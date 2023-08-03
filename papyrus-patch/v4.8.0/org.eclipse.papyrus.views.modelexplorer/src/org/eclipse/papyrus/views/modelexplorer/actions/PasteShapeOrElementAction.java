/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.actions;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.PasteAction;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Action used for pasting either a model element or a shape (i.e. the model element reprented
 * by the shape). Delegates to PasteShapeOrElementCommand
 *
 * @author Ansgar Radermacher (CEA LIST)
 */
public class PasteShapeOrElementAction extends PasteAction
{
	public PasteShapeOrElementAction(EditingDomain domain) {
		super(domain);
	}

	@Override
	public Command createCommand(Collection<?> selection)
	{
		if ((selection.size() == 1) && (domain != null)) {
			Object owner = selection.iterator().next();

			boolean onlyViewsInClipboard = true;
			boolean foundView = false;
			if (domain.getClipboard() != null) {
				for (Object clipObject : domain.getClipboard()) {
					if (clipObject instanceof View) {
						foundView = true;
					}
					else {
						onlyViewsInClipboard = false;
					}
				}
			}
			// TODO: currently only works for a single element to be copied.
			if (onlyViewsInClipboard && foundView) {
				View shape = (View) domain.getClipboard().iterator().next();
				return AddCommand.create(domain, owner, null, shape.getElement());
			}
		}
		return super.createCommand(selection);
	}
}
