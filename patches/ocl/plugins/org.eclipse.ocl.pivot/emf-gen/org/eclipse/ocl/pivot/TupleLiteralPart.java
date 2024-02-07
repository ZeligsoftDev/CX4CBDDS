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
import org.eclipse.ocl.pivot.ids.TuplePartId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Literal Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.TupleLiteralPart#getOwnedInit <em>Owned Init</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getTupleLiteralPart()
 * @generated
 */
public interface TupleLiteralPart
extends VariableDeclaration {

	/**
	 * Returns the value of the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Init</em>' containment reference.
	 * @see #setOwnedInit(OCLExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTupleLiteralPart_OwnedInit()
	 * @generated
	 */
	OCLExpression getOwnedInit();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TupleLiteralPart#getOwnedInit <em>Owned Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Init</em>' containment reference.
	 * @see #getOwnedInit()
	 * @generated
	 */
	void setOwnedInit(OCLExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleInitialiserType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	boolean validateTypeIsNotInvalid(DiagnosticChain diagnostics, Map<Object, Object> context);

	TuplePartId getPartId();
} // TupleLiteralPart
