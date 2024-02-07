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

/**
 * SerializationRuleHelper enables the SerializationRuleAnalysis-bland SerializationRule to use its
 * originating SerializationRuleAnalysis to contribute informative comments to the SerializationMetaData.
 */
public interface SerializationRuleHelper
{
	GrammarRuleValue getGrammarRuleValue(int ruleValueIndex);

//	void toMatchTermString(@NonNull DiagnosticStringBuilder s, int depth);

//	void toRuleString(@NonNull DiagnosticStringBuilder s);

//	void toString(@NonNull DiagnosticStringBuilder s, int depth);
}