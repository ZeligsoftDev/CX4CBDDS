/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.internal.xtend.util;

import java.util.IdentityHashMap;

/**
 * This cache treats keys as the same only if they are identical: (key1 == key2)
 * 
 * This cache does not store null values, which means that if createNew(key)
 * returns null for a specific key the result is not cached and createNew(key)
 * is called again every time the key's value is requested.
 * 
 * Not to cache the null-value provides the advantage that a single lookup in
 * the internal HashMap "get()" is enough to server one request. Otherwise it
 * would be necessary to do a "containsKey()" first and then the "get()" which
 * costs the time of two lookups.
 * 
 * @author Moritz Eysholdt
 * 
 * @param <K>
 *            The type for the cache's key
 * @param <V>
 *            The type for the cache's value
 */
public abstract class IdentityCacheWithoutNull<K, V> {
	protected abstract V createNew(K key);

	protected IdentityHashMap<K, V> internal = new IdentityHashMap<K, V>();

	public V get(K key) {
		final V g = internal.get(key);
		if (g != null)
			return g;
		final V n = createNew(key);
		internal.put(key, n);
		return n;
	}

}
