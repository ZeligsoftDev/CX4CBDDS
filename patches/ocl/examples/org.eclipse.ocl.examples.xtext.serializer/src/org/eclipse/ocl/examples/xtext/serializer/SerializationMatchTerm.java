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
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A SerializationMatchTerm defines the behaviour of SerializationMetaData nodes in an expression tree
 * that provides the limited capability to compute the cardinalities of SerializationRule terms from the
 * actual feature slot sizes of an actual element to be serialized.
 *
 * SerializationMatchTerm implements equals/hashCode so that the SerializationMetaData can share singletons.
 */
public abstract class SerializationMatchTerm
{
	/**
	 * SerializationMatchTermAbstractBinary provides the common functionality of binary expression terms
	 * such as Add/Multiply.
	 */
	public abstract static class SerializationMatchTermAbstractBinary extends SerializationMatchTerm
	{
		protected final @NonNull SerializationMatchTerm left;
		protected final @NonNull SerializationMatchTerm right;
		private @Nullable Set<@NonNull SerializationMatchTerm> childClosure = null;

		public SerializationMatchTermAbstractBinary(@NonNull SerializationMatchTerm left, @NonNull SerializationMatchTerm right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int computeHashCode() {
			return getClass().hashCode() + 3 * left.hashCode() + 7 * right.hashCode();
		}

		@Override
		public @NonNull Set<@NonNull SerializationMatchTerm> getChildClosure() {
			Set<@NonNull SerializationMatchTerm> childClosure2 = childClosure;
			if (childClosure2 == null) {
				childClosure = childClosure2 = new HashSet<>();
				childClosure2.add(this);
				childClosure2.addAll(left.getChildClosure());
				childClosure2.addAll(right.getChildClosure());
			}
			return childClosure2;
		}

		public @NonNull SerializationMatchTerm getLeft() {
			return left;
		}

		public @NonNull SerializationMatchTerm getRight() {
			return right;
		}

		@Override
		public boolean isConstant(@NonNull DynamicRuleMatch ruleMatch) {
			return left.isConstant(ruleMatch) && right.isConstant(ruleMatch);
		}

		@Override
		public boolean isKnown(@NonNull DynamicRuleMatch ruleMatch) {
			return left.isKnown(ruleMatch) && right.isKnown(ruleMatch);
		}
	}

	/**
	 * SerializationMatchTermAdd provides the functionality to add two terms.
	 */
	public static class SerializationMatchTermAdd extends SerializationMatchTermAbstractBinary
	{
		public SerializationMatchTermAdd(@NonNull SerializationMatchTerm left, @NonNull SerializationMatchTerm right) {
			super(left, right);
		}

