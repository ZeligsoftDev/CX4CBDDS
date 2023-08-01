/*****************************************************************************
 * Copyright (c) 2010 LIFL & CEA LIST.
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
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IKeyBindingService;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.PageSite;


/**
 * A Site implementing {@link IViewSite} and {@link IPageSite}.
 * This site is used by the {@link MultiViewPageBookView} to provide suitable Site to a {@link ViewPartPage} and its Viewer.
 *
 * @author cedric dumoulin
 *
 */
public class ViewPageSite extends PageSite implements IViewSite {

	/**
	 * Local copy.
	 */
	private IViewSite parentViewSite;

	/**
	 * Constructor.
	 *
	 * @param parentViewSite
	 */
	public ViewPageSite(IViewSite parentViewSite) {
		super(parentViewSite);
		this.parentViewSite = parentViewSite;
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPartSite#getId()
	 *
	 * @return
	 */
	public String getId() {
		return parentViewSite.getId();
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPartSite#getPluginId()
	 *
	 * @return
	 */
	public String getPluginId() {
		return parentViewSite.getPluginId();
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPartSite#getRegisteredName()
	 *
	 * @return
	 */
	public String getRegisteredName() {
		
		return parentViewSite.getRegisteredName();
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPartSite#registerContextMenu(org.eclipse.jface.action.MenuManager, org.eclipse.jface.viewers.ISelectionProvider)
	 *
	 * @param menuManager
	 * @param selectionProvider
	 */
	public void registerContextMenu(MenuManager menuManager, ISelectionProvider selectionProvider) {
		parentViewSite.registerContextMenu(menuManager, selectionProvider);

	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPartSite#getKeyBindingService()
	 *
	 * @return
	 * @deprecated
	 */
	@Deprecated
	public IKeyBindingService getKeyBindingService() {
		
		return parentViewSite.getKeyBindingService();
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPartSite#getPart()
	 *
	 * @return
	 */
	public IWorkbenchPart getPart() {
		return parentViewSite.getPart();
	}

	/**
	 * @see org.eclipse.ui.IViewSite#getSecondaryId()
	 *
	 * @return
	 */
	public String getSecondaryId() {
		return parentViewSite.getSecondaryId();
	}

}
