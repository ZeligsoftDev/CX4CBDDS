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
import org.eclipse.ocl.pivot.utilities.ValueUtil;

/**
 * NumericCompareToOperation realises the numeric compareTo() library operation.
 */
@Deprecated		// Use OclComparableCompareToOperation
public class NumericCompareToOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull NumericCompareToOperation INSTANCE = new NumericCompareToOperation();

	@Override
	public @NonNull Object evaluate(@Nullable Object left, @Nullable Object right) {
		if (left instanceof Comparable<?>) {
			@SuppressWarnings("unchecked") int compareTo = ((Comparable<Object>)left).compareTo(right);
			return compareTo;
		}
		else {
			@NonNull Integer valueOf = Integer.valueOf(ValueUtil.throwUnsupportedCompareTo(left, right));
			return valueOf;
		}
		//		RealValue leftNumeric = asRealValue(left);
		//		RealValue rightNumeric = asRealValue(right);
		//		return integerValueOf(leftNumeric.compareTo(rightNumeric));
	}
}
