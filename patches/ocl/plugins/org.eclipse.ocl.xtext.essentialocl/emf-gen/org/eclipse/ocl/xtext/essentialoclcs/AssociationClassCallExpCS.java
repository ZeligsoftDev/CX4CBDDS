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

import org.eclipse.ocl.pivot.AssociationClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association Class Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS#getReferredAssociation <em>Referred Association</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getAssociationClassCallExpCS()
 * @model abstract="true"
 * @generated
 */
public interface AssociationClassCallExpCS extends CallExpCS
{
	/**
	 * Returns the value of the '<em><b>Referred Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Association</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Association</em>' reference.
	 * @see #setReferredAssociation(AssociationClass)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getAssociationClassCallExpCS_ReferredAssociation()
	 * @model resolveProxies="false" derived="true"
	 * @generated
	 */
	AssociationClass getReferredAssociation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS#getReferredAssociation <em>Referred Association</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Association</em>' reference.
	 * @see #getReferredAssociation()
	 * @generated
	 */
	void setReferredAssociation(AssociationClass value);

} // AssociationClassCallExpCS
