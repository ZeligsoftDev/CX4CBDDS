package org.eclipse.papyrus.uml.textedit.parameter.xtext.ui.contentassist.antlr.internal;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;

@SuppressWarnings("all")
public class InternalUmlParameterLexer extends Lexer {
	public static final int T__19 = 19;
	public static final int T__15 = 15;
	public static final int T__16 = 16;
	public static final int T__17 = 17;
	public static final int T__18 = 18;
	public static final int T__12 = 12;
	public static final int T__13 = 13;
	public static final int T__14 = 14;
	public static final int RULE_ID = 5;
	public static final int T__26 = 26;
	public static final int T__27 = 27;
	public static final int T__28 = 28;
	public static final int RULE_INT = 4;
	public static final int T__29 = 29;
	public static final int T__22 = 22;
	public static final int RULE_ML_COMMENT = 7;
	public static final int T__23 = 23;
	public static final int T__24 = 24;
	public static final int T__25 = 25;
	public static final int T__20 = 20;
	public static final int T__21 = 21;
	public static final int RULE_STRING = 6;
	public static final int RULE_SL_COMMENT = 8;
	public static final int T__37 = 37;
	public static final int T__38 = 38;
	public static final int T__39 = 39;
	public static final int T__33 = 33;
	public static final int T__34 = 34;
	public static final int T__35 = 35;
	public static final int T__36 = 36;
	public static final int EOF = -1;
	public static final int T__30 = 30;
	public static final int T__31 = 31;
	public static final int T__32 = 32;
	public static final int RULE_WS = 10;
	public static final int RULE_ANY_OTHER = 11;
	public static final int T__44 = 44;
	public static final int RULE_INTEGER_VALUE = 9;
	public static final int T__40 = 40;
	public static final int T__41 = 41;
	public static final int T__42 = 42;
	public static final int T__43 = 43;

	// delegates
	// delegators

	public InternalUmlParameterLexer() {
		;
	}

