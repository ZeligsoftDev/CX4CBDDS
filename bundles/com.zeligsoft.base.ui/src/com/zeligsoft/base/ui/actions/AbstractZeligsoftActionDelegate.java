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
package com.zeligsoft.base.ui.actions;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.ui.action.AbstractModelActionDelegate;
import org.eclipse.ui.IViewActionDelegate;

import com.zeligsoft.base.ui.utils.BaseUIUtil;


/**
 * 
 *
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractZeligsoftActionDelegate
		extends AbstractModelActionDelegate
		implements IViewActionDelegate {

	/**
	 * Initializes me.
	 */
	public AbstractZeligsoftActionDelegate() {
		super();
	}

	/**
	 * Obtains a command to perform the action on the selected model element.
	 * 
	 * @return the command to be executed
	 */
	protected abstract ICommand getCommand();
	
	@Override
	protected TransactionalEditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(getSelectedElement());
	}

	protected EObject getSelectedElement() {
		if (getStructuredSelection() == null
			|| getStructuredSelection().isEmpty()) {
			return null;
		}
		EObject selection = (EObject) ((IAdaptable) getStructuredSelection()
			.getFirstElement()).getAdapter(EObject.class);
		return selection;

	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		ICommand command = getCommand();

		if (command == null || !command.canExecute())
			return;

		execute(command, progressMonitor, null);

		CommandResult result = command.getCommandResult();

		if (result != null) {
			BaseUIUtil.startInLineEdit((EObject) result
				.getReturnValue());
		}

	}

}
