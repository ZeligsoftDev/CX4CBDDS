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
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;

}

@lexer::header {
package org.eclipse.ocl.xtext.markup.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import.
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.ocl.xtext.markup.ui.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.ocl.xtext.markup.services.MarkupGrammarAccess;

}

@parser::members {

 	private MarkupGrammarAccess grammarAccess;

    public void setGrammarAccess(MarkupGrammarAccess grammarAccess) {
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

}




// Entry rule entryRuleMarkup
entryRuleMarkup
:
{ before(grammarAccess.getMarkupRule()); }
	 ruleMarkup
{ after(grammarAccess.getMarkupRule()); }
	 EOF
;

// Rule Markup
ruleMarkup
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMarkupAccess().getElementsAssignment()); }
(rule__Markup__ElementsAssignment)*
{ after(grammarAccess.getMarkupAccess().getElementsAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMarkupKeyword
entryRuleMarkupKeyword
:
{ before(grammarAccess.getMarkupKeywordRule()); }
	 ruleMarkupKeyword
{ after(grammarAccess.getMarkupKeywordRule()); }
	 EOF
;

// Rule MarkupKeyword
ruleMarkupKeyword
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMarkupKeywordAccess().getAlternatives()); }
(rule__MarkupKeyword__Alternatives)
{ after(grammarAccess.getMarkupKeywordAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMarkupElement
entryRuleMarkupElement
:
{ before(grammarAccess.getMarkupElementRule()); }
	 ruleMarkupElement
{ after(grammarAccess.getMarkupElementRule()); }
	 EOF
;

// Rule MarkupElement
ruleMarkupElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMarkupElementAccess().getAlternatives()); }
(rule__MarkupElement__Alternatives)
{ after(grammarAccess.getMarkupElementAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleBulletElement
entryRuleBulletElement
:
{ before(grammarAccess.getBulletElementRule()); }
	 ruleBulletElement
{ after(grammarAccess.getBulletElementRule()); }
	 EOF
;

// Rule BulletElement
ruleBulletElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getBulletElementAccess().getGroup()); }
(rule__BulletElement__Group__0)
{ after(grammarAccess.getBulletElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleFontElement
entryRuleFontElement
:
{ before(grammarAccess.getFontElementRule()); }
	 ruleFontElement
{ after(grammarAccess.getFontElementRule()); }
	 EOF
;

// Rule FontElement
ruleFontElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getFontElementAccess().getGroup()); }
(rule__FontElement__Group__0)
{ after(grammarAccess.getFontElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleFigureElement
entryRuleFigureElement
:
{ before(grammarAccess.getFigureElementRule()); }
	 ruleFigureElement
{ after(grammarAccess.getFigureElementRule()); }
	 EOF
;

// Rule FigureElement
ruleFigureElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getFigureElementAccess().getGroup()); }
(rule__FigureElement__Group__0)
{ after(grammarAccess.getFigureElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleFigureRefElement
entryRuleFigureRefElement
:
{ before(grammarAccess.getFigureRefElementRule()); }
	 ruleFigureRefElement
{ after(grammarAccess.getFigureRefElementRule()); }
	 EOF
;

// Rule FigureRefElement
ruleFigureRefElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getFigureRefElementAccess().getGroup()); }
(rule__FigureRefElement__Group__0)
{ after(grammarAccess.getFigureRefElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleFootnoteElement
entryRuleFootnoteElement
:
{ before(grammarAccess.getFootnoteElementRule()); }
	 ruleFootnoteElement
{ after(grammarAccess.getFootnoteElementRule()); }
	 EOF
;

// Rule FootnoteElement
ruleFootnoteElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getFootnoteElementAccess().getGroup()); }
(rule__FootnoteElement__Group__0)
{ after(grammarAccess.getFootnoteElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleHeadingElement
entryRuleHeadingElement
:
{ before(grammarAccess.getHeadingElementRule()); }
	 ruleHeadingElement
{ after(grammarAccess.getHeadingElementRule()); }
	 EOF
;

// Rule HeadingElement
ruleHeadingElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getHeadingElementAccess().getGroup()); }
(rule__HeadingElement__Group__0)
{ after(grammarAccess.getHeadingElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNewLineElement
entryRuleNewLineElement
:
{ before(grammarAccess.getNewLineElementRule()); }
	 ruleNewLineElement
{ after(grammarAccess.getNewLineElementRule()); }
	 EOF
;

// Rule NewLineElement
ruleNewLineElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNewLineElementAccess().getTextAssignment()); }
(rule__NewLineElement__TextAssignment)
{ after(grammarAccess.getNewLineElementAccess().getTextAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNullElement
entryRuleNullElement
:
{ before(grammarAccess.getNullElementRule()); }
	 ruleNullElement
{ after(grammarAccess.getNullElementRule()); }
	 EOF
;

// Rule NullElement
ruleNullElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNullElementAccess().getGroup()); }
(rule__NullElement__Group__0)
{ after(grammarAccess.getNullElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOCLCodeElement
entryRuleOCLCodeElement
:
{ before(grammarAccess.getOCLCodeElementRule()); }
	 ruleOCLCodeElement
{ after(grammarAccess.getOCLCodeElementRule()); }
	 EOF
;

// Rule OCLCodeElement
ruleOCLCodeElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getOCLCodeElementAccess().getGroup()); }
(rule__OCLCodeElement__Group__0)
{ after(grammarAccess.getOCLCodeElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOCLEvalElement
entryRuleOCLEvalElement
:
{ before(grammarAccess.getOCLEvalElementRule()); }
	 ruleOCLEvalElement
{ after(grammarAccess.getOCLEvalElementRule()); }
	 EOF
;

// Rule OCLEvalElement
ruleOCLEvalElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getOCLEvalElementAccess().getGroup()); }
(rule__OCLEvalElement__Group__0)
{ after(grammarAccess.getOCLEvalElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOCLTextElement
entryRuleOCLTextElement
:
{ before(grammarAccess.getOCLTextElementRule()); }
	 ruleOCLTextElement
{ after(grammarAccess.getOCLTextElementRule()); }
	 EOF
;

// Rule OCLTextElement
ruleOCLTextElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getOCLTextElementAccess().getGroup()); }
(rule__OCLTextElement__Group__0)
{ after(grammarAccess.getOCLTextElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTextElement
entryRuleTextElement
:
{ before(grammarAccess.getTextElementRule()); }
	 ruleTextElement
{ after(grammarAccess.getTextElementRule()); }
	 EOF
;

// Rule TextElement
ruleTextElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTextElementAccess().getAlternatives()); }
(rule__TextElement__Alternatives)
{ after(grammarAccess.getTextElementAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__MarkupKeyword__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMarkupKeywordAccess().getBKeyword_0()); }

	'b'