		@Override
		public @Nullable Integer basicGetIntegerSolution(@NonNull RuleMatch ruleMatch) {
			Integer intLeft = left.basicGetIntegerSolution(ruleMatch);
			if (intLeft == null) {
				return null;
			}
			Integer intRight = right.basicGetIntegerSolution(ruleMatch);
			if (intRight == null) {
				return null;
			}
			return intLeft + intRight;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof SerializationMatchTermAdd)) {
				return false;
			}
			SerializationMatchTermAdd that = (SerializationMatchTermAdd) obj;
			if (!this.left.equals(that.left)) return false;
			if (!this.right.equals(that.right)) return false;
			return true;
		}

		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("(");
			left.toString(s);
			s.append(" + ");
			right.toString(s);
			s.append(")");
		}
	}

	/**
	 * SerializationMatchTermDivide provides the functionality to divide a first term by a second.
	 */
	public static class SerializationMatchTermDivide extends SerializationMatchTermAbstractBinary
	{
		public SerializationMatchTermDivide(@NonNull SerializationMatchTerm left, @NonNull SerializationMatchTerm right) {
			super(left, right);
		}

		@Override
		public @Nullable Integer basicGetIntegerSolution(@NonNull RuleMatch ruleMatch) {
			Integer intRight = right.basicGetIntegerSolution(ruleMatch);
			if ((intRight == null) || (intRight == 0)) {
				return null;
			}
			Integer intLeft = left.basicGetIntegerSolution(ruleMatch);
			if (intLeft == null) {
				return null;
			}
			int result = Math.floorDiv(intLeft, intRight);
			if (result * intRight != intLeft) {
				return null;
			}
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof SerializationMatchTermDivide)) {
				return false;
			}
			SerializationMatchTermDivide that = (SerializationMatchTermDivide) obj;
			if (!this.left.equals(that.left)) return false;
			if (!this.right.equals(that.right)) return false;
			return true;
		}
		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("(");
			left.toString(s);
			s.append(" / ");
			right.toString(s);
			s.append(")");
		}
	}

	/**
	 * A SerializationMatchTermEAttributeSize contributes the actual (constant) number of String-valued attribute
	 * slot elements that match one of a specified set of known String values.
	 */
	public static class SerializationMatchTermEAttributeSize extends SerializationMatchTerm
	{
		protected final @NonNull EAttribute eAttribute;
		protected final @NonNull EnumerationValue enumerationValue;

		public SerializationMatchTermEAttributeSize(@NonNull EAttribute eAttribute, @NonNull EnumerationValue enumerationValue) {
			this.eAttribute = eAttribute;
			this.enumerationValue = enumerationValue;
		}

		@Override
		public @Nullable Integer basicGetIntegerSolution(@NonNull RuleMatch ruleMatch) {
			return ruleMatch.getSize(eAttribute, enumerationValue);
		}

		@Override
		public int computeHashCode() {
			return getClass().hashCode() + 3 * eAttribute.hashCode() + 7 * enumerationValue.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof SerializationMatchTermEAttributeSize)) {
				return false;
			}
			SerializationMatchTermEAttributeSize that = (SerializationMatchTermEAttributeSize) obj;
			if (this.eAttribute != that.eAttribute) return false;
			if (!this.enumerationValue.equals(that.enumerationValue)) return false;
			return true;
		}

		public @NonNull EAttribute getEAttribute() {
			return eAttribute;
		}

		public @NonNull EnumerationValue getEnumerationValue() {
			return enumerationValue;
		}

		@Override
		public boolean isConstant(@NonNull DynamicRuleMatch ruleMatch) {
			return false;
		}

		@Override
		public boolean isKnown(@NonNull DynamicRuleMatch ruleMatch) {
			return true;
		}

		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("|");
			s.append(SerializationUtils.getName(SerializationUtils.getEContainingClass(eAttribute)));
			s.append("::");
			s.append(SerializationUtils.getName(eAttribute));
			s.append(".'");
			s.append(enumerationValue.getName());
			s.append("'|");
		}
	}

	/**
	 * A SerializationMatchTermEReferenceSize contributes the actual (constant) number of contained/referenced
	 * slot elements that are able to be generated by one of a specified set of parser rules.
	 */
	public static class SerializationMatchTermEReferenceSize extends SerializationMatchTerm
	{
		protected final @NonNull EReference eReference;
		protected final @NonNull GrammarRuleVector grammarRuleVector;

		public SerializationMatchTermEReferenceSize(@NonNull EReference eReference, @NonNull GrammarRuleVector grammarRuleVector) {
			this.eReference = eReference;
			this.grammarRuleVector = grammarRuleVector;
		}

		@Override
		public @Nullable Integer basicGetIntegerSolution(@NonNull RuleMatch ruleMatch) {
			return ruleMatch.getSize(eReference, grammarRuleVector);
		}

		@Override
		public int computeHashCode() {
			return getClass().hashCode() + 3 * eReference.hashCode() + 7 * grammarRuleVector.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof SerializationMatchTermEReferenceSize)) {
				return false;
			}
			SerializationMatchTermEReferenceSize that = (SerializationMatchTermEReferenceSize) obj;
			if (this.eReference != that.eReference) return false;
			if (!this.grammarRuleVector.equals(that.grammarRuleVector)) return false;
			return true;
		}

		public @NonNull EReference getEReference() {
			return eReference;
		}

		public @NonNull GrammarRuleVector getGrammarRuleVector() {
			return grammarRuleVector;
		}

		@Override
		public boolean isConstant(@NonNull DynamicRuleMatch ruleMatch) {
			return false;
		}

		@Override
		public boolean isKnown(@NonNull DynamicRuleMatch ruleMatch) {
			return true;
		}

		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("|");
			s.append(SerializationUtils.getName(SerializationUtils.getEContainingClass(eReference)));
			s.append("::");
			s.append(SerializationUtils.getName(eReference));
			s.append(":{");
			grammarRuleVector.toString(s);
			s.append("}|");
		}
	}

	/**
	 * A SerializationMatchTermEStructuralFeatureSize contributes the actual (constant) size of an EList-valued slot or 1/0 for
	 * an optional slot when determining the cardinality of a SerializationRule term.
	 */
	public static class SerializationMatchTermEStructuralFeatureSize extends SerializationMatchTerm
	{
		protected final @NonNull EStructuralFeature eStructuralFeature;

		public SerializationMatchTermEStructuralFeatureSize(@NonNull EStructuralFeature eStructuralFeature) {
			assert eStructuralFeature != null;
			this.eStructuralFeature = eStructuralFeature;
		}

		@Override
		public @Nullable Integer basicGetIntegerSolution(@NonNull RuleMatch ruleMatch) {
			return ruleMatch.getSize(eStructuralFeature);
		}

		@Override
		public int computeHashCode() {
			return getClass().hashCode() + 3 * eStructuralFeature.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof SerializationMatchTermEStructuralFeatureSize)) {
				return false;
			}
			SerializationMatchTermEStructuralFeatureSize that = (SerializationMatchTermEStructuralFeatureSize)obj;
			if (this.eStructuralFeature != that.eStructuralFeature) return false;
			return true;
		}

		public @NonNull EStructuralFeature getEStructuralFeature() {
			return eStructuralFeature;
		}

		@Override
		public boolean isConstant(@NonNull DynamicRuleMatch ruleMatch) {
			return false;
		}

		@Override
		public boolean isKnown(@NonNull DynamicRuleMatch ruleMatch) {
			return true;
		}

		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("|");
			s.append(SerializationUtils.getName(SerializationUtils.getEContainingClass(eStructuralFeature)));
			s.append("::");
			s.append(SerializationUtils.getName(eStructuralFeature));
			s.append("|");
		}
	}

	/**
	 * SerializationMatchTermGreaterThan provides the functionality to compare a first term with a second.
	 * Its value is 1 if greater than or equal to or 0 if less than.
	 */
	public static class SerializationMatchTermGreaterThan extends SerializationMatchTermAbstractBinary
	{
		public SerializationMatchTermGreaterThan(@NonNull SerializationMatchTerm left, @NonNull SerializationMatchTerm right) {
			super(left, right);
		}

		@Override
		public @Nullable Integer basicGetIntegerSolution(@NonNull RuleMatch ruleMatch) {
			Integer intLeft = left.basicGetIntegerSolution(ruleMatch);
			if (intLeft == null) {
				return null;
			}
			Integer intRight = right.basicGetIntegerSolution(ruleMatch);
			if (intRight == null) {
				return null;
			}
			return intLeft > intRight ? 1 : 0;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof SerializationMatchTermGreaterThan)) {
				return false;
			}
			SerializationMatchTermGreaterThan that = (SerializationMatchTermGreaterThan) obj;
			if (!this.left.equals(that.left)) return false;
			if (!this.right.equals(that.right)) return false;
			return true;
		}

		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("(");
			left.toString(s);
			s.append(" > ");
			right.toString(s);
			s.append(")");
		}
	}

	/**
	 * SerializationMatchTermInteger provides the functionality og a term with a literal integer value.
	 */
	public static class SerializationMatchTermInteger extends SerializationMatchTerm
	{
		protected final int value;

		public SerializationMatchTermInteger(int value) {
			this.value = value;
		}

		@Override
		public int computeHashCode() {
			return getClass().hashCode() + value;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof SerializationMatchTermInteger)) {
				return false;
			}
			SerializationMatchTermInteger that = (SerializationMatchTermInteger) obj;
			if (this.value != that.value) return false;
			return true;
		}

		@Override
		public @NonNull Integer basicGetIntegerSolution(@NonNull RuleMatch ruleMatch) {
			return value;
		}

		public int getValue() {
			return value;
		}

		@Override
		public boolean isConstant(@NonNull DynamicRuleMatch ruleMatch) {
			return true;
		}

		@Override
		public boolean isKnown(@NonNull DynamicRuleMatch ruleMatch) {
			return true;
		}

		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			String string = Integer.toString(value);
			assert string != null;
			s.append(string);
		}
	}

	/**
	 * SerializationMatchTermMultiply provides the functionality to multiply two terms.
	 */
	public static class SerializationMatchTermMultiply extends SerializationMatchTermAbstractBinary
	{
		public SerializationMatchTermMultiply(@NonNull SerializationMatchTerm left, @NonNull SerializationMatchTerm right) {
			super(left, right);
		}

		@Override
		public @Nullable Integer basicGetIntegerSolution(@NonNull RuleMatch ruleMatch) {
			Integer intRight = right.basicGetIntegerSolution(ruleMatch);
			if ((intRight == null) || (intRight == 0)) {
				return null;
			}
			Integer intLeft = left.basicGetIntegerSolution(ruleMatch);
			if (intLeft == null) {
				return null;
			}
			return intLeft * intRight;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof SerializationMatchTermMultiply)) {
				return false;
			}
			SerializationMatchTermMultiply that = (SerializationMatchTermMultiply) obj;
			if (!this.left.equals(that.left)) return false;
			if (!this.right.equals(that.right)) return false;
			return true;
		}
		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("(");
			left.toString(s);
			s.append(" * ");
			right.toString(s);
			s.append(")");
		}
	}

	/**
	 * SerializationMatchTermSubtract provides the functionality to subtract a second term from a first.
	 */
	public static class SerializationMatchTermSubtract extends SerializationMatchTermAbstractBinary
	{
		public SerializationMatchTermSubtract(@NonNull SerializationMatchTerm left, @NonNull SerializationMatchTerm right) {
			super(left, right);
		}

		@Override
		public @Nullable Integer basicGetIntegerSolution(@NonNull RuleMatch ruleMatch) {
			Integer intLeft = left.basicGetIntegerSolution(ruleMatch);
			if (intLeft == null) {
				return null;
			}
			Integer intRight = right.basicGetIntegerSolution(ruleMatch);
			if (intRight == null) {
				return null;
			}
			return intLeft - intRight;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof SerializationMatchTermSubtract)) {
				return false;
			}
			SerializationMatchTermSubtract that = (SerializationMatchTermSubtract) obj;
			if (!this.left.equals(that.left)) return false;
			if (!this.right.equals(that.right)) return false;
			return true;
		}

		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("(");
			left.toString(s);
			s.append(" - ");
			right.toString(s);
			s.append(")");
		}
	}

	/**
	 * A SerializationMatchTermUnsupported is a place holder used to loclize the problem the anlysis has failed.
	 * Hopefully the resifual result may assist in de ugging,
	 */
	public static class SerializationMatchTermUnsupported extends SerializationMatchTerm
	{
		public SerializationMatchTermUnsupported() {}

		@Override
		public int computeHashCode() {
			return getClass().hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof SerializationMatchTermUnsupported)) {
				return false;
			}
			return true;
		}

		@Override
		public boolean isConstant(@NonNull DynamicRuleMatch ruleMatch) {
			return false;
		}

		@Override
		public boolean isKnown(@NonNull DynamicRuleMatch ruleMatch) {
			return false;
		}

		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("?");
		}
	}

	/**
	 * A SerializationMatchTermVariable contributes the already computed value of a cardinality variable to an
	 * expression determining the cardinality of a SerializationRule term.
	 */
	public static class SerializationMatchTermVariable extends SerializationMatchTerm
	{
		protected final int cardinalityVariableIndex;

		public SerializationMatchTermVariable(int cardinalityVariableIndex) {
			this.cardinalityVariableIndex = cardinalityVariableIndex;
		}

		@Override
		public @Nullable Integer basicGetIntegerSolution(@NonNull RuleMatch ruleMatch) {
			return ruleMatch.basicGetIntegerSolution(cardinalityVariableIndex);
		}

		@Override
		public int computeHashCode() {
			return getClass().hashCode() + 3 * cardinalityVariableIndex;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof SerializationMatchTermVariable)) {
				return false;
			}
			SerializationMatchTermVariable that = (SerializationMatchTermVariable) obj;
			return this.cardinalityVariableIndex == that.cardinalityVariableIndex;
		}

		public int getVariableIndex() {
			return cardinalityVariableIndex;
		}

		@Override
		public boolean isConstant(@NonNull DynamicRuleMatch ruleMatch) {
			return false;
		}

		@Override
		public boolean isKnown(@NonNull DynamicRuleMatch ruleMatch) {
			return false;
		}

