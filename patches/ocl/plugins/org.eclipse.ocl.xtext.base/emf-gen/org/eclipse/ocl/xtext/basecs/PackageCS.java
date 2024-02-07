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

package org.eclipse.ocl.xtext.basecs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.PackageCS#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.PackageCS#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.PackageCS#getOwnedClasses <em>Owned Classes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getPackageCS()
 * @model
 * @generated
 */
public interface PackageCS extends PackageOwnerCS, NamespaceCS {
	/**
	 * Returns the value of the '<em><b>Owned Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.ClassCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.ClassCS#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Classes</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getPackageCS_OwnedClasses()
	 * @see org.eclipse.ocl.xtext.basecs.ClassCS#getOwningPackage
	 * @model opposite="owningPackage" containment="true"
	 * @generated
	 */
	EList<ClassCS> getOwnedClasses();

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
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getPackageCS_NsPrefix()
	 * @model dataType="org.eclipse.ocl.pivot.String"
	 * @generated
	 */
	String getNsPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.PackageCS#getNsPrefix <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns Prefix</em>' attribute.
	 * @see #getNsPrefix()
	 * @generated
	 */
	void setNsPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ns URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ns URI</em>' attribute.
	 * @see #setNsURI(String)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getPackageCS_NsURI()
	 * @model dataType="org.eclipse.ocl.pivot.String"
	 * @generated
	 */
	String getNsURI();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.PackageCS#getNsURI <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns URI</em>' attribute.
	 * @see #getNsURI()
	 * @generated
	 */
	void setNsURI(String value);

} // PackageCS
