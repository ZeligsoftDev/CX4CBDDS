/*******************************************************************************
 * Copyright (c) 2010, 2020 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   E.D.Willink - Polish
 *******************************************************************************/

package org.eclipse.ocl.pivot.internal.values;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.Bag;

/**
 * Default implementation of the {@link Bag} interface.
 *
 * The implementation is optimized for populate then use. Map entries returned while populating may be stale by the time
 * subsequent usage occurs.
 *
 * @generated NOT
 */
public class BagImpl<E> extends AbstractCollection<E> implements Bag.Internal<E>
{
	/**
	 * BagIterator iterates over the Bag content returning each multiple element multiple times.
	 */
	private static class BagIterator<E> implements Iterator<E>
	{
		private final @NonNull Map<E, @NonNull ElementCounter> map;
		private final @NonNull Iterator<E> objectIterator;
		private E currentObject;
		private int residualCount;

		private BagIterator(@NonNull Map<E, @NonNull ElementCounter> map, @NonNull Iterator<E> objectIterator) {
			this.map = map;
			this.objectIterator = objectIterator;
			assert objectIterator.hasNext();
			currentObject = objectIterator.next();
			ElementCounter count = map.get(currentObject);
			assert count != null;
			residualCount = count.intValue();
		}

		@Override
		public boolean hasNext() {
			return residualCount > 0;
		}

		@Override
		public E next() {
			if (residualCount <= 0) {
				throw new NoSuchElementException();
			}
			if (--residualCount > 0) {
				return currentObject;
			}
			if (objectIterator.hasNext()) {
				E savedObject = currentObject;
				currentObject = objectIterator.next();
				ElementCounter count = map.get(currentObject);
				assert count != null;
				residualCount = count.intValue();
				return savedObject;
			}
			else {
				residualCount = 0;
				return currentObject;
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove not supported by OCL collections");	// Unimplemented optional operation
		}
	}

	/**
	 * ElementCounter is used as the count of a Bag element. It avoids thrashing Integer objects as counts evolve.
	 */
	private static class ElementCounter extends Number
	{
		private static final long serialVersionUID = -4943324197108585350L;

		private int value = 1;

		@Override
		public double doubleValue() {
			return value;
		}

		@Override
		public boolean equals(Object thatElement) {
			if (thatElement == this) {
				return true;
			}
			if (!(thatElement instanceof Number)) {
				return false;
			}
			return value == ((Number)thatElement).intValue();
		}

		@Override
		public float floatValue() {
			return value;
		}

		@Override
		public int hashCode() {
			return value;
		}

		@Override
		public int intValue() {
			return value;
		}

		@Override
		public long longValue() {
			return value;
		}

		@Override
		public String toString() {
			return Integer.toString(value);
		}
	}

	@SuppressWarnings("unchecked")
	public static <E> Bag<E> emptyBag() {
		return (Bag<E>) ValueUtil.EMPTY_BAG;
	}

	private final @NonNull Map<E, @NonNull ElementCounter> map = new HashMap<>();
	private int size = 0;
	private @Nullable Integer hashCode = null;

	/**
	 * The need for put-after-get is avoided by always putting. A previous value therefore goes stale and is
	 * maintinaed for re-use s the spareCounter.
	 */
	private @Nullable ElementCounter spareCounter = null;

	public BagImpl() {}

	/**
	 * @since 1.3
	 */
	public BagImpl(@NonNull Iterable<? extends E> someElements) {
		for (E anElement : someElements) {
			add(anElement);
		}
	}

	/* @deprecated retained only for API compatibility */
	@Deprecated
	public BagImpl(@NonNull Collection<? extends E> someElements) {
		addAll(someElements);
	}

	/**
	 * @since 1.3
	 */
	public BagImpl(@NonNull Iterator<? extends E> someElements) {
		while (someElements.hasNext()) {
			add(someElements.next());
		}
	}

	@Override
	public synchronized boolean add(E anElement) {
		ElementCounter newCounter = spareCounter;
		if (newCounter == null) {
			newCounter = new ElementCounter();
		}
		else {
			spareCounter = null;
			newCounter.value = 1;
		}
		ElementCounter oldCounter = map.put(anElement, newCounter);
		if (oldCounter != null) {
			newCounter.value += oldCounter.value;
			spareCounter = oldCounter;;
		}
		size++;
		hashCode = null;
		return true;	// the collection always changes as a result of this call
	}

	@Override
	public void clear() {
		hashCode = null;
		size = 0;
		map.clear();
	}

	@Override
	public boolean contains(Object anElement) {
		return count(anElement) > 0;
	}

	@Override
	public int count(Object anElement) {
		ElementCounter count = map.get(anElement);
		return count != null ? count.value : 0;
	}

	/**
	 * Returns true iff this bag and the argument bag have the same number of the same
	 * elements.
	 */
	@Override
	public boolean equals(Object thatElement) {
		if (thatElement == this) {
			return true;
		}
		if (!(thatElement instanceof Bag.Internal<?>)) {
			return false;
		}
		Bag.Internal<?> thatBag = (Bag.Internal<?>) thatElement;
		if (size() != thatBag.size()) {
			return false;
		}
		Map<?, ? extends Number> thatMap = thatBag.getMap();
		for (Object thisObject : map.keySet()) {
			ElementCounter thisCount = map.get(thisObject);
			assert thisCount !=  null;
			Number thatCount = thatMap.get(thisObject);
			if ((thatCount == null) || (thatCount.intValue() != thisCount.intValue()))
				return false;
		}
		return true;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public @NonNull Map<E, ? extends Number> getMap() {
		return map;
	}

	@Override
	public int hashCode() {
		Integer hashCode2 = hashCode;
		if (hashCode2 == null) {
			int result = 37;
			result = 37 * result + map.hashCode();
			result = 37 * result + size;
			hashCode2 = hashCode = result;
		}
		return hashCode2;
	}

	@Override
	public @NonNull Iterator<E> iterator() {
		Iterator<E> objectIterator = map.keySet().iterator();
		if (objectIterator.hasNext()) {
			return new BagIterator<E>(map, objectIterator);
		}
		else {
			return ClassUtil.emptyIterator();
		}
	}

	/**
	 * removes every occurrence of anElement from the collection
	 */
	@Override
	public boolean remove(Object anElement) {
		ElementCounter count = map.remove(anElement);
		if (count == null) {
			return false;
		}
		size -= count.value;
		hashCode = null;
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		return map.toString();
	}
}
