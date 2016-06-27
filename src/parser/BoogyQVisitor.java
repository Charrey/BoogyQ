// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/BoogyQ/src\BoogyQ.g4 by ANTLR 4.5.1
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
	 * Visit a parse tree produced by the {@code ifstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstat(BoogyQParser.IfstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functiondecl}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctiondecl(BoogyQParser.FunctiondeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loopstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopstat(BoogyQParser.LoopstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concurrentstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcurrentstat(BoogyQParser.ConcurrentstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flowstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlowstat(BoogyQParser.FlowstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commentstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentstat(BoogyQParser.CommentstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakstat(BoogyQParser.BreakstatContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoogyQParser#openscope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenscope(BoogyQParser.OpenscopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoogyQParser#closescope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosescope(BoogyQParser.ClosescopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoogyQParser#functionvars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionvars(BoogyQParser.FunctionvarsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignfunctionflow}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignfunctionflow(BoogyQParser.AssignfunctionflowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignstandardflow}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignstandardflow(BoogyQParser.AssignstandardflowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ignoreme}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreme(BoogyQParser.IgnoremeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declstandardflow}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assigngeneratorflow}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigngeneratorflow(BoogyQParser.AssigngeneratorflowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusexpr(BoogyQParser.PlusexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotexpr(BoogyQParser.NotexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclexpr(BoogyQParser.DeclexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolexpr(BoogyQParser.BoolexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andorexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndorexpr(BoogyQParser.AndorexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusexpr(BoogyQParser.MinusexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powerexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerexpr(BoogyQParser.PowerexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharexpr(BoogyQParser.CharexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparatorexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparatorexpr(BoogyQParser.ComparatorexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idenexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdenexpr(BoogyQParser.IdenexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberexpr(BoogyQParser.NumberexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timesexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimesexpr(BoogyQParser.TimesexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arraydecl}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraydecl(BoogyQParser.ArraydeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flowexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlowexpr(BoogyQParser.FlowexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoogyQParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(BoogyQParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoogyQParser#inequality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInequality(BoogyQParser.InequalityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code presetarray}
	 * labeled alternative in {@link BoogyQParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPresetarray(BoogyQParser.PresetarrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiarray}
	 * labeled alternative in {@link BoogyQParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiarray(BoogyQParser.MultiarrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoogyQParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(BoogyQParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoogyQParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(BoogyQParser.TypeContext ctx);
}