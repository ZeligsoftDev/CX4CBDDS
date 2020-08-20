/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.ddk.zdl.rsm.tooling.actions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.edit.context.TypeContext;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.uml2.uml.Class;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.ZDLNames;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Handler for validating a subtree
 */
public class AddZDLActionHandler extends AbstractHandler {

	/**
	 * Map which contains a mapping from Action id to concept.
	 */
	protected static Map<String, String> commandId2IElementType = new HashMap<String, String>();

	static {

		commandId2IElementType.put("com.zeligsoft.ddk.zdl.ui.addDomainPackageCommand", //$NON-NLS-1$
				ZDLNames.DOMAIN_PACKAGE);

		commandId2IElementType.put("com.zeligsoft.ddk.zdl.ui.addDomainBlockCommand", //$NON-NLS-1$
				ZDLNames.DOMAIN_BLOCK);

		commandId2IElementType.put("com.zeligsoft.ddk.zdl.ui.addDomainSpecializationCommand", //$NON-NLS-1$
				ZDLNames.DOMAIN_SPECIALIZATION);

		commandId2IElementType.put("com.zeligsoft.ddk.zdl.ui.addDomainDataTypeCommand", //$NON-NLS-1$
				ZDLNames.DOMAIN_DATA_TYPE);

		commandId2IElementType.put("com.zeligsoft.ddk.zdl.ui.addDomainConceptCommand", //$NON-NLS-1$
				ZDLNames.DOMAIN_CONCEPT);

		commandId2IElementType.put("com.zeligsoft.ddk.zdl.ui.addDomainModelLibraryCommand", //$NON-NLS-1$
				ZDLNames.DOMAIN_MODEL_LIBRARY);

		commandId2IElementType.put("com.zeligsoft.ddk.zdl.ui.addDomainEnumerationCommand", //$NON-NLS-1$
				ZDLNames.DOMAIN_ENUM);

		commandId2IElementType.put("com.zeligsoft.ddk.zdl.ui.addDomainEnumerationLiteralCommand", //$NON-NLS-1$
				ZDLNames.DOMAIN_ENUM_LITERAL);

		commandId2IElementType.put("com.zeligsoft.ddk.zdl.ui.addDomainAttributeCommand", //$NON-NLS-1$
				ZDLNames.DOMAIN_ATTRIBUTE);

		commandId2IElementType.put("com.zeligsoft.ddk.zdl.ui.addDomainConstraintCommand", //$NON-NLS-1$
				ZDLNames.DOMAIN_CONSTRAINT);

		commandId2IElementType.put("com.zeligsoft.ddk.zdl.ui.addDomainLinkConstraintCommand", //$NON-NLS-1$
				ZDLNames.DOMAIN_LINK_CONSTRAINT);
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String commandId = event.getCommand().getId();
		final String concept = commandId2IElementType.get(commandId);
		final EObject owner = BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(owner);
		IClientContext context = null;
		try {
			context = TypeContext.getContext(owner);
		} catch (ServiceException e) {
			// log
		}
		
		// get the ZDL concept class and its instantiable element type
		Class conceptClass = ZDLUtil.getZDLConcept(owner, concept);
		IElementType type = ZDLElementTypeUtil.getElementType(owner, conceptClass);

		final CreateElementRequest req = new CreateElementRequest(editingDomain, owner, type);
		final EObject target = ElementEditServiceUtils.getTargetFromContext(editingDomain, owner, req);
		if (target == null) {
			return null;
		}

		Command command = BaseUIUtil.buildCommand(editingDomain, context, req, target);
		if (command == null || !command.canExecute()) {
			return null;
		}

		// Wrap command to select created element
		command = BaseUIUtil.getRevealCommand(command, target);
		if (command != null) {
			command = BaseUIUtil.getDirectEditCommand(command);
		}
		if (command != null && command.canExecute()) {
			editingDomain.getCommandStack().execute(command);
		}
		return null;
	}
}
