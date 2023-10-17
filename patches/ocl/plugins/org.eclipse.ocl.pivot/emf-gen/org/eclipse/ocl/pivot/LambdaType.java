/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.ParametersId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lambda Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.LambdaType#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.LambdaType#getParameterType <em>Parameter Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.LambdaType#getResultType <em>Result Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getLambdaType()
 * @generated
 */
public interface LambdaType extends DataType
{
	/**
	 * Returns the value of the '<em><b>Context Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Type</em>' reference.
	 * @see #setContextType(Type)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getLambdaType_ContextType()
	 * @generated
	 */
	Type getContextType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.LambdaType#getContextType <em>Context Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Type</em>' reference.
	 * @see #getContextType()
	 * @generated
	 */
	void setContextType(Type value);

	/**
	 * Returns the value of the '<em><b>Parameter Type</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Type</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getLambdaType_ParameterType()
	 * @generated
	 */
	@NonNull List<Type> getParameterType();

	/**
	 * Returns the value of the '<em><b>Result Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Type</em>' reference.
	 * @see #setResultType(Type)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getLambdaType_ResultType()
	 * @generated
	 */
	Type getResultType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.LambdaType#getResultType <em>Result Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Type</em>' reference.
	 * @see #getResultType()
	 * @generated
	 */
	void setResultType(Type value);

	@NonNull ParametersId getParametersId();
	@NonNull List<? extends Type> getParameterTypes();
} // LambdaType
