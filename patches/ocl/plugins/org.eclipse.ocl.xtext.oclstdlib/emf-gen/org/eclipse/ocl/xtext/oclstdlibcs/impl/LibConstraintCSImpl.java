/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclstdlibcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.impl.ConstraintCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.oclstdlibcs.LibConstraintCS;
import org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage;
import org.eclipse.ocl.xtext.oclstdlibcs.util.OCLstdlibCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lib Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class LibConstraintCSImpl
		extends ConstraintCSImpl
		implements LibConstraintCS {

	/**
	 * The number of structural features of the '<em>Lib Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIB_CONSTRAINT_CS_FEATURE_COUNT = ConstraintCSImpl.CONSTRAINT_CS_FEATURE_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibConstraintCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLstdlibCSPackage.Literals.LIB_CONSTRAINT_CS;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		if (visitor instanceof OCLstdlibCSVisitor) {
			return (R) ((OCLstdlibCSVisitor<?>)visitor).visitLibConstraintCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}
} //LibConstraintCSImpl
