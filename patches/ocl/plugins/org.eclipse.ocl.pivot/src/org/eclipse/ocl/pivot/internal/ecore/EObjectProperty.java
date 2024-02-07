/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ecore;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * An EObjectProperty provides the standard LibraryProperty to implement a
 * PropertyCallExp. When constructed with a null specification, the call just accesses
 * the property field in a source object. When constructed with a non-null specification,
 * the specification defines the access algorithm, which if provided as an ExpressionInOCL
 * is lazily compiled from OCL source text.
 */
@Deprecated /* @deprecated ImplementationManager.getPropertyImplementation avoids the context-losing delegation to Ecore and back again - see Bug 543221 */
public class EObjectProperty extends AbstractProperty
{
	protected final @NonNull EStructuralFeature eFeature;
	protected @Nullable ExpressionInOCL specification;

	public EObjectProperty(@NonNull EStructuralFeature eFeature, @Nullable ExpressionInOCL specification) {
		this.eFeature = eFeature;
		this.specification = specification;
	}

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		Object object = asObject(sourceValue);
		if (!(object instanceof EObject)) {
			throw new InvalidValueException("non-EObject");
		}
		Object eValue = ((EObject)object).eGet(eFeature);
		return eValue != null ? executor.getIdResolver().boxedValueOf(eValue, eFeature, returnTypeId) : null;
	}
}