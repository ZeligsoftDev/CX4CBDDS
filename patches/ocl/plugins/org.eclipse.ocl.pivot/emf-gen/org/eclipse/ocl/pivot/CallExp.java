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
 * A representation of the model object '<em><b>Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.CallExp#isIsImplicit <em>Is Implicit</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.CallExp#isIsSafe <em>Is Safe</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.CallExp#getOwnedSource <em>Owned Source</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getCallExp()
 * @generated
 */
public interface CallExp extends OCLExpression {

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
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCallExp_IsImplicit()
	 * @generated
	 */
	boolean isIsImplicit();

	/**
	 * Returns the value of the '<em><b>Owned Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Source</em>' containment reference.
	 * @see #setOwnedSource(OCLExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCallExp_OwnedSource()
	 * @generated
	 */
	OCLExpression getOwnedSource();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.CallExp#getOwnedSource <em>Owned Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Source</em>' containment reference.
	 * @see #getOwnedSource()
	 * @generated
	 */
	void setOwnedSource(OCLExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateSafeSourceCanBeNull(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateSafeSourceCannotBeMap(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateTypeIsNotInvalid(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.CallExp#isIsImplicit <em>Is Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Implicit</em>' attribute.
	 * @see #isIsImplicit()
	 * @generated
	 */
	void setIsImplicit(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Safe</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Safe</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Safe</em>' attribute.
	 * @see #setIsSafe(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCallExp_IsSafe()
	 * @generated
	 */
	boolean isIsSafe();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.CallExp#isIsSafe <em>Is Safe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Safe</em>' attribute.
	 * @see #isIsSafe()
	 * @generated
	 */
	void setIsSafe(boolean value);

} // CallExp
