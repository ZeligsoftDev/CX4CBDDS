package org.eclipse.ocl.xtext.markup.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.ocl.xtext.markup.services.MarkupGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/*******************************************************************************
 * Copyright (c) 2011, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalMarkupParser extends org.eclipse.ocl.xtext.base.utilities.CompatibilityAbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_NL", "RULE_WORD", "RULE_WS", "RULE_NUMBER", "RULE_LETTER", "RULE_ESCAPED", "RULE_VERTICAL_WS", "RULE_HORIZONTAL_WS", "RULE_ANY_OTHER", "'b'", "'e'", "'bullet'", "'figure'", "'figureRef'", "'footnote'", "'heading'", "'oclCode'", "'oclEval'", "'oclText'", "':'", "'['", "']'", "'#'", "','"
    };
    public static final int RULE_ESCAPED=12;
    public static final int RULE_WORD=8;
    public static final int RULE_STRING=6;
    public static final int RULE_VERTICAL_WS=13;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_HORIZONTAL_WS=14;
    public static final int RULE_ANY_OTHER=15;
    public static final int RULE_NUMBER=10;
    public static final int RULE_LETTER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int RULE_NL=7;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMarkupParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMarkupParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);

        }


    public String[] getTokenNames() { return InternalMarkupParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMarkup.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private MarkupGrammarAccess grammarAccess;

        public InternalMarkupParser(TokenStream input, MarkupGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Markup";
       	}

       	@Override
       	protected MarkupGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMarkup"
    // InternalMarkup.g:80:1: entryRuleMarkup returns [EObject current=null] : iv_ruleMarkup= ruleMarkup EOF ;
    public final EObject entryRuleMarkup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMarkup = null;


        try {
            // InternalMarkup.g:81:2: (iv_ruleMarkup= ruleMarkup EOF )
            // InternalMarkup.g:82:2: iv_ruleMarkup= ruleMarkup EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMarkupRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMarkup=ruleMarkup();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMarkup;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMarkup"


    // $ANTLR start "ruleMarkup"
    // InternalMarkup.g:89:1: ruleMarkup returns [EObject current=null] : ( (lv_elements_0_0= ruleMarkupElement ) )* ;
    public final EObject ruleMarkup() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule();

        try {
            // InternalMarkup.g:92:28: ( ( (lv_elements_0_0= ruleMarkupElement ) )* )
            // InternalMarkup.g:93:1: ( (lv_elements_0_0= ruleMarkupElement ) )*
            {
            // InternalMarkup.g:93:1: ( (lv_elements_0_0= ruleMarkupElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_INT && LA1_0<=RULE_ID)||(LA1_0>=RULE_NL && LA1_0<=RULE_WS)||(LA1_0>=16 && LA1_0<=27)||(LA1_0>=29 && LA1_0<=30)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMarkup.g:94:1: (lv_elements_0_0= ruleMarkupElement )
            	    {
            	    // InternalMarkup.g:94:1: (lv_elements_0_0= ruleMarkupElement )
            	    // InternalMarkup.g:95:3: lv_elements_0_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getMarkupAccess().getElementsMarkupElementParserRuleCall_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_elements_0_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMarkupRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"elements",
            	              		lv_elements_0_0,
            	              		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMarkup"


    // $ANTLR start "entryRuleMarkupKeyword"
    // InternalMarkup.g:119:1: entryRuleMarkupKeyword returns [String current=null] : iv_ruleMarkupKeyword= ruleMarkupKeyword EOF ;
    public final String entryRuleMarkupKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMarkupKeyword = null;


        try {
            // InternalMarkup.g:120:2: (iv_ruleMarkupKeyword= ruleMarkupKeyword EOF )
            // InternalMarkup.g:121:2: iv_ruleMarkupKeyword= ruleMarkupKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMarkupKeywordRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMarkupKeyword=ruleMarkupKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMarkupKeyword.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMarkupKeyword"


    // $ANTLR start "ruleMarkupKeyword"
    // InternalMarkup.g:128:1: ruleMarkupKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'b' | kw= 'e' | kw= 'bullet' | kw= 'figure' | kw= 'figureRef' | kw= 'footnote' | kw= 'heading' | kw= 'oclCode' | kw= 'oclEval' | kw= 'oclText' ) ;
    public final AntlrDatatypeRuleToken ruleMarkupKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule();

        try {
            // InternalMarkup.g:131:28: ( (kw= 'b' | kw= 'e' | kw= 'bullet' | kw= 'figure' | kw= 'figureRef' | kw= 'footnote' | kw= 'heading' | kw= 'oclCode' | kw= 'oclEval' | kw= 'oclText' ) )
            // InternalMarkup.g:132:1: (kw= 'b' | kw= 'e' | kw= 'bullet' | kw= 'figure' | kw= 'figureRef' | kw= 'footnote' | kw= 'heading' | kw= 'oclCode' | kw= 'oclEval' | kw= 'oclText' )
            {
            // InternalMarkup.g:132:1: (kw= 'b' | kw= 'e' | kw= 'bullet' | kw= 'figure' | kw= 'figureRef' | kw= 'footnote' | kw= 'heading' | kw= 'oclCode' | kw= 'oclEval' | kw= 'oclText' )
            int alt2=10;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt2=1;
                }
                break;
            case 17:
                {
                alt2=2;
                }
                break;
            case 18:
                {
                alt2=3;
                }
                break;
            case 19:
                {
                alt2=4;
                }
                break;
            case 20:
                {
                alt2=5;
                }
                break;
            case 21:
                {
                alt2=6;
                }
                break;
            case 22:
                {
                alt2=7;
                }
                break;
            case 23:
                {
                alt2=8;
                }
                break;
            case 24:
                {
                alt2=9;
                }
                break;
            case 25:
                {
                alt2=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalMarkup.g:133:2: kw= 'b'
                    {
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getBKeyword_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalMarkup.g:140:2: kw= 'e'
                    {
                    kw=(Token)match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getEKeyword_1());

                    }

                    }
                    break;
                case 3 :
                    // InternalMarkup.g:147:2: kw= 'bullet'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getBulletKeyword_2());

                    }

                    }
                    break;
                case 4 :
                    // InternalMarkup.g:154:2: kw= 'figure'
                    {
                    kw=(Token)match(input,19,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getFigureKeyword_3());

                    }

                    }
                    break;
                case 5 :
                    // InternalMarkup.g:161:2: kw= 'figureRef'
                    {
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getFigureRefKeyword_4());

                    }

                    }
                    break;
                case 6 :
                    // InternalMarkup.g:168:2: kw= 'footnote'
                    {
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getFootnoteKeyword_5());

                    }

                    }
                    break;
                case 7 :
                    // InternalMarkup.g:175:2: kw= 'heading'
                    {
                    kw=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getHeadingKeyword_6());

                    }

                    }
                    break;
                case 8 :
                    // InternalMarkup.g:182:2: kw= 'oclCode'
                    {
                    kw=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getOclCodeKeyword_7());

                    }

                    }
                    break;
                case 9 :
                    // InternalMarkup.g:189:2: kw= 'oclEval'
                    {
                    kw=(Token)match(input,24,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getOclEvalKeyword_8());

                    }

                    }
                    break;
                case 10 :
                    // InternalMarkup.g:196:2: kw= 'oclText'
                    {
                    kw=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getOclTextKeyword_9());

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMarkupKeyword"


    // $ANTLR start "entryRuleMarkupElement"
    // InternalMarkup.g:209:1: entryRuleMarkupElement returns [EObject current=null] : iv_ruleMarkupElement= ruleMarkupElement EOF ;
    public final EObject entryRuleMarkupElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMarkupElement = null;


        try {
            // InternalMarkup.g:210:2: (iv_ruleMarkupElement= ruleMarkupElement EOF )
            // InternalMarkup.g:211:2: iv_ruleMarkupElement= ruleMarkupElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMarkupElementRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMarkupElement=ruleMarkupElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMarkupElement;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMarkupElement"


    // $ANTLR start "ruleMarkupElement"
    // InternalMarkup.g:218:1: ruleMarkupElement returns [EObject current=null] : (this_FontElement_0= ruleFontElement | this_NewLineElement_1= ruleNewLineElement | this_BulletElement_2= ruleBulletElement | this_FigureElement_3= ruleFigureElement | this_FigureRefElement_4= ruleFigureRefElement | this_FootnoteElement_5= ruleFootnoteElement | this_HeadingElement_6= ruleHeadingElement | this_NullElement_7= ruleNullElement | this_OCLCodeElement_8= ruleOCLCodeElement | this_OCLEvalElement_9= ruleOCLEvalElement | this_OCLTextElement_10= ruleOCLTextElement | this_TextElement_11= ruleTextElement ) ;
    public final EObject ruleMarkupElement() throws RecognitionException {
        EObject current = null;

        EObject this_FontElement_0 = null;

        EObject this_NewLineElement_1 = null;

        EObject this_BulletElement_2 = null;

        EObject this_FigureElement_3 = null;

        EObject this_FigureRefElement_4 = null;

        EObject this_FootnoteElement_5 = null;

        EObject this_HeadingElement_6 = null;

        EObject this_NullElement_7 = null;

        EObject this_OCLCodeElement_8 = null;

        EObject this_OCLEvalElement_9 = null;

        EObject this_OCLTextElement_10 = null;

        EObject this_TextElement_11 = null;


         enterRule();

        try {
            // InternalMarkup.g:221:28: ( (this_FontElement_0= ruleFontElement | this_NewLineElement_1= ruleNewLineElement | this_BulletElement_2= ruleBulletElement | this_FigureElement_3= ruleFigureElement | this_FigureRefElement_4= ruleFigureRefElement | this_FootnoteElement_5= ruleFootnoteElement | this_HeadingElement_6= ruleHeadingElement | this_NullElement_7= ruleNullElement | this_OCLCodeElement_8= ruleOCLCodeElement | this_OCLEvalElement_9= ruleOCLEvalElement | this_OCLTextElement_10= ruleOCLTextElement | this_TextElement_11= ruleTextElement ) )
            // InternalMarkup.g:222:1: (this_FontElement_0= ruleFontElement | this_NewLineElement_1= ruleNewLineElement | this_BulletElement_2= ruleBulletElement | this_FigureElement_3= ruleFigureElement | this_FigureRefElement_4= ruleFigureRefElement | this_FootnoteElement_5= ruleFootnoteElement | this_HeadingElement_6= ruleHeadingElement | this_NullElement_7= ruleNullElement | this_OCLCodeElement_8= ruleOCLCodeElement | this_OCLEvalElement_9= ruleOCLEvalElement | this_OCLTextElement_10= ruleOCLTextElement | this_TextElement_11= ruleTextElement )
            {
            // InternalMarkup.g:222:1: (this_FontElement_0= ruleFontElement | this_NewLineElement_1= ruleNewLineElement | this_BulletElement_2= ruleBulletElement | this_FigureElement_3= ruleFigureElement | this_FigureRefElement_4= ruleFigureRefElement | this_FootnoteElement_5= ruleFootnoteElement | this_HeadingElement_6= ruleHeadingElement | this_NullElement_7= ruleNullElement | this_OCLCodeElement_8= ruleOCLCodeElement | this_OCLEvalElement_9= ruleOCLEvalElement | this_OCLTextElement_10= ruleOCLTextElement | this_TextElement_11= ruleTextElement )
            int alt3=12;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalMarkup.g:223:2: this_FontElement_0= ruleFontElement
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getMarkupElementAccess().getFontElementParserRuleCall_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FontElement_0=ruleFontElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_FontElement_0;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 2 :
                    // InternalMarkup.g:236:2: this_NewLineElement_1= ruleNewLineElement
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getMarkupElementAccess().getNewLineElementParserRuleCall_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NewLineElement_1=ruleNewLineElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_NewLineElement_1;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 3 :
                    // InternalMarkup.g:249:2: this_BulletElement_2= ruleBulletElement
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getMarkupElementAccess().getBulletElementParserRuleCall_2());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BulletElement_2=ruleBulletElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_BulletElement_2;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 4 :
                    // InternalMarkup.g:262:2: this_FigureElement_3= ruleFigureElement
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getMarkupElementAccess().getFigureElementParserRuleCall_3());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FigureElement_3=ruleFigureElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_FigureElement_3;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 5 :
                    // InternalMarkup.g:275:2: this_FigureRefElement_4= ruleFigureRefElement
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getMarkupElementAccess().getFigureRefElementParserRuleCall_4());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FigureRefElement_4=ruleFigureRefElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_FigureRefElement_4;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 6 :
                    // InternalMarkup.g:288:2: this_FootnoteElement_5= ruleFootnoteElement
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getMarkupElementAccess().getFootnoteElementParserRuleCall_5());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FootnoteElement_5=ruleFootnoteElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_FootnoteElement_5;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 7 :
                    // InternalMarkup.g:301:2: this_HeadingElement_6= ruleHeadingElement
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getMarkupElementAccess().getHeadingElementParserRuleCall_6());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_HeadingElement_6=ruleHeadingElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_HeadingElement_6;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 8 :
                    // InternalMarkup.g:314:2: this_NullElement_7= ruleNullElement
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getMarkupElementAccess().getNullElementParserRuleCall_7());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NullElement_7=ruleNullElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_NullElement_7;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 9 :
                    // InternalMarkup.g:327:2: this_OCLCodeElement_8= ruleOCLCodeElement
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getMarkupElementAccess().getOCLCodeElementParserRuleCall_8());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_OCLCodeElement_8=ruleOCLCodeElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_OCLCodeElement_8;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 10 :
                    // InternalMarkup.g:340:2: this_OCLEvalElement_9= ruleOCLEvalElement
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getMarkupElementAccess().getOCLEvalElementParserRuleCall_9());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_OCLEvalElement_9=ruleOCLEvalElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_OCLEvalElement_9;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 11 :
                    // InternalMarkup.g:353:2: this_OCLTextElement_10= ruleOCLTextElement
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getMarkupElementAccess().getOCLTextElementParserRuleCall_10());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_OCLTextElement_10=ruleOCLTextElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_OCLTextElement_10;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 12 :
                    // InternalMarkup.g:366:2: this_TextElement_11= ruleTextElement
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getMarkupElementAccess().getTextElementParserRuleCall_11());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TextElement_11=ruleTextElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_TextElement_11;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMarkupElement"


    // $ANTLR start "entryRuleBulletElement"
    // InternalMarkup.g:385:1: entryRuleBulletElement returns [EObject current=null] : iv_ruleBulletElement= ruleBulletElement EOF ;
    public final EObject entryRuleBulletElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBulletElement = null;


        try {
            // InternalMarkup.g:386:2: (iv_ruleBulletElement= ruleBulletElement EOF )
            // InternalMarkup.g:387:2: iv_ruleBulletElement= ruleBulletElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBulletElementRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBulletElement=ruleBulletElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBulletElement;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBulletElement"


    // $ANTLR start "ruleBulletElement"
    // InternalMarkup.g:394:1: ruleBulletElement returns [EObject current=null] : ( () otherlv_1= 'bullet' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' ) ;
    public final EObject ruleBulletElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_level_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_elements_5_0 = null;


         enterRule();

        try {
            // InternalMarkup.g:397:28: ( ( () otherlv_1= 'bullet' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' ) )
            // InternalMarkup.g:398:1: ( () otherlv_1= 'bullet' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' )
            {
            // InternalMarkup.g:398:1: ( () otherlv_1= 'bullet' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' )
            // InternalMarkup.g:398:2: () otherlv_1= 'bullet' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']'
            {
            // InternalMarkup.g:398:2: ()
            // InternalMarkup.g:399:2:
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBulletElementAccess().getBulletElementAction_0(),
                          current);

            }

            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBulletElementAccess().getBulletKeyword_1());

            }
            // InternalMarkup.g:411:1: (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==26) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMarkup.g:411:3: otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) )
                    {
                    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getBulletElementAccess().getColonKeyword_2_0());

                    }
                    // InternalMarkup.g:415:1: ( (lv_level_3_0= RULE_INT ) )
                    // InternalMarkup.g:416:1: (lv_level_3_0= RULE_INT )
                    {
                    // InternalMarkup.g:416:1: (lv_level_3_0= RULE_INT )
                    // InternalMarkup.g:417:3: lv_level_3_0= RULE_INT
                    {
                    lv_level_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_level_3_0, grammarAccess.getBulletElementAccess().getLevelINTTerminalRuleCall_2_1_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBulletElementRule());
                      	        }
                             		setWithLastConsumed(
                             			current,
                             			"level",
                              		lv_level_3_0,
                              		"org.eclipse.ocl.xtext.markup.Markup.INT");

                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,27,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getBulletElementAccess().getLeftSquareBracketKeyword_3());

            }
            // InternalMarkup.g:437:1: ( (lv_elements_5_0= ruleMarkupElement ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=RULE_INT && LA5_0<=RULE_ID)||(LA5_0>=RULE_NL && LA5_0<=RULE_WS)||(LA5_0>=16 && LA5_0<=27)||(LA5_0>=29 && LA5_0<=30)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMarkup.g:438:1: (lv_elements_5_0= ruleMarkupElement )
            	    {
            	    // InternalMarkup.g:438:1: (lv_elements_5_0= ruleMarkupElement )
            	    // InternalMarkup.g:439:3: lv_elements_5_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getBulletElementAccess().getElementsMarkupElementParserRuleCall_4_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_elements_5_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBulletElementRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"elements",
            	              		lv_elements_5_0,
            	              		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getBulletElementAccess().getRightSquareBracketKeyword_5());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBulletElement"


    // $ANTLR start "entryRuleFontElement"
    // InternalMarkup.g:467:1: entryRuleFontElement returns [EObject current=null] : iv_ruleFontElement= ruleFontElement EOF ;
    public final EObject entryRuleFontElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFontElement = null;


        try {
            // InternalMarkup.g:468:2: (iv_ruleFontElement= ruleFontElement EOF )
            // InternalMarkup.g:469:2: iv_ruleFontElement= ruleFontElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFontElementRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFontElement=ruleFontElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFontElement;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFontElement"


    // $ANTLR start "ruleFontElement"
    // InternalMarkup.g:476:1: ruleFontElement returns [EObject current=null] : ( ( ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) ) ) otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' ) ;
    public final EObject ruleFontElement() throws RecognitionException {
        EObject current = null;

        Token lv_font_0_1=null;
        Token lv_font_0_2=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;


         enterRule();

        try {
            // InternalMarkup.g:479:28: ( ( ( ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) ) ) otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' ) )
            // InternalMarkup.g:480:1: ( ( ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) ) ) otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' )
            {
            // InternalMarkup.g:480:1: ( ( ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) ) ) otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' )
            // InternalMarkup.g:480:2: ( ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) ) ) otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']'
            {
            // InternalMarkup.g:480:2: ( ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) ) )
            // InternalMarkup.g:481:1: ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) )
            {
            // InternalMarkup.g:481:1: ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) )
            // InternalMarkup.g:482:1: (lv_font_0_1= 'b' | lv_font_0_2= 'e' )
            {
            // InternalMarkup.g:482:1: (lv_font_0_1= 'b' | lv_font_0_2= 'e' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalMarkup.g:483:3: lv_font_0_1= 'b'
                    {
                    lv_font_0_1=(Token)match(input,16,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_font_0_1, grammarAccess.getFontElementAccess().getFontBKeyword_0_0_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFontElementRule());
                      	        }
                             		setWithLastConsumed(current, "font", lv_font_0_1, null);

                    }

                    }
                    break;
                case 2 :
                    // InternalMarkup.g:495:8: lv_font_0_2= 'e'
                    {
                    lv_font_0_2=(Token)match(input,17,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_font_0_2, grammarAccess.getFontElementAccess().getFontEKeyword_0_0_1());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFontElementRule());
                      	        }
                             		setWithLastConsumed(current, "font", lv_font_0_2, null);

                    }

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFontElementAccess().getLeftSquareBracketKeyword_1());

            }
            // InternalMarkup.g:514:1: ( (lv_elements_2_0= ruleMarkupElement ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=RULE_INT && LA7_0<=RULE_ID)||(LA7_0>=RULE_NL && LA7_0<=RULE_WS)||(LA7_0>=16 && LA7_0<=27)||(LA7_0>=29 && LA7_0<=30)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMarkup.g:515:1: (lv_elements_2_0= ruleMarkupElement )
            	    {
            	    // InternalMarkup.g:515:1: (lv_elements_2_0= ruleMarkupElement )
            	    // InternalMarkup.g:516:3: lv_elements_2_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getFontElementAccess().getElementsMarkupElementParserRuleCall_2_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_elements_2_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFontElementRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"elements",
            	              		lv_elements_2_0,
            	              		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFontElementAccess().getRightSquareBracketKeyword_3());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFontElement"


    // $ANTLR start "entryRuleFigureElement"
    // InternalMarkup.g:544:1: entryRuleFigureElement returns [EObject current=null] : iv_ruleFigureElement= ruleFigureElement EOF ;
    public final EObject entryRuleFigureElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFigureElement = null;


        try {
            // InternalMarkup.g:545:2: (iv_ruleFigureElement= ruleFigureElement EOF )
            // InternalMarkup.g:546:2: iv_ruleFigureElement= ruleFigureElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFigureElementRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFigureElement=ruleFigureElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFigureElement;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFigureElement"


    // $ANTLR start "ruleFigureElement"
    // InternalMarkup.g:553:1: ruleFigureElement returns [EObject current=null] : (otherlv_0= 'figure' (otherlv_1= '#' ( (lv_def_2_0= RULE_ID ) ) )? otherlv_3= '[' ( (lv_src_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_alt_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )? )? otherlv_11= ']' ) ;
    public final EObject ruleFigureElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_def_2_0=null;
        Token otherlv_3=null;
        Token lv_src_4_0=null;
        Token otherlv_5=null;
        Token lv_alt_6_0=null;
        Token otherlv_7=null;
        Token lv_requiredWidth_8_0=null;
        Token otherlv_9=null;
        Token lv_requiredHeight_10_0=null;
        Token otherlv_11=null;

         enterRule();

        try {
            // InternalMarkup.g:556:28: ( (otherlv_0= 'figure' (otherlv_1= '#' ( (lv_def_2_0= RULE_ID ) ) )? otherlv_3= '[' ( (lv_src_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_alt_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )? )? otherlv_11= ']' ) )
            // InternalMarkup.g:557:1: (otherlv_0= 'figure' (otherlv_1= '#' ( (lv_def_2_0= RULE_ID ) ) )? otherlv_3= '[' ( (lv_src_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_alt_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )? )? otherlv_11= ']' )
            {
            // InternalMarkup.g:557:1: (otherlv_0= 'figure' (otherlv_1= '#' ( (lv_def_2_0= RULE_ID ) ) )? otherlv_3= '[' ( (lv_src_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_alt_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )? )? otherlv_11= ']' )
            // InternalMarkup.g:557:3: otherlv_0= 'figure' (otherlv_1= '#' ( (lv_def_2_0= RULE_ID ) ) )? otherlv_3= '[' ( (lv_src_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_alt_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )? )? otherlv_11= ']'
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFigureElementAccess().getFigureKeyword_0());

            }
            // InternalMarkup.g:561:1: (otherlv_1= '#' ( (lv_def_2_0= RULE_ID ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMarkup.g:561:3: otherlv_1= '#' ( (lv_def_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getFigureElementAccess().getNumberSignKeyword_1_0());

                    }
                    // InternalMarkup.g:565:1: ( (lv_def_2_0= RULE_ID ) )
                    // InternalMarkup.g:566:1: (lv_def_2_0= RULE_ID )
                    {
                    // InternalMarkup.g:566:1: (lv_def_2_0= RULE_ID )
                    // InternalMarkup.g:567:3: lv_def_2_0= RULE_ID
                    {
                    lv_def_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_def_2_0, grammarAccess.getFigureElementAccess().getDefIDTerminalRuleCall_1_1_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFigureElementRule());
                      	        }
                             		setWithLastConsumed(
                             			current,
                             			"def",
                              		lv_def_2_0,
                              		"org.eclipse.ocl.xtext.markup.Markup.ID");

                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,27,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFigureElementAccess().getLeftSquareBracketKeyword_2());

            }
            // InternalMarkup.g:587:1: ( (lv_src_4_0= RULE_STRING ) )
            // InternalMarkup.g:588:1: (lv_src_4_0= RULE_STRING )
            {
            // InternalMarkup.g:588:1: (lv_src_4_0= RULE_STRING )
            // InternalMarkup.g:589:3: lv_src_4_0= RULE_STRING
            {
            lv_src_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_src_4_0, grammarAccess.getFigureElementAccess().getSrcSTRINGTerminalRuleCall_3_0());

            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFigureElementRule());
              	        }
                     		setWithLastConsumed(
                     			current,
                     			"src",
                      		lv_src_4_0,
                      		"org.eclipse.ocl.xtext.markup.Markup.STRING");

            }

            }


            }

            // InternalMarkup.g:605:2: (otherlv_5= ',' ( (lv_alt_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )? )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==30) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMarkup.g:605:4: otherlv_5= ',' ( (lv_alt_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )?
                    {
                    otherlv_5=(Token)match(input,30,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getFigureElementAccess().getCommaKeyword_4_0());

                    }
                    // InternalMarkup.g:609:1: ( (lv_alt_6_0= RULE_STRING ) )
                    // InternalMarkup.g:610:1: (lv_alt_6_0= RULE_STRING )
                    {
                    // InternalMarkup.g:610:1: (lv_alt_6_0= RULE_STRING )
                    // InternalMarkup.g:611:3: lv_alt_6_0= RULE_STRING
                    {
                    lv_alt_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_alt_6_0, grammarAccess.getFigureElementAccess().getAltSTRINGTerminalRuleCall_4_1_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFigureElementRule());
                      	        }
                             		setWithLastConsumed(
                             			current,
                             			"alt",
                              		lv_alt_6_0,
                              		"org.eclipse.ocl.xtext.markup.Markup.STRING");

                    }

                    }


                    }

                    // InternalMarkup.g:627:2: (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==30) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalMarkup.g:627:4: otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )?
                            {
                            otherlv_7=(Token)match(input,30,FollowSets000.FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getFigureElementAccess().getCommaKeyword_4_2_0());

                            }
                            // InternalMarkup.g:631:1: ( (lv_requiredWidth_8_0= RULE_INT ) )
                            // InternalMarkup.g:632:1: (lv_requiredWidth_8_0= RULE_INT )
                            {
                            // InternalMarkup.g:632:1: (lv_requiredWidth_8_0= RULE_INT )
                            // InternalMarkup.g:633:3: lv_requiredWidth_8_0= RULE_INT
                            {
                            lv_requiredWidth_8_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_11); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_requiredWidth_8_0, grammarAccess.getFigureElementAccess().getRequiredWidthINTTerminalRuleCall_4_2_1_0());

                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getFigureElementRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current,
                                     			"requiredWidth",
                                      		lv_requiredWidth_8_0,
                                      		"org.eclipse.ocl.xtext.markup.Markup.INT");

                            }

                            }


                            }

                            // InternalMarkup.g:649:2: (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( (LA9_0==30) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // InternalMarkup.g:649:4: otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) )
                                    {
                                    otherlv_9=(Token)match(input,30,FollowSets000.FOLLOW_5); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_9, grammarAccess.getFigureElementAccess().getCommaKeyword_4_2_2_0());

                                    }
                                    // InternalMarkup.g:653:1: ( (lv_requiredHeight_10_0= RULE_INT ) )
                                    // InternalMarkup.g:654:1: (lv_requiredHeight_10_0= RULE_INT )
                                    {
                                    // InternalMarkup.g:654:1: (lv_requiredHeight_10_0= RULE_INT )
                                    // InternalMarkup.g:655:3: lv_requiredHeight_10_0= RULE_INT
                                    {
                                    lv_requiredHeight_10_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_12); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_requiredHeight_10_0, grammarAccess.getFigureElementAccess().getRequiredHeightINTTerminalRuleCall_4_2_2_1_0());

                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getFigureElementRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current,
                                             			"requiredHeight",
                                              		lv_requiredHeight_10_0,
                                              		"org.eclipse.ocl.xtext.markup.Markup.INT");

                                    }

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getFigureElementAccess().getRightSquareBracketKeyword_5());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFigureElement"


    // $ANTLR start "entryRuleFigureRefElement"
    // InternalMarkup.g:683:1: entryRuleFigureRefElement returns [EObject current=null] : iv_ruleFigureRefElement= ruleFigureRefElement EOF ;
    public final EObject entryRuleFigureRefElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFigureRefElement = null;


        try {
            // InternalMarkup.g:684:2: (iv_ruleFigureRefElement= ruleFigureRefElement EOF )
            // InternalMarkup.g:685:2: iv_ruleFigureRefElement= ruleFigureRefElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFigureRefElementRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFigureRefElement=ruleFigureRefElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFigureRefElement;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFigureRefElement"


    // $ANTLR start "ruleFigureRefElement"
    // InternalMarkup.g:692:1: ruleFigureRefElement returns [EObject current=null] : (otherlv_0= 'figureRef' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' ) ;
    public final EObject ruleFigureRefElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule();

        try {
            // InternalMarkup.g:695:28: ( (otherlv_0= 'figureRef' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' ) )
            // InternalMarkup.g:696:1: (otherlv_0= 'figureRef' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' )
            {
            // InternalMarkup.g:696:1: (otherlv_0= 'figureRef' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' )
            // InternalMarkup.g:696:3: otherlv_0= 'figureRef' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFigureRefElementAccess().getFigureRefKeyword_0());

            }
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFigureRefElementAccess().getLeftSquareBracketKeyword_1());

            }
            // InternalMarkup.g:704:1: ( (otherlv_2= RULE_ID ) )
            // InternalMarkup.g:705:1: (otherlv_2= RULE_ID )
            {
            // InternalMarkup.g:705:1: (otherlv_2= RULE_ID )
            // InternalMarkup.g:706:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		  /* */

            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFigureRefElementRule());
              	        }

            }
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getFigureRefElementAccess().getRefFigureElementCrossReference_2_0());

            }

            }


            }

            otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFigureRefElementAccess().getRightSquareBracketKeyword_3());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFigureRefElement"


    // $ANTLR start "entryRuleFootnoteElement"
    // InternalMarkup.g:732:1: entryRuleFootnoteElement returns [EObject current=null] : iv_ruleFootnoteElement= ruleFootnoteElement EOF ;
    public final EObject entryRuleFootnoteElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFootnoteElement = null;


        try {
            // InternalMarkup.g:733:2: (iv_ruleFootnoteElement= ruleFootnoteElement EOF )
            // InternalMarkup.g:734:2: iv_ruleFootnoteElement= ruleFootnoteElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFootnoteElementRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFootnoteElement=ruleFootnoteElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFootnoteElement;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFootnoteElement"


    // $ANTLR start "ruleFootnoteElement"
    // InternalMarkup.g:741:1: ruleFootnoteElement returns [EObject current=null] : ( () otherlv_1= 'footnote' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) ;
    public final EObject ruleFootnoteElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;


         enterRule();

        try {
            // InternalMarkup.g:744:28: ( ( () otherlv_1= 'footnote' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) )
            // InternalMarkup.g:745:1: ( () otherlv_1= 'footnote' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            {
            // InternalMarkup.g:745:1: ( () otherlv_1= 'footnote' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            // InternalMarkup.g:745:2: () otherlv_1= 'footnote' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']'
            {
            // InternalMarkup.g:745:2: ()
            // InternalMarkup.g:746:2:
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getFootnoteElementAccess().getFootnoteElementAction_0(),
                          current);

            }

            }

            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFootnoteElementAccess().getFootnoteKeyword_1());

            }
            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFootnoteElementAccess().getLeftSquareBracketKeyword_2());

            }
            // InternalMarkup.g:762:1: ( (lv_elements_3_0= ruleMarkupElement ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=RULE_INT && LA12_0<=RULE_ID)||(LA12_0>=RULE_NL && LA12_0<=RULE_WS)||(LA12_0>=16 && LA12_0<=27)||(LA12_0>=29 && LA12_0<=30)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMarkup.g:763:1: (lv_elements_3_0= ruleMarkupElement )
            	    {
            	    // InternalMarkup.g:763:1: (lv_elements_3_0= ruleMarkupElement )
            	    // InternalMarkup.g:764:3: lv_elements_3_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getFootnoteElementAccess().getElementsMarkupElementParserRuleCall_3_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_elements_3_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFootnoteElementRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"elements",
            	              		lv_elements_3_0,
            	              		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_4=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getFootnoteElementAccess().getRightSquareBracketKeyword_4());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFootnoteElement"


    // $ANTLR start "entryRuleHeadingElement"
    // InternalMarkup.g:792:1: entryRuleHeadingElement returns [EObject current=null] : iv_ruleHeadingElement= ruleHeadingElement EOF ;
    public final EObject entryRuleHeadingElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeadingElement = null;


        try {
            // InternalMarkup.g:793:2: (iv_ruleHeadingElement= ruleHeadingElement EOF )
            // InternalMarkup.g:794:2: iv_ruleHeadingElement= ruleHeadingElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHeadingElementRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleHeadingElement=ruleHeadingElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHeadingElement;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHeadingElement"


    // $ANTLR start "ruleHeadingElement"
    // InternalMarkup.g:801:1: ruleHeadingElement returns [EObject current=null] : ( () otherlv_1= 'heading' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' ) ;
    public final EObject ruleHeadingElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_level_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_elements_5_0 = null;


         enterRule();

        try {
            // InternalMarkup.g:804:28: ( ( () otherlv_1= 'heading' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' ) )
            // InternalMarkup.g:805:1: ( () otherlv_1= 'heading' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' )
            {
            // InternalMarkup.g:805:1: ( () otherlv_1= 'heading' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' )
            // InternalMarkup.g:805:2: () otherlv_1= 'heading' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']'
            {
            // InternalMarkup.g:805:2: ()
            // InternalMarkup.g:806:2:
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getHeadingElementAccess().getHeadingElementAction_0(),
                          current);

            }

            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getHeadingElementAccess().getHeadingKeyword_1());

            }
            // InternalMarkup.g:818:1: (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMarkup.g:818:3: otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) )
                    {
                    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getHeadingElementAccess().getColonKeyword_2_0());

                    }
                    // InternalMarkup.g:822:1: ( (lv_level_3_0= RULE_INT ) )
                    // InternalMarkup.g:823:1: (lv_level_3_0= RULE_INT )
                    {
                    // InternalMarkup.g:823:1: (lv_level_3_0= RULE_INT )
                    // InternalMarkup.g:824:3: lv_level_3_0= RULE_INT
                    {
                    lv_level_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_level_3_0, grammarAccess.getHeadingElementAccess().getLevelINTTerminalRuleCall_2_1_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getHeadingElementRule());
                      	        }
                             		setWithLastConsumed(
                             			current,
                             			"level",
                              		lv_level_3_0,
                              		"org.eclipse.ocl.xtext.markup.Markup.INT");

                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,27,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getHeadingElementAccess().getLeftSquareBracketKeyword_3());

            }
            // InternalMarkup.g:844:1: ( (lv_elements_5_0= ruleMarkupElement ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=RULE_INT && LA14_0<=RULE_ID)||(LA14_0>=RULE_NL && LA14_0<=RULE_WS)||(LA14_0>=16 && LA14_0<=27)||(LA14_0>=29 && LA14_0<=30)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalMarkup.g:845:1: (lv_elements_5_0= ruleMarkupElement )
            	    {
            	    // InternalMarkup.g:845:1: (lv_elements_5_0= ruleMarkupElement )
            	    // InternalMarkup.g:846:3: lv_elements_5_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getHeadingElementAccess().getElementsMarkupElementParserRuleCall_4_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_elements_5_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getHeadingElementRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"elements",
            	              		lv_elements_5_0,
            	              		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getHeadingElementAccess().getRightSquareBracketKeyword_5());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHeadingElement"


    // $ANTLR start "entryRuleNewLineElement"
    // InternalMarkup.g:874:1: entryRuleNewLineElement returns [EObject current=null] : iv_ruleNewLineElement= ruleNewLineElement EOF ;
    public final EObject entryRuleNewLineElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewLineElement = null;


        try {
            // InternalMarkup.g:875:2: (iv_ruleNewLineElement= ruleNewLineElement EOF )
            // InternalMarkup.g:876:2: iv_ruleNewLineElement= ruleNewLineElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNewLineElementRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNewLineElement=ruleNewLineElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNewLineElement;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNewLineElement"


    // $ANTLR start "ruleNewLineElement"
    // InternalMarkup.g:883:1: ruleNewLineElement returns [EObject current=null] : ( (lv_text_0_0= RULE_NL ) ) ;
    public final EObject ruleNewLineElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;

         enterRule();

        try {
            // InternalMarkup.g:886:28: ( ( (lv_text_0_0= RULE_NL ) ) )
            // InternalMarkup.g:887:1: ( (lv_text_0_0= RULE_NL ) )
            {
            // InternalMarkup.g:887:1: ( (lv_text_0_0= RULE_NL ) )
            // InternalMarkup.g:888:1: (lv_text_0_0= RULE_NL )
            {
            // InternalMarkup.g:888:1: (lv_text_0_0= RULE_NL )
            // InternalMarkup.g:889:3: lv_text_0_0= RULE_NL
            {
            lv_text_0_0=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_text_0_0, grammarAccess.getNewLineElementAccess().getTextNLTerminalRuleCall_0());

            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNewLineElementRule());
              	        }
                     		setWithLastConsumed(
                     			current,
                     			"text",
                      		lv_text_0_0,
                      		"org.eclipse.ocl.xtext.markup.Markup.NL");

            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNewLineElement"


    // $ANTLR start "entryRuleNullElement"
    // InternalMarkup.g:913:1: entryRuleNullElement returns [EObject current=null] : iv_ruleNullElement= ruleNullElement EOF ;
    public final EObject entryRuleNullElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullElement = null;


        try {
            // InternalMarkup.g:914:2: (iv_ruleNullElement= ruleNullElement EOF )
            // InternalMarkup.g:915:2: iv_ruleNullElement= ruleNullElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullElementRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNullElement=ruleNullElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullElement;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNullElement"


    // $ANTLR start "ruleNullElement"
    // InternalMarkup.g:922:1: ruleNullElement returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' ) ;
    public final EObject ruleNullElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;


         enterRule();

        try {
            // InternalMarkup.g:925:28: ( ( () otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' ) )
            // InternalMarkup.g:926:1: ( () otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' )
            {
            // InternalMarkup.g:926:1: ( () otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' )
            // InternalMarkup.g:926:2: () otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']'
            {
            // InternalMarkup.g:926:2: ()
            // InternalMarkup.g:927:2:
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getNullElementAccess().getNullElementAction_0(),
                          current);

            }

            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getNullElementAccess().getLeftSquareBracketKeyword_1());

            }
            // InternalMarkup.g:939:1: ( (lv_elements_2_0= ruleMarkupElement ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_INT && LA15_0<=RULE_ID)||(LA15_0>=RULE_NL && LA15_0<=RULE_WS)||(LA15_0>=16 && LA15_0<=27)||(LA15_0>=29 && LA15_0<=30)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalMarkup.g:940:1: (lv_elements_2_0= ruleMarkupElement )
            	    {
            	    // InternalMarkup.g:940:1: (lv_elements_2_0= ruleMarkupElement )
            	    // InternalMarkup.g:941:3: lv_elements_2_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getNullElementAccess().getElementsMarkupElementParserRuleCall_2_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_elements_2_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNullElementRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"elements",
            	              		lv_elements_2_0,
            	              		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getNullElementAccess().getRightSquareBracketKeyword_3());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullElement"


    // $ANTLR start "entryRuleOCLCodeElement"
    // InternalMarkup.g:969:1: entryRuleOCLCodeElement returns [EObject current=null] : iv_ruleOCLCodeElement= ruleOCLCodeElement EOF ;
    public final EObject entryRuleOCLCodeElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOCLCodeElement = null;


        try {
            // InternalMarkup.g:970:2: (iv_ruleOCLCodeElement= ruleOCLCodeElement EOF )
            // InternalMarkup.g:971:2: iv_ruleOCLCodeElement= ruleOCLCodeElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOCLCodeElementRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOCLCodeElement=ruleOCLCodeElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOCLCodeElement;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOCLCodeElement"


    // $ANTLR start "ruleOCLCodeElement"
    // InternalMarkup.g:978:1: ruleOCLCodeElement returns [EObject current=null] : ( () otherlv_1= 'oclCode' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) ;
    public final EObject ruleOCLCodeElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;


         enterRule();

        try {
            // InternalMarkup.g:981:28: ( ( () otherlv_1= 'oclCode' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) )
            // InternalMarkup.g:982:1: ( () otherlv_1= 'oclCode' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            {
            // InternalMarkup.g:982:1: ( () otherlv_1= 'oclCode' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            // InternalMarkup.g:982:2: () otherlv_1= 'oclCode' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']'
            {
            // InternalMarkup.g:982:2: ()
            // InternalMarkup.g:983:2:
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOCLCodeElementAccess().getOCLCodeElementAction_0(),
                          current);

            }

            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOCLCodeElementAccess().getOclCodeKeyword_1());

            }
            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOCLCodeElementAccess().getLeftSquareBracketKeyword_2());

            }
            // InternalMarkup.g:999:1: ( (lv_elements_3_0= ruleMarkupElement ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=RULE_INT && LA16_0<=RULE_ID)||(LA16_0>=RULE_NL && LA16_0<=RULE_WS)||(LA16_0>=16 && LA16_0<=27)||(LA16_0>=29 && LA16_0<=30)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalMarkup.g:1000:1: (lv_elements_3_0= ruleMarkupElement )
            	    {
            	    // InternalMarkup.g:1000:1: (lv_elements_3_0= ruleMarkupElement )
            	    // InternalMarkup.g:1001:3: lv_elements_3_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getOCLCodeElementAccess().getElementsMarkupElementParserRuleCall_3_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_elements_3_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOCLCodeElementRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"elements",
            	              		lv_elements_3_0,
            	              		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_4=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOCLCodeElementAccess().getRightSquareBracketKeyword_4());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOCLCodeElement"


    // $ANTLR start "entryRuleOCLEvalElement"
    // InternalMarkup.g:1029:1: entryRuleOCLEvalElement returns [EObject current=null] : iv_ruleOCLEvalElement= ruleOCLEvalElement EOF ;
    public final EObject entryRuleOCLEvalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOCLEvalElement = null;


        try {
            // InternalMarkup.g:1030:2: (iv_ruleOCLEvalElement= ruleOCLEvalElement EOF )
            // InternalMarkup.g:1031:2: iv_ruleOCLEvalElement= ruleOCLEvalElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOCLEvalElementRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOCLEvalElement=ruleOCLEvalElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOCLEvalElement;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOCLEvalElement"


    // $ANTLR start "ruleOCLEvalElement"
    // InternalMarkup.g:1038:1: ruleOCLEvalElement returns [EObject current=null] : ( () otherlv_1= 'oclEval' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) ;
    public final EObject ruleOCLEvalElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;


         enterRule();

        try {
            // InternalMarkup.g:1041:28: ( ( () otherlv_1= 'oclEval' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) )
            // InternalMarkup.g:1042:1: ( () otherlv_1= 'oclEval' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            {
            // InternalMarkup.g:1042:1: ( () otherlv_1= 'oclEval' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            // InternalMarkup.g:1042:2: () otherlv_1= 'oclEval' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']'
            {
            // InternalMarkup.g:1042:2: ()
            // InternalMarkup.g:1043:2:
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOCLEvalElementAccess().getOCLEvalElementAction_0(),
                          current);

            }

            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOCLEvalElementAccess().getOclEvalKeyword_1());

            }
            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOCLEvalElementAccess().getLeftSquareBracketKeyword_2());

            }
            // InternalMarkup.g:1059:1: ( (lv_elements_3_0= ruleMarkupElement ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=RULE_INT && LA17_0<=RULE_ID)||(LA17_0>=RULE_NL && LA17_0<=RULE_WS)||(LA17_0>=16 && LA17_0<=27)||(LA17_0>=29 && LA17_0<=30)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalMarkup.g:1060:1: (lv_elements_3_0= ruleMarkupElement )
            	    {
            	    // InternalMarkup.g:1060:1: (lv_elements_3_0= ruleMarkupElement )
            	    // InternalMarkup.g:1061:3: lv_elements_3_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getOCLEvalElementAccess().getElementsMarkupElementParserRuleCall_3_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_elements_3_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOCLEvalElementRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"elements",
            	              		lv_elements_3_0,
            	              		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_4=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOCLEvalElementAccess().getRightSquareBracketKeyword_4());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOCLEvalElement"


    // $ANTLR start "entryRuleOCLTextElement"
    // InternalMarkup.g:1089:1: entryRuleOCLTextElement returns [EObject current=null] : iv_ruleOCLTextElement= ruleOCLTextElement EOF ;
    public final EObject entryRuleOCLTextElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOCLTextElement = null;


        try {
            // InternalMarkup.g:1090:2: (iv_ruleOCLTextElement= ruleOCLTextElement EOF )
            // InternalMarkup.g:1091:2: iv_ruleOCLTextElement= ruleOCLTextElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOCLTextElementRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOCLTextElement=ruleOCLTextElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOCLTextElement;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOCLTextElement"


    // $ANTLR start "ruleOCLTextElement"
    // InternalMarkup.g:1098:1: ruleOCLTextElement returns [EObject current=null] : ( () otherlv_1= 'oclText' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) ;
    public final EObject ruleOCLTextElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;


         enterRule();

        try {
            // InternalMarkup.g:1101:28: ( ( () otherlv_1= 'oclText' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) )
            // InternalMarkup.g:1102:1: ( () otherlv_1= 'oclText' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            {
            // InternalMarkup.g:1102:1: ( () otherlv_1= 'oclText' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            // InternalMarkup.g:1102:2: () otherlv_1= 'oclText' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']'
            {
            // InternalMarkup.g:1102:2: ()
            // InternalMarkup.g:1103:2:
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOCLTextElementAccess().getOCLTextElementAction_0(),
                          current);

            }

            }

            otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOCLTextElementAccess().getOclTextKeyword_1());

            }
            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOCLTextElementAccess().getLeftSquareBracketKeyword_2());

            }
            // InternalMarkup.g:1119:1: ( (lv_elements_3_0= ruleMarkupElement ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=RULE_INT && LA18_0<=RULE_ID)||(LA18_0>=RULE_NL && LA18_0<=RULE_WS)||(LA18_0>=16 && LA18_0<=27)||(LA18_0>=29 && LA18_0<=30)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalMarkup.g:1120:1: (lv_elements_3_0= ruleMarkupElement )
            	    {
            	    // InternalMarkup.g:1120:1: (lv_elements_3_0= ruleMarkupElement )
            	    // InternalMarkup.g:1121:3: lv_elements_3_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getOCLTextElementAccess().getElementsMarkupElementParserRuleCall_3_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_elements_3_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOCLTextElementRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"elements",
            	              		lv_elements_3_0,
            	              		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_4=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOCLTextElementAccess().getRightSquareBracketKeyword_4());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOCLTextElement"


    // $ANTLR start "entryRuleTextElement"
    // InternalMarkup.g:1149:1: entryRuleTextElement returns [EObject current=null] : iv_ruleTextElement= ruleTextElement EOF ;
    public final EObject entryRuleTextElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextElement = null;


        try {
            // InternalMarkup.g:1150:2: (iv_ruleTextElement= ruleTextElement EOF )
            // InternalMarkup.g:1151:2: iv_ruleTextElement= ruleTextElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTextElementRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTextElement=ruleTextElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTextElement;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextElement"


    // $ANTLR start "ruleTextElement"
    // InternalMarkup.g:1158:1: ruleTextElement returns [EObject current=null] : ( ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )+ | ( (lv_text_1_0= ruleMarkupKeyword ) ) ) ;
    public final EObject ruleTextElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_1=null;
        Token lv_text_0_2=null;
        Token lv_text_0_3=null;
        Token lv_text_0_4=null;
        Token lv_text_0_5=null;
        Token lv_text_0_6=null;
        Token lv_text_0_7=null;
        AntlrDatatypeRuleToken lv_text_1_0 = null;


         enterRule();

        try {
            // InternalMarkup.g:1161:28: ( ( ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )+ | ( (lv_text_1_0= ruleMarkupKeyword ) ) ) )
            // InternalMarkup.g:1162:1: ( ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )+ | ( (lv_text_1_0= ruleMarkupKeyword ) ) )
            {
            // InternalMarkup.g:1162:1: ( ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )+ | ( (lv_text_1_0= ruleMarkupKeyword ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_INT && LA21_0<=RULE_ID)||(LA21_0>=RULE_WORD && LA21_0<=RULE_WS)||LA21_0==26||(LA21_0>=29 && LA21_0<=30)) ) {
                alt21=1;
            }
            else if ( ((LA21_0>=16 && LA21_0<=25)) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalMarkup.g:1162:2: ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )+
                    {
                    // InternalMarkup.g:1162:2: ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        alt20 = dfa20.predict(input);
                        switch (alt20) {
                    	case 1 :
                    	    // InternalMarkup.g:1163:1: ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) )
                    	    {
                    	    // InternalMarkup.g:1163:1: ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) )
                    	    // InternalMarkup.g:1164:1: (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' )
                    	    {
                    	    // InternalMarkup.g:1164:1: (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' )
                    	    int alt19=7;
                    	    switch ( input.LA(1) ) {
                    	    case RULE_ID:
                    	        {
                    	        alt19=1;
                    	        }
                    	        break;
                    	    case RULE_WORD:
                    	        {
                    	        alt19=2;
                    	        }
                    	        break;
                    	    case RULE_INT:
                    	        {
                    	        alt19=3;
                    	        }
                    	        break;
                    	    case RULE_WS:
                    	        {
                    	        alt19=4;
                    	        }
                    	        break;
                    	    case 26:
                    	        {
                    	        alt19=5;
                    	        }
                    	        break;
                    	    case 29:
                    	        {
                    	        alt19=6;
                    	        }
                    	        break;
                    	    case 30:
                    	        {
                    	        alt19=7;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 19, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt19) {
                    	        case 1 :
                    	            // InternalMarkup.g:1165:3: lv_text_0_1= RULE_ID
                    	            {
                    	            lv_text_0_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_text_0_1, grammarAccess.getTextElementAccess().getTextIDTerminalRuleCall_0_0_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getTextElementRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current,
                    	                     			"text",
                    	                      		lv_text_0_1,
                    	                      		"org.eclipse.ocl.xtext.markup.Markup.ID");

                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalMarkup.g:1180:8: lv_text_0_2= RULE_WORD
                    	            {
                    	            lv_text_0_2=(Token)match(input,RULE_WORD,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_text_0_2, grammarAccess.getTextElementAccess().getTextWORDTerminalRuleCall_0_0_1());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getTextElementRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current,
                    	                     			"text",
                    	                      		lv_text_0_2,
                    	                      		"org.eclipse.ocl.xtext.markup.Markup.WORD");

                    	            }

                    	            }
                    	            break;
                    	        case 3 :
                    	            // InternalMarkup.g:1195:8: lv_text_0_3= RULE_INT
                    	            {
                    	            lv_text_0_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_text_0_3, grammarAccess.getTextElementAccess().getTextINTTerminalRuleCall_0_0_2());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getTextElementRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current,
                    	                     			"text",
                    	                      		lv_text_0_3,
                    	                      		"org.eclipse.ocl.xtext.markup.Markup.INT");

                    	            }

                    	            }
                    	            break;
                    	        case 4 :
                    	            // InternalMarkup.g:1210:8: lv_text_0_4= RULE_WS
                    	            {
                    	            lv_text_0_4=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_text_0_4, grammarAccess.getTextElementAccess().getTextWSTerminalRuleCall_0_0_3());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getTextElementRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current,
                    	                     			"text",
                    	                      		lv_text_0_4,
                    	                      		"org.eclipse.ocl.xtext.markup.Markup.WS");

                    	            }

                    	            }
                    	            break;
                    	        case 5 :
                    	            // InternalMarkup.g:1225:8: lv_text_0_5= ':'
                    	            {
                    	            lv_text_0_5=(Token)match(input,26,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_text_0_5, grammarAccess.getTextElementAccess().getTextColonKeyword_0_0_4());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getTextElementRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "text", lv_text_0_5, null);

                    	            }

                    	            }
                    	            break;
                    	        case 6 :
                    	            // InternalMarkup.g:1237:8: lv_text_0_6= '#'
                    	            {
                    	            lv_text_0_6=(Token)match(input,29,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_text_0_6, grammarAccess.getTextElementAccess().getTextNumberSignKeyword_0_0_5());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getTextElementRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "text", lv_text_0_6, null);

                    	            }

                    	            }
                    	            break;
                    	        case 7 :
                    	            // InternalMarkup.g:1249:8: lv_text_0_7= ','
                    	            {
                    	            lv_text_0_7=(Token)match(input,30,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_text_0_7, grammarAccess.getTextElementAccess().getTextCommaKeyword_0_0_6());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getTextElementRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "text", lv_text_0_7, null);

                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalMarkup.g:1265:6: ( (lv_text_1_0= ruleMarkupKeyword ) )
                    {
                    // InternalMarkup.g:1265:6: ( (lv_text_1_0= ruleMarkupKeyword ) )
                    // InternalMarkup.g:1266:1: (lv_text_1_0= ruleMarkupKeyword )
                    {
                    // InternalMarkup.g:1266:1: (lv_text_1_0= ruleMarkupKeyword )
                    // InternalMarkup.g:1267:3: lv_text_1_0= ruleMarkupKeyword
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getTextElementAccess().getTextMarkupKeywordParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_text_1_0=ruleMarkupKeyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTextElementRule());
                      	        }
                             		add(
                             			current,
                             			"text",
                              		lv_text_1_0,
                              		"org.eclipse.ocl.xtext.markup.Markup.MarkupKeyword");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextElement"

    // $ANTLR start synpred11_InternalMarkup
    public final void synpred11_InternalMarkup_fragment() throws RecognitionException {
        EObject this_FontElement_0 = null;


        // InternalMarkup.g:223:2: (this_FontElement_0= ruleFontElement )
        // InternalMarkup.g:223:2: this_FontElement_0= ruleFontElement
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_FontElement_0=ruleFontElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalMarkup

    // $ANTLR start synpred13_InternalMarkup
    public final void synpred13_InternalMarkup_fragment() throws RecognitionException {
        EObject this_BulletElement_2 = null;


        // InternalMarkup.g:249:2: (this_BulletElement_2= ruleBulletElement )
        // InternalMarkup.g:249:2: this_BulletElement_2= ruleBulletElement
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_BulletElement_2=ruleBulletElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalMarkup

    // $ANTLR start synpred14_InternalMarkup
    public final void synpred14_InternalMarkup_fragment() throws RecognitionException {
        EObject this_FigureElement_3 = null;


        // InternalMarkup.g:262:2: (this_FigureElement_3= ruleFigureElement )
        // InternalMarkup.g:262:2: this_FigureElement_3= ruleFigureElement
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_FigureElement_3=ruleFigureElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalMarkup

    // $ANTLR start synpred15_InternalMarkup
    public final void synpred15_InternalMarkup_fragment() throws RecognitionException {
        EObject this_FigureRefElement_4 = null;


        // InternalMarkup.g:275:2: (this_FigureRefElement_4= ruleFigureRefElement )
        // InternalMarkup.g:275:2: this_FigureRefElement_4= ruleFigureRefElement
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_FigureRefElement_4=ruleFigureRefElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalMarkup

    // $ANTLR start synpred16_InternalMarkup
    public final void synpred16_InternalMarkup_fragment() throws RecognitionException {
        EObject this_FootnoteElement_5 = null;


        // InternalMarkup.g:288:2: (this_FootnoteElement_5= ruleFootnoteElement )
        // InternalMarkup.g:288:2: this_FootnoteElement_5= ruleFootnoteElement
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_FootnoteElement_5=ruleFootnoteElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalMarkup

    // $ANTLR start synpred17_InternalMarkup
    public final void synpred17_InternalMarkup_fragment() throws RecognitionException {
        EObject this_HeadingElement_6 = null;


        // InternalMarkup.g:301:2: (this_HeadingElement_6= ruleHeadingElement )
        // InternalMarkup.g:301:2: this_HeadingElement_6= ruleHeadingElement
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_HeadingElement_6=ruleHeadingElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_InternalMarkup

    // $ANTLR start synpred19_InternalMarkup
    public final void synpred19_InternalMarkup_fragment() throws RecognitionException {
        EObject this_OCLCodeElement_8 = null;


        // InternalMarkup.g:327:2: (this_OCLCodeElement_8= ruleOCLCodeElement )
        // InternalMarkup.g:327:2: this_OCLCodeElement_8= ruleOCLCodeElement
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_OCLCodeElement_8=ruleOCLCodeElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_InternalMarkup

    // $ANTLR start synpred20_InternalMarkup
    public final void synpred20_InternalMarkup_fragment() throws RecognitionException {
        EObject this_OCLEvalElement_9 = null;


        // InternalMarkup.g:340:2: (this_OCLEvalElement_9= ruleOCLEvalElement )
        // InternalMarkup.g:340:2: this_OCLEvalElement_9= ruleOCLEvalElement
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_OCLEvalElement_9=ruleOCLEvalElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_InternalMarkup

    // $ANTLR start synpred21_InternalMarkup
    public final void synpred21_InternalMarkup_fragment() throws RecognitionException {
        EObject this_OCLTextElement_10 = null;


        // InternalMarkup.g:353:2: (this_OCLTextElement_10= ruleOCLTextElement )
        // InternalMarkup.g:353:2: this_OCLTextElement_10= ruleOCLTextElement
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_OCLTextElement_10=ruleOCLTextElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalMarkup

    // $ANTLR start synpred43_InternalMarkup
    public final void synpred43_InternalMarkup_fragment() throws RecognitionException {
        Token lv_text_0_1=null;
        Token lv_text_0_2=null;
        Token lv_text_0_3=null;
        Token lv_text_0_4=null;
        Token lv_text_0_5=null;
        Token lv_text_0_6=null;
        Token lv_text_0_7=null;

        // InternalMarkup.g:1163:1: ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )
        // InternalMarkup.g:1163:1: ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) )
        {
        // InternalMarkup.g:1163:1: ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) )
        // InternalMarkup.g:1164:1: (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' )
        {
        // InternalMarkup.g:1164:1: (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' )
        int alt25=7;
        switch ( input.LA(1) ) {
        case RULE_ID:
            {
            alt25=1;
            }
            break;
        case RULE_WORD:
            {
            alt25=2;
            }
            break;
        case RULE_INT:
            {
            alt25=3;
            }
            break;
        case RULE_WS:
            {
            alt25=4;
            }
            break;
        case 26:
            {
            alt25=5;
            }
            break;
        case 29:
            {
            alt25=6;
            }
            break;
        case 30:
            {
            alt25=7;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 25, 0, input);

            throw nvae;
        }

        switch (alt25) {
            case 1 :
                // InternalMarkup.g:1165:3: lv_text_0_1= RULE_ID
                {
                lv_text_0_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalMarkup.g:1180:8: lv_text_0_2= RULE_WORD
                {
                lv_text_0_2=(Token)match(input,RULE_WORD,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 3 :
                // InternalMarkup.g:1195:8: lv_text_0_3= RULE_INT
                {
                lv_text_0_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 4 :
                // InternalMarkup.g:1210:8: lv_text_0_4= RULE_WS
                {
                lv_text_0_4=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 5 :
                // InternalMarkup.g:1225:8: lv_text_0_5= ':'
                {
                lv_text_0_5=(Token)match(input,26,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 6 :
                // InternalMarkup.g:1237:8: lv_text_0_6= '#'
                {
                lv_text_0_6=(Token)match(input,29,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 7 :
                // InternalMarkup.g:1249:8: lv_text_0_7= ','
                {
                lv_text_0_7=(Token)match(input,30,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred43_InternalMarkup

    // Delegated rules

    public final boolean synpred16_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA20 dfa20 = new DFA20(this);
    static final String dfa_1s = "\35\uffff";
    static final String dfa_2s = "\1\4\2\0\1\uffff\5\0\1\uffff\3\0\20\uffff";
    static final String dfa_3s = "\1\36\2\0\1\uffff\5\0\1\uffff\3\0\20\uffff";
    static final String dfa_4s = "\3\uffff\1\2\5\uffff\1\10\3\uffff\1\14\6\uffff\1\1\1\3\1\4\1\5\1\6\1\7\1\11\1\12\1\13";
    static final String dfa_5s = "\1\uffff\1\0\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\1\10\1\11\20\uffff}>";
    static final String[] dfa_6s = {
            "\2\15\1\uffff\1\3\2\15\6\uffff\1\1\1\2\1\4\1\5\1\6\1\7\1\10\1\12\1\13\1\14\1\15\1\11\1\uffff\2\15",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "222:1: (this_FontElement_0= ruleFontElement | this_NewLineElement_1= ruleNewLineElement | this_BulletElement_2= ruleBulletElement | this_FigureElement_3= ruleFigureElement | this_FigureRefElement_4= ruleFigureRefElement | this_FootnoteElement_5= ruleFootnoteElement | this_HeadingElement_6= ruleHeadingElement | this_NullElement_7= ruleNullElement | this_OCLCodeElement_8= ruleOCLCodeElement | this_OCLEvalElement_9= ruleOCLEvalElement | this_OCLTextElement_10= ruleOCLTextElement | this_TextElement_11= ruleTextElement )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA3_1 = input.LA(1);


                        int index3_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalMarkup()) ) {s = 20;}

                        else if ( (true) ) {s = 13;}


                        input.seek(index3_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 :
                        int LA3_2 = input.LA(1);


                        int index3_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalMarkup()) ) {s = 20;}

                        else if ( (true) ) {s = 13;}


                        input.seek(index3_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 :
                        int LA3_4 = input.LA(1);


                        int index3_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMarkup()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}


                        input.seek(index3_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 :
                        int LA3_5 = input.LA(1);


                        int index3_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalMarkup()) ) {s = 22;}

                        else if ( (true) ) {s = 13;}


                        input.seek(index3_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 :
                        int LA3_6 = input.LA(1);


                        int index3_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalMarkup()) ) {s = 23;}

                        else if ( (true) ) {s = 13;}


                        input.seek(index3_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 :
                        int LA3_7 = input.LA(1);


                        int index3_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalMarkup()) ) {s = 24;}

                        else if ( (true) ) {s = 13;}


                        input.seek(index3_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 :
                        int LA3_8 = input.LA(1);


                        int index3_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalMarkup()) ) {s = 25;}

                        else if ( (true) ) {s = 13;}


                        input.seek(index3_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 :
                        int LA3_10 = input.LA(1);


                        int index3_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalMarkup()) ) {s = 26;}

                        else if ( (true) ) {s = 13;}


                        input.seek(index3_10);
                        if ( s>=0 ) return s;
                        break;
                    case 8 :
                        int LA3_11 = input.LA(1);


                        int index3_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalMarkup()) ) {s = 27;}

                        else if ( (true) ) {s = 13;}


                        input.seek(index3_11);
                        if ( s>=0 ) return s;
                        break;
                    case 9 :
                        int LA3_12 = input.LA(1);


                        int index3_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalMarkup()) ) {s = 28;}

                        else if ( (true) ) {s = 13;}


                        input.seek(index3_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\12\uffff";
    static final String dfa_8s = "\1\1\11\uffff";
    static final String dfa_9s = "\1\4\1\uffff\7\0\1\uffff";
    static final String dfa_10s = "\1\36\1\uffff\7\0\1\uffff";
    static final String dfa_11s = "\1\uffff\1\2\7\uffff\1\1";
    static final String dfa_12s = "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff}>";
    static final String[] dfa_13s = {
            "\1\4\1\2\1\uffff\1\1\1\3\1\5\6\uffff\12\1\1\6\2\1\1\7\1\10",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()+ loopback of 1162:2: ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA20_2 = input.LA(1);


                        int index20_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}


                        input.seek(index20_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 :
                        int LA20_3 = input.LA(1);


                        int index20_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}


                        input.seek(index20_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 :
                        int LA20_4 = input.LA(1);


                        int index20_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}


                        input.seek(index20_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 :
                        int LA20_5 = input.LA(1);


                        int index20_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}


                        input.seek(index20_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 :
                        int LA20_6 = input.LA(1);


                        int index20_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}


                        input.seek(index20_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 :
                        int LA20_7 = input.LA(1);


                        int index20_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}


                        input.seek(index20_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 :
                        int LA20_8 = input.LA(1);


                        int index20_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}


                        input.seek(index20_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }



    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000006FFF03B2L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000028000000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000050000000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000064000332L});
    }


}
