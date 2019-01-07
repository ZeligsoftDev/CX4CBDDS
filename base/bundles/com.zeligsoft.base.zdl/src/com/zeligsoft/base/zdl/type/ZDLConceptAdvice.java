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
package com.zeligsoft.base.zdl.type;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * The edit-helper advice that defines a ZDL Concept specialization of a base
 * UML element type.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLConceptAdvice
		extends AbstractZDLAdvice {

	private String label;

	/**
	 * Initializes me.
	 * 
	 * @param type
	 *            my element type ID
	 * @param concept
	 *            my domain concept
	 * @param label
	 *            my localized label
	 */
	public ZDLConceptAdvice(String type, String concept, String label) {
		super(type, concept);

		this.label = label;
	}

	@Override
	protected ICommand getBeforeCreateCommand(CreateElementRequest request) {
		final EObject container = request.getContainer();

		if (!ZDLUtil.canCreateZDLConceptIn(container, concept)) {
			return UnexecutableCommand.INSTANCE;
		}

		return new AbstractTransactionalCommand(TransactionUtil
			.getEditingDomain(container), label, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EObject result = ZDLUtil.createZDLConceptIn(container, concept);

				return CommandResult.newOKCommandResult(result);
			}

		};
	}

	@Override
	protected String getLocalizedName(EObject eObject) {
		return label;
	}

}
