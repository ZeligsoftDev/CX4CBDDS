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
grammar InternalMarkup;

options {
	superClass=AbstractInternalAntlrParser;
	backtrack=true;

}

@lexer::header {
package org.eclipse.ocl.xtext.markup.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import.
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
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

}

@parser::members {

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
}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}




// Entry rule entryRuleMarkup
entryRuleMarkup returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getMarkupRule()); }
	 iv_ruleMarkup=ruleMarkup
	 { $current=$iv_ruleMarkup.current; }
	 EOF
;

// Rule Markup
ruleMarkup returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
(
		{
	        newCompositeNode(grammarAccess.getMarkupAccess().getElementsMarkupElementParserRuleCall_0());
	    }
		lv_elements_0_0=ruleMarkupElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMarkupRule());
	        }
       		add(
       			$current,
       			"elements",
        		lv_elements_0_0,
        		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
	        afterParserOrEnumRuleCall();
	    }

)
)*
;





// Entry rule entryRuleMarkupKeyword
entryRuleMarkupKeyword returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getMarkupKeywordRule()); }
	 iv_ruleMarkupKeyword=ruleMarkupKeyword
	 { $current=$iv_ruleMarkupKeyword.current.getText(); }
	 EOF
;

// Rule MarkupKeyword
ruleMarkupKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	kw='b'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getBKeyword_0());
    }

    |
	kw='e'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getEKeyword_1());
    }

    |
	kw='bullet'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getBulletKeyword_2());
    }

    |
	kw='figure'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getFigureKeyword_3());
    }

    |
	kw='figureRef'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getFigureRefKeyword_4());
    }

    |
	kw='footnote'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getFootnoteKeyword_5());
    }

    |
	kw='heading'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getHeadingKeyword_6());
    }

    |
	kw='oclCode'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getOclCodeKeyword_7());
    }

    |
	kw='oclEval'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getOclEvalKeyword_8());
    }

    |
	kw='oclText'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getOclTextKeyword_9());
    }
)
    ;





// Entry rule entryRuleMarkupElement
entryRuleMarkupElement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getMarkupElementRule()); }
	 iv_ruleMarkupElement=ruleMarkupElement
	 { $current=$iv_ruleMarkupElement.current; }
	 EOF
;

// Rule MarkupElement
ruleMarkupElement returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getMarkupElementAccess().getFontElementParserRuleCall_0());
    }
    this_FontElement_0=ruleFontElement
    {
        $current = $this_FontElement_0.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getMarkupElementAccess().getNewLineElementParserRuleCall_1());
    }
    this_NewLineElement_1=ruleNewLineElement
    {
        $current = $this_NewLineElement_1.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getMarkupElementAccess().getBulletElementParserRuleCall_2());
    }
    this_BulletElement_2=ruleBulletElement
    {
        $current = $this_BulletElement_2.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getMarkupElementAccess().getFigureElementParserRuleCall_3());
    }
    this_FigureElement_3=ruleFigureElement
    {
        $current = $this_FigureElement_3.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getMarkupElementAccess().getFigureRefElementParserRuleCall_4());
    }
    this_FigureRefElement_4=ruleFigureRefElement
    {
        $current = $this_FigureRefElement_4.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getMarkupElementAccess().getFootnoteElementParserRuleCall_5());
    }
    this_FootnoteElement_5=ruleFootnoteElement
    {
        $current = $this_FootnoteElement_5.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getMarkupElementAccess().getHeadingElementParserRuleCall_6());
    }
    this_HeadingElement_6=ruleHeadingElement
    {
        $current = $this_HeadingElement_6.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getMarkupElementAccess().getNullElementParserRuleCall_7());
    }
    this_NullElement_7=ruleNullElement
    {
        $current = $this_NullElement_7.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getMarkupElementAccess().getOCLCodeElementParserRuleCall_8());
    }
    this_OCLCodeElement_8=ruleOCLCodeElement
    {
        $current = $this_OCLCodeElement_8.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getMarkupElementAccess().getOCLEvalElementParserRuleCall_9());
    }
    this_OCLEvalElement_9=ruleOCLEvalElement
    {
        $current = $this_OCLEvalElement_9.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getMarkupElementAccess().getOCLTextElementParserRuleCall_10());
    }
    this_OCLTextElement_10=ruleOCLTextElement
    {
        $current = $this_OCLTextElement_10.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getMarkupElementAccess().getTextElementParserRuleCall_11());
    }
    this_TextElement_11=ruleTextElement
    {
        $current = $this_TextElement_11.current;
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleBulletElement
entryRuleBulletElement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getBulletElementRule()); }
	 iv_ruleBulletElement=ruleBulletElement
	 { $current=$iv_ruleBulletElement.current; }
	 EOF
