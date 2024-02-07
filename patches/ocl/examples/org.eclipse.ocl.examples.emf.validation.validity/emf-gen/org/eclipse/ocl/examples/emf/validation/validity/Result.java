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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getResultValidatableNode <em>Result Validatable Node</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getDiagnostic <em>Diagnostic</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getValidatableNode <em>Validatable Node</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getLeafConstrainingNode <em>Leaf Constraining Node</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getResultConstrainingNode <em>Result Constraining Node</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getException <em>Exception</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResult()
 * @model
 * @generated
 */
public interface Result extends EObject {
	/**
	 * Returns the value of the '<em><b>Result Set</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Set</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Set</em>' container reference.
	 * @see #setResultSet(ResultSet)
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResult_ResultSet()
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getResults
	 * @model opposite="results" required="true" transient="false"
	 * @generated
	 */
	ResultSet getResultSet();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getResultSet <em>Result Set</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Set</em>' container reference.
	 * @see #getResultSet()
	 * @generated
	 */
	void setResultSet(ResultSet value);

	/**
	 * Returns the value of the '<em><b>Result Validatable Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Validatable Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Validatable Node</em>' reference.
	 * @see #setResultValidatableNode(ResultValidatableNode)
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResult_ResultValidatableNode()
	 * @model required="true"
	 * @generated
	 */
	ResultValidatableNode getResultValidatableNode();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getResultValidatableNode <em>Result Validatable Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Validatable Node</em>' reference.
	 * @see #getResultValidatableNode()
	 * @generated
	 */
	void setResultValidatableNode(ResultValidatableNode value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The default value is <code>"UNKNOWN"</code>.
	 * The literals are from the enumeration {@link org.eclipse.ocl.examples.emf.validation.validity.Severity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.Severity
	 * @see #setSeverity(Severity)
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResult_Severity()
	 * @model default="UNKNOWN" required="true"
	 * @generated
	 */
	Severity getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.Severity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(Severity value);

	/**
	 * Returns the value of the '<em><b>Diagnostic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagnostic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagnostic</em>' attribute.
	 * @see #setDiagnostic(Object)
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResult_Diagnostic()
	 * @model dataType="org.eclipse.ocl.examples.emf.validation.validity.Object" transient="true"
	 * @generated
	 */
	Object getDiagnostic();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getDiagnostic <em>Diagnostic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagnostic</em>' attribute.
	 * @see #getDiagnostic()
	 * @generated
	 */
	void setDiagnostic(Object value);

	/**
	 * Returns the value of the '<em><b>Validatable Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ValidatableNode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validatable Node</em>' reference.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResult_ValidatableNode()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	ValidatableNode getValidatableNode();

	/**
	 * Returns the value of the '<em><b>Leaf Constraining Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leaf Constraining Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leaf Constraining Node</em>' reference.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResult_LeafConstrainingNode()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	LeafConstrainingNode getLeafConstrainingNode();

	/**
	 * Returns the value of the '<em><b>Result Constraining Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Constraining Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Constraining Node</em>' reference.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResult_ResultConstrainingNode()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	ResultConstrainingNode getResultConstrainingNode();

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' attribute.
	 * @see #setException(Throwable)
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResult_Exception()
	 * @model dataType="org.eclipse.ocl.examples.emf.validation.validity.Throwable"
	 * @generated
	 */
	Throwable getException();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getException <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' attribute.
	 * @see #getException()
	 * @generated
	 */
	void setException(Throwable value);

} // Result
