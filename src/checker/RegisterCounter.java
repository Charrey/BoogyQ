package checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import parser.*;

/**
 * Created by poesd_000 on 21/06/2016.
 */
public class RegisterCounter extends BoogyQBaseVisitor<Integer> {

    public int check(ParseTree input) {
        return input.accept(this);
    }

    public ParseTreeProperty<Integer> regcount = new ParseTreeProperty<>();


    @Override
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


    @Override
    public Integer visitBoolexpr(BoogyQParser.BoolexprContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    @Override
    public Integer visitBarecomment(BoogyQParser.BarecommentContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    @Override
    public Integer visitTimesexpr(BoogyQParser.TimesexprContext ctx) {
        regcount.put(ctx, Math.max(2,Math.max(visit(ctx.expr(0)), visit(ctx.expr(1)))));
        return regcount.get(ctx);
    }

    @Override
    public Integer visitPowerexpr(BoogyQParser.PowerexprContext ctx) {
        regcount.put(ctx, Math.max(3,Math.max(visit(ctx.expr(0)), visit(ctx.expr(1)))));
        return regcount.get(ctx);
    }

    @Override
    public Integer visitPlusexpr(BoogyQParser.PlusexprContext ctx) {
        regcount.put(ctx, Math.max(2,Math.max(visit(ctx.expr(0)), visit(ctx.expr(1)))));
        return regcount.get(ctx);
    }

    @Override
    public Integer visitOpenscope(BoogyQParser.OpenscopeContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    @Override
    public Integer visitNotexpr(BoogyQParser.NotexprContext ctx) {
        regcount.put(ctx,visit(ctx.expr()));
        return regcount.get(ctx);
    }

    @Override
    public Integer visitNumberexpr(BoogyQParser.NumberexprContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    @Override
    public Integer visitMinusexpr(BoogyQParser.MinusexprContext ctx) {
        regcount.put(ctx, visit(ctx.expr()));
        return regcount.get(ctx);
    }

    @Override
    public Integer visitLoopstat(BoogyQParser.LoopstatContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    @Override
    public Integer visitIgnoreme(BoogyQParser.IgnoremeContext ctx) {
        regcount.put(ctx, Math.max(1, visit(ctx.expr())));
        return regcount.get(ctx);
    }

    @Override
    public Integer visitIdenexpr(BoogyQParser.IdenexprContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    @Override
    public Integer visitFlowexpr(BoogyQParser.FlowexprContext ctx) {
        regcount.put(ctx, visit(ctx.flow()));
        return regcount.get(ctx);
    }

    @Override
    public Integer visitComparatorexpr(BoogyQParser.ComparatorexprContext ctx) {
        regcount.put(ctx, Math.max(2,Math.max(visit(ctx.expr(0)), visit(ctx.expr(1)))));
        return regcount.get(ctx);
    }

    @Override
    public Integer visitIfstat(BoogyQParser.IfstatContext ctx) {
        int condition = visit(ctx.expr());
        int max = 0;
        for (BoogyQParser.StatementContext st : ctx.statement()) {
            max = Math.max(max, visit(st));
        }
        regcount.put(ctx, Math.max(condition, max) + 1);
        return regcount.get(ctx);
    }

    @Override
    public Integer visitFunctionvars(BoogyQParser.FunctionvarsContext ctx) {
        regcount.put(ctx, 1);
        return 1;
    }

    @Override
    public Integer visitFunctiondecl(BoogyQParser.FunctiondeclContext ctx) {
        int functionvars  = visit(ctx.functionvars());
        int max = 0;
        for (BoogyQParser.StatementContext st : ctx.statement()) {
            max = Math.max(max, visit(st));
        }
        regcount.put(ctx, Math.max(functionvars, max));
        return regcount.get(ctx);
    }

    @Override
    public Integer visitFlowstat(BoogyQParser.FlowstatContext ctx) {
        regcount.put(ctx, visit(ctx.flow()));
        return regcount.get(ctx);
    }

//    @Override
//    public Integer visitEmptystat(BoogyQParser.EmptystatContext ctx) {
//        regcount.put(ctx, 0);
//        return 0;
//    }

    @Override
    public Integer visitDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx) {
        regcount.put(ctx, visit(ctx.flow()));
        return regcount.get(ctx);
    }



    @Override
    public Integer visitDeclexpr(BoogyQParser.DeclexprContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    @Override
    public Integer visitConcurrentstat(BoogyQParser.ConcurrentstatContext ctx) {
        int max = 0;
        for (BoogyQParser.StatementContext st : ctx.statement()) {
            max = Math.max(max, visit(st));
        }
        regcount.put(ctx, max);
        return max;
    }

    @Override
    public Integer visitCommentstat(BoogyQParser.CommentstatContext ctx) {
        regcount.put(ctx, visit(ctx.statement()));
        return regcount.get(ctx);
    }

    @Override
    public Integer visitClosescope(BoogyQParser.ClosescopeContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    @Override
    public Integer visitCharexpr(BoogyQParser.CharexprContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    @Override
    public Integer visitBreakstat(BoogyQParser.BreakstatContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    @Override
    public Integer visitAssignstandardflow(BoogyQParser.AssignstandardflowContext ctx) {
        regcount.put(ctx, visit(ctx.flow()));
        return regcount.get(ctx);
    }

    @Override
    public Integer visitAssigngeneratorflow(BoogyQParser.AssigngeneratorflowContext ctx) {
        regcount.put(ctx, 0);
        return 0;
    }

    @Override
    public Integer visitAssignfunctionflow(BoogyQParser.AssignfunctionflowContext ctx) {
        int noflows = ctx.flow().size();
        int maxflow = 0;
        for (BoogyQParser.FlowContext flow : ctx.flow()) {
            maxflow = Math.max(maxflow, visit(flow));
        }
        regcount.put(ctx, (noflows - 1) + maxflow);
        return regcount.get(ctx);
    }

    @Override
    public Integer visitAndorexpr(BoogyQParser.AndorexprContext ctx) {
        regcount.put(ctx, Math.max(2,Math.max(visit(ctx.expr(0)), visit(ctx.expr(1)))));
        return regcount.get(ctx);
    }
}
