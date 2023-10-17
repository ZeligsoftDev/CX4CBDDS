/*******************************************************************************
 * Copyright (c) 2014, 2018 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink (CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Profile Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A profile application is used to show which profiles have been applied to a package.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.ProfileApplication#getAppliedProfile <em>Applied Profile</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.ProfileApplication#isIsStrict <em>Is Strict</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.ProfileApplication#getOwningPackage <em>Owning Package</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getProfileApplication()
 * @generated
 */
public interface ProfileApplication extends Element
{
	/**
	 * Returns the value of the '<em><b>Applied Profile</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Profile#getProfileApplications <em>Profile Applications</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Profile</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the Profiles that are applied to a Package through this ProfileApplication.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applied Profile</em>' reference.
	 * @see #setAppliedProfile(Profile)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProfileApplication_AppliedProfile()
	 * @see org.eclipse.ocl.pivot.Profile#getProfileApplications
	 * @generated
	 */
	Profile getAppliedProfile();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.ProfileApplication#getAppliedProfile <em>Applied Profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applied Profile</em>' reference.
	 * @see #getAppliedProfile()
	 * @generated
	 */
	void setAppliedProfile(Profile value);

	/**
	 * Returns the value of the '<em><b>Is Strict</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Strict</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies that the Profile filtering rules for the metaclasses of the referenced metamodel shall be strictly applied.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Strict</em>' attribute.
	 * @see #setIsStrict(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProfileApplication_IsStrict()
	 * @generated
	 */
	boolean isIsStrict();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.ProfileApplication#isIsStrict <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Strict</em>' attribute.
	 * @see #isIsStrict()
	 * @generated
	 */
	void setIsStrict(boolean value);

	/**
	 * Returns the value of the '<em><b>Owning Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Package#getOwnedProfileApplications <em>Owned Profile Applications</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The package that owns the profile application.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Package</em>' container reference.
	 * @see #setOwningPackage(org.eclipse.ocl.pivot.Package)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProfileApplication_OwningPackage()
	 * @see org.eclipse.ocl.pivot.Package#getOwnedProfileApplications
	 * @generated
	 */
	org.eclipse.ocl.pivot.Package getOwningPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.ProfileApplication#getOwningPackage <em>Owning Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Package</em>' container reference.
	 * @see #getOwningPackage()
	 * @generated
	 */
	void setOwningPackage(org.eclipse.ocl.pivot.Package value);

} // ProfileApplication
