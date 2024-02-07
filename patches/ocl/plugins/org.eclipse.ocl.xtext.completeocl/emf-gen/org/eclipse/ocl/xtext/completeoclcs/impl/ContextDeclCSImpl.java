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

package org.eclipse.ocl.xtext.completeoclcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ContextDeclCSImpl
		extends PathNameDeclCSImpl
		implements ContextDeclCS {

	/**
	 * The number of structural features of the '<em>Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONTEXT_DECL_CS_FEATURE_COUNT = PathNameDeclCSImpl.PATH_NAME_DECL_CS_FEATURE_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextDeclCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteOCLCSPackage.Literals.CONTEXT_DECL_CS;
	}
} //ContextDeclCSImpl
