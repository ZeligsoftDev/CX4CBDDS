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
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;

public class ClassListeners<L extends ClassListeners.IClassListener> extends AbstractListeners<L>
{
	public static interface IClassListener extends AbstractListeners.IAbstractListener
	{
		void didAddOperation(@NonNull Operation partialOperation);
		void didAddProperty(@NonNull Property partialProperty);
		void didAddSuperClass(org.eclipse.ocl.pivot.@NonNull Class partialClass);
		void didRemoveOperation(@NonNull Operation partialOperation);
		void didRemoveProperty(@NonNull Property partialProperty);
		void didRemoveSuperClass(org.eclipse.ocl.pivot.@NonNull Class partialClass);
	}

	public synchronized void didAddOperation(@NonNull Operation partialOperation) {
		boolean doFlush = false;
		for (@NonNull WeakReference<L> ref : listeners) {
			@Nullable L listener = ref.get();
			if (listener != null) {
				listener.didAddOperation(partialOperation);
			}
			else {
				doFlush = true;
			}
		}
		if (doFlush) {
			doFlush();
		}
	}

	public synchronized void didAddProperty(@NonNull Property partialProperty) {
		boolean doFlush = false;
		for (@NonNull WeakReference<L> ref : listeners) {
			@Nullable L listener = ref.get();
			if (listener != null) {
				listener.didAddProperty(partialProperty);
			}
			else {
				doFlush = true;
			}
		}
		if (doFlush) {
			doFlush();
		}
	}

	public synchronized void didAddSuperClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		boolean doFlush = false;
		for (@NonNull WeakReference<L> ref : listeners) {
			@Nullable L listener = ref.get();
			if (listener != null) {
				listener.didAddSuperClass(partialClass);
			}
			else {
				doFlush = true;
			}
		}
		if (doFlush) {
			doFlush();
		}
	}

	public synchronized void didRemoveOperation(@NonNull Operation partialOperation) {
		boolean doFlush = false;
		for (@NonNull WeakReference<L> ref : listeners) {
			@Nullable L listener = ref.get();
			if (listener != null) {
				listener.didRemoveOperation(partialOperation);
			}
			else {
				doFlush = true;
			}
		}
		if (doFlush) {
			doFlush();
		}
	}

	public synchronized void didRemoveProperty(@NonNull Property partialProperty) {
		boolean doFlush = false;
		for (@NonNull WeakReference<L> ref : listeners) {
			@Nullable L listener = ref.get();
			if (listener != null) {
				listener.didRemoveProperty(partialProperty);
			}
			else {
				doFlush = true;
			}
		}
		if (doFlush) {
			doFlush();
		}
	}

	public synchronized void didRemoveSuperClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		boolean doFlush = false;
		for (@NonNull WeakReference<L> ref : listeners) {
			@Nullable L listener = ref.get();
			if (listener != null) {
				listener.didRemoveSuperClass(partialClass);
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