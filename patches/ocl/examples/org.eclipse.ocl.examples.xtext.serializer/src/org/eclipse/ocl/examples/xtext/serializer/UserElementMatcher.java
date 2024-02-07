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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.serializer.SerializationRule.SerializationAttribute;

/**
 * A Serializer supports the serialization of a user model element, automatically creating a hierarchy
 * of Serializers for the containment herarchy of the user model element.
 */
public class UserElementMatcher
{
	private static class MatcherContext extends HashMap<@NonNull EStructuralFeature, @NonNull Integer>
	{
		private static final long serialVersionUID = 1L;

		private @NonNull MatcherContext outerMatcherContext;
		private @Nullable EStructuralFeature failureFeature = null;
		private @Nullable SerializationStep failureStep = null;

		public MatcherContext() {
			this.outerMatcherContext = this;
		}

		public MatcherContext(@NonNull MatcherContext outerMatcherContext) {
			super(outerMatcherContext);
			this.outerMatcherContext = outerMatcherContext;
		}

		public void addFailedMatchTo(@NonNull DynamicRuleMatch dynamicRuleMatch) {
			assert hasFailed();
			EStructuralFeature failureFeature2 = failureFeature;
			if (failureFeature2 != null) {
				dynamicRuleMatch.setFailedMatch(failureFeature2);
			}
			SerializationStep failureStep2 = failureStep;
			if (failureStep2 != null) {
				dynamicRuleMatch.setFailedMatch(failureStep2);
			}
		}

	//	public @NonNull EStructuralFeature getFailureFeature() {
	//		assert failureFeature != null;
	//		return failureFeature;
	//	}

	//	public @NonNull SerializationStep getFailureStep() {
	//		assert failureStep != null;
	//		return failureStep;
	//	}

		public boolean hasFailed() {
			return (failureFeature != null) || (failureStep != null);
		}

		public boolean hasProgressed() {
			if (outerMatcherContext == this) {
				return true;
			}
			if (this.size() > outerMatcherContext.size()) {
				return true;
			}
			for (@NonNull EStructuralFeature key : keySet()) {
				int thisValue = this.get(key);
				int thatValue = outerMatcherContext.get(key);
				if (thisValue > thatValue) {
					return true;
				}
			}
			return false;
		}

		public void setFailureFeature(@NonNull EStructuralFeature failureFeature) {
			this.failureFeature = failureFeature;
		}

		public void setFailureStep(@NonNull SerializationStep failureStep) {
			this.failureStep = failureStep;
		}
	}

	public static @NonNull Object NOT_AN_OBJECT = new Object();

	protected final @NonNull DynamicRuleMatch dynamicRuleMatch;
	protected final @NonNull SerializationRule serializationRule;
	protected final @NonNull UserModelAnalysis modelAnalysis;
	protected final @NonNull EObject element;
	private @NonNull MatcherContext matcherContext = new MatcherContext();

	public UserElementMatcher(@NonNull DynamicRuleMatch dynamicRuleMatch, @NonNull UserModelAnalysis modelAnalysis, @NonNull EObject element) {
		this.dynamicRuleMatch = dynamicRuleMatch;
		this.serializationRule = dynamicRuleMatch.getSerializationRule();
		this.modelAnalysis = modelAnalysis;
		this.element = element;
	}

//	public void addFailedMatch() {
//		matcherContext.addFailedMatchTo(dynamicRuleMatch);
//	}

	public void addFailedMatchTo(@NonNull DynamicRuleMatch dynamicRuleMatch) {
		matcherContext.addFailedMatchTo(dynamicRuleMatch);
	}

	public @Nullable Integer basicGetValue(int variableIndex) {
		assert variableIndex >= 0;
		return dynamicRuleMatch.basicGetValue(variableIndex);
	}

