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
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.services.edit.ui.dialogs.ElementTypeValidator;
import org.eclipse.papyrus.uml.tools.providers.SemanticUMLContentProvider;

/**
 * A content provider that takes into account the nature of the searched element
 * (org.eclipse.papyrus.uml.tools.providers.ServiceEditFilteredContentProvider).
 */
public class ServiceEditContentProvider extends SemanticUMLContentProvider {

	private ElementTypeValidator validator;

	public ServiceEditContentProvider(IElementType elementType, EStructuralFeature feature, EObject semanticRoot) {
		super(semanticRoot.eResource().getResourceSet());
		setWantedMetaclasses(Collections.singletonList(feature.getEType()));
		validator = new ElementTypeValidator(elementType);
	}

	@Override
	public boolean isValidValue(Object element) {
		return super.isValidValue(element) && validator.validate(new Object[] { getAdaptedValue(element) }).isOK();
	}
}
