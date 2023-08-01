/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
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
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Use of a paste strategies
 *  Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Use the Copy Strategies
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.DefaultCopyCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.IStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.copy.CopyStrategyManager;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.copy.ICopyStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.PasteStrategyManager;
import org.eclipse.papyrus.infra.ui.command.AbstractCommandHandler;

/**
 * Handler for the Copy Action
 */
public class CopyHandler extends AbstractCommandHandler {

	/**
	 * Check if the selection allow copy
	 *
	 * @param selectedElements
	 * @return
	 */
	public static boolean isCopyEnabled(Collection<EObject> selectedElements) {
		return !getElementsToPutInClipboard(selectedElements).isEmpty();
	}

	protected static List<EObject> getElementsToPutInClipboard(Collection<EObject> selectedElements) {
		List<EObject> elementsInClipboard = new ArrayList<EObject>(selectedElements);
		List<IStrategy> allStrategies = CopyStrategyManager.getInstance().getAllStrategies();
		for (IStrategy iStrategy : allStrategies) {
			ICopyStrategy iCopyStrategy = (ICopyStrategy) iStrategy;
			iCopyStrategy.prepareElementsInClipboard(elementsInClipboard, selectedElements);
		}
		return elementsInClipboard;
	}

	/**
	 * Construct copy command from the selection
	 *
	 * @param editingDomain
	 * @param selectedElements
	 * @return
	 */
	public static Command buildCopyCommand(TransactionalEditingDomain editingDomain, Collection<EObject> selectedElements) {
		PapyrusClipboard<Object> papyrusClipboard = PapyrusClipboard.getNewInstance();
		DefaultCopyCommand defaultCopyCommand = new DefaultCopyCommand(editingDomain, papyrusClipboard, getElementsToPutInClipboard(selectedElements));
		List<IStrategy> allStrategies = PasteStrategyManager.getInstance().getAllStrategies();
		for (IStrategy iStrategy : allStrategies) {
			IPasteStrategy iPasteStrategy = (IPasteStrategy) iStrategy;
			iPasteStrategy.prepare(papyrusClipboard, selectedElements);
		}
		return defaultCopyCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCommand(final IEvaluationContext context) {
		return buildCopyCommand(getEditingDomain(context), getSelectedElements());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean computeEnabled(final IEvaluationContext context) { // copy is enable as long as there is an EObject to put in the Clipboard
		return isCopyEnabled(getSelectedElements());
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEnabled(final Object evaluationContext) {
		PapyrusClipboard<Object> instance = PapyrusClipboard.getInstance();
		super.setEnabled(evaluationContext); // setenabled should'nt clear/modify the clipboard
		PapyrusClipboard.setInstance(instance);
	}

}
