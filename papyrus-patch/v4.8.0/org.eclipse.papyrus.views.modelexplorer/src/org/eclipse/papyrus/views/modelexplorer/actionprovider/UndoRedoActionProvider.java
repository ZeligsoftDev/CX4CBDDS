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
 *   Christian W. Damus - bug 450536
 *
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer.actionprovider;

import java.util.EventObject;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;

/**
 * Action Provider to provide Redo/Undo action trough workbench menu.
 *
 * @author Gabriel Pascual
 *
 */
public class UndoRedoActionProvider extends AbstractCommonActionProvider implements CommandStackListener {


	/** The undo action. */
	private UndoActionHandler undoAction = null;

	/** The redo action. */
	private RedoActionHandler redoAction = null;

	/** Listened command stack. */
	private CommandStack commandStack;


	/**
	 * Instantiates a new undo redo action provider.
	 */
	public UndoRedoActionProvider() {
		super();
	}

	/**
	 * Gets the command stack.
	 *
	 * @return the command stack
	 */
	private CommandStack getCommandStack() {

		if (commandStack == null) {
			CommonNavigator navigator = getCommonNavigator();

			if (navigator instanceof IEditingDomainProvider) {
				EditingDomain editingDomain = ((IEditingDomainProvider) navigator).getEditingDomain();
				commandStack = editingDomain.getCommandStack();
			}

		}

		return commandStack;
	}

	@Override
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);

		ICommonViewerSite viewSite = aSite.getViewSite();
		if (viewSite instanceof ICommonViewerWorkbenchSite) {
			IWorkbenchPartSite partSite = ((ICommonViewerWorkbenchSite) viewSite).getSite();
			undoAction = new UndoActionHandler(partSite, getUndoContext());
			redoAction = new RedoActionHandler(partSite, getUndoContext());
		}

		getCommandStack().addCommandStackListener(this);

	}

	/**
	 * Gets the undo context.
	 *
	 * @return the undo context
	 */
	private IUndoContext getUndoContext() {
		IUndoContext context = null;

		CommonNavigator navigator = getCommonNavigator();
		if (navigator instanceof IAdaptable) {

			// Get undo context from navigator
			context = (IUndoContext) navigator.getAdapter(IUndoContext.class);
		}

		return context;
	}

	@Override
	public void fillActionBars(IActionBars actionBars) {

		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
	}

	/**
	 * <p>
	 * Synchronise handlers after a Command stack's change.
	 * </p>
	 *
	 * @see org.eclipse.emf.common.command.CommandStackListener#commandStackChanged(java.util.EventObject)
	 *
	 * @param event
	 */
	public void commandStackChanged(EventObject event) {

		// Refresh Undo handler after Command stack state has changed
		if (undoAction != null) {
			undoAction.update();
		}

		// Refresh Redo handler after Command stack state has changed
		if (redoAction != null) {
			redoAction.update();
		}

	}

	@Override
	public void dispose() {

		// Detach listener of command stack
		getCommandStack().removeCommandStackListener(this);
		commandStack = null;

		if (undoAction != null) {
			undoAction.dispose();
			undoAction = null;
		}
		if (redoAction != null) {
			redoAction.dispose();
			redoAction = null;
		}

		super.dispose();
	}
}
