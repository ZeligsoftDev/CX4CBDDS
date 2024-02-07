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
 * A representation of the model object '<em><b>String Multiplicity CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.MultiplicityStringCS#getStringBounds <em>String Bounds</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getMultiplicityStringCS()
 * @model
 * @generated
 */
public interface MultiplicityStringCS extends MultiplicityCS
{
	/**
	 * Returns the value of the '<em><b>String Bounds</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Bounds</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Bounds</em>' attribute.
	 * @see #setStringBounds(String)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getMultiplicityStringCS_StringBounds()
	 * @model default="1" dataType="org.eclipse.ocl.pivot.String"
	 * @generated
	 */
	String getStringBounds();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.MultiplicityStringCS#getStringBounds <em>String Bounds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Bounds</em>' attribute.
	 * @see #getStringBounds()
	 * @generated
	 */
	void setStringBounds(String value);

} // StringMultiplicityCS
