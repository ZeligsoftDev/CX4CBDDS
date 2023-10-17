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
package org.eclipse.ocl.pivot.library.logical;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * BooleanXorOperation realises the Boolean::xor() library operation.
 */
public class BooleanXorOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull BooleanXorOperation INSTANCE = new BooleanXorOperation();

	@Override
	public @Nullable Boolean evaluate(@Nullable Object left, @Nullable Object right) {
		if (left instanceof InvalidValueException) {
			throw (InvalidValueException)left;
		}
		else if (right instanceof InvalidValueException) {
			throw (InvalidValueException)right;
		}
		else if ((left == null) || (right == null)) {
			return null;
		}
		else if (left == Boolean.FALSE) {
			if (right == Boolean.TRUE) {
				return TRUE_VALUE;
			}
			else if (right == Boolean.FALSE) {
				return FALSE_VALUE;
			}
		}
		else if (left == Boolean.TRUE) {
			if (right == Boolean.TRUE) {
				return FALSE_VALUE;
			}
			else if (right == Boolean.FALSE) {
				return TRUE_VALUE;
			}
		}
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.BOOLEAN_NAME, getTypeName(left));
	}
}
