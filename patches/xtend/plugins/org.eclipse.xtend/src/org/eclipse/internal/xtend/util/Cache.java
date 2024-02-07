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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class Cache<K, V> {

	protected abstract V createNew(K arg0);

	protected Map<K, V> internal = new HashMap<K, V>();

	public V get(final K key) {
		V r = internal.get(key);
		if ((r == null) && !internal.containsKey(key)) {
			r = createNew(key);
			internal.put(key, r);
		}
		return r;
	}

	public Collection<V> getValues() {
		return internal.values();
	}

	/**
	 * Clears the cache.
	 * 
	 * @since 4.2
	 */
	public void clear() {
		internal.clear();
	}

	/**
	 * @return
	 * @see java.util.Map#isEmpty()
	 */
	public boolean isEmpty() {
		return internal.isEmpty();
	}

}