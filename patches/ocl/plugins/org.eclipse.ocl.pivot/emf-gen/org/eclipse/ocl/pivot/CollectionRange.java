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
package org.eclipse.ocl.pivot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.CollectionRange#getOwnedFirst <em>Owned First</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.CollectionRange#getOwnedLast <em>Owned Last</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getCollectionRange()
 * @generated
 */
public interface CollectionRange
		extends CollectionLiteralPart {

	/**
	 * Returns the value of the '<em><b>Owned First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned First</em>' containment reference.
	 * @see #setOwnedFirst(OCLExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCollectionRange_OwnedFirst()
	 * @generated
	 */
	OCLExpression getOwnedFirst();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.CollectionRange#getOwnedFirst <em>Owned First</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned First</em>' containment reference.
	 * @see #getOwnedFirst()
	 * @generated
	 */
	void setOwnedFirst(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Owned Last</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Last</em>' containment reference.
	 * @see #setOwnedLast(OCLExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCollectionRange_OwnedLast()
	 * @generated
	 */
	OCLExpression getOwnedLast();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.CollectionRange#getOwnedLast <em>Owned Last</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Last</em>' containment reference.
	 * @see #getOwnedLast()
	 * @generated
	 */
	void setOwnedLast(OCLExpression value);

} // CollectionRange
