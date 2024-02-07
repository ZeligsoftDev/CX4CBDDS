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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.serializer.DiagnosticStringBuilder.SerializationMetaDataDiagnosticStringBuilder;
import org.eclipse.ocl.examples.xtext.serializer.UserSlotAnalysis.CountedSlotAnalysis;
import org.eclipse.ocl.examples.xtext.serializer.UserSlotAnalysis.EnumeratedSlotAnalysis;

import com.google.common.collect.Lists;

/**
 * A UserElementAnalysis provides the working context to assist in the determination of the Xtext grammar rule
 * that can produce and assign a user model element that has a container.
 */
public class UserElementAnalysis implements Nameable
{
	private static int count = 0;

	protected final @NonNull UserModelAnalysis modelAnalysis;
	protected final @NonNull SerializationMetaData serializationMetaData;
	protected final @Nullable UserElementAnalysis containingElementAnalysis;
	protected final @NonNull EObject eObject;
	protected final @NonNull EClass eClass;
	protected final @NonNull EClassValue eClassValue;
	protected final @NonNull String name;
	/**
	 * The subset of the static SerializationRules that are compatiible with
	 * the containment ancestry of an actual EObject instance of EClass for the static rules.
	 */
	protected final @NonNull SerializationRule @NonNull [] serializationRules;

	/**
	 * The grammar eule indexes of the serializationRules.
	 */
	protected final @NonNull GrammarRuleVector grammarRuleVector;

	/**
	 * Cache of DynamicRuleMatch per SerializationRule at matching serializationRules index.
	 */
	private final @Nullable DynamicRuleMatch @NonNull [] dynamicRuleMatches;

	private final @NonNull Map<@NonNull EStructuralFeature, @NonNull UserSlotAnalysis> eStructuralFeature2slotAnalysis; // FIXME could be a matched index array if EClassValue knew all features

	public UserElementAnalysis(@NonNull UserModelAnalysis modelAnalysis, @Nullable UserElementAnalysis containingElementAnalysis, @NonNull EObject eObject) {
		assert eObject.eContainer() == (containingElementAnalysis == null ? null : containingElementAnalysis.getEObject());
		this.modelAnalysis = modelAnalysis;
		this.serializationMetaData = modelAnalysis.getSerializationMetaData();
		this.containingElementAnalysis = containingElementAnalysis;
		this.eObject = eObject;
		this.eClass = SerializationUtils.eClass(eObject);
		this.eClassValue = serializationMetaData.getEClassValue(eClass);
		this.name = eClass.getName() + "@" + ++count;
		this.serializationRules = analyzeSerializationRules();
		this.grammarRuleVector = analyzeGrammarRuleVector();
		this.dynamicRuleMatches = new @Nullable DynamicRuleMatch[serializationRules.length];
		for (int i = 0; i < serializationRules.length; i++) {
			dynamicRuleMatches[i] = null;
		}
		this.eStructuralFeature2slotAnalysis = analyzeSlots();
		modelAnalysis.debugAddUserElementAnalysis(this);
	}

	public boolean allRulesNeedDefault(@NonNull EAttribute eAttribute) {
		for (@NonNull SerializationRule serializationRule : serializationRules) {
			if (!serializationRule.needsDefault(eAttribute)) {
				return false;
			}
		}
		return true;
	}

	protected @NonNull UserSlotAnalysis analyzeEAttribute(@NonNull EAttribute eAttribute) {
		UserSlotAnalysis slotAnalysis;
		Object object = eObject.eGet(eAttribute);
		if (eAttribute.isMany()) {
			Iterable<@NonNull EnumerationValue> enumerationValues = getEnumerationValues(eAttribute);
			List<?> elements = (List<?>)object;
			int size = elements.size();
			if ((size > 0) && (enumerationValues != null)) {
				slotAnalysis = new EnumeratedSlotAnalysis(enumerationValues, elements);
			}
			else {
				slotAnalysis = CountedSlotAnalysis.valueOf(size);
			}
		}
		else if (object instanceof Boolean) {
			// NB Xtext has no ability to explicitly define a false Boolean.
			slotAnalysis = CountedSlotAnalysis.valueOf(object == Boolean.TRUE ? 1 : 0);
		}
		else if (eObject.eIsSet(eAttribute)) {
			Iterable<@NonNull EnumerationValue> enumerationValues = getEnumerationValues(eAttribute);
			if (enumerationValues != null) {
				slotAnalysis = new EnumeratedSlotAnalysis(enumerationValues, object);
			}
			else {
				slotAnalysis = CountedSlotAnalysis.valueOf(1);
			}
		}
		else if (eAttribute.isUnsettable()) {
			slotAnalysis = CountedSlotAnalysis.valueOf(0);
		}
		else {
			boolean allRulesNeedDefault = allRulesNeedDefault(eAttribute);
			slotAnalysis = CountedSlotAnalysis.valueOf(allRulesNeedDefault ? 1 : 0);
		}
		return slotAnalysis;
	}

