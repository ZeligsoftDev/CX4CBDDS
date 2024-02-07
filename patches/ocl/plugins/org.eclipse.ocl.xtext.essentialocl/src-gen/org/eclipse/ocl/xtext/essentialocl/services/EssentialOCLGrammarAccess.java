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
package org.eclipse.ocl.xtext.essentialocl.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;

@Singleton
public class EssentialOCLGrammarAccess extends AbstractGrammarElementFinder {


	public class ModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.Model");
		private final Assignment cOwnedExpressionAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_0 = (RuleCall)cOwnedExpressionAssignment.eContents().get(0);

		////generate essentialOCLCST "http://www.eclipse.org/ocl/3.0.0/EssentialOCLCST"
		//Model ContextCS:
		//	ownedExpression=ExpCS;
		@Override public ParserRule getRule() { return rule; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment() { return cOwnedExpressionAssignment; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_0() { return cOwnedExpressionExpCSParserRuleCall_0; }
	}

	public class EssentialOCLReservedKeywordElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.EssentialOCLReservedKeyword");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAndKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cAnd2Keyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cElseKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cEndifKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cIfKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cImpliesKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cImplies2Keyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cInKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cLetKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cNotKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cNot2Keyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cOrKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Keyword cOr2Keyword_12 = (Keyword)cAlternatives.eContents().get(12);
		private final Keyword cThenKeyword_13 = (Keyword)cAlternatives.eContents().get(13);
		private final Keyword cWithKeyword_14 = (Keyword)cAlternatives.eContents().get(14);
		private final Keyword cXorKeyword_15 = (Keyword)cAlternatives.eContents().get(15);
		private final Keyword cXor2Keyword_16 = (Keyword)cAlternatives.eContents().get(16);

		///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
		//EssentialOCLReservedKeyword:
		//	'and'
		//	| 'and2'
		//	| 'else'
		//	| 'endif'
		//	| 'if'
		//	| 'implies'
		//	| 'implies2'
		//	| 'in'
		//	| 'let'
		//	| 'not'
		//	| 'not2'
		//	| 'or'
		//	| 'or2'
		//	| 'then'
		//	| 'with'
		//	| 'xor'
		//	| 'xor2';
		@Override public ParserRule getRule() { return rule; }

		//'and'
		//| 'and2'
		//| 'else'
		//| 'endif'
		//| 'if'
		//| 'implies'
		//| 'implies2'
		//| 'in'
		//| 'let'
		//| 'not'
		//| 'not2'
		//| 'or'
		//| 'or2'
		//| 'then'
		//| 'with'
		//| 'xor'
		//| 'xor2'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'and'
		public Keyword getAndKeyword_0() { return cAndKeyword_0; }

		//'and2'
		public Keyword getAnd2Keyword_1() { return cAnd2Keyword_1; }

		//'else'
		public Keyword getElseKeyword_2() { return cElseKeyword_2; }

		//'endif'
		public Keyword getEndifKeyword_3() { return cEndifKeyword_3; }

		//'if'
		public Keyword getIfKeyword_4() { return cIfKeyword_4; }

		//'implies'
		public Keyword getImpliesKeyword_5() { return cImpliesKeyword_5; }

		//'implies2'
		public Keyword getImplies2Keyword_6() { return cImplies2Keyword_6; }

		//'in'
		public Keyword getInKeyword_7() { return cInKeyword_7; }

		//'let'
		public Keyword getLetKeyword_8() { return cLetKeyword_8; }

		//'not'
		public Keyword getNotKeyword_9() { return cNotKeyword_9; }

		//'not2'
		public Keyword getNot2Keyword_10() { return cNot2Keyword_10; }

		//'or'
		public Keyword getOrKeyword_11() { return cOrKeyword_11; }

		//'or2'
		public Keyword getOr2Keyword_12() { return cOr2Keyword_12; }

		//'then'
		public Keyword getThenKeyword_13() { return cThenKeyword_13; }

		//'with'
		public Keyword getWithKeyword_14() { return cWithKeyword_14; }

		//'xor'
		public Keyword getXorKeyword_15() { return cXorKeyword_15; }

		//'xor2'
		public Keyword getXor2Keyword_16() { return cXor2Keyword_16; }
	}

	public class EssentialOCLUnaryOperatorNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.EssentialOCLUnaryOperatorName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cNotKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cNot2Keyword_2 = (Keyword)cAlternatives.eContents().get(2);

		///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
		//EssentialOCLUnaryOperatorName:
		//	'-' | 'not' | 'not2';
		@Override public ParserRule getRule() { return rule; }

		//'-' | 'not' | 'not2'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'-'
		public Keyword getHyphenMinusKeyword_0() { return cHyphenMinusKeyword_0; }

		//'not'
		public Keyword getNotKeyword_1() { return cNotKeyword_1; }

