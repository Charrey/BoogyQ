// Generated from C:/Users/Administrator/IdeaProjects/BoogyQ/src\BoogyQ.g4 by ANTLR 4.5.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoogyQLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "PRIMITIVE", "IF", 
		"CONCURRENT", "FUNCTION", "OPENSCOPE", "CLOSESCOPE", "LOOP", "BREAK", 
		"REACH", "BOOL", "ID", "NUMBER", "CHAR", "DEL", "LPAR", "RPAR", "COLON", 
		"TAB", "NEWLINE", "WS", "HAT", "TIMES", "DIVIDE", "PLUS", "MINUS", "AND", 
		"OR", "COMP_EQ", "COMP_NE", "COMP_LE", "COMP_LT", "COMP_GE", "COMP_GT", 
		"NEGATION", "PLACEOPR", "PIPEOPR"
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


	public BoogyQLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BoogyQ.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2-\u0112\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tu\n\t\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u00b9\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u00c4\n\22\3\23\3\23\7\23\u00c8\n\23\f\23\16\23\u00cb\13\23\3\24"+
		"\3\24\3\24\7\24\u00d0\n\24\f\24\16\24\u00d3\13\24\5\24\u00d5\n\24\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3(\3)\3)"+
		"\3*\3*\3+\3+\3+\3,\3,\3,\2\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-\3\2\6\4\2"+
		"C\\c|\5\2\62;C\\c|\3\2\63;\3\2\62;\u0118\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2"+
		"\2\5[\3\2\2\2\7]\3\2\2\2\t_\3\2\2\2\13a\3\2\2\2\rc\3\2\2\2\17f\3\2\2\2"+
		"\21t\3\2\2\2\23v\3\2\2\2\25y\3\2\2\2\27\u0084\3\2\2\2\31\u008d\3\2\2\2"+
		"\33\u0097\3\2\2\2\35\u00a2\3\2\2\2\37\u00a7\3\2\2\2!\u00b8\3\2\2\2#\u00c3"+
		"\3\2\2\2%\u00c5\3\2\2\2\'\u00d4\3\2\2\2)\u00d6\3\2\2\2+\u00da\3\2\2\2"+
		"-\u00dc\3\2\2\2/\u00de\3\2\2\2\61\u00e0\3\2\2\2\63\u00e2\3\2\2\2\65\u00e4"+
		"\3\2\2\2\67\u00e6\3\2\2\29\u00ea\3\2\2\2;\u00ec\3\2\2\2=\u00ee\3\2\2\2"+
		"?\u00f0\3\2\2\2A\u00f2\3\2\2\2C\u00f4\3\2\2\2E\u00f7\3\2\2\2G\u00fa\3"+
		"\2\2\2I\u00fd\3\2\2\2K\u0100\3\2\2\2M\u0103\3\2\2\2O\u0105\3\2\2\2Q\u0108"+
		"\3\2\2\2S\u010a\3\2\2\2U\u010c\3\2\2\2W\u010f\3\2\2\2YZ\7}\2\2Z\4\3\2"+
		"\2\2[\\\7\177\2\2\\\6\3\2\2\2]^\7.\2\2^\b\3\2\2\2_`\7]\2\2`\n\3\2\2\2"+
		"ab\7_\2\2b\f\3\2\2\2cd\7\61\2\2de\7\61\2\2e\16\3\2\2\2fg\7]\2\2gh\7_\2"+
		"\2h\20\3\2\2\2ij\7k\2\2jk\7p\2\2ku\7v\2\2lm\7d\2\2mn\7q\2\2no\7q\2\2o"+
		"u\7n\2\2pq\7e\2\2qr\7j\2\2rs\7c\2\2su\7t\2\2ti\3\2\2\2tl\3\2\2\2tp\3\2"+
		"\2\2u\22\3\2\2\2vw\7k\2\2wx\7h\2\2x\24\3\2\2\2yz\7e\2\2z{\7q\2\2{|\7p"+
		"\2\2|}\7e\2\2}~\7w\2\2~\177\7t\2\2\177\u0080\7t\2\2\u0080\u0081\7g\2\2"+
		"\u0081\u0082\7p\2\2\u0082\u0083\7v\2\2\u0083\26\3\2\2\2\u0084\u0085\7"+
		"h\2\2\u0085\u0086\7w\2\2\u0086\u0087\7p\2\2\u0087\u0088\7e\2\2\u0088\u0089"+
		"\7v\2\2\u0089\u008a\7k\2\2\u008a\u008b\7q\2\2\u008b\u008c\7p\2\2\u008c"+
		"\30\3\2\2\2\u008d\u008e\7Q\2\2\u008e\u008f\7R\2\2\u008f\u0090\7G\2\2\u0090"+
		"\u0091\7P\2\2\u0091\u0092\7U\2\2\u0092\u0093\7E\2\2\u0093\u0094\7Q\2\2"+
		"\u0094\u0095\7R\2\2\u0095\u0096\7G\2\2\u0096\32\3\2\2\2\u0097\u0098\7"+
		"E\2\2\u0098\u0099\7N\2\2\u0099\u009a\7Q\2\2\u009a\u009b\7U\2\2\u009b\u009c"+
		"\7G\2\2\u009c\u009d\7U\2\2\u009d\u009e\7E\2\2\u009e\u009f\7Q\2\2\u009f"+
		"\u00a0\7R\2\2\u00a0\u00a1\7G\2\2\u00a1\34\3\2\2\2\u00a2\u00a3\7n\2\2\u00a3"+
		"\u00a4\7q\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7r\2\2\u00a6\36\3\2\2\2\u00a7"+
		"\u00a8\7d\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7c\2\2"+
		"\u00ab\u00ac\7m\2\2\u00ac \3\2\2\2\u00ad\u00ae\7i\2\2\u00ae\u00af\7n\2"+
		"\2\u00af\u00b0\7q\2\2\u00b0\u00b1\7d\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b9"+
		"\7n\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7q\2\2\u00b5\u00b6\7e\2\2\u00b6"+
		"\u00b7\7c\2\2\u00b7\u00b9\7n\2\2\u00b8\u00ad\3\2\2\2\u00b8\u00b3\3\2\2"+
		"\2\u00b9\"\3\2\2\2\u00ba\u00bb\7V\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7"+
		"w\2\2\u00bd\u00c4\7g\2\2\u00be\u00bf\7H\2\2\u00bf\u00c0\7c\2\2\u00c0\u00c1"+
		"\7n\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c4\7g\2\2\u00c3\u00ba\3\2\2\2\u00c3"+
		"\u00be\3\2\2\2\u00c4$\3\2\2\2\u00c5\u00c9\t\2\2\2\u00c6\u00c8\t\3\2\2"+
		"\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca&\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00d5\7\62\2\2\u00cd"+
		"\u00d1\t\4\2\2\u00ce\u00d0\t\5\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2"+
		"\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d4\u00cc\3\2\2\2\u00d4\u00cd\3\2\2\2\u00d5(\3\2\2\2"+
		"\u00d6\u00d7\7)\2\2\u00d7\u00d8\13\2\2\2\u00d8\u00d9\7)\2\2\u00d9*\3\2"+
		"\2\2\u00da\u00db\7\60\2\2\u00db,\3\2\2\2\u00dc\u00dd\7*\2\2\u00dd.\3\2"+
		"\2\2\u00de\u00df\7+\2\2\u00df\60\3\2\2\2\u00e0\u00e1\7<\2\2\u00e1\62\3"+
		"\2\2\2\u00e2\u00e3\7\13\2\2\u00e3\64\3\2\2\2\u00e4\u00e5\7\f\2\2\u00e5"+
		"\66\3\2\2\2\u00e6\u00e7\7\"\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\b\34\2"+
		"\2\u00e98\3\2\2\2\u00ea\u00eb\7`\2\2\u00eb:\3\2\2\2\u00ec\u00ed\7,\2\2"+
		"\u00ed<\3\2\2\2\u00ee\u00ef\7\61\2\2\u00ef>\3\2\2\2\u00f0\u00f1\7-\2\2"+
		"\u00f1@\3\2\2\2\u00f2\u00f3\7/\2\2\u00f3B\3\2\2\2\u00f4\u00f5\7(\2\2\u00f5"+
		"\u00f6\7(\2\2\u00f6D\3\2\2\2\u00f7\u00f8\7~\2\2\u00f8\u00f9\7~\2\2\u00f9"+
		"F\3\2\2\2\u00fa\u00fb\7?\2\2\u00fb\u00fc\7?\2\2\u00fcH\3\2\2\2\u00fd\u00fe"+
		"\7#\2\2\u00fe\u00ff\7?\2\2\u00ffJ\3\2\2\2\u0100\u0101\7>\2\2\u0101\u0102"+
		"\7?\2\2\u0102L\3\2\2\2\u0103\u0104\7>\2\2\u0104N\3\2\2\2\u0105\u0106\7"+
		"@\2\2\u0106\u0107\7?\2\2\u0107P\3\2\2\2\u0108\u0109\7@\2\2\u0109R\3\2"+
		"\2\2\u010a\u010b\7#\2\2\u010bT\3\2\2\2\u010c\u010d\7/\2\2\u010d\u010e"+
		"\7@\2\2\u010eV\3\2\2\2\u010f\u0110\7?\2\2\u0110\u0111\7@\2\2\u0111X\3"+
		"\2\2\2\t\2t\u00b8\u00c3\u00c9\u00d1\u00d4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}