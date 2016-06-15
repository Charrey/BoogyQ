// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/BoogyQ/src\BoogyQ.g4 by ANTLR 4.5.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BoogyQParser}.
 */
public interface BoogyQListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BoogyQParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(BoogyQParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoogyQParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(BoogyQParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(BoogyQParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(BoogyQParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 */
	void enterFlow(BoogyQParser.FlowContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 */
	void exitFlow(BoogyQParser.FlowContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(BoogyQParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(BoogyQParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoogyQParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(BoogyQParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoogyQParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(BoogyQParser.OperatorContext ctx);
}