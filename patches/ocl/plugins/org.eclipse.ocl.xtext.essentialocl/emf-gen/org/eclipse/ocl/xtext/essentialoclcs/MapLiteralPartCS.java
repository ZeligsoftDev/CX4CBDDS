/**
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.ocl.xtext.basecs.ModelElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Literal Part CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS#getOwnedKey <em>Owned Key</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS#getOwnedValue <em>Owned Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getMapLiteralPartCS()
 * @model
 * @generated
 */
public interface MapLiteralPartCS extends ModelElementCS
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
	 * @see #setOwnedKey(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getMapLiteralPartCS_OwnedKey()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedKey();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS#getOwnedKey <em>Owned Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Key</em>' containment reference.
	 * @see #getOwnedKey()
	 * @generated
	 */
	void setOwnedKey(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Owned Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Value</em>' containment reference.
	 * @see #setOwnedValue(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getMapLiteralPartCS_OwnedValue()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedValue();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS#getOwnedValue <em>Owned Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Value</em>' containment reference.
	 * @see #getOwnedValue()
	 * @generated
	 */
	void setOwnedValue(ExpCS value);

} // MapLiteralPartCS
