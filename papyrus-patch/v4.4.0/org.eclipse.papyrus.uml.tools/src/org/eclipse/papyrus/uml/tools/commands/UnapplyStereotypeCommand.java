/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.commands;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * A Command to unapply a Stereotype on a UML Element
 *
 * @author Camille Letavernier
 */
public class UnapplyStereotypeCommand extends RecordingCommand {

	private Element element;

	private Collection<Stereotype> stereotypes;

	/**
	 *
	 * Constructor.
	 *
	 * @param element
	 *            The UML Element from which the stereotypes will be unapplied
	 * @param stereotypes
	 *            The stereotypes to unapply
	 */
	public UnapplyStereotypeCommand(Element element, Collection<Stereotype> stereotypes, TransactionalEditingDomain domain) {
		super(domain);
		this.element = element;
		this.stereotypes = stereotypes;
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param element
	 *            The UML Element from which the stereotype will be unapplied
	 * @param stereotype
	 *            The stereotype to unapply
	 */
	public UnapplyStereotypeCommand(Element element, Stereotype stereotype, TransactionalEditingDomain domain) {
		super(domain);
		this.element = element;
		this.stereotypes = Collections.singletonList(stereotype);
	}

	@Override
	protected void doExecute() {
		for (Stereotype stereotype : stereotypes) {
			element.unapplyStereotype(stereotype);
		}
	}

}
