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

package org.eclipse.papyrus.uml.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.uml.properties.databinding.ImportedPackageLocationObservableValue;
import org.eclipse.uml2.uml.Package;

/**
 * 
 * Model element of Imported Package.
 * 
 * @author Gabriel Pascual
 *
 */
public class ImportedPackageModelElement extends EMFModelElement {

	/** The Constant LOCATION_PROPERTY_PATH. */
	private final static String LOCATION_PROPERTY_PATH = "location"; //$NON-NLS-1$

	/**
	 * Constructor.
	 *
	 * @param source
	 *            the source
	 * @param domain
	 *            the domain
	 */
	public ImportedPackageModelElement(EObject source, EditingDomain domain) {
		super(source, domain);
	}

	/**
	 * @see org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement#doGetObservable(java.lang.String)
	 *
	 * @param propertyPath
	 * @return
	 */
	@Override
	protected IObservable doGetObservable(String propertyPath) {

		// Location of Imported Package
		if (LOCATION_PROPERTY_PATH.equals(propertyPath)) {
			return new ImportedPackageLocationObservableValue((Package) source);
		}

		return super.doGetObservable(propertyPath);
	}

}
