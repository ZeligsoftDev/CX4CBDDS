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
package com.zeligsoft.domain.omg.dds.ui.edithelpers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.type.ZDLElementTypeManager;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.dds.DDSNames;
import com.zeligsoft.domain.omg.dds.ui.l10n.Messages;

/**
 * Edit helper for Domain participants. This advice is used to  create
 * the proper concept type when a DDS component or Topic is added to the
 * structure of a Domain.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class DomainEditHelperAdvice
	extends AbstractEditHelperAdvice{

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.
	 * 	AbstractEditHelperAdvice#getAfterCreateCommand(org.eclipse.
	 * 	gmf.runtime.emf.type.core.requests.CreateElementRequest)
	 */
	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		final EObject container = request.getContainer();
		final CreateElementRequest editRequest = request;
		
		boolean isComponentPartContainer = 
			ZDLUtil.isZDLConcept(container, DDSNames.DOMAIN);
		
		if(! isComponentPartContainer) {
			return null;
		}
		
		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(container), 
				Messages.CommandLabel_DomainPartEditHelperAdvice_getAfterCreateCommand,
				null) {

					@Override
					protected CommandResult doExecuteWithResult(
							IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {
						EObject newEObject = editRequest.getNewElement();
						
						if(!(newEObject instanceof Property)) {
							return null;
						}
						
						Property newPart = (Property) newEObject;
						if(newPart instanceof Port) {
							return null;
						}
						
						Type propertyType = newPart.getType();
						if(propertyType == null) {
							return null;
						}
						
						boolean isPropertyTypeDDSComponent =
							ZDLUtil.isZDLConcept(propertyType, DDSNames.DDSCOMPONENT);
						boolean isPropertyTypeTopic =
							ZDLUtil.isZDLConcept(propertyType, DDSNames.TOPIC_DESCRIPTION);
						String concept = null;
						if(isPropertyTypeDDSComponent) {
							concept = DDSNames.DOMAIN_PARTICIPANT;
						} else if(isPropertyTypeTopic){
							concept = DDSNames.DOMAIN_TOPIC;
						}
						
						if(concept != null) {
							ZDLUtil.addZDLConcept(newPart, concept);
						} else {
							return null;
						}
						
						return CommandResult.newOKCommandResult(newPart);
					}
		};
	}
	
	@Override
	protected ICommand getBeforeCreateCommand(CreateElementRequest request) {
		// disable the ability to drag anything but a publisher or subscriber
		// onto a DDS component
		if(ZDLUtil.isZDLConcept(request.getContainer(), DDSNames.DOMAIN)) {
			if(request.getElementType() == ZDLElementTypeManager.INSTANCE
					.getElementTypeFromHint("part")) { //$NON-NLS-1$
				// TODO RSM Dependency
				Object o =
					request.getParameter("uml.property.type"); //$NON-NLS-1$
				if(o == null) {
					return null;
				}
				if(o instanceof EObject) {
					if((!ZDLUtil.isZDLConcept((EObject) o, DDSNames.DDSCOMPONENT)) &&
							(!ZDLUtil.isZDLConcept((EObject) (o), DDSNames.TOPIC_DESCRIPTION))) {
						return UnexecutableCommand.INSTANCE;
					}
				}
				
			}
		}
		
		
		return super.getBeforeCreateCommand(request);
	}
}
