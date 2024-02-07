/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.xtext.basecs.ElementRefCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ElementRefCSImpl extends PivotableElementCSImpl implements ElementRefCS
{
	/**
	 * The number of structural features of the '<em>Element Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ELEMENT_REF_CS_FEATURE_COUNT = PivotableElementCSImpl.PIVOTABLE_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementRefCSImpl()
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
		return BaseCSPackage.Literals.ELEMENT_REF_CS;
	}
} //ElementRefCSImpl
