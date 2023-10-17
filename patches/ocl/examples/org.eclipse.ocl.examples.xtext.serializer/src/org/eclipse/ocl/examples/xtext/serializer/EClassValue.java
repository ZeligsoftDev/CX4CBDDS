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
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class EClassValue implements Nameable
{
	/**
	 * EReference_TargetGrammarRuleVector identifies the possible rules that may prpdce a satisfactory type as the
	 * target of an EReference.
	 */
	public static class EReference_TargetGrammarRuleVector implements Nameable
	{
		protected final @NonNull EReference eReference;
		protected final @NonNull GrammarRuleVector targetGrammarRuleVector;

		public EReference_TargetGrammarRuleVector(/*@NonNull*/ EReference eReference, @NonNull GrammarRuleVector targetGrammarRuleVector) {
			assert eReference != null;
			this.eReference = eReference;
			this.targetGrammarRuleVector = targetGrammarRuleVector;
		}

		public @NonNull EReference getEReference() {
			return eReference;
		}

		@Override
		public @NonNull String getName() {
			return SerializationUtils.getName(eReference);
		}

		public @NonNull GrammarRuleVector getTargetGrammarRuleVector() {
			return targetGrammarRuleVector;
		}

		@Override
		public @NonNull String toString() {
			return eReference.getEContainingClass().getName() + "::" + eReference.getName() + " " + targetGrammarRuleVector;
		}
	}

	protected final @NonNull EClass eClass;
	protected final @NonNull SerializationRule @NonNull [] serializationRules;
	protected final @NonNull EReference_TargetGrammarRuleVector @Nullable [] eReferenceRuleIndexes;

	public EClassValue(/*@NonNull*/ EClass eClass, @NonNull SerializationRule @NonNull [] serializationRules,
			@NonNull EReference_TargetGrammarRuleVector @Nullable [] eReferenceRuleIndexes) {
		assert eClass != null;
		this.eClass = eClass;
		this.serializationRules = serializationRules;
		this.eReferenceRuleIndexes = eReferenceRuleIndexes;
	}

	public @NonNull EReference_TargetGrammarRuleVector @Nullable [] basicGetEReferenceRuleIndexes() {
		return eReferenceRuleIndexes;
	}

	public @NonNull SerializationRule @NonNull [] createDynamicSerializationRules(@Nullable GrammarRuleVector targetRuleValueIndexes) {
		if (targetRuleValueIndexes == null)  {
			return serializationRules;
		}
		List<@NonNull SerializationRule> newSerializationRules = new ArrayList<>();
		for (@NonNull SerializationRule serializationRule : serializationRules) {
			int ruleValueIndex = serializationRule.getGrammarRuleValueIndex();
			if (targetRuleValueIndexes.test(ruleValueIndex)) {
				newSerializationRules.add(serializationRule);
			}
		}
		@NonNull SerializationRule @NonNull [] newEmptyArray = new @NonNull SerializationRule @NonNull [newSerializationRules.size()];
		@SuppressWarnings("null")
		@NonNull SerializationRule @NonNull [] newFullArray = newSerializationRules.toArray(newEmptyArray);
		return newFullArray;
	}

	/**
	 * Return the rule analyses assigned by one or more of the serialization rules that can assign eContainmentFeature.
	 */
	public @Nullable GrammarRuleVector getAssignedTargetRuleValues(@NonNull EReference eContainmentFeature) {
		if (eReferenceRuleIndexes != null) {
			for (@NonNull EReference_TargetGrammarRuleVector eReferenceRuleIndex : eReferenceRuleIndexes) {
				if (eReferenceRuleIndex.getEReference() == eContainmentFeature) {
					return eReferenceRuleIndex.getTargetGrammarRuleVector();
				}
			}
		}
		return null;
	}

	public @NonNull EClass getEClass() {
		return eClass;
	}

	@Override
	public @NonNull String getName() {
		return SerializationUtils.getName(eClass);
	}

	public @NonNull SerializationRule @NonNull [] getSerializationRules() {
		return serializationRules;
	}

	@Override
	public @NonNull String toString() {
		return getName();
	}

	public void toString(@NonNull DiagnosticStringBuilder s, int depth) {
		s.appendObject(SerializationUtils.getName(SerializationUtils.getEPackage(eClass)));
		s.append("::");;
		s.appendObject(SerializationUtils.getName(eClass));
		s.append(" <=>");;
		s.appendObject(SerializationUtils.getName(SerializationUtils.getEPackage(eClass)));
		s.append("::");
		s.appendObject(SerializationUtils.getName(eClass));
		for (@NonNull SerializationRule serializationRule : serializationRules) {
			s.appendIndentation(depth+1);
			serializationRule.toMatchTermString(s, depth+2);
		}
	}
}