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
 * A representation of the model object '<em><b>Model Element CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.ModelElementCS#getOriginalXmiId <em>Original Xmi Id</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.ModelElementCS#getOwnedAnnotations <em>Owned Annotations</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getModelElementCS()
 * @model abstract="true"
 * @generated
 */
public interface ModelElementCS extends PivotableElementCS {
	/**
	 * Returns the value of the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.AnnotationElementCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Annotation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Annotations</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getModelElementCS_OwnedAnnotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnnotationElementCS> getOwnedAnnotations();

	/**
	 * Returns the value of the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Xmi Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Xmi Id</em>' attribute.
	 * @see #setOriginalXmiId(String)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getModelElementCS_OriginalXmiId()
	 * @model dataType="org.eclipse.ocl.pivot.String" transient="true"
	 * @generated
	 */
	String getOriginalXmiId();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.ModelElementCS#getOriginalXmiId <em>Original Xmi Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Xmi Id</em>' attribute.
	 * @see #getOriginalXmiId()
	 * @generated
	 */
	void setOriginalXmiId(String value);

} // ModelElementCS
