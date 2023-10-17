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
package org.eclipse.ocl.xtext.base.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;


@Singleton
public class BaseGrammarAccess extends AbstractGrammarElementFinder {


	public class MultiplicityBoundsCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.MultiplicityBoundsCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cLowerBoundAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cLowerBoundLOWERParserRuleCall_0_0 = (RuleCall)cLowerBoundAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cUpperBoundAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cUpperBoundUPPERParserRuleCall_1_1_0 = (RuleCall)cUpperBoundAssignment_1_1.eContents().get(0);

		//MultiplicityBoundsCS:
		//	lowerBound=LOWER ('..' upperBound=UPPER)?;
		@Override public ParserRule getRule() { return rule; }

		//lowerBound=LOWER ('..' upperBound=UPPER)?
		public Group getGroup() { return cGroup; }

		//lowerBound=LOWER
		public Assignment getLowerBoundAssignment_0() { return cLowerBoundAssignment_0; }

		//LOWER
		public RuleCall getLowerBoundLOWERParserRuleCall_0_0() { return cLowerBoundLOWERParserRuleCall_0_0; }

		//('..' upperBound=UPPER)?
		public Group getGroup_1() { return cGroup_1; }

		//'..'
		public Keyword getFullStopFullStopKeyword_1_0() { return cFullStopFullStopKeyword_1_0; }

		//upperBound=UPPER
		public Assignment getUpperBoundAssignment_1_1() { return cUpperBoundAssignment_1_1; }

