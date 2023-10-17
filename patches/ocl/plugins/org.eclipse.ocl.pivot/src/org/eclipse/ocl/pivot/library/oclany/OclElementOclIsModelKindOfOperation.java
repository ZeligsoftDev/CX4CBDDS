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
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.library.AbstractUntypedBinaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * OclElementOclIsModelKindOfOperation realises the OclElement::oclIsModelKindOf() library operation.
 * 
 * @since 1.1
 */
public class OclElementOclIsModelKindOfOperation extends AbstractUntypedBinaryOperation
{
	public static final @NonNull OclElementOclIsModelKindOfOperation INSTANCE = new OclElementOclIsModelKindOfOperation();

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull Boolean evaluate(@NonNull Executor executor, @Nullable Object sourceVal, @Nullable Object argVal) {
		if (sourceVal instanceof InvalidValueException) {
			throw (InvalidValueException)sourceVal;
		}
		Type argType = asType(argVal);
		Type sourceType = executor.getIdResolver().getDynamicTypeOf(sourceVal);
		if (sourceVal == null) {
			throw new InvalidValueException(PivotMessages.NullNavigation, "source value", "oclIsModelKindOf");
		}
		Iterable<org.eclipse.ocl.pivot.@NonNull Class> modelClasses = ((IdResolver.IdResolverExtension)executor.getIdResolver()).getModelClassesOf(sourceVal);
		if (modelClasses == null) {
			throw new InvalidValueException(PivotMessages.IncompatibleModelType, sourceType);
		}
		StandardLibrary standardLibrary = executor.getStandardLibrary();
		Type bestModelType = null;
		for (org.eclipse.ocl.pivot.@NonNull Class modelClass : modelClasses) {
			if (modelClass.conformsTo(standardLibrary, argType)) {
				if (bestModelType == null) {
					bestModelType = modelClass;
				}
				else {
					throw new InvalidValueException(PivotMessages.AmbiguousModelType, bestModelType, modelClass, sourceType);
				}
			}
		}
		return bestModelType != null;
	}
}
