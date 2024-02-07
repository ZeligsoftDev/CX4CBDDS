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
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage;

public class ClassifierContextCSAttribution extends AbstractAttribution
{
	public static final @NonNull ClassifierContextCSAttribution INSTANCE = new ClassifierContextCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ClassifierContextDeclCS targetElement = (ClassifierContextDeclCS)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == CompleteOCLCSPackage.Literals.CLASSIFIER_CONTEXT_DECL_CS__OWNED_INVARIANTS) {
			org.eclipse.ocl.pivot.Class type = targetElement.getReferredClass();
			if (type != null) {
				environmentView.addAllOperations(type, FeatureFilter.SELECT_NON_STATIC);
				environmentView.addAllProperties(type, FeatureFilter.SELECT_NON_STATIC);
			}
		}
		return scopeView.getParent();
	}
}
