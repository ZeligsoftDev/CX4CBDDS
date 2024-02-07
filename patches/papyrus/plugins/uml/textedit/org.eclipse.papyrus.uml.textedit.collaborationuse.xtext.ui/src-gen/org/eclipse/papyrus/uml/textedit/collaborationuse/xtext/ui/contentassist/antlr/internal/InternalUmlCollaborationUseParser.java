package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.contentassist.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.services.UmlCollaborationUseGrammarAccess;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

@SuppressWarnings("all")
public class InternalUmlCollaborationUseParser extends AbstractInternalContentAssistParser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INTEGER_VALUE", "RULE_WS", "RULE_ANY_OTHER", "'<Undefined>'", "'*'", "'+'", "'-'", "'#'", "'~'", "':'", "'::'"
	};
	public static final int RULE_STRING = 6;
	public static final int RULE_SL_COMMENT = 8;
	public static final int T__19 = 19;
	public static final int T__15 = 15;
	public static final int T__16 = 16;
	public static final int T__17 = 17;
	public static final int T__18 = 18;
	public static final int T__12 = 12;
	public static final int T__13 = 13;
	public static final int T__14 = 14;
	public static final int EOF = -1;
	public static final int RULE_ID = 5;
	public static final int RULE_WS = 10;
	public static final int RULE_ANY_OTHER = 11;
	public static final int RULE_INT = 4;
	public static final int RULE_ML_COMMENT = 7;
	public static final int RULE_INTEGER_VALUE = 9;

	// delegates
	// delegators


	public InternalUmlCollaborationUseParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalUmlCollaborationUseParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);

	}


	public String[] getTokenNames() {
		return InternalUmlCollaborationUseParser.tokenNames;
	}

	public String getGrammarFileName() {
		return "../org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/collaborationuse/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g";
	}



	private UmlCollaborationUseGrammarAccess grammarAccess;

	public void setGrammarAccess(UmlCollaborationUseGrammarAccess grammarAccess) {
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




	// $ANTLR start "entryRuleCollaborationUseRule"
	// InternalUmlCollaborationUse.g:60:1: entryRuleCollaborationUseRule : ruleCollaborationUseRule EOF ;
	public final void entryRuleCollaborationUseRule() throws RecognitionException {
		try {
			// InternalUmlCollaborationUse.g:61:1: ( ruleCollaborationUseRule EOF )
			// InternalUmlCollaborationUse.g:62:1: ruleCollaborationUseRule EOF
			{
				before(grammarAccess.getCollaborationUseRuleRule());
				pushFollow(FOLLOW_1);
				ruleCollaborationUseRule();

				state._fsp--;

				after(grammarAccess.getCollaborationUseRuleRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleCollaborationUseRule"


	// $ANTLR start "ruleCollaborationUseRule"
	// InternalUmlCollaborationUse.g:69:1: ruleCollaborationUseRule : ( ( rule__CollaborationUseRule__Group__0 ) ) ;
	public final void ruleCollaborationUseRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:73:2: ( ( ( rule__CollaborationUseRule__Group__0 ) ) )
			// InternalUmlCollaborationUse.g:74:1: ( ( rule__CollaborationUseRule__Group__0 ) )
			{
				// InternalUmlCollaborationUse.g:74:1: ( ( rule__CollaborationUseRule__Group__0 ) )
				// InternalUmlCollaborationUse.g:75:1: ( rule__CollaborationUseRule__Group__0 )
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getGroup());
					// InternalUmlCollaborationUse.g:76:1: ( rule__CollaborationUseRule__Group__0 )
					// InternalUmlCollaborationUse.g:76:2: rule__CollaborationUseRule__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__CollaborationUseRule__Group__0();

						state._fsp--;


					}

					after(grammarAccess.getCollaborationUseRuleAccess().getGroup());

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
	// $ANTLR end "ruleCollaborationUseRule"


	// $ANTLR start "entryRuleTypeRule"
	// InternalUmlCollaborationUse.g:88:1: entryRuleTypeRule : ruleTypeRule EOF ;
	public final void entryRuleTypeRule() throws RecognitionException {
		try {
			// InternalUmlCollaborationUse.g:89:1: ( ruleTypeRule EOF )
			// InternalUmlCollaborationUse.g:90:1: ruleTypeRule EOF
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
	// InternalUmlCollaborationUse.g:97:1: ruleTypeRule : ( ( rule__TypeRule__Group__0 ) ) ;
	public final void ruleTypeRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:101:2: ( ( ( rule__TypeRule__Group__0 ) ) )
			// InternalUmlCollaborationUse.g:102:1: ( ( rule__TypeRule__Group__0 ) )
			{
				// InternalUmlCollaborationUse.g:102:1: ( ( rule__TypeRule__Group__0 ) )
				// InternalUmlCollaborationUse.g:103:1: ( rule__TypeRule__Group__0 )
				{
					before(grammarAccess.getTypeRuleAccess().getGroup());
					// InternalUmlCollaborationUse.g:104:1: ( rule__TypeRule__Group__0 )
					// InternalUmlCollaborationUse.g:104:2: rule__TypeRule__Group__0
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
	// InternalUmlCollaborationUse.g:116:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
	public final void entryRuleQualifiedName() throws RecognitionException {
		try {
			// InternalUmlCollaborationUse.g:117:1: ( ruleQualifiedName EOF )
			// InternalUmlCollaborationUse.g:118:1: ruleQualifiedName EOF
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
	// InternalUmlCollaborationUse.g:125:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
	public final void ruleQualifiedName() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:129:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
			// InternalUmlCollaborationUse.g:130:1: ( ( rule__QualifiedName__Group__0 ) )
			{
				// InternalUmlCollaborationUse.g:130:1: ( ( rule__QualifiedName__Group__0 ) )
				// InternalUmlCollaborationUse.g:131:1: ( rule__QualifiedName__Group__0 )
				{
					before(grammarAccess.getQualifiedNameAccess().getGroup());
					// InternalUmlCollaborationUse.g:132:1: ( rule__QualifiedName__Group__0 )
					// InternalUmlCollaborationUse.g:132:2: rule__QualifiedName__Group__0
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


	// $ANTLR start "entryRuleBoundSpecification"
	// InternalUmlCollaborationUse.g:146:1: entryRuleBoundSpecification : ruleBoundSpecification EOF ;
	public final void entryRuleBoundSpecification() throws RecognitionException {
		try {
			// InternalUmlCollaborationUse.g:147:1: ( ruleBoundSpecification EOF )
			// InternalUmlCollaborationUse.g:148:1: ruleBoundSpecification EOF
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
	// InternalUmlCollaborationUse.g:155:1: ruleBoundSpecification : ( ( rule__BoundSpecification__ValueAssignment ) ) ;
	public final void ruleBoundSpecification() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:159:2: ( ( ( rule__BoundSpecification__ValueAssignment ) ) )
			// InternalUmlCollaborationUse.g:160:1: ( ( rule__BoundSpecification__ValueAssignment ) )
			{
				// InternalUmlCollaborationUse.g:160:1: ( ( rule__BoundSpecification__ValueAssignment ) )
				// InternalUmlCollaborationUse.g:161:1: ( rule__BoundSpecification__ValueAssignment )
				{
					before(grammarAccess.getBoundSpecificationAccess().getValueAssignment());
					// InternalUmlCollaborationUse.g:162:1: ( rule__BoundSpecification__ValueAssignment )
					// InternalUmlCollaborationUse.g:162:2: rule__BoundSpecification__ValueAssignment
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
	// InternalUmlCollaborationUse.g:174:1: entryRuleUnlimitedLiteral : ruleUnlimitedLiteral EOF ;
	public final void entryRuleUnlimitedLiteral() throws RecognitionException {
		try {
			// InternalUmlCollaborationUse.g:175:1: ( ruleUnlimitedLiteral EOF )
			// InternalUmlCollaborationUse.g:176:1: ruleUnlimitedLiteral EOF
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
	// InternalUmlCollaborationUse.g:183:1: ruleUnlimitedLiteral : ( ( rule__UnlimitedLiteral__Alternatives ) ) ;
	public final void ruleUnlimitedLiteral() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:187:2: ( ( ( rule__UnlimitedLiteral__Alternatives ) ) )
			// InternalUmlCollaborationUse.g:188:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
			{
				// InternalUmlCollaborationUse.g:188:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
				// InternalUmlCollaborationUse.g:189:1: ( rule__UnlimitedLiteral__Alternatives )
				{
					before(grammarAccess.getUnlimitedLiteralAccess().getAlternatives());
					// InternalUmlCollaborationUse.g:190:1: ( rule__UnlimitedLiteral__Alternatives )
					// InternalUmlCollaborationUse.g:190:2: rule__UnlimitedLiteral__Alternatives
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


	// $ANTLR start "ruleVisibilityKind"
	// InternalUmlCollaborationUse.g:203:1: ruleVisibilityKind : ( ( rule__VisibilityKind__Alternatives ) ) ;
	public final void ruleVisibilityKind() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:207:1: ( ( ( rule__VisibilityKind__Alternatives ) ) )
			// InternalUmlCollaborationUse.g:208:1: ( ( rule__VisibilityKind__Alternatives ) )
			{
				// InternalUmlCollaborationUse.g:208:1: ( ( rule__VisibilityKind__Alternatives ) )
				// InternalUmlCollaborationUse.g:209:1: ( rule__VisibilityKind__Alternatives )
				{
					before(grammarAccess.getVisibilityKindAccess().getAlternatives());
					// InternalUmlCollaborationUse.g:210:1: ( rule__VisibilityKind__Alternatives )
					// InternalUmlCollaborationUse.g:210:2: rule__VisibilityKind__Alternatives
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


	// $ANTLR start "rule__CollaborationUseRule__Alternatives_3"
	// InternalUmlCollaborationUse.g:223:1: rule__CollaborationUseRule__Alternatives_3 : ( ( ( rule__CollaborationUseRule__TypeAssignment_3_0 ) ) | ( '<Undefined>' ) );
	public final void rule__CollaborationUseRule__Alternatives_3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:227:1: ( ( ( rule__CollaborationUseRule__TypeAssignment_3_0 ) ) | ( '<Undefined>' ) )
			int alt1 = 2;
			int LA1_0 = input.LA(1);

			if ((LA1_0 == RULE_ID)) {
				alt1 = 1;
			} else if ((LA1_0 == 12)) {
				alt1 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 1, 0, input);

				throw nvae;
			}
			switch (alt1) {
			case 1:
			// InternalUmlCollaborationUse.g:228:1: ( ( rule__CollaborationUseRule__TypeAssignment_3_0 ) )
			{
				// InternalUmlCollaborationUse.g:228:1: ( ( rule__CollaborationUseRule__TypeAssignment_3_0 ) )
				// InternalUmlCollaborationUse.g:229:1: ( rule__CollaborationUseRule__TypeAssignment_3_0 )
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getTypeAssignment_3_0());
					// InternalUmlCollaborationUse.g:230:1: ( rule__CollaborationUseRule__TypeAssignment_3_0 )
					// InternalUmlCollaborationUse.g:230:2: rule__CollaborationUseRule__TypeAssignment_3_0
					{
						pushFollow(FOLLOW_2);
						rule__CollaborationUseRule__TypeAssignment_3_0();

						state._fsp--;


					}

					after(grammarAccess.getCollaborationUseRuleAccess().getTypeAssignment_3_0());

				}


			}
				break;
			case 2:
			// InternalUmlCollaborationUse.g:234:6: ( '<Undefined>' )
			{
				// InternalUmlCollaborationUse.g:234:6: ( '<Undefined>' )
				// InternalUmlCollaborationUse.g:235:1: '<Undefined>'
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getUndefinedKeyword_3_1());
					match(input, 12, FOLLOW_2);
					after(grammarAccess.getCollaborationUseRuleAccess().getUndefinedKeyword_3_1());

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
	// $ANTLR end "rule__CollaborationUseRule__Alternatives_3"


	// $ANTLR start "rule__UnlimitedLiteral__Alternatives"
	// InternalUmlCollaborationUse.g:247:1: rule__UnlimitedLiteral__Alternatives : ( ( RULE_INT ) | ( '*' ) );
	public final void rule__UnlimitedLiteral__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:251:1: ( ( RULE_INT ) | ( '*' ) )
			int alt2 = 2;
			int LA2_0 = input.LA(1);

			if ((LA2_0 == RULE_INT)) {
				alt2 = 1;
			} else if ((LA2_0 == 13)) {
				alt2 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 2, 0, input);

				throw nvae;
			}
			switch (alt2) {
			case 1:
			// InternalUmlCollaborationUse.g:252:1: ( RULE_INT )
			{
				// InternalUmlCollaborationUse.g:252:1: ( RULE_INT )
				// InternalUmlCollaborationUse.g:253:1: RULE_INT
				{
					before(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0());
					match(input, RULE_INT, FOLLOW_2);
					after(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0());

				}


			}
				break;
			case 2:
			// InternalUmlCollaborationUse.g:258:6: ( '*' )
			{
				// InternalUmlCollaborationUse.g:258:6: ( '*' )
				// InternalUmlCollaborationUse.g:259:1: '*'
				{
					before(grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1());
					match(input, 13, FOLLOW_2);
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


	// $ANTLR start "rule__VisibilityKind__Alternatives"
	// InternalUmlCollaborationUse.g:271:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );
	public final void rule__VisibilityKind__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:275:1: ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) )
			int alt3 = 4;
			switch (input.LA(1)) {
			case 14: {
				alt3 = 1;
			}
				break;
			case 15: {
				alt3 = 2;
			}
				break;
			case 16: {
				alt3 = 3;
			}
				break;
			case 17: {
				alt3 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 3, 0, input);

				throw nvae;
			}

			switch (alt3) {
			case 1:
			// InternalUmlCollaborationUse.g:276:1: ( ( '+' ) )
			{
				// InternalUmlCollaborationUse.g:276:1: ( ( '+' ) )
				// InternalUmlCollaborationUse.g:277:1: ( '+' )
				{
					before(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0());
					// InternalUmlCollaborationUse.g:278:1: ( '+' )
					// InternalUmlCollaborationUse.g:278:3: '+'
					{
						match(input, 14, FOLLOW_2);

					}

					after(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0());

				}


			}
				break;
			case 2:
			// InternalUmlCollaborationUse.g:283:6: ( ( '-' ) )
			{
				// InternalUmlCollaborationUse.g:283:6: ( ( '-' ) )
				// InternalUmlCollaborationUse.g:284:1: ( '-' )
				{
					before(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1());
					// InternalUmlCollaborationUse.g:285:1: ( '-' )
					// InternalUmlCollaborationUse.g:285:3: '-'
					{
						match(input, 15, FOLLOW_2);

					}

					after(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1());

				}


			}
				break;
			case 3:
			// InternalUmlCollaborationUse.g:290:6: ( ( '#' ) )
			{
				// InternalUmlCollaborationUse.g:290:6: ( ( '#' ) )
				// InternalUmlCollaborationUse.g:291:1: ( '#' )
				{
					before(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2());
					// InternalUmlCollaborationUse.g:292:1: ( '#' )
					// InternalUmlCollaborationUse.g:292:3: '#'
					{
						match(input, 16, FOLLOW_2);

					}

					after(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2());

				}


			}
				break;
			case 4:
			// InternalUmlCollaborationUse.g:297:6: ( ( '~' ) )
			{
				// InternalUmlCollaborationUse.g:297:6: ( ( '~' ) )
				// InternalUmlCollaborationUse.g:298:1: ( '~' )
				{
					before(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3());
					// InternalUmlCollaborationUse.g:299:1: ( '~' )
					// InternalUmlCollaborationUse.g:299:3: '~'
					{
						match(input, 17, FOLLOW_2);

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


	// $ANTLR start "rule__CollaborationUseRule__Group__0"
	// InternalUmlCollaborationUse.g:312:1: rule__CollaborationUseRule__Group__0 : rule__CollaborationUseRule__Group__0__Impl rule__CollaborationUseRule__Group__1 ;
	public final void rule__CollaborationUseRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:316:1: ( rule__CollaborationUseRule__Group__0__Impl rule__CollaborationUseRule__Group__1 )
			// InternalUmlCollaborationUse.g:317:2: rule__CollaborationUseRule__Group__0__Impl rule__CollaborationUseRule__Group__1
			{
				pushFollow(FOLLOW_3);
				rule__CollaborationUseRule__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__CollaborationUseRule__Group__1();

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
	// $ANTLR end "rule__CollaborationUseRule__Group__0"


	// $ANTLR start "rule__CollaborationUseRule__Group__0__Impl"
	// InternalUmlCollaborationUse.g:324:1: rule__CollaborationUseRule__Group__0__Impl : ( ( rule__CollaborationUseRule__VisibilityAssignment_0 ) ) ;
	public final void rule__CollaborationUseRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:328:1: ( ( ( rule__CollaborationUseRule__VisibilityAssignment_0 ) ) )
			// InternalUmlCollaborationUse.g:329:1: ( ( rule__CollaborationUseRule__VisibilityAssignment_0 ) )
			{
				// InternalUmlCollaborationUse.g:329:1: ( ( rule__CollaborationUseRule__VisibilityAssignment_0 ) )
				// InternalUmlCollaborationUse.g:330:1: ( rule__CollaborationUseRule__VisibilityAssignment_0 )
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getVisibilityAssignment_0());
					// InternalUmlCollaborationUse.g:331:1: ( rule__CollaborationUseRule__VisibilityAssignment_0 )
					// InternalUmlCollaborationUse.g:331:2: rule__CollaborationUseRule__VisibilityAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__CollaborationUseRule__VisibilityAssignment_0();

						state._fsp--;


					}

					after(grammarAccess.getCollaborationUseRuleAccess().getVisibilityAssignment_0());

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
	// $ANTLR end "rule__CollaborationUseRule__Group__0__Impl"


	// $ANTLR start "rule__CollaborationUseRule__Group__1"
	// InternalUmlCollaborationUse.g:341:1: rule__CollaborationUseRule__Group__1 : rule__CollaborationUseRule__Group__1__Impl rule__CollaborationUseRule__Group__2 ;
	public final void rule__CollaborationUseRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:345:1: ( rule__CollaborationUseRule__Group__1__Impl rule__CollaborationUseRule__Group__2 )
			// InternalUmlCollaborationUse.g:346:2: rule__CollaborationUseRule__Group__1__Impl rule__CollaborationUseRule__Group__2
			{
				pushFollow(FOLLOW_4);
				rule__CollaborationUseRule__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__CollaborationUseRule__Group__2();

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
	// $ANTLR end "rule__CollaborationUseRule__Group__1"


	// $ANTLR start "rule__CollaborationUseRule__Group__1__Impl"
	// InternalUmlCollaborationUse.g:353:1: rule__CollaborationUseRule__Group__1__Impl : ( ( rule__CollaborationUseRule__NameAssignment_1 ) ) ;
	public final void rule__CollaborationUseRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:357:1: ( ( ( rule__CollaborationUseRule__NameAssignment_1 ) ) )
			// InternalUmlCollaborationUse.g:358:1: ( ( rule__CollaborationUseRule__NameAssignment_1 ) )
			{
				// InternalUmlCollaborationUse.g:358:1: ( ( rule__CollaborationUseRule__NameAssignment_1 ) )
				// InternalUmlCollaborationUse.g:359:1: ( rule__CollaborationUseRule__NameAssignment_1 )
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getNameAssignment_1());
					// InternalUmlCollaborationUse.g:360:1: ( rule__CollaborationUseRule__NameAssignment_1 )
					// InternalUmlCollaborationUse.g:360:2: rule__CollaborationUseRule__NameAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__CollaborationUseRule__NameAssignment_1();

						state._fsp--;


					}

					after(grammarAccess.getCollaborationUseRuleAccess().getNameAssignment_1());

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
	// $ANTLR end "rule__CollaborationUseRule__Group__1__Impl"


	// $ANTLR start "rule__CollaborationUseRule__Group__2"
	// InternalUmlCollaborationUse.g:370:1: rule__CollaborationUseRule__Group__2 : rule__CollaborationUseRule__Group__2__Impl rule__CollaborationUseRule__Group__3 ;
	public final void rule__CollaborationUseRule__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:374:1: ( rule__CollaborationUseRule__Group__2__Impl rule__CollaborationUseRule__Group__3 )
			// InternalUmlCollaborationUse.g:375:2: rule__CollaborationUseRule__Group__2__Impl rule__CollaborationUseRule__Group__3
			{
				pushFollow(FOLLOW_5);
				rule__CollaborationUseRule__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__CollaborationUseRule__Group__3();

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
	// $ANTLR end "rule__CollaborationUseRule__Group__2"


	// $ANTLR start "rule__CollaborationUseRule__Group__2__Impl"
	// InternalUmlCollaborationUse.g:382:1: rule__CollaborationUseRule__Group__2__Impl : ( ':' ) ;
	public final void rule__CollaborationUseRule__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:386:1: ( ( ':' ) )
			// InternalUmlCollaborationUse.g:387:1: ( ':' )
			{
				// InternalUmlCollaborationUse.g:387:1: ( ':' )
				// InternalUmlCollaborationUse.g:388:1: ':'
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getColonKeyword_2());
					match(input, 18, FOLLOW_2);
					after(grammarAccess.getCollaborationUseRuleAccess().getColonKeyword_2());

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
	// $ANTLR end "rule__CollaborationUseRule__Group__2__Impl"


	// $ANTLR start "rule__CollaborationUseRule__Group__3"
	// InternalUmlCollaborationUse.g:401:1: rule__CollaborationUseRule__Group__3 : rule__CollaborationUseRule__Group__3__Impl ;
	public final void rule__CollaborationUseRule__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:405:1: ( rule__CollaborationUseRule__Group__3__Impl )
			// InternalUmlCollaborationUse.g:406:2: rule__CollaborationUseRule__Group__3__Impl
			{
				pushFollow(FOLLOW_2);
				rule__CollaborationUseRule__Group__3__Impl();

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
	// $ANTLR end "rule__CollaborationUseRule__Group__3"


	// $ANTLR start "rule__CollaborationUseRule__Group__3__Impl"
	// InternalUmlCollaborationUse.g:412:1: rule__CollaborationUseRule__Group__3__Impl : ( ( rule__CollaborationUseRule__Alternatives_3 ) ) ;
	public final void rule__CollaborationUseRule__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:416:1: ( ( ( rule__CollaborationUseRule__Alternatives_3 ) ) )
			// InternalUmlCollaborationUse.g:417:1: ( ( rule__CollaborationUseRule__Alternatives_3 ) )
			{
				// InternalUmlCollaborationUse.g:417:1: ( ( rule__CollaborationUseRule__Alternatives_3 ) )
				// InternalUmlCollaborationUse.g:418:1: ( rule__CollaborationUseRule__Alternatives_3 )
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getAlternatives_3());
					// InternalUmlCollaborationUse.g:419:1: ( rule__CollaborationUseRule__Alternatives_3 )
					// InternalUmlCollaborationUse.g:419:2: rule__CollaborationUseRule__Alternatives_3
					{
						pushFollow(FOLLOW_2);
						rule__CollaborationUseRule__Alternatives_3();

						state._fsp--;


					}

					after(grammarAccess.getCollaborationUseRuleAccess().getAlternatives_3());

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
	// $ANTLR end "rule__CollaborationUseRule__Group__3__Impl"


	// $ANTLR start "rule__TypeRule__Group__0"
	// InternalUmlCollaborationUse.g:437:1: rule__TypeRule__Group__0 : rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 ;
	public final void rule__TypeRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:441:1: ( rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 )
			// InternalUmlCollaborationUse.g:442:2: rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1
			{
				pushFollow(FOLLOW_3);
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
	// InternalUmlCollaborationUse.g:449:1: rule__TypeRule__Group__0__Impl : ( ( rule__TypeRule__PathAssignment_0 )? ) ;
	public final void rule__TypeRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:453:1: ( ( ( rule__TypeRule__PathAssignment_0 )? ) )
			// InternalUmlCollaborationUse.g:454:1: ( ( rule__TypeRule__PathAssignment_0 )? )
			{
				// InternalUmlCollaborationUse.g:454:1: ( ( rule__TypeRule__PathAssignment_0 )? )
				// InternalUmlCollaborationUse.g:455:1: ( rule__TypeRule__PathAssignment_0 )?
				{
					before(grammarAccess.getTypeRuleAccess().getPathAssignment_0());
					// InternalUmlCollaborationUse.g:456:1: ( rule__TypeRule__PathAssignment_0 )?
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if ((LA4_0 == RULE_ID)) {
						int LA4_1 = input.LA(2);

						if ((LA4_1 == 19)) {
							alt4 = 1;
						}
					}
					switch (alt4) {
					case 1:
					// InternalUmlCollaborationUse.g:456:2: rule__TypeRule__PathAssignment_0
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
	// InternalUmlCollaborationUse.g:466:1: rule__TypeRule__Group__1 : rule__TypeRule__Group__1__Impl ;
	public final void rule__TypeRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:470:1: ( rule__TypeRule__Group__1__Impl )
			// InternalUmlCollaborationUse.g:471:2: rule__TypeRule__Group__1__Impl
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
	// InternalUmlCollaborationUse.g:477:1: rule__TypeRule__Group__1__Impl : ( ( rule__TypeRule__TypeAssignment_1 ) ) ;
	public final void rule__TypeRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:481:1: ( ( ( rule__TypeRule__TypeAssignment_1 ) ) )
			// InternalUmlCollaborationUse.g:482:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
			{
				// InternalUmlCollaborationUse.g:482:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
				// InternalUmlCollaborationUse.g:483:1: ( rule__TypeRule__TypeAssignment_1 )
				{
					before(grammarAccess.getTypeRuleAccess().getTypeAssignment_1());
					// InternalUmlCollaborationUse.g:484:1: ( rule__TypeRule__TypeAssignment_1 )
					// InternalUmlCollaborationUse.g:484:2: rule__TypeRule__TypeAssignment_1
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
	// InternalUmlCollaborationUse.g:498:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
	public final void rule__QualifiedName__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:502:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
			// InternalUmlCollaborationUse.g:503:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
			{
				pushFollow(FOLLOW_6);
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
	// InternalUmlCollaborationUse.g:510:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
	public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:514:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
			// InternalUmlCollaborationUse.g:515:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
			{
				// InternalUmlCollaborationUse.g:515:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
				// InternalUmlCollaborationUse.g:516:1: ( rule__QualifiedName__PathAssignment_0 )
				{
					before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0());
					// InternalUmlCollaborationUse.g:517:1: ( rule__QualifiedName__PathAssignment_0 )
					// InternalUmlCollaborationUse.g:517:2: rule__QualifiedName__PathAssignment_0
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
	// InternalUmlCollaborationUse.g:527:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
	public final void rule__QualifiedName__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:531:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
			// InternalUmlCollaborationUse.g:532:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
			{
				pushFollow(FOLLOW_3);
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
	// InternalUmlCollaborationUse.g:539:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
	public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:543:1: ( ( '::' ) )
			// InternalUmlCollaborationUse.g:544:1: ( '::' )
			{
				// InternalUmlCollaborationUse.g:544:1: ( '::' )
				// InternalUmlCollaborationUse.g:545:1: '::'
				{
					before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());
					match(input, 19, FOLLOW_2);
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
	// InternalUmlCollaborationUse.g:558:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
	public final void rule__QualifiedName__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:562:1: ( rule__QualifiedName__Group__2__Impl )
			// InternalUmlCollaborationUse.g:563:2: rule__QualifiedName__Group__2__Impl
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
	// InternalUmlCollaborationUse.g:569:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
	public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:573:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
			// InternalUmlCollaborationUse.g:574:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
			{
				// InternalUmlCollaborationUse.g:574:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
				// InternalUmlCollaborationUse.g:575:1: ( rule__QualifiedName__RemainingAssignment_2 )?
				{
					before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2());
					// InternalUmlCollaborationUse.g:576:1: ( rule__QualifiedName__RemainingAssignment_2 )?
					int alt5 = 2;
					int LA5_0 = input.LA(1);

					if ((LA5_0 == RULE_ID)) {
						int LA5_1 = input.LA(2);

						if ((LA5_1 == 19)) {
							alt5 = 1;
						}
					}
					switch (alt5) {
					case 1:
					// InternalUmlCollaborationUse.g:576:2: rule__QualifiedName__RemainingAssignment_2
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


	// $ANTLR start "rule__CollaborationUseRule__VisibilityAssignment_0"
	// InternalUmlCollaborationUse.g:595:1: rule__CollaborationUseRule__VisibilityAssignment_0 : ( ruleVisibilityKind ) ;
	public final void rule__CollaborationUseRule__VisibilityAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:599:1: ( ( ruleVisibilityKind ) )
			// InternalUmlCollaborationUse.g:600:1: ( ruleVisibilityKind )
			{
				// InternalUmlCollaborationUse.g:600:1: ( ruleVisibilityKind )
				// InternalUmlCollaborationUse.g:601:1: ruleVisibilityKind
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleVisibilityKind();

					state._fsp--;

					after(grammarAccess.getCollaborationUseRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0());

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
	// $ANTLR end "rule__CollaborationUseRule__VisibilityAssignment_0"


	// $ANTLR start "rule__CollaborationUseRule__NameAssignment_1"
	// InternalUmlCollaborationUse.g:610:1: rule__CollaborationUseRule__NameAssignment_1 : ( RULE_ID ) ;
	public final void rule__CollaborationUseRule__NameAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:614:1: ( ( RULE_ID ) )
			// InternalUmlCollaborationUse.g:615:1: ( RULE_ID )
			{
				// InternalUmlCollaborationUse.g:615:1: ( RULE_ID )
				// InternalUmlCollaborationUse.g:616:1: RULE_ID
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getNameIDTerminalRuleCall_1_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getCollaborationUseRuleAccess().getNameIDTerminalRuleCall_1_0());

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
	// $ANTLR end "rule__CollaborationUseRule__NameAssignment_1"


	// $ANTLR start "rule__CollaborationUseRule__TypeAssignment_3_0"
	// InternalUmlCollaborationUse.g:625:1: rule__CollaborationUseRule__TypeAssignment_3_0 : ( ruleTypeRule ) ;
	public final void rule__CollaborationUseRule__TypeAssignment_3_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:629:1: ( ( ruleTypeRule ) )
			// InternalUmlCollaborationUse.g:630:1: ( ruleTypeRule )
			{
				// InternalUmlCollaborationUse.g:630:1: ( ruleTypeRule )
				// InternalUmlCollaborationUse.g:631:1: ruleTypeRule
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getTypeTypeRuleParserRuleCall_3_0_0());
					pushFollow(FOLLOW_2);
					ruleTypeRule();

					state._fsp--;

					after(grammarAccess.getCollaborationUseRuleAccess().getTypeTypeRuleParserRuleCall_3_0_0());

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
	// $ANTLR end "rule__CollaborationUseRule__TypeAssignment_3_0"


	// $ANTLR start "rule__TypeRule__PathAssignment_0"
	// InternalUmlCollaborationUse.g:640:1: rule__TypeRule__PathAssignment_0 : ( ruleQualifiedName ) ;
	public final void rule__TypeRule__PathAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:644:1: ( ( ruleQualifiedName ) )
			// InternalUmlCollaborationUse.g:645:1: ( ruleQualifiedName )
			{
				// InternalUmlCollaborationUse.g:645:1: ( ruleQualifiedName )
				// InternalUmlCollaborationUse.g:646:1: ruleQualifiedName
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
	// InternalUmlCollaborationUse.g:655:1: rule__TypeRule__TypeAssignment_1 : ( ( RULE_ID ) ) ;
	public final void rule__TypeRule__TypeAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:659:1: ( ( ( RULE_ID ) ) )
			// InternalUmlCollaborationUse.g:660:1: ( ( RULE_ID ) )
			{
				// InternalUmlCollaborationUse.g:660:1: ( ( RULE_ID ) )
				// InternalUmlCollaborationUse.g:661:1: ( RULE_ID )
				{
					before(grammarAccess.getTypeRuleAccess().getTypeCollaborationCrossReference_1_0());
					// InternalUmlCollaborationUse.g:662:1: ( RULE_ID )
					// InternalUmlCollaborationUse.g:663:1: RULE_ID
					{
						before(grammarAccess.getTypeRuleAccess().getTypeCollaborationIDTerminalRuleCall_1_0_1());
						match(input, RULE_ID, FOLLOW_2);
						after(grammarAccess.getTypeRuleAccess().getTypeCollaborationIDTerminalRuleCall_1_0_1());

					}

					after(grammarAccess.getTypeRuleAccess().getTypeCollaborationCrossReference_1_0());

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
	// InternalUmlCollaborationUse.g:674:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
	public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:678:1: ( ( ( RULE_ID ) ) )
			// InternalUmlCollaborationUse.g:679:1: ( ( RULE_ID ) )
			{
				// InternalUmlCollaborationUse.g:679:1: ( ( RULE_ID ) )
				// InternalUmlCollaborationUse.g:680:1: ( RULE_ID )
				{
					before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0());
					// InternalUmlCollaborationUse.g:681:1: ( RULE_ID )
					// InternalUmlCollaborationUse.g:682:1: RULE_ID
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
	// InternalUmlCollaborationUse.g:693:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
	public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:697:1: ( ( ruleQualifiedName ) )
			// InternalUmlCollaborationUse.g:698:1: ( ruleQualifiedName )
			{
				// InternalUmlCollaborationUse.g:698:1: ( ruleQualifiedName )
				// InternalUmlCollaborationUse.g:699:1: ruleQualifiedName
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


	// $ANTLR start "rule__BoundSpecification__ValueAssignment"
	// InternalUmlCollaborationUse.g:710:1: rule__BoundSpecification__ValueAssignment : ( ruleUnlimitedLiteral ) ;
	public final void rule__BoundSpecification__ValueAssignment() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalUmlCollaborationUse.g:714:1: ( ( ruleUnlimitedLiteral ) )
			// InternalUmlCollaborationUse.g:715:1: ( ruleUnlimitedLiteral )
			{
				// InternalUmlCollaborationUse.g:715:1: ( ruleUnlimitedLiteral )
				// InternalUmlCollaborationUse.g:716:1: ruleUnlimitedLiteral
				{
					before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleUnlimitedLiteral();

					state._fsp--;

					after(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0());

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

	// Delegated rules




	public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_5 = new BitSet(new long[] { 0x0000000000001020L });
	public static final BitSet FOLLOW_6 = new BitSet(new long[] { 0x0000000000080000L });

}