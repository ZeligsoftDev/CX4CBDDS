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
import org.eclipse.ocl.pivot.ids.BindingsId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdHash;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.SingletonScope;
import org.eclipse.ocl.pivot.ids.SingletonScope.AbstractKeyAndValue;

/**
 * BindingsIdImpl provides a hashable list of elementIds suitable for use when indexing specializations.
 */
public class BindingsIdImpl implements BindingsId, WeakHashMapOfListOfWeakReference2.MatchableId<@NonNull ElementId @NonNull []>
{
	@Deprecated /* @deprecated no longer used */
	protected class Iterator implements java.util.Iterator<@NonNull ElementId>
	{
		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < elementIds.length;
		}

		@Override
		public @NonNull ElementId next() {
			return elementIds[index++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private static class BindingsIdValue extends AbstractKeyAndValue<@NonNull BindingsId>
	{
		private final @NonNull IdManager idManager;
		private @NonNull ElementId @NonNull [] elements;
		private @NonNull Object @Nullable [] values;

		private BindingsIdValue(@NonNull IdManager idManager, @NonNull ElementId @NonNull [] elements, @NonNull Object @Nullable [] values) {
			super(BindingsIdImpl.computeHashCode(elements, values));
			this.idManager = idManager;
			this.elements = elements;
			this.values = values;
		}

		@Override
		public @NonNull BindingsId createSingleton() {
			return new BindingsIdImpl(idManager, elements, values);
		}

		@Override
		public boolean equals(@Nullable Object that) {
			if (that instanceof BindingsIdImpl) {
				BindingsIdImpl singleton = (BindingsIdImpl)that;
				return singleton.matches(elements, values);
			}
			else {
				return false;
			}
		}
	}

	/**
	 * @since 1.18
	 */
	public static class BindingsIdSingletonScope extends AbstractSingletonScope<@NonNull BindingsId, @NonNull ElementId @NonNull []>
	{
		public @NonNull BindingsId getSingleton(@NonNull IdManager idManager, @NonNull ElementId @NonNull [] elements, @NonNull Object @Nullable [] values) {
			return getSingletonFor(new BindingsIdValue(idManager, elements, values));
		}
	}

	private static int computeHashCode(@NonNull ElementId @NonNull [] elementIds, @NonNull Object @Nullable [] values) {
		return IdHash.createParametersHash(BindingsId.class, elementIds, values);
	}

	private final @NonNull ElementId @NonNull [] elementIds;
	private final @NonNull Object @Nullable [] values;
	private final @NonNull Integer hashCode;

	/**
	 * Construct a BindingsId for an idManager that has computed the hashCode for the typeIds.
	 */
	@Deprecated /* @deprecated no longer used */
	public BindingsIdImpl(@NonNull IdManager idManager, @NonNull Integer hashCode, @NonNull ElementId @NonNull [] elementIds) {
		this.hashCode = hashCode;
		this.elementIds = elementIds;
		this.values = null;
		assert hashCode == this.hashCode;
	}

	private BindingsIdImpl(@NonNull IdManager idManager, @NonNull ElementId @NonNull [] elementIds, @NonNull Object @Nullable [] values) {
		this.hashCode = computeHashCode(elementIds, values);
		this.elementIds = elementIds;
		this.values = values;
	}

	@Override
	public int elementIdSize() {
		return elementIds.length;
	}

	@Override
	public final boolean equals(Object that) {
		if (that instanceof SingletonScope.KeyAndValue) {	// A SingletonScope.Key may be used to lookup a singleton
			return that.equals(this);
		}
		else {										// But normally ElementId instances are singletons
			return this == that;
		}
	}

	@Override @Deprecated /* @deprecated use getElementId() and/or getValue() */
	public @NonNull ElementId get(int i) {
		return getElementId(i);
	}

	@Override
	public @NonNull ElementId getElementId(int i) {
		return elementIds[i];
	}

	@Override
	public @NonNull Object getValue(int i) {
		assert values != null;
		return values[i];
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override @Deprecated /* @deprecated use elementIdSize()/getElementId() and/or valuesSize()/getValue() */
	public java.util.@NonNull Iterator<@NonNull ElementId> iterator() {
		return new Iterator();
	}

	@Override @Deprecated
	public boolean matches(@NonNull ElementId @NonNull [] value) {
		throw new UnsupportedOperationException();			// Only here for API compatibility
	}

	private boolean matches(@NonNull ElementId @NonNull [] thoseElementIds, @NonNull Object @Nullable [] thoseValues) {
		if (elementIds.length != thoseElementIds.length) {
			return false;
		}
		for (int i = 0; i < elementIds.length; i++) {
			if (elementIds[i] != thoseElementIds[i]) {
				return false;
			}
		}
		@NonNull Object[] theseValues = values;
		if ((theseValues != null) != (thoseValues != null)) {
			return false;
		}
		if (theseValues != null) {
			assert thoseValues != null;
			int length = theseValues.length;
			if (length != thoseValues.length) {
				return false;
			}
			for (int i = 0; i < length; i++) {
				Object thisValue = theseValues[i];
				Object thatValue = thoseValues[i];
				if (thisValue == thatValue) {
					continue;
				}
				if (!thisValue.equals(thatValue)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override @Deprecated /* @deprecated use elementIdSize() and/or valuesSize() */
	public int size() {
		return elementIdSize();
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append('(');
		for (int i = 0; i < elementIds.length; i++) {
			if (i > 0) {
				s.append(',');
			}
			s.append(String.valueOf(elementIds[i]));
		}
		@NonNull Object[] values2 = values;
		if (values2 != null) {
			for (int i = 0; i < values2.length; i++) {
			//	if (i > 0) {
					s.append(',');
			//	}
				s.append(String.valueOf(values2[i]));
			}
		}
		s.append(')');
		return s.toString();
	}

	@Override
	public int valuesSize() {
		@NonNull Object[] values2 = values;
		return values2 != null ? values2.length : 0;
	}
}
