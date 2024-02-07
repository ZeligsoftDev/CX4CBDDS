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
 * A representation of the model object '<em><b>Iterate Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS#getAccumulators <em>Accumulators</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIterateCallExpCS()
 * @model abstract="true"
 * @generated
 */
public interface IterateCallExpCS extends IterationCallExpCS
{
	/**
	 * Returns the value of the '<em><b>Accumulators</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.essentialoclcs.VariableCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accumulators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accumulators</em>' reference list.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIterateCallExpCS_Accumulators()
	 * @model resolveProxies="false" derived="true"
	 * @generated
	 */
	EList<VariableCS> getAccumulators();

} // IterateCallExpCS
