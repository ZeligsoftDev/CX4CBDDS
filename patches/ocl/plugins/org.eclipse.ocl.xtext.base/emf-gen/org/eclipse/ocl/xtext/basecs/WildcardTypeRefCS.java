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
 * A representation of the model object '<em><b>Wildcard Type Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS#getOwnedExtends <em>Owned Extends</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS#getOwnedSuper <em>Owned Super</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getWildcardTypeRefCS()
 * @model
 * @generated
 */
public interface WildcardTypeRefCS extends TypeRefCS {
	/**
	 * Returns the value of the '<em><b>Owned Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Extends</em>' containment reference.
	 * @see #setOwnedExtends(TypedRefCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getWildcardTypeRefCS_OwnedExtends()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedExtends();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS#getOwnedExtends <em>Owned Extends</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Extends</em>' containment reference.
	 * @see #getOwnedExtends()
	 * @generated
	 */
	void setOwnedExtends(TypedRefCS value);

	/**
	 * Returns the value of the '<em><b>Owned Super</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Super</em>' containment reference.
	 * @see #setOwnedSuper(TypedRefCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getWildcardTypeRefCS_OwnedSuper()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedSuper();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS#getOwnedSuper <em>Owned Super</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Super</em>' containment reference.
	 * @see #getOwnedSuper()
	 * @generated
	 */
	void setOwnedSuper(TypedRefCS value);

} // WildcardTypeRefCS
