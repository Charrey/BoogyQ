package generator;

import checker.*;
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
import java.util.*;

/**
 * Created by Hans on 21-6-2016.
 */
public class Generator extends BoogyQBaseVisitor<List<Op>> {

    private static Generator ourInstance = new Generator();

    public static Generator getInstance() {
        return ourInstance;
    }



    /** Association of statement nodes to labels. */
    private ParseTreeProperty<Label> labels;
    /** The program being built. */
    private Program prog;
    /** Register count, used to generate fresh registers. */
    /** Association of expression and target nodes to registers. */
    private ParseTreeProperty<List<Reg>> regsList;
    private ParseTreeProperty<Integer> regCount;


    private OffsetSymbolTable symbolTable;
    private final Map<String, Num> defaultValues; //The default values for all types.
                                                  //Atm we only have int, char and bool
                                                    // int = 0; char = A; bool = False;

    private Reg r_standard0 = new Reg("1"); //We use this both as r_0 and r_standard, we put the value back to 0 everytime we have used this.
    //private Reg r_arp = new Reg("r_arp");
    private Reg r_load = new Reg("2");
    private int label_counter;

    private static BigInteger MAXINTVALUE = new BigInteger(String.valueOf(Integer.MAX_VALUE)); //TOOD: Check if we can do this better.

    ParseTreeProperty<String> label;

    private Generator(){
        defaultValues = new HashMap<>();
        defaultValues.put("int", new Num(0));
        defaultValues.put("bool", new Num(0));
        defaultValues.put("char",new Num(65));
    }

