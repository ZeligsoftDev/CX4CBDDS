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
 *  Christian W. Damus (CEA) - bug 323802
 *  Gabriel Pascual (ALL4TEC) - Bug 441228
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.uml.properties.databinding.AppliedCommentsObservableList;
import org.eclipse.papyrus.uml.properties.databinding.OwnedCommentsObservableList;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

public class CommentModelElement extends EMFModelElement {

	private static final String APPLIED_COMMENTS_PROPERTY = "appliedComments";

	public CommentModelElement(Element source, EditingDomain domain) {
		super(source, domain);
	}

	@Override
	public boolean isOrdered(String propertyPath) {
		if (APPLIED_COMMENTS_PROPERTY.equals(propertyPath)) {
			return false;
		}
		return super.isOrdered(propertyPath);
	}

	@Override
	public boolean isUnique(String propertyPath) {
		if (APPLIED_COMMENTS_PROPERTY.equals(propertyPath)) {
			return true;
		}
		return super.isUnique(propertyPath);
	}

	@Override
	protected IObservable doGetObservable(String propertyPath) {
		if (APPLIED_COMMENTS_PROPERTY.equals(propertyPath)) {
			return new AppliedCommentsObservableList(domain, (Element) source);
		}

		EStructuralFeature feature = getFeature(propertyPath);
		if (feature == null) {
			return null;
		}

		if (UMLPackage.eINSTANCE.getElement_OwnedComment().equals(feature)) {
			return new OwnedCommentsObservableList(domain, source);
		}
		return super.doGetObservable(propertyPath);
	}

	@Override
	public ReferenceValueFactory getValueFactory(String propertyPath) {
		if (APPLIED_COMMENTS_PROPERTY.equals(propertyPath)) {
			return super.getValueFactory("ownedComment");
		}

		return super.getValueFactory(propertyPath);
	}

	@Override
	public boolean getDirectCreation(String propertyPath) {
		if (APPLIED_COMMENTS_PROPERTY.equals(propertyPath)) {
			return true;
		}
		return super.getDirectCreation(propertyPath);
	}

	@Override
	protected boolean isFeatureEditable(String propertyPath) {
		if (APPLIED_COMMENTS_PROPERTY.equals(propertyPath)) {
			return true;
		}
		return super.isFeatureEditable(propertyPath);
	}

}
