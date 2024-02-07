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
package org.eclipse.ocl.pivot.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.RealValue;

/**
 * NumericFloorOperation realises the floor() library operation.
 */
public class NumericFloorOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull NumericFloorOperation INSTANCE = new NumericFloorOperation();

	@Override
	public @NonNull IntegerValue evaluate(@Nullable Object sourceVal) {
		RealValue numericValue = asRealValue(sourceVal); 
		return numericValue.floor();
	}
}
