/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui.constraint;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.IDirectEditorConstraint;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * This class allow to define a constraint corresponding to the multiplicity lower value.
 */
public class MultiplicityLowerValueDirectEditorConstraint implements IDirectEditorConstraint {

	/**
	 * Constructor.
	 */
	public MultiplicityLowerValueDirectEditorConstraint() {
		super();
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.IDirectEditorConstraint#getLabel()
	 *
	 * @return The label.
	 */
	public String getLabel() {
		return " Multiplicity Element Lower Value"; //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.IDirectEditorConstraint#appliesTo(java.lang.Object)
	 *
	 * @param selection
	 *            the current selection
	 * @return <code>true</code> if selection matches the constraint, otherwise <code>false</code>
	 */
	public boolean appliesTo(final Object selection) {
		boolean appliedConstraint = false;
		// Check that the selection is a structural feature and the lower value of multiplicity element
		if (selection instanceof EStructuralFeature && UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue().equals(selection)) {
			appliedConstraint = true;
		} else if (selection instanceof ValueSpecification) {
			final ValueSpecification valueSpecification = (ValueSpecification) selection;
			if (valueSpecification.eContainer() instanceof MultiplicityElement) {
				final EObject parent = valueSpecification.eContainer();
				final Object lowerValue = parent.eGet(UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue());
				appliedConstraint = valueSpecification.equals(lowerValue);
			}
		}
		return appliedConstraint;
	}

}
