package org.eclipse.papyrus.uml.textedit.transition.xtext.ui.contentassist.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;
import org.eclipse.papyrus.uml.textedit.transition.xtext.services.UmlTransitionGrammarAccess;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

@SuppressWarnings("all")
public class InternalUmlTransitionParser extends AbstractInternalContentAssistParser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INT", "RULE_INTEGER_VALUE", "RULE_WS", "RULE_ANY_OTHER", "'Activity'", "'StateMachine'", "'OpaqueBehavior'", "','", "'after'", "'at'",
			"'when'", "'['", "']'", "'/'", "'all'"
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
	public static final int T__22 = 22;
	public static final int RULE_ML_COMMENT = 6;
	public static final int RULE_INTEGER_VALUE = 9;
	public static final int T__20 = 20;
	public static final int T__21 = 21;

	// delegates
	// delegators


	public InternalUmlTransitionParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalUmlTransitionParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);

	}


	public String[] getTokenNames() {
		return InternalUmlTransitionParser.tokenNames;
	}

	public String getGrammarFileName() {
		return "../org.eclipse.papyrus.uml.textedit.transition.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g";
	}



	private UmlTransitionGrammarAccess grammarAccess;

	public void setGrammarAccess(UmlTransitionGrammarAccess grammarAccess) {
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




	// $ANTLR start "entryRuleTransitionRule"
	// InternalUmlTransition.g:60:1: entryRuleTransitionRule : ruleTransitionRule EOF ;
	public final void entryRuleTransitionRule() throws RecognitionException {
		try {
			// InternalUmlTransition.g:61:1: ( ruleTransitionRule EOF )
			// InternalUmlTransition.g:62:1: ruleTransitionRule EOF
			{
				before(grammarAccess.getTransitionRuleRule());
				pushFollow(FOLLOW_1);
				ruleTransitionRule();

				state._fsp--;

				after(grammarAccess.getTransitionRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleTransitionRule"


	// $ANTLR start "ruleTransitionRule"
	// InternalUmlTransition.g:69:1: ruleTransitionRule : ( ( rule__TransitionRule__Group__0 ) ) ;
	public final void ruleTransitionRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:73:2: ( ( ( rule__TransitionRule__Group__0 ) ) )
			// InternalUmlTransition.g:74:1: ( ( rule__TransitionRule__Group__0 ) )
			{
				// InternalUmlTransition.g:74:1: ( ( rule__TransitionRule__Group__0 ) )
				// InternalUmlTransition.g:75:1: ( rule__TransitionRule__Group__0 )
				{
					before(grammarAccess.getTransitionRuleAccess().getGroup());
					// InternalUmlTransition.g:76:1: ( rule__TransitionRule__Group__0 )
					// InternalUmlTransition.g:76:2: rule__TransitionRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__TransitionRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getTransitionRuleAccess().getGroup());

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
	// $ANTLR end "ruleTransitionRule"


	// $ANTLR start "entryRuleEventRule"
	// InternalUmlTransition.g:88:1: entryRuleEventRule : ruleEventRule EOF ;
	public final void entryRuleEventRule() throws RecognitionException {
		try {
			// InternalUmlTransition.g:89:1: ( ruleEventRule EOF )
			// InternalUmlTransition.g:90:1: ruleEventRule EOF
			{
				before(grammarAccess.getEventRuleRule());
				pushFollow(FOLLOW_1);
				ruleEventRule();

				state._fsp--;

				after(grammarAccess.getEventRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleEventRule"


	// $ANTLR start "ruleEventRule"
	// InternalUmlTransition.g:97:1: ruleEventRule : ( ( rule__EventRule__Alternatives ) ) ;
	public final void ruleEventRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:101:2: ( ( ( rule__EventRule__Alternatives ) ) )
			// InternalUmlTransition.g:102:1: ( ( rule__EventRule__Alternatives ) )
			{
				// InternalUmlTransition.g:102:1: ( ( rule__EventRule__Alternatives ) )
				// InternalUmlTransition.g:103:1: ( rule__EventRule__Alternatives )
				{
					before(grammarAccess.getEventRuleAccess().getAlternatives());
					// InternalUmlTransition.g:104:1: ( rule__EventRule__Alternatives )
					// InternalUmlTransition.g:104:2: rule__EventRule__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__EventRule__Alternatives();

						state._fsp--;


					}

					after(grammarAccess.getEventRuleAccess().getAlternatives());

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
	// $ANTLR end "ruleEventRule"


	// $ANTLR start "entryRuleCallOrSignalEventRule"
	// InternalUmlTransition.g:116:1: entryRuleCallOrSignalEventRule : ruleCallOrSignalEventRule EOF ;
	public final void entryRuleCallOrSignalEventRule() throws RecognitionException {
		try {
			// InternalUmlTransition.g:117:1: ( ruleCallOrSignalEventRule EOF )
			// InternalUmlTransition.g:118:1: ruleCallOrSignalEventRule EOF
			{
				before(grammarAccess.getCallOrSignalEventRuleRule());
				pushFollow(FOLLOW_1);
				ruleCallOrSignalEventRule();

				state._fsp--;

				after(grammarAccess.getCallOrSignalEventRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleCallOrSignalEventRule"


	// $ANTLR start "ruleCallOrSignalEventRule"
	// InternalUmlTransition.g:125:1: ruleCallOrSignalEventRule : ( ( rule__CallOrSignalEventRule__OperationOrSignalAssignment ) ) ;
	public final void ruleCallOrSignalEventRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:129:2: ( ( ( rule__CallOrSignalEventRule__OperationOrSignalAssignment ) ) )
			// InternalUmlTransition.g:130:1: ( ( rule__CallOrSignalEventRule__OperationOrSignalAssignment ) )
			{
				// InternalUmlTransition.g:130:1: ( ( rule__CallOrSignalEventRule__OperationOrSignalAssignment ) )
				// InternalUmlTransition.g:131:1: ( rule__CallOrSignalEventRule__OperationOrSignalAssignment )
				{
					before(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalAssignment());
					// InternalUmlTransition.g:132:1: ( rule__CallOrSignalEventRule__OperationOrSignalAssignment )
					// InternalUmlTransition.g:132:2: rule__CallOrSignalEventRule__OperationOrSignalAssignment
					{
						pushFollow(FOLLOW_2);
						rule__CallOrSignalEventRule__OperationOrSignalAssignment();

						state._fsp--;


					}

					after(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalAssignment());

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
	// $ANTLR end "ruleCallOrSignalEventRule"


	// $ANTLR start "entryRuleAnyReceiveEventRule"
	// InternalUmlTransition.g:144:1: entryRuleAnyReceiveEventRule : ruleAnyReceiveEventRule EOF ;
	public final void entryRuleAnyReceiveEventRule() throws RecognitionException {
		try {
			// InternalUmlTransition.g:145:1: ( ruleAnyReceiveEventRule EOF )
			// InternalUmlTransition.g:146:1: ruleAnyReceiveEventRule EOF
			{
				before(grammarAccess.getAnyReceiveEventRuleRule());
				pushFollow(FOLLOW_1);
				ruleAnyReceiveEventRule();

				state._fsp--;

				after(grammarAccess.getAnyReceiveEventRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleAnyReceiveEventRule"


	// $ANTLR start "ruleAnyReceiveEventRule"
	// InternalUmlTransition.g:153:1: ruleAnyReceiveEventRule : ( ( rule__AnyReceiveEventRule__IsAReceiveEventAssignment ) ) ;
	public final void ruleAnyReceiveEventRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:157:2: ( ( ( rule__AnyReceiveEventRule__IsAReceiveEventAssignment ) ) )
			// InternalUmlTransition.g:158:1: ( ( rule__AnyReceiveEventRule__IsAReceiveEventAssignment ) )
			{
				// InternalUmlTransition.g:158:1: ( ( rule__AnyReceiveEventRule__IsAReceiveEventAssignment ) )
				// InternalUmlTransition.g:159:1: ( rule__AnyReceiveEventRule__IsAReceiveEventAssignment )
				{
					before(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAssignment());
					// InternalUmlTransition.g:160:1: ( rule__AnyReceiveEventRule__IsAReceiveEventAssignment )
					// InternalUmlTransition.g:160:2: rule__AnyReceiveEventRule__IsAReceiveEventAssignment
					{
						pushFollow(FOLLOW_2);
						rule__AnyReceiveEventRule__IsAReceiveEventAssignment();

						state._fsp--;


					}

					after(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAssignment());

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
	// $ANTLR end "ruleAnyReceiveEventRule"


	// $ANTLR start "entryRuleTimeEventRule"
	// InternalUmlTransition.g:172:1: entryRuleTimeEventRule : ruleTimeEventRule EOF ;
	public final void entryRuleTimeEventRule() throws RecognitionException {
		try {
			// InternalUmlTransition.g:173:1: ( ruleTimeEventRule EOF )
			// InternalUmlTransition.g:174:1: ruleTimeEventRule EOF
			{
				before(grammarAccess.getTimeEventRuleRule());
				pushFollow(FOLLOW_1);
				ruleTimeEventRule();

				state._fsp--;

				after(grammarAccess.getTimeEventRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleTimeEventRule"


	// $ANTLR start "ruleTimeEventRule"
	// InternalUmlTransition.g:181:1: ruleTimeEventRule : ( ( rule__TimeEventRule__Alternatives ) ) ;
	public final void ruleTimeEventRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:185:2: ( ( ( rule__TimeEventRule__Alternatives ) ) )
			// InternalUmlTransition.g:186:1: ( ( rule__TimeEventRule__Alternatives ) )
			{
				// InternalUmlTransition.g:186:1: ( ( rule__TimeEventRule__Alternatives ) )
				// InternalUmlTransition.g:187:1: ( rule__TimeEventRule__Alternatives )
				{
					before(grammarAccess.getTimeEventRuleAccess().getAlternatives());
					// InternalUmlTransition.g:188:1: ( rule__TimeEventRule__Alternatives )
					// InternalUmlTransition.g:188:2: rule__TimeEventRule__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__TimeEventRule__Alternatives();

						state._fsp--;


					}

					after(grammarAccess.getTimeEventRuleAccess().getAlternatives());

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
	// $ANTLR end "ruleTimeEventRule"


	// $ANTLR start "entryRuleRelativeTimeEventRule"
	// InternalUmlTransition.g:200:1: entryRuleRelativeTimeEventRule : ruleRelativeTimeEventRule EOF ;
	public final void entryRuleRelativeTimeEventRule() throws RecognitionException {
		try {
			// InternalUmlTransition.g:201:1: ( ruleRelativeTimeEventRule EOF )
			// InternalUmlTransition.g:202:1: ruleRelativeTimeEventRule EOF
			{
				before(grammarAccess.getRelativeTimeEventRuleRule());
				pushFollow(FOLLOW_1);
				ruleRelativeTimeEventRule();

				state._fsp--;

				after(grammarAccess.getRelativeTimeEventRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleRelativeTimeEventRule"


	// $ANTLR start "ruleRelativeTimeEventRule"
	// InternalUmlTransition.g:209:1: ruleRelativeTimeEventRule : ( ( rule__RelativeTimeEventRule__Group__0 ) ) ;
	public final void ruleRelativeTimeEventRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:213:2: ( ( ( rule__RelativeTimeEventRule__Group__0 ) ) )
			// InternalUmlTransition.g:214:1: ( ( rule__RelativeTimeEventRule__Group__0 ) )
			{
				// InternalUmlTransition.g:214:1: ( ( rule__RelativeTimeEventRule__Group__0 ) )
				// InternalUmlTransition.g:215:1: ( rule__RelativeTimeEventRule__Group__0 )
				{
					before(grammarAccess.getRelativeTimeEventRuleAccess().getGroup());
					// InternalUmlTransition.g:216:1: ( rule__RelativeTimeEventRule__Group__0 )
					// InternalUmlTransition.g:216:2: rule__RelativeTimeEventRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__RelativeTimeEventRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getRelativeTimeEventRuleAccess().getGroup());

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
	// $ANTLR end "ruleRelativeTimeEventRule"


	// $ANTLR start "entryRuleAbsoluteTimeEventRule"
	// InternalUmlTransition.g:228:1: entryRuleAbsoluteTimeEventRule : ruleAbsoluteTimeEventRule EOF ;
	public final void entryRuleAbsoluteTimeEventRule() throws RecognitionException {
		try {
			// InternalUmlTransition.g:229:1: ( ruleAbsoluteTimeEventRule EOF )
			// InternalUmlTransition.g:230:1: ruleAbsoluteTimeEventRule EOF
			{
				before(grammarAccess.getAbsoluteTimeEventRuleRule());
				pushFollow(FOLLOW_1);
				ruleAbsoluteTimeEventRule();

				state._fsp--;

				after(grammarAccess.getAbsoluteTimeEventRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleAbsoluteTimeEventRule"


	// $ANTLR start "ruleAbsoluteTimeEventRule"
	// InternalUmlTransition.g:237:1: ruleAbsoluteTimeEventRule : ( ( rule__AbsoluteTimeEventRule__Group__0 ) ) ;
	public final void ruleAbsoluteTimeEventRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:241:2: ( ( ( rule__AbsoluteTimeEventRule__Group__0 ) ) )
			// InternalUmlTransition.g:242:1: ( ( rule__AbsoluteTimeEventRule__Group__0 ) )
			{
				// InternalUmlTransition.g:242:1: ( ( rule__AbsoluteTimeEventRule__Group__0 ) )
				// InternalUmlTransition.g:243:1: ( rule__AbsoluteTimeEventRule__Group__0 )
				{
					before(grammarAccess.getAbsoluteTimeEventRuleAccess().getGroup());
					// InternalUmlTransition.g:244:1: ( rule__AbsoluteTimeEventRule__Group__0 )
					// InternalUmlTransition.g:244:2: rule__AbsoluteTimeEventRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__AbsoluteTimeEventRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getAbsoluteTimeEventRuleAccess().getGroup());

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
	// $ANTLR end "ruleAbsoluteTimeEventRule"


	// $ANTLR start "entryRuleChangeEventRule"
	// InternalUmlTransition.g:256:1: entryRuleChangeEventRule : ruleChangeEventRule EOF ;
	public final void entryRuleChangeEventRule() throws RecognitionException {
		try {
			// InternalUmlTransition.g:257:1: ( ruleChangeEventRule EOF )
			// InternalUmlTransition.g:258:1: ruleChangeEventRule EOF
			{
				before(grammarAccess.getChangeEventRuleRule());
				pushFollow(FOLLOW_1);
				ruleChangeEventRule();

				state._fsp--;

				after(grammarAccess.getChangeEventRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleChangeEventRule"


	// $ANTLR start "ruleChangeEventRule"
	// InternalUmlTransition.g:265:1: ruleChangeEventRule : ( ( rule__ChangeEventRule__Group__0 ) ) ;
	public final void ruleChangeEventRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:269:2: ( ( ( rule__ChangeEventRule__Group__0 ) ) )
			// InternalUmlTransition.g:270:1: ( ( rule__ChangeEventRule__Group__0 ) )
			{
				// InternalUmlTransition.g:270:1: ( ( rule__ChangeEventRule__Group__0 ) )
				// InternalUmlTransition.g:271:1: ( rule__ChangeEventRule__Group__0 )
				{
					before(grammarAccess.getChangeEventRuleAccess().getGroup());
					// InternalUmlTransition.g:272:1: ( rule__ChangeEventRule__Group__0 )
					// InternalUmlTransition.g:272:2: rule__ChangeEventRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__ChangeEventRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getChangeEventRuleAccess().getGroup());

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
	// $ANTLR end "ruleChangeEventRule"


	// $ANTLR start "entryRuleGuardRule"
	// InternalUmlTransition.g:284:1: entryRuleGuardRule : ruleGuardRule EOF ;
	public final void entryRuleGuardRule() throws RecognitionException {
		try {
			// InternalUmlTransition.g:285:1: ( ruleGuardRule EOF )
			// InternalUmlTransition.g:286:1: ruleGuardRule EOF
			{
				before(grammarAccess.getGuardRuleRule());
				pushFollow(FOLLOW_1);
				ruleGuardRule();

				state._fsp--;

				after(grammarAccess.getGuardRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleGuardRule"


	// $ANTLR start "ruleGuardRule"
	// InternalUmlTransition.g:293:1: ruleGuardRule : ( ( rule__GuardRule__Group__0 ) ) ;
	public final void ruleGuardRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:297:2: ( ( ( rule__GuardRule__Group__0 ) ) )
			// InternalUmlTransition.g:298:1: ( ( rule__GuardRule__Group__0 ) )
			{
				// InternalUmlTransition.g:298:1: ( ( rule__GuardRule__Group__0 ) )
				// InternalUmlTransition.g:299:1: ( rule__GuardRule__Group__0 )
				{
					before(grammarAccess.getGuardRuleAccess().getGroup());
					// InternalUmlTransition.g:300:1: ( rule__GuardRule__Group__0 )
					// InternalUmlTransition.g:300:2: rule__GuardRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__GuardRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getGuardRuleAccess().getGroup());

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
	// $ANTLR end "ruleGuardRule"


	// $ANTLR start "entryRuleEffectRule"
	// InternalUmlTransition.g:312:1: entryRuleEffectRule : ruleEffectRule EOF ;
	public final void entryRuleEffectRule() throws RecognitionException {
		try {
			// InternalUmlTransition.g:313:1: ( ruleEffectRule EOF )
			// InternalUmlTransition.g:314:1: ruleEffectRule EOF
			{
				before(grammarAccess.getEffectRuleRule());
				pushFollow(FOLLOW_1);
				ruleEffectRule();

				state._fsp--;

				after(grammarAccess.getEffectRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleEffectRule"


	// $ANTLR start "ruleEffectRule"
	// InternalUmlTransition.g:321:1: ruleEffectRule : ( ( rule__EffectRule__Group__0 ) ) ;
	public final void ruleEffectRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:325:2: ( ( ( rule__EffectRule__Group__0 ) ) )
			// InternalUmlTransition.g:326:1: ( ( rule__EffectRule__Group__0 ) )
			{
				// InternalUmlTransition.g:326:1: ( ( rule__EffectRule__Group__0 ) )
				// InternalUmlTransition.g:327:1: ( rule__EffectRule__Group__0 )
				{
					before(grammarAccess.getEffectRuleAccess().getGroup());
					// InternalUmlTransition.g:328:1: ( rule__EffectRule__Group__0 )
					// InternalUmlTransition.g:328:2: rule__EffectRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__EffectRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getEffectRuleAccess().getGroup());

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
	// $ANTLR end "ruleEffectRule"


	// $ANTLR start "ruleBehaviorKind"
	// InternalUmlTransition.g:341:1: ruleBehaviorKind : ( ( rule__BehaviorKind__Alternatives ) ) ;
	public final void ruleBehaviorKind() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:345:1: ( ( ( rule__BehaviorKind__Alternatives ) ) )
			// InternalUmlTransition.g:346:1: ( ( rule__BehaviorKind__Alternatives ) )
			{
				// InternalUmlTransition.g:346:1: ( ( rule__BehaviorKind__Alternatives ) )
				// InternalUmlTransition.g:347:1: ( rule__BehaviorKind__Alternatives )
				{
					before(grammarAccess.getBehaviorKindAccess().getAlternatives());
					// InternalUmlTransition.g:348:1: ( rule__BehaviorKind__Alternatives )
					// InternalUmlTransition.g:348:2: rule__BehaviorKind__Alternatives
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


	// $ANTLR start "rule__EventRule__Alternatives"
	// InternalUmlTransition.g:359:1: rule__EventRule__Alternatives : ( ( ruleCallOrSignalEventRule ) | ( ruleAnyReceiveEventRule ) | ( ruleTimeEventRule ) | ( ruleChangeEventRule ) );
	public final void rule__EventRule__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:363:1: ( ( ruleCallOrSignalEventRule ) | ( ruleAnyReceiveEventRule ) | ( ruleTimeEventRule ) | ( ruleChangeEventRule ) )
			int alt1 = 4;
			switch (input.LA(1)) {
			case RULE_ID: {
				alt1 = 1;
			}
				break;
			case 22: {
				alt1 = 2;
			}
				break;
			case 16:
			case 17: {
				alt1 = 3;
			}
				break;
			case 18: {
				alt1 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 1, 0, input);

				throw nvae;
			}

			switch (alt1) {
			case 1:
			// InternalUmlTransition.g:364:1: ( ruleCallOrSignalEventRule )
			{
				// InternalUmlTransition.g:364:1: ( ruleCallOrSignalEventRule )
				// InternalUmlTransition.g:365:1: ruleCallOrSignalEventRule
				{
					before(grammarAccess.getEventRuleAccess().getCallOrSignalEventRuleParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleCallOrSignalEventRule();

					state._fsp--;

					after(grammarAccess.getEventRuleAccess().getCallOrSignalEventRuleParserRuleCall_0());

				}


			}
				break;
			case 2:
			// InternalUmlTransition.g:370:6: ( ruleAnyReceiveEventRule )
			{
				// InternalUmlTransition.g:370:6: ( ruleAnyReceiveEventRule )
				// InternalUmlTransition.g:371:1: ruleAnyReceiveEventRule
				{
					before(grammarAccess.getEventRuleAccess().getAnyReceiveEventRuleParserRuleCall_1());
					pushFollow(FOLLOW_2);
					ruleAnyReceiveEventRule();

					state._fsp--;

					after(grammarAccess.getEventRuleAccess().getAnyReceiveEventRuleParserRuleCall_1());

				}


			}
				break;
			case 3:
			// InternalUmlTransition.g:376:6: ( ruleTimeEventRule )
			{
				// InternalUmlTransition.g:376:6: ( ruleTimeEventRule )
				// InternalUmlTransition.g:377:1: ruleTimeEventRule
				{
					before(grammarAccess.getEventRuleAccess().getTimeEventRuleParserRuleCall_2());
					pushFollow(FOLLOW_2);
					ruleTimeEventRule();

					state._fsp--;

					after(grammarAccess.getEventRuleAccess().getTimeEventRuleParserRuleCall_2());

				}


			}
				break;
			case 4:
			// InternalUmlTransition.g:382:6: ( ruleChangeEventRule )
			{
				// InternalUmlTransition.g:382:6: ( ruleChangeEventRule )
				// InternalUmlTransition.g:383:1: ruleChangeEventRule
				{
					before(grammarAccess.getEventRuleAccess().getChangeEventRuleParserRuleCall_3());
					pushFollow(FOLLOW_2);
					ruleChangeEventRule();

					state._fsp--;

					after(grammarAccess.getEventRuleAccess().getChangeEventRuleParserRuleCall_3());

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
	// $ANTLR end "rule__EventRule__Alternatives"


	// $ANTLR start "rule__TimeEventRule__Alternatives"
	// InternalUmlTransition.g:393:1: rule__TimeEventRule__Alternatives : ( ( ruleRelativeTimeEventRule ) | ( ruleAbsoluteTimeEventRule ) );
	public final void rule__TimeEventRule__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:397:1: ( ( ruleRelativeTimeEventRule ) | ( ruleAbsoluteTimeEventRule ) )
			int alt2 = 2;
			int LA2_0 = input.LA(1);

			if ((LA2_0 == 16)) {
				alt2 = 1;
			} else if ((LA2_0 == 17)) {
				alt2 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 2, 0, input);

				throw nvae;
			}
			switch (alt2) {
			case 1:
			// InternalUmlTransition.g:398:1: ( ruleRelativeTimeEventRule )
			{
				// InternalUmlTransition.g:398:1: ( ruleRelativeTimeEventRule )
				// InternalUmlTransition.g:399:1: ruleRelativeTimeEventRule
				{
					before(grammarAccess.getTimeEventRuleAccess().getRelativeTimeEventRuleParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleRelativeTimeEventRule();

					state._fsp--;

					after(grammarAccess.getTimeEventRuleAccess().getRelativeTimeEventRuleParserRuleCall_0());

				}


			}
				break;
			case 2:
			// InternalUmlTransition.g:404:6: ( ruleAbsoluteTimeEventRule )
			{
				// InternalUmlTransition.g:404:6: ( ruleAbsoluteTimeEventRule )
				// InternalUmlTransition.g:405:1: ruleAbsoluteTimeEventRule
				{
					before(grammarAccess.getTimeEventRuleAccess().getAbsoluteTimeEventRuleParserRuleCall_1());
					pushFollow(FOLLOW_2);
					ruleAbsoluteTimeEventRule();

					state._fsp--;

					after(grammarAccess.getTimeEventRuleAccess().getAbsoluteTimeEventRuleParserRuleCall_1());

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
	// $ANTLR end "rule__TimeEventRule__Alternatives"


	// $ANTLR start "rule__BehaviorKind__Alternatives"
	// InternalUmlTransition.g:415:1: rule__BehaviorKind__Alternatives : ( ( ( 'Activity' ) ) | ( ( 'StateMachine' ) ) | ( ( 'OpaqueBehavior' ) ) );
	public final void rule__BehaviorKind__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:419:1: ( ( ( 'Activity' ) ) | ( ( 'StateMachine' ) ) | ( ( 'OpaqueBehavior' ) ) )
			int alt3 = 3;
			switch (input.LA(1)) {
			case 12: {
				alt3 = 1;
			}
				break;
			case 13: {
				alt3 = 2;
			}
				break;
			case 14: {
				alt3 = 3;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 3, 0, input);

				throw nvae;
			}

			switch (alt3) {
			case 1:
			// InternalUmlTransition.g:420:1: ( ( 'Activity' ) )
			{
				// InternalUmlTransition.g:420:1: ( ( 'Activity' ) )
				// InternalUmlTransition.g:421:1: ( 'Activity' )
				{
					before(grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0());
					// InternalUmlTransition.g:422:1: ( 'Activity' )
					// InternalUmlTransition.g:422:3: 'Activity'
					{
						match(input, 12, FOLLOW_2);

					}

					after(grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0());

				}


			}
				break;
			case 2:
			// InternalUmlTransition.g:427:6: ( ( 'StateMachine' ) )
			{
				// InternalUmlTransition.g:427:6: ( ( 'StateMachine' ) )
				// InternalUmlTransition.g:428:1: ( 'StateMachine' )
				{
					before(grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1());
					// InternalUmlTransition.g:429:1: ( 'StateMachine' )
					// InternalUmlTransition.g:429:3: 'StateMachine'
					{
						match(input, 13, FOLLOW_2);

					}

					after(grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1());

				}


			}
				break;
			case 3:
			// InternalUmlTransition.g:434:6: ( ( 'OpaqueBehavior' ) )
			{
				// InternalUmlTransition.g:434:6: ( ( 'OpaqueBehavior' ) )
				// InternalUmlTransition.g:435:1: ( 'OpaqueBehavior' )
				{
					before(grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2());
					// InternalUmlTransition.g:436:1: ( 'OpaqueBehavior' )
					// InternalUmlTransition.g:436:3: 'OpaqueBehavior'
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


	// $ANTLR start "rule__TransitionRule__Group__0"
	// InternalUmlTransition.g:448:1: rule__TransitionRule__Group__0 : rule__TransitionRule__Group__0__Impl rule__TransitionRule__Group__1 ;
	public final void rule__TransitionRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:452:1: ( rule__TransitionRule__Group__0__Impl rule__TransitionRule__Group__1 )
			// InternalUmlTransition.g:453:2: rule__TransitionRule__Group__0__Impl rule__TransitionRule__Group__1
			{
				pushFollow(FOLLOW_3);
				rule__TransitionRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__TransitionRule__Group__1();

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
	// $ANTLR end "rule__TransitionRule__Group__0"


	// $ANTLR start "rule__TransitionRule__Group__0__Impl"
	// InternalUmlTransition.g:460:1: rule__TransitionRule__Group__0__Impl : ( ( rule__TransitionRule__Group_0__0 )? ) ;
	public final void rule__TransitionRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:464:1: ( ( ( rule__TransitionRule__Group_0__0 )? ) )
			// InternalUmlTransition.g:465:1: ( ( rule__TransitionRule__Group_0__0 )? )
			{
				// InternalUmlTransition.g:465:1: ( ( rule__TransitionRule__Group_0__0 )? )
				// InternalUmlTransition.g:466:1: ( rule__TransitionRule__Group_0__0 )?
				{
					before(grammarAccess.getTransitionRuleAccess().getGroup_0());
					// InternalUmlTransition.g:467:1: ( rule__TransitionRule__Group_0__0 )?
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if ((LA4_0 == RULE_ID || (LA4_0 >= 16 && LA4_0 <= 18) || LA4_0 == 22)) {
						alt4 = 1;
					}
					switch (alt4) {
					case 1:
					// InternalUmlTransition.g:467:2: rule__TransitionRule__Group_0__0
					{
						pushFollow(FOLLOW_2);
						rule__TransitionRule__Group_0__0();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getTransitionRuleAccess().getGroup_0());

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
	// $ANTLR end "rule__TransitionRule__Group__0__Impl"


	// $ANTLR start "rule__TransitionRule__Group__1"
	// InternalUmlTransition.g:477:1: rule__TransitionRule__Group__1 : rule__TransitionRule__Group__1__Impl rule__TransitionRule__Group__2 ;
	public final void rule__TransitionRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:481:1: ( rule__TransitionRule__Group__1__Impl rule__TransitionRule__Group__2 )
			// InternalUmlTransition.g:482:2: rule__TransitionRule__Group__1__Impl rule__TransitionRule__Group__2
			{
				pushFollow(FOLLOW_3);
				rule__TransitionRule__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__TransitionRule__Group__2();

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
	// $ANTLR end "rule__TransitionRule__Group__1"


	// $ANTLR start "rule__TransitionRule__Group__1__Impl"
	// InternalUmlTransition.g:489:1: rule__TransitionRule__Group__1__Impl : ( ( rule__TransitionRule__GuardAssignment_1 )? ) ;
	public final void rule__TransitionRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:493:1: ( ( ( rule__TransitionRule__GuardAssignment_1 )? ) )
			// InternalUmlTransition.g:494:1: ( ( rule__TransitionRule__GuardAssignment_1 )? )
			{
				// InternalUmlTransition.g:494:1: ( ( rule__TransitionRule__GuardAssignment_1 )? )
				// InternalUmlTransition.g:495:1: ( rule__TransitionRule__GuardAssignment_1 )?
				{
					before(grammarAccess.getTransitionRuleAccess().getGuardAssignment_1());
					// InternalUmlTransition.g:496:1: ( rule__TransitionRule__GuardAssignment_1 )?
					int alt5 = 2;
					int LA5_0 = input.LA(1);

					if ((LA5_0 == 19)) {
						alt5 = 1;
					}
					switch (alt5) {
					case 1:
					// InternalUmlTransition.g:496:2: rule__TransitionRule__GuardAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__TransitionRule__GuardAssignment_1();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getTransitionRuleAccess().getGuardAssignment_1());

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
	// $ANTLR end "rule__TransitionRule__Group__1__Impl"


	// $ANTLR start "rule__TransitionRule__Group__2"
	// InternalUmlTransition.g:506:1: rule__TransitionRule__Group__2 : rule__TransitionRule__Group__2__Impl ;
	public final void rule__TransitionRule__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:510:1: ( rule__TransitionRule__Group__2__Impl )
			// InternalUmlTransition.g:511:2: rule__TransitionRule__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__TransitionRule__Group__2__Impl();

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
	// $ANTLR end "rule__TransitionRule__Group__2"


	// $ANTLR start "rule__TransitionRule__Group__2__Impl"
	// InternalUmlTransition.g:517:1: rule__TransitionRule__Group__2__Impl : ( ( rule__TransitionRule__EffectAssignment_2 )? ) ;
	public final void rule__TransitionRule__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:521:1: ( ( ( rule__TransitionRule__EffectAssignment_2 )? ) )
			// InternalUmlTransition.g:522:1: ( ( rule__TransitionRule__EffectAssignment_2 )? )
			{
				// InternalUmlTransition.g:522:1: ( ( rule__TransitionRule__EffectAssignment_2 )? )
				// InternalUmlTransition.g:523:1: ( rule__TransitionRule__EffectAssignment_2 )?
				{
					before(grammarAccess.getTransitionRuleAccess().getEffectAssignment_2());
					// InternalUmlTransition.g:524:1: ( rule__TransitionRule__EffectAssignment_2 )?
					int alt6 = 2;
					int LA6_0 = input.LA(1);

					if ((LA6_0 == 21)) {
						alt6 = 1;
					}
					switch (alt6) {
					case 1:
					// InternalUmlTransition.g:524:2: rule__TransitionRule__EffectAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__TransitionRule__EffectAssignment_2();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getTransitionRuleAccess().getEffectAssignment_2());

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
	// $ANTLR end "rule__TransitionRule__Group__2__Impl"


	// $ANTLR start "rule__TransitionRule__Group_0__0"
	// InternalUmlTransition.g:540:1: rule__TransitionRule__Group_0__0 : rule__TransitionRule__Group_0__0__Impl rule__TransitionRule__Group_0__1 ;
	public final void rule__TransitionRule__Group_0__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:544:1: ( rule__TransitionRule__Group_0__0__Impl rule__TransitionRule__Group_0__1 )
			// InternalUmlTransition.g:545:2: rule__TransitionRule__Group_0__0__Impl rule__TransitionRule__Group_0__1
			{
				pushFollow(FOLLOW_4);
				rule__TransitionRule__Group_0__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__TransitionRule__Group_0__1();

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
	// $ANTLR end "rule__TransitionRule__Group_0__0"


	// $ANTLR start "rule__TransitionRule__Group_0__0__Impl"
	// InternalUmlTransition.g:552:1: rule__TransitionRule__Group_0__0__Impl : ( ( rule__TransitionRule__TriggersAssignment_0_0 ) ) ;
	public final void rule__TransitionRule__Group_0__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:556:1: ( ( ( rule__TransitionRule__TriggersAssignment_0_0 ) ) )
			// InternalUmlTransition.g:557:1: ( ( rule__TransitionRule__TriggersAssignment_0_0 ) )
			{
				// InternalUmlTransition.g:557:1: ( ( rule__TransitionRule__TriggersAssignment_0_0 ) )
				// InternalUmlTransition.g:558:1: ( rule__TransitionRule__TriggersAssignment_0_0 )
				{
					before(grammarAccess.getTransitionRuleAccess().getTriggersAssignment_0_0());
					// InternalUmlTransition.g:559:1: ( rule__TransitionRule__TriggersAssignment_0_0 )
					// InternalUmlTransition.g:559:2: rule__TransitionRule__TriggersAssignment_0_0
					{
						pushFollow(FOLLOW_2);
						rule__TransitionRule__TriggersAssignment_0_0();

						state._fsp--;


					}

					after(grammarAccess.getTransitionRuleAccess().getTriggersAssignment_0_0());

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
	// $ANTLR end "rule__TransitionRule__Group_0__0__Impl"


	// $ANTLR start "rule__TransitionRule__Group_0__1"
	// InternalUmlTransition.g:569:1: rule__TransitionRule__Group_0__1 : rule__TransitionRule__Group_0__1__Impl ;
	public final void rule__TransitionRule__Group_0__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:573:1: ( rule__TransitionRule__Group_0__1__Impl )
			// InternalUmlTransition.g:574:2: rule__TransitionRule__Group_0__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__TransitionRule__Group_0__1__Impl();

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
	// $ANTLR end "rule__TransitionRule__Group_0__1"


	// $ANTLR start "rule__TransitionRule__Group_0__1__Impl"
	// InternalUmlTransition.g:580:1: rule__TransitionRule__Group_0__1__Impl : ( ( rule__TransitionRule__Group_0_1__0 )* ) ;
	public final void rule__TransitionRule__Group_0__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:584:1: ( ( ( rule__TransitionRule__Group_0_1__0 )* ) )
			// InternalUmlTransition.g:585:1: ( ( rule__TransitionRule__Group_0_1__0 )* )
			{
				// InternalUmlTransition.g:585:1: ( ( rule__TransitionRule__Group_0_1__0 )* )
				// InternalUmlTransition.g:586:1: ( rule__TransitionRule__Group_0_1__0 )*
				{
					before(grammarAccess.getTransitionRuleAccess().getGroup_0_1());
					// InternalUmlTransition.g:587:1: ( rule__TransitionRule__Group_0_1__0 )*
					loop7: do {
						int alt7 = 2;
						int LA7_0 = input.LA(1);

						if ((LA7_0 == 15)) {
							alt7 = 1;
						}


						switch (alt7) {
						case 1:
						// InternalUmlTransition.g:587:2: rule__TransitionRule__Group_0_1__0
						{
							pushFollow(FOLLOW_5);
							rule__TransitionRule__Group_0_1__0();

							state._fsp--;


						}
							break;

						default:
							break loop7;
						}
					} while (true);

					after(grammarAccess.getTransitionRuleAccess().getGroup_0_1());

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
	// $ANTLR end "rule__TransitionRule__Group_0__1__Impl"


	// $ANTLR start "rule__TransitionRule__Group_0_1__0"
	// InternalUmlTransition.g:601:1: rule__TransitionRule__Group_0_1__0 : rule__TransitionRule__Group_0_1__0__Impl rule__TransitionRule__Group_0_1__1 ;
	public final void rule__TransitionRule__Group_0_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:605:1: ( rule__TransitionRule__Group_0_1__0__Impl rule__TransitionRule__Group_0_1__1 )
			// InternalUmlTransition.g:606:2: rule__TransitionRule__Group_0_1__0__Impl rule__TransitionRule__Group_0_1__1
			{
				pushFollow(FOLLOW_6);
				rule__TransitionRule__Group_0_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__TransitionRule__Group_0_1__1();

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
	// $ANTLR end "rule__TransitionRule__Group_0_1__0"


	// $ANTLR start "rule__TransitionRule__Group_0_1__0__Impl"
	// InternalUmlTransition.g:613:1: rule__TransitionRule__Group_0_1__0__Impl : ( ',' ) ;
	public final void rule__TransitionRule__Group_0_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:617:1: ( ( ',' ) )
			// InternalUmlTransition.g:618:1: ( ',' )
			{
				// InternalUmlTransition.g:618:1: ( ',' )
				// InternalUmlTransition.g:619:1: ','
				{
					before(grammarAccess.getTransitionRuleAccess().getCommaKeyword_0_1_0());
					match(input, 15, FOLLOW_2);
					after(grammarAccess.getTransitionRuleAccess().getCommaKeyword_0_1_0());

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
	// $ANTLR end "rule__TransitionRule__Group_0_1__0__Impl"


	// $ANTLR start "rule__TransitionRule__Group_0_1__1"
	// InternalUmlTransition.g:632:1: rule__TransitionRule__Group_0_1__1 : rule__TransitionRule__Group_0_1__1__Impl ;
	public final void rule__TransitionRule__Group_0_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:636:1: ( rule__TransitionRule__Group_0_1__1__Impl )
			// InternalUmlTransition.g:637:2: rule__TransitionRule__Group_0_1__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__TransitionRule__Group_0_1__1__Impl();

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
	// $ANTLR end "rule__TransitionRule__Group_0_1__1"


	// $ANTLR start "rule__TransitionRule__Group_0_1__1__Impl"
	// InternalUmlTransition.g:643:1: rule__TransitionRule__Group_0_1__1__Impl : ( ( rule__TransitionRule__TriggersAssignment_0_1_1 ) ) ;
	public final void rule__TransitionRule__Group_0_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:647:1: ( ( ( rule__TransitionRule__TriggersAssignment_0_1_1 ) ) )
			// InternalUmlTransition.g:648:1: ( ( rule__TransitionRule__TriggersAssignment_0_1_1 ) )
			{
				// InternalUmlTransition.g:648:1: ( ( rule__TransitionRule__TriggersAssignment_0_1_1 ) )
				// InternalUmlTransition.g:649:1: ( rule__TransitionRule__TriggersAssignment_0_1_1 )
				{
					before(grammarAccess.getTransitionRuleAccess().getTriggersAssignment_0_1_1());
					// InternalUmlTransition.g:650:1: ( rule__TransitionRule__TriggersAssignment_0_1_1 )
					// InternalUmlTransition.g:650:2: rule__TransitionRule__TriggersAssignment_0_1_1
					{
						pushFollow(FOLLOW_2);
						rule__TransitionRule__TriggersAssignment_0_1_1();

						state._fsp--;


					}

					after(grammarAccess.getTransitionRuleAccess().getTriggersAssignment_0_1_1());

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
	// $ANTLR end "rule__TransitionRule__Group_0_1__1__Impl"


	// $ANTLR start "rule__RelativeTimeEventRule__Group__0"
	// InternalUmlTransition.g:664:1: rule__RelativeTimeEventRule__Group__0 : rule__RelativeTimeEventRule__Group__0__Impl rule__RelativeTimeEventRule__Group__1 ;
	public final void rule__RelativeTimeEventRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:668:1: ( rule__RelativeTimeEventRule__Group__0__Impl rule__RelativeTimeEventRule__Group__1 )
			// InternalUmlTransition.g:669:2: rule__RelativeTimeEventRule__Group__0__Impl rule__RelativeTimeEventRule__Group__1
			{
				pushFollow(FOLLOW_7);
				rule__RelativeTimeEventRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__RelativeTimeEventRule__Group__1();

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
	// $ANTLR end "rule__RelativeTimeEventRule__Group__0"


	// $ANTLR start "rule__RelativeTimeEventRule__Group__0__Impl"
	// InternalUmlTransition.g:676:1: rule__RelativeTimeEventRule__Group__0__Impl : ( 'after' ) ;
	public final void rule__RelativeTimeEventRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:680:1: ( ( 'after' ) )
			// InternalUmlTransition.g:681:1: ( 'after' )
			{
				// InternalUmlTransition.g:681:1: ( 'after' )
				// InternalUmlTransition.g:682:1: 'after'
				{
					before(grammarAccess.getRelativeTimeEventRuleAccess().getAfterKeyword_0());
					match(input, 16, FOLLOW_2);
					after(grammarAccess.getRelativeTimeEventRuleAccess().getAfterKeyword_0());

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
	// $ANTLR end "rule__RelativeTimeEventRule__Group__0__Impl"


	// $ANTLR start "rule__RelativeTimeEventRule__Group__1"
	// InternalUmlTransition.g:695:1: rule__RelativeTimeEventRule__Group__1 : rule__RelativeTimeEventRule__Group__1__Impl ;
	public final void rule__RelativeTimeEventRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:699:1: ( rule__RelativeTimeEventRule__Group__1__Impl )
			// InternalUmlTransition.g:700:2: rule__RelativeTimeEventRule__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__RelativeTimeEventRule__Group__1__Impl();

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
	// $ANTLR end "rule__RelativeTimeEventRule__Group__1"


	// $ANTLR start "rule__RelativeTimeEventRule__Group__1__Impl"
	// InternalUmlTransition.g:706:1: rule__RelativeTimeEventRule__Group__1__Impl : ( ( rule__RelativeTimeEventRule__ExprAssignment_1 ) ) ;
	public final void rule__RelativeTimeEventRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:710:1: ( ( ( rule__RelativeTimeEventRule__ExprAssignment_1 ) ) )
			// InternalUmlTransition.g:711:1: ( ( rule__RelativeTimeEventRule__ExprAssignment_1 ) )
			{
				// InternalUmlTransition.g:711:1: ( ( rule__RelativeTimeEventRule__ExprAssignment_1 ) )
				// InternalUmlTransition.g:712:1: ( rule__RelativeTimeEventRule__ExprAssignment_1 )
				{
					before(grammarAccess.getRelativeTimeEventRuleAccess().getExprAssignment_1());
					// InternalUmlTransition.g:713:1: ( rule__RelativeTimeEventRule__ExprAssignment_1 )
					// InternalUmlTransition.g:713:2: rule__RelativeTimeEventRule__ExprAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__RelativeTimeEventRule__ExprAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getRelativeTimeEventRuleAccess().getExprAssignment_1());

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
	// $ANTLR end "rule__RelativeTimeEventRule__Group__1__Impl"


	// $ANTLR start "rule__AbsoluteTimeEventRule__Group__0"
	// InternalUmlTransition.g:727:1: rule__AbsoluteTimeEventRule__Group__0 : rule__AbsoluteTimeEventRule__Group__0__Impl rule__AbsoluteTimeEventRule__Group__1 ;
	public final void rule__AbsoluteTimeEventRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:731:1: ( rule__AbsoluteTimeEventRule__Group__0__Impl rule__AbsoluteTimeEventRule__Group__1 )
			// InternalUmlTransition.g:732:2: rule__AbsoluteTimeEventRule__Group__0__Impl rule__AbsoluteTimeEventRule__Group__1
			{
				pushFollow(FOLLOW_7);
				rule__AbsoluteTimeEventRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__AbsoluteTimeEventRule__Group__1();

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
	// $ANTLR end "rule__AbsoluteTimeEventRule__Group__0"


	// $ANTLR start "rule__AbsoluteTimeEventRule__Group__0__Impl"
	// InternalUmlTransition.g:739:1: rule__AbsoluteTimeEventRule__Group__0__Impl : ( 'at' ) ;
	public final void rule__AbsoluteTimeEventRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:743:1: ( ( 'at' ) )
			// InternalUmlTransition.g:744:1: ( 'at' )
			{
				// InternalUmlTransition.g:744:1: ( 'at' )
				// InternalUmlTransition.g:745:1: 'at'
				{
					before(grammarAccess.getAbsoluteTimeEventRuleAccess().getAtKeyword_0());
					match(input, 17, FOLLOW_2);
					after(grammarAccess.getAbsoluteTimeEventRuleAccess().getAtKeyword_0());

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
	// $ANTLR end "rule__AbsoluteTimeEventRule__Group__0__Impl"


	// $ANTLR start "rule__AbsoluteTimeEventRule__Group__1"
	// InternalUmlTransition.g:758:1: rule__AbsoluteTimeEventRule__Group__1 : rule__AbsoluteTimeEventRule__Group__1__Impl ;
	public final void rule__AbsoluteTimeEventRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:762:1: ( rule__AbsoluteTimeEventRule__Group__1__Impl )
			// InternalUmlTransition.g:763:2: rule__AbsoluteTimeEventRule__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__AbsoluteTimeEventRule__Group__1__Impl();

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
	// $ANTLR end "rule__AbsoluteTimeEventRule__Group__1"


	// $ANTLR start "rule__AbsoluteTimeEventRule__Group__1__Impl"
	// InternalUmlTransition.g:769:1: rule__AbsoluteTimeEventRule__Group__1__Impl : ( ( rule__AbsoluteTimeEventRule__ExprAssignment_1 ) ) ;
	public final void rule__AbsoluteTimeEventRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:773:1: ( ( ( rule__AbsoluteTimeEventRule__ExprAssignment_1 ) ) )
			// InternalUmlTransition.g:774:1: ( ( rule__AbsoluteTimeEventRule__ExprAssignment_1 ) )
			{
				// InternalUmlTransition.g:774:1: ( ( rule__AbsoluteTimeEventRule__ExprAssignment_1 ) )
				// InternalUmlTransition.g:775:1: ( rule__AbsoluteTimeEventRule__ExprAssignment_1 )
				{
					before(grammarAccess.getAbsoluteTimeEventRuleAccess().getExprAssignment_1());
					// InternalUmlTransition.g:776:1: ( rule__AbsoluteTimeEventRule__ExprAssignment_1 )
					// InternalUmlTransition.g:776:2: rule__AbsoluteTimeEventRule__ExprAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__AbsoluteTimeEventRule__ExprAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getAbsoluteTimeEventRuleAccess().getExprAssignment_1());

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
	// $ANTLR end "rule__AbsoluteTimeEventRule__Group__1__Impl"


	// $ANTLR start "rule__ChangeEventRule__Group__0"
	// InternalUmlTransition.g:790:1: rule__ChangeEventRule__Group__0 : rule__ChangeEventRule__Group__0__Impl rule__ChangeEventRule__Group__1 ;
	public final void rule__ChangeEventRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:794:1: ( rule__ChangeEventRule__Group__0__Impl rule__ChangeEventRule__Group__1 )
			// InternalUmlTransition.g:795:2: rule__ChangeEventRule__Group__0__Impl rule__ChangeEventRule__Group__1
			{
				pushFollow(FOLLOW_7);
				rule__ChangeEventRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ChangeEventRule__Group__1();

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
	// $ANTLR end "rule__ChangeEventRule__Group__0"


	// $ANTLR start "rule__ChangeEventRule__Group__0__Impl"
	// InternalUmlTransition.g:802:1: rule__ChangeEventRule__Group__0__Impl : ( 'when' ) ;
	public final void rule__ChangeEventRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:806:1: ( ( 'when' ) )
			// InternalUmlTransition.g:807:1: ( 'when' )
			{
				// InternalUmlTransition.g:807:1: ( 'when' )
				// InternalUmlTransition.g:808:1: 'when'
				{
					before(grammarAccess.getChangeEventRuleAccess().getWhenKeyword_0());
					match(input, 18, FOLLOW_2);
					after(grammarAccess.getChangeEventRuleAccess().getWhenKeyword_0());

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
	// $ANTLR end "rule__ChangeEventRule__Group__0__Impl"


	// $ANTLR start "rule__ChangeEventRule__Group__1"
	// InternalUmlTransition.g:821:1: rule__ChangeEventRule__Group__1 : rule__ChangeEventRule__Group__1__Impl ;
	public final void rule__ChangeEventRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:825:1: ( rule__ChangeEventRule__Group__1__Impl )
			// InternalUmlTransition.g:826:2: rule__ChangeEventRule__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__ChangeEventRule__Group__1__Impl();

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
	// $ANTLR end "rule__ChangeEventRule__Group__1"


	// $ANTLR start "rule__ChangeEventRule__Group__1__Impl"
	// InternalUmlTransition.g:832:1: rule__ChangeEventRule__Group__1__Impl : ( ( rule__ChangeEventRule__ExpAssignment_1 ) ) ;
	public final void rule__ChangeEventRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:836:1: ( ( ( rule__ChangeEventRule__ExpAssignment_1 ) ) )
			// InternalUmlTransition.g:837:1: ( ( rule__ChangeEventRule__ExpAssignment_1 ) )
			{
				// InternalUmlTransition.g:837:1: ( ( rule__ChangeEventRule__ExpAssignment_1 ) )
				// InternalUmlTransition.g:838:1: ( rule__ChangeEventRule__ExpAssignment_1 )
				{
					before(grammarAccess.getChangeEventRuleAccess().getExpAssignment_1());
					// InternalUmlTransition.g:839:1: ( rule__ChangeEventRule__ExpAssignment_1 )
					// InternalUmlTransition.g:839:2: rule__ChangeEventRule__ExpAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__ChangeEventRule__ExpAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getChangeEventRuleAccess().getExpAssignment_1());

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
	// $ANTLR end "rule__ChangeEventRule__Group__1__Impl"


	// $ANTLR start "rule__GuardRule__Group__0"
	// InternalUmlTransition.g:853:1: rule__GuardRule__Group__0 : rule__GuardRule__Group__0__Impl rule__GuardRule__Group__1 ;
	public final void rule__GuardRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:857:1: ( rule__GuardRule__Group__0__Impl rule__GuardRule__Group__1 )
			// InternalUmlTransition.g:858:2: rule__GuardRule__Group__0__Impl rule__GuardRule__Group__1
			{
				pushFollow(FOLLOW_7);
				rule__GuardRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__GuardRule__Group__1();

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
	// $ANTLR end "rule__GuardRule__Group__0"


	// $ANTLR start "rule__GuardRule__Group__0__Impl"
	// InternalUmlTransition.g:865:1: rule__GuardRule__Group__0__Impl : ( '[' ) ;
	public final void rule__GuardRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:869:1: ( ( '[' ) )
			// InternalUmlTransition.g:870:1: ( '[' )
			{
				// InternalUmlTransition.g:870:1: ( '[' )
				// InternalUmlTransition.g:871:1: '['
				{
					before(grammarAccess.getGuardRuleAccess().getLeftSquareBracketKeyword_0());
					match(input, 19, FOLLOW_2);
					after(grammarAccess.getGuardRuleAccess().getLeftSquareBracketKeyword_0());

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
	// $ANTLR end "rule__GuardRule__Group__0__Impl"


	// $ANTLR start "rule__GuardRule__Group__1"
	// InternalUmlTransition.g:884:1: rule__GuardRule__Group__1 : rule__GuardRule__Group__1__Impl rule__GuardRule__Group__2 ;
	public final void rule__GuardRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:888:1: ( rule__GuardRule__Group__1__Impl rule__GuardRule__Group__2 )
			// InternalUmlTransition.g:889:2: rule__GuardRule__Group__1__Impl rule__GuardRule__Group__2
			{
				pushFollow(FOLLOW_8);
				rule__GuardRule__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__GuardRule__Group__2();

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
	// $ANTLR end "rule__GuardRule__Group__1"


	// $ANTLR start "rule__GuardRule__Group__1__Impl"
	// InternalUmlTransition.g:896:1: rule__GuardRule__Group__1__Impl : ( ( rule__GuardRule__ConstraintAssignment_1 ) ) ;
	public final void rule__GuardRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:900:1: ( ( ( rule__GuardRule__ConstraintAssignment_1 ) ) )
			// InternalUmlTransition.g:901:1: ( ( rule__GuardRule__ConstraintAssignment_1 ) )
			{
				// InternalUmlTransition.g:901:1: ( ( rule__GuardRule__ConstraintAssignment_1 ) )
				// InternalUmlTransition.g:902:1: ( rule__GuardRule__ConstraintAssignment_1 )
				{
					before(grammarAccess.getGuardRuleAccess().getConstraintAssignment_1());
					// InternalUmlTransition.g:903:1: ( rule__GuardRule__ConstraintAssignment_1 )
					// InternalUmlTransition.g:903:2: rule__GuardRule__ConstraintAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__GuardRule__ConstraintAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getGuardRuleAccess().getConstraintAssignment_1());

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
	// $ANTLR end "rule__GuardRule__Group__1__Impl"


	// $ANTLR start "rule__GuardRule__Group__2"
	// InternalUmlTransition.g:913:1: rule__GuardRule__Group__2 : rule__GuardRule__Group__2__Impl ;
	public final void rule__GuardRule__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:917:1: ( rule__GuardRule__Group__2__Impl )
			// InternalUmlTransition.g:918:2: rule__GuardRule__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__GuardRule__Group__2__Impl();

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
	// $ANTLR end "rule__GuardRule__Group__2"


	// $ANTLR start "rule__GuardRule__Group__2__Impl"
	// InternalUmlTransition.g:924:1: rule__GuardRule__Group__2__Impl : ( ']' ) ;
	public final void rule__GuardRule__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:928:1: ( ( ']' ) )
			// InternalUmlTransition.g:929:1: ( ']' )
			{
				// InternalUmlTransition.g:929:1: ( ']' )
				// InternalUmlTransition.g:930:1: ']'
				{
					before(grammarAccess.getGuardRuleAccess().getRightSquareBracketKeyword_2());
					match(input, 20, FOLLOW_2);
					after(grammarAccess.getGuardRuleAccess().getRightSquareBracketKeyword_2());

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
	// $ANTLR end "rule__GuardRule__Group__2__Impl"


	// $ANTLR start "rule__EffectRule__Group__0"
	// InternalUmlTransition.g:949:1: rule__EffectRule__Group__0 : rule__EffectRule__Group__0__Impl rule__EffectRule__Group__1 ;
	public final void rule__EffectRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:953:1: ( rule__EffectRule__Group__0__Impl rule__EffectRule__Group__1 )
			// InternalUmlTransition.g:954:2: rule__EffectRule__Group__0__Impl rule__EffectRule__Group__1
			{
				pushFollow(FOLLOW_9);
				rule__EffectRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__EffectRule__Group__1();

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
	// $ANTLR end "rule__EffectRule__Group__0"


	// $ANTLR start "rule__EffectRule__Group__0__Impl"
	// InternalUmlTransition.g:961:1: rule__EffectRule__Group__0__Impl : ( '/' ) ;
	public final void rule__EffectRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:965:1: ( ( '/' ) )
			// InternalUmlTransition.g:966:1: ( '/' )
			{
				// InternalUmlTransition.g:966:1: ( '/' )
				// InternalUmlTransition.g:967:1: '/'
				{
					before(grammarAccess.getEffectRuleAccess().getSolidusKeyword_0());
					match(input, 21, FOLLOW_2);
					after(grammarAccess.getEffectRuleAccess().getSolidusKeyword_0());

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
	// $ANTLR end "rule__EffectRule__Group__0__Impl"


	// $ANTLR start "rule__EffectRule__Group__1"
	// InternalUmlTransition.g:980:1: rule__EffectRule__Group__1 : rule__EffectRule__Group__1__Impl rule__EffectRule__Group__2 ;
	public final void rule__EffectRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:984:1: ( rule__EffectRule__Group__1__Impl rule__EffectRule__Group__2 )
			// InternalUmlTransition.g:985:2: rule__EffectRule__Group__1__Impl rule__EffectRule__Group__2
			{
				pushFollow(FOLLOW_10);
				rule__EffectRule__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__EffectRule__Group__2();

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
	// $ANTLR end "rule__EffectRule__Group__1"


	// $ANTLR start "rule__EffectRule__Group__1__Impl"
	// InternalUmlTransition.g:992:1: rule__EffectRule__Group__1__Impl : ( ( rule__EffectRule__KindAssignment_1 ) ) ;
	public final void rule__EffectRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:996:1: ( ( ( rule__EffectRule__KindAssignment_1 ) ) )
			// InternalUmlTransition.g:997:1: ( ( rule__EffectRule__KindAssignment_1 ) )
			{
				// InternalUmlTransition.g:997:1: ( ( rule__EffectRule__KindAssignment_1 ) )
				// InternalUmlTransition.g:998:1: ( rule__EffectRule__KindAssignment_1 )
				{
					before(grammarAccess.getEffectRuleAccess().getKindAssignment_1());
					// InternalUmlTransition.g:999:1: ( rule__EffectRule__KindAssignment_1 )
					// InternalUmlTransition.g:999:2: rule__EffectRule__KindAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__EffectRule__KindAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getEffectRuleAccess().getKindAssignment_1());

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
	// $ANTLR end "rule__EffectRule__Group__1__Impl"


	// $ANTLR start "rule__EffectRule__Group__2"
	// InternalUmlTransition.g:1009:1: rule__EffectRule__Group__2 : rule__EffectRule__Group__2__Impl ;
	public final void rule__EffectRule__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:1013:1: ( rule__EffectRule__Group__2__Impl )
			// InternalUmlTransition.g:1014:2: rule__EffectRule__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__EffectRule__Group__2__Impl();

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
	// $ANTLR end "rule__EffectRule__Group__2"


	// $ANTLR start "rule__EffectRule__Group__2__Impl"
	// InternalUmlTransition.g:1020:1: rule__EffectRule__Group__2__Impl : ( ( rule__EffectRule__BehaviorNameAssignment_2 ) ) ;
	public final void rule__EffectRule__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:1024:1: ( ( ( rule__EffectRule__BehaviorNameAssignment_2 ) ) )
			// InternalUmlTransition.g:1025:1: ( ( rule__EffectRule__BehaviorNameAssignment_2 ) )
			{
				// InternalUmlTransition.g:1025:1: ( ( rule__EffectRule__BehaviorNameAssignment_2 ) )
				// InternalUmlTransition.g:1026:1: ( rule__EffectRule__BehaviorNameAssignment_2 )
				{
					before(grammarAccess.getEffectRuleAccess().getBehaviorNameAssignment_2());
					// InternalUmlTransition.g:1027:1: ( rule__EffectRule__BehaviorNameAssignment_2 )
					// InternalUmlTransition.g:1027:2: rule__EffectRule__BehaviorNameAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__EffectRule__BehaviorNameAssignment_2();

						state._fsp--;


					}

					after(grammarAccess.getEffectRuleAccess().getBehaviorNameAssignment_2());

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
	// $ANTLR end "rule__EffectRule__Group__2__Impl"


	// $ANTLR start "rule__TransitionRule__TriggersAssignment_0_0"
	// InternalUmlTransition.g:1044:1: rule__TransitionRule__TriggersAssignment_0_0 : ( ruleEventRule ) ;
	public final void rule__TransitionRule__TriggersAssignment_0_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:1048:1: ( ( ruleEventRule ) )
			// InternalUmlTransition.g:1049:1: ( ruleEventRule )
			{
				// InternalUmlTransition.g:1049:1: ( ruleEventRule )
				// InternalUmlTransition.g:1050:1: ruleEventRule
				{
					before(grammarAccess.getTransitionRuleAccess().getTriggersEventRuleParserRuleCall_0_0_0());
					pushFollow(FOLLOW_2);
					ruleEventRule();

					state._fsp--;

					after(grammarAccess.getTransitionRuleAccess().getTriggersEventRuleParserRuleCall_0_0_0());

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
	// $ANTLR end "rule__TransitionRule__TriggersAssignment_0_0"


	// $ANTLR start "rule__TransitionRule__TriggersAssignment_0_1_1"
	// InternalUmlTransition.g:1059:1: rule__TransitionRule__TriggersAssignment_0_1_1 : ( ruleEventRule ) ;
	public final void rule__TransitionRule__TriggersAssignment_0_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:1063:1: ( ( ruleEventRule ) )
			// InternalUmlTransition.g:1064:1: ( ruleEventRule )
			{
				// InternalUmlTransition.g:1064:1: ( ruleEventRule )
				// InternalUmlTransition.g:1065:1: ruleEventRule
				{
					before(grammarAccess.getTransitionRuleAccess().getTriggersEventRuleParserRuleCall_0_1_1_0());
					pushFollow(FOLLOW_2);
					ruleEventRule();

					state._fsp--;

					after(grammarAccess.getTransitionRuleAccess().getTriggersEventRuleParserRuleCall_0_1_1_0());

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
	// $ANTLR end "rule__TransitionRule__TriggersAssignment_0_1_1"


	// $ANTLR start "rule__TransitionRule__GuardAssignment_1"
	// InternalUmlTransition.g:1074:1: rule__TransitionRule__GuardAssignment_1 : ( ruleGuardRule ) ;
	public final void rule__TransitionRule__GuardAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:1078:1: ( ( ruleGuardRule ) )
			// InternalUmlTransition.g:1079:1: ( ruleGuardRule )
			{
				// InternalUmlTransition.g:1079:1: ( ruleGuardRule )
				// InternalUmlTransition.g:1080:1: ruleGuardRule
				{
					before(grammarAccess.getTransitionRuleAccess().getGuardGuardRuleParserRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleGuardRule();

					state._fsp--;

					after(grammarAccess.getTransitionRuleAccess().getGuardGuardRuleParserRuleCall_1_0());

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
	// $ANTLR end "rule__TransitionRule__GuardAssignment_1"


	// $ANTLR start "rule__TransitionRule__EffectAssignment_2"
	// InternalUmlTransition.g:1089:1: rule__TransitionRule__EffectAssignment_2 : ( ruleEffectRule ) ;
	public final void rule__TransitionRule__EffectAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:1093:1: ( ( ruleEffectRule ) )
			// InternalUmlTransition.g:1094:1: ( ruleEffectRule )
			{
				// InternalUmlTransition.g:1094:1: ( ruleEffectRule )
				// InternalUmlTransition.g:1095:1: ruleEffectRule
				{
					before(grammarAccess.getTransitionRuleAccess().getEffectEffectRuleParserRuleCall_2_0());
					pushFollow(FOLLOW_2);
					ruleEffectRule();

					state._fsp--;

					after(grammarAccess.getTransitionRuleAccess().getEffectEffectRuleParserRuleCall_2_0());

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
	// $ANTLR end "rule__TransitionRule__EffectAssignment_2"


	// $ANTLR start "rule__CallOrSignalEventRule__OperationOrSignalAssignment"
	// InternalUmlTransition.g:1104:1: rule__CallOrSignalEventRule__OperationOrSignalAssignment : ( ( RULE_ID ) ) ;
	public final void rule__CallOrSignalEventRule__OperationOrSignalAssignment() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:1108:1: ( ( ( RULE_ID ) ) )
			// InternalUmlTransition.g:1109:1: ( ( RULE_ID ) )
			{
				// InternalUmlTransition.g:1109:1: ( ( RULE_ID ) )
				// InternalUmlTransition.g:1110:1: ( RULE_ID )
				{
					before(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalNamedElementCrossReference_0());
					// InternalUmlTransition.g:1111:1: ( RULE_ID )
					// InternalUmlTransition.g:1112:1: RULE_ID
					{
						before(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalNamedElementIDTerminalRuleCall_0_1());
						match(input, RULE_ID, FOLLOW_2);
						after(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalNamedElementIDTerminalRuleCall_0_1());

					}

					after(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalNamedElementCrossReference_0());

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
	// $ANTLR end "rule__CallOrSignalEventRule__OperationOrSignalAssignment"


	// $ANTLR start "rule__AnyReceiveEventRule__IsAReceiveEventAssignment"
	// InternalUmlTransition.g:1123:1: rule__AnyReceiveEventRule__IsAReceiveEventAssignment : ( ( 'all' ) ) ;
	public final void rule__AnyReceiveEventRule__IsAReceiveEventAssignment() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:1127:1: ( ( ( 'all' ) ) )
			// InternalUmlTransition.g:1128:1: ( ( 'all' ) )
			{
				// InternalUmlTransition.g:1128:1: ( ( 'all' ) )
				// InternalUmlTransition.g:1129:1: ( 'all' )
				{
					before(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAllKeyword_0());
					// InternalUmlTransition.g:1130:1: ( 'all' )
					// InternalUmlTransition.g:1131:1: 'all'
					{
						before(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAllKeyword_0());
						match(input, 22, FOLLOW_2);
						after(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAllKeyword_0());

					}

					after(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAllKeyword_0());

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
	// $ANTLR end "rule__AnyReceiveEventRule__IsAReceiveEventAssignment"


	// $ANTLR start "rule__RelativeTimeEventRule__ExprAssignment_1"
	// InternalUmlTransition.g:1146:1: rule__RelativeTimeEventRule__ExprAssignment_1 : ( RULE_STRING ) ;
	public final void rule__RelativeTimeEventRule__ExprAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:1150:1: ( ( RULE_STRING ) )
			// InternalUmlTransition.g:1151:1: ( RULE_STRING )
			{
				// InternalUmlTransition.g:1151:1: ( RULE_STRING )
				// InternalUmlTransition.g:1152:1: RULE_STRING
				{
					before(grammarAccess.getRelativeTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0());
					match(input, RULE_STRING, FOLLOW_2);
					after(grammarAccess.getRelativeTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0());

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
	// $ANTLR end "rule__RelativeTimeEventRule__ExprAssignment_1"


	// $ANTLR start "rule__AbsoluteTimeEventRule__ExprAssignment_1"
	// InternalUmlTransition.g:1161:1: rule__AbsoluteTimeEventRule__ExprAssignment_1 : ( RULE_STRING ) ;
	public final void rule__AbsoluteTimeEventRule__ExprAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:1165:1: ( ( RULE_STRING ) )
			// InternalUmlTransition.g:1166:1: ( RULE_STRING )
			{
				// InternalUmlTransition.g:1166:1: ( RULE_STRING )
				// InternalUmlTransition.g:1167:1: RULE_STRING
				{
					before(grammarAccess.getAbsoluteTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0());
					match(input, RULE_STRING, FOLLOW_2);
					after(grammarAccess.getAbsoluteTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0());

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
	// $ANTLR end "rule__AbsoluteTimeEventRule__ExprAssignment_1"


	// $ANTLR start "rule__ChangeEventRule__ExpAssignment_1"
	// InternalUmlTransition.g:1176:1: rule__ChangeEventRule__ExpAssignment_1 : ( RULE_STRING ) ;
	public final void rule__ChangeEventRule__ExpAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:1180:1: ( ( RULE_STRING ) )
			// InternalUmlTransition.g:1181:1: ( RULE_STRING )
			{
				// InternalUmlTransition.g:1181:1: ( RULE_STRING )
				// InternalUmlTransition.g:1182:1: RULE_STRING
				{
					before(grammarAccess.getChangeEventRuleAccess().getExpSTRINGTerminalRuleCall_1_0());
					match(input, RULE_STRING, FOLLOW_2);
					after(grammarAccess.getChangeEventRuleAccess().getExpSTRINGTerminalRuleCall_1_0());

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
	// $ANTLR end "rule__ChangeEventRule__ExpAssignment_1"


	// $ANTLR start "rule__GuardRule__ConstraintAssignment_1"
	// InternalUmlTransition.g:1191:1: rule__GuardRule__ConstraintAssignment_1 : ( RULE_STRING ) ;
	public final void rule__GuardRule__ConstraintAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:1195:1: ( ( RULE_STRING ) )
			// InternalUmlTransition.g:1196:1: ( RULE_STRING )
			{
				// InternalUmlTransition.g:1196:1: ( RULE_STRING )
				// InternalUmlTransition.g:1197:1: RULE_STRING
				{
					before(grammarAccess.getGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0());
					match(input, RULE_STRING, FOLLOW_2);
					after(grammarAccess.getGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0());

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
	// $ANTLR end "rule__GuardRule__ConstraintAssignment_1"


	// $ANTLR start "rule__EffectRule__KindAssignment_1"
	// InternalUmlTransition.g:1206:1: rule__EffectRule__KindAssignment_1 : ( ruleBehaviorKind ) ;
	public final void rule__EffectRule__KindAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:1210:1: ( ( ruleBehaviorKind ) )
			// InternalUmlTransition.g:1211:1: ( ruleBehaviorKind )
			{
				// InternalUmlTransition.g:1211:1: ( ruleBehaviorKind )
				// InternalUmlTransition.g:1212:1: ruleBehaviorKind
				{
					before(grammarAccess.getEffectRuleAccess().getKindBehaviorKindEnumRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleBehaviorKind();

					state._fsp--;

					after(grammarAccess.getEffectRuleAccess().getKindBehaviorKindEnumRuleCall_1_0());

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
	// $ANTLR end "rule__EffectRule__KindAssignment_1"


	// $ANTLR start "rule__EffectRule__BehaviorNameAssignment_2"
	// InternalUmlTransition.g:1221:1: rule__EffectRule__BehaviorNameAssignment_2 : ( RULE_ID ) ;
	public final void rule__EffectRule__BehaviorNameAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlTransition.g:1225:1: ( ( RULE_ID ) )
			// InternalUmlTransition.g:1226:1: ( RULE_ID )
			{
				// InternalUmlTransition.g:1226:1: ( RULE_ID )
				// InternalUmlTransition.g:1227:1: RULE_ID
				{
					before(grammarAccess.getEffectRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getEffectRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0());

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
	// $ANTLR end "rule__EffectRule__BehaviorNameAssignment_2"

	// Delegated rules




	public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x0000000000280000L });
	public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x0000000000008000L });
	public static final BitSet FOLLOW_5 = new BitSet(new long[] { 0x0000000000008002L });
	public static final BitSet FOLLOW_6 = new BitSet(new long[] { 0x0000000000470010L });
	public static final BitSet FOLLOW_7 = new BitSet(new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_8 = new BitSet(new long[] { 0x0000000000100000L });
	public static final BitSet FOLLOW_9 = new BitSet(new long[] { 0x0000000000007000L });
	public static final BitSet FOLLOW_10 = new BitSet(new long[] { 0x0000000000000010L });

}