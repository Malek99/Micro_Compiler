// Generated from Micro.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD=1, OPERATOR=2, IDENTIFIER=3, INTLITERAL=4, FLOATLITERAL=5, STRINGLITERAL=6, 
		COMMENT=7, WS=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"KEYWORD", "OPERATOR", "IDENTIFIER", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", 
			"COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KEYWORD", "OPERATOR", "IDENTIFIER", "INTLITERAL", "FLOATLITERAL", 
			"STRINGLITERAL", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public MicroLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Micro.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\n\u00a4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\5\2`\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3l\n\3"+
		"\3\4\5\4o\n\4\3\4\7\4r\n\4\f\4\16\4u\13\4\3\5\6\5x\n\5\r\5\16\5y\3\6\7"+
		"\6}\n\6\f\6\16\6\u0080\13\6\3\6\3\6\6\6\u0084\n\6\r\6\16\6\u0085\3\7\3"+
		"\7\7\7\u008a\n\7\f\7\16\7\u008d\13\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u0095"+
		"\n\b\f\b\16\b\u0098\13\b\3\b\3\b\3\b\3\b\3\t\6\t\u009f\n\t\r\t\16\t\u00a0"+
		"\3\t\3\t\2\2\n\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\3\2\n\6\2,-//\61\61"+
		"??\6\2*+..=>@@\4\2C\\c|\5\2\62;C\\c|\3\2\62;\3\2$$\3\2\f\f\5\2\13\f\17"+
		"\17\"\"\2\u00be\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3_\3\2\2\2\5k\3\2\2\2\7n"+
		"\3\2\2\2\tw\3\2\2\2\13~\3\2\2\2\r\u0087\3\2\2\2\17\u0090\3\2\2\2\21\u009e"+
		"\3\2\2\2\23\24\7R\2\2\24\25\7T\2\2\25\26\7Q\2\2\26\27\7I\2\2\27\30\7T"+
		"\2\2\30\31\7C\2\2\31`\7O\2\2\32\33\7D\2\2\33\34\7G\2\2\34\35\7I\2\2\35"+
		"\36\7K\2\2\36`\7P\2\2\37 \7G\2\2 !\7P\2\2!`\7F\2\2\"#\7H\2\2#$\7W\2\2"+
		"$%\7P\2\2%&\7E\2\2&\'\7V\2\2\'(\7K\2\2()\7Q\2\2)`\7P\2\2*+\7T\2\2+,\7"+
		"G\2\2,-\7C\2\2-`\7F\2\2./\7Y\2\2/\60\7T\2\2\60\61\7K\2\2\61\62\7V\2\2"+
		"\62`\7G\2\2\63\64\7K\2\2\64`\7H\2\2\65\66\7G\2\2\66\67\7N\2\2\678\7U\2"+
		"\28`\7G\2\29:\7G\2\2:;\7P\2\2;<\7F\2\2<=\7K\2\2=`\7H\2\2>?\7H\2\2?@\7"+
		"Q\2\2@`\7T\2\2AB\7G\2\2BC\7P\2\2CD\7F\2\2DE\7H\2\2EF\7Q\2\2F`\7T\2\2G"+
		"H\7T\2\2HI\7G\2\2IJ\7V\2\2JK\7W\2\2KL\7T\2\2L`\7P\2\2MN\7K\2\2NO\7P\2"+
		"\2O`\7V\2\2PQ\7X\2\2QR\7Q\2\2RS\7K\2\2S`\7F\2\2TU\7U\2\2UV\7V\2\2VW\7"+
		"T\2\2WX\7K\2\2XY\7P\2\2Y`\7I\2\2Z[\7H\2\2[\\\7N\2\2\\]\7Q\2\2]^\7C\2\2"+
		"^`\7V\2\2_\23\3\2\2\2_\32\3\2\2\2_\37\3\2\2\2_\"\3\2\2\2_*\3\2\2\2_.\3"+
		"\2\2\2_\63\3\2\2\2_\65\3\2\2\2_9\3\2\2\2_>\3\2\2\2_A\3\2\2\2_G\3\2\2\2"+
		"_M\3\2\2\2_P\3\2\2\2_T\3\2\2\2_Z\3\2\2\2`\4\3\2\2\2ab\7<\2\2bl\7?\2\2"+
		"cl\t\2\2\2de\7#\2\2el\7?\2\2fl\t\3\2\2gh\7>\2\2hl\7?\2\2ij\7@\2\2jl\7"+
		"?\2\2ka\3\2\2\2kc\3\2\2\2kd\3\2\2\2kf\3\2\2\2kg\3\2\2\2ki\3\2\2\2l\6\3"+
		"\2\2\2mo\t\4\2\2nm\3\2\2\2os\3\2\2\2pr\t\5\2\2qp\3\2\2\2ru\3\2\2\2sq\3"+
		"\2\2\2st\3\2\2\2t\b\3\2\2\2us\3\2\2\2vx\t\6\2\2wv\3\2\2\2xy\3\2\2\2yw"+
		"\3\2\2\2yz\3\2\2\2z\n\3\2\2\2{}\t\6\2\2|{\3\2\2\2}\u0080\3\2\2\2~|\3\2"+
		"\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0083\7\60\2"+
		"\2\u0082\u0084\t\6\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0085\u0086\3\2\2\2\u0086\f\3\2\2\2\u0087\u008b\7$\2\2\u0088"+
		"\u008a\n\7\2\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2"+
		"\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e"+
		"\u008f\7$\2\2\u008f\16\3\2\2\2\u0090\u0091\7/\2\2\u0091\u0092\7/\2\2\u0092"+
		"\u0096\3\2\2\2\u0093\u0095\n\b\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2"+
		"\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u009a\7\f\2\2\u009a\u009b\3\2\2\2\u009b\u009c\b\b"+
		"\2\2\u009c\20\3\2\2\2\u009d\u009f\t\t\2\2\u009e\u009d\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a3\b\t\2\2\u00a3\22\3\2\2\2\16\2_knqsy~\u0085\u008b\u0096\u00a0\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}