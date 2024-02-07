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

/**
 * StringStartsWithOperation realises the String::startsWith() library operation.
 */
public class StringStartsWithOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull StringStartsWithOperation INSTANCE = new StringStartsWithOperation();

	@Override
	public @NonNull Boolean evaluate(@Nullable Object left, @Nullable Object right) {
		String leftString = asString(left);
		String rightString = asString(right);
		boolean result = leftString.startsWith(rightString);
		return result;
	}
}
