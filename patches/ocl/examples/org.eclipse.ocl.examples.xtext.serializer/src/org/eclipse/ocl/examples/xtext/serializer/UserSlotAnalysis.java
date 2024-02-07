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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.serializer.EnumerationValue.EnumerationValueAny;
import org.eclipse.ocl.examples.xtext.serializer.EnumerationValue.EnumerationValueOthers;

/**
 * A UserSlotAnalysis provides the actual run-time analysis of a particular user element slot.
 *
 * Derived classes implement distinct approach for counting slot content.
 */
public interface UserSlotAnalysis
{
	/**
	 * Return the number of slot elements for a CountedSlotAnalysis or throw an IllegalStateException otherwose.
	 */
	int asCounted();

	/**
	 * Return the number of grammarRuleVector slot elements for a DiscriminatedSlotAnalysis or throw an IllegalStateException otherwise.
	 */
	int asDiscriminated(@NonNull GrammarRuleVector grammarRuleVector);

	/**
	 * Return the number of enumerationValue slot elements for an EnmeratedSlotAnalysis or throw an IllegalStateException otherwise.
	 */
	int asEnumerated(@NonNull EnumerationValue enumerationValue);

	/**
	 * Return true if this is a CountedSlotAnalysis.
	 */
	boolean isCounted();

	/**
	 * Return true if this is an iscriminatedSlotAnalysis.
	 */
	boolean isDiscriminated();

	/**
	 * Return true if this is an EnmeratedSlotAnalysis.
	 */
	boolean isEnumerated();

	/**
	 * A CountedSlotAnalysis provides the default analysis of a slot of indeterminate compile-time content.
	 * The analysis provides a simple count of the actual number of slots.
	 */
	public static class CountedSlotAnalysis implements UserSlotAnalysis
	{
		private static final @NonNull CountedSlotAnalysis ZERO = new CountedSlotAnalysis(0);
		private static @NonNull CountedSlotAnalysis ONE = new CountedSlotAnalysis(1);

		public static @NonNull CountedSlotAnalysis valueOf(int value) {
			switch (value) {
				case 0: return ZERO;
				case 1: return ONE;
				default: return new CountedSlotAnalysis(value);
			}
		}

		protected final int count;

		private CountedSlotAnalysis(int count) {
			this.count = count;
		}

		@Override
		public int asCounted() {
			return count >= 0 ? count : 0;
		}

		@Override
		public int asDiscriminated(@NonNull GrammarRuleVector grammarRuleVector) {
			throw new IllegalStateException();
		}

		@Override
		public int asEnumerated(@NonNull EnumerationValue enumerationValue) {
			throw new IllegalStateException();
		}

		@Override
		public boolean isCounted() {
			return true;
		}

		@Override
		public boolean isDiscriminated() {
			return false;
		}

		@Override
		public boolean isEnumerated() {
			return false;
		}

		@Override
		public @NonNull String toString() {
			@SuppressWarnings("null")
			@NonNull String castString = Integer.toString(count);
			return castString;
		}
	}

	/**
	 * A DiscriminatedSlotAnalysis provides the analysis of a (typically many)-valued EReference slot
	 * whose EObject values are defined at compile-time by the grammar.
	 */
	public static class DiscriminatedSlotAnalysis implements UserSlotAnalysis
	{
		private final @NonNull Map<@NonNull GrammarRuleVector, @NonNull Integer> grammarRuleVector2count = new HashMap<>();

		public DiscriminatedSlotAnalysis(@NonNull SerializationMetaData serializationMetaData, @NonNull Iterable<@NonNull GrammarRuleVector> grammarRuleValues, @NonNull EObject eObject) {
			/* boolean gotOne =*/  analyzeEObject(serializationMetaData, grammarRuleValues, eObject, false);
		//	grammarRuleValue2count.put(EnumerationValueOthers.INSTANCE, gotOne ? 0 : 1);
		}

		public DiscriminatedSlotAnalysis(@NonNull SerializationMetaData serializationMetaData, @NonNull Iterable<@NonNull GrammarRuleVector> grammarRuleVectors, @NonNull Iterable<@NonNull EObject> eObjects) {
			/* int others = 0; */
			for (@NonNull EObject eObject : eObjects) {
				boolean gotOne = analyzeEObject(serializationMetaData, grammarRuleVectors, eObject, true);
				if (!gotOne) {
				//	others++;
				}
			}
		//	grammarRuleValue2count.put(EnumerationValueOthers.INSTANCE, others);
		}

		protected boolean analyzeEObject(@NonNull SerializationMetaData serializationMetaData, @NonNull Iterable<@NonNull GrammarRuleVector> grammarRuleVectors, @NonNull EObject eObject, boolean isMany) {
		//	@NonNull ParserRuleValue parserRuleValue = String.valueOf(value);
			boolean gotOne = false;
			EClass eClass = eObject.eClass();
			assert eClass != null;
			EClassValue eClassValue = serializationMetaData.getEClassValue(eClass);
			GrammarRuleVector eObjectGrammarRuleVector = new GrammarRuleVector();
			for (@NonNull SerializationRule serializationRule : eClassValue.getSerializationRules()) {
				eObjectGrammarRuleVector.set(serializationRule.getGrammarRuleValueIndex());
			}
			for (@NonNull GrammarRuleVector grammarRuleVector : grammarRuleVectors) {
				if (grammarRuleVector.testAny(eObjectGrammarRuleVector)) {
					Integer count = isMany ? SerializationUtils.maybeNull(grammarRuleVector2count.get(grammarRuleVector)) : null;
					grammarRuleVector2count.put(grammarRuleVector, (count == null) ? 1 : (count.intValue() + 1));
					gotOne = true;
				}
			}
			return gotOne;
		}

