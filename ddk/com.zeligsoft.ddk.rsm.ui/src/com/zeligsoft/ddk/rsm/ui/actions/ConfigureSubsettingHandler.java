/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.ddk.rsm.ui.actions;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.ddk.rsm.ui.l10n.Messages;

public class ConfigureSubsettingHandler extends AbstractHandler {

	private Set<Property> properties;

	private void configureSubsetting(Property a, Property b) throws ExecutionException {
		// first, figure out which is the subset and which the superset
		// by analyzing the subsetting context

		EList<Type> aCtx = a.subsettingContext();
		EList<Type> bCtx = b.subsettingContext();

		if (!aCtx.isEmpty() && !bCtx.isEmpty()) {
			Classifier aCtxCls = (Classifier) aCtx.get(0);
			Classifier bCtxCls = (Classifier) bCtx.get(0);

			Property subset;
			Property superset;

			if (aCtxCls.conformsTo(bCtxCls)) {
				subset = a;
				superset = b;
			} else if (bCtxCls.conformsTo(aCtxCls)) {
				subset = b;
				superset = a;
			} else {
				throw new ExecutionException(Messages.SpecifySubsetActionDelegate_noSubsetContext);
			}

			if (!subset.getSubsettedProperties().contains(superset)) {
				subset.getSubsettedProperties().add(superset);
			}

			Association superAssoc = superset.getAssociation();
			Association subAssoc = subset.getAssociation();
			if ((superAssoc != null) && (subAssoc != null)) {
				Property superOther = superset.getOtherEnd();
				Property subOther = subset.getOtherEnd();

				if (!subOther.getSubsettedProperties().contains(superOther)) {
					subOther.getSubsettedProperties().add(superOther);
				}

				if (!subAssoc.getGenerals().contains(superAssoc)) {
					subAssoc.getGenerals().add(superAssoc);
				}
			}
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final EObject owner = BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(owner);
		if (BaseUIUtil.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) BaseUIUtil.getSelection();

			if (ssel.size() == 2) {
				properties = new java.util.HashSet<Property>();

				for (Object next : ssel.toArray()) {
					if (next instanceof IAdaptable) {
						next = ((IAdaptable) next).getAdapter(EObject.class);
					}

					if (next instanceof Property) {
						properties.add((Property) next);
					}
				}

				if (properties.size() != 2) {
					return null;
				}
			}
		}

		Command command = new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				Iterator<Property> iter = properties.iterator();
				try {
					configureSubsetting(iter.next(), iter.next());
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		editingDomain.getCommandStack().execute(command);

		return null;
	}
}
