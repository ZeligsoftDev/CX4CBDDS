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
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import com.ibm.xtools.uml.type.UMLElementFactory;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Delete port action for ports in structure diagram
 * 
 * @author ysroh
 * 
 */
public class DeletePortActionDelegate implements IObjectActionDelegate {

	private List<EObject> ports;

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(IAction action) {
		if (ports.isEmpty()) {
			return;
		}

		ICommand command = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(ports.get(0)),
				Messages.DeletePortActionDelegate_DeletePortCommandLabel, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				for (EObject port : ports) {
					if (ZDLUtil.isZDLConcept(port, ZMLMMNames.PORT)) {
						UMLElementFactory.destroyElement(port, null);
					}
				}
				return CommandResult.newOKCommandResult();
			}

		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					null, null);
		} catch (ExecutionException e) {
			ZeligsoftCXUIPlugin.getDefault().error(
					Messages.DeletePortActionDelegate_DeletePortFailedMessage,
					e);
		}

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		ISharedImages workbenchImages = PlatformUI.getWorkbench()
				.getSharedImages();
		if (action.getImageDescriptor() == null) {
			action.setImageDescriptor(workbenchImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		}
		ports = BaseUIUtil.getEObjectsFromSelection(selection);
	}

}
