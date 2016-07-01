package divider;

import checker.DeclChecker;
import checker.OffsetSymbolTable;
import checker.Type;
import checker.TypeChecker;
import exceptions.CompileError;
import exceptions.divider.ReachError;
import exceptions.generator.RegisterException;
import sprocl.model.Flag;
import generator.Generator;
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
 * Class that builds an Oplist-tree from a BoogyQ parse tree based on a divide-and-conquer- mechanism.
 */
public class Divider extends BoogyQBaseVisitor {

    private boolean globalDeclAllowed;
    private Map<String, Type> globalVars;
    public List<CompileError> exceptions;
    private static int junklines;
    private Tree<OpListWrapper> threadTree; //A tree with the hierarchies of threads.
    private static ParseTreeProperty<String> concurrent_identifiers;
    private static int concurrentblockCounter;
    public static ParseTreeProperty<Flag> flags;
    private Flag flag;

    /**
     * Symboltable used solely for global variables.
     */
    public static OffsetSymbolTable globalSymbolTable = new OffsetSymbolTable();


    private static void init(){
        junklines = 0;
        concurrent_identifiers = new ParseTreeProperty<>();
        concurrentblockCounter = 0;
    }

    /**
     * Creates a new Divider.
     */
    public Divider() {
        init();
    }

    /**
     * Generates a Tree of OpListWrappers from a program.
     * @param globalDeclAllowed Whether declarations of global variables are allowed in this scope.
     * @param parseTree The program.
     * @param globalVars The global variables already present.
     * @return A result of this generation.
     */
    public DividerResult generate(boolean globalDeclAllowed, ParseTree parseTree, Map<String, Type> globalVars) {
        return this.generate(globalDeclAllowed, parseTree, globalVars, new ParseTreeProperty<>(), Flag.mainFlag());
    }

    private DividerResult generate(boolean globalDeclAllowed, ParseTree parseTree, Map<String, Type> globalVars, ParseTreeProperty<Flag> flags, Flag mine){
        this.flag = mine;
        Divider.flags = flags;
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
            return new DividerResult(threadTree, exceptions, globalVars);
        }
        TypeChecker typeChecker = new TypeChecker();
        exceptions.addAll(typeChecker.check(parseTree, globalVars));
        if (!exceptions.isEmpty()) {
            return new DividerResult(threadTree, exceptions, globalVars);
        }
        try {
            OpListWrapper mainCode;
            if (!globalDeclAllowed) {
                mainCode = Generator.getInstance().generate(parseTree, flag);
            } else {
                mainCode = Generator.getInstance().generate(parseTree, flag);
            }
            threadTree.set(mainCode);
            return new DividerResult(threadTree, exceptions, globalVars);
        } catch (RegisterException e) {
            exceptions.add(new CompileError(e.getMessage(), 0));
        }
        return new DividerResult(threadTree, exceptions,  globalVars);
    }


    @Override @Deprecated
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

    @Override @Deprecated
    public Object visitDeclexpr(BoogyQParser.DeclexprContext ctx) {
        if(ctx.REACH()!=null && ctx.REACH().getText().equals("global")){
            if (globalDeclAllowed){
                globalVars.put(ctx.ID().getText(), TypeChecker.fromString(ctx.PRIMITIVE().getText()));
                globalSymbolTable.add(ctx.ID().getText(), true);
            } else {
                exceptions.add(new ReachError(ctx.getStart().getLine() - junklines));
            }
        }
        return null;
    }

    @Override @Deprecated
    public Object visitDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx) {
        if(ctx.REACH()!=null && ctx.REACH().getText().equals("global")){
            if (globalDeclAllowed){
                globalVars.put(ctx.ID().getText(), TypeChecker.fromString(ctx.type().getText()));
                globalSymbolTable.add(ctx.ID().getText(), true);
            } else {
                exceptions.add(new ReachError(ctx.getStart().getLine() - junklines));
            }
        }
        visit(ctx.flow());
        return null;
    }

    @Override @Deprecated
    public Object visitOpenscope(BoogyQParser.OpenscopeContext ctx) {
        junklines++;
        return null;
    }


    @Override @Deprecated
    public Object visitClosescope(BoogyQParser.ClosescopeContext ctx) {
        junklines++;
        return null;
    }
}
