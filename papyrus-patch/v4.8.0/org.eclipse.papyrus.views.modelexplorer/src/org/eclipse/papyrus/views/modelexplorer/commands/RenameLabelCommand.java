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
package org.eclipse.papyrus.views.modelexplorer.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.views.modelexplorer.messages.Messages;
import org.eclipse.swt.widgets.Display;

/**
 * Command to rename a label of an element.
 */
public abstract class RenameLabelCommand extends AbstractTransactionalCommand {

	/**
	 * The element whose label will be renamed.
	 */
	private EObject element = null;

	/**
	 * The current element label.
	 */
	private String currentElementLabel = null;

	/**
	 * The input dialog title.
	 */
	private String dialogTitle = null;

	/**
	 * Default constructor.
	 *
	 * @param editingDomain
	 *            The editing domain
	 * @param commandLabel
	 *            The command label
	 * @param element
	 *            The element whose label is renamed
	 * @param currentElementLabel
	 *            The current element label
	 * @param dialogTitle
	 *            The dialog title
	 */
	public RenameLabelCommand(final TransactionalEditingDomain editingDomain, final String commandLabel, final EObject element, final String currentElementLabel, final String dialogTitle) {
		super(editingDomain, commandLabel, null);
		this.element = element;
		this.currentElementLabel = currentElementLabel;
		this.dialogTitle = dialogTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), this.dialogTitle, Messages.RenameLabelCommand_DialogMessage, this.currentElementLabel, null);

		if (Window.OK == dialog.open()) {
			final String newLabel = dialog.getValue();
			if (null != newLabel && !newLabel.equals(this.currentElementLabel)) {
				renameLabel(this.element, newLabel);
			}
			return CommandResult.newOKCommandResult();
		} else {
			return CommandResult.newCancelledCommandResult();
		}
	}

	/**
	 * Rename the label of an element.
	 * 
	 * @param element
	 *            The element
	 * @param newLabel
	 *            The new label
	 */
	protected abstract void renameLabel(final EObject element, final String newLabel);
}
