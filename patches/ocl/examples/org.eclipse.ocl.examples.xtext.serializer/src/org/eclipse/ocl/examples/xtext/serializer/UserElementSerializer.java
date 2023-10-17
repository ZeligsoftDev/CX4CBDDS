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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A Serializer supports the serialization of a user model element, automatically creating a hierarchy
 * of Serializers for the containment herarchy of the user model element.
 */
public class UserElementSerializer
{
	protected final @NonNull DynamicRuleMatch dynamicRuleMatch;
//	protected final @NonNull UserElementAnalysis elementAnalysis;
	protected final @NonNull UserModelAnalysis modelAnalysis;
	protected final @NonNull SerializationRule serializationRule;
	protected final @NonNull EObject element;
	private @Nullable Map<@NonNull EStructuralFeature, @NonNull Integer> feature2consumptions = null;

	public UserElementSerializer(@NonNull DynamicRuleMatch dynamicRuleMatch, @NonNull EObject element) {
		this.dynamicRuleMatch = dynamicRuleMatch;
		UserElementAnalysis elementAnalysis = dynamicRuleMatch.getElementAnalysis();
		this.modelAnalysis = elementAnalysis.getModelAnalysis();
		this.serializationRule = dynamicRuleMatch.getSerializationRule();
		this.element = element;
	}

	/**
	 * Return the next eStructuralFeature child object of this serializer's element.
	 */
	public @Nullable Object consumeNext(@NonNull EStructuralFeature eStructuralFeature) {
		Map<@NonNull EStructuralFeature, @NonNull Integer> feature2consumptions = this.feature2consumptions;
		if (feature2consumptions == null) {
			this.feature2consumptions = feature2consumptions = new HashMap<>();
		}
		int index;
		Integer count = SerializationUtils.maybeNull(feature2consumptions.get(eStructuralFeature));
		if (count == null) {
			@SuppressWarnings("null")
			@NonNull Integer castInteger = Integer.valueOf(1);
			feature2consumptions.put(eStructuralFeature, castInteger);
			index = 0;
		}
		else {
			int intValue = count.intValue();
			@SuppressWarnings("null")
			@NonNull Integer castInteger = Integer.valueOf(intValue+1);
			feature2consumptions.put(eStructuralFeature, castInteger);
			index = intValue;
		}
		Object object = element.eGet(eStructuralFeature);
		if (eStructuralFeature.isMany()) {
			@SuppressWarnings("unchecked") List<EObject> eList = (List<EObject>)object;
			assert index < eList.size();
			object = eList.get(index);
		}
		else {
			assert index == 0;
		}
		return object;
	}

//	public @NonNull DynamicRuleMatch getDynamicRuleMatch() {
//		return dynamicRuleMatch;
//	}

	public @NonNull EObject getElement() {
		return element;
	}

//	public @NonNull UserElementAnalysis getElementAnalysis() {
//		return elementAnalysis;
//	}

	public @NonNull UserModelAnalysis getModelAnalysis() {
		return modelAnalysis;
	}

	public @NonNull SerializationMetaData getSerializationMetaData() {
		return modelAnalysis.getSerializationMetaData();
	}

	public @NonNull SerializationRule getSerializationRule() {
		return serializationRule;
	}

	public int getValue(int variableIndex) {
		return SerializationUtils.nonNullState(dynamicRuleMatch.getValue(variableIndex)).intValue();
	}

	/**
	 * Serialize this serializer's configured element to the serializationBuilder.
	 */
	public void serialize(@NonNull SerializationBuilder serializationBuilder) {
		serializationRule.serialize(this, serializationBuilder);
	}

	/**
	 * Create and use a new serilaizer to serialize element to the serializationBuilder.
	 */
	public void serializeElement(@NonNull SerializationBuilder serializationBuilder, @NonNull EObject element, @Nullable GrammarRuleValue targetRuleValue) {
		modelAnalysis.serialize(serializationBuilder, element, targetRuleValue);
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		Map<@NonNull EStructuralFeature, @NonNull Integer> feature2consumptions2 = feature2consumptions;
		if (feature2consumptions2 != null) {
			List<@NonNull EStructuralFeature> features = new ArrayList<>(feature2consumptions2.keySet());
			Collections.sort(features, SerializationUtils.ENAMED_ELEMENT_COMPARATOR);
			boolean isFirst = true;
			for (@NonNull EStructuralFeature feature : features) {
				if (!isFirst) {
					s.append(",");
				}
				s.append(feature.getName());
				Integer consumed = feature2consumptions2.get(feature);
				assert consumed != null;
				s.append("[");
				s.append(consumed);
				s.append("]");
				isFirst = false;
			}
		}
		@SuppressWarnings("null")
		@NonNull String castString = s.toString();
		return castString;
	}
}