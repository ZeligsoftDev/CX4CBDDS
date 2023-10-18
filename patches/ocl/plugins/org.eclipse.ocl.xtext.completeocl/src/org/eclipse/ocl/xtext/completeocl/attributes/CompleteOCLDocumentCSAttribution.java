/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.xtext.base.scoping.AbstractRootCSAttribution;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;

public class CompleteOCLDocumentCSAttribution extends AbstractRootCSAttribution
{
	public static final @NonNull CompleteOCLDocumentCSAttribution INSTANCE = new CompleteOCLDocumentCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		CompleteOCLDocumentCS targetElement = (CompleteOCLDocumentCS)target;
		EnvironmentFactoryInternal environmentFactory = environmentView.getEnvironmentFactory();
		for (ImportCS anImport : targetElement.getOwnedImports()) {
			Namespace namespace = anImport.getReferredNamespace();
			if ((namespace != null) && !namespace.eIsProxy()) {
				String importName = anImport.getName();
				if (importName != null) {
					environmentView.addElement(importName, namespace);
					environmentView.addNamedElement(namespace);
					if (namespace instanceof Model) {
						environmentView.addAllPackages((Model)namespace);
					} else if (namespace instanceof org.eclipse.ocl.pivot.Package) {		// FIXME This legacy behaviour needs cleaning up
						if (anImport.isIsAll()) {
							org.eclipse.ocl.pivot.Package rootPackage = (org.eclipse.ocl.pivot.Package)namespace;
							environmentView.addAllPackages(rootPackage);
							environmentView.addAllTypes(rootPackage);
						}
					}
				} else {
					environmentView.addNamedElement(namespace);
					if (namespace instanceof Model) {
						environmentView.addAllPackages((Model)namespace);
					} else if (namespace instanceof org.eclipse.ocl.pivot.Package) {		// FIXME This legacy behaviour needs cleaning up
						for (org.eclipse.ocl.pivot.Package rootPackage : ((org.eclipse.ocl.pivot.Package)namespace).getOwnedPackages()) {
							assert rootPackage != null;
							environmentView.addNamedElement(rootPackage);		// FIXME Rationalize root of pivot model
							environmentView.addAllPackages(rootPackage);
							environmentView.addAllTypes(rootPackage);
						}
					}
				}
			}
		}
		if (!environmentView.hasFinalResult()) {
			environmentFactory.getStandardLibrary().getOclAnyType();
			for (Library library : environmentFactory.getMetamodelManager().getLibraries()) {
				assert library != null;
				environmentView.addNamedElement(library);
			}
		}
		return null;
	}
}