		@Override
		public int asCounted() {
			throw new IllegalStateException();
		}

		@Override
		public int asDiscriminated(@NonNull GrammarRuleVector grammarRuleVector) {
			Integer value = SerializationUtils.maybeNull(grammarRuleVector2count.get(grammarRuleVector));
			return value != null ? value.intValue() : 0;
		}

		@Override
		public int asEnumerated(@NonNull EnumerationValue enumerationValue) {
			throw new IllegalStateException();
		}

		@Override
		public boolean isCounted() {
			return false;
		}

		@Override
		public boolean isDiscriminated() {
			return true;
		}

		@Override
		public boolean isEnumerated() {
			return false;
		}

		@Override
		public @NonNull String toString() {
			StringBuilder s = new StringBuilder();
			List<@NonNull GrammarRuleVector> keys  = new ArrayList<>(grammarRuleVector2count.keySet());
			Collections.sort(keys);
			boolean isFirst = true;
			for (@NonNull GrammarRuleVector key : keys) {
				if (!isFirst) {
					s.append(",");
				}
				s.append(key);
				s.append("=");
				s.append(grammarRuleVector2count.get(key));
				isFirst = false;
			}
			@SuppressWarnings("null")
			@NonNull String castString = s.toString();
			return castString;
		}
	}

	/**
	 * An EnumeratedSlotAnalysis provides the analysis of a (typically many)-valued String EAttribute slot
	 * whose string values are defined at compile-time by the grammar. The String value therefore acts as an
	 * enumeration and is maintained as an EnumerationValue.
	 */
	public static class EnumeratedSlotAnalysis implements UserSlotAnalysis
	{
		private final @NonNull Map<@NonNull EnumerationValue, @NonNull Integer> enumerationValue2count = new HashMap<>();

		/**
		 * Analyze the optional value of an enumerated attribute to determine which of enumerationValues are present.
		 */
		public EnumeratedSlotAnalysis(@NonNull Iterable<@NonNull EnumerationValue> enumerationValues, @Nullable Object value) {
			assert value != null;
			boolean gotOne = analyzeValue(enumerationValues, value, false);
			enumerationValue2count.put(EnumerationValueOthers.INSTANCE, gotOne ? 0 : 1);
			enumerationValue2count.put(EnumerationValueAny.INSTANCE, value != null ? 1 : 0);
		}

		/**
		 * Analyze the many elements of an enumerated attribute to determine which of enumerationValues are present.
		 */
		public EnumeratedSlotAnalysis(@NonNull Iterable<@NonNull EnumerationValue> enumerationValues, @NonNull Iterable<?> elements) {
			int any = 0;
			int others = 0;
			for (Object element : elements) {
				boolean gotOne = analyzeValue(enumerationValues, element, true);
				if (!gotOne) {
					others++;
				}
				any++;
			}
			enumerationValue2count.put(EnumerationValueOthers.INSTANCE, others);
			enumerationValue2count.put(EnumerationValueAny.INSTANCE, any);
		}

		protected boolean analyzeValue(@NonNull Iterable<@NonNull EnumerationValue> enumerationValues, Object value, boolean isMany) {
			@SuppressWarnings("null") @NonNull String string = String.valueOf(value);
			boolean gotOne = false;
			for (@NonNull EnumerationValue enumerationValue : enumerationValues) {
				if (enumerationValue.isElement(string)) {
					Integer count = isMany ? SerializationUtils.maybeNull(enumerationValue2count.get(enumerationValue)) : null;
					enumerationValue2count.put(enumerationValue, (count == null) ? 1 : (count.intValue() + 1));
					gotOne = true;
				}
			}
			return gotOne;
		}

		@Override
		public int asCounted() {
			return SerializationUtils.nonNullState(enumerationValue2count.get(EnumerationValueAny.INSTANCE));
		}

		@Override
		public int asDiscriminated(@NonNull GrammarRuleVector grammarRuleVector) {
			throw new IllegalStateException();
		}

		@Override
		public int asEnumerated(@NonNull EnumerationValue enumerationValue) {
			Integer value = SerializationUtils.maybeNull(enumerationValue2count.get(enumerationValue));
			return value != null ? value.intValue() : 0;
		}

		@Override
		public boolean isCounted() {
			return false;
		}

		@Override
		public boolean isDiscriminated() {
			return false;
		}

		@Override
		public boolean isEnumerated() {
			return true;
		}

		@Override
		public @NonNull String toString() {
			StringBuilder s = new StringBuilder();
			List<@NonNull EnumerationValue> keys  = new ArrayList<>(enumerationValue2count.keySet());
			Collections.sort(keys, SerializationUtils.NAMEABLE_COMPARATOR);
			boolean isFirst = true;
			for (@NonNull EnumerationValue key : keys) {
				if (!isFirst) {
					s.append(",");
				}
				s.append(key);
				s.append("=");
				s.append(enumerationValue2count.get(key));
				isFirst = false;
			}
			@SuppressWarnings("null")
			@NonNull String castString = s.toString();
			return castString;
		}
	}
}