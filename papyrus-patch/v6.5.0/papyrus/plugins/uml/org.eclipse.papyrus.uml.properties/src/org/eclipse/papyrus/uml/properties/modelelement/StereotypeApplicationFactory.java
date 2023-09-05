/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
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

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.properties.contexts.DataContextElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractEMFModelElementFactory;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Element;

/**
 * A ModelElementFactory for manipulating Stereotype and Profile
 * applications
 *
 * @author Camille Letavernier
 *
 */
public class StereotypeApplicationFactory extends AbstractEMFModelElementFactory<StereotypeApplicationModelElement> {

	@Override
	protected StereotypeApplicationModelElement doCreateFromSource(Object sourceElement, DataContextElement context) {
		Element umlSource = UMLUtil.resolveUMLElement(sourceElement);
		if (umlSource == null) {
			Activator.log.warn("Unable to resolve the selected element to a UML Element"); //$NON-NLS-1$
			return null;
		}

		EditingDomain domain = EMFHelper.resolveEditingDomain(umlSource);
		if (sourceElement instanceof EditPart) {
			return new StereotypeApplicationModelElement((EditPart) sourceElement, domain);
		} else {
			return new StereotypeApplicationModelElement(umlSource, domain);
		}
	}

	@Override
	protected void updateModelElement(StereotypeApplicationModelElement modelElement, Object newSourceElement) {
		Element element = UMLUtil.resolveUMLElement(newSourceElement);
		if (element == null) {
			throw new IllegalArgumentException("Cannot resolve UML element selection: " + newSourceElement);
		}
		modelElement.umlSource = element;
		modelElement.setEditingDomain(EMFHelper.resolveEditingDomain(element));
		modelElement.sourceElement = (newSourceElement instanceof EditPart) ? (EditPart) newSourceElement : null;

		super.updateModelElement(modelElement, newSourceElement);
	}
}
