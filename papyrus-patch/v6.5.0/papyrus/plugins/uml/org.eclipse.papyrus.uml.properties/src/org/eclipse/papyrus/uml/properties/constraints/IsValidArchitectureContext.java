/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Jeremie TATIBOUET (CEA LIST) <jeremie.tatibouet@cea.fr>
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.constraints;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.architecture.ArchitectureDescriptionUtils;
import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.edit.domain.PapyrusTransactionalEditingDomain;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Element;

/**
 * @since 3.5
 */
public class IsValidArchitectureContext extends AbstractConstraint {

	private final static String ARCHITECTURE_CONTEXT_PROPERTY_NAME = "architectureContext"; //$NON-NLS-1$

	/**
	 * Architecture context ID in which this constraint returns true
	 */
	protected String expectedArchitectureContextId;

	/**
	 * @see org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint#setDescriptor(org.eclipse.papyrus.infra.constraints.SimpleConstraint)
	 *
	 *      Read the value defined for the property ARCHITECTURE_CONTEXT_PROPERTY_NAME
	 */
	@Override
	protected void setDescriptor(SimpleConstraint descriptor) {
		expectedArchitectureContextId = getValue(ARCHITECTURE_CONTEXT_PROPERTY_NAME);
	}

	/**
	 * @see org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint#match(java.lang.Object)
	 *
	 *      If the selection is a UML element and the edition occurs in the expected architecture
	 *      context then return true; false otherwise.
	 */
	@Override
	protected boolean match(Object selection) {
		boolean match = false;
		Element element = UMLUtil.resolveUMLElement(selection);
		if (element != null) {
			EditingDomain domain = UMLUtil.resolveEditingDomain(element);
			if (domain instanceof PapyrusTransactionalEditingDomain) {
				ArchitectureDescriptionUtils adUtils = new ArchitectureDescriptionUtils(
						(ModelSet) ((PapyrusTransactionalEditingDomain) domain).getResourceSet());
				MergedArchitectureContext architectureContext = adUtils.getArchitectureContext();
				if (architectureContext != null) {
					match = architectureContext.getId().equals(expectedArchitectureContextId);
				}
			}
		}
		return match;
	}

	/**
	 * @see org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint#equivalent(org.eclipse.papyrus.infra.constraints.constraints.Constraint)
	 *
	 *      Two constraints can only be equivalent if (1) they designate the same object or (2) they are different object of the same type with equal values for their properties
	 */
	@Override
	protected boolean equivalent(Constraint constraint) {
		boolean equivalent = this == constraint;
		if (!equivalent) {
			if (constraint != null && constraint instanceof IsValidArchitectureContext) {
				equivalent = expectedArchitectureContextId.equals(((IsValidArchitectureContext) constraint).expectedArchitectureContextId);
			}
		}
		return equivalent;
	}

}
