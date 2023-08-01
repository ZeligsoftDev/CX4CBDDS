/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Thanh Liem PHAN (ALL4TEC) thanhliem.phan@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.ui.util.WorkbenchPartHelper;
import org.eclipse.papyrus.views.modelexplorer.DirectEditorEditingSupport;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.MultiViewPageBookView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;

/**
 * Class contains common methods to be used by different handlers in Model Explorer.
 */
public class ModelExplorerEditionUtil {

	/**
	 * @return The Model Explorer active view part
	 */
	public static IViewPart getModelExplorerActiveViewPart() {
		IViewPart activeView = null;

		final IWorkbenchPage activeWorkbenchPage = WorkbenchPartHelper.getCurrentActiveWorkbenchPage();

		if (null != activeWorkbenchPage) {
			// Get Model Explorer view part
			final IViewPart modelExplorerView = activeWorkbenchPage.findView(ModelExplorerPageBookView.VIEW_ID);

			if (modelExplorerView instanceof MultiViewPageBookView) {
				final MultiViewPageBookView pageBook = (MultiViewPageBookView) modelExplorerView;
				activeView = pageBook.getActiveView();
			}
		}

		return activeView;
	}

	/**
	 * Check whether the editing of an element is handled by a direct editor. In this case, we do
	 * not want to open the rename pop-up.
	 *
	 * @param element
	 *            The element that should be edited
	 * @return <code>true</code> if the element is handled by a direct editor, <code>false</code> otherwise
	 */
	public static boolean isHandledByDirectEditor(final EObject element) {
		return null != DirectEditorEditingSupport.getConfiguration(element);
	}

	/**
	 * Edit a selection element from the model explorer view.
	 * 
	 * @param selectionObject
	 *            The selection object to be edited
	 */
	public static void editElement(final EObject selectionObject) {
		Display.getCurrent().asyncExec(new Runnable() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				IViewPart viewPart = getModelExplorerActiveViewPart();

				if (viewPart instanceof ModelExplorerView) {
					((ModelExplorerView) viewPart).editElement(selectionObject, 0);
				}
			}
		});
	}
}
