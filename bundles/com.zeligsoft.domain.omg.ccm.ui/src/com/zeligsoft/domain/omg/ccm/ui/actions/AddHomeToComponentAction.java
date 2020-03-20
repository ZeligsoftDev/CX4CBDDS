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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.ui.ElementTypeImageDescriptor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.edit.context.TypeContext;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;

import com.zeligsoft.base.ui.menus.actions.ICXAction;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.ui.Activator;

/**
 * @author smcfee
 * 
 */
public class AddHomeToComponentAction extends Action implements ICXAction {

	protected EObject selectedComponent;

	@Override
	public ImageDescriptor getImageDescriptor() {
		IElementType type = ZDLElementTypeUtil.getElementType(selectedComponent,
				CCMNames.HOME);
		return new ElementTypeImageDescriptor(type);
	}

	@Override
	public void run() {
		final EObject container = ((Component)selectedComponent).getNearestPackage();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(container);

		Command command = new RecordingCommand(editingDomain) {
			
			@Override
			protected void doExecute() {
				IClientContext context = null;
				try {
					context = TypeContext.getContext(container);
				} catch (ServiceException e) {
					Activator.getDefault().error(e.getMessage(), e);
					return;
				}
				IElementType type = ZDLElementTypeUtil.getElementType(container,
						CCMNames.HOME);
				final CreateElementRequest req = new CreateElementRequest(editingDomain, container, type);
				final EObject target = ElementEditServiceUtils.getTargetFromContext(editingDomain, container, req);
				if (target == null) {
					return;
				}

				Command command = BaseUIUtil.buildCommand(editingDomain, context, req, target);
				if (command == null || !command.canExecute()) {
					return;
				}

				// Wrap command to select created element
				command = BaseUIUtil.getRevealCommand(command, target);
				if (command != null) {
					command = BaseUIUtil.getDirectEditCommand(command);
				}
				if (command != null && command.canExecute()) {
					editingDomain.getCommandStack().execute(command);
				}
				if(!command.getResult().isEmpty()) {
					Dependency manages = ((org.eclipse.uml2.uml.Class) command.getResult().iterator().next())
							.createDependency((Component) selectedComponent);
					ZDLUtil.addZDLConcept(manages, CCMNames.MANAGES);
				}
			}
		};
		
		if (command.canExecute()) {
			editingDomain.getCommandStack().execute(command);
		}
	}

	public void setSelection(EObject context) {
		this.selectedComponent = context;
	}

}