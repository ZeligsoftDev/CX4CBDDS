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
package org.eclipse.ocl.xtext.essentialocl.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;

public class EssentialOCLParser extends AbstractContentAssistParser {

	@Inject
	private EssentialOCLGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected org.eclipse.ocl.xtext.essentialocl.ui.contentassist.antlr.internal.InternalEssentialOCLParser createParser() {
		org.eclipse.ocl.xtext.essentialocl.ui.contentassist.antlr.internal.InternalEssentialOCLParser result = new org.eclipse.ocl.xtext.essentialocl.ui.contentassist.antlr.internal.InternalEssentialOCLParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getEssentialOCLReservedKeywordAccess().getAlternatives(), "rule__EssentialOCLReservedKeyword__Alternatives");
					put(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getAlternatives(), "rule__EssentialOCLUnaryOperatorName__Alternatives");
					put(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAlternatives(), "rule__EssentialOCLInfixOperatorName__Alternatives");
					put(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getAlternatives(), "rule__EssentialOCLNavigationOperatorName__Alternatives");
					put(grammarAccess.getBinaryOperatorNameAccess().getAlternatives(), "rule__BinaryOperatorName__Alternatives");
					put(grammarAccess.getEssentialOCLUnreservedNameAccess().getAlternatives(), "rule__EssentialOCLUnreservedName__Alternatives");
					put(grammarAccess.getURIFirstPathElementCSAccess().getAlternatives(), "rule__URIFirstPathElementCS__Alternatives");
					put(grammarAccess.getPrimitiveTypeIdentifierAccess().getAlternatives(), "rule__PrimitiveTypeIdentifier__Alternatives");
					put(grammarAccess.getCollectionTypeIdentifierAccess().getAlternatives(), "rule__CollectionTypeIdentifier__Alternatives");
					put(grammarAccess.getCollectionLiteralPartCSAccess().getAlternatives(), "rule__CollectionLiteralPartCS__Alternatives");
					put(grammarAccess.getShadowPartCSAccess().getAlternatives(), "rule__ShadowPartCS__Alternatives");
					put(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAlternatives_0_2_0(), "rule__ShadowPartCS__OwnedInitExpressionAlternatives_0_2_0");
					put(grammarAccess.getMapLiteralPartCSAccess().getAlternatives_1(), "rule__MapLiteralPartCS__Alternatives_1");
					put(grammarAccess.getPrimitiveLiteralExpCSAccess().getAlternatives(), "rule__PrimitiveLiteralExpCS__Alternatives");
					put(grammarAccess.getBooleanLiteralExpCSAccess().getAlternatives(), "rule__BooleanLiteralExpCS__Alternatives");
					put(grammarAccess.getTypeLiteralCSAccess().getAlternatives(), "rule__TypeLiteralCS__Alternatives");
					put(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getAlternatives(), "rule__TypeExpWithoutMultiplicityCS__Alternatives");
					put(grammarAccess.getExpCSAccess().getAlternatives(), "rule__ExpCS__Alternatives");
					put(grammarAccess.getPrefixedLetExpCSAccess().getAlternatives(), "rule__PrefixedLetExpCS__Alternatives");
					put(grammarAccess.getPrefixedPrimaryExpCSAccess().getAlternatives(), "rule__PrefixedPrimaryExpCS__Alternatives");
					put(grammarAccess.getPrimaryExpCSAccess().getAlternatives(), "rule__PrimaryExpCS__Alternatives");
					put(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAlternatives_2_1_0(), "rule__RoundBracketedClauseCS__OwnedArgumentsAlternatives_2_1_0");
					put(grammarAccess.getNavigatingArgCSAccess().getAlternatives(), "rule__NavigatingArgCS__Alternatives");
					put(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1(), "rule__NavigatingArgCS__Alternatives_0_1");
					put(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1_0_0(), "rule__NavigatingArgCS__Alternatives_0_1_0_0");
					put(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1_1_2_0(), "rule__NavigatingArgCS__Alternatives_0_1_1_2_0");
					put(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1_2_1_0(), "rule__NavigatingArgCS__Alternatives_0_1_2_1_0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2(), "rule__NavigatingCommaArgCS__Alternatives_2");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2_0_0(), "rule__NavigatingCommaArgCS__Alternatives_2_0_0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2_1_2_0(), "rule__NavigatingCommaArgCS__Alternatives_2_1_2_0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2_2_1_0(), "rule__NavigatingCommaArgCS__Alternatives_2_2_1_0");
					put(grammarAccess.getIfExpCSAccess().getOwnedConditionAlternatives_1_0(), "rule__IfExpCS__OwnedConditionAlternatives_1_0");
					put(grammarAccess.getMultiplicityCSAccess().getAlternatives_1(), "rule__MultiplicityCS__Alternatives_1");
					put(grammarAccess.getMultiplicityCSAccess().getAlternatives_2(), "rule__MultiplicityCS__Alternatives_2");
					put(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0(), "rule__MultiplicityStringCS__StringBoundsAlternatives_0");
					put(grammarAccess.getTypeRefCSAccess().getAlternatives(), "rule__TypeRefCS__Alternatives");
					put(grammarAccess.getIDAccess().getAlternatives(), "rule__ID__Alternatives");
					put(grammarAccess.getUPPERAccess().getAlternatives(), "rule__UPPER__Alternatives");
					put(grammarAccess.getURIPathNameCSAccess().getGroup(), "rule__URIPathNameCS__Group__0");
					put(grammarAccess.getURIPathNameCSAccess().getGroup_1(), "rule__URIPathNameCS__Group_1__0");
					put(grammarAccess.getURIFirstPathElementCSAccess().getGroup_1(), "rule__URIFirstPathElementCS__Group_1__0");
					put(grammarAccess.getCollectionTypeCSAccess().getGroup(), "rule__CollectionTypeCS__Group__0");
					put(grammarAccess.getCollectionTypeCSAccess().getGroup_1(), "rule__CollectionTypeCS__Group_1__0");
					put(grammarAccess.getMapTypeCSAccess().getGroup(), "rule__MapTypeCS__Group__0");
					put(grammarAccess.getMapTypeCSAccess().getGroup_1(), "rule__MapTypeCS__Group_1__0");
					put(grammarAccess.getTupleTypeCSAccess().getGroup(), "rule__TupleTypeCS__Group__0");
					put(grammarAccess.getTupleTypeCSAccess().getGroup_1(), "rule__TupleTypeCS__Group_1__0");
					put(grammarAccess.getTupleTypeCSAccess().getGroup_1_1(), "rule__TupleTypeCS__Group_1_1__0");
					put(grammarAccess.getTupleTypeCSAccess().getGroup_1_1_1(), "rule__TupleTypeCS__Group_1_1_1__0");
					put(grammarAccess.getTuplePartCSAccess().getGroup(), "rule__TuplePartCS__Group__0");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getGroup(), "rule__CollectionLiteralExpCS__Group__0");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2(), "rule__CollectionLiteralExpCS__Group_2__0");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2_1(), "rule__CollectionLiteralExpCS__Group_2_1__0");
					put(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_0(), "rule__CollectionLiteralPartCS__Group_0__0");
					put(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_0_1(), "rule__CollectionLiteralPartCS__Group_0_1__0");
					put(grammarAccess.getCollectionPatternCSAccess().getGroup(), "rule__CollectionPatternCS__Group__0");
					put(grammarAccess.getCollectionPatternCSAccess().getGroup_2(), "rule__CollectionPatternCS__Group_2__0");
					put(grammarAccess.getCollectionPatternCSAccess().getGroup_2_1(), "rule__CollectionPatternCS__Group_2_1__0");
					put(grammarAccess.getCollectionPatternCSAccess().getGroup_2_2(), "rule__CollectionPatternCS__Group_2_2__0");
					put(grammarAccess.getShadowPartCSAccess().getGroup_0(), "rule__ShadowPartCS__Group_0__0");
					put(grammarAccess.getPatternExpCSAccess().getGroup(), "rule__PatternExpCS__Group__0");
					put(grammarAccess.getLambdaLiteralExpCSAccess().getGroup(), "rule__LambdaLiteralExpCS__Group__0");
					put(grammarAccess.getMapLiteralExpCSAccess().getGroup(), "rule__MapLiteralExpCS__Group__0");
					put(grammarAccess.getMapLiteralExpCSAccess().getGroup_2(), "rule__MapLiteralExpCS__Group_2__0");
					put(grammarAccess.getMapLiteralExpCSAccess().getGroup_2_1(), "rule__MapLiteralExpCS__Group_2_1__0");
					put(grammarAccess.getMapLiteralPartCSAccess().getGroup(), "rule__MapLiteralPartCS__Group__0");
					put(grammarAccess.getTupleLiteralExpCSAccess().getGroup(), "rule__TupleLiteralExpCS__Group__0");
					put(grammarAccess.getTupleLiteralExpCSAccess().getGroup_3(), "rule__TupleLiteralExpCS__Group_3__0");
					put(grammarAccess.getTupleLiteralPartCSAccess().getGroup(), "rule__TupleLiteralPartCS__Group__0");
					put(grammarAccess.getTupleLiteralPartCSAccess().getGroup_1(), "rule__TupleLiteralPartCS__Group_1__0");
					put(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getGroup(), "rule__UnlimitedNaturalLiteralExpCS__Group__0");
					put(grammarAccess.getInvalidLiteralExpCSAccess().getGroup(), "rule__InvalidLiteralExpCS__Group__0");
					put(grammarAccess.getNullLiteralExpCSAccess().getGroup(), "rule__NullLiteralExpCS__Group__0");
					put(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getGroup(), "rule__TypeLiteralWithMultiplicityCS__Group__0");
					put(grammarAccess.getTypeNameExpCSAccess().getGroup(), "rule__TypeNameExpCS__Group__0");
					put(grammarAccess.getTypeNameExpCSAccess().getGroup_1(), "rule__TypeNameExpCS__Group_1__0");
					put(grammarAccess.getTypeNameExpCSAccess().getGroup_1_1(), "rule__TypeNameExpCS__Group_1_1__0");
					put(grammarAccess.getTypeExpCSAccess().getGroup(), "rule__TypeExpCS__Group__0");
					put(grammarAccess.getExpCSAccess().getGroup_0(), "rule__ExpCS__Group_0__0");
					put(grammarAccess.getExpCSAccess().getGroup_0_1(), "rule__ExpCS__Group_0_1__0");
					put(grammarAccess.getPrefixedLetExpCSAccess().getGroup_0(), "rule__PrefixedLetExpCS__Group_0__0");
					put(grammarAccess.getPrefixedPrimaryExpCSAccess().getGroup_0(), "rule__PrefixedPrimaryExpCS__Group_0__0");
					put(grammarAccess.getNameExpCSAccess().getGroup(), "rule__NameExpCS__Group__0");
					put(grammarAccess.getNameExpCSAccess().getGroup_4(), "rule__NameExpCS__Group_4__0");
					put(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup(), "rule__CurlyBracketedClauseCS__Group__0");
					put(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup_2(), "rule__CurlyBracketedClauseCS__Group_2__0");
					put(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup_2_1(), "rule__CurlyBracketedClauseCS__Group_2_1__0");
					put(grammarAccess.getRoundBracketedClauseCSAccess().getGroup(), "rule__RoundBracketedClauseCS__Group__0");
					put(grammarAccess.getRoundBracketedClauseCSAccess().getGroup_2(), "rule__RoundBracketedClauseCS__Group_2__0");
					put(grammarAccess.getSquareBracketedClauseCSAccess().getGroup(), "rule__SquareBracketedClauseCS__Group__0");
					put(grammarAccess.getSquareBracketedClauseCSAccess().getGroup_2(), "rule__SquareBracketedClauseCS__Group_2__0");
					put(grammarAccess.getNavigatingArgCSAccess().getGroup_0(), "rule__NavigatingArgCS__Group_0__0");
					put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_0(), "rule__NavigatingArgCS__Group_0_1_0__0");
					put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_0_2(), "rule__NavigatingArgCS__Group_0_1_0_2__0");
					put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_1(), "rule__NavigatingArgCS__Group_0_1_1__0");
					put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_1_2(), "rule__NavigatingArgCS__Group_0_1_1_2__0");
					put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_1_3(), "rule__NavigatingArgCS__Group_0_1_1_3__0");
					put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_2(), "rule__NavigatingArgCS__Group_0_1_2__0");
					put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_2_0(), "rule__NavigatingArgCS__Group_0_1_2_0__0");
					put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_2_1(), "rule__NavigatingArgCS__Group_0_1_2_1__0");
					put(grammarAccess.getNavigatingArgCSAccess().getGroup_1(), "rule__NavigatingArgCS__Group_1__0");
					put(grammarAccess.getNavigatingBarArgCSAccess().getGroup(), "rule__NavigatingBarArgCS__Group__0");
					put(grammarAccess.getNavigatingBarArgCSAccess().getGroup_2(), "rule__NavigatingBarArgCS__Group_2__0");
					put(grammarAccess.getNavigatingBarArgCSAccess().getGroup_2_2(), "rule__NavigatingBarArgCS__Group_2_2__0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup(), "rule__NavigatingCommaArgCS__Group__0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_0(), "rule__NavigatingCommaArgCS__Group_2_0__0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_0_2(), "rule__NavigatingCommaArgCS__Group_2_0_2__0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_1(), "rule__NavigatingCommaArgCS__Group_2_1__0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_1_2(), "rule__NavigatingCommaArgCS__Group_2_1_2__0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_1_3(), "rule__NavigatingCommaArgCS__Group_2_1_3__0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_2(), "rule__NavigatingCommaArgCS__Group_2_2__0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_2_0(), "rule__NavigatingCommaArgCS__Group_2_2_0__0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_2_1(), "rule__NavigatingCommaArgCS__Group_2_2_1__0");
					put(grammarAccess.getNavigatingSemiArgCSAccess().getGroup(), "rule__NavigatingSemiArgCS__Group__0");
					put(grammarAccess.getNavigatingSemiArgCSAccess().getGroup_2(), "rule__NavigatingSemiArgCS__Group_2__0");
					put(grammarAccess.getNavigatingSemiArgCSAccess().getGroup_2_2(), "rule__NavigatingSemiArgCS__Group_2_2__0");
					put(grammarAccess.getCoIteratorVariableCSAccess().getGroup(), "rule__CoIteratorVariableCS__Group__0");
					put(grammarAccess.getCoIteratorVariableCSAccess().getGroup_1(), "rule__CoIteratorVariableCS__Group_1__0");
					put(grammarAccess.getIfExpCSAccess().getGroup(), "rule__IfExpCS__Group__0");
					put(grammarAccess.getElseIfThenExpCSAccess().getGroup(), "rule__ElseIfThenExpCS__Group__0");
					put(grammarAccess.getLetExpCSAccess().getGroup(), "rule__LetExpCS__Group__0");
					put(grammarAccess.getLetExpCSAccess().getGroup_2(), "rule__LetExpCS__Group_2__0");
					put(grammarAccess.getLetVariableCSAccess().getGroup(), "rule__LetVariableCS__Group__0");
					put(grammarAccess.getLetVariableCSAccess().getGroup_2(), "rule__LetVariableCS__Group_2__0");
					put(grammarAccess.getNestedExpCSAccess().getGroup(), "rule__NestedExpCS__Group__0");
					put(grammarAccess.getSelfExpCSAccess().getGroup(), "rule__SelfExpCS__Group__0");
					put(grammarAccess.getMultiplicityBoundsCSAccess().getGroup(), "rule__MultiplicityBoundsCS__Group__0");
					put(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1(), "rule__MultiplicityBoundsCS__Group_1__0");
					put(grammarAccess.getMultiplicityCSAccess().getGroup(), "rule__MultiplicityCS__Group__0");
					put(grammarAccess.getPathNameCSAccess().getGroup(), "rule__PathNameCS__Group__0");
					put(grammarAccess.getPathNameCSAccess().getGroup_1(), "rule__PathNameCS__Group_1__0");
					put(grammarAccess.getUnreservedPathNameCSAccess().getGroup(), "rule__UnreservedPathNameCS__Group__0");
					put(grammarAccess.getUnreservedPathNameCSAccess().getGroup_1(), "rule__UnreservedPathNameCS__Group_1__0");
					put(grammarAccess.getTemplateBindingCSAccess().getGroup(), "rule__TemplateBindingCS__Group__0");
					put(grammarAccess.getTemplateBindingCSAccess().getGroup_1(), "rule__TemplateBindingCS__Group_1__0");
					put(grammarAccess.getTemplateSignatureCSAccess().getGroup(), "rule__TemplateSignatureCS__Group__0");
					put(grammarAccess.getTemplateSignatureCSAccess().getGroup_2(), "rule__TemplateSignatureCS__Group_2__0");
					put(grammarAccess.getTypeParameterCSAccess().getGroup(), "rule__TypeParameterCS__Group__0");
					put(grammarAccess.getTypeParameterCSAccess().getGroup_1(), "rule__TypeParameterCS__Group_1__0");
					put(grammarAccess.getTypeParameterCSAccess().getGroup_1_2(), "rule__TypeParameterCS__Group_1_2__0");
					put(grammarAccess.getTypedTypeRefCSAccess().getGroup(), "rule__TypedTypeRefCS__Group__0");
					put(grammarAccess.getTypedTypeRefCSAccess().getGroup_1(), "rule__TypedTypeRefCS__Group_1__0");
					put(grammarAccess.getWildcardTypeRefCSAccess().getGroup(), "rule__WildcardTypeRefCS__Group__0");
					put(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2(), "rule__WildcardTypeRefCS__Group_2__0");
					put(grammarAccess.getModelAccess().getOwnedExpressionAssignment(), "rule__Model__OwnedExpressionAssignment");
					put(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsAssignment_0(), "rule__URIPathNameCS__OwnedPathElementsAssignment_0");
					put(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsAssignment_1_1(), "rule__URIPathNameCS__OwnedPathElementsAssignment_1_1");
					put(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementAssignment_0(), "rule__URIFirstPathElementCS__ReferredElementAssignment_0");
					put(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementAssignment_1_1(), "rule__URIFirstPathElementCS__ReferredElementAssignment_1_1");
					put(grammarAccess.getSimplePathNameCSAccess().getOwnedPathElementsAssignment(), "rule__SimplePathNameCS__OwnedPathElementsAssignment");
					put(grammarAccess.getPrimitiveTypeCSAccess().getNameAssignment(), "rule__PrimitiveTypeCS__NameAssignment");
					put(grammarAccess.getCollectionTypeCSAccess().getNameAssignment_0(), "rule__CollectionTypeCS__NameAssignment_0");
					put(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeAssignment_1_1(), "rule__CollectionTypeCS__OwnedTypeAssignment_1_1");
					put(grammarAccess.getCollectionTypeCSAccess().getOwnedCollectionMultiplicityAssignment_1_2(), "rule__CollectionTypeCS__OwnedCollectionMultiplicityAssignment_1_2");
					put(grammarAccess.getMapTypeCSAccess().getNameAssignment_0(), "rule__MapTypeCS__NameAssignment_0");
					put(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeAssignment_1_1(), "rule__MapTypeCS__OwnedKeyTypeAssignment_1_1");
					put(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeAssignment_1_3(), "rule__MapTypeCS__OwnedValueTypeAssignment_1_3");
					put(grammarAccess.getTupleTypeCSAccess().getNameAssignment_0(), "rule__TupleTypeCS__NameAssignment_0");
					put(grammarAccess.getTupleTypeCSAccess().getOwnedPartsAssignment_1_1_0(), "rule__TupleTypeCS__OwnedPartsAssignment_1_1_0");
					put(grammarAccess.getTupleTypeCSAccess().getOwnedPartsAssignment_1_1_1_1(), "rule__TupleTypeCS__OwnedPartsAssignment_1_1_1_1");
					put(grammarAccess.getTuplePartCSAccess().getNameAssignment_0(), "rule__TuplePartCS__NameAssignment_0");
					put(grammarAccess.getTuplePartCSAccess().getOwnedTypeAssignment_2(), "rule__TuplePartCS__OwnedTypeAssignment_2");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeAssignment_0(), "rule__CollectionLiteralExpCS__OwnedTypeAssignment_0");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsAssignment_2_0(), "rule__CollectionLiteralExpCS__OwnedPartsAssignment_2_0");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsAssignment_2_1_1(), "rule__CollectionLiteralExpCS__OwnedPartsAssignment_2_1_1");
					put(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionAssignment_0_0(), "rule__CollectionLiteralPartCS__OwnedExpressionAssignment_0_0");
					put(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionAssignment_0_1_1(), "rule__CollectionLiteralPartCS__OwnedLastExpressionAssignment_0_1_1");
					put(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionAssignment_1(), "rule__CollectionLiteralPartCS__OwnedExpressionAssignment_1");
					put(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeAssignment_0(), "rule__CollectionPatternCS__OwnedTypeAssignment_0");
					put(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsAssignment_2_0(), "rule__CollectionPatternCS__OwnedPartsAssignment_2_0");
					put(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsAssignment_2_1_1(), "rule__CollectionPatternCS__OwnedPartsAssignment_2_1_1");
					put(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameAssignment_2_2_1(), "rule__CollectionPatternCS__RestVariableNameAssignment_2_2_1");
					put(grammarAccess.getShadowPartCSAccess().getReferredPropertyAssignment_0_0(), "rule__ShadowPartCS__ReferredPropertyAssignment_0_0");
					put(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAssignment_0_2(), "rule__ShadowPartCS__OwnedInitExpressionAssignment_0_2");
					put(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAssignment_1(), "rule__ShadowPartCS__OwnedInitExpressionAssignment_1");
					put(grammarAccess.getPatternExpCSAccess().getPatternVariableNameAssignment_0(), "rule__PatternExpCS__PatternVariableNameAssignment_0");
					put(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeAssignment_2(), "rule__PatternExpCS__OwnedPatternTypeAssignment_2");
					put(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSAssignment_2(), "rule__LambdaLiteralExpCS__OwnedExpressionCSAssignment_2");
					put(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeAssignment_0(), "rule__MapLiteralExpCS__OwnedTypeAssignment_0");
					put(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsAssignment_2_0(), "rule__MapLiteralExpCS__OwnedPartsAssignment_2_0");
					put(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsAssignment_2_1_1(), "rule__MapLiteralExpCS__OwnedPartsAssignment_2_1_1");
					put(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyAssignment_0(), "rule__MapLiteralPartCS__OwnedKeyAssignment_0");
					put(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueAssignment_2(), "rule__MapLiteralPartCS__OwnedValueAssignment_2");
					put(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsAssignment_2(), "rule__TupleLiteralExpCS__OwnedPartsAssignment_2");
					put(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsAssignment_3_1(), "rule__TupleLiteralExpCS__OwnedPartsAssignment_3_1");
					put(grammarAccess.getTupleLiteralPartCSAccess().getNameAssignment_0(), "rule__TupleLiteralPartCS__NameAssignment_0");
					put(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeAssignment_1_1(), "rule__TupleLiteralPartCS__OwnedTypeAssignment_1_1");
					put(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionAssignment_3(), "rule__TupleLiteralPartCS__OwnedInitExpressionAssignment_3");
					put(grammarAccess.getNumberLiteralExpCSAccess().getSymbolAssignment(), "rule__NumberLiteralExpCS__SymbolAssignment");
					put(grammarAccess.getStringLiteralExpCSAccess().getSegmentsAssignment(), "rule__StringLiteralExpCS__SegmentsAssignment");
					put(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolAssignment_0(), "rule__BooleanLiteralExpCS__SymbolAssignment_0");
					put(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolAssignment_1(), "rule__BooleanLiteralExpCS__SymbolAssignment_1");
					put(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityAssignment_1(), "rule__TypeLiteralWithMultiplicityCS__OwnedMultiplicityAssignment_1");
					put(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeAssignment(), "rule__TypeLiteralExpCS__OwnedTypeAssignment");
					put(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNameAssignment_0(), "rule__TypeNameExpCS__OwnedPathNameAssignment_0");
					put(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseAssignment_1_0(), "rule__TypeNameExpCS__OwnedCurlyBracketedClauseAssignment_1_0");
					put(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardAssignment_1_1_1(), "rule__TypeNameExpCS__OwnedPatternGuardAssignment_1_1_1");
					put(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityAssignment_1(), "rule__TypeExpCS__OwnedMultiplicityAssignment_1");
					put(grammarAccess.getExpCSAccess().getNameAssignment_0_1_1(), "rule__ExpCS__NameAssignment_0_1_1");
					put(grammarAccess.getExpCSAccess().getOwnedRightAssignment_0_1_2(), "rule__ExpCS__OwnedRightAssignment_0_1_2");
					put(grammarAccess.getPrefixedLetExpCSAccess().getNameAssignment_0_1(), "rule__PrefixedLetExpCS__NameAssignment_0_1");
					put(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightAssignment_0_2(), "rule__PrefixedLetExpCS__OwnedRightAssignment_0_2");
					put(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameAssignment_0_1(), "rule__PrefixedPrimaryExpCS__NameAssignment_0_1");
					put(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightAssignment_0_2(), "rule__PrefixedPrimaryExpCS__OwnedRightAssignment_0_2");
					put(grammarAccess.getNameExpCSAccess().getOwnedPathNameAssignment_0(), "rule__NameExpCS__OwnedPathNameAssignment_0");
					put(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesAssignment_1(), "rule__NameExpCS__OwnedSquareBracketedClausesAssignment_1");
					put(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseAssignment_2(), "rule__NameExpCS__OwnedRoundBracketedClauseAssignment_2");
					put(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseAssignment_3(), "rule__NameExpCS__OwnedCurlyBracketedClauseAssignment_3");
					put(grammarAccess.getNameExpCSAccess().getIsPreAssignment_4_0(), "rule__NameExpCS__IsPreAssignment_4_0");
					put(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsAssignment_2_0(), "rule__CurlyBracketedClauseCS__OwnedPartsAssignment_2_0");
					put(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsAssignment_2_1_1(), "rule__CurlyBracketedClauseCS__OwnedPartsAssignment_2_1_1");
					put(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_0(), "rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_0");
					put(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_1(), "rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_1");
					put(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsAssignment_1(), "rule__SquareBracketedClauseCS__OwnedTermsAssignment_1");
					put(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsAssignment_2_1(), "rule__SquareBracketedClauseCS__OwnedTermsAssignment_2_1");
					put(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionAssignment_0_0(), "rule__NavigatingArgCS__OwnedNameExpressionAssignment_0_0");
					put(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorAssignment_0_1_0_1(), "rule__NavigatingArgCS__OwnedCoIteratorAssignment_0_1_0_1");
					put(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_0_2_1(), "rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_0_2_1");
					put(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_0_1_1_1(), "rule__NavigatingArgCS__OwnedTypeAssignment_0_1_1_1");
					put(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorAssignment_0_1_1_2_1(), "rule__NavigatingArgCS__OwnedCoIteratorAssignment_0_1_1_2_1");
					put(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_1_3_1(), "rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_1_3_1");
					put(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_0_1_2_0_1(), "rule__NavigatingArgCS__OwnedTypeAssignment_0_1_2_0_1");
					put(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorAssignment_0_1_2_1_1(), "rule__NavigatingArgCS__OwnedCoIteratorAssignment_0_1_2_1_1");
					put(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_2_3(), "rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_2_3");
					put(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_1_1(), "rule__NavigatingArgCS__OwnedTypeAssignment_1_1");
					put(grammarAccess.getNavigatingBarArgCSAccess().getPrefixAssignment_0(), "rule__NavigatingBarArgCS__PrefixAssignment_0");
					put(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionAssignment_1(), "rule__NavigatingBarArgCS__OwnedNameExpressionAssignment_1");
					put(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeAssignment_2_1(), "rule__NavigatingBarArgCS__OwnedTypeAssignment_2_1");
					put(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionAssignment_2_2_1(), "rule__NavigatingBarArgCS__OwnedInitExpressionAssignment_2_2_1");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixAssignment_0(), "rule__NavigatingCommaArgCS__PrefixAssignment_0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionAssignment_1(), "rule__NavigatingCommaArgCS__OwnedNameExpressionAssignment_1");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorAssignment_2_0_1(), "rule__NavigatingCommaArgCS__OwnedCoIteratorAssignment_2_0_1");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_0_2_1(), "rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_0_2_1");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeAssignment_2_1_1(), "rule__NavigatingCommaArgCS__OwnedTypeAssignment_2_1_1");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorAssignment_2_1_2_1(), "rule__NavigatingCommaArgCS__OwnedCoIteratorAssignment_2_1_2_1");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_1_3_1(), "rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_1_3_1");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeAssignment_2_2_0_1(), "rule__NavigatingCommaArgCS__OwnedTypeAssignment_2_2_0_1");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorAssignment_2_2_1_1(), "rule__NavigatingCommaArgCS__OwnedCoIteratorAssignment_2_2_1_1");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_2_3(), "rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_2_3");
					put(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixAssignment_0(), "rule__NavigatingSemiArgCS__PrefixAssignment_0");
					put(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionAssignment_1(), "rule__NavigatingSemiArgCS__OwnedNameExpressionAssignment_1");
					put(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeAssignment_2_1(), "rule__NavigatingSemiArgCS__OwnedTypeAssignment_2_1");
					put(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionAssignment_2_2_1(), "rule__NavigatingSemiArgCS__OwnedInitExpressionAssignment_2_2_1");
					put(grammarAccess.getCoIteratorVariableCSAccess().getNameAssignment_0(), "rule__CoIteratorVariableCS__NameAssignment_0");
					put(grammarAccess.getCoIteratorVariableCSAccess().getOwnedTypeAssignment_1_1(), "rule__CoIteratorVariableCS__OwnedTypeAssignment_1_1");
					put(grammarAccess.getIfExpCSAccess().getOwnedConditionAssignment_1(), "rule__IfExpCS__OwnedConditionAssignment_1");
					put(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionAssignment_3(), "rule__IfExpCS__OwnedThenExpressionAssignment_3");
					put(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsAssignment_4(), "rule__IfExpCS__OwnedIfThenExpressionsAssignment_4");
					put(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionAssignment_6(), "rule__IfExpCS__OwnedElseExpressionAssignment_6");
					put(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionAssignment_1(), "rule__ElseIfThenExpCS__OwnedConditionAssignment_1");
					put(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionAssignment_3(), "rule__ElseIfThenExpCS__OwnedThenExpressionAssignment_3");
					put(grammarAccess.getLetExpCSAccess().getOwnedVariablesAssignment_1(), "rule__LetExpCS__OwnedVariablesAssignment_1");
					put(grammarAccess.getLetExpCSAccess().getOwnedVariablesAssignment_2_1(), "rule__LetExpCS__OwnedVariablesAssignment_2_1");
					put(grammarAccess.getLetExpCSAccess().getOwnedInExpressionAssignment_4(), "rule__LetExpCS__OwnedInExpressionAssignment_4");
					put(grammarAccess.getLetVariableCSAccess().getNameAssignment_0(), "rule__LetVariableCS__NameAssignment_0");
					put(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseAssignment_1(), "rule__LetVariableCS__OwnedRoundBracketedClauseAssignment_1");
					put(grammarAccess.getLetVariableCSAccess().getOwnedTypeAssignment_2_1(), "rule__LetVariableCS__OwnedTypeAssignment_2_1");
					put(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionAssignment_4(), "rule__LetVariableCS__OwnedInitExpressionAssignment_4");
					put(grammarAccess.getNestedExpCSAccess().getOwnedExpressionAssignment_1(), "rule__NestedExpCS__OwnedExpressionAssignment_1");
					put(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0(), "rule__MultiplicityBoundsCS__LowerBoundAssignment_0");
					put(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1(), "rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1");
					put(grammarAccess.getMultiplicityCSAccess().getIsNullFreeAssignment_2_1(), "rule__MultiplicityCS__IsNullFreeAssignment_2_1");
					put(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAssignment(), "rule__MultiplicityStringCS__StringBoundsAssignment");
					put(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_0(), "rule__PathNameCS__OwnedPathElementsAssignment_0");
					put(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_1_1(), "rule__PathNameCS__OwnedPathElementsAssignment_1_1");
					put(grammarAccess.getUnreservedPathNameCSAccess().getOwnedPathElementsAssignment_0(), "rule__UnreservedPathNameCS__OwnedPathElementsAssignment_0");
					put(grammarAccess.getUnreservedPathNameCSAccess().getOwnedPathElementsAssignment_1_1(), "rule__UnreservedPathNameCS__OwnedPathElementsAssignment_1_1");
					put(grammarAccess.getFirstPathElementCSAccess().getReferredElementAssignment(), "rule__FirstPathElementCS__ReferredElementAssignment");
					put(grammarAccess.getNextPathElementCSAccess().getReferredElementAssignment(), "rule__NextPathElementCS__ReferredElementAssignment");
					put(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_0(), "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0");
					put(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_1_1(), "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1");
					put(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityAssignment_2(), "rule__TemplateBindingCS__OwnedMultiplicityAssignment_2");
					put(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterAssignment(), "rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment");
					put(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_1(), "rule__TemplateSignatureCS__OwnedParametersAssignment_1");
					put(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_2_1(), "rule__TemplateSignatureCS__OwnedParametersAssignment_2_1");
					put(grammarAccess.getTypeParameterCSAccess().getNameAssignment_0(), "rule__TypeParameterCS__NameAssignment_0");
					put(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_1(), "rule__TypeParameterCS__OwnedExtendsAssignment_1_1");
					put(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_2_1(), "rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1");
					put(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_0(), "rule__TypedTypeRefCS__OwnedPathNameAssignment_0");
					put(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingAssignment_1_1(), "rule__TypedTypeRefCS__OwnedBindingAssignment_1_1");
					put(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsAssignment_2_1(), "rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.eclipse.ocl.xtext.essentialocl.ui.contentassist.antlr.internal.InternalEssentialOCLParser typedParser = (org.eclipse.ocl.xtext.essentialocl.ui.contentassist.antlr.internal.InternalEssentialOCLParser) parser;
			typedParser.entryRuleModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public EssentialOCLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(EssentialOCLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