	protected @Nullable UserSlotAnalysis analyzeEReference(@NonNull EReference eReference) {
		if (eReference.isContainer()) {
			return null;
		}
		UserSlotAnalysis slotAnalysis;
		Object object = eObject.eGet(eReference);
		if (eReference.isMany()) {
			@SuppressWarnings("unchecked") List<@NonNull EObject> elements = (List<@NonNull EObject>)object;
			int size = elements.size();
		//	if ((size > 0) && (grammarRuleVectors != null)) {
		//		slotAnalysis = new DiscriminatedSlotAnalysis(serializationMetaData, grammarRuleVectors, elements);
		//	}
		//	else {
				slotAnalysis = CountedSlotAnalysis.valueOf(size);
		//	}
		}
		else {
			if (object == null) {
				slotAnalysis = CountedSlotAnalysis.valueOf(0);
			}
		//	else if (grammarRuleVectors != null) {
		//		@SuppressWarnings("null") EObject eObject = (@NonNull EObject)object;
		//		slotAnalysis = new DiscriminatedSlotAnalysis(serializationMetaData, grammarRuleVectors, eObject);
		//	}
			else {
				slotAnalysis = CountedSlotAnalysis.valueOf(1);
			}
		}
		return slotAnalysis;
	}

	private @NonNull GrammarRuleVector analyzeGrammarRuleVector() {
		GrammarRuleVector grammarRuleVector = new GrammarRuleVector();
		for (@NonNull SerializationRule serializationRule : serializationRules) {
			grammarRuleVector.set(serializationRule.getGrammarRuleValueIndex());
		}
		return grammarRuleVector;
	}

	/**
	 * Determine the rules able to produce this element and the containing assignments by which it can be contained.
	 */
	private @NonNull SerializationRule @NonNull [] analyzeSerializationRules() {
		GrammarRuleVector targetRuleValueIndexes = null;
		UserElementAnalysis containingElementAnalysis2 = containingElementAnalysis;
		if (containingElementAnalysis2 != null) {
			EReference eContainmentFeature = eObject.eContainmentFeature();
			assert eContainmentFeature != null;
			EClassValue parentEClassValue = serializationMetaData.getEClassValue(containingElementAnalysis2.getEClass());
			GrammarRuleVector targetRuleValues = parentEClassValue.getAssignedTargetRuleValues(eContainmentFeature);
			if (targetRuleValues != null) {
				targetRuleValueIndexes = new GrammarRuleVector();
				for (int targetRuleValueIndex : targetRuleValues) {
					GrammarRuleValue targetRuleValue = serializationMetaData.getGrammarRuleValue(targetRuleValueIndex);
					if (targetRuleValue instanceof ParserRuleValue) {
						targetRuleValueIndexes.set(targetRuleValueIndex);
						GrammarRuleVector subParserRuleValueIndexes = ((ParserRuleValue)targetRuleValue).getSubParserRuleValueIndexes();
						if (subParserRuleValueIndexes != null) {
							targetRuleValueIndexes.setAll(subParserRuleValueIndexes);
						}
					}
				}
			}
		}
		EClassValue parentEClassValue = serializationMetaData.getEClassValue(eClass);
		return parentEClassValue.createDynamicSerializationRules(targetRuleValueIndexes);
	}

	protected @NonNull Map<@NonNull EStructuralFeature, @NonNull UserSlotAnalysis> analyzeSlots() {
		Map<@NonNull EStructuralFeature, @NonNull UserSlotAnalysis> eStructuralFeature2slotAnalysis = new HashMap<>();
		for (EStructuralFeature eFeature : eClass.getEAllStructuralFeatures()) {
			assert eFeature != null;
			if (!eFeature.isDerived() && !eFeature.isTransient() && !eFeature.isVolatile()) {
				UserSlotAnalysis slotAnalysis = null;
				if (eFeature instanceof EReference) {
					slotAnalysis = analyzeEReference((EReference)eFeature);
				}
				else {
					slotAnalysis = analyzeEAttribute((EAttribute)eFeature);
				}
				if (slotAnalysis != null) {
					eStructuralFeature2slotAnalysis.put(eFeature, slotAnalysis);
				}
			}
		}
		return eStructuralFeature2slotAnalysis;
	}

