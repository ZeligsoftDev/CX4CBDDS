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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.EnumerationId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An Enumeration is a DataType whose values are enumerated in the model as EnumerationLiterals.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Enumeration#getOwnedLiterals <em>Owned Literals</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getEnumeration()
 * @generated
 */
public interface Enumeration extends DataType {

	/**
	 * Returns the value of the '<em><b>Owned Literals</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.EnumerationLiteral}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.EnumerationLiteral#getOwningEnumeration <em>Owning Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ordered set of literals owned by this Enumeration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Literals</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getEnumeration_OwnedLiterals()
	 * @see org.eclipse.ocl.pivot.EnumerationLiteral#getOwningEnumeration
	 * @generated
	 */
	@NonNull List<EnumerationLiteral> getOwnedLiterals();

	@NonNull EnumerationId getEnumerationId();
	@Nullable EnumerationLiteral getEnumerationLiteral(@NonNull String name);
} // Enumeration
