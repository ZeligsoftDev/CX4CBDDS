package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.parser.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.services.UmlValueSpecificationGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;

@SuppressWarnings("all")
public class InternalUmlValueSpecificationParser extends AbstractInternalAntlrParser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_VALUE_SPECIFICATION_ID", "RULE_ID", "RULE_INT", "RULE_VALUE_SPECIFICATION_NEGATIVE_INT", "RULE_VALUE_SPECIFICATION_DOUBLE", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS",
			"RULE_ANY_OTHER", "'true'", "'false'", "'*'", "'null'", "'<Undefined>'", "'+'", "'-'", "'#'", "'~'"
	};
	public static final int RULE_VALUE_SPECIFICATION_NEGATIVE_INT = 7;
	public static final int RULE_STRING = 9;
	public static final int RULE_VALUE_SPECIFICATION_DOUBLE = 8;
	public static final int RULE_VALUE_SPECIFICATION_ID = 4;
	public static final int RULE_SL_COMMENT = 11;
	public static final int T__19 = 19;
	public static final int T__15 = 15;
	public static final int T__16 = 16;
	public static final int T__17 = 17;
	public static final int T__18 = 18;
	public static final int T__14 = 14;
	public static final int EOF = -1;
	public static final int RULE_ID = 5;
	public static final int RULE_WS = 12;
	public static final int RULE_ANY_OTHER = 13;
	public static final int RULE_INT = 6;
	public static final int T__22 = 22;
	public static final int RULE_ML_COMMENT = 10;
	public static final int T__20 = 20;
	public static final int T__21 = 21;

	// delegates
	// delegators


	public InternalUmlValueSpecificationParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalUmlValueSpecificationParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);

	}


	public String[] getTokenNames() {
		return InternalUmlValueSpecificationParser.tokenNames;
	}

	public String getGrammarFileName() {
		return "../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g";
	}



	private UmlValueSpecificationGrammarAccess grammarAccess;

	public InternalUmlValueSpecificationParser(TokenStream input, UmlValueSpecificationGrammarAccess grammarAccess) {
		this(input);
		this.grammarAccess = grammarAccess;
		registerRules(grammarAccess.getGrammar());
	}

	@Override
	protected String getFirstRuleName() {
		return "AbstractRule";
	}

	@Override
	protected UmlValueSpecificationGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}



	// $ANTLR start "entryRuleAbstractRule"
	// InternalUmlValueSpecification.g:67:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
	public final EObject entryRuleAbstractRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleAbstractRule = null;


		try {
			// InternalUmlValueSpecification.g:68:2: (iv_ruleAbstractRule= ruleAbstractRule EOF )
			// InternalUmlValueSpecification.g:69:2: iv_ruleAbstractRule= ruleAbstractRule EOF
			{
				newCompositeNode(grammarAccess.getAbstractRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleAbstractRule = ruleAbstractRule();

				state._fsp--;

				current = iv_ruleAbstractRule;
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
	// $ANTLR end "entryRuleAbstractRule"


	// $ANTLR start "ruleAbstractRule"
	// InternalUmlValueSpecification.g:76:1: ruleAbstractRule returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) )? ( ( (otherlv_2= RULE_ID ) ) | ( ( (lv_value_3_1=
	// ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (lv_undefined_4_0= ruleUndefinedRule ) ) ) ) ;
	public final EObject ruleAbstractRule() throws RecognitionException {
		EObject current = null;

		Token lv_name_1_0 = null;
		Token otherlv_2 = null;
		EObject lv_visibility_0_0 = null;

		EObject lv_value_3_1 = null;

		EObject lv_value_3_2 = null;

		EObject lv_value_3_3 = null;

		EObject lv_value_3_4 = null;

		EObject lv_value_3_5 = null;

		EObject lv_undefined_4_0 = null;


		enterRule();

		try {
			// InternalUmlValueSpecification.g:79:28: ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) )? ( ( (otherlv_2= RULE_ID ) ) | ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2=
			// ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (lv_undefined_4_0= ruleUndefinedRule ) ) ) ) )
			// InternalUmlValueSpecification.g:80:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) )? ( ( (otherlv_2= RULE_ID ) ) | ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2=
			// ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (lv_undefined_4_0= ruleUndefinedRule ) ) ) )
			{
				// InternalUmlValueSpecification.g:80:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) )? ( ( (otherlv_2= RULE_ID ) ) | ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2=
				// ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (lv_undefined_4_0= ruleUndefinedRule ) ) ) )
				// InternalUmlValueSpecification.g:80:2: ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) )? ( ( (otherlv_2= RULE_ID ) ) | ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2=
				// ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (lv_undefined_4_0= ruleUndefinedRule ) ) )
				{
					// InternalUmlValueSpecification.g:80:2: ( (lv_visibility_0_0= ruleVisibilityKind ) )?
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if (((LA1_0 >= 19 && LA1_0 <= 22))) {
						alt1 = 1;
					}
					switch (alt1) {
					case 1:
					// InternalUmlValueSpecification.g:81:1: (lv_visibility_0_0= ruleVisibilityKind )
					{
						// InternalUmlValueSpecification.g:81:1: (lv_visibility_0_0= ruleVisibilityKind )
						// InternalUmlValueSpecification.g:82:3: lv_visibility_0_0= ruleVisibilityKind
						{

							newCompositeNode(grammarAccess.getAbstractRuleAccess().getVisibilityVisibilityKindParserRuleCall_0_0());

							pushFollow(FOLLOW_3);
							lv_visibility_0_0 = ruleVisibilityKind();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
							}
							set(
									current,
									"visibility",
									lv_visibility_0_0,
									"org.eclipse.papyrus.uml.textedit.valuespecification.xtext.UmlValueSpecification.VisibilityKind");
							afterParserOrEnumRuleCall();


						}


					}
						break;

					}

					// InternalUmlValueSpecification.g:98:3: ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) )?
					int alt2 = 2;
					int LA2_0 = input.LA(1);

					if ((LA2_0 == RULE_VALUE_SPECIFICATION_ID)) {
						alt2 = 1;
					}
					switch (alt2) {
					case 1:
					// InternalUmlValueSpecification.g:99:1: (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID )
					{
						// InternalUmlValueSpecification.g:99:1: (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID )
						// InternalUmlValueSpecification.g:100:3: lv_name_1_0= RULE_VALUE_SPECIFICATION_ID
						{
							lv_name_1_0 = (Token) match(input, RULE_VALUE_SPECIFICATION_ID, FOLLOW_3);

							newLeafNode(lv_name_1_0, grammarAccess.getAbstractRuleAccess().getNameVALUE_SPECIFICATION_IDTerminalRuleCall_1_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getAbstractRuleRule());
							}
							setWithLastConsumed(
									current,
									"name",
									lv_name_1_0,
									"org.eclipse.papyrus.uml.textedit.valuespecification.xtext.UmlValueSpecification.VALUE_SPECIFICATION_ID");


						}


					}
						break;

					}

					// InternalUmlValueSpecification.g:116:3: ( ( (otherlv_2= RULE_ID ) ) | ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4=
					// ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (lv_undefined_4_0= ruleUndefinedRule ) ) )
					int alt4 = 3;
					switch (input.LA(1)) {
					case RULE_ID: {
						alt4 = 1;
					}
						break;
					case RULE_INT:
					case RULE_VALUE_SPECIFICATION_NEGATIVE_INT:
					case RULE_VALUE_SPECIFICATION_DOUBLE:
					case RULE_STRING:
					case 14:
					case 15:
					case 16:
					case 17: {
						alt4 = 2;
					}
						break;
					case 18: {
						alt4 = 3;
					}
						break;
					default:
						NoViableAltException nvae = new NoViableAltException("", 4, 0, input);

						throw nvae;
					}

					switch (alt4) {
					case 1:
					// InternalUmlValueSpecification.g:116:4: ( (otherlv_2= RULE_ID ) )
					{
						// InternalUmlValueSpecification.g:116:4: ( (otherlv_2= RULE_ID ) )
						// InternalUmlValueSpecification.g:117:1: (otherlv_2= RULE_ID )
						{
							// InternalUmlValueSpecification.g:117:1: (otherlv_2= RULE_ID )
							// InternalUmlValueSpecification.g:118:3: otherlv_2= RULE_ID
							{

								if (current == null) {
									current = createModelElement(grammarAccess.getAbstractRuleRule());
								}

								otherlv_2 = (Token) match(input, RULE_ID, FOLLOW_2);

								newLeafNode(otherlv_2, grammarAccess.getAbstractRuleAccess().getInstanceSpecificationInstanceSpecificationCrossReference_2_0_0());


							}


						}


					}
						break;
					case 2:
					// InternalUmlValueSpecification.g:130:6: ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5=
					// ruleLiteralStringRule ) ) )
					{
						// InternalUmlValueSpecification.g:130:6: ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5=
						// ruleLiteralStringRule ) ) )
						// InternalUmlValueSpecification.g:131:1: ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5=
						// ruleLiteralStringRule ) )
						{
							// InternalUmlValueSpecification.g:131:1: ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5=
							// ruleLiteralStringRule ) )
							// InternalUmlValueSpecification.g:132:1: (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5=
							// ruleLiteralStringRule )
							{
								// InternalUmlValueSpecification.g:132:1: (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5=
								// ruleLiteralStringRule )
								int alt3 = 5;
								switch (input.LA(1)) {
								case 14:
								case 15: {
									alt3 = 1;
								}
									break;
								case RULE_INT:
								case RULE_VALUE_SPECIFICATION_NEGATIVE_INT:
								case 16: {
									alt3 = 2;
								}
									break;
								case RULE_VALUE_SPECIFICATION_DOUBLE: {
									alt3 = 3;
								}
									break;
								case 17: {
									alt3 = 4;
								}
									break;
								case RULE_STRING: {
									alt3 = 5;
								}
									break;
								default:
									NoViableAltException nvae = new NoViableAltException("", 3, 0, input);

									throw nvae;
								}

								switch (alt3) {
								case 1:
								// InternalUmlValueSpecification.g:133:3: lv_value_3_1= ruleLiteralBooleanRule
								{

									newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralBooleanRuleParserRuleCall_2_1_0_0());

									pushFollow(FOLLOW_2);
									lv_value_3_1 = ruleLiteralBooleanRule();

									state._fsp--;


									if (current == null) {
										current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
									}
									set(
											current,
											"value",
											lv_value_3_1,
											"org.eclipse.papyrus.uml.textedit.valuespecification.xtext.UmlValueSpecification.LiteralBooleanRule");
									afterParserOrEnumRuleCall();


								}
									break;
								case 2:
								// InternalUmlValueSpecification.g:148:8: lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule
								{

									newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralIntegerOrUnlimitedNaturalRuleParserRuleCall_2_1_0_1());

									pushFollow(FOLLOW_2);
									lv_value_3_2 = ruleLiteralIntegerOrUnlimitedNaturalRule();

									state._fsp--;


									if (current == null) {
										current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
									}
									set(
											current,
											"value",
											lv_value_3_2,
											"org.eclipse.papyrus.uml.textedit.valuespecification.xtext.UmlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule");
									afterParserOrEnumRuleCall();


								}
									break;
								case 3:
								// InternalUmlValueSpecification.g:163:8: lv_value_3_3= ruleLiteralRealRule
								{

									newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralRealRuleParserRuleCall_2_1_0_2());

									pushFollow(FOLLOW_2);
									lv_value_3_3 = ruleLiteralRealRule();

									state._fsp--;


									if (current == null) {
										current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
									}
									set(
											current,
											"value",
											lv_value_3_3,
											"org.eclipse.papyrus.uml.textedit.valuespecification.xtext.UmlValueSpecification.LiteralRealRule");
									afterParserOrEnumRuleCall();


								}
									break;
								case 4:
								// InternalUmlValueSpecification.g:178:8: lv_value_3_4= ruleLiteralNullRule
								{

									newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralNullRuleParserRuleCall_2_1_0_3());

									pushFollow(FOLLOW_2);
									lv_value_3_4 = ruleLiteralNullRule();

									state._fsp--;


									if (current == null) {
										current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
									}
									set(
											current,
											"value",
											lv_value_3_4,
											"org.eclipse.papyrus.uml.textedit.valuespecification.xtext.UmlValueSpecification.LiteralNullRule");
									afterParserOrEnumRuleCall();


								}
									break;
								case 5:
								// InternalUmlValueSpecification.g:193:8: lv_value_3_5= ruleLiteralStringRule
								{

									newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralStringRuleParserRuleCall_2_1_0_4());

									pushFollow(FOLLOW_2);
									lv_value_3_5 = ruleLiteralStringRule();

									state._fsp--;


									if (current == null) {
										current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
									}
									set(
											current,
											"value",
											lv_value_3_5,
											"org.eclipse.papyrus.uml.textedit.valuespecification.xtext.UmlValueSpecification.LiteralStringRule");
									afterParserOrEnumRuleCall();


								}
									break;

								}


							}


						}


					}
						break;
					case 3:
					// InternalUmlValueSpecification.g:212:6: ( (lv_undefined_4_0= ruleUndefinedRule ) )
					{
						// InternalUmlValueSpecification.g:212:6: ( (lv_undefined_4_0= ruleUndefinedRule ) )
						// InternalUmlValueSpecification.g:213:1: (lv_undefined_4_0= ruleUndefinedRule )
						{
							// InternalUmlValueSpecification.g:213:1: (lv_undefined_4_0= ruleUndefinedRule )
							// InternalUmlValueSpecification.g:214:3: lv_undefined_4_0= ruleUndefinedRule
							{

								newCompositeNode(grammarAccess.getAbstractRuleAccess().getUndefinedUndefinedRuleParserRuleCall_2_2_0());

								pushFollow(FOLLOW_2);
								lv_undefined_4_0 = ruleUndefinedRule();

								state._fsp--;


								if (current == null) {
									current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
								}
								set(
										current,
										"undefined",
										lv_undefined_4_0,
										"org.eclipse.papyrus.uml.textedit.valuespecification.xtext.UmlValueSpecification.UndefinedRule");
								afterParserOrEnumRuleCall();


							}


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
	// $ANTLR end "ruleAbstractRule"


	// $ANTLR start "entryRuleLiteralBooleanRule"
	// InternalUmlValueSpecification.g:238:1: entryRuleLiteralBooleanRule returns [EObject current=null] : iv_ruleLiteralBooleanRule= ruleLiteralBooleanRule EOF ;
	public final EObject entryRuleLiteralBooleanRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleLiteralBooleanRule = null;


		try {
			// InternalUmlValueSpecification.g:239:2: (iv_ruleLiteralBooleanRule= ruleLiteralBooleanRule EOF )
			// InternalUmlValueSpecification.g:240:2: iv_ruleLiteralBooleanRule= ruleLiteralBooleanRule EOF
			{
				newCompositeNode(grammarAccess.getLiteralBooleanRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleLiteralBooleanRule = ruleLiteralBooleanRule();

				state._fsp--;

				current = iv_ruleLiteralBooleanRule;
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
	// $ANTLR end "entryRuleLiteralBooleanRule"


	// $ANTLR start "ruleLiteralBooleanRule"
	// InternalUmlValueSpecification.g:247:1: ruleLiteralBooleanRule returns [EObject current=null] : ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) ) ;
	public final EObject ruleLiteralBooleanRule() throws RecognitionException {
		EObject current = null;

		Token lv_value_0_1 = null;
		Token lv_value_0_2 = null;

		enterRule();

		try {
			// InternalUmlValueSpecification.g:250:28: ( ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) ) )
			// InternalUmlValueSpecification.g:251:1: ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) )
			{
				// InternalUmlValueSpecification.g:251:1: ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) )
				// InternalUmlValueSpecification.g:252:1: ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) )
				{
					// InternalUmlValueSpecification.g:252:1: ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) )
					// InternalUmlValueSpecification.g:253:1: (lv_value_0_1= 'true' | lv_value_0_2= 'false' )
					{
						// InternalUmlValueSpecification.g:253:1: (lv_value_0_1= 'true' | lv_value_0_2= 'false' )
						int alt5 = 2;
						int LA5_0 = input.LA(1);

						if ((LA5_0 == 14)) {
							alt5 = 1;
						} else if ((LA5_0 == 15)) {
							alt5 = 2;
						} else {
							NoViableAltException nvae = new NoViableAltException("", 5, 0, input);

							throw nvae;
						}
						switch (alt5) {
						case 1:
						// InternalUmlValueSpecification.g:254:3: lv_value_0_1= 'true'
						{
							lv_value_0_1 = (Token) match(input, 14, FOLLOW_2);

							newLeafNode(lv_value_0_1, grammarAccess.getLiteralBooleanRuleAccess().getValueTrueKeyword_0_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getLiteralBooleanRuleRule());
							}
							setWithLastConsumed(current, "value", lv_value_0_1, null);


						}
							break;
						case 2:
						// InternalUmlValueSpecification.g:266:8: lv_value_0_2= 'false'
						{
							lv_value_0_2 = (Token) match(input, 15, FOLLOW_2);

							newLeafNode(lv_value_0_2, grammarAccess.getLiteralBooleanRuleAccess().getValueFalseKeyword_0_1());


							if (current == null) {
								current = createModelElement(grammarAccess.getLiteralBooleanRuleRule());
							}
							setWithLastConsumed(current, "value", lv_value_0_2, null);


						}
							break;

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
	// $ANTLR end "ruleLiteralBooleanRule"


	// $ANTLR start "entryRuleLiteralIntegerOrUnlimitedNaturalRule"
	// InternalUmlValueSpecification.g:289:1: entryRuleLiteralIntegerOrUnlimitedNaturalRule returns [EObject current=null] : iv_ruleLiteralIntegerOrUnlimitedNaturalRule= ruleLiteralIntegerOrUnlimitedNaturalRule EOF ;
	public final EObject entryRuleLiteralIntegerOrUnlimitedNaturalRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleLiteralIntegerOrUnlimitedNaturalRule = null;


		try {
			// InternalUmlValueSpecification.g:290:2: (iv_ruleLiteralIntegerOrUnlimitedNaturalRule= ruleLiteralIntegerOrUnlimitedNaturalRule EOF )
			// InternalUmlValueSpecification.g:291:2: iv_ruleLiteralIntegerOrUnlimitedNaturalRule= ruleLiteralIntegerOrUnlimitedNaturalRule EOF
			{
				newCompositeNode(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleLiteralIntegerOrUnlimitedNaturalRule = ruleLiteralIntegerOrUnlimitedNaturalRule();

				state._fsp--;

				current = iv_ruleLiteralIntegerOrUnlimitedNaturalRule;
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
	// $ANTLR end "entryRuleLiteralIntegerOrUnlimitedNaturalRule"


	// $ANTLR start "ruleLiteralIntegerOrUnlimitedNaturalRule"
	// InternalUmlValueSpecification.g:298:1: ruleLiteralIntegerOrUnlimitedNaturalRule returns [EObject current=null] : ( ( ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) ) ) | ( (lv_unlimited_1_0= '*' ) ) ) ;
	public final EObject ruleLiteralIntegerOrUnlimitedNaturalRule() throws RecognitionException {
		EObject current = null;

		Token lv_value_0_1 = null;
		Token lv_value_0_2 = null;
		Token lv_unlimited_1_0 = null;

		enterRule();

		try {
			// InternalUmlValueSpecification.g:301:28: ( ( ( ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) ) ) | ( (lv_unlimited_1_0= '*' ) ) ) )
			// InternalUmlValueSpecification.g:302:1: ( ( ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) ) ) | ( (lv_unlimited_1_0= '*' ) ) )
			{
				// InternalUmlValueSpecification.g:302:1: ( ( ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) ) ) | ( (lv_unlimited_1_0= '*' ) ) )
				int alt7 = 2;
				int LA7_0 = input.LA(1);

				if (((LA7_0 >= RULE_INT && LA7_0 <= RULE_VALUE_SPECIFICATION_NEGATIVE_INT))) {
					alt7 = 1;
				} else if ((LA7_0 == 16)) {
					alt7 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 7, 0, input);

					throw nvae;
				}
				switch (alt7) {
				case 1:
				// InternalUmlValueSpecification.g:302:2: ( ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) ) )
				{
					// InternalUmlValueSpecification.g:302:2: ( ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) ) )
					// InternalUmlValueSpecification.g:303:1: ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) )
					{
						// InternalUmlValueSpecification.g:303:1: ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) )
						// InternalUmlValueSpecification.g:304:1: (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT )
						{
							// InternalUmlValueSpecification.g:304:1: (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT )
							int alt6 = 2;
							int LA6_0 = input.LA(1);

							if ((LA6_0 == RULE_INT)) {
								alt6 = 1;
							} else if ((LA6_0 == RULE_VALUE_SPECIFICATION_NEGATIVE_INT)) {
								alt6 = 2;
							} else {
								NoViableAltException nvae = new NoViableAltException("", 6, 0, input);

								throw nvae;
							}
							switch (alt6) {
							case 1:
							// InternalUmlValueSpecification.g:305:3: lv_value_0_1= RULE_INT
							{
								lv_value_0_1 = (Token) match(input, RULE_INT, FOLLOW_2);

								newLeafNode(lv_value_0_1, grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueINTTerminalRuleCall_0_0_0());


								if (current == null) {
									current = createModelElement(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleRule());
								}
								setWithLastConsumed(
										current,
										"value",
										lv_value_0_1,
										"org.eclipse.xtext.common.Terminals.INT");


							}
								break;
							case 2:
							// InternalUmlValueSpecification.g:320:8: lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT
							{
								lv_value_0_2 = (Token) match(input, RULE_VALUE_SPECIFICATION_NEGATIVE_INT, FOLLOW_2);

								newLeafNode(lv_value_0_2, grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueVALUE_SPECIFICATION_NEGATIVE_INTTerminalRuleCall_0_0_1());


								if (current == null) {
									current = createModelElement(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleRule());
								}
								setWithLastConsumed(
										current,
										"value",
										lv_value_0_2,
										"org.eclipse.papyrus.uml.textedit.valuespecification.xtext.UmlValueSpecification.VALUE_SPECIFICATION_NEGATIVE_INT");


							}
								break;

							}


						}


					}


				}
					break;
				case 2:
				// InternalUmlValueSpecification.g:339:6: ( (lv_unlimited_1_0= '*' ) )
				{
					// InternalUmlValueSpecification.g:339:6: ( (lv_unlimited_1_0= '*' ) )
					// InternalUmlValueSpecification.g:340:1: (lv_unlimited_1_0= '*' )
					{
						// InternalUmlValueSpecification.g:340:1: (lv_unlimited_1_0= '*' )
						// InternalUmlValueSpecification.g:341:3: lv_unlimited_1_0= '*'
						{
							lv_unlimited_1_0 = (Token) match(input, 16, FOLLOW_2);

							newLeafNode(lv_unlimited_1_0, grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getUnlimitedAsteriskKeyword_1_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleRule());
							}
							setWithLastConsumed(current, "unlimited", lv_unlimited_1_0, "*");


						}


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
	// $ANTLR end "ruleLiteralIntegerOrUnlimitedNaturalRule"


	// $ANTLR start "entryRuleLiteralRealRule"
	// InternalUmlValueSpecification.g:362:1: entryRuleLiteralRealRule returns [EObject current=null] : iv_ruleLiteralRealRule= ruleLiteralRealRule EOF ;
	public final EObject entryRuleLiteralRealRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleLiteralRealRule = null;


		try {
			// InternalUmlValueSpecification.g:363:2: (iv_ruleLiteralRealRule= ruleLiteralRealRule EOF )
			// InternalUmlValueSpecification.g:364:2: iv_ruleLiteralRealRule= ruleLiteralRealRule EOF
			{
				newCompositeNode(grammarAccess.getLiteralRealRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleLiteralRealRule = ruleLiteralRealRule();

				state._fsp--;

				current = iv_ruleLiteralRealRule;
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
	// $ANTLR end "entryRuleLiteralRealRule"


	// $ANTLR start "ruleLiteralRealRule"
	// InternalUmlValueSpecification.g:371:1: ruleLiteralRealRule returns [EObject current=null] : ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE ) ) ;
	public final EObject ruleLiteralRealRule() throws RecognitionException {
		EObject current = null;

		Token lv_value_0_0 = null;

		enterRule();

		try {
			// InternalUmlValueSpecification.g:374:28: ( ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE ) ) )
			// InternalUmlValueSpecification.g:375:1: ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE ) )
			{
				// InternalUmlValueSpecification.g:375:1: ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE ) )
				// InternalUmlValueSpecification.g:376:1: (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE )
				{
					// InternalUmlValueSpecification.g:376:1: (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE )
					// InternalUmlValueSpecification.g:377:3: lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE
					{
						lv_value_0_0 = (Token) match(input, RULE_VALUE_SPECIFICATION_DOUBLE, FOLLOW_2);

						newLeafNode(lv_value_0_0, grammarAccess.getLiteralRealRuleAccess().getValueVALUE_SPECIFICATION_DOUBLETerminalRuleCall_0());


						if (current == null) {
							current = createModelElement(grammarAccess.getLiteralRealRuleRule());
						}
						setWithLastConsumed(
								current,
								"value",
								lv_value_0_0,
								"org.eclipse.papyrus.uml.textedit.valuespecification.xtext.UmlValueSpecification.VALUE_SPECIFICATION_DOUBLE");


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
	// $ANTLR end "ruleLiteralRealRule"


	// $ANTLR start "entryRuleLiteralNullRule"
	// InternalUmlValueSpecification.g:401:1: entryRuleLiteralNullRule returns [EObject current=null] : iv_ruleLiteralNullRule= ruleLiteralNullRule EOF ;
	public final EObject entryRuleLiteralNullRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleLiteralNullRule = null;


		try {
			// InternalUmlValueSpecification.g:402:2: (iv_ruleLiteralNullRule= ruleLiteralNullRule EOF )
			// InternalUmlValueSpecification.g:403:2: iv_ruleLiteralNullRule= ruleLiteralNullRule EOF
			{
				newCompositeNode(grammarAccess.getLiteralNullRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleLiteralNullRule = ruleLiteralNullRule();

				state._fsp--;

				current = iv_ruleLiteralNullRule;
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
	// $ANTLR end "entryRuleLiteralNullRule"


	// $ANTLR start "ruleLiteralNullRule"
	// InternalUmlValueSpecification.g:410:1: ruleLiteralNullRule returns [EObject current=null] : ( (lv_value_0_0= 'null' ) ) ;
	public final EObject ruleLiteralNullRule() throws RecognitionException {
		EObject current = null;

		Token lv_value_0_0 = null;

		enterRule();

		try {
			// InternalUmlValueSpecification.g:413:28: ( ( (lv_value_0_0= 'null' ) ) )
			// InternalUmlValueSpecification.g:414:1: ( (lv_value_0_0= 'null' ) )
			{
				// InternalUmlValueSpecification.g:414:1: ( (lv_value_0_0= 'null' ) )
				// InternalUmlValueSpecification.g:415:1: (lv_value_0_0= 'null' )
				{
					// InternalUmlValueSpecification.g:415:1: (lv_value_0_0= 'null' )
					// InternalUmlValueSpecification.g:416:3: lv_value_0_0= 'null'
					{
						lv_value_0_0 = (Token) match(input, 17, FOLLOW_2);

						newLeafNode(lv_value_0_0, grammarAccess.getLiteralNullRuleAccess().getValueNullKeyword_0());


						if (current == null) {
							current = createModelElement(grammarAccess.getLiteralNullRuleRule());
						}
						setWithLastConsumed(current, "value", lv_value_0_0, "null");


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
	// $ANTLR end "ruleLiteralNullRule"


	// $ANTLR start "entryRuleLiteralStringRule"
	// InternalUmlValueSpecification.g:437:1: entryRuleLiteralStringRule returns [EObject current=null] : iv_ruleLiteralStringRule= ruleLiteralStringRule EOF ;
	public final EObject entryRuleLiteralStringRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleLiteralStringRule = null;


		try {
			// InternalUmlValueSpecification.g:438:2: (iv_ruleLiteralStringRule= ruleLiteralStringRule EOF )
			// InternalUmlValueSpecification.g:439:2: iv_ruleLiteralStringRule= ruleLiteralStringRule EOF
			{
				newCompositeNode(grammarAccess.getLiteralStringRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleLiteralStringRule = ruleLiteralStringRule();

				state._fsp--;

				current = iv_ruleLiteralStringRule;
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
	// $ANTLR end "entryRuleLiteralStringRule"


	// $ANTLR start "ruleLiteralStringRule"
	// InternalUmlValueSpecification.g:446:1: ruleLiteralStringRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
	public final EObject ruleLiteralStringRule() throws RecognitionException {
		EObject current = null;

		Token lv_value_0_0 = null;

		enterRule();

		try {
			// InternalUmlValueSpecification.g:449:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
			// InternalUmlValueSpecification.g:450:1: ( (lv_value_0_0= RULE_STRING ) )
			{
				// InternalUmlValueSpecification.g:450:1: ( (lv_value_0_0= RULE_STRING ) )
				// InternalUmlValueSpecification.g:451:1: (lv_value_0_0= RULE_STRING )
				{
					// InternalUmlValueSpecification.g:451:1: (lv_value_0_0= RULE_STRING )
					// InternalUmlValueSpecification.g:452:3: lv_value_0_0= RULE_STRING
					{
						lv_value_0_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

						newLeafNode(lv_value_0_0, grammarAccess.getLiteralStringRuleAccess().getValueSTRINGTerminalRuleCall_0());


						if (current == null) {
							current = createModelElement(grammarAccess.getLiteralStringRuleRule());
						}
						setWithLastConsumed(
								current,
								"value",
								lv_value_0_0,
								"org.eclipse.xtext.common.Terminals.STRING");


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
	// $ANTLR end "ruleLiteralStringRule"


	// $ANTLR start "entryRuleUndefinedRule"
	// InternalUmlValueSpecification.g:476:1: entryRuleUndefinedRule returns [EObject current=null] : iv_ruleUndefinedRule= ruleUndefinedRule EOF ;
	public final EObject entryRuleUndefinedRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleUndefinedRule = null;


		try {
			// InternalUmlValueSpecification.g:477:2: (iv_ruleUndefinedRule= ruleUndefinedRule EOF )
			// InternalUmlValueSpecification.g:478:2: iv_ruleUndefinedRule= ruleUndefinedRule EOF
			{
				newCompositeNode(grammarAccess.getUndefinedRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleUndefinedRule = ruleUndefinedRule();

				state._fsp--;

				current = iv_ruleUndefinedRule;
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
	// $ANTLR end "entryRuleUndefinedRule"


	// $ANTLR start "ruleUndefinedRule"
	// InternalUmlValueSpecification.g:485:1: ruleUndefinedRule returns [EObject current=null] : ( (lv_value_0_0= '<Undefined>' ) ) ;
	public final EObject ruleUndefinedRule() throws RecognitionException {
		EObject current = null;

		Token lv_value_0_0 = null;

		enterRule();

		try {
			// InternalUmlValueSpecification.g:488:28: ( ( (lv_value_0_0= '<Undefined>' ) ) )
			// InternalUmlValueSpecification.g:489:1: ( (lv_value_0_0= '<Undefined>' ) )
			{
				// InternalUmlValueSpecification.g:489:1: ( (lv_value_0_0= '<Undefined>' ) )
				// InternalUmlValueSpecification.g:490:1: (lv_value_0_0= '<Undefined>' )
				{
					// InternalUmlValueSpecification.g:490:1: (lv_value_0_0= '<Undefined>' )
					// InternalUmlValueSpecification.g:491:3: lv_value_0_0= '<Undefined>'
					{
						lv_value_0_0 = (Token) match(input, 18, FOLLOW_2);

						newLeafNode(lv_value_0_0, grammarAccess.getUndefinedRuleAccess().getValueUndefinedKeyword_0());


						if (current == null) {
							current = createModelElement(grammarAccess.getUndefinedRuleRule());
						}
						setWithLastConsumed(current, "value", lv_value_0_0, "<Undefined>");


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
	// $ANTLR end "ruleUndefinedRule"


	// $ANTLR start "entryRuleVisibilityKind"
	// InternalUmlValueSpecification.g:512:1: entryRuleVisibilityKind returns [EObject current=null] : iv_ruleVisibilityKind= ruleVisibilityKind EOF ;
	public final EObject entryRuleVisibilityKind() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleVisibilityKind = null;


		try {
			// InternalUmlValueSpecification.g:513:2: (iv_ruleVisibilityKind= ruleVisibilityKind EOF )
			// InternalUmlValueSpecification.g:514:2: iv_ruleVisibilityKind= ruleVisibilityKind EOF
			{
				newCompositeNode(grammarAccess.getVisibilityKindRule());
				pushFollow(FOLLOW_1);
				iv_ruleVisibilityKind = ruleVisibilityKind();

				state._fsp--;

				current = iv_ruleVisibilityKind;
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
	// $ANTLR end "entryRuleVisibilityKind"


	// $ANTLR start "ruleVisibilityKind"
	// InternalUmlValueSpecification.g:521:1: ruleVisibilityKind returns [EObject current=null] : ( ( (lv_public_0_0= '+' ) ) | ( (lv_private_1_0= '-' ) ) | ( (lv_protected_2_0= '#' ) ) | ( (lv_package_3_0= '~' ) ) ) ;
	public final EObject ruleVisibilityKind() throws RecognitionException {
		EObject current = null;

		Token lv_public_0_0 = null;
		Token lv_private_1_0 = null;
		Token lv_protected_2_0 = null;
		Token lv_package_3_0 = null;

		enterRule();

		try {
			// InternalUmlValueSpecification.g:524:28: ( ( ( (lv_public_0_0= '+' ) ) | ( (lv_private_1_0= '-' ) ) | ( (lv_protected_2_0= '#' ) ) | ( (lv_package_3_0= '~' ) ) ) )
			// InternalUmlValueSpecification.g:525:1: ( ( (lv_public_0_0= '+' ) ) | ( (lv_private_1_0= '-' ) ) | ( (lv_protected_2_0= '#' ) ) | ( (lv_package_3_0= '~' ) ) )
			{
				// InternalUmlValueSpecification.g:525:1: ( ( (lv_public_0_0= '+' ) ) | ( (lv_private_1_0= '-' ) ) | ( (lv_protected_2_0= '#' ) ) | ( (lv_package_3_0= '~' ) ) )
				int alt8 = 4;
				switch (input.LA(1)) {
				case 19: {
					alt8 = 1;
				}
					break;
				case 20: {
					alt8 = 2;
				}
					break;
				case 21: {
					alt8 = 3;
				}
					break;
				case 22: {
					alt8 = 4;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("", 8, 0, input);

					throw nvae;
				}

				switch (alt8) {
				case 1:
				// InternalUmlValueSpecification.g:525:2: ( (lv_public_0_0= '+' ) )
				{
					// InternalUmlValueSpecification.g:525:2: ( (lv_public_0_0= '+' ) )
					// InternalUmlValueSpecification.g:526:1: (lv_public_0_0= '+' )
					{
						// InternalUmlValueSpecification.g:526:1: (lv_public_0_0= '+' )
						// InternalUmlValueSpecification.g:527:3: lv_public_0_0= '+'
						{
							lv_public_0_0 = (Token) match(input, 19, FOLLOW_2);

							newLeafNode(lv_public_0_0, grammarAccess.getVisibilityKindAccess().getPublicPlusSignKeyword_0_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getVisibilityKindRule());
							}
							setWithLastConsumed(current, "public", lv_public_0_0, "+");


						}


					}


				}
					break;
				case 2:
				// InternalUmlValueSpecification.g:541:6: ( (lv_private_1_0= '-' ) )
				{
					// InternalUmlValueSpecification.g:541:6: ( (lv_private_1_0= '-' ) )
					// InternalUmlValueSpecification.g:542:1: (lv_private_1_0= '-' )
					{
						// InternalUmlValueSpecification.g:542:1: (lv_private_1_0= '-' )
						// InternalUmlValueSpecification.g:543:3: lv_private_1_0= '-'
						{
							lv_private_1_0 = (Token) match(input, 20, FOLLOW_2);

							newLeafNode(lv_private_1_0, grammarAccess.getVisibilityKindAccess().getPrivateHyphenMinusKeyword_1_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getVisibilityKindRule());
							}
							setWithLastConsumed(current, "private", lv_private_1_0, "-");


						}


					}


				}
					break;
				case 3:
				// InternalUmlValueSpecification.g:557:6: ( (lv_protected_2_0= '#' ) )
				{
					// InternalUmlValueSpecification.g:557:6: ( (lv_protected_2_0= '#' ) )
					// InternalUmlValueSpecification.g:558:1: (lv_protected_2_0= '#' )
					{
						// InternalUmlValueSpecification.g:558:1: (lv_protected_2_0= '#' )
						// InternalUmlValueSpecification.g:559:3: lv_protected_2_0= '#'
						{
							lv_protected_2_0 = (Token) match(input, 21, FOLLOW_2);

							newLeafNode(lv_protected_2_0, grammarAccess.getVisibilityKindAccess().getProtectedNumberSignKeyword_2_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getVisibilityKindRule());
							}
							setWithLastConsumed(current, "protected", lv_protected_2_0, "#");


						}


					}


				}
					break;
				case 4:
				// InternalUmlValueSpecification.g:573:6: ( (lv_package_3_0= '~' ) )
				{
					// InternalUmlValueSpecification.g:573:6: ( (lv_package_3_0= '~' ) )
					// InternalUmlValueSpecification.g:574:1: (lv_package_3_0= '~' )
					{
						// InternalUmlValueSpecification.g:574:1: (lv_package_3_0= '~' )
						// InternalUmlValueSpecification.g:575:3: lv_package_3_0= '~'
						{
							lv_package_3_0 = (Token) match(input, 22, FOLLOW_2);

							newLeafNode(lv_package_3_0, grammarAccess.getVisibilityKindAccess().getPackageTildeKeyword_3_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getVisibilityKindRule());
							}
							setWithLastConsumed(current, "package", lv_package_3_0, "~");


						}


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
	public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x000000000007C3F0L });

}