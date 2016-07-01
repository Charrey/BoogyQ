package generator;

import checker.*;
import divider.Divider;
import exceptions.generator.RegisterException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import parser.*;
import sprocl.model.*;
import toplevel.OpListWrapper;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.*;

/**
 * Singleton responsible for generating code from a parse tree.
 */
public class Generator extends BoogyQBaseVisitor<List<Op>> {

    /**
     * The sole instance of this generator.
     */
    private static Generator ourInstance = new Generator();

    /**
     * Returns the sole generator instance.
     * @return The instance.
     */
    public static Generator getInstance() {
        return ourInstance;
    }


    /** Association of expression and target nodes to registers. */
    private ParseTreeProperty<List<Reg>> regsList;
    /** ParseTreeProperty saving how many registers each node needs. */
    private ParseTreeProperty<Integer> regCount;


    /**
     * Symboltable saving all local variables.
     */
    private OffsetSymbolTable symbolTable;
    /**
     * Map that saves default values of all primitive types.
     */
    private final Map<String, Num> defaultValues; //The default values for all types.
                                                  //Atm we only have int, char and bool
                                                    // int = 0; char = A; bool = False;

    /**
     * Register available for temporary use. Generally used to store values before performing operations on them. There is no guarantee the contents of this register will remain.
     */
    public Reg r_standard = new Reg("1");
    /**
     * Register available for temporary use. Generally used to store addresses. There is no guarantee the contents of this register will remain.
     */
    public Reg r_load = new Reg("2");


    /**
     * Stack which denotes in what if-statement the Visitor currently is, including enclosing if-statements.
     */
    private Stack<Integer> if_statements;
    /**
     * Counter used to identify if_statements. Incremented every time an ifstat is visited.
     */
    private int if_statement_counter;

    /**
     * Creates a new Generator.
     */
    private Generator(){
        defaultValues = new HashMap<>();
        defaultValues.put("int", new Num(0));
        defaultValues.put("bool", new Num(0));
        defaultValues.put("char",new Num(65));
    }

    /**
     * Generate a list of operations from a BoogyQ parse tree.
     * @param tree The BoogyQ parse tree.
     * @param flag The memory location this thread is assigned to.
     * @return A list of operations that executes this program.
     * @throws RegisterException Thrown when there are more than 8 registers needed in this program.
     */
    public OpListWrapper generate(ParseTree tree, Flag flag) throws RegisterException {
        if_statements = new Stack<>();
        if_statement_counter = 1;
        symbolTable = new OffsetSymbolTable();
        regsList = new ParseTreeProperty<>();
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

        List<Op> res = tree.accept(this);
        res = LoopBreakFixer.fix(res);
        return new OpListWrapper(res, flag);
    }

    /////////////////////////////////////////////////////////////////////////////

