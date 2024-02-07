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
package org.eclipse.ocl.pivot.annotations;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.annotations.PivotAnnotationsPackage
 * @generated
 */
public interface PivotAnnotationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PivotAnnotationsFactory eINSTANCE = org.eclipse.ocl.pivot.annotations.impl.PivotAnnotationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>AS Library EPackage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AS Library EPackage</em>'.
	 * @generated
	 */
	@NonNull ASLibrary_EPackage createASLibrary_EPackage();

	/**
	 * Returns a new object of class '<em>AS Metamodel EPackage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AS Metamodel EPackage</em>'.
	 * @generated
	 */
	@NonNull ASMetamodel_EPackage createASMetamodel_EPackage();

	/**
	 * Returns a new object of class '<em>Collection EClass</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection EClass</em>'.
	 * @generated
	 */
	@NonNull Collection_EClass createCollection_EClass();

	/**
	 * Returns a new object of class '<em>Collection EPackage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection EPackage</em>'.
	 * @generated
	 */
	@NonNull Collection_EPackage createCollection_EPackage();

	/**
	 * Returns a new object of class '<em>Collection ETyped Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection ETyped Element</em>'.
	 * @generated
	 */
	@NonNull Collection_ETypedElement createCollection_ETypedElement();

	/**
	 * Returns a new object of class '<em>Ecore OCL EClassifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecore OCL EClassifier</em>'.
	 * @generated
	 */
	@NonNull Ecore_OCL_EClassifier createEcore_OCL_EClassifier();

	/**
	 * Returns a new object of class '<em>Ecore OCL EOperation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecore OCL EOperation</em>'.
	 * @generated
	 */
	@NonNull Ecore_OCL_EOperation createEcore_OCL_EOperation();

	/**
	 * Returns a new object of class '<em>Ecore OCL EStructural Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecore OCL EStructural Feature</em>'.
	 * @generated
	 */
	@NonNull Ecore_OCL_EStructuralFeature createEcore_OCL_EStructuralFeature();

	/**
	 * Returns a new object of class '<em>Import EPackage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import EPackage</em>'.
	 * @generated
	 */
	@NonNull Import_EPackage createImport_EPackage();

	/**
	 * Returns a new object of class '<em>Meta Annotation EAnnotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Annotation EAnnotation</em>'.
	 * @generated
	 */
	@NonNull MetaAnnotation_EAnnotation createMetaAnnotation_EAnnotation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PivotAnnotationsPackage getPivotAnnotationsPackage();

} //AnnotationsFactory
