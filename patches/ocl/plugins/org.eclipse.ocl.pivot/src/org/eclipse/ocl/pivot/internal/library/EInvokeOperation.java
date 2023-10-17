/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractOperation;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * An EInvokeOperation supports evaluation of an operation call by using eInvoke on the underlying eObject.
 */
public class EInvokeOperation extends AbstractOperation
{
	protected final @NonNull EOperation eOperation;

	public EInvokeOperation(@NonNull EOperation eOperation) {
		this.eOperation = eOperation;
		EClassifier eType = eOperation.getEType();
		if (eType == null) {
			throw new IllegalArgumentException("Non-query EOperation");
		}
	}

	@Override
	public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] boxedSourceAndArgumentValues) {
		TypeId returnTypeId = caller.getTypeId();
		EObject eObject = asNavigableObject(boxedSourceAndArgumentValues[0], eOperation, executor);
		//		EList<Object> ecoreArguments = executor.getIdResolver().ecoreValuesOfEach(null, boxedArgumentValues);
		IdResolver idResolver = executor.getIdResolver();
		EList<EParameter> eParameters = eOperation.getEParameters();
		Object[] ecoreValues = new Object[boxedSourceAndArgumentValues.length-1];
		int iMax = Math.min(boxedSourceAndArgumentValues.length-1, eParameters.size());
		for (int i = 0; i < iMax; i++) {
			Object argumentValue = boxedSourceAndArgumentValues[1+i];
			EParameter eParameter = eParameters.get(i);
			ecoreValues[i] = idResolver.ecoreValueOf(eParameter.getEType().getInstanceClass(), argumentValue);
		}
		EList<Object> ecoreArguments = new EcoreEList.UnmodifiableEList<Object>(null, null, iMax, ecoreValues);
		try {
			Object eResult = eObject.eInvoke(eOperation, ecoreArguments);
			return getResultValue(executor, returnTypeId, eResult);
		} catch (InvocationTargetException e) {
			return createInvalidValue(e);
		}
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @Nullable Object dispatch(@NonNull Executor executor, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
		TypeId typeId = callExp.getTypeId();
		List<? extends OCLExpression> arguments = callExp.getOwnedArguments();
		if (arguments.size() == 0) {
			return evaluate(executor, typeId, sourceValue);
		}
		OCLExpression argument0 = arguments.get(0);
		assert argument0 != null;
		Object firstArgument = executor.evaluate(argument0);
		if (arguments.size() == 1) {
			return evaluate(executor, typeId, sourceValue, firstArgument);
		}
		OCLExpression argument1 = arguments.get(1);
		assert argument1 != null;
		Object secondArgument = executor.evaluate(argument1);
		if (arguments.size() == 2) {
			return evaluate(executor, typeId, sourceValue, firstArgument, secondArgument);
		}
		@Nullable Object[] argumentValues = new @Nullable Object[arguments.size()];
		argumentValues[0] = firstArgument;
		argumentValues[1] = secondArgument;
		for (int i = 2; i < arguments.size(); i++) {
			OCLExpression argument = arguments.get(i);
			assert argument != null;
			argumentValues[i] = executor.evaluate(argument);
		}
		return evaluate(executor, typeId, sourceValue, argumentValues);
	}

	/** @deprecated use Executor */
	@Deprecated
	public @Nullable Object evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object @NonNull ... boxedArgumentValues) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceValue, boxedArgumentValues);
	}

	/**
	 * @since 1.1
	 */
	/** @deprecated use boxedSourceAndArgumentValues */
	@Deprecated
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue,
			@Nullable Object... boxedArgumentValues) {
		EObject eObject = asNavigableObject(sourceValue, eOperation, executor);
		//		EList<Object> ecoreArguments = executor.getIdResolver().ecoreValuesOfEach(null, boxedArgumentValues);
		IdResolver idResolver = executor.getIdResolver();
		EList<EParameter> eParameters = eOperation.getEParameters();
		Object[] ecoreValues = new Object[boxedArgumentValues.length];
		int iMax = Math.min(boxedArgumentValues.length, eParameters.size());
		for (int i = 0; i < iMax; i++) {
			Object argumentValue = boxedArgumentValues[i];
			EParameter eParameter = eParameters.get(i);
			ecoreValues[i] = idResolver.ecoreValueOf(eParameter.getEType().getInstanceClass(), argumentValue);
		}
		EList<Object> ecoreArguments = new EcoreEList.UnmodifiableEList<Object>(null, null, iMax, ecoreValues);
		try {
			Object eResult = eObject.eInvoke(eOperation, ecoreArguments);
			return getResultValue(executor, returnTypeId, eResult);
		} catch (InvocationTargetException e) {
			return createInvalidValue(e);
		}
	}

	/** @deprecated use Executor */
	@Deprecated
	protected @Nullable Object getResultValue(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object eResult) {
		return evaluate(getExecutor(evaluator), returnTypeId, eResult);
	}

	/**
	 * @since 1.1
	 */
	protected @Nullable Object getResultValue(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object eResult) {
		if (returnTypeId instanceof CollectionTypeId) {
			if (eResult instanceof Iterable<?>) {
				return executor.getIdResolver().createCollectionOfAll((CollectionTypeId)returnTypeId, (Iterable<?>)eResult);
			}
			else {
				throw new InvalidValueException("Non-iterable result");
			}
		} else if (eResult != null) {
			@SuppressWarnings("null") @NonNull EClassifier eType = eOperation.getEType();
			return executor.getIdResolver().boxedValueOf(eResult, eType);
		}
		else {
			return null;
		}
	}
}