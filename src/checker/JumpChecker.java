package checker;

import exceptions.divider.JumpException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.*;

import java.util.LinkedList;
import java.util.List;

public class JumpChecker extends BoogyQBaseListener {

    private int depth;
    private LinkedList<JumpException> errors;
    private int junklines;

    public List<JumpException> check(ParseTree input) {
        depth = 0;
        errors = new LinkedList<>();
        junklines = 0;
        new ParseTreeWalker().walk(this, input);
        return errors;
    }

    @Override
    public void enterOpenscope(BoogyQParser.OpenscopeContext ctx) {
        depth++;
        junklines++;
    }

    @Override
    public void enterClosescope(BoogyQParser.ClosescopeContext ctx) {
        depth--;
        junklines++;
    }

    @Override
    public void enterLoopstat(BoogyQParser.LoopstatContext ctx) {
        int get = Integer.parseInt(ctx.NUMBER().getText());
        if (get < 0 || get >= depth) {
            errors.add(new JumpException("Invalid loop statement!", ctx.getStart().getLine() - junklines));
        }
    }

    @Override
    public void enterConcurrentstat(BoogyQParser.ConcurrentstatContext ctx) {
        throw new IllegalStateException("This should not happen; should be filtered out by divider.");
    }

    @Override
    public void enterBreakstat(BoogyQParser.BreakstatContext ctx) {
        int get = Integer.parseInt(ctx.NUMBER().getText());
        if (get < 0 || get >= depth) {
            errors.add(new JumpException("Invalid break statement!", ctx.getStart().getLine() - junklines));
        }
    }
}
