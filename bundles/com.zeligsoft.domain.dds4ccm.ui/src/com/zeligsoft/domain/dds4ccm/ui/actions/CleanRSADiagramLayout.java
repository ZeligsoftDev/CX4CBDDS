/*******************************************************************************
 * Copyright (c) 2021 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.util.BaseUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;

/**
 * Action to clean RSA diagram annotations
 * 
 * @author ysroh
 * 
 */
public class CleanRSADiagramLayout extends AbstractHandler {

	private int refactorCount = 0;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		refactorCount = 0;

		EObject selObject = BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());

		if (selObject != null
				&& ZDLUtil.isZDLConcept(selObject, DDS4CCMNames.DDS4_CCMMODEL)) {

			Command migrationCommand = new RefactorRemoveRSADiagramCommand(
					selObject, Messages.CleanRSADiagramLayout_CommandLabel);

			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(selObject);
			if(migrationCommand.canExecute()) {
				domain.getCommandStack().execute(migrationCommand);
			}
		}

		if (refactorCount > 0) {
			MessageDialog.openInformation(
					Display.getCurrent().getActiveShell(),
					Messages.CleanRSADiagramLayout_DialogTitle,
					Messages.Migrate_OK);
		} else {
			MessageDialog.openInformation(
					Display.getCurrent().getActiveShell(),
					Messages.CleanRSADiagramLayout_DialogTitle,
					Messages.Migrate_Noop);
		}

		return null;
	}

	/**
	 * Internal command used to perform the migration.
	 * 
	 * @author ysroh
	 * 
	 */
	private class RefactorRemoveRSADiagramCommand extends
			RecordingCommand {

		private EObject refactorObject = null;

		/**
		 * Constructor
		 * 
		 * @param modelToMigrate
		 * @param label
		 */
		public RefactorRemoveRSADiagramCommand(EObject modelToMigrate, String label) {

			super(TransactionUtil.getEditingDomain(modelToMigrate), label);

			this.refactorObject = modelToMigrate;

		}

		@Override
		protected void doExecute() {

			List<EObject> annotToRemove = new ArrayList<EObject>();

			for (TreeIterator<EObject> iter = refactorObject.eAllContents(); iter.hasNext();) {
				EObject next = iter.next();

				if (next instanceof EAnnotation) {
					EAnnotation annot = (EAnnotation) next;
					if("cx.diagrams".equals(annot.getSource())) { //$NON-NLS-1$
						annotToRemove.add(annot);
					}
					iter.prune();
				}else if(!(next instanceof Package) && !(next instanceof Component)) {
					iter.prune();
				}
			}

			refactorCount += annotToRemove.size();
			Command cmd = BaseUtil.getDeleteCommand(annotToRemove);
			if (cmd.canExecute()) {
				TransactionUtil.getEditingDomain(refactorObject).getCommandStack().execute(cmd);
			}
		}

		@Override
		public boolean canExecute() {
			return (refactorObject != null);
		}
	}
}
