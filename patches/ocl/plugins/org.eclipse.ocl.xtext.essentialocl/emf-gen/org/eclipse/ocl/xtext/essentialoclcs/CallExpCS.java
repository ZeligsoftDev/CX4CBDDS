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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.CallExpCS#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.CallExpCS#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getCallExpCS()
 * @model abstract="true"
 * @generated
 */
public interface CallExpCS extends AbstractNameExpCS
{
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getCallExpCS_Source()
	 * @model resolveProxies="false" derived="true"
	 * @generated
	 */
	ExpCS getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.CallExpCS#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' reference list.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getCallExpCS_Arguments()
	 * @model resolveProxies="false" derived="true"
	 * @generated
	 */
	EList<ExpCS> getArguments();

} // CallExpCS
