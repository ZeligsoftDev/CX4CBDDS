/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.constraints;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.tools.utils.DataTypeUtil;

/**
 * Matches EObjects which are instances of UML Datatype
 * (e.g. instances of DataTypes used in Profile Definition)
 *
 * @author Camille Letavernier
 */
public class IsUMLDatatypeInstance extends AbstractConstraint {

	@Override
	protected boolean equivalent(Constraint constraint) {
		return constraint instanceof IsUMLDatatypeInstance;
	}

	@Override
	protected boolean match(Object selection) {
		EObject selectedElement = EMFHelper.getEObject(selection);

		if (selectedElement == null) {
			return false;
		}

		// FIXME: Minor issue. Bug 427419: During the creation of the DataType instance,
		// the instance is not yet attached to its resource/resource set. For statically-defined
		// profiles, #isDataTypeInstance needs a resource/resource set to load the profile and
		// determine whether this is a UML DataType.
		// For dynamic profiles, this works fine because it verifies an EAnnotation on the EClassifier
		// (There is no need for a Resource/Resource set)
		return DataTypeUtil.isDataTypeInstance(selectedElement);
	}

}
