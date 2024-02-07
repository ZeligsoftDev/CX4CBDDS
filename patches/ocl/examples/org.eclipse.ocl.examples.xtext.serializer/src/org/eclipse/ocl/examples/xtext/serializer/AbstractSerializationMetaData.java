/**
 * Copyright (c) 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.examples.xtext.serializer;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.serializer.EClassValue.EReference_TargetGrammarRuleVector;
import org.eclipse.ocl.examples.xtext.serializer.EnumerationValue.EnumerationValueNull;
import org.eclipse.ocl.examples.xtext.serializer.SerializationRule.SerializationAttribute;
import org.eclipse.ocl.examples.xtext.serializer.SerializationRule.SerializationEnumeratedAttribute;
import org.eclipse.ocl.examples.xtext.serializer.SerializationRule.SerializationFeature;
import org.eclipse.ocl.examples.xtext.serializer.SerializationRule.SerializationReference;
import org.eclipse.ocl.examples.xtext.serializer.SerializationRule.SerializationSimpleAttribute;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;

/**
 * AbstractSerializationMetaData provides shared functionality for the auto-generated SerializationMetaData for a particular
 * Xtext grammar plus idioms combination.
 */
public abstract class AbstractSerializationMetaData implements SerializationMetaData
{
	/**
	 * The T2M Xtext grammar for which this MetaData provides M2T serialization capabilities.
	 */
	private @NonNull Grammar grammar;

	/**
	 * The cache of all distinct CrossReferences in the grammar, indexed by the traversed ERefence and the Rule name for the referenced value.
	 *
	 * This cache is typically rather small and only used transiently during construction. Lists might be better.
	 */
	private @Nullable Map<@NonNull EReference, @NonNull Map<@NonNull String, @NonNull CrossReference>> eReference2ruleName2crossReference = null;

	/**
	 * Lazily computed map from Xtext grammar element and its formatting segments.
	 */
	private @Nullable Map<@NonNull AbstractElement, @NonNull SerializationSegment @NonNull []> grammarElement2innerFormattingSegments;
	private @Nullable Map<@NonNull AbstractElement, @NonNull SerializationSegment @NonNull []> grammarElement2outerFormattingSegments;

	protected AbstractSerializationMetaData(@NonNull Grammar grammar) {
		this.grammar = grammar;
	}

	/**
	 * Traverse the grammar(s) to discover all distinct CrossREferences.
	 */
	private void analyzeGrammar(@NonNull Grammar grammar, @NonNull Map<@NonNull EReference, @NonNull Map<@NonNull String, @NonNull CrossReference>> eReference2ruleName2crossReference) {
		for (@NonNull EObject eObject : new TreeIterable(grammar, false)) {
			if (eObject instanceof CrossReference) {
				CrossReference crossReference = (CrossReference)eObject;
				EReference eReference = GrammarUtil.getReference(crossReference);
				assert eReference != null;
				RuleCall ruleCall = (RuleCall)crossReference.getTerminal();
				AbstractRule calledRule = ruleCall.getRule();
				String calledRuleName = calledRule.getName();
				assert calledRuleName != null;
				Map<@NonNull String, @NonNull CrossReference> ruleName2crossReference = SerializationUtils.maybeNull(eReference2ruleName2crossReference.get(eReference));
				if (ruleName2crossReference == null) {
					ruleName2crossReference = new HashMap<>();
					eReference2ruleName2crossReference.put(eReference, ruleName2crossReference);
				}
				CrossReference oldCrossReference = SerializationUtils.maybeNull(ruleName2crossReference.get(calledRuleName));
				if (oldCrossReference == null) {
					ruleName2crossReference.put(calledRuleName, crossReference);
				}
			}
		}
		for (Grammar usedGrammar : grammar.getUsedGrammars()) {
			assert usedGrammar != null;
			analyzeGrammar(usedGrammar, eReference2ruleName2crossReference);
		}
	}

