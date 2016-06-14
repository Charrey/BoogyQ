package parser;

// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/BoogyQ/src\BoogyQ.g4 by ANTLR 4.5.1
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
		ID=1, DEL=2, NUMBER=3, IF=4, BRACKETOPEN=5, BRACKETCLOSE=6, COLON=7, TAB=8, 
		NEWLINE=9, TYPE=10, PLACEOPR=11, PIPEOPR=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ID", "DEL", "NUMBER", "IF", "BRACKETOPEN", "BRACKETCLOSE", "COLON", "TAB", 
		"NEWLINE", "TYPE", "PLACEOPR", "PIPEOPR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'.'", null, "'if'", "'('", "')'", "':'", "'\t'", "'\n'", 
		null, "'->'", "'=>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ID", "DEL", "NUMBER", "IF", "BRACKETOPEN", "BRACKETCLOSE", "COLON", 
		"TAB", "NEWLINE", "TYPE", "PLACEOPR", "PIPEOPR"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16R\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\3\3\3\3\4\3\4"+
		"\7\4\'\n\4\f\4\16\4*\13\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13D"+
		"\n\13\3\13\3\13\7\13H\n\13\f\13\16\13K\13\13\3\f\3\f\3\f\3\r\3\r\3\r\2"+
		"\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\6\4"+
		"\2C\\c|\5\2\62;C\\c|\3\2\63;\3\2\62;V\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5\"\3"+
		"\2\2\2\7$\3\2\2\2\t+\3\2\2\2\13.\3\2\2\2\r\60\3\2\2\2\17\62\3\2\2\2\21"+
		"\64\3\2\2\2\23\66\3\2\2\2\25C\3\2\2\2\27L\3\2\2\2\31O\3\2\2\2\33\37\t"+
		"\2\2\2\34\36\t\3\2\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2"+
		"\2 \4\3\2\2\2!\37\3\2\2\2\"#\7\60\2\2#\6\3\2\2\2$(\t\4\2\2%\'\t\5\2\2"+
		"&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\b\3\2\2\2*(\3\2\2\2+,\7k\2"+
		"\2,-\7h\2\2-\n\3\2\2\2./\7*\2\2/\f\3\2\2\2\60\61\7+\2\2\61\16\3\2\2\2"+
		"\62\63\7<\2\2\63\20\3\2\2\2\64\65\7\13\2\2\65\22\3\2\2\2\66\67\7\f\2\2"+
		"\67\24\3\2\2\289\7k\2\29:\7p\2\2:D\7v\2\2;<\7d\2\2<=\7q\2\2=>\7q\2\2>"+
		"D\7n\2\2?@\7e\2\2@A\7j\2\2AB\7c\2\2BD\7t\2\2C8\3\2\2\2C;\3\2\2\2C?\3\2"+
		"\2\2DI\3\2\2\2EF\7]\2\2FH\7_\2\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2"+
		"\2J\26\3\2\2\2KI\3\2\2\2LM\7/\2\2MN\7@\2\2N\30\3\2\2\2OP\7?\2\2PQ\7@\2"+
		"\2Q\32\3\2\2\2\7\2\37(CI\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}