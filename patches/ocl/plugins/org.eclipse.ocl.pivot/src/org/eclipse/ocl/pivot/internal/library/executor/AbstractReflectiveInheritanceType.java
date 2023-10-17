/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.executor;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.values.OCLValue;

public abstract class AbstractReflectiveInheritanceType extends ReflectiveInheritance implements org.eclipse.ocl.pivot.Class
{
	public AbstractReflectiveInheritanceType(@NonNull String name, int flags) {
		super(name, flags);
	}

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		CompleteInheritance thatInheritance = type.getInheritance(standardLibrary);
		if (this == thatInheritance) {
			return true;
		}
		return thatInheritance.isSuperInheritanceOf(this);
	}

	@Override
	public org.eclipse.ocl.pivot.Class flattenedType() {
		return this;
	}

	@Override
	public @NonNull CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary) {
		return this;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getNormalizedType(@NonNull StandardLibrary standardLibrary) {
		return getPivotClass();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class isClass() {
		return getPivotClass();
	}

	@Override
	public boolean isEqualTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		return getPivotClass() == type;
	}

	@Override
	public boolean isEqualToUnspecializedType(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		return getPivotClass() == type;
	}

	@Override
	public @Nullable TemplateParameter isTemplateParameter() {
		return null;
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
	public boolean validateNameIsNotNull(DiagnosticChain diagnostics, Map<Object, Object> context) {
		throw new UnsupportedOperationException();
	}
}