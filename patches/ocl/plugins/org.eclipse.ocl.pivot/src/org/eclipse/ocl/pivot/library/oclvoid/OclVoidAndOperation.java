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
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * OclVoidAndOperation realises the OclVoid::and() library operation.
 */
public class OclVoidAndOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull OclVoidAndOperation INSTANCE = new OclVoidAndOperation();

	@Override
	public @Nullable Boolean evaluate(@Nullable Object left, @Nullable Object right) {
		if ((left == Boolean.FALSE) || (right == Boolean.FALSE)) {
			return FALSE_VALUE;
		}
		else if ((left == Boolean.TRUE) && (right == Boolean.TRUE)) {
			return TRUE_VALUE;
		}
		else if (left instanceof InvalidValueException) {
			throw (InvalidValueException)left;
		}
		else if (right instanceof InvalidValueException) {
			throw (InvalidValueException)right;
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.BOOLEAN_NAME, getTypeName(left));
		}
	}
}
