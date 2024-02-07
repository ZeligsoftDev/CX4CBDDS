package org.eclipse.papyrus.infra.gmfdiag.css3.parser.antlr.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.papyrus.infra.gmfdiag.css3.services.CSSGrammarAccess;

import org.antlr.runtime.*;

@SuppressWarnings("all")
public class InternalCSSParser extends AbstractInternalAntlrParser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_CSSSTRING", "RULE_COLON", "RULE_COMMA", "RULE_PERCENT", "RULE_WS", "RULE_INCLUDES", "RULE_DASHMATCH", "RULE_HASHMARK", "RULE_IMPORTANT_SYM", "RULE_PLUS", "RULE_DASH", "RULE_UNDERSCORE",
			"RULE_ONE_HEX_LETTER", "RULE_ONE_NON_HEX_LETTER", "RULE_ONE_INT", "RULE_ML_COMMENT", "'@charset'", "'@CHARSET'", "';'", "'@import'", "'@IMPORT'", "'@page'", "'@PAGE'", "'{'", "'}'", "'@media'", "'@MEDIA'", "'@font-face'", "'@FONT-FACE'",
			"'@keyframes'", "'@KEYFRAMES'", "'['", "'^='", "'$='", "'*='", "'='", "']'", "'.'", "'*'", "'|'", "')'", "'('", "'not('", "'>'", "'~'", "'url('", "'/'", "'?'", "'@'", "'!'", "'$'", "'&'", "'not'", "'no'", "'url'", "'ur'", "'\\\\ '", "'\\\\('",
			"'\\\\)'", "'\\\\\\''", "'\\\\\"'"
	};
	public static final int T__50 = 50;
	public static final int RULE_IMPORTANT_SYM = 12;
	public static final int T__59 = 59;
	public static final int RULE_CSSSTRING = 4;
	public static final int RULE_UNDERSCORE = 15;
	public static final int T__55 = 55;
	public static final int T__56 = 56;
	public static final int T__57 = 57;
	public static final int T__58 = 58;
	public static final int RULE_PERCENT = 7;
	public static final int T__51 = 51;
	public static final int T__52 = 52;
	public static final int T__53 = 53;
	public static final int T__54 = 54;
	public static final int T__60 = 60;
	public static final int T__61 = 61;
	public static final int RULE_COMMA = 6;
	public static final int RULE_COLON = 5;
	public static final int RULE_HASHMARK = 11;
	public static final int T__26 = 26;
	public static final int T__27 = 27;
	public static final int RULE_DASHMATCH = 10;
	public static final int T__28 = 28;
	public static final int T__29 = 29;
	public static final int T__22 = 22;
	public static final int RULE_ML_COMMENT = 19;
	public static final int T__23 = 23;
	public static final int T__24 = 24;
	public static final int T__25 = 25;
	public static final int T__62 = 62;
	public static final int T__63 = 63;
	public static final int T__20 = 20;
	public static final int T__64 = 64;
	public static final int RULE_INCLUDES = 9;
	public static final int T__21 = 21;
	public static final int RULE_ONE_HEX_LETTER = 16;
	public static final int T__37 = 37;
	public static final int T__38 = 38;
	public static final int T__39 = 39;
	public static final int RULE_DASH = 14;
	public static final int RULE_ONE_INT = 18;
	public static final int T__33 = 33;
	public static final int T__34 = 34;
	public static final int T__35 = 35;
	public static final int RULE_PLUS = 13;
	public static final int T__36 = 36;
	public static final int EOF = -1;
	public static final int T__30 = 30;
	public static final int T__31 = 31;
	public static final int RULE_ONE_NON_HEX_LETTER = 17;
	public static final int T__32 = 32;
	public static final int RULE_WS = 8;
	public static final int T__48 = 48;
	public static final int T__49 = 49;
	public static final int T__44 = 44;
	public static final int T__45 = 45;
	public static final int T__46 = 46;
	public static final int T__47 = 47;
	public static final int T__40 = 40;
	public static final int T__41 = 41;
	public static final int T__42 = 42;
	public static final int T__43 = 43;

	// delegates
	// delegators


	public InternalCSSParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalCSSParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);

	}


	@Override
	public String[] getTokenNames() {
		return InternalCSSParser.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "InternalCSS.g";
	}



	private CSSGrammarAccess grammarAccess;

	public InternalCSSParser(TokenStream input, CSSGrammarAccess grammarAccess) {
		this(input);
		this.grammarAccess = grammarAccess;
		registerRules(grammarAccess.getGrammar());
	}

	@Override
	protected String getFirstRuleName() {
		return "stylesheet";
	}

	@Override
	protected CSSGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}



	// $ANTLR start "entryRulestylesheet"
	// InternalCSS.g:67:1: entryRulestylesheet returns [EObject current=null] : iv_rulestylesheet= rulestylesheet EOF ;
	public final EObject entryRulestylesheet() throws RecognitionException {
		EObject current = null;

		EObject iv_rulestylesheet = null;


		try {
			// InternalCSS.g:68:2: (iv_rulestylesheet= rulestylesheet EOF )
			// InternalCSS.g:69:2: iv_rulestylesheet= rulestylesheet EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getStylesheetRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulestylesheet = rulestylesheet();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulestylesheet;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulestylesheet"


	// $ANTLR start "rulestylesheet"
	// InternalCSS.g:76:1: rulestylesheet returns [EObject current=null] : ( ( (lv_charset_0_0= rulecharset ) )? ( (lv_imports_1_0= ruleimportExpression ) )* ( ( (lv_ruleset_2_0= ruleruleset ) ) | ( (lv_media_3_0= rulemedia ) ) | ( (lv_page_4_0= rulepage ) ) |
	// ( (lv_font_face_5_0= rulefont_face ) ) | ( (lv_keyframes_6_0= rulekeyframes ) ) )* ) ;
	public final EObject rulestylesheet() throws RecognitionException {
		EObject current = null;

		EObject lv_charset_0_0 = null;

		EObject lv_imports_1_0 = null;

		EObject lv_ruleset_2_0 = null;

		EObject lv_media_3_0 = null;

		EObject lv_page_4_0 = null;

		EObject lv_font_face_5_0 = null;

		EObject lv_keyframes_6_0 = null;


		enterRule();

		try {
			// InternalCSS.g:79:28: ( ( ( (lv_charset_0_0= rulecharset ) )? ( (lv_imports_1_0= ruleimportExpression ) )* ( ( (lv_ruleset_2_0= ruleruleset ) ) | ( (lv_media_3_0= rulemedia ) ) | ( (lv_page_4_0= rulepage ) ) | ( (lv_font_face_5_0= rulefont_face )
			// ) | ( (lv_keyframes_6_0= rulekeyframes ) ) )* ) )
			// InternalCSS.g:80:1: ( ( (lv_charset_0_0= rulecharset ) )? ( (lv_imports_1_0= ruleimportExpression ) )* ( ( (lv_ruleset_2_0= ruleruleset ) ) | ( (lv_media_3_0= rulemedia ) ) | ( (lv_page_4_0= rulepage ) ) | ( (lv_font_face_5_0= rulefont_face ) )
			// | ( (lv_keyframes_6_0= rulekeyframes ) ) )* )
			{
				// InternalCSS.g:80:1: ( ( (lv_charset_0_0= rulecharset ) )? ( (lv_imports_1_0= ruleimportExpression ) )* ( ( (lv_ruleset_2_0= ruleruleset ) ) | ( (lv_media_3_0= rulemedia ) ) | ( (lv_page_4_0= rulepage ) ) | ( (lv_font_face_5_0= rulefont_face
				// ) ) | ( (lv_keyframes_6_0= rulekeyframes ) ) )* )
				// InternalCSS.g:80:2: ( (lv_charset_0_0= rulecharset ) )? ( (lv_imports_1_0= ruleimportExpression ) )* ( ( (lv_ruleset_2_0= ruleruleset ) ) | ( (lv_media_3_0= rulemedia ) ) | ( (lv_page_4_0= rulepage ) ) | ( (lv_font_face_5_0= rulefont_face )
				// ) | ( (lv_keyframes_6_0= rulekeyframes ) ) )*
				{
					// InternalCSS.g:80:2: ( (lv_charset_0_0= rulecharset ) )?
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if (((LA1_0 >= 20 && LA1_0 <= 21))) {
						alt1 = 1;
					}
					switch (alt1) {
					case 1:
					// InternalCSS.g:81:1: (lv_charset_0_0= rulecharset )
					{
						// InternalCSS.g:81:1: (lv_charset_0_0= rulecharset )
						// InternalCSS.g:82:3: lv_charset_0_0= rulecharset
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getStylesheetAccess().getCharsetCharsetParserRuleCall_0_0());

							}
							pushFollow(FOLLOW_3);
							lv_charset_0_0 = rulecharset();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getStylesheetRule());
								}
								set(
										current,
										"charset",
										lv_charset_0_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.charset");
								afterParserOrEnumRuleCall();

							}

						}


					}
						break;

					}

					// InternalCSS.g:98:3: ( (lv_imports_1_0= ruleimportExpression ) )*
					loop2: do {
						int alt2 = 2;
						int LA2_0 = input.LA(1);

						if (((LA2_0 >= 23 && LA2_0 <= 24))) {
							alt2 = 1;
						}


						switch (alt2) {
						case 1:
						// InternalCSS.g:99:1: (lv_imports_1_0= ruleimportExpression )
						{
							// InternalCSS.g:99:1: (lv_imports_1_0= ruleimportExpression )
							// InternalCSS.g:100:3: lv_imports_1_0= ruleimportExpression
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getStylesheetAccess().getImportsImportExpressionParserRuleCall_1_0());

								}
								pushFollow(FOLLOW_3);
								lv_imports_1_0 = ruleimportExpression();

								state._fsp--;
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getStylesheetRule());
									}
									add(
											current,
											"imports",
											lv_imports_1_0,
											"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.importExpression");
									afterParserOrEnumRuleCall();

								}

							}


						}
							break;

						default:
							break loop2;
						}
					} while (true);

					// InternalCSS.g:116:3: ( ( (lv_ruleset_2_0= ruleruleset ) ) | ( (lv_media_3_0= rulemedia ) ) | ( (lv_page_4_0= rulepage ) ) | ( (lv_font_face_5_0= rulefont_face ) ) | ( (lv_keyframes_6_0= rulekeyframes ) ) )*
					loop3: do {
						int alt3 = 6;
						switch (input.LA(1)) {
						case RULE_COLON:
						case RULE_HASHMARK:
						case RULE_DASH:
						case RULE_UNDERSCORE:
						case RULE_ONE_HEX_LETTER:
						case RULE_ONE_NON_HEX_LETTER:
						case 35:
						case 41:
						case 42:
						case 43:
						case 56:
						case 57:
						case 58:
						case 59: {
							alt3 = 1;
						}
							break;
						case 29:
						case 30: {
							alt3 = 2;
						}
							break;
						case 25:
						case 26: {
							alt3 = 3;
						}
							break;
						case 31:
						case 32: {
							alt3 = 4;
						}
							break;
						case 33:
						case 34: {
							alt3 = 5;
						}
							break;

						}

						switch (alt3) {
						case 1:
						// InternalCSS.g:116:4: ( (lv_ruleset_2_0= ruleruleset ) )
						{
							// InternalCSS.g:116:4: ( (lv_ruleset_2_0= ruleruleset ) )
							// InternalCSS.g:117:1: (lv_ruleset_2_0= ruleruleset )
							{
								// InternalCSS.g:117:1: (lv_ruleset_2_0= ruleruleset )
								// InternalCSS.g:118:3: lv_ruleset_2_0= ruleruleset
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getStylesheetAccess().getRulesetRulesetParserRuleCall_2_0_0());

									}
									pushFollow(FOLLOW_4);
									lv_ruleset_2_0 = ruleruleset();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getStylesheetRule());
										}
										add(
												current,
												"ruleset",
												lv_ruleset_2_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.ruleset");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;
						case 2:
						// InternalCSS.g:135:6: ( (lv_media_3_0= rulemedia ) )
						{
							// InternalCSS.g:135:6: ( (lv_media_3_0= rulemedia ) )
							// InternalCSS.g:136:1: (lv_media_3_0= rulemedia )
							{
								// InternalCSS.g:136:1: (lv_media_3_0= rulemedia )
								// InternalCSS.g:137:3: lv_media_3_0= rulemedia
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getStylesheetAccess().getMediaMediaParserRuleCall_2_1_0());

									}
									pushFollow(FOLLOW_4);
									lv_media_3_0 = rulemedia();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getStylesheetRule());
										}
										add(
												current,
												"media",
												lv_media_3_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.media");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;
						case 3:
						// InternalCSS.g:154:6: ( (lv_page_4_0= rulepage ) )
						{
							// InternalCSS.g:154:6: ( (lv_page_4_0= rulepage ) )
							// InternalCSS.g:155:1: (lv_page_4_0= rulepage )
							{
								// InternalCSS.g:155:1: (lv_page_4_0= rulepage )
								// InternalCSS.g:156:3: lv_page_4_0= rulepage
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getStylesheetAccess().getPagePageParserRuleCall_2_2_0());

									}
									pushFollow(FOLLOW_4);
									lv_page_4_0 = rulepage();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getStylesheetRule());
										}
										add(
												current,
												"page",
												lv_page_4_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.page");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;
						case 4:
						// InternalCSS.g:173:6: ( (lv_font_face_5_0= rulefont_face ) )
						{
							// InternalCSS.g:173:6: ( (lv_font_face_5_0= rulefont_face ) )
							// InternalCSS.g:174:1: (lv_font_face_5_0= rulefont_face )
							{
								// InternalCSS.g:174:1: (lv_font_face_5_0= rulefont_face )
								// InternalCSS.g:175:3: lv_font_face_5_0= rulefont_face
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getStylesheetAccess().getFont_faceFont_faceParserRuleCall_2_3_0());

									}
									pushFollow(FOLLOW_4);
									lv_font_face_5_0 = rulefont_face();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getStylesheetRule());
										}
										add(
												current,
												"font_face",
												lv_font_face_5_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.font_face");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;
						case 5:
						// InternalCSS.g:192:6: ( (lv_keyframes_6_0= rulekeyframes ) )
						{
							// InternalCSS.g:192:6: ( (lv_keyframes_6_0= rulekeyframes ) )
							// InternalCSS.g:193:1: (lv_keyframes_6_0= rulekeyframes )
							{
								// InternalCSS.g:193:1: (lv_keyframes_6_0= rulekeyframes )
								// InternalCSS.g:194:3: lv_keyframes_6_0= rulekeyframes
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getStylesheetAccess().getKeyframesKeyframesParserRuleCall_2_4_0());

									}
									pushFollow(FOLLOW_4);
									lv_keyframes_6_0 = rulekeyframes();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getStylesheetRule());
										}
										add(
												current,
												"keyframes",
												lv_keyframes_6_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.keyframes");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;

						default:
							break loop3;
						}
					} while (true);


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulestylesheet"


	// $ANTLR start "entryRulecharset"
	// InternalCSS.g:218:1: entryRulecharset returns [EObject current=null] : iv_rulecharset= rulecharset EOF ;
	public final EObject entryRulecharset() throws RecognitionException {
		EObject current = null;

		EObject iv_rulecharset = null;


		try {
			// InternalCSS.g:219:2: (iv_rulecharset= rulecharset EOF )
			// InternalCSS.g:220:2: iv_rulecharset= rulecharset EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getCharsetRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulecharset = rulecharset();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulecharset;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulecharset"


	// $ANTLR start "rulecharset"
	// InternalCSS.g:227:1: rulecharset returns [EObject current=null] : ( (otherlv_0= '@charset' | otherlv_1= '@CHARSET' ) ( (lv_charset_2_0= RULE_CSSSTRING ) ) otherlv_3= ';' ) ;
	public final EObject rulecharset() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_1 = null;
		Token lv_charset_2_0 = null;
		Token otherlv_3 = null;

		enterRule();

		try {
			// InternalCSS.g:230:28: ( ( (otherlv_0= '@charset' | otherlv_1= '@CHARSET' ) ( (lv_charset_2_0= RULE_CSSSTRING ) ) otherlv_3= ';' ) )
			// InternalCSS.g:231:1: ( (otherlv_0= '@charset' | otherlv_1= '@CHARSET' ) ( (lv_charset_2_0= RULE_CSSSTRING ) ) otherlv_3= ';' )
			{
				// InternalCSS.g:231:1: ( (otherlv_0= '@charset' | otherlv_1= '@CHARSET' ) ( (lv_charset_2_0= RULE_CSSSTRING ) ) otherlv_3= ';' )
				// InternalCSS.g:231:2: (otherlv_0= '@charset' | otherlv_1= '@CHARSET' ) ( (lv_charset_2_0= RULE_CSSSTRING ) ) otherlv_3= ';'
				{
					// InternalCSS.g:231:2: (otherlv_0= '@charset' | otherlv_1= '@CHARSET' )
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if ((LA4_0 == 20)) {
						alt4 = 1;
					} else if ((LA4_0 == 21)) {
						alt4 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 4, 0, input);

						throw nvae;
					}
					switch (alt4) {
					case 1:
					// InternalCSS.g:231:4: otherlv_0= '@charset'
					{
						otherlv_0 = (Token) match(input, 20, FOLLOW_5);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_0, grammarAccess.getCharsetAccess().getCharsetKeyword_0_0());

						}

					}
						break;
					case 2:
					// InternalCSS.g:236:7: otherlv_1= '@CHARSET'
					{
						otherlv_1 = (Token) match(input, 21, FOLLOW_5);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_1, grammarAccess.getCharsetAccess().getCHARSETKeyword_0_1());

						}

					}
						break;

					}

					// InternalCSS.g:240:2: ( (lv_charset_2_0= RULE_CSSSTRING ) )
					// InternalCSS.g:241:1: (lv_charset_2_0= RULE_CSSSTRING )
					{
						// InternalCSS.g:241:1: (lv_charset_2_0= RULE_CSSSTRING )
						// InternalCSS.g:242:3: lv_charset_2_0= RULE_CSSSTRING
						{
							lv_charset_2_0 = (Token) match(input, RULE_CSSSTRING, FOLLOW_6);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								newLeafNode(lv_charset_2_0, grammarAccess.getCharsetAccess().getCharsetCSSSTRINGTerminalRuleCall_1_0());

							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElement(grammarAccess.getCharsetRule());
								}
								setWithLastConsumed(
										current,
										"charset",
										lv_charset_2_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.CSSSTRING");

							}

						}


					}

					otherlv_3 = (Token) match(input, 22, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_3, grammarAccess.getCharsetAccess().getSemicolonKeyword_2());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulecharset"


	// $ANTLR start "entryRuleimportExpression"
	// InternalCSS.g:270:1: entryRuleimportExpression returns [EObject current=null] : iv_ruleimportExpression= ruleimportExpression EOF ;
	public final EObject entryRuleimportExpression() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleimportExpression = null;


		try {
			// InternalCSS.g:271:2: (iv_ruleimportExpression= ruleimportExpression EOF )
			// InternalCSS.g:272:2: iv_ruleimportExpression= ruleimportExpression EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getImportExpressionRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleimportExpression = ruleimportExpression();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleimportExpression;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleimportExpression"


	// $ANTLR start "ruleimportExpression"
	// InternalCSS.g:279:1: ruleimportExpression returns [EObject current=null] : ( (otherlv_0= '@import' | otherlv_1= '@IMPORT' ) ( ( (lv_value_2_0= RULE_CSSSTRING ) ) | (this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? ) ) otherlv_5= ';'
	// ) ;
	public final EObject ruleimportExpression() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_1 = null;
		Token lv_value_2_0 = null;
		Token otherlv_5 = null;
		EObject this_URLType_3 = null;

		AntlrDatatypeRuleToken lv_mediaList_4_0 = null;


		enterRule();

		try {
			// InternalCSS.g:282:28: ( ( (otherlv_0= '@import' | otherlv_1= '@IMPORT' ) ( ( (lv_value_2_0= RULE_CSSSTRING ) ) | (this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? ) ) otherlv_5= ';' ) )
			// InternalCSS.g:283:1: ( (otherlv_0= '@import' | otherlv_1= '@IMPORT' ) ( ( (lv_value_2_0= RULE_CSSSTRING ) ) | (this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? ) ) otherlv_5= ';' )
			{
				// InternalCSS.g:283:1: ( (otherlv_0= '@import' | otherlv_1= '@IMPORT' ) ( ( (lv_value_2_0= RULE_CSSSTRING ) ) | (this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? ) ) otherlv_5= ';' )
				// InternalCSS.g:283:2: (otherlv_0= '@import' | otherlv_1= '@IMPORT' ) ( ( (lv_value_2_0= RULE_CSSSTRING ) ) | (this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? ) ) otherlv_5= ';'
				{
					// InternalCSS.g:283:2: (otherlv_0= '@import' | otherlv_1= '@IMPORT' )
					int alt5 = 2;
					int LA5_0 = input.LA(1);

					if ((LA5_0 == 23)) {
						alt5 = 1;
					} else if ((LA5_0 == 24)) {
						alt5 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 5, 0, input);

						throw nvae;
					}
					switch (alt5) {
					case 1:
					// InternalCSS.g:283:4: otherlv_0= '@import'
					{
						otherlv_0 = (Token) match(input, 23, FOLLOW_7);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_0, grammarAccess.getImportExpressionAccess().getImportKeyword_0_0());

						}

					}
						break;
					case 2:
					// InternalCSS.g:288:7: otherlv_1= '@IMPORT'
					{
						otherlv_1 = (Token) match(input, 24, FOLLOW_7);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_1, grammarAccess.getImportExpressionAccess().getIMPORTKeyword_0_1());

						}

					}
						break;

					}

					// InternalCSS.g:292:2: ( ( (lv_value_2_0= RULE_CSSSTRING ) ) | (this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? ) )
					int alt7 = 2;
					int LA7_0 = input.LA(1);

					if ((LA7_0 == RULE_CSSSTRING)) {
						alt7 = 1;
					} else if ((LA7_0 == 49)) {
						alt7 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 7, 0, input);

						throw nvae;
					}
					switch (alt7) {
					case 1:
					// InternalCSS.g:292:3: ( (lv_value_2_0= RULE_CSSSTRING ) )
					{
						// InternalCSS.g:292:3: ( (lv_value_2_0= RULE_CSSSTRING ) )
						// InternalCSS.g:293:1: (lv_value_2_0= RULE_CSSSTRING )
						{
							// InternalCSS.g:293:1: (lv_value_2_0= RULE_CSSSTRING )
							// InternalCSS.g:294:3: lv_value_2_0= RULE_CSSSTRING
							{
								lv_value_2_0 = (Token) match(input, RULE_CSSSTRING, FOLLOW_6);
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									newLeafNode(lv_value_2_0, grammarAccess.getImportExpressionAccess().getValueCSSSTRINGTerminalRuleCall_1_0_0());

								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElement(grammarAccess.getImportExpressionRule());
									}
									setWithLastConsumed(
											current,
											"value",
											lv_value_2_0,
											"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.CSSSTRING");

								}

							}


						}


					}
						break;
					case 2:
					// InternalCSS.g:311:6: (this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? )
					{
						// InternalCSS.g:311:6: (this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? )
						// InternalCSS.g:312:5: this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )?
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getImportExpressionAccess().getURLTypeParserRuleCall_1_1_0());

							}
							pushFollow(FOLLOW_8);
							this_URLType_3 = ruleURLType();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								current = this_URLType_3;
								afterParserOrEnumRuleCall();

							}
							// InternalCSS.g:320:1: ( (lv_mediaList_4_0= rulemedia_list ) )?
							int alt6 = 2;
							int LA6_0 = input.LA(1);

							if (((LA6_0 >= RULE_DASH && LA6_0 <= RULE_ONE_NON_HEX_LETTER) || (LA6_0 >= 56 && LA6_0 <= 59))) {
								alt6 = 1;
							}
							switch (alt6) {
							case 1:
							// InternalCSS.g:321:1: (lv_mediaList_4_0= rulemedia_list )
							{
								// InternalCSS.g:321:1: (lv_mediaList_4_0= rulemedia_list )
								// InternalCSS.g:322:3: lv_mediaList_4_0= rulemedia_list
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getImportExpressionAccess().getMediaListMedia_listParserRuleCall_1_1_1_0());

									}
									pushFollow(FOLLOW_6);
									lv_mediaList_4_0 = rulemedia_list();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getImportExpressionRule());
										}
										set(
												current,
												"mediaList",
												lv_mediaList_4_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.media_list");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							}


						}


					}
						break;

					}

					otherlv_5 = (Token) match(input, 22, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_5, grammarAccess.getImportExpressionAccess().getSemicolonKeyword_2());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleimportExpression"


	// $ANTLR start "entryRulepage"
	// InternalCSS.g:350:1: entryRulepage returns [EObject current=null] : iv_rulepage= rulepage EOF ;
	public final EObject entryRulepage() throws RecognitionException {
		EObject current = null;

		EObject iv_rulepage = null;


		try {
			// InternalCSS.g:351:2: (iv_rulepage= rulepage EOF )
			// InternalCSS.g:352:2: iv_rulepage= rulepage EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getPageRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulepage = rulepage();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulepage;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulepage"


	// $ANTLR start "rulepage"
	// InternalCSS.g:359:1: rulepage returns [EObject current=null] : ( () (otherlv_1= '@page' | otherlv_2= '@PAGE' ) ( (lv_pseudoPage_3_0= rulepseudo_page ) )? otherlv_4= '{' ( (lv_declarations_5_0= rulecss_declaration ) )? (otherlv_6= ';' (
	// (lv_declarations_7_0= rulecss_declaration ) )? )* otherlv_8= '}' ) ;
	public final EObject rulepage() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		Token otherlv_2 = null;
		Token otherlv_4 = null;
		Token otherlv_6 = null;
		Token otherlv_8 = null;
		AntlrDatatypeRuleToken lv_pseudoPage_3_0 = null;

		EObject lv_declarations_5_0 = null;

		EObject lv_declarations_7_0 = null;


		enterRule();

		try {
			// InternalCSS.g:362:28: ( ( () (otherlv_1= '@page' | otherlv_2= '@PAGE' ) ( (lv_pseudoPage_3_0= rulepseudo_page ) )? otherlv_4= '{' ( (lv_declarations_5_0= rulecss_declaration ) )? (otherlv_6= ';' ( (lv_declarations_7_0= rulecss_declaration ) )?
			// )* otherlv_8= '}' ) )
			// InternalCSS.g:363:1: ( () (otherlv_1= '@page' | otherlv_2= '@PAGE' ) ( (lv_pseudoPage_3_0= rulepseudo_page ) )? otherlv_4= '{' ( (lv_declarations_5_0= rulecss_declaration ) )? (otherlv_6= ';' ( (lv_declarations_7_0= rulecss_declaration ) )? )*
			// otherlv_8= '}' )
			{
				// InternalCSS.g:363:1: ( () (otherlv_1= '@page' | otherlv_2= '@PAGE' ) ( (lv_pseudoPage_3_0= rulepseudo_page ) )? otherlv_4= '{' ( (lv_declarations_5_0= rulecss_declaration ) )? (otherlv_6= ';' ( (lv_declarations_7_0= rulecss_declaration ) )?
				// )* otherlv_8= '}' )
				// InternalCSS.g:363:2: () (otherlv_1= '@page' | otherlv_2= '@PAGE' ) ( (lv_pseudoPage_3_0= rulepseudo_page ) )? otherlv_4= '{' ( (lv_declarations_5_0= rulecss_declaration ) )? (otherlv_6= ';' ( (lv_declarations_7_0= rulecss_declaration ) )? )*
				// otherlv_8= '}'
				{
					// InternalCSS.g:363:2: ()
					// InternalCSS.g:364:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getPageAccess().getPageAction_0(),
									current);

						}

					}

					// InternalCSS.g:369:2: (otherlv_1= '@page' | otherlv_2= '@PAGE' )
					int alt8 = 2;
					int LA8_0 = input.LA(1);

					if ((LA8_0 == 25)) {
						alt8 = 1;
					} else if ((LA8_0 == 26)) {
						alt8 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 8, 0, input);

						throw nvae;
					}
					switch (alt8) {
					case 1:
					// InternalCSS.g:369:4: otherlv_1= '@page'
					{
						otherlv_1 = (Token) match(input, 25, FOLLOW_9);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_1, grammarAccess.getPageAccess().getPageKeyword_1_0());

						}

					}
						break;
					case 2:
					// InternalCSS.g:374:7: otherlv_2= '@PAGE'
					{
						otherlv_2 = (Token) match(input, 26, FOLLOW_9);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_2, grammarAccess.getPageAccess().getPAGEKeyword_1_1());

						}

					}
						break;

					}

					// InternalCSS.g:378:2: ( (lv_pseudoPage_3_0= rulepseudo_page ) )?
					int alt9 = 2;
					int LA9_0 = input.LA(1);

					if ((LA9_0 == RULE_COLON)) {
						alt9 = 1;
					}
					switch (alt9) {
					case 1:
					// InternalCSS.g:379:1: (lv_pseudoPage_3_0= rulepseudo_page )
					{
						// InternalCSS.g:379:1: (lv_pseudoPage_3_0= rulepseudo_page )
						// InternalCSS.g:380:3: lv_pseudoPage_3_0= rulepseudo_page
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getPageAccess().getPseudoPagePseudo_pageParserRuleCall_2_0());

							}
							pushFollow(FOLLOW_10);
							lv_pseudoPage_3_0 = rulepseudo_page();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getPageRule());
								}
								set(
										current,
										"pseudoPage",
										lv_pseudoPage_3_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.pseudo_page");
								afterParserOrEnumRuleCall();

							}

						}


					}
						break;

					}

					otherlv_4 = (Token) match(input, 27, FOLLOW_11);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_4, grammarAccess.getPageAccess().getLeftCurlyBracketKeyword_3());

					}
					// InternalCSS.g:400:1: ( (lv_declarations_5_0= rulecss_declaration ) )?
					int alt10 = 2;
					int LA10_0 = input.LA(1);

					if ((LA10_0 == RULE_WS || (LA10_0 >= RULE_DASH && LA10_0 <= RULE_ONE_NON_HEX_LETTER) || (LA10_0 >= 56 && LA10_0 <= 59))) {
						alt10 = 1;
					}
					switch (alt10) {
					case 1:
					// InternalCSS.g:401:1: (lv_declarations_5_0= rulecss_declaration )
					{
						// InternalCSS.g:401:1: (lv_declarations_5_0= rulecss_declaration )
						// InternalCSS.g:402:3: lv_declarations_5_0= rulecss_declaration
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getPageAccess().getDeclarationsCss_declarationParserRuleCall_4_0());

							}
							pushFollow(FOLLOW_12);
							lv_declarations_5_0 = rulecss_declaration();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getPageRule());
								}
								add(
										current,
										"declarations",
										lv_declarations_5_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.css_declaration");
								afterParserOrEnumRuleCall();

							}

						}


					}
						break;

					}

					// InternalCSS.g:418:3: (otherlv_6= ';' ( (lv_declarations_7_0= rulecss_declaration ) )? )*
					loop12: do {
						int alt12 = 2;
						int LA12_0 = input.LA(1);

						if ((LA12_0 == 22)) {
							alt12 = 1;
						}


						switch (alt12) {
						case 1:
						// InternalCSS.g:418:5: otherlv_6= ';' ( (lv_declarations_7_0= rulecss_declaration ) )?
						{
							otherlv_6 = (Token) match(input, 22, FOLLOW_11);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								newLeafNode(otherlv_6, grammarAccess.getPageAccess().getSemicolonKeyword_5_0());

							}
							// InternalCSS.g:422:1: ( (lv_declarations_7_0= rulecss_declaration ) )?
							int alt11 = 2;
							int LA11_0 = input.LA(1);

							if ((LA11_0 == RULE_WS || (LA11_0 >= RULE_DASH && LA11_0 <= RULE_ONE_NON_HEX_LETTER) || (LA11_0 >= 56 && LA11_0 <= 59))) {
								alt11 = 1;
							}
							switch (alt11) {
							case 1:
							// InternalCSS.g:423:1: (lv_declarations_7_0= rulecss_declaration )
							{
								// InternalCSS.g:423:1: (lv_declarations_7_0= rulecss_declaration )
								// InternalCSS.g:424:3: lv_declarations_7_0= rulecss_declaration
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getPageAccess().getDeclarationsCss_declarationParserRuleCall_5_1_0());

									}
									pushFollow(FOLLOW_12);
									lv_declarations_7_0 = rulecss_declaration();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getPageRule());
										}
										add(
												current,
												"declarations",
												lv_declarations_7_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.css_declaration");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							}


						}
							break;

						default:
							break loop12;
						}
					} while (true);

					otherlv_8 = (Token) match(input, 28, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_8, grammarAccess.getPageAccess().getRightCurlyBracketKeyword_6());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulepage"


	// $ANTLR start "entryRulepseudo_page"
	// InternalCSS.g:452:1: entryRulepseudo_page returns [String current=null] : iv_rulepseudo_page= rulepseudo_page EOF ;
	public final String entryRulepseudo_page() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_rulepseudo_page = null;


		try {
			// InternalCSS.g:453:2: (iv_rulepseudo_page= rulepseudo_page EOF )
			// InternalCSS.g:454:2: iv_rulepseudo_page= rulepseudo_page EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getPseudo_pageRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulepseudo_page = rulepseudo_page();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulepseudo_page.getText();
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulepseudo_page"


	// $ANTLR start "rulepseudo_page"
	// InternalCSS.g:461:1: rulepseudo_page returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_COLON_0= RULE_COLON this_Identifier_1= ruleIdentifier ) ;
	public final AntlrDatatypeRuleToken rulepseudo_page() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_COLON_0 = null;
		AntlrDatatypeRuleToken this_Identifier_1 = null;


		enterRule();

		try {
			// InternalCSS.g:464:28: ( (this_COLON_0= RULE_COLON this_Identifier_1= ruleIdentifier ) )
			// InternalCSS.g:465:1: (this_COLON_0= RULE_COLON this_Identifier_1= ruleIdentifier )
			{
				// InternalCSS.g:465:1: (this_COLON_0= RULE_COLON this_Identifier_1= ruleIdentifier )
				// InternalCSS.g:465:6: this_COLON_0= RULE_COLON this_Identifier_1= ruleIdentifier
				{
					this_COLON_0 = (Token) match(input, RULE_COLON, FOLLOW_13);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(this_COLON_0);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_COLON_0, grammarAccess.getPseudo_pageAccess().getCOLONTerminalRuleCall_0());

					}
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getPseudo_pageAccess().getIdentifierParserRuleCall_1());

					}
					pushFollow(FOLLOW_2);
					this_Identifier_1 = ruleIdentifier();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(this_Identifier_1);

					}
					if (state.backtracking == 0) {

						afterParserOrEnumRuleCall();

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulepseudo_page"


	// $ANTLR start "entryRulemedia"
	// InternalCSS.g:491:1: entryRulemedia returns [EObject current=null] : iv_rulemedia= rulemedia EOF ;
	public final EObject entryRulemedia() throws RecognitionException {
		EObject current = null;

		EObject iv_rulemedia = null;


		try {
			// InternalCSS.g:492:2: (iv_rulemedia= rulemedia EOF )
			// InternalCSS.g:493:2: iv_rulemedia= rulemedia EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getMediaRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulemedia = rulemedia();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulemedia;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulemedia"


	// $ANTLR start "rulemedia"
	// InternalCSS.g:500:1: rulemedia returns [EObject current=null] : ( (otherlv_0= '@media' | otherlv_1= '@MEDIA' ) ( (lv_medialist_2_0= rulemedia_list ) ) otherlv_3= '{' ( (lv_rulesets_4_0= ruleruleset ) )* otherlv_5= '}' ) ;
	public final EObject rulemedia() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_1 = null;
		Token otherlv_3 = null;
		Token otherlv_5 = null;
		AntlrDatatypeRuleToken lv_medialist_2_0 = null;

		EObject lv_rulesets_4_0 = null;


		enterRule();

		try {
			// InternalCSS.g:503:28: ( ( (otherlv_0= '@media' | otherlv_1= '@MEDIA' ) ( (lv_medialist_2_0= rulemedia_list ) ) otherlv_3= '{' ( (lv_rulesets_4_0= ruleruleset ) )* otherlv_5= '}' ) )
			// InternalCSS.g:504:1: ( (otherlv_0= '@media' | otherlv_1= '@MEDIA' ) ( (lv_medialist_2_0= rulemedia_list ) ) otherlv_3= '{' ( (lv_rulesets_4_0= ruleruleset ) )* otherlv_5= '}' )
			{
				// InternalCSS.g:504:1: ( (otherlv_0= '@media' | otherlv_1= '@MEDIA' ) ( (lv_medialist_2_0= rulemedia_list ) ) otherlv_3= '{' ( (lv_rulesets_4_0= ruleruleset ) )* otherlv_5= '}' )
				// InternalCSS.g:504:2: (otherlv_0= '@media' | otherlv_1= '@MEDIA' ) ( (lv_medialist_2_0= rulemedia_list ) ) otherlv_3= '{' ( (lv_rulesets_4_0= ruleruleset ) )* otherlv_5= '}'
				{
					// InternalCSS.g:504:2: (otherlv_0= '@media' | otherlv_1= '@MEDIA' )
					int alt13 = 2;
					int LA13_0 = input.LA(1);

					if ((LA13_0 == 29)) {
						alt13 = 1;
					} else if ((LA13_0 == 30)) {
						alt13 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 13, 0, input);

						throw nvae;
					}
					switch (alt13) {
					case 1:
					// InternalCSS.g:504:4: otherlv_0= '@media'
					{
						otherlv_0 = (Token) match(input, 29, FOLLOW_13);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_0, grammarAccess.getMediaAccess().getMediaKeyword_0_0());

						}

					}
						break;
					case 2:
					// InternalCSS.g:509:7: otherlv_1= '@MEDIA'
					{
						otherlv_1 = (Token) match(input, 30, FOLLOW_13);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_1, grammarAccess.getMediaAccess().getMEDIAKeyword_0_1());

						}

					}
						break;

					}

					// InternalCSS.g:513:2: ( (lv_medialist_2_0= rulemedia_list ) )
					// InternalCSS.g:514:1: (lv_medialist_2_0= rulemedia_list )
					{
						// InternalCSS.g:514:1: (lv_medialist_2_0= rulemedia_list )
						// InternalCSS.g:515:3: lv_medialist_2_0= rulemedia_list
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getMediaAccess().getMedialistMedia_listParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_10);
							lv_medialist_2_0 = rulemedia_list();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getMediaRule());
								}
								set(
										current,
										"medialist",
										lv_medialist_2_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.media_list");
								afterParserOrEnumRuleCall();

							}

						}


					}

					otherlv_3 = (Token) match(input, 27, FOLLOW_14);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_3, grammarAccess.getMediaAccess().getLeftCurlyBracketKeyword_2());

					}
					// InternalCSS.g:535:1: ( (lv_rulesets_4_0= ruleruleset ) )*
					loop14: do {
						int alt14 = 2;
						int LA14_0 = input.LA(1);

						if ((LA14_0 == RULE_COLON || LA14_0 == RULE_HASHMARK || (LA14_0 >= RULE_DASH && LA14_0 <= RULE_ONE_NON_HEX_LETTER) || LA14_0 == 35 || (LA14_0 >= 41 && LA14_0 <= 43) || (LA14_0 >= 56 && LA14_0 <= 59))) {
							alt14 = 1;
						}


						switch (alt14) {
						case 1:
						// InternalCSS.g:536:1: (lv_rulesets_4_0= ruleruleset )
						{
							// InternalCSS.g:536:1: (lv_rulesets_4_0= ruleruleset )
							// InternalCSS.g:537:3: lv_rulesets_4_0= ruleruleset
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getMediaAccess().getRulesetsRulesetParserRuleCall_3_0());

								}
								pushFollow(FOLLOW_14);
								lv_rulesets_4_0 = ruleruleset();

								state._fsp--;
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getMediaRule());
									}
									add(
											current,
											"rulesets",
											lv_rulesets_4_0,
											"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.ruleset");
									afterParserOrEnumRuleCall();

								}

							}


						}
							break;

						default:
							break loop14;
						}
					} while (true);

					otherlv_5 = (Token) match(input, 28, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_5, grammarAccess.getMediaAccess().getRightCurlyBracketKeyword_4());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulemedia"


	// $ANTLR start "entryRulemedia_list"
	// InternalCSS.g:565:1: entryRulemedia_list returns [String current=null] : iv_rulemedia_list= rulemedia_list EOF ;
	public final String entryRulemedia_list() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_rulemedia_list = null;


		try {
			// InternalCSS.g:566:2: (iv_rulemedia_list= rulemedia_list EOF )
			// InternalCSS.g:567:2: iv_rulemedia_list= rulemedia_list EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getMedia_listRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulemedia_list = rulemedia_list();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulemedia_list.getText();
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulemedia_list"


	// $ANTLR start "rulemedia_list"
	// InternalCSS.g:574:1: rulemedia_list returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_medium_0= rulemedium (this_COMMA_1= RULE_COMMA this_medium_2= rulemedium )* ) ;
	public final AntlrDatatypeRuleToken rulemedia_list() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_COMMA_1 = null;
		AntlrDatatypeRuleToken this_medium_0 = null;

		AntlrDatatypeRuleToken this_medium_2 = null;


		enterRule();

		try {
			// InternalCSS.g:577:28: ( (this_medium_0= rulemedium (this_COMMA_1= RULE_COMMA this_medium_2= rulemedium )* ) )
			// InternalCSS.g:578:1: (this_medium_0= rulemedium (this_COMMA_1= RULE_COMMA this_medium_2= rulemedium )* )
			{
				// InternalCSS.g:578:1: (this_medium_0= rulemedium (this_COMMA_1= RULE_COMMA this_medium_2= rulemedium )* )
				// InternalCSS.g:579:5: this_medium_0= rulemedium (this_COMMA_1= RULE_COMMA this_medium_2= rulemedium )*
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getMedia_listAccess().getMediumParserRuleCall_0());

					}
					pushFollow(FOLLOW_15);
					this_medium_0 = rulemedium();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(this_medium_0);

					}
					if (state.backtracking == 0) {

						afterParserOrEnumRuleCall();

					}
					// InternalCSS.g:589:1: (this_COMMA_1= RULE_COMMA this_medium_2= rulemedium )*
					loop15: do {
						int alt15 = 2;
						int LA15_0 = input.LA(1);

						if ((LA15_0 == RULE_COMMA)) {
							alt15 = 1;
						}


						switch (alt15) {
						case 1:
						// InternalCSS.g:589:6: this_COMMA_1= RULE_COMMA this_medium_2= rulemedium
						{
							this_COMMA_1 = (Token) match(input, RULE_COMMA, FOLLOW_13);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								current.merge(this_COMMA_1);

							}
							if (state.backtracking == 0) {

								newLeafNode(this_COMMA_1, grammarAccess.getMedia_listAccess().getCOMMATerminalRuleCall_1_0());

							}
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getMedia_listAccess().getMediumParserRuleCall_1_1());

							}
							pushFollow(FOLLOW_15);
							this_medium_2 = rulemedium();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								current.merge(this_medium_2);

							}
							if (state.backtracking == 0) {

								afterParserOrEnumRuleCall();

							}

						}
							break;

						default:
							break loop15;
						}
					} while (true);


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulemedia_list"


	// $ANTLR start "entryRulemedium"
	// InternalCSS.g:615:1: entryRulemedium returns [String current=null] : iv_rulemedium= rulemedium EOF ;
	public final String entryRulemedium() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_rulemedium = null;


		try {
			// InternalCSS.g:616:2: (iv_rulemedium= rulemedium EOF )
			// InternalCSS.g:617:2: iv_rulemedium= rulemedium EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getMediumRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulemedium = rulemedium();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulemedium.getText();
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulemedium"


	// $ANTLR start "rulemedium"
	// InternalCSS.g:624:1: rulemedium returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
	public final AntlrDatatypeRuleToken rulemedium() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		AntlrDatatypeRuleToken this_Identifier_0 = null;


		enterRule();

		try {
			// InternalCSS.g:627:28: (this_Identifier_0= ruleIdentifier )
			// InternalCSS.g:629:5: this_Identifier_0= ruleIdentifier
			{
				if (state.backtracking == 0) {

					newCompositeNode(grammarAccess.getMediumAccess().getIdentifierParserRuleCall());

				}
				pushFollow(FOLLOW_2);
				this_Identifier_0 = ruleIdentifier();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {

					current.merge(this_Identifier_0);

				}
				if (state.backtracking == 0) {

					afterParserOrEnumRuleCall();

				}

			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulemedium"


	// $ANTLR start "entryRulefont_face"
	// InternalCSS.g:647:1: entryRulefont_face returns [EObject current=null] : iv_rulefont_face= rulefont_face EOF ;
	public final EObject entryRulefont_face() throws RecognitionException {
		EObject current = null;

		EObject iv_rulefont_face = null;


		try {
			// InternalCSS.g:648:2: (iv_rulefont_face= rulefont_face EOF )
			// InternalCSS.g:649:2: iv_rulefont_face= rulefont_face EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getFont_faceRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulefont_face = rulefont_face();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulefont_face;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulefont_face"


	// $ANTLR start "rulefont_face"
	// InternalCSS.g:656:1: rulefont_face returns [EObject current=null] : ( () (otherlv_1= '@font-face' | otherlv_2= '@FONT-FACE' ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration )
	// )? )* otherlv_7= '}' ) ;
	public final EObject rulefont_face() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		Token otherlv_2 = null;
		Token otherlv_3 = null;
		Token otherlv_5 = null;
		Token otherlv_7 = null;
		EObject lv_declarations_4_0 = null;

		EObject lv_declarations_6_0 = null;


		enterRule();

		try {
			// InternalCSS.g:659:28: ( ( () (otherlv_1= '@font-face' | otherlv_2= '@FONT-FACE' ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}' ) )
			// InternalCSS.g:660:1: ( () (otherlv_1= '@font-face' | otherlv_2= '@FONT-FACE' ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}' )
			{
				// InternalCSS.g:660:1: ( () (otherlv_1= '@font-face' | otherlv_2= '@FONT-FACE' ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}' )
				// InternalCSS.g:660:2: () (otherlv_1= '@font-face' | otherlv_2= '@FONT-FACE' ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}'
				{
					// InternalCSS.g:660:2: ()
					// InternalCSS.g:661:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getFont_faceAccess().getFont_faceAction_0(),
									current);

						}

					}

					// InternalCSS.g:666:2: (otherlv_1= '@font-face' | otherlv_2= '@FONT-FACE' )
					int alt16 = 2;
					int LA16_0 = input.LA(1);

					if ((LA16_0 == 31)) {
						alt16 = 1;
					} else if ((LA16_0 == 32)) {
						alt16 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 16, 0, input);

						throw nvae;
					}
					switch (alt16) {
					case 1:
					// InternalCSS.g:666:4: otherlv_1= '@font-face'
					{
						otherlv_1 = (Token) match(input, 31, FOLLOW_10);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_1, grammarAccess.getFont_faceAccess().getFontFaceKeyword_1_0());

						}

					}
						break;
					case 2:
					// InternalCSS.g:671:7: otherlv_2= '@FONT-FACE'
					{
						otherlv_2 = (Token) match(input, 32, FOLLOW_10);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_2, grammarAccess.getFont_faceAccess().getFONTFACEKeyword_1_1());

						}

					}
						break;

					}

					otherlv_3 = (Token) match(input, 27, FOLLOW_11);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_3, grammarAccess.getFont_faceAccess().getLeftCurlyBracketKeyword_2());

					}
					// InternalCSS.g:679:1: ( (lv_declarations_4_0= rulecss_declaration ) )?
					int alt17 = 2;
					int LA17_0 = input.LA(1);

					if ((LA17_0 == RULE_WS || (LA17_0 >= RULE_DASH && LA17_0 <= RULE_ONE_NON_HEX_LETTER) || (LA17_0 >= 56 && LA17_0 <= 59))) {
						alt17 = 1;
					}
					switch (alt17) {
					case 1:
					// InternalCSS.g:680:1: (lv_declarations_4_0= rulecss_declaration )
					{
						// InternalCSS.g:680:1: (lv_declarations_4_0= rulecss_declaration )
						// InternalCSS.g:681:3: lv_declarations_4_0= rulecss_declaration
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getFont_faceAccess().getDeclarationsCss_declarationParserRuleCall_3_0());

							}
							pushFollow(FOLLOW_12);
							lv_declarations_4_0 = rulecss_declaration();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getFont_faceRule());
								}
								add(
										current,
										"declarations",
										lv_declarations_4_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.css_declaration");
								afterParserOrEnumRuleCall();

							}

						}


					}
						break;

					}

					// InternalCSS.g:697:3: (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )*
					loop19: do {
						int alt19 = 2;
						int LA19_0 = input.LA(1);

						if ((LA19_0 == 22)) {
							alt19 = 1;
						}


						switch (alt19) {
						case 1:
						// InternalCSS.g:697:5: otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )?
						{
							otherlv_5 = (Token) match(input, 22, FOLLOW_11);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								newLeafNode(otherlv_5, grammarAccess.getFont_faceAccess().getSemicolonKeyword_4_0());

							}
							// InternalCSS.g:701:1: ( (lv_declarations_6_0= rulecss_declaration ) )?
							int alt18 = 2;
							int LA18_0 = input.LA(1);

							if ((LA18_0 == RULE_WS || (LA18_0 >= RULE_DASH && LA18_0 <= RULE_ONE_NON_HEX_LETTER) || (LA18_0 >= 56 && LA18_0 <= 59))) {
								alt18 = 1;
							}
							switch (alt18) {
							case 1:
							// InternalCSS.g:702:1: (lv_declarations_6_0= rulecss_declaration )
							{
								// InternalCSS.g:702:1: (lv_declarations_6_0= rulecss_declaration )
								// InternalCSS.g:703:3: lv_declarations_6_0= rulecss_declaration
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getFont_faceAccess().getDeclarationsCss_declarationParserRuleCall_4_1_0());

									}
									pushFollow(FOLLOW_12);
									lv_declarations_6_0 = rulecss_declaration();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getFont_faceRule());
										}
										add(
												current,
												"declarations",
												lv_declarations_6_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.css_declaration");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							}


						}
							break;

						default:
							break loop19;
						}
					} while (true);

					otherlv_7 = (Token) match(input, 28, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_7, grammarAccess.getFont_faceAccess().getRightCurlyBracketKeyword_5());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulefont_face"


	// $ANTLR start "entryRulekeyframes"
	// InternalCSS.g:731:1: entryRulekeyframes returns [EObject current=null] : iv_rulekeyframes= rulekeyframes EOF ;
	public final EObject entryRulekeyframes() throws RecognitionException {
		EObject current = null;

		EObject iv_rulekeyframes = null;


		try {
			// InternalCSS.g:732:2: (iv_rulekeyframes= rulekeyframes EOF )
			// InternalCSS.g:733:2: iv_rulekeyframes= rulekeyframes EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getKeyframesRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulekeyframes = rulekeyframes();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulekeyframes;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulekeyframes"


	// $ANTLR start "rulekeyframes"
	// InternalCSS.g:740:1: rulekeyframes returns [EObject current=null] : ( () (otherlv_1= '@keyframes' | otherlv_2= '@KEYFRAMES' ) ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '{' ( (lv_keyframeselectors_5_0= rulekeyframe_selector ) )? (otherlv_6= ';' (
	// (lv_keyframeselectors_7_0= rulekeyframe_selector ) )? )* otherlv_8= '}' ) ;
	public final EObject rulekeyframes() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		Token otherlv_2 = null;
		Token otherlv_4 = null;
		Token otherlv_6 = null;
		Token otherlv_8 = null;
		AntlrDatatypeRuleToken lv_name_3_0 = null;

		EObject lv_keyframeselectors_5_0 = null;

		EObject lv_keyframeselectors_7_0 = null;


		enterRule();

		try {
			// InternalCSS.g:743:28: ( ( () (otherlv_1= '@keyframes' | otherlv_2= '@KEYFRAMES' ) ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '{' ( (lv_keyframeselectors_5_0= rulekeyframe_selector ) )? (otherlv_6= ';' ( (lv_keyframeselectors_7_0=
			// rulekeyframe_selector ) )? )* otherlv_8= '}' ) )
			// InternalCSS.g:744:1: ( () (otherlv_1= '@keyframes' | otherlv_2= '@KEYFRAMES' ) ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '{' ( (lv_keyframeselectors_5_0= rulekeyframe_selector ) )? (otherlv_6= ';' ( (lv_keyframeselectors_7_0=
			// rulekeyframe_selector ) )? )* otherlv_8= '}' )
			{
				// InternalCSS.g:744:1: ( () (otherlv_1= '@keyframes' | otherlv_2= '@KEYFRAMES' ) ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '{' ( (lv_keyframeselectors_5_0= rulekeyframe_selector ) )? (otherlv_6= ';' ( (lv_keyframeselectors_7_0=
				// rulekeyframe_selector ) )? )* otherlv_8= '}' )
				// InternalCSS.g:744:2: () (otherlv_1= '@keyframes' | otherlv_2= '@KEYFRAMES' ) ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '{' ( (lv_keyframeselectors_5_0= rulekeyframe_selector ) )? (otherlv_6= ';' ( (lv_keyframeselectors_7_0=
				// rulekeyframe_selector ) )? )* otherlv_8= '}'
				{
					// InternalCSS.g:744:2: ()
					// InternalCSS.g:745:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getKeyframesAccess().getFont_faceAction_0(),
									current);

						}

					}

					// InternalCSS.g:750:2: (otherlv_1= '@keyframes' | otherlv_2= '@KEYFRAMES' )
					int alt20 = 2;
					int LA20_0 = input.LA(1);

					if ((LA20_0 == 33)) {
						alt20 = 1;
					} else if ((LA20_0 == 34)) {
						alt20 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 20, 0, input);

						throw nvae;
					}
					switch (alt20) {
					case 1:
					// InternalCSS.g:750:4: otherlv_1= '@keyframes'
					{
						otherlv_1 = (Token) match(input, 33, FOLLOW_13);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_1, grammarAccess.getKeyframesAccess().getKeyframesKeyword_1_0());

						}

					}
						break;
					case 2:
					// InternalCSS.g:755:7: otherlv_2= '@KEYFRAMES'
					{
						otherlv_2 = (Token) match(input, 34, FOLLOW_13);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_2, grammarAccess.getKeyframesAccess().getKEYFRAMESKeyword_1_1());

						}

					}
						break;

					}

					// InternalCSS.g:759:2: ( (lv_name_3_0= ruleIdentifier ) )
					// InternalCSS.g:760:1: (lv_name_3_0= ruleIdentifier )
					{
						// InternalCSS.g:760:1: (lv_name_3_0= ruleIdentifier )
						// InternalCSS.g:761:3: lv_name_3_0= ruleIdentifier
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getKeyframesAccess().getNameIdentifierParserRuleCall_2_0());

							}
							pushFollow(FOLLOW_10);
							lv_name_3_0 = ruleIdentifier();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getKeyframesRule());
								}
								set(
										current,
										"name",
										lv_name_3_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.Identifier");
								afterParserOrEnumRuleCall();

							}

						}


					}

					otherlv_4 = (Token) match(input, 27, FOLLOW_16);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_4, grammarAccess.getKeyframesAccess().getLeftCurlyBracketKeyword_3());

					}
					// InternalCSS.g:781:1: ( (lv_keyframeselectors_5_0= rulekeyframe_selector ) )?
					int alt21 = 2;
					int LA21_0 = input.LA(1);

					if (((LA21_0 >= RULE_PLUS && LA21_0 <= RULE_ONE_INT) || LA21_0 == 41 || (LA21_0 >= 56 && LA21_0 <= 59))) {
						alt21 = 1;
					}
					switch (alt21) {
					case 1:
					// InternalCSS.g:782:1: (lv_keyframeselectors_5_0= rulekeyframe_selector )
					{
						// InternalCSS.g:782:1: (lv_keyframeselectors_5_0= rulekeyframe_selector )
						// InternalCSS.g:783:3: lv_keyframeselectors_5_0= rulekeyframe_selector
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getKeyframesAccess().getKeyframeselectorsKeyframe_selectorParserRuleCall_4_0());

							}
							pushFollow(FOLLOW_12);
							lv_keyframeselectors_5_0 = rulekeyframe_selector();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getKeyframesRule());
								}
								add(
										current,
										"keyframeselectors",
										lv_keyframeselectors_5_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.keyframe_selector");
								afterParserOrEnumRuleCall();

							}

						}


					}
						break;

					}

					// InternalCSS.g:799:3: (otherlv_6= ';' ( (lv_keyframeselectors_7_0= rulekeyframe_selector ) )? )*
					loop23: do {
						int alt23 = 2;
						int LA23_0 = input.LA(1);

						if ((LA23_0 == 22)) {
							alt23 = 1;
						}


						switch (alt23) {
						case 1:
						// InternalCSS.g:799:5: otherlv_6= ';' ( (lv_keyframeselectors_7_0= rulekeyframe_selector ) )?
						{
							otherlv_6 = (Token) match(input, 22, FOLLOW_16);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								newLeafNode(otherlv_6, grammarAccess.getKeyframesAccess().getSemicolonKeyword_5_0());

							}
							// InternalCSS.g:803:1: ( (lv_keyframeselectors_7_0= rulekeyframe_selector ) )?
							int alt22 = 2;
							int LA22_0 = input.LA(1);

							if (((LA22_0 >= RULE_PLUS && LA22_0 <= RULE_ONE_INT) || LA22_0 == 41 || (LA22_0 >= 56 && LA22_0 <= 59))) {
								alt22 = 1;
							}
							switch (alt22) {
							case 1:
							// InternalCSS.g:804:1: (lv_keyframeselectors_7_0= rulekeyframe_selector )
							{
								// InternalCSS.g:804:1: (lv_keyframeselectors_7_0= rulekeyframe_selector )
								// InternalCSS.g:805:3: lv_keyframeselectors_7_0= rulekeyframe_selector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getKeyframesAccess().getKeyframeselectorsKeyframe_selectorParserRuleCall_5_1_0());

									}
									pushFollow(FOLLOW_12);
									lv_keyframeselectors_7_0 = rulekeyframe_selector();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getKeyframesRule());
										}
										add(
												current,
												"keyframeselectors",
												lv_keyframeselectors_7_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.keyframe_selector");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							}


						}
							break;

						default:
							break loop23;
						}
					} while (true);

					otherlv_8 = (Token) match(input, 28, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_8, grammarAccess.getKeyframesAccess().getRightCurlyBracketKeyword_6());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulekeyframes"


	// $ANTLR start "entryRulekeyframe_selector"
	// InternalCSS.g:833:1: entryRulekeyframe_selector returns [EObject current=null] : iv_rulekeyframe_selector= rulekeyframe_selector EOF ;
	public final EObject entryRulekeyframe_selector() throws RecognitionException {
		EObject current = null;

		EObject iv_rulekeyframe_selector = null;


		try {
			// InternalCSS.g:834:2: (iv_rulekeyframe_selector= rulekeyframe_selector EOF )
			// InternalCSS.g:835:2: iv_rulekeyframe_selector= rulekeyframe_selector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getKeyframe_selectorRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulekeyframe_selector = rulekeyframe_selector();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulekeyframe_selector;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulekeyframe_selector"


	// $ANTLR start "rulekeyframe_selector"
	// InternalCSS.g:842:1: rulekeyframe_selector returns [EObject current=null] : ( ( ( (lv_type_0_0= ruleIdentifier ) ) | ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT ) ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )?
	// (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}' ) ;
	public final EObject rulekeyframe_selector() throws RecognitionException {
		EObject current = null;

		Token this_PERCENT_2 = null;
		Token otherlv_3 = null;
		Token otherlv_5 = null;
		Token otherlv_7 = null;
		AntlrDatatypeRuleToken lv_type_0_0 = null;

		AntlrDatatypeRuleToken lv_percentage_1_0 = null;

		EObject lv_declarations_4_0 = null;

		EObject lv_declarations_6_0 = null;


		enterRule();

		try {
			// InternalCSS.g:845:28: ( ( ( ( (lv_type_0_0= ruleIdentifier ) ) | ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT ) ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0=
			// rulecss_declaration ) )? )* otherlv_7= '}' ) )
			// InternalCSS.g:846:1: ( ( ( (lv_type_0_0= ruleIdentifier ) ) | ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT ) ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0=
			// rulecss_declaration ) )? )* otherlv_7= '}' )
			{
				// InternalCSS.g:846:1: ( ( ( (lv_type_0_0= ruleIdentifier ) ) | ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT ) ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0=
				// rulecss_declaration ) )? )* otherlv_7= '}' )
				// InternalCSS.g:846:2: ( ( (lv_type_0_0= ruleIdentifier ) ) | ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT ) ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0=
				// rulecss_declaration ) )? )* otherlv_7= '}'
				{
					// InternalCSS.g:846:2: ( ( (lv_type_0_0= ruleIdentifier ) ) | ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT ) )
					int alt24 = 2;
					switch (input.LA(1)) {
					case RULE_DASH: {
						int LA24_1 = input.LA(2);

						if ((LA24_1 == RULE_ONE_INT || LA24_1 == 41)) {
							alt24 = 2;
						} else if (((LA24_1 >= RULE_UNDERSCORE && LA24_1 <= RULE_ONE_NON_HEX_LETTER) || (LA24_1 >= 56 && LA24_1 <= 59))) {
							alt24 = 1;
						} else {
							if (state.backtracking > 0) {
								state.failed = true;
								return current;
							}
							NoViableAltException nvae = new NoViableAltException("", 24, 1, input);

							throw nvae;
						}
					}
						break;
					case RULE_UNDERSCORE:
					case RULE_ONE_HEX_LETTER:
					case RULE_ONE_NON_HEX_LETTER:
					case 56:
					case 57:
					case 58:
					case 59: {
						alt24 = 1;
					}
						break;
					case RULE_PLUS:
					case RULE_ONE_INT:
					case 41: {
						alt24 = 2;
					}
						break;
					default:
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 24, 0, input);

						throw nvae;
					}

					switch (alt24) {
					case 1:
					// InternalCSS.g:846:3: ( (lv_type_0_0= ruleIdentifier ) )
					{
						// InternalCSS.g:846:3: ( (lv_type_0_0= ruleIdentifier ) )
						// InternalCSS.g:847:1: (lv_type_0_0= ruleIdentifier )
						{
							// InternalCSS.g:847:1: (lv_type_0_0= ruleIdentifier )
							// InternalCSS.g:848:3: lv_type_0_0= ruleIdentifier
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getKeyframe_selectorAccess().getTypeIdentifierParserRuleCall_0_0_0());

								}
								pushFollow(FOLLOW_10);
								lv_type_0_0 = ruleIdentifier();

								state._fsp--;
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getKeyframe_selectorRule());
									}
									set(
											current,
											"type",
											lv_type_0_0,
											"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.Identifier");
									afterParserOrEnumRuleCall();

								}

							}


						}


					}
						break;
					case 2:
					// InternalCSS.g:865:6: ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT )
					{
						// InternalCSS.g:865:6: ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT )
						// InternalCSS.g:865:7: ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT
						{
							// InternalCSS.g:865:7: ( (lv_percentage_1_0= ruleNum ) )
							// InternalCSS.g:866:1: (lv_percentage_1_0= ruleNum )
							{
								// InternalCSS.g:866:1: (lv_percentage_1_0= ruleNum )
								// InternalCSS.g:867:3: lv_percentage_1_0= ruleNum
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getKeyframe_selectorAccess().getPercentageNumParserRuleCall_0_1_0_0());

									}
									pushFollow(FOLLOW_17);
									lv_percentage_1_0 = ruleNum();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getKeyframe_selectorRule());
										}
										set(
												current,
												"percentage",
												lv_percentage_1_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.Num");
										afterParserOrEnumRuleCall();

									}

								}


							}

							this_PERCENT_2 = (Token) match(input, RULE_PERCENT, FOLLOW_10);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								newLeafNode(this_PERCENT_2, grammarAccess.getKeyframe_selectorAccess().getPERCENTTerminalRuleCall_0_1_1());

							}

						}


					}
						break;

					}

					otherlv_3 = (Token) match(input, 27, FOLLOW_11);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_3, grammarAccess.getKeyframe_selectorAccess().getLeftCurlyBracketKeyword_1());

					}
					// InternalCSS.g:891:1: ( (lv_declarations_4_0= rulecss_declaration ) )?
					int alt25 = 2;
					int LA25_0 = input.LA(1);

					if ((LA25_0 == RULE_WS || (LA25_0 >= RULE_DASH && LA25_0 <= RULE_ONE_NON_HEX_LETTER) || (LA25_0 >= 56 && LA25_0 <= 59))) {
						alt25 = 1;
					}
					switch (alt25) {
					case 1:
					// InternalCSS.g:892:1: (lv_declarations_4_0= rulecss_declaration )
					{
						// InternalCSS.g:892:1: (lv_declarations_4_0= rulecss_declaration )
						// InternalCSS.g:893:3: lv_declarations_4_0= rulecss_declaration
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getKeyframe_selectorAccess().getDeclarationsCss_declarationParserRuleCall_2_0());

							}
							pushFollow(FOLLOW_12);
							lv_declarations_4_0 = rulecss_declaration();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getKeyframe_selectorRule());
								}
								add(
										current,
										"declarations",
										lv_declarations_4_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.css_declaration");
								afterParserOrEnumRuleCall();

							}

						}


					}
						break;

					}

					// InternalCSS.g:909:3: (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )*
					loop27: do {
						int alt27 = 2;
						int LA27_0 = input.LA(1);

						if ((LA27_0 == 22)) {
							alt27 = 1;
						}


						switch (alt27) {
						case 1:
						// InternalCSS.g:909:5: otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )?
						{
							otherlv_5 = (Token) match(input, 22, FOLLOW_11);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								newLeafNode(otherlv_5, grammarAccess.getKeyframe_selectorAccess().getSemicolonKeyword_3_0());

							}
							// InternalCSS.g:913:1: ( (lv_declarations_6_0= rulecss_declaration ) )?
							int alt26 = 2;
							int LA26_0 = input.LA(1);

							if ((LA26_0 == RULE_WS || (LA26_0 >= RULE_DASH && LA26_0 <= RULE_ONE_NON_HEX_LETTER) || (LA26_0 >= 56 && LA26_0 <= 59))) {
								alt26 = 1;
							}
							switch (alt26) {
							case 1:
							// InternalCSS.g:914:1: (lv_declarations_6_0= rulecss_declaration )
							{
								// InternalCSS.g:914:1: (lv_declarations_6_0= rulecss_declaration )
								// InternalCSS.g:915:3: lv_declarations_6_0= rulecss_declaration
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getKeyframe_selectorAccess().getDeclarationsCss_declarationParserRuleCall_3_1_0());

									}
									pushFollow(FOLLOW_12);
									lv_declarations_6_0 = rulecss_declaration();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getKeyframe_selectorRule());
										}
										add(
												current,
												"declarations",
												lv_declarations_6_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.css_declaration");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							}


						}
							break;

						default:
							break loop27;
						}
					} while (true);

					otherlv_7 = (Token) match(input, 28, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_7, grammarAccess.getKeyframe_selectorAccess().getRightCurlyBracketKeyword_4());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulekeyframe_selector"


	// $ANTLR start "entryRuleruleset"
	// InternalCSS.g:943:1: entryRuleruleset returns [EObject current=null] : iv_ruleruleset= ruleruleset EOF ;
	public final EObject entryRuleruleset() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleruleset = null;


		try {
			// InternalCSS.g:944:2: (iv_ruleruleset= ruleruleset EOF )
			// InternalCSS.g:945:2: iv_ruleruleset= ruleruleset EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getRulesetRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleruleset = ruleruleset();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleruleset;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleruleset"


	// $ANTLR start "ruleruleset"
	// InternalCSS.g:952:1: ruleruleset returns [EObject current=null] : ( ( (lv_selectors_0_0= ruleselector ) ) ( (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA ( (lv_selectors_3_0= ruleselector ) ) )* (this_WS_4= RULE_WS )* otherlv_5= '{' ( (
	// (lv_declarations_6_0= rulecss_declaration ) ) (otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) ) )* (otherlv_9= ';' )? )? otherlv_10= '}' ) ;
	public final EObject ruleruleset() throws RecognitionException {
		EObject current = null;

		Token this_WS_1 = null;
		Token this_COMMA_2 = null;
		Token this_WS_4 = null;
		Token otherlv_5 = null;
		Token otherlv_7 = null;
		Token otherlv_9 = null;
		Token otherlv_10 = null;
		EObject lv_selectors_0_0 = null;

		EObject lv_selectors_3_0 = null;

		EObject lv_declarations_6_0 = null;

		EObject lv_declarations_8_0 = null;


		enterRule();

		try {
			// InternalCSS.g:955:28: ( ( ( (lv_selectors_0_0= ruleselector ) ) ( (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA ( (lv_selectors_3_0= ruleselector ) ) )* (this_WS_4= RULE_WS )* otherlv_5= '{' ( ( (lv_declarations_6_0= rulecss_declaration ) )
			// (otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) ) )* (otherlv_9= ';' )? )? otherlv_10= '}' ) )
			// InternalCSS.g:956:1: ( ( (lv_selectors_0_0= ruleselector ) ) ( (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA ( (lv_selectors_3_0= ruleselector ) ) )* (this_WS_4= RULE_WS )* otherlv_5= '{' ( ( (lv_declarations_6_0= rulecss_declaration ) )
			// (otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) ) )* (otherlv_9= ';' )? )? otherlv_10= '}' )
			{
				// InternalCSS.g:956:1: ( ( (lv_selectors_0_0= ruleselector ) ) ( (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA ( (lv_selectors_3_0= ruleselector ) ) )* (this_WS_4= RULE_WS )* otherlv_5= '{' ( ( (lv_declarations_6_0= rulecss_declaration ) )
				// (otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) ) )* (otherlv_9= ';' )? )? otherlv_10= '}' )
				// InternalCSS.g:956:2: ( (lv_selectors_0_0= ruleselector ) ) ( (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA ( (lv_selectors_3_0= ruleselector ) ) )* (this_WS_4= RULE_WS )* otherlv_5= '{' ( ( (lv_declarations_6_0= rulecss_declaration ) )
				// (otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) ) )* (otherlv_9= ';' )? )? otherlv_10= '}'
				{
					// InternalCSS.g:956:2: ( (lv_selectors_0_0= ruleselector ) )
					// InternalCSS.g:957:1: (lv_selectors_0_0= ruleselector )
					{
						// InternalCSS.g:957:1: (lv_selectors_0_0= ruleselector )
						// InternalCSS.g:958:3: lv_selectors_0_0= ruleselector
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getRulesetAccess().getSelectorsSelectorParserRuleCall_0_0());

							}
							pushFollow(FOLLOW_18);
							lv_selectors_0_0 = ruleselector();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getRulesetRule());
								}
								add(
										current,
										"selectors",
										lv_selectors_0_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.selector");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalCSS.g:974:2: ( (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA ( (lv_selectors_3_0= ruleselector ) ) )*
					loop29: do {
						int alt29 = 2;
						alt29 = dfa29.predict(input);
						switch (alt29) {
						case 1:
						// InternalCSS.g:974:3: (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA ( (lv_selectors_3_0= ruleselector ) )
						{
							// InternalCSS.g:974:3: (this_WS_1= RULE_WS )*
							loop28: do {
								int alt28 = 2;
								int LA28_0 = input.LA(1);

								if ((LA28_0 == RULE_WS)) {
									alt28 = 1;
								}


								switch (alt28) {
								case 1:
								// InternalCSS.g:974:4: this_WS_1= RULE_WS
								{
									this_WS_1 = (Token) match(input, RULE_WS, FOLLOW_19);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										newLeafNode(this_WS_1, grammarAccess.getRulesetAccess().getWSTerminalRuleCall_1_0());

									}

								}
									break;

								default:
									break loop28;
								}
							} while (true);

							this_COMMA_2 = (Token) match(input, RULE_COMMA, FOLLOW_20);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								newLeafNode(this_COMMA_2, grammarAccess.getRulesetAccess().getCOMMATerminalRuleCall_1_1());

							}
							// InternalCSS.g:982:1: ( (lv_selectors_3_0= ruleselector ) )
							// InternalCSS.g:983:1: (lv_selectors_3_0= ruleselector )
							{
								// InternalCSS.g:983:1: (lv_selectors_3_0= ruleselector )
								// InternalCSS.g:984:3: lv_selectors_3_0= ruleselector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getRulesetAccess().getSelectorsSelectorParserRuleCall_1_2_0());

									}
									pushFollow(FOLLOW_18);
									lv_selectors_3_0 = ruleselector();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getRulesetRule());
										}
										add(
												current,
												"selectors",
												lv_selectors_3_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.selector");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;

						default:
							break loop29;
						}
					} while (true);

					// InternalCSS.g:1000:4: (this_WS_4= RULE_WS )*
					loop30: do {
						int alt30 = 2;
						int LA30_0 = input.LA(1);

						if ((LA30_0 == RULE_WS)) {
							alt30 = 1;
						}


						switch (alt30) {
						case 1:
						// InternalCSS.g:1000:5: this_WS_4= RULE_WS
						{
							this_WS_4 = (Token) match(input, RULE_WS, FOLLOW_21);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								newLeafNode(this_WS_4, grammarAccess.getRulesetAccess().getWSTerminalRuleCall_2());

							}

						}
							break;

						default:
							break loop30;
						}
					} while (true);

					otherlv_5 = (Token) match(input, 27, FOLLOW_22);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_5, grammarAccess.getRulesetAccess().getLeftCurlyBracketKeyword_3());

					}
					// InternalCSS.g:1008:1: ( ( (lv_declarations_6_0= rulecss_declaration ) ) (otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) ) )* (otherlv_9= ';' )? )?
					int alt33 = 2;
					int LA33_0 = input.LA(1);

					if ((LA33_0 == RULE_WS || (LA33_0 >= RULE_DASH && LA33_0 <= RULE_ONE_NON_HEX_LETTER) || (LA33_0 >= 56 && LA33_0 <= 59))) {
						alt33 = 1;
					}
					switch (alt33) {
					case 1:
					// InternalCSS.g:1008:2: ( (lv_declarations_6_0= rulecss_declaration ) ) (otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) ) )* (otherlv_9= ';' )?
					{
						// InternalCSS.g:1008:2: ( (lv_declarations_6_0= rulecss_declaration ) )
						// InternalCSS.g:1009:1: (lv_declarations_6_0= rulecss_declaration )
						{
							// InternalCSS.g:1009:1: (lv_declarations_6_0= rulecss_declaration )
							// InternalCSS.g:1010:3: lv_declarations_6_0= rulecss_declaration
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getRulesetAccess().getDeclarationsCss_declarationParserRuleCall_4_0_0());

								}
								pushFollow(FOLLOW_12);
								lv_declarations_6_0 = rulecss_declaration();

								state._fsp--;
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getRulesetRule());
									}
									add(
											current,
											"declarations",
											lv_declarations_6_0,
											"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.css_declaration");
									afterParserOrEnumRuleCall();

								}

							}


						}

						// InternalCSS.g:1026:2: (otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) ) )*
						loop31: do {
							int alt31 = 2;
							int LA31_0 = input.LA(1);

							if ((LA31_0 == 22)) {
								int LA31_1 = input.LA(2);

								if ((LA31_1 == RULE_WS || (LA31_1 >= RULE_DASH && LA31_1 <= RULE_ONE_NON_HEX_LETTER) || (LA31_1 >= 56 && LA31_1 <= 59))) {
									alt31 = 1;
								}


							}


							switch (alt31) {
							case 1:
							// InternalCSS.g:1026:4: otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) )
							{
								otherlv_7 = (Token) match(input, 22, FOLLOW_23);
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									newLeafNode(otherlv_7, grammarAccess.getRulesetAccess().getSemicolonKeyword_4_1_0());

								}
								// InternalCSS.g:1030:1: ( (lv_declarations_8_0= rulecss_declaration ) )
								// InternalCSS.g:1031:1: (lv_declarations_8_0= rulecss_declaration )
								{
									// InternalCSS.g:1031:1: (lv_declarations_8_0= rulecss_declaration )
									// InternalCSS.g:1032:3: lv_declarations_8_0= rulecss_declaration
									{
										if (state.backtracking == 0) {

											newCompositeNode(grammarAccess.getRulesetAccess().getDeclarationsCss_declarationParserRuleCall_4_1_1_0());

										}
										pushFollow(FOLLOW_12);
										lv_declarations_8_0 = rulecss_declaration();

										state._fsp--;
										if (state.failed) {
											return current;
										}
										if (state.backtracking == 0) {

											if (current == null) {
												current = createModelElementForParent(grammarAccess.getRulesetRule());
											}
											add(
													current,
													"declarations",
													lv_declarations_8_0,
													"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.css_declaration");
											afterParserOrEnumRuleCall();

										}

									}


								}


							}
								break;

							default:
								break loop31;
							}
						} while (true);

						// InternalCSS.g:1048:4: (otherlv_9= ';' )?
						int alt32 = 2;
						int LA32_0 = input.LA(1);

						if ((LA32_0 == 22)) {
							alt32 = 1;
						}
						switch (alt32) {
						case 1:
						// InternalCSS.g:1048:6: otherlv_9= ';'
						{
							otherlv_9 = (Token) match(input, 22, FOLLOW_24);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								newLeafNode(otherlv_9, grammarAccess.getRulesetAccess().getSemicolonKeyword_4_2());

							}

						}
							break;

						}


					}
						break;

					}

					otherlv_10 = (Token) match(input, 28, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_10, grammarAccess.getRulesetAccess().getRightCurlyBracketKeyword_5());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleruleset"


	// $ANTLR start "entryRuleselector"
	// InternalCSS.g:1064:1: entryRuleselector returns [EObject current=null] : iv_ruleselector= ruleselector EOF ;
	public final EObject entryRuleselector() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleselector = null;



		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens("RULE_ML_COMMENT");

		try {
			// InternalCSS.g:1068:2: (iv_ruleselector= ruleselector EOF )
			// InternalCSS.g:1069:2: iv_ruleselector= ruleselector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getSelectorRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleselector = ruleselector();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleselector;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRuleselector"


	// $ANTLR start "ruleselector"
	// InternalCSS.g:1079:1: ruleselector returns [EObject current=null] : ( ( (lv_simpleselectors_0_0= rulesimple_selector ) ) ( ( ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) ) | ( (this_WS_4= RULE_WS
	// )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) ) )? ) ;
	public final EObject ruleselector() throws RecognitionException {
		EObject current = null;

		Token this_WS_2 = null;
		Token this_WS_4 = null;
		Token this_WS_6 = null;
		EObject lv_simpleselectors_0_0 = null;

		AntlrDatatypeRuleToken lv_combinator_1_0 = null;

		EObject lv_selector_3_0 = null;

		AntlrDatatypeRuleToken lv_combinator_5_0 = null;

		EObject lv_selector_7_0 = null;


		enterRule();
		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens("RULE_ML_COMMENT");

		try {
			// InternalCSS.g:1083:28: ( ( ( (lv_simpleselectors_0_0= rulesimple_selector ) ) ( ( ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) ) | ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0=
			// rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) ) )? ) )
			// InternalCSS.g:1084:1: ( ( (lv_simpleselectors_0_0= rulesimple_selector ) ) ( ( ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) ) | ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0=
			// rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) ) )? )
			{
				// InternalCSS.g:1084:1: ( ( (lv_simpleselectors_0_0= rulesimple_selector ) ) ( ( ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) ) | ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0=
				// rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) ) )? )
				// InternalCSS.g:1084:2: ( (lv_simpleselectors_0_0= rulesimple_selector ) ) ( ( ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) ) | ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0=
				// rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) ) )?
				{
					// InternalCSS.g:1084:2: ( (lv_simpleselectors_0_0= rulesimple_selector ) )
					// InternalCSS.g:1085:1: (lv_simpleselectors_0_0= rulesimple_selector )
					{
						// InternalCSS.g:1085:1: (lv_simpleselectors_0_0= rulesimple_selector )
						// InternalCSS.g:1086:3: lv_simpleselectors_0_0= rulesimple_selector
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getSelectorAccess().getSimpleselectorsSimple_selectorParserRuleCall_0_0());

							}
							pushFollow(FOLLOW_25);
							lv_simpleselectors_0_0 = rulesimple_selector();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getSelectorRule());
								}
								add(
										current,
										"simpleselectors",
										lv_simpleselectors_0_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.simple_selector");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalCSS.g:1102:2: ( ( ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) ) | ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? (
					// (lv_selector_7_0= ruleselector ) ) ) )?
					int alt38 = 3;
					alt38 = dfa38.predict(input);
					switch (alt38) {
					case 1:
					// InternalCSS.g:1102:3: ( ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) )
					{
						// InternalCSS.g:1102:3: ( ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) )
						// InternalCSS.g:1102:4: ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) )
						{
							// InternalCSS.g:1102:4: ( (lv_combinator_1_0= rulecombinator ) )
							// InternalCSS.g:1103:1: (lv_combinator_1_0= rulecombinator )
							{
								// InternalCSS.g:1103:1: (lv_combinator_1_0= rulecombinator )
								// InternalCSS.g:1104:3: lv_combinator_1_0= rulecombinator
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSelectorAccess().getCombinatorCombinatorParserRuleCall_1_0_0_0());

									}
									pushFollow(FOLLOW_26);
									lv_combinator_1_0 = rulecombinator();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSelectorRule());
										}
										set(
												current,
												"combinator",
												lv_combinator_1_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.combinator");
										afterParserOrEnumRuleCall();

									}

								}


							}

							// InternalCSS.g:1120:2: (this_WS_2= RULE_WS )*
							loop34: do {
								int alt34 = 2;
								int LA34_0 = input.LA(1);

								if ((LA34_0 == RULE_WS)) {
									alt34 = 1;
								}


								switch (alt34) {
								case 1:
								// InternalCSS.g:1120:3: this_WS_2= RULE_WS
								{
									this_WS_2 = (Token) match(input, RULE_WS, FOLLOW_26);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										newLeafNode(this_WS_2, grammarAccess.getSelectorAccess().getWSTerminalRuleCall_1_0_1());

									}

								}
									break;

								default:
									break loop34;
								}
							} while (true);

							// InternalCSS.g:1124:3: ( (lv_selector_3_0= ruleselector ) )
							// InternalCSS.g:1125:1: (lv_selector_3_0= ruleselector )
							{
								// InternalCSS.g:1125:1: (lv_selector_3_0= ruleselector )
								// InternalCSS.g:1126:3: lv_selector_3_0= ruleselector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSelectorAccess().getSelectorSelectorParserRuleCall_1_0_2_0());

									}
									pushFollow(FOLLOW_2);
									lv_selector_3_0 = ruleselector();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSelectorRule());
										}
										set(
												current,
												"selector",
												lv_selector_3_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.selector");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}


					}
						break;
					case 2:
					// InternalCSS.g:1143:6: ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) )
					{
						// InternalCSS.g:1143:6: ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) )
						// InternalCSS.g:1143:7: (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) )
						{
							// InternalCSS.g:1143:7: (this_WS_4= RULE_WS )+
							int cnt35 = 0;
							loop35: do {
								int alt35 = 2;
								int LA35_0 = input.LA(1);

								if ((LA35_0 == RULE_WS)) {
									alt35 = 1;
								}


								switch (alt35) {
								case 1:
								// InternalCSS.g:1143:8: this_WS_4= RULE_WS
								{
									this_WS_4 = (Token) match(input, RULE_WS, FOLLOW_27);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										newLeafNode(this_WS_4, grammarAccess.getSelectorAccess().getWSTerminalRuleCall_1_1_0());

									}

								}
									break;

								default:
									if (cnt35 >= 1) {
										break loop35;
									}
									if (state.backtracking > 0) {
										state.failed = true;
										return current;
									}
									EarlyExitException eee = new EarlyExitException(35, input);
									throw eee;
								}
								cnt35++;
							} while (true);

							// InternalCSS.g:1147:3: ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )?
							int alt37 = 2;
							int LA37_0 = input.LA(1);

							if ((LA37_0 == RULE_PLUS || (LA37_0 >= 47 && LA37_0 <= 48))) {
								alt37 = 1;
							}
							switch (alt37) {
							case 1:
							// InternalCSS.g:1147:4: ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )*
							{
								// InternalCSS.g:1147:4: ( (lv_combinator_5_0= rulecombinator ) )
								// InternalCSS.g:1148:1: (lv_combinator_5_0= rulecombinator )
								{
									// InternalCSS.g:1148:1: (lv_combinator_5_0= rulecombinator )
									// InternalCSS.g:1149:3: lv_combinator_5_0= rulecombinator
									{
										if (state.backtracking == 0) {

											newCompositeNode(grammarAccess.getSelectorAccess().getCombinatorCombinatorParserRuleCall_1_1_1_0_0());

										}
										pushFollow(FOLLOW_26);
										lv_combinator_5_0 = rulecombinator();

										state._fsp--;
										if (state.failed) {
											return current;
										}
										if (state.backtracking == 0) {

											if (current == null) {
												current = createModelElementForParent(grammarAccess.getSelectorRule());
											}
											set(
													current,
													"combinator",
													lv_combinator_5_0,
													"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.combinator");
											afterParserOrEnumRuleCall();

										}

									}


								}

								// InternalCSS.g:1165:2: (this_WS_6= RULE_WS )*
								loop36: do {
									int alt36 = 2;
									int LA36_0 = input.LA(1);

									if ((LA36_0 == RULE_WS)) {
										alt36 = 1;
									}


									switch (alt36) {
									case 1:
									// InternalCSS.g:1165:3: this_WS_6= RULE_WS
									{
										this_WS_6 = (Token) match(input, RULE_WS, FOLLOW_26);
										if (state.failed) {
											return current;
										}
										if (state.backtracking == 0) {

											newLeafNode(this_WS_6, grammarAccess.getSelectorAccess().getWSTerminalRuleCall_1_1_1_1());

										}

									}
										break;

									default:
										break loop36;
									}
								} while (true);


							}
								break;

							}

							// InternalCSS.g:1169:5: ( (lv_selector_7_0= ruleselector ) )
							// InternalCSS.g:1170:1: (lv_selector_7_0= ruleselector )
							{
								// InternalCSS.g:1170:1: (lv_selector_7_0= ruleselector )
								// InternalCSS.g:1171:3: lv_selector_7_0= ruleselector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSelectorAccess().getSelectorSelectorParserRuleCall_1_1_2_0());

									}
									pushFollow(FOLLOW_2);
									lv_selector_7_0 = ruleselector();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSelectorRule());
										}
										set(
												current,
												"selector",
												lv_selector_7_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.selector");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}


					}
						break;

					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "ruleselector"


	// $ANTLR start "entryRuleSimpleSelectorForNegation"
	// InternalCSS.g:1198:1: entryRuleSimpleSelectorForNegation returns [EObject current=null] : iv_ruleSimpleSelectorForNegation= ruleSimpleSelectorForNegation EOF ;
	public final EObject entryRuleSimpleSelectorForNegation() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSimpleSelectorForNegation = null;


		try {
			// InternalCSS.g:1199:2: (iv_ruleSimpleSelectorForNegation= ruleSimpleSelectorForNegation EOF )
			// InternalCSS.g:1200:2: iv_ruleSimpleSelectorForNegation= ruleSimpleSelectorForNegation EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getSimpleSelectorForNegationRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleSimpleSelectorForNegation = ruleSimpleSelectorForNegation();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleSimpleSelectorForNegation;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleSimpleSelectorForNegation"


	// $ANTLR start "ruleSimpleSelectorForNegation"
	// InternalCSS.g:1207:1: ruleSimpleSelectorForNegation returns [EObject current=null] : ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )* ) | ( ( (
	// ruleSubSelectorForNegation ) )=> (lv_subSelectors_3_0= ruleSubSelectorForNegation ) )+ ) ;
	public final EObject ruleSimpleSelectorForNegation() throws RecognitionException {
		EObject current = null;

		EObject lv_element_0_0 = null;

		EObject lv_universal_1_0 = null;

		EObject lv_subSelectors_2_0 = null;

		EObject lv_subSelectors_3_0 = null;


		enterRule();

		try {
			// InternalCSS.g:1210:28: ( ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )* ) | ( ( ( ruleSubSelectorForNegation ) )=> (lv_subSelectors_3_0=
			// ruleSubSelectorForNegation ) )+ ) )
			// InternalCSS.g:1211:1: ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )* ) | ( ( ( ruleSubSelectorForNegation ) )=> (lv_subSelectors_3_0=
			// ruleSubSelectorForNegation ) )+ )
			{
				// InternalCSS.g:1211:1: ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )* ) | ( ( ( ruleSubSelectorForNegation ) )=>
				// (lv_subSelectors_3_0= ruleSubSelectorForNegation ) )+ )
				int alt42 = 2;
				int LA42_0 = input.LA(1);

				if (((LA42_0 >= RULE_DASH && LA42_0 <= RULE_ONE_NON_HEX_LETTER) || (LA42_0 >= 42 && LA42_0 <= 43) || (LA42_0 >= 56 && LA42_0 <= 59))) {
					alt42 = 1;
				} else if ((LA42_0 == RULE_COLON || LA42_0 == RULE_HASHMARK || LA42_0 == 35 || LA42_0 == 41)) {
					alt42 = 2;
				} else {
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 42, 0, input);

					throw nvae;
				}
				switch (alt42) {
				case 1:
				// InternalCSS.g:1211:2: ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )* )
				{
					// InternalCSS.g:1211:2: ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )* )
					// InternalCSS.g:1211:3: ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )*
					{
						// InternalCSS.g:1211:3: ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) )
						int alt39 = 2;
						alt39 = dfa39.predict(input);
						switch (alt39) {
						case 1:
						// InternalCSS.g:1211:4: ( (lv_element_0_0= ruleElementSelector ) )
						{
							// InternalCSS.g:1211:4: ( (lv_element_0_0= ruleElementSelector ) )
							// InternalCSS.g:1212:1: (lv_element_0_0= ruleElementSelector )
							{
								// InternalCSS.g:1212:1: (lv_element_0_0= ruleElementSelector )
								// InternalCSS.g:1213:3: lv_element_0_0= ruleElementSelector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSimpleSelectorForNegationAccess().getElementElementSelectorParserRuleCall_0_0_0_0());

									}
									pushFollow(FOLLOW_28);
									lv_element_0_0 = ruleElementSelector();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSimpleSelectorForNegationRule());
										}
										set(
												current,
												"element",
												lv_element_0_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.ElementSelector");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;
						case 2:
						// InternalCSS.g:1230:6: ( (lv_universal_1_0= ruleUniversalSelector ) )
						{
							// InternalCSS.g:1230:6: ( (lv_universal_1_0= ruleUniversalSelector ) )
							// InternalCSS.g:1231:1: (lv_universal_1_0= ruleUniversalSelector )
							{
								// InternalCSS.g:1231:1: (lv_universal_1_0= ruleUniversalSelector )
								// InternalCSS.g:1232:3: lv_universal_1_0= ruleUniversalSelector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSimpleSelectorForNegationAccess().getUniversalUniversalSelectorParserRuleCall_0_0_1_0());

									}
									pushFollow(FOLLOW_28);
									lv_universal_1_0 = ruleUniversalSelector();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSimpleSelectorForNegationRule());
										}
										set(
												current,
												"universal",
												lv_universal_1_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.UniversalSelector");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;

						}

						// InternalCSS.g:1248:3: ( (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )*
						loop40: do {
							int alt40 = 2;
							int LA40_0 = input.LA(1);

							if ((LA40_0 == RULE_COLON || LA40_0 == RULE_HASHMARK || LA40_0 == 35 || LA40_0 == 41)) {
								alt40 = 1;
							}


							switch (alt40) {
							case 1:
							// InternalCSS.g:1249:1: (lv_subSelectors_2_0= ruleSubSelectorForNegation )
							{
								// InternalCSS.g:1249:1: (lv_subSelectors_2_0= ruleSubSelectorForNegation )
								// InternalCSS.g:1250:3: lv_subSelectors_2_0= ruleSubSelectorForNegation
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSimpleSelectorForNegationAccess().getSubSelectorsSubSelectorForNegationParserRuleCall_0_1_0());

									}
									pushFollow(FOLLOW_28);
									lv_subSelectors_2_0 = ruleSubSelectorForNegation();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSimpleSelectorForNegationRule());
										}
										add(
												current,
												"subSelectors",
												lv_subSelectors_2_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.SubSelectorForNegation");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							default:
								break loop40;
							}
						} while (true);


					}


				}
					break;
				case 2:
				// InternalCSS.g:1267:6: ( ( ( ruleSubSelectorForNegation ) )=> (lv_subSelectors_3_0= ruleSubSelectorForNegation ) )+
				{
					// InternalCSS.g:1267:6: ( ( ( ruleSubSelectorForNegation ) )=> (lv_subSelectors_3_0= ruleSubSelectorForNegation ) )+
					int cnt41 = 0;
					loop41: do {
						int alt41 = 2;
						int LA41_0 = input.LA(1);

						if ((LA41_0 == RULE_HASHMARK) && (synpred1_InternalCSS())) {
							alt41 = 1;
						} else if ((LA41_0 == 41) && (synpred1_InternalCSS())) {
							alt41 = 1;
						} else if ((LA41_0 == 35) && (synpred1_InternalCSS())) {
							alt41 = 1;
						} else if ((LA41_0 == RULE_COLON) && (synpred1_InternalCSS())) {
							alt41 = 1;
						}


						switch (alt41) {
						case 1:
						// InternalCSS.g:1267:7: ( ( ruleSubSelectorForNegation ) )=> (lv_subSelectors_3_0= ruleSubSelectorForNegation )
						{
							// InternalCSS.g:1272:1: (lv_subSelectors_3_0= ruleSubSelectorForNegation )
							// InternalCSS.g:1273:3: lv_subSelectors_3_0= ruleSubSelectorForNegation
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getSimpleSelectorForNegationAccess().getSubSelectorsSubSelectorForNegationParserRuleCall_1_0());

								}
								pushFollow(FOLLOW_28);
								lv_subSelectors_3_0 = ruleSubSelectorForNegation();

								state._fsp--;
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getSimpleSelectorForNegationRule());
									}
									add(
											current,
											"subSelectors",
											lv_subSelectors_3_0,
											"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.SubSelectorForNegation");
									afterParserOrEnumRuleCall();

								}

							}


						}
							break;

						default:
							if (cnt41 >= 1) {
								break loop41;
							}
							if (state.backtracking > 0) {
								state.failed = true;
								return current;
							}
							EarlyExitException eee = new EarlyExitException(41, input);
							throw eee;
						}
						cnt41++;
					} while (true);


				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleSimpleSelectorForNegation"


	// $ANTLR start "entryRuleSubSelectorForNegation"
	// InternalCSS.g:1297:1: entryRuleSubSelectorForNegation returns [EObject current=null] : iv_ruleSubSelectorForNegation= ruleSubSelectorForNegation EOF ;
	public final EObject entryRuleSubSelectorForNegation() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSubSelectorForNegation = null;


		try {
			// InternalCSS.g:1298:2: (iv_ruleSubSelectorForNegation= ruleSubSelectorForNegation EOF )
			// InternalCSS.g:1299:2: iv_ruleSubSelectorForNegation= ruleSubSelectorForNegation EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getSubSelectorForNegationRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleSubSelectorForNegation = ruleSubSelectorForNegation();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleSubSelectorForNegation;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleSubSelectorForNegation"


	// $ANTLR start "ruleSubSelectorForNegation"
	// InternalCSS.g:1306:1: ruleSubSelectorForNegation returns [EObject current=null] : (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1= ruleClassSelector | this_AttributeSelector_2= ruleAttributeSelector | this_PseudoClass_3= rulePseudoClass ) ;
	public final EObject ruleSubSelectorForNegation() throws RecognitionException {
		EObject current = null;

		EObject this_IdSelector_0 = null;

		EObject this_ClassSelector_1 = null;

		EObject this_AttributeSelector_2 = null;

		EObject this_PseudoClass_3 = null;


		enterRule();

		try {
			// InternalCSS.g:1309:28: ( (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1= ruleClassSelector | this_AttributeSelector_2= ruleAttributeSelector | this_PseudoClass_3= rulePseudoClass ) )
			// InternalCSS.g:1310:1: (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1= ruleClassSelector | this_AttributeSelector_2= ruleAttributeSelector | this_PseudoClass_3= rulePseudoClass )
			{
				// InternalCSS.g:1310:1: (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1= ruleClassSelector | this_AttributeSelector_2= ruleAttributeSelector | this_PseudoClass_3= rulePseudoClass )
				int alt43 = 4;
				switch (input.LA(1)) {
				case RULE_HASHMARK: {
					alt43 = 1;
				}
					break;
				case 41: {
					alt43 = 2;
				}
					break;
				case 35: {
					alt43 = 3;
				}
					break;
				case RULE_COLON: {
					alt43 = 4;
				}
					break;
				default:
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 43, 0, input);

					throw nvae;
				}

				switch (alt43) {
				case 1:
				// InternalCSS.g:1311:5: this_IdSelector_0= ruleIdSelector
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorForNegationAccess().getIdSelectorParserRuleCall_0());

					}
					pushFollow(FOLLOW_2);
					this_IdSelector_0 = ruleIdSelector();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_IdSelector_0;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 2:
				// InternalCSS.g:1321:5: this_ClassSelector_1= ruleClassSelector
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorForNegationAccess().getClassSelectorParserRuleCall_1());

					}
					pushFollow(FOLLOW_2);
					this_ClassSelector_1 = ruleClassSelector();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_ClassSelector_1;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 3:
				// InternalCSS.g:1331:5: this_AttributeSelector_2= ruleAttributeSelector
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorForNegationAccess().getAttributeSelectorParserRuleCall_2());

					}
					pushFollow(FOLLOW_2);
					this_AttributeSelector_2 = ruleAttributeSelector();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_AttributeSelector_2;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 4:
				// InternalCSS.g:1341:5: this_PseudoClass_3= rulePseudoClass
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorForNegationAccess().getPseudoClassParserRuleCall_3());

					}
					pushFollow(FOLLOW_2);
					this_PseudoClass_3 = rulePseudoClass();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_PseudoClass_3;
						afterParserOrEnumRuleCall();

					}

				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleSubSelectorForNegation"


	// $ANTLR start "entryRulesimple_selector"
	// InternalCSS.g:1357:1: entryRulesimple_selector returns [EObject current=null] : iv_rulesimple_selector= rulesimple_selector EOF ;
	public final EObject entryRulesimple_selector() throws RecognitionException {
		EObject current = null;

		EObject iv_rulesimple_selector = null;



		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens("RULE_ML_COMMENT");

		try {
			// InternalCSS.g:1361:2: (iv_rulesimple_selector= rulesimple_selector EOF )
			// InternalCSS.g:1362:2: iv_rulesimple_selector= rulesimple_selector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getSimple_selectorRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulesimple_selector = rulesimple_selector();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulesimple_selector;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRulesimple_selector"


	// $ANTLR start "rulesimple_selector"
	// InternalCSS.g:1372:1: rulesimple_selector returns [EObject current=null] : ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelector ) )* ) | ( (lv_subSelectors_3_0=
	// ruleSubSelector ) )+ ) ;
	public final EObject rulesimple_selector() throws RecognitionException {
		EObject current = null;

		EObject lv_element_0_0 = null;

		EObject lv_universal_1_0 = null;

		EObject lv_subSelectors_2_0 = null;

		EObject lv_subSelectors_3_0 = null;


		enterRule();
		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens("RULE_ML_COMMENT");

		try {
			// InternalCSS.g:1376:28: ( ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelector ) )* ) | ( (lv_subSelectors_3_0= ruleSubSelector ) )+ ) )
			// InternalCSS.g:1377:1: ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelector ) )* ) | ( (lv_subSelectors_3_0= ruleSubSelector ) )+ )
			{
				// InternalCSS.g:1377:1: ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelector ) )* ) | ( (lv_subSelectors_3_0= ruleSubSelector ) )+ )
				int alt47 = 2;
				int LA47_0 = input.LA(1);

				if (((LA47_0 >= RULE_DASH && LA47_0 <= RULE_ONE_NON_HEX_LETTER) || (LA47_0 >= 42 && LA47_0 <= 43) || (LA47_0 >= 56 && LA47_0 <= 59))) {
					alt47 = 1;
				} else if ((LA47_0 == RULE_COLON || LA47_0 == RULE_HASHMARK || LA47_0 == 35 || LA47_0 == 41)) {
					alt47 = 2;
				} else {
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 47, 0, input);

					throw nvae;
				}
				switch (alt47) {
				case 1:
				// InternalCSS.g:1377:2: ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelector ) )* )
				{
					// InternalCSS.g:1377:2: ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelector ) )* )
					// InternalCSS.g:1377:3: ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelector ) )*
					{
						// InternalCSS.g:1377:3: ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) )
						int alt44 = 2;
						alt44 = dfa44.predict(input);
						switch (alt44) {
						case 1:
						// InternalCSS.g:1377:4: ( (lv_element_0_0= ruleElementSelector ) )
						{
							// InternalCSS.g:1377:4: ( (lv_element_0_0= ruleElementSelector ) )
							// InternalCSS.g:1378:1: (lv_element_0_0= ruleElementSelector )
							{
								// InternalCSS.g:1378:1: (lv_element_0_0= ruleElementSelector )
								// InternalCSS.g:1379:3: lv_element_0_0= ruleElementSelector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSimple_selectorAccess().getElementElementSelectorParserRuleCall_0_0_0_0());

									}
									pushFollow(FOLLOW_29);
									lv_element_0_0 = ruleElementSelector();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSimple_selectorRule());
										}
										set(
												current,
												"element",
												lv_element_0_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.ElementSelector");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;
						case 2:
						// InternalCSS.g:1396:6: ( (lv_universal_1_0= ruleUniversalSelector ) )
						{
							// InternalCSS.g:1396:6: ( (lv_universal_1_0= ruleUniversalSelector ) )
							// InternalCSS.g:1397:1: (lv_universal_1_0= ruleUniversalSelector )
							{
								// InternalCSS.g:1397:1: (lv_universal_1_0= ruleUniversalSelector )
								// InternalCSS.g:1398:3: lv_universal_1_0= ruleUniversalSelector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSimple_selectorAccess().getUniversalUniversalSelectorParserRuleCall_0_0_1_0());

									}
									pushFollow(FOLLOW_29);
									lv_universal_1_0 = ruleUniversalSelector();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSimple_selectorRule());
										}
										set(
												current,
												"universal",
												lv_universal_1_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.UniversalSelector");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;

						}

						// InternalCSS.g:1414:3: ( (lv_subSelectors_2_0= ruleSubSelector ) )*
						loop45: do {
							int alt45 = 2;
							int LA45_0 = input.LA(1);

							if ((LA45_0 == RULE_COLON || LA45_0 == RULE_HASHMARK || LA45_0 == 35 || LA45_0 == 41)) {
								alt45 = 1;
							}


							switch (alt45) {
							case 1:
							// InternalCSS.g:1415:1: (lv_subSelectors_2_0= ruleSubSelector )
							{
								// InternalCSS.g:1415:1: (lv_subSelectors_2_0= ruleSubSelector )
								// InternalCSS.g:1416:3: lv_subSelectors_2_0= ruleSubSelector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSimple_selectorAccess().getSubSelectorsSubSelectorParserRuleCall_0_1_0());

									}
									pushFollow(FOLLOW_29);
									lv_subSelectors_2_0 = ruleSubSelector();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSimple_selectorRule());
										}
										add(
												current,
												"subSelectors",
												lv_subSelectors_2_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.SubSelector");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							default:
								break loop45;
							}
						} while (true);


					}


				}
					break;
				case 2:
				// InternalCSS.g:1433:6: ( (lv_subSelectors_3_0= ruleSubSelector ) )+
				{
					// InternalCSS.g:1433:6: ( (lv_subSelectors_3_0= ruleSubSelector ) )+
					int cnt46 = 0;
					loop46: do {
						int alt46 = 2;
						int LA46_0 = input.LA(1);

						if ((LA46_0 == RULE_COLON || LA46_0 == RULE_HASHMARK || LA46_0 == 35 || LA46_0 == 41)) {
							alt46 = 1;
						}


						switch (alt46) {
						case 1:
						// InternalCSS.g:1434:1: (lv_subSelectors_3_0= ruleSubSelector )
						{
							// InternalCSS.g:1434:1: (lv_subSelectors_3_0= ruleSubSelector )
							// InternalCSS.g:1435:3: lv_subSelectors_3_0= ruleSubSelector
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getSimple_selectorAccess().getSubSelectorsSubSelectorParserRuleCall_1_0());

								}
								pushFollow(FOLLOW_29);
								lv_subSelectors_3_0 = ruleSubSelector();

								state._fsp--;
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getSimple_selectorRule());
									}
									add(
											current,
											"subSelectors",
											lv_subSelectors_3_0,
											"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.SubSelector");
									afterParserOrEnumRuleCall();

								}

							}


						}
							break;

						default:
							if (cnt46 >= 1) {
								break loop46;
							}
							if (state.backtracking > 0) {
								state.failed = true;
								return current;
							}
							EarlyExitException eee = new EarlyExitException(46, input);
							throw eee;
						}
						cnt46++;
					} while (true);


				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "rulesimple_selector"


	// $ANTLR start "entryRuleSubSelector"
	// InternalCSS.g:1462:1: entryRuleSubSelector returns [EObject current=null] : iv_ruleSubSelector= ruleSubSelector EOF ;
	public final EObject entryRuleSubSelector() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSubSelector = null;


		try {
			// InternalCSS.g:1463:2: (iv_ruleSubSelector= ruleSubSelector EOF )
			// InternalCSS.g:1464:2: iv_ruleSubSelector= ruleSubSelector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getSubSelectorRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleSubSelector = ruleSubSelector();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleSubSelector;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleSubSelector"


	// $ANTLR start "ruleSubSelector"
	// InternalCSS.g:1471:1: ruleSubSelector returns [EObject current=null] : (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1= ruleClassSelector | this_AttributeSelector_2= ruleAttributeSelector | this_PseudoClassOrFunc_3= rulePseudoClassOrFunc ) ;
	public final EObject ruleSubSelector() throws RecognitionException {
		EObject current = null;

		EObject this_IdSelector_0 = null;

		EObject this_ClassSelector_1 = null;

		EObject this_AttributeSelector_2 = null;

		EObject this_PseudoClassOrFunc_3 = null;


		enterRule();

		try {
			// InternalCSS.g:1474:28: ( (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1= ruleClassSelector | this_AttributeSelector_2= ruleAttributeSelector | this_PseudoClassOrFunc_3= rulePseudoClassOrFunc ) )
			// InternalCSS.g:1475:1: (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1= ruleClassSelector | this_AttributeSelector_2= ruleAttributeSelector | this_PseudoClassOrFunc_3= rulePseudoClassOrFunc )
			{
				// InternalCSS.g:1475:1: (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1= ruleClassSelector | this_AttributeSelector_2= ruleAttributeSelector | this_PseudoClassOrFunc_3= rulePseudoClassOrFunc )
				int alt48 = 4;
				switch (input.LA(1)) {
				case RULE_HASHMARK: {
					alt48 = 1;
				}
					break;
				case 41: {
					alt48 = 2;
				}
					break;
				case 35: {
					alt48 = 3;
				}
					break;
				case RULE_COLON: {
					alt48 = 4;
				}
					break;
				default:
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 48, 0, input);

					throw nvae;
				}

				switch (alt48) {
				case 1:
				// InternalCSS.g:1476:5: this_IdSelector_0= ruleIdSelector
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorAccess().getIdSelectorParserRuleCall_0());

					}
					pushFollow(FOLLOW_2);
					this_IdSelector_0 = ruleIdSelector();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_IdSelector_0;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 2:
				// InternalCSS.g:1486:5: this_ClassSelector_1= ruleClassSelector
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorAccess().getClassSelectorParserRuleCall_1());

					}
					pushFollow(FOLLOW_2);
					this_ClassSelector_1 = ruleClassSelector();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_ClassSelector_1;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 3:
				// InternalCSS.g:1496:5: this_AttributeSelector_2= ruleAttributeSelector
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorAccess().getAttributeSelectorParserRuleCall_2());

					}
					pushFollow(FOLLOW_2);
					this_AttributeSelector_2 = ruleAttributeSelector();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_AttributeSelector_2;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 4:
				// InternalCSS.g:1506:5: this_PseudoClassOrFunc_3= rulePseudoClassOrFunc
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorAccess().getPseudoClassOrFuncParserRuleCall_3());

					}
					pushFollow(FOLLOW_2);
					this_PseudoClassOrFunc_3 = rulePseudoClassOrFunc();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_PseudoClassOrFunc_3;
						afterParserOrEnumRuleCall();

					}

				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleSubSelector"


	// $ANTLR start "entryRuleAttributeSelector"
	// InternalCSS.g:1522:1: entryRuleAttributeSelector returns [EObject current=null] : iv_ruleAttributeSelector= ruleAttributeSelector EOF ;
	public final EObject entryRuleAttributeSelector() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleAttributeSelector = null;


		try {
			// InternalCSS.g:1523:2: (iv_ruleAttributeSelector= ruleAttributeSelector EOF )
			// InternalCSS.g:1524:2: iv_ruleAttributeSelector= ruleAttributeSelector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getAttributeSelectorRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleAttributeSelector = ruleAttributeSelector();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleAttributeSelector;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleAttributeSelector"


	// $ANTLR start "ruleAttributeSelector"
	// InternalCSS.g:1531:1: ruleAttributeSelector returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_name_2_0= ruleIdentifier ) ) ( ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6=
	// RULE_DASHMATCH ) ) ) ( ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) ) )? otherlv_5= ']' ) ;
	public final EObject ruleAttributeSelector() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		Token lv_op_3_1 = null;
		Token lv_op_3_2 = null;
		Token lv_op_3_3 = null;
		Token lv_op_3_4 = null;
		Token lv_op_3_5 = null;
		Token lv_op_3_6 = null;
		Token lv_value_4_2 = null;
		Token otherlv_5 = null;
		AntlrDatatypeRuleToken lv_name_2_0 = null;

		AntlrDatatypeRuleToken lv_value_4_1 = null;


		enterRule();

		try {
			// InternalCSS.g:1534:28: ( ( () otherlv_1= '[' ( (lv_name_2_0= ruleIdentifier ) ) ( ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) ) ( ( (lv_value_4_1=
			// ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) ) )? otherlv_5= ']' ) )
			// InternalCSS.g:1535:1: ( () otherlv_1= '[' ( (lv_name_2_0= ruleIdentifier ) ) ( ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) ) ( ( (lv_value_4_1=
			// ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) ) )? otherlv_5= ']' )
			{
				// InternalCSS.g:1535:1: ( () otherlv_1= '[' ( (lv_name_2_0= ruleIdentifier ) ) ( ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) ) ( ( (lv_value_4_1=
				// ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) ) )? otherlv_5= ']' )
				// InternalCSS.g:1535:2: () otherlv_1= '[' ( (lv_name_2_0= ruleIdentifier ) ) ( ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) ) ( ( (lv_value_4_1=
				// ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) ) )? otherlv_5= ']'
				{
					// InternalCSS.g:1535:2: ()
					// InternalCSS.g:1536:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getAttributeSelectorAccess().getAttributeSelectorAction_0(),
									current);

						}

					}

					otherlv_1 = (Token) match(input, 35, FOLLOW_13);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_1, grammarAccess.getAttributeSelectorAccess().getLeftSquareBracketKeyword_1());

					}
					// InternalCSS.g:1545:1: ( (lv_name_2_0= ruleIdentifier ) )
					// InternalCSS.g:1546:1: (lv_name_2_0= ruleIdentifier )
					{
						// InternalCSS.g:1546:1: (lv_name_2_0= ruleIdentifier )
						// InternalCSS.g:1547:3: lv_name_2_0= ruleIdentifier
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getAttributeSelectorAccess().getNameIdentifierParserRuleCall_2_0());

							}
							pushFollow(FOLLOW_30);
							lv_name_2_0 = ruleIdentifier();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getAttributeSelectorRule());
								}
								set(
										current,
										"name",
										lv_name_2_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.Identifier");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalCSS.g:1563:2: ( ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) ) ( ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) ) )?
					int alt51 = 2;
					int LA51_0 = input.LA(1);

					if (((LA51_0 >= RULE_INCLUDES && LA51_0 <= RULE_DASHMATCH) || (LA51_0 >= 36 && LA51_0 <= 39))) {
						alt51 = 1;
					}
					switch (alt51) {
					case 1:
					// InternalCSS.g:1563:3: ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) ) ( ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) )
					{
						// InternalCSS.g:1563:3: ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) )
						// InternalCSS.g:1564:1: ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) )
						{
							// InternalCSS.g:1564:1: ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) )
							// InternalCSS.g:1565:1: (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH )
							{
								// InternalCSS.g:1565:1: (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH )
								int alt49 = 6;
								switch (input.LA(1)) {
								case 36: {
									alt49 = 1;
								}
									break;
								case 37: {
									alt49 = 2;
								}
									break;
								case 38: {
									alt49 = 3;
								}
									break;
								case 39: {
									alt49 = 4;
								}
									break;
								case RULE_INCLUDES: {
									alt49 = 5;
								}
									break;
								case RULE_DASHMATCH: {
									alt49 = 6;
								}
									break;
								default:
									if (state.backtracking > 0) {
										state.failed = true;
										return current;
									}
									NoViableAltException nvae = new NoViableAltException("", 49, 0, input);

									throw nvae;
								}

								switch (alt49) {
								case 1:
								// InternalCSS.g:1566:3: lv_op_3_1= '^='
								{
									lv_op_3_1 = (Token) match(input, 36, FOLLOW_31);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										newLeafNode(lv_op_3_1, grammarAccess.getAttributeSelectorAccess().getOpCircumflexAccentEqualsSignKeyword_3_0_0_0());

									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElement(grammarAccess.getAttributeSelectorRule());
										}
										setWithLastConsumed(current, "op", lv_op_3_1, null);

									}

								}
									break;
								case 2:
								// InternalCSS.g:1578:8: lv_op_3_2= '$='
								{
									lv_op_3_2 = (Token) match(input, 37, FOLLOW_31);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										newLeafNode(lv_op_3_2, grammarAccess.getAttributeSelectorAccess().getOpDollarSignEqualsSignKeyword_3_0_0_1());

									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElement(grammarAccess.getAttributeSelectorRule());
										}
										setWithLastConsumed(current, "op", lv_op_3_2, null);

									}

								}
									break;
								case 3:
								// InternalCSS.g:1590:8: lv_op_3_3= '*='
								{
									lv_op_3_3 = (Token) match(input, 38, FOLLOW_31);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										newLeafNode(lv_op_3_3, grammarAccess.getAttributeSelectorAccess().getOpAsteriskEqualsSignKeyword_3_0_0_2());

									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElement(grammarAccess.getAttributeSelectorRule());
										}
										setWithLastConsumed(current, "op", lv_op_3_3, null);

									}

								}
									break;
								case 4:
								// InternalCSS.g:1602:8: lv_op_3_4= '='
								{
									lv_op_3_4 = (Token) match(input, 39, FOLLOW_31);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										newLeafNode(lv_op_3_4, grammarAccess.getAttributeSelectorAccess().getOpEqualsSignKeyword_3_0_0_3());

									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElement(grammarAccess.getAttributeSelectorRule());
										}
										setWithLastConsumed(current, "op", lv_op_3_4, null);

									}

								}
									break;
								case 5:
								// InternalCSS.g:1614:8: lv_op_3_5= RULE_INCLUDES
								{
									lv_op_3_5 = (Token) match(input, RULE_INCLUDES, FOLLOW_31);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										newLeafNode(lv_op_3_5, grammarAccess.getAttributeSelectorAccess().getOpINCLUDESTerminalRuleCall_3_0_0_4());

									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElement(grammarAccess.getAttributeSelectorRule());
										}
										setWithLastConsumed(
												current,
												"op",
												lv_op_3_5,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.INCLUDES");

									}

								}
									break;
								case 6:
								// InternalCSS.g:1629:8: lv_op_3_6= RULE_DASHMATCH
								{
									lv_op_3_6 = (Token) match(input, RULE_DASHMATCH, FOLLOW_31);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										newLeafNode(lv_op_3_6, grammarAccess.getAttributeSelectorAccess().getOpDASHMATCHTerminalRuleCall_3_0_0_5());

									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElement(grammarAccess.getAttributeSelectorRule());
										}
										setWithLastConsumed(
												current,
												"op",
												lv_op_3_6,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.DASHMATCH");

									}

								}
									break;

								}


							}


						}

						// InternalCSS.g:1647:2: ( ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) )
						// InternalCSS.g:1648:1: ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) )
						{
							// InternalCSS.g:1648:1: ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) )
							// InternalCSS.g:1649:1: (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING )
							{
								// InternalCSS.g:1649:1: (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING )
								int alt50 = 2;
								int LA50_0 = input.LA(1);

								if (((LA50_0 >= RULE_DASH && LA50_0 <= RULE_ONE_NON_HEX_LETTER) || (LA50_0 >= 56 && LA50_0 <= 59))) {
									alt50 = 1;
								} else if ((LA50_0 == RULE_CSSSTRING)) {
									alt50 = 2;
								} else {
									if (state.backtracking > 0) {
										state.failed = true;
										return current;
									}
									NoViableAltException nvae = new NoViableAltException("", 50, 0, input);

									throw nvae;
								}
								switch (alt50) {
								case 1:
								// InternalCSS.g:1650:3: lv_value_4_1= ruleIdentifier
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getAttributeSelectorAccess().getValueIdentifierParserRuleCall_3_1_0_0());

									}
									pushFollow(FOLLOW_32);
									lv_value_4_1 = ruleIdentifier();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getAttributeSelectorRule());
										}
										set(
												current,
												"value",
												lv_value_4_1,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.Identifier");
										afterParserOrEnumRuleCall();

									}

								}
									break;
								case 2:
								// InternalCSS.g:1665:8: lv_value_4_2= RULE_CSSSTRING
								{
									lv_value_4_2 = (Token) match(input, RULE_CSSSTRING, FOLLOW_32);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										newLeafNode(lv_value_4_2, grammarAccess.getAttributeSelectorAccess().getValueCSSSTRINGTerminalRuleCall_3_1_0_1());

									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElement(grammarAccess.getAttributeSelectorRule());
										}
										setWithLastConsumed(
												current,
												"value",
												lv_value_4_2,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.CSSSTRING");

									}

								}
									break;

								}


							}


						}


					}
						break;

					}

					otherlv_5 = (Token) match(input, 40, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_5, grammarAccess.getAttributeSelectorAccess().getRightSquareBracketKeyword_4());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleAttributeSelector"


	// $ANTLR start "entryRuleClassSelector"
	// InternalCSS.g:1695:1: entryRuleClassSelector returns [EObject current=null] : iv_ruleClassSelector= ruleClassSelector EOF ;
	public final EObject entryRuleClassSelector() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleClassSelector = null;


		try {
			// InternalCSS.g:1696:2: (iv_ruleClassSelector= ruleClassSelector EOF )
			// InternalCSS.g:1697:2: iv_ruleClassSelector= ruleClassSelector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getClassSelectorRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleClassSelector = ruleClassSelector();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleClassSelector;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleClassSelector"


	// $ANTLR start "ruleClassSelector"
	// InternalCSS.g:1704:1: ruleClassSelector returns [EObject current=null] : ( () otherlv_1= '.' ( (lv_name_2_0= ruleIdentifier ) ) ) ;
	public final EObject ruleClassSelector() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		AntlrDatatypeRuleToken lv_name_2_0 = null;


		enterRule();

		try {
			// InternalCSS.g:1707:28: ( ( () otherlv_1= '.' ( (lv_name_2_0= ruleIdentifier ) ) ) )
			// InternalCSS.g:1708:1: ( () otherlv_1= '.' ( (lv_name_2_0= ruleIdentifier ) ) )
			{
				// InternalCSS.g:1708:1: ( () otherlv_1= '.' ( (lv_name_2_0= ruleIdentifier ) ) )
				// InternalCSS.g:1708:2: () otherlv_1= '.' ( (lv_name_2_0= ruleIdentifier ) )
				{
					// InternalCSS.g:1708:2: ()
					// InternalCSS.g:1709:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getClassSelectorAccess().getClassSelectorAction_0(),
									current);

						}

					}

					otherlv_1 = (Token) match(input, 41, FOLLOW_13);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_1, grammarAccess.getClassSelectorAccess().getFullStopKeyword_1());

					}
					// InternalCSS.g:1718:1: ( (lv_name_2_0= ruleIdentifier ) )
					// InternalCSS.g:1719:1: (lv_name_2_0= ruleIdentifier )
					{
						// InternalCSS.g:1719:1: (lv_name_2_0= ruleIdentifier )
						// InternalCSS.g:1720:3: lv_name_2_0= ruleIdentifier
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getClassSelectorAccess().getNameIdentifierParserRuleCall_2_0());

							}
							pushFollow(FOLLOW_2);
							lv_name_2_0 = ruleIdentifier();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getClassSelectorRule());
								}
								set(
										current,
										"name",
										lv_name_2_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.Identifier");
								afterParserOrEnumRuleCall();

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleClassSelector"


	// $ANTLR start "entryRuleElementSelector"
	// InternalCSS.g:1744:1: entryRuleElementSelector returns [EObject current=null] : iv_ruleElementSelector= ruleElementSelector EOF ;
	public final EObject entryRuleElementSelector() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleElementSelector = null;


		try {
			// InternalCSS.g:1745:2: (iv_ruleElementSelector= ruleElementSelector EOF )
			// InternalCSS.g:1746:2: iv_ruleElementSelector= ruleElementSelector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getElementSelectorRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleElementSelector = ruleElementSelector();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleElementSelector;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleElementSelector"


	// $ANTLR start "ruleElementSelector"
	// InternalCSS.g:1753:1: ruleElementSelector returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) ) ;
	public final EObject ruleElementSelector() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_name_1_0 = null;


		enterRule();

		try {
			// InternalCSS.g:1756:28: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) ) )
			// InternalCSS.g:1757:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) )
			{
				// InternalCSS.g:1757:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) )
				// InternalCSS.g:1757:2: () ( (lv_name_1_0= ruleIdentifier ) )
				{
					// InternalCSS.g:1757:2: ()
					// InternalCSS.g:1758:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getElementSelectorAccess().getElementSelectorAction_0(),
									current);

						}

					}

					// InternalCSS.g:1763:2: ( (lv_name_1_0= ruleIdentifier ) )
					// InternalCSS.g:1764:1: (lv_name_1_0= ruleIdentifier )
					{
						// InternalCSS.g:1764:1: (lv_name_1_0= ruleIdentifier )
						// InternalCSS.g:1765:3: lv_name_1_0= ruleIdentifier
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getElementSelectorAccess().getNameIdentifierParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_2);
							lv_name_1_0 = ruleIdentifier();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getElementSelectorRule());
								}
								set(
										current,
										"name",
										lv_name_1_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.Identifier");
								afterParserOrEnumRuleCall();

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleElementSelector"


	// $ANTLR start "entryRuleUniversalSelector"
	// InternalCSS.g:1789:1: entryRuleUniversalSelector returns [EObject current=null] : iv_ruleUniversalSelector= ruleUniversalSelector EOF ;
	public final EObject entryRuleUniversalSelector() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleUniversalSelector = null;


		try {
			// InternalCSS.g:1790:2: (iv_ruleUniversalSelector= ruleUniversalSelector EOF )
			// InternalCSS.g:1791:2: iv_ruleUniversalSelector= ruleUniversalSelector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getUniversalSelectorRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleUniversalSelector = ruleUniversalSelector();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleUniversalSelector;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleUniversalSelector"


	// $ANTLR start "ruleUniversalSelector"
	// InternalCSS.g:1798:1: ruleUniversalSelector returns [EObject current=null] : ( () ( (lv_namespace_1_0= rulecss_namespace_prefix ) )? otherlv_2= '*' ) ;
	public final EObject ruleUniversalSelector() throws RecognitionException {
		EObject current = null;

		Token otherlv_2 = null;
		AntlrDatatypeRuleToken lv_namespace_1_0 = null;


		enterRule();

		try {
			// InternalCSS.g:1801:28: ( ( () ( (lv_namespace_1_0= rulecss_namespace_prefix ) )? otherlv_2= '*' ) )
			// InternalCSS.g:1802:1: ( () ( (lv_namespace_1_0= rulecss_namespace_prefix ) )? otherlv_2= '*' )
			{
				// InternalCSS.g:1802:1: ( () ( (lv_namespace_1_0= rulecss_namespace_prefix ) )? otherlv_2= '*' )
				// InternalCSS.g:1802:2: () ( (lv_namespace_1_0= rulecss_namespace_prefix ) )? otherlv_2= '*'
				{
					// InternalCSS.g:1802:2: ()
					// InternalCSS.g:1803:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getUniversalSelectorAccess().getUniversalSelectorAction_0(),
									current);

						}

					}

					// InternalCSS.g:1808:2: ( (lv_namespace_1_0= rulecss_namespace_prefix ) )?
					int alt52 = 2;
					int LA52_0 = input.LA(1);

					if (((LA52_0 >= RULE_DASH && LA52_0 <= RULE_ONE_NON_HEX_LETTER) || LA52_0 == 43 || (LA52_0 >= 56 && LA52_0 <= 59))) {
						alt52 = 1;
					} else if ((LA52_0 == 42)) {
						int LA52_2 = input.LA(2);

						if ((LA52_2 == 43)) {
							alt52 = 1;
						}
					}
					switch (alt52) {
					case 1:
					// InternalCSS.g:1809:1: (lv_namespace_1_0= rulecss_namespace_prefix )
					{
						// InternalCSS.g:1809:1: (lv_namespace_1_0= rulecss_namespace_prefix )
						// InternalCSS.g:1810:3: lv_namespace_1_0= rulecss_namespace_prefix
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getUniversalSelectorAccess().getNamespaceCss_namespace_prefixParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_33);
							lv_namespace_1_0 = rulecss_namespace_prefix();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getUniversalSelectorRule());
								}
								set(
										current,
										"namespace",
										lv_namespace_1_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.css_namespace_prefix");
								afterParserOrEnumRuleCall();

							}

						}


					}
						break;

					}

					otherlv_2 = (Token) match(input, 42, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_2, grammarAccess.getUniversalSelectorAccess().getAsteriskKeyword_2());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleUniversalSelector"


	// $ANTLR start "entryRuleIdSelector"
	// InternalCSS.g:1838:1: entryRuleIdSelector returns [EObject current=null] : iv_ruleIdSelector= ruleIdSelector EOF ;
	public final EObject entryRuleIdSelector() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleIdSelector = null;


		try {
			// InternalCSS.g:1839:2: (iv_ruleIdSelector= ruleIdSelector EOF )
			// InternalCSS.g:1840:2: iv_ruleIdSelector= ruleIdSelector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getIdSelectorRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleIdSelector = ruleIdSelector();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleIdSelector;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleIdSelector"


	// $ANTLR start "ruleIdSelector"
	// InternalCSS.g:1847:1: ruleIdSelector returns [EObject current=null] : ( () this_HASHMARK_1= RULE_HASHMARK ( (lv_name_2_0= ruleIdentifier ) ) ) ;
	public final EObject ruleIdSelector() throws RecognitionException {
		EObject current = null;

		Token this_HASHMARK_1 = null;
		AntlrDatatypeRuleToken lv_name_2_0 = null;


		enterRule();

		try {
			// InternalCSS.g:1850:28: ( ( () this_HASHMARK_1= RULE_HASHMARK ( (lv_name_2_0= ruleIdentifier ) ) ) )
			// InternalCSS.g:1851:1: ( () this_HASHMARK_1= RULE_HASHMARK ( (lv_name_2_0= ruleIdentifier ) ) )
			{
				// InternalCSS.g:1851:1: ( () this_HASHMARK_1= RULE_HASHMARK ( (lv_name_2_0= ruleIdentifier ) ) )
				// InternalCSS.g:1851:2: () this_HASHMARK_1= RULE_HASHMARK ( (lv_name_2_0= ruleIdentifier ) )
				{
					// InternalCSS.g:1851:2: ()
					// InternalCSS.g:1852:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getIdSelectorAccess().getIdSelectorAction_0(),
									current);

						}

					}

					this_HASHMARK_1 = (Token) match(input, RULE_HASHMARK, FOLLOW_13);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(this_HASHMARK_1, grammarAccess.getIdSelectorAccess().getHASHMARKTerminalRuleCall_1());

					}
					// InternalCSS.g:1861:1: ( (lv_name_2_0= ruleIdentifier ) )
					// InternalCSS.g:1862:1: (lv_name_2_0= ruleIdentifier )
					{
						// InternalCSS.g:1862:1: (lv_name_2_0= ruleIdentifier )
						// InternalCSS.g:1863:3: lv_name_2_0= ruleIdentifier
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getIdSelectorAccess().getNameIdentifierParserRuleCall_2_0());

							}
							pushFollow(FOLLOW_2);
							lv_name_2_0 = ruleIdentifier();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getIdSelectorRule());
								}
								set(
										current,
										"name",
										lv_name_2_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.Identifier");
								afterParserOrEnumRuleCall();

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleIdSelector"


	// $ANTLR start "entryRulecss_namespace_prefix"
	// InternalCSS.g:1887:1: entryRulecss_namespace_prefix returns [String current=null] : iv_rulecss_namespace_prefix= rulecss_namespace_prefix EOF ;
	public final String entryRulecss_namespace_prefix() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_rulecss_namespace_prefix = null;


		try {
			// InternalCSS.g:1888:2: (iv_rulecss_namespace_prefix= rulecss_namespace_prefix EOF )
			// InternalCSS.g:1889:2: iv_rulecss_namespace_prefix= rulecss_namespace_prefix EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getCss_namespace_prefixRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulecss_namespace_prefix = rulecss_namespace_prefix();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulecss_namespace_prefix.getText();
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulecss_namespace_prefix"


	// $ANTLR start "rulecss_namespace_prefix"
	// InternalCSS.g:1896:1: rulecss_namespace_prefix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_Identifier_0= ruleIdentifier | kw= '*' )? kw= '|' ) ;
	public final AntlrDatatypeRuleToken rulecss_namespace_prefix() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token kw = null;
		AntlrDatatypeRuleToken this_Identifier_0 = null;


		enterRule();

		try {
			// InternalCSS.g:1899:28: ( ( (this_Identifier_0= ruleIdentifier | kw= '*' )? kw= '|' ) )
			// InternalCSS.g:1900:1: ( (this_Identifier_0= ruleIdentifier | kw= '*' )? kw= '|' )
			{
				// InternalCSS.g:1900:1: ( (this_Identifier_0= ruleIdentifier | kw= '*' )? kw= '|' )
				// InternalCSS.g:1900:2: (this_Identifier_0= ruleIdentifier | kw= '*' )? kw= '|'
				{
					// InternalCSS.g:1900:2: (this_Identifier_0= ruleIdentifier | kw= '*' )?
					int alt53 = 3;
					int LA53_0 = input.LA(1);

					if (((LA53_0 >= RULE_DASH && LA53_0 <= RULE_ONE_NON_HEX_LETTER) || (LA53_0 >= 56 && LA53_0 <= 59))) {
						alt53 = 1;
					} else if ((LA53_0 == 42)) {
						alt53 = 2;
					}
					switch (alt53) {
					case 1:
					// InternalCSS.g:1901:5: this_Identifier_0= ruleIdentifier
					{
						if (state.backtracking == 0) {

							newCompositeNode(grammarAccess.getCss_namespace_prefixAccess().getIdentifierParserRuleCall_0_0());

						}
						pushFollow(FOLLOW_34);
						this_Identifier_0 = ruleIdentifier();

						state._fsp--;
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							current.merge(this_Identifier_0);

						}
						if (state.backtracking == 0) {

							afterParserOrEnumRuleCall();

						}

					}
						break;
					case 2:
					// InternalCSS.g:1913:2: kw= '*'
					{
						kw = (Token) match(input, 42, FOLLOW_34);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getCss_namespace_prefixAccess().getAsteriskKeyword_0_1());

						}

					}
						break;

					}

					kw = (Token) match(input, 43, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getCss_namespace_prefixAccess().getVerticalLineKeyword_1());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulecss_namespace_prefix"


	// $ANTLR start "entryRulecss_declaration"
	// InternalCSS.g:1932:1: entryRulecss_declaration returns [EObject current=null] : iv_rulecss_declaration= rulecss_declaration EOF ;
	public final EObject entryRulecss_declaration() throws RecognitionException {
		EObject current = null;

		EObject iv_rulecss_declaration = null;



		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens("RULE_ML_COMMENT");

		try {
			// InternalCSS.g:1936:2: (iv_rulecss_declaration= rulecss_declaration EOF )
			// InternalCSS.g:1937:2: iv_rulecss_declaration= rulecss_declaration EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getCss_declarationRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulecss_declaration = rulecss_declaration();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulecss_declaration;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRulecss_declaration"


	// $ANTLR start "rulecss_declaration"
	// InternalCSS.g:1947:1: rulecss_declaration returns [EObject current=null] : ( (this_WS_0= RULE_WS )* ( (lv_property_1_0= rulecss_property ) ) (this_WS_2= RULE_WS )* this_COLON_3= RULE_COLON ( (lv_valueTokens_4_0= ruleCssTok ) )+ ( (lv_important_5_0=
	// RULE_IMPORTANT_SYM ) )? ) ;
	public final EObject rulecss_declaration() throws RecognitionException {
		EObject current = null;

		Token this_WS_0 = null;
		Token this_WS_2 = null;
		Token this_COLON_3 = null;
		Token lv_important_5_0 = null;
		EObject lv_property_1_0 = null;

		EObject lv_valueTokens_4_0 = null;


		enterRule();
		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens("RULE_ML_COMMENT");

		try {
			// InternalCSS.g:1951:28: ( ( (this_WS_0= RULE_WS )* ( (lv_property_1_0= rulecss_property ) ) (this_WS_2= RULE_WS )* this_COLON_3= RULE_COLON ( (lv_valueTokens_4_0= ruleCssTok ) )+ ( (lv_important_5_0= RULE_IMPORTANT_SYM ) )? ) )
			// InternalCSS.g:1952:1: ( (this_WS_0= RULE_WS )* ( (lv_property_1_0= rulecss_property ) ) (this_WS_2= RULE_WS )* this_COLON_3= RULE_COLON ( (lv_valueTokens_4_0= ruleCssTok ) )+ ( (lv_important_5_0= RULE_IMPORTANT_SYM ) )? )
			{
				// InternalCSS.g:1952:1: ( (this_WS_0= RULE_WS )* ( (lv_property_1_0= rulecss_property ) ) (this_WS_2= RULE_WS )* this_COLON_3= RULE_COLON ( (lv_valueTokens_4_0= ruleCssTok ) )+ ( (lv_important_5_0= RULE_IMPORTANT_SYM ) )? )
				// InternalCSS.g:1952:2: (this_WS_0= RULE_WS )* ( (lv_property_1_0= rulecss_property ) ) (this_WS_2= RULE_WS )* this_COLON_3= RULE_COLON ( (lv_valueTokens_4_0= ruleCssTok ) )+ ( (lv_important_5_0= RULE_IMPORTANT_SYM ) )?
				{
					// InternalCSS.g:1952:2: (this_WS_0= RULE_WS )*
					loop54: do {
						int alt54 = 2;
						int LA54_0 = input.LA(1);

						if ((LA54_0 == RULE_WS)) {
							alt54 = 1;
						}


						switch (alt54) {
						case 1:
						// InternalCSS.g:1952:3: this_WS_0= RULE_WS
						{
							this_WS_0 = (Token) match(input, RULE_WS, FOLLOW_23);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								newLeafNode(this_WS_0, grammarAccess.getCss_declarationAccess().getWSTerminalRuleCall_0());

							}

						}
							break;

						default:
							break loop54;
						}
					} while (true);

					// InternalCSS.g:1956:3: ( (lv_property_1_0= rulecss_property ) )
					// InternalCSS.g:1957:1: (lv_property_1_0= rulecss_property )
					{
						// InternalCSS.g:1957:1: (lv_property_1_0= rulecss_property )
						// InternalCSS.g:1958:3: lv_property_1_0= rulecss_property
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getCss_declarationAccess().getPropertyCss_propertyParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_35);
							lv_property_1_0 = rulecss_property();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getCss_declarationRule());
								}
								set(
										current,
										"property",
										lv_property_1_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.css_property");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalCSS.g:1974:2: (this_WS_2= RULE_WS )*
					loop55: do {
						int alt55 = 2;
						int LA55_0 = input.LA(1);

						if ((LA55_0 == RULE_WS)) {
							alt55 = 1;
						}


						switch (alt55) {
						case 1:
						// InternalCSS.g:1974:3: this_WS_2= RULE_WS
						{
							this_WS_2 = (Token) match(input, RULE_WS, FOLLOW_35);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								newLeafNode(this_WS_2, grammarAccess.getCss_declarationAccess().getWSTerminalRuleCall_2());

							}

						}
							break;

						default:
							break loop55;
						}
					} while (true);

					this_COLON_3 = (Token) match(input, RULE_COLON, FOLLOW_36);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(this_COLON_3, grammarAccess.getCss_declarationAccess().getCOLONTerminalRuleCall_3());

					}
					// InternalCSS.g:1982:1: ( (lv_valueTokens_4_0= ruleCssTok ) )+
					int cnt56 = 0;
					loop56: do {
						int alt56 = 2;
						int LA56_0 = input.LA(1);

						if ((LA56_0 == RULE_CSSSTRING || (LA56_0 >= RULE_COMMA && LA56_0 <= RULE_WS) || LA56_0 == RULE_HASHMARK || (LA56_0 >= RULE_PLUS && LA56_0 <= RULE_ONE_INT) || LA56_0 == 41 || LA56_0 == 49 || (LA56_0 >= 56 && LA56_0 <= 59))) {
							alt56 = 1;
						}


						switch (alt56) {
						case 1:
						// InternalCSS.g:1983:1: (lv_valueTokens_4_0= ruleCssTok )
						{
							// InternalCSS.g:1983:1: (lv_valueTokens_4_0= ruleCssTok )
							// InternalCSS.g:1984:3: lv_valueTokens_4_0= ruleCssTok
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getCss_declarationAccess().getValueTokensCssTokParserRuleCall_4_0());

								}
								pushFollow(FOLLOW_37);
								lv_valueTokens_4_0 = ruleCssTok();

								state._fsp--;
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getCss_declarationRule());
									}
									add(
											current,
											"valueTokens",
											lv_valueTokens_4_0,
											"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.CssTok");
									afterParserOrEnumRuleCall();

								}

							}


						}
							break;

						default:
							if (cnt56 >= 1) {
								break loop56;
							}
							if (state.backtracking > 0) {
								state.failed = true;
								return current;
							}
							EarlyExitException eee = new EarlyExitException(56, input);
							throw eee;
						}
						cnt56++;
					} while (true);

					// InternalCSS.g:2000:3: ( (lv_important_5_0= RULE_IMPORTANT_SYM ) )?
					int alt57 = 2;
					int LA57_0 = input.LA(1);

					if ((LA57_0 == RULE_IMPORTANT_SYM)) {
						alt57 = 1;
					}
					switch (alt57) {
					case 1:
					// InternalCSS.g:2001:1: (lv_important_5_0= RULE_IMPORTANT_SYM )
					{
						// InternalCSS.g:2001:1: (lv_important_5_0= RULE_IMPORTANT_SYM )
						// InternalCSS.g:2002:3: lv_important_5_0= RULE_IMPORTANT_SYM
						{
							lv_important_5_0 = (Token) match(input, RULE_IMPORTANT_SYM, FOLLOW_2);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								newLeafNode(lv_important_5_0, grammarAccess.getCss_declarationAccess().getImportantIMPORTANT_SYMTerminalRuleCall_5_0());

							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElement(grammarAccess.getCss_declarationRule());
								}
								setWithLastConsumed(
										current,
										"important",
										true,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.IMPORTANT_SYM");

							}

						}


					}
						break;

					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "rulecss_declaration"


	// $ANTLR start "entryRulecss_property"
	// InternalCSS.g:2029:1: entryRulecss_property returns [EObject current=null] : iv_rulecss_property= rulecss_property EOF ;
	public final EObject entryRulecss_property() throws RecognitionException {
		EObject current = null;

		EObject iv_rulecss_property = null;


		try {
			// InternalCSS.g:2030:2: (iv_rulecss_property= rulecss_property EOF )
			// InternalCSS.g:2031:2: iv_rulecss_property= rulecss_property EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getCss_propertyRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulecss_property = rulecss_property();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulecss_property;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulecss_property"


	// $ANTLR start "rulecss_property"
	// InternalCSS.g:2038:1: rulecss_property returns [EObject current=null] : ( () ( (lv_name_1_0= ruleValidPropertyIdent ) ) ) ;
	public final EObject rulecss_property() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_name_1_0 = null;


		enterRule();

		try {
			// InternalCSS.g:2041:28: ( ( () ( (lv_name_1_0= ruleValidPropertyIdent ) ) ) )
			// InternalCSS.g:2042:1: ( () ( (lv_name_1_0= ruleValidPropertyIdent ) ) )
			{
				// InternalCSS.g:2042:1: ( () ( (lv_name_1_0= ruleValidPropertyIdent ) ) )
				// InternalCSS.g:2042:2: () ( (lv_name_1_0= ruleValidPropertyIdent ) )
				{
					// InternalCSS.g:2042:2: ()
					// InternalCSS.g:2043:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getCss_propertyAccess().getCss_propertyAction_0(),
									current);

						}

					}

					// InternalCSS.g:2048:2: ( (lv_name_1_0= ruleValidPropertyIdent ) )
					// InternalCSS.g:2049:1: (lv_name_1_0= ruleValidPropertyIdent )
					{
						// InternalCSS.g:2049:1: (lv_name_1_0= ruleValidPropertyIdent )
						// InternalCSS.g:2050:3: lv_name_1_0= ruleValidPropertyIdent
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getCss_propertyAccess().getNameValidPropertyIdentParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_2);
							lv_name_1_0 = ruleValidPropertyIdent();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getCss_propertyRule());
								}
								set(
										current,
										"name",
										lv_name_1_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.ValidPropertyIdent");
								afterParserOrEnumRuleCall();

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulecss_property"


	// $ANTLR start "entryRuleValidPropertyIdent"
	// InternalCSS.g:2074:1: entryRuleValidPropertyIdent returns [String current=null] : iv_ruleValidPropertyIdent= ruleValidPropertyIdent EOF ;
	public final String entryRuleValidPropertyIdent() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleValidPropertyIdent = null;


		try {
			// InternalCSS.g:2075:2: (iv_ruleValidPropertyIdent= ruleValidPropertyIdent EOF )
			// InternalCSS.g:2076:2: iv_ruleValidPropertyIdent= ruleValidPropertyIdent EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getValidPropertyIdentRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleValidPropertyIdent = ruleValidPropertyIdent();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleValidPropertyIdent.getText();
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleValidPropertyIdent"


	// $ANTLR start "ruleValidPropertyIdent"
	// InternalCSS.g:2083:1: ruleValidPropertyIdent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
	public final AntlrDatatypeRuleToken ruleValidPropertyIdent() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		AntlrDatatypeRuleToken this_Identifier_0 = null;


		enterRule();

		try {
			// InternalCSS.g:2086:28: (this_Identifier_0= ruleIdentifier )
			// InternalCSS.g:2088:5: this_Identifier_0= ruleIdentifier
			{
				if (state.backtracking == 0) {

					newCompositeNode(grammarAccess.getValidPropertyIdentAccess().getIdentifierParserRuleCall());

				}
				pushFollow(FOLLOW_2);
				this_Identifier_0 = ruleIdentifier();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {

					current.merge(this_Identifier_0);

				}
				if (state.backtracking == 0) {

					afterParserOrEnumRuleCall();

				}

			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleValidPropertyIdent"


	// $ANTLR start "entryRulePseudoClassOrFunc"
	// InternalCSS.g:2106:1: entryRulePseudoClassOrFunc returns [EObject current=null] : iv_rulePseudoClassOrFunc= rulePseudoClassOrFunc EOF ;
	public final EObject entryRulePseudoClassOrFunc() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePseudoClassOrFunc = null;


		try {
			// InternalCSS.g:2107:2: (iv_rulePseudoClassOrFunc= rulePseudoClassOrFunc EOF )
			// InternalCSS.g:2108:2: iv_rulePseudoClassOrFunc= rulePseudoClassOrFunc EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getPseudoClassOrFuncRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulePseudoClassOrFunc = rulePseudoClassOrFunc();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulePseudoClassOrFunc;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulePseudoClassOrFunc"


	// $ANTLR start "rulePseudoClassOrFunc"
	// InternalCSS.g:2115:1: rulePseudoClassOrFunc returns [EObject current=null] : (this_PseudoClass_0= rulePseudoClass | this_PseudoClassFunction_1= rulePseudoClassFunction ) ;
	public final EObject rulePseudoClassOrFunc() throws RecognitionException {
		EObject current = null;

		EObject this_PseudoClass_0 = null;

		EObject this_PseudoClassFunction_1 = null;


		enterRule();

		try {
			// InternalCSS.g:2118:28: ( (this_PseudoClass_0= rulePseudoClass | this_PseudoClassFunction_1= rulePseudoClassFunction ) )
			// InternalCSS.g:2119:1: (this_PseudoClass_0= rulePseudoClass | this_PseudoClassFunction_1= rulePseudoClassFunction )
			{
				// InternalCSS.g:2119:1: (this_PseudoClass_0= rulePseudoClass | this_PseudoClassFunction_1= rulePseudoClassFunction )
				int alt58 = 2;
				alt58 = dfa58.predict(input);
				switch (alt58) {
				case 1:
				// InternalCSS.g:2120:5: this_PseudoClass_0= rulePseudoClass
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getPseudoClassOrFuncAccess().getPseudoClassParserRuleCall_0());

					}
					pushFollow(FOLLOW_2);
					this_PseudoClass_0 = rulePseudoClass();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_PseudoClass_0;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 2:
				// InternalCSS.g:2130:5: this_PseudoClassFunction_1= rulePseudoClassFunction
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getPseudoClassOrFuncAccess().getPseudoClassFunctionParserRuleCall_1());

					}
					pushFollow(FOLLOW_2);
					this_PseudoClassFunction_1 = rulePseudoClassFunction();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_PseudoClassFunction_1;
						afterParserOrEnumRuleCall();

					}

				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulePseudoClassOrFunc"


	// $ANTLR start "entryRulePseudoClass"
	// InternalCSS.g:2146:1: entryRulePseudoClass returns [EObject current=null] : iv_rulePseudoClass= rulePseudoClass EOF ;
	public final EObject entryRulePseudoClass() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePseudoClass = null;


		try {
			// InternalCSS.g:2147:2: (iv_rulePseudoClass= rulePseudoClass EOF )
			// InternalCSS.g:2148:2: iv_rulePseudoClass= rulePseudoClass EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getPseudoClassRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulePseudoClass = rulePseudoClass();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulePseudoClass;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulePseudoClass"


	// $ANTLR start "rulePseudoClass"
	// InternalCSS.g:2155:1: rulePseudoClass returns [EObject current=null] : (this_COLON_0= RULE_COLON (this_COLON_1= RULE_COLON )? this_PseudoClassName_2= rulePseudoClassName ) ;
	public final EObject rulePseudoClass() throws RecognitionException {
		EObject current = null;

		Token this_COLON_0 = null;
		Token this_COLON_1 = null;
		EObject this_PseudoClassName_2 = null;


		enterRule();

		try {
			// InternalCSS.g:2158:28: ( (this_COLON_0= RULE_COLON (this_COLON_1= RULE_COLON )? this_PseudoClassName_2= rulePseudoClassName ) )
			// InternalCSS.g:2159:1: (this_COLON_0= RULE_COLON (this_COLON_1= RULE_COLON )? this_PseudoClassName_2= rulePseudoClassName )
			{
				// InternalCSS.g:2159:1: (this_COLON_0= RULE_COLON (this_COLON_1= RULE_COLON )? this_PseudoClassName_2= rulePseudoClassName )
				// InternalCSS.g:2159:2: this_COLON_0= RULE_COLON (this_COLON_1= RULE_COLON )? this_PseudoClassName_2= rulePseudoClassName
				{
					this_COLON_0 = (Token) match(input, RULE_COLON, FOLLOW_38);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(this_COLON_0, grammarAccess.getPseudoClassAccess().getCOLONTerminalRuleCall_0());

					}
					// InternalCSS.g:2163:1: (this_COLON_1= RULE_COLON )?
					int alt59 = 2;
					int LA59_0 = input.LA(1);

					if ((LA59_0 == RULE_COLON)) {
						alt59 = 1;
					}
					switch (alt59) {
					case 1:
					// InternalCSS.g:2163:2: this_COLON_1= RULE_COLON
					{
						this_COLON_1 = (Token) match(input, RULE_COLON, FOLLOW_38);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(this_COLON_1, grammarAccess.getPseudoClassAccess().getCOLONTerminalRuleCall_1());

						}

					}
						break;

					}

					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getPseudoClassAccess().getPseudoClassNameParserRuleCall_2());

					}
					pushFollow(FOLLOW_2);
					this_PseudoClassName_2 = rulePseudoClassName();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_PseudoClassName_2;
						afterParserOrEnumRuleCall();

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulePseudoClass"


	// $ANTLR start "entryRulePseudoClassName"
	// InternalCSS.g:2184:1: entryRulePseudoClassName returns [EObject current=null] : iv_rulePseudoClassName= rulePseudoClassName EOF ;
	public final EObject entryRulePseudoClassName() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePseudoClassName = null;


		try {
			// InternalCSS.g:2185:2: (iv_rulePseudoClassName= rulePseudoClassName EOF )
			// InternalCSS.g:2186:2: iv_rulePseudoClassName= rulePseudoClassName EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getPseudoClassNameRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulePseudoClassName = rulePseudoClassName();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulePseudoClassName;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulePseudoClassName"


	// $ANTLR start "rulePseudoClassName"
	// InternalCSS.g:2193:1: rulePseudoClassName returns [EObject current=null] : ( (lv_name_0_0= ruleIdentifier ) ) ;
	public final EObject rulePseudoClassName() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_name_0_0 = null;


		enterRule();

		try {
			// InternalCSS.g:2196:28: ( ( (lv_name_0_0= ruleIdentifier ) ) )
			// InternalCSS.g:2197:1: ( (lv_name_0_0= ruleIdentifier ) )
			{
				// InternalCSS.g:2197:1: ( (lv_name_0_0= ruleIdentifier ) )
				// InternalCSS.g:2198:1: (lv_name_0_0= ruleIdentifier )
				{
					// InternalCSS.g:2198:1: (lv_name_0_0= ruleIdentifier )
					// InternalCSS.g:2199:3: lv_name_0_0= ruleIdentifier
					{
						if (state.backtracking == 0) {

							newCompositeNode(grammarAccess.getPseudoClassNameAccess().getNameIdentifierParserRuleCall_0());

						}
						pushFollow(FOLLOW_2);
						lv_name_0_0 = ruleIdentifier();

						state._fsp--;
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							if (current == null) {
								current = createModelElementForParent(grammarAccess.getPseudoClassNameRule());
							}
							set(
									current,
									"name",
									lv_name_0_0,
									"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.Identifier");
							afterParserOrEnumRuleCall();

						}

					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulePseudoClassName"


	// $ANTLR start "entryRulePseudoClassFunction"
	// InternalCSS.g:2223:1: entryRulePseudoClassFunction returns [EObject current=null] : iv_rulePseudoClassFunction= rulePseudoClassFunction EOF ;
	public final EObject entryRulePseudoClassFunction() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePseudoClassFunction = null;


		try {
			// InternalCSS.g:2224:2: (iv_rulePseudoClassFunction= rulePseudoClassFunction EOF )
			// InternalCSS.g:2225:2: iv_rulePseudoClassFunction= rulePseudoClassFunction EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getPseudoClassFunctionRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulePseudoClassFunction = rulePseudoClassFunction();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulePseudoClassFunction;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulePseudoClassFunction"


	// $ANTLR start "rulePseudoClassFunction"
	// InternalCSS.g:2232:1: rulePseudoClassFunction returns [EObject current=null] : ( ( ( (lv_not_0_0= ruleNotFunctionCall ) ) ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) ) otherlv_2= ')' ) | (this_COLON_3= RULE_COLON ( (lv_name_4_0=
	// ruleIdentifier ) ) otherlv_5= '(' ( (lv_params_6_0= ruleCssTok ) )* otherlv_7= ')' ) ) ;
	public final EObject rulePseudoClassFunction() throws RecognitionException {
		EObject current = null;

		Token otherlv_2 = null;
		Token this_COLON_3 = null;
		Token otherlv_5 = null;
		Token otherlv_7 = null;
		AntlrDatatypeRuleToken lv_not_0_0 = null;

		EObject lv_paramSelector_1_0 = null;

		AntlrDatatypeRuleToken lv_name_4_0 = null;

		EObject lv_params_6_0 = null;


		enterRule();

		try {
			// InternalCSS.g:2235:28: ( ( ( ( (lv_not_0_0= ruleNotFunctionCall ) ) ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) ) otherlv_2= ')' ) | (this_COLON_3= RULE_COLON ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_params_6_0=
			// ruleCssTok ) )* otherlv_7= ')' ) ) )
			// InternalCSS.g:2236:1: ( ( ( (lv_not_0_0= ruleNotFunctionCall ) ) ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) ) otherlv_2= ')' ) | (this_COLON_3= RULE_COLON ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_params_6_0=
			// ruleCssTok ) )* otherlv_7= ')' ) )
			{
				// InternalCSS.g:2236:1: ( ( ( (lv_not_0_0= ruleNotFunctionCall ) ) ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) ) otherlv_2= ')' ) | (this_COLON_3= RULE_COLON ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_params_6_0=
				// ruleCssTok ) )* otherlv_7= ')' ) )
				int alt61 = 2;
				int LA61_0 = input.LA(1);

				if ((LA61_0 == RULE_COLON)) {
					int LA61_1 = input.LA(2);

					if (((LA61_1 >= RULE_DASH && LA61_1 <= RULE_ONE_NON_HEX_LETTER) || (LA61_1 >= 56 && LA61_1 <= 59))) {
						alt61 = 2;
					} else if ((LA61_1 == 46)) {
						alt61 = 1;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 61, 1, input);

						throw nvae;
					}
				} else {
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 61, 0, input);

					throw nvae;
				}
				switch (alt61) {
				case 1:
				// InternalCSS.g:2236:2: ( ( (lv_not_0_0= ruleNotFunctionCall ) ) ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) ) otherlv_2= ')' )
				{
					// InternalCSS.g:2236:2: ( ( (lv_not_0_0= ruleNotFunctionCall ) ) ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) ) otherlv_2= ')' )
					// InternalCSS.g:2236:3: ( (lv_not_0_0= ruleNotFunctionCall ) ) ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) ) otherlv_2= ')'
					{
						// InternalCSS.g:2236:3: ( (lv_not_0_0= ruleNotFunctionCall ) )
						// InternalCSS.g:2237:1: (lv_not_0_0= ruleNotFunctionCall )
						{
							// InternalCSS.g:2237:1: (lv_not_0_0= ruleNotFunctionCall )
							// InternalCSS.g:2238:3: lv_not_0_0= ruleNotFunctionCall
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getPseudoClassFunctionAccess().getNotNotFunctionCallParserRuleCall_0_0_0());

								}
								pushFollow(FOLLOW_20);
								lv_not_0_0 = ruleNotFunctionCall();

								state._fsp--;
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getPseudoClassFunctionRule());
									}
									set(
											current,
											"not",
											true,
											"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.NotFunctionCall");
									afterParserOrEnumRuleCall();

								}

							}


						}

						// InternalCSS.g:2254:2: ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) )
						// InternalCSS.g:2255:1: (lv_paramSelector_1_0= ruleSimpleSelectorForNegation )
						{
							// InternalCSS.g:2255:1: (lv_paramSelector_1_0= ruleSimpleSelectorForNegation )
							// InternalCSS.g:2256:3: lv_paramSelector_1_0= ruleSimpleSelectorForNegation
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getPseudoClassFunctionAccess().getParamSelectorSimpleSelectorForNegationParserRuleCall_0_1_0());

								}
								pushFollow(FOLLOW_39);
								lv_paramSelector_1_0 = ruleSimpleSelectorForNegation();

								state._fsp--;
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getPseudoClassFunctionRule());
									}
									set(
											current,
											"paramSelector",
											lv_paramSelector_1_0,
											"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.SimpleSelectorForNegation");
									afterParserOrEnumRuleCall();

								}

							}


						}

						otherlv_2 = (Token) match(input, 44, FOLLOW_2);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_2, grammarAccess.getPseudoClassFunctionAccess().getRightParenthesisKeyword_0_2());

						}

					}


				}
					break;
				case 2:
				// InternalCSS.g:2277:6: (this_COLON_3= RULE_COLON ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_params_6_0= ruleCssTok ) )* otherlv_7= ')' )
				{
					// InternalCSS.g:2277:6: (this_COLON_3= RULE_COLON ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_params_6_0= ruleCssTok ) )* otherlv_7= ')' )
					// InternalCSS.g:2277:7: this_COLON_3= RULE_COLON ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_params_6_0= ruleCssTok ) )* otherlv_7= ')'
					{
						this_COLON_3 = (Token) match(input, RULE_COLON, FOLLOW_13);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(this_COLON_3, grammarAccess.getPseudoClassFunctionAccess().getCOLONTerminalRuleCall_1_0());

						}
						// InternalCSS.g:2281:1: ( (lv_name_4_0= ruleIdentifier ) )
						// InternalCSS.g:2282:1: (lv_name_4_0= ruleIdentifier )
						{
							// InternalCSS.g:2282:1: (lv_name_4_0= ruleIdentifier )
							// InternalCSS.g:2283:3: lv_name_4_0= ruleIdentifier
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getPseudoClassFunctionAccess().getNameIdentifierParserRuleCall_1_1_0());

								}
								pushFollow(FOLLOW_40);
								lv_name_4_0 = ruleIdentifier();

								state._fsp--;
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getPseudoClassFunctionRule());
									}
									set(
											current,
											"name",
											lv_name_4_0,
											"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.Identifier");
									afterParserOrEnumRuleCall();

								}

							}


						}

						otherlv_5 = (Token) match(input, 45, FOLLOW_41);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_5, grammarAccess.getPseudoClassFunctionAccess().getLeftParenthesisKeyword_1_2());

						}
						// InternalCSS.g:2303:1: ( (lv_params_6_0= ruleCssTok ) )*
						loop60: do {
							int alt60 = 2;
							int LA60_0 = input.LA(1);

							if ((LA60_0 == RULE_CSSSTRING || (LA60_0 >= RULE_COMMA && LA60_0 <= RULE_WS) || LA60_0 == RULE_HASHMARK || (LA60_0 >= RULE_PLUS && LA60_0 <= RULE_ONE_INT) || LA60_0 == 41 || LA60_0 == 49 || (LA60_0 >= 56 && LA60_0 <= 59))) {
								alt60 = 1;
							}


							switch (alt60) {
							case 1:
							// InternalCSS.g:2304:1: (lv_params_6_0= ruleCssTok )
							{
								// InternalCSS.g:2304:1: (lv_params_6_0= ruleCssTok )
								// InternalCSS.g:2305:3: lv_params_6_0= ruleCssTok
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getPseudoClassFunctionAccess().getParamsCssTokParserRuleCall_1_3_0());

									}
									pushFollow(FOLLOW_41);
									lv_params_6_0 = ruleCssTok();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getPseudoClassFunctionRule());
										}
										add(
												current,
												"params",
												lv_params_6_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.CssTok");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							default:
								break loop60;
							}
						} while (true);

						otherlv_7 = (Token) match(input, 44, FOLLOW_2);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_7, grammarAccess.getPseudoClassFunctionAccess().getRightParenthesisKeyword_1_4());

						}

					}


				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulePseudoClassFunction"


	// $ANTLR start "entryRuleNotFunctionCall"
	// InternalCSS.g:2333:1: entryRuleNotFunctionCall returns [String current=null] : iv_ruleNotFunctionCall= ruleNotFunctionCall EOF ;
	public final String entryRuleNotFunctionCall() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleNotFunctionCall = null;



		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens();

		try {
			// InternalCSS.g:2337:2: (iv_ruleNotFunctionCall= ruleNotFunctionCall EOF )
			// InternalCSS.g:2338:2: iv_ruleNotFunctionCall= ruleNotFunctionCall EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getNotFunctionCallRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleNotFunctionCall = ruleNotFunctionCall();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleNotFunctionCall.getText();
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRuleNotFunctionCall"


	// $ANTLR start "ruleNotFunctionCall"
	// InternalCSS.g:2348:1: ruleNotFunctionCall returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_COLON_0= RULE_COLON kw= 'not(' ) ;
	public final AntlrDatatypeRuleToken ruleNotFunctionCall() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_COLON_0 = null;
		Token kw = null;

		enterRule();
		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens();

		try {
			// InternalCSS.g:2352:28: ( (this_COLON_0= RULE_COLON kw= 'not(' ) )
			// InternalCSS.g:2353:1: (this_COLON_0= RULE_COLON kw= 'not(' )
			{
				// InternalCSS.g:2353:1: (this_COLON_0= RULE_COLON kw= 'not(' )
				// InternalCSS.g:2353:6: this_COLON_0= RULE_COLON kw= 'not('
				{
					this_COLON_0 = (Token) match(input, RULE_COLON, FOLLOW_42);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(this_COLON_0);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_COLON_0, grammarAccess.getNotFunctionCallAccess().getCOLONTerminalRuleCall_0());

					}
					kw = (Token) match(input, 46, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getNotFunctionCallAccess().getNotKeyword_1());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "ruleNotFunctionCall"


	// $ANTLR start "entryRulecombinator"
	// InternalCSS.g:2377:1: entryRulecombinator returns [String current=null] : iv_rulecombinator= rulecombinator EOF ;
	public final String entryRulecombinator() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_rulecombinator = null;


		try {
			// InternalCSS.g:2378:2: (iv_rulecombinator= rulecombinator EOF )
			// InternalCSS.g:2379:2: iv_rulecombinator= rulecombinator EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getCombinatorRule());
				}
				pushFollow(FOLLOW_1);
				iv_rulecombinator = rulecombinator();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_rulecombinator.getText();
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulecombinator"


	// $ANTLR start "rulecombinator"
	// InternalCSS.g:2386:1: rulecombinator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_PLUS_0= RULE_PLUS | kw= '>' | kw= '~' ) ;
	public final AntlrDatatypeRuleToken rulecombinator() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_PLUS_0 = null;
		Token kw = null;

		enterRule();

		try {
			// InternalCSS.g:2389:28: ( (this_PLUS_0= RULE_PLUS | kw= '>' | kw= '~' ) )
			// InternalCSS.g:2390:1: (this_PLUS_0= RULE_PLUS | kw= '>' | kw= '~' )
			{
				// InternalCSS.g:2390:1: (this_PLUS_0= RULE_PLUS | kw= '>' | kw= '~' )
				int alt62 = 3;
				switch (input.LA(1)) {
				case RULE_PLUS: {
					alt62 = 1;
				}
					break;
				case 47: {
					alt62 = 2;
				}
					break;
				case 48: {
					alt62 = 3;
				}
					break;
				default:
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 62, 0, input);

					throw nvae;
				}

				switch (alt62) {
				case 1:
				// InternalCSS.g:2390:6: this_PLUS_0= RULE_PLUS
				{
					this_PLUS_0 = (Token) match(input, RULE_PLUS, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(this_PLUS_0);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_PLUS_0, grammarAccess.getCombinatorAccess().getPLUSTerminalRuleCall_0());

					}

				}
					break;
				case 2:
				// InternalCSS.g:2399:2: kw= '>'
				{
					kw = (Token) match(input, 47, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getCombinatorAccess().getGreaterThanSignKeyword_1());

					}

				}
					break;
				case 3:
				// InternalCSS.g:2406:2: kw= '~'
				{
					kw = (Token) match(input, 48, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getCombinatorAccess().getTildeKeyword_2());

					}

				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulecombinator"


	// $ANTLR start "entryRuleSymbolTok"
	// InternalCSS.g:2423:1: entryRuleSymbolTok returns [EObject current=null] : iv_ruleSymbolTok= ruleSymbolTok EOF ;
	public final EObject entryRuleSymbolTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSymbolTok = null;


		try {
			// InternalCSS.g:2424:2: (iv_ruleSymbolTok= ruleSymbolTok EOF )
			// InternalCSS.g:2425:2: iv_ruleSymbolTok= ruleSymbolTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getSymbolTokRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleSymbolTok = ruleSymbolTok();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleSymbolTok;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleSymbolTok"


	// $ANTLR start "ruleSymbolTok"
	// InternalCSS.g:2432:1: ruleSymbolTok returns [EObject current=null] : ( () ( ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) ) ) ) ;
	public final EObject ruleSymbolTok() throws RecognitionException {
		EObject current = null;

		Token lv_symbol_1_1 = null;
		Token lv_symbol_1_2 = null;

		enterRule();

		try {
			// InternalCSS.g:2435:28: ( ( () ( ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) ) ) ) )
			// InternalCSS.g:2436:1: ( () ( ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) ) ) )
			{
				// InternalCSS.g:2436:1: ( () ( ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) ) ) )
				// InternalCSS.g:2436:2: () ( ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) ) )
				{
					// InternalCSS.g:2436:2: ()
					// InternalCSS.g:2437:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getSymbolTokAccess().getSymbolTokAction_0(),
									current);

						}

					}

					// InternalCSS.g:2442:2: ( ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) ) )
					// InternalCSS.g:2443:1: ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) )
					{
						// InternalCSS.g:2443:1: ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) )
						// InternalCSS.g:2444:1: (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT )
						{
							// InternalCSS.g:2444:1: (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT )
							int alt63 = 2;
							int LA63_0 = input.LA(1);

							if ((LA63_0 == RULE_COMMA)) {
								alt63 = 1;
							} else if ((LA63_0 == RULE_PERCENT)) {
								alt63 = 2;
							} else {
								if (state.backtracking > 0) {
									state.failed = true;
									return current;
								}
								NoViableAltException nvae = new NoViableAltException("", 63, 0, input);

								throw nvae;
							}
							switch (alt63) {
							case 1:
							// InternalCSS.g:2445:3: lv_symbol_1_1= RULE_COMMA
							{
								lv_symbol_1_1 = (Token) match(input, RULE_COMMA, FOLLOW_2);
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									newLeafNode(lv_symbol_1_1, grammarAccess.getSymbolTokAccess().getSymbolCOMMATerminalRuleCall_1_0_0());

								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElement(grammarAccess.getSymbolTokRule());
									}
									setWithLastConsumed(
											current,
											"symbol",
											lv_symbol_1_1,
											"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.COMMA");

								}

							}
								break;
							case 2:
							// InternalCSS.g:2460:8: lv_symbol_1_2= RULE_PERCENT
							{
								lv_symbol_1_2 = (Token) match(input, RULE_PERCENT, FOLLOW_2);
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									newLeafNode(lv_symbol_1_2, grammarAccess.getSymbolTokAccess().getSymbolPERCENTTerminalRuleCall_1_0_1());

								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElement(grammarAccess.getSymbolTokRule());
									}
									setWithLastConsumed(
											current,
											"symbol",
											lv_symbol_1_2,
											"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.PERCENT");

								}

							}
								break;

							}


						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleSymbolTok"


	// $ANTLR start "entryRuleWSTok"
	// InternalCSS.g:2486:1: entryRuleWSTok returns [EObject current=null] : iv_ruleWSTok= ruleWSTok EOF ;
	public final EObject entryRuleWSTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleWSTok = null;


		try {
			// InternalCSS.g:2487:2: (iv_ruleWSTok= ruleWSTok EOF )
			// InternalCSS.g:2488:2: iv_ruleWSTok= ruleWSTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getWSTokRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleWSTok = ruleWSTok();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleWSTok;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleWSTok"


	// $ANTLR start "ruleWSTok"
	// InternalCSS.g:2495:1: ruleWSTok returns [EObject current=null] : ( () this_WS_1= RULE_WS ) ;
	public final EObject ruleWSTok() throws RecognitionException {
		EObject current = null;

		Token this_WS_1 = null;

		enterRule();

		try {
			// InternalCSS.g:2498:28: ( ( () this_WS_1= RULE_WS ) )
			// InternalCSS.g:2499:1: ( () this_WS_1= RULE_WS )
			{
				// InternalCSS.g:2499:1: ( () this_WS_1= RULE_WS )
				// InternalCSS.g:2499:2: () this_WS_1= RULE_WS
				{
					// InternalCSS.g:2499:2: ()
					// InternalCSS.g:2500:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getWSTokAccess().getWSTokAction_0(),
									current);

						}

					}

					this_WS_1 = (Token) match(input, RULE_WS, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(this_WS_1, grammarAccess.getWSTokAccess().getWSTerminalRuleCall_1());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleWSTok"


	// $ANTLR start "entryRuleStringTok"
	// InternalCSS.g:2517:1: entryRuleStringTok returns [EObject current=null] : iv_ruleStringTok= ruleStringTok EOF ;
	public final EObject entryRuleStringTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleStringTok = null;


		try {
			// InternalCSS.g:2518:2: (iv_ruleStringTok= ruleStringTok EOF )
			// InternalCSS.g:2519:2: iv_ruleStringTok= ruleStringTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getStringTokRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleStringTok = ruleStringTok();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleStringTok;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleStringTok"


	// $ANTLR start "ruleStringTok"
	// InternalCSS.g:2526:1: ruleStringTok returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_CSSSTRING ) ) ) ;
	public final EObject ruleStringTok() throws RecognitionException {
		EObject current = null;

		Token lv_value_1_0 = null;

		enterRule();

		try {
			// InternalCSS.g:2529:28: ( ( () ( (lv_value_1_0= RULE_CSSSTRING ) ) ) )
			// InternalCSS.g:2530:1: ( () ( (lv_value_1_0= RULE_CSSSTRING ) ) )
			{
				// InternalCSS.g:2530:1: ( () ( (lv_value_1_0= RULE_CSSSTRING ) ) )
				// InternalCSS.g:2530:2: () ( (lv_value_1_0= RULE_CSSSTRING ) )
				{
					// InternalCSS.g:2530:2: ()
					// InternalCSS.g:2531:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getStringTokAccess().getStringTokAction_0(),
									current);

						}

					}

					// InternalCSS.g:2536:2: ( (lv_value_1_0= RULE_CSSSTRING ) )
					// InternalCSS.g:2537:1: (lv_value_1_0= RULE_CSSSTRING )
					{
						// InternalCSS.g:2537:1: (lv_value_1_0= RULE_CSSSTRING )
						// InternalCSS.g:2538:3: lv_value_1_0= RULE_CSSSTRING
						{
							lv_value_1_0 = (Token) match(input, RULE_CSSSTRING, FOLLOW_2);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								newLeafNode(lv_value_1_0, grammarAccess.getStringTokAccess().getValueCSSSTRINGTerminalRuleCall_1_0());

							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElement(grammarAccess.getStringTokRule());
								}
								setWithLastConsumed(
										current,
										"value",
										lv_value_1_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.CSSSTRING");

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleStringTok"


	// $ANTLR start "entryRuleNumberTok"
	// InternalCSS.g:2562:1: entryRuleNumberTok returns [EObject current=null] : iv_ruleNumberTok= ruleNumberTok EOF ;
	public final EObject entryRuleNumberTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNumberTok = null;



		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens();

		try {
			// InternalCSS.g:2566:2: (iv_ruleNumberTok= ruleNumberTok EOF )
			// InternalCSS.g:2567:2: iv_ruleNumberTok= ruleNumberTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getNumberTokRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleNumberTok = ruleNumberTok();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleNumberTok;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRuleNumberTok"


	// $ANTLR start "ruleNumberTok"
	// InternalCSS.g:2577:1: ruleNumberTok returns [EObject current=null] : ( () ( (lv_val_1_0= ruleNum ) ) ) ;
	public final EObject ruleNumberTok() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_val_1_0 = null;


		enterRule();
		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens();

		try {
			// InternalCSS.g:2581:28: ( ( () ( (lv_val_1_0= ruleNum ) ) ) )
			// InternalCSS.g:2582:1: ( () ( (lv_val_1_0= ruleNum ) ) )
			{
				// InternalCSS.g:2582:1: ( () ( (lv_val_1_0= ruleNum ) ) )
				// InternalCSS.g:2582:2: () ( (lv_val_1_0= ruleNum ) )
				{
					// InternalCSS.g:2582:2: ()
					// InternalCSS.g:2583:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getNumberTokAccess().getNumberTokAction_0(),
									current);

						}

					}

					// InternalCSS.g:2588:2: ( (lv_val_1_0= ruleNum ) )
					// InternalCSS.g:2589:1: (lv_val_1_0= ruleNum )
					{
						// InternalCSS.g:2589:1: (lv_val_1_0= ruleNum )
						// InternalCSS.g:2590:3: lv_val_1_0= ruleNum
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getNumberTokAccess().getValNumParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_2);
							lv_val_1_0 = ruleNum();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getNumberTokRule());
								}
								set(
										current,
										"val",
										lv_val_1_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.Num");
								afterParserOrEnumRuleCall();

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "ruleNumberTok"


	// $ANTLR start "entryRuleUrlTok"
	// InternalCSS.g:2617:1: entryRuleUrlTok returns [EObject current=null] : iv_ruleUrlTok= ruleUrlTok EOF ;
	public final EObject entryRuleUrlTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleUrlTok = null;


		try {
			// InternalCSS.g:2618:2: (iv_ruleUrlTok= ruleUrlTok EOF )
			// InternalCSS.g:2619:2: iv_ruleUrlTok= ruleUrlTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getUrlTokRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleUrlTok = ruleUrlTok();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleUrlTok;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleUrlTok"


	// $ANTLR start "ruleUrlTok"
	// InternalCSS.g:2626:1: ruleUrlTok returns [EObject current=null] : ( () ( (lv_url_1_0= ruleURLType ) ) ) ;
	public final EObject ruleUrlTok() throws RecognitionException {
		EObject current = null;

		EObject lv_url_1_0 = null;


		enterRule();

		try {
			// InternalCSS.g:2629:28: ( ( () ( (lv_url_1_0= ruleURLType ) ) ) )
			// InternalCSS.g:2630:1: ( () ( (lv_url_1_0= ruleURLType ) ) )
			{
				// InternalCSS.g:2630:1: ( () ( (lv_url_1_0= ruleURLType ) ) )
				// InternalCSS.g:2630:2: () ( (lv_url_1_0= ruleURLType ) )
				{
					// InternalCSS.g:2630:2: ()
					// InternalCSS.g:2631:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getUrlTokAccess().getUrlTokAction_0(),
									current);

						}

					}

					// InternalCSS.g:2636:2: ( (lv_url_1_0= ruleURLType ) )
					// InternalCSS.g:2637:1: (lv_url_1_0= ruleURLType )
					{
						// InternalCSS.g:2637:1: (lv_url_1_0= ruleURLType )
						// InternalCSS.g:2638:3: lv_url_1_0= ruleURLType
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getUrlTokAccess().getUrlURLTypeParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_2);
							lv_url_1_0 = ruleURLType();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getUrlTokRule());
								}
								set(
										current,
										"url",
										lv_url_1_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.URLType");
								afterParserOrEnumRuleCall();

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleUrlTok"


	// $ANTLR start "entryRuleColorTok"
	// InternalCSS.g:2662:1: entryRuleColorTok returns [EObject current=null] : iv_ruleColorTok= ruleColorTok EOF ;
	public final EObject entryRuleColorTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleColorTok = null;



		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens();

		try {
			// InternalCSS.g:2666:2: (iv_ruleColorTok= ruleColorTok EOF )
			// InternalCSS.g:2667:2: iv_ruleColorTok= ruleColorTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getColorTokRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleColorTok = ruleColorTok();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleColorTok;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRuleColorTok"


	// $ANTLR start "ruleColorTok"
	// InternalCSS.g:2677:1: ruleColorTok returns [EObject current=null] : ( () ( (lv_value_1_0= ruleHex ) ) ) ;
	public final EObject ruleColorTok() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_value_1_0 = null;


		enterRule();
		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens();

		try {
			// InternalCSS.g:2681:28: ( ( () ( (lv_value_1_0= ruleHex ) ) ) )
			// InternalCSS.g:2682:1: ( () ( (lv_value_1_0= ruleHex ) ) )
			{
				// InternalCSS.g:2682:1: ( () ( (lv_value_1_0= ruleHex ) ) )
				// InternalCSS.g:2682:2: () ( (lv_value_1_0= ruleHex ) )
				{
					// InternalCSS.g:2682:2: ()
					// InternalCSS.g:2683:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getColorTokAccess().getColorTokAction_0(),
									current);

						}

					}

					// InternalCSS.g:2688:2: ( (lv_value_1_0= ruleHex ) )
					// InternalCSS.g:2689:1: (lv_value_1_0= ruleHex )
					{
						// InternalCSS.g:2689:1: (lv_value_1_0= ruleHex )
						// InternalCSS.g:2690:3: lv_value_1_0= ruleHex
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getColorTokAccess().getValueHexParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_2);
							lv_value_1_0 = ruleHex();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getColorTokRule());
								}
								set(
										current,
										"value",
										lv_value_1_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.Hex");
								afterParserOrEnumRuleCall();

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "ruleColorTok"


	// $ANTLR start "entryRuleIdentifierOrFuncTok"
	// InternalCSS.g:2717:1: entryRuleIdentifierOrFuncTok returns [EObject current=null] : iv_ruleIdentifierOrFuncTok= ruleIdentifierOrFuncTok EOF ;
	public final EObject entryRuleIdentifierOrFuncTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleIdentifierOrFuncTok = null;



		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens("RULE_ML_COMMENT");

		try {
			// InternalCSS.g:2721:2: (iv_ruleIdentifierOrFuncTok= ruleIdentifierOrFuncTok EOF )
			// InternalCSS.g:2722:2: iv_ruleIdentifierOrFuncTok= ruleIdentifierOrFuncTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getIdentifierOrFuncTokRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleIdentifierOrFuncTok = ruleIdentifierOrFuncTok();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleIdentifierOrFuncTok;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRuleIdentifierOrFuncTok"


	// $ANTLR start "ruleIdentifierOrFuncTok"
	// InternalCSS.g:2732:1: ruleIdentifierOrFuncTok returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) ( () otherlv_3= '(' ( (lv_params_4_0= ruleCssTok ) )+ otherlv_5= ')' )? ) ;
	public final EObject ruleIdentifierOrFuncTok() throws RecognitionException {
		EObject current = null;

		Token otherlv_3 = null;
		Token otherlv_5 = null;
		AntlrDatatypeRuleToken lv_name_1_0 = null;

		EObject lv_params_4_0 = null;


		enterRule();
		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens("RULE_ML_COMMENT");

		try {
			// InternalCSS.g:2736:28: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) ( () otherlv_3= '(' ( (lv_params_4_0= ruleCssTok ) )+ otherlv_5= ')' )? ) )
			// InternalCSS.g:2737:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) ( () otherlv_3= '(' ( (lv_params_4_0= ruleCssTok ) )+ otherlv_5= ')' )? )
			{
				// InternalCSS.g:2737:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) ( () otherlv_3= '(' ( (lv_params_4_0= ruleCssTok ) )+ otherlv_5= ')' )? )
				// InternalCSS.g:2737:2: () ( (lv_name_1_0= ruleIdentifier ) ) ( () otherlv_3= '(' ( (lv_params_4_0= ruleCssTok ) )+ otherlv_5= ')' )?
				{
					// InternalCSS.g:2737:2: ()
					// InternalCSS.g:2738:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getIdentifierOrFuncTokAccess().getIdentifierTokAction_0(),
									current);

						}

					}

					// InternalCSS.g:2743:2: ( (lv_name_1_0= ruleIdentifier ) )
					// InternalCSS.g:2744:1: (lv_name_1_0= ruleIdentifier )
					{
						// InternalCSS.g:2744:1: (lv_name_1_0= ruleIdentifier )
						// InternalCSS.g:2745:3: lv_name_1_0= ruleIdentifier
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getIdentifierOrFuncTokAccess().getNameIdentifierParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_43);
							lv_name_1_0 = ruleIdentifier();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getIdentifierOrFuncTokRule());
								}
								set(
										current,
										"name",
										lv_name_1_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.Identifier");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalCSS.g:2761:2: ( () otherlv_3= '(' ( (lv_params_4_0= ruleCssTok ) )+ otherlv_5= ')' )?
					int alt65 = 2;
					int LA65_0 = input.LA(1);

					if ((LA65_0 == 45)) {
						alt65 = 1;
					}
					switch (alt65) {
					case 1:
					// InternalCSS.g:2761:3: () otherlv_3= '(' ( (lv_params_4_0= ruleCssTok ) )+ otherlv_5= ')'
					{
						// InternalCSS.g:2761:3: ()
						// InternalCSS.g:2762:5:
						{
							if (state.backtracking == 0) {

								current = forceCreateModelElementAndSet(
										grammarAccess.getIdentifierOrFuncTokAccess().getFuncTokNameAction_2_0(),
										current);

							}

						}

						otherlv_3 = (Token) match(input, 45, FOLLOW_36);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_3, grammarAccess.getIdentifierOrFuncTokAccess().getLeftParenthesisKeyword_2_1());

						}
						// InternalCSS.g:2771:1: ( (lv_params_4_0= ruleCssTok ) )+
						int cnt64 = 0;
						loop64: do {
							int alt64 = 2;
							int LA64_0 = input.LA(1);

							if ((LA64_0 == RULE_CSSSTRING || (LA64_0 >= RULE_COMMA && LA64_0 <= RULE_WS) || LA64_0 == RULE_HASHMARK || (LA64_0 >= RULE_PLUS && LA64_0 <= RULE_ONE_INT) || LA64_0 == 41 || LA64_0 == 49 || (LA64_0 >= 56 && LA64_0 <= 59))) {
								alt64 = 1;
							}


							switch (alt64) {
							case 1:
							// InternalCSS.g:2772:1: (lv_params_4_0= ruleCssTok )
							{
								// InternalCSS.g:2772:1: (lv_params_4_0= ruleCssTok )
								// InternalCSS.g:2773:3: lv_params_4_0= ruleCssTok
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getIdentifierOrFuncTokAccess().getParamsCssTokParserRuleCall_2_2_0());

									}
									pushFollow(FOLLOW_41);
									lv_params_4_0 = ruleCssTok();

									state._fsp--;
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getIdentifierOrFuncTokRule());
										}
										add(
												current,
												"params",
												lv_params_4_0,
												"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.CssTok");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							default:
								if (cnt64 >= 1) {
									break loop64;
								}
								if (state.backtracking > 0) {
									state.failed = true;
									return current;
								}
								EarlyExitException eee = new EarlyExitException(64, input);
								throw eee;
							}
							cnt64++;
						} while (true);

						otherlv_5 = (Token) match(input, 44, FOLLOW_2);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							newLeafNode(otherlv_5, grammarAccess.getIdentifierOrFuncTokAccess().getRightParenthesisKeyword_2_3());

						}

					}
						break;

					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "ruleIdentifierOrFuncTok"


	// $ANTLR start "entryRuleCssTok"
	// InternalCSS.g:2804:1: entryRuleCssTok returns [EObject current=null] : iv_ruleCssTok= ruleCssTok EOF ;
	public final EObject entryRuleCssTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleCssTok = null;



		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens("RULE_ML_COMMENT");

		try {
			// InternalCSS.g:2808:2: (iv_ruleCssTok= ruleCssTok EOF )
			// InternalCSS.g:2809:2: iv_ruleCssTok= ruleCssTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getCssTokRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleCssTok = ruleCssTok();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleCssTok;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRuleCssTok"


	// $ANTLR start "ruleCssTok"
	// InternalCSS.g:2819:1: ruleCssTok returns [EObject current=null] : (this_IdentifierOrFuncTok_0= ruleIdentifierOrFuncTok | this_SymbolTok_1= ruleSymbolTok | this_WSTok_2= ruleWSTok | this_StringTok_3= ruleStringTok | this_NumberTok_4= ruleNumberTok |
	// this_UrlTok_5= ruleUrlTok | this_ColorTok_6= ruleColorTok ) ;
	public final EObject ruleCssTok() throws RecognitionException {
		EObject current = null;

		EObject this_IdentifierOrFuncTok_0 = null;

		EObject this_SymbolTok_1 = null;

		EObject this_WSTok_2 = null;

		EObject this_StringTok_3 = null;

		EObject this_NumberTok_4 = null;

		EObject this_UrlTok_5 = null;

		EObject this_ColorTok_6 = null;


		enterRule();
		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens("RULE_ML_COMMENT");

		try {
			// InternalCSS.g:2823:28: ( (this_IdentifierOrFuncTok_0= ruleIdentifierOrFuncTok | this_SymbolTok_1= ruleSymbolTok | this_WSTok_2= ruleWSTok | this_StringTok_3= ruleStringTok | this_NumberTok_4= ruleNumberTok | this_UrlTok_5= ruleUrlTok |
			// this_ColorTok_6= ruleColorTok ) )
			// InternalCSS.g:2824:1: (this_IdentifierOrFuncTok_0= ruleIdentifierOrFuncTok | this_SymbolTok_1= ruleSymbolTok | this_WSTok_2= ruleWSTok | this_StringTok_3= ruleStringTok | this_NumberTok_4= ruleNumberTok | this_UrlTok_5= ruleUrlTok |
			// this_ColorTok_6= ruleColorTok )
			{
				// InternalCSS.g:2824:1: (this_IdentifierOrFuncTok_0= ruleIdentifierOrFuncTok | this_SymbolTok_1= ruleSymbolTok | this_WSTok_2= ruleWSTok | this_StringTok_3= ruleStringTok | this_NumberTok_4= ruleNumberTok | this_UrlTok_5= ruleUrlTok |
				// this_ColorTok_6= ruleColorTok )
				int alt66 = 7;
				switch (input.LA(1)) {
				case RULE_DASH: {
					int LA66_1 = input.LA(2);

					if ((LA66_1 == RULE_ONE_INT || LA66_1 == 41)) {
						alt66 = 5;
					} else if (((LA66_1 >= RULE_UNDERSCORE && LA66_1 <= RULE_ONE_NON_HEX_LETTER) || (LA66_1 >= 56 && LA66_1 <= 59))) {
						alt66 = 1;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 66, 1, input);

						throw nvae;
					}
				}
					break;
				case RULE_UNDERSCORE:
				case RULE_ONE_HEX_LETTER:
				case RULE_ONE_NON_HEX_LETTER:
				case 56:
				case 57:
				case 58:
				case 59: {
					alt66 = 1;
				}
					break;
				case RULE_COMMA:
				case RULE_PERCENT: {
					alt66 = 2;
				}
					break;
				case RULE_WS: {
					alt66 = 3;
				}
					break;
				case RULE_CSSSTRING: {
					alt66 = 4;
				}
					break;
				case RULE_PLUS:
				case RULE_ONE_INT:
				case 41: {
					alt66 = 5;
				}
					break;
				case 49: {
					alt66 = 6;
				}
					break;
				case RULE_HASHMARK: {
					alt66 = 7;
				}
					break;
				default:
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 66, 0, input);

					throw nvae;
				}

				switch (alt66) {
				case 1:
				// InternalCSS.g:2825:5: this_IdentifierOrFuncTok_0= ruleIdentifierOrFuncTok
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getCssTokAccess().getIdentifierOrFuncTokParserRuleCall_0());

					}
					pushFollow(FOLLOW_2);
					this_IdentifierOrFuncTok_0 = ruleIdentifierOrFuncTok();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_IdentifierOrFuncTok_0;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 2:
				// InternalCSS.g:2835:5: this_SymbolTok_1= ruleSymbolTok
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getCssTokAccess().getSymbolTokParserRuleCall_1());

					}
					pushFollow(FOLLOW_2);
					this_SymbolTok_1 = ruleSymbolTok();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_SymbolTok_1;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 3:
				// InternalCSS.g:2845:5: this_WSTok_2= ruleWSTok
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getCssTokAccess().getWSTokParserRuleCall_2());

					}
					pushFollow(FOLLOW_2);
					this_WSTok_2 = ruleWSTok();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_WSTok_2;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 4:
				// InternalCSS.g:2855:5: this_StringTok_3= ruleStringTok
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getCssTokAccess().getStringTokParserRuleCall_3());

					}
					pushFollow(FOLLOW_2);
					this_StringTok_3 = ruleStringTok();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_StringTok_3;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 5:
				// InternalCSS.g:2865:5: this_NumberTok_4= ruleNumberTok
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getCssTokAccess().getNumberTokParserRuleCall_4());

					}
					pushFollow(FOLLOW_2);
					this_NumberTok_4 = ruleNumberTok();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_NumberTok_4;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 6:
				// InternalCSS.g:2875:5: this_UrlTok_5= ruleUrlTok
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getCssTokAccess().getUrlTokParserRuleCall_5());

					}
					pushFollow(FOLLOW_2);
					this_UrlTok_5 = ruleUrlTok();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_UrlTok_5;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 7:
				// InternalCSS.g:2885:5: this_ColorTok_6= ruleColorTok
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getCssTokAccess().getColorTokParserRuleCall_6());

					}
					pushFollow(FOLLOW_2);
					this_ColorTok_6 = ruleColorTok();

					state._fsp--;
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current = this_ColorTok_6;
						afterParserOrEnumRuleCall();

					}

				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "ruleCssTok"


	// $ANTLR start "entryRuleURLType"
	// InternalCSS.g:2904:1: entryRuleURLType returns [EObject current=null] : iv_ruleURLType= ruleURLType EOF ;
	public final EObject entryRuleURLType() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleURLType = null;



		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens();

		try {
			// InternalCSS.g:2908:2: (iv_ruleURLType= ruleURLType EOF )
			// InternalCSS.g:2909:2: iv_ruleURLType= ruleURLType EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getURLTypeRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleURLType = ruleURLType();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleURLType;
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRuleURLType"


	// $ANTLR start "ruleURLType"
	// InternalCSS.g:2919:1: ruleURLType returns [EObject current=null] : (otherlv_0= 'url(' ( (lv_url_1_0= ruleValidURL ) ) otherlv_2= ')' ) ;
	public final EObject ruleURLType() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_2 = null;
		AntlrDatatypeRuleToken lv_url_1_0 = null;


		enterRule();
		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens();

		try {
			// InternalCSS.g:2923:28: ( (otherlv_0= 'url(' ( (lv_url_1_0= ruleValidURL ) ) otherlv_2= ')' ) )
			// InternalCSS.g:2924:1: (otherlv_0= 'url(' ( (lv_url_1_0= ruleValidURL ) ) otherlv_2= ')' )
			{
				// InternalCSS.g:2924:1: (otherlv_0= 'url(' ( (lv_url_1_0= ruleValidURL ) ) otherlv_2= ')' )
				// InternalCSS.g:2924:3: otherlv_0= 'url(' ( (lv_url_1_0= ruleValidURL ) ) otherlv_2= ')'
				{
					otherlv_0 = (Token) match(input, 49, FOLLOW_44);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_0, grammarAccess.getURLTypeAccess().getUrlKeyword_0());

					}
					// InternalCSS.g:2928:1: ( (lv_url_1_0= ruleValidURL ) )
					// InternalCSS.g:2929:1: (lv_url_1_0= ruleValidURL )
					{
						// InternalCSS.g:2929:1: (lv_url_1_0= ruleValidURL )
						// InternalCSS.g:2930:3: lv_url_1_0= ruleValidURL
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getURLTypeAccess().getUrlValidURLParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_39);
							lv_url_1_0 = ruleValidURL();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getURLTypeRule());
								}
								set(
										current,
										"url",
										lv_url_1_0,
										"org.eclipse.papyrus.infra.gmfdiag.css3.CSS.ValidURL");
								afterParserOrEnumRuleCall();

							}

						}


					}

					otherlv_2 = (Token) match(input, 44, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						newLeafNode(otherlv_2, grammarAccess.getURLTypeAccess().getRightParenthesisKeyword_2());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "ruleURLType"


	// $ANTLR start "entryRuleValidURLSymbol"
	// InternalCSS.g:2961:1: entryRuleValidURLSymbol returns [String current=null] : iv_ruleValidURLSymbol= ruleValidURLSymbol EOF ;
	public final String entryRuleValidURLSymbol() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleValidURLSymbol = null;


		try {
			// InternalCSS.g:2962:2: (iv_ruleValidURLSymbol= ruleValidURLSymbol EOF )
			// InternalCSS.g:2963:2: iv_ruleValidURLSymbol= ruleValidURLSymbol EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getValidURLSymbolRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleValidURLSymbol = ruleValidURLSymbol();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleValidURLSymbol.getText();
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleValidURLSymbol"


	// $ANTLR start "ruleValidURLSymbol"
	// InternalCSS.g:2970:1: ruleValidURLSymbol returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DASH_0= RULE_DASH | kw= '.' | this_UNDERSCORE_2= RULE_UNDERSCORE | kw= '~' | this_COLON_4= RULE_COLON | kw= '/' | kw= '?' |
	// this_HASHMARK_7= RULE_HASHMARK | kw= '[' | kw= ']' | kw= '@' | kw= '!' | kw= '$' | kw= '&' | kw= '*' | this_PLUS_15= RULE_PLUS | this_COMMA_16= RULE_COMMA | kw= ';' | (kw= '=' this_KeywordHack_19= ruleKeywordHack ) ) ;
	public final AntlrDatatypeRuleToken ruleValidURLSymbol() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_DASH_0 = null;
		Token kw = null;
		Token this_UNDERSCORE_2 = null;
		Token this_COLON_4 = null;
		Token this_HASHMARK_7 = null;
		Token this_PLUS_15 = null;
		Token this_COMMA_16 = null;
		AntlrDatatypeRuleToken this_KeywordHack_19 = null;


		enterRule();

		try {
			// InternalCSS.g:2973:28: ( (this_DASH_0= RULE_DASH | kw= '.' | this_UNDERSCORE_2= RULE_UNDERSCORE | kw= '~' | this_COLON_4= RULE_COLON | kw= '/' | kw= '?' | this_HASHMARK_7= RULE_HASHMARK | kw= '[' | kw= ']' | kw= '@' | kw= '!' | kw= '$' | kw= '&'
			// | kw= '*' | this_PLUS_15= RULE_PLUS | this_COMMA_16= RULE_COMMA | kw= ';' | (kw= '=' this_KeywordHack_19= ruleKeywordHack ) ) )
			// InternalCSS.g:2974:1: (this_DASH_0= RULE_DASH | kw= '.' | this_UNDERSCORE_2= RULE_UNDERSCORE | kw= '~' | this_COLON_4= RULE_COLON | kw= '/' | kw= '?' | this_HASHMARK_7= RULE_HASHMARK | kw= '[' | kw= ']' | kw= '@' | kw= '!' | kw= '$' | kw= '&' |
			// kw= '*' | this_PLUS_15= RULE_PLUS | this_COMMA_16= RULE_COMMA | kw= ';' | (kw= '=' this_KeywordHack_19= ruleKeywordHack ) )
			{
				// InternalCSS.g:2974:1: (this_DASH_0= RULE_DASH | kw= '.' | this_UNDERSCORE_2= RULE_UNDERSCORE | kw= '~' | this_COLON_4= RULE_COLON | kw= '/' | kw= '?' | this_HASHMARK_7= RULE_HASHMARK | kw= '[' | kw= ']' | kw= '@' | kw= '!' | kw= '$' | kw=
				// '&' | kw= '*' | this_PLUS_15= RULE_PLUS | this_COMMA_16= RULE_COMMA | kw= ';' | (kw= '=' this_KeywordHack_19= ruleKeywordHack ) )
				int alt67 = 19;
				switch (input.LA(1)) {
				case RULE_DASH: {
					alt67 = 1;
				}
					break;
				case 41: {
					alt67 = 2;
				}
					break;
				case RULE_UNDERSCORE: {
					alt67 = 3;
				}
					break;
				case 48: {
					alt67 = 4;
				}
					break;
				case RULE_COLON: {
					alt67 = 5;
				}
					break;
				case 50: {
					alt67 = 6;
				}
					break;
				case 51: {
					alt67 = 7;
				}
					break;
				case RULE_HASHMARK: {
					alt67 = 8;
				}
					break;
				case 35: {
					alt67 = 9;
				}
					break;
				case 40: {
					alt67 = 10;
				}
					break;
				case 52: {
					alt67 = 11;
				}
					break;
				case 53: {
					alt67 = 12;
				}
					break;
				case 54: {
					alt67 = 13;
				}
					break;
				case 55: {
					alt67 = 14;
				}
					break;
				case 42: {
					alt67 = 15;
				}
					break;
				case RULE_PLUS: {
					alt67 = 16;
				}
					break;
				case RULE_COMMA: {
					alt67 = 17;
				}
					break;
				case 22: {
					alt67 = 18;
				}
					break;
				case 39: {
					alt67 = 19;
				}
					break;
				default:
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 67, 0, input);

					throw nvae;
				}

				switch (alt67) {
				case 1:
				// InternalCSS.g:2974:6: this_DASH_0= RULE_DASH
				{
					this_DASH_0 = (Token) match(input, RULE_DASH, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(this_DASH_0);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_DASH_0, grammarAccess.getValidURLSymbolAccess().getDASHTerminalRuleCall_0());

					}

				}
					break;
				case 2:
				// InternalCSS.g:2983:2: kw= '.'
				{
					kw = (Token) match(input, 41, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getFullStopKeyword_1());

					}

				}
					break;
				case 3:
				// InternalCSS.g:2989:10: this_UNDERSCORE_2= RULE_UNDERSCORE
				{
					this_UNDERSCORE_2 = (Token) match(input, RULE_UNDERSCORE, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(this_UNDERSCORE_2);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_UNDERSCORE_2, grammarAccess.getValidURLSymbolAccess().getUNDERSCORETerminalRuleCall_2());

					}

				}
					break;
				case 4:
				// InternalCSS.g:2998:2: kw= '~'
				{
					kw = (Token) match(input, 48, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getTildeKeyword_3());

					}

				}
					break;
				case 5:
				// InternalCSS.g:3004:10: this_COLON_4= RULE_COLON
				{
					this_COLON_4 = (Token) match(input, RULE_COLON, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(this_COLON_4);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_COLON_4, grammarAccess.getValidURLSymbolAccess().getCOLONTerminalRuleCall_4());

					}

				}
					break;
				case 6:
				// InternalCSS.g:3013:2: kw= '/'
				{
					kw = (Token) match(input, 50, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getSolidusKeyword_5());

					}

				}
					break;
				case 7:
				// InternalCSS.g:3020:2: kw= '?'
				{
					kw = (Token) match(input, 51, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getQuestionMarkKeyword_6());

					}

				}
					break;
				case 8:
				// InternalCSS.g:3026:10: this_HASHMARK_7= RULE_HASHMARK
				{
					this_HASHMARK_7 = (Token) match(input, RULE_HASHMARK, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(this_HASHMARK_7);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_HASHMARK_7, grammarAccess.getValidURLSymbolAccess().getHASHMARKTerminalRuleCall_7());

					}

				}
					break;
				case 9:
				// InternalCSS.g:3035:2: kw= '['
				{
					kw = (Token) match(input, 35, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getLeftSquareBracketKeyword_8());

					}

				}
					break;
				case 10:
				// InternalCSS.g:3042:2: kw= ']'
				{
					kw = (Token) match(input, 40, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getRightSquareBracketKeyword_9());

					}

				}
					break;
				case 11:
				// InternalCSS.g:3049:2: kw= '@'
				{
					kw = (Token) match(input, 52, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getCommercialAtKeyword_10());

					}

				}
					break;
				case 12:
				// InternalCSS.g:3056:2: kw= '!'
				{
					kw = (Token) match(input, 53, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getExclamationMarkKeyword_11());

					}

				}
					break;
				case 13:
				// InternalCSS.g:3063:2: kw= '$'
				{
					kw = (Token) match(input, 54, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getDollarSignKeyword_12());

					}

				}
					break;
				case 14:
				// InternalCSS.g:3070:2: kw= '&'
				{
					kw = (Token) match(input, 55, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getAmpersandKeyword_13());

					}

				}
					break;
				case 15:
				// InternalCSS.g:3077:2: kw= '*'
				{
					kw = (Token) match(input, 42, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getAsteriskKeyword_14());

					}

				}
					break;
				case 16:
				// InternalCSS.g:3083:10: this_PLUS_15= RULE_PLUS
				{
					this_PLUS_15 = (Token) match(input, RULE_PLUS, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(this_PLUS_15);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_PLUS_15, grammarAccess.getValidURLSymbolAccess().getPLUSTerminalRuleCall_15());

					}

				}
					break;
				case 17:
				// InternalCSS.g:3091:10: this_COMMA_16= RULE_COMMA
				{
					this_COMMA_16 = (Token) match(input, RULE_COMMA, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(this_COMMA_16);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_COMMA_16, grammarAccess.getValidURLSymbolAccess().getCOMMATerminalRuleCall_16());

					}

				}
					break;
				case 18:
				// InternalCSS.g:3100:2: kw= ';'
				{
					kw = (Token) match(input, 22, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getSemicolonKeyword_17());

					}

				}
					break;
				case 19:
				// InternalCSS.g:3106:6: (kw= '=' this_KeywordHack_19= ruleKeywordHack )
				{
					// InternalCSS.g:3106:6: (kw= '=' this_KeywordHack_19= ruleKeywordHack )
					// InternalCSS.g:3107:2: kw= '=' this_KeywordHack_19= ruleKeywordHack
					{
						kw = (Token) match(input, 39, FOLLOW_13);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getEqualsSignKeyword_18_0());

						}
						if (state.backtracking == 0) {

							newCompositeNode(grammarAccess.getValidURLSymbolAccess().getKeywordHackParserRuleCall_18_1());

						}
						pushFollow(FOLLOW_2);
						this_KeywordHack_19 = ruleKeywordHack();

						state._fsp--;
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							current.merge(this_KeywordHack_19);

						}
						if (state.backtracking == 0) {

							afterParserOrEnumRuleCall();

						}

					}


				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleValidURLSymbol"


	// $ANTLR start "entryRuleKeywordHack"
	// InternalCSS.g:3131:1: entryRuleKeywordHack returns [String current=null] : iv_ruleKeywordHack= ruleKeywordHack EOF ;
	public final String entryRuleKeywordHack() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleKeywordHack = null;


		try {
			// InternalCSS.g:3132:2: (iv_ruleKeywordHack= ruleKeywordHack EOF )
			// InternalCSS.g:3133:2: iv_ruleKeywordHack= ruleKeywordHack EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getKeywordHackRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleKeywordHack = ruleKeywordHack();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleKeywordHack.getText();
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleKeywordHack"


	// $ANTLR start "ruleKeywordHack"
	// InternalCSS.g:3140:1: ruleKeywordHack returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= 'no' | kw= 'url' | kw= 'ur' ) ;
	public final AntlrDatatypeRuleToken ruleKeywordHack() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token kw = null;

		enterRule();

		try {
			// InternalCSS.g:3143:28: ( (kw= 'not' | kw= 'no' | kw= 'url' | kw= 'ur' ) )
			// InternalCSS.g:3144:1: (kw= 'not' | kw= 'no' | kw= 'url' | kw= 'ur' )
			{
				// InternalCSS.g:3144:1: (kw= 'not' | kw= 'no' | kw= 'url' | kw= 'ur' )
				int alt68 = 4;
				switch (input.LA(1)) {
				case 56: {
					alt68 = 1;
				}
					break;
				case 57: {
					alt68 = 2;
				}
					break;
				case 58: {
					alt68 = 3;
				}
					break;
				case 59: {
					alt68 = 4;
				}
					break;
				default:
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 68, 0, input);

					throw nvae;
				}

				switch (alt68) {
				case 1:
				// InternalCSS.g:3145:2: kw= 'not'
				{
					kw = (Token) match(input, 56, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getKeywordHackAccess().getNotKeyword_0());

					}

				}
					break;
				case 2:
				// InternalCSS.g:3152:2: kw= 'no'
				{
					kw = (Token) match(input, 57, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getKeywordHackAccess().getNoKeyword_1());

					}

				}
					break;
				case 3:
				// InternalCSS.g:3159:2: kw= 'url'
				{
					kw = (Token) match(input, 58, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getKeywordHackAccess().getUrlKeyword_2());

					}

				}
					break;
				case 4:
				// InternalCSS.g:3166:2: kw= 'ur'
				{
					kw = (Token) match(input, 59, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getKeywordHackAccess().getUrKeyword_3());

					}

				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleKeywordHack"


	// $ANTLR start "entryRuleValidURL"
	// InternalCSS.g:3179:1: entryRuleValidURL returns [String current=null] : iv_ruleValidURL= ruleValidURL EOF ;
	public final String entryRuleValidURL() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleValidURL = null;



		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens();

		try {
			// InternalCSS.g:3183:2: (iv_ruleValidURL= ruleValidURL EOF )
			// InternalCSS.g:3184:2: iv_ruleValidURL= ruleValidURL EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getValidURLRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleValidURL = ruleValidURL();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleValidURL.getText();
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRuleValidURL"


	// $ANTLR start "ruleValidURL"
	// InternalCSS.g:3194:1: ruleValidURL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CSSSTRING_0= RULE_CSSSTRING | (this_ValidURLSymbol_1= ruleValidURLSymbol | this_KeywordHack_2= ruleKeywordHack | this_ONE_HEX_LETTER_3=
	// RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_4= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_5= RULE_ONE_INT | kw= '\\\\ ' | kw= '\\\\(' | kw= '\\\\)' | kw= '\\\\\\'' | kw= '\\\\\"' | (this_PERCENT_11= RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT |
	// this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER ) ) )+ ) ;
	public final AntlrDatatypeRuleToken ruleValidURL() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_CSSSTRING_0 = null;
		Token this_ONE_HEX_LETTER_3 = null;
		Token this_ONE_NON_HEX_LETTER_4 = null;
		Token this_ONE_INT_5 = null;
		Token kw = null;
		Token this_PERCENT_11 = null;
		Token this_ONE_INT_12 = null;
		Token this_ONE_HEX_LETTER_13 = null;
		Token this_ONE_INT_14 = null;
		Token this_ONE_HEX_LETTER_15 = null;
		AntlrDatatypeRuleToken this_ValidURLSymbol_1 = null;

		AntlrDatatypeRuleToken this_KeywordHack_2 = null;


		enterRule();
		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens();

		try {
			// InternalCSS.g:3198:28: ( (this_CSSSTRING_0= RULE_CSSSTRING | (this_ValidURLSymbol_1= ruleValidURLSymbol | this_KeywordHack_2= ruleKeywordHack | this_ONE_HEX_LETTER_3= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_4= RULE_ONE_NON_HEX_LETTER |
			// this_ONE_INT_5= RULE_ONE_INT | kw= '\\\\ ' | kw= '\\\\(' | kw= '\\\\)' | kw= '\\\\\\'' | kw= '\\\\\"' | (this_PERCENT_11= RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT
			// | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER ) ) )+ ) )
			// InternalCSS.g:3199:1: (this_CSSSTRING_0= RULE_CSSSTRING | (this_ValidURLSymbol_1= ruleValidURLSymbol | this_KeywordHack_2= ruleKeywordHack | this_ONE_HEX_LETTER_3= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_4= RULE_ONE_NON_HEX_LETTER |
			// this_ONE_INT_5= RULE_ONE_INT | kw= '\\\\ ' | kw= '\\\\(' | kw= '\\\\)' | kw= '\\\\\\'' | kw= '\\\\\"' | (this_PERCENT_11= RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT
			// | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER ) ) )+ )
			{
				// InternalCSS.g:3199:1: (this_CSSSTRING_0= RULE_CSSSTRING | (this_ValidURLSymbol_1= ruleValidURLSymbol | this_KeywordHack_2= ruleKeywordHack | this_ONE_HEX_LETTER_3= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_4= RULE_ONE_NON_HEX_LETTER |
				// this_ONE_INT_5= RULE_ONE_INT | kw= '\\\\ ' | kw= '\\\\(' | kw= '\\\\)' | kw= '\\\\\\'' | kw= '\\\\\"' | (this_PERCENT_11= RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14=
				// RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER ) ) )+ )
				int alt72 = 2;
				int LA72_0 = input.LA(1);

				if ((LA72_0 == RULE_CSSSTRING)) {
					alt72 = 1;
				} else if (((LA72_0 >= RULE_COLON && LA72_0 <= RULE_PERCENT) || LA72_0 == RULE_HASHMARK || (LA72_0 >= RULE_PLUS && LA72_0 <= RULE_ONE_INT) || LA72_0 == 22 || LA72_0 == 35 || (LA72_0 >= 39 && LA72_0 <= 42) || LA72_0 == 48
						|| (LA72_0 >= 50 && LA72_0 <= 64))) {
					alt72 = 2;
				} else {
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 72, 0, input);

					throw nvae;
				}
				switch (alt72) {
				case 1:
				// InternalCSS.g:3199:6: this_CSSSTRING_0= RULE_CSSSTRING
				{
					this_CSSSTRING_0 = (Token) match(input, RULE_CSSSTRING, FOLLOW_2);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(this_CSSSTRING_0);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_CSSSTRING_0, grammarAccess.getValidURLAccess().getCSSSTRINGTerminalRuleCall_0());

					}

				}
					break;
				case 2:
				// InternalCSS.g:3207:6: (this_ValidURLSymbol_1= ruleValidURLSymbol | this_KeywordHack_2= ruleKeywordHack | this_ONE_HEX_LETTER_3= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_4= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_5= RULE_ONE_INT | kw=
				// '\\\\ ' | kw= '\\\\(' | kw= '\\\\)' | kw= '\\\\\\'' | kw= '\\\\\"' | (this_PERCENT_11= RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15=
				// RULE_ONE_HEX_LETTER ) ) )+
				{
					// InternalCSS.g:3207:6: (this_ValidURLSymbol_1= ruleValidURLSymbol | this_KeywordHack_2= ruleKeywordHack | this_ONE_HEX_LETTER_3= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_4= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_5= RULE_ONE_INT | kw=
					// '\\\\ ' | kw= '\\\\(' | kw= '\\\\)' | kw= '\\\\\\'' | kw= '\\\\\"' | (this_PERCENT_11= RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15=
					// RULE_ONE_HEX_LETTER ) ) )+
					int cnt71 = 0;
					loop71: do {
						int alt71 = 12;
						switch (input.LA(1)) {
						case RULE_COLON:
						case RULE_COMMA:
						case RULE_HASHMARK:
						case RULE_PLUS:
						case RULE_DASH:
						case RULE_UNDERSCORE:
						case 22:
						case 35:
						case 39:
						case 40:
						case 41:
						case 42:
						case 48:
						case 50:
						case 51:
						case 52:
						case 53:
						case 54:
						case 55: {
							alt71 = 1;
						}
							break;
						case 56:
						case 57:
						case 58:
						case 59: {
							alt71 = 2;
						}
							break;
						case RULE_ONE_HEX_LETTER: {
							alt71 = 3;
						}
							break;
						case RULE_ONE_NON_HEX_LETTER: {
							alt71 = 4;
						}
							break;
						case RULE_ONE_INT: {
							alt71 = 5;
						}
							break;
						case 60: {
							alt71 = 6;
						}
							break;
						case 61: {
							alt71 = 7;
						}
							break;
						case 62: {
							alt71 = 8;
						}
							break;
						case 63: {
							alt71 = 9;
						}
							break;
						case 64: {
							alt71 = 10;
						}
							break;
						case RULE_PERCENT: {
							alt71 = 11;
						}
							break;

						}

						switch (alt71) {
						case 1:
						// InternalCSS.g:3208:5: this_ValidURLSymbol_1= ruleValidURLSymbol
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getValidURLAccess().getValidURLSymbolParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_45);
							this_ValidURLSymbol_1 = ruleValidURLSymbol();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								current.merge(this_ValidURLSymbol_1);

							}
							if (state.backtracking == 0) {

								afterParserOrEnumRuleCall();

							}

						}
							break;
						case 2:
						// InternalCSS.g:3220:5: this_KeywordHack_2= ruleKeywordHack
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getValidURLAccess().getKeywordHackParserRuleCall_1_1());

							}
							pushFollow(FOLLOW_45);
							this_KeywordHack_2 = ruleKeywordHack();

							state._fsp--;
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								current.merge(this_KeywordHack_2);

							}
							if (state.backtracking == 0) {

								afterParserOrEnumRuleCall();

							}

						}
							break;
						case 3:
						// InternalCSS.g:3231:10: this_ONE_HEX_LETTER_3= RULE_ONE_HEX_LETTER
						{
							this_ONE_HEX_LETTER_3 = (Token) match(input, RULE_ONE_HEX_LETTER, FOLLOW_45);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								current.merge(this_ONE_HEX_LETTER_3);

							}
							if (state.backtracking == 0) {

								newLeafNode(this_ONE_HEX_LETTER_3, grammarAccess.getValidURLAccess().getONE_HEX_LETTERTerminalRuleCall_1_2());

							}

						}
							break;
						case 4:
						// InternalCSS.g:3239:10: this_ONE_NON_HEX_LETTER_4= RULE_ONE_NON_HEX_LETTER
						{
							this_ONE_NON_HEX_LETTER_4 = (Token) match(input, RULE_ONE_NON_HEX_LETTER, FOLLOW_45);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								current.merge(this_ONE_NON_HEX_LETTER_4);

							}
							if (state.backtracking == 0) {

								newLeafNode(this_ONE_NON_HEX_LETTER_4, grammarAccess.getValidURLAccess().getONE_NON_HEX_LETTERTerminalRuleCall_1_3());

							}

						}
							break;
						case 5:
						// InternalCSS.g:3247:10: this_ONE_INT_5= RULE_ONE_INT
						{
							this_ONE_INT_5 = (Token) match(input, RULE_ONE_INT, FOLLOW_45);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								current.merge(this_ONE_INT_5);

							}
							if (state.backtracking == 0) {

								newLeafNode(this_ONE_INT_5, grammarAccess.getValidURLAccess().getONE_INTTerminalRuleCall_1_4());

							}

						}
							break;
						case 6:
						// InternalCSS.g:3256:2: kw= '\\\\ '
						{
							kw = (Token) match(input, 60, FOLLOW_45);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								current.merge(kw);
								newLeafNode(kw, grammarAccess.getValidURLAccess().getReverseSolidusSpaceKeyword_1_5());

							}

						}
							break;
						case 7:
						// InternalCSS.g:3263:2: kw= '\\\\('
						{
							kw = (Token) match(input, 61, FOLLOW_45);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								current.merge(kw);
								newLeafNode(kw, grammarAccess.getValidURLAccess().getReverseSolidusLeftParenthesisKeyword_1_6());

							}

						}
							break;
						case 8:
						// InternalCSS.g:3270:2: kw= '\\\\)'
						{
							kw = (Token) match(input, 62, FOLLOW_45);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								current.merge(kw);
								newLeafNode(kw, grammarAccess.getValidURLAccess().getReverseSolidusRightParenthesisKeyword_1_7());

							}

						}
							break;
						case 9:
						// InternalCSS.g:3277:2: kw= '\\\\\\''
						{
							kw = (Token) match(input, 63, FOLLOW_45);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								current.merge(kw);
								newLeafNode(kw, grammarAccess.getValidURLAccess().getReverseSolidusApostropheKeyword_1_8());

							}

						}
							break;
						case 10:
						// InternalCSS.g:3284:2: kw= '\\\\\"'
						{
							kw = (Token) match(input, 64, FOLLOW_45);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								current.merge(kw);
								newLeafNode(kw, grammarAccess.getValidURLAccess().getReverseSolidusQuotationMarkKeyword_1_9());

							}

						}
							break;
						case 11:
						// InternalCSS.g:3290:6: (this_PERCENT_11= RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER ) )
						{
							// InternalCSS.g:3290:6: (this_PERCENT_11= RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER ) )
							// InternalCSS.g:3290:11: this_PERCENT_11= RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER )
							{
								this_PERCENT_11 = (Token) match(input, RULE_PERCENT, FOLLOW_46);
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									current.merge(this_PERCENT_11);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_PERCENT_11, grammarAccess.getValidURLAccess().getPERCENTTerminalRuleCall_1_10_0());

								}
								// InternalCSS.g:3297:1: (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER )
								int alt69 = 2;
								int LA69_0 = input.LA(1);

								if ((LA69_0 == RULE_ONE_INT)) {
									alt69 = 1;
								} else if ((LA69_0 == RULE_ONE_HEX_LETTER)) {
									alt69 = 2;
								} else {
									if (state.backtracking > 0) {
										state.failed = true;
										return current;
									}
									NoViableAltException nvae = new NoViableAltException("", 69, 0, input);

									throw nvae;
								}
								switch (alt69) {
								case 1:
								// InternalCSS.g:3297:6: this_ONE_INT_12= RULE_ONE_INT
								{
									this_ONE_INT_12 = (Token) match(input, RULE_ONE_INT, FOLLOW_46);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										current.merge(this_ONE_INT_12);

									}
									if (state.backtracking == 0) {

										newLeafNode(this_ONE_INT_12, grammarAccess.getValidURLAccess().getONE_INTTerminalRuleCall_1_10_1_0());

									}

								}
									break;
								case 2:
								// InternalCSS.g:3305:10: this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER
								{
									this_ONE_HEX_LETTER_13 = (Token) match(input, RULE_ONE_HEX_LETTER, FOLLOW_46);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										current.merge(this_ONE_HEX_LETTER_13);

									}
									if (state.backtracking == 0) {

										newLeafNode(this_ONE_HEX_LETTER_13, grammarAccess.getValidURLAccess().getONE_HEX_LETTERTerminalRuleCall_1_10_1_1());

									}

								}
									break;

								}

								// InternalCSS.g:3312:2: (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER )
								int alt70 = 2;
								int LA70_0 = input.LA(1);

								if ((LA70_0 == RULE_ONE_INT)) {
									alt70 = 1;
								} else if ((LA70_0 == RULE_ONE_HEX_LETTER)) {
									alt70 = 2;
								} else {
									if (state.backtracking > 0) {
										state.failed = true;
										return current;
									}
									NoViableAltException nvae = new NoViableAltException("", 70, 0, input);

									throw nvae;
								}
								switch (alt70) {
								case 1:
								// InternalCSS.g:3312:7: this_ONE_INT_14= RULE_ONE_INT
								{
									this_ONE_INT_14 = (Token) match(input, RULE_ONE_INT, FOLLOW_45);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										current.merge(this_ONE_INT_14);

									}
									if (state.backtracking == 0) {

										newLeafNode(this_ONE_INT_14, grammarAccess.getValidURLAccess().getONE_INTTerminalRuleCall_1_10_2_0());

									}

								}
									break;
								case 2:
								// InternalCSS.g:3320:10: this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER
								{
									this_ONE_HEX_LETTER_15 = (Token) match(input, RULE_ONE_HEX_LETTER, FOLLOW_45);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										current.merge(this_ONE_HEX_LETTER_15);

									}
									if (state.backtracking == 0) {

										newLeafNode(this_ONE_HEX_LETTER_15, grammarAccess.getValidURLAccess().getONE_HEX_LETTERTerminalRuleCall_1_10_2_1());

									}

								}
									break;

								}


							}


						}
							break;

						default:
							if (cnt71 >= 1) {
								break loop71;
							}
							if (state.backtracking > 0) {
								state.failed = true;
								return current;
							}
							EarlyExitException eee = new EarlyExitException(71, input);
							throw eee;
						}
						cnt71++;
					} while (true);


				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "ruleValidURL"


	// $ANTLR start "entryRuleIdentifier"
	// InternalCSS.g:3338:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
	public final String entryRuleIdentifier() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleIdentifier = null;



		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens();

		try {
			// InternalCSS.g:3342:2: (iv_ruleIdentifier= ruleIdentifier EOF )
			// InternalCSS.g:3343:2: iv_ruleIdentifier= ruleIdentifier EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getIdentifierRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleIdentifier = ruleIdentifier();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleIdentifier.getText();
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRuleIdentifier"


	// $ANTLR start "ruleIdentifier"
	// InternalCSS.g:3353:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_DASH_0= RULE_DASH )? (this_UNDERSCORE_1= RULE_UNDERSCORE | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_3=
	// RULE_ONE_NON_HEX_LETTER | this_KeywordHack_4= ruleKeywordHack ) ( ( ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )=> (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH |
	// this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10= ruleKeywordHack ) )* ) ;
	public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_DASH_0 = null;
		Token this_UNDERSCORE_1 = null;
		Token this_ONE_HEX_LETTER_2 = null;
		Token this_ONE_NON_HEX_LETTER_3 = null;
		Token this_UNDERSCORE_5 = null;
		Token this_DASH_6 = null;
		Token this_ONE_HEX_LETTER_7 = null;
		Token this_ONE_NON_HEX_LETTER_8 = null;
		Token this_ONE_INT_9 = null;
		AntlrDatatypeRuleToken this_KeywordHack_4 = null;

		AntlrDatatypeRuleToken this_KeywordHack_10 = null;


		enterRule();
		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens();

		try {
			// InternalCSS.g:3357:28: ( ( (this_DASH_0= RULE_DASH )? (this_UNDERSCORE_1= RULE_UNDERSCORE | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_3= RULE_ONE_NON_HEX_LETTER | this_KeywordHack_4= ruleKeywordHack ) ( ( (
			// RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )=> (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER |
			// this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10= ruleKeywordHack ) )* ) )
			// InternalCSS.g:3358:1: ( (this_DASH_0= RULE_DASH )? (this_UNDERSCORE_1= RULE_UNDERSCORE | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_3= RULE_ONE_NON_HEX_LETTER | this_KeywordHack_4= ruleKeywordHack ) ( ( (
			// RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )=> (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER |
			// this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10= ruleKeywordHack ) )* )
			{
				// InternalCSS.g:3358:1: ( (this_DASH_0= RULE_DASH )? (this_UNDERSCORE_1= RULE_UNDERSCORE | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_3= RULE_ONE_NON_HEX_LETTER | this_KeywordHack_4= ruleKeywordHack ) ( ( (
				// RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )=> (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER |
				// this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10= ruleKeywordHack ) )* )
				// InternalCSS.g:3358:2: (this_DASH_0= RULE_DASH )? (this_UNDERSCORE_1= RULE_UNDERSCORE | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_3= RULE_ONE_NON_HEX_LETTER | this_KeywordHack_4= ruleKeywordHack ) ( ( (
				// RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )=> (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER |
				// this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10= ruleKeywordHack ) )*
				{
					// InternalCSS.g:3358:2: (this_DASH_0= RULE_DASH )?
					int alt73 = 2;
					int LA73_0 = input.LA(1);

					if ((LA73_0 == RULE_DASH)) {
						alt73 = 1;
					}
					switch (alt73) {
					case 1:
					// InternalCSS.g:3358:7: this_DASH_0= RULE_DASH
					{
						this_DASH_0 = (Token) match(input, RULE_DASH, FOLLOW_13);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							current.merge(this_DASH_0);

						}
						if (state.backtracking == 0) {

							newLeafNode(this_DASH_0, grammarAccess.getIdentifierAccess().getDASHTerminalRuleCall_0());

						}

					}
						break;

					}

					// InternalCSS.g:3365:3: (this_UNDERSCORE_1= RULE_UNDERSCORE | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_3= RULE_ONE_NON_HEX_LETTER | this_KeywordHack_4= ruleKeywordHack )
					int alt74 = 4;
					switch (input.LA(1)) {
					case RULE_UNDERSCORE: {
						alt74 = 1;
					}
						break;
					case RULE_ONE_HEX_LETTER: {
						alt74 = 2;
					}
						break;
					case RULE_ONE_NON_HEX_LETTER: {
						alt74 = 3;
					}
						break;
					case 56:
					case 57:
					case 58:
					case 59: {
						alt74 = 4;
					}
						break;
					default:
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 74, 0, input);

						throw nvae;
					}

					switch (alt74) {
					case 1:
					// InternalCSS.g:3365:8: this_UNDERSCORE_1= RULE_UNDERSCORE
					{
						this_UNDERSCORE_1 = (Token) match(input, RULE_UNDERSCORE, FOLLOW_47);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							current.merge(this_UNDERSCORE_1);

						}
						if (state.backtracking == 0) {

							newLeafNode(this_UNDERSCORE_1, grammarAccess.getIdentifierAccess().getUNDERSCORETerminalRuleCall_1_0());

						}

					}
						break;
					case 2:
					// InternalCSS.g:3373:10: this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER
					{
						this_ONE_HEX_LETTER_2 = (Token) match(input, RULE_ONE_HEX_LETTER, FOLLOW_47);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							current.merge(this_ONE_HEX_LETTER_2);

						}
						if (state.backtracking == 0) {

							newLeafNode(this_ONE_HEX_LETTER_2, grammarAccess.getIdentifierAccess().getONE_HEX_LETTERTerminalRuleCall_1_1());

						}

					}
						break;
					case 3:
					// InternalCSS.g:3381:10: this_ONE_NON_HEX_LETTER_3= RULE_ONE_NON_HEX_LETTER
					{
						this_ONE_NON_HEX_LETTER_3 = (Token) match(input, RULE_ONE_NON_HEX_LETTER, FOLLOW_47);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							current.merge(this_ONE_NON_HEX_LETTER_3);

						}
						if (state.backtracking == 0) {

							newLeafNode(this_ONE_NON_HEX_LETTER_3, grammarAccess.getIdentifierAccess().getONE_NON_HEX_LETTERTerminalRuleCall_1_2());

						}

					}
						break;
					case 4:
					// InternalCSS.g:3390:5: this_KeywordHack_4= ruleKeywordHack
					{
						if (state.backtracking == 0) {

							newCompositeNode(grammarAccess.getIdentifierAccess().getKeywordHackParserRuleCall_1_3());

						}
						pushFollow(FOLLOW_47);
						this_KeywordHack_4 = ruleKeywordHack();

						state._fsp--;
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							current.merge(this_KeywordHack_4);

						}
						if (state.backtracking == 0) {

							afterParserOrEnumRuleCall();

						}

					}
						break;

					}

					// InternalCSS.g:3400:2: ( ( ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )=> (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7=
					// RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10= ruleKeywordHack ) )*
					loop76: do {
						int alt76 = 2;
						alt76 = dfa76.predict(input);
						switch (alt76) {
						case 1:
						// InternalCSS.g:3400:3: ( ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )=> (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7=
						// RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10= ruleKeywordHack )
						{
							// InternalCSS.g:3405:26: (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT |
							// this_KeywordHack_10= ruleKeywordHack )
							int alt75 = 6;
							switch (input.LA(1)) {
							case RULE_UNDERSCORE: {
								alt75 = 1;
							}
								break;
							case RULE_DASH: {
								alt75 = 2;
							}
								break;
							case RULE_ONE_HEX_LETTER: {
								alt75 = 3;
							}
								break;
							case RULE_ONE_NON_HEX_LETTER: {
								alt75 = 4;
							}
								break;
							case RULE_ONE_INT: {
								alt75 = 5;
							}
								break;
							case 56:
							case 57:
							case 58:
							case 59: {
								alt75 = 6;
							}
								break;
							default:
								if (state.backtracking > 0) {
									state.failed = true;
									return current;
								}
								NoViableAltException nvae = new NoViableAltException("", 75, 0, input);

								throw nvae;
							}

							switch (alt75) {
							case 1:
							// InternalCSS.g:3405:31: this_UNDERSCORE_5= RULE_UNDERSCORE
							{
								this_UNDERSCORE_5 = (Token) match(input, RULE_UNDERSCORE, FOLLOW_47);
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									current.merge(this_UNDERSCORE_5);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_UNDERSCORE_5, grammarAccess.getIdentifierAccess().getUNDERSCORETerminalRuleCall_2_0_0());

								}

							}
								break;
							case 2:
							// InternalCSS.g:3413:10: this_DASH_6= RULE_DASH
							{
								this_DASH_6 = (Token) match(input, RULE_DASH, FOLLOW_47);
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									current.merge(this_DASH_6);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_DASH_6, grammarAccess.getIdentifierAccess().getDASHTerminalRuleCall_2_0_1());

								}

							}
								break;
							case 3:
							// InternalCSS.g:3421:10: this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER
							{
								this_ONE_HEX_LETTER_7 = (Token) match(input, RULE_ONE_HEX_LETTER, FOLLOW_47);
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									current.merge(this_ONE_HEX_LETTER_7);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_ONE_HEX_LETTER_7, grammarAccess.getIdentifierAccess().getONE_HEX_LETTERTerminalRuleCall_2_0_2());

								}

							}
								break;
							case 4:
							// InternalCSS.g:3429:10: this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER
							{
								this_ONE_NON_HEX_LETTER_8 = (Token) match(input, RULE_ONE_NON_HEX_LETTER, FOLLOW_47);
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									current.merge(this_ONE_NON_HEX_LETTER_8);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_ONE_NON_HEX_LETTER_8, grammarAccess.getIdentifierAccess().getONE_NON_HEX_LETTERTerminalRuleCall_2_0_3());

								}

							}
								break;
							case 5:
							// InternalCSS.g:3437:10: this_ONE_INT_9= RULE_ONE_INT
							{
								this_ONE_INT_9 = (Token) match(input, RULE_ONE_INT, FOLLOW_47);
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									current.merge(this_ONE_INT_9);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_ONE_INT_9, grammarAccess.getIdentifierAccess().getONE_INTTerminalRuleCall_2_0_4());

								}

							}
								break;
							case 6:
							// InternalCSS.g:3446:5: this_KeywordHack_10= ruleKeywordHack
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getIdentifierAccess().getKeywordHackParserRuleCall_2_0_5());

								}
								pushFollow(FOLLOW_47);
								this_KeywordHack_10 = ruleKeywordHack();

								state._fsp--;
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									current.merge(this_KeywordHack_10);

								}
								if (state.backtracking == 0) {

									afterParserOrEnumRuleCall();

								}

							}
								break;

							}


						}
							break;

						default:
							break loop76;
						}
					} while (true);


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "ruleIdentifier"


	// $ANTLR start "entryRuleNum"
	// InternalCSS.g:3467:1: entryRuleNum returns [String current=null] : iv_ruleNum= ruleNum EOF ;
	public final String entryRuleNum() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleNum = null;



		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens();

		try {
			// InternalCSS.g:3471:2: (iv_ruleNum= ruleNum EOF )
			// InternalCSS.g:3472:2: iv_ruleNum= ruleNum EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getNumRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleNum = ruleNum();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleNum.getText();
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRuleNum"


	// $ANTLR start "ruleNum"
	// InternalCSS.g:3482:1: ruleNum returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_PLUS_0= RULE_PLUS | this_DASH_1= RULE_DASH )? ( (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+ ) | ( ( ( RULE_ONE_INT
	// )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+ )? ) ) ) ;
	public final AntlrDatatypeRuleToken ruleNum() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_PLUS_0 = null;
		Token this_DASH_1 = null;
		Token kw = null;
		Token this_ONE_INT_3 = null;
		Token this_ONE_INT_4 = null;
		Token this_ONE_INT_6 = null;

		enterRule();
		HiddenTokens myHiddenTokenState = ((XtextTokenStream) input).setHiddenTokens();

		try {
			// InternalCSS.g:3486:28: ( ( (this_PLUS_0= RULE_PLUS | this_DASH_1= RULE_DASH )? ( (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+ ) | ( ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT
			// )=>this_ONE_INT_6= RULE_ONE_INT )+ )? ) ) ) )
			// InternalCSS.g:3487:1: ( (this_PLUS_0= RULE_PLUS | this_DASH_1= RULE_DASH )? ( (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+ ) | ( ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT
			// )=>this_ONE_INT_6= RULE_ONE_INT )+ )? ) ) )
			{
				// InternalCSS.g:3487:1: ( (this_PLUS_0= RULE_PLUS | this_DASH_1= RULE_DASH )? ( (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+ ) | ( ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT
				// )=>this_ONE_INT_6= RULE_ONE_INT )+ )? ) ) )
				// InternalCSS.g:3487:2: (this_PLUS_0= RULE_PLUS | this_DASH_1= RULE_DASH )? ( (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+ ) | ( ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT
				// )=>this_ONE_INT_6= RULE_ONE_INT )+ )? ) )
				{
					// InternalCSS.g:3487:2: (this_PLUS_0= RULE_PLUS | this_DASH_1= RULE_DASH )?
					int alt77 = 3;
					int LA77_0 = input.LA(1);

					if ((LA77_0 == RULE_PLUS)) {
						alt77 = 1;
					} else if ((LA77_0 == RULE_DASH)) {
						alt77 = 2;
					}
					switch (alt77) {
					case 1:
					// InternalCSS.g:3487:7: this_PLUS_0= RULE_PLUS
					{
						this_PLUS_0 = (Token) match(input, RULE_PLUS, FOLLOW_48);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							current.merge(this_PLUS_0);

						}
						if (state.backtracking == 0) {

							newLeafNode(this_PLUS_0, grammarAccess.getNumAccess().getPLUSTerminalRuleCall_0_0());

						}

					}
						break;
					case 2:
					// InternalCSS.g:3495:10: this_DASH_1= RULE_DASH
					{
						this_DASH_1 = (Token) match(input, RULE_DASH, FOLLOW_48);
						if (state.failed) {
							return current;
						}
						if (state.backtracking == 0) {

							current.merge(this_DASH_1);

						}
						if (state.backtracking == 0) {

							newLeafNode(this_DASH_1, grammarAccess.getNumAccess().getDASHTerminalRuleCall_0_1());

						}

					}
						break;

					}

					// InternalCSS.g:3502:3: ( (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+ ) | ( ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+ )? ) )
					int alt82 = 2;
					int LA82_0 = input.LA(1);

					if ((LA82_0 == 41)) {
						alt82 = 1;
					} else if ((LA82_0 == RULE_ONE_INT)) {
						alt82 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 82, 0, input);

						throw nvae;
					}
					switch (alt82) {
					case 1:
					// InternalCSS.g:3502:4: (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+ )
					{
						// InternalCSS.g:3502:4: (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+ )
						// InternalCSS.g:3503:2: kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+
						{
							kw = (Token) match(input, 41, FOLLOW_49);
							if (state.failed) {
								return current;
							}
							if (state.backtracking == 0) {

								current.merge(kw);
								newLeafNode(kw, grammarAccess.getNumAccess().getFullStopKeyword_1_0_0());

							}
							// InternalCSS.g:3508:1: ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+
							int cnt78 = 0;
							loop78: do {
								int alt78 = 2;
								int LA78_0 = input.LA(1);

								if ((LA78_0 == RULE_ONE_INT)) {
									int LA78_2 = input.LA(2);

									if ((synpred3_InternalCSS())) {
										alt78 = 1;
									}


								}


								switch (alt78) {
								case 1:
								// InternalCSS.g:3508:2: ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT
								{
									this_ONE_INT_3 = (Token) match(input, RULE_ONE_INT, FOLLOW_50);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										current.merge(this_ONE_INT_3);

									}
									if (state.backtracking == 0) {

										newLeafNode(this_ONE_INT_3, grammarAccess.getNumAccess().getONE_INTTerminalRuleCall_1_0_1());

									}

								}
									break;

								default:
									if (cnt78 >= 1) {
										break loop78;
									}
									if (state.backtracking > 0) {
										state.failed = true;
										return current;
									}
									EarlyExitException eee = new EarlyExitException(78, input);
									throw eee;
								}
								cnt78++;
							} while (true);


						}


					}
						break;
					case 2:
					// InternalCSS.g:3516:6: ( ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+ )? )
					{
						// InternalCSS.g:3516:6: ( ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+ )? )
						// InternalCSS.g:3516:7: ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+ )?
						{
							// InternalCSS.g:3516:7: ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+
							int cnt79 = 0;
							loop79: do {
								int alt79 = 2;
								int LA79_0 = input.LA(1);

								if ((LA79_0 == RULE_ONE_INT)) {
									int LA79_2 = input.LA(2);

									if ((synpred4_InternalCSS())) {
										alt79 = 1;
									}


								}


								switch (alt79) {
								case 1:
								// InternalCSS.g:3516:8: ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT
								{
									this_ONE_INT_4 = (Token) match(input, RULE_ONE_INT, FOLLOW_51);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										current.merge(this_ONE_INT_4);

									}
									if (state.backtracking == 0) {

										newLeafNode(this_ONE_INT_4, grammarAccess.getNumAccess().getONE_INTTerminalRuleCall_1_1_0());

									}

								}
									break;

								default:
									if (cnt79 >= 1) {
										break loop79;
									}
									if (state.backtracking > 0) {
										state.failed = true;
										return current;
									}
									EarlyExitException eee = new EarlyExitException(79, input);
									throw eee;
								}
								cnt79++;
							} while (true);

							// InternalCSS.g:3523:3: ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+ )?
							int alt81 = 2;
							int LA81_0 = input.LA(1);

							if ((LA81_0 == 41)) {
								int LA81_1 = input.LA(2);

								if ((LA81_1 == RULE_ONE_INT)) {
									int LA81_3 = input.LA(3);

									if ((synpred5_InternalCSS())) {
										alt81 = 1;
									}
								}
							}
							switch (alt81) {
							case 1:
							// InternalCSS.g:3523:4: ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+
							{
								// InternalCSS.g:3523:4: ( ( '.' )=>kw= '.' )
								// InternalCSS.g:3523:5: ( '.' )=>kw= '.'
								{
									kw = (Token) match(input, 41, FOLLOW_49);
									if (state.failed) {
										return current;
									}
									if (state.backtracking == 0) {

										current.merge(kw);
										newLeafNode(kw, grammarAccess.getNumAccess().getFullStopKeyword_1_1_1_0());

									}

								}

								// InternalCSS.g:3531:2: ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+
								int cnt80 = 0;
								loop80: do {
									int alt80 = 2;
									int LA80_0 = input.LA(1);

									if ((LA80_0 == RULE_ONE_INT)) {
										int LA80_2 = input.LA(2);

										if ((synpred6_InternalCSS())) {
											alt80 = 1;
										}


									}


									switch (alt80) {
									case 1:
									// InternalCSS.g:3531:3: ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT
									{
										this_ONE_INT_6 = (Token) match(input, RULE_ONE_INT, FOLLOW_50);
										if (state.failed) {
											return current;
										}
										if (state.backtracking == 0) {

											current.merge(this_ONE_INT_6);

										}
										if (state.backtracking == 0) {

											newLeafNode(this_ONE_INT_6, grammarAccess.getNumAccess().getONE_INTTerminalRuleCall_1_1_1_1());

										}

									}
										break;

									default:
										if (cnt80 >= 1) {
											break loop80;
										}
										if (state.backtracking > 0) {
											state.failed = true;
											return current;
										}
										EarlyExitException eee = new EarlyExitException(80, input);
										throw eee;
									}
									cnt80++;
								} while (true);


							}
								break;

							}


						}


					}
						break;

					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {

			myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "ruleNum"


	// $ANTLR start "entryRuleHex"
	// InternalCSS.g:3549:1: entryRuleHex returns [String current=null] : iv_ruleHex= ruleHex EOF ;
	public final String entryRuleHex() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleHex = null;


		try {
			// InternalCSS.g:3550:2: (iv_ruleHex= ruleHex EOF )
			// InternalCSS.g:3551:2: iv_ruleHex= ruleHex EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getHexRule());
				}
				pushFollow(FOLLOW_1);
				iv_ruleHex = ruleHex();

				state._fsp--;
				if (state.failed) {
					return current;
				}
				if (state.backtracking == 0) {
					current = iv_ruleHex.getText();
				}
				match(input, EOF, FOLLOW_2);
				if (state.failed) {
					return current;
				}

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleHex"


	// $ANTLR start "ruleHex"
	// InternalCSS.g:3558:1: ruleHex returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HASHMARK_0= RULE_HASHMARK ( ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )=> (this_ONE_INT_1= RULE_ONE_INT | this_ONE_HEX_LETTER_2=
	// RULE_ONE_HEX_LETTER ) )+ ) ;
	public final AntlrDatatypeRuleToken ruleHex() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_HASHMARK_0 = null;
		Token this_ONE_INT_1 = null;
		Token this_ONE_HEX_LETTER_2 = null;

		enterRule();

		try {
			// InternalCSS.g:3561:28: ( (this_HASHMARK_0= RULE_HASHMARK ( ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )=> (this_ONE_INT_1= RULE_ONE_INT | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER ) )+ ) )
			// InternalCSS.g:3562:1: (this_HASHMARK_0= RULE_HASHMARK ( ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )=> (this_ONE_INT_1= RULE_ONE_INT | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER ) )+ )
			{
				// InternalCSS.g:3562:1: (this_HASHMARK_0= RULE_HASHMARK ( ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )=> (this_ONE_INT_1= RULE_ONE_INT | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER ) )+ )
				// InternalCSS.g:3562:6: this_HASHMARK_0= RULE_HASHMARK ( ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )=> (this_ONE_INT_1= RULE_ONE_INT | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER ) )+
				{
					this_HASHMARK_0 = (Token) match(input, RULE_HASHMARK, FOLLOW_46);
					if (state.failed) {
						return current;
					}
					if (state.backtracking == 0) {

						current.merge(this_HASHMARK_0);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_HASHMARK_0, grammarAccess.getHexAccess().getHASHMARKTerminalRuleCall_0());

					}
					// InternalCSS.g:3569:1: ( ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )=> (this_ONE_INT_1= RULE_ONE_INT | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER ) )+
					int cnt84 = 0;
					loop84: do {
						int alt84 = 2;
						int LA84_0 = input.LA(1);

						if ((LA84_0 == RULE_ONE_HEX_LETTER)) {
							int LA84_2 = input.LA(2);

							if ((synpred7_InternalCSS())) {
								alt84 = 1;
							}


						} else if ((LA84_0 == RULE_ONE_INT)) {
							int LA84_3 = input.LA(2);

							if ((synpred7_InternalCSS())) {
								alt84 = 1;
							}


						}


						switch (alt84) {
						case 1:
						// InternalCSS.g:3569:2: ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )=> (this_ONE_INT_1= RULE_ONE_INT | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER )
						{
							// InternalCSS.g:3570:30: (this_ONE_INT_1= RULE_ONE_INT | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER )
							int alt83 = 2;
							int LA83_0 = input.LA(1);

							if ((LA83_0 == RULE_ONE_INT)) {
								alt83 = 1;
							} else if ((LA83_0 == RULE_ONE_HEX_LETTER)) {
								alt83 = 2;
							} else {
								if (state.backtracking > 0) {
									state.failed = true;
									return current;
								}
								NoViableAltException nvae = new NoViableAltException("", 83, 0, input);

								throw nvae;
							}
							switch (alt83) {
							case 1:
							// InternalCSS.g:3570:35: this_ONE_INT_1= RULE_ONE_INT
							{
								this_ONE_INT_1 = (Token) match(input, RULE_ONE_INT, FOLLOW_52);
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									current.merge(this_ONE_INT_1);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_ONE_INT_1, grammarAccess.getHexAccess().getONE_INTTerminalRuleCall_1_0_0());

								}

							}
								break;
							case 2:
							// InternalCSS.g:3578:10: this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER
							{
								this_ONE_HEX_LETTER_2 = (Token) match(input, RULE_ONE_HEX_LETTER, FOLLOW_52);
								if (state.failed) {
									return current;
								}
								if (state.backtracking == 0) {

									current.merge(this_ONE_HEX_LETTER_2);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_ONE_HEX_LETTER_2, grammarAccess.getHexAccess().getONE_HEX_LETTERTerminalRuleCall_1_0_1());

								}

							}
								break;

							}


						}
							break;

						default:
							if (cnt84 >= 1) {
								break loop84;
							}
							if (state.backtracking > 0) {
								state.failed = true;
								return current;
							}
							EarlyExitException eee = new EarlyExitException(84, input);
							throw eee;
						}
						cnt84++;
					} while (true);


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleHex"

	// $ANTLR start synpred1_InternalCSS
	public final void synpred1_InternalCSS_fragment() throws RecognitionException {
		// InternalCSS.g:1267:7: ( ( ruleSubSelectorForNegation ) )
		// InternalCSS.g:1268:1: ( ruleSubSelectorForNegation )
		{
			// InternalCSS.g:1268:1: ( ruleSubSelectorForNegation )
			// InternalCSS.g:1269:1: ruleSubSelectorForNegation
			{
				pushFollow(FOLLOW_2);
				ruleSubSelectorForNegation();

				state._fsp--;
				if (state.failed) {
					return;
				}

			}


		}
	}
	// $ANTLR end synpred1_InternalCSS

	// $ANTLR start synpred2_InternalCSS
	public final void synpred2_InternalCSS_fragment() throws RecognitionException {
		// InternalCSS.g:3400:3: ( ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )
		// InternalCSS.g:3400:4: ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack )
		{
			// InternalCSS.g:3400:4: ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack )
			int alt85 = 6;
			switch (input.LA(1)) {
			case RULE_UNDERSCORE: {
				alt85 = 1;
			}
				break;
			case RULE_DASH: {
				alt85 = 2;
			}
				break;
			case RULE_ONE_HEX_LETTER: {
				alt85 = 3;
			}
				break;
			case RULE_ONE_NON_HEX_LETTER: {
				alt85 = 4;
			}
				break;
			case RULE_ONE_INT: {
				alt85 = 5;
			}
				break;
			case 56:
			case 57:
			case 58:
			case 59: {
				alt85 = 6;
			}
				break;
			default:
				if (state.backtracking > 0) {
					state.failed = true;
					return;
				}
				NoViableAltException nvae = new NoViableAltException("", 85, 0, input);

				throw nvae;
			}

			switch (alt85) {
			case 1:
			// InternalCSS.g:3400:6: RULE_UNDERSCORE
			{
				match(input, RULE_UNDERSCORE, FOLLOW_2);
				if (state.failed) {
					return;
				}

			}
				break;
			case 2:
			// InternalCSS.g:3401:7: RULE_DASH
			{
				match(input, RULE_DASH, FOLLOW_2);
				if (state.failed) {
					return;
				}

			}
				break;
			case 3:
			// InternalCSS.g:3402:7: RULE_ONE_HEX_LETTER
			{
				match(input, RULE_ONE_HEX_LETTER, FOLLOW_2);
				if (state.failed) {
					return;
				}

			}
				break;
			case 4:
			// InternalCSS.g:3403:7: RULE_ONE_NON_HEX_LETTER
			{
				match(input, RULE_ONE_NON_HEX_LETTER, FOLLOW_2);
				if (state.failed) {
					return;
				}

			}
				break;
			case 5:
			// InternalCSS.g:3404:7: RULE_ONE_INT
			{
				match(input, RULE_ONE_INT, FOLLOW_2);
				if (state.failed) {
					return;
				}

			}
				break;
			case 6:
			// InternalCSS.g:3405:7: ruleKeywordHack
			{
				pushFollow(FOLLOW_2);
				ruleKeywordHack();

				state._fsp--;
				if (state.failed) {
					return;
				}

			}
				break;

			}


		}
	}
	// $ANTLR end synpred2_InternalCSS

	// $ANTLR start synpred3_InternalCSS
	public final void synpred3_InternalCSS_fragment() throws RecognitionException {
		// InternalCSS.g:3508:2: ( RULE_ONE_INT )
		// InternalCSS.g:3508:4: RULE_ONE_INT
		{
			match(input, RULE_ONE_INT, FOLLOW_2);
			if (state.failed) {
				return;
			}

		}
	}
	// $ANTLR end synpred3_InternalCSS

	// $ANTLR start synpred4_InternalCSS
	public final void synpred4_InternalCSS_fragment() throws RecognitionException {
		// InternalCSS.g:3516:8: ( RULE_ONE_INT )
		// InternalCSS.g:3516:10: RULE_ONE_INT
		{
			match(input, RULE_ONE_INT, FOLLOW_2);
			if (state.failed) {
				return;
			}

		}
	}
	// $ANTLR end synpred4_InternalCSS

	// $ANTLR start synpred5_InternalCSS
	public final void synpred5_InternalCSS_fragment() throws RecognitionException {
		// InternalCSS.g:3523:5: ( '.' )
		// InternalCSS.g:3524:2: '.'
		{
			match(input, 41, FOLLOW_2);
			if (state.failed) {
				return;
			}

		}
	}
	// $ANTLR end synpred5_InternalCSS

	// $ANTLR start synpred6_InternalCSS
	public final void synpred6_InternalCSS_fragment() throws RecognitionException {
		// InternalCSS.g:3531:3: ( RULE_ONE_INT )
		// InternalCSS.g:3531:5: RULE_ONE_INT
		{
			match(input, RULE_ONE_INT, FOLLOW_2);
			if (state.failed) {
				return;
			}

		}
	}
	// $ANTLR end synpred6_InternalCSS

	// $ANTLR start synpred7_InternalCSS
	public final void synpred7_InternalCSS_fragment() throws RecognitionException {
		// InternalCSS.g:3569:2: ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )
		// InternalCSS.g:3569:3: ( RULE_ONE_INT | RULE_ONE_HEX_LETTER )
		{
			if (input.LA(1) == RULE_ONE_HEX_LETTER || input.LA(1) == RULE_ONE_INT) {
				input.consume();
				state.errorRecovery = false;
				state.failed = false;
			} else {
				if (state.backtracking > 0) {
					state.failed = true;
					return;
				}
				MismatchedSetException mse = new MismatchedSetException(null, input);
				throw mse;
			}


		}
	}
	// $ANTLR end synpred7_InternalCSS

	// Delegated rules

	public final boolean synpred4_InternalCSS() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_InternalCSS_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}

	public final boolean synpred6_InternalCSS() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred6_InternalCSS_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}

	public final boolean synpred5_InternalCSS() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred5_InternalCSS_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}

	public final boolean synpred1_InternalCSS() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_InternalCSS_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}

	public final boolean synpred2_InternalCSS() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_InternalCSS_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}

	public final boolean synpred3_InternalCSS() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_InternalCSS_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}

	public final boolean synpred7_InternalCSS() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred7_InternalCSS_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}


	protected DFA29 dfa29 = new DFA29(this);
	protected DFA38 dfa38 = new DFA38(this);
	protected DFA39 dfa39 = new DFA39(this);
	protected DFA44 dfa44 = new DFA44(this);
	protected DFA58 dfa58 = new DFA58(this);
	protected DFA76 dfa76 = new DFA76(this);
	static final String dfa_1s = "\4\uffff";
	static final String dfa_2s = "\2\6\2\uffff";
	static final String dfa_3s = "\2\33\2\uffff";
	static final String dfa_4s = "\2\uffff\1\2\1\1";
	static final String dfa_5s = "\4\uffff}>";
	static final String[] dfa_6s = {
			"\1\3\1\uffff\1\1\22\uffff\1\2",
			"\1\3\1\uffff\1\1\22\uffff\1\2",
			"",
			""
	};

	static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
	static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
	static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
	static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
	static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
	static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

	class DFA29 extends DFA {

		public DFA29(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 29;
			this.eot = dfa_1;
			this.eof = dfa_1;
			this.min = dfa_2;
			this.max = dfa_3;
			this.accept = dfa_4;
			this.special = dfa_5;
			this.transition = dfa_6;
		}

		@Override
		public String getDescription() {
			return "()* loopback of 974:2: ( (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA ( (lv_selectors_3_0= ruleselector ) ) )*";
		}
	}

	static final String dfa_7s = "\5\uffff";
	static final String dfa_8s = "\1\3\4\uffff";
	static final String dfa_9s = "\1\6\1\uffff\1\5\2\uffff";
	static final String dfa_10s = "\1\60\1\uffff\1\73\2\uffff";
	static final String dfa_11s = "\1\uffff\1\1\1\uffff\1\3\1\2";
	static final String dfa_12s = "\5\uffff}>";
	static final String[] dfa_13s = {
			"\1\3\1\uffff\1\2\4\uffff\1\1\15\uffff\1\3\23\uffff\2\1",
			"",
			"\1\4\1\3\1\uffff\1\2\2\uffff\1\4\1\uffff\5\4\11\uffff\1\3\7\uffff\1\4\5\uffff\3\4\3\uffff\2\4\7\uffff\4\4",
			"",
			""
	};

	static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
	static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
	static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
	static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
	static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
	static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
	static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

	class DFA38 extends DFA {

		public DFA38(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 38;
			this.eot = dfa_7;
			this.eof = dfa_8;
			this.min = dfa_9;
			this.max = dfa_10;
			this.accept = dfa_11;
			this.special = dfa_12;
			this.transition = dfa_13;
		}

		@Override
		public String getDescription() {
			return "1102:2: ( ( ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) ) | ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) ) )?";
		}
	}

	static final String dfa_14s = "\24\uffff";
	static final String dfa_15s = "\2\uffff\7\23\1\uffff\11\23\1\uffff";
	static final String dfa_16s = "\1\16\1\17\7\5\1\uffff\11\5\1\uffff";
	static final String dfa_17s = "\11\73\1\uffff\11\73\1\uffff";
	static final String dfa_18s = "\11\uffff\1\2\11\uffff\1\1";
	static final String dfa_19s = "\24\uffff}>";
	static final String[] dfa_20s = {
			"\1\1\1\2\1\3\1\4\30\uffff\2\11\14\uffff\1\5\1\6\1\7\1\10",
			"\1\2\1\3\1\4\46\uffff\1\5\1\6\1\7\1\10",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21\1\22",
			""
	};

	static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
	static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
	static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
	static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
	static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
	static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
	static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

	class DFA39 extends DFA {

		public DFA39(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 39;
			this.eot = dfa_14;
			this.eof = dfa_15;
			this.min = dfa_16;
			this.max = dfa_17;
			this.accept = dfa_18;
			this.special = dfa_19;
			this.transition = dfa_20;
		}

		@Override
		public String getDescription() {
			return "1211:3: ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) )";
		}
	}

	static final String[] dfa_21s = {
			"\1\1\1\2\1\3\1\4\30\uffff\2\11\14\uffff\1\5\1\6\1\7\1\10",
			"\1\2\1\3\1\4\46\uffff\1\5\1\6\1\7\1\10",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			""
	};
	static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

	class DFA44 extends DFA {

		public DFA44(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 44;
			this.eot = dfa_14;
			this.eof = dfa_15;
			this.min = dfa_16;
			this.max = dfa_17;
			this.accept = dfa_18;
			this.special = dfa_19;
			this.transition = dfa_21;
		}

		@Override
		public String getDescription() {
			return "1377:3: ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) )";
		}
	}

	static final String dfa_22s = "\25\uffff";
	static final String dfa_23s = "\4\uffff\7\13\1\uffff\11\13";
	static final String dfa_24s = "\2\5\1\uffff\1\17\7\5\1\uffff\11\5";
	static final String dfa_25s = "\1\5\1\73\1\uffff\10\73\1\uffff\11\73";
	static final String dfa_26s = "\2\uffff\1\2\10\uffff\1\1\11\uffff";
	static final String dfa_27s = "\25\uffff}>";
	static final String[] dfa_28s = {
			"\1\1",
			"\1\13\10\uffff\1\3\1\4\1\5\1\6\34\uffff\1\2\11\uffff\1\7\1\10\1\11\1\12",
			"",
			"\1\4\1\5\1\6\46\uffff\1\7\1\10\1\11\1\12",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24"
	};

	static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
	static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
	static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
	static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
	static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
	static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
	static final short[][] dfa_28 = unpackEncodedStringArray(dfa_28s);

	class DFA58 extends DFA {

		public DFA58(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 58;
			this.eot = dfa_22;
			this.eof = dfa_23;
			this.min = dfa_24;
			this.max = dfa_25;
			this.accept = dfa_26;
			this.special = dfa_27;
			this.transition = dfa_28;
		}

		@Override
		public String getDescription() {
			return "2119:1: (this_PseudoClass_0= rulePseudoClass | this_PseudoClassFunction_1= rulePseudoClassFunction )";
		}
	}

	static final String dfa_29s = "\14\uffff";
	static final String dfa_30s = "\1\1\13\uffff";
	static final String dfa_31s = "\1\4\1\uffff\11\0\1\uffff";
	static final String dfa_32s = "\1\73\1\uffff\11\0\1\uffff";
	static final String dfa_33s = "\1\uffff\1\2\11\uffff\1\1";
	static final String dfa_34s = "\2\uffff\1\6\1\0\1\10\1\1\1\2\1\3\1\4\1\5\1\7\1\uffff}>";
	static final String[] dfa_35s = {
			"\12\1\1\2\1\3\1\4\1\5\1\12\3\uffff\1\1\4\uffff\2\1\6\uffff\7\1\1\uffff\3\1\1\uffff\3\1\6\uffff\1\6\1\7\1\10\1\11",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			""
	};

	static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
	static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
	static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
	static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
	static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
	static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
	static final short[][] dfa_35 = unpackEncodedStringArray(dfa_35s);

	class DFA76 extends DFA {

		public DFA76(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 76;
			this.eot = dfa_29;
			this.eof = dfa_30;
			this.min = dfa_31;
			this.max = dfa_32;
			this.accept = dfa_33;
			this.special = dfa_34;
			this.transition = dfa_35;
		}

		@Override
		public String getDescription() {
			return "()* loopback of 3400:2: ( ( ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )=> (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10= ruleKeywordHack ) )*";
		}

		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream) _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA76_3 = input.LA(1);


				int index76_3 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_3);
				if (s >= 0) {
					return s;
				}
				break;
			case 1:
				int LA76_5 = input.LA(1);


				int index76_5 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_5);
				if (s >= 0) {
					return s;
				}
				break;
			case 2:
				int LA76_6 = input.LA(1);


				int index76_6 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_6);
				if (s >= 0) {
					return s;
				}
				break;
			case 3:
				int LA76_7 = input.LA(1);


				int index76_7 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_7);
				if (s >= 0) {
					return s;
				}
				break;
			case 4:
				int LA76_8 = input.LA(1);


				int index76_8 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_8);
				if (s >= 0) {
					return s;
				}
				break;
			case 5:
				int LA76_9 = input.LA(1);


				int index76_9 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_9);
				if (s >= 0) {
					return s;
				}
				break;
			case 6:
				int LA76_2 = input.LA(1);


				int index76_2 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_2);
				if (s >= 0) {
					return s;
				}
				break;
			case 7:
				int LA76_10 = input.LA(1);


				int index76_10 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_10);
				if (s >= 0) {
					return s;
				}
				break;
			case 8:
				int LA76_4 = input.LA(1);


				int index76_4 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_4);
				if (s >= 0) {
					return s;
				}
				break;
			}
			if (state.backtracking > 0) {
				state.failed = true;
				return -1;
			}
			NoViableAltException nvae = new NoViableAltException(getDescription(), 76, _s, input);
			error(nvae);
			throw nvae;
		}
	}


	public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x0F000E0FE783C822L });
	public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x0F000E0FE603C822L });
	public static final BitSet FOLLOW_5 = new BitSet(new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_6 = new BitSet(new long[] { 0x0000000000400000L });
	public static final BitSet FOLLOW_7 = new BitSet(new long[] { 0x0002000000000010L });
	public static final BitSet FOLLOW_8 = new BitSet(new long[] { 0x0F0000000043C000L });
	public static final BitSet FOLLOW_9 = new BitSet(new long[] { 0x0000000008000020L });
	public static final BitSet FOLLOW_10 = new BitSet(new long[] { 0x0000000008000000L });
	public static final BitSet FOLLOW_11 = new BitSet(new long[] { 0x0F0000001043C100L });
	public static final BitSet FOLLOW_12 = new BitSet(new long[] { 0x0000000010400000L });
	public static final BitSet FOLLOW_13 = new BitSet(new long[] { 0x0F0000000003C000L });
	public static final BitSet FOLLOW_14 = new BitSet(new long[] { 0x0F000E081003C820L });
	public static final BitSet FOLLOW_15 = new BitSet(new long[] { 0x0000000000000042L });
	public static final BitSet FOLLOW_16 = new BitSet(new long[] { 0x0F0002001047E000L });
	public static final BitSet FOLLOW_17 = new BitSet(new long[] { 0x0000000000000080L });
	public static final BitSet FOLLOW_18 = new BitSet(new long[] { 0x0000000008000140L });
	public static final BitSet FOLLOW_19 = new BitSet(new long[] { 0x0000000000000140L });
	public static final BitSet FOLLOW_20 = new BitSet(new long[] { 0x0F000E080003C820L });
	public static final BitSet FOLLOW_21 = new BitSet(new long[] { 0x0000000008000100L });
	public static final BitSet FOLLOW_22 = new BitSet(new long[] { 0x0F0000001003C100L });
	public static final BitSet FOLLOW_23 = new BitSet(new long[] { 0x0F0000000003C100L });
	public static final BitSet FOLLOW_24 = new BitSet(new long[] { 0x0000000010000000L });
	public static final BitSet FOLLOW_25 = new BitSet(new long[] { 0x0001800000002102L });
	public static final BitSet FOLLOW_26 = new BitSet(new long[] { 0x0F000E080003C920L });
	public static final BitSet FOLLOW_27 = new BitSet(new long[] { 0x0F018E080003E920L });
	public static final BitSet FOLLOW_28 = new BitSet(new long[] { 0x0000020800000822L });
	public static final BitSet FOLLOW_29 = new BitSet(new long[] { 0x0F000E080003C822L });
	public static final BitSet FOLLOW_30 = new BitSet(new long[] { 0x000001F000000600L });
	public static final BitSet FOLLOW_31 = new BitSet(new long[] { 0x0F0000000003C010L });
	public static final BitSet FOLLOW_32 = new BitSet(new long[] { 0x0000010000000000L });
	public static final BitSet FOLLOW_33 = new BitSet(new long[] { 0x0000040000000000L });
	public static final BitSet FOLLOW_34 = new BitSet(new long[] { 0x0000080000000000L });
	public static final BitSet FOLLOW_35 = new BitSet(new long[] { 0x0000000000000120L });
	public static final BitSet FOLLOW_36 = new BitSet(new long[] { 0x0F0202000007E9D0L });
	public static final BitSet FOLLOW_37 = new BitSet(new long[] { 0x0F0202000007F9D2L });
	public static final BitSet FOLLOW_38 = new BitSet(new long[] { 0x0F0000000003C020L });
	public static final BitSet FOLLOW_39 = new BitSet(new long[] { 0x0000100000000000L });
	public static final BitSet FOLLOW_40 = new BitSet(new long[] { 0x0000200000000000L });
	public static final BitSet FOLLOW_41 = new BitSet(new long[] { 0x0F0212000007E9D0L });
	public static final BitSet FOLLOW_42 = new BitSet(new long[] { 0x0000400000000000L });
	public static final BitSet FOLLOW_43 = new BitSet(new long[] { 0x0000200000000002L });
	public static final BitSet FOLLOW_44 = new BitSet(new long[] { 0xFFFD07880047E8F0L, 0x0000000000000001L });
	public static final BitSet FOLLOW_45 = new BitSet(new long[] { 0xFFFD07880047E8E2L, 0x0000000000000001L });
	public static final BitSet FOLLOW_46 = new BitSet(new long[] { 0x0000000000050000L });
	public static final BitSet FOLLOW_47 = new BitSet(new long[] { 0x0F0000000007C002L });
	public static final BitSet FOLLOW_48 = new BitSet(new long[] { 0x0000020000040000L });
	public static final BitSet FOLLOW_49 = new BitSet(new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_50 = new BitSet(new long[] { 0x0000000000040002L });
	public static final BitSet FOLLOW_51 = new BitSet(new long[] { 0x0000020000040002L });
	public static final BitSet FOLLOW_52 = new BitSet(new long[] { 0x0000000000050002L });

}