/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.ocl.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS#getReferredProperty <em>Referred Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getPropertyCallExpCS()
 * @model abstract="true"
 * @generated
 */
public interface PropertyCallExpCS extends CallExpCS
{
	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Property</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(Property)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getPropertyCallExpCS_ReferredProperty()
	 * @model resolveProxies="false" derived="true"
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);

} // PropertyCallExpCS
