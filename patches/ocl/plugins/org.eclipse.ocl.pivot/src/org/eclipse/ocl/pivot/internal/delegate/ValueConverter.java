/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   C.Damus - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.delegate;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.values.Value;

/**
 * An object that converts values according to their declared multiplicities,
 * as collections or not.
 */
interface ValueConverter {

	ValueConverter VERBATIM = new ValueConverter() {

		@Override
		public @NonNull Object convert(@NonNull OCL ocl, @NonNull Value value) {
			return value;
		}
	};

	ValueConverter LIST = new ValueConverter() {

		@Override
		public @NonNull Object convert(@NonNull OCL ocl, @NonNull Value value) {
			Collection<?> collection = (Collection<?>) value;
			return new BasicEList.UnmodifiableEList<Object>(collection
				.size(), collection.toArray());
		}
	};

	@NonNull Object convert(@NonNull OCL ocl, @NonNull Value value);
}
