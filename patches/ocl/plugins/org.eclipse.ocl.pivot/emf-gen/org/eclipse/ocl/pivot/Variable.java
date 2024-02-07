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
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Variable#isIsImplicit <em>Is Implicit</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Variable#getOwnedInit <em>Owned Init</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Variable#getRepresentedParameter <em>Represented Parameter</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getVariable()
 * @generated
 */
public interface Variable
		extends VariableDeclaration {

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
	 * @see org.eclipse.ocl.pivot.PivotPackage#getVariable_IsImplicit()
	 * @generated
	 */
	boolean isIsImplicit();

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
	 * @see org.eclipse.ocl.pivot.PivotPackage#getVariable_OwnedInit()
	 * @generated
	 */
	OCLExpression getOwnedInit();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Variable#getOwnedInit <em>Owned Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Init</em>' containment reference.
	 * @see #getOwnedInit()
	 * @generated
	 */
	void setOwnedInit(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Represented Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Represented Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Represented Parameter</em>' reference.
	 * @see #setRepresentedParameter(Parameter)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getVariable_RepresentedParameter()
	 * @generated
	 */
	Parameter getRepresentedParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Variable#getRepresentedParameter <em>Represented Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Represented Parameter</em>' reference.
	 * @see #getRepresentedParameter()
	 * @generated
	 */
	void setRepresentedParameter(Parameter value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleInitialiserType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Variable#isIsImplicit <em>Is Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Implicit</em>' attribute.
	 * @see #isIsImplicit()
	 * @generated
	 */
	void setIsImplicit(boolean value);

} // Variable
