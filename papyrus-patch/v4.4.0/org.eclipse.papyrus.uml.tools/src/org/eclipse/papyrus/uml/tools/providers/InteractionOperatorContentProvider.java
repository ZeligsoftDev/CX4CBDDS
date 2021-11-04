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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.eclipse.papyrus.infra.ui.emf.providers.EMFEnumeratorContentProvider;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.InteractionOperatorKind;

/**
 * Specific ContentProvider for filtering the acceptable values on CombinedFragment#interactionOperator
 *
 * See 383401: [Sequence Diagram] Interaction operator
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=383401
 *
 * @author Camille Letavernier
 *
 */
public class InteractionOperatorContentProvider extends EMFEnumeratorContentProvider {

	protected EObject editedEObject;

	public InteractionOperatorContentProvider(EObject editedEObject, EStructuralFeature feature) {
		super(feature);
		this.editedEObject = editedEObject;
	}

	@Override
	public Object[] getElements() {
		if (editedEObject instanceof ConsiderIgnoreFragment) {
			return new Object[] { InteractionOperatorKind.CONSIDER_LITERAL, InteractionOperatorKind.IGNORE_LITERAL };
		} else if (editedEObject instanceof CombinedFragment) {
			List<Object> elements = ListHelper.asList(super.getElements());
			elements.remove(InteractionOperatorKind.CONSIDER_LITERAL);
			elements.remove(InteractionOperatorKind.IGNORE_LITERAL);
			return elements.toArray();
		}

		return new Object[0];
	}

}
