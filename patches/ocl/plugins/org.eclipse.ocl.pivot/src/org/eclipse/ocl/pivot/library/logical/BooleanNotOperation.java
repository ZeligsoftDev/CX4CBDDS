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
import org.eclipse.ocl.pivot.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * NotOperation realises the not() library operation.
 */
public class BooleanNotOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull BooleanNotOperation INSTANCE = new BooleanNotOperation();

	@Override
	public @Nullable Boolean evaluate(@Nullable Object argument) {
		if (argument == Boolean.FALSE) {
			return TRUE_VALUE;
		}
		else if (argument == Boolean.TRUE) {
			return FALSE_VALUE;
		}
		if (argument == null) {
			return null;
		}
		else if (argument instanceof InvalidValueException) {
			throw (InvalidValueException)argument;
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.BOOLEAN_NAME, getTypeName(argument));
		}
	}
}
