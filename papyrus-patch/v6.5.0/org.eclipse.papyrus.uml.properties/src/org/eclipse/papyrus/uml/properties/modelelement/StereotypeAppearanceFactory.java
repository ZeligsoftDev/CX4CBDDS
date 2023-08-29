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

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.properties.contexts.DataContextElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractModelElementFactory;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Element;

/**
 * A ModelElementFactory for handling Stereotype appearance
 *
 * @author Camille Letavernier
 *
 */
public class StereotypeAppearanceFactory extends AbstractModelElementFactory<StereotypeAppearanceModelElement> {

	@Override
	protected StereotypeAppearanceModelElement doCreateFromSource(Object sourceElement, DataContextElement context) {
		Element umlSource = UMLUtil.resolveUMLElement(sourceElement);

		if (umlSource == null) {
			Activator.log.warn("Unable to resolve the selected element to a UML Element"); //$NON-NLS-1$
			return null;
		}

		if (sourceElement instanceof EditPart) {
			EModelElement modelElement = (EModelElement) ((EditPart) sourceElement).getModel();
			EditingDomain domain = EMFHelper.resolveEditingDomain(umlSource);
			return new StereotypeAppearanceModelElement(umlSource, domain, modelElement);
		}

		Activator.log.warn("The selected element is not an edit part"); //$NON-NLS-1$
		return null;
	}

	@Override
	protected void updateModelElement(StereotypeAppearanceModelElement modelElement, Object newSourceElement) {
		if (!(newSourceElement instanceof EditPart)) {
			throw new IllegalArgumentException("Cannot resolve EditPart selection: " + newSourceElement);
		}

		Element umlSource = UMLUtil.resolveUMLElement(newSourceElement);
		modelElement.umlSource = umlSource;
		modelElement.diagramElement = (EModelElement) ((EditPart) newSourceElement).getModel();
		modelElement.domain = EMFHelper.resolveEditingDomain(umlSource);
	}
}
