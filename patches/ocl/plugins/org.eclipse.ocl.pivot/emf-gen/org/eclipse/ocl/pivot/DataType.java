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
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A DataType is a type whose instances are identified only by their value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.DataType#getBehavioralClass <em>Behavioral Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.DataType#isIsSerializable <em>Is Serializable</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.DataType#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getDataType()
 * @generated
 */
public interface DataType
extends org.eclipse.ocl.pivot.Class {

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.DataType#isIsSerializable <em>Is Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Serializable</em>' attribute.
	 * @see #isIsSerializable()
	 * @generated
	 */
	void setIsSerializable(boolean value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * @since 1.3
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value pseudo-property accesses a String-valued representation of the DataType.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getDataType_Value()
	 * @generated
	 */
	String getValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateBehavioralClassHasDistinctName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateBehavioralClassIsPrimitiveType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateBehavioralClassIsSuperClass(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * Returns the value of the '<em><b>Behavioral Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavioral Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An equivalent type, such as a PrimitiveType, that defines the conformance and evaluation behavior.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Behavioral Class</em>' reference.
	 * @see #setBehavioralClass(org.eclipse.ocl.pivot.Class)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getDataType_BehavioralClass()
	 * @generated
	 */
	org.eclipse.ocl.pivot.Class getBehavioralClass();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.DataType#getBehavioralClass <em>Behavioral Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavioral Class</em>' reference.
	 * @see #getBehavioralClass()
	 * @generated
	 */
	void setBehavioralClass(org.eclipse.ocl.pivot.Class value);

	/**
	 * Returns the value of the '<em><b>Is Serializable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Serializable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Serializable</em>' attribute.
	 * @see #setIsSerializable(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getDataType_IsSerializable()
	 * @generated
	 */
	boolean isIsSerializable();
} // DataType
