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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.commands.GetEditContextCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Advice that sets a ZDL reference property.
 * 
 * @author Christian W. Damus (Zeligsoft)
 */
public class ZDLReferenceAdvice
		extends AbstractZDLAdvice {

	protected String reference;

	private String label;

	/**
	 * Initializes me.
	 * 
	 * @param type
	 *            my element type ID
	 * @param concept
	 *            my domain concept
	 * @param reference
	 *            my domain reference
	 * @param label
	 *            my localized label
	 */
	public ZDLReferenceAdvice(String type, String concept, String reference,
			String label) {
		super(type, concept);

		this.reference = reference;
		this.label = label;
	}

	@Override
	public ICommand getBeforeEditContextCommand(GetEditContextRequest request) {
		request.setEditContext(ElementTypeRegistry.getInstance().getType(type));
		return super.getBeforeEditContextCommand(request);
	}

	@Override
	protected ICommand getAfterEditContextCommand(GetEditContextRequest request) {
		return new GetEditContextCommand(request);
	}

	@Override
	protected ICommand getBeforeCreateRelationshipCommand(
			final CreateRelationshipRequest request) {

		final EObject owner = request.getSource();
		final EObject value = request.getTarget();
		
		// It is possible that the request source is not
		// set, so do nothing.
		if (owner == null) {
			return null;
		}

		if (!ZDLUtil.hasZDLProperty(owner, concept, reference)) {
			return UnexecutableCommand.INSTANCE;
		}

		return new AbstractTransactionalCommand(TransactionUtil
			.getEditingDomain(owner), label, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				Object current = ZDLUtil.getValue(owner, concept, reference);
				if (current instanceof EList) {
					@SuppressWarnings("unchecked")
					EList<EObject> list = (EList<EObject>) current;

					// perhaps the relationship is already set and the user is
					// re-drawing it on the diagram. Nate that, as EMF does
					// not support non-unique references, we dan't ave to
					// worry about that case
					if (!list.contains(value)) {
						list.add(value);
					}
				} else {
					ZDLUtil.setValue(owner, concept, reference, value);
				}

				return CommandResult.newOKCommandResult();
			}

		};
	}
}
