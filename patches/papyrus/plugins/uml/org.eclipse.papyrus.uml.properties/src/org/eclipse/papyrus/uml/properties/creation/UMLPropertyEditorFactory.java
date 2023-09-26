/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.creation;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.properties.ui.creation.EcorePropertyEditorFactory;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.tools.providers.UMLEClassLabelProvider;
import org.eclipse.swt.graphics.Image;


public class UMLPropertyEditorFactory extends EcorePropertyEditorFactory {

	/**
	 * the label provider used to get the image and the label in the creation popup menu
	 */
	private UMLEClassLabelProvider provider = new UMLEClassLabelProvider();

	public UMLPropertyEditorFactory(EReference referenceIn) {
		super(referenceIn);
	}

	/**
	 * {@inheritDoc} Overridden to use Papyrus commands
	 */
	@Override
	public Collection<Object> validateObjects(Collection<Object> objectsToValidate) {
		if (!referenceIn.isContainment()) {
			for (Object objectToValidate : objectsToValidate) {
				// We add the object to the containment reference
				// They will be automatically added to the edited reference
				// (referenceIn) after this method returns
				CreateIn creationInformation = this.createIn.get(objectToValidate);
				if (creationInformation != null) {
					set(creationInformation.createInObject, creationInformation.createInReference, objectToValidate);
				} else {
					Activator.log.warn("Unknown object : " + objectToValidate);
				}
			}
		}

		return objectsToValidate;
	}

	protected void set(EObject container, EReference reference, Object value) {
		try {
			EditingDomain domain = EMFHelper.resolveEditingDomain(container);
			if (domain == null) {
				container.eSet(reference, value);
				return;
			}

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container);

			if (provider != null) {
				SetRequest request = new SetRequest((TransactionalEditingDomain) domain, container, reference, value);
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				domain.getCommandStack().execute(emfCommand);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.properties.ui.creation.EcorePropertyEditorFactory#getImage(org.eclipse.emf.ecore.EClass)
	 *
	 * @param eClass
	 * @return
	 */
	@Override
	protected Image getImage(final EClass eClass) {
		return this.provider.getImage(eClass);
	}
}
