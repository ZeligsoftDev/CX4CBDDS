/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.ocl.xtext.basecs.NamedElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS#getOwnedRight <em>Owned Right</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getOperatorExpCS()
 * @model abstract="true"
 * @generated
 */
public interface OperatorExpCS
		extends ExpCS, NamedElementCS {

	/**
	 * Returns the value of the '<em><b>Owned Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Right</em>' containment reference.
	 * @see #setOwnedRight(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getOperatorExpCS_OwnedRight()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpCS getOwnedRight();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS#getOwnedRight <em>Owned Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Right</em>' containment reference.
	 * @see #getOwnedRight()
	 * @generated
	 */
	void setOwnedRight(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getOperatorExpCS_Source()
	 * @model resolveProxies="false" transient="true" changeable="false" derived="true"
	 * @generated
	 */
	ExpCS getSource();
} // OperatorCS
