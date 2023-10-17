/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.executor;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.Unlimited;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

public /*abstract*/ class ExecutorCollectionType extends AbstractSpecializedType implements CollectionType
{
	protected final @NonNull Type elementType;
	protected final boolean isNullFree;
	protected final @NonNull IntegerValue lower;
	protected final @NonNull UnlimitedNaturalValue upper;
	protected final @NonNull CollectionTypeId typeId;

	public ExecutorCollectionType(@NonNull String name, org.eclipse.ocl.pivot.@NonNull Class containerType,
			@NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		super(name, containerType);
		this.elementType = elementType;
		this.isNullFree = isNullFree;
		this.lower = lower != null ? lower : ValueUtil.ZERO_VALUE;
		this.upper = upper != null ? upper : ValueUtil.UNLIMITED_VALUE;
		this.typeId = IdManager.getCollectionTypeId(name).getSpecializedId(elementType.getTypeId(), isNullFree, this.lower, this.upper);
	}

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (this == type) {
			return true;
		}
		if (!(type instanceof CollectionType)) {
			return false;
		}
		return TypeUtil.conformsToCollectionType(standardLibrary, this, (CollectionType)type);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getCommonType(@NonNull IdResolver idResolver, @NonNull Type type) {
		StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		if (!(type instanceof ExecutorCollectionType)) {
			return standardLibrary.getOclAnyType();
		}
		ExecutorCollectionType thatClass = (ExecutorCollectionType) type;
		// FIXME kind
		org.eclipse.ocl.pivot.Class commonContainerClass = containerType;		// FIXME WIP
		Type commonElementClass = elementType.getCommonType(idResolver, thatClass.getElementType());
		if ((commonContainerClass == containerType) && (commonElementClass == elementType)) {
			return this;
		}
		else if ((commonContainerClass == thatClass.containerType) && (commonElementClass == thatClass.elementType)) {
			return thatClass;
		}
		else {
			boolean commonIsNullFree = this.isIsNullFree() && thatClass.isIsNullFree();
			if (commonContainerClass.isOrdered()) {
				if (commonContainerClass.isUnique()) {
					return standardLibrary.getCollectionType(standardLibrary.getOrderedSetType(), commonElementClass, commonIsNullFree, null, null);
				}
				else {
					return standardLibrary.getCollectionType(standardLibrary.getSequenceType(), commonElementClass, commonIsNullFree, null, null);
				}
			}
			else {
				if (commonContainerClass.isUnique()) {
					return standardLibrary.getCollectionType(standardLibrary.getSetType(), commonElementClass, commonIsNullFree, null, null);
				}
				else {
					return standardLibrary.getCollectionType(standardLibrary.getBagType(), commonElementClass, commonIsNullFree, null, null);
				}
			}
		}
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getContainerType() {
		return containerType;
	}

	@Override
	public @NonNull Type getElementType() {
		return elementType;
	}

	@Override
	public Number getLower() {
		return lower.asNumber();
	}

	@Override
	public @NonNull IntegerValue getLowerValue() {
		return lower;
	}

	//	@Override
	//	public @NonNull String getMetaTypeName() {
	//		return getTypeId().getCollectionTypeId().getMetaTypeName();
	//	}

	@Override
	public @NonNull List<Operation> getOwnedOperations() {
		return containerType.getOwnedOperations();
	}

	@Override
	public @NonNull CollectionTypeId getTypeId() {
		return typeId;
	}

	@Override
	public Number getUpper() {
		return upper.isUnlimited() ? Unlimited.INSTANCE : upper.intValue();
	}

	@Override
	public @NonNull UnlimitedNaturalValue getUpperValue() {
		return upper;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public String getValue() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEqualTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (this == type) {
			return true;
		}
		if (!(type instanceof CollectionType)) {
			return false;
		}
		return TypeUtil.isEqualToCollectionType(standardLibrary, this, (CollectionType)type);
	}

	@Override
	public boolean isIsNullFree() {
		return isNullFree;
	}

	@Override
	public void setElementType(Type value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsNullFree(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLower(Number value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLowerValue(@NonNull IntegerValue lower) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setUpper(Number value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setUpperValue(@NonNull UnlimitedNaturalValue upper) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
//		return String.valueOf(containerType) + "(" + String.valueOf(elementType) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		StringBuilder s = new StringBuilder();
		s.append(containerType);
		s.append("(");
		s.append(elementType.toString());
		Number lower = getLower();
		Number upper = getUpper();
		long lowerValue = lower != null ? lower.longValue() : 0l;		// FIXME Handle BigInteger
		long upperValue = (upper != null) && (upper != Unlimited.INSTANCE) ? upper.longValue() : -1l;
		if (/*SHOW_ALL_MULTIPLICITIES ||*/ (lowerValue != 0) || (upperValue != -1) || !isIsNullFree()) {
			StringUtil.appendMultiplicity(s, lowerValue, upperValue, isIsNullFree());
		}
		s.append(")");
		return s.toString();
	}
}