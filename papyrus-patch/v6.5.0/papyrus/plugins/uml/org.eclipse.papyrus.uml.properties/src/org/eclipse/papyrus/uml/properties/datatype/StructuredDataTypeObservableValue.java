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
package org.eclipse.papyrus.uml.properties.datatype;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.GMFObservableValue;

/**
 * Allows the manipulation of a UML DataType from a static profile (Implemented by an EMF EDataType)
 *
 * @author Camille Letavernier
 */
public class StructuredDataTypeObservableValue extends GMFObservableValue implements IAdaptable {

	protected EDataType type;

	protected DataTypeObservableValue observable;

	public StructuredDataTypeObservableValue(EObject owner, EStructuralFeature feature, EditingDomain domain, EDataType type) {
		super(owner, feature, domain);
		this.type = type;
	}

	@Override
	public Object getValueType() {
		return Object.class;
	}

	@Override
	protected Object doGetValue() {
		if (observable == null) {
			observable = DataTypeProvider.instance.getObservableDataType(type);
			observable.setOwner(eObject, eStructuralFeature, domain, type);
			observable.setValue(super.doGetValue());
		}
		return observable;
	}

	public void unset() {
		setValue(null);
	}

	@Override
	protected void doSetValue(Object value) { // value = dataType instance
		super.doSetValue(value); // TODO : real type of the value ? type compatibility ?

	}

	@Override
	public Object getAdapter(Class adapter) {
		throw new UnsupportedOperationException();
	}
}
