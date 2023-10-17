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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Comment is a textual annotation that can be attached to a set of Elements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Comment#getAnnotatedElements <em>Annotated Elements</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Comment#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Comment#getOwningElement <em>Owning Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getComment()
 * @generated
 */
public interface Comment
		extends Element {

	/**
	 * Returns the value of the '<em><b>Annotated Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Element}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Element#getAnnotatingComments <em>Annotating Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the Element(s) being commented.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Annotated Elements</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getComment_AnnotatedElements()
	 * @see org.eclipse.ocl.pivot.Element#getAnnotatingComments
	 * @generated
	 */
	List<Element> getAnnotatedElements();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies a string that is the comment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getComment_Body()
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Comment#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

	/**
	 * Returns the value of the '<em><b>Owning Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Element#getOwnedComments <em>Owned Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Element</em>' container reference.
	 * @see #setOwningElement(Element)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getComment_OwningElement()
	 * @see org.eclipse.ocl.pivot.Element#getOwnedComments
	 * @generated
	 */
	Element getOwningElement();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Comment#getOwningElement <em>Owning Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Element</em>' container reference.
	 * @see #getOwningElement()
	 * @generated
	 */
	void setOwningElement(Element value);

} // Comment
