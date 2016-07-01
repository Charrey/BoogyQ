package checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import parser.*;

/**
 * Class used to determine register use of a parse tree.
 */
public class RegisterCounter extends BoogyQBaseVisitor<Integer> {

    /**
     * Returns how many registers a program in BoogyQ needs.
     * @param input The BoogyQ program in the form of a parse tree.
     * @return The minimum number of registers needed.
     */
    public int check(ParseTree input) {
        return input.accept(this);
    }

    /**
     * ParseTreeProperty which saves the number of needed registers per node.
     */
    public ParseTreeProperty<Integer> regcount = new ParseTreeProperty<>();


    @Override @Deprecated
    public Integer visitProgram(BoogyQParser.ProgramContext ctx) {
        int max = 0;
        for (BoogyQParser.StatementContext i : ctx.statement()) {
            int regcount = visit(i);
                max = Math.max(max, regcount);
        }
        regcount.put(ctx, max+3);
        return max + 3;
        //max + r_standard + r_arp + r_load
    }


    /**
     * Returns how many registers a Boolexpr needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitBoolexpr(BoogyQParser.BoolexprContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    /**
     * Returns how many registers a comment needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitBarecomment(BoogyQParser.BarecommentContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    /**
     * Returns how many registers a Timesexpr needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitTimesexpr(BoogyQParser.TimesexprContext ctx) {
        regcount.put(ctx, Math.max(2,Math.max(visit(ctx.expr(0)), visit(ctx.expr(1)))));
        return regcount.get(ctx);
    }

    /**
     * Returns how many registers a Powerexpr needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitPowerexpr(BoogyQParser.PowerexprContext ctx) {
        regcount.put(ctx, Math.max(3,Math.max(visit(ctx.expr(0)), visit(ctx.expr(1)))));
        return regcount.get(ctx);
    }


    /**
     * Returns how many registers a Plusexpr needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitPlusexpr(BoogyQParser.PlusexprContext ctx) {
        regcount.put(ctx, Math.max(2,Math.max(visit(ctx.expr(0)), visit(ctx.expr(1)))));
        return regcount.get(ctx);
    }

    /**
     * Returns how many registers an Openscope needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitOpenscope(BoogyQParser.OpenscopeContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    /**
     * Returns how many registers a Notexpr needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitNotexpr(BoogyQParser.NotexprContext ctx) {
        regcount.put(ctx,visit(ctx.expr()));
        return regcount.get(ctx);
    }

    /**
     * Returns how many registers a Numberexpr needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitNumberexpr(BoogyQParser.NumberexprContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    /**
     * Returns how many registers a Minusexpr needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitMinusexpr(BoogyQParser.MinusexprContext ctx) {
        regcount.put(ctx, visit(ctx.expr()));
        return regcount.get(ctx);
    }

    /**
     * Returns how many registers a Loopstat needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitLoopstat(BoogyQParser.LoopstatContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    /**
     * Returns how many registers a (//TODO) needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitIgnoreme(BoogyQParser.IgnoremeContext ctx) {
        regcount.put(ctx, Math.max(1, visit(ctx.expr())));
        return regcount.get(ctx);
    }

    /**
     * Returns how many registers an Idenexpr needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitIdenexpr(BoogyQParser.IdenexprContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    /**
     * Returns how many registers a Flowexpr needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitFlowexpr(BoogyQParser.FlowexprContext ctx) {
        regcount.put(ctx, visit(ctx.flow()));
        return regcount.get(ctx);
    }

    /**
     * Returns how many registers a Comparatorexpr needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitComparatorexpr(BoogyQParser.ComparatorexprContext ctx) {
        regcount.put(ctx, Math.max(2,Math.max(visit(ctx.expr(0)), visit(ctx.expr(1)))));
        return regcount.get(ctx);
    }

    /**
     * Returns how many registers an If-statement needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitIfstat(BoogyQParser.IfstatContext ctx) {
        int condition = visit(ctx.expr());
        int max = 0;
        for (BoogyQParser.StatementContext st : ctx.statement()) {
            max = Math.max(max, visit(st));
        }
        regcount.put(ctx, Math.max(condition, max) + 1);
        return regcount.get(ctx);
    }

    /**
     * Returns how many registers the type of a function needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitFunctionvars(BoogyQParser.FunctionvarsContext ctx) {
        regcount.put(ctx, 1);
        return 1;
    }

    /**
     * Returns how many registers a function needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitFunctiondecl(BoogyQParser.FunctiondeclContext ctx) {
        int functionvars  = visit(ctx.functionvars());
        int max = 0;
        for (BoogyQParser.StatementContext st : ctx.statement()) {
            max = Math.max(max, visit(st));
        }
        regcount.put(ctx, Math.max(functionvars, max));
        return regcount.get(ctx);
    }

    /**
     * Returns how many registers a Flowstat needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitFlowstat(BoogyQParser.FlowstatContext ctx) {
        regcount.put(ctx, visit(ctx.flow()));
        return regcount.get(ctx);
    }


    /**
     * Returns how many registers a Declstandardflow needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx) {
        regcount.put(ctx, visit(ctx.flow()));
        return regcount.get(ctx);
    }

    /**
     * Returns how many registers a Declexpr needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitDeclexpr(BoogyQParser.DeclexprContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    /**
     * Returns how many registers a Concurrentstat needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitConcurrentstat(BoogyQParser.ConcurrentstatContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    /**
     * Returns how many registers a Commentstat needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitCommentstat(BoogyQParser.CommentstatContext ctx) {
        regcount.put(ctx, visit(ctx.statement()));
        return regcount.get(ctx);
    }

    /**
     * Returns how many registers a Closescope needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitClosescope(BoogyQParser.ClosescopeContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    /**
     * Returns how many registers a Charexpr needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitCharexpr(BoogyQParser.CharexprContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    /**
     * Returns how many registers a Break statement needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitBreakstat(BoogyQParser.BreakstatContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    /**
     * Returns how many registers an Assignstandardflow needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitAssignstandardflow(BoogyQParser.AssignstandardflowContext ctx) {
        regcount.put(ctx, visit(ctx.flow()));
        return regcount.get(ctx);
    }

    /**
     * Returns how many registers an Assigngeneratorflow needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitAssigngeneratorflow(BoogyQParser.AssigngeneratorflowContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    /**
     * Returns how many registers an Assignfunctionflow needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitAssignfunctionflow(BoogyQParser.AssignfunctionflowContext ctx) {
        int noflows = ctx.flow().size();
        int maxflow = 0;
        for (BoogyQParser.FlowContext flow : ctx.flow()) {
            maxflow = Math.max(maxflow, visit(flow));
        }
        regcount.put(ctx, (noflows - 1) + maxflow);
        return regcount.get(ctx);
    }

    /**
     * Returns how many registers an Andorexpr needs.
     * @param ctx This node.
     * @return The correct amount.
     */
    @Override @Deprecated
    public Integer visitAndorexpr(BoogyQParser.AndorexprContext ctx) {
        regcount.put(ctx, Math.max(2,Math.max(visit(ctx.expr(0)), visit(ctx.expr(1)))));
        return regcount.get(ctx);
    }
}