    /**
     * Gathers code from all its statements and glues it together.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
    public List<Op> visitProgram(BoogyQParser.ProgramContext ctx) {
        List<Op> operations = new LinkedList<>();
        List<Reg> programRegList = regsList.get(ctx);
        List<Reg> statementRegList;
        for(BoogyQParser.StatementContext context : ctx.statement()){
            statementRegList = programRegList.subList(0, regCount.get(context));
            regsList.put(context, statementRegList);
            operations.addAll(visit(context));
        }
        return operations;
    }

    /**
     * Returns the empty list; Comments do not require instructions.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
    public List<Op> visitBarecomment(BoogyQParser.BarecommentContext ctx) {
        return new ArrayList<>();
    }

    /**
     * Visits an if-statement; Adds all code evaluating the expression, adds a conditional branch.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
    public List<Op> visitIfstat(BoogyQParser.IfstatContext ctx) {
        List<Op> operations = new ArrayList<>();
        List<Reg> ifRegList = regsList.get(ctx);

        int myvalue = if_statement_counter;
        if_statements.push(myvalue);


        List<Reg> exprRegList = ifRegList.subList(0, regCount.get(ctx.expr()));
        regsList.put(ctx.expr(), exprRegList);
        operations.addAll(visit(ctx.expr()));

        operations.get(0).setIfStartLabel(String.valueOf(myvalue));
        if_statement_counter++;

        List<Reg> statementRegList;
        List<Op> statementoperations = new ArrayList<>();

        symbolTable.openScope();
        for(BoogyQParser.StatementContext context : ctx.statement()){
            statementRegList = ifRegList.subList(0, regCount.get(context));
            regsList.put(context, statementRegList);
            statementoperations.addAll(visit(context));
        }
        symbolTable.closeScope();

        operations.add(new Op(OpCode.pop, r_standard));
        operations.add(new Op(OpCode.loadCONST, new Num(1), r_load));
        operations.add(new Op(OpCode.computeXOR, r_standard, r_load, r_standard));
        operations.add(new Op(OpCode.branchREL, r_standard, new Num(statementoperations.size()+1)));
        operations.addAll(statementoperations);

        if_statements.pop();
        operations.get(operations.size()-1).addIfendlabel(String.valueOf(myvalue));

        return operations;
    }


    /**
     * Visits a statement with a comment behind it. Ignores the comment.
     * @param ctx Current node.
     * @return Whatever the child statement returns.
     */
    @Override @Deprecated
    public List<Op> visitCommentstat(BoogyQParser.CommentstatContext ctx) {
        regsList.put(ctx.statement(), regsList.get(ctx));
        return visit(ctx.statement());
    }

    /**
     * Visits a concurrent stat; Add code that looks up the statement's memory location and writes 1 to it.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
    public List<Op> visitConcurrentstat(BoogyQParser.ConcurrentstatContext ctx) {
        List<Op> operations = new ArrayList<>();
        operations.add(new Op(OpCode.loadCONST, Divider.flags.get(ctx), r_load));
        operations.add(new Op(OpCode.loadCONST, new Num(1), r_standard));
        operations.add(new Op(OpCode.writeINDA, r_standard, r_load));
        return operations;
    }

    /**
     * Converts a loop-statement into a jump-statement with the correct number.
     * @param ctx Current node.
     * @return Correct jump instruction.
     */
    @Override @Deprecated
    public List<Op> visitLoopstat(BoogyQParser.LoopstatContext ctx) {
        List<Op> operations = new ArrayList<>();
        Stack<Integer> stackcopy = (Stack<Integer>) if_statements.clone();
        int back = Integer.parseInt(ctx.NUMBER().getText());
        while (back>0) {
            stackcopy.pop();
            back--;
        }
        operations.add(new Op(OpCode.jumpLABEL, new Num(stackcopy.pop())));
        return operations;
    }

    /**
     * Converts a break-statement into a jump-statement with the correct number.
     * @param ctx Current node.
     * @return Correct jump instuction.
     */
    @Override @Deprecated
    public List<Op> visitBreakstat(BoogyQParser.BreakstatContext ctx) {
        List<Op> operations = new ArrayList<>();
        Stack<Integer> stackcopy = (Stack<Integer>) if_statements.clone();
        int back = Integer.parseInt(ctx.NUMBER().getText());
        while (back>0) {
            stackcopy.pop();
            back--;
        }
        operations.add(new Op(OpCode.jumpBREAK, new Num(stackcopy.pop())));
        return operations;
    }


    /**
     * Returns the list of operations from its flow, after performing a minor optimalization.
     * @param ctx Current node.
     * @return Optimized list of operations.
     */
    @Override @Deprecated
    public List<Op> visitFlowstat(BoogyQParser.FlowstatContext ctx) {
        if (ctx.flow().isEmpty()) {
            return new ArrayList<>();
        } else {
            regsList.put(ctx.flow(), regsList.get(ctx));
            List<Op> a = visit(ctx.flow());
            Op lastinstruction = a.get(a.size()-1);
            Set<OpCode> storeset = new HashSet<>();
            storeset.add(OpCode.storeCONST);
            storeset.add(OpCode.storeDIRA);
            storeset.add(OpCode.storeINDA);
            storeset.add(OpCode.writeDIRA);
            storeset.add(OpCode.writeINDA);
            storeset.add(OpCode.receive);   //waiting for global memory
            while (!storeset.contains(lastinstruction.getOpCode()) && !a.isEmpty()) {
                a = a.subList(0, a.size()-1);
                lastinstruction = a.get(a.size()-1);
            }
            return a;
        }
    }


