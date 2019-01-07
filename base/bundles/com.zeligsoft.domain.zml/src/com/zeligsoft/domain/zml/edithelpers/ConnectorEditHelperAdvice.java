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

package com.zeligsoft.domain.zml.edithelpers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.zdl.type.ZDLElementTypeManager;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.l10n.Messages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * The ZML connector edit helper advice which applies the ZMLMMNames.ASSEMBLY_CONNECTOR
 * concept to all connectors in all domains.
 * 
 * @author jcorchis
 * 
 */
public class ConnectorEditHelperAdvice
		extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		final EObject container = request.getContainer();
		final CreateElementRequest editRequest = request;

		IElementType elementType = editRequest.getElementType();
		IElementType connector = ZDLElementTypeManager.INSTANCE
			.getElementTypeFromHint("connector");//$NON-NLS-1$
		IElementType assemblyConnector = ZDLElementTypeManager.INSTANCE
			.getElementTypeFromHint("assemblyConnector");//$NON-NLS-1$
		if (!(elementType == connector) || !(elementType == assemblyConnector))
			return null;

		return new AbstractTransactionalCommand(
			TransactionUtil.getEditingDomain(container),
			Messages.CommandLabel_ZMLConnectorEditHelperAdvice_getAfterCreateCommand,
			null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info) {

				Element newElement = (Element) editRequest.getNewElement();

				// check if it is already an CONNECTOR
				if (!ZDLUtil.isZDLConcept(newElement,
					ZMLMMNames.ASSEMBLY_CONNECTOR)) {

					ZDLUtil.addZDLConcept(newElement,
						ZMLMMNames.ASSEMBLY_CONNECTOR);
				}

				return CommandResult.newOKCommandResult(newElement);
			}

		};
	}

}
