/*****************************************************************************
 * Copyright (c) 2010, 2016 CEA LIST, Christian W. Damus, and others.
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
 *  Christian W. Damus - bug 450235
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.listener;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IOpenable;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.modelexplorer.Activator;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/**
 * this class is a listener in charge to manage double on element of the model explorer
 *
 */
public class DoubleClickListener implements IDoubleClickListener {

	private final Supplier<ServicesRegistry> servicesRegistry;

	/**
	 * Initializes me with a fixed service registry.
	 *
	 * @param servicesRegistry
	 *            a service registry
	 *
	 * @deprecated The editor that the Model Explorer views can change dynamically, replacing its service registry. Use the {@link #DoubleClickListener(Supplier)} constructor instead to account for the variability of the registry.
	 */
	@Deprecated
	public DoubleClickListener(ServicesRegistry servicesRegistry) {
		this(Suppliers.ofInstance(servicesRegistry));
	}

	/**
	 * Initializes me with a variable service registry.
	 *
	 * @param servicesRegistrySupplier
	 *            a supplier of a dynamically variable service registry
	 */
	public DoubleClickListener(Supplier<ServicesRegistry> servicesRegistrySupplier) {
		this.servicesRegistry = servicesRegistrySupplier;
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.IDoubleClickListener#doubleClick(org.eclipse.jface.viewers.DoubleClickEvent)
	 *
	 */
	@Override
	public void doubleClick(DoubleClickEvent event) {
		ISelection selection = event.getSelection();
		final IPageManager pageManager;
		// get the page Manager
		try {
			pageManager = ServiceUtils.getInstance().getService(IPageManager.class, servicesRegistry.get());
		} catch (Exception e) {
			Activator.log.error("Impossibility to load the page manager", e);//$NON-NLS-1$
			return;
		}

		if (pageManager != null) {
			if (selection instanceof IStructuredSelection) {
				Iterator<?> iter = ((IStructuredSelection) selection).iterator();
				final List<EObject> pagesToOpen = new LinkedList<EObject>();
				EObject pageToSelect = null;
				while (iter.hasNext()) {
					Object currentObject = iter.next();
					EObject diag = EMFHelper.getEObject(currentObject);

					if (isPage(diag, pageManager)) {
						// Note that Diagram migration is triggered by the Diagram Editor.
						// Try to open the diagram, even if it is currently invalid. The editor might be able to repair it
						if (pageManager.isOpen(diag)) {
							pageToSelect = diag;
						} else {
							pagesToOpen.add(diag);
						}
					}
				}

				if (!pagesToOpen.isEmpty()) {
					for (EObject page : pagesToOpen) {
						pageManager.openPage(page);
					}
				} else if (pageToSelect != null) {
					pageManager.selectPage(pageToSelect);
				}
			}

		}
	}

	protected boolean isPage(EObject element, IPageManager pageManager) {
		if (pageManager.allPages().contains(element)) {
			return true;
		}

		Object openable = Platform.getAdapterManager().getAdapter(element, IOpenable.class);
		return openable instanceof IOpenable;
	}
}
