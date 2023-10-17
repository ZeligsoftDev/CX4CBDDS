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

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.PackageId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A package can have one or more profile applications to indicate which profiles have been applied. Because a profile is a package, it is possible to apply a profile not only to packages, but also to profiles.
 * Package specializes TemplateableElement and PackageableElement specializes ParameterableElement to specify that a package can be used as a template and a PackageableElement as a template parameter.
 * A package is used to group elements, and provides a namespace for the grouped elements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getURI <em>URI</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getImportedPackages <em>Imported Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getOwnedClasses <em>Owned Classes</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getOwnedInstances <em>Owned Instances</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getOwnedPackages <em>Owned Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getOwnedProfileApplications <em>Owned Profile Applications</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getOwningPackage <em>Owning Package</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage()
 * @generated
 */
public interface Package extends Namespace {

	/**
	 * Returns the value of the '<em><b>Owned Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Package}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Package#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the packaged elements that are Packages.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Packages</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_OwnedPackages()
	 * @see org.eclipse.ocl.pivot.Package#getOwningPackage
	 * @generated
	 */
	@NonNull List<Package> getOwnedPackages();

	/**
	 * Returns the value of the '<em><b>Owned Profile Applications</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.ProfileApplication}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.ProfileApplication#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Profile Applications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the ProfileApplications that indicate which profiles have been applied to the Package.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Profile Applications</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_OwnedProfileApplications()
	 * @see org.eclipse.ocl.pivot.ProfileApplication#getOwningPackage
	 * @generated
	 */
	List<ProfileApplication> getOwnedProfileApplications();

	/**
	 * Returns the value of the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ns Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ns Prefix</em>' attribute.
	 * @see #setNsPrefix(String)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_NsPrefix()
	 * @generated
	 */
	String getNsPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Package#getNsPrefix <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns Prefix</em>' attribute.
	 * @see #getNsPrefix()
	 * @generated
	 */
	void setNsPrefix(String value);

	/**
	 * Returns the value of the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ns URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Provides an identifier for the package that can be used for many purposes. A URI is the universally unique identification of the package following the IETF URI specification, RFC 2396 http://www.ietf.org/rfc/rfc2396.txt and it must comply with those syntax rules.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>URI</em>' attribute.
	 * @see #setURI(String)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_URI()
	 * @generated
	 */
	String getURI();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Package#getURI <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URI</em>' attribute.
	 * @see #getURI()
	 * @generated
	 */
	void setURI(String value);

	/**
	 * Returns the value of the '<em><b>Owned Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.InstanceSpecification}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.InstanceSpecification#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The instance specification that owns this slot.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Instances</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_OwnedInstances()
	 * @see org.eclipse.ocl.pivot.InstanceSpecification#getOwningPackage
	 * @generated
	 */
	List<InstanceSpecification> getOwnedInstances();

	/**
	 * Returns the value of the '<em><b>Imported Packages</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Package</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Packages</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_ImportedPackages()
	 * @generated
	 */
	@NonNull List<Package> getImportedPackages();

	/**
	 * Returns the value of the '<em><b>Owned Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Class}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Class#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the packaged elements that are Types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Classes</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_OwnedClasses()
	 * @see org.eclipse.ocl.pivot.Class#getOwningPackage
	 * @generated
	 */
	@NonNull List<org.eclipse.ocl.pivot.Class> getOwnedClasses();

	/**
	 * Returns the value of the '<em><b>Owning Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Package#getOwnedPackages <em>Owned Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the Package that owns this Package.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Package</em>' container reference.
	 * @see #setOwningPackage(Package)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_OwningPackage()
	 * @see org.eclipse.ocl.pivot.Package#getOwnedPackages
	 * @generated
	 */
	Package getOwningPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Package#getOwningPackage <em>Owning Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Package</em>' container reference.
	 * @see #getOwningPackage()
	 * @generated
	 */
	void setOwningPackage(Package value);

	@Nullable EPackage getEPackage();
	@NonNull PackageId getPackageId();
	org.eclipse.ocl.pivot.@Nullable Class getOwnedClass(String className);
} // Package
