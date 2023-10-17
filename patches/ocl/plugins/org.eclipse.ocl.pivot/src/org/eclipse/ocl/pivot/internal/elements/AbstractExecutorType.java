/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.elements;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.InheritanceFragment;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.types.AbstractInheritance;
import org.eclipse.ocl.pivot.utilities.IndexableIterable;
import org.eclipse.ocl.pivot.values.OCLValue;

public class AbstractExecutorType extends AbstractInheritance implements Type
{
	public AbstractExecutorType(@NonNull String name, int flags) {
		super(name, flags);
	}

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type thatType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Type flattenedType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Iterable<@NonNull InheritanceFragment> getAllProperSuperFragments() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Iterable<@NonNull InheritanceFragment> getAllSuperFragments() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Type getCommonType(@NonNull IdResolver idResolver, @NonNull Type thatType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getDepth() {
		throw new UnsupportedOperationException();
	}

	@Override

	public @NonNull Iterable<@NonNull InheritanceFragment> getFragments() {
		throw new UnsupportedOperationException();
	}

	@Override
	public InheritanceFragment getFragment(int fragmentNumber) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getIndex(int fragmentNumber) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getIndexes() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CompleteInheritance getInheritance( @NonNull StandardLibrary standardLibrary) {
		//		return standardLibrary.getInheritance(this);
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Operation getMemberOperation(@NonNull OperationId id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Property getMemberProperty(@NonNull String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getNormalizedType( @NonNull StandardLibrary standardLibrary) {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getPivotClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull InheritanceFragment getSelfFragment() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull IndexableIterable<@NonNull InheritanceFragment> getSuperFragments(int depth) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull TypeId getTypeId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.@Nullable Class isClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEqualTo(@NonNull StandardLibrary standardLibrary, @NonNull Type thatType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEqualToUnspecializedType(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable TemplateParameter isTemplateParameter() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean oclEquals(@NonNull OCLValue thatValue) {
		if (!(thatValue instanceof Type)) {
			return false;
		}
		TypeId thisTypeId = getTypeId();
		TypeId thatTypeId = ((Type)thatValue).getTypeId();
		return thisTypeId.equals(thatTypeId);
	}

	@Override
	public int oclHashCode() {
		return getTypeId().hashCode();
	}

	@Override
	public Type specializeIn(CallExp expr, Type selfType) {
		throw new UnsupportedOperationException();
	}
}