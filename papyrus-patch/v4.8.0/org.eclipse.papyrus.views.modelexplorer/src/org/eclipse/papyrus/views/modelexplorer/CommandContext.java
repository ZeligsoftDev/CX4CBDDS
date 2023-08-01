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
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Context holder for model element creation commands.
 */
public class CommandContext implements ICommandContext {

	private EObject container;

	private EReference reference;

	/** Constructor */
	public CommandContext(EObject container) {
		this.container = container;
	}

	/** Constructor */
	public CommandContext(EObject container, EReference reference) {
		this.container = container;
		this.reference = reference;
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject getContainer() {
		return container;
	}

	/**
	 * {@inheritDoc}
	 */
	public EReference getReference() {
		return reference;
	}
}
