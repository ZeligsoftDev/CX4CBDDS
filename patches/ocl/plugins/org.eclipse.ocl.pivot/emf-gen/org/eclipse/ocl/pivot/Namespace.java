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

import org.eclipse.jdt.annotation.NonNull;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Namespace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Namespace is an Element in a model that owns and/or imports a set of NamedElements that can be identified by name.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Namespace#getOwnedConstraints <em>Owned Constraints</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getNamespace()
 * @generated
 */
public interface Namespace extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies a set of Constraints owned by this Namespace.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Constraints</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getNamespace_OwnedConstraints()
	 * @generated
	 */
	@NonNull List<Constraint> getOwnedConstraints();
} // Namespace
