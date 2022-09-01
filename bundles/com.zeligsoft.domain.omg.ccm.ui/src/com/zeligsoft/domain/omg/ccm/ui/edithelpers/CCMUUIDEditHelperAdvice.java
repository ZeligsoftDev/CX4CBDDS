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

import java.util.UUID;

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
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.ui.l10n.Messages;

public class CCMUUIDEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		final CreateElementRequest editRequest = request;

		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(request.getContainer()),
				Messages.CommandLabel_SCAComponentPartEditHelperAdvice_getAfterCreateCommand,
				null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {

				if(!(editRequest.getContainer() instanceof Element)){
					return CommandResult.newOKCommandResult();
				}
				EObject newObject = editRequest.getNewElement();
				if (newObject == null) {
					return null;
				}

				if (newObject != null && ZDLUtil.isZDLConcept(newObject, CCMNames.DOMAIN)) {
					ZDLUtil.setValue(newObject, CCMNames.DOMAIN, CCMNames.DOMAIN___UUID,
							"_" + UUID.randomUUID().toString()); //$NON-NLS-1$
				} else if (newObject != null && ZDLUtil.isZDLConcept(newObject, CCMNames.DEPLOYMENT_PLAN)) {
					ZDLUtil.setValue(newObject, CCMNames.DEPLOYMENT_PLAN, CCMNames.DEPLOYMENT_PLAN__ID,
							"_" + UUID.randomUUID().toString()); //$NON-NLS-1$
				}

				return CommandResult.newOKCommandResult(newObject);

			}
		};
	}
}
