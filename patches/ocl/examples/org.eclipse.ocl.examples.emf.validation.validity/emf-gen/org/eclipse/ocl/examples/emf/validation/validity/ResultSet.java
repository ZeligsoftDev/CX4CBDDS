/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getRoot <em>Root</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getResults <em>Results</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getTimestamp <em>Timestamp</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResultSet()
 * @model
 * @generated
 */
public interface ResultSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.emf.validation.validity.RootNode#getResultSets <em>Result Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' container reference.
	 * @see #setRoot(RootNode)
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResultSet_Root()
	 * @see org.eclipse.ocl.examples.emf.validation.validity.RootNode#getResultSets
	 * @model opposite="resultSets" required="true" transient="false"
	 * @generated
	 */
	RootNode getRoot();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getRoot <em>Root</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' container reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(RootNode value);

	/**
	 * Returns the value of the '<em><b>Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.emf.validation.validity.Result}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResultSet_Results()
	 * @see org.eclipse.ocl.examples.emf.validation.validity.Result#getResultSet
	 * @model opposite="resultSet" containment="true" ordered="false"
	 * @generated
	 */
	@NonNull EList<Result> getResults();

	/**
	 * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timestamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp</em>' attribute.
	 * @see #setTimestamp(String)
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResultSet_Timestamp()
	 * @model
	 * @generated
	 */
	String getTimestamp();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(String value);

} // ResultSet
