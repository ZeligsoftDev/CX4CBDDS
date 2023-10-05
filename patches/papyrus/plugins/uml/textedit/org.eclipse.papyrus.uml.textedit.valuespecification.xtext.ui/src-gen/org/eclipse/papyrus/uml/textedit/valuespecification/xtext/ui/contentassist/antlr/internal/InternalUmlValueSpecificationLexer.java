package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui.contentassist.antlr.internal;

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
public class InternalUmlValueSpecificationLexer extends Lexer {
	public static final int RULE_VALUE_SPECIFICATION_NEGATIVE_INT = 5;
	public static final int RULE_STRING = 9;
	public static final int RULE_VALUE_SPECIFICATION_DOUBLE = 8;
	public static final int RULE_VALUE_SPECIFICATION_ID = 6;
	public static final int RULE_SL_COMMENT = 11;
	public static final int T__19 = 19;
	public static final int T__15 = 15;
	public static final int T__16 = 16;
	public static final int T__17 = 17;
	public static final int T__18 = 18;
	public static final int T__14 = 14;
	public static final int EOF = -1;
	public static final int RULE_ID = 7;
	public static final int RULE_WS = 12;
	public static final int RULE_ANY_OTHER = 13;
	public static final int RULE_INT = 4;
	public static final int T__22 = 22;
	public static final int RULE_ML_COMMENT = 10;
	public static final int T__20 = 20;
	public static final int T__21 = 21;

	// delegates
	// delegators

	public InternalUmlValueSpecificationLexer() {
		;
	}

	public InternalUmlValueSpecificationLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalUmlValueSpecificationLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);

	}

	public String getGrammarFileName() {
		return "InternalUmlValueSpecification.g";
	}

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlValueSpecification.g:11:7: ( 'true' )
			// InternalUmlValueSpecification.g:11:9: 'true'
			{
				match("true");


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
			// InternalUmlValueSpecification.g:12:7: ( 'false' )
			// InternalUmlValueSpecification.g:12:9: 'false'
			{
				match("false");


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
			// InternalUmlValueSpecification.g:13:7: ( '*' )
			// InternalUmlValueSpecification.g:13:9: '*'
			{
				match('*');

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
			// InternalUmlValueSpecification.g:14:7: ( 'null' )
			// InternalUmlValueSpecification.g:14:9: 'null'
			{
				match("null");


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
			// InternalUmlValueSpecification.g:15:7: ( '<Undefined>' )
			// InternalUmlValueSpecification.g:15:9: '<Undefined>'
			{
				match("<Undefined>");


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
			// InternalUmlValueSpecification.g:16:7: ( '+' )
			// InternalUmlValueSpecification.g:16:9: '+'
			{
				match('+');

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
			// InternalUmlValueSpecification.g:17:7: ( '-' )
			// InternalUmlValueSpecification.g:17:9: '-'
			{
				match('-');

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
			// InternalUmlValueSpecification.g:18:7: ( '#' )
			// InternalUmlValueSpecification.g:18:9: '#'
			{
				match('#');

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
			// InternalUmlValueSpecification.g:19:7: ( '~' )
			// InternalUmlValueSpecification.g:19:9: '~'
			{
				match('~');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "RULE_VALUE_SPECIFICATION_ID"
	public final void mRULE_VALUE_SPECIFICATION_ID() throws RecognitionException {
		try {
			int _type = RULE_VALUE_SPECIFICATION_ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlValueSpecification.g:855:29: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )* '=' )
			// InternalUmlValueSpecification.g:855:31: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )* '='
			{
				if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

				// InternalUmlValueSpecification.g:855:55: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )*
				loop1: do {
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if ((LA1_0 == '-' || (LA1_0 >= '0' && LA1_0 <= '9') || (LA1_0 >= 'A' && LA1_0 <= 'Z') || LA1_0 == '_' || (LA1_0 >= 'a' && LA1_0 <= 'z'))) {
						alt1 = 1;
					}


					switch (alt1) {
					case 1:
					// InternalUmlValueSpecification.g:
					{
						if (input.LA(1) == '-' || (input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
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

				match('=');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_VALUE_SPECIFICATION_ID"

	// $ANTLR start "RULE_VALUE_SPECIFICATION_NEGATIVE_INT"
	public final void mRULE_VALUE_SPECIFICATION_NEGATIVE_INT() throws RecognitionException {
		try {
			int _type = RULE_VALUE_SPECIFICATION_NEGATIVE_INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlValueSpecification.g:857:39: ( '-' RULE_INT )
			// InternalUmlValueSpecification.g:857:41: '-' RULE_INT
			{
				match('-');
				mRULE_INT();

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_VALUE_SPECIFICATION_NEGATIVE_INT"

	// $ANTLR start "RULE_VALUE_SPECIFICATION_DOUBLE"
	public final void mRULE_VALUE_SPECIFICATION_DOUBLE() throws RecognitionException {
		try {
			int _type = RULE_VALUE_SPECIFICATION_DOUBLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlValueSpecification.g:859:33: ( ( '-' )? ( RULE_INT ( '.' | ',' ) RULE_INT | RULE_INT ( '.' | ',' ) | ( '.' | ',' ) RULE_INT ) )
			// InternalUmlValueSpecification.g:859:35: ( '-' )? ( RULE_INT ( '.' | ',' ) RULE_INT | RULE_INT ( '.' | ',' ) | ( '.' | ',' ) RULE_INT )
			{
				// InternalUmlValueSpecification.g:859:35: ( '-' )?
				int alt2 = 2;
				int LA2_0 = input.LA(1);

				if ((LA2_0 == '-')) {
					alt2 = 1;
				}
				switch (alt2) {
				case 1:
				// InternalUmlValueSpecification.g:859:35: '-'
				{
					match('-');

				}
					break;

				}

				// InternalUmlValueSpecification.g:859:40: ( RULE_INT ( '.' | ',' ) RULE_INT | RULE_INT ( '.' | ',' ) | ( '.' | ',' ) RULE_INT )
				int alt3 = 3;
				alt3 = dfa3.predict(input);
				switch (alt3) {
				case 1:
				// InternalUmlValueSpecification.g:859:41: RULE_INT ( '.' | ',' ) RULE_INT
				{
					mRULE_INT();
					if (input.LA(1) == ',' || input.LA(1) == '.') {
						input.consume();

					} else {
						MismatchedSetException mse = new MismatchedSetException(null, input);
						recover(mse);
						throw mse;
					}

					mRULE_INT();

				}
					break;
				case 2:
				// InternalUmlValueSpecification.g:859:69: RULE_INT ( '.' | ',' )
				{
					mRULE_INT();
					if (input.LA(1) == ',' || input.LA(1) == '.') {
						input.consume();

					} else {
						MismatchedSetException mse = new MismatchedSetException(null, input);
						recover(mse);
						throw mse;
					}


				}
					break;
				case 3:
				// InternalUmlValueSpecification.g:859:88: ( '.' | ',' ) RULE_INT
				{
					if (input.LA(1) == ',' || input.LA(1) == '.') {
						input.consume();

					} else {
						MismatchedSetException mse = new MismatchedSetException(null, input);
						recover(mse);
						throw mse;
					}

					mRULE_INT();

				}
					break;

				}


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_VALUE_SPECIFICATION_DOUBLE"

	// $ANTLR start "RULE_ID"
	public final void mRULE_ID() throws RecognitionException {
		try {
			int _type = RULE_ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlValueSpecification.g:861:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
			// InternalUmlValueSpecification.g:861:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			{
				// InternalUmlValueSpecification.g:861:11: ( '^' )?
				int alt4 = 2;
				int LA4_0 = input.LA(1);

				if ((LA4_0 == '^')) {
					alt4 = 1;
				}
				switch (alt4) {
				case 1:
				// InternalUmlValueSpecification.g:861:11: '^'
				{
					match('^');

				}
					break;

				}

				if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

				// InternalUmlValueSpecification.g:861:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
				loop5: do {
					int alt5 = 2;
					int LA5_0 = input.LA(1);

					if (((LA5_0 >= '0' && LA5_0 <= '9') || (LA5_0 >= 'A' && LA5_0 <= 'Z') || LA5_0 == '_' || (LA5_0 >= 'a' && LA5_0 <= 'z'))) {
						alt5 = 1;
					}


					switch (alt5) {
					case 1:
					// InternalUmlValueSpecification.g:
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
						break loop5;
					}
				} while (true);


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_ID"

	// $ANTLR start "RULE_INT"
	public final void mRULE_INT() throws RecognitionException {
		try {
			int _type = RULE_INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlValueSpecification.g:863:10: ( ( '0' .. '9' )+ )
			// InternalUmlValueSpecification.g:863:12: ( '0' .. '9' )+
			{
				// InternalUmlValueSpecification.g:863:12: ( '0' .. '9' )+
				int cnt6 = 0;
				loop6: do {
					int alt6 = 2;
					int LA6_0 = input.LA(1);

					if (((LA6_0 >= '0' && LA6_0 <= '9'))) {
						alt6 = 1;
					}


					switch (alt6) {
					case 1:
					// InternalUmlValueSpecification.g:863:13: '0' .. '9'
					{
						matchRange('0', '9');

					}
						break;

					default:
						if (cnt6 >= 1)
							break loop6;
						EarlyExitException eee = new EarlyExitException(6, input);
						throw eee;
					}
					cnt6++;
				} while (true);


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_INT"

	// $ANTLR start "RULE_STRING"
	public final void mRULE_STRING() throws RecognitionException {
		try {
			int _type = RULE_STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlValueSpecification.g:865:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
			// InternalUmlValueSpecification.g:865:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
			{
				// InternalUmlValueSpecification.g:865:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
				int alt9 = 2;
				int LA9_0 = input.LA(1);

				if ((LA9_0 == '\"')) {
					alt9 = 1;
				} else if ((LA9_0 == '\'')) {
					alt9 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 9, 0, input);

					throw nvae;
				}
				switch (alt9) {
				case 1:
				// InternalUmlValueSpecification.g:865:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
				{
					match('\"');
					// InternalUmlValueSpecification.g:865:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
					loop7: do {
						int alt7 = 3;
						int LA7_0 = input.LA(1);

						if ((LA7_0 == '\\')) {
							alt7 = 1;
						} else if (((LA7_0 >= '\u0000' && LA7_0 <= '!') || (LA7_0 >= '#' && LA7_0 <= '[') || (LA7_0 >= ']' && LA7_0 <= '\uFFFF'))) {
							alt7 = 2;
						}


						switch (alt7) {
						case 1:
						// InternalUmlValueSpecification.g:865:21: '\\\\' .
						{
							match('\\');
							matchAny();

						}
							break;
						case 2:
						// InternalUmlValueSpecification.g:865:28: ~ ( ( '\\\\' | '\"' ) )
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
							break loop7;
						}
					} while (true);

					match('\"');

				}
					break;
				case 2:
				// InternalUmlValueSpecification.g:865:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
				{
					match('\'');
					// InternalUmlValueSpecification.g:865:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
					loop8: do {
						int alt8 = 3;
						int LA8_0 = input.LA(1);

						if ((LA8_0 == '\\')) {
							alt8 = 1;
						} else if (((LA8_0 >= '\u0000' && LA8_0 <= '&') || (LA8_0 >= '(' && LA8_0 <= '[') || (LA8_0 >= ']' && LA8_0 <= '\uFFFF'))) {
							alt8 = 2;
						}


						switch (alt8) {
						case 1:
						// InternalUmlValueSpecification.g:865:54: '\\\\' .
						{
							match('\\');
							matchAny();

						}
							break;
						case 2:
						// InternalUmlValueSpecification.g:865:61: ~ ( ( '\\\\' | '\\'' ) )
						{
							if ((input.LA(1) >= '\u0000' && input.LA(1) <= '&') || (input.LA(1) >= '(' && input.LA(1) <= '[') || (input.LA(1) >= ']' && input.LA(1) <= '\uFFFF')) {
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
	// $ANTLR end "RULE_STRING"

	// $ANTLR start "RULE_ML_COMMENT"
	public final void mRULE_ML_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_ML_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlValueSpecification.g:867:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// InternalUmlValueSpecification.g:867:19: '/*' ( options {greedy=false; } : . )* '*/'
			{
				match("/*");

				// InternalUmlValueSpecification.g:867:24: ( options {greedy=false; } : . )*
				loop10: do {
					int alt10 = 2;
					int LA10_0 = input.LA(1);

					if ((LA10_0 == '*')) {
						int LA10_1 = input.LA(2);

						if ((LA10_1 == '/')) {
							alt10 = 2;
						} else if (((LA10_1 >= '\u0000' && LA10_1 <= '.') || (LA10_1 >= '0' && LA10_1 <= '\uFFFF'))) {
							alt10 = 1;
						}


					} else if (((LA10_0 >= '\u0000' && LA10_0 <= ')') || (LA10_0 >= '+' && LA10_0 <= '\uFFFF'))) {
						alt10 = 1;
					}


					switch (alt10) {
					case 1:
					// InternalUmlValueSpecification.g:867:52: .
					{
						matchAny();

					}
						break;

					default:
						break loop10;
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
			// InternalUmlValueSpecification.g:869:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
			// InternalUmlValueSpecification.g:869:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
			{
				match("//");

				// InternalUmlValueSpecification.g:869:24: (~ ( ( '\\n' | '\\r' ) ) )*
				loop11: do {
					int alt11 = 2;
					int LA11_0 = input.LA(1);

					if (((LA11_0 >= '\u0000' && LA11_0 <= '\t') || (LA11_0 >= '\u000B' && LA11_0 <= '\f') || (LA11_0 >= '\u000E' && LA11_0 <= '\uFFFF'))) {
						alt11 = 1;
					}


					switch (alt11) {
					case 1:
					// InternalUmlValueSpecification.g:869:24: ~ ( ( '\\n' | '\\r' ) )
					{
						if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t') || (input.LA(1) >= '\u000B' && input.LA(1) <= '\f') || (input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF')) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}


					}
						break;

					default:
						break loop11;
					}
				} while (true);

				// InternalUmlValueSpecification.g:869:40: ( ( '\\r' )? '\\n' )?
				int alt13 = 2;
				int LA13_0 = input.LA(1);

				if ((LA13_0 == '\n' || LA13_0 == '\r')) {
					alt13 = 1;
				}
				switch (alt13) {
				case 1:
				// InternalUmlValueSpecification.g:869:41: ( '\\r' )? '\\n'
				{
					// InternalUmlValueSpecification.g:869:41: ( '\\r' )?
					int alt12 = 2;
					int LA12_0 = input.LA(1);

					if ((LA12_0 == '\r')) {
						alt12 = 1;
					}
					switch (alt12) {
					case 1:
					// InternalUmlValueSpecification.g:869:41: '\\r'
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

	// $ANTLR start "RULE_WS"
	public final void mRULE_WS() throws RecognitionException {
		try {
			int _type = RULE_WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalUmlValueSpecification.g:871:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// InternalUmlValueSpecification.g:871:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
				// InternalUmlValueSpecification.g:871:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
				int cnt14 = 0;
				loop14: do {
					int alt14 = 2;
					int LA14_0 = input.LA(1);

					if (((LA14_0 >= '\t' && LA14_0 <= '\n') || LA14_0 == '\r' || LA14_0 == ' ')) {
						alt14 = 1;
					}


					switch (alt14) {
					case 1:
					// InternalUmlValueSpecification.g:
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
						if (cnt14 >= 1)
							break loop14;
						EarlyExitException eee = new EarlyExitException(14, input);
						throw eee;
					}
					cnt14++;
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
			// InternalUmlValueSpecification.g:873:16: ( . )
			// InternalUmlValueSpecification.g:873:18: .
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
		// InternalUmlValueSpecification.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | RULE_VALUE_SPECIFICATION_ID | RULE_VALUE_SPECIFICATION_NEGATIVE_INT | RULE_VALUE_SPECIFICATION_DOUBLE | RULE_ID | RULE_INT | RULE_STRING |
		// RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
		int alt15 = 19;
		alt15 = dfa15.predict(input);
		switch (alt15) {
		case 1:
		// InternalUmlValueSpecification.g:1:10: T__14
		{
			mT__14();

		}
			break;
		case 2:
		// InternalUmlValueSpecification.g:1:16: T__15
		{
			mT__15();

		}
			break;
		case 3:
		// InternalUmlValueSpecification.g:1:22: T__16
		{
			mT__16();

		}
			break;
		case 4:
		// InternalUmlValueSpecification.g:1:28: T__17
		{
			mT__17();

		}
			break;
		case 5:
		// InternalUmlValueSpecification.g:1:34: T__18
		{
			mT__18();

		}
			break;
		case 6:
		// InternalUmlValueSpecification.g:1:40: T__19
		{
			mT__19();

		}
			break;
		case 7:
		// InternalUmlValueSpecification.g:1:46: T__20
		{
			mT__20();

		}
			break;
		case 8:
		// InternalUmlValueSpecification.g:1:52: T__21
		{
			mT__21();

		}
			break;
		case 9:
		// InternalUmlValueSpecification.g:1:58: T__22
		{
			mT__22();

		}
			break;
		case 10:
		// InternalUmlValueSpecification.g:1:64: RULE_VALUE_SPECIFICATION_ID
		{
			mRULE_VALUE_SPECIFICATION_ID();

		}
			break;
		case 11:
		// InternalUmlValueSpecification.g:1:92: RULE_VALUE_SPECIFICATION_NEGATIVE_INT
		{
			mRULE_VALUE_SPECIFICATION_NEGATIVE_INT();

		}
			break;
		case 12:
		// InternalUmlValueSpecification.g:1:130: RULE_VALUE_SPECIFICATION_DOUBLE
		{
			mRULE_VALUE_SPECIFICATION_DOUBLE();

		}
			break;
		case 13:
		// InternalUmlValueSpecification.g:1:162: RULE_ID
		{
			mRULE_ID();

		}
			break;
		case 14:
		// InternalUmlValueSpecification.g:1:170: RULE_INT
		{
			mRULE_INT();

		}
			break;
		case 15:
		// InternalUmlValueSpecification.g:1:179: RULE_STRING
		{
			mRULE_STRING();

		}
			break;
		case 16:
		// InternalUmlValueSpecification.g:1:191: RULE_ML_COMMENT
		{
			mRULE_ML_COMMENT();

		}
			break;
		case 17:
		// InternalUmlValueSpecification.g:1:207: RULE_SL_COMMENT
		{
			mRULE_SL_COMMENT();

		}
			break;
		case 18:
		// InternalUmlValueSpecification.g:1:223: RULE_WS
		{
			mRULE_WS();

		}
			break;
		case 19:
		// InternalUmlValueSpecification.g:1:231: RULE_ANY_OTHER
		{
			mRULE_ANY_OTHER();

		}
			break;

		}

	}


	protected DFA3 dfa3 = new DFA3(this);
	protected DFA15 dfa15 = new DFA15(this);
	static final String DFA3_eotS = "\3\uffff\1\5\2\uffff";
	static final String DFA3_eofS = "\6\uffff";
	static final String DFA3_minS = "\2\54\1\uffff\1\60\2\uffff";
	static final String DFA3_maxS = "\2\71\1\uffff\1\71\2\uffff";
	static final String DFA3_acceptS = "\2\uffff\1\3\1\uffff\1\1\1\2";
	static final String DFA3_specialS = "\6\uffff}>";
	static final String[] DFA3_transitionS = {
			"\1\2\1\uffff\1\2\1\uffff\12\1",
			"\1\3\1\uffff\1\3\1\uffff\12\1",
			"",
			"\12\4",
			"",
			""
	};

	static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
	static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
	static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
	static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
	static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
	static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
	static final short[][] DFA3_transition;

	static {
		int numStates = DFA3_transitionS.length;
		DFA3_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
		}
	}

	class DFA3 extends DFA {

		public DFA3(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 3;
			this.eot = DFA3_eot;
			this.eof = DFA3_eof;
			this.min = DFA3_min;
			this.max = DFA3_max;
			this.accept = DFA3_accept;
			this.special = DFA3_special;
			this.transition = DFA3_transition;
		}

		public String getDescription() {
			return "859:40: ( RULE_INT ( '.' | ',' ) RULE_INT | RULE_INT ( '.' | ',' ) | ( '.' | ',' ) RULE_INT )";
		}
	}

	static final String DFA15_eotS = "\1\uffff\2\26\1\uffff\1\26\1\22\1\uffff\1\36\2\uffff\1\26\1\41\5\22\2\uffff\2\26\2\uffff\1\26\1\uffff\1\26\2\uffff\1\52\5\uffff\1\41\4\uffff\3\26\1\uffff\1\56\1\26\1\60\1\uffff\1\61\2\uffff";
	static final String DFA15_eofS = "\62\uffff";
	static final String DFA15_minS = "\1\0\2\55\1\uffff\1\55\1\125\1\uffff\1\54\2\uffff\1\55\1\54\1\60\1\101\2\0\1\52\2\uffff\2\55\2\uffff\1\55\1\uffff\1\55\2\uffff\1\54\5\uffff\1\54\4\uffff\3\55\1\uffff\3\55\1\uffff\1\55\2\uffff";
	static final String DFA15_maxS = "\1\uffff\2\172\1\uffff\1\172\1\125\1\uffff\1\71\2\uffff\1\172\2\71\1\172\2\uffff\1\57\2\uffff\2\172\2\uffff\1\172\1\uffff\1\172\2\uffff\1\71\5\uffff\1\71\4\uffff\3\172\1\uffff\3\172\1\uffff\1\172\2\uffff";
	static final String DFA15_acceptS = "\3\uffff\1\3\2\uffff\1\6\1\uffff\1\10\1\11\7\uffff\1\22\1\23\2\uffff\1\12\1\15\1\uffff\1\3\1\uffff\1\5\1\6\1\uffff\1\14\1\7\1\10\1\11\1\16\1\uffff\1\17\1\20\1\21\1\22\3\uffff\1\13\3\uffff\1\1\1\uffff\1\4\1\2";
	static final String DFA15_specialS = "\1\2\15\uffff\1\0\1\1\42\uffff}>";
	static final String[] DFA15_transitionS = {
			"\11\22\2\21\2\22\1\21\22\22\1\21\1\22\1\16\1\10\3\22\1\17\2\22\1\3\1\6\1\14\1\7\1\14\1\20\12\13\2\22\1\5\4\22\32\12\3\22\1\15\1\12\1\22\5\12\1\2\7\12\1\4\5\12\1\1\6\12\3\22\1\11\uff81\22",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\21\24\1\23\10\24",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\1\27\31\24",
			"",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\24\24\1\31\5\24",
			"\1\32",
			"",
			"\1\35\1\uffff\1\35\1\uffff\12\34",
			"",
			"",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"\1\35\1\uffff\1\35\1\uffff\12\42",
			"\12\35",
			"\32\26\4\uffff\1\26\1\uffff\32\26",
			"\0\43",
			"\0\43",
			"\1\44\4\uffff\1\45",
			"",
			"",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\24\24\1\47\5\24",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"",
			"",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\13\24\1\50\16\24",
			"",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\13\24\1\51\16\24",
			"",
			"",
			"\1\35\1\uffff\1\35\1\uffff\12\34",
			"",
			"",
			"",
			"",
			"",
			"\1\35\1\uffff\1\35\1\uffff\12\42",
			"",
			"",
			"",
			"",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\4\24\1\53\25\24",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\22\24\1\54\7\24",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\13\24\1\55\16\24",
			"",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\4\24\1\57\25\24",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"",
			"\1\25\2\uffff\12\24\3\uffff\1\25\3\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"",
			""
	};

	static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
	static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
	static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
	static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
	static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
	static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
	static final short[][] DFA15_transition;

	static {
		int numStates = DFA15_transitionS.length;
		DFA15_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
		}
	}

	class DFA15 extends DFA {

		public DFA15(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 15;
			this.eot = DFA15_eot;
			this.eof = DFA15_eof;
			this.min = DFA15_min;
			this.max = DFA15_max;
			this.accept = DFA15_accept;
			this.special = DFA15_special;
			this.transition = DFA15_transition;
		}

		public String getDescription() {
			return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | RULE_VALUE_SPECIFICATION_ID | RULE_VALUE_SPECIFICATION_NEGATIVE_INT | RULE_VALUE_SPECIFICATION_DOUBLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
		}

		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA15_14 = input.LA(1);

				s = -1;
				if (((LA15_14 >= '\u0000' && LA15_14 <= '\uFFFF'))) {
					s = 35;
				}

				else
					s = 18;

				if (s >= 0)
					return s;
				break;
			case 1:
				int LA15_15 = input.LA(1);

				s = -1;
				if (((LA15_15 >= '\u0000' && LA15_15 <= '\uFFFF'))) {
					s = 35;
				}

				else
					s = 18;

				if (s >= 0)
					return s;
				break;
			case 2:
				int LA15_0 = input.LA(1);

				s = -1;
				if ((LA15_0 == 't')) {
					s = 1;
				}

				else if ((LA15_0 == 'f')) {
					s = 2;
				}

				else if ((LA15_0 == '*')) {
					s = 3;
				}

				else if ((LA15_0 == 'n')) {
					s = 4;
				}

				else if ((LA15_0 == '<')) {
					s = 5;
				}

				else if ((LA15_0 == '+')) {
					s = 6;
				}

				else if ((LA15_0 == '-')) {
					s = 7;
				}

				else if ((LA15_0 == '#')) {
					s = 8;
				}

				else if ((LA15_0 == '~')) {
					s = 9;
				}

				else if (((LA15_0 >= 'A' && LA15_0 <= 'Z') || LA15_0 == '_' || (LA15_0 >= 'a' && LA15_0 <= 'e') || (LA15_0 >= 'g' && LA15_0 <= 'm') || (LA15_0 >= 'o' && LA15_0 <= 's') || (LA15_0 >= 'u' && LA15_0 <= 'z'))) {
					s = 10;
				}

				else if (((LA15_0 >= '0' && LA15_0 <= '9'))) {
					s = 11;
				}

				else if ((LA15_0 == ',' || LA15_0 == '.')) {
					s = 12;
				}

				else if ((LA15_0 == '^')) {
					s = 13;
				}

				else if ((LA15_0 == '\"')) {
					s = 14;
				}

				else if ((LA15_0 == '\'')) {
					s = 15;
				}

				else if ((LA15_0 == '/')) {
					s = 16;
				}

				else if (((LA15_0 >= '\t' && LA15_0 <= '\n') || LA15_0 == '\r' || LA15_0 == ' ')) {
					s = 17;
				}

				else if (((LA15_0 >= '\u0000' && LA15_0 <= '\b') || (LA15_0 >= '\u000B' && LA15_0 <= '\f') || (LA15_0 >= '\u000E' && LA15_0 <= '\u001F') || LA15_0 == '!' || (LA15_0 >= '$' && LA15_0 <= '&') || (LA15_0 >= '(' && LA15_0 <= ')')
						|| (LA15_0 >= ':' && LA15_0 <= ';') || (LA15_0 >= '=' && LA15_0 <= '@') || (LA15_0 >= '[' && LA15_0 <= ']') || LA15_0 == '`' || (LA15_0 >= '{' && LA15_0 <= '}') || (LA15_0 >= '\u007F' && LA15_0 <= '\uFFFF'))) {
					s = 18;
				}

				if (s >= 0)
					return s;
				break;
			}
			NoViableAltException nvae = new NoViableAltException(getDescription(), 15, _s, input);
			error(nvae);
			throw nvae;
		}
	}


}