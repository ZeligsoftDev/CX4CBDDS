/*******************************************************************************
 * Copyright (c) 2013, 2017 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Philip Langer - check if control is disposed before redraw
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.util;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

/**
 * Utility class for running operation in the UI-Thread if not already within it.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public final class SWTUtil {

	private SWTUtil() {
		// prevent instantiation.
	}

	/**
	 * Causes the run() method of the runnable to be invoked by the user-interface thread at the next
	 * reasonable opportunity. The caller of this method continues to run in parallel, and is not notified
	 * when the runnable has completed.
	 * 
	 * @param runnable
	 *            runnable code to run on the user-interface thread.
	 */
	public static void safeAsyncExec(final Runnable runnable) {
		if (Display.getCurrent() != null) {
			Display.getCurrent().asyncExec(runnable);
		} else {
			Display.getDefault().asyncExec(runnable);
		}
	}

	/**
	 * Causes the run() method of the runnable to be invoked by the user-interface thread at the next
	 * reasonable opportunity. The thread which calls this method is suspended until the runnable completes.
	 * 
	 * @param runnable
	 *            runnable code to run on the user-interface thread.
	 */
	public static void safeSyncExec(final Runnable runnable) {
		if (Display.getCurrent() != null) {
			runnable.run();
		} else {
			Display.getDefault().syncExec(runnable);
		}
	}

	/**
	 * Run {@link Viewer#refresh()} on the given viewer.
	 * 
	 * @param viewer
	 *            the viewer to refresh.
	 * @param async
	 *            whether the thread which calls this method is not suspended until the runnable completes.
	 * @param checkDisposed
	 *            whether the viewer's control dispose state has to be checked before refresh.
	 */
	public static void safeRefresh(final Viewer viewer, boolean async, final boolean checkDisposed) {
		Runnable runnable = new Runnable() {
			public void run() {
				if (checkDisposed) {
					Control control = viewer.getControl();
					if (control != null && !control.isDisposed()) {
						viewer.refresh();
					}
				} else {
					viewer.refresh();
				}
			}
		};
		if (async) {
			safeAsyncExec(runnable);
		} else {
			safeSyncExec(runnable);
		}
	}

	/**
	 * Run {@link Control#redraw()} on the given viewer.
	 * 
	 * @param redraw
	 *            the control to redraw.
	 * @param async
	 *            whether the thread which calls this method is not suspended until the runnable completes.
	 */
	public static void safeRedraw(final Control control, boolean async) {
		Runnable runnable = new Runnable() {
			public void run() {
				if (!control.isDisposed()) {
					control.redraw();
				}
			}
		};
		if (async) {
			safeAsyncExec(runnable);
		} else {
			safeSyncExec(runnable);
		}
	}
}
