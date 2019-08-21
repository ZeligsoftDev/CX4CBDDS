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

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.ui.Activator;
import com.zeligsoft.domain.idl3plus.ui.l10n.Messages;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;

/**
 * Action to repair all template module instantiations
 * 
 * @author Hua Guo (hguo)
 * 
 */
public class RepairAllModuleInstantiationsAction extends Action implements
		IAction, IObjectActionDelegate {

	protected EObject element;

	/**
	 * Construct me.
	 */
	public RepairAllModuleInstantiationsAction() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.actions.ActionDelegate#run(org.eclipse.jface.action.IAction
	 * )
	 */
	@Override
	public void run(IAction action) {
		if (element == null) {
			return;
		}

		final AbstractTransactionalCommand editCommand = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(element),
				Messages.RepairAllModuleInstantiationsAction_RepairAllCommandLabel,
				Collections.EMPTY_MAP, null) {

			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				if (element instanceof Package) {
					IDL3PlusUtil.INSTANCE
							.repairAllTemplateModuleInstantiations((Package) element);
				}
				return CommandResult.newOKCommandResult();
			}
		};

		Job job = new Job(Messages.RepairAllModuleInstantiationsAction_JobTitle) {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask(
						Messages.RepairAllModuleInstantiationsAction_TaskName,
						IProgressMonitor.UNKNOWN);
				try {
					editCommand.execute(monitor, null);
				} catch (ExecutionException e) {
					Activator
							.getDefault()
							.error(Messages.RepairAllModuleInstantiationsAction_ErrorRepairingAllModuleInstantiations,
									e);
				}
				monitor.done();
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action
	 * .IAction, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection == null || action == null) {
			action.setEnabled(false);
			return;
		}

		element = BaseUIUtil.getEObjectFromSelection(selection);
		if (element != null
				&& ZDLUtil.isZDLConcept(element, IDL3PlusNames.IDL3_PLUS_MODEL)) {
			action.setEnabled(true);
		} else {
			action.setEnabled(false);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.
	 * action.IAction, org.eclipse.ui.IWorkbenchPart)
	 */
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// do nothing
	}

}
