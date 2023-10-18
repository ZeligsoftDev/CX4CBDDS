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
package org.eclipse.ocl.xtext.oclstdlib.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;

@Singleton
public class OCLstdlibGrammarAccess extends AbstractGrammarElementFinder {


	public class LibraryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Library");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cOwnedImportsAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cOwnedImportsImportCSParserRuleCall_0_0_0 = (RuleCall)cOwnedImportsAssignment_0_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cOwnedPackagesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedPackagesLibPackageCSParserRuleCall_1_0 = (RuleCall)cOwnedPackagesAssignment_1.eContents().get(0);

		////generate OCLstdlib "http://www.eclipse.org/ocl/examples/xtext/oclstdlib/OCLstdlibCST"
		//Library LibRootPackageCS:
		//	(ownedImports+=ImportCS ';')*
		//	ownedPackages+=LibPackageCS*;
		@Override public ParserRule getRule() { return rule; }

		//(ownedImports+=ImportCS ';')*
		//ownedPackages+=LibPackageCS*
		public Group getGroup() { return cGroup; }

		//(ownedImports+=ImportCS ';')*
		public Group getGroup_0() { return cGroup_0; }

		//ownedImports+=ImportCS
		public Assignment getOwnedImportsAssignment_0_0() { return cOwnedImportsAssignment_0_0; }

		//ImportCS
		public RuleCall getOwnedImportsImportCSParserRuleCall_0_0_0() { return cOwnedImportsImportCSParserRuleCall_0_0_0; }

		//';'
		public Keyword getSemicolonKeyword_0_1() { return cSemicolonKeyword_0_1; }

		//ownedPackages+=LibPackageCS*
		public Assignment getOwnedPackagesAssignment_1() { return cOwnedPackagesAssignment_1; }