    public Program generate(ParseTree tree) throws RegisterException {
        symbolTable = new OffsetSymbolTable();
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
        for (int i = 3; i < regCount.get(tree) ; i++){
            regsListForTopNode.add(new Reg(String.valueOf(i)));
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

    @Override
    public List<Op> visitIfstat(BoogyQParser.IfstatContext ctx) {
        List<Op> operations = new ArrayList<>();
        List<Reg> ifRegList = regsList.get(ctx);

        List<Reg> exprRegList = ifRegList.subList(0, regCount.get(ctx.expr()));
        regsList.put(ctx.expr(), exprRegList);
        operations.addAll(visit(ctx.expr()));

        List<Reg> statementRegList;
        List<Op> statementoperations = new ArrayList<>();

        symbolTable.openScope();
        for(BoogyQParser.StatementContext context : ctx.statement()){
            statementRegList = ifRegList.subList(0, regCount.get(context));
            regsList.put(context, statementRegList);
            statementoperations.addAll(visit(context));
        }
        symbolTable.closeScope();

        operations.add(new Op(OpCode.pop, r_standard0));
        operations.add(new Op(OpCode.loadCONST, new Num(1), r_load));
        operations.add(new Op(OpCode.computeXOR, r_standard0, r_load, r_standard0));
        operations.add(new Op(OpCode.branchREL, r_standard0, new Num(statementoperations.size())));
        operations.addAll(statementoperations);
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
                    } else {
            operations.add(new Op(OpCode.push, r_standard0));
        }
        return operations;
    }

    @Override
    //TODO: Fix exceptions
    public List<Op> visitNumberexpr(BoogyQParser.NumberexprContext ctx) {
        List<Op> operations = new ArrayList<>();
        int number = Integer.parseInt(ctx.NUMBER().getText());
        operations.add(new Op(OpCode.loadCONST, new Num(number), r_standard0));
        operations.add(new Op(OpCode.push, r_standard0));
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
        BoogyQParser.ExprContext rightexpr = ctx.expr(1);

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
                operations.add(new Op(OpCode.push, r_1));
        return operations;
    }

    @Override
    public List<Op> visitComparatorexpr(BoogyQParser.ComparatorexprContext ctx) {
        BoogyQParser.ExprContext leftexpr = ctx.expr(0);
        BoogyQParser.ExprContext rightexpr = ctx.expr(1);

        List<Reg> exprRegList = regsList.get(ctx).subList(0, regCount.get(leftexpr));
        Reg r_1 = regsList.get(ctx).get(0); //Niet exprRegList.get(0) want exprRegList kan een lege lijst zijn.

        regsList.put(leftexpr, exprRegList);
        List<Op> operations = visit(leftexpr);

        exprRegList = regsList.get(ctx).subList(0, regCount.get(rightexpr));
        regsList.put(rightexpr, exprRegList);
        operations.addAll(visit(rightexpr));

        operations.add(new Op(OpCode.pop, r_standard0));
        operations.add(new Op(OpCode.pop, r_1));

        String comparator = ctx.getChild(1).getText();
        switch (comparator){
            case "==":
                operations.add(new Op(OpCode.computeEQUAL,r_1, r_standard0, r_1));
                break;
            case "!=":
                operations.add(new Op(OpCode.computeNEQ, r_1, r_standard0, r_1));
                break;
            case "<":
                operations.add(new Op(OpCode.computeLT, r_1, r_standard0, r_1));
                break;
            case "<=":
                operations.add(new Op(OpCode.computeLTE, r_1, r_standard0, r_1));
                break;
            case ">":
                operations.add(new Op(OpCode.computeGT, r_1, r_standard0, r_1));
                break;
            case ">=":
                operations.add(new Op(OpCode.computeGTE, r_1, r_standard0, r_1));
                break;
        }
        operations.add(new Op(OpCode.push, r_1));
        return operations;
    }


    @Override
    public List<Op> visitPowerexpr(BoogyQParser.PowerexprContext ctx) {
        int leftwants = regCount.get(ctx.expr(0));
        int rightwants = regCount.get(ctx.expr(1));

        List<Reg> wehave = regsList.get(ctx);
        List<Reg> leftmayhave = wehave.subList(0, leftwants);
        List<Reg> rightmayhave = wehave.subList(0, rightwants);

        regsList.put(ctx.expr(0), leftmayhave);
        regsList.put(ctx.expr(1), rightmayhave);

        List<Op> left = visit(ctx.expr(0));
        List<Op> right = visit(ctx.expr(1));


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
        operations.add(new Op(OpCode.storeINDA, r_res, r_load));

        return operations;
    }

    @Override
    public List<Op> visitDeclexpr(BoogyQParser.DeclexprContext ctx) {
        List<Op> operations = new ArrayList<>();
        String id = ctx.ID().getText();
        String type = ctx.PRIMITIVE().getText();

        symbolTable.add(id);
        operations.add(new Op(OpCode.loadCONST, defaultValues.get(type), r_standard0));
        operations.add(new Op(OpCode.loadCONST, new Num(symbolTable.get(id)), r_load));
        operations.add(new Op(OpCode.storeINDA, r_standard0, r_load));
        operations.add(new Op(OpCode.push, r_standard0));

        return operations;
    }

    @Override
    public List<Op> visitDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx) {
        List<Reg> flowRegList = regsList.get(ctx);
        regsList.put(ctx.flow(), flowRegList);
        Reg r_res =  regsList.get(ctx).get(regsList.get(ctx).size()-1);

        List<Op> operations = visit(ctx.flow());
        String id = ctx.ID().getText();
        symbolTable.add(id);
        int offset = symbolTable.get(id);

        operations.add(new Op(OpCode.loadCONST, new Num(offset), r_load));
        operations.add(new Op(OpCode.storeINDA, r_res, r_load));

        return operations;
    }

    @Override
    public List<Op> visitIdenexpr(BoogyQParser.IdenexprContext ctx) {
        String id = ctx.ID().getText();
        int offset = symbolTable.get(id);
        List<Op> operations = new ArrayList<>();

        operations.add(new Op(OpCode.loadCONST, new Num(offset), r_load));
        operations.add(new Op(OpCode.loadDIRA, r_load, r_load));
        operations.add(new Op(OpCode.push, r_load));
        return operations;
    }

    @Override
    public List<Op> visitIgnoreme(BoogyQParser.IgnoremeContext ctx) {
        List<Reg> flowRegList = regsList.get(ctx);
        regsList.put(ctx.expr(), flowRegList);
        Reg r_res =  regsList.get(ctx).get(regsList.get(ctx).size()-1);
        List<Op> operations = visit(ctx.expr());

        operations.add(new Op(OpCode.pop, r_res));
        return operations;
    }

