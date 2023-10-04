package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.parser.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.services.UmlCollaborationUseGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;

@SuppressWarnings("all")
public class InternalUmlCollaborationUseParser extends AbstractInternalAntlrParser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INTEGER_VALUE", "RULE_WS", "RULE_ANY_OTHER", "':'", "'<Undefined>'", "'::'", "'*'", "'+'", "'-'", "'#'", "'~'"
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
	public static final int RULE_ID = 4;
	public static final int RULE_WS = 10;
	public static final int RULE_ANY_OTHER = 11;
	public static final int RULE_INT = 5;
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
		return "../org.eclipse.papyrus.uml.textedit.collaborationuse.xtext/src-gen/org/eclipse/papyrus/uml/textedit/collaborationuse/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g";
	}



	private UmlCollaborationUseGrammarAccess grammarAccess;

	public InternalUmlCollaborationUseParser(TokenStream input, UmlCollaborationUseGrammarAccess grammarAccess) {
		this(input);
		this.grammarAccess = grammarAccess;
		registerRules(grammarAccess.getGrammar());
	}

	@Override
	protected String getFirstRuleName() {
		return "CollaborationUseRule";
	}

	@Override
	protected UmlCollaborationUseGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}



	// $ANTLR start "entryRuleCollaborationUseRule"
	// InternalUmlCollaborationUse.g:68:1: entryRuleCollaborationUseRule returns [EObject current=null] : iv_ruleCollaborationUseRule= ruleCollaborationUseRule EOF ;
	public final EObject entryRuleCollaborationUseRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleCollaborationUseRule = null;


		try {
			// InternalUmlCollaborationUse.g:69:2: (iv_ruleCollaborationUseRule= ruleCollaborationUseRule EOF )
			// InternalUmlCollaborationUse.g:70:2: iv_ruleCollaborationUseRule= ruleCollaborationUseRule EOF
			{
				newCompositeNode(grammarAccess.getCollaborationUseRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleCollaborationUseRule = ruleCollaborationUseRule();

				state._fsp--;

				current = iv_ruleCollaborationUseRule;
				match(input, EOF, FOLLOW_2);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleCollaborationUseRule"


	// $ANTLR start "ruleCollaborationUseRule"
	// InternalUmlCollaborationUse.g:77:1: ruleCollaborationUseRule returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_type_3_0= ruleTypeRule ) ) | otherlv_4= '<Undefined>' ) ) ;
	public final EObject ruleCollaborationUseRule() throws RecognitionException {
		EObject current = null;

		Token lv_name_1_0 = null;
		Token otherlv_2 = null;
		Token otherlv_4 = null;
		Enumerator lv_visibility_0_0 = null;

		EObject lv_type_3_0 = null;


		enterRule();

		try {
			// InternalUmlCollaborationUse.g:80:28: ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_type_3_0= ruleTypeRule ) ) | otherlv_4= '<Undefined>' ) ) )
			// InternalUmlCollaborationUse.g:81:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_type_3_0= ruleTypeRule ) ) | otherlv_4= '<Undefined>' ) )
			{
				// InternalUmlCollaborationUse.g:81:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_type_3_0= ruleTypeRule ) ) | otherlv_4= '<Undefined>' ) )
				// InternalUmlCollaborationUse.g:81:2: ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_type_3_0= ruleTypeRule ) ) | otherlv_4= '<Undefined>' )
				{
					// InternalUmlCollaborationUse.g:81:2: ( (lv_visibility_0_0= ruleVisibilityKind ) )
					// InternalUmlCollaborationUse.g:82:1: (lv_visibility_0_0= ruleVisibilityKind )
					{
						// InternalUmlCollaborationUse.g:82:1: (lv_visibility_0_0= ruleVisibilityKind )
						// InternalUmlCollaborationUse.g:83:3: lv_visibility_0_0= ruleVisibilityKind
						{

							newCompositeNode(grammarAccess.getCollaborationUseRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0());

							pushFollow(FOLLOW_3);
							lv_visibility_0_0 = ruleVisibilityKind();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getCollaborationUseRuleRule());
							}
							set(
									current,
									"visibility",
									lv_visibility_0_0,
									"org.eclipse.papyrus.uml.textedit.common.xtext.UmlCommon.VisibilityKind");
							afterParserOrEnumRuleCall();


						}


					}

					// InternalUmlCollaborationUse.g:99:2: ( (lv_name_1_0= RULE_ID ) )
					// InternalUmlCollaborationUse.g:100:1: (lv_name_1_0= RULE_ID )
					{
						// InternalUmlCollaborationUse.g:100:1: (lv_name_1_0= RULE_ID )
						// InternalUmlCollaborationUse.g:101:3: lv_name_1_0= RULE_ID
						{
							lv_name_1_0 = (Token) match(input, RULE_ID, FOLLOW_4);

							newLeafNode(lv_name_1_0, grammarAccess.getCollaborationUseRuleAccess().getNameIDTerminalRuleCall_1_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getCollaborationUseRuleRule());
							}
							setWithLastConsumed(
									current,
									"name",
									lv_name_1_0,
									"org.eclipse.papyrus.uml.alf.Common.ID");


						}


					}

					otherlv_2 = (Token) match(input, 12, FOLLOW_5);

					newLeafNode(otherlv_2, grammarAccess.getCollaborationUseRuleAccess().getColonKeyword_2());

					// InternalUmlCollaborationUse.g:121:1: ( ( (lv_type_3_0= ruleTypeRule ) ) | otherlv_4= '<Undefined>' )
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if ((LA1_0 == RULE_ID)) {
						alt1 = 1;
					} else if ((LA1_0 == 13)) {
						alt1 = 2;
					} else {
						NoViableAltException nvae = new NoViableAltException("", 1, 0, input);

						throw nvae;
					}
					switch (alt1) {
					case 1:
					// InternalUmlCollaborationUse.g:121:2: ( (lv_type_3_0= ruleTypeRule ) )
					{
						// InternalUmlCollaborationUse.g:121:2: ( (lv_type_3_0= ruleTypeRule ) )
						// InternalUmlCollaborationUse.g:122:1: (lv_type_3_0= ruleTypeRule )
						{
							// InternalUmlCollaborationUse.g:122:1: (lv_type_3_0= ruleTypeRule )
							// InternalUmlCollaborationUse.g:123:3: lv_type_3_0= ruleTypeRule
							{

								newCompositeNode(grammarAccess.getCollaborationUseRuleAccess().getTypeTypeRuleParserRuleCall_3_0_0());

								pushFollow(FOLLOW_2);
								lv_type_3_0 = ruleTypeRule();

								state._fsp--;


								if (current == null) {
									current = createModelElementForParent(grammarAccess.getCollaborationUseRuleRule());
								}
								set(
										current,
										"type",
										lv_type_3_0,
										"org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.UmlCollaborationUse.TypeRule");
								afterParserOrEnumRuleCall();


							}


						}


					}
						break;
					case 2:
					// InternalUmlCollaborationUse.g:140:7: otherlv_4= '<Undefined>'
					{
						otherlv_4 = (Token) match(input, 13, FOLLOW_2);

						newLeafNode(otherlv_4, grammarAccess.getCollaborationUseRuleAccess().getUndefinedKeyword_3_1());


					}
						break;

					}


				}


			}

			leaveRule();
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleCollaborationUseRule"


	// $ANTLR start "entryRuleTypeRule"
	// InternalUmlCollaborationUse.g:152:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
	public final EObject entryRuleTypeRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTypeRule = null;


		try {
			// InternalUmlCollaborationUse.g:153:2: (iv_ruleTypeRule= ruleTypeRule EOF )
			// InternalUmlCollaborationUse.g:154:2: iv_ruleTypeRule= ruleTypeRule EOF
			{
				newCompositeNode(grammarAccess.getTypeRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleTypeRule = ruleTypeRule();

				state._fsp--;

				current = iv_ruleTypeRule;
				match(input, EOF, FOLLOW_2);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleTypeRule"


	// $ANTLR start "ruleTypeRule"
	// InternalUmlCollaborationUse.g:161:1: ruleTypeRule returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
	public final EObject ruleTypeRule() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		EObject lv_path_0_0 = null;


		enterRule();

		try {
			// InternalUmlCollaborationUse.g:164:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
			// InternalUmlCollaborationUse.g:165:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
			{
				// InternalUmlCollaborationUse.g:165:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
				// InternalUmlCollaborationUse.g:165:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
				{
					// InternalUmlCollaborationUse.g:165:2: ( (lv_path_0_0= ruleQualifiedName ) )?
					int alt2 = 2;
					int LA2_0 = input.LA(1);

					if ((LA2_0 == RULE_ID)) {
						int LA2_1 = input.LA(2);

						if ((LA2_1 == 14)) {
							alt2 = 1;
						}
					}
					switch (alt2) {
					case 1:
					// InternalUmlCollaborationUse.g:166:1: (lv_path_0_0= ruleQualifiedName )
					{
						// InternalUmlCollaborationUse.g:166:1: (lv_path_0_0= ruleQualifiedName )
						// InternalUmlCollaborationUse.g:167:3: lv_path_0_0= ruleQualifiedName
						{

							newCompositeNode(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0());

							pushFollow(FOLLOW_3);
							lv_path_0_0 = ruleQualifiedName();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getTypeRuleRule());
							}
							set(
									current,
									"path",
									lv_path_0_0,
									"org.eclipse.papyrus.uml.textedit.common.xtext.UmlCommon.QualifiedName");
							afterParserOrEnumRuleCall();


						}


					}
						break;

					}

					// InternalUmlCollaborationUse.g:183:3: ( (otherlv_1= RULE_ID ) )
					// InternalUmlCollaborationUse.g:184:1: (otherlv_1= RULE_ID )
					{
						// InternalUmlCollaborationUse.g:184:1: (otherlv_1= RULE_ID )
						// InternalUmlCollaborationUse.g:185:3: otherlv_1= RULE_ID
						{

							if (current == null) {
								current = createModelElement(grammarAccess.getTypeRuleRule());
							}

							otherlv_1 = (Token) match(input, RULE_ID, FOLLOW_2);

							newLeafNode(otherlv_1, grammarAccess.getTypeRuleAccess().getTypeCollaborationCrossReference_1_0());


						}


					}


				}


			}

			leaveRule();
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleTypeRule"


	// $ANTLR start "entryRuleQualifiedName"
	// InternalUmlCollaborationUse.g:204:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
	public final EObject entryRuleQualifiedName() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleQualifiedName = null;


		try {
			// InternalUmlCollaborationUse.g:205:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
			// InternalUmlCollaborationUse.g:206:2: iv_ruleQualifiedName= ruleQualifiedName EOF
			{
				newCompositeNode(grammarAccess.getQualifiedNameRule());
				pushFollow(FOLLOW_1);
				iv_ruleQualifiedName = ruleQualifiedName();

				state._fsp--;

				current = iv_ruleQualifiedName;
				match(input, EOF, FOLLOW_2);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleQualifiedName"


	// $ANTLR start "ruleQualifiedName"
	// InternalUmlCollaborationUse.g:213:1: ruleQualifiedName returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
	public final EObject ruleQualifiedName() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_1 = null;
		EObject lv_remaining_2_0 = null;


		enterRule();

		try {
			// InternalUmlCollaborationUse.g:216:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
			// InternalUmlCollaborationUse.g:217:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
			{
				// InternalUmlCollaborationUse.g:217:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
				// InternalUmlCollaborationUse.g:217:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
				{
					// InternalUmlCollaborationUse.g:217:2: ( (otherlv_0= RULE_ID ) )
					// InternalUmlCollaborationUse.g:218:1: (otherlv_0= RULE_ID )
					{
						// InternalUmlCollaborationUse.g:218:1: (otherlv_0= RULE_ID )
						// InternalUmlCollaborationUse.g:219:3: otherlv_0= RULE_ID
						{

							if (current == null) {
								current = createModelElement(grammarAccess.getQualifiedNameRule());
							}

							otherlv_0 = (Token) match(input, RULE_ID, FOLLOW_6);

							newLeafNode(otherlv_0, grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0());


						}


					}

					otherlv_1 = (Token) match(input, 14, FOLLOW_7);

					newLeafNode(otherlv_1, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());

					// InternalUmlCollaborationUse.g:234:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
					int alt3 = 2;
					int LA3_0 = input.LA(1);

					if ((LA3_0 == RULE_ID)) {
						int LA3_1 = input.LA(2);

						if ((LA3_1 == 14)) {
							alt3 = 1;
						}
					}
					switch (alt3) {
					case 1:
					// InternalUmlCollaborationUse.g:235:1: (lv_remaining_2_0= ruleQualifiedName )
					{
						// InternalUmlCollaborationUse.g:235:1: (lv_remaining_2_0= ruleQualifiedName )
						// InternalUmlCollaborationUse.g:236:3: lv_remaining_2_0= ruleQualifiedName
						{

							newCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0());

							pushFollow(FOLLOW_2);
							lv_remaining_2_0 = ruleQualifiedName();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getQualifiedNameRule());
							}
							set(
									current,
									"remaining",
									lv_remaining_2_0,
									"org.eclipse.papyrus.uml.textedit.common.xtext.UmlCommon.QualifiedName");
							afterParserOrEnumRuleCall();


						}


					}
						break;

					}


				}


			}

			leaveRule();
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleQualifiedName"


	// $ANTLR start "entryRuleBoundSpecification"
	// InternalUmlCollaborationUse.g:262:1: entryRuleBoundSpecification returns [EObject current=null] : iv_ruleBoundSpecification= ruleBoundSpecification EOF ;
	public final EObject entryRuleBoundSpecification() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleBoundSpecification = null;


		try {
			// InternalUmlCollaborationUse.g:263:2: (iv_ruleBoundSpecification= ruleBoundSpecification EOF )
			// InternalUmlCollaborationUse.g:264:2: iv_ruleBoundSpecification= ruleBoundSpecification EOF
			{
				newCompositeNode(grammarAccess.getBoundSpecificationRule());
				pushFollow(FOLLOW_1);
				iv_ruleBoundSpecification = ruleBoundSpecification();

				state._fsp--;

				current = iv_ruleBoundSpecification;
				match(input, EOF, FOLLOW_2);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleBoundSpecification"


	// $ANTLR start "ruleBoundSpecification"
	// InternalUmlCollaborationUse.g:271:1: ruleBoundSpecification returns [EObject current=null] : ( (lv_value_0_0= ruleUnlimitedLiteral ) ) ;
	public final EObject ruleBoundSpecification() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_value_0_0 = null;


		enterRule();

		try {
			// InternalUmlCollaborationUse.g:274:28: ( ( (lv_value_0_0= ruleUnlimitedLiteral ) ) )
			// InternalUmlCollaborationUse.g:275:1: ( (lv_value_0_0= ruleUnlimitedLiteral ) )
			{
				// InternalUmlCollaborationUse.g:275:1: ( (lv_value_0_0= ruleUnlimitedLiteral ) )
				// InternalUmlCollaborationUse.g:276:1: (lv_value_0_0= ruleUnlimitedLiteral )
				{
					// InternalUmlCollaborationUse.g:276:1: (lv_value_0_0= ruleUnlimitedLiteral )
					// InternalUmlCollaborationUse.g:277:3: lv_value_0_0= ruleUnlimitedLiteral
					{

						newCompositeNode(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0());

						pushFollow(FOLLOW_2);
						lv_value_0_0 = ruleUnlimitedLiteral();

						state._fsp--;


						if (current == null) {
							current = createModelElementForParent(grammarAccess.getBoundSpecificationRule());
						}
						set(
								current,
								"value",
								lv_value_0_0,
								"org.eclipse.papyrus.uml.textedit.common.xtext.UmlCommon.UnlimitedLiteral");
						afterParserOrEnumRuleCall();


					}


				}


			}

			leaveRule();
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleBoundSpecification"


	// $ANTLR start "entryRuleUnlimitedLiteral"
	// InternalUmlCollaborationUse.g:301:1: entryRuleUnlimitedLiteral returns [String current=null] : iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF ;
	public final String entryRuleUnlimitedLiteral() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleUnlimitedLiteral = null;


		try {
			// InternalUmlCollaborationUse.g:302:2: (iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF )
			// InternalUmlCollaborationUse.g:303:2: iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF
			{
				newCompositeNode(grammarAccess.getUnlimitedLiteralRule());
				pushFollow(FOLLOW_1);
				iv_ruleUnlimitedLiteral = ruleUnlimitedLiteral();

				state._fsp--;

				current = iv_ruleUnlimitedLiteral.getText();
				match(input, EOF, FOLLOW_2);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleUnlimitedLiteral"


	// $ANTLR start "ruleUnlimitedLiteral"
	// InternalUmlCollaborationUse.g:310:1: ruleUnlimitedLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
	public final AntlrDatatypeRuleToken ruleUnlimitedLiteral() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_INT_0 = null;
		Token kw = null;

		enterRule();

		try {
			// InternalUmlCollaborationUse.g:313:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
			// InternalUmlCollaborationUse.g:314:1: (this_INT_0= RULE_INT | kw= '*' )
			{
				// InternalUmlCollaborationUse.g:314:1: (this_INT_0= RULE_INT | kw= '*' )
				int alt4 = 2;
				int LA4_0 = input.LA(1);

				if ((LA4_0 == RULE_INT)) {
					alt4 = 1;
				} else if ((LA4_0 == 15)) {
					alt4 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 4, 0, input);

					throw nvae;
				}
				switch (alt4) {
				case 1:
				// InternalUmlCollaborationUse.g:314:6: this_INT_0= RULE_INT
				{
					this_INT_0 = (Token) match(input, RULE_INT, FOLLOW_2);

					current.merge(this_INT_0);


					newLeafNode(this_INT_0, grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0());


				}
					break;
				case 2:
				// InternalUmlCollaborationUse.g:323:2: kw= '*'
				{
					kw = (Token) match(input, 15, FOLLOW_2);

					current.merge(kw);
					newLeafNode(kw, grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1());


				}
					break;

				}


			}

			leaveRule();
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleUnlimitedLiteral"


	// $ANTLR start "ruleVisibilityKind"
	// InternalUmlCollaborationUse.g:336:1: ruleVisibilityKind returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) ) ;
	public final Enumerator ruleVisibilityKind() throws RecognitionException {
		Enumerator current = null;

		Token enumLiteral_0 = null;
		Token enumLiteral_1 = null;
		Token enumLiteral_2 = null;
		Token enumLiteral_3 = null;

		enterRule();
		try {
			// InternalUmlCollaborationUse.g:338:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) ) )
			// InternalUmlCollaborationUse.g:339:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) )
			{
				// InternalUmlCollaborationUse.g:339:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) )
				int alt5 = 4;
				switch (input.LA(1)) {
				case 16: {
					alt5 = 1;
				}
					break;
				case 17: {
					alt5 = 2;
				}
					break;
				case 18: {
					alt5 = 3;
				}
					break;
				case 19: {
					alt5 = 4;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("", 5, 0, input);

					throw nvae;
				}

				switch (alt5) {
				case 1:
				// InternalUmlCollaborationUse.g:339:2: (enumLiteral_0= '+' )
				{
					// InternalUmlCollaborationUse.g:339:2: (enumLiteral_0= '+' )
					// InternalUmlCollaborationUse.g:339:4: enumLiteral_0= '+'
					{
						enumLiteral_0 = (Token) match(input, 16, FOLLOW_2);

						current = grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_0, grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0());


					}


				}
					break;
				case 2:
				// InternalUmlCollaborationUse.g:345:6: (enumLiteral_1= '-' )
				{
					// InternalUmlCollaborationUse.g:345:6: (enumLiteral_1= '-' )
					// InternalUmlCollaborationUse.g:345:8: enumLiteral_1= '-'
					{
						enumLiteral_1 = (Token) match(input, 17, FOLLOW_2);

						current = grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_1, grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1());


					}


				}
					break;
				case 3:
				// InternalUmlCollaborationUse.g:351:6: (enumLiteral_2= '#' )
				{
					// InternalUmlCollaborationUse.g:351:6: (enumLiteral_2= '#' )
					// InternalUmlCollaborationUse.g:351:8: enumLiteral_2= '#'
					{
						enumLiteral_2 = (Token) match(input, 18, FOLLOW_2);

						current = grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_2, grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2());


					}


				}
					break;
				case 4:
				// InternalUmlCollaborationUse.g:357:6: (enumLiteral_3= '~' )
				{
					// InternalUmlCollaborationUse.g:357:6: (enumLiteral_3= '~' )
					// InternalUmlCollaborationUse.g:357:8: enumLiteral_3= '~'
					{
						enumLiteral_3 = (Token) match(input, 19, FOLLOW_2);

						current = grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_3, grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3());


					}


				}
					break;

				}


			}

			leaveRule();
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleVisibilityKind"

	// Delegated rules




	public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x0000000000001000L });
	public static final BitSet FOLLOW_5 = new BitSet(new long[] { 0x0000000000002010L });
	public static final BitSet FOLLOW_6 = new BitSet(new long[] { 0x0000000000004000L });
	public static final BitSet FOLLOW_7 = new BitSet(new long[] { 0x0000000000000012L });

}