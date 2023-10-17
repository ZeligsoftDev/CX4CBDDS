/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.complete;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public abstract class AbstractListeners<L extends AbstractListeners.IAbstractListener>
{
	public static interface IAbstractListener {}
	
	protected final @NonNull List<@NonNull WeakReference<L>> listeners = new ArrayList<@NonNull WeakReference<L>>();

	public synchronized void addListener(@NonNull L aListener) {
		for (@NonNull WeakReference<L> ref : listeners) {
			@Nullable L listener = ref.get();
			if (listener == aListener) {
				return;
			}
		}
		listeners.add(new WeakReference<L>(aListener));
	}

	protected void doFlush() {				// FIXME automate as part of custom lister-list
		for (int i = listeners.size(); --i >= 0; ) {
			@Nullable L completeListener = listeners.get(i).get();
			if (completeListener == null) {
				listeners.remove(i);
			}
		}
	}

	/**
	 * Remove a listener and return trie if there are no listeners left.
	 */
	public synchronized boolean removeListener(@NonNull L aListener) {
		for (@NonNull WeakReference<L> ref : listeners) {
			@Nullable L listener = ref.get();
			if (listener == aListener) {
				listeners.remove(ref);
				break;
			}
		}
		doFlush();
		return listeners.size() <= 0;
	}
}