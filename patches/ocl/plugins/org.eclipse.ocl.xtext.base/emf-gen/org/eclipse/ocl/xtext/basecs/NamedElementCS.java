/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.basecs;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element CS</b></em>'.
 * @extends org.eclipse.ocl.pivot.utilities.Nameable
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.NamedElementCS#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getNamedElementCS()
 * @model abstract="true"
 * @generated
 */
public interface NamedElementCS extends ModelElementCS, org.eclipse.ocl.pivot.utilities.Nameable {

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
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getNamedElementCS_Name()
	 * @model dataType="org.eclipse.ocl.pivot.String"
	 * @generated
	 */
	@Override
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.NamedElementCS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // NamedElementCS
