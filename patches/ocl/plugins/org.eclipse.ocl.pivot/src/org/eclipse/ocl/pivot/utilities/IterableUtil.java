/*******************************************************************************
 * Copyright (c) 2019, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 * E.D.Willink - initial API and implementation
 * E.D.Willink - Bug 360072
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;

import com.google.common.collect.Iterables;

/**
 * IterableUtil remedies defects in com.google.common.collect.Iterables.
 *
 * @since 1.11
 */
public class IterableUtil
{
	/**
	 * Retain only those elements of one iterable that are present in another, returning true if anything removed.
	 */
	public static boolean retainAll(@NonNull Collection<?> removeFrom, @NonNull Iterable<?> elementsToRetain) {
		if (elementsToRetain instanceof Collection) {
			return removeFrom.retainAll((Collection<?>)elementsToRetain);
		}
		else {
			Iterator<?> removeFromIterator = removeFrom.iterator();
			boolean didRemove = false;
			while (removeFromIterator.hasNext()) {
				if (!Iterables.contains(elementsToRetain, removeFromIterator.next())) {
					removeFromIterator.remove();
					didRemove = true;
				}
			}
			return didRemove;
		}
	}
}
