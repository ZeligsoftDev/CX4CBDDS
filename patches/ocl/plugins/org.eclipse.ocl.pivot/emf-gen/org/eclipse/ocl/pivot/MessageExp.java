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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.MessageExp#getOwnedArguments <em>Owned Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.MessageExp#getOwnedCalledOperation <em>Owned Called Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.MessageExp#getOwnedSentSignal <em>Owned Sent Signal</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.MessageExp#getOwnedTarget <em>Owned Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getMessageExp()
 * @generated
 */
public interface MessageExp
		extends OCLExpression {

	/**
	 * Returns the value of the '<em><b>Owned Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Target</em>' containment reference.
	 * @see #setOwnedTarget(OCLExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getMessageExp_OwnedTarget()
	 * @generated
	 */
	OCLExpression getOwnedTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.MessageExp#getOwnedTarget <em>Owned Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Target</em>' containment reference.
	 * @see #getOwnedTarget()
	 * @generated
	 */
	void setOwnedTarget(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Owned Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Arguments</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getMessageExp_OwnedArguments()
	 * @generated
	 */
	@NonNull List<OCLExpression> getOwnedArguments();

	/**
	 * Returns the value of the '<em><b>Owned Called Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Operation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Called Operation</em>' containment reference.
	 * @see #setOwnedCalledOperation(CallOperationAction)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getMessageExp_OwnedCalledOperation()
	 * @generated
	 */
	CallOperationAction getOwnedCalledOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.MessageExp#getOwnedCalledOperation <em>Owned Called Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Called Operation</em>' containment reference.
	 * @see #getOwnedCalledOperation()
	 * @generated
	 */
	void setOwnedCalledOperation(CallOperationAction value);

	/**
	 * Returns the value of the '<em><b>Owned Sent Signal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sent Signal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Sent Signal</em>' containment reference.
	 * @see #setOwnedSentSignal(SendSignalAction)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getMessageExp_OwnedSentSignal()
	 * @generated
	 */
	SendSignalAction getOwnedSentSignal();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.MessageExp#getOwnedSentSignal <em>Owned Sent Signal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Sent Signal</em>' containment reference.
	 * @see #getOwnedSentSignal()
	 * @generated
	 */
	void setOwnedSentSignal(SendSignalAction value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateOneCallOrOneSend(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateTargetIsNotACollection(DiagnosticChain diagnostics, Map<Object, Object> context);
} // MessageExp
