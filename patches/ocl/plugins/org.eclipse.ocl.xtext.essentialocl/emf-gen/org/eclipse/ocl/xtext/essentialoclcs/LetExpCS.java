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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.LetExpCS#isIsImplicit <em>Is Implicit</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.LetExpCS#getOwnedInExpression <em>Owned In Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.LetExpCS#getOwnedVariables <em>Owned Variables</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getLetExpCS()
 * @model
 * @generated
 */
public interface LetExpCS
		extends ExpCS {

	/**
	 * Returns the value of the '<em><b>Owned Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS#getOwningLetExpression <em>Owning Let Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Variables</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getLetExpCS_OwnedVariables()
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS#getOwningLetExpression
	 * @model opposite="owningLetExpression" containment="true"
	 * @generated
	 */
	EList<LetVariableCS> getOwnedVariables();

	/**
	 * Returns the value of the '<em><b>Owned In Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned In Expression</em>' containment reference.
	 * @see #setOwnedInExpression(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getLetExpCS_OwnedInExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedInExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.LetExpCS#getOwnedInExpression <em>Owned In Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned In Expression</em>' containment reference.
	 * @see #getOwnedInExpression()
	 * @generated
	 */
	void setOwnedInExpression(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Is Implicit</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Implicit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Implicit</em>' attribute.
	 * @see #setIsImplicit(boolean)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getLetExpCS_IsImplicit()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsImplicit();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.LetExpCS#isIsImplicit <em>Is Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Implicit</em>' attribute.
	 * @see #isIsImplicit()
	 * @generated
	 */
	void setIsImplicit(boolean value);

} // LetExpCS