	/**
	 * Return the EClassValue for eClass or null if not available.
	 */
	@Override
	public @Nullable EClassValue basicGetEClassValue(@NonNull EClass eClass) {
		// This binary search is more efficient space-wise and quite possibly time-wise too.
		@NonNull EClassValue[] eClassValues = getEClassValues();
		int loIndex = 0;					// Inclusive
		int hiIndex = eClassValues.length;	// Exclusive
		while (loIndex < hiIndex) {
			int tryIndex = (loIndex + hiIndex - 1) >>> 1;
			EClassValue eClassValue = eClassValues[tryIndex];
			int comparison = SerializationUtils.ENAMED_ELEMENT_COMPARATOR.compare(eClassValue.getEClass(), eClass);
			if (comparison < 0) {
				loIndex = tryIndex + 1;
			}
			else if (comparison > 0) {
				hiIndex = tryIndex;
			}
			else {
				return eClassValue;
			}
		}
		return null;
	}

	/**
	 * Return the serialization grammar rule artefact named by ruleName or null if unknown.
	 */
	@Override
	public @Nullable GrammarRuleValue basicGetGrammarRuleValue(@NonNull String ruleName) {
		// This binary search is more efficient space-wise and quite possibly time-wise too.
		@NonNull GrammarRuleValue[] grammarRuleValues = getGrammarRuleValues();
		int loIndex = 0;					// Inclusive
		int hiIndex = grammarRuleValues.length;	// Exclusive
		while (loIndex < hiIndex) {
			int tryIndex = (loIndex + hiIndex - 1) >>> 1;
			GrammarRuleValue grammarRuleValue = grammarRuleValues[tryIndex];
			int comparison = grammarRuleValue.getRuleName().compareTo(ruleName);
			if (comparison < 0) {
				loIndex = tryIndex + 1;
			}
			else if (comparison > 0) {
				hiIndex = tryIndex;
			}
			else {
				return grammarRuleValue;
			}
		}
		return null;
	}

	@Override
	public @Nullable SerializationStep basicGetGlobalSerializationStepAssignment(@NonNull EStructuralFeature eStructuralFeature) {
		// This binary search is more efficient than a Map space-wise and quite possibly time-wise too.
		@NonNull SerializationStep[] serializationSteps = getSerializationSteps();
		int loIndex = getFirstGlobalSerializationStepAssignmentIndex();	// Inclusive
		int hiIndex = getLastGlobalSerializationStepAssignmentIndex() + 1;	// Exclusive
		while (loIndex < hiIndex) {
			int tryIndex = (loIndex + hiIndex - 1) >>> 1;
			SerializationStep.SerializationStepAbstractFeature serializationStep = (SerializationStep.SerializationStepAbstractFeature)serializationSteps[tryIndex];
			int comparison = SerializationUtils.ENAMED_ELEMENT_COMPARATOR.compare(serializationStep.getEStructuralFeature(), eStructuralFeature);
			if (comparison < 0) {
				loIndex = tryIndex + 1;
			}
			else if (comparison > 0) {
				hiIndex = tryIndex;
			}
			else {
				return serializationStep;
			}
		}
		return null;
	}

	/**
	 * Return the globally consistent serialization step for a keyword or null if not available.
	 */
	@Override
	public SerializationStep.@Nullable SerializationStepKeyword basicGetGlobalSerializationStepKeyword(@NonNull String keyword) {
		// This binary search is more efficient than a Map space-wise and quite possibly time-wise too.
		@NonNull SerializationStep[] serializationSteps = getSerializationSteps();
		int loIndex = getFirstGlobalSerializationStepLiteralIndex();	// Inclusive
		int hiIndex = getLastGlobalSerializationStepLiteralIndex() + 1;	// Exclusive
		while (loIndex < hiIndex) {
			int tryIndex = (loIndex + hiIndex - 1) >>> 1;
			SerializationStep.SerializationStepKeyword serializationStep = (SerializationStep.SerializationStepKeyword)serializationSteps[tryIndex];
			int comparison = serializationStep.getKeyword().compareTo(keyword);
			if (comparison < 0) {
				loIndex = tryIndex + 1;
			}
			else if (comparison > 0) {
				hiIndex = tryIndex;
			}
			else {
				return serializationStep;
			}
		}
		return null;
	}

