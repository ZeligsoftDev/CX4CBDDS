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
package org.eclipse.ocl.pivot.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * UnlimitedNaturalOclAsTypeOperation realizes the UnlimitedNatural::oclAsType() library operation.
 */
public class UnlimitedNaturalOclAsTypeOperation extends OclAnyOclAsTypeOperation
{
	public static final @NonNull UnlimitedNaturalOclAsTypeOperation INSTANCE = new UnlimitedNaturalOclAsTypeOperation();

	@Override
	public @NonNull Object evaluate(@NonNull Executor executor, @Nullable Object sourceVal, @Nullable Object argVal) {
		StandardLibrary standardLibrary = executor.getStandardLibrary();
		Type sourceType = executor.getIdResolver().getDynamicTypeOf(sourceVal);
		Type argType = asType(argVal);
		if (sourceType.conformsTo(standardLibrary, argType)) {
			if (isUnlimited(sourceVal) && ((argType == standardLibrary.getRealType()) || (argType == standardLibrary.getIntegerType()))) {
				throw new InvalidValueException(PivotMessages.NonFiniteIntegerValue);
			}
			assert sourceVal != null;
			return sourceVal;
		}
		else {
			throw new InvalidValueException(PivotMessages.IncompatibleOclAsTypeSourceType, sourceType, argType);
		}
	}
}
