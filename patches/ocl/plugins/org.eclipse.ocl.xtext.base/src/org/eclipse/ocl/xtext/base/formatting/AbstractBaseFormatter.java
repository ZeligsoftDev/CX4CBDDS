/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.formatting;

import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess.MultiplicityBoundsCSElements;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess.MultiplicityCSElements;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess.MultiplicityStringCSElements;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess.PathNameCSElements;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess.TemplateBindingCSElements;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess.TemplateSignatureCSElements;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess.TypedTypeRefCSElements;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 */
public abstract class AbstractBaseFormatter extends AbstractDeclarativeFormatter
{
	protected void configureMultiplicityBoundsCS(FormattingConfig c, MultiplicityBoundsCSElements a) {
		c.setNoSpace().around(a.getFullStopFullStopKeyword_1_0());
    }

	protected void configureMultiplicityCS(FormattingConfig c, MultiplicityCSElements a) {
		c.setNoSpace().around(a.getLeftSquareBracketKeyword_0());
		c.setNoSpace().around(a.getVerticalLineQuestionMarkKeyword_2_0());
		c.setNoSpace().around(a.getIsNullFree1Keyword_2_1_0());
		c.setNoSpace().before(a.getRightSquareBracketKeyword_3());
	    c.setIndentation(a.getLeftSquareBracketKeyword_0(), a.getRightSquareBracketKeyword_3());
    }

	protected void configureMultiplicityStringCS(FormattingConfig c, MultiplicityStringCSElements a) {
		c.setNoSpace().around(a.getStringBoundsAsteriskKeyword_0_0());
		c.setNoSpace().around(a.getStringBoundsPlusSignKeyword_0_1());
		c.setNoSpace().around(a.getStringBoundsQuestionMarkKeyword_0_2());
    }

	protected void configurePathNameCS(FormattingConfig c, PathNameCSElements a) {
	    c.setNoSpace().around(a.getColonColonKeyword_1_0());
	}

	protected void configureTemplateBindingCS(FormattingConfig c, TemplateBindingCSElements a) {
//		c.setNoSpace().around(a.getLeftParenthesisKeyword_0());
		c.setNoSpace().before(a.getCommaKeyword_1_0());
//		c.setNoSpace().before(a.getRightParenthesisKeyword_3());
//	    c.setIndentation(a.getLeftParenthesisKeyword_0(), a.getRightParenthesisKeyword_3());
	}

	protected void configureTemplateSignatureCS(FormattingConfig c, TemplateSignatureCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_0());
		c.setNoSpace().before(a.getCommaKeyword_2_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_3());
	    c.setIndentation(a.getLeftParenthesisKeyword_0(), a.getRightParenthesisKeyword_3());
	}

	protected void configureTypedTypeRefCS(FormattingConfig c, TypedTypeRefCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1_0());
//		c.setNoSpace().before(a.getCommaKeyword_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_1_2());
	    c.setIndentation(a.getLeftParenthesisKeyword_1_0(), a.getRightParenthesisKeyword_1_2());
	}

	public void setBraces(FormattingConfig c, Keyword leftBrace, Keyword rightBrace) {
		c.setIndentation(leftBrace, rightBrace);
	    c.setLinewrap().before(leftBrace);
	    c.setLinewrap().after(leftBrace);
	    c.setLinewrap().before(rightBrace);
	    c.setLinewrap().after(rightBrace);
	}

	public void setAppendedBraces(FormattingConfig c, Keyword leftBrace, Keyword rightBrace) {
		c.setIndentation(leftBrace, rightBrace);
	    c.setNoLinewrap().before(leftBrace);
	    c.setLinewrap().after(leftBrace);
	    c.setLinewrap().before(rightBrace);
	    c.setLinewrap().after(rightBrace);
	}

	public void setNoSpaceLineWrap(FormattingConfig c, Keyword semicolon) {
		c.setNoSpace().before(semicolon);
	    c.setLinewrap().after(semicolon);
	}
}
