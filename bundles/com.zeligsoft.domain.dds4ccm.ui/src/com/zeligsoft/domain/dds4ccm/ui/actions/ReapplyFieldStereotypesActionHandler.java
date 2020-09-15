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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMUtil;
import com.zeligsoft.domain.omg.corba.CXDomainNames;

/**
 * Reapplies stereotypes to fields of CXStruct and DDSMessage
 * 
 * @author parmvirs
 * 
 */
public class ReapplyFieldStereotypesActionHandler extends AbstractHandler {

	Boolean stereotypeApplied = false;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		EObject selObject = BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());

		if (selObject != null
				&& (ZDLUtil.isZDLConcept(selObject, DDS4CCMNames.DDSMESSAGE) || ZDLUtil
						.isZDLConcept(selObject, CXDomainNames.CXSTRUCT))) {

			RecordingCommand command = new ReapplyFieldStereotypesCommand(
					selObject, Messages.ReapplyFieldStereotypes_DialogTitle);

			if (command.canExecute()) {
				TransactionUtil.getEditingDomain(selObject).getCommandStack().execute(command);
			}
		}
		if (stereotypeApplied) {
			MessageDialog.openInformation(
					Display.getCurrent().getActiveShell(),
					Messages.ReapplyFieldStereotypes_DialogTitle,
					Messages.Migrate_OK);
		} else {
			MessageDialog.openInformation(
					Display.getCurrent().getActiveShell(),
					Messages.ReapplyFieldStereotypes_DialogTitle,
					Messages.ReapplyFieldStereotypes_Noop);
		}
		return null;
	}

	private class ReapplyFieldStereotypesCommand extends
			RecordingCommand {

		private EObject refactorObject = null;

		/**
		 * Constructor
		 * 
		 * @param element
		 * @param label
		 */
		public ReapplyFieldStereotypesCommand(EObject element, String label) {

			super(TransactionUtil.getEditingDomain(element), label);

			this.refactorObject = element;

		}

		@Override
		protected void doExecute() {

			if (ZDLUtil.isZDLConcept(refactorObject, DDS4CCMNames.DDSMESSAGE)
					|| ZDLUtil.isZDLConcept(refactorObject,
							CXDomainNames.CXSTRUCT)) {
				stereotypeApplied = DDS4CCMUtil
						.reapplyFieldStereotypes((Element) refactorObject);
			}
		}

		@Override
		public boolean canExecute() {
			return (refactorObject != null);
		}
	}
}
