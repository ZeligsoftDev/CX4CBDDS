/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.ids.BindingsId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

public class SpecializedCollectionTypeIdImpl extends AbstractSpecializedIdImpl<CollectionTypeId> implements CollectionTypeId
{
	public SpecializedCollectionTypeIdImpl(@NonNull CollectionTypeId generalizedId, @NonNull BindingsId templateBindings) {
		super(generalizedId, templateBindings);
		assert templateBindings.elementIdSize() == 1;
		assert templateBindings.valuesSize() == 3;
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitCollectionTypeId(this);
	}

	@Override
	protected @NonNull CollectionTypeId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedCollectionTypeIdImpl(this, templateBindings);
	}

	@Override
	public @NonNull TypeId getElementTypeId() {
		return (TypeId)templateBindings.getElementId(0);
	}

	@Override
	public @NonNull IntegerValue getLowerValue() {
		return (IntegerValue)templateBindings.getValue(2);
	}

	@Override
	public @NonNull UnlimitedNaturalValue getUpperValue() {
		return (UnlimitedNaturalValue)templateBindings.getValue(3);
	}

	@Override
	public boolean isNullFree() {
		return (boolean)templateBindings.getValue(1);
	}

	/**
	 * @since 1.7
	 */
	@Override
	public boolean isTemplated() {
		return true;
	}

	@Override
	public @NonNull CollectionTypeId specialize(@NonNull BindingsId templateBindings) {
		return createSpecializedId(templateBindings);
	}
}