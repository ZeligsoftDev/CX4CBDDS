/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.classifier;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractAllInstancesOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * ClassifierAllInstancesOperation realises the Classifier::allInstances() library operation.
 */
public class ClassifierAllInstancesOperation extends AbstractAllInstancesOperation
{
	public static final @NonNull ClassifierAllInstancesOperation INSTANCE = new ClassifierAllInstancesOperation();

	/**
	 * @since 1.18
	 */
	public static @NonNull SetValue allInstances(@NonNull Executor executor, @NonNull CollectionTypeId returnTypeId, org.eclipse.ocl.pivot.@NonNull Class type) {
		ModelManager modelManager = executor.getModelManager();
		Iterable<?> instances = modelManager.getInstances(type);
		Set<Object> results = new HashSet<Object>();
		if (instances != null) {
			IdResolver idResolver = executor.getIdResolver();
			for (Object instance : instances) {
				results.add(idResolver.boxedValueOf(instance));
			}
		}
		return ValueUtil.createSetValue(returnTypeId, results);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull SetValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		org.eclipse.ocl.pivot.Class type = asClass(sourceVal);
		return type.allInstances(executor, (CollectionTypeId)returnTypeId);
	}
}
