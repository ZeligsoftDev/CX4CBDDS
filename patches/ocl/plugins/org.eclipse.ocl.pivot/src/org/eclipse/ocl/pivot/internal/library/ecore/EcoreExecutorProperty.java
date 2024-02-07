/*******************************************************************************
 * Copyright (c) 2011, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.ecore;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;

public class EcoreExecutorProperty extends ExecutorProperty implements LibraryProperty.LibraryPropertyExtension
{			// FIXME Eliminate spurious ExecutorProperty rather than AbstractExecutorProperty once API has evolved publicly

	protected final @NonNull EStructuralFeature eFeature;

	public EcoreExecutorProperty(/*@NonNull*/ EStructuralFeature eFeature, @NonNull Type executorType, int propertyIndex) {
		super(ClassUtil.nonNullModel(eFeature.getName()), executorType, propertyIndex);
		this.eFeature = eFeature;
	}

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable Object evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		return evaluate(evaluator, returnTypeId, sourceValue);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		EObject eObject = ValueUtil.asNavigableObject(sourceValue, eFeature, executor);
		Object eValue = eObject.eGet(eFeature);
		return eValue != null ? executor.getIdResolver().boxedValueOf(eValue, eFeature, returnTypeId) : null;
	}

	public @NonNull EStructuralFeature getEFeature() {
		return eFeature;
	}

	@Override
	public EObject getESObject() {
		return eFeature;
	}

	@Override
	public @NonNull LibraryProperty getImplementation() {
		return this;
	}

	@Override
	public void initValue(@NonNull Object objectValue, @Nullable Object propertyValue) {
		((EObject)objectValue).eSet(eFeature, propertyValue);
	}

	@Override
	public boolean isIsMany() {
		return eFeature.isMany();
	}

	@Override
	public boolean isIsRequired() {
		return eFeature.isRequired();
	}
}