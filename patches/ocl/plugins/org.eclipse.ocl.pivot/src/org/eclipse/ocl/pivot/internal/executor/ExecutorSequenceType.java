/*******************************************************************************
 * Copyright (c) 2022 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

/**
 * @since 1.18
 */
public class ExecutorSequenceType extends ExecutorCollectionType implements SequenceType
{
	public ExecutorSequenceType(@NonNull String name, org.eclipse.ocl.pivot.@NonNull Class containerType,
			@NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		super(name, containerType, elementType, isNullFree, lower, upper);
	}
}