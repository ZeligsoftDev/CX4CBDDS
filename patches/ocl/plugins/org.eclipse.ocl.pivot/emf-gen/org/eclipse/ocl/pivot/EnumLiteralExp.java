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
 * A representation of the model object '<em><b>Enum Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.EnumLiteralExp#getReferredLiteral <em>Referred Literal</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getEnumLiteralExp()
 * @generated
 */
public interface EnumLiteralExp
		extends LiteralExp {

	/**
	 * Returns the value of the '<em><b>Referred Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Enum Literal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Literal</em>' reference.
	 * @see #setReferredLiteral(EnumerationLiteral)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getEnumLiteralExp_ReferredLiteral()
	 * @generated
	 */
	EnumerationLiteral getReferredLiteral();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.EnumLiteralExp#getReferredLiteral <em>Referred Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Literal</em>' reference.
	 * @see #getReferredLiteral()
	 * @generated
	 */
	void setReferredLiteral(EnumerationLiteral value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateTypeIsEnumerationType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // EnumLiteralExp