	/**
	 * Return and consume if an eStructuralFeature is available complying with one of grammarRuleIndexes.
	 */
	public Object consumeNext(@NonNull EStructuralFeature eStructuralFeature, int @Nullable [] grammarRuleIndexes) {		// FIXME need ordered rule search
		int index = getSize(eStructuralFeature);
		Object object = element.eGet(eStructuralFeature);
		if (eStructuralFeature.isMany()) {
			@SuppressWarnings("unchecked") List<EObject> eList = (List<EObject>)object;
			if (eList.size() <= index) {
				return NOT_AN_OBJECT;
			}
			object = eList.get(index);
		}
		else {
			if (0 < index) {
				return NOT_AN_OBJECT;
			}
		}
		if (eStructuralFeature instanceof EReference) {
			assert grammarRuleIndexes != null;
			EReference eReference = (EReference)eStructuralFeature;
			EObject eObject = (EObject) object;
			if (eReference.isContainment()) {
				if (eObject == null) {
					return NOT_AN_OBJECT;
				}
				UserElementAnalysis elementAnalysis = modelAnalysis.getElementAnalysis(eObject);
				for (int grammarRuleIndex : grammarRuleIndexes) {
					DynamicRuleMatch dynamicRuleMatch = elementAnalysis.basicCreateDynamicRuleMatch(grammarRuleIndex);
					if (dynamicRuleMatch != null) {
						@SuppressWarnings("null")
						@NonNull Integer castInteger = Integer.valueOf(index+1);
						matcherContext.put(eReference, castInteger);
						return object;
					}
				}
			}
			else if (eObject != null) {
				@SuppressWarnings("null")
				@NonNull Integer castInteger = Integer.valueOf(index+1);
				matcherContext.put(eReference, castInteger);
				return eObject;
			}
			return NOT_AN_OBJECT;
		}
		else {
			// fIXME ?? use grammarRuleIndexes if non-null ?? check enumerationValue here
			EAttribute eAttribute = (EAttribute)eStructuralFeature;
			if (!element.eIsSet(eAttribute)) {
				SerializationAttribute serializationAttribute = serializationRule.getSerializationAttribute(eAttribute);
				if (!serializationAttribute.needsDefault()) {
					return NOT_AN_OBJECT;
				}
			}
			// FIXME Check non ParserRule grammarRuleValue
			@SuppressWarnings("null")
			@NonNull Integer castInteger = Integer.valueOf(index+1);
			matcherContext.put(eAttribute, castInteger);
			return object;
		}
	}

	public @NonNull DynamicRuleMatch getDynamicRuleMatch() {
		return dynamicRuleMatch;
	}

	public @NonNull EObject getElement() {
		return element;
	}

	public @NonNull UserModelAnalysis getModelAnalysis() {
		return modelAnalysis;
	}

	public @NonNull SerializationMetaData getSerializationMetaData() {
		return modelAnalysis.getSerializationMetaData();
	}

	public @NonNull SerializationRule getSerializationRule() {
		return serializationRule;
	}

	public int getSize(@NonNull EStructuralFeature eStructuralFeature) {
		Integer count = SerializationUtils.maybeNull(matcherContext.get(eStructuralFeature));
		return count == null ? 0 : count.intValue();
	}

	public int getValue(int variableIndex) {
		return SerializationUtils.nonNullState(dynamicRuleMatch.getValue(variableIndex)).intValue();
	}

	public boolean hasFailed() {
		return matcherContext.hasFailed();
	}

	public boolean hasProgressed() {
		return matcherContext.hasProgressed();
	}

	public void pop(boolean acceptOrReject) {
		MatcherContext innerMatcherContext = matcherContext;
		if (acceptOrReject) {
			this.matcherContext.outerMatcherContext = innerMatcherContext.outerMatcherContext;
		}
		else {
			this.matcherContext = innerMatcherContext.outerMatcherContext;
		}
	}

	public void push() {
		this.matcherContext = new MatcherContext(matcherContext);
	}

	public void setFailureFeature(@NonNull EStructuralFeature eStructuralFeature) {
		matcherContext.setFailureFeature(eStructuralFeature);	// FIXME context should be flattened
	}

	public void setFailureStep(@NonNull SerializationStep serializationStep) {
		matcherContext.setFailureStep(serializationStep);
	}

	public void setValue(int variableIndex, int matchedCount) {
		dynamicRuleMatch.putValue(variableIndex, matchedCount);
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
			List<@NonNull EStructuralFeature> features = new ArrayList<>(matcherContext.keySet());
			Collections.sort(features, SerializationUtils.ENAMED_ELEMENT_COMPARATOR);
			boolean isFirst = true;
			for (@NonNull EStructuralFeature feature : features) {
				if (!isFirst) {
					s.append(",");
				}
				s.append(feature.getName());
				Integer consumed = SerializationUtils.maybeNull(matcherContext.get(feature));
				assert consumed != null;
				s.append("[");
				s.append(consumed);
				s.append("]");
				isFirst = false;
			}
		@SuppressWarnings("null")
		@NonNull String castString = s.toString();
		return castString;
	}
}