	/**
	 * Create/re-use the element-rule dynamic match for the first serializationRule that supports targetParserRuleValueIndex.
	 */
	public @Nullable DynamicRuleMatch basicCreateDynamicRuleMatch(int targetParserRuleValueIndex) {
		ParserRuleValue targetParserRuleValue = (ParserRuleValue)serializationMetaData.getGrammarRuleValue(targetParserRuleValueIndex);
		return basicCreateDynamicRuleMatch(targetParserRuleValue);
	}

	/**
	 * Create/re-use the element-rule dynamic match for the first serializationRule that supports targetParserRuleValue.
	 */
	public @Nullable DynamicRuleMatch basicCreateDynamicRuleMatch(@Nullable ParserRuleValue targetParserRuleValue) {
		for (int serializationRulesIndex = 0; serializationRulesIndex < serializationRules.length; serializationRulesIndex++) {
			SerializationRule serializationRule = serializationRules[serializationRulesIndex];
			DynamicRuleMatch dynamicRuleMatch = basicCreateDynamicRuleMatch(serializationRule, serializationRulesIndex);
			if ((targetParserRuleValue == null) || targetParserRuleValue.subParserRuleValueClosureContains(serializationRule.getGrammarRuleValueIndex())) {
				if (dynamicRuleMatch != null) {
					return dynamicRuleMatch;
				}
			}
		}
		return null;
	}

	/**
	 * Create/re-use the element-rule dynamic match for the specific serializationRule.
	 */
	public @Nullable DynamicRuleMatch basicCreateDynamicRuleMatch(@NonNull SerializationRule serializationRule) {
		//
		//	Create/re-use the dynamic match for the element-rule pair.
		//
		for (int serializationRulesIndex = 0; serializationRulesIndex < serializationRules.length; serializationRulesIndex++) {
			if (serializationRules[serializationRulesIndex] == serializationRule) {   // == is fast, binary search is unlikely to be justified
				return basicCreateDynamicRuleMatch(serializationRule, serializationRulesIndex);
			}
		}
		return null;
	//	throw new IllegalStateException("Invalid SerializationRule '" + serializationRule.getName() + "' for '" + getName() + "'");
	}

	/**
	 * Create/re-use the element-rule dynamic match for the specific serializationRule which is at serializationRules[serializationRulesIndex].
	 */
	private @Nullable DynamicRuleMatch basicCreateDynamicRuleMatch(@NonNull SerializationRule serializationRule, int serializationRulesIndex) {
		assert serializationRules[serializationRulesIndex] == serializationRule;
		DynamicRuleMatch dynamicRuleMatch = dynamicRuleMatches[serializationRulesIndex];
		if (dynamicRuleMatch == null) {
			dynamicRuleMatch = new DynamicRuleMatch(this, serializationRule);
			dynamicRuleMatches[serializationRulesIndex] = dynamicRuleMatch;
			if (!dynamicRuleMatch.analyze()) {
				assert dynamicRuleMatch.matchFailed();
				return null;
			}
		}
		else if (dynamicRuleMatch.matchFailed()) {
			return null;
		}
		return dynamicRuleMatch;
	}

/*	public @Nullable DynamicRuleMatch basicGetDynamicRuleMatch(@NonNull SerializationRule serializationRule) {
		for (int i = 0; i< serializationRules.length; i++) {
			if (serializationRules[i] == serializationRule) {		// == is fast, binary search is unlikley to be justified
				return dynamicRuleMatches[i];
			}
		}
		return null;
	} */

	public @Nullable UserSlotAnalysis basicGetSlotAnalysis(@NonNull EStructuralFeature eStructuralFeature) {
		return eStructuralFeature2slotAnalysis.get(eStructuralFeature);
	}

