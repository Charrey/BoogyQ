package checker;

import exceptions.divider.JumpException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.*;

import java.util.LinkedList;
import java.util.List;

public class JumpChecker extends BoogyQBaseVisitor {

    private int depth;
    private LinkedList<JumpException> errors;
    private int junklines;

    public List<JumpException> check(ParseTree input) {
        depth = 0;
        errors = new LinkedList<>();
        junklines = 0;
        input.accept(this);
        return errors;
    }

    @Override
    public Object visitOpenscope(BoogyQParser.OpenscopeContext ctx) {
        depth++;
        junklines++;
        return null;
    }

    @Override
    public Object visitClosescope(BoogyQParser.ClosescopeContext ctx) {
        depth--;
        junklines++;
        return null;
    }

    @Override
    public Object visitLoopstat(BoogyQParser.LoopstatContext ctx) {
        int get = Integer.parseInt(ctx.NUMBER().getText());
        if (get < 0 || get >= depth) {
            errors.add(new JumpException("Invalid loop statement!", ctx.getStart().getLine() - junklines));
        }
        return null;
    }



    @Override
    public Object visitConcurrentstat(BoogyQParser.ConcurrentstatContext ctx) {
        return null;
    }

    @Override
    public Object visitBreakstat(BoogyQParser.BreakstatContext ctx) {
        int get = Integer.parseInt(ctx.NUMBER().getText());
        if (get < 0 || get >= depth) {
            errors.add(new JumpException("Invalid break statement!", ctx.getStart().getLine() - junklines));
        }
        return null;
    }
}
