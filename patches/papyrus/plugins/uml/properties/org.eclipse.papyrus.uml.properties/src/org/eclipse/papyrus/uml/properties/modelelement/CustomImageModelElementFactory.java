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
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.properties.contexts.DataContextElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractModelElementFactory;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Image;

/**
 * A ModelElementFactory for handling UML Images
 *
 * @author Camille Letavernier
 *
 */
public class CustomImageModelElementFactory extends AbstractModelElementFactory<CustomImageModelElement> {

	@Override
	protected CustomImageModelElement doCreateFromSource(Object sourceElement, DataContextElement context) {
		Element umlSource = UMLUtil.resolveUMLElement(sourceElement);
		if (umlSource == null) {
			Activator.log.warn("Unable to resolve the selected element to a UML Element"); //$NON-NLS-1$
			return null;
		}

		if (umlSource instanceof Image) {
			EditingDomain domain = EMFHelper.resolveEditingDomain(umlSource);
			return new CustomImageModelElement((Image) umlSource, domain);
		}

		Activator.log.warn("The selected element is not a UML Image"); //$NON-NLS-1$
		return null;
	}

	@Override
	protected void updateModelElement(CustomImageModelElement modelElement, Object newSourceElement) {
		Element element = UMLUtil.resolveUMLElement(newSourceElement);
		if (!(element instanceof Image)) {
			throw new IllegalArgumentException("Cannot resolve UML Image selection: " + newSourceElement);
		}
		modelElement.image = (Image) element;
		modelElement.editingDomain = EMFHelper.resolveEditingDomain(element);
	}
}
