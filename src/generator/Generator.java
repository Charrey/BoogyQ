package generator;

import checker.RegisterCounter;
import checker.Type;
import checker.BasicSymbolTable;
import checker.SymbolTable;
import exceptions.generator.RegisterException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import parser.BoogyQBaseVisitor;
import parser.BoogyQParser;
import sprocl.model.*;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.util.*;

/**
 * Created by Hans on 21-6-2016.
 */
public class Generator extends BoogyQBaseVisitor<List<Op>> {

    /** The base register. */
    private Reg arp = new Reg("r_arp");
    /** Association of statement nodes to labels. */
    private ParseTreeProperty<Label> labels;
    /** The program being built. */
    private Program prog;
    /** Register count, used to generate fresh registers. */
    /** Association of expression and target nodes to registers. */
    private ParseTreeProperty<List<Reg>> regsList;
    private ParseTreeProperty<Integer> regCount;


    private SymbolTable<Integer> symbolTable = new BasicSymbolTable();

    private Reg r_standard0 = new Reg("r_standard0"); //We use this both as r_0 and r_standard, we put the value back to 0 everytime we have used this.
    private Reg r_arp = new Reg("r_arp");
    private Reg r_load = new Reg("r_load");
    private int label_counter;

    private static BigInteger MAXINTVALUE = new BigInteger(String.valueOf(Integer.MAX_VALUE)); //TOOD: Check if we can do this better.

    ParseTreeProperty<String> label;

    public Program generate(ParseTree tree) throws RegisterException {
        prog = new Program();
        regsList = new ParseTreeProperty<List<Reg>>();
        label = new ParseTreeProperty<>();
        RegisterCounter registerCounter = new RegisterCounter();
        int maxamountofregisters = registerCounter.check(tree);
        if(maxamountofregisters > 8){
            throw new RegisterException("Not enough registers available to compile this program. Available: 8, Needed: " + maxamountofregisters);
        }
        regCount = registerCounter.regcount;
        List<Reg> regsListForTopNode = new ArrayList<>();
        for (int i = 1; i < regCount.get(tree) -2 ; i++){
            regsListForTopNode.add(new Reg("r_"+i));
        }
        regsList.put(tree,regsListForTopNode);
        labels = new ParseTreeProperty<>();
        List<Op> res = tree.accept(this);
        for (Op i : res) {
            prog.addInstr(i);
        }
        return prog;
    }

    /**
     * Looks up the label for a given parse tree node,
     * creating it if none has been created before.
     * The label is actually constructed from the entry node
     * in the flow graph, as stored in the checker result.
     */
    private Label label(ParserRuleContext node) {
        Label result = this.labels.get(node);
        if (result == null) {
            //ParserRuleContext entry = this.checkResult.getEntry(node);
            //result = createLabel(entry, "n");
            this.labels.put(node, result);
        }
        return result;
    }

    /** Creates a label for a given parse tree node and prefix. */
    private Label createLabel(ParserRuleContext node, String prefix) {
        Token token = node.getStart();
        int line = token.getLine();
        int column = token.getCharPositionInLine();
        String result = prefix + "_" + line + "_" + column;
        return new Label(result);
    }

    /////////////////////////////////////////////////////////////////////////////

    @Override
    public List<Op> visitProgram(BoogyQParser.ProgramContext ctx) {
        List<Op> operations = new LinkedList<Op>();
        List<Reg> programRegList = regsList.get(ctx);
        List<Reg> statementRegList;
        for(BoogyQParser.StatementContext context : ctx.statement()){
            statementRegList = programRegList.subList(0, regCount.get(context));
            regsList.put(context, statementRegList);
            operations.addAll(visit(context));
        }
        return operations;
    }

    //EVERYTHING CONERCING STATEMENTS
    @Override
    public List<Op> visitCommentstat(BoogyQParser.CommentstatContext ctx) {
        regsList.put(ctx.statement(), regsList.get(ctx));
        return visit(ctx.statement());
    }

    // EVERYTHING CONCERNING FLOWS
    @Override
    public List<Op> visitFlowstat(BoogyQParser.FlowstatContext ctx) {
        if (ctx.flow().isEmpty()) { //TODO, check this.
            return new ArrayList<>();
        } else {
            regsList.put(ctx.flow(), regsList.get(ctx));
            return visit(ctx.flow());
        }
    }

    //EVERYTHING CONCERNING EXPRESSION
    @Override
    public List<Op> visitBoolexpr(BoogyQParser.BoolexprContext ctx) {
        List<Op> operations = new ArrayList<>();
        if(ctx.BOOL().getText().equals("True")){
            operations.add(new Op(OpCode.loadCONST, new Num(1), r_standard0));
            operations.add(new Op(OpCode.push, r_standard0));
            operations.add(new Op(OpCode.loadCONST, new Num(0), r_standard0));
        } else {
            operations.add(new Op(OpCode.push, r_standard0));
        }
        return operations;
    }

    @Override
    //TODO: Fix exceptions
    public List<Op> visitNumberexpr(BoogyQParser.NumberexprContext ctx) {
        List<Op> operations = new ArrayList<>();
        int number = Integer.getInteger(ctx.NUMBER().getText());
        operations.add(new Op(OpCode.loadCONST, new Num(number), r_standard0));
        operations.add(new Op(OpCode.push, r_standard0));
        operations.add(new Op(OpCode.loadCONST, new Num(0), r_standard0));
        return operations;
    }

