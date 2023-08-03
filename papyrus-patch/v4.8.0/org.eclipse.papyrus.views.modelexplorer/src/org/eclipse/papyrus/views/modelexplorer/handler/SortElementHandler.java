/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 434635
 *
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.papyrus.views.modelexplorer.sorting.DefaultTreeViewerSorting;
import org.eclipse.papyrus.views.modelexplorer.sorting.ITreeViewerSorting;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.handlers.HandlerUtil;


/**
 * this handler is used to set a sorter on the model explorer
 */
public class SortElementHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (Activator.getDefault().getCustomizationManager() != null) {
			final boolean isSorted = ((ToolItem) ((Event) event.getTrigger()).widget).getSelection();

			getTreeViewerSorting(event).setSorted(isSorted);
		}
		return null;
	}

	protected ITreeViewerSorting getTreeViewerSorting(ExecutionEvent event) {
		return DefaultTreeViewerSorting.getSorting(HandlerUtil.getActivePart(event));
	}
}
