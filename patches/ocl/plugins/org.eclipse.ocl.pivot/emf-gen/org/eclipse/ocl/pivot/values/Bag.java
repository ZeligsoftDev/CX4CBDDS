/*******************************************************************************
 * Copyright (c) 2010, 2020 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.values;

import java.util.Collection;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A bag is a collection that is non-unique and unordered.  It is, therefore,
 * like a set except that any element may occur multiple times.
 *
 * @author Christian W. Damus (cdamus)
 */
public interface Bag<E> extends Collection<E>
{
	/**
	 * @since 1.3
	 */
	public interface Internal<E> extends Bag<E>
	{
		/**
		 * Return the internal map of distinct object to count of that object.
		 */
		@NonNull Map<E, ? extends Number> getMap();
	}

	/**
	 * Queries how many times the specified object occurs in me.
	 * If I do not contain the object, then the count is zero.
	 *
	 * @param o an object
	 * @return the number of times that it occurs in me
	 */
	int count(Object o);
}
