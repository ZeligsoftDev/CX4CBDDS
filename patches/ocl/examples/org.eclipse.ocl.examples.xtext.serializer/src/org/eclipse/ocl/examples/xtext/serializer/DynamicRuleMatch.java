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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.serializer.DiagnosticStringBuilder.SerializationMetaDataDiagnosticStringBuilder;
import org.eclipse.ocl.examples.xtext.serializer.SerializationRule.SerializationEnumeratedAttribute;
import org.eclipse.ocl.examples.xtext.serializer.SerializationRule.SerializationFeature;
import org.eclipse.ocl.examples.xtext.serializer.SerializationRule.SerializationReference;

/**
 * A DynamicRuleMatch accumulates the results of augmenting the static match of a particular SerializationRule
 * with the actual analysis of the slots of a user model element.
 */
public class DynamicRuleMatch implements RuleMatch
{
	protected final @NonNull UserElementAnalysis elementAnalysis;
	protected final @NonNull SerializationRule serializationRule;
	private final @NonNull Map<@NonNull Integer, @NonNull Integer> variableIndex2value = new HashMap<>();

	// Mismatch and reason
	private boolean matchFailed = false;
	private @Nullable EStructuralFeature reasonFeature = null;
	private @Nullable SerializationMatchStep reasonMatchStep = null;
	private @Nullable ParserRuleValue reasonRuleValue = null;
	private @Nullable SerializationStep reasonStep = null;

	public DynamicRuleMatch(@NonNull UserElementAnalysis elementAnalysis, @NonNull SerializationRule serializationRule) {
		this.elementAnalysis = elementAnalysis;
		this.serializationRule = serializationRule;
		elementAnalysis.getModelAnalysis().debugAddDynamicRuleMatch(this);
		EObject eObject = elementAnalysis.getEObject();
	}

	/**
	 * Analyze the actual slots to compute the value of each cardinality variable.
	 *
	 * Returns false if analysis fails.
	 */
	public boolean analyze() {
		@NonNull SerializationMatchStep[] serializationMatchSteps = serializationRule.getSerializationMatchSteps();
		for (@NonNull SerializationMatchStep step : serializationMatchSteps) {
			if (!step.execute(this)) {
				assert matchFailed;
				return false;
			}
		}
		return true;
	}

	@Override
	public @Nullable Integer basicGetIntegerSolution(int variableIndex) {
		return variableIndex2value.get(variableIndex);
	}

	public @Nullable String basicGetReasonString() {
		EStructuralFeature reasonFeature2 = reasonFeature;
		if (reasonFeature2 != null) {
			return "Incompatible/missing '" + reasonFeature2.getEContainingClass().getName() + "::" + reasonFeature2.getName() + "' values.";
		}
		if (reasonMatchStep != null) {
			return reasonMatchStep.getFailureReason(this);
		}
		if (reasonStep != null) {
			return reasonStep.getFailureReason(this);
		}
		return null;
	}

	public @Nullable Integer basicGetValue(int variableIndex) {
		assert variableIndex >= 0;
		return variableIndex2value.get(variableIndex);
	}

	public boolean checkNoUnusedFeatureUsage(@NonNull UserElementMatcher matcher) {
		for (@NonNull EStructuralFeature eStructuralFeature : elementAnalysis.getEStructuralFeatures()) {
			SerializationFeature serializationFeature = serializationRule.getSerializationFeature(eStructuralFeature);
			UserSlotAnalysis object = elementAnalysis.getSlotAnalysis(eStructuralFeature);
			if (serializationFeature == null) {
				if (!object.isCounted() || (object.asCounted() != 0)) {
					setFailedMatch(eStructuralFeature);
					matcher.setFailureFeature(eStructuralFeature);
					assert matchFailed;
					return false;
				}
			}
			else {
				if (serializationFeature instanceof SerializationEnumeratedAttribute) {
					SerializationEnumeratedAttribute serializationEnumeratedAttribute = (SerializationEnumeratedAttribute)serializationFeature;
					for (EnumerationValue enumerationValue : serializationEnumeratedAttribute.getEnumerationValues()) {
						int available = elementAnalysis.getSize((EAttribute)eStructuralFeature, enumerationValue);
						int consumed = matcher.getSize(eStructuralFeature);
						if (consumed < available) {
							setFailedMatch(eStructuralFeature);
							matcher.setFailureFeature(eStructuralFeature);
							assert matchFailed;
							return false;
						}
					}
				}
				else if (serializationFeature instanceof SerializationReference) {
					SerializationReference serializationReference = (SerializationReference)serializationFeature;
					GrammarRuleVector targetGrammarRuleVector = serializationReference.getTargetGrammarRuleVector();
					if (targetGrammarRuleVector != null) {
						int available = elementAnalysis.getSize((EReference)eStructuralFeature, targetGrammarRuleVector);
						int consumed = matcher.getSize(eStructuralFeature);
						if (consumed < available) {
							setFailedMatch(eStructuralFeature);
							matcher.setFailureFeature(eStructuralFeature);
							assert matchFailed;
							return false;
						}
					}
					else {
						int available = elementAnalysis.getSize(eStructuralFeature);
						int consumed = matcher.getSize(eStructuralFeature);
						if (consumed < available) {
							setFailedMatch(eStructuralFeature);
							matcher.setFailureFeature(eStructuralFeature);
							assert matchFailed;
							return false;
						}
					}
				}
				else {
					int available = elementAnalysis.getSize(eStructuralFeature);
					int consumed = matcher.getSize(eStructuralFeature);
					if (consumed < available) {
						setFailedMatch(eStructuralFeature);
						matcher.setFailureFeature(eStructuralFeature);
						assert matchFailed;
						return false;
					}
				}
			}
		}
		return true;
	}

