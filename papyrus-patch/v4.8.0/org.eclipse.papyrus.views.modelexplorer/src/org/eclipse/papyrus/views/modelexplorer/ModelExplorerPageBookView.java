/*****************************************************************************
 * Copyright (c) 2010, 2014 LIFL, CEA LIST, Christian W. Damus, and others.
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
 *  Ansgar Radermacher (CEA) ansgar.radermacher@cea.fr - Added support for IGotoMarker
 *  Christian W. Damus (CEA) - bug 434635
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Bug 431117
 *  Christian W. Damus - bug 450536
 *  Christian W. Damus - bug 451683
 *  Christian W. Damus - bug 454536
 *
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.MultiViewPageBookView;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.ViewPartPage;
import org.eclipse.papyrus.views.modelexplorer.sorting.DefaultTreeViewerSorting;
import org.eclipse.papyrus.views.modelexplorer.sorting.ITreeViewerSorting;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import com.google.common.collect.Lists;


/**
 * A Page Book containing one {@link ModelExplorerView} for each opened Papyrus Editor.
 *
 * @author cedric dumoulin
 *
 */
public class ModelExplorerPageBookView extends MultiViewPageBookView implements IGotoMarker, ITabbedPropertySheetPageContributor {

	/** ID of the view, as given in the plugin.xml file */
	public static final String VIEW_ID = "org.eclipse.papyrus.views.modelexplorer.modelexplorer"; //$NON-NLS-1$

	private final SharedModelExplorerState state = new SharedModelExplorerState();

	/** The property sheet pages. */
	private List<IPropertySheetPage> propertiesSheetPages = new LinkedList<IPropertySheetPage>();

	private final CopyOnWriteArrayList<IPageBookViewPageListener> pageListeners = new CopyOnWriteArrayList<IPageBookViewPageListener>();

	@Override
	public void init(IViewSite site, IMemento memento) throws PartInitException {
		super.init(site, memento);

		if (memento != null) {
			state.load(memento);
		}
	}

	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {

		// part is of type IMultiDiagramEditor (because of isImportant() )

		ModelExplorerPage page = new ModelExplorerPage();
		page.setSharedState(state);

		// Init the page, and so the View
		initPage(page, part);
		page.createControl(getPageBook());
		return new PageRec(part, page);
	}

	/**
	 * Retrieves the {@link IPropertySheetPage} that his Model Explorer uses.
	 *
	 * @return
	 */
	private IPropertySheetPage getPropertySheetPage() {
		IPropertySheetPage propertySheetPage = new ModelExplorerPropertySheetPage(this);
		propertiesSheetPages.add(propertySheetPage);
		return propertySheetPage;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {

		if (IPropertySheetPage.class == adapter) {
			// Do not test if tabbedPropertySheetPage is null before calling new
			// this is managed by Eclipse which only call current method when necessary
			return getPropertySheetPage();
		}

		if (adapter == ITreeViewerSorting.class) {
			return new DefaultTreeViewerSorting() {

				@Override
				public void setSorted(boolean sorted) {
					// Update the shared state
					if (state != null) {
						state.setAlphaSorted(sorted);
					}
				}

				@Override
				public boolean isSorted() {
					return state != null && state.isAlphaSorted();
				}
			};
		}

		return super.getAdapter(adapter);
	}

	public String getContributorId() {
		// return Activator.PLUGIN_ID;
		return "TreeOutlinePage"; //$NON-NLS-1$
	}

	public void gotoMarker(IMarker marker) {
		String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
		if (uriAttribute != null) {
			URI uri = URI.createURI(uriAttribute);
			IViewPart viewPart = getActiveView();
			if (viewPart instanceof ModelExplorerView) {
				ModelExplorerView modelExplorerView = (ModelExplorerView) viewPart;
				EditingDomain domain = modelExplorerView.getEditingDomain();
				EObject eObject = domain.getResourceSet().getEObject(uri, false);
				if (eObject != null) {
					CommonViewer treeViewer = ((ModelExplorerView) viewPart).getCommonViewer();
					// The common viewer is in fact a tree viewer
					// bug enhancement: use function in ModelExplorerView instead of findElementForEObject
					ModelExplorerView.reveal(Lists.newArrayList(eObject), treeViewer);
				}
			}
		}
	}

	@Override
	public void saveState(IMemento memento) {
		state.save(memento);

		super.saveState(memento);
	}

	@Override
	public void partClosed(IWorkbenchPart part) {
		PageRec rec = getPageRec(part);
		if (rec != null) {
			if (rec.page instanceof ModelExplorerPage) {
				ModelExplorerView explorer = (ModelExplorerView) ((ModelExplorerPage) rec.page).getViewer();

				// Clear the explorer tree input to prompt the CNF to clear caches, promoting garbage collection
				explorer.aboutToDispose();
			}

			if (rec.page instanceof ViewPartPage) {
				// Forget the current selection in any property page that is targeting the model that is closing
				firePageClosing((ViewPartPage) rec.page);
			}
		}

		super.partClosed(part);
	}

	@Override
	protected void showPageRec(PageRec pageRec) {
		super.showPageRec(pageRec);

		if (getSite().getPage().getActivePart() == this) {
			if ((pageRec != null) && (pageRec.page instanceof ViewPartPage)) {
				firePageActivated((ViewPartPage) pageRec.page);
			}
		}
	}

	@Override
	public void setFocus() {
		try {
			super.setFocus();
		} catch (Exception ex) {
			//Tentative workaround to reduce error log cluttering during test execution on Linux
			//Only log a warning instead of the full stack trace, since NPEs happen a lot during tests on Linux
			Activator.log.warn("Error setting focus");
		}

		IPage page = getCurrentPage();
		if (page instanceof ViewPartPage) {
			firePageActivated((ViewPartPage) page);
		}
	}

	@Override
	public void dispose() {
		for (IPropertySheetPage page : propertiesSheetPages) {
			page.dispose();
		}
		propertiesSheetPages.clear();
		super.dispose();
	}

	void addPageListener(IPageBookViewPageListener listener) {
		pageListeners.addIfAbsent(listener);
	}

	void removePageListener(IPageBookViewPageListener listener) {
		pageListeners.remove(listener);
	}

	private void firePageActivated(ViewPartPage page) {
		for (IPageBookViewPageListener next : pageListeners) {
			try {
				next.pageActivated(this, page);
			} catch (Exception e) {
				Activator.log.error("Uncaught exception in page activation listener.", e); //$NON-NLS-1$
			}
		}
	}

	private void firePageClosing(ViewPartPage page) {
		for (IPageBookViewPageListener next : pageListeners) {
			try {
				next.pageClosing(this, page);
			} catch (Exception e) {
				Activator.log.error("Uncaught exception in page closing listener.", e); //$NON-NLS-1$
			}
		}
	}
}
