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
		CLOSESCOPE=10, ID=11, NUMBER=12, BOOL=13, DEL=14, LPAR=15, RPAR=16, COLON=17, 
		TAB=18, NEWLINE=19, WS=20, HAT=21, TIMES=22, DIVIDE=23, PLUS=24, MINUS=25, 
		AND=26, OR=27, COMP_EQ=28, COMP_NE=29, COMP_LE=30, COMP_LT=31, COMP_GE=32, 
		COMP_GT=33, NEGATION=34, PLACEOPR=35, PIPEOPR=36;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_flow = 2, RULE_expr = 3, RULE_operator = 4, 
		RULE_array = 5, RULE_type = 6;
	public static final String[] ruleNames = {
		"program", "statement", "flow", "expr", "operator", "array", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "','", "']'", "'{'", "'}'", "'[]'", null, "'if'", "'OPENSCOPE'", 
		"'CLOSESCOPE'", null, null, null, "'.'", "'('", "')'", "':'", "'\t'", 
		"'\n'", "' '", "'^'", "'*'", "'/'", "'+'", "'-'", "'&&'", "'||'", "'=='", 
		"'!='", "'<='", "'<'", "'>='", "'>'", "'!'", "'->'", "'=>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "PRIMITIVE", "IF", "OPENSCOPE", 
		"CLOSESCOPE", "ID", "NUMBER", "BOOL", "DEL", "LPAR", "RPAR", "COLON", 
		"TAB", "NEWLINE", "WS", "HAT", "TIMES", "DIVIDE", "PLUS", "MINUS", "AND", 
		"OR", "COMP_EQ", "COMP_NE", "COMP_LE", "COMP_LT", "COMP_GE", "COMP_GT", 
		"NEGATION", "PLACEOPR", "PIPEOPR"
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
			setState(47);
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << PRIMITIVE) | (1L << IF) | (1L << ID) | (1L << NUMBER) | (1L << DEL) | (1L << LPAR) | (1L << MINUS) | (1L << NEGATION))) != 0)) {
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
			case T__3:
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
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << PRIMITIVE) | (1L << ID) | (1L << NUMBER) | (1L << LPAR) | (1L << MINUS) | (1L << NEGATION))) != 0)) {
					{
					setState(43);
					flow(0);
					}
				}

				setState(46);
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
			setState(50);
			expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(63);
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
					setState(52);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(58);
					switch (_input.LA(1)) {
					case PLACEOPR:
						{
						setState(53);
						match(PLACEOPR);
						setState(55);
						_la = _input.LA(1);
						if (_la==PRIMITIVE) {
							{
							setState(54);
							type();
							}
						}

						}
						break;
					case PIPEOPR:
						{
						setState(57);
						match(PIPEOPR);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(60);
					match(ID);
					}
					} 
				}
				setState(65);
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
			setState(81);
			switch (_input.LA(1)) {
			case MINUS:
				{
				setState(67);
				match(MINUS);
				setState(68);
				expr(2);
				}
				break;
			case NEGATION:
				{
				setState(69);
				match(NEGATION);
				setState(70);
				expr(1);
				}
				break;
			case PRIMITIVE:
			case ID:
				{
				setState(72);
				_la = _input.LA(1);
				if (_la==PRIMITIVE) {
					{
					setState(71);
					match(PRIMITIVE);
					}
				}

				setState(74);
				match(ID);
				}
				break;
			case NUMBER:
				{
				setState(75);
				match(NUMBER);
				}
				break;
			case T__0:
			case T__3:
				{
				setState(76);
				array();
				}
				break;
			case LPAR:
				{
				setState(77);
				match(LPAR);
				setState(78);
				flow(0);
				setState(79);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(99);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(83);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(84);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(85);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(87);
						match(HAT);
						setState(88);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(90);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIVIDE) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(91);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(93);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(94);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(96);
						operator();
						setState(97);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(103);
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
			setState(104);
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
			setState(135);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(T__0);
				setState(111);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(107);
					match(ID);
					}
					break;
				case NUMBER:
					{
					setState(108);
					match(NUMBER);
					}
					break;
				case BOOL:
					{
					setState(109);
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
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(113);
					match(T__1);
					setState(118);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(114);
						match(ID);
						}
						break;
					case NUMBER:
						{
						setState(115);
						match(NUMBER);
						}
						break;
					case BOOL:
						{
						setState(116);
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
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(125);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(T__3);
				setState(127);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMBER) | (1L << BOOL))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(128);
				match(T__4);
				setState(131); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(129);
						match(TIMES);
						setState(130);
						match(NUMBER);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(133); 
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
			setState(137);
			match(PRIMITIVE);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(138);
				match(T__5);
				}
				}
				setState(143);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3&\u0093\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\7\2\24\n\2"+
		"\f\2\16\2\27\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\3\3\5\3/\n\3\3\3\5\3\62\n\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4:\n\4\3\4\5\4=\n\4\3\4\7\4@\n\4\f\4\16\4C\13\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5K\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5T\n\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5f"+
		"\n\5\f\5\16\5i\13\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7r\n\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7y\n\7\7\7{\n\7\f\7\16\7~\13\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7\u0086"+
		"\n\7\r\7\16\7\u0087\5\7\u008a\n\7\3\b\3\b\7\b\u008e\n\b\f\b\16\b\u0091"+
		"\13\b\3\b\2\4\6\b\t\2\4\6\b\n\f\16\2\7\3\2\34\35\3\2\30\31\3\2\32\33\3"+
		"\2\27#\3\2\r\17\u00a7\2\25\3\2\2\2\4\61\3\2\2\2\6\63\3\2\2\2\bS\3\2\2"+
		"\2\nj\3\2\2\2\f\u0089\3\2\2\2\16\u008b\3\2\2\2\20\21\5\4\3\2\21\22\7\25"+
		"\2\2\22\24\3\2\2\2\23\20\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2"+
		"\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31\5\4\3\2\31\32\7\2\2\3\32\3\3\2"+
		"\2\2\33\34\7\n\2\2\34\35\7\21\2\2\35\36\5\b\5\2\36\37\7\22\2\2\37 \7\23"+
		"\2\2 !\7\25\2\2!\"\7\13\2\2\"(\7\25\2\2#$\5\4\3\2$%\7\25\2\2%\'\3\2\2"+
		"\2&#\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\f"+
		"\2\2,\62\3\2\2\2-/\5\6\4\2.-\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\62\7\20"+
		"\2\2\61\33\3\2\2\2\61.\3\2\2\2\62\5\3\2\2\2\63\64\b\4\1\2\64\65\5\b\5"+
		"\2\65A\3\2\2\2\66<\f\4\2\2\679\7%\2\28:\5\16\b\298\3\2\2\29:\3\2\2\2:"+
		"=\3\2\2\2;=\7&\2\2<\67\3\2\2\2<;\3\2\2\2=>\3\2\2\2>@\7\r\2\2?\66\3\2\2"+
		"\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\7\3\2\2\2CA\3\2\2\2DE\b\5\1\2EF\7\33"+
		"\2\2FT\5\b\5\4GH\7$\2\2HT\5\b\5\3IK\7\t\2\2JI\3\2\2\2JK\3\2\2\2KL\3\2"+
		"\2\2LT\7\r\2\2MT\7\16\2\2NT\5\f\7\2OP\7\21\2\2PQ\5\6\4\2QR\7\22\2\2RT"+
		"\3\2\2\2SD\3\2\2\2SG\3\2\2\2SJ\3\2\2\2SM\3\2\2\2SN\3\2\2\2SO\3\2\2\2T"+
		"g\3\2\2\2UV\f\t\2\2VW\t\2\2\2Wf\5\b\5\nXY\f\b\2\2YZ\7\27\2\2Zf\5\b\5\t"+
		"[\\\f\7\2\2\\]\t\3\2\2]f\5\b\5\b^_\f\6\2\2_`\t\4\2\2`f\5\b\5\7ab\f\5\2"+
		"\2bc\5\n\6\2cd\5\b\5\6df\3\2\2\2eU\3\2\2\2eX\3\2\2\2e[\3\2\2\2e^\3\2\2"+
		"\2ea\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\t\3\2\2\2ig\3\2\2\2jk\t\5"+
		"\2\2k\13\3\2\2\2lq\7\3\2\2mr\7\r\2\2nr\7\16\2\2or\7\17\2\2pr\3\2\2\2q"+
		"m\3\2\2\2qn\3\2\2\2qo\3\2\2\2qp\3\2\2\2r|\3\2\2\2sx\7\4\2\2ty\7\r\2\2"+
		"uy\7\16\2\2vy\7\17\2\2wy\3\2\2\2xt\3\2\2\2xu\3\2\2\2xv\3\2\2\2xw\3\2\2"+
		"\2y{\3\2\2\2zs\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3"+
		"\2\2\2\177\u008a\7\5\2\2\u0080\u0081\7\6\2\2\u0081\u0082\t\6\2\2\u0082"+
		"\u0085\7\7\2\2\u0083\u0084\7\30\2\2\u0084\u0086\7\16\2\2\u0085\u0083\3"+
		"\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u008a\3\2\2\2\u0089l\3\2\2\2\u0089\u0080\3\2\2\2\u008a\r\3\2\2\2\u008b"+
		"\u008f\7\t\2\2\u008c\u008e\7\b\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\17\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\23\25(.\619<AJSegqx|\u0087\u0089\u008f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}