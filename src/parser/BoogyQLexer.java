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
		TYPE=1, ID=2, DEL=3, NUMBER=4, IF=5, LPAR=6, RPAR=7, COLON=8, TAB=9, NEWLINE=10, 
		WS=11, HAT=12, TIMES=13, DIVIDE=14, PLUS=15, MINUS=16, AND=17, OR=18, 
		COMP_EQ=19, COMP_NE=20, COMP_LE=21, COMP_LT=22, COMP_GE=23, COMP_GT=24, 
		NEGATION=25, PLACEOPR=26, PIPEOPR=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TYPE", "ID", "DEL", "NUMBER", "IF", "LPAR", "RPAR", "COLON", "TAB", "NEWLINE", 
		"WS", "HAT", "TIMES", "DIVIDE", "PLUS", "MINUS", "AND", "OR", "COMP_EQ", 
		"COMP_NE", "COMP_LE", "COMP_LT", "COMP_GE", "COMP_GT", "NEGATION", "PLACEOPR", 
		"PIPEOPR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'.'", null, "'if'", "'('", "')'", "':'", "'\t'", "'\n'", 
		"' '", "'^'", "'*'", "'/'", "'+'", "'-'", "'&&'", "'||'", "'=='", "'!='", 
		"'<='", "'<'", "'>='", "'>'", "'!'", "'->'", "'=>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TYPE", "ID", "DEL", "NUMBER", "IF", "LPAR", "RPAR", "COLON", "TAB", 
		"NEWLINE", "WS", "HAT", "TIMES", "DIVIDE", "PLUS", "MINUS", "AND", "OR", 
		"COMP_EQ", "COMP_NE", "COMP_LE", "COMP_LT", "COMP_GE", "COMP_GT", "NEGATION", 
		"PLACEOPR", "PIPEOPR"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u0096\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\5\2E\n\2\3\2\3\2\7\2I\n\2\f\2\16\2L\13\2\3\3\3\3\7\3P\n\3\f"+
		"\3\16\3S\13\3\3\4\3\4\3\5\3\5\7\5Y\n\5\f\5\16\5\\\13\5\3\6\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\2\2\35\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\6\4\2C\\c|\5\2\62;C\\"+
		"c|\3\2\63;\3\2\62;\u009a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\3D\3\2\2\2\5M\3\2\2\2\7T\3\2\2\2\tV\3\2\2\2\13]\3\2\2\2\r`\3\2"+
		"\2\2\17b\3\2\2\2\21d\3\2\2\2\23f\3\2\2\2\25h\3\2\2\2\27j\3\2\2\2\31n\3"+
		"\2\2\2\33p\3\2\2\2\35r\3\2\2\2\37t\3\2\2\2!v\3\2\2\2#x\3\2\2\2%{\3\2\2"+
		"\2\'~\3\2\2\2)\u0081\3\2\2\2+\u0084\3\2\2\2-\u0087\3\2\2\2/\u0089\3\2"+
		"\2\2\61\u008c\3\2\2\2\63\u008e\3\2\2\2\65\u0090\3\2\2\2\67\u0093\3\2\2"+
		"\29:\7k\2\2:;\7p\2\2;E\7v\2\2<=\7d\2\2=>\7q\2\2>?\7q\2\2?E\7n\2\2@A\7"+
		"e\2\2AB\7j\2\2BC\7c\2\2CE\7t\2\2D9\3\2\2\2D<\3\2\2\2D@\3\2\2\2EJ\3\2\2"+
		"\2FG\7]\2\2GI\7_\2\2HF\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\4\3\2\2"+
		"\2LJ\3\2\2\2MQ\t\2\2\2NP\t\3\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2"+
		"\2R\6\3\2\2\2SQ\3\2\2\2TU\7\60\2\2U\b\3\2\2\2VZ\t\4\2\2WY\t\5\2\2XW\3"+
		"\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\n\3\2\2\2\\Z\3\2\2\2]^\7k\2\2^"+
		"_\7h\2\2_\f\3\2\2\2`a\7*\2\2a\16\3\2\2\2bc\7+\2\2c\20\3\2\2\2de\7<\2\2"+
		"e\22\3\2\2\2fg\7\13\2\2g\24\3\2\2\2hi\7\f\2\2i\26\3\2\2\2jk\7\"\2\2kl"+
		"\3\2\2\2lm\b\f\2\2m\30\3\2\2\2no\7`\2\2o\32\3\2\2\2pq\7,\2\2q\34\3\2\2"+
		"\2rs\7\61\2\2s\36\3\2\2\2tu\7-\2\2u \3\2\2\2vw\7/\2\2w\"\3\2\2\2xy\7("+
		"\2\2yz\7(\2\2z$\3\2\2\2{|\7~\2\2|}\7~\2\2}&\3\2\2\2~\177\7?\2\2\177\u0080"+
		"\7?\2\2\u0080(\3\2\2\2\u0081\u0082\7#\2\2\u0082\u0083\7?\2\2\u0083*\3"+
		"\2\2\2\u0084\u0085\7>\2\2\u0085\u0086\7?\2\2\u0086,\3\2\2\2\u0087\u0088"+
		"\7>\2\2\u0088.\3\2\2\2\u0089\u008a\7@\2\2\u008a\u008b\7?\2\2\u008b\60"+
		"\3\2\2\2\u008c\u008d\7@\2\2\u008d\62\3\2\2\2\u008e\u008f\7#\2\2\u008f"+
		"\64\3\2\2\2\u0090\u0091\7/\2\2\u0091\u0092\7@\2\2\u0092\66\3\2\2\2\u0093"+
		"\u0094\7?\2\2\u0094\u0095\7@\2\2\u00958\3\2\2\2\7\2DJQZ\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}