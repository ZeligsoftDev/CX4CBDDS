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
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
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
public class SetPortTypeActionDelegate extends AbstractHandler{

	private List<EObject> selectedEObjects;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		selectedEObjects = BaseUIUtil.getEObjectsFromSelection(BaseUIUtil.getSelection());

		ElementSelectionFilter filter = new ElementSelectionFilter(ZMLMMNames.PORT,
				ZMLMMNames.TYPED_ELEMENT__TYPE);
		filter.addConceptsToFilter(getPortTypeableConcepts());

		final ZDLElementSelectionDialog dialog = new ZDLElementSelectionDialog(Display
				.getCurrent().getActiveShell(),
				Messages.SetPortTypeActionDelegate_DialogTitle, selectedEObjects.get(0),
				new ArrayList<String>(), true, true);
		dialog.setElementFilter(filter);

		int result = dialog.open();
		if (result == Window.OK) {
			if (!dialog.getSelectedElements().isEmpty()) {
				EObject eObject = (EObject) dialog.getSelectedElements()
						.getFirstElement();
				setPortType(eObject);
			}
		}
		
		return null;
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
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(portType);
		Command command = new RecordingCommand(domain
				,
				Messages.SetPortTypeActionDelegate_SetPortTypeCommandLabel, null) {

			@Override
			protected void doExecute() {

				for (EObject eo : selectedEObjects) {
					if (ZDLUtil.isZDLConcept(eo, ZMLMMNames.PORT)) {
						ZDLUtil.setValue(eo, ZMLMMNames.PORT,
								ZMLMMNames.TYPED_ELEMENT__TYPE, portType);
					}
				}
			}

		};

		if(command.canExecute()) {
			domain.getCommandStack().execute(command);
		}
	}
}
