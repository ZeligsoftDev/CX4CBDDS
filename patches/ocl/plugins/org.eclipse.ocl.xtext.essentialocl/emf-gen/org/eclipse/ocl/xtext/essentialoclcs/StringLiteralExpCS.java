/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
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
 * A representation of the model object '<em><b>String Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS#getSegments <em>Segments</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getStringLiteralExpCS()
 * @model
 * @generated
 */
public interface StringLiteralExpCS
		extends PrimitiveLiteralExpCS {

	/**
	 * Returns the value of the '<em><b>Segments</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Segments</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segments</em>' attribute list.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getStringLiteralExpCS_Segments()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getSegments();

} // StringLiteralExpCS
