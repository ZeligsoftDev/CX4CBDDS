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
package org.eclipse.ocl.pivot.uml.internal.library;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.StereotypeProperty;

/**
 * An instance of StereotypeProperty supports evaluation of a property call that accesses a stereotype extension property.
 */
public class UMLStereotypeProperty extends StereotypeProperty
{
	public UMLStereotypeProperty(@NonNull Property property) {
		super(property);
	}
	
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		IdResolver idResolver = executor.getIdResolver();
		EObject eObject = asNavigableObject(sourceValue, property, executor);
		Object boxedValue = null;
		if (eObject instanceof UMLElementExtension) {
			Object unboxedValue = ((UMLElementExtension)eObject).getValue(idResolver, property);
			boxedValue = unboxedValue != null ? idResolver.boxedValueOf(unboxedValue/*, eFeature, callExp.getTypeId()*/) : null;
			return boxedValue;
		}
		else  {
			return super.evaluate(executor, returnTypeId, sourceValue);
		}
	}
}