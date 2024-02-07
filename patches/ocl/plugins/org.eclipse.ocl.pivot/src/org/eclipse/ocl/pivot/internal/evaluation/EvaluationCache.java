/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.TracingOption;

/**
 * An EvaluationCache caches the results of each distinct operation implementation and source and argument value
 * for re-use if the same implementation is re-attempted.
 *
 * The cache is normally accessed as a consequence of AbstractOperation.evaluate redirecting to the cache.
 * A call-back to AbstractOperation.basicEvaluate occurs when evaluation is actually necessary.
 *
 * The cache is bypassed for derived implementations that override AbstractOperation.evaluate.
 *
 * @since 1.3
 */
public class EvaluationCache
{
	public static final @NonNull TracingOption EVALUATIONS = new TracingOption(PivotPlugin.PLUGIN_ID, "evaluations");

	/**
	 * An EvaluationResult maintains the cached result of the invocation of implementation with theseValues.
	 */
	private static final class EvaluationResult
	{
		private final LibraryOperation.@NonNull LibraryOperationExtension2 implementation;
		private final @Nullable Object @NonNull [] theseValues;
		private final @Nullable Object result;

		public EvaluationResult(LibraryOperation.@NonNull LibraryOperationExtension2 implementation, @Nullable Object @NonNull [] theseValues, @Nullable Object result) {
			this.implementation = implementation;
			this.theseValues = theseValues;
			this.result = result;
		}

		public @Nullable Object getResult() {
			return result;
		}

		public boolean isEqual(@NonNull IdResolver idResolver, LibraryOperation.@NonNull LibraryOperationExtension2 implementation, @Nullable Object @NonNull [] thoseValues) {
			if (this.implementation != implementation) {
				return false;
			}
			Object [] theseValues2 = theseValues; // JDT 4.5 cannot handle @Nullable
			Object [] thoseValues2 = thoseValues;
			int iMax = thoseValues2.length;
			if (iMax != theseValues2.length) {
				return false;
			}
			for (int i = 0; i < iMax; i++) {
				if (!idResolver.oclEquals(theseValues2[i], thoseValues2[i])) {
					return false;
				}
			}
			return true;
		}
	}

	protected final @NonNull Executor executor;

	/**
	 * Map from implementation, source, arguments hashCode to one or more evaluations with that hashCode. Single map entries use the
	 * EvaluationResult directly as the entry. Colliding entries use a List<@NonNull EvaluationResult> for the collisions.
	 * <br>
	 * This map is used to inhibit repeated evaluations.
	 */
	private final @NonNull Map<@NonNull Integer, @NonNull Object> hashCode2evaluations = new HashMap<@NonNull Integer, @NonNull Object>();

	protected final boolean debugEvaluations = EVALUATIONS.isActive();

	public EvaluationCache(@NonNull Executor executor) {
		this.executor = executor;
	}

	public void dispose() {
		hashCode2evaluations.clear();
	}

	public @Nullable Object getCachedEvaluationResult(LibraryOperation.@NonNull LibraryOperationExtension2 implementation, @NonNull TypedElement caller, @Nullable Object @NonNull ... sourceAndArgumentValues) {
		IdResolver.@NonNull IdResolverExtension idResolver = (IdResolver.IdResolverExtension) executor.getIdResolver();
		int hashCode = implementation.hashCode();
		for (@Nullable Object sourceAndArgumentValue : sourceAndArgumentValues) {
			hashCode = 3 * hashCode + idResolver.oclHashCode(sourceAndArgumentValue);
		}
		synchronized (hashCode2evaluations) {
			Object zeroOrMoreEvaluations = hashCode2evaluations.get(hashCode);
			EvaluationResult oneEvaluation = null;
			if (zeroOrMoreEvaluations instanceof EvaluationResult) {
				oneEvaluation = (EvaluationResult)zeroOrMoreEvaluations;
				if (oneEvaluation.isEqual(idResolver, implementation, sourceAndArgumentValues)) {
					if (debugEvaluations) {
						EVALUATIONS.println("old:" + oneEvaluation);
					}
					return oneEvaluation.getResult();
				}
			}
			else if (zeroOrMoreEvaluations instanceof List<?>) {
				@SuppressWarnings("unchecked")@NonNull List<@NonNull EvaluationResult> zeroOrMoreEvaluations2 = (List<@NonNull EvaluationResult>)zeroOrMoreEvaluations;
				for (@NonNull EvaluationResult aEvaluation : zeroOrMoreEvaluations2) {
					if (aEvaluation.isEqual(idResolver, implementation, sourceAndArgumentValues)) {
						if (debugEvaluations) {
							EVALUATIONS.println("old:" + aEvaluation);
						}
						return aEvaluation.getResult();
					}
				}
			}
		}
		//
		//	Must resynchronize after newInstance creation and execution in case the execution is recursive.
		//
		Object result = implementation.basicEvaluate(executor, caller, sourceAndArgumentValues);
		EvaluationResult theEvaluation = new EvaluationResult(implementation, sourceAndArgumentValues, result);
		synchronized (hashCode2evaluations) {
			Object zeroOrMoreEvaluations = hashCode2evaluations.get(hashCode);
			if (zeroOrMoreEvaluations == null) {
				hashCode2evaluations.put(hashCode, theEvaluation);
			}
			else if (zeroOrMoreEvaluations instanceof EvaluationResult) {
				EvaluationResult oneEvaluation = (EvaluationResult)zeroOrMoreEvaluations;
				if (oneEvaluation.isEqual(idResolver, implementation, sourceAndArgumentValues)) {
					if (debugEvaluations) {
						EVALUATIONS.println("old:" + oneEvaluation);
					}
					return oneEvaluation.getResult();
				}
				List<@NonNull EvaluationResult> twoOrMoreEvaluations = new ArrayList<>(4);
				twoOrMoreEvaluations.add(oneEvaluation);
				twoOrMoreEvaluations.add(theEvaluation);
				hashCode2evaluations.put(hashCode, twoOrMoreEvaluations);
			}
			else if (zeroOrMoreEvaluations instanceof List<?>) {
				@SuppressWarnings("unchecked")@NonNull List<@NonNull EvaluationResult> twoOrMoreEvaluations = (List<@NonNull EvaluationResult>)zeroOrMoreEvaluations;
				for (@NonNull EvaluationResult aEvaluation : twoOrMoreEvaluations) {
					if (aEvaluation.isEqual(idResolver, implementation, sourceAndArgumentValues)) {
						if (debugEvaluations) {
							EVALUATIONS.println("old:" + aEvaluation);
						}
						return aEvaluation.getResult();
					}
				}
				twoOrMoreEvaluations.add(theEvaluation);
			}
			if (debugEvaluations) {
//				EVALUATIONS.println("new:" + theEvaluation);
			}
			return theEvaluation.getResult();
		}
	}
}