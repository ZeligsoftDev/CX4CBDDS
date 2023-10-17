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
package org.eclipse.ocl.pivot.queries;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * @since 1.18
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.queries.QueriesFactory
 * @model kind="package"
 * @generated
 */
public interface QueriesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "queries";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/2022/Queries";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "queries";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QueriesPackage eINSTANCE = org.eclipse.ocl.pivot.queries.impl.QueriesPackageImpl.init();



	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.queries.QueryModel <em>Query Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Model</em>'.
	 * @see org.eclipse.ocl.pivot.queries.QueryModel
	 * @generated
	 */
	EClass getQueryModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.queries.QueryModel#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see org.eclipse.ocl.pivot.queries.QueryModel#getResults()
	 * @see #getQueryModel()
	 * @generated
	 */
	EReference getQueryModel_Results();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.queries.QueryResult <em>Query Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Result</em>'.
	 * @see org.eclipse.ocl.pivot.queries.QueryResult
	 * @generated
	 */
	EClass getQueryResult();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.queries.QueryResult#getSelf <em>Self</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Self</em>'.
	 * @see org.eclipse.ocl.pivot.queries.QueryResult#getSelf()
	 * @see #getQueryResult()
	 * @generated
	 */
	EReference getQueryResult_Self();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.queries.QueryResult#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query</em>'.
	 * @see org.eclipse.ocl.pivot.queries.QueryResult#getQuery()
	 * @see #getQueryResult()
	 * @generated
	 */
	EAttribute getQueryResult_Query();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.queries.QueryResult#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.ocl.pivot.queries.QueryResult#getExpression()
	 * @see #getQueryResult()
	 * @generated
	 */
	EReference getQueryResult_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.queries.QueryResult#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.ocl.pivot.queries.QueryResult#getValue()
	 * @see #getQueryResult()
	 * @generated
	 */
	EReference getQueryResult_Value();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.pivot.queries.QueryResult#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Errors</em>'.
	 * @see org.eclipse.ocl.pivot.queries.QueryResult#getErrors()
	 * @see #getQueryResult()
	 * @generated
	 */
	EAttribute getQueryResult_Errors();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.queries.QueryResult#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see org.eclipse.ocl.pivot.queries.QueryResult#getResult()
	 * @see #getQueryResult()
	 * @generated
	 */
	EAttribute getQueryResult_Result();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QueriesFactory getQueriesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.queries.impl.QueryModelImpl <em>Query Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.queries.impl.QueryModelImpl
		 * @see org.eclipse.ocl.pivot.queries.impl.QueriesPackageImpl#getQueryModel()
		 * @generated
		 */
		EClass QUERY_MODEL = eINSTANCE.getQueryModel();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_MODEL__RESULTS = eINSTANCE.getQueryModel_Results();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.queries.impl.QueryResultImpl <em>Query Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.queries.impl.QueryResultImpl
		 * @see org.eclipse.ocl.pivot.queries.impl.QueriesPackageImpl#getQueryResult()
		 * @generated
		 */
		EClass QUERY_RESULT = eINSTANCE.getQueryResult();

		/**
		 * The meta object literal for the '<em><b>Self</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_RESULT__SELF = eINSTANCE.getQueryResult_Self();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_RESULT__QUERY = eINSTANCE.getQueryResult_Query();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_RESULT__EXPRESSION = eINSTANCE.getQueryResult_Expression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_RESULT__VALUE = eINSTANCE.getQueryResult_Value();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_RESULT__ERRORS = eINSTANCE.getQueryResult_Errors();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_RESULT__RESULT = eINSTANCE.getQueryResult_Result();

	}

} //QueriesPackage
