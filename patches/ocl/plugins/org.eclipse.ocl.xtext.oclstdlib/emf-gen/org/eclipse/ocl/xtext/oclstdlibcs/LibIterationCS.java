/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.oclstdlibcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lib Iteration CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS#isIsInvalidating <em>Is Invalidating</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS#isIsValidating <em>Is Validating</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS#getOwnedAccumulators <em>Owned Accumulators</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS#getOwnedIterators <em>Owned Iterators</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibIterationCS()
 * @model
 * @generated
 */
public interface LibIterationCS
		extends OperationCS, JavaImplementationCS {

	/**
	 * Returns the value of the '<em><b>Owned Iterators</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.ParameterCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Iterators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Iterators</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibIterationCS_OwnedIterators()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterCS> getOwnedIterators();

	/**
	 * Returns the value of the '<em><b>Owned Accumulators</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.ParameterCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Accumulators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Accumulators</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibIterationCS_OwnedAccumulators()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterCS> getOwnedAccumulators();

	/**
	 * Returns the value of the '<em><b>Is Invalidating</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Invalidating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Invalidating</em>' attribute.
	 * @see #setIsInvalidating(boolean)
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibIterationCS_IsInvalidating()
	 * @model default="false" dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsInvalidating();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS#isIsInvalidating <em>Is Invalidating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Invalidating</em>' attribute.
	 * @see #isIsInvalidating()
	 * @generated
	 */
	void setIsInvalidating(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Validating</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Validating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Validating</em>' attribute.
	 * @see #setIsValidating(boolean)
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibIterationCS_IsValidating()
	 * @model default="false" dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsValidating();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS#isIsValidating <em>Is Validating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Validating</em>' attribute.
	 * @see #isIsValidating()
	 * @generated
	 */
	void setIsValidating(boolean value);

} // LibIterationCS
