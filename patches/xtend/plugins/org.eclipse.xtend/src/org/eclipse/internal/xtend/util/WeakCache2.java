/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.internal.xtend.util;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A cache implementation based on WeakReferences which cleans up GCed references regularely. Originally copied from
 * {@link org.eclipse.emf.common.util.URI}' internal URICache class.
 * 
 * @param <K>
 *            Key type
 * @param <V>
 *            Value type
 */
public class WeakCache2<K, V> {

	protected Map<K, WeakReference<V>> map = new HashMap<K, WeakReference<V>>();
	private int min_limit;

	int count;
	int limit;
	long hitCount = 0;
	long totalCount = 0;

	public WeakCache2() {
		this(1000);
	}

	public WeakCache2(final int min_limit) {
		this.min_limit = min_limit;
		this.limit = this.min_limit;
	}

	public synchronized V get(final K key) {
		this.totalCount++;
		WeakReference<V> reference = this.map.get(key);
		final V result = reference == null ? null : reference.get();
		if (result != null) {
			this.hitCount++;
		}
		return result;
	}

	public synchronized void put(final K key, final V value) {
		if (key == value) {
			throw new IllegalArgumentException("Cannot use same instance as key and value, since this would prevent GC of the cache value");
		}
		this.map.put(key, new WeakReference<V>(value));
		if (++this.count > this.limit) {
			cleanGCedValues();
		}
	}

	private void cleanGCedValues() {
		for (Iterator<Map.Entry<K, WeakReference<V>>> i = this.map.entrySet().iterator(); i.hasNext();) {
			Map.Entry<K, WeakReference<V>> entry = i.next();
			WeakReference<V> reference = entry.getValue();
			if (reference.get() == null) {
				i.remove();
			}
		}
		this.count = 0;
		this.limit = Math.max(this.min_limit, this.map.size() / 2);
	}

	/**
	 * @param key
	 *            Cache key
	 * @return <code>true</code> if the cache contains an element with the given key.
	 */
	public boolean containsKey(final String key) {
		return this.map.containsKey(key);
	}

	/**
	 * @return the totalCount
	 */
	public long getTotalCount() {
		return this.totalCount;
	}

	/**
	 * @return the hitCount
	 */
	public long getHitCount() {
		return this.hitCount;
	}

	public long getMissCount() {
		return this.totalCount - this.hitCount;
	}

	public double getHitRatio() {
		return new Long(this.hitCount).doubleValue() / this.totalCount;
	}
}
