// Generated from C:/Users/Administrator/IdeaProjects/BoogyQ/src\BoogyQ.g4 by ANTLR 4.5.1
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoogyQParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, PRIMITIVE=8, IF=9, 
		CONCURRENT=10, FUNCTION=11, OPENSCOPE=12, CLOSESCOPE=13, LOOP=14, BREAK=15, 
		REACH=16, BOOL=17, ID=18, NUMBER=19, CHAR=20, DEL=21, LPAR=22, RPAR=23, 
		COLON=24, TAB=25, NEWLINE=26, WS=27, HAT=28, TIMES=29, DIVIDE=30, PLUS=31, 
		MINUS=32, AND=33, OR=34, COMP_EQ=35, COMP_NE=36, COMP_LE=37, COMP_LT=38, 
		COMP_GE=39, COMP_GT=40, NEGATION=41, PLACEOPR=42, PIPEOPR=43;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_openscope = 2, RULE_closescope = 3, 
		RULE_functionvars = 4, RULE_flow = 5, RULE_expr = 6, RULE_equality = 7, 
		RULE_inequality = 8, RULE_array = 9, RULE_comment = 10, RULE_type = 11;
	public static final String[] ruleNames = {
		"program", "statement", "openscope", "closescope", "functionvars", "flow", 
		"expr", "equality", "inequality", "array", "comment", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "','", "'['", "']'", "'//'", "'[]'", null, "'if'", 
		"'concurrent'", "'function'", "'OPENSCOPE'", "'CLOSESCOPE'", "'loop'", 
		"'break'", null, null, null, null, null, "'.'", "'('", "')'", "':'", "'\t'", 
		"'\n'", "' '", "'^'", "'*'", "'/'", "'+'", "'-'", "'&&'", "'||'", "'=='", 
		"'!='", "'<='", "'<'", "'>='", "'>'", "'!'", "'->'", "'=>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "PRIMITIVE", "IF", "CONCURRENT", 
		"FUNCTION", "OPENSCOPE", "CLOSESCOPE", "LOOP", "BREAK", "REACH", "BOOL", 
		"ID", "NUMBER", "CHAR", "DEL", "LPAR", "RPAR", "COLON", "TAB", "NEWLINE", 
		"WS", "HAT", "TIMES", "DIVIDE", "PLUS", "MINUS", "AND", "OR", "COMP_EQ", 
		"COMP_NE", "COMP_LE", "COMP_LT", "COMP_GE", "COMP_GT", "NEGATION", "PLACEOPR", 
		"PIPEOPR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "BoogyQ.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BoogyQParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode EOF() { return getToken(BoogyQParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(BoogyQParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(BoogyQParser.NEWLINE, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(24);
				match(NEWLINE);
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(30);
					statement(0);
					setState(32); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(31);
						match(NEWLINE);
						}
						}
						setState(34); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(41);
			statement(0);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(42);
				match(NEWLINE);
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfstatContext extends StatementContext {
		public TerminalNode IF() { return getToken(BoogyQParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(BoogyQParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(BoogyQParser.RPAR, 0); }
		public TerminalNode COLON() { return getToken(BoogyQParser.COLON, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(BoogyQParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(BoogyQParser.NEWLINE, i);
		}
		public OpenscopeContext openscope() {
			return getRuleContext(OpenscopeContext.class,0);
		}
		public ClosescopeContext closescope() {
			return getRuleContext(ClosescopeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfstatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterIfstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitIfstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitIfstat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctiondeclContext extends StatementContext {
		public TerminalNode FUNCTION() { return getToken(BoogyQParser.FUNCTION, 0); }
		public TerminalNode LPAR() { return getToken(BoogyQParser.LPAR, 0); }
		public FunctionvarsContext functionvars() {
			return getRuleContext(FunctionvarsContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(BoogyQParser.RPAR, 0); }
		public TerminalNode ID() { return getToken(BoogyQParser.ID, 0); }
		public TerminalNode COLON() { return getToken(BoogyQParser.COLON, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(BoogyQParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(BoogyQParser.NEWLINE, i);
		}
		public OpenscopeContext openscope() {
			return getRuleContext(OpenscopeContext.class,0);
		}
		public ClosescopeContext closescope() {
			return getRuleContext(ClosescopeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctiondeclContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterFunctiondecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitFunctiondecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitFunctiondecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoopstatContext extends StatementContext {
		public TerminalNode LOOP() { return getToken(BoogyQParser.LOOP, 0); }
		public TerminalNode NUMBER() { return getToken(BoogyQParser.NUMBER, 0); }
		public TerminalNode DEL() { return getToken(BoogyQParser.DEL, 0); }
		public LoopstatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterLoopstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitLoopstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitLoopstat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConcurrentstatContext extends StatementContext {
		public TerminalNode CONCURRENT() { return getToken(BoogyQParser.CONCURRENT, 0); }
		public TerminalNode COLON() { return getToken(BoogyQParser.COLON, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(BoogyQParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(BoogyQParser.NEWLINE, i);
		}
		public OpenscopeContext openscope() {
			return getRuleContext(OpenscopeContext.class,0);
		}
		public ClosescopeContext closescope() {
			return getRuleContext(ClosescopeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ConcurrentstatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterConcurrentstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitConcurrentstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitConcurrentstat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FlowstatContext extends StatementContext {
		public TerminalNode DEL() { return getToken(BoogyQParser.DEL, 0); }
		public FlowContext flow() {
			return getRuleContext(FlowContext.class,0);
		}
		public FlowstatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterFlowstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitFlowstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitFlowstat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BarecommentContext extends StatementContext {
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public BarecommentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterBarecomment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitBarecomment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitBarecomment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CommentstatContext extends StatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public CommentstatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterCommentstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitCommentstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitCommentstat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakstatContext extends StatementContext {
		public TerminalNode BREAK() { return getToken(BoogyQParser.BREAK, 0); }
		public TerminalNode NUMBER() { return getToken(BoogyQParser.NUMBER, 0); }
		public TerminalNode DEL() { return getToken(BoogyQParser.DEL, 0); }
		public BreakstatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterBreakstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitBreakstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitBreakstat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		return statement(0);
	}

	private StatementContext statement(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementContext _localctx = new StatementContext(_ctx, _parentState);
		StatementContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_statement, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			switch (_input.LA(1)) {
			case IF:
				{
				_localctx = new IfstatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(51);
				match(IF);
				setState(52);
				match(LPAR);
				setState(53);
				expr(0);
				setState(54);
				match(RPAR);
				setState(55);
				match(COLON);
				setState(56);
				match(NEWLINE);
				setState(57);
				openscope();
				setState(58);
				match(NEWLINE);
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__5) | (1L << PRIMITIVE) | (1L << IF) | (1L << CONCURRENT) | (1L << FUNCTION) | (1L << LOOP) | (1L << BREAK) | (1L << REACH) | (1L << BOOL) | (1L << ID) | (1L << NUMBER) | (1L << CHAR) | (1L << DEL) | (1L << LPAR) | (1L << MINUS) | (1L << NEGATION) | (1L << PIPEOPR))) != 0)) {
					{
					{
					setState(59);
					statement(0);
					setState(60);
					match(NEWLINE);
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(67);
				closescope();
				}
				break;
			case FUNCTION:
				{
				_localctx = new FunctiondeclContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				match(FUNCTION);
				setState(70);
				match(LPAR);
				setState(71);
				functionvars();
				setState(72);
				match(RPAR);
				setState(73);
				match(ID);
				setState(74);
				match(COLON);
				setState(75);
				match(NEWLINE);
				setState(76);
				openscope();
				setState(77);
				match(NEWLINE);
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__5) | (1L << PRIMITIVE) | (1L << IF) | (1L << CONCURRENT) | (1L << FUNCTION) | (1L << LOOP) | (1L << BREAK) | (1L << REACH) | (1L << BOOL) | (1L << ID) | (1L << NUMBER) | (1L << CHAR) | (1L << DEL) | (1L << LPAR) | (1L << MINUS) | (1L << NEGATION) | (1L << PIPEOPR))) != 0)) {
					{
					{
					setState(78);
					statement(0);
					setState(79);
					match(NEWLINE);
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(86);
				closescope();
				}
				break;
			case CONCURRENT:
				{
				_localctx = new ConcurrentstatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				match(CONCURRENT);
				setState(89);
				match(COLON);
				setState(90);
				match(NEWLINE);
				setState(91);
				openscope();
				setState(92);
				match(NEWLINE);
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__5) | (1L << PRIMITIVE) | (1L << IF) | (1L << CONCURRENT) | (1L << FUNCTION) | (1L << LOOP) | (1L << BREAK) | (1L << REACH) | (1L << BOOL) | (1L << ID) | (1L << NUMBER) | (1L << CHAR) | (1L << DEL) | (1L << LPAR) | (1L << MINUS) | (1L << NEGATION) | (1L << PIPEOPR))) != 0)) {
					{
					{
					setState(93);
					statement(0);
					setState(94);
					match(NEWLINE);
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(101);
				closescope();
				}
				break;
			case T__0:
			case T__3:
			case PRIMITIVE:
			case REACH:
			case BOOL:
			case ID:
			case NUMBER:
			case CHAR:
			case DEL:
			case LPAR:
			case MINUS:
			case NEGATION:
			case PIPEOPR:
				{
				_localctx = new FlowstatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << PRIMITIVE) | (1L << REACH) | (1L << BOOL) | (1L << ID) | (1L << NUMBER) | (1L << CHAR) | (1L << LPAR) | (1L << MINUS) | (1L << NEGATION) | (1L << PIPEOPR))) != 0)) {
					{
					setState(103);
					flow(0);
					}
				}

				setState(106);
				match(DEL);
				}
				break;
			case LOOP:
				{
				_localctx = new LoopstatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(107);
				match(LOOP);
				setState(108);
				match(T__0);
				setState(109);
				match(NUMBER);
				setState(110);
				match(T__1);
				setState(111);
				match(DEL);
				}
				break;
			case BREAK:
				{
				_localctx = new BreakstatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112);
				match(BREAK);
				setState(113);
				match(T__0);
				setState(114);
				match(NUMBER);
				setState(115);
				match(T__1);
				setState(116);
				match(DEL);
				}
				break;
			case T__5:
				{
				_localctx = new BarecommentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				comment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CommentstatContext(new StatementContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_statement);
					setState(120);
					if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
					setState(121);
					comment();
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class OpenscopeContext extends ParserRuleContext {
		public TerminalNode OPENSCOPE() { return getToken(BoogyQParser.OPENSCOPE, 0); }
		public OpenscopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_openscope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterOpenscope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitOpenscope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitOpenscope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpenscopeContext openscope() throws RecognitionException {
		OpenscopeContext _localctx = new OpenscopeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_openscope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(OPENSCOPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClosescopeContext extends ParserRuleContext {
		public TerminalNode CLOSESCOPE() { return getToken(BoogyQParser.CLOSESCOPE, 0); }
		public ClosescopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closescope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterClosescope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitClosescope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitClosescope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClosescopeContext closescope() throws RecognitionException {
		ClosescopeContext _localctx = new ClosescopeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_closescope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(CLOSESCOPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionvarsContext extends ParserRuleContext {
		public TerminalNode PLACEOPR() { return getToken(BoogyQParser.PLACEOPR, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(BoogyQParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(BoogyQParser.ID, i);
		}
		public FunctionvarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionvars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterFunctionvars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitFunctionvars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitFunctionvars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionvarsContext functionvars() throws RecognitionException {
		FunctionvarsContext _localctx = new FunctionvarsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionvars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_la = _input.LA(1);
			if (_la==PRIMITIVE) {
				{
				{
				setState(131);
				type();
				setState(132);
				match(ID);
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(134);
					match(T__2);
					setState(135);
					type();
					setState(136);
					match(ID);
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(145);
			match(PLACEOPR);
			setState(146);
			type();
			setState(147);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlowContext extends ParserRuleContext {
		public FlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flow; }
	 
		public FlowContext() { }
		public void copyFrom(FlowContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignfunctionflowContext extends FlowContext {
		public List<FlowContext> flow() {
			return getRuleContexts(FlowContext.class);
		}
		public FlowContext flow(int i) {
			return getRuleContext(FlowContext.class,i);
		}
		public TerminalNode PIPEOPR() { return getToken(BoogyQParser.PIPEOPR, 0); }
		public TerminalNode ID() { return getToken(BoogyQParser.ID, 0); }
		public AssignfunctionflowContext(FlowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterAssignfunctionflow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitAssignfunctionflow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitAssignfunctionflow(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignstandardflowContext extends FlowContext {
		public FlowContext flow() {
			return getRuleContext(FlowContext.class,0);
		}
		public TerminalNode PLACEOPR() { return getToken(BoogyQParser.PLACEOPR, 0); }
		public TerminalNode ID() { return getToken(BoogyQParser.ID, 0); }
		public AssignstandardflowContext(FlowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterAssignstandardflow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitAssignstandardflow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitAssignstandardflow(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IgnoremeContext extends FlowContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IgnoremeContext(FlowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterIgnoreme(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitIgnoreme(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitIgnoreme(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclstandardflowContext extends FlowContext {
		public FlowContext flow() {
			return getRuleContext(FlowContext.class,0);
		}
		public TerminalNode PLACEOPR() { return getToken(BoogyQParser.PLACEOPR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(BoogyQParser.ID, 0); }
		public TerminalNode REACH() { return getToken(BoogyQParser.REACH, 0); }
		public DeclstandardflowContext(FlowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterDeclstandardflow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitDeclstandardflow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitDeclstandardflow(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssigngeneratorflowContext extends FlowContext {
		public TerminalNode PIPEOPR() { return getToken(BoogyQParser.PIPEOPR, 0); }
		public TerminalNode ID() { return getToken(BoogyQParser.ID, 0); }
		public AssigngeneratorflowContext(FlowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterAssigngeneratorflow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitAssigngeneratorflow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitAssigngeneratorflow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FlowContext flow() throws RecognitionException {
		return flow(0);
	}

	private FlowContext flow(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FlowContext _localctx = new FlowContext(_ctx, _parentState);
		FlowContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_flow, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			switch (_input.LA(1)) {
			case PIPEOPR:
				{
				_localctx = new AssigngeneratorflowContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(150);
				match(PIPEOPR);
				setState(151);
				match(ID);
				}
				break;
			case T__0:
			case T__3:
			case PRIMITIVE:
			case REACH:
			case BOOL:
			case ID:
			case NUMBER:
			case CHAR:
			case LPAR:
			case MINUS:
			case NEGATION:
				{
				_localctx = new IgnoremeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(176);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new AssignstandardflowContext(new FlowContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_flow);
						setState(155);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(156);
						match(PLACEOPR);
						setState(157);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new DeclstandardflowContext(new FlowContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_flow);
						setState(158);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(159);
						match(PLACEOPR);
						setState(161);
						_la = _input.LA(1);
						if (_la==REACH) {
							{
							setState(160);
							match(REACH);
							}
						}

						setState(163);
						type();
						setState(164);
						match(ID);
						}
						break;
					case 3:
						{
						_localctx = new AssignfunctionflowContext(new FlowContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_flow);
						setState(166);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(171);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(167);
							match(T__2);
							setState(168);
							flow(0);
							}
							}
							setState(173);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(174);
						match(PIPEOPR);
						setState(175);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PlusexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(BoogyQParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BoogyQParser.MINUS, 0); }
		public PlusexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterPlusexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitPlusexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitPlusexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotexprContext extends ExprContext {
		public TerminalNode NEGATION() { return getToken(BoogyQParser.NEGATION, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterNotexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitNotexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitNotexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclexprContext extends ExprContext {
		public TerminalNode PRIMITIVE() { return getToken(BoogyQParser.PRIMITIVE, 0); }
		public TerminalNode ID() { return getToken(BoogyQParser.ID, 0); }
		public TerminalNode REACH() { return getToken(BoogyQParser.REACH, 0); }
		public DeclexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterDeclexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitDeclexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitDeclexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolexprContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(BoogyQParser.BOOL, 0); }
		public BoolexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterBoolexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitBoolexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitBoolexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndorexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(BoogyQParser.AND, 0); }
		public TerminalNode OR() { return getToken(BoogyQParser.OR, 0); }
		public AndorexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterAndorexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitAndorexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitAndorexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusexprContext extends ExprContext {
		public TerminalNode MINUS() { return getToken(BoogyQParser.MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MinusexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterMinusexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitMinusexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitMinusexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowerexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode HAT() { return getToken(BoogyQParser.HAT, 0); }
		public PowerexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterPowerexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitPowerexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitPowerexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharexprContext extends ExprContext {
		public TerminalNode CHAR() { return getToken(BoogyQParser.CHAR, 0); }
		public CharexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterCharexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitCharexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitCharexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparatorexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public InequalityContext inequality() {
			return getRuleContext(InequalityContext.class,0);
		}
		public ComparatorexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterComparatorexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitComparatorexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitComparatorexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdenexprContext extends ExprContext {
		public TerminalNode ID() { return getToken(BoogyQParser.ID, 0); }
		public IdenexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterIdenexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitIdenexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitIdenexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberexprContext extends ExprContext {
		public TerminalNode NUMBER() { return getToken(BoogyQParser.NUMBER, 0); }
		public NumberexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterNumberexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitNumberexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitNumberexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TimesexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TIMES() { return getToken(BoogyQParser.TIMES, 0); }
		public TerminalNode DIVIDE() { return getToken(BoogyQParser.DIVIDE, 0); }
		public TimesexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterTimesexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitTimesexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitTimesexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArraydeclContext extends ExprContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArraydeclContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterArraydecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitArraydecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitArraydecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FlowexprContext extends ExprContext {
		public TerminalNode LPAR() { return getToken(BoogyQParser.LPAR, 0); }
		public FlowContext flow() {
			return getRuleContext(FlowContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(BoogyQParser.RPAR, 0); }
		public FlowexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterFlowexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitFlowexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitFlowexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			switch (_input.LA(1)) {
			case NEGATION:
				{
				_localctx = new NotexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(182);
				match(NEGATION);
				setState(183);
				expr(7);
				}
				break;
			case MINUS:
				{
				_localctx = new MinusexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				match(MINUS);
				setState(185);
				expr(6);
				}
				break;
			case BOOL:
				{
				_localctx = new BoolexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				match(BOOL);
				}
				break;
			case ID:
				{
				_localctx = new IdenexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(ID);
				}
				break;
			case PRIMITIVE:
			case REACH:
				{
				_localctx = new DeclexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189);
				_la = _input.LA(1);
				if (_la==REACH) {
					{
					setState(188);
					match(REACH);
					}
				}

				setState(191);
				match(PRIMITIVE);
				setState(192);
				match(ID);
				}
				break;
			case CHAR:
				{
				_localctx = new CharexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(CHAR);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumberexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				match(NUMBER);
				}
				break;
			case T__0:
			case T__3:
				{
				_localctx = new ArraydeclContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				array();
				}
				break;
			case LPAR:
				{
				_localctx = new FlowexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				match(LPAR);
				setState(197);
				flow(0);
				setState(198);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(221);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new PowerexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(202);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(203);
						match(HAT);
						setState(204);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new TimesexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(205);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(206);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIVIDE) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(207);
						expr(5);
						}
						break;
					case 3:
						{
						_localctx = new PlusexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(208);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(209);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(210);
						expr(4);
						}
						break;
					case 4:
						{
						_localctx = new ComparatorexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(211);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(214);
						switch (_input.LA(1)) {
						case COMP_EQ:
						case COMP_NE:
							{
							setState(212);
							equality();
							}
							break;
						case COMP_LE:
						case COMP_LT:
						case COMP_GE:
						case COMP_GT:
							{
							setState(213);
							inequality();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(216);
						expr(3);
						}
						break;
					case 5:
						{
						_localctx = new AndorexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(218);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(219);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(220);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityContext extends ParserRuleContext {
		public TerminalNode COMP_EQ() { return getToken(BoogyQParser.COMP_EQ, 0); }
		public TerminalNode COMP_NE() { return getToken(BoogyQParser.COMP_NE, 0); }
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_equality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_la = _input.LA(1);
			if ( !(_la==COMP_EQ || _la==COMP_NE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InequalityContext extends ParserRuleContext {
		public TerminalNode COMP_LE() { return getToken(BoogyQParser.COMP_LE, 0); }
		public TerminalNode COMP_LT() { return getToken(BoogyQParser.COMP_LT, 0); }
		public TerminalNode COMP_GE() { return getToken(BoogyQParser.COMP_GE, 0); }
		public TerminalNode COMP_GT() { return getToken(BoogyQParser.COMP_GT, 0); }
		public InequalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inequality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterInequality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitInequality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitInequality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InequalityContext inequality() throws RecognitionException {
		InequalityContext _localctx = new InequalityContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_inequality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMP_LE) | (1L << COMP_LT) | (1L << COMP_GE) | (1L << COMP_GT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
	 
		public ArrayContext() { }
		public void copyFrom(ArrayContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiarrayContext extends ArrayContext {
		public TerminalNode ID() { return getToken(BoogyQParser.ID, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(BoogyQParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(BoogyQParser.NUMBER, i);
		}
		public TerminalNode BOOL() { return getToken(BoogyQParser.BOOL, 0); }
		public TerminalNode CHAR() { return getToken(BoogyQParser.CHAR, 0); }
		public List<TerminalNode> TIMES() { return getTokens(BoogyQParser.TIMES); }
		public TerminalNode TIMES(int i) {
			return getToken(BoogyQParser.TIMES, i);
		}
		public MultiarrayContext(ArrayContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterMultiarray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitMultiarray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitMultiarray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PresetarrayContext extends ArrayContext {
		public List<TerminalNode> ID() { return getTokens(BoogyQParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(BoogyQParser.ID, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(BoogyQParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(BoogyQParser.NUMBER, i);
		}
		public List<TerminalNode> BOOL() { return getTokens(BoogyQParser.BOOL); }
		public TerminalNode BOOL(int i) {
			return getToken(BoogyQParser.BOOL, i);
		}
		public PresetarrayContext(ArrayContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterPresetarray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitPresetarray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitPresetarray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_array);
		int _la;
		try {
			int _alt;
			setState(259);
			switch (_input.LA(1)) {
			case T__3:
				_localctx = new PresetarrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(T__3);
				setState(235);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(231);
					match(ID);
					}
					break;
				case NUMBER:
					{
					setState(232);
					match(NUMBER);
					}
					break;
				case BOOL:
					{
					setState(233);
					match(BOOL);
					}
					break;
				case T__2:
				case T__4:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(237);
					match(T__2);
					setState(242);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(238);
						match(ID);
						}
						break;
					case NUMBER:
						{
						setState(239);
						match(NUMBER);
						}
						break;
					case BOOL:
						{
						setState(240);
						match(BOOL);
						}
						break;
					case T__2:
					case T__4:
						{
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(248);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(249);
				match(T__4);
				}
				break;
			case T__0:
				_localctx = new MultiarrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				match(T__0);
				setState(251);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << ID) | (1L << NUMBER) | (1L << CHAR))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(252);
				match(T__1);
				setState(255); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(253);
						match(TIMES);
						setState(254);
						match(NUMBER);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(257); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentContext extends ParserRuleContext {
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_comment);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(T__5);
			setState(265);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(262);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					} 
				}
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode PRIMITIVE() { return getToken(BoogyQParser.PRIMITIVE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(PRIMITIVE);
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(269);
				match(T__6);
				}
				}
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return statement_sempred((StatementContext)_localctx, predIndex);
		case 5:
			return flow_sempred((FlowContext)_localctx, predIndex);
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean statement_sempred(StatementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		}
		return true;
	}
	private boolean flow_sempred(FlowContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-\u0116\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\6\2#\n\2\r"+
		"\2\16\2$\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\7\2.\n\2\f\2\16\2\61\13\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3A\n\3\f\3\16"+
		"\3D\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3T"+
		"\n\3\f\3\16\3W\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3c\n\3\f"+
		"\3\16\3f\13\3\3\3\3\3\3\3\5\3k\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3y\n\3\3\3\3\3\7\3}\n\3\f\3\16\3\u0080\13\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u008d\n\6\f\6\16\6\u0090\13\6\5\6"+
		"\u0092\n\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u009c\n\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7\u00a4\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00ac\n\7\f\7\16"+
		"\7\u00af\13\7\3\7\3\7\7\7\u00b3\n\7\f\7\16\7\u00b6\13\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\5\b\u00c0\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\b\u00cb\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00d9"+
		"\n\b\3\b\3\b\3\b\3\b\3\b\7\b\u00e0\n\b\f\b\16\b\u00e3\13\b\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u00ee\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u00f5\n\13\7\13\u00f7\n\13\f\13\16\13\u00fa\13\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\6\13\u0102\n\13\r\13\16\13\u0103\5\13\u0106\n\13\3\f\3"+
		"\f\7\f\u010a\n\f\f\f\16\f\u010d\13\f\3\r\3\r\7\r\u0111\n\r\f\r\16\r\u0114"+
		"\13\r\3\r\2\5\4\f\16\16\2\4\6\b\n\f\16\20\22\24\26\30\2\t\3\2\37 \3\2"+
		"!\"\3\2#$\3\2%&\3\2\'*\3\2\23\26\3\2\34\34\u013a\2\35\3\2\2\2\4x\3\2\2"+
		"\2\6\u0081\3\2\2\2\b\u0083\3\2\2\2\n\u0091\3\2\2\2\f\u009b\3\2\2\2\16"+
		"\u00ca\3\2\2\2\20\u00e4\3\2\2\2\22\u00e6\3\2\2\2\24\u0105\3\2\2\2\26\u0107"+
		"\3\2\2\2\30\u010e\3\2\2\2\32\34\7\34\2\2\33\32\3\2\2\2\34\37\3\2\2\2\35"+
		"\33\3\2\2\2\35\36\3\2\2\2\36(\3\2\2\2\37\35\3\2\2\2 \"\5\4\3\2!#\7\34"+
		"\2\2\"!\3\2\2\2#$\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2& \3\2\2\2\'"+
		"*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+/\5\4\3\2,.\7\34\2\2"+
		"-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2"+
		"\62\63\7\2\2\3\63\3\3\2\2\2\64\65\b\3\1\2\65\66\7\13\2\2\66\67\7\30\2"+
		"\2\678\5\16\b\289\7\31\2\29:\7\32\2\2:;\7\34\2\2;<\5\6\4\2<B\7\34\2\2"+
		"=>\5\4\3\2>?\7\34\2\2?A\3\2\2\2@=\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2"+
		"\2CE\3\2\2\2DB\3\2\2\2EF\5\b\5\2Fy\3\2\2\2GH\7\r\2\2HI\7\30\2\2IJ\5\n"+
		"\6\2JK\7\31\2\2KL\7\24\2\2LM\7\32\2\2MN\7\34\2\2NO\5\6\4\2OU\7\34\2\2"+
		"PQ\5\4\3\2QR\7\34\2\2RT\3\2\2\2SP\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2"+
		"\2VX\3\2\2\2WU\3\2\2\2XY\5\b\5\2Yy\3\2\2\2Z[\7\f\2\2[\\\7\32\2\2\\]\7"+
		"\34\2\2]^\5\6\4\2^d\7\34\2\2_`\5\4\3\2`a\7\34\2\2ac\3\2\2\2b_\3\2\2\2"+
		"cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\5\b\5\2hy\3\2\2\2"+
		"ik\5\f\7\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2\2ly\7\27\2\2mn\7\20\2\2no\7\3\2"+
		"\2op\7\25\2\2pq\7\4\2\2qy\7\27\2\2rs\7\21\2\2st\7\3\2\2tu\7\25\2\2uv\7"+
		"\4\2\2vy\7\27\2\2wy\5\26\f\2x\64\3\2\2\2xG\3\2\2\2xZ\3\2\2\2xj\3\2\2\2"+
		"xm\3\2\2\2xr\3\2\2\2xw\3\2\2\2y~\3\2\2\2z{\f\n\2\2{}\5\26\f\2|z\3\2\2"+
		"\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\5\3\2\2\2\u0080~\3\2\2\2"+
		"\u0081\u0082\7\16\2\2\u0082\7\3\2\2\2\u0083\u0084\7\17\2\2\u0084\t\3\2"+
		"\2\2\u0085\u0086\5\30\r\2\u0086\u0087\7\24\2\2\u0087\u008e\3\2\2\2\u0088"+
		"\u0089\7\5\2\2\u0089\u008a\5\30\r\2\u008a\u008b\7\24\2\2\u008b\u008d\3"+
		"\2\2\2\u008c\u0088\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0085\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7,\2\2\u0094"+
		"\u0095\5\30\r\2\u0095\u0096\7\24\2\2\u0096\13\3\2\2\2\u0097\u0098\b\7"+
		"\1\2\u0098\u0099\7-\2\2\u0099\u009c\7\24\2\2\u009a\u009c\5\16\b\2\u009b"+
		"\u0097\3\2\2\2\u009b\u009a\3\2\2\2\u009c\u00b4\3\2\2\2\u009d\u009e\f\7"+
		"\2\2\u009e\u009f\7,\2\2\u009f\u00b3\7\24\2\2\u00a0\u00a1\f\6\2\2\u00a1"+
		"\u00a3\7,\2\2\u00a2\u00a4\7\22\2\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\5\30\r\2\u00a6\u00a7\7\24\2\2\u00a7"+
		"\u00b3\3\2\2\2\u00a8\u00ad\f\4\2\2\u00a9\u00aa\7\5\2\2\u00aa\u00ac\5\f"+
		"\7\2\u00ab\u00a9\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7-"+
		"\2\2\u00b1\u00b3\7\24\2\2\u00b2\u009d\3\2\2\2\u00b2\u00a0\3\2\2\2\u00b2"+
		"\u00a8\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\r\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\b\b\1\2\u00b8\u00b9"+
		"\7+\2\2\u00b9\u00cb\5\16\b\t\u00ba\u00bb\7\"\2\2\u00bb\u00cb\5\16\b\b"+
		"\u00bc\u00cb\7\23\2\2\u00bd\u00cb\7\24\2\2\u00be\u00c0\7\22\2\2\u00bf"+
		"\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\7\n"+
		"\2\2\u00c2\u00cb\7\24\2\2\u00c3\u00cb\7\26\2\2\u00c4\u00cb\7\25\2\2\u00c5"+
		"\u00cb\5\24\13\2\u00c6\u00c7\7\30\2\2\u00c7\u00c8\5\f\7\2\u00c8\u00c9"+
		"\7\31\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00b7\3\2\2\2\u00ca\u00ba\3\2\2\2"+
		"\u00ca\u00bc\3\2\2\2\u00ca\u00bd\3\2\2\2\u00ca\u00bf\3\2\2\2\u00ca\u00c3"+
		"\3\2\2\2\u00ca\u00c4\3\2\2\2\u00ca\u00c5\3\2\2\2\u00ca\u00c6\3\2\2\2\u00cb"+
		"\u00e1\3\2\2\2\u00cc\u00cd\f\7\2\2\u00cd\u00ce\7\36\2\2\u00ce\u00e0\5"+
		"\16\b\b\u00cf\u00d0\f\6\2\2\u00d0\u00d1\t\2\2\2\u00d1\u00e0\5\16\b\7\u00d2"+
		"\u00d3\f\5\2\2\u00d3\u00d4\t\3\2\2\u00d4\u00e0\5\16\b\6\u00d5\u00d8\f"+
		"\4\2\2\u00d6\u00d9\5\20\t\2\u00d7\u00d9\5\22\n\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\5\16\b\5\u00db\u00e0\3"+
		"\2\2\2\u00dc\u00dd\f\3\2\2\u00dd\u00de\t\4\2\2\u00de\u00e0\5\16\b\4\u00df"+
		"\u00cc\3\2\2\2\u00df\u00cf\3\2\2\2\u00df\u00d2\3\2\2\2\u00df\u00d5\3\2"+
		"\2\2\u00df\u00dc\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\17\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\t\5\2"+
		"\2\u00e5\21\3\2\2\2\u00e6\u00e7\t\6\2\2\u00e7\23\3\2\2\2\u00e8\u00ed\7"+
		"\6\2\2\u00e9\u00ee\7\24\2\2\u00ea\u00ee\7\25\2\2\u00eb\u00ee\7\23\2\2"+
		"\u00ec\u00ee\3\2\2\2\u00ed\u00e9\3\2\2\2\u00ed\u00ea\3\2\2\2\u00ed\u00eb"+
		"\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f8\3\2\2\2\u00ef\u00f4\7\5\2\2\u00f0"+
		"\u00f5\7\24\2\2\u00f1\u00f5\7\25\2\2\u00f2\u00f5\7\23\2\2\u00f3\u00f5"+
		"\3\2\2\2\u00f4\u00f0\3\2\2\2\u00f4\u00f1\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4"+
		"\u00f3\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00ef\3\2\2\2\u00f7\u00fa\3\2"+
		"\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fb\3\2\2\2\u00fa"+
		"\u00f8\3\2\2\2\u00fb\u0106\7\7\2\2\u00fc\u00fd\7\3\2\2\u00fd\u00fe\t\7"+
		"\2\2\u00fe\u0101\7\4\2\2\u00ff\u0100\7\37\2\2\u0100\u0102\7\25\2\2\u0101"+
		"\u00ff\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2"+
		"\2\2\u0104\u0106\3\2\2\2\u0105\u00e8\3\2\2\2\u0105\u00fc\3\2\2\2\u0106"+
		"\25\3\2\2\2\u0107\u010b\7\b\2\2\u0108\u010a\n\b\2\2\u0109\u0108\3\2\2"+
		"\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\27"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0112\7\n\2\2\u010f\u0111\7\t\2\2\u0110"+
		"\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2"+
		"\2\2\u0113\31\3\2\2\2\u0114\u0112\3\2\2\2\37\35$(/BUdjx~\u008e\u0091\u009b"+
		"\u00a3\u00ad\u00b2\u00b4\u00bf\u00ca\u00d8\u00df\u00e1\u00ed\u00f4\u00f8"+
		"\u0103\u0105\u010b\u0112";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}