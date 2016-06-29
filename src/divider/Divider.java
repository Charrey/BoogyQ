package divider;

import checker.DeclChecker;
import checker.OffsetSymbolTable;
import checker.Type;
import checker.TypeChecker;
import exceptions.CompileException;
import exceptions.divider.ReachException;
import exceptions.generator.RegisterException;
import generator.Generator;
import javafx.util.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import parser.BoogyQBaseVisitor;
import parser.BoogyQParser;
import sprocl.model.Num;
import sprocl.model.Op;
import sprocl.model.OpCode;
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

    private boolean globalDeclAllowed;
    private Map<String, Type> globalVars;
    public List<CompileException> exceptions;
    private static int junklines;
    private Tree<OpListWrapper> threadTree; //A tree with the hierarchies of threads.
    private static ParseTreeProperty<String> concurrent_identifiers = new ParseTreeProperty<>();
    private static int concurrentblockCounter = 0;

    public static void init(){
        junklines = 0;
        concurrent_identifiers = new ParseTreeProperty<>();
        concurrentblockCounter = 0;
    }
    public Pair<DividerResult, OffsetSymbolTable> generate(boolean globalDeclAllowed, ParseTree parseTree, Map<String, Type> globalVars){
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
            return new Pair<>(new DividerResult(threadTree, exceptions), null);
        }
        TypeChecker typeChecker = new TypeChecker();
        exceptions.addAll(typeChecker.check(parseTree, globalVars));
        if (!exceptions.isEmpty()) {
            return new Pair<>(new DividerResult(threadTree, exceptions), null);
        }
        try {
            Pair<OpListWrapper, OffsetSymbolTable> mainCode;

            if (!globalDeclAllowed) {
                mainCode = Generator.getInstance().generate(parseTree, globalVars.keySet(), false);
            } else {
                mainCode = Generator.getInstance().generate(parseTree, new HashSet<>(), true);
                for (OpListWrapper i : threadTree.toSetChildren()) {
                    mainCode.getKey().getOps().add(new Op(OpCode.loadCONST, new Num(-1), Generator.getInstance().r_standard0));
                    mainCode.getKey().getOps().add(new Op(OpCode.writeDIRA, Generator.getInstance().r_standard0, new Num(i.getMemLocation())));
                }
                mainCode.getKey().getOps().add(new Op(OpCode.readDIRA, new Num(0)));
                mainCode.getKey().getOps().add(new Op(OpCode.receive, Generator.getInstance().r_standard0));
            }
            threadTree.set(mainCode.getKey());
            return new Pair<>(new DividerResult(threadTree, exceptions), mainCode.getValue());
        } catch (RegisterException e) {
            exceptions.add(new CompileException(e.getMessage(), 0));
        }
        return new Pair<>(new DividerResult(threadTree, exceptions), null);
    }


    @Override
    public Object visitConcurrentstat(BoogyQParser.ConcurrentstatContext ctx) {
        concurrent_identifiers.put(ctx, "_ConcurrentBlockID" + concurrentblockCounter++);
        BoogyQParser.ProgramContext a = new BoogyQParser.ProgramContext(null, -1);
        for (int i = 0; i<ctx.statement().size(); i++) {
            a.addChild(ctx.statement(i));
        }
        globalVars.put(concurrent_identifiers.get(ctx), null);
        Pair<DividerResult, OffsetSymbolTable> dividerResult = new Divider().generate(false, a, globalVars);
        threadTree.addChild(dividerResult.getKey().getThreadTree());
        dividerResult.getKey().getThreadTree().get().setMemLocation(dividerResult.getValue().get(concurrent_identifiers.get(ctx)).getKey());
        exceptions.addAll(dividerResult.getKey().getErrors());
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

    public static ParseTreeProperty<String> getConcurrent_identifiers() {
        return concurrent_identifiers;
    }
}
