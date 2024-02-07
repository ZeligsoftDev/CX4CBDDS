/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * A CompleteElementIterable supports iteration over the multiple iterable contributions
 * to a Complete Element as if all were merged in a composite element.
 *
 * @param <O> The Outer type of the Complete Element
 * @param <I> The Inner type of the iterated Complete Element child
 */
public abstract class CompleteElementIterable<O,I> implements Iterable<I>
{
	protected class Iterator implements java.util.Iterator<I>
	{
		private final java.util.Iterator<? extends O> outerIterator;
		private java.util.Iterator<I> innerIterator;
		private @Nullable I nextValue;

		public Iterator(@NonNull Iterable<? extends O> iterables) {
			outerIterator = iterables.iterator();
			innerIterator = null;
			advance();
		}

		protected boolean advance() {
			while (true) {
				if (innerIterator != null) {
					while (innerIterator.hasNext()) {
						nextValue = getInnerValue(ClassUtil.nonNullState(innerIterator.next()));
						if (nextValue != null) {
							return true;
						}
					}
				}
				if (outerIterator.hasNext()) {
					Iterable<I> innerIterable = getInnerIterable(ClassUtil.nonNullState(outerIterator.next()));
					if (innerIterable != null) {
						innerIterator = innerIterable.iterator();
					}
				}
				else {
					break;
				}
			}
			nextValue = null;
			return false;
		}

		@Override
		public boolean hasNext() {
			return nextValue != null;
			//			if (innerIterator == null) {
			//				return false;
			//			}
			//			if (innerIterator.hasNext()) {
			//				return true;
			//			}
			//			return advance();
		}

		@Override
		public I next() {
			try {
				if (nextValue != null) {
					return nextValue;
				}
				else {
					throw new NoSuchElementException();
				}
			}
			finally {
				advance();
			}
			//			return innerIterator != null ? getInnerValue(innerIterator.next()) : null;
		}

		@Override
		public void remove() {
			throw new IllegalStateException();
		}
	}

	protected final @NonNull Iterable<? extends O> iterables;

	public CompleteElementIterable(@NonNull Iterable<? extends O> iterables) {
		this.iterables = iterables;
	}

	/**
	 * Return the iterables for an inner iteration over the iterable. A null
	 * return may be used to indicate no inner iterations are necessary.
	 *
	 * @param iterable
	 * @return the inner iterable or null for none.
	 */
	protected abstract Iterable<I> getInnerIterable(@NonNull O iterable);

	protected @Nullable I getInnerValue(@NonNull I element) {
		return element;
	}

	@Override
	public java.util.@NonNull Iterator<I> iterator() {
		if (iterables instanceof List<?>) {
			@SuppressWarnings("unchecked")
			List<O> list = (List<O>)iterables;
			if (list.size() == 0) {
				java.util.@NonNull Iterator<I> result = ClassUtil.<I>emptyIterator();
				return result;
			}
			else if (list.size() == 1) {
				O listEntry = list.get(0);
				if (listEntry != null) {
					Iterable<I> innerIterable = getInnerIterable(listEntry);
					if (innerIterable != null) {
						java.util.@NonNull Iterator<I> result = innerIterable.iterator();
						return result;
					}
				}
				java.util.@NonNull Iterator<I> result = ClassUtil.<I>emptyIterator();
				return result;
			}
		}
		return new Iterator(iterables);
	}
}