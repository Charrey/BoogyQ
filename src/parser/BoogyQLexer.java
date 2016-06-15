// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/BoogyQ/src\BoogyQ.g4 by ANTLR 4.5.1
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, TYPE=6, ID=7, NUMBER=8, BOOL=9, 
		DEL=10, IF=11, LPAR=12, RPAR=13, COLON=14, TAB=15, NEWLINE=16, WS=17, 
		OPENSCOPE=18, CLOSESCOPE=19, HAT=20, TIMES=21, DIVIDE=22, PLUS=23, MINUS=24, 
		AND=25, OR=26, COMP_EQ=27, COMP_NE=28, COMP_LE=29, COMP_LT=30, COMP_GE=31, 
		COMP_GT=32, NEGATION=33, PLACEOPR=34, PIPEOPR=35;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "TYPE", "ID", "NUMBER", "BOOL", 
		"DEL", "IF", "LPAR", "RPAR", "COLON", "TAB", "NEWLINE", "WS", "OPENSCOPE", 
		"CLOSESCOPE", "HAT", "TIMES", "DIVIDE", "PLUS", "MINUS", "AND", "OR", 
		"COMP_EQ", "COMP_NE", "COMP_LE", "COMP_LT", "COMP_GE", "COMP_GT", "NEGATION", 
		"PLACEOPR", "PIPEOPR"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2%\u00d3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7_\n\7\3\7\3\7\7\7c\n\7\f\7\16"+
		"\7f\13\7\3\b\3\b\7\bj\n\b\f\b\16\bm\13\b\3\t\3\t\3\t\7\tr\n\t\f\t\16\t"+
		"u\13\t\5\tw\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0082\n\n\3\13"+
		"\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3"+
		"#\3#\3#\3$\3$\3$\2\2%\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%\3\2\6\4\2C\\c|\5\2\62;C\\c|\3\2\63;"+
		"\3\2\62;\u00d9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5K\3\2\2\2\7M\3\2\2\2\tO\3\2\2\2\13Q\3\2"+
		"\2\2\r^\3\2\2\2\17g\3\2\2\2\21v\3\2\2\2\23\u0081\3\2\2\2\25\u0083\3\2"+
		"\2\2\27\u0085\3\2\2\2\31\u0088\3\2\2\2\33\u008a\3\2\2\2\35\u008c\3\2\2"+
		"\2\37\u008e\3\2\2\2!\u0090\3\2\2\2#\u0092\3\2\2\2%\u0096\3\2\2\2\'\u00a0"+
		"\3\2\2\2)\u00ab\3\2\2\2+\u00ad\3\2\2\2-\u00af\3\2\2\2/\u00b1\3\2\2\2\61"+
		"\u00b3\3\2\2\2\63\u00b5\3\2\2\2\65\u00b8\3\2\2\2\67\u00bb\3\2\2\29\u00be"+
		"\3\2\2\2;\u00c1\3\2\2\2=\u00c4\3\2\2\2?\u00c6\3\2\2\2A\u00c9\3\2\2\2C"+
		"\u00cb\3\2\2\2E\u00cd\3\2\2\2G\u00d0\3\2\2\2IJ\7]\2\2J\4\3\2\2\2KL\7."+
		"\2\2L\6\3\2\2\2MN\7_\2\2N\b\3\2\2\2OP\7}\2\2P\n\3\2\2\2QR\7\177\2\2R\f"+
		"\3\2\2\2ST\7k\2\2TU\7p\2\2U_\7v\2\2VW\7d\2\2WX\7q\2\2XY\7q\2\2Y_\7n\2"+
		"\2Z[\7e\2\2[\\\7j\2\2\\]\7c\2\2]_\7t\2\2^S\3\2\2\2^V\3\2\2\2^Z\3\2\2\2"+
		"_d\3\2\2\2`a\7]\2\2ac\7_\2\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e"+
		"\16\3\2\2\2fd\3\2\2\2gk\t\2\2\2hj\t\3\2\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2"+
		"\2kl\3\2\2\2l\20\3\2\2\2mk\3\2\2\2nw\7\62\2\2os\t\4\2\2pr\t\5\2\2qp\3"+
		"\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tw\3\2\2\2us\3\2\2\2vn\3\2\2\2vo\3"+
		"\2\2\2w\22\3\2\2\2xy\7V\2\2yz\7t\2\2z{\7w\2\2{\u0082\7g\2\2|}\7H\2\2}"+
		"~\7c\2\2~\177\7n\2\2\177\u0080\7u\2\2\u0080\u0082\7g\2\2\u0081x\3\2\2"+
		"\2\u0081|\3\2\2\2\u0082\24\3\2\2\2\u0083\u0084\7\60\2\2\u0084\26\3\2\2"+
		"\2\u0085\u0086\7k\2\2\u0086\u0087\7h\2\2\u0087\30\3\2\2\2\u0088\u0089"+
		"\7*\2\2\u0089\32\3\2\2\2\u008a\u008b\7+\2\2\u008b\34\3\2\2\2\u008c\u008d"+
		"\7<\2\2\u008d\36\3\2\2\2\u008e\u008f\7\13\2\2\u008f \3\2\2\2\u0090\u0091"+
		"\7\f\2\2\u0091\"\3\2\2\2\u0092\u0093\7\"\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0095\b\22\2\2\u0095$\3\2\2\2\u0096\u0097\7Q\2\2\u0097\u0098\7R\2\2\u0098"+
		"\u0099\7G\2\2\u0099\u009a\7P\2\2\u009a\u009b\7U\2\2\u009b\u009c\7E\2\2"+
		"\u009c\u009d\7Q\2\2\u009d\u009e\7R\2\2\u009e\u009f\7G\2\2\u009f&\3\2\2"+
		"\2\u00a0\u00a1\7E\2\2\u00a1\u00a2\7N\2\2\u00a2\u00a3\7Q\2\2\u00a3\u00a4"+
		"\7U\2\2\u00a4\u00a5\7G\2\2\u00a5\u00a6\7U\2\2\u00a6\u00a7\7E\2\2\u00a7"+
		"\u00a8\7Q\2\2\u00a8\u00a9\7R\2\2\u00a9\u00aa\7G\2\2\u00aa(\3\2\2\2\u00ab"+
		"\u00ac\7`\2\2\u00ac*\3\2\2\2\u00ad\u00ae\7,\2\2\u00ae,\3\2\2\2\u00af\u00b0"+
		"\7\61\2\2\u00b0.\3\2\2\2\u00b1\u00b2\7-\2\2\u00b2\60\3\2\2\2\u00b3\u00b4"+
		"\7/\2\2\u00b4\62\3\2\2\2\u00b5\u00b6\7(\2\2\u00b6\u00b7\7(\2\2\u00b7\64"+
		"\3\2\2\2\u00b8\u00b9\7~\2\2\u00b9\u00ba\7~\2\2\u00ba\66\3\2\2\2\u00bb"+
		"\u00bc\7?\2\2\u00bc\u00bd\7?\2\2\u00bd8\3\2\2\2\u00be\u00bf\7#\2\2\u00bf"+
		"\u00c0\7?\2\2\u00c0:\3\2\2\2\u00c1\u00c2\7>\2\2\u00c2\u00c3\7?\2\2\u00c3"+
		"<\3\2\2\2\u00c4\u00c5\7>\2\2\u00c5>\3\2\2\2\u00c6\u00c7\7@\2\2\u00c7\u00c8"+
		"\7?\2\2\u00c8@\3\2\2\2\u00c9\u00ca\7@\2\2\u00caB\3\2\2\2\u00cb\u00cc\7"+
		"#\2\2\u00ccD\3\2\2\2\u00cd\u00ce\7/\2\2\u00ce\u00cf\7@\2\2\u00cfF\3\2"+
		"\2\2\u00d0\u00d1\7?\2\2\u00d1\u00d2\7@\2\2\u00d2H\3\2\2\2\t\2^dksv\u0081"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}