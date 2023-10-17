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

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.CollectionItem#getOwnedItem <em>Owned Item</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getCollectionItem()
 * @generated
 */
public interface CollectionItem
		extends CollectionLiteralPart {

	/**
	 * Returns the value of the '<em><b>Owned Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Item</em>' containment reference.
	 * @see #setOwnedItem(OCLExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCollectionItem_OwnedItem()
	 * @generated
	 */
	OCLExpression getOwnedItem();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.CollectionItem#getOwnedItem <em>Owned Item</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Item</em>' containment reference.
	 * @see #getOwnedItem()
	 * @generated
	 */
	void setOwnedItem(OCLExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateTypeIsItemType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CollectionItem
