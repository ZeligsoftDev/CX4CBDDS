/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.basecs.ContextLessElementCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ElementRefCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.PivotableElementCS;
import org.eclipse.ocl.xtext.basecs.RootCS;
import org.eclipse.ocl.xtext.basecs.SpecificationCS;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage
 * @generated
 */
public class EssentialOCLCSAdapterFactory
		extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EssentialOCLCSPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EssentialOCLCSAdapterFactory() {
		if (modelPackage == null)
		{
			modelPackage = EssentialOCLCSPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EssentialOCLCSSwitch<@Nullable Adapter> modelSwitch = new EssentialOCLCSSwitch<@Nullable Adapter>()
		{
			@Override
			public Adapter caseAbstractNameExpCS(AbstractNameExpCS object)
			{
				return createAbstractNameExpCSAdapter();
			}
			@Override
			public Adapter caseAssociationClassCallExpCS(AssociationClassCallExpCS object)
			{
				return createAssociationClassCallExpCSAdapter();
			}
			@Override
			public Adapter caseBooleanLiteralExpCS(BooleanLiteralExpCS object)
			{
				return createBooleanLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseCallExpCS(CallExpCS object)
			{
				return createCallExpCSAdapter();
			}
			@Override
			public Adapter caseCollectionLiteralExpCS(CollectionLiteralExpCS object)
			{
				return createCollectionLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseCollectionLiteralPartCS(CollectionLiteralPartCS object)
			{
				return createCollectionLiteralPartCSAdapter();
			}
			@Override
			public Adapter caseCollectionPatternCS(CollectionPatternCS object)
			{
				return createCollectionPatternCSAdapter();
			}
			@Override
			public Adapter caseCollectionTypeCS(CollectionTypeCS object)
			{
				return createCollectionTypeCSAdapter();
			}
			@Override
			public Adapter caseContextCS(ContextCS object)
			{
				return createContextCSAdapter();
			}
			@Override
			public Adapter caseCurlyBracketedClauseCS(CurlyBracketedClauseCS object)
			{
				return createCurlyBracketedClauseCSAdapter();
			}
			@Override
			public Adapter caseExpCS(ExpCS object)
			{
				return createExpCSAdapter();
			}
			@Override
			public Adapter caseExpSpecificationCS(ExpSpecificationCS object)
			{
				return createExpSpecificationCSAdapter();
			}
			@Override
			public Adapter caseIfExpCS(IfExpCS object)
			{
				return createIfExpCSAdapter();
			}
			@Override
			public Adapter caseIfThenExpCS(IfThenExpCS object)
			{
				return createIfThenExpCSAdapter();
			}
			@Override
			public Adapter caseInfixExpCS(InfixExpCS object)
			{
				return createInfixExpCSAdapter();
			}
			@Override
			public Adapter caseInvalidLiteralExpCS(InvalidLiteralExpCS object)
			{
				return createInvalidLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseIterateCallExpCS(IterateCallExpCS object)
			{
				return createIterateCallExpCSAdapter();
			}
			@Override
			public Adapter caseIterationCallExpCS(IterationCallExpCS object)
			{
				return createIterationCallExpCSAdapter();
			}
			@Override
			public Adapter caseLambdaLiteralExpCS(LambdaLiteralExpCS object)
			{
				return createLambdaLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseLetExpCS(LetExpCS object)
			{
				return createLetExpCSAdapter();
			}
			@Override
			public Adapter caseLetVariableCS(LetVariableCS object)
			{
				return createLetVariableCSAdapter();
			}
			@Override
			public Adapter caseLiteralExpCS(LiteralExpCS object)
			{
				return createLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseMapLiteralExpCS(MapLiteralExpCS object)
			{
				return createMapLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseMapLiteralPartCS(MapLiteralPartCS object)
			{
				return createMapLiteralPartCSAdapter();
			}
			@Override
			public Adapter caseMapTypeCS(MapTypeCS object)
			{
				return createMapTypeCSAdapter();
			}
			@Override
			public Adapter caseNameExpCS(NameExpCS object)
			{
				return createNameExpCSAdapter();
			}
			@Override
			public Adapter caseNavigatingArgCS(NavigatingArgCS object)
			{
				return createNavigatingArgCSAdapter();
			}
			@Override
			public Adapter caseNestedExpCS(NestedExpCS object)
			{
				return createNestedExpCSAdapter();
			}
			@Override
			public Adapter caseNullLiteralExpCS(NullLiteralExpCS object)
			{
				return createNullLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseNumberLiteralExpCS(NumberLiteralExpCS object)
			{
				return createNumberLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseOperationCallExpCS(OperationCallExpCS object)
			{
				return createOperationCallExpCSAdapter();
			}
			@Override
			public Adapter caseOperatorExpCS(OperatorExpCS object)
			{
				return createOperatorExpCSAdapter();
			}
			@Override
			public Adapter casePatternExpCS(PatternExpCS object)
			{
				return createPatternExpCSAdapter();
			}
			@Override
			public Adapter casePrefixExpCS(PrefixExpCS object)
			{
				return createPrefixExpCSAdapter();
			}
			@Override
			public Adapter casePrimitiveLiteralExpCS(PrimitiveLiteralExpCS object)
			{
				return createPrimitiveLiteralExpCSAdapter();
			}
			@Override
			public Adapter casePropertyCallExpCS(PropertyCallExpCS object)
			{
				return createPropertyCallExpCSAdapter();
			}
			@Override
			public Adapter caseRoundBracketedClauseCS(RoundBracketedClauseCS object)
			{
				return createRoundBracketedClauseCSAdapter();
			}
			@Override
			public Adapter caseSelfExpCS(SelfExpCS object)
			{
				return createSelfExpCSAdapter();
			}
			@Override
			public Adapter caseShadowExpCS(ShadowExpCS object)
			{
				return createShadowExpCSAdapter();
			}
			@Override
			public Adapter caseShadowPartCS(ShadowPartCS object)
			{
				return createShadowPartCSAdapter();
			}
			@Override
			public Adapter caseSquareBracketedClauseCS(SquareBracketedClauseCS object)
			{
				return createSquareBracketedClauseCSAdapter();
			}
			@Override
			public Adapter caseStringLiteralExpCS(StringLiteralExpCS object)
			{
				return createStringLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseTupleLiteralExpCS(TupleLiteralExpCS object)
			{
				return createTupleLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseTupleLiteralPartCS(TupleLiteralPartCS object)
			{
				return createTupleLiteralPartCSAdapter();
			}
			@Override
			public Adapter caseTypeLiteralExpCS(TypeLiteralExpCS object)
			{
				return createTypeLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseTypeNameExpCS(TypeNameExpCS object)
			{
				return createTypeNameExpCSAdapter();
			}
			@Override
			public Adapter caseUnlimitedNaturalLiteralExpCS(UnlimitedNaturalLiteralExpCS object)
			{
				return createUnlimitedNaturalLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseVariableCS(VariableCS object)
			{
				return createVariableCSAdapter();
			}
			@Override
			public Adapter caseVariableExpCS(VariableExpCS object)
			{
				return createVariableExpCSAdapter();
			}
			@Override
			public Adapter caseElementCS(ElementCS object)
			{
				return createElementCSAdapter();
			}
			@Override
			public Adapter casePivotableElementCS(PivotableElementCS object)
			{
				return createPivotableElementCSAdapter();
			}
			@Override
			public Adapter caseModelElementCS(ModelElementCS object)
			{
				return createModelElementCSAdapter();
			}
			@Override
			public Adapter caseElementRefCS(ElementRefCS object)
			{
				return createElementRefCSAdapter();
			}
			@Override
			public Adapter caseTypeRefCS(TypeRefCS object)
			{
				return createTypeRefCSAdapter();
			}
			@Override
			public Adapter caseTypedRefCS(TypedRefCS object)
			{
				return createTypedRefCSAdapter();
			}
			@Override
			public Adapter caseNamedElementCS(NamedElementCS object)
			{
				return createNamedElementCSAdapter();
			}
			@Override
			public Adapter caseRootCS(RootCS object)
			{
				return createRootCSAdapter();
			}
			@Override
			public Adapter caseContextLessElementCS(ContextLessElementCS object)
			{
				return createContextLessElementCSAdapter();
			}
			@Override
			public Adapter caseSpecificationCS(SpecificationCS object)
			{
				return createSpecificationCSAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS <em>Abstract Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS
	 * @generated
	 */
	public Adapter createAbstractNameExpCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS <em>Association Class Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS
	 * @generated
	 */
	public Adapter createAssociationClassCallExpCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS <em>Boolean Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS
	 * @generated
	 */
	public Adapter createBooleanLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.CallExpCS <em>Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CallExpCS
	 * @generated
	 */
	public Adapter createCallExpCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS <em>Collection Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS
	 * @generated
	 */
	public Adapter createCollectionLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS <em>Collection Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS
	 * @generated
	 */
	public Adapter createCollectionLiteralPartCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS <em>Collection Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS
	 * @generated
	 */
	public Adapter createCollectionPatternCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS <em>Collection Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS
	 * @generated
	 */
	public Adapter createCollectionTypeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.ContextCS <em>Context CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ContextCS
	 * @generated
	 */
	public Adapter createContextCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS <em>Curly Bracketed Clause CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS
	 * @generated
	 */
	public Adapter createCurlyBracketedClauseCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS <em>Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ExpCS
	 * @generated
	 */
	public Adapter createExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS <em>Exp Specification CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS
	 * @generated
	 */
	public Adapter createExpSpecificationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS <em>If Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IfExpCS
	 * @generated
	 */
	public Adapter createIfExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS <em>If Then Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS
	 * @generated
	 */
	public Adapter createIfThenExpCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS <em>Infix Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS
	 * @generated
	 */
	public Adapter createInfixExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS <em>Invalid Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS
	 * @generated
	 */
	public Adapter createInvalidLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS <em>Iterate Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS
	 * @generated
	 */
	public Adapter createIterateCallExpCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS <em>Iteration Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS
	 * @generated
	 */
	public Adapter createIterationCallExpCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS <em>Lambda Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS
	 * @generated
	 */
	public Adapter createLambdaLiteralExpCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.LetExpCS <em>Let Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LetExpCS
	 * @generated
	 */
	public Adapter createLetExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS <em>Let Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS
	 * @generated
	 */
	public Adapter createLetVariableCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.LiteralExpCS <em>Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LiteralExpCS
	 * @generated
	 */
	public Adapter createLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS <em>Map Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS
	 * @generated
	 */
	public Adapter createMapLiteralExpCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS <em>Map Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS
	 * @generated
	 */
	public Adapter createMapLiteralPartCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS <em>Map Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS
	 * @generated
	 */
	public Adapter createMapTypeCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.NameExpCS <em>Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NameExpCS
	 * @generated
	 */
	public Adapter createNameExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS <em>Navigating Arg CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS
	 * @generated
	 */
	public Adapter createNavigatingArgCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS <em>Nested Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS
	 * @generated
	 */
	public Adapter createNestedExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS <em>Null Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS
	 * @generated
	 */
	public Adapter createNullLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS <em>Number Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS
	 * @generated
	 */
	public Adapter createNumberLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.OperationCallExpCS <em>Operation Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.OperationCallExpCS
	 * @generated
	 */
	public Adapter createOperationCallExpCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS <em>Operator Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS
	 * @generated
	 */
	public Adapter createOperatorExpCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS <em>Pattern Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS
	 * @generated
	 */
	public Adapter createPatternExpCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS <em>Prefix Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS
	 * @generated
	 */
	public Adapter createPrefixExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.PrimitiveLiteralExpCS <em>Primitive Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.PrimitiveLiteralExpCS
	 * @generated
	 */
	public Adapter createPrimitiveLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS <em>Property Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS
	 * @generated
	 */
	public Adapter createPropertyCallExpCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS <em>Round Bracketed Clause CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS
	 * @generated
	 */
	public Adapter createRoundBracketedClauseCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS <em>Self Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS
	 * @generated
	 */
	public Adapter createSelfExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS <em>Shadow Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS
	 * @generated
	 */
	public Adapter createShadowExpCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS <em>Shadow Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS
	 * @generated
	 */
	public Adapter createShadowPartCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS <em>Square Bracketed Clause CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS
	 * @generated
	 */
	public Adapter createSquareBracketedClauseCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS <em>String Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS
	 * @generated
	 */
	public Adapter createStringLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS <em>Tuple Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS
	 * @generated
	 */
	public Adapter createTupleLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS <em>Tuple Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS
	 * @generated
	 */
	public Adapter createTupleLiteralPartCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS <em>Type Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS
	 * @generated
	 */
	public Adapter createTypeLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS <em>Type Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS
	 * @generated
	 */
	public Adapter createTypeNameExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS <em>Unlimited Natural Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS
	 * @generated
	 */
	public Adapter createUnlimitedNaturalLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.VariableCS <em>Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.VariableCS
	 * @generated
	 */
	public Adapter createVariableCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS <em>Variable Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS
	 * @generated
	 */
	public Adapter createVariableExpCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ElementCS <em>Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ElementCS
	 * @generated
	 */
	public Adapter createElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.PivotableElementCS <em>Pivotable Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.PivotableElementCS
	 * @generated
	 */
	public Adapter createPivotableElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ModelElementCS <em>Model Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ModelElementCS
	 * @generated
	 */
	public Adapter createModelElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.NamedElementCS <em>Named Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.NamedElementCS
	 * @generated
	 */
	public Adapter createNamedElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ElementRefCS <em>Element Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ElementRefCS
	 * @generated
	 */
	public Adapter createElementRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TypeRefCS <em>Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TypeRefCS
	 * @generated
	 */
	public Adapter createTypeRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TypedRefCS <em>Typed Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TypedRefCS
	 * @generated
	 */
	public Adapter createTypedRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.RootCS <em>Root CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.RootCS
	 * @generated
	 */
	public Adapter createRootCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ContextLessElementCS <em>Context Less Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ContextLessElementCS
	 * @generated
	 */
	public Adapter createContextLessElementCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.SpecificationCS <em>Specification CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.SpecificationCS
	 * @generated
	 */
	public Adapter createSpecificationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EssentialOCLCSAdapterFactory
