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

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.DelegatingEList;
import org.eclipse.emf.common.util.EList;

/**
 * A specialization of the EMF delegating list framework that simply transforms
 * the objects of one type in a source list to another type in the target list,
 * and vice-versa. The transformation and its inverse are provided by
 * subclasses, in implementations of:
 * <ul>
 * <li>{@link #transform(Object)} to transform source values to target values</li>
 * <li>{@link #inverse(Object)} to transform target values to source values</li>
 * </ul>
 * 
 * @param <S>
 *            the element type of the source list that I delegate to
 * @param <T>
 *            the element type of the target list to which I transform the
 *            source
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("serial")
public abstract class TransformingList<T, S>
		extends DelegatingEList<T> {

	private EList<S> source;

	private EList<T> delegate;

	/**
	 * Initialize me with the source list of objects to be transformed.
	 * 
	 * @param source
	 *            my source list
	 */
	public TransformingList(EList<S> source) {
		this.source = source;

		delegate = new BasicEList<T>(source.size());
		for (S next : source) {
			delegate.add(transform(next));
		}
	}

	/**
	 * Transforms an element in the source list to an element in the target
	 * list. Must not actually add the result to the target list.
	 * 
	 * @param sourceElement
	 *            an element in the source list
	 * @return an element to be stored in the target list
	 */
	protected abstract T transform(S sourceElement);

	/**
	 * Transforms an element in the target list to an element in the source
	 * list. Must not actually add the result to the source list.
	 * 
	 * @param targetElement
	 *            an element in the target list
	 * @return an element to be stored in the source list
	 */
	protected abstract S inverse(T targetElement);

	@Override
	protected List<T> delegateList() {
		return delegate;
	}

	@Override
	protected void delegateAdd(T object) {
		super.delegateAdd(object);

		source.add(inverse(object));
	}

	@Override
	protected void delegateAdd(int index, T object) {
		super.delegateAdd(index, object);

		source.add(index, inverse(object));
	}

	@Override
	protected T delegateRemove(int index) {
		T result = super.delegateRemove(index);

		source.remove(index);

		return result;
	}

	@Override
	protected T delegateMove(int targetIndex, int sourceIndex) {
		T result = super.delegateMove(targetIndex, sourceIndex);

		source.move(targetIndex, sourceIndex);

		return result;
	}

	@Override
	protected T delegateSet(int index, T object) {
		T result = super.delegateSet(index, object);

		source.set(index, inverse(object));

		return result;
	}

	@Override
	protected void delegateClear() {
		super.delegateClear();

		source.clear();
	}
}