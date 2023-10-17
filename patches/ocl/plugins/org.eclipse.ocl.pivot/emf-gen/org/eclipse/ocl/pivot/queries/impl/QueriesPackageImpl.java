/**
 * Copyright (c) 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.queries.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.ModelImpl;
import org.eclipse.ocl.pivot.queries.QueriesFactory;
import org.eclipse.ocl.pivot.queries.QueriesPackage;
import org.eclipse.ocl.pivot.queries.QueryModel;
import org.eclipse.ocl.pivot.queries.QueryResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * @since 1.18
 * <!-- end-user-doc -->
 * @generated
 */
public class QueriesPackageImpl extends EPackageImpl implements QueriesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryResultEClass = null;

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
	 * @see org.eclipse.ocl.pivot.queries.QueriesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QueriesPackageImpl() {
		super(eNS_URI, QueriesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QueriesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QueriesPackage init() {
		if (isInited) return (QueriesPackage)EPackage.Registry.INSTANCE.getEPackage(QueriesPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredQueriesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QueriesPackageImpl theQueriesPackage = registeredQueriesPackage instanceof QueriesPackageImpl ? (QueriesPackageImpl)registeredQueriesPackage : new QueriesPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		PivotPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQueriesPackage.createPackageContents();

		// Initialize created meta-data
		theQueriesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQueriesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QueriesPackage.eNS_URI, theQueriesPackage);
		return theQueriesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQueryModel() {
		return queryModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQueryModel_Results() {
		return (EReference)queryModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQueryResult() {
		return queryResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQueryResult_Self() {
		return (EReference)queryResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getQueryResult_Query() {
		return (EAttribute)queryResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQueryResult_Expression() {
		return (EReference)queryResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQueryResult_Value() {
		return (EReference)queryResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getQueryResult_Errors() {
		return (EAttribute)queryResultEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getQueryResult_Result() {
		return (EAttribute)queryResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QueriesFactory getQueriesFactory() {
		return (QueriesFactory)getEFactoryInstance();
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
		queryModelEClass = createEClass(0);
		createEReference(queryModelEClass, ModelImpl.MODEL_FEATURE_COUNT + 0);

		queryResultEClass = createEClass(1);
		createEReference(queryResultEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 0);
		createEAttribute(queryResultEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 1);
		createEAttribute(queryResultEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 2);
		createEReference(queryResultEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 3);
		createEReference(queryResultEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 4);
		createEAttribute(queryResultEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 5);
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
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		queryModelEClass.getESuperTypes().add(thePivotPackage.getModel());
		queryResultEClass.getESuperTypes().add(thePivotPackage.getElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(queryModelEClass, QueryModel.class, "QueryModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQueryModel_Results(), this.getQueryResult(), null, "results", null, 0, -1, QueryModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryResultEClass, QueryResult.class, "QueryResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQueryResult_Self(), ecorePackage.getEObject(), null, "self", null, 0, 1, QueryResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryResult_Query(), ecorePackage.getEString(), "query", null, 0, 1, QueryResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryResult_Result(), ecorePackage.getEString(), "result", null, 0, 1, QueryResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryResult_Expression(), thePivotPackage.getExpressionInOCL(), null, "expression", null, 1, 1, QueryResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryResult_Value(), thePivotPackage.getOCLExpression(), null, "value", null, 0, 1, QueryResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryResult_Errors(), ecorePackage.getEString(), "errors", null, 0, -1, QueryResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //QueriesPackageImpl
