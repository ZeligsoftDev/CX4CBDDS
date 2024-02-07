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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.serializer.SerializationStep.SerializationStepKeyword;
import org.eclipse.xtext.AbstractElement;

/**
 * A derived SerializationMetaData is auto-generated to present the Xtext parsing grammar and Xtext formatting idioms
 * as a serialization grammar for use by the DeclarativeSerializer and DeclarativeFormatter.
 */
public interface SerializationMetaData
{
	public static interface Provider
	{
		@NonNull SerializationMetaData get();
	}

	/**
	 * Return the EClassValue for eClass or null if not available.
	 */
	@Nullable EClassValue basicGetEClassValue(@NonNull EClass eClass);

	@Nullable SerializationStep basicGetGlobalSerializationStepAssignment(@NonNull EStructuralFeature eStructuralFeature);

	/**
	 * Return the globally consistent serialization step for a keyword or null if not available.
	 */
	@Nullable SerializationStepKeyword basicGetGlobalSerializationStepKeyword(@NonNull String keyword);

	/**
	 * Return the serialization grammar rule artefact named by ruleName or null if unknown.
	 */
	@Nullable GrammarRuleValue basicGetGrammarRuleValue(@NonNull String ruleName);

	/**
	 * Return the EClassValue for eClass or throw an IllegalStateException if not available.
	 */
	@NonNull EClassValue getEClassValue(@NonNull EClass eClass);

	/**
	 * Return the serialization grammar rule artefact named by ruleName or throw an IllegalStateException if not available.
	 */
	@NonNull GrammarRuleValue getGrammarRuleValue(int ruleValueIndex);

	/**
	 * Return the serialization segments to format a grammarElement.
	 */
	@NonNull SerializationSegment @NonNull [] getInnerFormattingSegments(@NonNull AbstractElement grammarElement);

	/**
	 * Return the strings that may indent intermediate lines of multiple line comments corresponding to the
	 * {@link getMultipleLineCommentPrefixes(), @link getMultipleLineCommentSuffixes()}}.
	 *
	 * e.g " *" for the typical Java comment.
	 */
	@Nullable String @Nullable [] getMultipleLineCommentMidfixes();

	/**
	 * Return the strings that may introduce multiple line comments corresponding to the
	 * {@link getMultipleLineCommentSuffixes()}
	 */
	@NonNull String @Nullable [] getMultipleLineCommentPrefixes();

	/**
	 * Return the strings that may terminate multiple line comments corresponding to the
	 * {@link getMultipleLineCommentPrefixes()}
	 */
	@NonNull String @Nullable [] getMultipleLineCommentSuffixes();

	/**
	 * Return the serialization segments to format a group of grammarElement.
	 */
	@NonNull SerializationSegment @NonNull [] getOuterFormattingSegments(@NonNull AbstractElement grammarElement);

	/**
	 * Return the strings that may introduce single line comments..
	 */
	@NonNull String @Nullable [] getSingleLineCommentPrefixes();
}
