/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;

public class PropertyAttribution extends AbstractAttribution
{
	public static final PropertyAttribution INSTANCE = new PropertyAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		Property targetElement = (Property)target;
		if (environmentView.getRequiredType() == PivotPackage.Literals.PROPERTY) {
			Type type = targetElement.getType();
			while (type instanceof CollectionType) {
				type = ((CollectionType)type).getElementType();
			}
			if (type instanceof org.eclipse.ocl.pivot.Class) {
				environmentView.addAllProperties((org.eclipse.ocl.pivot.Class)type, FeatureFilter.SELECT_NON_STATIC);
			}
			else if (type instanceof TemplateParameter) {
				for (org.eclipse.ocl.pivot.@NonNull Class constrainingClass : ClassUtil.nullFree(((TemplateParameter)type).getConstrainingClasses())) {
					environmentView.addAllProperties(constrainingClass, FeatureFilter.SELECT_NON_STATIC);
				}
			}
		}
		return scopeView.getParent();
	}
}
