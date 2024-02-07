package org.eclipse.papyrus.uml.textedit.port.xtext.parser.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.port.xtext.services.UmlPortGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;

@SuppressWarnings("all")
public class InternalUmlPortParser extends AbstractInternalAntlrParser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INTEGER_VALUE", "RULE_WS", "RULE_ANY_OTHER", "'/'", "':'", "'~'", "'<Undefined>'", "'::'", "'['", "'..'", "']'", "'*'", "'{'",
			"','", "'}'", "'redefines'", "'subsets'", "'='", "'.'", "'null'", "'none'", "'+'", "'-'", "'#'", "'readOnly'", "'union'", "'ordered'", "'unique'", "'true'", "'false'"
	};
	public static final int RULE_STRING = 6;
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
	public static final int RULE_ID = 4;
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


	public InternalUmlPortParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalUmlPortParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);

	}


	public String[] getTokenNames() {
		return InternalUmlPortParser.tokenNames;
	}

	public String getGrammarFileName() {
		return "../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g";
	}



	private UmlPortGrammarAccess grammarAccess;

	public InternalUmlPortParser(TokenStream input, UmlPortGrammarAccess grammarAccess) {
		this(input);
		this.grammarAccess = grammarAccess;
		registerRules(grammarAccess.getGrammar());
	}

	@Override
	protected String getFirstRuleName() {
		return "PortRule";
	}

	@Override
	protected UmlPortGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}



	// $ANTLR start "entryRulePortRule"
	// InternalUmlPort.g:68:1: entryRulePortRule returns [EObject current=null] : iv_rulePortRule= rulePortRule EOF ;
	public final EObject entryRulePortRule() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePortRule = null;


		try {
			// InternalUmlPort.g:69:2: (iv_rulePortRule= rulePortRule EOF )
			// InternalUmlPort.g:70:2: iv_rulePortRule= rulePortRule EOF
			{
				newCompositeNode(grammarAccess.getPortRuleRule());
				pushFollow(FOLLOW_1);
				iv_rulePortRule = rulePortRule();

				state._fsp--;

				current = iv_rulePortRule;
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
	// $ANTLR end "entryRulePortRule"


	// $ANTLR start "rulePortRule"
	// InternalUmlPort.g:77:1: rulePortRule returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityRule ) )? ( (lv_derived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_conjugated_4_0= '~' ) )? ( ( (lv_type_5_0= ruleTypeRule )
	// ) | ( (lv_typeUndefined_6_0= '<Undefined>' ) ) ) )? ( (lv_multiplicity_7_0= ruleMultiplicityRule ) )? ( (lv_modifiers_8_0= ruleModifiersRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )? ) ;
	public final EObject rulePortRule() throws RecognitionException {
		EObject current = null;

		Token lv_derived_1_0 = null;
		Token lv_name_2_0 = null;
		Token otherlv_3 = null;
		Token lv_conjugated_4_0 = null;
		Token lv_typeUndefined_6_0 = null;
		EObject lv_visibility_0_0 = null;

		EObject lv_type_5_0 = null;

		EObject lv_multiplicity_7_0 = null;

		EObject lv_modifiers_8_0 = null;

		EObject lv_default_9_0 = null;


		enterRule();

		try {
			// InternalUmlPort.g:80:28: ( ( ( (lv_visibility_0_0= ruleVisibilityRule ) )? ( (lv_derived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_conjugated_4_0= '~' ) )? ( ( (lv_type_5_0= ruleTypeRule ) ) | ( (lv_typeUndefined_6_0=
			// '<Undefined>' ) ) ) )? ( (lv_multiplicity_7_0= ruleMultiplicityRule ) )? ( (lv_modifiers_8_0= ruleModifiersRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )? ) )
			// InternalUmlPort.g:81:1: ( ( (lv_visibility_0_0= ruleVisibilityRule ) )? ( (lv_derived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_conjugated_4_0= '~' ) )? ( ( (lv_type_5_0= ruleTypeRule ) ) | ( (lv_typeUndefined_6_0=
			// '<Undefined>' ) ) ) )? ( (lv_multiplicity_7_0= ruleMultiplicityRule ) )? ( (lv_modifiers_8_0= ruleModifiersRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )? )
			{
				// InternalUmlPort.g:81:1: ( ( (lv_visibility_0_0= ruleVisibilityRule ) )? ( (lv_derived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_conjugated_4_0= '~' ) )? ( ( (lv_type_5_0= ruleTypeRule ) ) | ( (lv_typeUndefined_6_0=
				// '<Undefined>' ) ) ) )? ( (lv_multiplicity_7_0= ruleMultiplicityRule ) )? ( (lv_modifiers_8_0= ruleModifiersRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )? )
				// InternalUmlPort.g:81:2: ( (lv_visibility_0_0= ruleVisibilityRule ) )? ( (lv_derived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_conjugated_4_0= '~' ) )? ( ( (lv_type_5_0= ruleTypeRule ) ) | ( (lv_typeUndefined_6_0=
				// '<Undefined>' ) ) ) )? ( (lv_multiplicity_7_0= ruleMultiplicityRule ) )? ( (lv_modifiers_8_0= ruleModifiersRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )?
				{
					// InternalUmlPort.g:81:2: ( (lv_visibility_0_0= ruleVisibilityRule ) )?
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if ((LA1_0 == 14 || (LA1_0 >= 30 && LA1_0 <= 32))) {
						alt1 = 1;
					}
					switch (alt1) {
					case 1:
					// InternalUmlPort.g:82:1: (lv_visibility_0_0= ruleVisibilityRule )
					{
						// InternalUmlPort.g:82:1: (lv_visibility_0_0= ruleVisibilityRule )
						// InternalUmlPort.g:83:3: lv_visibility_0_0= ruleVisibilityRule
						{

							newCompositeNode(grammarAccess.getPortRuleAccess().getVisibilityVisibilityRuleParserRuleCall_0_0());

							pushFollow(FOLLOW_3);
							lv_visibility_0_0 = ruleVisibilityRule();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getPortRuleRule());
							}
							set(
									current,
									"visibility",
									lv_visibility_0_0,
									"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.VisibilityRule");
							afterParserOrEnumRuleCall();


						}


					}
						break;

					}

					// InternalUmlPort.g:99:3: ( (lv_derived_1_0= '/' ) )?
					int alt2 = 2;
					int LA2_0 = input.LA(1);

					if ((LA2_0 == 12)) {
						alt2 = 1;
					}
					switch (alt2) {
					case 1:
					// InternalUmlPort.g:100:1: (lv_derived_1_0= '/' )
					{
						// InternalUmlPort.g:100:1: (lv_derived_1_0= '/' )
						// InternalUmlPort.g:101:3: lv_derived_1_0= '/'
						{
							lv_derived_1_0 = (Token) match(input, 12, FOLLOW_4);

							newLeafNode(lv_derived_1_0, grammarAccess.getPortRuleAccess().getDerivedSolidusKeyword_1_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getPortRuleRule());
							}
							setWithLastConsumed(current, "derived", true, "/");


						}


					}
						break;

					}

					// InternalUmlPort.g:114:3: ( (lv_name_2_0= RULE_ID ) )
					// InternalUmlPort.g:115:1: (lv_name_2_0= RULE_ID )
					{
						// InternalUmlPort.g:115:1: (lv_name_2_0= RULE_ID )
						// InternalUmlPort.g:116:3: lv_name_2_0= RULE_ID
						{
							lv_name_2_0 = (Token) match(input, RULE_ID, FOLLOW_5);

							newLeafNode(lv_name_2_0, grammarAccess.getPortRuleAccess().getNameIDTerminalRuleCall_2_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getPortRuleRule());
							}
							setWithLastConsumed(
									current,
									"name",
									lv_name_2_0,
									"org.eclipse.papyrus.uml.alf.Common.ID");


						}


					}

					// InternalUmlPort.g:132:2: (otherlv_3= ':' ( (lv_conjugated_4_0= '~' ) )? ( ( (lv_type_5_0= ruleTypeRule ) ) | ( (lv_typeUndefined_6_0= '<Undefined>' ) ) ) )?
					int alt5 = 2;
					int LA5_0 = input.LA(1);

					if ((LA5_0 == 13)) {
						alt5 = 1;
					}
					switch (alt5) {
					case 1:
					// InternalUmlPort.g:132:4: otherlv_3= ':' ( (lv_conjugated_4_0= '~' ) )? ( ( (lv_type_5_0= ruleTypeRule ) ) | ( (lv_typeUndefined_6_0= '<Undefined>' ) ) )
					{
						otherlv_3 = (Token) match(input, 13, FOLLOW_6);

						newLeafNode(otherlv_3, grammarAccess.getPortRuleAccess().getColonKeyword_3_0());

						// InternalUmlPort.g:136:1: ( (lv_conjugated_4_0= '~' ) )?
						int alt3 = 2;
						int LA3_0 = input.LA(1);

						if ((LA3_0 == 14)) {
							alt3 = 1;
						}
						switch (alt3) {
						case 1:
						// InternalUmlPort.g:137:1: (lv_conjugated_4_0= '~' )
						{
							// InternalUmlPort.g:137:1: (lv_conjugated_4_0= '~' )
							// InternalUmlPort.g:138:3: lv_conjugated_4_0= '~'
							{
								lv_conjugated_4_0 = (Token) match(input, 14, FOLLOW_7);

								newLeafNode(lv_conjugated_4_0, grammarAccess.getPortRuleAccess().getConjugatedTildeKeyword_3_1_0());


								if (current == null) {
									current = createModelElement(grammarAccess.getPortRuleRule());
								}
								setWithLastConsumed(current, "conjugated", true, "~");


							}


						}
							break;

						}

						// InternalUmlPort.g:151:3: ( ( (lv_type_5_0= ruleTypeRule ) ) | ( (lv_typeUndefined_6_0= '<Undefined>' ) ) )
						int alt4 = 2;
						int LA4_0 = input.LA(1);

						if ((LA4_0 == RULE_ID)) {
							alt4 = 1;
						} else if ((LA4_0 == 15)) {
							alt4 = 2;
						} else {
							NoViableAltException nvae = new NoViableAltException("", 4, 0, input);

							throw nvae;
						}
						switch (alt4) {
						case 1:
						// InternalUmlPort.g:151:4: ( (lv_type_5_0= ruleTypeRule ) )
						{
							// InternalUmlPort.g:151:4: ( (lv_type_5_0= ruleTypeRule ) )
							// InternalUmlPort.g:152:1: (lv_type_5_0= ruleTypeRule )
							{
								// InternalUmlPort.g:152:1: (lv_type_5_0= ruleTypeRule )
								// InternalUmlPort.g:153:3: lv_type_5_0= ruleTypeRule
								{

									newCompositeNode(grammarAccess.getPortRuleAccess().getTypeTypeRuleParserRuleCall_3_2_0_0());

									pushFollow(FOLLOW_8);
									lv_type_5_0 = ruleTypeRule();

									state._fsp--;


									if (current == null) {
										current = createModelElementForParent(grammarAccess.getPortRuleRule());
									}
									set(
											current,
											"type",
											lv_type_5_0,
											"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.TypeRule");
									afterParserOrEnumRuleCall();


								}


							}


						}
							break;
						case 2:
						// InternalUmlPort.g:170:6: ( (lv_typeUndefined_6_0= '<Undefined>' ) )
						{
							// InternalUmlPort.g:170:6: ( (lv_typeUndefined_6_0= '<Undefined>' ) )
							// InternalUmlPort.g:171:1: (lv_typeUndefined_6_0= '<Undefined>' )
							{
								// InternalUmlPort.g:171:1: (lv_typeUndefined_6_0= '<Undefined>' )
								// InternalUmlPort.g:172:3: lv_typeUndefined_6_0= '<Undefined>'
								{
									lv_typeUndefined_6_0 = (Token) match(input, 15, FOLLOW_8);

									newLeafNode(lv_typeUndefined_6_0, grammarAccess.getPortRuleAccess().getTypeUndefinedUndefinedKeyword_3_2_1_0());


									if (current == null) {
										current = createModelElement(grammarAccess.getPortRuleRule());
									}
									setWithLastConsumed(current, "typeUndefined", true, "<Undefined>");


								}


							}


						}
							break;

						}


					}
						break;

					}

					// InternalUmlPort.g:185:5: ( (lv_multiplicity_7_0= ruleMultiplicityRule ) )?
					int alt6 = 2;
					int LA6_0 = input.LA(1);

					if ((LA6_0 == 17)) {
						alt6 = 1;
					}
					switch (alt6) {
					case 1:
					// InternalUmlPort.g:186:1: (lv_multiplicity_7_0= ruleMultiplicityRule )
					{
						// InternalUmlPort.g:186:1: (lv_multiplicity_7_0= ruleMultiplicityRule )
						// InternalUmlPort.g:187:3: lv_multiplicity_7_0= ruleMultiplicityRule
						{

							newCompositeNode(grammarAccess.getPortRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_4_0());

							pushFollow(FOLLOW_9);
							lv_multiplicity_7_0 = ruleMultiplicityRule();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getPortRuleRule());
							}
							set(
									current,
									"multiplicity",
									lv_multiplicity_7_0,
									"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.MultiplicityRule");
							afterParserOrEnumRuleCall();


						}


					}
						break;

					}

					// InternalUmlPort.g:203:3: ( (lv_modifiers_8_0= ruleModifiersRule ) )?
					int alt7 = 2;
					int LA7_0 = input.LA(1);

					if ((LA7_0 == 21)) {
						alt7 = 1;
					}
					switch (alt7) {
					case 1:
					// InternalUmlPort.g:204:1: (lv_modifiers_8_0= ruleModifiersRule )
					{
						// InternalUmlPort.g:204:1: (lv_modifiers_8_0= ruleModifiersRule )
						// InternalUmlPort.g:205:3: lv_modifiers_8_0= ruleModifiersRule
						{

							newCompositeNode(grammarAccess.getPortRuleAccess().getModifiersModifiersRuleParserRuleCall_5_0());

							pushFollow(FOLLOW_10);
							lv_modifiers_8_0 = ruleModifiersRule();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getPortRuleRule());
							}
							set(
									current,
									"modifiers",
									lv_modifiers_8_0,
									"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.ModifiersRule");
							afterParserOrEnumRuleCall();


						}


					}
						break;

					}

					// InternalUmlPort.g:221:3: ( (lv_default_9_0= ruleDefaultValueRule ) )?
					int alt8 = 2;
					int LA8_0 = input.LA(1);

					if ((LA8_0 == 26)) {
						alt8 = 1;
					}
					switch (alt8) {
					case 1:
					// InternalUmlPort.g:222:1: (lv_default_9_0= ruleDefaultValueRule )
					{
						// InternalUmlPort.g:222:1: (lv_default_9_0= ruleDefaultValueRule )
						// InternalUmlPort.g:223:3: lv_default_9_0= ruleDefaultValueRule
						{

							newCompositeNode(grammarAccess.getPortRuleAccess().getDefaultDefaultValueRuleParserRuleCall_6_0());

							pushFollow(FOLLOW_2);
							lv_default_9_0 = ruleDefaultValueRule();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getPortRuleRule());
							}
							set(
									current,
									"default",
									lv_default_9_0,
									"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.DefaultValueRule");
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
	// $ANTLR end "rulePortRule"


	// $ANTLR start "entryRuleVisibilityRule"
	// InternalUmlPort.g:247:1: entryRuleVisibilityRule returns [EObject current=null] : iv_ruleVisibilityRule= ruleVisibilityRule EOF ;
	public final EObject entryRuleVisibilityRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleVisibilityRule = null;


		try {
			// InternalUmlPort.g:248:2: (iv_ruleVisibilityRule= ruleVisibilityRule EOF )
			// InternalUmlPort.g:249:2: iv_ruleVisibilityRule= ruleVisibilityRule EOF
			{
				newCompositeNode(grammarAccess.getVisibilityRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleVisibilityRule = ruleVisibilityRule();

				state._fsp--;

				current = iv_ruleVisibilityRule;
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
	// $ANTLR end "entryRuleVisibilityRule"


	// $ANTLR start "ruleVisibilityRule"
	// InternalUmlPort.g:256:1: ruleVisibilityRule returns [EObject current=null] : ( (lv_visibility_0_0= ruleVisibilityKind ) ) ;
	public final EObject ruleVisibilityRule() throws RecognitionException {
		EObject current = null;

		Enumerator lv_visibility_0_0 = null;


		enterRule();

		try {
			// InternalUmlPort.g:259:28: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) )
			// InternalUmlPort.g:260:1: ( (lv_visibility_0_0= ruleVisibilityKind ) )
			{
				// InternalUmlPort.g:260:1: ( (lv_visibility_0_0= ruleVisibilityKind ) )
				// InternalUmlPort.g:261:1: (lv_visibility_0_0= ruleVisibilityKind )
				{
					// InternalUmlPort.g:261:1: (lv_visibility_0_0= ruleVisibilityKind )
					// InternalUmlPort.g:262:3: lv_visibility_0_0= ruleVisibilityKind
					{

						newCompositeNode(grammarAccess.getVisibilityRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0());

						pushFollow(FOLLOW_2);
						lv_visibility_0_0 = ruleVisibilityKind();

						state._fsp--;


						if (current == null) {
							current = createModelElementForParent(grammarAccess.getVisibilityRuleRule());
						}
						set(
								current,
								"visibility",
								lv_visibility_0_0,
								"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.VisibilityKind");
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
	// $ANTLR end "ruleVisibilityRule"


	// $ANTLR start "entryRuleTypeRule"
	// InternalUmlPort.g:286:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
	public final EObject entryRuleTypeRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTypeRule = null;


		try {
			// InternalUmlPort.g:287:2: (iv_ruleTypeRule= ruleTypeRule EOF )
			// InternalUmlPort.g:288:2: iv_ruleTypeRule= ruleTypeRule EOF
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
	// InternalUmlPort.g:295:1: ruleTypeRule returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
	public final EObject ruleTypeRule() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		EObject lv_path_0_0 = null;


		enterRule();

		try {
			// InternalUmlPort.g:298:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
			// InternalUmlPort.g:299:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
			{
				// InternalUmlPort.g:299:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
				// InternalUmlPort.g:299:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
				{
					// InternalUmlPort.g:299:2: ( (lv_path_0_0= ruleQualifiedName ) )?
					int alt9 = 2;
					int LA9_0 = input.LA(1);

					if ((LA9_0 == RULE_ID)) {
						int LA9_1 = input.LA(2);

						if ((LA9_1 == 16)) {
							alt9 = 1;
						}
					}
					switch (alt9) {
					case 1:
					// InternalUmlPort.g:300:1: (lv_path_0_0= ruleQualifiedName )
					{
						// InternalUmlPort.g:300:1: (lv_path_0_0= ruleQualifiedName )
						// InternalUmlPort.g:301:3: lv_path_0_0= ruleQualifiedName
						{

							newCompositeNode(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0());

							pushFollow(FOLLOW_4);
							lv_path_0_0 = ruleQualifiedName();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getTypeRuleRule());
							}
							set(
									current,
									"path",
									lv_path_0_0,
									"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.QualifiedName");
							afterParserOrEnumRuleCall();


						}


					}
						break;

					}

					// InternalUmlPort.g:317:3: ( (otherlv_1= RULE_ID ) )
					// InternalUmlPort.g:318:1: (otherlv_1= RULE_ID )
					{
						// InternalUmlPort.g:318:1: (otherlv_1= RULE_ID )
						// InternalUmlPort.g:319:3: otherlv_1= RULE_ID
						{

							if (current == null) {
								current = createModelElement(grammarAccess.getTypeRuleRule());
							}

							otherlv_1 = (Token) match(input, RULE_ID, FOLLOW_2);

							newLeafNode(otherlv_1, grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0());


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
	// InternalUmlPort.g:338:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
	public final EObject entryRuleQualifiedName() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleQualifiedName = null;


		try {
			// InternalUmlPort.g:339:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
			// InternalUmlPort.g:340:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
	// InternalUmlPort.g:347:1: ruleQualifiedName returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
	public final EObject ruleQualifiedName() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_1 = null;
		EObject lv_remaining_2_0 = null;


		enterRule();

		try {
			// InternalUmlPort.g:350:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
			// InternalUmlPort.g:351:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
			{
				// InternalUmlPort.g:351:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
				// InternalUmlPort.g:351:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
				{
					// InternalUmlPort.g:351:2: ( (otherlv_0= RULE_ID ) )
					// InternalUmlPort.g:352:1: (otherlv_0= RULE_ID )
					{
						// InternalUmlPort.g:352:1: (otherlv_0= RULE_ID )
						// InternalUmlPort.g:353:3: otherlv_0= RULE_ID
						{

							if (current == null) {
								current = createModelElement(grammarAccess.getQualifiedNameRule());
							}

							otherlv_0 = (Token) match(input, RULE_ID, FOLLOW_11);

							newLeafNode(otherlv_0, grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0());


						}


					}

					otherlv_1 = (Token) match(input, 16, FOLLOW_12);

					newLeafNode(otherlv_1, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());

					// InternalUmlPort.g:368:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
					int alt10 = 2;
					int LA10_0 = input.LA(1);

					if ((LA10_0 == RULE_ID)) {
						int LA10_1 = input.LA(2);

						if ((LA10_1 == 16)) {
							alt10 = 1;
						}
					}
					switch (alt10) {
					case 1:
					// InternalUmlPort.g:369:1: (lv_remaining_2_0= ruleQualifiedName )
					{
						// InternalUmlPort.g:369:1: (lv_remaining_2_0= ruleQualifiedName )
						// InternalUmlPort.g:370:3: lv_remaining_2_0= ruleQualifiedName
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
									"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.QualifiedName");
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


	// $ANTLR start "entryRuleMultiplicityRule"
	// InternalUmlPort.g:394:1: entryRuleMultiplicityRule returns [EObject current=null] : iv_ruleMultiplicityRule= ruleMultiplicityRule EOF ;
	public final EObject entryRuleMultiplicityRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleMultiplicityRule = null;


		try {
			// InternalUmlPort.g:395:2: (iv_ruleMultiplicityRule= ruleMultiplicityRule EOF )
			// InternalUmlPort.g:396:2: iv_ruleMultiplicityRule= ruleMultiplicityRule EOF
			{
				newCompositeNode(grammarAccess.getMultiplicityRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleMultiplicityRule = ruleMultiplicityRule();

				state._fsp--;

				current = iv_ruleMultiplicityRule;
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
	// $ANTLR end "entryRuleMultiplicityRule"


	// $ANTLR start "ruleMultiplicityRule"
	// InternalUmlPort.g:403:1: ruleMultiplicityRule returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_bounds_1_0= ruleBoundSpecification ) ) otherlv_2= '..' )? ( (lv_bounds_3_0= ruleBoundSpecification ) ) otherlv_4= ']' ) ;
	public final EObject ruleMultiplicityRule() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_2 = null;
		Token otherlv_4 = null;
		EObject lv_bounds_1_0 = null;

		EObject lv_bounds_3_0 = null;


		enterRule();

		try {
			// InternalUmlPort.g:406:28: ( (otherlv_0= '[' ( ( (lv_bounds_1_0= ruleBoundSpecification ) ) otherlv_2= '..' )? ( (lv_bounds_3_0= ruleBoundSpecification ) ) otherlv_4= ']' ) )
			// InternalUmlPort.g:407:1: (otherlv_0= '[' ( ( (lv_bounds_1_0= ruleBoundSpecification ) ) otherlv_2= '..' )? ( (lv_bounds_3_0= ruleBoundSpecification ) ) otherlv_4= ']' )
			{
				// InternalUmlPort.g:407:1: (otherlv_0= '[' ( ( (lv_bounds_1_0= ruleBoundSpecification ) ) otherlv_2= '..' )? ( (lv_bounds_3_0= ruleBoundSpecification ) ) otherlv_4= ']' )
				// InternalUmlPort.g:407:3: otherlv_0= '[' ( ( (lv_bounds_1_0= ruleBoundSpecification ) ) otherlv_2= '..' )? ( (lv_bounds_3_0= ruleBoundSpecification ) ) otherlv_4= ']'
				{
					otherlv_0 = (Token) match(input, 17, FOLLOW_13);

					newLeafNode(otherlv_0, grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0());

					// InternalUmlPort.g:411:1: ( ( (lv_bounds_1_0= ruleBoundSpecification ) ) otherlv_2= '..' )?
					int alt11 = 2;
					switch (input.LA(1)) {
					case RULE_INT: {
						int LA11_1 = input.LA(2);

						if ((LA11_1 == 18)) {
							alt11 = 1;
						}
					}
						break;
					case 20: {
						int LA11_2 = input.LA(2);

						if ((LA11_2 == 18)) {
							alt11 = 1;
						}
					}
						break;
					case RULE_STRING: {
						int LA11_3 = input.LA(2);

						if ((LA11_3 == 18)) {
							alt11 = 1;
						}
					}
						break;
					}

					switch (alt11) {
					case 1:
					// InternalUmlPort.g:411:2: ( (lv_bounds_1_0= ruleBoundSpecification ) ) otherlv_2= '..'
					{
						// InternalUmlPort.g:411:2: ( (lv_bounds_1_0= ruleBoundSpecification ) )
						// InternalUmlPort.g:412:1: (lv_bounds_1_0= ruleBoundSpecification )
						{
							// InternalUmlPort.g:412:1: (lv_bounds_1_0= ruleBoundSpecification )
							// InternalUmlPort.g:413:3: lv_bounds_1_0= ruleBoundSpecification
							{

								newCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0_0());

								pushFollow(FOLLOW_14);
								lv_bounds_1_0 = ruleBoundSpecification();

								state._fsp--;


								if (current == null) {
									current = createModelElementForParent(grammarAccess.getMultiplicityRuleRule());
								}
								add(
										current,
										"bounds",
										lv_bounds_1_0,
										"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.BoundSpecification");
								afterParserOrEnumRuleCall();


							}


						}

						otherlv_2 = (Token) match(input, 18, FOLLOW_13);

						newLeafNode(otherlv_2, grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_1_1());


					}
						break;

					}

					// InternalUmlPort.g:433:3: ( (lv_bounds_3_0= ruleBoundSpecification ) )
					// InternalUmlPort.g:434:1: (lv_bounds_3_0= ruleBoundSpecification )
					{
						// InternalUmlPort.g:434:1: (lv_bounds_3_0= ruleBoundSpecification )
						// InternalUmlPort.g:435:3: lv_bounds_3_0= ruleBoundSpecification
						{

							newCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_0());

							pushFollow(FOLLOW_15);
							lv_bounds_3_0 = ruleBoundSpecification();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getMultiplicityRuleRule());
							}
							add(
									current,
									"bounds",
									lv_bounds_3_0,
									"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.BoundSpecification");
							afterParserOrEnumRuleCall();


						}


					}

					otherlv_4 = (Token) match(input, 19, FOLLOW_2);

					newLeafNode(otherlv_4, grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3());


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
	// $ANTLR end "ruleMultiplicityRule"


	// $ANTLR start "entryRuleBoundSpecification"
	// InternalUmlPort.g:463:1: entryRuleBoundSpecification returns [EObject current=null] : iv_ruleBoundSpecification= ruleBoundSpecification EOF ;
	public final EObject entryRuleBoundSpecification() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleBoundSpecification = null;


		try {
			// InternalUmlPort.g:464:2: (iv_ruleBoundSpecification= ruleBoundSpecification EOF )
			// InternalUmlPort.g:465:2: iv_ruleBoundSpecification= ruleBoundSpecification EOF
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
	// InternalUmlPort.g:472:1: ruleBoundSpecification returns [EObject current=null] : ( ( (lv_value_0_1= ruleUnlimitedLiteral | lv_value_0_2= ruleStringLiteral ) ) ) ;
	public final EObject ruleBoundSpecification() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_value_0_1 = null;

		AntlrDatatypeRuleToken lv_value_0_2 = null;


		enterRule();

		try {
			// InternalUmlPort.g:475:28: ( ( ( (lv_value_0_1= ruleUnlimitedLiteral | lv_value_0_2= ruleStringLiteral ) ) ) )
			// InternalUmlPort.g:476:1: ( ( (lv_value_0_1= ruleUnlimitedLiteral | lv_value_0_2= ruleStringLiteral ) ) )
			{
				// InternalUmlPort.g:476:1: ( ( (lv_value_0_1= ruleUnlimitedLiteral | lv_value_0_2= ruleStringLiteral ) ) )
				// InternalUmlPort.g:477:1: ( (lv_value_0_1= ruleUnlimitedLiteral | lv_value_0_2= ruleStringLiteral ) )
				{
					// InternalUmlPort.g:477:1: ( (lv_value_0_1= ruleUnlimitedLiteral | lv_value_0_2= ruleStringLiteral ) )
					// InternalUmlPort.g:478:1: (lv_value_0_1= ruleUnlimitedLiteral | lv_value_0_2= ruleStringLiteral )
					{
						// InternalUmlPort.g:478:1: (lv_value_0_1= ruleUnlimitedLiteral | lv_value_0_2= ruleStringLiteral )
						int alt12 = 2;
						int LA12_0 = input.LA(1);

						if ((LA12_0 == RULE_INT || LA12_0 == 20)) {
							alt12 = 1;
						} else if ((LA12_0 == RULE_STRING)) {
							alt12 = 2;
						} else {
							NoViableAltException nvae = new NoViableAltException("", 12, 0, input);

							throw nvae;
						}
						switch (alt12) {
						case 1:
						// InternalUmlPort.g:479:3: lv_value_0_1= ruleUnlimitedLiteral
						{

							newCompositeNode(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0_0());

							pushFollow(FOLLOW_2);
							lv_value_0_1 = ruleUnlimitedLiteral();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getBoundSpecificationRule());
							}
							set(
									current,
									"value",
									lv_value_0_1,
									"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.UnlimitedLiteral");
							afterParserOrEnumRuleCall();


						}
							break;
						case 2:
						// InternalUmlPort.g:494:8: lv_value_0_2= ruleStringLiteral
						{

							newCompositeNode(grammarAccess.getBoundSpecificationAccess().getValueStringLiteralParserRuleCall_0_1());

							pushFollow(FOLLOW_2);
							lv_value_0_2 = ruleStringLiteral();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getBoundSpecificationRule());
							}
							set(
									current,
									"value",
									lv_value_0_2,
									"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.StringLiteral");
							afterParserOrEnumRuleCall();


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
	// $ANTLR end "ruleBoundSpecification"


	// $ANTLR start "entryRuleUnlimitedLiteral"
	// InternalUmlPort.g:520:1: entryRuleUnlimitedLiteral returns [String current=null] : iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF ;
	public final String entryRuleUnlimitedLiteral() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleUnlimitedLiteral = null;


		try {
			// InternalUmlPort.g:521:2: (iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF )
			// InternalUmlPort.g:522:2: iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF
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
	// InternalUmlPort.g:529:1: ruleUnlimitedLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
	public final AntlrDatatypeRuleToken ruleUnlimitedLiteral() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_INT_0 = null;
		Token kw = null;

		enterRule();

		try {
			// InternalUmlPort.g:532:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
			// InternalUmlPort.g:533:1: (this_INT_0= RULE_INT | kw= '*' )
			{
				// InternalUmlPort.g:533:1: (this_INT_0= RULE_INT | kw= '*' )
				int alt13 = 2;
				int LA13_0 = input.LA(1);

				if ((LA13_0 == RULE_INT)) {
					alt13 = 1;
				} else if ((LA13_0 == 20)) {
					alt13 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 13, 0, input);

					throw nvae;
				}
				switch (alt13) {
				case 1:
				// InternalUmlPort.g:533:6: this_INT_0= RULE_INT
				{
					this_INT_0 = (Token) match(input, RULE_INT, FOLLOW_2);

					current.merge(this_INT_0);


					newLeafNode(this_INT_0, grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0());


				}
					break;
				case 2:
				// InternalUmlPort.g:542:2: kw= '*'
				{
					kw = (Token) match(input, 20, FOLLOW_2);

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


	// $ANTLR start "entryRuleStringLiteral"
	// InternalUmlPort.g:555:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
	public final String entryRuleStringLiteral() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


		try {
			// InternalUmlPort.g:556:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
			// InternalUmlPort.g:557:2: iv_ruleStringLiteral= ruleStringLiteral EOF
			{
				newCompositeNode(grammarAccess.getStringLiteralRule());
				pushFollow(FOLLOW_1);
				iv_ruleStringLiteral = ruleStringLiteral();

				state._fsp--;

				current = iv_ruleStringLiteral.getText();
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
	// $ANTLR end "entryRuleStringLiteral"


	// $ANTLR start "ruleStringLiteral"
	// InternalUmlPort.g:564:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
	public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_STRING_0 = null;

		enterRule();

		try {
			// InternalUmlPort.g:567:28: (this_STRING_0= RULE_STRING )
			// InternalUmlPort.g:568:5: this_STRING_0= RULE_STRING
			{
				this_STRING_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

				current.merge(this_STRING_0);


				newLeafNode(this_STRING_0, grammarAccess.getStringLiteralAccess().getSTRINGTerminalRuleCall());


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
	// $ANTLR end "ruleStringLiteral"


	// $ANTLR start "entryRuleModifiersRule"
	// InternalUmlPort.g:583:1: entryRuleModifiersRule returns [EObject current=null] : iv_ruleModifiersRule= ruleModifiersRule EOF ;
	public final EObject entryRuleModifiersRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleModifiersRule = null;


		try {
			// InternalUmlPort.g:584:2: (iv_ruleModifiersRule= ruleModifiersRule EOF )
			// InternalUmlPort.g:585:2: iv_ruleModifiersRule= ruleModifiersRule EOF
			{
				newCompositeNode(grammarAccess.getModifiersRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleModifiersRule = ruleModifiersRule();

				state._fsp--;

				current = iv_ruleModifiersRule;
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
	// $ANTLR end "entryRuleModifiersRule"


	// $ANTLR start "ruleModifiersRule"
	// InternalUmlPort.g:592:1: ruleModifiersRule returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_values_2_0= ruleModifierSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleModifierSpecification ) ) )* )? otherlv_5= '}' ) ;
	public final EObject ruleModifiersRule() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		Token otherlv_3 = null;
		Token otherlv_5 = null;
		EObject lv_values_2_0 = null;

		EObject lv_values_4_0 = null;


		enterRule();

		try {
			// InternalUmlPort.g:595:28: ( ( () otherlv_1= '{' ( ( (lv_values_2_0= ruleModifierSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleModifierSpecification ) ) )* )? otherlv_5= '}' ) )
			// InternalUmlPort.g:596:1: ( () otherlv_1= '{' ( ( (lv_values_2_0= ruleModifierSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleModifierSpecification ) ) )* )? otherlv_5= '}' )
			{
				// InternalUmlPort.g:596:1: ( () otherlv_1= '{' ( ( (lv_values_2_0= ruleModifierSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleModifierSpecification ) ) )* )? otherlv_5= '}' )
				// InternalUmlPort.g:596:2: () otherlv_1= '{' ( ( (lv_values_2_0= ruleModifierSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleModifierSpecification ) ) )* )? otherlv_5= '}'
				{
					// InternalUmlPort.g:596:2: ()
					// InternalUmlPort.g:597:5:
					{

						current = forceCreateModelElement(
								grammarAccess.getModifiersRuleAccess().getModifiersRuleAction_0(),
								current);


					}

					otherlv_1 = (Token) match(input, 21, FOLLOW_16);

					newLeafNode(otherlv_1, grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_1());

					// InternalUmlPort.g:606:1: ( ( (lv_values_2_0= ruleModifierSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleModifierSpecification ) ) )* )?
					int alt15 = 2;
					int LA15_0 = input.LA(1);

					if (((LA15_0 >= 24 && LA15_0 <= 25) || (LA15_0 >= 33 && LA15_0 <= 36))) {
						alt15 = 1;
					}
					switch (alt15) {
					case 1:
					// InternalUmlPort.g:606:2: ( (lv_values_2_0= ruleModifierSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleModifierSpecification ) ) )*
					{
						// InternalUmlPort.g:606:2: ( (lv_values_2_0= ruleModifierSpecification ) )
						// InternalUmlPort.g:607:1: (lv_values_2_0= ruleModifierSpecification )
						{
							// InternalUmlPort.g:607:1: (lv_values_2_0= ruleModifierSpecification )
							// InternalUmlPort.g:608:3: lv_values_2_0= ruleModifierSpecification
							{

								newCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_0_0());

								pushFollow(FOLLOW_17);
								lv_values_2_0 = ruleModifierSpecification();

								state._fsp--;


								if (current == null) {
									current = createModelElementForParent(grammarAccess.getModifiersRuleRule());
								}
								add(
										current,
										"values",
										lv_values_2_0,
										"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.ModifierSpecification");
								afterParserOrEnumRuleCall();


							}


						}

						// InternalUmlPort.g:624:2: (otherlv_3= ',' ( (lv_values_4_0= ruleModifierSpecification ) ) )*
						loop14: do {
							int alt14 = 2;
							int LA14_0 = input.LA(1);

							if ((LA14_0 == 22)) {
								alt14 = 1;
							}


							switch (alt14) {
							case 1:
							// InternalUmlPort.g:624:4: otherlv_3= ',' ( (lv_values_4_0= ruleModifierSpecification ) )
							{
								otherlv_3 = (Token) match(input, 22, FOLLOW_18);

								newLeafNode(otherlv_3, grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_1_0());

								// InternalUmlPort.g:628:1: ( (lv_values_4_0= ruleModifierSpecification ) )
								// InternalUmlPort.g:629:1: (lv_values_4_0= ruleModifierSpecification )
								{
									// InternalUmlPort.g:629:1: (lv_values_4_0= ruleModifierSpecification )
									// InternalUmlPort.g:630:3: lv_values_4_0= ruleModifierSpecification
									{

										newCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_1_0());

										pushFollow(FOLLOW_17);
										lv_values_4_0 = ruleModifierSpecification();

										state._fsp--;


										if (current == null) {
											current = createModelElementForParent(grammarAccess.getModifiersRuleRule());
										}
										add(
												current,
												"values",
												lv_values_4_0,
												"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.ModifierSpecification");
										afterParserOrEnumRuleCall();


									}


								}


							}
								break;

							default:
								break loop14;
							}
						} while (true);


					}
						break;

					}

					otherlv_5 = (Token) match(input, 23, FOLLOW_2);

					newLeafNode(otherlv_5, grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3());


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
	// $ANTLR end "ruleModifiersRule"


	// $ANTLR start "entryRuleModifierSpecification"
	// InternalUmlPort.g:658:1: entryRuleModifierSpecification returns [EObject current=null] : iv_ruleModifierSpecification= ruleModifierSpecification EOF ;
	public final EObject entryRuleModifierSpecification() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleModifierSpecification = null;


		try {
			// InternalUmlPort.g:659:2: (iv_ruleModifierSpecification= ruleModifierSpecification EOF )
			// InternalUmlPort.g:660:2: iv_ruleModifierSpecification= ruleModifierSpecification EOF
			{
				newCompositeNode(grammarAccess.getModifierSpecificationRule());
				pushFollow(FOLLOW_1);
				iv_ruleModifierSpecification = ruleModifierSpecification();

				state._fsp--;

				current = iv_ruleModifierSpecification;
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
	// $ANTLR end "entryRuleModifierSpecification"


	// $ANTLR start "ruleModifierSpecification"
	// InternalUmlPort.g:667:1: ruleModifierSpecification returns [EObject current=null] : ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) ) ;
	public final EObject ruleModifierSpecification() throws RecognitionException {
		EObject current = null;

		Enumerator lv_value_0_0 = null;

		EObject lv_redefines_1_0 = null;

		EObject lv_subsets_2_0 = null;


		enterRule();

		try {
			// InternalUmlPort.g:670:28: ( ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) ) )
			// InternalUmlPort.g:671:1: ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) )
			{
				// InternalUmlPort.g:671:1: ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) )
				int alt16 = 3;
				switch (input.LA(1)) {
				case 33:
				case 34:
				case 35:
				case 36: {
					alt16 = 1;
				}
					break;
				case 24: {
					alt16 = 2;
				}
					break;
				case 25: {
					alt16 = 3;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("", 16, 0, input);

					throw nvae;
				}

				switch (alt16) {
				case 1:
				// InternalUmlPort.g:671:2: ( (lv_value_0_0= ruleModifierKind ) )
				{
					// InternalUmlPort.g:671:2: ( (lv_value_0_0= ruleModifierKind ) )
					// InternalUmlPort.g:672:1: (lv_value_0_0= ruleModifierKind )
					{
						// InternalUmlPort.g:672:1: (lv_value_0_0= ruleModifierKind )
						// InternalUmlPort.g:673:3: lv_value_0_0= ruleModifierKind
						{

							newCompositeNode(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0());

							pushFollow(FOLLOW_2);
							lv_value_0_0 = ruleModifierKind();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getModifierSpecificationRule());
							}
							set(
									current,
									"value",
									lv_value_0_0,
									"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.ModifierKind");
							afterParserOrEnumRuleCall();


						}


					}


				}
					break;
				case 2:
				// InternalUmlPort.g:690:6: ( (lv_redefines_1_0= ruleRedefinesRule ) )
				{
					// InternalUmlPort.g:690:6: ( (lv_redefines_1_0= ruleRedefinesRule ) )
					// InternalUmlPort.g:691:1: (lv_redefines_1_0= ruleRedefinesRule )
					{
						// InternalUmlPort.g:691:1: (lv_redefines_1_0= ruleRedefinesRule )
						// InternalUmlPort.g:692:3: lv_redefines_1_0= ruleRedefinesRule
						{

							newCompositeNode(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0());

							pushFollow(FOLLOW_2);
							lv_redefines_1_0 = ruleRedefinesRule();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getModifierSpecificationRule());
							}
							set(
									current,
									"redefines",
									lv_redefines_1_0,
									"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.RedefinesRule");
							afterParserOrEnumRuleCall();


						}


					}


				}
					break;
				case 3:
				// InternalUmlPort.g:709:6: ( (lv_subsets_2_0= ruleSubsetsRule ) )
				{
					// InternalUmlPort.g:709:6: ( (lv_subsets_2_0= ruleSubsetsRule ) )
					// InternalUmlPort.g:710:1: (lv_subsets_2_0= ruleSubsetsRule )
					{
						// InternalUmlPort.g:710:1: (lv_subsets_2_0= ruleSubsetsRule )
						// InternalUmlPort.g:711:3: lv_subsets_2_0= ruleSubsetsRule
						{

							newCompositeNode(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0());

							pushFollow(FOLLOW_2);
							lv_subsets_2_0 = ruleSubsetsRule();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getModifierSpecificationRule());
							}
							set(
									current,
									"subsets",
									lv_subsets_2_0,
									"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.SubsetsRule");
							afterParserOrEnumRuleCall();


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
	// $ANTLR end "ruleModifierSpecification"


	// $ANTLR start "entryRuleRedefinesRule"
	// InternalUmlPort.g:735:1: entryRuleRedefinesRule returns [EObject current=null] : iv_ruleRedefinesRule= ruleRedefinesRule EOF ;
	public final EObject entryRuleRedefinesRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleRedefinesRule = null;


		try {
			// InternalUmlPort.g:736:2: (iv_ruleRedefinesRule= ruleRedefinesRule EOF )
			// InternalUmlPort.g:737:2: iv_ruleRedefinesRule= ruleRedefinesRule EOF
			{
				newCompositeNode(grammarAccess.getRedefinesRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleRedefinesRule = ruleRedefinesRule();

				state._fsp--;

				current = iv_ruleRedefinesRule;
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
	// $ANTLR end "entryRuleRedefinesRule"


	// $ANTLR start "ruleRedefinesRule"
	// InternalUmlPort.g:744:1: ruleRedefinesRule returns [EObject current=null] : (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) ) ;
	public final EObject ruleRedefinesRule() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_1 = null;

		enterRule();

		try {
			// InternalUmlPort.g:747:28: ( (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) ) )
			// InternalUmlPort.g:748:1: (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) )
			{
				// InternalUmlPort.g:748:1: (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) )
				// InternalUmlPort.g:748:3: otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) )
				{
					otherlv_0 = (Token) match(input, 24, FOLLOW_4);

					newLeafNode(otherlv_0, grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0());

					// InternalUmlPort.g:752:1: ( (otherlv_1= RULE_ID ) )
					// InternalUmlPort.g:753:1: (otherlv_1= RULE_ID )
					{
						// InternalUmlPort.g:753:1: (otherlv_1= RULE_ID )
						// InternalUmlPort.g:754:3: otherlv_1= RULE_ID
						{

							if (current == null) {
								current = createModelElement(grammarAccess.getRedefinesRuleRule());
							}

							otherlv_1 = (Token) match(input, RULE_ID, FOLLOW_2);

							newLeafNode(otherlv_1, grammarAccess.getRedefinesRuleAccess().getPortPortCrossReference_1_0());


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
	// $ANTLR end "ruleRedefinesRule"


	// $ANTLR start "entryRuleSubsetsRule"
	// InternalUmlPort.g:773:1: entryRuleSubsetsRule returns [EObject current=null] : iv_ruleSubsetsRule= ruleSubsetsRule EOF ;
	public final EObject entryRuleSubsetsRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSubsetsRule = null;


		try {
			// InternalUmlPort.g:774:2: (iv_ruleSubsetsRule= ruleSubsetsRule EOF )
			// InternalUmlPort.g:775:2: iv_ruleSubsetsRule= ruleSubsetsRule EOF
			{
				newCompositeNode(grammarAccess.getSubsetsRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleSubsetsRule = ruleSubsetsRule();

				state._fsp--;

				current = iv_ruleSubsetsRule;
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
	// $ANTLR end "entryRuleSubsetsRule"


	// $ANTLR start "ruleSubsetsRule"
	// InternalUmlPort.g:782:1: ruleSubsetsRule returns [EObject current=null] : (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) ) ;
	public final EObject ruleSubsetsRule() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_1 = null;

		enterRule();

		try {
			// InternalUmlPort.g:785:28: ( (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) ) )
			// InternalUmlPort.g:786:1: (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) )
			{
				// InternalUmlPort.g:786:1: (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) )
				// InternalUmlPort.g:786:3: otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) )
				{
					otherlv_0 = (Token) match(input, 25, FOLLOW_4);

					newLeafNode(otherlv_0, grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0());

					// InternalUmlPort.g:790:1: ( (otherlv_1= RULE_ID ) )
					// InternalUmlPort.g:791:1: (otherlv_1= RULE_ID )
					{
						// InternalUmlPort.g:791:1: (otherlv_1= RULE_ID )
						// InternalUmlPort.g:792:3: otherlv_1= RULE_ID
						{

							if (current == null) {
								current = createModelElement(grammarAccess.getSubsetsRuleRule());
							}

							otherlv_1 = (Token) match(input, RULE_ID, FOLLOW_2);

							newLeafNode(otherlv_1, grammarAccess.getSubsetsRuleAccess().getPortPortCrossReference_1_0());


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
	// $ANTLR end "ruleSubsetsRule"


	// $ANTLR start "entryRuleDefaultValueRule"
	// InternalUmlPort.g:811:1: entryRuleDefaultValueRule returns [EObject current=null] : iv_ruleDefaultValueRule= ruleDefaultValueRule EOF ;
	public final EObject entryRuleDefaultValueRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleDefaultValueRule = null;


		try {
			// InternalUmlPort.g:812:2: (iv_ruleDefaultValueRule= ruleDefaultValueRule EOF )
			// InternalUmlPort.g:813:2: iv_ruleDefaultValueRule= ruleDefaultValueRule EOF
			{
				newCompositeNode(grammarAccess.getDefaultValueRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleDefaultValueRule = ruleDefaultValueRule();

				state._fsp--;

				current = iv_ruleDefaultValueRule;
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
	// $ANTLR end "entryRuleDefaultValueRule"


	// $ANTLR start "ruleDefaultValueRule"
	// InternalUmlPort.g:820:1: ruleDefaultValueRule returns [EObject current=null] : (otherlv_0= '=' ( (lv_default_1_0= ruleValue ) ) ) ;
	public final EObject ruleDefaultValueRule() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		EObject lv_default_1_0 = null;


		enterRule();

		try {
			// InternalUmlPort.g:823:28: ( (otherlv_0= '=' ( (lv_default_1_0= ruleValue ) ) ) )
			// InternalUmlPort.g:824:1: (otherlv_0= '=' ( (lv_default_1_0= ruleValue ) ) )
			{
				// InternalUmlPort.g:824:1: (otherlv_0= '=' ( (lv_default_1_0= ruleValue ) ) )
				// InternalUmlPort.g:824:3: otherlv_0= '=' ( (lv_default_1_0= ruleValue ) )
				{
					otherlv_0 = (Token) match(input, 26, FOLLOW_19);

					newLeafNode(otherlv_0, grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0());

					// InternalUmlPort.g:828:1: ( (lv_default_1_0= ruleValue ) )
					// InternalUmlPort.g:829:1: (lv_default_1_0= ruleValue )
					{
						// InternalUmlPort.g:829:1: (lv_default_1_0= ruleValue )
						// InternalUmlPort.g:830:3: lv_default_1_0= ruleValue
						{

							newCompositeNode(grammarAccess.getDefaultValueRuleAccess().getDefaultValueParserRuleCall_1_0());

							pushFollow(FOLLOW_2);
							lv_default_1_0 = ruleValue();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getDefaultValueRuleRule());
							}
							set(
									current,
									"default",
									lv_default_1_0,
									"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.Value");
							afterParserOrEnumRuleCall();


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
	// $ANTLR end "ruleDefaultValueRule"


	// $ANTLR start "entryRuleValue"
	// InternalUmlPort.g:854:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
	public final EObject entryRuleValue() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleValue = null;


		try {
			// InternalUmlPort.g:855:2: (iv_ruleValue= ruleValue EOF )
			// InternalUmlPort.g:856:2: iv_ruleValue= ruleValue EOF
			{
				newCompositeNode(grammarAccess.getValueRule());
				pushFollow(FOLLOW_1);
				iv_ruleValue = ruleValue();

				state._fsp--;

				current = iv_ruleValue;
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
	// $ANTLR end "entryRuleValue"


	// $ANTLR start "ruleValue"
	// InternalUmlPort.g:863:1: ruleValue returns [EObject current=null] : (this_IntValue_0= ruleIntValue | this_StringValue_1= ruleStringValue | this_BooleanValue_2= ruleBooleanValue | this_RealValue_3= ruleRealValue | this_NullValue_4= ruleNullValue |
	// this_NoValue_5= ruleNoValue ) ;
	public final EObject ruleValue() throws RecognitionException {
		EObject current = null;

		EObject this_IntValue_0 = null;

		EObject this_StringValue_1 = null;

		EObject this_BooleanValue_2 = null;

		EObject this_RealValue_3 = null;

		EObject this_NullValue_4 = null;

		EObject this_NoValue_5 = null;


		enterRule();

		try {
			// InternalUmlPort.g:866:28: ( (this_IntValue_0= ruleIntValue | this_StringValue_1= ruleStringValue | this_BooleanValue_2= ruleBooleanValue | this_RealValue_3= ruleRealValue | this_NullValue_4= ruleNullValue | this_NoValue_5= ruleNoValue ) )
			// InternalUmlPort.g:867:1: (this_IntValue_0= ruleIntValue | this_StringValue_1= ruleStringValue | this_BooleanValue_2= ruleBooleanValue | this_RealValue_3= ruleRealValue | this_NullValue_4= ruleNullValue | this_NoValue_5= ruleNoValue )
			{
				// InternalUmlPort.g:867:1: (this_IntValue_0= ruleIntValue | this_StringValue_1= ruleStringValue | this_BooleanValue_2= ruleBooleanValue | this_RealValue_3= ruleRealValue | this_NullValue_4= ruleNullValue | this_NoValue_5= ruleNoValue )
				int alt17 = 6;
				switch (input.LA(1)) {
				case RULE_INT: {
					int LA17_1 = input.LA(2);

					if ((LA17_1 == 27)) {
						alt17 = 4;
					} else if ((LA17_1 == EOF)) {
						alt17 = 1;
					} else {
						NoViableAltException nvae = new NoViableAltException("", 17, 1, input);

						throw nvae;
					}
				}
					break;
				case RULE_STRING: {
					alt17 = 2;
				}
					break;
				case 37:
				case 38: {
					alt17 = 3;
				}
					break;
				case 27: {
					alt17 = 4;
				}
					break;
				case 28: {
					alt17 = 5;
				}
					break;
				case 29: {
					alt17 = 6;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("", 17, 0, input);

					throw nvae;
				}

				switch (alt17) {
				case 1:
				// InternalUmlPort.g:868:5: this_IntValue_0= ruleIntValue
				{

					newCompositeNode(grammarAccess.getValueAccess().getIntValueParserRuleCall_0());

					pushFollow(FOLLOW_2);
					this_IntValue_0 = ruleIntValue();

					state._fsp--;


					current = this_IntValue_0;
					afterParserOrEnumRuleCall();


				}
					break;
				case 2:
				// InternalUmlPort.g:878:5: this_StringValue_1= ruleStringValue
				{

					newCompositeNode(grammarAccess.getValueAccess().getStringValueParserRuleCall_1());

					pushFollow(FOLLOW_2);
					this_StringValue_1 = ruleStringValue();

					state._fsp--;


					current = this_StringValue_1;
					afterParserOrEnumRuleCall();


				}
					break;
				case 3:
				// InternalUmlPort.g:888:5: this_BooleanValue_2= ruleBooleanValue
				{

					newCompositeNode(grammarAccess.getValueAccess().getBooleanValueParserRuleCall_2());

					pushFollow(FOLLOW_2);
					this_BooleanValue_2 = ruleBooleanValue();

					state._fsp--;


					current = this_BooleanValue_2;
					afterParserOrEnumRuleCall();


				}
					break;
				case 4:
				// InternalUmlPort.g:898:5: this_RealValue_3= ruleRealValue
				{

					newCompositeNode(grammarAccess.getValueAccess().getRealValueParserRuleCall_3());

					pushFollow(FOLLOW_2);
					this_RealValue_3 = ruleRealValue();

					state._fsp--;


					current = this_RealValue_3;
					afterParserOrEnumRuleCall();


				}
					break;
				case 5:
				// InternalUmlPort.g:908:5: this_NullValue_4= ruleNullValue
				{

					newCompositeNode(grammarAccess.getValueAccess().getNullValueParserRuleCall_4());

					pushFollow(FOLLOW_2);
					this_NullValue_4 = ruleNullValue();

					state._fsp--;


					current = this_NullValue_4;
					afterParserOrEnumRuleCall();


				}
					break;
				case 6:
				// InternalUmlPort.g:918:5: this_NoValue_5= ruleNoValue
				{

					newCompositeNode(grammarAccess.getValueAccess().getNoValueParserRuleCall_5());

					pushFollow(FOLLOW_2);
					this_NoValue_5 = ruleNoValue();

					state._fsp--;


					current = this_NoValue_5;
					afterParserOrEnumRuleCall();


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
	// $ANTLR end "ruleValue"


	// $ANTLR start "entryRuleIntValue"
	// InternalUmlPort.g:934:1: entryRuleIntValue returns [EObject current=null] : iv_ruleIntValue= ruleIntValue EOF ;
	public final EObject entryRuleIntValue() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleIntValue = null;


		try {
			// InternalUmlPort.g:935:2: (iv_ruleIntValue= ruleIntValue EOF )
			// InternalUmlPort.g:936:2: iv_ruleIntValue= ruleIntValue EOF
			{
				newCompositeNode(grammarAccess.getIntValueRule());
				pushFollow(FOLLOW_1);
				iv_ruleIntValue = ruleIntValue();

				state._fsp--;

				current = iv_ruleIntValue;
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
	// $ANTLR end "entryRuleIntValue"


	// $ANTLR start "ruleIntValue"
	// InternalUmlPort.g:943:1: ruleIntValue returns [EObject current=null] : ( (lv_literalInteger_0_0= RULE_INT ) ) ;
	public final EObject ruleIntValue() throws RecognitionException {
		EObject current = null;

		Token lv_literalInteger_0_0 = null;

		enterRule();

		try {
			// InternalUmlPort.g:946:28: ( ( (lv_literalInteger_0_0= RULE_INT ) ) )
			// InternalUmlPort.g:947:1: ( (lv_literalInteger_0_0= RULE_INT ) )
			{
				// InternalUmlPort.g:947:1: ( (lv_literalInteger_0_0= RULE_INT ) )
				// InternalUmlPort.g:948:1: (lv_literalInteger_0_0= RULE_INT )
				{
					// InternalUmlPort.g:948:1: (lv_literalInteger_0_0= RULE_INT )
					// InternalUmlPort.g:949:3: lv_literalInteger_0_0= RULE_INT
					{
						lv_literalInteger_0_0 = (Token) match(input, RULE_INT, FOLLOW_2);

						newLeafNode(lv_literalInteger_0_0, grammarAccess.getIntValueAccess().getLiteralIntegerINTTerminalRuleCall_0());


						if (current == null) {
							current = createModelElement(grammarAccess.getIntValueRule());
						}
						setWithLastConsumed(
								current,
								"literalInteger",
								lv_literalInteger_0_0,
								"org.eclipse.papyrus.uml.alf.Common.INT");


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
	// $ANTLR end "ruleIntValue"


	// $ANTLR start "entryRuleStringValue"
	// InternalUmlPort.g:973:1: entryRuleStringValue returns [EObject current=null] : iv_ruleStringValue= ruleStringValue EOF ;
	public final EObject entryRuleStringValue() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleStringValue = null;


		try {
			// InternalUmlPort.g:974:2: (iv_ruleStringValue= ruleStringValue EOF )
			// InternalUmlPort.g:975:2: iv_ruleStringValue= ruleStringValue EOF
			{
				newCompositeNode(grammarAccess.getStringValueRule());
				pushFollow(FOLLOW_1);
				iv_ruleStringValue = ruleStringValue();

				state._fsp--;

				current = iv_ruleStringValue;
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
	// $ANTLR end "entryRuleStringValue"


	// $ANTLR start "ruleStringValue"
	// InternalUmlPort.g:982:1: ruleStringValue returns [EObject current=null] : ( (lv_literalString_0_0= RULE_STRING ) ) ;
	public final EObject ruleStringValue() throws RecognitionException {
		EObject current = null;

		Token lv_literalString_0_0 = null;

		enterRule();

		try {
			// InternalUmlPort.g:985:28: ( ( (lv_literalString_0_0= RULE_STRING ) ) )
			// InternalUmlPort.g:986:1: ( (lv_literalString_0_0= RULE_STRING ) )
			{
				// InternalUmlPort.g:986:1: ( (lv_literalString_0_0= RULE_STRING ) )
				// InternalUmlPort.g:987:1: (lv_literalString_0_0= RULE_STRING )
				{
					// InternalUmlPort.g:987:1: (lv_literalString_0_0= RULE_STRING )
					// InternalUmlPort.g:988:3: lv_literalString_0_0= RULE_STRING
					{
						lv_literalString_0_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

						newLeafNode(lv_literalString_0_0, grammarAccess.getStringValueAccess().getLiteralStringSTRINGTerminalRuleCall_0());


						if (current == null) {
							current = createModelElement(grammarAccess.getStringValueRule());
						}
						setWithLastConsumed(
								current,
								"literalString",
								lv_literalString_0_0,
								"org.eclipse.papyrus.uml.alf.Common.STRING");


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
	// $ANTLR end "ruleStringValue"


	// $ANTLR start "entryRuleBooleanValue"
	// InternalUmlPort.g:1012:1: entryRuleBooleanValue returns [EObject current=null] : iv_ruleBooleanValue= ruleBooleanValue EOF ;
	public final EObject entryRuleBooleanValue() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleBooleanValue = null;


		try {
			// InternalUmlPort.g:1013:2: (iv_ruleBooleanValue= ruleBooleanValue EOF )
			// InternalUmlPort.g:1014:2: iv_ruleBooleanValue= ruleBooleanValue EOF
			{
				newCompositeNode(grammarAccess.getBooleanValueRule());
				pushFollow(FOLLOW_1);
				iv_ruleBooleanValue = ruleBooleanValue();

				state._fsp--;

				current = iv_ruleBooleanValue;
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
	// $ANTLR end "entryRuleBooleanValue"


	// $ANTLR start "ruleBooleanValue"
	// InternalUmlPort.g:1021:1: ruleBooleanValue returns [EObject current=null] : ( (lv_literalBoolean_0_0= ruleBooleanLiterals ) ) ;
	public final EObject ruleBooleanValue() throws RecognitionException {
		EObject current = null;

		Enumerator lv_literalBoolean_0_0 = null;


		enterRule();

		try {
			// InternalUmlPort.g:1024:28: ( ( (lv_literalBoolean_0_0= ruleBooleanLiterals ) ) )
			// InternalUmlPort.g:1025:1: ( (lv_literalBoolean_0_0= ruleBooleanLiterals ) )
			{
				// InternalUmlPort.g:1025:1: ( (lv_literalBoolean_0_0= ruleBooleanLiterals ) )
				// InternalUmlPort.g:1026:1: (lv_literalBoolean_0_0= ruleBooleanLiterals )
				{
					// InternalUmlPort.g:1026:1: (lv_literalBoolean_0_0= ruleBooleanLiterals )
					// InternalUmlPort.g:1027:3: lv_literalBoolean_0_0= ruleBooleanLiterals
					{

						newCompositeNode(grammarAccess.getBooleanValueAccess().getLiteralBooleanBooleanLiteralsEnumRuleCall_0());

						pushFollow(FOLLOW_2);
						lv_literalBoolean_0_0 = ruleBooleanLiterals();

						state._fsp--;


						if (current == null) {
							current = createModelElementForParent(grammarAccess.getBooleanValueRule());
						}
						set(
								current,
								"literalBoolean",
								lv_literalBoolean_0_0,
								"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.BooleanLiterals");
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
	// $ANTLR end "ruleBooleanValue"


	// $ANTLR start "entryRuleRealValue"
	// InternalUmlPort.g:1051:1: entryRuleRealValue returns [EObject current=null] : iv_ruleRealValue= ruleRealValue EOF ;
	public final EObject entryRuleRealValue() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleRealValue = null;


		try {
			// InternalUmlPort.g:1052:2: (iv_ruleRealValue= ruleRealValue EOF )
			// InternalUmlPort.g:1053:2: iv_ruleRealValue= ruleRealValue EOF
			{
				newCompositeNode(grammarAccess.getRealValueRule());
				pushFollow(FOLLOW_1);
				iv_ruleRealValue = ruleRealValue();

				state._fsp--;

				current = iv_ruleRealValue;
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
	// $ANTLR end "entryRuleRealValue"


	// $ANTLR start "ruleRealValue"
	// InternalUmlPort.g:1060:1: ruleRealValue returns [EObject current=null] : ( ( ( (lv_integer_0_0= RULE_INT ) ) otherlv_1= '.' ) | (otherlv_2= '.' ( (lv_fraction_3_0= RULE_INT ) ) ) | ( ( (lv_integer_4_0= RULE_INT ) ) otherlv_5= '.' ( (lv_fraction_6_0=
	// RULE_INT ) ) ) ) ;
	public final EObject ruleRealValue() throws RecognitionException {
		EObject current = null;

		Token lv_integer_0_0 = null;
		Token otherlv_1 = null;
		Token otherlv_2 = null;
		Token lv_fraction_3_0 = null;
		Token lv_integer_4_0 = null;
		Token otherlv_5 = null;
		Token lv_fraction_6_0 = null;

		enterRule();

		try {
			// InternalUmlPort.g:1063:28: ( ( ( ( (lv_integer_0_0= RULE_INT ) ) otherlv_1= '.' ) | (otherlv_2= '.' ( (lv_fraction_3_0= RULE_INT ) ) ) | ( ( (lv_integer_4_0= RULE_INT ) ) otherlv_5= '.' ( (lv_fraction_6_0= RULE_INT ) ) ) ) )
			// InternalUmlPort.g:1064:1: ( ( ( (lv_integer_0_0= RULE_INT ) ) otherlv_1= '.' ) | (otherlv_2= '.' ( (lv_fraction_3_0= RULE_INT ) ) ) | ( ( (lv_integer_4_0= RULE_INT ) ) otherlv_5= '.' ( (lv_fraction_6_0= RULE_INT ) ) ) )
			{
				// InternalUmlPort.g:1064:1: ( ( ( (lv_integer_0_0= RULE_INT ) ) otherlv_1= '.' ) | (otherlv_2= '.' ( (lv_fraction_3_0= RULE_INT ) ) ) | ( ( (lv_integer_4_0= RULE_INT ) ) otherlv_5= '.' ( (lv_fraction_6_0= RULE_INT ) ) ) )
				int alt18 = 3;
				int LA18_0 = input.LA(1);

				if ((LA18_0 == RULE_INT)) {
					int LA18_1 = input.LA(2);

					if ((LA18_1 == 27)) {
						int LA18_3 = input.LA(3);

						if ((LA18_3 == RULE_INT)) {
							alt18 = 3;
						} else if ((LA18_3 == EOF)) {
							alt18 = 1;
						} else {
							NoViableAltException nvae = new NoViableAltException("", 18, 3, input);

							throw nvae;
						}
					} else {
						NoViableAltException nvae = new NoViableAltException("", 18, 1, input);

						throw nvae;
					}
				} else if ((LA18_0 == 27)) {
					alt18 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 18, 0, input);

					throw nvae;
				}
				switch (alt18) {
				case 1:
				// InternalUmlPort.g:1064:2: ( ( (lv_integer_0_0= RULE_INT ) ) otherlv_1= '.' )
				{
					// InternalUmlPort.g:1064:2: ( ( (lv_integer_0_0= RULE_INT ) ) otherlv_1= '.' )
					// InternalUmlPort.g:1064:3: ( (lv_integer_0_0= RULE_INT ) ) otherlv_1= '.'
					{
						// InternalUmlPort.g:1064:3: ( (lv_integer_0_0= RULE_INT ) )
						// InternalUmlPort.g:1065:1: (lv_integer_0_0= RULE_INT )
						{
							// InternalUmlPort.g:1065:1: (lv_integer_0_0= RULE_INT )
							// InternalUmlPort.g:1066:3: lv_integer_0_0= RULE_INT
							{
								lv_integer_0_0 = (Token) match(input, RULE_INT, FOLLOW_20);

								newLeafNode(lv_integer_0_0, grammarAccess.getRealValueAccess().getIntegerINTTerminalRuleCall_0_0_0());


								if (current == null) {
									current = createModelElement(grammarAccess.getRealValueRule());
								}
								setWithLastConsumed(
										current,
										"integer",
										lv_integer_0_0,
										"org.eclipse.papyrus.uml.alf.Common.INT");


							}


						}

						otherlv_1 = (Token) match(input, 27, FOLLOW_2);

						newLeafNode(otherlv_1, grammarAccess.getRealValueAccess().getFullStopKeyword_0_1());


					}


				}
					break;
				case 2:
				// InternalUmlPort.g:1087:6: (otherlv_2= '.' ( (lv_fraction_3_0= RULE_INT ) ) )
				{
					// InternalUmlPort.g:1087:6: (otherlv_2= '.' ( (lv_fraction_3_0= RULE_INT ) ) )
					// InternalUmlPort.g:1087:8: otherlv_2= '.' ( (lv_fraction_3_0= RULE_INT ) )
					{
						otherlv_2 = (Token) match(input, 27, FOLLOW_21);

						newLeafNode(otherlv_2, grammarAccess.getRealValueAccess().getFullStopKeyword_1_0());

						// InternalUmlPort.g:1091:1: ( (lv_fraction_3_0= RULE_INT ) )
						// InternalUmlPort.g:1092:1: (lv_fraction_3_0= RULE_INT )
						{
							// InternalUmlPort.g:1092:1: (lv_fraction_3_0= RULE_INT )
							// InternalUmlPort.g:1093:3: lv_fraction_3_0= RULE_INT
							{
								lv_fraction_3_0 = (Token) match(input, RULE_INT, FOLLOW_2);

								newLeafNode(lv_fraction_3_0, grammarAccess.getRealValueAccess().getFractionINTTerminalRuleCall_1_1_0());


								if (current == null) {
									current = createModelElement(grammarAccess.getRealValueRule());
								}
								setWithLastConsumed(
										current,
										"fraction",
										lv_fraction_3_0,
										"org.eclipse.papyrus.uml.alf.Common.INT");


							}


						}


					}


				}
					break;
				case 3:
				// InternalUmlPort.g:1110:6: ( ( (lv_integer_4_0= RULE_INT ) ) otherlv_5= '.' ( (lv_fraction_6_0= RULE_INT ) ) )
				{
					// InternalUmlPort.g:1110:6: ( ( (lv_integer_4_0= RULE_INT ) ) otherlv_5= '.' ( (lv_fraction_6_0= RULE_INT ) ) )
					// InternalUmlPort.g:1110:7: ( (lv_integer_4_0= RULE_INT ) ) otherlv_5= '.' ( (lv_fraction_6_0= RULE_INT ) )
					{
						// InternalUmlPort.g:1110:7: ( (lv_integer_4_0= RULE_INT ) )
						// InternalUmlPort.g:1111:1: (lv_integer_4_0= RULE_INT )
						{
							// InternalUmlPort.g:1111:1: (lv_integer_4_0= RULE_INT )
							// InternalUmlPort.g:1112:3: lv_integer_4_0= RULE_INT
							{
								lv_integer_4_0 = (Token) match(input, RULE_INT, FOLLOW_20);

								newLeafNode(lv_integer_4_0, grammarAccess.getRealValueAccess().getIntegerINTTerminalRuleCall_2_0_0());


								if (current == null) {
									current = createModelElement(grammarAccess.getRealValueRule());
								}
								setWithLastConsumed(
										current,
										"integer",
										lv_integer_4_0,
										"org.eclipse.papyrus.uml.alf.Common.INT");


							}


						}

						otherlv_5 = (Token) match(input, 27, FOLLOW_21);

						newLeafNode(otherlv_5, grammarAccess.getRealValueAccess().getFullStopKeyword_2_1());

						// InternalUmlPort.g:1132:1: ( (lv_fraction_6_0= RULE_INT ) )
						// InternalUmlPort.g:1133:1: (lv_fraction_6_0= RULE_INT )
						{
							// InternalUmlPort.g:1133:1: (lv_fraction_6_0= RULE_INT )
							// InternalUmlPort.g:1134:3: lv_fraction_6_0= RULE_INT
							{
								lv_fraction_6_0 = (Token) match(input, RULE_INT, FOLLOW_2);

								newLeafNode(lv_fraction_6_0, grammarAccess.getRealValueAccess().getFractionINTTerminalRuleCall_2_2_0());


								if (current == null) {
									current = createModelElement(grammarAccess.getRealValueRule());
								}
								setWithLastConsumed(
										current,
										"fraction",
										lv_fraction_6_0,
										"org.eclipse.papyrus.uml.alf.Common.INT");


							}


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
	// $ANTLR end "ruleRealValue"


	// $ANTLR start "entryRuleNullValue"
	// InternalUmlPort.g:1158:1: entryRuleNullValue returns [EObject current=null] : iv_ruleNullValue= ruleNullValue EOF ;
	public final EObject entryRuleNullValue() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNullValue = null;


		try {
			// InternalUmlPort.g:1159:2: (iv_ruleNullValue= ruleNullValue EOF )
			// InternalUmlPort.g:1160:2: iv_ruleNullValue= ruleNullValue EOF
			{
				newCompositeNode(grammarAccess.getNullValueRule());
				pushFollow(FOLLOW_1);
				iv_ruleNullValue = ruleNullValue();

				state._fsp--;

				current = iv_ruleNullValue;
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
	// $ANTLR end "entryRuleNullValue"


	// $ANTLR start "ruleNullValue"
	// InternalUmlPort.g:1167:1: ruleNullValue returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
	public final EObject ruleNullValue() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;

		enterRule();

		try {
			// InternalUmlPort.g:1170:28: ( ( () otherlv_1= 'null' ) )
			// InternalUmlPort.g:1171:1: ( () otherlv_1= 'null' )
			{
				// InternalUmlPort.g:1171:1: ( () otherlv_1= 'null' )
				// InternalUmlPort.g:1171:2: () otherlv_1= 'null'
				{
					// InternalUmlPort.g:1171:2: ()
					// InternalUmlPort.g:1172:5:
					{

						current = forceCreateModelElement(
								grammarAccess.getNullValueAccess().getNullValueAction_0(),
								current);


					}

					otherlv_1 = (Token) match(input, 28, FOLLOW_2);

					newLeafNode(otherlv_1, grammarAccess.getNullValueAccess().getNullKeyword_1());


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
	// $ANTLR end "ruleNullValue"


	// $ANTLR start "entryRuleNoValue"
	// InternalUmlPort.g:1189:1: entryRuleNoValue returns [EObject current=null] : iv_ruleNoValue= ruleNoValue EOF ;
	public final EObject entryRuleNoValue() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNoValue = null;


		try {
			// InternalUmlPort.g:1190:2: (iv_ruleNoValue= ruleNoValue EOF )
			// InternalUmlPort.g:1191:2: iv_ruleNoValue= ruleNoValue EOF
			{
				newCompositeNode(grammarAccess.getNoValueRule());
				pushFollow(FOLLOW_1);
				iv_ruleNoValue = ruleNoValue();

				state._fsp--;

				current = iv_ruleNoValue;
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
	// $ANTLR end "entryRuleNoValue"


	// $ANTLR start "ruleNoValue"
	// InternalUmlPort.g:1198:1: ruleNoValue returns [EObject current=null] : ( () otherlv_1= 'none' ) ;
	public final EObject ruleNoValue() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;

		enterRule();

		try {
			// InternalUmlPort.g:1201:28: ( ( () otherlv_1= 'none' ) )
			// InternalUmlPort.g:1202:1: ( () otherlv_1= 'none' )
			{
				// InternalUmlPort.g:1202:1: ( () otherlv_1= 'none' )
				// InternalUmlPort.g:1202:2: () otherlv_1= 'none'
				{
					// InternalUmlPort.g:1202:2: ()
					// InternalUmlPort.g:1203:5:
					{

						current = forceCreateModelElement(
								grammarAccess.getNoValueAccess().getNoValueAction_0(),
								current);


					}

					otherlv_1 = (Token) match(input, 29, FOLLOW_2);

					newLeafNode(otherlv_1, grammarAccess.getNoValueAccess().getNoneKeyword_1());


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
	// $ANTLR end "ruleNoValue"


	// $ANTLR start "ruleVisibilityKind"
	// InternalUmlPort.g:1220:1: ruleVisibilityKind returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) ) ;
	public final Enumerator ruleVisibilityKind() throws RecognitionException {
		Enumerator current = null;

		Token enumLiteral_0 = null;
		Token enumLiteral_1 = null;
		Token enumLiteral_2 = null;
		Token enumLiteral_3 = null;

		enterRule();
		try {
			// InternalUmlPort.g:1222:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) ) )
			// InternalUmlPort.g:1223:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) )
			{
				// InternalUmlPort.g:1223:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) )
				int alt19 = 4;
				switch (input.LA(1)) {
				case 30: {
					alt19 = 1;
				}
					break;
				case 31: {
					alt19 = 2;
				}
					break;
				case 32: {
					alt19 = 3;
				}
					break;
				case 14: {
					alt19 = 4;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("", 19, 0, input);

					throw nvae;
				}

				switch (alt19) {
				case 1:
				// InternalUmlPort.g:1223:2: (enumLiteral_0= '+' )
				{
					// InternalUmlPort.g:1223:2: (enumLiteral_0= '+' )
					// InternalUmlPort.g:1223:4: enumLiteral_0= '+'
					{
						enumLiteral_0 = (Token) match(input, 30, FOLLOW_2);

						current = grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_0, grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0());


					}


				}
					break;
				case 2:
				// InternalUmlPort.g:1229:6: (enumLiteral_1= '-' )
				{
					// InternalUmlPort.g:1229:6: (enumLiteral_1= '-' )
					// InternalUmlPort.g:1229:8: enumLiteral_1= '-'
					{
						enumLiteral_1 = (Token) match(input, 31, FOLLOW_2);

						current = grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_1, grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1());


					}


				}
					break;
				case 3:
				// InternalUmlPort.g:1235:6: (enumLiteral_2= '#' )
				{
					// InternalUmlPort.g:1235:6: (enumLiteral_2= '#' )
					// InternalUmlPort.g:1235:8: enumLiteral_2= '#'
					{
						enumLiteral_2 = (Token) match(input, 32, FOLLOW_2);

						current = grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_2, grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2());


					}


				}
					break;
				case 4:
				// InternalUmlPort.g:1241:6: (enumLiteral_3= '~' )
				{
					// InternalUmlPort.g:1241:6: (enumLiteral_3= '~' )
					// InternalUmlPort.g:1241:8: enumLiteral_3= '~'
					{
						enumLiteral_3 = (Token) match(input, 14, FOLLOW_2);

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


	// $ANTLR start "ruleModifierKind"
	// InternalUmlPort.g:1251:1: ruleModifierKind returns [Enumerator current=null] : ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) ) ;
	public final Enumerator ruleModifierKind() throws RecognitionException {
		Enumerator current = null;

		Token enumLiteral_0 = null;
		Token enumLiteral_1 = null;
		Token enumLiteral_2 = null;
		Token enumLiteral_3 = null;

		enterRule();
		try {
			// InternalUmlPort.g:1253:28: ( ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) ) )
			// InternalUmlPort.g:1254:1: ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) )
			{
				// InternalUmlPort.g:1254:1: ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) )
				int alt20 = 4;
				switch (input.LA(1)) {
				case 33: {
					alt20 = 1;
				}
					break;
				case 34: {
					alt20 = 2;
				}
					break;
				case 35: {
					alt20 = 3;
				}
					break;
				case 36: {
					alt20 = 4;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("", 20, 0, input);

					throw nvae;
				}

				switch (alt20) {
				case 1:
				// InternalUmlPort.g:1254:2: (enumLiteral_0= 'readOnly' )
				{
					// InternalUmlPort.g:1254:2: (enumLiteral_0= 'readOnly' )
					// InternalUmlPort.g:1254:4: enumLiteral_0= 'readOnly'
					{
						enumLiteral_0 = (Token) match(input, 33, FOLLOW_2);

						current = grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_0, grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0());


					}


				}
					break;
				case 2:
				// InternalUmlPort.g:1260:6: (enumLiteral_1= 'union' )
				{
					// InternalUmlPort.g:1260:6: (enumLiteral_1= 'union' )
					// InternalUmlPort.g:1260:8: enumLiteral_1= 'union'
					{
						enumLiteral_1 = (Token) match(input, 34, FOLLOW_2);

						current = grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_1, grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1());


					}


				}
					break;
				case 3:
				// InternalUmlPort.g:1266:6: (enumLiteral_2= 'ordered' )
				{
					// InternalUmlPort.g:1266:6: (enumLiteral_2= 'ordered' )
					// InternalUmlPort.g:1266:8: enumLiteral_2= 'ordered'
					{
						enumLiteral_2 = (Token) match(input, 35, FOLLOW_2);

						current = grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_2, grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2());


					}


				}
					break;
				case 4:
				// InternalUmlPort.g:1272:6: (enumLiteral_3= 'unique' )
				{
					// InternalUmlPort.g:1272:6: (enumLiteral_3= 'unique' )
					// InternalUmlPort.g:1272:8: enumLiteral_3= 'unique'
					{
						enumLiteral_3 = (Token) match(input, 36, FOLLOW_2);

						current = grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_3, grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3());


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
	// $ANTLR end "ruleModifierKind"


	// $ANTLR start "ruleBooleanLiterals"
	// InternalUmlPort.g:1282:1: ruleBooleanLiterals returns [Enumerator current=null] : ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) ) ;
	public final Enumerator ruleBooleanLiterals() throws RecognitionException {
		Enumerator current = null;

		Token enumLiteral_0 = null;
		Token enumLiteral_1 = null;

		enterRule();
		try {
			// InternalUmlPort.g:1284:28: ( ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) ) )
			// InternalUmlPort.g:1285:1: ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) )
			{
				// InternalUmlPort.g:1285:1: ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) )
				int alt21 = 2;
				int LA21_0 = input.LA(1);

				if ((LA21_0 == 37)) {
					alt21 = 1;
				} else if ((LA21_0 == 38)) {
					alt21 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 21, 0, input);

					throw nvae;
				}
				switch (alt21) {
				case 1:
				// InternalUmlPort.g:1285:2: (enumLiteral_0= 'true' )
				{
					// InternalUmlPort.g:1285:2: (enumLiteral_0= 'true' )
					// InternalUmlPort.g:1285:4: enumLiteral_0= 'true'
					{
						enumLiteral_0 = (Token) match(input, 37, FOLLOW_2);

						current = grammarAccess.getBooleanLiteralsAccess().getTRUEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_0, grammarAccess.getBooleanLiteralsAccess().getTRUEEnumLiteralDeclaration_0());


					}


				}
					break;
				case 2:
				// InternalUmlPort.g:1291:6: (enumLiteral_1= 'false' )
				{
					// InternalUmlPort.g:1291:6: (enumLiteral_1= 'false' )
					// InternalUmlPort.g:1291:8: enumLiteral_1= 'false'
					{
						enumLiteral_1 = (Token) match(input, 38, FOLLOW_2);

						current = grammarAccess.getBooleanLiteralsAccess().getFALSEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_1, grammarAccess.getBooleanLiteralsAccess().getFALSEEnumLiteralDeclaration_1());


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
	// $ANTLR end "ruleBooleanLiterals"

	// Delegated rules




	public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x0000000000001010L });
	public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_5 = new BitSet(new long[] { 0x0000000004222002L });
	public static final BitSet FOLLOW_6 = new BitSet(new long[] { 0x000000000000C010L });
	public static final BitSet FOLLOW_7 = new BitSet(new long[] { 0x0000000000008010L });
	public static final BitSet FOLLOW_8 = new BitSet(new long[] { 0x0000000004220002L });
	public static final BitSet FOLLOW_9 = new BitSet(new long[] { 0x0000000004200002L });
	public static final BitSet FOLLOW_10 = new BitSet(new long[] { 0x0000000004000002L });
	public static final BitSet FOLLOW_11 = new BitSet(new long[] { 0x0000000000010000L });
	public static final BitSet FOLLOW_12 = new BitSet(new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_13 = new BitSet(new long[] { 0x0000000000100060L });
	public static final BitSet FOLLOW_14 = new BitSet(new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_15 = new BitSet(new long[] { 0x0000000000080000L });
	public static final BitSet FOLLOW_16 = new BitSet(new long[] { 0x0000001E03800000L });
	public static final BitSet FOLLOW_17 = new BitSet(new long[] { 0x0000000000C00000L });
	public static final BitSet FOLLOW_18 = new BitSet(new long[] { 0x0000001E03000000L });
	public static final BitSet FOLLOW_19 = new BitSet(new long[] { 0x0000006038000060L });
	public static final BitSet FOLLOW_20 = new BitSet(new long[] { 0x0000000008000000L });
	public static final BitSet FOLLOW_21 = new BitSet(new long[] { 0x0000000000000020L });

}