{ after(grammarAccess.getMarkupKeywordAccess().getBKeyword_0()); }
)

    |(
{ before(grammarAccess.getMarkupKeywordAccess().getEKeyword_1()); }

	'e'

{ after(grammarAccess.getMarkupKeywordAccess().getEKeyword_1()); }
)

    |(
{ before(grammarAccess.getMarkupKeywordAccess().getBulletKeyword_2()); }

	'bullet'

{ after(grammarAccess.getMarkupKeywordAccess().getBulletKeyword_2()); }
)

    |(
{ before(grammarAccess.getMarkupKeywordAccess().getFigureKeyword_3()); }

	'figure'

{ after(grammarAccess.getMarkupKeywordAccess().getFigureKeyword_3()); }
)

    |(
{ before(grammarAccess.getMarkupKeywordAccess().getFigureRefKeyword_4()); }

	'figureRef'

{ after(grammarAccess.getMarkupKeywordAccess().getFigureRefKeyword_4()); }
)

    |(
{ before(grammarAccess.getMarkupKeywordAccess().getFootnoteKeyword_5()); }

	'footnote'

{ after(grammarAccess.getMarkupKeywordAccess().getFootnoteKeyword_5()); }
)

    |(
{ before(grammarAccess.getMarkupKeywordAccess().getHeadingKeyword_6()); }

	'heading'

{ after(grammarAccess.getMarkupKeywordAccess().getHeadingKeyword_6()); }
)

    |(
{ before(grammarAccess.getMarkupKeywordAccess().getOclCodeKeyword_7()); }

	'oclCode'

{ after(grammarAccess.getMarkupKeywordAccess().getOclCodeKeyword_7()); }
)

    |(
{ before(grammarAccess.getMarkupKeywordAccess().getOclEvalKeyword_8()); }

	'oclEval'

{ after(grammarAccess.getMarkupKeywordAccess().getOclEvalKeyword_8()); }
)

    |(
{ before(grammarAccess.getMarkupKeywordAccess().getOclTextKeyword_9()); }

	'oclText'

{ after(grammarAccess.getMarkupKeywordAccess().getOclTextKeyword_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MarkupElement__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMarkupElementAccess().getFontElementParserRuleCall_0()); }
	ruleFontElement
{ after(grammarAccess.getMarkupElementAccess().getFontElementParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getMarkupElementAccess().getNewLineElementParserRuleCall_1()); }
	ruleNewLineElement
{ after(grammarAccess.getMarkupElementAccess().getNewLineElementParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getMarkupElementAccess().getBulletElementParserRuleCall_2()); }
	ruleBulletElement
{ after(grammarAccess.getMarkupElementAccess().getBulletElementParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getMarkupElementAccess().getFigureElementParserRuleCall_3()); }
	ruleFigureElement
{ after(grammarAccess.getMarkupElementAccess().getFigureElementParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getMarkupElementAccess().getFigureRefElementParserRuleCall_4()); }
	ruleFigureRefElement
{ after(grammarAccess.getMarkupElementAccess().getFigureRefElementParserRuleCall_4()); }
)

    |(
{ before(grammarAccess.getMarkupElementAccess().getFootnoteElementParserRuleCall_5()); }
	ruleFootnoteElement
{ after(grammarAccess.getMarkupElementAccess().getFootnoteElementParserRuleCall_5()); }
)

    |(
{ before(grammarAccess.getMarkupElementAccess().getHeadingElementParserRuleCall_6()); }
	ruleHeadingElement
{ after(grammarAccess.getMarkupElementAccess().getHeadingElementParserRuleCall_6()); }
)

    |(
{ before(grammarAccess.getMarkupElementAccess().getNullElementParserRuleCall_7()); }
	ruleNullElement
{ after(grammarAccess.getMarkupElementAccess().getNullElementParserRuleCall_7()); }
)

    |(
{ before(grammarAccess.getMarkupElementAccess().getOCLCodeElementParserRuleCall_8()); }
	ruleOCLCodeElement
{ after(grammarAccess.getMarkupElementAccess().getOCLCodeElementParserRuleCall_8()); }
)

    |(
{ before(grammarAccess.getMarkupElementAccess().getOCLEvalElementParserRuleCall_9()); }
	ruleOCLEvalElement
{ after(grammarAccess.getMarkupElementAccess().getOCLEvalElementParserRuleCall_9()); }
)

    |(
{ before(grammarAccess.getMarkupElementAccess().getOCLTextElementParserRuleCall_10()); }
	ruleOCLTextElement
{ after(grammarAccess.getMarkupElementAccess().getOCLTextElementParserRuleCall_10()); }
)

    |(
{ before(grammarAccess.getMarkupElementAccess().getTextElementParserRuleCall_11()); }
	ruleTextElement
{ after(grammarAccess.getMarkupElementAccess().getTextElementParserRuleCall_11()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FontElement__FontAlternatives_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFontElementAccess().getFontBKeyword_0_0_0()); }

	'b'

{ after(grammarAccess.getFontElementAccess().getFontBKeyword_0_0_0()); }
)

    |(
{ before(grammarAccess.getFontElementAccess().getFontEKeyword_0_0_1()); }

	'e'

{ after(grammarAccess.getFontElementAccess().getFontEKeyword_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TextElement__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getTextElementAccess().getTextAssignment_0()); }
(rule__TextElement__TextAssignment_0)
{ after(grammarAccess.getTextElementAccess().getTextAssignment_0()); }
)
(
{ before(grammarAccess.getTextElementAccess().getTextAssignment_0()); }
(rule__TextElement__TextAssignment_0)*
{ after(grammarAccess.getTextElementAccess().getTextAssignment_0()); }
)
)

    |(
{ before(grammarAccess.getTextElementAccess().getTextAssignment_1()); }
(rule__TextElement__TextAssignment_1)
{ after(grammarAccess.getTextElementAccess().getTextAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TextElement__TextAlternatives_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTextElementAccess().getTextIDTerminalRuleCall_0_0_0()); }
	RULE_ID
{ after(grammarAccess.getTextElementAccess().getTextIDTerminalRuleCall_0_0_0()); }
)

    |(
{ before(grammarAccess.getTextElementAccess().getTextWORDTerminalRuleCall_0_0_1()); }
	RULE_WORD
{ after(grammarAccess.getTextElementAccess().getTextWORDTerminalRuleCall_0_0_1()); }
)

    |(
{ before(grammarAccess.getTextElementAccess().getTextINTTerminalRuleCall_0_0_2()); }
	RULE_INT
{ after(grammarAccess.getTextElementAccess().getTextINTTerminalRuleCall_0_0_2()); }
)

    |(
{ before(grammarAccess.getTextElementAccess().getTextWSTerminalRuleCall_0_0_3()); }
	RULE_WS
{ after(grammarAccess.getTextElementAccess().getTextWSTerminalRuleCall_0_0_3()); }
)

    |(
{ before(grammarAccess.getTextElementAccess().getTextColonKeyword_0_0_4()); }

	':'

{ after(grammarAccess.getTextElementAccess().getTextColonKeyword_0_0_4()); }
)

    |(
{ before(grammarAccess.getTextElementAccess().getTextNumberSignKeyword_0_0_5()); }

	'#'

{ after(grammarAccess.getTextElementAccess().getTextNumberSignKeyword_0_0_5()); }
)

    |(
{ before(grammarAccess.getTextElementAccess().getTextCommaKeyword_0_0_6()); }

	','

{ after(grammarAccess.getTextElementAccess().getTextCommaKeyword_0_0_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__BulletElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BulletElement__Group__0__Impl
	rule__BulletElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BulletElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBulletElementAccess().getBulletElementAction_0()); }
(

)
{ after(grammarAccess.getBulletElementAccess().getBulletElementAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BulletElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BulletElement__Group__1__Impl
	rule__BulletElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__BulletElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBulletElementAccess().getBulletKeyword_1()); }

	'bullet'

{ after(grammarAccess.getBulletElementAccess().getBulletKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BulletElement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BulletElement__Group__2__Impl
	rule__BulletElement__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__BulletElement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBulletElementAccess().getGroup_2()); }
(rule__BulletElement__Group_2__0)?
{ after(grammarAccess.getBulletElementAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BulletElement__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BulletElement__Group__3__Impl
	rule__BulletElement__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__BulletElement__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBulletElementAccess().getLeftSquareBracketKeyword_3()); }

	'['

{ after(grammarAccess.getBulletElementAccess().getLeftSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BulletElement__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BulletElement__Group__4__Impl
	rule__BulletElement__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__BulletElement__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBulletElementAccess().getElementsAssignment_4()); }
(rule__BulletElement__ElementsAssignment_4)*
{ after(grammarAccess.getBulletElementAccess().getElementsAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BulletElement__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BulletElement__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BulletElement__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBulletElementAccess().getRightSquareBracketKeyword_5()); }

	']'

{ after(grammarAccess.getBulletElementAccess().getRightSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__BulletElement__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BulletElement__Group_2__0__Impl
	rule__BulletElement__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BulletElement__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBulletElementAccess().getColonKeyword_2_0()); }

	':'

{ after(grammarAccess.getBulletElementAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BulletElement__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BulletElement__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BulletElement__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBulletElementAccess().getLevelAssignment_2_1()); }
(rule__BulletElement__LevelAssignment_2_1)
{ after(grammarAccess.getBulletElementAccess().getLevelAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__FontElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FontElement__Group__0__Impl
	rule__FontElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FontElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFontElementAccess().getFontAssignment_0()); }
(rule__FontElement__FontAssignment_0)
{ after(grammarAccess.getFontElementAccess().getFontAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FontElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FontElement__Group__1__Impl
	rule__FontElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FontElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFontElementAccess().getLeftSquareBracketKeyword_1()); }

	'['

{ after(grammarAccess.getFontElementAccess().getLeftSquareBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FontElement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FontElement__Group__2__Impl
	rule__FontElement__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__FontElement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFontElementAccess().getElementsAssignment_2()); }
(rule__FontElement__ElementsAssignment_2)*
{ after(grammarAccess.getFontElementAccess().getElementsAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FontElement__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FontElement__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FontElement__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFontElementAccess().getRightSquareBracketKeyword_3()); }

	']'

{ after(grammarAccess.getFontElementAccess().getRightSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__FigureElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group__0__Impl
	rule__FigureElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getFigureKeyword_0()); }

	'figure'

{ after(grammarAccess.getFigureElementAccess().getFigureKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FigureElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group__1__Impl
	rule__FigureElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getGroup_1()); }
(rule__FigureElement__Group_1__0)?
{ after(grammarAccess.getFigureElementAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FigureElement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group__2__Impl
	rule__FigureElement__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getLeftSquareBracketKeyword_2()); }

	'['

{ after(grammarAccess.getFigureElementAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FigureElement__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group__3__Impl
	rule__FigureElement__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getSrcAssignment_3()); }
(rule__FigureElement__SrcAssignment_3)
{ after(grammarAccess.getFigureElementAccess().getSrcAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FigureElement__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group__4__Impl
	rule__FigureElement__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getGroup_4()); }
(rule__FigureElement__Group_4__0)?
{ after(grammarAccess.getFigureElementAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FigureElement__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getRightSquareBracketKeyword_5()); }

	']'

{ after(grammarAccess.getFigureElementAccess().getRightSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__FigureElement__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group_1__0__Impl
	rule__FigureElement__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getNumberSignKeyword_1_0()); }

	'#'

{ after(grammarAccess.getFigureElementAccess().getNumberSignKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FigureElement__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getDefAssignment_1_1()); }
(rule__FigureElement__DefAssignment_1_1)
{ after(grammarAccess.getFigureElementAccess().getDefAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__FigureElement__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group_4__0__Impl
	rule__FigureElement__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getCommaKeyword_4_0()); }

	','

{ after(grammarAccess.getFigureElementAccess().getCommaKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FigureElement__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group_4__1__Impl
	rule__FigureElement__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getAltAssignment_4_1()); }
(rule__FigureElement__AltAssignment_4_1)
{ after(grammarAccess.getFigureElementAccess().getAltAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FigureElement__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getGroup_4_2()); }
(rule__FigureElement__Group_4_2__0)?
{ after(grammarAccess.getFigureElementAccess().getGroup_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__FigureElement__Group_4_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group_4_2__0__Impl
	rule__FigureElement__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group_4_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getCommaKeyword_4_2_0()); }

	','

{ after(grammarAccess.getFigureElementAccess().getCommaKeyword_4_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FigureElement__Group_4_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group_4_2__1__Impl
	rule__FigureElement__Group_4_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group_4_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getRequiredWidthAssignment_4_2_1()); }
(rule__FigureElement__RequiredWidthAssignment_4_2_1)
{ after(grammarAccess.getFigureElementAccess().getRequiredWidthAssignment_4_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FigureElement__Group_4_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group_4_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group_4_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getGroup_4_2_2()); }
(rule__FigureElement__Group_4_2_2__0)?
{ after(grammarAccess.getFigureElementAccess().getGroup_4_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__FigureElement__Group_4_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group_4_2_2__0__Impl
	rule__FigureElement__Group_4_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group_4_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getCommaKeyword_4_2_2_0()); }

	','

{ after(grammarAccess.getFigureElementAccess().getCommaKeyword_4_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FigureElement__Group_4_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureElement__Group_4_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__Group_4_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getRequiredHeightAssignment_4_2_2_1()); }
(rule__FigureElement__RequiredHeightAssignment_4_2_2_1)
{ after(grammarAccess.getFigureElementAccess().getRequiredHeightAssignment_4_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__FigureRefElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureRefElement__Group__0__Impl
	rule__FigureRefElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureRefElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureRefElementAccess().getFigureRefKeyword_0()); }

	'figureRef'

{ after(grammarAccess.getFigureRefElementAccess().getFigureRefKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FigureRefElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureRefElement__Group__1__Impl
	rule__FigureRefElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureRefElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureRefElementAccess().getLeftSquareBracketKeyword_1()); }

	'['

{ after(grammarAccess.getFigureRefElementAccess().getLeftSquareBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FigureRefElement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureRefElement__Group__2__Impl
	rule__FigureRefElement__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureRefElement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureRefElementAccess().getRefAssignment_2()); }
(rule__FigureRefElement__RefAssignment_2)
{ after(grammarAccess.getFigureRefElementAccess().getRefAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FigureRefElement__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FigureRefElement__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FigureRefElement__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureRefElementAccess().getRightSquareBracketKeyword_3()); }

	']'

{ after(grammarAccess.getFigureRefElementAccess().getRightSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__FootnoteElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FootnoteElement__Group__0__Impl
	rule__FootnoteElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FootnoteElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFootnoteElementAccess().getFootnoteElementAction_0()); }
(

)
{ after(grammarAccess.getFootnoteElementAccess().getFootnoteElementAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FootnoteElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FootnoteElement__Group__1__Impl
	rule__FootnoteElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FootnoteElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFootnoteElementAccess().getFootnoteKeyword_1()); }

	'footnote'

{ after(grammarAccess.getFootnoteElementAccess().getFootnoteKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FootnoteElement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FootnoteElement__Group__2__Impl
	rule__FootnoteElement__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__FootnoteElement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFootnoteElementAccess().getLeftSquareBracketKeyword_2()); }

	'['

{ after(grammarAccess.getFootnoteElementAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FootnoteElement__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FootnoteElement__Group__3__Impl
	rule__FootnoteElement__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__FootnoteElement__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFootnoteElementAccess().getElementsAssignment_3()); }
(rule__FootnoteElement__ElementsAssignment_3)*
{ after(grammarAccess.getFootnoteElementAccess().getElementsAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FootnoteElement__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FootnoteElement__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FootnoteElement__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFootnoteElementAccess().getRightSquareBracketKeyword_4()); }

	']'

{ after(grammarAccess.getFootnoteElementAccess().getRightSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__HeadingElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__HeadingElement__Group__0__Impl
	rule__HeadingElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__HeadingElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getHeadingElementAccess().getHeadingElementAction_0()); }
(

)
{ after(grammarAccess.getHeadingElementAccess().getHeadingElementAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__HeadingElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__HeadingElement__Group__1__Impl
	rule__HeadingElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__HeadingElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getHeadingElementAccess().getHeadingKeyword_1()); }

	'heading'

{ after(grammarAccess.getHeadingElementAccess().getHeadingKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__HeadingElement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__HeadingElement__Group__2__Impl
	rule__HeadingElement__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__HeadingElement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getHeadingElementAccess().getGroup_2()); }
(rule__HeadingElement__Group_2__0)?
{ after(grammarAccess.getHeadingElementAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__HeadingElement__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__HeadingElement__Group__3__Impl
	rule__HeadingElement__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__HeadingElement__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getHeadingElementAccess().getLeftSquareBracketKeyword_3()); }

	'['

{ after(grammarAccess.getHeadingElementAccess().getLeftSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__HeadingElement__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__HeadingElement__Group__4__Impl
	rule__HeadingElement__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__HeadingElement__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getHeadingElementAccess().getElementsAssignment_4()); }
(rule__HeadingElement__ElementsAssignment_4)*
{ after(grammarAccess.getHeadingElementAccess().getElementsAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__HeadingElement__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__HeadingElement__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__HeadingElement__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getHeadingElementAccess().getRightSquareBracketKeyword_5()); }

	']'

{ after(grammarAccess.getHeadingElementAccess().getRightSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__HeadingElement__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__HeadingElement__Group_2__0__Impl
	rule__HeadingElement__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__HeadingElement__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getHeadingElementAccess().getColonKeyword_2_0()); }

	':'

{ after(grammarAccess.getHeadingElementAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__HeadingElement__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__HeadingElement__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__HeadingElement__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getHeadingElementAccess().getLevelAssignment_2_1()); }
(rule__HeadingElement__LevelAssignment_2_1)
{ after(grammarAccess.getHeadingElementAccess().getLevelAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NullElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NullElement__Group__0__Impl
	rule__NullElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NullElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNullElementAccess().getNullElementAction_0()); }
(

)
{ after(grammarAccess.getNullElementAccess().getNullElementAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NullElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NullElement__Group__1__Impl
	rule__NullElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NullElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNullElementAccess().getLeftSquareBracketKeyword_1()); }

	'['

{ after(grammarAccess.getNullElementAccess().getLeftSquareBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NullElement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NullElement__Group__2__Impl
	rule__NullElement__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__NullElement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNullElementAccess().getElementsAssignment_2()); }
(rule__NullElement__ElementsAssignment_2)*
{ after(grammarAccess.getNullElementAccess().getElementsAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NullElement__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NullElement__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NullElement__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNullElementAccess().getRightSquareBracketKeyword_3()); }

	']'

{ after(grammarAccess.getNullElementAccess().getRightSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__OCLCodeElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLCodeElement__Group__0__Impl
	rule__OCLCodeElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLCodeElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLCodeElementAccess().getOCLCodeElementAction_0()); }
(

)
{ after(grammarAccess.getOCLCodeElementAccess().getOCLCodeElementAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OCLCodeElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLCodeElement__Group__1__Impl
	rule__OCLCodeElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLCodeElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLCodeElementAccess().getOclCodeKeyword_1()); }

	'oclCode'

{ after(grammarAccess.getOCLCodeElementAccess().getOclCodeKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OCLCodeElement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLCodeElement__Group__2__Impl
	rule__OCLCodeElement__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLCodeElement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLCodeElementAccess().getLeftSquareBracketKeyword_2()); }

	'['

{ after(grammarAccess.getOCLCodeElementAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OCLCodeElement__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLCodeElement__Group__3__Impl
	rule__OCLCodeElement__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLCodeElement__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLCodeElementAccess().getElementsAssignment_3()); }
(rule__OCLCodeElement__ElementsAssignment_3)*
{ after(grammarAccess.getOCLCodeElementAccess().getElementsAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OCLCodeElement__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLCodeElement__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLCodeElement__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLCodeElementAccess().getRightSquareBracketKeyword_4()); }

	']'

{ after(grammarAccess.getOCLCodeElementAccess().getRightSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__OCLEvalElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLEvalElement__Group__0__Impl
	rule__OCLEvalElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLEvalElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLEvalElementAccess().getOCLEvalElementAction_0()); }
(

)
{ after(grammarAccess.getOCLEvalElementAccess().getOCLEvalElementAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OCLEvalElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLEvalElement__Group__1__Impl
	rule__OCLEvalElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLEvalElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLEvalElementAccess().getOclEvalKeyword_1()); }

	'oclEval'

{ after(grammarAccess.getOCLEvalElementAccess().getOclEvalKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OCLEvalElement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLEvalElement__Group__2__Impl
	rule__OCLEvalElement__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLEvalElement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLEvalElementAccess().getLeftSquareBracketKeyword_2()); }

	'['

{ after(grammarAccess.getOCLEvalElementAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OCLEvalElement__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLEvalElement__Group__3__Impl
	rule__OCLEvalElement__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLEvalElement__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLEvalElementAccess().getElementsAssignment_3()); }
(rule__OCLEvalElement__ElementsAssignment_3)*
{ after(grammarAccess.getOCLEvalElementAccess().getElementsAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OCLEvalElement__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLEvalElement__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLEvalElement__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLEvalElementAccess().getRightSquareBracketKeyword_4()); }

	']'

{ after(grammarAccess.getOCLEvalElementAccess().getRightSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__OCLTextElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLTextElement__Group__0__Impl
	rule__OCLTextElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLTextElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLTextElementAccess().getOCLTextElementAction_0()); }
(

)
{ after(grammarAccess.getOCLTextElementAccess().getOCLTextElementAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OCLTextElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLTextElement__Group__1__Impl
	rule__OCLTextElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLTextElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLTextElementAccess().getOclTextKeyword_1()); }

	'oclText'

{ after(grammarAccess.getOCLTextElementAccess().getOclTextKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OCLTextElement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLTextElement__Group__2__Impl
	rule__OCLTextElement__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLTextElement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLTextElementAccess().getLeftSquareBracketKeyword_2()); }

	'['

{ after(grammarAccess.getOCLTextElementAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OCLTextElement__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLTextElement__Group__3__Impl
	rule__OCLTextElement__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLTextElement__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLTextElementAccess().getElementsAssignment_3()); }
(rule__OCLTextElement__ElementsAssignment_3)*
{ after(grammarAccess.getOCLTextElementAccess().getElementsAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OCLTextElement__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OCLTextElement__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OCLTextElement__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLTextElementAccess().getRightSquareBracketKeyword_4()); }

	']'

{ after(grammarAccess.getOCLTextElementAccess().getRightSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}













rule__Markup__ElementsAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMarkupAccess().getElementsMarkupElementParserRuleCall_0()); }
	ruleMarkupElement{ after(grammarAccess.getMarkupAccess().getElementsMarkupElementParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BulletElement__LevelAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBulletElementAccess().getLevelINTTerminalRuleCall_2_1_0()); }
	RULE_INT{ after(grammarAccess.getBulletElementAccess().getLevelINTTerminalRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BulletElement__ElementsAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBulletElementAccess().getElementsMarkupElementParserRuleCall_4_0()); }
	ruleMarkupElement{ after(grammarAccess.getBulletElementAccess().getElementsMarkupElementParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FontElement__FontAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFontElementAccess().getFontAlternatives_0_0()); }
