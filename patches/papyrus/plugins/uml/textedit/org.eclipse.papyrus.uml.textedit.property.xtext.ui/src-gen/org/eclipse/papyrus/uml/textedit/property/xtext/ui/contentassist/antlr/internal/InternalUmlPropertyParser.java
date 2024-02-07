package org.eclipse.papyrus.uml.textedit.property.xtext.ui.contentassist.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;
import org.eclipse.papyrus.uml.textedit.property.xtext.services.UmlPropertyGrammarAccess;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

@SuppressWarnings("all")
public class InternalUmlPropertyParser extends AbstractInternalContentAssistParser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INTEGER_VALUE", "RULE_WS", "RULE_ANY_OTHER", "'*'", "'+'", "'-'", "'#'", "'~'", "'readOnly'", "'union'", "'ordered'",
			"'unique'", "'true'", "'false'", "':'", "'::'", "'['", "']'", "'..'", "'{'", "'}'", "','", "'redefines'", "'subsets'", "'='", "'.'", "'null'", "'none'", "'/'", "'<Undefined>'"
	};
	public static final int RULE_STRING = 4;
	public static final int RULE_SL_COMMENT = 8;
	public static final int T__19 = 19;
	public static final int T__15 = 15;
	public static final int T__37 = 37;
	public static final int T__16 = 16;
	public static final int T__38 = 38;
	public static final int T__17 = 17;
	public static final int T__18 = 18;
	public static final int T__33 = 33;
	public static final int T__12 = 12;
	public static final int T__34 = 34;
	public static final int T__13 = 13;
	public static final int T__35 = 35;
	public static final int T__14 = 14;
	public static final int T__36 = 36;
	public static final int EOF = -1;
	public static final int T__30 = 30;
	public static final int T__31 = 31;
	public static final int T__32 = 32;
	public static final int RULE_ID = 6;
	public static final int RULE_WS = 10;
	public static final int RULE_ANY_OTHER = 11;
	public static final int T__26 = 26;
	public static final int T__27 = 27;
	public static final int T__28 = 28;
	public static final int RULE_INT = 5;
	public static final int T__29 = 29;
	public static final int T__22 = 22;
	public static final int RULE_ML_COMMENT = 7;
	public static final int RULE_INTEGER_VALUE = 9;
	public static final int T__23 = 23;
	public static final int T__24 = 24;
	public static final int T__25 = 25;
	public static final int T__20 = 20;
	public static final int T__21 = 21;

	// delegates
	// delegators


	public InternalUmlPropertyParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalUmlPropertyParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);

	}


	public String[] getTokenNames() {
		return InternalUmlPropertyParser.tokenNames;
	}

	public String getGrammarFileName() {
		return "../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g";
	}



	private UmlPropertyGrammarAccess grammarAccess;

	public void setGrammarAccess(UmlPropertyGrammarAccess grammarAccess) {
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




	// $ANTLR start "entryRulePropertyRule"
	// InternalUmlProperty.g:60:1: entryRulePropertyRule : rulePropertyRule EOF ;
	public final void entryRulePropertyRule() throws RecognitionException {
		try {
			// InternalUmlProperty.g:61:1: ( rulePropertyRule EOF )
			// InternalUmlProperty.g:62:1: rulePropertyRule EOF
			{
				before(grammarAccess.getPropertyRuleRule());
				pushFollow(FOLLOW_1);
				rulePropertyRule();

				state._fsp--;

				after(grammarAccess.getPropertyRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRulePropertyRule"


	// $ANTLR start "rulePropertyRule"
	// InternalUmlProperty.g:69:1: rulePropertyRule : ( ( rule__PropertyRule__Group__0 ) ) ;
	public final void rulePropertyRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:73:2: ( ( ( rule__PropertyRule__Group__0 ) ) )
			// InternalUmlProperty.g:74:1: ( ( rule__PropertyRule__Group__0 ) )
			{
				// InternalUmlProperty.g:74:1: ( ( rule__PropertyRule__Group__0 ) )
				// InternalUmlProperty.g:75:1: ( rule__PropertyRule__Group__0 )
				{
					before(grammarAccess.getPropertyRuleAccess().getGroup());
					// InternalUmlProperty.g:76:1: ( rule__PropertyRule__Group__0 )
					// InternalUmlProperty.g:76:2: rule__PropertyRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__PropertyRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getPropertyRuleAccess().getGroup());

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
	// $ANTLR end "rulePropertyRule"


	// $ANTLR start "entryRuleVisibilityRule"
	// InternalUmlProperty.g:88:1: entryRuleVisibilityRule : ruleVisibilityRule EOF ;
	public final void entryRuleVisibilityRule() throws RecognitionException {
		try {
			// InternalUmlProperty.g:89:1: ( ruleVisibilityRule EOF )
			// InternalUmlProperty.g:90:1: ruleVisibilityRule EOF
			{
				before(grammarAccess.getVisibilityRuleRule());
				pushFollow(FOLLOW_1);
				ruleVisibilityRule();

				state._fsp--;

				after(grammarAccess.getVisibilityRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleVisibilityRule"


	// $ANTLR start "ruleVisibilityRule"
	// InternalUmlProperty.g:97:1: ruleVisibilityRule : ( ( rule__VisibilityRule__VisibilityAssignment ) ) ;
	public final void ruleVisibilityRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:101:2: ( ( ( rule__VisibilityRule__VisibilityAssignment ) ) )
			// InternalUmlProperty.g:102:1: ( ( rule__VisibilityRule__VisibilityAssignment ) )
			{
				// InternalUmlProperty.g:102:1: ( ( rule__VisibilityRule__VisibilityAssignment ) )
				// InternalUmlProperty.g:103:1: ( rule__VisibilityRule__VisibilityAssignment )
				{
					before(grammarAccess.getVisibilityRuleAccess().getVisibilityAssignment());
					// InternalUmlProperty.g:104:1: ( rule__VisibilityRule__VisibilityAssignment )
					// InternalUmlProperty.g:104:2: rule__VisibilityRule__VisibilityAssignment
					{
						pushFollow(FOLLOW_2);
						rule__VisibilityRule__VisibilityAssignment();

						state._fsp--;


					}

					after(grammarAccess.getVisibilityRuleAccess().getVisibilityAssignment());

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
	// $ANTLR end "ruleVisibilityRule"


	// $ANTLR start "entryRuleTypeRule"
	// InternalUmlProperty.g:116:1: entryRuleTypeRule : ruleTypeRule EOF ;
	public final void entryRuleTypeRule() throws RecognitionException {
		try {
			// InternalUmlProperty.g:117:1: ( ruleTypeRule EOF )
			// InternalUmlProperty.g:118:1: ruleTypeRule EOF
			{
				before(grammarAccess.getTypeRuleRule());
				pushFollow(FOLLOW_1);
				ruleTypeRule();

				state._fsp--;

				after(grammarAccess.getTypeRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleTypeRule"


	// $ANTLR start "ruleTypeRule"
	// InternalUmlProperty.g:125:1: ruleTypeRule : ( ( rule__TypeRule__Group__0 ) ) ;
	public final void ruleTypeRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:129:2: ( ( ( rule__TypeRule__Group__0 ) ) )
			// InternalUmlProperty.g:130:1: ( ( rule__TypeRule__Group__0 ) )
			{
				// InternalUmlProperty.g:130:1: ( ( rule__TypeRule__Group__0 ) )
				// InternalUmlProperty.g:131:1: ( rule__TypeRule__Group__0 )
				{
					before(grammarAccess.getTypeRuleAccess().getGroup());
					// InternalUmlProperty.g:132:1: ( rule__TypeRule__Group__0 )
					// InternalUmlProperty.g:132:2: rule__TypeRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__TypeRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getTypeRuleAccess().getGroup());

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
	// $ANTLR end "ruleTypeRule"


	// $ANTLR start "entryRuleQualifiedName"
	// InternalUmlProperty.g:144:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
	public final void entryRuleQualifiedName() throws RecognitionException {
		try {
			// InternalUmlProperty.g:145:1: ( ruleQualifiedName EOF )
			// InternalUmlProperty.g:146:1: ruleQualifiedName EOF
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
	// InternalUmlProperty.g:153:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
	public final void ruleQualifiedName() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:157:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
			// InternalUmlProperty.g:158:1: ( ( rule__QualifiedName__Group__0 ) )
			{
				// InternalUmlProperty.g:158:1: ( ( rule__QualifiedName__Group__0 ) )
				// InternalUmlProperty.g:159:1: ( rule__QualifiedName__Group__0 )
				{
					before(grammarAccess.getQualifiedNameAccess().getGroup());
					// InternalUmlProperty.g:160:1: ( rule__QualifiedName__Group__0 )
					// InternalUmlProperty.g:160:2: rule__QualifiedName__Group__0
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


	// $ANTLR start "entryRuleMultiplicityRule"
	// InternalUmlProperty.g:172:1: entryRuleMultiplicityRule : ruleMultiplicityRule EOF ;
	public final void entryRuleMultiplicityRule() throws RecognitionException {
		try {
			// InternalUmlProperty.g:173:1: ( ruleMultiplicityRule EOF )
			// InternalUmlProperty.g:174:1: ruleMultiplicityRule EOF
			{
				before(grammarAccess.getMultiplicityRuleRule());
				pushFollow(FOLLOW_1);
				ruleMultiplicityRule();

				state._fsp--;

				after(grammarAccess.getMultiplicityRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleMultiplicityRule"


	// $ANTLR start "ruleMultiplicityRule"
	// InternalUmlProperty.g:181:1: ruleMultiplicityRule : ( ( rule__MultiplicityRule__Group__0 ) ) ;
	public final void ruleMultiplicityRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:185:2: ( ( ( rule__MultiplicityRule__Group__0 ) ) )
			// InternalUmlProperty.g:186:1: ( ( rule__MultiplicityRule__Group__0 ) )
			{
				// InternalUmlProperty.g:186:1: ( ( rule__MultiplicityRule__Group__0 ) )
				// InternalUmlProperty.g:187:1: ( rule__MultiplicityRule__Group__0 )
				{
					before(grammarAccess.getMultiplicityRuleAccess().getGroup());
					// InternalUmlProperty.g:188:1: ( rule__MultiplicityRule__Group__0 )
					// InternalUmlProperty.g:188:2: rule__MultiplicityRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__MultiplicityRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getMultiplicityRuleAccess().getGroup());

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
	// $ANTLR end "ruleMultiplicityRule"


	// $ANTLR start "entryRuleBoundSpecification"
	// InternalUmlProperty.g:200:1: entryRuleBoundSpecification : ruleBoundSpecification EOF ;
	public final void entryRuleBoundSpecification() throws RecognitionException {
		try {
			// InternalUmlProperty.g:201:1: ( ruleBoundSpecification EOF )
			// InternalUmlProperty.g:202:1: ruleBoundSpecification EOF
			{
				before(grammarAccess.getBoundSpecificationRule());
				pushFollow(FOLLOW_1);
				ruleBoundSpecification();

				state._fsp--;

				after(grammarAccess.getBoundSpecificationRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleBoundSpecification"


	// $ANTLR start "ruleBoundSpecification"
	// InternalUmlProperty.g:209:1: ruleBoundSpecification : ( ( rule__BoundSpecification__ValueAssignment ) ) ;
	public final void ruleBoundSpecification() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:213:2: ( ( ( rule__BoundSpecification__ValueAssignment ) ) )
			// InternalUmlProperty.g:214:1: ( ( rule__BoundSpecification__ValueAssignment ) )
			{
				// InternalUmlProperty.g:214:1: ( ( rule__BoundSpecification__ValueAssignment ) )
				// InternalUmlProperty.g:215:1: ( rule__BoundSpecification__ValueAssignment )
				{
					before(grammarAccess.getBoundSpecificationAccess().getValueAssignment());
					// InternalUmlProperty.g:216:1: ( rule__BoundSpecification__ValueAssignment )
					// InternalUmlProperty.g:216:2: rule__BoundSpecification__ValueAssignment
					{
						pushFollow(FOLLOW_2);
						rule__BoundSpecification__ValueAssignment();

						state._fsp--;


					}

					after(grammarAccess.getBoundSpecificationAccess().getValueAssignment());

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
	// $ANTLR end "ruleBoundSpecification"


	// $ANTLR start "entryRuleUnlimitedLiteral"
	// InternalUmlProperty.g:228:1: entryRuleUnlimitedLiteral : ruleUnlimitedLiteral EOF ;
	public final void entryRuleUnlimitedLiteral() throws RecognitionException {
		try {
			// InternalUmlProperty.g:229:1: ( ruleUnlimitedLiteral EOF )
			// InternalUmlProperty.g:230:1: ruleUnlimitedLiteral EOF
			{
				before(grammarAccess.getUnlimitedLiteralRule());
				pushFollow(FOLLOW_1);
				ruleUnlimitedLiteral();

				state._fsp--;

				after(grammarAccess.getUnlimitedLiteralRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleUnlimitedLiteral"


	// $ANTLR start "ruleUnlimitedLiteral"
	// InternalUmlProperty.g:237:1: ruleUnlimitedLiteral : ( ( rule__UnlimitedLiteral__Alternatives ) ) ;
	public final void ruleUnlimitedLiteral() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:241:2: ( ( ( rule__UnlimitedLiteral__Alternatives ) ) )
			// InternalUmlProperty.g:242:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
			{
				// InternalUmlProperty.g:242:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
				// InternalUmlProperty.g:243:1: ( rule__UnlimitedLiteral__Alternatives )
				{
					before(grammarAccess.getUnlimitedLiteralAccess().getAlternatives());
					// InternalUmlProperty.g:244:1: ( rule__UnlimitedLiteral__Alternatives )
					// InternalUmlProperty.g:244:2: rule__UnlimitedLiteral__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__UnlimitedLiteral__Alternatives();

						state._fsp--;


					}

					after(grammarAccess.getUnlimitedLiteralAccess().getAlternatives());

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
	// $ANTLR end "ruleUnlimitedLiteral"


	// $ANTLR start "entryRuleStringLiteral"
	// InternalUmlProperty.g:256:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
	public final void entryRuleStringLiteral() throws RecognitionException {
		try {
			// InternalUmlProperty.g:257:1: ( ruleStringLiteral EOF )
			// InternalUmlProperty.g:258:1: ruleStringLiteral EOF
			{
				before(grammarAccess.getStringLiteralRule());
				pushFollow(FOLLOW_1);
				ruleStringLiteral();

				state._fsp--;

				after(grammarAccess.getStringLiteralRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleStringLiteral"


	// $ANTLR start "ruleStringLiteral"
	// InternalUmlProperty.g:265:1: ruleStringLiteral : ( RULE_STRING ) ;
	public final void ruleStringLiteral() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:269:2: ( ( RULE_STRING ) )
			// InternalUmlProperty.g:270:1: ( RULE_STRING )
			{
				// InternalUmlProperty.g:270:1: ( RULE_STRING )
				// InternalUmlProperty.g:271:1: RULE_STRING
				{
					before(grammarAccess.getStringLiteralAccess().getSTRINGTerminalRuleCall());
					match(input, RULE_STRING, FOLLOW_2);
					after(grammarAccess.getStringLiteralAccess().getSTRINGTerminalRuleCall());

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
	// $ANTLR end "ruleStringLiteral"


	// $ANTLR start "entryRuleModifiersRule"
	// InternalUmlProperty.g:284:1: entryRuleModifiersRule : ruleModifiersRule EOF ;
	public final void entryRuleModifiersRule() throws RecognitionException {
		try {
			// InternalUmlProperty.g:285:1: ( ruleModifiersRule EOF )
			// InternalUmlProperty.g:286:1: ruleModifiersRule EOF
			{
				before(grammarAccess.getModifiersRuleRule());
				pushFollow(FOLLOW_1);
				ruleModifiersRule();

				state._fsp--;

				after(grammarAccess.getModifiersRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleModifiersRule"


	// $ANTLR start "ruleModifiersRule"
	// InternalUmlProperty.g:293:1: ruleModifiersRule : ( ( rule__ModifiersRule__Group__0 ) ) ;
	public final void ruleModifiersRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:297:2: ( ( ( rule__ModifiersRule__Group__0 ) ) )
			// InternalUmlProperty.g:298:1: ( ( rule__ModifiersRule__Group__0 ) )
			{
				// InternalUmlProperty.g:298:1: ( ( rule__ModifiersRule__Group__0 ) )
				// InternalUmlProperty.g:299:1: ( rule__ModifiersRule__Group__0 )
				{
					before(grammarAccess.getModifiersRuleAccess().getGroup());
					// InternalUmlProperty.g:300:1: ( rule__ModifiersRule__Group__0 )
					// InternalUmlProperty.g:300:2: rule__ModifiersRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__ModifiersRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getModifiersRuleAccess().getGroup());

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
	// $ANTLR end "ruleModifiersRule"


	// $ANTLR start "entryRuleModifierSpecification"
	// InternalUmlProperty.g:312:1: entryRuleModifierSpecification : ruleModifierSpecification EOF ;
	public final void entryRuleModifierSpecification() throws RecognitionException {
		try {
			// InternalUmlProperty.g:313:1: ( ruleModifierSpecification EOF )
			// InternalUmlProperty.g:314:1: ruleModifierSpecification EOF
			{
				before(grammarAccess.getModifierSpecificationRule());
				pushFollow(FOLLOW_1);
				ruleModifierSpecification();

				state._fsp--;

				after(grammarAccess.getModifierSpecificationRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleModifierSpecification"


	// $ANTLR start "ruleModifierSpecification"
	// InternalUmlProperty.g:321:1: ruleModifierSpecification : ( ( rule__ModifierSpecification__Alternatives ) ) ;
	public final void ruleModifierSpecification() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:325:2: ( ( ( rule__ModifierSpecification__Alternatives ) ) )
			// InternalUmlProperty.g:326:1: ( ( rule__ModifierSpecification__Alternatives ) )
			{
				// InternalUmlProperty.g:326:1: ( ( rule__ModifierSpecification__Alternatives ) )
				// InternalUmlProperty.g:327:1: ( rule__ModifierSpecification__Alternatives )
				{
					before(grammarAccess.getModifierSpecificationAccess().getAlternatives());
					// InternalUmlProperty.g:328:1: ( rule__ModifierSpecification__Alternatives )
					// InternalUmlProperty.g:328:2: rule__ModifierSpecification__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__ModifierSpecification__Alternatives();

						state._fsp--;


					}

					after(grammarAccess.getModifierSpecificationAccess().getAlternatives());

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
	// $ANTLR end "ruleModifierSpecification"


	// $ANTLR start "entryRuleRedefinesRule"
	// InternalUmlProperty.g:340:1: entryRuleRedefinesRule : ruleRedefinesRule EOF ;
	public final void entryRuleRedefinesRule() throws RecognitionException {
		try {
			// InternalUmlProperty.g:341:1: ( ruleRedefinesRule EOF )
			// InternalUmlProperty.g:342:1: ruleRedefinesRule EOF
			{
				before(grammarAccess.getRedefinesRuleRule());
				pushFollow(FOLLOW_1);
				ruleRedefinesRule();

				state._fsp--;

				after(grammarAccess.getRedefinesRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleRedefinesRule"


	// $ANTLR start "ruleRedefinesRule"
	// InternalUmlProperty.g:349:1: ruleRedefinesRule : ( ( rule__RedefinesRule__Group__0 ) ) ;
	public final void ruleRedefinesRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:353:2: ( ( ( rule__RedefinesRule__Group__0 ) ) )
			// InternalUmlProperty.g:354:1: ( ( rule__RedefinesRule__Group__0 ) )
			{
				// InternalUmlProperty.g:354:1: ( ( rule__RedefinesRule__Group__0 ) )
				// InternalUmlProperty.g:355:1: ( rule__RedefinesRule__Group__0 )
				{
					before(grammarAccess.getRedefinesRuleAccess().getGroup());
					// InternalUmlProperty.g:356:1: ( rule__RedefinesRule__Group__0 )
					// InternalUmlProperty.g:356:2: rule__RedefinesRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__RedefinesRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getRedefinesRuleAccess().getGroup());

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
	// $ANTLR end "ruleRedefinesRule"


	// $ANTLR start "entryRuleSubsetsRule"
	// InternalUmlProperty.g:368:1: entryRuleSubsetsRule : ruleSubsetsRule EOF ;
	public final void entryRuleSubsetsRule() throws RecognitionException {
		try {
			// InternalUmlProperty.g:369:1: ( ruleSubsetsRule EOF )
			// InternalUmlProperty.g:370:1: ruleSubsetsRule EOF
			{
				before(grammarAccess.getSubsetsRuleRule());
				pushFollow(FOLLOW_1);
				ruleSubsetsRule();

				state._fsp--;

				after(grammarAccess.getSubsetsRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleSubsetsRule"


	// $ANTLR start "ruleSubsetsRule"
	// InternalUmlProperty.g:377:1: ruleSubsetsRule : ( ( rule__SubsetsRule__Group__0 ) ) ;
	public final void ruleSubsetsRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:381:2: ( ( ( rule__SubsetsRule__Group__0 ) ) )
			// InternalUmlProperty.g:382:1: ( ( rule__SubsetsRule__Group__0 ) )
			{
				// InternalUmlProperty.g:382:1: ( ( rule__SubsetsRule__Group__0 ) )
				// InternalUmlProperty.g:383:1: ( rule__SubsetsRule__Group__0 )
				{
					before(grammarAccess.getSubsetsRuleAccess().getGroup());
					// InternalUmlProperty.g:384:1: ( rule__SubsetsRule__Group__0 )
					// InternalUmlProperty.g:384:2: rule__SubsetsRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__SubsetsRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getSubsetsRuleAccess().getGroup());

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
	// $ANTLR end "ruleSubsetsRule"


	// $ANTLR start "entryRuleDefaultValueRule"
	// InternalUmlProperty.g:396:1: entryRuleDefaultValueRule : ruleDefaultValueRule EOF ;
	public final void entryRuleDefaultValueRule() throws RecognitionException {
		try {
			// InternalUmlProperty.g:397:1: ( ruleDefaultValueRule EOF )
			// InternalUmlProperty.g:398:1: ruleDefaultValueRule EOF
			{
				before(grammarAccess.getDefaultValueRuleRule());
				pushFollow(FOLLOW_1);
				ruleDefaultValueRule();

				state._fsp--;

				after(grammarAccess.getDefaultValueRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleDefaultValueRule"


	// $ANTLR start "ruleDefaultValueRule"
	// InternalUmlProperty.g:405:1: ruleDefaultValueRule : ( ( rule__DefaultValueRule__Group__0 ) ) ;
	public final void ruleDefaultValueRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:409:2: ( ( ( rule__DefaultValueRule__Group__0 ) ) )
			// InternalUmlProperty.g:410:1: ( ( rule__DefaultValueRule__Group__0 ) )
			{
				// InternalUmlProperty.g:410:1: ( ( rule__DefaultValueRule__Group__0 ) )
				// InternalUmlProperty.g:411:1: ( rule__DefaultValueRule__Group__0 )
				{
					before(grammarAccess.getDefaultValueRuleAccess().getGroup());
					// InternalUmlProperty.g:412:1: ( rule__DefaultValueRule__Group__0 )
					// InternalUmlProperty.g:412:2: rule__DefaultValueRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__DefaultValueRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getDefaultValueRuleAccess().getGroup());

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
	// $ANTLR end "ruleDefaultValueRule"


	// $ANTLR start "entryRuleValue"
	// InternalUmlProperty.g:424:1: entryRuleValue : ruleValue EOF ;
	public final void entryRuleValue() throws RecognitionException {
		try {
			// InternalUmlProperty.g:425:1: ( ruleValue EOF )
			// InternalUmlProperty.g:426:1: ruleValue EOF
			{
				before(grammarAccess.getValueRule());
				pushFollow(FOLLOW_1);
				ruleValue();

				state._fsp--;

				after(grammarAccess.getValueRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleValue"


	// $ANTLR start "ruleValue"
	// InternalUmlProperty.g:433:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
	public final void ruleValue() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:437:2: ( ( ( rule__Value__Alternatives ) ) )
			// InternalUmlProperty.g:438:1: ( ( rule__Value__Alternatives ) )
			{
				// InternalUmlProperty.g:438:1: ( ( rule__Value__Alternatives ) )
				// InternalUmlProperty.g:439:1: ( rule__Value__Alternatives )
				{
					before(grammarAccess.getValueAccess().getAlternatives());
					// InternalUmlProperty.g:440:1: ( rule__Value__Alternatives )
					// InternalUmlProperty.g:440:2: rule__Value__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Value__Alternatives();

						state._fsp--;


					}

					after(grammarAccess.getValueAccess().getAlternatives());

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
	// $ANTLR end "ruleValue"


	// $ANTLR start "entryRuleIntValue"
	// InternalUmlProperty.g:452:1: entryRuleIntValue : ruleIntValue EOF ;
	public final void entryRuleIntValue() throws RecognitionException {
		try {
			// InternalUmlProperty.g:453:1: ( ruleIntValue EOF )
			// InternalUmlProperty.g:454:1: ruleIntValue EOF
			{
				before(grammarAccess.getIntValueRule());
				pushFollow(FOLLOW_1);
				ruleIntValue();

				state._fsp--;

				after(grammarAccess.getIntValueRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleIntValue"


	// $ANTLR start "ruleIntValue"
	// InternalUmlProperty.g:461:1: ruleIntValue : ( ( rule__IntValue__LiteralIntegerAssignment ) ) ;
	public final void ruleIntValue() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:465:2: ( ( ( rule__IntValue__LiteralIntegerAssignment ) ) )
			// InternalUmlProperty.g:466:1: ( ( rule__IntValue__LiteralIntegerAssignment ) )
			{
				// InternalUmlProperty.g:466:1: ( ( rule__IntValue__LiteralIntegerAssignment ) )
				// InternalUmlProperty.g:467:1: ( rule__IntValue__LiteralIntegerAssignment )
				{
					before(grammarAccess.getIntValueAccess().getLiteralIntegerAssignment());
					// InternalUmlProperty.g:468:1: ( rule__IntValue__LiteralIntegerAssignment )
					// InternalUmlProperty.g:468:2: rule__IntValue__LiteralIntegerAssignment
					{
						pushFollow(FOLLOW_2);
						rule__IntValue__LiteralIntegerAssignment();

						state._fsp--;


					}

					after(grammarAccess.getIntValueAccess().getLiteralIntegerAssignment());

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
	// $ANTLR end "ruleIntValue"


	// $ANTLR start "entryRuleStringValue"
	// InternalUmlProperty.g:480:1: entryRuleStringValue : ruleStringValue EOF ;
	public final void entryRuleStringValue() throws RecognitionException {
		try {
			// InternalUmlProperty.g:481:1: ( ruleStringValue EOF )
			// InternalUmlProperty.g:482:1: ruleStringValue EOF
			{
				before(grammarAccess.getStringValueRule());
				pushFollow(FOLLOW_1);
				ruleStringValue();

				state._fsp--;

				after(grammarAccess.getStringValueRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleStringValue"


	// $ANTLR start "ruleStringValue"
	// InternalUmlProperty.g:489:1: ruleStringValue : ( ( rule__StringValue__LiteralStringAssignment ) ) ;
	public final void ruleStringValue() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:493:2: ( ( ( rule__StringValue__LiteralStringAssignment ) ) )
			// InternalUmlProperty.g:494:1: ( ( rule__StringValue__LiteralStringAssignment ) )
			{
				// InternalUmlProperty.g:494:1: ( ( rule__StringValue__LiteralStringAssignment ) )
				// InternalUmlProperty.g:495:1: ( rule__StringValue__LiteralStringAssignment )
				{
					before(grammarAccess.getStringValueAccess().getLiteralStringAssignment());
					// InternalUmlProperty.g:496:1: ( rule__StringValue__LiteralStringAssignment )
					// InternalUmlProperty.g:496:2: rule__StringValue__LiteralStringAssignment
					{
						pushFollow(FOLLOW_2);
						rule__StringValue__LiteralStringAssignment();

						state._fsp--;


					}

					after(grammarAccess.getStringValueAccess().getLiteralStringAssignment());

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
	// $ANTLR end "ruleStringValue"


	// $ANTLR start "entryRuleBooleanValue"
	// InternalUmlProperty.g:508:1: entryRuleBooleanValue : ruleBooleanValue EOF ;
	public final void entryRuleBooleanValue() throws RecognitionException {
		try {
			// InternalUmlProperty.g:509:1: ( ruleBooleanValue EOF )
			// InternalUmlProperty.g:510:1: ruleBooleanValue EOF
			{
				before(grammarAccess.getBooleanValueRule());
				pushFollow(FOLLOW_1);
				ruleBooleanValue();

				state._fsp--;

				after(grammarAccess.getBooleanValueRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleBooleanValue"


	// $ANTLR start "ruleBooleanValue"
	// InternalUmlProperty.g:517:1: ruleBooleanValue : ( ( rule__BooleanValue__LiteralBooleanAssignment ) ) ;
	public final void ruleBooleanValue() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:521:2: ( ( ( rule__BooleanValue__LiteralBooleanAssignment ) ) )
			// InternalUmlProperty.g:522:1: ( ( rule__BooleanValue__LiteralBooleanAssignment ) )
			{
				// InternalUmlProperty.g:522:1: ( ( rule__BooleanValue__LiteralBooleanAssignment ) )
				// InternalUmlProperty.g:523:1: ( rule__BooleanValue__LiteralBooleanAssignment )
				{
					before(grammarAccess.getBooleanValueAccess().getLiteralBooleanAssignment());
					// InternalUmlProperty.g:524:1: ( rule__BooleanValue__LiteralBooleanAssignment )
					// InternalUmlProperty.g:524:2: rule__BooleanValue__LiteralBooleanAssignment
					{
						pushFollow(FOLLOW_2);
						rule__BooleanValue__LiteralBooleanAssignment();

						state._fsp--;


					}

					after(grammarAccess.getBooleanValueAccess().getLiteralBooleanAssignment());

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
	// $ANTLR end "ruleBooleanValue"


	// $ANTLR start "entryRuleRealValue"
	// InternalUmlProperty.g:536:1: entryRuleRealValue : ruleRealValue EOF ;
	public final void entryRuleRealValue() throws RecognitionException {
		try {
			// InternalUmlProperty.g:537:1: ( ruleRealValue EOF )
			// InternalUmlProperty.g:538:1: ruleRealValue EOF
			{
				before(grammarAccess.getRealValueRule());
				pushFollow(FOLLOW_1);
				ruleRealValue();

				state._fsp--;

				after(grammarAccess.getRealValueRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleRealValue"


	// $ANTLR start "ruleRealValue"
	// InternalUmlProperty.g:545:1: ruleRealValue : ( ( rule__RealValue__Alternatives ) ) ;
	public final void ruleRealValue() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:549:2: ( ( ( rule__RealValue__Alternatives ) ) )
			// InternalUmlProperty.g:550:1: ( ( rule__RealValue__Alternatives ) )
			{
				// InternalUmlProperty.g:550:1: ( ( rule__RealValue__Alternatives ) )
				// InternalUmlProperty.g:551:1: ( rule__RealValue__Alternatives )
				{
					before(grammarAccess.getRealValueAccess().getAlternatives());
					// InternalUmlProperty.g:552:1: ( rule__RealValue__Alternatives )
					// InternalUmlProperty.g:552:2: rule__RealValue__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__RealValue__Alternatives();

						state._fsp--;


					}

					after(grammarAccess.getRealValueAccess().getAlternatives());

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
	// $ANTLR end "ruleRealValue"


	// $ANTLR start "entryRuleNullValue"
	// InternalUmlProperty.g:564:1: entryRuleNullValue : ruleNullValue EOF ;
	public final void entryRuleNullValue() throws RecognitionException {
		try {
			// InternalUmlProperty.g:565:1: ( ruleNullValue EOF )
			// InternalUmlProperty.g:566:1: ruleNullValue EOF
			{
				before(grammarAccess.getNullValueRule());
				pushFollow(FOLLOW_1);
				ruleNullValue();

				state._fsp--;

				after(grammarAccess.getNullValueRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleNullValue"


	// $ANTLR start "ruleNullValue"
	// InternalUmlProperty.g:573:1: ruleNullValue : ( ( rule__NullValue__Group__0 ) ) ;
	public final void ruleNullValue() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:577:2: ( ( ( rule__NullValue__Group__0 ) ) )
			// InternalUmlProperty.g:578:1: ( ( rule__NullValue__Group__0 ) )
			{
				// InternalUmlProperty.g:578:1: ( ( rule__NullValue__Group__0 ) )
				// InternalUmlProperty.g:579:1: ( rule__NullValue__Group__0 )
				{
					before(grammarAccess.getNullValueAccess().getGroup());
					// InternalUmlProperty.g:580:1: ( rule__NullValue__Group__0 )
					// InternalUmlProperty.g:580:2: rule__NullValue__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__NullValue__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getNullValueAccess().getGroup());

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
	// $ANTLR end "ruleNullValue"


	// $ANTLR start "entryRuleNoValue"
	// InternalUmlProperty.g:592:1: entryRuleNoValue : ruleNoValue EOF ;
	public final void entryRuleNoValue() throws RecognitionException {
		try {
			// InternalUmlProperty.g:593:1: ( ruleNoValue EOF )
			// InternalUmlProperty.g:594:1: ruleNoValue EOF
			{
				before(grammarAccess.getNoValueRule());
				pushFollow(FOLLOW_1);
				ruleNoValue();

				state._fsp--;

				after(grammarAccess.getNoValueRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleNoValue"


	// $ANTLR start "ruleNoValue"
	// InternalUmlProperty.g:601:1: ruleNoValue : ( ( rule__NoValue__Group__0 ) ) ;
	public final void ruleNoValue() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:605:2: ( ( ( rule__NoValue__Group__0 ) ) )
			// InternalUmlProperty.g:606:1: ( ( rule__NoValue__Group__0 ) )
			{
				// InternalUmlProperty.g:606:1: ( ( rule__NoValue__Group__0 ) )
				// InternalUmlProperty.g:607:1: ( rule__NoValue__Group__0 )
				{
					before(grammarAccess.getNoValueAccess().getGroup());
					// InternalUmlProperty.g:608:1: ( rule__NoValue__Group__0 )
					// InternalUmlProperty.g:608:2: rule__NoValue__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__NoValue__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getNoValueAccess().getGroup());

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
	// $ANTLR end "ruleNoValue"


	// $ANTLR start "ruleVisibilityKind"
	// InternalUmlProperty.g:621:1: ruleVisibilityKind : ( ( rule__VisibilityKind__Alternatives ) ) ;
	public final void ruleVisibilityKind() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:625:1: ( ( ( rule__VisibilityKind__Alternatives ) ) )
			// InternalUmlProperty.g:626:1: ( ( rule__VisibilityKind__Alternatives ) )
			{
				// InternalUmlProperty.g:626:1: ( ( rule__VisibilityKind__Alternatives ) )
				// InternalUmlProperty.g:627:1: ( rule__VisibilityKind__Alternatives )
				{
					before(grammarAccess.getVisibilityKindAccess().getAlternatives());
					// InternalUmlProperty.g:628:1: ( rule__VisibilityKind__Alternatives )
					// InternalUmlProperty.g:628:2: rule__VisibilityKind__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__VisibilityKind__Alternatives();

						state._fsp--;


					}

					after(grammarAccess.getVisibilityKindAccess().getAlternatives());

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
	// $ANTLR end "ruleVisibilityKind"


	// $ANTLR start "ruleModifierKind"
	// InternalUmlProperty.g:640:1: ruleModifierKind : ( ( rule__ModifierKind__Alternatives ) ) ;
	public final void ruleModifierKind() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:644:1: ( ( ( rule__ModifierKind__Alternatives ) ) )
			// InternalUmlProperty.g:645:1: ( ( rule__ModifierKind__Alternatives ) )
			{
				// InternalUmlProperty.g:645:1: ( ( rule__ModifierKind__Alternatives ) )
				// InternalUmlProperty.g:646:1: ( rule__ModifierKind__Alternatives )
				{
					before(grammarAccess.getModifierKindAccess().getAlternatives());
					// InternalUmlProperty.g:647:1: ( rule__ModifierKind__Alternatives )
					// InternalUmlProperty.g:647:2: rule__ModifierKind__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__ModifierKind__Alternatives();

						state._fsp--;


					}

					after(grammarAccess.getModifierKindAccess().getAlternatives());

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
	// $ANTLR end "ruleModifierKind"


	// $ANTLR start "ruleBooleanLiterals"
	// InternalUmlProperty.g:659:1: ruleBooleanLiterals : ( ( rule__BooleanLiterals__Alternatives ) ) ;
	public final void ruleBooleanLiterals() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:663:1: ( ( ( rule__BooleanLiterals__Alternatives ) ) )
			// InternalUmlProperty.g:664:1: ( ( rule__BooleanLiterals__Alternatives ) )
			{
				// InternalUmlProperty.g:664:1: ( ( rule__BooleanLiterals__Alternatives ) )
				// InternalUmlProperty.g:665:1: ( rule__BooleanLiterals__Alternatives )
				{
					before(grammarAccess.getBooleanLiteralsAccess().getAlternatives());
					// InternalUmlProperty.g:666:1: ( rule__BooleanLiterals__Alternatives )
					// InternalUmlProperty.g:666:2: rule__BooleanLiterals__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__BooleanLiterals__Alternatives();

						state._fsp--;


					}

					after(grammarAccess.getBooleanLiteralsAccess().getAlternatives());

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
	// $ANTLR end "ruleBooleanLiterals"


	// $ANTLR start "rule__PropertyRule__Alternatives_3_1"
	// InternalUmlProperty.g:677:1: rule__PropertyRule__Alternatives_3_1 : ( ( ( rule__PropertyRule__TypeAssignment_3_1_0 ) ) | ( ( rule__PropertyRule__TypeUndefinedAssignment_3_1_1 ) ) );
	public final void rule__PropertyRule__Alternatives_3_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:681:1: ( ( ( rule__PropertyRule__TypeAssignment_3_1_0 ) ) | ( ( rule__PropertyRule__TypeUndefinedAssignment_3_1_1 ) ) )
			int alt1 = 2;
			int LA1_0 = input.LA(1);

			if ((LA1_0 == RULE_ID)) {
				alt1 = 1;
			} else if ((LA1_0 == 38)) {
				alt1 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 1, 0, input);

				throw nvae;
			}
			switch (alt1) {
			case 1:
			// InternalUmlProperty.g:682:1: ( ( rule__PropertyRule__TypeAssignment_3_1_0 ) )
			{
				// InternalUmlProperty.g:682:1: ( ( rule__PropertyRule__TypeAssignment_3_1_0 ) )
				// InternalUmlProperty.g:683:1: ( rule__PropertyRule__TypeAssignment_3_1_0 )
				{
					before(grammarAccess.getPropertyRuleAccess().getTypeAssignment_3_1_0());
					// InternalUmlProperty.g:684:1: ( rule__PropertyRule__TypeAssignment_3_1_0 )
					// InternalUmlProperty.g:684:2: rule__PropertyRule__TypeAssignment_3_1_0
					{
						pushFollow(FOLLOW_2);
						rule__PropertyRule__TypeAssignment_3_1_0();

						state._fsp--;


					}

					after(grammarAccess.getPropertyRuleAccess().getTypeAssignment_3_1_0());

				}


			}
				break;
			case 2:
			// InternalUmlProperty.g:688:6: ( ( rule__PropertyRule__TypeUndefinedAssignment_3_1_1 ) )
			{
				// InternalUmlProperty.g:688:6: ( ( rule__PropertyRule__TypeUndefinedAssignment_3_1_1 ) )
				// InternalUmlProperty.g:689:1: ( rule__PropertyRule__TypeUndefinedAssignment_3_1_1 )
				{
					before(grammarAccess.getPropertyRuleAccess().getTypeUndefinedAssignment_3_1_1());
					// InternalUmlProperty.g:690:1: ( rule__PropertyRule__TypeUndefinedAssignment_3_1_1 )
					// InternalUmlProperty.g:690:2: rule__PropertyRule__TypeUndefinedAssignment_3_1_1
					{
						pushFollow(FOLLOW_2);
						rule__PropertyRule__TypeUndefinedAssignment_3_1_1();

						state._fsp--;


					}

					after(grammarAccess.getPropertyRuleAccess().getTypeUndefinedAssignment_3_1_1());

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
	// $ANTLR end "rule__PropertyRule__Alternatives_3_1"


	// $ANTLR start "rule__BoundSpecification__ValueAlternatives_0"
	// InternalUmlProperty.g:699:1: rule__BoundSpecification__ValueAlternatives_0 : ( ( ruleUnlimitedLiteral ) | ( ruleStringLiteral ) );
	public final void rule__BoundSpecification__ValueAlternatives_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:703:1: ( ( ruleUnlimitedLiteral ) | ( ruleStringLiteral ) )
			int alt2 = 2;
			int LA2_0 = input.LA(1);

			if ((LA2_0 == RULE_INT || LA2_0 == 12)) {
				alt2 = 1;
			} else if ((LA2_0 == RULE_STRING)) {
				alt2 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 2, 0, input);

				throw nvae;
			}
			switch (alt2) {
			case 1:
			// InternalUmlProperty.g:704:1: ( ruleUnlimitedLiteral )
			{
				// InternalUmlProperty.g:704:1: ( ruleUnlimitedLiteral )
				// InternalUmlProperty.g:705:1: ruleUnlimitedLiteral
				{
					before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleUnlimitedLiteral();

					state._fsp--;

					after(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0_0());

				}


			}
				break;
			case 2:
			// InternalUmlProperty.g:710:6: ( ruleStringLiteral )
			{
				// InternalUmlProperty.g:710:6: ( ruleStringLiteral )
				// InternalUmlProperty.g:711:1: ruleStringLiteral
				{
					before(grammarAccess.getBoundSpecificationAccess().getValueStringLiteralParserRuleCall_0_1());
					pushFollow(FOLLOW_2);
					ruleStringLiteral();

					state._fsp--;

					after(grammarAccess.getBoundSpecificationAccess().getValueStringLiteralParserRuleCall_0_1());

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
	// $ANTLR end "rule__BoundSpecification__ValueAlternatives_0"


	// $ANTLR start "rule__UnlimitedLiteral__Alternatives"
	// InternalUmlProperty.g:721:1: rule__UnlimitedLiteral__Alternatives : ( ( RULE_INT ) | ( '*' ) );
	public final void rule__UnlimitedLiteral__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:725:1: ( ( RULE_INT ) | ( '*' ) )
			int alt3 = 2;
			int LA3_0 = input.LA(1);

			if ((LA3_0 == RULE_INT)) {
				alt3 = 1;
			} else if ((LA3_0 == 12)) {
				alt3 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 3, 0, input);

				throw nvae;
			}
			switch (alt3) {
			case 1:
			// InternalUmlProperty.g:726:1: ( RULE_INT )
			{
				// InternalUmlProperty.g:726:1: ( RULE_INT )
				// InternalUmlProperty.g:727:1: RULE_INT
				{
					before(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0());
					match(input, RULE_INT, FOLLOW_2);
					after(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0());

				}


			}
				break;
			case 2:
			// InternalUmlProperty.g:732:6: ( '*' )
			{
				// InternalUmlProperty.g:732:6: ( '*' )
				// InternalUmlProperty.g:733:1: '*'
				{
					before(grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1());
					match(input, 12, FOLLOW_2);
					after(grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1());

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
	// $ANTLR end "rule__UnlimitedLiteral__Alternatives"


	// $ANTLR start "rule__ModifierSpecification__Alternatives"
	// InternalUmlProperty.g:745:1: rule__ModifierSpecification__Alternatives : ( ( ( rule__ModifierSpecification__ValueAssignment_0 ) ) | ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) ) | ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) ) );
	public final void rule__ModifierSpecification__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:749:1: ( ( ( rule__ModifierSpecification__ValueAssignment_0 ) ) | ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) ) | ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) ) )
			int alt4 = 3;
			switch (input.LA(1)) {
			case 17:
			case 18:
			case 19:
			case 20: {
				alt4 = 1;
			}
				break;
			case 31: {
				alt4 = 2;
			}
				break;
			case 32: {
				alt4 = 3;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 4, 0, input);

				throw nvae;
			}

			switch (alt4) {
			case 1:
			// InternalUmlProperty.g:750:1: ( ( rule__ModifierSpecification__ValueAssignment_0 ) )
			{
				// InternalUmlProperty.g:750:1: ( ( rule__ModifierSpecification__ValueAssignment_0 ) )
				// InternalUmlProperty.g:751:1: ( rule__ModifierSpecification__ValueAssignment_0 )
				{
					before(grammarAccess.getModifierSpecificationAccess().getValueAssignment_0());
					// InternalUmlProperty.g:752:1: ( rule__ModifierSpecification__ValueAssignment_0 )
					// InternalUmlProperty.g:752:2: rule__ModifierSpecification__ValueAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__ModifierSpecification__ValueAssignment_0();

						state._fsp--;


					}

					after(grammarAccess.getModifierSpecificationAccess().getValueAssignment_0());

				}


			}
				break;
			case 2:
			// InternalUmlProperty.g:756:6: ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) )
			{
				// InternalUmlProperty.g:756:6: ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) )
				// InternalUmlProperty.g:757:1: ( rule__ModifierSpecification__RedefinesAssignment_1 )
				{
					before(grammarAccess.getModifierSpecificationAccess().getRedefinesAssignment_1());
					// InternalUmlProperty.g:758:1: ( rule__ModifierSpecification__RedefinesAssignment_1 )
					// InternalUmlProperty.g:758:2: rule__ModifierSpecification__RedefinesAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__ModifierSpecification__RedefinesAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getModifierSpecificationAccess().getRedefinesAssignment_1());

				}


			}
				break;
			case 3:
			// InternalUmlProperty.g:762:6: ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) )
			{
				// InternalUmlProperty.g:762:6: ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) )
				// InternalUmlProperty.g:763:1: ( rule__ModifierSpecification__SubsetsAssignment_2 )
				{
					before(grammarAccess.getModifierSpecificationAccess().getSubsetsAssignment_2());
					// InternalUmlProperty.g:764:1: ( rule__ModifierSpecification__SubsetsAssignment_2 )
					// InternalUmlProperty.g:764:2: rule__ModifierSpecification__SubsetsAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__ModifierSpecification__SubsetsAssignment_2();

						state._fsp--;


					}

					after(grammarAccess.getModifierSpecificationAccess().getSubsetsAssignment_2());

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
	// $ANTLR end "rule__ModifierSpecification__Alternatives"


	// $ANTLR start "rule__Value__Alternatives"
	// InternalUmlProperty.g:773:1: rule__Value__Alternatives : ( ( ruleIntValue ) | ( ruleStringValue ) | ( ruleBooleanValue ) | ( ruleRealValue ) | ( ruleNullValue ) | ( ruleNoValue ) );
	public final void rule__Value__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:777:1: ( ( ruleIntValue ) | ( ruleStringValue ) | ( ruleBooleanValue ) | ( ruleRealValue ) | ( ruleNullValue ) | ( ruleNoValue ) )
			int alt5 = 6;
			switch (input.LA(1)) {
			case RULE_INT: {
				int LA5_1 = input.LA(2);

				if ((LA5_1 == 34)) {
					alt5 = 4;
				} else if ((LA5_1 == EOF)) {
					alt5 = 1;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 5, 1, input);

					throw nvae;
				}
			}
				break;
			case RULE_STRING: {
				alt5 = 2;
			}
				break;
			case 21:
			case 22: {
				alt5 = 3;
			}
				break;
			case 34: {
				alt5 = 4;
			}
				break;
			case 35: {
				alt5 = 5;
			}
				break;
			case 36: {
				alt5 = 6;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 5, 0, input);

				throw nvae;
			}

			switch (alt5) {
			case 1:
			// InternalUmlProperty.g:778:1: ( ruleIntValue )
			{
				// InternalUmlProperty.g:778:1: ( ruleIntValue )
				// InternalUmlProperty.g:779:1: ruleIntValue
				{
					before(grammarAccess.getValueAccess().getIntValueParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleIntValue();

					state._fsp--;

					after(grammarAccess.getValueAccess().getIntValueParserRuleCall_0());

				}


			}
				break;
			case 2:
			// InternalUmlProperty.g:784:6: ( ruleStringValue )
			{
				// InternalUmlProperty.g:784:6: ( ruleStringValue )
				// InternalUmlProperty.g:785:1: ruleStringValue
				{
					before(grammarAccess.getValueAccess().getStringValueParserRuleCall_1());
					pushFollow(FOLLOW_2);
					ruleStringValue();

					state._fsp--;

					after(grammarAccess.getValueAccess().getStringValueParserRuleCall_1());

				}


			}
				break;
			case 3:
			// InternalUmlProperty.g:790:6: ( ruleBooleanValue )
			{
				// InternalUmlProperty.g:790:6: ( ruleBooleanValue )
				// InternalUmlProperty.g:791:1: ruleBooleanValue
				{
					before(grammarAccess.getValueAccess().getBooleanValueParserRuleCall_2());
					pushFollow(FOLLOW_2);
					ruleBooleanValue();

					state._fsp--;

					after(grammarAccess.getValueAccess().getBooleanValueParserRuleCall_2());

				}


			}
				break;
			case 4:
			// InternalUmlProperty.g:796:6: ( ruleRealValue )
			{
				// InternalUmlProperty.g:796:6: ( ruleRealValue )
				// InternalUmlProperty.g:797:1: ruleRealValue
				{
					before(grammarAccess.getValueAccess().getRealValueParserRuleCall_3());
					pushFollow(FOLLOW_2);
					ruleRealValue();

					state._fsp--;

					after(grammarAccess.getValueAccess().getRealValueParserRuleCall_3());

				}


			}
				break;
			case 5:
			// InternalUmlProperty.g:802:6: ( ruleNullValue )
			{
				// InternalUmlProperty.g:802:6: ( ruleNullValue )
				// InternalUmlProperty.g:803:1: ruleNullValue
				{
					before(grammarAccess.getValueAccess().getNullValueParserRuleCall_4());
					pushFollow(FOLLOW_2);
					ruleNullValue();

					state._fsp--;

					after(grammarAccess.getValueAccess().getNullValueParserRuleCall_4());

				}


			}
				break;
			case 6:
			// InternalUmlProperty.g:808:6: ( ruleNoValue )
			{
				// InternalUmlProperty.g:808:6: ( ruleNoValue )
				// InternalUmlProperty.g:809:1: ruleNoValue
				{
					before(grammarAccess.getValueAccess().getNoValueParserRuleCall_5());
					pushFollow(FOLLOW_2);
					ruleNoValue();

					state._fsp--;

					after(grammarAccess.getValueAccess().getNoValueParserRuleCall_5());

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
	// $ANTLR end "rule__Value__Alternatives"


	// $ANTLR start "rule__RealValue__Alternatives"
	// InternalUmlProperty.g:819:1: rule__RealValue__Alternatives : ( ( ( rule__RealValue__Group_0__0 ) ) | ( ( rule__RealValue__Group_1__0 ) ) | ( ( rule__RealValue__Group_2__0 ) ) );
	public final void rule__RealValue__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:823:1: ( ( ( rule__RealValue__Group_0__0 ) ) | ( ( rule__RealValue__Group_1__0 ) ) | ( ( rule__RealValue__Group_2__0 ) ) )
			int alt6 = 3;
			int LA6_0 = input.LA(1);

			if ((LA6_0 == RULE_INT)) {
				int LA6_1 = input.LA(2);

				if ((LA6_1 == 34)) {
					int LA6_3 = input.LA(3);

					if ((LA6_3 == RULE_INT)) {
						alt6 = 3;
					} else if ((LA6_3 == EOF)) {
						alt6 = 1;
					} else {
						NoViableAltException nvae = new NoViableAltException("", 6, 3, input);

						throw nvae;
					}
				} else {
					NoViableAltException nvae = new NoViableAltException("", 6, 1, input);

					throw nvae;
				}
			} else if ((LA6_0 == 34)) {
				alt6 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 6, 0, input);

				throw nvae;
			}
			switch (alt6) {
			case 1:
			// InternalUmlProperty.g:824:1: ( ( rule__RealValue__Group_0__0 ) )
			{
				// InternalUmlProperty.g:824:1: ( ( rule__RealValue__Group_0__0 ) )
				// InternalUmlProperty.g:825:1: ( rule__RealValue__Group_0__0 )
				{
					before(grammarAccess.getRealValueAccess().getGroup_0());
					// InternalUmlProperty.g:826:1: ( rule__RealValue__Group_0__0 )
					// InternalUmlProperty.g:826:2: rule__RealValue__Group_0__0
					{
						pushFollow(FOLLOW_2);
						rule__RealValue__Group_0__0();

						state._fsp--;


					}

					after(grammarAccess.getRealValueAccess().getGroup_0());

				}


			}
				break;
			case 2:
			// InternalUmlProperty.g:830:6: ( ( rule__RealValue__Group_1__0 ) )
			{
				// InternalUmlProperty.g:830:6: ( ( rule__RealValue__Group_1__0 ) )
				// InternalUmlProperty.g:831:1: ( rule__RealValue__Group_1__0 )
				{
					before(grammarAccess.getRealValueAccess().getGroup_1());
					// InternalUmlProperty.g:832:1: ( rule__RealValue__Group_1__0 )
					// InternalUmlProperty.g:832:2: rule__RealValue__Group_1__0
					{
						pushFollow(FOLLOW_2);
						rule__RealValue__Group_1__0();

						state._fsp--;


					}

					after(grammarAccess.getRealValueAccess().getGroup_1());

				}


			}
				break;
			case 3:
			// InternalUmlProperty.g:836:6: ( ( rule__RealValue__Group_2__0 ) )
			{
				// InternalUmlProperty.g:836:6: ( ( rule__RealValue__Group_2__0 ) )
				// InternalUmlProperty.g:837:1: ( rule__RealValue__Group_2__0 )
				{
					before(grammarAccess.getRealValueAccess().getGroup_2());
					// InternalUmlProperty.g:838:1: ( rule__RealValue__Group_2__0 )
					// InternalUmlProperty.g:838:2: rule__RealValue__Group_2__0
					{
						pushFollow(FOLLOW_2);
						rule__RealValue__Group_2__0();

						state._fsp--;


					}

					after(grammarAccess.getRealValueAccess().getGroup_2());

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
	// $ANTLR end "rule__RealValue__Alternatives"


	// $ANTLR start "rule__VisibilityKind__Alternatives"
	// InternalUmlProperty.g:847:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );
	public final void rule__VisibilityKind__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:851:1: ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) )
			int alt7 = 4;
			switch (input.LA(1)) {
			case 13: {
				alt7 = 1;
			}
				break;
			case 14: {
				alt7 = 2;
			}
				break;
			case 15: {
				alt7 = 3;
			}
				break;
			case 16: {
				alt7 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 7, 0, input);

				throw nvae;
			}

			switch (alt7) {
			case 1:
			// InternalUmlProperty.g:852:1: ( ( '+' ) )
			{
				// InternalUmlProperty.g:852:1: ( ( '+' ) )
				// InternalUmlProperty.g:853:1: ( '+' )
				{
					before(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0());
					// InternalUmlProperty.g:854:1: ( '+' )
					// InternalUmlProperty.g:854:3: '+'
					{
						match(input, 13, FOLLOW_2);

					}

					after(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0());

				}


			}
				break;
			case 2:
			// InternalUmlProperty.g:859:6: ( ( '-' ) )
			{
				// InternalUmlProperty.g:859:6: ( ( '-' ) )
				// InternalUmlProperty.g:860:1: ( '-' )
				{
					before(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1());
					// InternalUmlProperty.g:861:1: ( '-' )
					// InternalUmlProperty.g:861:3: '-'
					{
						match(input, 14, FOLLOW_2);

					}

					after(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1());

				}


			}
				break;
			case 3:
			// InternalUmlProperty.g:866:6: ( ( '#' ) )
			{
				// InternalUmlProperty.g:866:6: ( ( '#' ) )
				// InternalUmlProperty.g:867:1: ( '#' )
				{
					before(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2());
					// InternalUmlProperty.g:868:1: ( '#' )
					// InternalUmlProperty.g:868:3: '#'
					{
						match(input, 15, FOLLOW_2);

					}

					after(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2());

				}


			}
				break;
			case 4:
			// InternalUmlProperty.g:873:6: ( ( '~' ) )
			{
				// InternalUmlProperty.g:873:6: ( ( '~' ) )
				// InternalUmlProperty.g:874:1: ( '~' )
				{
					before(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3());
					// InternalUmlProperty.g:875:1: ( '~' )
					// InternalUmlProperty.g:875:3: '~'
					{
						match(input, 16, FOLLOW_2);

					}

					after(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3());

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
	// $ANTLR end "rule__VisibilityKind__Alternatives"


	// $ANTLR start "rule__ModifierKind__Alternatives"
	// InternalUmlProperty.g:885:1: rule__ModifierKind__Alternatives : ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) );
	public final void rule__ModifierKind__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:889:1: ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) )
			int alt8 = 4;
			switch (input.LA(1)) {
			case 17: {
				alt8 = 1;
			}
				break;
			case 18: {
				alt8 = 2;
			}
				break;
			case 19: {
				alt8 = 3;
			}
				break;
			case 20: {
				alt8 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 8, 0, input);

				throw nvae;
			}

			switch (alt8) {
			case 1:
			// InternalUmlProperty.g:890:1: ( ( 'readOnly' ) )
			{
				// InternalUmlProperty.g:890:1: ( ( 'readOnly' ) )
				// InternalUmlProperty.g:891:1: ( 'readOnly' )
				{
					before(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0());
					// InternalUmlProperty.g:892:1: ( 'readOnly' )
					// InternalUmlProperty.g:892:3: 'readOnly'
					{
						match(input, 17, FOLLOW_2);

					}

					after(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0());

				}


			}
				break;
			case 2:
			// InternalUmlProperty.g:897:6: ( ( 'union' ) )
			{
				// InternalUmlProperty.g:897:6: ( ( 'union' ) )
				// InternalUmlProperty.g:898:1: ( 'union' )
				{
					before(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1());
					// InternalUmlProperty.g:899:1: ( 'union' )
					// InternalUmlProperty.g:899:3: 'union'
					{
						match(input, 18, FOLLOW_2);

					}

					after(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1());

				}


			}
				break;
			case 3:
			// InternalUmlProperty.g:904:6: ( ( 'ordered' ) )
			{
				// InternalUmlProperty.g:904:6: ( ( 'ordered' ) )
				// InternalUmlProperty.g:905:1: ( 'ordered' )
				{
					before(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2());
					// InternalUmlProperty.g:906:1: ( 'ordered' )
					// InternalUmlProperty.g:906:3: 'ordered'
					{
						match(input, 19, FOLLOW_2);

					}

					after(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2());

				}


			}
				break;
			case 4:
			// InternalUmlProperty.g:911:6: ( ( 'unique' ) )
			{
				// InternalUmlProperty.g:911:6: ( ( 'unique' ) )
				// InternalUmlProperty.g:912:1: ( 'unique' )
				{
					before(grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3());
					// InternalUmlProperty.g:913:1: ( 'unique' )
					// InternalUmlProperty.g:913:3: 'unique'
					{
						match(input, 20, FOLLOW_2);

					}

					after(grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3());

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
	// $ANTLR end "rule__ModifierKind__Alternatives"


	// $ANTLR start "rule__BooleanLiterals__Alternatives"
	// InternalUmlProperty.g:923:1: rule__BooleanLiterals__Alternatives : ( ( ( 'true' ) ) | ( ( 'false' ) ) );
	public final void rule__BooleanLiterals__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:927:1: ( ( ( 'true' ) ) | ( ( 'false' ) ) )
			int alt9 = 2;
			int LA9_0 = input.LA(1);

			if ((LA9_0 == 21)) {
				alt9 = 1;
			} else if ((LA9_0 == 22)) {
				alt9 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 9, 0, input);

				throw nvae;
			}
			switch (alt9) {
			case 1:
			// InternalUmlProperty.g:928:1: ( ( 'true' ) )
			{
				// InternalUmlProperty.g:928:1: ( ( 'true' ) )
				// InternalUmlProperty.g:929:1: ( 'true' )
				{
					before(grammarAccess.getBooleanLiteralsAccess().getTRUEEnumLiteralDeclaration_0());
					// InternalUmlProperty.g:930:1: ( 'true' )
					// InternalUmlProperty.g:930:3: 'true'
					{
						match(input, 21, FOLLOW_2);

					}

					after(grammarAccess.getBooleanLiteralsAccess().getTRUEEnumLiteralDeclaration_0());

				}


			}
				break;
			case 2:
			// InternalUmlProperty.g:935:6: ( ( 'false' ) )
			{
				// InternalUmlProperty.g:935:6: ( ( 'false' ) )
				// InternalUmlProperty.g:936:1: ( 'false' )
				{
					before(grammarAccess.getBooleanLiteralsAccess().getFALSEEnumLiteralDeclaration_1());
					// InternalUmlProperty.g:937:1: ( 'false' )
					// InternalUmlProperty.g:937:3: 'false'
					{
						match(input, 22, FOLLOW_2);

					}

					after(grammarAccess.getBooleanLiteralsAccess().getFALSEEnumLiteralDeclaration_1());

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
	// $ANTLR end "rule__BooleanLiterals__Alternatives"


	// $ANTLR start "rule__PropertyRule__Group__0"
	// InternalUmlProperty.g:949:1: rule__PropertyRule__Group__0 : rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1 ;
	public final void rule__PropertyRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:953:1: ( rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1 )
			// InternalUmlProperty.g:954:2: rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1
			{
				pushFollow(FOLLOW_3);
				rule__PropertyRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__PropertyRule__Group__1();

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
	// $ANTLR end "rule__PropertyRule__Group__0"


	// $ANTLR start "rule__PropertyRule__Group__0__Impl"
	// InternalUmlProperty.g:961:1: rule__PropertyRule__Group__0__Impl : ( ( rule__PropertyRule__VisibilityAssignment_0 )? ) ;
	public final void rule__PropertyRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:965:1: ( ( ( rule__PropertyRule__VisibilityAssignment_0 )? ) )
			// InternalUmlProperty.g:966:1: ( ( rule__PropertyRule__VisibilityAssignment_0 )? )
			{
				// InternalUmlProperty.g:966:1: ( ( rule__PropertyRule__VisibilityAssignment_0 )? )
				// InternalUmlProperty.g:967:1: ( rule__PropertyRule__VisibilityAssignment_0 )?
				{
					before(grammarAccess.getPropertyRuleAccess().getVisibilityAssignment_0());
					// InternalUmlProperty.g:968:1: ( rule__PropertyRule__VisibilityAssignment_0 )?
					int alt10 = 2;
					int LA10_0 = input.LA(1);

					if (((LA10_0 >= 13 && LA10_0 <= 16))) {
						alt10 = 1;
					}
					switch (alt10) {
					case 1:
					// InternalUmlProperty.g:968:2: rule__PropertyRule__VisibilityAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__PropertyRule__VisibilityAssignment_0();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getPropertyRuleAccess().getVisibilityAssignment_0());

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
	// $ANTLR end "rule__PropertyRule__Group__0__Impl"


	// $ANTLR start "rule__PropertyRule__Group__1"
	// InternalUmlProperty.g:978:1: rule__PropertyRule__Group__1 : rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2 ;
	public final void rule__PropertyRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:982:1: ( rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2 )
			// InternalUmlProperty.g:983:2: rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2
			{
				pushFollow(FOLLOW_3);
				rule__PropertyRule__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__PropertyRule__Group__2();

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
	// $ANTLR end "rule__PropertyRule__Group__1"


	// $ANTLR start "rule__PropertyRule__Group__1__Impl"
	// InternalUmlProperty.g:990:1: rule__PropertyRule__Group__1__Impl : ( ( rule__PropertyRule__DerivedAssignment_1 )? ) ;
	public final void rule__PropertyRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:994:1: ( ( ( rule__PropertyRule__DerivedAssignment_1 )? ) )
			// InternalUmlProperty.g:995:1: ( ( rule__PropertyRule__DerivedAssignment_1 )? )
			{
				// InternalUmlProperty.g:995:1: ( ( rule__PropertyRule__DerivedAssignment_1 )? )
				// InternalUmlProperty.g:996:1: ( rule__PropertyRule__DerivedAssignment_1 )?
				{
					before(grammarAccess.getPropertyRuleAccess().getDerivedAssignment_1());
					// InternalUmlProperty.g:997:1: ( rule__PropertyRule__DerivedAssignment_1 )?
					int alt11 = 2;
					int LA11_0 = input.LA(1);

					if ((LA11_0 == 37)) {
						alt11 = 1;
					}
					switch (alt11) {
					case 1:
					// InternalUmlProperty.g:997:2: rule__PropertyRule__DerivedAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__PropertyRule__DerivedAssignment_1();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getPropertyRuleAccess().getDerivedAssignment_1());

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
	// $ANTLR end "rule__PropertyRule__Group__1__Impl"


	// $ANTLR start "rule__PropertyRule__Group__2"
	// InternalUmlProperty.g:1007:1: rule__PropertyRule__Group__2 : rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3 ;
	public final void rule__PropertyRule__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1011:1: ( rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3 )
			// InternalUmlProperty.g:1012:2: rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3
			{
				pushFollow(FOLLOW_4);
				rule__PropertyRule__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__PropertyRule__Group__3();

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
	// $ANTLR end "rule__PropertyRule__Group__2"


	// $ANTLR start "rule__PropertyRule__Group__2__Impl"
	// InternalUmlProperty.g:1019:1: rule__PropertyRule__Group__2__Impl : ( ( rule__PropertyRule__NameAssignment_2 ) ) ;
	public final void rule__PropertyRule__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1023:1: ( ( ( rule__PropertyRule__NameAssignment_2 ) ) )
			// InternalUmlProperty.g:1024:1: ( ( rule__PropertyRule__NameAssignment_2 ) )
			{
				// InternalUmlProperty.g:1024:1: ( ( rule__PropertyRule__NameAssignment_2 ) )
				// InternalUmlProperty.g:1025:1: ( rule__PropertyRule__NameAssignment_2 )
				{
					before(grammarAccess.getPropertyRuleAccess().getNameAssignment_2());
					// InternalUmlProperty.g:1026:1: ( rule__PropertyRule__NameAssignment_2 )
					// InternalUmlProperty.g:1026:2: rule__PropertyRule__NameAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__PropertyRule__NameAssignment_2();

						state._fsp--;


					}

					after(grammarAccess.getPropertyRuleAccess().getNameAssignment_2());

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
	// $ANTLR end "rule__PropertyRule__Group__2__Impl"


	// $ANTLR start "rule__PropertyRule__Group__3"
	// InternalUmlProperty.g:1036:1: rule__PropertyRule__Group__3 : rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4 ;
	public final void rule__PropertyRule__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1040:1: ( rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4 )
			// InternalUmlProperty.g:1041:2: rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4
			{
				pushFollow(FOLLOW_4);
				rule__PropertyRule__Group__3__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__PropertyRule__Group__4();

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
	// $ANTLR end "rule__PropertyRule__Group__3"


	// $ANTLR start "rule__PropertyRule__Group__3__Impl"
	// InternalUmlProperty.g:1048:1: rule__PropertyRule__Group__3__Impl : ( ( rule__PropertyRule__Group_3__0 )? ) ;
	public final void rule__PropertyRule__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1052:1: ( ( ( rule__PropertyRule__Group_3__0 )? ) )
			// InternalUmlProperty.g:1053:1: ( ( rule__PropertyRule__Group_3__0 )? )
			{
				// InternalUmlProperty.g:1053:1: ( ( rule__PropertyRule__Group_3__0 )? )
				// InternalUmlProperty.g:1054:1: ( rule__PropertyRule__Group_3__0 )?
				{
					before(grammarAccess.getPropertyRuleAccess().getGroup_3());
					// InternalUmlProperty.g:1055:1: ( rule__PropertyRule__Group_3__0 )?
					int alt12 = 2;
					int LA12_0 = input.LA(1);

					if ((LA12_0 == 23)) {
						alt12 = 1;
					}
					switch (alt12) {
					case 1:
					// InternalUmlProperty.g:1055:2: rule__PropertyRule__Group_3__0
					{
						pushFollow(FOLLOW_2);
						rule__PropertyRule__Group_3__0();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getPropertyRuleAccess().getGroup_3());

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
	// $ANTLR end "rule__PropertyRule__Group__3__Impl"


	// $ANTLR start "rule__PropertyRule__Group__4"
	// InternalUmlProperty.g:1065:1: rule__PropertyRule__Group__4 : rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5 ;
	public final void rule__PropertyRule__Group__4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1069:1: ( rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5 )
			// InternalUmlProperty.g:1070:2: rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5
			{
				pushFollow(FOLLOW_4);
				rule__PropertyRule__Group__4__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__PropertyRule__Group__5();

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
	// $ANTLR end "rule__PropertyRule__Group__4"


	// $ANTLR start "rule__PropertyRule__Group__4__Impl"
	// InternalUmlProperty.g:1077:1: rule__PropertyRule__Group__4__Impl : ( ( rule__PropertyRule__MultiplicityAssignment_4 )? ) ;
	public final void rule__PropertyRule__Group__4__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1081:1: ( ( ( rule__PropertyRule__MultiplicityAssignment_4 )? ) )
			// InternalUmlProperty.g:1082:1: ( ( rule__PropertyRule__MultiplicityAssignment_4 )? )
			{
				// InternalUmlProperty.g:1082:1: ( ( rule__PropertyRule__MultiplicityAssignment_4 )? )
				// InternalUmlProperty.g:1083:1: ( rule__PropertyRule__MultiplicityAssignment_4 )?
				{
					before(grammarAccess.getPropertyRuleAccess().getMultiplicityAssignment_4());
					// InternalUmlProperty.g:1084:1: ( rule__PropertyRule__MultiplicityAssignment_4 )?
					int alt13 = 2;
					int LA13_0 = input.LA(1);

					if ((LA13_0 == 25)) {
						alt13 = 1;
					}
					switch (alt13) {
					case 1:
					// InternalUmlProperty.g:1084:2: rule__PropertyRule__MultiplicityAssignment_4
					{
						pushFollow(FOLLOW_2);
						rule__PropertyRule__MultiplicityAssignment_4();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getPropertyRuleAccess().getMultiplicityAssignment_4());

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
	// $ANTLR end "rule__PropertyRule__Group__4__Impl"


	// $ANTLR start "rule__PropertyRule__Group__5"
	// InternalUmlProperty.g:1094:1: rule__PropertyRule__Group__5 : rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6 ;
	public final void rule__PropertyRule__Group__5() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1098:1: ( rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6 )
			// InternalUmlProperty.g:1099:2: rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6
			{
				pushFollow(FOLLOW_4);
				rule__PropertyRule__Group__5__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__PropertyRule__Group__6();

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
	// $ANTLR end "rule__PropertyRule__Group__5"


	// $ANTLR start "rule__PropertyRule__Group__5__Impl"
	// InternalUmlProperty.g:1106:1: rule__PropertyRule__Group__5__Impl : ( ( rule__PropertyRule__ModifiersAssignment_5 )? ) ;
	public final void rule__PropertyRule__Group__5__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1110:1: ( ( ( rule__PropertyRule__ModifiersAssignment_5 )? ) )
			// InternalUmlProperty.g:1111:1: ( ( rule__PropertyRule__ModifiersAssignment_5 )? )
			{
				// InternalUmlProperty.g:1111:1: ( ( rule__PropertyRule__ModifiersAssignment_5 )? )
				// InternalUmlProperty.g:1112:1: ( rule__PropertyRule__ModifiersAssignment_5 )?
				{
					before(grammarAccess.getPropertyRuleAccess().getModifiersAssignment_5());
					// InternalUmlProperty.g:1113:1: ( rule__PropertyRule__ModifiersAssignment_5 )?
					int alt14 = 2;
					int LA14_0 = input.LA(1);

					if ((LA14_0 == 28)) {
						alt14 = 1;
					}
					switch (alt14) {
					case 1:
					// InternalUmlProperty.g:1113:2: rule__PropertyRule__ModifiersAssignment_5
					{
						pushFollow(FOLLOW_2);
						rule__PropertyRule__ModifiersAssignment_5();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getPropertyRuleAccess().getModifiersAssignment_5());

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
	// $ANTLR end "rule__PropertyRule__Group__5__Impl"


	// $ANTLR start "rule__PropertyRule__Group__6"
	// InternalUmlProperty.g:1123:1: rule__PropertyRule__Group__6 : rule__PropertyRule__Group__6__Impl ;
	public final void rule__PropertyRule__Group__6() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1127:1: ( rule__PropertyRule__Group__6__Impl )
			// InternalUmlProperty.g:1128:2: rule__PropertyRule__Group__6__Impl
			{
				pushFollow(FOLLOW_2);
				rule__PropertyRule__Group__6__Impl();

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
	// $ANTLR end "rule__PropertyRule__Group__6"


	// $ANTLR start "rule__PropertyRule__Group__6__Impl"
	// InternalUmlProperty.g:1134:1: rule__PropertyRule__Group__6__Impl : ( ( rule__PropertyRule__DefaultAssignment_6 )? ) ;
	public final void rule__PropertyRule__Group__6__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1138:1: ( ( ( rule__PropertyRule__DefaultAssignment_6 )? ) )
			// InternalUmlProperty.g:1139:1: ( ( rule__PropertyRule__DefaultAssignment_6 )? )
			{
				// InternalUmlProperty.g:1139:1: ( ( rule__PropertyRule__DefaultAssignment_6 )? )
				// InternalUmlProperty.g:1140:1: ( rule__PropertyRule__DefaultAssignment_6 )?
				{
					before(grammarAccess.getPropertyRuleAccess().getDefaultAssignment_6());
					// InternalUmlProperty.g:1141:1: ( rule__PropertyRule__DefaultAssignment_6 )?
					int alt15 = 2;
					int LA15_0 = input.LA(1);

					if ((LA15_0 == 33)) {
						alt15 = 1;
					}
					switch (alt15) {
					case 1:
					// InternalUmlProperty.g:1141:2: rule__PropertyRule__DefaultAssignment_6
					{
						pushFollow(FOLLOW_2);
						rule__PropertyRule__DefaultAssignment_6();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getPropertyRuleAccess().getDefaultAssignment_6());

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
	// $ANTLR end "rule__PropertyRule__Group__6__Impl"


	// $ANTLR start "rule__PropertyRule__Group_3__0"
	// InternalUmlProperty.g:1165:1: rule__PropertyRule__Group_3__0 : rule__PropertyRule__Group_3__0__Impl rule__PropertyRule__Group_3__1 ;
	public final void rule__PropertyRule__Group_3__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1169:1: ( rule__PropertyRule__Group_3__0__Impl rule__PropertyRule__Group_3__1 )
			// InternalUmlProperty.g:1170:2: rule__PropertyRule__Group_3__0__Impl rule__PropertyRule__Group_3__1
			{
				pushFollow(FOLLOW_5);
				rule__PropertyRule__Group_3__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__PropertyRule__Group_3__1();

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
	// $ANTLR end "rule__PropertyRule__Group_3__0"


	// $ANTLR start "rule__PropertyRule__Group_3__0__Impl"
	// InternalUmlProperty.g:1177:1: rule__PropertyRule__Group_3__0__Impl : ( ':' ) ;
	public final void rule__PropertyRule__Group_3__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1181:1: ( ( ':' ) )
			// InternalUmlProperty.g:1182:1: ( ':' )
			{
				// InternalUmlProperty.g:1182:1: ( ':' )
				// InternalUmlProperty.g:1183:1: ':'
				{
					before(grammarAccess.getPropertyRuleAccess().getColonKeyword_3_0());
					match(input, 23, FOLLOW_2);
					after(grammarAccess.getPropertyRuleAccess().getColonKeyword_3_0());

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
	// $ANTLR end "rule__PropertyRule__Group_3__0__Impl"


	// $ANTLR start "rule__PropertyRule__Group_3__1"
	// InternalUmlProperty.g:1196:1: rule__PropertyRule__Group_3__1 : rule__PropertyRule__Group_3__1__Impl ;
	public final void rule__PropertyRule__Group_3__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1200:1: ( rule__PropertyRule__Group_3__1__Impl )
			// InternalUmlProperty.g:1201:2: rule__PropertyRule__Group_3__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__PropertyRule__Group_3__1__Impl();

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
	// $ANTLR end "rule__PropertyRule__Group_3__1"


	// $ANTLR start "rule__PropertyRule__Group_3__1__Impl"
	// InternalUmlProperty.g:1207:1: rule__PropertyRule__Group_3__1__Impl : ( ( rule__PropertyRule__Alternatives_3_1 ) ) ;
	public final void rule__PropertyRule__Group_3__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1211:1: ( ( ( rule__PropertyRule__Alternatives_3_1 ) ) )
			// InternalUmlProperty.g:1212:1: ( ( rule__PropertyRule__Alternatives_3_1 ) )
			{
				// InternalUmlProperty.g:1212:1: ( ( rule__PropertyRule__Alternatives_3_1 ) )
				// InternalUmlProperty.g:1213:1: ( rule__PropertyRule__Alternatives_3_1 )
				{
					before(grammarAccess.getPropertyRuleAccess().getAlternatives_3_1());
					// InternalUmlProperty.g:1214:1: ( rule__PropertyRule__Alternatives_3_1 )
					// InternalUmlProperty.g:1214:2: rule__PropertyRule__Alternatives_3_1
					{
						pushFollow(FOLLOW_2);
						rule__PropertyRule__Alternatives_3_1();

						state._fsp--;


					}

					after(grammarAccess.getPropertyRuleAccess().getAlternatives_3_1());

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
	// $ANTLR end "rule__PropertyRule__Group_3__1__Impl"


	// $ANTLR start "rule__TypeRule__Group__0"
	// InternalUmlProperty.g:1228:1: rule__TypeRule__Group__0 : rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 ;
	public final void rule__TypeRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1232:1: ( rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 )
			// InternalUmlProperty.g:1233:2: rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1
			{
				pushFollow(FOLLOW_6);
				rule__TypeRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__TypeRule__Group__1();

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
	// $ANTLR end "rule__TypeRule__Group__0"


	// $ANTLR start "rule__TypeRule__Group__0__Impl"
	// InternalUmlProperty.g:1240:1: rule__TypeRule__Group__0__Impl : ( ( rule__TypeRule__PathAssignment_0 )? ) ;
	public final void rule__TypeRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1244:1: ( ( ( rule__TypeRule__PathAssignment_0 )? ) )
			// InternalUmlProperty.g:1245:1: ( ( rule__TypeRule__PathAssignment_0 )? )
			{
				// InternalUmlProperty.g:1245:1: ( ( rule__TypeRule__PathAssignment_0 )? )
				// InternalUmlProperty.g:1246:1: ( rule__TypeRule__PathAssignment_0 )?
				{
					before(grammarAccess.getTypeRuleAccess().getPathAssignment_0());
					// InternalUmlProperty.g:1247:1: ( rule__TypeRule__PathAssignment_0 )?
					int alt16 = 2;
					int LA16_0 = input.LA(1);

					if ((LA16_0 == RULE_ID)) {
						int LA16_1 = input.LA(2);

						if ((LA16_1 == 24)) {
							alt16 = 1;
						}
					}
					switch (alt16) {
					case 1:
					// InternalUmlProperty.g:1247:2: rule__TypeRule__PathAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__TypeRule__PathAssignment_0();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getTypeRuleAccess().getPathAssignment_0());

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
	// $ANTLR end "rule__TypeRule__Group__0__Impl"


	// $ANTLR start "rule__TypeRule__Group__1"
	// InternalUmlProperty.g:1257:1: rule__TypeRule__Group__1 : rule__TypeRule__Group__1__Impl ;
	public final void rule__TypeRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1261:1: ( rule__TypeRule__Group__1__Impl )
			// InternalUmlProperty.g:1262:2: rule__TypeRule__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__TypeRule__Group__1__Impl();

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
	// $ANTLR end "rule__TypeRule__Group__1"


	// $ANTLR start "rule__TypeRule__Group__1__Impl"
	// InternalUmlProperty.g:1268:1: rule__TypeRule__Group__1__Impl : ( ( rule__TypeRule__TypeAssignment_1 ) ) ;
	public final void rule__TypeRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1272:1: ( ( ( rule__TypeRule__TypeAssignment_1 ) ) )
			// InternalUmlProperty.g:1273:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
			{
				// InternalUmlProperty.g:1273:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
				// InternalUmlProperty.g:1274:1: ( rule__TypeRule__TypeAssignment_1 )
				{
					before(grammarAccess.getTypeRuleAccess().getTypeAssignment_1());
					// InternalUmlProperty.g:1275:1: ( rule__TypeRule__TypeAssignment_1 )
					// InternalUmlProperty.g:1275:2: rule__TypeRule__TypeAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__TypeRule__TypeAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getTypeRuleAccess().getTypeAssignment_1());

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
	// $ANTLR end "rule__TypeRule__Group__1__Impl"


	// $ANTLR start "rule__QualifiedName__Group__0"
	// InternalUmlProperty.g:1289:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
	public final void rule__QualifiedName__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1293:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
			// InternalUmlProperty.g:1294:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
			{
				pushFollow(FOLLOW_7);
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
	// InternalUmlProperty.g:1301:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
	public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1305:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
			// InternalUmlProperty.g:1306:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
			{
				// InternalUmlProperty.g:1306:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
				// InternalUmlProperty.g:1307:1: ( rule__QualifiedName__PathAssignment_0 )
				{
					before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0());
					// InternalUmlProperty.g:1308:1: ( rule__QualifiedName__PathAssignment_0 )
					// InternalUmlProperty.g:1308:2: rule__QualifiedName__PathAssignment_0
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
	// InternalUmlProperty.g:1318:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
	public final void rule__QualifiedName__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1322:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
			// InternalUmlProperty.g:1323:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
			{
				pushFollow(FOLLOW_6);
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
	// InternalUmlProperty.g:1330:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
	public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1334:1: ( ( '::' ) )
			// InternalUmlProperty.g:1335:1: ( '::' )
			{
				// InternalUmlProperty.g:1335:1: ( '::' )
				// InternalUmlProperty.g:1336:1: '::'
				{
					before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());
					match(input, 24, FOLLOW_2);
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
	// InternalUmlProperty.g:1349:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
	public final void rule__QualifiedName__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1353:1: ( rule__QualifiedName__Group__2__Impl )
			// InternalUmlProperty.g:1354:2: rule__QualifiedName__Group__2__Impl
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
	// InternalUmlProperty.g:1360:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
	public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1364:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
			// InternalUmlProperty.g:1365:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
			{
				// InternalUmlProperty.g:1365:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
				// InternalUmlProperty.g:1366:1: ( rule__QualifiedName__RemainingAssignment_2 )?
				{
					before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2());
					// InternalUmlProperty.g:1367:1: ( rule__QualifiedName__RemainingAssignment_2 )?
					int alt17 = 2;
					int LA17_0 = input.LA(1);

					if ((LA17_0 == RULE_ID)) {
						int LA17_1 = input.LA(2);

						if ((LA17_1 == 24)) {
							alt17 = 1;
						}
					}
					switch (alt17) {
					case 1:
					// InternalUmlProperty.g:1367:2: rule__QualifiedName__RemainingAssignment_2
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


	// $ANTLR start "rule__MultiplicityRule__Group__0"
	// InternalUmlProperty.g:1383:1: rule__MultiplicityRule__Group__0 : rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 ;
	public final void rule__MultiplicityRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1387:1: ( rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 )
			// InternalUmlProperty.g:1388:2: rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1
			{
				pushFollow(FOLLOW_8);
				rule__MultiplicityRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__MultiplicityRule__Group__1();

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
	// $ANTLR end "rule__MultiplicityRule__Group__0"


	// $ANTLR start "rule__MultiplicityRule__Group__0__Impl"
	// InternalUmlProperty.g:1395:1: rule__MultiplicityRule__Group__0__Impl : ( '[' ) ;
	public final void rule__MultiplicityRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1399:1: ( ( '[' ) )
			// InternalUmlProperty.g:1400:1: ( '[' )
			{
				// InternalUmlProperty.g:1400:1: ( '[' )
				// InternalUmlProperty.g:1401:1: '['
				{
					before(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0());
					match(input, 25, FOLLOW_2);
					after(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0());

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
	// $ANTLR end "rule__MultiplicityRule__Group__0__Impl"


	// $ANTLR start "rule__MultiplicityRule__Group__1"
	// InternalUmlProperty.g:1414:1: rule__MultiplicityRule__Group__1 : rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 ;
	public final void rule__MultiplicityRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1418:1: ( rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 )
			// InternalUmlProperty.g:1419:2: rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2
			{
				pushFollow(FOLLOW_9);
				rule__MultiplicityRule__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__MultiplicityRule__Group__2();

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
	// $ANTLR end "rule__MultiplicityRule__Group__1"


	// $ANTLR start "rule__MultiplicityRule__Group__1__Impl"
	// InternalUmlProperty.g:1426:1: rule__MultiplicityRule__Group__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) ;
	public final void rule__MultiplicityRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1430:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) )
			// InternalUmlProperty.g:1431:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
			{
				// InternalUmlProperty.g:1431:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
				// InternalUmlProperty.g:1432:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
				{
					before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1());
					// InternalUmlProperty.g:1433:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
					// InternalUmlProperty.g:1433:2: rule__MultiplicityRule__BoundsAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__MultiplicityRule__BoundsAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1());

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
	// $ANTLR end "rule__MultiplicityRule__Group__1__Impl"


	// $ANTLR start "rule__MultiplicityRule__Group__2"
	// InternalUmlProperty.g:1443:1: rule__MultiplicityRule__Group__2 : rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 ;
	public final void rule__MultiplicityRule__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1447:1: ( rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 )
			// InternalUmlProperty.g:1448:2: rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3
			{
				pushFollow(FOLLOW_9);
				rule__MultiplicityRule__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__MultiplicityRule__Group__3();

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
	// $ANTLR end "rule__MultiplicityRule__Group__2"


	// $ANTLR start "rule__MultiplicityRule__Group__2__Impl"
	// InternalUmlProperty.g:1455:1: rule__MultiplicityRule__Group__2__Impl : ( ( rule__MultiplicityRule__Group_2__0 )? ) ;
	public final void rule__MultiplicityRule__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1459:1: ( ( ( rule__MultiplicityRule__Group_2__0 )? ) )
			// InternalUmlProperty.g:1460:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
			{
				// InternalUmlProperty.g:1460:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
				// InternalUmlProperty.g:1461:1: ( rule__MultiplicityRule__Group_2__0 )?
				{
					before(grammarAccess.getMultiplicityRuleAccess().getGroup_2());
					// InternalUmlProperty.g:1462:1: ( rule__MultiplicityRule__Group_2__0 )?
					int alt18 = 2;
					int LA18_0 = input.LA(1);

					if ((LA18_0 == 27)) {
						alt18 = 1;
					}
					switch (alt18) {
					case 1:
					// InternalUmlProperty.g:1462:2: rule__MultiplicityRule__Group_2__0
					{
						pushFollow(FOLLOW_2);
						rule__MultiplicityRule__Group_2__0();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getMultiplicityRuleAccess().getGroup_2());

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
	// $ANTLR end "rule__MultiplicityRule__Group__2__Impl"


	// $ANTLR start "rule__MultiplicityRule__Group__3"
	// InternalUmlProperty.g:1472:1: rule__MultiplicityRule__Group__3 : rule__MultiplicityRule__Group__3__Impl ;
	public final void rule__MultiplicityRule__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1476:1: ( rule__MultiplicityRule__Group__3__Impl )
			// InternalUmlProperty.g:1477:2: rule__MultiplicityRule__Group__3__Impl
			{
				pushFollow(FOLLOW_2);
				rule__MultiplicityRule__Group__3__Impl();

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
	// $ANTLR end "rule__MultiplicityRule__Group__3"


	// $ANTLR start "rule__MultiplicityRule__Group__3__Impl"
	// InternalUmlProperty.g:1483:1: rule__MultiplicityRule__Group__3__Impl : ( ']' ) ;
	public final void rule__MultiplicityRule__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1487:1: ( ( ']' ) )
			// InternalUmlProperty.g:1488:1: ( ']' )
			{
				// InternalUmlProperty.g:1488:1: ( ']' )
				// InternalUmlProperty.g:1489:1: ']'
				{
					before(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3());
					match(input, 26, FOLLOW_2);
					after(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3());

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
	// $ANTLR end "rule__MultiplicityRule__Group__3__Impl"


	// $ANTLR start "rule__MultiplicityRule__Group_2__0"
	// InternalUmlProperty.g:1510:1: rule__MultiplicityRule__Group_2__0 : rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 ;
	public final void rule__MultiplicityRule__Group_2__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1514:1: ( rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 )
			// InternalUmlProperty.g:1515:2: rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1
			{
				pushFollow(FOLLOW_8);
				rule__MultiplicityRule__Group_2__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__MultiplicityRule__Group_2__1();

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
	// $ANTLR end "rule__MultiplicityRule__Group_2__0"


	// $ANTLR start "rule__MultiplicityRule__Group_2__0__Impl"
	// InternalUmlProperty.g:1522:1: rule__MultiplicityRule__Group_2__0__Impl : ( '..' ) ;
	public final void rule__MultiplicityRule__Group_2__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1526:1: ( ( '..' ) )
			// InternalUmlProperty.g:1527:1: ( '..' )
			{
				// InternalUmlProperty.g:1527:1: ( '..' )
				// InternalUmlProperty.g:1528:1: '..'
				{
					before(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0());
					match(input, 27, FOLLOW_2);
					after(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0());

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
	// $ANTLR end "rule__MultiplicityRule__Group_2__0__Impl"


	// $ANTLR start "rule__MultiplicityRule__Group_2__1"
	// InternalUmlProperty.g:1541:1: rule__MultiplicityRule__Group_2__1 : rule__MultiplicityRule__Group_2__1__Impl ;
	public final void rule__MultiplicityRule__Group_2__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1545:1: ( rule__MultiplicityRule__Group_2__1__Impl )
			// InternalUmlProperty.g:1546:2: rule__MultiplicityRule__Group_2__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__MultiplicityRule__Group_2__1__Impl();

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
	// $ANTLR end "rule__MultiplicityRule__Group_2__1"


	// $ANTLR start "rule__MultiplicityRule__Group_2__1__Impl"
	// InternalUmlProperty.g:1552:1: rule__MultiplicityRule__Group_2__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) ;
	public final void rule__MultiplicityRule__Group_2__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1556:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) )
			// InternalUmlProperty.g:1557:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
			{
				// InternalUmlProperty.g:1557:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
				// InternalUmlProperty.g:1558:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
				{
					before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2_1());
					// InternalUmlProperty.g:1559:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
					// InternalUmlProperty.g:1559:2: rule__MultiplicityRule__BoundsAssignment_2_1
					{
						pushFollow(FOLLOW_2);
						rule__MultiplicityRule__BoundsAssignment_2_1();

						state._fsp--;


					}

					after(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2_1());

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
	// $ANTLR end "rule__MultiplicityRule__Group_2__1__Impl"


	// $ANTLR start "rule__ModifiersRule__Group__0"
	// InternalUmlProperty.g:1573:1: rule__ModifiersRule__Group__0 : rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 ;
	public final void rule__ModifiersRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1577:1: ( rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 )
			// InternalUmlProperty.g:1578:2: rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1
			{
				pushFollow(FOLLOW_10);
				rule__ModifiersRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ModifiersRule__Group__1();

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
	// $ANTLR end "rule__ModifiersRule__Group__0"


	// $ANTLR start "rule__ModifiersRule__Group__0__Impl"
	// InternalUmlProperty.g:1585:1: rule__ModifiersRule__Group__0__Impl : ( () ) ;
	public final void rule__ModifiersRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1589:1: ( ( () ) )
			// InternalUmlProperty.g:1590:1: ( () )
			{
				// InternalUmlProperty.g:1590:1: ( () )
				// InternalUmlProperty.g:1591:1: ()
				{
					before(grammarAccess.getModifiersRuleAccess().getModifiersRuleAction_0());
					// InternalUmlProperty.g:1592:1: ()
					// InternalUmlProperty.g:1594:1:
					{
					}

					after(grammarAccess.getModifiersRuleAccess().getModifiersRuleAction_0());

				}


			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ModifiersRule__Group__0__Impl"


	// $ANTLR start "rule__ModifiersRule__Group__1"
	// InternalUmlProperty.g:1604:1: rule__ModifiersRule__Group__1 : rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 ;
	public final void rule__ModifiersRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1608:1: ( rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 )
			// InternalUmlProperty.g:1609:2: rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2
			{
				pushFollow(FOLLOW_11);
				rule__ModifiersRule__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ModifiersRule__Group__2();

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
	// $ANTLR end "rule__ModifiersRule__Group__1"


	// $ANTLR start "rule__ModifiersRule__Group__1__Impl"
	// InternalUmlProperty.g:1616:1: rule__ModifiersRule__Group__1__Impl : ( '{' ) ;
	public final void rule__ModifiersRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1620:1: ( ( '{' ) )
			// InternalUmlProperty.g:1621:1: ( '{' )
			{
				// InternalUmlProperty.g:1621:1: ( '{' )
				// InternalUmlProperty.g:1622:1: '{'
				{
					before(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_1());
					match(input, 28, FOLLOW_2);
					after(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_1());

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
	// $ANTLR end "rule__ModifiersRule__Group__1__Impl"


	// $ANTLR start "rule__ModifiersRule__Group__2"
	// InternalUmlProperty.g:1635:1: rule__ModifiersRule__Group__2 : rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 ;
	public final void rule__ModifiersRule__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1639:1: ( rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 )
			// InternalUmlProperty.g:1640:2: rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3
			{
				pushFollow(FOLLOW_11);
				rule__ModifiersRule__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ModifiersRule__Group__3();

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
	// $ANTLR end "rule__ModifiersRule__Group__2"


	// $ANTLR start "rule__ModifiersRule__Group__2__Impl"
	// InternalUmlProperty.g:1647:1: rule__ModifiersRule__Group__2__Impl : ( ( rule__ModifiersRule__Group_2__0 )? ) ;
	public final void rule__ModifiersRule__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1651:1: ( ( ( rule__ModifiersRule__Group_2__0 )? ) )
			// InternalUmlProperty.g:1652:1: ( ( rule__ModifiersRule__Group_2__0 )? )
			{
				// InternalUmlProperty.g:1652:1: ( ( rule__ModifiersRule__Group_2__0 )? )
				// InternalUmlProperty.g:1653:1: ( rule__ModifiersRule__Group_2__0 )?
				{
					before(grammarAccess.getModifiersRuleAccess().getGroup_2());
					// InternalUmlProperty.g:1654:1: ( rule__ModifiersRule__Group_2__0 )?
					int alt19 = 2;
					int LA19_0 = input.LA(1);

					if (((LA19_0 >= 17 && LA19_0 <= 20) || (LA19_0 >= 31 && LA19_0 <= 32))) {
						alt19 = 1;
					}
					switch (alt19) {
					case 1:
					// InternalUmlProperty.g:1654:2: rule__ModifiersRule__Group_2__0
					{
						pushFollow(FOLLOW_2);
						rule__ModifiersRule__Group_2__0();

						state._fsp--;


					}
						break;

					}

					after(grammarAccess.getModifiersRuleAccess().getGroup_2());

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
	// $ANTLR end "rule__ModifiersRule__Group__2__Impl"


	// $ANTLR start "rule__ModifiersRule__Group__3"
	// InternalUmlProperty.g:1664:1: rule__ModifiersRule__Group__3 : rule__ModifiersRule__Group__3__Impl ;
	public final void rule__ModifiersRule__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1668:1: ( rule__ModifiersRule__Group__3__Impl )
			// InternalUmlProperty.g:1669:2: rule__ModifiersRule__Group__3__Impl
			{
				pushFollow(FOLLOW_2);
				rule__ModifiersRule__Group__3__Impl();

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
	// $ANTLR end "rule__ModifiersRule__Group__3"


	// $ANTLR start "rule__ModifiersRule__Group__3__Impl"
	// InternalUmlProperty.g:1675:1: rule__ModifiersRule__Group__3__Impl : ( '}' ) ;
	public final void rule__ModifiersRule__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1679:1: ( ( '}' ) )
			// InternalUmlProperty.g:1680:1: ( '}' )
			{
				// InternalUmlProperty.g:1680:1: ( '}' )
				// InternalUmlProperty.g:1681:1: '}'
				{
					before(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3());
					match(input, 29, FOLLOW_2);
					after(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3());

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
	// $ANTLR end "rule__ModifiersRule__Group__3__Impl"


	// $ANTLR start "rule__ModifiersRule__Group_2__0"
	// InternalUmlProperty.g:1702:1: rule__ModifiersRule__Group_2__0 : rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 ;
	public final void rule__ModifiersRule__Group_2__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1706:1: ( rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 )
			// InternalUmlProperty.g:1707:2: rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1
			{
				pushFollow(FOLLOW_12);
				rule__ModifiersRule__Group_2__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ModifiersRule__Group_2__1();

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
	// $ANTLR end "rule__ModifiersRule__Group_2__0"


	// $ANTLR start "rule__ModifiersRule__Group_2__0__Impl"
	// InternalUmlProperty.g:1714:1: rule__ModifiersRule__Group_2__0__Impl : ( ( rule__ModifiersRule__ValuesAssignment_2_0 ) ) ;
	public final void rule__ModifiersRule__Group_2__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1718:1: ( ( ( rule__ModifiersRule__ValuesAssignment_2_0 ) ) )
			// InternalUmlProperty.g:1719:1: ( ( rule__ModifiersRule__ValuesAssignment_2_0 ) )
			{
				// InternalUmlProperty.g:1719:1: ( ( rule__ModifiersRule__ValuesAssignment_2_0 ) )
				// InternalUmlProperty.g:1720:1: ( rule__ModifiersRule__ValuesAssignment_2_0 )
				{
					before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_0());
					// InternalUmlProperty.g:1721:1: ( rule__ModifiersRule__ValuesAssignment_2_0 )
					// InternalUmlProperty.g:1721:2: rule__ModifiersRule__ValuesAssignment_2_0
					{
						pushFollow(FOLLOW_2);
						rule__ModifiersRule__ValuesAssignment_2_0();

						state._fsp--;


					}

					after(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_0());

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
	// $ANTLR end "rule__ModifiersRule__Group_2__0__Impl"


	// $ANTLR start "rule__ModifiersRule__Group_2__1"
	// InternalUmlProperty.g:1731:1: rule__ModifiersRule__Group_2__1 : rule__ModifiersRule__Group_2__1__Impl ;
	public final void rule__ModifiersRule__Group_2__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1735:1: ( rule__ModifiersRule__Group_2__1__Impl )
			// InternalUmlProperty.g:1736:2: rule__ModifiersRule__Group_2__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__ModifiersRule__Group_2__1__Impl();

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
	// $ANTLR end "rule__ModifiersRule__Group_2__1"


	// $ANTLR start "rule__ModifiersRule__Group_2__1__Impl"
	// InternalUmlProperty.g:1742:1: rule__ModifiersRule__Group_2__1__Impl : ( ( rule__ModifiersRule__Group_2_1__0 )* ) ;
	public final void rule__ModifiersRule__Group_2__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1746:1: ( ( ( rule__ModifiersRule__Group_2_1__0 )* ) )
			// InternalUmlProperty.g:1747:1: ( ( rule__ModifiersRule__Group_2_1__0 )* )
			{
				// InternalUmlProperty.g:1747:1: ( ( rule__ModifiersRule__Group_2_1__0 )* )
				// InternalUmlProperty.g:1748:1: ( rule__ModifiersRule__Group_2_1__0 )*
				{
					before(grammarAccess.getModifiersRuleAccess().getGroup_2_1());
					// InternalUmlProperty.g:1749:1: ( rule__ModifiersRule__Group_2_1__0 )*
					loop20: do {
						int alt20 = 2;
						int LA20_0 = input.LA(1);

						if ((LA20_0 == 30)) {
							alt20 = 1;
						}


						switch (alt20) {
						case 1:
						// InternalUmlProperty.g:1749:2: rule__ModifiersRule__Group_2_1__0
						{
							pushFollow(FOLLOW_13);
							rule__ModifiersRule__Group_2_1__0();

							state._fsp--;


						}
							break;

						default:
							break loop20;
						}
					} while (true);

					after(grammarAccess.getModifiersRuleAccess().getGroup_2_1());

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
	// $ANTLR end "rule__ModifiersRule__Group_2__1__Impl"


	// $ANTLR start "rule__ModifiersRule__Group_2_1__0"
	// InternalUmlProperty.g:1763:1: rule__ModifiersRule__Group_2_1__0 : rule__ModifiersRule__Group_2_1__0__Impl rule__ModifiersRule__Group_2_1__1 ;
	public final void rule__ModifiersRule__Group_2_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1767:1: ( rule__ModifiersRule__Group_2_1__0__Impl rule__ModifiersRule__Group_2_1__1 )
			// InternalUmlProperty.g:1768:2: rule__ModifiersRule__Group_2_1__0__Impl rule__ModifiersRule__Group_2_1__1
			{
				pushFollow(FOLLOW_14);
				rule__ModifiersRule__Group_2_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ModifiersRule__Group_2_1__1();

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
	// $ANTLR end "rule__ModifiersRule__Group_2_1__0"


	// $ANTLR start "rule__ModifiersRule__Group_2_1__0__Impl"
	// InternalUmlProperty.g:1775:1: rule__ModifiersRule__Group_2_1__0__Impl : ( ',' ) ;
	public final void rule__ModifiersRule__Group_2_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1779:1: ( ( ',' ) )
			// InternalUmlProperty.g:1780:1: ( ',' )
			{
				// InternalUmlProperty.g:1780:1: ( ',' )
				// InternalUmlProperty.g:1781:1: ','
				{
					before(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_1_0());
					match(input, 30, FOLLOW_2);
					after(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_1_0());

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
	// $ANTLR end "rule__ModifiersRule__Group_2_1__0__Impl"


	// $ANTLR start "rule__ModifiersRule__Group_2_1__1"
	// InternalUmlProperty.g:1794:1: rule__ModifiersRule__Group_2_1__1 : rule__ModifiersRule__Group_2_1__1__Impl ;
	public final void rule__ModifiersRule__Group_2_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1798:1: ( rule__ModifiersRule__Group_2_1__1__Impl )
			// InternalUmlProperty.g:1799:2: rule__ModifiersRule__Group_2_1__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__ModifiersRule__Group_2_1__1__Impl();

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
	// $ANTLR end "rule__ModifiersRule__Group_2_1__1"


	// $ANTLR start "rule__ModifiersRule__Group_2_1__1__Impl"
	// InternalUmlProperty.g:1805:1: rule__ModifiersRule__Group_2_1__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_2_1_1 ) ) ;
	public final void rule__ModifiersRule__Group_2_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1809:1: ( ( ( rule__ModifiersRule__ValuesAssignment_2_1_1 ) ) )
			// InternalUmlProperty.g:1810:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1_1 ) )
			{
				// InternalUmlProperty.g:1810:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1_1 ) )
				// InternalUmlProperty.g:1811:1: ( rule__ModifiersRule__ValuesAssignment_2_1_1 )
				{
					before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1_1());
					// InternalUmlProperty.g:1812:1: ( rule__ModifiersRule__ValuesAssignment_2_1_1 )
					// InternalUmlProperty.g:1812:2: rule__ModifiersRule__ValuesAssignment_2_1_1
					{
						pushFollow(FOLLOW_2);
						rule__ModifiersRule__ValuesAssignment_2_1_1();

						state._fsp--;


					}

					after(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1_1());

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
	// $ANTLR end "rule__ModifiersRule__Group_2_1__1__Impl"


	// $ANTLR start "rule__RedefinesRule__Group__0"
	// InternalUmlProperty.g:1826:1: rule__RedefinesRule__Group__0 : rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1 ;
	public final void rule__RedefinesRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1830:1: ( rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1 )
			// InternalUmlProperty.g:1831:2: rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1
			{
				pushFollow(FOLLOW_6);
				rule__RedefinesRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__RedefinesRule__Group__1();

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
	// $ANTLR end "rule__RedefinesRule__Group__0"


	// $ANTLR start "rule__RedefinesRule__Group__0__Impl"
	// InternalUmlProperty.g:1838:1: rule__RedefinesRule__Group__0__Impl : ( 'redefines' ) ;
	public final void rule__RedefinesRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1842:1: ( ( 'redefines' ) )
			// InternalUmlProperty.g:1843:1: ( 'redefines' )
			{
				// InternalUmlProperty.g:1843:1: ( 'redefines' )
				// InternalUmlProperty.g:1844:1: 'redefines'
				{
					before(grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0());
					match(input, 31, FOLLOW_2);
					after(grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0());

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
	// $ANTLR end "rule__RedefinesRule__Group__0__Impl"


	// $ANTLR start "rule__RedefinesRule__Group__1"
	// InternalUmlProperty.g:1857:1: rule__RedefinesRule__Group__1 : rule__RedefinesRule__Group__1__Impl ;
	public final void rule__RedefinesRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1861:1: ( rule__RedefinesRule__Group__1__Impl )
			// InternalUmlProperty.g:1862:2: rule__RedefinesRule__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__RedefinesRule__Group__1__Impl();

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
	// $ANTLR end "rule__RedefinesRule__Group__1"


	// $ANTLR start "rule__RedefinesRule__Group__1__Impl"
	// InternalUmlProperty.g:1868:1: rule__RedefinesRule__Group__1__Impl : ( ( rule__RedefinesRule__PropertyAssignment_1 ) ) ;
	public final void rule__RedefinesRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1872:1: ( ( ( rule__RedefinesRule__PropertyAssignment_1 ) ) )
			// InternalUmlProperty.g:1873:1: ( ( rule__RedefinesRule__PropertyAssignment_1 ) )
			{
				// InternalUmlProperty.g:1873:1: ( ( rule__RedefinesRule__PropertyAssignment_1 ) )
				// InternalUmlProperty.g:1874:1: ( rule__RedefinesRule__PropertyAssignment_1 )
				{
					before(grammarAccess.getRedefinesRuleAccess().getPropertyAssignment_1());
					// InternalUmlProperty.g:1875:1: ( rule__RedefinesRule__PropertyAssignment_1 )
					// InternalUmlProperty.g:1875:2: rule__RedefinesRule__PropertyAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__RedefinesRule__PropertyAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getRedefinesRuleAccess().getPropertyAssignment_1());

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
	// $ANTLR end "rule__RedefinesRule__Group__1__Impl"


	// $ANTLR start "rule__SubsetsRule__Group__0"
	// InternalUmlProperty.g:1889:1: rule__SubsetsRule__Group__0 : rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1 ;
	public final void rule__SubsetsRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1893:1: ( rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1 )
			// InternalUmlProperty.g:1894:2: rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1
			{
				pushFollow(FOLLOW_6);
				rule__SubsetsRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__SubsetsRule__Group__1();

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
	// $ANTLR end "rule__SubsetsRule__Group__0"


	// $ANTLR start "rule__SubsetsRule__Group__0__Impl"
	// InternalUmlProperty.g:1901:1: rule__SubsetsRule__Group__0__Impl : ( 'subsets' ) ;
	public final void rule__SubsetsRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1905:1: ( ( 'subsets' ) )
			// InternalUmlProperty.g:1906:1: ( 'subsets' )
			{
				// InternalUmlProperty.g:1906:1: ( 'subsets' )
				// InternalUmlProperty.g:1907:1: 'subsets'
				{
					before(grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0());
					match(input, 32, FOLLOW_2);
					after(grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0());

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
	// $ANTLR end "rule__SubsetsRule__Group__0__Impl"


	// $ANTLR start "rule__SubsetsRule__Group__1"
	// InternalUmlProperty.g:1920:1: rule__SubsetsRule__Group__1 : rule__SubsetsRule__Group__1__Impl ;
	public final void rule__SubsetsRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1924:1: ( rule__SubsetsRule__Group__1__Impl )
			// InternalUmlProperty.g:1925:2: rule__SubsetsRule__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__SubsetsRule__Group__1__Impl();

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
	// $ANTLR end "rule__SubsetsRule__Group__1"


	// $ANTLR start "rule__SubsetsRule__Group__1__Impl"
	// InternalUmlProperty.g:1931:1: rule__SubsetsRule__Group__1__Impl : ( ( rule__SubsetsRule__PropertyAssignment_1 ) ) ;
	public final void rule__SubsetsRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1935:1: ( ( ( rule__SubsetsRule__PropertyAssignment_1 ) ) )
			// InternalUmlProperty.g:1936:1: ( ( rule__SubsetsRule__PropertyAssignment_1 ) )
			{
				// InternalUmlProperty.g:1936:1: ( ( rule__SubsetsRule__PropertyAssignment_1 ) )
				// InternalUmlProperty.g:1937:1: ( rule__SubsetsRule__PropertyAssignment_1 )
				{
					before(grammarAccess.getSubsetsRuleAccess().getPropertyAssignment_1());
					// InternalUmlProperty.g:1938:1: ( rule__SubsetsRule__PropertyAssignment_1 )
					// InternalUmlProperty.g:1938:2: rule__SubsetsRule__PropertyAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__SubsetsRule__PropertyAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getSubsetsRuleAccess().getPropertyAssignment_1());

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
	// $ANTLR end "rule__SubsetsRule__Group__1__Impl"


	// $ANTLR start "rule__DefaultValueRule__Group__0"
	// InternalUmlProperty.g:1952:1: rule__DefaultValueRule__Group__0 : rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1 ;
	public final void rule__DefaultValueRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1956:1: ( rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1 )
			// InternalUmlProperty.g:1957:2: rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1
			{
				pushFollow(FOLLOW_15);
				rule__DefaultValueRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__DefaultValueRule__Group__1();

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
	// $ANTLR end "rule__DefaultValueRule__Group__0"


	// $ANTLR start "rule__DefaultValueRule__Group__0__Impl"
	// InternalUmlProperty.g:1964:1: rule__DefaultValueRule__Group__0__Impl : ( '=' ) ;
	public final void rule__DefaultValueRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1968:1: ( ( '=' ) )
			// InternalUmlProperty.g:1969:1: ( '=' )
			{
				// InternalUmlProperty.g:1969:1: ( '=' )
				// InternalUmlProperty.g:1970:1: '='
				{
					before(grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0());
					match(input, 33, FOLLOW_2);
					after(grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0());

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
	// $ANTLR end "rule__DefaultValueRule__Group__0__Impl"


	// $ANTLR start "rule__DefaultValueRule__Group__1"
	// InternalUmlProperty.g:1983:1: rule__DefaultValueRule__Group__1 : rule__DefaultValueRule__Group__1__Impl ;
	public final void rule__DefaultValueRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1987:1: ( rule__DefaultValueRule__Group__1__Impl )
			// InternalUmlProperty.g:1988:2: rule__DefaultValueRule__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__DefaultValueRule__Group__1__Impl();

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
	// $ANTLR end "rule__DefaultValueRule__Group__1"


	// $ANTLR start "rule__DefaultValueRule__Group__1__Impl"
	// InternalUmlProperty.g:1994:1: rule__DefaultValueRule__Group__1__Impl : ( ( rule__DefaultValueRule__DefaultAssignment_1 ) ) ;
	public final void rule__DefaultValueRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:1998:1: ( ( ( rule__DefaultValueRule__DefaultAssignment_1 ) ) )
			// InternalUmlProperty.g:1999:1: ( ( rule__DefaultValueRule__DefaultAssignment_1 ) )
			{
				// InternalUmlProperty.g:1999:1: ( ( rule__DefaultValueRule__DefaultAssignment_1 ) )
				// InternalUmlProperty.g:2000:1: ( rule__DefaultValueRule__DefaultAssignment_1 )
				{
					before(grammarAccess.getDefaultValueRuleAccess().getDefaultAssignment_1());
					// InternalUmlProperty.g:2001:1: ( rule__DefaultValueRule__DefaultAssignment_1 )
					// InternalUmlProperty.g:2001:2: rule__DefaultValueRule__DefaultAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__DefaultValueRule__DefaultAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getDefaultValueRuleAccess().getDefaultAssignment_1());

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
	// $ANTLR end "rule__DefaultValueRule__Group__1__Impl"


	// $ANTLR start "rule__RealValue__Group_0__0"
	// InternalUmlProperty.g:2015:1: rule__RealValue__Group_0__0 : rule__RealValue__Group_0__0__Impl rule__RealValue__Group_0__1 ;
	public final void rule__RealValue__Group_0__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2019:1: ( rule__RealValue__Group_0__0__Impl rule__RealValue__Group_0__1 )
			// InternalUmlProperty.g:2020:2: rule__RealValue__Group_0__0__Impl rule__RealValue__Group_0__1
			{
				pushFollow(FOLLOW_16);
				rule__RealValue__Group_0__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__RealValue__Group_0__1();

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
	// $ANTLR end "rule__RealValue__Group_0__0"


	// $ANTLR start "rule__RealValue__Group_0__0__Impl"
	// InternalUmlProperty.g:2027:1: rule__RealValue__Group_0__0__Impl : ( ( rule__RealValue__IntegerAssignment_0_0 ) ) ;
	public final void rule__RealValue__Group_0__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2031:1: ( ( ( rule__RealValue__IntegerAssignment_0_0 ) ) )
			// InternalUmlProperty.g:2032:1: ( ( rule__RealValue__IntegerAssignment_0_0 ) )
			{
				// InternalUmlProperty.g:2032:1: ( ( rule__RealValue__IntegerAssignment_0_0 ) )
				// InternalUmlProperty.g:2033:1: ( rule__RealValue__IntegerAssignment_0_0 )
				{
					before(grammarAccess.getRealValueAccess().getIntegerAssignment_0_0());
					// InternalUmlProperty.g:2034:1: ( rule__RealValue__IntegerAssignment_0_0 )
					// InternalUmlProperty.g:2034:2: rule__RealValue__IntegerAssignment_0_0
					{
						pushFollow(FOLLOW_2);
						rule__RealValue__IntegerAssignment_0_0();

						state._fsp--;


					}

					after(grammarAccess.getRealValueAccess().getIntegerAssignment_0_0());

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
	// $ANTLR end "rule__RealValue__Group_0__0__Impl"


	// $ANTLR start "rule__RealValue__Group_0__1"
	// InternalUmlProperty.g:2044:1: rule__RealValue__Group_0__1 : rule__RealValue__Group_0__1__Impl ;
	public final void rule__RealValue__Group_0__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2048:1: ( rule__RealValue__Group_0__1__Impl )
			// InternalUmlProperty.g:2049:2: rule__RealValue__Group_0__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__RealValue__Group_0__1__Impl();

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
	// $ANTLR end "rule__RealValue__Group_0__1"


	// $ANTLR start "rule__RealValue__Group_0__1__Impl"
	// InternalUmlProperty.g:2055:1: rule__RealValue__Group_0__1__Impl : ( '.' ) ;
	public final void rule__RealValue__Group_0__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2059:1: ( ( '.' ) )
			// InternalUmlProperty.g:2060:1: ( '.' )
			{
				// InternalUmlProperty.g:2060:1: ( '.' )
				// InternalUmlProperty.g:2061:1: '.'
				{
					before(grammarAccess.getRealValueAccess().getFullStopKeyword_0_1());
					match(input, 34, FOLLOW_2);
					after(grammarAccess.getRealValueAccess().getFullStopKeyword_0_1());

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
	// $ANTLR end "rule__RealValue__Group_0__1__Impl"


	// $ANTLR start "rule__RealValue__Group_1__0"
	// InternalUmlProperty.g:2078:1: rule__RealValue__Group_1__0 : rule__RealValue__Group_1__0__Impl rule__RealValue__Group_1__1 ;
	public final void rule__RealValue__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2082:1: ( rule__RealValue__Group_1__0__Impl rule__RealValue__Group_1__1 )
			// InternalUmlProperty.g:2083:2: rule__RealValue__Group_1__0__Impl rule__RealValue__Group_1__1
			{
				pushFollow(FOLLOW_17);
				rule__RealValue__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__RealValue__Group_1__1();

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
	// $ANTLR end "rule__RealValue__Group_1__0"


	// $ANTLR start "rule__RealValue__Group_1__0__Impl"
	// InternalUmlProperty.g:2090:1: rule__RealValue__Group_1__0__Impl : ( '.' ) ;
	public final void rule__RealValue__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2094:1: ( ( '.' ) )
			// InternalUmlProperty.g:2095:1: ( '.' )
			{
				// InternalUmlProperty.g:2095:1: ( '.' )
				// InternalUmlProperty.g:2096:1: '.'
				{
					before(grammarAccess.getRealValueAccess().getFullStopKeyword_1_0());
					match(input, 34, FOLLOW_2);
					after(grammarAccess.getRealValueAccess().getFullStopKeyword_1_0());

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
	// $ANTLR end "rule__RealValue__Group_1__0__Impl"


	// $ANTLR start "rule__RealValue__Group_1__1"
	// InternalUmlProperty.g:2109:1: rule__RealValue__Group_1__1 : rule__RealValue__Group_1__1__Impl ;
	public final void rule__RealValue__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2113:1: ( rule__RealValue__Group_1__1__Impl )
			// InternalUmlProperty.g:2114:2: rule__RealValue__Group_1__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__RealValue__Group_1__1__Impl();

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
	// $ANTLR end "rule__RealValue__Group_1__1"


	// $ANTLR start "rule__RealValue__Group_1__1__Impl"
	// InternalUmlProperty.g:2120:1: rule__RealValue__Group_1__1__Impl : ( ( rule__RealValue__FractionAssignment_1_1 ) ) ;
	public final void rule__RealValue__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2124:1: ( ( ( rule__RealValue__FractionAssignment_1_1 ) ) )
			// InternalUmlProperty.g:2125:1: ( ( rule__RealValue__FractionAssignment_1_1 ) )
			{
				// InternalUmlProperty.g:2125:1: ( ( rule__RealValue__FractionAssignment_1_1 ) )
				// InternalUmlProperty.g:2126:1: ( rule__RealValue__FractionAssignment_1_1 )
				{
					before(grammarAccess.getRealValueAccess().getFractionAssignment_1_1());
					// InternalUmlProperty.g:2127:1: ( rule__RealValue__FractionAssignment_1_1 )
					// InternalUmlProperty.g:2127:2: rule__RealValue__FractionAssignment_1_1
					{
						pushFollow(FOLLOW_2);
						rule__RealValue__FractionAssignment_1_1();

						state._fsp--;


					}

					after(grammarAccess.getRealValueAccess().getFractionAssignment_1_1());

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
	// $ANTLR end "rule__RealValue__Group_1__1__Impl"


	// $ANTLR start "rule__RealValue__Group_2__0"
	// InternalUmlProperty.g:2141:1: rule__RealValue__Group_2__0 : rule__RealValue__Group_2__0__Impl rule__RealValue__Group_2__1 ;
	public final void rule__RealValue__Group_2__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2145:1: ( rule__RealValue__Group_2__0__Impl rule__RealValue__Group_2__1 )
			// InternalUmlProperty.g:2146:2: rule__RealValue__Group_2__0__Impl rule__RealValue__Group_2__1
			{
				pushFollow(FOLLOW_16);
				rule__RealValue__Group_2__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__RealValue__Group_2__1();

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
	// $ANTLR end "rule__RealValue__Group_2__0"


	// $ANTLR start "rule__RealValue__Group_2__0__Impl"
	// InternalUmlProperty.g:2153:1: rule__RealValue__Group_2__0__Impl : ( ( rule__RealValue__IntegerAssignment_2_0 ) ) ;
	public final void rule__RealValue__Group_2__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2157:1: ( ( ( rule__RealValue__IntegerAssignment_2_0 ) ) )
			// InternalUmlProperty.g:2158:1: ( ( rule__RealValue__IntegerAssignment_2_0 ) )
			{
				// InternalUmlProperty.g:2158:1: ( ( rule__RealValue__IntegerAssignment_2_0 ) )
				// InternalUmlProperty.g:2159:1: ( rule__RealValue__IntegerAssignment_2_0 )
				{
					before(grammarAccess.getRealValueAccess().getIntegerAssignment_2_0());
					// InternalUmlProperty.g:2160:1: ( rule__RealValue__IntegerAssignment_2_0 )
					// InternalUmlProperty.g:2160:2: rule__RealValue__IntegerAssignment_2_0
					{
						pushFollow(FOLLOW_2);
						rule__RealValue__IntegerAssignment_2_0();

						state._fsp--;


					}

					after(grammarAccess.getRealValueAccess().getIntegerAssignment_2_0());

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
	// $ANTLR end "rule__RealValue__Group_2__0__Impl"


	// $ANTLR start "rule__RealValue__Group_2__1"
	// InternalUmlProperty.g:2170:1: rule__RealValue__Group_2__1 : rule__RealValue__Group_2__1__Impl rule__RealValue__Group_2__2 ;
	public final void rule__RealValue__Group_2__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2174:1: ( rule__RealValue__Group_2__1__Impl rule__RealValue__Group_2__2 )
			// InternalUmlProperty.g:2175:2: rule__RealValue__Group_2__1__Impl rule__RealValue__Group_2__2
			{
				pushFollow(FOLLOW_17);
				rule__RealValue__Group_2__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__RealValue__Group_2__2();

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
	// $ANTLR end "rule__RealValue__Group_2__1"


	// $ANTLR start "rule__RealValue__Group_2__1__Impl"
	// InternalUmlProperty.g:2182:1: rule__RealValue__Group_2__1__Impl : ( '.' ) ;
	public final void rule__RealValue__Group_2__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2186:1: ( ( '.' ) )
			// InternalUmlProperty.g:2187:1: ( '.' )
			{
				// InternalUmlProperty.g:2187:1: ( '.' )
				// InternalUmlProperty.g:2188:1: '.'
				{
					before(grammarAccess.getRealValueAccess().getFullStopKeyword_2_1());
					match(input, 34, FOLLOW_2);
					after(grammarAccess.getRealValueAccess().getFullStopKeyword_2_1());

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
	// $ANTLR end "rule__RealValue__Group_2__1__Impl"


	// $ANTLR start "rule__RealValue__Group_2__2"
	// InternalUmlProperty.g:2201:1: rule__RealValue__Group_2__2 : rule__RealValue__Group_2__2__Impl ;
	public final void rule__RealValue__Group_2__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2205:1: ( rule__RealValue__Group_2__2__Impl )
			// InternalUmlProperty.g:2206:2: rule__RealValue__Group_2__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__RealValue__Group_2__2__Impl();

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
	// $ANTLR end "rule__RealValue__Group_2__2"


	// $ANTLR start "rule__RealValue__Group_2__2__Impl"
	// InternalUmlProperty.g:2212:1: rule__RealValue__Group_2__2__Impl : ( ( rule__RealValue__FractionAssignment_2_2 ) ) ;
	public final void rule__RealValue__Group_2__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2216:1: ( ( ( rule__RealValue__FractionAssignment_2_2 ) ) )
			// InternalUmlProperty.g:2217:1: ( ( rule__RealValue__FractionAssignment_2_2 ) )
			{
				// InternalUmlProperty.g:2217:1: ( ( rule__RealValue__FractionAssignment_2_2 ) )
				// InternalUmlProperty.g:2218:1: ( rule__RealValue__FractionAssignment_2_2 )
				{
					before(grammarAccess.getRealValueAccess().getFractionAssignment_2_2());
					// InternalUmlProperty.g:2219:1: ( rule__RealValue__FractionAssignment_2_2 )
					// InternalUmlProperty.g:2219:2: rule__RealValue__FractionAssignment_2_2
					{
						pushFollow(FOLLOW_2);
						rule__RealValue__FractionAssignment_2_2();

						state._fsp--;


					}

					after(grammarAccess.getRealValueAccess().getFractionAssignment_2_2());

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
	// $ANTLR end "rule__RealValue__Group_2__2__Impl"


	// $ANTLR start "rule__NullValue__Group__0"
	// InternalUmlProperty.g:2235:1: rule__NullValue__Group__0 : rule__NullValue__Group__0__Impl rule__NullValue__Group__1 ;
	public final void rule__NullValue__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2239:1: ( rule__NullValue__Group__0__Impl rule__NullValue__Group__1 )
			// InternalUmlProperty.g:2240:2: rule__NullValue__Group__0__Impl rule__NullValue__Group__1
			{
				pushFollow(FOLLOW_18);
				rule__NullValue__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__NullValue__Group__1();

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
	// $ANTLR end "rule__NullValue__Group__0"


	// $ANTLR start "rule__NullValue__Group__0__Impl"
	// InternalUmlProperty.g:2247:1: rule__NullValue__Group__0__Impl : ( () ) ;
	public final void rule__NullValue__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2251:1: ( ( () ) )
			// InternalUmlProperty.g:2252:1: ( () )
			{
				// InternalUmlProperty.g:2252:1: ( () )
				// InternalUmlProperty.g:2253:1: ()
				{
					before(grammarAccess.getNullValueAccess().getNullValueAction_0());
					// InternalUmlProperty.g:2254:1: ()
					// InternalUmlProperty.g:2256:1:
					{
					}

					after(grammarAccess.getNullValueAccess().getNullValueAction_0());

				}


			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__NullValue__Group__0__Impl"


	// $ANTLR start "rule__NullValue__Group__1"
	// InternalUmlProperty.g:2266:1: rule__NullValue__Group__1 : rule__NullValue__Group__1__Impl ;
	public final void rule__NullValue__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2270:1: ( rule__NullValue__Group__1__Impl )
			// InternalUmlProperty.g:2271:2: rule__NullValue__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__NullValue__Group__1__Impl();

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
	// $ANTLR end "rule__NullValue__Group__1"


	// $ANTLR start "rule__NullValue__Group__1__Impl"
	// InternalUmlProperty.g:2277:1: rule__NullValue__Group__1__Impl : ( 'null' ) ;
	public final void rule__NullValue__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2281:1: ( ( 'null' ) )
			// InternalUmlProperty.g:2282:1: ( 'null' )
			{
				// InternalUmlProperty.g:2282:1: ( 'null' )
				// InternalUmlProperty.g:2283:1: 'null'
				{
					before(grammarAccess.getNullValueAccess().getNullKeyword_1());
					match(input, 35, FOLLOW_2);
					after(grammarAccess.getNullValueAccess().getNullKeyword_1());

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
	// $ANTLR end "rule__NullValue__Group__1__Impl"


	// $ANTLR start "rule__NoValue__Group__0"
	// InternalUmlProperty.g:2300:1: rule__NoValue__Group__0 : rule__NoValue__Group__0__Impl rule__NoValue__Group__1 ;
	public final void rule__NoValue__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2304:1: ( rule__NoValue__Group__0__Impl rule__NoValue__Group__1 )
			// InternalUmlProperty.g:2305:2: rule__NoValue__Group__0__Impl rule__NoValue__Group__1
			{
				pushFollow(FOLLOW_15);
				rule__NoValue__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__NoValue__Group__1();

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
	// $ANTLR end "rule__NoValue__Group__0"


	// $ANTLR start "rule__NoValue__Group__0__Impl"
	// InternalUmlProperty.g:2312:1: rule__NoValue__Group__0__Impl : ( () ) ;
	public final void rule__NoValue__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2316:1: ( ( () ) )
			// InternalUmlProperty.g:2317:1: ( () )
			{
				// InternalUmlProperty.g:2317:1: ( () )
				// InternalUmlProperty.g:2318:1: ()
				{
					before(grammarAccess.getNoValueAccess().getNoValueAction_0());
					// InternalUmlProperty.g:2319:1: ()
					// InternalUmlProperty.g:2321:1:
					{
					}

					after(grammarAccess.getNoValueAccess().getNoValueAction_0());

				}


			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__NoValue__Group__0__Impl"


	// $ANTLR start "rule__NoValue__Group__1"
	// InternalUmlProperty.g:2331:1: rule__NoValue__Group__1 : rule__NoValue__Group__1__Impl ;
	public final void rule__NoValue__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2335:1: ( rule__NoValue__Group__1__Impl )
			// InternalUmlProperty.g:2336:2: rule__NoValue__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__NoValue__Group__1__Impl();

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
	// $ANTLR end "rule__NoValue__Group__1"


	// $ANTLR start "rule__NoValue__Group__1__Impl"
	// InternalUmlProperty.g:2342:1: rule__NoValue__Group__1__Impl : ( 'none' ) ;
	public final void rule__NoValue__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2346:1: ( ( 'none' ) )
			// InternalUmlProperty.g:2347:1: ( 'none' )
			{
				// InternalUmlProperty.g:2347:1: ( 'none' )
				// InternalUmlProperty.g:2348:1: 'none'
				{
					before(grammarAccess.getNoValueAccess().getNoneKeyword_1());
					match(input, 36, FOLLOW_2);
					after(grammarAccess.getNoValueAccess().getNoneKeyword_1());

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
	// $ANTLR end "rule__NoValue__Group__1__Impl"


	// $ANTLR start "rule__PropertyRule__VisibilityAssignment_0"
	// InternalUmlProperty.g:2366:1: rule__PropertyRule__VisibilityAssignment_0 : ( ruleVisibilityRule ) ;
	public final void rule__PropertyRule__VisibilityAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2370:1: ( ( ruleVisibilityRule ) )
			// InternalUmlProperty.g:2371:1: ( ruleVisibilityRule )
			{
				// InternalUmlProperty.g:2371:1: ( ruleVisibilityRule )
				// InternalUmlProperty.g:2372:1: ruleVisibilityRule
				{
					before(grammarAccess.getPropertyRuleAccess().getVisibilityVisibilityRuleParserRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleVisibilityRule();

					state._fsp--;

					after(grammarAccess.getPropertyRuleAccess().getVisibilityVisibilityRuleParserRuleCall_0_0());

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
	// $ANTLR end "rule__PropertyRule__VisibilityAssignment_0"


	// $ANTLR start "rule__PropertyRule__DerivedAssignment_1"
	// InternalUmlProperty.g:2381:1: rule__PropertyRule__DerivedAssignment_1 : ( ( '/' ) ) ;
	public final void rule__PropertyRule__DerivedAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2385:1: ( ( ( '/' ) ) )
			// InternalUmlProperty.g:2386:1: ( ( '/' ) )
			{
				// InternalUmlProperty.g:2386:1: ( ( '/' ) )
				// InternalUmlProperty.g:2387:1: ( '/' )
				{
					before(grammarAccess.getPropertyRuleAccess().getDerivedSolidusKeyword_1_0());
					// InternalUmlProperty.g:2388:1: ( '/' )
					// InternalUmlProperty.g:2389:1: '/'
					{
						before(grammarAccess.getPropertyRuleAccess().getDerivedSolidusKeyword_1_0());
						match(input, 37, FOLLOW_2);
						after(grammarAccess.getPropertyRuleAccess().getDerivedSolidusKeyword_1_0());

					}

					after(grammarAccess.getPropertyRuleAccess().getDerivedSolidusKeyword_1_0());

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
	// $ANTLR end "rule__PropertyRule__DerivedAssignment_1"


	// $ANTLR start "rule__PropertyRule__NameAssignment_2"
	// InternalUmlProperty.g:2404:1: rule__PropertyRule__NameAssignment_2 : ( RULE_ID ) ;
	public final void rule__PropertyRule__NameAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2408:1: ( ( RULE_ID ) )
			// InternalUmlProperty.g:2409:1: ( RULE_ID )
			{
				// InternalUmlProperty.g:2409:1: ( RULE_ID )
				// InternalUmlProperty.g:2410:1: RULE_ID
				{
					before(grammarAccess.getPropertyRuleAccess().getNameIDTerminalRuleCall_2_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getPropertyRuleAccess().getNameIDTerminalRuleCall_2_0());

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
	// $ANTLR end "rule__PropertyRule__NameAssignment_2"


	// $ANTLR start "rule__PropertyRule__TypeAssignment_3_1_0"
	// InternalUmlProperty.g:2419:1: rule__PropertyRule__TypeAssignment_3_1_0 : ( ruleTypeRule ) ;
	public final void rule__PropertyRule__TypeAssignment_3_1_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2423:1: ( ( ruleTypeRule ) )
			// InternalUmlProperty.g:2424:1: ( ruleTypeRule )
			{
				// InternalUmlProperty.g:2424:1: ( ruleTypeRule )
				// InternalUmlProperty.g:2425:1: ruleTypeRule
				{
					before(grammarAccess.getPropertyRuleAccess().getTypeTypeRuleParserRuleCall_3_1_0_0());
					pushFollow(FOLLOW_2);
					ruleTypeRule();

					state._fsp--;

					after(grammarAccess.getPropertyRuleAccess().getTypeTypeRuleParserRuleCall_3_1_0_0());

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
	// $ANTLR end "rule__PropertyRule__TypeAssignment_3_1_0"


	// $ANTLR start "rule__PropertyRule__TypeUndefinedAssignment_3_1_1"
	// InternalUmlProperty.g:2434:1: rule__PropertyRule__TypeUndefinedAssignment_3_1_1 : ( ( '<Undefined>' ) ) ;
	public final void rule__PropertyRule__TypeUndefinedAssignment_3_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2438:1: ( ( ( '<Undefined>' ) ) )
			// InternalUmlProperty.g:2439:1: ( ( '<Undefined>' ) )
			{
				// InternalUmlProperty.g:2439:1: ( ( '<Undefined>' ) )
				// InternalUmlProperty.g:2440:1: ( '<Undefined>' )
				{
					before(grammarAccess.getPropertyRuleAccess().getTypeUndefinedUndefinedKeyword_3_1_1_0());
					// InternalUmlProperty.g:2441:1: ( '<Undefined>' )
					// InternalUmlProperty.g:2442:1: '<Undefined>'
					{
						before(grammarAccess.getPropertyRuleAccess().getTypeUndefinedUndefinedKeyword_3_1_1_0());
						match(input, 38, FOLLOW_2);
						after(grammarAccess.getPropertyRuleAccess().getTypeUndefinedUndefinedKeyword_3_1_1_0());

					}

					after(grammarAccess.getPropertyRuleAccess().getTypeUndefinedUndefinedKeyword_3_1_1_0());

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
	// $ANTLR end "rule__PropertyRule__TypeUndefinedAssignment_3_1_1"


	// $ANTLR start "rule__PropertyRule__MultiplicityAssignment_4"
	// InternalUmlProperty.g:2457:1: rule__PropertyRule__MultiplicityAssignment_4 : ( ruleMultiplicityRule ) ;
	public final void rule__PropertyRule__MultiplicityAssignment_4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2461:1: ( ( ruleMultiplicityRule ) )
			// InternalUmlProperty.g:2462:1: ( ruleMultiplicityRule )
			{
				// InternalUmlProperty.g:2462:1: ( ruleMultiplicityRule )
				// InternalUmlProperty.g:2463:1: ruleMultiplicityRule
				{
					before(grammarAccess.getPropertyRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_4_0());
					pushFollow(FOLLOW_2);
					ruleMultiplicityRule();

					state._fsp--;

					after(grammarAccess.getPropertyRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_4_0());

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
	// $ANTLR end "rule__PropertyRule__MultiplicityAssignment_4"


	// $ANTLR start "rule__PropertyRule__ModifiersAssignment_5"
	// InternalUmlProperty.g:2472:1: rule__PropertyRule__ModifiersAssignment_5 : ( ruleModifiersRule ) ;
	public final void rule__PropertyRule__ModifiersAssignment_5() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2476:1: ( ( ruleModifiersRule ) )
			// InternalUmlProperty.g:2477:1: ( ruleModifiersRule )
			{
				// InternalUmlProperty.g:2477:1: ( ruleModifiersRule )
				// InternalUmlProperty.g:2478:1: ruleModifiersRule
				{
					before(grammarAccess.getPropertyRuleAccess().getModifiersModifiersRuleParserRuleCall_5_0());
					pushFollow(FOLLOW_2);
					ruleModifiersRule();

					state._fsp--;

					after(grammarAccess.getPropertyRuleAccess().getModifiersModifiersRuleParserRuleCall_5_0());

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
	// $ANTLR end "rule__PropertyRule__ModifiersAssignment_5"


	// $ANTLR start "rule__PropertyRule__DefaultAssignment_6"
	// InternalUmlProperty.g:2487:1: rule__PropertyRule__DefaultAssignment_6 : ( ruleDefaultValueRule ) ;
	public final void rule__PropertyRule__DefaultAssignment_6() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2491:1: ( ( ruleDefaultValueRule ) )
			// InternalUmlProperty.g:2492:1: ( ruleDefaultValueRule )
			{
				// InternalUmlProperty.g:2492:1: ( ruleDefaultValueRule )
				// InternalUmlProperty.g:2493:1: ruleDefaultValueRule
				{
					before(grammarAccess.getPropertyRuleAccess().getDefaultDefaultValueRuleParserRuleCall_6_0());
					pushFollow(FOLLOW_2);
					ruleDefaultValueRule();

					state._fsp--;

					after(grammarAccess.getPropertyRuleAccess().getDefaultDefaultValueRuleParserRuleCall_6_0());

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
	// $ANTLR end "rule__PropertyRule__DefaultAssignment_6"


	// $ANTLR start "rule__VisibilityRule__VisibilityAssignment"
	// InternalUmlProperty.g:2502:1: rule__VisibilityRule__VisibilityAssignment : ( ruleVisibilityKind ) ;
	public final void rule__VisibilityRule__VisibilityAssignment() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2506:1: ( ( ruleVisibilityKind ) )
			// InternalUmlProperty.g:2507:1: ( ruleVisibilityKind )
			{
				// InternalUmlProperty.g:2507:1: ( ruleVisibilityKind )
				// InternalUmlProperty.g:2508:1: ruleVisibilityKind
				{
					before(grammarAccess.getVisibilityRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleVisibilityKind();

					state._fsp--;

					after(grammarAccess.getVisibilityRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0());

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
	// $ANTLR end "rule__VisibilityRule__VisibilityAssignment"


	// $ANTLR start "rule__TypeRule__PathAssignment_0"
	// InternalUmlProperty.g:2517:1: rule__TypeRule__PathAssignment_0 : ( ruleQualifiedName ) ;
	public final void rule__TypeRule__PathAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2521:1: ( ( ruleQualifiedName ) )
			// InternalUmlProperty.g:2522:1: ( ruleQualifiedName )
			{
				// InternalUmlProperty.g:2522:1: ( ruleQualifiedName )
				// InternalUmlProperty.g:2523:1: ruleQualifiedName
				{
					before(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleQualifiedName();

					state._fsp--;

					after(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0());

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
	// $ANTLR end "rule__TypeRule__PathAssignment_0"


	// $ANTLR start "rule__TypeRule__TypeAssignment_1"
	// InternalUmlProperty.g:2532:1: rule__TypeRule__TypeAssignment_1 : ( ( RULE_ID ) ) ;
	public final void rule__TypeRule__TypeAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2536:1: ( ( ( RULE_ID ) ) )
			// InternalUmlProperty.g:2537:1: ( ( RULE_ID ) )
			{
				// InternalUmlProperty.g:2537:1: ( ( RULE_ID ) )
				// InternalUmlProperty.g:2538:1: ( RULE_ID )
				{
					before(grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0());
					// InternalUmlProperty.g:2539:1: ( RULE_ID )
					// InternalUmlProperty.g:2540:1: RULE_ID
					{
						before(grammarAccess.getTypeRuleAccess().getTypeClassifierIDTerminalRuleCall_1_0_1());
						match(input, RULE_ID, FOLLOW_2);
						after(grammarAccess.getTypeRuleAccess().getTypeClassifierIDTerminalRuleCall_1_0_1());

					}

					after(grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0());

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
	// $ANTLR end "rule__TypeRule__TypeAssignment_1"


	// $ANTLR start "rule__QualifiedName__PathAssignment_0"
	// InternalUmlProperty.g:2551:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
	public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2555:1: ( ( ( RULE_ID ) ) )
			// InternalUmlProperty.g:2556:1: ( ( RULE_ID ) )
			{
				// InternalUmlProperty.g:2556:1: ( ( RULE_ID ) )
				// InternalUmlProperty.g:2557:1: ( RULE_ID )
				{
					before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0());
					// InternalUmlProperty.g:2558:1: ( RULE_ID )
					// InternalUmlProperty.g:2559:1: RULE_ID
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
	// InternalUmlProperty.g:2570:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
	public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2574:1: ( ( ruleQualifiedName ) )
			// InternalUmlProperty.g:2575:1: ( ruleQualifiedName )
			{
				// InternalUmlProperty.g:2575:1: ( ruleQualifiedName )
				// InternalUmlProperty.g:2576:1: ruleQualifiedName
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


	// $ANTLR start "rule__MultiplicityRule__BoundsAssignment_1"
	// InternalUmlProperty.g:2585:1: rule__MultiplicityRule__BoundsAssignment_1 : ( ruleBoundSpecification ) ;
	public final void rule__MultiplicityRule__BoundsAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2589:1: ( ( ruleBoundSpecification ) )
			// InternalUmlProperty.g:2590:1: ( ruleBoundSpecification )
			{
				// InternalUmlProperty.g:2590:1: ( ruleBoundSpecification )
				// InternalUmlProperty.g:2591:1: ruleBoundSpecification
				{
					before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleBoundSpecification();

					state._fsp--;

					after(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0());

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
	// $ANTLR end "rule__MultiplicityRule__BoundsAssignment_1"


	// $ANTLR start "rule__MultiplicityRule__BoundsAssignment_2_1"
	// InternalUmlProperty.g:2600:1: rule__MultiplicityRule__BoundsAssignment_2_1 : ( ruleBoundSpecification ) ;
	public final void rule__MultiplicityRule__BoundsAssignment_2_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2604:1: ( ( ruleBoundSpecification ) )
			// InternalUmlProperty.g:2605:1: ( ruleBoundSpecification )
			{
				// InternalUmlProperty.g:2605:1: ( ruleBoundSpecification )
				// InternalUmlProperty.g:2606:1: ruleBoundSpecification
				{
					before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0());
					pushFollow(FOLLOW_2);
					ruleBoundSpecification();

					state._fsp--;

					after(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0());

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
	// $ANTLR end "rule__MultiplicityRule__BoundsAssignment_2_1"


	// $ANTLR start "rule__BoundSpecification__ValueAssignment"
	// InternalUmlProperty.g:2615:1: rule__BoundSpecification__ValueAssignment : ( ( rule__BoundSpecification__ValueAlternatives_0 ) ) ;
	public final void rule__BoundSpecification__ValueAssignment() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2619:1: ( ( ( rule__BoundSpecification__ValueAlternatives_0 ) ) )
			// InternalUmlProperty.g:2620:1: ( ( rule__BoundSpecification__ValueAlternatives_0 ) )
			{
				// InternalUmlProperty.g:2620:1: ( ( rule__BoundSpecification__ValueAlternatives_0 ) )
				// InternalUmlProperty.g:2621:1: ( rule__BoundSpecification__ValueAlternatives_0 )
				{
					before(grammarAccess.getBoundSpecificationAccess().getValueAlternatives_0());
					// InternalUmlProperty.g:2622:1: ( rule__BoundSpecification__ValueAlternatives_0 )
					// InternalUmlProperty.g:2622:2: rule__BoundSpecification__ValueAlternatives_0
					{
						pushFollow(FOLLOW_2);
						rule__BoundSpecification__ValueAlternatives_0();

						state._fsp--;


					}

					after(grammarAccess.getBoundSpecificationAccess().getValueAlternatives_0());

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
	// $ANTLR end "rule__BoundSpecification__ValueAssignment"


	// $ANTLR start "rule__ModifiersRule__ValuesAssignment_2_0"
	// InternalUmlProperty.g:2631:1: rule__ModifiersRule__ValuesAssignment_2_0 : ( ruleModifierSpecification ) ;
	public final void rule__ModifiersRule__ValuesAssignment_2_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2635:1: ( ( ruleModifierSpecification ) )
			// InternalUmlProperty.g:2636:1: ( ruleModifierSpecification )
			{
				// InternalUmlProperty.g:2636:1: ( ruleModifierSpecification )
				// InternalUmlProperty.g:2637:1: ruleModifierSpecification
				{
					before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_0_0());
					pushFollow(FOLLOW_2);
					ruleModifierSpecification();

					state._fsp--;

					after(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_0_0());

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
	// $ANTLR end "rule__ModifiersRule__ValuesAssignment_2_0"


	// $ANTLR start "rule__ModifiersRule__ValuesAssignment_2_1_1"
	// InternalUmlProperty.g:2646:1: rule__ModifiersRule__ValuesAssignment_2_1_1 : ( ruleModifierSpecification ) ;
	public final void rule__ModifiersRule__ValuesAssignment_2_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2650:1: ( ( ruleModifierSpecification ) )
			// InternalUmlProperty.g:2651:1: ( ruleModifierSpecification )
			{
				// InternalUmlProperty.g:2651:1: ( ruleModifierSpecification )
				// InternalUmlProperty.g:2652:1: ruleModifierSpecification
				{
					before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_1_0());
					pushFollow(FOLLOW_2);
					ruleModifierSpecification();

					state._fsp--;

					after(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_1_0());

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
	// $ANTLR end "rule__ModifiersRule__ValuesAssignment_2_1_1"


	// $ANTLR start "rule__ModifierSpecification__ValueAssignment_0"
	// InternalUmlProperty.g:2661:1: rule__ModifierSpecification__ValueAssignment_0 : ( ruleModifierKind ) ;
	public final void rule__ModifierSpecification__ValueAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2665:1: ( ( ruleModifierKind ) )
			// InternalUmlProperty.g:2666:1: ( ruleModifierKind )
			{
				// InternalUmlProperty.g:2666:1: ( ruleModifierKind )
				// InternalUmlProperty.g:2667:1: ruleModifierKind
				{
					before(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleModifierKind();

					state._fsp--;

					after(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0());

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
	// $ANTLR end "rule__ModifierSpecification__ValueAssignment_0"


	// $ANTLR start "rule__ModifierSpecification__RedefinesAssignment_1"
	// InternalUmlProperty.g:2676:1: rule__ModifierSpecification__RedefinesAssignment_1 : ( ruleRedefinesRule ) ;
	public final void rule__ModifierSpecification__RedefinesAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2680:1: ( ( ruleRedefinesRule ) )
			// InternalUmlProperty.g:2681:1: ( ruleRedefinesRule )
			{
				// InternalUmlProperty.g:2681:1: ( ruleRedefinesRule )
				// InternalUmlProperty.g:2682:1: ruleRedefinesRule
				{
					before(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleRedefinesRule();

					state._fsp--;

					after(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0());

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
	// $ANTLR end "rule__ModifierSpecification__RedefinesAssignment_1"


	// $ANTLR start "rule__ModifierSpecification__SubsetsAssignment_2"
	// InternalUmlProperty.g:2691:1: rule__ModifierSpecification__SubsetsAssignment_2 : ( ruleSubsetsRule ) ;
	public final void rule__ModifierSpecification__SubsetsAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2695:1: ( ( ruleSubsetsRule ) )
			// InternalUmlProperty.g:2696:1: ( ruleSubsetsRule )
			{
				// InternalUmlProperty.g:2696:1: ( ruleSubsetsRule )
				// InternalUmlProperty.g:2697:1: ruleSubsetsRule
				{
					before(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0());
					pushFollow(FOLLOW_2);
					ruleSubsetsRule();

					state._fsp--;

					after(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0());

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
	// $ANTLR end "rule__ModifierSpecification__SubsetsAssignment_2"


	// $ANTLR start "rule__RedefinesRule__PropertyAssignment_1"
	// InternalUmlProperty.g:2706:1: rule__RedefinesRule__PropertyAssignment_1 : ( ( RULE_ID ) ) ;
	public final void rule__RedefinesRule__PropertyAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2710:1: ( ( ( RULE_ID ) ) )
			// InternalUmlProperty.g:2711:1: ( ( RULE_ID ) )
			{
				// InternalUmlProperty.g:2711:1: ( ( RULE_ID ) )
				// InternalUmlProperty.g:2712:1: ( RULE_ID )
				{
					before(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyCrossReference_1_0());
					// InternalUmlProperty.g:2713:1: ( RULE_ID )
					// InternalUmlProperty.g:2714:1: RULE_ID
					{
						before(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1());
						match(input, RULE_ID, FOLLOW_2);
						after(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1());

					}

					after(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyCrossReference_1_0());

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
	// $ANTLR end "rule__RedefinesRule__PropertyAssignment_1"


	// $ANTLR start "rule__SubsetsRule__PropertyAssignment_1"
	// InternalUmlProperty.g:2725:1: rule__SubsetsRule__PropertyAssignment_1 : ( ( RULE_ID ) ) ;
	public final void rule__SubsetsRule__PropertyAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2729:1: ( ( ( RULE_ID ) ) )
			// InternalUmlProperty.g:2730:1: ( ( RULE_ID ) )
			{
				// InternalUmlProperty.g:2730:1: ( ( RULE_ID ) )
				// InternalUmlProperty.g:2731:1: ( RULE_ID )
				{
					before(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyCrossReference_1_0());
					// InternalUmlProperty.g:2732:1: ( RULE_ID )
					// InternalUmlProperty.g:2733:1: RULE_ID
					{
						before(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1());
						match(input, RULE_ID, FOLLOW_2);
						after(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1());

					}

					after(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyCrossReference_1_0());

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
	// $ANTLR end "rule__SubsetsRule__PropertyAssignment_1"


	// $ANTLR start "rule__DefaultValueRule__DefaultAssignment_1"
	// InternalUmlProperty.g:2744:1: rule__DefaultValueRule__DefaultAssignment_1 : ( ruleValue ) ;
	public final void rule__DefaultValueRule__DefaultAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2748:1: ( ( ruleValue ) )
			// InternalUmlProperty.g:2749:1: ( ruleValue )
			{
				// InternalUmlProperty.g:2749:1: ( ruleValue )
				// InternalUmlProperty.g:2750:1: ruleValue
				{
					before(grammarAccess.getDefaultValueRuleAccess().getDefaultValueParserRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleValue();

					state._fsp--;

					after(grammarAccess.getDefaultValueRuleAccess().getDefaultValueParserRuleCall_1_0());

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
	// $ANTLR end "rule__DefaultValueRule__DefaultAssignment_1"


	// $ANTLR start "rule__IntValue__LiteralIntegerAssignment"
	// InternalUmlProperty.g:2759:1: rule__IntValue__LiteralIntegerAssignment : ( RULE_INT ) ;
	public final void rule__IntValue__LiteralIntegerAssignment() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2763:1: ( ( RULE_INT ) )
			// InternalUmlProperty.g:2764:1: ( RULE_INT )
			{
				// InternalUmlProperty.g:2764:1: ( RULE_INT )
				// InternalUmlProperty.g:2765:1: RULE_INT
				{
					before(grammarAccess.getIntValueAccess().getLiteralIntegerINTTerminalRuleCall_0());
					match(input, RULE_INT, FOLLOW_2);
					after(grammarAccess.getIntValueAccess().getLiteralIntegerINTTerminalRuleCall_0());

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
	// $ANTLR end "rule__IntValue__LiteralIntegerAssignment"


	// $ANTLR start "rule__StringValue__LiteralStringAssignment"
	// InternalUmlProperty.g:2774:1: rule__StringValue__LiteralStringAssignment : ( RULE_STRING ) ;
	public final void rule__StringValue__LiteralStringAssignment() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2778:1: ( ( RULE_STRING ) )
			// InternalUmlProperty.g:2779:1: ( RULE_STRING )
			{
				// InternalUmlProperty.g:2779:1: ( RULE_STRING )
				// InternalUmlProperty.g:2780:1: RULE_STRING
				{
					before(grammarAccess.getStringValueAccess().getLiteralStringSTRINGTerminalRuleCall_0());
					match(input, RULE_STRING, FOLLOW_2);
					after(grammarAccess.getStringValueAccess().getLiteralStringSTRINGTerminalRuleCall_0());

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
	// $ANTLR end "rule__StringValue__LiteralStringAssignment"


	// $ANTLR start "rule__BooleanValue__LiteralBooleanAssignment"
	// InternalUmlProperty.g:2789:1: rule__BooleanValue__LiteralBooleanAssignment : ( ruleBooleanLiterals ) ;
	public final void rule__BooleanValue__LiteralBooleanAssignment() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2793:1: ( ( ruleBooleanLiterals ) )
			// InternalUmlProperty.g:2794:1: ( ruleBooleanLiterals )
			{
				// InternalUmlProperty.g:2794:1: ( ruleBooleanLiterals )
				// InternalUmlProperty.g:2795:1: ruleBooleanLiterals
				{
					before(grammarAccess.getBooleanValueAccess().getLiteralBooleanBooleanLiteralsEnumRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleBooleanLiterals();

					state._fsp--;

					after(grammarAccess.getBooleanValueAccess().getLiteralBooleanBooleanLiteralsEnumRuleCall_0());

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
	// $ANTLR end "rule__BooleanValue__LiteralBooleanAssignment"


	// $ANTLR start "rule__RealValue__IntegerAssignment_0_0"
	// InternalUmlProperty.g:2804:1: rule__RealValue__IntegerAssignment_0_0 : ( RULE_INT ) ;
	public final void rule__RealValue__IntegerAssignment_0_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2808:1: ( ( RULE_INT ) )
			// InternalUmlProperty.g:2809:1: ( RULE_INT )
			{
				// InternalUmlProperty.g:2809:1: ( RULE_INT )
				// InternalUmlProperty.g:2810:1: RULE_INT
				{
					before(grammarAccess.getRealValueAccess().getIntegerINTTerminalRuleCall_0_0_0());
					match(input, RULE_INT, FOLLOW_2);
					after(grammarAccess.getRealValueAccess().getIntegerINTTerminalRuleCall_0_0_0());

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
	// $ANTLR end "rule__RealValue__IntegerAssignment_0_0"


	// $ANTLR start "rule__RealValue__FractionAssignment_1_1"
	// InternalUmlProperty.g:2819:1: rule__RealValue__FractionAssignment_1_1 : ( RULE_INT ) ;
	public final void rule__RealValue__FractionAssignment_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2823:1: ( ( RULE_INT ) )
			// InternalUmlProperty.g:2824:1: ( RULE_INT )
			{
				// InternalUmlProperty.g:2824:1: ( RULE_INT )
				// InternalUmlProperty.g:2825:1: RULE_INT
				{
					before(grammarAccess.getRealValueAccess().getFractionINTTerminalRuleCall_1_1_0());
					match(input, RULE_INT, FOLLOW_2);
					after(grammarAccess.getRealValueAccess().getFractionINTTerminalRuleCall_1_1_0());

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
	// $ANTLR end "rule__RealValue__FractionAssignment_1_1"


	// $ANTLR start "rule__RealValue__IntegerAssignment_2_0"
	// InternalUmlProperty.g:2834:1: rule__RealValue__IntegerAssignment_2_0 : ( RULE_INT ) ;
	public final void rule__RealValue__IntegerAssignment_2_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2838:1: ( ( RULE_INT ) )
			// InternalUmlProperty.g:2839:1: ( RULE_INT )
			{
				// InternalUmlProperty.g:2839:1: ( RULE_INT )
				// InternalUmlProperty.g:2840:1: RULE_INT
				{
					before(grammarAccess.getRealValueAccess().getIntegerINTTerminalRuleCall_2_0_0());
					match(input, RULE_INT, FOLLOW_2);
					after(grammarAccess.getRealValueAccess().getIntegerINTTerminalRuleCall_2_0_0());

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
	// $ANTLR end "rule__RealValue__IntegerAssignment_2_0"


	// $ANTLR start "rule__RealValue__FractionAssignment_2_2"
	// InternalUmlProperty.g:2849:1: rule__RealValue__FractionAssignment_2_2 : ( RULE_INT ) ;
	public final void rule__RealValue__FractionAssignment_2_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlProperty.g:2853:1: ( ( RULE_INT ) )
			// InternalUmlProperty.g:2854:1: ( RULE_INT )
			{
				// InternalUmlProperty.g:2854:1: ( RULE_INT )
				// InternalUmlProperty.g:2855:1: RULE_INT
				{
					before(grammarAccess.getRealValueAccess().getFractionINTTerminalRuleCall_2_2_0());
					match(input, RULE_INT, FOLLOW_2);
					after(grammarAccess.getRealValueAccess().getFractionINTTerminalRuleCall_2_2_0());

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
	// $ANTLR end "rule__RealValue__FractionAssignment_2_2"

	// Delegated rules




	public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x0000002000000040L });
	public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x0000000212800000L });
	public static final BitSet FOLLOW_5 = new BitSet(new long[] { 0x0000004000000040L });
	public static final BitSet FOLLOW_6 = new BitSet(new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_7 = new BitSet(new long[] { 0x0000000001000000L });
	public static final BitSet FOLLOW_8 = new BitSet(new long[] { 0x0000000000001030L });
	public static final BitSet FOLLOW_9 = new BitSet(new long[] { 0x000000000C000000L });
	public static final BitSet FOLLOW_10 = new BitSet(new long[] { 0x0000000010000000L });
	public static final BitSet FOLLOW_11 = new BitSet(new long[] { 0x00000001A01E0000L });
	public static final BitSet FOLLOW_12 = new BitSet(new long[] { 0x0000000040000000L });
	public static final BitSet FOLLOW_13 = new BitSet(new long[] { 0x0000000040000002L });
	public static final BitSet FOLLOW_14 = new BitSet(new long[] { 0x00000001801E0000L });
	public static final BitSet FOLLOW_15 = new BitSet(new long[] { 0x0000001C00600030L });
	public static final BitSet FOLLOW_16 = new BitSet(new long[] { 0x0000000400000000L });
	public static final BitSet FOLLOW_17 = new BitSet(new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_18 = new BitSet(new long[] { 0x0000000800000000L });

}