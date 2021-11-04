/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * A SemanticContentProvider for Papyrus UML elements.
 *
 * This provider uses the Papyrus Service Edit to determine whether a value
 * is valid or not for a given eObject/feature.
 *
 * @author Camille Letavernier
 */
public class ServiceEditFilteredContentProvider extends SemanticUMLContentProvider {

	private EditServiceValidator validator;

	public ServiceEditFilteredContentProvider(EObject editedObject, EStructuralFeature feature, EObject[] roots) {
		super(editedObject, feature, roots);
		validator = new EditServiceValidator(editedObject, feature);
	}

	public ServiceEditFilteredContentProvider(EObject editedObject, EStructuralFeature feature, ResourceSet root) {
		super(editedObject, feature, root);
		validator = new EditServiceValidator(editedObject, feature);
	}

	@Override
	public boolean isValidValue(Object element) {
		return super.isValidValue(element) && validator.isValidValue(getAdaptedValue(element));
	}
}
