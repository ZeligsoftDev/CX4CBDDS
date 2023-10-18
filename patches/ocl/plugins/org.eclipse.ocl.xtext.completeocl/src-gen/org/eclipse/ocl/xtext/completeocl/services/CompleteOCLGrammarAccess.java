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
package org.eclipse.ocl.xtext.completeocl.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;

@Singleton
public class CompleteOCLGrammarAccess extends AbstractGrammarElementFinder {


	public class CompleteOCLDocumentCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.CompleteOCLDocumentCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedImportsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedImportsImportCSParserRuleCall_0_0 = (RuleCall)cOwnedImportsAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cOwnedPackagesAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cOwnedPackagesPackageDeclarationCSParserRuleCall_1_0_0 = (RuleCall)cOwnedPackagesAssignment_1_0.eContents().get(0);
		private final Assignment cOwnedContextsAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cOwnedContextsContextDeclCSParserRuleCall_1_1_0 = (RuleCall)cOwnedContextsAssignment_1_1.eContents().get(0);

		///*
		// * A Complete OCL document comprises
		// * bullet[model imports for referenced and complemented models]
		// * bullet[includes for additional Complete OCL documents]
		// * bullet[libraries to augment or override the OCL Standard Library]
		// * bullet[package declarations for package-grouped declarations]
		// * bullet[context declarations for independent declarations]
		// */
		//CompleteOCLDocumentCS:
		//	ownedImports+=ImportCS* (ownedPackages+=PackageDeclarationCS | ownedContexts+=ContextDeclCS)*;
		@Override public ParserRule getRule() { return rule; }

		//ownedImports+=ImportCS* (ownedPackages+=PackageDeclarationCS | ownedContexts+=ContextDeclCS)*
		public Group getGroup() { return cGroup; }

		//ownedImports+=ImportCS*
		public Assignment getOwnedImportsAssignment_0() { return cOwnedImportsAssignment_0; }

		//ImportCS
		public RuleCall getOwnedImportsImportCSParserRuleCall_0_0() { return cOwnedImportsImportCSParserRuleCall_0_0; }

		//(ownedPackages+=PackageDeclarationCS | ownedContexts+=ContextDeclCS)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//ownedPackages+=PackageDeclarationCS
		public Assignment getOwnedPackagesAssignment_1_0() { return cOwnedPackagesAssignment_1_0; }

		//PackageDeclarationCS
		public RuleCall getOwnedPackagesPackageDeclarationCSParserRuleCall_1_0_0() { return cOwnedPackagesPackageDeclarationCSParserRuleCall_1_0_0; }

		//ownedContexts+=ContextDeclCS
		public Assignment getOwnedContextsAssignment_1_1() { return cOwnedContextsAssignment_1_1; }

