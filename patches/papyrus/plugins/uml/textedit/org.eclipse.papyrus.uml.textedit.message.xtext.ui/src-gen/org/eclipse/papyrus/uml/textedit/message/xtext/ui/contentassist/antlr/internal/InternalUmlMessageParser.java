package org.eclipse.papyrus.uml.textedit.message.xtext.ui.contentassist.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;
import org.eclipse.papyrus.uml.textedit.message.xtext.services.UmlMessageGrammarAccess;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

@SuppressWarnings("all")
public class InternalUmlMessageParser extends AbstractInternalContentAssistParser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_NAME_RULE", "RULE_INT", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INTEGER_VALUE", "RULE_WS", "RULE_ANY_OTHER", "':'", "'.'", "'*'", "'['", "']'"
	};
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


	public InternalUmlMessageParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalUmlMessageParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);

	}


	public String[] getTokenNames() {
		return InternalUmlMessageParser.tokenNames;
	}

	public String getGrammarFileName() {
		return "../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g";
	}



	private UmlMessageGrammarAccess grammarAccess;

	public void setGrammarAccess(UmlMessageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}




	// $ANTLR start "entryRuleMessageRule"
	// InternalUmlMessage.g:60:1: entryRuleMessageRule : ruleMessageRule EOF ;
	public final void entryRuleMessageRule() throws RecognitionException {
		try {
			// InternalUmlMessage.g:61:1: ( ruleMessageRule EOF )
			// InternalUmlMessage.g:62:1: ruleMessageRule EOF
			{
				before(grammarAccess.getMessageRuleRule());
				pushFollow(FOLLOW_1);
				ruleMessageRule();

				state._fsp--;

				after(grammarAccess.getMessageRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleMessageRule"


	// $ANTLR start "ruleMessageRule"
	// InternalUmlMessage.g:69:1: ruleMessageRule : ( ( rule__MessageRule__Group__0 ) ) ;
	public final void ruleMessageRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:73:2: ( ( ( rule__MessageRule__Group__0 ) ) )
			// InternalUmlMessage.g:74:1: ( ( rule__MessageRule__Group__0 ) )
			{
				// InternalUmlMessage.g:74:1: ( ( rule__MessageRule__Group__0 ) )
				// InternalUmlMessage.g:75:1: ( rule__MessageRule__Group__0 )
				{
					before(grammarAccess.getMessageRuleAccess().getGroup());
					// InternalUmlMessage.g:76:1: ( rule__MessageRule__Group__0 )
					// InternalUmlMessage.g:76:2: rule__MessageRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__MessageRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getMessageRuleAccess().getGroup());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleMessageRule"


	// $ANTLR start "entryRuleSequenceTermRule"
	// InternalUmlMessage.g:88:1: entryRuleSequenceTermRule : ruleSequenceTermRule EOF ;
	public final void entryRuleSequenceTermRule() throws RecognitionException {
		try {
			// InternalUmlMessage.g:89:1: ( ruleSequenceTermRule EOF )
			// InternalUmlMessage.g:90:1: ruleSequenceTermRule EOF
			{
				before(grammarAccess.getSequenceTermRuleRule());
				pushFollow(FOLLOW_1);
				ruleSequenceTermRule();

				state._fsp--;

				after(grammarAccess.getSequenceTermRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleSequenceTermRule"


	// $ANTLR start "ruleSequenceTermRule"
	// InternalUmlMessage.g:97:1: ruleSequenceTermRule : ( ( rule__SequenceTermRule__Group__0 ) ) ;
	public final void ruleSequenceTermRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:101:2: ( ( ( rule__SequenceTermRule__Group__0 ) ) )
			// InternalUmlMessage.g:102:1: ( ( rule__SequenceTermRule__Group__0 ) )
			{
				// InternalUmlMessage.g:102:1: ( ( rule__SequenceTermRule__Group__0 ) )
				// InternalUmlMessage.g:103:1: ( rule__SequenceTermRule__Group__0 )
				{
					before(grammarAccess.getSequenceTermRuleAccess().getGroup());
					// InternalUmlMessage.g:104:1: ( rule__SequenceTermRule__Group__0 )
					// InternalUmlMessage.g:104:2: rule__SequenceTermRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__SequenceTermRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getSequenceTermRuleAccess().getGroup());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleSequenceTermRule"


	// $ANTLR start "entryRuleRecurrenceRule"
	// InternalUmlMessage.g:116:1: entryRuleRecurrenceRule : ruleRecurrenceRule EOF ;
	public final void entryRuleRecurrenceRule() throws RecognitionException {
		try {
			// InternalUmlMessage.g:117:1: ( ruleRecurrenceRule EOF )
			// InternalUmlMessage.g:118:1: ruleRecurrenceRule EOF
			{
				before(grammarAccess.getRecurrenceRuleRule());
				pushFollow(FOLLOW_1);
				ruleRecurrenceRule();

				state._fsp--;

				after(grammarAccess.getRecurrenceRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleRecurrenceRule"


	// $ANTLR start "ruleRecurrenceRule"
	// InternalUmlMessage.g:125:1: ruleRecurrenceRule : ( ( rule__RecurrenceRule__Alternatives ) ) ;
	public final void ruleRecurrenceRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:129:2: ( ( ( rule__RecurrenceRule__Alternatives ) ) )
			// InternalUmlMessage.g:130:1: ( ( rule__RecurrenceRule__Alternatives ) )
			{
				// InternalUmlMessage.g:130:1: ( ( rule__RecurrenceRule__Alternatives ) )
				// InternalUmlMessage.g:131:1: ( rule__RecurrenceRule__Alternatives )
				{
					before(grammarAccess.getRecurrenceRuleAccess().getAlternatives());
					// InternalUmlMessage.g:132:1: ( rule__RecurrenceRule__Alternatives )
					// InternalUmlMessage.g:132:2: rule__RecurrenceRule__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__RecurrenceRule__Alternatives();

						state._fsp--;


					}

					after(grammarAccess.getRecurrenceRuleAccess().getAlternatives());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleRecurrenceRule"


	// $ANTLR start "rule__RecurrenceRule__Alternatives"
	// InternalUmlMessage.g:144:1: rule__RecurrenceRule__Alternatives : ( ( ( rule__RecurrenceRule__Group_0__0 ) ) | ( ( rule__RecurrenceRule__Group_1__0 ) ) );
	public final void rule__RecurrenceRule__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:148:1: ( ( ( rule__RecurrenceRule__Group_0__0 ) ) | ( ( rule__RecurrenceRule__Group_1__0 ) ) )
			int alt1 = 2;
			int LA1_0 = input.LA(1);

			if ((LA1_0 == 15)) {
				alt1 = 1;
			} else if ((LA1_0 == 16)) {
				alt1 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 1, 0, input);

				throw nvae;
			}
			switch (alt1) {
			case 1:
			// InternalUmlMessage.g:149:1: ( ( rule__RecurrenceRule__Group_0__0 ) )
			{
				// InternalUmlMessage.g:149:1: ( ( rule__RecurrenceRule__Group_0__0 ) )
				// InternalUmlMessage.g:150:1: ( rule__RecurrenceRule__Group_0__0 )
				{
					before(grammarAccess.getRecurrenceRuleAccess().getGroup_0());
					// InternalUmlMessage.g:151:1: ( rule__RecurrenceRule__Group_0__0 )
					// InternalUmlMessage.g:151:2: rule__RecurrenceRule__Group_0__0
					{
						pushFollow(FOLLOW_2);
						rule__RecurrenceRule__Group_0__0();

						state._fsp--;


					}

					after(grammarAccess.getRecurrenceRuleAccess().getGroup_0());

				}


			}
				break;
			case 2:
			// InternalUmlMessage.g:155:6: ( ( rule__RecurrenceRule__Group_1__0 ) )
			{
				// InternalUmlMessage.g:155:6: ( ( rule__RecurrenceRule__Group_1__0 ) )
				// InternalUmlMessage.g:156:1: ( rule__RecurrenceRule__Group_1__0 )
				{
					before(grammarAccess.getRecurrenceRuleAccess().getGroup_1());
					// InternalUmlMessage.g:157:1: ( rule__RecurrenceRule__Group_1__0 )
					// InternalUmlMessage.g:157:2: rule__RecurrenceRule__Group_1__0
					{
						pushFollow(FOLLOW_2);
						rule__RecurrenceRule__Group_1__0();

						state._fsp--;


					}

					after(grammarAccess.getRecurrenceRuleAccess().getGroup_1());

				}


			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Alternatives"


	// $ANTLR start "rule__MessageRule__Group__0"
	// InternalUmlMessage.g:168:1: rule__MessageRule__Group__0 : rule__MessageRule__Group__0__Impl rule__MessageRule__Group__1 ;
	public final void rule__MessageRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:172:1: ( rule__MessageRule__Group__0__Impl rule__MessageRule__Group__1 )
			// InternalUmlMessage.g:173:2: rule__MessageRule__Group__0__Impl rule__MessageRule__Group__1
			{
				pushFollow(FOLLOW_3);
				rule__MessageRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__MessageRule__Group__1();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__Group__0"


	// $ANTLR start "rule__MessageRule__Group__0__Impl"
	// InternalUmlMessage.g:180:1: rule__MessageRule__Group__0__Impl : ( ( rule__MessageRule__SequenceTermAssignment_0 ) ) ;
	public final void rule__MessageRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:184:1: ( ( ( rule__MessageRule__SequenceTermAssignment_0 ) ) )
			// InternalUmlMessage.g:185:1: ( ( rule__MessageRule__SequenceTermAssignment_0 ) )
			{
				// InternalUmlMessage.g:185:1: ( ( rule__MessageRule__SequenceTermAssignment_0 ) )
				// InternalUmlMessage.g:186:1: ( rule__MessageRule__SequenceTermAssignment_0 )
				{
					before(grammarAccess.getMessageRuleAccess().getSequenceTermAssignment_0());
					// InternalUmlMessage.g:187:1: ( rule__MessageRule__SequenceTermAssignment_0 )
					// InternalUmlMessage.g:187:2: rule__MessageRule__SequenceTermAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__MessageRule__SequenceTermAssignment_0();

						state._fsp--;


					}

					after(grammarAccess.getMessageRuleAccess().getSequenceTermAssignment_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__Group__0__Impl"


	// $ANTLR start "rule__MessageRule__Group__1"
	// InternalUmlMessage.g:197:1: rule__MessageRule__Group__1 : rule__MessageRule__Group__1__Impl rule__MessageRule__Group__2 ;
	public final void rule__MessageRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:201:1: ( rule__MessageRule__Group__1__Impl rule__MessageRule__Group__2 )
			// InternalUmlMessage.g:202:2: rule__MessageRule__Group__1__Impl rule__MessageRule__Group__2
			{
				pushFollow(FOLLOW_3);
				rule__MessageRule__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__MessageRule__Group__2();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__Group__1"


	// $ANTLR start "rule__MessageRule__Group__1__Impl"
	// InternalUmlMessage.g:209:1: rule__MessageRule__Group__1__Impl : ( ( rule__MessageRule__Group_1__0 )* ) ;
	public final void rule__MessageRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:213:1: ( ( ( rule__MessageRule__Group_1__0 )* ) )
			// InternalUmlMessage.g:214:1: ( ( rule__MessageRule__Group_1__0 )* )
			{
				// InternalUmlMessage.g:214:1: ( ( rule__MessageRule__Group_1__0 )* )
				// InternalUmlMessage.g:215:1: ( rule__MessageRule__Group_1__0 )*
				{
					before(grammarAccess.getMessageRuleAccess().getGroup_1());
					// InternalUmlMessage.g:216:1: ( rule__MessageRule__Group_1__0 )*
					loop2: do {
						int alt2 = 2;
						int LA2_0 = input.LA(1);

						if ((LA2_0 == 14)) {
							alt2 = 1;
						}


						switch (alt2) {
						case 1:
						// InternalUmlMessage.g:216:2: rule__MessageRule__Group_1__0
						{
							pushFollow(FOLLOW_4);
							rule__MessageRule__Group_1__0();

							state._fsp--;


						}
							break;

						default:
							break loop2;
						}
					} while (true);

					after(grammarAccess.getMessageRuleAccess().getGroup_1());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__Group__1__Impl"


	// $ANTLR start "rule__MessageRule__Group__2"
	// InternalUmlMessage.g:226:1: rule__MessageRule__Group__2 : rule__MessageRule__Group__2__Impl rule__MessageRule__Group__3 ;
	public final void rule__MessageRule__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:230:1: ( rule__MessageRule__Group__2__Impl rule__MessageRule__Group__3 )
			// InternalUmlMessage.g:231:2: rule__MessageRule__Group__2__Impl rule__MessageRule__Group__3
			{
				pushFollow(FOLLOW_5);
				rule__MessageRule__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__MessageRule__Group__3();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__Group__2"


	// $ANTLR start "rule__MessageRule__Group__2__Impl"
	// InternalUmlMessage.g:238:1: rule__MessageRule__Group__2__Impl : ( ':' ) ;
	public final void rule__MessageRule__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:242:1: ( ( ':' ) )
			// InternalUmlMessage.g:243:1: ( ':' )
			{
				// InternalUmlMessage.g:243:1: ( ':' )
				// InternalUmlMessage.g:244:1: ':'
				{
					before(grammarAccess.getMessageRuleAccess().getColonKeyword_2());
					match(input, 13, FOLLOW_2);
					after(grammarAccess.getMessageRuleAccess().getColonKeyword_2());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__Group__2__Impl"


	// $ANTLR start "rule__MessageRule__Group__3"
	// InternalUmlMessage.g:257:1: rule__MessageRule__Group__3 : rule__MessageRule__Group__3__Impl ;
	public final void rule__MessageRule__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:261:1: ( rule__MessageRule__Group__3__Impl )
			// InternalUmlMessage.g:262:2: rule__MessageRule__Group__3__Impl
			{
				pushFollow(FOLLOW_2);
				rule__MessageRule__Group__3__Impl();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__Group__3"


	// $ANTLR start "rule__MessageRule__Group__3__Impl"
	// InternalUmlMessage.g:268:1: rule__MessageRule__Group__3__Impl : ( ( rule__MessageRule__NameAssignment_3 ) ) ;
	public final void rule__MessageRule__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:272:1: ( ( ( rule__MessageRule__NameAssignment_3 ) ) )
			// InternalUmlMessage.g:273:1: ( ( rule__MessageRule__NameAssignment_3 ) )
			{
				// InternalUmlMessage.g:273:1: ( ( rule__MessageRule__NameAssignment_3 ) )
				// InternalUmlMessage.g:274:1: ( rule__MessageRule__NameAssignment_3 )
				{
					before(grammarAccess.getMessageRuleAccess().getNameAssignment_3());
					// InternalUmlMessage.g:275:1: ( rule__MessageRule__NameAssignment_3 )
					// InternalUmlMessage.g:275:2: rule__MessageRule__NameAssignment_3
					{
						pushFollow(FOLLOW_2);
						rule__MessageRule__NameAssignment_3();

						state._fsp--;


					}

					after(grammarAccess.getMessageRuleAccess().getNameAssignment_3());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__Group__3__Impl"


	// $ANTLR start "rule__MessageRule__Group_1__0"
	// InternalUmlMessage.g:293:1: rule__MessageRule__Group_1__0 : rule__MessageRule__Group_1__0__Impl rule__MessageRule__Group_1__1 ;
	public final void rule__MessageRule__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:297:1: ( rule__MessageRule__Group_1__0__Impl rule__MessageRule__Group_1__1 )
			// InternalUmlMessage.g:298:2: rule__MessageRule__Group_1__0__Impl rule__MessageRule__Group_1__1
			{
				pushFollow(FOLLOW_6);
				rule__MessageRule__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__MessageRule__Group_1__1();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__Group_1__0"


	// $ANTLR start "rule__MessageRule__Group_1__0__Impl"
	// InternalUmlMessage.g:305:1: rule__MessageRule__Group_1__0__Impl : ( '.' ) ;
	public final void rule__MessageRule__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:309:1: ( ( '.' ) )
			// InternalUmlMessage.g:310:1: ( '.' )
			{
				// InternalUmlMessage.g:310:1: ( '.' )
				// InternalUmlMessage.g:311:1: '.'
				{
					before(grammarAccess.getMessageRuleAccess().getFullStopKeyword_1_0());
					match(input, 14, FOLLOW_2);
					after(grammarAccess.getMessageRuleAccess().getFullStopKeyword_1_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__Group_1__0__Impl"


	// $ANTLR start "rule__MessageRule__Group_1__1"
	// InternalUmlMessage.g:324:1: rule__MessageRule__Group_1__1 : rule__MessageRule__Group_1__1__Impl ;
	public final void rule__MessageRule__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:328:1: ( rule__MessageRule__Group_1__1__Impl )
			// InternalUmlMessage.g:329:2: rule__MessageRule__Group_1__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__MessageRule__Group_1__1__Impl();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__Group_1__1"


	// $ANTLR start "rule__MessageRule__Group_1__1__Impl"
	// InternalUmlMessage.g:335:1: rule__MessageRule__Group_1__1__Impl : ( ( rule__MessageRule__SequenceTermAssignment_1_1 ) ) ;
	public final void rule__MessageRule__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:339:1: ( ( ( rule__MessageRule__SequenceTermAssignment_1_1 ) ) )
			// InternalUmlMessage.g:340:1: ( ( rule__MessageRule__SequenceTermAssignment_1_1 ) )
			{
				// InternalUmlMessage.g:340:1: ( ( rule__MessageRule__SequenceTermAssignment_1_1 ) )
				// InternalUmlMessage.g:341:1: ( rule__MessageRule__SequenceTermAssignment_1_1 )
				{
					before(grammarAccess.getMessageRuleAccess().getSequenceTermAssignment_1_1());
					// InternalUmlMessage.g:342:1: ( rule__MessageRule__SequenceTermAssignment_1_1 )
					// InternalUmlMessage.g:342:2: rule__MessageRule__SequenceTermAssignment_1_1
					{
						pushFollow(FOLLOW_2);
						rule__MessageRule__SequenceTermAssignment_1_1();

						state._fsp--;


					}

					after(grammarAccess.getMessageRuleAccess().getSequenceTermAssignment_1_1());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__Group_1__1__Impl"


	// $ANTLR start "rule__SequenceTermRule__Group__0"
	// InternalUmlMessage.g:356:1: rule__SequenceTermRule__Group__0 : rule__SequenceTermRule__Group__0__Impl rule__SequenceTermRule__Group__1 ;
	public final void rule__SequenceTermRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:360:1: ( rule__SequenceTermRule__Group__0__Impl rule__SequenceTermRule__Group__1 )
			// InternalUmlMessage.g:361:2: rule__SequenceTermRule__Group__0__Impl rule__SequenceTermRule__Group__1
			{
				pushFollow(FOLLOW_7);
				rule__SequenceTermRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__SequenceTermRule__Group__1();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__SequenceTermRule__Group__0"


	// $ANTLR start "rule__SequenceTermRule__Group__0__Impl"
	// InternalUmlMessage.g:368:1: rule__SequenceTermRule__Group__0__Impl : ( ( rule__SequenceTermRule__SequencialOrderAssignment_0 ) ) ;
	public final void rule__SequenceTermRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:372:1: ( ( ( rule__SequenceTermRule__SequencialOrderAssignment_0 ) ) )
			// InternalUmlMessage.g:373:1: ( ( rule__SequenceTermRule__SequencialOrderAssignment_0 ) )
			{
				// InternalUmlMessage.g:373:1: ( ( rule__SequenceTermRule__SequencialOrderAssignment_0 ) )
				// InternalUmlMessage.g:374:1: ( rule__SequenceTermRule__SequencialOrderAssignment_0 )
				{
					before(grammarAccess.getSequenceTermRuleAccess().getSequencialOrderAssignment_0());
					// InternalUmlMessage.g:375:1: ( rule__SequenceTermRule__SequencialOrderAssignment_0 )
					// InternalUmlMessage.g:375:2: rule__SequenceTermRule__SequencialOrderAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__SequenceTermRule__SequencialOrderAssignment_0();

						state._fsp--;


					}

					after(grammarAccess.getSequenceTermRuleAccess().getSequencialOrderAssignment_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__SequenceTermRule__Group__0__Impl"


	// $ANTLR start "rule__SequenceTermRule__Group__1"
	// InternalUmlMessage.g:385:1: rule__SequenceTermRule__Group__1 : rule__SequenceTermRule__Group__1__Impl rule__SequenceTermRule__Group__2 ;
	public final void rule__SequenceTermRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:389:1: ( rule__SequenceTermRule__Group__1__Impl rule__SequenceTermRule__Group__2 )
			// InternalUmlMessage.g:390:2: rule__SequenceTermRule__Group__1__Impl rule__SequenceTermRule__Group__2
			{
				pushFollow(FOLLOW_7);
				rule__SequenceTermRule__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__SequenceTermRule__Group__2();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__SequenceTermRule__Group__1"


	// $ANTLR start "rule__SequenceTermRule__Group__1__Impl"
	// InternalUmlMessage.g:397:1: rule__SequenceTermRule__Group__1__Impl : ( ( rule__SequenceTermRule__SequenceNameAssignment_1 )? ) ;
	public final void rule__SequenceTermRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:401:1: ( ( ( rule__SequenceTermRule__SequenceNameAssignment_1 )? ) )
			// InternalUmlMessage.g:402:1: ( ( rule__SequenceTermRule__SequenceNameAssignment_1 )? )
			{
				// InternalUmlMessage.g:402:1: ( ( rule__SequenceTermRule__SequenceNameAssignment_1 )? )
				// InternalUmlMessage.g:403:1: ( rule__SequenceTermRule__SequenceNameAssignment_1 )?
				{
					before(grammarAccess.getSequenceTermRuleAccess().getSequenceNameAssignment_1());
					// InternalUmlMessage.g:404:1: ( rule__SequenceTermRule__SequenceNameAssignment_1 )?
					int alt3 = 2;
					int LA3_0 = input.LA(1);

					if ((LA3_0 == RULE_ID)) {
						alt3 = 1;
					}
					switch (alt3) {
					case 1:
					// InternalUmlMessage.g:404:2: rule__SequenceTermRule__SequenceNameAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__SequenceTermRule__SequenceNameAssignment_1();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getSequenceTermRuleAccess().getSequenceNameAssignment_1());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__SequenceTermRule__Group__1__Impl"


	// $ANTLR start "rule__SequenceTermRule__Group__2"
	// InternalUmlMessage.g:414:1: rule__SequenceTermRule__Group__2 : rule__SequenceTermRule__Group__2__Impl ;
	public final void rule__SequenceTermRule__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:418:1: ( rule__SequenceTermRule__Group__2__Impl )
			// InternalUmlMessage.g:419:2: rule__SequenceTermRule__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__SequenceTermRule__Group__2__Impl();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__SequenceTermRule__Group__2"


	// $ANTLR start "rule__SequenceTermRule__Group__2__Impl"
	// InternalUmlMessage.g:425:1: rule__SequenceTermRule__Group__2__Impl : ( ( rule__SequenceTermRule__RecurrenceAssignment_2 )? ) ;
	public final void rule__SequenceTermRule__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:429:1: ( ( ( rule__SequenceTermRule__RecurrenceAssignment_2 )? ) )
			// InternalUmlMessage.g:430:1: ( ( rule__SequenceTermRule__RecurrenceAssignment_2 )? )
			{
				// InternalUmlMessage.g:430:1: ( ( rule__SequenceTermRule__RecurrenceAssignment_2 )? )
				// InternalUmlMessage.g:431:1: ( rule__SequenceTermRule__RecurrenceAssignment_2 )?
				{
					before(grammarAccess.getSequenceTermRuleAccess().getRecurrenceAssignment_2());
					// InternalUmlMessage.g:432:1: ( rule__SequenceTermRule__RecurrenceAssignment_2 )?
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if (((LA4_0 >= 15 && LA4_0 <= 16))) {
						alt4 = 1;
					}
					switch (alt4) {
					case 1:
					// InternalUmlMessage.g:432:2: rule__SequenceTermRule__RecurrenceAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__SequenceTermRule__RecurrenceAssignment_2();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getSequenceTermRuleAccess().getRecurrenceAssignment_2());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__SequenceTermRule__Group__2__Impl"


	// $ANTLR start "rule__RecurrenceRule__Group_0__0"
	// InternalUmlMessage.g:448:1: rule__RecurrenceRule__Group_0__0 : rule__RecurrenceRule__Group_0__0__Impl rule__RecurrenceRule__Group_0__1 ;
	public final void rule__RecurrenceRule__Group_0__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:452:1: ( rule__RecurrenceRule__Group_0__0__Impl rule__RecurrenceRule__Group_0__1 )
			// InternalUmlMessage.g:453:2: rule__RecurrenceRule__Group_0__0__Impl rule__RecurrenceRule__Group_0__1
			{
				pushFollow(FOLLOW_8);
				rule__RecurrenceRule__Group_0__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__RecurrenceRule__Group_0__1();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Group_0__0"


	// $ANTLR start "rule__RecurrenceRule__Group_0__0__Impl"
	// InternalUmlMessage.g:460:1: rule__RecurrenceRule__Group_0__0__Impl : ( '*' ) ;
	public final void rule__RecurrenceRule__Group_0__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:464:1: ( ( '*' ) )
			// InternalUmlMessage.g:465:1: ( '*' )
			{
				// InternalUmlMessage.g:465:1: ( '*' )
				// InternalUmlMessage.g:466:1: '*'
				{
					before(grammarAccess.getRecurrenceRuleAccess().getAsteriskKeyword_0_0());
					match(input, 15, FOLLOW_2);
					after(grammarAccess.getRecurrenceRuleAccess().getAsteriskKeyword_0_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Group_0__0__Impl"


	// $ANTLR start "rule__RecurrenceRule__Group_0__1"
	// InternalUmlMessage.g:479:1: rule__RecurrenceRule__Group_0__1 : rule__RecurrenceRule__Group_0__1__Impl rule__RecurrenceRule__Group_0__2 ;
	public final void rule__RecurrenceRule__Group_0__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:483:1: ( rule__RecurrenceRule__Group_0__1__Impl rule__RecurrenceRule__Group_0__2 )
			// InternalUmlMessage.g:484:2: rule__RecurrenceRule__Group_0__1__Impl rule__RecurrenceRule__Group_0__2
			{
				pushFollow(FOLLOW_9);
				rule__RecurrenceRule__Group_0__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__RecurrenceRule__Group_0__2();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Group_0__1"


	// $ANTLR start "rule__RecurrenceRule__Group_0__1__Impl"
	// InternalUmlMessage.g:491:1: rule__RecurrenceRule__Group_0__1__Impl : ( '[' ) ;
	public final void rule__RecurrenceRule__Group_0__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:495:1: ( ( '[' ) )
			// InternalUmlMessage.g:496:1: ( '[' )
			{
				// InternalUmlMessage.g:496:1: ( '[' )
				// InternalUmlMessage.g:497:1: '['
				{
					before(grammarAccess.getRecurrenceRuleAccess().getLeftSquareBracketKeyword_0_1());
					match(input, 16, FOLLOW_2);
					after(grammarAccess.getRecurrenceRuleAccess().getLeftSquareBracketKeyword_0_1());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Group_0__1__Impl"


	// $ANTLR start "rule__RecurrenceRule__Group_0__2"
	// InternalUmlMessage.g:510:1: rule__RecurrenceRule__Group_0__2 : rule__RecurrenceRule__Group_0__2__Impl rule__RecurrenceRule__Group_0__3 ;
	public final void rule__RecurrenceRule__Group_0__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:514:1: ( rule__RecurrenceRule__Group_0__2__Impl rule__RecurrenceRule__Group_0__3 )
			// InternalUmlMessage.g:515:2: rule__RecurrenceRule__Group_0__2__Impl rule__RecurrenceRule__Group_0__3
			{
				pushFollow(FOLLOW_10);
				rule__RecurrenceRule__Group_0__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__RecurrenceRule__Group_0__3();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Group_0__2"


	// $ANTLR start "rule__RecurrenceRule__Group_0__2__Impl"
	// InternalUmlMessage.g:522:1: rule__RecurrenceRule__Group_0__2__Impl : ( RULE_STRING ) ;
	public final void rule__RecurrenceRule__Group_0__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:526:1: ( ( RULE_STRING ) )
			// InternalUmlMessage.g:527:1: ( RULE_STRING )
			{
				// InternalUmlMessage.g:527:1: ( RULE_STRING )
				// InternalUmlMessage.g:528:1: RULE_STRING
				{
					before(grammarAccess.getRecurrenceRuleAccess().getSTRINGTerminalRuleCall_0_2());
					match(input, RULE_STRING, FOLLOW_2);
					after(grammarAccess.getRecurrenceRuleAccess().getSTRINGTerminalRuleCall_0_2());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Group_0__2__Impl"


	// $ANTLR start "rule__RecurrenceRule__Group_0__3"
	// InternalUmlMessage.g:539:1: rule__RecurrenceRule__Group_0__3 : rule__RecurrenceRule__Group_0__3__Impl ;
	public final void rule__RecurrenceRule__Group_0__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:543:1: ( rule__RecurrenceRule__Group_0__3__Impl )
			// InternalUmlMessage.g:544:2: rule__RecurrenceRule__Group_0__3__Impl
			{
				pushFollow(FOLLOW_2);
				rule__RecurrenceRule__Group_0__3__Impl();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Group_0__3"


	// $ANTLR start "rule__RecurrenceRule__Group_0__3__Impl"
	// InternalUmlMessage.g:550:1: rule__RecurrenceRule__Group_0__3__Impl : ( ']' ) ;
	public final void rule__RecurrenceRule__Group_0__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:554:1: ( ( ']' ) )
			// InternalUmlMessage.g:555:1: ( ']' )
			{
				// InternalUmlMessage.g:555:1: ( ']' )
				// InternalUmlMessage.g:556:1: ']'
				{
					before(grammarAccess.getRecurrenceRuleAccess().getRightSquareBracketKeyword_0_3());
					match(input, 17, FOLLOW_2);
					after(grammarAccess.getRecurrenceRuleAccess().getRightSquareBracketKeyword_0_3());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Group_0__3__Impl"


	// $ANTLR start "rule__RecurrenceRule__Group_1__0"
	// InternalUmlMessage.g:577:1: rule__RecurrenceRule__Group_1__0 : rule__RecurrenceRule__Group_1__0__Impl rule__RecurrenceRule__Group_1__1 ;
	public final void rule__RecurrenceRule__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:581:1: ( rule__RecurrenceRule__Group_1__0__Impl rule__RecurrenceRule__Group_1__1 )
			// InternalUmlMessage.g:582:2: rule__RecurrenceRule__Group_1__0__Impl rule__RecurrenceRule__Group_1__1
			{
				pushFollow(FOLLOW_9);
				rule__RecurrenceRule__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__RecurrenceRule__Group_1__1();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Group_1__0"


	// $ANTLR start "rule__RecurrenceRule__Group_1__0__Impl"
	// InternalUmlMessage.g:589:1: rule__RecurrenceRule__Group_1__0__Impl : ( '[' ) ;
	public final void rule__RecurrenceRule__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:593:1: ( ( '[' ) )
			// InternalUmlMessage.g:594:1: ( '[' )
			{
				// InternalUmlMessage.g:594:1: ( '[' )
				// InternalUmlMessage.g:595:1: '['
				{
					before(grammarAccess.getRecurrenceRuleAccess().getLeftSquareBracketKeyword_1_0());
					match(input, 16, FOLLOW_2);
					after(grammarAccess.getRecurrenceRuleAccess().getLeftSquareBracketKeyword_1_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Group_1__0__Impl"


	// $ANTLR start "rule__RecurrenceRule__Group_1__1"
	// InternalUmlMessage.g:608:1: rule__RecurrenceRule__Group_1__1 : rule__RecurrenceRule__Group_1__1__Impl rule__RecurrenceRule__Group_1__2 ;
	public final void rule__RecurrenceRule__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:612:1: ( rule__RecurrenceRule__Group_1__1__Impl rule__RecurrenceRule__Group_1__2 )
			// InternalUmlMessage.g:613:2: rule__RecurrenceRule__Group_1__1__Impl rule__RecurrenceRule__Group_1__2
			{
				pushFollow(FOLLOW_10);
				rule__RecurrenceRule__Group_1__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__RecurrenceRule__Group_1__2();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Group_1__1"


	// $ANTLR start "rule__RecurrenceRule__Group_1__1__Impl"
	// InternalUmlMessage.g:620:1: rule__RecurrenceRule__Group_1__1__Impl : ( RULE_STRING ) ;
	public final void rule__RecurrenceRule__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:624:1: ( ( RULE_STRING ) )
			// InternalUmlMessage.g:625:1: ( RULE_STRING )
			{
				// InternalUmlMessage.g:625:1: ( RULE_STRING )
				// InternalUmlMessage.g:626:1: RULE_STRING
				{
					before(grammarAccess.getRecurrenceRuleAccess().getSTRINGTerminalRuleCall_1_1());
					match(input, RULE_STRING, FOLLOW_2);
					after(grammarAccess.getRecurrenceRuleAccess().getSTRINGTerminalRuleCall_1_1());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Group_1__1__Impl"


	// $ANTLR start "rule__RecurrenceRule__Group_1__2"
	// InternalUmlMessage.g:637:1: rule__RecurrenceRule__Group_1__2 : rule__RecurrenceRule__Group_1__2__Impl ;
	public final void rule__RecurrenceRule__Group_1__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:641:1: ( rule__RecurrenceRule__Group_1__2__Impl )
			// InternalUmlMessage.g:642:2: rule__RecurrenceRule__Group_1__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__RecurrenceRule__Group_1__2__Impl();

				state._fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Group_1__2"


	// $ANTLR start "rule__RecurrenceRule__Group_1__2__Impl"
	// InternalUmlMessage.g:648:1: rule__RecurrenceRule__Group_1__2__Impl : ( ']' ) ;
	public final void rule__RecurrenceRule__Group_1__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:652:1: ( ( ']' ) )
			// InternalUmlMessage.g:653:1: ( ']' )
			{
				// InternalUmlMessage.g:653:1: ( ']' )
				// InternalUmlMessage.g:654:1: ']'
				{
					before(grammarAccess.getRecurrenceRuleAccess().getRightSquareBracketKeyword_1_2());
					match(input, 17, FOLLOW_2);
					after(grammarAccess.getRecurrenceRuleAccess().getRightSquareBracketKeyword_1_2());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__RecurrenceRule__Group_1__2__Impl"


	// $ANTLR start "rule__MessageRule__SequenceTermAssignment_0"
	// InternalUmlMessage.g:674:1: rule__MessageRule__SequenceTermAssignment_0 : ( ruleSequenceTermRule ) ;
	public final void rule__MessageRule__SequenceTermAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:678:1: ( ( ruleSequenceTermRule ) )
			// InternalUmlMessage.g:679:1: ( ruleSequenceTermRule )
			{
				// InternalUmlMessage.g:679:1: ( ruleSequenceTermRule )
				// InternalUmlMessage.g:680:1: ruleSequenceTermRule
				{
					before(grammarAccess.getMessageRuleAccess().getSequenceTermSequenceTermRuleParserRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleSequenceTermRule();

					state._fsp--;

					after(grammarAccess.getMessageRuleAccess().getSequenceTermSequenceTermRuleParserRuleCall_0_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__SequenceTermAssignment_0"


	// $ANTLR start "rule__MessageRule__SequenceTermAssignment_1_1"
	// InternalUmlMessage.g:689:1: rule__MessageRule__SequenceTermAssignment_1_1 : ( ruleSequenceTermRule ) ;
	public final void rule__MessageRule__SequenceTermAssignment_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:693:1: ( ( ruleSequenceTermRule ) )
			// InternalUmlMessage.g:694:1: ( ruleSequenceTermRule )
			{
				// InternalUmlMessage.g:694:1: ( ruleSequenceTermRule )
				// InternalUmlMessage.g:695:1: ruleSequenceTermRule
				{
					before(grammarAccess.getMessageRuleAccess().getSequenceTermSequenceTermRuleParserRuleCall_1_1_0());
					pushFollow(FOLLOW_2);
					ruleSequenceTermRule();

					state._fsp--;

					after(grammarAccess.getMessageRuleAccess().getSequenceTermSequenceTermRuleParserRuleCall_1_1_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__SequenceTermAssignment_1_1"


	// $ANTLR start "rule__MessageRule__NameAssignment_3"
	// InternalUmlMessage.g:704:1: rule__MessageRule__NameAssignment_3 : ( RULE_NAME_RULE ) ;
	public final void rule__MessageRule__NameAssignment_3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:708:1: ( ( RULE_NAME_RULE ) )
			// InternalUmlMessage.g:709:1: ( RULE_NAME_RULE )
			{
				// InternalUmlMessage.g:709:1: ( RULE_NAME_RULE )
				// InternalUmlMessage.g:710:1: RULE_NAME_RULE
				{
					before(grammarAccess.getMessageRuleAccess().getNameNAME_RULETerminalRuleCall_3_0());
					match(input, RULE_NAME_RULE, FOLLOW_2);
					after(grammarAccess.getMessageRuleAccess().getNameNAME_RULETerminalRuleCall_3_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__MessageRule__NameAssignment_3"


	// $ANTLR start "rule__SequenceTermRule__SequencialOrderAssignment_0"
	// InternalUmlMessage.g:719:1: rule__SequenceTermRule__SequencialOrderAssignment_0 : ( RULE_INT ) ;
	public final void rule__SequenceTermRule__SequencialOrderAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:723:1: ( ( RULE_INT ) )
			// InternalUmlMessage.g:724:1: ( RULE_INT )
			{
				// InternalUmlMessage.g:724:1: ( RULE_INT )
				// InternalUmlMessage.g:725:1: RULE_INT
				{
					before(grammarAccess.getSequenceTermRuleAccess().getSequencialOrderINTTerminalRuleCall_0_0());
					match(input, RULE_INT, FOLLOW_2);
					after(grammarAccess.getSequenceTermRuleAccess().getSequencialOrderINTTerminalRuleCall_0_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__SequenceTermRule__SequencialOrderAssignment_0"


	// $ANTLR start "rule__SequenceTermRule__SequenceNameAssignment_1"
	// InternalUmlMessage.g:734:1: rule__SequenceTermRule__SequenceNameAssignment_1 : ( RULE_ID ) ;
	public final void rule__SequenceTermRule__SequenceNameAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:738:1: ( ( RULE_ID ) )
			// InternalUmlMessage.g:739:1: ( RULE_ID )
			{
				// InternalUmlMessage.g:739:1: ( RULE_ID )
				// InternalUmlMessage.g:740:1: RULE_ID
				{
					before(grammarAccess.getSequenceTermRuleAccess().getSequenceNameIDTerminalRuleCall_1_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getSequenceTermRuleAccess().getSequenceNameIDTerminalRuleCall_1_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__SequenceTermRule__SequenceNameAssignment_1"


	// $ANTLR start "rule__SequenceTermRule__RecurrenceAssignment_2"
	// InternalUmlMessage.g:749:1: rule__SequenceTermRule__RecurrenceAssignment_2 : ( ruleRecurrenceRule ) ;
	public final void rule__SequenceTermRule__RecurrenceAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlMessage.g:753:1: ( ( ruleRecurrenceRule ) )
			// InternalUmlMessage.g:754:1: ( ruleRecurrenceRule )
			{
				// InternalUmlMessage.g:754:1: ( ruleRecurrenceRule )
				// InternalUmlMessage.g:755:1: ruleRecurrenceRule
				{
					before(grammarAccess.getSequenceTermRuleAccess().getRecurrenceRecurrenceRuleParserRuleCall_2_0());
					pushFollow(FOLLOW_2);
					ruleRecurrenceRule();

					state._fsp--;

					after(grammarAccess.getSequenceTermRuleAccess().getRecurrenceRecurrenceRuleParserRuleCall_2_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__SequenceTermRule__RecurrenceAssignment_2"

	// Delegated rules




	public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x0000000000006000L });
	public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x0000000000004002L });
	public static final BitSet FOLLOW_5 = new BitSet(new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_6 = new BitSet(new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_7 = new BitSet(new long[] { 0x0000000000018080L });
	public static final BitSet FOLLOW_8 = new BitSet(new long[] { 0x0000000000010000L });
	public static final BitSet FOLLOW_9 = new BitSet(new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_10 = new BitSet(new long[] { 0x0000000000020000L });

}