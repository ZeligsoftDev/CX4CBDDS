/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The label provider for UML EClass
 *
 * @author Vincent Lorenzo
 *
 */
public class UMLEClassLabelProvider extends UMLFilteredLabelProvider {

	/**
	 *
	 * @see org.eclipse.papyrus.uml.tools.providers.UMLFilteredLabelProvider#accept(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public boolean accept(Object element) {
		if (element instanceof EClass) {
			final EObject container = ((EClass) element).eContainer();
			return container == UMLPackage.eINSTANCE;
		}
		return false;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider#getText(org.eclipse.emf.ecore.EObject)
	 *
	 * @param element
	 * @return
	 */
	@Override
	protected String getText(final EObject element) {
		return ((EClass) element).getName();
	}

	/**
	 *
	 * @see org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider#getImage(org.eclipse.emf.ecore.EObject)
	 *
	 * @param element
	 * @return
	 */
	@Override
	protected Image getImage(EObject element) {
		if (!((EClass) element).isAbstract() && !((EClass) element).isInterface()) {
			final EObject instance = UMLFactory.eINSTANCE.create(((EClass) element));
			return super.getImage(instance);
		}
		return null;
	}
}
