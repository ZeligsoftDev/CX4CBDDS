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
package com.zeligsoft.domain.dds4ccm.ui.edithelpers;

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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Edit Helper advice to configure CCM components post-creation. Needed because CCMComponent is defined
 * in another domain so we can't use the ZDLGen configuration facilities.
 * 
 * @author smcfee
 *
 */
public class ComponentEditHelperAdvice extends AbstractEditHelperAdvice {
	
	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		final CreateElementRequest editRequest = request;

		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(request.getContainer()),
				"CreateRegisterNamingProperty", //$NON-NLS-1$
				null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {

				EObject newObject = editRequest.getNewElement();
				if (newObject == null
						|| !(newObject.eContainer() instanceof Element)) {
					return CommandResult.newOKCommandResult();
				}

				if (ZDLUtil.isZDLConcept(newObject, CCMNames.CCMCOMPONENT)) {
					DDS4CCMUtil.addRegisterNamingProperty((Component) newObject);
				}
				return CommandResult.newOKCommandResult(newObject);
			}
		};
	}
	
	@Override
	protected ICommand getAfterCreateRelationshipCommand(
			final CreateRelationshipRequest request) {

		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(request.getContainer()),
				"RemoveRegisterNamingProperty", //$NON-NLS-1$
				null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				if (request.getNewElement() != null
						&& request.getNewElement() instanceof Generalization) {
					EObject target = request.getTarget();
					EObject source = request.getSource();
					if (target != null
							&& ZDLUtil.isZDLConcept(target,
									CCMNames.CCMCOMPONENT)
							&& source != null
							&& ZDLUtil.isZDLConcept(source,
									CCMNames.ASSEMBLY_IMPLEMENTATION)) {

						DDS4CCMUtil
								.removeRegisterNamingProperty((Component) target);
					}
				}

				return CommandResult.newOKCommandResult();
			}
		};
	}
}
