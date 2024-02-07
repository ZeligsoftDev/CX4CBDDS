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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.TupleValue;

public class TuplePartProperty extends AbstractProperty
{
	protected final @NonNull TuplePartId tuplePartId;

	public TuplePartProperty(@NonNull TuplePartId tuplePartId) {
		this.tuplePartId = tuplePartId;
	}

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		TupleValue tupleValue = asTupleValue(sourceValue);
		Object resultValue = tupleValue.getValue(tuplePartId);
		if (resultValue != null) {
			return resultValue;		// null is a static type error so no need to diagnose dynamically
		}
		throw new InvalidValueException(StringUtil.bind("part '" + tuplePartId + "' is not a part of '" + sourceValue));
	}
}