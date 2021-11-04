/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;

/**
 * Content provider for Interfaces of provided or required attribute of a {@link Port}.
 *
 * @author Gabriel Pascual
 *
 */
public class PortInterfaceContentProvider extends SemanticUMLContentProvider {


	/**
	 * Instantiates a new port interface content provider.
	 *
	 * @param source
	 *            the source
	 * @param feature
	 *            the feature
	 */
	public PortInterfaceContentProvider(EObject source, EStructuralFeature feature) {
		super(source, feature);

	}

	/**
	 * @see org.eclipse.papyrus.infra.ui.emf.providers.strategy.SemanticEMFContentProvider#getElements()
	 *
	 * @return
	 */

	@Override
	public Object[] getElements() {
		if (feature == UMLPackage.eINSTANCE.getPort_Provided()) {
			return buildProvidedInterfaceElements();
		} else if (feature == UMLPackage.eINSTANCE.getPort_Required()) {
			return buildRequiredInterfaceElements();
		}
		return null;
	}

	/**
	 * Gets the top package.
	 *
	 * @return the top package
	 */
	private Package getTopPackage() {
		Package topPackage = null;

		EObject rootContainer = EcoreUtil.getRootContainer(eObject);
		if (rootContainer instanceof Package) {
			topPackage = (Package) rootContainer;
		}
		return topPackage;
	}

	/**
	 * Builds the required interface elements.
	 *
	 * @return the object[]
	 */
	private Object[] buildRequiredInterfaceElements() {
		Package rootPackage = getTopPackage();

		return ElementUtil.getInstancesFilteredByType(rootPackage, Usage.class, null).toArray();
	}

	/**
	 * Builds the provided interface elements.
	 *
	 * @return the object[]
	 */
	private Object[] buildProvidedInterfaceElements() {
		Package rootPackage = getTopPackage();

		return ElementUtil.getInstancesFilteredByType(rootPackage, Realization.class, null).toArray();
	}
}
