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
package com.zeligsoft.base.ui.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.type.ZDLElementTypeManager;

/**
 * Command to create a package without default diagram.
 * 
 * @author ysroh
 * 
 */
public class CreatePackageWithoutDiagramCommand extends
		AbstractTransactionalCommand {

	private EObject context;

	/**
	 * Creates new package without default diagram
	 * 
	 * @param context
	 * @param label
	 */
	public CreatePackageWithoutDiagramCommand(EObject context, String label) {

		super(TransactionUtil.getEditingDomain(context), label, null);
		this.context = context;

	}

	public CreatePackageWithoutDiagramCommand(EObject context) {
		this(context, UML2Util.EMPTY_STRING);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {

		final CreateElementRequest request = new CreateElementRequest(context,
				ZDLElementTypeManager.INSTANCE
						.getElementTypeFromHint("package")); //$NON-NLS-1$

		CommandResult result;
		result = BaseUIUtil.createModelElement(request);
		if (result != null && result.getReturnValue() != null) {
			Package pkg = (Package) result.getReturnValue();
			ICommand command = new DestroyDefaultDiagramCommand(pkg);
			// command is not executed through the operation history since it
			// does not require undo action
			command.execute(null, null);
		}
		return result;
	}
}