		//'not2'
		public Keyword getNot2Keyword_2() { return cNot2Keyword_2; }
	}

	public class EssentialOCLInfixOperatorNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.EssentialOCLInfixOperatorName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAsteriskKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cSolidusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cPlusSignKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cHyphenMinusKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cGreaterThanSignKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cLessThanSignKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cGreaterThanSignEqualsSignKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cLessThanSignEqualsSignKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cEqualsSignKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cLessThanSignGreaterThanSignKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cAndKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cAnd2Keyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Keyword cImpliesKeyword_12 = (Keyword)cAlternatives.eContents().get(12);
		private final Keyword cImplies2Keyword_13 = (Keyword)cAlternatives.eContents().get(13);
		private final Keyword cOrKeyword_14 = (Keyword)cAlternatives.eContents().get(14);
		private final Keyword cOr2Keyword_15 = (Keyword)cAlternatives.eContents().get(15);
		private final Keyword cXorKeyword_16 = (Keyword)cAlternatives.eContents().get(16);
		private final Keyword cXor2Keyword_17 = (Keyword)cAlternatives.eContents().get(17);

		///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
		//EssentialOCLInfixOperatorName:
		//	'*' | '/' | '+' | '-' | '>' | '<' | '>=' | '<=' | '=' | '<>' | 'and' | 'and2' | 'implies' | 'implies2' | 'or' |
		//	'or2' | 'xor' | 'xor2';
		@Override public ParserRule getRule() { return rule; }

		//'*' | '/' | '+' | '-' | '>' | '<' | '>=' | '<=' | '=' | '<>' | 'and' | 'and2' | 'implies' | 'implies2' | 'or' |
		//'or2' | 'xor' | 'xor2'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'*'
		public Keyword getAsteriskKeyword_0() { return cAsteriskKeyword_0; }

		//'/'
		public Keyword getSolidusKeyword_1() { return cSolidusKeyword_1; }

		//'+'
		public Keyword getPlusSignKeyword_2() { return cPlusSignKeyword_2; }

		//'-'
		public Keyword getHyphenMinusKeyword_3() { return cHyphenMinusKeyword_3; }

		//'>'
		public Keyword getGreaterThanSignKeyword_4() { return cGreaterThanSignKeyword_4; }

		//'<'
		public Keyword getLessThanSignKeyword_5() { return cLessThanSignKeyword_5; }

		//'>='
		public Keyword getGreaterThanSignEqualsSignKeyword_6() { return cGreaterThanSignEqualsSignKeyword_6; }

		//'<='
		public Keyword getLessThanSignEqualsSignKeyword_7() { return cLessThanSignEqualsSignKeyword_7; }

		//'='
		public Keyword getEqualsSignKeyword_8() { return cEqualsSignKeyword_8; }

		//'<>'
		public Keyword getLessThanSignGreaterThanSignKeyword_9() { return cLessThanSignGreaterThanSignKeyword_9; }

		//'and'
		public Keyword getAndKeyword_10() { return cAndKeyword_10; }

		//'and2'
		public Keyword getAnd2Keyword_11() { return cAnd2Keyword_11; }

		//'implies'
		public Keyword getImpliesKeyword_12() { return cImpliesKeyword_12; }

		//'implies2'
		public Keyword getImplies2Keyword_13() { return cImplies2Keyword_13; }

		//'or'
		public Keyword getOrKeyword_14() { return cOrKeyword_14; }

		//'or2'
		public Keyword getOr2Keyword_15() { return cOr2Keyword_15; }

		//'xor'
		public Keyword getXorKeyword_16() { return cXorKeyword_16; }

		//'xor2'
		public Keyword getXor2Keyword_17() { return cXor2Keyword_17; }
	}

	public class EssentialOCLNavigationOperatorNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.EssentialOCLNavigationOperatorName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cFullStopKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cQuestionMarkFullStopKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cQuestionMarkHyphenMinusGreaterThanSignKeyword_3 = (Keyword)cAlternatives.eContents().get(3);

		///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
		//EssentialOCLNavigationOperatorName:
		//	'.' | '->' | '?.' | '?->';
		@Override public ParserRule getRule() { return rule; }

		//'.' | '->' | '?.' | '?->'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'.'
		public Keyword getFullStopKeyword_0() { return cFullStopKeyword_0; }

		//'->'
		public Keyword getHyphenMinusGreaterThanSignKeyword_1() { return cHyphenMinusGreaterThanSignKeyword_1; }

		//'?.'
		public Keyword getQuestionMarkFullStopKeyword_2() { return cQuestionMarkFullStopKeyword_2; }

		//'?->'
		public Keyword getQuestionMarkHyphenMinusGreaterThanSignKeyword_3() { return cQuestionMarkHyphenMinusGreaterThanSignKeyword_3; }
	}

	public class BinaryOperatorNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.BinaryOperatorName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cInfixOperatorNameParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cNavigationOperatorNameParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		//BinaryOperatorName:
		//	InfixOperatorName | NavigationOperatorName;
		@Override public ParserRule getRule() { return rule; }

		//InfixOperatorName | NavigationOperatorName
		public Alternatives getAlternatives() { return cAlternatives; }

		//InfixOperatorName
		public RuleCall getInfixOperatorNameParserRuleCall_0() { return cInfixOperatorNameParserRuleCall_0; }

		//NavigationOperatorName
		public RuleCall getNavigationOperatorNameParserRuleCall_1() { return cNavigationOperatorNameParserRuleCall_1; }
	}

	public class InfixOperatorNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.InfixOperatorName");
		private final RuleCall cEssentialOCLInfixOperatorNameParserRuleCall = (RuleCall)rule.eContents().get(1);

		//InfixOperatorName:
		//	EssentialOCLInfixOperatorName;
		@Override public ParserRule getRule() { return rule; }

		//// Intended to be overrideable
		//	EssentialOCLInfixOperatorName
		public RuleCall getEssentialOCLInfixOperatorNameParserRuleCall() { return cEssentialOCLInfixOperatorNameParserRuleCall; }
	}

	public class NavigationOperatorNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigationOperatorName");
		private final RuleCall cEssentialOCLNavigationOperatorNameParserRuleCall = (RuleCall)rule.eContents().get(1);

		//NavigationOperatorName:
		//	EssentialOCLNavigationOperatorName;
		@Override public ParserRule getRule() { return rule; }

		//// Intended to be overrideable
		//	EssentialOCLNavigationOperatorName
		public RuleCall getEssentialOCLNavigationOperatorNameParserRuleCall() { return cEssentialOCLNavigationOperatorNameParserRuleCall; }
	}

	public class UnaryOperatorNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnaryOperatorName");
		private final RuleCall cEssentialOCLUnaryOperatorNameParserRuleCall = (RuleCall)rule.eContents().get(1);

		//UnaryOperatorName:
		//	EssentialOCLUnaryOperatorName;
		@Override public ParserRule getRule() { return rule; }

		//// Intended to be overrideable
		//	EssentialOCLUnaryOperatorName
		public RuleCall getEssentialOCLUnaryOperatorNameParserRuleCall() { return cEssentialOCLUnaryOperatorNameParserRuleCall; }
	}

	public class EssentialOCLUnrestrictedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.EssentialOCLUnrestrictedName");
		private final RuleCall cIdentifierParserRuleCall = (RuleCall)rule.eContents().get(1);

		////---------------------------------------------------------------------
		////  Names
		////---------------------------------------------------------------------
		///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
		//EssentialOCLUnrestrictedName:
		//	Identifier;
		@Override public ParserRule getRule() { return rule; }

		//Identifier
		public RuleCall getIdentifierParserRuleCall() { return cIdentifierParserRuleCall; }
	}

	public class UnrestrictedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
		private final RuleCall cEssentialOCLUnrestrictedNameParserRuleCall = (RuleCall)rule.eContents().get(1);

		//@Override
		//UnrestrictedName:
		//	EssentialOCLUnrestrictedName;
		@Override public ParserRule getRule() { return rule; }

		//// Intended to be overridden
		//	EssentialOCLUnrestrictedName
		public RuleCall getEssentialOCLUnrestrictedNameParserRuleCall() { return cEssentialOCLUnrestrictedNameParserRuleCall; }
	}

	public class EssentialOCLUnreservedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.EssentialOCLUnreservedName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cUnrestrictedNameParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cCollectionTypeIdentifierParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cPrimitiveTypeIdentifierParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final Keyword cMapKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cTupleKeyword_4 = (Keyword)cAlternatives.eContents().get(4);

		///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
		//EssentialOCLUnreservedName:
		//	UnrestrictedName
		//	| CollectionTypeIdentifier
		//	| PrimitiveTypeIdentifier
		//	| 'Map'
		//	| 'Tuple';
		@Override public ParserRule getRule() { return rule; }

		//UnrestrictedName
		//| CollectionTypeIdentifier
		//| PrimitiveTypeIdentifier
		//| 'Map'
		//| 'Tuple'
		public Alternatives getAlternatives() { return cAlternatives; }

		//UnrestrictedName
		public RuleCall getUnrestrictedNameParserRuleCall_0() { return cUnrestrictedNameParserRuleCall_0; }

		//CollectionTypeIdentifier
		public RuleCall getCollectionTypeIdentifierParserRuleCall_1() { return cCollectionTypeIdentifierParserRuleCall_1; }

		//PrimitiveTypeIdentifier
		public RuleCall getPrimitiveTypeIdentifierParserRuleCall_2() { return cPrimitiveTypeIdentifierParserRuleCall_2; }

		//'Map'
		public Keyword getMapKeyword_3() { return cMapKeyword_3; }

		//'Tuple'
		public Keyword getTupleKeyword_4() { return cTupleKeyword_4; }
	}

	public class UnreservedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnreservedName");
		private final RuleCall cEssentialOCLUnreservedNameParserRuleCall = (RuleCall)rule.eContents().get(1);

		//@Override
		//UnreservedName:
		//	EssentialOCLUnreservedName;
		@Override public ParserRule getRule() { return rule; }

		//// Intended to be overridden
		//	EssentialOCLUnreservedName
		public RuleCall getEssentialOCLUnreservedNameParserRuleCall() { return cEssentialOCLUnreservedNameParserRuleCall; }
	}

	public class URIPathNameCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.URIPathNameCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedPathElementsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedPathElementsURIFirstPathElementCSParserRuleCall_0_0 = (RuleCall)cOwnedPathElementsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedPathElementsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0 = (RuleCall)cOwnedPathElementsAssignment_1_1.eContents().get(0);

		//URIPathNameCS base::PathNameCS:
		//	ownedPathElements+=URIFirstPathElementCS ('::' ownedPathElements+=NextPathElementCS)*;
		@Override public ParserRule getRule() { return rule; }

		//ownedPathElements+=URIFirstPathElementCS ('::' ownedPathElements+=NextPathElementCS)*
		public Group getGroup() { return cGroup; }

		//ownedPathElements+=URIFirstPathElementCS
		public Assignment getOwnedPathElementsAssignment_0() { return cOwnedPathElementsAssignment_0; }

		//URIFirstPathElementCS
		public RuleCall getOwnedPathElementsURIFirstPathElementCSParserRuleCall_0_0() { return cOwnedPathElementsURIFirstPathElementCSParserRuleCall_0_0; }

		//('::' ownedPathElements+=NextPathElementCS)*
		public Group getGroup_1() { return cGroup_1; }

		//'::'
		public Keyword getColonColonKeyword_1_0() { return cColonColonKeyword_1_0; }

		//ownedPathElements+=NextPathElementCS
		public Assignment getOwnedPathElementsAssignment_1_1() { return cOwnedPathElementsAssignment_1_1; }

		//NextPathElementCS
		public RuleCall getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0() { return cOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0; }
	}

	public class URIFirstPathElementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.URIFirstPathElementCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cReferredElementAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final CrossReference cReferredElementNamedElementCrossReference_0_0 = (CrossReference)cReferredElementAssignment_0.eContents().get(0);
		private final RuleCall cReferredElementNamedElementUnrestrictedNameParserRuleCall_0_0_1 = (RuleCall)cReferredElementNamedElementCrossReference_0_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cPathElementWithURICSAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cReferredElementAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final CrossReference cReferredElementNamespaceCrossReference_1_1_0 = (CrossReference)cReferredElementAssignment_1_1.eContents().get(0);
		private final RuleCall cReferredElementNamespaceURIParserRuleCall_1_1_0_1 = (RuleCall)cReferredElementNamespaceCrossReference_1_1_0.eContents().get(1);

		//URIFirstPathElementCS base::PathElementCS:
		//	referredElement=[pivot::NamedElement|UnrestrictedName] | {base::PathElementWithURICS}
		//	referredElement=[pivot::Namespace|URI];
		@Override public ParserRule getRule() { return rule; }

		//referredElement=[pivot::NamedElement|UnrestrictedName] | {base::PathElementWithURICS}
		//referredElement=[pivot::Namespace|URI]
		public Alternatives getAlternatives() { return cAlternatives; }

		//referredElement=[pivot::NamedElement|UnrestrictedName]
		public Assignment getReferredElementAssignment_0() { return cReferredElementAssignment_0; }

		//[pivot::NamedElement|UnrestrictedName]
		public CrossReference getReferredElementNamedElementCrossReference_0_0() { return cReferredElementNamedElementCrossReference_0_0; }

		//UnrestrictedName
		public RuleCall getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_0_1() { return cReferredElementNamedElementUnrestrictedNameParserRuleCall_0_0_1; }

		//{base::PathElementWithURICS} referredElement=[pivot::Namespace|URI]
		public Group getGroup_1() { return cGroup_1; }

		//{base::PathElementWithURICS}
		public Action getPathElementWithURICSAction_1_0() { return cPathElementWithURICSAction_1_0; }

		//referredElement=[pivot::Namespace|URI]
		public Assignment getReferredElementAssignment_1_1() { return cReferredElementAssignment_1_1; }

		//[pivot::Namespace|URI]
		public CrossReference getReferredElementNamespaceCrossReference_1_1_0() { return cReferredElementNamespaceCrossReference_1_1_0; }

		//URI
		public RuleCall getReferredElementNamespaceURIParserRuleCall_1_1_0_1() { return cReferredElementNamespaceURIParserRuleCall_1_1_0_1; }
	}

	public class SimplePathNameCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.SimplePathNameCS");
		private final Assignment cOwnedPathElementsAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cOwnedPathElementsFirstPathElementCSParserRuleCall_0 = (RuleCall)cOwnedPathElementsAssignment.eContents().get(0);

		//SimplePathNameCS base::PathNameCS:
		//	ownedPathElements+=FirstPathElementCS;
		@Override public ParserRule getRule() { return rule; }

		//ownedPathElements+=FirstPathElementCS
		public Assignment getOwnedPathElementsAssignment() { return cOwnedPathElementsAssignment; }

		//FirstPathElementCS
		public RuleCall getOwnedPathElementsFirstPathElementCSParserRuleCall_0() { return cOwnedPathElementsFirstPathElementCSParserRuleCall_0; }
	}

	public class PrimitiveTypeIdentifierElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrimitiveTypeIdentifier");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cBooleanKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cIntegerKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cRealKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cStringKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cUnlimitedNaturalKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cOclAnyKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cOclInvalidKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cOclVoidKeyword_7 = (Keyword)cAlternatives.eContents().get(7);

		////---------------------------------------------------------------------
		////  Types
		////---------------------------------------------------------------------
		//PrimitiveTypeIdentifier:
		//	'Boolean'
		//	| 'Integer'
		//	| 'Real'
		//	| 'String'
		//	| 'UnlimitedNatural'
		//	| 'OclAny'
		//	| 'OclInvalid'
		//	| 'OclVoid';
		@Override public ParserRule getRule() { return rule; }

		//'Boolean'
		//| 'Integer'
		//| 'Real'
		//| 'String'
		//| 'UnlimitedNatural'
		//| 'OclAny'
		//| 'OclInvalid'
		//| 'OclVoid'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'Boolean'
		public Keyword getBooleanKeyword_0() { return cBooleanKeyword_0; }

		//'Integer'
		public Keyword getIntegerKeyword_1() { return cIntegerKeyword_1; }

		//'Real'
		public Keyword getRealKeyword_2() { return cRealKeyword_2; }

		//'String'
		public Keyword getStringKeyword_3() { return cStringKeyword_3; }

		//'UnlimitedNatural'
		public Keyword getUnlimitedNaturalKeyword_4() { return cUnlimitedNaturalKeyword_4; }

		//'OclAny'
		public Keyword getOclAnyKeyword_5() { return cOclAnyKeyword_5; }

		//'OclInvalid'
		public Keyword getOclInvalidKeyword_6() { return cOclInvalidKeyword_6; }

		//'OclVoid'
		public Keyword getOclVoidKeyword_7() { return cOclVoidKeyword_7; }
	}

	public class PrimitiveTypeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrimitiveTypeCS");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNamePrimitiveTypeIdentifierParserRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);

		//PrimitiveTypeCS base::PrimitiveTypeRefCS:
		//	name=PrimitiveTypeIdentifier;
		@Override public ParserRule getRule() { return rule; }

		//name=PrimitiveTypeIdentifier
		public Assignment getNameAssignment() { return cNameAssignment; }

		//PrimitiveTypeIdentifier
		public RuleCall getNamePrimitiveTypeIdentifierParserRuleCall_0() { return cNamePrimitiveTypeIdentifierParserRuleCall_0; }
	}

	public class CollectionTypeIdentifierElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeIdentifier");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cSetKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cBagKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cSequenceKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cCollectionKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cOrderedSetKeyword_4 = (Keyword)cAlternatives.eContents().get(4);

		//CollectionTypeIdentifier:
		//	'Set'
		//	| 'Bag'
		//	| 'Sequence'
		//	| 'Collection'
		//	| 'OrderedSet';
		@Override public ParserRule getRule() { return rule; }

		//'Set'
		//| 'Bag'
		//| 'Sequence'
		//| 'Collection'
		//| 'OrderedSet'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'Set'
		public Keyword getSetKeyword_0() { return cSetKeyword_0; }

		//'Bag'
		public Keyword getBagKeyword_1() { return cBagKeyword_1; }

		//'Sequence'
		public Keyword getSequenceKeyword_2() { return cSequenceKeyword_2; }

		//'Collection'
		public Keyword getCollectionKeyword_3() { return cCollectionKeyword_3; }

		//'OrderedSet'
		public Keyword getOrderedSetKeyword_4() { return cOrderedSetKeyword_4; }
	}

	public class CollectionTypeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameCollectionTypeIdentifierParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpWithoutMultiplicityCSParserRuleCall_1_1_0 = (RuleCall)cOwnedTypeAssignment_1_1.eContents().get(0);
		private final Assignment cOwnedCollectionMultiplicityAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cOwnedCollectionMultiplicityMultiplicityCSParserRuleCall_1_2_0 = (RuleCall)cOwnedCollectionMultiplicityAssignment_1_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_3 = (Keyword)cGroup_1.eContents().get(3);

		//CollectionTypeCS:
		//	name=CollectionTypeIdentifier ('(' ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS
		//	? ')')?;
		@Override public ParserRule getRule() { return rule; }

		//name=CollectionTypeIdentifier ('(' ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS
		//? ')')?
		public Group getGroup() { return cGroup; }

		//name=CollectionTypeIdentifier
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//CollectionTypeIdentifier
		public RuleCall getNameCollectionTypeIdentifierParserRuleCall_0_0() { return cNameCollectionTypeIdentifierParserRuleCall_0_0; }

		//('(' ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS? ')')?
		public Group getGroup_1() { return cGroup_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_1_0() { return cLeftParenthesisKeyword_1_0; }

		//ownedType=TypeExpWithoutMultiplicityCS
		public Assignment getOwnedTypeAssignment_1_1() { return cOwnedTypeAssignment_1_1; }

		//TypeExpWithoutMultiplicityCS
		public RuleCall getOwnedTypeTypeExpWithoutMultiplicityCSParserRuleCall_1_1_0() { return cOwnedTypeTypeExpWithoutMultiplicityCSParserRuleCall_1_1_0; }

		//ownedCollectionMultiplicity=MultiplicityCS?
		public Assignment getOwnedCollectionMultiplicityAssignment_1_2() { return cOwnedCollectionMultiplicityAssignment_1_2; }

		//MultiplicityCS
		public RuleCall getOwnedCollectionMultiplicityMultiplicityCSParserRuleCall_1_2_0() { return cOwnedCollectionMultiplicityMultiplicityCSParserRuleCall_1_2_0; }

		//')'
		public Keyword getRightParenthesisKeyword_1_3() { return cRightParenthesisKeyword_1_3; }
	}

	public class MapTypeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapTypeCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cNameMapKeyword_0_0 = (Keyword)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedKeyTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0 = (RuleCall)cOwnedKeyTypeAssignment_1_1.eContents().get(0);
		private final Keyword cCommaKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		private final Assignment cOwnedValueTypeAssignment_1_3 = (Assignment)cGroup_1.eContents().get(3);
		private final RuleCall cOwnedValueTypeTypeExpCSParserRuleCall_1_3_0 = (RuleCall)cOwnedValueTypeAssignment_1_3.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_4 = (Keyword)cGroup_1.eContents().get(4);

		//MapTypeCS:
		//	name='Map' ('(' ownedKeyType=TypeExpCS ',' ownedValueType=TypeExpCS ')')?;
		@Override public ParserRule getRule() { return rule; }

		//name='Map' ('(' ownedKeyType=TypeExpCS ',' ownedValueType=TypeExpCS ')')?
		public Group getGroup() { return cGroup; }

		//name='Map'
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//'Map'
		public Keyword getNameMapKeyword_0_0() { return cNameMapKeyword_0_0; }

		//('(' ownedKeyType=TypeExpCS ',' ownedValueType=TypeExpCS ')')?
		public Group getGroup_1() { return cGroup_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_1_0() { return cLeftParenthesisKeyword_1_0; }

		//ownedKeyType=TypeExpCS
		public Assignment getOwnedKeyTypeAssignment_1_1() { return cOwnedKeyTypeAssignment_1_1; }

		//TypeExpCS
		public RuleCall getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0() { return cOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0; }

		//','
		public Keyword getCommaKeyword_1_2() { return cCommaKeyword_1_2; }

		//ownedValueType=TypeExpCS
		public Assignment getOwnedValueTypeAssignment_1_3() { return cOwnedValueTypeAssignment_1_3; }

		//TypeExpCS
		public RuleCall getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0() { return cOwnedValueTypeTypeExpCSParserRuleCall_1_3_0; }

		//')'
		public Keyword getRightParenthesisKeyword_1_4() { return cRightParenthesisKeyword_1_4; }
	}

	public class TupleTypeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TupleTypeCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cNameTupleKeyword_0_0 = (Keyword)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Assignment cOwnedPartsAssignment_1_1_0 = (Assignment)cGroup_1_1.eContents().get(0);
		private final RuleCall cOwnedPartsTuplePartCSParserRuleCall_1_1_0_0 = (RuleCall)cOwnedPartsAssignment_1_1_0.eContents().get(0);
		private final Group cGroup_1_1_1 = (Group)cGroup_1_1.eContents().get(1);
		private final Keyword cCommaKeyword_1_1_1_0 = (Keyword)cGroup_1_1_1.eContents().get(0);
		private final Assignment cOwnedPartsAssignment_1_1_1_1 = (Assignment)cGroup_1_1_1.eContents().get(1);
		private final RuleCall cOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0 = (RuleCall)cOwnedPartsAssignment_1_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);

		//TupleTypeCS base::TupleTypeCS:
		//	name='Tuple' ('(' (ownedParts+=TuplePartCS (',' ownedParts+=TuplePartCS)*)? ')')?;
		@Override public ParserRule getRule() { return rule; }

		//name='Tuple' ('(' (ownedParts+=TuplePartCS (',' ownedParts+=TuplePartCS)*)? ')')?
		public Group getGroup() { return cGroup; }

		//name='Tuple'
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//'Tuple'
		public Keyword getNameTupleKeyword_0_0() { return cNameTupleKeyword_0_0; }

		//('(' (ownedParts+=TuplePartCS (',' ownedParts+=TuplePartCS)*)? ')')?
		public Group getGroup_1() { return cGroup_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_1_0() { return cLeftParenthesisKeyword_1_0; }

		//(ownedParts+=TuplePartCS (',' ownedParts+=TuplePartCS)*)?
		public Group getGroup_1_1() { return cGroup_1_1; }

		//ownedParts+=TuplePartCS
		public Assignment getOwnedPartsAssignment_1_1_0() { return cOwnedPartsAssignment_1_1_0; }

		//TuplePartCS
		public RuleCall getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0() { return cOwnedPartsTuplePartCSParserRuleCall_1_1_0_0; }

		//(',' ownedParts+=TuplePartCS)*
		public Group getGroup_1_1_1() { return cGroup_1_1_1; }

		//','
		public Keyword getCommaKeyword_1_1_1_0() { return cCommaKeyword_1_1_1_0; }

		//ownedParts+=TuplePartCS
		public Assignment getOwnedPartsAssignment_1_1_1_1() { return cOwnedPartsAssignment_1_1_1_1; }

		//TuplePartCS
		public RuleCall getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0() { return cOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_1_2() { return cRightParenthesisKeyword_1_2; }
	}

	public class TuplePartCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TuplePartCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_2_0 = (RuleCall)cOwnedTypeAssignment_2.eContents().get(0);

		//TuplePartCS base::TuplePartCS:
		//	name=UnrestrictedName ':' ownedType=TypeExpCS;
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName ':' ownedType=TypeExpCS
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_2() { return cOwnedTypeAssignment_2; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_2_0() { return cOwnedTypeTypeExpCSParserRuleCall_2_0; }
	}

	public class CollectionLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionLiteralExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedTypeCollectionTypeCSParserRuleCall_0_0 = (RuleCall)cOwnedTypeAssignment_0.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cOwnedPartsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0 = (RuleCall)cOwnedPartsAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cOwnedPartsAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0 = (RuleCall)cOwnedPartsAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);

		////---------------------------------------------------------------------
		////  Literals
		////---------------------------------------------------------------------
		//CollectionLiteralExpCS:
		//	ownedType=CollectionTypeCS
		//	'{' (ownedParts+=CollectionLiteralPartCS (',' ownedParts+=CollectionLiteralPartCS)*)?
		//	'}';
		@Override public ParserRule getRule() { return rule; }

		//ownedType=CollectionTypeCS
		//'{' (ownedParts+=CollectionLiteralPartCS (',' ownedParts+=CollectionLiteralPartCS)*)?
		//'}'
		public Group getGroup() { return cGroup; }

		//ownedType=CollectionTypeCS
		public Assignment getOwnedTypeAssignment_0() { return cOwnedTypeAssignment_0; }

		//CollectionTypeCS
		public RuleCall getOwnedTypeCollectionTypeCSParserRuleCall_0_0() { return cOwnedTypeCollectionTypeCSParserRuleCall_0_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//(ownedParts+=CollectionLiteralPartCS (',' ownedParts+=CollectionLiteralPartCS)*)?
		public Group getGroup_2() { return cGroup_2; }

		//ownedParts+=CollectionLiteralPartCS
		public Assignment getOwnedPartsAssignment_2_0() { return cOwnedPartsAssignment_2_0; }

		//CollectionLiteralPartCS
		public RuleCall getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0() { return cOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0; }

		//(',' ownedParts+=CollectionLiteralPartCS)*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//','
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//ownedParts+=CollectionLiteralPartCS
		public Assignment getOwnedPartsAssignment_2_1_1() { return cOwnedPartsAssignment_2_1_1; }

		//CollectionLiteralPartCS
		public RuleCall getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0() { return cOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class CollectionLiteralPartCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionLiteralPartCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Assignment cOwnedExpressionAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_0_0_0 = (RuleCall)cOwnedExpressionAssignment_0_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Keyword cFullStopFullStopKeyword_0_1_0 = (Keyword)cGroup_0_1.eContents().get(0);
		private final Assignment cOwnedLastExpressionAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final RuleCall cOwnedLastExpressionExpCSParserRuleCall_0_1_1_0 = (RuleCall)cOwnedLastExpressionAssignment_0_1_1.eContents().get(0);
		private final Assignment cOwnedExpressionAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cOwnedExpressionPatternExpCSParserRuleCall_1_0 = (RuleCall)cOwnedExpressionAssignment_1.eContents().get(0);

		//CollectionLiteralPartCS:
		//	ownedExpression=ExpCS ('..' ownedLastExpression=ExpCS)? | ownedExpression=PatternExpCS;
		@Override public ParserRule getRule() { return rule; }

		//ownedExpression=ExpCS ('..' ownedLastExpression=ExpCS)? | ownedExpression=PatternExpCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//ownedExpression=ExpCS ('..' ownedLastExpression=ExpCS)?
		public Group getGroup_0() { return cGroup_0; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment_0_0() { return cOwnedExpressionAssignment_0_0; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_0_0_0() { return cOwnedExpressionExpCSParserRuleCall_0_0_0; }

		//('..' ownedLastExpression=ExpCS)?
		public Group getGroup_0_1() { return cGroup_0_1; }

		//'..'
		public Keyword getFullStopFullStopKeyword_0_1_0() { return cFullStopFullStopKeyword_0_1_0; }

		//ownedLastExpression=ExpCS
		public Assignment getOwnedLastExpressionAssignment_0_1_1() { return cOwnedLastExpressionAssignment_0_1_1; }

		//ExpCS
		public RuleCall getOwnedLastExpressionExpCSParserRuleCall_0_1_1_0() { return cOwnedLastExpressionExpCSParserRuleCall_0_1_1_0; }

		//ownedExpression=PatternExpCS
		public Assignment getOwnedExpressionAssignment_1() { return cOwnedExpressionAssignment_1; }

		//PatternExpCS
		public RuleCall getOwnedExpressionPatternExpCSParserRuleCall_1_0() { return cOwnedExpressionPatternExpCSParserRuleCall_1_0; }
	}

	public class CollectionPatternCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionPatternCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedTypeCollectionTypeCSParserRuleCall_0_0 = (RuleCall)cOwnedTypeAssignment_0.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cOwnedPartsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cOwnedPartsPatternExpCSParserRuleCall_2_0_0 = (RuleCall)cOwnedPartsAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cOwnedPartsAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cOwnedPartsPatternExpCSParserRuleCall_2_1_1_0 = (RuleCall)cOwnedPartsAssignment_2_1_1.eContents().get(0);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Keyword cPlusSignPlusSignKeyword_2_2_0 = (Keyword)cGroup_2_2.eContents().get(0);
		private final Assignment cRestVariableNameAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cRestVariableNameIdentifierParserRuleCall_2_2_1_0 = (RuleCall)cRestVariableNameAssignment_2_2_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);

		//CollectionPatternCS:
		//	ownedType=CollectionTypeCS
		//	'{' (ownedParts+=PatternExpCS (',' ownedParts+=PatternExpCS)* ('++' restVariableName=Identifier))?
		//	'}';
		@Override public ParserRule getRule() { return rule; }

		//ownedType=CollectionTypeCS
		//'{' (ownedParts+=PatternExpCS (',' ownedParts+=PatternExpCS)* ('++' restVariableName=Identifier))?
		//'}'
		public Group getGroup() { return cGroup; }

		//ownedType=CollectionTypeCS
		public Assignment getOwnedTypeAssignment_0() { return cOwnedTypeAssignment_0; }

		//CollectionTypeCS
		public RuleCall getOwnedTypeCollectionTypeCSParserRuleCall_0_0() { return cOwnedTypeCollectionTypeCSParserRuleCall_0_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//(ownedParts+=PatternExpCS (',' ownedParts+=PatternExpCS)* ('++' restVariableName=Identifier))?
		public Group getGroup_2() { return cGroup_2; }

		//ownedParts+=PatternExpCS
		public Assignment getOwnedPartsAssignment_2_0() { return cOwnedPartsAssignment_2_0; }

		//PatternExpCS
		public RuleCall getOwnedPartsPatternExpCSParserRuleCall_2_0_0() { return cOwnedPartsPatternExpCSParserRuleCall_2_0_0; }

		//(',' ownedParts+=PatternExpCS)*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//','
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//ownedParts+=PatternExpCS
		public Assignment getOwnedPartsAssignment_2_1_1() { return cOwnedPartsAssignment_2_1_1; }

		//PatternExpCS
		public RuleCall getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0() { return cOwnedPartsPatternExpCSParserRuleCall_2_1_1_0; }

		//('++' restVariableName=Identifier)
		public Group getGroup_2_2() { return cGroup_2_2; }

		//'++'
		public Keyword getPlusSignPlusSignKeyword_2_2_0() { return cPlusSignPlusSignKeyword_2_2_0; }

		//restVariableName=Identifier
		public Assignment getRestVariableNameAssignment_2_2_1() { return cRestVariableNameAssignment_2_2_1; }

		//Identifier
		public RuleCall getRestVariableNameIdentifierParserRuleCall_2_2_1_0() { return cRestVariableNameIdentifierParserRuleCall_2_2_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class ShadowPartCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ShadowPartCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Assignment cReferredPropertyAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final CrossReference cReferredPropertyPropertyCrossReference_0_0_0 = (CrossReference)cReferredPropertyAssignment_0_0.eContents().get(0);
		private final RuleCall cReferredPropertyPropertyUnrestrictedNameParserRuleCall_0_0_0_1 = (RuleCall)cReferredPropertyPropertyCrossReference_0_0_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cOwnedInitExpressionAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final Alternatives cOwnedInitExpressionAlternatives_0_2_0 = (Alternatives)cOwnedInitExpressionAssignment_0_2.eContents().get(0);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_0_2_0_0 = (RuleCall)cOwnedInitExpressionAlternatives_0_2_0.eContents().get(0);
		private final RuleCall cOwnedInitExpressionPatternExpCSParserRuleCall_0_2_0_1 = (RuleCall)cOwnedInitExpressionAlternatives_0_2_0.eContents().get(1);
		private final Assignment cOwnedInitExpressionAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cOwnedInitExpressionStringLiteralExpCSParserRuleCall_1_0 = (RuleCall)cOwnedInitExpressionAssignment_1.eContents().get(0);

		//ShadowPartCS:
		//	referredProperty=[pivot::Property|UnrestrictedName] '=' ownedInitExpression=(ExpCS | PatternExpCS) |
		//	ownedInitExpression=StringLiteralExpCS;
		@Override public ParserRule getRule() { return rule; }

		//// PatternPartCS
		//	referredProperty=[pivot::Property|UnrestrictedName] '=' ownedInitExpression=(ExpCS | PatternExpCS) |
		//ownedInitExpression=StringLiteralExpCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//// PatternPartCS
		//	referredProperty=[pivot::Property|UnrestrictedName] '=' ownedInitExpression=(ExpCS | PatternExpCS)
		public Group getGroup_0() { return cGroup_0; }

		//referredProperty=[pivot::Property|UnrestrictedName]
		public Assignment getReferredPropertyAssignment_0_0() { return cReferredPropertyAssignment_0_0; }

		//[pivot::Property|UnrestrictedName]
		public CrossReference getReferredPropertyPropertyCrossReference_0_0_0() { return cReferredPropertyPropertyCrossReference_0_0_0; }

		//UnrestrictedName
		public RuleCall getReferredPropertyPropertyUnrestrictedNameParserRuleCall_0_0_0_1() { return cReferredPropertyPropertyUnrestrictedNameParserRuleCall_0_0_0_1; }

		//'='
		public Keyword getEqualsSignKeyword_0_1() { return cEqualsSignKeyword_0_1; }

		//ownedInitExpression=(ExpCS | PatternExpCS)
		public Assignment getOwnedInitExpressionAssignment_0_2() { return cOwnedInitExpressionAssignment_0_2; }

		//(ExpCS | PatternExpCS)
		public Alternatives getOwnedInitExpressionAlternatives_0_2_0() { return cOwnedInitExpressionAlternatives_0_2_0; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_0_2_0_0() { return cOwnedInitExpressionExpCSParserRuleCall_0_2_0_0; }

		//PatternExpCS
		public RuleCall getOwnedInitExpressionPatternExpCSParserRuleCall_0_2_0_1() { return cOwnedInitExpressionPatternExpCSParserRuleCall_0_2_0_1; }

		//ownedInitExpression=StringLiteralExpCS
		public Assignment getOwnedInitExpressionAssignment_1() { return cOwnedInitExpressionAssignment_1; }

		//StringLiteralExpCS
		public RuleCall getOwnedInitExpressionStringLiteralExpCSParserRuleCall_1_0() { return cOwnedInitExpressionStringLiteralExpCSParserRuleCall_1_0; }
	}

	public class PatternExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPatternVariableNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cPatternVariableNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cPatternVariableNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedPatternTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedPatternTypeTypeExpCSParserRuleCall_2_0 = (RuleCall)cOwnedPatternTypeAssignment_2.eContents().get(0);

		//PatternExpCS:
		//	patternVariableName=UnrestrictedName? ':' ownedPatternType=TypeExpCS;
		@Override public ParserRule getRule() { return rule; }

		//patternVariableName=UnrestrictedName? ':' ownedPatternType=TypeExpCS
		public Group getGroup() { return cGroup; }

		//patternVariableName=UnrestrictedName?
		public Assignment getPatternVariableNameAssignment_0() { return cPatternVariableNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getPatternVariableNameUnrestrictedNameParserRuleCall_0_0() { return cPatternVariableNameUnrestrictedNameParserRuleCall_0_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//ownedPatternType=TypeExpCS
		public Assignment getOwnedPatternTypeAssignment_2() { return cOwnedPatternTypeAssignment_2; }

		//TypeExpCS
		public RuleCall getOwnedPatternTypeTypeExpCSParserRuleCall_2_0() { return cOwnedPatternTypeTypeExpCSParserRuleCall_2_0; }
	}

	public class LambdaLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.LambdaLiteralExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLambdaKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedExpressionCSAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedExpressionCSExpCSParserRuleCall_2_0 = (RuleCall)cOwnedExpressionCSAssignment_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);

		//LambdaLiteralExpCS:
		//	'Lambda' '{' ownedExpressionCS=ExpCS '}';
		@Override public ParserRule getRule() { return rule; }

		//'Lambda' '{' ownedExpressionCS=ExpCS '}'
		public Group getGroup() { return cGroup; }

		//'Lambda'
		public Keyword getLambdaKeyword_0() { return cLambdaKeyword_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//ownedExpressionCS=ExpCS
		public Assignment getOwnedExpressionCSAssignment_2() { return cOwnedExpressionCSAssignment_2; }

		//ExpCS
		public RuleCall getOwnedExpressionCSExpCSParserRuleCall_2_0() { return cOwnedExpressionCSExpCSParserRuleCall_2_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class MapLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapLiteralExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedTypeMapTypeCSParserRuleCall_0_0 = (RuleCall)cOwnedTypeAssignment_0.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cOwnedPartsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0 = (RuleCall)cOwnedPartsAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cOwnedPartsAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0 = (RuleCall)cOwnedPartsAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);

		//MapLiteralExpCS:
		//	ownedType=MapTypeCS '{' (ownedParts+=MapLiteralPartCS (',' ownedParts+=MapLiteralPartCS)*)? '}';
		@Override public ParserRule getRule() { return rule; }

		//ownedType=MapTypeCS '{' (ownedParts+=MapLiteralPartCS (',' ownedParts+=MapLiteralPartCS)*)? '}'
		public Group getGroup() { return cGroup; }

		//ownedType=MapTypeCS
		public Assignment getOwnedTypeAssignment_0() { return cOwnedTypeAssignment_0; }

		//MapTypeCS
		public RuleCall getOwnedTypeMapTypeCSParserRuleCall_0_0() { return cOwnedTypeMapTypeCSParserRuleCall_0_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//(ownedParts+=MapLiteralPartCS (',' ownedParts+=MapLiteralPartCS)*)?
		public Group getGroup_2() { return cGroup_2; }

		//ownedParts+=MapLiteralPartCS
		public Assignment getOwnedPartsAssignment_2_0() { return cOwnedPartsAssignment_2_0; }

		//MapLiteralPartCS
		public RuleCall getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0() { return cOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0; }

		//(',' ownedParts+=MapLiteralPartCS)*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//','
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//ownedParts+=MapLiteralPartCS
		public Assignment getOwnedPartsAssignment_2_1_1() { return cOwnedPartsAssignment_2_1_1; }

		//MapLiteralPartCS
		public RuleCall getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0() { return cOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class MapLiteralPartCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapLiteralPartCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedKeyExpCSParserRuleCall_0_0 = (RuleCall)cOwnedKeyAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Keyword cWithKeyword_1_0 = (Keyword)cAlternatives_1.eContents().get(0);
		private final Keyword cLessThanSignHyphenMinusKeyword_1_1 = (Keyword)cAlternatives_1.eContents().get(1);
		private final Assignment cOwnedValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedValueExpCSParserRuleCall_2_0 = (RuleCall)cOwnedValueAssignment_2.eContents().get(0);

		//MapLiteralPartCS:
		//	ownedKey=ExpCS ('with' | '<-') ownedValue=ExpCS;
		@Override public ParserRule getRule() { return rule; }

		//ownedKey=ExpCS ('with' | '<-') ownedValue=ExpCS
		public Group getGroup() { return cGroup; }

		//ownedKey=ExpCS
		public Assignment getOwnedKeyAssignment_0() { return cOwnedKeyAssignment_0; }

		//ExpCS
		public RuleCall getOwnedKeyExpCSParserRuleCall_0_0() { return cOwnedKeyExpCSParserRuleCall_0_0; }

		//('with' | '<-')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//'with'
		public Keyword getWithKeyword_1_0() { return cWithKeyword_1_0; }

		//'<-'
		public Keyword getLessThanSignHyphenMinusKeyword_1_1() { return cLessThanSignHyphenMinusKeyword_1_1; }

		//ownedValue=ExpCS
		public Assignment getOwnedValueAssignment_2() { return cOwnedValueAssignment_2; }

		//ExpCS
		public RuleCall getOwnedValueExpCSParserRuleCall_2_0() { return cOwnedValueExpCSParserRuleCall_2_0; }
	}

	public class PrimitiveLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrimitiveLiteralExpCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cNumberLiteralExpCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cStringLiteralExpCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cBooleanLiteralExpCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cUnlimitedNaturalLiteralExpCSParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cInvalidLiteralExpCSParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cNullLiteralExpCSParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);

		//// <- is deprecated see Bug 577614
		//
		//PrimitiveLiteralExpCS:
		//	NumberLiteralExpCS
		//	| StringLiteralExpCS
		//	| BooleanLiteralExpCS
		//	| UnlimitedNaturalLiteralExpCS
		//	| InvalidLiteralExpCS
		//	| NullLiteralExpCS;
		@Override public ParserRule getRule() { return rule; }

		//NumberLiteralExpCS
		//| StringLiteralExpCS
		//| BooleanLiteralExpCS
		//| UnlimitedNaturalLiteralExpCS
		//| InvalidLiteralExpCS
		//| NullLiteralExpCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//NumberLiteralExpCS
		public RuleCall getNumberLiteralExpCSParserRuleCall_0() { return cNumberLiteralExpCSParserRuleCall_0; }

		//StringLiteralExpCS
		public RuleCall getStringLiteralExpCSParserRuleCall_1() { return cStringLiteralExpCSParserRuleCall_1; }

		//BooleanLiteralExpCS
		public RuleCall getBooleanLiteralExpCSParserRuleCall_2() { return cBooleanLiteralExpCSParserRuleCall_2; }

		//UnlimitedNaturalLiteralExpCS
		public RuleCall getUnlimitedNaturalLiteralExpCSParserRuleCall_3() { return cUnlimitedNaturalLiteralExpCSParserRuleCall_3; }

		//InvalidLiteralExpCS
		public RuleCall getInvalidLiteralExpCSParserRuleCall_4() { return cInvalidLiteralExpCSParserRuleCall_4; }

		//NullLiteralExpCS
		public RuleCall getNullLiteralExpCSParserRuleCall_5() { return cNullLiteralExpCSParserRuleCall_5; }
	}

	public class TupleLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TupleLiteralExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTupleKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedPartsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedPartsTupleLiteralPartCSParserRuleCall_2_0 = (RuleCall)cOwnedPartsAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cCommaKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cOwnedPartsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0 = (RuleCall)cOwnedPartsAssignment_3_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//TupleLiteralExpCS:
		//	'Tuple' '{' ownedParts+=TupleLiteralPartCS (',' ownedParts+=TupleLiteralPartCS)* '}';
		@Override public ParserRule getRule() { return rule; }

		//'Tuple' '{' ownedParts+=TupleLiteralPartCS (',' ownedParts+=TupleLiteralPartCS)* '}'
		public Group getGroup() { return cGroup; }

		//'Tuple'
		public Keyword getTupleKeyword_0() { return cTupleKeyword_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//ownedParts+=TupleLiteralPartCS
		public Assignment getOwnedPartsAssignment_2() { return cOwnedPartsAssignment_2; }

		//TupleLiteralPartCS
		public RuleCall getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0() { return cOwnedPartsTupleLiteralPartCSParserRuleCall_2_0; }

		//(',' ownedParts+=TupleLiteralPartCS)*
		public Group getGroup_3() { return cGroup_3; }

		//','
		public Keyword getCommaKeyword_3_0() { return cCommaKeyword_3_0; }

		//ownedParts+=TupleLiteralPartCS
		public Assignment getOwnedPartsAssignment_3_1() { return cOwnedPartsAssignment_3_1; }

		//TupleLiteralPartCS
		public RuleCall getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0() { return cOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}

	public class TupleLiteralPartCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TupleLiteralPartCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_1_1_0 = (RuleCall)cOwnedTypeAssignment_1_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedInitExpressionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_3_0 = (RuleCall)cOwnedInitExpressionAssignment_3.eContents().get(0);

		//TupleLiteralPartCS:
		//	name=UnrestrictedName (':' ownedType=TypeExpCS)? '=' ownedInitExpression=ExpCS;
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName (':' ownedType=TypeExpCS)? '=' ownedInitExpression=ExpCS
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//(':' ownedType=TypeExpCS)?
		public Group getGroup_1() { return cGroup_1; }

		//':'
		public Keyword getColonKeyword_1_0() { return cColonKeyword_1_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_1_1() { return cOwnedTypeAssignment_1_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_1_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_1_1_0; }

		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_3() { return cOwnedInitExpressionAssignment_3; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_3_0() { return cOwnedInitExpressionExpCSParserRuleCall_3_0; }
	}

	public class NumberLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NumberLiteralExpCS");
		private final Assignment cSymbolAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cSymbolNUMBER_LITERALParserRuleCall_0 = (RuleCall)cSymbolAssignment.eContents().get(0);

		//NumberLiteralExpCS:
		//	symbol=NUMBER_LITERAL;
		@Override public ParserRule getRule() { return rule; }

		//symbol=NUMBER_LITERAL
		public Assignment getSymbolAssignment() { return cSymbolAssignment; }

		//NUMBER_LITERAL
		public RuleCall getSymbolNUMBER_LITERALParserRuleCall_0() { return cSymbolNUMBER_LITERALParserRuleCall_0; }
	}

	public class StringLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.StringLiteralExpCS");
		private final Assignment cSegmentsAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cSegmentsStringLiteralParserRuleCall_0 = (RuleCall)cSegmentsAssignment.eContents().get(0);

		//StringLiteralExpCS:
		//	segments+=StringLiteral+;
		@Override public ParserRule getRule() { return rule; }

		//segments+=StringLiteral+
		public Assignment getSegmentsAssignment() { return cSegmentsAssignment; }

		//StringLiteral
		public RuleCall getSegmentsStringLiteralParserRuleCall_0() { return cSegmentsStringLiteralParserRuleCall_0; }
	}

	public class BooleanLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.BooleanLiteralExpCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cSymbolAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final Keyword cSymbolTrueKeyword_0_0 = (Keyword)cSymbolAssignment_0.eContents().get(0);
		private final Assignment cSymbolAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final Keyword cSymbolFalseKeyword_1_0 = (Keyword)cSymbolAssignment_1.eContents().get(0);

		//BooleanLiteralExpCS:
		//	symbol='true'
		//	| symbol='false';
		@Override public ParserRule getRule() { return rule; }

		//symbol='true'
		//| symbol='false'
		public Alternatives getAlternatives() { return cAlternatives; }

		//symbol='true'
		public Assignment getSymbolAssignment_0() { return cSymbolAssignment_0; }

		//'true'
		public Keyword getSymbolTrueKeyword_0_0() { return cSymbolTrueKeyword_0_0; }

		//symbol='false'
		public Assignment getSymbolAssignment_1() { return cSymbolAssignment_1; }

		//'false'
		public Keyword getSymbolFalseKeyword_1_0() { return cSymbolFalseKeyword_1_0; }
	}

	public class UnlimitedNaturalLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnlimitedNaturalLiteralExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cUnlimitedNaturalLiteralExpCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cAsteriskKeyword_1 = (Keyword)cGroup.eContents().get(1);

		//UnlimitedNaturalLiteralExpCS:
		//	{UnlimitedNaturalLiteralExpCS} '*';
		@Override public ParserRule getRule() { return rule; }

		//{UnlimitedNaturalLiteralExpCS} '*'
		public Group getGroup() { return cGroup; }

		//{UnlimitedNaturalLiteralExpCS}
		public Action getUnlimitedNaturalLiteralExpCSAction_0() { return cUnlimitedNaturalLiteralExpCSAction_0; }

		//'*'
		public Keyword getAsteriskKeyword_1() { return cAsteriskKeyword_1; }
	}

	public class InvalidLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.InvalidLiteralExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cInvalidLiteralExpCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cInvalidKeyword_1 = (Keyword)cGroup.eContents().get(1);

		//InvalidLiteralExpCS:
		//	{InvalidLiteralExpCS} 'invalid';
		@Override public ParserRule getRule() { return rule; }

		//{InvalidLiteralExpCS} 'invalid'
		public Group getGroup() { return cGroup; }

		//{InvalidLiteralExpCS}
		public Action getInvalidLiteralExpCSAction_0() { return cInvalidLiteralExpCSAction_0; }

		//'invalid'
		public Keyword getInvalidKeyword_1() { return cInvalidKeyword_1; }
	}

	public class NullLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NullLiteralExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cNullLiteralExpCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNullKeyword_1 = (Keyword)cGroup.eContents().get(1);

		//NullLiteralExpCS:
		//	{NullLiteralExpCS} 'null';
		@Override public ParserRule getRule() { return rule; }

		//{NullLiteralExpCS} 'null'
		public Group getGroup() { return cGroup; }

		//{NullLiteralExpCS}
		public Action getNullLiteralExpCSAction_0() { return cNullLiteralExpCSAction_0; }

		//'null'
		public Keyword getNullKeyword_1() { return cNullKeyword_1; }
	}

	public class TypeLiteralCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeLiteralCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cPrimitiveTypeCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cCollectionTypeCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cMapTypeCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cTupleTypeCSParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);

		//TypeLiteralCS base::TypedRefCS:
		//	PrimitiveTypeCS
		//	| CollectionTypeCS
		//	| MapTypeCS
		//	| TupleTypeCS;
		@Override public ParserRule getRule() { return rule; }

		//PrimitiveTypeCS
		//| CollectionTypeCS
		//| MapTypeCS
		//| TupleTypeCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//PrimitiveTypeCS
		public RuleCall getPrimitiveTypeCSParserRuleCall_0() { return cPrimitiveTypeCSParserRuleCall_0; }

		//CollectionTypeCS
		public RuleCall getCollectionTypeCSParserRuleCall_1() { return cCollectionTypeCSParserRuleCall_1; }

		//MapTypeCS
		public RuleCall getMapTypeCSParserRuleCall_2() { return cMapTypeCSParserRuleCall_2; }

		//TupleTypeCS
		public RuleCall getTupleTypeCSParserRuleCall_3() { return cTupleTypeCSParserRuleCall_3; }
	}

	public class TypeLiteralWithMultiplicityCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeLiteralWithMultiplicityCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cTypeLiteralCSParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Assignment cOwnedMultiplicityAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedMultiplicityMultiplicityCSParserRuleCall_1_0 = (RuleCall)cOwnedMultiplicityAssignment_1.eContents().get(0);

		//TypeLiteralWithMultiplicityCS base::TypedRefCS:
		//	TypeLiteralCS ownedMultiplicity=MultiplicityCS?;
		@Override public ParserRule getRule() { return rule; }

		//TypeLiteralCS ownedMultiplicity=MultiplicityCS?
		public Group getGroup() { return cGroup; }

		//TypeLiteralCS
		public RuleCall getTypeLiteralCSParserRuleCall_0() { return cTypeLiteralCSParserRuleCall_0; }

		//ownedMultiplicity=MultiplicityCS?
		public Assignment getOwnedMultiplicityAssignment_1() { return cOwnedMultiplicityAssignment_1; }

		//MultiplicityCS
		public RuleCall getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0() { return cOwnedMultiplicityMultiplicityCSParserRuleCall_1_0; }
	}

	public class TypeLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeLiteralExpCS");
		private final Assignment cOwnedTypeAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0 = (RuleCall)cOwnedTypeAssignment.eContents().get(0);

		//TypeLiteralExpCS:
		//	ownedType=TypeLiteralWithMultiplicityCS;
		@Override public ParserRule getRule() { return rule; }

		//ownedType=TypeLiteralWithMultiplicityCS
		public Assignment getOwnedTypeAssignment() { return cOwnedTypeAssignment; }

		//TypeLiteralWithMultiplicityCS
		public RuleCall getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0() { return cOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0; }
	}

	public class TypeNameExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeNameExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedPathNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedPathNamePathNameCSParserRuleCall_0_0 = (RuleCall)cOwnedPathNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cOwnedCurlyBracketedClauseAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0 = (RuleCall)cOwnedCurlyBracketedClauseAssignment_1_0.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cOwnedPatternGuardAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cOwnedPatternGuardExpCSParserRuleCall_1_1_1_0 = (RuleCall)cOwnedPatternGuardAssignment_1_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_1_1_2 = (Keyword)cGroup_1_1.eContents().get(2);

		//TypeNameExpCS:
		//	ownedPathName=PathNameCS (ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' ownedPatternGuard=ExpCS '}')?)?;
		@Override public ParserRule getRule() { return rule; }

		//ownedPathName=PathNameCS (ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' ownedPatternGuard=ExpCS '}')?)?
		public Group getGroup() { return cGroup; }

		//ownedPathName=PathNameCS
		public Assignment getOwnedPathNameAssignment_0() { return cOwnedPathNameAssignment_0; }

		//PathNameCS
		public RuleCall getOwnedPathNamePathNameCSParserRuleCall_0_0() { return cOwnedPathNamePathNameCSParserRuleCall_0_0; }

		//(ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' ownedPatternGuard=ExpCS '}')?)?
		public Group getGroup_1() { return cGroup_1; }

		//ownedCurlyBracketedClause=CurlyBracketedClauseCS
		public Assignment getOwnedCurlyBracketedClauseAssignment_1_0() { return cOwnedCurlyBracketedClauseAssignment_1_0; }

		//CurlyBracketedClauseCS
		public RuleCall getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0() { return cOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0; }

		//('{' ownedPatternGuard=ExpCS '}')?
		public Group getGroup_1_1() { return cGroup_1_1; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_1_1_0() { return cLeftCurlyBracketKeyword_1_1_0; }

		//ownedPatternGuard=ExpCS
		public Assignment getOwnedPatternGuardAssignment_1_1_1() { return cOwnedPatternGuardAssignment_1_1_1; }

		//ExpCS
		public RuleCall getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0() { return cOwnedPatternGuardExpCSParserRuleCall_1_1_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_1_1_2() { return cRightCurlyBracketKeyword_1_1_2; }
	}

	public class TypeExpWithoutMultiplicityCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpWithoutMultiplicityCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTypeNameExpCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTypeLiteralCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cCollectionPatternCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);

		//TypeExpWithoutMultiplicityCS base::TypedRefCS:
		//	TypeNameExpCS | TypeLiteralCS | CollectionPatternCS;
		@Override public ParserRule getRule() { return rule; }

		//TypeNameExpCS | TypeLiteralCS | CollectionPatternCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//TypeNameExpCS
		public RuleCall getTypeNameExpCSParserRuleCall_0() { return cTypeNameExpCSParserRuleCall_0; }

		//TypeLiteralCS
		public RuleCall getTypeLiteralCSParserRuleCall_1() { return cTypeLiteralCSParserRuleCall_1; }

		//CollectionPatternCS
		public RuleCall getCollectionPatternCSParserRuleCall_2() { return cCollectionPatternCSParserRuleCall_2; }
	}

	public class TypeExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cTypeExpWithoutMultiplicityCSParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Assignment cOwnedMultiplicityAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedMultiplicityMultiplicityCSParserRuleCall_1_0 = (RuleCall)cOwnedMultiplicityAssignment_1.eContents().get(0);

		//TypeExpCS base::TypedRefCS:
		//	TypeExpWithoutMultiplicityCS ownedMultiplicity=MultiplicityCS?;
		@Override public ParserRule getRule() { return rule; }

		//TypeExpWithoutMultiplicityCS ownedMultiplicity=MultiplicityCS?
		public Group getGroup() { return cGroup; }

		//TypeExpWithoutMultiplicityCS
		public RuleCall getTypeExpWithoutMultiplicityCSParserRuleCall_0() { return cTypeExpWithoutMultiplicityCSParserRuleCall_0; }

		//ownedMultiplicity=MultiplicityCS?
		public Assignment getOwnedMultiplicityAssignment_1() { return cOwnedMultiplicityAssignment_1; }

		//MultiplicityCS
		public RuleCall getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0() { return cOwnedMultiplicityMultiplicityCSParserRuleCall_1_0; }
	}

	public class ExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final RuleCall cPrefixedPrimaryExpCSParserRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Action cInfixExpCSOwnedLeftAction_0_1_0 = (Action)cGroup_0_1.eContents().get(0);
		private final Assignment cNameAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final RuleCall cNameBinaryOperatorNameParserRuleCall_0_1_1_0 = (RuleCall)cNameAssignment_0_1_1.eContents().get(0);
		private final Assignment cOwnedRightAssignment_0_1_2 = (Assignment)cGroup_0_1.eContents().get(2);
		private final RuleCall cOwnedRightExpCSParserRuleCall_0_1_2_0 = (RuleCall)cOwnedRightAssignment_0_1_2.eContents().get(0);
		private final RuleCall cPrefixedLetExpCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		////---------------------------------------------------------------------
		////  Expressions
		////---------------------------------------------------------------------
		//// An ExpCS permits a LetExpCS only in the final term to ensure
		////  that let is right associative, whereas infix operators are left associative.
		////   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4
		//// is
		////   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
		///* An expression elaborates a prefixed expression with zero or more binary operator and expression suffixes.
		// * An optionally prefixed let expression is permitted except when suffixed with further expressions.*/
		//ExpCS:
		//	PrefixedPrimaryExpCS ({InfixExpCS.ownedLeft=current} name=BinaryOperatorName ownedRight=ExpCS)? | PrefixedLetExpCS;
		@Override public ParserRule getRule() { return rule; }

		////	({InfixExpCS} ownedSource=PrefixedExpCS name=BinaryOperatorName ownedArgument=ExpCS)
		////| 	PrefixedExpCS
		//// the above takes exponential or worse time for backtracking, below is fast
		//	PrefixedPrimaryExpCS ({InfixExpCS.ownedLeft=current} name=BinaryOperatorName ownedRight=ExpCS)? | PrefixedLetExpCS
		public Alternatives getAlternatives() { return cAlternatives; }

		////	({InfixExpCS} ownedSource=PrefixedExpCS name=BinaryOperatorName ownedArgument=ExpCS)
		////| 	PrefixedExpCS
		//// the above takes exponential or worse time for backtracking, below is fast
		//	PrefixedPrimaryExpCS ({InfixExpCS.ownedLeft=current} name=BinaryOperatorName ownedRight=ExpCS)?
		public Group getGroup_0() { return cGroup_0; }

		//PrefixedPrimaryExpCS
		public RuleCall getPrefixedPrimaryExpCSParserRuleCall_0_0() { return cPrefixedPrimaryExpCSParserRuleCall_0_0; }

		//({InfixExpCS.ownedLeft=current} name=BinaryOperatorName ownedRight=ExpCS)?
		public Group getGroup_0_1() { return cGroup_0_1; }

		//{InfixExpCS.ownedLeft=current}
		public Action getInfixExpCSOwnedLeftAction_0_1_0() { return cInfixExpCSOwnedLeftAction_0_1_0; }

		//name=BinaryOperatorName
		public Assignment getNameAssignment_0_1_1() { return cNameAssignment_0_1_1; }

		//BinaryOperatorName
		public RuleCall getNameBinaryOperatorNameParserRuleCall_0_1_1_0() { return cNameBinaryOperatorNameParserRuleCall_0_1_1_0; }

		//ownedRight=ExpCS
		public Assignment getOwnedRightAssignment_0_1_2() { return cOwnedRightAssignment_0_1_2; }

		//ExpCS
		public RuleCall getOwnedRightExpCSParserRuleCall_0_1_2_0() { return cOwnedRightExpCSParserRuleCall_0_1_2_0; }

		//PrefixedLetExpCS
		public RuleCall getPrefixedLetExpCSParserRuleCall_1() { return cPrefixedLetExpCSParserRuleCall_1; }
	}

	public class PrefixedLetExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrefixedLetExpCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cPrefixExpCSAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cNameAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cNameUnaryOperatorNameParserRuleCall_0_1_0 = (RuleCall)cNameAssignment_0_1.eContents().get(0);
		private final Assignment cOwnedRightAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0 = (RuleCall)cOwnedRightAssignment_0_2.eContents().get(0);
		private final RuleCall cLetExpCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		///* A prefixed let expression elaborates a let expression with zero or more unary prefix operators. */
		//PrefixedLetExpCS ExpCS:
		//	{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedLetExpCS | LetExpCS;
		@Override public ParserRule getRule() { return rule; }

		//{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedLetExpCS | LetExpCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedLetExpCS
		public Group getGroup_0() { return cGroup_0; }

		//{PrefixExpCS}
		public Action getPrefixExpCSAction_0_0() { return cPrefixExpCSAction_0_0; }

		//name=UnaryOperatorName
		public Assignment getNameAssignment_0_1() { return cNameAssignment_0_1; }

		//UnaryOperatorName
		public RuleCall getNameUnaryOperatorNameParserRuleCall_0_1_0() { return cNameUnaryOperatorNameParserRuleCall_0_1_0; }

		//ownedRight=PrefixedLetExpCS
		public Assignment getOwnedRightAssignment_0_2() { return cOwnedRightAssignment_0_2; }

		//PrefixedLetExpCS
		public RuleCall getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0() { return cOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0; }

		//LetExpCS
		public RuleCall getLetExpCSParserRuleCall_1() { return cLetExpCSParserRuleCall_1; }
	}

	public class PrefixedPrimaryExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrefixedPrimaryExpCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cPrefixExpCSAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cNameAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cNameUnaryOperatorNameParserRuleCall_0_1_0 = (RuleCall)cNameAssignment_0_1.eContents().get(0);
		private final Assignment cOwnedRightAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0 = (RuleCall)cOwnedRightAssignment_0_2.eContents().get(0);
		private final RuleCall cPrimaryExpCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		///* A prefixed primary expression elaborates a primary expression with zero or more unary prefix operators. */
		//PrefixedPrimaryExpCS ExpCS:
		//	{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS | PrimaryExpCS;
		@Override public ParserRule getRule() { return rule; }

		//{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS | PrimaryExpCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS
		public Group getGroup_0() { return cGroup_0; }

		//{PrefixExpCS}
		public Action getPrefixExpCSAction_0_0() { return cPrefixExpCSAction_0_0; }

		//name=UnaryOperatorName
		public Assignment getNameAssignment_0_1() { return cNameAssignment_0_1; }

		//UnaryOperatorName
		public RuleCall getNameUnaryOperatorNameParserRuleCall_0_1_0() { return cNameUnaryOperatorNameParserRuleCall_0_1_0; }

		//ownedRight=PrefixedPrimaryExpCS
		public Assignment getOwnedRightAssignment_0_2() { return cOwnedRightAssignment_0_2; }

		//PrefixedPrimaryExpCS
		public RuleCall getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0() { return cOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0; }

		//PrimaryExpCS
		public RuleCall getPrimaryExpCSParserRuleCall_1() { return cPrimaryExpCSParserRuleCall_1; }
	}

	public class PrimaryExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrimaryExpCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cNestedExpCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cIfExpCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cSelfExpCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cPrimitiveLiteralExpCSParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cTupleLiteralExpCSParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cMapLiteralExpCSParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cCollectionLiteralExpCSParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cLambdaLiteralExpCSParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		private final RuleCall cTypeLiteralExpCSParserRuleCall_8 = (RuleCall)cAlternatives.eContents().get(8);
		private final RuleCall cNameExpCSParserRuleCall_9 = (RuleCall)cAlternatives.eContents().get(9);

		///* A primary expression identifies the basic expressions from which more complex expressions may be constructed. */
		//PrimaryExpCS ExpCS:
		//	NestedExpCS
		//	| IfExpCS
		//	| SelfExpCS
		//	| PrimitiveLiteralExpCS
		//	| TupleLiteralExpCS
		//	| MapLiteralExpCS
		//	| CollectionLiteralExpCS
		//	| LambdaLiteralExpCS
		//	| TypeLiteralExpCS
		//	| NameExpCS;
		@Override public ParserRule getRule() { return rule; }

		//NestedExpCS
		//| IfExpCS
		//| SelfExpCS
		//| PrimitiveLiteralExpCS
		//| TupleLiteralExpCS
		//| MapLiteralExpCS
		//| CollectionLiteralExpCS
		//| LambdaLiteralExpCS
		//| TypeLiteralExpCS
		//| NameExpCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//NestedExpCS
		public RuleCall getNestedExpCSParserRuleCall_0() { return cNestedExpCSParserRuleCall_0; }

		//IfExpCS
		public RuleCall getIfExpCSParserRuleCall_1() { return cIfExpCSParserRuleCall_1; }

		//SelfExpCS
		public RuleCall getSelfExpCSParserRuleCall_2() { return cSelfExpCSParserRuleCall_2; }

		//PrimitiveLiteralExpCS
		public RuleCall getPrimitiveLiteralExpCSParserRuleCall_3() { return cPrimitiveLiteralExpCSParserRuleCall_3; }

		//TupleLiteralExpCS
		public RuleCall getTupleLiteralExpCSParserRuleCall_4() { return cTupleLiteralExpCSParserRuleCall_4; }

		//MapLiteralExpCS
		public RuleCall getMapLiteralExpCSParserRuleCall_5() { return cMapLiteralExpCSParserRuleCall_5; }

		//CollectionLiteralExpCS
		public RuleCall getCollectionLiteralExpCSParserRuleCall_6() { return cCollectionLiteralExpCSParserRuleCall_6; }

		//LambdaLiteralExpCS
		public RuleCall getLambdaLiteralExpCSParserRuleCall_7() { return cLambdaLiteralExpCSParserRuleCall_7; }

		//TypeLiteralExpCS
		public RuleCall getTypeLiteralExpCSParserRuleCall_8() { return cTypeLiteralExpCSParserRuleCall_8; }

		//NameExpCS
		public RuleCall getNameExpCSParserRuleCall_9() { return cNameExpCSParserRuleCall_9; }
	}

	public class NameExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NameExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedPathNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedPathNamePathNameCSParserRuleCall_0_0 = (RuleCall)cOwnedPathNameAssignment_0.eContents().get(0);
		private final Assignment cOwnedSquareBracketedClausesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0 = (RuleCall)cOwnedSquareBracketedClausesAssignment_1.eContents().get(0);
		private final Assignment cOwnedRoundBracketedClauseAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0 = (RuleCall)cOwnedRoundBracketedClauseAssignment_2.eContents().get(0);
		private final Assignment cOwnedCurlyBracketedClauseAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0 = (RuleCall)cOwnedCurlyBracketedClauseAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Assignment cIsPreAssignment_4_0 = (Assignment)cGroup_4.eContents().get(0);
		private final Keyword cIsPreCommercialAtKeyword_4_0_0 = (Keyword)cIsPreAssignment_4_0.eContents().get(0);
		private final Keyword cPreKeyword_4_1 = (Keyword)cGroup_4.eContents().get(1);

		///* A name expression is a generalised rule for expressions that start with a name and which may be followed by square, round or
		// * curly bracket clauses and optionally an @pre as well.*/
		//NameExpCS:
		//	ownedPathName=PathNameCS ownedSquareBracketedClauses+=SquareBracketedClauseCS*
		//	ownedRoundBracketedClause=RoundBracketedClauseCS? ownedCurlyBracketedClause=CurlyBracketedClauseCS? (isPre?='@'
		//	'pre')?;
		@Override public ParserRule getRule() { return rule; }

		//ownedPathName=PathNameCS ownedSquareBracketedClauses+=SquareBracketedClauseCS*
		//ownedRoundBracketedClause=RoundBracketedClauseCS? ownedCurlyBracketedClause=CurlyBracketedClauseCS? (isPre?='@' 'pre')?
		public Group getGroup() { return cGroup; }

		//ownedPathName=PathNameCS
		public Assignment getOwnedPathNameAssignment_0() { return cOwnedPathNameAssignment_0; }

		//PathNameCS
		public RuleCall getOwnedPathNamePathNameCSParserRuleCall_0_0() { return cOwnedPathNamePathNameCSParserRuleCall_0_0; }

		//ownedSquareBracketedClauses+=SquareBracketedClauseCS*
		public Assignment getOwnedSquareBracketedClausesAssignment_1() { return cOwnedSquareBracketedClausesAssignment_1; }

		//SquareBracketedClauseCS
		public RuleCall getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0() { return cOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0; }

		//ownedRoundBracketedClause=RoundBracketedClauseCS?
		public Assignment getOwnedRoundBracketedClauseAssignment_2() { return cOwnedRoundBracketedClauseAssignment_2; }

		//RoundBracketedClauseCS
		public RuleCall getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0() { return cOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0; }

		//ownedCurlyBracketedClause=CurlyBracketedClauseCS?
		public Assignment getOwnedCurlyBracketedClauseAssignment_3() { return cOwnedCurlyBracketedClauseAssignment_3; }

		//CurlyBracketedClauseCS
		public RuleCall getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0() { return cOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0; }

		//(isPre?='@' 'pre')?
		public Group getGroup_4() { return cGroup_4; }

		//isPre?='@'
		public Assignment getIsPreAssignment_4_0() { return cIsPreAssignment_4_0; }

		//'@'
		public Keyword getIsPreCommercialAtKeyword_4_0_0() { return cIsPreCommercialAtKeyword_4_0_0; }

		//'pre'
		public Keyword getPreKeyword_4_1() { return cPreKeyword_4_1; }
	}

	public class CurlyBracketedClauseCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CurlyBracketedClauseCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cCurlyBracketedClauseCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cOwnedPartsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cOwnedPartsShadowPartCSParserRuleCall_2_0_0 = (RuleCall)cOwnedPartsAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cOwnedPartsAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cOwnedPartsShadowPartCSParserRuleCall_2_1_1_0 = (RuleCall)cOwnedPartsAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);

		///* A curly bracket clause is a generalized rule for the literal arguments of collections, maps, tuples and shadows.*/
		//CurlyBracketedClauseCS:
		//	{CurlyBracketedClauseCS} '{' (ownedParts+=ShadowPartCS (',' ownedParts+=ShadowPartCS)*)? '}';
		@Override public ParserRule getRule() { return rule; }

		//{CurlyBracketedClauseCS} '{' (ownedParts+=ShadowPartCS (',' ownedParts+=ShadowPartCS)*)? '}'
		public Group getGroup() { return cGroup; }

		//{CurlyBracketedClauseCS}
		public Action getCurlyBracketedClauseCSAction_0() { return cCurlyBracketedClauseCSAction_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//(ownedParts+=ShadowPartCS (',' ownedParts+=ShadowPartCS)*)?
		public Group getGroup_2() { return cGroup_2; }

		//ownedParts+=ShadowPartCS
		public Assignment getOwnedPartsAssignment_2_0() { return cOwnedPartsAssignment_2_0; }

		//ShadowPartCS
		public RuleCall getOwnedPartsShadowPartCSParserRuleCall_2_0_0() { return cOwnedPartsShadowPartCSParserRuleCall_2_0_0; }

		//(',' ownedParts+=ShadowPartCS)*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//','
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//ownedParts+=ShadowPartCS
		public Assignment getOwnedPartsAssignment_2_1_1() { return cOwnedPartsAssignment_2_1_1; }

		//ShadowPartCS
		public RuleCall getOwnedPartsShadowPartCSParserRuleCall_2_1_1_0() { return cOwnedPartsShadowPartCSParserRuleCall_2_1_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class RoundBracketedClauseCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.RoundBracketedClauseCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRoundBracketedClauseCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cOwnedArgumentsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0 = (RuleCall)cOwnedArgumentsAssignment_2_0.eContents().get(0);
		private final Assignment cOwnedArgumentsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final Alternatives cOwnedArgumentsAlternatives_2_1_0 = (Alternatives)cOwnedArgumentsAssignment_2_1.eContents().get(0);
		private final RuleCall cOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0_0 = (RuleCall)cOwnedArgumentsAlternatives_2_1_0.eContents().get(0);
		private final RuleCall cOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_1_0_1 = (RuleCall)cOwnedArgumentsAlternatives_2_1_0.eContents().get(1);
		private final RuleCall cOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_1_0_2 = (RuleCall)cOwnedArgumentsAlternatives_2_1_0.eContents().get(2);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);

		///* A curly bracket clause is a generalized rule for template specialisations and operations arguments.*/
		//RoundBracketedClauseCS:
		//	{RoundBracketedClauseCS} '(' (ownedArguments+=NavigatingArgCS ownedArguments+=(NavigatingCommaArgCS |
		//	NavigatingSemiArgCS | NavigatingBarArgCS)*)? ')';
		@Override public ParserRule getRule() { return rule; }

		//{RoundBracketedClauseCS} '(' (ownedArguments+=NavigatingArgCS ownedArguments+=(NavigatingCommaArgCS |
		//NavigatingSemiArgCS | NavigatingBarArgCS)*)? ')'
		public Group getGroup() { return cGroup; }

		//{RoundBracketedClauseCS}
		public Action getRoundBracketedClauseCSAction_0() { return cRoundBracketedClauseCSAction_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//(ownedArguments+=NavigatingArgCS ownedArguments+=(NavigatingCommaArgCS | NavigatingSemiArgCS | NavigatingBarArgCS)*)?
		public Group getGroup_2() { return cGroup_2; }

		//ownedArguments+=NavigatingArgCS
		public Assignment getOwnedArgumentsAssignment_2_0() { return cOwnedArgumentsAssignment_2_0; }

		//NavigatingArgCS
		public RuleCall getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0() { return cOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0; }

		//ownedArguments+=(NavigatingCommaArgCS | NavigatingSemiArgCS | NavigatingBarArgCS)*
		public Assignment getOwnedArgumentsAssignment_2_1() { return cOwnedArgumentsAssignment_2_1; }

		//(NavigatingCommaArgCS | NavigatingSemiArgCS | NavigatingBarArgCS)
		public Alternatives getOwnedArgumentsAlternatives_2_1_0() { return cOwnedArgumentsAlternatives_2_1_0; }

		//NavigatingCommaArgCS
		public RuleCall getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0_0() { return cOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0_0; }

		//NavigatingSemiArgCS
		public RuleCall getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_1_0_1() { return cOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_1_0_1; }

		//NavigatingBarArgCS
		public RuleCall getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_1_0_2() { return cOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_1_0_2; }

		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class SquareBracketedClauseCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.SquareBracketedClauseCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedTermsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedTermsExpCSParserRuleCall_1_0 = (RuleCall)cOwnedTermsAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cCommaKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedTermsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedTermsExpCSParserRuleCall_2_1_0 = (RuleCall)cOwnedTermsAssignment_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);

		///* A square bracket clause is a generalized rule for association class qualifiers and roles.*/
		//SquareBracketedClauseCS:
		//	'[' ownedTerms+=ExpCS (',' ownedTerms+=ExpCS)* ']';
		@Override public ParserRule getRule() { return rule; }

		//'[' ownedTerms+=ExpCS (',' ownedTerms+=ExpCS)* ']'
		public Group getGroup() { return cGroup; }

		//'['
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }

		//ownedTerms+=ExpCS
		public Assignment getOwnedTermsAssignment_1() { return cOwnedTermsAssignment_1; }

		//ExpCS
		public RuleCall getOwnedTermsExpCSParserRuleCall_1_0() { return cOwnedTermsExpCSParserRuleCall_1_0; }

		//(',' ownedTerms+=ExpCS)*
		public Group getGroup_2() { return cGroup_2; }

		//','
		public Keyword getCommaKeyword_2_0() { return cCommaKeyword_2_0; }

		//ownedTerms+=ExpCS
		public Assignment getOwnedTermsAssignment_2_1() { return cOwnedTermsAssignment_2_1; }

		//ExpCS
		public RuleCall getOwnedTermsExpCSParserRuleCall_2_1_0() { return cOwnedTermsExpCSParserRuleCall_2_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_3() { return cRightSquareBracketKeyword_3; }
	}

	public class NavigatingArgCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Assignment cOwnedNameExpressionAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0 = (RuleCall)cOwnedNameExpressionAssignment_0_0.eContents().get(0);
		private final Alternatives cAlternatives_0_1 = (Alternatives)cGroup_0.eContents().get(1);
		private final Group cGroup_0_1_0 = (Group)cAlternatives_0_1.eContents().get(0);
		private final Alternatives cAlternatives_0_1_0_0 = (Alternatives)cGroup_0_1_0.eContents().get(0);
		private final Keyword cWithKeyword_0_1_0_0_0 = (Keyword)cAlternatives_0_1_0_0.eContents().get(0);
		private final Keyword cLessThanSignHyphenMinusKeyword_0_1_0_0_1 = (Keyword)cAlternatives_0_1_0_0.eContents().get(1);
		private final Assignment cOwnedCoIteratorAssignment_0_1_0_1 = (Assignment)cGroup_0_1_0.eContents().get(1);
		private final RuleCall cOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_0_1_0 = (RuleCall)cOwnedCoIteratorAssignment_0_1_0_1.eContents().get(0);
		private final Group cGroup_0_1_0_2 = (Group)cGroup_0_1_0.eContents().get(2);
		private final Keyword cEqualsSignKeyword_0_1_0_2_0 = (Keyword)cGroup_0_1_0_2.eContents().get(0);
		private final Assignment cOwnedInitExpressionAssignment_0_1_0_2_1 = (Assignment)cGroup_0_1_0_2.eContents().get(1);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0 = (RuleCall)cOwnedInitExpressionAssignment_0_1_0_2_1.eContents().get(0);
		private final Group cGroup_0_1_1 = (Group)cAlternatives_0_1.eContents().get(1);
		private final Keyword cColonKeyword_0_1_1_0 = (Keyword)cGroup_0_1_1.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_0_1_1_1 = (Assignment)cGroup_0_1_1.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_0_1_1_1_0 = (RuleCall)cOwnedTypeAssignment_0_1_1_1.eContents().get(0);
		private final Group cGroup_0_1_1_2 = (Group)cGroup_0_1_1.eContents().get(2);
		private final Alternatives cAlternatives_0_1_1_2_0 = (Alternatives)cGroup_0_1_1_2.eContents().get(0);
		private final Keyword cWithKeyword_0_1_1_2_0_0 = (Keyword)cAlternatives_0_1_1_2_0.eContents().get(0);
		private final Keyword cLessThanSignHyphenMinusKeyword_0_1_1_2_0_1 = (Keyword)cAlternatives_0_1_1_2_0.eContents().get(1);
		private final Assignment cOwnedCoIteratorAssignment_0_1_1_2_1 = (Assignment)cGroup_0_1_1_2.eContents().get(1);
		private final RuleCall cOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_1_2_1_0 = (RuleCall)cOwnedCoIteratorAssignment_0_1_1_2_1.eContents().get(0);
		private final Group cGroup_0_1_1_3 = (Group)cGroup_0_1_1.eContents().get(3);
		private final Keyword cEqualsSignKeyword_0_1_1_3_0 = (Keyword)cGroup_0_1_1_3.eContents().get(0);
		private final Assignment cOwnedInitExpressionAssignment_0_1_1_3_1 = (Assignment)cGroup_0_1_1_3.eContents().get(1);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_0_1_1_3_1_0 = (RuleCall)cOwnedInitExpressionAssignment_0_1_1_3_1.eContents().get(0);
		private final Group cGroup_0_1_2 = (Group)cAlternatives_0_1.eContents().get(2);
		private final Group cGroup_0_1_2_0 = (Group)cGroup_0_1_2.eContents().get(0);
		private final Keyword cColonKeyword_0_1_2_0_0 = (Keyword)cGroup_0_1_2_0.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_0_1_2_0_1 = (Assignment)cGroup_0_1_2_0.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_0_1_2_0_1_0 = (RuleCall)cOwnedTypeAssignment_0_1_2_0_1.eContents().get(0);
		private final Group cGroup_0_1_2_1 = (Group)cGroup_0_1_2.eContents().get(1);
		private final Alternatives cAlternatives_0_1_2_1_0 = (Alternatives)cGroup_0_1_2_1.eContents().get(0);
		private final Keyword cWithKeyword_0_1_2_1_0_0 = (Keyword)cAlternatives_0_1_2_1_0.eContents().get(0);
		private final Keyword cLessThanSignHyphenMinusKeyword_0_1_2_1_0_1 = (Keyword)cAlternatives_0_1_2_1_0.eContents().get(1);
		private final Assignment cOwnedCoIteratorAssignment_0_1_2_1_1 = (Assignment)cGroup_0_1_2_1.eContents().get(1);
		private final RuleCall cOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_2_1_1_0 = (RuleCall)cOwnedCoIteratorAssignment_0_1_2_1_1.eContents().get(0);
		private final Keyword cInKeyword_0_1_2_2 = (Keyword)cGroup_0_1_2.eContents().get(2);
		private final Assignment cOwnedInitExpressionAssignment_0_1_2_3 = (Assignment)cGroup_0_1_2.eContents().get(3);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_0_1_2_3_0 = (RuleCall)cOwnedInitExpressionAssignment_0_1_2_3.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_1_1_0 = (RuleCall)cOwnedTypeAssignment_1_1.eContents().get(0);

		///* A navigating argument is a generalized rule for the first argument in a round bracket clause. This is typically the first operation
		// * parameter or an iterator. */
		//NavigatingArgCS:
		//	ownedNameExpression=NavigatingArgExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS ('='
		//	ownedInitExpression=ExpCS)? | ':' ownedType=TypeExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? ('='
		//	ownedInitExpression=ExpCS)? | (':' ownedType=TypeExpCS)? (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? 'in'
		//	ownedInitExpression=ExpCS)?
		//	| ':' ownedType=TypeExpCS;
		@Override public ParserRule getRule() { return rule; }

		//ownedNameExpression=NavigatingArgExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS ('='
		//ownedInitExpression=ExpCS)? | ':' ownedType=TypeExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? ('='
		//ownedInitExpression=ExpCS)? | (':' ownedType=TypeExpCS)? (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? 'in'
		//ownedInitExpression=ExpCS)?
		//| ':' ownedType=TypeExpCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//ownedNameExpression=NavigatingArgExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS ('='
		//ownedInitExpression=ExpCS)? | ':' ownedType=TypeExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? ('='
		//ownedInitExpression=ExpCS)? | (':' ownedType=TypeExpCS)? (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? 'in'
		//ownedInitExpression=ExpCS)?
		public Group getGroup_0() { return cGroup_0; }

		//ownedNameExpression=NavigatingArgExpCS
		public Assignment getOwnedNameExpressionAssignment_0_0() { return cOwnedNameExpressionAssignment_0_0; }

		//NavigatingArgExpCS
		public RuleCall getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0() { return cOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0; }

		//(('with' | '<-') ownedCoIterator=CoIteratorVariableCS ('=' ownedInitExpression=ExpCS)? | ':' ownedType=TypeExpCS ((
		//'with' | '<-') ownedCoIterator=CoIteratorVariableCS)? ('=' ownedInitExpression=ExpCS)? | (':' ownedType=TypeExpCS)? ((
		//'with' | '<-') ownedCoIterator=CoIteratorVariableCS)? 'in' ownedInitExpression=ExpCS)?
		public Alternatives getAlternatives_0_1() { return cAlternatives_0_1; }

		//('with' | '<-') ownedCoIterator=CoIteratorVariableCS ('=' ownedInitExpression=ExpCS)?
		public Group getGroup_0_1_0() { return cGroup_0_1_0; }

		//('with' | '<-')
		public Alternatives getAlternatives_0_1_0_0() { return cAlternatives_0_1_0_0; }

		//'with'
		public Keyword getWithKeyword_0_1_0_0_0() { return cWithKeyword_0_1_0_0_0; }

		//'<-'
		public Keyword getLessThanSignHyphenMinusKeyword_0_1_0_0_1() { return cLessThanSignHyphenMinusKeyword_0_1_0_0_1; }

		//ownedCoIterator=CoIteratorVariableCS
		public Assignment getOwnedCoIteratorAssignment_0_1_0_1() { return cOwnedCoIteratorAssignment_0_1_0_1; }

		//CoIteratorVariableCS
		public RuleCall getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_0_1_0() { return cOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_0_1_0; }

		//('=' ownedInitExpression=ExpCS)?
		public Group getGroup_0_1_0_2() { return cGroup_0_1_0_2; }

		//'='
		public Keyword getEqualsSignKeyword_0_1_0_2_0() { return cEqualsSignKeyword_0_1_0_2_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_0_1_0_2_1() { return cOwnedInitExpressionAssignment_0_1_0_2_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0; }

		//':' ownedType=TypeExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? ('=' ownedInitExpression=ExpCS)?
		public Group getGroup_0_1_1() { return cGroup_0_1_1; }

		//':'
		public Keyword getColonKeyword_0_1_1_0() { return cColonKeyword_0_1_1_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_0_1_1_1() { return cOwnedTypeAssignment_0_1_1_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_0_1_1_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_0_1_1_1_0; }

		//(('with' | '<-') ownedCoIterator=CoIteratorVariableCS)?
		public Group getGroup_0_1_1_2() { return cGroup_0_1_1_2; }

		//('with' | '<-')
		public Alternatives getAlternatives_0_1_1_2_0() { return cAlternatives_0_1_1_2_0; }

		//'with'
		public Keyword getWithKeyword_0_1_1_2_0_0() { return cWithKeyword_0_1_1_2_0_0; }

		//'<-'
		public Keyword getLessThanSignHyphenMinusKeyword_0_1_1_2_0_1() { return cLessThanSignHyphenMinusKeyword_0_1_1_2_0_1; }

		//ownedCoIterator=CoIteratorVariableCS
		public Assignment getOwnedCoIteratorAssignment_0_1_1_2_1() { return cOwnedCoIteratorAssignment_0_1_1_2_1; }

		//CoIteratorVariableCS
		public RuleCall getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_1_2_1_0() { return cOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_1_2_1_0; }

		//('=' ownedInitExpression=ExpCS)?
		public Group getGroup_0_1_1_3() { return cGroup_0_1_1_3; }

		//'='
		public Keyword getEqualsSignKeyword_0_1_1_3_0() { return cEqualsSignKeyword_0_1_1_3_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_0_1_1_3_1() { return cOwnedInitExpressionAssignment_0_1_1_3_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_0_1_1_3_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_0_1_1_3_1_0; }

		//(':' ownedType=TypeExpCS)? (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? 'in' ownedInitExpression=ExpCS
		public Group getGroup_0_1_2() { return cGroup_0_1_2; }

		//(':' ownedType=TypeExpCS)?
		public Group getGroup_0_1_2_0() { return cGroup_0_1_2_0; }

		//':'
		public Keyword getColonKeyword_0_1_2_0_0() { return cColonKeyword_0_1_2_0_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_0_1_2_0_1() { return cOwnedTypeAssignment_0_1_2_0_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_0_1_2_0_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_0_1_2_0_1_0; }

		//(('with' | '<-') ownedCoIterator=CoIteratorVariableCS)?
		public Group getGroup_0_1_2_1() { return cGroup_0_1_2_1; }

		//('with' | '<-')
		public Alternatives getAlternatives_0_1_2_1_0() { return cAlternatives_0_1_2_1_0; }

		//'with'
		public Keyword getWithKeyword_0_1_2_1_0_0() { return cWithKeyword_0_1_2_1_0_0; }

		//'<-'
		public Keyword getLessThanSignHyphenMinusKeyword_0_1_2_1_0_1() { return cLessThanSignHyphenMinusKeyword_0_1_2_1_0_1; }

		//ownedCoIterator=CoIteratorVariableCS
		public Assignment getOwnedCoIteratorAssignment_0_1_2_1_1() { return cOwnedCoIteratorAssignment_0_1_2_1_1; }

		//CoIteratorVariableCS
		public RuleCall getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_2_1_1_0() { return cOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_2_1_1_0; }

		//'in'
		public Keyword getInKeyword_0_1_2_2() { return cInKeyword_0_1_2_2; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_0_1_2_3() { return cOwnedInitExpressionAssignment_0_1_2_3; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_0_1_2_3_0() { return cOwnedInitExpressionExpCSParserRuleCall_0_1_2_3_0; }

		//':' ownedType=TypeExpCS
		public Group getGroup_1() { return cGroup_1; }

		//':'
		public Keyword getColonKeyword_1_0() { return cColonKeyword_1_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_1_1() { return cOwnedTypeAssignment_1_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_1_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_1_1_0; }
	}

	public class NavigatingBarArgCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingBarArgCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPrefixAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cPrefixVerticalLineKeyword_0_0 = (Keyword)cPrefixAssignment_0.eContents().get(0);
		private final Assignment cOwnedNameExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0 = (RuleCall)cOwnedNameExpressionAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_2_1_0 = (RuleCall)cOwnedTypeAssignment_2_1.eContents().get(0);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Keyword cEqualsSignKeyword_2_2_0 = (Keyword)cGroup_2_2.eContents().get(0);
		private final Assignment cOwnedInitExpressionAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_2_2_1_0 = (RuleCall)cOwnedInitExpressionAssignment_2_2_1.eContents().get(0);

		//// Type-less init is an illegal infix expression
		//
		///* A navigating bar argument is a generalized rule for a bar-prefixed argument in a round bracket clause. This is typically the body of an iteration. */
		//NavigatingBarArgCS NavigatingArgCS:
		//	prefix='|' ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?;
		@Override public ParserRule getRule() { return rule; }

		//prefix='|' ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?
		public Group getGroup() { return cGroup; }

		//prefix='|'
		public Assignment getPrefixAssignment_0() { return cPrefixAssignment_0; }

		//'|'
		public Keyword getPrefixVerticalLineKeyword_0_0() { return cPrefixVerticalLineKeyword_0_0; }

		//ownedNameExpression=NavigatingArgExpCS
		public Assignment getOwnedNameExpressionAssignment_1() { return cOwnedNameExpressionAssignment_1; }

		//NavigatingArgExpCS
		public RuleCall getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0() { return cOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0; }

		//(':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?
		public Group getGroup_2() { return cGroup_2; }

		//':'
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_2_1() { return cOwnedTypeAssignment_2_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_2_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_2_1_0; }

		//('=' ownedInitExpression=ExpCS)?
		public Group getGroup_2_2() { return cGroup_2_2; }

		//'='
		public Keyword getEqualsSignKeyword_2_2_0() { return cEqualsSignKeyword_2_2_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_2_2_1() { return cOwnedInitExpressionAssignment_2_2_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_2_2_1_0; }
	}

	public class NavigatingCommaArgCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingCommaArgCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPrefixAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cPrefixCommaKeyword_0_0 = (Keyword)cPrefixAssignment_0.eContents().get(0);
		private final Assignment cOwnedNameExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0 = (RuleCall)cOwnedNameExpressionAssignment_1.eContents().get(0);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Alternatives cAlternatives_2_0_0 = (Alternatives)cGroup_2_0.eContents().get(0);
		private final Keyword cWithKeyword_2_0_0_0 = (Keyword)cAlternatives_2_0_0.eContents().get(0);
		private final Keyword cLessThanSignHyphenMinusKeyword_2_0_0_1 = (Keyword)cAlternatives_2_0_0.eContents().get(1);
		private final Assignment cOwnedCoIteratorAssignment_2_0_1 = (Assignment)cGroup_2_0.eContents().get(1);
		private final RuleCall cOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_0_1_0 = (RuleCall)cOwnedCoIteratorAssignment_2_0_1.eContents().get(0);
		private final Group cGroup_2_0_2 = (Group)cGroup_2_0.eContents().get(2);
		private final Keyword cEqualsSignKeyword_2_0_2_0 = (Keyword)cGroup_2_0_2.eContents().get(0);
		private final Assignment cOwnedInitExpressionAssignment_2_0_2_1 = (Assignment)cGroup_2_0_2.eContents().get(1);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0 = (RuleCall)cOwnedInitExpressionAssignment_2_0_2_1.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Keyword cColonKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_2_1_1_0 = (RuleCall)cOwnedTypeAssignment_2_1_1.eContents().get(0);
		private final Group cGroup_2_1_2 = (Group)cGroup_2_1.eContents().get(2);
		private final Alternatives cAlternatives_2_1_2_0 = (Alternatives)cGroup_2_1_2.eContents().get(0);
		private final Keyword cWithKeyword_2_1_2_0_0 = (Keyword)cAlternatives_2_1_2_0.eContents().get(0);
		private final Keyword cLessThanSignHyphenMinusKeyword_2_1_2_0_1 = (Keyword)cAlternatives_2_1_2_0.eContents().get(1);
		private final Assignment cOwnedCoIteratorAssignment_2_1_2_1 = (Assignment)cGroup_2_1_2.eContents().get(1);
		private final RuleCall cOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_1_2_1_0 = (RuleCall)cOwnedCoIteratorAssignment_2_1_2_1.eContents().get(0);
		private final Group cGroup_2_1_3 = (Group)cGroup_2_1.eContents().get(3);
		private final Keyword cEqualsSignKeyword_2_1_3_0 = (Keyword)cGroup_2_1_3.eContents().get(0);
		private final Assignment cOwnedInitExpressionAssignment_2_1_3_1 = (Assignment)cGroup_2_1_3.eContents().get(1);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_2_1_3_1_0 = (RuleCall)cOwnedInitExpressionAssignment_2_1_3_1.eContents().get(0);
		private final Group cGroup_2_2 = (Group)cAlternatives_2.eContents().get(2);
		private final Group cGroup_2_2_0 = (Group)cGroup_2_2.eContents().get(0);
		private final Keyword cColonKeyword_2_2_0_0 = (Keyword)cGroup_2_2_0.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_2_2_0_1 = (Assignment)cGroup_2_2_0.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_2_2_0_1_0 = (RuleCall)cOwnedTypeAssignment_2_2_0_1.eContents().get(0);
		private final Group cGroup_2_2_1 = (Group)cGroup_2_2.eContents().get(1);
		private final Alternatives cAlternatives_2_2_1_0 = (Alternatives)cGroup_2_2_1.eContents().get(0);
		private final Keyword cWithKeyword_2_2_1_0_0 = (Keyword)cAlternatives_2_2_1_0.eContents().get(0);
		private final Keyword cLessThanSignHyphenMinusKeyword_2_2_1_0_1 = (Keyword)cAlternatives_2_2_1_0.eContents().get(1);
		private final Assignment cOwnedCoIteratorAssignment_2_2_1_1 = (Assignment)cGroup_2_2_1.eContents().get(1);
		private final RuleCall cOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_2_1_1_0 = (RuleCall)cOwnedCoIteratorAssignment_2_2_1_1.eContents().get(0);
		private final Keyword cInKeyword_2_2_2 = (Keyword)cGroup_2_2.eContents().get(2);
		private final Assignment cOwnedInitExpressionAssignment_2_2_3 = (Assignment)cGroup_2_2.eContents().get(3);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_2_2_3_0 = (RuleCall)cOwnedInitExpressionAssignment_2_2_3.eContents().get(0);

		//// Type-less init is an illegal infix expression
		//
		///* A navigating comma argument is a generalized rule for non-first argument in a round bracket clause. These are typically non-first operation
		// * parameters or a second iterator. */
		//NavigatingCommaArgCS NavigatingArgCS:
		//	prefix=',' ownedNameExpression=NavigatingArgExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS ('='
		//	ownedInitExpression=ExpCS)? | ':' ownedType=TypeExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? ('='
		//	ownedInitExpression=ExpCS)? | (':' ownedType=TypeExpCS)? (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? 'in'
		//	ownedInitExpression=ExpCS)?;
		@Override public ParserRule getRule() { return rule; }

		//prefix=',' ownedNameExpression=NavigatingArgExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS ('='
		//ownedInitExpression=ExpCS)? | ':' ownedType=TypeExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? ('='
		//ownedInitExpression=ExpCS)? | (':' ownedType=TypeExpCS)? (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? 'in'
		//ownedInitExpression=ExpCS)?
		public Group getGroup() { return cGroup; }

		//prefix=','
		public Assignment getPrefixAssignment_0() { return cPrefixAssignment_0; }

		//','
		public Keyword getPrefixCommaKeyword_0_0() { return cPrefixCommaKeyword_0_0; }

		//ownedNameExpression=NavigatingArgExpCS
		public Assignment getOwnedNameExpressionAssignment_1() { return cOwnedNameExpressionAssignment_1; }

		//NavigatingArgExpCS
		public RuleCall getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0() { return cOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0; }

		//(('with' | '<-') ownedCoIterator=CoIteratorVariableCS ('=' ownedInitExpression=ExpCS)? | ':' ownedType=TypeExpCS ((
		//'with' | '<-') ownedCoIterator=CoIteratorVariableCS)? ('=' ownedInitExpression=ExpCS)? | (':' ownedType=TypeExpCS)? ((
		//'with' | '<-') ownedCoIterator=CoIteratorVariableCS)? 'in' ownedInitExpression=ExpCS)?
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//('with' | '<-') ownedCoIterator=CoIteratorVariableCS ('=' ownedInitExpression=ExpCS)?
		public Group getGroup_2_0() { return cGroup_2_0; }

		//('with' | '<-')
		public Alternatives getAlternatives_2_0_0() { return cAlternatives_2_0_0; }

		//'with'
		public Keyword getWithKeyword_2_0_0_0() { return cWithKeyword_2_0_0_0; }

		//'<-'
		public Keyword getLessThanSignHyphenMinusKeyword_2_0_0_1() { return cLessThanSignHyphenMinusKeyword_2_0_0_1; }

		//ownedCoIterator=CoIteratorVariableCS
		public Assignment getOwnedCoIteratorAssignment_2_0_1() { return cOwnedCoIteratorAssignment_2_0_1; }

		//CoIteratorVariableCS
		public RuleCall getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_0_1_0() { return cOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_0_1_0; }

		//('=' ownedInitExpression=ExpCS)?
		public Group getGroup_2_0_2() { return cGroup_2_0_2; }

		//'='
		public Keyword getEqualsSignKeyword_2_0_2_0() { return cEqualsSignKeyword_2_0_2_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_2_0_2_1() { return cOwnedInitExpressionAssignment_2_0_2_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0; }

		//':' ownedType=TypeExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? ('=' ownedInitExpression=ExpCS)?
		public Group getGroup_2_1() { return cGroup_2_1; }

		//':'
		public Keyword getColonKeyword_2_1_0() { return cColonKeyword_2_1_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_2_1_1() { return cOwnedTypeAssignment_2_1_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_2_1_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_2_1_1_0; }

		//(('with' | '<-') ownedCoIterator=CoIteratorVariableCS)?
		public Group getGroup_2_1_2() { return cGroup_2_1_2; }

		//('with' | '<-')
		public Alternatives getAlternatives_2_1_2_0() { return cAlternatives_2_1_2_0; }

		//'with'
		public Keyword getWithKeyword_2_1_2_0_0() { return cWithKeyword_2_1_2_0_0; }

		//'<-'
		public Keyword getLessThanSignHyphenMinusKeyword_2_1_2_0_1() { return cLessThanSignHyphenMinusKeyword_2_1_2_0_1; }

		//ownedCoIterator=CoIteratorVariableCS
		public Assignment getOwnedCoIteratorAssignment_2_1_2_1() { return cOwnedCoIteratorAssignment_2_1_2_1; }

		//CoIteratorVariableCS
		public RuleCall getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_1_2_1_0() { return cOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_1_2_1_0; }

		//('=' ownedInitExpression=ExpCS)?
		public Group getGroup_2_1_3() { return cGroup_2_1_3; }

		//'='
		public Keyword getEqualsSignKeyword_2_1_3_0() { return cEqualsSignKeyword_2_1_3_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_2_1_3_1() { return cOwnedInitExpressionAssignment_2_1_3_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_2_1_3_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_2_1_3_1_0; }

		//(':' ownedType=TypeExpCS)? (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? 'in' ownedInitExpression=ExpCS
		public Group getGroup_2_2() { return cGroup_2_2; }

		//(':' ownedType=TypeExpCS)?
		public Group getGroup_2_2_0() { return cGroup_2_2_0; }

		//':'
		public Keyword getColonKeyword_2_2_0_0() { return cColonKeyword_2_2_0_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_2_2_0_1() { return cOwnedTypeAssignment_2_2_0_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_2_2_0_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_2_2_0_1_0; }

		//(('with' | '<-') ownedCoIterator=CoIteratorVariableCS)?
		public Group getGroup_2_2_1() { return cGroup_2_2_1; }

		//('with' | '<-')
		public Alternatives getAlternatives_2_2_1_0() { return cAlternatives_2_2_1_0; }

		//'with'
		public Keyword getWithKeyword_2_2_1_0_0() { return cWithKeyword_2_2_1_0_0; }

		//'<-'
		public Keyword getLessThanSignHyphenMinusKeyword_2_2_1_0_1() { return cLessThanSignHyphenMinusKeyword_2_2_1_0_1; }

		//ownedCoIterator=CoIteratorVariableCS
		public Assignment getOwnedCoIteratorAssignment_2_2_1_1() { return cOwnedCoIteratorAssignment_2_2_1_1; }

		//CoIteratorVariableCS
		public RuleCall getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_2_1_1_0() { return cOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_2_1_1_0; }

		//'in'
		public Keyword getInKeyword_2_2_2() { return cInKeyword_2_2_2; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_2_2_3() { return cOwnedInitExpressionAssignment_2_2_3; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_2_2_3_0() { return cOwnedInitExpressionExpCSParserRuleCall_2_2_3_0; }
	}

	public class NavigatingSemiArgCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingSemiArgCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPrefixAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cPrefixSemicolonKeyword_0_0 = (Keyword)cPrefixAssignment_0.eContents().get(0);
		private final Assignment cOwnedNameExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0 = (RuleCall)cOwnedNameExpressionAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_2_1_0 = (RuleCall)cOwnedTypeAssignment_2_1.eContents().get(0);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Keyword cEqualsSignKeyword_2_2_0 = (Keyword)cGroup_2_2.eContents().get(0);
		private final Assignment cOwnedInitExpressionAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_2_2_1_0 = (RuleCall)cOwnedInitExpressionAssignment_2_2_1.eContents().get(0);

		//// Type-less init is an illegal infix expression
		//
		///* A navigating semi argument is a generalized rule for a semicolon prefixed argument in a round bracket clause. This is typically an iterate accumulator. */
		//NavigatingSemiArgCS NavigatingArgCS:
		//	prefix=';' ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?;
		@Override public ParserRule getRule() { return rule; }

		//prefix=';' ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?
		public Group getGroup() { return cGroup; }

		//prefix=';'
		public Assignment getPrefixAssignment_0() { return cPrefixAssignment_0; }

		//';'
		public Keyword getPrefixSemicolonKeyword_0_0() { return cPrefixSemicolonKeyword_0_0; }

		//ownedNameExpression=NavigatingArgExpCS
		public Assignment getOwnedNameExpressionAssignment_1() { return cOwnedNameExpressionAssignment_1; }

		//NavigatingArgExpCS
		public RuleCall getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0() { return cOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0; }

		//(':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?
		public Group getGroup_2() { return cGroup_2; }

		//':'
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_2_1() { return cOwnedTypeAssignment_2_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_2_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_2_1_0; }

		//('=' ownedInitExpression=ExpCS)?
		public Group getGroup_2_2() { return cGroup_2_2; }

		//'='
		public Keyword getEqualsSignKeyword_2_2_0() { return cEqualsSignKeyword_2_2_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_2_2_1() { return cOwnedInitExpressionAssignment_2_2_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_2_2_1_0; }
	}

	public class NavigatingArgExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
		private final RuleCall cExpCSParserRuleCall = (RuleCall)rule.eContents().get(1);

		//// Type-less init is an illegal infix expression
		//
		//NavigatingArgExpCS ExpCS:
		//	ExpCS// '?'	-- defined by Complete OCL
		//;
		@Override public ParserRule getRule() { return rule; }

		//// Intended to be overridden
		//	ExpCS
		public RuleCall getExpCSParserRuleCall() { return cExpCSParserRuleCall; }
	}

	public class CoIteratorVariableCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_1_1_0 = (RuleCall)cOwnedTypeAssignment_1_1.eContents().get(0);

		//CoIteratorVariableCS VariableCS:
		//	name=UnrestrictedName (':' ownedType=TypeExpCS)?;
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName (':' ownedType=TypeExpCS)?
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//(':' ownedType=TypeExpCS)?
		public Group getGroup_1() { return cGroup_1; }

		//':'
		public Keyword getColonKeyword_1_0() { return cColonKeyword_1_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_1_1() { return cOwnedTypeAssignment_1_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_1_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_1_1_0; }
	}

	public class IfExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.IfExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cIfKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedConditionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives cOwnedConditionAlternatives_1_0 = (Alternatives)cOwnedConditionAssignment_1.eContents().get(0);
		private final RuleCall cOwnedConditionExpCSParserRuleCall_1_0_0 = (RuleCall)cOwnedConditionAlternatives_1_0.eContents().get(0);
		private final RuleCall cOwnedConditionPatternExpCSParserRuleCall_1_0_1 = (RuleCall)cOwnedConditionAlternatives_1_0.eContents().get(1);
		private final Keyword cThenKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedThenExpressionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedThenExpressionExpCSParserRuleCall_3_0 = (RuleCall)cOwnedThenExpressionAssignment_3.eContents().get(0);
		private final Assignment cOwnedIfThenExpressionsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0 = (RuleCall)cOwnedIfThenExpressionsAssignment_4.eContents().get(0);
		private final Keyword cElseKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cOwnedElseExpressionAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cOwnedElseExpressionExpCSParserRuleCall_6_0 = (RuleCall)cOwnedElseExpressionAssignment_6.eContents().get(0);
		private final Keyword cEndifKeyword_7 = (Keyword)cGroup.eContents().get(7);

		//IfExpCS:
		//	'if' ownedCondition=(ExpCS | PatternExpCS)
		//	'then' ownedThenExpression=ExpCS
		////	ifThenExpressions+=IfThenExpCS
		//	ownedIfThenExpressions+=ElseIfThenExpCS*
		//	'else' ownedElseExpression=ExpCS
		//	'endif';
		@Override public ParserRule getRule() { return rule; }

		//'if' ownedCondition=(ExpCS | PatternExpCS)
		//'then' ownedThenExpression=ExpCS
		////	ifThenExpressions+=IfThenExpCS
		//ownedIfThenExpressions+=ElseIfThenExpCS*
		//'else' ownedElseExpression=ExpCS
		//'endif'
		public Group getGroup() { return cGroup; }

		//'if'
		public Keyword getIfKeyword_0() { return cIfKeyword_0; }

		//ownedCondition=(ExpCS | PatternExpCS)
		public Assignment getOwnedConditionAssignment_1() { return cOwnedConditionAssignment_1; }

		//(ExpCS | PatternExpCS)
		public Alternatives getOwnedConditionAlternatives_1_0() { return cOwnedConditionAlternatives_1_0; }

		//ExpCS
		public RuleCall getOwnedConditionExpCSParserRuleCall_1_0_0() { return cOwnedConditionExpCSParserRuleCall_1_0_0; }

		//PatternExpCS
		public RuleCall getOwnedConditionPatternExpCSParserRuleCall_1_0_1() { return cOwnedConditionPatternExpCSParserRuleCall_1_0_1; }

		//'then'
		public Keyword getThenKeyword_2() { return cThenKeyword_2; }

		//ownedThenExpression=ExpCS
		public Assignment getOwnedThenExpressionAssignment_3() { return cOwnedThenExpressionAssignment_3; }

		//ExpCS
		public RuleCall getOwnedThenExpressionExpCSParserRuleCall_3_0() { return cOwnedThenExpressionExpCSParserRuleCall_3_0; }

		////	ifThenExpressions+=IfThenExpCS
		//ownedIfThenExpressions+=ElseIfThenExpCS*
		public Assignment getOwnedIfThenExpressionsAssignment_4() { return cOwnedIfThenExpressionsAssignment_4; }

		//ElseIfThenExpCS
		public RuleCall getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0() { return cOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0; }

		//'else'
		public Keyword getElseKeyword_5() { return cElseKeyword_5; }

		//ownedElseExpression=ExpCS
		public Assignment getOwnedElseExpressionAssignment_6() { return cOwnedElseExpressionAssignment_6; }

		//ExpCS
		public RuleCall getOwnedElseExpressionExpCSParserRuleCall_6_0() { return cOwnedElseExpressionExpCSParserRuleCall_6_0; }

		//'endif'
		public Keyword getEndifKeyword_7() { return cEndifKeyword_7; }
	}

	public class ElseIfThenExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ElseIfThenExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cElseifKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedConditionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedConditionExpCSParserRuleCall_1_0 = (RuleCall)cOwnedConditionAssignment_1.eContents().get(0);
		private final Keyword cThenKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedThenExpressionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedThenExpressionExpCSParserRuleCall_3_0 = (RuleCall)cOwnedThenExpressionAssignment_3.eContents().get(0);

		////IfThenExpCS returns IfThenExpCS:
		////	'if' condition=ExpCS
		////	'then' thenExpression=ExpCS
		////;
		//ElseIfThenExpCS IfThenExpCS:
		//	'elseif' ownedCondition=ExpCS
		//	'then' ownedThenExpression=ExpCS;
		@Override public ParserRule getRule() { return rule; }

		//'elseif' ownedCondition=ExpCS
		//'then' ownedThenExpression=ExpCS
		public Group getGroup() { return cGroup; }

		//'elseif'
		public Keyword getElseifKeyword_0() { return cElseifKeyword_0; }

		//ownedCondition=ExpCS
		public Assignment getOwnedConditionAssignment_1() { return cOwnedConditionAssignment_1; }

		//ExpCS
		public RuleCall getOwnedConditionExpCSParserRuleCall_1_0() { return cOwnedConditionExpCSParserRuleCall_1_0; }

		//'then'
		public Keyword getThenKeyword_2() { return cThenKeyword_2; }

		//ownedThenExpression=ExpCS
		public Assignment getOwnedThenExpressionAssignment_3() { return cOwnedThenExpressionAssignment_3; }

		//ExpCS
		public RuleCall getOwnedThenExpressionExpCSParserRuleCall_3_0() { return cOwnedThenExpressionExpCSParserRuleCall_3_0; }
	}

	public class LetExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.LetExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLetKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedVariablesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedVariablesLetVariableCSParserRuleCall_1_0 = (RuleCall)cOwnedVariablesAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cCommaKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedVariablesAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedVariablesLetVariableCSParserRuleCall_2_1_0 = (RuleCall)cOwnedVariablesAssignment_2_1.eContents().get(0);
		private final Keyword cInKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cOwnedInExpressionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedInExpressionExpCSParserRuleCall_4_0 = (RuleCall)cOwnedInExpressionAssignment_4.eContents().get(0);

		//LetExpCS:
		//	'let' ownedVariables+=LetVariableCS (',' ownedVariables+=LetVariableCS)*
		//	'in' ownedInExpression=ExpCS;
		@Override public ParserRule getRule() { return rule; }

		//'let' ownedVariables+=LetVariableCS (',' ownedVariables+=LetVariableCS)*
		//'in' ownedInExpression=ExpCS
		public Group getGroup() { return cGroup; }

		//'let'
		public Keyword getLetKeyword_0() { return cLetKeyword_0; }

		//ownedVariables+=LetVariableCS
		public Assignment getOwnedVariablesAssignment_1() { return cOwnedVariablesAssignment_1; }

		//LetVariableCS
		public RuleCall getOwnedVariablesLetVariableCSParserRuleCall_1_0() { return cOwnedVariablesLetVariableCSParserRuleCall_1_0; }

		//(',' ownedVariables+=LetVariableCS)*
		public Group getGroup_2() { return cGroup_2; }

		//','
		public Keyword getCommaKeyword_2_0() { return cCommaKeyword_2_0; }

		//ownedVariables+=LetVariableCS
		public Assignment getOwnedVariablesAssignment_2_1() { return cOwnedVariablesAssignment_2_1; }

		//LetVariableCS
		public RuleCall getOwnedVariablesLetVariableCSParserRuleCall_2_1_0() { return cOwnedVariablesLetVariableCSParserRuleCall_2_1_0; }

		//'in'
		public Keyword getInKeyword_3() { return cInKeyword_3; }

		//ownedInExpression=ExpCS
		public Assignment getOwnedInExpressionAssignment_4() { return cOwnedInExpressionAssignment_4; }

		//ExpCS
		public RuleCall getOwnedInExpressionExpCSParserRuleCall_4_0() { return cOwnedInExpressionExpCSParserRuleCall_4_0; }
	}

	public class LetVariableCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.LetVariableCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Assignment cOwnedRoundBracketedClauseAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0 = (RuleCall)cOwnedRoundBracketedClauseAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_2_1_0 = (RuleCall)cOwnedTypeAssignment_2_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cOwnedInitExpressionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_4_0 = (RuleCall)cOwnedInitExpressionAssignment_4.eContents().get(0);

		//LetVariableCS:
		//	name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS? (':' ownedType=TypeExpCS)? '='
		//	ownedInitExpression=ExpCS;
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS? (':' ownedType=TypeExpCS)? '='
		//ownedInitExpression=ExpCS
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//ownedRoundBracketedClause=RoundBracketedClauseCS?
		public Assignment getOwnedRoundBracketedClauseAssignment_1() { return cOwnedRoundBracketedClauseAssignment_1; }

		//RoundBracketedClauseCS
		public RuleCall getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0() { return cOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0; }

		//(':' ownedType=TypeExpCS)?
		public Group getGroup_2() { return cGroup_2; }

		//':'
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_2_1() { return cOwnedTypeAssignment_2_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_2_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_2_1_0; }

		//'='
		public Keyword getEqualsSignKeyword_3() { return cEqualsSignKeyword_3; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_4() { return cOwnedInitExpressionAssignment_4; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_4_0() { return cOwnedInitExpressionExpCSParserRuleCall_4_0; }
	}

	public class NestedExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NestedExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_1_0 = (RuleCall)cOwnedExpressionAssignment_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);

		//NestedExpCS:
		//	'(' ownedExpression=ExpCS ')';
		@Override public ParserRule getRule() { return rule; }

		//'(' ownedExpression=ExpCS ')'
		public Group getGroup() { return cGroup; }

		//'('
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment_1() { return cOwnedExpressionAssignment_1; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_1_0() { return cOwnedExpressionExpCSParserRuleCall_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
	}

	public class SelfExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.essentialocl.EssentialOCL.SelfExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cSelfExpCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cSelfKeyword_1 = (Keyword)cGroup.eContents().get(1);

		//SelfExpCS:
		//	{SelfExpCS} 'self';
		@Override public ParserRule getRule() { return rule; }

		//{SelfExpCS} 'self'
		public Group getGroup() { return cGroup; }

		//{SelfExpCS}
		public Action getSelfExpCSAction_0() { return cSelfExpCSAction_0; }

		//'self'
		public Keyword getSelfKeyword_1() { return cSelfKeyword_1; }
	}


	private final ModelElements pModel;
	private final EssentialOCLReservedKeywordElements pEssentialOCLReservedKeyword;
	private final EssentialOCLUnaryOperatorNameElements pEssentialOCLUnaryOperatorName;
	private final EssentialOCLInfixOperatorNameElements pEssentialOCLInfixOperatorName;
	private final EssentialOCLNavigationOperatorNameElements pEssentialOCLNavigationOperatorName;
	private final BinaryOperatorNameElements pBinaryOperatorName;
	private final InfixOperatorNameElements pInfixOperatorName;
	private final NavigationOperatorNameElements pNavigationOperatorName;
	private final UnaryOperatorNameElements pUnaryOperatorName;
	private final EssentialOCLUnrestrictedNameElements pEssentialOCLUnrestrictedName;
	private final UnrestrictedNameElements pUnrestrictedName;
	private final EssentialOCLUnreservedNameElements pEssentialOCLUnreservedName;
	private final UnreservedNameElements pUnreservedName;
	private final URIPathNameCSElements pURIPathNameCS;
	private final URIFirstPathElementCSElements pURIFirstPathElementCS;
	private final SimplePathNameCSElements pSimplePathNameCS;
	private final PrimitiveTypeIdentifierElements pPrimitiveTypeIdentifier;
	private final PrimitiveTypeCSElements pPrimitiveTypeCS;
	private final CollectionTypeIdentifierElements pCollectionTypeIdentifier;
	private final CollectionTypeCSElements pCollectionTypeCS;
	private final MapTypeCSElements pMapTypeCS;
	private final TupleTypeCSElements pTupleTypeCS;
	private final TuplePartCSElements pTuplePartCS;
	private final CollectionLiteralExpCSElements pCollectionLiteralExpCS;
	private final CollectionLiteralPartCSElements pCollectionLiteralPartCS;
	private final CollectionPatternCSElements pCollectionPatternCS;
	private final ShadowPartCSElements pShadowPartCS;
	private final PatternExpCSElements pPatternExpCS;
	private final LambdaLiteralExpCSElements pLambdaLiteralExpCS;
	private final MapLiteralExpCSElements pMapLiteralExpCS;
	private final MapLiteralPartCSElements pMapLiteralPartCS;
	private final PrimitiveLiteralExpCSElements pPrimitiveLiteralExpCS;
	private final TupleLiteralExpCSElements pTupleLiteralExpCS;
	private final TupleLiteralPartCSElements pTupleLiteralPartCS;
	private final NumberLiteralExpCSElements pNumberLiteralExpCS;
	private final StringLiteralExpCSElements pStringLiteralExpCS;
	private final BooleanLiteralExpCSElements pBooleanLiteralExpCS;
	private final UnlimitedNaturalLiteralExpCSElements pUnlimitedNaturalLiteralExpCS;
	private final InvalidLiteralExpCSElements pInvalidLiteralExpCS;
	private final NullLiteralExpCSElements pNullLiteralExpCS;
	private final TypeLiteralCSElements pTypeLiteralCS;
	private final TypeLiteralWithMultiplicityCSElements pTypeLiteralWithMultiplicityCS;
	private final TypeLiteralExpCSElements pTypeLiteralExpCS;
	private final TypeNameExpCSElements pTypeNameExpCS;
	private final TypeExpWithoutMultiplicityCSElements pTypeExpWithoutMultiplicityCS;
	private final TypeExpCSElements pTypeExpCS;
	private final ExpCSElements pExpCS;
	private final PrefixedLetExpCSElements pPrefixedLetExpCS;
	private final PrefixedPrimaryExpCSElements pPrefixedPrimaryExpCS;
	private final PrimaryExpCSElements pPrimaryExpCS;
	private final NameExpCSElements pNameExpCS;
	private final CurlyBracketedClauseCSElements pCurlyBracketedClauseCS;
	private final RoundBracketedClauseCSElements pRoundBracketedClauseCS;
	private final SquareBracketedClauseCSElements pSquareBracketedClauseCS;
	private final NavigatingArgCSElements pNavigatingArgCS;
	private final NavigatingBarArgCSElements pNavigatingBarArgCS;
	private final NavigatingCommaArgCSElements pNavigatingCommaArgCS;
	private final NavigatingSemiArgCSElements pNavigatingSemiArgCS;
	private final NavigatingArgExpCSElements pNavigatingArgExpCS;
	private final CoIteratorVariableCSElements pCoIteratorVariableCS;
	private final IfExpCSElements pIfExpCS;
	private final ElseIfThenExpCSElements pElseIfThenExpCS;
	private final LetExpCSElements pLetExpCS;
	private final LetVariableCSElements pLetVariableCS;
	private final NestedExpCSElements pNestedExpCS;
	private final SelfExpCSElements pSelfExpCS;

	private final Grammar grammar;

	private final BaseGrammarAccess gaBase;

	@Inject
	public EssentialOCLGrammarAccess(GrammarProvider grammarProvider,
		BaseGrammarAccess gaBase) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaBase = gaBase;
		this.pModel = new ModelElements();
		this.pEssentialOCLReservedKeyword = new EssentialOCLReservedKeywordElements();
		this.pEssentialOCLUnaryOperatorName = new EssentialOCLUnaryOperatorNameElements();
		this.pEssentialOCLInfixOperatorName = new EssentialOCLInfixOperatorNameElements();
		this.pEssentialOCLNavigationOperatorName = new EssentialOCLNavigationOperatorNameElements();
		this.pBinaryOperatorName = new BinaryOperatorNameElements();
		this.pInfixOperatorName = new InfixOperatorNameElements();
		this.pNavigationOperatorName = new NavigationOperatorNameElements();
		this.pUnaryOperatorName = new UnaryOperatorNameElements();
		this.pEssentialOCLUnrestrictedName = new EssentialOCLUnrestrictedNameElements();
		this.pUnrestrictedName = new UnrestrictedNameElements();
		this.pEssentialOCLUnreservedName = new EssentialOCLUnreservedNameElements();
		this.pUnreservedName = new UnreservedNameElements();
		this.pURIPathNameCS = new URIPathNameCSElements();
		this.pURIFirstPathElementCS = new URIFirstPathElementCSElements();
		this.pSimplePathNameCS = new SimplePathNameCSElements();
		this.pPrimitiveTypeIdentifier = new PrimitiveTypeIdentifierElements();
		this.pPrimitiveTypeCS = new PrimitiveTypeCSElements();
		this.pCollectionTypeIdentifier = new CollectionTypeIdentifierElements();
		this.pCollectionTypeCS = new CollectionTypeCSElements();
		this.pMapTypeCS = new MapTypeCSElements();
		this.pTupleTypeCS = new TupleTypeCSElements();
		this.pTuplePartCS = new TuplePartCSElements();
		this.pCollectionLiteralExpCS = new CollectionLiteralExpCSElements();
		this.pCollectionLiteralPartCS = new CollectionLiteralPartCSElements();
		this.pCollectionPatternCS = new CollectionPatternCSElements();
		this.pShadowPartCS = new ShadowPartCSElements();
		this.pPatternExpCS = new PatternExpCSElements();
		this.pLambdaLiteralExpCS = new LambdaLiteralExpCSElements();
		this.pMapLiteralExpCS = new MapLiteralExpCSElements();
		this.pMapLiteralPartCS = new MapLiteralPartCSElements();
		this.pPrimitiveLiteralExpCS = new PrimitiveLiteralExpCSElements();
		this.pTupleLiteralExpCS = new TupleLiteralExpCSElements();
		this.pTupleLiteralPartCS = new TupleLiteralPartCSElements();
		this.pNumberLiteralExpCS = new NumberLiteralExpCSElements();
		this.pStringLiteralExpCS = new StringLiteralExpCSElements();
		this.pBooleanLiteralExpCS = new BooleanLiteralExpCSElements();
		this.pUnlimitedNaturalLiteralExpCS = new UnlimitedNaturalLiteralExpCSElements();
		this.pInvalidLiteralExpCS = new InvalidLiteralExpCSElements();
		this.pNullLiteralExpCS = new NullLiteralExpCSElements();
		this.pTypeLiteralCS = new TypeLiteralCSElements();
		this.pTypeLiteralWithMultiplicityCS = new TypeLiteralWithMultiplicityCSElements();
		this.pTypeLiteralExpCS = new TypeLiteralExpCSElements();
		this.pTypeNameExpCS = new TypeNameExpCSElements();
		this.pTypeExpWithoutMultiplicityCS = new TypeExpWithoutMultiplicityCSElements();
		this.pTypeExpCS = new TypeExpCSElements();
		this.pExpCS = new ExpCSElements();
		this.pPrefixedLetExpCS = new PrefixedLetExpCSElements();
		this.pPrefixedPrimaryExpCS = new PrefixedPrimaryExpCSElements();
		this.pPrimaryExpCS = new PrimaryExpCSElements();
		this.pNameExpCS = new NameExpCSElements();
		this.pCurlyBracketedClauseCS = new CurlyBracketedClauseCSElements();
		this.pRoundBracketedClauseCS = new RoundBracketedClauseCSElements();
		this.pSquareBracketedClauseCS = new SquareBracketedClauseCSElements();
		this.pNavigatingArgCS = new NavigatingArgCSElements();
		this.pNavigatingBarArgCS = new NavigatingBarArgCSElements();
		this.pNavigatingCommaArgCS = new NavigatingCommaArgCSElements();
		this.pNavigatingSemiArgCS = new NavigatingSemiArgCSElements();
		this.pNavigatingArgExpCS = new NavigatingArgExpCSElements();
		this.pCoIteratorVariableCS = new CoIteratorVariableCSElements();
		this.pIfExpCS = new IfExpCSElements();
		this.pElseIfThenExpCS = new ElseIfThenExpCSElements();
		this.pLetExpCS = new LetExpCSElements();
		this.pLetVariableCS = new LetVariableCSElements();
		this.pNestedExpCS = new NestedExpCSElements();
		this.pSelfExpCS = new SelfExpCSElements();
	}

	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.ocl.xtext.essentialocl.EssentialOCL".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}

	@Override
	public Grammar getGrammar() {
		return grammar;
	}


	public BaseGrammarAccess getBaseGrammarAccess() {
		return gaBase;
	}


	////generate essentialOCLCST "http://www.eclipse.org/ocl/3.0.0/EssentialOCLCST"
	//Model ContextCS:
	//	ownedExpression=ExpCS;
	public ModelElements getModelAccess() {
		return pModel;
	}

	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}

	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLReservedKeyword:
	//	'and'
	//	| 'and2'
	//	| 'else'
	//	| 'endif'
	//	| 'if'
	//	| 'implies'
	//	| 'implies2'
	//	| 'in'
	//	| 'let'
	//	| 'not'
	//	| 'not2'
	//	| 'or'
	//	| 'or2'
	//	| 'then'
	//	| 'with'
	//	| 'xor'
	//	| 'xor2';
	public EssentialOCLReservedKeywordElements getEssentialOCLReservedKeywordAccess() {
		return pEssentialOCLReservedKeyword;
	}

	public ParserRule getEssentialOCLReservedKeywordRule() {
		return getEssentialOCLReservedKeywordAccess().getRule();
	}

	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLUnaryOperatorName:
	//	'-' | 'not' | 'not2';
	public EssentialOCLUnaryOperatorNameElements getEssentialOCLUnaryOperatorNameAccess() {
		return pEssentialOCLUnaryOperatorName;
	}

	public ParserRule getEssentialOCLUnaryOperatorNameRule() {
		return getEssentialOCLUnaryOperatorNameAccess().getRule();
	}

	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLInfixOperatorName:
	//	'*' | '/' | '+' | '-' | '>' | '<' | '>=' | '<=' | '=' | '<>' | 'and' | 'and2' | 'implies' | 'implies2' | 'or' |
	//	'or2' | 'xor' | 'xor2';
	public EssentialOCLInfixOperatorNameElements getEssentialOCLInfixOperatorNameAccess() {
		return pEssentialOCLInfixOperatorName;
	}

	public ParserRule getEssentialOCLInfixOperatorNameRule() {
		return getEssentialOCLInfixOperatorNameAccess().getRule();
	}

	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLNavigationOperatorName:
	//	'.' | '->' | '?.' | '?->';
	public EssentialOCLNavigationOperatorNameElements getEssentialOCLNavigationOperatorNameAccess() {
		return pEssentialOCLNavigationOperatorName;
	}

	public ParserRule getEssentialOCLNavigationOperatorNameRule() {
		return getEssentialOCLNavigationOperatorNameAccess().getRule();
	}

	//BinaryOperatorName:
	//	InfixOperatorName | NavigationOperatorName;
	public BinaryOperatorNameElements getBinaryOperatorNameAccess() {
		return pBinaryOperatorName;
	}

	public ParserRule getBinaryOperatorNameRule() {
		return getBinaryOperatorNameAccess().getRule();
	}

	//InfixOperatorName:
	//	EssentialOCLInfixOperatorName;
	public InfixOperatorNameElements getInfixOperatorNameAccess() {
		return pInfixOperatorName;
	}

	public ParserRule getInfixOperatorNameRule() {
		return getInfixOperatorNameAccess().getRule();
	}

	//NavigationOperatorName:
	//	EssentialOCLNavigationOperatorName;
	public NavigationOperatorNameElements getNavigationOperatorNameAccess() {
		return pNavigationOperatorName;
	}

	public ParserRule getNavigationOperatorNameRule() {
		return getNavigationOperatorNameAccess().getRule();
	}

	//UnaryOperatorName:
	//	EssentialOCLUnaryOperatorName;
	public UnaryOperatorNameElements getUnaryOperatorNameAccess() {
		return pUnaryOperatorName;
	}

	public ParserRule getUnaryOperatorNameRule() {
		return getUnaryOperatorNameAccess().getRule();
	}

	////---------------------------------------------------------------------
	////  Names
	////---------------------------------------------------------------------
	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLUnrestrictedName:
	//	Identifier;
	public EssentialOCLUnrestrictedNameElements getEssentialOCLUnrestrictedNameAccess() {
		return pEssentialOCLUnrestrictedName;
	}

	public ParserRule getEssentialOCLUnrestrictedNameRule() {
		return getEssentialOCLUnrestrictedNameAccess().getRule();
	}

	//@Override
	//UnrestrictedName:
	//	EssentialOCLUnrestrictedName;
	public UnrestrictedNameElements getUnrestrictedNameAccess() {
		return pUnrestrictedName;
	}

	public ParserRule getUnrestrictedNameRule() {
		return getUnrestrictedNameAccess().getRule();
	}

	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLUnreservedName:
	//	UnrestrictedName
	//	| CollectionTypeIdentifier
	//	| PrimitiveTypeIdentifier
	//	| 'Map'
	//	| 'Tuple';
	public EssentialOCLUnreservedNameElements getEssentialOCLUnreservedNameAccess() {
		return pEssentialOCLUnreservedName;
	}

	public ParserRule getEssentialOCLUnreservedNameRule() {
		return getEssentialOCLUnreservedNameAccess().getRule();
	}

	//@Override
	//UnreservedName:
	//	EssentialOCLUnreservedName;
	public UnreservedNameElements getUnreservedNameAccess() {
		return pUnreservedName;
	}

	public ParserRule getUnreservedNameRule() {
		return getUnreservedNameAccess().getRule();
	}

	//URIPathNameCS base::PathNameCS:
	//	ownedPathElements+=URIFirstPathElementCS ('::' ownedPathElements+=NextPathElementCS)*;
	public URIPathNameCSElements getURIPathNameCSAccess() {
		return pURIPathNameCS;
	}

	public ParserRule getURIPathNameCSRule() {
		return getURIPathNameCSAccess().getRule();
	}

	//URIFirstPathElementCS base::PathElementCS:
	//	referredElement=[pivot::NamedElement|UnrestrictedName] | {base::PathElementWithURICS}
	//	referredElement=[pivot::Namespace|URI];
	public URIFirstPathElementCSElements getURIFirstPathElementCSAccess() {
		return pURIFirstPathElementCS;
	}

	public ParserRule getURIFirstPathElementCSRule() {
		return getURIFirstPathElementCSAccess().getRule();
	}

	//SimplePathNameCS base::PathNameCS:
	//	ownedPathElements+=FirstPathElementCS;
	public SimplePathNameCSElements getSimplePathNameCSAccess() {
		return pSimplePathNameCS;
	}

	public ParserRule getSimplePathNameCSRule() {
		return getSimplePathNameCSAccess().getRule();
	}

	////---------------------------------------------------------------------
	////  Types
	////---------------------------------------------------------------------
	//PrimitiveTypeIdentifier:
	//	'Boolean'
	//	| 'Integer'
	//	| 'Real'
	//	| 'String'
	//	| 'UnlimitedNatural'
	//	| 'OclAny'
	//	| 'OclInvalid'
	//	| 'OclVoid';
	public PrimitiveTypeIdentifierElements getPrimitiveTypeIdentifierAccess() {
		return pPrimitiveTypeIdentifier;
	}

	public ParserRule getPrimitiveTypeIdentifierRule() {
		return getPrimitiveTypeIdentifierAccess().getRule();
	}

	//PrimitiveTypeCS base::PrimitiveTypeRefCS:
	//	name=PrimitiveTypeIdentifier;
	public PrimitiveTypeCSElements getPrimitiveTypeCSAccess() {
		return pPrimitiveTypeCS;
	}

	public ParserRule getPrimitiveTypeCSRule() {
		return getPrimitiveTypeCSAccess().getRule();
	}

	//CollectionTypeIdentifier:
	//	'Set'
	//	| 'Bag'
	//	| 'Sequence'
	//	| 'Collection'
	//	| 'OrderedSet';
	public CollectionTypeIdentifierElements getCollectionTypeIdentifierAccess() {
		return pCollectionTypeIdentifier;
	}

	public ParserRule getCollectionTypeIdentifierRule() {
		return getCollectionTypeIdentifierAccess().getRule();
	}

	//CollectionTypeCS:
	//	name=CollectionTypeIdentifier ('(' ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS
	//	? ')')?;
	public CollectionTypeCSElements getCollectionTypeCSAccess() {
		return pCollectionTypeCS;
	}

	public ParserRule getCollectionTypeCSRule() {
		return getCollectionTypeCSAccess().getRule();
	}

	//MapTypeCS:
	//	name='Map' ('(' ownedKeyType=TypeExpCS ',' ownedValueType=TypeExpCS ')')?;
	public MapTypeCSElements getMapTypeCSAccess() {
		return pMapTypeCS;
	}

	public ParserRule getMapTypeCSRule() {
		return getMapTypeCSAccess().getRule();
	}

	//TupleTypeCS base::TupleTypeCS:
	//	name='Tuple' ('(' (ownedParts+=TuplePartCS (',' ownedParts+=TuplePartCS)*)? ')')?;
	public TupleTypeCSElements getTupleTypeCSAccess() {
		return pTupleTypeCS;
	}

	public ParserRule getTupleTypeCSRule() {
		return getTupleTypeCSAccess().getRule();
	}

	//TuplePartCS base::TuplePartCS:
	//	name=UnrestrictedName ':' ownedType=TypeExpCS;
	public TuplePartCSElements getTuplePartCSAccess() {
		return pTuplePartCS;
	}

	public ParserRule getTuplePartCSRule() {
		return getTuplePartCSAccess().getRule();
	}

	////---------------------------------------------------------------------
	////  Literals
	////---------------------------------------------------------------------
	//CollectionLiteralExpCS:
	//	ownedType=CollectionTypeCS
	//	'{' (ownedParts+=CollectionLiteralPartCS (',' ownedParts+=CollectionLiteralPartCS)*)?
	//	'}';
	public CollectionLiteralExpCSElements getCollectionLiteralExpCSAccess() {
		return pCollectionLiteralExpCS;
	}

	public ParserRule getCollectionLiteralExpCSRule() {
		return getCollectionLiteralExpCSAccess().getRule();
	}

	//CollectionLiteralPartCS:
	//	ownedExpression=ExpCS ('..' ownedLastExpression=ExpCS)? | ownedExpression=PatternExpCS;
	public CollectionLiteralPartCSElements getCollectionLiteralPartCSAccess() {
		return pCollectionLiteralPartCS;
	}

	public ParserRule getCollectionLiteralPartCSRule() {
		return getCollectionLiteralPartCSAccess().getRule();
	}

	//CollectionPatternCS:
	//	ownedType=CollectionTypeCS
	//	'{' (ownedParts+=PatternExpCS (',' ownedParts+=PatternExpCS)* ('++' restVariableName=Identifier))?
	//	'}';
	public CollectionPatternCSElements getCollectionPatternCSAccess() {
		return pCollectionPatternCS;
	}

	public ParserRule getCollectionPatternCSRule() {
		return getCollectionPatternCSAccess().getRule();
	}

	//ShadowPartCS:
	//	referredProperty=[pivot::Property|UnrestrictedName] '=' ownedInitExpression=(ExpCS | PatternExpCS) |
	//	ownedInitExpression=StringLiteralExpCS;
	public ShadowPartCSElements getShadowPartCSAccess() {
		return pShadowPartCS;
	}

	public ParserRule getShadowPartCSRule() {
		return getShadowPartCSAccess().getRule();
	}

	//PatternExpCS:
	//	patternVariableName=UnrestrictedName? ':' ownedPatternType=TypeExpCS;
	public PatternExpCSElements getPatternExpCSAccess() {
		return pPatternExpCS;
	}

	public ParserRule getPatternExpCSRule() {
		return getPatternExpCSAccess().getRule();
	}

	//LambdaLiteralExpCS:
	//	'Lambda' '{' ownedExpressionCS=ExpCS '}';
	public LambdaLiteralExpCSElements getLambdaLiteralExpCSAccess() {
		return pLambdaLiteralExpCS;
	}

	public ParserRule getLambdaLiteralExpCSRule() {
		return getLambdaLiteralExpCSAccess().getRule();
	}

	//MapLiteralExpCS:
	//	ownedType=MapTypeCS '{' (ownedParts+=MapLiteralPartCS (',' ownedParts+=MapLiteralPartCS)*)? '}';
	public MapLiteralExpCSElements getMapLiteralExpCSAccess() {
		return pMapLiteralExpCS;
	}

	public ParserRule getMapLiteralExpCSRule() {
		return getMapLiteralExpCSAccess().getRule();
	}

	//MapLiteralPartCS:
	//	ownedKey=ExpCS ('with' | '<-') ownedValue=ExpCS;
	public MapLiteralPartCSElements getMapLiteralPartCSAccess() {
		return pMapLiteralPartCS;
	}

	public ParserRule getMapLiteralPartCSRule() {
		return getMapLiteralPartCSAccess().getRule();
	}

	//// <- is deprecated see Bug 577614
	//
	//PrimitiveLiteralExpCS:
	//	NumberLiteralExpCS
	//	| StringLiteralExpCS
	//	| BooleanLiteralExpCS
	//	| UnlimitedNaturalLiteralExpCS
	//	| InvalidLiteralExpCS
	//	| NullLiteralExpCS;
	public PrimitiveLiteralExpCSElements getPrimitiveLiteralExpCSAccess() {
		return pPrimitiveLiteralExpCS;
	}

	public ParserRule getPrimitiveLiteralExpCSRule() {
		return getPrimitiveLiteralExpCSAccess().getRule();
	}

	//TupleLiteralExpCS:
	//	'Tuple' '{' ownedParts+=TupleLiteralPartCS (',' ownedParts+=TupleLiteralPartCS)* '}';
	public TupleLiteralExpCSElements getTupleLiteralExpCSAccess() {
		return pTupleLiteralExpCS;
	}

	public ParserRule getTupleLiteralExpCSRule() {
		return getTupleLiteralExpCSAccess().getRule();
	}

	//TupleLiteralPartCS:
	//	name=UnrestrictedName (':' ownedType=TypeExpCS)? '=' ownedInitExpression=ExpCS;
	public TupleLiteralPartCSElements getTupleLiteralPartCSAccess() {
		return pTupleLiteralPartCS;
	}

	public ParserRule getTupleLiteralPartCSRule() {
		return getTupleLiteralPartCSAccess().getRule();
	}

	//NumberLiteralExpCS:
	//	symbol=NUMBER_LITERAL;
	public NumberLiteralExpCSElements getNumberLiteralExpCSAccess() {
		return pNumberLiteralExpCS;
	}

	public ParserRule getNumberLiteralExpCSRule() {
		return getNumberLiteralExpCSAccess().getRule();
	}

	//StringLiteralExpCS:
	//	segments+=StringLiteral+;
	public StringLiteralExpCSElements getStringLiteralExpCSAccess() {
		return pStringLiteralExpCS;
	}

	public ParserRule getStringLiteralExpCSRule() {
		return getStringLiteralExpCSAccess().getRule();
	}

	//BooleanLiteralExpCS:
	//	symbol='true'
	//	| symbol='false';
	public BooleanLiteralExpCSElements getBooleanLiteralExpCSAccess() {
		return pBooleanLiteralExpCS;
	}

	public ParserRule getBooleanLiteralExpCSRule() {
		return getBooleanLiteralExpCSAccess().getRule();
	}

	//UnlimitedNaturalLiteralExpCS:
	//	{UnlimitedNaturalLiteralExpCS} '*';
	public UnlimitedNaturalLiteralExpCSElements getUnlimitedNaturalLiteralExpCSAccess() {
		return pUnlimitedNaturalLiteralExpCS;
	}

	public ParserRule getUnlimitedNaturalLiteralExpCSRule() {
		return getUnlimitedNaturalLiteralExpCSAccess().getRule();
	}

	//InvalidLiteralExpCS:
	//	{InvalidLiteralExpCS} 'invalid';
	public InvalidLiteralExpCSElements getInvalidLiteralExpCSAccess() {
		return pInvalidLiteralExpCS;
	}

	public ParserRule getInvalidLiteralExpCSRule() {
		return getInvalidLiteralExpCSAccess().getRule();
	}

	//NullLiteralExpCS:
	//	{NullLiteralExpCS} 'null';
	public NullLiteralExpCSElements getNullLiteralExpCSAccess() {
		return pNullLiteralExpCS;
	}

	public ParserRule getNullLiteralExpCSRule() {
		return getNullLiteralExpCSAccess().getRule();
	}

	//TypeLiteralCS base::TypedRefCS:
	//	PrimitiveTypeCS
	//	| CollectionTypeCS
	//	| MapTypeCS
	//	| TupleTypeCS;
	public TypeLiteralCSElements getTypeLiteralCSAccess() {
		return pTypeLiteralCS;
	}

	public ParserRule getTypeLiteralCSRule() {
		return getTypeLiteralCSAccess().getRule();
	}

	//TypeLiteralWithMultiplicityCS base::TypedRefCS:
	//	TypeLiteralCS ownedMultiplicity=MultiplicityCS?;
	public TypeLiteralWithMultiplicityCSElements getTypeLiteralWithMultiplicityCSAccess() {
		return pTypeLiteralWithMultiplicityCS;
	}

	public ParserRule getTypeLiteralWithMultiplicityCSRule() {
		return getTypeLiteralWithMultiplicityCSAccess().getRule();
	}

	//TypeLiteralExpCS:
	//	ownedType=TypeLiteralWithMultiplicityCS;
	public TypeLiteralExpCSElements getTypeLiteralExpCSAccess() {
		return pTypeLiteralExpCS;
	}

	public ParserRule getTypeLiteralExpCSRule() {
		return getTypeLiteralExpCSAccess().getRule();
	}

	//TypeNameExpCS:
	//	ownedPathName=PathNameCS (ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' ownedPatternGuard=ExpCS '}')?)?;
	public TypeNameExpCSElements getTypeNameExpCSAccess() {
		return pTypeNameExpCS;
	}

	public ParserRule getTypeNameExpCSRule() {
		return getTypeNameExpCSAccess().getRule();
	}

	//TypeExpWithoutMultiplicityCS base::TypedRefCS:
	//	TypeNameExpCS | TypeLiteralCS | CollectionPatternCS;
	public TypeExpWithoutMultiplicityCSElements getTypeExpWithoutMultiplicityCSAccess() {
		return pTypeExpWithoutMultiplicityCS;
	}

	public ParserRule getTypeExpWithoutMultiplicityCSRule() {
		return getTypeExpWithoutMultiplicityCSAccess().getRule();
	}

	//TypeExpCS base::TypedRefCS:
	//	TypeExpWithoutMultiplicityCS ownedMultiplicity=MultiplicityCS?;
	public TypeExpCSElements getTypeExpCSAccess() {
		return pTypeExpCS;
	}

	public ParserRule getTypeExpCSRule() {
		return getTypeExpCSAccess().getRule();
	}

	////---------------------------------------------------------------------
	////  Expressions
	////---------------------------------------------------------------------
	//// An ExpCS permits a LetExpCS only in the final term to ensure
	////  that let is right associative, whereas infix operators are left associative.
	////   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4
	//// is
	////   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
	///* An expression elaborates a prefixed expression with zero or more binary operator and expression suffixes.
	// * An optionally prefixed let expression is permitted except when suffixed with further expressions.*/
	//ExpCS:
	//	PrefixedPrimaryExpCS ({InfixExpCS.ownedLeft=current} name=BinaryOperatorName ownedRight=ExpCS)? | PrefixedLetExpCS;
	public ExpCSElements getExpCSAccess() {
		return pExpCS;
	}

	public ParserRule getExpCSRule() {
		return getExpCSAccess().getRule();
	}

	///* A prefixed let expression elaborates a let expression with zero or more unary prefix operators. */
	//PrefixedLetExpCS ExpCS:
	//	{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedLetExpCS | LetExpCS;
	public PrefixedLetExpCSElements getPrefixedLetExpCSAccess() {
		return pPrefixedLetExpCS;
	}

	public ParserRule getPrefixedLetExpCSRule() {
		return getPrefixedLetExpCSAccess().getRule();
	}

	///* A prefixed primary expression elaborates a primary expression with zero or more unary prefix operators. */
	//PrefixedPrimaryExpCS ExpCS:
	//	{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS | PrimaryExpCS;
	public PrefixedPrimaryExpCSElements getPrefixedPrimaryExpCSAccess() {
		return pPrefixedPrimaryExpCS;
	}

	public ParserRule getPrefixedPrimaryExpCSRule() {
		return getPrefixedPrimaryExpCSAccess().getRule();
	}

	///* A primary expression identifies the basic expressions from which more complex expressions may be constructed. */
	//PrimaryExpCS ExpCS:
	//	NestedExpCS
	//	| IfExpCS
	//	| SelfExpCS
	//	| PrimitiveLiteralExpCS
	//	| TupleLiteralExpCS
	//	| MapLiteralExpCS
	//	| CollectionLiteralExpCS
	//	| LambdaLiteralExpCS
	//	| TypeLiteralExpCS
	//	| NameExpCS;
	public PrimaryExpCSElements getPrimaryExpCSAccess() {
		return pPrimaryExpCS;
	}

	public ParserRule getPrimaryExpCSRule() {
		return getPrimaryExpCSAccess().getRule();
	}

	///* A name expression is a generalised rule for expressions that start with a name and which may be followed by square, round or
	// * curly bracket clauses and optionally an @pre as well.*/
	//NameExpCS:
	//	ownedPathName=PathNameCS ownedSquareBracketedClauses+=SquareBracketedClauseCS*
	//	ownedRoundBracketedClause=RoundBracketedClauseCS? ownedCurlyBracketedClause=CurlyBracketedClauseCS? (isPre?='@'
	//	'pre')?;
	public NameExpCSElements getNameExpCSAccess() {
		return pNameExpCS;
	}

	public ParserRule getNameExpCSRule() {
		return getNameExpCSAccess().getRule();
	}

	///* A curly bracket clause is a generalized rule for the literal arguments of collections, maps, tuples and shadows.*/
	//CurlyBracketedClauseCS:
	//	{CurlyBracketedClauseCS} '{' (ownedParts+=ShadowPartCS (',' ownedParts+=ShadowPartCS)*)? '}';
	public CurlyBracketedClauseCSElements getCurlyBracketedClauseCSAccess() {
		return pCurlyBracketedClauseCS;
	}

	public ParserRule getCurlyBracketedClauseCSRule() {
		return getCurlyBracketedClauseCSAccess().getRule();
	}

	///* A curly bracket clause is a generalized rule for template specialisations and operations arguments.*/
	//RoundBracketedClauseCS:
	//	{RoundBracketedClauseCS} '(' (ownedArguments+=NavigatingArgCS ownedArguments+=(NavigatingCommaArgCS |
	//	NavigatingSemiArgCS | NavigatingBarArgCS)*)? ')';
	public RoundBracketedClauseCSElements getRoundBracketedClauseCSAccess() {
		return pRoundBracketedClauseCS;
	}

	public ParserRule getRoundBracketedClauseCSRule() {
		return getRoundBracketedClauseCSAccess().getRule();
	}

	///* A square bracket clause is a generalized rule for association class qualifiers and roles.*/
	//SquareBracketedClauseCS:
	//	'[' ownedTerms+=ExpCS (',' ownedTerms+=ExpCS)* ']';
	public SquareBracketedClauseCSElements getSquareBracketedClauseCSAccess() {
		return pSquareBracketedClauseCS;
	}

	public ParserRule getSquareBracketedClauseCSRule() {
		return getSquareBracketedClauseCSAccess().getRule();
	}

	///* A navigating argument is a generalized rule for the first argument in a round bracket clause. This is typically the first operation
	// * parameter or an iterator. */
	//NavigatingArgCS:
	//	ownedNameExpression=NavigatingArgExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS ('='
	//	ownedInitExpression=ExpCS)? | ':' ownedType=TypeExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? ('='
	//	ownedInitExpression=ExpCS)? | (':' ownedType=TypeExpCS)? (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? 'in'
	//	ownedInitExpression=ExpCS)?
	//	| ':' ownedType=TypeExpCS;
	public NavigatingArgCSElements getNavigatingArgCSAccess() {
		return pNavigatingArgCS;
	}

	public ParserRule getNavigatingArgCSRule() {
		return getNavigatingArgCSAccess().getRule();
	}

	//// Type-less init is an illegal infix expression
	//
	///* A navigating bar argument is a generalized rule for a bar-prefixed argument in a round bracket clause. This is typically the body of an iteration. */
	//NavigatingBarArgCS NavigatingArgCS:
	//	prefix='|' ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?;
	public NavigatingBarArgCSElements getNavigatingBarArgCSAccess() {
		return pNavigatingBarArgCS;
	}

	public ParserRule getNavigatingBarArgCSRule() {
		return getNavigatingBarArgCSAccess().getRule();
	}

	//// Type-less init is an illegal infix expression
	//
	///* A navigating comma argument is a generalized rule for non-first argument in a round bracket clause. These are typically non-first operation
	// * parameters or a second iterator. */
	//NavigatingCommaArgCS NavigatingArgCS:
	//	prefix=',' ownedNameExpression=NavigatingArgExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS ('='
	//	ownedInitExpression=ExpCS)? | ':' ownedType=TypeExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? ('='
	//	ownedInitExpression=ExpCS)? | (':' ownedType=TypeExpCS)? (('with' | '<-') ownedCoIterator=CoIteratorVariableCS)? 'in'
	//	ownedInitExpression=ExpCS)?;
	public NavigatingCommaArgCSElements getNavigatingCommaArgCSAccess() {
		return pNavigatingCommaArgCS;
	}

	public ParserRule getNavigatingCommaArgCSRule() {
		return getNavigatingCommaArgCSAccess().getRule();
	}

	//// Type-less init is an illegal infix expression
	//
	///* A navigating semi argument is a generalized rule for a semicolon prefixed argument in a round bracket clause. This is typically an iterate accumulator. */
	//NavigatingSemiArgCS NavigatingArgCS:
	//	prefix=';' ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?;
	public NavigatingSemiArgCSElements getNavigatingSemiArgCSAccess() {
		return pNavigatingSemiArgCS;
	}

	public ParserRule getNavigatingSemiArgCSRule() {
		return getNavigatingSemiArgCSAccess().getRule();
	}

	//// Type-less init is an illegal infix expression
	//
	//NavigatingArgExpCS ExpCS:
	//	ExpCS// '?'	-- defined by Complete OCL
	//;
	public NavigatingArgExpCSElements getNavigatingArgExpCSAccess() {
		return pNavigatingArgExpCS;
	}

	public ParserRule getNavigatingArgExpCSRule() {
		return getNavigatingArgExpCSAccess().getRule();
	}

	//CoIteratorVariableCS VariableCS:
	//	name=UnrestrictedName (':' ownedType=TypeExpCS)?;
	public CoIteratorVariableCSElements getCoIteratorVariableCSAccess() {
		return pCoIteratorVariableCS;
	}

	public ParserRule getCoIteratorVariableCSRule() {
		return getCoIteratorVariableCSAccess().getRule();
	}

	//IfExpCS:
	//	'if' ownedCondition=(ExpCS | PatternExpCS)
	//	'then' ownedThenExpression=ExpCS
	////	ifThenExpressions+=IfThenExpCS
	//	ownedIfThenExpressions+=ElseIfThenExpCS*
	//	'else' ownedElseExpression=ExpCS
	//	'endif';
	public IfExpCSElements getIfExpCSAccess() {
		return pIfExpCS;
	}

	public ParserRule getIfExpCSRule() {
		return getIfExpCSAccess().getRule();
	}

	////IfThenExpCS returns IfThenExpCS:
	////	'if' condition=ExpCS
	////	'then' thenExpression=ExpCS
	////;
	//ElseIfThenExpCS IfThenExpCS:
	//	'elseif' ownedCondition=ExpCS
	//	'then' ownedThenExpression=ExpCS;
	public ElseIfThenExpCSElements getElseIfThenExpCSAccess() {
		return pElseIfThenExpCS;
	}

	public ParserRule getElseIfThenExpCSRule() {
		return getElseIfThenExpCSAccess().getRule();
	}

	//LetExpCS:
	//	'let' ownedVariables+=LetVariableCS (',' ownedVariables+=LetVariableCS)*
	//	'in' ownedInExpression=ExpCS;
	public LetExpCSElements getLetExpCSAccess() {
		return pLetExpCS;
	}

	public ParserRule getLetExpCSRule() {
		return getLetExpCSAccess().getRule();
	}

	//LetVariableCS:
	//	name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS? (':' ownedType=TypeExpCS)? '='
	//	ownedInitExpression=ExpCS;
	public LetVariableCSElements getLetVariableCSAccess() {
		return pLetVariableCS;
	}

	public ParserRule getLetVariableCSRule() {
		return getLetVariableCSAccess().getRule();
	}

	//NestedExpCS:
	//	'(' ownedExpression=ExpCS ')';
	public NestedExpCSElements getNestedExpCSAccess() {
		return pNestedExpCS;
	}

	public ParserRule getNestedExpCSRule() {
		return getNestedExpCSAccess().getRule();
	}

	//SelfExpCS:
	//	{SelfExpCS} 'self';
	public SelfExpCSElements getSelfExpCSAccess() {
		return pSelfExpCS;
	}

	public ParserRule getSelfExpCSRule() {
		return getSelfExpCSAccess().getRule();
	}

	//MultiplicityBoundsCS:
	//	lowerBound=LOWER ('..' upperBound=UPPER)?;
	public BaseGrammarAccess.MultiplicityBoundsCSElements getMultiplicityBoundsCSAccess() {
		return gaBase.getMultiplicityBoundsCSAccess();
	}

	public ParserRule getMultiplicityBoundsCSRule() {
		return getMultiplicityBoundsCSAccess().getRule();
	}

	//MultiplicityCS:
	//	'[' (MultiplicityBoundsCS | MultiplicityStringCS) ('|?' | isNullFree?='|1')? ']';
	public BaseGrammarAccess.MultiplicityCSElements getMultiplicityCSAccess() {
		return gaBase.getMultiplicityCSAccess();
	}

	public ParserRule getMultiplicityCSRule() {
		return getMultiplicityCSAccess().getRule();
	}

	//MultiplicityStringCS:
	//	stringBounds=('*' | '+' | '?');
	public BaseGrammarAccess.MultiplicityStringCSElements getMultiplicityStringCSAccess() {
		return gaBase.getMultiplicityStringCSAccess();
	}

	public ParserRule getMultiplicityStringCSRule() {
		return getMultiplicityStringCSAccess().getRule();
	}

	//PathNameCS:
	//	ownedPathElements+=FirstPathElementCS ('::' ownedPathElements+=NextPathElementCS)*;
	public BaseGrammarAccess.PathNameCSElements getPathNameCSAccess() {
		return gaBase.getPathNameCSAccess();
	}

	public ParserRule getPathNameCSRule() {
		return getPathNameCSAccess().getRule();
	}

	//UnreservedPathNameCS PathNameCS:
	//	ownedPathElements+=NextPathElementCS ('::' ownedPathElements+=NextPathElementCS)*;
	public BaseGrammarAccess.UnreservedPathNameCSElements getUnreservedPathNameCSAccess() {
		return gaBase.getUnreservedPathNameCSAccess();
	}

	public ParserRule getUnreservedPathNameCSRule() {
		return getUnreservedPathNameCSAccess().getRule();
	}

	//FirstPathElementCS PathElementCS:
	//	referredElement=[pivot::NamedElement|super::UnrestrictedName];
	public BaseGrammarAccess.FirstPathElementCSElements getFirstPathElementCSAccess() {
		return gaBase.getFirstPathElementCSAccess();
	}

	public ParserRule getFirstPathElementCSRule() {
		return getFirstPathElementCSAccess().getRule();
	}

	//NextPathElementCS PathElementCS:
	//	referredElement=[pivot::NamedElement|super::UnreservedName];
	public BaseGrammarAccess.NextPathElementCSElements getNextPathElementCSAccess() {
		return gaBase.getNextPathElementCSAccess();
	}

	public ParserRule getNextPathElementCSRule() {
		return getNextPathElementCSAccess().getRule();
	}

	//TemplateBindingCS:
	//	ownedSubstitutions+=TemplateParameterSubstitutionCS (',' ownedSubstitutions+=TemplateParameterSubstitutionCS)*
	//	ownedMultiplicity=MultiplicityCS?;
	public BaseGrammarAccess.TemplateBindingCSElements getTemplateBindingCSAccess() {
		return gaBase.getTemplateBindingCSAccess();
	}

	public ParserRule getTemplateBindingCSRule() {
		return getTemplateBindingCSAccess().getRule();
	}

	//TemplateParameterSubstitutionCS:
	//	ownedActualParameter=TypeRefCS;
	public BaseGrammarAccess.TemplateParameterSubstitutionCSElements getTemplateParameterSubstitutionCSAccess() {
		return gaBase.getTemplateParameterSubstitutionCSAccess();
	}

	public ParserRule getTemplateParameterSubstitutionCSRule() {
		return getTemplateParameterSubstitutionCSAccess().getRule();
	}

	//TemplateSignatureCS:
	//	'(' ownedParameters+=TypeParameterCS (',' ownedParameters+=TypeParameterCS)* ')';
	public BaseGrammarAccess.TemplateSignatureCSElements getTemplateSignatureCSAccess() {
		return gaBase.getTemplateSignatureCSAccess();
	}

	public ParserRule getTemplateSignatureCSRule() {
		return getTemplateSignatureCSAccess().getRule();
	}

	//TypeParameterCS:
	//	name=super::UnrestrictedName ('extends' ownedExtends+=TypedRefCS ('&&' ownedExtends+=TypedRefCS)*)?;
	public BaseGrammarAccess.TypeParameterCSElements getTypeParameterCSAccess() {
		return gaBase.getTypeParameterCSAccess();
	}

	public ParserRule getTypeParameterCSRule() {
		return getTypeParameterCSAccess().getRule();
	}

	//TypeRefCS:
	//	TypedRefCS | WildcardTypeRefCS;
	public BaseGrammarAccess.TypeRefCSElements getTypeRefCSAccess() {
		return gaBase.getTypeRefCSAccess();
	}

	public ParserRule getTypeRefCSRule() {
		return getTypeRefCSAccess().getRule();
	}

	//TypedRefCS:
	//	TypedTypeRefCS;
	public BaseGrammarAccess.TypedRefCSElements getTypedRefCSAccess() {
		return gaBase.getTypedRefCSAccess();
	}

	public ParserRule getTypedRefCSRule() {
		return getTypedRefCSAccess().getRule();
	}

	//TypedTypeRefCS:
	//	ownedPathName=PathNameCS ('(' ownedBinding=TemplateBindingCS ')')?;
	public BaseGrammarAccess.TypedTypeRefCSElements getTypedTypeRefCSAccess() {
		return gaBase.getTypedTypeRefCSAccess();
	}

	public ParserRule getTypedTypeRefCSRule() {
		return getTypedTypeRefCSAccess().getRule();
	}

	//WildcardTypeRefCS:
	//	{WildcardTypeRefCS} '?' ('extends' ownedExtends=TypedRefCS)?;
	public BaseGrammarAccess.WildcardTypeRefCSElements getWildcardTypeRefCSAccess() {
		return gaBase.getWildcardTypeRefCSAccess();
	}

	public ParserRule getWildcardTypeRefCSRule() {
		return getWildcardTypeRefCSAccess().getRule();
	}

	//ID:
	//	SIMPLE_ID | ESCAPED_ID;
	public BaseGrammarAccess.IDElements getIDAccess() {
		return gaBase.getIDAccess();
	}

	public ParserRule getIDRule() {
		return getIDAccess().getRule();
	}

	//Identifier:
	//	ID;
	public BaseGrammarAccess.IdentifierElements getIdentifierAccess() {
		return gaBase.getIdentifierAccess();
	}

	public ParserRule getIdentifierRule() {
		return getIdentifierAccess().getRule();
	}

	///* A lowerbounded integer is used to define the lowerbound of a collection multiplicity. The value may not be the unlimited value. */
	//LOWER ecore::EInt:
	//	INT;
	public BaseGrammarAccess.LOWERElements getLOWERAccess() {
		return gaBase.getLOWERAccess();
	}

	public ParserRule getLOWERRule() {
		return getLOWERAccess().getRule();
	}

	///* A number may be an integer or floating point value. The declaration here appears to be that for just an integer. This is to avoid
	// * lookahead conflicts in simple lexers between a dot within a floating point number and the dot-dot in a CollectionLiteralPartCS. A
	// * practical implementation should give high priority to a successful parse of INT ('.' INT)? (('e' | 'E') ('+' | '-')? INT)? than
	// * to the unsuccessful partial parse of INT '..'. The type of the INT terminal is String to allow the floating point syntax to be used.
	// */
	//NUMBER_LITERAL BigNumber:
	//	INT;
	public BaseGrammarAccess.NUMBER_LITERALElements getNUMBER_LITERALAccess() {
		return gaBase.getNUMBER_LITERALAccess();
	}

	public ParserRule getNUMBER_LITERALRule() {
		return getNUMBER_LITERALAccess().getRule();
	}

	//// EssentialOCLTokenSource pieces this together ('.' INT)? (('e' | 'E') ('+' | '-')? INT)?;
	//
	//StringLiteral:
	//	SINGLE_QUOTED_STRING;
	public BaseGrammarAccess.StringLiteralElements getStringLiteralAccess() {
		return gaBase.getStringLiteralAccess();
	}

	public ParserRule getStringLiteralRule() {
		return getStringLiteralAccess().getRule();
	}

	///* An upperbounded integer is used to define the upperbound of a collection multiplicity. The value may be the unlimited value. */
	//UPPER ecore::EInt:
	//	INT | '*';
	public BaseGrammarAccess.UPPERElements getUPPERAccess() {
		return gaBase.getUPPERAccess();
	}

	public ParserRule getUPPERRule() {
		return getUPPERAccess().getRule();
	}

	//URI:
	//	SINGLE_QUOTED_STRING;
	public BaseGrammarAccess.URIElements getURIAccess() {
		return gaBase.getURIAccess();
	}

	public ParserRule getURIRule() {
		return getURIAccess().getRule();
	}

	//terminal fragment ESCAPED_CHARACTER:
	//	'\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | "'" | '\\');
	public TerminalRule getESCAPED_CHARACTERRule() {
		return gaBase.getESCAPED_CHARACTERRule();
	}

	//terminal fragment LETTER_CHARACTER:
	//	'a'..'z' | 'A'..'Z' | '_';
	public TerminalRule getLETTER_CHARACTERRule() {
		return gaBase.getLETTER_CHARACTERRule();
	}

	//terminal DOUBLE_QUOTED_STRING:
	//	'"' (ESCAPED_CHARACTER | !('\\' | '"'))* '"';
	public TerminalRule getDOUBLE_QUOTED_STRINGRule() {
		return gaBase.getDOUBLE_QUOTED_STRINGRule();
	}

	//terminal SINGLE_QUOTED_STRING:
	//	"'" (ESCAPED_CHARACTER | !('\\' | "'"))* "'";
	public TerminalRule getSINGLE_QUOTED_STRINGRule() {
		return gaBase.getSINGLE_QUOTED_STRINGRule();
	}

	//terminal ML_SINGLE_QUOTED_STRING:
	//	"/'"->"'/";
	public TerminalRule getML_SINGLE_QUOTED_STRINGRule() {
		return gaBase.getML_SINGLE_QUOTED_STRINGRule();
	}

	//terminal SIMPLE_ID:
	//	LETTER_CHARACTER (LETTER_CHARACTER | '0'..'9')*;
	public TerminalRule getSIMPLE_IDRule() {
		return gaBase.getSIMPLE_IDRule();
	}

	//terminal ESCAPED_ID:
	//	"_" SINGLE_QUOTED_STRING;
	public TerminalRule getESCAPED_IDRule() {
		return gaBase.getESCAPED_IDRule();
	}

	//terminal INT:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaBase.getINTRule();
	}

	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaBase.getML_COMMENTRule();
	}

	//terminal SL_COMMENT:
	//	'--' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaBase.getSL_COMMENTRule();
	}

	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaBase.getWSRule();
	}

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaBase.getANY_OTHERRule();
	}
}
