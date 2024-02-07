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
package org.eclipse.ocl.pivot.library.string;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.library.AbstractSimpleTernaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * StringSubstringOperation realises the String::substring() library operation.
 */
public class StringSubstringOperation extends AbstractSimpleTernaryOperation
{
	public static final @NonNull StringSubstringOperation INSTANCE = new StringSubstringOperation();

	@Override
	public @NonNull String evaluate(@Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		String sourceString = asString(sourceValue);
		Integer startInteger = asInteger(firstArgumentValue);
		Integer endInteger = asInteger(secondArgumentValue);
		int size = sourceString.length();
		int lower = startInteger.intValue();
		int upper = endInteger.intValue();
		if ((0 < lower) && (lower <= upper) && (upper <= size)) {
			@NonNull String result = sourceString.substring(lower-1, upper);
			return result;
		}
		else {
			throw new InvalidValueException(StringUtil.bind(PivotMessages.IndexesOutOfRange, lower, upper, size));
		}
	}
}