	/**
	 * Append a disgnosis of ths element, retuning truue if sometning appended, false
	 * if nothing is wrong with his element,
	 */
	public boolean diagnose(@NonNull DiagnosticStringBuilder s) {
		boolean hasFailure = false;
	//	boolean hasSuccess = false;
		for (@Nullable DynamicRuleMatch dynamicRuleMatch : dynamicRuleMatches) {
			if (dynamicRuleMatch != null) {
				if (dynamicRuleMatch.matchFailed()) {
					hasFailure = true;
				}
				else {
				//	hasSuccess = true;
					return false;
				}
			}
		}
		if (!hasFailure) {
			return false;
		}
	//	if (serializationRules2 == null) {
	//		s.append(" - No serialization rules.");
	//		return;
	//	}
		diagnoseEObject(s, eObject);
		char c = 'A';
		for (@NonNull SerializationRule serializationRule : serializationRules) {
			s.append("\n  [");
			s.append(c++);
			s.append("] ");
			serializationRule.toRuleString(s);
		}
		s.append("\n");
		List<@NonNull EStructuralFeature> sortedFeatures = Lists.newArrayList(getEStructuralFeatures());
		if (!sortedFeatures.isEmpty()) {
			Collections.sort(sortedFeatures, SerializationUtils.ENAMED_ELEMENT_COMPARATOR);
			c = 'A';
			s.appendWithFormat("%-30.30s%9s", "feature", "actual");
		//	Set<@NonNull EStructuralFeature> allFeatures = new HashSet<>();
			for (@SuppressWarnings("unused") @NonNull SerializationRule serializationRule : serializationRules) {
				s.append(" [");
				s.append(c++);
				s.append("]");
		//		for (@NonNull EStructuralFeature eStructuralFeature : serializationRule.getEStructuralFeatures()) {
		//			allFeatures.add(eStructuralFeature);
		//		}
			}
			for (@NonNull EStructuralFeature eStructuralFeature : sortedFeatures) {
				s.append("\n");
				int size = getSize(eStructuralFeature);
				s.appendWithFormat("%-30.30s%8d", eStructuralFeature.getName(), size);
				for (@NonNull SerializationRule serializationRule : serializationRules) {
					GrammarCardinality grammarCardinality = serializationRule.basicGetGrammarCardinality(eStructuralFeature);
					s.appendWithFormat("%4s", grammarCardinality != null ? grammarCardinality.toString() : "0");
				}
				if (eStructuralFeature instanceof EAttribute) {
					EAttribute eAttribute = (EAttribute)eStructuralFeature;
					Iterable<@NonNull EnumerationValue> enumerationValues = getEnumerationValues(eAttribute);
					if (enumerationValues != null) {
						List<@NonNull EnumerationValue> sortedEnumerationValues = Lists.newArrayList(enumerationValues);
						Collections.sort(sortedEnumerationValues, SerializationUtils.NAMEABLE_COMPARATOR);
						for (@NonNull EnumerationValue enumerationValue : sortedEnumerationValues) {
							int size2 = getSize(eAttribute, enumerationValue);
							s.appendWithFormat("\n %-29.29s%8d", "'" + enumerationValue.getName() + "'", size2);
							for (@NonNull SerializationRule serializationRule : serializationRules) {
								GrammarCardinality grammarCardinality = serializationRule.basicGetGrammarCardinality(eAttribute, enumerationValue);
								s.appendWithFormat("%4s", grammarCardinality != null ? grammarCardinality.toString() : "0");
							}
						}
					}
				}
				else {
					EReference eReference = (EReference)eStructuralFeature;
					GrammarRuleVector assignedRuleValueIndexes = getAssignedRuleValueIndexes(eReference);
					if (assignedRuleValueIndexes != null) {
						for (int ruleValueIndex : assignedRuleValueIndexes) {
							ParserRuleValue ruleValue = (ParserRuleValue)serializationMetaData.getGrammarRuleValue(ruleValueIndex);
							int size2 = getSize(eReference, assignedRuleValueIndexes);
							s.appendWithFormat("\n %-29.29s%8d", "'" + ruleValue.getName() + "'", size2);
							for (@NonNull SerializationRule serializationRule : serializationRules) {
								GrammarCardinality grammarCardinality = serializationRule.basicGetGrammarCardinality(eReference, ruleValue);
								s.appendWithFormat("%4s", grammarCardinality != null ? grammarCardinality.toString() : "0");
							}
						}
					}
				}
			}
		}
		else {
			s.append("no features");
		}
		c = 'A';
		for (@Nullable DynamicRuleMatch dynamicRuleMatch : dynamicRuleMatches) {
			s.append("\n [");
			s.append(c++);
			s.append("] ");
			s.append(dynamicRuleMatch != null ? dynamicRuleMatch.getReasonString() : "Not analyzed.");
		}
		s.append("\n");
		return true;
	}

