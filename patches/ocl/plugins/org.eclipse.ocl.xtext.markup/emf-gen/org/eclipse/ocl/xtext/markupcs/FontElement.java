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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.markupcs.FontElement#getFont <em>Font</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.markupcs.MarkupPackage#getFontElement()
 * @model
 * @generated
 */
public interface FontElement extends CompoundElement {
	/**
	 * Returns the value of the '<em><b>Font</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font</em>' attribute.
	 * @see #setFont(String)
	 * @see org.eclipse.ocl.xtext.markupcs.MarkupPackage#getFontElement_Font()
	 * @model required="true" derived="true"
	 * @generated
	 */
	String getFont();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.markupcs.FontElement#getFont <em>Font</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font</em>' attribute.
	 * @see #getFont()
	 * @generated
	 */
	void setFont(String value);

} // FontElement
