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
package org.eclipse.ocl.pivot;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.DynamicElement#getMetaType <em>Meta Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getDynamicElement()
 * @generated
 */
public interface DynamicElement extends Element
{
	/**
	 * Returns the value of the '<em><b>Meta Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Type</em>' reference.
	 * @see #setMetaType(Type)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getDynamicElement_MetaType()
	 * @generated
	 */
	Type getMetaType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.DynamicElement#getMetaType <em>Meta Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Type</em>' reference.
	 * @see #getMetaType()
	 * @generated
	 */
	void setMetaType(Type value);

} // DynamicElement