;

// Rule BulletElement
ruleBulletElement returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getBulletElementAccess().getBulletElementAction_0(),
            $current);
    }
)	otherlv_1='bullet'
    {
    	newLeafNode(otherlv_1, grammarAccess.getBulletElementAccess().getBulletKeyword_1());
    }
(	otherlv_2=':'
    {
    	newLeafNode(otherlv_2, grammarAccess.getBulletElementAccess().getColonKeyword_2_0());
    }
(
(
		lv_level_3_0=RULE_INT
		{
			newLeafNode(lv_level_3_0, grammarAccess.getBulletElementAccess().getLevelINTTerminalRuleCall_2_1_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getBulletElementRule());
	        }
       		setWithLastConsumed(
       			$current,
       			"level",
        		lv_level_3_0,
        		"org.eclipse.ocl.xtext.markup.Markup.INT");
	    }

)
))?	otherlv_4='['
    {
    	newLeafNode(otherlv_4, grammarAccess.getBulletElementAccess().getLeftSquareBracketKeyword_3());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getBulletElementAccess().getElementsMarkupElementParserRuleCall_4_0());
	    }
		lv_elements_5_0=ruleMarkupElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBulletElementRule());
	        }
       		add(
       			$current,
       			"elements",
        		lv_elements_5_0,
        		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_6=']'
    {
    	newLeafNode(otherlv_6, grammarAccess.getBulletElementAccess().getRightSquareBracketKeyword_5());
    }
)
;





// Entry rule entryRuleFontElement
entryRuleFontElement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getFontElementRule()); }
	 iv_ruleFontElement=ruleFontElement
	 { $current=$iv_ruleFontElement.current; }
	 EOF
;

// Rule FontElement
ruleFontElement returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
(
		lv_font_0_1=	'b'
    {
        newLeafNode(lv_font_0_1, grammarAccess.getFontElementAccess().getFontBKeyword_0_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFontElementRule());
	        }
       		setWithLastConsumed($current, "font", lv_font_0_1, null);
	    }

    |		lv_font_0_2=	'e'
    {
        newLeafNode(lv_font_0_2, grammarAccess.getFontElementAccess().getFontEKeyword_0_0_1());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFontElementRule());
	        }
       		setWithLastConsumed($current, "font", lv_font_0_2, null);
	    }

)

)
)	otherlv_1='['
    {
    	newLeafNode(otherlv_1, grammarAccess.getFontElementAccess().getLeftSquareBracketKeyword_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getFontElementAccess().getElementsMarkupElementParserRuleCall_2_0());
	    }
		lv_elements_2_0=ruleMarkupElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFontElementRule());
	        }
       		add(
       			$current,
       			"elements",
        		lv_elements_2_0,
        		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_3=']'
    {
    	newLeafNode(otherlv_3, grammarAccess.getFontElementAccess().getRightSquareBracketKeyword_3());
    }
)
;





// Entry rule entryRuleFigureElement
entryRuleFigureElement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getFigureElementRule()); }
	 iv_ruleFigureElement=ruleFigureElement
	 { $current=$iv_ruleFigureElement.current; }
	 EOF
;

// Rule FigureElement
ruleFigureElement returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='figure'
    {
    	newLeafNode(otherlv_0, grammarAccess.getFigureElementAccess().getFigureKeyword_0());
    }
