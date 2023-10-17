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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.serializer.DiagnosticStringBuilder.DiagnosticStringBuilderWithHelper;
import org.eclipse.ocl.examples.xtext.serializer.DiagnosticStringBuilder.SerializationMetaDataDiagnosticStringBuilder;
import org.eclipse.ocl.examples.xtext.serializer.SerializationStep.SerializationStepSequence;
import org.eclipse.ocl.examples.xtext.serializer.SerializationStep.SerializationStepWrapper;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * Each SerializationRule provides the metadat to support serializing or reformatting a user model element
 * in accordance with a serialization(M2T)-friendly variation of a grammar(T2M) rule.
 *
 * Each serialization rule is associated with precisely one user EClass and comprises a potentially nested
 * sequence of serialization steps to generate the output. There are no root or intermediate alternatives,
 * since these are multiplied out as distinct serialization rules. There may be leaf alternatives. The
 * seria;ization is guarded by some match steps that validate the applicability of the rule and deduce the
 * cardinalities of variables for each serialization loop/condition.
 */
public class SerializationRule implements Nameable
{
	/**
	 * SerializationFeature captures the rule-specific EStructuralFeature metadata for a SerializationRule.
	 */
	public static abstract class SerializationFeature implements Nameable
	{
		protected final @NonNull EStructuralFeature eStructuralFeature;

		protected SerializationFeature(@NonNull EStructuralFeature eStructuralFeature) {
			this.eStructuralFeature = eStructuralFeature;
		}

		public @NonNull EStructuralFeature getEStructuralFeature() {
			return eStructuralFeature;
		}

		@Override
		public @NonNull String getName() {
			return SerializationUtils.getName(eStructuralFeature);
		}

		@Override
		public @NonNull String toString() {
			return eStructuralFeature.getEContainingClass().getName() + "::" + eStructuralFeature.getName();
		}
	}

	/**
	 * SerializationAttribute captures the rule-specific EAttribute metadata for a SerializationRule.
	 */
	public static abstract class SerializationAttribute extends SerializationFeature
	{
		/**
		 * True if the default value must be used to satisfy grammar rule multiplicities.
		 */
		protected final boolean needsDefault;

		public SerializationAttribute(@NonNull EAttribute eAttribute, boolean needsDefault) {
			super(eAttribute);
			this.needsDefault = needsDefault;
		}

		public @Nullable SerializationEnumeratedAttribute asEnumerated() {
			return null;
		}

		public abstract @Nullable GrammarCardinality basicGetGrammarCardinality(@Nullable EnumerationValue enumerationValue);

	//	public @NonNull EAttribute getEAttribute() {
	//		return eAttribute;
	//	}

		public abstract @NonNull EnumerationValue @NonNull [] getEnumerationValues();

		public boolean needsDefault() {
			return needsDefault;
		}
	}

	/**
	 * SerializationAttribute captures the rule-specific EAttribute metadata for a SerializationRule.
	 */
	public static class SerializationEnumeratedAttribute extends SerializationAttribute
	{
		/**
		 * The various groups of strings that may beassigned to the attribute, if string-valued. null if none.
		 */
		protected final @NonNull EnumerationValue @NonNull [] enumerationValues;

		/**
		 * The corresponding cardinality for each enumerationValues.
		 */
		protected final @NonNull GrammarCardinality @NonNull [] grammarCardinalities;

		public SerializationEnumeratedAttribute(@NonNull EAttribute eAttribute, boolean needsDefault, @NonNull EnumerationValue @NonNull [] enumerationValues, @NonNull GrammarCardinality @NonNull [] grammarCardinalities) {
			super(eAttribute, needsDefault);
			this.enumerationValues = enumerationValues;
			this.grammarCardinalities = grammarCardinalities;
			for (@NonNull EnumerationValue enumerationValue : enumerationValues) {
				assert !enumerationValue.isNull();
			}
		}

		@Override
		public @Nullable SerializationEnumeratedAttribute asEnumerated() {
			return this;
		}

		@Override
		public @NonNull EnumerationValue @NonNull [] getEnumerationValues() {
			return enumerationValues;
		}

