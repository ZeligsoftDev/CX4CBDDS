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
package org.eclipse.ocl.pivot.library.enumeration;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractAllInstancesOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * EnumerationAllInstancesOperation realises the Enumeration::allInstances() library operation.
 */
public class EnumerationAllInstancesOperation extends AbstractAllInstancesOperation
{
	@Deprecated /* @deprecated invoke the polymorphic EnumerationImpl.allInstances() */
	public static final @NonNull EnumerationAllInstancesOperation INSTANCE = new EnumerationAllInstancesOperation();

	/**
	 * @since 1.18
	 */
	public static @NonNull SetValue allInstances(@NonNull CollectionTypeId returnTypeId, @NonNull Iterable<EnumerationLiteral> literals) {
		Set<Object> results = new HashSet<Object>();
		for (EnumerationLiteral instance : literals) {
			if (instance != null) {
				results.add(instance.getEnumerationLiteralId());
			}
		}
		return ValueUtil.createSetValue(returnTypeId, results);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull SetValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		Enumeration type = (Enumeration) asClass(sourceVal);
		return allInstances((CollectionTypeId)returnTypeId, type.getOwnedLiterals());
	}
}
