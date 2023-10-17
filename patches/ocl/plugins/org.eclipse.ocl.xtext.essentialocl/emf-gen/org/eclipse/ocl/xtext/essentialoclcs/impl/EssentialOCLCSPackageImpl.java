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
package org.eclipse.ocl.xtext.essentialoclcs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.impl.ContextLessElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.SpecificationCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.TypedRefCSImpl;
import org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CallExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSFactory;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.LiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigationRole;
import org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.OperationCallExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrimitiveLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EssentialOCLCSPackageImpl
extends EPackageImpl
implements EssentialOCLCSPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractNameExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationClassCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prefixExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass curlyBracketedClauseCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expSpecificationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeNameExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unlimitedNaturalLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum navigationRoleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapLiteralPartCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigatingArgCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nestedExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionLiteralPartCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionPatternCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roundBracketedClauseCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selfExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shadowExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shadowPartCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass squareBracketedClauseCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleLiteralPartCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invalidLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterateCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterationCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lambdaLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifThenExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass infixExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass letExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass letVariableCSEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EssentialOCLCSPackageImpl() {
		super(eNS_URI, EssentialOCLCSFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link EssentialOCLCSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EssentialOCLCSPackage init() {
		if (isInited) return (EssentialOCLCSPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredEssentialOCLCSPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EssentialOCLCSPackageImpl theEssentialOCLCSPackage = registeredEssentialOCLCSPackage instanceof EssentialOCLCSPackageImpl ? (EssentialOCLCSPackageImpl)registeredEssentialOCLCSPackage : new EssentialOCLCSPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BaseCSPackage.eINSTANCE.eClass();
		PivotPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEssentialOCLCSPackage.createPackageContents();

		// Initialize created meta-data
		theEssentialOCLCSPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEssentialOCLCSPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EssentialOCLCSPackage.eNS_URI, theEssentialOCLCSPackage);
		return theEssentialOCLCSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractNameExpCS()
	{
		return abstractNameExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractNameExpCS_OwnedPathName()
	{
		return (EReference)abstractNameExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractNameExpCS_IsPre()
	{
		return (EAttribute)abstractNameExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractNameExpCS_OwnedCurlyBracketedClause()
	{
		return (EReference)abstractNameExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractNameExpCS_OwnedRoundBracketedClause()
	{
		return (EReference)abstractNameExpCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractNameExpCS_OwnedSquareBracketedClauses()
	{
		return (EReference)abstractNameExpCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractNameExpCS_SourceType()
	{
		return (EReference)abstractNameExpCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractNameExpCS_SourceTypeValue()
	{
		return (EReference)abstractNameExpCSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssociationClassCallExpCS()
	{
		return associationClassCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssociationClassCallExpCS_ReferredAssociation()
	{
		return (EReference)associationClassCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrefixExpCS() {
		return prefixExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollectionTypeCS() {
		return collectionTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCollectionTypeCS_Name() {
		return (EAttribute)collectionTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionTypeCS_OwnedCollectionMultiplicity()
	{
		return (EReference)collectionTypeCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionTypeCS_OwnedType() {
		return (EReference)collectionTypeCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContextCS() {
		return contextCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContextCS_OwnedExpression() {
		return (EReference)contextCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCurlyBracketedClauseCS()
	{
		return curlyBracketedClauseCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCurlyBracketedClauseCS_OwningNameExp()
	{
		return (EReference)curlyBracketedClauseCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCurlyBracketedClauseCS_OwnedParts()
	{
		return (EReference)curlyBracketedClauseCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCurlyBracketedClauseCS_Value()
	{
		return (EAttribute)curlyBracketedClauseCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpCS() {
		return expCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExpCS_HasError()
	{
		return (EAttribute)expCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpCS_LocalLeft()
	{
		return (EReference)expCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpCS_LocalLeftmostDescendant()
	{
		return (EReference)expCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpCS_LocalParent()
	{
		return (EReference)expCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpCS_LocalRight()
	{
		return (EReference)expCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpCS_LocalRightmostDescendant()
	{
		return (EReference)expCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpCS_Precedence()
	{
		return (EReference)expCSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExpCS_PrecedenceOrder()
	{
		return (EAttribute)expCSEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpSpecificationCS() {
		return expSpecificationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpSpecificationCS_OwnedExpression() {
		return (EReference)expSpecificationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeLiteralExpCS() {
		return typeLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeLiteralExpCS_OwnedPathName()
	{
		return (EReference)typeLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeLiteralExpCS_OwnedType() {
		return (EReference)typeLiteralExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeNameExpCS() {
		return typeNameExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeNameExpCS_OwnedPathName()
	{
		return (EReference)typeNameExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeNameExpCS_Element() {
		return (EReference)typeNameExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeNameExpCS_OwnedCurlyBracketedClause()
	{
		return (EReference)typeNameExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeNameExpCS_OwnedPatternGuard()
	{
		return (EReference)typeNameExpCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnlimitedNaturalLiteralExpCS() {
		return unlimitedNaturalLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableCS() {
		return variableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableCS_OwnedType() {
		return (EReference)variableCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableCS_OwnedInitExpression()
	{
		return (EReference)variableCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableExpCS()
	{
		return variableExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableExpCS_ReferredVariable()
	{
		return (EReference)variableExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getNavigationRole() {
		return navigationRoleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralExpCS() {
		return literalExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMapLiteralExpCS()
	{
		return mapLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapLiteralExpCS_OwnedParts()
	{
		return (EReference)mapLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapLiteralExpCS_OwnedType()
	{
		return (EReference)mapLiteralExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMapLiteralPartCS()
	{
		return mapLiteralPartCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapLiteralPartCS_OwnedKey()
	{
		return (EReference)mapLiteralPartCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapLiteralPartCS_OwnedValue()
	{
		return (EReference)mapLiteralPartCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMapTypeCS()
	{
		return mapTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMapTypeCS_Name()
	{
		return (EAttribute)mapTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapTypeCS_OwnedKeyType()
	{
		return (EReference)mapTypeCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapTypeCS_OwnedValueType()
	{
		return (EReference)mapTypeCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNameExpCS() {
		return nameExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNavigatingArgCS() {
		return navigatingArgCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigatingArgCS_OwningRoundBracketedClause()
	{
		return (EReference)navigatingArgCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNavigatingArgCS_Role() {
		return (EAttribute)navigatingArgCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigatingArgCS_OwnedCoIterator()
	{
		return (EReference)navigatingArgCSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNavigatingArgCS_Prefix() {
		return (EAttribute)navigatingArgCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigatingArgCS_OwnedNameExpression()
	{
		return (EReference)navigatingArgCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigatingArgCS_OwnedType() {
		return (EReference)navigatingArgCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigatingArgCS_OwnedInitExpression()
	{
		return (EReference)navigatingArgCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNestedExpCS() {
		return nestedExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNestedExpCS_OwnedExpression()
	{
		return (EReference)nestedExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollectionLiteralExpCS() {
		return collectionLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionLiteralExpCS_OwnedType() {
		return (EReference)collectionLiteralExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionLiteralExpCS_OwnedParts() {
		return (EReference)collectionLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollectionLiteralPartCS() {
		return collectionLiteralPartCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionLiteralPartCS_OwnedExpression()
	{
		return (EReference)collectionLiteralPartCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionLiteralPartCS_OwnedLastExpression()
	{
		return (EReference)collectionLiteralPartCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollectionPatternCS()
	{
		return collectionPatternCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionPatternCS_OwnedType()
	{
		return (EReference)collectionPatternCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionPatternCS_OwnedParts()
	{
		return (EReference)collectionPatternCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCollectionPatternCS_RestVariableName()
	{
		return (EAttribute)collectionPatternCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionPatternCS_OwnedPatternGuard()
	{
		return (EReference)collectionPatternCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveLiteralExpCS() {
		return primitiveLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyCallExpCS()
	{
		return propertyCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyCallExpCS_ReferredProperty()
	{
		return (EReference)propertyCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRoundBracketedClauseCS()
	{
		return roundBracketedClauseCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoundBracketedClauseCS_OwningNameExp()
	{
		return (EReference)roundBracketedClauseCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoundBracketedClauseCS_OwnedArguments()
	{
		return (EReference)roundBracketedClauseCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSelfExpCS() {
		return selfExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSelfExpCS_Name() {
		return (EAttribute)selfExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getShadowExpCS()
	{
		return shadowExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getShadowExpCS_Parts()
	{
		return (EReference)shadowExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getShadowExpCS_TypeName()
	{
		return (EReference)shadowExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getShadowExpCS_Value()
	{
		return (EAttribute)shadowExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getShadowPartCS()
	{
		return shadowPartCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getShadowPartCS_OwnedInitExpression()
	{
		return (EReference)shadowPartCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getShadowPartCS_OwningCurlyBracketClause()
	{
		return (EReference)shadowPartCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getShadowPartCS_ReferredProperty()
	{
		return (EReference)shadowPartCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSquareBracketedClauseCS()
	{
		return squareBracketedClauseCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSquareBracketedClauseCS_OwningNameExp()
	{
		return (EReference)squareBracketedClauseCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSquareBracketedClauseCS_OwnedTerms()
	{
		return (EReference)squareBracketedClauseCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTupleLiteralExpCS() {
		return tupleLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTupleLiteralExpCS_OwnedParts() {
		return (EReference)tupleLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTupleLiteralPartCS() {
		return tupleLiteralPartCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringLiteralExpCS() {
		return stringLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringLiteralExpCS_Segments()
	{
		return (EAttribute)stringLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanLiteralExpCS() {
		return booleanLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBooleanLiteralExpCS_Symbol()
	{
		return (EAttribute)booleanLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCallExpCS()
	{
		return callExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCallExpCS_Source()
	{
		return (EReference)callExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCallExpCS_Arguments()
	{
		return (EReference)callExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInvalidLiteralExpCS() {
		return invalidLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIterateCallExpCS()
	{
		return iterateCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIterateCallExpCS_Accumulators()
	{
		return (EReference)iterateCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIterationCallExpCS()
	{
		return iterationCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIterationCallExpCS_CoIterators()
	{
		return (EReference)iterationCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIterationCallExpCS_ReferredIteration()
	{
		return (EReference)iterationCallExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIterationCallExpCS_Iterators()
	{
		return (EReference)iterationCallExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLambdaLiteralExpCS()
	{
		return lambdaLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLambdaLiteralExpCS_OwnedExpressionCS()
	{
		return (EReference)lambdaLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNullLiteralExpCS() {
		return nullLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNumberLiteralExpCS() {
		return numberLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNumberLiteralExpCS_Symbol()
	{
		return (EAttribute)numberLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperationCallExpCS()
	{
		return operationCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationCallExpCS_ReferredOperation()
	{
		return (EReference)operationCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperatorExpCS()
	{
		return operatorExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperatorExpCS_OwnedRight()
	{
		return (EReference)operatorExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperatorExpCS_Source()
	{
		return (EReference)operatorExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPatternExpCS()
	{
		return patternExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPatternExpCS_PatternVariableName()
	{
		return (EAttribute)patternExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPatternExpCS_OwnedPatternType()
	{
		return (EReference)patternExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EssentialOCLCSFactory getEssentialOCLCSFactory() {
		return (EssentialOCLCSFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIfExpCS() {
		return ifExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfExpCS_OwnedCondition()
	{
		return (EReference)ifExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfExpCS_OwnedThenExpression()
	{
		return (EReference)ifExpCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfExpCS_OwnedIfThenExpressions()
	{
		return (EReference)ifExpCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfExpCS_OwnedElseExpression()
	{
		return (EReference)ifExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIfExpCS_IsImplicit()
	{
		return (EAttribute)ifExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIfThenExpCS()
	{
		return ifThenExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfThenExpCS_OwnedCondition()
	{
		return (EReference)ifThenExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfThenExpCS_OwnedThenExpression()
	{
		return (EReference)ifThenExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInfixExpCS() {
		return infixExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInfixExpCS_OwnedLeft()
	{
		return (EReference)infixExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInfixExpCS_Argument()
	{
		return (EReference)infixExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLetExpCS() {
		return letExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLetExpCS_OwnedVariables()
	{
		return (EReference)letExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLetExpCS_OwnedInExpression()
	{
		return (EReference)letExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLetExpCS_IsImplicit()
	{
		return (EAttribute)letExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLetVariableCS() {
		return letVariableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLetVariableCS_OwningLetExpression()
	{
		return (EReference)letVariableCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLetVariableCS_OwnedRoundBracketedClause()
	{
		return (EReference)letVariableCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractNameExpCSEClass = createEClass(0);
		createEAttribute(abstractNameExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);
		createEReference(abstractNameExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9);
		createEReference(abstractNameExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 10);
		createEReference(abstractNameExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 11);
		createEReference(abstractNameExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 12);
		createEReference(abstractNameExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 13);
		createEReference(abstractNameExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 14);

		associationClassCallExpCSEClass = createEClass(1);
		createEReference(associationClassCallExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 17);

		booleanLiteralExpCSEClass = createEClass(2);
		createEAttribute(booleanLiteralExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);

		callExpCSEClass = createEClass(3);
		createEReference(callExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 15);
		createEReference(callExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 16);

		collectionLiteralExpCSEClass = createEClass(4);
		createEReference(collectionLiteralExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);
		createEReference(collectionLiteralExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9);

		collectionLiteralPartCSEClass = createEClass(5);
		createEReference(collectionLiteralPartCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(collectionLiteralPartCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 1);

		collectionPatternCSEClass = createEClass(6);
		createEReference(collectionPatternCSEClass, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 0);
		createEReference(collectionPatternCSEClass, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1);
		createEReference(collectionPatternCSEClass, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2);
		createEAttribute(collectionPatternCSEClass, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 3);

		collectionTypeCSEClass = createEClass(7);
		createEAttribute(collectionTypeCSEClass, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 0);
		createEReference(collectionTypeCSEClass, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1);
		createEReference(collectionTypeCSEClass, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2);

		contextCSEClass = createEClass(8);
		createEReference(contextCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1);

		curlyBracketedClauseCSEClass = createEClass(9);
		createEReference(curlyBracketedClauseCSEClass, ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(curlyBracketedClauseCSEClass, ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1);
		createEAttribute(curlyBracketedClauseCSEClass, ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 2);

		expCSEClass = createEClass(10);
		createEAttribute(expCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(expCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 1);
		createEReference(expCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 2);
		createEReference(expCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 3);
		createEReference(expCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 4);
		createEReference(expCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 5);
		createEReference(expCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 6);
		createEAttribute(expCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 7);

		expSpecificationCSEClass = createEClass(11);
		createEReference(expSpecificationCSEClass, SpecificationCSImpl.SPECIFICATION_CS_FEATURE_COUNT + 0);

		ifExpCSEClass = createEClass(12);
		createEAttribute(ifExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);
		createEReference(ifExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9);
		createEReference(ifExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 10);
		createEReference(ifExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 11);
		createEReference(ifExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 12);

		ifThenExpCSEClass = createEClass(13);
		createEReference(ifThenExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);
		createEReference(ifThenExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9);

		infixExpCSEClass = createEClass(14);
		createEReference(infixExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 11);
		createEReference(infixExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 12);

		invalidLiteralExpCSEClass = createEClass(15);

		iterateCallExpCSEClass = createEClass(16);
		createEReference(iterateCallExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 20);

		iterationCallExpCSEClass = createEClass(17);
		createEReference(iterationCallExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 17);
		createEReference(iterationCallExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 18);
		createEReference(iterationCallExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 19);

		lambdaLiteralExpCSEClass = createEClass(18);
		createEReference(lambdaLiteralExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);

		letExpCSEClass = createEClass(19);
		createEAttribute(letExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);
		createEReference(letExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9);
		createEReference(letExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 10);

		letVariableCSEClass = createEClass(20);
		createEReference(letVariableCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 11);
		createEReference(letVariableCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 12);

		literalExpCSEClass = createEClass(21);

		mapLiteralExpCSEClass = createEClass(22);
		createEReference(mapLiteralExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);
		createEReference(mapLiteralExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9);

		mapLiteralPartCSEClass = createEClass(23);
		createEReference(mapLiteralPartCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(mapLiteralPartCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 1);

		mapTypeCSEClass = createEClass(24);
		createEAttribute(mapTypeCSEClass, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 0);
		createEReference(mapTypeCSEClass, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1);
		createEReference(mapTypeCSEClass, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2);

		nameExpCSEClass = createEClass(25);

		navigatingArgCSEClass = createEClass(26);
		createEReference(navigatingArgCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(navigatingArgCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 1);
		createEReference(navigatingArgCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 2);
		createEReference(navigatingArgCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 3);
		createEAttribute(navigatingArgCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 4);
		createEAttribute(navigatingArgCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 5);
		createEReference(navigatingArgCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 6);

		nestedExpCSEClass = createEClass(27);
		createEReference(nestedExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);

		nullLiteralExpCSEClass = createEClass(28);

		numberLiteralExpCSEClass = createEClass(29);
		createEAttribute(numberLiteralExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);

		operationCallExpCSEClass = createEClass(30);
		createEReference(operationCallExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 17);

		operatorExpCSEClass = createEClass(31);
		createEReference(operatorExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9);
		createEReference(operatorExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 10);

		patternExpCSEClass = createEClass(32);
		createEReference(patternExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);
		createEAttribute(patternExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9);

		prefixExpCSEClass = createEClass(33);

		primitiveLiteralExpCSEClass = createEClass(34);

		propertyCallExpCSEClass = createEClass(35);
		createEReference(propertyCallExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 17);

		roundBracketedClauseCSEClass = createEClass(36);
		createEReference(roundBracketedClauseCSEClass, ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(roundBracketedClauseCSEClass, ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1);

		selfExpCSEClass = createEClass(37);
		createEAttribute(selfExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);

		shadowExpCSEClass = createEClass(38);
		createEReference(shadowExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 15);
		createEReference(shadowExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 16);
		createEAttribute(shadowExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 17);

		shadowPartCSEClass = createEClass(39);
		createEReference(shadowPartCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(shadowPartCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 1);
		createEReference(shadowPartCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 2);

		squareBracketedClauseCSEClass = createEClass(40);
		createEReference(squareBracketedClauseCSEClass, ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(squareBracketedClauseCSEClass, ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1);

		stringLiteralExpCSEClass = createEClass(41);
		createEAttribute(stringLiteralExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);

		tupleLiteralExpCSEClass = createEClass(42);
		createEReference(tupleLiteralExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);

		tupleLiteralPartCSEClass = createEClass(43);

		typeLiteralExpCSEClass = createEClass(44);
		createEReference(typeLiteralExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8);
		createEReference(typeLiteralExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9);

		typeNameExpCSEClass = createEClass(45);
		createEReference(typeNameExpCSEClass, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 0);
		createEReference(typeNameExpCSEClass, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1);
		createEReference(typeNameExpCSEClass, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2);
		createEReference(typeNameExpCSEClass, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 3);

		unlimitedNaturalLiteralExpCSEClass = createEClass(46);

		variableCSEClass = createEClass(47);
		createEReference(variableCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(variableCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1);

		variableExpCSEClass = createEClass(48);
		createEReference(variableExpCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 15);

		// Create enums
		navigationRoleEEnum = createEEnum(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BaseCSPackage theBaseCSPackage = (BaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractNameExpCSEClass.getESuperTypes().add(this.getExpCS());
		associationClassCallExpCSEClass.getESuperTypes().add(this.getCallExpCS());
		booleanLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		callExpCSEClass.getESuperTypes().add(this.getAbstractNameExpCS());
		collectionLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		collectionLiteralPartCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		collectionPatternCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedRefCS());
		collectionTypeCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedRefCS());
		contextCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		contextCSEClass.getESuperTypes().add(theBaseCSPackage.getRootCS());
		curlyBracketedClauseCSEClass.getESuperTypes().add(theBaseCSPackage.getContextLessElementCS());
		expCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		expSpecificationCSEClass.getESuperTypes().add(theBaseCSPackage.getSpecificationCS());
		ifExpCSEClass.getESuperTypes().add(this.getExpCS());
		ifThenExpCSEClass.getESuperTypes().add(this.getExpCS());
		infixExpCSEClass.getESuperTypes().add(this.getOperatorExpCS());
		invalidLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		iterateCallExpCSEClass.getESuperTypes().add(this.getIterationCallExpCS());
		iterationCallExpCSEClass.getESuperTypes().add(this.getCallExpCS());
		lambdaLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		letExpCSEClass.getESuperTypes().add(this.getExpCS());
		letVariableCSEClass.getESuperTypes().add(this.getExpCS());
		letVariableCSEClass.getESuperTypes().add(this.getVariableCS());
		literalExpCSEClass.getESuperTypes().add(this.getExpCS());
		mapLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		mapLiteralPartCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		mapTypeCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedRefCS());
		nameExpCSEClass.getESuperTypes().add(this.getAssociationClassCallExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getShadowExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getIterateCallExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getIterationCallExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getOperationCallExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getPropertyCallExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getVariableExpCS());
		navigatingArgCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		nestedExpCSEClass.getESuperTypes().add(this.getExpCS());
		nullLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		numberLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		operationCallExpCSEClass.getESuperTypes().add(this.getCallExpCS());
		operatorExpCSEClass.getESuperTypes().add(this.getExpCS());
		operatorExpCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		patternExpCSEClass.getESuperTypes().add(this.getExpCS());
		prefixExpCSEClass.getESuperTypes().add(this.getOperatorExpCS());
		primitiveLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		propertyCallExpCSEClass.getESuperTypes().add(this.getCallExpCS());
		roundBracketedClauseCSEClass.getESuperTypes().add(theBaseCSPackage.getContextLessElementCS());
		selfExpCSEClass.getESuperTypes().add(this.getExpCS());
		shadowExpCSEClass.getESuperTypes().add(this.getAbstractNameExpCS());
		shadowPartCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		squareBracketedClauseCSEClass.getESuperTypes().add(theBaseCSPackage.getContextLessElementCS());
		stringLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		tupleLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		tupleLiteralPartCSEClass.getESuperTypes().add(this.getVariableCS());
		typeLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		typeNameExpCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedRefCS());
		unlimitedNaturalLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		variableCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		variableExpCSEClass.getESuperTypes().add(this.getAbstractNameExpCS());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractNameExpCSEClass, AbstractNameExpCS.class, "AbstractNameExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAbstractNameExpCS_IsPre(), ecorePackage.getEBoolean(), "isPre", "false", 0, 1, AbstractNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getAbstractNameExpCS_OwnedCurlyBracketedClause(), this.getCurlyBracketedClauseCS(), this.getCurlyBracketedClauseCS_OwningNameExp(), "ownedCurlyBracketedClause", null, 0, 1, AbstractNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractNameExpCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, AbstractNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractNameExpCS_OwnedRoundBracketedClause(), this.getRoundBracketedClauseCS(), this.getRoundBracketedClauseCS_OwningNameExp(), "ownedRoundBracketedClause", null, 0, 1, AbstractNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractNameExpCS_OwnedSquareBracketedClauses(), this.getSquareBracketedClauseCS(), this.getSquareBracketedClauseCS_OwningNameExp(), "ownedSquareBracketedClauses", null, 0, 2, AbstractNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractNameExpCS_SourceType(), thePivotPackage.getType(), null, "sourceType", null, 0, 1, AbstractNameExpCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractNameExpCS_SourceTypeValue(), thePivotPackage.getType(), null, "sourceTypeValue", null, 0, 1, AbstractNameExpCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(associationClassCallExpCSEClass, AssociationClassCallExpCS.class, "AssociationClassCallExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAssociationClassCallExpCS_ReferredAssociation(), thePivotPackage.getAssociationClass(), null, "referredAssociation", null, 0, 1, AssociationClassCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(booleanLiteralExpCSEClass, BooleanLiteralExpCS.class, "BooleanLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getBooleanLiteralExpCS_Symbol(), ecorePackage.getEString(), "symbol", null, 0, 1, BooleanLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(callExpCSEClass, CallExpCS.class, "CallExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCallExpCS_Arguments(), this.getExpCS(), null, "arguments", null, 0, -1, CallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCallExpCS_Source(), this.getExpCS(), null, "source", null, 0, 1, CallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionLiteralExpCSEClass, CollectionLiteralExpCS.class, "CollectionLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCollectionLiteralExpCS_OwnedParts(), this.getCollectionLiteralPartCS(), null, "ownedParts", null, 0, -1, CollectionLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionLiteralExpCS_OwnedType(), this.getCollectionTypeCS(), null, "ownedType", null, 0, 1, CollectionLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionLiteralPartCSEClass, CollectionLiteralPartCS.class, "CollectionLiteralPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCollectionLiteralPartCS_OwnedExpression(), this.getExpCS(), null, "ownedExpression", null, 0, 1, CollectionLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionLiteralPartCS_OwnedLastExpression(), this.getExpCS(), null, "ownedLastExpression", null, 0, 1, CollectionLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionPatternCSEClass, CollectionPatternCS.class, "CollectionPatternCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCollectionPatternCS_OwnedParts(), this.getPatternExpCS(), null, "ownedParts", null, 0, -1, CollectionPatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionPatternCS_OwnedPatternGuard(), this.getExpCS(), null, "ownedPatternGuard", null, 0, 1, CollectionPatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionPatternCS_OwnedType(), this.getCollectionTypeCS(), null, "ownedType", null, 0, 1, CollectionPatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getCollectionPatternCS_RestVariableName(), ecorePackage.getEString(), "restVariableName", null, 0, 1, CollectionPatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionTypeCSEClass, CollectionTypeCS.class, "CollectionTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getCollectionTypeCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, CollectionTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionTypeCS_OwnedCollectionMultiplicity(), theBaseCSPackage.getMultiplicityCS(), null, "ownedCollectionMultiplicity", null, 0, 1, CollectionTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionTypeCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, CollectionTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(contextCSEClass, ContextCS.class, "ContextCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getContextCS_OwnedExpression(), this.getExpCS(), null, "ownedExpression", null, 0, 1, ContextCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(curlyBracketedClauseCSEClass, CurlyBracketedClauseCS.class, "CurlyBracketedClauseCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCurlyBracketedClauseCS_OwnedParts(), this.getShadowPartCS(), this.getShadowPartCS_OwningCurlyBracketClause(), "ownedParts", null, 0, -1, CurlyBracketedClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCurlyBracketedClauseCS_OwningNameExp(), this.getAbstractNameExpCS(), this.getAbstractNameExpCS_OwnedCurlyBracketedClause(), "owningNameExp", null, 0, 1, CurlyBracketedClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getCurlyBracketedClauseCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, CurlyBracketedClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(expCSEClass, ExpCS.class, "ExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getExpCS_HasError(), ecorePackage.getEBoolean(), "hasError", "false", 0, 1, ExpCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getExpCS_LocalLeft(), this.getExpCS(), null, "localLeft", null, 0, 1, ExpCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getExpCS_LocalLeftmostDescendant(), this.getExpCS(), null, "localLeftmostDescendant", null, 1, 1, ExpCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getExpCS_LocalParent(), this.getOperatorExpCS(), null, "localParent", null, 0, 1, ExpCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getExpCS_LocalRight(), this.getExpCS(), null, "localRight", null, 0, 1, ExpCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getExpCS_LocalRightmostDescendant(), this.getExpCS(), null, "localRightmostDescendant", null, 1, 1, ExpCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getExpCS_Precedence(), thePivotPackage.getPrecedence(), null, "precedence", null, 0, 1, ExpCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getExpCS_PrecedenceOrder(), ecorePackage.getEInt(), "precedenceOrder", null, 0, 1, ExpCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		EOperation op = addEOperation(expCSEClass, ecorePackage.getEBoolean(), "isLocalLeftAncestorOf", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getExpCS(), "csExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(expCSEClass, ecorePackage.getEBoolean(), "isLocalRightAncestorOf", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getExpCS(), "csExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(expSpecificationCSEClass, ExpSpecificationCS.class, "ExpSpecificationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getExpSpecificationCS_OwnedExpression(), this.getExpCS(), null, "ownedExpression", null, 0, 1, ExpSpecificationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ifExpCSEClass, IfExpCS.class, "IfExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIfExpCS_IsImplicit(), ecorePackage.getEBoolean(), "isImplicit", "false", 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getIfExpCS_OwnedCondition(), this.getExpCS(), null, "ownedCondition", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIfExpCS_OwnedElseExpression(), this.getExpCS(), null, "ownedElseExpression", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIfExpCS_OwnedIfThenExpressions(), this.getIfThenExpCS(), null, "ownedIfThenExpressions", null, 0, -1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIfExpCS_OwnedThenExpression(), this.getExpCS(), null, "ownedThenExpression", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ifThenExpCSEClass, IfThenExpCS.class, "IfThenExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIfThenExpCS_OwnedCondition(), this.getExpCS(), null, "ownedCondition", null, 0, 1, IfThenExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIfThenExpCS_OwnedThenExpression(), this.getExpCS(), null, "ownedThenExpression", null, 0, 1, IfThenExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(infixExpCSEClass, InfixExpCS.class, "InfixExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getInfixExpCS_Argument(), this.getExpCS(), null, "argument", null, 0, 1, InfixExpCS.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getInfixExpCS_OwnedLeft(), this.getExpCS(), null, "ownedLeft", null, 1, 1, InfixExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(invalidLiteralExpCSEClass, InvalidLiteralExpCS.class, "InvalidLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iterateCallExpCSEClass, IterateCallExpCS.class, "IterateCallExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIterateCallExpCS_Accumulators(), this.getVariableCS(), null, "accumulators", null, 0, -1, IterateCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(iterationCallExpCSEClass, IterationCallExpCS.class, "IterationCallExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIterationCallExpCS_CoIterators(), this.getVariableCS(), null, "coIterators", null, 0, -1, IterationCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIterationCallExpCS_Iterators(), this.getVariableCS(), null, "iterators", null, 0, -1, IterationCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIterationCallExpCS_ReferredIteration(), thePivotPackage.getIteration(), null, "referredIteration", null, 0, 1, IterationCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(lambdaLiteralExpCSEClass, LambdaLiteralExpCS.class, "LambdaLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLambdaLiteralExpCS_OwnedExpressionCS(), this.getExpCS(), null, "ownedExpressionCS", null, 0, 1, LambdaLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(letExpCSEClass, LetExpCS.class, "LetExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLetExpCS_IsImplicit(), ecorePackage.getEBoolean(), "isImplicit", "false", 0, 1, LetExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getLetExpCS_OwnedInExpression(), this.getExpCS(), null, "ownedInExpression", null, 0, 1, LetExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLetExpCS_OwnedVariables(), this.getLetVariableCS(), this.getLetVariableCS_OwningLetExpression(), "ownedVariables", null, 0, -1, LetExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(letVariableCSEClass, LetVariableCS.class, "LetVariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLetVariableCS_OwnedRoundBracketedClause(), this.getRoundBracketedClauseCS(), null, "ownedRoundBracketedClause", null, 0, 1, LetVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLetVariableCS_OwningLetExpression(), this.getLetExpCS(), this.getLetExpCS_OwnedVariables(), "owningLetExpression", null, 0, 1, LetVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(literalExpCSEClass, LiteralExpCS.class, "LiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mapLiteralExpCSEClass, MapLiteralExpCS.class, "MapLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getMapLiteralExpCS_OwnedParts(), this.getMapLiteralPartCS(), null, "ownedParts", null, 0, -1, MapLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMapLiteralExpCS_OwnedType(), this.getMapTypeCS(), null, "ownedType", null, 0, 1, MapLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mapLiteralPartCSEClass, MapLiteralPartCS.class, "MapLiteralPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getMapLiteralPartCS_OwnedKey(), this.getExpCS(), null, "ownedKey", null, 0, 1, MapLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMapLiteralPartCS_OwnedValue(), this.getExpCS(), null, "ownedValue", null, 0, 1, MapLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mapTypeCSEClass, MapTypeCS.class, "MapTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMapTypeCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, MapTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMapTypeCS_OwnedKeyType(), theBaseCSPackage.getTypedRefCS(), null, "ownedKeyType", null, 0, 1, MapTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMapTypeCS_OwnedValueType(), theBaseCSPackage.getTypedRefCS(), null, "ownedValueType", null, 0, 1, MapTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(nameExpCSEClass, NameExpCS.class, "NameExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(navigatingArgCSEClass, NavigatingArgCS.class, "NavigatingArgCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getNavigatingArgCS_OwnedInitExpression(), this.getExpCS(), null, "ownedInitExpression", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNavigatingArgCS_OwnedNameExpression(), this.getExpCS(), null, "ownedNameExpression", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNavigatingArgCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNavigatingArgCS_OwningRoundBracketedClause(), this.getRoundBracketedClauseCS(), this.getRoundBracketedClauseCS_OwnedArguments(), "owningRoundBracketedClause", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNavigatingArgCS_Prefix(), ecorePackage.getEString(), "prefix", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNavigatingArgCS_Role(), this.getNavigationRole(), "role", null, 0, 1, NavigatingArgCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNavigatingArgCS_OwnedCoIterator(), this.getVariableCS(), null, "ownedCoIterator", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(nestedExpCSEClass, NestedExpCS.class, "NestedExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getNestedExpCS_OwnedExpression(), this.getExpCS(), null, "ownedExpression", null, 0, 1, NestedExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(nullLiteralExpCSEClass, NullLiteralExpCS.class, "NullLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(numberLiteralExpCSEClass, NumberLiteralExpCS.class, "NumberLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getNumberLiteralExpCS_Symbol(), theBaseCSPackage.getBigNumber(), "symbol", null, 0, 1, NumberLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(operationCallExpCSEClass, OperationCallExpCS.class, "OperationCallExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOperationCallExpCS_ReferredOperation(), thePivotPackage.getOperation(), null, "referredOperation", null, 0, 1, OperationCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(operatorExpCSEClass, OperatorExpCS.class, "OperatorExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOperatorExpCS_OwnedRight(), this.getExpCS(), null, "ownedRight", null, 1, 1, OperatorExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperatorExpCS_Source(), this.getExpCS(), null, "source", null, 0, 1, OperatorExpCS.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(patternExpCSEClass, PatternExpCS.class, "PatternExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPatternExpCS_OwnedPatternType(), theBaseCSPackage.getTypeRefCS(), null, "ownedPatternType", null, 0, 1, PatternExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPatternExpCS_PatternVariableName(), ecorePackage.getEString(), "patternVariableName", null, 0, 1, PatternExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(prefixExpCSEClass, PrefixExpCS.class, "PrefixExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(primitiveLiteralExpCSEClass, PrimitiveLiteralExpCS.class, "PrimitiveLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(propertyCallExpCSEClass, PropertyCallExpCS.class, "PropertyCallExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPropertyCallExpCS_ReferredProperty(), thePivotPackage.getProperty(), null, "referredProperty", null, 0, 1, PropertyCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(roundBracketedClauseCSEClass, RoundBracketedClauseCS.class, "RoundBracketedClauseCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getRoundBracketedClauseCS_OwnedArguments(), this.getNavigatingArgCS(), this.getNavigatingArgCS_OwningRoundBracketedClause(), "ownedArguments", null, 0, -1, RoundBracketedClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getRoundBracketedClauseCS_OwningNameExp(), this.getAbstractNameExpCS(), this.getAbstractNameExpCS_OwnedRoundBracketedClause(), "owningNameExp", null, 0, 1, RoundBracketedClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(selfExpCSEClass, SelfExpCS.class, "SelfExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSelfExpCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, SelfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(shadowExpCSEClass, ShadowExpCS.class, "ShadowExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getShadowExpCS_Parts(), this.getShadowPartCS(), null, "parts", null, 0, -1, ShadowExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getShadowExpCS_TypeName(), this.getTypeNameExpCS(), null, "typeName", null, 0, 1, ShadowExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getShadowExpCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, ShadowExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(shadowPartCSEClass, ShadowPartCS.class, "ShadowPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getShadowPartCS_OwnedInitExpression(), this.getExpCS(), null, "ownedInitExpression", null, 1, 1, ShadowPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getShadowPartCS_OwningCurlyBracketClause(), this.getCurlyBracketedClauseCS(), this.getCurlyBracketedClauseCS_OwnedParts(), "owningCurlyBracketClause", null, 0, 1, ShadowPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getShadowPartCS_ReferredProperty(), thePivotPackage.getProperty(), null, "referredProperty", null, 0, 1, ShadowPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(squareBracketedClauseCSEClass, SquareBracketedClauseCS.class, "SquareBracketedClauseCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSquareBracketedClauseCS_OwnedTerms(), this.getExpCS(), null, "ownedTerms", null, 1, -1, SquareBracketedClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSquareBracketedClauseCS_OwningNameExp(), this.getAbstractNameExpCS(), this.getAbstractNameExpCS_OwnedSquareBracketedClauses(), "owningNameExp", null, 0, 1, SquareBracketedClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stringLiteralExpCSEClass, StringLiteralExpCS.class, "StringLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStringLiteralExpCS_Segments(), ecorePackage.getEString(), "segments", null, 0, -1, StringLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tupleLiteralExpCSEClass, TupleLiteralExpCS.class, "TupleLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTupleLiteralExpCS_OwnedParts(), this.getTupleLiteralPartCS(), null, "ownedParts", null, 0, -1, TupleLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tupleLiteralPartCSEClass, TupleLiteralPartCS.class, "TupleLiteralPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(typeLiteralExpCSEClass, TypeLiteralExpCS.class, "TypeLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypeLiteralExpCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, TypeLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeLiteralExpCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 1, 1, TypeLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typeNameExpCSEClass, TypeNameExpCS.class, "TypeNameExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypeNameExpCS_Element(), thePivotPackage.getType(), null, "element", null, 0, 1, TypeNameExpCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeNameExpCS_OwnedCurlyBracketedClause(), this.getCurlyBracketedClauseCS(), null, "ownedCurlyBracketedClause", null, 0, 1, TypeNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeNameExpCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, TypeNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeNameExpCS_OwnedPatternGuard(), this.getExpCS(), null, "ownedPatternGuard", null, 0, 1, TypeNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(unlimitedNaturalLiteralExpCSEClass, UnlimitedNaturalLiteralExpCS.class, "UnlimitedNaturalLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(variableCSEClass, VariableCS.class, "VariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getVariableCS_OwnedInitExpression(), this.getExpCS(), null, "ownedInitExpression", null, 0, 1, VariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVariableCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, VariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(variableExpCSEClass, VariableExpCS.class, "VariableExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getVariableExpCS_ReferredVariable(), thePivotPackage.getVariable(), null, "referredVariable", null, 0, 1, VariableExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(navigationRoleEEnum, NavigationRole.class, "NavigationRole"); //$NON-NLS-1$
		addEEnumLiteral(navigationRoleEEnum, NavigationRole.ITERATOR);
		addEEnumLiteral(navigationRoleEEnum, NavigationRole.ACCUMULATOR);
		addEEnumLiteral(navigationRoleEEnum, NavigationRole.EXPRESSION);

		// Create resource
		createResource(eNS_URI);
	}

} //EssentialOCLCSPackageImpl