//		@Override
//		public boolean isOptional() {
//			return cardinalityVariable.mayBeNone() && !cardinalityVariable.mayBeMany();
//		}

		@Override
		public void toString(@NonNull DiagnosticStringBuilder s) {
			s.append("V" + cardinalityVariableIndex);
		}
	}

	/**
	 * The hashCode - null until lazily evaluated by {@link computeHashCode()}.
	 */
	private @Nullable Integer hashCode = null;

	/**
	 * Return the value of the expression value using the actual characteristic of the user element slots if available.
	 * Returns null if evaluation fails.
	 */
	public @Nullable Integer basicGetIntegerSolution(@NonNull RuleMatch ruleMatch) {
		return null;
	}

	/**
	 * Compute the hashCode for caching by {@link hashCode()}. Derived classes must override.
	 * @return
	 */
	protected abstract int computeHashCode();

	// Force derived classes to override.
	@Override
	public abstract boolean equals(Object obj);

	/**
	 * Return the closure of this and all child solutions.
	 */
	public @NonNull Set<@NonNull SerializationMatchTerm> getChildClosure() {
		@SuppressWarnings("null")
		@NonNull Set<@NonNull SerializationMatchTerm> singleton = Collections.singleton(this);
		return singleton;
	}

	/**
	 * The hashCode is lazily computed by  and cached.
	 */
	@Override
	public final int hashCode() {
		Integer hashCode2 = hashCode;
		if (hashCode2 == null) {
			hashCode = hashCode2 = computeHashCode();
		}
		return hashCode2.intValue();
	}

	/**
	 * Return true if this is a foldable constant value at compile time.
	 * i.e an expression transitively involving integer literals.
	 */
	public abstract boolean isConstant(@NonNull DynamicRuleMatch ruleMatch);

	/**
	 * Return true if this will be a known constant value at run time.
	 * i.e. an expression transitively involving integer literals and actual feature slot sizes.
	 */
	public abstract boolean isKnown(@NonNull DynamicRuleMatch ruleMatch);

	/**
	 *  Overridden to redirect to {@link toString(@NonNull DiagnosticStringBuilder)}.
	 */
	@Override
	public @NonNull String toString() {
		DiagnosticStringBuilder s = new DiagnosticStringBuilder();
		toString(s);
		@NonNull String castString = s.toString();
		return castString;
	}

	/**
	 * Append a readble representatio of this object to a DiagnosticStringBuilder.
	 */
	public abstract void toString(@NonNull DiagnosticStringBuilder s);
}
