/**
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.internal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.BooleanType;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.library.logical.BooleanAllInstancesOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Type</b></em>'.
 * @since 1.18
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class BooleanTypeImpl extends PrimitiveTypeImpl implements BooleanType
{
	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_TYPE_FEATURE_COUNT = PrimitiveTypeImpl.PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_TYPE_OPERATION_COUNT = PrimitiveTypeImpl.PRIMITIVE_TYPE_OPERATION_COUNT + 0;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanTypeImpl()
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
		return PivotPackage.Literals.BOOLEAN_TYPE;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitBooleanType(this);
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull SetValue allInstances(@NonNull Executor executor, @NonNull CollectionTypeId returnTypeId) {
		return BooleanAllInstancesOperation.allInstances();
	}

} //BooleanTypeImpl
