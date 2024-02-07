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
package org.eclipse.ocl.pivot.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;

/**
 * OclComparableCompareToOperation realizes the abstract compareTo library operation using intrinsic Java functionality.
 */
public class OclComparableCompareToOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull OclComparableCompareToOperation INSTANCE = new OclComparableCompareToOperation();

	@Override
	public @NonNull IntegerValue evaluate(@Nullable Object left, @Nullable Object right) {
		if (left instanceof Comparable<?>) {
			@SuppressWarnings("unchecked") int compareTo = ((Comparable<Object>)left).compareTo(right);
			return integerValueOf(compareTo);
		}
		else {
			return integerValueOf(ValueUtil.throwUnsupportedCompareTo(left, right));
		}
	}
}
