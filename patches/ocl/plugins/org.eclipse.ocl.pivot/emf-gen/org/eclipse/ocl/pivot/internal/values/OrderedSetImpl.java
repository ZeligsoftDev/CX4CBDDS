/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.values;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.values.OrderedSet;

/**
 * Default implementation of the {@link OrderedSet} interface.
 * @generated NOT
 */
public class OrderedSetImpl<E> extends LinkedHashSet<E> implements OrderedSet<E>
{
	/**
	 *
	 */
	private static final long serialVersionUID = 3297491641047187175L;

	public OrderedSetImpl() {
		super();
	}

	public OrderedSetImpl(@NonNull Collection<? extends E> elements) {
		super(elements);
	}

	@Override
	public boolean equals(Object o) {
		// This is probably a bug fix on LinkedHashSet that should consider ordering for equals
		if (o == this) {
			return true;
		}
		if (!(o instanceof OrderedSet)) {
			return false;
		}
		OrderedSet<?> that = (OrderedSet<?>) o;
		if (that.size() != size())
			return false;
		Iterator<?> thisIterator = this.iterator();
		Iterator<?> thatIterator = that.iterator();
		while (thisIterator.hasNext()) {
			Object thisElement = thisIterator.next();
			Object thatElement = thatIterator.next();
			if (thisElement == null) {
				if (thatElement != null) {
					return false;
				}
			}
			else {
				if (!thisElement.equals(thatElement)) {
					return false;
				}
			}
		}
		return true;
	}
}
