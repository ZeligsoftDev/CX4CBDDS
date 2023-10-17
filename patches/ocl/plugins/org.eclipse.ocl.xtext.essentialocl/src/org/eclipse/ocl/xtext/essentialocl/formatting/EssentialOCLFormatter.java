/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.formatting;

import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 */
public class EssentialOCLFormatter extends AbstractEssentialOCLFormatter
{
	@Override
	protected void configureFormatting(FormattingConfig c) {

		c.setAutoLinewrap(120);

		EssentialOCLGrammarAccess f = (EssentialOCLGrammarAccess)getGrammarAccess();
		configureCollectionLiteralExpCS(c, f.getCollectionLiteralExpCSAccess());
		configureCollectionTypeCS(c, f.getCollectionTypeCSAccess());
		configureCurlyBracketedClauseCS(c, f.getCurlyBracketedClauseCSAccess());
		configureElseIfThenExpCS(c, f.getElseIfThenExpCSAccess());
		configureEssentialOCLNavigationOperatorCS(c, f.getEssentialOCLNavigationOperatorNameAccess());
		configureExpCS(c, f.getExpCSAccess());
		configureIfExpCS(c, f.getIfExpCSAccess());
		configureLetExpCS(c, f.getLetExpCSAccess());
		configureMapLiteralExpCS(c, f.getMapLiteralExpCSAccess());
		configureMapTypeCS(c, f.getMapTypeCSAccess());
		configureMultiplicityBoundsCS(c, f.getMultiplicityBoundsCSAccess());
		configureMultiplicityCS(c, f.getMultiplicityCSAccess());
		configureMultiplicityStringCS(c, f.getMultiplicityStringCSAccess());
		configureNameExpCS(c, f.getNameExpCSAccess());
		configureNavigatingCommaArgCS(c, f.getNavigatingCommaArgCSAccess());
		configureNavigatingSemiArgCS(c, f.getNavigatingSemiArgCSAccess());
		configureNestedExpCS(c, f.getNestedExpCSAccess());
		configurePathNameCS(c, f.getPathNameCSAccess());
		configurePrimaryExpCS(c, f.getPrimaryExpCSAccess());
		configureRoundBracketedClauseCS(c, f.getRoundBracketedClauseCSAccess());
		configureSquareBracketedClauseCS(c, f.getSquareBracketedClauseCSAccess());
		configureTupleLiteralExpCS(c, f.getTupleLiteralExpCSAccess());
		configureTupleTypeCS(c, f.getTupleTypeCSAccess());
		configureTypedTypeRefCS(c, f.getTypedTypeRefCSAccess());
		configureURIPathNameCS(c, f.getURIPathNameCSAccess());
	}
}