		@Override
		public @Nullable GrammarCardinality basicGetGrammarCardinality(@Nullable EnumerationValue enumerationValue) {
			if (enumerationValue == null) {
				return eStructuralFeature.isRequired() ? GrammarCardinality.ONE : GrammarCardinality.ZERO_OR_ONE;
			}
			for (int i = 0; i < enumerationValues.length; i++) {
				if (enumerationValues[i] == enumerationValue) {
					return grammarCardinalities[i];
				}
			}
			return null;
		}

		public @NonNull GrammarCardinality getGrammarCardinality(@Nullable EnumerationValue enumerationValue) {
			return SerializationUtils.nonNullState(basicGetGrammarCardinality(enumerationValue));
		}

		@Override
		public @NonNull String toString() {
			StringBuilder s = new StringBuilder();
			s.append(eStructuralFeature.getEContainingClass().getName());
			s.append("::");
			s.append(eStructuralFeature.getName());
			s.append(" ");
			for (int i = 0; i <enumerationValues.length; i++) {
				if (i > 0) {
					s.append(",");
					s.append(enumerationValues[i]);
					s.append(grammarCardinalities[i]);
				}
			}
			@SuppressWarnings("null")
			@NonNull String castString = s.toString();
			return castString;
		}
	}

	/**
	 * SerializationSimpleAttribute captures the rule-specific EAttribute metadata for a SerializationRule.
	 * Nothing is known about potential values of the attribute.
	 */
	public static class SerializationSimpleAttribute extends SerializationAttribute
	{
		/**
		 * The cardinality of a single attribute assignment term in the grammar, null for a multiple assignment term even if same rule each time) (.
		 */
		protected final @NonNull GrammarCardinality grammarCardinality;

		public SerializationSimpleAttribute(@NonNull EAttribute eAttribute, boolean needsDefault, @NonNull GrammarCardinality grammarCardinality) {
			super(eAttribute, needsDefault);
			this.grammarCardinality = grammarCardinality;
		}

		@Override
		public @NonNull EnumerationValue @NonNull [] getEnumerationValues() {
			return EnumerationValue.NO_ENUMERATION_VALUES;
		}

		public @NonNull GrammarCardinality getGrammarCardinality() {
			return grammarCardinality;
		}

		@Override
		public @Nullable GrammarCardinality basicGetGrammarCardinality(@Nullable EnumerationValue enumerationValue) {
			return enumerationValue == null ? grammarCardinality : null;
		}

		@Override
		public @NonNull String toString() {
			return super.toString() + " " + grammarCardinality;
		}
	}

	/**
	 * SerializationReference captures the rule-specific EReference metadata for a SerializationRule.
	 */
	public static class SerializationReference extends SerializationFeature
	{
		/**
		 * The possible rules that may produce a satisfactory type as the target of this reference.
		 */
		protected final @Nullable GrammarRuleVector targetGrammarRuleVector;

		/**
		 * The index of the grammar rule for each distinctly-ruled assignment.
		 */
		protected final int @NonNull [] grammarRuleIndexes;

		/**
		 * The corresponding net cardinality for each distinctly-ruled assignment.
		 */
		protected final @NonNull GrammarCardinality @NonNull [] grammarCardinalities;

		public SerializationReference(@NonNull EReference eReference, @Nullable GrammarRuleVector targetGrammarRuleVector, int @NonNull [] grammarRuleIndexes, @NonNull GrammarCardinality @NonNull [] grammarCardinalities) {
			super(eReference);
		// FIXME	assert targetGrammarRuleVector != null;			// FIXME @NonNull
			this.targetGrammarRuleVector = targetGrammarRuleVector;
			this.grammarRuleIndexes = grammarRuleIndexes;
			this.grammarCardinalities = grammarCardinalities;
		}

		public @Nullable GrammarCardinality basicGetGrammarCardinality(int grammarRuleIndex) {
			for (int i = 0; i < grammarRuleIndexes.length; i++) {
				if (grammarRuleIndexes[i] == grammarRuleIndex) {
					return grammarCardinalities[i];
				}
			}
			return null;
		}

