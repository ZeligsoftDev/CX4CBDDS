/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.markupcs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.markupcs.MarkupElement#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.markupcs.MarkupElement#getUniqueId <em>Unique Id</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.markupcs.MarkupPackage#getMarkupElement()
 * @model
 * @generated
 */
public interface MarkupElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.markupcs.CompoundElement#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(CompoundElement)
	 * @see org.eclipse.ocl.xtext.markupcs.MarkupPackage#getMarkupElement_Owner()
	 * @see org.eclipse.ocl.xtext.markupcs.CompoundElement#getElements
	 * @model opposite="elements" transient="false"
	 * @generated
	 */
	CompoundElement getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.markupcs.MarkupElement#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(CompoundElement value);

	/**
	 * Returns the value of the '<em><b>Unique Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique Id</em>' attribute.
	 * @see org.eclipse.ocl.xtext.markupcs.MarkupPackage#getMarkupElement_UniqueId()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	int getUniqueId();

} // MarkupElement