		//UPPER
		public RuleCall getUpperBoundUPPERParserRuleCall_1_1_0() { return cUpperBoundUPPERParserRuleCall_1_1_0; }
	}

	public class MultiplicityCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final RuleCall cMultiplicityBoundsCSParserRuleCall_1_0 = (RuleCall)cAlternatives_1.eContents().get(0);
		private final RuleCall cMultiplicityStringCSParserRuleCall_1_1 = (RuleCall)cAlternatives_1.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Keyword cVerticalLineQuestionMarkKeyword_2_0 = (Keyword)cAlternatives_2.eContents().get(0);
		private final Assignment cIsNullFreeAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final Keyword cIsNullFree1Keyword_2_1_0 = (Keyword)cIsNullFreeAssignment_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);

		//MultiplicityCS:
		//	'[' (MultiplicityBoundsCS | MultiplicityStringCS) ('|?' | isNullFree?='|1')? ']';
		@Override public ParserRule getRule() { return rule; }

		//'[' (MultiplicityBoundsCS | MultiplicityStringCS) ('|?' | isNullFree?='|1')? ']'
		public Group getGroup() { return cGroup; }

		//'['
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }

		//(MultiplicityBoundsCS | MultiplicityStringCS)
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//MultiplicityBoundsCS
		public RuleCall getMultiplicityBoundsCSParserRuleCall_1_0() { return cMultiplicityBoundsCSParserRuleCall_1_0; }

		//MultiplicityStringCS
		public RuleCall getMultiplicityStringCSParserRuleCall_1_1() { return cMultiplicityStringCSParserRuleCall_1_1; }

		//('|?' | isNullFree?='|1')?
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//'|?'
		public Keyword getVerticalLineQuestionMarkKeyword_2_0() { return cVerticalLineQuestionMarkKeyword_2_0; }

		//isNullFree?='|1'
		public Assignment getIsNullFreeAssignment_2_1() { return cIsNullFreeAssignment_2_1; }

		//'|1'
		public Keyword getIsNullFree1Keyword_2_1_0() { return cIsNullFree1Keyword_2_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_3() { return cRightSquareBracketKeyword_3; }
	}

	public class MultiplicityStringCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.MultiplicityStringCS");
		private final Assignment cStringBoundsAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cStringBoundsAlternatives_0 = (Alternatives)cStringBoundsAssignment.eContents().get(0);
		private final Keyword cStringBoundsAsteriskKeyword_0_0 = (Keyword)cStringBoundsAlternatives_0.eContents().get(0);
		private final Keyword cStringBoundsPlusSignKeyword_0_1 = (Keyword)cStringBoundsAlternatives_0.eContents().get(1);
		private final Keyword cStringBoundsQuestionMarkKeyword_0_2 = (Keyword)cStringBoundsAlternatives_0.eContents().get(2);

		//MultiplicityStringCS:
		//	stringBounds=('*' | '+' | '?');
		@Override public ParserRule getRule() { return rule; }

		//stringBounds=('*' | '+' | '?')
		public Assignment getStringBoundsAssignment() { return cStringBoundsAssignment; }

		//('*' | '+' | '?')
		public Alternatives getStringBoundsAlternatives_0() { return cStringBoundsAlternatives_0; }

		//'*'
		public Keyword getStringBoundsAsteriskKeyword_0_0() { return cStringBoundsAsteriskKeyword_0_0; }

		//'+'
		public Keyword getStringBoundsPlusSignKeyword_0_1() { return cStringBoundsPlusSignKeyword_0_1; }

		//'?'
		public Keyword getStringBoundsQuestionMarkKeyword_0_2() { return cStringBoundsQuestionMarkKeyword_0_2; }
	}

	public class PathNameCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.PathNameCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedPathElementsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedPathElementsFirstPathElementCSParserRuleCall_0_0 = (RuleCall)cOwnedPathElementsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedPathElementsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0 = (RuleCall)cOwnedPathElementsAssignment_1_1.eContents().get(0);

		//PathNameCS:
		//	ownedPathElements+=FirstPathElementCS ('::' ownedPathElements+=NextPathElementCS)*;
		@Override public ParserRule getRule() { return rule; }

		//ownedPathElements+=FirstPathElementCS ('::' ownedPathElements+=NextPathElementCS)*
		public Group getGroup() { return cGroup; }

		//ownedPathElements+=FirstPathElementCS
		public Assignment getOwnedPathElementsAssignment_0() { return cOwnedPathElementsAssignment_0; }

		//FirstPathElementCS
		public RuleCall getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0() { return cOwnedPathElementsFirstPathElementCSParserRuleCall_0_0; }

		//('::' ownedPathElements+=NextPathElementCS)*
		public Group getGroup_1() { return cGroup_1; }

		//'::'
		public Keyword getColonColonKeyword_1_0() { return cColonColonKeyword_1_0; }

		//ownedPathElements+=NextPathElementCS
		public Assignment getOwnedPathElementsAssignment_1_1() { return cOwnedPathElementsAssignment_1_1; }

		//NextPathElementCS
		public RuleCall getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0() { return cOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0; }
	}

	public class UnreservedPathNameCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.UnreservedPathNameCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedPathElementsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedPathElementsNextPathElementCSParserRuleCall_0_0 = (RuleCall)cOwnedPathElementsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedPathElementsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0 = (RuleCall)cOwnedPathElementsAssignment_1_1.eContents().get(0);

		//UnreservedPathNameCS PathNameCS:
		//	ownedPathElements+=NextPathElementCS ('::' ownedPathElements+=NextPathElementCS)*;
		@Override public ParserRule getRule() { return rule; }

		//ownedPathElements+=NextPathElementCS ('::' ownedPathElements+=NextPathElementCS)*
		public Group getGroup() { return cGroup; }

		//ownedPathElements+=NextPathElementCS
		public Assignment getOwnedPathElementsAssignment_0() { return cOwnedPathElementsAssignment_0; }

		//NextPathElementCS
		public RuleCall getOwnedPathElementsNextPathElementCSParserRuleCall_0_0() { return cOwnedPathElementsNextPathElementCSParserRuleCall_0_0; }

		//('::' ownedPathElements+=NextPathElementCS)*
		public Group getGroup_1() { return cGroup_1; }

		//'::'
		public Keyword getColonColonKeyword_1_0() { return cColonColonKeyword_1_0; }

		//ownedPathElements+=NextPathElementCS
		public Assignment getOwnedPathElementsAssignment_1_1() { return cOwnedPathElementsAssignment_1_1; }

		//NextPathElementCS
		public RuleCall getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0() { return cOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0; }
	}

	public class FirstPathElementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.FirstPathElementCS");
		private final Assignment cReferredElementAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cReferredElementNamedElementCrossReference_0 = (CrossReference)cReferredElementAssignment.eContents().get(0);
		private final RuleCall cReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1 = (RuleCall)cReferredElementNamedElementCrossReference_0.eContents().get(1);

		//FirstPathElementCS PathElementCS:
		//	referredElement=[pivot::NamedElement|UnrestrictedName];
		@Override public ParserRule getRule() { return rule; }

		//referredElement=[pivot::NamedElement|UnrestrictedName]
		public Assignment getReferredElementAssignment() { return cReferredElementAssignment; }

		//[pivot::NamedElement|UnrestrictedName]
		public CrossReference getReferredElementNamedElementCrossReference_0() { return cReferredElementNamedElementCrossReference_0; }

		//UnrestrictedName
		public RuleCall getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1() { return cReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1; }
	}

	public class NextPathElementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.NextPathElementCS");
		private final Assignment cReferredElementAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cReferredElementNamedElementCrossReference_0 = (CrossReference)cReferredElementAssignment.eContents().get(0);
		private final RuleCall cReferredElementNamedElementUnreservedNameParserRuleCall_0_1 = (RuleCall)cReferredElementNamedElementCrossReference_0.eContents().get(1);

		//NextPathElementCS PathElementCS:
		//	referredElement=[pivot::NamedElement|UnreservedName];
		@Override public ParserRule getRule() { return rule; }

		//referredElement=[pivot::NamedElement|UnreservedName]
		public Assignment getReferredElementAssignment() { return cReferredElementAssignment; }

		//[pivot::NamedElement|UnreservedName]
		public CrossReference getReferredElementNamedElementCrossReference_0() { return cReferredElementNamedElementCrossReference_0; }

		//UnreservedName
		public RuleCall getReferredElementNamedElementUnreservedNameParserRuleCall_0_1() { return cReferredElementNamedElementUnreservedNameParserRuleCall_0_1; }
	}

	public class TemplateBindingCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.TemplateBindingCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedSubstitutionsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0 = (RuleCall)cOwnedSubstitutionsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedSubstitutionsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0 = (RuleCall)cOwnedSubstitutionsAssignment_1_1.eContents().get(0);
		private final Assignment cOwnedMultiplicityAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedMultiplicityMultiplicityCSParserRuleCall_2_0 = (RuleCall)cOwnedMultiplicityAssignment_2.eContents().get(0);

		//TemplateBindingCS:
		//	ownedSubstitutions+=TemplateParameterSubstitutionCS (',' ownedSubstitutions+=TemplateParameterSubstitutionCS)*
		//	ownedMultiplicity=MultiplicityCS?;
		@Override public ParserRule getRule() { return rule; }

		//ownedSubstitutions+=TemplateParameterSubstitutionCS (',' ownedSubstitutions+=TemplateParameterSubstitutionCS)*
		//ownedMultiplicity=MultiplicityCS?
		public Group getGroup() { return cGroup; }

		//ownedSubstitutions+=TemplateParameterSubstitutionCS
		public Assignment getOwnedSubstitutionsAssignment_0() { return cOwnedSubstitutionsAssignment_0; }

		//TemplateParameterSubstitutionCS
		public RuleCall getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0() { return cOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0; }

		//(',' ownedSubstitutions+=TemplateParameterSubstitutionCS)*
		public Group getGroup_1() { return cGroup_1; }

		//','
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }

		//ownedSubstitutions+=TemplateParameterSubstitutionCS
		public Assignment getOwnedSubstitutionsAssignment_1_1() { return cOwnedSubstitutionsAssignment_1_1; }

		//TemplateParameterSubstitutionCS
		public RuleCall getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0() { return cOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0; }

		//ownedMultiplicity=MultiplicityCS?
		public Assignment getOwnedMultiplicityAssignment_2() { return cOwnedMultiplicityAssignment_2; }

		//MultiplicityCS
		public RuleCall getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0() { return cOwnedMultiplicityMultiplicityCSParserRuleCall_2_0; }
	}

	public class TemplateParameterSubstitutionCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.TemplateParameterSubstitutionCS");
		private final Assignment cOwnedActualParameterAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cOwnedActualParameterTypeRefCSParserRuleCall_0 = (RuleCall)cOwnedActualParameterAssignment.eContents().get(0);

		//TemplateParameterSubstitutionCS:
		//	ownedActualParameter=TypeRefCS;
		@Override public ParserRule getRule() { return rule; }

		//ownedActualParameter=TypeRefCS
		public Assignment getOwnedActualParameterAssignment() { return cOwnedActualParameterAssignment; }

		//TypeRefCS
		public RuleCall getOwnedActualParameterTypeRefCSParserRuleCall_0() { return cOwnedActualParameterTypeRefCSParserRuleCall_0; }
	}

	public class TemplateSignatureCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedParametersTypeParameterCSParserRuleCall_1_0 = (RuleCall)cOwnedParametersAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cCommaKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedParametersTypeParameterCSParserRuleCall_2_1_0 = (RuleCall)cOwnedParametersAssignment_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);

		//TemplateSignatureCS:
		//	'(' ownedParameters+=TypeParameterCS (',' ownedParameters+=TypeParameterCS)* ')';
		@Override public ParserRule getRule() { return rule; }

		//'(' ownedParameters+=TypeParameterCS (',' ownedParameters+=TypeParameterCS)* ')'
		public Group getGroup() { return cGroup; }

		//'('
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }

		//ownedParameters+=TypeParameterCS
		public Assignment getOwnedParametersAssignment_1() { return cOwnedParametersAssignment_1; }

		//TypeParameterCS
		public RuleCall getOwnedParametersTypeParameterCSParserRuleCall_1_0() { return cOwnedParametersTypeParameterCSParserRuleCall_1_0; }

		//(',' ownedParameters+=TypeParameterCS)*
		public Group getGroup_2() { return cGroup_2; }

		//','
		public Keyword getCommaKeyword_2_0() { return cCommaKeyword_2_0; }

		//ownedParameters+=TypeParameterCS
		public Assignment getOwnedParametersAssignment_2_1() { return cOwnedParametersAssignment_2_1; }

		//TypeParameterCS
		public RuleCall getOwnedParametersTypeParameterCSParserRuleCall_2_1_0() { return cOwnedParametersTypeParameterCSParserRuleCall_2_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class TypeParameterCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.TypeParameterCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cExtendsKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedExtendsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedExtendsTypedRefCSParserRuleCall_1_1_0 = (RuleCall)cOwnedExtendsAssignment_1_1.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Keyword cAmpersandAmpersandKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Assignment cOwnedExtendsAssignment_1_2_1 = (Assignment)cGroup_1_2.eContents().get(1);
		private final RuleCall cOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0 = (RuleCall)cOwnedExtendsAssignment_1_2_1.eContents().get(0);

		//TypeParameterCS:
		//	name=UnrestrictedName ('extends' ownedExtends+=TypedRefCS ('&&' ownedExtends+=TypedRefCS)*)?;
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName ('extends' ownedExtends+=TypedRefCS ('&&' ownedExtends+=TypedRefCS)*)?
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//('extends' ownedExtends+=TypedRefCS ('&&' ownedExtends+=TypedRefCS)*)?
		public Group getGroup_1() { return cGroup_1; }

		//'extends'
		public Keyword getExtendsKeyword_1_0() { return cExtendsKeyword_1_0; }

		//ownedExtends+=TypedRefCS
		public Assignment getOwnedExtendsAssignment_1_1() { return cOwnedExtendsAssignment_1_1; }

		//TypedRefCS
		public RuleCall getOwnedExtendsTypedRefCSParserRuleCall_1_1_0() { return cOwnedExtendsTypedRefCSParserRuleCall_1_1_0; }

		//('&&' ownedExtends+=TypedRefCS)*
		public Group getGroup_1_2() { return cGroup_1_2; }

		//'&&'
		public Keyword getAmpersandAmpersandKeyword_1_2_0() { return cAmpersandAmpersandKeyword_1_2_0; }

		//ownedExtends+=TypedRefCS
		public Assignment getOwnedExtendsAssignment_1_2_1() { return cOwnedExtendsAssignment_1_2_1; }

		//TypedRefCS
		public RuleCall getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0() { return cOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0; }
	}

	public class TypeRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.TypeRefCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTypedRefCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cWildcardTypeRefCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		//TypeRefCS:
		//	TypedRefCS | WildcardTypeRefCS;
		@Override public ParserRule getRule() { return rule; }

		//TypedRefCS | WildcardTypeRefCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//TypedRefCS
		public RuleCall getTypedRefCSParserRuleCall_0() { return cTypedRefCSParserRuleCall_0; }

		//WildcardTypeRefCS
		public RuleCall getWildcardTypeRefCSParserRuleCall_1() { return cWildcardTypeRefCSParserRuleCall_1; }
	}

	public class TypedRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.TypedRefCS");
		private final RuleCall cTypedTypeRefCSParserRuleCall = (RuleCall)rule.eContents().get(1);

		//TypedRefCS:
		//	TypedTypeRefCS;
		@Override public ParserRule getRule() { return rule; }

		//TypedTypeRefCS
		public RuleCall getTypedTypeRefCSParserRuleCall() { return cTypedTypeRefCSParserRuleCall; }
	}

	public class TypedTypeRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.TypedTypeRefCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedPathNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedPathNamePathNameCSParserRuleCall_0_0 = (RuleCall)cOwnedPathNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedBindingAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedBindingTemplateBindingCSParserRuleCall_1_1_0 = (RuleCall)cOwnedBindingAssignment_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);

		//TypedTypeRefCS:
		//	ownedPathName=PathNameCS ('(' ownedBinding=TemplateBindingCS ')')?;
		@Override public ParserRule getRule() { return rule; }

		//ownedPathName=PathNameCS ('(' ownedBinding=TemplateBindingCS ')')?
		public Group getGroup() { return cGroup; }

		//ownedPathName=PathNameCS
		public Assignment getOwnedPathNameAssignment_0() { return cOwnedPathNameAssignment_0; }

		//PathNameCS
		public RuleCall getOwnedPathNamePathNameCSParserRuleCall_0_0() { return cOwnedPathNamePathNameCSParserRuleCall_0_0; }

		//('(' ownedBinding=TemplateBindingCS ')')?
		public Group getGroup_1() { return cGroup_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_1_0() { return cLeftParenthesisKeyword_1_0; }

		//ownedBinding=TemplateBindingCS
		public Assignment getOwnedBindingAssignment_1_1() { return cOwnedBindingAssignment_1_1; }

		//TemplateBindingCS
		public RuleCall getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0() { return cOwnedBindingTemplateBindingCSParserRuleCall_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_1_2() { return cRightParenthesisKeyword_1_2; }
	}

	public class UnreservedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.UnreservedName");
		private final RuleCall cUnrestrictedNameParserRuleCall = (RuleCall)rule.eContents().get(1);

		//UnreservedName:
		//	UnrestrictedName;
		@Override public ParserRule getRule() { return rule; }

		//// Intended to be overridden
		//	UnrestrictedName
		public RuleCall getUnrestrictedNameParserRuleCall() { return cUnrestrictedNameParserRuleCall; }
	}

	public class UnrestrictedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.UnrestrictedName");
		private final RuleCall cIdentifierParserRuleCall = (RuleCall)rule.eContents().get(1);

		//UnrestrictedName:
		//	Identifier;
		@Override public ParserRule getRule() { return rule; }

		//// Intended to be overridden
		//	Identifier
		public RuleCall getIdentifierParserRuleCall() { return cIdentifierParserRuleCall; }
	}

	public class WildcardTypeRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.WildcardTypeRefCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cWildcardTypeRefCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cQuestionMarkKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cExtendsKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedExtendsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedExtendsTypedRefCSParserRuleCall_2_1_0 = (RuleCall)cOwnedExtendsAssignment_2_1.eContents().get(0);

		//WildcardTypeRefCS:
		//	{WildcardTypeRefCS} '?' ('extends' ownedExtends=TypedRefCS)?;
		@Override public ParserRule getRule() { return rule; }

		//{WildcardTypeRefCS} '?' ('extends' ownedExtends=TypedRefCS)?
		public Group getGroup() { return cGroup; }

		//{WildcardTypeRefCS}
		public Action getWildcardTypeRefCSAction_0() { return cWildcardTypeRefCSAction_0; }

		//'?'
		public Keyword getQuestionMarkKeyword_1() { return cQuestionMarkKeyword_1; }

		//('extends' ownedExtends=TypedRefCS)?
		public Group getGroup_2() { return cGroup_2; }

		//'extends'
		public Keyword getExtendsKeyword_2_0() { return cExtendsKeyword_2_0; }

		//ownedExtends=TypedRefCS
		public Assignment getOwnedExtendsAssignment_2_1() { return cOwnedExtendsAssignment_2_1; }

		//TypedRefCS
		public RuleCall getOwnedExtendsTypedRefCSParserRuleCall_2_1_0() { return cOwnedExtendsTypedRefCSParserRuleCall_2_1_0; }
	}

	public class IDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.ID");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSIMPLE_IDTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cESCAPED_IDTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		//ID:
		//	SIMPLE_ID | ESCAPED_ID;
		@Override public ParserRule getRule() { return rule; }

		//SIMPLE_ID | ESCAPED_ID
		public Alternatives getAlternatives() { return cAlternatives; }

		//SIMPLE_ID
		public RuleCall getSIMPLE_IDTerminalRuleCall_0() { return cSIMPLE_IDTerminalRuleCall_0; }

		//ESCAPED_ID
		public RuleCall getESCAPED_IDTerminalRuleCall_1() { return cESCAPED_IDTerminalRuleCall_1; }
	}

	public class IdentifierElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.Identifier");
		private final RuleCall cIDParserRuleCall = (RuleCall)rule.eContents().get(1);

		//Identifier:
		//	ID;
		@Override public ParserRule getRule() { return rule; }

		//ID
		public RuleCall getIDParserRuleCall() { return cIDParserRuleCall; }
	}

	public class LOWERElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.LOWER");
		private final RuleCall cINTTerminalRuleCall = (RuleCall)rule.eContents().get(1);

		///* A lowerbounded integer is used to define the lowerbound of a collection multiplicity. The value may not be the unlimited value. */
		//LOWER ecore::EInt:
		//	INT;
		@Override public ParserRule getRule() { return rule; }

		//INT
		public RuleCall getINTTerminalRuleCall() { return cINTTerminalRuleCall; }
	}

	public class NUMBER_LITERALElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.NUMBER_LITERAL");
		private final RuleCall cINTTerminalRuleCall = (RuleCall)rule.eContents().get(1);

		///* A number may be an integer or floating point value. The declaration here appears to be that for just an integer. This is to avoid
		// * lookahead conflicts in simple lexers between a dot within a floating point number and the dot-dot in a CollectionLiteralPartCS. A
		// * practical implementation should give high priority to a successful parse of INT ('.' INT)? (('e' | 'E') ('+' | '-')? INT)? than
		// * to the unsuccessful partial parse of INT '..'. The type of the INT terminal is String to allow the floating point syntax to be used.
		// */
		//NUMBER_LITERAL BigNumber:
		//	INT;
		@Override public ParserRule getRule() { return rule; }

		//// Not terminal to allow parser backtracking to sort out "5..7"
		//	INT
		public RuleCall getINTTerminalRuleCall() { return cINTTerminalRuleCall; }
	}

	public class StringLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.StringLiteral");
		private final RuleCall cSINGLE_QUOTED_STRINGTerminalRuleCall = (RuleCall)rule.eContents().get(1);

		//// EssentialOCLTokenSource pieces this together ('.' INT)? (('e' | 'E') ('+' | '-')? INT)?;
		//
		//StringLiteral:
		//	SINGLE_QUOTED_STRING;
		@Override public ParserRule getRule() { return rule; }

		//SINGLE_QUOTED_STRING
		public RuleCall getSINGLE_QUOTED_STRINGTerminalRuleCall() { return cSINGLE_QUOTED_STRINGTerminalRuleCall; }
	}

	public class UPPERElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.UPPER");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cAsteriskKeyword_1 = (Keyword)cAlternatives.eContents().get(1);

		///* An upperbounded integer is used to define the upperbound of a collection multiplicity. The value may be the unlimited value. */
		//UPPER ecore::EInt:
		//	INT | '*';
		@Override public ParserRule getRule() { return rule; }

		//INT | '*'
		public Alternatives getAlternatives() { return cAlternatives; }

		//INT
		public RuleCall getINTTerminalRuleCall_0() { return cINTTerminalRuleCall_0; }

		//'*'
		public Keyword getAsteriskKeyword_1() { return cAsteriskKeyword_1; }
	}

	public class URIElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.URI");
		private final RuleCall cSINGLE_QUOTED_STRINGTerminalRuleCall = (RuleCall)rule.eContents().get(1);

		//URI:
		//	SINGLE_QUOTED_STRING;
		@Override public ParserRule getRule() { return rule; }

		//SINGLE_QUOTED_STRING
		public RuleCall getSINGLE_QUOTED_STRINGTerminalRuleCall() { return cSINGLE_QUOTED_STRINGTerminalRuleCall; }
	}


	private final MultiplicityBoundsCSElements pMultiplicityBoundsCS;
	private final MultiplicityCSElements pMultiplicityCS;
	private final MultiplicityStringCSElements pMultiplicityStringCS;
	private final PathNameCSElements pPathNameCS;
	private final UnreservedPathNameCSElements pUnreservedPathNameCS;
	private final FirstPathElementCSElements pFirstPathElementCS;
	private final NextPathElementCSElements pNextPathElementCS;
	private final TemplateBindingCSElements pTemplateBindingCS;
	private final TemplateParameterSubstitutionCSElements pTemplateParameterSubstitutionCS;
	private final TemplateSignatureCSElements pTemplateSignatureCS;
	private final TypeParameterCSElements pTypeParameterCS;
	private final TypeRefCSElements pTypeRefCS;
	private final TypedRefCSElements pTypedRefCS;
	private final TypedTypeRefCSElements pTypedTypeRefCS;
	private final UnreservedNameElements pUnreservedName;
	private final UnrestrictedNameElements pUnrestrictedName;
	private final WildcardTypeRefCSElements pWildcardTypeRefCS;
	private final IDElements pID;
	private final IdentifierElements pIdentifier;
	private final LOWERElements pLOWER;
	private final NUMBER_LITERALElements pNUMBER_LITERAL;
	private final StringLiteralElements pStringLiteral;
	private final UPPERElements pUPPER;
	private final URIElements pURI;
	private final TerminalRule tESCAPED_CHARACTER;
	private final TerminalRule tLETTER_CHARACTER;
	private final TerminalRule tDOUBLE_QUOTED_STRING;
	private final TerminalRule tSINGLE_QUOTED_STRING;
	private final TerminalRule tML_SINGLE_QUOTED_STRING;
	private final TerminalRule tSIMPLE_ID;
	private final TerminalRule tESCAPED_ID;
	private final TerminalRule tINT;
	private final TerminalRule tML_COMMENT;
	private final TerminalRule tSL_COMMENT;
	private final TerminalRule tWS;
	private final TerminalRule tANY_OTHER;

	private final Grammar grammar;

	@Inject
	public BaseGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.pMultiplicityBoundsCS = new MultiplicityBoundsCSElements();
		this.pMultiplicityCS = new MultiplicityCSElements();
		this.pMultiplicityStringCS = new MultiplicityStringCSElements();
		this.pPathNameCS = new PathNameCSElements();
		this.pUnreservedPathNameCS = new UnreservedPathNameCSElements();
		this.pFirstPathElementCS = new FirstPathElementCSElements();
		this.pNextPathElementCS = new NextPathElementCSElements();
		this.pTemplateBindingCS = new TemplateBindingCSElements();
		this.pTemplateParameterSubstitutionCS = new TemplateParameterSubstitutionCSElements();
		this.pTemplateSignatureCS = new TemplateSignatureCSElements();
		this.pTypeParameterCS = new TypeParameterCSElements();
		this.pTypeRefCS = new TypeRefCSElements();
		this.pTypedRefCS = new TypedRefCSElements();
		this.pTypedTypeRefCS = new TypedTypeRefCSElements();
		this.pUnreservedName = new UnreservedNameElements();
		this.pUnrestrictedName = new UnrestrictedNameElements();
		this.pWildcardTypeRefCS = new WildcardTypeRefCSElements();
		this.pID = new IDElements();
		this.pIdentifier = new IdentifierElements();
		this.pLOWER = new LOWERElements();
		this.pNUMBER_LITERAL = new NUMBER_LITERALElements();
		this.pStringLiteral = new StringLiteralElements();
		this.pUPPER = new UPPERElements();
		this.pURI = new URIElements();
		this.tESCAPED_CHARACTER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.ESCAPED_CHARACTER");
		this.tLETTER_CHARACTER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.LETTER_CHARACTER");
		this.tDOUBLE_QUOTED_STRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.DOUBLE_QUOTED_STRING");
		this.tSINGLE_QUOTED_STRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");
		this.tML_SINGLE_QUOTED_STRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.ML_SINGLE_QUOTED_STRING");
		this.tSIMPLE_ID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.SIMPLE_ID");
		this.tESCAPED_ID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.ESCAPED_ID");
		this.tINT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.INT");
		this.tML_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.ML_COMMENT");
		this.tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.SL_COMMENT");
		this.tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.WS");
		this.tANY_OTHER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.base.Base.ANY_OTHER");
	}

	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.ocl.xtext.base.Base".equals(grammar.getName())) {
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



	//MultiplicityBoundsCS:
	//	lowerBound=LOWER ('..' upperBound=UPPER)?;
	public MultiplicityBoundsCSElements getMultiplicityBoundsCSAccess() {
		return pMultiplicityBoundsCS;
	}

	public ParserRule getMultiplicityBoundsCSRule() {
		return getMultiplicityBoundsCSAccess().getRule();
	}

	//MultiplicityCS:
	//	'[' (MultiplicityBoundsCS | MultiplicityStringCS) ('|?' | isNullFree?='|1')? ']';
	public MultiplicityCSElements getMultiplicityCSAccess() {
		return pMultiplicityCS;
	}

	public ParserRule getMultiplicityCSRule() {
		return getMultiplicityCSAccess().getRule();
	}

	//MultiplicityStringCS:
	//	stringBounds=('*' | '+' | '?');
	public MultiplicityStringCSElements getMultiplicityStringCSAccess() {
		return pMultiplicityStringCS;
	}

	public ParserRule getMultiplicityStringCSRule() {
		return getMultiplicityStringCSAccess().getRule();
	}

	//PathNameCS:
	//	ownedPathElements+=FirstPathElementCS ('::' ownedPathElements+=NextPathElementCS)*;
	public PathNameCSElements getPathNameCSAccess() {
		return pPathNameCS;
	}

	public ParserRule getPathNameCSRule() {
		return getPathNameCSAccess().getRule();
	}

	//UnreservedPathNameCS PathNameCS:
	//	ownedPathElements+=NextPathElementCS ('::' ownedPathElements+=NextPathElementCS)*;
	public UnreservedPathNameCSElements getUnreservedPathNameCSAccess() {
		return pUnreservedPathNameCS;
	}

	public ParserRule getUnreservedPathNameCSRule() {
		return getUnreservedPathNameCSAccess().getRule();
	}

	//FirstPathElementCS PathElementCS:
	//	referredElement=[pivot::NamedElement|UnrestrictedName];
	public FirstPathElementCSElements getFirstPathElementCSAccess() {
		return pFirstPathElementCS;
	}

	public ParserRule getFirstPathElementCSRule() {
		return getFirstPathElementCSAccess().getRule();
	}

	//NextPathElementCS PathElementCS:
	//	referredElement=[pivot::NamedElement|UnreservedName];
	public NextPathElementCSElements getNextPathElementCSAccess() {
		return pNextPathElementCS;
	}

	public ParserRule getNextPathElementCSRule() {
		return getNextPathElementCSAccess().getRule();
	}

	//TemplateBindingCS:
	//	ownedSubstitutions+=TemplateParameterSubstitutionCS (',' ownedSubstitutions+=TemplateParameterSubstitutionCS)*
	//	ownedMultiplicity=MultiplicityCS?;
	public TemplateBindingCSElements getTemplateBindingCSAccess() {
		return pTemplateBindingCS;
	}

	public ParserRule getTemplateBindingCSRule() {
		return getTemplateBindingCSAccess().getRule();
	}

	//TemplateParameterSubstitutionCS:
	//	ownedActualParameter=TypeRefCS;
	public TemplateParameterSubstitutionCSElements getTemplateParameterSubstitutionCSAccess() {
		return pTemplateParameterSubstitutionCS;
	}

	public ParserRule getTemplateParameterSubstitutionCSRule() {
		return getTemplateParameterSubstitutionCSAccess().getRule();
	}

	//TemplateSignatureCS:
	//	'(' ownedParameters+=TypeParameterCS (',' ownedParameters+=TypeParameterCS)* ')';
	public TemplateSignatureCSElements getTemplateSignatureCSAccess() {
		return pTemplateSignatureCS;
	}

	public ParserRule getTemplateSignatureCSRule() {
		return getTemplateSignatureCSAccess().getRule();
	}

	//TypeParameterCS:
	//	name=UnrestrictedName ('extends' ownedExtends+=TypedRefCS ('&&' ownedExtends+=TypedRefCS)*)?;
	public TypeParameterCSElements getTypeParameterCSAccess() {
		return pTypeParameterCS;
	}

	public ParserRule getTypeParameterCSRule() {
		return getTypeParameterCSAccess().getRule();
	}

	//TypeRefCS:
	//	TypedRefCS | WildcardTypeRefCS;
	public TypeRefCSElements getTypeRefCSAccess() {
		return pTypeRefCS;
	}

	public ParserRule getTypeRefCSRule() {
		return getTypeRefCSAccess().getRule();
	}

	//TypedRefCS:
	//	TypedTypeRefCS;
	public TypedRefCSElements getTypedRefCSAccess() {
		return pTypedRefCS;
	}

	public ParserRule getTypedRefCSRule() {
		return getTypedRefCSAccess().getRule();
	}

	//TypedTypeRefCS:
	//	ownedPathName=PathNameCS ('(' ownedBinding=TemplateBindingCS ')')?;
	public TypedTypeRefCSElements getTypedTypeRefCSAccess() {
		return pTypedTypeRefCS;
	}

	public ParserRule getTypedTypeRefCSRule() {
		return getTypedTypeRefCSAccess().getRule();
	}

	//UnreservedName:
	//	UnrestrictedName;
	public UnreservedNameElements getUnreservedNameAccess() {
		return pUnreservedName;
	}

	public ParserRule getUnreservedNameRule() {
		return getUnreservedNameAccess().getRule();
	}

	//UnrestrictedName:
	//	Identifier;
	public UnrestrictedNameElements getUnrestrictedNameAccess() {
		return pUnrestrictedName;
	}

	public ParserRule getUnrestrictedNameRule() {
		return getUnrestrictedNameAccess().getRule();
	}

	//WildcardTypeRefCS:
	//	{WildcardTypeRefCS} '?' ('extends' ownedExtends=TypedRefCS)?;
	public WildcardTypeRefCSElements getWildcardTypeRefCSAccess() {
		return pWildcardTypeRefCS;
	}

	public ParserRule getWildcardTypeRefCSRule() {
		return getWildcardTypeRefCSAccess().getRule();
	}

	//ID:
	//	SIMPLE_ID | ESCAPED_ID;
	public IDElements getIDAccess() {
		return pID;
	}

	public ParserRule getIDRule() {
		return getIDAccess().getRule();
	}

	//Identifier:
	//	ID;
	public IdentifierElements getIdentifierAccess() {
		return pIdentifier;
	}

	public ParserRule getIdentifierRule() {
		return getIdentifierAccess().getRule();
	}

	///* A lowerbounded integer is used to define the lowerbound of a collection multiplicity. The value may not be the unlimited value. */
	//LOWER ecore::EInt:
	//	INT;
	public LOWERElements getLOWERAccess() {
		return pLOWER;
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
	public NUMBER_LITERALElements getNUMBER_LITERALAccess() {
		return pNUMBER_LITERAL;
	}

	public ParserRule getNUMBER_LITERALRule() {
		return getNUMBER_LITERALAccess().getRule();
	}

	//// EssentialOCLTokenSource pieces this together ('.' INT)? (('e' | 'E') ('+' | '-')? INT)?;
	//
	//StringLiteral:
	//	SINGLE_QUOTED_STRING;
	public StringLiteralElements getStringLiteralAccess() {
		return pStringLiteral;
	}

	public ParserRule getStringLiteralRule() {
		return getStringLiteralAccess().getRule();
	}

	///* An upperbounded integer is used to define the upperbound of a collection multiplicity. The value may be the unlimited value. */
	//UPPER ecore::EInt:
	//	INT | '*';
	public UPPERElements getUPPERAccess() {
		return pUPPER;
	}

	public ParserRule getUPPERRule() {
		return getUPPERAccess().getRule();
	}

	//URI:
	//	SINGLE_QUOTED_STRING;
	public URIElements getURIAccess() {
		return pURI;
	}

	public ParserRule getURIRule() {
		return getURIAccess().getRule();
	}

	//terminal fragment ESCAPED_CHARACTER:
	//	'\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | "'" | '\\');
	public TerminalRule getESCAPED_CHARACTERRule() {
		return tESCAPED_CHARACTER;
	}

	//terminal fragment LETTER_CHARACTER:
	//	'a'..'z' | 'A'..'Z' | '_';
	public TerminalRule getLETTER_CHARACTERRule() {
		return tLETTER_CHARACTER;
	}

	//terminal DOUBLE_QUOTED_STRING:
	//	'"' (ESCAPED_CHARACTER | !('\\' | '"'))* '"';
	public TerminalRule getDOUBLE_QUOTED_STRINGRule() {
		return tDOUBLE_QUOTED_STRING;
	}

	//terminal SINGLE_QUOTED_STRING:
	//	"'" (ESCAPED_CHARACTER | !('\\' | "'"))* "'";
	public TerminalRule getSINGLE_QUOTED_STRINGRule() {
		return tSINGLE_QUOTED_STRING;
	}

	//terminal ML_SINGLE_QUOTED_STRING:
	//	"/'"->"'/";
	public TerminalRule getML_SINGLE_QUOTED_STRINGRule() {
		return tML_SINGLE_QUOTED_STRING;
	}

	//terminal SIMPLE_ID:
	//	LETTER_CHARACTER (LETTER_CHARACTER | '0'..'9')*;
	public TerminalRule getSIMPLE_IDRule() {
		return tSIMPLE_ID;
	}

	//terminal ESCAPED_ID:
	//	"_" SINGLE_QUOTED_STRING;
	public TerminalRule getESCAPED_IDRule() {
		return tESCAPED_ID;
	}

	//terminal INT:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return tINT;
	}

	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return tML_COMMENT;
	}

	//terminal SL_COMMENT:
	//	'--' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return tSL_COMMENT;
	}

	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return tWS;
	}

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return tANY_OTHER;
	}
}
