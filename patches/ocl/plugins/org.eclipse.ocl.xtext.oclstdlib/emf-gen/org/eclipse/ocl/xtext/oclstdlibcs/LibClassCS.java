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
package org.eclipse.ocl.xtext.oclstdlibcs;

import org.eclipse.ocl.xtext.basecs.StructuredClassCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lib Class CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS#getMetaclassName <em>Metaclass Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibClassCS()
 * @model
 * @generated
 */
public interface LibClassCS
		extends StructuredClassCS, JavaImplementationCS {

	/**
	 * Returns the value of the '<em><b>Metaclass Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Type Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metaclass Name</em>' reference.
	 * @see #setMetaclassName(MetaclassNameCS)
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibClassCS_MetaclassName()
	 * @model
	 * @generated
	 */
	MetaclassNameCS getMetaclassName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS#getMetaclassName <em>Metaclass Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metaclass Name</em>' reference.
	 * @see #getMetaclassName()
	 * @generated
	 */
	void setMetaclassName(MetaclassNameCS value);

} // LibClassCS
