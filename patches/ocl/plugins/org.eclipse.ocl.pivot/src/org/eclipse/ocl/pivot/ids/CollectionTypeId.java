/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.NumberValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

/**
 * A CollectionTypeId provides a unique identifier for an unspecialized collection type such as Set(T).
 */
public interface CollectionTypeId extends BuiltInTypeId, TemplateableId
{
	@NonNull TypeId getElementTypeId();
	@Override
	@NonNull CollectionTypeId getGeneralizedId();
	/**
	 * @since 1.18
	 */
	@NonNull IntegerValue getLowerValue();
	@Override
	@NonNull String getMetaTypeName();
	@Override
	@NonNull CollectionTypeId getSpecializedId(@NonNull BindingsId templateBindings);

	@Deprecated
	default @NonNull CollectionTypeId getSpecializedId(@NonNull ElementId... templateBindings) {
		assert templateBindings.length == 1;			// Legacy compatibility
		return getSpecializedId(templateBindings[0], false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	}

	/**
	 * @since 1.18
	 */
	default @NonNull CollectionTypeId getSpecializedId(@NonNull ElementId elementId) {
		return getSpecializedId(elementId, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	}

	/**
	 * @since 1.18
	 */
	default @NonNull CollectionTypeId getSpecializedId(@NonNull ElementId elementId, boolean isNullFree, @NonNull IntegerValue lowerValue, @NonNull NumberValue upperValue) {
		@NonNull ElementId[] elementIds = new @NonNull ElementId[] {elementId};
		@NonNull Object[] values = new @NonNull Object[] {isNullFree, lowerValue, upperValue};
		BindingsId bindingsId = IdManager.getBindingsId(elementIds, values);
		return getSpecializedId(bindingsId);
	}

	/**
	 * @since 1.18
	 */
	@NonNull UnlimitedNaturalValue getUpperValue();

	/**
	 * @since 1.18
	 */
	boolean isNullFree();
}