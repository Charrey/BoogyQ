// Generated from C:/Users/Administrator/IdeaProjects/BoogyQ/src\BoogyQ.g4 by ANTLR 4.5.1
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
	 * Enter a parse tree produced by the {@code ifstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfstat(BoogyQParser.IfstatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfstat(BoogyQParser.IfstatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code flowstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFlowstat(BoogyQParser.FlowstatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code flowstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFlowstat(BoogyQParser.FlowstatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loopstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLoopstat(BoogyQParser.LoopstatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loopstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLoopstat(BoogyQParser.LoopstatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakstat(BoogyQParser.BreakstatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakstat(BoogyQParser.BreakstatContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoogyQParser#openscope}.
	 * @param ctx the parse tree
	 */
	void enterOpenscope(BoogyQParser.OpenscopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoogyQParser#openscope}.
	 * @param ctx the parse tree
	 */
	void exitOpenscope(BoogyQParser.OpenscopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoogyQParser#closescope}.
	 * @param ctx the parse tree
	 */
	void enterClosescope(BoogyQParser.ClosescopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoogyQParser#closescope}.
	 * @param ctx the parse tree
	 */
	void exitClosescope(BoogyQParser.ClosescopeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignfunctionflow}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 */
	void enterAssignfunctionflow(BoogyQParser.AssignfunctionflowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignfunctionflow}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 */
	void exitAssignfunctionflow(BoogyQParser.AssignfunctionflowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignstandardflow}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 */
	void enterAssignstandardflow(BoogyQParser.AssignstandardflowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignstandardflow}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 */
	void exitAssignstandardflow(BoogyQParser.AssignstandardflowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ignoreme}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 */
	void enterIgnoreme(BoogyQParser.IgnoremeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ignoreme}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 */
	void exitIgnoreme(BoogyQParser.IgnoremeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declstandardflow}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 */
	void enterDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declstandardflow}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 */
	void exitDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declfunctionflow}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 */
	void enterDeclfunctionflow(BoogyQParser.DeclfunctionflowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declfunctionflow}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 */
	void exitDeclfunctionflow(BoogyQParser.DeclfunctionflowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlusexpr(BoogyQParser.PlusexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlusexpr(BoogyQParser.PlusexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotexpr(BoogyQParser.NotexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotexpr(BoogyQParser.NotexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andorexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndorexpr(BoogyQParser.AndorexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andorexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndorexpr(BoogyQParser.AndorexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minusexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMinusexpr(BoogyQParser.MinusexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minusexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMinusexpr(BoogyQParser.MinusexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powerexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowerexpr(BoogyQParser.PowerexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powerexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowerexpr(BoogyQParser.PowerexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDeclexpr(BoogyQParser.DeclexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDeclexpr(BoogyQParser.DeclexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparatorexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparatorexpr(BoogyQParser.ComparatorexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparatorexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparatorexpr(BoogyQParser.ComparatorexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idenexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdenexpr(BoogyQParser.IdenexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idenexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdenexpr(BoogyQParser.IdenexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberexpr(BoogyQParser.NumberexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberexpr(BoogyQParser.NumberexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timesexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTimesexpr(BoogyQParser.TimesexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timesexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTimesexpr(BoogyQParser.TimesexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arraydecl}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArraydecl(BoogyQParser.ArraydeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arraydecl}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArraydecl(BoogyQParser.ArraydeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code flowexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFlowexpr(BoogyQParser.FlowexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code flowexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFlowexpr(BoogyQParser.FlowexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoogyQParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(BoogyQParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoogyQParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(BoogyQParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoogyQParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(BoogyQParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoogyQParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(BoogyQParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoogyQParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(BoogyQParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoogyQParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(BoogyQParser.TypeContext ctx);
}