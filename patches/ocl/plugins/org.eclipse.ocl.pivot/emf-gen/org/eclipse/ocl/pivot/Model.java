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

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A model captures a view of a physical system. It is an abstraction of the physical system, with a certain purpose. This purpose determines what is to be included in the model and what is irrelevant. Thus the model completely describes those aspects of the physical system that are relevant to the purpose of the model, at the appropriate level of detail.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Model#getExternalURI <em>External URI</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Model#getOwnedImports <em>Owned Imports</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Model#getOwnedPackages <em>Owned Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Model#getXmiidVersion <em>Xmiid Version</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getModel()
 * @generated
 */
public interface Model extends Namespace
{

	/**
	 * Returns the value of the '<em><b>Owned Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Package</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Packages</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getModel_OwnedPackages()
	 * @generated
	 */
	@NonNull List<org.eclipse.ocl.pivot.Package> getOwnedPackages();

	/**
	 * Returns the value of the '<em><b>Xmiid Version</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmiid Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 1.4
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmiid Version</em>' attribute.
	 * @see #setXmiidVersion(Number)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getModel_XmiidVersion()
	 * @generated
	 */
	Number getXmiidVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Model#getXmiidVersion <em>Xmiid Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.4
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmiid Version</em>' attribute.
	 * @see #getXmiidVersion()
	 * @generated
	 */
	void setXmiidVersion(Number value);

	/**
	 * Returns the value of the '<em><b>External URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External URI</em>' attribute.
	 * @see #setExternalURI(String)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getModel_ExternalURI()
	 * @generated
	 */
	String getExternalURI();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Model#getExternalURI <em>External URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External URI</em>' attribute.
	 * @see #getExternalURI()
	 * @generated
	 */
	void setExternalURI(String value);

	/**
	 * Returns the value of the '<em><b>Owned Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Imports</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getModel_OwnedImports()
	 * @generated
	 */
	@NonNull List<Import> getOwnedImports();

} // Root