		//LibPackageCS
		public RuleCall getOwnedPackagesLibPackageCSParserRuleCall_1_0() { return cOwnedPackagesLibPackageCSParserRuleCall_1_0; }
	}

	public class IdentifierElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Identifier");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIDParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRestrictedKeywordsParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		//@Override
		//Identifier:
		//	ID
		//	| RestrictedKeywords;
		@Override public ParserRule getRule() { return rule; }

		//ID
		//| RestrictedKeywords
		public Alternatives getAlternatives() { return cAlternatives; }

		//ID
		public RuleCall getIDParserRuleCall_0() { return cIDParserRuleCall_0; }

		//RestrictedKeywords
		public RuleCall getRestrictedKeywordsParserRuleCall_1() { return cRestrictedKeywordsParserRuleCall_1; }
	}

	public class RestrictedKeywordsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.RestrictedKeywords");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAbstractKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cAnnotationKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cConformsToKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cDocumentationKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cExtendsKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cImportKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cInvKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cInvalidatingKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cIterationKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cLeftKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cLibraryKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cOperationKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Keyword cOppositeKeyword_12 = (Keyword)cAlternatives.eContents().get(12);
		private final Keyword cPackageKeyword_13 = (Keyword)cAlternatives.eContents().get(13);
		private final Keyword cPostKeyword_14 = (Keyword)cAlternatives.eContents().get(14);
		private final Keyword cPreKeyword_15 = (Keyword)cAlternatives.eContents().get(15);
		private final Keyword cPrecedenceKeyword_16 = (Keyword)cAlternatives.eContents().get(16);
		private final Keyword cPropertyKeyword_17 = (Keyword)cAlternatives.eContents().get(17);
		private final Keyword cRightKeyword_18 = (Keyword)cAlternatives.eContents().get(18);
		private final Keyword cStaticKeyword_19 = (Keyword)cAlternatives.eContents().get(19);
		private final Keyword cTypeKeyword_20 = (Keyword)cAlternatives.eContents().get(20);
		private final Keyword cValidatingKeyword_21 = (Keyword)cAlternatives.eContents().get(21);

		//RestrictedKeywords:
		//	'abstract'
		//	| 'annotation'
		//	| 'conformsTo'
		//	| 'documentation'
		//	| 'extends'
		//	| 'import'
		//	| 'inv'
		//	| 'invalidating'
		//	| 'iteration'
		//	| 'left'
		//	| 'library'
		//	| 'operation'
		//	| 'opposite'
		//	| 'package'
		//	| 'post'
		//	| 'pre'
		//	| 'precedence'
		//	| 'property'
		//	| 'right'
		//	| 'static'
		//	| 'type'
		////|	'typeof'
		//	| 'validating'//|	'Lambda'
		////|	'Tuple'
		//;
		@Override public ParserRule getRule() { return rule; }

		//'abstract'
		//| 'annotation'
		//| 'conformsTo'
		//| 'documentation'
		//| 'extends'
		//| 'import'
		//| 'inv'
		//| 'invalidating'
		//| 'iteration'
		//| 'left'
		//| 'library'
		//| 'operation'
		//| 'opposite'
		//| 'package'
		//| 'post'
		//| 'pre'
		//| 'precedence'
		//| 'property'
		//| 'right'
		//| 'static'
		//| 'type'
		////|	'typeof'
		//| 'validating'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'abstract'
		public Keyword getAbstractKeyword_0() { return cAbstractKeyword_0; }

		//'annotation'
		public Keyword getAnnotationKeyword_1() { return cAnnotationKeyword_1; }

		//'conformsTo'
		public Keyword getConformsToKeyword_2() { return cConformsToKeyword_2; }

		//'documentation'
		public Keyword getDocumentationKeyword_3() { return cDocumentationKeyword_3; }

		//'extends'
		public Keyword getExtendsKeyword_4() { return cExtendsKeyword_4; }

		//'import'
		public Keyword getImportKeyword_5() { return cImportKeyword_5; }

		//'inv'
		public Keyword getInvKeyword_6() { return cInvKeyword_6; }

		//'invalidating'
		public Keyword getInvalidatingKeyword_7() { return cInvalidatingKeyword_7; }

		//'iteration'
		public Keyword getIterationKeyword_8() { return cIterationKeyword_8; }

		//'left'
		public Keyword getLeftKeyword_9() { return cLeftKeyword_9; }

		//'library'
		public Keyword getLibraryKeyword_10() { return cLibraryKeyword_10; }

		//'operation'
		public Keyword getOperationKeyword_11() { return cOperationKeyword_11; }

		//'opposite'
		public Keyword getOppositeKeyword_12() { return cOppositeKeyword_12; }

		//'package'
		public Keyword getPackageKeyword_13() { return cPackageKeyword_13; }

		//'post'
		public Keyword getPostKeyword_14() { return cPostKeyword_14; }

		//'pre'
		public Keyword getPreKeyword_15() { return cPreKeyword_15; }

		//'precedence'
		public Keyword getPrecedenceKeyword_16() { return cPrecedenceKeyword_16; }

		//'property'
		public Keyword getPropertyKeyword_17() { return cPropertyKeyword_17; }

		//'right'
		public Keyword getRightKeyword_18() { return cRightKeyword_18; }

		//'static'
		public Keyword getStaticKeyword_19() { return cStaticKeyword_19; }

		//'type'
		public Keyword getTypeKeyword_20() { return cTypeKeyword_20; }

		//'validating'
		public Keyword getValidatingKeyword_21() { return cValidatingKeyword_21; }
	}

	public class NameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Name");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIdentifierParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDOUBLE_QUOTED_STRINGTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cEssentialOCLReservedKeywordParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cPrimitiveTypeIdentifierParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cCollectionTypeIdentifierParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);

		//Name:
		//	Identifier
		//	| DOUBLE_QUOTED_STRING
		//	| EssentialOCLReservedKeyword
		//	| PrimitiveTypeIdentifier
		//	| CollectionTypeIdentifier;
		@Override public ParserRule getRule() { return rule; }

		//Identifier
		//| DOUBLE_QUOTED_STRING
		//| EssentialOCLReservedKeyword
		//| PrimitiveTypeIdentifier
		//| CollectionTypeIdentifier
		public Alternatives getAlternatives() { return cAlternatives; }

		//Identifier
		public RuleCall getIdentifierParserRuleCall_0() { return cIdentifierParserRuleCall_0; }

		//DOUBLE_QUOTED_STRING
		public RuleCall getDOUBLE_QUOTED_STRINGTerminalRuleCall_1() { return cDOUBLE_QUOTED_STRINGTerminalRuleCall_1; }

		//EssentialOCLReservedKeyword
		public RuleCall getEssentialOCLReservedKeywordParserRuleCall_2() { return cEssentialOCLReservedKeywordParserRuleCall_2; }

		//PrimitiveTypeIdentifier
		public RuleCall getPrimitiveTypeIdentifierParserRuleCall_3() { return cPrimitiveTypeIdentifierParserRuleCall_3; }

		//CollectionTypeIdentifier
		public RuleCall getCollectionTypeIdentifierParserRuleCall_4() { return cCollectionTypeIdentifierParserRuleCall_4; }
	}

	public class AnyNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AnyName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cNameParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cLambdaKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cMapKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cTupleKeyword_3 = (Keyword)cAlternatives.eContents().get(3);

		//AnyName:
		//	Name
		//	| 'Lambda'
		//	| 'Map'
		//	| 'Tuple';
		@Override public ParserRule getRule() { return rule; }

		//Name
		//| 'Lambda'
		//| 'Map'
		//| 'Tuple'
		public Alternatives getAlternatives() { return cAlternatives; }

		//Name
		public RuleCall getNameParserRuleCall_0() { return cNameParserRuleCall_0; }

		//'Lambda'
		public Keyword getLambdaKeyword_1() { return cLambdaKeyword_1; }

		//'Map'
		public Keyword getMapKeyword_2() { return cMapKeyword_2; }

		//'Tuple'
		public Keyword getTupleKeyword_3() { return cTupleKeyword_3; }
	}

	public class LibPathNameCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibPathNameCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedPathElementsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedPathElementsLibPathElementCSParserRuleCall_0_0 = (RuleCall)cOwnedPathElementsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedPathElementsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedPathElementsLibPathElementCSParserRuleCall_1_1_0 = (RuleCall)cOwnedPathElementsAssignment_1_1.eContents().get(0);

		//LibPathNameCS base::PathNameCS:
		//	ownedPathElements+=LibPathElementCS ('::' ownedPathElements+=LibPathElementCS)*;
		@Override public ParserRule getRule() { return rule; }

		//ownedPathElements+=LibPathElementCS ('::' ownedPathElements+=LibPathElementCS)*
		public Group getGroup() { return cGroup; }

		//ownedPathElements+=LibPathElementCS
		public Assignment getOwnedPathElementsAssignment_0() { return cOwnedPathElementsAssignment_0; }

		//LibPathElementCS
		public RuleCall getOwnedPathElementsLibPathElementCSParserRuleCall_0_0() { return cOwnedPathElementsLibPathElementCSParserRuleCall_0_0; }

		//('::' ownedPathElements+=LibPathElementCS)*
		public Group getGroup_1() { return cGroup_1; }

		//'::'
		public Keyword getColonColonKeyword_1_0() { return cColonColonKeyword_1_0; }

		//ownedPathElements+=LibPathElementCS
		public Assignment getOwnedPathElementsAssignment_1_1() { return cOwnedPathElementsAssignment_1_1; }

		//LibPathElementCS
		public RuleCall getOwnedPathElementsLibPathElementCSParserRuleCall_1_1_0() { return cOwnedPathElementsLibPathElementCSParserRuleCall_1_1_0; }
	}

	public class LibPathElementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibPathElementCS");
		private final Assignment cReferredElementAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cReferredElementNamedElementCrossReference_0 = (CrossReference)cReferredElementAssignment.eContents().get(0);
		private final RuleCall cReferredElementNamedElementNameParserRuleCall_0_1 = (RuleCall)cReferredElementNamedElementCrossReference_0.eContents().get(1);

		//LibPathElementCS base::PathElementCS:
		//	referredElement=[pivot::NamedElement|Name];
		@Override public ParserRule getRule() { return rule; }

		//referredElement=[pivot::NamedElement|Name]
		public Assignment getReferredElementAssignment() { return cReferredElementAssignment; }

		//[pivot::NamedElement|Name]
		public CrossReference getReferredElementNamedElementCrossReference_0() { return cReferredElementNamedElementCrossReference_0; }

		//Name
		public RuleCall getReferredElementNamedElementNameParserRuleCall_0_1() { return cReferredElementNamedElementNameParserRuleCall_0_1; }
	}

	public class AccumulatorCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AccumulatorCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIdentifierParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0 = (RuleCall)cOwnedTypeAssignment_2.eContents().get(0);

		//AccumulatorCS base::ParameterCS:
		//	name=Identifier ':' ownedType=TypedMultiplicityRefCS;
		@Override public ParserRule getRule() { return rule; }

		//name=Identifier ':' ownedType=TypedMultiplicityRefCS
		public Group getGroup() { return cGroup; }

		//name=Identifier
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//Identifier
		public RuleCall getNameIdentifierParserRuleCall_0_0() { return cNameIdentifierParserRuleCall_0_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_2() { return cOwnedTypeAssignment_2; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0; }
	}

	public class AnnotationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AnnotationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAnnotationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives cNameAlternatives_1_0 = (Alternatives)cNameAssignment_1.eContents().get(0);
		private final RuleCall cNameIdentifierParserRuleCall_1_0_0 = (RuleCall)cNameAlternatives_1_0.eContents().get(0);
		private final RuleCall cNameSINGLE_QUOTED_STRINGTerminalRuleCall_1_0_1 = (RuleCall)cNameAlternatives_1_0.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedDetailsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedDetailsDetailCSParserRuleCall_2_1_0 = (RuleCall)cOwnedDetailsAssignment_2_1.eContents().get(0);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Keyword cCommaKeyword_2_2_0 = (Keyword)cGroup_2_2.eContents().get(0);
		private final Assignment cOwnedDetailsAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cOwnedDetailsDetailCSParserRuleCall_2_2_1_0 = (RuleCall)cOwnedDetailsAssignment_2_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_3 = (Keyword)cGroup_2.eContents().get(3);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cAlternatives_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3_0_0 = (Keyword)cGroup_3_0.eContents().get(0);
		private final Assignment cOwnedAnnotationsAssignment_3_0_1 = (Assignment)cGroup_3_0.eContents().get(1);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_3_0_1_0 = (RuleCall)cOwnedAnnotationsAssignment_3_0_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3_0_2 = (Keyword)cGroup_3_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_3_1 = (Keyword)cAlternatives_3.eContents().get(1);

		//AnnotationCS base::AnnotationCS:
		//	'annotation' name=(Identifier | SINGLE_QUOTED_STRING) ('(' ownedDetails+=DetailCS (',' ownedDetails+=DetailCS)* ')')
		//	? ('{' ownedAnnotations+=AnnotationElementCS '}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//'annotation' name=(Identifier | SINGLE_QUOTED_STRING) ('(' ownedDetails+=DetailCS (',' ownedDetails+=DetailCS)* ')')
		//? ('{' ownedAnnotations+=AnnotationElementCS '}' | ';')
		public Group getGroup() { return cGroup; }

		//'annotation'
		public Keyword getAnnotationKeyword_0() { return cAnnotationKeyword_0; }

		//name=(Identifier | SINGLE_QUOTED_STRING)
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//(Identifier | SINGLE_QUOTED_STRING)
		public Alternatives getNameAlternatives_1_0() { return cNameAlternatives_1_0; }

		//Identifier
		public RuleCall getNameIdentifierParserRuleCall_1_0_0() { return cNameIdentifierParserRuleCall_1_0_0; }

		//SINGLE_QUOTED_STRING
		public RuleCall getNameSINGLE_QUOTED_STRINGTerminalRuleCall_1_0_1() { return cNameSINGLE_QUOTED_STRINGTerminalRuleCall_1_0_1; }

		//('(' ownedDetails+=DetailCS (',' ownedDetails+=DetailCS)* ')')?
		public Group getGroup_2() { return cGroup_2; }

		//'('
		public Keyword getLeftParenthesisKeyword_2_0() { return cLeftParenthesisKeyword_2_0; }

		//ownedDetails+=DetailCS
		public Assignment getOwnedDetailsAssignment_2_1() { return cOwnedDetailsAssignment_2_1; }

		//DetailCS
		public RuleCall getOwnedDetailsDetailCSParserRuleCall_2_1_0() { return cOwnedDetailsDetailCSParserRuleCall_2_1_0; }

		//(',' ownedDetails+=DetailCS)*
		public Group getGroup_2_2() { return cGroup_2_2; }

		//','
		public Keyword getCommaKeyword_2_2_0() { return cCommaKeyword_2_2_0; }

		//ownedDetails+=DetailCS
		public Assignment getOwnedDetailsAssignment_2_2_1() { return cOwnedDetailsAssignment_2_2_1; }

		//DetailCS
		public RuleCall getOwnedDetailsDetailCSParserRuleCall_2_2_1_0() { return cOwnedDetailsDetailCSParserRuleCall_2_2_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_2_3() { return cRightParenthesisKeyword_2_3; }

		//('{' ownedAnnotations+=AnnotationElementCS '}' | ';')
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//'{' ownedAnnotations+=AnnotationElementCS '}'
		public Group getGroup_3_0() { return cGroup_3_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_3_0_0() { return cLeftCurlyBracketKeyword_3_0_0; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_3_0_1() { return cOwnedAnnotationsAssignment_3_0_1; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_3_0_1_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_3_0_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_3_0_2() { return cRightCurlyBracketKeyword_3_0_2; }

		//';'
		public Keyword getSemicolonKeyword_3_1() { return cSemicolonKeyword_3_1; }
	}

	public class AnnotationElementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AnnotationElementCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAnnotationCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDocumentationCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		//AnnotationElementCS base::AnnotationElementCS:
		//	AnnotationCS | DocumentationCS;
		@Override public ParserRule getRule() { return rule; }

		//AnnotationCS | DocumentationCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//AnnotationCS
		public RuleCall getAnnotationCSParserRuleCall_0() { return cAnnotationCSParserRuleCall_0; }

		//DocumentationCS
		public RuleCall getDocumentationCSParserRuleCall_1() { return cDocumentationCSParserRuleCall_1; }
	}

	public class LibClassCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibClassCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsAbstractAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsAbstractAbstractKeyword_0_0 = (Keyword)cIsAbstractAssignment_0.eContents().get(0);
		private final Keyword cTypeKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameAnyNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cOwnedSignatureAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_3_0 = (RuleCall)cOwnedSignatureAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cColonKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cMetaclassNameAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final CrossReference cMetaclassNameMetaclassNameCSCrossReference_4_1_0 = (CrossReference)cMetaclassNameAssignment_4_1.eContents().get(0);
		private final RuleCall cMetaclassNameMetaclassNameCSAnyNameParserRuleCall_4_1_0_1 = (RuleCall)cMetaclassNameMetaclassNameCSCrossReference_4_1_0.eContents().get(1);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cConformsToKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cOwnedSuperTypesAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cOwnedSuperTypesTypedRefCSParserRuleCall_5_1_0 = (RuleCall)cOwnedSuperTypesAssignment_5_1.eContents().get(0);
		private final Group cGroup_5_2 = (Group)cGroup_5.eContents().get(2);
		private final Keyword cCommaKeyword_5_2_0 = (Keyword)cGroup_5_2.eContents().get(0);
		private final Assignment cOwnedSuperTypesAssignment_5_2_1 = (Assignment)cGroup_5_2.eContents().get(1);
		private final RuleCall cOwnedSuperTypesTypedRefCSParserRuleCall_5_2_1_0 = (RuleCall)cOwnedSuperTypesAssignment_5_2_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cEqualsSignGreaterThanSignKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cImplementationAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final CrossReference cImplementationJavaClassCSCrossReference_6_1_0 = (CrossReference)cImplementationAssignment_6_1.eContents().get(0);
		private final RuleCall cImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1 = (RuleCall)cImplementationJavaClassCSCrossReference_6_1_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Alternatives cAlternatives_8 = (Alternatives)cGroup.eContents().get(8);
		private final Assignment cOwnedOperationsAssignment_8_0 = (Assignment)cAlternatives_8.eContents().get(0);
		private final RuleCall cOwnedOperationsOperationCSParserRuleCall_8_0_0 = (RuleCall)cOwnedOperationsAssignment_8_0.eContents().get(0);
		private final Assignment cOwnedPropertiesAssignment_8_1 = (Assignment)cAlternatives_8.eContents().get(1);
		private final RuleCall cOwnedPropertiesLibPropertyCSParserRuleCall_8_1_0 = (RuleCall)cOwnedPropertiesAssignment_8_1.eContents().get(0);
		private final Assignment cOwnedConstraintsAssignment_8_2 = (Assignment)cAlternatives_8.eContents().get(2);
		private final RuleCall cOwnedConstraintsInvCSParserRuleCall_8_2_0 = (RuleCall)cOwnedConstraintsAssignment_8_2.eContents().get(0);
		private final Assignment cOwnedAnnotationsAssignment_8_3 = (Assignment)cAlternatives_8.eContents().get(3);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_8_3_0 = (RuleCall)cOwnedAnnotationsAssignment_8_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);

		//LibClassCS:
		//	isAbstract?='abstract'? 'type' name=AnyName
		//	ownedSignature=TemplateSignatureCS? (':' metaclassName=[MetaclassNameCS|AnyName])? ('conformsTo'
		//	ownedSuperTypes+=TypedRefCS (',' ownedSuperTypes+=TypedRefCS)*)? ('=>'
		//	implementation=[JavaClassCS|SINGLE_QUOTED_STRING])?
		//	'{' (ownedOperations+=OperationCS
		//	| ownedProperties+=LibPropertyCS
		//	| ownedConstraints+=InvCS
		//	| ownedAnnotations+=AnnotationElementCS)* '}';
		@Override public ParserRule getRule() { return rule; }

		//isAbstract?='abstract'? 'type' name=AnyName
		//ownedSignature=TemplateSignatureCS? (':' metaclassName=[MetaclassNameCS|AnyName])? ('conformsTo'
		//ownedSuperTypes+=TypedRefCS (',' ownedSuperTypes+=TypedRefCS)*)? ('=>' implementation=[JavaClassCS|SINGLE_QUOTED_STRING])
		//?
		//'{' (ownedOperations+=OperationCS
		//| ownedProperties+=LibPropertyCS
		//| ownedConstraints+=InvCS
		//| ownedAnnotations+=AnnotationElementCS)* '}'
		public Group getGroup() { return cGroup; }

		//isAbstract?='abstract'?
		public Assignment getIsAbstractAssignment_0() { return cIsAbstractAssignment_0; }

		//'abstract'
		public Keyword getIsAbstractAbstractKeyword_0_0() { return cIsAbstractAbstractKeyword_0_0; }

		//'type'
		public Keyword getTypeKeyword_1() { return cTypeKeyword_1; }

		//name=AnyName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//AnyName
		public RuleCall getNameAnyNameParserRuleCall_2_0() { return cNameAnyNameParserRuleCall_2_0; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_3() { return cOwnedSignatureAssignment_3; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_3_0; }

		//(':' metaclassName=[MetaclassNameCS|AnyName])?
		public Group getGroup_4() { return cGroup_4; }

		//':'
		public Keyword getColonKeyword_4_0() { return cColonKeyword_4_0; }

		//metaclassName=[MetaclassNameCS|AnyName]
		public Assignment getMetaclassNameAssignment_4_1() { return cMetaclassNameAssignment_4_1; }

		//[MetaclassNameCS|AnyName]
		public CrossReference getMetaclassNameMetaclassNameCSCrossReference_4_1_0() { return cMetaclassNameMetaclassNameCSCrossReference_4_1_0; }

		//AnyName
		public RuleCall getMetaclassNameMetaclassNameCSAnyNameParserRuleCall_4_1_0_1() { return cMetaclassNameMetaclassNameCSAnyNameParserRuleCall_4_1_0_1; }

		//('conformsTo' ownedSuperTypes+=TypedRefCS (',' ownedSuperTypes+=TypedRefCS)*)?
		public Group getGroup_5() { return cGroup_5; }

		//'conformsTo'
		public Keyword getConformsToKeyword_5_0() { return cConformsToKeyword_5_0; }

		//ownedSuperTypes+=TypedRefCS
		public Assignment getOwnedSuperTypesAssignment_5_1() { return cOwnedSuperTypesAssignment_5_1; }

		//TypedRefCS
		public RuleCall getOwnedSuperTypesTypedRefCSParserRuleCall_5_1_0() { return cOwnedSuperTypesTypedRefCSParserRuleCall_5_1_0; }

		//(',' ownedSuperTypes+=TypedRefCS)*
		public Group getGroup_5_2() { return cGroup_5_2; }

		//','
		public Keyword getCommaKeyword_5_2_0() { return cCommaKeyword_5_2_0; }

		//ownedSuperTypes+=TypedRefCS
		public Assignment getOwnedSuperTypesAssignment_5_2_1() { return cOwnedSuperTypesAssignment_5_2_1; }

		//TypedRefCS
		public RuleCall getOwnedSuperTypesTypedRefCSParserRuleCall_5_2_1_0() { return cOwnedSuperTypesTypedRefCSParserRuleCall_5_2_1_0; }

		//('=>' implementation=[JavaClassCS|SINGLE_QUOTED_STRING])?
		public Group getGroup_6() { return cGroup_6; }

		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_6_0() { return cEqualsSignGreaterThanSignKeyword_6_0; }

		//implementation=[JavaClassCS|SINGLE_QUOTED_STRING]
		public Assignment getImplementationAssignment_6_1() { return cImplementationAssignment_6_1; }

		//[JavaClassCS|SINGLE_QUOTED_STRING]
		public CrossReference getImplementationJavaClassCSCrossReference_6_1_0() { return cImplementationJavaClassCSCrossReference_6_1_0; }

		//SINGLE_QUOTED_STRING
		public RuleCall getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1() { return cImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_7() { return cLeftCurlyBracketKeyword_7; }

		//(ownedOperations+=OperationCS
		//| ownedProperties+=LibPropertyCS
		//| ownedConstraints+=InvCS
		//| ownedAnnotations+=AnnotationElementCS)*
		public Alternatives getAlternatives_8() { return cAlternatives_8; }

		//ownedOperations+=OperationCS
		public Assignment getOwnedOperationsAssignment_8_0() { return cOwnedOperationsAssignment_8_0; }

		//OperationCS
		public RuleCall getOwnedOperationsOperationCSParserRuleCall_8_0_0() { return cOwnedOperationsOperationCSParserRuleCall_8_0_0; }

		//ownedProperties+=LibPropertyCS
		public Assignment getOwnedPropertiesAssignment_8_1() { return cOwnedPropertiesAssignment_8_1; }

		//LibPropertyCS
		public RuleCall getOwnedPropertiesLibPropertyCSParserRuleCall_8_1_0() { return cOwnedPropertiesLibPropertyCSParserRuleCall_8_1_0; }

		//ownedConstraints+=InvCS
		public Assignment getOwnedConstraintsAssignment_8_2() { return cOwnedConstraintsAssignment_8_2; }

		//InvCS
		public RuleCall getOwnedConstraintsInvCSParserRuleCall_8_2_0() { return cOwnedConstraintsInvCSParserRuleCall_8_2_0; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_8_3() { return cOwnedAnnotationsAssignment_8_3; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_8_3_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_8_3_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_9() { return cRightCurlyBracketKeyword_9; }
	}

	public class ClassCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.ClassCS");
		private final RuleCall cLibClassCSParserRuleCall = (RuleCall)rule.eContents().get(1);

		//ClassCS base::ClassCS:
		//	LibClassCS;
		@Override public ParserRule getRule() { return rule; }

		//LibClassCS
		public RuleCall getLibClassCSParserRuleCall() { return cLibClassCSParserRuleCall; }
	}

	public class DetailCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.DetailCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Alternatives cNameAlternatives_0_0 = (Alternatives)cNameAssignment_0.eContents().get(0);
		private final RuleCall cNameNameParserRuleCall_0_0_0 = (RuleCall)cNameAlternatives_0_0.eContents().get(0);
		private final RuleCall cNameSINGLE_QUOTED_STRINGTerminalRuleCall_0_0_1 = (RuleCall)cNameAlternatives_0_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cValuesAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cValuesAlternatives_2_0 = (Alternatives)cValuesAssignment_2.eContents().get(0);
		private final RuleCall cValuesSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_0 = (RuleCall)cValuesAlternatives_2_0.eContents().get(0);
		private final RuleCall cValuesML_SINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1 = (RuleCall)cValuesAlternatives_2_0.eContents().get(1);

		//DetailCS base::DetailCS:
		//	name=(Name | SINGLE_QUOTED_STRING) '=' values+=(SINGLE_QUOTED_STRING | ML_SINGLE_QUOTED_STRING)*;
		@Override public ParserRule getRule() { return rule; }

		//name=(Name | SINGLE_QUOTED_STRING) '=' values+=(SINGLE_QUOTED_STRING | ML_SINGLE_QUOTED_STRING)*
		public Group getGroup() { return cGroup; }

		//name=(Name | SINGLE_QUOTED_STRING)
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//(Name | SINGLE_QUOTED_STRING)
		public Alternatives getNameAlternatives_0_0() { return cNameAlternatives_0_0; }

		//Name
		public RuleCall getNameNameParserRuleCall_0_0_0() { return cNameNameParserRuleCall_0_0_0; }

		//SINGLE_QUOTED_STRING
		public RuleCall getNameSINGLE_QUOTED_STRINGTerminalRuleCall_0_0_1() { return cNameSINGLE_QUOTED_STRINGTerminalRuleCall_0_0_1; }

		//'='
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }

		//values+=(SINGLE_QUOTED_STRING | ML_SINGLE_QUOTED_STRING)*
		public Assignment getValuesAssignment_2() { return cValuesAssignment_2; }

		//(SINGLE_QUOTED_STRING | ML_SINGLE_QUOTED_STRING)
		public Alternatives getValuesAlternatives_2_0() { return cValuesAlternatives_2_0; }

		//SINGLE_QUOTED_STRING
		public RuleCall getValuesSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_0() { return cValuesSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_0; }

		//ML_SINGLE_QUOTED_STRING
		public RuleCall getValuesML_SINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1() { return cValuesML_SINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1; }
	}

	public class DocumentationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.DocumentationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cDocumentationCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cDocumentationKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cValueSINGLE_QUOTED_STRINGTerminalRuleCall_2_0 = (RuleCall)cValueAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cOwnedDetailsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cOwnedDetailsDetailCSParserRuleCall_3_1_0 = (RuleCall)cOwnedDetailsAssignment_3_1.eContents().get(0);
		private final Group cGroup_3_2 = (Group)cGroup_3.eContents().get(2);
		private final Keyword cCommaKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Assignment cOwnedDetailsAssignment_3_2_1 = (Assignment)cGroup_3_2.eContents().get(1);
		private final RuleCall cOwnedDetailsDetailCSParserRuleCall_3_2_1_0 = (RuleCall)cOwnedDetailsAssignment_3_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3_3 = (Keyword)cGroup_3.eContents().get(3);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//DocumentationCS base::DocumentationCS:
		//	{base::DocumentationCS} 'documentation' value=SINGLE_QUOTED_STRING? ('(' ownedDetails+=DetailCS (','
		//	ownedDetails+=DetailCS)* ')')?
		//	';';
		@Override public ParserRule getRule() { return rule; }

		//{base::DocumentationCS} 'documentation' value=SINGLE_QUOTED_STRING? ('(' ownedDetails+=DetailCS (','
		//ownedDetails+=DetailCS)* ')')?
		//';'
		public Group getGroup() { return cGroup; }

		//{base::DocumentationCS}
		public Action getDocumentationCSAction_0() { return cDocumentationCSAction_0; }

		//'documentation'
		public Keyword getDocumentationKeyword_1() { return cDocumentationKeyword_1; }

		//value=SINGLE_QUOTED_STRING?
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }

		//SINGLE_QUOTED_STRING
		public RuleCall getValueSINGLE_QUOTED_STRINGTerminalRuleCall_2_0() { return cValueSINGLE_QUOTED_STRINGTerminalRuleCall_2_0; }

		//('(' ownedDetails+=DetailCS (',' ownedDetails+=DetailCS)* ')')?
		public Group getGroup_3() { return cGroup_3; }

		//'('
		public Keyword getLeftParenthesisKeyword_3_0() { return cLeftParenthesisKeyword_3_0; }

		//ownedDetails+=DetailCS
		public Assignment getOwnedDetailsAssignment_3_1() { return cOwnedDetailsAssignment_3_1; }

		//DetailCS
		public RuleCall getOwnedDetailsDetailCSParserRuleCall_3_1_0() { return cOwnedDetailsDetailCSParserRuleCall_3_1_0; }

		//(',' ownedDetails+=DetailCS)*
		public Group getGroup_3_2() { return cGroup_3_2; }

		//','
		public Keyword getCommaKeyword_3_2_0() { return cCommaKeyword_3_2_0; }

		//ownedDetails+=DetailCS
		public Assignment getOwnedDetailsAssignment_3_2_1() { return cOwnedDetailsAssignment_3_2_1; }

		//DetailCS
		public RuleCall getOwnedDetailsDetailCSParserRuleCall_3_2_1_0() { return cOwnedDetailsDetailCSParserRuleCall_3_2_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_3_3() { return cRightParenthesisKeyword_3_3; }

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class ImportCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.ImportCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cImportKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cNameIdentifierParserRuleCall_1_0_0 = (RuleCall)cNameAssignment_1_0.eContents().get(0);
		private final Keyword cColonKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cOwnedPathNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedPathNameURIPathNameCSParserRuleCall_2_0 = (RuleCall)cOwnedPathNameAssignment_2.eContents().get(0);
		private final Assignment cIsAllAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final Keyword cIsAllColonColonAsteriskKeyword_3_0 = (Keyword)cIsAllAssignment_3.eContents().get(0);

		//ImportCS base::ImportCS:
		//	'import' (name=Identifier ':')? ownedPathName=URIPathNameCS isAll?='::*'?;
		@Override public ParserRule getRule() { return rule; }

		//'import' (name=Identifier ':')? ownedPathName=URIPathNameCS isAll?='::*'?
		public Group getGroup() { return cGroup; }

		//'import'
		public Keyword getImportKeyword_0() { return cImportKeyword_0; }

		//(name=Identifier ':')?
		public Group getGroup_1() { return cGroup_1; }

		//name=Identifier
		public Assignment getNameAssignment_1_0() { return cNameAssignment_1_0; }

		//Identifier
		public RuleCall getNameIdentifierParserRuleCall_1_0_0() { return cNameIdentifierParserRuleCall_1_0_0; }

		//':'
		public Keyword getColonKeyword_1_1() { return cColonKeyword_1_1; }

		//ownedPathName=URIPathNameCS
		public Assignment getOwnedPathNameAssignment_2() { return cOwnedPathNameAssignment_2; }

		//URIPathNameCS
		public RuleCall getOwnedPathNameURIPathNameCSParserRuleCall_2_0() { return cOwnedPathNameURIPathNameCSParserRuleCall_2_0; }

		//isAll?='::*'?
		public Assignment getIsAllAssignment_3() { return cIsAllAssignment_3; }

		//'::*'
		public Keyword getIsAllColonColonAsteriskKeyword_3_0() { return cIsAllColonColonAsteriskKeyword_3_0; }
	}

	public class InvCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.InvCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cStereotypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cStereotypeInvKeyword_0_0 = (Keyword)cStereotypeAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0_0 = (RuleCall)cNameAssignment_1_0.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cOwnedMessageSpecificationAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0 = (RuleCall)cOwnedMessageSpecificationAssignment_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_1_2 = (Keyword)cGroup_1_1.eContents().get(2);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedSpecificationAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedSpecificationSpecificationCSParserRuleCall_3_0 = (RuleCall)cOwnedSpecificationAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//InvCS LibConstraintCS:
		//	stereotype='inv' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
		//	ownedSpecification=SpecificationCS ';';
		@Override public ParserRule getRule() { return rule; }

		//stereotype='inv' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
		//ownedSpecification=SpecificationCS ';'
		public Group getGroup() { return cGroup; }

		//stereotype='inv'
		public Assignment getStereotypeAssignment_0() { return cStereotypeAssignment_0; }

		//'inv'
		public Keyword getStereotypeInvKeyword_0_0() { return cStereotypeInvKeyword_0_0; }

		//(name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)?
		public Group getGroup_1() { return cGroup_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_1_0() { return cNameAssignment_1_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0_0() { return cNameUnrestrictedNameParserRuleCall_1_0_0; }

		//('(' ownedMessageSpecification=SpecificationCS ')')?
		public Group getGroup_1_1() { return cGroup_1_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_1_1_0() { return cLeftParenthesisKeyword_1_1_0; }

		//ownedMessageSpecification=SpecificationCS
		public Assignment getOwnedMessageSpecificationAssignment_1_1_1() { return cOwnedMessageSpecificationAssignment_1_1_1; }

		//SpecificationCS
		public RuleCall getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0() { return cOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_1_1_2() { return cRightParenthesisKeyword_1_1_2; }

		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//ownedSpecification=SpecificationCS
		public Assignment getOwnedSpecificationAssignment_3() { return cOwnedSpecificationAssignment_3; }

		//SpecificationCS
		public RuleCall getOwnedSpecificationSpecificationCSParserRuleCall_3_0() { return cOwnedSpecificationSpecificationCSParserRuleCall_3_0; }

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class LibCoercionCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibCoercionCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCoercionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cOwnedTypeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_5_0 = (RuleCall)cOwnedTypeAssignment_5.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cEqualsSignGreaterThanSignKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cImplementationAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final CrossReference cImplementationJavaClassCSCrossReference_6_1_0 = (CrossReference)cImplementationAssignment_6_1.eContents().get(0);
		private final RuleCall cImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1 = (RuleCall)cImplementationJavaClassCSCrossReference_6_1_0.eContents().get(1);
		private final Alternatives cAlternatives_7 = (Alternatives)cGroup.eContents().get(7);
		private final Group cGroup_7_0 = (Group)cAlternatives_7.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_7_0_0 = (Keyword)cGroup_7_0.eContents().get(0);
		private final Alternatives cAlternatives_7_0_1 = (Alternatives)cGroup_7_0.eContents().get(1);
		private final Assignment cOwnedAnnotationsAssignment_7_0_1_0 = (Assignment)cAlternatives_7_0_1.eContents().get(0);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0 = (RuleCall)cOwnedAnnotationsAssignment_7_0_1_0.eContents().get(0);
		private final Assignment cOwnedPreconditionsAssignment_7_0_1_1 = (Assignment)cAlternatives_7_0_1.eContents().get(1);
		private final RuleCall cOwnedPreconditionsPostCSParserRuleCall_7_0_1_1_0 = (RuleCall)cOwnedPreconditionsAssignment_7_0_1_1.eContents().get(0);
		private final Assignment cOwnedPostconditionsAssignment_7_0_1_2 = (Assignment)cAlternatives_7_0_1.eContents().get(2);
		private final RuleCall cOwnedPostconditionsPreCSParserRuleCall_7_0_1_2_0 = (RuleCall)cOwnedPostconditionsAssignment_7_0_1_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7_0_2 = (Keyword)cGroup_7_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_7_1 = (Keyword)cAlternatives_7.eContents().get(1);

		//LibCoercionCS:
		//	'coercion' name=Name '(' ')' ':' ownedType=TypedMultiplicityRefCS ('=>'
		//	implementation=[JavaClassCS|SINGLE_QUOTED_STRING])? ('{' (ownedAnnotations+=AnnotationElementCS
		//	| ownedPreconditions+=PostCS
		//	| ownedPostconditions+=PreCS)* '}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//'coercion' name=Name '(' ')' ':' ownedType=TypedMultiplicityRefCS ('=>'
		//implementation=[JavaClassCS|SINGLE_QUOTED_STRING])? ('{' (ownedAnnotations+=AnnotationElementCS
		//| ownedPreconditions+=PostCS
		//| ownedPostconditions+=PreCS)* '}' | ';')
		public Group getGroup() { return cGroup; }

		//'coercion'
		public Keyword getCoercionKeyword_0() { return cCoercionKeyword_0; }

		//name=Name
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//Name
		public RuleCall getNameNameParserRuleCall_1_0() { return cNameNameParserRuleCall_1_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }

		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }

		//':'
		public Keyword getColonKeyword_4() { return cColonKeyword_4; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_5() { return cOwnedTypeAssignment_5; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_5_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_5_0; }

		//('=>' implementation=[JavaClassCS|SINGLE_QUOTED_STRING])?
		public Group getGroup_6() { return cGroup_6; }

		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_6_0() { return cEqualsSignGreaterThanSignKeyword_6_0; }

		//implementation=[JavaClassCS|SINGLE_QUOTED_STRING]
		public Assignment getImplementationAssignment_6_1() { return cImplementationAssignment_6_1; }

		//[JavaClassCS|SINGLE_QUOTED_STRING]
		public CrossReference getImplementationJavaClassCSCrossReference_6_1_0() { return cImplementationJavaClassCSCrossReference_6_1_0; }

		//SINGLE_QUOTED_STRING
		public RuleCall getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1() { return cImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1; }

		//('{' (ownedAnnotations+=AnnotationElementCS
		//| ownedPreconditions+=PostCS
		//| ownedPostconditions+=PreCS)* '}' | ';')
		public Alternatives getAlternatives_7() { return cAlternatives_7; }

		//'{' (ownedAnnotations+=AnnotationElementCS
		//| ownedPreconditions+=PostCS
		//| ownedPostconditions+=PreCS)* '}'
		public Group getGroup_7_0() { return cGroup_7_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_7_0_0() { return cLeftCurlyBracketKeyword_7_0_0; }

		//(ownedAnnotations+=AnnotationElementCS
		//| ownedPreconditions+=PostCS
		//| ownedPostconditions+=PreCS)*
		public Alternatives getAlternatives_7_0_1() { return cAlternatives_7_0_1; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_7_0_1_0() { return cOwnedAnnotationsAssignment_7_0_1_0; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0; }

		//ownedPreconditions+=PostCS
		public Assignment getOwnedPreconditionsAssignment_7_0_1_1() { return cOwnedPreconditionsAssignment_7_0_1_1; }

		//PostCS
		public RuleCall getOwnedPreconditionsPostCSParserRuleCall_7_0_1_1_0() { return cOwnedPreconditionsPostCSParserRuleCall_7_0_1_1_0; }

		//ownedPostconditions+=PreCS
		public Assignment getOwnedPostconditionsAssignment_7_0_1_2() { return cOwnedPostconditionsAssignment_7_0_1_2; }

		//PreCS
		public RuleCall getOwnedPostconditionsPreCSParserRuleCall_7_0_1_2_0() { return cOwnedPostconditionsPreCSParserRuleCall_7_0_1_2_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_7_0_2() { return cRightCurlyBracketKeyword_7_0_2; }

		//';'
		public Keyword getSemicolonKeyword_7_1() { return cSemicolonKeyword_7_1; }
	}

	public class LibIterationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibIterationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cIterationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cOwnedSignatureAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_2_0 = (RuleCall)cOwnedSignatureAssignment_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cOwnedIteratorsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedIteratorsIteratorCSParserRuleCall_4_0 = (RuleCall)cOwnedIteratorsAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cCommaKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cOwnedIteratorsAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cOwnedIteratorsIteratorCSParserRuleCall_5_1_0 = (RuleCall)cOwnedIteratorsAssignment_5_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cSemicolonKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cOwnedAccumulatorsAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cOwnedAccumulatorsAccumulatorCSParserRuleCall_6_1_0 = (RuleCall)cOwnedAccumulatorsAssignment_6_1.eContents().get(0);
		private final Group cGroup_6_2 = (Group)cGroup_6.eContents().get(2);
		private final Keyword cCommaKeyword_6_2_0 = (Keyword)cGroup_6_2.eContents().get(0);
		private final Assignment cOwnedAccumulatorsAssignment_6_2_1 = (Assignment)cGroup_6_2.eContents().get(1);
		private final RuleCall cOwnedAccumulatorsAccumulatorCSParserRuleCall_6_2_1_0 = (RuleCall)cOwnedAccumulatorsAssignment_6_2_1.eContents().get(0);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cVerticalLineKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final RuleCall cOwnedParametersParameterCSParserRuleCall_7_1_0 = (RuleCall)cOwnedParametersAssignment_7_1.eContents().get(0);
		private final Group cGroup_7_2 = (Group)cGroup_7.eContents().get(2);
		private final Keyword cCommaKeyword_7_2_0 = (Keyword)cGroup_7_2.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_7_2_1 = (Assignment)cGroup_7_2.eContents().get(1);
		private final RuleCall cOwnedParametersParameterCSParserRuleCall_7_2_1_0 = (RuleCall)cOwnedParametersAssignment_7_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Keyword cColonKeyword_9 = (Keyword)cGroup.eContents().get(9);
		private final Assignment cOwnedTypeAssignment_10 = (Assignment)cGroup.eContents().get(10);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_10_0 = (RuleCall)cOwnedTypeAssignment_10.eContents().get(0);
		private final Assignment cIsInvalidatingAssignment_11 = (Assignment)cGroup.eContents().get(11);
		private final Keyword cIsInvalidatingInvalidatingKeyword_11_0 = (Keyword)cIsInvalidatingAssignment_11.eContents().get(0);
		private final Assignment cIsValidatingAssignment_12 = (Assignment)cGroup.eContents().get(12);
		private final Keyword cIsValidatingValidatingKeyword_12_0 = (Keyword)cIsValidatingAssignment_12.eContents().get(0);
		private final Group cGroup_13 = (Group)cGroup.eContents().get(13);
		private final Keyword cEqualsSignGreaterThanSignKeyword_13_0 = (Keyword)cGroup_13.eContents().get(0);
		private final Assignment cImplementationAssignment_13_1 = (Assignment)cGroup_13.eContents().get(1);
		private final CrossReference cImplementationJavaClassCSCrossReference_13_1_0 = (CrossReference)cImplementationAssignment_13_1.eContents().get(0);
		private final RuleCall cImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_13_1_0_1 = (RuleCall)cImplementationJavaClassCSCrossReference_13_1_0.eContents().get(1);
		private final Alternatives cAlternatives_14 = (Alternatives)cGroup.eContents().get(14);
		private final Group cGroup_14_0 = (Group)cAlternatives_14.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_14_0_0 = (Keyword)cGroup_14_0.eContents().get(0);
		private final Alternatives cAlternatives_14_0_1 = (Alternatives)cGroup_14_0.eContents().get(1);
		private final Assignment cOwnedAnnotationsAssignment_14_0_1_0 = (Assignment)cAlternatives_14_0_1.eContents().get(0);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_14_0_1_0_0 = (RuleCall)cOwnedAnnotationsAssignment_14_0_1_0.eContents().get(0);
		private final Assignment cOwnedPreconditionsAssignment_14_0_1_1 = (Assignment)cAlternatives_14_0_1.eContents().get(1);
		private final RuleCall cOwnedPreconditionsPostCSParserRuleCall_14_0_1_1_0 = (RuleCall)cOwnedPreconditionsAssignment_14_0_1_1.eContents().get(0);
		private final Assignment cOwnedPostconditionsAssignment_14_0_1_2 = (Assignment)cAlternatives_14_0_1.eContents().get(2);
		private final RuleCall cOwnedPostconditionsPreCSParserRuleCall_14_0_1_2_0 = (RuleCall)cOwnedPostconditionsAssignment_14_0_1_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_14_0_2 = (Keyword)cGroup_14_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_14_1 = (Keyword)cAlternatives_14.eContents().get(1);

		//LibIterationCS:
		//	'iteration' name=Name
		//	ownedSignature=TemplateSignatureCS?
		//	'(' ownedIterators+=IteratorCS (',' ownedIterators+=IteratorCS)* (';' ownedAccumulators+=AccumulatorCS (','
		//	ownedAccumulators+=AccumulatorCS)*)? ('|' ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)?
		//	')'
		//	':' ownedType=TypedMultiplicityRefCS
		//	isInvalidating?='invalidating'?
		//	isValidating?='validating'? ('=>' implementation=[JavaClassCS|SINGLE_QUOTED_STRING])? ('{'
		//	(ownedAnnotations+=AnnotationElementCS
		//	| ownedPreconditions+=PostCS
		//	| ownedPostconditions+=PreCS)* '}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//'iteration' name=Name
		//ownedSignature=TemplateSignatureCS?
		//'(' ownedIterators+=IteratorCS (',' ownedIterators+=IteratorCS)* (';' ownedAccumulators+=AccumulatorCS (','
		//ownedAccumulators+=AccumulatorCS)*)? ('|' ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)?
		//')'
		//':' ownedType=TypedMultiplicityRefCS
		//isInvalidating?='invalidating'?
		//isValidating?='validating'? ('=>' implementation=[JavaClassCS|SINGLE_QUOTED_STRING])? ('{'
		//(ownedAnnotations+=AnnotationElementCS
		//| ownedPreconditions+=PostCS
		//| ownedPostconditions+=PreCS)* '}' | ';')
		public Group getGroup() { return cGroup; }

		//'iteration'
		public Keyword getIterationKeyword_0() { return cIterationKeyword_0; }

		//name=Name
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//Name
		public RuleCall getNameNameParserRuleCall_1_0() { return cNameNameParserRuleCall_1_0; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_2() { return cOwnedSignatureAssignment_2; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_2_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }

		//ownedIterators+=IteratorCS
		public Assignment getOwnedIteratorsAssignment_4() { return cOwnedIteratorsAssignment_4; }

		//IteratorCS
		public RuleCall getOwnedIteratorsIteratorCSParserRuleCall_4_0() { return cOwnedIteratorsIteratorCSParserRuleCall_4_0; }

		//(',' ownedIterators+=IteratorCS)*
		public Group getGroup_5() { return cGroup_5; }

		//','
		public Keyword getCommaKeyword_5_0() { return cCommaKeyword_5_0; }

		//ownedIterators+=IteratorCS
		public Assignment getOwnedIteratorsAssignment_5_1() { return cOwnedIteratorsAssignment_5_1; }

		//IteratorCS
		public RuleCall getOwnedIteratorsIteratorCSParserRuleCall_5_1_0() { return cOwnedIteratorsIteratorCSParserRuleCall_5_1_0; }

		//(';' ownedAccumulators+=AccumulatorCS (',' ownedAccumulators+=AccumulatorCS)*)?
		public Group getGroup_6() { return cGroup_6; }

		//';'
		public Keyword getSemicolonKeyword_6_0() { return cSemicolonKeyword_6_0; }

		//ownedAccumulators+=AccumulatorCS
		public Assignment getOwnedAccumulatorsAssignment_6_1() { return cOwnedAccumulatorsAssignment_6_1; }

		//AccumulatorCS
		public RuleCall getOwnedAccumulatorsAccumulatorCSParserRuleCall_6_1_0() { return cOwnedAccumulatorsAccumulatorCSParserRuleCall_6_1_0; }

		//(',' ownedAccumulators+=AccumulatorCS)*
		public Group getGroup_6_2() { return cGroup_6_2; }

		//','
		public Keyword getCommaKeyword_6_2_0() { return cCommaKeyword_6_2_0; }

		//ownedAccumulators+=AccumulatorCS
		public Assignment getOwnedAccumulatorsAssignment_6_2_1() { return cOwnedAccumulatorsAssignment_6_2_1; }

		//AccumulatorCS
		public RuleCall getOwnedAccumulatorsAccumulatorCSParserRuleCall_6_2_1_0() { return cOwnedAccumulatorsAccumulatorCSParserRuleCall_6_2_1_0; }

		//('|' ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)?
		public Group getGroup_7() { return cGroup_7; }

		//'|'
		public Keyword getVerticalLineKeyword_7_0() { return cVerticalLineKeyword_7_0; }

		//ownedParameters+=ParameterCS
		public Assignment getOwnedParametersAssignment_7_1() { return cOwnedParametersAssignment_7_1; }

		//ParameterCS
		public RuleCall getOwnedParametersParameterCSParserRuleCall_7_1_0() { return cOwnedParametersParameterCSParserRuleCall_7_1_0; }

		//(',' ownedParameters+=ParameterCS)*
		public Group getGroup_7_2() { return cGroup_7_2; }

		//','
		public Keyword getCommaKeyword_7_2_0() { return cCommaKeyword_7_2_0; }

		//ownedParameters+=ParameterCS
		public Assignment getOwnedParametersAssignment_7_2_1() { return cOwnedParametersAssignment_7_2_1; }

		//ParameterCS
		public RuleCall getOwnedParametersParameterCSParserRuleCall_7_2_1_0() { return cOwnedParametersParameterCSParserRuleCall_7_2_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_8() { return cRightParenthesisKeyword_8; }

		//':'
		public Keyword getColonKeyword_9() { return cColonKeyword_9; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_10() { return cOwnedTypeAssignment_10; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_10_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_10_0; }

		//isInvalidating?='invalidating'?
		public Assignment getIsInvalidatingAssignment_11() { return cIsInvalidatingAssignment_11; }

		//'invalidating'
		public Keyword getIsInvalidatingInvalidatingKeyword_11_0() { return cIsInvalidatingInvalidatingKeyword_11_0; }

		//isValidating?='validating'?
		public Assignment getIsValidatingAssignment_12() { return cIsValidatingAssignment_12; }

		//'validating'
		public Keyword getIsValidatingValidatingKeyword_12_0() { return cIsValidatingValidatingKeyword_12_0; }

		//('=>' implementation=[JavaClassCS|SINGLE_QUOTED_STRING])?
		public Group getGroup_13() { return cGroup_13; }

		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_13_0() { return cEqualsSignGreaterThanSignKeyword_13_0; }

		//implementation=[JavaClassCS|SINGLE_QUOTED_STRING]
		public Assignment getImplementationAssignment_13_1() { return cImplementationAssignment_13_1; }

		//[JavaClassCS|SINGLE_QUOTED_STRING]
		public CrossReference getImplementationJavaClassCSCrossReference_13_1_0() { return cImplementationJavaClassCSCrossReference_13_1_0; }

		//SINGLE_QUOTED_STRING
		public RuleCall getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_13_1_0_1() { return cImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_13_1_0_1; }

		//('{' (ownedAnnotations+=AnnotationElementCS
		//| ownedPreconditions+=PostCS
		//| ownedPostconditions+=PreCS)* '}' | ';')
		public Alternatives getAlternatives_14() { return cAlternatives_14; }

		//'{' (ownedAnnotations+=AnnotationElementCS
		//| ownedPreconditions+=PostCS
		//| ownedPostconditions+=PreCS)* '}'
		public Group getGroup_14_0() { return cGroup_14_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_14_0_0() { return cLeftCurlyBracketKeyword_14_0_0; }

		//(ownedAnnotations+=AnnotationElementCS
		//| ownedPreconditions+=PostCS
		//| ownedPostconditions+=PreCS)*
		public Alternatives getAlternatives_14_0_1() { return cAlternatives_14_0_1; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_14_0_1_0() { return cOwnedAnnotationsAssignment_14_0_1_0; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_14_0_1_0_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_14_0_1_0_0; }

		//ownedPreconditions+=PostCS
		public Assignment getOwnedPreconditionsAssignment_14_0_1_1() { return cOwnedPreconditionsAssignment_14_0_1_1; }

		//PostCS
		public RuleCall getOwnedPreconditionsPostCSParserRuleCall_14_0_1_1_0() { return cOwnedPreconditionsPostCSParserRuleCall_14_0_1_1_0; }

		//ownedPostconditions+=PreCS
		public Assignment getOwnedPostconditionsAssignment_14_0_1_2() { return cOwnedPostconditionsAssignment_14_0_1_2; }

		//PreCS
		public RuleCall getOwnedPostconditionsPreCSParserRuleCall_14_0_1_2_0() { return cOwnedPostconditionsPreCSParserRuleCall_14_0_1_2_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_14_0_2() { return cRightCurlyBracketKeyword_14_0_2; }

		//';'
		public Keyword getSemicolonKeyword_14_1() { return cSemicolonKeyword_14_1; }
	}

	public class IteratorCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.IteratorCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIdentifierParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0 = (RuleCall)cOwnedTypeAssignment_2.eContents().get(0);

		//IteratorCS base::ParameterCS:
		//	name=Identifier ':' ownedType=TypedMultiplicityRefCS;
		@Override public ParserRule getRule() { return rule; }

		//name=Identifier ':' ownedType=TypedMultiplicityRefCS
		public Group getGroup() { return cGroup; }

		//name=Identifier
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//Identifier
		public RuleCall getNameIdentifierParserRuleCall_0_0() { return cNameIdentifierParserRuleCall_0_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_2() { return cOwnedTypeAssignment_2; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0; }
	}

	public class LambdaTypeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LambdaTypeCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cNameLambdaKeyword_0_0 = (Keyword)cNameAssignment_0.eContents().get(0);
		private final Assignment cOwnedSignatureAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_1_0 = (RuleCall)cOwnedSignatureAssignment_1.eContents().get(0);
		private final Assignment cOwnedContextTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedContextTypeLambdaContextTypeRefCSParserRuleCall_2_0 = (RuleCall)cOwnedContextTypeAssignment_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Assignment cOwnedParameterTypesAssignment_4_0 = (Assignment)cGroup_4.eContents().get(0);
		private final RuleCall cOwnedParameterTypesTypedMultiplicityRefCSParserRuleCall_4_0_0 = (RuleCall)cOwnedParameterTypesAssignment_4_0.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cGroup_4.eContents().get(1);
		private final Keyword cCommaKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cOwnedParameterTypesAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cOwnedParameterTypesTypedMultiplicityRefCSParserRuleCall_4_1_1_0 = (RuleCall)cOwnedParameterTypesAssignment_4_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cColonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cOwnedResultTypeAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cOwnedResultTypeTypedRefCSParserRuleCall_7_0 = (RuleCall)cOwnedResultTypeAssignment_7.eContents().get(0);

		//LambdaTypeCS base::LambdaTypeCS:
		//	name='Lambda' ownedSignature=TemplateSignatureCS? ownedContextType=LambdaContextTypeRefCS
		//	'(' (ownedParameterTypes+=TypedMultiplicityRefCS (',' ownedParameterTypes+=TypedMultiplicityRefCS)*)? ')'
		//	':' ownedResultType=TypedRefCS;
		@Override public ParserRule getRule() { return rule; }

		//name='Lambda' ownedSignature=TemplateSignatureCS? ownedContextType=LambdaContextTypeRefCS
		//'(' (ownedParameterTypes+=TypedMultiplicityRefCS (',' ownedParameterTypes+=TypedMultiplicityRefCS)*)? ')'
		//':' ownedResultType=TypedRefCS
		public Group getGroup() { return cGroup; }

		//name='Lambda'
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//'Lambda'
		public Keyword getNameLambdaKeyword_0_0() { return cNameLambdaKeyword_0_0; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_1() { return cOwnedSignatureAssignment_1; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_1_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_1_0; }

		//ownedContextType=LambdaContextTypeRefCS
		public Assignment getOwnedContextTypeAssignment_2() { return cOwnedContextTypeAssignment_2; }

		//LambdaContextTypeRefCS
		public RuleCall getOwnedContextTypeLambdaContextTypeRefCSParserRuleCall_2_0() { return cOwnedContextTypeLambdaContextTypeRefCSParserRuleCall_2_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }

		//(ownedParameterTypes+=TypedMultiplicityRefCS (',' ownedParameterTypes+=TypedMultiplicityRefCS)*)?
		public Group getGroup_4() { return cGroup_4; }

		//ownedParameterTypes+=TypedMultiplicityRefCS
		public Assignment getOwnedParameterTypesAssignment_4_0() { return cOwnedParameterTypesAssignment_4_0; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedParameterTypesTypedMultiplicityRefCSParserRuleCall_4_0_0() { return cOwnedParameterTypesTypedMultiplicityRefCSParserRuleCall_4_0_0; }

		//(',' ownedParameterTypes+=TypedMultiplicityRefCS)*
		public Group getGroup_4_1() { return cGroup_4_1; }

		//','
		public Keyword getCommaKeyword_4_1_0() { return cCommaKeyword_4_1_0; }

		//ownedParameterTypes+=TypedMultiplicityRefCS
		public Assignment getOwnedParameterTypesAssignment_4_1_1() { return cOwnedParameterTypesAssignment_4_1_1; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedParameterTypesTypedMultiplicityRefCSParserRuleCall_4_1_1_0() { return cOwnedParameterTypesTypedMultiplicityRefCSParserRuleCall_4_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }

		//':'
		public Keyword getColonKeyword_6() { return cColonKeyword_6; }

		//ownedResultType=TypedRefCS
		public Assignment getOwnedResultTypeAssignment_7() { return cOwnedResultTypeAssignment_7; }

		//TypedRefCS
		public RuleCall getOwnedResultTypeTypedRefCSParserRuleCall_7_0() { return cOwnedResultTypeTypedRefCSParserRuleCall_7_0; }
	}

	public class LambdaContextTypeRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LambdaContextTypeRefCS");
		private final Assignment cOwnedPathNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cOwnedPathNameLibPathNameCSParserRuleCall_0 = (RuleCall)cOwnedPathNameAssignment.eContents().get(0);

		//LambdaContextTypeRefCS base::TypedTypeRefCS:
		//	ownedPathName=LibPathNameCS;
		@Override public ParserRule getRule() { return rule; }

		//ownedPathName=LibPathNameCS
		public Assignment getOwnedPathNameAssignment() { return cOwnedPathNameAssignment; }

		//LibPathNameCS
		public RuleCall getOwnedPathNameLibPathNameCSParserRuleCall_0() { return cOwnedPathNameLibPathNameCSParserRuleCall_0; }
	}

	public class OperationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.OperationCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cLibCoercionCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cLibIterationCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cLibOperationCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);

		//OperationCS base::OperationCS:
		//	LibCoercionCS | LibIterationCS | LibOperationCS;
		@Override public ParserRule getRule() { return rule; }

		//LibCoercionCS | LibIterationCS | LibOperationCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//LibCoercionCS
		public RuleCall getLibCoercionCSParserRuleCall_0() { return cLibCoercionCSParserRuleCall_0; }

		//LibIterationCS
		public RuleCall getLibIterationCSParserRuleCall_1() { return cLibIterationCSParserRuleCall_1; }

		//LibOperationCS
		public RuleCall getLibOperationCSParserRuleCall_2() { return cLibOperationCSParserRuleCall_2; }
	}

	public class LibOperationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibOperationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsStaticAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsStaticStaticKeyword_0_0 = (Keyword)cIsStaticAssignment_0.eContents().get(0);
		private final Keyword cOperationKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cOwnedSignatureAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_3_0 = (RuleCall)cOwnedSignatureAssignment_3.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Assignment cOwnedParametersAssignment_5_0 = (Assignment)cGroup_5.eContents().get(0);
		private final RuleCall cOwnedParametersParameterCSParserRuleCall_5_0_0 = (RuleCall)cOwnedParametersAssignment_5_0.eContents().get(0);
		private final Group cGroup_5_1 = (Group)cGroup_5.eContents().get(1);
		private final Keyword cCommaKeyword_5_1_0 = (Keyword)cGroup_5_1.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_5_1_1 = (Assignment)cGroup_5_1.eContents().get(1);
		private final RuleCall cOwnedParametersParameterCSParserRuleCall_5_1_1_0 = (RuleCall)cOwnedParametersAssignment_5_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Keyword cColonKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Assignment cOwnedTypeAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_8_0 = (RuleCall)cOwnedTypeAssignment_8.eContents().get(0);
		private final Assignment cIsValidatingAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final Keyword cIsValidatingValidatingKeyword_9_0 = (Keyword)cIsValidatingAssignment_9.eContents().get(0);
		private final Assignment cIsInvalidatingAssignment_10 = (Assignment)cGroup.eContents().get(10);
		private final Keyword cIsInvalidatingInvalidatingKeyword_10_0 = (Keyword)cIsInvalidatingAssignment_10.eContents().get(0);
		private final Group cGroup_11 = (Group)cGroup.eContents().get(11);
		private final Keyword cPrecedenceKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Keyword cEqualsSignKeyword_11_1 = (Keyword)cGroup_11.eContents().get(1);
		private final Assignment cPrecedenceAssignment_11_2 = (Assignment)cGroup_11.eContents().get(2);
		private final CrossReference cPrecedencePrecedenceCrossReference_11_2_0 = (CrossReference)cPrecedenceAssignment_11_2.eContents().get(0);
		private final RuleCall cPrecedencePrecedenceNameParserRuleCall_11_2_0_1 = (RuleCall)cPrecedencePrecedenceCrossReference_11_2_0.eContents().get(1);
		private final Group cGroup_12 = (Group)cGroup.eContents().get(12);
		private final Keyword cEqualsSignGreaterThanSignKeyword_12_0 = (Keyword)cGroup_12.eContents().get(0);
		private final Assignment cImplementationAssignment_12_1 = (Assignment)cGroup_12.eContents().get(1);
		private final CrossReference cImplementationJavaClassCSCrossReference_12_1_0 = (CrossReference)cImplementationAssignment_12_1.eContents().get(0);
		private final RuleCall cImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_12_1_0_1 = (RuleCall)cImplementationJavaClassCSCrossReference_12_1_0.eContents().get(1);
		private final Alternatives cAlternatives_13 = (Alternatives)cGroup.eContents().get(13);
		private final Group cGroup_13_0 = (Group)cAlternatives_13.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_13_0_0 = (Keyword)cGroup_13_0.eContents().get(0);
		private final Alternatives cAlternatives_13_0_1 = (Alternatives)cGroup_13_0.eContents().get(1);
		private final Assignment cOwnedAnnotationsAssignment_13_0_1_0 = (Assignment)cAlternatives_13_0_1.eContents().get(0);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_13_0_1_0_0 = (RuleCall)cOwnedAnnotationsAssignment_13_0_1_0.eContents().get(0);
		private final Group cGroup_13_0_1_1 = (Group)cAlternatives_13_0_1.eContents().get(1);
		private final Keyword cBodyKeyword_13_0_1_1_0 = (Keyword)cGroup_13_0_1_1.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_13_0_1_1_1 = (RuleCall)cGroup_13_0_1_1.eContents().get(1);
		private final Keyword cColonKeyword_13_0_1_1_2 = (Keyword)cGroup_13_0_1_1.eContents().get(2);
		private final Assignment cOwnedBodyExpressionsAssignment_13_0_1_1_3 = (Assignment)cGroup_13_0_1_1.eContents().get(3);
		private final RuleCall cOwnedBodyExpressionsSpecificationCSParserRuleCall_13_0_1_1_3_0 = (RuleCall)cOwnedBodyExpressionsAssignment_13_0_1_1_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_13_0_1_1_4 = (Keyword)cGroup_13_0_1_1.eContents().get(4);
		private final Assignment cOwnedPostconditionsAssignment_13_0_1_2 = (Assignment)cAlternatives_13_0_1.eContents().get(2);
		private final RuleCall cOwnedPostconditionsPostCSParserRuleCall_13_0_1_2_0 = (RuleCall)cOwnedPostconditionsAssignment_13_0_1_2.eContents().get(0);
		private final Assignment cOwnedPreconditionsAssignment_13_0_1_3 = (Assignment)cAlternatives_13_0_1.eContents().get(3);
		private final RuleCall cOwnedPreconditionsPreCSParserRuleCall_13_0_1_3_0 = (RuleCall)cOwnedPreconditionsAssignment_13_0_1_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_13_0_2 = (Keyword)cGroup_13_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_13_1 = (Keyword)cAlternatives_13.eContents().get(1);

		//LibOperationCS:
		//	isStatic?='static'? 'operation' name=Name
		//	ownedSignature=TemplateSignatureCS?
		//	'(' (ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)? ')'
		//	':' ownedType=TypedMultiplicityRefCS
		//	isValidating?='validating'?
		//	isInvalidating?='invalidating'? ('precedence' '=' precedence=[pivot::Precedence|Name])? ('=>'
		//	implementation=[JavaClassCS|SINGLE_QUOTED_STRING])? ('{' (ownedAnnotations+=AnnotationElementCS
		//	| 'body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS ';' | ownedPostconditions+=PostCS
		//	| ownedPreconditions+=PreCS)* '}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//isStatic?='static'? 'operation' name=Name
		//ownedSignature=TemplateSignatureCS?
		//'(' (ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)? ')'
		//':' ownedType=TypedMultiplicityRefCS
		//isValidating?='validating'?
		//isInvalidating?='invalidating'? ('precedence' '=' precedence=[pivot::Precedence|Name])? ('=>'
		//implementation=[JavaClassCS|SINGLE_QUOTED_STRING])? ('{' (ownedAnnotations+=AnnotationElementCS
		//| 'body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS ';' | ownedPostconditions+=PostCS
		//| ownedPreconditions+=PreCS)* '}' | ';')
		public Group getGroup() { return cGroup; }

		//isStatic?='static'?
		public Assignment getIsStaticAssignment_0() { return cIsStaticAssignment_0; }

		//'static'
		public Keyword getIsStaticStaticKeyword_0_0() { return cIsStaticStaticKeyword_0_0; }

		//'operation'
		public Keyword getOperationKeyword_1() { return cOperationKeyword_1; }

		//name=Name
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//Name
		public RuleCall getNameNameParserRuleCall_2_0() { return cNameNameParserRuleCall_2_0; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_3() { return cOwnedSignatureAssignment_3; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_3_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_4() { return cLeftParenthesisKeyword_4; }

		//(ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)?
		public Group getGroup_5() { return cGroup_5; }

		//ownedParameters+=ParameterCS
		public Assignment getOwnedParametersAssignment_5_0() { return cOwnedParametersAssignment_5_0; }

		//ParameterCS
		public RuleCall getOwnedParametersParameterCSParserRuleCall_5_0_0() { return cOwnedParametersParameterCSParserRuleCall_5_0_0; }

		//(',' ownedParameters+=ParameterCS)*
		public Group getGroup_5_1() { return cGroup_5_1; }

		//','
		public Keyword getCommaKeyword_5_1_0() { return cCommaKeyword_5_1_0; }

		//ownedParameters+=ParameterCS
		public Assignment getOwnedParametersAssignment_5_1_1() { return cOwnedParametersAssignment_5_1_1; }

		//ParameterCS
		public RuleCall getOwnedParametersParameterCSParserRuleCall_5_1_1_0() { return cOwnedParametersParameterCSParserRuleCall_5_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_6() { return cRightParenthesisKeyword_6; }

		//':'
		public Keyword getColonKeyword_7() { return cColonKeyword_7; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_8() { return cOwnedTypeAssignment_8; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_8_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_8_0; }

		//isValidating?='validating'?
		public Assignment getIsValidatingAssignment_9() { return cIsValidatingAssignment_9; }

		//'validating'
		public Keyword getIsValidatingValidatingKeyword_9_0() { return cIsValidatingValidatingKeyword_9_0; }

		//isInvalidating?='invalidating'?
		public Assignment getIsInvalidatingAssignment_10() { return cIsInvalidatingAssignment_10; }

		//'invalidating'
		public Keyword getIsInvalidatingInvalidatingKeyword_10_0() { return cIsInvalidatingInvalidatingKeyword_10_0; }

		//('precedence' '=' precedence=[pivot::Precedence|Name])?
		public Group getGroup_11() { return cGroup_11; }

		//'precedence'
		public Keyword getPrecedenceKeyword_11_0() { return cPrecedenceKeyword_11_0; }

		//'='
		public Keyword getEqualsSignKeyword_11_1() { return cEqualsSignKeyword_11_1; }

		//precedence=[pivot::Precedence|Name]
		public Assignment getPrecedenceAssignment_11_2() { return cPrecedenceAssignment_11_2; }

		//[pivot::Precedence|Name]
		public CrossReference getPrecedencePrecedenceCrossReference_11_2_0() { return cPrecedencePrecedenceCrossReference_11_2_0; }

		//Name
		public RuleCall getPrecedencePrecedenceNameParserRuleCall_11_2_0_1() { return cPrecedencePrecedenceNameParserRuleCall_11_2_0_1; }

		//('=>' implementation=[JavaClassCS|SINGLE_QUOTED_STRING])?
		public Group getGroup_12() { return cGroup_12; }

		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_12_0() { return cEqualsSignGreaterThanSignKeyword_12_0; }

		//implementation=[JavaClassCS|SINGLE_QUOTED_STRING]
		public Assignment getImplementationAssignment_12_1() { return cImplementationAssignment_12_1; }

		//[JavaClassCS|SINGLE_QUOTED_STRING]
		public CrossReference getImplementationJavaClassCSCrossReference_12_1_0() { return cImplementationJavaClassCSCrossReference_12_1_0; }

		//SINGLE_QUOTED_STRING
		public RuleCall getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_12_1_0_1() { return cImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_12_1_0_1; }

		//('{' (ownedAnnotations+=AnnotationElementCS
		//| 'body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS ';' | ownedPostconditions+=PostCS
		//| ownedPreconditions+=PreCS)* '}' | ';')
		public Alternatives getAlternatives_13() { return cAlternatives_13; }

		//'{' (ownedAnnotations+=AnnotationElementCS
		//| 'body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS ';' | ownedPostconditions+=PostCS
		//| ownedPreconditions+=PreCS)* '}'
		public Group getGroup_13_0() { return cGroup_13_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_13_0_0() { return cLeftCurlyBracketKeyword_13_0_0; }

		//(ownedAnnotations+=AnnotationElementCS
		//| 'body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS ';' | ownedPostconditions+=PostCS
		//| ownedPreconditions+=PreCS)*
		public Alternatives getAlternatives_13_0_1() { return cAlternatives_13_0_1; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_13_0_1_0() { return cOwnedAnnotationsAssignment_13_0_1_0; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_13_0_1_0_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_13_0_1_0_0; }

		//'body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS ';'
		public Group getGroup_13_0_1_1() { return cGroup_13_0_1_1; }

		//'body'
		public Keyword getBodyKeyword_13_0_1_1_0() { return cBodyKeyword_13_0_1_1_0; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_13_0_1_1_1() { return cUnrestrictedNameParserRuleCall_13_0_1_1_1; }

		//':'
		public Keyword getColonKeyword_13_0_1_1_2() { return cColonKeyword_13_0_1_1_2; }

		//ownedBodyExpressions+=SpecificationCS
		public Assignment getOwnedBodyExpressionsAssignment_13_0_1_1_3() { return cOwnedBodyExpressionsAssignment_13_0_1_1_3; }

		//SpecificationCS
		public RuleCall getOwnedBodyExpressionsSpecificationCSParserRuleCall_13_0_1_1_3_0() { return cOwnedBodyExpressionsSpecificationCSParserRuleCall_13_0_1_1_3_0; }

		//';'
		public Keyword getSemicolonKeyword_13_0_1_1_4() { return cSemicolonKeyword_13_0_1_1_4; }

		//ownedPostconditions+=PostCS
		public Assignment getOwnedPostconditionsAssignment_13_0_1_2() { return cOwnedPostconditionsAssignment_13_0_1_2; }

		//PostCS
		public RuleCall getOwnedPostconditionsPostCSParserRuleCall_13_0_1_2_0() { return cOwnedPostconditionsPostCSParserRuleCall_13_0_1_2_0; }

		//ownedPreconditions+=PreCS
		public Assignment getOwnedPreconditionsAssignment_13_0_1_3() { return cOwnedPreconditionsAssignment_13_0_1_3; }

		//PreCS
		public RuleCall getOwnedPreconditionsPreCSParserRuleCall_13_0_1_3_0() { return cOwnedPreconditionsPreCSParserRuleCall_13_0_1_3_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_13_0_2() { return cRightCurlyBracketKeyword_13_0_2; }

		//';'
		public Keyword getSemicolonKeyword_13_1() { return cSemicolonKeyword_13_1; }
	}

	public class LibOppositeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibOppositeCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cOppositeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_0 = (RuleCall)cOwnedTypeAssignment_3.eContents().get(0);

		//LibOppositeCS:
		//	'opposite' name=Name ':' ownedType=TypedMultiplicityRefCS;
		@Override public ParserRule getRule() { return rule; }

		//'opposite' name=Name ':' ownedType=TypedMultiplicityRefCS
		public Group getGroup() { return cGroup; }

		//'opposite'
		public Keyword getOppositeKeyword_0() { return cOppositeKeyword_0; }

		//name=Name
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//Name
		public RuleCall getNameNameParserRuleCall_1_0() { return cNameNameParserRuleCall_1_0; }

		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_3() { return cOwnedTypeAssignment_3; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_0; }
	}

	public class LibPackageCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibPackageCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLibraryKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cNsPrefixAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cNsPrefixIdentifierParserRuleCall_2_1_0 = (RuleCall)cNsPrefixAssignment_2_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Assignment cNsURIAssignment_2_3 = (Assignment)cGroup_2.eContents().get(3);
		private final RuleCall cNsURIURIParserRuleCall_2_3_0 = (RuleCall)cNsURIAssignment_2_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cOwnedPackagesAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final RuleCall cOwnedPackagesPackageCSParserRuleCall_4_0_0 = (RuleCall)cOwnedPackagesAssignment_4_0.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cAlternatives_4.eContents().get(1);
		private final Keyword cPrecedenceKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cOwnedPrecedencesAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cOwnedPrecedencesPrecedenceCSParserRuleCall_4_1_1_0 = (RuleCall)cOwnedPrecedencesAssignment_4_1_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_4_1_2 = (Keyword)cGroup_4_1.eContents().get(2);
		private final Assignment cOwnedClassesAssignment_4_2 = (Assignment)cAlternatives_4.eContents().get(2);
		private final RuleCall cOwnedClassesClassCSParserRuleCall_4_2_0 = (RuleCall)cOwnedClassesAssignment_4_2.eContents().get(0);
		private final Assignment cOwnedAnnotationsAssignment_4_3 = (Assignment)cAlternatives_4.eContents().get(3);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_4_3_0 = (RuleCall)cOwnedAnnotationsAssignment_4_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);

		//LibPackageCS:
		//	'library' name=Name (':' nsPrefix=Identifier '=' nsURI=URI)?
		//	'{' (ownedPackages+=PackageCS
		//	| 'precedence' ownedPrecedences+=PrecedenceCS+ ';' | ownedClasses+=ClassCS
		//	| ownedAnnotations+=AnnotationElementCS)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }

		//'library' name=Name (':' nsPrefix=Identifier '=' nsURI=URI)?
		//'{' (ownedPackages+=PackageCS
		//| 'precedence' ownedPrecedences+=PrecedenceCS+ ';' | ownedClasses+=ClassCS
		//| ownedAnnotations+=AnnotationElementCS)*
		//'}'
		public Group getGroup() { return cGroup; }

		//'library'
		public Keyword getLibraryKeyword_0() { return cLibraryKeyword_0; }

		//name=Name
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//Name
		public RuleCall getNameNameParserRuleCall_1_0() { return cNameNameParserRuleCall_1_0; }

		//(':' nsPrefix=Identifier '=' nsURI=URI)?
		public Group getGroup_2() { return cGroup_2; }

		//':'
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//nsPrefix=Identifier
		public Assignment getNsPrefixAssignment_2_1() { return cNsPrefixAssignment_2_1; }

		//Identifier
		public RuleCall getNsPrefixIdentifierParserRuleCall_2_1_0() { return cNsPrefixIdentifierParserRuleCall_2_1_0; }

		//'='
		public Keyword getEqualsSignKeyword_2_2() { return cEqualsSignKeyword_2_2; }

		//nsURI=URI
		public Assignment getNsURIAssignment_2_3() { return cNsURIAssignment_2_3; }

		//URI
		public RuleCall getNsURIURIParserRuleCall_2_3_0() { return cNsURIURIParserRuleCall_2_3_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }

		//(ownedPackages+=PackageCS
		//| 'precedence' ownedPrecedences+=PrecedenceCS+ ';' | ownedClasses+=ClassCS
		//| ownedAnnotations+=AnnotationElementCS)*
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//ownedPackages+=PackageCS
		public Assignment getOwnedPackagesAssignment_4_0() { return cOwnedPackagesAssignment_4_0; }

		//PackageCS
		public RuleCall getOwnedPackagesPackageCSParserRuleCall_4_0_0() { return cOwnedPackagesPackageCSParserRuleCall_4_0_0; }

		//'precedence' ownedPrecedences+=PrecedenceCS+ ';'
		public Group getGroup_4_1() { return cGroup_4_1; }

		//'precedence'
		public Keyword getPrecedenceKeyword_4_1_0() { return cPrecedenceKeyword_4_1_0; }

		//ownedPrecedences+=PrecedenceCS+
		public Assignment getOwnedPrecedencesAssignment_4_1_1() { return cOwnedPrecedencesAssignment_4_1_1; }

		//PrecedenceCS
		public RuleCall getOwnedPrecedencesPrecedenceCSParserRuleCall_4_1_1_0() { return cOwnedPrecedencesPrecedenceCSParserRuleCall_4_1_1_0; }

		//';'
		public Keyword getSemicolonKeyword_4_1_2() { return cSemicolonKeyword_4_1_2; }

		//ownedClasses+=ClassCS
		public Assignment getOwnedClassesAssignment_4_2() { return cOwnedClassesAssignment_4_2; }

		//ClassCS
		public RuleCall getOwnedClassesClassCSParserRuleCall_4_2_0() { return cOwnedClassesClassCSParserRuleCall_4_2_0; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_4_3() { return cOwnedAnnotationsAssignment_4_3; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_4_3_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_4_3_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}

	public class PackageCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.PackageCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPackageKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cNsPrefixAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cNsPrefixIdentifierParserRuleCall_2_1_0 = (RuleCall)cNsPrefixAssignment_2_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Assignment cNsURIAssignment_2_3 = (Assignment)cGroup_2.eContents().get(3);
		private final RuleCall cNsURIURIParserRuleCall_2_3_0 = (RuleCall)cNsURIAssignment_2_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cOwnedPackagesAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final RuleCall cOwnedPackagesPackageCSParserRuleCall_4_0_0 = (RuleCall)cOwnedPackagesAssignment_4_0.eContents().get(0);
		private final Assignment cOwnedClassesAssignment_4_1 = (Assignment)cAlternatives_4.eContents().get(1);
		private final RuleCall cOwnedClassesClassCSParserRuleCall_4_1_0 = (RuleCall)cOwnedClassesAssignment_4_1.eContents().get(0);
		private final Assignment cOwnedAnnotationsAssignment_4_2 = (Assignment)cAlternatives_4.eContents().get(2);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_4_2_0 = (RuleCall)cOwnedAnnotationsAssignment_4_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);

		//PackageCS base::PackageCS:
		//	'package' name=Name (':' nsPrefix=Identifier '=' nsURI=URI)?
		//	'{' (ownedPackages+=PackageCS
		//	| ownedClasses+=ClassCS
		//	| ownedAnnotations+=AnnotationElementCS)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }

		//'package' name=Name (':' nsPrefix=Identifier '=' nsURI=URI)?
		//'{' (ownedPackages+=PackageCS
		//| ownedClasses+=ClassCS
		//| ownedAnnotations+=AnnotationElementCS)*
		//'}'
		public Group getGroup() { return cGroup; }

		//'package'
		public Keyword getPackageKeyword_0() { return cPackageKeyword_0; }

		//name=Name
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//Name
		public RuleCall getNameNameParserRuleCall_1_0() { return cNameNameParserRuleCall_1_0; }

		//(':' nsPrefix=Identifier '=' nsURI=URI)?
		public Group getGroup_2() { return cGroup_2; }

		//':'
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//nsPrefix=Identifier
		public Assignment getNsPrefixAssignment_2_1() { return cNsPrefixAssignment_2_1; }

		//Identifier
		public RuleCall getNsPrefixIdentifierParserRuleCall_2_1_0() { return cNsPrefixIdentifierParserRuleCall_2_1_0; }

		//'='
		public Keyword getEqualsSignKeyword_2_2() { return cEqualsSignKeyword_2_2; }

		//nsURI=URI
		public Assignment getNsURIAssignment_2_3() { return cNsURIAssignment_2_3; }

		//URI
		public RuleCall getNsURIURIParserRuleCall_2_3_0() { return cNsURIURIParserRuleCall_2_3_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }

		//(ownedPackages+=PackageCS
		//| ownedClasses+=ClassCS
		//| ownedAnnotations+=AnnotationElementCS)*
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//ownedPackages+=PackageCS
		public Assignment getOwnedPackagesAssignment_4_0() { return cOwnedPackagesAssignment_4_0; }

		//PackageCS
		public RuleCall getOwnedPackagesPackageCSParserRuleCall_4_0_0() { return cOwnedPackagesPackageCSParserRuleCall_4_0_0; }

		//ownedClasses+=ClassCS
		public Assignment getOwnedClassesAssignment_4_1() { return cOwnedClassesAssignment_4_1; }

		//ClassCS
		public RuleCall getOwnedClassesClassCSParserRuleCall_4_1_0() { return cOwnedClassesClassCSParserRuleCall_4_1_0; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_4_2() { return cOwnedAnnotationsAssignment_4_2; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_4_2_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_4_2_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}

	public class ParameterCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.ParameterCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIdentifierParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0 = (RuleCall)cOwnedTypeAssignment_2.eContents().get(0);

		//ParameterCS base::ParameterCS:
		//	name=Identifier ':' ownedType=TypedMultiplicityRefCS;
		@Override public ParserRule getRule() { return rule; }

		//name=Identifier ':' ownedType=TypedMultiplicityRefCS
		public Group getGroup() { return cGroup; }

		//name=Identifier
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//Identifier
		public RuleCall getNameIdentifierParserRuleCall_0_0() { return cNameIdentifierParserRuleCall_0_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_2() { return cOwnedTypeAssignment_2; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0; }
	}

	public class LibPropertyCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibPropertyCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsStaticAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsStaticStaticKeyword_0_0 = (Keyword)cIsStaticAssignment_0.eContents().get(0);
		private final Keyword cPropertyKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cOwnedTypeAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_0 = (RuleCall)cOwnedTypeAssignment_4.eContents().get(0);
		private final Assignment cOwnedOppositeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cOwnedOppositeLibOppositeCSParserRuleCall_5_0 = (RuleCall)cOwnedOppositeAssignment_5.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cEqualsSignGreaterThanSignKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cImplementationAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final CrossReference cImplementationJavaClassCSCrossReference_6_1_0 = (CrossReference)cImplementationAssignment_6_1.eContents().get(0);
		private final RuleCall cImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1 = (RuleCall)cImplementationJavaClassCSCrossReference_6_1_0.eContents().get(1);
		private final Alternatives cAlternatives_7 = (Alternatives)cGroup.eContents().get(7);
		private final Group cGroup_7_0 = (Group)cAlternatives_7.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_7_0_0 = (Keyword)cGroup_7_0.eContents().get(0);
		private final Assignment cOwnedAnnotationsAssignment_7_0_1 = (Assignment)cGroup_7_0.eContents().get(1);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0 = (RuleCall)cOwnedAnnotationsAssignment_7_0_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7_0_2 = (Keyword)cGroup_7_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_7_1 = (Keyword)cAlternatives_7.eContents().get(1);

		//LibPropertyCS:
		//	isStatic?='static'? 'property' name=Name
		//	':' ownedType=TypedMultiplicityRefCS
		//	ownedOpposite=LibOppositeCS? ('=>' implementation=[JavaClassCS|SINGLE_QUOTED_STRING])? ('{'
		//	ownedAnnotations+=AnnotationElementCS* '}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//isStatic?='static'? 'property' name=Name
		//':' ownedType=TypedMultiplicityRefCS
		//ownedOpposite=LibOppositeCS? ('=>' implementation=[JavaClassCS|SINGLE_QUOTED_STRING])? ('{'
		//ownedAnnotations+=AnnotationElementCS* '}' | ';')
		public Group getGroup() { return cGroup; }

		//isStatic?='static'?
		public Assignment getIsStaticAssignment_0() { return cIsStaticAssignment_0; }

		//'static'
		public Keyword getIsStaticStaticKeyword_0_0() { return cIsStaticStaticKeyword_0_0; }

		//'property'
		public Keyword getPropertyKeyword_1() { return cPropertyKeyword_1; }

		//name=Name
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//Name
		public RuleCall getNameNameParserRuleCall_2_0() { return cNameNameParserRuleCall_2_0; }

		//':'
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_4() { return cOwnedTypeAssignment_4; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_0; }

		//ownedOpposite=LibOppositeCS?
		public Assignment getOwnedOppositeAssignment_5() { return cOwnedOppositeAssignment_5; }

		//LibOppositeCS
		public RuleCall getOwnedOppositeLibOppositeCSParserRuleCall_5_0() { return cOwnedOppositeLibOppositeCSParserRuleCall_5_0; }

		//('=>' implementation=[JavaClassCS|SINGLE_QUOTED_STRING])?
		public Group getGroup_6() { return cGroup_6; }

		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_6_0() { return cEqualsSignGreaterThanSignKeyword_6_0; }

		//implementation=[JavaClassCS|SINGLE_QUOTED_STRING]
		public Assignment getImplementationAssignment_6_1() { return cImplementationAssignment_6_1; }

		//[JavaClassCS|SINGLE_QUOTED_STRING]
		public CrossReference getImplementationJavaClassCSCrossReference_6_1_0() { return cImplementationJavaClassCSCrossReference_6_1_0; }

		//SINGLE_QUOTED_STRING
		public RuleCall getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1() { return cImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1; }

		//('{' ownedAnnotations+=AnnotationElementCS* '}' | ';')
		public Alternatives getAlternatives_7() { return cAlternatives_7; }

		//'{' ownedAnnotations+=AnnotationElementCS* '}'
		public Group getGroup_7_0() { return cGroup_7_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_7_0_0() { return cLeftCurlyBracketKeyword_7_0_0; }

		//ownedAnnotations+=AnnotationElementCS*
		public Assignment getOwnedAnnotationsAssignment_7_0_1() { return cOwnedAnnotationsAssignment_7_0_1; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_7_0_2() { return cRightCurlyBracketKeyword_7_0_2; }

		//';'
		public Keyword getSemicolonKeyword_7_1() { return cSemicolonKeyword_7_1; }
	}

	public class PostCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.PostCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cStereotypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cStereotypePostKeyword_0_0 = (Keyword)cStereotypeAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0_0 = (RuleCall)cNameAssignment_1_0.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cOwnedMessageSpecificationAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0 = (RuleCall)cOwnedMessageSpecificationAssignment_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_1_2 = (Keyword)cGroup_1_1.eContents().get(2);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedSpecificationAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedSpecificationSpecificationCSParserRuleCall_3_0 = (RuleCall)cOwnedSpecificationAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//PostCS LibConstraintCS:
		//	stereotype='post' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
		//	ownedSpecification=SpecificationCS ';';
		@Override public ParserRule getRule() { return rule; }

		//stereotype='post' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
		//ownedSpecification=SpecificationCS ';'
		public Group getGroup() { return cGroup; }

		//stereotype='post'
		public Assignment getStereotypeAssignment_0() { return cStereotypeAssignment_0; }

		//'post'
		public Keyword getStereotypePostKeyword_0_0() { return cStereotypePostKeyword_0_0; }

		//(name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)?
		public Group getGroup_1() { return cGroup_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_1_0() { return cNameAssignment_1_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0_0() { return cNameUnrestrictedNameParserRuleCall_1_0_0; }

		//('(' ownedMessageSpecification=SpecificationCS ')')?
		public Group getGroup_1_1() { return cGroup_1_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_1_1_0() { return cLeftParenthesisKeyword_1_1_0; }

		//ownedMessageSpecification=SpecificationCS
		public Assignment getOwnedMessageSpecificationAssignment_1_1_1() { return cOwnedMessageSpecificationAssignment_1_1_1; }

		//SpecificationCS
		public RuleCall getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0() { return cOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_1_1_2() { return cRightParenthesisKeyword_1_1_2; }

		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//ownedSpecification=SpecificationCS
		public Assignment getOwnedSpecificationAssignment_3() { return cOwnedSpecificationAssignment_3; }

		//SpecificationCS
		public RuleCall getOwnedSpecificationSpecificationCSParserRuleCall_3_0() { return cOwnedSpecificationSpecificationCSParserRuleCall_3_0; }

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class PreCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.PreCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cStereotypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cStereotypePreKeyword_0_0 = (Keyword)cStereotypeAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0_0 = (RuleCall)cNameAssignment_1_0.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cOwnedMessageSpecificationAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0 = (RuleCall)cOwnedMessageSpecificationAssignment_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_1_2 = (Keyword)cGroup_1_1.eContents().get(2);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedSpecificationAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedSpecificationSpecificationCSParserRuleCall_3_0 = (RuleCall)cOwnedSpecificationAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//PreCS LibConstraintCS:
		//	stereotype='pre' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
		//	ownedSpecification=SpecificationCS ';';
		@Override public ParserRule getRule() { return rule; }

		//stereotype='pre' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
		//ownedSpecification=SpecificationCS ';'
		public Group getGroup() { return cGroup; }

		//stereotype='pre'
		public Assignment getStereotypeAssignment_0() { return cStereotypeAssignment_0; }

		//'pre'
		public Keyword getStereotypePreKeyword_0_0() { return cStereotypePreKeyword_0_0; }

		//(name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)?
		public Group getGroup_1() { return cGroup_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_1_0() { return cNameAssignment_1_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0_0() { return cNameUnrestrictedNameParserRuleCall_1_0_0; }

		//('(' ownedMessageSpecification=SpecificationCS ')')?
		public Group getGroup_1_1() { return cGroup_1_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_1_1_0() { return cLeftParenthesisKeyword_1_1_0; }

		//ownedMessageSpecification=SpecificationCS
		public Assignment getOwnedMessageSpecificationAssignment_1_1_1() { return cOwnedMessageSpecificationAssignment_1_1_1; }

		//SpecificationCS
		public RuleCall getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0() { return cOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_1_1_2() { return cRightParenthesisKeyword_1_1_2; }

		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//ownedSpecification=SpecificationCS
		public Assignment getOwnedSpecificationAssignment_3() { return cOwnedSpecificationAssignment_3; }

		//SpecificationCS
		public RuleCall getOwnedSpecificationSpecificationCSParserRuleCall_3_0() { return cOwnedSpecificationSpecificationCSParserRuleCall_3_0; }

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class PrecedenceCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.PrecedenceCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cLeftKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Assignment cIsRightAssociativeAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final Keyword cIsRightAssociativeRightKeyword_0_1_0 = (Keyword)cIsRightAssociativeAssignment_0_1.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);

		//PrecedenceCS:
		//	('left' | isRightAssociative?='right') ':' name=Name;
		@Override public ParserRule getRule() { return rule; }

		//('left' | isRightAssociative?='right') ':' name=Name
		public Group getGroup() { return cGroup; }

		//('left' | isRightAssociative?='right')
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//'left'
		public Keyword getLeftKeyword_0_0() { return cLeftKeyword_0_0; }

		//isRightAssociative?='right'
		public Assignment getIsRightAssociativeAssignment_0_1() { return cIsRightAssociativeAssignment_0_1; }

		//'right'
		public Keyword getIsRightAssociativeRightKeyword_0_1_0() { return cIsRightAssociativeRightKeyword_0_1_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//name=Name
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//Name
		public RuleCall getNameNameParserRuleCall_2_0() { return cNameNameParserRuleCall_2_0; }
	}

	public class SpecificationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.SpecificationCS");
		private final Assignment cOwnedExpressionAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_0 = (RuleCall)cOwnedExpressionAssignment.eContents().get(0);

		//SpecificationCS essentialocl::ExpSpecificationCS:
		//	ownedExpression=ExpCS;
		@Override public ParserRule getRule() { return rule; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment() { return cOwnedExpressionAssignment; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_0() { return cOwnedExpressionExpCSParserRuleCall_0; }
	}

	public class TypedMultiplicityRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedMultiplicityRefCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final RuleCall cMapTypeCSParserRuleCall_0_0 = (RuleCall)cAlternatives_0.eContents().get(0);
		private final RuleCall cTupleTypeCSParserRuleCall_0_1 = (RuleCall)cAlternatives_0.eContents().get(1);
		private final RuleCall cTypedTypeRefCSParserRuleCall_0_2 = (RuleCall)cAlternatives_0.eContents().get(2);
		private final RuleCall cLambdaTypeCSParserRuleCall_0_3 = (RuleCall)cAlternatives_0.eContents().get(3);
		private final Assignment cOwnedMultiplicityAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedMultiplicityMultiplicityCSParserRuleCall_1_0 = (RuleCall)cOwnedMultiplicityAssignment_1.eContents().get(0);

		//TypedMultiplicityRefCS base::TypedRefCS:
		//	(MapTypeCS | TupleTypeCS | TypedTypeRefCS | LambdaTypeCS) ownedMultiplicity=MultiplicityCS?;
		@Override public ParserRule getRule() { return rule; }

		//(MapTypeCS | TupleTypeCS | TypedTypeRefCS | LambdaTypeCS) ownedMultiplicity=MultiplicityCS?
		public Group getGroup() { return cGroup; }

		//(MapTypeCS | TupleTypeCS | TypedTypeRefCS | LambdaTypeCS)
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//MapTypeCS
		public RuleCall getMapTypeCSParserRuleCall_0_0() { return cMapTypeCSParserRuleCall_0_0; }

		//TupleTypeCS
		public RuleCall getTupleTypeCSParserRuleCall_0_1() { return cTupleTypeCSParserRuleCall_0_1; }

		//TypedTypeRefCS
		public RuleCall getTypedTypeRefCSParserRuleCall_0_2() { return cTypedTypeRefCSParserRuleCall_0_2; }

		//LambdaTypeCS
		public RuleCall getLambdaTypeCSParserRuleCall_0_3() { return cLambdaTypeCSParserRuleCall_0_3; }

		//ownedMultiplicity=MultiplicityCS?
		public Assignment getOwnedMultiplicityAssignment_1() { return cOwnedMultiplicityAssignment_1; }

		//MultiplicityCS
		public RuleCall getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0() { return cOwnedMultiplicityMultiplicityCSParserRuleCall_1_0; }
	}

	public class TypedRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedRefCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cMapTypeCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTupleTypeCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cTypedTypeRefCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cLambdaTypeCSParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);

		//@Override
		//TypedRefCS base::TypedRefCS:
		//	MapTypeCS | TupleTypeCS | TypedTypeRefCS | LambdaTypeCS;
		@Override public ParserRule getRule() { return rule; }

		//MapTypeCS | TupleTypeCS | TypedTypeRefCS | LambdaTypeCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//MapTypeCS
		public RuleCall getMapTypeCSParserRuleCall_0() { return cMapTypeCSParserRuleCall_0; }

		//TupleTypeCS
		public RuleCall getTupleTypeCSParserRuleCall_1() { return cTupleTypeCSParserRuleCall_1; }

		//TypedTypeRefCS
		public RuleCall getTypedTypeRefCSParserRuleCall_2() { return cTypedTypeRefCSParserRuleCall_2; }

		//LambdaTypeCS
		public RuleCall getLambdaTypeCSParserRuleCall_3() { return cLambdaTypeCSParserRuleCall_3; }
	}

	public class TypedTypeRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedTypeRefCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Assignment cIsTypeofAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final Keyword cIsTypeofTypeofKeyword_0_0_0 = (Keyword)cIsTypeofAssignment_0_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cOwnedPathNameAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cOwnedPathNameLibPathNameCSParserRuleCall_0_2_0 = (RuleCall)cOwnedPathNameAssignment_0_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_0_3 = (Keyword)cGroup_0.eContents().get(3);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Assignment cOwnedPathNameAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cOwnedPathNameLibPathNameCSParserRuleCall_1_0_0 = (RuleCall)cOwnedPathNameAssignment_1_0.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cOwnedBindingAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cOwnedBindingTemplateBindingCSParserRuleCall_1_1_1_0 = (RuleCall)cOwnedBindingAssignment_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_1_2 = (Keyword)cGroup_1_1.eContents().get(2);

		//@Override
		//TypedTypeRefCS base::TypedTypeRefCS:
		//	isTypeof?='typeof' '(' ownedPathName=LibPathNameCS ')' | ownedPathName=LibPathNameCS ('('
		//	ownedBinding=TemplateBindingCS ')')?;
		@Override public ParserRule getRule() { return rule; }

		//isTypeof?='typeof' '(' ownedPathName=LibPathNameCS ')' | ownedPathName=LibPathNameCS ('('
		//ownedBinding=TemplateBindingCS ')')?
		public Alternatives getAlternatives() { return cAlternatives; }

		//isTypeof?='typeof' '(' ownedPathName=LibPathNameCS ')'
		public Group getGroup_0() { return cGroup_0; }

		//isTypeof?='typeof'
		public Assignment getIsTypeofAssignment_0_0() { return cIsTypeofAssignment_0_0; }

		//'typeof'
		public Keyword getIsTypeofTypeofKeyword_0_0_0() { return cIsTypeofTypeofKeyword_0_0_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_0_1() { return cLeftParenthesisKeyword_0_1; }

		//ownedPathName=LibPathNameCS
		public Assignment getOwnedPathNameAssignment_0_2() { return cOwnedPathNameAssignment_0_2; }

		//LibPathNameCS
		public RuleCall getOwnedPathNameLibPathNameCSParserRuleCall_0_2_0() { return cOwnedPathNameLibPathNameCSParserRuleCall_0_2_0; }

		//')'
		public Keyword getRightParenthesisKeyword_0_3() { return cRightParenthesisKeyword_0_3; }

		//ownedPathName=LibPathNameCS ('(' ownedBinding=TemplateBindingCS ')')?
		public Group getGroup_1() { return cGroup_1; }

		//ownedPathName=LibPathNameCS
		public Assignment getOwnedPathNameAssignment_1_0() { return cOwnedPathNameAssignment_1_0; }

		//LibPathNameCS
		public RuleCall getOwnedPathNameLibPathNameCSParserRuleCall_1_0_0() { return cOwnedPathNameLibPathNameCSParserRuleCall_1_0_0; }

		//('(' ownedBinding=TemplateBindingCS ')')?
		public Group getGroup_1_1() { return cGroup_1_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_1_1_0() { return cLeftParenthesisKeyword_1_1_0; }

		//ownedBinding=TemplateBindingCS
		public Assignment getOwnedBindingAssignment_1_1_1() { return cOwnedBindingAssignment_1_1_1; }

		//TemplateBindingCS
		public RuleCall getOwnedBindingTemplateBindingCSParserRuleCall_1_1_1_0() { return cOwnedBindingTemplateBindingCSParserRuleCall_1_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_1_1_2() { return cRightParenthesisKeyword_1_1_2; }
	}

	public class TuplePartCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TuplePartCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIdentifierParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0 = (RuleCall)cOwnedTypeAssignment_2.eContents().get(0);

		//@Override
		//TuplePartCS base::TuplePartCS:
		//	name=Identifier ':' ownedType=TypedMultiplicityRefCS;
		@Override public ParserRule getRule() { return rule; }

		//name=Identifier ':' ownedType=TypedMultiplicityRefCS
		public Group getGroup() { return cGroup; }

		//name=Identifier
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//Identifier
		public RuleCall getNameIdentifierParserRuleCall_0_0() { return cNameIdentifierParserRuleCall_0_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_2() { return cOwnedTypeAssignment_2; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0; }
	}


	private final LibraryElements pLibrary;
	private final IdentifierElements pIdentifier;
	private final RestrictedKeywordsElements pRestrictedKeywords;
	private final NameElements pName;
	private final AnyNameElements pAnyName;
	private final LibPathNameCSElements pLibPathNameCS;
	private final LibPathElementCSElements pLibPathElementCS;
	private final AccumulatorCSElements pAccumulatorCS;
	private final AnnotationCSElements pAnnotationCS;
	private final AnnotationElementCSElements pAnnotationElementCS;
	private final LibClassCSElements pLibClassCS;
	private final ClassCSElements pClassCS;
	private final DetailCSElements pDetailCS;
	private final DocumentationCSElements pDocumentationCS;
	private final ImportCSElements pImportCS;
	private final InvCSElements pInvCS;
	private final LibCoercionCSElements pLibCoercionCS;
	private final LibIterationCSElements pLibIterationCS;
	private final IteratorCSElements pIteratorCS;
	private final LambdaTypeCSElements pLambdaTypeCS;
	private final LambdaContextTypeRefCSElements pLambdaContextTypeRefCS;
	private final OperationCSElements pOperationCS;
	private final LibOperationCSElements pLibOperationCS;
	private final LibOppositeCSElements pLibOppositeCS;
	private final LibPackageCSElements pLibPackageCS;
	private final PackageCSElements pPackageCS;
	private final ParameterCSElements pParameterCS;
	private final LibPropertyCSElements pLibPropertyCS;
	private final PostCSElements pPostCS;
	private final PreCSElements pPreCS;
	private final PrecedenceCSElements pPrecedenceCS;
	private final SpecificationCSElements pSpecificationCS;
	private final TypedMultiplicityRefCSElements pTypedMultiplicityRefCS;
	private final TypedRefCSElements pTypedRefCS;
	private final TypedTypeRefCSElements pTypedTypeRefCS;
	private final TuplePartCSElements pTuplePartCS;

	private final Grammar grammar;

	private final EssentialOCLGrammarAccess gaEssentialOCL;

	private final BaseGrammarAccess gaBase;

	@Inject
	public OCLstdlibGrammarAccess(GrammarProvider grammarProvider,
		EssentialOCLGrammarAccess gaEssentialOCL,
		BaseGrammarAccess gaBase) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaEssentialOCL = gaEssentialOCL;
		this.gaBase = gaBase;
		this.pLibrary = new LibraryElements();
		this.pIdentifier = new IdentifierElements();
		this.pRestrictedKeywords = new RestrictedKeywordsElements();
		this.pName = new NameElements();
		this.pAnyName = new AnyNameElements();
		this.pLibPathNameCS = new LibPathNameCSElements();
		this.pLibPathElementCS = new LibPathElementCSElements();
		this.pAccumulatorCS = new AccumulatorCSElements();
		this.pAnnotationCS = new AnnotationCSElements();
		this.pAnnotationElementCS = new AnnotationElementCSElements();
		this.pLibClassCS = new LibClassCSElements();
		this.pClassCS = new ClassCSElements();
		this.pDetailCS = new DetailCSElements();
		this.pDocumentationCS = new DocumentationCSElements();
		this.pImportCS = new ImportCSElements();
		this.pInvCS = new InvCSElements();
		this.pLibCoercionCS = new LibCoercionCSElements();
		this.pLibIterationCS = new LibIterationCSElements();
		this.pIteratorCS = new IteratorCSElements();
		this.pLambdaTypeCS = new LambdaTypeCSElements();
		this.pLambdaContextTypeRefCS = new LambdaContextTypeRefCSElements();
		this.pOperationCS = new OperationCSElements();
		this.pLibOperationCS = new LibOperationCSElements();
		this.pLibOppositeCS = new LibOppositeCSElements();
		this.pLibPackageCS = new LibPackageCSElements();
		this.pPackageCS = new PackageCSElements();
		this.pParameterCS = new ParameterCSElements();
		this.pLibPropertyCS = new LibPropertyCSElements();
		this.pPostCS = new PostCSElements();
		this.pPreCS = new PreCSElements();
		this.pPrecedenceCS = new PrecedenceCSElements();
		this.pSpecificationCS = new SpecificationCSElements();
		this.pTypedMultiplicityRefCS = new TypedMultiplicityRefCSElements();
		this.pTypedRefCS = new TypedRefCSElements();
		this.pTypedTypeRefCS = new TypedTypeRefCSElements();
		this.pTuplePartCS = new TuplePartCSElements();
	}

	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.ocl.xtext.oclstdlib.OCLstdlib".equals(grammar.getName())) {
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


	public EssentialOCLGrammarAccess getEssentialOCLGrammarAccess() {
		return gaEssentialOCL;
	}

	public BaseGrammarAccess getBaseGrammarAccess() {
		return gaBase;
	}


	////generate OCLstdlib "http://www.eclipse.org/ocl/examples/xtext/oclstdlib/OCLstdlibCST"
	//Library LibRootPackageCS:
	//	(ownedImports+=ImportCS ';')*
	//	ownedPackages+=LibPackageCS*;
	public LibraryElements getLibraryAccess() {
		return pLibrary;
	}

	public ParserRule getLibraryRule() {
		return getLibraryAccess().getRule();
	}

	//@Override
	//Identifier:
	//	ID
	//	| RestrictedKeywords;
	public IdentifierElements getIdentifierAccess() {
		return pIdentifier;
	}

	public ParserRule getIdentifierRule() {
		return getIdentifierAccess().getRule();
	}

	//RestrictedKeywords:
	//	'abstract'
	//	| 'annotation'
	//	| 'conformsTo'
	//	| 'documentation'
	//	| 'extends'
	//	| 'import'
	//	| 'inv'
	//	| 'invalidating'
	//	| 'iteration'
	//	| 'left'
	//	| 'library'
	//	| 'operation'
	//	| 'opposite'
	//	| 'package'
	//	| 'post'
	//	| 'pre'
	//	| 'precedence'
	//	| 'property'
	//	| 'right'
	//	| 'static'
	//	| 'type'
	////|	'typeof'
	//	| 'validating'//|	'Lambda'
	////|	'Tuple'
	//;
	public RestrictedKeywordsElements getRestrictedKeywordsAccess() {
		return pRestrictedKeywords;
	}

	public ParserRule getRestrictedKeywordsRule() {
		return getRestrictedKeywordsAccess().getRule();
	}

	//Name:
	//	Identifier
	//	| DOUBLE_QUOTED_STRING
	//	| EssentialOCLReservedKeyword
	//	| PrimitiveTypeIdentifier
	//	| CollectionTypeIdentifier;
	public NameElements getNameAccess() {
		return pName;
	}

	public ParserRule getNameRule() {
		return getNameAccess().getRule();
	}

	//AnyName:
	//	Name
	//	| 'Lambda'
	//	| 'Map'
	//	| 'Tuple';
	public AnyNameElements getAnyNameAccess() {
		return pAnyName;
	}

	public ParserRule getAnyNameRule() {
		return getAnyNameAccess().getRule();
	}

	//LibPathNameCS base::PathNameCS:
	//	ownedPathElements+=LibPathElementCS ('::' ownedPathElements+=LibPathElementCS)*;
	public LibPathNameCSElements getLibPathNameCSAccess() {
		return pLibPathNameCS;
	}

	public ParserRule getLibPathNameCSRule() {
		return getLibPathNameCSAccess().getRule();
	}

	//LibPathElementCS base::PathElementCS:
	//	referredElement=[pivot::NamedElement|Name];
	public LibPathElementCSElements getLibPathElementCSAccess() {
		return pLibPathElementCS;
	}

	public ParserRule getLibPathElementCSRule() {
		return getLibPathElementCSAccess().getRule();
	}

	//AccumulatorCS base::ParameterCS:
	//	name=Identifier ':' ownedType=TypedMultiplicityRefCS;
	public AccumulatorCSElements getAccumulatorCSAccess() {
		return pAccumulatorCS;
	}

	public ParserRule getAccumulatorCSRule() {
		return getAccumulatorCSAccess().getRule();
	}

	//AnnotationCS base::AnnotationCS:
	//	'annotation' name=(Identifier | SINGLE_QUOTED_STRING) ('(' ownedDetails+=DetailCS (',' ownedDetails+=DetailCS)* ')')
	//	? ('{' ownedAnnotations+=AnnotationElementCS '}' | ';');
	public AnnotationCSElements getAnnotationCSAccess() {
		return pAnnotationCS;
	}

	public ParserRule getAnnotationCSRule() {
		return getAnnotationCSAccess().getRule();
	}

	//AnnotationElementCS base::AnnotationElementCS:
	//	AnnotationCS | DocumentationCS;
	public AnnotationElementCSElements getAnnotationElementCSAccess() {
		return pAnnotationElementCS;
	}

	public ParserRule getAnnotationElementCSRule() {
		return getAnnotationElementCSAccess().getRule();
	}

	//LibClassCS:
	//	isAbstract?='abstract'? 'type' name=AnyName
	//	ownedSignature=TemplateSignatureCS? (':' metaclassName=[MetaclassNameCS|AnyName])? ('conformsTo'
	//	ownedSuperTypes+=TypedRefCS (',' ownedSuperTypes+=TypedRefCS)*)? ('=>'
	//	implementation=[JavaClassCS|SINGLE_QUOTED_STRING])?
	//	'{' (ownedOperations+=OperationCS
	//	| ownedProperties+=LibPropertyCS
	//	| ownedConstraints+=InvCS
	//	| ownedAnnotations+=AnnotationElementCS)* '}';
	public LibClassCSElements getLibClassCSAccess() {
		return pLibClassCS;
	}

	public ParserRule getLibClassCSRule() {
		return getLibClassCSAccess().getRule();
	}

	//ClassCS base::ClassCS:
	//	LibClassCS;
	public ClassCSElements getClassCSAccess() {
		return pClassCS;
	}

	public ParserRule getClassCSRule() {
		return getClassCSAccess().getRule();
	}

	//DetailCS base::DetailCS:
	//	name=(Name | SINGLE_QUOTED_STRING) '=' values+=(SINGLE_QUOTED_STRING | ML_SINGLE_QUOTED_STRING)*;
	public DetailCSElements getDetailCSAccess() {
		return pDetailCS;
	}

	public ParserRule getDetailCSRule() {
		return getDetailCSAccess().getRule();
	}

	//DocumentationCS base::DocumentationCS:
	//	{base::DocumentationCS} 'documentation' value=SINGLE_QUOTED_STRING? ('(' ownedDetails+=DetailCS (','
	//	ownedDetails+=DetailCS)* ')')?
	//	';';
	public DocumentationCSElements getDocumentationCSAccess() {
		return pDocumentationCS;
	}

	public ParserRule getDocumentationCSRule() {
		return getDocumentationCSAccess().getRule();
	}

	//ImportCS base::ImportCS:
	//	'import' (name=Identifier ':')? ownedPathName=URIPathNameCS isAll?='::*'?;
	public ImportCSElements getImportCSAccess() {
		return pImportCS;
	}

	public ParserRule getImportCSRule() {
		return getImportCSAccess().getRule();
	}

	//InvCS LibConstraintCS:
	//	stereotype='inv' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
	//	ownedSpecification=SpecificationCS ';';
	public InvCSElements getInvCSAccess() {
		return pInvCS;
	}

	public ParserRule getInvCSRule() {
		return getInvCSAccess().getRule();
	}

	//LibCoercionCS:
	//	'coercion' name=Name '(' ')' ':' ownedType=TypedMultiplicityRefCS ('=>'
	//	implementation=[JavaClassCS|SINGLE_QUOTED_STRING])? ('{' (ownedAnnotations+=AnnotationElementCS
	//	| ownedPreconditions+=PostCS
	//	| ownedPostconditions+=PreCS)* '}' | ';');
	public LibCoercionCSElements getLibCoercionCSAccess() {
		return pLibCoercionCS;
	}

	public ParserRule getLibCoercionCSRule() {
		return getLibCoercionCSAccess().getRule();
	}

	//LibIterationCS:
	//	'iteration' name=Name
	//	ownedSignature=TemplateSignatureCS?
	//	'(' ownedIterators+=IteratorCS (',' ownedIterators+=IteratorCS)* (';' ownedAccumulators+=AccumulatorCS (','
	//	ownedAccumulators+=AccumulatorCS)*)? ('|' ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)?
	//	')'
	//	':' ownedType=TypedMultiplicityRefCS
	//	isInvalidating?='invalidating'?
	//	isValidating?='validating'? ('=>' implementation=[JavaClassCS|SINGLE_QUOTED_STRING])? ('{'
	//	(ownedAnnotations+=AnnotationElementCS
	//	| ownedPreconditions+=PostCS
	//	| ownedPostconditions+=PreCS)* '}' | ';');
	public LibIterationCSElements getLibIterationCSAccess() {
		return pLibIterationCS;
	}

	public ParserRule getLibIterationCSRule() {
		return getLibIterationCSAccess().getRule();
	}

	//IteratorCS base::ParameterCS:
	//	name=Identifier ':' ownedType=TypedMultiplicityRefCS;
	public IteratorCSElements getIteratorCSAccess() {
		return pIteratorCS;
	}

	public ParserRule getIteratorCSRule() {
		return getIteratorCSAccess().getRule();
	}

	//LambdaTypeCS base::LambdaTypeCS:
	//	name='Lambda' ownedSignature=TemplateSignatureCS? ownedContextType=LambdaContextTypeRefCS
	//	'(' (ownedParameterTypes+=TypedMultiplicityRefCS (',' ownedParameterTypes+=TypedMultiplicityRefCS)*)? ')'
	//	':' ownedResultType=TypedRefCS;
	public LambdaTypeCSElements getLambdaTypeCSAccess() {
		return pLambdaTypeCS;
	}

	public ParserRule getLambdaTypeCSRule() {
		return getLambdaTypeCSAccess().getRule();
	}

	//LambdaContextTypeRefCS base::TypedTypeRefCS:
	//	ownedPathName=LibPathNameCS;
	public LambdaContextTypeRefCSElements getLambdaContextTypeRefCSAccess() {
		return pLambdaContextTypeRefCS;
	}

	public ParserRule getLambdaContextTypeRefCSRule() {
		return getLambdaContextTypeRefCSAccess().getRule();
	}

	//OperationCS base::OperationCS:
	//	LibCoercionCS | LibIterationCS | LibOperationCS;
	public OperationCSElements getOperationCSAccess() {
		return pOperationCS;
	}

	public ParserRule getOperationCSRule() {
		return getOperationCSAccess().getRule();
	}

	//LibOperationCS:
	//	isStatic?='static'? 'operation' name=Name
	//	ownedSignature=TemplateSignatureCS?
	//	'(' (ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)? ')'
	//	':' ownedType=TypedMultiplicityRefCS
	//	isValidating?='validating'?
	//	isInvalidating?='invalidating'? ('precedence' '=' precedence=[pivot::Precedence|Name])? ('=>'
	//	implementation=[JavaClassCS|SINGLE_QUOTED_STRING])? ('{' (ownedAnnotations+=AnnotationElementCS
	//	| 'body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS ';' | ownedPostconditions+=PostCS
	//	| ownedPreconditions+=PreCS)* '}' | ';');
	public LibOperationCSElements getLibOperationCSAccess() {
		return pLibOperationCS;
	}

	public ParserRule getLibOperationCSRule() {
		return getLibOperationCSAccess().getRule();
	}

	//LibOppositeCS:
	//	'opposite' name=Name ':' ownedType=TypedMultiplicityRefCS;
	public LibOppositeCSElements getLibOppositeCSAccess() {
		return pLibOppositeCS;
	}

	public ParserRule getLibOppositeCSRule() {
		return getLibOppositeCSAccess().getRule();
	}

	//LibPackageCS:
	//	'library' name=Name (':' nsPrefix=Identifier '=' nsURI=URI)?
	//	'{' (ownedPackages+=PackageCS
	//	| 'precedence' ownedPrecedences+=PrecedenceCS+ ';' | ownedClasses+=ClassCS
	//	| ownedAnnotations+=AnnotationElementCS)*
	//	'}';
	public LibPackageCSElements getLibPackageCSAccess() {
		return pLibPackageCS;
	}

	public ParserRule getLibPackageCSRule() {
		return getLibPackageCSAccess().getRule();
	}

	//PackageCS base::PackageCS:
	//	'package' name=Name (':' nsPrefix=Identifier '=' nsURI=URI)?
	//	'{' (ownedPackages+=PackageCS
	//	| ownedClasses+=ClassCS
	//	| ownedAnnotations+=AnnotationElementCS)*
	//	'}';
	public PackageCSElements getPackageCSAccess() {
		return pPackageCS;
	}

	public ParserRule getPackageCSRule() {
		return getPackageCSAccess().getRule();
	}

	//ParameterCS base::ParameterCS:
	//	name=Identifier ':' ownedType=TypedMultiplicityRefCS;
	public ParameterCSElements getParameterCSAccess() {
		return pParameterCS;
	}

	public ParserRule getParameterCSRule() {
		return getParameterCSAccess().getRule();
	}

	//LibPropertyCS:
	//	isStatic?='static'? 'property' name=Name
	//	':' ownedType=TypedMultiplicityRefCS
	//	ownedOpposite=LibOppositeCS? ('=>' implementation=[JavaClassCS|SINGLE_QUOTED_STRING])? ('{'
	//	ownedAnnotations+=AnnotationElementCS* '}' | ';');
	public LibPropertyCSElements getLibPropertyCSAccess() {
		return pLibPropertyCS;
	}

	public ParserRule getLibPropertyCSRule() {
		return getLibPropertyCSAccess().getRule();
	}

	//PostCS LibConstraintCS:
	//	stereotype='post' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
	//	ownedSpecification=SpecificationCS ';';
	public PostCSElements getPostCSAccess() {
		return pPostCS;
	}

	public ParserRule getPostCSRule() {
		return getPostCSAccess().getRule();
	}

	//PreCS LibConstraintCS:
	//	stereotype='pre' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
	//	ownedSpecification=SpecificationCS ';';
	public PreCSElements getPreCSAccess() {
		return pPreCS;
	}

	public ParserRule getPreCSRule() {
		return getPreCSAccess().getRule();
	}

	//PrecedenceCS:
	//	('left' | isRightAssociative?='right') ':' name=Name;
	public PrecedenceCSElements getPrecedenceCSAccess() {
		return pPrecedenceCS;
	}

	public ParserRule getPrecedenceCSRule() {
		return getPrecedenceCSAccess().getRule();
	}

	//SpecificationCS essentialocl::ExpSpecificationCS:
	//	ownedExpression=ExpCS;
	public SpecificationCSElements getSpecificationCSAccess() {
		return pSpecificationCS;
	}

	public ParserRule getSpecificationCSRule() {
		return getSpecificationCSAccess().getRule();
	}

	//TypedMultiplicityRefCS base::TypedRefCS:
	//	(MapTypeCS | TupleTypeCS | TypedTypeRefCS | LambdaTypeCS) ownedMultiplicity=MultiplicityCS?;
	public TypedMultiplicityRefCSElements getTypedMultiplicityRefCSAccess() {
		return pTypedMultiplicityRefCS;
	}

	public ParserRule getTypedMultiplicityRefCSRule() {
		return getTypedMultiplicityRefCSAccess().getRule();
	}

	//@Override
	//TypedRefCS base::TypedRefCS:
	//	MapTypeCS | TupleTypeCS | TypedTypeRefCS | LambdaTypeCS;
	public TypedRefCSElements getTypedRefCSAccess() {
		return pTypedRefCS;
	}

	public ParserRule getTypedRefCSRule() {
		return getTypedRefCSAccess().getRule();
	}

	//@Override
	//TypedTypeRefCS base::TypedTypeRefCS:
	//	isTypeof?='typeof' '(' ownedPathName=LibPathNameCS ')' | ownedPathName=LibPathNameCS ('('
	//	ownedBinding=TemplateBindingCS ')')?;
	public TypedTypeRefCSElements getTypedTypeRefCSAccess() {
		return pTypedTypeRefCS;
	}

	public ParserRule getTypedTypeRefCSRule() {
		return getTypedTypeRefCSAccess().getRule();
	}

	//@Override
	//TuplePartCS base::TuplePartCS:
	//	name=Identifier ':' ownedType=TypedMultiplicityRefCS;
	public TuplePartCSElements getTuplePartCSAccess() {
		return pTuplePartCS;
	}

	public ParserRule getTuplePartCSRule() {
		return getTuplePartCSAccess().getRule();
	}

	////generate essentialOCLCST "http://www.eclipse.org/ocl/3.0.0/EssentialOCLCST"
	//Model ContextCS:
	//	ownedExpression=ExpCS;
	public EssentialOCLGrammarAccess.ModelElements getModelAccess() {
		return gaEssentialOCL.getModelAccess();
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
	public EssentialOCLGrammarAccess.EssentialOCLReservedKeywordElements getEssentialOCLReservedKeywordAccess() {
		return gaEssentialOCL.getEssentialOCLReservedKeywordAccess();
	}

	public ParserRule getEssentialOCLReservedKeywordRule() {
		return getEssentialOCLReservedKeywordAccess().getRule();
	}

	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLUnaryOperatorName:
	//	'-' | 'not' | 'not2';
	public EssentialOCLGrammarAccess.EssentialOCLUnaryOperatorNameElements getEssentialOCLUnaryOperatorNameAccess() {
		return gaEssentialOCL.getEssentialOCLUnaryOperatorNameAccess();
	}

	public ParserRule getEssentialOCLUnaryOperatorNameRule() {
		return getEssentialOCLUnaryOperatorNameAccess().getRule();
	}

	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLInfixOperatorName:
	//	'*' | '/' | '+' | '-' | '>' | '<' | '>=' | '<=' | '=' | '<>' | 'and' | 'and2' | 'implies' | 'implies2' | 'or' |
	//	'or2' | 'xor' | 'xor2';
	public EssentialOCLGrammarAccess.EssentialOCLInfixOperatorNameElements getEssentialOCLInfixOperatorNameAccess() {
		return gaEssentialOCL.getEssentialOCLInfixOperatorNameAccess();
	}

	public ParserRule getEssentialOCLInfixOperatorNameRule() {
		return getEssentialOCLInfixOperatorNameAccess().getRule();
	}

	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLNavigationOperatorName:
	//	'.' | '->' | '?.' | '?->';
	public EssentialOCLGrammarAccess.EssentialOCLNavigationOperatorNameElements getEssentialOCLNavigationOperatorNameAccess() {
		return gaEssentialOCL.getEssentialOCLNavigationOperatorNameAccess();
	}

	public ParserRule getEssentialOCLNavigationOperatorNameRule() {
		return getEssentialOCLNavigationOperatorNameAccess().getRule();
	}

	//BinaryOperatorName:
	//	InfixOperatorName | NavigationOperatorName;
	public EssentialOCLGrammarAccess.BinaryOperatorNameElements getBinaryOperatorNameAccess() {
		return gaEssentialOCL.getBinaryOperatorNameAccess();
	}

	public ParserRule getBinaryOperatorNameRule() {
		return getBinaryOperatorNameAccess().getRule();
	}

	//InfixOperatorName:
	//	EssentialOCLInfixOperatorName;
	public EssentialOCLGrammarAccess.InfixOperatorNameElements getInfixOperatorNameAccess() {
		return gaEssentialOCL.getInfixOperatorNameAccess();
	}

	public ParserRule getInfixOperatorNameRule() {
		return getInfixOperatorNameAccess().getRule();
	}

	//NavigationOperatorName:
	//	EssentialOCLNavigationOperatorName;
	public EssentialOCLGrammarAccess.NavigationOperatorNameElements getNavigationOperatorNameAccess() {
		return gaEssentialOCL.getNavigationOperatorNameAccess();
	}

	public ParserRule getNavigationOperatorNameRule() {
		return getNavigationOperatorNameAccess().getRule();
	}

	//UnaryOperatorName:
	//	EssentialOCLUnaryOperatorName;
	public EssentialOCLGrammarAccess.UnaryOperatorNameElements getUnaryOperatorNameAccess() {
		return gaEssentialOCL.getUnaryOperatorNameAccess();
	}

	public ParserRule getUnaryOperatorNameRule() {
		return getUnaryOperatorNameAccess().getRule();
	}

	////---------------------------------------------------------------------
	////  Names
	////---------------------------------------------------------------------
	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLUnrestrictedName:
	//	super::Identifier;
	public EssentialOCLGrammarAccess.EssentialOCLUnrestrictedNameElements getEssentialOCLUnrestrictedNameAccess() {
		return gaEssentialOCL.getEssentialOCLUnrestrictedNameAccess();
	}

	public ParserRule getEssentialOCLUnrestrictedNameRule() {
		return getEssentialOCLUnrestrictedNameAccess().getRule();
	}

	//@Override
	//UnrestrictedName:
	//	EssentialOCLUnrestrictedName;
	public EssentialOCLGrammarAccess.UnrestrictedNameElements getUnrestrictedNameAccess() {
		return gaEssentialOCL.getUnrestrictedNameAccess();
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
	public EssentialOCLGrammarAccess.EssentialOCLUnreservedNameElements getEssentialOCLUnreservedNameAccess() {
		return gaEssentialOCL.getEssentialOCLUnreservedNameAccess();
	}

	public ParserRule getEssentialOCLUnreservedNameRule() {
		return getEssentialOCLUnreservedNameAccess().getRule();
	}

	//@Override
	//UnreservedName:
	//	EssentialOCLUnreservedName;
	public EssentialOCLGrammarAccess.UnreservedNameElements getUnreservedNameAccess() {
		return gaEssentialOCL.getUnreservedNameAccess();
	}

	public ParserRule getUnreservedNameRule() {
		return getUnreservedNameAccess().getRule();
	}

	//URIPathNameCS base::PathNameCS:
	//	ownedPathElements+=URIFirstPathElementCS ('::' ownedPathElements+=NextPathElementCS)*;
	public EssentialOCLGrammarAccess.URIPathNameCSElements getURIPathNameCSAccess() {
		return gaEssentialOCL.getURIPathNameCSAccess();
	}

	public ParserRule getURIPathNameCSRule() {
		return getURIPathNameCSAccess().getRule();
	}

	//URIFirstPathElementCS base::PathElementCS:
	//	referredElement=[pivot::NamedElement|UnrestrictedName] | {base::PathElementWithURICS}
	//	referredElement=[pivot::Namespace|URI];
	public EssentialOCLGrammarAccess.URIFirstPathElementCSElements getURIFirstPathElementCSAccess() {
		return gaEssentialOCL.getURIFirstPathElementCSAccess();
	}

	public ParserRule getURIFirstPathElementCSRule() {
		return getURIFirstPathElementCSAccess().getRule();
	}

	//SimplePathNameCS base::PathNameCS:
	//	ownedPathElements+=FirstPathElementCS;
	public EssentialOCLGrammarAccess.SimplePathNameCSElements getSimplePathNameCSAccess() {
		return gaEssentialOCL.getSimplePathNameCSAccess();
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
	public EssentialOCLGrammarAccess.PrimitiveTypeIdentifierElements getPrimitiveTypeIdentifierAccess() {
		return gaEssentialOCL.getPrimitiveTypeIdentifierAccess();
	}

	public ParserRule getPrimitiveTypeIdentifierRule() {
		return getPrimitiveTypeIdentifierAccess().getRule();
	}

	//PrimitiveTypeCS base::PrimitiveTypeRefCS:
	//	name=PrimitiveTypeIdentifier;
	public EssentialOCLGrammarAccess.PrimitiveTypeCSElements getPrimitiveTypeCSAccess() {
		return gaEssentialOCL.getPrimitiveTypeCSAccess();
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
	public EssentialOCLGrammarAccess.CollectionTypeIdentifierElements getCollectionTypeIdentifierAccess() {
		return gaEssentialOCL.getCollectionTypeIdentifierAccess();
	}

	public ParserRule getCollectionTypeIdentifierRule() {
		return getCollectionTypeIdentifierAccess().getRule();
	}

	//CollectionTypeCS:
	//	name=CollectionTypeIdentifier ('(' ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS
	//	? ')')?;
	public EssentialOCLGrammarAccess.CollectionTypeCSElements getCollectionTypeCSAccess() {
		return gaEssentialOCL.getCollectionTypeCSAccess();
	}

	public ParserRule getCollectionTypeCSRule() {
		return getCollectionTypeCSAccess().getRule();
	}

	//MapTypeCS:
	//	name='Map' ('(' ownedKeyType=TypeExpCS ',' ownedValueType=TypeExpCS ')')?;
	public EssentialOCLGrammarAccess.MapTypeCSElements getMapTypeCSAccess() {
		return gaEssentialOCL.getMapTypeCSAccess();
	}

	public ParserRule getMapTypeCSRule() {
		return getMapTypeCSAccess().getRule();
	}

	//TupleTypeCS base::TupleTypeCS:
	//	name='Tuple' ('(' (ownedParts+=super::TuplePartCS (',' ownedParts+=super::TuplePartCS)*)? ')')?;
	public EssentialOCLGrammarAccess.TupleTypeCSElements getTupleTypeCSAccess() {
		return gaEssentialOCL.getTupleTypeCSAccess();
	}

	public ParserRule getTupleTypeCSRule() {
		return getTupleTypeCSAccess().getRule();
	}

	////---------------------------------------------------------------------
	////  Literals
	////---------------------------------------------------------------------
	//CollectionLiteralExpCS:
	//	ownedType=CollectionTypeCS
	//	'{' (ownedParts+=CollectionLiteralPartCS (',' ownedParts+=CollectionLiteralPartCS)*)?
	//	'}';
	public EssentialOCLGrammarAccess.CollectionLiteralExpCSElements getCollectionLiteralExpCSAccess() {
		return gaEssentialOCL.getCollectionLiteralExpCSAccess();
	}

	public ParserRule getCollectionLiteralExpCSRule() {
		return getCollectionLiteralExpCSAccess().getRule();
	}

	//CollectionLiteralPartCS:
	//	ownedExpression=ExpCS ('..' ownedLastExpression=ExpCS)? | ownedExpression=PatternExpCS;
	public EssentialOCLGrammarAccess.CollectionLiteralPartCSElements getCollectionLiteralPartCSAccess() {
		return gaEssentialOCL.getCollectionLiteralPartCSAccess();
	}

	public ParserRule getCollectionLiteralPartCSRule() {
		return getCollectionLiteralPartCSAccess().getRule();
	}

	//CollectionPatternCS:
	//	ownedType=CollectionTypeCS
	//	'{' (ownedParts+=PatternExpCS (',' ownedParts+=PatternExpCS)* ('++' restVariableName=super::Identifier))?
	//	'}';
	public EssentialOCLGrammarAccess.CollectionPatternCSElements getCollectionPatternCSAccess() {
		return gaEssentialOCL.getCollectionPatternCSAccess();
	}

	public ParserRule getCollectionPatternCSRule() {
		return getCollectionPatternCSAccess().getRule();
	}

	//ShadowPartCS:
	//	referredProperty=[pivot::Property|UnrestrictedName] '=' ownedInitExpression=(ExpCS | PatternExpCS) |
	//	ownedInitExpression=StringLiteralExpCS;
	public EssentialOCLGrammarAccess.ShadowPartCSElements getShadowPartCSAccess() {
		return gaEssentialOCL.getShadowPartCSAccess();
	}

	public ParserRule getShadowPartCSRule() {
		return getShadowPartCSAccess().getRule();
	}

	//PatternExpCS:
	//	patternVariableName=UnrestrictedName? ':' ownedPatternType=TypeExpCS;
	public EssentialOCLGrammarAccess.PatternExpCSElements getPatternExpCSAccess() {
		return gaEssentialOCL.getPatternExpCSAccess();
	}

	public ParserRule getPatternExpCSRule() {
		return getPatternExpCSAccess().getRule();
	}

	//LambdaLiteralExpCS:
	//	'Lambda' '{' ownedExpressionCS=ExpCS '}';
	public EssentialOCLGrammarAccess.LambdaLiteralExpCSElements getLambdaLiteralExpCSAccess() {
		return gaEssentialOCL.getLambdaLiteralExpCSAccess();
	}

	public ParserRule getLambdaLiteralExpCSRule() {
		return getLambdaLiteralExpCSAccess().getRule();
	}

	//MapLiteralExpCS:
	//	ownedType=MapTypeCS '{' (ownedParts+=MapLiteralPartCS (',' ownedParts+=MapLiteralPartCS)*)? '}';
	public EssentialOCLGrammarAccess.MapLiteralExpCSElements getMapLiteralExpCSAccess() {
		return gaEssentialOCL.getMapLiteralExpCSAccess();
	}

	public ParserRule getMapLiteralExpCSRule() {
		return getMapLiteralExpCSAccess().getRule();
	}

	//MapLiteralPartCS:
	//	ownedKey=ExpCS ('with' | '<-') ownedValue=ExpCS;
	public EssentialOCLGrammarAccess.MapLiteralPartCSElements getMapLiteralPartCSAccess() {
		return gaEssentialOCL.getMapLiteralPartCSAccess();
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
	public EssentialOCLGrammarAccess.PrimitiveLiteralExpCSElements getPrimitiveLiteralExpCSAccess() {
		return gaEssentialOCL.getPrimitiveLiteralExpCSAccess();
	}

	public ParserRule getPrimitiveLiteralExpCSRule() {
		return getPrimitiveLiteralExpCSAccess().getRule();
	}

	//TupleLiteralExpCS:
	//	'Tuple' '{' ownedParts+=TupleLiteralPartCS (',' ownedParts+=TupleLiteralPartCS)* '}';
	public EssentialOCLGrammarAccess.TupleLiteralExpCSElements getTupleLiteralExpCSAccess() {
		return gaEssentialOCL.getTupleLiteralExpCSAccess();
	}

	public ParserRule getTupleLiteralExpCSRule() {
		return getTupleLiteralExpCSAccess().getRule();
	}

	//TupleLiteralPartCS:
	//	name=UnrestrictedName (':' ownedType=TypeExpCS)? '=' ownedInitExpression=ExpCS;
	public EssentialOCLGrammarAccess.TupleLiteralPartCSElements getTupleLiteralPartCSAccess() {
		return gaEssentialOCL.getTupleLiteralPartCSAccess();
	}

	public ParserRule getTupleLiteralPartCSRule() {
		return getTupleLiteralPartCSAccess().getRule();
	}

	//NumberLiteralExpCS:
	//	symbol=NUMBER_LITERAL;
	public EssentialOCLGrammarAccess.NumberLiteralExpCSElements getNumberLiteralExpCSAccess() {
		return gaEssentialOCL.getNumberLiteralExpCSAccess();
	}

	public ParserRule getNumberLiteralExpCSRule() {
		return getNumberLiteralExpCSAccess().getRule();
	}

	//StringLiteralExpCS:
	//	segments+=StringLiteral+;
	public EssentialOCLGrammarAccess.StringLiteralExpCSElements getStringLiteralExpCSAccess() {
		return gaEssentialOCL.getStringLiteralExpCSAccess();
	}

	public ParserRule getStringLiteralExpCSRule() {
		return getStringLiteralExpCSAccess().getRule();
	}

	//BooleanLiteralExpCS:
	//	symbol='true'
	//	| symbol='false';
	public EssentialOCLGrammarAccess.BooleanLiteralExpCSElements getBooleanLiteralExpCSAccess() {
		return gaEssentialOCL.getBooleanLiteralExpCSAccess();
	}

	public ParserRule getBooleanLiteralExpCSRule() {
		return getBooleanLiteralExpCSAccess().getRule();
	}

	//UnlimitedNaturalLiteralExpCS:
	//	{UnlimitedNaturalLiteralExpCS} '*';
	public EssentialOCLGrammarAccess.UnlimitedNaturalLiteralExpCSElements getUnlimitedNaturalLiteralExpCSAccess() {
		return gaEssentialOCL.getUnlimitedNaturalLiteralExpCSAccess();
	}

	public ParserRule getUnlimitedNaturalLiteralExpCSRule() {
		return getUnlimitedNaturalLiteralExpCSAccess().getRule();
	}

	//InvalidLiteralExpCS:
	//	{InvalidLiteralExpCS} 'invalid';
	public EssentialOCLGrammarAccess.InvalidLiteralExpCSElements getInvalidLiteralExpCSAccess() {
		return gaEssentialOCL.getInvalidLiteralExpCSAccess();
	}

	public ParserRule getInvalidLiteralExpCSRule() {
		return getInvalidLiteralExpCSAccess().getRule();
	}

	//NullLiteralExpCS:
	//	{NullLiteralExpCS} 'null';
	public EssentialOCLGrammarAccess.NullLiteralExpCSElements getNullLiteralExpCSAccess() {
		return gaEssentialOCL.getNullLiteralExpCSAccess();
	}

	public ParserRule getNullLiteralExpCSRule() {
		return getNullLiteralExpCSAccess().getRule();
	}

	//TypeLiteralCS base::TypedRefCS:
	//	PrimitiveTypeCS
	//	| CollectionTypeCS
	//	| MapTypeCS
	//	| TupleTypeCS;
	public EssentialOCLGrammarAccess.TypeLiteralCSElements getTypeLiteralCSAccess() {
		return gaEssentialOCL.getTypeLiteralCSAccess();
	}

	public ParserRule getTypeLiteralCSRule() {
		return getTypeLiteralCSAccess().getRule();
	}

	//TypeLiteralWithMultiplicityCS base::TypedRefCS:
	//	TypeLiteralCS ownedMultiplicity=MultiplicityCS?;
	public EssentialOCLGrammarAccess.TypeLiteralWithMultiplicityCSElements getTypeLiteralWithMultiplicityCSAccess() {
		return gaEssentialOCL.getTypeLiteralWithMultiplicityCSAccess();
	}

	public ParserRule getTypeLiteralWithMultiplicityCSRule() {
		return getTypeLiteralWithMultiplicityCSAccess().getRule();
	}

	//TypeLiteralExpCS:
	//	ownedType=TypeLiteralWithMultiplicityCS;
	public EssentialOCLGrammarAccess.TypeLiteralExpCSElements getTypeLiteralExpCSAccess() {
		return gaEssentialOCL.getTypeLiteralExpCSAccess();
	}

	public ParserRule getTypeLiteralExpCSRule() {
		return getTypeLiteralExpCSAccess().getRule();
	}

	//TypeNameExpCS:
	//	ownedPathName=PathNameCS (ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' ownedPatternGuard=ExpCS '}')?)?;
	public EssentialOCLGrammarAccess.TypeNameExpCSElements getTypeNameExpCSAccess() {
		return gaEssentialOCL.getTypeNameExpCSAccess();
	}

	public ParserRule getTypeNameExpCSRule() {
		return getTypeNameExpCSAccess().getRule();
	}

	//TypeExpWithoutMultiplicityCS base::TypedRefCS:
	//	TypeNameExpCS | TypeLiteralCS | CollectionPatternCS;
	public EssentialOCLGrammarAccess.TypeExpWithoutMultiplicityCSElements getTypeExpWithoutMultiplicityCSAccess() {
		return gaEssentialOCL.getTypeExpWithoutMultiplicityCSAccess();
	}

	public ParserRule getTypeExpWithoutMultiplicityCSRule() {
		return getTypeExpWithoutMultiplicityCSAccess().getRule();
	}

	//TypeExpCS base::TypedRefCS:
	//	TypeExpWithoutMultiplicityCS ownedMultiplicity=MultiplicityCS?;
	public EssentialOCLGrammarAccess.TypeExpCSElements getTypeExpCSAccess() {
		return gaEssentialOCL.getTypeExpCSAccess();
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
	public EssentialOCLGrammarAccess.ExpCSElements getExpCSAccess() {
		return gaEssentialOCL.getExpCSAccess();
	}

	public ParserRule getExpCSRule() {
		return getExpCSAccess().getRule();
	}

	///* A prefixed let expression elaborates a let expression with zero or more unary prefix operators. */
	//PrefixedLetExpCS ExpCS:
	//	{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedLetExpCS | LetExpCS;
	public EssentialOCLGrammarAccess.PrefixedLetExpCSElements getPrefixedLetExpCSAccess() {
		return gaEssentialOCL.getPrefixedLetExpCSAccess();
	}

	public ParserRule getPrefixedLetExpCSRule() {
		return getPrefixedLetExpCSAccess().getRule();
	}

	///* A prefixed primary expression elaborates a primary expression with zero or more unary prefix operators. */
	//PrefixedPrimaryExpCS ExpCS:
	//	{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS | PrimaryExpCS;
	public EssentialOCLGrammarAccess.PrefixedPrimaryExpCSElements getPrefixedPrimaryExpCSAccess() {
		return gaEssentialOCL.getPrefixedPrimaryExpCSAccess();
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
	public EssentialOCLGrammarAccess.PrimaryExpCSElements getPrimaryExpCSAccess() {
		return gaEssentialOCL.getPrimaryExpCSAccess();
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
	public EssentialOCLGrammarAccess.NameExpCSElements getNameExpCSAccess() {
		return gaEssentialOCL.getNameExpCSAccess();
	}

	public ParserRule getNameExpCSRule() {
		return getNameExpCSAccess().getRule();
	}

	///* A curly bracket clause is a generalized rule for the literal arguments of collections, maps, tuples and shadows.*/
	//CurlyBracketedClauseCS:
	//	{CurlyBracketedClauseCS} '{' (ownedParts+=ShadowPartCS (',' ownedParts+=ShadowPartCS)*)? '}';
	public EssentialOCLGrammarAccess.CurlyBracketedClauseCSElements getCurlyBracketedClauseCSAccess() {
		return gaEssentialOCL.getCurlyBracketedClauseCSAccess();
	}

	public ParserRule getCurlyBracketedClauseCSRule() {
		return getCurlyBracketedClauseCSAccess().getRule();
	}

	///* A curly bracket clause is a generalized rule for template specialisations and operations arguments.*/
	//RoundBracketedClauseCS:
	//	{RoundBracketedClauseCS} '(' (ownedArguments+=NavigatingArgCS ownedArguments+=(NavigatingCommaArgCS |
	//	NavigatingSemiArgCS | NavigatingBarArgCS)*)? ')';
	public EssentialOCLGrammarAccess.RoundBracketedClauseCSElements getRoundBracketedClauseCSAccess() {
		return gaEssentialOCL.getRoundBracketedClauseCSAccess();
	}

	public ParserRule getRoundBracketedClauseCSRule() {
		return getRoundBracketedClauseCSAccess().getRule();
	}

	///* A square bracket clause is a generalized rule for association class qualifiers and roles.*/
	//SquareBracketedClauseCS:
	//	'[' ownedTerms+=ExpCS (',' ownedTerms+=ExpCS)* ']';
	public EssentialOCLGrammarAccess.SquareBracketedClauseCSElements getSquareBracketedClauseCSAccess() {
		return gaEssentialOCL.getSquareBracketedClauseCSAccess();
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
	public EssentialOCLGrammarAccess.NavigatingArgCSElements getNavigatingArgCSAccess() {
		return gaEssentialOCL.getNavigatingArgCSAccess();
	}

	public ParserRule getNavigatingArgCSRule() {
		return getNavigatingArgCSAccess().getRule();
	}

	//// Type-less init is an illegal infix expression
	//
	///* A navigating bar argument is a generalized rule for a bar-prefixed argument in a round bracket clause. This is typically the body of an iteration. */
	//NavigatingBarArgCS NavigatingArgCS:
	//	prefix='|' ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?;
	public EssentialOCLGrammarAccess.NavigatingBarArgCSElements getNavigatingBarArgCSAccess() {
		return gaEssentialOCL.getNavigatingBarArgCSAccess();
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
	public EssentialOCLGrammarAccess.NavigatingCommaArgCSElements getNavigatingCommaArgCSAccess() {
		return gaEssentialOCL.getNavigatingCommaArgCSAccess();
	}

	public ParserRule getNavigatingCommaArgCSRule() {
		return getNavigatingCommaArgCSAccess().getRule();
	}

	//// Type-less init is an illegal infix expression
	//
	///* A navigating semi argument is a generalized rule for a semicolon prefixed argument in a round bracket clause. This is typically an iterate accumulator. */
	//NavigatingSemiArgCS NavigatingArgCS:
	//	prefix=';' ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?;
	public EssentialOCLGrammarAccess.NavigatingSemiArgCSElements getNavigatingSemiArgCSAccess() {
		return gaEssentialOCL.getNavigatingSemiArgCSAccess();
	}

	public ParserRule getNavigatingSemiArgCSRule() {
		return getNavigatingSemiArgCSAccess().getRule();
	}

	//// Type-less init is an illegal infix expression
	//
	//NavigatingArgExpCS ExpCS:
	//	ExpCS// '?'	-- defined by Complete OCL
	//;
	public EssentialOCLGrammarAccess.NavigatingArgExpCSElements getNavigatingArgExpCSAccess() {
		return gaEssentialOCL.getNavigatingArgExpCSAccess();
	}

	public ParserRule getNavigatingArgExpCSRule() {
		return getNavigatingArgExpCSAccess().getRule();
	}

	//CoIteratorVariableCS VariableCS:
	//	name=UnrestrictedName (':' ownedType=TypeExpCS)?;
	public EssentialOCLGrammarAccess.CoIteratorVariableCSElements getCoIteratorVariableCSAccess() {
		return gaEssentialOCL.getCoIteratorVariableCSAccess();
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
	public EssentialOCLGrammarAccess.IfExpCSElements getIfExpCSAccess() {
		return gaEssentialOCL.getIfExpCSAccess();
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
	public EssentialOCLGrammarAccess.ElseIfThenExpCSElements getElseIfThenExpCSAccess() {
		return gaEssentialOCL.getElseIfThenExpCSAccess();
	}

	public ParserRule getElseIfThenExpCSRule() {
		return getElseIfThenExpCSAccess().getRule();
	}

	//LetExpCS:
	//	'let' ownedVariables+=LetVariableCS (',' ownedVariables+=LetVariableCS)*
	//	'in' ownedInExpression=ExpCS;
	public EssentialOCLGrammarAccess.LetExpCSElements getLetExpCSAccess() {
		return gaEssentialOCL.getLetExpCSAccess();
	}

	public ParserRule getLetExpCSRule() {
		return getLetExpCSAccess().getRule();
	}

	//LetVariableCS:
	//	name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS? (':' ownedType=TypeExpCS)? '='
	//	ownedInitExpression=ExpCS;
	public EssentialOCLGrammarAccess.LetVariableCSElements getLetVariableCSAccess() {
		return gaEssentialOCL.getLetVariableCSAccess();
	}

	public ParserRule getLetVariableCSRule() {
		return getLetVariableCSAccess().getRule();
	}

	//NestedExpCS:
	//	'(' ownedExpression=ExpCS ')';
	public EssentialOCLGrammarAccess.NestedExpCSElements getNestedExpCSAccess() {
		return gaEssentialOCL.getNestedExpCSAccess();
	}

	public ParserRule getNestedExpCSRule() {
		return getNestedExpCSAccess().getRule();
	}

	//SelfExpCS:
	//	{SelfExpCS} 'self';
	public EssentialOCLGrammarAccess.SelfExpCSElements getSelfExpCSAccess() {
		return gaEssentialOCL.getSelfExpCSAccess();
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
	//	name=super::UnrestrictedName ('extends' ownedExtends+=super::TypedRefCS ('&&' ownedExtends+=super::TypedRefCS)*)?;
	public BaseGrammarAccess.TypeParameterCSElements getTypeParameterCSAccess() {
		return gaBase.getTypeParameterCSAccess();
	}

	public ParserRule getTypeParameterCSRule() {
		return getTypeParameterCSAccess().getRule();
	}

	//TypeRefCS:
	//	super::TypedRefCS | WildcardTypeRefCS;
	public BaseGrammarAccess.TypeRefCSElements getTypeRefCSAccess() {
		return gaBase.getTypeRefCSAccess();
	}

	public ParserRule getTypeRefCSRule() {
		return getTypeRefCSAccess().getRule();
	}

	//WildcardTypeRefCS:
	//	{WildcardTypeRefCS} '?' ('extends' ownedExtends=super::TypedRefCS)?;
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
