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
package org.eclipse.ocl.pivot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Literal Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.MapLiteralPart#getOwnedKey <em>Owned Key</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.MapLiteralPart#getOwnedValue <em>Owned Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getMapLiteralPart()
 * @generated
 */
public interface MapLiteralPart extends Element
{
	/**
	 * Returns the value of the '<em><b>Owned Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Key</em>' containment reference.
	 * @see #setOwnedKey(OCLExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getMapLiteralPart_OwnedKey()
	 * @generated
	 */
	OCLExpression getOwnedKey();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.MapLiteralPart#getOwnedKey <em>Owned Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Key</em>' containment reference.
	 * @see #getOwnedKey()
	 * @generated
	 */
	void setOwnedKey(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Owned Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Value</em>' containment reference.
	 * @see #setOwnedValue(OCLExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getMapLiteralPart_OwnedValue()
	 * @generated
	 */
	OCLExpression getOwnedValue();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.MapLiteralPart#getOwnedValue <em>Owned Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Value</em>' containment reference.
	 * @see #getOwnedValue()
	 * @generated
	 */
	void setOwnedValue(OCLExpression value);

} // MapLiteralPart
