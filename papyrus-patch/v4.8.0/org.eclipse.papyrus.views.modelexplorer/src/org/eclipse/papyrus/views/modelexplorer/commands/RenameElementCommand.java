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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.emf.gmf.command.ICommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.ui.command.InteractiveCommandWrapper;
import org.eclipse.swt.widgets.Display;

/**
 * Command to rename an element.
 * @since 3.0
 */
public class RenameElementCommand extends InteractiveCommandWrapper {

	/**
	 * The editing domain.
	 */
	private TransactionalEditingDomain editingDomain = null;

	/**
	 * The element to be renamed.
	 */
	private EObject element = null;

	/**
	 * The current name of element.
	 */
	private String currentElementName = null;

	/**
	 * The structural feature of name.
	 */
	private EStructuralFeature nameStructuralFeature = null;

	/**
	 * The input dialog title.
	 */
	private String dialogTitle = null;

	/**
	 * The input dialog message.
	 */
	private String dialogMessage = null;

	/**
	 * Default constructor.
	 *
	 * @param editingDomain
	 *            The editing domain
	 * @param commandLabel
	 *            The command label
	 * @param element
	 *            The named element
	 * @param currentElementName
	 *            The current element name
	 * @param nameStructuralFeature
	 *            The name structural feature
	 * @param dialogTitle
	 *            The dialog title
	 * @param dialogMessage
	 *            The dialog message
	 */
	public RenameElementCommand(final TransactionalEditingDomain editingDomain, final String commandLabel, final EObject element, final String currentElementName, final EStructuralFeature nameStructuralFeature, final String dialogTitle,
			final String dialogMessage) {
		super(commandLabel);
		this.editingDomain = editingDomain;
		this.element = element;
		this.currentElementName = currentElementName;
		this.nameStructuralFeature = nameStructuralFeature;
		this.dialogTitle = dialogTitle;
		this.dialogMessage = dialogMessage;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command createCommand() {
		Command result = UnexecutableCommand.INSTANCE;

		InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), this.dialogTitle, this.dialogMessage, this.currentElementName, null);

		// Check parameters before opening the input dialog
		if (null != this.editingDomain && null != this.element && null != this.nameStructuralFeature && Window.OK == dialog.open()) {
			String newName = dialog.getValue();

			if (null != newName && !newName.isEmpty() && !newName.equals(this.currentElementName)) {
				IElementEditService edit = ElementEditServiceUtils.getCommandProvider(this.element);

				SetRequest request = new SetRequest(this.editingDomain, this.element, this.nameStructuralFeature, newName);
				if (edit.canEdit(request)) {
					result = ICommandWrapper.wrap(edit.getEditCommand(request), Command.class);
				}
			}
		}

		return result;
	}
}
