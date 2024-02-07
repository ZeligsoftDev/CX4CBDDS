/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A SingletonIterator supports a single iteration over a given value.
 */
public final class SingletonIterator<T> implements Iterator<T>
{
	private @NonNull T value;
	private boolean done = false;

	public SingletonIterator(@NonNull T value) {
		this.value = value;
	}

	@Override
	public boolean hasNext() {
		return !done;
	}

	@Override
	public @NonNull T next() {
        if (done) {
        	throw new NoSuchElementException();
        }
        else {
        	done = true;
			return value;
        }
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();			
	}
}