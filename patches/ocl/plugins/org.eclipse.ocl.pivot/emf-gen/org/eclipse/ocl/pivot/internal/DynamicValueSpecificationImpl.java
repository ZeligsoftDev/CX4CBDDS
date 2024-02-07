/**
 * Copyright (c) 2010, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.DynamicValueSpecification;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Value Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class DynamicValueSpecificationImpl extends ValueSpecificationImpl implements DynamicValueSpecification
{
	/**
	 * The number of structural features of the '<em>Dynamic Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DYNAMIC_VALUE_SPECIFICATION_FEATURE_COUNT = ValueSpecificationImpl.VALUE_SPECIFICATION_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Dynamic Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DYNAMIC_VALUE_SPECIFICATION_OPERATION_COUNT = ValueSpecificationImpl.VALUE_SPECIFICATION_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicValueSpecificationImpl()
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
		return PivotPackage.Literals.DYNAMIC_VALUE_SPECIFICATION;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitDynamicValueSpecification(this);
	}

} //DynamicValueSpecificationImpl
