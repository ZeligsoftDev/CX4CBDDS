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
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;

/**
 * Utility class to manipulate model libraries
 */
public class LibraryHelper {

	public static Set<PackageImport> getAllImportedPackages(ModelSet modelSet) {
		UmlModel umlModel = (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);

		if (umlModel != null) {
			Resource mainUMLResource = umlModel.getResource();

			final Set<PackageImport> allImportedPackages = new HashSet<PackageImport>();

			Iterator<EObject> allContents = mainUMLResource.getAllContents();

			while (allContents.hasNext()) {
				EObject currentElement = allContents.next();
				if (currentElement instanceof Package) {
					Package currentPackage = (Package) currentElement;
					allImportedPackages.addAll(currentPackage.getPackageImports());
				}
			}
			return allImportedPackages;
		}

		return Collections.emptySet();
	}
}
