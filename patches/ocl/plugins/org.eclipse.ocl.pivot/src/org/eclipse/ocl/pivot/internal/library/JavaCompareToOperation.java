/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library;

import java.lang.reflect.Method;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

public class JavaCompareToOperation extends AbstractSimpleBinaryOperation
{
	protected final @NonNull Method method;

	public JavaCompareToOperation(@NonNull Method method) {
		this.method = method;
	}

	@Override
	public @Nullable Object evaluate(@Nullable Object leftValue, @Nullable Object rightValue) {
		Object leftObject = asObject(leftValue);
		Object rightObject = asObject(rightValue);
		try {
			Object result = method.invoke(leftObject, rightObject);
			if (!(result instanceof Integer)) {
				throw new InvalidValueException(PivotMessages.TypedResultRequired, TypeId.INTEGER_NAME);
			}
			return ValueUtil.integerValueOf(((Integer)result).intValue());
		} catch (Exception e) {
			throw new InvalidValueException(e, PivotMessages.TypedResultRequired, TypeId.INTEGER_NAME);
		} catch (AssertionError e) {
			throw new InvalidValueException(e, PivotMessages.TypedResultRequired, TypeId.INTEGER_NAME);
		}
	}
}