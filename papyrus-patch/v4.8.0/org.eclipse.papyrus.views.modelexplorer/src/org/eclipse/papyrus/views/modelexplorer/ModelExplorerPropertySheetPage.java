/*****************************************************************************
 * Copyright (c) 2014 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *   Christian W. Damus - bug 454536
 *
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer;

import java.util.Iterator;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.operation.DelegatingUndoContext;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.AdapterUtils;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.MultiViewPageBookView;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.ViewPartPage;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.Iterators;

/**
 * Specific PropertySheetPage for Model Explorer view to contribute to Undo/Redo Edit menu.
 *
 * @author Gabriel Pascual
 *
 */
class ModelExplorerPropertySheetPage extends TabbedPropertySheetPage implements IPageBookViewPageListener {
	private final ModelExplorerPageBookView modelExplorer;

	/** The undo. */
	private UndoActionHandler undo = null;

	/** The redo. */
	private RedoActionHandler redo = null;

	/** The undo context. */
	private DelegatingUndoContext undoContext = null;

	/**
	 * Constructor.
	 *
	 * @param modelExplorer
	 *            the Model Explorer view that owns me
	 */
	public ModelExplorerPropertySheetPage(ModelExplorerPageBookView modelExplorer) {
		super(modelExplorer);

		this.modelExplorer = modelExplorer;
		modelExplorer.addPageListener(this);
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage#setActionBars(org.eclipse.ui.IActionBars)
	 *
	 * @param actionBars
	 */
	@Override
	public void setActionBars(IActionBars actionBars) {
		super.setActionBars(actionBars);

		undoContext = new DelegatingUndoContext.Dynamic(new Supplier<IUndoContext>() {

			public IUndoContext get() {
				return AdapterUtils.adapt(modelExplorer, IUndoContext.class, null);
			}
		});

		undo = new UndoActionHandler(getSite().getPage().getActivePart().getSite(), undoContext);
		redo = new RedoActionHandler(getSite().getPage().getActivePart().getSite(), undoContext);

		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undo);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redo);
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage#dispose()
	 *
	 */
	@Override
	public void dispose() {
		modelExplorer.removePageListener(this);

		if (undo != null) {
			undo.dispose();
		}
		if (redo != null) {
			redo.dispose();
		}

		super.dispose();
	}

	public void pageActivated(MultiViewPageBookView pageBookView, ViewPartPage page) {
		// Ensure that I am showing the up-to-date selection
		selectionChanged(modelExplorer, pageBookView.getSite().getSelectionProvider().getSelection());
	}

	public void pageClosing(MultiViewPageBookView pageBookView, ViewPartPage page) {
		if (isSelectionUnloading((ServicesRegistry) page.getAdapter(ServicesRegistry.class))) {
			// Forget the selection because it is now invalid and we don't want to show it when next the Model Explorer is activated
			selectionChanged(modelExplorer, StructuredSelection.EMPTY);
		}
	}

	/**
	 * Queries whether the current selection includes any element from a resource in the context of the specified {@code context} that is being unloaded.
	 *
	 * @param context
	 *            the service registry context of an editor that is being unloaded
	 * @return whether any currently presented input element has already been unloaded (is now a proxy) or is in the given {@code context}
	 */
	private boolean isSelectionUnloading(final ServicesRegistry context) {
		boolean result = false;

		ISelection currentSelection = getCurrentSelection();
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) currentSelection;
			result = Iterators.any((Iterator<?>) selection.iterator(), new Predicate<Object>() {
				public boolean apply(Object input) {
					try {
						EObject eObject = EMFHelper.getEObject(input);
						return (eObject != null) && (eObject.eIsProxy() || (ServiceUtilsForEObject.getInstance().getServiceRegistry(eObject) == context));
					} catch (ServiceException e) {
						// We won't try to get the registry for an element that is already unloaded (short-circuit 'or')
						return false;
					}
				}
			});
		}

		return result;
	}
}
