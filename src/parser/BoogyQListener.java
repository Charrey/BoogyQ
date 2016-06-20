// Generated from C:/Users/poesd_000/IdeaProjects/second/BoogyQ/src\BoogyQ.g4 by ANTLR 4.5.3
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BoogyQParser}.
 */
interface BoogyQListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by the {@code functiondecl}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFunctiondecl(BoogyQParser.FunctiondeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functiondecl}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFunctiondecl(BoogyQParser.FunctiondeclContext ctx);
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
	 * Enter a parse tree produced by the {@code concurrentstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterConcurrentstat(BoogyQParser.ConcurrentstatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code concurrentstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitConcurrentstat(BoogyQParser.ConcurrentstatContext ctx);
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
	 * Enter a parse tree produced by the {@code emptystat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptystat(BoogyQParser.EmptystatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptystat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptystat(BoogyQParser.EmptystatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code commentstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCommentstat(BoogyQParser.CommentstatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code commentstat}
	 * labeled alternative in {@link BoogyQParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCommentstat(BoogyQParser.CommentstatContext ctx);
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
	 * Enter a parse tree produced by {@link BoogyQParser#functionvars}.
	 * @param ctx the parse tree
	 */
	void enterFunctionvars(BoogyQParser.FunctionvarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoogyQParser#functionvars}.
	 * @param ctx the parse tree
	 */
	void exitFunctionvars(BoogyQParser.FunctionvarsContext ctx);
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
	 * Enter a parse tree produced by the {@code assigngeneratorflow}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 */
	void enterAssigngeneratorflow(BoogyQParser.AssigngeneratorflowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assigngeneratorflow}
	 * labeled alternative in {@link BoogyQParser#flow}.
	 * @param ctx the parse tree
	 */
	void exitAssigngeneratorflow(BoogyQParser.AssigngeneratorflowContext ctx);
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
	 * Enter a parse tree produced by the {@code boolexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolexpr(BoogyQParser.BoolexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolexpr(BoogyQParser.BoolexprContext ctx);
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
	 * Enter a parse tree produced by the {@code charexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCharexpr(BoogyQParser.CharexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charexpr}
	 * labeled alternative in {@link BoogyQParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCharexpr(BoogyQParser.CharexprContext ctx);
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
	 * Enter a parse tree produced by {@link BoogyQParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEquality(BoogyQParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoogyQParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEquality(BoogyQParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoogyQParser#inequality}.
	 * @param ctx the parse tree
	 */
	void enterInequality(BoogyQParser.InequalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoogyQParser#inequality}.
	 * @param ctx the parse tree
	 */
	void exitInequality(BoogyQParser.InequalityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code presetarray}
	 * labeled alternative in {@link BoogyQParser#array}.
	 * @param ctx the parse tree
	 */
	void enterPresetarray(BoogyQParser.PresetarrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code presetarray}
	 * labeled alternative in {@link BoogyQParser#array}.
	 * @param ctx the parse tree
	 */
	void exitPresetarray(BoogyQParser.PresetarrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiarray}
	 * labeled alternative in {@link BoogyQParser#array}.
	 * @param ctx the parse tree
	 */
	void enterMultiarray(BoogyQParser.MultiarrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiarray}
	 * labeled alternative in {@link BoogyQParser#array}.
	 * @param ctx the parse tree
	 */
	void exitMultiarray(BoogyQParser.MultiarrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoogyQParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(BoogyQParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoogyQParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(BoogyQParser.CommentContext ctx);
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