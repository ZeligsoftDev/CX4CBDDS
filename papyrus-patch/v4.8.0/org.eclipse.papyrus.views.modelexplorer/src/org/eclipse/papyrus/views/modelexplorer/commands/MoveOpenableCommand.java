/*****************************************************************************
 * Copyright (c) 2012 Atos .
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
 * Arthur daussy - arthur.daussy@atos.net - 374607: [model explorer] moving a model element in another model does not move associated diagrams
 *
 **/
package org.eclipse.papyrus.views.modelexplorer.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

/**
 * Command to move a diagram from a resource to another
 *
 * @author arthur daussy
 *
 */
public class MoveOpenableCommand extends AbstractTransactionalCommand {
	/**
	 * Containing resource
	 */
	private Resource newContainingRessource;
	/**
	 * The diagram to move
	 */
	private EObject diagram;

	public MoveOpenableCommand(TransactionalEditingDomain domain, String label, EObject diagram, Resource newContainingRessource) {
		super(domain, label, null);
		this.diagram = diagram;
		this.newContainingRessource = newContainingRessource;
		/*
		 * set modified list file
		 */
		List<?> notations = getWorkspaceFiles(diagram);
		getAffectedFiles().addAll(notations);
		getAffectedFiles().add(WorkspaceSynchronizer.getFile(newContainingRessource));
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (newContainingRessource != null) {
			newContainingRessource.getContents().add(diagram);
			return CommandResult.newOKCommandResult();
		} else {
			return CommandResult.newErrorCommandResult("The new resource to add the diagram is null");////$NON-NLS-1$
		}
	}
}
