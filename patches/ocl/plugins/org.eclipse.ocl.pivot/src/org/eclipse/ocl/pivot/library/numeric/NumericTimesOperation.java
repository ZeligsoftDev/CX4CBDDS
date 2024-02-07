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
import org.eclipse.ocl.pivot.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.pivot.values.RealValue;

/**
 * NumericTimesOperation realises the *() library operation.
 */
public class NumericTimesOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull NumericTimesOperation INSTANCE = new NumericTimesOperation();

	@Override
	public @NonNull RealValue evaluate(@Nullable Object left, @Nullable Object right) {
		RealValue leftNumeric = asRealValue(left);
		RealValue rightNumeric = asRealValue(right);
		return rightNumeric.commutatedMultiply(leftNumeric);
	}
}
