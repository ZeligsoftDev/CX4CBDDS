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
package org.eclipse.ocl.xtext.oclinecore.formatting;

import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess.TemplateBindingCSElements;
import org.eclipse.ocl.xtext.essentialocl.formatting.AbstractEssentialOCLFormatter;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.AnnotationCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.AttributeCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.DataTypeCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.DocumentationCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.EnumerationCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.EnumerationLiteralCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ImportCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.InvariantConstraintCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ModelElementRefCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.OperationCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.PackageCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ParameterCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.PostconditionConstraintCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.PreconditionConstraintCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ReferenceCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.StructuredClassCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.SysMLCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.TemplateSignatureCSElements;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess.TypedTypeRefCSElements;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 */
public class OCLinEcoreFormatter extends AbstractEssentialOCLFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {

		c.setAutoLinewrap(120);

		OCLinEcoreGrammarAccess f = getGrammarAccess();

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
		configureURIPathNameCS(c, f.getURIPathNameCSAccess());

		c.setLinewrap(2).before(f.getML_COMMENTRule());
		c.setLinewrap(1).after(f.getML_COMMENTRule());

		//	    c.setLinewrap(1).after(f.getTopLevelCSAccess().getNameAssignment_0_1());

		c.setLinewrap(2).between(f.getImportCSRule(), f.getPackageCSRule());
		c.setLinewrap(2).between(f.getPackageCSRule(), f.getPackageCSRule());
		c.setLinewrap(2).between(f.getStructuredClassCSRule(), f.getStructuredClassCSRule());
		c.setLinewrap(2).between(f.getStructuredClassCSRule(), f.getDataTypeCSRule());
		c.setLinewrap(2).between(f.getStructuredClassCSRule(), f.getEnumerationCSRule());
		c.setLinewrap(2).between(f.getDataTypeCSRule(), f.getStructuredClassCSRule());
		c.setLinewrap(2).between(f.getDataTypeCSRule(), f.getDataTypeCSRule());
		c.setLinewrap(2).between(f.getDataTypeCSRule(), f.getEnumerationCSRule());
		c.setLinewrap(2).between(f.getEnumerationCSRule(), f.getStructuredClassCSRule());
		c.setLinewrap(2).between(f.getEnumerationCSRule(), f.getDataTypeCSRule());
		c.setLinewrap(2).between(f.getEnumerationCSRule(), f.getEnumerationCSRule());

