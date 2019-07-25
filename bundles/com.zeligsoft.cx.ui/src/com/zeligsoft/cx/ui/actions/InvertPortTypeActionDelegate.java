/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.cx.ui.actions;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Action to change a port's port type to the port type inverse.
 * 
 * @author schafe
 * 
 */
public class InvertPortTypeActionDelegate
		implements IObjectActionDelegate {

	protected ISelection selection;

	protected IWorkbenchPart activePart;

	/**
	 * Get the current selection.
	 * 
	 * @return ISelection currentSelection
	 */
	protected ISelection getSelection() {
		return this.selection;
	}

	/**
	 * Get the active part.
	 * 
	 * @return IWorkbenchPart activePart
	 */
	protected IWorkbenchPart getActivePart() {
		return this.activePart;
	}

	@Override
	public void run(IAction action) {

		ICommand invertCommands = new CompositeCommand(
			Messages.InvertPortTypeActionDelegate_InvertPortTypesCommandLabel);

		List<EObject> eObjects = getSelectedEObjects();
		for (int i = 0; i < eObjects.size(); i++) {
			EObject selectedEObject = eObjects.get(i);

			if (!(selectedEObject instanceof Port)) {
				continue;
			}

			Port port = (Port) selectedEObject;
			Type portType = port.getType();
			if (portType == null) {
				continue;
			}

			Type inversePortType = getValidPortTypeInverse(portType);
			if (inversePortType == null) {
				continue;
			}

			TransactionalEditingDomain domain = TransactionUtil
				.getEditingDomain(selectedEObject);

			ICommand changePortTypeCommand = getChangePortTypeCommand(domain,
				port, inversePortType);
			invertCommands.compose(changePortTypeCommand);
		}

		try {
			OperationHistoryFactory.getOperationHistory().execute(
				invertCommands, null, null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Get the ICommand that will set a port's type to be the new type.
	 * 
	 * @param TransactionEditingDomain
	 *            domain
	 * @param Port
	 *            port
	 * @param Type
	 *            newType
	 * @return ICommand command
	 */
	private ICommand getChangePortTypeCommand(
			TransactionalEditingDomain domain, Port port, Type newType) {

		final TransactionalEditingDomain finalDomain = domain;
		final Port finalPort = port;
		final Type finalNewType = newType;

		AbstractTransactionalCommand changePortTypeCommand = new AbstractTransactionalCommand(
			finalDomain,
			Messages.InvertPortTypeActionDelegate_ChangePortTypeCommandLabel,
			null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				finalPort.setType(finalNewType);

				return CommandResult.newOKCommandResult();
			}

		};
		return changePortTypeCommand;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IWorkbenchPart)
	 */
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.activePart = targetPart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, final ISelection selection) {
		this.selection = selection;

		if (isValidPortSelection(selection)) {
			action.setEnabled(true);
		} else {
			action.setEnabled(false);
		}
	}

	/**
	 * Get a list of selected eObjects.
	 * 
	 * @return List<EObjects>
	 */
	private List<EObject> getSelectedEObjects() {
		return BaseUIUtil.getEObjectsFromSelection(getSelection());
	}

	/**
	 * Get a portType's inverse type. Ensure that the inverse is a valid zdl
	 * port type.
	 * 
	 * @param Type
	 *            portType
	 * @return Object validPortType
	 */
	protected Type getValidPortTypeInverse(Type portType) {

		// Check that the port's portType is a zdl concept PORT_TYPE
		if (ZDLUtil.isZDLConcept(portType, ZMLMMNames.PORT_TYPE)) {

			// Get the inverse port type
			Object inversePortType = ZDLUtil.getValue(portType,
				ZMLMMNames.PORT_TYPE, ZMLMMNames.PORT_TYPE__INVERSE);

			// Check that the inverse port type exists, and is
			// of zdl concept PORT_TYPE
			if ((inversePortType != null)
				&& (ZDLUtil.isZDLConcept((EObject) inversePortType,
					ZMLMMNames.PORT_TYPE))) {
				return (Type) inversePortType;
			}
		}
		return null;
	}

	/**
	 * Check that the current selection is a valid port, with a valid port type
	 * and inverse port type.
	 * 
	 * @param ISelection
	 *            selection
	 * @return boolean isValidPortSelection
	 */
	private boolean isValidPortSelection(ISelection selection) {

		List<EObject> eObjects = getSelectedEObjects();
		for (int i = 0; i < eObjects.size(); i++) {
			EObject selectedEObject = eObjects.get(i);
			if (!(selectedEObject instanceof Port)) {
				return false;
			}

			Port port = (Port) selectedEObject;
			Type portType = port.getType();
			if (portType == null) {
				return false;
			}

			Type inversePortType = getValidPortTypeInverse(portType);
			if (inversePortType == null) {
				return false;
			}
		}
		return true;
	}

}
