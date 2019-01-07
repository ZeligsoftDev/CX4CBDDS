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
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.type.ZDLElementTypeManager;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.dds.DDSNames;
import com.zeligsoft.domain.omg.dds.ui.l10n.Messages;

/**
 * Edit helper for DDS Component participants. This advice is used to  create
 * the proper concept type when a publisher or subscriber is added to the
 * structure of a DDS Component.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class DDSComponentEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * Initialize me
	 */
	public DDSComponentEditHelperAdvice() {
		super();
	}
	
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
			ZDLUtil.isZDLConcept(container, DDSNames.DDSCOMPONENT);
		
		if(! isComponentPartContainer) {
			return null;
		}
		
		ICompositeCommand command = new CompositeCommand("DDSComponentEditHelperAdvice");
		command.compose(getAddZDLConceptCommand(container, editRequest));
		command.compose(getAddConnectorCommand(container, editRequest));
		
		return command;
	}
	
	private static ICommand getAddZDLConceptCommand(final EObject container, 
			final CreateElementRequest editRequest) {
		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(container), 
				Messages.CommandLabel_ComponentPartEditHelperAdvice_getAfterCreateCommand,
				null) {

					@Override
					protected CommandResult doExecuteWithResult(
							IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {
						final EObject newEObject = editRequest.getNewElement();
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
						
						boolean isPropertyTypePublisher =
							ZDLUtil.isZDLConcept(propertyType, DDSNames.PUBLISHER);
						boolean isPropertyTypeSubscriber =
							ZDLUtil.isZDLConcept(propertyType, DDSNames.SUBSCRIBER);
						String concept = null;
						if(isPropertyTypePublisher) {
							concept = DDSNames.COMPONENT_PART;
						} else if(isPropertyTypeSubscriber){
							concept = DDSNames.COMPONENT_PART;
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
	
	private ICommand getAddConnectorCommand(final EObject container, 
			final CreateElementRequest editRequest) {
		
		return new AbstractTransactionalCommand(TransactionUtil.getEditingDomain(container),
				"", null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				final EObject newEObject = editRequest.getNewElement();
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
				
				final boolean isPropertyTypePublisher =
					ZDLUtil.isZDLConcept(propertyType, DDSNames.PUBLISHER);
				final boolean isPropertyTypeSubscriber =
					ZDLUtil.isZDLConcept(propertyType, DDSNames.SUBSCRIBER);
				
				if(isPropertyTypePublisher || isPropertyTypeSubscriber) {
					final boolean isContainerDDSComponent =
						ZDLUtil.isZDLConcept(newPart.getClass_(), DDSNames.DDSCOMPONENT);
					final boolean isPartTypeAClass =
						newPart.getType() instanceof StructuredClassifier;
					
					if(isContainerDDSComponent && isPartTypeAClass) {
						final Component container = (Component) newPart.getClass_();
						final org.eclipse.uml2.uml.Class partType = 
							(org.eclipse.uml2.uml.Class) newPart.getType();
						for(Port p : partType.getOwnedPorts()) {
							final boolean isDataReader = 
								ZDLUtil.isZDLConcept(p, DDSNames.DATA_READER);
							final boolean isDataWriter =
								ZDLUtil.isZDLConcept(p, DDSNames.DATA_WRITER);
							
							if(isDataReader || isDataWriter) {
								final Port containerPort = 
									container.createOwnedPort(p.getName(), p.getType());
								if(isDataReader) {
									ZDLUtil.addZDLConcept(containerPort, DDSNames.DATA_READER);
								} else if(isDataWriter) {
									ZDLUtil.addZDLConcept(containerPort, DDSNames.DATA_WRITER);
								}
							
								Connector connector = container.createOwnedConnector("");
								ConnectorEnd end0 = connector.createEnd();
								ConnectorEnd end1 = connector.createEnd();
								
								end0.setPartWithPort(newPart);
								end0.setRole(p);
								
								end1.setRole(containerPort);
							}
						}
						
						return CommandResult.newOKCommandResult();
					}
				}
				
				return null;
			}
			
		};
	}
	
	@Override
	protected ICommand getBeforeCreateCommand(CreateElementRequest request) {
		// disable the ability to drag anything but a publisher or subscriber
		// onto a DDS component
		if(ZDLUtil.isZDLConcept(request.getContainer(), DDSNames.DDSCOMPONENT)) {
			if(request.getElementType() == ZDLElementTypeManager.INSTANCE
					.getElementTypeFromHint("part")) { //$NON-NLS-1$
				// TODO RSM Dependency
				Object o =
					request.getParameter("uml.property.type"); //$NON-NLS-1$
				if(o == null) {
					return null;
				}
				if(o instanceof EObject) {
					if(!ZDLUtil.isZDLConcept((EObject) o, DDSNames.PUBLISHER_SUBSCRIBER)) {
						return UnexecutableCommand.INSTANCE;
					}
				}
				
			}
		}
		
		
		return super.getBeforeCreateCommand(request);
	}

}