	public InternalUmlParameterLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalUmlParameterLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);

	}

	public String getGrammarFileName() {
		return "InternalUmlParameter.g";
	}

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:11:7: ( '*' )
			// InternalUmlParameter.g:11:9: '*'
			{
				match('*');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:12:7: ( 'exception' )
			// InternalUmlParameter.g:12:9: 'exception'
			{
				match("exception");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:13:7: ( 'stream' )
			// InternalUmlParameter.g:13:9: 'stream'
			{
				match("stream");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:14:7: ( 'ordered' )
			// InternalUmlParameter.g:14:9: 'ordered'
			{
				match("ordered");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:15:7: ( 'unique' )
			// InternalUmlParameter.g:15:9: 'unique'
			{
				match("unique");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:16:7: ( 'create' )
			// InternalUmlParameter.g:16:9: 'create'
			{
				match("create");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:17:7: ( 'read' )
			// InternalUmlParameter.g:17:9: 'read'
			{
				match("read");


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
			// InternalUmlParameter.g:18:7: ( 'update' )
			// InternalUmlParameter.g:18:9: 'update'
			{
				match("update");


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
			// InternalUmlParameter.g:19:7: ( 'delete' )
			// InternalUmlParameter.g:19:9: 'delete'
			{
				match("delete");


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
			// InternalUmlParameter.g:20:7: ( 'true' )
			// InternalUmlParameter.g:20:9: 'true'
			{
				match("true");


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
			// InternalUmlParameter.g:21:7: ( 'false' )
			// InternalUmlParameter.g:21:9: 'false'
			{
				match("false");


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
			// InternalUmlParameter.g:22:7: ( '+' )
			// InternalUmlParameter.g:22:9: '+'
			{
				match('+');

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
			// InternalUmlParameter.g:23:7: ( '-' )
			// InternalUmlParameter.g:23:9: '-'
			{
				match('-');

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
			// InternalUmlParameter.g:24:7: ( '#' )
			// InternalUmlParameter.g:24:9: '#'
			{
				match('#');

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
			// InternalUmlParameter.g:25:7: ( '~' )
			// InternalUmlParameter.g:25:9: '~'
			{
				match('~');

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
			// InternalUmlParameter.g:26:7: ( 'in' )
			// InternalUmlParameter.g:26:9: 'in'
			{
				match("in");


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
			// InternalUmlParameter.g:27:7: ( 'out' )
			// InternalUmlParameter.g:27:9: 'out'
			{
				match("out");


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
			// InternalUmlParameter.g:28:7: ( 'inout' )
			// InternalUmlParameter.g:28:9: 'inout'
			{
				match("inout");


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
			// InternalUmlParameter.g:29:7: ( 'return' )
			// InternalUmlParameter.g:29:9: 'return'
			{
				match("return");


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
			// InternalUmlParameter.g:30:7: ( ':' )
			// InternalUmlParameter.g:30:9: ':'
			{
				match(':');

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
			// InternalUmlParameter.g:31:7: ( '{' )
			// InternalUmlParameter.g:31:9: '{'
			{
				match('{');

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
			// InternalUmlParameter.g:32:7: ( '}' )
			// InternalUmlParameter.g:32:9: '}'
			{
				match('}');

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
			// InternalUmlParameter.g:33:7: ( ',' )
			// InternalUmlParameter.g:33:9: ','
			{
				match(',');

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
			// InternalUmlParameter.g:34:7: ( 'effect:' )
			// InternalUmlParameter.g:34:9: 'effect:'
			{
				match("effect:");


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
			// InternalUmlParameter.g:35:7: ( '=' )
			// InternalUmlParameter.g:35:9: '='
			{
				match('=');

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
			// InternalUmlParameter.g:36:7: ( '.' )
			// InternalUmlParameter.g:36:9: '.'
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
			// InternalUmlParameter.g:37:7: ( 'null' )
			// InternalUmlParameter.g:37:9: 'null'
			{
				match("null");


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
			// InternalUmlParameter.g:38:7: ( 'none' )
			// InternalUmlParameter.g:38:9: 'none'
			{
				match("none");


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
			// InternalUmlParameter.g:39:7: ( '::' )
			// InternalUmlParameter.g:39:9: '::'
			{
				match("::");


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
			// InternalUmlParameter.g:40:7: ( '[' )
			// InternalUmlParameter.g:40:9: '['
			{
				match('[');

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
			// InternalUmlParameter.g:41:7: ( ']' )
			// InternalUmlParameter.g:41:9: ']'
			{
				match(']');

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
			// InternalUmlParameter.g:42:7: ( '..' )
			// InternalUmlParameter.g:42:9: '..'
			{
				match("..");


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
			// InternalUmlParameter.g:43:7: ( '<Undefined>' )
			// InternalUmlParameter.g:43:9: '<Undefined>'
			{
				match("<Undefined>");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__44"

	// $ANTLR start "RULE_ID"
	public final void mRULE_ID() throws RecognitionException {
		try {
			int _type = RULE_ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:2903:9: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' ) )
			// InternalUmlParameter.g:2903:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' )
			{
				// InternalUmlParameter.g:2903:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' )
				int alt3 = 2;
				int LA3_0 = input.LA(1);

				if (((LA3_0 >= 'A' && LA3_0 <= 'Z') || LA3_0 == '_' || (LA3_0 >= 'a' && LA3_0 <= 'z'))) {
					alt3 = 1;
				} else if ((LA3_0 == '\'')) {
					alt3 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 3, 0, input);

					throw nvae;
				}
				switch (alt3) {
				case 1:
				// InternalUmlParameter.g:2903:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
				{
					if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
						input.consume();

					} else {
						MismatchedSetException mse = new MismatchedSetException(null, input);
						recover(mse);
						throw mse;
					}

					// InternalUmlParameter.g:2903:36: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
					loop1: do {
						int alt1 = 2;
						int LA1_0 = input.LA(1);

						if (((LA1_0 >= '0' && LA1_0 <= '9') || (LA1_0 >= 'A' && LA1_0 <= 'Z') || LA1_0 == '_' || (LA1_0 >= 'a' && LA1_0 <= 'z'))) {
							alt1 = 1;
						}


						switch (alt1) {
						case 1:
						// InternalUmlParameter.g:
						{
							if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(null, input);
								recover(mse);
								throw mse;
							}


						}
							break;

						default:
							break loop1;
						}
					} while (true);


				}
					break;
				case 2:
				// InternalUmlParameter.g:2903:70: '\\'' ( options {greedy=false; } : . )* '\\''
				{
					match('\'');
					// InternalUmlParameter.g:2903:75: ( options {greedy=false; } : . )*
					loop2: do {
						int alt2 = 2;
						int LA2_0 = input.LA(1);

						if ((LA2_0 == '\'')) {
							alt2 = 2;
						} else if (((LA2_0 >= '\u0000' && LA2_0 <= '&') || (LA2_0 >= '(' && LA2_0 <= '\uFFFF'))) {
							alt2 = 1;
						}


						switch (alt2) {
						case 1:
						// InternalUmlParameter.g:2903:103: .
						{
							matchAny();

						}
							break;

						default:
							break loop2;
						}
					} while (true);

					match('\'');

				}
					break;

				}


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_ID"

	// $ANTLR start "RULE_STRING"
	public final void mRULE_STRING() throws RecognitionException {
		try {
			int _type = RULE_STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:2905:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
			// InternalUmlParameter.g:2905:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
			{
				match('\"');
				// InternalUmlParameter.g:2905:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
				loop4: do {
					int alt4 = 3;
					int LA4_0 = input.LA(1);

					if ((LA4_0 == '\\')) {
						alt4 = 1;
					} else if (((LA4_0 >= '\u0000' && LA4_0 <= '!') || (LA4_0 >= '#' && LA4_0 <= '[') || (LA4_0 >= ']' && LA4_0 <= '\uFFFF'))) {
						alt4 = 2;
					}


					switch (alt4) {
					case 1:
					// InternalUmlParameter.g:2905:20: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
					{
						match('\\');
						if (input.LA(1) == '\"' || input.LA(1) == '\'' || input.LA(1) == '\\' || input.LA(1) == 'b' || input.LA(1) == 'f' || input.LA(1) == 'n' || input.LA(1) == 'r' || input.LA(1) == 't') {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}


					}
						break;
					case 2:
					// InternalUmlParameter.g:2905:61: ~ ( ( '\\\\' | '\"' ) )
					{
						if ((input.LA(1) >= '\u0000' && input.LA(1) <= '!') || (input.LA(1) >= '#' && input.LA(1) <= '[') || (input.LA(1) >= ']' && input.LA(1) <= '\uFFFF')) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}


					}
						break;

					default:
						break loop4;
					}
				} while (true);

				match('\"');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_STRING"

	// $ANTLR start "RULE_ML_COMMENT"
	public final void mRULE_ML_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_ML_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:2907:17: ( '/*' ~ ( '@' ) ( options {greedy=false; } : . )* '*/' )
			// InternalUmlParameter.g:2907:19: '/*' ~ ( '@' ) ( options {greedy=false; } : . )* '*/'
			{
				match("/*");

				if ((input.LA(1) >= '\u0000' && input.LA(1) <= '?') || (input.LA(1) >= 'A' && input.LA(1) <= '\uFFFF')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

				// InternalUmlParameter.g:2907:31: ( options {greedy=false; } : . )*
				loop5: do {
					int alt5 = 2;
					int LA5_0 = input.LA(1);

					if ((LA5_0 == '*')) {
						int LA5_1 = input.LA(2);

						if ((LA5_1 == '/')) {
							alt5 = 2;
						} else if (((LA5_1 >= '\u0000' && LA5_1 <= '.') || (LA5_1 >= '0' && LA5_1 <= '\uFFFF'))) {
							alt5 = 1;
						}


					} else if (((LA5_0 >= '\u0000' && LA5_0 <= ')') || (LA5_0 >= '+' && LA5_0 <= '\uFFFF'))) {
						alt5 = 1;
					}


					switch (alt5) {
					case 1:
					// InternalUmlParameter.g:2907:59: .
					{
						matchAny();

					}
						break;

					default:
						break loop5;
					}
				} while (true);

				match("*/");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_ML_COMMENT"

	// $ANTLR start "RULE_SL_COMMENT"
	public final void mRULE_SL_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_SL_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:2909:17: ( '//' (~ ( ( '\\n' | '\\r' | '@' ) ) )* ( ( '\\r' )? '\\n' )? )
			// InternalUmlParameter.g:2909:19: '//' (~ ( ( '\\n' | '\\r' | '@' ) ) )* ( ( '\\r' )? '\\n' )?
			{
				match("//");

				// InternalUmlParameter.g:2909:24: (~ ( ( '\\n' | '\\r' | '@' ) ) )*
				loop6: do {
					int alt6 = 2;
					int LA6_0 = input.LA(1);

					if (((LA6_0 >= '\u0000' && LA6_0 <= '\t') || (LA6_0 >= '\u000B' && LA6_0 <= '\f') || (LA6_0 >= '\u000E' && LA6_0 <= '?') || (LA6_0 >= 'A' && LA6_0 <= '\uFFFF'))) {
						alt6 = 1;
					}


					switch (alt6) {
					case 1:
					// InternalUmlParameter.g:2909:24: ~ ( ( '\\n' | '\\r' | '@' ) )
					{
						if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t') || (input.LA(1) >= '\u000B' && input.LA(1) <= '\f') || (input.LA(1) >= '\u000E' && input.LA(1) <= '?') || (input.LA(1) >= 'A' && input.LA(1) <= '\uFFFF')) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}


					}
						break;

					default:
						break loop6;
					}
				} while (true);

				// InternalUmlParameter.g:2909:44: ( ( '\\r' )? '\\n' )?
				int alt8 = 2;
				int LA8_0 = input.LA(1);

				if ((LA8_0 == '\n' || LA8_0 == '\r')) {
					alt8 = 1;
				}
				switch (alt8) {
				case 1:
				// InternalUmlParameter.g:2909:45: ( '\\r' )? '\\n'
				{
					// InternalUmlParameter.g:2909:45: ( '\\r' )?
					int alt7 = 2;
					int LA7_0 = input.LA(1);

					if ((LA7_0 == '\r')) {
						alt7 = 1;
					}
					switch (alt7) {
					case 1:
					// InternalUmlParameter.g:2909:45: '\\r'
					{
						match('\r');

					}
						break;

					}

					match('\n');

				}
					break;

				}


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_SL_COMMENT"

	// $ANTLR start "RULE_INT"
	public final void mRULE_INT() throws RecognitionException {
		try {
			int _type = RULE_INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:2911:10: ( ( '0' .. '9' )+ )
			// InternalUmlParameter.g:2911:12: ( '0' .. '9' )+
			{
				// InternalUmlParameter.g:2911:12: ( '0' .. '9' )+
				int cnt9 = 0;
				loop9: do {
					int alt9 = 2;
					int LA9_0 = input.LA(1);

					if (((LA9_0 >= '0' && LA9_0 <= '9'))) {
						alt9 = 1;
					}


					switch (alt9) {
					case 1:
					// InternalUmlParameter.g:2911:13: '0' .. '9'
					{
						matchRange('0', '9');

					}
						break;

					default:
						if (cnt9 >= 1)
							break loop9;
						EarlyExitException eee = new EarlyExitException(9, input);
						throw eee;
					}
					cnt9++;
				} while (true);


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_INT"

	// $ANTLR start "RULE_INTEGER_VALUE"
	public final void mRULE_INTEGER_VALUE() throws RecognitionException {
		try {
			int _type = RULE_INTEGER_VALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:2913:20: ( ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F'
			// ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* ) )
			// InternalUmlParameter.g:2913:22: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
			// )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
			{
				// InternalUmlParameter.g:2913:22: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' ..
				// 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
				int alt22 = 4;
				int LA22_0 = input.LA(1);

				if ((LA22_0 == '0')) {
					switch (input.LA(2)) {
					case 'B':
					case 'b': {
						alt22 = 2;
					}
						break;
					case 'X':
					case 'x': {
						alt22 = 3;
					}
						break;
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '_': {
						alt22 = 4;
					}
						break;
					default:
						alt22 = 1;
					}

				} else if (((LA22_0 >= '1' && LA22_0 <= '9'))) {
					alt22 = 1;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 22, 0, input);

					throw nvae;
				}
				switch (alt22) {
				case 1:
				// InternalUmlParameter.g:2913:23: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
				{
					// InternalUmlParameter.g:2913:23: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
					int alt12 = 2;
					int LA12_0 = input.LA(1);

					if ((LA12_0 == '0')) {
						alt12 = 1;
					} else if (((LA12_0 >= '1' && LA12_0 <= '9'))) {
						alt12 = 2;
					} else {
						NoViableAltException nvae = new NoViableAltException("", 12, 0, input);

						throw nvae;
					}
					switch (alt12) {
					case 1:
					// InternalUmlParameter.g:2913:24: '0'
					{
						match('0');

					}
						break;
					case 2:
					// InternalUmlParameter.g:2913:28: '1' .. '9' ( ( '_' )? '0' .. '9' )*
					{
						matchRange('1', '9');
						// InternalUmlParameter.g:2913:37: ( ( '_' )? '0' .. '9' )*
						loop11: do {
							int alt11 = 2;
							int LA11_0 = input.LA(1);

							if (((LA11_0 >= '0' && LA11_0 <= '9') || LA11_0 == '_')) {
								alt11 = 1;
							}


							switch (alt11) {
							case 1:
							// InternalUmlParameter.g:2913:38: ( '_' )? '0' .. '9'
							{
								// InternalUmlParameter.g:2913:38: ( '_' )?
								int alt10 = 2;
								int LA10_0 = input.LA(1);

								if ((LA10_0 == '_')) {
									alt10 = 1;
								}
								switch (alt10) {
								case 1:
								// InternalUmlParameter.g:2913:38: '_'
								{
									match('_');

								}
									break;

								}

								matchRange('0', '9');

							}
								break;

							default:
								break loop11;
							}
						} while (true);


					}
						break;

					}


				}
					break;
				case 2:
				// InternalUmlParameter.g:2913:55: ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )*
				{
					// InternalUmlParameter.g:2913:55: ( '0b' | '0B' )
					int alt13 = 2;
					int LA13_0 = input.LA(1);

					if ((LA13_0 == '0')) {
						int LA13_1 = input.LA(2);

						if ((LA13_1 == 'b')) {
							alt13 = 1;
						} else if ((LA13_1 == 'B')) {
							alt13 = 2;
						} else {
							NoViableAltException nvae = new NoViableAltException("", 13, 1, input);

							throw nvae;
						}
					} else {
						NoViableAltException nvae = new NoViableAltException("", 13, 0, input);

						throw nvae;
					}
					switch (alt13) {
					case 1:
					// InternalUmlParameter.g:2913:56: '0b'
					{
						match("0b");


					}
						break;
					case 2:
					// InternalUmlParameter.g:2913:61: '0B'
					{
						match("0B");


					}
						break;

					}

					matchRange('0', '1');
					// InternalUmlParameter.g:2913:76: ( ( '_' )? '0' .. '1' )*
					loop15: do {
						int alt15 = 2;
						int LA15_0 = input.LA(1);

						if (((LA15_0 >= '0' && LA15_0 <= '1') || LA15_0 == '_')) {
							alt15 = 1;
						}


						switch (alt15) {
						case 1:
						// InternalUmlParameter.g:2913:77: ( '_' )? '0' .. '1'
						{
							// InternalUmlParameter.g:2913:77: ( '_' )?
							int alt14 = 2;
							int LA14_0 = input.LA(1);

							if ((LA14_0 == '_')) {
								alt14 = 1;
							}
							switch (alt14) {
							case 1:
							// InternalUmlParameter.g:2913:77: '_'
							{
								match('_');

							}
								break;

							}

							matchRange('0', '1');

						}
							break;

						default:
							break loop15;
						}
					} while (true);


				}
					break;
				case 3:
				// InternalUmlParameter.g:2913:93: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
				{
					// InternalUmlParameter.g:2913:93: ( '0x' | '0X' )
					int alt16 = 2;
					int LA16_0 = input.LA(1);

					if ((LA16_0 == '0')) {
						int LA16_1 = input.LA(2);

						if ((LA16_1 == 'x')) {
							alt16 = 1;
						} else if ((LA16_1 == 'X')) {
							alt16 = 2;
						} else {
							NoViableAltException nvae = new NoViableAltException("", 16, 1, input);

							throw nvae;
						}
					} else {
						NoViableAltException nvae = new NoViableAltException("", 16, 0, input);

						throw nvae;
					}
					switch (alt16) {
					case 1:
					// InternalUmlParameter.g:2913:94: '0x'
					{
						match("0x");


					}
						break;
					case 2:
					// InternalUmlParameter.g:2913:99: '0X'
					{
						match("0X");


					}
						break;

					}

					if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'F') || (input.LA(1) >= 'a' && input.LA(1) <= 'f')) {
						input.consume();

					} else {
						MismatchedSetException mse = new MismatchedSetException(null, input);
						recover(mse);
						throw mse;
					}

					// InternalUmlParameter.g:2913:134: ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
					loop18: do {
						int alt18 = 2;
						int LA18_0 = input.LA(1);

						if (((LA18_0 >= '0' && LA18_0 <= '9') || (LA18_0 >= 'A' && LA18_0 <= 'F') || LA18_0 == '_' || (LA18_0 >= 'a' && LA18_0 <= 'f'))) {
							alt18 = 1;
						}


						switch (alt18) {
						case 1:
						// InternalUmlParameter.g:2913:135: ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
						{
							// InternalUmlParameter.g:2913:135: ( '_' )?
							int alt17 = 2;
							int LA17_0 = input.LA(1);

							if ((LA17_0 == '_')) {
								alt17 = 1;
							}
							switch (alt17) {
							case 1:
							// InternalUmlParameter.g:2913:135: '_'
							{
								match('_');

							}
								break;

							}

							if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'F') || (input.LA(1) >= 'a' && input.LA(1) <= 'f')) {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(null, input);
								recover(mse);
								throw mse;
							}


						}
							break;

						default:
							break loop18;
						}
					} while (true);


				}
					break;
				case 4:
				// InternalUmlParameter.g:2913:171: '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )*
				{
					match('0');
					// InternalUmlParameter.g:2913:175: ( '_' )?
					int alt19 = 2;
					int LA19_0 = input.LA(1);

					if ((LA19_0 == '_')) {
						alt19 = 1;
					}
					switch (alt19) {
					case 1:
					// InternalUmlParameter.g:2913:175: '_'
					{
						match('_');

					}
						break;

					}

					matchRange('0', '7');
					// InternalUmlParameter.g:2913:189: ( ( '_' )? '0' .. '7' )*
					loop21: do {
						int alt21 = 2;
						int LA21_0 = input.LA(1);

						if (((LA21_0 >= '0' && LA21_0 <= '7') || LA21_0 == '_')) {
							alt21 = 1;
						}


						switch (alt21) {
						case 1:
						// InternalUmlParameter.g:2913:190: ( '_' )? '0' .. '7'
						{
							// InternalUmlParameter.g:2913:190: ( '_' )?
							int alt20 = 2;
							int LA20_0 = input.LA(1);

							if ((LA20_0 == '_')) {
								alt20 = 1;
							}
							switch (alt20) {
							case 1:
							// InternalUmlParameter.g:2913:190: '_'
							{
								match('_');

							}
								break;

							}

							matchRange('0', '7');

						}
							break;

						default:
							break loop21;
						}
					} while (true);


				}
					break;

				}


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_INTEGER_VALUE"

	// $ANTLR start "RULE_WS"
	public final void mRULE_WS() throws RecognitionException {
		try {
			int _type = RULE_WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:2915:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// InternalUmlParameter.g:2915:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
				// InternalUmlParameter.g:2915:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
				int cnt23 = 0;
				loop23: do {
					int alt23 = 2;
					int LA23_0 = input.LA(1);

					if (((LA23_0 >= '\t' && LA23_0 <= '\n') || LA23_0 == '\r' || LA23_0 == ' ')) {
						alt23 = 1;
					}


					switch (alt23) {
					case 1:
					// InternalUmlParameter.g:
					{
						if ((input.LA(1) >= '\t' && input.LA(1) <= '\n') || input.LA(1) == '\r' || input.LA(1) == ' ') {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}


					}
						break;

					default:
						if (cnt23 >= 1)
							break loop23;
						EarlyExitException eee = new EarlyExitException(23, input);
						throw eee;
					}
					cnt23++;
				} while (true);


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_WS"

	// $ANTLR start "RULE_ANY_OTHER"
	public final void mRULE_ANY_OTHER() throws RecognitionException {
		try {
			int _type = RULE_ANY_OTHER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlParameter.g:2917:16: ( . )
			// InternalUmlParameter.g:2917:18: .
			{
				matchAny();

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_ANY_OTHER"

	public void mTokens() throws RecognitionException {
		// InternalUmlParameter.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 |
		// T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_INT | RULE_INTEGER_VALUE | RULE_WS | RULE_ANY_OTHER )
		int alt24 = 41;
		alt24 = dfa24.predict(input);
		switch (alt24) {
		case 1:
		// InternalUmlParameter.g:1:10: T__12
		{
			mT__12();

		}
			break;
		case 2:
		// InternalUmlParameter.g:1:16: T__13
		{
			mT__13();

		}
			break;
		case 3:
		// InternalUmlParameter.g:1:22: T__14
		{
			mT__14();

		}
			break;
		case 4:
		// InternalUmlParameter.g:1:28: T__15
		{
			mT__15();

		}
			break;
		case 5:
		// InternalUmlParameter.g:1:34: T__16
		{
			mT__16();

		}
			break;
		case 6:
		// InternalUmlParameter.g:1:40: T__17
		{
			mT__17();

		}
			break;
		case 7:
		// InternalUmlParameter.g:1:46: T__18
		{
			mT__18();

		}
			break;
		case 8:
		// InternalUmlParameter.g:1:52: T__19
		{
			mT__19();

		}
			break;
		case 9:
		// InternalUmlParameter.g:1:58: T__20
		{
			mT__20();

		}
			break;
		case 10:
		// InternalUmlParameter.g:1:64: T__21
		{
			mT__21();

		}
			break;
		case 11:
		// InternalUmlParameter.g:1:70: T__22
		{
			mT__22();

		}
			break;
		case 12:
		// InternalUmlParameter.g:1:76: T__23
		{
			mT__23();

		}
			break;
		case 13:
		// InternalUmlParameter.g:1:82: T__24
		{
			mT__24();

		}
			break;
		case 14:
		// InternalUmlParameter.g:1:88: T__25
		{
			mT__25();

		}
			break;
		case 15:
		// InternalUmlParameter.g:1:94: T__26
		{
			mT__26();

		}
			break;
		case 16:
		// InternalUmlParameter.g:1:100: T__27
		{
			mT__27();

		}
			break;
		case 17:
		// InternalUmlParameter.g:1:106: T__28
		{
			mT__28();

		}
			break;
		case 18:
		// InternalUmlParameter.g:1:112: T__29
		{
			mT__29();

		}
			break;
		case 19:
		// InternalUmlParameter.g:1:118: T__30
		{
			mT__30();

		}
			break;
		case 20:
		// InternalUmlParameter.g:1:124: T__31
		{
			mT__31();

		}
			break;
		case 21:
		// InternalUmlParameter.g:1:130: T__32
		{
			mT__32();

		}
			break;
		case 22:
		// InternalUmlParameter.g:1:136: T__33
		{
			mT__33();

		}
			break;
		case 23:
		// InternalUmlParameter.g:1:142: T__34
		{
			mT__34();

		}
			break;
		case 24:
		// InternalUmlParameter.g:1:148: T__35
		{
			mT__35();

		}
			break;
		case 25:
		// InternalUmlParameter.g:1:154: T__36
		{
			mT__36();

		}
			break;
		case 26:
		// InternalUmlParameter.g:1:160: T__37
		{
			mT__37();

		}
			break;
		case 27:
		// InternalUmlParameter.g:1:166: T__38
		{
			mT__38();

		}
			break;
		case 28:
		// InternalUmlParameter.g:1:172: T__39
		{
			mT__39();

		}
			break;
		case 29:
		// InternalUmlParameter.g:1:178: T__40
		{
			mT__40();

		}
			break;
		case 30:
		// InternalUmlParameter.g:1:184: T__41
		{
			mT__41();

		}
			break;
		case 31:
		// InternalUmlParameter.g:1:190: T__42
		{
			mT__42();

		}
			break;
		case 32:
		// InternalUmlParameter.g:1:196: T__43
		{
			mT__43();

		}
			break;
		case 33:
		// InternalUmlParameter.g:1:202: T__44
		{
			mT__44();

		}
			break;
		case 34:
		// InternalUmlParameter.g:1:208: RULE_ID
		{
			mRULE_ID();

		}
			break;
		case 35:
		// InternalUmlParameter.g:1:216: RULE_STRING
		{
			mRULE_STRING();

		}
			break;
		case 36:
		// InternalUmlParameter.g:1:228: RULE_ML_COMMENT
		{
			mRULE_ML_COMMENT();

		}
			break;
		case 37:
		// InternalUmlParameter.g:1:244: RULE_SL_COMMENT
		{
			mRULE_SL_COMMENT();

		}
			break;
		case 38:
		// InternalUmlParameter.g:1:260: RULE_INT
		{
			mRULE_INT();

		}
			break;
		case 39:
		// InternalUmlParameter.g:1:269: RULE_INTEGER_VALUE
		{
			mRULE_INTEGER_VALUE();

		}
			break;
		case 40:
		// InternalUmlParameter.g:1:288: RULE_WS
		{
			mRULE_WS();

		}
			break;
		case 41:
		// InternalUmlParameter.g:1:296: RULE_ANY_OTHER
		{
			mRULE_ANY_OTHER();

		}
			break;

		}

	}


	protected DFA24 dfa24 = new DFA24(this);
	static final String DFA24_eotS = "\2\uffff\11\45\4\uffff\1\45\1\66\4\uffff\1\74\1\45\2\uffff\1\41\1\uffff\3\41\2\106\3\uffff\2\45\1\uffff\12\45\4\uffff\1\130\10\uffff\2\45\10\uffff\2\106\1\uffff\4\45\1\140\11\45\1\uffff\2\45\1\106\4\45\1\uffff\3\45\1\163\2\45\1\166\2\45\1\171\1\172\7\45\1\uffff\2\45\1\uffff\1\u0084\1\u0085\2\uffff\2\45\1\u0088\1\45\1\u008a\1\u008b\1\u008c\1\u008d\1\u008e\2\uffff\1\45\2\uffff\1\u0090\5\uffff\1\45\1\uffff\1\u0092\1\uffff";
	static final String DFA24_eofS = "\u0093\uffff";
	static final String DFA24_minS = "\1\0\1\uffff\1\146\1\164\1\162\1\156\1\162\2\145\1\162\1\141\4\uffff\1\156\1\72\4\uffff\1\56\1\157\2\uffff\1\125\1\uffff\2\0\1\52\2\60\3\uffff\1\143\1\146\1\uffff\1\162\1\144\1\164\1\151\1\144\1\145\1\141\1\154\1\165\1\154\4\uffff\1\60\10\uffff\1\154\1\156\10\uffff\2\60\1\uffff\4\145\1\60\1\161\2\141\1\144\1\165\2\145\1\163\1\165\1\uffff\1\154\1\145\1\60\1\160\1\143\1\141\1\162\1\uffff\1\165\2\164\1\60\1\162\1\164\1\60\1\145\1\164\2\60\2\164\1\155\4\145\1\uffff\1\156\1\145\1\uffff\2\60\2\uffff\1\151\1\72\1\60\1\144\5\60\2\uffff\1\157\2\uffff\1\60\5\uffff\1\156\1\uffff\1\60\1\uffff";
	static final String DFA24_maxS = "\1\uffff\1\uffff\1\170\1\164\1\165\1\160\1\162\2\145\1\162\1\141\4\uffff\1\156\1\72\4\uffff\1\56\1\165\2\uffff\1\125\1\uffff\2\uffff\1\57\1\170\1\137\3\uffff\1\143\1\146\1\uffff\1\162\1\144\1\164\1\151\1\144\1\145\1\164\1\154\1\165\1\154\4\uffff\1\172\10\uffff\1\154\1\156\10\uffff\2\137\1\uffff\4\145\1\172\1\161\2\141\1\144\1\165\2\145\1\163\1\165\1\uffff\1\154\1\145\1\137\1\160\1\143\1\141\1\162\1\uffff\1\165\2\164\1\172\1\162\1\164\1\172\1\145\1\164\2\172\2\164\1\155\4\145\1\uffff\1\156\1\145\1\uffff\2\172\2\uffff\1\151\1\72\1\172\1\144\5\172\2\uffff\1\157\2\uffff\1\172\5\uffff\1\156\1\uffff\1\172\1\uffff";
	static final String DFA24_acceptS = "\1\uffff\1\1\11\uffff\1\14\1\15\1\16\1\17\2\uffff\1\25\1\26\1\27\1\31\2\uffff\1\36\1\37\1\uffff\1\42\5\uffff\1\50\1\51\1\1\2\uffff\1\42\12\uffff\1\14\1\15\1\16\1\17\1\uffff\1\35\1\24\1\25\1\26\1\27\1\31\1\40\1\32\2\uffff\1\36\1\37\1\41\1\43\1\44\1\45\1\47\1\46\2\uffff\1\50\16\uffff\1\20\7\uffff\1\21\22\uffff\1\7\2\uffff\1\12\2\uffff\1\33\1\34\11\uffff\1\13\1\22\1\uffff\1\30\1\3\1\uffff\1\5\1\10\1\6\1\23\1\11\1\uffff\1\4\1\uffff\1\2";
	static final String DFA24_specialS = "\1\0\32\uffff\1\1\1\2\166\uffff}>";
	static final String[] DFA24_transitionS = {
			"\11\41\2\40\2\41\1\40\22\41\1\40\1\41\1\34\1\15\3\41\1\33\2\41\1\1\1\13\1\23\1\14\1\25\1\35\1\36\11\37\1\20\1\41\1\31\1\24\3\41\32\32\1\27\1\41\1\30\1\41\1\32\1\41\2\32\1\6\1\10\1\2\1\12\2\32\1\17\4\32\1\26\1\4\2\32\1\7\1\3\1\11\1\5\5\32\1\21\1\41\1\22\1\16\uff81\41",
			"",
			"\1\44\21\uffff\1\43",
			"\1\46",
			"\1\47\2\uffff\1\50",
			"\1\51\1\uffff\1\52",
			"\1\53",
			"\1\54",
			"\1\55",
			"\1\56",
			"\1\57",
			"",
			"",
			"",
			"",
			"\1\64",
			"\1\65",
			"",
			"",
			"",
			"",
			"\1\73",
			"\1\76\5\uffff\1\75",
			"",
			"",
			"\1\101",
			"",
			"\0\45",
			"\0\102",
			"\1\103\4\uffff\1\104",
			"\10\107\12\uffff\1\105\25\uffff\1\105\6\uffff\1\105\2\uffff\1\105\25\uffff\1\105",
			"\12\110\45\uffff\1\105",
			"",
			"",
			"",
			"\1\112",
			"\1\113",
			"",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"\1\122\22\uffff\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"",
			"",
			"",
			"",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\16\45\1\127\13\45",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\131",
			"\1\132",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\10\133\47\uffff\1\105",
			"\12\110\45\uffff\1\105",
			"",
			"\1\134",
			"\1\135",
			"\1\136",
			"\1\137",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\141",
			"\1\142",
			"\1\143",
			"\1\144",
			"\1\145",
			"\1\146",
			"\1\147",
			"\1\150",
			"\1\151",
			"",
			"\1\152",
			"\1\153",
			"\10\133\47\uffff\1\105",
			"\1\154",
			"\1\155",
			"\1\156",
			"\1\157",
			"",
			"\1\160",
			"\1\161",
			"\1\162",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\164",
			"\1\165",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\167",
			"\1\170",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\173",
			"\1\174",
			"\1\175",
			"\1\176",
			"\1\177",
			"\1\u0080",
			"\1\u0081",
			"",
			"\1\u0082",
			"\1\u0083",
			"",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"",
			"\1\u0086",
			"\1\u0087",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\u0089",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"",
			"\1\u008f",
			"",
			"",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"",
			"",
			"",
			"",
			"\1\u0091",
			"",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			""
	};

	static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
	static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
	static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
	static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
	static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
	static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
	static final short[][] DFA24_transition;

	static {
		int numStates = DFA24_transitionS.length;
		DFA24_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
		}
	}

	class DFA24 extends DFA {

		public DFA24(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 24;
			this.eot = DFA24_eot;
			this.eof = DFA24_eof;
			this.min = DFA24_min;
			this.max = DFA24_max;
			this.accept = DFA24_accept;
			this.special = DFA24_special;
			this.transition = DFA24_transition;
		}

		public String getDescription() {
			return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_INT | RULE_INTEGER_VALUE | RULE_WS | RULE_ANY_OTHER );";
		}

		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA24_0 = input.LA(1);

				s = -1;
				if ((LA24_0 == '*')) {
					s = 1;
				}

				else if ((LA24_0 == 'e')) {
					s = 2;
				}

				else if ((LA24_0 == 's')) {
					s = 3;
				}

				else if ((LA24_0 == 'o')) {
					s = 4;
				}

				else if ((LA24_0 == 'u')) {
					s = 5;
				}

				else if ((LA24_0 == 'c')) {
					s = 6;
				}

				else if ((LA24_0 == 'r')) {
					s = 7;
				}

				else if ((LA24_0 == 'd')) {
					s = 8;
				}

				else if ((LA24_0 == 't')) {
					s = 9;
				}

				else if ((LA24_0 == 'f')) {
					s = 10;
				}

				else if ((LA24_0 == '+')) {
					s = 11;
				}

				else if ((LA24_0 == '-')) {
					s = 12;
				}

				else if ((LA24_0 == '#')) {
					s = 13;
				}

				else if ((LA24_0 == '~')) {
					s = 14;
				}

				else if ((LA24_0 == 'i')) {
					s = 15;
				}

				else if ((LA24_0 == ':')) {
					s = 16;
				}

				else if ((LA24_0 == '{')) {
					s = 17;
				}

				else if ((LA24_0 == '}')) {
					s = 18;
				}

				else if ((LA24_0 == ',')) {
					s = 19;
				}

				else if ((LA24_0 == '=')) {
					s = 20;
				}

				else if ((LA24_0 == '.')) {
					s = 21;
				}

				else if ((LA24_0 == 'n')) {
					s = 22;
				}

				else if ((LA24_0 == '[')) {
					s = 23;
				}

				else if ((LA24_0 == ']')) {
					s = 24;
				}

				else if ((LA24_0 == '<')) {
					s = 25;
				}

				else if (((LA24_0 >= 'A' && LA24_0 <= 'Z') || LA24_0 == '_' || (LA24_0 >= 'a' && LA24_0 <= 'b') || (LA24_0 >= 'g' && LA24_0 <= 'h') || (LA24_0 >= 'j' && LA24_0 <= 'm') || (LA24_0 >= 'p' && LA24_0 <= 'q') || (LA24_0 >= 'v' && LA24_0 <= 'z'))) {
					s = 26;
				}

				else if ((LA24_0 == '\'')) {
					s = 27;
				}

				else if ((LA24_0 == '\"')) {
					s = 28;
				}

				else if ((LA24_0 == '/')) {
					s = 29;
				}

				else if ((LA24_0 == '0')) {
					s = 30;
				}

				else if (((LA24_0 >= '1' && LA24_0 <= '9'))) {
					s = 31;
				}

				else if (((LA24_0 >= '\t' && LA24_0 <= '\n') || LA24_0 == '\r' || LA24_0 == ' ')) {
					s = 32;
				}

				else if (((LA24_0 >= '\u0000' && LA24_0 <= '\b') || (LA24_0 >= '\u000B' && LA24_0 <= '\f') || (LA24_0 >= '\u000E' && LA24_0 <= '\u001F') || LA24_0 == '!' || (LA24_0 >= '$' && LA24_0 <= '&') || (LA24_0 >= '(' && LA24_0 <= ')') || LA24_0 == ';'
						|| (LA24_0 >= '>' && LA24_0 <= '@') || LA24_0 == '\\' || LA24_0 == '^' || LA24_0 == '`' || LA24_0 == '|' || (LA24_0 >= '\u007F' && LA24_0 <= '\uFFFF'))) {
					s = 33;
				}

				if (s >= 0)
					return s;
				break;
			case 1:
				int LA24_27 = input.LA(1);

				s = -1;
				if (((LA24_27 >= '\u0000' && LA24_27 <= '\uFFFF'))) {
					s = 37;
				}

				else
					s = 33;

				if (s >= 0)
					return s;
				break;
			case 2:
				int LA24_28 = input.LA(1);

				s = -1;
				if (((LA24_28 >= '\u0000' && LA24_28 <= '\uFFFF'))) {
					s = 66;
				}

				else
					s = 33;

				if (s >= 0)
					return s;
				break;
			}
			NoViableAltException nvae = new NoViableAltException(getDescription(), 24, _s, input);
			error(nvae);
			throw nvae;
		}
	}


}