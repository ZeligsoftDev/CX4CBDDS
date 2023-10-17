/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.attributes;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

public class PackageAttribution extends AbstractAttribution
{
	public static final PackageAttribution INSTANCE = new PackageAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		org.eclipse.ocl.pivot.Package targetPackage = (org.eclipse.ocl.pivot.Package)target;
		if ((targetPackage.getImportedPackages().size() > 0) && !environmentView.isQualified()) {
			Set<org.eclipse.ocl.pivot.@NonNull Package> importedPackageClosure = PivotUtil.getImportedPackageClosure(environmentView.getEnvironmentFactory().getCompleteModel(), targetPackage);
			for (org.eclipse.ocl.pivot.@NonNull Package aPackage : importedPackageClosure) {
				environmentView.addAllPackages(aPackage);
				environmentView.addAllTypes(aPackage);
			}
		}
		else {
			environmentView.addAllPackages(targetPackage);
			environmentView.addAllTypes(targetPackage);
		}
		return scopeView.getParent();
	}
}
