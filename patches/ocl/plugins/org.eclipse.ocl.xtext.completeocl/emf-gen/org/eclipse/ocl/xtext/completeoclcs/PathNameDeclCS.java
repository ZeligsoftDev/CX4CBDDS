/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeoclcs;

import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element Decl CS</b></em>'.
 * @extends org.eclipse.ocl.pivot.utilities.MorePivotable
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS#getOwnedPathName <em>Owned Path Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getPathNameDeclCS()
 * @model abstract="true"
 * @generated
 */
public interface PathNameDeclCS
extends ModelElementCS, org.eclipse.ocl.pivot.utilities.MorePivotable {

	/**
	 * Returns the value of the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Element Ref</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Path Name</em>' containment reference.
	 * @see #setOwnedPathName(PathNameCS)
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getPathNameDeclCS_OwnedPathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getOwnedPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS#getOwnedPathName <em>Owned Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Path Name</em>' containment reference.
	 * @see #getOwnedPathName()
	 * @generated
	 */
	void setOwnedPathName(PathNameCS value);

} // NamedElementDeclCS
