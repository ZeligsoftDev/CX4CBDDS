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

import org.eclipse.ocl.xtext.basecs.ElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Implementation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS#getImplementation <em>Implementation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getJavaImplementationCS()
 * @model abstract="true"
 * @generated
 */
public interface JavaImplementationCS
		extends ElementCS {

	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' reference.
	 * @see #setImplementation(JavaClassCS)
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getJavaImplementationCS_Implementation()
	 * @model
	 * @generated
	 */
	JavaClassCS getImplementation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS#getImplementation <em>Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' reference.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(JavaClassCS value);

} // JavaImplementationCS