	public @NonNull UserElementAnalysis getElementAnalysis() {
		return elementAnalysis;
	}

	public @NonNull UserModelAnalysis getModelAnalysis() {
		return elementAnalysis.getModelAnalysis();
	}

	public @Nullable EStructuralFeature getReasonFeature() {
		return reasonFeature;
	}

	public @Nullable SerializationMatchStep getReasonMatchStep() {
		return reasonMatchStep;
	}

	public @Nullable ParserRuleValue RuleValue() {
		return reasonRuleValue;
	}

	public @Nullable SerializationStep getReasonStep() {
		return reasonStep;
	}

	public @NonNull String getReasonString() {
		if (!matchFailed) {
			return "OK";
		}
		EStructuralFeature reasonFeature2 = reasonFeature;
		if (reasonFeature2 != null) {
			return "Incompatible/missing '" + reasonFeature2.getEContainingClass().getName() + "::" + reasonFeature2.getName() + "' values.";
		}
		if (reasonMatchStep != null) {
			return reasonMatchStep.getFailureReason(this);
		}
		if (reasonRuleValue != null) {
			return "Required '" + reasonRuleValue + "'";
		}
		assert reasonStep != null;
		return reasonStep.getFailureReason(this);
	}

	public @NonNull SerializationRule getSerializationRule() {
		return serializationRule;
	}

	@Override
	public @NonNull Integer getSize(@NonNull EStructuralFeature eStructuralFeature) {
		return elementAnalysis.getSize(eStructuralFeature);
	}

	@Override
	public @NonNull Integer getSize(@NonNull EAttribute eAttribute, @NonNull EnumerationValue enumerationValue) {
		return elementAnalysis.getSize(eAttribute, enumerationValue);
	}

	@Override
	public @NonNull Integer getSize(@NonNull EReference eReference, @NonNull GrammarRuleVector grammarRuleVector) {
		return elementAnalysis.getSize(eReference, grammarRuleVector);
	}

	public @NonNull Integer getValue(int variableIndex) {
		assert variableIndex >= 0;
		return SerializationUtils.nonNullState(variableIndex2value.get(variableIndex));
	}

	public boolean matchFailed() {
		return matchFailed;
	}

	public void putValue(@NonNull Integer variableIndex, @NonNull Integer integerSolution) {
		variableIndex2value.put(variableIndex, integerSolution);
	}

	public void setFailedMatch(@NonNull ParserRuleValue reasonRuleValue) {
		assert !this.matchFailed;
		assert this.reasonFeature == null;
		assert this.reasonMatchStep == null;
		assert this.reasonRuleValue == null;
		assert this.reasonStep == null;
		this.reasonRuleValue = reasonRuleValue;
		setMatchFailed();
	}

	public void setFailedMatch(@NonNull EStructuralFeature reasonFeature) {
		assert !this.matchFailed;
		assert this.reasonFeature == null;
		assert this.reasonMatchStep == null;
		assert this.reasonRuleValue == null;
		assert this.reasonStep == null;
		this.reasonFeature = reasonFeature;
		String basicGetReasonString = basicGetReasonString();
		assert basicGetReasonString != null;
		setMatchFailed();
	}

	public void setFailedMatch(@NonNull SerializationMatchStep reasonMatchStep) {
		assert !this.matchFailed;
		assert this.reasonFeature == null;
		assert this.reasonMatchStep == null;
		assert this.reasonRuleValue == null;
		assert this.reasonStep == null;
		assert !(reasonMatchStep instanceof SerializationMatchStep.MatchStep_Runtime);
		this.reasonMatchStep = reasonMatchStep;
		setMatchFailed();
	}

	public void setFailedMatch(@NonNull SerializationStep reasonStep) {
		assert !this.matchFailed;
		assert this.reasonFeature == null;
		assert this.reasonMatchStep == null;
		assert this.reasonRuleValue == null;
		assert this.reasonStep == null;
		this.reasonStep = reasonStep;
		setMatchFailed();
	}

	private void setMatchFailed() {
		assert !this.matchFailed;
		assert (this.reasonFeature != null) || (this.reasonMatchStep != null) || (this.reasonRuleValue != null)|| (this.reasonStep != null);
		this.matchFailed = true;
	}

	@Override
	public @NonNull String toString() {
		DiagnosticStringBuilder s = new SerializationMetaDataDiagnosticStringBuilder(elementAnalysis.getModelAnalysis().getSerializationMetaData());
		toString(s, 0);
		return s.toString();
	}

	public void toString(@NonNull DiagnosticStringBuilder s, int depth) {
		serializationRule.toString(s, depth);
		List<@NonNull Integer> variableIndexes = new ArrayList<>(variableIndex2value.keySet());
		Collections.sort(variableIndexes);
		for (@NonNull Integer variableIndex : variableIndexes) {
			Integer value = SerializationUtils.maybeNull(variableIndex2value.get(variableIndex));
			s.appendIndentation(depth);
			s.appendVariableName(variableIndex);
			s.append(" = " + value);
		}
		String reasonString = basicGetReasonString();
		if (reasonString != null) {
			s.appendIndentation(depth);
			s.append(reasonString);
		}
	}
}