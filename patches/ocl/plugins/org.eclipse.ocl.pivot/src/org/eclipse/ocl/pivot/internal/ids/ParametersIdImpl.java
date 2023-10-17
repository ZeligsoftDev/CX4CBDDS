/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.AbstractSingletonScope;
import org.eclipse.ocl.pivot.ids.IdHash;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.SingletonScope;
import org.eclipse.ocl.pivot.ids.SingletonScope.AbstractKeyAndValue;
import org.eclipse.ocl.pivot.ids.TypeId;

/**
 * ParametersId provides a hashed list of typeIds suitable for characterizing an operation signature.
 * parameter ids suitable for use when indexing operation overloads.
 */
public class ParametersIdImpl implements ParametersId, WeakHashMapOfListOfWeakReference2.MatchableId<@NonNull TypeId @NonNull []>
{
	protected class Iterator implements java.util.Iterator<@NonNull TypeId>
	{
		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < typeIds.length;
		}

		@Override
		public @NonNull TypeId next() {
			return typeIds[index++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private static class ParametersIdValue extends AbstractKeyAndValue<@NonNull ParametersId>
	{
		private final @NonNull IdManager idManager;
		private final @NonNull TypeId @NonNull [] value;

		private ParametersIdValue(@NonNull IdManager idManager, @NonNull TypeId @NonNull [] value) {
			super(computeHashCode(value));
			this.idManager = idManager;
			this.value = value;
		}

		@Override
		public @NonNull ParametersId createSingleton() {
			return new ParametersIdImpl(idManager, value);
		}

		@Override
		public boolean equals(@Nullable Object that) {
			if (that instanceof ParametersIdImpl) {
				ParametersIdImpl singleton = (ParametersIdImpl)that;
				return computeEquals(singleton.typeIds, value);
			}
			else {
				return false;
			}
		}
	}

	/**
	 * @since 1.18
	 */
	public static class ParametersIdSingletonScope extends AbstractSingletonScope<@NonNull ParametersId, @NonNull TypeId @NonNull []>
	{
		public @NonNull ParametersId getSingleton(@NonNull IdManager idManager, @NonNull TypeId @NonNull [] value) {
			return getSingletonFor(new ParametersIdValue(idManager, value));
		}
	}

	private static boolean computeEquals(@NonNull TypeId @NonNull [] theseTypeIds, @NonNull TypeId @NonNull [] thoseTypeIds) {
		if (theseTypeIds.length != thoseTypeIds.length) {
			return false;
		}
		for (int i = 0; i < theseTypeIds.length; i++) {
			if (theseTypeIds[i] != thoseTypeIds[i]) {
				return false;
			}
		}
		return true;
	}

	private static int computeHashCode(@NonNull TypeId @NonNull [] typeIds) {
		return IdHash.createParametersHash(ParametersIdImpl.class, typeIds, null);
	}

	private final int hashCode;
	private final @NonNull TypeId @NonNull [] typeIds;

	/**
	 * Construct a ParametersId for an idManager that has computed the hashCode for the typeIds.
	 */
	@Deprecated /* @deprecated hashCode is redundant */
	public ParametersIdImpl(@NonNull IdManager idManager, @NonNull Integer hashCode, @NonNull TypeId @NonNull [] typeIds) {
		this(idManager, typeIds);
		assert this.hashCode == hashCode;
	}

	/**
	 * @since 1.18
	 */
	public ParametersIdImpl(@NonNull IdManager idManager, @NonNull TypeId @NonNull [] typeIds) {
		this.hashCode = computeHashCode(typeIds);
		this.typeIds = typeIds;
	}

	@Override
	public final boolean equals(Object that) {
		if (that instanceof SingletonScope.KeyAndValue) {			// A SingletonScope.Key may be used to lookup a ParametersId
			return that.equals(this);
		}
		else {												// But normally ParametersId instances are singletons
			return this == that;
		}
	}

	@Override
	public @NonNull TypeId get(int index) {
		return typeIds[index];
	}

	public @NonNull TypeId @NonNull [] get() {
		return typeIds;
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
	public java.util.@NonNull Iterator<@NonNull TypeId> iterator() {
		return new Iterator();
	}

	@Override
	public boolean matches(@NonNull TypeId @NonNull [] thoseTypeIds) {
		return computeEquals(typeIds, thoseTypeIds);
	}

	@Override
	public int size() {
		return typeIds.length;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append('(');
		for (int i = 0; i < typeIds.length; i++) {
			if (i > 0) {
				s.append(',');
			}
			TypeId typeId = typeIds[i];
			@SuppressWarnings("null")boolean isNonNull = typeId != null;			// Never happens NE guard
			s.append(isNonNull ? typeId.toString() : "null");
		}
		s.append(')');
		return s.toString();
	}
}