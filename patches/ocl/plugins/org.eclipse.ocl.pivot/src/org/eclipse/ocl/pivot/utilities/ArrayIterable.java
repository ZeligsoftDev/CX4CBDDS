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
package org.eclipse.ocl.pivot.utilities;

import org.eclipse.jdt.annotation.NonNull;

/**
 * ArrayIterable provides an Iterable for an Array
 */
public class ArrayIterable<T> implements IndexableIterable<T>
{
	protected class Iterator implements java.util.Iterator<T>
	{
		private int index = firstIndex;

		@Override
		public boolean hasNext() {
			return index < lastIndex;
		}

		@Override
		public T next() {
			return array[index++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private final T[] array;
	private final int firstIndex;
	private final int lastIndex;

	public ArrayIterable(T[] array) {
		this.array = array;
		this.firstIndex = 0;
		this.lastIndex = array.length;
	}

	public ArrayIterable(T[] array, int firstIndex, int lastIndex) {
		this.array = array;
		this.firstIndex = firstIndex;
		this.lastIndex = lastIndex;
	}

	@Override
	public @NonNull T get(int index) {
		return ClassUtil.nonNullState(array[firstIndex + index]);
	}

	@Override
	public java.util.@NonNull Iterator<T> iterator() {
		return new Iterator();
	}

	@Override
	public int size() {
		return lastIndex - firstIndex;
	}
}