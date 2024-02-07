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
package org.eclipse.ocl.pivot.internal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveLiteralExp;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class PrimitiveLiteralExpImpl
		extends LiteralExpImpl
		implements PrimitiveLiteralExp {

	/**
	 * The number of structural features of the '<em>Primitive Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMITIVE_LITERAL_EXP_FEATURE_COUNT = LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Primitive Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMITIVE_LITERAL_EXP_OPERATION_COUNT = LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.PRIMITIVE_LITERAL_EXP;
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitPrimitiveLiteralExp(this);
	}
} //PrimitiveLiteralExpImpl
