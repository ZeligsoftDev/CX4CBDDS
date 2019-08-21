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
import org.eclipse.uml2.uml.Port;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * CCM Implementation edit helper adivce
 * 
 * @author ysroh
 * 
 */
public class CCMImplementationEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterCreateCommand(final CreateElementRequest request) {

		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(request.getContainer()),
				"MovePortToComponent", //$NON-NLS-1$
				null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EObject container = request.getContainer();
				if (!ZDLUtil.isZDLConcept(container,
						CCMNames.ASSEMBLY_IMPLEMENTATION)) {
					return null;
				}
				EObject newObject = request.getNewElement();
				if (newObject == null) {
					return null;
				}
				if (!ZDLUtil.isZDLConcept(newObject, ZMLMMNames.PORT)) {
					return CommandResult.newOKCommandResult(newObject);
				}

				Object obj = ZDLUtil.getValue(container,
						CCMNames.ASSEMBLY_IMPLEMENTATION,
						ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE);
				if (obj != null) {
					// Move port to the definition
					((Port) newObject).destroy();
					CreateElementRequest newRequest = new CreateElementRequest(
							(EObject) obj, request.getElementType());
					newRequest.setParameter("uml.port.type", "unspecified"); //$NON-NLS-1$//$NON-NLS-2$
					BaseUIUtil.createModelElement(newRequest);
				}

				return CommandResult.newOKCommandResult(newObject);

			}
		};
	}
}
