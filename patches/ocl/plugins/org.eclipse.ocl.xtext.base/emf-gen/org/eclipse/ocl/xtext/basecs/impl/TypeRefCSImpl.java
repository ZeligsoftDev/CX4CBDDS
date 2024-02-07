/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.basecs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type CS Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class TypeRefCSImpl extends ElementRefCSImpl implements TypeRefCS {
	/**
	 * The number of structural features of the '<em>Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TYPE_REF_CS_FEATURE_COUNT = ElementRefCSImpl.ELEMENT_REF_CS_FEATURE_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeRefCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSPackage.Literals.TYPE_REF_CS;
	}
} //TypeCSRefImpl
