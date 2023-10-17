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
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSFactory
 * @model kind="package"
 * @generated
 */
public interface EssentialOCLCSPackage
extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "essentialoclcs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/2015/EssentialOCLCS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "essentialoclcs";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String eCONTENT_TYPE = "org.eclipse.ocl.xtext.essentialocl"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EssentialOCLCSPackage eINSTANCE = org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl <em>Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getExpCS()
	 * @generated
	 */
	int EXP_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionTypeCSImpl <em>Collection Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionTypeCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionTypeCS()
	 * @generated
	 */
	int COLLECTION_TYPE_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.LiteralExpCSImpl <em>Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.LiteralExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLiteralExpCS()
	 * @generated
	 */
	int LITERAL_EXP_CS = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionLiteralExpCSImpl <em>Collection Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionLiteralExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionLiteralExpCS()
	 * @generated
	 */
	int COLLECTION_LITERAL_EXP_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionLiteralPartCSImpl <em>Collection Literal Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionLiteralPartCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionLiteralPartCS()
	 * @generated
	 */
	int COLLECTION_LITERAL_PART_CS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.PrimitiveLiteralExpCSImpl <em>Primitive Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.PrimitiveLiteralExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getPrimitiveLiteralExpCS()
	 * @generated
	 */
	int PRIMITIVE_LITERAL_EXP_CS = 34;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.TupleLiteralExpCSImpl <em>Tuple Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.TupleLiteralExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTupleLiteralExpCS()
	 * @generated
	 */
	int TUPLE_LITERAL_EXP_CS = 42;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.StringLiteralExpCSImpl <em>String Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.StringLiteralExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getStringLiteralExpCS()
	 * @generated
	 */
	int STRING_LITERAL_EXP_CS = 41;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.BooleanLiteralExpCSImpl <em>Boolean Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.BooleanLiteralExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getBooleanLiteralExpCS()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.InvalidLiteralExpCSImpl <em>Invalid Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.InvalidLiteralExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getInvalidLiteralExpCS()
	 * @generated
	 */
	int INVALID_LITERAL_EXP_CS = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.NullLiteralExpCSImpl <em>Null Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.NullLiteralExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNullLiteralExpCS()
	 * @generated
	 */
	int NULL_LITERAL_EXP_CS = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.IfExpCSImpl <em>If Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.IfExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getIfExpCS()
	 * @generated
	 */
	int IF_EXP_CS = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.LetExpCSImpl <em>Let Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.LetExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLetExpCS()
	 * @generated
	 */
	int LET_EXP_CS = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.InfixExpCSImpl <em>Infix Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.InfixExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getInfixExpCS()
	 * @generated
	 */
	int INFIX_EXP_CS = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.NameExpCSImpl <em>Name Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.NameExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNameExpCS()
	 * @generated
	 */
	int NAME_EXP_CS = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.TypeNameExpCSImpl <em>Type Name Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.TypeNameExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTypeNameExpCS()
	 * @generated
	 */
	int TYPE_NAME_EXP_CS = 45;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.NavigatingArgCSImpl <em>Navigating Arg CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.NavigatingArgCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNavigatingArgCS()
	 * @generated
	 */
	int NAVIGATING_ARG_CS = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.NestedExpCSImpl <em>Nested Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.NestedExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNestedExpCS()
	 * @generated
	 */
	int NESTED_EXP_CS = 27;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.NumberLiteralExpCSImpl <em>Number Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.NumberLiteralExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNumberLiteralExpCS()
	 * @generated
	 */
	int NUMBER_LITERAL_EXP_CS = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.AbstractNameExpCSImpl <em>Abstract Name Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.AbstractNameExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getAbstractNameExpCS()
	 * @generated
	 */
	int ABSTRACT_NAME_EXP_CS = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CallExpCSImpl <em>Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.CallExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCallExpCS()
	 * @generated
	 */
	int CALL_EXP_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.AssociationClassCallExpCSImpl <em>Association Class Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.AssociationClassCallExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getAssociationClassCallExpCS()
	 * @generated
	 */
	int ASSOCIATION_CLASS_CALL_EXP_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionPatternCSImpl <em>Collection Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionPatternCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionPatternCS()
	 * @generated
	 */
	int COLLECTION_PATTERN_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ContextCSImpl <em>Context CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.ContextCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getContextCS()
	 * @generated
	 */
	int CONTEXT_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ExpSpecificationCSImpl <em>Exp Specification CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.ExpSpecificationCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getExpSpecificationCS()
	 * @generated
	 */
	int EXP_SPECIFICATION_CS = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.VariableCSImpl <em>Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.VariableCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getVariableCS()
	 * @generated
	 */
	int VARIABLE_CS = 47;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.LetVariableCSImpl <em>Let Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.LetVariableCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLetVariableCS()
	 * @generated
	 */
	int LET_VARIABLE_CS = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CurlyBracketedClauseCSImpl <em>Curly Bracketed Clause CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.CurlyBracketedClauseCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCurlyBracketedClauseCS()
	 * @generated
	 */
	int CURLY_BRACKETED_CLAUSE_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.IfThenExpCSImpl <em>If Then Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.IfThenExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getIfThenExpCS()
	 * @generated
	 */
	int IF_THEN_EXP_CS = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.OperatorExpCSImpl <em>Operator Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.OperatorExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getOperatorExpCS()
	 * @generated
	 */
	int OPERATOR_EXP_CS = 31;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.IterationCallExpCSImpl <em>Iteration Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.IterationCallExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getIterationCallExpCS()
	 * @generated
	 */
	int ITERATION_CALL_EXP_CS = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.IterateCallExpCSImpl <em>Iterate Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.IterateCallExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getIterateCallExpCS()
	 * @generated
	 */
	int ITERATE_CALL_EXP_CS = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.LambdaLiteralExpCSImpl <em>Lambda Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.LambdaLiteralExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLambdaLiteralExpCS()
	 * @generated
	 */
	int LAMBDA_LITERAL_EXP_CS = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.MapLiteralExpCSImpl <em>Map Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.MapLiteralExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getMapLiteralExpCS()
	 * @generated
	 */
	int MAP_LITERAL_EXP_CS = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.MapLiteralPartCSImpl <em>Map Literal Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.MapLiteralPartCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getMapLiteralPartCS()
	 * @generated
	 */
	int MAP_LITERAL_PART_CS = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.MapTypeCSImpl <em>Map Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.MapTypeCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getMapTypeCS()
	 * @generated
	 */
	int MAP_TYPE_CS = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.OperationCallExpCSImpl <em>Operation Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.OperationCallExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getOperationCallExpCS()
	 * @generated
	 */
	int OPERATION_CALL_EXP_CS = 30;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.PatternExpCSImpl <em>Pattern Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.PatternExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getPatternExpCS()
	 * @generated
	 */
	int PATTERN_EXP_CS = 32;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.PrefixExpCSImpl <em>Prefix Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.PrefixExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getPrefixExpCS()
	 * @generated
	 */
	int PREFIX_EXP_CS = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.PropertyCallExpCSImpl <em>Property Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.PropertyCallExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getPropertyCallExpCS()
	 * @generated
	 */
	int PROPERTY_CALL_EXP_CS = 35;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.RoundBracketedClauseCSImpl <em>Round Bracketed Clause CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.RoundBracketedClauseCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getRoundBracketedClauseCS()
	 * @generated
	 */
	int ROUND_BRACKETED_CLAUSE_CS = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.SelfExpCSImpl <em>Self Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.SelfExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getSelfExpCS()
	 * @generated
	 */
	int SELF_EXP_CS = 37;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.SquareBracketedClauseCSImpl <em>Square Bracketed Clause CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.SquareBracketedClauseCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getSquareBracketedClauseCS()
	 * @generated
	 */
	int SQUARE_BRACKETED_CLAUSE_CS = 40;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.TupleLiteralPartCSImpl <em>Tuple Literal Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.TupleLiteralPartCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTupleLiteralPartCS()
	 * @generated
	 */
	int TUPLE_LITERAL_PART_CS = 43;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.TypeLiteralExpCSImpl <em>Type Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.TypeLiteralExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTypeLiteralExpCS()
	 * @generated
	 */
	int TYPE_LITERAL_EXP_CS = 44;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ShadowExpCSImpl <em>Shadow Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.ShadowExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getShadowExpCS()
	 * @generated
	 */
	int SHADOW_EXP_CS = 38;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ShadowPartCSImpl <em>Shadow Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.ShadowPartCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getShadowPartCS()
	 * @generated
	 */
	int SHADOW_PART_CS = 39;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.UnlimitedNaturalLiteralExpCSImpl <em>Unlimited Natural Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.UnlimitedNaturalLiteralExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getUnlimitedNaturalLiteralExpCS()
	 * @generated
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS = 46;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.VariableExpCSImpl <em>Variable Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.VariableExpCSImpl
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getVariableExpCS()
	 * @generated
	 */
	int VARIABLE_EXP_CS = 48;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigationRole <em>Navigation Role</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigationRole
	 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNavigationRole()
	 * @generated
	 */
	int NAVIGATION_ROLE = 49;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS <em>Abstract Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Name Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS
	 * @generated
	 */
	EClass getAbstractNameExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedPathName()
	 * @see #getAbstractNameExpCS()
	 * @generated
	 */
	EReference getAbstractNameExpCS_OwnedPathName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#isIsPre <em>Is Pre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Pre</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#isIsPre()
	 * @see #getAbstractNameExpCS()
	 * @generated
	 */
	EAttribute getAbstractNameExpCS_IsPre();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedCurlyBracketedClause <em>Owned Curly Bracketed Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Curly Bracketed Clause</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedCurlyBracketedClause()
	 * @see #getAbstractNameExpCS()
	 * @generated
	 */
	EReference getAbstractNameExpCS_OwnedCurlyBracketedClause();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedRoundBracketedClause <em>Owned Round Bracketed Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Round Bracketed Clause</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedRoundBracketedClause()
	 * @see #getAbstractNameExpCS()
	 * @generated
	 */
	EReference getAbstractNameExpCS_OwnedRoundBracketedClause();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedSquareBracketedClauses <em>Owned Square Bracketed Clauses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Square Bracketed Clauses</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedSquareBracketedClauses()
	 * @see #getAbstractNameExpCS()
	 * @generated
	 */
	EReference getAbstractNameExpCS_OwnedSquareBracketedClauses();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getSourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Type</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getSourceType()
	 * @see #getAbstractNameExpCS()
	 * @generated
	 */
	EReference getAbstractNameExpCS_SourceType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getSourceTypeValue <em>Source Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Type Value</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getSourceTypeValue()
	 * @see #getAbstractNameExpCS()
	 * @generated
	 */
	EReference getAbstractNameExpCS_SourceTypeValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS <em>Association Class Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Class Call Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS
	 * @generated
	 */
	EClass getAssociationClassCallExpCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS#getReferredAssociation <em>Referred Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Association</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS#getReferredAssociation()
	 * @see #getAssociationClassCallExpCS()
	 * @generated
	 */
	EReference getAssociationClassCallExpCS_ReferredAssociation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS <em>Prefix Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prefix Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS
	 * @generated
	 */
	EClass getPrefixExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS <em>Collection Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS
	 * @generated
	 */
	EClass getCollectionTypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS#getName()
	 * @see #getCollectionTypeCS()
	 * @generated
	 */
	EAttribute getCollectionTypeCS_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS#getOwnedCollectionMultiplicity <em>Owned Collection Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Collection Multiplicity</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS#getOwnedCollectionMultiplicity()
	 * @see #getCollectionTypeCS()
	 * @generated
	 */
	EReference getCollectionTypeCS_OwnedCollectionMultiplicity();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS#getOwnedType()
	 * @see #getCollectionTypeCS()
	 * @generated
	 */
	EReference getCollectionTypeCS_OwnedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.ContextCS <em>Context CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ContextCS
	 * @generated
	 */
	EClass getContextCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.ContextCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ContextCS#getOwnedExpression()
	 * @see #getContextCS()
	 * @generated
	 */
	EReference getContextCS_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS <em>Curly Bracketed Clause CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Curly Bracketed Clause CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS
	 * @generated
	 */
	EClass getCurlyBracketedClauseCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getOwningNameExp <em>Owning Name Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Name Exp</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getOwningNameExp()
	 * @see #getCurlyBracketedClauseCS()
	 * @generated
	 */
	EReference getCurlyBracketedClauseCS_OwningNameExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getOwnedParts()
	 * @see #getCurlyBracketedClauseCS()
	 * @generated
	 */
	EReference getCurlyBracketedClauseCS_OwnedParts();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getValue()
	 * @see #getCurlyBracketedClauseCS()
	 * @generated
	 */
	EAttribute getCurlyBracketedClauseCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS <em>Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ExpCS
	 * @generated
	 */
	EClass getExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#isHasError <em>Has Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Error</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ExpCS#isHasError()
	 * @see #getExpCS()
	 * @generated
	 */
	EAttribute getExpCS_HasError();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalLeft <em>Local Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Local Left</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalLeft()
	 * @see #getExpCS()
	 * @generated
	 */
	EReference getExpCS_LocalLeft();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalLeftmostDescendant <em>Local Leftmost Descendant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Local Leftmost Descendant</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalLeftmostDescendant()
	 * @see #getExpCS()
	 * @generated
	 */
	EReference getExpCS_LocalLeftmostDescendant();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalParent <em>Local Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Local Parent</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalParent()
	 * @see #getExpCS()
	 * @generated
	 */
	EReference getExpCS_LocalParent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalRight <em>Local Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Local Right</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalRight()
	 * @see #getExpCS()
	 * @generated
	 */
	EReference getExpCS_LocalRight();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalRightmostDescendant <em>Local Rightmost Descendant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Local Rightmost Descendant</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalRightmostDescendant()
	 * @see #getExpCS()
	 * @generated
	 */
	EReference getExpCS_LocalRightmostDescendant();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getPrecedence <em>Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * @deprecated not used
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Precedence</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getPrecedence()
	 * @see #getExpCS()
	 * @generated
	 */
	@Deprecated
	EReference getExpCS_Precedence();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getPrecedenceOrder <em>Precedence Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Precedence Order</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getPrecedenceOrder()
	 * @see #getExpCS()
	 * @generated
	 */
	EAttribute getExpCS_PrecedenceOrder();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS <em>Exp Specification CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exp Specification CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS
	 * @generated
	 */
	EClass getExpSpecificationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS#getOwnedExpression()
	 * @see #getExpSpecificationCS()
	 * @generated
	 */
	EReference getExpSpecificationCS_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS <em>Type Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS
	 * @generated
	 */
	EClass getTypeLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS#getOwnedPathName()
	 * @see #getTypeLiteralExpCS()
	 * @generated
	 */
	EReference getTypeLiteralExpCS_OwnedPathName();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS#getOwnedType()
	 * @see #getTypeLiteralExpCS()
	 * @generated
	 */
	EReference getTypeLiteralExpCS_OwnedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS <em>Type Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Name Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS
	 * @generated
	 */
	EClass getTypeNameExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getOwnedPathName()
	 * @see #getTypeNameExpCS()
	 * @generated
	 */
	EReference getTypeNameExpCS_OwnedPathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getElement()
	 * @see #getTypeNameExpCS()
	 * @generated
	 */
	EReference getTypeNameExpCS_Element();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getOwnedCurlyBracketedClause <em>Owned Curly Bracketed Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Curly Bracketed Clause</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getOwnedCurlyBracketedClause()
	 * @see #getTypeNameExpCS()
	 * @generated
	 */
	EReference getTypeNameExpCS_OwnedCurlyBracketedClause();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getOwnedPatternGuard <em>Owned Pattern Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Pattern Guard</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getOwnedPatternGuard()
	 * @see #getTypeNameExpCS()
	 * @generated
	 */
	EReference getTypeNameExpCS_OwnedPatternGuard();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS <em>Unlimited Natural Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlimited Natural Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS
	 * @generated
	 */
	EClass getUnlimitedNaturalLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.VariableCS <em>Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.VariableCS
	 * @generated
	 */
	EClass getVariableCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.VariableCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.VariableCS#getOwnedType()
	 * @see #getVariableCS()
	 * @generated
	 */
	EReference getVariableCS_OwnedType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.VariableCS#getOwnedInitExpression <em>Owned Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Expression</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.VariableCS#getOwnedInitExpression()
	 * @see #getVariableCS()
	 * @generated
	 */
	EReference getVariableCS_OwnedInitExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS <em>Variable Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS
	 * @generated
	 */
	EClass getVariableExpCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS#getReferredVariable()
	 * @see #getVariableExpCS()
	 * @generated
	 */
	EReference getVariableExpCS_ReferredVariable();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigationRole <em>Navigation Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Navigation Role</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigationRole
	 * @generated
	 */
	EEnum getNavigationRole();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.LiteralExpCS <em>Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LiteralExpCS
	 * @generated
	 */
	EClass getLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS <em>Map Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS
	 * @generated
	 */
	EClass getMapLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS#getOwnedParts()
	 * @see #getMapLiteralExpCS()
	 * @generated
	 */
	EReference getMapLiteralExpCS_OwnedParts();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS#getOwnedType()
	 * @see #getMapLiteralExpCS()
	 * @generated
	 */
	EReference getMapLiteralExpCS_OwnedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS <em>Map Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Literal Part CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS
	 * @generated
	 */
	EClass getMapLiteralPartCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS#getOwnedKey <em>Owned Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Key</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS#getOwnedKey()
	 * @see #getMapLiteralPartCS()
	 * @generated
	 */
	EReference getMapLiteralPartCS_OwnedKey();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS#getOwnedValue <em>Owned Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Value</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS#getOwnedValue()
	 * @see #getMapLiteralPartCS()
	 * @generated
	 */
	EReference getMapLiteralPartCS_OwnedValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS <em>Map Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Type CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS
	 * @generated
	 */
	EClass getMapTypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS#getName()
	 * @see #getMapTypeCS()
	 * @generated
	 */
	EAttribute getMapTypeCS_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS#getOwnedKeyType <em>Owned Key Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Key Type</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS#getOwnedKeyType()
	 * @see #getMapTypeCS()
	 * @generated
	 */
	EReference getMapTypeCS_OwnedKeyType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS#getOwnedValueType <em>Owned Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Value Type</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS#getOwnedValueType()
	 * @see #getMapTypeCS()
	 * @generated
	 */
	EReference getMapTypeCS_OwnedValueType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.NameExpCS <em>Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NameExpCS
	 * @generated
	 */
	EClass getNameExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS <em>Navigating Arg CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigating Arg CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS
	 * @generated
	 */
	EClass getNavigatingArgCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwningRoundBracketedClause <em>Owning Round Bracketed Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Round Bracketed Clause</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwningRoundBracketedClause()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EReference getNavigatingArgCS_OwningRoundBracketedClause();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getRole()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EAttribute getNavigatingArgCS_Role();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedCoIterator <em>Owned Co Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Co Iterator</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedCoIterator()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EReference getNavigatingArgCS_OwnedCoIterator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getPrefix()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EAttribute getNavigatingArgCS_Prefix();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedNameExpression <em>Owned Name Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Name Expression</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedNameExpression()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EReference getNavigatingArgCS_OwnedNameExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedType()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EReference getNavigatingArgCS_OwnedType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedInitExpression <em>Owned Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Expression</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedInitExpression()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EReference getNavigatingArgCS_OwnedInitExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS <em>Nested Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nested Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS
	 * @generated
	 */
	EClass getNestedExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS#getOwnedExpression()
	 * @see #getNestedExpCS()
	 * @generated
	 */
	EReference getNestedExpCS_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS <em>Collection Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS
	 * @generated
	 */
	EClass getCollectionLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS#getOwnedType()
	 * @see #getCollectionLiteralExpCS()
	 * @generated
	 */
	EReference getCollectionLiteralExpCS_OwnedType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS#getOwnedParts()
	 * @see #getCollectionLiteralExpCS()
	 * @generated
	 */
	EReference getCollectionLiteralExpCS_OwnedParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS <em>Collection Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Part CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS
	 * @generated
	 */
	EClass getCollectionLiteralPartCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS#getOwnedExpression()
	 * @see #getCollectionLiteralPartCS()
	 * @generated
	 */
	EReference getCollectionLiteralPartCS_OwnedExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS#getOwnedLastExpression <em>Owned Last Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Last Expression</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS#getOwnedLastExpression()
	 * @see #getCollectionLiteralPartCS()
	 * @generated
	 */
	EReference getCollectionLiteralPartCS_OwnedLastExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS <em>Collection Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Pattern CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS
	 * @generated
	 */
	EClass getCollectionPatternCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getOwnedType()
	 * @see #getCollectionPatternCS()
	 * @generated
	 */
	EReference getCollectionPatternCS_OwnedType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getOwnedParts()
	 * @see #getCollectionPatternCS()
	 * @generated
	 */
	EReference getCollectionPatternCS_OwnedParts();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getRestVariableName <em>Rest Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rest Variable Name</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getRestVariableName()
	 * @see #getCollectionPatternCS()
	 * @generated
	 */
	EAttribute getCollectionPatternCS_RestVariableName();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getOwnedPatternGuard <em>Owned Pattern Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Pattern Guard</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getOwnedPatternGuard()
	 * @see #getCollectionPatternCS()
	 * @generated
	 */
	EReference getCollectionPatternCS_OwnedPatternGuard();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.PrimitiveLiteralExpCS <em>Primitive Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.PrimitiveLiteralExpCS
	 * @generated
	 */
	EClass getPrimitiveLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS <em>Property Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Call Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS
	 * @generated
	 */
	EClass getPropertyCallExpCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS#getReferredProperty()
	 * @see #getPropertyCallExpCS()
	 * @generated
	 */
	EReference getPropertyCallExpCS_ReferredProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS <em>Round Bracketed Clause CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Round Bracketed Clause CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS
	 * @generated
	 */
	EClass getRoundBracketedClauseCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS#getOwningNameExp <em>Owning Name Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Name Exp</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS#getOwningNameExp()
	 * @see #getRoundBracketedClauseCS()
	 * @generated
	 */
	EReference getRoundBracketedClauseCS_OwningNameExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS#getOwnedArguments <em>Owned Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Arguments</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS#getOwnedArguments()
	 * @see #getRoundBracketedClauseCS()
	 * @generated
	 */
	EReference getRoundBracketedClauseCS_OwnedArguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS <em>Self Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Self Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS
	 * @generated
	 */
	EClass getSelfExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS#getName()
	 * @see #getSelfExpCS()
	 * @generated
	 */
	EAttribute getSelfExpCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS <em>Shadow Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shadow Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS
	 * @generated
	 */
	EClass getShadowExpCS();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parts</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS#getParts()
	 * @see #getShadowExpCS()
	 * @generated
	 */
	EReference getShadowExpCS_Parts();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Name</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS#getTypeName()
	 * @see #getShadowExpCS()
	 * @generated
	 */
	EReference getShadowExpCS_TypeName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS#getValue()
	 * @see #getShadowExpCS()
	 * @generated
	 */
	EAttribute getShadowExpCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS <em>Shadow Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shadow Part CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS
	 * @generated
	 */
	EClass getShadowPartCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS#getOwnedInitExpression <em>Owned Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Expression</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS#getOwnedInitExpression()
	 * @see #getShadowPartCS()
	 * @generated
	 */
	EReference getShadowPartCS_OwnedInitExpression();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS#getOwningCurlyBracketClause <em>Owning Curly Bracket Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Curly Bracket Clause</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS#getOwningCurlyBracketClause()
	 * @see #getShadowPartCS()
	 * @generated
	 */
	EReference getShadowPartCS_OwningCurlyBracketClause();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS#getReferredProperty()
	 * @see #getShadowPartCS()
	 * @generated
	 */
	EReference getShadowPartCS_ReferredProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS <em>Square Bracketed Clause CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Square Bracketed Clause CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS
	 * @generated
	 */
	EClass getSquareBracketedClauseCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS#getOwningNameExp <em>Owning Name Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Name Exp</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS#getOwningNameExp()
	 * @see #getSquareBracketedClauseCS()
	 * @generated
	 */
	EReference getSquareBracketedClauseCS_OwningNameExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS#getOwnedTerms <em>Owned Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Terms</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS#getOwnedTerms()
	 * @see #getSquareBracketedClauseCS()
	 * @generated
	 */
	EReference getSquareBracketedClauseCS_OwnedTerms();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS <em>Tuple Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS
	 * @generated
	 */
	EClass getTupleLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS#getOwnedParts()
	 * @see #getTupleLiteralExpCS()
	 * @generated
	 */
	EReference getTupleLiteralExpCS_OwnedParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS <em>Tuple Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Part CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS
	 * @generated
	 */
	EClass getTupleLiteralPartCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS <em>String Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS
	 * @generated
	 */
	EClass getStringLiteralExpCS();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Segments</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS#getSegments()
	 * @see #getStringLiteralExpCS()
	 * @generated
	 */
	EAttribute getStringLiteralExpCS_Segments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS <em>Boolean Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS
	 * @generated
	 */
	EClass getBooleanLiteralExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS#getSymbol()
	 * @see #getBooleanLiteralExpCS()
	 * @generated
	 */
	EAttribute getBooleanLiteralExpCS_Symbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.CallExpCS <em>Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CallExpCS
	 * @generated
	 */
	EClass getCallExpCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.CallExpCS#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CallExpCS#getSource()
	 * @see #getCallExpCS()
	 * @generated
	 */
	EReference getCallExpCS_Source();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.CallExpCS#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CallExpCS#getArguments()
	 * @see #getCallExpCS()
	 * @generated
	 */
	EReference getCallExpCS_Arguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS <em>Invalid Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS
	 * @generated
	 */
	EClass getInvalidLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS <em>Iterate Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterate Call Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS
	 * @generated
	 */
	EClass getIterateCallExpCS();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS#getAccumulators <em>Accumulators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Accumulators</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS#getAccumulators()
	 * @see #getIterateCallExpCS()
	 * @generated
	 */
	EReference getIterateCallExpCS_Accumulators();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS <em>Iteration Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration Call Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS
	 * @generated
	 */
	EClass getIterationCallExpCS();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS#getCoIterators <em>Co Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Co Iterators</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS#getCoIterators()
	 * @see #getIterationCallExpCS()
	 * @generated
	 */
	EReference getIterationCallExpCS_CoIterators();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS#getReferredIteration <em>Referred Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Iteration</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS#getReferredIteration()
	 * @see #getIterationCallExpCS()
	 * @generated
	 */
	EReference getIterationCallExpCS_ReferredIteration();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS#getIterators <em>Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Iterators</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS#getIterators()
	 * @see #getIterationCallExpCS()
	 * @generated
	 */
	EReference getIterationCallExpCS_Iterators();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS <em>Lambda Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lambda Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS
	 * @generated
	 */
	EClass getLambdaLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS#getOwnedExpressionCS <em>Owned Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS#getOwnedExpressionCS()
	 * @see #getLambdaLiteralExpCS()
	 * @generated
	 */
	EReference getLambdaLiteralExpCS_OwnedExpressionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS <em>Null Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS
	 * @generated
	 */
	EClass getNullLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS <em>Number Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS
	 * @generated
	 */
	EClass getNumberLiteralExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS#getSymbol()
	 * @see #getNumberLiteralExpCS()
	 * @generated
	 */
	EAttribute getNumberLiteralExpCS_Symbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.OperationCallExpCS <em>Operation Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.OperationCallExpCS
	 * @generated
	 */
	EClass getOperationCallExpCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.OperationCallExpCS#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.OperationCallExpCS#getReferredOperation()
	 * @see #getOperationCallExpCS()
	 * @generated
	 */
	EReference getOperationCallExpCS_ReferredOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS <em>Operator Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS
	 * @generated
	 */
	EClass getOperatorExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS#getOwnedRight <em>Owned Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Right</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS#getOwnedRight()
	 * @see #getOperatorExpCS()
	 * @generated
	 */
	EReference getOperatorExpCS_OwnedRight();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS#getSource()
	 * @see #getOperatorExpCS()
	 * @generated
	 */
	EReference getOperatorExpCS_Source();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS <em>Pattern Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS
	 * @generated
	 */
	EClass getPatternExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS#getPatternVariableName <em>Pattern Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern Variable Name</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS#getPatternVariableName()
	 * @see #getPatternExpCS()
	 * @generated
	 */
	EAttribute getPatternExpCS_PatternVariableName();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS#getOwnedPatternType <em>Owned Pattern Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Pattern Type</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS#getOwnedPatternType()
	 * @see #getPatternExpCS()
	 * @generated
	 */
	EReference getPatternExpCS_OwnedPatternType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EssentialOCLCSFactory getEssentialOCLCSFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS <em>If Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IfExpCS
	 * @generated
	 */
	EClass getIfExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedCondition <em>Owned Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Condition</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedCondition()
	 * @see #getIfExpCS()
	 * @generated
	 */
	EReference getIfExpCS_OwnedCondition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedThenExpression <em>Owned Then Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Then Expression</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedThenExpression()
	 * @see #getIfExpCS()
	 * @generated
	 */
	EReference getIfExpCS_OwnedThenExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedIfThenExpressions <em>Owned If Then Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned If Then Expressions</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedIfThenExpressions()
	 * @see #getIfExpCS()
	 * @generated
	 */
	EReference getIfExpCS_OwnedIfThenExpressions();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedElseExpression <em>Owned Else Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Else Expression</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedElseExpression()
	 * @see #getIfExpCS()
	 * @generated
	 */
	EReference getIfExpCS_OwnedElseExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#isIsImplicit <em>Is Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Implicit</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#isIsImplicit()
	 * @see #getIfExpCS()
	 * @generated
	 */
	EAttribute getIfExpCS_IsImplicit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS <em>If Then Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Then Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS
	 * @generated
	 */
	EClass getIfThenExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS#getOwnedCondition <em>Owned Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Condition</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS#getOwnedCondition()
	 * @see #getIfThenExpCS()
	 * @generated
	 */
	EReference getIfThenExpCS_OwnedCondition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS#getOwnedThenExpression <em>Owned Then Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Then Expression</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS#getOwnedThenExpression()
	 * @see #getIfThenExpCS()
	 * @generated
	 */
	EReference getIfThenExpCS_OwnedThenExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS <em>Infix Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infix Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS
	 * @generated
	 */
	EClass getInfixExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS#getOwnedLeft <em>Owned Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Left</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS#getOwnedLeft()
	 * @see #getInfixExpCS()
	 * @generated
	 */
	EReference getInfixExpCS_OwnedLeft();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Argument</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS#getArgument()
	 * @see #getInfixExpCS()
	 * @generated
	 */
	EReference getInfixExpCS_Argument();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.LetExpCS <em>Let Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Exp CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LetExpCS
	 * @generated
	 */
	EClass getLetExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.essentialoclcs.LetExpCS#getOwnedVariables <em>Owned Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Variables</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LetExpCS#getOwnedVariables()
	 * @see #getLetExpCS()
	 * @generated
	 */
	EReference getLetExpCS_OwnedVariables();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.LetExpCS#getOwnedInExpression <em>Owned In Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned In Expression</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LetExpCS#getOwnedInExpression()
	 * @see #getLetExpCS()
	 * @generated
	 */
	EReference getLetExpCS_OwnedInExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.essentialoclcs.LetExpCS#isIsImplicit <em>Is Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Implicit</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LetExpCS#isIsImplicit()
	 * @see #getLetExpCS()
	 * @generated
	 */
	EAttribute getLetExpCS_IsImplicit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS <em>Let Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Variable CS</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS
	 * @generated
	 */
	EClass getLetVariableCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS#getOwningLetExpression <em>Owning Let Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Let Expression</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS#getOwningLetExpression()
	 * @see #getLetVariableCS()
	 * @generated
	 */
	EReference getLetVariableCS_OwningLetExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS#getOwnedRoundBracketedClause <em>Owned Round Bracketed Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Round Bracketed Clause</em>'.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS#getOwnedRoundBracketedClause()
	 * @see #getLetVariableCS()
	 * @generated
	 */
	EReference getLetVariableCS_OwnedRoundBracketedClause();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.AbstractNameExpCSImpl <em>Abstract Name Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.AbstractNameExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getAbstractNameExpCS()
		 * @generated
		 */
		EClass ABSTRACT_NAME_EXP_CS = eINSTANCE.getAbstractNameExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME = eINSTANCE.getAbstractNameExpCS_OwnedPathName();

		/**
		 * The meta object literal for the '<em><b>Is Pre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_NAME_EXP_CS__IS_PRE = eINSTANCE.getAbstractNameExpCS_IsPre();

		/**
		 * The meta object literal for the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE = eINSTANCE.getAbstractNameExpCS_OwnedCurlyBracketedClause();

		/**
		 * The meta object literal for the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE = eINSTANCE.getAbstractNameExpCS_OwnedRoundBracketedClause();

		/**
		 * The meta object literal for the '<em><b>Owned Square Bracketed Clauses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES = eINSTANCE.getAbstractNameExpCS_OwnedSquareBracketedClauses();

		/**
		 * The meta object literal for the '<em><b>Source Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NAME_EXP_CS__SOURCE_TYPE = eINSTANCE.getAbstractNameExpCS_SourceType();

		/**
		 * The meta object literal for the '<em><b>Source Type Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NAME_EXP_CS__SOURCE_TYPE_VALUE = eINSTANCE.getAbstractNameExpCS_SourceTypeValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.AssociationClassCallExpCSImpl <em>Association Class Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.AssociationClassCallExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getAssociationClassCallExpCS()
		 * @generated
		 */
		EClass ASSOCIATION_CLASS_CALL_EXP_CS = eINSTANCE.getAssociationClassCallExpCS();

		/**
		 * The meta object literal for the '<em><b>Referred Association</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_CLASS_CALL_EXP_CS__REFERRED_ASSOCIATION = eINSTANCE.getAssociationClassCallExpCS_ReferredAssociation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.PrefixExpCSImpl <em>Prefix Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.PrefixExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getPrefixExpCS()
		 * @generated
		 */
		EClass PREFIX_EXP_CS = eINSTANCE.getPrefixExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionTypeCSImpl <em>Collection Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionTypeCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionTypeCS()
		 * @generated
		 */
		EClass COLLECTION_TYPE_CS = eINSTANCE.getCollectionTypeCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_TYPE_CS__NAME = eINSTANCE.getCollectionTypeCS_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Collection Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY = eINSTANCE.getCollectionTypeCS_OwnedCollectionMultiplicity();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE_CS__OWNED_TYPE = eINSTANCE.getCollectionTypeCS_OwnedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ContextCSImpl <em>Context CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.ContextCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getContextCS()
		 * @generated
		 */
		EClass CONTEXT_CS = eINSTANCE.getContextCS();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_CS__OWNED_EXPRESSION = eINSTANCE.getContextCS_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CurlyBracketedClauseCSImpl <em>Curly Bracketed Clause CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.CurlyBracketedClauseCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCurlyBracketedClauseCS()
		 * @generated
		 */
		EClass CURLY_BRACKETED_CLAUSE_CS = eINSTANCE.getCurlyBracketedClauseCS();

		/**
		 * The meta object literal for the '<em><b>Owning Name Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CURLY_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP = eINSTANCE.getCurlyBracketedClauseCS_OwningNameExp();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS = eINSTANCE.getCurlyBracketedClauseCS_OwnedParts();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURLY_BRACKETED_CLAUSE_CS__VALUE = eINSTANCE.getCurlyBracketedClauseCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl <em>Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getExpCS()
		 * @generated
		 */
		EClass EXP_CS = eINSTANCE.getExpCS();

		/**
		 * The meta object literal for the '<em><b>Has Error</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXP_CS__HAS_ERROR = eINSTANCE.getExpCS_HasError();

		/**
		 * The meta object literal for the '<em><b>Local Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXP_CS__LOCAL_LEFT = eINSTANCE.getExpCS_LocalLeft();

		/**
		 * The meta object literal for the '<em><b>Local Leftmost Descendant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXP_CS__LOCAL_LEFTMOST_DESCENDANT = eINSTANCE.getExpCS_LocalLeftmostDescendant();

		/**
		 * The meta object literal for the '<em><b>Local Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXP_CS__LOCAL_PARENT = eINSTANCE.getExpCS_LocalParent();

		/**
		 * The meta object literal for the '<em><b>Local Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXP_CS__LOCAL_RIGHT = eINSTANCE.getExpCS_LocalRight();

		/**
		 * The meta object literal for the '<em><b>Local Rightmost Descendant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = eINSTANCE.getExpCS_LocalRightmostDescendant();

		/**
		 * The meta object literal for the '<em><b>Precedence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXP_CS__PRECEDENCE = eINSTANCE.getExpCS_Precedence();

		/**
		 * The meta object literal for the '<em><b>Precedence Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXP_CS__PRECEDENCE_ORDER = eINSTANCE.getExpCS_PrecedenceOrder();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ExpSpecificationCSImpl <em>Exp Specification CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.ExpSpecificationCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getExpSpecificationCS()
		 * @generated
		 */
		EClass EXP_SPECIFICATION_CS = eINSTANCE.getExpSpecificationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXP_SPECIFICATION_CS__OWNED_EXPRESSION = eINSTANCE.getExpSpecificationCS_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.TypeLiteralExpCSImpl <em>Type Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.TypeLiteralExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTypeLiteralExpCS()
		 * @generated
		 */
		EClass TYPE_LITERAL_EXP_CS = eINSTANCE.getTypeLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_LITERAL_EXP_CS__OWNED_PATH_NAME = eINSTANCE.getTypeLiteralExpCS_OwnedPathName();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_LITERAL_EXP_CS__OWNED_TYPE = eINSTANCE.getTypeLiteralExpCS_OwnedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.TypeNameExpCSImpl <em>Type Name Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.TypeNameExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTypeNameExpCS()
		 * @generated
		 */
		EClass TYPE_NAME_EXP_CS = eINSTANCE.getTypeNameExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_NAME_EXP_CS__OWNED_PATH_NAME = eINSTANCE.getTypeNameExpCS_OwnedPathName();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_NAME_EXP_CS__ELEMENT = eINSTANCE.getTypeNameExpCS_Element();

		/**
		 * The meta object literal for the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE = eINSTANCE.getTypeNameExpCS_OwnedCurlyBracketedClause();

		/**
		 * The meta object literal for the '<em><b>Owned Pattern Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD = eINSTANCE.getTypeNameExpCS_OwnedPatternGuard();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.UnlimitedNaturalLiteralExpCSImpl <em>Unlimited Natural Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.UnlimitedNaturalLiteralExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getUnlimitedNaturalLiteralExpCS()
		 * @generated
		 */
		EClass UNLIMITED_NATURAL_LITERAL_EXP_CS = eINSTANCE.getUnlimitedNaturalLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.VariableCSImpl <em>Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.VariableCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getVariableCS()
		 * @generated
		 */
		EClass VARIABLE_CS = eINSTANCE.getVariableCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CS__OWNED_TYPE = eINSTANCE.getVariableCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Owned Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CS__OWNED_INIT_EXPRESSION = eINSTANCE.getVariableCS_OwnedInitExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.VariableExpCSImpl <em>Variable Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.VariableExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getVariableExpCS()
		 * @generated
		 */
		EClass VARIABLE_EXP_CS = eINSTANCE.getVariableExpCS();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_EXP_CS__REFERRED_VARIABLE = eINSTANCE.getVariableExpCS_ReferredVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigationRole <em>Navigation Role</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigationRole
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNavigationRole()
		 * @generated
		 */
		EEnum NAVIGATION_ROLE = eINSTANCE.getNavigationRole();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.LiteralExpCSImpl <em>Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.LiteralExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLiteralExpCS()
		 * @generated
		 */
		EClass LITERAL_EXP_CS = eINSTANCE.getLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.MapLiteralExpCSImpl <em>Map Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.MapLiteralExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getMapLiteralExpCS()
		 * @generated
		 */
		EClass MAP_LITERAL_EXP_CS = eINSTANCE.getMapLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_LITERAL_EXP_CS__OWNED_PARTS = eINSTANCE.getMapLiteralExpCS_OwnedParts();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_LITERAL_EXP_CS__OWNED_TYPE = eINSTANCE.getMapLiteralExpCS_OwnedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.MapLiteralPartCSImpl <em>Map Literal Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.MapLiteralPartCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getMapLiteralPartCS()
		 * @generated
		 */
		EClass MAP_LITERAL_PART_CS = eINSTANCE.getMapLiteralPartCS();

		/**
		 * The meta object literal for the '<em><b>Owned Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_LITERAL_PART_CS__OWNED_KEY = eINSTANCE.getMapLiteralPartCS_OwnedKey();

		/**
		 * The meta object literal for the '<em><b>Owned Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_LITERAL_PART_CS__OWNED_VALUE = eINSTANCE.getMapLiteralPartCS_OwnedValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.MapTypeCSImpl <em>Map Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.MapTypeCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getMapTypeCS()
		 * @generated
		 */
		EClass MAP_TYPE_CS = eINSTANCE.getMapTypeCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAP_TYPE_CS__NAME = eINSTANCE.getMapTypeCS_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Key Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_TYPE_CS__OWNED_KEY_TYPE = eINSTANCE.getMapTypeCS_OwnedKeyType();

		/**
		 * The meta object literal for the '<em><b>Owned Value Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_TYPE_CS__OWNED_VALUE_TYPE = eINSTANCE.getMapTypeCS_OwnedValueType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.NameExpCSImpl <em>Name Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.NameExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNameExpCS()
		 * @generated
		 */
		EClass NAME_EXP_CS = eINSTANCE.getNameExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.NavigatingArgCSImpl <em>Navigating Arg CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.NavigatingArgCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNavigatingArgCS()
		 * @generated
		 */
		EClass NAVIGATING_ARG_CS = eINSTANCE.getNavigatingArgCS();

		/**
		 * The meta object literal for the '<em><b>Owning Round Bracketed Clause</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATING_ARG_CS__OWNING_ROUND_BRACKETED_CLAUSE = eINSTANCE.getNavigatingArgCS_OwningRoundBracketedClause();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATING_ARG_CS__ROLE = eINSTANCE.getNavigatingArgCS_Role();

		/**
		 * The meta object literal for the '<em><b>Owned Co Iterator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATING_ARG_CS__OWNED_CO_ITERATOR = eINSTANCE.getNavigatingArgCS_OwnedCoIterator();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATING_ARG_CS__PREFIX = eINSTANCE.getNavigatingArgCS_Prefix();

		/**
		 * The meta object literal for the '<em><b>Owned Name Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION = eINSTANCE.getNavigatingArgCS_OwnedNameExpression();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATING_ARG_CS__OWNED_TYPE = eINSTANCE.getNavigatingArgCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Owned Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION = eINSTANCE.getNavigatingArgCS_OwnedInitExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.NestedExpCSImpl <em>Nested Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.NestedExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNestedExpCS()
		 * @generated
		 */
		EClass NESTED_EXP_CS = eINSTANCE.getNestedExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NESTED_EXP_CS__OWNED_EXPRESSION = eINSTANCE.getNestedExpCS_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionLiteralExpCSImpl <em>Collection Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionLiteralExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionLiteralExpCS()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_EXP_CS = eINSTANCE.getCollectionLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP_CS__OWNED_TYPE = eINSTANCE.getCollectionLiteralExpCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP_CS__OWNED_PARTS = eINSTANCE.getCollectionLiteralExpCS_OwnedParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionLiteralPartCSImpl <em>Collection Literal Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionLiteralPartCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionLiteralPartCS()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_PART_CS = eINSTANCE.getCollectionLiteralPartCS();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION = eINSTANCE.getCollectionLiteralPartCS_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Owned Last Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION = eINSTANCE.getCollectionLiteralPartCS_OwnedLastExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionPatternCSImpl <em>Collection Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionPatternCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionPatternCS()
		 * @generated
		 */
		EClass COLLECTION_PATTERN_CS = eINSTANCE.getCollectionPatternCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_PATTERN_CS__OWNED_TYPE = eINSTANCE.getCollectionPatternCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_PATTERN_CS__OWNED_PARTS = eINSTANCE.getCollectionPatternCS_OwnedParts();

		/**
		 * The meta object literal for the '<em><b>Rest Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_PATTERN_CS__REST_VARIABLE_NAME = eINSTANCE.getCollectionPatternCS_RestVariableName();

		/**
		 * The meta object literal for the '<em><b>Owned Pattern Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_PATTERN_CS__OWNED_PATTERN_GUARD = eINSTANCE.getCollectionPatternCS_OwnedPatternGuard();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.PrimitiveLiteralExpCSImpl <em>Primitive Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.PrimitiveLiteralExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getPrimitiveLiteralExpCS()
		 * @generated
		 */
		EClass PRIMITIVE_LITERAL_EXP_CS = eINSTANCE.getPrimitiveLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.PropertyCallExpCSImpl <em>Property Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.PropertyCallExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getPropertyCallExpCS()
		 * @generated
		 */
		EClass PROPERTY_CALL_EXP_CS = eINSTANCE.getPropertyCallExpCS();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CALL_EXP_CS__REFERRED_PROPERTY = eINSTANCE.getPropertyCallExpCS_ReferredProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.RoundBracketedClauseCSImpl <em>Round Bracketed Clause CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.RoundBracketedClauseCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getRoundBracketedClauseCS()
		 * @generated
		 */
		EClass ROUND_BRACKETED_CLAUSE_CS = eINSTANCE.getRoundBracketedClauseCS();

		/**
		 * The meta object literal for the '<em><b>Owning Name Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUND_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP = eINSTANCE.getRoundBracketedClauseCS_OwningNameExp();

		/**
		 * The meta object literal for the '<em><b>Owned Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS = eINSTANCE.getRoundBracketedClauseCS_OwnedArguments();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.SelfExpCSImpl <em>Self Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.SelfExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getSelfExpCS()
		 * @generated
		 */
		EClass SELF_EXP_CS = eINSTANCE.getSelfExpCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELF_EXP_CS__NAME = eINSTANCE.getSelfExpCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ShadowExpCSImpl <em>Shadow Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.ShadowExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getShadowExpCS()
		 * @generated
		 */
		EClass SHADOW_EXP_CS = eINSTANCE.getShadowExpCS();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHADOW_EXP_CS__PARTS = eINSTANCE.getShadowExpCS_Parts();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHADOW_EXP_CS__TYPE_NAME = eINSTANCE.getShadowExpCS_TypeName();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHADOW_EXP_CS__VALUE = eINSTANCE.getShadowExpCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ShadowPartCSImpl <em>Shadow Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.ShadowPartCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getShadowPartCS()
		 * @generated
		 */
		EClass SHADOW_PART_CS = eINSTANCE.getShadowPartCS();

		/**
		 * The meta object literal for the '<em><b>Owned Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHADOW_PART_CS__OWNED_INIT_EXPRESSION = eINSTANCE.getShadowPartCS_OwnedInitExpression();

		/**
		 * The meta object literal for the '<em><b>Owning Curly Bracket Clause</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHADOW_PART_CS__OWNING_CURLY_BRACKET_CLAUSE = eINSTANCE.getShadowPartCS_OwningCurlyBracketClause();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHADOW_PART_CS__REFERRED_PROPERTY = eINSTANCE.getShadowPartCS_ReferredProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.SquareBracketedClauseCSImpl <em>Square Bracketed Clause CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.SquareBracketedClauseCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getSquareBracketedClauseCS()
		 * @generated
		 */
		EClass SQUARE_BRACKETED_CLAUSE_CS = eINSTANCE.getSquareBracketedClauseCS();

		/**
		 * The meta object literal for the '<em><b>Owning Name Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SQUARE_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP = eINSTANCE.getSquareBracketedClauseCS_OwningNameExp();

		/**
		 * The meta object literal for the '<em><b>Owned Terms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS = eINSTANCE.getSquareBracketedClauseCS_OwnedTerms();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.TupleLiteralExpCSImpl <em>Tuple Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.TupleLiteralExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTupleLiteralExpCS()
		 * @generated
		 */
		EClass TUPLE_LITERAL_EXP_CS = eINSTANCE.getTupleLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_LITERAL_EXP_CS__OWNED_PARTS = eINSTANCE.getTupleLiteralExpCS_OwnedParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.TupleLiteralPartCSImpl <em>Tuple Literal Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.TupleLiteralPartCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTupleLiteralPartCS()
		 * @generated
		 */
		EClass TUPLE_LITERAL_PART_CS = eINSTANCE.getTupleLiteralPartCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.StringLiteralExpCSImpl <em>String Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.StringLiteralExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getStringLiteralExpCS()
		 * @generated
		 */
		EClass STRING_LITERAL_EXP_CS = eINSTANCE.getStringLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Segments</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_EXP_CS__SEGMENTS = eINSTANCE.getStringLiteralExpCS_Segments();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.BooleanLiteralExpCSImpl <em>Boolean Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.BooleanLiteralExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getBooleanLiteralExpCS()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_EXP_CS = eINSTANCE.getBooleanLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_EXP_CS__SYMBOL = eINSTANCE.getBooleanLiteralExpCS_Symbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CallExpCSImpl <em>Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.CallExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCallExpCS()
		 * @generated
		 */
		EClass CALL_EXP_CS = eINSTANCE.getCallExpCS();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXP_CS__SOURCE = eINSTANCE.getCallExpCS_Source();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXP_CS__ARGUMENTS = eINSTANCE.getCallExpCS_Arguments();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.InvalidLiteralExpCSImpl <em>Invalid Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.InvalidLiteralExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getInvalidLiteralExpCS()
		 * @generated
		 */
		EClass INVALID_LITERAL_EXP_CS = eINSTANCE.getInvalidLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.IterateCallExpCSImpl <em>Iterate Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.IterateCallExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getIterateCallExpCS()
		 * @generated
		 */
		EClass ITERATE_CALL_EXP_CS = eINSTANCE.getIterateCallExpCS();

		/**
		 * The meta object literal for the '<em><b>Accumulators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATE_CALL_EXP_CS__ACCUMULATORS = eINSTANCE.getIterateCallExpCS_Accumulators();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.IterationCallExpCSImpl <em>Iteration Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.IterationCallExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getIterationCallExpCS()
		 * @generated
		 */
		EClass ITERATION_CALL_EXP_CS = eINSTANCE.getIterationCallExpCS();

		/**
		 * The meta object literal for the '<em><b>Co Iterators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION_CALL_EXP_CS__CO_ITERATORS = eINSTANCE.getIterationCallExpCS_CoIterators();

		/**
		 * The meta object literal for the '<em><b>Referred Iteration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION_CALL_EXP_CS__REFERRED_ITERATION = eINSTANCE.getIterationCallExpCS_ReferredIteration();

		/**
		 * The meta object literal for the '<em><b>Iterators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION_CALL_EXP_CS__ITERATORS = eINSTANCE.getIterationCallExpCS_Iterators();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.LambdaLiteralExpCSImpl <em>Lambda Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.LambdaLiteralExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLambdaLiteralExpCS()
		 * @generated
		 */
		EClass LAMBDA_LITERAL_EXP_CS = eINSTANCE.getLambdaLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Expression CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS = eINSTANCE.getLambdaLiteralExpCS_OwnedExpressionCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.NullLiteralExpCSImpl <em>Null Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.NullLiteralExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNullLiteralExpCS()
		 * @generated
		 */
		EClass NULL_LITERAL_EXP_CS = eINSTANCE.getNullLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.NumberLiteralExpCSImpl <em>Number Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.NumberLiteralExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNumberLiteralExpCS()
		 * @generated
		 */
		EClass NUMBER_LITERAL_EXP_CS = eINSTANCE.getNumberLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_LITERAL_EXP_CS__SYMBOL = eINSTANCE.getNumberLiteralExpCS_Symbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.OperationCallExpCSImpl <em>Operation Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.OperationCallExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getOperationCallExpCS()
		 * @generated
		 */
		EClass OPERATION_CALL_EXP_CS = eINSTANCE.getOperationCallExpCS();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL_EXP_CS__REFERRED_OPERATION = eINSTANCE.getOperationCallExpCS_ReferredOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.OperatorExpCSImpl <em>Operator Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.OperatorExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getOperatorExpCS()
		 * @generated
		 */
		EClass OPERATOR_EXP_CS = eINSTANCE.getOperatorExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_EXP_CS__OWNED_RIGHT = eINSTANCE.getOperatorExpCS_OwnedRight();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_EXP_CS__SOURCE = eINSTANCE.getOperatorExpCS_Source();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.PatternExpCSImpl <em>Pattern Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.PatternExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getPatternExpCS()
		 * @generated
		 */
		EClass PATTERN_EXP_CS = eINSTANCE.getPatternExpCS();

		/**
		 * The meta object literal for the '<em><b>Pattern Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_EXP_CS__PATTERN_VARIABLE_NAME = eINSTANCE.getPatternExpCS_PatternVariableName();

		/**
		 * The meta object literal for the '<em><b>Owned Pattern Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_EXP_CS__OWNED_PATTERN_TYPE = eINSTANCE.getPatternExpCS_OwnedPatternType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.IfExpCSImpl <em>If Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.IfExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getIfExpCS()
		 * @generated
		 */
		EClass IF_EXP_CS = eINSTANCE.getIfExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP_CS__OWNED_CONDITION = eINSTANCE.getIfExpCS_OwnedCondition();

		/**
		 * The meta object literal for the '<em><b>Owned Then Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP_CS__OWNED_THEN_EXPRESSION = eINSTANCE.getIfExpCS_OwnedThenExpression();

		/**
		 * The meta object literal for the '<em><b>Owned If Then Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS = eINSTANCE.getIfExpCS_OwnedIfThenExpressions();

		/**
		 * The meta object literal for the '<em><b>Owned Else Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP_CS__OWNED_ELSE_EXPRESSION = eINSTANCE.getIfExpCS_OwnedElseExpression();

		/**
		 * The meta object literal for the '<em><b>Is Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IF_EXP_CS__IS_IMPLICIT = eINSTANCE.getIfExpCS_IsImplicit();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.IfThenExpCSImpl <em>If Then Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.IfThenExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getIfThenExpCS()
		 * @generated
		 */
		EClass IF_THEN_EXP_CS = eINSTANCE.getIfThenExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_THEN_EXP_CS__OWNED_CONDITION = eINSTANCE.getIfThenExpCS_OwnedCondition();

		/**
		 * The meta object literal for the '<em><b>Owned Then Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION = eINSTANCE.getIfThenExpCS_OwnedThenExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.InfixExpCSImpl <em>Infix Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.InfixExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getInfixExpCS()
		 * @generated
		 */
		EClass INFIX_EXP_CS = eINSTANCE.getInfixExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFIX_EXP_CS__OWNED_LEFT = eINSTANCE.getInfixExpCS_OwnedLeft();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFIX_EXP_CS__ARGUMENT = eINSTANCE.getInfixExpCS_Argument();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.LetExpCSImpl <em>Let Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.LetExpCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLetExpCS()
		 * @generated
		 */
		EClass LET_EXP_CS = eINSTANCE.getLetExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP_CS__OWNED_VARIABLES = eINSTANCE.getLetExpCS_OwnedVariables();

		/**
		 * The meta object literal for the '<em><b>Owned In Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP_CS__OWNED_IN_EXPRESSION = eINSTANCE.getLetExpCS_OwnedInExpression();

		/**
		 * The meta object literal for the '<em><b>Is Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LET_EXP_CS__IS_IMPLICIT = eINSTANCE.getLetExpCS_IsImplicit();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.essentialoclcs.impl.LetVariableCSImpl <em>Let Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.LetVariableCSImpl
		 * @see org.eclipse.ocl.xtext.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLetVariableCS()
		 * @generated
		 */
		EClass LET_VARIABLE_CS = eINSTANCE.getLetVariableCS();

		/**
		 * The meta object literal for the '<em><b>Owning Let Expression</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_VARIABLE_CS__OWNING_LET_EXPRESSION = eINSTANCE.getLetVariableCS_OwningLetExpression();

		/**
		 * The meta object literal for the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE = eINSTANCE.getLetVariableCS_OwnedRoundBracketedClause();

	}

} //EssentialOCLCSPackage
