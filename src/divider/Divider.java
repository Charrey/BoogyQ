package divider;

import checker.DeclChecker;
import checker.Type;
import checker.TypeChecker;
import exceptions.CompileException;
import exceptions.divider.ReachException;
import exceptions.generator.RegisterException;
import generator.Generator;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.BoogyQBaseListener;
import parser.BoogyQBaseVisitor;
import parser.BoogyQParser;
import sprocl.model.Op;
import toplevel.OpListWrapper;
import toplevel.Tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Hans on 27-6-2016.
 */
public class Divider extends BoogyQBaseVisitor {

    boolean globalDeclAllowed;
    private Map<String, Type> globalVars;
    public List<CompileException> exceptions;
    private static int junklines;
    public Tree<OpListWrapper> threadTree; //A tree with the hierarchies of threads.
    private static ParseTreeProperty<String> concurrentPTP = new ParseTreeProperty<>();
    private static int concurrentblockCounter = 0;

    public static void init(){
        junklines = 0;
        concurrentPTP = new ParseTreeProperty<>();
        concurrentblockCounter = 0;
    }
    public DividerResult generate(boolean globalDeclAllowed, ParseTree parseTree, Map<String, Type> globalVars){
        this.globalDeclAllowed = globalDeclAllowed;
        this.globalVars = globalVars;
        this.exceptions = new LinkedList<>();
        threadTree = new Tree<>();

        parseTree.accept(this);

        DeclChecker declChecker = new DeclChecker();

        //If this is the main code, declarations are allowed.
        if (!globalDeclAllowed) {
            exceptions.addAll(declChecker.check(parseTree, globalVars.keySet()));
        } else {
            exceptions.addAll(declChecker.check(parseTree, new HashSet<>()));
        }



        if (!exceptions.isEmpty()) {
            return new DividerResult(threadTree, exceptions);
        }

        TypeChecker typeChecker = new TypeChecker();
        exceptions.addAll(typeChecker.check(parseTree, globalVars));
        if (!exceptions.isEmpty()) {
            return new DividerResult(threadTree, exceptions);
        }

        OpListWrapper mainCode = null;
        try {
            if (!globalDeclAllowed) {
                mainCode = Generator.getInstance().generate(parseTree, globalVars.keySet());
                threadTree.set(mainCode);
            } else {
                mainCode = Generator.getInstance().generate(parseTree, new HashSet<>());
                threadTree.set(mainCode);
            }
        } catch (RegisterException e) {
            exceptions.add(new CompileException(e.getMessage(), 0));
        }
        return new DividerResult(threadTree, exceptions);
    }


    @Override
    public Object visitConcurrentstat(BoogyQParser.ConcurrentstatContext ctx) {
        concurrentPTP.put(ctx, "_ConcurrentBlockID" + concurrentblockCounter++);
        BoogyQParser.ProgramContext a = new BoogyQParser.ProgramContext(null, -1);
        for (int i = 0; i<ctx.statement().size(); i++) {
            a.addChild(ctx.statement(i));
        }

        DividerResult dividerResult = new Divider().generate(false, a, globalVars);
        threadTree.addChild(dividerResult.getThreadTree());
        exceptions.addAll(dividerResult.getErrors());
        return null;
    }

    @Override
    public Object visitDeclexpr(BoogyQParser.DeclexprContext ctx) {
        if(ctx.REACH()!=null && ctx.REACH().getText().equals("global")){
            if (globalDeclAllowed){
                globalVars.put(ctx.ID().getText(), TypeChecker.fromString(ctx.PRIMITIVE().getText()));
            } else {
                exceptions.add(new ReachException(ctx.getStart().getLine() - junklines));
            }
        }
        return null;
    }

    @Override
    public Object visitDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx) {
        if(ctx.REACH()!=null && ctx.REACH().getText().equals("global")){
            if (globalDeclAllowed){
                globalVars.put(ctx.ID().getText(), TypeChecker.fromString(ctx.type().getText()));
            } else {
                exceptions.add(new ReachException(ctx.getStart().getLine() - junklines));
            }
        }
        visit(ctx.flow());
        return null;
    }

    @Override
    public Object visitOpenscope(BoogyQParser.OpenscopeContext ctx) {
        junklines++;
        return null;
    }


    @Override
    public Object visitClosescope(BoogyQParser.ClosescopeContext ctx) {
        junklines++;
        return null;
    }

    public static ParseTreeProperty<String> getConcurrentPTP() {
        return concurrentPTP;
    }
}
