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
 * A representation of the model object '<em><b>If Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#isIsImplicit <em>Is Implicit</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedCondition <em>Owned Condition</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedElseExpression <em>Owned Else Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedIfThenExpressions <em>Owned If Then Expressions</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedThenExpression <em>Owned Then Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIfExpCS()
 * @model
 * @generated
 */
public interface IfExpCS
		extends ExpCS {

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
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIfExpCS_OwnedCondition()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedCondition <em>Owned Condition</em>}' containment reference.
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
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIfExpCS_OwnedThenExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedThenExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedThenExpression <em>Owned Then Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Then Expression</em>' containment reference.
	 * @see #getOwnedThenExpression()
	 * @generated
	 */
	void setOwnedThenExpression(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Owned If Then Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If Then Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned If Then Expressions</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIfExpCS_OwnedIfThenExpressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<IfThenExpCS> getOwnedIfThenExpressions();

	/**
	 * Returns the value of the '<em><b>Owned Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Else Expression</em>' containment reference.
	 * @see #setOwnedElseExpression(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIfExpCS_OwnedElseExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedElseExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#getOwnedElseExpression <em>Owned Else Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Else Expression</em>' containment reference.
	 * @see #getOwnedElseExpression()
	 * @generated
	 */
	void setOwnedElseExpression(ExpCS value);

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
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIfExpCS_IsImplicit()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsImplicit();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.IfExpCS#isIsImplicit <em>Is Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Implicit</em>' attribute.
	 * @see #isIsImplicit()
	 * @generated
	 */
	void setIsImplicit(boolean value);

} // IfExpCS