	public void diagnoseEObject(@NonNull DiagnosticStringBuilder s, @NonNull EObject eObject) {
		EObject eContainer = eObject.eContainer();
		if (eContainer != null) {
			diagnoseEObject(s, eContainer);
			s.appendObject("::");
			EReference eContainmentFeature = eObject.eContainmentFeature();
			if (eContainmentFeature != null) {
				s.appendObject(eContainmentFeature.getName());
				if (eContainmentFeature.isMany()) {
					s.append("[");
					s.appendObject(((EList<?>)eContainer.eGet(eContainmentFeature)).indexOf(eObject));
					s.append("]");
				}
				s.append("\n   / ");
			}
		}
		EClass eClass = eObject.eClass();
		s.appendObject(eClass.getName());
		String name = null;
		String id = null;
		String string = null;
		for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
			if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute)eStructuralFeature;
				if (eAttribute.getEAttributeType().getInstanceClass() == String.class) {
					String featureName = eAttribute.getName();
					if ("name".equals(featureName)) {
						name = (String) eObject.eGet(eAttribute);
						break;
					}
					else if ("id".equals(featureName)) {
						id = (String) eObject.eGet(eAttribute);
					}
					else {
						string = (String) eObject.eGet(eAttribute);
					}
				}
			}
		}
		if (name == null) {
			name = id;
		}
		if (name == null) {
			name = string;
		}
		if (name != null) {
			s.append("'");
			s.append(name);
			s.append("'");
		}
	}

	public @Nullable GrammarRuleVector getAssignedRuleValueIndexes(@NonNull EReference eReference) {
		GrammarRuleVector allAssignedRuleValueIndexes = null;
		for (@NonNull SerializationRule serializationRule : serializationRules) {
			GrammarRuleVector assignedRuleValueIndexes = serializationRule.basicGetTargetGrammarRuleVector(eReference);
			if (assignedRuleValueIndexes != null) {
				if (allAssignedRuleValueIndexes == null) {
					allAssignedRuleValueIndexes = new GrammarRuleVector();
				}
				allAssignedRuleValueIndexes.setAll(assignedRuleValueIndexes);
			}
		}
		return allAssignedRuleValueIndexes;
	}

/*	public @NonNull GrammarRuleVector getCallableGrammarRuleVector() {
		int [] indexes = new int[serializationRules.length];
		for (int i = 0; i < serializationRules.length; i++) {
			indexes[i] = serializationRules[i].getGrammarRuleValueIndex();
		}
		return new GrammarRuleVector(indexes);
	} */

	public @Nullable UserElementAnalysis getContainingElementAnalysis() {
		return containingElementAnalysis;
	}

	public @NonNull EClass getEClass() {
		return eClass;
	}

	public @NonNull EObject getEObject() {
		return eObject;
	}

	public @NonNull Iterable<@NonNull EStructuralFeature> getEStructuralFeatures() {
		@SuppressWarnings("null")
		@NonNull Set<@NonNull EStructuralFeature> castKeySet = eStructuralFeature2slotAnalysis.keySet();
		return castKeySet;
	}

	public @Nullable Iterable<@NonNull EnumerationValue> getEnumerationValues(@NonNull EAttribute eAttribute) {
		Set<@NonNull EnumerationValue> allEnumerationValues = null;
		for (@NonNull SerializationRule serializationRule : serializationRules) {
			@NonNull EnumerationValue[] enumerationValues = serializationRule.basicGetEnumerationValues(eAttribute);
			if ((enumerationValues != null) && (enumerationValues.length > 0)) {
				if (allEnumerationValues == null) {
					allEnumerationValues = new HashSet<>();
				}
				for (@NonNull EnumerationValue enumerationValue : enumerationValues) {
					allEnumerationValues.add(enumerationValue);
				}
			}
		}
		return allEnumerationValues;
	}

