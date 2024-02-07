/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ids;

import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.IndexableIterable;

/**
 * BindingsId provides a hashable list of Class-typed elementIds and/or DataType-typed values that parameterize a template specialization.
 */
public interface BindingsId extends IndexableIterable<@NonNull ElementId>	// Use of IndexableIterable is deprecated
{
	/**
	 * @since 1.18
	 */
	int elementIdSize();
	@Override @Deprecated
	@NonNull ElementId get(int index);
	/**
	 * @since 1.18
	 */
	@NonNull ElementId getElementId(int i);
	/**
	 * @since 1.18
	 */
	@NonNull Object getValue(int i);
	@Override @Deprecated
	@NonNull Iterator<@NonNull ElementId> iterator();
	@Override @Deprecated
	int size();
	/**
	 * @since 1.18
	 */
	int valuesSize();
}
