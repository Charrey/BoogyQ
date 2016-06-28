package divider;

import checker.DeclChecker;
import checker.Type;
import checker.TypeChecker;
import exceptions.CompileException;
import exceptions.divider.ReachException;
import exceptions.generator.RegisterException;
import generator.Generator;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.BoogyQBaseListener;
import parser.BoogyQParser;
import sprocl.model.Op;
import toplevel.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Hans on 27-6-2016.
 */
public class Divider extends BoogyQBaseListener{

    boolean globalDeclAllowed;
    private Map<String, Type> globalVars;
    public List<CompileException> exceptions;
    private int junklines;
    public Tree<List<Op>> threadTree; //A tree with the hierarchies of threads.

    public DividerResult generate(boolean globalDeclAllowed, ParseTree parseTree, Map<String, Type> globalVars){
        this.globalDeclAllowed = globalDeclAllowed;
        this.globalVars = globalVars;
        this.exceptions = new LinkedList<>();
        threadTree = new Tree<>();

        new ParseTreeWalker().walk(this,parseTree);

        DeclChecker declChecker = new DeclChecker();
        exceptions.addAll(declChecker.check(parseTree));
        if (!exceptions.isEmpty()) {
            return new DividerResult(threadTree, exceptions);
        }

        TypeChecker typeChecker = new TypeChecker();
        exceptions.addAll(typeChecker.check(parseTree));
        if (!exceptions.isEmpty()) {
            return new DividerResult(threadTree, exceptions);
        }

        List<Op> mainCode = null;
        try {
            mainCode = Generator.getInstance().generate(parseTree);
            threadTree.set(mainCode);
        } catch (RegisterException e) {
            exceptions.add(new CompileException(e.getMessage(), 0));
        }
        return new DividerResult(threadTree, exceptions);
    }

    @Override
    public void enterConcurrentstat(BoogyQParser.ConcurrentstatContext ctx) {
        DividerResult dividerResult = new Divider().generate(false, ctx, globalVars);
        threadTree.addChild(dividerResult.getThreadTree());
        exceptions.addAll(dividerResult.getErrors());
    }

    @Override
    public void enterDeclexpr(BoogyQParser.DeclexprContext ctx) {
        if(ctx.REACH().getText().equals("global")){
            if (globalDeclAllowed){
                globalVars.put(ctx.ID().getText(), TypeChecker.fromString(ctx.PRIMITIVE().getText()));
            } else {
                exceptions.add(new ReachException(ctx.getStart().getLine() - junklines));
            }
        }
    }

    @Override
    public void enterDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx)  {
        if(ctx.REACH()!=null && ctx.REACH().getText().equals("global")){
            if (globalDeclAllowed){
                globalVars.put(ctx.ID().getText(), TypeChecker.fromString(ctx.type().getText()));
            } else {
                exceptions.add(new ReachException(ctx.getStart().getLine() - junklines));
            }
        }
    }

    @Override
    public void enterOpenscope(BoogyQParser.OpenscopeContext ctx) {
        junklines++;
    }

    @Override
    public void enterClosescope(BoogyQParser.ClosescopeContext ctx) {
        junklines++;
    }
}