		//ContextDeclCS
		public RuleCall getOwnedContextsContextDeclCSParserRuleCall_1_1_0() { return cOwnedContextsContextDeclCSParserRuleCall_1_1_0; }
	}

	public class CompleteOCLNavigationOperatorNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.CompleteOCLNavigationOperatorName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cCircumflexAccentKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cCircumflexAccentCircumflexAccentKeyword_1 = (Keyword)cAlternatives.eContents().get(1);

		//CompleteOCLNavigationOperatorName:
		//	'^' | '^^';
		@Override public ParserRule getRule() { return rule; }

		//'^' | '^^'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'^'
		public Keyword getCircumflexAccentKeyword_0() { return cCircumflexAccentKeyword_0; }

		//'^^'
		public Keyword getCircumflexAccentCircumflexAccentKeyword_1() { return cCircumflexAccentCircumflexAccentKeyword_1; }
	}

	public class ClassifierContextDeclCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.ClassifierContextDeclCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cContextKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedSignatureAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_1_0 = (RuleCall)cOwnedSignatureAssignment_1.eContents().get(0);
		private final Assignment cSelfNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cSelfNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cSelfNameAssignment_2.eContents().get(0);
		private final Assignment cOwnedPathNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedPathNameUnreservedPathNameCSParserRuleCall_3_0 = (RuleCall)cOwnedPathNameAssignment_3.eContents().get(0);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Group cGroup_4_0 = (Group)cAlternatives_4.eContents().get(0);
		private final Keyword cInvKeyword_4_0_0 = (Keyword)cGroup_4_0.eContents().get(0);
		private final Assignment cOwnedInvariantsAssignment_4_0_1 = (Assignment)cGroup_4_0.eContents().get(1);
		private final RuleCall cOwnedInvariantsConstraintCSParserRuleCall_4_0_1_0 = (RuleCall)cOwnedInvariantsAssignment_4_0_1.eContents().get(0);
		private final Assignment cOwnedDefinitionsAssignment_4_1 = (Assignment)cAlternatives_4.eContents().get(1);
		private final RuleCall cOwnedDefinitionsDefCSParserRuleCall_4_1_0 = (RuleCall)cOwnedDefinitionsAssignment_4_1.eContents().get(0);

		//ClassifierContextDeclCS:
		//	'context' ownedSignature=TemplateSignatureCS? selfName=UnrestrictedName?
		//	ownedPathName=UnreservedPathNameCS ('inv' ownedInvariants+=ConstraintCS | ownedDefinitions+=DefCS)+;
		@Override public ParserRule getRule() { return rule; }

		//'context' ownedSignature=TemplateSignatureCS? selfName=UnrestrictedName?
		//ownedPathName=UnreservedPathNameCS ('inv' ownedInvariants+=ConstraintCS | ownedDefinitions+=DefCS)+
		public Group getGroup() { return cGroup; }

		//'context'
		public Keyword getContextKeyword_0() { return cContextKeyword_0; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_1() { return cOwnedSignatureAssignment_1; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_1_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_1_0; }

		//selfName=UnrestrictedName?
		public Assignment getSelfNameAssignment_2() { return cSelfNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getSelfNameUnrestrictedNameParserRuleCall_2_0() { return cSelfNameUnrestrictedNameParserRuleCall_2_0; }

		//ownedPathName=UnreservedPathNameCS
		public Assignment getOwnedPathNameAssignment_3() { return cOwnedPathNameAssignment_3; }

		//UnreservedPathNameCS
		public RuleCall getOwnedPathNameUnreservedPathNameCSParserRuleCall_3_0() { return cOwnedPathNameUnreservedPathNameCSParserRuleCall_3_0; }

		//('inv' ownedInvariants+=ConstraintCS | ownedDefinitions+=DefCS)+
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//'inv' ownedInvariants+=ConstraintCS
		public Group getGroup_4_0() { return cGroup_4_0; }

		//'inv'
		public Keyword getInvKeyword_4_0_0() { return cInvKeyword_4_0_0; }

		//ownedInvariants+=ConstraintCS
		public Assignment getOwnedInvariantsAssignment_4_0_1() { return cOwnedInvariantsAssignment_4_0_1; }

		//ConstraintCS
		public RuleCall getOwnedInvariantsConstraintCSParserRuleCall_4_0_1_0() { return cOwnedInvariantsConstraintCSParserRuleCall_4_0_1_0; }

		//ownedDefinitions+=DefCS
		public Assignment getOwnedDefinitionsAssignment_4_1() { return cOwnedDefinitionsAssignment_4_1; }

		//DefCS
		public RuleCall getOwnedDefinitionsDefCSParserRuleCall_4_1_0() { return cOwnedDefinitionsDefCSParserRuleCall_4_1_0; }
	}

	public class ConstraintCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.ConstraintCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0_0 = (RuleCall)cNameAssignment_0_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0_1_0 = (Keyword)cGroup_0_1.eContents().get(0);
		private final Assignment cOwnedMessageSpecificationAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final RuleCall cOwnedMessageSpecificationSpecificationCSParserRuleCall_0_1_1_0 = (RuleCall)cOwnedMessageSpecificationAssignment_0_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_0_1_2 = (Keyword)cGroup_0_1.eContents().get(2);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedSpecificationAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedSpecificationSpecificationCSParserRuleCall_2_0 = (RuleCall)cOwnedSpecificationAssignment_2.eContents().get(0);

		///*
		// * A Constraint such as
		// *
		// * oclText[IsNull('should be null') : self = null]
		// *
		// * comprises at least the OCL specification of the constraint. The constraint may
		// * additionally have a name which may be followed by a parenthesized expression defining an OCL
		// * expression to be evaluated to provide an error message.
		// */
		//ConstraintCS base::ConstraintCS:
		//	(name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':' ownedSpecification=SpecificationCS
		//;
		@Override public ParserRule getRule() { return rule; }

		//(name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':' ownedSpecification=SpecificationCS
		public Group getGroup() { return cGroup; }

		//(name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)?
		public Group getGroup_0() { return cGroup_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0_0() { return cNameAssignment_0_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0_0; }

		//('(' ownedMessageSpecification=SpecificationCS ')')?
		public Group getGroup_0_1() { return cGroup_0_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_0_1_0() { return cLeftParenthesisKeyword_0_1_0; }

		//ownedMessageSpecification=SpecificationCS
		public Assignment getOwnedMessageSpecificationAssignment_0_1_1() { return cOwnedMessageSpecificationAssignment_0_1_1; }

		//SpecificationCS
		public RuleCall getOwnedMessageSpecificationSpecificationCSParserRuleCall_0_1_1_0() { return cOwnedMessageSpecificationSpecificationCSParserRuleCall_0_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_0_1_2() { return cRightParenthesisKeyword_0_1_2; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//ownedSpecification=SpecificationCS
		public Assignment getOwnedSpecificationAssignment_2() { return cOwnedSpecificationAssignment_2; }

		//SpecificationCS
		public RuleCall getOwnedSpecificationSpecificationCSParserRuleCall_2_0() { return cOwnedSpecificationSpecificationCSParserRuleCall_2_0; }
	}

	public class ContextDeclCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.ContextDeclCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cPropertyContextDeclCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cClassifierContextDeclCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cOperationContextDeclCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);

		///*
		// * A Context declaration can be a Classifier, Operation of Property Context declaration.
		// */
		//ContextDeclCS:
		//	PropertyContextDeclCS
		//	| ClassifierContextDeclCS
		//	| OperationContextDeclCS;
		@Override public ParserRule getRule() { return rule; }

		//PropertyContextDeclCS
		//| ClassifierContextDeclCS
		//| OperationContextDeclCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//PropertyContextDeclCS
		public RuleCall getPropertyContextDeclCSParserRuleCall_0() { return cPropertyContextDeclCSParserRuleCall_0; }

		//ClassifierContextDeclCS
		public RuleCall getClassifierContextDeclCSParserRuleCall_1() { return cClassifierContextDeclCSParserRuleCall_1; }

		//OperationContextDeclCS
		public RuleCall getOperationContextDeclCSParserRuleCall_2() { return cOperationContextDeclCSParserRuleCall_2; }
	}

	public class DefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.DefCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cDefOperationCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDefPropertyCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		///*
		// * A definition can be an, Operation or Property definition.
		// */
		//DefCS:
		//	DefOperationCS | DefPropertyCS;
		@Override public ParserRule getRule() { return rule; }

		//DefOperationCS | DefPropertyCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//DefOperationCS
		public RuleCall getDefOperationCSParserRuleCall_0() { return cDefOperationCSParserRuleCall_0; }

		//DefPropertyCS
		public RuleCall getDefPropertyCSParserRuleCall_1() { return cDefPropertyCSParserRuleCall_1; }
	}

	public class DefOperationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.DefOperationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsStaticAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsStaticStaticKeyword_0_0 = (Keyword)cIsStaticAssignment_0.eContents().get(0);
		private final Keyword cDefKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cUnrestrictedNameParserRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cOwnedSignatureAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_4_0 = (RuleCall)cOwnedSignatureAssignment_4.eContents().get(0);
		private final Assignment cNameAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_5_0 = (RuleCall)cNameAssignment_5.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Assignment cOwnedParametersAssignment_7_0 = (Assignment)cGroup_7.eContents().get(0);
		private final RuleCall cOwnedParametersDefParameterCSParserRuleCall_7_0_0 = (RuleCall)cOwnedParametersAssignment_7_0.eContents().get(0);
		private final Group cGroup_7_1 = (Group)cGroup_7.eContents().get(1);
		private final Keyword cCommaKeyword_7_1_0 = (Keyword)cGroup_7_1.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_7_1_1 = (Assignment)cGroup_7_1.eContents().get(1);
		private final RuleCall cOwnedParametersDefParameterCSParserRuleCall_7_1_1_0 = (RuleCall)cOwnedParametersAssignment_7_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Keyword cColonKeyword_9 = (Keyword)cGroup.eContents().get(9);
		private final Assignment cOwnedTypeAssignment_10 = (Assignment)cGroup.eContents().get(10);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_10_0 = (RuleCall)cOwnedTypeAssignment_10.eContents().get(0);
		private final Keyword cEqualsSignKeyword_11 = (Keyword)cGroup.eContents().get(11);
		private final Assignment cOwnedSpecificationAssignment_12 = (Assignment)cGroup.eContents().get(12);
		private final RuleCall cOwnedSpecificationSpecificationCSParserRuleCall_12_0 = (RuleCall)cOwnedSpecificationAssignment_12.eContents().get(0);

		///*
		// * An operation definition provides an additional operation for its classifier context.
		// *
		// * oclText[static def redundantName: isEven(i : Integer) : Boolean = i mod 2 = 0]
		// *
		// * comprises at least an operation name, return type and an OCL expression that evaluates the operation value.
		// * The operation may have parameters and may be declared static in which case there is no oclText[self].
		// *
		// * For compatibility with invariants the definition may have a name that is never used.
		// */
		//DefOperationCS:
		//	isStatic?='static'? 'def' UnrestrictedName? ':' ownedSignature=TemplateSignatureCS?
		//	name=UnrestrictedName '(' (ownedParameters+=DefParameterCS (',' ownedParameters+=DefParameterCS)*)? ')' ':'
		//	ownedType=TypeExpCS?
		//	'=' ownedSpecification=SpecificationCS;
		@Override public ParserRule getRule() { return rule; }

		//isStatic?='static'? 'def' UnrestrictedName? ':' ownedSignature=TemplateSignatureCS?
		//name=UnrestrictedName '(' (ownedParameters+=DefParameterCS (',' ownedParameters+=DefParameterCS)*)? ')' ':'
		//ownedType=TypeExpCS?
		//'=' ownedSpecification=SpecificationCS
		public Group getGroup() { return cGroup; }

		//isStatic?='static'?
		public Assignment getIsStaticAssignment_0() { return cIsStaticAssignment_0; }

		//'static'
		public Keyword getIsStaticStaticKeyword_0_0() { return cIsStaticStaticKeyword_0_0; }

		//'def'
		public Keyword getDefKeyword_1() { return cDefKeyword_1; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_2() { return cUnrestrictedNameParserRuleCall_2; }

		//':'
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_4() { return cOwnedSignatureAssignment_4; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_4_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_4_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_5() { return cNameAssignment_5; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_5_0() { return cNameUnrestrictedNameParserRuleCall_5_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_6() { return cLeftParenthesisKeyword_6; }

		//(ownedParameters+=DefParameterCS (',' ownedParameters+=DefParameterCS)*)?
		public Group getGroup_7() { return cGroup_7; }

		//ownedParameters+=DefParameterCS
		public Assignment getOwnedParametersAssignment_7_0() { return cOwnedParametersAssignment_7_0; }

		//DefParameterCS
		public RuleCall getOwnedParametersDefParameterCSParserRuleCall_7_0_0() { return cOwnedParametersDefParameterCSParserRuleCall_7_0_0; }

		//(',' ownedParameters+=DefParameterCS)*
		public Group getGroup_7_1() { return cGroup_7_1; }

		//','
		public Keyword getCommaKeyword_7_1_0() { return cCommaKeyword_7_1_0; }

		//ownedParameters+=DefParameterCS
		public Assignment getOwnedParametersAssignment_7_1_1() { return cOwnedParametersAssignment_7_1_1; }

		//DefParameterCS
		public RuleCall getOwnedParametersDefParameterCSParserRuleCall_7_1_1_0() { return cOwnedParametersDefParameterCSParserRuleCall_7_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_8() { return cRightParenthesisKeyword_8; }

		//':'
		public Keyword getColonKeyword_9() { return cColonKeyword_9; }

		//ownedType=TypeExpCS?
		public Assignment getOwnedTypeAssignment_10() { return cOwnedTypeAssignment_10; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_10_0() { return cOwnedTypeTypeExpCSParserRuleCall_10_0; }

		//'='
		public Keyword getEqualsSignKeyword_11() { return cEqualsSignKeyword_11; }

		//ownedSpecification=SpecificationCS
		public Assignment getOwnedSpecificationAssignment_12() { return cOwnedSpecificationAssignment_12; }

		//SpecificationCS
		public RuleCall getOwnedSpecificationSpecificationCSParserRuleCall_12_0() { return cOwnedSpecificationSpecificationCSParserRuleCall_12_0; }
	}

	public class DefParameterCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.DefParameterCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_2_0 = (RuleCall)cOwnedTypeAssignment_2.eContents().get(0);

		//DefParameterCS base::ParameterCS:
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

	public class DefPropertyCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.DefPropertyCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsStaticAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsStaticStaticKeyword_0_0 = (Keyword)cIsStaticAssignment_0.eContents().get(0);
		private final Keyword cDefKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cUnrestrictedNameParserRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cNameAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_4_0 = (RuleCall)cNameAssignment_4.eContents().get(0);
		private final Keyword cColonKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cOwnedTypeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_6_0 = (RuleCall)cOwnedTypeAssignment_6.eContents().get(0);
		private final Keyword cEqualsSignKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Assignment cOwnedSpecificationAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cOwnedSpecificationSpecificationCSParserRuleCall_8_0 = (RuleCall)cOwnedSpecificationAssignment_8.eContents().get(0);

		///*
		// * A property definition provides an additional property for its classifier context.
		// *
		// * oclText[static def redundantName: upperCaseName : Boolean = name.toUpperCase()]
		// *
		// * comprises at least a property name, type and an OCL expression that evaluates the property value.
		// * The property may be declared static in which case there is no oclText[self].
		// *
		// * For compatibility with invariants the definition may have a name that is never used.
		// */
		//DefPropertyCS:
		//	isStatic?='static'? 'def' UnrestrictedName? ':' name=UnrestrictedName ':' ownedType=TypeExpCS
		//	'=' ownedSpecification=SpecificationCS;
		@Override public ParserRule getRule() { return rule; }

		//isStatic?='static'? 'def' UnrestrictedName? ':' name=UnrestrictedName ':' ownedType=TypeExpCS
		//'=' ownedSpecification=SpecificationCS
		public Group getGroup() { return cGroup; }

		//isStatic?='static'?
		public Assignment getIsStaticAssignment_0() { return cIsStaticAssignment_0; }

		//'static'
		public Keyword getIsStaticStaticKeyword_0_0() { return cIsStaticStaticKeyword_0_0; }

		//'def'
		public Keyword getDefKeyword_1() { return cDefKeyword_1; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_2() { return cUnrestrictedNameParserRuleCall_2; }

		//':'
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_4() { return cNameAssignment_4; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_4_0() { return cNameUnrestrictedNameParserRuleCall_4_0; }

		//':'
		public Keyword getColonKeyword_5() { return cColonKeyword_5; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_6() { return cOwnedTypeAssignment_6; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_6_0() { return cOwnedTypeTypeExpCSParserRuleCall_6_0; }

		//'='
		public Keyword getEqualsSignKeyword_7() { return cEqualsSignKeyword_7; }

		//ownedSpecification=SpecificationCS
		public Assignment getOwnedSpecificationAssignment_8() { return cOwnedSpecificationAssignment_8; }

		//SpecificationCS
		public RuleCall getOwnedSpecificationSpecificationCSParserRuleCall_8_0() { return cOwnedSpecificationSpecificationCSParserRuleCall_8_0; }
	}

	public class ImportCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.ImportCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cImportKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Keyword cIncludeKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final Keyword cLibraryKeyword_0_2 = (Keyword)cAlternatives_0.eContents().get(2);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cNameIdentifierParserRuleCall_1_0_0 = (RuleCall)cNameAssignment_1_0.eContents().get(0);
		private final Keyword cColonKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cOwnedPathNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedPathNameURIPathNameCSParserRuleCall_2_0 = (RuleCall)cOwnedPathNameAssignment_2.eContents().get(0);
		private final Assignment cIsAllAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final Keyword cIsAllColonColonAsteriskKeyword_3_0 = (Keyword)cIsAllAssignment_3.eContents().get(0);

		//ImportCS base::ImportCS:
		//	('import' | 'include' | 'library') (name=Identifier ':')? ownedPathName=URIPathNameCS isAll?='::*'?;
		@Override public ParserRule getRule() { return rule; }

		//('import' | 'include' | 'library') (name=Identifier ':')? ownedPathName=URIPathNameCS isAll?='::*'?
		public Group getGroup() { return cGroup; }

		//('import' | 'include' | 'library')
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//'import'
		public Keyword getImportKeyword_0_0() { return cImportKeyword_0_0; }

		//'include'
		public Keyword getIncludeKeyword_0_1() { return cIncludeKeyword_0_1; }

		//'library'
		public Keyword getLibraryKeyword_0_2() { return cLibraryKeyword_0_2; }

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

	public class OperationContextDeclCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.OperationContextDeclCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cContextKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedSignatureAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_1_0 = (RuleCall)cOwnedSignatureAssignment_1.eContents().get(0);
		private final Assignment cOwnedPathNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedPathNameUnreservedPathNameCSParserRuleCall_2_0 = (RuleCall)cOwnedPathNameAssignment_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Assignment cOwnedParametersAssignment_4_0 = (Assignment)cGroup_4.eContents().get(0);
		private final RuleCall cOwnedParametersParameterCSParserRuleCall_4_0_0 = (RuleCall)cOwnedParametersAssignment_4_0.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cGroup_4.eContents().get(1);
		private final Keyword cCommaKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cOwnedParametersParameterCSParserRuleCall_4_1_1_0 = (RuleCall)cOwnedParametersAssignment_4_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cColonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cOwnedTypeAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_7_0 = (RuleCall)cOwnedTypeAssignment_7.eContents().get(0);
		private final Alternatives cAlternatives_8 = (Alternatives)cGroup.eContents().get(8);
		private final Group cGroup_8_0 = (Group)cAlternatives_8.eContents().get(0);
		private final Keyword cPreKeyword_8_0_0 = (Keyword)cGroup_8_0.eContents().get(0);
		private final Assignment cOwnedPreconditionsAssignment_8_0_1 = (Assignment)cGroup_8_0.eContents().get(1);
		private final RuleCall cOwnedPreconditionsConstraintCSParserRuleCall_8_0_1_0 = (RuleCall)cOwnedPreconditionsAssignment_8_0_1.eContents().get(0);
		private final Group cGroup_8_1 = (Group)cAlternatives_8.eContents().get(1);
		private final Keyword cPostKeyword_8_1_0 = (Keyword)cGroup_8_1.eContents().get(0);
		private final Assignment cOwnedPostconditionsAssignment_8_1_1 = (Assignment)cGroup_8_1.eContents().get(1);
		private final RuleCall cOwnedPostconditionsConstraintCSParserRuleCall_8_1_1_0 = (RuleCall)cOwnedPostconditionsAssignment_8_1_1.eContents().get(0);
		private final Group cGroup_8_2 = (Group)cAlternatives_8.eContents().get(2);
		private final Keyword cBodyKeyword_8_2_0 = (Keyword)cGroup_8_2.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_8_2_1 = (RuleCall)cGroup_8_2.eContents().get(1);
		private final Keyword cColonKeyword_8_2_2 = (Keyword)cGroup_8_2.eContents().get(2);
		private final Assignment cOwnedBodiesAssignment_8_2_3 = (Assignment)cGroup_8_2.eContents().get(3);
		private final RuleCall cOwnedBodiesSpecificationCSParserRuleCall_8_2_3_0 = (RuleCall)cOwnedBodiesAssignment_8_2_3.eContents().get(0);

		///*
		// * An operation context declaration complements an existing operation with additional details.
		// *
		// * oclText[context (T) Stack::pop() : T]
		// * oclText[pre NotEmptyPop: size() > 0]
		// * oclText[post: size()@pre = size() + 1]
		// *
		// * The operation declaration comprises at least an operation name, which must be qualified with at least a
		// * class name. If used outside a package declaration, package name qualification is also needed.
		// * If the return type is omitted OclVoid is used.
		// * The operation may also have operation parameters and template parameters.
		// * The declaration may be followed by any number of preconditions,
		// * and/or postconditions. It may also be followed by a body expression that defines the evaluation.
		// *
		// * For compatibility with invariants the body expression may have a name that is never used.
		// */
		//OperationContextDeclCS:
		//	'context' ownedSignature=TemplateSignatureCS? ownedPathName=UnreservedPathNameCS
		//	'(' (ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)? ')' ':' ownedType=TypeExpCS? ('pre'
		//	ownedPreconditions+=ConstraintCS | 'post' ownedPostconditions+=ConstraintCS | 'body' UnrestrictedName? ':'
		//	ownedBodies+=SpecificationCS)*;
		@Override public ParserRule getRule() { return rule; }

		//'context' ownedSignature=TemplateSignatureCS? ownedPathName=UnreservedPathNameCS
		//'(' (ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)? ')' ':' ownedType=TypeExpCS? ('pre'
		//ownedPreconditions+=ConstraintCS | 'post' ownedPostconditions+=ConstraintCS | 'body' UnrestrictedName? ':'
		//ownedBodies+=SpecificationCS)*
		public Group getGroup() { return cGroup; }

		//'context'
		public Keyword getContextKeyword_0() { return cContextKeyword_0; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_1() { return cOwnedSignatureAssignment_1; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_1_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_1_0; }

		//ownedPathName=UnreservedPathNameCS
		public Assignment getOwnedPathNameAssignment_2() { return cOwnedPathNameAssignment_2; }

		//UnreservedPathNameCS
		public RuleCall getOwnedPathNameUnreservedPathNameCSParserRuleCall_2_0() { return cOwnedPathNameUnreservedPathNameCSParserRuleCall_2_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }

		//(ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)?
		public Group getGroup_4() { return cGroup_4; }

		//ownedParameters+=ParameterCS
		public Assignment getOwnedParametersAssignment_4_0() { return cOwnedParametersAssignment_4_0; }

		//ParameterCS
		public RuleCall getOwnedParametersParameterCSParserRuleCall_4_0_0() { return cOwnedParametersParameterCSParserRuleCall_4_0_0; }

		//(',' ownedParameters+=ParameterCS)*
		public Group getGroup_4_1() { return cGroup_4_1; }

		//','
		public Keyword getCommaKeyword_4_1_0() { return cCommaKeyword_4_1_0; }

		//ownedParameters+=ParameterCS
		public Assignment getOwnedParametersAssignment_4_1_1() { return cOwnedParametersAssignment_4_1_1; }

		//ParameterCS
		public RuleCall getOwnedParametersParameterCSParserRuleCall_4_1_1_0() { return cOwnedParametersParameterCSParserRuleCall_4_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }

		//':'
		public Keyword getColonKeyword_6() { return cColonKeyword_6; }

		//ownedType=TypeExpCS?
		public Assignment getOwnedTypeAssignment_7() { return cOwnedTypeAssignment_7; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_7_0() { return cOwnedTypeTypeExpCSParserRuleCall_7_0; }

		//('pre' ownedPreconditions+=ConstraintCS | 'post' ownedPostconditions+=ConstraintCS | 'body' UnrestrictedName? ':'
		//ownedBodies+=SpecificationCS)*
		public Alternatives getAlternatives_8() { return cAlternatives_8; }

		//'pre' ownedPreconditions+=ConstraintCS
		public Group getGroup_8_0() { return cGroup_8_0; }

		//'pre'
		public Keyword getPreKeyword_8_0_0() { return cPreKeyword_8_0_0; }

		//ownedPreconditions+=ConstraintCS
		public Assignment getOwnedPreconditionsAssignment_8_0_1() { return cOwnedPreconditionsAssignment_8_0_1; }

		//ConstraintCS
		public RuleCall getOwnedPreconditionsConstraintCSParserRuleCall_8_0_1_0() { return cOwnedPreconditionsConstraintCSParserRuleCall_8_0_1_0; }

		//'post' ownedPostconditions+=ConstraintCS
		public Group getGroup_8_1() { return cGroup_8_1; }

		//'post'
		public Keyword getPostKeyword_8_1_0() { return cPostKeyword_8_1_0; }

		//ownedPostconditions+=ConstraintCS
		public Assignment getOwnedPostconditionsAssignment_8_1_1() { return cOwnedPostconditionsAssignment_8_1_1; }

		//ConstraintCS
		public RuleCall getOwnedPostconditionsConstraintCSParserRuleCall_8_1_1_0() { return cOwnedPostconditionsConstraintCSParserRuleCall_8_1_1_0; }

		//'body' UnrestrictedName? ':' ownedBodies+=SpecificationCS
		public Group getGroup_8_2() { return cGroup_8_2; }

		//'body'
		public Keyword getBodyKeyword_8_2_0() { return cBodyKeyword_8_2_0; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_8_2_1() { return cUnrestrictedNameParserRuleCall_8_2_1; }

		//':'
		public Keyword getColonKeyword_8_2_2() { return cColonKeyword_8_2_2; }

		//ownedBodies+=SpecificationCS
		public Assignment getOwnedBodiesAssignment_8_2_3() { return cOwnedBodiesAssignment_8_2_3; }

		//SpecificationCS
		public RuleCall getOwnedBodiesSpecificationCSParserRuleCall_8_2_3_0() { return cOwnedBodiesSpecificationCSParserRuleCall_8_2_3_0; }
	}

	public class PackageDeclarationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.PackageDeclarationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPackageKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedPathNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedPathNameUnreservedPathNameCSParserRuleCall_1_0 = (RuleCall)cOwnedPathNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cInvKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedInvariantsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedInvariantsConstraintCSParserRuleCall_2_1_0 = (RuleCall)cOwnedInvariantsAssignment_2_1.eContents().get(0);
		private final Assignment cOwnedContextsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedContextsContextDeclCSParserRuleCall_3_0 = (RuleCall)cOwnedContextsAssignment_3.eContents().get(0);
		private final Keyword cEndpackageKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//PackageDeclarationCS:
		//	'package' ownedPathName=UnreservedPathNameCS ('inv' ownedInvariants+=ConstraintCS)* ownedContexts+=ContextDeclCS*
		//	'endpackage';
		@Override public ParserRule getRule() { return rule; }

		//'package' ownedPathName=UnreservedPathNameCS ('inv' ownedInvariants+=ConstraintCS)* ownedContexts+=ContextDeclCS*
		//'endpackage'
		public Group getGroup() { return cGroup; }

		//'package'
		public Keyword getPackageKeyword_0() { return cPackageKeyword_0; }

		//ownedPathName=UnreservedPathNameCS
		public Assignment getOwnedPathNameAssignment_1() { return cOwnedPathNameAssignment_1; }

		//UnreservedPathNameCS
		public RuleCall getOwnedPathNameUnreservedPathNameCSParserRuleCall_1_0() { return cOwnedPathNameUnreservedPathNameCSParserRuleCall_1_0; }

		//('inv' ownedInvariants+=ConstraintCS)*
		public Group getGroup_2() { return cGroup_2; }

		//'inv'
		public Keyword getInvKeyword_2_0() { return cInvKeyword_2_0; }

		//ownedInvariants+=ConstraintCS
		public Assignment getOwnedInvariantsAssignment_2_1() { return cOwnedInvariantsAssignment_2_1; }

		//ConstraintCS
		public RuleCall getOwnedInvariantsConstraintCSParserRuleCall_2_1_0() { return cOwnedInvariantsConstraintCSParserRuleCall_2_1_0; }

		//ownedContexts+=ContextDeclCS*
		public Assignment getOwnedContextsAssignment_3() { return cOwnedContextsAssignment_3; }

		//ContextDeclCS
		public RuleCall getOwnedContextsContextDeclCSParserRuleCall_3_0() { return cOwnedContextsContextDeclCSParserRuleCall_3_0; }

		//'endpackage'
		public Keyword getEndpackageKeyword_4() { return cEndpackageKeyword_4; }
	}

	public class ParameterCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.ParameterCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0_0 = (RuleCall)cNameAssignment_0_0.eContents().get(0);
		private final Keyword cColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_1_0 = (RuleCall)cOwnedTypeAssignment_1.eContents().get(0);

		//ParameterCS base::ParameterCS:
		//	(name=UnrestrictedName ':')? ownedType=TypeExpCS;
		@Override public ParserRule getRule() { return rule; }

		//(name=UnrestrictedName ':')? ownedType=TypeExpCS
		public Group getGroup() { return cGroup; }

		//(name=UnrestrictedName ':')?
		public Group getGroup_0() { return cGroup_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0_0() { return cNameAssignment_0_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0_0; }

		//':'
		public Keyword getColonKeyword_0_1() { return cColonKeyword_0_1; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_1() { return cOwnedTypeAssignment_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_1_0; }
	}

	public class PropertyContextDeclCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.PropertyContextDeclCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cContextKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedPathNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedPathNameUnreservedPathNameCSParserRuleCall_1_0 = (RuleCall)cOwnedPathNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_3_0 = (RuleCall)cOwnedTypeAssignment_3.eContents().get(0);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Group cGroup_4_0 = (Group)cAlternatives_4.eContents().get(0);
		private final Keyword cDeriveKeyword_4_0_0 = (Keyword)cGroup_4_0.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_4_0_1 = (RuleCall)cGroup_4_0.eContents().get(1);
		private final Keyword cColonKeyword_4_0_2 = (Keyword)cGroup_4_0.eContents().get(2);
		private final Assignment cOwnedDefaultExpressionsAssignment_4_0_3 = (Assignment)cGroup_4_0.eContents().get(3);
		private final RuleCall cOwnedDefaultExpressionsSpecificationCSParserRuleCall_4_0_3_0 = (RuleCall)cOwnedDefaultExpressionsAssignment_4_0_3.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cAlternatives_4.eContents().get(1);
		private final Keyword cInitKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_4_1_1 = (RuleCall)cGroup_4_1.eContents().get(1);
		private final Keyword cColonKeyword_4_1_2 = (Keyword)cGroup_4_1.eContents().get(2);
		private final Assignment cOwnedDefaultExpressionsAssignment_4_1_3 = (Assignment)cGroup_4_1.eContents().get(3);
		private final RuleCall cOwnedDefaultExpressionsSpecificationCSParserRuleCall_4_1_3_0 = (RuleCall)cOwnedDefaultExpressionsAssignment_4_1_3.eContents().get(0);

		///*
		// * A property context declaration complements an existing property with additional details.
		// *
		// * oclText[context (T) Stack::isEmpty : Boolean]
		// * oclText[derive IsEmpty: size() = 0]
		// *
		// * The property declaration comprises at least a property name and type.
		// * The type must be qualified with at least a class name.
		// * If used outside a package declaration, package name qualification is also needed.
		// * The declaration may be followed by a derive constraint and/or an init expression.
		// *
		// * A derive constraint provides an alternate mechanism for defining a class invariant;
		// * the only difference is that the property is identified as a constrainedElement. As an
		// * invariant the constraint provides an OCL expression that should always be true.
		// *
		// * For a non-derived property, an init expression defines the value to be assigned to the property
		// * when its containing object is first created.
		// *
		// * For a derived property, an init expression defines the evaluation of the property, which
		// * may vary from access to access even for read-only properties.
		// *
		// * NB. RoyalAndLoyal gratuitously names its derived values.
		// */
		//PropertyContextDeclCS:
		//	'context' ownedPathName=UnreservedPathNameCS ':' ownedType=TypeExpCS ('derive' UnrestrictedName? ':'
		//	ownedDefaultExpressions+=SpecificationCS | 'init' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS)*;
		@Override public ParserRule getRule() { return rule; }

		//'context' ownedPathName=UnreservedPathNameCS ':' ownedType=TypeExpCS ('derive' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS | 'init' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS)*
		public Group getGroup() { return cGroup; }

		//'context'
		public Keyword getContextKeyword_0() { return cContextKeyword_0; }

		//ownedPathName=UnreservedPathNameCS
		public Assignment getOwnedPathNameAssignment_1() { return cOwnedPathNameAssignment_1; }

		//UnreservedPathNameCS
		public RuleCall getOwnedPathNameUnreservedPathNameCSParserRuleCall_1_0() { return cOwnedPathNameUnreservedPathNameCSParserRuleCall_1_0; }

		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_3() { return cOwnedTypeAssignment_3; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_3_0() { return cOwnedTypeTypeExpCSParserRuleCall_3_0; }

		//('derive' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS | 'init' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS)*
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//'derive' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS
		public Group getGroup_4_0() { return cGroup_4_0; }

		//'derive'
		public Keyword getDeriveKeyword_4_0_0() { return cDeriveKeyword_4_0_0; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_4_0_1() { return cUnrestrictedNameParserRuleCall_4_0_1; }

		//':'
		public Keyword getColonKeyword_4_0_2() { return cColonKeyword_4_0_2; }

		//ownedDefaultExpressions+=SpecificationCS
		public Assignment getOwnedDefaultExpressionsAssignment_4_0_3() { return cOwnedDefaultExpressionsAssignment_4_0_3; }

		//SpecificationCS
		public RuleCall getOwnedDefaultExpressionsSpecificationCSParserRuleCall_4_0_3_0() { return cOwnedDefaultExpressionsSpecificationCSParserRuleCall_4_0_3_0; }

		//'init' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS
		public Group getGroup_4_1() { return cGroup_4_1; }

		//'init'
		public Keyword getInitKeyword_4_1_0() { return cInitKeyword_4_1_0; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_4_1_1() { return cUnrestrictedNameParserRuleCall_4_1_1; }

		//':'
		public Keyword getColonKeyword_4_1_2() { return cColonKeyword_4_1_2; }

		//ownedDefaultExpressions+=SpecificationCS
		public Assignment getOwnedDefaultExpressionsAssignment_4_1_3() { return cOwnedDefaultExpressionsAssignment_4_1_3; }

		//SpecificationCS
		public RuleCall getOwnedDefaultExpressionsSpecificationCSParserRuleCall_4_1_3_0() { return cOwnedDefaultExpressionsSpecificationCSParserRuleCall_4_1_3_0; }
	}

	public class SpecificationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.SpecificationCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cOwnedExpressionAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_0_0 = (RuleCall)cOwnedExpressionAssignment_0.eContents().get(0);
		private final Assignment cExprStringAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cExprStringUNQUOTED_STRINGTerminalRuleCall_1_0 = (RuleCall)cExprStringAssignment_1.eContents().get(0);

		//SpecificationCS essentialocl::ExpSpecificationCS:
		//	ownedExpression=ExpCS | exprString=UNQUOTED_STRING;
		@Override public ParserRule getRule() { return rule; }

		//ownedExpression=ExpCS | exprString=UNQUOTED_STRING
		public Alternatives getAlternatives() { return cAlternatives; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment_0() { return cOwnedExpressionAssignment_0; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_0_0() { return cOwnedExpressionExpCSParserRuleCall_0_0; }

		//exprString=UNQUOTED_STRING
		public Assignment getExprStringAssignment_1() { return cExprStringAssignment_1; }

		//UNQUOTED_STRING
		public RuleCall getExprStringUNQUOTED_STRINGTerminalRuleCall_1_0() { return cExprStringUNQUOTED_STRINGTerminalRuleCall_1_0; }
	}

	public class TemplateSignatureCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.TemplateSignatureCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cOwnedParametersTypeParameterCSParserRuleCall_0_1_0 = (RuleCall)cOwnedParametersAssignment_0_1.eContents().get(0);
		private final Group cGroup_0_2 = (Group)cGroup_0.eContents().get(2);
		private final Keyword cCommaKeyword_0_2_0 = (Keyword)cGroup_0_2.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_0_2_1 = (Assignment)cGroup_0_2.eContents().get(1);
		private final RuleCall cOwnedParametersTypeParameterCSParserRuleCall_0_2_1_0 = (RuleCall)cOwnedParametersAssignment_0_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_0_3 = (Keyword)cGroup_0.eContents().get(3);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cLessThanSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedParametersTypeParameterCSParserRuleCall_1_1_0 = (RuleCall)cOwnedParametersAssignment_1_1.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Keyword cCommaKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_1_2_1 = (Assignment)cGroup_1_2.eContents().get(1);
		private final RuleCall cOwnedParametersTypeParameterCSParserRuleCall_1_2_1_0 = (RuleCall)cOwnedParametersAssignment_1_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_1_3 = (Keyword)cGroup_1.eContents().get(3);

		//@Override
		//TemplateSignatureCS base::TemplateSignatureCS:
		//	'(' ownedParameters+=TypeParameterCS (',' ownedParameters+=TypeParameterCS)* ')' | '<'
		//	ownedParameters+=TypeParameterCS (',' ownedParameters+=TypeParameterCS)* '>';
		@Override public ParserRule getRule() { return rule; }

		//'(' ownedParameters+=TypeParameterCS (',' ownedParameters+=TypeParameterCS)* ')' | '<'
		//ownedParameters+=TypeParameterCS (',' ownedParameters+=TypeParameterCS)* '>'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'(' ownedParameters+=TypeParameterCS (',' ownedParameters+=TypeParameterCS)* ')'
		public Group getGroup_0() { return cGroup_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_0_0() { return cLeftParenthesisKeyword_0_0; }

		//ownedParameters+=TypeParameterCS
		public Assignment getOwnedParametersAssignment_0_1() { return cOwnedParametersAssignment_0_1; }

		//TypeParameterCS
		public RuleCall getOwnedParametersTypeParameterCSParserRuleCall_0_1_0() { return cOwnedParametersTypeParameterCSParserRuleCall_0_1_0; }

		//(',' ownedParameters+=TypeParameterCS)*
		public Group getGroup_0_2() { return cGroup_0_2; }

		//','
		public Keyword getCommaKeyword_0_2_0() { return cCommaKeyword_0_2_0; }

		//ownedParameters+=TypeParameterCS
		public Assignment getOwnedParametersAssignment_0_2_1() { return cOwnedParametersAssignment_0_2_1; }

		//TypeParameterCS
		public RuleCall getOwnedParametersTypeParameterCSParserRuleCall_0_2_1_0() { return cOwnedParametersTypeParameterCSParserRuleCall_0_2_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_0_3() { return cRightParenthesisKeyword_0_3; }

		//'<' ownedParameters+=TypeParameterCS (',' ownedParameters+=TypeParameterCS)* '>'
		public Group getGroup_1() { return cGroup_1; }

		//'<'
		public Keyword getLessThanSignKeyword_1_0() { return cLessThanSignKeyword_1_0; }

		//ownedParameters+=TypeParameterCS
		public Assignment getOwnedParametersAssignment_1_1() { return cOwnedParametersAssignment_1_1; }

		//TypeParameterCS
		public RuleCall getOwnedParametersTypeParameterCSParserRuleCall_1_1_0() { return cOwnedParametersTypeParameterCSParserRuleCall_1_1_0; }

		//(',' ownedParameters+=TypeParameterCS)*
		public Group getGroup_1_2() { return cGroup_1_2; }

		//','
		public Keyword getCommaKeyword_1_2_0() { return cCommaKeyword_1_2_0; }

		//ownedParameters+=TypeParameterCS
		public Assignment getOwnedParametersAssignment_1_2_1() { return cOwnedParametersAssignment_1_2_1; }

		//TypeParameterCS
		public RuleCall getOwnedParametersTypeParameterCSParserRuleCall_1_2_1_0() { return cOwnedParametersTypeParameterCSParserRuleCall_1_2_1_0; }

		//'>'
		public Keyword getGreaterThanSignKeyword_1_3() { return cGreaterThanSignKeyword_1_3; }
	}

	public class TypedRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.TypedRefCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTypeLiteralCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTypedTypeRefCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		//@Override
		//TypedRefCS base::TypedRefCS:
		//	TypeLiteralCS | TypedTypeRefCS;
		@Override public ParserRule getRule() { return rule; }

		//TypeLiteralCS | TypedTypeRefCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//TypeLiteralCS
		public RuleCall getTypeLiteralCSParserRuleCall_0() { return cTypeLiteralCSParserRuleCall_0; }

		//TypedTypeRefCS
		public RuleCall getTypedTypeRefCSParserRuleCall_1() { return cTypedTypeRefCSParserRuleCall_1; }
	}

	public class UnrestrictedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.UnrestrictedName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEssentialOCLUnrestrictedNameParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cImportKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cIncludeKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cLibraryKeyword_3 = (Keyword)cAlternatives.eContents().get(3);

		//@Override
		//UnrestrictedName:
		//	EssentialOCLUnrestrictedName
		//	// | 'body'
		//	// | 'context'
		//	// | 'def'
		//	// | 'derive'
		//	// |	'endpackage'
		//	| 'import'
		//	| 'include'
		//	// | 'init'
		//	// | 'inv'
		//	| 'library'// |	'package'
		//// |	'post'
		//// |	'pre'
		//// |	'static'
		//;
		@Override public ParserRule getRule() { return rule; }

		//EssentialOCLUnrestrictedName
		//// | 'body'
		//// | 'context'
		//// | 'def'
		//// | 'derive'
		//// |	'endpackage'
		//| 'import'
		//| 'include'
		//// | 'init'
		//// | 'inv'
		//| 'library'
		public Alternatives getAlternatives() { return cAlternatives; }

		//EssentialOCLUnrestrictedName
		public RuleCall getEssentialOCLUnrestrictedNameParserRuleCall_0() { return cEssentialOCLUnrestrictedNameParserRuleCall_0; }

		//'import'
		public Keyword getImportKeyword_1() { return cImportKeyword_1; }

		//'include'
		public Keyword getIncludeKeyword_2() { return cIncludeKeyword_2; }

		//'library'
		public Keyword getLibraryKeyword_3() { return cLibraryKeyword_3; }
	}

	public class NavigatingArgExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.NavigatingArgExpCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cOCLMessageArgCSAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Keyword cQuestionMarkKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final RuleCall cExpCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		//@Override
		//NavigatingArgExpCS essentialocl::ExpCS:
		//	{OCLMessageArgCS} '?' | ExpCS;
		@Override public ParserRule getRule() { return rule; }

		//{OCLMessageArgCS} '?' | ExpCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//{OCLMessageArgCS} '?'
		public Group getGroup_0() { return cGroup_0; }

		//{OCLMessageArgCS}
		public Action getOCLMessageArgCSAction_0_0() { return cOCLMessageArgCSAction_0_0; }

		//'?'
		public Keyword getQuestionMarkKeyword_0_1() { return cQuestionMarkKeyword_0_1; }

		//ExpCS
		public RuleCall getExpCSParserRuleCall_1() { return cExpCSParserRuleCall_1; }
	}

	public class NavigationOperatorNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.NavigationOperatorName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEssentialOCLNavigationOperatorNameParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cCompleteOCLNavigationOperatorNameParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		//@Override
		//NavigationOperatorName:
		//	EssentialOCLNavigationOperatorName | CompleteOCLNavigationOperatorName;
		@Override public ParserRule getRule() { return rule; }

		//EssentialOCLNavigationOperatorName | CompleteOCLNavigationOperatorName
		public Alternatives getAlternatives() { return cAlternatives; }

		//EssentialOCLNavigationOperatorName
		public RuleCall getEssentialOCLNavigationOperatorNameParserRuleCall_0() { return cEssentialOCLNavigationOperatorNameParserRuleCall_0; }

		//CompleteOCLNavigationOperatorName
		public RuleCall getCompleteOCLNavigationOperatorNameParserRuleCall_1() { return cCompleteOCLNavigationOperatorNameParserRuleCall_1; }
	}

	public class PrimitiveTypeIdentifierElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.PrimitiveTypeIdentifier");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cBooleanKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cIntegerKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cRealKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cStringKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cUnlimitedNaturalKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cOclAnyKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cOclInvalidKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cOclMessageKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cOclStateKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cOclVoidKeyword_9 = (Keyword)cAlternatives.eContents().get(9);

		//@Override
		//PrimitiveTypeIdentifier:
		//	'Boolean'
		//	| 'Integer'
		//	| 'Real'
		//	| 'String'
		//	| 'UnlimitedNatural'
		//	| 'OclAny'
		//	| 'OclInvalid'
		//	| 'OclMessage'
		//	| 'OclState'
		//	| 'OclVoid';
		@Override public ParserRule getRule() { return rule; }

		//'Boolean'
		//| 'Integer'
		//| 'Real'
		//| 'String'
		//| 'UnlimitedNatural'
		//| 'OclAny'
		//| 'OclInvalid'
		//| 'OclMessage'
		//| 'OclState'
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

		//'OclMessage'
		public Keyword getOclMessageKeyword_7() { return cOclMessageKeyword_7; }

		//'OclState'
		public Keyword getOclStateKeyword_8() { return cOclStateKeyword_8; }

		//'OclVoid'
		public Keyword getOclVoidKeyword_9() { return cOclVoidKeyword_9; }
	}


	private final CompleteOCLDocumentCSElements pCompleteOCLDocumentCS;
	private final TerminalRule tUNQUOTED_STRING;
	private final CompleteOCLNavigationOperatorNameElements pCompleteOCLNavigationOperatorName;
	private final ClassifierContextDeclCSElements pClassifierContextDeclCS;
	private final ConstraintCSElements pConstraintCS;
	private final ContextDeclCSElements pContextDeclCS;
	private final DefCSElements pDefCS;
	private final DefOperationCSElements pDefOperationCS;
	private final DefParameterCSElements pDefParameterCS;
	private final DefPropertyCSElements pDefPropertyCS;
	private final ImportCSElements pImportCS;
	private final OperationContextDeclCSElements pOperationContextDeclCS;
	private final PackageDeclarationCSElements pPackageDeclarationCS;
	private final ParameterCSElements pParameterCS;
	private final PropertyContextDeclCSElements pPropertyContextDeclCS;
	private final SpecificationCSElements pSpecificationCS;
	private final TemplateSignatureCSElements pTemplateSignatureCS;
	private final TypedRefCSElements pTypedRefCS;
	private final UnrestrictedNameElements pUnrestrictedName;
	private final NavigatingArgExpCSElements pNavigatingArgExpCS;
	private final NavigationOperatorNameElements pNavigationOperatorName;
	private final PrimitiveTypeIdentifierElements pPrimitiveTypeIdentifier;

	private final Grammar grammar;

	private final EssentialOCLGrammarAccess gaEssentialOCL;

	private final BaseGrammarAccess gaBase;

	@Inject
	public CompleteOCLGrammarAccess(GrammarProvider grammarProvider,
		EssentialOCLGrammarAccess gaEssentialOCL,
		BaseGrammarAccess gaBase) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaEssentialOCL = gaEssentialOCL;
		this.gaBase = gaBase;
		this.pCompleteOCLDocumentCS = new CompleteOCLDocumentCSElements();
		this.tUNQUOTED_STRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.completeocl.CompleteOCL.UNQUOTED_STRING");
		this.pCompleteOCLNavigationOperatorName = new CompleteOCLNavigationOperatorNameElements();
		this.pClassifierContextDeclCS = new ClassifierContextDeclCSElements();
		this.pConstraintCS = new ConstraintCSElements();
		this.pContextDeclCS = new ContextDeclCSElements();
		this.pDefCS = new DefCSElements();
		this.pDefOperationCS = new DefOperationCSElements();
		this.pDefParameterCS = new DefParameterCSElements();
		this.pDefPropertyCS = new DefPropertyCSElements();
		this.pImportCS = new ImportCSElements();
		this.pOperationContextDeclCS = new OperationContextDeclCSElements();
		this.pPackageDeclarationCS = new PackageDeclarationCSElements();
		this.pParameterCS = new ParameterCSElements();
		this.pPropertyContextDeclCS = new PropertyContextDeclCSElements();
		this.pSpecificationCS = new SpecificationCSElements();
		this.pTemplateSignatureCS = new TemplateSignatureCSElements();
		this.pTypedRefCS = new TypedRefCSElements();
		this.pUnrestrictedName = new UnrestrictedNameElements();
		this.pNavigatingArgExpCS = new NavigatingArgExpCSElements();
		this.pNavigationOperatorName = new NavigationOperatorNameElements();
		this.pPrimitiveTypeIdentifier = new PrimitiveTypeIdentifierElements();
	}

	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.ocl.xtext.completeocl.CompleteOCL".equals(grammar.getName())) {
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


	///*
	// * A Complete OCL document comprises
	// * bullet[model imports for referenced and complemented models]
	// * bullet[includes for additional Complete OCL documents]
	// * bullet[libraries to augment or override the OCL Standard Library]
	// * bullet[package declarations for package-grouped declarations]
	// * bullet[context declarations for independent declarations]
	// */
	//CompleteOCLDocumentCS:
	//	ownedImports+=ImportCS* (ownedPackages+=PackageDeclarationCS | ownedContexts+=ContextDeclCS)*;
	public CompleteOCLDocumentCSElements getCompleteOCLDocumentCSAccess() {
		return pCompleteOCLDocumentCS;
	}

	public ParserRule getCompleteOCLDocumentCSRule() {
		return getCompleteOCLDocumentCSAccess().getRule();
	}

	//terminal UNQUOTED_STRING: // Never forward parsed; just provides a placeholder
	//	'£$%^£$%^' // for reverse serialisation of embedded OCL
	//;
	public TerminalRule getUNQUOTED_STRINGRule() {
		return tUNQUOTED_STRING;
	}

	//CompleteOCLNavigationOperatorName:
	//	'^' | '^^';
	public CompleteOCLNavigationOperatorNameElements getCompleteOCLNavigationOperatorNameAccess() {
		return pCompleteOCLNavigationOperatorName;
	}

	public ParserRule getCompleteOCLNavigationOperatorNameRule() {
		return getCompleteOCLNavigationOperatorNameAccess().getRule();
	}

	//ClassifierContextDeclCS:
	//	'context' ownedSignature=TemplateSignatureCS? selfName=UnrestrictedName?
	//	ownedPathName=UnreservedPathNameCS ('inv' ownedInvariants+=ConstraintCS | ownedDefinitions+=DefCS)+;
	public ClassifierContextDeclCSElements getClassifierContextDeclCSAccess() {
		return pClassifierContextDeclCS;
	}

	public ParserRule getClassifierContextDeclCSRule() {
		return getClassifierContextDeclCSAccess().getRule();
	}

	///*
	// * A Constraint such as
	// *
	// * oclText[IsNull('should be null') : self = null]
	// *
	// * comprises at least the OCL specification of the constraint. The constraint may
	// * additionally have a name which may be followed by a parenthesized expression defining an OCL
	// * expression to be evaluated to provide an error message.
	// */
	//ConstraintCS base::ConstraintCS:
	//	(name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':' ownedSpecification=SpecificationCS
	//;
	public ConstraintCSElements getConstraintCSAccess() {
		return pConstraintCS;
	}

	public ParserRule getConstraintCSRule() {
		return getConstraintCSAccess().getRule();
	}

	///*
	// * A Context declaration can be a Classifier, Operation of Property Context declaration.
	// */
	//ContextDeclCS:
	//	PropertyContextDeclCS
	//	| ClassifierContextDeclCS
	//	| OperationContextDeclCS;
	public ContextDeclCSElements getContextDeclCSAccess() {
		return pContextDeclCS;
	}

	public ParserRule getContextDeclCSRule() {
		return getContextDeclCSAccess().getRule();
	}

	///*
	// * A definition can be an, Operation or Property definition.
	// */
	//DefCS:
	//	DefOperationCS | DefPropertyCS;
	public DefCSElements getDefCSAccess() {
		return pDefCS;
	}

	public ParserRule getDefCSRule() {
		return getDefCSAccess().getRule();
	}

	///*
	// * An operation definition provides an additional operation for its classifier context.
	// *
	// * oclText[static def redundantName: isEven(i : Integer) : Boolean = i mod 2 = 0]
	// *
	// * comprises at least an operation name, return type and an OCL expression that evaluates the operation value.
	// * The operation may have parameters and may be declared static in which case there is no oclText[self].
	// *
	// * For compatibility with invariants the definition may have a name that is never used.
	// */
	//DefOperationCS:
	//	isStatic?='static'? 'def' UnrestrictedName? ':' ownedSignature=TemplateSignatureCS?
	//	name=UnrestrictedName '(' (ownedParameters+=DefParameterCS (',' ownedParameters+=DefParameterCS)*)? ')' ':'
	//	ownedType=TypeExpCS?
	//	'=' ownedSpecification=SpecificationCS;
	public DefOperationCSElements getDefOperationCSAccess() {
		return pDefOperationCS;
	}

	public ParserRule getDefOperationCSRule() {
		return getDefOperationCSAccess().getRule();
	}

	//DefParameterCS base::ParameterCS:
	//	name=UnrestrictedName ':' ownedType=TypeExpCS;
	public DefParameterCSElements getDefParameterCSAccess() {
		return pDefParameterCS;
	}

	public ParserRule getDefParameterCSRule() {
		return getDefParameterCSAccess().getRule();
	}

	///*
	// * A property definition provides an additional property for its classifier context.
	// *
	// * oclText[static def redundantName: upperCaseName : Boolean = name.toUpperCase()]
	// *
	// * comprises at least a property name, type and an OCL expression that evaluates the property value.
	// * The property may be declared static in which case there is no oclText[self].
	// *
	// * For compatibility with invariants the definition may have a name that is never used.
	// */
	//DefPropertyCS:
	//	isStatic?='static'? 'def' UnrestrictedName? ':' name=UnrestrictedName ':' ownedType=TypeExpCS
	//	'=' ownedSpecification=SpecificationCS;
	public DefPropertyCSElements getDefPropertyCSAccess() {
		return pDefPropertyCS;
	}

	public ParserRule getDefPropertyCSRule() {
		return getDefPropertyCSAccess().getRule();
	}

	//ImportCS base::ImportCS:
	//	('import' | 'include' | 'library') (name=Identifier ':')? ownedPathName=URIPathNameCS isAll?='::*'?;
	public ImportCSElements getImportCSAccess() {
		return pImportCS;
	}

	public ParserRule getImportCSRule() {
		return getImportCSAccess().getRule();
	}

	///*
	// * An operation context declaration complements an existing operation with additional details.
	// *
	// * oclText[context (T) Stack::pop() : T]
	// * oclText[pre NotEmptyPop: size() > 0]
	// * oclText[post: size()@pre = size() + 1]
	// *
	// * The operation declaration comprises at least an operation name, which must be qualified with at least a
	// * class name. If used outside a package declaration, package name qualification is also needed.
	// * If the return type is omitted OclVoid is used.
	// * The operation may also have operation parameters and template parameters.
	// * The declaration may be followed by any number of preconditions,
	// * and/or postconditions. It may also be followed by a body expression that defines the evaluation.
	// *
	// * For compatibility with invariants the body expression may have a name that is never used.
	// */
	//OperationContextDeclCS:
	//	'context' ownedSignature=TemplateSignatureCS? ownedPathName=UnreservedPathNameCS
	//	'(' (ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)? ')' ':' ownedType=TypeExpCS? ('pre'
	//	ownedPreconditions+=ConstraintCS | 'post' ownedPostconditions+=ConstraintCS | 'body' UnrestrictedName? ':'
	//	ownedBodies+=SpecificationCS)*;
	public OperationContextDeclCSElements getOperationContextDeclCSAccess() {
		return pOperationContextDeclCS;
	}

	public ParserRule getOperationContextDeclCSRule() {
		return getOperationContextDeclCSAccess().getRule();
	}

	//PackageDeclarationCS:
	//	'package' ownedPathName=UnreservedPathNameCS ('inv' ownedInvariants+=ConstraintCS)* ownedContexts+=ContextDeclCS*
	//	'endpackage';
	public PackageDeclarationCSElements getPackageDeclarationCSAccess() {
		return pPackageDeclarationCS;
	}

	public ParserRule getPackageDeclarationCSRule() {
		return getPackageDeclarationCSAccess().getRule();
	}

	//ParameterCS base::ParameterCS:
	//	(name=UnrestrictedName ':')? ownedType=TypeExpCS;
	public ParameterCSElements getParameterCSAccess() {
		return pParameterCS;
	}

	public ParserRule getParameterCSRule() {
		return getParameterCSAccess().getRule();
	}

	///*
	// * A property context declaration complements an existing property with additional details.
	// *
	// * oclText[context (T) Stack::isEmpty : Boolean]
	// * oclText[derive IsEmpty: size() = 0]
	// *
	// * The property declaration comprises at least a property name and type.
	// * The type must be qualified with at least a class name.
	// * If used outside a package declaration, package name qualification is also needed.
	// * The declaration may be followed by a derive constraint and/or an init expression.
	// *
	// * A derive constraint provides an alternate mechanism for defining a class invariant;
	// * the only difference is that the property is identified as a constrainedElement. As an
	// * invariant the constraint provides an OCL expression that should always be true.
	// *
	// * For a non-derived property, an init expression defines the value to be assigned to the property
	// * when its containing object is first created.
	// *
	// * For a derived property, an init expression defines the evaluation of the property, which
	// * may vary from access to access even for read-only properties.
	// *
	// * NB. RoyalAndLoyal gratuitously names its derived values.
	// */
	//PropertyContextDeclCS:
	//	'context' ownedPathName=UnreservedPathNameCS ':' ownedType=TypeExpCS ('derive' UnrestrictedName? ':'
	//	ownedDefaultExpressions+=SpecificationCS | 'init' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS)*;
	public PropertyContextDeclCSElements getPropertyContextDeclCSAccess() {
		return pPropertyContextDeclCS;
	}

	public ParserRule getPropertyContextDeclCSRule() {
		return getPropertyContextDeclCSAccess().getRule();
	}

	//SpecificationCS essentialocl::ExpSpecificationCS:
	//	ownedExpression=ExpCS | exprString=UNQUOTED_STRING;
	public SpecificationCSElements getSpecificationCSAccess() {
		return pSpecificationCS;
	}

	public ParserRule getSpecificationCSRule() {
		return getSpecificationCSAccess().getRule();
	}

	//@Override
	//TemplateSignatureCS base::TemplateSignatureCS:
	//	'(' ownedParameters+=TypeParameterCS (',' ownedParameters+=TypeParameterCS)* ')' | '<'
	//	ownedParameters+=TypeParameterCS (',' ownedParameters+=TypeParameterCS)* '>';
	public TemplateSignatureCSElements getTemplateSignatureCSAccess() {
		return pTemplateSignatureCS;
	}

	public ParserRule getTemplateSignatureCSRule() {
		return getTemplateSignatureCSAccess().getRule();
	}

	//@Override
	//TypedRefCS base::TypedRefCS:
	//	TypeLiteralCS | TypedTypeRefCS;
	public TypedRefCSElements getTypedRefCSAccess() {
		return pTypedRefCS;
	}

	public ParserRule getTypedRefCSRule() {
		return getTypedRefCSAccess().getRule();
	}

	//@Override
	//UnrestrictedName:
	//	EssentialOCLUnrestrictedName
	//	// | 'body'
	//	// | 'context'
	//	// | 'def'
	//	// | 'derive'
	//	// |	'endpackage'
	//	| 'import'
	//	| 'include'
	//	// | 'init'
	//	// | 'inv'
	//	| 'library'// |	'package'
	//// |	'post'
	//// |	'pre'
	//// |	'static'
	//;
	public UnrestrictedNameElements getUnrestrictedNameAccess() {
		return pUnrestrictedName;
	}

	public ParserRule getUnrestrictedNameRule() {
		return getUnrestrictedNameAccess().getRule();
	}

	//@Override
	//NavigatingArgExpCS essentialocl::ExpCS:
	//	{OCLMessageArgCS} '?' | ExpCS;
	public NavigatingArgExpCSElements getNavigatingArgExpCSAccess() {
		return pNavigatingArgExpCS;
	}

	public ParserRule getNavigatingArgExpCSRule() {
		return getNavigatingArgExpCSAccess().getRule();
	}

	//@Override
	//NavigationOperatorName:
	//	EssentialOCLNavigationOperatorName | CompleteOCLNavigationOperatorName;
	public NavigationOperatorNameElements getNavigationOperatorNameAccess() {
		return pNavigationOperatorName;
	}

	public ParserRule getNavigationOperatorNameRule() {
		return getNavigationOperatorNameAccess().getRule();
	}

	//@Override
	//PrimitiveTypeIdentifier:
	//	'Boolean'
	//	| 'Integer'
	//	| 'Real'
	//	| 'String'
	//	| 'UnlimitedNatural'
	//	| 'OclAny'
	//	| 'OclInvalid'
	//	| 'OclMessage'
	//	| 'OclState'
	//	| 'OclVoid';
	public PrimitiveTypeIdentifierElements getPrimitiveTypeIdentifierAccess() {
		return pPrimitiveTypeIdentifier;
	}

	public ParserRule getPrimitiveTypeIdentifierRule() {
		return getPrimitiveTypeIdentifierAccess().getRule();
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
	//	InfixOperatorName | super::NavigationOperatorName;
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
	//	Identifier;
	public EssentialOCLGrammarAccess.EssentialOCLUnrestrictedNameElements getEssentialOCLUnrestrictedNameAccess() {
		return gaEssentialOCL.getEssentialOCLUnrestrictedNameAccess();
	}

	public ParserRule getEssentialOCLUnrestrictedNameRule() {
		return getEssentialOCLUnrestrictedNameAccess().getRule();
	}

	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLUnreservedName:
	//	super::UnrestrictedName
	//	| CollectionTypeIdentifier
	//	| super::PrimitiveTypeIdentifier
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
	//	referredElement=[pivot::NamedElement|super::UnrestrictedName] | {base::PathElementWithURICS}
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

	//PrimitiveTypeCS base::PrimitiveTypeRefCS:
	//	name=super::PrimitiveTypeIdentifier;
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
	//	name='Tuple' ('(' (ownedParts+=TuplePartCS (',' ownedParts+=TuplePartCS)*)? ')')?;
	public EssentialOCLGrammarAccess.TupleTypeCSElements getTupleTypeCSAccess() {
		return gaEssentialOCL.getTupleTypeCSAccess();
	}

	public ParserRule getTupleTypeCSRule() {
		return getTupleTypeCSAccess().getRule();
	}

	//TuplePartCS base::TuplePartCS:
	//	name=super::UnrestrictedName ':' ownedType=TypeExpCS;
	public EssentialOCLGrammarAccess.TuplePartCSElements getTuplePartCSAccess() {
		return gaEssentialOCL.getTuplePartCSAccess();
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
	//	'{' (ownedParts+=PatternExpCS (',' ownedParts+=PatternExpCS)* ('++' restVariableName=Identifier))?
	//	'}';
	public EssentialOCLGrammarAccess.CollectionPatternCSElements getCollectionPatternCSAccess() {
		return gaEssentialOCL.getCollectionPatternCSAccess();
	}

	public ParserRule getCollectionPatternCSRule() {
		return getCollectionPatternCSAccess().getRule();
	}

	//ShadowPartCS:
	//	referredProperty=[pivot::Property|super::UnrestrictedName] '=' ownedInitExpression=(ExpCS | PatternExpCS) |
	//	ownedInitExpression=StringLiteralExpCS;
	public EssentialOCLGrammarAccess.ShadowPartCSElements getShadowPartCSAccess() {
		return gaEssentialOCL.getShadowPartCSAccess();
	}

	public ParserRule getShadowPartCSRule() {
		return getShadowPartCSAccess().getRule();
	}

	//PatternExpCS:
	//	patternVariableName=super::UnrestrictedName? ':' ownedPatternType=TypeExpCS;
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
	//	name=super::UnrestrictedName (':' ownedType=TypeExpCS)? '=' ownedInitExpression=ExpCS;
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
	//	ownedNameExpression=super::NavigatingArgExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS ('='
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
	//	prefix='|' ownedNameExpression=super::NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?
	//;
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
	//	prefix=',' ownedNameExpression=super::NavigatingArgExpCS (('with' | '<-') ownedCoIterator=CoIteratorVariableCS ('='
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
	//	prefix=';' ownedNameExpression=super::NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?
	//;
	public EssentialOCLGrammarAccess.NavigatingSemiArgCSElements getNavigatingSemiArgCSAccess() {
		return gaEssentialOCL.getNavigatingSemiArgCSAccess();
	}

	public ParserRule getNavigatingSemiArgCSRule() {
		return getNavigatingSemiArgCSAccess().getRule();
	}

	//CoIteratorVariableCS VariableCS:
	//	name=super::UnrestrictedName (':' ownedType=TypeExpCS)?;
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
	//	name=super::UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS? (':' ownedType=TypeExpCS)? '='
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

	//TypedTypeRefCS:
	//	ownedPathName=PathNameCS ('(' ownedBinding=TemplateBindingCS ')')?;
	public BaseGrammarAccess.TypedTypeRefCSElements getTypedTypeRefCSAccess() {
		return gaBase.getTypedTypeRefCSAccess();
	}

	public ParserRule getTypedTypeRefCSRule() {
		return getTypedTypeRefCSAccess().getRule();
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
