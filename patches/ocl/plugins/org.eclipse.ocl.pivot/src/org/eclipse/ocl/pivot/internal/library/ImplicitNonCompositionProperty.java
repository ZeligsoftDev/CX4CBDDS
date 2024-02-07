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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.evaluation.ModelManager.EcoreModelManager;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.values.InvalidValueException;

import com.google.common.collect.Iterables;

/**
 * An instance of ImplicitNonCompositionProperty supports evaluation of an implicit (unnavigable opposite) property
 * searching the ModelManager's cache of opposite types for the one that has the source as an opposite opposite target.
 *
 * This includes the implicit opposite for a UML extension_XXXX in a statically compiled profile.
 */
public class ImplicitNonCompositionProperty extends AbstractProperty
{
	protected @NonNull Property property;

	public ImplicitNonCompositionProperty(@NonNull Property property) {
		this.property = property;
	}

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		if (sourceValue == null) {
			return null;
		}
		IdResolver idResolver = executor.getIdResolver();
		Property oppositeProperty = property.getOpposite();
		Iterable<Object> results = null;
		ModelManager modelManager = executor.getModelManager();
		if (modelManager instanceof EcoreModelManager) {
			EObject esObject = oppositeProperty.getESObject();
			if (esObject instanceof EReference) {
				List<Object> resultList = new ArrayList<>();
				if (sourceValue instanceof EObject) {
					EReference oppositeEReference = (EReference)esObject;
					results = new ArrayList<Object>();
					Iterable<@NonNull EObject> opposites = ((EcoreModelManager)modelManager).getOpposites(oppositeEReference, (EObject)sourceValue);
					if (opposites != null) {
						for (@NonNull EObject opposite :opposites) {
							resultList.add(idResolver.boxedValueOf(opposite));
						}
					}
				}
				results = resultList;
			}
		}
		if (results == null) {	// Never happens always an EcoreModelManager
			results = new ArrayList<>();
			ModelManager.ModelManagerExtension2 modelManager2 = (ModelManager.ModelManagerExtension2)modelManager;
			results = modelManager2.getOpposite(oppositeProperty, sourceValue);
		}
		if (returnTypeId instanceof CollectionTypeId) { // property.isIsMany()
			return idResolver.createCollectionOfAll(PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_ORDERED,
				PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_UNIQUE, returnTypeId, results);
		}
		int size = Iterables.size(results);
		if (size <= 1) {
			return size == 1 ? results.iterator().next() : null;
		}
		throw new InvalidValueException("Multiple opposites for '" + oppositeProperty + "'");
	}
}