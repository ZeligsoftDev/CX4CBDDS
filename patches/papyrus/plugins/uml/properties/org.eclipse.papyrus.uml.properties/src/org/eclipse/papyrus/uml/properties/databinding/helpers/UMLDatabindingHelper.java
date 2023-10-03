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
package org.eclipse.papyrus.uml.properties.databinding.helpers;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.GMFObservableValue;

/**
 * A Helper class for UML Databinding
 *
 * @author Camille Letavernier
 * @since 3.3
 */
public class UMLDatabindingHelper {

	/**
	 * Returns an IObservableValue for the given feature and EObject
	 *
	 * If the EditingDomain is set, the IObservableValue will use the Papyrus ServiceEdit ;
	 * otherwise, a standard EMFObservableValue will be used
	 *
	 * @param source
	 *            The EObject to observe
	 * @param feature
	 *            The feature to observe
	 * @param domain
	 *            The editing domain on which the commands will be executed. If null, direct
	 *            object modifications will be used.
	 * @return
	 * 		The IObservableValue
	 */
	public static IObservableValue getObservableValue(EObject source, EStructuralFeature feature, EditingDomain domain) {
		return domain == null ? EMFProperties.value(feature).observe(source) : new GMFObservableValue(source, feature, domain);
	}
}
