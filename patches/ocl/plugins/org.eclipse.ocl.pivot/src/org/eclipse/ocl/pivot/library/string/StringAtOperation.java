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
import org.eclipse.ocl.pivot.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * StringAtOperation realises the String::at() library operation.
 */
public class StringAtOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull StringAtOperation INSTANCE = new StringAtOperation();

	@Override
	public @NonNull String evaluate(@Nullable Object left, @Nullable Object right) {
		String leftString = asString(left);
		Integer rightInteger = asInteger(right);
		int size = leftString.length();
		int index = rightInteger.intValue();
		if ((0 < index) && (index <= size)) {
			char c = leftString.charAt(index-1);
			@SuppressWarnings("null") @NonNull String result = String.valueOf(c);
			return result;
		}
		else {
			throw new InvalidValueException(PivotMessages.IndexOutOfRange, index, size);
		}
	}
}
