/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Gabriel Pascual - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.message.xtext.ui.contributions;

import org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.IDirectEditorConstraint;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.MessageNameEditPart;

/**
 * Direct Editor constraint for Message of Communication diagram.
 *
 * @author Gabriel Pascual
 *
 */
public class AdvancedMessageDirectEditorConstraint implements IDirectEditorConstraint {

	/** The Constant CONSTRAINT_LABEL. */
	private static final String CONSTRAINT_LABEL = "Advanced Message Editor Constraint";

	/**
	 * Constructor.
	 *
	 */
	public AdvancedMessageDirectEditorConstraint() {
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.IDirectEditorConstraint#getLabel()
	 *
	 * @return
	 */
	@Override
	public String getLabel() {
		return CONSTRAINT_LABEL;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.IDirectEditorConstraint#appliesTo(java.lang.Object)
	 *
	 * @param selection
	 * @return
	 */
	@Override
	public boolean appliesTo(Object selection) {

		// The selection must be an Message edit part of Communication diagram
		return selection instanceof MessageNameEditPart;
	}

}
