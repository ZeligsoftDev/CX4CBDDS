/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A SmallSet is a Set whose implementation uses null while empty
 * else an ArrayList so long as its size remains under 5 elements
 * else a HashSet.
 *
 * @since 1.8
 */
public class SmallSet<T> implements Set<T>
{
	private static final Object[] EMPTY_ARRAY = new Object[] {};
//	@SuppressWarnings("null")
//	private static final @NonNull Iterator<?> EMPTY_ITERATOR = Collections.emptyIterator();
	private static int SMALL_TO_LARGE_THRESHOLD = 5;

	private @Nullable Collection<T> contents;
	private boolean isList;

    /**
     * Constructs a new, empty set using a null contents.
     */
    public SmallSet() {
    	contents = null;
    	isList = false;
    }

    /**
     * Constructs a new set containing the elements in the specified collection.
     */
    public SmallSet(Collection<? extends T> c) {
    	if (c.size() >= SMALL_TO_LARGE_THRESHOLD) {
        	contents = new HashSet<>(c);
        	isList = false;
    	}
    	else {
        	contents = new ArrayList<>();
        	isList = true;
        	for (T aT : c) {
        		add(aT);
        	}
    	}
    }

    /**
     * Constructs a new, empty set with the specified initial capacity.
     */
    public SmallSet(int initialCapacity) {
    	if (initialCapacity <= 0) {
        	contents = null;
        	isList = false;
    	}
    	else if (initialCapacity >= SMALL_TO_LARGE_THRESHOLD) {
        	contents = new HashSet<>(initialCapacity);
        	isList = false;
    	}
    	else {
        	contents = new ArrayList<>(initialCapacity);
        	isList = true;
    	}
    }

	@Override
	public boolean add(T e) {
		Collection<T> contents2 = contents;
		if (contents2 == null) {
			contents = contents2 = new ArrayList<>();
			isList = true;
		}
		else if (isList) {
			int newSize = contents2.size() + 1;
			if (newSize > SMALL_TO_LARGE_THRESHOLD) {
				contents = contents2 = new HashSet<>(contents2);
				isList = false;
			}
			else if (contents2.contains(e)) {
				return false;
			}
		}
		return contents2.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		Collection<T> contents2 = contents;
		if (contents2 == null) {
			contents = contents2 = new ArrayList<>();
			isList = true;
		}
		else if (isList) {
			int newSize = contents2.size() + c.size();
			if (newSize > SMALL_TO_LARGE_THRESHOLD) {
				contents = contents2 = new HashSet<>(contents);
				isList = false;
			}
			else {
				boolean isChanged = false;
				for (T aT : c) {
					if (!contents2.contains(aT)) {
						contents2.add(aT);
						isChanged = true;
					}
				}
				return isChanged;
			}
		}
		return contents2.addAll(c);
	}

	@Override
	public void clear() {
		contents = null;
	}

	@Override
	public boolean contains(Object o) {
		return contents != null ? contents.contains(o) : false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return contents != null ? contents.containsAll(c) : false;
	}

	@Override
	public boolean isEmpty() {
		return contents != null ? contents.isEmpty() : true;
	}

	@SuppressWarnings("null")		// FIXME See Bug 547825
	@Override
	public @NonNull Iterator<T> iterator() {
		return contents != null ? contents.iterator() : Collections.emptyIterator();
	}

	@Override
	public boolean remove(Object o) {
		return contents != null ? contents.remove(o) : false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return contents != null ? contents.removeAll(c) : false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return contents != null ? contents.retainAll(c) : false;
	}

	@Override
	public int size() {
		return contents != null ? contents.size() : 0;
	}

	@Override
	public Object[] toArray() {
		return contents != null ? contents.toArray() : EMPTY_ARRAY;
	}

	@SuppressWarnings("null")		// FIXME See Bug 547825
	@Override
	public <T2> T2 @NonNull [] toArray(T2[] a) {
		return (contents != null ? contents : Collections.emptyList()).toArray(a);
	}
}