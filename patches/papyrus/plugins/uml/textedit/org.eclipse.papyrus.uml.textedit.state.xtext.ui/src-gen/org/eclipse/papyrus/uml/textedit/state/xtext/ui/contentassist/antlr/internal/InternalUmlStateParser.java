package org.eclipse.papyrus.uml.textedit.state.xtext.ui.contentassist.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;
import org.eclipse.papyrus.uml.textedit.state.xtext.services.UmlStateGrammarAccess;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

@SuppressWarnings("all")
public class InternalUmlStateParser extends AbstractInternalContentAssistParser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INT", "RULE_INTEGER_VALUE", "RULE_WS", "RULE_ANY_OTHER", "'Activity'", "'StateMachine'", "'OpaqueBehavior'", "':'", "'::'", "'entry'",
			"'do'", "'exit'"
	};
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
	public static final int RULE_ML_COMMENT = 6;
	public static final int RULE_INTEGER_VALUE = 9;

	// delegates
	// delegators


	public InternalUmlStateParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalUmlStateParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);

	}


	public String[] getTokenNames() {
		return InternalUmlStateParser.tokenNames;
	}

	public String getGrammarFileName() {
		return "../org.eclipse.papyrus.uml.textedit.state.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/state/xtext/ui/contentassist/antlr/internal/InternalUmlState.g";
	}



	private UmlStateGrammarAccess grammarAccess;

	public void setGrammarAccess(UmlStateGrammarAccess grammarAccess) {
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




	// $ANTLR start "entryRuleStateRule"
	// InternalUmlState.g:60:1: entryRuleStateRule : ruleStateRule EOF ;
	public final void entryRuleStateRule() throws RecognitionException {
		try {
			// InternalUmlState.g:61:1: ( ruleStateRule EOF )
			// InternalUmlState.g:62:1: ruleStateRule EOF
			{
				before(grammarAccess.getStateRuleRule());
				pushFollow(FOLLOW_1);
				ruleStateRule();

				state._fsp--;

				after(grammarAccess.getStateRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleStateRule"


	// $ANTLR start "ruleStateRule"
	// InternalUmlState.g:69:1: ruleStateRule : ( ( rule__StateRule__Group__0 ) ) ;
	public final void ruleStateRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:73:2: ( ( ( rule__StateRule__Group__0 ) ) )
			// InternalUmlState.g:74:1: ( ( rule__StateRule__Group__0 ) )
			{
				// InternalUmlState.g:74:1: ( ( rule__StateRule__Group__0 ) )
				// InternalUmlState.g:75:1: ( rule__StateRule__Group__0 )
				{
					before(grammarAccess.getStateRuleAccess().getGroup());
					// InternalUmlState.g:76:1: ( rule__StateRule__Group__0 )
					// InternalUmlState.g:76:2: rule__StateRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__StateRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getStateRuleAccess().getGroup());

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
	// $ANTLR end "ruleStateRule"


	// $ANTLR start "entryRuleSubmachineRule"
	// InternalUmlState.g:88:1: entryRuleSubmachineRule : ruleSubmachineRule EOF ;
	public final void entryRuleSubmachineRule() throws RecognitionException {
		try {
			// InternalUmlState.g:89:1: ( ruleSubmachineRule EOF )
			// InternalUmlState.g:90:1: ruleSubmachineRule EOF
			{
				before(grammarAccess.getSubmachineRuleRule());
				pushFollow(FOLLOW_1);
				ruleSubmachineRule();

				state._fsp--;

				after(grammarAccess.getSubmachineRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleSubmachineRule"


	// $ANTLR start "ruleSubmachineRule"
	// InternalUmlState.g:97:1: ruleSubmachineRule : ( ( rule__SubmachineRule__Group__0 ) ) ;
	public final void ruleSubmachineRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:101:2: ( ( ( rule__SubmachineRule__Group__0 ) ) )
			// InternalUmlState.g:102:1: ( ( rule__SubmachineRule__Group__0 ) )
			{
				// InternalUmlState.g:102:1: ( ( rule__SubmachineRule__Group__0 ) )
				// InternalUmlState.g:103:1: ( rule__SubmachineRule__Group__0 )
				{
					before(grammarAccess.getSubmachineRuleAccess().getGroup());
					// InternalUmlState.g:104:1: ( rule__SubmachineRule__Group__0 )
					// InternalUmlState.g:104:2: rule__SubmachineRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__SubmachineRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getSubmachineRuleAccess().getGroup());

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
	// $ANTLR end "ruleSubmachineRule"


	// $ANTLR start "entryRuleQualifiedName"
	// InternalUmlState.g:116:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
	public final void entryRuleQualifiedName() throws RecognitionException {
		try {
			// InternalUmlState.g:117:1: ( ruleQualifiedName EOF )
			// InternalUmlState.g:118:1: ruleQualifiedName EOF
			{
				before(grammarAccess.getQualifiedNameRule());
				pushFollow(FOLLOW_1);
				ruleQualifiedName();

				state._fsp--;

				after(grammarAccess.getQualifiedNameRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleQualifiedName"


	// $ANTLR start "ruleQualifiedName"
	// InternalUmlState.g:125:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
	public final void ruleQualifiedName() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:129:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
			// InternalUmlState.g:130:1: ( ( rule__QualifiedName__Group__0 ) )
			{
				// InternalUmlState.g:130:1: ( ( rule__QualifiedName__Group__0 ) )
				// InternalUmlState.g:131:1: ( rule__QualifiedName__Group__0 )
				{
					before(grammarAccess.getQualifiedNameAccess().getGroup());
					// InternalUmlState.g:132:1: ( rule__QualifiedName__Group__0 )
					// InternalUmlState.g:132:2: rule__QualifiedName__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__QualifiedName__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getQualifiedNameAccess().getGroup());

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
	// $ANTLR end "ruleQualifiedName"


	// $ANTLR start "entryRuleEntryRule"
	// InternalUmlState.g:144:1: entryRuleEntryRule : ruleEntryRule EOF ;
	public final void entryRuleEntryRule() throws RecognitionException {
		try {
			// InternalUmlState.g:145:1: ( ruleEntryRule EOF )
			// InternalUmlState.g:146:1: ruleEntryRule EOF
			{
				before(grammarAccess.getEntryRuleRule());
				pushFollow(FOLLOW_1);
				ruleEntryRule();

				state._fsp--;

				after(grammarAccess.getEntryRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleEntryRule"


	// $ANTLR start "ruleEntryRule"
	// InternalUmlState.g:153:1: ruleEntryRule : ( ( rule__EntryRule__Group__0 ) ) ;
	public final void ruleEntryRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:157:2: ( ( ( rule__EntryRule__Group__0 ) ) )
			// InternalUmlState.g:158:1: ( ( rule__EntryRule__Group__0 ) )
			{
				// InternalUmlState.g:158:1: ( ( rule__EntryRule__Group__0 ) )
				// InternalUmlState.g:159:1: ( rule__EntryRule__Group__0 )
				{
					before(grammarAccess.getEntryRuleAccess().getGroup());
					// InternalUmlState.g:160:1: ( rule__EntryRule__Group__0 )
					// InternalUmlState.g:160:2: rule__EntryRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__EntryRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getEntryRuleAccess().getGroup());

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
	// $ANTLR end "ruleEntryRule"


	// $ANTLR start "entryRuleDoRule"
	// InternalUmlState.g:172:1: entryRuleDoRule : ruleDoRule EOF ;
	public final void entryRuleDoRule() throws RecognitionException {
		try {
			// InternalUmlState.g:173:1: ( ruleDoRule EOF )
			// InternalUmlState.g:174:1: ruleDoRule EOF
			{
				before(grammarAccess.getDoRuleRule());
				pushFollow(FOLLOW_1);
				ruleDoRule();

				state._fsp--;

				after(grammarAccess.getDoRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleDoRule"


	// $ANTLR start "ruleDoRule"
	// InternalUmlState.g:181:1: ruleDoRule : ( ( rule__DoRule__Group__0 ) ) ;
	public final void ruleDoRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:185:2: ( ( ( rule__DoRule__Group__0 ) ) )
			// InternalUmlState.g:186:1: ( ( rule__DoRule__Group__0 ) )
			{
				// InternalUmlState.g:186:1: ( ( rule__DoRule__Group__0 ) )
				// InternalUmlState.g:187:1: ( rule__DoRule__Group__0 )
				{
					before(grammarAccess.getDoRuleAccess().getGroup());
					// InternalUmlState.g:188:1: ( rule__DoRule__Group__0 )
					// InternalUmlState.g:188:2: rule__DoRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__DoRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getDoRuleAccess().getGroup());

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
	// $ANTLR end "ruleDoRule"


	// $ANTLR start "entryRuleExitRule"
	// InternalUmlState.g:200:1: entryRuleExitRule : ruleExitRule EOF ;
	public final void entryRuleExitRule() throws RecognitionException {
		try {
			// InternalUmlState.g:201:1: ( ruleExitRule EOF )
			// InternalUmlState.g:202:1: ruleExitRule EOF
			{
				before(grammarAccess.getExitRuleRule());
				pushFollow(FOLLOW_1);
				ruleExitRule();

				state._fsp--;

				after(grammarAccess.getExitRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleExitRule"


	// $ANTLR start "ruleExitRule"
	// InternalUmlState.g:209:1: ruleExitRule : ( ( rule__ExitRule__Group__0 ) ) ;
	public final void ruleExitRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:213:2: ( ( ( rule__ExitRule__Group__0 ) ) )
			// InternalUmlState.g:214:1: ( ( rule__ExitRule__Group__0 ) )
			{
				// InternalUmlState.g:214:1: ( ( rule__ExitRule__Group__0 ) )
				// InternalUmlState.g:215:1: ( rule__ExitRule__Group__0 )
				{
					before(grammarAccess.getExitRuleAccess().getGroup());
					// InternalUmlState.g:216:1: ( rule__ExitRule__Group__0 )
					// InternalUmlState.g:216:2: rule__ExitRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__ExitRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getExitRuleAccess().getGroup());

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
	// $ANTLR end "ruleExitRule"


	// $ANTLR start "ruleBehaviorKind"
	// InternalUmlState.g:229:1: ruleBehaviorKind : ( ( rule__BehaviorKind__Alternatives ) ) ;
	public final void ruleBehaviorKind() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:233:1: ( ( ( rule__BehaviorKind__Alternatives ) ) )
			// InternalUmlState.g:234:1: ( ( rule__BehaviorKind__Alternatives ) )
			{
				// InternalUmlState.g:234:1: ( ( rule__BehaviorKind__Alternatives ) )
				// InternalUmlState.g:235:1: ( rule__BehaviorKind__Alternatives )
				{
					before(grammarAccess.getBehaviorKindAccess().getAlternatives());
					// InternalUmlState.g:236:1: ( rule__BehaviorKind__Alternatives )
					// InternalUmlState.g:236:2: rule__BehaviorKind__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__BehaviorKind__Alternatives();

						state._fsp--;


					}

					after(grammarAccess.getBehaviorKindAccess().getAlternatives());

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
	// $ANTLR end "ruleBehaviorKind"


	// $ANTLR start "rule__BehaviorKind__Alternatives"
	// InternalUmlState.g:247:1: rule__BehaviorKind__Alternatives : ( ( ( 'Activity' ) ) | ( ( 'StateMachine' ) ) | ( ( 'OpaqueBehavior' ) ) );
	public final void rule__BehaviorKind__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:251:1: ( ( ( 'Activity' ) ) | ( ( 'StateMachine' ) ) | ( ( 'OpaqueBehavior' ) ) )
			int alt1 = 3;
			switch (input.LA(1)) {
			case 12: {
				alt1 = 1;
			}
				break;
			case 13: {
				alt1 = 2;
			}
				break;
			case 14: {
				alt1 = 3;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 1, 0, input);

				throw nvae;
			}

			switch (alt1) {
			case 1:
			// InternalUmlState.g:252:1: ( ( 'Activity' ) )
			{
				// InternalUmlState.g:252:1: ( ( 'Activity' ) )
				// InternalUmlState.g:253:1: ( 'Activity' )
				{
					before(grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0());
					// InternalUmlState.g:254:1: ( 'Activity' )
					// InternalUmlState.g:254:3: 'Activity'
					{
						match(input, 12, FOLLOW_2);

					}

					after(grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0());

				}


			}
				break;
			case 2:
			// InternalUmlState.g:259:6: ( ( 'StateMachine' ) )
			{
				// InternalUmlState.g:259:6: ( ( 'StateMachine' ) )
				// InternalUmlState.g:260:1: ( 'StateMachine' )
				{
					before(grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1());
					// InternalUmlState.g:261:1: ( 'StateMachine' )
					// InternalUmlState.g:261:3: 'StateMachine'
					{
						match(input, 13, FOLLOW_2);

					}

					after(grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1());

				}


			}
				break;
			case 3:
			// InternalUmlState.g:266:6: ( ( 'OpaqueBehavior' ) )
			{
				// InternalUmlState.g:266:6: ( ( 'OpaqueBehavior' ) )
				// InternalUmlState.g:267:1: ( 'OpaqueBehavior' )
				{
					before(grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2());
					// InternalUmlState.g:268:1: ( 'OpaqueBehavior' )
					// InternalUmlState.g:268:3: 'OpaqueBehavior'
					{
						match(input, 14, FOLLOW_2);

					}

					after(grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2());

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
	// $ANTLR end "rule__BehaviorKind__Alternatives"


	// $ANTLR start "rule__StateRule__Group__0"
	// InternalUmlState.g:280:1: rule__StateRule__Group__0 : rule__StateRule__Group__0__Impl rule__StateRule__Group__1 ;
	public final void rule__StateRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:284:1: ( rule__StateRule__Group__0__Impl rule__StateRule__Group__1 )
			// InternalUmlState.g:285:2: rule__StateRule__Group__0__Impl rule__StateRule__Group__1
			{
				pushFollow(FOLLOW_3);
				rule__StateRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__StateRule__Group__1();

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
	// $ANTLR end "rule__StateRule__Group__0"


	// $ANTLR start "rule__StateRule__Group__0__Impl"
	// InternalUmlState.g:292:1: rule__StateRule__Group__0__Impl : ( ( rule__StateRule__NameAssignment_0 ) ) ;
	public final void rule__StateRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:296:1: ( ( ( rule__StateRule__NameAssignment_0 ) ) )
			// InternalUmlState.g:297:1: ( ( rule__StateRule__NameAssignment_0 ) )
			{
				// InternalUmlState.g:297:1: ( ( rule__StateRule__NameAssignment_0 ) )
				// InternalUmlState.g:298:1: ( rule__StateRule__NameAssignment_0 )
				{
					before(grammarAccess.getStateRuleAccess().getNameAssignment_0());
					// InternalUmlState.g:299:1: ( rule__StateRule__NameAssignment_0 )
					// InternalUmlState.g:299:2: rule__StateRule__NameAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__StateRule__NameAssignment_0();

						state._fsp--;


					}

					after(grammarAccess.getStateRuleAccess().getNameAssignment_0());

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
	// $ANTLR end "rule__StateRule__Group__0__Impl"


	// $ANTLR start "rule__StateRule__Group__1"
	// InternalUmlState.g:309:1: rule__StateRule__Group__1 : rule__StateRule__Group__1__Impl rule__StateRule__Group__2 ;
	public final void rule__StateRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:313:1: ( rule__StateRule__Group__1__Impl rule__StateRule__Group__2 )
			// InternalUmlState.g:314:2: rule__StateRule__Group__1__Impl rule__StateRule__Group__2
			{
				pushFollow(FOLLOW_3);
				rule__StateRule__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__StateRule__Group__2();

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
	// $ANTLR end "rule__StateRule__Group__1"


	// $ANTLR start "rule__StateRule__Group__1__Impl"
	// InternalUmlState.g:321:1: rule__StateRule__Group__1__Impl : ( ( rule__StateRule__Group_1__0 )? ) ;
	public final void rule__StateRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:325:1: ( ( ( rule__StateRule__Group_1__0 )? ) )
			// InternalUmlState.g:326:1: ( ( rule__StateRule__Group_1__0 )? )
			{
				// InternalUmlState.g:326:1: ( ( rule__StateRule__Group_1__0 )? )
				// InternalUmlState.g:327:1: ( rule__StateRule__Group_1__0 )?
				{
					before(grammarAccess.getStateRuleAccess().getGroup_1());
					// InternalUmlState.g:328:1: ( rule__StateRule__Group_1__0 )?
					int alt2 = 2;
					int LA2_0 = input.LA(1);

					if ((LA2_0 == 15)) {
						alt2 = 1;
					}
					switch (alt2) {
					case 1:
					// InternalUmlState.g:328:2: rule__StateRule__Group_1__0
					{
						pushFollow(FOLLOW_2);
						rule__StateRule__Group_1__0();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getStateRuleAccess().getGroup_1());

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
	// $ANTLR end "rule__StateRule__Group__1__Impl"


	// $ANTLR start "rule__StateRule__Group__2"
	// InternalUmlState.g:338:1: rule__StateRule__Group__2 : rule__StateRule__Group__2__Impl ;
	public final void rule__StateRule__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:342:1: ( rule__StateRule__Group__2__Impl )
			// InternalUmlState.g:343:2: rule__StateRule__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__StateRule__Group__2__Impl();

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
	// $ANTLR end "rule__StateRule__Group__2"


	// $ANTLR start "rule__StateRule__Group__2__Impl"
	// InternalUmlState.g:349:1: rule__StateRule__Group__2__Impl : ( ( rule__StateRule__UnorderedGroup_2 ) ) ;
	public final void rule__StateRule__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:353:1: ( ( ( rule__StateRule__UnorderedGroup_2 ) ) )
			// InternalUmlState.g:354:1: ( ( rule__StateRule__UnorderedGroup_2 ) )
			{
				// InternalUmlState.g:354:1: ( ( rule__StateRule__UnorderedGroup_2 ) )
				// InternalUmlState.g:355:1: ( rule__StateRule__UnorderedGroup_2 )
				{
					before(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
					// InternalUmlState.g:356:1: ( rule__StateRule__UnorderedGroup_2 )
					// InternalUmlState.g:356:2: rule__StateRule__UnorderedGroup_2
					{
						pushFollow(FOLLOW_2);
						rule__StateRule__UnorderedGroup_2();

						state._fsp--;


					}

					after(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());

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
	// $ANTLR end "rule__StateRule__Group__2__Impl"


	// $ANTLR start "rule__StateRule__Group_1__0"
	// InternalUmlState.g:372:1: rule__StateRule__Group_1__0 : rule__StateRule__Group_1__0__Impl rule__StateRule__Group_1__1 ;
	public final void rule__StateRule__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:376:1: ( rule__StateRule__Group_1__0__Impl rule__StateRule__Group_1__1 )
			// InternalUmlState.g:377:2: rule__StateRule__Group_1__0__Impl rule__StateRule__Group_1__1
			{
				pushFollow(FOLLOW_4);
				rule__StateRule__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__StateRule__Group_1__1();

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
	// $ANTLR end "rule__StateRule__Group_1__0"


	// $ANTLR start "rule__StateRule__Group_1__0__Impl"
	// InternalUmlState.g:384:1: rule__StateRule__Group_1__0__Impl : ( ':' ) ;
	public final void rule__StateRule__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:388:1: ( ( ':' ) )
			// InternalUmlState.g:389:1: ( ':' )
			{
				// InternalUmlState.g:389:1: ( ':' )
				// InternalUmlState.g:390:1: ':'
				{
					before(grammarAccess.getStateRuleAccess().getColonKeyword_1_0());
					match(input, 15, FOLLOW_2);
					after(grammarAccess.getStateRuleAccess().getColonKeyword_1_0());

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
	// $ANTLR end "rule__StateRule__Group_1__0__Impl"


	// $ANTLR start "rule__StateRule__Group_1__1"
	// InternalUmlState.g:403:1: rule__StateRule__Group_1__1 : rule__StateRule__Group_1__1__Impl ;
	public final void rule__StateRule__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:407:1: ( rule__StateRule__Group_1__1__Impl )
			// InternalUmlState.g:408:2: rule__StateRule__Group_1__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__StateRule__Group_1__1__Impl();

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
	// $ANTLR end "rule__StateRule__Group_1__1"


	// $ANTLR start "rule__StateRule__Group_1__1__Impl"
	// InternalUmlState.g:414:1: rule__StateRule__Group_1__1__Impl : ( ( rule__StateRule__SubmachineAssignment_1_1 ) ) ;
	public final void rule__StateRule__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:418:1: ( ( ( rule__StateRule__SubmachineAssignment_1_1 ) ) )
			// InternalUmlState.g:419:1: ( ( rule__StateRule__SubmachineAssignment_1_1 ) )
			{
				// InternalUmlState.g:419:1: ( ( rule__StateRule__SubmachineAssignment_1_1 ) )
				// InternalUmlState.g:420:1: ( rule__StateRule__SubmachineAssignment_1_1 )
				{
					before(grammarAccess.getStateRuleAccess().getSubmachineAssignment_1_1());
					// InternalUmlState.g:421:1: ( rule__StateRule__SubmachineAssignment_1_1 )
					// InternalUmlState.g:421:2: rule__StateRule__SubmachineAssignment_1_1
					{
						pushFollow(FOLLOW_2);
						rule__StateRule__SubmachineAssignment_1_1();

						state._fsp--;


					}

					after(grammarAccess.getStateRuleAccess().getSubmachineAssignment_1_1());

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
	// $ANTLR end "rule__StateRule__Group_1__1__Impl"


	// $ANTLR start "rule__SubmachineRule__Group__0"
	// InternalUmlState.g:435:1: rule__SubmachineRule__Group__0 : rule__SubmachineRule__Group__0__Impl rule__SubmachineRule__Group__1 ;
	public final void rule__SubmachineRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:439:1: ( rule__SubmachineRule__Group__0__Impl rule__SubmachineRule__Group__1 )
			// InternalUmlState.g:440:2: rule__SubmachineRule__Group__0__Impl rule__SubmachineRule__Group__1
			{
				pushFollow(FOLLOW_4);
				rule__SubmachineRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__SubmachineRule__Group__1();

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
	// $ANTLR end "rule__SubmachineRule__Group__0"


	// $ANTLR start "rule__SubmachineRule__Group__0__Impl"
	// InternalUmlState.g:447:1: rule__SubmachineRule__Group__0__Impl : ( ( rule__SubmachineRule__PathAssignment_0 )? ) ;
	public final void rule__SubmachineRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:451:1: ( ( ( rule__SubmachineRule__PathAssignment_0 )? ) )
			// InternalUmlState.g:452:1: ( ( rule__SubmachineRule__PathAssignment_0 )? )
			{
				// InternalUmlState.g:452:1: ( ( rule__SubmachineRule__PathAssignment_0 )? )
				// InternalUmlState.g:453:1: ( rule__SubmachineRule__PathAssignment_0 )?
				{
					before(grammarAccess.getSubmachineRuleAccess().getPathAssignment_0());
					// InternalUmlState.g:454:1: ( rule__SubmachineRule__PathAssignment_0 )?
					int alt3 = 2;
					int LA3_0 = input.LA(1);

					if ((LA3_0 == RULE_ID)) {
						int LA3_1 = input.LA(2);

						if ((LA3_1 == 16)) {
							alt3 = 1;
						}
					}
					switch (alt3) {
					case 1:
					// InternalUmlState.g:454:2: rule__SubmachineRule__PathAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__SubmachineRule__PathAssignment_0();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getSubmachineRuleAccess().getPathAssignment_0());

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
	// $ANTLR end "rule__SubmachineRule__Group__0__Impl"


	// $ANTLR start "rule__SubmachineRule__Group__1"
	// InternalUmlState.g:464:1: rule__SubmachineRule__Group__1 : rule__SubmachineRule__Group__1__Impl ;
	public final void rule__SubmachineRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:468:1: ( rule__SubmachineRule__Group__1__Impl )
			// InternalUmlState.g:469:2: rule__SubmachineRule__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__SubmachineRule__Group__1__Impl();

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
	// $ANTLR end "rule__SubmachineRule__Group__1"


	// $ANTLR start "rule__SubmachineRule__Group__1__Impl"
	// InternalUmlState.g:475:1: rule__SubmachineRule__Group__1__Impl : ( ( rule__SubmachineRule__SubmachineAssignment_1 ) ) ;
	public final void rule__SubmachineRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:479:1: ( ( ( rule__SubmachineRule__SubmachineAssignment_1 ) ) )
			// InternalUmlState.g:480:1: ( ( rule__SubmachineRule__SubmachineAssignment_1 ) )
			{
				// InternalUmlState.g:480:1: ( ( rule__SubmachineRule__SubmachineAssignment_1 ) )
				// InternalUmlState.g:481:1: ( rule__SubmachineRule__SubmachineAssignment_1 )
				{
					before(grammarAccess.getSubmachineRuleAccess().getSubmachineAssignment_1());
					// InternalUmlState.g:482:1: ( rule__SubmachineRule__SubmachineAssignment_1 )
					// InternalUmlState.g:482:2: rule__SubmachineRule__SubmachineAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__SubmachineRule__SubmachineAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getSubmachineRuleAccess().getSubmachineAssignment_1());

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
	// $ANTLR end "rule__SubmachineRule__Group__1__Impl"


	// $ANTLR start "rule__QualifiedName__Group__0"
	// InternalUmlState.g:496:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
	public final void rule__QualifiedName__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:500:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
			// InternalUmlState.g:501:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
			{
				pushFollow(FOLLOW_5);
				rule__QualifiedName__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__QualifiedName__Group__1();

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
	// $ANTLR end "rule__QualifiedName__Group__0"


	// $ANTLR start "rule__QualifiedName__Group__0__Impl"
	// InternalUmlState.g:508:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
	public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:512:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
			// InternalUmlState.g:513:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
			{
				// InternalUmlState.g:513:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
				// InternalUmlState.g:514:1: ( rule__QualifiedName__PathAssignment_0 )
				{
					before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0());
					// InternalUmlState.g:515:1: ( rule__QualifiedName__PathAssignment_0 )
					// InternalUmlState.g:515:2: rule__QualifiedName__PathAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__QualifiedName__PathAssignment_0();

						state._fsp--;


					}

					after(grammarAccess.getQualifiedNameAccess().getPathAssignment_0());

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
	// $ANTLR end "rule__QualifiedName__Group__0__Impl"


	// $ANTLR start "rule__QualifiedName__Group__1"
	// InternalUmlState.g:525:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
	public final void rule__QualifiedName__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:529:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
			// InternalUmlState.g:530:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
			{
				pushFollow(FOLLOW_4);
				rule__QualifiedName__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__QualifiedName__Group__2();

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
	// $ANTLR end "rule__QualifiedName__Group__1"


	// $ANTLR start "rule__QualifiedName__Group__1__Impl"
	// InternalUmlState.g:537:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
	public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:541:1: ( ( '::' ) )
			// InternalUmlState.g:542:1: ( '::' )
			{
				// InternalUmlState.g:542:1: ( '::' )
				// InternalUmlState.g:543:1: '::'
				{
					before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());
					match(input, 16, FOLLOW_2);
					after(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());

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
	// $ANTLR end "rule__QualifiedName__Group__1__Impl"


	// $ANTLR start "rule__QualifiedName__Group__2"
	// InternalUmlState.g:556:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
	public final void rule__QualifiedName__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:560:1: ( rule__QualifiedName__Group__2__Impl )
			// InternalUmlState.g:561:2: rule__QualifiedName__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__QualifiedName__Group__2__Impl();

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
	// $ANTLR end "rule__QualifiedName__Group__2"


	// $ANTLR start "rule__QualifiedName__Group__2__Impl"
	// InternalUmlState.g:567:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
	public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:571:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
			// InternalUmlState.g:572:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
			{
				// InternalUmlState.g:572:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
				// InternalUmlState.g:573:1: ( rule__QualifiedName__RemainingAssignment_2 )?
				{
					before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2());
					// InternalUmlState.g:574:1: ( rule__QualifiedName__RemainingAssignment_2 )?
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if ((LA4_0 == RULE_ID)) {
						int LA4_1 = input.LA(2);

						if ((LA4_1 == 16)) {
							alt4 = 1;
						}
					}
					switch (alt4) {
					case 1:
					// InternalUmlState.g:574:2: rule__QualifiedName__RemainingAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__QualifiedName__RemainingAssignment_2();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2());

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
	// $ANTLR end "rule__QualifiedName__Group__2__Impl"


	// $ANTLR start "rule__EntryRule__Group__0"
	// InternalUmlState.g:590:1: rule__EntryRule__Group__0 : rule__EntryRule__Group__0__Impl rule__EntryRule__Group__1 ;
	public final void rule__EntryRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:594:1: ( rule__EntryRule__Group__0__Impl rule__EntryRule__Group__1 )
			// InternalUmlState.g:595:2: rule__EntryRule__Group__0__Impl rule__EntryRule__Group__1
			{
				pushFollow(FOLLOW_6);
				rule__EntryRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__EntryRule__Group__1();

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
	// $ANTLR end "rule__EntryRule__Group__0"


	// $ANTLR start "rule__EntryRule__Group__0__Impl"
	// InternalUmlState.g:602:1: rule__EntryRule__Group__0__Impl : ( 'entry' ) ;
	public final void rule__EntryRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:606:1: ( ( 'entry' ) )
			// InternalUmlState.g:607:1: ( 'entry' )
			{
				// InternalUmlState.g:607:1: ( 'entry' )
				// InternalUmlState.g:608:1: 'entry'
				{
					before(grammarAccess.getEntryRuleAccess().getEntryKeyword_0());
					match(input, 17, FOLLOW_2);
					after(grammarAccess.getEntryRuleAccess().getEntryKeyword_0());

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
	// $ANTLR end "rule__EntryRule__Group__0__Impl"


	// $ANTLR start "rule__EntryRule__Group__1"
	// InternalUmlState.g:621:1: rule__EntryRule__Group__1 : rule__EntryRule__Group__1__Impl rule__EntryRule__Group__2 ;
	public final void rule__EntryRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:625:1: ( rule__EntryRule__Group__1__Impl rule__EntryRule__Group__2 )
			// InternalUmlState.g:626:2: rule__EntryRule__Group__1__Impl rule__EntryRule__Group__2
			{
				pushFollow(FOLLOW_4);
				rule__EntryRule__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__EntryRule__Group__2();

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
	// $ANTLR end "rule__EntryRule__Group__1"


	// $ANTLR start "rule__EntryRule__Group__1__Impl"
	// InternalUmlState.g:633:1: rule__EntryRule__Group__1__Impl : ( ( rule__EntryRule__KindAssignment_1 ) ) ;
	public final void rule__EntryRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:637:1: ( ( ( rule__EntryRule__KindAssignment_1 ) ) )
			// InternalUmlState.g:638:1: ( ( rule__EntryRule__KindAssignment_1 ) )
			{
				// InternalUmlState.g:638:1: ( ( rule__EntryRule__KindAssignment_1 ) )
				// InternalUmlState.g:639:1: ( rule__EntryRule__KindAssignment_1 )
				{
					before(grammarAccess.getEntryRuleAccess().getKindAssignment_1());
					// InternalUmlState.g:640:1: ( rule__EntryRule__KindAssignment_1 )
					// InternalUmlState.g:640:2: rule__EntryRule__KindAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__EntryRule__KindAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getEntryRuleAccess().getKindAssignment_1());

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
	// $ANTLR end "rule__EntryRule__Group__1__Impl"


	// $ANTLR start "rule__EntryRule__Group__2"
	// InternalUmlState.g:650:1: rule__EntryRule__Group__2 : rule__EntryRule__Group__2__Impl ;
	public final void rule__EntryRule__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:654:1: ( rule__EntryRule__Group__2__Impl )
			// InternalUmlState.g:655:2: rule__EntryRule__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__EntryRule__Group__2__Impl();

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
	// $ANTLR end "rule__EntryRule__Group__2"


	// $ANTLR start "rule__EntryRule__Group__2__Impl"
	// InternalUmlState.g:661:1: rule__EntryRule__Group__2__Impl : ( ( rule__EntryRule__BehaviorNameAssignment_2 ) ) ;
	public final void rule__EntryRule__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:665:1: ( ( ( rule__EntryRule__BehaviorNameAssignment_2 ) ) )
			// InternalUmlState.g:666:1: ( ( rule__EntryRule__BehaviorNameAssignment_2 ) )
			{
				// InternalUmlState.g:666:1: ( ( rule__EntryRule__BehaviorNameAssignment_2 ) )
				// InternalUmlState.g:667:1: ( rule__EntryRule__BehaviorNameAssignment_2 )
				{
					before(grammarAccess.getEntryRuleAccess().getBehaviorNameAssignment_2());
					// InternalUmlState.g:668:1: ( rule__EntryRule__BehaviorNameAssignment_2 )
					// InternalUmlState.g:668:2: rule__EntryRule__BehaviorNameAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__EntryRule__BehaviorNameAssignment_2();

						state._fsp--;


					}

					after(grammarAccess.getEntryRuleAccess().getBehaviorNameAssignment_2());

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
	// $ANTLR end "rule__EntryRule__Group__2__Impl"


	// $ANTLR start "rule__DoRule__Group__0"
	// InternalUmlState.g:684:1: rule__DoRule__Group__0 : rule__DoRule__Group__0__Impl rule__DoRule__Group__1 ;
	public final void rule__DoRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:688:1: ( rule__DoRule__Group__0__Impl rule__DoRule__Group__1 )
			// InternalUmlState.g:689:2: rule__DoRule__Group__0__Impl rule__DoRule__Group__1
			{
				pushFollow(FOLLOW_6);
				rule__DoRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__DoRule__Group__1();

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
	// $ANTLR end "rule__DoRule__Group__0"


	// $ANTLR start "rule__DoRule__Group__0__Impl"
	// InternalUmlState.g:696:1: rule__DoRule__Group__0__Impl : ( 'do' ) ;
	public final void rule__DoRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:700:1: ( ( 'do' ) )
			// InternalUmlState.g:701:1: ( 'do' )
			{
				// InternalUmlState.g:701:1: ( 'do' )
				// InternalUmlState.g:702:1: 'do'
				{
					before(grammarAccess.getDoRuleAccess().getDoKeyword_0());
					match(input, 18, FOLLOW_2);
					after(grammarAccess.getDoRuleAccess().getDoKeyword_0());

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
	// $ANTLR end "rule__DoRule__Group__0__Impl"


	// $ANTLR start "rule__DoRule__Group__1"
	// InternalUmlState.g:715:1: rule__DoRule__Group__1 : rule__DoRule__Group__1__Impl rule__DoRule__Group__2 ;
	public final void rule__DoRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:719:1: ( rule__DoRule__Group__1__Impl rule__DoRule__Group__2 )
			// InternalUmlState.g:720:2: rule__DoRule__Group__1__Impl rule__DoRule__Group__2
			{
				pushFollow(FOLLOW_4);
				rule__DoRule__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__DoRule__Group__2();

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
	// $ANTLR end "rule__DoRule__Group__1"


	// $ANTLR start "rule__DoRule__Group__1__Impl"
	// InternalUmlState.g:727:1: rule__DoRule__Group__1__Impl : ( ( rule__DoRule__KindAssignment_1 ) ) ;
	public final void rule__DoRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:731:1: ( ( ( rule__DoRule__KindAssignment_1 ) ) )
			// InternalUmlState.g:732:1: ( ( rule__DoRule__KindAssignment_1 ) )
			{
				// InternalUmlState.g:732:1: ( ( rule__DoRule__KindAssignment_1 ) )
				// InternalUmlState.g:733:1: ( rule__DoRule__KindAssignment_1 )
				{
					before(grammarAccess.getDoRuleAccess().getKindAssignment_1());
					// InternalUmlState.g:734:1: ( rule__DoRule__KindAssignment_1 )
					// InternalUmlState.g:734:2: rule__DoRule__KindAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__DoRule__KindAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getDoRuleAccess().getKindAssignment_1());

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
	// $ANTLR end "rule__DoRule__Group__1__Impl"


	// $ANTLR start "rule__DoRule__Group__2"
	// InternalUmlState.g:744:1: rule__DoRule__Group__2 : rule__DoRule__Group__2__Impl ;
	public final void rule__DoRule__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:748:1: ( rule__DoRule__Group__2__Impl )
			// InternalUmlState.g:749:2: rule__DoRule__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__DoRule__Group__2__Impl();

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
	// $ANTLR end "rule__DoRule__Group__2"


	// $ANTLR start "rule__DoRule__Group__2__Impl"
	// InternalUmlState.g:755:1: rule__DoRule__Group__2__Impl : ( ( rule__DoRule__BehaviorNameAssignment_2 ) ) ;
	public final void rule__DoRule__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:759:1: ( ( ( rule__DoRule__BehaviorNameAssignment_2 ) ) )
			// InternalUmlState.g:760:1: ( ( rule__DoRule__BehaviorNameAssignment_2 ) )
			{
				// InternalUmlState.g:760:1: ( ( rule__DoRule__BehaviorNameAssignment_2 ) )
				// InternalUmlState.g:761:1: ( rule__DoRule__BehaviorNameAssignment_2 )
				{
					before(grammarAccess.getDoRuleAccess().getBehaviorNameAssignment_2());
					// InternalUmlState.g:762:1: ( rule__DoRule__BehaviorNameAssignment_2 )
					// InternalUmlState.g:762:2: rule__DoRule__BehaviorNameAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__DoRule__BehaviorNameAssignment_2();

						state._fsp--;


					}

					after(grammarAccess.getDoRuleAccess().getBehaviorNameAssignment_2());

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
	// $ANTLR end "rule__DoRule__Group__2__Impl"


	// $ANTLR start "rule__ExitRule__Group__0"
	// InternalUmlState.g:778:1: rule__ExitRule__Group__0 : rule__ExitRule__Group__0__Impl rule__ExitRule__Group__1 ;
	public final void rule__ExitRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:782:1: ( rule__ExitRule__Group__0__Impl rule__ExitRule__Group__1 )
			// InternalUmlState.g:783:2: rule__ExitRule__Group__0__Impl rule__ExitRule__Group__1
			{
				pushFollow(FOLLOW_6);
				rule__ExitRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ExitRule__Group__1();

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
	// $ANTLR end "rule__ExitRule__Group__0"


	// $ANTLR start "rule__ExitRule__Group__0__Impl"
	// InternalUmlState.g:790:1: rule__ExitRule__Group__0__Impl : ( 'exit' ) ;
	public final void rule__ExitRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:794:1: ( ( 'exit' ) )
			// InternalUmlState.g:795:1: ( 'exit' )
			{
				// InternalUmlState.g:795:1: ( 'exit' )
				// InternalUmlState.g:796:1: 'exit'
				{
					before(grammarAccess.getExitRuleAccess().getExitKeyword_0());
					match(input, 19, FOLLOW_2);
					after(grammarAccess.getExitRuleAccess().getExitKeyword_0());

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
	// $ANTLR end "rule__ExitRule__Group__0__Impl"


	// $ANTLR start "rule__ExitRule__Group__1"
	// InternalUmlState.g:809:1: rule__ExitRule__Group__1 : rule__ExitRule__Group__1__Impl rule__ExitRule__Group__2 ;
	public final void rule__ExitRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:813:1: ( rule__ExitRule__Group__1__Impl rule__ExitRule__Group__2 )
			// InternalUmlState.g:814:2: rule__ExitRule__Group__1__Impl rule__ExitRule__Group__2
			{
				pushFollow(FOLLOW_4);
				rule__ExitRule__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ExitRule__Group__2();

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
	// $ANTLR end "rule__ExitRule__Group__1"


	// $ANTLR start "rule__ExitRule__Group__1__Impl"
	// InternalUmlState.g:821:1: rule__ExitRule__Group__1__Impl : ( ( rule__ExitRule__KindAssignment_1 ) ) ;
	public final void rule__ExitRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:825:1: ( ( ( rule__ExitRule__KindAssignment_1 ) ) )
			// InternalUmlState.g:826:1: ( ( rule__ExitRule__KindAssignment_1 ) )
			{
				// InternalUmlState.g:826:1: ( ( rule__ExitRule__KindAssignment_1 ) )
				// InternalUmlState.g:827:1: ( rule__ExitRule__KindAssignment_1 )
				{
					before(grammarAccess.getExitRuleAccess().getKindAssignment_1());
					// InternalUmlState.g:828:1: ( rule__ExitRule__KindAssignment_1 )
					// InternalUmlState.g:828:2: rule__ExitRule__KindAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__ExitRule__KindAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getExitRuleAccess().getKindAssignment_1());

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
	// $ANTLR end "rule__ExitRule__Group__1__Impl"


	// $ANTLR start "rule__ExitRule__Group__2"
	// InternalUmlState.g:838:1: rule__ExitRule__Group__2 : rule__ExitRule__Group__2__Impl ;
	public final void rule__ExitRule__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:842:1: ( rule__ExitRule__Group__2__Impl )
			// InternalUmlState.g:843:2: rule__ExitRule__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__ExitRule__Group__2__Impl();

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
	// $ANTLR end "rule__ExitRule__Group__2"


	// $ANTLR start "rule__ExitRule__Group__2__Impl"
	// InternalUmlState.g:849:1: rule__ExitRule__Group__2__Impl : ( ( rule__ExitRule__BehaviorNameAssignment_2 ) ) ;
	public final void rule__ExitRule__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:853:1: ( ( ( rule__ExitRule__BehaviorNameAssignment_2 ) ) )
			// InternalUmlState.g:854:1: ( ( rule__ExitRule__BehaviorNameAssignment_2 ) )
			{
				// InternalUmlState.g:854:1: ( ( rule__ExitRule__BehaviorNameAssignment_2 ) )
				// InternalUmlState.g:855:1: ( rule__ExitRule__BehaviorNameAssignment_2 )
				{
					before(grammarAccess.getExitRuleAccess().getBehaviorNameAssignment_2());
					// InternalUmlState.g:856:1: ( rule__ExitRule__BehaviorNameAssignment_2 )
					// InternalUmlState.g:856:2: rule__ExitRule__BehaviorNameAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__ExitRule__BehaviorNameAssignment_2();

						state._fsp--;


					}

					after(grammarAccess.getExitRuleAccess().getBehaviorNameAssignment_2());

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
	// $ANTLR end "rule__ExitRule__Group__2__Impl"


	// $ANTLR start "rule__StateRule__UnorderedGroup_2"
	// InternalUmlState.g:873:1: rule__StateRule__UnorderedGroup_2 : ( rule__StateRule__UnorderedGroup_2__0 )? ;
	public final void rule__StateRule__UnorderedGroup_2() throws RecognitionException {

		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());

		try {
			// InternalUmlState.g:878:1: ( ( rule__StateRule__UnorderedGroup_2__0 )? )
			// InternalUmlState.g:879:2: ( rule__StateRule__UnorderedGroup_2__0 )?
			{
				// InternalUmlState.g:879:2: ( rule__StateRule__UnorderedGroup_2__0 )?
				int alt5 = 2;
				int LA5_0 = input.LA(1);

				if (LA5_0 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0)) {
					alt5 = 1;
				} else if (LA5_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1)) {
					alt5 = 1;
				} else if (LA5_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2)) {
					alt5 = 1;
				}
				switch (alt5) {
				case 1:
				// InternalUmlState.g:879:2: rule__StateRule__UnorderedGroup_2__0
				{
					pushFollow(FOLLOW_2);
					rule__StateRule__UnorderedGroup_2__0();

					state._fsp--;


				}
					break;

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			getUnorderedGroupHelper().leave(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StateRule__UnorderedGroup_2"


	// $ANTLR start "rule__StateRule__UnorderedGroup_2__Impl"
	// InternalUmlState.g:889:1: rule__StateRule__UnorderedGroup_2__Impl : ( ({...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) )
	// ) ) ;
	public final void rule__StateRule__UnorderedGroup_2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();
		boolean selected = false;

		try {
			// InternalUmlState.g:894:1: ( ( ({...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) ) ) ) )
			// InternalUmlState.g:895:3: ( ({...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) ) ) )
			{
				// InternalUmlState.g:895:3: ( ({...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) ) ) )
				int alt6 = 3;
				int LA6_0 = input.LA(1);

				if (LA6_0 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0)) {
					alt6 = 1;
				} else if (LA6_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1)) {
					alt6 = 2;
				} else if (LA6_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2)) {
					alt6 = 3;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 6, 0, input);

					throw nvae;
				}
				switch (alt6) {
				case 1:
				// InternalUmlState.g:897:4: ({...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) ) )
				{
					// InternalUmlState.g:897:4: ({...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) ) )
					// InternalUmlState.g:898:5: {...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) )
					{
						if (!getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0)) {
							throw new FailedPredicateException(input, "rule__StateRule__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0)");
						}
						// InternalUmlState.g:898:106: ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) )
						// InternalUmlState.g:899:6: ( ( rule__StateRule__EntryAssignment_2_0 ) )
						{

							getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0);


							selected = true;

							// InternalUmlState.g:905:6: ( ( rule__StateRule__EntryAssignment_2_0 ) )
							// InternalUmlState.g:907:7: ( rule__StateRule__EntryAssignment_2_0 )
							{
								before(grammarAccess.getStateRuleAccess().getEntryAssignment_2_0());
								// InternalUmlState.g:908:7: ( rule__StateRule__EntryAssignment_2_0 )
								// InternalUmlState.g:908:8: rule__StateRule__EntryAssignment_2_0
								{
									pushFollow(FOLLOW_2);
									rule__StateRule__EntryAssignment_2_0();

									state._fsp--;


								}

								after(grammarAccess.getStateRuleAccess().getEntryAssignment_2_0());

							}


						}


					}


				}
					break;
				case 2:
				// InternalUmlState.g:914:4: ({...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) ) )
				{
					// InternalUmlState.g:914:4: ({...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) ) )
					// InternalUmlState.g:915:5: {...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) )
					{
						if (!getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1)) {
							throw new FailedPredicateException(input, "rule__StateRule__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1)");
						}
						// InternalUmlState.g:915:106: ( ( ( rule__StateRule__DoAssignment_2_1 ) ) )
						// InternalUmlState.g:916:6: ( ( rule__StateRule__DoAssignment_2_1 ) )
						{

							getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1);


							selected = true;

							// InternalUmlState.g:922:6: ( ( rule__StateRule__DoAssignment_2_1 ) )
							// InternalUmlState.g:924:7: ( rule__StateRule__DoAssignment_2_1 )
							{
								before(grammarAccess.getStateRuleAccess().getDoAssignment_2_1());
								// InternalUmlState.g:925:7: ( rule__StateRule__DoAssignment_2_1 )
								// InternalUmlState.g:925:8: rule__StateRule__DoAssignment_2_1
								{
									pushFollow(FOLLOW_2);
									rule__StateRule__DoAssignment_2_1();

									state._fsp--;


								}

								after(grammarAccess.getStateRuleAccess().getDoAssignment_2_1());

							}


						}


					}


				}
					break;
				case 3:
				// InternalUmlState.g:931:4: ({...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) ) )
				{
					// InternalUmlState.g:931:4: ({...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) ) )
					// InternalUmlState.g:932:5: {...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) )
					{
						if (!getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2)) {
							throw new FailedPredicateException(input, "rule__StateRule__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2)");
						}
						// InternalUmlState.g:932:106: ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) )
						// InternalUmlState.g:933:6: ( ( rule__StateRule__ExitAssignment_2_2 ) )
						{

							getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2);


							selected = true;

							// InternalUmlState.g:939:6: ( ( rule__StateRule__ExitAssignment_2_2 ) )
							// InternalUmlState.g:941:7: ( rule__StateRule__ExitAssignment_2_2 )
							{
								before(grammarAccess.getStateRuleAccess().getExitAssignment_2_2());
								// InternalUmlState.g:942:7: ( rule__StateRule__ExitAssignment_2_2 )
								// InternalUmlState.g:942:8: rule__StateRule__ExitAssignment_2_2
								{
									pushFollow(FOLLOW_2);
									rule__StateRule__ExitAssignment_2_2();

									state._fsp--;


								}

								after(grammarAccess.getStateRuleAccess().getExitAssignment_2_2());

							}


						}


					}


				}
					break;

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			if (selected)
				getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StateRule__UnorderedGroup_2__Impl"


	// $ANTLR start "rule__StateRule__UnorderedGroup_2__0"
	// InternalUmlState.g:957:1: rule__StateRule__UnorderedGroup_2__0 : rule__StateRule__UnorderedGroup_2__Impl ( rule__StateRule__UnorderedGroup_2__1 )? ;
	public final void rule__StateRule__UnorderedGroup_2__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:961:1: ( rule__StateRule__UnorderedGroup_2__Impl ( rule__StateRule__UnorderedGroup_2__1 )? )
			// InternalUmlState.g:962:2: rule__StateRule__UnorderedGroup_2__Impl ( rule__StateRule__UnorderedGroup_2__1 )?
			{
				pushFollow(FOLLOW_7);
				rule__StateRule__UnorderedGroup_2__Impl();

				state._fsp--;

				// InternalUmlState.g:963:2: ( rule__StateRule__UnorderedGroup_2__1 )?
				int alt7 = 2;
				int LA7_0 = input.LA(1);

				if (LA7_0 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0)) {
					alt7 = 1;
				} else if (LA7_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1)) {
					alt7 = 1;
				} else if (LA7_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2)) {
					alt7 = 1;
				}
				switch (alt7) {
				case 1:
				// InternalUmlState.g:963:2: rule__StateRule__UnorderedGroup_2__1
				{
					pushFollow(FOLLOW_2);
					rule__StateRule__UnorderedGroup_2__1();

					state._fsp--;


				}
					break;

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
	// $ANTLR end "rule__StateRule__UnorderedGroup_2__0"


	// $ANTLR start "rule__StateRule__UnorderedGroup_2__1"
	// InternalUmlState.g:970:1: rule__StateRule__UnorderedGroup_2__1 : rule__StateRule__UnorderedGroup_2__Impl ( rule__StateRule__UnorderedGroup_2__2 )? ;
	public final void rule__StateRule__UnorderedGroup_2__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:974:1: ( rule__StateRule__UnorderedGroup_2__Impl ( rule__StateRule__UnorderedGroup_2__2 )? )
			// InternalUmlState.g:975:2: rule__StateRule__UnorderedGroup_2__Impl ( rule__StateRule__UnorderedGroup_2__2 )?
			{
				pushFollow(FOLLOW_7);
				rule__StateRule__UnorderedGroup_2__Impl();

				state._fsp--;

				// InternalUmlState.g:976:2: ( rule__StateRule__UnorderedGroup_2__2 )?
				int alt8 = 2;
				int LA8_0 = input.LA(1);

				if (LA8_0 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0)) {
					alt8 = 1;
				} else if (LA8_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1)) {
					alt8 = 1;
				} else if (LA8_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2)) {
					alt8 = 1;
				}
				switch (alt8) {
				case 1:
				// InternalUmlState.g:976:2: rule__StateRule__UnorderedGroup_2__2
				{
					pushFollow(FOLLOW_2);
					rule__StateRule__UnorderedGroup_2__2();

					state._fsp--;


				}
					break;

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
	// $ANTLR end "rule__StateRule__UnorderedGroup_2__1"


	// $ANTLR start "rule__StateRule__UnorderedGroup_2__2"
	// InternalUmlState.g:983:1: rule__StateRule__UnorderedGroup_2__2 : rule__StateRule__UnorderedGroup_2__Impl ;
	public final void rule__StateRule__UnorderedGroup_2__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:987:1: ( rule__StateRule__UnorderedGroup_2__Impl )
			// InternalUmlState.g:988:2: rule__StateRule__UnorderedGroup_2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__StateRule__UnorderedGroup_2__Impl();

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
	// $ANTLR end "rule__StateRule__UnorderedGroup_2__2"


	// $ANTLR start "rule__StateRule__NameAssignment_0"
	// InternalUmlState.g:1001:1: rule__StateRule__NameAssignment_0 : ( RULE_ID ) ;
	public final void rule__StateRule__NameAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1005:1: ( ( RULE_ID ) )
			// InternalUmlState.g:1006:1: ( RULE_ID )
			{
				// InternalUmlState.g:1006:1: ( RULE_ID )
				// InternalUmlState.g:1007:1: RULE_ID
				{
					before(grammarAccess.getStateRuleAccess().getNameIDTerminalRuleCall_0_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getStateRuleAccess().getNameIDTerminalRuleCall_0_0());

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
	// $ANTLR end "rule__StateRule__NameAssignment_0"


	// $ANTLR start "rule__StateRule__SubmachineAssignment_1_1"
	// InternalUmlState.g:1016:1: rule__StateRule__SubmachineAssignment_1_1 : ( ruleSubmachineRule ) ;
	public final void rule__StateRule__SubmachineAssignment_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1020:1: ( ( ruleSubmachineRule ) )
			// InternalUmlState.g:1021:1: ( ruleSubmachineRule )
			{
				// InternalUmlState.g:1021:1: ( ruleSubmachineRule )
				// InternalUmlState.g:1022:1: ruleSubmachineRule
				{
					before(grammarAccess.getStateRuleAccess().getSubmachineSubmachineRuleParserRuleCall_1_1_0());
					pushFollow(FOLLOW_2);
					ruleSubmachineRule();

					state._fsp--;

					after(grammarAccess.getStateRuleAccess().getSubmachineSubmachineRuleParserRuleCall_1_1_0());

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
	// $ANTLR end "rule__StateRule__SubmachineAssignment_1_1"


	// $ANTLR start "rule__StateRule__EntryAssignment_2_0"
	// InternalUmlState.g:1031:1: rule__StateRule__EntryAssignment_2_0 : ( ruleEntryRule ) ;
	public final void rule__StateRule__EntryAssignment_2_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1035:1: ( ( ruleEntryRule ) )
			// InternalUmlState.g:1036:1: ( ruleEntryRule )
			{
				// InternalUmlState.g:1036:1: ( ruleEntryRule )
				// InternalUmlState.g:1037:1: ruleEntryRule
				{
					before(grammarAccess.getStateRuleAccess().getEntryEntryRuleParserRuleCall_2_0_0());
					pushFollow(FOLLOW_2);
					ruleEntryRule();

					state._fsp--;

					after(grammarAccess.getStateRuleAccess().getEntryEntryRuleParserRuleCall_2_0_0());

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
	// $ANTLR end "rule__StateRule__EntryAssignment_2_0"


	// $ANTLR start "rule__StateRule__DoAssignment_2_1"
	// InternalUmlState.g:1046:1: rule__StateRule__DoAssignment_2_1 : ( ruleDoRule ) ;
	public final void rule__StateRule__DoAssignment_2_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1050:1: ( ( ruleDoRule ) )
			// InternalUmlState.g:1051:1: ( ruleDoRule )
			{
				// InternalUmlState.g:1051:1: ( ruleDoRule )
				// InternalUmlState.g:1052:1: ruleDoRule
				{
					before(grammarAccess.getStateRuleAccess().getDoDoRuleParserRuleCall_2_1_0());
					pushFollow(FOLLOW_2);
					ruleDoRule();

					state._fsp--;

					after(grammarAccess.getStateRuleAccess().getDoDoRuleParserRuleCall_2_1_0());

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
	// $ANTLR end "rule__StateRule__DoAssignment_2_1"


	// $ANTLR start "rule__StateRule__ExitAssignment_2_2"
	// InternalUmlState.g:1061:1: rule__StateRule__ExitAssignment_2_2 : ( ruleExitRule ) ;
	public final void rule__StateRule__ExitAssignment_2_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1065:1: ( ( ruleExitRule ) )
			// InternalUmlState.g:1066:1: ( ruleExitRule )
			{
				// InternalUmlState.g:1066:1: ( ruleExitRule )
				// InternalUmlState.g:1067:1: ruleExitRule
				{
					before(grammarAccess.getStateRuleAccess().getExitExitRuleParserRuleCall_2_2_0());
					pushFollow(FOLLOW_2);
					ruleExitRule();

					state._fsp--;

					after(grammarAccess.getStateRuleAccess().getExitExitRuleParserRuleCall_2_2_0());

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
	// $ANTLR end "rule__StateRule__ExitAssignment_2_2"


	// $ANTLR start "rule__SubmachineRule__PathAssignment_0"
	// InternalUmlState.g:1076:1: rule__SubmachineRule__PathAssignment_0 : ( ruleQualifiedName ) ;
	public final void rule__SubmachineRule__PathAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1080:1: ( ( ruleQualifiedName ) )
			// InternalUmlState.g:1081:1: ( ruleQualifiedName )
			{
				// InternalUmlState.g:1081:1: ( ruleQualifiedName )
				// InternalUmlState.g:1082:1: ruleQualifiedName
				{
					before(grammarAccess.getSubmachineRuleAccess().getPathQualifiedNameParserRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleQualifiedName();

					state._fsp--;

					after(grammarAccess.getSubmachineRuleAccess().getPathQualifiedNameParserRuleCall_0_0());

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
	// $ANTLR end "rule__SubmachineRule__PathAssignment_0"


	// $ANTLR start "rule__SubmachineRule__SubmachineAssignment_1"
	// InternalUmlState.g:1091:1: rule__SubmachineRule__SubmachineAssignment_1 : ( ( RULE_ID ) ) ;
	public final void rule__SubmachineRule__SubmachineAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1095:1: ( ( ( RULE_ID ) ) )
			// InternalUmlState.g:1096:1: ( ( RULE_ID ) )
			{
				// InternalUmlState.g:1096:1: ( ( RULE_ID ) )
				// InternalUmlState.g:1097:1: ( RULE_ID )
				{
					before(grammarAccess.getSubmachineRuleAccess().getSubmachineStateMachineCrossReference_1_0());
					// InternalUmlState.g:1098:1: ( RULE_ID )
					// InternalUmlState.g:1099:1: RULE_ID
					{
						before(grammarAccess.getSubmachineRuleAccess().getSubmachineStateMachineIDTerminalRuleCall_1_0_1());
						match(input, RULE_ID, FOLLOW_2);
						after(grammarAccess.getSubmachineRuleAccess().getSubmachineStateMachineIDTerminalRuleCall_1_0_1());

					}

					after(grammarAccess.getSubmachineRuleAccess().getSubmachineStateMachineCrossReference_1_0());

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
	// $ANTLR end "rule__SubmachineRule__SubmachineAssignment_1"


	// $ANTLR start "rule__QualifiedName__PathAssignment_0"
	// InternalUmlState.g:1110:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
	public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1114:1: ( ( ( RULE_ID ) ) )
			// InternalUmlState.g:1115:1: ( ( RULE_ID ) )
			{
				// InternalUmlState.g:1115:1: ( ( RULE_ID ) )
				// InternalUmlState.g:1116:1: ( RULE_ID )
				{
					before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0());
					// InternalUmlState.g:1117:1: ( RULE_ID )
					// InternalUmlState.g:1118:1: RULE_ID
					{
						before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1());
						match(input, RULE_ID, FOLLOW_2);
						after(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1());

					}

					after(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0());

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
	// $ANTLR end "rule__QualifiedName__PathAssignment_0"


	// $ANTLR start "rule__QualifiedName__RemainingAssignment_2"
	// InternalUmlState.g:1129:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
	public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1133:1: ( ( ruleQualifiedName ) )
			// InternalUmlState.g:1134:1: ( ruleQualifiedName )
			{
				// InternalUmlState.g:1134:1: ( ruleQualifiedName )
				// InternalUmlState.g:1135:1: ruleQualifiedName
				{
					before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0());
					pushFollow(FOLLOW_2);
					ruleQualifiedName();

					state._fsp--;

					after(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0());

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
	// $ANTLR end "rule__QualifiedName__RemainingAssignment_2"


	// $ANTLR start "rule__EntryRule__KindAssignment_1"
	// InternalUmlState.g:1144:1: rule__EntryRule__KindAssignment_1 : ( ruleBehaviorKind ) ;
	public final void rule__EntryRule__KindAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1148:1: ( ( ruleBehaviorKind ) )
			// InternalUmlState.g:1149:1: ( ruleBehaviorKind )
			{
				// InternalUmlState.g:1149:1: ( ruleBehaviorKind )
				// InternalUmlState.g:1150:1: ruleBehaviorKind
				{
					before(grammarAccess.getEntryRuleAccess().getKindBehaviorKindEnumRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleBehaviorKind();

					state._fsp--;

					after(grammarAccess.getEntryRuleAccess().getKindBehaviorKindEnumRuleCall_1_0());

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
	// $ANTLR end "rule__EntryRule__KindAssignment_1"


	// $ANTLR start "rule__EntryRule__BehaviorNameAssignment_2"
	// InternalUmlState.g:1159:1: rule__EntryRule__BehaviorNameAssignment_2 : ( RULE_ID ) ;
	public final void rule__EntryRule__BehaviorNameAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1163:1: ( ( RULE_ID ) )
			// InternalUmlState.g:1164:1: ( RULE_ID )
			{
				// InternalUmlState.g:1164:1: ( RULE_ID )
				// InternalUmlState.g:1165:1: RULE_ID
				{
					before(grammarAccess.getEntryRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getEntryRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0());

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
	// $ANTLR end "rule__EntryRule__BehaviorNameAssignment_2"


	// $ANTLR start "rule__DoRule__KindAssignment_1"
	// InternalUmlState.g:1174:1: rule__DoRule__KindAssignment_1 : ( ruleBehaviorKind ) ;
	public final void rule__DoRule__KindAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1178:1: ( ( ruleBehaviorKind ) )
			// InternalUmlState.g:1179:1: ( ruleBehaviorKind )
			{
				// InternalUmlState.g:1179:1: ( ruleBehaviorKind )
				// InternalUmlState.g:1180:1: ruleBehaviorKind
				{
					before(grammarAccess.getDoRuleAccess().getKindBehaviorKindEnumRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleBehaviorKind();

					state._fsp--;

					after(grammarAccess.getDoRuleAccess().getKindBehaviorKindEnumRuleCall_1_0());

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
	// $ANTLR end "rule__DoRule__KindAssignment_1"


	// $ANTLR start "rule__DoRule__BehaviorNameAssignment_2"
	// InternalUmlState.g:1189:1: rule__DoRule__BehaviorNameAssignment_2 : ( RULE_ID ) ;
	public final void rule__DoRule__BehaviorNameAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1193:1: ( ( RULE_ID ) )
			// InternalUmlState.g:1194:1: ( RULE_ID )
			{
				// InternalUmlState.g:1194:1: ( RULE_ID )
				// InternalUmlState.g:1195:1: RULE_ID
				{
					before(grammarAccess.getDoRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getDoRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0());

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
	// $ANTLR end "rule__DoRule__BehaviorNameAssignment_2"


	// $ANTLR start "rule__ExitRule__KindAssignment_1"
	// InternalUmlState.g:1204:1: rule__ExitRule__KindAssignment_1 : ( ruleBehaviorKind ) ;
	public final void rule__ExitRule__KindAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1208:1: ( ( ruleBehaviorKind ) )
			// InternalUmlState.g:1209:1: ( ruleBehaviorKind )
			{
				// InternalUmlState.g:1209:1: ( ruleBehaviorKind )
				// InternalUmlState.g:1210:1: ruleBehaviorKind
				{
					before(grammarAccess.getExitRuleAccess().getKindBehaviorKindEnumRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleBehaviorKind();

					state._fsp--;

					after(grammarAccess.getExitRuleAccess().getKindBehaviorKindEnumRuleCall_1_0());

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
	// $ANTLR end "rule__ExitRule__KindAssignment_1"


	// $ANTLR start "rule__ExitRule__BehaviorNameAssignment_2"
	// InternalUmlState.g:1219:1: rule__ExitRule__BehaviorNameAssignment_2 : ( RULE_ID ) ;
	public final void rule__ExitRule__BehaviorNameAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlState.g:1223:1: ( ( RULE_ID ) )
			// InternalUmlState.g:1224:1: ( RULE_ID )
			{
				// InternalUmlState.g:1224:1: ( RULE_ID )
				// InternalUmlState.g:1225:1: RULE_ID
				{
					before(grammarAccess.getExitRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getExitRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0());

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
	// $ANTLR end "rule__ExitRule__BehaviorNameAssignment_2"

	// Delegated rules




	public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x00000000000E8000L });
	public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_5 = new BitSet(new long[] { 0x0000000000010000L });
	public static final BitSet FOLLOW_6 = new BitSet(new long[] { 0x0000000000007000L });
	public static final BitSet FOLLOW_7 = new BitSet(new long[] { 0x00000000000E0002L });

}
