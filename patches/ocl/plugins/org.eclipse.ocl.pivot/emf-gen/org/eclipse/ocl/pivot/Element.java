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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * @extends org.eclipse.ocl.pivot.util.Visitable
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An Element is a constituent of a model. As such, it has the capability of owning other Elements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Element#getAnnotatingComments <em>Annotating Comments</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Element#getOwnedAnnotations <em>Owned Annotations</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Element#getOwnedComments <em>Owned Comments</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Element#getOwnedExtensions <em>Owned Extensions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getElement()
 * @generated
 */
public interface Element extends EObject, org.eclipse.ocl.pivot.util.Visitable {

	/**
	 * Returns the value of the '<em><b>Annotating Comments</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Comment}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Comment#getAnnotatedElements <em>Annotated Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotating Comments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotating Comments</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getElement_AnnotatingComments()
	 * @see org.eclipse.ocl.pivot.Comment#getAnnotatedElements
	 * @generated
	 */
	List<Comment> getAnnotatingComments();

	/**
	 * Returns the value of the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.ElementExtension}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.ElementExtension#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Extensions</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getElement_OwnedExtensions()
	 * @see org.eclipse.ocl.pivot.ElementExtension#getBase
	 * @generated
	 */
	@NonNull List<ElementExtension> getOwnedExtensions();

	/**
	 * Returns the value of the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Annotation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Annotations</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getElement_OwnedAnnotations()
	 * @generated
	 */
	@NonNull List<Element> getOwnedAnnotations();

	/**
	 * Returns the value of the '<em><b>Owned Comments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Comment}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Comment#getOwningElement <em>Owning Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Comments owned by this Element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Comments</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getElement_OwnedComments()
	 * @see org.eclipse.ocl.pivot.Comment#getOwningElement
	 * @generated
	 */
	List<Comment> getOwnedComments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query allOwnedElements() gives all of the direct and indirect ownedElements of an Element.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	@NonNull List<Element> allOwnedElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Element getValue(Type stereotype, String propertyName);

	/**
	 * Accept a visit from a visitor and return the result of a call to the derived type-specific visitXXX in the visitor.
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build/templates/model/Class/insert.javajetinc
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor);

	EObject getESObject();

	/**
	 * @deprecated use getESObject
	 */
	@Deprecated
	EObject getETarget();
} // Element