	//	public @NonNull EReference getEReference() {
	//		return eReference;
	//	}

		public @NonNull GrammarCardinality getGrammarCardinality(int grammarRuleIndex) {
			return SerializationUtils.nonNullState(basicGetGrammarCardinality(grammarRuleIndex));
		}

		public int @NonNull [] getGrammarRuleIndexes() {
			return grammarRuleIndexes;
		}

		public @Nullable GrammarRuleVector getTargetGrammarRuleVector() {
			return targetGrammarRuleVector;
		}

		@Override
		public @NonNull String toString() {
			StringBuilder s = new StringBuilder();
			s.append(eStructuralFeature.getEContainingClass().getName());
			s.append("::");
			s.append(eStructuralFeature.getName());
			s.append(":{");
			for (int i = 0; i <grammarRuleIndexes.length; i++) {
				if (i > 0) {
					s.append(",");
				}
				s.append(grammarRuleIndexes[i]);
				s.append(grammarCardinalities[i]);
			}
			s.append("}");
			@SuppressWarnings("null")
			@NonNull String castString = s.toString();
			return castString;
		}
	}

	private static final @NonNull SerializationMatchStep @NonNull [] RUNTIME_STEP = new @NonNull SerializationMatchStep[] { new SerializationMatchStep.MatchStep_Runtime() };

	private final @Nullable SerializationMetaData serializationMetaData;

	/**
	 * The unqualified grammar rule name.
	 */
	protected final @NonNull String name;

	/**
	 * The grammar rule for which this is (one of) the serialization rules.
	 */
	protected final int grammarRuleValueIndex;

	/**
	 * The matching instructions to confirm applicability and deduce variables.
	 */
	private final @NonNull SerializationMatchStep @NonNull [] matchSteps;

	/**
	 * The serialization instructions to convert the model element to text..
	 */
	private final @NonNull SerializationStep @NonNull [] serializationSteps;

	/**
	 * The per-EStructuralFeature meta data.
	 */
	private final @NonNull SerializationFeature @Nullable [] serializationFeatures;

	/**
	 * An optional helper that can translate metadata index to metaobjects for diagnostics.
	 */
	private @Nullable SerializationRuleHelper helper;

	public SerializationRule(@NonNull SerializationMetaData serializationMetaData, @NonNull String name, int grammarRuleValueIndex,
			@NonNull SerializationMatchStep @Nullable [] matchSteps, @NonNull SerializationStep @NonNull [] serializationSteps,
			@NonNull SerializationFeature @Nullable [] serializationFeatures) {
		this.serializationMetaData = serializationMetaData;
		this.name = name;
		this.grammarRuleValueIndex = grammarRuleValueIndex;
		this.matchSteps = matchSteps != null ? matchSteps : RUNTIME_STEP;
		this.serializationSteps = serializationSteps;
		this.serializationFeatures = serializationFeatures;
		this.helper = null;
	}

	public SerializationRule(@NonNull SerializationRuleHelper helper, @NonNull String name, int grammarRuleValueIndex,
			@NonNull SerializationMatchStep @Nullable [] matchSteps, @NonNull SerializationStep @NonNull [] serializationSteps,
			@NonNull SerializationFeature @Nullable [] serializationFeatures) {
		this.serializationMetaData = null;
		this.name = name;
		this.grammarRuleValueIndex = grammarRuleValueIndex;
		this.matchSteps = matchSteps != null ? matchSteps : RUNTIME_STEP;
		this.serializationSteps = serializationSteps;
		this.serializationFeatures = serializationFeatures;
		this.helper = helper;
	}

	public @NonNull EnumerationValue @Nullable [] basicGetEnumerationValues(@NonNull EAttribute eAttribute) {
		SerializationAttribute serializationAttribute = basicGetSerializationAttribute(eAttribute);
		return serializationAttribute != null ? serializationAttribute.getEnumerationValues() : null;
	}

