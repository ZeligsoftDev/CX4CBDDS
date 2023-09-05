/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.databinding;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.uml.properties.messages.Messages;
import org.eclipse.uml2.uml.Package;

/**
 * Observable value of Imported Package's location.
 * 
 * @author Gabriel Pascual
 *
 */
public class ImportedPackageLocationObservableValue extends AbstractObservableValue {

	/** The Constant UNKNOWN_LOCATION. */
	private static final String UNKNOWN_LOCATION = Messages.ImportedPackageLocationObservableValue_Unknown;

	/** The imported package. */
	private Package importedPackage = null;


	/**
	 * Instantiates a new imported package location.
	 *
	 * @param source
	 *            the source
	 */
	public ImportedPackageLocationObservableValue(Package source) {
		super();
		importedPackage = source;
	}

	/**
	 * @see org.eclipse.core.databinding.observable.value.IObservableValue#getValueType()
	 *
	 * @return
	 */
	public Object getValueType() {
		return String.class;
	}

	/**
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doGetValue()
	 *
	 * @return
	 */
	@Override
	protected Object doGetValue() {
		String location = UNKNOWN_LOCATION;

		if (importedPackage.eIsProxy()) {
			location = EcoreUtil.getURI(importedPackage).trimFragment().toString();
		} else if (importedPackage.eResource() != null) {
			URI uri = importedPackage.eResource().getURI();
			if (uri != null) {
				location = uri.toString();
			}
		}
		return location;
	}

}
