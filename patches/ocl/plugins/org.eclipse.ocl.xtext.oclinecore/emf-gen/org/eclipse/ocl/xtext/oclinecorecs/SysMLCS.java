/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.ocl.xtext.oclinecorecs;

import org.eclipse.ocl.xtext.basecs.AnnotationElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sys MLCS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.oclinecorecs.SysMLCS#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSPackage#getSysMLCS()
 * @model
 * @generated
 */
public interface SysMLCS extends AnnotationElementCS
{
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
	 * @see org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSPackage#getSysMLCS_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.oclinecorecs.SysMLCS#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // SysMLCS
