package org.eclipse.papyrus.uml.textedit.message.xtext.parser.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.message.xtext.services.UmlMessageGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;

@SuppressWarnings("all")
public class InternalUmlMessageParser extends AbstractInternalAntlrParser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NAME_RULE", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INTEGER_VALUE", "RULE_WS", "RULE_ANY_OTHER", "'.'", "':'", "'*'", "'['", "']'"
	};
	public static final int RULE_ID = 6;
	public static final int RULE_WS = 11;
	public static final int RULE_STRING = 7;
	public static final int RULE_ANY_OTHER = 12;
	public static final int RULE_SL_COMMENT = 9;
	public static final int T__15 = 15;
	public static final int T__16 = 16;
	public static final int T__17 = 17;
	public static final int RULE_INT = 5;
	public static final int RULE_ML_COMMENT = 8;
	public static final int RULE_INTEGER_VALUE = 10;
	public static final int T__13 = 13;
	public static final int T__14 = 14;
	public static final int EOF = -1;
	public static final int RULE_NAME_RULE = 4;

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
		return "../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g";
	}



	private UmlMessageGrammarAccess grammarAccess;

	public InternalUmlMessageParser(TokenStream input, UmlMessageGrammarAccess grammarAccess) {
		this(input);
		this.grammarAccess = grammarAccess;
		registerRules(grammarAccess.getGrammar());
	}

	@Override
	protected String getFirstRuleName() {
		return "MessageRule";
	}

	@Override
	protected UmlMessageGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}



	// $ANTLR start "entryRuleMessageRule"
	// InternalUmlMessage.g:67:1: entryRuleMessageRule returns [EObject current=null] : iv_ruleMessageRule= ruleMessageRule EOF ;
	public final EObject entryRuleMessageRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleMessageRule = null;


		try {
			// InternalUmlMessage.g:68:2: (iv_ruleMessageRule= ruleMessageRule EOF )
			// InternalUmlMessage.g:69:2: iv_ruleMessageRule= ruleMessageRule EOF
			{
				newCompositeNode(grammarAccess.getMessageRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleMessageRule = ruleMessageRule();

				state._fsp--;

				current = iv_ruleMessageRule;
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
	// $ANTLR end "entryRuleMessageRule"


	// $ANTLR start "ruleMessageRule"
	// InternalUmlMessage.g:76:1: ruleMessageRule returns [EObject current=null] : ( ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) (otherlv_1= '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_NAME_RULE ) ) ) ;
	public final EObject ruleMessageRule() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		Token otherlv_3 = null;
		Token lv_name_4_0 = null;
		EObject lv_sequenceTerm_0_0 = null;

		EObject lv_sequenceTerm_2_0 = null;


		enterRule();

		try {
			// InternalUmlMessage.g:79:28: ( ( ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) (otherlv_1= '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_NAME_RULE ) ) ) )
			// InternalUmlMessage.g:80:1: ( ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) (otherlv_1= '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_NAME_RULE ) ) )
			{
				// InternalUmlMessage.g:80:1: ( ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) (otherlv_1= '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_NAME_RULE ) ) )
				// InternalUmlMessage.g:80:2: ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) (otherlv_1= '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_NAME_RULE ) )
				{
					// InternalUmlMessage.g:80:2: ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) )
					// InternalUmlMessage.g:81:1: (lv_sequenceTerm_0_0= ruleSequenceTermRule )
					{
						// InternalUmlMessage.g:81:1: (lv_sequenceTerm_0_0= ruleSequenceTermRule )
						// InternalUmlMessage.g:82:3: lv_sequenceTerm_0_0= ruleSequenceTermRule
						{

							newCompositeNode(grammarAccess.getMessageRuleAccess().getSequenceTermSequenceTermRuleParserRuleCall_0_0());

							pushFollow(FOLLOW_3);
							lv_sequenceTerm_0_0 = ruleSequenceTermRule();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getMessageRuleRule());
							}
							add(
									current,
									"sequenceTerm",
									lv_sequenceTerm_0_0,
									"org.eclipse.papyrus.uml.textedit.message.xtext.UmlMessage.SequenceTermRule");
							afterParserOrEnumRuleCall();


						}


					}

					// InternalUmlMessage.g:98:2: (otherlv_1= '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )*
					loop1: do {
						int alt1 = 2;
						int LA1_0 = input.LA(1);

						if ((LA1_0 == 13)) {
							alt1 = 1;
						}


						switch (alt1) {
						case 1:
						// InternalUmlMessage.g:98:4: otherlv_1= '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) )
						{
							otherlv_1 = (Token) match(input, 13, FOLLOW_4);

							newLeafNode(otherlv_1, grammarAccess.getMessageRuleAccess().getFullStopKeyword_1_0());

							// InternalUmlMessage.g:102:1: ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) )
							// InternalUmlMessage.g:103:1: (lv_sequenceTerm_2_0= ruleSequenceTermRule )
							{
								// InternalUmlMessage.g:103:1: (lv_sequenceTerm_2_0= ruleSequenceTermRule )
								// InternalUmlMessage.g:104:3: lv_sequenceTerm_2_0= ruleSequenceTermRule
								{

									newCompositeNode(grammarAccess.getMessageRuleAccess().getSequenceTermSequenceTermRuleParserRuleCall_1_1_0());

									pushFollow(FOLLOW_3);
									lv_sequenceTerm_2_0 = ruleSequenceTermRule();

									state._fsp--;


									if (current == null) {
										current = createModelElementForParent(grammarAccess.getMessageRuleRule());
									}
									add(
											current,
											"sequenceTerm",
											lv_sequenceTerm_2_0,
											"org.eclipse.papyrus.uml.textedit.message.xtext.UmlMessage.SequenceTermRule");
									afterParserOrEnumRuleCall();


								}


							}


						}
							break;

						default:
							break loop1;
						}
					} while (true);

					otherlv_3 = (Token) match(input, 14, FOLLOW_5);

					newLeafNode(otherlv_3, grammarAccess.getMessageRuleAccess().getColonKeyword_2());

					// InternalUmlMessage.g:124:1: ( (lv_name_4_0= RULE_NAME_RULE ) )
					// InternalUmlMessage.g:125:1: (lv_name_4_0= RULE_NAME_RULE )
					{
						// InternalUmlMessage.g:125:1: (lv_name_4_0= RULE_NAME_RULE )
						// InternalUmlMessage.g:126:3: lv_name_4_0= RULE_NAME_RULE
						{
							lv_name_4_0 = (Token) match(input, RULE_NAME_RULE, FOLLOW_2);

							newLeafNode(lv_name_4_0, grammarAccess.getMessageRuleAccess().getNameNAME_RULETerminalRuleCall_3_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getMessageRuleRule());
							}
							setWithLastConsumed(
									current,
									"name",
									lv_name_4_0,
									"org.eclipse.papyrus.uml.textedit.message.xtext.UmlMessage.NAME_RULE");


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
	// $ANTLR end "ruleMessageRule"


	// $ANTLR start "entryRuleSequenceTermRule"
	// InternalUmlMessage.g:150:1: entryRuleSequenceTermRule returns [EObject current=null] : iv_ruleSequenceTermRule= ruleSequenceTermRule EOF ;
	public final EObject entryRuleSequenceTermRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSequenceTermRule = null;


		try {
			// InternalUmlMessage.g:151:2: (iv_ruleSequenceTermRule= ruleSequenceTermRule EOF )
			// InternalUmlMessage.g:152:2: iv_ruleSequenceTermRule= ruleSequenceTermRule EOF
			{
				newCompositeNode(grammarAccess.getSequenceTermRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleSequenceTermRule = ruleSequenceTermRule();

				state._fsp--;

				current = iv_ruleSequenceTermRule;
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
	// $ANTLR end "entryRuleSequenceTermRule"


	// $ANTLR start "ruleSequenceTermRule"
	// InternalUmlMessage.g:159:1: ruleSequenceTermRule returns [EObject current=null] : ( ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )? ) ;
	public final EObject ruleSequenceTermRule() throws RecognitionException {
		EObject current = null;

		Token lv_sequencialOrder_0_0 = null;
		Token lv_sequenceName_1_0 = null;
		AntlrDatatypeRuleToken lv_recurrence_2_0 = null;


		enterRule();

		try {
			// InternalUmlMessage.g:162:28: ( ( ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )? ) )
			// InternalUmlMessage.g:163:1: ( ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )? )
			{
				// InternalUmlMessage.g:163:1: ( ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )? )
				// InternalUmlMessage.g:163:2: ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )?
				{
					// InternalUmlMessage.g:163:2: ( (lv_sequencialOrder_0_0= RULE_INT ) )
					// InternalUmlMessage.g:164:1: (lv_sequencialOrder_0_0= RULE_INT )
					{
						// InternalUmlMessage.g:164:1: (lv_sequencialOrder_0_0= RULE_INT )
						// InternalUmlMessage.g:165:3: lv_sequencialOrder_0_0= RULE_INT
						{
							lv_sequencialOrder_0_0 = (Token) match(input, RULE_INT, FOLLOW_6);

							newLeafNode(lv_sequencialOrder_0_0, grammarAccess.getSequenceTermRuleAccess().getSequencialOrderINTTerminalRuleCall_0_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getSequenceTermRuleRule());
							}
							setWithLastConsumed(
									current,
									"sequencialOrder",
									lv_sequencialOrder_0_0,
									"org.eclipse.papyrus.uml.alf.Common.INT");


						}


					}

					// InternalUmlMessage.g:181:2: ( (lv_sequenceName_1_0= RULE_ID ) )?
					int alt2 = 2;
					int LA2_0 = input.LA(1);

					if ((LA2_0 == RULE_ID)) {
						alt2 = 1;
					}
					switch (alt2) {
					case 1:
					// InternalUmlMessage.g:182:1: (lv_sequenceName_1_0= RULE_ID )
					{
						// InternalUmlMessage.g:182:1: (lv_sequenceName_1_0= RULE_ID )
						// InternalUmlMessage.g:183:3: lv_sequenceName_1_0= RULE_ID
						{
							lv_sequenceName_1_0 = (Token) match(input, RULE_ID, FOLLOW_7);

							newLeafNode(lv_sequenceName_1_0, grammarAccess.getSequenceTermRuleAccess().getSequenceNameIDTerminalRuleCall_1_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getSequenceTermRuleRule());
							}
							setWithLastConsumed(
									current,
									"sequenceName",
									lv_sequenceName_1_0,
									"org.eclipse.papyrus.uml.alf.Common.ID");


						}


					}
						break;

					}

					// InternalUmlMessage.g:199:3: ( (lv_recurrence_2_0= ruleRecurrenceRule ) )?
					int alt3 = 2;
					int LA3_0 = input.LA(1);

					if (((LA3_0 >= 15 && LA3_0 <= 16))) {
						alt3 = 1;
					}
					switch (alt3) {
					case 1:
					// InternalUmlMessage.g:200:1: (lv_recurrence_2_0= ruleRecurrenceRule )
					{
						// InternalUmlMessage.g:200:1: (lv_recurrence_2_0= ruleRecurrenceRule )
						// InternalUmlMessage.g:201:3: lv_recurrence_2_0= ruleRecurrenceRule
						{

							newCompositeNode(grammarAccess.getSequenceTermRuleAccess().getRecurrenceRecurrenceRuleParserRuleCall_2_0());

							pushFollow(FOLLOW_2);
							lv_recurrence_2_0 = ruleRecurrenceRule();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getSequenceTermRuleRule());
							}
							set(
									current,
									"recurrence",
									lv_recurrence_2_0,
									"org.eclipse.papyrus.uml.textedit.message.xtext.UmlMessage.RecurrenceRule");
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
	// $ANTLR end "ruleSequenceTermRule"


	// $ANTLR start "entryRuleRecurrenceRule"
	// InternalUmlMessage.g:225:1: entryRuleRecurrenceRule returns [String current=null] : iv_ruleRecurrenceRule= ruleRecurrenceRule EOF ;
	public final String entryRuleRecurrenceRule() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleRecurrenceRule = null;


		try {
			// InternalUmlMessage.g:226:2: (iv_ruleRecurrenceRule= ruleRecurrenceRule EOF )
			// InternalUmlMessage.g:227:2: iv_ruleRecurrenceRule= ruleRecurrenceRule EOF
			{
				newCompositeNode(grammarAccess.getRecurrenceRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleRecurrenceRule = ruleRecurrenceRule();

				state._fsp--;

				current = iv_ruleRecurrenceRule.getText();
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
	// $ANTLR end "entryRuleRecurrenceRule"


	// $ANTLR start "ruleRecurrenceRule"
	// InternalUmlMessage.g:234:1: ruleRecurrenceRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' ) | (kw= '[' this_STRING_5= RULE_STRING kw= ']' ) ) ;
	public final AntlrDatatypeRuleToken ruleRecurrenceRule() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token kw = null;
		Token this_STRING_2 = null;
		Token this_STRING_5 = null;

		enterRule();

		try {
			// InternalUmlMessage.g:237:28: ( ( (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' ) | (kw= '[' this_STRING_5= RULE_STRING kw= ']' ) ) )
			// InternalUmlMessage.g:238:1: ( (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' ) | (kw= '[' this_STRING_5= RULE_STRING kw= ']' ) )
			{
				// InternalUmlMessage.g:238:1: ( (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' ) | (kw= '[' this_STRING_5= RULE_STRING kw= ']' ) )
				int alt4 = 2;
				int LA4_0 = input.LA(1);

				if ((LA4_0 == 15)) {
					alt4 = 1;
				} else if ((LA4_0 == 16)) {
					alt4 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 4, 0, input);

					throw nvae;
				}
				switch (alt4) {
				case 1:
				// InternalUmlMessage.g:238:2: (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' )
				{
					// InternalUmlMessage.g:238:2: (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' )
					// InternalUmlMessage.g:239:2: kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']'
					{
						kw = (Token) match(input, 15, FOLLOW_8);

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getAsteriskKeyword_0_0());

						kw = (Token) match(input, 16, FOLLOW_9);

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getLeftSquareBracketKeyword_0_1());

						this_STRING_2 = (Token) match(input, RULE_STRING, FOLLOW_10);

						current.merge(this_STRING_2);


						newLeafNode(this_STRING_2, grammarAccess.getRecurrenceRuleAccess().getSTRINGTerminalRuleCall_0_2());

						kw = (Token) match(input, 17, FOLLOW_2);

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getRightSquareBracketKeyword_0_3());


					}


				}
					break;
				case 2:
				// InternalUmlMessage.g:264:6: (kw= '[' this_STRING_5= RULE_STRING kw= ']' )
				{
					// InternalUmlMessage.g:264:6: (kw= '[' this_STRING_5= RULE_STRING kw= ']' )
					// InternalUmlMessage.g:265:2: kw= '[' this_STRING_5= RULE_STRING kw= ']'
					{
						kw = (Token) match(input, 16, FOLLOW_9);

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getLeftSquareBracketKeyword_1_0());

						this_STRING_5 = (Token) match(input, RULE_STRING, FOLLOW_10);

						current.merge(this_STRING_5);


						newLeafNode(this_STRING_5, grammarAccess.getRecurrenceRuleAccess().getSTRINGTerminalRuleCall_1_1());

						kw = (Token) match(input, 17, FOLLOW_2);

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getRightSquareBracketKeyword_1_2());


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
	// $ANTLR end "ruleRecurrenceRule"

	// Delegated rules




	public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x0000000000006000L });
	public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_5 = new BitSet(new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_6 = new BitSet(new long[] { 0x0000000000018042L });
	public static final BitSet FOLLOW_7 = new BitSet(new long[] { 0x0000000000018002L });
	public static final BitSet FOLLOW_8 = new BitSet(new long[] { 0x0000000000010000L });
	public static final BitSet FOLLOW_9 = new BitSet(new long[] { 0x0000000000000080L });
	public static final BitSet FOLLOW_10 = new BitSet(new long[] { 0x0000000000020000L });

}