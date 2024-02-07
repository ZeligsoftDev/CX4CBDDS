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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.NameUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TupleTypeImpl
		extends DataTypeImpl
		implements TupleType {

	/**
	 * The number of structural features of the '<em>Tuple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TUPLE_TYPE_FEATURE_COUNT = DataTypeImpl.DATA_TYPE_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Tuple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TUPLE_TYPE_OPERATION_COUNT = DataTypeImpl.DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TupleTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TUPLE_TYPE;
	}

	private /*final @NonNull*/ TupleTypeId tupleTypeId;		// FIXME Redundant, but PivotSaver has to 'clone' these using EcoreUtil.Copier

	public TupleTypeImpl(@NonNull TupleTypeId tupleTypeId) {
		this.tupleTypeId = tupleTypeId;
		setName(tupleTypeId.getName());
	}

	@Override
	public @NonNull TypeId computeId() {
		TupleTypeId tupleTypeId2 = tupleTypeId;
		if (tupleTypeId2 == null) {
			String name2 = NameUtil.getSafeName(this);
			List<Property> parts = getOwnedProperties();
			int iSize = parts.size();
			List<@NonNull TuplePartId> partIds = new ArrayList<@NonNull TuplePartId>(iSize);
			for (int i = 0; i < iSize; i++) {
				@SuppressWarnings("null")@NonNull TypedElement part = parts.get(i);
				String partName = NameUtil.getSafeName(part);
				TypeId partTypeId = part.getTypeId();
				partIds.add(IdManager.getTuplePartId(i, partName, partTypeId));
			}
			tupleTypeId = tupleTypeId2 = IdManager.getTupleTypeId(name2, partIds);
		}
		return tupleTypeId2;
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull TypeId computeNormalizedId() {
	//	TupleTypeId tupleTypeId2 = tupleTypeId;
	//	if (tupleTypeId2 == null) {
			String name2 = NameUtil.getSafeName(this);
			List<Property> parts = getOwnedProperties();
			int iSize = parts.size();
			List<@NonNull TuplePartId> partIds = new ArrayList<@NonNull TuplePartId>(iSize);
			for (int i = 0; i < iSize; i++) {
				@SuppressWarnings("null")@NonNull TypedElement part = parts.get(i);
				String partName = NameUtil.getSafeName(part);
				TypeId partTypeId = part.getNormalizedTypeId();
				partIds.add(IdManager.getTuplePartId(i, partName, partTypeId));
			}
			TypeId tupleTypeId2 = IdManager.getTupleTypeId(name2, partIds);
	//	}
		return tupleTypeId2;
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitTupleType(this);
	}

	@Override
	public @NonNull CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary) {
		Type tupleType = standardLibrary.getOclTupleType();
		return tupleType.getInheritance(standardLibrary);
	}

	@Override
	public @NonNull TupleTypeId getTupleTypeId() {
		return getTypeId();
	}

	@Override
	public @NonNull TupleTypeId getTypeId() {
		return (TupleTypeId) super.getTypeId();
	}
} //TupleTypeImpl
