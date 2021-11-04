/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.tools.providers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.ui.emf.providers.strategy.ContainmentBrowseStrategy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;


public class UMLContainmentBrowseStrategy extends ContainmentBrowseStrategy {

	public UMLContainmentBrowseStrategy(ITreeContentProvider provider) {
		super(provider);
	}

	@Override
	protected boolean browseElement(Object containerElement) {
		Object semanticElement = adaptableProvider.getAdaptedValue(containerElement);

		if (semanticElement == UMLPackage.eINSTANCE.getPackageImport_ImportedPackage()) {
			// FIXME: Only return true for the closest PackageImport
			return true;
		}

		return super.browseElement(containerElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TreePath findPath(Object semanticElement, Object[] rootElements) {
		// If element is a stereotype application, search for the base element instead
		EObject source = EMFHelper.getEObject(semanticElement);

		if (source instanceof Element) {
			return super.findPath(semanticElement, rootElements);
		}

		Element baseElement = UMLUtil.getBaseElement(source);
		if (baseElement == null) {
			return super.findPath(semanticElement, rootElements);
		}

		return super.findPath(baseElement, rootElements);
	}

	@Override
	public void revealSemanticElement(List<?> elementsList) {
		// For stereotypeApplication, we reveal the UML baseElement instead of the stereotypeApplication object
		List<Object> umlElementsList = new LinkedList<Object>();
		for (Object semanticElement : elementsList) {
			EObject source = EMFHelper.getEObject(semanticElement);

			Element baseElement;
			if (source instanceof Element) {
				baseElement = (Element) source;
			} else {
				baseElement = UMLUtil.getBaseElement(source);
			}

			if (baseElement == null) {
				umlElementsList.add(semanticElement);
			} else {
				umlElementsList.add(baseElement);
			}
		}

		super.revealSemanticElement(umlElementsList);
	}
}
