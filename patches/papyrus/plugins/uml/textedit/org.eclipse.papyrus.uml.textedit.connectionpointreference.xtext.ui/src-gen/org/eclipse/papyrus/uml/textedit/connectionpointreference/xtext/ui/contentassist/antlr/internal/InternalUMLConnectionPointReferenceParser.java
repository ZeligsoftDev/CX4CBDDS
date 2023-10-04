package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui.contentassist.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.services.UMLConnectionPointReferenceGrammarAccess;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

@SuppressWarnings("all")
public class InternalUMLConnectionPointReferenceParser extends AbstractInternalContentAssistParser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INT", "RULE_INTEGER_VALUE", "RULE_WS", "RULE_ANY_OTHER", "'entry'", "','", "'exit'"
	};
	public static final int RULE_ID = 4;
	public static final int RULE_WS = 10;
	public static final int RULE_STRING = 5;
	public static final int RULE_ANY_OTHER = 11;
	public static final int RULE_SL_COMMENT = 7;
	public static final int RULE_INT = 8;
	public static final int RULE_ML_COMMENT = 6;
	public static final int RULE_INTEGER_VALUE = 9;
	public static final int T__12 = 12;
	public static final int T__13 = 13;
	public static final int T__14 = 14;
	public static final int EOF = -1;

	// delegates
	// delegators


	public InternalUMLConnectionPointReferenceParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalUMLConnectionPointReferenceParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);

	}


	public String[] getTokenNames() {
		return InternalUMLConnectionPointReferenceParser.tokenNames;
	}

	public String getGrammarFileName() {
		return "../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g";
	}



	private UMLConnectionPointReferenceGrammarAccess grammarAccess;

	public void setGrammarAccess(UMLConnectionPointReferenceGrammarAccess grammarAccess) {
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




	// $ANTLR start "entryRuleConnectionPointReferenceRule"
	// InternalUMLConnectionPointReference.g:60:1: entryRuleConnectionPointReferenceRule : ruleConnectionPointReferenceRule EOF ;
	public final void entryRuleConnectionPointReferenceRule() throws RecognitionException {
		try {
			// InternalUMLConnectionPointReference.g:61:1: ( ruleConnectionPointReferenceRule EOF )
			// InternalUMLConnectionPointReference.g:62:1: ruleConnectionPointReferenceRule EOF
			{
				before(grammarAccess.getConnectionPointReferenceRuleRule());
				pushFollow(FOLLOW_1);
				ruleConnectionPointReferenceRule();

				state._fsp--;

				after(grammarAccess.getConnectionPointReferenceRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleConnectionPointReferenceRule"


	// $ANTLR start "ruleConnectionPointReferenceRule"
	// InternalUMLConnectionPointReference.g:69:1: ruleConnectionPointReferenceRule : ( ( rule__ConnectionPointReferenceRule__Alternatives )? ) ;
	public final void ruleConnectionPointReferenceRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:73:2: ( ( ( rule__ConnectionPointReferenceRule__Alternatives )? ) )
			// InternalUMLConnectionPointReference.g:74:1: ( ( rule__ConnectionPointReferenceRule__Alternatives )? )
			{
				// InternalUMLConnectionPointReference.g:74:1: ( ( rule__ConnectionPointReferenceRule__Alternatives )? )
				// InternalUMLConnectionPointReference.g:75:1: ( rule__ConnectionPointReferenceRule__Alternatives )?
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getAlternatives());
					// InternalUMLConnectionPointReference.g:76:1: ( rule__ConnectionPointReferenceRule__Alternatives )?
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if ((LA1_0 == 12 || LA1_0 == 14)) {
						alt1 = 1;
					}
					switch (alt1) {
					case 1:
					// InternalUMLConnectionPointReference.g:76:2: rule__ConnectionPointReferenceRule__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__ConnectionPointReferenceRule__Alternatives();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getConnectionPointReferenceRuleAccess().getAlternatives());

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
	// $ANTLR end "ruleConnectionPointReferenceRule"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Alternatives"
	// InternalUMLConnectionPointReference.g:88:1: rule__ConnectionPointReferenceRule__Alternatives : ( ( ( rule__ConnectionPointReferenceRule__Group_0__0 ) ) | ( ( rule__ConnectionPointReferenceRule__Group_1__0 ) ) );
	public final void rule__ConnectionPointReferenceRule__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:92:1: ( ( ( rule__ConnectionPointReferenceRule__Group_0__0 ) ) | ( ( rule__ConnectionPointReferenceRule__Group_1__0 ) ) )
			int alt2 = 2;
			int LA2_0 = input.LA(1);

			if ((LA2_0 == 12)) {
				alt2 = 1;
			} else if ((LA2_0 == 14)) {
				alt2 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 2, 0, input);

				throw nvae;
			}
			switch (alt2) {
			case 1:
			// InternalUMLConnectionPointReference.g:93:1: ( ( rule__ConnectionPointReferenceRule__Group_0__0 ) )
			{
				// InternalUMLConnectionPointReference.g:93:1: ( ( rule__ConnectionPointReferenceRule__Group_0__0 ) )
				// InternalUMLConnectionPointReference.g:94:1: ( rule__ConnectionPointReferenceRule__Group_0__0 )
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_0());
					// InternalUMLConnectionPointReference.g:95:1: ( rule__ConnectionPointReferenceRule__Group_0__0 )
					// InternalUMLConnectionPointReference.g:95:2: rule__ConnectionPointReferenceRule__Group_0__0
					{
						pushFollow(FOLLOW_2);
						rule__ConnectionPointReferenceRule__Group_0__0();

						state._fsp--;


					}

					after(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_0());

				}


			}
				break;
			case 2:
			// InternalUMLConnectionPointReference.g:99:6: ( ( rule__ConnectionPointReferenceRule__Group_1__0 ) )
			{
				// InternalUMLConnectionPointReference.g:99:6: ( ( rule__ConnectionPointReferenceRule__Group_1__0 ) )
				// InternalUMLConnectionPointReference.g:100:1: ( rule__ConnectionPointReferenceRule__Group_1__0 )
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_1());
					// InternalUMLConnectionPointReference.g:101:1: ( rule__ConnectionPointReferenceRule__Group_1__0 )
					// InternalUMLConnectionPointReference.g:101:2: rule__ConnectionPointReferenceRule__Group_1__0
					{
						pushFollow(FOLLOW_2);
						rule__ConnectionPointReferenceRule__Group_1__0();

						state._fsp--;


					}

					after(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_1());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Alternatives"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_0__0"
	// InternalUMLConnectionPointReference.g:112:1: rule__ConnectionPointReferenceRule__Group_0__0 : rule__ConnectionPointReferenceRule__Group_0__0__Impl rule__ConnectionPointReferenceRule__Group_0__1 ;
	public final void rule__ConnectionPointReferenceRule__Group_0__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:116:1: ( rule__ConnectionPointReferenceRule__Group_0__0__Impl rule__ConnectionPointReferenceRule__Group_0__1 )
			// InternalUMLConnectionPointReference.g:117:2: rule__ConnectionPointReferenceRule__Group_0__0__Impl rule__ConnectionPointReferenceRule__Group_0__1
			{
				pushFollow(FOLLOW_3);
				rule__ConnectionPointReferenceRule__Group_0__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ConnectionPointReferenceRule__Group_0__1();

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_0__0"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_0__0__Impl"
	// InternalUMLConnectionPointReference.g:124:1: rule__ConnectionPointReferenceRule__Group_0__0__Impl : ( 'entry' ) ;
	public final void rule__ConnectionPointReferenceRule__Group_0__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:128:1: ( ( 'entry' ) )
			// InternalUMLConnectionPointReference.g:129:1: ( 'entry' )
			{
				// InternalUMLConnectionPointReference.g:129:1: ( 'entry' )
				// InternalUMLConnectionPointReference.g:130:1: 'entry'
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryKeyword_0_0());
					match(input, 12, FOLLOW_2);
					after(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryKeyword_0_0());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_0__0__Impl"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_0__1"
	// InternalUMLConnectionPointReference.g:143:1: rule__ConnectionPointReferenceRule__Group_0__1 : rule__ConnectionPointReferenceRule__Group_0__1__Impl rule__ConnectionPointReferenceRule__Group_0__2 ;
	public final void rule__ConnectionPointReferenceRule__Group_0__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:147:1: ( rule__ConnectionPointReferenceRule__Group_0__1__Impl rule__ConnectionPointReferenceRule__Group_0__2 )
			// InternalUMLConnectionPointReference.g:148:2: rule__ConnectionPointReferenceRule__Group_0__1__Impl rule__ConnectionPointReferenceRule__Group_0__2
			{
				pushFollow(FOLLOW_4);
				rule__ConnectionPointReferenceRule__Group_0__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ConnectionPointReferenceRule__Group_0__2();

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_0__1"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_0__1__Impl"
	// InternalUMLConnectionPointReference.g:155:1: rule__ConnectionPointReferenceRule__Group_0__1__Impl : ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_1 ) ) ;
	public final void rule__ConnectionPointReferenceRule__Group_0__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:159:1: ( ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_1 ) ) )
			// InternalUMLConnectionPointReference.g:160:1: ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_1 ) )
			{
				// InternalUMLConnectionPointReference.g:160:1: ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_1 ) )
				// InternalUMLConnectionPointReference.g:161:1: ( rule__ConnectionPointReferenceRule__EntryAssignment_0_1 )
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryAssignment_0_1());
					// InternalUMLConnectionPointReference.g:162:1: ( rule__ConnectionPointReferenceRule__EntryAssignment_0_1 )
					// InternalUMLConnectionPointReference.g:162:2: rule__ConnectionPointReferenceRule__EntryAssignment_0_1
					{
						pushFollow(FOLLOW_2);
						rule__ConnectionPointReferenceRule__EntryAssignment_0_1();

						state._fsp--;


					}

					after(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryAssignment_0_1());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_0__1__Impl"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_0__2"
	// InternalUMLConnectionPointReference.g:172:1: rule__ConnectionPointReferenceRule__Group_0__2 : rule__ConnectionPointReferenceRule__Group_0__2__Impl ;
	public final void rule__ConnectionPointReferenceRule__Group_0__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:176:1: ( rule__ConnectionPointReferenceRule__Group_0__2__Impl )
			// InternalUMLConnectionPointReference.g:177:2: rule__ConnectionPointReferenceRule__Group_0__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__ConnectionPointReferenceRule__Group_0__2__Impl();

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_0__2"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_0__2__Impl"
	// InternalUMLConnectionPointReference.g:183:1: rule__ConnectionPointReferenceRule__Group_0__2__Impl : ( ( rule__ConnectionPointReferenceRule__Group_0_2__0 )* ) ;
	public final void rule__ConnectionPointReferenceRule__Group_0__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:187:1: ( ( ( rule__ConnectionPointReferenceRule__Group_0_2__0 )* ) )
			// InternalUMLConnectionPointReference.g:188:1: ( ( rule__ConnectionPointReferenceRule__Group_0_2__0 )* )
			{
				// InternalUMLConnectionPointReference.g:188:1: ( ( rule__ConnectionPointReferenceRule__Group_0_2__0 )* )
				// InternalUMLConnectionPointReference.g:189:1: ( rule__ConnectionPointReferenceRule__Group_0_2__0 )*
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_0_2());
					// InternalUMLConnectionPointReference.g:190:1: ( rule__ConnectionPointReferenceRule__Group_0_2__0 )*
					loop3: do {
						int alt3 = 2;
						int LA3_0 = input.LA(1);

						if ((LA3_0 == 13)) {
							alt3 = 1;
						}


						switch (alt3) {
						case 1:
						// InternalUMLConnectionPointReference.g:190:2: rule__ConnectionPointReferenceRule__Group_0_2__0
						{
							pushFollow(FOLLOW_5);
							rule__ConnectionPointReferenceRule__Group_0_2__0();

							state._fsp--;


						}
							break;

						default:
							break loop3;
						}
					} while (true);

					after(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_0_2());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_0__2__Impl"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_0_2__0"
	// InternalUMLConnectionPointReference.g:206:1: rule__ConnectionPointReferenceRule__Group_0_2__0 : rule__ConnectionPointReferenceRule__Group_0_2__0__Impl rule__ConnectionPointReferenceRule__Group_0_2__1 ;
	public final void rule__ConnectionPointReferenceRule__Group_0_2__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:210:1: ( rule__ConnectionPointReferenceRule__Group_0_2__0__Impl rule__ConnectionPointReferenceRule__Group_0_2__1 )
			// InternalUMLConnectionPointReference.g:211:2: rule__ConnectionPointReferenceRule__Group_0_2__0__Impl rule__ConnectionPointReferenceRule__Group_0_2__1
			{
				pushFollow(FOLLOW_3);
				rule__ConnectionPointReferenceRule__Group_0_2__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ConnectionPointReferenceRule__Group_0_2__1();

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_0_2__0"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_0_2__0__Impl"
	// InternalUMLConnectionPointReference.g:218:1: rule__ConnectionPointReferenceRule__Group_0_2__0__Impl : ( ',' ) ;
	public final void rule__ConnectionPointReferenceRule__Group_0_2__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:222:1: ( ( ',' ) )
			// InternalUMLConnectionPointReference.g:223:1: ( ',' )
			{
				// InternalUMLConnectionPointReference.g:223:1: ( ',' )
				// InternalUMLConnectionPointReference.g:224:1: ','
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getCommaKeyword_0_2_0());
					match(input, 13, FOLLOW_2);
					after(grammarAccess.getConnectionPointReferenceRuleAccess().getCommaKeyword_0_2_0());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_0_2__0__Impl"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_0_2__1"
	// InternalUMLConnectionPointReference.g:237:1: rule__ConnectionPointReferenceRule__Group_0_2__1 : rule__ConnectionPointReferenceRule__Group_0_2__1__Impl ;
	public final void rule__ConnectionPointReferenceRule__Group_0_2__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:241:1: ( rule__ConnectionPointReferenceRule__Group_0_2__1__Impl )
			// InternalUMLConnectionPointReference.g:242:2: rule__ConnectionPointReferenceRule__Group_0_2__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__ConnectionPointReferenceRule__Group_0_2__1__Impl();

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_0_2__1"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_0_2__1__Impl"
	// InternalUMLConnectionPointReference.g:248:1: rule__ConnectionPointReferenceRule__Group_0_2__1__Impl : ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1 ) ) ;
	public final void rule__ConnectionPointReferenceRule__Group_0_2__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:252:1: ( ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1 ) ) )
			// InternalUMLConnectionPointReference.g:253:1: ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1 ) )
			{
				// InternalUMLConnectionPointReference.g:253:1: ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1 ) )
				// InternalUMLConnectionPointReference.g:254:1: ( rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1 )
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryAssignment_0_2_1());
					// InternalUMLConnectionPointReference.g:255:1: ( rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1 )
					// InternalUMLConnectionPointReference.g:255:2: rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1
					{
						pushFollow(FOLLOW_2);
						rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1();

						state._fsp--;


					}

					after(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryAssignment_0_2_1());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_0_2__1__Impl"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_1__0"
	// InternalUMLConnectionPointReference.g:269:1: rule__ConnectionPointReferenceRule__Group_1__0 : rule__ConnectionPointReferenceRule__Group_1__0__Impl rule__ConnectionPointReferenceRule__Group_1__1 ;
	public final void rule__ConnectionPointReferenceRule__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:273:1: ( rule__ConnectionPointReferenceRule__Group_1__0__Impl rule__ConnectionPointReferenceRule__Group_1__1 )
			// InternalUMLConnectionPointReference.g:274:2: rule__ConnectionPointReferenceRule__Group_1__0__Impl rule__ConnectionPointReferenceRule__Group_1__1
			{
				pushFollow(FOLLOW_3);
				rule__ConnectionPointReferenceRule__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ConnectionPointReferenceRule__Group_1__1();

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_1__0"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_1__0__Impl"
	// InternalUMLConnectionPointReference.g:281:1: rule__ConnectionPointReferenceRule__Group_1__0__Impl : ( 'exit' ) ;
	public final void rule__ConnectionPointReferenceRule__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:285:1: ( ( 'exit' ) )
			// InternalUMLConnectionPointReference.g:286:1: ( 'exit' )
			{
				// InternalUMLConnectionPointReference.g:286:1: ( 'exit' )
				// InternalUMLConnectionPointReference.g:287:1: 'exit'
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getExitKeyword_1_0());
					match(input, 14, FOLLOW_2);
					after(grammarAccess.getConnectionPointReferenceRuleAccess().getExitKeyword_1_0());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_1__0__Impl"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_1__1"
	// InternalUMLConnectionPointReference.g:300:1: rule__ConnectionPointReferenceRule__Group_1__1 : rule__ConnectionPointReferenceRule__Group_1__1__Impl rule__ConnectionPointReferenceRule__Group_1__2 ;
	public final void rule__ConnectionPointReferenceRule__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:304:1: ( rule__ConnectionPointReferenceRule__Group_1__1__Impl rule__ConnectionPointReferenceRule__Group_1__2 )
			// InternalUMLConnectionPointReference.g:305:2: rule__ConnectionPointReferenceRule__Group_1__1__Impl rule__ConnectionPointReferenceRule__Group_1__2
			{
				pushFollow(FOLLOW_4);
				rule__ConnectionPointReferenceRule__Group_1__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ConnectionPointReferenceRule__Group_1__2();

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_1__1"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_1__1__Impl"
	// InternalUMLConnectionPointReference.g:312:1: rule__ConnectionPointReferenceRule__Group_1__1__Impl : ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_1 ) ) ;
	public final void rule__ConnectionPointReferenceRule__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:316:1: ( ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_1 ) ) )
			// InternalUMLConnectionPointReference.g:317:1: ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_1 ) )
			{
				// InternalUMLConnectionPointReference.g:317:1: ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_1 ) )
				// InternalUMLConnectionPointReference.g:318:1: ( rule__ConnectionPointReferenceRule__ExitAssignment_1_1 )
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getExitAssignment_1_1());
					// InternalUMLConnectionPointReference.g:319:1: ( rule__ConnectionPointReferenceRule__ExitAssignment_1_1 )
					// InternalUMLConnectionPointReference.g:319:2: rule__ConnectionPointReferenceRule__ExitAssignment_1_1
					{
						pushFollow(FOLLOW_2);
						rule__ConnectionPointReferenceRule__ExitAssignment_1_1();

						state._fsp--;


					}

					after(grammarAccess.getConnectionPointReferenceRuleAccess().getExitAssignment_1_1());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_1__1__Impl"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_1__2"
	// InternalUMLConnectionPointReference.g:329:1: rule__ConnectionPointReferenceRule__Group_1__2 : rule__ConnectionPointReferenceRule__Group_1__2__Impl ;
	public final void rule__ConnectionPointReferenceRule__Group_1__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:333:1: ( rule__ConnectionPointReferenceRule__Group_1__2__Impl )
			// InternalUMLConnectionPointReference.g:334:2: rule__ConnectionPointReferenceRule__Group_1__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__ConnectionPointReferenceRule__Group_1__2__Impl();

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_1__2"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_1__2__Impl"
	// InternalUMLConnectionPointReference.g:340:1: rule__ConnectionPointReferenceRule__Group_1__2__Impl : ( ( rule__ConnectionPointReferenceRule__Group_1_2__0 )* ) ;
	public final void rule__ConnectionPointReferenceRule__Group_1__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:344:1: ( ( ( rule__ConnectionPointReferenceRule__Group_1_2__0 )* ) )
			// InternalUMLConnectionPointReference.g:345:1: ( ( rule__ConnectionPointReferenceRule__Group_1_2__0 )* )
			{
				// InternalUMLConnectionPointReference.g:345:1: ( ( rule__ConnectionPointReferenceRule__Group_1_2__0 )* )
				// InternalUMLConnectionPointReference.g:346:1: ( rule__ConnectionPointReferenceRule__Group_1_2__0 )*
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_1_2());
					// InternalUMLConnectionPointReference.g:347:1: ( rule__ConnectionPointReferenceRule__Group_1_2__0 )*
					loop4: do {
						int alt4 = 2;
						int LA4_0 = input.LA(1);

						if ((LA4_0 == 13)) {
							alt4 = 1;
						}


						switch (alt4) {
						case 1:
						// InternalUMLConnectionPointReference.g:347:2: rule__ConnectionPointReferenceRule__Group_1_2__0
						{
							pushFollow(FOLLOW_5);
							rule__ConnectionPointReferenceRule__Group_1_2__0();

							state._fsp--;


						}
							break;

						default:
							break loop4;
						}
					} while (true);

					after(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_1_2());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_1__2__Impl"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_1_2__0"
	// InternalUMLConnectionPointReference.g:363:1: rule__ConnectionPointReferenceRule__Group_1_2__0 : rule__ConnectionPointReferenceRule__Group_1_2__0__Impl rule__ConnectionPointReferenceRule__Group_1_2__1 ;
	public final void rule__ConnectionPointReferenceRule__Group_1_2__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:367:1: ( rule__ConnectionPointReferenceRule__Group_1_2__0__Impl rule__ConnectionPointReferenceRule__Group_1_2__1 )
			// InternalUMLConnectionPointReference.g:368:2: rule__ConnectionPointReferenceRule__Group_1_2__0__Impl rule__ConnectionPointReferenceRule__Group_1_2__1
			{
				pushFollow(FOLLOW_3);
				rule__ConnectionPointReferenceRule__Group_1_2__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ConnectionPointReferenceRule__Group_1_2__1();

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_1_2__0"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_1_2__0__Impl"
	// InternalUMLConnectionPointReference.g:375:1: rule__ConnectionPointReferenceRule__Group_1_2__0__Impl : ( ',' ) ;
	public final void rule__ConnectionPointReferenceRule__Group_1_2__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:379:1: ( ( ',' ) )
			// InternalUMLConnectionPointReference.g:380:1: ( ',' )
			{
				// InternalUMLConnectionPointReference.g:380:1: ( ',' )
				// InternalUMLConnectionPointReference.g:381:1: ','
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getCommaKeyword_1_2_0());
					match(input, 13, FOLLOW_2);
					after(grammarAccess.getConnectionPointReferenceRuleAccess().getCommaKeyword_1_2_0());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_1_2__0__Impl"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_1_2__1"
	// InternalUMLConnectionPointReference.g:394:1: rule__ConnectionPointReferenceRule__Group_1_2__1 : rule__ConnectionPointReferenceRule__Group_1_2__1__Impl ;
	public final void rule__ConnectionPointReferenceRule__Group_1_2__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:398:1: ( rule__ConnectionPointReferenceRule__Group_1_2__1__Impl )
			// InternalUMLConnectionPointReference.g:399:2: rule__ConnectionPointReferenceRule__Group_1_2__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__ConnectionPointReferenceRule__Group_1_2__1__Impl();

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_1_2__1"


	// $ANTLR start "rule__ConnectionPointReferenceRule__Group_1_2__1__Impl"
	// InternalUMLConnectionPointReference.g:405:1: rule__ConnectionPointReferenceRule__Group_1_2__1__Impl : ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1 ) ) ;
	public final void rule__ConnectionPointReferenceRule__Group_1_2__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:409:1: ( ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1 ) ) )
			// InternalUMLConnectionPointReference.g:410:1: ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1 ) )
			{
				// InternalUMLConnectionPointReference.g:410:1: ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1 ) )
				// InternalUMLConnectionPointReference.g:411:1: ( rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1 )
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getExitAssignment_1_2_1());
					// InternalUMLConnectionPointReference.g:412:1: ( rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1 )
					// InternalUMLConnectionPointReference.g:412:2: rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1
					{
						pushFollow(FOLLOW_2);
						rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1();

						state._fsp--;


					}

					after(grammarAccess.getConnectionPointReferenceRuleAccess().getExitAssignment_1_2_1());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__Group_1_2__1__Impl"


	// $ANTLR start "rule__ConnectionPointReferenceRule__EntryAssignment_0_1"
	// InternalUMLConnectionPointReference.g:427:1: rule__ConnectionPointReferenceRule__EntryAssignment_0_1 : ( ( RULE_ID ) ) ;
	public final void rule__ConnectionPointReferenceRule__EntryAssignment_0_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:431:1: ( ( ( RULE_ID ) ) )
			// InternalUMLConnectionPointReference.g:432:1: ( ( RULE_ID ) )
			{
				// InternalUMLConnectionPointReference.g:432:1: ( ( RULE_ID ) )
				// InternalUMLConnectionPointReference.g:433:1: ( RULE_ID )
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_1_0());
					// InternalUMLConnectionPointReference.g:434:1: ( RULE_ID )
					// InternalUMLConnectionPointReference.g:435:1: RULE_ID
					{
						before(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateIDTerminalRuleCall_0_1_0_1());
						match(input, RULE_ID, FOLLOW_2);
						after(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateIDTerminalRuleCall_0_1_0_1());

					}

					after(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_1_0());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__EntryAssignment_0_1"


	// $ANTLR start "rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1"
	// InternalUMLConnectionPointReference.g:446:1: rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1 : ( ( RULE_ID ) ) ;
	public final void rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:450:1: ( ( ( RULE_ID ) ) )
			// InternalUMLConnectionPointReference.g:451:1: ( ( RULE_ID ) )
			{
				// InternalUMLConnectionPointReference.g:451:1: ( ( RULE_ID ) )
				// InternalUMLConnectionPointReference.g:452:1: ( RULE_ID )
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_2_1_0());
					// InternalUMLConnectionPointReference.g:453:1: ( RULE_ID )
					// InternalUMLConnectionPointReference.g:454:1: RULE_ID
					{
						before(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateIDTerminalRuleCall_0_2_1_0_1());
						match(input, RULE_ID, FOLLOW_2);
						after(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateIDTerminalRuleCall_0_2_1_0_1());

					}

					after(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_2_1_0());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1"


	// $ANTLR start "rule__ConnectionPointReferenceRule__ExitAssignment_1_1"
	// InternalUMLConnectionPointReference.g:465:1: rule__ConnectionPointReferenceRule__ExitAssignment_1_1 : ( ( RULE_ID ) ) ;
	public final void rule__ConnectionPointReferenceRule__ExitAssignment_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:469:1: ( ( ( RULE_ID ) ) )
			// InternalUMLConnectionPointReference.g:470:1: ( ( RULE_ID ) )
			{
				// InternalUMLConnectionPointReference.g:470:1: ( ( RULE_ID ) )
				// InternalUMLConnectionPointReference.g:471:1: ( RULE_ID )
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_1_0());
					// InternalUMLConnectionPointReference.g:472:1: ( RULE_ID )
					// InternalUMLConnectionPointReference.g:473:1: RULE_ID
					{
						before(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateIDTerminalRuleCall_1_1_0_1());
						match(input, RULE_ID, FOLLOW_2);
						after(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateIDTerminalRuleCall_1_1_0_1());

					}

					after(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_1_0());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__ExitAssignment_1_1"


	// $ANTLR start "rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1"
	// InternalUMLConnectionPointReference.g:484:1: rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1 : ( ( RULE_ID ) ) ;
	public final void rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUMLConnectionPointReference.g:488:1: ( ( ( RULE_ID ) ) )
			// InternalUMLConnectionPointReference.g:489:1: ( ( RULE_ID ) )
			{
				// InternalUMLConnectionPointReference.g:489:1: ( ( RULE_ID ) )
				// InternalUMLConnectionPointReference.g:490:1: ( RULE_ID )
				{
					before(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_2_1_0());
					// InternalUMLConnectionPointReference.g:491:1: ( RULE_ID )
					// InternalUMLConnectionPointReference.g:492:1: RULE_ID
					{
						before(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateIDTerminalRuleCall_1_2_1_0_1());
						match(input, RULE_ID, FOLLOW_2);
						after(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateIDTerminalRuleCall_1_2_1_0_1());

					}

					after(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_2_1_0());

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
	// $ANTLR end "rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1"

	// Delegated rules




	public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x0000000000002000L });
	public static final BitSet FOLLOW_5 = new BitSet(new long[] { 0x0000000000002002L });

}