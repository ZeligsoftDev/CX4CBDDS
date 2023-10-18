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
package org.eclipse.ocl.xtext.markup.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.eclipse.ocl.xtext.markup.services.MarkupGrammarAccess;

public class MarkupParser extends AbstractContentAssistParser {

	@Inject
	private MarkupGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected org.eclipse.ocl.xtext.markup.ui.contentassist.antlr.internal.InternalMarkupParser createParser() {
		org.eclipse.ocl.xtext.markup.ui.contentassist.antlr.internal.InternalMarkupParser result = new org.eclipse.ocl.xtext.markup.ui.contentassist.antlr.internal.InternalMarkupParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getMarkupKeywordAccess().getAlternatives(), "rule__MarkupKeyword__Alternatives");
					put(grammarAccess.getMarkupElementAccess().getAlternatives(), "rule__MarkupElement__Alternatives");
					put(grammarAccess.getFontElementAccess().getFontAlternatives_0_0(), "rule__FontElement__FontAlternatives_0_0");
					put(grammarAccess.getTextElementAccess().getAlternatives(), "rule__TextElement__Alternatives");
					put(grammarAccess.getTextElementAccess().getTextAlternatives_0_0(), "rule__TextElement__TextAlternatives_0_0");
					put(grammarAccess.getBulletElementAccess().getGroup(), "rule__BulletElement__Group__0");
					put(grammarAccess.getBulletElementAccess().getGroup_2(), "rule__BulletElement__Group_2__0");
					put(grammarAccess.getFontElementAccess().getGroup(), "rule__FontElement__Group__0");
					put(grammarAccess.getFigureElementAccess().getGroup(), "rule__FigureElement__Group__0");
					put(grammarAccess.getFigureElementAccess().getGroup_1(), "rule__FigureElement__Group_1__0");
					put(grammarAccess.getFigureElementAccess().getGroup_4(), "rule__FigureElement__Group_4__0");
					put(grammarAccess.getFigureElementAccess().getGroup_4_2(), "rule__FigureElement__Group_4_2__0");
					put(grammarAccess.getFigureElementAccess().getGroup_4_2_2(), "rule__FigureElement__Group_4_2_2__0");
					put(grammarAccess.getFigureRefElementAccess().getGroup(), "rule__FigureRefElement__Group__0");
					put(grammarAccess.getFootnoteElementAccess().getGroup(), "rule__FootnoteElement__Group__0");
					put(grammarAccess.getHeadingElementAccess().getGroup(), "rule__HeadingElement__Group__0");
					put(grammarAccess.getHeadingElementAccess().getGroup_2(), "rule__HeadingElement__Group_2__0");
					put(grammarAccess.getNullElementAccess().getGroup(), "rule__NullElement__Group__0");
					put(grammarAccess.getOCLCodeElementAccess().getGroup(), "rule__OCLCodeElement__Group__0");
					put(grammarAccess.getOCLEvalElementAccess().getGroup(), "rule__OCLEvalElement__Group__0");
					put(grammarAccess.getOCLTextElementAccess().getGroup(), "rule__OCLTextElement__Group__0");
					put(grammarAccess.getMarkupAccess().getElementsAssignment(), "rule__Markup__ElementsAssignment");
					put(grammarAccess.getBulletElementAccess().getLevelAssignment_2_1(), "rule__BulletElement__LevelAssignment_2_1");
					put(grammarAccess.getBulletElementAccess().getElementsAssignment_4(), "rule__BulletElement__ElementsAssignment_4");
					put(grammarAccess.getFontElementAccess().getFontAssignment_0(), "rule__FontElement__FontAssignment_0");
					put(grammarAccess.getFontElementAccess().getElementsAssignment_2(), "rule__FontElement__ElementsAssignment_2");
					put(grammarAccess.getFigureElementAccess().getDefAssignment_1_1(), "rule__FigureElement__DefAssignment_1_1");
					put(grammarAccess.getFigureElementAccess().getSrcAssignment_3(), "rule__FigureElement__SrcAssignment_3");
					put(grammarAccess.getFigureElementAccess().getAltAssignment_4_1(), "rule__FigureElement__AltAssignment_4_1");
					put(grammarAccess.getFigureElementAccess().getRequiredWidthAssignment_4_2_1(), "rule__FigureElement__RequiredWidthAssignment_4_2_1");
					put(grammarAccess.getFigureElementAccess().getRequiredHeightAssignment_4_2_2_1(), "rule__FigureElement__RequiredHeightAssignment_4_2_2_1");
					put(grammarAccess.getFigureRefElementAccess().getRefAssignment_2(), "rule__FigureRefElement__RefAssignment_2");
					put(grammarAccess.getFootnoteElementAccess().getElementsAssignment_3(), "rule__FootnoteElement__ElementsAssignment_3");
					put(grammarAccess.getHeadingElementAccess().getLevelAssignment_2_1(), "rule__HeadingElement__LevelAssignment_2_1");
					put(grammarAccess.getHeadingElementAccess().getElementsAssignment_4(), "rule__HeadingElement__ElementsAssignment_4");
					put(grammarAccess.getNewLineElementAccess().getTextAssignment(), "rule__NewLineElement__TextAssignment");
					put(grammarAccess.getNullElementAccess().getElementsAssignment_2(), "rule__NullElement__ElementsAssignment_2");
					put(grammarAccess.getOCLCodeElementAccess().getElementsAssignment_3(), "rule__OCLCodeElement__ElementsAssignment_3");
					put(grammarAccess.getOCLEvalElementAccess().getElementsAssignment_3(), "rule__OCLEvalElement__ElementsAssignment_3");
					put(grammarAccess.getOCLTextElementAccess().getElementsAssignment_3(), "rule__OCLTextElement__ElementsAssignment_3");
					put(grammarAccess.getTextElementAccess().getTextAssignment_0(), "rule__TextElement__TextAssignment_0");
					put(grammarAccess.getTextElementAccess().getTextAssignment_1(), "rule__TextElement__TextAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.eclipse.ocl.xtext.markup.ui.contentassist.antlr.internal.InternalMarkupParser typedParser = (org.eclipse.ocl.xtext.markup.ui.contentassist.antlr.internal.InternalMarkupParser) parser;
			typedParser.entryRuleMarkup();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] {  };
	}

	public MarkupGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(MarkupGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