(rule__FontElement__FontAlternatives_0_0)
{ after(grammarAccess.getFontElementAccess().getFontAlternatives_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FontElement__ElementsAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFontElementAccess().getElementsMarkupElementParserRuleCall_2_0()); }
	ruleMarkupElement{ after(grammarAccess.getFontElementAccess().getElementsMarkupElementParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__DefAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getDefIDTerminalRuleCall_1_1_0()); }
	RULE_ID{ after(grammarAccess.getFigureElementAccess().getDefIDTerminalRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__SrcAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getSrcSTRINGTerminalRuleCall_3_0()); }
	RULE_STRING{ after(grammarAccess.getFigureElementAccess().getSrcSTRINGTerminalRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__AltAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getAltSTRINGTerminalRuleCall_4_1_0()); }
	RULE_STRING{ after(grammarAccess.getFigureElementAccess().getAltSTRINGTerminalRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__RequiredWidthAssignment_4_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getRequiredWidthINTTerminalRuleCall_4_2_1_0()); }
	RULE_INT{ after(grammarAccess.getFigureElementAccess().getRequiredWidthINTTerminalRuleCall_4_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FigureElement__RequiredHeightAssignment_4_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureElementAccess().getRequiredHeightINTTerminalRuleCall_4_2_2_1_0()); }
	RULE_INT{ after(grammarAccess.getFigureElementAccess().getRequiredHeightINTTerminalRuleCall_4_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FigureRefElement__RefAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFigureRefElementAccess().getRefFigureElementCrossReference_2_0()); }
