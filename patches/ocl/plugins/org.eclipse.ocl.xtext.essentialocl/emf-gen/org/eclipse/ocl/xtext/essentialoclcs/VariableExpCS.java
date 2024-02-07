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

import org.eclipse.ocl.pivot.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS#getReferredVariable <em>Referred Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getVariableExpCS()
 * @model abstract="true"
 * @generated
 */
public interface VariableExpCS extends AbstractNameExpCS
{
	/**
	 * Returns the value of the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Variable</em>' reference.
	 * @see #setReferredVariable(Variable)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getVariableExpCS_ReferredVariable()
	 * @model resolveProxies="false" derived="true"
	 * @generated
	 */
	Variable getReferredVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS#getReferredVariable <em>Referred Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Variable</em>' reference.
	 * @see #getReferredVariable()
	 * @generated
	 */
	void setReferredVariable(Variable value);

} // VariableExpCS
