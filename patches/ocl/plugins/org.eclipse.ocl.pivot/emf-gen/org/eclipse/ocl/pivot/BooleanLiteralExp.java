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
 * A representation of the model object '<em><b>Boolean Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.BooleanLiteralExp#isBooleanSymbol <em>Boolean Symbol</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getBooleanLiteralExp()
 * @generated
 */
public interface BooleanLiteralExp
		extends PrimitiveLiteralExp {

	/**
	 * Returns the value of the '<em><b>Boolean Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boolean Symbol</em>' attribute.
	 * @see #isSetBooleanSymbol()
	 * @see #unsetBooleanSymbol()
	 * @see #setBooleanSymbol(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getBooleanLiteralExp_BooleanSymbol()
	 * @generated
	 */
	boolean isBooleanSymbol();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.BooleanLiteralExp#isBooleanSymbol <em>Boolean Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boolean Symbol</em>' attribute.
	 * @see #isSetBooleanSymbol()
	 * @see #unsetBooleanSymbol()
	 * @see #isBooleanSymbol()
	 * @generated
	 */
	void setBooleanSymbol(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.ocl.pivot.BooleanLiteralExp#isBooleanSymbol <em>Boolean Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBooleanSymbol()
	 * @see #isBooleanSymbol()
	 * @see #setBooleanSymbol(boolean)
	 * @generated
	 */
	void unsetBooleanSymbol();

	/**
	 * Returns whether the value of the '{@link org.eclipse.ocl.pivot.BooleanLiteralExp#isBooleanSymbol <em>Boolean Symbol</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Boolean Symbol</em>' attribute is set.
	 * @see #unsetBooleanSymbol()
	 * @see #isBooleanSymbol()
	 * @see #setBooleanSymbol(boolean)
	 * @generated
	 */
	boolean isSetBooleanSymbol();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context);

} // BooleanLiteralExp
