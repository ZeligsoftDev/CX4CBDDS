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
package com.zeligsoft.domain.idl3plus.ui.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.domain.idl3plus.ui.l10n.Messages;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;

/**
 * Action to repair a module instantiation when the instantiated template module
 * has changed.
 *
 * @author Toby McClean (tmcclean)
 *
 */
public class RepairModuleInstantiationActionHandler extends AbstractHandler {

	protected Element element;

	/**
	 * Construct me.
	 */
	public RepairModuleInstantiationActionHandler() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.actions.ActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		element = (Element) BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());

		if (element == null) {
			return null;
		}

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
		Command editCommand = new RecordingCommand(domain, "Repair module instantiation" //$NON-NLS-1$
		) {

			public void doExecute() {
				IDL3PlusUtil.INSTANCE.repairTemplateModuleInstantiation(element);
			}
		};

		IRunnableWithProgress runnable = new IRunnableWithProgress() {

			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

				monitor.beginTask(Messages.RepairAllModuleInstantiationsAction_TaskName, IProgressMonitor.UNKNOWN);
				if (editCommand.canExecute()) {
					domain.getCommandStack().execute(editCommand);
				}
				monitor.done();
			}
		};

		try {
			new ProgressMonitorDialog(null).run(false, false, runnable);
		} catch (InvocationTargetException e) {
		} catch (InterruptedException e) {
		}

		return null;
	}
}
