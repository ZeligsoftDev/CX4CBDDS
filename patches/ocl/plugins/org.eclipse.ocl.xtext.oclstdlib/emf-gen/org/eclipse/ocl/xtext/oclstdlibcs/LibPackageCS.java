/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclstdlibcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.PackageCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lib Package CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.LibPackageCS#getOwnedPrecedences <em>Owned Precedences</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibPackageCS()
 * @model
 * @generated
 */
public interface LibPackageCS extends PackageCS
{
	/**
	 * Returns the value of the '<em><b>Owned Precedences</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Precedence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Precedences</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getLibPackageCS_OwnedPrecedences()
	 * @model containment="true"
	 * @generated
	 */
	EList<PrecedenceCS> getOwnedPrecedences();

} // LibPackageCS
