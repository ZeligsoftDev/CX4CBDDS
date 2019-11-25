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
package com.zeligsoft.domain.omg.ccm.ui.edithelpers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.ui.l10n.Messages;

/**
 * Edit helper advice for components in the CCM domain.
 * 
 * @author smcfee
 * 
 */
public class DomainEditHelperAdvice extends AbstractEditHelperAdvice {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice
	 * #getAfterCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.
	 * CreateElementRequest)
	 */
	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		final CreateElementRequest editRequest = request;

		return new AbstractTransactionalCommand(TransactionUtil.getEditingDomain(request.getContainer()),
				Messages.CommandLabel_SCAComponentPartEditHelperAdvice_getAfterCreateCommand, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EObject newEObject = editRequest.getNewElement();
				if (newEObject == null) {
					return null;
				}
				if (ZDLUtil.isZDLConcept(newEObject, CCMNames.CCMCONNECTOR)
						|| ZDLUtil.isZDLConcept(newEObject, CCMNames.TARGET_ASSEMBLY_CONNECTOR)) {
					((Connector) newEObject).setName(UML2Util.EMPTY_STRING);
					return CommandResult.newOKCommandResult(newEObject);
				}
				if (!(newEObject instanceof Property)) {
					return CommandResult.newOKCommandResult(newEObject);
				}

				Property newProperty = (Property) newEObject;

				Type propertyType = newProperty.getType();

				if (ZDLUtil.isZDLConcept(propertyType, CCMNames.NODE)) {
					if (!ZDLUtil.isZDLConcept(newProperty, CCMNames.NODE_INSTANCE)) {
						ZDLUtil.addZDLConcept(newProperty, CCMNames.NODE_INSTANCE);
					}
				} else if (ZDLUtil.isZDLConcept(propertyType, CCMNames.INTERCONNECT)) {
					if (!ZDLUtil.isZDLConcept(newProperty, CCMNames.INTERCONNECT_INSTANCE)) {
						ZDLUtil.addZDLConcept(newProperty, CCMNames.INTERCONNECT_INSTANCE);
					}
				} else if (ZDLUtil.isZDLConcept(propertyType, CCMNames.BRIDGE)) {
					if (!ZDLUtil.isZDLConcept(newProperty, CCMNames.BRIDGE_INSTANCE)) {
						ZDLUtil.addZDLConcept(newProperty, CCMNames.BRIDGE_INSTANCE);
					}
				} else if (ZDLUtil.isZDLConcept(propertyType, CCMNames.RESOURCE)) {
					if (!ZDLUtil.isZDLConcept(newProperty, CCMNames.RESOURCE_PROPERTY)) {
						ZDLUtil.addZDLConcept(newProperty, CCMNames.RESOURCE_PROPERTY);
					}
				}
				return CommandResult.newOKCommandResult(newProperty);
			}
		};
	}

}
