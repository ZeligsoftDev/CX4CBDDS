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
package org.eclipse.ocl.pivot.library;

import org.eclipse.jdt.annotation.Nullable;

/**
 * LibrarySimpleBinaryOperation extends the invocation API of a binary operation to support using just
 * <br>
 * arguments.
 */
public interface LibrarySimpleBinaryOperation extends LibraryUntypedBinaryOperation, LibrarySimpleOperation
{
	/**
	 * @since 1.1
	 */
	public interface LibrarySimpleBinaryOperationExtension
		extends LibrarySimpleBinaryOperation, LibraryUntypedBinaryOperation.LibraryUntypedBinaryOperationExtension
	{
	}
	@Nullable Object evaluate(@Nullable Object sourceValue, @Nullable Object argumentValue);
}
