/*
 * Copyright (c) 2014 CEA and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.views.modelexplorer.handler;

import java.util.Map;

import org.eclipse.core.commands.State;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.papyrus.views.modelexplorer.sorting.DefaultTreeViewerSorting;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


/**
 * The computed toggle state of the Sort Elements action.
 */
public class SortElementState extends State implements IExecutableExtension {

	private String viewID;

	public SortElementState() {
		super();
	}

	@Override
	public Object getValue() {
		IWorkbench bench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = bench.getActiveWorkbenchWindow();
		if (window == null) {
			// Not actually active?
			if (bench.getWorkbenchWindowCount() > 0) {
				window = bench.getWorkbenchWindows()[0];
			}
		}

		IWorkbenchPage page = (window == null) ? null : window.getActivePage();
		IViewPart viewPart = (page == null) ? null : page.findView(viewID);

		return DefaultTreeViewerSorting.getSorting(viewPart).isSorted();
	}

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		viewID = getViewID(config, propertyName, data);

		if (viewID == null) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "No viewID specified in SortElementState extension.")); //$NON-NLS-1$
		}
	}

	static String getViewID(IConfigurationElement config, String propertyName, Object data) {
		String result = null;

		if (data instanceof String) {
			// It's the view ID
			result = (String) data;
		} else {
			// It's a parameter map
			Map<?, ?> parameters = (Map<?, ?>) data;
			Object value = parameters.get("viewID");
			if (value instanceof String) {
				result = (String) value;
			}
		}

		return result;
	}
}
