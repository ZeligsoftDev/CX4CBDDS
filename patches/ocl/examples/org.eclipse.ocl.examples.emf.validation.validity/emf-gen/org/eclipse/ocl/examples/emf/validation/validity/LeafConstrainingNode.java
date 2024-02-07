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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.emf.validation.validity.locator.ConstraintLocator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Leaf ConstrainingNode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode#getConstraintLocator <em>Constraint Locator</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode#getConstraintResource <em>Constraint Resource</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode#getConstraintString <em>Constraint String</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getLeafConstrainingNode()
 * @model
 * @generated
 */
public interface LeafConstrainingNode extends ConstrainingNode {
	/**
	 * Returns the value of the '<em><b>Constraint Locator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Locator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Locator</em>' attribute.
	 * @see #setConstraintLocator(ConstraintLocator)
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getLeafConstrainingNode_ConstraintLocator()
	 * @model dataType="org.eclipse.ocl.examples.emf.validation.validity.ConstraintLocator" required="true" transient="true"
	 * @generated
	 */
	ConstraintLocator getConstraintLocator();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode#getConstraintLocator <em>Constraint Locator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Locator</em>' attribute.
	 * @see #getConstraintLocator()
	 * @generated
	 */
	void setConstraintLocator(ConstraintLocator value);

	/**
	 * Returns the value of the '<em><b>Constraint Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Resource</em>' attribute.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getLeafConstrainingNode_ConstraintResource()
	 * @model dataType="org.eclipse.ocl.examples.emf.validation.validity.Resource" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Resource getConstraintResource();

	/**
	 * Returns the value of the '<em><b>Constraint String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint String</em>' attribute.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getLeafConstrainingNode_ConstraintString()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getConstraintString();
} // LeafConstrainingNode
