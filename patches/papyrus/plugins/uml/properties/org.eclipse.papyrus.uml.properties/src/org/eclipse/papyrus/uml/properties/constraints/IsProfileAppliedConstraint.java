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
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.constraints;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;

/**
 * A constraint to test if the given object is a UML Element and
 * has the given profile applied
 *
 * @author Benoit Maggi
 */
public class IsProfileAppliedConstraint extends AbstractConstraint {

	/**
	 * The name of the property that hold the pluginURI used by this constraint
	 */
	public static final String PROFILE_URI = "profileURI"; //$NON-NLS-1$

	/**
	 * The uri of the profile to look for
	 */
	protected String profileURI;

	/**
	 * The UML element on which the profile may be applied
	 */
	protected Element umlElement;

	/**
	 * @see org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint#match(java.lang.Object)
	 * Check if the containing package has profilUri applied.
	 * @param selection
	 * @return
	 */
	@Override
	public boolean match(Object selection) {
		umlElement = UMLUtil.resolveUMLElement(selection);
		if (umlElement == null) {
			return false;
		}
		
		EList<Profile> allAppliedProfiles = umlElement.getNearestPackage().getAllAppliedProfiles();
		for (Profile profile : allAppliedProfiles) {
			String uri = profile.getURI();
			if (profileURI.equals(uri)){
				return true;
			}
		}
		return false; // always called even when not defined 
	}

	/**
	 * @see org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint#setDescriptor(org.eclipse.papyrus.infra.constraints.SimpleConstraint)
	 *
	 * @param descriptor
	 */
	@Override
	public void setDescriptor(SimpleConstraint descriptor) {
		profileURI = getValue(PROFILE_URI);
	}

	/**
	 * @see java.lang.Object#toString()
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return String.format("IsProfileApplied %s (%s)", profileURI, getDisplayUnit().getElementMultiplicity() == 1 ? "Single" : "Multiple"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * @see org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint#equivalent(org.eclipse.papyrus.infra.constraints.constraints.Constraint)
	 * Check if the constraint share the same pluginURI
	 * @param constraint
	 * @return
	 */
	@Override
	protected boolean equivalent(Constraint constraint) {
		if (this == constraint) {
			return true;
		}
		if (constraint == null) {
			return false;
		}
		if (!(constraint instanceof IsProfileAppliedConstraint)) {
			return false;
		}
		IsProfileAppliedConstraint other = (IsProfileAppliedConstraint) constraint;
		if (profileURI == null) {
			if (other.profileURI != null) {
				return false;
			}
		} else if (!profileURI.equals(other.profileURI)) {
			return false;
		}
		return true;
	}
	
}
