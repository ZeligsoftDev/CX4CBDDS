/*******************************************************************************
 * Copyright (c) 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ids;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A SingletonScope maintains a set of singletons using weak references to ensure that a singleton can be
 * garbage collected once no longer in use.
 *
 * Each singleton of (interface) type T is constructed from a value of the V (interface) type.
 *
 * The identity of the singleton is determined by some or all of the value type, thus for many singletons a
 * String value provides a simple value and identity.
 *
 * However for an NsURIPackageId the value comprises nsURI, nsPrefix and EPackage although tjhe identity is
 * determined solely by the nsURI; the additional optional nsPrefix and ePackage cache related conrent;
 * the ePackage may be lazily determined from recreations of the singleton.
 *
 * For a JavaTypeId the value is a Class and the identity is the qualified class name. The same JavaTypeId
 * is shared by the same-named class loaded by diverse class loaders. This is mostly beneficial in so far
 * as the Class is used only for future execution afer code generation.
 *
 * A singleton may be located by invoking getSingeton() with the distinctive value.
 *
 * The scope is a map of singleton to singleton enabling the actual singleton to be located by a using a
 * fake singleton as the map lookup key. This requires that T.equals(that) detects an argument of type
 * Singleton.Key and inverts to invoke that.equals(this) before exploiting singeton uniqueness to return
 * this == that.
 *
 * Maintenance of singletons is probably thread safe, but not yet tested as such.
 *
 * @since 1.18
 */
public abstract class AbstractSingletonScope<@NonNull T, @NonNull V> extends WeakHashMap<@NonNull Object, @NonNull WeakReference<@Nullable T>> implements SingletonScope<T, V>
{
	protected @NonNull T getSingletonFor(@NonNull KeyAndValue<@NonNull T> key) {
		WeakReference<@Nullable T> ref = get(key);
		@Nullable T singleton = ref != null ? ref.get() : null;
		if (singleton == null) {
			synchronized (this) {
				ref = get(key);
				singleton = ref != null ? ref.get() : null;
				if (singleton == null) {
					singleton = key.createSingleton();
					put(singleton, new WeakReference<>(singleton));
				//	if (singleton.hashCode() != key.hashCode()) {
				//		singleton.hashCode();
				//		key.hashCode();
				//	}
					assert singleton.hashCode() == key.hashCode() : "Inconsistent singletonHashCode for " + singleton.getClass().getName();
					assert singleton.equals(key) : "Missing equals SingletonScope.Key support for " + singleton.getClass().getName();
				// -- redundant --	assert key.equals(key) : "Missing equals this support for " + singleton.getClass().getName();
					assert singleton.equals(singleton) : "Missing SingletonScope.Key equals this support for " + singleton.getClass().getName();
					assert key.equals(singleton) : "Inconsistent singletonEquals for " + singleton.getClass().getName();
					assert !key.equals(null) : "Missing SingletonScope.Key equals null support for " + singleton.getClass().getName();
				}
			}
		}
		return singleton;
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		boolean first = true;
		for (Object key : keySet()) {
			if (!first) {
				s.append("\n");
			}
			s.append(key);
			first = false;
		}
		return s.toString();
	}
}