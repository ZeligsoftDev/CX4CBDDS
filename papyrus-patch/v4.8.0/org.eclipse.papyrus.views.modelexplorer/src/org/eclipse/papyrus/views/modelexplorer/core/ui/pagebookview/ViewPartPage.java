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
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.part.ViewPart;


/**
 * A {@link Page} handling a {@link ViewPart} in a {@link MultiViewPageBookView}.
 * Subclass must create the viewer in their constructor. The constructor take the part as argument.
 * The constructor is called from a subclass of {@link MultiViewPageBookView}.
 * Subclass should also implements the method getControl().
 *
 * @author cedric dumoulin
 *
 */
public abstract class ViewPartPage extends Page implements IAdaptable {


	/**
	 * The wrapped View
	 */
	private IViewPart modelExplorer;

	/**
	 * Constructor.
	 *
	 */
	public ViewPartPage() {
	}

	/**
	 * Init the inner View
	 *
	 * @see org.eclipse.ui.part.Page#init(org.eclipse.ui.part.IPageSite)
	 *
	 * @param pageSite
	 */
	@Override
	public void init(IPageSite pageSite) {
		// Not used.
		super.init(pageSite);
	}

	/**
	 * @param viewPageSite
	 * @param memento
	 * @throws CoreException
	 */
	public void init(IWorkbenchPart part, ViewPageSite viewPageSite, IMemento memento, IConfigurationElement cfig) throws CoreException {

		// Call the original method to record the site
		init(viewPageSite);

		// ask to create the Viewer
		modelExplorer = createViewer(part);

		// Add the extension config if requested by the Viewer
		if (modelExplorer instanceof IExecutableExtension) {
			((IExecutableExtension) modelExplorer).setInitializationData(cfig, null, null);
		}
		// Init the part
		modelExplorer.init(viewPageSite, memento);
	}

	/**
	 * Create the viewer for this page. The Viewer is associated to the specified part.
	 *
	 * @param part
	 *            The part associated to the Viewer.
	 *
	 * @return The Viewer to render in the page.
	 */
	protected abstract IViewPart createViewer(IWorkbenchPart part);

	/**
	 * Subclass must implement this method.
	 *
	 * @see org.eclipse.ui.part.Page#getControl()
	 *
	 * @return
	 */
	@Override
	public abstract Control getControl();

	/**
	 * @see org.eclipse.ui.part.Page#setFocus()
	 *
	 */
	@Override
	public void setFocus() {
		modelExplorer.setFocus();
	}

	/**
	 * Return the associated viewer
	 *
	 * @return
	 */
	public IViewPart getViewer() {
		return modelExplorer;
	}

	/**
	 * Forward to the
	 *
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 *
	 * @param adapter
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {

		if (modelExplorer instanceof IAdaptable) {
			return ((IAdaptable) modelExplorer).getAdapter(adapter);
		}

		// do nothing
		return null;
	}

	/**
	 * Dispose the page, and its associated viewer.
	 *
	 * @see org.eclipse.ui.part.Page#dispose()
	 *
	 */
	@Override
	public void dispose() {
		modelExplorer.dispose();
		super.dispose();
		modelExplorer = null;
	}
}
