package org.eclipse.papyrus.uml.textedit.common.xtext.parser.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.common.xtext.services.UmlCommonGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;

@SuppressWarnings("all")
public class InternalUmlCommonParser extends AbstractInternalAntlrParser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INTEGER_VALUE", "RULE_WS", "RULE_ANY_OTHER", "'::'", "'*'"
	};
	public static final int RULE_ID = 4;
	public static final int RULE_WS = 10;
	public static final int RULE_STRING = 6;
	public static final int RULE_ANY_OTHER = 11;
	public static final int RULE_SL_COMMENT = 8;
	public static final int RULE_INT = 5;
	public static final int RULE_ML_COMMENT = 7;
	public static final int RULE_INTEGER_VALUE = 9;
	public static final int T__12 = 12;
	public static final int T__13 = 13;
	public static final int EOF = -1;

	// delegates
	// delegators


	public InternalUmlCommonParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalUmlCommonParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);

	}


	public String[] getTokenNames() {
		return InternalUmlCommonParser.tokenNames;
	}

	public String getGrammarFileName() {
		return "../org.eclipse.papyrus.uml.textedit.common.xtext/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/parser/antlr/internal/InternalUmlCommon.g";
	}



	private UmlCommonGrammarAccess grammarAccess;

	public InternalUmlCommonParser(TokenStream input, UmlCommonGrammarAccess grammarAccess) {
		this(input);
		this.grammarAccess = grammarAccess;
		registerRules(grammarAccess.getGrammar());
	}

	@Override
	protected String getFirstRuleName() {
		return "QualifiedName";
	}

	@Override
	protected UmlCommonGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}



	// $ANTLR start "entryRuleQualifiedName"
	// InternalUmlCommon.g:68:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
	public final EObject entryRuleQualifiedName() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleQualifiedName = null;


		try {
			// InternalUmlCommon.g:69:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
			// InternalUmlCommon.g:70:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
	// InternalUmlCommon.g:77:1: ruleQualifiedName returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
	public final EObject ruleQualifiedName() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_1 = null;
		EObject lv_remaining_2_0 = null;


		enterRule();

		try {
			// InternalUmlCommon.g:80:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
			// InternalUmlCommon.g:81:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
			{
				// InternalUmlCommon.g:81:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
				// InternalUmlCommon.g:81:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
				{
					// InternalUmlCommon.g:81:2: ( (otherlv_0= RULE_ID ) )
					// InternalUmlCommon.g:82:1: (otherlv_0= RULE_ID )
					{
						// InternalUmlCommon.g:82:1: (otherlv_0= RULE_ID )
						// InternalUmlCommon.g:83:3: otherlv_0= RULE_ID
						{

							if (current == null) {
								current = createModelElement(grammarAccess.getQualifiedNameRule());
							}

							otherlv_0 = (Token) match(input, RULE_ID, FOLLOW_3);

							newLeafNode(otherlv_0, grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0());


						}


					}

					otherlv_1 = (Token) match(input, 12, FOLLOW_4);

					newLeafNode(otherlv_1, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());

					// InternalUmlCommon.g:98:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if ((LA1_0 == RULE_ID)) {
						alt1 = 1;
					}
					switch (alt1) {
					case 1:
					// InternalUmlCommon.g:99:1: (lv_remaining_2_0= ruleQualifiedName )
					{
						// InternalUmlCommon.g:99:1: (lv_remaining_2_0= ruleQualifiedName )
						// InternalUmlCommon.g:100:3: lv_remaining_2_0= ruleQualifiedName
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
	// InternalUmlCommon.g:128:1: entryRuleBoundSpecification returns [EObject current=null] : iv_ruleBoundSpecification= ruleBoundSpecification EOF ;
	public final EObject entryRuleBoundSpecification() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleBoundSpecification = null;


		try {
			// InternalUmlCommon.g:129:2: (iv_ruleBoundSpecification= ruleBoundSpecification EOF )
			// InternalUmlCommon.g:130:2: iv_ruleBoundSpecification= ruleBoundSpecification EOF
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
	// InternalUmlCommon.g:137:1: ruleBoundSpecification returns [EObject current=null] : ( (lv_value_0_0= ruleUnlimitedLiteral ) ) ;
	public final EObject ruleBoundSpecification() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_value_0_0 = null;


		enterRule();

		try {
			// InternalUmlCommon.g:140:28: ( ( (lv_value_0_0= ruleUnlimitedLiteral ) ) )
			// InternalUmlCommon.g:141:1: ( (lv_value_0_0= ruleUnlimitedLiteral ) )
			{
				// InternalUmlCommon.g:141:1: ( (lv_value_0_0= ruleUnlimitedLiteral ) )
				// InternalUmlCommon.g:142:1: (lv_value_0_0= ruleUnlimitedLiteral )
				{
					// InternalUmlCommon.g:142:1: (lv_value_0_0= ruleUnlimitedLiteral )
					// InternalUmlCommon.g:143:3: lv_value_0_0= ruleUnlimitedLiteral
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
	// InternalUmlCommon.g:167:1: entryRuleUnlimitedLiteral returns [String current=null] : iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF ;
	public final String entryRuleUnlimitedLiteral() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleUnlimitedLiteral = null;


		try {
			// InternalUmlCommon.g:168:2: (iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF )
			// InternalUmlCommon.g:169:2: iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF
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
	// InternalUmlCommon.g:176:1: ruleUnlimitedLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
	public final AntlrDatatypeRuleToken ruleUnlimitedLiteral() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_INT_0 = null;
		Token kw = null;

		enterRule();

		try {
			// InternalUmlCommon.g:179:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
			// InternalUmlCommon.g:180:1: (this_INT_0= RULE_INT | kw= '*' )
			{
				// InternalUmlCommon.g:180:1: (this_INT_0= RULE_INT | kw= '*' )
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
				// InternalUmlCommon.g:180:6: this_INT_0= RULE_INT
				{
					this_INT_0 = (Token) match(input, RULE_INT, FOLLOW_2);

					current.merge(this_INT_0);


					newLeafNode(this_INT_0, grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0());


				}
					break;
				case 2:
				// InternalUmlCommon.g:189:2: kw= '*'
				{
					kw = (Token) match(input, 13, FOLLOW_2);

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

	// Delegated rules




	public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x0000000000001000L });
	public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x0000000000000012L });

}