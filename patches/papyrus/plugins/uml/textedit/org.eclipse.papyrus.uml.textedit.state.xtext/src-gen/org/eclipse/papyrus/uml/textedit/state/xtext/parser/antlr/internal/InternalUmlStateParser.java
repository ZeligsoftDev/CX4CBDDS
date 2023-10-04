package org.eclipse.papyrus.uml.textedit.state.xtext.parser.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.state.xtext.services.UmlStateGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;

@SuppressWarnings("all")
public class InternalUmlStateParser extends AbstractInternalAntlrParser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INT", "RULE_INTEGER_VALUE", "RULE_WS", "RULE_ANY_OTHER", "':'", "'::'", "'entry'", "'do'", "'exit'", "'Activity'", "'StateMachine'",
			"'OpaqueBehavior'"
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
		return "../org.eclipse.papyrus.uml.textedit.state.xtext/src-gen/org/eclipse/papyrus/uml/textedit/state/xtext/parser/antlr/internal/InternalUmlState.g";
	}



	private UmlStateGrammarAccess grammarAccess;

	public InternalUmlStateParser(TokenStream input, UmlStateGrammarAccess grammarAccess) {
		this(input);
		this.grammarAccess = grammarAccess;
		registerRules(grammarAccess.getGrammar());
	}

	@Override
	protected String getFirstRuleName() {
		return "StateRule";
	}

	@Override
	protected UmlStateGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}



	// $ANTLR start "entryRuleStateRule"
	// InternalUmlState.g:68:1: entryRuleStateRule returns [EObject current=null] : iv_ruleStateRule= ruleStateRule EOF ;
	public final EObject entryRuleStateRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleStateRule = null;


		try {
			// InternalUmlState.g:69:2: (iv_ruleStateRule= ruleStateRule EOF )
			// InternalUmlState.g:70:2: iv_ruleStateRule= ruleStateRule EOF
			{
				newCompositeNode(grammarAccess.getStateRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleStateRule = ruleStateRule();

				state._fsp--;

				current = iv_ruleStateRule;
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
	// $ANTLR end "entryRuleStateRule"


	// $ANTLR start "ruleStateRule"
	// InternalUmlState.g:77:1: ruleStateRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_submachine_2_0= ruleSubmachineRule ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) ) ) | ({...}? => (
	// ({...}? => ( (lv_do_5_0= ruleDoRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) ) ) )* ) ) ) ) ;
	public final EObject ruleStateRule() throws RecognitionException {
		EObject current = null;

		Token lv_name_0_0 = null;
		Token otherlv_1 = null;
		EObject lv_submachine_2_0 = null;

		EObject lv_entry_4_0 = null;

		EObject lv_do_5_0 = null;

		EObject lv_exit_6_0 = null;


		enterRule();

		try {
			// InternalUmlState.g:80:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_submachine_2_0= ruleSubmachineRule ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_do_5_0= ruleDoRule
			// ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) ) ) )* ) ) ) ) )
			// InternalUmlState.g:81:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_submachine_2_0= ruleSubmachineRule ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_do_5_0= ruleDoRule )
			// ) ) ) ) | ({...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) ) ) )* ) ) ) )
			{
				// InternalUmlState.g:81:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_submachine_2_0= ruleSubmachineRule ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_do_5_0=
				// ruleDoRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) ) ) )* ) ) ) )
				// InternalUmlState.g:81:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_submachine_2_0= ruleSubmachineRule ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_do_5_0= ruleDoRule
				// ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) ) ) )* ) ) )
				{
					// InternalUmlState.g:81:2: ( (lv_name_0_0= RULE_ID ) )
					// InternalUmlState.g:82:1: (lv_name_0_0= RULE_ID )
					{
						// InternalUmlState.g:82:1: (lv_name_0_0= RULE_ID )
						// InternalUmlState.g:83:3: lv_name_0_0= RULE_ID
						{
							lv_name_0_0 = (Token) match(input, RULE_ID, FOLLOW_3);

							newLeafNode(lv_name_0_0, grammarAccess.getStateRuleAccess().getNameIDTerminalRuleCall_0_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getStateRuleRule());
							}
							setWithLastConsumed(
									current,
									"name",
									lv_name_0_0,
									"org.eclipse.papyrus.uml.alf.Common.ID");


						}


					}

					// InternalUmlState.g:99:2: (otherlv_1= ':' ( (lv_submachine_2_0= ruleSubmachineRule ) ) )?
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if ((LA1_0 == 12)) {
						alt1 = 1;
					}
					switch (alt1) {
					case 1:
					// InternalUmlState.g:99:4: otherlv_1= ':' ( (lv_submachine_2_0= ruleSubmachineRule ) )
					{
						otherlv_1 = (Token) match(input, 12, FOLLOW_4);

						newLeafNode(otherlv_1, grammarAccess.getStateRuleAccess().getColonKeyword_1_0());

						// InternalUmlState.g:103:1: ( (lv_submachine_2_0= ruleSubmachineRule ) )
						// InternalUmlState.g:104:1: (lv_submachine_2_0= ruleSubmachineRule )
						{
							// InternalUmlState.g:104:1: (lv_submachine_2_0= ruleSubmachineRule )
							// InternalUmlState.g:105:3: lv_submachine_2_0= ruleSubmachineRule
							{

								newCompositeNode(grammarAccess.getStateRuleAccess().getSubmachineSubmachineRuleParserRuleCall_1_1_0());

								pushFollow(FOLLOW_5);
								lv_submachine_2_0 = ruleSubmachineRule();

								state._fsp--;


								if (current == null) {
									current = createModelElementForParent(grammarAccess.getStateRuleRule());
								}
								set(
										current,
										"submachine",
										lv_submachine_2_0,
										"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.SubmachineRule");
								afterParserOrEnumRuleCall();


							}


						}


					}
						break;

					}

					// InternalUmlState.g:121:4: ( ( ( ( ({...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_do_5_0= ruleDoRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) ) ) )* ) ) )
					// InternalUmlState.g:123:1: ( ( ( ({...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_do_5_0= ruleDoRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) ) ) )* ) )
					{
						// InternalUmlState.g:123:1: ( ( ( ({...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_do_5_0= ruleDoRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) ) ) )* ) )
						// InternalUmlState.g:124:2: ( ( ({...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_do_5_0= ruleDoRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) ) ) )* )
						{

							getUnorderedGroupHelper().enter(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());

							// InternalUmlState.g:127:2: ( ( ({...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_do_5_0= ruleDoRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) ) ) )* )
							// InternalUmlState.g:128:3: ( ({...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_do_5_0= ruleDoRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) ) ) )*
							{
								// InternalUmlState.g:128:3: ( ({...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_do_5_0= ruleDoRule ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) ) ) )*
								loop2: do {
									int alt2 = 4;
									int LA2_0 = input.LA(1);

									if (LA2_0 == 14 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0)) {
										alt2 = 1;
									} else if (LA2_0 == 15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1)) {
										alt2 = 2;
									} else if (LA2_0 == 16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2)) {
										alt2 = 3;
									}


									switch (alt2) {
									case 1:
									// InternalUmlState.g:130:4: ({...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) ) )
									{
										// InternalUmlState.g:130:4: ({...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) ) )
										// InternalUmlState.g:131:5: {...}? => ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) )
										{
											if (!getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0)) {
												throw new FailedPredicateException(input, "ruleStateRule", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0)");
											}
											// InternalUmlState.g:131:106: ( ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) ) )
											// InternalUmlState.g:132:6: ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) )
											{

												getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0);

												// InternalUmlState.g:135:6: ({...}? => ( (lv_entry_4_0= ruleEntryRule ) ) )
												// InternalUmlState.g:135:7: {...}? => ( (lv_entry_4_0= ruleEntryRule ) )
												{
													if (!((true))) {
														throw new FailedPredicateException(input, "ruleStateRule", "true");
													}
													// InternalUmlState.g:135:16: ( (lv_entry_4_0= ruleEntryRule ) )
													// InternalUmlState.g:136:1: (lv_entry_4_0= ruleEntryRule )
													{
														// InternalUmlState.g:136:1: (lv_entry_4_0= ruleEntryRule )
														// InternalUmlState.g:137:3: lv_entry_4_0= ruleEntryRule
														{

															newCompositeNode(grammarAccess.getStateRuleAccess().getEntryEntryRuleParserRuleCall_2_0_0());

															pushFollow(FOLLOW_5);
															lv_entry_4_0 = ruleEntryRule();

															state._fsp--;


															if (current == null) {
																current = createModelElementForParent(grammarAccess.getStateRuleRule());
															}
															set(
																	current,
																	"entry",
																	lv_entry_4_0,
																	"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.EntryRule");
															afterParserOrEnumRuleCall();


														}


													}


												}


												getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());


											}


										}


									}
										break;
									case 2:
									// InternalUmlState.g:160:4: ({...}? => ( ({...}? => ( (lv_do_5_0= ruleDoRule ) ) ) ) )
									{
										// InternalUmlState.g:160:4: ({...}? => ( ({...}? => ( (lv_do_5_0= ruleDoRule ) ) ) ) )
										// InternalUmlState.g:161:5: {...}? => ( ({...}? => ( (lv_do_5_0= ruleDoRule ) ) ) )
										{
											if (!getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1)) {
												throw new FailedPredicateException(input, "ruleStateRule", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1)");
											}
											// InternalUmlState.g:161:106: ( ({...}? => ( (lv_do_5_0= ruleDoRule ) ) ) )
											// InternalUmlState.g:162:6: ({...}? => ( (lv_do_5_0= ruleDoRule ) ) )
											{

												getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1);

												// InternalUmlState.g:165:6: ({...}? => ( (lv_do_5_0= ruleDoRule ) ) )
												// InternalUmlState.g:165:7: {...}? => ( (lv_do_5_0= ruleDoRule ) )
												{
													if (!((true))) {
														throw new FailedPredicateException(input, "ruleStateRule", "true");
													}
													// InternalUmlState.g:165:16: ( (lv_do_5_0= ruleDoRule ) )
													// InternalUmlState.g:166:1: (lv_do_5_0= ruleDoRule )
													{
														// InternalUmlState.g:166:1: (lv_do_5_0= ruleDoRule )
														// InternalUmlState.g:167:3: lv_do_5_0= ruleDoRule
														{

															newCompositeNode(grammarAccess.getStateRuleAccess().getDoDoRuleParserRuleCall_2_1_0());

															pushFollow(FOLLOW_5);
															lv_do_5_0 = ruleDoRule();

															state._fsp--;


															if (current == null) {
																current = createModelElementForParent(grammarAccess.getStateRuleRule());
															}
															set(
																	current,
																	"do",
																	lv_do_5_0,
																	"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.DoRule");
															afterParserOrEnumRuleCall();


														}


													}


												}


												getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());


											}


										}


									}
										break;
									case 3:
									// InternalUmlState.g:190:4: ({...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) ) )
									{
										// InternalUmlState.g:190:4: ({...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) ) )
										// InternalUmlState.g:191:5: {...}? => ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) )
										{
											if (!getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2)) {
												throw new FailedPredicateException(input, "ruleStateRule", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2)");
											}
											// InternalUmlState.g:191:106: ( ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) ) )
											// InternalUmlState.g:192:6: ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) )
											{

												getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2);

												// InternalUmlState.g:195:6: ({...}? => ( (lv_exit_6_0= ruleExitRule ) ) )
												// InternalUmlState.g:195:7: {...}? => ( (lv_exit_6_0= ruleExitRule ) )
												{
													if (!((true))) {
														throw new FailedPredicateException(input, "ruleStateRule", "true");
													}
													// InternalUmlState.g:195:16: ( (lv_exit_6_0= ruleExitRule ) )
													// InternalUmlState.g:196:1: (lv_exit_6_0= ruleExitRule )
													{
														// InternalUmlState.g:196:1: (lv_exit_6_0= ruleExitRule )
														// InternalUmlState.g:197:3: lv_exit_6_0= ruleExitRule
														{

															newCompositeNode(grammarAccess.getStateRuleAccess().getExitExitRuleParserRuleCall_2_2_0());

															pushFollow(FOLLOW_5);
															lv_exit_6_0 = ruleExitRule();

															state._fsp--;


															if (current == null) {
																current = createModelElementForParent(grammarAccess.getStateRuleRule());
															}
															set(
																	current,
																	"exit",
																	lv_exit_6_0,
																	"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.ExitRule");
															afterParserOrEnumRuleCall();


														}


													}


												}


												getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());


											}


										}


									}
										break;

									default:
										break loop2;
									}
								} while (true);


							}


						}


						getUnorderedGroupHelper().leave(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());


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
	// $ANTLR end "ruleStateRule"


	// $ANTLR start "entryRuleSubmachineRule"
	// InternalUmlState.g:235:1: entryRuleSubmachineRule returns [EObject current=null] : iv_ruleSubmachineRule= ruleSubmachineRule EOF ;
	public final EObject entryRuleSubmachineRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSubmachineRule = null;


		try {
			// InternalUmlState.g:236:2: (iv_ruleSubmachineRule= ruleSubmachineRule EOF )
			// InternalUmlState.g:237:2: iv_ruleSubmachineRule= ruleSubmachineRule EOF
			{
				newCompositeNode(grammarAccess.getSubmachineRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleSubmachineRule = ruleSubmachineRule();

				state._fsp--;

				current = iv_ruleSubmachineRule;
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
	// $ANTLR end "entryRuleSubmachineRule"


	// $ANTLR start "ruleSubmachineRule"
	// InternalUmlState.g:244:1: ruleSubmachineRule returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
	public final EObject ruleSubmachineRule() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		EObject lv_path_0_0 = null;


		enterRule();

		try {
			// InternalUmlState.g:247:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
			// InternalUmlState.g:248:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
			{
				// InternalUmlState.g:248:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
				// InternalUmlState.g:248:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
				{
					// InternalUmlState.g:248:2: ( (lv_path_0_0= ruleQualifiedName ) )?
					int alt3 = 2;
					int LA3_0 = input.LA(1);

					if ((LA3_0 == RULE_ID)) {
						int LA3_1 = input.LA(2);

						if ((LA3_1 == 13)) {
							alt3 = 1;
						}
					}
					switch (alt3) {
					case 1:
					// InternalUmlState.g:249:1: (lv_path_0_0= ruleQualifiedName )
					{
						// InternalUmlState.g:249:1: (lv_path_0_0= ruleQualifiedName )
						// InternalUmlState.g:250:3: lv_path_0_0= ruleQualifiedName
						{

							newCompositeNode(grammarAccess.getSubmachineRuleAccess().getPathQualifiedNameParserRuleCall_0_0());

							pushFollow(FOLLOW_4);
							lv_path_0_0 = ruleQualifiedName();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getSubmachineRuleRule());
							}
							set(
									current,
									"path",
									lv_path_0_0,
									"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.QualifiedName");
							afterParserOrEnumRuleCall();


						}


					}
						break;

					}

					// InternalUmlState.g:266:3: ( (otherlv_1= RULE_ID ) )
					// InternalUmlState.g:267:1: (otherlv_1= RULE_ID )
					{
						// InternalUmlState.g:267:1: (otherlv_1= RULE_ID )
						// InternalUmlState.g:268:3: otherlv_1= RULE_ID
						{

							if (current == null) {
								current = createModelElement(grammarAccess.getSubmachineRuleRule());
							}

							otherlv_1 = (Token) match(input, RULE_ID, FOLLOW_2);

							newLeafNode(otherlv_1, grammarAccess.getSubmachineRuleAccess().getSubmachineStateMachineCrossReference_1_0());


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
	// $ANTLR end "ruleSubmachineRule"


	// $ANTLR start "entryRuleQualifiedName"
	// InternalUmlState.g:287:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
	public final EObject entryRuleQualifiedName() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleQualifiedName = null;


		try {
			// InternalUmlState.g:288:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
			// InternalUmlState.g:289:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
	// InternalUmlState.g:296:1: ruleQualifiedName returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
	public final EObject ruleQualifiedName() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_1 = null;
		EObject lv_remaining_2_0 = null;


		enterRule();

		try {
			// InternalUmlState.g:299:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
			// InternalUmlState.g:300:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
			{
				// InternalUmlState.g:300:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
				// InternalUmlState.g:300:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
				{
					// InternalUmlState.g:300:2: ( (otherlv_0= RULE_ID ) )
					// InternalUmlState.g:301:1: (otherlv_0= RULE_ID )
					{
						// InternalUmlState.g:301:1: (otherlv_0= RULE_ID )
						// InternalUmlState.g:302:3: otherlv_0= RULE_ID
						{

							if (current == null) {
								current = createModelElement(grammarAccess.getQualifiedNameRule());
							}

							otherlv_0 = (Token) match(input, RULE_ID, FOLLOW_6);

							newLeafNode(otherlv_0, grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0());


						}


					}

					otherlv_1 = (Token) match(input, 13, FOLLOW_7);

					newLeafNode(otherlv_1, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());

					// InternalUmlState.g:317:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if ((LA4_0 == RULE_ID)) {
						int LA4_1 = input.LA(2);

						if ((LA4_1 == 13)) {
							alt4 = 1;
						}
					}
					switch (alt4) {
					case 1:
					// InternalUmlState.g:318:1: (lv_remaining_2_0= ruleQualifiedName )
					{
						// InternalUmlState.g:318:1: (lv_remaining_2_0= ruleQualifiedName )
						// InternalUmlState.g:319:3: lv_remaining_2_0= ruleQualifiedName
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
									"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.QualifiedName");
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


	// $ANTLR start "entryRuleEntryRule"
	// InternalUmlState.g:343:1: entryRuleEntryRule returns [EObject current=null] : iv_ruleEntryRule= ruleEntryRule EOF ;
	public final EObject entryRuleEntryRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleEntryRule = null;


		try {
			// InternalUmlState.g:344:2: (iv_ruleEntryRule= ruleEntryRule EOF )
			// InternalUmlState.g:345:2: iv_ruleEntryRule= ruleEntryRule EOF
			{
				newCompositeNode(grammarAccess.getEntryRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleEntryRule = ruleEntryRule();

				state._fsp--;

				current = iv_ruleEntryRule;
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
	// $ANTLR end "entryRuleEntryRule"


	// $ANTLR start "ruleEntryRule"
	// InternalUmlState.g:352:1: ruleEntryRule returns [EObject current=null] : (otherlv_0= 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) ;
	public final EObject ruleEntryRule() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token lv_behaviorName_2_0 = null;
		Enumerator lv_kind_1_0 = null;


		enterRule();

		try {
			// InternalUmlState.g:355:28: ( (otherlv_0= 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) )
			// InternalUmlState.g:356:1: (otherlv_0= 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
			{
				// InternalUmlState.g:356:1: (otherlv_0= 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
				// InternalUmlState.g:356:3: otherlv_0= 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) )
				{
					otherlv_0 = (Token) match(input, 14, FOLLOW_8);

					newLeafNode(otherlv_0, grammarAccess.getEntryRuleAccess().getEntryKeyword_0());

					// InternalUmlState.g:360:1: ( (lv_kind_1_0= ruleBehaviorKind ) )
					// InternalUmlState.g:361:1: (lv_kind_1_0= ruleBehaviorKind )
					{
						// InternalUmlState.g:361:1: (lv_kind_1_0= ruleBehaviorKind )
						// InternalUmlState.g:362:3: lv_kind_1_0= ruleBehaviorKind
						{

							newCompositeNode(grammarAccess.getEntryRuleAccess().getKindBehaviorKindEnumRuleCall_1_0());

							pushFollow(FOLLOW_4);
							lv_kind_1_0 = ruleBehaviorKind();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getEntryRuleRule());
							}
							set(
									current,
									"kind",
									lv_kind_1_0,
									"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.BehaviorKind");
							afterParserOrEnumRuleCall();


						}


					}

					// InternalUmlState.g:378:2: ( (lv_behaviorName_2_0= RULE_ID ) )
					// InternalUmlState.g:379:1: (lv_behaviorName_2_0= RULE_ID )
					{
						// InternalUmlState.g:379:1: (lv_behaviorName_2_0= RULE_ID )
						// InternalUmlState.g:380:3: lv_behaviorName_2_0= RULE_ID
						{
							lv_behaviorName_2_0 = (Token) match(input, RULE_ID, FOLLOW_2);

							newLeafNode(lv_behaviorName_2_0, grammarAccess.getEntryRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getEntryRuleRule());
							}
							setWithLastConsumed(
									current,
									"behaviorName",
									lv_behaviorName_2_0,
									"org.eclipse.papyrus.uml.alf.Common.ID");


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
	// $ANTLR end "ruleEntryRule"


	// $ANTLR start "entryRuleDoRule"
	// InternalUmlState.g:404:1: entryRuleDoRule returns [EObject current=null] : iv_ruleDoRule= ruleDoRule EOF ;
	public final EObject entryRuleDoRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleDoRule = null;


		try {
			// InternalUmlState.g:405:2: (iv_ruleDoRule= ruleDoRule EOF )
			// InternalUmlState.g:406:2: iv_ruleDoRule= ruleDoRule EOF
			{
				newCompositeNode(grammarAccess.getDoRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleDoRule = ruleDoRule();

				state._fsp--;

				current = iv_ruleDoRule;
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
	// $ANTLR end "entryRuleDoRule"


	// $ANTLR start "ruleDoRule"
	// InternalUmlState.g:413:1: ruleDoRule returns [EObject current=null] : (otherlv_0= 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) ;
	public final EObject ruleDoRule() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token lv_behaviorName_2_0 = null;
		Enumerator lv_kind_1_0 = null;


		enterRule();

		try {
			// InternalUmlState.g:416:28: ( (otherlv_0= 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) )
			// InternalUmlState.g:417:1: (otherlv_0= 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
			{
				// InternalUmlState.g:417:1: (otherlv_0= 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
				// InternalUmlState.g:417:3: otherlv_0= 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) )
				{
					otherlv_0 = (Token) match(input, 15, FOLLOW_8);

					newLeafNode(otherlv_0, grammarAccess.getDoRuleAccess().getDoKeyword_0());

					// InternalUmlState.g:421:1: ( (lv_kind_1_0= ruleBehaviorKind ) )
					// InternalUmlState.g:422:1: (lv_kind_1_0= ruleBehaviorKind )
					{
						// InternalUmlState.g:422:1: (lv_kind_1_0= ruleBehaviorKind )
						// InternalUmlState.g:423:3: lv_kind_1_0= ruleBehaviorKind
						{

							newCompositeNode(grammarAccess.getDoRuleAccess().getKindBehaviorKindEnumRuleCall_1_0());

							pushFollow(FOLLOW_4);
							lv_kind_1_0 = ruleBehaviorKind();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getDoRuleRule());
							}
							set(
									current,
									"kind",
									lv_kind_1_0,
									"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.BehaviorKind");
							afterParserOrEnumRuleCall();


						}


					}

					// InternalUmlState.g:439:2: ( (lv_behaviorName_2_0= RULE_ID ) )
					// InternalUmlState.g:440:1: (lv_behaviorName_2_0= RULE_ID )
					{
						// InternalUmlState.g:440:1: (lv_behaviorName_2_0= RULE_ID )
						// InternalUmlState.g:441:3: lv_behaviorName_2_0= RULE_ID
						{
							lv_behaviorName_2_0 = (Token) match(input, RULE_ID, FOLLOW_2);

							newLeafNode(lv_behaviorName_2_0, grammarAccess.getDoRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getDoRuleRule());
							}
							setWithLastConsumed(
									current,
									"behaviorName",
									lv_behaviorName_2_0,
									"org.eclipse.papyrus.uml.alf.Common.ID");


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
	// $ANTLR end "ruleDoRule"


	// $ANTLR start "entryRuleExitRule"
	// InternalUmlState.g:465:1: entryRuleExitRule returns [EObject current=null] : iv_ruleExitRule= ruleExitRule EOF ;
	public final EObject entryRuleExitRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleExitRule = null;


		try {
			// InternalUmlState.g:466:2: (iv_ruleExitRule= ruleExitRule EOF )
			// InternalUmlState.g:467:2: iv_ruleExitRule= ruleExitRule EOF
			{
				newCompositeNode(grammarAccess.getExitRuleRule());
				pushFollow(FOLLOW_1);
				iv_ruleExitRule = ruleExitRule();

				state._fsp--;

				current = iv_ruleExitRule;
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
	// $ANTLR end "entryRuleExitRule"


	// $ANTLR start "ruleExitRule"
	// InternalUmlState.g:474:1: ruleExitRule returns [EObject current=null] : (otherlv_0= 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) ;
	public final EObject ruleExitRule() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token lv_behaviorName_2_0 = null;
		Enumerator lv_kind_1_0 = null;


		enterRule();

		try {
			// InternalUmlState.g:477:28: ( (otherlv_0= 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) )
			// InternalUmlState.g:478:1: (otherlv_0= 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
			{
				// InternalUmlState.g:478:1: (otherlv_0= 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
				// InternalUmlState.g:478:3: otherlv_0= 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) )
				{
					otherlv_0 = (Token) match(input, 16, FOLLOW_8);

					newLeafNode(otherlv_0, grammarAccess.getExitRuleAccess().getExitKeyword_0());

					// InternalUmlState.g:482:1: ( (lv_kind_1_0= ruleBehaviorKind ) )
					// InternalUmlState.g:483:1: (lv_kind_1_0= ruleBehaviorKind )
					{
						// InternalUmlState.g:483:1: (lv_kind_1_0= ruleBehaviorKind )
						// InternalUmlState.g:484:3: lv_kind_1_0= ruleBehaviorKind
						{

							newCompositeNode(grammarAccess.getExitRuleAccess().getKindBehaviorKindEnumRuleCall_1_0());

							pushFollow(FOLLOW_4);
							lv_kind_1_0 = ruleBehaviorKind();

							state._fsp--;


							if (current == null) {
								current = createModelElementForParent(grammarAccess.getExitRuleRule());
							}
							set(
									current,
									"kind",
									lv_kind_1_0,
									"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.BehaviorKind");
							afterParserOrEnumRuleCall();


						}


					}

					// InternalUmlState.g:500:2: ( (lv_behaviorName_2_0= RULE_ID ) )
					// InternalUmlState.g:501:1: (lv_behaviorName_2_0= RULE_ID )
					{
						// InternalUmlState.g:501:1: (lv_behaviorName_2_0= RULE_ID )
						// InternalUmlState.g:502:3: lv_behaviorName_2_0= RULE_ID
						{
							lv_behaviorName_2_0 = (Token) match(input, RULE_ID, FOLLOW_2);

							newLeafNode(lv_behaviorName_2_0, grammarAccess.getExitRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0());


							if (current == null) {
								current = createModelElement(grammarAccess.getExitRuleRule());
							}
							setWithLastConsumed(
									current,
									"behaviorName",
									lv_behaviorName_2_0,
									"org.eclipse.papyrus.uml.alf.Common.ID");


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
	// $ANTLR end "ruleExitRule"


	// $ANTLR start "ruleBehaviorKind"
	// InternalUmlState.g:526:1: ruleBehaviorKind returns [Enumerator current=null] : ( (enumLiteral_0= 'Activity' ) | (enumLiteral_1= 'StateMachine' ) | (enumLiteral_2= 'OpaqueBehavior' ) ) ;
	public final Enumerator ruleBehaviorKind() throws RecognitionException {
		Enumerator current = null;

		Token enumLiteral_0 = null;
		Token enumLiteral_1 = null;
		Token enumLiteral_2 = null;

		enterRule();
		try {
			// InternalUmlState.g:528:28: ( ( (enumLiteral_0= 'Activity' ) | (enumLiteral_1= 'StateMachine' ) | (enumLiteral_2= 'OpaqueBehavior' ) ) )
			// InternalUmlState.g:529:1: ( (enumLiteral_0= 'Activity' ) | (enumLiteral_1= 'StateMachine' ) | (enumLiteral_2= 'OpaqueBehavior' ) )
			{
				// InternalUmlState.g:529:1: ( (enumLiteral_0= 'Activity' ) | (enumLiteral_1= 'StateMachine' ) | (enumLiteral_2= 'OpaqueBehavior' ) )
				int alt5 = 3;
				switch (input.LA(1)) {
				case 17: {
					alt5 = 1;
				}
					break;
				case 18: {
					alt5 = 2;
				}
					break;
				case 19: {
					alt5 = 3;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("", 5, 0, input);

					throw nvae;
				}

				switch (alt5) {
				case 1:
				// InternalUmlState.g:529:2: (enumLiteral_0= 'Activity' )
				{
					// InternalUmlState.g:529:2: (enumLiteral_0= 'Activity' )
					// InternalUmlState.g:529:4: enumLiteral_0= 'Activity'
					{
						enumLiteral_0 = (Token) match(input, 17, FOLLOW_2);

						current = grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_0, grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0());


					}


				}
					break;
				case 2:
				// InternalUmlState.g:535:6: (enumLiteral_1= 'StateMachine' )
				{
					// InternalUmlState.g:535:6: (enumLiteral_1= 'StateMachine' )
					// InternalUmlState.g:535:8: enumLiteral_1= 'StateMachine'
					{
						enumLiteral_1 = (Token) match(input, 18, FOLLOW_2);

						current = grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_1, grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1());


					}


				}
					break;
				case 3:
				// InternalUmlState.g:541:6: (enumLiteral_2= 'OpaqueBehavior' )
				{
					// InternalUmlState.g:541:6: (enumLiteral_2= 'OpaqueBehavior' )
					// InternalUmlState.g:541:8: enumLiteral_2= 'OpaqueBehavior'
					{
						enumLiteral_2 = (Token) match(input, 19, FOLLOW_2);

						current = grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
						newLeafNode(enumLiteral_2, grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2());


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
	// $ANTLR end "ruleBehaviorKind"

	// Delegated rules




	public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x000000000001D002L });
	public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_5 = new BitSet(new long[] { 0x000000000001C002L });
	public static final BitSet FOLLOW_6 = new BitSet(new long[] { 0x0000000000002000L });
	public static final BitSet FOLLOW_7 = new BitSet(new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_8 = new BitSet(new long[] { 0x00000000000E0000L });

}
