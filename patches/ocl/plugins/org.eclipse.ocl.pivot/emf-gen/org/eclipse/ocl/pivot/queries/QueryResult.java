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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A QueryResult pairs a query with its self context and evaluation result
 * @since 1.18
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.queries.QueryResult#getSelf <em>Self</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.queries.QueryResult#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.queries.QueryResult#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.queries.QueryResult#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.queries.QueryResult#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.queries.QueryResult#getErrors <em>Errors</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.queries.QueriesPackage#getQueryResult()
 * @model
 * @generated
 */
public interface QueryResult extends Element {
	/**
	 * Returns the value of the '<em><b>Self</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self</em>' reference.
	 * @see #setSelf(EObject)
	 * @see org.eclipse.ocl.pivot.queries.QueriesPackage#getQueryResult_Self()
	 * @model
	 * @generated
	 */
	EObject getSelf();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.queries.QueryResult#getSelf <em>Self</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self</em>' reference.
	 * @see #getSelf()
	 * @generated
	 */
	void setSelf(EObject value);

	/**
	 * Returns the value of the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' attribute.
	 * @see #setQuery(String)
	 * @see org.eclipse.ocl.pivot.queries.QueriesPackage#getQueryResult_Query()
	 * @model
	 * @generated
	 */
	String getQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.queries.QueryResult#getQuery <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' attribute.
	 * @see #getQuery()
	 * @generated
	 */
	void setQuery(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(ExpressionInOCL)
	 * @see org.eclipse.ocl.pivot.queries.QueriesPackage#getQueryResult_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpressionInOCL getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.queries.QueryResult#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(ExpressionInOCL value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(OCLExpression)
	 * @see org.eclipse.ocl.pivot.queries.QueriesPackage#getQueryResult_Value()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.queries.QueryResult#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Errors</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Errors</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Errors</em>' attribute list.
	 * @see org.eclipse.ocl.pivot.queries.QueriesPackage#getQueryResult_Errors()
	 * @model
	 * @generated
	 */
	EList<String> getErrors();

	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute.
	 * @see #setResult(String)
	 * @see org.eclipse.ocl.pivot.queries.QueriesPackage#getQueryResult_Result()
	 * @model
	 * @generated
	 */
	String getResult();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.queries.QueryResult#getResult <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' attribute.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(String value);

} // QueryResult