(	otherlv_1='#'
    {
    	newLeafNode(otherlv_1, grammarAccess.getFigureElementAccess().getNumberSignKeyword_1_0());
    }
(
(
		lv_def_2_0=RULE_ID
		{
			newLeafNode(lv_def_2_0, grammarAccess.getFigureElementAccess().getDefIDTerminalRuleCall_1_1_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFigureElementRule());
	        }
       		setWithLastConsumed(
       			$current,
       			"def",
        		lv_def_2_0,
        		"org.eclipse.ocl.xtext.markup.Markup.ID");
	    }

)
))?	otherlv_3='['
    {
    	newLeafNode(otherlv_3, grammarAccess.getFigureElementAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		lv_src_4_0=RULE_STRING
		{
			newLeafNode(lv_src_4_0, grammarAccess.getFigureElementAccess().getSrcSTRINGTerminalRuleCall_3_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFigureElementRule());
	        }
       		setWithLastConsumed(
       			$current,
       			"src",
        		lv_src_4_0,
        		"org.eclipse.ocl.xtext.markup.Markup.STRING");
	    }

)
)(	otherlv_5=','
    {
    	newLeafNode(otherlv_5, grammarAccess.getFigureElementAccess().getCommaKeyword_4_0());
    }
(
(
		lv_alt_6_0=RULE_STRING
		{
			newLeafNode(lv_alt_6_0, grammarAccess.getFigureElementAccess().getAltSTRINGTerminalRuleCall_4_1_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFigureElementRule());
	        }
       		setWithLastConsumed(
       			$current,
       			"alt",
        		lv_alt_6_0,
        		"org.eclipse.ocl.xtext.markup.Markup.STRING");
	    }

)
)(	otherlv_7=','
    {
    	newLeafNode(otherlv_7, grammarAccess.getFigureElementAccess().getCommaKeyword_4_2_0());
    }
(
(
		lv_requiredWidth_8_0=RULE_INT
		{
			newLeafNode(lv_requiredWidth_8_0, grammarAccess.getFigureElementAccess().getRequiredWidthINTTerminalRuleCall_4_2_1_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFigureElementRule());
	        }
       		setWithLastConsumed(
       			$current,
       			"requiredWidth",
        		lv_requiredWidth_8_0,
        		"org.eclipse.ocl.xtext.markup.Markup.INT");
	    }

)
)(	otherlv_9=','
    {
    	newLeafNode(otherlv_9, grammarAccess.getFigureElementAccess().getCommaKeyword_4_2_2_0());
    }
(
(
		lv_requiredHeight_10_0=RULE_INT
		{
			newLeafNode(lv_requiredHeight_10_0, grammarAccess.getFigureElementAccess().getRequiredHeightINTTerminalRuleCall_4_2_2_1_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFigureElementRule());
	        }
       		setWithLastConsumed(
       			$current,
       			"requiredHeight",
        		lv_requiredHeight_10_0,
        		"org.eclipse.ocl.xtext.markup.Markup.INT");
	    }

)
))?)?)?	otherlv_11=']'
    {
    	newLeafNode(otherlv_11, grammarAccess.getFigureElementAccess().getRightSquareBracketKeyword_5());
    }
)
;





// Entry rule entryRuleFigureRefElement
entryRuleFigureRefElement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getFigureRefElementRule()); }
	 iv_ruleFigureRefElement=ruleFigureRefElement
	 { $current=$iv_ruleFigureRefElement.current; }
	 EOF
;

// Rule FigureRefElement
ruleFigureRefElement returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='figureRef'
    {
    	newLeafNode(otherlv_0, grammarAccess.getFigureRefElementAccess().getFigureRefKeyword_0());
    }
	otherlv_1='['
    {
    	newLeafNode(otherlv_1, grammarAccess.getFigureRefElementAccess().getLeftSquareBracketKeyword_1());
    }
(
(
		{
		  /* */
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFigureRefElementRule());
	        }
        }
	otherlv_2=RULE_ID
	{
		newLeafNode(otherlv_2, grammarAccess.getFigureRefElementAccess().getRefFigureElementCrossReference_2_0());
	}

)
)	otherlv_3=']'
    {
    	newLeafNode(otherlv_3, grammarAccess.getFigureRefElementAccess().getRightSquareBracketKeyword_3());
    }
)
;





