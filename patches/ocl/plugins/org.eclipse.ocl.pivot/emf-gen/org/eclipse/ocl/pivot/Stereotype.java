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
package org.eclipse.ocl.pivot;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A stereotype defines how an existing metaclass may be extended, and enables the use of platform or domain specific terminology or notation in place of, or in addition to, the ones used for the extended metaclass.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Stereotype#getOwnedExtenders <em>Owned Extenders</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getStereotype()
 * @generated
 */
public interface Stereotype extends org.eclipse.ocl.pivot.Class
{

	/**
	 * Returns the value of the '<em><b>Owned Extenders</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.StereotypeExtender}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.StereotypeExtender#getOwningStereotype <em>Owning Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Extension Ofs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Extenders</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getStereotype_OwnedExtenders()
	 * @see org.eclipse.ocl.pivot.StereotypeExtender#getOwningStereotype
	 * @generated
	 */
	List<StereotypeExtender> getOwnedExtenders();
} // Stereotype
