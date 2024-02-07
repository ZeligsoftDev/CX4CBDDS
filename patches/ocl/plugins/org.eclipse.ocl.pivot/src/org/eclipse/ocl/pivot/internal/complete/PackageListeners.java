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

public class PackageListeners<L extends PackageListeners.IPackageListener> extends ModelListeners<L>
{
	public static interface IPackageListener extends IModelListener
	{
		void didAddClass(org.eclipse.ocl.pivot.@NonNull Class partialClass);
		void didRemoveClass(org.eclipse.ocl.pivot.@NonNull Class partialClass);
	}

	public synchronized void didAddClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		boolean doFlush = false;
		for (WeakReference<L> ref : listeners) {
			IPackageListener listener = ref.get();
			if (listener != null) {
				listener.didAddClass(partialClass);
			}
			else {
				doFlush = true;
			}
		}
		if (doFlush) {
			doFlush();
		}
	}

	public synchronized void didRemoveClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		boolean doFlush = false;
		for (WeakReference<L> ref : listeners) {
			IPackageListener listener = ref.get();
			if (listener != null) {
				listener.didRemoveClass(partialClass);
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