	protected @NonNull EReference_TargetGrammarRuleVector createEReference_TargetGrammarRuleVector(/*@NonNull*/ EReference eReference, int targetGrammarRuleVectorIndex) {
		return new EReference_TargetGrammarRuleVector(eReference, getGrammarRuleVectors()[targetGrammarRuleVectorIndex]);
	}

	protected @NonNull SerializationMatchStep createMatchStep_Assert(int serializationMatchTermIndex) {
		return new SerializationMatchStep.MatchStep_Assert(getSerializationMatchTerms()[serializationMatchTermIndex]);
	}

	protected @NonNull SerializationMatchStep createMatchStep_Assign(int cardinalityVariableIndex, int serializationMatchTermIndex) {
		return new SerializationMatchStep.MatchStep_Assign(cardinalityVariableIndex, getSerializationMatchTerms()[serializationMatchTermIndex]);
	}

	protected @NonNull SerializationMatchStep createMatchStep_RuleCheck(/*@NonNull*/ EReference eReference, int grammarRuleValueIndexes) {
		return new SerializationMatchStep.MatchStep_RuleCheck(eReference, getGrammarRuleVectors()[grammarRuleValueIndexes]);
	}

	protected @NonNull SerializationMatchStep createMatchStep_Runtime() {
		return new SerializationMatchStep.MatchStep_Runtime();
	}

	protected @NonNull SerializationMatchStep createMatchStep_ValueCheck(int cardinalityVariableIndex, int serializationMatchTermIndex) {
		return new SerializationMatchStep.MatchStep_ValueCheck(cardinalityVariableIndex, getSerializationMatchTerms()[serializationMatchTermIndex]);
	}

	protected @NonNull GrammarRuleValue createParserRuleValue(int ruleIndex, @NonNull String name, int subParserRuleValueIndexes,
			@NonNull SerializationRule @NonNull [] serializationRules, int ... serializationSegmentsBiIndexes) {
		@NonNull SerializationSegment @NonNull [] @NonNull [] serializationSegments = getSerializationSegments();
		int iMax = serializationSegmentsBiIndexes.length;
		@NonNull SerializationSegment @NonNull [] @NonNull [] innerSerializationSegmentsArray = new @NonNull SerializationSegment @NonNull [iMax] @NonNull [];
		@NonNull SerializationSegment @NonNull [] @NonNull [] outerSerializationSegmentsArray = new @NonNull SerializationSegment @NonNull [iMax] @NonNull [];
		for (int i =  0; i < iMax; i++) {
			int serializationSegmentsBiIndex = serializationSegmentsBiIndexes[i];
			int innerSerializationSegmentsIndex = serializationSegmentsBiIndex & 0xFFFF;
			int outerSerializationSegmentsIndex = (serializationSegmentsBiIndex >> 16) & 0xFFFF;
			innerSerializationSegmentsArray[i] = serializationSegments[innerSerializationSegmentsIndex];
			outerSerializationSegmentsArray[i] = serializationSegments[outerSerializationSegmentsIndex];
		}
		return new ParserRuleValue(ruleIndex, name, serializationRules, outerSerializationSegmentsArray, innerSerializationSegmentsArray,
			subParserRuleValueIndexes >= 0 ? getGrammarRuleVectors()[subParserRuleValueIndexes] : null);
	}

	protected @NonNull SerializationAttribute createSerializationEnumeratedAttribute(/*@NonNull*/ EAttribute eAttribute,
			boolean needsDefault, int @NonNull ... enumerationValue_grammarCardinalities) {
		assert eAttribute != null;
		int iMax = enumerationValue_grammarCardinalities.length;
		@NonNull EnumerationValue [] enumerationValues = new @NonNull EnumerationValue [iMax];
		@NonNull GrammarCardinality [] grammarCardinalities = new @NonNull GrammarCardinality [iMax];
		for (int i = 0; i < iMax; i++) {
			EnumerationValue enumerationValue = getEnumerationValues()[enumerationValue_grammarCardinalities[i] >> 4];
			GrammarCardinality grammarCardinality = GrammarCardinality.valueOf(enumerationValue_grammarCardinalities[i] & 0xF);
			assert enumerationValue != null;
			enumerationValues[i] = enumerationValue;
			grammarCardinalities[i] = grammarCardinality;
		}
		return new SerializationEnumeratedAttribute(eAttribute, needsDefault, enumerationValues, grammarCardinalities);
	}

