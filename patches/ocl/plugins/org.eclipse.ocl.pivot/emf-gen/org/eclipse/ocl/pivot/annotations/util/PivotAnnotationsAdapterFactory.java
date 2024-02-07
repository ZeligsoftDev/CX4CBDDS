/**
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.annotations.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.annotations.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.annotations.PivotAnnotationsPackage
 * @generated
 */
public class PivotAnnotationsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PivotAnnotationsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PivotAnnotationsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PivotAnnotationsPackage.eINSTANCE;
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
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
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
	protected PivotAnnotationsSwitch<@Nullable Adapter> modelSwitch =
			new PivotAnnotationsSwitch<@Nullable Adapter>() {
			@Override
			public Adapter caseASLibrary_EPackage(ASLibrary_EPackage object) {
				return createASLibrary_EPackageAdapter();
			}
			@Override
			public Adapter caseASMetamodel_EPackage(ASMetamodel_EPackage object) {
				return createASMetamodel_EPackageAdapter();
			}
			@Override
			public Adapter caseCollection_EClass(Collection_EClass object) {
				return createCollection_EClassAdapter();
			}
			@Override
			public Adapter caseCollection_EPackage(Collection_EPackage object) {
				return createCollection_EPackageAdapter();
			}
			@Override
			public Adapter caseCollection_ETypedElement(Collection_ETypedElement object) {
				return createCollection_ETypedElementAdapter();
			}
			@Override
			public Adapter caseEcore_OCL_EClassifier(Ecore_OCL_EClassifier object) {
				return createEcore_OCL_EClassifierAdapter();
			}
			@Override
			public Adapter caseEcore_OCL_EOperation(Ecore_OCL_EOperation object) {
				return createEcore_OCL_EOperationAdapter();
			}
			@Override
			public Adapter caseEcore_OCL_EStructuralFeature(Ecore_OCL_EStructuralFeature object) {
				return createEcore_OCL_EStructuralFeatureAdapter();
			}
			@Override
			public Adapter caseImport_EPackage(Import_EPackage object) {
				return createImport_EPackageAdapter();
			}
			@Override
			public Adapter caseMetaAnnotation_EAnnotation(MetaAnnotation_EAnnotation object) {
				return createMetaAnnotation_EAnnotationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.annotations.ASLibrary_EPackage <em>AS Library EPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.annotations.ASLibrary_EPackage
	 * @generated
	 */
	public Adapter createASLibrary_EPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.annotations.ASMetamodel_EPackage <em>AS Metamodel EPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.annotations.ASMetamodel_EPackage
	 * @generated
	 */
	public Adapter createASMetamodel_EPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.annotations.Collection_EClass <em>Collection EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.annotations.Collection_EClass
	 * @generated
	 */
	public Adapter createCollection_EClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.annotations.Collection_EPackage <em>Collection EPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.annotations.Collection_EPackage
	 * @generated
	 */
	public Adapter createCollection_EPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.annotations.Collection_ETypedElement <em>Collection ETyped Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.annotations.Collection_ETypedElement
	 * @generated
	 */
	public Adapter createCollection_ETypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.annotations.Ecore_OCL_EClassifier <em>Ecore OCL EClassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.annotations.Ecore_OCL_EClassifier
	 * @generated
	 */
	public Adapter createEcore_OCL_EClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.annotations.Ecore_OCL_EOperation <em>Ecore OCL EOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.annotations.Ecore_OCL_EOperation
	 * @generated
	 */
	public Adapter createEcore_OCL_EOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.annotations.Ecore_OCL_EStructuralFeature <em>Ecore OCL EStructural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.annotations.Ecore_OCL_EStructuralFeature
	 * @generated
	 */
	public Adapter createEcore_OCL_EStructuralFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.annotations.Import_EPackage <em>Import EPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.annotations.Import_EPackage
	 * @generated
	 */
	public Adapter createImport_EPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.annotations.MetaAnnotation_EAnnotation <em>Meta Annotation EAnnotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.annotations.MetaAnnotation_EAnnotation
	 * @generated
	 */
	public Adapter createMetaAnnotation_EAnnotationAdapter() {
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

} //AnnotationsAdapterFactory
