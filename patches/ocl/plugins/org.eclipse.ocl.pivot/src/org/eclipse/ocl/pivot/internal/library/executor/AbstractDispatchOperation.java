/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.pivot/model/Pivot.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.pivot.internal.library.executor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.library.AbstractOperation;

/**
 * AbstractDispatchOperation supports evaluation by virtual dispatch to the appropriate operation
 * determined by the class of the source argument.
 * @since 1.3
 */
public abstract class AbstractDispatchOperation extends AbstractEvaluationOperation
{
	/**
	 * BAD_OPERATION populates dispatch targets that fail to resolve and inhibits attempts at re-resolution.
	 */
	private static final @NonNull AbstractOperation BAD_OPERATION = new AbstractOperation()
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			return null;
		}

		@Override
		public @Nullable Object dispatch(@NonNull Executor executor, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
			return null;
		}
	};

	/**
	 * Map of target operations for each known source type. Map is populated by installed targets. Thereafter
	 * it grows lazily as the target for further types is discovered by inheritance search.
	 */
	private final @NonNull Map<@NonNull Class<?>, @NonNull AbstractOperation> class2operation = new HashMap<>();

	@Override
	public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
		Object source = sourceAndArgumentValues[0];
		if (source == null) {
			return null;
		}
		Class<?> jClass = source.getClass();
		AbstractOperation abstractOperation = class2operation.get(jClass);
		if (abstractOperation == null) {
			abstractOperation = resolve(jClass);
			if (abstractOperation == null) {
				abstractOperation = BAD_OPERATION;
				class2operation.put(jClass, abstractOperation);
			}
			assert class2operation.get(jClass) == abstractOperation;
		}
		return abstractOperation.basicEvaluate(executor, caller, sourceAndArgumentValues);
	}

	protected void install(@NonNull Class<?> jClass, @NonNull AbstractOperation operation) {
		class2operation.put(jClass, operation);
	}

	private @Nullable AbstractOperation resolve(@NonNull Class<?> jClass) {
		for (Class<?> jInterface : jClass.getInterfaces()) { // Interfaces first supports EMF's Impl registered as non-Impl
			assert jInterface != null;
			AbstractOperation abstractOperation = class2operation.get(jInterface);
			if (abstractOperation != null) {
				class2operation.put(jClass, abstractOperation);
				return abstractOperation;
			}
			abstractOperation = resolve(jInterface);
			if (abstractOperation != null) {
				class2operation.put(jClass, abstractOperation);
				return abstractOperation;
			}
		}
		Class<?> jSuperclass = jClass.getSuperclass();
		if (jSuperclass != null) {
			AbstractOperation abstractOperation = class2operation.get(jSuperclass);
			if (abstractOperation != null) {
				class2operation.put(jClass, abstractOperation);
				return abstractOperation;
			}
			abstractOperation = resolve(jSuperclass);
			if (abstractOperation != null) {
				class2operation.put(jClass, abstractOperation);
				return abstractOperation;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		List<@NonNull Class<?>> keys = new ArrayList<>(class2operation.keySet());
		Collections.sort(keys, new Comparator<@NonNull Class<?>>()
		{
			@Override
			public int compare(@NonNull Class<?> o1, @NonNull Class<?> o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		StringBuilder s = new StringBuilder();
		for (@NonNull Class<?> key : keys) {
			s.append(key + " => " + class2operation.get(key) + "\n");
		}
		return s.toString();
	}
}
