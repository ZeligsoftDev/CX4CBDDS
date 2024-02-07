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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.markupcs.CompoundElement#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.markupcs.MarkupPackage#getCompoundElement()
 * @model
 * @generated
 */
public interface CompoundElement extends MarkupElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.markupcs.MarkupElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.markupcs.MarkupElement#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.markupcs.MarkupPackage#getCompoundElement_Elements()
	 * @see org.eclipse.ocl.xtext.markupcs.MarkupElement#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<MarkupElement> getElements();

} // CompoundElement
