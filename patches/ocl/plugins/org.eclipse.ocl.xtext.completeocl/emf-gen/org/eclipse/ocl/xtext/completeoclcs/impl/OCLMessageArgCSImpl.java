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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.xtext.completeoclcs.OCLMessageArgCS;
import org.eclipse.ocl.xtext.completeoclcs.util.CompleteOCLCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Message Arg CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class OCLMessageArgCSImpl
		extends ExpCSImpl
		implements OCLMessageArgCS {

	/**
	 * The number of structural features of the '<em>OCL Message Arg CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OCL_MESSAGE_ARG_CS_FEATURE_COUNT = ExpCSImpl.EXP_CS_FEATURE_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCLMessageArgCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteOCLCSPackage.Literals.OCL_MESSAGE_ARG_CS;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		if (visitor instanceof CompleteOCLCSVisitor) {
			return (R) ((CompleteOCLCSVisitor<?>)visitor).visitOCLMessageArgCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}
} //OclMessageArgCSImpl
