/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.VariableCS#getOwnedInitExpression <em>Owned Init Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.VariableCS#getOwnedType <em>Owned Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getVariableCS()
 * @model
 * @generated
 */
public interface VariableCS
		extends NamedElementCS {

	/**
	 * Returns the value of the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Type</em>' containment reference.
	 * @see #setOwnedType(TypedRefCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getVariableCS_OwnedType()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.VariableCS#getOwnedType <em>Owned Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Type</em>' containment reference.
	 * @see #getOwnedType()
	 * @generated
	 */
	void setOwnedType(TypedRefCS value);

	/**
	 * Returns the value of the '<em><b>Owned Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Init Expression</em>' containment reference.
	 * @see #setOwnedInitExpression(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getVariableCS_OwnedInitExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedInitExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.VariableCS#getOwnedInitExpression <em>Owned Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Init Expression</em>' containment reference.
	 * @see #getOwnedInitExpression()
	 * @generated
	 */
	void setOwnedInitExpression(ExpCS value);

} // VariableCS
