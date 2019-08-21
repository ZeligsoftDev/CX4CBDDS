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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.l10n.Messages;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Edit-helper advice applied to all elements to implement the destruction of
 * ZDL references.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLDestroyReferenceAdvice
		extends AbstractEditHelperAdvice {

	/**
	 * Initializes me.
	 */
	public ZDLDestroyReferenceAdvice() {
		super();
	}

	@Override
	protected ICommand getBeforeDestroyReferenceCommand(
			DestroyReferenceRequest request) {

		final EObject owner = request.getContainer();
		final EReference reference = request.getContainingFeature();
		final EObject value = request.getReferencedObject();

		if (owner != null && reference != null) {
			final Class concept = ZDLUtil.getZDLDefinition(reference
				.getEContainingClass());

			if (concept != null) {
				// it's a ZDL reference
				return new AbstractTransactionalCommand(TransactionUtil
					.getEditingDomain(owner),
					Messages.ZDLDestroyReferenceAdvice_commandLabel, null) {

					@Override
					protected CommandResult doExecuteWithResult(
							IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {

						Property property = ZDLUtil.getZDLDefinition(reference);
						String reference = property.getName();

						Object current = ZDLUtil.getValue(owner, concept,
							reference);
						if (current instanceof EList) {
							@SuppressWarnings("unchecked")
							EList<EObject> list = (EList<EObject>) current;
							list.remove(value);
						} else {
							ZDLUtil.setValue(owner, concept, reference, null);
						}

						return CommandResult.newOKCommandResult();
					}

				};
			}
		}

		return super.getBeforeDestroyReferenceCommand(request);
	}

}
