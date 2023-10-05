package org.eclipse.papyrus.uml.textedit.transition.xtext.parser.antlr.internal;

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
import org.eclipse.xtext.parser.antlr.Lexer;

@SuppressWarnings("all")
public class InternalUmlTransitionLexer extends Lexer {
	public static final int RULE_STRING = 5;
	public static final int RULE_SL_COMMENT = 7;
	public static final int T__19 = 19;
	public static final int T__15 = 15;
	public static final int T__16 = 16;
	public static final int T__17 = 17;
	public static final int T__18 = 18;
	public static final int T__12 = 12;
	public static final int T__13 = 13;
	public static final int T__14 = 14;
	public static final int EOF = -1;
	public static final int RULE_ID = 4;
	public static final int RULE_WS = 10;
	public static final int RULE_ANY_OTHER = 11;
	public static final int RULE_INT = 8;
	public static final int T__22 = 22;
	public static final int RULE_ML_COMMENT = 6;
	public static final int RULE_INTEGER_VALUE = 9;
	public static final int T__20 = 20;
	public static final int T__21 = 21;

	// delegates
	// delegators

	public InternalUmlTransitionLexer() {
		;
	}

	public InternalUmlTransitionLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalUmlTransitionLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);

	}

	public String getGrammarFileName() {
		return "InternalUmlTransition.g";
	}

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlTransition.g:11:7: ( ',' )
			// InternalUmlTransition.g:11:9: ','
			{
				match(',');

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
			// InternalUmlTransition.g:12:7: ( 'all' )
			// InternalUmlTransition.g:12:9: 'all'
			{
				match("all");


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
			// InternalUmlTransition.g:13:7: ( 'after' )
			// InternalUmlTransition.g:13:9: 'after'
			{
				match("after");


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
			// InternalUmlTransition.g:14:7: ( 'at' )
			// InternalUmlTransition.g:14:9: 'at'
			{
				match("at");


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
			// InternalUmlTransition.g:15:7: ( 'when' )
			// InternalUmlTransition.g:15:9: 'when'
			{
				match("when");


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
			// InternalUmlTransition.g:16:7: ( '[' )
			// InternalUmlTransition.g:16:9: '['
			{
				match('[');

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
			// InternalUmlTransition.g:17:7: ( ']' )
			// InternalUmlTransition.g:17:9: ']'
			{
				match(']');

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
			// InternalUmlTransition.g:18:7: ( '/' )
			// InternalUmlTransition.g:18:9: '/'
			{
				match('/');

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
			// InternalUmlTransition.g:19:7: ( 'Activity' )
			// InternalUmlTransition.g:19:9: 'Activity'
			{
				match("Activity");


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
			// InternalUmlTransition.g:20:7: ( 'StateMachine' )
			// InternalUmlTransition.g:20:9: 'StateMachine'
			{
				match("StateMachine");


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
			// InternalUmlTransition.g:21:7: ( 'OpaqueBehavior' )
			// InternalUmlTransition.g:21:9: 'OpaqueBehavior'
			{
				match("OpaqueBehavior");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "RULE_ID"
	public final void mRULE_ID() throws RecognitionException {
		try {
			int _type = RULE_ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlTransition.g:596:9: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' ) )
			// InternalUmlTransition.g:596:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' )
			{
				// InternalUmlTransition.g:596:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' )
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
				// InternalUmlTransition.g:596:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
				{
					if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
						input.consume();

					} else {
						MismatchedSetException mse = new MismatchedSetException(null, input);
						recover(mse);
						throw mse;
					}

					// InternalUmlTransition.g:596:36: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
					loop1: do {
						int alt1 = 2;
						int LA1_0 = input.LA(1);

						if (((LA1_0 >= '0' && LA1_0 <= '9') || (LA1_0 >= 'A' && LA1_0 <= 'Z') || LA1_0 == '_' || (LA1_0 >= 'a' && LA1_0 <= 'z'))) {
							alt1 = 1;
						}


						switch (alt1) {
						case 1:
						// InternalUmlTransition.g:
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
				// InternalUmlTransition.g:596:70: '\\'' ( options {greedy=false; } : . )* '\\''
				{
					match('\'');
					// InternalUmlTransition.g:596:75: ( options {greedy=false; } : . )*
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
						// InternalUmlTransition.g:596:103: .
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
			// InternalUmlTransition.g:598:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
			// InternalUmlTransition.g:598:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
			{
				match('\"');
				// InternalUmlTransition.g:598:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
					// InternalUmlTransition.g:598:20: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
					// InternalUmlTransition.g:598:61: ~ ( ( '\\\\' | '\"' ) )
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
			// InternalUmlTransition.g:600:17: ( '/*' ~ ( '@' ) ( options {greedy=false; } : . )* '*/' )
			// InternalUmlTransition.g:600:19: '/*' ~ ( '@' ) ( options {greedy=false; } : . )* '*/'
			{
				match("/*");

				if ((input.LA(1) >= '\u0000' && input.LA(1) <= '?') || (input.LA(1) >= 'A' && input.LA(1) <= '\uFFFF')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

				// InternalUmlTransition.g:600:31: ( options {greedy=false; } : . )*
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
					// InternalUmlTransition.g:600:59: .
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
			// InternalUmlTransition.g:602:17: ( '//' (~ ( ( '\\n' | '\\r' | '@' ) ) )* ( ( '\\r' )? '\\n' )? )
			// InternalUmlTransition.g:602:19: '//' (~ ( ( '\\n' | '\\r' | '@' ) ) )* ( ( '\\r' )? '\\n' )?
			{
				match("//");

				// InternalUmlTransition.g:602:24: (~ ( ( '\\n' | '\\r' | '@' ) ) )*
				loop6: do {
					int alt6 = 2;
					int LA6_0 = input.LA(1);

					if (((LA6_0 >= '\u0000' && LA6_0 <= '\t') || (LA6_0 >= '\u000B' && LA6_0 <= '\f') || (LA6_0 >= '\u000E' && LA6_0 <= '?') || (LA6_0 >= 'A' && LA6_0 <= '\uFFFF'))) {
						alt6 = 1;
					}


					switch (alt6) {
					case 1:
					// InternalUmlTransition.g:602:24: ~ ( ( '\\n' | '\\r' | '@' ) )
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

				// InternalUmlTransition.g:602:44: ( ( '\\r' )? '\\n' )?
				int alt8 = 2;
				int LA8_0 = input.LA(1);

				if ((LA8_0 == '\n' || LA8_0 == '\r')) {
					alt8 = 1;
				}
				switch (alt8) {
				case 1:
				// InternalUmlTransition.g:602:45: ( '\\r' )? '\\n'
				{
					// InternalUmlTransition.g:602:45: ( '\\r' )?
					int alt7 = 2;
					int LA7_0 = input.LA(1);

					if ((LA7_0 == '\r')) {
						alt7 = 1;
					}
					switch (alt7) {
					case 1:
					// InternalUmlTransition.g:602:45: '\\r'
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
			// InternalUmlTransition.g:604:10: ( ( '0' .. '9' )+ )
			// InternalUmlTransition.g:604:12: ( '0' .. '9' )+
			{
				// InternalUmlTransition.g:604:12: ( '0' .. '9' )+
				int cnt9 = 0;
				loop9: do {
					int alt9 = 2;
					int LA9_0 = input.LA(1);

					if (((LA9_0 >= '0' && LA9_0 <= '9'))) {
						alt9 = 1;
					}


					switch (alt9) {
					case 1:
					// InternalUmlTransition.g:604:13: '0' .. '9'
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
			// InternalUmlTransition.g:606:20: ( ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F'
			// ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* ) )
			// InternalUmlTransition.g:606:22: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
			// )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
			{
				// InternalUmlTransition.g:606:22: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' ..
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
				// InternalUmlTransition.g:606:23: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
				{
					// InternalUmlTransition.g:606:23: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
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
					// InternalUmlTransition.g:606:24: '0'
					{
						match('0');

					}
						break;
					case 2:
					// InternalUmlTransition.g:606:28: '1' .. '9' ( ( '_' )? '0' .. '9' )*
					{
						matchRange('1', '9');
						// InternalUmlTransition.g:606:37: ( ( '_' )? '0' .. '9' )*
						loop11: do {
							int alt11 = 2;
							int LA11_0 = input.LA(1);

							if (((LA11_0 >= '0' && LA11_0 <= '9') || LA11_0 == '_')) {
								alt11 = 1;
							}


							switch (alt11) {
							case 1:
							// InternalUmlTransition.g:606:38: ( '_' )? '0' .. '9'
							{
								// InternalUmlTransition.g:606:38: ( '_' )?
								int alt10 = 2;
								int LA10_0 = input.LA(1);

								if ((LA10_0 == '_')) {
									alt10 = 1;
								}
								switch (alt10) {
								case 1:
								// InternalUmlTransition.g:606:38: '_'
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
				// InternalUmlTransition.g:606:55: ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )*
				{
					// InternalUmlTransition.g:606:55: ( '0b' | '0B' )
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
					// InternalUmlTransition.g:606:56: '0b'
					{
						match("0b");


					}
						break;
					case 2:
					// InternalUmlTransition.g:606:61: '0B'
					{
						match("0B");


					}
						break;

					}

					matchRange('0', '1');
					// InternalUmlTransition.g:606:76: ( ( '_' )? '0' .. '1' )*
					loop15: do {
						int alt15 = 2;
						int LA15_0 = input.LA(1);

						if (((LA15_0 >= '0' && LA15_0 <= '1') || LA15_0 == '_')) {
							alt15 = 1;
						}


						switch (alt15) {
						case 1:
						// InternalUmlTransition.g:606:77: ( '_' )? '0' .. '1'
						{
							// InternalUmlTransition.g:606:77: ( '_' )?
							int alt14 = 2;
							int LA14_0 = input.LA(1);

							if ((LA14_0 == '_')) {
								alt14 = 1;
							}
							switch (alt14) {
							case 1:
							// InternalUmlTransition.g:606:77: '_'
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
				// InternalUmlTransition.g:606:93: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
				{
					// InternalUmlTransition.g:606:93: ( '0x' | '0X' )
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
					// InternalUmlTransition.g:606:94: '0x'
					{
						match("0x");


					}
						break;
					case 2:
					// InternalUmlTransition.g:606:99: '0X'
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

					// InternalUmlTransition.g:606:134: ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
					loop18: do {
						int alt18 = 2;
						int LA18_0 = input.LA(1);

						if (((LA18_0 >= '0' && LA18_0 <= '9') || (LA18_0 >= 'A' && LA18_0 <= 'F') || LA18_0 == '_' || (LA18_0 >= 'a' && LA18_0 <= 'f'))) {
							alt18 = 1;
						}


						switch (alt18) {
						case 1:
						// InternalUmlTransition.g:606:135: ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
						{
							// InternalUmlTransition.g:606:135: ( '_' )?
							int alt17 = 2;
							int LA17_0 = input.LA(1);

							if ((LA17_0 == '_')) {
								alt17 = 1;
							}
							switch (alt17) {
							case 1:
							// InternalUmlTransition.g:606:135: '_'
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
				// InternalUmlTransition.g:606:171: '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )*
				{
					match('0');
					// InternalUmlTransition.g:606:175: ( '_' )?
					int alt19 = 2;
					int LA19_0 = input.LA(1);

					if ((LA19_0 == '_')) {
						alt19 = 1;
					}
					switch (alt19) {
					case 1:
					// InternalUmlTransition.g:606:175: '_'
					{
						match('_');

					}
						break;

					}

					matchRange('0', '7');
					// InternalUmlTransition.g:606:189: ( ( '_' )? '0' .. '7' )*
					loop21: do {
						int alt21 = 2;
						int LA21_0 = input.LA(1);

						if (((LA21_0 >= '0' && LA21_0 <= '7') || LA21_0 == '_')) {
							alt21 = 1;
						}


						switch (alt21) {
						case 1:
						// InternalUmlTransition.g:606:190: ( '_' )? '0' .. '7'
						{
							// InternalUmlTransition.g:606:190: ( '_' )?
							int alt20 = 2;
							int LA20_0 = input.LA(1);

							if ((LA20_0 == '_')) {
								alt20 = 1;
							}
							switch (alt20) {
							case 1:
							// InternalUmlTransition.g:606:190: '_'
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
			// InternalUmlTransition.g:608:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// InternalUmlTransition.g:608:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
				// InternalUmlTransition.g:608:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
				int cnt23 = 0;
				loop23: do {
					int alt23 = 2;
					int LA23_0 = input.LA(1);

					if (((LA23_0 >= '\t' && LA23_0 <= '\n') || LA23_0 == '\r' || LA23_0 == ' ')) {
						alt23 = 1;
					}


					switch (alt23) {
					case 1:
					// InternalUmlTransition.g:
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
			// InternalUmlTransition.g:610:16: ( . )
			// InternalUmlTransition.g:610:18: .
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
		// InternalUmlTransition.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_INT | RULE_INTEGER_VALUE | RULE_WS | RULE_ANY_OTHER )
		int alt24 = 19;
		alt24 = dfa24.predict(input);
		switch (alt24) {
		case 1:
		// InternalUmlTransition.g:1:10: T__12
		{
			mT__12();

		}
			break;
		case 2:
		// InternalUmlTransition.g:1:16: T__13
		{
			mT__13();

		}
			break;
		case 3:
		// InternalUmlTransition.g:1:22: T__14
		{
			mT__14();

		}
			break;
		case 4:
		// InternalUmlTransition.g:1:28: T__15
		{
			mT__15();

		}
			break;
		case 5:
		// InternalUmlTransition.g:1:34: T__16
		{
			mT__16();

		}
			break;
		case 6:
		// InternalUmlTransition.g:1:40: T__17
		{
			mT__17();

		}
			break;
		case 7:
		// InternalUmlTransition.g:1:46: T__18
		{
			mT__18();

		}
			break;
		case 8:
		// InternalUmlTransition.g:1:52: T__19
		{
			mT__19();

		}
			break;
		case 9:
		// InternalUmlTransition.g:1:58: T__20
		{
			mT__20();

		}
			break;
		case 10:
		// InternalUmlTransition.g:1:64: T__21
		{
			mT__21();

		}
			break;
		case 11:
		// InternalUmlTransition.g:1:70: T__22
		{
			mT__22();

		}
			break;
		case 12:
		// InternalUmlTransition.g:1:76: RULE_ID
		{
			mRULE_ID();

		}
			break;
		case 13:
		// InternalUmlTransition.g:1:84: RULE_STRING
		{
			mRULE_STRING();

		}
			break;
		case 14:
		// InternalUmlTransition.g:1:96: RULE_ML_COMMENT
		{
			mRULE_ML_COMMENT();

		}
			break;
		case 15:
		// InternalUmlTransition.g:1:112: RULE_SL_COMMENT
		{
			mRULE_SL_COMMENT();

		}
			break;
		case 16:
		// InternalUmlTransition.g:1:128: RULE_INT
		{
			mRULE_INT();

		}
			break;
		case 17:
		// InternalUmlTransition.g:1:137: RULE_INTEGER_VALUE
		{
			mRULE_INTEGER_VALUE();

		}
			break;
		case 18:
		// InternalUmlTransition.g:1:156: RULE_WS
		{
			mRULE_WS();

		}
			break;
		case 19:
		// InternalUmlTransition.g:1:164: RULE_ANY_OTHER
		{
			mRULE_ANY_OTHER();

		}
			break;

		}

	}


	protected DFA24 dfa24 = new DFA24(this);
	static final String DFA24_eotS = "\2\uffff\2\25\2\uffff\1\33\3\25\1\uffff\2\20\2\41\3\uffff\2\25\1\47\1\uffff\1\25\5\uffff\3\25\3\uffff\2\41\1\uffff\1\55\1\25\1\uffff\4\25\1\41\1\uffff\1\25\1\64\3\25\1\70\1\uffff\3\25\1\uffff\6\25\1\102\2\25\1\uffff\6\25\1\113\1\25\1\uffff\1\25\1\116\1\uffff";
	static final String DFA24_eofS = "\117\uffff";
	static final String DFA24_minS = "\1\0\1\uffff\1\146\1\150\2\uffff\1\52\1\143\1\164\1\160\1\uffff\2\0\2\60\3\uffff\1\154\1\164\1\60\1\uffff\1\145\5\uffff\1\164\2\141\3\uffff\2\60\1\uffff\1\60\1\145\1\uffff\1\156\1\151\1\164\1\161\1\60\1\uffff\1\162\1\60\1\166\1\145\1\165\1\60\1\uffff\1\151\1\115\1\145\1\uffff\1\164\1\141\1\102\1\171\1\143\1\145\1\60\2\150\1\uffff\1\151\1\141\1\156\1\166\1\145\1\151\1\60\1\157\1\uffff\1\162\1\60\1\uffff";
	static final String DFA24_maxS = "\1\uffff\1\uffff\1\164\1\150\2\uffff\1\57\1\143\1\164\1\160\1\uffff\2\uffff\1\170\1\137\3\uffff\1\154\1\164\1\172\1\uffff\1\145\5\uffff\1\164\2\141\3\uffff\2\137\1\uffff\1\172\1\145\1\uffff\1\156\1\151\1\164\1\161\1\137\1\uffff\1\162\1\172\1\166\1\145\1\165\1\172\1\uffff\1\151\1\115\1\145\1\uffff\1\164\1\141\1\102\1\171\1\143\1\145\1\172\2\150\1\uffff\1\151\1\141\1\156\1\166\1\145\1\151\1\172\1\157\1\uffff\1\162\1\172\1\uffff";
	static final String DFA24_acceptS = "\1\uffff\1\1\2\uffff\1\6\1\7\4\uffff\1\14\4\uffff\1\22\1\23\1\1\3\uffff\1\14\1\uffff\1\6\1\7\1\16\1\17\1\10\3\uffff\1\15\1\21\1\20\2\uffff\1\22\2\uffff\1\4\5\uffff\1\2\6\uffff\1\5\3\uffff\1\3\11\uffff\1\11\10\uffff\1\12\2\uffff\1\13";
	static final String DFA24_specialS = "\1\0\12\uffff\1\1\1\2\102\uffff}>";
	static final String[] DFA24_transitionS = {
			"\11\20\2\17\2\20\1\17\22\20\1\17\1\20\1\14\4\20\1\13\4\20\1\1\2\20\1\6\1\15\11\16\7\20\1\7\15\12\1\11\3\12\1\10\7\12\1\4\1\20\1\5\1\20\1\12\1\20\1\2\25\12\1\3\3\12\uff85\20",
			"",
			"\1\23\5\uffff\1\22\7\uffff\1\24",
			"\1\26",
			"",
			"",
			"\1\31\4\uffff\1\32",
			"\1\34",
			"\1\35",
			"\1\36",
			"",
			"\0\25",
			"\0\37",
			"\10\42\12\uffff\1\40\25\uffff\1\40\6\uffff\1\40\2\uffff\1\40\25\uffff\1\40",
			"\12\43\45\uffff\1\40",
			"",
			"",
			"",
			"\1\45",
			"\1\46",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\50",
			"",
			"",
			"",
			"",
			"",
			"\1\51",
			"\1\52",
			"\1\53",
			"",
			"",
			"",
			"\10\54\47\uffff\1\40",
			"\12\43\45\uffff\1\40",
			"",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\56",
			"",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\10\54\47\uffff\1\40",
			"",
			"\1\63",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\65",
			"\1\66",
			"\1\67",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\71",
			"\1\72",
			"\1\73",
			"",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\103",
			"\1\104",
			"",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"\1\111",
			"\1\112",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\114",
			"",
			"\1\115",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
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
			return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_INT | RULE_INTEGER_VALUE | RULE_WS | RULE_ANY_OTHER );";
		}

		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA24_0 = input.LA(1);

				s = -1;
				if ((LA24_0 == ',')) {
					s = 1;
				}

				else if ((LA24_0 == 'a')) {
					s = 2;
				}

				else if ((LA24_0 == 'w')) {
					s = 3;
				}

				else if ((LA24_0 == '[')) {
					s = 4;
				}

				else if ((LA24_0 == ']')) {
					s = 5;
				}

				else if ((LA24_0 == '/')) {
					s = 6;
				}

				else if ((LA24_0 == 'A')) {
					s = 7;
				}

				else if ((LA24_0 == 'S')) {
					s = 8;
				}

				else if ((LA24_0 == 'O')) {
					s = 9;
				}

				else if (((LA24_0 >= 'B' && LA24_0 <= 'N') || (LA24_0 >= 'P' && LA24_0 <= 'R') || (LA24_0 >= 'T' && LA24_0 <= 'Z') || LA24_0 == '_' || (LA24_0 >= 'b' && LA24_0 <= 'v') || (LA24_0 >= 'x' && LA24_0 <= 'z'))) {
					s = 10;
				}

				else if ((LA24_0 == '\'')) {
					s = 11;
				}

				else if ((LA24_0 == '\"')) {
					s = 12;
				}

				else if ((LA24_0 == '0')) {
					s = 13;
				}

				else if (((LA24_0 >= '1' && LA24_0 <= '9'))) {
					s = 14;
				}

				else if (((LA24_0 >= '\t' && LA24_0 <= '\n') || LA24_0 == '\r' || LA24_0 == ' ')) {
					s = 15;
				}

				else if (((LA24_0 >= '\u0000' && LA24_0 <= '\b') || (LA24_0 >= '\u000B' && LA24_0 <= '\f') || (LA24_0 >= '\u000E' && LA24_0 <= '\u001F') || LA24_0 == '!' || (LA24_0 >= '#' && LA24_0 <= '&') || (LA24_0 >= '(' && LA24_0 <= '+')
						|| (LA24_0 >= '-' && LA24_0 <= '.') || (LA24_0 >= ':' && LA24_0 <= '@') || LA24_0 == '\\' || LA24_0 == '^' || LA24_0 == '`' || (LA24_0 >= '{' && LA24_0 <= '\uFFFF'))) {
					s = 16;
				}

				if (s >= 0)
					return s;
				break;
			case 1:
				int LA24_11 = input.LA(1);

				s = -1;
				if (((LA24_11 >= '\u0000' && LA24_11 <= '\uFFFF'))) {
					s = 21;
				}

				else
					s = 16;

				if (s >= 0)
					return s;
				break;
			case 2:
				int LA24_12 = input.LA(1);

				s = -1;
				if (((LA24_12 >= '\u0000' && LA24_12 <= '\uFFFF'))) {
					s = 31;
				}

				else
					s = 16;

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