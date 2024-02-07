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
package org.eclipse.ocl.xtext.essentialocl.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public abstract class AbstractEssentialOCLSyntacticSequencer extends AbstractSyntacticSequencer {

	protected EssentialOCLGrammarAccess grammarAccess;
	protected AbstractElementAlias match_MapLiteralPartCS_LessThanSignHyphenMinusKeyword_1_1_or_WithKeyword_1_0;
	protected AbstractElementAlias match_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q;
	protected AbstractElementAlias match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_0_0_1_or_WithKeyword_0_1_0_0_0;
	protected AbstractElementAlias match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_1_2_0_1_or_WithKeyword_0_1_1_2_0_0;
	protected AbstractElementAlias match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_2_1_0_1_or_WithKeyword_0_1_2_1_0_0;
	protected AbstractElementAlias match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_0_0_1_or_WithKeyword_2_0_0_0;
	protected AbstractElementAlias match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_1_2_0_1_or_WithKeyword_2_1_2_0_0;
	protected AbstractElementAlias match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_2_1_0_1_or_WithKeyword_2_2_1_0_0;
	protected AbstractElementAlias match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q;

	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (EssentialOCLGrammarAccess) access;
		match_MapLiteralPartCS_LessThanSignHyphenMinusKeyword_1_1_or_WithKeyword_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getMapLiteralPartCSAccess().getWithKeyword_1_0()));
		match_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
		match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_0_0_1_or_WithKeyword_0_1_0_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_0_0_1()), new TokenAlias(false, false, grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_0_0_0()));
		match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_1_2_0_1_or_WithKeyword_0_1_1_2_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_1_2_0_1()), new TokenAlias(false, false, grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_1_2_0_0()));
		match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_2_1_0_1_or_WithKeyword_0_1_2_1_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_2_1_0_1()), new TokenAlias(false, false, grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_2_1_0_0()));
		match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_0_0_1_or_WithKeyword_2_0_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_0_0_1()), new TokenAlias(false, false, grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_0_0_0()));
		match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_1_2_0_1_or_WithKeyword_2_1_2_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_1_2_0_1()), new TokenAlias(false, false, grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_1_2_0_0()));
		match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_2_1_0_1_or_WithKeyword_2_2_1_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_2_1_0_1()), new TokenAlias(false, false, grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_2_1_0_0()));
		match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2()));
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
			if (match_MapLiteralPartCS_LessThanSignHyphenMinusKeyword_1_1_or_WithKeyword_1_0.equals(syntax))
				emit_MapLiteralPartCS_LessThanSignHyphenMinusKeyword_1_1_or_WithKeyword_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q.equals(syntax))
				emit_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_0_0_1_or_WithKeyword_0_1_0_0_0.equals(syntax))
				emit_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_0_0_1_or_WithKeyword_0_1_0_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_1_2_0_1_or_WithKeyword_0_1_1_2_0_0.equals(syntax))
				emit_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_1_2_0_1_or_WithKeyword_0_1_1_2_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_2_1_0_1_or_WithKeyword_0_1_2_1_0_0.equals(syntax))
				emit_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_2_1_0_1_or_WithKeyword_0_1_2_1_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_0_0_1_or_WithKeyword_2_0_0_0.equals(syntax))
				emit_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_0_0_1_or_WithKeyword_2_0_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_1_2_0_1_or_WithKeyword_2_1_2_0_0.equals(syntax))
				emit_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_1_2_0_1_or_WithKeyword_2_1_2_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_2_1_0_1_or_WithKeyword_2_2_1_0_0.equals(syntax))
				emit_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_2_1_0_1_or_WithKeyword_2_2_1_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q.equals(syntax))
				emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'with' | '&lt;-'
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedKey=ExpCS (ambiguity) ownedValue=ExpCS

	 * </pre>
	 */
	protected void emit_MapLiteralPartCS_LessThanSignHyphenMinusKeyword_1_1_or_WithKeyword_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
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

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'with' | '&lt;-'
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedNameExpression=NavigatingArgExpCS (ambiguity) ownedCoIterator=CoIteratorVariableCS

	 * </pre>
	 */
	protected void emit_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_0_0_1_or_WithKeyword_0_1_0_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'with' | '&lt;-'
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedType=TypeExpCS (ambiguity) ownedCoIterator=CoIteratorVariableCS

	 * </pre>
	 */
	protected void emit_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_1_2_0_1_or_WithKeyword_0_1_1_2_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'with' | '&lt;-'
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedNameExpression=NavigatingArgExpCS (ambiguity) ownedCoIterator=CoIteratorVariableCS
	 *     ownedType=TypeExpCS (ambiguity) ownedCoIterator=CoIteratorVariableCS

	 * </pre>
	 */
	protected void emit_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_2_1_0_1_or_WithKeyword_0_1_2_1_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'with' | '&lt;-'
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedNameExpression=NavigatingArgExpCS (ambiguity) ownedCoIterator=CoIteratorVariableCS

	 * </pre>
	 */
	protected void emit_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_0_0_1_or_WithKeyword_2_0_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'with' | '&lt;-'
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedType=TypeExpCS (ambiguity) ownedCoIterator=CoIteratorVariableCS

	 * </pre>
	 */
	protected void emit_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_1_2_0_1_or_WithKeyword_2_1_2_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'with' | '&lt;-'
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedNameExpression=NavigatingArgExpCS (ambiguity) ownedCoIterator=CoIteratorVariableCS
	 *     ownedType=TypeExpCS (ambiguity) ownedCoIterator=CoIteratorVariableCS

	 * </pre>
	 */
	protected void emit_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_2_1_0_1_or_WithKeyword_2_2_1_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name='Tuple' (ambiguity) (rule end)
	 *     name='Tuple' (ambiguity) ownedMultiplicity=MultiplicityCS

	 * </pre>
	 */
	protected void emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

}