    /**
     * Pushes a boolean value on the stack.
     * @param ctx Current node.
     * @return Instruction that pushes the value on the stack.
     */
    @Override @Deprecated
    public List<Op> visitBoolexpr(BoogyQParser.BoolexprContext ctx) {
        List<Op> operations = new ArrayList<>();
        if(ctx.BOOL().getText().equals("True")){
            operations.add(new Op(OpCode.loadCONST, new Num(1), r_standard));
            operations.add(new Op(OpCode.push, r_standard));
        } else {
            operations.add(new Op(OpCode.push, new Reg("0")));
        }
        return operations;
    }

    /**
     * Pushes a number value on the stack.
     * @param ctx Current node.
     * @return Instruction that pushes the value on the stack.
     */
    @Override @Deprecated
    public List<Op> visitNumberexpr(BoogyQParser.NumberexprContext ctx) {
        List<Op> operations = new ArrayList<>();
        int number = Integer.parseInt(ctx.NUMBER().getText());
        if (number != 0) {
            operations.add(new Op(OpCode.loadCONST, new Num(number), r_standard));
            operations.add(new Op(OpCode.push, r_standard));
        } else {
            operations.add(new Op(OpCode.push, new Reg("0")));
        }
        return operations;
    }

    /**
     * Pushes a character value on the stack.
     * @param ctx Current node.
     * @return Instruction that pushes the value on the stack.
     */
    @Override @Deprecated
    public List<Op> visitCharexpr(BoogyQParser.CharexprContext ctx) {
        List<Op> operations = new ArrayList<>();
        String character = ctx.CHAR().getText().substring(1,2);
        try {
            int charValue = ByteBuffer.wrap(character.getBytes("UTF-32")).getInt();
            operations.add(new Op(OpCode.loadCONST, new Num(charValue), r_standard));
            operations.add(new Op(OpCode.push, r_standard));
                        return operations;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    /**
     * Looks up what the flow does, returns that including an instruction to push it to the stack.
     * @param ctx Current node.
     * @return List of instructions.
     */
    @Override @Deprecated
    public List<Op> visitFlowexpr(BoogyQParser.FlowexprContext ctx) {
        regsList.put(ctx.flow(), regsList.get(ctx));
        List<Op> operations = visit(ctx.flow());
        Reg r_res= regsList.get(ctx).get(regsList.get(ctx).size()-1);
        operations.add(new Op(OpCode.push, r_res));
        return operations;
    }

    /**
     * Evaluates the left an right expression, pops both off the stack and performs the operation.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
    public List<Op> visitAndorexpr(BoogyQParser.AndorexprContext ctx) {
        BoogyQParser.ExprContext leftexpr = ctx.expr(0);
        BoogyQParser.ExprContext rightexpr = ctx.expr(1);

        List<Reg> exprRegList = regsList.get(ctx).subList(0, regCount.get(leftexpr));
        Reg r_1 = r_load; //Niet exprRegList.get(0) want exprRegList kan een lege lijst zijn.

        regsList.put(leftexpr, exprRegList);
        List<Op> operations = visit(leftexpr);

        exprRegList = regsList.get(ctx).subList(0, regCount.get(rightexpr));
        regsList.put(rightexpr, exprRegList);
        operations.addAll(visit(rightexpr));

        operations.add(new Op(OpCode.pop, r_standard));
        operations.add(new Op(OpCode.pop, r_1));
        if (ctx.getChild(1).getText().equals("&&")){
            operations.add(new Op(OpCode.computeAND, r_standard, r_1, r_1));
        } else {
            operations.add(new Op(OpCode.computeOR, r_standard, r_1, r_1));
        }
                operations.add(new Op(OpCode.push, r_1));
        return operations;
    }

    /**
     * Evaluates the left an right expression, pops both off the stack and performs the operation.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
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

        operations.add(new Op(OpCode.pop, r_standard));
        operations.add(new Op(OpCode.pop, r_1));

        String comparator = ctx.getChild(1).getText();
        switch (comparator){
            case "==":
                operations.add(new Op(OpCode.computeEQUAL,r_1, r_standard, r_1));
                break;
            case "!=":
                operations.add(new Op(OpCode.computeNEQ, r_1, r_standard, r_1));
                break;
            case "<":
                operations.add(new Op(OpCode.computeLT, r_1, r_standard, r_1));
                break;
            case "<=":
                operations.add(new Op(OpCode.computeLTE, r_1, r_standard, r_1));
                break;
            case ">":
                operations.add(new Op(OpCode.computeGT, r_1, r_standard, r_1));
                break;
            case ">=":
                operations.add(new Op(OpCode.computeGTE, r_1, r_standard, r_1));
                break;
        }
        operations.add(new Op(OpCode.push, r_1));
        return operations;
    }

    /**
     * Evaluates the left an right expression, pops both off the stack and performs the operation.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
    public List<Op> visitPowerexpr(BoogyQParser.PowerexprContext ctx) {
        int leftwants = regCount.get(ctx.expr(0));
        int rightwants = regCount.get(ctx.expr(1));

        List<Reg> wehave = regsList.get(ctx);
        List<Reg> leftmayhave = wehave.subList(0, leftwants);
        List<Reg> rightmayhave = wehave.subList(0, rightwants);

        regsList.put(ctx.expr(0), leftmayhave);
        regsList.put(ctx.expr(1), rightmayhave);

        List<Op> operations = visit(ctx.expr(0));
        operations.addAll(visit(ctx.expr(1)));

        Reg r_result = regsList.get(ctx).get(0);
        Reg r_base = r_load;
        Reg r_temp1 = regsList.get(ctx).get(1);
        Reg r_temp2 = regsList.get(ctx).get(2);
        Reg r_exponent = r_standard;
        operations.add(new Op(OpCode.loadCONST, new Num(1), r_temp2));
        operations.add(new Op(OpCode.loadCONST, new Num(1), r_result));
        operations.add(new Op(OpCode.pop, r_exponent)); //exponent
        operations.add(new Op(OpCode.pop, r_load)); //base

        operations.add(new Op(OpCode.computeEQUAL, r_exponent, new Reg("0"), r_temp1));
        operations.add(new Op(OpCode.branchREL, r_temp1, new Num(10))); // jump to end of this all
        operations.add(new Op(OpCode.loadCONST, new Num(1), r_temp1));
        operations.add(new Op(OpCode.computeAND, r_exponent, r_temp1, r_temp1));


        operations.add(new Op(OpCode.computeXOR, r_temp2, r_temp1, r_temp1));   // invert condition

        operations.add(new Op(OpCode.branchREL, r_temp1, new Num(2)));              //jump to the end of result mult
        operations.add(new Op(OpCode.computeMUL, r_result, r_base, r_result));
        operations.add(new Op(OpCode.computeRSHIFT, r_exponent, r_temp2, r_exponent));
        operations.add(new Op(OpCode.computeMUL, r_base, r_base, r_base));

        operations.add(new Op(OpCode.loadCONST, new Num(-10), r_temp1));
        operations.add(new Op(OpCode.jumpREL, new Num(-10)));
        operations.add(new Op(OpCode.push, r_result));


        return operations;
    }

    /**
     *  Returns all instructions from the flow, and assigns the result to a variable.
     * @param ctx Current node.
     * @return List of instructions.
     */
    @Override @Deprecated
    public List<Op> visitAssignstandardflow(BoogyQParser.AssignstandardflowContext ctx) {
        List<Reg> flowRegList = regsList.get(ctx);
        regsList.put(ctx.flow(), flowRegList);
        Reg r_res =  regsList.get(ctx).get(regsList.get(ctx).size()-1);

        List<Op> operations = visit(ctx.flow());

        int offset;
        boolean global;
        if (Divider.globalSymbolTable.contains(ctx.ID().getText())) {
            global = true;
            offset = Divider.globalSymbolTable.get(ctx.ID().getText());
        } else {
            global = false;
            offset = symbolTable.get(ctx.ID().getText());
        }

        operations.add(new Op(OpCode.loadCONST, new Num(offset), r_load));

        if (!global) {
            operations.add(new Op(OpCode.storeINDA, r_res, r_load));
        } else {
            operations.add(new Op(OpCode.writeINDA, r_res, r_load));
            operations.add(new Op(OpCode.readINDA, r_load));
            operations.add(new Op(OpCode.receive, r_res));
        }

        return operations;
    }

    /**
     * Reserves a memory location for a new variable, and writes the default value to it.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
    public List<Op> visitDeclexpr(BoogyQParser.DeclexprContext ctx) {
        List<Op> operations = new ArrayList<>();
        String id = ctx.ID().getText();
        String type = ctx.PRIMITIVE().getText();
        if (ctx.REACH()==null || !ctx.REACH().getText().equals("global")) {
            symbolTable.add(id, false);
            if (defaultValues.get(type).getValue() != 0) {
                operations.add(new Op(OpCode.loadCONST, defaultValues.get(type), r_standard));
                operations.add(new Op(OpCode.loadCONST, new Num(symbolTable.get(id)), r_load));
                operations.add(new Op(OpCode.storeINDA, r_standard, r_load));
            } else {
                operations.add(new Op(OpCode.loadCONST, new Num(symbolTable.get(id)), r_load));
                operations.add(new Op(OpCode.storeINDA, new Reg("0"), r_load));
            }
            operations.add(new Op(OpCode.push, r_standard));
        } else {
            Divider.globalSymbolTable.add(id, true);
            symbolTable.add(id, true);
            if (defaultValues.get(type).getValue() != 0) {
                operations.add(new Op(OpCode.loadCONST, defaultValues.get(type), r_standard));
                operations.add(new Op(OpCode.loadCONST, new Num(symbolTable.get(id)), r_load));
                operations.add(new Op(OpCode.writeINDA, r_standard, r_load));
                operations.add(new Op(OpCode.readINDA, r_load));
                operations.add(new Op(OpCode.receive, r_standard));// wait till fully written
            } else {
                operations.add(new Op(OpCode.loadCONST, new Num(symbolTable.get(id)), r_load));
                operations.add(new Op(OpCode.writeINDA, new Reg("0"), r_load));
                operations.add(new Op(OpCode.readINDA, r_load));
                operations.add(new Op(OpCode.receive, r_standard));// wait till fully written
            }
            operations.add(new Op(OpCode.push, r_standard));
        }
        return operations;
    }

    /**
     * Evaluates the flow, reserves a memory location for a new variable, and writes the default value to it.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
    public List<Op> visitDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx) {
        List<Reg> flowRegList = regsList.get(ctx);
        regsList.put(ctx.flow(), flowRegList);

        Reg r_res =  regsList.get(ctx).get(regsList.get(ctx).size()-1);

        List<Op> operations = visit(ctx.flow());
        String id = ctx.ID().getText();

        if (ctx.REACH() == null || !ctx.REACH().getText().equals("global")) {
            symbolTable.add(id, false);
            int offset = symbolTable.get(id);

            operations.add(new Op(OpCode.loadCONST, new Num(offset), r_load));
            operations.add(new Op(OpCode.storeINDA, r_res, r_load));
        } else {
            symbolTable.add(id, true);
            Divider.globalSymbolTable.add(id, true);
            int offset = symbolTable.get(id);
            operations.add(new Op(OpCode.loadCONST, new Num(offset), r_load));
            operations.add(new Op(OpCode.writeINDA, r_res, r_load));
            operations.add(new Op(OpCode.readINDA, r_load));
            operations.add(new Op(OpCode.receive, r_standard));// wait till fully written
        }
        return operations;
    }

    /**
     * Returns all instructions needed to return this variable.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
    public List<Op> visitIdenexpr(BoogyQParser.IdenexprContext ctx) {
        String id = ctx.ID().getText();
        List<Op> operations = new ArrayList<>();

        int offset;
        boolean global;
        if (Divider.globalSymbolTable.contains(id)) {
            global = true;
            offset = Divider.globalSymbolTable.get(id);
        } else {
            global = false;
            offset = symbolTable.get(id);
        }

        operations.add(new Op(OpCode.loadCONST, new Num(offset), r_load));

        if (!global) {
            operations.add(new Op(OpCode.loadINDA, r_load, r_load));
        } else {
            operations.add(new Op(OpCode.readINDA, r_load));
            operations.add(new Op(OpCode.receive, r_load));
        }
        operations.add(new Op(OpCode.push, r_load));
        return operations;
    }

    /**
     * Evalues the expression and writes it to the correct register.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
    public List<Op> visitIgnoreme(BoogyQParser.IgnoremeContext ctx) {
        List<Reg> flowRegList = regsList.get(ctx);
        regsList.put(ctx.expr(), flowRegList);
        Reg r_res =  regsList.get(ctx).get(regsList.get(ctx).size()-1);
        List<Op> operations = visit(ctx.expr());

        operations.add(new Op(OpCode.pop, r_res));
        return operations;
    }

    /**
     * Evaluates the left an right expression, pops both off the stack and performs the operation.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
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

        operations.add(new Op(OpCode.pop, r_standard));
        operations.add(new Op(OpCode.pop, r_1));
        operations.add(new Op(OpCode.computeMUL, r_1, r_standard, r_1));
                operations.add(new Op(OpCode.push, r_1));
        return operations;
    }

    /**
     * Evaluates the left an right expression, pops both off the stack and performs the operation.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
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

        operations.add(new Op(OpCode.pop, r_standard));
        operations.add(new Op(OpCode.pop, r_1));
        if (ctx.getChild(1).getText().equals("+")) {
            operations.add(new Op(OpCode.computeADD, r_1, r_standard, r_1));
        } else {
            operations.add(new Op(OpCode.computeSUB, r_1, r_standard, r_1));
        }
                operations.add(new Op(OpCode.push, r_1));
        return operations;
        }

    /**
     * Evalues the nested expression and negates it.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
    public List<Op> visitMinusexpr(BoogyQParser.MinusexprContext ctx) {
        BoogyQParser.ExprContext leftexpr = ctx.expr();
        List<Reg> exprRegList = regsList.get(ctx).subList(0, regCount.get(leftexpr));
        regsList.put(leftexpr, exprRegList);
        List<Op> operations = visit(leftexpr);
        operations.add(new Op(OpCode.pop, r_standard));
        operations.add(new Op(OpCode.computeSUB, new Reg("0") , r_standard, r_standard));
        operations.add(new Op(OpCode.push, r_standard));
        return operations;
    }

    /**
     * Evalues the nested expression and inverts it.
     * @param ctx Current node.
     * @return List of operations.
     */
    @Override @Deprecated
    public List<Op> visitNotexpr(BoogyQParser.NotexprContext ctx) {
        BoogyQParser.ExprContext leftexpr = ctx.expr();

        List<Reg> exprRegList = regsList.get(ctx).subList(0, regCount.get(leftexpr));
        Reg r_1 = r_load; //Niet exprRegList.get(0) want exprRegList kan een lege lijst zijn.

        regsList.put(leftexpr, exprRegList);
        List<Op> operations = visit(leftexpr);

        operations.add(new Op(OpCode.pop, r_1));
        operations.add(new Op(OpCode.loadCONST, new Num(1), r_standard));
        operations.add(new Op(OpCode.computeXOR, r_standard, r_1, r_1));
                operations.add(new Op(OpCode.push, r_1));
        return operations;
    }
}
