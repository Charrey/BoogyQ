// Generated from C:/Users/jij/IdeaProjects/BoogyQ/src\BoogyQ.g4 by ANTLR 4.5.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BoogyQParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BoogyQVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BoogyQParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(BoogyQParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(BoogyQParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlow(BoogyQParser.FlowContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(BoogyQParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoogyQParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(BoogyQParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoogyQParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(BoogyQParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoogyQParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(BoogyQParser.TypeContext ctx);
}