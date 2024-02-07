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
 * A representation of the model object '<em><b>Annotation Element CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.AnnotationElementCS#getOwnedDetails <em>Owned Details</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getAnnotationElementCS()
 * @model abstract="true"
 * @generated
 */
public interface AnnotationElementCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Owned Details</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.DetailCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Detail</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Details</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getAnnotationElementCS_OwnedDetails()
	 * @model containment="true"
	 * @generated
	 */
	EList<DetailCS> getOwnedDetails();

} // AnnotationElementCS