// Entry rule entryRuleFootnoteElement
entryRuleFootnoteElement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getFootnoteElementRule()); }
	 iv_ruleFootnoteElement=ruleFootnoteElement
	 { $current=$iv_ruleFootnoteElement.current; }
	 EOF
;

// Rule FootnoteElement
ruleFootnoteElement returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getFootnoteElementAccess().getFootnoteElementAction_0(),
            $current);
    }
)	otherlv_1='footnote'
    {
    	newLeafNode(otherlv_1, grammarAccess.getFootnoteElementAccess().getFootnoteKeyword_1());
    }
	otherlv_2='['
    {
    	newLeafNode(otherlv_2, grammarAccess.getFootnoteElementAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getFootnoteElementAccess().getElementsMarkupElementParserRuleCall_3_0());
	    }
		lv_elements_3_0=ruleMarkupElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFootnoteElementRule());
	        }
       		add(
       			$current,
       			"elements",
        		lv_elements_3_0,
        		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_4=']'
    {
    	newLeafNode(otherlv_4, grammarAccess.getFootnoteElementAccess().getRightSquareBracketKeyword_4());
    }
)
;





// Entry rule entryRuleHeadingElement
entryRuleHeadingElement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getHeadingElementRule()); }
	 iv_ruleHeadingElement=ruleHeadingElement
	 { $current=$iv_ruleHeadingElement.current; }
	 EOF
;

// Rule HeadingElement
ruleHeadingElement returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getHeadingElementAccess().getHeadingElementAction_0(),
            $current);
    }
)	otherlv_1='heading'
    {
    	newLeafNode(otherlv_1, grammarAccess.getHeadingElementAccess().getHeadingKeyword_1());
    }
(	otherlv_2=':'
    {
    	newLeafNode(otherlv_2, grammarAccess.getHeadingElementAccess().getColonKeyword_2_0());
    }
(
(
		lv_level_3_0=RULE_INT
		{
			newLeafNode(lv_level_3_0, grammarAccess.getHeadingElementAccess().getLevelINTTerminalRuleCall_2_1_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getHeadingElementRule());
	        }
       		setWithLastConsumed(
       			$current,
       			"level",
        		lv_level_3_0,
        		"org.eclipse.ocl.xtext.markup.Markup.INT");
	    }

)
))?	otherlv_4='['
    {
    	newLeafNode(otherlv_4, grammarAccess.getHeadingElementAccess().getLeftSquareBracketKeyword_3());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getHeadingElementAccess().getElementsMarkupElementParserRuleCall_4_0());
	    }
		lv_elements_5_0=ruleMarkupElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getHeadingElementRule());
	        }
       		add(
       			$current,
       			"elements",
        		lv_elements_5_0,
        		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_6=']'
    {
    	newLeafNode(otherlv_6, grammarAccess.getHeadingElementAccess().getRightSquareBracketKeyword_5());
    }
)
;





// Entry rule entryRuleNewLineElement
entryRuleNewLineElement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getNewLineElementRule()); }
	 iv_ruleNewLineElement=ruleNewLineElement
	 { $current=$iv_ruleNewLineElement.current; }
	 EOF
;

// Rule NewLineElement
ruleNewLineElement returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
(
		lv_text_0_0=RULE_NL
		{
			newLeafNode(lv_text_0_0, grammarAccess.getNewLineElementAccess().getTextNLTerminalRuleCall_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getNewLineElementRule());
	        }
       		setWithLastConsumed(
       			$current,
       			"text",
        		lv_text_0_0,
        		"org.eclipse.ocl.xtext.markup.Markup.NL");
	    }

)
)
;





// Entry rule entryRuleNullElement
entryRuleNullElement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getNullElementRule()); }
	 iv_ruleNullElement=ruleNullElement
	 { $current=$iv_ruleNullElement.current; }
	 EOF
;

