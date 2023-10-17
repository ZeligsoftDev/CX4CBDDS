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
import org.eclipse.ocl.pivot.library.AbstractSimpleTernaryOperation;

/**
 * StringSubstituteAllOperation realises the String::substituteAll() library operation.
 */
public class StringSubstituteAllOperation extends AbstractSimpleTernaryOperation
{
	public static final @NonNull StringSubstituteAllOperation INSTANCE = new StringSubstituteAllOperation();

	@Override
	public @NonNull String evaluate(@Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		String sourceString = asString(sourceValue);
		String oldSubstring = asString(firstArgumentValue);
		String newSubstring = asString(secondArgumentValue);
		@NonNull String result = sourceString.replace(oldSubstring, newSubstring);
		return result;
	}
}
