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

import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.infra.properties.contexts.DataContextElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractModelElementFactory;

/**
 * A ModelElementFactory for handling UML-specific appearance properties
 *
 * @author Camille Letavernier
 *
 */
public class UMLNotationFactory extends AbstractModelElementFactory<UMLNotationModelElement> {

	@Override
	protected UMLNotationModelElement doCreateFromSource(Object sourceElement, DataContextElement context) {
		if (sourceElement instanceof EditPart) {
			return new UMLNotationModelElement((EditPart) sourceElement);
		}
		return null;
	}

	@Override
	protected void updateModelElement(UMLNotationModelElement modelElement, Object newSourceElement) {
		if (!(newSourceElement instanceof EditPart)) {
			throw new IllegalArgumentException("Cannot resolve EditPart selection: " + newSourceElement);
		}
		modelElement.sourceElement = (EditPart) newSourceElement;
	}
}
