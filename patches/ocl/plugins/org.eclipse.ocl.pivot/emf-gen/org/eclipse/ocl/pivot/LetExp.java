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
 * A representation of the model object '<em><b>Let Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.LetExp#getOwnedIn <em>Owned In</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.LetExp#getOwnedVariable <em>Owned Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getLetExp()
 * @generated
 */
public interface LetExp
extends OCLExpression {

	/**
	 * Returns the value of the '<em><b>Owned In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned In</em>' containment reference.
	 * @see #setOwnedIn(OCLExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getLetExp_OwnedIn()
	 * @generated
	 */
	OCLExpression getOwnedIn();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.LetExp#getOwnedIn <em>Owned In</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned In</em>' containment reference.
	 * @see #getOwnedIn()
	 * @generated
	 */
	void setOwnedIn(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Owned Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Variable</em>' containment reference.
	 * @see #setOwnedVariable(Variable)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getLetExp_OwnedVariable()
	 * @generated
	 */
	Variable getOwnedVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.LetExp#getOwnedVariable <em>Owned Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Variable</em>' containment reference.
	 * @see #getOwnedVariable()
	 * @generated
	 */
	void setOwnedVariable(Variable value);

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleNullityForIn(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateTypeIsInType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateTypeIsNotInvalid(DiagnosticChain diagnostics, Map<Object, Object> context);

} // LetExp
