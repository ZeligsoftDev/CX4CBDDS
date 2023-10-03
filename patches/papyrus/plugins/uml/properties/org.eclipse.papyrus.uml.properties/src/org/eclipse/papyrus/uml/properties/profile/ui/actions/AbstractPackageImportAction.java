/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *  Ansgar Radermacher (CEA LIST) Ansgar.Radermacher@cea.fr - minor modifications
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.actions;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IViewPart;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Package;

/**
 * Abstract command for all package import for registered elements actions
 */
public abstract class AbstractPackageImportAction extends AbstractViewActionDelegate {

	/** current selection */
	protected Package selectedElement;

	/** stored instance of the command */
	protected ChangeCommand command;

	@Override
	public void init(IViewPart view) {
		super.init(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Package getSelectedElement() {
		return selectedElement;
	}

	/**
	 * Returns <code>true</code> if the element is a Package
	 *
	 * @param element
	 *            the element to test
	 * @return <code>true</code> if the element is a Package
	 */
	@Override
	protected boolean isSelectableElement(Object element) {
		return (element instanceof Package);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSelectedElement(Object selectedElement) {
		if (selectedElement instanceof Package) {
			this.selectedElement = (Package) selectedElement;
		}
		else {
			this.selectedElement = null;
		}
	}

	/**
	 * Returns <code>true</code> if the action can be executed
	 *
	 * @return <code>true</code> if the action can be executed
	 */
	public boolean canExecute() {
		if (selectedElement != null) {
			EditingDomain editingDomain = TransactionUtil.getEditingDomain(selectedElement);
			return getCommand(editingDomain).canExecute();
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run(IAction action) {
		if (selectedElement != null) {
			EditingDomain editingDomain = TransactionUtil.getEditingDomain(selectedElement);
			CommandStack stack = editingDomain.getCommandStack();
			stack.execute(getCommand(editingDomain));
		}
	}

	/**
	 * returns the command that is executed by this action.
	 *
	 * @param domain
	 *            EMF editing domain used by the command
	 * @return the command that is executed by this action
	 */
	public abstract ChangeCommand getCommand(EditingDomain domain);
}
