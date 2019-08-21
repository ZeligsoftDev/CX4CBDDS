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
package com.zeligsoft.domain.omg.corba.ui.edithelpers;

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
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Parameter;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * Add return type to newly created CORBA operation and apply correct stereotype
 * to the return parameter
 * 
 * @author ysroh
 * 
 */
public class CORBAOperationEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterCreateCommand(final CreateElementRequest request) {
		final EObject container = request.getContainer();

		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(container), "SetReturnType", //$NON-NLS-1$
				null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EObject newObject = request.getNewElement();
				if (newObject == null || !ZDLUtil.isZDLConcept(newObject,
						CORBADomainNames.CORBAOPERATION)) {
					return CommandResult.newOKCommandResult(newObject);
				}

				Operation operation = (Operation) newObject;
				NamedElement corbaVoidType = null;
				for (PackageImport pi : operation.getModel()
						.getPackageImports()) {
					if ("IDLPrimitives".equals(pi.getImportedPackage().getName())) { //$NON-NLS-1$
						corbaVoidType = pi.getImportedPackage().getOwnedMember(
								"CORBAVoid"); //$NON-NLS-1$
					}
				}
				if (corbaVoidType != null) {
					operation.setType((DataType) corbaVoidType);
				}
				Parameter param = operation.getOwnedParameter("Parameter1", //$NON-NLS-1$
						null);
				if (param != null) {
					param.setName("ReturnParameter"); //$NON-NLS-1$
				}

				return CommandResult.newOKCommandResult(newObject);
			}
		};
	}

}
