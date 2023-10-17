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
import java.util.Iterator;
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.ElementId;

@Deprecated /* @deprecated no longer used - unsound see Bug 577642 */
public abstract class WeakHashMapOfWeakReference<K,V extends ElementId> extends WeakHashMap<K,WeakReference<V>>
{
	public @NonNull V getId(@NonNull K key) {
		WeakReference<V> ref = get(key);
		if (ref != null) {
			@Nullable V oldId = ref.get();
			if (oldId != null) {
				return oldId;
			}
		}
		synchronized (this) {
			ref = get(key);
			if (ref != null) {
				@Nullable V oldId = ref.get();
				if (oldId != null) {
					return oldId;
				}
			}
			V newId = newId(key);
			put(key, new WeakReference<V>(newId));
			return newId;
		}
	}

	protected abstract @NonNull V newId(@NonNull K key);

	@Override public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("{");
		Iterator<java.util.Map.Entry<K, WeakReference<V>>> i = entrySet().iterator();
		boolean hasNext = i.hasNext();
		while (hasNext) {
			java.util.Map.Entry<K, WeakReference<V>> e = i.next();
			hasNext = i.hasNext();
			WeakReference<V> ref = e.getValue();
			if (ref != null) {
				@Nullable V value = ref.get();
				if (value != null) {
					K key = e.getKey();
					if (key == this)
						buf.append("(this Map)");
					else
						buf.append(key);
					buf.append("=");
					if (value == this)
						buf.append("(this Map)");
					else
						buf.append(value);
					if (hasNext)
						buf.append(", ");
				}
			}
		}

		buf.append("}");
		return buf.toString();
	}


}