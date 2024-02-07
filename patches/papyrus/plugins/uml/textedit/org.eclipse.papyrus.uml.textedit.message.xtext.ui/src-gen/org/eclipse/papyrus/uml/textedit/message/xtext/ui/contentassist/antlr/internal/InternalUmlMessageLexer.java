package org.eclipse.papyrus.uml.textedit.message.xtext.ui.contentassist.antlr.internal;

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
public class InternalUmlMessageLexer extends Lexer {
	public static final int RULE_ID = 7;
	public static final int RULE_WS = 11;
	public static final int RULE_STRING = 4;
	public static final int RULE_ANY_OTHER = 12;
	public static final int RULE_SL_COMMENT = 9;
	public static final int T__15 = 15;
	public static final int T__16 = 16;
	public static final int T__17 = 17;
	public static final int RULE_INT = 6;
	public static final int RULE_ML_COMMENT = 8;
	public static final int RULE_INTEGER_VALUE = 10;
	public static final int T__13 = 13;
	public static final int T__14 = 14;
	public static final int EOF = -1;
	public static final int RULE_NAME_RULE = 5;

	// delegates
	// delegators

	public InternalUmlMessageLexer() {
		;
	}

	public InternalUmlMessageLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalUmlMessageLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);

	}

	public String getGrammarFileName() {
		return "InternalUmlMessage.g";
	}

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlMessage.g:11:7: ( ':' )
			// InternalUmlMessage.g:11:9: ':'
			{
				match(':');

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
			// InternalUmlMessage.g:12:7: ( '.' )
			// InternalUmlMessage.g:12:9: '.'
			{
				match('.');

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
			// InternalUmlMessage.g:13:7: ( '*' )
			// InternalUmlMessage.g:13:9: '*'
			{
				match('*');

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
			// InternalUmlMessage.g:14:7: ( '[' )
			// InternalUmlMessage.g:14:9: '['
			{
				match('[');

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
			// InternalUmlMessage.g:15:7: ( ']' )
			// InternalUmlMessage.g:15:9: ']'
			{
				match(']');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "RULE_NAME_RULE"
	public final void mRULE_NAME_RULE() throws RecognitionException {
		try {
			int _type = RULE_NAME_RULE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlMessage.g:765:16: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' | '(' | ')' )* )
			// InternalUmlMessage.g:765:18: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' | '(' | ')' )*
			{
				if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

				// InternalUmlMessage.g:765:38: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' | '(' | ')' )*
				loop1: do {
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if (((LA1_0 >= '(' && LA1_0 <= ')') || LA1_0 == '-' || (LA1_0 >= '0' && LA1_0 <= '9') || (LA1_0 >= 'A' && LA1_0 <= 'Z') || LA1_0 == '_' || (LA1_0 >= 'a' && LA1_0 <= 'z'))) {
						alt1 = 1;
					}


					switch (alt1) {
					case 1:
					// InternalUmlMessage.g:
					{
						if ((input.LA(1) >= '(' && input.LA(1) <= ')') || input.LA(1) == '-' || (input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
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

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_NAME_RULE"

	// $ANTLR start "RULE_ID"
	public final void mRULE_ID() throws RecognitionException {
		try {
			int _type = RULE_ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlMessage.g:767:9: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' ) )
			// InternalUmlMessage.g:767:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' )
			{
				// InternalUmlMessage.g:767:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' )
				int alt4 = 2;
				int LA4_0 = input.LA(1);

				if (((LA4_0 >= 'A' && LA4_0 <= 'Z') || LA4_0 == '_' || (LA4_0 >= 'a' && LA4_0 <= 'z'))) {
					alt4 = 1;
				} else if ((LA4_0 == '\'')) {
					alt4 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 4, 0, input);

					throw nvae;
				}
				switch (alt4) {
				case 1:
				// InternalUmlMessage.g:767:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
				{
					if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
						input.consume();

					} else {
						MismatchedSetException mse = new MismatchedSetException(null, input);
						recover(mse);
						throw mse;
					}

					// InternalUmlMessage.g:767:36: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
					loop2: do {
						int alt2 = 2;
						int LA2_0 = input.LA(1);

						if (((LA2_0 >= '0' && LA2_0 <= '9') || (LA2_0 >= 'A' && LA2_0 <= 'Z') || LA2_0 == '_' || (LA2_0 >= 'a' && LA2_0 <= 'z'))) {
							alt2 = 1;
						}


						switch (alt2) {
						case 1:
						// InternalUmlMessage.g:
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
							break loop2;
						}
					} while (true);


				}
					break;
				case 2:
				// InternalUmlMessage.g:767:70: '\\'' ( options {greedy=false; } : . )* '\\''
				{
					match('\'');
					// InternalUmlMessage.g:767:75: ( options {greedy=false; } : . )*
					loop3: do {
						int alt3 = 2;
						int LA3_0 = input.LA(1);

						if ((LA3_0 == '\'')) {
							alt3 = 2;
						} else if (((LA3_0 >= '\u0000' && LA3_0 <= '&') || (LA3_0 >= '(' && LA3_0 <= '\uFFFF'))) {
							alt3 = 1;
						}


						switch (alt3) {
						case 1:
						// InternalUmlMessage.g:767:103: .
						{
							matchAny();

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
			// InternalUmlMessage.g:769:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
			// InternalUmlMessage.g:769:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
			{
				match('\"');
				// InternalUmlMessage.g:769:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
				loop5: do {
					int alt5 = 3;
					int LA5_0 = input.LA(1);

					if ((LA5_0 == '\\')) {
						alt5 = 1;
					} else if (((LA5_0 >= '\u0000' && LA5_0 <= '!') || (LA5_0 >= '#' && LA5_0 <= '[') || (LA5_0 >= ']' && LA5_0 <= '\uFFFF'))) {
						alt5 = 2;
					}


					switch (alt5) {
					case 1:
					// InternalUmlMessage.g:769:20: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
					// InternalUmlMessage.g:769:61: ~ ( ( '\\\\' | '\"' ) )
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
						break loop5;
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
			// InternalUmlMessage.g:771:17: ( '/*' ~ ( '@' ) ( options {greedy=false; } : . )* '*/' )
			// InternalUmlMessage.g:771:19: '/*' ~ ( '@' ) ( options {greedy=false; } : . )* '*/'
			{
				match("/*");

				if ((input.LA(1) >= '\u0000' && input.LA(1) <= '?') || (input.LA(1) >= 'A' && input.LA(1) <= '\uFFFF')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

				// InternalUmlMessage.g:771:31: ( options {greedy=false; } : . )*
				loop6: do {
					int alt6 = 2;
					int LA6_0 = input.LA(1);

					if ((LA6_0 == '*')) {
						int LA6_1 = input.LA(2);

						if ((LA6_1 == '/')) {
							alt6 = 2;
						} else if (((LA6_1 >= '\u0000' && LA6_1 <= '.') || (LA6_1 >= '0' && LA6_1 <= '\uFFFF'))) {
							alt6 = 1;
						}


					} else if (((LA6_0 >= '\u0000' && LA6_0 <= ')') || (LA6_0 >= '+' && LA6_0 <= '\uFFFF'))) {
						alt6 = 1;
					}


					switch (alt6) {
					case 1:
					// InternalUmlMessage.g:771:59: .
					{
						matchAny();

					}
						break;

					default:
						break loop6;
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
			// InternalUmlMessage.g:773:17: ( '//' (~ ( ( '\\n' | '\\r' | '@' ) ) )* ( ( '\\r' )? '\\n' )? )
			// InternalUmlMessage.g:773:19: '//' (~ ( ( '\\n' | '\\r' | '@' ) ) )* ( ( '\\r' )? '\\n' )?
			{
				match("//");

				// InternalUmlMessage.g:773:24: (~ ( ( '\\n' | '\\r' | '@' ) ) )*
				loop7: do {
					int alt7 = 2;
					int LA7_0 = input.LA(1);

					if (((LA7_0 >= '\u0000' && LA7_0 <= '\t') || (LA7_0 >= '\u000B' && LA7_0 <= '\f') || (LA7_0 >= '\u000E' && LA7_0 <= '?') || (LA7_0 >= 'A' && LA7_0 <= '\uFFFF'))) {
						alt7 = 1;
					}


					switch (alt7) {
					case 1:
					// InternalUmlMessage.g:773:24: ~ ( ( '\\n' | '\\r' | '@' ) )
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
						break loop7;
					}
				} while (true);

				// InternalUmlMessage.g:773:44: ( ( '\\r' )? '\\n' )?
				int alt9 = 2;
				int LA9_0 = input.LA(1);

				if ((LA9_0 == '\n' || LA9_0 == '\r')) {
					alt9 = 1;
				}
				switch (alt9) {
				case 1:
				// InternalUmlMessage.g:773:45: ( '\\r' )? '\\n'
				{
					// InternalUmlMessage.g:773:45: ( '\\r' )?
					int alt8 = 2;
					int LA8_0 = input.LA(1);

					if ((LA8_0 == '\r')) {
						alt8 = 1;
					}
					switch (alt8) {
					case 1:
					// InternalUmlMessage.g:773:45: '\\r'
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
			// InternalUmlMessage.g:775:10: ( ( '0' .. '9' )+ )
			// InternalUmlMessage.g:775:12: ( '0' .. '9' )+
			{
				// InternalUmlMessage.g:775:12: ( '0' .. '9' )+
				int cnt10 = 0;
				loop10: do {
					int alt10 = 2;
					int LA10_0 = input.LA(1);

					if (((LA10_0 >= '0' && LA10_0 <= '9'))) {
						alt10 = 1;
					}


					switch (alt10) {
					case 1:
					// InternalUmlMessage.g:775:13: '0' .. '9'
					{
						matchRange('0', '9');

					}
						break;

					default:
						if (cnt10 >= 1)
							break loop10;
						EarlyExitException eee = new EarlyExitException(10, input);
						throw eee;
					}
					cnt10++;
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
			// InternalUmlMessage.g:777:20: ( ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
			// )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* ) )
			// InternalUmlMessage.g:777:22: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
			// | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
			{
				// InternalUmlMessage.g:777:22: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
				// )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
				int alt23 = 4;
				int LA23_0 = input.LA(1);

				if ((LA23_0 == '0')) {
					switch (input.LA(2)) {
					case 'B':
					case 'b': {
						alt23 = 2;
					}
						break;
					case 'X':
					case 'x': {
						alt23 = 3;
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
						alt23 = 4;
					}
						break;
					default:
						alt23 = 1;
					}

				} else if (((LA23_0 >= '1' && LA23_0 <= '9'))) {
					alt23 = 1;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 23, 0, input);

					throw nvae;
				}
				switch (alt23) {
				case 1:
				// InternalUmlMessage.g:777:23: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
				{
					// InternalUmlMessage.g:777:23: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
					int alt13 = 2;
					int LA13_0 = input.LA(1);

					if ((LA13_0 == '0')) {
						alt13 = 1;
					} else if (((LA13_0 >= '1' && LA13_0 <= '9'))) {
						alt13 = 2;
					} else {
						NoViableAltException nvae = new NoViableAltException("", 13, 0, input);

						throw nvae;
					}
					switch (alt13) {
					case 1:
					// InternalUmlMessage.g:777:24: '0'
					{
						match('0');

					}
						break;
					case 2:
					// InternalUmlMessage.g:777:28: '1' .. '9' ( ( '_' )? '0' .. '9' )*
					{
						matchRange('1', '9');
						// InternalUmlMessage.g:777:37: ( ( '_' )? '0' .. '9' )*
						loop12: do {
							int alt12 = 2;
							int LA12_0 = input.LA(1);

							if (((LA12_0 >= '0' && LA12_0 <= '9') || LA12_0 == '_')) {
								alt12 = 1;
							}


							switch (alt12) {
							case 1:
							// InternalUmlMessage.g:777:38: ( '_' )? '0' .. '9'
							{
								// InternalUmlMessage.g:777:38: ( '_' )?
								int alt11 = 2;
								int LA11_0 = input.LA(1);

								if ((LA11_0 == '_')) {
									alt11 = 1;
								}
								switch (alt11) {
								case 1:
								// InternalUmlMessage.g:777:38: '_'
								{
									match('_');

								}
									break;

								}

								matchRange('0', '9');

							}
								break;

							default:
								break loop12;
							}
						} while (true);


					}
						break;

					}


				}
					break;
				case 2:
				// InternalUmlMessage.g:777:55: ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )*
				{
					// InternalUmlMessage.g:777:55: ( '0b' | '0B' )
					int alt14 = 2;
					int LA14_0 = input.LA(1);

					if ((LA14_0 == '0')) {
						int LA14_1 = input.LA(2);

						if ((LA14_1 == 'b')) {
							alt14 = 1;
						} else if ((LA14_1 == 'B')) {
							alt14 = 2;
						} else {
							NoViableAltException nvae = new NoViableAltException("", 14, 1, input);

							throw nvae;
						}
					} else {
						NoViableAltException nvae = new NoViableAltException("", 14, 0, input);

						throw nvae;
					}
					switch (alt14) {
					case 1:
					// InternalUmlMessage.g:777:56: '0b'
					{
						match("0b");


					}
						break;
					case 2:
					// InternalUmlMessage.g:777:61: '0B'
					{
						match("0B");


					}
						break;

					}

					matchRange('0', '1');
					// InternalUmlMessage.g:777:76: ( ( '_' )? '0' .. '1' )*
					loop16: do {
						int alt16 = 2;
						int LA16_0 = input.LA(1);

						if (((LA16_0 >= '0' && LA16_0 <= '1') || LA16_0 == '_')) {
							alt16 = 1;
						}


						switch (alt16) {
						case 1:
						// InternalUmlMessage.g:777:77: ( '_' )? '0' .. '1'
						{
							// InternalUmlMessage.g:777:77: ( '_' )?
							int alt15 = 2;
							int LA15_0 = input.LA(1);

							if ((LA15_0 == '_')) {
								alt15 = 1;
							}
							switch (alt15) {
							case 1:
							// InternalUmlMessage.g:777:77: '_'
							{
								match('_');

							}
								break;

							}

							matchRange('0', '1');

						}
							break;

						default:
							break loop16;
						}
					} while (true);


				}
					break;
				case 3:
				// InternalUmlMessage.g:777:93: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
				{
					// InternalUmlMessage.g:777:93: ( '0x' | '0X' )
					int alt17 = 2;
					int LA17_0 = input.LA(1);

					if ((LA17_0 == '0')) {
						int LA17_1 = input.LA(2);

						if ((LA17_1 == 'x')) {
							alt17 = 1;
						} else if ((LA17_1 == 'X')) {
							alt17 = 2;
						} else {
							NoViableAltException nvae = new NoViableAltException("", 17, 1, input);

							throw nvae;
						}
					} else {
						NoViableAltException nvae = new NoViableAltException("", 17, 0, input);

						throw nvae;
					}
					switch (alt17) {
					case 1:
					// InternalUmlMessage.g:777:94: '0x'
					{
						match("0x");


					}
						break;
					case 2:
					// InternalUmlMessage.g:777:99: '0X'
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

					// InternalUmlMessage.g:777:134: ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
					loop19: do {
						int alt19 = 2;
						int LA19_0 = input.LA(1);

						if (((LA19_0 >= '0' && LA19_0 <= '9') || (LA19_0 >= 'A' && LA19_0 <= 'F') || LA19_0 == '_' || (LA19_0 >= 'a' && LA19_0 <= 'f'))) {
							alt19 = 1;
						}


						switch (alt19) {
						case 1:
						// InternalUmlMessage.g:777:135: ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
						{
							// InternalUmlMessage.g:777:135: ( '_' )?
							int alt18 = 2;
							int LA18_0 = input.LA(1);

							if ((LA18_0 == '_')) {
								alt18 = 1;
							}
							switch (alt18) {
							case 1:
							// InternalUmlMessage.g:777:135: '_'
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
							break loop19;
						}
					} while (true);


				}
					break;
				case 4:
				// InternalUmlMessage.g:777:171: '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )*
				{
					match('0');
					// InternalUmlMessage.g:777:175: ( '_' )?
					int alt20 = 2;
					int LA20_0 = input.LA(1);

					if ((LA20_0 == '_')) {
						alt20 = 1;
					}
					switch (alt20) {
					case 1:
					// InternalUmlMessage.g:777:175: '_'
					{
						match('_');

					}
						break;

					}

					matchRange('0', '7');
					// InternalUmlMessage.g:777:189: ( ( '_' )? '0' .. '7' )*
					loop22: do {
						int alt22 = 2;
						int LA22_0 = input.LA(1);

						if (((LA22_0 >= '0' && LA22_0 <= '7') || LA22_0 == '_')) {
							alt22 = 1;
						}


						switch (alt22) {
						case 1:
						// InternalUmlMessage.g:777:190: ( '_' )? '0' .. '7'
						{
							// InternalUmlMessage.g:777:190: ( '_' )?
							int alt21 = 2;
							int LA21_0 = input.LA(1);

							if ((LA21_0 == '_')) {
								alt21 = 1;
							}
							switch (alt21) {
							case 1:
							// InternalUmlMessage.g:777:190: '_'
							{
								match('_');

							}
								break;

							}

							matchRange('0', '7');

						}
							break;

						default:
							break loop22;
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
			// InternalUmlMessage.g:779:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// InternalUmlMessage.g:779:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
				// InternalUmlMessage.g:779:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
				int cnt24 = 0;
				loop24: do {
					int alt24 = 2;
					int LA24_0 = input.LA(1);

					if (((LA24_0 >= '\t' && LA24_0 <= '\n') || LA24_0 == '\r' || LA24_0 == ' ')) {
						alt24 = 1;
					}


					switch (alt24) {
					case 1:
					// InternalUmlMessage.g:
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
						if (cnt24 >= 1)
							break loop24;
						EarlyExitException eee = new EarlyExitException(24, input);
						throw eee;
					}
					cnt24++;
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
			// InternalUmlMessage.g:781:16: ( . )
			// InternalUmlMessage.g:781:18: .
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
		// InternalUmlMessage.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | RULE_NAME_RULE | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_INT | RULE_INTEGER_VALUE | RULE_WS | RULE_ANY_OTHER )
		int alt25 = 14;
		alt25 = dfa25.predict(input);
		switch (alt25) {
		case 1:
		// InternalUmlMessage.g:1:10: T__13
		{
			mT__13();

		}
			break;
		case 2:
		// InternalUmlMessage.g:1:16: T__14
		{
			mT__14();

		}
			break;
		case 3:
		// InternalUmlMessage.g:1:22: T__15
		{
			mT__15();

		}
			break;
		case 4:
		// InternalUmlMessage.g:1:28: T__16
		{
			mT__16();

		}
			break;
		case 5:
		// InternalUmlMessage.g:1:34: T__17
		{
			mT__17();

		}
			break;
		case 6:
		// InternalUmlMessage.g:1:40: RULE_NAME_RULE
		{
			mRULE_NAME_RULE();

		}
			break;
		case 7:
		// InternalUmlMessage.g:1:55: RULE_ID
		{
			mRULE_ID();

		}
			break;
		case 8:
		// InternalUmlMessage.g:1:63: RULE_STRING
		{
			mRULE_STRING();

		}
			break;
		case 9:
		// InternalUmlMessage.g:1:75: RULE_ML_COMMENT
		{
			mRULE_ML_COMMENT();

		}
			break;
		case 10:
		// InternalUmlMessage.g:1:91: RULE_SL_COMMENT
		{
			mRULE_SL_COMMENT();

		}
			break;
		case 11:
		// InternalUmlMessage.g:1:107: RULE_INT
		{
			mRULE_INT();

		}
			break;
		case 12:
		// InternalUmlMessage.g:1:116: RULE_INTEGER_VALUE
		{
			mRULE_INTEGER_VALUE();

		}
			break;
		case 13:
		// InternalUmlMessage.g:1:135: RULE_WS
		{
			mRULE_WS();

		}
			break;
		case 14:
		// InternalUmlMessage.g:1:143: RULE_ANY_OTHER
		{
			mRULE_ANY_OTHER();

		}
			break;

		}

	}


	protected DFA25 dfa25 = new DFA25(this);
	static final String DFA25_eotS = "\6\uffff\1\24\1\uffff\3\16\2\34\10\uffff\1\24\5\uffff\1\34\1\uffff\1\34\1\uffff\1\34";
	static final String DFA25_eofS = "\40\uffff";
	static final String DFA25_minS = "\1\0\5\uffff\1\60\1\uffff\2\0\1\52\2\60\10\uffff\1\60\5\uffff\1\60\1\uffff\1\60\1\uffff\1\60";
	static final String DFA25_maxS = "\1\uffff\5\uffff\1\172\1\uffff\2\uffff\1\57\1\170\1\137\10\uffff\1\172\5\uffff\1\137\1\uffff\1\137\1\uffff\1\137";
	static final String DFA25_acceptS = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\5\uffff\1\15\1\16\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\1\10\1\11\1\12\1\14\1\uffff\1\13\1\uffff\1\15\1\uffff";
	static final String DFA25_specialS = "\1\0\7\uffff\1\1\1\2\26\uffff}>";
	static final String[] DFA25_transitionS = {
			"\11\16\2\15\2\16\1\15\22\16\1\15\1\16\1\11\4\16\1\10\2\16\1\3\3\16\1\2\1\12\1\13\11\14\1\1\6\16\32\6\1\4\1\16\1\5\1\16\1\7\1\16\32\6\uff85\16",
			"",
			"",
			"",
			"",
			"",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\0\26",
			"\0\27",
			"\1\30\4\uffff\1\31",
			"\10\33\12\uffff\1\32\25\uffff\1\32\6\uffff\1\32\2\uffff\1\32\25\uffff\1\32",
			"\12\35\45\uffff\1\32",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"",
			"",
			"",
			"",
			"\10\37\47\uffff\1\32",
			"",
			"\12\35\45\uffff\1\32",
			"",
			"\10\37\47\uffff\1\32"
	};

	static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
	static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
	static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
	static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
	static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
	static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
	static final short[][] DFA25_transition;

	static {
		int numStates = DFA25_transitionS.length;
		DFA25_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
		}
	}

	class DFA25 extends DFA {

		public DFA25(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 25;
			this.eot = DFA25_eot;
			this.eof = DFA25_eof;
			this.min = DFA25_min;
			this.max = DFA25_max;
			this.accept = DFA25_accept;
			this.special = DFA25_special;
			this.transition = DFA25_transition;
		}

		public String getDescription() {
			return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | RULE_NAME_RULE | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_INT | RULE_INTEGER_VALUE | RULE_WS | RULE_ANY_OTHER );";
		}

		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA25_0 = input.LA(1);

				s = -1;
				if ((LA25_0 == ':')) {
					s = 1;
				}

				else if ((LA25_0 == '.')) {
					s = 2;
				}

				else if ((LA25_0 == '*')) {
					s = 3;
				}

				else if ((LA25_0 == '[')) {
					s = 4;
				}

				else if ((LA25_0 == ']')) {
					s = 5;
				}

				else if (((LA25_0 >= 'A' && LA25_0 <= 'Z') || (LA25_0 >= 'a' && LA25_0 <= 'z'))) {
					s = 6;
				}

				else if ((LA25_0 == '_')) {
					s = 7;
				}

				else if ((LA25_0 == '\'')) {
					s = 8;
				}

				else if ((LA25_0 == '\"')) {
					s = 9;
				}

				else if ((LA25_0 == '/')) {
					s = 10;
				}

				else if ((LA25_0 == '0')) {
					s = 11;
				}

				else if (((LA25_0 >= '1' && LA25_0 <= '9'))) {
					s = 12;
				}

				else if (((LA25_0 >= '\t' && LA25_0 <= '\n') || LA25_0 == '\r' || LA25_0 == ' ')) {
					s = 13;
				}

				else if (((LA25_0 >= '\u0000' && LA25_0 <= '\b') || (LA25_0 >= '\u000B' && LA25_0 <= '\f') || (LA25_0 >= '\u000E' && LA25_0 <= '\u001F') || LA25_0 == '!' || (LA25_0 >= '#' && LA25_0 <= '&') || (LA25_0 >= '(' && LA25_0 <= ')')
						|| (LA25_0 >= '+' && LA25_0 <= '-') || (LA25_0 >= ';' && LA25_0 <= '@') || LA25_0 == '\\' || LA25_0 == '^' || LA25_0 == '`' || (LA25_0 >= '{' && LA25_0 <= '\uFFFF'))) {
					s = 14;
				}

				if (s >= 0)
					return s;
				break;
			case 1:
				int LA25_8 = input.LA(1);

				s = -1;
				if (((LA25_8 >= '\u0000' && LA25_8 <= '\uFFFF'))) {
					s = 22;
				}

				else
					s = 14;

				if (s >= 0)
					return s;
				break;
			case 2:
				int LA25_9 = input.LA(1);

				s = -1;
				if (((LA25_9 >= '\u0000' && LA25_9 <= '\uFFFF'))) {
					s = 23;
				}

				else
					s = 14;

				if (s >= 0)
					return s;
				break;
			}
			NoViableAltException nvae = new NoViableAltException(getDescription(), 25, _s, input);
			error(nvae);
			throw nvae;
		}
	}


}