// Rule NullElement
ruleNullElement returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getNullElementAccess().getNullElementAction_0(),
            $current);
    }
)	otherlv_1='['
    {
    	newLeafNode(otherlv_1, grammarAccess.getNullElementAccess().getLeftSquareBracketKeyword_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNullElementAccess().getElementsMarkupElementParserRuleCall_2_0());
	    }
		lv_elements_2_0=ruleMarkupElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNullElementRule());
	        }
       		add(
       			$current,
       			"elements",
        		lv_elements_2_0,
        		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_3=']'
    {
    	newLeafNode(otherlv_3, grammarAccess.getNullElementAccess().getRightSquareBracketKeyword_3());
    }
)
;





// Entry rule entryRuleOCLCodeElement
entryRuleOCLCodeElement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getOCLCodeElementRule()); }
	 iv_ruleOCLCodeElement=ruleOCLCodeElement
	 { $current=$iv_ruleOCLCodeElement.current; }
	 EOF
;

// Rule OCLCodeElement
ruleOCLCodeElement returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getOCLCodeElementAccess().getOCLCodeElementAction_0(),
            $current);
    }
)	otherlv_1='oclCode'
    {
    	newLeafNode(otherlv_1, grammarAccess.getOCLCodeElementAccess().getOclCodeKeyword_1());
    }
	otherlv_2='['
    {
    	newLeafNode(otherlv_2, grammarAccess.getOCLCodeElementAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getOCLCodeElementAccess().getElementsMarkupElementParserRuleCall_3_0());
	    }
		lv_elements_3_0=ruleMarkupElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOCLCodeElementRule());
	        }
       		add(
       			$current,
       			"elements",
        		lv_elements_3_0,
        		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_4=']'
    {
    	newLeafNode(otherlv_4, grammarAccess.getOCLCodeElementAccess().getRightSquareBracketKeyword_4());
    }
)
;





// Entry rule entryRuleOCLEvalElement
entryRuleOCLEvalElement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getOCLEvalElementRule()); }
	 iv_ruleOCLEvalElement=ruleOCLEvalElement
	 { $current=$iv_ruleOCLEvalElement.current; }
	 EOF
;

// Rule OCLEvalElement
ruleOCLEvalElement returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getOCLEvalElementAccess().getOCLEvalElementAction_0(),
            $current);
    }
)	otherlv_1='oclEval'
    {
    	newLeafNode(otherlv_1, grammarAccess.getOCLEvalElementAccess().getOclEvalKeyword_1());
    }
	otherlv_2='['
    {
    	newLeafNode(otherlv_2, grammarAccess.getOCLEvalElementAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getOCLEvalElementAccess().getElementsMarkupElementParserRuleCall_3_0());
	    }
		lv_elements_3_0=ruleMarkupElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOCLEvalElementRule());
	        }
       		add(
       			$current,
       			"elements",
        		lv_elements_3_0,
        		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_4=']'
    {
    	newLeafNode(otherlv_4, grammarAccess.getOCLEvalElementAccess().getRightSquareBracketKeyword_4());
    }
)
;





// Entry rule entryRuleOCLTextElement
entryRuleOCLTextElement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getOCLTextElementRule()); }
	 iv_ruleOCLTextElement=ruleOCLTextElement
	 { $current=$iv_ruleOCLTextElement.current; }
	 EOF
;

// Rule OCLTextElement
ruleOCLTextElement returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getOCLTextElementAccess().getOCLTextElementAction_0(),
            $current);
    }
)	otherlv_1='oclText'
    {
    	newLeafNode(otherlv_1, grammarAccess.getOCLTextElementAccess().getOclTextKeyword_1());
    }
	otherlv_2='['
    {
    	newLeafNode(otherlv_2, grammarAccess.getOCLTextElementAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getOCLTextElementAccess().getElementsMarkupElementParserRuleCall_3_0());
	    }
		lv_elements_3_0=ruleMarkupElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOCLTextElementRule());
	        }
       		add(
       			$current,
       			"elements",
        		lv_elements_3_0,
        		"org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_4=']'
    {
    	newLeafNode(otherlv_4, grammarAccess.getOCLTextElementAccess().getRightSquareBracketKeyword_4());
    }
)
;





