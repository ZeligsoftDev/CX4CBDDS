/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.oclstdlibcs;

import org.eclipse.ocl.xtext.basecs.AttributeCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lib Property CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS#isIsStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS#getOwnedOpposite <em>Owned Opposite</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibPropertyCS()
 * @model
 * @generated
 */
public interface LibPropertyCS
		extends AttributeCS, JavaImplementationCS {

	/**
	 * Returns the value of the '<em><b>Is Static</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Static</em>' attribute.
	 * @see #setIsStatic(boolean)
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibPropertyCS_IsStatic()
	 * @model default="false" dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS#isIsStatic <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Static</em>' attribute.
	 * @see #isIsStatic()
	 * @generated
	 */
	void setIsStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Opposite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Opposite</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Opposite</em>' containment reference.
	 * @see #setOwnedOpposite(LibOppositeCS)
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibPropertyCS_OwnedOpposite()
	 * @model containment="true"
	 * @generated
	 */
	LibOppositeCS getOwnedOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS#getOwnedOpposite <em>Owned Opposite</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Opposite</em>' containment reference.
	 * @see #getOwnedOpposite()
	 * @generated
	 */
	void setOwnedOpposite(LibOppositeCS value);

} // LibPropertyCS
