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
package org.eclipse.papyrus.uml.properties.creation;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.infra.properties.ui.creation.EcorePropertyEditorFactory;
import org.eclipse.swt.widgets.Control;

/**
 * A Factory for creating objects in references that are subsets of {@link Namespace#getOwnedRules()}.
 *
 * The elements are actually contained in the ownedRule containment reference,
 * and referenced from the subset feature.
 *
 * @author Camille Letavernier
 *
 */
public class OwnedRuleCreationFactory extends EcorePropertyEditorFactory {

	public OwnedRuleCreationFactory(EReference referenceIn) {
		super(referenceIn);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EObject createObjectInDifferentContainer(Control widget) {
		// The base implementation is sufficient, as objects added to subsets of ownedRule are
		// already added to the right ownedRule by the UML framework.
		return simpleCreateObject(widget);
	}

	@Override
	public Collection<Object> validateObjects(Collection<Object> objectsToValidate) {
		return objectsToValidate; // Bypass the parent implementation
	}
}
