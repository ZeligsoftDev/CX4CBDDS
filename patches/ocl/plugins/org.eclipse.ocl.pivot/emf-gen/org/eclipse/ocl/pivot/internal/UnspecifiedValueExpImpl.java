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
import org.eclipse.ocl.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unspecified Value Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class UnspecifiedValueExpImpl
		extends OCLExpressionImpl
		implements UnspecifiedValueExp {

	/**
	 * The number of structural features of the '<em>Unspecified Value Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UNSPECIFIED_VALUE_EXP_FEATURE_COUNT = OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Unspecified Value Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UNSPECIFIED_VALUE_EXP_OPERATION_COUNT = OCLExpressionImpl.OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnspecifiedValueExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.UNSPECIFIED_VALUE_EXP;
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitUnspecifiedValueExp(this);
	}
} //UnspecifiedValueExpImpl
