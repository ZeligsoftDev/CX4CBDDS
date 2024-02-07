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

public abstract class TripleKeyCache<K1, K2, K3, V> {

	protected abstract V createNew(K1 key1, K2 key2, K3 key3);

	private final Map<Triplet<K1, K2, K3>, V> internal = new HashMap<Triplet<K1, K2, K3>, V>();

	public V get(final K1 key1, final K2 key2, final K3 key3) {
		final Triplet<K1, K2, K3> key = new Triplet<K1, K2, K3>(key1, key2, key3);

		V r = internal.get(key);
		if ((r == null) && !internal.containsKey(key)) {
			r = createNew(key1, key2, key3);
			internal.put(key, r);
		}
		return r;
	}

	public Collection<V> getValues() {
		return internal.values();
	}
}
