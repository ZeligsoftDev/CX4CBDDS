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
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SequenceTypeImpl
		extends CollectionTypeImpl
		implements SequenceType {

	/**
	 * The number of structural features of the '<em>Sequence Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SEQUENCE_TYPE_FEATURE_COUNT = CollectionTypeImpl.COLLECTION_TYPE_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Sequence Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SEQUENCE_TYPE_OPERATION_COUNT = CollectionTypeImpl.COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.SEQUENCE_TYPE;
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitSequenceType(this);
	}

	@Override
	public @NonNull TypeId computeId() {
		if (getUnspecializedElement() == null) {
			return TypeId.SEQUENCE;
		}
		else {
			TypeId elementTypeId = getElementType().getTypeId();
			return TypeId.SEQUENCE.getSpecializedId(elementTypeId, isIsNullFree(), getLowerValue(), getUpperValue());
		}
	}

	@Override
	public @NonNull TypeId computeNormalizedId() {
		if (getUnspecializedElement() == null) {
			return TypeId.SEQUENCE;
		}
		else {
			TypeId elementTypeId = getElementType().getNormalizedTypeId();
			return TypeId.SEQUENCE.getSpecializedId(elementTypeId, isIsNullFree(), getLowerValue(), getUpperValue());
		}
	}

	@Override
	public boolean isOrdered() {
		return true;
	}
} //SequenceTypeImpl
