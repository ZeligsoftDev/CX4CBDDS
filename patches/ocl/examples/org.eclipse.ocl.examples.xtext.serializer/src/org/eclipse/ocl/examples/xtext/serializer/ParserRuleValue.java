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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class ParserRuleValue extends GrammarRuleValue
{
	protected final @Nullable GrammarRuleVector subParserRuleValueIndexes;	// Includes this if non-null
	protected final @NonNull SerializationRule @NonNull [] serializationRules;

	/**
	 * The outer segments to format each group of grammar element
	 */
	protected final @NonNull SerializationSegment @NonNull [] @NonNull [] outerFormattingSegments;	// FIXME only needed transiently

	/**
	 * The inner segments to format each individual grammar element
	 */
	protected final @NonNull SerializationSegment @NonNull [] @NonNull [] innerFormattingSegments;	// FIXME only needed transiently

	public ParserRuleValue(int ruleIndex, @NonNull String name, @NonNull SerializationRule @NonNull [] serializationRules,
			@NonNull SerializationSegment @NonNull [] @NonNull [] outerFormattingSegments,
			@NonNull SerializationSegment @NonNull [] @NonNull [] innerFormattingSegments,
			@Nullable GrammarRuleVector subParserRuleValueIndexes) {
		super(ruleIndex, name);
		this.subParserRuleValueIndexes = subParserRuleValueIndexes;
		this.serializationRules = serializationRules;
		this.outerFormattingSegments = outerFormattingSegments;
		this.innerFormattingSegments = innerFormattingSegments;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ParserRuleValue)) {
			return false;
		}
		ParserRuleValue that = (ParserRuleValue)obj;
		return (this.ruleIndex == that.ruleIndex) && this.name.equals(that.name) && SerializationUtils.safeEquals(this.subParserRuleValueIndexes, that.subParserRuleValueIndexes);
	}

	public @NonNull SerializationSegment @NonNull []  @NonNull [] getInnerFormattingSegments() {
		return innerFormattingSegments;
	}

	public @NonNull SerializationSegment @NonNull [] @NonNull [] getOuterFormattingSegments() {
		return outerFormattingSegments;
	}

	public @NonNull SerializationRule @NonNull[] getSerializationRules() {
		return serializationRules;
	}

	public @Nullable GrammarRuleVector getSubParserRuleValueIndexes() {
		return subParserRuleValueIndexes;
	}

	public boolean subParserRuleValueClosureContains(int ruleValueIndex) {
		return (subParserRuleValueIndexes != null) ? subParserRuleValueIndexes.test(ruleValueIndex) : ruleValueIndex == ruleIndex;
	}
}