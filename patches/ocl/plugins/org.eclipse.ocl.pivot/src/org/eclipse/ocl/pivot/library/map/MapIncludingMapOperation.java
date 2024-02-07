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
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.MapTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.values.MapValue;

/**
 * MapIncludingMapOperation realises the Map::includingMap(map) library operation.
 */
public class MapIncludingMapOperation extends AbstractBinaryOperation
{
	public static final @NonNull MapIncludingMapOperation INSTANCE = new MapIncludingMapOperation();
	
	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable MapValue evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceValue, argumentValue); 
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull /*@Thrown*/ MapValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		MapValue leftMapValue = asMapValue(sourceValue);
		MapValue rightMapValue = asMapValue(argumentValue);
		return leftMapValue.includingMap((MapTypeId) returnTypeId, rightMapValue);
	}
}
