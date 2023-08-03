/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.actions;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.DiSashModelManager;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IOpenable;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.menus.IWorkbenchContribution;
import org.eclipse.ui.services.IServiceLocator;

public class OpenWithMenu extends ContributionItem implements IWorkbenchContribution {

	private IServiceLocator serviceLocator;

	public OpenWithMenu() {
		super();
	}

	public OpenWithMenu(String id) {
		super(id);
	}

	/**
	 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.Menu, int)
	 *
	 * @param menu
	 * @param index
	 */
	@Override
	public void fill(Menu menu, int index) {
		ISelectionService selectionService = serviceLocator.getService(ISelectionService.class);
		if (selectionService == null) {
			return;
		}

		ISelection currentSelection = selectionService.getSelection();
		if (!(currentSelection instanceof IStructuredSelection)) {
			return;
		}

		IStructuredSelection selection = (IStructuredSelection) currentSelection;
		if (selection.isEmpty()) {
			return;
		}

		IWorkbenchPart part = serviceLocator.getService(IWorkbenchPart.class);
		if (part == null) {
			return;
		}
		ServicesRegistry registry = part.getAdapter(ServicesRegistry.class);
		if (registry == null) {
			return;
		}

		IPageManager pageManager;
		try {
			pageManager = registry.getService(IPageManager.class);
			if (pageManager == null) {
				return;
			}
		} catch (ServiceException ex) {
			// Ignore and stop
			return;
		}

		Iterator<?> iterator = selection.iterator();
		while (iterator.hasNext()) {
			final EObject selectedElement = EMFHelper.getEObject(iterator.next());
			if (selectedElement == null) {
				continue;
			}

			IOpenable papyrusPage = Platform.getAdapterManager().getAdapter(selectedElement, IOpenable.class);
			if (papyrusPage == null) {
				continue;
			}

			Map<String, String> editorIDs;
			try {
				DiSashModelManager modelManager = registry.getService(DiSashModelManager.class);
				editorIDs = modelManager.getEditorIDsFor(selectedElement);
			} catch (ServiceException ex) {
				Activator.log.error(ex);
				return;
			}

			if (editorIDs == null || editorIDs.size() < 2) {
				return;
			}

			MenuItem openWith = new MenuItem(menu, SWT.CASCADE);
			openWith.setText("Open with...");

			Menu subMenu = new Menu(menu);
			openWith.setMenu(subMenu);

			for (Map.Entry<String, String> editorID : editorIDs.entrySet()) {
				MenuItem gmfItem = new MenuItem(subMenu, SWT.NONE);
				gmfItem.setText(editorID.getValue());
				gmfItem.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						pageManager.openPage(selectedElement, editorID.getKey());
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						// Nothing
					}
				});
			}
		}
	}

	/**
	 * @see org.eclipse.ui.menus.IWorkbenchContribution#initialize(org.eclipse.ui.services.IServiceLocator)
	 *
	 * @param serviceLocator
	 */
	@Override
	public void initialize(IServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

}
