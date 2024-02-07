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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Interface to be implemented by specific DataType Observable values
 *
 * @author Camille Letavernier
 *
 */
public interface DataTypeObservableValue extends IObservableValue {

	public void setOwner(EObject owner, EStructuralFeature feature, EditingDomain domain, EDataType type);

}
