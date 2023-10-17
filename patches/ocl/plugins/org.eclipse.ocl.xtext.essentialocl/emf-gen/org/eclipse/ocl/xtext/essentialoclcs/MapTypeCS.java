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
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.ocl.xtext.basecs.TypedRefCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Type CS</b></em>'.
 * @extends org.eclipse.ocl.pivot.utilities.Nameable
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS#getOwnedKeyType <em>Owned Key Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS#getOwnedValueType <em>Owned Value Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getMapTypeCS()
 * @model
 * @generated
 */
public interface MapTypeCS extends TypedRefCS, org.eclipse.ocl.pivot.utilities.Nameable
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getMapTypeCS_Name()
	 * @model
	 * @generated
	 */
	@Override
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owned Key Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Key Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Key Type</em>' containment reference.
	 * @see #setOwnedKeyType(TypedRefCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getMapTypeCS_OwnedKeyType()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedKeyType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS#getOwnedKeyType <em>Owned Key Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Key Type</em>' containment reference.
	 * @see #getOwnedKeyType()
	 * @generated
	 */
	void setOwnedKeyType(TypedRefCS value);

	/**
	 * Returns the value of the '<em><b>Owned Value Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Value Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Value Type</em>' containment reference.
	 * @see #setOwnedValueType(TypedRefCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getMapTypeCS_OwnedValueType()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedValueType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS#getOwnedValueType <em>Owned Value Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Value Type</em>' containment reference.
	 * @see #getOwnedValueType()
	 * @generated
	 */
	void setOwnedValueType(TypedRefCS value);

} // MapTypeCS
