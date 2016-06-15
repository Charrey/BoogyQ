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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, TYPE=6, ID=7, NUMBER=8, BOOL=9, 
		DEL=10, IF=11, LPAR=12, RPAR=13, COLON=14, TAB=15, NEWLINE=16, WS=17, 
		OPENSCOPE=18, CLOSESCOPE=19, HAT=20, TIMES=21, DIVIDE=22, PLUS=23, MINUS=24, 
		AND=25, OR=26, COMP_EQ=27, COMP_NE=28, COMP_LE=29, COMP_LT=30, COMP_GE=31, 
		COMP_GT=32, NEGATION=33, PLACEOPR=34, PIPEOPR=35;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_flow = 2, RULE_expr = 3, RULE_operator = 4, 
		RULE_array = 5;
	public static final String[] ruleNames = {
		"program", "statement", "flow", "expr", "operator", "array"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "','", "']'", "'{'", "'}'", null, null, null, null, "'.'", 
		"'if'", "'('", "')'", "':'", "'\t'", "'\n'", "' '", "'OPENSCOPE'", "'CLOSESCOPE'", 
		"'^'", "'*'", "'/'", "'+'", "'-'", "'&&'", "'||'", "'=='", "'!='", "'<='", 
		"'<'", "'>='", "'>'", "'!'", "'->'", "'=>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "TYPE", "ID", "NUMBER", "BOOL", "DEL", 
		"IF", "LPAR", "RPAR", "COLON", "TAB", "NEWLINE", "WS", "OPENSCOPE", "CLOSESCOPE", 
		"HAT", "TIMES", "DIVIDE", "PLUS", "MINUS", "AND", "OR", "COMP_EQ", "COMP_NE", 
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
			setState(17);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(12);
					statement();
					setState(13);
					match(NEWLINE);
					}
					} 
				}
				setState(19);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(20);
			statement();
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
		public FlowContext flow() {
			return getRuleContext(FlowContext.class,0);
		}
		public TerminalNode DEL() { return getToken(BoogyQParser.DEL, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			flow(0);
			setState(23);
			match(DEL);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(BoogyQParser.ID, 0); }
		public TerminalNode PLACEOPR() { return getToken(BoogyQParser.PLACEOPR, 0); }
		public TerminalNode PIPEOPR() { return getToken(BoogyQParser.PIPEOPR, 0); }
		public TerminalNode TYPE() { return getToken(BoogyQParser.TYPE, 0); }
		public FlowContext flow() {
			return getRuleContext(FlowContext.class,0);
		}
		public FlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterFlow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitFlow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitFlow(this);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_flow, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(26);
				expr(0);
				setState(32);
				switch (_input.LA(1)) {
				case PLACEOPR:
					{
					setState(27);
					match(PLACEOPR);
					setState(29);
					_la = _input.LA(1);
					if (_la==TYPE) {
						{
						setState(28);
						match(TYPE);
						}
					}

					}
					break;
				case PIPEOPR:
					{
					setState(31);
					match(PIPEOPR);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(34);
				match(ID);
				}
				break;
			case 2:
				{
				setState(36);
				expr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FlowContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_flow);
					setState(39);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(45);
					switch (_input.LA(1)) {
					case PLACEOPR:
						{
						setState(40);
						match(PLACEOPR);
						setState(42);
						_la = _input.LA(1);
						if (_la==TYPE) {
							{
							setState(41);
							match(TYPE);
							}
						}

						}
						break;
					case PIPEOPR:
						{
						setState(44);
						match(PIPEOPR);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(47);
					match(ID);
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		public TerminalNode MINUS() { return getToken(BoogyQParser.MINUS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NEGATION() { return getToken(BoogyQParser.NEGATION, 0); }
		public TerminalNode ID() { return getToken(BoogyQParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(BoogyQParser.NUMBER, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(BoogyQParser.LPAR, 0); }
		public FlowContext flow() {
			return getRuleContext(FlowContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(BoogyQParser.RPAR, 0); }
		public TerminalNode AND() { return getToken(BoogyQParser.AND, 0); }
		public TerminalNode OR() { return getToken(BoogyQParser.OR, 0); }
		public TerminalNode HAT() { return getToken(BoogyQParser.HAT, 0); }
		public TerminalNode TIMES() { return getToken(BoogyQParser.TIMES, 0); }
		public TerminalNode DIVIDE() { return getToken(BoogyQParser.DIVIDE, 0); }
		public TerminalNode PLUS() { return getToken(BoogyQParser.PLUS, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitExpr(this);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			switch (_input.LA(1)) {
			case MINUS:
				{
				setState(54);
				match(MINUS);
				setState(55);
				expr(2);
				}
				break;
			case NEGATION:
				{
				setState(56);
				match(NEGATION);
				setState(57);
				expr(1);
				}
				break;
			case ID:
				{
				setState(58);
				match(ID);
				}
				break;
			case NUMBER:
				{
				setState(59);
				match(NUMBER);
				}
				break;
			case T__0:
			case T__3:
				{
				setState(60);
				array();
				}
				break;
			case LPAR:
				{
				setState(61);
				match(LPAR);
				setState(62);
				flow(0);
				setState(63);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(83);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(67);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(68);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(69);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(71);
						match(HAT);
						setState(72);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(73);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(74);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIVIDE) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(75);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(76);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(77);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(78);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(79);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(80);
						operator();
						setState(81);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(87);
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

	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode HAT() { return getToken(BoogyQParser.HAT, 0); }
		public TerminalNode TIMES() { return getToken(BoogyQParser.TIMES, 0); }
		public TerminalNode DIVIDE() { return getToken(BoogyQParser.DIVIDE, 0); }
		public TerminalNode PLUS() { return getToken(BoogyQParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BoogyQParser.MINUS, 0); }
		public TerminalNode AND() { return getToken(BoogyQParser.AND, 0); }
		public TerminalNode OR() { return getToken(BoogyQParser.OR, 0); }
		public TerminalNode COMP_EQ() { return getToken(BoogyQParser.COMP_EQ, 0); }
		public TerminalNode COMP_NE() { return getToken(BoogyQParser.COMP_NE, 0); }
		public TerminalNode COMP_LE() { return getToken(BoogyQParser.COMP_LE, 0); }
		public TerminalNode COMP_LT() { return getToken(BoogyQParser.COMP_LT, 0); }
		public TerminalNode COMP_GE() { return getToken(BoogyQParser.COMP_GE, 0); }
		public TerminalNode COMP_GT() { return getToken(BoogyQParser.COMP_GT, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoogyQListener ) ((BoogyQListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoogyQVisitor ) return ((BoogyQVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HAT) | (1L << TIMES) | (1L << DIVIDE) | (1L << PLUS) | (1L << MINUS) | (1L << AND) | (1L << OR) | (1L << COMP_EQ) | (1L << COMP_NE) | (1L << COMP_LE) | (1L << COMP_LT) | (1L << COMP_GE) | (1L << COMP_GT))) != 0)) ) {
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
		enterRule(_localctx, 10, RULE_array);
		int _la;
		try {
			int _alt;
			setState(119);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				match(T__0);
				setState(95);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(91);
					match(ID);
					}
					break;
				case NUMBER:
					{
					setState(92);
					match(NUMBER);
					}
					break;
				case BOOL:
					{
					setState(93);
					match(BOOL);
					}
					break;
				case T__1:
				case T__2:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(97);
					match(T__1);
					setState(102);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(98);
						match(ID);
						}
						break;
					case NUMBER:
						{
						setState(99);
						match(NUMBER);
						}
						break;
					case BOOL:
						{
						setState(100);
						match(BOOL);
						}
						break;
					case T__1:
					case T__2:
						{
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(109);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(T__3);
				setState(111);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMBER) | (1L << BOOL))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(112);
				match(T__4);
				setState(115); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(113);
						match(TIMES);
						setState(114);
						match(NUMBER);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(117); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return flow_sempred((FlowContext)_localctx, predIndex);
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean flow_sempred(FlowContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3%|\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\7\2\22\n\2\f\2\16\2\25\13"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4 \n\4\3\4\5\4#\n\4\3\4\3\4\3"+
		"\4\5\4(\n\4\3\4\3\4\3\4\5\4-\n\4\3\4\5\4\60\n\4\3\4\7\4\63\n\4\f\4\16"+
		"\4\66\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5D\n\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5V\n"+
		"\5\f\5\16\5Y\13\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7b\n\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7i\n\7\7\7k\n\7\f\7\16\7n\13\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7v\n\7"+
		"\r\7\16\7w\5\7z\n\7\3\7\2\4\6\b\b\2\4\6\b\n\f\2\7\3\2\33\34\3\2\27\30"+
		"\3\2\31\32\3\2\26\"\3\2\t\13\u008f\2\23\3\2\2\2\4\30\3\2\2\2\6\'\3\2\2"+
		"\2\bC\3\2\2\2\nZ\3\2\2\2\fy\3\2\2\2\16\17\5\4\3\2\17\20\7\22\2\2\20\22"+
		"\3\2\2\2\21\16\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\26"+
		"\3\2\2\2\25\23\3\2\2\2\26\27\5\4\3\2\27\3\3\2\2\2\30\31\5\6\4\2\31\32"+
		"\7\f\2\2\32\5\3\2\2\2\33\34\b\4\1\2\34\"\5\b\5\2\35\37\7$\2\2\36 \7\b"+
		"\2\2\37\36\3\2\2\2\37 \3\2\2\2 #\3\2\2\2!#\7%\2\2\"\35\3\2\2\2\"!\3\2"+
		"\2\2#$\3\2\2\2$%\7\t\2\2%(\3\2\2\2&(\5\b\5\2\'\33\3\2\2\2\'&\3\2\2\2("+
		"\64\3\2\2\2)/\f\5\2\2*,\7$\2\2+-\7\b\2\2,+\3\2\2\2,-\3\2\2\2-\60\3\2\2"+
		"\2.\60\7%\2\2/*\3\2\2\2/.\3\2\2\2\60\61\3\2\2\2\61\63\7\t\2\2\62)\3\2"+
		"\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\7\3\2\2\2\66\64\3\2"+
		"\2\2\678\b\5\1\289\7\32\2\29D\5\b\5\4:;\7#\2\2;D\5\b\5\3<D\7\t\2\2=D\7"+
		"\n\2\2>D\5\f\7\2?@\7\16\2\2@A\5\6\4\2AB\7\17\2\2BD\3\2\2\2C\67\3\2\2\2"+
		"C:\3\2\2\2C<\3\2\2\2C=\3\2\2\2C>\3\2\2\2C?\3\2\2\2DW\3\2\2\2EF\f\t\2\2"+
		"FG\t\2\2\2GV\5\b\5\nHI\f\b\2\2IJ\7\26\2\2JV\5\b\5\tKL\f\7\2\2LM\t\3\2"+
		"\2MV\5\b\5\bNO\f\6\2\2OP\t\4\2\2PV\5\b\5\7QR\f\5\2\2RS\5\n\6\2ST\5\b\5"+
		"\6TV\3\2\2\2UE\3\2\2\2UH\3\2\2\2UK\3\2\2\2UN\3\2\2\2UQ\3\2\2\2VY\3\2\2"+
		"\2WU\3\2\2\2WX\3\2\2\2X\t\3\2\2\2YW\3\2\2\2Z[\t\5\2\2[\13\3\2\2\2\\a\7"+
		"\3\2\2]b\7\t\2\2^b\7\n\2\2_b\7\13\2\2`b\3\2\2\2a]\3\2\2\2a^\3\2\2\2a_"+
		"\3\2\2\2a`\3\2\2\2bl\3\2\2\2ch\7\4\2\2di\7\t\2\2ei\7\n\2\2fi\7\13\2\2"+
		"gi\3\2\2\2hd\3\2\2\2he\3\2\2\2hf\3\2\2\2hg\3\2\2\2ik\3\2\2\2jc\3\2\2\2"+
		"kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2oz\7\5\2\2pq\7\6\2\2"+
		"qr\t\6\2\2ru\7\7\2\2st\7\27\2\2tv\7\n\2\2us\3\2\2\2vw\3\2\2\2wu\3\2\2"+
		"\2wx\3\2\2\2xz\3\2\2\2y\\\3\2\2\2yp\3\2\2\2z\r\3\2\2\2\21\23\37\"\',/"+
		"\64CUWahlwy";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}