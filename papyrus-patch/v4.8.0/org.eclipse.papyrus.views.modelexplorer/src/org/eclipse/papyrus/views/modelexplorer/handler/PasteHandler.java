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
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Use paste strategy
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - bug 455305
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.handler;

import java.util.List;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.IStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.PasteStrategyManager;
import org.eclipse.papyrus.infra.ui.command.AbstractCommandHandler;

/**
 * Handler for the Paste Action
 *
 */
public class PasteHandler extends AbstractCommandHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCommand(final IEvaluationContext context) {
		List<EObject> selection = getSelectedElements();

		List<IStrategy> allStrategies = PasteStrategyManager.getInstance()
				.getAllActiveStrategies();

		if (selection.size() == 1) { // Paste is only available on a simple selection
			CompoundCommand compoundCommand = new CompoundCommand();
			for (IStrategy iStrategy : allStrategies) {
				Command emfCommand = ((IPasteStrategy) iStrategy)
						.getSemanticCommand(getEditingDomain(context), selection.get(0), PapyrusClipboard.getInstance());
				if (emfCommand != null) {
					compoundCommand.append(emfCommand);
				}
			}
			return compoundCommand;
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean computeEnabled(final IEvaluationContext context) { // paste is only available on a simple selection and with a non empty Clipboard
		boolean isEnabled = false;

		if (!PapyrusClipboard.getInstance().isEmptyWithNoAdditionalData() && getSelectedElements().size() == 1) {
			isEnabled = !EMFHelper.isReadOnly(getSelectedElements().get(0));
		}

		return isEnabled;
	}
}
