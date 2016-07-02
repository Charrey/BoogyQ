package checker;

import exceptions.divider.DeclError;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.*;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Class that checks declaration use in BoogyQ.
 */
public class DeclChecker extends BoogyQBaseVisitor {

    /**
     * SymbolTable used to keep track of variable declarations.
     */
    private BasicSymbolTable<Object> decls;
    /**
     * Set of functions that have been declared.
     */
    private Set<String> functions = new HashSet<>();
    /**
     * List of errors gathered during checking.
     */
    private List<DeclError> errors;
    /**
     * How much the program line in preprocessed code differs from the un-preprocessed code.
     */
    private int junklines;


    /**
     * Checks a ParseTree of BoogyQ for declaration use.
     * @param input The Parse tree.
     * @param global Strings that are global variables.
     * @return A list of errors in this program.
     */
    public List<DeclError> check(ParseTree input, Set<String> global) {
        decls = new BasicSymbolTable<>();
        junklines = 0;
        errors = new LinkedList<>();
        for (String i : global) {
            decls.add(i, null);
        }
        input.accept(this);
        return errors;
    }

    /**
     * Checks whether no overly large number is in the code.
     * @param ctx Current node.
     * @return Nothing.
     */
    @Override @Deprecated
    public Object visitNumberexpr(BoogyQParser.NumberexprContext ctx) {
        BigInteger get = new BigInteger(ctx.NUMBER().getText());
        BigInteger intmax = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        if (get.compareTo(intmax)==1) {
            errors.add(new DeclError("Integer overflow", ctx.getStart().getLine() - junklines));
        }
        return null;
    }

    /**
     * Checks whether this declaration is allowed.
     * @param ctx Current node.
     * @return Nothing.
     */
    @Override @Deprecated
    public Object visitDeclexpr(BoogyQParser.DeclexprContext ctx) {
        if (!decls.add(ctx.ID().getText(), null)) {
            errors.add(new DeclError("Duplicate declaration of \"" + ctx.ID().getText() + "\"", ctx.getStart().getLine() - junklines));
        }
        return null;
    }

    /**
     * DeclChecker is limited to this (concurrent) scope.
     * @param ctx This node.
     * @return Nothing.
     */
    @Override @Deprecated
    public Object visitConcurrentstat(BoogyQParser.ConcurrentstatContext ctx) {
        return null;
    }

    /**
     * Checks whether this declaration is allowed.
     * @param ctx Current node.
     * @return Nothing.
     */
    @Override @Deprecated
    public Object visitDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx) {
        visit(ctx.flow());
        if (!decls.add(ctx.ID().getText(), null)) {
            errors.add(new DeclError("Duplicate declaration of \"" + ctx.ID().getText() + "\"", ctx.getStart().getLine() - junklines));
        }
        return null;
    }

    /**
     * Checks whether the function used here exists.
     * @param ctx Current node.
     * @return Nothing.
     */
    @Override @Deprecated
    public Object visitAssignfunctionflow(BoogyQParser.AssignfunctionflowContext ctx) {
        if (!functions.contains(ctx.ID().getText())) {
            errors.add(new DeclError("Unknown function " + ctx.ID().getText(), ctx.getStart().getLine() - junklines));
        }
        for (BoogyQParser.FlowContext i : ctx.flow()) {
            visit(i);
        }
        return null;
    }

    /**
     * Checks whether this variable has been declared.
     * @param ctx Current node.
     * @return Nothing.
     */
    @Override @Deprecated
    public Object visitIdenexpr(BoogyQParser.IdenexprContext ctx) {
        if (!decls.contains(ctx.ID().getText())) {
            errors.add(new DeclError("Unknown variable " + ctx.ID().getText(), ctx.getStart().getLine()-junklines));
        }
        return null;
    }

    /**
     * Checks whether the variable here has been declared.
     * @param ctx Current node.
     * @return Nothing.
     */
    @Override @Deprecated
    public Object visitAssignstandardflow(BoogyQParser.AssignstandardflowContext ctx) {
        visit(ctx.flow());
        if (!decls.contains(ctx.ID().getText())) {
            errors.add(new DeclError("Unknown variable " + ctx.ID().getText(), ctx.getStart().getLine()-junklines));
        }
        return null;
    }


    /**
     * Checks whether the function declaration is allowed, and Decl-checks the function content.
     * @param ctx Current scope.
     * @return Nothing.
     */
    @Override @Deprecated
    public Object visitFunctiondecl(BoogyQParser.FunctiondeclContext ctx) {
        decls.openScope();
        int size = functions.size();
        functions.add(ctx.ID().getText());
        if (functions.size() == size) {
            errors.add(new DeclError("Duplicate function "+ ctx.ID().getText(), ctx.getStart().getLine() - junklines));
        }
        visit(ctx.functionvars());
        visit(ctx.openscope());
        for (BoogyQParser.StatementContext i : ctx.statement()) {
            visit(i);
        }
        visit(ctx.closescope());
        return null;
    }

    @Override @Deprecated
    public Object visitFunctionvars(BoogyQParser.FunctionvarsContext ctx) {
        for (TerminalNode i : ctx.ID()) {
            decls.add(i.getText(), null);
        }
        return null;
    }

    @Override @Deprecated
    public Object visitOpenscope(BoogyQParser.OpenscopeContext ctx) {
        decls.openScope();
        junklines++;
        return null;
    }

    @Override @Deprecated
    public Object visitClosescope(BoogyQParser.ClosescopeContext ctx) {
        decls.closeScope();
        junklines++;
        return null;
    }
}
