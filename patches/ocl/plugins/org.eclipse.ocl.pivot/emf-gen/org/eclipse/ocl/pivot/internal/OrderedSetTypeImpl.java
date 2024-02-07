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
import org.eclipse.ocl.pivot.OrderedSetType;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ordered Set Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class OrderedSetTypeImpl
		extends CollectionTypeImpl
		implements OrderedSetType {

	/**
	 * The number of structural features of the '<em>Ordered Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ORDERED_SET_TYPE_FEATURE_COUNT = CollectionTypeImpl.COLLECTION_TYPE_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Ordered Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ORDERED_SET_TYPE_OPERATION_COUNT = CollectionTypeImpl.COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrderedSetTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.ORDERED_SET_TYPE;
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitOrderedSetType(this);
	}

	@Override
	public @NonNull TypeId computeId() {
		if (getUnspecializedElement() == null) {
			return TypeId.ORDERED_SET;
		}
		else {
			TypeId elementTypeId = getElementType().getTypeId();
			return TypeId.ORDERED_SET.getSpecializedId(elementTypeId, isIsNullFree(), getLowerValue(), getUpperValue());
		}
	}

	@Override
	public @NonNull TypeId computeNormalizedId() {
		if (getUnspecializedElement() == null) {
			return TypeId.ORDERED_SET;
		}
		else {
			TypeId elementTypeId = getElementType().getNormalizedTypeId();
			return TypeId.ORDERED_SET.getSpecializedId(elementTypeId, isIsNullFree(), getLowerValue(), getUpperValue());
		}
	}

	@Override
	public boolean isOrdered() {
		return true;
	}

	@Override
	public boolean isUnique() {
		return true;
	}
} //OrderedSetTypeImpl
