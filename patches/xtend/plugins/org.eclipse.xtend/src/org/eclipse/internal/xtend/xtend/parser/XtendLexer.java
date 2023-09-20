// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/org/eclipse/internal/xtend/xtend/parser/Xtend.g 2015-11-18 22:41:58

package org.eclipse.internal.xtend.xtend.parser;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

@SuppressWarnings("all")
public class XtendLexer extends Lexer {
	public static final int T__50 = 50;
	public static final int T__19 = 19;
	public static final int Identifier = 6;
	public static final int T__59 = 59;
	public static final int T__18 = 18;
	public static final int T__55 = 55;
	public static final int T__56 = 56;
	public static final int T__57 = 57;
	public static final int IntLiteral = 5;
	public static final int T__58 = 58;
	public static final int T__51 = 51;
	public static final int T__52 = 52;
	public static final int T__53 = 53;
	public static final int T__54 = 54;
	public static final int T__60 = 60;
	public static final int T__61 = 61;
	public static final int HexDigit = 10;
	public static final int Letter = 11;
	public static final int LINE_COMMENT = 15;
	public static final int T__26 = 26;
	public static final int StringLiteral = 4;
	public static final int T__27 = 27;
	public static final int T__28 = 28;
	public static final int T__29 = 29;
	public static final int T__22 = 22;
	public static final int T__66 = 66;
	public static final int T__23 = 23;
	public static final int T__67 = 67;
	public static final int T__24 = 24;
	public static final int T__68 = 68;
	public static final int T__25 = 25;
	public static final int T__69 = 69;
	public static final int T__62 = 62;
	public static final int OctalEscape = 9;
	public static final int JavaIDDigit = 12;
	public static final int T__63 = 63;
	public static final int T__20 = 20;
	public static final int T__64 = 64;
	public static final int T__21 = 21;
	public static final int T__65 = 65;
	public static final int T__70 = 70;
	public static final int T__71 = 71;
	public static final int T__72 = 72;
	public static final int COMMENT = 14;
	public static final int XPAND_TAG_OPEN = 16;
	public static final int T__37 = 37;
	public static final int T__38 = 38;
	public static final int T__39 = 39;
	public static final int T__33 = 33;
	public static final int T__77 = 77;
	public static final int T__34 = 34;
	public static final int T__78 = 78;
	public static final int T__35 = 35;
	public static final int T__79 = 79;
	public static final int T__36 = 36;
	public static final int T__73 = 73;
	public static final int UnicodeEscape = 8;
	public static final int WS = 13;
	public static final int EOF = -1;
	public static final int T__30 = 30;
	public static final int T__74 = 74;
	public static final int T__31 = 31;
	public static final int T__75 = 75;
	public static final int T__32 = 32;
	public static final int T__76 = 76;
	public static final int XPAND_TAG_CLOSE = 17;
	public static final int T__80 = 80;
	public static final int T__81 = 81;
	public static final int T__82 = 82;
	public static final int EscapeSequence = 7;
	public static final int T__48 = 48;
	public static final int T__49 = 49;
	public static final int T__44 = 44;
	public static final int T__45 = 45;
	public static final int T__46 = 46;
	public static final int T__47 = 47;
	public static final int T__40 = 40;
	public static final int T__41 = 41;
	public static final int T__42 = 42;
	public static final int T__43 = 43;

	// delegates
	// delegators

	public XtendLexer() {
		;
	}

