/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.values;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerRange;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.Value;

/**
 * @generated NOT
 */
public class IntegerRangeImpl extends AbstractList<Value> implements IntegerRange
{
	// local iterator class that provides
	// hasNext() and next() methods appropriate
	// for this range set
	class IntegerRangeIterator implements Iterator<Value>
	{
		private IntegerValue curr = null;		// null before first next(), last once finished

		//		public Value get() {
		//			assert curr != null;
		//			return curr;
		//		}

		@Override
		public boolean hasNext() {
			if (curr == null) {
				return first.commutatedCompareToInteger(last) <= 0;
			}
			else {
				return !last.equals(curr);
			}
		}

		@Override
		public IntegerValue next() {
			if (curr == null) {
				curr = first;
			}
			else if (curr.commutatedCompareToInteger(last) < 0) {
				try {
					curr = curr.addInteger(ValueUtil.ONE_VALUE);
				} catch (InvalidValueException e) {
					throw new NoSuchElementException();
				}
			}
			else {
				throw new NoSuchElementException();
			}
			return curr;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();	// Unimplemented optional operation
		}

		@Override
		public String toString() {
			return String.valueOf(curr);
		}
	}

	protected final @NonNull IntegerValue first;		// not null or invalid
	protected final @NonNull IntegerValue last;			// not null or invalid
	protected final @NonNull IntegerValue fullSize;		// zero if empty
	protected final Integer size;						// null if fullSize not an Integer

	public IntegerRangeImpl(@NonNull IntegerValue first, @NonNull IntegerValue last) {
		IntegerValue sizeMinusOne = last.subtractInteger(first);
		this.first = first;
		this.last = last;
		if (sizeMinusOne.signum() < 0) {
			this.fullSize = ValueUtil.ZERO_VALUE;
			this.size = 0;
		}
		else {
			this.fullSize = sizeMinusOne.addInteger(ValueUtil.ONE_VALUE);
			this.size = fullSize.asInteger();
		}
	}

	@Override
	public boolean contains(Object o) {
		if (!(o instanceof IntegerValue)) {
			return false;
		}
		IntegerValue value = (IntegerValue)o;
		return (first.commutatedCompareToInteger(value) <= 0) && (value.commutatedCompareToInteger(last) <= 0);
	}

	@Override
	public @NonNull IntegerValue get(int index) {
		if ((index < 0) || (size == null) || (index >= size)) {
			throw new NoSuchElementException();
			//			getValueFactory().throwInvalidValueException("Out of range index {0} for range 0..{1}", index, size);
		}
		try {
			return first.addInteger(ValueUtil.integerValueOf(index));
		} catch (InvalidValueException e) {
			throw new NoSuchElementException();
		}
	}

	@Override
	public @NonNull IntegerValue getFirst() {
		return first;
	}

	@Override
	public @NonNull IntegerValue getLast() {
		return last;
	}

	@Override
	public @NonNull IntegerValue getSize() {
		return fullSize;
	}

	//	public @NonNull ValueFactory getValueFactory() {
	//		return first.getValueFactory();
	//	}

	@Override
	public @NonNull Iterator<Value> iterator() {
		return new IntegerRangeIterator();
	}

	@Override
	public int size() {
		if (size != null) {
			return size;
		}
		else {
			throw new NoSuchElementException();
			//			getValueFactory().throwInvalidValueException("Range size {0} cannot be expressed as an int", size);
		}
	}
}