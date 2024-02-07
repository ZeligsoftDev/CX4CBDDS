/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constructor Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS#getParts <em>Parts</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getShadowExpCS()
 * @model abstract="true"
 * @generated
 */
public interface ShadowExpCS extends AbstractNameExpCS
{
	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Name</em>' reference.
	 * @see #setTypeName(TypeNameExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getShadowExpCS_TypeName()
	 * @model resolveProxies="false" derived="true"
	 * @generated
	 */
	TypeNameExpCS getTypeName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS#getTypeName <em>Type Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' reference.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(TypeNameExpCS value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' reference list.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getShadowExpCS_Parts()
	 * @model resolveProxies="false" derived="true"
	 * @generated
	 */
	EList<ShadowPartCS> getParts();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getShadowExpCS_Value()
	 * @model unique="false" derived="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // ShadowExpCS
