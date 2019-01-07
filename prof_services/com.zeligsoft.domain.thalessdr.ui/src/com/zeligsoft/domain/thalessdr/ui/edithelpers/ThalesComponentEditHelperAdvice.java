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
package com.zeligsoft.domain.thalessdr.ui.edithelpers;

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
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.sca.utils.SCANames;
import com.zeligsoft.domain.thalessdr.ui.li0n.ThalesMessages;

/**
 * Edit helper advice for components in the ThalesSDR domain.
 * 
 * @author smcfee
 *
 */
public class ThalesComponentEditHelperAdvice extends AbstractEditHelperAdvice {

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
		final EObject container = request.getContainer();
		final CreateElementRequest editRequest = request;

		boolean isPartContainer = ZDLUtil.isZDLConcept(container, SCANames.SCACOMPONENT);

		if (!isPartContainer) {
			return null;
		}		

		return new AbstractTransactionalCommand(
			TransactionUtil.getEditingDomain(container),
			ThalesMessages.CommandLabel_ComponentPartEditHelperAdvice_getAfterCreateCommand,
			null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EObject newEObject = editRequest.getNewElement();
				if (!(newEObject instanceof Property)) {
					return null;
				}

				Property newProperty = (Property) newEObject;
				if (newProperty instanceof Port) {
					return null;
				}
				
				Type propertyType = newProperty.getType();
				if (propertyType == null) {
					return null;
				}
				
				if( ZDLUtil.isZDLConcept(propertyType, CCMNames.CCMCOMPONENT)) {
					ZDLUtil.addZDLConcept(newProperty, CCMNames.CCMPART);	
				}

				return CommandResult.newOKCommandResult(newProperty);
			}

		};
	}
}
