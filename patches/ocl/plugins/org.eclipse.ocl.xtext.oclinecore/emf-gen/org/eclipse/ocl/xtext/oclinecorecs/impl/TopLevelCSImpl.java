/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
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
package org.eclipse.ocl.xtext.oclinecorecs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.impl.RootPackageCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.ocl.xtext.oclinecorecs.TopLevelCS;
import org.eclipse.ocl.xtext.oclinecorecs.util.OCLinEcoreCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Level CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TopLevelCSImpl extends RootPackageCSImpl implements TopLevelCS
{
	/**
	 * The number of structural features of the '<em>Top Level CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TOP_LEVEL_CS_FEATURE_COUNT = RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopLevelCSImpl()
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
		return OCLinEcoreCSPackage.Literals.TOP_LEVEL_CS;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		if (visitor instanceof OCLinEcoreCSVisitor) {
			return (R) ((OCLinEcoreCSVisitor<?>)visitor).visitTopLevelCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //TopLevelCSImpl