	protected @NonNull SerializationMatchStep @NonNull [] createSerializationMatchSteps(int ... serializationMatchStepIndexes) {
		int iMax = serializationMatchStepIndexes.length;
		@NonNull SerializationMatchStep @NonNull [] serializationMatchSteps = new @NonNull SerializationMatchStep[iMax];
		for (int i = 0; i < iMax; i++) {
			serializationMatchSteps[i] = getSerializationMatchSteps()[serializationMatchStepIndexes[i]];
		}
		return serializationMatchSteps;
	}

	protected @NonNull SerializationMatchTerm createSerializationMatchTermAdd(int leftIndex, int rightIndex) {
		return new SerializationMatchTerm.SerializationMatchTermAdd(getSerializationMatchTerms()[leftIndex], getSerializationMatchTerms()[rightIndex]);
	}

	protected @NonNull SerializationMatchTerm createSerializationMatchTermDivide(int leftIndex, int rightIndex) {
		return new SerializationMatchTerm.SerializationMatchTermDivide(getSerializationMatchTerms()[leftIndex], getSerializationMatchTerms()[rightIndex]);
	}

	protected @NonNull SerializationMatchTerm createSerializationMatchTermEAttributeSize(/*@NonNull*/ EAttribute eAttribute, int enumerationValueIndex) {
		assert eAttribute != null;
		return new SerializationMatchTerm.SerializationMatchTermEAttributeSize(eAttribute, getEnumerationValues()[enumerationValueIndex]);
	}

	protected @NonNull SerializationMatchTerm createSerializationMatchTermEReferenceSize(/*@NonNull*/ EReference eReference, int grammarRuleVectorIndex) {
		assert eReference != null;
		return new SerializationMatchTerm.SerializationMatchTermEReferenceSize(eReference, getGrammarRuleVectors()[grammarRuleVectorIndex]);
	}

	protected @NonNull SerializationMatchTerm createSerializationMatchTermEStructuralFeatureSize(/*@NonNull*/ EStructuralFeature eStructuralFeature) {
		assert eStructuralFeature != null;
		return new SerializationMatchTerm.SerializationMatchTermEStructuralFeatureSize(eStructuralFeature);
	}

	protected @NonNull SerializationMatchTerm createSerializationMatchTermGreaterThan(int leftIndex, int rightIndex) {
		return new SerializationMatchTerm.SerializationMatchTermGreaterThan(getSerializationMatchTerms()[leftIndex], getSerializationMatchTerms()[rightIndex]);
	}

	protected @NonNull SerializationMatchTerm createSerializationMatchTermInteger(int value) {
		return new SerializationMatchTerm.SerializationMatchTermInteger(value);
	}

	protected @NonNull SerializationMatchTerm createSerializationMatchTermMultiply(int leftIndex, int rightIndex) {
		return new SerializationMatchTerm.SerializationMatchTermMultiply(getSerializationMatchTerms()[leftIndex], getSerializationMatchTerms()[rightIndex]);
	}

