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
package org.eclipse.ocl.xtext.essentialoclcs;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Expression CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS#getOwnedLeft <em>Owned Left</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getInfixExpCS()
 * @model
 * @generated
 */
public interface InfixExpCS
		extends OperatorExpCS {

	/**
	 * Returns the value of the '<em><b>Owned Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Left</em>' containment reference.
	 * @see #setOwnedLeft(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getInfixExpCS_OwnedLeft()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpCS getOwnedLeft();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS#getOwnedLeft <em>Owned Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Left</em>' containment reference.
	 * @see #getOwnedLeft()
	 * @generated
	 */
	void setOwnedLeft(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' reference.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getInfixExpCS_Argument()
	 * @model resolveProxies="false" transient="true" changeable="false" derived="true"
	 * @generated
	 */
	ExpCS getArgument();

} // BinaryExpressionCS
