/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.string;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;

/**
 * StringLastIndexOfOperation realises the String::lastIndexOf() library operation.
 */
public class StringLastIndexOfOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull StringLastIndexOfOperation INSTANCE = new StringLastIndexOfOperation();

	@Override
	public @NonNull IntegerValue evaluate(@Nullable Object left, @Nullable Object right) {
		String leftString = asString(left);
		String rightString = asString(right);
		/*if (leftString.length() <= 0) {
			return ValuesUtil.integerValueOf(0);
		}
		else*/ if (rightString.length() <= 0) {
			return ValueUtil.integerValueOf(leftString.length()+1);
		}
		else {
			int index = leftString.lastIndexOf(rightString);
			if (index >= 0) {
				return ValueUtil.integerValueOf(index+1);
			}
			else {
				return ValueUtil.integerValueOf(0);
			}
		}
	}
}
