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
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Action to add required properties to existing ContainerProcess elements.
 * 
 * @author smcfee
 *
 */
public class RefactorContainerProcessAction
		implements IViewActionDelegate {

	private ISelection selection;
	
	private int repairedReferenceCount = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		
		if(selection == null){
			return;
		}
		repairedReferenceCount = 0;

		EObject selObject = BaseUIUtil.getEObjectFromSelection(selection);
		
		if( selObject != null && 
			ZDLUtil.isZDLConcept(selObject, DDS4CCMNames.DDS4_CCMMODEL) ||
			ZDLUtil.isZDLConcept(selObject, CCMNames.CONTAINER_PROCESS)) {
		
			AbstractTransactionalCommand migrationCommand = new RefactorContainerProcessCommand(
					selObject,
					Messages.RefactorContainerProcess_DialogTitle);
			
			try {	
				OperationHistoryFactory.getOperationHistory().execute(migrationCommand, null, null);		
			} catch( Exception e ) {
				Activator.getDefault().error(Messages.Migrate_Error, e);
				MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.Migrate_Error, e.getMessage());
				return;
			}
		}
		
		if( repairedReferenceCount > 0 ) {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
					Messages.RefactorContainerProcess_DialogTitle,
					Messages.Migrate_OK);
		} else {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
					Messages.RefactorContainerProcess_DialogTitle,
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
	
	/**
	 * Internal command used to perform the migration.
	 * 
	 * @author smcfee
	 *
	 */
	private class RefactorContainerProcessCommand extends
			AbstractTransactionalCommand {

		private EObject refactorObject = null;
		
		/**
		 * Constructor
		 * 
		 * @param modelToMigrate
		 * @param label
		 */
		public RefactorContainerProcessCommand(EObject modelToMigrate, String label) {

			super(TransactionUtil.getEditingDomain(modelToMigrate), label,
					Collections.EMPTY_MAP, getWorkspaceFiles(modelToMigrate));
			
			this.refactorObject = modelToMigrate;

		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			
			List<Component> containerProcesses = new ArrayList<Component>();
			
			if( ZDLUtil.isZDLConcept(refactorObject, CCMNames.CONTAINER_PROCESS)) {
				containerProcesses.add((Component)refactorObject);
			} else if( ZDLUtil.isZDLConcept(refactorObject, DDS4CCMNames.DDS4_CCMMODEL)) {
				
				for (TreeIterator<?> iter = EcoreUtil.getAllContents(refactorObject.eResource().getContents()); iter.hasNext();) {
					
					Object next = iter.next();
					
					if( next instanceof Component) {
						if( ZDLUtil.isZDLConcept((Component)next, CCMNames.CONTAINER_PROCESS)) {
							containerProcesses.add((Component)next);
						}
					}
				}
			}
			
			for( Component process : containerProcesses ) {
				if( DDS4CCMUtil.setupContainerProcessResources(process)) {
					repairedReferenceCount++;
				}
			}
			
			return CommandResult.newOKCommandResult();
		}

		@Override
		public boolean canExecute() {
			return (refactorObject != null);
		}
	}

	@Override
	public void init(IViewPart view) {
		// TODO Auto-generated method stub
		
	}
}
