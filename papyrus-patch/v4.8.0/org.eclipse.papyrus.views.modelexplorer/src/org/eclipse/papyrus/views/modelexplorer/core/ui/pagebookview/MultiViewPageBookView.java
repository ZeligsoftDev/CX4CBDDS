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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;


/**
 * Base class for PageBookView in Papyrus.
 * The PageBook mechanism can be moved in the core, as it can be reused by other Views.
 *
 * @author cedric dumoulin
 *
 */
public abstract class MultiViewPageBookView extends PageBookView {

	/**
	 * Remember the IMemento
	 */
	private IMemento memento;

	/**
	 * @see org.eclipse.ui.part.PageBookView#createDefaultPage(org.eclipse.ui.part.PageBook)
	 *
	 * @param book
	 * @return
	 */
	@Override
	protected IPageBookViewPage createDefaultPage(PageBook book) {
		IPageBookViewPage page = new DefaultPage();
		// Set Site
		initPage(page);
		page.createControl(book);

		return page;
	}

	/**
	 * Subclass must implement this method.
	 * The subclass implementation look like this:
	 * <ul>
	 * <li>ViewPartPage page = new MyPage();</li>
	 * <li>call initPage(page, part);</li>
	 * <li>call page.createControl(getPageBook());</li>
	 * <li>return new PageRec(part, page);</li>
	 * </ul>
	 *
	 * @param part
	 * @return
	 */
	@Override
	protected abstract PageRec doCreatePage(IWorkbenchPart part);

	/**
	 * @see org.eclipse.ui.part.PageBookView#doDestroyPage(org.eclipse.ui.IWorkbenchPart, org.eclipse.ui.part.PageBookView.PageRec)
	 *
	 * @param part
	 * @param pageRecord
	 */
	@Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec pageRecord) {

		// Dispose the associated page.
		pageRecord.page.dispose();

	}

	/**
	 * Check if the currently active part is a {@link IMultiDiagramEditor}.
	 * If true, return it.
	 *
	 * @see org.eclipse.ui.part.PageBookView#getBootstrapPart()
	 *
	 * @return The currently active editor if it is a IMultiDiagramEditor, null otherwise.
	 */
	@Override
	protected IWorkbenchPart getBootstrapPart() {


		IWorkbenchPart part = null;
		try {
			IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if (activeWorkbenchWindow != null) {
				IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
				if (activePage != null) {
					part = activePage.getActiveEditor();
				}
			}
		} catch (NullPointerException e) {
			// An element is not active yet
			return null;
		}
		if (isImportant(part)) {
			return part;
		}
		// The current active part is not for us.
		return null;
	}

	/**
	 * return true if the activated part is a {@link IMultiDiagramEditor}.
	 *
	 * @see org.eclipse.ui.part.PageBookView#isImportant(org.eclipse.ui.IWorkbenchPart)
	 *
	 * @param part
	 * @return
	 */
	@Override
	protected boolean isImportant(IWorkbenchPart part) {


		if (part instanceof IMultiDiagramEditor) {
			return true;
		}

		return false;
	}

	/**
	 * Record the IMemento to use it when pages are created
	 *
	 * @see org.eclipse.ui.part.ViewPart#init(org.eclipse.ui.IViewSite, org.eclipse.ui.IMemento)
	 *
	 * @param site
	 * @param memento
	 * @throws PartInitException
	 */
	@Override
	public void init(IViewSite site, IMemento memento) throws PartInitException {
		super.init(site, memento);
		this.memento = memento;
	}

	/**
	 * Create a Site that is also a {@link IViewSite}.
	 *
	 * @see org.eclipse.ui.part.PageBookView#initPage(org.eclipse.ui.part.IPageBookViewPage)
	 *
	 * @param page
	 */
	protected void initPage(ViewPartPage page, IWorkbenchPart part) {

		try {
			page.init(part, new ViewPageSite(getViewSite()), memento, getConfigurationElement());
		} catch (PartInitException e) {
			Activator.log.error("initPage", e); //$NON-NLS-1$
		} catch (CoreException e) {
			Activator.log.error("initPage", e); //$NON-NLS-1$
		}

	}

	/**
	 * Get the currently nested active view.
	 *
	 * @return The active Viewer, or null if none.
	 */
	public IViewPart getActiveView() {
		IPage page = getCurrentPage();
		if (page instanceof ViewPartPage) {
			return ((ViewPartPage) page).getViewer();
		}

		// not found
		return null;
	}
}