	public @Nullable GrammarCardinality basicGetGrammarCardinality(@NonNull EStructuralFeature eStructuralFeature) {
		if (eStructuralFeature instanceof EAttribute) {
			SerializationAttribute serializationAttribute = basicGetSerializationAttribute((EAttribute)eStructuralFeature);
			if (serializationAttribute != null) {
				GrammarCardinality grammarCardinality = serializationAttribute.basicGetGrammarCardinality(null);
			//	assert grammarCardinality == serializationAttribute.getGrammarCardinality();
				return grammarCardinality;
			}
		}
		return null;
	}

	public @Nullable GrammarCardinality basicGetGrammarCardinality(@NonNull EAttribute eAttribute, @NonNull EnumerationValue enumerationValue) {
		SerializationAttribute serializationAttribute = basicGetSerializationAttribute(eAttribute);
		return serializationAttribute != null ? serializationAttribute.basicGetGrammarCardinality(enumerationValue) : null;
	}

	public @Nullable GrammarCardinality basicGetGrammarCardinality(@NonNull EReference eReference, @NonNull ParserRuleValue ruleValue) {
		SerializationReference serializationReference = basicGetSerializationReference(eReference);
		return serializationReference != null ? serializationReference.basicGetGrammarCardinality(ruleValue.getIndex()) : null;
	}

	public @Nullable SerializationAttribute basicGetSerializationAttribute(@NonNull EAttribute eAttribute) {
		if (serializationFeatures != null) {
			for (@NonNull SerializationFeature serializationFeature : serializationFeatures) {
				if (serializationFeature.getEStructuralFeature() == eAttribute) {
					return (SerializationAttribute)serializationFeature;
				}
			}
		}
		return null;
	}

	public @NonNull SerializationFeature @Nullable [] basicGetSerializationFeatures() {
		return serializationFeatures;
	}

	public @Nullable SerializationReference basicGetSerializationReference(@NonNull EReference eReference) {
		if (serializationFeatures != null) {
			for (@NonNull SerializationFeature serializationFeature : serializationFeatures) {
				if (serializationFeature.getEStructuralFeature() == eReference) {
					return (SerializationReference)serializationFeature;
				}
			}
		}
		return null;
	}

	public @Nullable GrammarRuleVector basicGetTargetGrammarRuleVector(@NonNull EReference eReference) {
		SerializationReference serializationReference = basicGetSerializationReference(eReference);
		return serializationReference != null ? serializationReference.getTargetGrammarRuleVector() : null;
	}

	public void formatRule(@NonNull UserElementSerializer serializer, @NonNull SerializationBuilder serializationBuilder) {
		formatSubRule(0, serializationSteps.length, serializer, serializationBuilder);
	}

