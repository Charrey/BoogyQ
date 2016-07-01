package checker;

import exceptions.divider.JumpError;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that checks jump use in BoogyQ.
 */
public class JumpChecker extends BoogyQBaseVisitor {

    private int depth;
    private LinkedList<JumpError> errors;
    private int junklines;

    /**
     * Checks a Parse Tree of BoogyQ for jump errors.
     * @param input The parse tree.
     * @return A list of jump errors.
     */
    public List<JumpError> check(ParseTree input) {
        depth = 0;
        errors = new LinkedList<>();
        junklines = 0;
        input.accept(this);
        return errors;
    }

    @Override @Deprecated
    public Object visitOpenscope(BoogyQParser.OpenscopeContext ctx) {
        depth++;
        junklines++;
        return null;
    }

    @Override @Deprecated
    public Object visitClosescope(BoogyQParser.ClosescopeContext ctx) {
        depth--;
        junklines++;
        return null;
    }

    @Override @Deprecated
    public Object visitLoopstat(BoogyQParser.LoopstatContext ctx) {
        int get = Integer.parseInt(ctx.NUMBER().getText());
        if (get < 0 || get >= depth) {
            errors.add(new JumpError("Invalid loop statement!", ctx.getStart().getLine() - junklines));
        }
        return null;
    }



    @Override @Deprecated
    public Object visitConcurrentstat(BoogyQParser.ConcurrentstatContext ctx) {
        return null;
    }

    @Override @Deprecated
    public Object visitBreakstat(BoogyQParser.BreakstatContext ctx) {
        int get = Integer.parseInt(ctx.NUMBER().getText());
        if (get < 0 || get >= depth) {
            errors.add(new JumpError("Invalid break statement!", ctx.getStart().getLine() - junklines));
        }
        return null;
    }
}
