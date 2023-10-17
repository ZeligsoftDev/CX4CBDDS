/*******************************************************************************
 * Copyright (c) 2016, 2020 Willink Transformations and others.
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
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A UniqueList is an ArrayList that enforces uniqueness of its contents. For small lists the enforcement
 * is by content iteration. For large lists a HashSet accelerates is-present testing.
 *
 * @since 1.8
 */
public class UniqueList<E> extends ArrayList<E> implements Set<E>
{
	private static final long serialVersionUID = 1L;
	private static int SMALL_TO_LARGE_THRESHOLD = 5;

	private @Nullable Set<E> set = null;

    /**
     * Constructs a new empty list.
     */
    public UniqueList() {}

    /**
     * Constructs a new set containing the elements in the specified collection.
     */
    public UniqueList(Collection<? extends E> c) {
    	if (c.size() >= SMALL_TO_LARGE_THRESHOLD) {
        	set = new HashSet<>(c.size());
     	}
       	for (E aT : c) {
       		add(aT);
       	}
    }

    /**
     * Constructs a new, empty set with the specified initial capacity.
     */
    public UniqueList(int initialCapacity) {
    	if (initialCapacity >= SMALL_TO_LARGE_THRESHOLD) {
        	set = new HashSet<>(initialCapacity);
     	}
    }

	@Override
	public boolean add(E e) {
		Set<E> set2 = set;
		if (set2 == null) {
			if (size() < SMALL_TO_LARGE_THRESHOLD) {
				if (contains(e)) {
					return false;
				}
				return super.add(e);
			}
			else {
				set = set2 = new HashSet<>(this);
			}
		}
		if (!set2.add(e)) {
			return false;
		}
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		Set<E> set2 = set;
		if ((set2 == null) && ((size() + c.size()) >= SMALL_TO_LARGE_THRESHOLD)) {
			set = set2 = new HashSet<>(this);
		}
		boolean isChanged = false;
		if (set2 == null) {
			for (E aT : c) {
				if (!contains(aT)) {
					isChanged = true;
					super.add(aT);
				}
			}
		}
		else {
			for (E aT : c) {
				if (set2.add(aT)) {
					isChanged = true;
					super.add(aT);
				}
			}
		}
		return isChanged;
	}

	@Override
	public void clear() {
		super.clear();
		set = null;
	}

	@Override
	public boolean contains(Object o) {
		return set != null ? set.contains(o) : super.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return set != null ? set.containsAll(c) : super.containsAll(c);
	}


	@Override
	public boolean remove(Object o) {
		if ((set != null)  && !set.remove(o)) {
			return false;
		}
		return super.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean isChanged = false;
		for (Object aT : c) {
			if (remove(aT)) {
				isChanged = true;
			}
		}
		return isChanged;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		if (set != null) {
			set.retainAll(c);
			return super.retainAll(set);
		}
		else {
			return super.retainAll(c);
		}
	}

	@SuppressWarnings("null")
	@Override
	public <T> T @NonNull [] toArray(T[] a) {
		return super.toArray(a);
	}
}