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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
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

import com.zeligsoft.base.ui.menus.Activator;
import com.zeligsoft.base.ui.menus.actions.ICXAction;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.type.ZDLElementTypeManager;

/**
 * Action delegate for "Add Package" context menu.
 * 
 * @author ysroh
 * 
 */

public class AddCXPackageAction extends Action implements ICXAction {

	protected EObject selectedEObject;

	/**
	 * The IElementType for Package
	 */
	public static IElementType PACKAGE_ELEMENT_TYPE = ZDLElementTypeManager.INSTANCE
			.getElementTypeFromHint("package");//$NON-NLS-1$;

	/**
	 * Returns a new CreateElementRequest and set the element to be create to
	 * <code>PACKAGE_ELEMENT_TYPE</code>
	 * 
	 * @return CreateElementRequest
	 */

	@Override
	public void setSelection(EObject context) {
		this.selectedEObject = context;
	}

	@Override
	public void run() {
		if (selectedEObject == null) {
			return;
		}
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(selectedEObject);
		IClientContext context = null;
		try {
			context = TypeContext.getContext(selectedEObject);
		} catch (ServiceException e) {
			Activator.getDefault().error(e.getMessage(), e);
			return;
		}
		final CreateElementRequest req = new CreateElementRequest(editingDomain, selectedEObject, PACKAGE_ELEMENT_TYPE);
		final EObject target = ElementEditServiceUtils.getTargetFromContext(editingDomain, selectedEObject, req);
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
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return new ElementTypeImageDescriptor(PACKAGE_ELEMENT_TYPE);
	}

}