	protected @NonNull SerializationMatchTerm createSerializationMatchTermRuntime() {
		return new SerializationMatchTerm()
		{
			@Override
			protected int computeHashCode() {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean equals(Object obj) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean isConstant(@NonNull DynamicRuleMatch ruleMatch) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean isKnown(@NonNull DynamicRuleMatch ruleMatch) {
				throw new UnsupportedOperationException();
			}

			@Override
			public void toString(@NonNull DiagnosticStringBuilder s) {
				throw new UnsupportedOperationException();
			}
		};
	}

	protected @NonNull SerializationMatchTerm createSerializationMatchTermSubtract(int leftIndex, int rightIndex) {
		return new SerializationMatchTerm.SerializationMatchTermSubtract(getSerializationMatchTerms()[leftIndex], getSerializationMatchTerms()[rightIndex]);
	}

	protected @NonNull SerializationMatchTerm createSerializationMatchTermVariable(int cardinalityVariableIndex) {
		return new SerializationMatchTerm.SerializationMatchTermVariable(cardinalityVariableIndex);
	}

	protected @NonNull SerializationReference createSerializationReference(/*@NonNull*/ EReference eReference, int targetGrammarRuleVectorIndex,
			int @NonNull ... grammarRuleIndex_grammarCardinalities) {
		assert eReference != null;
		GrammarRuleVector targetGrammarRuleVector = targetGrammarRuleVectorIndex >= 0 ? getGrammarRuleVectors()[targetGrammarRuleVectorIndex] : null;
		int iMax = grammarRuleIndex_grammarCardinalities.length;
		int @NonNull [] grammarRuleIndexes = new int[iMax];
		@NonNull GrammarCardinality @NonNull [] grammarCardinalities = new @NonNull GrammarCardinality[iMax];
		for (int i = 0; i < iMax; i++) {
			grammarRuleIndexes[i] = grammarRuleIndex_grammarCardinalities[i] >> 4;
			grammarCardinalities[i] = GrammarCardinality.valueOf(grammarRuleIndex_grammarCardinalities[i] & 0xF);
		}
		return new SerializationReference(eReference, targetGrammarRuleVector, grammarRuleIndexes, grammarCardinalities);
	}

	protected @NonNull SerializationRule createSerializationRule(@NonNull String name, int grammarRuleValueIndex,
			@NonNull SerializationMatchStep @Nullable [] matchSteps,
			@NonNull SerializationStep @NonNull [] serializationSteps,
			@NonNull SerializationFeature @Nullable [] serializationFeatures) {
		return new SerializationRule(this, name, grammarRuleValueIndex, matchSteps, serializationSteps, serializationFeatures);
	}

	protected @NonNull SerializationRule @NonNull [] createSerializationRules(int ... serializationRuleIndexes) {
		int iMax = serializationRuleIndexes.length;
		@NonNull SerializationRule @NonNull [] serializationRules = new @NonNull SerializationRule[iMax];
		for (int i = 0; i < iMax; i++) {
			serializationRules[i] = getSerializationRules()[serializationRuleIndexes[i]];
		}
		return serializationRules;
	}

	protected @NonNull SerializationAttribute createSerializationSimpleAttribute(/*@NonNull*/ EAttribute eAttribute, boolean needsDefault, @NonNull GrammarCardinality grammarCardinality) {
		assert eAttribute != null;
		return new SerializationSimpleAttribute(eAttribute, needsDefault, grammarCardinality);
	}

	protected @NonNull SerializationStep createSerializationStepAssignKeyword(/*@NonNull*/ EStructuralFeature eStructuralFeature,int enumerationValueIndex, int serializationSegmentsIndex) {
		assert eStructuralFeature != null;
		return new SerializationStep.SerializationStepAssignKeyword(eStructuralFeature, getEnumerationValues()[enumerationValueIndex], serializationSegmentsIndex >= 0 ? getSerializationSegments()[serializationSegmentsIndex] : null);
	}

	protected @NonNull SerializationStep createSerializationStepAssignedRuleCall(/*@NonNull*/ EStructuralFeature eStructuralFeature, int calledValueIndex, int serializationSegmentsIndex) {
		assert eStructuralFeature != null;
		return new SerializationStep.SerializationStepAssignedRuleCall(eStructuralFeature, calledValueIndex, serializationSegmentsIndex >= 0 ? getSerializationSegments()[serializationSegmentsIndex] : null);
	}

	protected @NonNull SerializationStep createSerializationStepAssigns(/*@NonNull*/ EStructuralFeature eStructuralFeature, int enumerationValueIndex, int @NonNull [] calledRuleIndexes, int serializationSegmentsIndex) {
		assert eStructuralFeature != null;
		return new SerializationStep.SerializationStepAssigns(eStructuralFeature, enumerationValueIndex >= 0 ? getEnumerationValues()[enumerationValueIndex] : EnumerationValueNull.INSTANCE, calledRuleIndexes, serializationSegmentsIndex >= 0 ? getSerializationSegments()[serializationSegmentsIndex] : null);
	}

	protected @NonNull SerializationStep createSerializationStepCrossReference(/*@NonNull*/ EStructuralFeature eStructuralFeature, @NonNull CrossReference crossReference, int calledRuleIndex, int serializationSegmentsIndex) {
		assert eStructuralFeature != null;
		return new SerializationStep.SerializationStepCrossReference(eStructuralFeature, crossReference, calledRuleIndex, serializationSegmentsIndex >= 0 ? getSerializationSegments()[serializationSegmentsIndex] : null);
	}

	protected @NonNull SerializationStep createSerializationStepKeyword(@NonNull String keyword, int serializationSegmentsIndex) {
		return new SerializationStep.SerializationStepKeyword(keyword, serializationSegmentsIndex >= 0 ? getSerializationSegments()[serializationSegmentsIndex] : null);
	}

	protected @NonNull SerializationStep createSerializationStepSequence(int variableIndex_grammarCardinality, int stepsRange, int serializationSegmentsIndex) {
		int variableIndex = variableIndex_grammarCardinality >> 4;
		GrammarCardinality grammarCardinality = GrammarCardinality.valueOf(variableIndex_grammarCardinality & 0xF);
		return new SerializationStep.SerializationStepSequence(variableIndex, stepsRange, grammarCardinality, serializationSegmentsIndex >= 0 ? getSerializationSegments()[serializationSegmentsIndex] : null);
	}

	protected @NonNull SerializationStep createSerializationStepWrapper(int serializationSegmentsIndex) {
		assert serializationSegmentsIndex >= 0;
		@NonNull SerializationSegment[] serializationSegments = getSerializationSegments()[serializationSegmentsIndex];
		assert serializationSegments != null;
		return new SerializationStep.SerializationStepWrapper(serializationSegments);
	}

	protected @NonNull SerializationStep @NonNull [] createSerializationSteps(int ... serializationStepIndexes) {
		int iMax = serializationStepIndexes.length;
		@NonNull SerializationStep @NonNull [] serializationSteps = new @NonNull SerializationStep[iMax];
		for (int i = 0; i < iMax; i++) {
			serializationSteps[i] = getSerializationSteps()[serializationStepIndexes[i]];
		}
		return serializationSteps;
	}

	/**
	 * Serialization of references uses ICrossReferenceSerializer.serializeCrossRef(EObject, CrossReference, EObject, INode, ISerializationDiagnostic.Acceptor)
	 * which needs a plausible CrossReference.
	 *
	 * This is most reliably obtained by finding the CrossReference in the grammar using name context.
	 *
	 * (More efficient would be to use URIs, but that would fail if the grammar evolves without regenerating the serilaizer.)
	 *
	 * (Better if an alternative API didn't need the CrossReference.)
	 */
	public @NonNull CrossReference getCrossReference(/*@NonNull*/ EReference assignedEReference, @NonNull String assignedRuleName) {
		Map<@NonNull EReference, @NonNull Map<@NonNull String, @NonNull CrossReference>> eReference2ruleName2crossReference2 = eReference2ruleName2crossReference;
		if (eReference2ruleName2crossReference2 == null) {
			eReference2ruleName2crossReference = eReference2ruleName2crossReference2 = new HashMap<>();
			analyzeGrammar(grammar, eReference2ruleName2crossReference2);
		}
		Map<@NonNull String, @NonNull CrossReference> ruleName2crossReference = SerializationUtils.maybeNull(eReference2ruleName2crossReference2.get(assignedEReference));
		if (ruleName2crossReference != null) {
			CrossReference crossReference = SerializationUtils.maybeNull(ruleName2crossReference.get(assignedRuleName));
			if (crossReference != null) {
				return crossReference;
			}
		}
		throw new IllegalStateException();
	}

	@Override
	public @NonNull EClassValue getEClassValue(@NonNull EClass eClass) {
		return SerializationUtils.nonNullState(basicGetEClassValue(eClass));
	}

	/**
	 * Return the per-EClass serialization metadata in alphabetical order.
	 * Use {@link SerializationGrammarAnalysis.getEClassValue(EClass)} to look up an EClass.
	 */
	public abstract @NonNull EClassValue @NonNull [] getEClassValues();

	/**
	 * Return the string-groups that behave as enumerations, in alphabetical order.
	 */
	public abstract @NonNull EnumerationValue @NonNull [] getEnumerationValues();

	/**
	 * Return the {@link getSerializationSteps()} index of the first assignment serialization step that is used consistently
	 * across all rules. Returns -1 if none.
	 */
	protected abstract int getFirstGlobalSerializationStepAssignmentIndex();

	/**
	 * Return the {@link getSerializationSteps()} index of the first keyword/literal serialization step that is used consistently
	 * across all rules. Returns -1 if none.
	 */
	protected abstract int getFirstGlobalSerializationStepLiteralIndex();

	protected @NonNull Map<@NonNull AbstractElement, @NonNull SerializationSegment @NonNull []> getGrammarElement2innerFormattingSegments(@NonNull AbstractElement grammarElement) {
		Map<@NonNull AbstractElement, @NonNull SerializationSegment @NonNull []> grammarElement2innerFormattingSegments2 = grammarElement2innerFormattingSegments;
		if (grammarElement2innerFormattingSegments2 == null) {
			grammarElement2innerFormattingSegments = grammarElement2innerFormattingSegments2 = new HashMap<>();
		}
		@NonNull SerializationSegment [] innerFormattingSegments = SerializationUtils.maybeNull(grammarElement2innerFormattingSegments2.get(grammarElement));
		if (innerFormattingSegments == null) {
			AbstractRule grammarRule = GrammarUtil.containingRule(grammarElement);
			assert grammarRule != null;
			ParserRuleValue grammarRuleValue = (ParserRuleValue) basicGetGrammarRuleValue(SerializationUtils.getName(grammarRule));
			if (grammarRuleValue != null) {
				setInnerFormattingSegments(SerializationUtils.getAlternatives(grammarRule), 0, grammarRuleValue.getInnerFormattingSegments());
			}
		}
		return grammarElement2innerFormattingSegments2;
	}

	protected @NonNull Map<@NonNull AbstractElement, @NonNull SerializationSegment @NonNull []> getGrammarElement2outerFormattingSegments(@NonNull AbstractElement grammarElement) {
		Map<@NonNull AbstractElement, @NonNull SerializationSegment @NonNull []> grammarElement2outerFormattingSegments2 = grammarElement2outerFormattingSegments;
		if (grammarElement2outerFormattingSegments2 == null) {
			grammarElement2outerFormattingSegments = grammarElement2outerFormattingSegments2 = new HashMap<>();
		}
		@NonNull SerializationSegment [] outerFormattingSegments = SerializationUtils.maybeNull(grammarElement2outerFormattingSegments2.get(grammarElement));
		if (outerFormattingSegments == null) {
			AbstractRule grammarRule = GrammarUtil.containingRule(grammarElement);
			assert grammarRule != null;
			ParserRuleValue grammarRuleValue = (ParserRuleValue) basicGetGrammarRuleValue(SerializationUtils.getName(grammarRule));
			if (grammarRuleValue != null) {
				setOuterFormattingSegments(SerializationUtils.getAlternatives(grammarRule), 0, grammarRuleValue.getOuterFormattingSegments());
			}
		}
		return grammarElement2outerFormattingSegments2;
	}

	@Override
	public @NonNull GrammarRuleValue getGrammarRuleValue(int ruleValueIndex) {
		return getGrammarRuleValues()[ruleValueIndex];
	}

	/**
	 * Return the per-GrammarRule serialization metadata in alphabetical order.
	 */
	public abstract @NonNull GrammarRuleValue @NonNull [] getGrammarRuleValues();

	/**
	 * Return the GrammarRule-group bit vectors that encode 'derived' grammar rules closures.
	 */
	public abstract @NonNull GrammarRuleVector @NonNull [] getGrammarRuleVectors();

	@Override
	public @NonNull SerializationSegment @NonNull [] getInnerFormattingSegments(@NonNull AbstractElement grammarElement) {
		Map<@NonNull AbstractElement, @NonNull SerializationSegment @NonNull []> grammarElement2innerFormattingSegments2 = getGrammarElement2innerFormattingSegments(grammarElement);
		@NonNull SerializationSegment[] innerFormattingSegments = SerializationUtils.maybeNull(grammarElement2innerFormattingSegments2.get(grammarElement));
		return innerFormattingSegments != null ? innerFormattingSegments : SerializationSegment.VALUE_SEGMENTS_ARRAY;
	}

	/**
	 * Return the {@link getSerializationSteps()) inclusive index of the last assignment serialization step that is used consistently
	 * across all rules. Returns -1 if none.
	 */
	protected abstract int getLastGlobalSerializationStepAssignmentIndex();

	/**
	 * Return the {@link getSerializationSteps()) inclusive index of the last keyword/literal serialization step that is used consistently
	 * across all rules. Returns -1 if none.
	 */
	protected abstract int getLastGlobalSerializationStepLiteralIndex();

	@Override
	public @NonNull SerializationSegment @NonNull [] getOuterFormattingSegments(@NonNull AbstractElement grammarElement) {
		Map<@NonNull AbstractElement, @NonNull SerializationSegment @NonNull []> grammarElement2outerFormattingSegments2 = getGrammarElement2outerFormattingSegments(grammarElement);
		@NonNull SerializationSegment[] outerFormattingSegments = SerializationUtils.maybeNull(grammarElement2outerFormattingSegments2.get(grammarElement));
		return outerFormattingSegments != null ? outerFormattingSegments : SerializationSegment.VALUE_SEGMENTS_ARRAY;
	}

	/**
	 * Return the shared steps that are used when matching a candidate serialization rule.
	 */
	public abstract @NonNull SerializationMatchStep @NonNull [] getSerializationMatchSteps();

	/**
	 * Return the shared expression terms that are used when evaluating a candidate serialization match step.
	 */
	public abstract @NonNull SerializationMatchTerm @NonNull [] getSerializationMatchTerms();

	/**
	 * Return the per-SerializationRule serialization metadata in alphabetical order.
	 * Note that a ParserRule with actions/unassigned-rule-calls/non-leaf-alternatives is
	 * transformed to multiple SerializationRules.
	 */
	public abstract @NonNull SerializationRule @NonNull [] getSerializationRules();

	/**
	 * Return the shared (virtual) string segments that contribute to the serialization of a serialization step.
	 */
	public abstract @NonNull SerializationSegment @NonNull [] @NonNull [] getSerializationSegments();

	/**
	 * Return the shared arrays of shared (virtual) string segments that contribute to the serialization of a serialization rule.
	 */
	public @NonNull SerializationSegment @NonNull [] @NonNull [] @Nullable [] getSerializationSegmentsArrays() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Return the shared steps that are used when serializing a term of a serialization rule.
	 */
	public abstract @NonNull SerializationStep @NonNull [] getSerializationSteps();

	private int setInnerFormattingSegments(@NonNull AbstractElement grammarElement, int index, @NonNull SerializationSegment @NonNull [] @NonNull [] formattingSegmentsArray) {
		@NonNull SerializationSegment @NonNull [] formattingSegments = formattingSegmentsArray[index++];
		assert grammarElement2innerFormattingSegments != null;
		grammarElement2innerFormattingSegments.put(grammarElement, formattingSegments);
		if (grammarElement instanceof CompoundElement) {
			for (@NonNull AbstractElement nestedElement : SerializationUtils.getElements((CompoundElement)grammarElement)) {
				index = setInnerFormattingSegments(nestedElement, index, formattingSegmentsArray);
			}
		}
		return index;
	}

	private int setOuterFormattingSegments(@NonNull AbstractElement grammarElement, int index, @NonNull SerializationSegment @NonNull [] @NonNull [] formattingSegmentsArray) {
		@NonNull SerializationSegment @NonNull [] formattingSegments = formattingSegmentsArray[index++];
		assert grammarElement2outerFormattingSegments != null;
		grammarElement2outerFormattingSegments.put(grammarElement, formattingSegments);
		if (grammarElement instanceof CompoundElement) {
			for (@NonNull AbstractElement nestedElement : SerializationUtils.getElements((CompoundElement)grammarElement)) {
				index = setOuterFormattingSegments(nestedElement, index, formattingSegmentsArray);
			}
		}
		return index;
	}
}
