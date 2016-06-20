package checking;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.BoogyQBaseListener;
import parser.BoogyQParser;

import java.util.LinkedList;
import java.util.List;

public class DeclChecker extends BoogyQBaseListener {

    private SymbolTable<Integer> decls = new BasicSymbolTable<Integer>();
    private List<String> errors;

    public List<String> check(ParseTree input) {
        decls = new BasicSymbolTable<Integer>();
        errors = new LinkedList<>();
        new ParseTreeWalker().walk(this, input);
        return errors;
    }

    @Override
    public void enterDeclexpr(BoogyQParser.DeclexprContext ctx) {
        if (!decls.add(ctx.ID().getText(), 0)) {
            errors.add("Duplicate declaration of \"" + ctx.ID().getText() + "\"");
        }
    }

    @Override
    public void enterDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx) {
        if (!decls.add(ctx.ID().getText(), 0)) {
            errors.add("Duplicate declaration of \"" + ctx.ID().getText() + "\"");
        }
    }

    @Override
    public void enterDeclfunctionflow(BoogyQParser.DeclfunctionflowContext ctx) {
        if (!decls.add(ctx.ID().getText(), 0)) {
            errors.add("Duplicate declaration of \"" + ctx.ID().getText() + "\"");
        }
    }

    @Override
    public void enterAssignfunctionflow(BoogyQParser.AssignfunctionflowContext ctx) {
        if (!decls.contains(ctx.ID().getText())) {
            errors.add("Unknown variable " + ctx.ID().getText());
        }
    }

    @Override
    public void enterAssignstandardflow(BoogyQParser.AssignstandardflowContext ctx) {
        if (!decls.contains(ctx.ID().getText())) {
            errors.add("Unknown variable " + ctx.ID().getText());
        }
    }

    @Override
    public void enterDeclgeneratorflow(BoogyQParser.DeclgeneratorflowContext ctx) {
        if (!decls.add(ctx.ID().getText(), 0)) {
            errors.add("Duplicate declaration of \"" + ctx.ID().getText() + "\"");
        }
    }

    @Override
    public void enterOpenscope(BoogyQParser.OpenscopeContext ctx) {
        decls.openScope();
    }

    @Override
    public void enterClosescope(BoogyQParser.ClosescopeContext ctx) {
        decls.closeScope();
    }
}
