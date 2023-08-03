/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.MultiViewPageBookView;
import org.eclipse.papyrus.views.modelexplorer.dialog.NavigatorSearchDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * this handler is used to look for element
 *
 */
// @Unused
// The QuickSearch feature is disabled since the new Search feature is available (0.10)
public class SearchElementHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShell(event);
		if (shell == null) {
			return null;
		}
		NavigatorSearchDialog dialog = new NavigatorSearchDialog(shell, getSelectedTreeViewer(event));
		dialog.open();
		return null;
	}

	protected TreeViewer getSelectedTreeViewer(ExecutionEvent event) {

		IWorkbenchPart activePart;
		// Try to get the active part

		// Try to get the TreeViewer from the evaluation context
		if (event.getApplicationContext() instanceof EvaluationContext) {
			EvaluationContext context = (EvaluationContext) event.getApplicationContext();
			// activeEditor, activeSite, selection, activeShell, activePart
			Object site = context.getVariable("activeSite");
			activePart = (IWorkbenchPart) context.getVariable("activePart");
		} else {
			activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		}

		if (activePart instanceof TreeViewer) {
			return (TreeViewer) activePart;
		}

		if (activePart instanceof MultiViewPageBookView) {
			MultiViewPageBookView pageBookView = (MultiViewPageBookView) activePart;
			IViewPart viewPart = pageBookView.getActiveView();
			if (viewPart instanceof ModelExplorerView) {
				return ((ModelExplorerView) viewPart).getCommonViewer();
			}
		}

		// Not found
		return null;
	}

	protected CommonNavigator getCommonNavigator() {
		IViewPart part = org.eclipse.papyrus.views.modelexplorer.NavigatorUtils.findViewPart("org.eclipse.papyrus.views.modelexplorer.modelexplorer");
		if (part instanceof CommonNavigator) {
			return ((CommonNavigator) part);
		}
		return null;
	}
}
