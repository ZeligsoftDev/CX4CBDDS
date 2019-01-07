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

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.zdl.l10n.Messages;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Abstract implementation of a ZDL advice.
 * 
 * @author Christian W. Damus (cdamus)
 */
abstract class AbstractZDLAdvice
		extends AbstractEditHelperAdvice {

	protected String type;

	protected String concept;

	AbstractZDLAdvice(String type, String concept) {
		this.type = type;
		this.concept = concept;
	}

	@Override
	protected ICommand getBeforeEditContextCommand(GetEditContextRequest request) {
		IEditCommandRequest editRequest = request.getEditCommandRequest();
		if (editRequest instanceof CreateRelationshipRequest) {
			CreateRelationshipRequest crr = (CreateRelationshipRequest) editRequest;

			IElementType type = crr.getElementType();

			if (type instanceof ZDLElementType) {
				ZDLElementType zdlType = (ZDLElementType) type;

				EObject source = crr.getSource();
				EObject target = crr.getTarget();

				if (zdlType.getDomainReference() != null) {
					if (source != null) {
						if (!ZDLUtil.hasZDLProperty(source, zdlType
							.getDomainConcept(), zdlType.getDomainReference())) {
							return UnexecutableCommand.INSTANCE;
						}
					}

					if (target != null) {
						if (!ZDLUtil.isZDLTypeOf(target, zdlType
							.getDomainConcept(), zdlType.getDomainReference())) {
							return UnexecutableCommand.INSTANCE;
						}
					}
				}
			}
		} else if (editRequest instanceof CreateElementRequest) {
			CreateElementRequest cer = (CreateElementRequest) editRequest;

			IElementType type = cer.getElementType();

			if (type instanceof ZDLElementType) {
				ZDLElementType zdlType = (ZDLElementType) type;

				EObject container = cer.getContainer();
				if ((container == null)
					|| !ZDLUtil.canCreateZDLConceptIn(container, zdlType
						.getDomainConcept())) {
					return UnexecutableCommand.INSTANCE;
				}
			}

		}

		return super.getBeforeEditContextCommand(request);
	}

	@Override
	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {

		final EObject eObject = request.getElementToConfigure();
		final EObject container = eObject.eContainer();
		final EReference reference = eObject.eContainmentFeature();

		return new AbstractTransactionalCommand(TransactionUtil
			.getEditingDomain(eObject), Messages.AbstractZDLAdvice_autname,
			null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				autoName(container, reference, eObject);
				return CommandResult.newOKCommandResult();
			}

		};
	}

	/**
	 * Return the localized name of the given EObject.
	 * 
	 * @param eObject
	 * @return the localized name
	 */
	protected String getLocalizedName(EObject eObject) {
		return PackageUtil.getLocalizedName(eObject.eClass());
	}

	/**
	 * Set the auto name for the given EObject.
	 * 
	 * @param eObject
	 * @param name
	 */
	protected void setAutoName(EObject eObject, String name) {
		if (eObject instanceof NamedElement)
			((NamedElement) eObject).setName(name);
	}

	/**
	 * Get the name for the given EObject.
	 * 
	 * @param eObject
	 * @return String name
	 */
	protected String getName(EObject eObject) {
		if (eObject instanceof NamedElement) {
			return ((NamedElement) eObject).getName();
		}
		return null;
	}

	/**
	 * Auto name the given EObject.
	 * 
	 * @param container
	 * @param reference
	 * @param eObject
	 */
	protected void autoName(EObject container, EReference reference,
			EObject eObject) {

		String originalName = getLocalizedName(eObject);

		if (originalName != null) {
			
			String originalNameNoSpaces = originalName.replace(" ", "");  //$NON-NLS-1$//$NON-NLS-2$
			
			if (reference.isMany()) {
				String name = originalNameNoSpaces;
				Set<String> set = new java.util.HashSet<String>();
				Iterator<?> i = ((Collection<?>) container.eGet(reference))
					.iterator();
				while (i.hasNext()) {
					Object sibling = i.next();
					if (sibling != null) {
						String n = null;

						// add extra conditions for other model elements
						if (sibling instanceof NamedElement)
							n = ((NamedElement) sibling).getName();

						if (n != null)
							set.add(n);
					}
				}

				for (int j = 1; j <= Integer.MAX_VALUE; j++) {
					String n = (j == 1)
						? name
						: name + j;
					if (!set.contains(n)) {
						name = n;
						break;
					}
				}
				if (!name.equals(getName(eObject)))
					setAutoName(eObject, name);
			}
		}
	}
}