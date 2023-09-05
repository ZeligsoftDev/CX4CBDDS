/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.properties.constraints;

import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Element;

/**
 * A Constraint to test if the given object is an instance of the given
 * UML Metaclass. This constraint can recognize UML Objects hidden behind
 * a GMF Edit Part or, in general, any IAdaptable.
 *
 * @author Camille Letavernier
 */
public class UmlInstanceOfConstraint extends AbstractConstraint {

	private String umlClassName;

	@Override
	public void setDescriptor(SimpleConstraint descriptor) {
		umlClassName = getValue("umlClassName"); //$NON-NLS-1$
	}

	@Override
	public boolean match(Object selection) {
		Element umlSemantic = UMLUtil.resolveUMLElement(selection);
		if (umlSemantic != null) {
			return EMFHelper.isInstance(umlSemantic, umlClassName, UMLUtil.getUMLMetamodel());
		}

		return false;
	}

	/**
	 * A class constraint overrides its superclass constraints
	 * e.g. : instanceOf(Class) overrides instanceOf(Classifier)
	 */
	@Override
	public boolean overrides(Constraint constraint) {
		if (!(constraint instanceof UmlInstanceOfConstraint)) {
			return false;
		}

		UmlInstanceOfConstraint umlConstraint = (UmlInstanceOfConstraint) constraint;
		boolean result = (!umlClassName.equals(umlConstraint.umlClassName)) && UMLUtil.isSubClass(umlClassName, umlConstraint.umlClassName);

		return result || super.overrides(constraint);
	}

	@Override
	public String toString() {
		return String.format("UMLInstanceOf %s (%s)", umlClassName, getDisplayUnit().getElementMultiplicity() == 1 ? "Single" : "Multiple");//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@Override
	protected boolean equivalent(Constraint constraint) {
		if (this == constraint) {
			return true;
		}
		if (constraint == null) {
			return false;
		}
		if (!(constraint instanceof UmlInstanceOfConstraint)) {
			return false;
		}
		UmlInstanceOfConstraint other = (UmlInstanceOfConstraint) constraint;
		if (umlClassName == null) {
			if (other.umlClassName != null) {
				return false;
			}
		} else if (!umlClassName.equals(other.umlClassName)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the name of the UML Metaclass
	 */
	public String getClassName() {
		return umlClassName;
	}
}
