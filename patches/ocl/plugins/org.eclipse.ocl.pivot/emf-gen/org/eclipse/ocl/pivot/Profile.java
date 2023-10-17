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
 * A representation of the model object '<em><b>Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A profile defines limited extensions to a reference metamodel with the purpose of adapting the metamodel to a specific platform or domain.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Profile#getProfileApplications <em>Profile Applications</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getProfile()
 * @generated
 */
public interface Profile extends org.eclipse.ocl.pivot.Package
{

	/**
	 * Returns the value of the '<em><b>Profile Applications</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.ProfileApplication}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.ProfileApplication#getAppliedProfile <em>Applied Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Applications</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Applications</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProfile_ProfileApplications()
	 * @see org.eclipse.ocl.pivot.ProfileApplication#getAppliedProfile
	 * @generated
	 */
	List<ProfileApplication> getProfileApplications();

} // Profile
