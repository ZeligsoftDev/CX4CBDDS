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
package com.zeligsoft.domain.omg.ccm.ui.actions;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.ui.ElementTypeImageDescriptor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.uml2.uml.Component;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.zeligsoft.base.ui.menus.actions.ICXAction;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.ui.Activator;
import com.zeligsoft.domain.omg.ccm.ui.l10n.Messages;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Action delegate to create an attribute to a CCMPart
 * 
 * @author ysroh
 * 
 */
public class AddAttributeToCCMPartAction extends Action implements ICXAction {

	protected EObject context;

	protected Component definition;

	protected IElementType type;

	@Override
	public ImageDescriptor getImageDescriptor() {
		if (context == null) {
			return null;
		}
		type = ZDLElementTypeUtil
				.getElementType(context, CORBADomainNames.CORBAATTRIBUTE);
		return new ElementTypeImageDescriptor(type);
	}

	public void setSelection(EObject context) {
		this.context = context;

	}

	@Override
	public void run() {
		if (context == null || !ZDLUtil.isZDLConcept(context, CCMNames.CCMPART)) {
			return;
		}
		definition = (Component) ZDLUtil.getValue(context, CCMNames.CCMPART,
				ZMLMMNames.PART__DEFINITION);
		type = ZDLElementTypeUtil
				.getElementType(context, CORBADomainNames.CORBAATTRIBUTE);
		if (type == null || definition == null) {
			return;
		}
		AbstractTransactionalCommand editCommand = new AbstractTransactionalCommand(
				UMLModeler.getEditingDomain(),
				Messages.AddCCMAssemblyImplementationToComponent, Collections.EMPTY_MAP,
				null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {

				CreateElementRequest request = new CreateElementRequest(definition, type);
				try {
					ICommand createCommand = BaseUIUtil.getCommand(request);
					createCommand.execute(monitor, info);
					CommandResult cmdResult = createCommand.getCommandResult();
					if (cmdResult.getReturnValue() instanceof EObject) {
						EObject newObject = (EObject) cmdResult.getReturnValue();
						if (newObject != null) {
							BaseUIUtil.startInLineEdit(newObject);
						}
					}
				} catch (ExecutionException e) {
					throw e;
				}

				return CommandResult.newOKCommandResult();
			}
		};
		try {
			OperationHistoryFactory.getOperationHistory()
					.execute(editCommand, null, null);
		} catch (ExecutionException e) {
			Activator.getDefault().error("Failed to create an attribute", e); //$NON-NLS-1$
		}
	}

}
