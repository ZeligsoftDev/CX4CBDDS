/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.formatting;

//import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.IndexExpCSElements;
//import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.NavigatingExpCSElements;
import org.eclipse.ocl.xtext.base.formatting.BaseFormatter;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.CollectionLiteralExpCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.CollectionTypeCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.CurlyBracketedClauseCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.ElseIfThenExpCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.EssentialOCLNavigationOperatorNameElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.ExpCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.IfExpCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.LetExpCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.MapLiteralExpCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.MapTypeCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.NameExpCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.NavigatingCommaArgCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.NavigatingSemiArgCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.NestedExpCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.PrimaryExpCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.RoundBracketedClauseCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.SquareBracketedClauseCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.TupleLiteralExpCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.TupleTypeCSElements;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess.URIPathNameCSElements;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 */
public abstract class AbstractEssentialOCLFormatter extends BaseFormatter
{
	protected void configureCollectionLiteralExpCS(FormattingConfig c, CollectionLiteralExpCSElements a) {
		c.setNoSpace().around(a.getLeftCurlyBracketKeyword_1());
		c.setNoSpace().before(a.getCommaKeyword_2_1_0());
		c.setNoSpace().before(a.getRightCurlyBracketKeyword_3());
		c.setIndentation(a.getLeftCurlyBracketKeyword_1(), a.getRightCurlyBracketKeyword_3());
	}

	protected void configureCollectionTypeCS(FormattingConfig c, CollectionTypeCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_1_3());
	}

	protected void configureCurlyBracketedClauseCS(FormattingConfig c, CurlyBracketedClauseCSElements a) {
		c.setNoSpace().around(a.getLeftCurlyBracketKeyword_1());
		c.setNoSpace().before(a.getCommaKeyword_2_1_0());
		c.setNoSpace().before(a.getRightCurlyBracketKeyword_3());
		c.setIndentation(a.getLeftCurlyBracketKeyword_1(), a.getRightCurlyBracketKeyword_3());
	}

	protected void configureEssentialOCLNavigationOperatorCS(FormattingConfig c, EssentialOCLNavigationOperatorNameElements a) {
		c.setNoSpace().before(a.getFullStopKeyword_0());
		c.setNoSpace().after(a.getFullStopKeyword_0());
		c.setLinewrap().before(a.getHyphenMinusGreaterThanSignKeyword_1());
		c.setNoSpace().after(a.getHyphenMinusGreaterThanSignKeyword_1());
	}

	protected void configureExpCS(FormattingConfig c, ExpCSElements a) {
		c.setNoSpace().around(a.getNameAssignment_0_1_1());		// BaseValueConverterService.BinaryOperatorNameConverter wraps spaces
	}

	protected void configureIfExpCS(FormattingConfig c, IfExpCSElements a) {
		c.setLinewrap().after(a.getOwnedConditionAssignment_1());
		c.setLinewrap().after(a.getOwnedThenExpressionAssignment_3());
		c.setLinewrap().after(a.getOwnedElseExpressionAssignment_6());
		c.setIndentation(a.getIfKeyword_0(), a.getThenKeyword_2());
		c.setIndentation(a.getThenKeyword_2(), a.getOwnedThenExpressionAssignment_3());
		c.setIndentation(a.getElseKeyword_5(), a.getEndifKeyword_7());
	}

	protected void configureElseIfThenExpCS(FormattingConfig c, ElseIfThenExpCSElements a) {
		c.setLinewrap().after(a.getOwnedConditionAssignment_1());
		c.setLinewrap().after(a.getOwnedThenExpressionAssignment_3());
		c.setIndentation(a.getElseifKeyword_0(), a.getThenKeyword_2());
		c.setIndentation(a.getThenKeyword_2(), a.getOwnedThenExpressionAssignment_3());
	}

	protected void configureLetExpCS(FormattingConfig c, LetExpCSElements a) {
		c.setIndentation(a.getLetKeyword_0(), a.getInKeyword_3());
		c.setLinewrap().before(a.getLetKeyword_0());
		c.setLinewrap().before(a.getInKeyword_3());
		c.setIndentation(a.getInKeyword_3(), a.getGroup());
	}

	protected void configureMapLiteralExpCS(FormattingConfig c, MapLiteralExpCSElements a) {
		c.setNoSpace().around(a.getLeftCurlyBracketKeyword_1());
		c.setNoSpace().before(a.getCommaKeyword_2_1_0());
		c.setNoSpace().before(a.getRightCurlyBracketKeyword_3());
		c.setIndentation(a.getLeftCurlyBracketKeyword_1(), a.getRightCurlyBracketKeyword_3());
	}

	protected void configureMapTypeCS(FormattingConfig c, MapTypeCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1_0());
		c.setNoSpace().before(a.getCommaKeyword_1_2());
		c.setNoSpace().before(a.getRightParenthesisKeyword_1_4());
	}

	protected void configureNameExpCS(FormattingConfig c, NameExpCSElements a) {
		c.setNoSpace().after(a.getIsPreCommercialAtKeyword_4_0_0());
	}

	protected void configureNavigatingCommaArgCS(FormattingConfig c, NavigatingCommaArgCSElements a) {
		c.setNoSpace().before(a.getPrefixCommaKeyword_0_0());
	}

	protected void configureNavigatingSemiArgCS(FormattingConfig c, NavigatingSemiArgCSElements a) {
		c.setNoSpace().before(a.getPrefixSemicolonKeyword_0_0());
	}

	protected void configureNestedExpCS(FormattingConfig c, NestedExpCSElements a) {
		c.setNoSpace().after(a.getLeftParenthesisKeyword_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_2());
	}

	protected void configurePrimaryExpCS(FormattingConfig c, PrimaryExpCSElements a) {
	}

	protected void configureRoundBracketedClauseCS(FormattingConfig c, RoundBracketedClauseCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1());
		c.setNoSpace().before(a.getRightParenthesisKeyword_3());
		c.setIndentation(a.getLeftParenthesisKeyword_1(), a.getRightParenthesisKeyword_3());
	}

	protected void configureSquareBracketedClauseCS(FormattingConfig c, SquareBracketedClauseCSElements a) {
		c.setNoSpace().around(a.getLeftSquareBracketKeyword_0());
		c.setNoSpace().before(a.getCommaKeyword_2_0());
		c.setNoSpace().before(a.getRightSquareBracketKeyword_3());
	}

	protected void configureTupleLiteralExpCS(FormattingConfig c, TupleLiteralExpCSElements a) {
		c.setNoSpace().around(a.getLeftCurlyBracketKeyword_1());
		c.setNoSpace().before(a.getCommaKeyword_3_0());
		c.setNoSpace().before(a.getRightCurlyBracketKeyword_4());
		c.setIndentation(a.getLeftCurlyBracketKeyword_1(), a.getRightCurlyBracketKeyword_4());
	}

	protected void configureTupleTypeCS(FormattingConfig c, TupleTypeCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1_0());
		c.setNoSpace().before(a.getCommaKeyword_1_1_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_1_2());
		c.setIndentation(a.getLeftParenthesisKeyword_1_0(), a.getRightParenthesisKeyword_1_2());
	}

	protected void configureURIPathNameCS(FormattingConfig c, URIPathNameCSElements a) {
		c.setNoSpace().around(a.getColonColonKeyword_1_0());
	}
}
