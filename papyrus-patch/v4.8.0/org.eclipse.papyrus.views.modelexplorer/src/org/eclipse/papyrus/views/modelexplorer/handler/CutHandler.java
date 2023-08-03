/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.handler;

import java.util.List;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.ui.command.AbstractCommandHandler;;

/**
 * Handler for the Cut Action in Model Explorer : it's a copy followed by a delete
 *
 */
public class CutHandler extends AbstractCommandHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCommand(final IEvaluationContext context) {
		CompoundCommand cutInModelExplorerCommand = new CompoundCommand("Cut in Model Explorer Command"); //$NON-NLS-1$
		Command copyCommand = CopyHandler.buildCopyCommand(getEditingDomain(context), getSelectedElements());
		cutInModelExplorerCommand.append(copyCommand);
		Command deleteCommand = DeleteCommandHandler.buildDeleteCommand(getSelectedElements());
		cutInModelExplorerCommand.append(deleteCommand);
		return cutInModelExplorerCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean computeEnabled(final IEvaluationContext context) {
		List<EObject> selectedElements = getSelectedElements();
		return CopyHandler.isCopyEnabled(selectedElements) && DeleteCommandHandler.isDeleteEnabled(selectedElements);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEnabled(final Object evaluationContext) {
		PapyrusClipboard<Object> instance = PapyrusClipboard.getInstance();
		super.setEnabled(evaluationContext); // setEnabled should'nt clear/modify the clipboard
		PapyrusClipboard.setInstance(instance);
	}

}
