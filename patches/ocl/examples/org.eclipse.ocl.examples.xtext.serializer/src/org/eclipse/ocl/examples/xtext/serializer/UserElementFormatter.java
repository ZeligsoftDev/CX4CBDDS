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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.INode;

/**
 * A Serializer supports the serialization of a user model element, automatically creating a hierarchy
 * of Serializers for the containment herarchy of the user model element.
 */
public class UserElementFormatter
{
	protected final @NonNull INode node;
	protected final @NonNull AbstractElement compoundedGrammarElement;
	protected final @NonNull UserModelAnalysis modelAnalysis;
	protected final @NonNull EObject element;

	public UserElementFormatter(@NonNull INode node, @NonNull AbstractElement compoundedGrammarElement, @NonNull UserModelAnalysis modelAnalysis, @NonNull EObject element) {
		this.node = node;
		this.compoundedGrammarElement = compoundedGrammarElement;
		this.modelAnalysis = modelAnalysis;
		this.element = element;
	}

	public @NonNull EObject getElement() {
		return element;
	}

	public @NonNull SerializationSegment @NonNull [] getInnerFormattingSegments() {
		return modelAnalysis.getSerializationMetaData().getInnerFormattingSegments(compoundedGrammarElement);
	}

	public @NonNull INode getNode() {
		return node;
	}

//	public @NonNull UserModelAnalysis getModelAnalysis() {
//		return modelAnalysis;
//	}

	public @NonNull SerializationSegment @NonNull [] getOuterFormattingSegments() {
		return modelAnalysis.getSerializationMetaData().getOuterFormattingSegments(compoundedGrammarElement);
	}

	public @NonNull SerializationSegment @NonNull [] getRuleFormattingSegments() {
		ParserRule parserRule = GrammarUtil.containingParserRule(compoundedGrammarElement);
		AbstractElement rootGrammarElement = parserRule.getAlternatives();
		assert rootGrammarElement !=  null;
		return modelAnalysis.getSerializationMetaData().getInnerFormattingSegments(rootGrammarElement);
	}

	public @NonNull SerializationMetaData getSerializationMetaData() {
		return modelAnalysis.getSerializationMetaData();
	}
}