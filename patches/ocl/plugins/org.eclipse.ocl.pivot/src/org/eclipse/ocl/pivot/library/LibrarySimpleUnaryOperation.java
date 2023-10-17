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
 * LibrarySimpleUnaryOperation extends the invocation API of a unary operation to support using just
 * <br>
 * arguments.
 */
public interface LibrarySimpleUnaryOperation extends LibraryUntypedUnaryOperation, LibrarySimpleOperation
{
	/**
	 * @since 1.1
	 */
	public interface LibrarySimpleUnaryOperationExtension extends LibrarySimpleUnaryOperation, LibraryUntypedUnaryOperation.LibraryUntypedUnaryOperationExtension, LibrarySimpleOperation
	{
	}
	@Nullable Object evaluate(@Nullable Object sourceValue);
}
