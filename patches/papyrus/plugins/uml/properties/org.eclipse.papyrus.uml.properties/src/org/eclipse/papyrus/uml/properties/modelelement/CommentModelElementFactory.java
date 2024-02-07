/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Sebastien Poissonnet (CEA LIST) sebastien.poissonnet@cea.fr
 *  Christian W. Damus (CEA) - bug 417409
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.modelelement;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.properties.contexts.DataContextElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractEMFModelElementFactory;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Element;

public class CommentModelElementFactory extends AbstractEMFModelElementFactory<CommentModelElement> {

	@Override
	protected CommentModelElement doCreateFromSource(Object source, DataContextElement context) {
		Element umlSource = UMLUtil.resolveUMLElement(source);
		if (umlSource == null) {
			Activator.log.warn("Unable to resolve the selected element to a UML Element"); //$NON-NLS-1$
			return null;
		}

		EditingDomain domain = EMFHelper.resolveEditingDomain(umlSource);
		return new CommentModelElement(umlSource, domain);
	}

}
