package checking;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.BoogyQBaseListener;
import parser.BoogyQParser;

import java.util.LinkedList;
import java.util.List;

public class JumpChecker extends BoogyQBaseListener {

    private int depth;
    private LinkedList<String> errors;

    public List<String> check(ParseTree input) {
        depth = 0;
        errors = new LinkedList<>();
        new ParseTreeWalker().walk(this, input);
        return errors;
    }

    @Override
    public void enterOpenscope(BoogyQParser.OpenscopeContext ctx) {
        depth++;
    }

    @Override
    public void enterClosescope(BoogyQParser.ClosescopeContext ctx) {
        depth--;
    }

    @Override
    public void enterLoopstat(BoogyQParser.LoopstatContext ctx) {
        int get = Integer.parseInt(ctx.NUMBER().getText());
        if (get < 0 || get >= depth) {
            errors.add("Invalid loop statement!");
        }
    }

    @Override
    public void enterBreakstat(BoogyQParser.BreakstatContext ctx) {
        int get = Integer.parseInt(ctx.NUMBER().getText());
        if (get < 0 || get >= depth) {
            errors.add("Invalid break statement!");
        }
    }
}
