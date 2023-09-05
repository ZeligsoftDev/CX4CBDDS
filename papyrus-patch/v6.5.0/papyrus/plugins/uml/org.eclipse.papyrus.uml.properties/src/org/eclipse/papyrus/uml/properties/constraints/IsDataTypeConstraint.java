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
package org.eclipse.papyrus.uml.properties.constraints;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.papyrus.infra.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;
import org.eclipse.papyrus.uml.properties.datatype.DataTypeObservableValue;

/**
 * This constraints tests whether an Object is an instance of a DataType
 * The "null" DataType instance should still be matched by this constraint.
 * It is encapsulated in a DataTypeObservableObject instance (Which is never null).
 *
 * @author Camille Letavernier
 */
public class IsDataTypeConstraint extends AbstractConstraint {

	/**
	 * The "datatype" property (From ConstraintDescriptor)
	 */
	public static final String DATATYPE_PROPERTY = "datatype"; //$NON-NLS-1$

	private EDataType dataType;

	protected void setDescriptor(ConstraintDescriptor descriptor) {
		String dataTypeClassName = getValue(DATATYPE_PROPERTY);
		dataType = ClassLoaderHelper.newInstance(dataTypeClassName, EDataType.class);
	}

	@Override
	public boolean match(Object selection) {
		if (dataType == null) {
			return false;
		}
		if (selection instanceof DataTypeObservableValue) {
			DataTypeObservableValue observer = (DataTypeObservableValue) selection;
			return observer.getValueType() == dataType;
		}

		return false;
	}

	@Override
	protected boolean equivalent(Constraint constraint) {
		if (constraint == null) {
			return false;
		}

		if (constraint instanceof IsDataTypeConstraint) {
			return ((IsDataTypeConstraint) constraint).dataType == dataType;
		}

		return false;
	}
}