(
{ before(grammarAccess.getFigureRefElementAccess().getRefFigureElementIDTerminalRuleCall_2_0_1()); }
	RULE_ID{ after(grammarAccess.getFigureRefElementAccess().getRefFigureElementIDTerminalRuleCall_2_0_1()); }
)
{ after(grammarAccess.getFigureRefElementAccess().getRefFigureElementCrossReference_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FootnoteElement__ElementsAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFootnoteElementAccess().getElementsMarkupElementParserRuleCall_3_0()); }
	ruleMarkupElement{ after(grammarAccess.getFootnoteElementAccess().getElementsMarkupElementParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__HeadingElement__LevelAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getHeadingElementAccess().getLevelINTTerminalRuleCall_2_1_0()); }
	RULE_INT{ after(grammarAccess.getHeadingElementAccess().getLevelINTTerminalRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__HeadingElement__ElementsAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getHeadingElementAccess().getElementsMarkupElementParserRuleCall_4_0()); }
	ruleMarkupElement{ after(grammarAccess.getHeadingElementAccess().getElementsMarkupElementParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NewLineElement__TextAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNewLineElementAccess().getTextNLTerminalRuleCall_0()); }
	RULE_NL{ after(grammarAccess.getNewLineElementAccess().getTextNLTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NullElement__ElementsAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNullElementAccess().getElementsMarkupElementParserRuleCall_2_0()); }
	ruleMarkupElement{ after(grammarAccess.getNullElementAccess().getElementsMarkupElementParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OCLCodeElement__ElementsAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLCodeElementAccess().getElementsMarkupElementParserRuleCall_3_0()); }
	ruleMarkupElement{ after(grammarAccess.getOCLCodeElementAccess().getElementsMarkupElementParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OCLEvalElement__ElementsAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLEvalElementAccess().getElementsMarkupElementParserRuleCall_3_0()); }
	ruleMarkupElement{ after(grammarAccess.getOCLEvalElementAccess().getElementsMarkupElementParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OCLTextElement__ElementsAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOCLTextElementAccess().getElementsMarkupElementParserRuleCall_3_0()); }
	ruleMarkupElement{ after(grammarAccess.getOCLTextElementAccess().getElementsMarkupElementParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TextElement__TextAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTextElementAccess().getTextAlternatives_0_0()); }
(rule__TextElement__TextAlternatives_0_0)
{ after(grammarAccess.getTextElementAccess().getTextAlternatives_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TextElement__TextAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTextElementAccess().getTextMarkupKeywordParserRuleCall_1_0()); }
	ruleMarkupKeyword{ after(grammarAccess.getTextElementAccess().getTextMarkupKeywordParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


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


