/*******************************************************************************
 * Copyright (c) 2013, 2021 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.evaluation.ModelManager.EcoreModelManager;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

public class UnboxedOppositeNavigationProperty extends AbstractProperty
{
	protected @NonNull PropertyId oppositePropertyId;

	public UnboxedOppositeNavigationProperty(@NonNull PropertyId oppositePropertyId) {
		this.oppositePropertyId = oppositePropertyId;
	}

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		IdResolver idResolver = executor.getIdResolver();
		Property oppositeProperty = idResolver.getProperty(oppositePropertyId);
		List<Object> results = null;
		ModelManager modelManager = executor.getModelManager();
		if (modelManager instanceof EcoreModelManager) {
			EObject esObject = oppositeProperty.getESObject();
			if (esObject instanceof EReference) {
				results = new ArrayList<>();
				if (sourceValue instanceof EObject) {
					EReference oppositeEReference = (EReference)esObject;
					results = new ArrayList<Object>();
					Iterable<@NonNull EObject> opposites = ((EcoreModelManager)modelManager).getOpposites(oppositeEReference, (EObject)sourceValue);
					if (opposites != null) {
						for (@NonNull EObject opposite :opposites) {
							results.add(idResolver.boxedValueOf(opposite));
						}
					}
				}
			}
		}
		if (results == null) {	// Never happens always an EcoreModelManager
			results = new ArrayList<>();
			Type thatType = ClassUtil.nonNullModel(oppositeProperty.getType());
			if (thatType instanceof CollectionType) {
				thatType = ((CollectionType)thatType).getElementType();
			}
			if (thatType instanceof org.eclipse.ocl.pivot.Class) {
				org.eclipse.ocl.pivot.Class thatClass = (org.eclipse.ocl.pivot.Class)thatType;
				ModelManager.ModelManagerExtension modelManager2 = (ModelManager.ModelManagerExtension)modelManager;
				for (@NonNull Object eObject : modelManager.get(thatClass)) {	// FIXME Use a cache
					EClass eClass = modelManager2.eClass(eObject);
					EStructuralFeature eFeature = eClass.getEStructuralFeature(oppositeProperty.getName());
					assert eFeature != null;
					Object eGet = modelManager2.eGet(eObject, eFeature);
					if (eGet == sourceValue) {
						results.add(eObject);
					}
				}
			}
		}
		if (returnTypeId instanceof CollectionTypeId) { // oppositeProperty.getOpposite().isIsMany()
			return idResolver.createCollectionOfAll(PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_ORDERED,
				PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_UNIQUE, returnTypeId, results);
		}
		int size = results.size();
		if (size <= 1) {
			return size == 1 ? results.get(0) : null;
		}
		throw new InvalidValueException("Multiple opposites for '" + oppositeProperty + "'");
	}
}
