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
package org.eclipse.ocl.xtext.completeocl.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.xtext.completeocl.services.CompleteOCLGrammarAccess;
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
public abstract class AbstractCompleteOCLSyntacticSequencer extends AbstractSyntacticSequencer {

	protected CompleteOCLGrammarAccess grammarAccess;
	protected AbstractElementAlias match_DefOperationCS_UnrestrictedNameParserRuleCall_2_q;
	protected AbstractElementAlias match_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q;
	protected AbstractElementAlias match_ImportCS_ImportKeyword_0_0_or_IncludeKeyword_0_1_or_LibraryKeyword_0_2;
	protected AbstractElementAlias match_MapLiteralPartCS_LessThanSignHyphenMinusKeyword_1_1_or_WithKeyword_1_0;
	protected AbstractElementAlias match_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q;
	protected AbstractElementAlias match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_0_0_1_or_WithKeyword_0_1_0_0_0;
	protected AbstractElementAlias match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_1_2_0_1_or_WithKeyword_0_1_1_2_0_0;
	protected AbstractElementAlias match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_2_1_0_1_or_WithKeyword_0_1_2_1_0_0;
	protected AbstractElementAlias match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_0_0_1_or_WithKeyword_2_0_0_0;
	protected AbstractElementAlias match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_1_2_0_1_or_WithKeyword_2_1_2_0_0;
	protected AbstractElementAlias match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_2_1_0_1_or_WithKeyword_2_2_1_0_0;
	protected AbstractElementAlias match_OperationContextDeclCS_UnrestrictedNameParserRuleCall_8_2_1_q;
	protected AbstractElementAlias match_PropertyContextDeclCS_UnrestrictedNameParserRuleCall_4_0_1_q;
	protected AbstractElementAlias match_PropertyContextDeclCS_UnrestrictedNameParserRuleCall_4_1_1_q;
	protected AbstractElementAlias match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q;

	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (CompleteOCLGrammarAccess) access;
		match_DefOperationCS_UnrestrictedNameParserRuleCall_2_q = new TokenAlias(false, true, grammarAccess.getDefOperationCSAccess().getUnrestrictedNameParserRuleCall_2());
		match_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q = new TokenAlias(false, true, grammarAccess.getDefPropertyCSAccess().getUnrestrictedNameParserRuleCall_2());
		match_ImportCS_ImportKeyword_0_0_or_IncludeKeyword_0_1_or_LibraryKeyword_0_2 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getImportCSAccess().getImportKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getImportCSAccess().getIncludeKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getImportCSAccess().getLibraryKeyword_0_2()));
		match_MapLiteralPartCS_LessThanSignHyphenMinusKeyword_1_1_or_WithKeyword_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getMapLiteralPartCSAccess().getWithKeyword_1_0()));
		match_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
		match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_0_0_1_or_WithKeyword_0_1_0_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_0_0_1()), new TokenAlias(false, false, grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_0_0_0()));
		match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_1_2_0_1_or_WithKeyword_0_1_1_2_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_1_2_0_1()), new TokenAlias(false, false, grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_1_2_0_0()));
		match_NavigatingArgCS_LessThanSignHyphenMinusKeyword_0_1_2_1_0_1_or_WithKeyword_0_1_2_1_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_2_1_0_1()), new TokenAlias(false, false, grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_2_1_0_0()));
		match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_0_0_1_or_WithKeyword_2_0_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_0_0_1()), new TokenAlias(false, false, grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_0_0_0()));
		match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_1_2_0_1_or_WithKeyword_2_1_2_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_1_2_0_1()), new TokenAlias(false, false, grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_1_2_0_0()));
		match_NavigatingCommaArgCS_LessThanSignHyphenMinusKeyword_2_2_1_0_1_or_WithKeyword_2_2_1_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_2_1_0_1()), new TokenAlias(false, false, grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_2_1_0_0()));
		match_OperationContextDeclCS_UnrestrictedNameParserRuleCall_8_2_1_q = new TokenAlias(false, true, grammarAccess.getOperationContextDeclCSAccess().getUnrestrictedNameParserRuleCall_8_2_1());
		match_PropertyContextDeclCS_UnrestrictedNameParserRuleCall_4_0_1_q = new TokenAlias(false, true, grammarAccess.getPropertyContextDeclCSAccess().getUnrestrictedNameParserRuleCall_4_0_1());
		match_PropertyContextDeclCS_UnrestrictedNameParserRuleCall_4_1_1_q = new TokenAlias(false, true, grammarAccess.getPropertyContextDeclCSAccess().getUnrestrictedNameParserRuleCall_4_1_1());
		match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2()));
	}

	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getUnrestrictedNameRule())
			return getUnrestrictedNameToken(semanticObject, ruleCall, node);
		return "";
	}

	/**
	 * @Override
	 * UnrestrictedName returns ecore::EString:
	 * 	EssentialOCLUnrestrictedName
	 * 						| 'import'
	 * 	| 'include'
	 * 			| 'library'
	 * 				;
	 */
	protected String getUnrestrictedNameToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}

	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_DefOperationCS_UnrestrictedNameParserRuleCall_2_q.equals(syntax))
				emit_DefOperationCS_UnrestrictedNameParserRuleCall_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q.equals(syntax))
				emit_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ImportCS_ImportKeyword_0_0_or_IncludeKeyword_0_1_or_LibraryKeyword_0_2.equals(syntax))
				emit_ImportCS_ImportKeyword_0_0_or_IncludeKeyword_0_1_or_LibraryKeyword_0_2(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_MapLiteralPartCS_LessThanSignHyphenMinusKeyword_1_1_or_WithKeyword_1_0.equals(syntax))
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
			else if (match_OperationContextDeclCS_UnrestrictedNameParserRuleCall_8_2_1_q.equals(syntax))
				emit_OperationContextDeclCS_UnrestrictedNameParserRuleCall_8_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_PropertyContextDeclCS_UnrestrictedNameParserRuleCall_4_0_1_q.equals(syntax))
				emit_PropertyContextDeclCS_UnrestrictedNameParserRuleCall_4_0_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_PropertyContextDeclCS_UnrestrictedNameParserRuleCall_4_1_1_q.equals(syntax))
				emit_PropertyContextDeclCS_UnrestrictedNameParserRuleCall_4_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q.equals(syntax))
				emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     UnrestrictedName?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'def' (ambiguity) ':' name=UnrestrictedName
	 *     (rule start) 'def' (ambiguity) ':' ownedSignature=TemplateSignatureCS
	 *     isStatic?='static' 'def' (ambiguity) ':' name=UnrestrictedName
	 *     isStatic?='static' 'def' (ambiguity) ':' ownedSignature=TemplateSignatureCS

	 * </pre>
	 */
	protected void emit_DefOperationCS_UnrestrictedNameParserRuleCall_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     UnrestrictedName?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'def' (ambiguity) ':' name=UnrestrictedName
	 *     isStatic?='static' 'def' (ambiguity) ':' name=UnrestrictedName

	 * </pre>
	 */
	protected void emit_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'import' | 'include' | 'library'
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) name=Identifier
	 *     (rule start) (ambiguity) ownedPathName=URIPathNameCS

	 * </pre>
	 */
	protected void emit_ImportCS_ImportKeyword_0_0_or_IncludeKeyword_0_1_or_LibraryKeyword_0_2(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
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
	 *     UnrestrictedName?
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedBodies+=SpecificationCS 'body' (ambiguity) ':' ownedBodies+=SpecificationCS
	 *     ownedParameters+=ParameterCS ')' ':' 'body' (ambiguity) ':' ownedBodies+=SpecificationCS
	 *     ownedPathName=UnreservedPathNameCS '(' ')' ':' 'body' (ambiguity) ':' ownedBodies+=SpecificationCS
	 *     ownedPostconditions+=ConstraintCS 'body' (ambiguity) ':' ownedBodies+=SpecificationCS
	 *     ownedPreconditions+=ConstraintCS 'body' (ambiguity) ':' ownedBodies+=SpecificationCS
	 *     ownedType=TypeExpCS 'body' (ambiguity) ':' ownedBodies+=SpecificationCS

	 * </pre>
	 */
	protected void emit_OperationContextDeclCS_UnrestrictedNameParserRuleCall_8_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     UnrestrictedName?
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedDefaultExpressions+=SpecificationCS 'derive' (ambiguity) ':' ownedDefaultExpressions+=SpecificationCS
	 *     ownedType=TypeExpCS 'derive' (ambiguity) ':' ownedDefaultExpressions+=SpecificationCS

	 * </pre>
	 */
	protected void emit_PropertyContextDeclCS_UnrestrictedNameParserRuleCall_4_0_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     UnrestrictedName?
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedDefaultExpressions+=SpecificationCS 'init' (ambiguity) ':' ownedDefaultExpressions+=SpecificationCS
	 *     ownedType=TypeExpCS 'init' (ambiguity) ':' ownedDefaultExpressions+=SpecificationCS

	 * </pre>
	 */
	protected void emit_PropertyContextDeclCS_UnrestrictedNameParserRuleCall_4_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
