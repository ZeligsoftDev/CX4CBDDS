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

import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.xtext.basecs.OperationCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lib Operation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#isIsInvalidating <em>Is Invalidating</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#isIsStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#isIsValidating <em>Is Validating</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#getPrecedence <em>Precedence</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibOperationCS()
 * @model
 * @generated
 */
public interface LibOperationCS
		extends OperationCS, JavaImplementationCS {

	/**
	 * Returns the value of the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precedence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precedence</em>' reference.
	 * @see #setPrecedence(Precedence)
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibOperationCS_Precedence()
	 * @model
	 * @generated
	 */
	Precedence getPrecedence();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#getPrecedence <em>Precedence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precedence</em>' reference.
	 * @see #getPrecedence()
	 * @generated
	 */
	void setPrecedence(Precedence value);

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
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibOperationCS_IsInvalidating()
	 * @model default="false" dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsInvalidating();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#isIsInvalidating <em>Is Invalidating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Invalidating</em>' attribute.
	 * @see #isIsInvalidating()
	 * @generated
	 */
	void setIsInvalidating(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Static</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Static</em>' attribute.
	 * @see #setIsStatic(boolean)
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibOperationCS_IsStatic()
	 * @model default="false" dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#isIsStatic <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Static</em>' attribute.
	 * @see #isIsStatic()
	 * @generated
	 */
	void setIsStatic(boolean value);

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
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibOperationCS_IsValidating()
	 * @model default="false" dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsValidating();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#isIsValidating <em>Is Validating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Validating</em>' attribute.
	 * @see #isIsValidating()
	 * @generated
	 */
	void setIsValidating(boolean value);

} // LibOperationCS
