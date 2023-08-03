/*****************************************************************************
 * Copyright (c) 2016 CEA LIST, ALL4TEC and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.MultiViewPageBookView;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonViewer;

/**
 * Handler to collapse all children at selected element.
 * @since 3.0
 */
public class CollapseAllHandler extends AbstractHandler {

	/**
	 * Constructor.
	 */
	public CollapseAllHandler() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(final ExecutionEvent event) {

		ModelExplorerView openedModelExplorerView = getOpenedModelExplorerView();

		if (openedModelExplorerView != null) {
			CommonViewer commonViewer = openedModelExplorerView.getCommonViewer();
			ISelection selection = commonViewer.getSelection();
			// If there are selected element
			if (selection instanceof StructuredSelection && !selection.isEmpty()) {
				// expand each selected element
				for (Object object : ((StructuredSelection) selection).toArray()) {
					commonViewer.collapseToLevel(object, AbstractTreeViewer.ALL_LEVELS);
				}

			} else {
				// or collapse all
				commonViewer.collapseAll();
			}
		}
		return null;
	}

	/**
	 * Get the view 'ModelExplorer' if it's already opened.
	 */
	public static ModelExplorerView getOpenedModelExplorerView() {
		final IViewReference[] iViewModelExplorers = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getViewReferences();

		for (final IViewReference iViewModelExplorer : iViewModelExplorers) {
			final IViewPart iViewPart = iViewModelExplorer.getView(false);
			if (iViewPart instanceof ModelExplorerPageBookView && ((MultiViewPageBookView) iViewPart).getActiveView() instanceof ModelExplorerView) {
				return (ModelExplorerView) ((ModelExplorerPageBookView) iViewPart).getActiveView();
			}
		}
		return null;
	}

}
