/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.commands;

import java.util.Collections;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Dependency;

/**
 * This command is used to destroy Dependencies which have any supplier before the deletion of the Interface.
 */
public class DestroyDependencyWithoutSupplierCommand extends AbstractTransactionalCommand {

	/** the dependencies to test. */
	private Set<Dependency> dependencies;

	/** The provider. */
	private IElementEditService provider;

	/**
	 * Constructor.
	 *
	 * @param domain
	 *            the domain
	 * @param dependencies
	 *            the dependencies to test
	 * @param provider
	 *            the provider
	 */
	public DestroyDependencyWithoutSupplierCommand(TransactionalEditingDomain domain, Set<Dependency> dependencies, IElementEditService provider) {
		super(domain, "Destroy the empty elements", null); //$NON-NLS-1$
		this.dependencies = dependencies;
		this.provider = provider;
	}

	/**
	 * Constructor.
	 *
	 * @param domain
	 *            the domain
	 * @param dependency
	 *            the dependency
	 * @param provider
	 *            the provider
	 */
	public DestroyDependencyWithoutSupplierCommand(TransactionalEditingDomain domain, Dependency dependency, IElementEditService provider) {
		super(domain, "Destroy the empty elements", null); //$NON-NLS-1$
		this.dependencies = Collections.singleton(dependency);
		this.provider = provider;
	}

	/**
	 * Do execute with result.
	 *
	 * @param monitor
	 *            the monitor
	 * @param info
	 *            the info
	 * @return the command result
	 * @throws ExecutionException
	 *             the execution exception
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		CompositeCommand command = new CompositeCommand("Destroy relationship without suppliers"); //$NON-NLS-1$

		for (Dependency current : dependencies) {
			if (current.getSuppliers().isEmpty()) {
				DestroyElementRequest request = new DestroyElementRequest(getEditingDomain(), current, false);
				ICommand cmd = getCommand(request);
				if (cmd.canExecute()) {
					command.add(cmd);
				}
			}
		}


		if (!command.isEmpty() && command.canExecute()) {
			command.execute(monitor, info);
		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Return the command corresponding to the request.
	 *
	 * @param req
	 *            a request
	 * @return the command corresponding to the request
	 */
	private ICommand getCommand(AbstractEditCommandRequest req) {

		if (provider != null) {
			ICommand setCommand = provider.getEditCommand(req);
			if (setCommand != null) {
				return setCommand.reduce();
			}
		}
		return UnexecutableCommand.INSTANCE;
	}
}
