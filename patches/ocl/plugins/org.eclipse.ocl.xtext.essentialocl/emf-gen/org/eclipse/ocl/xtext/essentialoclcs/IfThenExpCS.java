/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
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
 * A representation of the model object '<em><b>If Then Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS#getOwnedCondition <em>Owned Condition</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS#getOwnedThenExpression <em>Owned Then Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIfThenExpCS()
 * @model
 * @generated
 */
public interface IfThenExpCS extends ExpCS
{
	/**
	 * Returns the value of the '<em><b>Owned Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Condition</em>' containment reference.
	 * @see #setOwnedCondition(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIfThenExpCS_OwnedCondition()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS#getOwnedCondition <em>Owned Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Condition</em>' containment reference.
	 * @see #getOwnedCondition()
	 * @generated
	 */
	void setOwnedCondition(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Owned Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Then Expression</em>' containment reference.
	 * @see #setOwnedThenExpression(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIfThenExpCS_OwnedThenExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedThenExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS#getOwnedThenExpression <em>Owned Then Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Then Expression</em>' containment reference.
	 * @see #getOwnedThenExpression()
	 * @generated
	 */
	void setOwnedThenExpression(ExpCS value);

} // IfThenExpCS
