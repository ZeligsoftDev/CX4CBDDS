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
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Edit helper advice for dataspaces in the DDS4CCM domain.
 * 
 * @author ysroh
 * 
 */
public class DataspaceEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		final CreateElementRequest editRequest = request;

		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(request.getContainer()),
				"DataspaceEditHelperAdivce", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EObject newEObject = editRequest.getNewElement();
				if (newEObject == null) {
					return null;
				}
				EObject container = editRequest.getContainer();
				if (!ZDLUtil.isZDLConcept(container,
						CCMNames.ASSEMBLY_IMPLEMENTATION)) {
					return null;
				}

				if (newEObject instanceof Property) {
					Property newProperty = (Property) newEObject;
					Type propertyType = newProperty.getType();
					if (propertyType != null
							&& ZDLUtil.isZDLConcept(propertyType,
									IDL3PlusNames.CONNECTOR_DEF)
							&& ZDLUtil.isZDLConcept(propertyType.eContainer(),
									IDL3PlusNames.MODULE_INSTANTIATION)) {
						newProperty.setName(EMFCoreUtil.getName(propertyType
								.eContainer()));
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
	}
}
