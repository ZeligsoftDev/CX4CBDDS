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
package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Relationship;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMMigrationModelTypeUtil;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Refactoring model type.
 * 
 * @author smcfee
 *
 */
public class MigrateModelTypeAction 
	implements IViewActionDelegate {

		private ISelection selection;

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
		 */
		public void run(IAction action) {
			
			if(selection == null){
				return;
			}

			final EObject selObject = BaseUIUtil.getEObjectFromSelection(selection);
			if (selObject == null || !(selObject instanceof Model)) {
				return;
			}

			if (DDS4CCMMigrationModelTypeUtil.isMigrationRequired((Model) selObject)) {

				
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				IEditorReference[] editors = page.getEditorReferences();
				List<IEditorReference> editorsToBeClosed = new ArrayList<IEditorReference>();
				for (IEditorReference editor : editors) {
					if ("DEPLOYMENT_TREE_EDITOR_ID".equals(editor.getId())) {
						editorsToBeClosed.add(editor);
					}
				}
				if (!editorsToBeClosed.isEmpty()) {
					page.closeEditors(
							editorsToBeClosed.toArray(new IEditorReference[0]),
							true);
				}
				
				final AbstractTransactionalCommand migrationCommand = new AbstractTransactionalCommand(
						UMLModeler.getEditingDomain(),
						Messages.MigrateModelTypeAction_CommandLabel, null) {

					@Override
					protected CommandResult doExecuteWithResult(
							IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {

						DDS4CCMMigrationModelTypeUtil.migrateAll((Model) selObject);
						return CommandResult.newOKCommandResult();
					}
				};

				Job job = new Job("Model Type Migration") { //$NON-NLS-1$

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						monitor.beginTask(Messages.MigrateModelTypeAction_MonitorTask,
								IProgressMonitor.UNKNOWN);
						try {
							OperationHistoryFactory.getOperationHistory().execute(
									migrationCommand, monitor, null);
						} catch (ExecutionException e) {
							Activator.getDefault().error(Messages.Migrate_Error, e);
						}
						monitor.done();
						return Status.OK_STATUS;
					}
				};
				job.setUser(true);
				job.schedule();
	
			} else {
				MessageDialog.openInformation(
						Display.getCurrent().getActiveShell(),
						Messages.MigrateModelAction_DialogTitle,
						Messages.Migrate_Noop);
			}

			
			
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
		 *      org.eclipse.jface.viewers.ISelection)
		 */
		public void selectionChanged(IAction action, ISelection selection) {
			this.selection = selection;

		}
		
		
		@Override
		public void init(IViewPart view) {
			// TODO Auto-generated method stub
			
		}
}
