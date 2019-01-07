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
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Package;

/**
 * This is command class intended to delete the default diagram created with the
 * package
 * 
 * @author ysroh
 * 
 */
public class DestroyDefaultDiagramCommand extends AbstractTransactionalCommand {

	private EObject context;

	public DestroyDefaultDiagramCommand(EObject context, String label) {

		super(TransactionUtil.getEditingDomain(context), label, null);
		this.context = context;

	}

	/**
	 * Delete the default diagram under the given package
	 * 
	 * @param context
	 */
	public DestroyDefaultDiagramCommand(EObject context) {
		this(context, UML2Util.EMPTY_STRING);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {

		Package pkg = (Package) context;
		// try to delete default diagram created with the
		// package
		EAnnotation anno = pkg.getEAnnotation("uml2.diagrams"); //$NON-NLS-1$
		if (anno != null && !anno.getContents().isEmpty()) {
			DestroyElementRequest destoryRequest = new DestroyElementRequest(
					anno.getContents().get(0), false);
			DestroyElementCommand command = new DestroyElementCommand(
					destoryRequest);
			command.execute(null, null);
		}
		return CommandResult.newOKCommandResult();
	}
}
