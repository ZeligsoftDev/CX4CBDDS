/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
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
 * A representation of the model object '<em><b>Wildcard Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.WildcardType#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.WildcardType#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getWildcardType()
 * @generated
 */
public interface WildcardType extends org.eclipse.ocl.pivot.Class
{
	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' reference.
	 * @see #setLowerBound(Type)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getWildcardType_LowerBound()
	 * @generated
	 */
	Type getLowerBound();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.WildcardType#getLowerBound <em>Lower Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' reference.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(Type value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' reference.
	 * @see #setUpperBound(Type)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getWildcardType_UpperBound()
	 * @generated
	 */
	Type getUpperBound();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.WildcardType#getUpperBound <em>Upper Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' reference.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(Type value);

} // WildcardType