		{	// AnnotationCS
			AnnotationCSElements a = f.getAnnotationCSAccess();
			setBraces(c, a.getLeftParenthesisKeyword_3_0(), a.getRightParenthesisKeyword_3_3());
			//			setNoSpaceLineWrap(c, a.getLeftParenthesisKeyword_2_0());
			setNoSpaceLineWrap(c, a.getCommaKeyword_3_2_0());
			//			c.setNoSpace().before(a.getRightParenthesisKeyword_2_3());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_4_0_0(), a.getRightCurlyBracketKeyword_4_0_2());
			//		    c.setIndentation(a.getLeftParenthesisKeyword_2_0(), a.getRightParenthesisKeyword_2_3());
		}
		{	// AttributeCS
			AttributeCSElements a = f.getAttributeCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_5_0(), a.getRightCurlyBracketKeyword_5_2());
			c.setNoSpace().around(a.getCommaKeyword_5_1_1());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_6_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_6_0_0(), a.getRightCurlyBracketKeyword_6_0_2());
			//
			c.setNoSpace().before(a.getColonKeyword_6_0_1_1_2());
			c.setSpace(" ").after(a.getColonKeyword_6_0_1_1_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_6_0_1_1_4());
			c.setIndentation(a.getColonKeyword_6_0_1_1_2(), a.getSemicolonKeyword_6_0_1_1_4());
			//
			c.setNoSpace().before(a.getColonKeyword_6_0_1_1_2());
			c.setSpace(" ").after(a.getColonKeyword_6_0_1_1_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_6_0_1_2_4());
			c.setIndentation(a.getColonKeyword_6_0_1_1_2(), a.getSemicolonKeyword_6_0_1_2_4());
		}
		{
			DataTypeCSElements a = f.getDataTypeCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_5_0(), a.getRightCurlyBracketKeyword_5_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_6_0_0(), a.getRightCurlyBracketKeyword_6_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_6_1());
		}
		{
			DocumentationCSElements a = f.getDocumentationCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_3_0());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
			c.setNoSpace().before(a.getRightParenthesisKeyword_3_3());
			c.setIndentation(a.getLeftParenthesisKeyword_3_0(), a.getRightParenthesisKeyword_3_3());
		}
		{
			EnumerationCSElements a = f.getEnumerationCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_4_0(), a.getRightCurlyBracketKeyword_4_2());
			//			setBraces(c, a.getLeftCurlyBracketKeyword_4_0(), a.getRightCurlyBracketKeyword_4_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_5_0_0(), a.getRightCurlyBracketKeyword_5_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_5_1());
		}
		{
			EnumerationLiteralCSElements a = f.getEnumerationLiteralCSAccess();
			//			c.setNoSpace().around(a.getColonKeyword_1_0());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3_1());
		}
		{
			ImportCSElements a = f.getImportCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			c.setNoSpace().around(a.getIsAllColonColonAsteriskKeyword_3_0());
			c.setNoSpace().before(a.getSemicolonKeyword_4());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
		}
		{
			InvariantConstraintCSElements a = f.getInvariantConstraintCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_2_1_0());
			c.setNoSpace().around(a.getRightParenthesisKeyword_2_1_2());
			c.setNoSpace().around(a.getColonKeyword_3_0_0());
			c.setSpace(" ").before(a.getOwnedSpecificationSpecificationCSParserRuleCall_3_0_1_0());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3_1());
			c.setIndentation(a.getLeftParenthesisKeyword_2_1_0(), a.getRightParenthesisKeyword_2_1_2());
			c.setIndentation(a.getColonKeyword_3_0_0(), a.getSemicolonKeyword_3_0_2());
		}
		{
			ModelElementRefCSElements a = f.getModelElementRefCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_2());
		}
		{
			OperationCSElements a = f.getOperationCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_4());
			c.setNoSpace().before(a.getCommaKeyword_5_1_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_6());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_9_0(), a.getRightCurlyBracketKeyword_9_2());
			c.setNoSpace().around(a.getCommaKeyword_9_1_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_10_0_0(), a.getRightCurlyBracketKeyword_10_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_10_1());
			c.setIndentation(a.getLeftParenthesisKeyword_4(), a.getRightParenthesisKeyword_6());
			//
			c.setNoSpace().before(a.getColonKeyword_10_0_1_2_2());
			c.setSpace(" ").after(a.getColonKeyword_10_0_1_2_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_10_0_1_2_4());
			c.setIndentation(a.getColonKeyword_10_0_1_2_2(), a.getSemicolonKeyword_10_0_1_2_4());
		}
		{
			PackageCSElements a = f.getPackageCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_4_0_0(), a.getRightCurlyBracketKeyword_4_0_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_4_0_0(), a.getRightCurlyBracketKeyword_4_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4_1());
		}
		{
			ParameterCSElements a = f.getParameterCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_2());
			c.setNoSpace().around(a.getCommaKeyword_2_1_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_3_0(), a.getRightCurlyBracketKeyword_3_2());
		}
		{
			PostconditionConstraintCSElements a = f.getPostconditionConstraintCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_1_1_0());
			c.setNoSpace().around(a.getRightParenthesisKeyword_1_1_2());
			c.setNoSpace().around(a.getColonKeyword_2());
			c.setSpace(" ").before(a.getOwnedSpecificationSpecificationCSParserRuleCall_3_0());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
			c.setIndentation(a.getColonKeyword_2(), a.getSemicolonKeyword_4());
		}
		{
			PreconditionConstraintCSElements a = f.getPreconditionConstraintCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_1_1_0());
			c.setNoSpace().around(a.getRightParenthesisKeyword_1_1_2());
			c.setNoSpace().around(a.getColonKeyword_2());
			c.setSpace(" ").before(a.getOwnedSpecificationSpecificationCSParserRuleCall_3_0());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
			c.setIndentation(a.getColonKeyword_2(), a.getSemicolonKeyword_4());
		}
		{
			ReferenceCSElements a = f.getReferenceCSAccess();
			c.setNoSpace().around(a.getNumberSignKeyword_3_0());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_6_0(), a.getRightCurlyBracketKeyword_6_2());
			c.setNoSpace().around(a.getCommaKeyword_6_1_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_7_0_0(), a.getRightCurlyBracketKeyword_7_0_2());
			c.setNoSpace().before(a.getCommaKeyword_7_0_1_1_2_0());
			//
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_0_1_1_3());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_1());
			//
			c.setNoSpace().before(a.getColonKeyword_7_0_1_2_2());
			c.setSpace(" ").after(a.getColonKeyword_7_0_1_2_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_0_1_2_4());
			c.setIndentation(a.getColonKeyword_7_0_1_2_2(), a.getSemicolonKeyword_7_0_1_2_4());
			//
			c.setNoSpace().before(a.getColonKeyword_7_0_1_3_2());
			c.setSpace(" ").after(a.getColonKeyword_7_0_1_3_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_0_1_3_4());
			c.setIndentation(a.getColonKeyword_7_0_1_3_2(), a.getSemicolonKeyword_7_0_1_3_4());
			//
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_0_1_4_1());
		}
		{
			StructuredClassCSElements a = f.getStructuredClassCSAccess();
			c.setNoSpace().around(a.getCommaKeyword_4_2_0());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_6_0(), a.getRightCurlyBracketKeyword_6_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_7_0_0(), a.getRightCurlyBracketKeyword_7_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_1());
		}
		{	// AnnotationCS
			SysMLCSElements a = f.getSysMLCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_2_0_1());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_2_1_1_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_2_1_0(), a.getRightCurlyBracketKeyword_2_1_2());
		}
		{
			TemplateBindingCSElements a = f.getTemplateBindingCSAccess();
			//			c.setNoSpace().around(a.getLeftParenthesisKeyword_0_0());
			c.setNoSpace().before(a.getCommaKeyword_1_0());
			//			c.setNoSpace().before(a.getRightParenthesisKeyword_0_3());
			//		    c.setIndentation(a.getLeftParenthesisKeyword_0_0(), a.getRightParenthesisKeyword_0_3());
			//			c.setNoSpace().around(a.getLessThanSignKeyword_1_0());
			//			c.setNoSpace().before(a.getCommaKeyword_1_2_0());
			//			c.setNoSpace().before(a.getGreaterThanSignKeyword_1_3());
			//		    c.setIndentation(a.getLessThanSignKeyword_1_0(), a.getGreaterThanSignKeyword_1_3());
		}
		{
			TemplateSignatureCSElements a = f.getTemplateSignatureCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_0_0());
			c.setNoSpace().before(a.getCommaKeyword_0_2_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_0_3());
			c.setIndentation(a.getLeftParenthesisKeyword_0_0(), a.getRightParenthesisKeyword_0_3());
			c.setNoSpace().around(a.getLessThanSignKeyword_1_0());
			c.setNoSpace().before(a.getCommaKeyword_1_2_0());
			c.setNoSpace().before(a.getGreaterThanSignKeyword_1_3());
			c.setIndentation(a.getLessThanSignKeyword_1_0(), a.getGreaterThanSignKeyword_1_3());
		}
		{
			TypedTypeRefCSElements a = f.getTypedTypeRefCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_1_0_0());
			//			c.setNoSpace().before(a.getCommaKeyword_1_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_1_0_2());
			c.setIndentation(a.getLeftParenthesisKeyword_1_0_0(), a.getRightParenthesisKeyword_1_0_2());
			c.setNoSpace().around(a.getLessThanSignKeyword_1_1_0());
			//			c.setNoSpace().before(a.getCommaKeyword_1_2_0());
			c.setNoSpace().before(a.getGreaterThanSignKeyword_1_1_2());
			c.setIndentation(a.getLessThanSignKeyword_1_1_0(), a.getGreaterThanSignKeyword_1_1_2());
		}
		{	// comments
			c.setNoLinewrap().before(f.getSL_COMMENTRule());
		}
	}

	@Override
	public OCLinEcoreGrammarAccess getGrammarAccess() {
		return (OCLinEcoreGrammarAccess) super.getGrammarAccess();
	}
}
