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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.MessageType#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.MessageType#getReferredSignal <em>Referred Signal</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getMessageType()
 * @generated
 */
public interface MessageType
		extends org.eclipse.ocl.pivot.Class {

	/**
	 * Returns the value of the '<em><b>Referred Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Signal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Signal</em>' reference.
	 * @see #setReferredSignal(Signal)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getMessageType_ReferredSignal()
	 * @generated
	 */
	Signal getReferredSignal();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.MessageType#getReferredSignal <em>Referred Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Signal</em>' reference.
	 * @see #getReferredSignal()
	 * @generated
	 */
	void setReferredSignal(Signal value);

	/**
	 * Returns the value of the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Operation</em>' reference.
	 * @see #setReferredOperation(Operation)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getMessageType_ReferredOperation()
	 * @generated
	 */
	Operation getReferredOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.MessageType#getReferredOperation <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Operation</em>' reference.
	 * @see #getReferredOperation()
	 * @generated
	 */
	void setReferredOperation(Operation value);

} // MessageType
