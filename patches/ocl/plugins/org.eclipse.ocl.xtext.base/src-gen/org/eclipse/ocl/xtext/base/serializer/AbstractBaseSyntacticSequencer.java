/*******************************************************************************
 * Copyright (c) 2011, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public abstract class AbstractBaseSyntacticSequencer extends AbstractSyntacticSequencer {

	protected BaseGrammarAccess grammarAccess;
	protected AbstractElementAlias match_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q;

	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (BaseGrammarAccess) access;
		match_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
	}

	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}


	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q.equals(syntax))
				emit_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '|?'?
	 *
	 * This ambiguous syntax occurs at:
	 *     lowerBound=LOWER (ambiguity) ']' (rule end)
	 *     stringBounds='*' (ambiguity) ']' (rule end)
	 *     stringBounds='+' (ambiguity) ']' (rule end)
	 *     stringBounds='?' (ambiguity) ']' (rule end)
	 *     upperBound=UPPER (ambiguity) ']' (rule end)

	 * </pre>
	 */
	protected void emit_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

}
