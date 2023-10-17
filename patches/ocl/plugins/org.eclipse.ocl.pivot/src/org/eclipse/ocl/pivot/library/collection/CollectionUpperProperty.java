/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

/**
 * CollectionUpperProperty realizes the Collection::upper() library property.
 */
public class CollectionUpperProperty extends AbstractProperty
{
	public static final @NonNull CollectionUpperProperty INSTANCE = new CollectionUpperProperty();

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable UnlimitedNaturalValue evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceValue);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull UnlimitedNaturalValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		if (sourceValue instanceof CollectionValue) {				// Legacy compatibility.
			CollectionValue collectionValue = asCollectionValue(sourceValue);
			assert false: "Use CollectionType.getUpperValue() directly";
			CollectionTypeId collectionTypeId = collectionValue.getTypeId();
			IdResolver idResolver = executor.getIdResolver();
			CollectionType collectionType = (CollectionType) idResolver.getType(collectionTypeId);
			return collectionType.getUpperValue();
		}
		CollectionType collectionType = asCollectionType(sourceValue);
		return collectionType.getUpperValue();
	}
}
