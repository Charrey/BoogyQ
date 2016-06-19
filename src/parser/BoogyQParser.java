// Generated from C:/Users/jij/IdeaProjects/BoogyQ/src\BoogyQ.g4 by ANTLR 4.5.1
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, PRIMITIVE=7, IF=8, OPENSCOPE=9, 
		CLOSESCOPE=10, LOOP=11, BREAK=12, ID=13, NUMBER=14, BOOL=15, DEL=16, LPAR=17, 
		RPAR=18, COLON=19, TAB=20, NEWLINE=21, WS=22, HAT=23, TIMES=24, DIVIDE=25, 
		PLUS=26, MINUS=27, AND=28, OR=29, COMP_EQ=30, COMP_NE=31, COMP_LE=32, 
		COMP_LT=33, COMP_GE=34, COMP_GT=35, NEGATION=36, PLACEOPR=37, PIPEOPR=38;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_flow = 2, RULE_expr = 3, RULE_operator = 4, 
		RULE_array = 5, RULE_type = 6;
	public static final String[] ruleNames = {
		"program", "statement", "flow", "expr", "operator", "array", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'['", "','", "']'", "'[]'", null, "'if'", "'OPENSCOPE'", 
		"'CLOSESCOPE'", "'loop'", "'break'", null, null, null, "'.'", "'('", "')'", 
		"':'", "'\t'", "'\n'", "' '", "'^'", "'*'", "'/'", "'+'", "'-'", "'&&'", 
		"'||'", "'=='", "'!='", "'<='", "'<'", "'>='", "'>'", "'!'", "'->'", "'=>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "PRIMITIVE", "IF", "OPENSCOPE", 
		"CLOSESCOPE", "LOOP", "BREAK", "ID", "NUMBER", "BOOL", "DEL", "LPAR", 
		"RPAR", "COLON", "TAB", "NEWLINE", "WS", "HAT", "TIMES", "DIVIDE", "PLUS", 
		"MINUS", "AND", "OR", "COMP_EQ", "COMP_NE", "COMP_LE", "COMP_LT", "COMP_GE", 
		"COMP_GT", "NEGATION", "PLACEOPR", "PIPEOPR"
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
			setState(19);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(14);
					statement();
					setState(15);
					match(NEWLINE);
					}
					} 
				}
				setState(21);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(22);
			statement();
			setState(23);
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
		public TerminalNode OPENSCOPE() { return getToken(BoogyQParser.OPENSCOPE, 0); }
		public TerminalNode CLOSESCOPE() { return getToken(BoogyQParser.CLOSESCOPE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode DEL() { return getToken(BoogyQParser.DEL, 0); }
		public FlowContext flow() {
			return getRuleContext(FlowContext.class,0);
		}
		public TerminalNode LOOP() { return getToken(BoogyQParser.LOOP, 0); }
		public TerminalNode NUMBER() { return getToken(BoogyQParser.NUMBER, 0); }
		public TerminalNode BREAK() { return getToken(BoogyQParser.BREAK, 0); }
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
		int _la;
		try {
			setState(57);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				match(IF);
				setState(26);
				match(LPAR);
				setState(27);
				expr(0);
				setState(28);
				match(RPAR);
				setState(29);
				match(COLON);
				setState(30);
				match(NEWLINE);
				setState(31);
				match(OPENSCOPE);
				setState(32);
				match(NEWLINE);
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << PRIMITIVE) | (1L << IF) | (1L << LOOP) | (1L << BREAK) | (1L << ID) | (1L << NUMBER) | (1L << DEL) | (1L << LPAR) | (1L << MINUS) | (1L << NEGATION))) != 0)) {
					{
					{
					setState(33);
					statement();
					setState(34);
					match(NEWLINE);
					}
					}
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(41);
				match(CLOSESCOPE);
				}
				break;
			case T__0:
			case T__2:
			case PRIMITIVE:
			case ID:
			case NUMBER:
			case DEL:
			case LPAR:
			case MINUS:
			case NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << PRIMITIVE) | (1L << ID) | (1L << NUMBER) | (1L << LPAR) | (1L << MINUS) | (1L << NEGATION))) != 0)) {
					{
					setState(43);
					flow(0);
					}
				}

				setState(46);
				match(DEL);
				}
				break;
			case LOOP:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				match(LOOP);
				setState(48);
				match(T__0);
				setState(49);
				match(NUMBER);
				setState(50);
				match(T__1);
				setState(51);
				match(DEL);
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 4);
				{
				setState(52);
				match(BREAK);
				setState(53);
				match(T__0);
				setState(54);
				match(NUMBER);
				setState(55);
				match(T__1);
				setState(56);
				match(DEL);
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

	public static class FlowContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FlowContext flow() {
			return getRuleContext(FlowContext.class,0);
		}
		public TerminalNode ID() { return getToken(BoogyQParser.ID, 0); }
		public TerminalNode PLACEOPR() { return getToken(BoogyQParser.PLACEOPR, 0); }
		public TerminalNode PIPEOPR() { return getToken(BoogyQParser.PIPEOPR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
			{
			setState(60);
			expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(73);
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
					setState(62);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(68);
					switch (_input.LA(1)) {
					case PLACEOPR:
						{
						setState(63);
						match(PLACEOPR);
						setState(65);
						_la = _input.LA(1);
						if (_la==PRIMITIVE) {
							{
							setState(64);
							type();
							}
						}

						}
						break;
					case PIPEOPR:
						{
						setState(67);
						match(PIPEOPR);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(70);
					match(ID);
					}
					} 
				}
				setState(75);
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
		public TerminalNode PRIMITIVE() { return getToken(BoogyQParser.PRIMITIVE, 0); }
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
			setState(91);
			switch (_input.LA(1)) {
			case MINUS:
				{
				setState(77);
				match(MINUS);
				setState(78);
				expr(2);
				}
				break;
			case NEGATION:
				{
				setState(79);
				match(NEGATION);
				setState(80);
				expr(1);
				}
				break;
			case PRIMITIVE:
			case ID:
				{
				setState(82);
				_la = _input.LA(1);
				if (_la==PRIMITIVE) {
					{
					setState(81);
					match(PRIMITIVE);
					}
				}

				setState(84);
				match(ID);
				}
				break;
			case NUMBER:
				{
				setState(85);
				match(NUMBER);
				}
				break;
			case T__0:
			case T__2:
				{
				setState(86);
				array();
				}
				break;
			case LPAR:
				{
				setState(87);
				match(LPAR);
				setState(88);
				flow(0);
				setState(89);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(109);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(93);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(94);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(95);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(96);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(97);
						match(HAT);
						setState(98);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(99);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(100);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIVIDE) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(101);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(102);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(103);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(104);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(105);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(106);
						operator();
						setState(107);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
			setState(114);
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
			setState(145);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(T__2);
				setState(121);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(117);
					match(ID);
					}
					break;
				case NUMBER:
					{
					setState(118);
					match(NUMBER);
					}
					break;
				case BOOL:
					{
					setState(119);
					match(BOOL);
					}
					break;
				case T__3:
				case T__4:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(123);
					match(T__3);
					setState(128);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(124);
						match(ID);
						}
						break;
					case NUMBER:
						{
						setState(125);
						match(NUMBER);
						}
						break;
					case BOOL:
						{
						setState(126);
						match(BOOL);
						}
						break;
					case T__3:
					case T__4:
						{
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(135);
				match(T__4);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(T__0);
				setState(137);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMBER) | (1L << BOOL))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(138);
				match(T__1);
				setState(141); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(139);
						match(TIMES);
						setState(140);
						match(NUMBER);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(143); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(PRIMITIVE);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(148);
				match(T__5);
				}
				}
				setState(153);
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
			return precpred(_ctx, 2);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3(\u009d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\7\2\24\n\2"+
		"\f\2\16\2\27\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\3\3\5\3/\n\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3<\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4D\n\4\3\4"+
		"\5\4G\n\4\3\4\7\4J\n\4\f\4\16\4M\13\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5U\n\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5^\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5p\n\5\f\5\16\5s\13\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\5\7|\n\7\3\7\3\7\3\7\3\7\3\7\5\7\u0083\n\7\7\7\u0085\n"+
		"\7\f\7\16\7\u0088\13\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7\u0090\n\7\r\7\16\7"+
		"\u0091\5\7\u0094\n\7\3\b\3\b\7\b\u0098\n\b\f\b\16\b\u009b\13\b\3\b\2\4"+
		"\6\b\t\2\4\6\b\n\f\16\2\7\3\2\36\37\3\2\32\33\3\2\34\35\3\2\31%\3\2\17"+
		"\21\u00b3\2\25\3\2\2\2\4;\3\2\2\2\6=\3\2\2\2\b]\3\2\2\2\nt\3\2\2\2\f\u0093"+
		"\3\2\2\2\16\u0095\3\2\2\2\20\21\5\4\3\2\21\22\7\27\2\2\22\24\3\2\2\2\23"+
		"\20\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27"+
		"\25\3\2\2\2\30\31\5\4\3\2\31\32\7\2\2\3\32\3\3\2\2\2\33\34\7\n\2\2\34"+
		"\35\7\23\2\2\35\36\5\b\5\2\36\37\7\24\2\2\37 \7\25\2\2 !\7\27\2\2!\"\7"+
		"\13\2\2\"(\7\27\2\2#$\5\4\3\2$%\7\27\2\2%\'\3\2\2\2&#\3\2\2\2\'*\3\2\2"+
		"\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\f\2\2,<\3\2\2\2-/\5\6\4"+
		"\2.-\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60<\7\22\2\2\61\62\7\r\2\2\62\63\7"+
		"\3\2\2\63\64\7\20\2\2\64\65\7\4\2\2\65<\7\22\2\2\66\67\7\16\2\2\678\7"+
		"\3\2\289\7\20\2\29:\7\4\2\2:<\7\22\2\2;\33\3\2\2\2;.\3\2\2\2;\61\3\2\2"+
		"\2;\66\3\2\2\2<\5\3\2\2\2=>\b\4\1\2>?\5\b\5\2?K\3\2\2\2@F\f\4\2\2AC\7"+
		"\'\2\2BD\5\16\b\2CB\3\2\2\2CD\3\2\2\2DG\3\2\2\2EG\7(\2\2FA\3\2\2\2FE\3"+
		"\2\2\2GH\3\2\2\2HJ\7\17\2\2I@\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\7"+
		"\3\2\2\2MK\3\2\2\2NO\b\5\1\2OP\7\35\2\2P^\5\b\5\4QR\7&\2\2R^\5\b\5\3S"+
		"U\7\t\2\2TS\3\2\2\2TU\3\2\2\2UV\3\2\2\2V^\7\17\2\2W^\7\20\2\2X^\5\f\7"+
		"\2YZ\7\23\2\2Z[\5\6\4\2[\\\7\24\2\2\\^\3\2\2\2]N\3\2\2\2]Q\3\2\2\2]T\3"+
		"\2\2\2]W\3\2\2\2]X\3\2\2\2]Y\3\2\2\2^q\3\2\2\2_`\f\t\2\2`a\t\2\2\2ap\5"+
		"\b\5\nbc\f\b\2\2cd\7\31\2\2dp\5\b\5\tef\f\7\2\2fg\t\3\2\2gp\5\b\5\bhi"+
		"\f\6\2\2ij\t\4\2\2jp\5\b\5\7kl\f\5\2\2lm\5\n\6\2mn\5\b\5\6np\3\2\2\2o"+
		"_\3\2\2\2ob\3\2\2\2oe\3\2\2\2oh\3\2\2\2ok\3\2\2\2ps\3\2\2\2qo\3\2\2\2"+
		"qr\3\2\2\2r\t\3\2\2\2sq\3\2\2\2tu\t\5\2\2u\13\3\2\2\2v{\7\5\2\2w|\7\17"+
		"\2\2x|\7\20\2\2y|\7\21\2\2z|\3\2\2\2{w\3\2\2\2{x\3\2\2\2{y\3\2\2\2{z\3"+
		"\2\2\2|\u0086\3\2\2\2}\u0082\7\6\2\2~\u0083\7\17\2\2\177\u0083\7\20\2"+
		"\2\u0080\u0083\7\21\2\2\u0081\u0083\3\2\2\2\u0082~\3\2\2\2\u0082\177\3"+
		"\2\2\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083\u0085\3\2\2\2\u0084"+
		"}\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2"+
		"\u0087\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u0094\7\7\2\2\u008a\u008b"+
		"\7\3\2\2\u008b\u008c\t\6\2\2\u008c\u008f\7\4\2\2\u008d\u008e\7\32\2\2"+
		"\u008e\u0090\7\20\2\2\u008f\u008d\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093v\3\2\2\2\u0093"+
		"\u008a\3\2\2\2\u0094\r\3\2\2\2\u0095\u0099\7\t\2\2\u0096\u0098\7\b\2\2"+
		"\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\17\3\2\2\2\u009b\u0099\3\2\2\2\23\25(.;CFKT]oq{\u0082\u0086"+
		"\u0091\u0093\u0099";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}