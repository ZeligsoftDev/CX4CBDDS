/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.infra.gmfdiag.menu.handlers.AbstractGraphicalCommandHandler;
import org.eclipse.papyrus.infra.gmfdiag.menu.utils.DeleteActionUtil;

/**
 * Command handler for "Delete Selected Line" diagram menu.
 * 
 * @author Young-Soo Roh
 *
 */
public class DeleteSelectedLineCommandHandler extends AbstractGraphicalCommandHandler {

	private static final String DELETE_COMMAND_LABEL = "Delete From Model";

	@Override
	protected boolean computeEnabled() {
		return true;
	}

	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();

		if (editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}

		List<IGraphicalEditPart> editParts = getSelectedElements();
		if (editParts.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, DELETE_COMMAND_LABEL);

		Iterator<IGraphicalEditPart> it = editParts.iterator();
		while (it.hasNext()) {
			IGraphicalEditPart editPart = it.next();

			if (!(editPart instanceof DiagramEditPart)) {
				// Look for the GMF deletion command
				Command curCommand = null;
				if (org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil.isSemanticDeletion(editPart)) {
					curCommand = editPart.getCommand(new EditCommandRequestWrapper(new DestroyElementRequest(false)));
				} else {
					curCommand = DeleteActionUtil.getDeleteFromDiagramCommand(editPart);
				}
				if (curCommand != null) {
					command.compose(new CommandProxy(curCommand));
				}
			}
		}

		if (command.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		return new ICommandProxy(command);
	}

}
