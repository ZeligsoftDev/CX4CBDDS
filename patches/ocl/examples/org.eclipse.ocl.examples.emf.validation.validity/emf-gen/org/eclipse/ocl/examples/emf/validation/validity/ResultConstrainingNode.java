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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result ConstrainingNode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode#getResultValidatableNode <em>Result Validatable Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResultConstrainingNode()
 * @model
 * @generated
 */
public interface ResultConstrainingNode extends ConstrainingNode {
	/**
	 * Returns the value of the '<em><b>Result Validatable Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode#getResultConstrainingNode <em>Result Constraining Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result ValidatableNode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Validatable Node</em>' reference.
	 * @see #setResultValidatableNode(ResultValidatableNode)
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getResultConstrainingNode_ResultValidatableNode()
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode#getResultConstrainingNode
	 * @model opposite="resultConstrainingNode" required="true" ordered="false"
	 * @generated
	 */
	ResultValidatableNode getResultValidatableNode();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode#getResultValidatableNode <em>Result Validatable Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Validatable Node</em>' reference.
	 * @see #getResultValidatableNode()
	 * @generated
	 */
	void setResultValidatableNode(ResultValidatableNode value);

} // ResultConstrainingNode
