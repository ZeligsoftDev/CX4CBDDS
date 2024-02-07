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
import org.eclipse.ocl.pivot.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;

/**
 * StringToIntegerOperation realises the String::toInteger() library operation.
 */
public class StringToIntegerOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull StringToIntegerOperation INSTANCE = new StringToIntegerOperation();

	@Override
	public @Nullable IntegerValue evaluate(@Nullable Object sourceVal) {
		String sourceString = asString(sourceVal);
		@NonNull String result = sourceString.trim();
		try {
			return ValueUtil.integerValueOf(result);
		}
		catch (Throwable e) {
			return null;
		}
	}
}
