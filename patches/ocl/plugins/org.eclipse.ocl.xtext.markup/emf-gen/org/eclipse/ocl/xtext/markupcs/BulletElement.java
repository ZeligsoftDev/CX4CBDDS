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
 * A representation of the model object '<em><b>Bullet Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.markupcs.BulletElement#getLevel <em>Level</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.markupcs.MarkupPackage#getBulletElement()
 * @model
 * @generated
 */
public interface BulletElement extends CompoundElement {
	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #setLevel(String)
	 * @see org.eclipse.ocl.xtext.markupcs.MarkupPackage#getBulletElement_Level()
	 * @model derived="true"
	 * @generated
	 */
	String getLevel();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.markupcs.BulletElement#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(String value);

} // BulletElement
