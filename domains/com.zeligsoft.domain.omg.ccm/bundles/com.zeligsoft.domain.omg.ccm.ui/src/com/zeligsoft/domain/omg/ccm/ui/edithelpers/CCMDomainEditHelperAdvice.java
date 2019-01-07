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
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.PlatformUI;

import com.ibm.xtools.uml.type.UMLElementFactory;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Create and open structure diagram when Domain is created
 * 
 * @author ysroh
 * 
 */
public class CCMDomainEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		final CreateElementRequest editRequest = request;

		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(request.getContainer()),
				"DomainEditHelper", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EObject newEObject = editRequest.getNewElement();
				if (newEObject == null) {
					return null;
				}

				if (!ZDLUtil.isZDLConcept(newEObject, CCMNames.DOMAIN)) {
					return null;
				}

				ICommand command = UMLElementFactory
						.getCreateElementCommand(
								newEObject,
								ElementTypeRegistry
										.getInstance()
										.getType(
												"org.eclipse.gmf.runtime.notation.structureDiagram")); //$NON-NLS-1$
				try {
					command.execute(null, null);

					final CommandResult result = command.getCommandResult();

					if (result != null
							&& result.getReturnValue() instanceof Diagram) {
						getEditingDomain().runExclusive(new Runnable() {

							public void run() {
								try {
									IDiagramEditorInput diagramInput = new DiagramEditorInput(
											(Diagram) result.getReturnValue());

									PlatformUI
											.getWorkbench()
											.getActiveWorkbenchWindow()
											.getActivePage()
											.openEditor(diagramInput,
													"ModelerDiagramEditor");//$NON-NLS-1$
								} catch (Exception e) {
									// do nothing
								}
							}
						});
					}
				} catch (Exception e) {
					// do nothing
				}
				return CommandResult.newOKCommandResult();
			}
		};
	}
}
