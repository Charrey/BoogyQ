package checker;

import exceptions.CompileException;
import exceptions.divider.DeclException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.*;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DeclChecker extends BoogyQBaseListener {

    private BasicSymbolTable<Integer> decls = new BasicSymbolTable<>();
    private Set<String> functions = new HashSet<>();

    private List<DeclException> errors;
    private int junklines;
    

    public List<DeclException> check(ParseTree input) {
        decls = new BasicSymbolTable<>();
        junklines = 0;
        errors = new LinkedList<>();
        new ParseTreeWalker().walk(this, input);
        return errors;
    }

    @Override
    public void exitNumberexpr(BoogyQParser.NumberexprContext ctx) {
        BigInteger get = new BigInteger(ctx.NUMBER().getText());
        BigInteger intmax = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        if (get.compareTo(intmax)==1) {
            errors.add(new DeclException("Integer overflow", ctx.getStart().getLine() - junklines));
        }
    }

    @Override
    public void enterDeclexpr(BoogyQParser.DeclexprContext ctx) {
        if (!decls.add(ctx.ID().getText(), 0)) {
            errors.add(new DeclException("Duplicate declaration of \"" + ctx.ID().getText() + "\"", ctx.getStart().getLine() - junklines));
        }
    }

    @Override
    public void exitDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx) {
        if (!decls.add(ctx.ID().getText(), 0)) {
            errors.add(new DeclException("Duplicate declaration of \"" + ctx.ID().getText() + "\"", ctx.getStart().getLine() - junklines));
        }
    }

    @Override
    public void enterAssignfunctionflow(BoogyQParser.AssignfunctionflowContext ctx) {
        if (!functions.contains(ctx.ID().getText())) {
            errors.add(new DeclException("Unknown function " + ctx.ID().getText(), ctx.getStart().getLine() - junklines));
        }
    }

    @Override
    public void enterIdenexpr(BoogyQParser.IdenexprContext ctx) {
        if (!decls.contains(ctx.ID().getText())) {
            errors.add(new DeclException("Unknown variable " + ctx.ID().getText(), ctx.getStart().getLine()-junklines));
        }
    }

    @Override
    public void exitAssignstandardflow(BoogyQParser.AssignstandardflowContext ctx) {
        if (!decls.contains(ctx.ID().getText())) {
            errors.add(new DeclException("Unknown variable " + ctx.ID().getText(), ctx.getStart().getLine()-junklines));
        }
    }

    @Override
    public void enterFunctiondecl(BoogyQParser.FunctiondeclContext ctx) {
        decls.openScope();
        int size = functions.size();
        functions.add(ctx.ID().getText());
        if (functions.size() == size) {
            errors.add(new DeclException("Duplicate function "+ ctx.ID().getText(), ctx.getStart().getLine() - junklines));
        }
    }

    @Override
    public void enterFunctionvars(BoogyQParser.FunctionvarsContext ctx) {
        for (TerminalNode i : ctx.ID()) {
            decls.add(i.getText(), 0);
        }
    }

    @Override
    public void exitFunctiondecl(BoogyQParser.FunctiondeclContext ctx) {
        decls.closeScope();
    }


    @Override
    public void enterOpenscope(BoogyQParser.OpenscopeContext ctx) {
        decls.openScope();
        junklines++;
    }

    @Override
    public void enterClosescope(BoogyQParser.ClosescopeContext ctx) {
        decls.closeScope();
        junklines++;
    }
}
