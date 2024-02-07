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
package org.eclipse.ocl.pivot.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * OclAnyEqualOperation realises the OCLAny::=() library operation and
 * regular derived implementations since the Value classes exhibit
 * OCL value semantics.
 */
public class OclAnyEqualOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull OclAnyEqualOperation INSTANCE = new OclAnyEqualOperation();

	@Override
	public @NonNull Boolean evaluate(@Nullable Object left, @Nullable Object right) {
		//
		//	A.2.2 is clear. 11.3.1 is vague.
		//
		if (left instanceof InvalidValueException) {
			throw (InvalidValueException)left;
		}
		if (right instanceof InvalidValueException) {
			throw (InvalidValueException)right;
		}
		if (left == null) {
			return right == null;
		}
		else if ((left instanceof Type) && (right instanceof Type)){
			boolean result = ((Type) left).getTypeId().equals(((Type) right).getTypeId());		// FIXME is this a sound/efficient tradeoff for not boxing?
			return result;
		}
		else {
			boolean result = left.equals(right);
			return result;
		}
	}
}
