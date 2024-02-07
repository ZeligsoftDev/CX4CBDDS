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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A SingletonScope maintains a set of singletons using weak references to ensure that a singleton can be
 * garbage collected once no longer in use.
 *</br>
 * Each singleton of (interface) type T is constructed from a value of the V (interface) type.
 *</br>
 * The identity of the singleton is determined by some or all of the value type, thus for many singletons a
 * String value provides a simple value and identity.
 *</br>
 * However for an NsURIPackageId, the value comprises nsURI, nsPrefix and EPackage although tjhe identity is
 * determined solely by the nsURI; the additional optional nsPrefix and ePackage cache related content.
 * The ePackage may be lazily determined from recreations of the singleton.
 *</br>
 * For a JavaTypeId, the value is a Class and the identity is the qualified class name. The same JavaTypeId
 * is shared by the same-named class loaded by diverse class loaders. This is mostly beneficial in so far
 * as the Class is used only for future execution after code generation.
 *</br>
 * A singleton may be located by invoking getSingeton() with the distinctive value.
 *</br>
 * Maintenance of singletons is probably thread safe, but not yet tested as such.
 *
 * @since 1.18
 */
public interface SingletonScope<@NonNull T, @NonNull V>
{
	/**
	 * A SingletonScope.KeyAndValue is used as the fake singleton key to lookup the actual singleton in the scope's singleton to singleton map.
	 * It therefore implements equals and hashCode to support equality with an instance of T. Conversely T must implement equals to redirect
	 * comparison with a SingletonScope.KeyAndValue to the KeyAnValue before a simple = comparison.
	 *</br>
	 * A SingletonScope.KeyAndValue is also used to create a required singleton, it therefore contains all the
	 * infprmation required for such construction.
	 */
	public static interface KeyAndValue<@NonNull T>
	{
		/**
		 * Implement to create the singleton instance from the value fields cached during construction of the derived class.
		 */
		@NonNull T createSingleton();
	}

	/**
	 * AbstractKeyAndValue provides the mandatory support for a singleton lookup fully implementing
	 * hashCode() access and forcing derived implementation of equals()
	 */
	public static abstract class AbstractKeyAndValue<@NonNull T> implements KeyAndValue<T>
	{
		protected final int hashCode;	// Primarily distinct within the SingletonScope but desirably distinct
										//  globally to allow efficint use in arbitrary sets.

		protected AbstractKeyAndValue(int hashCode) {
			this.hashCode = hashCode;	// Guaranteed to be accessed once and may be accessed again so worth caching.
		}

		@Override
		public abstract boolean equals(@Nullable Object that);	// that may be null - perhaps after GC of a key

		@Override
		public final int hashCode() {
			return hashCode;
		}
	}
}