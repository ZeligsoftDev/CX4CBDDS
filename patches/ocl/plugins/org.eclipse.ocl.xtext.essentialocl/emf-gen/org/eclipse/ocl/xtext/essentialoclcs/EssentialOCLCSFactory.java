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
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage
 * @generated
 */
public interface EssentialOCLCSFactory
		extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EssentialOCLCSFactory eINSTANCE = org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Prefix Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prefix Exp CS</em>'.
	 * @generated
	 */
	@NonNull PrefixExpCS createPrefixExpCS();

	/**
	 * Returns a new object of class '<em>Collection Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Type CS</em>'.
	 * @generated
	 */
	@NonNull CollectionTypeCS createCollectionTypeCS();

	/**
	 * Returns a new object of class '<em>Context CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context CS</em>'.
	 * @generated
	 */
	@NonNull ContextCS createContextCS();

	/**
	 * Returns a new object of class '<em>Curly Bracketed Clause CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Curly Bracketed Clause CS</em>'.
	 * @generated
	 */
	@NonNull CurlyBracketedClauseCS createCurlyBracketedClauseCS();

	/**
	 * Returns a new object of class '<em>Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exp CS</em>'.
	 * @generated
	 */
	@NonNull ExpCS createExpCS();

	/**
	 * Returns a new object of class '<em>Exp Specification CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exp Specification CS</em>'.
	 * @generated
	 */
	@NonNull ExpSpecificationCS createExpSpecificationCS();

	/**
	 * Returns a new object of class '<em>Type Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Literal Exp CS</em>'.
	 * @generated
	 */
	@NonNull TypeLiteralExpCS createTypeLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Type Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Name Exp CS</em>'.
	 * @generated
	 */
	@NonNull TypeNameExpCS createTypeNameExpCS();

	/**
	 * Returns a new object of class '<em>Unlimited Natural Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unlimited Natural Literal Exp CS</em>'.
	 * @generated
	 */
	@NonNull UnlimitedNaturalLiteralExpCS createUnlimitedNaturalLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable CS</em>'.
	 * @generated
	 */
	@NonNull VariableCS createVariableCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EssentialOCLCSPackage getEssentialOCLCSPackage();

	/**
	 * Returns a new object of class '<em>Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Exp CS</em>'.
	 * @generated
	 */
	@NonNull LiteralExpCS createLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Map Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Literal Exp CS</em>'.
	 * @generated
	 */
	@NonNull MapLiteralExpCS createMapLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Map Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Literal Part CS</em>'.
	 * @generated
	 */
	@NonNull MapLiteralPartCS createMapLiteralPartCS();

	/**
	 * Returns a new object of class '<em>Map Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Type CS</em>'.
	 * @generated
	 */
	@NonNull MapTypeCS createMapTypeCS();

	/**
	 * Returns a new object of class '<em>Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Name Exp CS</em>'.
	 * @generated
	 */
	@NonNull NameExpCS createNameExpCS();

	/**
	 * Returns a new object of class '<em>Navigating Arg CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Navigating Arg CS</em>'.
	 * @generated
	 */
	@NonNull NavigatingArgCS createNavigatingArgCS();

	/**
	 * Returns a new object of class '<em>Nested Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nested Exp CS</em>'.
	 * @generated
	 */
	@NonNull NestedExpCS createNestedExpCS();

	/**
	 * Returns a new object of class '<em>Collection Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Literal Exp CS</em>'.
	 * @generated
	 */
	@NonNull CollectionLiteralExpCS createCollectionLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Collection Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Literal Part CS</em>'.
	 * @generated
	 */
	@NonNull CollectionLiteralPartCS createCollectionLiteralPartCS();

	/**
	 * Returns a new object of class '<em>Collection Pattern CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Pattern CS</em>'.
	 * @generated
	 */
	@NonNull CollectionPatternCS createCollectionPatternCS();

	/**
	 * Returns a new object of class '<em>Primitive Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Literal Exp CS</em>'.
	 * @generated
	 */
	@NonNull PrimitiveLiteralExpCS createPrimitiveLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Round Bracketed Clause CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Round Bracketed Clause CS</em>'.
	 * @generated
	 */
	@NonNull RoundBracketedClauseCS createRoundBracketedClauseCS();

	/**
	 * Returns a new object of class '<em>Self Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Self Exp CS</em>'.
	 * @generated
	 */
	@NonNull SelfExpCS createSelfExpCS();

	/**
	 * Returns a new object of class '<em>Shadow Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shadow Part CS</em>'.
	 * @generated
	 */
	@NonNull ShadowPartCS createShadowPartCS();

	/**
	 * Returns a new object of class '<em>Square Bracketed Clause CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Square Bracketed Clause CS</em>'.
	 * @generated
	 */
	@NonNull SquareBracketedClauseCS createSquareBracketedClauseCS();

	/**
	 * Returns a new object of class '<em>Tuple Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Literal Exp CS</em>'.
	 * @generated
	 */
	@NonNull TupleLiteralExpCS createTupleLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Tuple Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Literal Part CS</em>'.
	 * @generated
	 */
	@NonNull TupleLiteralPartCS createTupleLiteralPartCS();

	/**
	 * Returns a new object of class '<em>String Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal Exp CS</em>'.
	 * @generated
	 */
	@NonNull StringLiteralExpCS createStringLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Boolean Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal Exp CS</em>'.
	 * @generated
	 */
	@NonNull BooleanLiteralExpCS createBooleanLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Invalid Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invalid Literal Exp CS</em>'.
	 * @generated
	 */
	@NonNull InvalidLiteralExpCS createInvalidLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Lambda Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lambda Literal Exp CS</em>'.
	 * @generated
	 */
	@NonNull LambdaLiteralExpCS createLambdaLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Null Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Literal Exp CS</em>'.
	 * @generated
	 */
	@NonNull NullLiteralExpCS createNullLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Number Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Number Literal Exp CS</em>'.
	 * @generated
	 */
	@NonNull NumberLiteralExpCS createNumberLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Pattern Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Exp CS</em>'.
	 * @generated
	 */
	@NonNull PatternExpCS createPatternExpCS();

	/**
	 * Returns a new object of class '<em>If Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Exp CS</em>'.
	 * @generated
	 */
	@NonNull IfExpCS createIfExpCS();

	/**
	 * Returns a new object of class '<em>If Then Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Then Exp CS</em>'.
	 * @generated
	 */
	@NonNull IfThenExpCS createIfThenExpCS();

	/**
	 * Returns a new object of class '<em>Infix Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Infix Exp CS</em>'.
	 * @generated
	 */
	@NonNull InfixExpCS createInfixExpCS();

	/**
	 * Returns a new object of class '<em>Let Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let Exp CS</em>'.
	 * @generated
	 */
	@NonNull LetExpCS createLetExpCS();

	/**
	 * Returns a new object of class '<em>Let Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let Variable CS</em>'.
	 * @generated
	 */
	@NonNull LetVariableCS createLetVariableCS();

} //EssentialOCLCSFactory
