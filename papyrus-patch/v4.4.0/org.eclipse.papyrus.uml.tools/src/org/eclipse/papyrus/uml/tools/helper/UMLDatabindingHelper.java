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
package org.eclipse.papyrus.uml.tools.helper;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableValue;

/**
 * A Helper class for UML Databinding
 *
 * @author Camille Letavernier
 *
 * @deprecated since 3.2
 *             Use the {@link org.eclipse.papyrus.uml.properties.databinding.helpers.UMLDatabindingHelper} API, instead
 *
 *             This class Will be removed in Papyrus 5.0, see bug 540829
 */
@Deprecated
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
		return domain == null ? EMFProperties.value(feature).observe(source) : new PapyrusObservableValue(source, feature, domain);
	}
}
