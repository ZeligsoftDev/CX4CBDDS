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
package org.eclipse.ocl.xtext.completeoclcs.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.NamespaceCS;
import org.eclipse.ocl.xtext.basecs.PivotableElementCS;
import org.eclipse.ocl.xtext.basecs.RootCS;
import org.eclipse.ocl.xtext.basecs.TemplateableElementCS;
import org.eclipse.ocl.xtext.basecs.TypedElementCS;
import org.eclipse.ocl.xtext.completeoclcs.*;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage
 * @generated
 */
public class CompleteOCLCSAdapterFactory
		extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CompleteOCLCSPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteOCLCSAdapterFactory() {
		if (modelPackage == null)
		{
			modelPackage = CompleteOCLCSPackage.eINSTANCE;
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
	protected CompleteOCLCSSwitch<@Nullable Adapter> modelSwitch = new CompleteOCLCSSwitch<@Nullable Adapter>()
		{
			@Override
			public Adapter caseClassifierContextDeclCS(ClassifierContextDeclCS object)
			{
				return createClassifierContextDeclCSAdapter();
			}
			@Override
			public Adapter caseCompleteOCLDocumentCS(CompleteOCLDocumentCS object)
			{
				return createCompleteOCLDocumentCSAdapter();
			}
			@Override
			public Adapter caseContextDeclCS(ContextDeclCS object)
			{
				return createContextDeclCSAdapter();
			}
			@Override
			public Adapter caseDefCS(DefCS object)
			{
				return createDefCSAdapter();
			}
			@Override
			public Adapter caseDefOperationCS(DefOperationCS object)
			{
				return createDefOperationCSAdapter();
			}
			@Override
			public Adapter caseDefPropertyCS(DefPropertyCS object)
			{
				return createDefPropertyCSAdapter();
			}
			@Override
			public Adapter caseFeatureContextDeclCS(FeatureContextDeclCS object)
			{
				return createFeatureContextDeclCSAdapter();
			}
			@Override
			public Adapter caseOCLMessageArgCS(OCLMessageArgCS object)
			{
				return createOCLMessageArgCSAdapter();
			}
			@Override
			public Adapter caseOperationContextDeclCS(OperationContextDeclCS object)
			{
				return createOperationContextDeclCSAdapter();
			}
			@Override
			public Adapter casePackageDeclarationCS(PackageDeclarationCS object)
			{
				return createPackageDeclarationCSAdapter();
			}
			@Override
			public Adapter casePathNameDeclCS(PathNameDeclCS object)
			{
				return createPathNameDeclCSAdapter();
			}
			@Override
			public Adapter casePropertyContextDeclCS(PropertyContextDeclCS object)
			{
				return createPropertyContextDeclCSAdapter();
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
			public Adapter caseTemplateableElementCS(TemplateableElementCS object)
			{
				return createTemplateableElementCSAdapter();
			}
			@Override
			public Adapter caseNamedElementCS(NamedElementCS object)
			{
				return createNamedElementCSAdapter();
			}
			@Override
			public Adapter caseNamespaceCS(NamespaceCS object)
			{
				return createNamespaceCSAdapter();
			}
			@Override
			public Adapter caseRootCS(RootCS object)
			{
				return createRootCSAdapter();
			}
			@Override
			public Adapter caseTypedElementCS(TypedElementCS object)
			{
				return createTypedElementCSAdapter();
			}
			@Override
			public Adapter caseExpCS(ExpCS object)
			{
				return createExpCSAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS <em>Classifier Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS
	 * @generated
	 */
	public Adapter createClassifierContextDeclCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS <em>Complete OCL Document CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS
	 * @generated
	 */
	public Adapter createCompleteOCLDocumentCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TemplateableElementCS <em>Templateable Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateableElementCS
	 * @generated
	 */
	public Adapter createTemplateableElementCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS <em>Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS
	 * @generated
	 */
	public Adapter createContextDeclCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.completeoclcs.DefCS <em>Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.completeoclcs.DefCS
	 * @generated
	 */
	public Adapter createDefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.completeoclcs.DefOperationCS <em>Def Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.completeoclcs.DefOperationCS
	 * @generated
	 */
	public Adapter createDefOperationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS <em>Def Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS
	 * @generated
	 */
	public Adapter createDefPropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.completeoclcs.FeatureContextDeclCS <em>Feature Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.completeoclcs.FeatureContextDeclCS
	 * @generated
	 */
	public Adapter createFeatureContextDeclCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.completeoclcs.OCLMessageArgCS <em>OCL Message Arg CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.completeoclcs.OCLMessageArgCS
	 * @generated
	 */
	public Adapter createOCLMessageArgCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS <em>Operation Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS
	 * @generated
	 */
	public Adapter createOperationContextDeclCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS <em>Package Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS
	 * @generated
	 */
	public Adapter createPackageDeclarationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS <em>Path Name Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS
	 * @generated
	 */
	public Adapter createPathNameDeclCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS <em>Property Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS
	 * @generated
	 */
	public Adapter createPropertyContextDeclCSAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.NamespaceCS <em>Namespace CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.NamespaceCS
	 * @generated
	 */
	public Adapter createNamespaceCSAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TypedElementCS <em>Typed Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TypedElementCS
	 * @generated
	 */
	public Adapter createTypedElementCSAdapter() {
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

} //CompleteOCLCSAdapterFactory