	public void formatSubRule(int startIndex, int endIndex, @NonNull UserElementSerializer serializer, @NonNull SerializationBuilder serializationBuilder) {
		UserModelAnalysis modelAnalysis = serializer.getModelAnalysis();
		SerializationMetaData serializationMetaData = modelAnalysis.getSerializationMetaData();
		Map<@NonNull String, @NonNull List<@NonNull ILeafNode>> keyword2leafNodes = new HashMap<>();
		Map<@NonNull EReference, @NonNull List<@NonNull ILeafNode>> eReference2leafNodes = new HashMap<>();
		Map<@NonNull AbstractRule, @NonNull List<@NonNull ILeafNode>> calledRule2leafNodes = new HashMap<>();
		Map<@NonNull SerializationRule, @NonNull List<@NonNull ICompositeNode>> serializationRule2compositeNodes = new HashMap<>();
		ICompositeNode parentNode = NodeModelUtils.getNode(serializer.getElement());
		assert parentNode != null;
		for (@NonNull INode childNode : SerializationUtils.getChildren(parentNode)) {
			if (childNode instanceof ILeafNode) {
				ILeafNode leafNode = (ILeafNode)childNode;
				if (!leafNode.isHidden()) {
					EObject grammarElement = leafNode.getGrammarElement();
					if (grammarElement instanceof Keyword) {
						String value = ((Keyword)grammarElement).getValue();
						if (value != null) {
							List<@NonNull ILeafNode> leafNodes = SerializationUtils.maybeNull(keyword2leafNodes.get(value));
							if (leafNodes == null) {
								leafNodes = new ArrayList<>();
								keyword2leafNodes.put(value, leafNodes);
							}
							leafNodes.add(leafNode);
						}
					}
					else if (grammarElement instanceof CrossReference) {
						EReference eReference = GrammarUtil.getReference((CrossReference)grammarElement);
						if (eReference != null) {
							List<@NonNull ILeafNode> leafNodes = SerializationUtils.maybeNull(eReference2leafNodes.get(eReference));
							if (leafNodes == null) {
								leafNodes = new ArrayList<>();
								eReference2leafNodes.put(eReference, leafNodes);
							}
							leafNodes.add(leafNode);
						}
					}
					else if (grammarElement instanceof RuleCall) {
						AbstractRule calledRule = ((RuleCall)grammarElement).getRule();
						if (calledRule != null) {
							List<@NonNull ILeafNode> leafNodes = SerializationUtils.maybeNull(calledRule2leafNodes.get(calledRule));
							if (leafNodes == null) {
								leafNodes = new ArrayList<>();
								calledRule2leafNodes.put(calledRule, leafNodes);
							}
							leafNodes.add(leafNode);
						}
					}
					else {
						throw new UnsupportedOperationException();
					}
				}
			}
			else if (childNode instanceof ICompositeNode) {
				ICompositeNode compositeNode = (ICompositeNode)childNode;
				EObject grammarElement = compositeNode.getGrammarElement();
				if (grammarElement instanceof RuleCall) {
					AbstractRule calledRule = ((RuleCall)grammarElement).getRule();
					if (calledRule != null) {
						GrammarRuleValue calledRuleValue = serializationMetaData.basicGetGrammarRuleValue(SerializationUtils.getName(calledRule));
						assert calledRuleValue != null;
						EObject childElement = compositeNode.getSemanticElement();
						assert childElement != null;
						UserElementAnalysis childElementAnalysis = modelAnalysis.getElementAnalysis(childElement);
						DynamicRuleMatch dynamicRuleMatch = childElementAnalysis.basicCreateDynamicRuleMatch(calledRuleValue.getIndex());
						if (dynamicRuleMatch != null) {
							SerializationRule childSerializationRule = dynamicRuleMatch.getSerializationRule();
							List<@NonNull ICompositeNode> compositeNodes = SerializationUtils.maybeNull(serializationRule2compositeNodes.get(childSerializationRule));
							if (compositeNodes == null) {
								compositeNodes = new ArrayList<>();
								serializationRule2compositeNodes.put(childSerializationRule, compositeNodes);
							}
							compositeNodes.add(compositeNode);
						}
					}
				}
				else {
					throw new UnsupportedOperationException();
				}
			}
			else {
				throw new UnsupportedOperationException();
			}
		}



		for (int index = startIndex; index < endIndex; ) {
			SerializationStep serializationStep = serializationSteps[index++];
			@NonNull SerializationSegment @Nullable [] segments = serializationStep.getSerializationSegments(); // FIXME Could invite serializer to provide a dynamicSerializationSegments.
			if (serializationStep instanceof SerializationStepSequence) {
				int stepsRange = ((SerializationStepSequence)serializationStep).getStepsRange();
				if (segments != null) {
					for (@NonNull SerializationSegment segment : segments) {
						segment.serialize(index-1, serializer, serializationBuilder);
					}
				}
				else {
					int cardinalityVariableIndex = ((SerializationStepSequence)serializationStep).getVariableIndex();
					int stepLoopCount = cardinalityVariableIndex >= 0 ? serializer.getValue(cardinalityVariableIndex) : 1;
					for (int i = 0; i < stepLoopCount; i++) {
						formatSubRule(index-1, index + stepsRange, serializer, serializationBuilder);
					}
				}
				index += stepsRange;
			}
			else {
				if (segments != null) {
					for (@NonNull SerializationSegment segment : segments) {
						segment.serialize(index-1, serializer, serializationBuilder);
					}
				}
				else {
					serializationStep.serializeInnerValue(index-1, serializer, serializationBuilder);
				}
			}
		}
	}

	public @NonNull DiagnosticStringBuilder getDiagnosticStringBuilder() {
		if (serializationMetaData != null) {
			return new SerializationMetaDataDiagnosticStringBuilder(serializationMetaData);
		}
		else {
			return new DiagnosticStringBuilderWithHelper(helper);
		}
	}

