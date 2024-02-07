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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class ModelListeners<L extends ModelListeners.IModelListener> extends AbstractListeners<L>
{
	public static interface IModelListener extends AbstractListeners.IAbstractListener
	{
		void didAddPackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage);
		void didRemovePackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage);
	}

	public synchronized void didAddPackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		boolean doFlush = false;
		for (@NonNull WeakReference<L> ref : listeners) {
			@Nullable L listener = ref.get();
			if (listener != null) {
				listener.didAddPackage(partialPackage);
			}
			else {
				doFlush = true;
			}
		}
		if (doFlush) {
			doFlush();
		}
	}

	public synchronized void didRemovePackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		boolean doFlush = false;
		for (@NonNull WeakReference<L> ref : listeners) {
			@Nullable L listener = ref.get();
			if (listener != null) {
				listener.didRemovePackage(partialPackage);
			}
			else {
				doFlush = true;
			}
		}
		if (doFlush) {
			doFlush();
		}
	}
}