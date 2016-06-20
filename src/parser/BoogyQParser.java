// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/BoogyQ/src\BoogyQ.g4 by ANTLR 4.5.1
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
		ID=16, NUMBER=17, BOOL=18, DEL=19, LPAR=20, RPAR=21, COLON=22, TAB=23, 
		NEWLINE=24, WS=25, HAT=26, TIMES=27, DIVIDE=28, PLUS=29, MINUS=30, AND=31, 
		OR=32, COMP_EQ=33, COMP_NE=34, COMP_LE=35, COMP_LT=36, COMP_GE=37, COMP_GT=38, 
		NEGATION=39, PLACEOPR=40, PIPEOPR=41;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_openscope = 2, RULE_closescope = 3, 
		RULE_functionvars = 4, RULE_flow = 5, RULE_expr = 6, RULE_comparator = 7, 
		RULE_array = 8, RULE_comment = 9, RULE_type = 10;
	public static final String[] ruleNames = {
		"program", "statement", "openscope", "closescope", "functionvars", "flow", 
		"expr", "comparator", "array", "comment", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "','", "'['", "']'", "'//'", "'[]'", null, "'if'", 
		"'concurrent'", "'function'", "'OPENSCOPE'", "'CLOSESCOPE'", "'loop'", 
		"'break'", null, null, null, "'.'", "'('", "')'", "':'", "'\t'", "'\n'", 
		"' '", "'^'", "'*'", "'/'", "'+'", "'-'", "'&&'", "'||'", "'=='", "'!='", 
		"'<='", "'<'", "'>='", "'>'", "'!'", "'->'", "'=>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "PRIMITIVE", "IF", "CONCURRENT", 
		"FUNCTION", "OPENSCOPE", "CLOSESCOPE", "LOOP", "BREAK", "ID", "NUMBER", 
		"BOOL", "DEL", "LPAR", "RPAR", "COLON", "TAB", "NEWLINE", "WS", "HAT", 
		"TIMES", "DIVIDE", "PLUS", "MINUS", "AND", "OR", "COMP_EQ", "COMP_NE", 
		"COMP_LE", "COMP_LT", "COMP_GE", "COMP_GT", "NEGATION", "PLACEOPR", "PIPEOPR"
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(22);
					statement(0);
					setState(23);
					match(NEWLINE);
					}
					} 
				}
				setState(29);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(30);
			statement(0);
			setState(31);
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
	public static class EmptystatContext extends StatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(BoogyQParser.NEWLINE, 0); }
		public EmptystatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterEmptystat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitEmptystat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitEmptystat(this);
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
			setState(100);
			switch (_input.LA(1)) {
			case IF:
				{
				_localctx = new IfstatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(34);
				match(IF);
				setState(35);
				match(LPAR);
				setState(36);
				expr(0);
				setState(37);
				match(RPAR);
				setState(38);
				match(COLON);
				setState(39);
				match(NEWLINE);
				setState(40);
				openscope();
				setState(41);
				match(NEWLINE);
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << PRIMITIVE) | (1L << IF) | (1L << CONCURRENT) | (1L << FUNCTION) | (1L << LOOP) | (1L << BREAK) | (1L << ID) | (1L << NUMBER) | (1L << DEL) | (1L << LPAR) | (1L << MINUS) | (1L << NEGATION) | (1L << PIPEOPR))) != 0)) {
					{
					{
					setState(42);
					statement(0);
					setState(43);
					match(NEWLINE);
					}
					}
					setState(49);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(50);
				closescope();
				}
				break;
			case FUNCTION:
				{
				_localctx = new FunctiondeclContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				match(FUNCTION);
				setState(53);
				match(LPAR);
				setState(54);
				functionvars();
				setState(55);
				match(RPAR);
				setState(56);
				match(ID);
				setState(57);
				match(COLON);
				setState(58);
				match(NEWLINE);
				setState(59);
				openscope();
				setState(60);
				match(NEWLINE);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << PRIMITIVE) | (1L << IF) | (1L << CONCURRENT) | (1L << FUNCTION) | (1L << LOOP) | (1L << BREAK) | (1L << ID) | (1L << NUMBER) | (1L << DEL) | (1L << LPAR) | (1L << MINUS) | (1L << NEGATION) | (1L << PIPEOPR))) != 0)) {
					{
					{
					setState(61);
					statement(0);
					setState(62);
					match(NEWLINE);
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(69);
				closescope();
				}
				break;
			case CONCURRENT:
				{
				_localctx = new ConcurrentstatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				match(CONCURRENT);
				setState(72);
				match(COLON);
				setState(73);
				match(NEWLINE);
				setState(74);
				openscope();
				setState(75);
				match(NEWLINE);
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << PRIMITIVE) | (1L << IF) | (1L << CONCURRENT) | (1L << FUNCTION) | (1L << LOOP) | (1L << BREAK) | (1L << ID) | (1L << NUMBER) | (1L << DEL) | (1L << LPAR) | (1L << MINUS) | (1L << NEGATION) | (1L << PIPEOPR))) != 0)) {
					{
					{
					setState(76);
					statement(0);
					setState(77);
					match(NEWLINE);
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(84);
				closescope();
				}
				break;
			case T__0:
			case T__3:
			case PRIMITIVE:
			case ID:
			case NUMBER:
			case DEL:
			case LPAR:
			case MINUS:
			case NEGATION:
			case PIPEOPR:
				{
				_localctx = new FlowstatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << PRIMITIVE) | (1L << ID) | (1L << NUMBER) | (1L << LPAR) | (1L << MINUS) | (1L << NEGATION) | (1L << PIPEOPR))) != 0)) {
					{
					setState(86);
					flow(0);
					}
				}

				setState(89);
				match(DEL);
				}
				break;
			case LOOP:
				{
				_localctx = new LoopstatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				match(LOOP);
				setState(91);
				match(T__0);
				setState(92);
				match(NUMBER);
				setState(93);
				match(T__1);
				setState(94);
				match(DEL);
				}
				break;
			case BREAK:
				{
				_localctx = new BreakstatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				match(BREAK);
				setState(96);
				match(T__0);
				setState(97);
				match(NUMBER);
				setState(98);
				match(T__1);
				setState(99);
				match(DEL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(106);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new EmptystatContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(102);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(103);
						match(NEWLINE);
						}
						break;
					case 2:
						{
						_localctx = new CommentstatContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(104);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(105);
						comment();
						}
						break;
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
			setState(111);
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
			setState(113);
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
			setState(127);
			_la = _input.LA(1);
			if (_la==PRIMITIVE) {
				{
				{
				setState(115);
				type();
				setState(116);
				match(ID);
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(118);
					match(T__2);
					setState(119);
					type();
					setState(120);
					match(ID);
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(129);
			match(PLACEOPR);
			setState(130);
			type();
			setState(131);
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
	public static class DeclfunctionflowContext extends FlowContext {
		public List<FlowContext> flow() {
			return getRuleContexts(FlowContext.class);
		}
		public FlowContext flow(int i) {
			return getRuleContext(FlowContext.class,i);
		}
		public TerminalNode PIPEOPR() { return getToken(BoogyQParser.PIPEOPR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(BoogyQParser.ID, 0); }
		public DeclfunctionflowContext(FlowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterDeclfunctionflow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitDeclfunctionflow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitDeclfunctionflow(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclgeneratorflowContext extends FlowContext {
		public TerminalNode PIPEOPR() { return getToken(BoogyQParser.PIPEOPR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(BoogyQParser.ID, 0); }
		public DeclgeneratorflowContext(FlowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterDeclgeneratorflow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitDeclgeneratorflow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitDeclgeneratorflow(this);
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
			setState(141);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new AssigngeneratorflowContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(134);
				match(PIPEOPR);
				setState(135);
				match(ID);
				}
				break;
			case 2:
				{
				_localctx = new DeclgeneratorflowContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(PIPEOPR);
				setState(137);
				type();
				setState(138);
				match(ID);
				}
				break;
			case 3:
				{
				_localctx = new IgnoremeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				expr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(175);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(173);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new AssignstandardflowContext(new FlowContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_flow);
						setState(143);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(144);
						match(PLACEOPR);
						setState(145);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new DeclstandardflowContext(new FlowContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_flow);
						setState(146);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(147);
						match(PLACEOPR);
						setState(148);
						type();
						setState(149);
						match(ID);
						}
						break;
					case 3:
						{
						_localctx = new AssignfunctionflowContext(new FlowContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_flow);
						setState(151);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(156);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(152);
							match(T__2);
							setState(153);
							flow(0);
							}
							}
							setState(158);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(159);
						match(PIPEOPR);
						setState(160);
						match(ID);
						}
						break;
					case 4:
						{
						_localctx = new DeclfunctionflowContext(new FlowContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_flow);
						setState(161);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(166);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(162);
							match(T__2);
							setState(163);
							flow(0);
							}
							}
							setState(168);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(169);
						match(PIPEOPR);
						setState(170);
						type();
						setState(171);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(177);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
	public static class DeclexprContext extends ExprContext {
		public TerminalNode PRIMITIVE() { return getToken(BoogyQParser.PRIMITIVE, 0); }
		public TerminalNode ID() { return getToken(BoogyQParser.ID, 0); }
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
	public static class ComparatorexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
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
			setState(192);
			switch (_input.LA(1)) {
			case MINUS:
				{
				_localctx = new MinusexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(179);
				match(MINUS);
				setState(180);
				expr(2);
				}
				break;
			case NEGATION:
				{
				_localctx = new NotexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				match(NEGATION);
				setState(182);
				expr(1);
				}
				break;
			case ID:
				{
				_localctx = new IdenexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				match(ID);
				}
				break;
			case PRIMITIVE:
				{
				_localctx = new DeclexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				match(PRIMITIVE);
				setState(185);
				match(ID);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumberexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				match(NUMBER);
				}
				break;
			case T__0:
			case T__3:
				{
				_localctx = new ArraydeclContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				array();
				}
				break;
			case LPAR:
				{
				_localctx = new FlowexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				match(LPAR);
				setState(189);
				flow(0);
				setState(190);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(210);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new AndorexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(194);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(195);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(196);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new ComparatorexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(197);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(198);
						comparator();
						setState(199);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new PowerexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(201);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(202);
						match(HAT);
						setState(203);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new TimesexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(204);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(205);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIVIDE) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(206);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new PlusexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(207);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(208);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(209);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class ComparatorContext extends ParserRuleContext {
		public TerminalNode COMP_EQ() { return getToken(BoogyQParser.COMP_EQ, 0); }
		public TerminalNode COMP_NE() { return getToken(BoogyQParser.COMP_NE, 0); }
		public TerminalNode COMP_LE() { return getToken(BoogyQParser.COMP_LE, 0); }
		public TerminalNode COMP_LT() { return getToken(BoogyQParser.COMP_LT, 0); }
		public TerminalNode COMP_GE() { return getToken(BoogyQParser.COMP_GE, 0); }
		public TerminalNode COMP_GT() { return getToken(BoogyQParser.COMP_GT, 0); }
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMP_EQ) | (1L << COMP_NE) | (1L << COMP_LE) | (1L << COMP_LT) | (1L << COMP_GE) | (1L << COMP_GT))) != 0)) ) {
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
		public List<TerminalNode> TIMES() { return getTokens(BoogyQParser.TIMES); }
		public TerminalNode TIMES(int i) {
			return getToken(BoogyQParser.TIMES, i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_array);
		int _la;
		try {
			int _alt;
			setState(246);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				match(T__3);
				setState(222);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(218);
					match(ID);
					}
					break;
				case NUMBER:
					{
					setState(219);
					match(NUMBER);
					}
					break;
				case BOOL:
					{
					setState(220);
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
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(224);
					match(T__2);
					setState(229);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(225);
						match(ID);
						}
						break;
					case NUMBER:
						{
						setState(226);
						match(NUMBER);
						}
						break;
					case BOOL:
						{
						setState(227);
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
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(236);
				match(T__4);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				match(T__0);
				setState(238);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMBER) | (1L << BOOL))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(239);
				match(T__1);
				setState(242); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(240);
						match(TIMES);
						setState(241);
						match(NUMBER);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(244); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		enterRule(_localctx, 18, RULE_comment);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(T__5);
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(249);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(PRIMITIVE);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(256);
				match(T__6);
				}
				}
				setState(261);
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
		case 1:
			return precpred(_ctx, 7);
		}
		return true;
	}
	private boolean flow_sempred(FlowContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u0109\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63\13\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3C\n\3\f\3"+
		"\16\3F\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3R\n\3\f\3\16\3"+
		"U\13\3\3\3\3\3\3\3\5\3Z\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3g\n\3\3\3\3\3\3\3\3\3\7\3m\n\3\f\3\16\3p\13\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6}\n\6\f\6\16\6\u0080\13\6\5\6\u0082\n\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0090\n\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u009d\n\7\f\7\16\7\u00a0\13\7"+
		"\3\7\3\7\3\7\3\7\3\7\7\7\u00a7\n\7\f\7\16\7\u00aa\13\7\3\7\3\7\3\7\3\7"+
		"\7\7\u00b0\n\7\f\7\16\7\u00b3\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b\u00c3\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00d5\n\b\f\b\16\b\u00d8\13\b\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\u00e1\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u00e8\n\n\7"+
		"\n\u00ea\n\n\f\n\16\n\u00ed\13\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u00f5\n\n"+
		"\r\n\16\n\u00f6\5\n\u00f9\n\n\3\13\3\13\7\13\u00fd\n\13\f\13\16\13\u0100"+
		"\13\13\3\f\3\f\7\f\u0104\n\f\f\f\16\f\u0107\13\f\3\f\2\5\4\f\16\r\2\4"+
		"\6\b\n\f\16\20\22\24\26\2\b\3\2!\"\3\2\35\36\3\2\37 \3\2#(\3\2\22\24\3"+
		"\2\32\32\u0129\2\35\3\2\2\2\4f\3\2\2\2\6q\3\2\2\2\bs\3\2\2\2\n\u0081\3"+
		"\2\2\2\f\u008f\3\2\2\2\16\u00c2\3\2\2\2\20\u00d9\3\2\2\2\22\u00f8\3\2"+
		"\2\2\24\u00fa\3\2\2\2\26\u0101\3\2\2\2\30\31\5\4\3\2\31\32\7\32\2\2\32"+
		"\34\3\2\2\2\33\30\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36"+
		" \3\2\2\2\37\35\3\2\2\2 !\5\4\3\2!\"\7\2\2\3\"\3\3\2\2\2#$\b\3\1\2$%\7"+
		"\13\2\2%&\7\26\2\2&\'\5\16\b\2\'(\7\27\2\2()\7\30\2\2)*\7\32\2\2*+\5\6"+
		"\4\2+\61\7\32\2\2,-\5\4\3\2-.\7\32\2\2.\60\3\2\2\2/,\3\2\2\2\60\63\3\2"+
		"\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\5\b\5"+
		"\2\65g\3\2\2\2\66\67\7\r\2\2\678\7\26\2\289\5\n\6\29:\7\27\2\2:;\7\22"+
		"\2\2;<\7\30\2\2<=\7\32\2\2=>\5\6\4\2>D\7\32\2\2?@\5\4\3\2@A\7\32\2\2A"+
		"C\3\2\2\2B?\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2"+
		"GH\5\b\5\2Hg\3\2\2\2IJ\7\f\2\2JK\7\30\2\2KL\7\32\2\2LM\5\6\4\2MS\7\32"+
		"\2\2NO\5\4\3\2OP\7\32\2\2PR\3\2\2\2QN\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3"+
		"\2\2\2TV\3\2\2\2US\3\2\2\2VW\5\b\5\2Wg\3\2\2\2XZ\5\f\7\2YX\3\2\2\2YZ\3"+
		"\2\2\2Z[\3\2\2\2[g\7\25\2\2\\]\7\20\2\2]^\7\3\2\2^_\7\23\2\2_`\7\4\2\2"+
		"`g\7\25\2\2ab\7\21\2\2bc\7\3\2\2cd\7\23\2\2de\7\4\2\2eg\7\25\2\2f#\3\2"+
		"\2\2f\66\3\2\2\2fI\3\2\2\2fY\3\2\2\2f\\\3\2\2\2fa\3\2\2\2gn\3\2\2\2hi"+
		"\f\n\2\2im\7\32\2\2jk\f\t\2\2km\5\24\13\2lh\3\2\2\2lj\3\2\2\2mp\3\2\2"+
		"\2nl\3\2\2\2no\3\2\2\2o\5\3\2\2\2pn\3\2\2\2qr\7\16\2\2r\7\3\2\2\2st\7"+
		"\17\2\2t\t\3\2\2\2uv\5\26\f\2vw\7\22\2\2w~\3\2\2\2xy\7\5\2\2yz\5\26\f"+
		"\2z{\7\22\2\2{}\3\2\2\2|x\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2"+
		"\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0081u\3\2\2\2\u0081\u0082\3\2\2\2"+
		"\u0082\u0083\3\2\2\2\u0083\u0084\7*\2\2\u0084\u0085\5\26\f\2\u0085\u0086"+
		"\7\22\2\2\u0086\13\3\2\2\2\u0087\u0088\b\7\1\2\u0088\u0089\7+\2\2\u0089"+
		"\u0090\7\22\2\2\u008a\u008b\7+\2\2\u008b\u008c\5\26\f\2\u008c\u008d\7"+
		"\22\2\2\u008d\u0090\3\2\2\2\u008e\u0090\5\16\b\2\u008f\u0087\3\2\2\2\u008f"+
		"\u008a\3\2\2\2\u008f\u008e\3\2\2\2\u0090\u00b1\3\2\2\2\u0091\u0092\f\t"+
		"\2\2\u0092\u0093\7*\2\2\u0093\u00b0\7\22\2\2\u0094\u0095\f\b\2\2\u0095"+
		"\u0096\7*\2\2\u0096\u0097\5\26\f\2\u0097\u0098\7\22\2\2\u0098\u00b0\3"+
		"\2\2\2\u0099\u009e\f\5\2\2\u009a\u009b\7\5\2\2\u009b\u009d\5\f\7\2\u009c"+
		"\u009a\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2"+
		"\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\7+\2\2\u00a2"+
		"\u00b0\7\22\2\2\u00a3\u00a8\f\4\2\2\u00a4\u00a5\7\5\2\2\u00a5\u00a7\5"+
		"\f\7\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\7+"+
		"\2\2\u00ac\u00ad\5\26\f\2\u00ad\u00ae\7\22\2\2\u00ae\u00b0\3\2\2\2\u00af"+
		"\u0091\3\2\2\2\u00af\u0094\3\2\2\2\u00af\u0099\3\2\2\2\u00af\u00a3\3\2"+
		"\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\r\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5\b\b\1\2\u00b5\u00b6\7 \2\2"+
		"\u00b6\u00c3\5\16\b\4\u00b7\u00b8\7)\2\2\u00b8\u00c3\5\16\b\3\u00b9\u00c3"+
		"\7\22\2\2\u00ba\u00bb\7\n\2\2\u00bb\u00c3\7\22\2\2\u00bc\u00c3\7\23\2"+
		"\2\u00bd\u00c3\5\22\n\2\u00be\u00bf\7\26\2\2\u00bf\u00c0\5\f\7\2\u00c0"+
		"\u00c1\7\27\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00b4\3\2\2\2\u00c2\u00b7\3"+
		"\2\2\2\u00c2\u00b9\3\2\2\2\u00c2\u00ba\3\2\2\2\u00c2\u00bc\3\2\2\2\u00c2"+
		"\u00bd\3\2\2\2\u00c2\u00be\3\2\2\2\u00c3\u00d6\3\2\2\2\u00c4\u00c5\f\t"+
		"\2\2\u00c5\u00c6\t\2\2\2\u00c6\u00d5\5\16\b\n\u00c7\u00c8\f\b\2\2\u00c8"+
		"\u00c9\5\20\t\2\u00c9\u00ca\5\16\b\t\u00ca\u00d5\3\2\2\2\u00cb\u00cc\f"+
		"\7\2\2\u00cc\u00cd\7\34\2\2\u00cd\u00d5\5\16\b\b\u00ce\u00cf\f\6\2\2\u00cf"+
		"\u00d0\t\3\2\2\u00d0\u00d5\5\16\b\7\u00d1\u00d2\f\5\2\2\u00d2\u00d3\t"+
		"\4\2\2\u00d3\u00d5\5\16\b\6\u00d4\u00c4\3\2\2\2\u00d4\u00c7\3\2\2\2\u00d4"+
		"\u00cb\3\2\2\2\u00d4\u00ce\3\2\2\2\u00d4\u00d1\3\2\2\2\u00d5\u00d8\3\2"+
		"\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\17\3\2\2\2\u00d8\u00d6"+
		"\3\2\2\2\u00d9\u00da\t\5\2\2\u00da\21\3\2\2\2\u00db\u00e0\7\6\2\2\u00dc"+
		"\u00e1\7\22\2\2\u00dd\u00e1\7\23\2\2\u00de\u00e1\7\24\2\2\u00df\u00e1"+
		"\3\2\2\2\u00e0\u00dc\3\2\2\2\u00e0\u00dd\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00df\3\2\2\2\u00e1\u00eb\3\2\2\2\u00e2\u00e7\7\5\2\2\u00e3\u00e8\7\22"+
		"\2\2\u00e4\u00e8\7\23\2\2\u00e5\u00e8\7\24\2\2\u00e6\u00e8\3\2\2\2\u00e7"+
		"\u00e3\3\2\2\2\u00e7\u00e4\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3\2"+
		"\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e2\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ee\u00f9\7\7\2\2\u00ef\u00f0\7\3\2\2\u00f0\u00f1\t\6\2\2\u00f1"+
		"\u00f4\7\4\2\2\u00f2\u00f3\7\35\2\2\u00f3\u00f5\7\23\2\2\u00f4\u00f2\3"+
		"\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\u00f9\3\2\2\2\u00f8\u00db\3\2\2\2\u00f8\u00ef\3\2\2\2\u00f9\23\3\2\2"+
		"\2\u00fa\u00fe\7\b\2\2\u00fb\u00fd\n\7\2\2\u00fc\u00fb\3\2\2\2\u00fd\u0100"+
		"\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\25\3\2\2\2\u0100"+
		"\u00fe\3\2\2\2\u0101\u0105\7\n\2\2\u0102\u0104\7\t\2\2\u0103\u0102\3\2"+
		"\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\27\3\2\2\2\u0107\u0105\3\2\2\2\33\35\61DSYfln~\u0081\u008f\u009e\u00a8"+
		"\u00af\u00b1\u00c2\u00d4\u00d6\u00e0\u00e7\u00eb\u00f6\u00f8\u00fe\u0105";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}