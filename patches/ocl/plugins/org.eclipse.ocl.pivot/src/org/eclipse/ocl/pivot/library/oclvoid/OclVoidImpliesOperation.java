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
package org.eclipse.ocl.pivot.library.oclvoid;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.library.AbstractSimpleBinaryOperation;

/**
 * OclVoidImpliesOperation realises the OclVoid::implies() library operation.
 */
public class OclVoidImpliesOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull OclVoidImpliesOperation INSTANCE = new OclVoidImpliesOperation();

	@Override
	public @Nullable Boolean evaluate(@Nullable Object left, @Nullable Object right) {
		if (right == TRUE_VALUE) {
			return asBoolean(right);		// Simple type cast
		}
		else {
			return asBoolean(left);			// Guaranteed exception
		}
	}
}
