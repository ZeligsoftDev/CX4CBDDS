/*******************************************************************************
 * Copyright (c) 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.serializer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * DiagnosticStringBuilder enables diagnostics to translate SerializationMetaData integer indexes to meaningful strings.
 *
 * The default implementation renders indexes as numbers. Derived implementations
 * may override {@link appendRuleName(int ruleValueIndex)} to provide string rendering.
 */
public class DiagnosticStringBuilder
{
	public static class SerializationMetaDataDiagnosticStringBuilder extends DiagnosticStringBuilder
	{
		protected final @NonNull SerializationMetaData serializationMetaData;

		public SerializationMetaDataDiagnosticStringBuilder(@NonNull SerializationMetaData serializationMetaData) {
			this.serializationMetaData = serializationMetaData;
		}

		@Override
		public void appendRuleName(int ruleValueIndex) {
			GrammarRuleValue grammarRuleValue = serializationMetaData.getGrammarRuleValue(ruleValueIndex);
			s.append(grammarRuleValue.getName());
		}
	}

	public static class DiagnosticStringBuilderWithHelper extends DiagnosticStringBuilder
	{
		protected final @NonNull SerializationRuleHelper helper;

		public DiagnosticStringBuilderWithHelper(@Nullable SerializationRuleHelper helper) {
			assert helper != null;
			this.helper = helper;
		}

		@Override
		public void appendRuleName(int ruleValueIndex) {
			GrammarRuleValue grammarRuleValue = helper.getGrammarRuleValue(ruleValueIndex);
			s.append(grammarRuleValue.getName());
		}
	}

	protected final @NonNull StringBuilder s;

	public DiagnosticStringBuilder() {
		this.s = new StringBuilder();
	}

	public DiagnosticStringBuilder(@NonNull StringBuilder s) {
		this.s = s;
	}

	public void append(char c) {
		s.append(c);
	}

	public void append(@NonNull String string) {
		s.append(string);
	}

	public void appendEStructuralFeatureName(@NonNull EClass eFeatureScope, @NonNull EStructuralFeature eStructuralFeature) {
		s.append(SerializationUtils.getName(eStructuralFeature));
	}

	public void appendIndentation(int depth) {
		SerializationUtils.appendIndentation(s, depth);
	}

	public void appendObject(@Nullable Object object) {
		String toString = object != null ? object.toString() : null;
		s.append(toString);
	}

	public void appendRuleName(int ruleValueIndex) {
		s.append(ruleValueIndex);
	}

	public void appendVariableName(int variableIndex) {
		s.append("V");
		s.append(variableIndex);
	}

	public void appendWithFormat(@NonNull String format, Object ... args) {
		s.append(String.format(format, args));
	}

	public @NonNull StringBuilder getStringBuilder() {
		return s;
	}

	@Override
	public @NonNull String toString() {
		@SuppressWarnings("null")
		@NonNull String castString = s.toString();
		return castString;
	}
}
