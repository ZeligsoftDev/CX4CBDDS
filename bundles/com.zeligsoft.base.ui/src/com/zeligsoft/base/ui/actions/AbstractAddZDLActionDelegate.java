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

package com.zeligsoft.base.ui.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Class;

import com.zeligsoft.base.ui.l10n.Messages;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An abstract action delegate for creation of instances of domain concepts.
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractAddZDLActionDelegate
		extends AbstractZeligsoftActionDelegate {

	/**
	 * Initializes me.
	 */
	public AbstractAddZDLActionDelegate() {
		super();
	}

	/**
	 * Implemented by subclasses to provide the qualified name of the domain
	 * concept to instantiate.
	 * 
	 * @return the domain concept qualified name
	 */
	protected abstract String getDomainConcept();

	@Override
	protected ICommand getCommand() {
		final EObject owner = getSelectedElement();
		final String concept = getDomainConcept();

		return new AbstractTransactionalCommand(getEditingDomain(), getLabel(),
			null) {

			@Override
			public boolean canExecute() {
				return ZDLUtil.canCreateZDLConceptIn(owner, concept);
			}

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				ElementTypeRegistry reg = ElementTypeRegistry.getInstance();
				IClientContext ctx = ZDLElementTypeUtil.getClientContext(owner);

				// get the ZDL concept class and its instantiable element type
				Class conceptClass = ZDLUtil.getZDLConcept(owner,
					getDomainConcept());
				IElementType type = ZDLElementTypeUtil.getElementType(owner, conceptClass);

				// set up the create request
				CreateElementRequest req = new CreateElementRequest(owner, type);
				req.setClientContext(ctx);
				Object editCtx = req.getEditHelperContext();

				// get the element type that actually does the creating
				IElementType editType = reg.getElementType(editCtx);

				if (editType == null) {
					// no rich editing support
					EObject result = ZDLUtil.createZDLConcept(owner,
						conceptClass);
					
					if (result != null) {
						if (result.eContainer() != null) {
							// successfully attached
							return CommandResult.newOKCommandResult(result);
						} else {
							// not attached. Destroy it
							DestroyElementCommand.destroy(result);
						}
					}
				} else {
					// get and execute the command
					ICommand cmd = editType.getEditCommand(req);
					
					if ((cmd != null) && cmd.canExecute()) {
						cmd.execute(monitor, info).isOK();
						return cmd.getCommandResult();
					}
				}

				return CommandResult.newErrorCommandResult(NLS.bind(
					Messages.AddZDLFailed_error, EMFCoreUtil.getQualifiedName(
						owner, true)));
			}

		};
	}
}
