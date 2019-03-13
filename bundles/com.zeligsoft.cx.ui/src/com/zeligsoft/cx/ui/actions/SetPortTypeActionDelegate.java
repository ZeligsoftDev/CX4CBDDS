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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.dialogs.ZDLElementSelectionDialog;
import com.zeligsoft.cx.ui.filters.ElementSelectionFilter;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Action to set the portType of the port
 * 
 * @author Young-Soo Roh (ysroh)
 * 
 */
public class SetPortTypeActionDelegate implements IObjectActionDelegate {

	private List<EObject> selectedEObjects;

	@Override
	@SuppressWarnings("unchecked")
	public void run(IAction action) {

		if (selectedEObjects.isEmpty()) {
			return;
		}

		ElementSelectionFilter filter = new ElementSelectionFilter(ZMLMMNames.PORT,
				ZMLMMNames.TYPED_ELEMENT__TYPE);
		filter.addConceptsToFilter(getPortTypeableConcepts());

		final ZDLElementSelectionDialog dialog = new ZDLElementSelectionDialog(Display
				.getCurrent().getActiveShell(),
				Messages.SetPortTypeActionDelegate_DialogTitle, selectedEObjects.get(0),
				Collections.EMPTY_LIST, true, true);
		dialog.setElementFilter(filter);

		int result = dialog.open();
		if (result == Window.OK) {
			if (!dialog.getSelectedElements().isEmpty()) {
				EObject eObject = (EObject) dialog.getSelectedElements()
						.getFirstElement();
				setPortType(eObject);
			}
		}
	}

	/**
	 * Queries allowed port types.
	 * 
	 * @return
	 */
	protected List<String> getPortTypeableConcepts() {
		List<String> concepts = new ArrayList<String>();
		concepts.add(ZMLMMNames.PORT_TYPE);

		return concepts;
	}

	/**
	 * Set port type of the selected port
	 * 
	 * @param portType
	 */
	private void setPortType(final EObject portType) {
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(portType),
				Messages.SetPortTypeActionDelegate_SetPortTypeCommandLabel, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {

				for (EObject eo : selectedEObjects) {
					if (ZDLUtil.isZDLConcept(eo, ZMLMMNames.PORT)) {
						ZDLUtil.setValue(eo, ZMLMMNames.PORT,
								ZMLMMNames.TYPED_ELEMENT__TYPE, portType);
					}
				}

				return CommandResult.newOKCommandResult();
			}

		};

		try {
			OperationHistoryFactory.getOperationHistory().execute(command, null, null);
		} catch (ExecutionException e) {
			ZeligsoftCXUIPlugin.getDefault().error(
					Messages.SetPortTypeActionDelegate_SetPortTypeFailedLog, e);
		}

	}

	@Override
	public void selectionChanged(IAction action, final ISelection selection) {

		if (selection == null || action == null) {
			action.setEnabled(false);
			return;
		}

		if (isValidPortSelection(selection)) {
			action.setEnabled(true);
		} else {
			action.setEnabled(false);
		}
	}

	/**
	 * Check that the current selection is a valid port
	 * 
	 * @param ISelection
	 *            selection
	 * @return boolean isValidPortSelection
	 */
	private boolean isValidPortSelection(ISelection selection) {

		selectedEObjects = BaseUIUtil.getEObjectsFromSelection(selection);
		if (selectedEObjects.isEmpty()) {
			return false;
		}
		for (EObject eo : selectedEObjects) {

			if (ZDLUtil.isZDLConcept(eo, ZMLMMNames.PORT)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// do nothing
	}

}
