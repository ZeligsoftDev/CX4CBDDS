/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
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
 *  Christian W. Damus (CEA) - bug 417409
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.modelelement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.properties.contexts.DataContextElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractModelElementFactory;
import org.eclipse.papyrus.uml.properties.Activator;

/**
 * A Factory for building ModelElements for specific UML properties
 * (Virtual properties, such as Multiplicity or Navigability)
 *
 * @author Camille Letavernier
 */
public class UMLEditorFactory extends AbstractModelElementFactory<MemberEndModelElement> {

	@Override
	protected MemberEndModelElement doCreateFromSource(Object sourceElement, DataContextElement context) {
		EObject source = EMFHelper.getEObject(sourceElement);
		if (source == null) {
			Activator.log.warn("Unable to resolve the selected element to an EObject"); //$NON-NLS-1$
			return null;
		}

		EditingDomain domain = EMFHelper.resolveEditingDomain(source);

		return new MemberEndModelElement(source, domain);
	}

	@Override
	protected void updateModelElement(MemberEndModelElement modelElement, Object newSourceElement) {
		EObject eObject = EMFHelper.getEObject(newSourceElement);
		if (eObject == null) {
			throw new IllegalArgumentException("Cannot resolve EObject selection: " + newSourceElement);
		}
		modelElement.source = eObject;
		modelElement.domain = EMFHelper.resolveEditingDomain(eObject);
	}
}
