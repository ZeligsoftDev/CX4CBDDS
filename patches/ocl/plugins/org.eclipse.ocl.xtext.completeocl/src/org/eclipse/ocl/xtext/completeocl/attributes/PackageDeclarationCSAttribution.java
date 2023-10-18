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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS;

public class PackageDeclarationCSAttribution extends AbstractAttribution
{
	public static final @NonNull PackageDeclarationCSAttribution INSTANCE = new PackageDeclarationCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		PackageDeclarationCS targetElement = (PackageDeclarationCS)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == CompleteOCLCSPackage.Literals.PACKAGE_DECLARATION_CS__OWNED_CONTEXTS) {
			org.eclipse.ocl.pivot.Package pkg = targetElement.getReferredPackage();
			if (pkg != null) {
				environmentView.addAllPackages(pkg);
				environmentView.addAllTypes(pkg);
			}
		}
		return scopeView.getParent();
	}
}
