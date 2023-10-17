/*******************************************************************************
 * Copyright (c) 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.serializer;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.serializer.DiagnosticStringBuilder.SerializationMetaDataDiagnosticStringBuilder;

/**
 * A SerializationMatchStep specifies a run-time action as part of the cardinality variable determination.
 * An expression may be assigned to or checked against some variable. A candidate SerializationRule is only
 * eligible for use once all its SerializationMatchStep have been satisfied.
 */
public abstract class SerializationMatchStep
{
	/**
	 * An Assert match step requires a given expression to be zero-valued to allow the invoking DynamicRuleMatch to succeed.
	 */
	public static class MatchStep_Assert extends SerializationMatchStep
	{
		protected final @NonNull SerializationMatchTerm matchTerm;

		public MatchStep_Assert(@NonNull SerializationMatchTerm matchTerm) {
			this.matchTerm = matchTerm;
		}

		@Override
		public int computeHashCode() {
			return super.computeHashCode() + 5 * matchTerm.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof MatchStep_Assert)) {
				return false;
			}
			MatchStep_Assert that = (MatchStep_Assert)obj;
			return this.matchTerm.equals(that.matchTerm);
		}

		@Override
		public boolean execute(@NonNull DynamicRuleMatch dynamicRuleMatch) {
			Integer newIntegerSolution = matchTerm.basicGetIntegerSolution(dynamicRuleMatch);
			if (newIntegerSolution == null) {
				dynamicRuleMatch.setFailedMatch(this);
				return false;
			}
			boolean isOk = newIntegerSolution.equals(0);
			if (!isOk) {
				dynamicRuleMatch.setFailedMatch(this);
			}
			return isOk;
		}

		@Override
		public @NonNull String getFailureReason(@NonNull DynamicRuleMatch dynamicRuleMatch) {
			Integer newIntegerSolution = matchTerm.basicGetIntegerSolution(dynamicRuleMatch);
			if (newIntegerSolution == null) {
				return "Failed to solve for " + matchTerm;
			}
			return newIntegerSolution + " rather than 0 for " + matchTerm;
		}

		public @NonNull SerializationMatchTerm getMatchTerm() {
			return matchTerm;
		}

		@Override
		public @NonNull Set<@NonNull SerializationMatchTerm> getMatchTermClosure() {
			return matchTerm.getChildClosure();
		}

		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("assert ");
			matchTerm.toString(s);
			s.append(" == 0");
		}
	}

	/**
	 * An Assign match step computes the value of a variable on behalf of the invoking DynamicRuleMatch.
	 */
	public static class MatchStep_Assign extends SerializationMatchStep
	{
		protected final int variableIndex;
		protected final @NonNull SerializationMatchTerm matchTerm;

		public MatchStep_Assign(int variableIndex, @NonNull SerializationMatchTerm matchTerm) {
			this.variableIndex = variableIndex;
			this.matchTerm = matchTerm;
		}

		@Override
		public int computeHashCode() {
			return super.computeHashCode() + 5 * matchTerm.hashCode() + 7 * variableIndex;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof MatchStep_Assign)) {
				return false;
			}
			MatchStep_Assign that = (MatchStep_Assign)obj;
			return this.matchTerm.equals(that.matchTerm)
				&& (this.variableIndex == that.variableIndex);
		}

		@Override
		public boolean execute(@NonNull DynamicRuleMatch dynamicRuleMatch) {
			Integer newIntegerSolution = matchTerm.basicGetIntegerSolution(dynamicRuleMatch);
			if (newIntegerSolution == null) {
				dynamicRuleMatch.setFailedMatch(this);
				return false;
			}
			assert variableIndex >= 0;
			dynamicRuleMatch.putValue(variableIndex, newIntegerSolution);
			return true;
		}

		@Override
		public @NonNull String getFailureReason(@NonNull DynamicRuleMatch dynamicRuleMatch) {
			return "Failed to solve for " + matchTerm;
		}

		public @NonNull SerializationMatchTerm getMatchTerm() {
			return matchTerm;
		}

		@Override
		public @NonNull Set<@NonNull SerializationMatchTerm> getMatchTermClosure() {
			return matchTerm.getChildClosure();
		}

		public int getVariableIndex() {
			return variableIndex;
		}

		@Override
		public boolean isAssignTo(int variableIndex) {
			return this.variableIndex == variableIndex;
		}

		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("assign ");
			s.appendVariableName(variableIndex);
			s.append(" = ");
			matchTerm.toString(s);
		}
	}

	/**
	 * A RuleCheck match step checks that a slot value conforms to a rule required by a rule assignment on behalf of the invoking DynamicRuleMatch=.
	 */
	public static class MatchStep_RuleCheck extends SerializationMatchStep
	{
		protected final @NonNull EReference eReference;
		protected final @NonNull GrammarRuleVector ruleValueIndexes;

		public MatchStep_RuleCheck(/*@NonNull*/ EReference eReference, @NonNull GrammarRuleVector ruleValueIndexes) {
			assert eReference != null;
			this.eReference = eReference;
			this.ruleValueIndexes = ruleValueIndexes;
			assert eReference.isContainment();
		}

		@Override
		public int computeHashCode() {
			return super.computeHashCode() + 5 * eReference.hashCode() + 7 * ruleValueIndexes.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof MatchStep_RuleCheck)) {
				return false;
			}
			MatchStep_RuleCheck that = (MatchStep_RuleCheck)obj;
			return (this.eReference == that.eReference)
				&& this.ruleValueIndexes.equals(that.ruleValueIndexes);
		}

		@Override
		public boolean execute(@NonNull DynamicRuleMatch dynamicRuleMatch) {
			UserElementAnalysis elementAnalysis = dynamicRuleMatch.getElementAnalysis();
			UserModelAnalysis modelAnalysis = elementAnalysis.getModelAnalysis();
			EObject eObject = elementAnalysis.getEObject();
			if (!eReference.getEContainingClass().isInstance(eObject)) {
				dynamicRuleMatch.setFailedMatch(this);
				return false;
			}
			Object slotContent = eObject.eGet(eReference);
			if (eReference.isMany()) {
				for (Object element : (List<?>)slotContent) {
					@SuppressWarnings("null")
					@NonNull EObject castElement = (@NonNull EObject)element;
					if (!isInstance(modelAnalysis, castElement)) {
						dynamicRuleMatch.setFailedMatch(this);
						return false;
					}
				}
			}
			else if (slotContent != null) {
				if (!isInstance(modelAnalysis, (EObject)slotContent)) {
					dynamicRuleMatch.setFailedMatch(this);
					return false;
				}
			}
			else {}				// Null is never actually serialized, */
			return true;
		}

		public @NonNull EReference getEReference() {
			return eReference;
		}

		@Override
		public @NonNull String getFailureReason(@NonNull DynamicRuleMatch dynamicRuleMatch) {
			UserElementAnalysis elementAnalysis = dynamicRuleMatch.getElementAnalysis();
			UserModelAnalysis modelAnalysis = elementAnalysis.getModelAnalysis();
			EObject eObject = elementAnalysis.getEObject();
			if (!eReference.getEContainingClass().isInstance(eObject)) {
				return eReference.getName() + " container is " + eObject.eClass().getName() + " rather than " + eReference.getEContainingClass().getName();
			}
			Object slotContent = eObject.eGet(eReference);
			if (eReference.isMany()) {
				for (Object element : (List<?>)slotContent) {
					@SuppressWarnings("null")
					@NonNull EObject castElement = (@NonNull EObject)element;
					String failureReason = isInstanceWithReason(modelAnalysis, castElement);
					if (failureReason != null) {
						return failureReason;
					}
				}
			}
			else if (slotContent != null) {
				String failureReason = isInstanceWithReason(modelAnalysis, (EObject)slotContent);
				if (failureReason != null) {
					return failureReason;
				}
			}
			else {}				// Null is never actually serialized, */
			return "BUG - no reason available";
		}

		protected @Nullable String isInstanceWithReason(@NonNull UserModelAnalysis modelAnalysis, @NonNull EObject slotContent) {
			UserElementAnalysis childElementAnalysis = modelAnalysis.getElementAnalysis(slotContent);
			for (@NonNull Integer ruleValueIndex : ruleValueIndexes) {
				DynamicRuleMatch dynamicRuleMatch = childElementAnalysis.basicCreateDynamicRuleMatch(ruleValueIndex);
				if (dynamicRuleMatch != null) {
					return null;
				}
			}
			SerializationMetaData serializationMetaData = modelAnalysis.getSerializationMetaData();
			DiagnosticStringBuilder s = new SerializationMetaDataDiagnosticStringBuilder(serializationMetaData);
			s.append("is not any of");
			for (@NonNull Integer ruleValueIndex : ruleValueIndexes) {
				s.append(" ");
				s.appendRuleName(ruleValueIndex);
			}
			return s.toString();
		}

		@Override
		public @NonNull Set<@NonNull SerializationMatchTerm> getMatchTermClosure() {
			@SuppressWarnings("null")
			@NonNull Set<@NonNull SerializationMatchTerm> emptySet = (@NonNull Set<@NonNull SerializationMatchTerm>)Collections.<@NonNull SerializationMatchTerm>emptySet();
			return emptySet;
		}

		public @NonNull GrammarRuleVector getRuleValueIndexes() {
			return ruleValueIndexes;
		}

		protected boolean isInstance(@NonNull UserModelAnalysis modelAnalysis, @NonNull EObject slotContent) {
			UserElementAnalysis elementAnalysis = modelAnalysis.getElementAnalysis(slotContent);
			GrammarRuleVector elementGrammarRuleVector = elementAnalysis.getGrammarRuleVector();
			GrammarRuleVector targetRuleValueIndexes = ruleValueIndexes;
			GrammarRuleVector compatibleRuleValueIndexes = targetRuleValueIndexes.intersection(elementGrammarRuleVector);
			for (int ruleValueIndex : compatibleRuleValueIndexes) {
				DynamicRuleMatch dynamicRuleMatch = elementAnalysis.basicCreateDynamicRuleMatch(ruleValueIndex);
				if (dynamicRuleMatch != null) {
					return true;
				}
			}
			return false;
		}

		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("check-rule ");
			s.append(SerializationUtils.getName(SerializationUtils.getEPackage(SerializationUtils.getEContainingClass(eReference))));
			s.append("::");
			s.append(SerializationUtils.getName(SerializationUtils.getEContainingClass(eReference)));
			s.append(".");
			s.append(SerializationUtils.getName(eReference));
			s.append(" : ");
			boolean isFirst = true;
			for (@NonNull Integer ruleValueIndex : ruleValueIndexes) {
				if (!isFirst) {
					s.append("|");
				}
				s.appendRuleName(ruleValueIndex);
				isFirst = false;
			}
		}
	}

	/**
	 * A TypeCheck step checks that a slot value conforms to a type required by a rule assignment on behalf of the invoking DynamicRuleMatch=.
	 *
	public static class MatchStep_TypeCheck extends CardinalitySolutionStep
	{
		protected final @NonNull EReference eReference;
		protected final @NonNull Iterable<@NonNull EClass> eClasses;

		public MatchStep_TypeCheck(@NonNull EReference eReference, @NonNull Iterable<@NonNull EClass> eClasses) {
			this.eReference = eReference;
			this.eClasses = eClasses;
			assert Iterables.size(eClasses) >= 1;
		}

		@Override
		public boolean execute(@NonNull DynamicRuleMatch dynamicRuleMatch) {
			UserSlotsAnalysis slotsAnalysis = dynamicRuleMatch.getSlotsAnalysis();
			EObject eObject = slotsAnalysis.getEObject();
			if (!eReference.getEContainingClass().isInstance(eObject)) {
				return false;
			}
			Object slotContent = eObject.eGet(eReference);
			if (eReference.isMany()) {
				for (Object element : (List<?>)slotContent) {
					if (!isInstance(element)) {
						return false;
					}
				}
			}
			else if (slotContent != null) {
				if (!isInstance(slotContent)) {
					return false;
				}
			}
			else {}				// Null is never actually serialized,
			return true;
		}

		protected boolean isInstance(Object slotContent) {
			for (@NonNull EClass eClass : eClasses) {
				if (eClass.isInstance(slotContent)) {
					return true;
				}
			}
			return false;
		}

		@Override
		public void toString(@NonNull StringBuilder s) {
			s.append("check-type ");
			s.append(eReference.getEContainingClass().getEPackage().getName());
			s.append("::");
			s.append(eReference.getEContainingClass().getName());
			s.append(".");
			s.append(eReference.getName());
			s.append(" : ");
			boolean isFirst = true;
			for (@NonNull EClass eClass : eClasses) {
				if (!isFirst) {
					s.append("|");
				}
				s.append(eClass.getEPackage().getName());
				s.append("::");
				s.append(eClass.getName());
				isFirst = false;
			}
		}
	} */

	/**
	 * A Runtime match step requires the serialization steps to be used to search for a solution since static analysis
	 * failed..
	 */
	public static class MatchStep_Runtime extends SerializationMatchStep
	{
		@Override
		public int computeHashCode() {
			return super.computeHashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof MatchStep_Runtime)) {
				return false;
			}
		//	MatchStep_Runtime that = (MatchStep_Runtime)obj;
			return true;
		}

		@Override
		public boolean execute(@NonNull DynamicRuleMatch dynamicRuleMatch) {
			SerializationRule serializationRule = dynamicRuleMatch.getSerializationRule();
			UserElementAnalysis elementAnalysis = dynamicRuleMatch.getElementAnalysis();
			UserElementMatcher matcher = new UserElementMatcher(dynamicRuleMatch, elementAnalysis.getModelAnalysis(), elementAnalysis.getEObject());;
			@NonNull SerializationStep @NonNull [] serializationSteps = serializationRule.getSerializationSteps();
			for (int index = 0; index < serializationSteps.length; ) {
				SerializationStep serializationStep = serializationSteps[index];
				index = serializationStep.matchOuterValue(index, matcher);
				if (index < 0) {
					matcher.setFailureStep(serializationStep);
					assert matcher.hasFailed() : "No failure for a " + serializationStep.getClass().getSimpleName();
					matcher.addFailedMatchTo(dynamicRuleMatch);
					assert dynamicRuleMatch.matchFailed();
					return false;
				}
			}
			if (!dynamicRuleMatch.checkNoUnusedFeatureUsage(matcher)) {
			//	dynamicRuleMatch.checkNoUnusedFeatureUsage(matcher);
				assert matcher.hasFailed() : "No checkNoUnusedFeatureUsage failure";
				assert dynamicRuleMatch.matchFailed();
				return false;
			}
			assert !matcher.hasFailed();
			return true;
		}

		@Override
		public @NonNull String getFailureReason(@NonNull DynamicRuleMatch dynamicRuleMatch) {
			return "BUG --  missing reason";
		}

		@Override
		public @NonNull Set<@NonNull SerializationMatchTerm> getMatchTermClosure() {
			@SuppressWarnings("null")
			@NonNull Set<@NonNull SerializationMatchTerm> emptySet = (@NonNull Set<@NonNull SerializationMatchTerm>)Collections.<@NonNull SerializationMatchTerm>emptySet();
			return emptySet;
		}

		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("runtime");
		}
	}

	/**
	 * A ValueCheck match step re-computes the value of a variable on behalf of the invoking DynamicRuleMatch and requires it to be
	 * consistent with the previous computation.
	 */
	public static class MatchStep_ValueCheck extends SerializationMatchStep
	{
		protected final int variableIndex;
		protected final @NonNull SerializationMatchTerm matchTerm;

		public MatchStep_ValueCheck(int variableIndex, @NonNull SerializationMatchTerm matchTerm) {
			this.variableIndex = variableIndex;
			this.matchTerm = matchTerm;
		}

		@Override
		public int computeHashCode() {
			return super.computeHashCode() + 5 * matchTerm.hashCode() + 7 * variableIndex;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof MatchStep_ValueCheck)) {
				return false;
			}
			MatchStep_ValueCheck that = (MatchStep_ValueCheck)obj;
			return this.matchTerm.equals(that.matchTerm)
				&& (this.variableIndex == that.variableIndex);
		}

		@Override
		public boolean execute(@NonNull DynamicRuleMatch dynamicRuleMatch) {
			Integer newIntegerSolution = matchTerm.basicGetIntegerSolution(dynamicRuleMatch);
			if (newIntegerSolution == null) {
				// throw new UnsupportedOperationException();
				dynamicRuleMatch.setFailedMatch(this);
				return false;
			}
			Integer integer = dynamicRuleMatch.getValue(variableIndex);
			boolean isOk = newIntegerSolution.equals(integer);
			if (!isOk) {
				dynamicRuleMatch.setFailedMatch(this);
			}
			return isOk;
		}

		@Override
		public @NonNull String getFailureReason(@NonNull DynamicRuleMatch dynamicRuleMatch) {
			Integer newIntegerSolution = matchTerm.basicGetIntegerSolution(dynamicRuleMatch);
			if (newIntegerSolution == null) {
				return "Failed to solve for " + matchTerm;
			}
			Integer integer = dynamicRuleMatch.getValue(variableIndex);
			return newIntegerSolution + " rather than " + integer + " for " + matchTerm;
		}

		public @NonNull SerializationMatchTerm getMatchTerm() {
			return matchTerm;
		}

		@Override
		public @NonNull Set<@NonNull SerializationMatchTerm> getMatchTermClosure() {
			return matchTerm.getChildClosure();
		}

		public int getVariableIndex() {
			return variableIndex;
		}

		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("check-value ");
			s.appendVariableName(variableIndex);
			s.append(" = ");
			matchTerm.toString(s);
		}
	}

	private @Nullable Integer hashCode = null;

	protected int computeHashCode() {
		return getClass().hashCode();
	}

	/**
	 * Execute this step to contribute to the dermination of a successful dynamicRuleMatch.
	 *
	 * Returns true if the execution is successful, false if the dynamicRuleMatch is to fail.
	 */
	public abstract boolean execute(@NonNull DynamicRuleMatch dynamicRuleMatch);

	/**
	 * Provide the diagnostic reason for a step execute failure.
	 *
	 * The reason is computed separately from execute() since there is no point wasting time formatting
	 * a pretty explanation of the failure of serialization rule candidate 1 if serialization rule candidate 2
	 * matches.
	 */
	public abstract @NonNull String getFailureReason(@NonNull DynamicRuleMatch dynamicRuleMatch);

	/**
	 * Return all solutions to be evaluated.
	 */
	public abstract @NonNull Set<@NonNull SerializationMatchTerm> getMatchTermClosure();

	@Override
	public final int hashCode() {
		Integer hashCode2 = hashCode;
		if (hashCode2 == null) {
			hashCode = hashCode2 = computeHashCode();
		}
		return hashCode2.intValue();
	}

	/**
	 * Return true if this is an assignment step to cardinalityVariable.
	 */
	public boolean isAssignTo(int variableIndex) {
		return false;
	}

	@Override
	public @NonNull String toString() {
		DiagnosticStringBuilder s = new DiagnosticStringBuilder();
		toString(s);
		return s.toString();
	}

	public abstract void toString(@NonNull DiagnosticStringBuilder s);
}