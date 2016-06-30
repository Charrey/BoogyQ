package divider;

import checker.DeclChecker;
import checker.OffsetSymbolTable;
import checker.Type;
import checker.TypeChecker;
import exceptions.CompileException;
import exceptions.divider.ReachException;
import exceptions.generator.RegisterException;
import sprocl.model.Flag;
import generator.Generator;
import generator.GeneratorResult;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import parser.BoogyQBaseVisitor;
import parser.BoogyQParser;
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
    public static ParseTreeProperty<Flag> flags;
    private Flag flag;

    public static OffsetSymbolTable globalSymbolTable = new OffsetSymbolTable();


    public static int globalVarscount = -1;

    public static void init(){
        junklines = 0;
        concurrent_identifiers = new ParseTreeProperty<>();
        concurrentblockCounter = 0;
    }
    public DividerResult generate(boolean globalDeclAllowed, ParseTree parseTree, Map<String, Type> globalVars) {
        return this.generate(globalDeclAllowed, parseTree, globalVars, new ParseTreeProperty<>(), Flag.mainFlag());
    }

    public DividerResult generate(boolean globalDeclAllowed, ParseTree parseTree, Map<String, Type> globalVars, ParseTreeProperty<Flag> flags, Flag mine){
        this.flag = mine;
        this.flags = flags;
        this.globalDeclAllowed = globalDeclAllowed;
        this.globalVars = globalVars;
        this.exceptions = new LinkedList<>();
        threadTree = new Tree<>();

        flags = new ParseTreeProperty<>();

        parseTree.accept(this);
        globalVarscount = globalVars.size();

        DeclChecker declChecker = new DeclChecker();

        //If this is the main code, declarations are allowed.
        if (!globalDeclAllowed) {
            exceptions.addAll(declChecker.check(parseTree, globalVars.keySet()));
        } else {
            exceptions.addAll(declChecker.check(parseTree, new HashSet<>()));
        }
        if (!exceptions.isEmpty()) {
            return new DividerResult(threadTree, exceptions, null, globalVars);
        }
        TypeChecker typeChecker = new TypeChecker();
        exceptions.addAll(typeChecker.check(parseTree, globalVars));
        if (!exceptions.isEmpty()) {
            return new DividerResult(threadTree, exceptions, null, globalVars);
        }
        try {
            GeneratorResult mainCode;
            if (!globalDeclAllowed) {
                mainCode = Generator.getInstance().generate(parseTree, flag);
            } else {
                mainCode = Generator.getInstance().generate(parseTree, flag);
            }
            threadTree.set(mainCode.getResult());
            return new DividerResult(threadTree, exceptions, mainCode.getSymbolTable(), globalVars);
        } catch (RegisterException e) {
            exceptions.add(new CompileException(e.getMessage(), 0));
        }
        return new DividerResult(threadTree, exceptions, null, globalVars);
    }


    @Override
    public Object visitConcurrentstat(BoogyQParser.ConcurrentstatContext ctx) {
        Flag yourFlag = new Flag();
        flags.put(ctx, yourFlag);

        concurrent_identifiers.put(ctx, "_ConcurrentBlockID" + concurrentblockCounter++);
        BoogyQParser.ProgramContext a = new BoogyQParser.ProgramContext(null, -1);
        for (int i = 0; i<ctx.statement().size(); i++) {
            a.addChild(ctx.statement(i));
        }
        flags.put(a, yourFlag);
        globalVars.put(concurrent_identifiers.get(ctx), null);
        DividerResult dividerResult = new Divider().generate(false, a, globalVars, flags, yourFlag);
        threadTree.addChild(dividerResult.getThreadTree());
        exceptions.addAll(dividerResult.getErrors());
        return null;
    }

    @Override
    public Object visitDeclexpr(BoogyQParser.DeclexprContext ctx) {
        if(ctx.REACH()!=null && ctx.REACH().getText().equals("global")){
            if (globalDeclAllowed){
                globalVars.put(ctx.ID().getText(), TypeChecker.fromString(ctx.PRIMITIVE().getText()));
                globalSymbolTable.add(ctx.ID().getText(), true);
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
                globalSymbolTable.add(ctx.ID().getText(), true);
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