	public XtendLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public XtendLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);

	}

	public String getGrammarFileName() {
		return "src/org/eclipse/internal/xtend/xtend/parser/Xtend.g";
	}

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:14:7: ( 'import' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:14:9: 'import'
			{
				match("import");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:15:7: ( ';' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:15:9: ';'
			{
				match(';');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:16:7: ( 'extension' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:16:9: 'extension'
			{
				match("extension");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:17:7: ( 'reexport' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:17:9: 'reexport'
			{
				match("reexport");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:18:7: ( 'context' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:18:9: 'context'
			{
				match("context");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:19:7: ( '#' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:19:9: '#'
			{
				match('#');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:20:7: ( 'if' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:20:9: 'if'
			{
				match("if");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:21:7: ( 'ERROR' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:21:9: 'ERROR'
			{
				match("ERROR");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:22:7: ( 'WARNING' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:22:9: 'WARNING'
			{
				match("WARNING");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:23:7: ( ':' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:23:9: ':'
			{
				match(':');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:24:7: ( 'around' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:24:9: 'around'
			{
				match("around");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:25:7: ( '(' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:25:9: '('
			{
				match('(');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:26:7: ( ',' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:26:9: ','
			{
				match(',');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:27:7: ( '*' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:27:9: '*'
			{
				match('*');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:28:7: ( ')' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:28:9: ')'
			{
				match(')');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:29:7: ( '::' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:29:9: '::'
			{
				match("::");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:30:7: ( 'private' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:30:9: 'private'
			{
				match("private");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:31:7: ( 'cached' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:31:9: 'cached'
			{
				match("cached");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:32:7: ( 'JAVA' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:32:9: 'JAVA'
			{
				match("JAVA");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:33:7: ( '.' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:33:9: '.'
			{
				match('.');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__37"

	// $ANTLR start "T__38"
	public final void mT__38() throws RecognitionException {
		try {
			int _type = T__38;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:34:7: ( 'create' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:34:9: 'create'
			{
				match("create");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__38"

	// $ANTLR start "T__39"
	public final void mT__39() throws RecognitionException {
		try {
			int _type = T__39;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:35:7: ( 'Collection' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:35:9: 'Collection'
			{
				match("Collection");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__39"

	// $ANTLR start "T__40"
	public final void mT__40() throws RecognitionException {
		try {
			int _type = T__40;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:36:7: ( 'List' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:36:9: 'List'
			{
				match("List");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__40"

	// $ANTLR start "T__41"
	public final void mT__41() throws RecognitionException {
		try {
			int _type = T__41;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:37:7: ( 'Set' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:37:9: 'Set'
			{
				match("Set");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__41"

	// $ANTLR start "T__42"
	public final void mT__42() throws RecognitionException {
		try {
			int _type = T__42;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:38:7: ( 'let' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:38:9: 'let'
			{
				match("let");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__42"

	// $ANTLR start "T__43"
	public final void mT__43() throws RecognitionException {
		try {
			int _type = T__43;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:39:7: ( '=' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:39:9: '='
			{
				match('=');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__43"

	// $ANTLR start "T__44"
	public final void mT__44() throws RecognitionException {
		try {
			int _type = T__44;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:40:7: ( '->' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:40:9: '->'
			{
				match("->");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__44"

	// $ANTLR start "T__45"
	public final void mT__45() throws RecognitionException {
		try {
			int _type = T__45;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:41:7: ( '?' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:41:9: '?'
			{
				match('?');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__45"

	// $ANTLR start "T__46"
	public final void mT__46() throws RecognitionException {
		try {
			int _type = T__46;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:42:7: ( 'then' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:42:9: 'then'
			{
				match("then");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__46"

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:43:7: ( 'else' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:43:9: 'else'
			{
				match("else");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:44:7: ( 'switch' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:44:9: 'switch'
			{
				match("switch");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__48"

	// $ANTLR start "T__49"
	public final void mT__49() throws RecognitionException {
		try {
			int _type = T__49;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:45:7: ( '{' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:45:9: '{'
			{
				match('{');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__49"

	// $ANTLR start "T__50"
	public final void mT__50() throws RecognitionException {
		try {
			int _type = T__50;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:46:7: ( 'case' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:46:9: 'case'
			{
				match("case");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__50"

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:47:7: ( 'default' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:47:9: 'default'
			{
				match("default");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__51"

	// $ANTLR start "T__52"
	public final void mT__52() throws RecognitionException {
		try {
			int _type = T__52;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:48:7: ( '}' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:48:9: '}'
			{
				match('}');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__52"

	// $ANTLR start "T__53"
	public final void mT__53() throws RecognitionException {
		try {
			int _type = T__53;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:49:7: ( '||' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:49:9: '||'
			{
				match("||");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__53"

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:50:7: ( '&&' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:50:9: '&&'
			{
				match("&&");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__54"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:51:7: ( 'implies' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:51:9: 'implies'
			{
				match("implies");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__55"

	// $ANTLR start "T__56"
	public final void mT__56() throws RecognitionException {
		try {
			int _type = T__56;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:52:7: ( '==' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:52:9: '=='
			{
				match("==");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__56"

	// $ANTLR start "T__57"
	public final void mT__57() throws RecognitionException {
		try {
			int _type = T__57;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:53:7: ( '!=' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:53:9: '!='
			{
				match("!=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__57"

	// $ANTLR start "T__58"
	public final void mT__58() throws RecognitionException {
		try {
			int _type = T__58;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:54:7: ( '>=' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:54:9: '>='
			{
				match(">=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__58"

	// $ANTLR start "T__59"
	public final void mT__59() throws RecognitionException {
		try {
			int _type = T__59;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:55:7: ( '<=' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:55:9: '<='
			{
				match("<=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__59"

	// $ANTLR start "T__60"
	public final void mT__60() throws RecognitionException {
		try {
			int _type = T__60;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:56:7: ( '>' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:56:9: '>'
			{
				match('>');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__60"

	// $ANTLR start "T__61"
	public final void mT__61() throws RecognitionException {
		try {
			int _type = T__61;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:57:7: ( '<' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:57:9: '<'
			{
				match('<');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__61"

	// $ANTLR start "T__62"
	public final void mT__62() throws RecognitionException {
		try {
			int _type = T__62;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:58:7: ( '+' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:58:9: '+'
			{
				match('+');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__62"

	// $ANTLR start "T__63"
	public final void mT__63() throws RecognitionException {
		try {
			int _type = T__63;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:59:7: ( '-' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:59:9: '-'
			{
				match('-');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__63"

	// $ANTLR start "T__64"
	public final void mT__64() throws RecognitionException {
		try {
			int _type = T__64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:60:7: ( '/' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:60:9: '/'
			{
				match('/');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__64"

	// $ANTLR start "T__65"
	public final void mT__65() throws RecognitionException {
		try {
			int _type = T__65;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:61:7: ( '!' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:61:9: '!'
			{
				match('!');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__65"

	// $ANTLR start "T__66"
	public final void mT__66() throws RecognitionException {
		try {
			int _type = T__66;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:62:7: ( 'GLOBALVAR' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:62:9: 'GLOBALVAR'
			{
				match("GLOBALVAR");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__66"

	// $ANTLR start "T__67"
	public final void mT__67() throws RecognitionException {
		try {
			int _type = T__67;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:63:7: ( 'new' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:63:9: 'new'
			{
				match("new");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__67"

	// $ANTLR start "T__68"
	public final void mT__68() throws RecognitionException {
		try {
			int _type = T__68;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:64:7: ( 'false' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:64:9: 'false'
			{
				match("false");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__68"

	// $ANTLR start "T__69"
	public final void mT__69() throws RecognitionException {
		try {
			int _type = T__69;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:65:7: ( 'true' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:65:9: 'true'
			{
				match("true");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__69"

	// $ANTLR start "T__70"
	public final void mT__70() throws RecognitionException {
		try {
			int _type = T__70;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:66:7: ( 'null' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:66:9: 'null'
			{
				match("null");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__70"

	// $ANTLR start "T__71"
	public final void mT__71() throws RecognitionException {
		try {
			int _type = T__71;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:67:7: ( 'typeSelect' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:67:9: 'typeSelect'
			{
				match("typeSelect");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__71"

	// $ANTLR start "T__72"
	public final void mT__72() throws RecognitionException {
		try {
			int _type = T__72;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:68:7: ( 'collect' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:68:9: 'collect'
			{
				match("collect");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__72"

	// $ANTLR start "T__73"
	public final void mT__73() throws RecognitionException {
		try {
			int _type = T__73;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:69:7: ( 'select' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:69:9: 'select'
			{
				match("select");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__73"

	// $ANTLR start "T__74"
	public final void mT__74() throws RecognitionException {
		try {
			int _type = T__74;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:70:7: ( 'selectFirst' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:70:9: 'selectFirst'
			{
				match("selectFirst");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__74"

	// $ANTLR start "T__75"
	public final void mT__75() throws RecognitionException {
		try {
			int _type = T__75;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:71:7: ( 'reject' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:71:9: 'reject'
			{
				match("reject");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__75"

	// $ANTLR start "T__76"
	public final void mT__76() throws RecognitionException {
		try {
			int _type = T__76;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:72:7: ( 'exists' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:72:9: 'exists'
			{
				match("exists");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__76"

	// $ANTLR start "T__77"
	public final void mT__77() throws RecognitionException {
		try {
			int _type = T__77;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:73:7: ( 'notExists' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:73:9: 'notExists'
			{
				match("notExists");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__77"

	// $ANTLR start "T__78"
	public final void mT__78() throws RecognitionException {
		try {
			int _type = T__78;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:74:7: ( 'sortBy' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:74:9: 'sortBy'
			{
				match("sortBy");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__78"

	// $ANTLR start "T__79"
	public final void mT__79() throws RecognitionException {
		try {
			int _type = T__79;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:75:7: ( 'forAll' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:75:9: 'forAll'
			{
				match("forAll");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__79"

	// $ANTLR start "T__80"
	public final void mT__80() throws RecognitionException {
		try {
			int _type = T__80;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:76:7: ( '|' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:76:9: '|'
			{
				match('|');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__80"

	// $ANTLR start "T__81"
	public final void mT__81() throws RecognitionException {
		try {
			int _type = T__81;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:77:7: ( '[' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:77:9: '['
			{
				match('[');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__81"

	// $ANTLR start "T__82"
	public final void mT__82() throws RecognitionException {
		try {
			int _type = T__82;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:78:7: ( ']' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:78:9: ']'
			{
				match(']');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__82"

	// $ANTLR start "IntLiteral"
	public final void mIntLiteral() throws RecognitionException {
		try {
			int _type = IntLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:427:12: ( ( '0' .. '9' )+ )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:427:14: ( '0' .. '9' )+
			{
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:427:14: ( '0' .. '9' )+
				int cnt1 = 0;
				loop1: do {
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if (((LA1_0 >= '0' && LA1_0 <= '9'))) {
						alt1 = 1;
					}

					switch (alt1) {
					case 1:
					// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:427:14: '0' .. '9'
					{
						matchRange('0', '9');

					}
						break;

					default:
						if (cnt1 >= 1)
							break loop1;
						EarlyExitException eee = new EarlyExitException(1, input);
						throw eee;
					}
					cnt1++;
				} while (true);

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "IntLiteral"

	// $ANTLR start "StringLiteral"
	public final void mStringLiteral() throws RecognitionException {
		try {
			int _type = StringLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:430:5: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' (
			// EscapeSequence | ~ ( '\\'' | '\\\\' ) )* '\\'' )
			int alt4 = 2;
			int LA4_0 = input.LA(1);

			if ((LA4_0 == '\"')) {
				alt4 = 1;
			} else if ((LA4_0 == '\'')) {
				alt4 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 4, 0, input);

				throw nvae;
			}
			switch (alt4) {
			case 1:
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:430:8: '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"'
			{
				match('\"');
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:430:12: ( EscapeSequence | ~ ( '\\\\' | '\"' ) )*
				loop2: do {
					int alt2 = 3;
					int LA2_0 = input.LA(1);

					if ((LA2_0 == '\\')) {
						alt2 = 1;
					} else if (((LA2_0 >= '\u0000' && LA2_0 <= '!') || (LA2_0 >= '#' && LA2_0 <= '[') || (LA2_0 >= ']' && LA2_0 <= '\uFFFF'))) {
						alt2 = 2;
					}

					switch (alt2) {
					case 1:
					// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:430:14: EscapeSequence
					{
						mEscapeSequence();

					}
						break;
					case 2:
					// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:430:31: ~ ( '\\\\' | '\"' )
					{
						if ((input.LA(1) >= '\u0000' && input.LA(1) <= '!') || (input.LA(1) >= '#' && input.LA(1) <= '[')
								|| (input.LA(1) >= ']' && input.LA(1) <= '\uFFFF')) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}

					}
						break;

					default:
						break loop2;
					}
				} while (true);

				match('\"');

			}
				break;
			case 2:
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:431:8: '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )* '\\''
			{
				match('\'');
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:431:13: ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )*
				loop3: do {
					int alt3 = 3;
					int LA3_0 = input.LA(1);

					if ((LA3_0 == '\\')) {
						alt3 = 1;
					} else if (((LA3_0 >= '\u0000' && LA3_0 <= '&') || (LA3_0 >= '(' && LA3_0 <= '[') || (LA3_0 >= ']' && LA3_0 <= '\uFFFF'))) {
						alt3 = 2;
					}

					switch (alt3) {
					case 1:
					// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:431:15: EscapeSequence
					{
						mEscapeSequence();

					}
						break;
					case 2:
					// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:431:32: ~ ( '\\'' | '\\\\' )
					{
						if ((input.LA(1) >= '\u0000' && input.LA(1) <= '&') || (input.LA(1) >= '(' && input.LA(1) <= '[')
								|| (input.LA(1) >= ']' && input.LA(1) <= '\uFFFF')) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}

					}
						break;

					default:
						break loop3;
					}
				} while (true);

				match('\'');

			}
				break;

			}
			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "StringLiteral"

	// $ANTLR start "EscapeSequence"
	public final void mEscapeSequence() throws RecognitionException {
		try {
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:436:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) |
			// UnicodeEscape | OctalEscape )
			int alt5 = 3;
			int LA5_0 = input.LA(1);

			if ((LA5_0 == '\\')) {
				switch (input.LA(2)) {
				case '\"':
				case '\'':
				case '\\':
				case 'b':
				case 'f':
				case 'n':
				case 'r':
				case 't': {
					alt5 = 1;
				}
					break;
				case 'u': {
					alt5 = 2;
				}
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7': {
					alt5 = 3;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("", 5, 1, input);

					throw nvae;
				}

			} else {
				NoViableAltException nvae = new NoViableAltException("", 5, 0, input);

				throw nvae;
			}
			switch (alt5) {
			case 1:
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:436:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
			{
				match('\\');
				if (input.LA(1) == '\"' || input.LA(1) == '\'' || input.LA(1) == '\\' || input.LA(1) == 'b' || input.LA(1) == 'f'
						|| input.LA(1) == 'n' || input.LA(1) == 'r' || input.LA(1) == 't') {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

			}
				break;
			case 2:
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:437:9: UnicodeEscape
			{
				mUnicodeEscape();

			}
				break;
			case 3:
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:438:9: OctalEscape
			{
				mOctalEscape();

			}
				break;

			}
		} finally {
		}
	}

	// $ANTLR end "EscapeSequence"

	// $ANTLR start "OctalEscape"
	public final void mOctalEscape() throws RecognitionException {
		try {
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:443:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7'
			// ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
			int alt6 = 3;
			int LA6_0 = input.LA(1);

			if ((LA6_0 == '\\')) {
				int LA6_1 = input.LA(2);

				if (((LA6_1 >= '0' && LA6_1 <= '3'))) {
					int LA6_2 = input.LA(3);

					if (((LA6_2 >= '0' && LA6_2 <= '7'))) {
						int LA6_4 = input.LA(4);

						if (((LA6_4 >= '0' && LA6_4 <= '7'))) {
							alt6 = 1;
						} else {
							alt6 = 2;
						}
					} else {
						alt6 = 3;
					}
				} else if (((LA6_1 >= '4' && LA6_1 <= '7'))) {
					int LA6_3 = input.LA(3);

					if (((LA6_3 >= '0' && LA6_3 <= '7'))) {
						alt6 = 2;
					} else {
						alt6 = 3;
					}
				} else {
					NoViableAltException nvae = new NoViableAltException("", 6, 1, input);

					throw nvae;
				}
			} else {
				NoViableAltException nvae = new NoViableAltException("", 6, 0, input);

				throw nvae;
			}
			switch (alt6) {
			case 1:
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:443:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
			{
				match('\\');
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:443:14: ( '0' .. '3' )
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:443:15: '0' .. '3'
				{
					matchRange('0', '3');

				}

				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:443:25: ( '0' .. '7' )
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:443:26: '0' .. '7'
				{
					matchRange('0', '7');

				}

				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:443:36: ( '0' .. '7' )
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:443:37: '0' .. '7'
				{
					matchRange('0', '7');

				}

			}
				break;
			case 2:
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:444:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
			{
				match('\\');
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:444:14: ( '0' .. '7' )
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:444:15: '0' .. '7'
				{
					matchRange('0', '7');

				}

				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:444:25: ( '0' .. '7' )
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:444:26: '0' .. '7'
				{
					matchRange('0', '7');

				}

			}
				break;
			case 3:
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:445:9: '\\\\' ( '0' .. '7' )
			{
				match('\\');
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:445:14: ( '0' .. '7' )
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:445:15: '0' .. '7'
				{
					matchRange('0', '7');

				}

			}
				break;

			}
		} finally {
		}
	}

	// $ANTLR end "OctalEscape"

	// $ANTLR start "UnicodeEscape"
	public final void mUnicodeEscape() throws RecognitionException {
		try {
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:450:5: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:450:9: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
			{
				match('\\');
				match('u');
				mHexDigit();
				mHexDigit();
				mHexDigit();
				mHexDigit();

			}

		} finally {
		}
	}

	// $ANTLR end "UnicodeEscape"

	// $ANTLR start "HexDigit"
	public final void mHexDigit() throws RecognitionException {
		try {
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:453:10: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:453:12: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
			{
				if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'F')
						|| (input.LA(1) >= 'a' && input.LA(1) <= 'f')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

			}

		} finally {
		}
	}

	// $ANTLR end "HexDigit"

	// $ANTLR start "Identifier"
	public final void mIdentifier() throws RecognitionException {
		try {
			int _type = Identifier;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:456:5: ( ( '^' )? Letter ( Letter | JavaIDDigit )* )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:456:9: ( '^' )? Letter ( Letter | JavaIDDigit )*
			{
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:456:9: ( '^' )?
				int alt7 = 2;
				int LA7_0 = input.LA(1);

				if ((LA7_0 == '^')) {
					alt7 = 1;
				}
				switch (alt7) {
				case 1:
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:456:10: '^'
				{
					match('^');

				}
					break;

				}

				mLetter();
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:456:23: ( Letter | JavaIDDigit )*
				loop8: do {
					int alt8 = 2;
					int LA8_0 = input.LA(1);

					if ((LA8_0 == '$' || (LA8_0 >= '0' && LA8_0 <= '9') || (LA8_0 >= 'A' && LA8_0 <= 'Z') || LA8_0 == '_'
							|| (LA8_0 >= 'a' && LA8_0 <= 'z') || (LA8_0 >= '\u00C0' && LA8_0 <= '\u00D6') || (LA8_0 >= '\u00D8' && LA8_0 <= '\u00F6')
							|| (LA8_0 >= '\u00F8' && LA8_0 <= '\u1FFF') || (LA8_0 >= '\u3040' && LA8_0 <= '\u318F')
							|| (LA8_0 >= '\u3300' && LA8_0 <= '\u337F') || (LA8_0 >= '\u3400' && LA8_0 <= '\u3D2D')
							|| (LA8_0 >= '\u4E00' && LA8_0 <= '\u9FFF') || (LA8_0 >= '\uF900' && LA8_0 <= '\uFAFF'))) {
						alt8 = 1;
					}

					switch (alt8) {
					case 1:
					// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:
					{
						if (input.LA(1) == '$' || (input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z')
								|| input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')
								|| (input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6') || (input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6')
								|| (input.LA(1) >= '\u00F8' && input.LA(1) <= '\u1FFF') || (input.LA(1) >= '\u3040' && input.LA(1) <= '\u318F')
								|| (input.LA(1) >= '\u3300' && input.LA(1) <= '\u337F') || (input.LA(1) >= '\u3400' && input.LA(1) <= '\u3D2D')
								|| (input.LA(1) >= '\u4E00' && input.LA(1) <= '\u9FFF') || (input.LA(1) >= '\uF900' && input.LA(1) <= '\uFAFF')) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}

					}
						break;

					default:
						break loop8;
					}
				} while (true);

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "Identifier"

	// $ANTLR start "Letter"
	public final void mLetter() throws RecognitionException {
		try {
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:461:5: ( '\\u0024' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' |
			// '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u00ff' | '\\u0100' .. '\\u1fff' | '\\u3040' .. '\\u318f' | '\\u3300'
			// .. '\\u337f' | '\\u3400' .. '\\u3d2d' | '\\u4e00' .. '\\u9fff' | '\\uf900' .. '\\ufaff' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:
			{
				if (input.LA(1) == '$' || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_'
						|| (input.LA(1) >= 'a' && input.LA(1) <= 'z') || (input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')
						|| (input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6') || (input.LA(1) >= '\u00F8' && input.LA(1) <= '\u1FFF')
						|| (input.LA(1) >= '\u3040' && input.LA(1) <= '\u318F') || (input.LA(1) >= '\u3300' && input.LA(1) <= '\u337F')
						|| (input.LA(1) >= '\u3400' && input.LA(1) <= '\u3D2D') || (input.LA(1) >= '\u4E00' && input.LA(1) <= '\u9FFF')
						|| (input.LA(1) >= '\uF900' && input.LA(1) <= '\uFAFF')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

			}

		} finally {
		}
	}

	// $ANTLR end "Letter"

	// $ANTLR start "JavaIDDigit"
	public final void mJavaIDDigit() throws RecognitionException {
		try {
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:478:5: ( '\\u0030' .. '\\u0039' | '\\u0660' .. '\\u0669' | '\\u06f0' .. '\\u06f9' |
			// '\\u0966' .. '\\u096f' | '\\u09e6' .. '\\u09ef' | '\\u0a66' .. '\\u0a6f' | '\\u0ae6' .. '\\u0aef' | '\\u0b66' .. '\\u0b6f' | '\\u0be7'
			// .. '\\u0bef' | '\\u0c66' .. '\\u0c6f' | '\\u0ce6' .. '\\u0cef' | '\\u0d66' .. '\\u0d6f' | '\\u0e50' .. '\\u0e59' | '\\u0ed0' ..
			// '\\u0ed9' | '\\u1040' .. '\\u1049' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:
			{
				if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= '\u0660' && input.LA(1) <= '\u0669')
						|| (input.LA(1) >= '\u06F0' && input.LA(1) <= '\u06F9') || (input.LA(1) >= '\u0966' && input.LA(1) <= '\u096F')
						|| (input.LA(1) >= '\u09E6' && input.LA(1) <= '\u09EF') || (input.LA(1) >= '\u0A66' && input.LA(1) <= '\u0A6F')
						|| (input.LA(1) >= '\u0AE6' && input.LA(1) <= '\u0AEF') || (input.LA(1) >= '\u0B66' && input.LA(1) <= '\u0B6F')
						|| (input.LA(1) >= '\u0BE7' && input.LA(1) <= '\u0BEF') || (input.LA(1) >= '\u0C66' && input.LA(1) <= '\u0C6F')
						|| (input.LA(1) >= '\u0CE6' && input.LA(1) <= '\u0CEF') || (input.LA(1) >= '\u0D66' && input.LA(1) <= '\u0D6F')
						|| (input.LA(1) >= '\u0E50' && input.LA(1) <= '\u0E59') || (input.LA(1) >= '\u0ED0' && input.LA(1) <= '\u0ED9')
						|| (input.LA(1) >= '\u1040' && input.LA(1) <= '\u1049')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

			}

		} finally {
		}
	}

	// $ANTLR end "JavaIDDigit"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:495:5: ( ( ' ' | '\\r' | '\\t' | '\ ' | '\\n' ) )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:495:8: ( ' ' | '\\r' | '\\t' | '\ ' | '\\n' )
			{
				if ((input.LA(1) >= '\t' && input.LA(1) <= '\n') || (input.LA(1) >= '\f' && input.LA(1) <= '\r') || input.LA(1) == ' ') {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

				_channel = HIDDEN;

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:499:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:499:9: '/*' ( options {greedy=false; } : . )* '*/'
			{
				match("/*");

				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:499:14: ( options {greedy=false; } : . )*
				loop9: do {
					int alt9 = 2;
					int LA9_0 = input.LA(1);

					if ((LA9_0 == '*')) {
						int LA9_1 = input.LA(2);

						if ((LA9_1 == '/')) {
							alt9 = 2;
						} else if (((LA9_1 >= '\u0000' && LA9_1 <= '.') || (LA9_1 >= '0' && LA9_1 <= '\uFFFF'))) {
							alt9 = 1;
						}

					} else if (((LA9_0 >= '\u0000' && LA9_0 <= ')') || (LA9_0 >= '+' && LA9_0 <= '\uFFFF'))) {
						alt9 = 1;
					}

					switch (alt9) {
					case 1:
					// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:499:42: .
					{
						matchAny();

					}
						break;

					default:
						break loop9;
					}
				} while (true);

				match("*/");

				_channel = HIDDEN;

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "COMMENT"

	// $ANTLR start "LINE_COMMENT"
	public final void mLINE_COMMENT() throws RecognitionException {
		try {
			int _type = LINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:503:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\r' )? '\\n' | EOF ) )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:503:7: '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\r' )? '\\n' | EOF )
			{
				match("//");

				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:503:12: (~ ( '\\n' | '\\r' ) )*
				loop10: do {
					int alt10 = 2;
					int LA10_0 = input.LA(1);

					if (((LA10_0 >= '\u0000' && LA10_0 <= '\t') || (LA10_0 >= '\u000B' && LA10_0 <= '\f') || (LA10_0 >= '\u000E' && LA10_0 <= '\uFFFF'))) {
						alt10 = 1;
					}

					switch (alt10) {
					case 1:
					// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:503:12: ~ ( '\\n' | '\\r' )
					{
						if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t') || (input.LA(1) >= '\u000B' && input.LA(1) <= '\f')
								|| (input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF')) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}

					}
						break;

					default:
						break loop10;
					}
				} while (true);

				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:503:26: ( ( '\\r' )? '\\n' | EOF )
				int alt12 = 2;
				int LA12_0 = input.LA(1);

				if ((LA12_0 == '\n' || LA12_0 == '\r')) {
					alt12 = 1;
				} else {
					alt12 = 2;
				}
				switch (alt12) {
				case 1:
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:503:27: ( '\\r' )? '\\n'
				{
					// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:503:27: ( '\\r' )?
					int alt11 = 2;
					int LA11_0 = input.LA(1);

					if ((LA11_0 == '\r')) {
						alt11 = 1;
					}
					switch (alt11) {
					case 1:
					// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:503:27: '\\r'
					{
						match('\r');

					}
						break;

					}

					match('\n');

				}
					break;
				case 2:
				// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:503:38: EOF
				{
					match(EOF);

				}
					break;

				}

				_channel = HIDDEN;

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "LINE_COMMENT"

	// $ANTLR start "XPAND_TAG_OPEN"
	public final void mXPAND_TAG_OPEN() throws RecognitionException {
		try {
			int _type = XPAND_TAG_OPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:508:2: ( '\\u00AB' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:508:4: '\\u00AB'
			{
				match('\u00AB');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "XPAND_TAG_OPEN"

	// $ANTLR start "XPAND_TAG_CLOSE"
	public final void mXPAND_TAG_CLOSE() throws RecognitionException {
		try {
			int _type = XPAND_TAG_CLOSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:510:2: ( '\\u00BB' )
			// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:510:4: '\\u00BB'
			{
				match('\u00BB');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "XPAND_TAG_CLOSE"

	public void mTokens() throws RecognitionException {
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:8: ( T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 |
		// T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 |
		// T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 |
		// T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 |
		// T__79 | T__80 | T__81 | T__82 | IntLiteral | StringLiteral | Identifier | WS | COMMENT | LINE_COMMENT | XPAND_TAG_OPEN | XPAND_TAG_CLOSE )
		int alt13 = 73;
		alt13 = dfa13.predict(input);
		switch (alt13) {
		case 1:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:10: T__18
		{
			mT__18();

		}
			break;
		case 2:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:16: T__19
		{
			mT__19();

		}
			break;
		case 3:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:22: T__20
		{
			mT__20();

		}
			break;
		case 4:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:28: T__21
		{
			mT__21();

		}
			break;
		case 5:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:34: T__22
		{
			mT__22();

		}
			break;
		case 6:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:40: T__23
		{
			mT__23();

		}
			break;
		case 7:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:46: T__24
		{
			mT__24();

		}
			break;
		case 8:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:52: T__25
		{
			mT__25();

		}
			break;
		case 9:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:58: T__26
		{
			mT__26();

		}
			break;
		case 10:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:64: T__27
		{
			mT__27();

		}
			break;
		case 11:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:70: T__28
		{
			mT__28();

		}
			break;
		case 12:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:76: T__29
		{
			mT__29();

		}
			break;
		case 13:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:82: T__30
		{
			mT__30();

		}
			break;
		case 14:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:88: T__31
		{
			mT__31();

		}
			break;
		case 15:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:94: T__32
		{
			mT__32();

		}
			break;
		case 16:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:100: T__33
		{
			mT__33();

		}
			break;
		case 17:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:106: T__34
		{
			mT__34();

		}
			break;
		case 18:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:112: T__35
		{
			mT__35();

		}
			break;
		case 19:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:118: T__36
		{
			mT__36();

		}
			break;
		case 20:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:124: T__37
		{
			mT__37();

		}
			break;
		case 21:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:130: T__38
		{
			mT__38();

		}
			break;
		case 22:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:136: T__39
		{
			mT__39();

		}
			break;
		case 23:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:142: T__40
		{
			mT__40();

		}
			break;
		case 24:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:148: T__41
		{
			mT__41();

		}
			break;
		case 25:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:154: T__42
		{
			mT__42();

		}
			break;
		case 26:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:160: T__43
		{
			mT__43();

		}
			break;
		case 27:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:166: T__44
		{
			mT__44();

		}
			break;
		case 28:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:172: T__45
		{
			mT__45();

		}
			break;
		case 29:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:178: T__46
		{
			mT__46();

		}
			break;
		case 30:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:184: T__47
		{
			mT__47();

		}
			break;
		case 31:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:190: T__48
		{
			mT__48();

		}
			break;
		case 32:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:196: T__49
		{
			mT__49();

		}
			break;
		case 33:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:202: T__50
		{
			mT__50();

		}
			break;
		case 34:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:208: T__51
		{
			mT__51();

		}
			break;
		case 35:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:214: T__52
		{
			mT__52();

		}
			break;
		case 36:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:220: T__53
		{
			mT__53();

		}
			break;
		case 37:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:226: T__54
		{
			mT__54();

		}
			break;
		case 38:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:232: T__55
		{
			mT__55();

		}
			break;
		case 39:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:238: T__56
		{
			mT__56();

		}
			break;
		case 40:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:244: T__57
		{
			mT__57();

		}
			break;
		case 41:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:250: T__58
		{
			mT__58();

		}
			break;
		case 42:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:256: T__59
		{
			mT__59();

		}
			break;
		case 43:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:262: T__60
		{
			mT__60();

		}
			break;
		case 44:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:268: T__61
		{
			mT__61();

		}
			break;
		case 45:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:274: T__62
		{
			mT__62();

		}
			break;
		case 46:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:280: T__63
		{
			mT__63();

		}
			break;
		case 47:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:286: T__64
		{
			mT__64();

		}
			break;
		case 48:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:292: T__65
		{
			mT__65();

		}
			break;
		case 49:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:298: T__66
		{
			mT__66();

		}
			break;
		case 50:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:304: T__67
		{
			mT__67();

		}
			break;
		case 51:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:310: T__68
		{
			mT__68();

		}
			break;
		case 52:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:316: T__69
		{
			mT__69();

		}
			break;
		case 53:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:322: T__70
		{
			mT__70();

		}
			break;
		case 54:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:328: T__71
		{
			mT__71();

		}
			break;
		case 55:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:334: T__72
		{
			mT__72();

		}
			break;
		case 56:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:340: T__73
		{
			mT__73();

		}
			break;
		case 57:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:346: T__74
		{
			mT__74();

		}
			break;
		case 58:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:352: T__75
		{
			mT__75();

		}
			break;
		case 59:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:358: T__76
		{
			mT__76();

		}
			break;
		case 60:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:364: T__77
		{
			mT__77();

		}
			break;
		case 61:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:370: T__78
		{
			mT__78();

		}
			break;
		case 62:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:376: T__79
		{
			mT__79();

		}
			break;
		case 63:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:382: T__80
		{
			mT__80();

		}
			break;
		case 64:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:388: T__81
		{
			mT__81();

		}
			break;
		case 65:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:394: T__82
		{
			mT__82();

		}
			break;
		case 66:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:400: IntLiteral
		{
			mIntLiteral();

		}
			break;
		case 67:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:411: StringLiteral
		{
			mStringLiteral();

		}
			break;
		case 68:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:425: Identifier
		{
			mIdentifier();

		}
			break;
		case 69:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:436: WS
		{
			mWS();

		}
			break;
		case 70:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:439: COMMENT
		{
			mCOMMENT();

		}
			break;
		case 71:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:447: LINE_COMMENT
		{
			mLINE_COMMENT();

		}
			break;
		case 72:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:460: XPAND_TAG_OPEN
		{
			mXPAND_TAG_OPEN();

		}
			break;
		case 73:
		// src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:1:475: XPAND_TAG_CLOSE
		{
			mXPAND_TAG_CLOSE();

		}
			break;

		}

	}

	protected DFA13 dfa13 = new DFA13(this);
	static final String DFA13_eotS = "\1\uffff\1\54\1\uffff\3\54\1\uffff\2\54\1\73\1\54\4\uffff\2\54\1"
			+ "\uffff\4\54\1\104\1\106\1\uffff\2\54\1\uffff\1\54\1\uffff\1\117" + "\1\uffff\1\121\1\123\1\125\1\uffff\1\130\3\54\10\uffff\1\54\1\140"
			+ "\10\54\2\uffff\7\54\4\uffff\7\54\13\uffff\7\54\1\uffff\21\54\1\u0094"
			+ "\1\u0095\10\54\1\u009e\10\54\1\u00a7\5\54\1\u00ad\5\54\1\u00b3\1" + "\54\1\u00b5\2\uffff\1\u00b6\1\u00b7\6\54\1\uffff\1\u00be\7\54\1"
			+ "\uffff\5\54\1\uffff\1\54\1\u00cc\3\54\1\uffff\1\54\3\uffff\6\54" + "\1\uffff\1\54\1\u00d8\1\54\1\u00da\2\54\1\u00dd\1\54\1\u00df\2\54"
			+ "\1\u00e2\1\u00e3\1\uffff\1\54\1\u00e5\3\54\1\u00e9\1\u00eb\1\u00ec"
			+ "\3\54\1\uffff\1\u00f0\1\uffff\1\u00f1\1\54\1\uffff\1\54\1\uffff" + "\1\u00f4\1\u00f5\2\uffff\1\u00f6\1\uffff\1\u00f7\2\54\1\uffff\1"
			+ "\54\2\uffff\1\u00fb\2\54\2\uffff\1\54\1\u00ff\4\uffff\3\54\1\uffff"
			+ "\2\54\1\u0105\1\uffff\3\54\1\u0109\1\u010a\1\uffff\1\u010b\1\u010c" + "\1\54\4\uffff\1\u010e\1\uffff";
	static final String DFA13_eofS = "\u010f\uffff";
	static final String DFA13_minS = "\1\11\1\146\1\uffff\1\154\1\145\1\141\1\uffff\1\122\1\101\1\72\1"
			+ "\162\4\uffff\1\162\1\101\1\uffff\1\157\1\151\2\145\1\75\1\76\1\uffff"
			+ "\1\150\1\145\1\uffff\1\145\1\uffff\1\174\1\uffff\3\75\1\uffff\1" + "\52\1\114\1\145\1\141\10\uffff\1\160\1\44\1\151\1\163\1\145\1\154"
			+ "\1\143\1\145\2\122\2\uffff\1\157\1\151\1\126\1\154\1\163\2\164\4" + "\uffff\1\145\1\165\1\160\1\151\1\154\1\162\1\146\13\uffff\1\117"
			+ "\1\167\1\154\1\164\1\154\1\162\1\154\1\uffff\1\145\1\163\1\145\1" + "\170\1\145\1\164\1\154\1\150\1\145\1\141\1\117\1\116\1\165\1\166"
			+ "\1\101\1\154\1\164\2\44\1\156\2\145\1\164\1\145\1\164\1\141\1\102"
			+ "\1\44\1\154\1\105\1\163\1\101\1\162\1\151\1\156\1\164\1\44\1\160" + "\1\143\3\145\1\44\1\164\1\122\1\111\1\156\1\141\1\44\1\145\1\44"
			+ "\2\uffff\2\44\1\123\2\143\1\102\1\165\1\101\1\uffff\1\44\1\170\1"
			+ "\145\1\154\1\164\1\145\2\163\1\uffff\1\157\1\164\1\170\1\143\1\144"
			+ "\1\uffff\1\145\1\44\1\116\1\144\1\164\1\uffff\1\143\3\uffff\1\145"
			+ "\1\150\1\164\1\171\1\154\1\114\1\uffff\1\151\1\44\1\154\1\44\1\163"
			+ "\1\151\1\44\1\162\1\44\2\164\2\44\1\uffff\1\107\1\44\1\145\1\164" + "\1\154\3\44\1\164\1\126\1\163\1\uffff\1\44\1\uffff\1\44\1\157\1"
			+ "\uffff\1\164\1\uffff\2\44\2\uffff\1\44\1\uffff\1\44\1\151\1\145"
			+ "\1\uffff\1\151\2\uffff\1\44\1\101\1\164\2\uffff\1\156\1\44\4\uffff"
			+ "\1\157\1\143\1\162\1\uffff\1\122\1\163\1\44\1\uffff\1\156\1\164" + "\1\163\2\44\1\uffff\2\44\1\164\4\uffff\1\44\1\uffff";
	static final String DFA13_maxS = "\1\ufaff\1\155\1\uffff\1\170\1\145\1\162\1\uffff\1\122\1\101\1\72"
			+ "\1\162\4\uffff\1\162\1\101\1\uffff\1\157\1\151\2\145\1\75\1\76\1"
			+ "\uffff\1\171\1\167\1\uffff\1\145\1\uffff\1\174\1\uffff\3\75\1\uffff"
			+ "\1\57\1\114\1\165\1\157\10\uffff\1\160\1\ufaff\1\164\1\163\1\152" + "\1\156\1\163\1\145\2\122\2\uffff\1\157\1\151\1\126\1\154\1\163\2"
			+ "\164\4\uffff\1\145\1\165\1\160\1\151\1\154\1\162\1\146\13\uffff" + "\1\117\1\167\1\154\1\164\1\154\1\162\1\157\1\uffff\1\145\1\163\1"
			+ "\145\1\170\1\145\1\164\1\154\1\150\1\145\1\141\1\117\1\116\1\165" + "\1\166\1\101\1\154\1\164\2\ufaff\1\156\2\145\1\164\1\145\1\164\1"
			+ "\141\1\102\1\ufaff\1\154\1\105\1\163\1\101\1\162\1\151\1\156\1\164"
			+ "\1\ufaff\1\160\1\143\3\145\1\ufaff\1\164\1\122\1\111\1\156\1\141" + "\1\ufaff\1\145\1\ufaff\2\uffff\2\ufaff\1\123\2\143\1\102\1\165\1"
			+ "\101\1\uffff\1\ufaff\1\170\1\145\1\154\1\164\1\145\2\163\1\uffff" + "\1\157\1\164\1\170\1\143\1\144\1\uffff\1\145\1\ufaff\1\116\1\144"
			+ "\1\164\1\uffff\1\143\3\uffff\1\145\1\150\1\164\1\171\1\154\1\114" + "\1\uffff\1\151\1\ufaff\1\154\1\ufaff\1\163\1\151\1\ufaff\1\162\1"
			+ "\ufaff\2\164\2\ufaff\1\uffff\1\107\1\ufaff\1\145\1\164\1\154\3\ufaff"
			+ "\1\164\1\126\1\163\1\uffff\1\ufaff\1\uffff\1\ufaff\1\157\1\uffff"
			+ "\1\164\1\uffff\2\ufaff\2\uffff\1\ufaff\1\uffff\1\ufaff\1\151\1\145"
			+ "\1\uffff\1\151\2\uffff\1\ufaff\1\101\1\164\2\uffff\1\156\1\ufaff" + "\4\uffff\1\157\1\143\1\162\1\uffff\1\122\1\163\1\ufaff\1\uffff\1"
			+ "\156\1\164\1\163\2\ufaff\1\uffff\2\ufaff\1\164\4\uffff\1\ufaff\1" + "\uffff";
	static final String DFA13_acceptS = "\2\uffff\1\2\3\uffff\1\6\4\uffff\1\14\1\15\1\16\1\17\2\uffff\1\24"
			+ "\6\uffff\1\34\2\uffff\1\40\1\uffff\1\43\1\uffff\1\45\3\uffff\1\55"
			+ "\4\uffff\1\100\1\101\1\102\1\103\1\104\1\105\1\110\1\111\12\uffff" + "\1\20\1\12\7\uffff\1\47\1\32\1\33\1\56\7\uffff\1\44\1\77\1\50\1"
			+ "\60\1\51\1\53\1\52\1\54\1\106\1\107\1\57\7\uffff\1\7\63\uffff\1" + "\30\1\31\10\uffff\1\62\10\uffff\1\36\5\uffff\1\41\5\uffff\1\23\1"
			+ "\uffff\1\27\1\35\1\64\6\uffff\1\65\15\uffff\1\10\13\uffff\1\63\1" + "\uffff\1\1\2\uffff\1\73\1\uffff\1\72\2\uffff\1\22\1\25\1\uffff\1"
			+ "\13\3\uffff\1\37\1\uffff\1\70\1\75\3\uffff\1\76\1\46\2\uffff\1\5"
			+ "\1\67\1\11\1\21\3\uffff\1\42\3\uffff\1\4\5\uffff\1\3\3\uffff\1\61" + "\1\74\1\26\1\66\1\uffff\1\71";
	static final String DFA13_specialS = "\u010f\uffff}>";
	static final String[] DFA13_transitionS = {
			"\2\55\1\uffff\2\55\22\uffff\1\55\1\40\1\53\1\6\1\54\1\uffff" + "\1\37\1\53\1\13\1\16\1\15\1\43\1\14\1\27\1\21\1\44\12\52\1\11"
					+ "\1\2\1\42\1\26\1\41\1\30\1\uffff\2\54\1\22\1\54\1\7\1\54\1\45"
					+ "\2\54\1\20\1\54\1\23\6\54\1\24\3\54\1\10\3\54\1\50\1\uffff\1" + "\51\2\54\1\uffff\1\12\1\54\1\5\1\34\1\3\1\47\2\54\1\1\2\54\1"
					+ "\25\1\54\1\46\1\54\1\17\1\54\1\4\1\32\1\31\6\54\1\33\1\36\1" + "\35\55\uffff\1\56\17\uffff\1\57\4\uffff\27\54\1\uffff\37\54"
					+ "\1\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54" + "\u0080\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200"
					+ "\54",
			"\1\61\6\uffff\1\60",
			"",
			"\1\63\13\uffff\1\62",
			"\1\64",
			"\1\66\15\uffff\1\65\2\uffff\1\67",
			"",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\74",
			"",
			"",
			"",
			"",
			"\1\75",
			"\1\76",
			"",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\105",
			"",
			"\1\107\11\uffff\1\110\6\uffff\1\111",
			"\1\113\11\uffff\1\114\7\uffff\1\112",
			"",
			"\1\115",
			"",
			"\1\116",
			"",
			"\1\120",
			"\1\122",
			"\1\124",
			"",
			"\1\126\4\uffff\1\127",
			"\1\131",
			"\1\132\11\uffff\1\134\5\uffff\1\133",
			"\1\135\15\uffff\1\136",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\137",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\142\12\uffff\1\141",
			"\1\143",
			"\1\144\4\uffff\1\145",
			"\1\147\1\uffff\1\146",
			"\1\150\17\uffff\1\151",
			"\1\152",
			"\1\153",
			"\1\154",
			"",
			"",
			"\1\155",
			"\1\156",
			"\1\157",
			"\1\160",
			"\1\161",
			"\1\162",
			"\1\163",
			"",
			"",
			"",
			"",
			"\1\164",
			"\1\165",
			"\1\166",
			"\1\167",
			"\1\170",
			"\1\171",
			"\1\172",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\173",
			"\1\174",
			"\1\175",
			"\1\176",
			"\1\177",
			"\1\u0080",
			"\1\u0082\2\uffff\1\u0081",
			"",
			"\1\u0083",
			"\1\u0084",
			"\1\u0085",
			"\1\u0086",
			"\1\u0087",
			"\1\u0088",
			"\1\u0089",
			"\1\u008a",
			"\1\u008b",
			"\1\u008c",
			"\1\u008d",
			"\1\u008e",
			"\1\u008f",
			"\1\u0090",
			"\1\u0091",
			"\1\u0092",
			"\1\u0093",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u0096",
			"\1\u0097",
			"\1\u0098",
			"\1\u0099",
			"\1\u009a",
			"\1\u009b",
			"\1\u009c",
			"\1\u009d",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u009f",
			"\1\u00a0",
			"\1\u00a1",
			"\1\u00a2",
			"\1\u00a3",
			"\1\u00a4",
			"\1\u00a5",
			"\1\u00a6",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00a8",
			"\1\u00a9",
			"\1\u00aa",
			"\1\u00ab",
			"\1\u00ac",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00ae",
			"\1\u00af",
			"\1\u00b0",
			"\1\u00b1",
			"\1\u00b2",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00b4",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00b8",
			"\1\u00b9",
			"\1\u00ba",
			"\1\u00bb",
			"\1\u00bc",
			"\1\u00bd",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00bf",
			"\1\u00c0",
			"\1\u00c1",
			"\1\u00c2",
			"\1\u00c3",
			"\1\u00c4",
			"\1\u00c5",
			"",
			"\1\u00c6",
			"\1\u00c7",
			"\1\u00c8",
			"\1\u00c9",
			"\1\u00ca",
			"",
			"\1\u00cb",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00cd",
			"\1\u00ce",
			"\1\u00cf",
			"",
			"\1\u00d0",
			"",
			"",
			"",
			"\1\u00d1",
			"\1\u00d2",
			"\1\u00d3",
			"\1\u00d4",
			"\1\u00d5",
			"\1\u00d6",
			"",
			"\1\u00d7",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00d9",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00db",
			"\1\u00dc",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00de",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00e0",
			"\1\u00e1",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"",
			"\1\u00e4",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00e6",
			"\1\u00e7",
			"\1\u00e8",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\54\13\uffff\12\54\7\uffff\5\54\1\u00ea\24\54\4\uffff\1\54" + "\1\uffff\32\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54"
					+ "\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e" + "\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00ed",
			"\1\u00ee",
			"\1\u00ef",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00f2",
			"",
			"\1\u00f3",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00f8",
			"\1\u00f9",
			"",
			"\1\u00fa",
			"",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u00fc",
			"\1\u00fd",
			"",
			"",
			"\1\u00fe",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"",
			"",
			"",
			"",
			"\1\u0100",
			"\1\u0101",
			"\1\u0102",
			"",
			"\1\u0103",
			"\1\u0104",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"",
			"\1\u0106",
			"\1\u0107",
			"\1\u0108",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
			"\1\u010d",
			"",
			"",
			"",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
					+ "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54", "" };

	static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
	static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
	static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
	static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
	static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
	static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
	static final short[][] DFA13_transition;

	static {
		int numStates = DFA13_transitionS.length;
		DFA13_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
		}
	}

	class DFA13 extends DFA {

		public DFA13(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 13;
			this.eot = DFA13_eot;
			this.eof = DFA13_eof;
			this.min = DFA13_min;
			this.max = DFA13_max;
			this.accept = DFA13_accept;
			this.special = DFA13_special;
			this.transition = DFA13_transition;
		}

		public String getDescription() {
			return "1:1: Tokens : ( T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | IntLiteral | StringLiteral | Identifier | WS | COMMENT | LINE_COMMENT | XPAND_TAG_OPEN | XPAND_TAG_CLOSE );";
		}
	}

}