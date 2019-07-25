/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.util;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.DelegatingEList;
import org.eclipse.emf.common.util.EList;

/**
 * A specialization of the EMF delegating list framework that simply filters the
 * objects in a source list. The filter provided by an implementation of the
 * {@link IFilter} interface.
 * 
 * @param <E>
 *            the element type of the source list that I delegate to
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("serial")
public class FilteringList<E>
		extends DelegatingEList<E> {

	private final IFilter<? super E> filter;

	private EList<E> source;

	private EList<E> delegate;

	/**
	 * Initialize me with the source list of objects to be filtered.
	 * 
	 * @param source
	 *            my source list
	 * @param filter
	 *            the filter criteria to apply
	 */
	public FilteringList(EList<E> source, IFilter<? super E> filter) {
		this.filter = filter;
		this.source = source;

		delegate = new BasicEList<E>(source.size());

		// initial population
		for (E next : source) {
			if (accept(next)) {
				delegate.add(next);
			}
		}
	}

	/**
	 * Filters an element in the source list.
	 * 
	 * @param sourceElement
	 *            an element in the source list
	 * @return whether the element should appear in the delegate list
	 */
	protected final boolean accept(E sourceElement) {
		return filter.accept(sourceElement);
	}

	@Override
	protected List<E> delegateList() {
		return delegate;
	}

	@Override
	protected void delegateAdd(E object) {
		if (accept(object)) {
			super.delegateAdd(object);
			source.add(object);
		} else {
			throw new IllegalArgumentException(
				"cannot add an element excluded by the filter"); //$NON-NLS-1$
		}
	}

	@Override
	protected void delegateAdd(int index, E object) {
		if (accept(object)) {
			int sourceIndex = source.size();
			if (index < delegate.size()) {
				E result = delegate.get(index);
				sourceIndex = source.indexOf(result);
			}
			super.delegateAdd(index, object);
			source.add(sourceIndex, object); 
		} else {
			throw new IllegalArgumentException(
					"cannot add an element excluded by the filter"); //$NON-NLS-1$
		}
	}

	@Override
	protected E delegateRemove(int index) {
		E result = super.delegateRemove(index);

		source.remove(result);

		return result;
	}

	@Override
	protected E delegateMove(int targetIndex, int sourceIndex) {
		throw new UnsupportedOperationException(
			"move makes no sense in a FilteringList"); //$NON-NLS-1$
	}

	@Override
	protected E delegateSet(int index, E object) {
		E result = super.delegateSet(index, object);

		if (accept(object)) {
			source.set(source.indexOf(result), object);
		}

		return result;
	}

	@Override
	protected void delegateClear() {
		super.delegateClear();

		for (Iterator<E> iter = source.iterator(); iter.hasNext();) {
			if (accept(iter.next())) {
				iter.remove();
			}
		}
	}

	/**
	 * Filtering protocol for a {@link FilteringList}.
	 * 
	 * @param <E>
	 *            the element type of the list to be filtered
	 * 
	 * @author Christian W. Damus (Zeligsoft)
	 */
	public static interface IFilter<E> {

		/**
		 * Filters an element in the source list.
		 * 
		 * @param element
		 *            an element in the source list
		 * @return whether the element should appear in the delegate list
		 */
		boolean accept(E element);
	}
}