    @Override
    public List<Op> visitTimesexpr(BoogyQParser.TimesexprContext ctx) {
        BoogyQParser.ExprContext leftexpr = ctx.expr(0);
        BoogyQParser.ExprContext rightexpr = ctx.expr(1);

        List<Reg> exprRegList = regsList.get(ctx).subList(0, regCount.get(leftexpr));
        Reg r_1 = regsList.get(ctx).get(0); //Niet exprRegList.get(0) want exprRegList kan een lege lijst zijn.

        regsList.put(leftexpr, exprRegList);
        List<Op> operations = visit(leftexpr);

        exprRegList = regsList.get(ctx).subList(0, regCount.get(rightexpr));
        regsList.put(rightexpr, exprRegList);
        operations.addAll(visit(rightexpr));

        operations.add(new Op(OpCode.pop, r_standard0));
        operations.add(new Op(OpCode.pop, r_1));
        operations.add(new Op(OpCode.computeMUL, r_1, r_standard0, r_1));
                operations.add(new Op(OpCode.push, r_1));
        return operations;
    }

    @Override
    public List<Op> visitPlusexpr(BoogyQParser.PlusexprContext ctx) {
        BoogyQParser.ExprContext leftexpr = ctx.expr(0);
        BoogyQParser.ExprContext rightexpr = ctx.expr(1);

        List<Reg> exprRegList = regsList.get(ctx).subList(0, regCount.get(leftexpr));
        Reg r_1 = regsList.get(ctx).get(0); //Niet exprRegList.get(0) want exprRegList kan een lege lijst zijn.

        regsList.put(leftexpr, exprRegList);
        List<Op> operations = visit(leftexpr);

        exprRegList = regsList.get(ctx).subList(0, regCount.get(rightexpr));
        regsList.put(rightexpr, exprRegList);
        operations.addAll(visit(rightexpr));

        operations.add(new Op(OpCode.pop, r_standard0));
        operations.add(new Op(OpCode.pop, r_1));
        if (ctx.getChild(1).getText().equals("+")) {
            operations.add(new Op(OpCode.computeADD, r_1, r_standard0, r_1));
        } else {
            operations.add(new Op(OpCode.computeSUB, r_1, r_standard0, r_1));
        }
                operations.add(new Op(OpCode.push, r_1));
        return operations;
        }

    @Override
    public List<Op> visitMinusexpr(BoogyQParser.MinusexprContext ctx) {
        BoogyQParser.ExprContext leftexpr = ctx.expr();

        List<Reg> exprRegList = regsList.get(ctx).subList(0, regCount.get(leftexpr));
        Reg r_1 = regsList.get(ctx).get(0); //Niet exprRegList.get(0) want exprRegList kan een lege lijst zijn.

        regsList.put(leftexpr, exprRegList);
        List<Op> operations = visit(leftexpr);

        operations.add(new Op(OpCode.pop, r_1));
        operations.add(new Op(OpCode.loadCONST, new Num(0), r_standard0));
        operations.add(new Op(OpCode.computeSUB, r_standard0, r_1, r_1));
        operations.add(new Op(OpCode.push, r_1));
        return operations;
    }

    @Override
    public List<Op> visitNotexpr(BoogyQParser.NotexprContext ctx) {
        BoogyQParser.ExprContext leftexpr = ctx.expr();

        List<Reg> exprRegList = regsList.get(ctx).subList(0, regCount.get(leftexpr));
        Reg r_1 = regsList.get(ctx).get(0); //Niet exprRegList.get(0) want exprRegList kan een lege lijst zijn.

        regsList.put(leftexpr, exprRegList);
        List<Op> operations = visit(leftexpr);

        operations.add(new Op(OpCode.pop, r_1));
        operations.add(new Op(OpCode.loadCONST, new Num(1), r_standard0));
        operations.add(new Op(OpCode.computeXOR, r_standard0, r_1, r_1));
                operations.add(new Op(OpCode.push, r_1));
        return operations;
    }
}
