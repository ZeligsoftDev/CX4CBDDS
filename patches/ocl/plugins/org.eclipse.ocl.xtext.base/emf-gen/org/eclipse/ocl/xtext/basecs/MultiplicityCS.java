/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.basecs;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.MultiplicityCS#isIsNullFree <em>Is Null Free</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getMultiplicityCS()
 * @model abstract="true"
 * @generated
 */
public interface MultiplicityCS extends ElementCS
{
	/**
	 * Returns the value of the '<em><b>Is Null Free</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Null Free</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Null Free</em>' attribute.
	 * @see #setIsNullFree(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getMultiplicityCS_IsNullFree()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsNullFree();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.MultiplicityCS#isIsNullFree <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Null Free</em>' attribute.
	 * @see #isIsNullFree()
	 * @generated
	 */
	void setIsNullFree(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getLower();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getUpper();

} // MultiplicityCS
