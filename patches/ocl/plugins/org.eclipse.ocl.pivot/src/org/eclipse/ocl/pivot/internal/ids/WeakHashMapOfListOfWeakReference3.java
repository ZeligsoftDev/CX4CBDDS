/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ids;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

@Deprecated /* @deprecated no longer used */
public abstract class WeakHashMapOfListOfWeakReference3<K1, K2, K3, V extends WeakHashMapOfListOfWeakReference3.MatchableId<K2, K3>> extends WeakHashMap<K1,List<WeakReference<V>>>
{
	public static interface MatchableId<K2, K3>
	{
		boolean matches(@NonNull K2 key2, @NonNull K3 key3);
	}

	public synchronized @NonNull V getId(@NonNull K1 key1, @NonNull K2 key2, @NonNull K3 key3) {
		List<WeakReference<V>> ids = get(key1);
		if (ids == null) {
			ids = new ArrayList<WeakReference<V>>();
			put(key1, ids);
		}
		for (WeakReference<V> ref : ids) {
			@Nullable V oldId = ref.get();
			if (oldId != null) {
				if (oldId.matches(key2, key3)) {
					return oldId;
				}
			}
		}
		V newId = newId(key1, key2, key3);
		ids.add(new WeakReference<V>(newId));
		return newId;
	}

	protected abstract @NonNull V newId(@NonNull K1 key1, @NonNull K2 key2, @NonNull K3 key3);
}