    @Override
    public List<Op> visitCharexpr(BoogyQParser.CharexprContext ctx) {
        List<Op> operations = new ArrayList<>();
        String character = ctx.CHAR().getText().substring(1,2);
        try {
            int charValue = ByteBuffer.wrap(character.getBytes("UTF-32")).getInt();
            operations.add(new Op(OpCode.loadCONST, new Num(charValue), r_standard0));
            operations.add(new Op(OpCode.push, r_standard0));
            operations.add(new Op(OpCode.loadCONST, new Num(0), r_standard0));
            return operations;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    @Override
    public List<Op> visitFlowexpr(BoogyQParser.FlowexprContext ctx) {
        regsList.put(ctx.flow(), regsList.get(ctx));
        List<Op> operations = visit(ctx.flow());
        Reg r_res= regsList.get(ctx).get(regsList.get(ctx).size()-1);
        operations.add(new Op(OpCode.push, r_res));
        return operations;
    }

    @Override
    public List<Op> visitAndorexpr(BoogyQParser.AndorexprContext ctx) {
        BoogyQParser.ExprContext leftexpr = ctx.expr(0);
        BoogyQParser.ExprContext rightexpr = ctx.expr(2);

        List<Reg> exprRegList = regsList.get(ctx).subList(0, regCount.get(leftexpr));
        Reg r_1 = regsList.get(ctx).get(0); //Niet exprRegList.get(0) want exprRegList kan een lege lijst zijn.

        regsList.put(leftexpr, exprRegList);
        List<Op> operations = visit(leftexpr);

        exprRegList = regsList.get(ctx).subList(0, regCount.get(rightexpr));
        regsList.put(rightexpr, exprRegList);
        operations.addAll(visit(rightexpr));

        operations.add(new Op(OpCode.pop, r_standard0));
        operations.add(new Op(OpCode.pop, r_1));
        if (ctx.getChild(1).getText().equals("&&")){
            operations.add(new Op(OpCode.computeAND, r_standard0, r_1, r_1));
        } else {
            operations.add(new Op(OpCode.computeOR, r_standard0, r_1, r_1));
        }
        operations.add(new Op(OpCode.loadCONST, new Num(0), r_standard0));
        operations.add(new Op(OpCode.push, r_1));
        return operations;
    }

    @Override
    public List<Op> visitComparatorexpr(BoogyQParser.ComparatorexprContext ctx) {
        BoogyQParser.ExprContext leftexpr = ctx.expr(0);
        BoogyQParser.ExprContext rightexpr = ctx.expr(2);

        List<Reg> exprRegList = regsList.get(ctx).subList(0, regCount.get(leftexpr));
        Reg r_1 = regsList.get(ctx).get(0); //Niet exprRegList.get(0) want exprRegList kan een lege lijst zijn.

        regsList.put(leftexpr, exprRegList);
        List<Op> operations = visit(leftexpr);

        exprRegList = regsList.get(ctx).subList(0, regCount.get(rightexpr));
        regsList.put(rightexpr, exprRegList);
        operations.addAll(visit(rightexpr));

        String comparator = ctx.getChild(1).getText();
        switch (comparator){
            case "==":
                operations.add(new Op(OpCode.computeEQUAL,r_standard0, r_1, r_1));
                break;
            case "!=":
                operations.add(new Op(OpCode.computeNEQ, r_standard0, r_1, r_1));
                break;
            case "<":
                operations.add(new Op(OpCode.computeLT, r_standard0, r_1, r_1));
                break;
            case "<=":
                operations.add(new Op(OpCode.computeLTE, r_standard0, r_1, r_1));
                break;
            case ">":
                operations.add(new Op(OpCode.computeGT, r_standard0, r_1, r_1));
                break;
            case ">=":
                operations.add(new Op(OpCode.computeGTE, r_standard0, r_1, r_1));
                break;
        }
        return operations;
    }


    @Override
    public List<Op> visitPowerexpr(BoogyQParser.PowerexprContext ctx) {
       // List<Op> operations = new ArrayList<>();
        //Reg target = regs.get(ctx);

        //regs.put(ctx.getChild(0),target);
        //List<Op> baseOps = visit(ctx.getChild(0));
        //operations.addAll(baseOps);

        //Reg expReg = new Reg(String.valueOf(regCount++));
        //r//egs.put(ctx.getChild(2), expReg);
        //List<Op> expOps = visit(ctx.getChild(2));
        //operations.addAll(expOps);
        return null;
    }

    @Override
    public List<Op> visitAssignstandardflow(BoogyQParser.AssignstandardflowContext ctx) {
        List<Reg> flowRegList = regsList.get(ctx);
        regsList.put(ctx.flow(), flowRegList);
        Reg r_res =  regsList.get(ctx).get(regsList.get(ctx).size()-1);
        List<Op> operations = visit(ctx.flow());
        int offset = symbolTable.get(ctx.ID().getText());
        operations.add(new Op(OpCode.loadCONST, new Num(offset), r_load));
        operations.add(new Op(OpCode.storeDIRA, r_load, r_res));
        return operations;
    }


}
