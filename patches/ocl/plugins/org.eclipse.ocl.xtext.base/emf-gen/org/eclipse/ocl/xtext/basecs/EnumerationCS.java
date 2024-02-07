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
package org.eclipse.ocl.xtext.basecs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.EnumerationCS#isIsSerializable <em>Is Serializable</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.EnumerationCS#getOwnedLiterals <em>Owned Literals</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getEnumerationCS()
 * @model
 * @generated
 */
public interface EnumerationCS extends ClassCS, NamespaceCS
{
	/**
	 * Returns the value of the '<em><b>Is Serializable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Serializable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Serializable</em>' attribute.
	 * @see #setIsSerializable(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getEnumerationCS_IsSerializable()
	 * @model default="false" dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsSerializable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.EnumerationCS#isIsSerializable <em>Is Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Serializable</em>' attribute.
	 * @see #isIsSerializable()
	 * @generated
	 */
	void setIsSerializable(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Literals</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Literals</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getEnumerationCS_OwnedLiterals()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnumerationLiteralCS> getOwnedLiterals();

} // EnumCS
