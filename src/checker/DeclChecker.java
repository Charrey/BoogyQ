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

public class DeclChecker extends BoogyQBaseVisitor {

    private BasicSymbolTable<Integer> decls = new BasicSymbolTable<>();
    private Set<String> functions = new HashSet<>();

    private List<DeclException> errors;
    private int junklines;
    

    public List<DeclException> check(ParseTree input, Set<String> global) {
        decls = new BasicSymbolTable<>();
        junklines = 0;
        errors = new LinkedList<>();
        for (String i : global) {
            decls.add(i, 0);
        }

        input.accept(this);
        return errors;
    }

    @Override
    public Object visitNumberexpr(BoogyQParser.NumberexprContext ctx) {
        BigInteger get = new BigInteger(ctx.NUMBER().getText());
        BigInteger intmax = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        if (get.compareTo(intmax)==1) {
            errors.add(new DeclException("Integer overflow", ctx.getStart().getLine() - junklines));
        }
        return null;
    }

    @Override
    public Object visitDeclexpr(BoogyQParser.DeclexprContext ctx) {
        if (!decls.add(ctx.ID().getText(), 0)) {
            errors.add(new DeclException("Duplicate declaration of \"" + ctx.ID().getText() + "\"", ctx.getStart().getLine() - junklines));
        }
        return null;
    }

    @Override
    public Object visitConcurrentstat(BoogyQParser.ConcurrentstatContext ctx) {
        return null;
    }

    @Override
    public Object visitDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx) {
        visit(ctx.flow());
        if (!decls.add(ctx.ID().getText(), 0)) {
            errors.add(new DeclException("Duplicate declaration of \"" + ctx.ID().getText() + "\"", ctx.getStart().getLine() - junklines));
        }
        return null;
    }

    @Override
    public Object visitAssignfunctionflow(BoogyQParser.AssignfunctionflowContext ctx) {
        if (!functions.contains(ctx.ID().getText())) {
            errors.add(new DeclException("Unknown function " + ctx.ID().getText(), ctx.getStart().getLine() - junklines));
        }
        for (BoogyQParser.FlowContext i : ctx.flow()) {
            visit(i);
        }
        return null;
    }

    @Override
    public Object visitIdenexpr(BoogyQParser.IdenexprContext ctx) {
        if (!decls.contains(ctx.ID().getText())) {
            errors.add(new DeclException("Unknown variable " + ctx.ID().getText(), ctx.getStart().getLine()-junklines));
        }
        return null;
    }


    @Override
    public Object visitAssignstandardflow(BoogyQParser.AssignstandardflowContext ctx) {
        visit(ctx.flow());
        if (!decls.contains(ctx.ID().getText())) {
            errors.add(new DeclException("Unknown variable " + ctx.ID().getText(), ctx.getStart().getLine()-junklines));
        }
        return null;
    }


    @Override
    public Object visitFunctiondecl(BoogyQParser.FunctiondeclContext ctx) {
        decls.openScope();
        int size = functions.size();
        functions.add(ctx.ID().getText());
        if (functions.size() == size) {
            errors.add(new DeclException("Duplicate function "+ ctx.ID().getText(), ctx.getStart().getLine() - junklines));
        }

        visit(ctx.functionvars());
        visit(ctx.openscope());
        for (BoogyQParser.StatementContext i : ctx.statement()) {
            visit(i);
        }
        visit(ctx.closescope());

        return null;
    }

    @Override
    public Object visitFunctionvars(BoogyQParser.FunctionvarsContext ctx) {
        for (TerminalNode i : ctx.ID()) {
            decls.add(i.getText(), 0);
        }
        return null;
    }

    @Override
    public Object visitOpenscope(BoogyQParser.OpenscopeContext ctx) {
        decls.openScope();
        junklines++;
        return null;
    }

    @Override
    public Object visitClosescope(BoogyQParser.ClosescopeContext ctx) {
        decls.closeScope();
        junklines++;
        return null;
    }
}
