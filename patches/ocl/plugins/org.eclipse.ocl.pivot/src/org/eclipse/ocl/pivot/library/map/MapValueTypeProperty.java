/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.MapTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.MapValue;

/**
 * MapValueTypeProperty realizes the Map::valueType library property.
 */
public class MapValueTypeProperty extends AbstractProperty
{
	public static final @NonNull MapValueTypeProperty INSTANCE = new MapValueTypeProperty();

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable Type evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceValue);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull Type evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		if (sourceValue instanceof MapValue) {				// Legacy compatibility.
			MapValue mapValue = asMapValue(sourceValue);
			assert false: "Use MapType.getValueType() directly";
			MapTypeId mapTypeId = mapValue.getTypeId();
			TypeId valueTypeId = mapTypeId.getValueTypeId();
			IdResolver idResolver = executor.getIdResolver();
			return idResolver.getType(valueTypeId);
		}
		MapType mapType = asMapType(sourceValue);
		return PivotUtil.getValueType(mapType);
	}
}