//	public @NonNull GrammarAnalysis getGrammarAnalysis() {
//		return grammarAnalysis;
//	}

	public @NonNull GrammarRuleVector getGrammarRuleVector() {
		return grammarRuleVector;
	}

	public @Nullable Iterable<@NonNull GrammarRuleVector> getGrammarRuleVectors(@NonNull EReference eReference) {
		Set<@NonNull GrammarRuleVector> allGrammarRuleVectors = null;
		for (@NonNull SerializationRule serializationRule : serializationRules) {
			GrammarRuleVector grammarRuleVector = serializationRule.basicGetTargetGrammarRuleVector(eReference);
			if (grammarRuleVector != null) {
				if (allGrammarRuleVectors == null) {
					allGrammarRuleVectors = new HashSet<>();
				}
				allGrammarRuleVectors.add(grammarRuleVector);
			}
		}
		return allGrammarRuleVectors;
	}

	public @NonNull UserModelAnalysis getModelAnalysis() {
		return modelAnalysis;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	public @NonNull SerializationRule @NonNull [] getSerializationRules() {
		return serializationRules;
	}

	public int getSize(@NonNull EStructuralFeature eStructuralFeature) {
		UserSlotAnalysis slotAnalysis = basicGetSlotAnalysis(eStructuralFeature);
		if (slotAnalysis == null) {
			return 0;
		}
		if (slotAnalysis.isCounted()) {
			return slotAnalysis.asCounted();
		}
		else if (slotAnalysis.isEnumerated()) {
			return slotAnalysis.asCounted();
		}
		else {
			throw new UnsupportedOperationException();
		}
	}

	public int getSize(@NonNull EAttribute eAttribute, @NonNull EnumerationValue enumerationValue) {
		UserSlotAnalysis slotAnalysis = basicGetSlotAnalysis(eAttribute);
		if (slotAnalysis == null) {
			return 0;
		}
		if (slotAnalysis.isCounted()) {
			return slotAnalysis.asCounted();
		}
		else if (slotAnalysis.isEnumerated()) {
			return slotAnalysis.asEnumerated(enumerationValue);
		}
		else {
			throw new UnsupportedOperationException();
		}
	}

	public int getSize(@NonNull EReference eReference, @NonNull GrammarRuleVector grammarRuleVector) {
		UserSlotAnalysis slotAnalysis = basicGetSlotAnalysis(eReference);
		if (slotAnalysis == null) {
			return 0;
		}
		if (slotAnalysis.isCounted()) {
			return slotAnalysis.asCounted();
		}
		else if (slotAnalysis.isDiscriminated()) {
			return slotAnalysis.asDiscriminated(grammarRuleVector);
		}
		throw new UnsupportedOperationException();
	}

	public @NonNull UserSlotAnalysis getSlotAnalysis(@NonNull EStructuralFeature eStructuralFeature) {
		return SerializationUtils.nonNullState(eStructuralFeature2slotAnalysis.get(eStructuralFeature));
	}

	@Override
	public @NonNull String toString() {
		DiagnosticStringBuilder s = new SerializationMetaDataDiagnosticStringBuilder(serializationMetaData);
		toString(s, 0);
		return s.toString();
	}

	public void toString(@NonNull DiagnosticStringBuilder s, int depth) {
		s.append(getName());
		s.append(" - ");
		EClass eClass = eClassValue.getEClass();
		s.append(SerializationUtils.getName(SerializationUtils.getEPackage(eClass)));
		s.append("::");
		s.append(SerializationUtils.getName(eClass));
	//	boolean isMany = Iterables.size(serializationRules) > 1;
		for (@NonNull SerializationRule serializationRule : serializationRules) {
	//		if (isMany) {
			s.appendIndentation(depth+1);
	//		}
	//		else {
	//			s.append(" ");
	//		}
	//		s.append(serializationRule.getName());
	//		s.append(" - ");
		//	serializationRuleAnalysis.toRuleString(s);
			serializationRule.toMatchTermString(s, depth+2);
		}
//	}
//
//	public void toString(@NonNull StringBuilder s, int depth) {
//		s.append(eClass.getName());
	//	s.append("@");
	//	s.append(Integer.toHexString(System.identityHashCode(eObject)));
		s.append(": ");
		if (SerializationUtils.maybeNull(eStructuralFeature2slotAnalysis) != null) {
			List<@NonNull EStructuralFeature> keys  = new ArrayList<>(eStructuralFeature2slotAnalysis.keySet());
			Collections.sort(keys, SerializationUtils.ENAMED_ELEMENT_COMPARATOR);
			boolean isFirst = true;
			for (@NonNull EStructuralFeature key : keys) {
				if (!isFirst) {
					s.append(", ");
				}
				s.appendObject(key.getName());
				s.append("=");
				s.appendObject(eStructuralFeature2slotAnalysis.get(key));
				isFirst = false;
			}
		}

		for (@Nullable DynamicRuleMatch dynamicRuleMatch : dynamicRuleMatches) {
			if ((dynamicRuleMatch != null) && dynamicRuleMatch.matchFailed()) {
				s.append("\n\t");
				s.append(dynamicRuleMatch.getSerializationRule().toRuleString());
				String reasonString = dynamicRuleMatch.basicGetReasonString();
				if (reasonString != null) {
					s.append("\n\t\t");
					s.append(reasonString);
				}
			}
		}
	}
}