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
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - bug 455305
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.ui.command.AbstractPapyrusHandler;

/**
 * Handler for the Undo Action
 *
 *
 *
 */
public class UndoHandler extends AbstractPapyrusHandler {

	/**
	 *
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EditingDomain domain = getEditingDomain(event);
		if (domain != null) {
			domain.getCommandStack().undo();
		}
		return null;
	}

	/**
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 *
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		EditingDomain domain;
		if (evaluationContext instanceof IEvaluationContext) {
			domain = getEditingDomain((IEvaluationContext) evaluationContext);
		} else {
			domain = getEditingDomain((IEvaluationContext) null);
		}

		if (null != domain) {
			setBaseEnabled(domain.getCommandStack().canUndo());
		} else {
			setBaseEnabled(false);
		}
	}

}
