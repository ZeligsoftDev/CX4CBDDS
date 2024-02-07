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

package org.eclipse.ocl.xtext.completeoclcs;

import org.eclipse.ocl.xtext.basecs.TypedRefCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The abstract FeatureContextDeclCS identifies the common functionality of Operation and Property
 * contexts for complementary declarations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.FeatureContextDeclCS#getOwnedType <em>Owned Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getFeatureContextDeclCS()
 * @model abstract="true"
 * @generated
 */
public interface FeatureContextDeclCS
		extends ContextDeclCS {

	/**
	 * Returns the value of the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Property type or OPeration return type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Type</em>' containment reference.
	 * @see #setOwnedType(TypedRefCS)
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getFeatureContextDeclCS_OwnedType()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.completeoclcs.FeatureContextDeclCS#getOwnedType <em>Owned Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Type</em>' containment reference.
	 * @see #getOwnedType()
	 * @generated
	 */
	void setOwnedType(TypedRefCS value);

} // FeatureContextDeclCS
