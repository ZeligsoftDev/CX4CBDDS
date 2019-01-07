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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.ui.utils.BaseUtil;
import com.zeligsoft.base.zdl.type.ZDLElementTypeManager;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.dds.DDSNames;
import com.zeligsoft.domain.omg.dds.ui.l10n.Messages;
import com.zeligsoft.domain.omg.dds.util.DDSUtil;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class TopicConnectorEditHelperAdvice extends AbstractEditHelperAdvice {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest)
	 */
	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		final EObject container = request.getContainer();
		final CreateElementRequest editRequest = request;

		IElementType elementType = editRequest.getElementType();
		IElementType metamodelType = elementType;
		
		if (elementType instanceof ISpecializationType){
			metamodelType = ((ISpecializationType)elementType).getMetamodelType();
		}
		IElementType connectorElementType = ZDLElementTypeManager.INSTANCE
			.getElementTypeFromHint("connector"); //$NON-NLS-1$
		if (!(metamodelType == connectorElementType))
			return null;
		
		if (!(container instanceof Element)) {
			return null;
		}

		boolean found = false;	
		found = BaseUtil.isDomainProfileApplied((Element)container, DDSUtil.DDS_PROFILE_NSURI);
		if (!found) {
			return null;
		}
		
		
		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(container),
				Messages.CommandLabel_DDSConnectorEditHelperAdvice_getAfterCreateCommand,
				null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				Connector connector = (Connector) editRequest.getNewElement();
				EList<ConnectorEnd> ends = connector.getEnds();
				boolean isTopicConnector = false;
				if (ends.size() == 2) {
					boolean end0IsValid = ZDLUtil.isZDLConcept(ends.get(0).getRole(), DDSNames.DATA_READER_WRITER)
						|| ZDLUtil.isZDLConcept(ends.get(0).getRole(), DDSNames.DOMAIN_TOPIC);
					boolean end1IsValid = ZDLUtil.isZDLConcept(ends.get(1).getRole(), DDSNames.DATA_READER_WRITER)
						|| ZDLUtil.isZDLConcept(ends.get(1).getRole(), DDSNames.DOMAIN_TOPIC);;
					
					isTopicConnector = end0IsValid && end1IsValid;
				}

				if (!isTopicConnector) {
					return CommandResult.newOKCommandResult();
				}
				
				if (!ZDLUtil.isZDLConcept(connector, DDSNames.TOPIC_CONNECTOR)) {
					ZDLUtil.addZDLConcept(connector, DDSNames.TOPIC_CONNECTOR);					
				}
				
				connector.setKind(ConnectorKind.ASSEMBLY_LITERAL);
				
				return CommandResult.newOKCommandResult(connector);
			}

		};
	}
}
