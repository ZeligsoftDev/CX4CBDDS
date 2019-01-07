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
package com.zeligsoft.cx.ui.edithelpers;

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
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.ui.commands.DestroyDefaultDiagramCommand;

/**
 * Remove default diagram under package
 * 
 * @author ysroh
 * 
 */
public class PackageEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterCreateCommand(final CreateElementRequest request) {
		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(request.getContainer()),
				"PackageEditHelper", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EObject newEObject = request.getNewElement();
				if (newEObject instanceof Package
						&& ((Package) newEObject)
								.getEAnnotation("uml2.diagrams") != null) { //$NON-NLS-1$
					ICommand command = new DestroyDefaultDiagramCommand(
							newEObject);
					command.execute(null, null);
				}
				return CommandResult.newOKCommandResult(newEObject);
			}
		};
	}
}
