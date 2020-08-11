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

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.RedefinableElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLSwitch;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.ddk.rsm.ui.l10n.Messages;

public class ConfigureRedefinitionHandler extends AbstractHandler {

	
	private Set<RedefinableElement> elements;

	private static Set<EClass> SUPPORTED_ECLASSES = Collections
		.unmodifiableSet(new java.util.HashSet<EClass>(Arrays
			.<EClass> asList(UMLPackage.Literals.PROPERTY)));

	private static class RedefinitionSwitch
			extends UMLSwitch<Boolean> {

		private RedefinableElement redefining;

		void redefine(RedefinableElement redefining,
				RedefinableElement redefined) {
			this.redefining = redefining;

			if (!doSwitch(redefined)) {
				throw new IllegalArgumentException(
					"Not a supported element kind: " + redefined); //$NON-NLS-1$
			}
		}

		@Override
		public Boolean defaultCase(EObject object) {
			return Boolean.FALSE;
		}

		@Override
		public Boolean caseProperty(Property object) {
			Property property = (Property) redefining;

			property.getRedefinedProperties().add(object);

			Association redefAssoc = property.getAssociation();
			Association assoc = object.getAssociation();

			if ((redefAssoc != null) && (assoc != null)) {
				Property redefOther = property.getOtherEnd();
				Property other = object.getOtherEnd();

				if (!redefOther.getRedefinedProperties().contains(other)) {
					redefOther.getRedefinedProperties().add(other);
				}

				if (!redefAssoc.getGenerals().contains(assoc)) {
					redefAssoc.getGenerals().add(assoc);
				}
			}

			return Boolean.TRUE;
		}
	}

	private static RedefinitionSwitch redefSwitch = new RedefinitionSwitch();

	private static boolean isSupported(EObject element) {
		boolean result = SUPPORTED_ECLASSES.contains(element.eClass());

		if (!result) {
			for (EClass next : element.eClass().getEAllSuperTypes()) {
				if (SUPPORTED_ECLASSES.contains(next)) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	private void configureRedefinition(RedefinableElement a,
			RedefinableElement b)
			throws ExecutionException {
		// first, figure out which is the redefining and which the redefined
		// by analyzing the redefinition context

		EList<Classifier> aCtx = a.getRedefinitionContexts();
		EList<Classifier> bCtx = b.getRedefinitionContexts();

		if (!aCtx.isEmpty() && !bCtx.isEmpty()) {
			Classifier aCtxCls = aCtx.get(0);
			Classifier bCtxCls = bCtx.get(0);

			RedefinableElement redefining;
			RedefinableElement redefined;

			if (aCtxCls.conformsTo(bCtxCls)) {
				redefining = a;
				redefined = b;
			} else if (bCtxCls.conformsTo(aCtxCls)) {
				redefining = b;
				redefined = a;
			} else {
				throw new ExecutionException(
					Messages.SpecifyRedefinitionActionDelegate_noRedefContext);
			}

			if (!redefining.getRedefinedElements().contains(redefined)) {
				if (redefined.eClass() != redefining.eClass()) {
					throw new ExecutionException(
						Messages.SpecifyRedefinitionActionDelegate_incompatibleElements);
				}
				redefSwitch.redefine(redefining, redefined);
			}
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final EObject owner = BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(owner);
		
		elements = null;

		if (BaseUIUtil.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) BaseUIUtil.getSelection();

			if (ssel.size() == 2) {
				elements = new java.util.HashSet<RedefinableElement>();

				for (Object next : ssel.toArray()) {
					if (next instanceof IAdaptable) {
						next = ((IAdaptable) next).getAdapter(EObject.class);
					}

					if (next instanceof RedefinableElement) {
						RedefinableElement redefinable = (RedefinableElement) next;
						if (isSupported(redefinable)) {
							elements.add(redefinable);
						}
					}
				}
			}
			Iterator<RedefinableElement> iter = elements.iterator();
			if ((elements.size() != 2)
				|| (iter.next().eClass() != iter.next().eClass())) {
				return null;
			}
		}

		Command command = new RecordingCommand(editingDomain) {
			
			@Override
			protected void doExecute() {
				Iterator<RedefinableElement> iter = elements.iterator();
				try {
					configureRedefinition(iter.next(), iter.next());
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
