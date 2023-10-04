/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.validation;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;


public class UMLConnectionPointReferenceJavaValidator extends AbstractUMLConnectionPointReferenceJavaValidator {

	private static Namespace model;
	private static Element contextElement;

	public static void init(Element _contextElement) {
		contextElement = _contextElement;
		if (contextElement != null) {
			Element elem = contextElement.getOwner();
			while (elem.getOwner() != null) {
				elem = elem.getOwner();
			}
			model = (Namespace) elem;
		}
	}

	public static Namespace getModel() {
		return model;
	}

	public static Element getContextElement() {
		return contextElement;
	}

}
