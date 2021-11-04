/*****************************************************************************
 * Copyright (c) 2014, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 502461
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A Command to apply a rename on a UML Element
 */
public class RenameElementCommand extends RecordingCommand {

	private final TransactionalEditingDomain domain;

	private final NamedElement element;

	private final String name;

	/**
	 *
	 * Constructor.
	 *
	 * @param namedElement
	 *            The UML Element w
	 * @param stereotypes
	 *            The stereotypes to apply
	 */
	public RenameElementCommand(TransactionalEditingDomain domain, NamedElement namedElement, String name) {
		super(domain);

		this.domain = domain;
		this.element = namedElement;
		this.name = name;
	}


	@Override
	protected void doExecute() {
		ICommand rename = null;

		// Try first to use the element edit service
		IElementEditService edit = ElementEditServiceUtils.getCommandProvider(element);
		if (edit != null) {
			rename = edit.getEditCommand(new SetRequest(domain, element, UMLPackage.Literals.NAMED_ELEMENT__NAME, name));
		}

		try {
			if ((rename != null) && rename.canExecute()) {
				try {
					rename.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					// Plan B
					element.setName(name);
					Activator.log.error(e);
				}
			} else {
				// Plan B
				element.setName(name);
			}
		} finally {
			if (rename != null) {
				rename.dispose();
			}
		}
	}

}
