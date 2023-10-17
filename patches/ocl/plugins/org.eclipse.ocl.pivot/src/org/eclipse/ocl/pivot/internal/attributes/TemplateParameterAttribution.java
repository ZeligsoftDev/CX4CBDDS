/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class TemplateParameterAttribution extends AbstractAttribution
{
	public static final TemplateParameterAttribution INSTANCE = new TemplateParameterAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		TemplateParameter targetClass = (TemplateParameter) target;
		for (org.eclipse.ocl.pivot.@NonNull Class constrainingClass : ClassUtil.nullFree(targetClass.getConstrainingClasses())) {
			environmentView.addAllOperations(constrainingClass, null);
			environmentView.addAllProperties(constrainingClass, null);
			environmentView.addAllStates(constrainingClass);
		}
		for (ScopeView parentScopeView = scopeView.getParent(); true; parentScopeView = parentScopeView.getParent()) {
			EObject parentTarget = parentScopeView.getTarget();
			if (parentTarget == null) {
				return null;
			}
			if (parentTarget instanceof TemplateableElement) {
				return parentScopeView;
			}
			if (parentTarget instanceof org.eclipse.ocl.pivot.Package) {
				return parentScopeView;
			}
		}
	}
}
