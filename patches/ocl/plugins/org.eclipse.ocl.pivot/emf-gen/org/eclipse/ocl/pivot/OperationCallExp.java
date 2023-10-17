/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
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
 * A representation of the model object '<em><b>Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.OperationCallExp#isIsVirtual <em>Is Virtual</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.OperationCallExp#getOwnedArguments <em>Owned Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.OperationCallExp#getReferredOperation <em>Referred Operation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getOperationCallExp()
 * @generated
 */
public interface OperationCallExp
extends FeatureCallExp, ReferringElement {

	/**
	 * Returns the value of the '<em><b>Is Virtual</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Virtual</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Virtual</em>' attribute.
	 * @see #setIsVirtual(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperationCallExp_IsVirtual()
	 * @generated
	 */
	boolean isIsVirtual();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.OperationCallExp#isIsVirtual <em>Is Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Virtual</em>' attribute.
	 * @see #isIsVirtual()
	 * @generated
	 */
	void setIsVirtual(boolean value);

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
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperationCallExp_OwnedArguments()
	 * @generated
	 */
	@NonNull List<OCLExpression> getOwnedArguments();

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
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperationCallExp_ReferredOperation()
	 * @generated
	 */
	Operation getReferredOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.OperationCallExp#getReferredOperation <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Operation</em>' reference.
	 * @see #getReferredOperation()
	 * @generated
	 */
	void setReferredOperation(Operation value);

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.7
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean hasOclVoidOverload();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateArgumentTypeIsConformant(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	boolean validateSafeSourceCanBeNull(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.7
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateUnsafeSourceCanNotBeNull(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateArgumentCount(DiagnosticChain diagnostics, Map<Object, Object> context);

} // OperationCallExp
