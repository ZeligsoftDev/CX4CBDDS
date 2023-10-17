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
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Annotation#getOwnedContents <em>Owned Contents</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Annotation#getOwnedDetails <em>Owned Details</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Annotation#getReferences <em>References</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getAnnotation()
 * @generated
 */
public interface Annotation
		extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Owned Contents</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Contents</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getAnnotation_OwnedContents()
	 * @generated
	 */
	@NonNull List<Element> getOwnedContents();

	/**
	 * Returns the value of the '<em><b>Owned Details</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Detail}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Details</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Details</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getAnnotation_OwnedDetails()
	 * @generated
	 */
	@NonNull List<Detail> getOwnedDetails();

	/**
	 * Returns the value of the '<em><b>References</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getAnnotation_References()
	 * @generated
	 */
	@NonNull List<Element> getReferences();

} // Annotation
