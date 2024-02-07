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
package org.eclipse.ocl.xtext.markup.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;


@Singleton
public class MarkupGrammarAccess extends AbstractGrammarElementFinder {


	public class MarkupElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.Markup");
		private final Assignment cElementsAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cElementsMarkupElementParserRuleCall_0 = (RuleCall)cElementsAssignment.eContents().get(0);

		//Markup:
		//	elements+=MarkupElement*;
		@Override public ParserRule getRule() { return rule; }

		//elements+=MarkupElement*
		public Assignment getElementsAssignment() { return cElementsAssignment; }

		//MarkupElement
		public RuleCall getElementsMarkupElementParserRuleCall_0() { return cElementsMarkupElementParserRuleCall_0; }
	}

	public class MarkupKeywordElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.MarkupKeyword");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cBKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cEKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cBulletKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cFigureKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cFigureRefKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cFootnoteKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cHeadingKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cOclCodeKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cOclEvalKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cOclTextKeyword_9 = (Keyword)cAlternatives.eContents().get(9);

		//MarkupKeyword:
		//	'b'
		//	| 'e'
		//	| 'bullet'
		//	| 'figure'
		//	| 'figureRef'
		//	| 'footnote'
		//	| 'heading'
		//	| 'oclCode'
		//	| 'oclEval'
		//	| 'oclText';
		@Override public ParserRule getRule() { return rule; }

		//'b'
		//| 'e'
		//| 'bullet'
		//| 'figure'
		//| 'figureRef'
		//| 'footnote'
		//| 'heading'
		//| 'oclCode'
		//| 'oclEval'
		//| 'oclText'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'b'
		public Keyword getBKeyword_0() { return cBKeyword_0; }

		//'e'
		public Keyword getEKeyword_1() { return cEKeyword_1; }

		//'bullet'
		public Keyword getBulletKeyword_2() { return cBulletKeyword_2; }

		//'figure'
		public Keyword getFigureKeyword_3() { return cFigureKeyword_3; }

		//'figureRef'
		public Keyword getFigureRefKeyword_4() { return cFigureRefKeyword_4; }

		//'footnote'
		public Keyword getFootnoteKeyword_5() { return cFootnoteKeyword_5; }

		//'heading'
		public Keyword getHeadingKeyword_6() { return cHeadingKeyword_6; }

		//'oclCode'
		public Keyword getOclCodeKeyword_7() { return cOclCodeKeyword_7; }

		//'oclEval'
		public Keyword getOclEvalKeyword_8() { return cOclEvalKeyword_8; }

		//'oclText'
		public Keyword getOclTextKeyword_9() { return cOclTextKeyword_9; }
	}

	public class MarkupElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.MarkupElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cFontElementParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cNewLineElementParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cBulletElementParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cFigureElementParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cFigureRefElementParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cFootnoteElementParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cHeadingElementParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cNullElementParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		private final RuleCall cOCLCodeElementParserRuleCall_8 = (RuleCall)cAlternatives.eContents().get(8);
		private final RuleCall cOCLEvalElementParserRuleCall_9 = (RuleCall)cAlternatives.eContents().get(9);
		private final RuleCall cOCLTextElementParserRuleCall_10 = (RuleCall)cAlternatives.eContents().get(10);
		private final RuleCall cTextElementParserRuleCall_11 = (RuleCall)cAlternatives.eContents().get(11);

		//MarkupElement:
		//	FontElement
		//	| NewLineElement
		//	| BulletElement
		//	| FigureElement
		//	| FigureRefElement
		//	| FootnoteElement
		//	| HeadingElement
		//	| NullElement
		//	| OCLCodeElement
		//	| OCLEvalElement
		//	| OCLTextElement
		//	| TextElement // Last to give everything else a try first
		//;
		@Override public ParserRule getRule() { return rule; }

		//FontElement
		//| NewLineElement
		//| BulletElement
		//| FigureElement
		//| FigureRefElement
		//| FootnoteElement
		//| HeadingElement
		//| NullElement
		//| OCLCodeElement
		//| OCLEvalElement
		//| OCLTextElement
		//| TextElement
		public Alternatives getAlternatives() { return cAlternatives; }

		//FontElement
		public RuleCall getFontElementParserRuleCall_0() { return cFontElementParserRuleCall_0; }

		//NewLineElement
		public RuleCall getNewLineElementParserRuleCall_1() { return cNewLineElementParserRuleCall_1; }

		//BulletElement
		public RuleCall getBulletElementParserRuleCall_2() { return cBulletElementParserRuleCall_2; }

		//FigureElement
		public RuleCall getFigureElementParserRuleCall_3() { return cFigureElementParserRuleCall_3; }

		//FigureRefElement
		public RuleCall getFigureRefElementParserRuleCall_4() { return cFigureRefElementParserRuleCall_4; }

		//FootnoteElement
		public RuleCall getFootnoteElementParserRuleCall_5() { return cFootnoteElementParserRuleCall_5; }

		//HeadingElement
		public RuleCall getHeadingElementParserRuleCall_6() { return cHeadingElementParserRuleCall_6; }

		//NullElement
		public RuleCall getNullElementParserRuleCall_7() { return cNullElementParserRuleCall_7; }

		//OCLCodeElement
		public RuleCall getOCLCodeElementParserRuleCall_8() { return cOCLCodeElementParserRuleCall_8; }

		//OCLEvalElement
		public RuleCall getOCLEvalElementParserRuleCall_9() { return cOCLEvalElementParserRuleCall_9; }

		//OCLTextElement
		public RuleCall getOCLTextElementParserRuleCall_10() { return cOCLTextElementParserRuleCall_10; }

		//TextElement
		public RuleCall getTextElementParserRuleCall_11() { return cTextElementParserRuleCall_11; }
	}

	public class BulletElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.BulletElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBulletElementAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cBulletKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cLevelAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cLevelINTTerminalRuleCall_2_1_0 = (RuleCall)cLevelAssignment_2_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cElementsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cElementsMarkupElementParserRuleCall_4_0 = (RuleCall)cElementsAssignment_4.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);

		//BulletElement:
		//	{BulletElement} 'bullet' (':' level=INT)? '[' elements+=MarkupElement* ']';
		@Override public ParserRule getRule() { return rule; }

		//{BulletElement} 'bullet' (':' level=INT)? '[' elements+=MarkupElement* ']'
		public Group getGroup() { return cGroup; }

		//{BulletElement}
		public Action getBulletElementAction_0() { return cBulletElementAction_0; }

		//'bullet'
		public Keyword getBulletKeyword_1() { return cBulletKeyword_1; }

		//(':' level=INT)?
		public Group getGroup_2() { return cGroup_2; }

		//':'
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//level=INT
		public Assignment getLevelAssignment_2_1() { return cLevelAssignment_2_1; }

		//INT
		public RuleCall getLevelINTTerminalRuleCall_2_1_0() { return cLevelINTTerminalRuleCall_2_1_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//elements+=MarkupElement*
		public Assignment getElementsAssignment_4() { return cElementsAssignment_4; }

		//MarkupElement
		public RuleCall getElementsMarkupElementParserRuleCall_4_0() { return cElementsMarkupElementParserRuleCall_4_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class FontElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.FontElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cFontAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Alternatives cFontAlternatives_0_0 = (Alternatives)cFontAssignment_0.eContents().get(0);
		private final Keyword cFontBKeyword_0_0_0 = (Keyword)cFontAlternatives_0_0.eContents().get(0);
		private final Keyword cFontEKeyword_0_0_1 = (Keyword)cFontAlternatives_0_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cElementsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cElementsMarkupElementParserRuleCall_2_0 = (RuleCall)cElementsAssignment_2.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);

		//FontElement:
		//	font=('b' | 'e') '[' elements+=MarkupElement* ']';
		@Override public ParserRule getRule() { return rule; }

		//font=('b' | 'e') '[' elements+=MarkupElement* ']'
		public Group getGroup() { return cGroup; }

		//font=('b' | 'e')
		public Assignment getFontAssignment_0() { return cFontAssignment_0; }

		//('b' | 'e')
		public Alternatives getFontAlternatives_0_0() { return cFontAlternatives_0_0; }

		//'b'
		public Keyword getFontBKeyword_0_0_0() { return cFontBKeyword_0_0_0; }

		//'e'
		public Keyword getFontEKeyword_0_0_1() { return cFontEKeyword_0_0_1; }

		//'['
		public Keyword getLeftSquareBracketKeyword_1() { return cLeftSquareBracketKeyword_1; }

		//elements+=MarkupElement*
		public Assignment getElementsAssignment_2() { return cElementsAssignment_2; }

		//MarkupElement
		public RuleCall getElementsMarkupElementParserRuleCall_2_0() { return cElementsMarkupElementParserRuleCall_2_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_3() { return cRightSquareBracketKeyword_3; }
	}

	public class FigureElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.FigureElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cFigureKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cNumberSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cDefAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cDefIDTerminalRuleCall_1_1_0 = (RuleCall)cDefAssignment_1_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cSrcAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cSrcSTRINGTerminalRuleCall_3_0 = (RuleCall)cSrcAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCommaKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cAltAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cAltSTRINGTerminalRuleCall_4_1_0 = (RuleCall)cAltAssignment_4_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cGroup_4.eContents().get(2);
		private final Keyword cCommaKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cRequiredWidthAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cRequiredWidthINTTerminalRuleCall_4_2_1_0 = (RuleCall)cRequiredWidthAssignment_4_2_1.eContents().get(0);
		private final Group cGroup_4_2_2 = (Group)cGroup_4_2.eContents().get(2);
		private final Keyword cCommaKeyword_4_2_2_0 = (Keyword)cGroup_4_2_2.eContents().get(0);
		private final Assignment cRequiredHeightAssignment_4_2_2_1 = (Assignment)cGroup_4_2_2.eContents().get(1);
		private final RuleCall cRequiredHeightINTTerminalRuleCall_4_2_2_1_0 = (RuleCall)cRequiredHeightAssignment_4_2_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);

		//FigureElement:
		//	'figure' ('#' def=ID)? '[' src=STRING (',' alt=STRING (',' requiredWidth=INT (',' requiredHeight=INT)?)?)? ']';
		@Override public ParserRule getRule() { return rule; }

		//'figure' ('#' def=ID)? '[' src=STRING (',' alt=STRING (',' requiredWidth=INT (',' requiredHeight=INT)?)?)? ']'
		public Group getGroup() { return cGroup; }

		//'figure'
		public Keyword getFigureKeyword_0() { return cFigureKeyword_0; }

		//('#' def=ID)?
		public Group getGroup_1() { return cGroup_1; }

		//'#'
		public Keyword getNumberSignKeyword_1_0() { return cNumberSignKeyword_1_0; }

		//def=ID
		public Assignment getDefAssignment_1_1() { return cDefAssignment_1_1; }

		//ID
		public RuleCall getDefIDTerminalRuleCall_1_1_0() { return cDefIDTerminalRuleCall_1_1_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//src=STRING
		public Assignment getSrcAssignment_3() { return cSrcAssignment_3; }

		//STRING
		public RuleCall getSrcSTRINGTerminalRuleCall_3_0() { return cSrcSTRINGTerminalRuleCall_3_0; }

		//(',' alt=STRING (',' requiredWidth=INT (',' requiredHeight=INT)?)?)?
		public Group getGroup_4() { return cGroup_4; }

		//','
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }

		//alt=STRING
		public Assignment getAltAssignment_4_1() { return cAltAssignment_4_1; }

		//STRING
		public RuleCall getAltSTRINGTerminalRuleCall_4_1_0() { return cAltSTRINGTerminalRuleCall_4_1_0; }

		//(',' requiredWidth=INT (',' requiredHeight=INT)?)?
		public Group getGroup_4_2() { return cGroup_4_2; }

		//','
		public Keyword getCommaKeyword_4_2_0() { return cCommaKeyword_4_2_0; }

		//requiredWidth=INT
		public Assignment getRequiredWidthAssignment_4_2_1() { return cRequiredWidthAssignment_4_2_1; }

		//INT
		public RuleCall getRequiredWidthINTTerminalRuleCall_4_2_1_0() { return cRequiredWidthINTTerminalRuleCall_4_2_1_0; }

		//(',' requiredHeight=INT)?
		public Group getGroup_4_2_2() { return cGroup_4_2_2; }

		//','
		public Keyword getCommaKeyword_4_2_2_0() { return cCommaKeyword_4_2_2_0; }

		//requiredHeight=INT
		public Assignment getRequiredHeightAssignment_4_2_2_1() { return cRequiredHeightAssignment_4_2_2_1; }

		//INT
		public RuleCall getRequiredHeightINTTerminalRuleCall_4_2_2_1_0() { return cRequiredHeightINTTerminalRuleCall_4_2_2_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class FigureRefElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.FigureRefElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cFigureRefKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRefAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cRefFigureElementCrossReference_2_0 = (CrossReference)cRefAssignment_2.eContents().get(0);
		private final RuleCall cRefFigureElementIDTerminalRuleCall_2_0_1 = (RuleCall)cRefFigureElementCrossReference_2_0.eContents().get(1);
		private final Keyword cRightSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);

		//FigureRefElement:
		//	'figureRef' '[' ref=[FigureElement] ']';
		@Override public ParserRule getRule() { return rule; }

		//'figureRef' '[' ref=[FigureElement] ']'
		public Group getGroup() { return cGroup; }

		//'figureRef'
		public Keyword getFigureRefKeyword_0() { return cFigureRefKeyword_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_1() { return cLeftSquareBracketKeyword_1; }

		//ref=[FigureElement]
		public Assignment getRefAssignment_2() { return cRefAssignment_2; }

		//[FigureElement]
		public CrossReference getRefFigureElementCrossReference_2_0() { return cRefFigureElementCrossReference_2_0; }

		//ID
		public RuleCall getRefFigureElementIDTerminalRuleCall_2_0_1() { return cRefFigureElementIDTerminalRuleCall_2_0_1; }

		//']'
		public Keyword getRightSquareBracketKeyword_3() { return cRightSquareBracketKeyword_3; }
	}

	public class FootnoteElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.FootnoteElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cFootnoteElementAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cFootnoteKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cElementsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cElementsMarkupElementParserRuleCall_3_0 = (RuleCall)cElementsAssignment_3.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//FootnoteElement:
		//	{FootnoteElement} 'footnote' '[' elements+=MarkupElement* ']';
		@Override public ParserRule getRule() { return rule; }

		//{FootnoteElement} 'footnote' '[' elements+=MarkupElement* ']'
		public Group getGroup() { return cGroup; }

		//{FootnoteElement}
		public Action getFootnoteElementAction_0() { return cFootnoteElementAction_0; }

		//'footnote'
		public Keyword getFootnoteKeyword_1() { return cFootnoteKeyword_1; }

		//'['
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//elements+=MarkupElement*
		public Assignment getElementsAssignment_3() { return cElementsAssignment_3; }

		//MarkupElement
		public RuleCall getElementsMarkupElementParserRuleCall_3_0() { return cElementsMarkupElementParserRuleCall_3_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_4() { return cRightSquareBracketKeyword_4; }
	}

	public class HeadingElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.HeadingElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cHeadingElementAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cHeadingKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cLevelAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cLevelINTTerminalRuleCall_2_1_0 = (RuleCall)cLevelAssignment_2_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cElementsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cElementsMarkupElementParserRuleCall_4_0 = (RuleCall)cElementsAssignment_4.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);

		//HeadingElement:
		//	{HeadingElement} 'heading' (':' level=INT)? '[' elements+=MarkupElement* ']';
		@Override public ParserRule getRule() { return rule; }

		//{HeadingElement} 'heading' (':' level=INT)? '[' elements+=MarkupElement* ']'
		public Group getGroup() { return cGroup; }

		//{HeadingElement}
		public Action getHeadingElementAction_0() { return cHeadingElementAction_0; }

		//'heading'
		public Keyword getHeadingKeyword_1() { return cHeadingKeyword_1; }

		//(':' level=INT)?
		public Group getGroup_2() { return cGroup_2; }

		//':'
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//level=INT
		public Assignment getLevelAssignment_2_1() { return cLevelAssignment_2_1; }

		//INT
		public RuleCall getLevelINTTerminalRuleCall_2_1_0() { return cLevelINTTerminalRuleCall_2_1_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//elements+=MarkupElement*
		public Assignment getElementsAssignment_4() { return cElementsAssignment_4; }

		//MarkupElement
		public RuleCall getElementsMarkupElementParserRuleCall_4_0() { return cElementsMarkupElementParserRuleCall_4_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class NewLineElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.NewLineElement");
		private final Assignment cTextAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cTextNLTerminalRuleCall_0 = (RuleCall)cTextAssignment.eContents().get(0);

		//NewLineElement:
		//	text=NL;
		@Override public ParserRule getRule() { return rule; }

		//text=NL
		public Assignment getTextAssignment() { return cTextAssignment; }

		//NL
		public RuleCall getTextNLTerminalRuleCall_0() { return cTextNLTerminalRuleCall_0; }
	}

	public class NullElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.NullElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cNullElementAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cElementsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cElementsMarkupElementParserRuleCall_2_0 = (RuleCall)cElementsAssignment_2.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);

		//NullElement:
		//	{NullElement} '[' elements+=MarkupElement* ']';
		@Override public ParserRule getRule() { return rule; }

		//{NullElement} '[' elements+=MarkupElement* ']'
		public Group getGroup() { return cGroup; }

		//{NullElement}
		public Action getNullElementAction_0() { return cNullElementAction_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_1() { return cLeftSquareBracketKeyword_1; }

		//elements+=MarkupElement*
		public Assignment getElementsAssignment_2() { return cElementsAssignment_2; }

		//MarkupElement
		public RuleCall getElementsMarkupElementParserRuleCall_2_0() { return cElementsMarkupElementParserRuleCall_2_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_3() { return cRightSquareBracketKeyword_3; }
	}

	public class OCLCodeElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.OCLCodeElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cOCLCodeElementAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cOclCodeKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cElementsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cElementsMarkupElementParserRuleCall_3_0 = (RuleCall)cElementsAssignment_3.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//OCLCodeElement:
		//	{OCLCodeElement} 'oclCode' '[' elements+=MarkupElement* ']';
		@Override public ParserRule getRule() { return rule; }

		//{OCLCodeElement} 'oclCode' '[' elements+=MarkupElement* ']'
		public Group getGroup() { return cGroup; }

		//{OCLCodeElement}
		public Action getOCLCodeElementAction_0() { return cOCLCodeElementAction_0; }

		//'oclCode'
		public Keyword getOclCodeKeyword_1() { return cOclCodeKeyword_1; }

		//'['
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//elements+=MarkupElement*
		public Assignment getElementsAssignment_3() { return cElementsAssignment_3; }

		//MarkupElement
		public RuleCall getElementsMarkupElementParserRuleCall_3_0() { return cElementsMarkupElementParserRuleCall_3_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_4() { return cRightSquareBracketKeyword_4; }
	}

	public class OCLEvalElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.OCLEvalElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cOCLEvalElementAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cOclEvalKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cElementsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cElementsMarkupElementParserRuleCall_3_0 = (RuleCall)cElementsAssignment_3.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//OCLEvalElement:
		//	{OCLEvalElement} 'oclEval' '[' elements+=MarkupElement* ']';
		@Override public ParserRule getRule() { return rule; }

		//{OCLEvalElement} 'oclEval' '[' elements+=MarkupElement* ']'
		public Group getGroup() { return cGroup; }

		//{OCLEvalElement}
		public Action getOCLEvalElementAction_0() { return cOCLEvalElementAction_0; }

		//'oclEval'
		public Keyword getOclEvalKeyword_1() { return cOclEvalKeyword_1; }

		//'['
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//elements+=MarkupElement*
		public Assignment getElementsAssignment_3() { return cElementsAssignment_3; }

		//MarkupElement
		public RuleCall getElementsMarkupElementParserRuleCall_3_0() { return cElementsMarkupElementParserRuleCall_3_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_4() { return cRightSquareBracketKeyword_4; }
	}

	public class OCLTextElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.OCLTextElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cOCLTextElementAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cOclTextKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cElementsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cElementsMarkupElementParserRuleCall_3_0 = (RuleCall)cElementsAssignment_3.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//OCLTextElement:
		//	{OCLTextElement} 'oclText' '[' elements+=MarkupElement* ']';
		@Override public ParserRule getRule() { return rule; }

		//{OCLTextElement} 'oclText' '[' elements+=MarkupElement* ']'
		public Group getGroup() { return cGroup; }

		//{OCLTextElement}
		public Action getOCLTextElementAction_0() { return cOCLTextElementAction_0; }

		//'oclText'
		public Keyword getOclTextKeyword_1() { return cOclTextKeyword_1; }

		//'['
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//elements+=MarkupElement*
		public Assignment getElementsAssignment_3() { return cElementsAssignment_3; }

		//MarkupElement
		public RuleCall getElementsMarkupElementParserRuleCall_3_0() { return cElementsMarkupElementParserRuleCall_3_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_4() { return cRightSquareBracketKeyword_4; }
	}

	public class TextElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.TextElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cTextAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final Alternatives cTextAlternatives_0_0 = (Alternatives)cTextAssignment_0.eContents().get(0);
		private final RuleCall cTextIDTerminalRuleCall_0_0_0 = (RuleCall)cTextAlternatives_0_0.eContents().get(0);
		private final RuleCall cTextWORDTerminalRuleCall_0_0_1 = (RuleCall)cTextAlternatives_0_0.eContents().get(1);
		private final RuleCall cTextINTTerminalRuleCall_0_0_2 = (RuleCall)cTextAlternatives_0_0.eContents().get(2);
		private final RuleCall cTextWSTerminalRuleCall_0_0_3 = (RuleCall)cTextAlternatives_0_0.eContents().get(3);
		private final Keyword cTextColonKeyword_0_0_4 = (Keyword)cTextAlternatives_0_0.eContents().get(4);
		private final Keyword cTextNumberSignKeyword_0_0_5 = (Keyword)cTextAlternatives_0_0.eContents().get(5);
		private final Keyword cTextCommaKeyword_0_0_6 = (Keyword)cTextAlternatives_0_0.eContents().get(6);
		private final Assignment cTextAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cTextMarkupKeywordParserRuleCall_1_0 = (RuleCall)cTextAssignment_1.eContents().get(0);

		//TextElement:
		//	text+=(ID | WORD | INT | WS | ':' | '#' | ',')+ | text+=MarkupKeyword;
		@Override public ParserRule getRule() { return rule; }

		//text+=(ID | WORD | INT | WS | ':' | '#' | ',')+ | text+=MarkupKeyword
		public Alternatives getAlternatives() { return cAlternatives; }

		//text+=(ID | WORD | INT | WS | ':' | '#' | ',')+
		public Assignment getTextAssignment_0() { return cTextAssignment_0; }

		//(ID | WORD | INT | WS | ':' | '#' | ',')
		public Alternatives getTextAlternatives_0_0() { return cTextAlternatives_0_0; }

		//ID
		public RuleCall getTextIDTerminalRuleCall_0_0_0() { return cTextIDTerminalRuleCall_0_0_0; }

		//WORD
		public RuleCall getTextWORDTerminalRuleCall_0_0_1() { return cTextWORDTerminalRuleCall_0_0_1; }

		//INT
		public RuleCall getTextINTTerminalRuleCall_0_0_2() { return cTextINTTerminalRuleCall_0_0_2; }

		//WS
		public RuleCall getTextWSTerminalRuleCall_0_0_3() { return cTextWSTerminalRuleCall_0_0_3; }

		//':'
		public Keyword getTextColonKeyword_0_0_4() { return cTextColonKeyword_0_0_4; }

		//'#'
		public Keyword getTextNumberSignKeyword_0_0_5() { return cTextNumberSignKeyword_0_0_5; }

		//','
		public Keyword getTextCommaKeyword_0_0_6() { return cTextCommaKeyword_0_0_6; }

		//text+=MarkupKeyword
		public Assignment getTextAssignment_1() { return cTextAssignment_1; }

		//MarkupKeyword
		public RuleCall getTextMarkupKeywordParserRuleCall_1_0() { return cTextMarkupKeywordParserRuleCall_1_0; }
	}


	private final MarkupElements pMarkup;
	private final TerminalRule tNUMBER;
	private final TerminalRule tLETTER;
	private final TerminalRule tESCAPED;
	private final TerminalRule tVERTICAL_WS;
	private final TerminalRule tHORIZONTAL_WS;
	private final TerminalRule tINT;
	private final TerminalRule tSTRING;
	private final TerminalRule tID;
	private final TerminalRule tWORD;
	private final TerminalRule tNL;
	private final TerminalRule tWS;
	private final TerminalRule tANY_OTHER;
	private final MarkupKeywordElements pMarkupKeyword;
	private final MarkupElementElements pMarkupElement;
	private final BulletElementElements pBulletElement;
	private final FontElementElements pFontElement;
	private final FigureElementElements pFigureElement;
	private final FigureRefElementElements pFigureRefElement;
	private final FootnoteElementElements pFootnoteElement;
	private final HeadingElementElements pHeadingElement;
	private final NewLineElementElements pNewLineElement;
	private final NullElementElements pNullElement;
	private final OCLCodeElementElements pOCLCodeElement;
	private final OCLEvalElementElements pOCLEvalElement;
	private final OCLTextElementElements pOCLTextElement;
	private final TextElementElements pTextElement;

	private final Grammar grammar;

	@Inject
	public MarkupGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.pMarkup = new MarkupElements();
		this.tNUMBER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.NUMBER");
		this.tLETTER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.LETTER");
		this.tESCAPED = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.ESCAPED");
		this.tVERTICAL_WS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.VERTICAL_WS");
		this.tHORIZONTAL_WS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.HORIZONTAL_WS");
		this.tINT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.INT");
		this.tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.STRING");
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.ID");
		this.tWORD = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.WORD");
		this.tNL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.NL");
		this.tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.WS");
		this.tANY_OTHER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.markup.Markup.ANY_OTHER");
		this.pMarkupKeyword = new MarkupKeywordElements();
		this.pMarkupElement = new MarkupElementElements();
		this.pBulletElement = new BulletElementElements();
		this.pFontElement = new FontElementElements();
		this.pFigureElement = new FigureElementElements();
		this.pFigureRefElement = new FigureRefElementElements();
		this.pFootnoteElement = new FootnoteElementElements();
		this.pHeadingElement = new HeadingElementElements();
		this.pNewLineElement = new NewLineElementElements();
		this.pNullElement = new NullElementElements();
		this.pOCLCodeElement = new OCLCodeElementElements();
		this.pOCLEvalElement = new OCLEvalElementElements();
		this.pOCLTextElement = new OCLTextElementElements();
		this.pTextElement = new TextElementElements();
	}

	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.ocl.xtext.markup.Markup".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}

	@Override
	public Grammar getGrammar() {
		return grammar;
	}



	//Markup:
	//	elements+=MarkupElement*;
	public MarkupElements getMarkupAccess() {
		return pMarkup;
	}

	public ParserRule getMarkupRule() {
		return getMarkupAccess().getRule();
	}

	//terminal fragment NUMBER:
	//	'0'..'9';
	public TerminalRule getNUMBERRule() {
		return tNUMBER;
	}

	//terminal fragment LETTER:
	//	'a'..'z' | 'A'..'Z' | '_';
	public TerminalRule getLETTERRule() {
		return tLETTER;
	}

	//terminal fragment ESCAPED:
	//	'\\' ('b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' | '<' | '>' | '[' | ']');
	public TerminalRule getESCAPEDRule() {
		return tESCAPED;
	}

	//terminal fragment VERTICAL_WS:
	//	'\n' | '\r';
	public TerminalRule getVERTICAL_WSRule() {
		return tVERTICAL_WS;
	}

	//terminal fragment HORIZONTAL_WS:
	//	' ' | '\t';
	public TerminalRule getHORIZONTAL_WSRule() {
		return tHORIZONTAL_WS;
	}

	//terminal INT:
	//	NUMBER+;
	public TerminalRule getINTRule() {
		return tINT;
	}

	//terminal STRING:
	//	'"' (ESCAPED | !('\\' | '"'))* '"';
	public TerminalRule getSTRINGRule() {
		return tSTRING;
	}

	//terminal ID:
	//	LETTER (LETTER | NUMBER)*;
	public TerminalRule getIDRule() {
		return tID;
	}

	//terminal WORD:
	//	ESCAPED | !('\\' | '"' | '[' | ']' | ':' | '#' | ',' | HORIZONTAL_WS | VERTICAL_WS)+;
	public TerminalRule getWORDRule() {
		return tWORD;
	}

	//terminal NL:
	//	HORIZONTAL_WS* VERTICAL_WS+;
	public TerminalRule getNLRule() {
		return tNL;
	}

	//terminal WS:
	//	HORIZONTAL_WS+;
	public TerminalRule getWSRule() {
		return tWS;
	}

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return tANY_OTHER;
	}

	//MarkupKeyword:
	//	'b'
	//	| 'e'
	//	| 'bullet'
	//	| 'figure'
	//	| 'figureRef'
	//	| 'footnote'
	//	| 'heading'
	//	| 'oclCode'
	//	| 'oclEval'
	//	| 'oclText';
	public MarkupKeywordElements getMarkupKeywordAccess() {
		return pMarkupKeyword;
	}

	public ParserRule getMarkupKeywordRule() {
		return getMarkupKeywordAccess().getRule();
	}

	//MarkupElement:
	//	FontElement
	//	| NewLineElement
	//	| BulletElement
	//	| FigureElement
	//	| FigureRefElement
	//	| FootnoteElement
	//	| HeadingElement
	//	| NullElement
	//	| OCLCodeElement
	//	| OCLEvalElement
	//	| OCLTextElement
	//	| TextElement // Last to give everything else a try first
	//;
	public MarkupElementElements getMarkupElementAccess() {
		return pMarkupElement;
	}

	public ParserRule getMarkupElementRule() {
		return getMarkupElementAccess().getRule();
	}

	//BulletElement:
	//	{BulletElement} 'bullet' (':' level=INT)? '[' elements+=MarkupElement* ']';
	public BulletElementElements getBulletElementAccess() {
		return pBulletElement;
	}

	public ParserRule getBulletElementRule() {
		return getBulletElementAccess().getRule();
	}

	//FontElement:
	//	font=('b' | 'e') '[' elements+=MarkupElement* ']';
	public FontElementElements getFontElementAccess() {
		return pFontElement;
	}

	public ParserRule getFontElementRule() {
		return getFontElementAccess().getRule();
	}

	//FigureElement:
	//	'figure' ('#' def=ID)? '[' src=STRING (',' alt=STRING (',' requiredWidth=INT (',' requiredHeight=INT)?)?)? ']';
	public FigureElementElements getFigureElementAccess() {
		return pFigureElement;
	}

	public ParserRule getFigureElementRule() {
		return getFigureElementAccess().getRule();
	}

	//FigureRefElement:
	//	'figureRef' '[' ref=[FigureElement] ']';
	public FigureRefElementElements getFigureRefElementAccess() {
		return pFigureRefElement;
	}

	public ParserRule getFigureRefElementRule() {
		return getFigureRefElementAccess().getRule();
	}

	//FootnoteElement:
	//	{FootnoteElement} 'footnote' '[' elements+=MarkupElement* ']';
	public FootnoteElementElements getFootnoteElementAccess() {
		return pFootnoteElement;
	}

	public ParserRule getFootnoteElementRule() {
		return getFootnoteElementAccess().getRule();
	}

	//HeadingElement:
	//	{HeadingElement} 'heading' (':' level=INT)? '[' elements+=MarkupElement* ']';
	public HeadingElementElements getHeadingElementAccess() {
		return pHeadingElement;
	}

	public ParserRule getHeadingElementRule() {
		return getHeadingElementAccess().getRule();
	}

	//NewLineElement:
	//	text=NL;
	public NewLineElementElements getNewLineElementAccess() {
		return pNewLineElement;
	}

	public ParserRule getNewLineElementRule() {
		return getNewLineElementAccess().getRule();
	}

	//NullElement:
	//	{NullElement} '[' elements+=MarkupElement* ']';
	public NullElementElements getNullElementAccess() {
		return pNullElement;
	}

	public ParserRule getNullElementRule() {
		return getNullElementAccess().getRule();
	}

	//OCLCodeElement:
	//	{OCLCodeElement} 'oclCode' '[' elements+=MarkupElement* ']';
	public OCLCodeElementElements getOCLCodeElementAccess() {
		return pOCLCodeElement;
	}

	public ParserRule getOCLCodeElementRule() {
		return getOCLCodeElementAccess().getRule();
	}

	//OCLEvalElement:
	//	{OCLEvalElement} 'oclEval' '[' elements+=MarkupElement* ']';
	public OCLEvalElementElements getOCLEvalElementAccess() {
		return pOCLEvalElement;
	}

	public ParserRule getOCLEvalElementRule() {
		return getOCLEvalElementAccess().getRule();
	}

	//OCLTextElement:
	//	{OCLTextElement} 'oclText' '[' elements+=MarkupElement* ']';
	public OCLTextElementElements getOCLTextElementAccess() {
		return pOCLTextElement;
	}

	public ParserRule getOCLTextElementRule() {
		return getOCLTextElementAccess().getRule();
	}

	//TextElement:
	//	text+=(ID | WORD | INT | WS | ':' | '#' | ',')+ | text+=MarkupKeyword;
	public TextElementElements getTextElementAccess() {
		return pTextElement;
	}

	public ParserRule getTextElementRule() {
		return getTextElementAccess().getRule();
	}
}
