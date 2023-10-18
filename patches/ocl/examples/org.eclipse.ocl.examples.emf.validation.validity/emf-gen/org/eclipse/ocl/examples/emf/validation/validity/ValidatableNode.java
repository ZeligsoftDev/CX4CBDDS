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
import org.eclipse.jdt.annotation.Nullable;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ValidatableNode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getConstrainedObject <em>Constrained Object</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getValidatableNode()
 * @model
 * @generated
 */
public interface ValidatableNode extends AbstractNode {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(ValidatableNode)
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getValidatableNode_Parent()
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	@Nullable ValidatableNode getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(ValidatableNode value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getValidatableNode_Children()
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getParent
	 * @model opposite="parent" containment="true" ordered="false"
	 * @generated
	 */
	@NonNull EList<ValidatableNode> getChildren();

	/**
	 * Returns the value of the '<em><b>Constrained Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constrained Object</em>' reference.
	 * @see #setConstrainedObject(EObject)
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getValidatableNode_ConstrainedObject()
	 * @model required="true"
	 * @generated
	 */
	EObject getConstrainedObject();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getConstrainedObject <em>Constrained Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constrained Object</em>' reference.
	 * @see #getConstrainedObject()
	 * @generated
	 */
	void setConstrainedObject(EObject value);

} // ValidatableNode