	public int getGrammarRuleValueIndex() {
		return grammarRuleValueIndex;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	public @NonNull SerializationAttribute getSerializationAttribute(@NonNull EAttribute eAttribute) {
		return SerializationUtils.nonNullState(basicGetSerializationAttribute(eAttribute));
	}

	public @Nullable SerializationFeature getSerializationFeature(@NonNull EStructuralFeature eStructuralFeature) {
		@NonNull SerializationFeature @Nullable [] serializationFeatures2 = serializationFeatures;
		if (serializationFeatures2 == null) {
			return null;
		}
		for (@NonNull SerializationFeature serializationFeature : serializationFeatures2) {
			if (serializationFeature.getEStructuralFeature() == eStructuralFeature) {	// NB == rather than name-equals
				return serializationFeature;
			}
		}
		return null;
	}

	public @NonNull SerializationFeature @Nullable [] getSerializationFeatures() {
		return serializationFeatures;
	}

	public @NonNull SerializationMatchStep @NonNull [] getSerializationMatchSteps() {
		return matchSteps;
	}

	public @NonNull SerializationReference getSerializationReference(@NonNull EReference eReference) {
		return SerializationUtils.nonNullState(basicGetSerializationReference(eReference));
	}

	public @NonNull SerializationStep @NonNull [] getSerializationSteps() {
		return serializationSteps;
	}

	public boolean needsDefault(@NonNull EAttribute eAttribute) {
		SerializationAttribute serializationAttribute = basicGetSerializationAttribute(eAttribute);
		return serializationAttribute != null ? serializationAttribute.needsDefault() : false;
	}

	public void serialize(@NonNull UserElementSerializer serializer, @NonNull SerializationBuilder serializationBuilder) {
		for (int index = 0; index < serializationSteps.length; ) {
			SerializationStep serializationStep = serializationSteps[index];
			index = serializationStep.serializeOuterValue(index, serializer, serializationBuilder);
		}
	}

	public void toMatchTermString(@NonNull DiagnosticStringBuilder s, int depth) {
		toRuleString(s);
		if (matchSteps.length > 0) {
			for (@NonNull SerializationMatchStep matchStep : matchSteps) {
				s.appendIndentation(depth);
				matchStep.toString(s);
				s.append(";");
			}
		}
	}

	public @NonNull String toRuleString() {
		DiagnosticStringBuilder s = getDiagnosticStringBuilder();
		toRuleString(s);
		return s.toString();
	}

	public void toRuleString(@NonNull DiagnosticStringBuilder s) {
		toRuleString(s, 0, serializationSteps.length);
	}

	protected void toRuleString(@NonNull DiagnosticStringBuilder s, int start, int end) {
		for (int i = start; i < end; ) {
			SerializationStep serializationStep = serializationSteps[i++];
			if (serializationStep instanceof SerializationStepSequence) {
				SerializationStepSequence serializationStepSequence = (SerializationStepSequence)serializationStep;
				s.append("(");
				toRuleString(s, i, i + serializationStepSequence.getStepsRange());
				s.append(")[");
				int variableIndex = serializationStepSequence.getVariableIndex();
				if (variableIndex >= 0) {
					s.appendVariableName(variableIndex);
					s.append(":");
				}
				s.appendObject(serializationStepSequence.getGrammarCardinality());
				s.append("]");
				i += serializationStepSequence.getStepsRange();
			}
			else if (!(serializationStep instanceof SerializationStepWrapper)) {
				serializationStep.toStepString(s);
			}
			if ((i < end) && !(serializationStep instanceof SerializationStepWrapper)) {
				s.append(" ");
			}
		}
	}

	@Override
	public String toString() {
		DiagnosticStringBuilder s = getDiagnosticStringBuilder();
		s.append(getName());
		s.append(": ");
		toString(s, 0);
		return s.toString();
	}

	public void toString(@NonNull DiagnosticStringBuilder s, int depth) {
		toRuleString(s, 0, serializationSteps.length);
	}
}