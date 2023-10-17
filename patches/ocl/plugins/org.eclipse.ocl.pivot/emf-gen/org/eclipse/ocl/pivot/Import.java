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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Import#getImportedNamespace <em>Imported Namespace</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Import#getXmiidVersion <em>Xmiid Version</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getImport()
 * @generated
 */
public interface Import extends NamedElement
{
	/**
	 * Returns the value of the '<em><b>Imported Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Namespace</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Namespace</em>' reference.
	 * @see #setImportedNamespace(Namespace)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getImport_ImportedNamespace()
	 * @generated
	 */
	Namespace getImportedNamespace();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Import#getImportedNamespace <em>Imported Namespace</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Namespace</em>' reference.
	 * @see #getImportedNamespace()
	 * @generated
	 */
	void setImportedNamespace(Namespace value);

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
	 * @see org.eclipse.ocl.pivot.PivotPackage#getImport_XmiidVersion()
	 * @generated
	 */
	Number getXmiidVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Import#getXmiidVersion <em>Xmiid Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.4
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmiid Version</em>' attribute.
	 * @see #getXmiidVersion()
	 * @generated
	 */
	void setXmiidVersion(Number value);

} // Import