// Entry rule entryRuleTextElement
entryRuleTextElement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTextElementRule()); }
	 iv_ruleTextElement=ruleTextElement
	 { $current=$iv_ruleTextElement.current; }
	 EOF
;

// Rule TextElement
ruleTextElement returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
(
		lv_text_0_1=RULE_ID
		{
			newLeafNode(lv_text_0_1, grammarAccess.getTextElementAccess().getTextIDTerminalRuleCall_0_0_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTextElementRule());
	        }
       		addWithLastConsumed(
       			$current,
       			"text",
        		lv_text_0_1,
        		"org.eclipse.ocl.xtext.markup.Markup.ID");
	    }

    |		lv_text_0_2=RULE_WORD
		{
			newLeafNode(lv_text_0_2, grammarAccess.getTextElementAccess().getTextWORDTerminalRuleCall_0_0_1());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTextElementRule());
	        }
       		addWithLastConsumed(
       			$current,
       			"text",
        		lv_text_0_2,
        		"org.eclipse.ocl.xtext.markup.Markup.WORD");
	    }

    |		lv_text_0_3=RULE_INT
		{
			newLeafNode(lv_text_0_3, grammarAccess.getTextElementAccess().getTextINTTerminalRuleCall_0_0_2());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTextElementRule());
	        }
       		addWithLastConsumed(
       			$current,
       			"text",
        		lv_text_0_3,
        		"org.eclipse.ocl.xtext.markup.Markup.INT");
	    }

    |		lv_text_0_4=RULE_WS
		{
			newLeafNode(lv_text_0_4, grammarAccess.getTextElementAccess().getTextWSTerminalRuleCall_0_0_3());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTextElementRule());
	        }
       		addWithLastConsumed(
       			$current,
       			"text",
        		lv_text_0_4,
        		"org.eclipse.ocl.xtext.markup.Markup.WS");
	    }

    |		lv_text_0_5=	':'
    {
        newLeafNode(lv_text_0_5, grammarAccess.getTextElementAccess().getTextColonKeyword_0_0_4());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTextElementRule());
	        }
       		addWithLastConsumed($current, "text", lv_text_0_5, null);
	    }

    |		lv_text_0_6=	'#'
    {
        newLeafNode(lv_text_0_6, grammarAccess.getTextElementAccess().getTextNumberSignKeyword_0_0_5());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTextElementRule());
	        }
       		addWithLastConsumed($current, "text", lv_text_0_6, null);
	    }

    |		lv_text_0_7=	','
    {
        newLeafNode(lv_text_0_7, grammarAccess.getTextElementAccess().getTextCommaKeyword_0_0_6());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTextElementRule());
	        }
       		addWithLastConsumed($current, "text", lv_text_0_7, null);
	    }

)

)
)+
    |(
(
		{
	        newCompositeNode(grammarAccess.getTextElementAccess().getTextMarkupKeywordParserRuleCall_1_0());
	    }
		lv_text_1_0=ruleMarkupKeyword		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTextElementRule());
	        }
       		add(
       			$current,
       			"text",
        		lv_text_1_0,
        		"org.eclipse.ocl.xtext.markup.Markup.MarkupKeyword");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





fragment RULE_NUMBER : '0'..'9';

fragment RULE_LETTER : ('a'..'z'|'A'..'Z'|'_');

fragment RULE_ESCAPED : '\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\'|'<'|'>'|'['|']');

fragment RULE_VERTICAL_WS : ('\n'|'\r');

fragment RULE_HORIZONTAL_WS : (' '|'\t');

RULE_INT : RULE_NUMBER+;

RULE_STRING : '"' (RULE_ESCAPED|~(('\\'|'"')))* '"';

RULE_ID : RULE_LETTER (RULE_LETTER|RULE_NUMBER)*;

RULE_WORD : (RULE_ESCAPED|~(('\\'|'"'|'['|']'|':'|'#'|','|RULE_HORIZONTAL_WS|RULE_VERTICAL_WS)))+;

RULE_NL : (RULE_HORIZONTAL_WS* RULE_VERTICAL_WS)+;

RULE_WS : RULE_HORIZONTAL_WS+;

RULE_ANY_OTHER : .;


