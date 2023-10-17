/*******************************************************************************
 * Copyright (c) 2011, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * An instance of ImplicitContainerProperty supports evaluation of
 * a property call that navigates a relationship to a container.
 */
public class CompositionProperty extends AbstractProperty
{
	protected final @NonNull EReference eContainmentFeature;
	protected final @NonNull PropertyId propertyId;

	public CompositionProperty(@NonNull EReference eContainmentFeature, @NonNull PropertyId propertyId) {
		this.eContainmentFeature = eContainmentFeature;
		this.propertyId = propertyId;
	}

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		EObject eObject = asNavigableObject(sourceValue, eContainmentFeature, executor);
		EObject eContainer = eObject.eContainer();
		if (eContainer == null) {
			return null;				// No container
		}
		EReference eContainmentFeature = ClassUtil.nonNullModel(eObject.eContainmentFeature());
		if (eContainmentFeature != this.eContainmentFeature) {
			if (!isReferenced(eContainmentFeature)) {
				return null;				// Contained but by some other property
			}
//			PropertyId propertyId = IdManager.getPropertyId(eContainmentFeature);	// FIXME get this from constructor
//			if (!containmentPropertyId.equals(propertyId)) {
//				return null;				// Contained but by some other property
//			}
//			this.eContainmentFeature = eContainmentFeature;
		}
		return executor.getIdResolver().boxedValueOf(eContainer);
	}

	protected boolean isReferenced(EReference eObject) {
		EAnnotation eAnnotation = eObject.getEAnnotation(PivotConstantsInternal.SUBSETS_ANNOTATION_SOURCE);
		if (eAnnotation == null) {
			return false;
		}
		for (EObject eReference : eAnnotation.getReferences()) {
			if (eReference == this.eContainmentFeature) {
				return true;
			}
			if ((eReference instanceof EReference) && isReferenced((EReference) eReference)) {
				return true;
			}
		}
		return false;
	}
}
