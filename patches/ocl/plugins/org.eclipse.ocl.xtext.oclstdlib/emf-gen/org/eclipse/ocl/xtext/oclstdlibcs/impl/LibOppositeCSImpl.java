/**
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.xtext.oclstdlibcs.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.xtext.basecs.impl.FeatureCSImpl;

import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.ocl.xtext.oclstdlibcs.LibOppositeCS;
import org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage;

import org.eclipse.ocl.xtext.oclstdlibcs.util.OCLstdlibCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lib Opposite CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class LibOppositeCSImpl extends FeatureCSImpl implements LibOppositeCS
{
	/**
	 * The number of structural features of the '<em>Lib Opposite CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIB_OPPOSITE_CS_FEATURE_COUNT = FeatureCSImpl.FEATURE_CS_FEATURE_COUNT + 0;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibOppositeCSImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return OCLstdlibCSPackage.Literals.LIB_OPPOSITE_CS;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		if (visitor instanceof OCLstdlibCSVisitor) {
			return (R) ((OCLstdlibCSVisitor<?>)visitor).visitLibOppositeCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //LibOppositeCSImpl
