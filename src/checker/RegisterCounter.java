package checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.BoogyQBaseVisitor;
import parser.BoogyQParser;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by poesd_000 on 21/06/2016.
 */
public class RegisterCounter extends BoogyQBaseVisitor<Integer>{

    public int check(ParseTree input) {
        return input.accept(this);
    }


    @Override
    public Integer visitProgram(BoogyQParser.ProgramContext ctx) {
        int max = 0;
        for (BoogyQParser.StatementContext i : ctx.statement()) {
            max = Math.max(max, visit(i));
        }
        return max;
    }


    @Override
    public Integer visitBoolexpr(BoogyQParser.BoolexprContext ctx) {
        return 1;
    }

    @Override
    public Integer visitTimesexpr(BoogyQParser.TimesexprContext ctx) {
        return Math.max(visit(ctx.expr(0)), visit(ctx.expr(1))) + 1;
    }


}
