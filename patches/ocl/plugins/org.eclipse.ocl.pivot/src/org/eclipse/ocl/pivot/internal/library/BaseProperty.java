/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.utilities.NameUtil;

/**
 * The static instance of ExplicitNavigationProperty supports evaluation of
 * a property call that navigates a relationship.
 */
public class BaseProperty extends AbstractProperty
{
	protected final @NonNull Property property;
	
	public BaseProperty(@NonNull Property property) {
		this.property = property;
	}
	
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
//		return property.getType(); 
		if (sourceValue instanceof ElementExtension) {
			return ((ElementExtension)sourceValue).eContainer(); 
		}
		if (sourceValue instanceof EObject) {
			EObject eObject = (EObject)sourceValue;
			EClass eClass = eObject.eClass();
			EStructuralFeature eFeature = NameUtil.getENamedElement(eClass.getEAllStructuralFeatures(), property.getName());
			if (eFeature != null) {
				Object baseObject = eObject.eGet(eFeature);
				return baseObject;
			}
		}
		return null;
	}
}