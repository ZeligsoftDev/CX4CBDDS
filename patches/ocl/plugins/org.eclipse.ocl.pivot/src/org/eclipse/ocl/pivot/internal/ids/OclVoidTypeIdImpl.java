/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ids.BindingsId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.OclVoidTypeId;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

public class OclVoidTypeIdImpl extends UnscopedId implements OclVoidTypeId
{
	public OclVoidTypeIdImpl(@NonNull String name) {
		super(name);
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitNullId(this);
	}

	public @NonNull CollectionTypeId getCollectedTypeId() {
		return this;
	}

	public @NonNull TypeId getElementId() {
		return this;
	}

	@Override
	public @NonNull TypeId getElementTypeId() {
		return this;
	}

	@Override
	public @NonNull OclVoidTypeIdImpl getGeneralizedId() {
		return this;
	}

	@Override
	public int getIndex() {
		return 0;
	}

	@Override
	public @Nullable String getLiteralName() {
		if (this == TypeId.OCL_ANY) {
			return "OCL_ANY";
		}
		else {
			return "OCL_VOID";
		}
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return TypeId.VOID_TYPE_NAME;
	}

	public @Nullable Element getOrigin() {
		return null;
	}

	public @NonNull TypeId getParent() {
		return this;									// FIXME Is this safe?
	}

	@Override
	public TuplePartId getPartId(@NonNull String name) {
		return null;
	}

	@Override
	public @NonNull TuplePartId @NonNull [] getPartIds() {
		return NULL_TUPLE_PART_ID_ARRAY;
	}

	@Override
	public @NonNull OclVoidTypeIdImpl getSpecializedId(@NonNull BindingsId templateBindings) {
		return this;
	}

	@Override
	public @NonNull CollectionTypeId getSpecializedId(@NonNull ElementId... templateBindings) {
		return this;
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull TemplateParameterId getTemplateParameterId(int index, @NonNull String name) {
		return this;
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull IntegerValue getLowerValue() {
		return ValueUtil.ZERO_VALUE;
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull UnlimitedNaturalValue getUpperValue() {
		return ValueUtil.UNLIMITED_VALUE;
	}

	/**
	 * @since 1.18
	 */
	@Override
	public boolean isNullFree() {
		return false;
	}
}