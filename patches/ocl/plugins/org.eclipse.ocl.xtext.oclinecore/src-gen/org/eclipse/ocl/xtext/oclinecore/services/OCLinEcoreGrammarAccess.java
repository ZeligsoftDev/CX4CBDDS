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
package org.eclipse.ocl.xtext.oclinecore.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;

@Singleton
public class OCLinEcoreGrammarAccess extends AbstractGrammarElementFinder {


	public class TopLevelCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.TopLevelCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTopLevelCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cModuleKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		private final Assignment cOwnedImportsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedImportsImportCSParserRuleCall_2_0 = (RuleCall)cOwnedImportsAssignment_2.eContents().get(0);
		private final Assignment cOwnedPackagesAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedPackagesPackageCSParserRuleCall_3_0 = (RuleCall)cOwnedPackagesAssignment_3.eContents().get(0);

		////generate oclinEcore2 "http://www.eclipse.org/ocl/examples/xtext/oclinecore/OCLinEcore"
		//TopLevelCS:
		//	{TopLevelCS} ('module' UnrestrictedName)?
		//	ownedImports+=ImportCS*
		//	ownedPackages+=PackageCS*;
		@Override public ParserRule getRule() { return rule; }

		//{TopLevelCS} ('module' UnrestrictedName)?
		//ownedImports+=ImportCS*
		//ownedPackages+=PackageCS*
		public Group getGroup() { return cGroup; }

		//{TopLevelCS}
		public Action getTopLevelCSAction_0() { return cTopLevelCSAction_0; }

		//('module' UnrestrictedName)?
		public Group getGroup_1() { return cGroup_1; }

		//'module'
		public Keyword getModuleKeyword_1_0() { return cModuleKeyword_1_0; }

		//UnrestrictedName
		public RuleCall getUnrestrictedNameParserRuleCall_1_1() { return cUnrestrictedNameParserRuleCall_1_1; }

		//ownedImports+=ImportCS*
		public Assignment getOwnedImportsAssignment_2() { return cOwnedImportsAssignment_2; }

		//ImportCS
		public RuleCall getOwnedImportsImportCSParserRuleCall_2_0() { return cOwnedImportsImportCSParserRuleCall_2_0; }

		//ownedPackages+=PackageCS*
		public Assignment getOwnedPackagesAssignment_3() { return cOwnedPackagesAssignment_3; }

		//PackageCS
		public RuleCall getOwnedPackagesPackageCSParserRuleCall_3_0() { return cOwnedPackagesPackageCSParserRuleCall_3_0; }
	}

	public class INTEGERElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.INTEGER");
		private final RuleCall cINTTerminalRuleCall = (RuleCall)rule.eContents().get(1);

		//INTEGER ecore::EInt:
		//	INT;
		@Override public ParserRule getRule() { return rule; }

		//INT
		public RuleCall getINTTerminalRuleCall() { return cINTTerminalRuleCall; }
	}

	public class SIGNEDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.SIGNED");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);

		//SIGNED ecore::EInt:
		//	'-'? INT;
		@Override public ParserRule getRule() { return rule; }

		//'-'? INT
		public Group getGroup() { return cGroup; }

		//'-'?
		public Keyword getHyphenMinusKeyword_0() { return cHyphenMinusKeyword_0; }

		//INT
		public RuleCall getINTTerminalRuleCall_1() { return cINTTerminalRuleCall_1; }
	}

	public class EnumerationLiteralNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.EnumerationLiteralName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEssentialOCLUnrestrictedNameParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cAbstractKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cAttributeKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cBodyKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cCallableKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cClassKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cComposesKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cDatatypeKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cDefinitionKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cDerivationKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cDerivedKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cEnumKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Keyword cExtendsKeyword_12 = (Keyword)cAlternatives.eContents().get(12);
		private final Keyword cIdKeyword_13 = (Keyword)cAlternatives.eContents().get(13);
		private final Keyword cImportKeyword_14 = (Keyword)cAlternatives.eContents().get(14);
		private final Keyword cInitialKeyword_15 = (Keyword)cAlternatives.eContents().get(15);
		private final Keyword cInterfaceKeyword_16 = (Keyword)cAlternatives.eContents().get(16);
		private final Keyword cKeyKeyword_17 = (Keyword)cAlternatives.eContents().get(17);
		private final Keyword cLibraryKeyword_18 = (Keyword)cAlternatives.eContents().get(18);
		private final Keyword cModuleKeyword_19 = (Keyword)cAlternatives.eContents().get(19);
		private final Keyword cOperationKeyword_20 = (Keyword)cAlternatives.eContents().get(20);
		private final Keyword cOrderedKeyword_21 = (Keyword)cAlternatives.eContents().get(21);
		private final Keyword cPackageKeyword_22 = (Keyword)cAlternatives.eContents().get(22);
		private final Keyword cPostconditionKeyword_23 = (Keyword)cAlternatives.eContents().get(23);
		private final Keyword cPreconditionKeyword_24 = (Keyword)cAlternatives.eContents().get(24);
		private final Keyword cPrimitiveKeyword_25 = (Keyword)cAlternatives.eContents().get(25);
		private final Keyword cPropertyKeyword_26 = (Keyword)cAlternatives.eContents().get(26);
		private final Keyword cReadonlyKeyword_27 = (Keyword)cAlternatives.eContents().get(27);
		private final Keyword cReferenceKeyword_28 = (Keyword)cAlternatives.eContents().get(28);
		private final Keyword cResolveKeyword_29 = (Keyword)cAlternatives.eContents().get(29);
		private final Keyword cStaticKeyword_30 = (Keyword)cAlternatives.eContents().get(30);
		private final Keyword cThrowsKeyword_31 = (Keyword)cAlternatives.eContents().get(31);
		private final Keyword cTransientKeyword_32 = (Keyword)cAlternatives.eContents().get(32);
		private final Keyword cUniqueKeyword_33 = (Keyword)cAlternatives.eContents().get(33);
		private final Keyword cUnsettableKeyword_34 = (Keyword)cAlternatives.eContents().get(34);
		private final Keyword cVolatileKeyword_35 = (Keyword)cAlternatives.eContents().get(35);

		//EnumerationLiteralName:
		//	EssentialOCLUnrestrictedName
		//	| 'abstract'
		//	| 'attribute'
		//	| 'body'
		//	| 'callable'
		//	| 'class'
		//	| 'composes'
		//	| 'datatype'
		//	| 'definition'
		//	| 'derivation'
		//	| 'derived'
		//	| 'enum'
		//	| 'extends'
		//	| 'id'
		//	| 'import'
		//	| 'initial'
		//	| 'interface'
		//	| 'key'
		//	| 'library'
		//	| 'module'
		//	| 'operation'
		//	| 'ordered'
		//	| 'package'
		//	| 'postcondition'
		//	| 'precondition'
		//	| 'primitive'
		//	| 'property'
		//	| 'readonly'
		//	| 'reference'
		//	| 'resolve'
		//	| 'static'
		//	| 'throws'
		//	| 'transient'
		//	| 'unique'
		//	| 'unsettable'
		//	| 'volatile';
		@Override public ParserRule getRule() { return rule; }

		//EssentialOCLUnrestrictedName
		//| 'abstract'
		//| 'attribute'
		//| 'body'
		//| 'callable'
		//| 'class'
		//| 'composes'
		//| 'datatype'
		//| 'definition'
		//| 'derivation'
		//| 'derived'
		//| 'enum'
		//| 'extends'
		//| 'id'
		//| 'import'
		//| 'initial'
		//| 'interface'
		//| 'key'
		//| 'library'
		//| 'module'
		//| 'operation'
		//| 'ordered'
		//| 'package'
		//| 'postcondition'
		//| 'precondition'
		//| 'primitive'
		//| 'property'
		//| 'readonly'
		//| 'reference'
		//| 'resolve'
		//| 'static'
		//| 'throws'
		//| 'transient'
		//| 'unique'
		//| 'unsettable'
		//| 'volatile'
		public Alternatives getAlternatives() { return cAlternatives; }

		//EssentialOCLUnrestrictedName
		public RuleCall getEssentialOCLUnrestrictedNameParserRuleCall_0() { return cEssentialOCLUnrestrictedNameParserRuleCall_0; }

		//'abstract'
		public Keyword getAbstractKeyword_1() { return cAbstractKeyword_1; }

		//'attribute'
		public Keyword getAttributeKeyword_2() { return cAttributeKeyword_2; }

		//'body'
		public Keyword getBodyKeyword_3() { return cBodyKeyword_3; }

		//'callable'
		public Keyword getCallableKeyword_4() { return cCallableKeyword_4; }

		//'class'
		public Keyword getClassKeyword_5() { return cClassKeyword_5; }

		//'composes'
		public Keyword getComposesKeyword_6() { return cComposesKeyword_6; }

		//'datatype'
		public Keyword getDatatypeKeyword_7() { return cDatatypeKeyword_7; }

		//'definition'
		public Keyword getDefinitionKeyword_8() { return cDefinitionKeyword_8; }

		//'derivation'
		public Keyword getDerivationKeyword_9() { return cDerivationKeyword_9; }

		//'derived'
		public Keyword getDerivedKeyword_10() { return cDerivedKeyword_10; }

		//'enum'
		public Keyword getEnumKeyword_11() { return cEnumKeyword_11; }

		//'extends'
		public Keyword getExtendsKeyword_12() { return cExtendsKeyword_12; }

		//'id'
		public Keyword getIdKeyword_13() { return cIdKeyword_13; }

		//'import'
		public Keyword getImportKeyword_14() { return cImportKeyword_14; }

		//'initial'
		public Keyword getInitialKeyword_15() { return cInitialKeyword_15; }

		//'interface'
		public Keyword getInterfaceKeyword_16() { return cInterfaceKeyword_16; }

		//'key'
		public Keyword getKeyKeyword_17() { return cKeyKeyword_17; }

		//'library'
		public Keyword getLibraryKeyword_18() { return cLibraryKeyword_18; }

		//'module'
		public Keyword getModuleKeyword_19() { return cModuleKeyword_19; }

		//'operation'
		public Keyword getOperationKeyword_20() { return cOperationKeyword_20; }

		//'ordered'
		public Keyword getOrderedKeyword_21() { return cOrderedKeyword_21; }

		//'package'
		public Keyword getPackageKeyword_22() { return cPackageKeyword_22; }

		//'postcondition'
		public Keyword getPostconditionKeyword_23() { return cPostconditionKeyword_23; }

		//'precondition'
		public Keyword getPreconditionKeyword_24() { return cPreconditionKeyword_24; }

		//'primitive'
		public Keyword getPrimitiveKeyword_25() { return cPrimitiveKeyword_25; }

		//'property'
		public Keyword getPropertyKeyword_26() { return cPropertyKeyword_26; }

		//'readonly'
		public Keyword getReadonlyKeyword_27() { return cReadonlyKeyword_27; }

		//'reference'
		public Keyword getReferenceKeyword_28() { return cReferenceKeyword_28; }

		//'resolve'
		public Keyword getResolveKeyword_29() { return cResolveKeyword_29; }

		//'static'
		public Keyword getStaticKeyword_30() { return cStaticKeyword_30; }

		//'throws'
		public Keyword getThrowsKeyword_31() { return cThrowsKeyword_31; }

		//'transient'
		public Keyword getTransientKeyword_32() { return cTransientKeyword_32; }

		//'unique'
		public Keyword getUniqueKeyword_33() { return cUniqueKeyword_33; }

		//'unsettable'
		public Keyword getUnsettableKeyword_34() { return cUnsettableKeyword_34; }

		//'volatile'
		public Keyword getVolatileKeyword_35() { return cVolatileKeyword_35; }
	}

	public class InvariantConstraintCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.InvariantConstraintCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsCallableAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsCallableCallableKeyword_0_0 = (Keyword)cIsCallableAssignment_0.eContents().get(0);
		private final Assignment cStereotypeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cStereotypeInvariantKeyword_1_0 = (Keyword)cStereotypeAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0_0 = (RuleCall)cNameAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cOwnedMessageSpecificationAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cOwnedMessageSpecificationSpecificationCSParserRuleCall_2_1_1_0 = (RuleCall)cOwnedMessageSpecificationAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_1_2 = (Keyword)cGroup_2_1.eContents().get(2);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cAlternatives_3.eContents().get(0);
		private final Keyword cColonKeyword_3_0_0 = (Keyword)cGroup_3_0.eContents().get(0);
		private final Assignment cOwnedSpecificationAssignment_3_0_1 = (Assignment)cGroup_3_0.eContents().get(1);
		private final RuleCall cOwnedSpecificationSpecificationCSParserRuleCall_3_0_1_0 = (RuleCall)cOwnedSpecificationAssignment_3_0_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_3_0_2 = (Keyword)cGroup_3_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_3_1 = (Keyword)cAlternatives_3.eContents().get(1);

		//InvariantConstraintCS OCLinEcoreConstraintCS:
		//	isCallable?='callable'? stereotype='invariant' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS
		//	')')?)? (':' ownedSpecification=SpecificationCS? ';' | ';');
		@Override public ParserRule getRule() { return rule; }

		//isCallable?='callable'? stereotype='invariant' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS
		//')')?)? (':' ownedSpecification=SpecificationCS? ';' | ';')
		public Group getGroup() { return cGroup; }

		//isCallable?='callable'?
		public Assignment getIsCallableAssignment_0() { return cIsCallableAssignment_0; }

		//'callable'
		public Keyword getIsCallableCallableKeyword_0_0() { return cIsCallableCallableKeyword_0_0; }

		//stereotype='invariant'
		public Assignment getStereotypeAssignment_1() { return cStereotypeAssignment_1; }

		//'invariant'
		public Keyword getStereotypeInvariantKeyword_1_0() { return cStereotypeInvariantKeyword_1_0; }

		//(name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)?
		public Group getGroup_2() { return cGroup_2; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2_0() { return cNameAssignment_2_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0_0() { return cNameUnrestrictedNameParserRuleCall_2_0_0; }

		//('(' ownedMessageSpecification=SpecificationCS ')')?
		public Group getGroup_2_1() { return cGroup_2_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_2_1_0() { return cLeftParenthesisKeyword_2_1_0; }

		//ownedMessageSpecification=SpecificationCS
		public Assignment getOwnedMessageSpecificationAssignment_2_1_1() { return cOwnedMessageSpecificationAssignment_2_1_1; }

		//SpecificationCS
		public RuleCall getOwnedMessageSpecificationSpecificationCSParserRuleCall_2_1_1_0() { return cOwnedMessageSpecificationSpecificationCSParserRuleCall_2_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_2_1_2() { return cRightParenthesisKeyword_2_1_2; }

		//(':' ownedSpecification=SpecificationCS? ';' | ';')
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//':' ownedSpecification=SpecificationCS? ';'
		public Group getGroup_3_0() { return cGroup_3_0; }

		//':'
		public Keyword getColonKeyword_3_0_0() { return cColonKeyword_3_0_0; }

		//ownedSpecification=SpecificationCS?
		public Assignment getOwnedSpecificationAssignment_3_0_1() { return cOwnedSpecificationAssignment_3_0_1; }

		//SpecificationCS
		public RuleCall getOwnedSpecificationSpecificationCSParserRuleCall_3_0_1_0() { return cOwnedSpecificationSpecificationCSParserRuleCall_3_0_1_0; }

		//';'
		public Keyword getSemicolonKeyword_3_0_2() { return cSemicolonKeyword_3_0_2; }

		//';'
		public Keyword getSemicolonKeyword_3_1() { return cSemicolonKeyword_3_1; }
	}

	public class PostconditionConstraintCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.PostconditionConstraintCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cStereotypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cStereotypePostconditionKeyword_0_0 = (Keyword)cStereotypeAssignment_0.eContents().get(0);
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

		//PostconditionConstraintCS OCLinEcoreConstraintCS:
		//	stereotype='postcondition' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
		//	ownedSpecification=SpecificationCS? ';';
		@Override public ParserRule getRule() { return rule; }

		//stereotype='postcondition' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
		//ownedSpecification=SpecificationCS? ';'
		public Group getGroup() { return cGroup; }

		//stereotype='postcondition'
		public Assignment getStereotypeAssignment_0() { return cStereotypeAssignment_0; }

		//'postcondition'
		public Keyword getStereotypePostconditionKeyword_0_0() { return cStereotypePostconditionKeyword_0_0; }

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

		//ownedSpecification=SpecificationCS?
		public Assignment getOwnedSpecificationAssignment_3() { return cOwnedSpecificationAssignment_3; }

		//SpecificationCS
		public RuleCall getOwnedSpecificationSpecificationCSParserRuleCall_3_0() { return cOwnedSpecificationSpecificationCSParserRuleCall_3_0; }

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class PreconditionConstraintCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.PreconditionConstraintCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cStereotypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cStereotypePreconditionKeyword_0_0 = (Keyword)cStereotypeAssignment_0.eContents().get(0);
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

		//PreconditionConstraintCS OCLinEcoreConstraintCS:
		//	stereotype='precondition' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
		//	ownedSpecification=SpecificationCS? ';';
		@Override public ParserRule getRule() { return rule; }

		//stereotype='precondition' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
		//ownedSpecification=SpecificationCS? ';'
		public Group getGroup() { return cGroup; }

		//stereotype='precondition'
		public Assignment getStereotypeAssignment_0() { return cStereotypeAssignment_0; }

		//'precondition'
		public Keyword getStereotypePreconditionKeyword_0_0() { return cStereotypePreconditionKeyword_0_0; }

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

		//ownedSpecification=SpecificationCS?
		public Assignment getOwnedSpecificationAssignment_3() { return cOwnedSpecificationAssignment_3; }

		//SpecificationCS
		public RuleCall getOwnedSpecificationSpecificationCSParserRuleCall_3_0() { return cOwnedSpecificationSpecificationCSParserRuleCall_3_0; }

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class AnnotationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.AnnotationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAnnotationCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cAnnotationKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cNameAlternatives_2_0 = (Alternatives)cNameAssignment_2.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0_0 = (RuleCall)cNameAlternatives_2_0.eContents().get(0);
		private final RuleCall cNameSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1 = (RuleCall)cNameAlternatives_2_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cOwnedDetailsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cOwnedDetailsDetailCSParserRuleCall_3_1_0 = (RuleCall)cOwnedDetailsAssignment_3_1.eContents().get(0);
		private final Group cGroup_3_2 = (Group)cGroup_3.eContents().get(2);
		private final Keyword cCommaKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Assignment cOwnedDetailsAssignment_3_2_1 = (Assignment)cGroup_3_2.eContents().get(1);
		private final RuleCall cOwnedDetailsDetailCSParserRuleCall_3_2_1_0 = (RuleCall)cOwnedDetailsAssignment_3_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3_3 = (Keyword)cGroup_3.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Group cGroup_4_0 = (Group)cAlternatives_4.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4_0_0 = (Keyword)cGroup_4_0.eContents().get(0);
		private final Alternatives cAlternatives_4_0_1 = (Alternatives)cGroup_4_0.eContents().get(1);
		private final Assignment cOwnedAnnotationsAssignment_4_0_1_0 = (Assignment)cAlternatives_4_0_1.eContents().get(0);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_4_0_1_0_0 = (RuleCall)cOwnedAnnotationsAssignment_4_0_1_0.eContents().get(0);
		private final Assignment cOwnedContentsAssignment_4_0_1_1 = (Assignment)cAlternatives_4_0_1.eContents().get(1);
		private final RuleCall cOwnedContentsModelElementCSParserRuleCall_4_0_1_1_0 = (RuleCall)cOwnedContentsAssignment_4_0_1_1.eContents().get(0);
		private final Assignment cOwnedReferencesAssignment_4_0_1_2 = (Assignment)cAlternatives_4_0_1.eContents().get(2);
		private final RuleCall cOwnedReferencesModelElementRefCSParserRuleCall_4_0_1_2_0 = (RuleCall)cOwnedReferencesAssignment_4_0_1_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4_0_2 = (Keyword)cGroup_4_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_4_1 = (Keyword)cAlternatives_4.eContents().get(1);

		//AnnotationCS base::AnnotationCS:
		//	{base::AnnotationCS} 'annotation' name=(UnrestrictedName | SINGLE_QUOTED_STRING)? ('(' ownedDetails+=DetailCS (','
		//	ownedDetails+=DetailCS)* ')')? ('{' (ownedAnnotations+=AnnotationElementCS
		//	| ownedContents+=ModelElementCS
		//	| ownedReferences+=ModelElementRefCS)+ '}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//{base::AnnotationCS} 'annotation' name=(UnrestrictedName | SINGLE_QUOTED_STRING)? ('(' ownedDetails+=DetailCS (','
		//ownedDetails+=DetailCS)* ')')? ('{' (ownedAnnotations+=AnnotationElementCS
		//| ownedContents+=ModelElementCS
		//| ownedReferences+=ModelElementRefCS)+ '}' | ';')
		public Group getGroup() { return cGroup; }

		//{base::AnnotationCS}
		public Action getAnnotationCSAction_0() { return cAnnotationCSAction_0; }

		//'annotation'
		public Keyword getAnnotationKeyword_1() { return cAnnotationKeyword_1; }

		//name=(UnrestrictedName | SINGLE_QUOTED_STRING)?
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//(UnrestrictedName | SINGLE_QUOTED_STRING)
		public Alternatives getNameAlternatives_2_0() { return cNameAlternatives_2_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0_0() { return cNameUnrestrictedNameParserRuleCall_2_0_0; }

		//SINGLE_QUOTED_STRING
		public RuleCall getNameSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1() { return cNameSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1; }

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

		//('{' (ownedAnnotations+=AnnotationElementCS
		//| ownedContents+=ModelElementCS
		//| ownedReferences+=ModelElementRefCS)+ '}' | ';')
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//'{' (ownedAnnotations+=AnnotationElementCS
		//| ownedContents+=ModelElementCS
		//| ownedReferences+=ModelElementRefCS)+ '}'
		public Group getGroup_4_0() { return cGroup_4_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_4_0_0() { return cLeftCurlyBracketKeyword_4_0_0; }

		//(ownedAnnotations+=AnnotationElementCS
		//| ownedContents+=ModelElementCS
		//| ownedReferences+=ModelElementRefCS)+
		public Alternatives getAlternatives_4_0_1() { return cAlternatives_4_0_1; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_4_0_1_0() { return cOwnedAnnotationsAssignment_4_0_1_0; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_4_0_1_0_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_4_0_1_0_0; }

		//ownedContents+=ModelElementCS
		public Assignment getOwnedContentsAssignment_4_0_1_1() { return cOwnedContentsAssignment_4_0_1_1; }

		//ModelElementCS
		public RuleCall getOwnedContentsModelElementCSParserRuleCall_4_0_1_1_0() { return cOwnedContentsModelElementCSParserRuleCall_4_0_1_1_0; }

		//ownedReferences+=ModelElementRefCS
		public Assignment getOwnedReferencesAssignment_4_0_1_2() { return cOwnedReferencesAssignment_4_0_1_2; }

		//ModelElementRefCS
		public RuleCall getOwnedReferencesModelElementRefCSParserRuleCall_4_0_1_2_0() { return cOwnedReferencesModelElementRefCSParserRuleCall_4_0_1_2_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_4_0_2() { return cRightCurlyBracketKeyword_4_0_2; }

		//';'
		public Keyword getSemicolonKeyword_4_1() { return cSemicolonKeyword_4_1; }
	}

	public class AnnotationElementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.AnnotationElementCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAnnotationCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDocumentationCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cSysMLCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);

		//AnnotationElementCS base::AnnotationElementCS:
		//	AnnotationCS | DocumentationCS | SysMLCS;
		@Override public ParserRule getRule() { return rule; }

		//AnnotationCS | DocumentationCS | SysMLCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//AnnotationCS
		public RuleCall getAnnotationCSParserRuleCall_0() { return cAnnotationCSParserRuleCall_0; }

		//DocumentationCS
		public RuleCall getDocumentationCSParserRuleCall_1() { return cDocumentationCSParserRuleCall_1; }

		//SysMLCS
		public RuleCall getSysMLCSParserRuleCall_2() { return cSysMLCSParserRuleCall_2; }
	}

	public class AttributeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.AttributeCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cAlternatives_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_0_0 = (Assignment)cGroup_0_0.eContents().get(0);
		private final Keyword cQualifiersStaticKeyword_0_0_0_0 = (Keyword)cQualifiersAssignment_0_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_0_1 = (Assignment)cGroup_0_0.eContents().get(1);
		private final Keyword cQualifiersDefinitionKeyword_0_0_1_0 = (Keyword)cQualifiersAssignment_0_0_1.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cAlternatives_0.eContents().get(1);
		private final Assignment cQualifiersAssignment_0_1_0 = (Assignment)cGroup_0_1.eContents().get(0);
		private final Keyword cQualifiersDefinitionKeyword_0_1_0_0 = (Keyword)cQualifiersAssignment_0_1_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final Keyword cQualifiersStaticKeyword_0_1_1_0 = (Keyword)cQualifiersAssignment_0_1_1.eContents().get(0);
		private final Keyword cAttributeKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_1_0 = (RuleCall)cOwnedTypeAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cEqualsSignKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cDefaultAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0 = (RuleCall)cDefaultAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cLeftCurlyBracketKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Group cGroup_5_1 = (Group)cGroup_5.eContents().get(1);
		private final Alternatives cAlternatives_5_1_0 = (Alternatives)cGroup_5_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_0 = (Assignment)cAlternatives_5_1_0.eContents().get(0);
		private final Keyword cQualifiersDerivedKeyword_5_1_0_0_0 = (Keyword)cQualifiersAssignment_5_1_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_1 = (Assignment)cAlternatives_5_1_0.eContents().get(1);
		private final Keyword cQualifiersDerivedKeyword_5_1_0_1_0 = (Keyword)cQualifiersAssignment_5_1_0_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_2 = (Assignment)cAlternatives_5_1_0.eContents().get(2);
		private final Keyword cQualifiersIdKeyword_5_1_0_2_0 = (Keyword)cQualifiersAssignment_5_1_0_2.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_3 = (Assignment)cAlternatives_5_1_0.eContents().get(3);
		private final Keyword cQualifiersIdKeyword_5_1_0_3_0 = (Keyword)cQualifiersAssignment_5_1_0_3.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_4 = (Assignment)cAlternatives_5_1_0.eContents().get(4);
		private final Keyword cQualifiersOrderedKeyword_5_1_0_4_0 = (Keyword)cQualifiersAssignment_5_1_0_4.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_5 = (Assignment)cAlternatives_5_1_0.eContents().get(5);
		private final Keyword cQualifiersOrderedKeyword_5_1_0_5_0 = (Keyword)cQualifiersAssignment_5_1_0_5.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_6 = (Assignment)cAlternatives_5_1_0.eContents().get(6);
		private final Keyword cQualifiersReadonlyKeyword_5_1_0_6_0 = (Keyword)cQualifiersAssignment_5_1_0_6.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_7 = (Assignment)cAlternatives_5_1_0.eContents().get(7);
		private final Keyword cQualifiersReadonlyKeyword_5_1_0_7_0 = (Keyword)cQualifiersAssignment_5_1_0_7.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_8 = (Assignment)cAlternatives_5_1_0.eContents().get(8);
		private final Keyword cQualifiersTransientKeyword_5_1_0_8_0 = (Keyword)cQualifiersAssignment_5_1_0_8.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_9 = (Assignment)cAlternatives_5_1_0.eContents().get(9);
		private final Keyword cQualifiersTransientKeyword_5_1_0_9_0 = (Keyword)cQualifiersAssignment_5_1_0_9.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_10 = (Assignment)cAlternatives_5_1_0.eContents().get(10);
		private final Keyword cQualifiersUniqueKeyword_5_1_0_10_0 = (Keyword)cQualifiersAssignment_5_1_0_10.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_11 = (Assignment)cAlternatives_5_1_0.eContents().get(11);
		private final Keyword cQualifiersUniqueKeyword_5_1_0_11_0 = (Keyword)cQualifiersAssignment_5_1_0_11.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_12 = (Assignment)cAlternatives_5_1_0.eContents().get(12);
		private final Keyword cQualifiersUnsettableKeyword_5_1_0_12_0 = (Keyword)cQualifiersAssignment_5_1_0_12.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_13 = (Assignment)cAlternatives_5_1_0.eContents().get(13);
		private final Keyword cQualifiersUnsettableKeyword_5_1_0_13_0 = (Keyword)cQualifiersAssignment_5_1_0_13.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_14 = (Assignment)cAlternatives_5_1_0.eContents().get(14);
		private final Keyword cQualifiersVolatileKeyword_5_1_0_14_0 = (Keyword)cQualifiersAssignment_5_1_0_14.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_15 = (Assignment)cAlternatives_5_1_0.eContents().get(15);
		private final Keyword cQualifiersVolatileKeyword_5_1_0_15_0 = (Keyword)cQualifiersAssignment_5_1_0_15.eContents().get(0);
		private final Keyword cCommaKeyword_5_1_1 = (Keyword)cGroup_5_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_5_2 = (Keyword)cGroup_5.eContents().get(2);
		private final Alternatives cAlternatives_6 = (Alternatives)cGroup.eContents().get(6);
		private final Group cGroup_6_0 = (Group)cAlternatives_6.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_6_0_0 = (Keyword)cGroup_6_0.eContents().get(0);
		private final Alternatives cAlternatives_6_0_1 = (Alternatives)cGroup_6_0.eContents().get(1);
		private final Assignment cOwnedAnnotationsAssignment_6_0_1_0 = (Assignment)cAlternatives_6_0_1.eContents().get(0);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_6_0_1_0_0 = (RuleCall)cOwnedAnnotationsAssignment_6_0_1_0.eContents().get(0);
		private final Group cGroup_6_0_1_1 = (Group)cAlternatives_6_0_1.eContents().get(1);
		private final Keyword cInitialKeyword_6_0_1_1_0 = (Keyword)cGroup_6_0_1_1.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_6_0_1_1_1 = (RuleCall)cGroup_6_0_1_1.eContents().get(1);
		private final Keyword cColonKeyword_6_0_1_1_2 = (Keyword)cGroup_6_0_1_1.eContents().get(2);
		private final Assignment cOwnedDefaultExpressionsAssignment_6_0_1_1_3 = (Assignment)cGroup_6_0_1_1.eContents().get(3);
		private final RuleCall cOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_1_3_0 = (RuleCall)cOwnedDefaultExpressionsAssignment_6_0_1_1_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_6_0_1_1_4 = (Keyword)cGroup_6_0_1_1.eContents().get(4);
		private final Group cGroup_6_0_1_2 = (Group)cAlternatives_6_0_1.eContents().get(2);
		private final Keyword cDerivationKeyword_6_0_1_2_0 = (Keyword)cGroup_6_0_1_2.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_6_0_1_2_1 = (RuleCall)cGroup_6_0_1_2.eContents().get(1);
		private final Keyword cColonKeyword_6_0_1_2_2 = (Keyword)cGroup_6_0_1_2.eContents().get(2);
		private final Assignment cOwnedDefaultExpressionsAssignment_6_0_1_2_3 = (Assignment)cGroup_6_0_1_2.eContents().get(3);
		private final RuleCall cOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_2_3_0 = (RuleCall)cOwnedDefaultExpressionsAssignment_6_0_1_2_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_6_0_1_2_4 = (Keyword)cGroup_6_0_1_2.eContents().get(4);
		private final Keyword cRightCurlyBracketKeyword_6_0_2 = (Keyword)cGroup_6_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_6_1 = (Keyword)cAlternatives_6.eContents().get(1);

		//AttributeCS base::AttributeCS:
		//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		//	'attribute' name=UnrestrictedName (':' ownedType=TypedMultiplicityRefCS)? ('=' default=SINGLE_QUOTED_STRING)? ('{' (
		//	(qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='id' | qualifiers+='!id' | qualifiers+='ordered' |
		//	qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='transient' | qualifiers+=
		//	'!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' |
		//	qualifiers+='volatile' | qualifiers+='!volatile') ','?)+
		//	'}')? ('{' (ownedAnnotations+=AnnotationElementCS
		//	| 'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//	ownedDefaultExpressions+=SpecificationCS? ';')* '}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		//'attribute' name=UnrestrictedName (':' ownedType=TypedMultiplicityRefCS)? ('=' default=SINGLE_QUOTED_STRING)? ('{' (
		//(qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='id' | qualifiers+='!id' | qualifiers+='ordered' |
		//qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='transient' | qualifiers+=
		//'!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' |
		//qualifiers+='volatile' | qualifiers+='!volatile') ','?)+
		//'}')? ('{' (ownedAnnotations+=AnnotationElementCS
		//| 'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';')* '}' | ';')
		public Group getGroup() { return cGroup; }

		//(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//qualifiers+='static' qualifiers+='definition'?
		public Group getGroup_0_0() { return cGroup_0_0; }

		//qualifiers+='static'
		public Assignment getQualifiersAssignment_0_0_0() { return cQualifiersAssignment_0_0_0; }

		//'static'
		public Keyword getQualifiersStaticKeyword_0_0_0_0() { return cQualifiersStaticKeyword_0_0_0_0; }

		//qualifiers+='definition'?
		public Assignment getQualifiersAssignment_0_0_1() { return cQualifiersAssignment_0_0_1; }

		//'definition'
		public Keyword getQualifiersDefinitionKeyword_0_0_1_0() { return cQualifiersDefinitionKeyword_0_0_1_0; }

		//qualifiers+='definition' qualifiers+='static'?
		public Group getGroup_0_1() { return cGroup_0_1; }

		//qualifiers+='definition'
		public Assignment getQualifiersAssignment_0_1_0() { return cQualifiersAssignment_0_1_0; }

		//'definition'
		public Keyword getQualifiersDefinitionKeyword_0_1_0_0() { return cQualifiersDefinitionKeyword_0_1_0_0; }

		//qualifiers+='static'?
		public Assignment getQualifiersAssignment_0_1_1() { return cQualifiersAssignment_0_1_1; }

		//'static'
		public Keyword getQualifiersStaticKeyword_0_1_1_0() { return cQualifiersStaticKeyword_0_1_1_0; }

		//'attribute'
		public Keyword getAttributeKeyword_1() { return cAttributeKeyword_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//(':' ownedType=TypedMultiplicityRefCS)?
		public Group getGroup_3() { return cGroup_3; }

		//':'
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_3_1() { return cOwnedTypeAssignment_3_1; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_1_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_1_0; }

		//('=' default=SINGLE_QUOTED_STRING)?
		public Group getGroup_4() { return cGroup_4; }

		//'='
		public Keyword getEqualsSignKeyword_4_0() { return cEqualsSignKeyword_4_0; }

		//default=SINGLE_QUOTED_STRING
		public Assignment getDefaultAssignment_4_1() { return cDefaultAssignment_4_1; }

		//SINGLE_QUOTED_STRING
		public RuleCall getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0() { return cDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0; }

		//('{' ((qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='id' | qualifiers+='!id' | qualifiers+='ordered' |
		//qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='transient' | qualifiers+=
		//'!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' |
		//qualifiers+='volatile' | qualifiers+='!volatile') ','?)+
		//'}')?
		public Group getGroup_5() { return cGroup_5; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_5_0() { return cLeftCurlyBracketKeyword_5_0; }

		//((qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='id' | qualifiers+='!id' | qualifiers+='ordered' |
		//qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='transient' | qualifiers+=
		//'!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' |
		//qualifiers+='volatile' | qualifiers+='!volatile') ','?)+
		public Group getGroup_5_1() { return cGroup_5_1; }

		//(qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='id' | qualifiers+='!id' | qualifiers+='ordered' |
		//qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='transient' | qualifiers+=
		//'!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' |
		//qualifiers+='volatile' | qualifiers+='!volatile')
		public Alternatives getAlternatives_5_1_0() { return cAlternatives_5_1_0; }

		//qualifiers+='derived'
		public Assignment getQualifiersAssignment_5_1_0_0() { return cQualifiersAssignment_5_1_0_0; }

		//'derived'
		public Keyword getQualifiersDerivedKeyword_5_1_0_0_0() { return cQualifiersDerivedKeyword_5_1_0_0_0; }

		//qualifiers+='!derived'
		public Assignment getQualifiersAssignment_5_1_0_1() { return cQualifiersAssignment_5_1_0_1; }

		//'!derived'
		public Keyword getQualifiersDerivedKeyword_5_1_0_1_0() { return cQualifiersDerivedKeyword_5_1_0_1_0; }

		//qualifiers+='id'
		public Assignment getQualifiersAssignment_5_1_0_2() { return cQualifiersAssignment_5_1_0_2; }

		//'id'
		public Keyword getQualifiersIdKeyword_5_1_0_2_0() { return cQualifiersIdKeyword_5_1_0_2_0; }

		//qualifiers+='!id'
		public Assignment getQualifiersAssignment_5_1_0_3() { return cQualifiersAssignment_5_1_0_3; }

		//'!id'
		public Keyword getQualifiersIdKeyword_5_1_0_3_0() { return cQualifiersIdKeyword_5_1_0_3_0; }

		//qualifiers+='ordered'
		public Assignment getQualifiersAssignment_5_1_0_4() { return cQualifiersAssignment_5_1_0_4; }

		//'ordered'
		public Keyword getQualifiersOrderedKeyword_5_1_0_4_0() { return cQualifiersOrderedKeyword_5_1_0_4_0; }

		//qualifiers+='!ordered'
		public Assignment getQualifiersAssignment_5_1_0_5() { return cQualifiersAssignment_5_1_0_5; }

		//'!ordered'
		public Keyword getQualifiersOrderedKeyword_5_1_0_5_0() { return cQualifiersOrderedKeyword_5_1_0_5_0; }

		//qualifiers+='readonly'
		public Assignment getQualifiersAssignment_5_1_0_6() { return cQualifiersAssignment_5_1_0_6; }

		//'readonly'
		public Keyword getQualifiersReadonlyKeyword_5_1_0_6_0() { return cQualifiersReadonlyKeyword_5_1_0_6_0; }

		//qualifiers+='!readonly'
		public Assignment getQualifiersAssignment_5_1_0_7() { return cQualifiersAssignment_5_1_0_7; }

		//'!readonly'
		public Keyword getQualifiersReadonlyKeyword_5_1_0_7_0() { return cQualifiersReadonlyKeyword_5_1_0_7_0; }

		//qualifiers+='transient'
		public Assignment getQualifiersAssignment_5_1_0_8() { return cQualifiersAssignment_5_1_0_8; }

		//'transient'
		public Keyword getQualifiersTransientKeyword_5_1_0_8_0() { return cQualifiersTransientKeyword_5_1_0_8_0; }

		//qualifiers+='!transient'
		public Assignment getQualifiersAssignment_5_1_0_9() { return cQualifiersAssignment_5_1_0_9; }

		//'!transient'
		public Keyword getQualifiersTransientKeyword_5_1_0_9_0() { return cQualifiersTransientKeyword_5_1_0_9_0; }

		//qualifiers+='unique'
		public Assignment getQualifiersAssignment_5_1_0_10() { return cQualifiersAssignment_5_1_0_10; }

		//'unique'
		public Keyword getQualifiersUniqueKeyword_5_1_0_10_0() { return cQualifiersUniqueKeyword_5_1_0_10_0; }

		//qualifiers+='!unique'
		public Assignment getQualifiersAssignment_5_1_0_11() { return cQualifiersAssignment_5_1_0_11; }

		//'!unique'
		public Keyword getQualifiersUniqueKeyword_5_1_0_11_0() { return cQualifiersUniqueKeyword_5_1_0_11_0; }

		//qualifiers+='unsettable'
		public Assignment getQualifiersAssignment_5_1_0_12() { return cQualifiersAssignment_5_1_0_12; }

		//'unsettable'
		public Keyword getQualifiersUnsettableKeyword_5_1_0_12_0() { return cQualifiersUnsettableKeyword_5_1_0_12_0; }

		//qualifiers+='!unsettable'
		public Assignment getQualifiersAssignment_5_1_0_13() { return cQualifiersAssignment_5_1_0_13; }

		//'!unsettable'
		public Keyword getQualifiersUnsettableKeyword_5_1_0_13_0() { return cQualifiersUnsettableKeyword_5_1_0_13_0; }

		//qualifiers+='volatile'
		public Assignment getQualifiersAssignment_5_1_0_14() { return cQualifiersAssignment_5_1_0_14; }

		//'volatile'
		public Keyword getQualifiersVolatileKeyword_5_1_0_14_0() { return cQualifiersVolatileKeyword_5_1_0_14_0; }

		//qualifiers+='!volatile'
		public Assignment getQualifiersAssignment_5_1_0_15() { return cQualifiersAssignment_5_1_0_15; }

		//'!volatile'
		public Keyword getQualifiersVolatileKeyword_5_1_0_15_0() { return cQualifiersVolatileKeyword_5_1_0_15_0; }

		//','?
		public Keyword getCommaKeyword_5_1_1() { return cCommaKeyword_5_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5_2() { return cRightCurlyBracketKeyword_5_2; }

		//('{' (ownedAnnotations+=AnnotationElementCS
		//| 'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';')* '}' | ';')
		public Alternatives getAlternatives_6() { return cAlternatives_6; }

		//'{' (ownedAnnotations+=AnnotationElementCS
		//| 'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';')* '}'
		public Group getGroup_6_0() { return cGroup_6_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_6_0_0() { return cLeftCurlyBracketKeyword_6_0_0; }

		//(ownedAnnotations+=AnnotationElementCS
		//| 'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';')*
		public Alternatives getAlternatives_6_0_1() { return cAlternatives_6_0_1; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_6_0_1_0() { return cOwnedAnnotationsAssignment_6_0_1_0; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_6_0_1_0_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_6_0_1_0_0; }

		//'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';'
		public Group getGroup_6_0_1_1() { return cGroup_6_0_1_1; }

		//'initial'
		public Keyword getInitialKeyword_6_0_1_1_0() { return cInitialKeyword_6_0_1_1_0; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_6_0_1_1_1() { return cUnrestrictedNameParserRuleCall_6_0_1_1_1; }

		//':'
		public Keyword getColonKeyword_6_0_1_1_2() { return cColonKeyword_6_0_1_1_2; }

		//ownedDefaultExpressions+=SpecificationCS?
		public Assignment getOwnedDefaultExpressionsAssignment_6_0_1_1_3() { return cOwnedDefaultExpressionsAssignment_6_0_1_1_3; }

		//SpecificationCS
		public RuleCall getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_1_3_0() { return cOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_1_3_0; }

		//';'
		public Keyword getSemicolonKeyword_6_0_1_1_4() { return cSemicolonKeyword_6_0_1_1_4; }

		//'derivation' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';'
		public Group getGroup_6_0_1_2() { return cGroup_6_0_1_2; }

		//'derivation'
		public Keyword getDerivationKeyword_6_0_1_2_0() { return cDerivationKeyword_6_0_1_2_0; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_6_0_1_2_1() { return cUnrestrictedNameParserRuleCall_6_0_1_2_1; }

		//':'
		public Keyword getColonKeyword_6_0_1_2_2() { return cColonKeyword_6_0_1_2_2; }

		//ownedDefaultExpressions+=SpecificationCS?
		public Assignment getOwnedDefaultExpressionsAssignment_6_0_1_2_3() { return cOwnedDefaultExpressionsAssignment_6_0_1_2_3; }

		//SpecificationCS
		public RuleCall getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_2_3_0() { return cOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_2_3_0; }

		//';'
		public Keyword getSemicolonKeyword_6_0_1_2_4() { return cSemicolonKeyword_6_0_1_2_4; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_6_0_2() { return cRightCurlyBracketKeyword_6_0_2; }

		//';'
		public Keyword getSemicolonKeyword_6_1() { return cSemicolonKeyword_6_1; }
	}

	public class ClassCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.ClassCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cStructuredClassCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDataTypeCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cEnumerationCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);

		//ClassCS base::ClassCS:
		//	StructuredClassCS | DataTypeCS | EnumerationCS;
		@Override public ParserRule getRule() { return rule; }

		//StructuredClassCS | DataTypeCS | EnumerationCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//StructuredClassCS
		public RuleCall getStructuredClassCSParserRuleCall_0() { return cStructuredClassCSParserRuleCall_0; }

		//DataTypeCS
		public RuleCall getDataTypeCSParserRuleCall_1() { return cDataTypeCSParserRuleCall_1; }

		//EnumerationCS
		public RuleCall getEnumerationCSParserRuleCall_2() { return cEnumerationCSParserRuleCall_2; }
	}

	public class DataTypeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.DataTypeCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsPrimitiveAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsPrimitivePrimitiveKeyword_0_0 = (Keyword)cIsPrimitiveAssignment_0.eContents().get(0);
		private final Keyword cDatatypeKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cOwnedSignatureAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_3_0 = (RuleCall)cOwnedSignatureAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cColonKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cInstanceClassNameAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0 = (RuleCall)cInstanceClassNameAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cLeftCurlyBracketKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Alternatives cAlternatives_5_1 = (Alternatives)cGroup_5.eContents().get(1);
		private final Assignment cIsSerializableAssignment_5_1_0 = (Assignment)cAlternatives_5_1.eContents().get(0);
		private final Keyword cIsSerializableSerializableKeyword_5_1_0_0 = (Keyword)cIsSerializableAssignment_5_1_0.eContents().get(0);
		private final Keyword cSerializableKeyword_5_1_1 = (Keyword)cAlternatives_5_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_5_2 = (Keyword)cGroup_5.eContents().get(2);
		private final Alternatives cAlternatives_6 = (Alternatives)cGroup.eContents().get(6);
		private final Group cGroup_6_0 = (Group)cAlternatives_6.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_6_0_0 = (Keyword)cGroup_6_0.eContents().get(0);
		private final Alternatives cAlternatives_6_0_1 = (Alternatives)cGroup_6_0.eContents().get(1);
		private final Assignment cOwnedAnnotationsAssignment_6_0_1_0 = (Assignment)cAlternatives_6_0_1.eContents().get(0);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_6_0_1_0_0 = (RuleCall)cOwnedAnnotationsAssignment_6_0_1_0.eContents().get(0);
		private final Assignment cOwnedConstraintsAssignment_6_0_1_1 = (Assignment)cAlternatives_6_0_1.eContents().get(1);
		private final RuleCall cOwnedConstraintsInvariantConstraintCSParserRuleCall_6_0_1_1_0 = (RuleCall)cOwnedConstraintsAssignment_6_0_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6_0_2 = (Keyword)cGroup_6_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_6_1 = (Keyword)cAlternatives_6.eContents().get(1);

		//DataTypeCS base::DataTypeCS:
		//	isPrimitive?='primitive'? 'datatype' name=UnrestrictedName
		//	ownedSignature=TemplateSignatureCS? (':' instanceClassName=SINGLE_QUOTED_STRING)? ('{' (isSerializable?=
		//	'serializable' | '!serializable')? '}')? ('{' (ownedAnnotations+=AnnotationElementCS
		//	| ownedConstraints+=InvariantConstraintCS)* '}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//isPrimitive?='primitive'? 'datatype' name=UnrestrictedName
		//ownedSignature=TemplateSignatureCS? (':' instanceClassName=SINGLE_QUOTED_STRING)? ('{' (isSerializable?='serializable' |
		//'!serializable')? '}')? ('{' (ownedAnnotations+=AnnotationElementCS
		//| ownedConstraints+=InvariantConstraintCS)* '}' | ';')
		public Group getGroup() { return cGroup; }

		//isPrimitive?='primitive'?
		public Assignment getIsPrimitiveAssignment_0() { return cIsPrimitiveAssignment_0; }

		//'primitive'
		public Keyword getIsPrimitivePrimitiveKeyword_0_0() { return cIsPrimitivePrimitiveKeyword_0_0; }

		//'datatype'
		public Keyword getDatatypeKeyword_1() { return cDatatypeKeyword_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_3() { return cOwnedSignatureAssignment_3; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_3_0; }

		//(':' instanceClassName=SINGLE_QUOTED_STRING)?
		public Group getGroup_4() { return cGroup_4; }

		//':'
		public Keyword getColonKeyword_4_0() { return cColonKeyword_4_0; }

		//instanceClassName=SINGLE_QUOTED_STRING
		public Assignment getInstanceClassNameAssignment_4_1() { return cInstanceClassNameAssignment_4_1; }

		//SINGLE_QUOTED_STRING
		public RuleCall getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0() { return cInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0; }

		//('{' (isSerializable?='serializable' | '!serializable')? '}')?
		public Group getGroup_5() { return cGroup_5; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_5_0() { return cLeftCurlyBracketKeyword_5_0; }

		//(isSerializable?='serializable' | '!serializable')?
		public Alternatives getAlternatives_5_1() { return cAlternatives_5_1; }

		//isSerializable?='serializable'
		public Assignment getIsSerializableAssignment_5_1_0() { return cIsSerializableAssignment_5_1_0; }

		//'serializable'
		public Keyword getIsSerializableSerializableKeyword_5_1_0_0() { return cIsSerializableSerializableKeyword_5_1_0_0; }

		//'!serializable'
		public Keyword getSerializableKeyword_5_1_1() { return cSerializableKeyword_5_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5_2() { return cRightCurlyBracketKeyword_5_2; }

		//('{' (ownedAnnotations+=AnnotationElementCS
		//| ownedConstraints+=InvariantConstraintCS)* '}' | ';')
		public Alternatives getAlternatives_6() { return cAlternatives_6; }

		//'{' (ownedAnnotations+=AnnotationElementCS
		//| ownedConstraints+=InvariantConstraintCS)* '}'
		public Group getGroup_6_0() { return cGroup_6_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_6_0_0() { return cLeftCurlyBracketKeyword_6_0_0; }

		//(ownedAnnotations+=AnnotationElementCS
		//| ownedConstraints+=InvariantConstraintCS)*
		public Alternatives getAlternatives_6_0_1() { return cAlternatives_6_0_1; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_6_0_1_0() { return cOwnedAnnotationsAssignment_6_0_1_0; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_6_0_1_0_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_6_0_1_0_0; }

		//ownedConstraints+=InvariantConstraintCS
		public Assignment getOwnedConstraintsAssignment_6_0_1_1() { return cOwnedConstraintsAssignment_6_0_1_1; }

		//InvariantConstraintCS
		public RuleCall getOwnedConstraintsInvariantConstraintCSParserRuleCall_6_0_1_1_0() { return cOwnedConstraintsInvariantConstraintCSParserRuleCall_6_0_1_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_6_0_2() { return cRightCurlyBracketKeyword_6_0_2; }

		//';'
		public Keyword getSemicolonKeyword_6_1() { return cSemicolonKeyword_6_1; }
	}

	public class DetailCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.DetailCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Alternatives cNameAlternatives_0_0 = (Alternatives)cNameAssignment_0.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0_0 = (RuleCall)cNameAlternatives_0_0.eContents().get(0);
		private final RuleCall cNameSINGLE_QUOTED_STRINGTerminalRuleCall_0_0_1 = (RuleCall)cNameAlternatives_0_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cValuesAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cValuesAlternatives_2_0 = (Alternatives)cValuesAssignment_2.eContents().get(0);
		private final RuleCall cValuesSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_0 = (RuleCall)cValuesAlternatives_2_0.eContents().get(0);
		private final RuleCall cValuesML_SINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1 = (RuleCall)cValuesAlternatives_2_0.eContents().get(1);

		//DetailCS base::DetailCS:
		//	name=(UnrestrictedName | SINGLE_QUOTED_STRING) '=' values+=(SINGLE_QUOTED_STRING | ML_SINGLE_QUOTED_STRING)*;
		@Override public ParserRule getRule() { return rule; }

		//name=(UnrestrictedName | SINGLE_QUOTED_STRING) '=' values+=(SINGLE_QUOTED_STRING | ML_SINGLE_QUOTED_STRING)*
		public Group getGroup() { return cGroup; }

		//name=(UnrestrictedName | SINGLE_QUOTED_STRING)
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//(UnrestrictedName | SINGLE_QUOTED_STRING)
		public Alternatives getNameAlternatives_0_0() { return cNameAlternatives_0_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0_0; }

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
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.DocumentationCS");
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

	public class EnumerationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.EnumerationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEnumKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cOwnedSignatureAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_2_0 = (RuleCall)cOwnedSignatureAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cInstanceClassNameAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_3_1_0 = (RuleCall)cInstanceClassNameAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cLeftCurlyBracketKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Alternatives cAlternatives_4_1 = (Alternatives)cGroup_4.eContents().get(1);
		private final Assignment cIsSerializableAssignment_4_1_0 = (Assignment)cAlternatives_4_1.eContents().get(0);
		private final Keyword cIsSerializableSerializableKeyword_4_1_0_0 = (Keyword)cIsSerializableAssignment_4_1_0.eContents().get(0);
		private final Keyword cSerializableKeyword_4_1_1 = (Keyword)cAlternatives_4_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Group cGroup_5_0 = (Group)cAlternatives_5.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_5_0_0 = (Keyword)cGroup_5_0.eContents().get(0);
		private final Alternatives cAlternatives_5_0_1 = (Alternatives)cGroup_5_0.eContents().get(1);
		private final Assignment cOwnedAnnotationsAssignment_5_0_1_0 = (Assignment)cAlternatives_5_0_1.eContents().get(0);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_5_0_1_0_0 = (RuleCall)cOwnedAnnotationsAssignment_5_0_1_0.eContents().get(0);
		private final Assignment cOwnedLiteralsAssignment_5_0_1_1 = (Assignment)cAlternatives_5_0_1.eContents().get(1);
		private final RuleCall cOwnedLiteralsEnumerationLiteralCSParserRuleCall_5_0_1_1_0 = (RuleCall)cOwnedLiteralsAssignment_5_0_1_1.eContents().get(0);
		private final Assignment cOwnedConstraintsAssignment_5_0_1_2 = (Assignment)cAlternatives_5_0_1.eContents().get(2);
		private final RuleCall cOwnedConstraintsInvariantConstraintCSParserRuleCall_5_0_1_2_0 = (RuleCall)cOwnedConstraintsAssignment_5_0_1_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5_0_2 = (Keyword)cGroup_5_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_5_1 = (Keyword)cAlternatives_5.eContents().get(1);

		//EnumerationCS base::EnumerationCS:
		//	'enum' name=UnrestrictedName
		//	ownedSignature=TemplateSignatureCS? (':' instanceClassName=SINGLE_QUOTED_STRING)? ('{' (isSerializable?=
		//	'serializable' | '!serializable')? '}')? ('{' (ownedAnnotations+=AnnotationElementCS
		//	| ownedLiterals+=EnumerationLiteralCS
		//	| ownedConstraints+=InvariantConstraintCS)* '}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//'enum' name=UnrestrictedName
		//ownedSignature=TemplateSignatureCS? (':' instanceClassName=SINGLE_QUOTED_STRING)? ('{' (isSerializable?='serializable' |
		//'!serializable')? '}')? ('{' (ownedAnnotations+=AnnotationElementCS
		//| ownedLiterals+=EnumerationLiteralCS
		//| ownedConstraints+=InvariantConstraintCS)* '}' | ';')
		public Group getGroup() { return cGroup; }

		//'enum'
		public Keyword getEnumKeyword_0() { return cEnumKeyword_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0() { return cNameUnrestrictedNameParserRuleCall_1_0; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_2() { return cOwnedSignatureAssignment_2; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_2_0; }

		//(':' instanceClassName=SINGLE_QUOTED_STRING)?
		public Group getGroup_3() { return cGroup_3; }

		//':'
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//instanceClassName=SINGLE_QUOTED_STRING
		public Assignment getInstanceClassNameAssignment_3_1() { return cInstanceClassNameAssignment_3_1; }

		//SINGLE_QUOTED_STRING
		public RuleCall getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_3_1_0() { return cInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_3_1_0; }

		//('{' (isSerializable?='serializable' | '!serializable')? '}')?
		public Group getGroup_4() { return cGroup_4; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_4_0() { return cLeftCurlyBracketKeyword_4_0; }

		//(isSerializable?='serializable' | '!serializable')?
		public Alternatives getAlternatives_4_1() { return cAlternatives_4_1; }

		//isSerializable?='serializable'
		public Assignment getIsSerializableAssignment_4_1_0() { return cIsSerializableAssignment_4_1_0; }

		//'serializable'
		public Keyword getIsSerializableSerializableKeyword_4_1_0_0() { return cIsSerializableSerializableKeyword_4_1_0_0; }

		//'!serializable'
		public Keyword getSerializableKeyword_4_1_1() { return cSerializableKeyword_4_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_4_2() { return cRightCurlyBracketKeyword_4_2; }

		//('{' (ownedAnnotations+=AnnotationElementCS
		//| ownedLiterals+=EnumerationLiteralCS
		//| ownedConstraints+=InvariantConstraintCS)* '}' | ';')
		public Alternatives getAlternatives_5() { return cAlternatives_5; }

		//'{' (ownedAnnotations+=AnnotationElementCS
		//| ownedLiterals+=EnumerationLiteralCS
		//| ownedConstraints+=InvariantConstraintCS)* '}'
		public Group getGroup_5_0() { return cGroup_5_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_5_0_0() { return cLeftCurlyBracketKeyword_5_0_0; }

		//(ownedAnnotations+=AnnotationElementCS
		//| ownedLiterals+=EnumerationLiteralCS
		//| ownedConstraints+=InvariantConstraintCS)*
		public Alternatives getAlternatives_5_0_1() { return cAlternatives_5_0_1; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_5_0_1_0() { return cOwnedAnnotationsAssignment_5_0_1_0; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_5_0_1_0_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_5_0_1_0_0; }

		//ownedLiterals+=EnumerationLiteralCS
		public Assignment getOwnedLiteralsAssignment_5_0_1_1() { return cOwnedLiteralsAssignment_5_0_1_1; }

		//EnumerationLiteralCS
		public RuleCall getOwnedLiteralsEnumerationLiteralCSParserRuleCall_5_0_1_1_0() { return cOwnedLiteralsEnumerationLiteralCSParserRuleCall_5_0_1_1_0; }

		//ownedConstraints+=InvariantConstraintCS
		public Assignment getOwnedConstraintsAssignment_5_0_1_2() { return cOwnedConstraintsAssignment_5_0_1_2; }

		//InvariantConstraintCS
		public RuleCall getOwnedConstraintsInvariantConstraintCSParserRuleCall_5_0_1_2_0() { return cOwnedConstraintsInvariantConstraintCSParserRuleCall_5_0_1_2_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5_0_2() { return cRightCurlyBracketKeyword_5_0_2; }

		//';'
		public Keyword getSemicolonKeyword_5_1() { return cSemicolonKeyword_5_1; }
	}

	public class EnumerationLiteralCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.EnumerationLiteralCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cAlternatives_0.eContents().get(0);
		private final Keyword cLiteralKeyword_0_0_0 = (Keyword)cGroup_0_0.eContents().get(0);
		private final Assignment cNameAssignment_0_0_1 = (Assignment)cGroup_0_0.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0_1_0 = (RuleCall)cNameAssignment_0_0_1.eContents().get(0);
		private final Assignment cNameAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final RuleCall cNameEnumerationLiteralNameParserRuleCall_0_1_0 = (RuleCall)cNameAssignment_0_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cLiteralAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cLiteralSINGLE_QUOTED_STRINGTerminalRuleCall_1_1_0 = (RuleCall)cLiteralAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cEqualsSignKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cValueAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cValueSIGNEDParserRuleCall_2_1_0 = (RuleCall)cValueAssignment_2_1.eContents().get(0);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cAlternatives_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3_0_0 = (Keyword)cGroup_3_0.eContents().get(0);
		private final Assignment cOwnedAnnotationsAssignment_3_0_1 = (Assignment)cGroup_3_0.eContents().get(1);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_3_0_1_0 = (RuleCall)cOwnedAnnotationsAssignment_3_0_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3_0_2 = (Keyword)cGroup_3_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_3_1 = (Keyword)cAlternatives_3.eContents().get(1);

		//EnumerationLiteralCS base::EnumerationLiteralCS:
		//	('literal' name=UnrestrictedName | name=EnumerationLiteralName) (':' literal=SINGLE_QUOTED_STRING)? ('=' value=SIGNED
		//	)? ('{' ownedAnnotations+=AnnotationElementCS* '}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//('literal' name=UnrestrictedName | name=EnumerationLiteralName) (':' literal=SINGLE_QUOTED_STRING)? ('=' value=SIGNED)? (
		//'{' ownedAnnotations+=AnnotationElementCS* '}' | ';')
		public Group getGroup() { return cGroup; }

		//('literal' name=UnrestrictedName | name=EnumerationLiteralName)
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//'literal' name=UnrestrictedName
		public Group getGroup_0_0() { return cGroup_0_0; }

		//'literal'
		public Keyword getLiteralKeyword_0_0_0() { return cLiteralKeyword_0_0_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0_0_1() { return cNameAssignment_0_0_1; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0_1_0() { return cNameUnrestrictedNameParserRuleCall_0_0_1_0; }

		//name=EnumerationLiteralName
		public Assignment getNameAssignment_0_1() { return cNameAssignment_0_1; }

		//EnumerationLiteralName
		public RuleCall getNameEnumerationLiteralNameParserRuleCall_0_1_0() { return cNameEnumerationLiteralNameParserRuleCall_0_1_0; }

		//(':' literal=SINGLE_QUOTED_STRING)?
		public Group getGroup_1() { return cGroup_1; }

		//':'
		public Keyword getColonKeyword_1_0() { return cColonKeyword_1_0; }

		//literal=SINGLE_QUOTED_STRING
		public Assignment getLiteralAssignment_1_1() { return cLiteralAssignment_1_1; }

		//SINGLE_QUOTED_STRING
		public RuleCall getLiteralSINGLE_QUOTED_STRINGTerminalRuleCall_1_1_0() { return cLiteralSINGLE_QUOTED_STRINGTerminalRuleCall_1_1_0; }

		//('=' value=SIGNED)?
		public Group getGroup_2() { return cGroup_2; }

		//'='
		public Keyword getEqualsSignKeyword_2_0() { return cEqualsSignKeyword_2_0; }

		//value=SIGNED
		public Assignment getValueAssignment_2_1() { return cValueAssignment_2_1; }

		//SIGNED
		public RuleCall getValueSIGNEDParserRuleCall_2_1_0() { return cValueSIGNEDParserRuleCall_2_1_0; }

		//('{' ownedAnnotations+=AnnotationElementCS* '}' | ';')
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//'{' ownedAnnotations+=AnnotationElementCS* '}'
		public Group getGroup_3_0() { return cGroup_3_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_3_0_0() { return cLeftCurlyBracketKeyword_3_0_0; }

		//ownedAnnotations+=AnnotationElementCS*
		public Assignment getOwnedAnnotationsAssignment_3_0_1() { return cOwnedAnnotationsAssignment_3_0_1; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_3_0_1_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_3_0_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_3_0_2() { return cRightCurlyBracketKeyword_3_0_2; }

		//';'
		public Keyword getSemicolonKeyword_3_1() { return cSemicolonKeyword_3_1; }
	}

	public class ImportCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.ImportCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cImportKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Keyword cLibraryKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0_0 = (RuleCall)cNameAssignment_1_0.eContents().get(0);
		private final Keyword cColonKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cOwnedPathNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedPathNameURIPathNameCSParserRuleCall_2_0 = (RuleCall)cOwnedPathNameAssignment_2.eContents().get(0);
		private final Assignment cIsAllAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final Keyword cIsAllColonColonAsteriskKeyword_3_0 = (Keyword)cIsAllAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//ImportCS base::ImportCS:
		//	('import' | 'library') (name=UnrestrictedName ':')? ownedPathName=URIPathNameCS isAll?='::*'? ';';
		@Override public ParserRule getRule() { return rule; }

		//('import' | 'library') (name=UnrestrictedName ':')? ownedPathName=URIPathNameCS isAll?='::*'? ';'
		public Group getGroup() { return cGroup; }

		//('import' | 'library')
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//'import'
		public Keyword getImportKeyword_0_0() { return cImportKeyword_0_0; }

		//'library'
		public Keyword getLibraryKeyword_0_1() { return cLibraryKeyword_0_1; }

		//(name=UnrestrictedName ':')?
		public Group getGroup_1() { return cGroup_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_1_0() { return cNameAssignment_1_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0_0() { return cNameUnrestrictedNameParserRuleCall_1_0_0; }

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

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class ModelElementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.ModelElementCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cClassCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cEnumerationLiteralCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cOperationCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cPackageCSParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cStructuralFeatureCSParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);

		//ModelElementCS base::ModelElementCS:
		//	ClassCS | EnumerationLiteralCS | OperationCS | PackageCS | StructuralFeatureCS;
		@Override public ParserRule getRule() { return rule; }

		//ClassCS | EnumerationLiteralCS | OperationCS | PackageCS | StructuralFeatureCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//ClassCS
		public RuleCall getClassCSParserRuleCall_0() { return cClassCSParserRuleCall_0; }

		//EnumerationLiteralCS
		public RuleCall getEnumerationLiteralCSParserRuleCall_1() { return cEnumerationLiteralCSParserRuleCall_1; }

		//OperationCS
		public RuleCall getOperationCSParserRuleCall_2() { return cOperationCSParserRuleCall_2; }

		//PackageCS
		public RuleCall getPackageCSParserRuleCall_3() { return cPackageCSParserRuleCall_3; }

		//StructuralFeatureCS
		public RuleCall getStructuralFeatureCSParserRuleCall_4() { return cStructuralFeatureCSParserRuleCall_4; }
	}

	public class ModelElementRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.ModelElementRefCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cReferenceKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedPathNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedPathNamePathNameCSParserRuleCall_1_0 = (RuleCall)cOwnedPathNameAssignment_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);

		//ModelElementRefCS base::ModelElementRefCS:
		//	'reference' ownedPathName=PathNameCS ';';
		@Override public ParserRule getRule() { return rule; }

		//'reference' ownedPathName=PathNameCS ';'
		public Group getGroup() { return cGroup; }

		//'reference'
		public Keyword getReferenceKeyword_0() { return cReferenceKeyword_0; }

		//ownedPathName=PathNameCS
		public Assignment getOwnedPathNameAssignment_1() { return cOwnedPathNameAssignment_1; }

		//PathNameCS
		public RuleCall getOwnedPathNamePathNameCSParserRuleCall_1_0() { return cOwnedPathNamePathNameCSParserRuleCall_1_0; }

		//';'
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
	}

	public class OperationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.OperationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cAlternatives_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_0_0 = (Assignment)cGroup_0_0.eContents().get(0);
		private final Keyword cQualifiersStaticKeyword_0_0_0_0 = (Keyword)cQualifiersAssignment_0_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_0_1 = (Assignment)cGroup_0_0.eContents().get(1);
		private final Keyword cQualifiersDefinitionKeyword_0_0_1_0 = (Keyword)cQualifiersAssignment_0_0_1.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cAlternatives_0.eContents().get(1);
		private final Assignment cQualifiersAssignment_0_1_0 = (Assignment)cGroup_0_1.eContents().get(0);
		private final Keyword cQualifiersDefinitionKeyword_0_1_0_0 = (Keyword)cQualifiersAssignment_0_1_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final Keyword cQualifiersStaticKeyword_0_1_1_0 = (Keyword)cQualifiersAssignment_0_1_1.eContents().get(0);
		private final Keyword cOperationKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedSignatureAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_2_0 = (RuleCall)cOwnedSignatureAssignment_2.eContents().get(0);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Assignment cOwnedParametersAssignment_5_0 = (Assignment)cGroup_5.eContents().get(0);
		private final RuleCall cOwnedParametersParameterCSParserRuleCall_5_0_0 = (RuleCall)cOwnedParametersAssignment_5_0.eContents().get(0);
		private final Group cGroup_5_1 = (Group)cGroup_5.eContents().get(1);
		private final Keyword cCommaKeyword_5_1_0 = (Keyword)cGroup_5_1.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_5_1_1 = (Assignment)cGroup_5_1.eContents().get(1);
		private final RuleCall cOwnedParametersParameterCSParserRuleCall_5_1_1_0 = (RuleCall)cOwnedParametersAssignment_5_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cColonKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_7_1_0 = (RuleCall)cOwnedTypeAssignment_7_1.eContents().get(0);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cThrowsKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Assignment cOwnedExceptionsAssignment_8_1 = (Assignment)cGroup_8.eContents().get(1);
		private final RuleCall cOwnedExceptionsTypedRefCSParserRuleCall_8_1_0 = (RuleCall)cOwnedExceptionsAssignment_8_1.eContents().get(0);
		private final Group cGroup_8_2 = (Group)cGroup_8.eContents().get(2);
		private final Keyword cCommaKeyword_8_2_0 = (Keyword)cGroup_8_2.eContents().get(0);
		private final Assignment cOwnedExceptionsAssignment_8_2_1 = (Assignment)cGroup_8_2.eContents().get(1);
		private final RuleCall cOwnedExceptionsTypedRefCSParserRuleCall_8_2_1_0 = (RuleCall)cOwnedExceptionsAssignment_8_2_1.eContents().get(0);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cLeftCurlyBracketKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Group cGroup_9_1 = (Group)cGroup_9.eContents().get(1);
		private final Alternatives cAlternatives_9_1_0 = (Alternatives)cGroup_9_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_9_1_0_0 = (Assignment)cAlternatives_9_1_0.eContents().get(0);
		private final Keyword cQualifiersDerivedKeyword_9_1_0_0_0 = (Keyword)cQualifiersAssignment_9_1_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_9_1_0_1 = (Assignment)cAlternatives_9_1_0.eContents().get(1);
		private final Keyword cQualifiersDerivedKeyword_9_1_0_1_0 = (Keyword)cQualifiersAssignment_9_1_0_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_9_1_0_2 = (Assignment)cAlternatives_9_1_0.eContents().get(2);
		private final Keyword cQualifiersOrderedKeyword_9_1_0_2_0 = (Keyword)cQualifiersAssignment_9_1_0_2.eContents().get(0);
		private final Assignment cQualifiersAssignment_9_1_0_3 = (Assignment)cAlternatives_9_1_0.eContents().get(3);
		private final Keyword cQualifiersOrderedKeyword_9_1_0_3_0 = (Keyword)cQualifiersAssignment_9_1_0_3.eContents().get(0);
		private final Assignment cQualifiersAssignment_9_1_0_4 = (Assignment)cAlternatives_9_1_0.eContents().get(4);
		private final Keyword cQualifiersTransientKeyword_9_1_0_4_0 = (Keyword)cQualifiersAssignment_9_1_0_4.eContents().get(0);
		private final Assignment cQualifiersAssignment_9_1_0_5 = (Assignment)cAlternatives_9_1_0.eContents().get(5);
		private final Keyword cQualifiersTransientKeyword_9_1_0_5_0 = (Keyword)cQualifiersAssignment_9_1_0_5.eContents().get(0);
		private final Assignment cQualifiersAssignment_9_1_0_6 = (Assignment)cAlternatives_9_1_0.eContents().get(6);
		private final Keyword cQualifiersUniqueKeyword_9_1_0_6_0 = (Keyword)cQualifiersAssignment_9_1_0_6.eContents().get(0);
		private final Assignment cQualifiersAssignment_9_1_0_7 = (Assignment)cAlternatives_9_1_0.eContents().get(7);
		private final Keyword cQualifiersUniqueKeyword_9_1_0_7_0 = (Keyword)cQualifiersAssignment_9_1_0_7.eContents().get(0);
		private final Keyword cCommaKeyword_9_1_1 = (Keyword)cGroup_9_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_9_2 = (Keyword)cGroup_9.eContents().get(2);
		private final Alternatives cAlternatives_10 = (Alternatives)cGroup.eContents().get(10);
		private final Group cGroup_10_0 = (Group)cAlternatives_10.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_10_0_0 = (Keyword)cGroup_10_0.eContents().get(0);
		private final Alternatives cAlternatives_10_0_1 = (Alternatives)cGroup_10_0.eContents().get(1);
		private final Assignment cOwnedAnnotationsAssignment_10_0_1_0 = (Assignment)cAlternatives_10_0_1.eContents().get(0);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_10_0_1_0_0 = (RuleCall)cOwnedAnnotationsAssignment_10_0_1_0.eContents().get(0);
		private final Assignment cOwnedPreconditionsAssignment_10_0_1_1 = (Assignment)cAlternatives_10_0_1.eContents().get(1);
		private final RuleCall cOwnedPreconditionsPreconditionConstraintCSParserRuleCall_10_0_1_1_0 = (RuleCall)cOwnedPreconditionsAssignment_10_0_1_1.eContents().get(0);
		private final Group cGroup_10_0_1_2 = (Group)cAlternatives_10_0_1.eContents().get(2);
		private final Keyword cBodyKeyword_10_0_1_2_0 = (Keyword)cGroup_10_0_1_2.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_10_0_1_2_1 = (RuleCall)cGroup_10_0_1_2.eContents().get(1);
		private final Keyword cColonKeyword_10_0_1_2_2 = (Keyword)cGroup_10_0_1_2.eContents().get(2);
		private final Assignment cOwnedBodyExpressionsAssignment_10_0_1_2_3 = (Assignment)cGroup_10_0_1_2.eContents().get(3);
		private final RuleCall cOwnedBodyExpressionsSpecificationCSParserRuleCall_10_0_1_2_3_0 = (RuleCall)cOwnedBodyExpressionsAssignment_10_0_1_2_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_10_0_1_2_4 = (Keyword)cGroup_10_0_1_2.eContents().get(4);
		private final Assignment cOwnedPostconditionsAssignment_10_0_1_3 = (Assignment)cAlternatives_10_0_1.eContents().get(3);
		private final RuleCall cOwnedPostconditionsPostconditionConstraintCSParserRuleCall_10_0_1_3_0 = (RuleCall)cOwnedPostconditionsAssignment_10_0_1_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_10_0_2 = (Keyword)cGroup_10_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_10_1 = (Keyword)cAlternatives_10.eContents().get(1);

		//OperationCS base::OperationCS:
		//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		//	'operation' ownedSignature=TemplateSignatureCS? name=UnrestrictedName
		//	'(' (ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)? ')' (':' ownedType=TypedMultiplicityRefCS)? (
		//	'throws' ownedExceptions+=TypedRefCS (',' ownedExceptions+=TypedRefCS)*)? ('{' ((qualifiers+='derived' | qualifiers+=
		//	'!derived' | qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='transient' | qualifiers+='!transient' |
		//	qualifiers+='unique' | qualifiers+='!unique') ','?)+
		//	'}')? ('{' (ownedAnnotations+=AnnotationElementCS
		//	| ownedPreconditions+=PreconditionConstraintCS
		//	| 'body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS? ';' |
		//	ownedPostconditions+=PostconditionConstraintCS)* '}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		//'operation' ownedSignature=TemplateSignatureCS? name=UnrestrictedName
		//'(' (ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)? ')' (':' ownedType=TypedMultiplicityRefCS)? (
		//'throws' ownedExceptions+=TypedRefCS (',' ownedExceptions+=TypedRefCS)*)? ('{' ((qualifiers+='derived' | qualifiers+=
		//'!derived' | qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='transient' | qualifiers+='!transient' |
		//qualifiers+='unique' | qualifiers+='!unique') ','?)+
		//'}')? ('{' (ownedAnnotations+=AnnotationElementCS
		//| ownedPreconditions+=PreconditionConstraintCS
		//| 'body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS? ';' |
		//ownedPostconditions+=PostconditionConstraintCS)* '}' | ';')
		public Group getGroup() { return cGroup; }

		//(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//qualifiers+='static' qualifiers+='definition'?
		public Group getGroup_0_0() { return cGroup_0_0; }

		//qualifiers+='static'
		public Assignment getQualifiersAssignment_0_0_0() { return cQualifiersAssignment_0_0_0; }

		//'static'
		public Keyword getQualifiersStaticKeyword_0_0_0_0() { return cQualifiersStaticKeyword_0_0_0_0; }

		//qualifiers+='definition'?
		public Assignment getQualifiersAssignment_0_0_1() { return cQualifiersAssignment_0_0_1; }

		//'definition'
		public Keyword getQualifiersDefinitionKeyword_0_0_1_0() { return cQualifiersDefinitionKeyword_0_0_1_0; }

		//qualifiers+='definition' qualifiers+='static'?
		public Group getGroup_0_1() { return cGroup_0_1; }

		//qualifiers+='definition'
		public Assignment getQualifiersAssignment_0_1_0() { return cQualifiersAssignment_0_1_0; }

		//'definition'
		public Keyword getQualifiersDefinitionKeyword_0_1_0_0() { return cQualifiersDefinitionKeyword_0_1_0_0; }

		//qualifiers+='static'?
		public Assignment getQualifiersAssignment_0_1_1() { return cQualifiersAssignment_0_1_1; }

		//'static'
		public Keyword getQualifiersStaticKeyword_0_1_1_0() { return cQualifiersStaticKeyword_0_1_1_0; }

		//'operation'
		public Keyword getOperationKeyword_1() { return cOperationKeyword_1; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_2() { return cOwnedSignatureAssignment_2; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_2_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_3_0() { return cNameUnrestrictedNameParserRuleCall_3_0; }

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

		//(':' ownedType=TypedMultiplicityRefCS)?
		public Group getGroup_7() { return cGroup_7; }

		//':'
		public Keyword getColonKeyword_7_0() { return cColonKeyword_7_0; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_7_1() { return cOwnedTypeAssignment_7_1; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_7_1_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_7_1_0; }

		//('throws' ownedExceptions+=TypedRefCS (',' ownedExceptions+=TypedRefCS)*)?
		public Group getGroup_8() { return cGroup_8; }

		//'throws'
		public Keyword getThrowsKeyword_8_0() { return cThrowsKeyword_8_0; }

		//ownedExceptions+=TypedRefCS
		public Assignment getOwnedExceptionsAssignment_8_1() { return cOwnedExceptionsAssignment_8_1; }

		//TypedRefCS
		public RuleCall getOwnedExceptionsTypedRefCSParserRuleCall_8_1_0() { return cOwnedExceptionsTypedRefCSParserRuleCall_8_1_0; }

		//(',' ownedExceptions+=TypedRefCS)*
		public Group getGroup_8_2() { return cGroup_8_2; }

		//','
		public Keyword getCommaKeyword_8_2_0() { return cCommaKeyword_8_2_0; }

		//ownedExceptions+=TypedRefCS
		public Assignment getOwnedExceptionsAssignment_8_2_1() { return cOwnedExceptionsAssignment_8_2_1; }

		//TypedRefCS
		public RuleCall getOwnedExceptionsTypedRefCSParserRuleCall_8_2_1_0() { return cOwnedExceptionsTypedRefCSParserRuleCall_8_2_1_0; }

		//('{' ((qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+=
		//'transient' | qualifiers+='!transient' | qualifiers+='unique' | qualifiers+='!unique') ','?)+
		//'}')?
		public Group getGroup_9() { return cGroup_9; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_9_0() { return cLeftCurlyBracketKeyword_9_0; }

		//((qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+=
		//'transient' | qualifiers+='!transient' | qualifiers+='unique' | qualifiers+='!unique') ','?)+
		public Group getGroup_9_1() { return cGroup_9_1; }

		//(qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+=
		//'transient' | qualifiers+='!transient' | qualifiers+='unique' | qualifiers+='!unique')
		public Alternatives getAlternatives_9_1_0() { return cAlternatives_9_1_0; }

		//qualifiers+='derived'
		public Assignment getQualifiersAssignment_9_1_0_0() { return cQualifiersAssignment_9_1_0_0; }

		//'derived'
		public Keyword getQualifiersDerivedKeyword_9_1_0_0_0() { return cQualifiersDerivedKeyword_9_1_0_0_0; }

		//qualifiers+='!derived'
		public Assignment getQualifiersAssignment_9_1_0_1() { return cQualifiersAssignment_9_1_0_1; }

		//'!derived'
		public Keyword getQualifiersDerivedKeyword_9_1_0_1_0() { return cQualifiersDerivedKeyword_9_1_0_1_0; }

		//qualifiers+='ordered'
		public Assignment getQualifiersAssignment_9_1_0_2() { return cQualifiersAssignment_9_1_0_2; }

		//'ordered'
		public Keyword getQualifiersOrderedKeyword_9_1_0_2_0() { return cQualifiersOrderedKeyword_9_1_0_2_0; }

		//qualifiers+='!ordered'
		public Assignment getQualifiersAssignment_9_1_0_3() { return cQualifiersAssignment_9_1_0_3; }

		//'!ordered'
		public Keyword getQualifiersOrderedKeyword_9_1_0_3_0() { return cQualifiersOrderedKeyword_9_1_0_3_0; }

		//qualifiers+='transient'
		public Assignment getQualifiersAssignment_9_1_0_4() { return cQualifiersAssignment_9_1_0_4; }

		//'transient'
		public Keyword getQualifiersTransientKeyword_9_1_0_4_0() { return cQualifiersTransientKeyword_9_1_0_4_0; }

		//qualifiers+='!transient'
		public Assignment getQualifiersAssignment_9_1_0_5() { return cQualifiersAssignment_9_1_0_5; }

		//'!transient'
		public Keyword getQualifiersTransientKeyword_9_1_0_5_0() { return cQualifiersTransientKeyword_9_1_0_5_0; }

		//qualifiers+='unique'
		public Assignment getQualifiersAssignment_9_1_0_6() { return cQualifiersAssignment_9_1_0_6; }

		//'unique'
		public Keyword getQualifiersUniqueKeyword_9_1_0_6_0() { return cQualifiersUniqueKeyword_9_1_0_6_0; }

		//qualifiers+='!unique'
		public Assignment getQualifiersAssignment_9_1_0_7() { return cQualifiersAssignment_9_1_0_7; }

		//'!unique'
		public Keyword getQualifiersUniqueKeyword_9_1_0_7_0() { return cQualifiersUniqueKeyword_9_1_0_7_0; }

		//','?
		public Keyword getCommaKeyword_9_1_1() { return cCommaKeyword_9_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_9_2() { return cRightCurlyBracketKeyword_9_2; }

		//('{' (ownedAnnotations+=AnnotationElementCS
		//| ownedPreconditions+=PreconditionConstraintCS
		//| 'body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS? ';' |
		//ownedPostconditions+=PostconditionConstraintCS)* '}' | ';')
		public Alternatives getAlternatives_10() { return cAlternatives_10; }

		//'{' (ownedAnnotations+=AnnotationElementCS
		//| ownedPreconditions+=PreconditionConstraintCS
		//| 'body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS? ';' |
		//ownedPostconditions+=PostconditionConstraintCS)* '}'
		public Group getGroup_10_0() { return cGroup_10_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_10_0_0() { return cLeftCurlyBracketKeyword_10_0_0; }

		//(ownedAnnotations+=AnnotationElementCS
		//| ownedPreconditions+=PreconditionConstraintCS
		//| 'body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS? ';' |
		//ownedPostconditions+=PostconditionConstraintCS)*
		public Alternatives getAlternatives_10_0_1() { return cAlternatives_10_0_1; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_10_0_1_0() { return cOwnedAnnotationsAssignment_10_0_1_0; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_10_0_1_0_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_10_0_1_0_0; }

		//ownedPreconditions+=PreconditionConstraintCS
		public Assignment getOwnedPreconditionsAssignment_10_0_1_1() { return cOwnedPreconditionsAssignment_10_0_1_1; }

		//PreconditionConstraintCS
		public RuleCall getOwnedPreconditionsPreconditionConstraintCSParserRuleCall_10_0_1_1_0() { return cOwnedPreconditionsPreconditionConstraintCSParserRuleCall_10_0_1_1_0; }

		//'body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS? ';'
		public Group getGroup_10_0_1_2() { return cGroup_10_0_1_2; }

		//'body'
		public Keyword getBodyKeyword_10_0_1_2_0() { return cBodyKeyword_10_0_1_2_0; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_10_0_1_2_1() { return cUnrestrictedNameParserRuleCall_10_0_1_2_1; }

		//':'
		public Keyword getColonKeyword_10_0_1_2_2() { return cColonKeyword_10_0_1_2_2; }

		//ownedBodyExpressions+=SpecificationCS?
		public Assignment getOwnedBodyExpressionsAssignment_10_0_1_2_3() { return cOwnedBodyExpressionsAssignment_10_0_1_2_3; }

		//SpecificationCS
		public RuleCall getOwnedBodyExpressionsSpecificationCSParserRuleCall_10_0_1_2_3_0() { return cOwnedBodyExpressionsSpecificationCSParserRuleCall_10_0_1_2_3_0; }

		//';'
		public Keyword getSemicolonKeyword_10_0_1_2_4() { return cSemicolonKeyword_10_0_1_2_4; }

		//ownedPostconditions+=PostconditionConstraintCS
		public Assignment getOwnedPostconditionsAssignment_10_0_1_3() { return cOwnedPostconditionsAssignment_10_0_1_3; }

		//PostconditionConstraintCS
		public RuleCall getOwnedPostconditionsPostconditionConstraintCSParserRuleCall_10_0_1_3_0() { return cOwnedPostconditionsPostconditionConstraintCSParserRuleCall_10_0_1_3_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_10_0_2() { return cRightCurlyBracketKeyword_10_0_2; }

		//';'
		public Keyword getSemicolonKeyword_10_1() { return cSemicolonKeyword_10_1; }
	}

	public class PackageCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.PackageCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPackageKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cNsPrefixAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cNsPrefixUnrestrictedNameParserRuleCall_2_1_0 = (RuleCall)cNsPrefixAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cEqualsSignKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cNsURIAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cNsURIURIParserRuleCall_3_1_0 = (RuleCall)cNsURIAssignment_3_1.eContents().get(0);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Group cGroup_4_0 = (Group)cAlternatives_4.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4_0_0 = (Keyword)cGroup_4_0.eContents().get(0);
		private final Alternatives cAlternatives_4_0_1 = (Alternatives)cGroup_4_0.eContents().get(1);
		private final Assignment cOwnedAnnotationsAssignment_4_0_1_0 = (Assignment)cAlternatives_4_0_1.eContents().get(0);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_4_0_1_0_0 = (RuleCall)cOwnedAnnotationsAssignment_4_0_1_0.eContents().get(0);
		private final Assignment cOwnedPackagesAssignment_4_0_1_1 = (Assignment)cAlternatives_4_0_1.eContents().get(1);
		private final RuleCall cOwnedPackagesPackageCSParserRuleCall_4_0_1_1_0 = (RuleCall)cOwnedPackagesAssignment_4_0_1_1.eContents().get(0);
		private final Assignment cOwnedClassesAssignment_4_0_1_2 = (Assignment)cAlternatives_4_0_1.eContents().get(2);
		private final RuleCall cOwnedClassesClassCSParserRuleCall_4_0_1_2_0 = (RuleCall)cOwnedClassesAssignment_4_0_1_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4_0_2 = (Keyword)cGroup_4_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_4_1 = (Keyword)cAlternatives_4.eContents().get(1);

		//PackageCS base::PackageCS:
		//	'package' name=UnrestrictedName (':' nsPrefix=UnrestrictedName)? ('=' nsURI=URI)? ('{'
		//	(ownedAnnotations+=AnnotationElementCS | ownedPackages+=PackageCS | ownedClasses+=ClassCS)*
		//	'}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//'package' name=UnrestrictedName (':' nsPrefix=UnrestrictedName)? ('=' nsURI=URI)? ('{'
		//(ownedAnnotations+=AnnotationElementCS | ownedPackages+=PackageCS | ownedClasses+=ClassCS)*
		//'}' | ';')
		public Group getGroup() { return cGroup; }

		//'package'
		public Keyword getPackageKeyword_0() { return cPackageKeyword_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0() { return cNameUnrestrictedNameParserRuleCall_1_0; }

		//(':' nsPrefix=UnrestrictedName)?
		public Group getGroup_2() { return cGroup_2; }

		//':'
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//nsPrefix=UnrestrictedName
		public Assignment getNsPrefixAssignment_2_1() { return cNsPrefixAssignment_2_1; }

		//UnrestrictedName
		public RuleCall getNsPrefixUnrestrictedNameParserRuleCall_2_1_0() { return cNsPrefixUnrestrictedNameParserRuleCall_2_1_0; }

		//('=' nsURI=URI)?
		public Group getGroup_3() { return cGroup_3; }

		//'='
		public Keyword getEqualsSignKeyword_3_0() { return cEqualsSignKeyword_3_0; }

		//nsURI=URI
		public Assignment getNsURIAssignment_3_1() { return cNsURIAssignment_3_1; }

		//URI
		public RuleCall getNsURIURIParserRuleCall_3_1_0() { return cNsURIURIParserRuleCall_3_1_0; }

		//('{' (ownedAnnotations+=AnnotationElementCS | ownedPackages+=PackageCS | ownedClasses+=ClassCS)*
		//'}' | ';')
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//'{' (ownedAnnotations+=AnnotationElementCS | ownedPackages+=PackageCS | ownedClasses+=ClassCS)*
		//'}'
		public Group getGroup_4_0() { return cGroup_4_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_4_0_0() { return cLeftCurlyBracketKeyword_4_0_0; }

		//(ownedAnnotations+=AnnotationElementCS | ownedPackages+=PackageCS | ownedClasses+=ClassCS)*
		public Alternatives getAlternatives_4_0_1() { return cAlternatives_4_0_1; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_4_0_1_0() { return cOwnedAnnotationsAssignment_4_0_1_0; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_4_0_1_0_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_4_0_1_0_0; }

		//ownedPackages+=PackageCS
		public Assignment getOwnedPackagesAssignment_4_0_1_1() { return cOwnedPackagesAssignment_4_0_1_1; }

		//PackageCS
		public RuleCall getOwnedPackagesPackageCSParserRuleCall_4_0_1_1_0() { return cOwnedPackagesPackageCSParserRuleCall_4_0_1_1_0; }

		//ownedClasses+=ClassCS
		public Assignment getOwnedClassesAssignment_4_0_1_2() { return cOwnedClassesAssignment_4_0_1_2; }

		//ClassCS
		public RuleCall getOwnedClassesClassCSParserRuleCall_4_0_1_2_0() { return cOwnedClassesClassCSParserRuleCall_4_0_1_2_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_4_0_2() { return cRightCurlyBracketKeyword_4_0_2; }

		//';'
		public Keyword getSemicolonKeyword_4_1() { return cSemicolonKeyword_4_1; }
	}

	public class ParameterCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.ParameterCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_1_1_0 = (RuleCall)cOwnedTypeAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftCurlyBracketKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Alternatives cAlternatives_2_1_0 = (Alternatives)cGroup_2_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_2_1_0_0 = (Assignment)cAlternatives_2_1_0.eContents().get(0);
		private final Keyword cQualifiersOrderedKeyword_2_1_0_0_0 = (Keyword)cQualifiersAssignment_2_1_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_2_1_0_1 = (Assignment)cAlternatives_2_1_0.eContents().get(1);
		private final Keyword cQualifiersOrderedKeyword_2_1_0_1_0 = (Keyword)cQualifiersAssignment_2_1_0_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_2_1_0_2 = (Assignment)cAlternatives_2_1_0.eContents().get(2);
		private final Keyword cQualifiersUniqueKeyword_2_1_0_2_0 = (Keyword)cQualifiersAssignment_2_1_0_2.eContents().get(0);
		private final Assignment cQualifiersAssignment_2_1_0_3 = (Assignment)cAlternatives_2_1_0.eContents().get(3);
		private final Keyword cQualifiersUniqueKeyword_2_1_0_3_0 = (Keyword)cQualifiersAssignment_2_1_0_3.eContents().get(0);
		private final Keyword cCommaKeyword_2_1_1 = (Keyword)cGroup_2_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLeftCurlyBracketKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cOwnedAnnotationsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_3_1_0 = (RuleCall)cOwnedAnnotationsAssignment_3_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);

		//ParameterCS base::ParameterCS:
		//	name=UnrestrictedName (':' ownedType=TypedMultiplicityRefCS)? ('{' ((qualifiers+='ordered' | qualifiers+='!ordered' |
		//	qualifiers+='unique' | qualifiers+='!unique') ','?)+
		//	'}')? ('{' ownedAnnotations+=AnnotationElementCS* '}')?;
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName (':' ownedType=TypedMultiplicityRefCS)? ('{' ((qualifiers+='ordered' | qualifiers+='!ordered' |
		//qualifiers+='unique' | qualifiers+='!unique') ','?)+
		//'}')? ('{' ownedAnnotations+=AnnotationElementCS* '}')?
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//(':' ownedType=TypedMultiplicityRefCS)?
		public Group getGroup_1() { return cGroup_1; }

		//':'
		public Keyword getColonKeyword_1_0() { return cColonKeyword_1_0; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_1_1() { return cOwnedTypeAssignment_1_1; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_1_1_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_1_1_0; }

		//('{' ((qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' | qualifiers+='!unique') ','?)+
		//'}')?
		public Group getGroup_2() { return cGroup_2; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_0() { return cLeftCurlyBracketKeyword_2_0; }

		//((qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' | qualifiers+='!unique') ','?)+
		public Group getGroup_2_1() { return cGroup_2_1; }

		//(qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' | qualifiers+='!unique')
		public Alternatives getAlternatives_2_1_0() { return cAlternatives_2_1_0; }

		//qualifiers+='ordered'
		public Assignment getQualifiersAssignment_2_1_0_0() { return cQualifiersAssignment_2_1_0_0; }

		//'ordered'
		public Keyword getQualifiersOrderedKeyword_2_1_0_0_0() { return cQualifiersOrderedKeyword_2_1_0_0_0; }

		//qualifiers+='!ordered'
		public Assignment getQualifiersAssignment_2_1_0_1() { return cQualifiersAssignment_2_1_0_1; }

		//'!ordered'
		public Keyword getQualifiersOrderedKeyword_2_1_0_1_0() { return cQualifiersOrderedKeyword_2_1_0_1_0; }

		//qualifiers+='unique'
		public Assignment getQualifiersAssignment_2_1_0_2() { return cQualifiersAssignment_2_1_0_2; }

		//'unique'
		public Keyword getQualifiersUniqueKeyword_2_1_0_2_0() { return cQualifiersUniqueKeyword_2_1_0_2_0; }

		//qualifiers+='!unique'
		public Assignment getQualifiersAssignment_2_1_0_3() { return cQualifiersAssignment_2_1_0_3; }

		//'!unique'
		public Keyword getQualifiersUniqueKeyword_2_1_0_3_0() { return cQualifiersUniqueKeyword_2_1_0_3_0; }

		//','?
		public Keyword getCommaKeyword_2_1_1() { return cCommaKeyword_2_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_2_2() { return cRightCurlyBracketKeyword_2_2; }

		//('{' ownedAnnotations+=AnnotationElementCS* '}')?
		public Group getGroup_3() { return cGroup_3; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_3_0() { return cLeftCurlyBracketKeyword_3_0; }

		//ownedAnnotations+=AnnotationElementCS*
		public Assignment getOwnedAnnotationsAssignment_3_1() { return cOwnedAnnotationsAssignment_3_1; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_3_1_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_3_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_3_2() { return cRightCurlyBracketKeyword_3_2; }
	}

	public class ImplicitOppositeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.ImplicitOppositeCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cOppositeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_0 = (RuleCall)cOwnedTypeAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cLeftCurlyBracketKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cGroup_4.eContents().get(1);
		private final Alternatives cAlternatives_4_1_0 = (Alternatives)cGroup_4_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_4_1_0_0 = (Assignment)cAlternatives_4_1_0.eContents().get(0);
		private final Keyword cQualifiersOrderedKeyword_4_1_0_0_0 = (Keyword)cQualifiersAssignment_4_1_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_4_1_0_1 = (Assignment)cAlternatives_4_1_0.eContents().get(1);
		private final Keyword cQualifiersOrderedKeyword_4_1_0_1_0 = (Keyword)cQualifiersAssignment_4_1_0_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_4_1_0_2 = (Assignment)cAlternatives_4_1_0.eContents().get(2);
		private final Keyword cQualifiersUniqueKeyword_4_1_0_2_0 = (Keyword)cQualifiersAssignment_4_1_0_2.eContents().get(0);
		private final Assignment cQualifiersAssignment_4_1_0_3 = (Assignment)cAlternatives_4_1_0.eContents().get(3);
		private final Keyword cQualifiersUniqueKeyword_4_1_0_3_0 = (Keyword)cQualifiersAssignment_4_1_0_3.eContents().get(0);
		private final Keyword cCommaKeyword_4_1_1 = (Keyword)cGroup_4_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);

		//ImplicitOppositeCS base::ImplicitOppositeCS:
		//	'opposite' name=UnrestrictedName
		//	':' ownedType=TypedMultiplicityRefCS ('{' ((qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' |
		//	qualifiers+='!unique') ','?)+
		//	'}')?;
		@Override public ParserRule getRule() { return rule; }

		//'opposite' name=UnrestrictedName
		//':' ownedType=TypedMultiplicityRefCS ('{' ((qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' |
		//qualifiers+='!unique') ','?)+
		//'}')?
		public Group getGroup() { return cGroup; }

		//'opposite'
		public Keyword getOppositeKeyword_0() { return cOppositeKeyword_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0() { return cNameUnrestrictedNameParserRuleCall_1_0; }

		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_3() { return cOwnedTypeAssignment_3; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_0; }

		//('{' ((qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' | qualifiers+='!unique') ','?)+
		//'}')?
		public Group getGroup_4() { return cGroup_4; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_4_0() { return cLeftCurlyBracketKeyword_4_0; }

		//((qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' | qualifiers+='!unique') ','?)+
		public Group getGroup_4_1() { return cGroup_4_1; }

		//(qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' | qualifiers+='!unique')
		public Alternatives getAlternatives_4_1_0() { return cAlternatives_4_1_0; }

		//qualifiers+='ordered'
		public Assignment getQualifiersAssignment_4_1_0_0() { return cQualifiersAssignment_4_1_0_0; }

		//'ordered'
		public Keyword getQualifiersOrderedKeyword_4_1_0_0_0() { return cQualifiersOrderedKeyword_4_1_0_0_0; }

		//qualifiers+='!ordered'
		public Assignment getQualifiersAssignment_4_1_0_1() { return cQualifiersAssignment_4_1_0_1; }

		//'!ordered'
		public Keyword getQualifiersOrderedKeyword_4_1_0_1_0() { return cQualifiersOrderedKeyword_4_1_0_1_0; }

		//qualifiers+='unique'
		public Assignment getQualifiersAssignment_4_1_0_2() { return cQualifiersAssignment_4_1_0_2; }

		//'unique'
		public Keyword getQualifiersUniqueKeyword_4_1_0_2_0() { return cQualifiersUniqueKeyword_4_1_0_2_0; }

		//qualifiers+='!unique'
		public Assignment getQualifiersAssignment_4_1_0_3() { return cQualifiersAssignment_4_1_0_3; }

		//'!unique'
		public Keyword getQualifiersUniqueKeyword_4_1_0_3_0() { return cQualifiersUniqueKeyword_4_1_0_3_0; }

		//','?
		public Keyword getCommaKeyword_4_1_1() { return cCommaKeyword_4_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_4_2() { return cRightCurlyBracketKeyword_4_2; }
	}

	public class ReferenceCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.ReferenceCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cAlternatives_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_0_0 = (Assignment)cGroup_0_0.eContents().get(0);
		private final Keyword cQualifiersStaticKeyword_0_0_0_0 = (Keyword)cQualifiersAssignment_0_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_0_1 = (Assignment)cGroup_0_0.eContents().get(1);
		private final Keyword cQualifiersDefinitionKeyword_0_0_1_0 = (Keyword)cQualifiersAssignment_0_0_1.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cAlternatives_0.eContents().get(1);
		private final Assignment cQualifiersAssignment_0_1_0 = (Assignment)cGroup_0_1.eContents().get(0);
		private final Keyword cQualifiersDefinitionKeyword_0_1_0_0 = (Keyword)cQualifiersAssignment_0_1_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final Keyword cQualifiersStaticKeyword_0_1_1_0 = (Keyword)cQualifiersAssignment_0_1_1.eContents().get(0);
		private final Keyword cPropertyKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cNumberSignKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cReferredOppositeAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final CrossReference cReferredOppositePropertyCrossReference_3_1_0 = (CrossReference)cReferredOppositeAssignment_3_1.eContents().get(0);
		private final RuleCall cReferredOppositePropertyUnrestrictedNameParserRuleCall_3_1_0_1 = (RuleCall)cReferredOppositePropertyCrossReference_3_1_0.eContents().get(1);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cColonKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_1_0 = (RuleCall)cOwnedTypeAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cEqualsSignKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cDefaultAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0 = (RuleCall)cDefaultAssignment_5_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cLeftCurlyBracketKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Group cGroup_6_1 = (Group)cGroup_6.eContents().get(1);
		private final Alternatives cAlternatives_6_1_0 = (Alternatives)cGroup_6_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_0 = (Assignment)cAlternatives_6_1_0.eContents().get(0);
		private final Keyword cQualifiersComposesKeyword_6_1_0_0_0 = (Keyword)cQualifiersAssignment_6_1_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_1 = (Assignment)cAlternatives_6_1_0.eContents().get(1);
		private final Keyword cQualifiersComposesKeyword_6_1_0_1_0 = (Keyword)cQualifiersAssignment_6_1_0_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_2 = (Assignment)cAlternatives_6_1_0.eContents().get(2);
		private final Keyword cQualifiersDerivedKeyword_6_1_0_2_0 = (Keyword)cQualifiersAssignment_6_1_0_2.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_3 = (Assignment)cAlternatives_6_1_0.eContents().get(3);
		private final Keyword cQualifiersDerivedKeyword_6_1_0_3_0 = (Keyword)cQualifiersAssignment_6_1_0_3.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_4 = (Assignment)cAlternatives_6_1_0.eContents().get(4);
		private final Keyword cQualifiersOrderedKeyword_6_1_0_4_0 = (Keyword)cQualifiersAssignment_6_1_0_4.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_5 = (Assignment)cAlternatives_6_1_0.eContents().get(5);
		private final Keyword cQualifiersOrderedKeyword_6_1_0_5_0 = (Keyword)cQualifiersAssignment_6_1_0_5.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_6 = (Assignment)cAlternatives_6_1_0.eContents().get(6);
		private final Keyword cQualifiersReadonlyKeyword_6_1_0_6_0 = (Keyword)cQualifiersAssignment_6_1_0_6.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_7 = (Assignment)cAlternatives_6_1_0.eContents().get(7);
		private final Keyword cQualifiersReadonlyKeyword_6_1_0_7_0 = (Keyword)cQualifiersAssignment_6_1_0_7.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_8 = (Assignment)cAlternatives_6_1_0.eContents().get(8);
		private final Keyword cQualifiersResolveKeyword_6_1_0_8_0 = (Keyword)cQualifiersAssignment_6_1_0_8.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_9 = (Assignment)cAlternatives_6_1_0.eContents().get(9);
		private final Keyword cQualifiersResolveKeyword_6_1_0_9_0 = (Keyword)cQualifiersAssignment_6_1_0_9.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_10 = (Assignment)cAlternatives_6_1_0.eContents().get(10);
		private final Keyword cQualifiersTransientKeyword_6_1_0_10_0 = (Keyword)cQualifiersAssignment_6_1_0_10.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_11 = (Assignment)cAlternatives_6_1_0.eContents().get(11);
		private final Keyword cQualifiersTransientKeyword_6_1_0_11_0 = (Keyword)cQualifiersAssignment_6_1_0_11.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_12 = (Assignment)cAlternatives_6_1_0.eContents().get(12);
		private final Keyword cQualifiersUniqueKeyword_6_1_0_12_0 = (Keyword)cQualifiersAssignment_6_1_0_12.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_13 = (Assignment)cAlternatives_6_1_0.eContents().get(13);
		private final Keyword cQualifiersUniqueKeyword_6_1_0_13_0 = (Keyword)cQualifiersAssignment_6_1_0_13.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_14 = (Assignment)cAlternatives_6_1_0.eContents().get(14);
		private final Keyword cQualifiersUnsettableKeyword_6_1_0_14_0 = (Keyword)cQualifiersAssignment_6_1_0_14.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_15 = (Assignment)cAlternatives_6_1_0.eContents().get(15);
		private final Keyword cQualifiersUnsettableKeyword_6_1_0_15_0 = (Keyword)cQualifiersAssignment_6_1_0_15.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_16 = (Assignment)cAlternatives_6_1_0.eContents().get(16);
		private final Keyword cQualifiersVolatileKeyword_6_1_0_16_0 = (Keyword)cQualifiersAssignment_6_1_0_16.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_17 = (Assignment)cAlternatives_6_1_0.eContents().get(17);
		private final Keyword cQualifiersVolatileKeyword_6_1_0_17_0 = (Keyword)cQualifiersAssignment_6_1_0_17.eContents().get(0);
		private final Keyword cCommaKeyword_6_1_1 = (Keyword)cGroup_6_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_6_2 = (Keyword)cGroup_6.eContents().get(2);
		private final Alternatives cAlternatives_7 = (Alternatives)cGroup.eContents().get(7);
		private final Group cGroup_7_0 = (Group)cAlternatives_7.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_7_0_0 = (Keyword)cGroup_7_0.eContents().get(0);
		private final Alternatives cAlternatives_7_0_1 = (Alternatives)cGroup_7_0.eContents().get(1);
		private final Assignment cOwnedAnnotationsAssignment_7_0_1_0 = (Assignment)cAlternatives_7_0_1.eContents().get(0);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0 = (RuleCall)cOwnedAnnotationsAssignment_7_0_1_0.eContents().get(0);
		private final Group cGroup_7_0_1_1 = (Group)cAlternatives_7_0_1.eContents().get(1);
		private final Keyword cKeyKeyword_7_0_1_1_0 = (Keyword)cGroup_7_0_1_1.eContents().get(0);
		private final Assignment cReferredKeysAssignment_7_0_1_1_1 = (Assignment)cGroup_7_0_1_1.eContents().get(1);
		private final CrossReference cReferredKeysPropertyCrossReference_7_0_1_1_1_0 = (CrossReference)cReferredKeysAssignment_7_0_1_1_1.eContents().get(0);
		private final RuleCall cReferredKeysPropertyUnrestrictedNameParserRuleCall_7_0_1_1_1_0_1 = (RuleCall)cReferredKeysPropertyCrossReference_7_0_1_1_1_0.eContents().get(1);
		private final Group cGroup_7_0_1_1_2 = (Group)cGroup_7_0_1_1.eContents().get(2);
		private final Keyword cCommaKeyword_7_0_1_1_2_0 = (Keyword)cGroup_7_0_1_1_2.eContents().get(0);
		private final Assignment cReferredKeysAssignment_7_0_1_1_2_1 = (Assignment)cGroup_7_0_1_1_2.eContents().get(1);
		private final CrossReference cReferredKeysPropertyCrossReference_7_0_1_1_2_1_0 = (CrossReference)cReferredKeysAssignment_7_0_1_1_2_1.eContents().get(0);
		private final RuleCall cReferredKeysPropertyUnrestrictedNameParserRuleCall_7_0_1_1_2_1_0_1 = (RuleCall)cReferredKeysPropertyCrossReference_7_0_1_1_2_1_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_7_0_1_1_3 = (Keyword)cGroup_7_0_1_1.eContents().get(3);
		private final Group cGroup_7_0_1_2 = (Group)cAlternatives_7_0_1.eContents().get(2);
		private final Keyword cInitialKeyword_7_0_1_2_0 = (Keyword)cGroup_7_0_1_2.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_7_0_1_2_1 = (RuleCall)cGroup_7_0_1_2.eContents().get(1);
		private final Keyword cColonKeyword_7_0_1_2_2 = (Keyword)cGroup_7_0_1_2.eContents().get(2);
		private final Assignment cOwnedDefaultExpressionsAssignment_7_0_1_2_3 = (Assignment)cGroup_7_0_1_2.eContents().get(3);
		private final RuleCall cOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_2_3_0 = (RuleCall)cOwnedDefaultExpressionsAssignment_7_0_1_2_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_7_0_1_2_4 = (Keyword)cGroup_7_0_1_2.eContents().get(4);
		private final Group cGroup_7_0_1_3 = (Group)cAlternatives_7_0_1.eContents().get(3);
		private final Keyword cDerivationKeyword_7_0_1_3_0 = (Keyword)cGroup_7_0_1_3.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_7_0_1_3_1 = (RuleCall)cGroup_7_0_1_3.eContents().get(1);
		private final Keyword cColonKeyword_7_0_1_3_2 = (Keyword)cGroup_7_0_1_3.eContents().get(2);
		private final Assignment cOwnedDefaultExpressionsAssignment_7_0_1_3_3 = (Assignment)cGroup_7_0_1_3.eContents().get(3);
		private final RuleCall cOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_3_3_0 = (RuleCall)cOwnedDefaultExpressionsAssignment_7_0_1_3_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_7_0_1_3_4 = (Keyword)cGroup_7_0_1_3.eContents().get(4);
		private final Group cGroup_7_0_1_4 = (Group)cAlternatives_7_0_1.eContents().get(4);
		private final Assignment cOwnedImplicitOppositesAssignment_7_0_1_4_0 = (Assignment)cGroup_7_0_1_4.eContents().get(0);
		private final RuleCall cOwnedImplicitOppositesImplicitOppositeCSParserRuleCall_7_0_1_4_0_0 = (RuleCall)cOwnedImplicitOppositesAssignment_7_0_1_4_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_7_0_1_4_1 = (Keyword)cGroup_7_0_1_4.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7_0_2 = (Keyword)cGroup_7_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_7_1 = (Keyword)cAlternatives_7.eContents().get(1);

		//ReferenceCS base::ReferenceCS:
		//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		//	'property' name=UnrestrictedName ('#' referredOpposite=[pivot::Property|UnrestrictedName])? (':'
		//	ownedType=TypedMultiplicityRefCS)? ('=' default=SINGLE_QUOTED_STRING)? ('{' ((qualifiers+='composes' | qualifiers+=
		//	'!composes' | qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' | qualifiers+='!ordered' |
		//	qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='resolve' | qualifiers+='!resolve' | qualifiers+=
		//	'transient' | qualifiers+='!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' |
		//	qualifiers+='!unsettable' | qualifiers+='volatile' | qualifiers+='!volatile') ','?)+
		//	'}')? ('{' (ownedAnnotations+=AnnotationElementCS
		//	| 'key' referredKeys+=[pivot::Property|UnrestrictedName] (',' referredKeys+=[pivot::Property|UnrestrictedName])* ';'
		//	| 'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//	ownedDefaultExpressions+=SpecificationCS? ';' | ownedImplicitOpposites+=ImplicitOppositeCS ';')* '}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		//'property' name=UnrestrictedName ('#' referredOpposite=[pivot::Property|UnrestrictedName])? (':'
		//ownedType=TypedMultiplicityRefCS)? ('=' default=SINGLE_QUOTED_STRING)? ('{' ((qualifiers+='composes' | qualifiers+=
		//'!composes' | qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' | qualifiers+='!ordered' |
		//qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='resolve' | qualifiers+='!resolve' | qualifiers+=
		//'transient' | qualifiers+='!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' |
		//qualifiers+='!unsettable' | qualifiers+='volatile' | qualifiers+='!volatile') ','?)+
		//'}')? ('{' (ownedAnnotations+=AnnotationElementCS
		//| 'key' referredKeys+=[pivot::Property|UnrestrictedName] (',' referredKeys+=[pivot::Property|UnrestrictedName])* ';' |
		//'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';' | ownedImplicitOpposites+=ImplicitOppositeCS ';')* '}' | ';')
		public Group getGroup() { return cGroup; }

		//(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//qualifiers+='static' qualifiers+='definition'?
		public Group getGroup_0_0() { return cGroup_0_0; }

		//qualifiers+='static'
		public Assignment getQualifiersAssignment_0_0_0() { return cQualifiersAssignment_0_0_0; }

		//'static'
		public Keyword getQualifiersStaticKeyword_0_0_0_0() { return cQualifiersStaticKeyword_0_0_0_0; }

		//qualifiers+='definition'?
		public Assignment getQualifiersAssignment_0_0_1() { return cQualifiersAssignment_0_0_1; }

		//'definition'
		public Keyword getQualifiersDefinitionKeyword_0_0_1_0() { return cQualifiersDefinitionKeyword_0_0_1_0; }

		//qualifiers+='definition' qualifiers+='static'?
		public Group getGroup_0_1() { return cGroup_0_1; }

		//qualifiers+='definition'
		public Assignment getQualifiersAssignment_0_1_0() { return cQualifiersAssignment_0_1_0; }

		//'definition'
		public Keyword getQualifiersDefinitionKeyword_0_1_0_0() { return cQualifiersDefinitionKeyword_0_1_0_0; }

		//qualifiers+='static'?
		public Assignment getQualifiersAssignment_0_1_1() { return cQualifiersAssignment_0_1_1; }

		//'static'
		public Keyword getQualifiersStaticKeyword_0_1_1_0() { return cQualifiersStaticKeyword_0_1_1_0; }

		//'property'
		public Keyword getPropertyKeyword_1() { return cPropertyKeyword_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//('#' referredOpposite=[pivot::Property|UnrestrictedName])?
		public Group getGroup_3() { return cGroup_3; }

		//'#'
		public Keyword getNumberSignKeyword_3_0() { return cNumberSignKeyword_3_0; }

		//referredOpposite=[pivot::Property|UnrestrictedName]
		public Assignment getReferredOppositeAssignment_3_1() { return cReferredOppositeAssignment_3_1; }

		//[pivot::Property|UnrestrictedName]
		public CrossReference getReferredOppositePropertyCrossReference_3_1_0() { return cReferredOppositePropertyCrossReference_3_1_0; }

		//UnrestrictedName
		public RuleCall getReferredOppositePropertyUnrestrictedNameParserRuleCall_3_1_0_1() { return cReferredOppositePropertyUnrestrictedNameParserRuleCall_3_1_0_1; }

		//(':' ownedType=TypedMultiplicityRefCS)?
		public Group getGroup_4() { return cGroup_4; }

		//':'
		public Keyword getColonKeyword_4_0() { return cColonKeyword_4_0; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_4_1() { return cOwnedTypeAssignment_4_1; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_1_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_1_0; }

		//('=' default=SINGLE_QUOTED_STRING)?
		public Group getGroup_5() { return cGroup_5; }

		//'='
		public Keyword getEqualsSignKeyword_5_0() { return cEqualsSignKeyword_5_0; }

		//default=SINGLE_QUOTED_STRING
		public Assignment getDefaultAssignment_5_1() { return cDefaultAssignment_5_1; }

		//SINGLE_QUOTED_STRING
		public RuleCall getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0() { return cDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0; }

		//('{' ((qualifiers+='composes' | qualifiers+='!composes' | qualifiers+='derived' | qualifiers+='!derived' | qualifiers+=
		//'ordered' | qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='resolve' |
		//qualifiers+='!resolve' | qualifiers+='transient' | qualifiers+='!transient' | qualifiers+='unique' | qualifiers+=
		//'!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' | qualifiers+='volatile' | qualifiers+='!volatile')
		//','?)+
		//'}')?
		public Group getGroup_6() { return cGroup_6; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_6_0() { return cLeftCurlyBracketKeyword_6_0; }

		//((qualifiers+='composes' | qualifiers+='!composes' | qualifiers+='derived' | qualifiers+='!derived' | qualifiers+=
		//'ordered' | qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='resolve' |
		//qualifiers+='!resolve' | qualifiers+='transient' | qualifiers+='!transient' | qualifiers+='unique' | qualifiers+=
		//'!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' | qualifiers+='volatile' | qualifiers+='!volatile')
		//','?)+
		public Group getGroup_6_1() { return cGroup_6_1; }

		//(qualifiers+='composes' | qualifiers+='!composes' | qualifiers+='derived' | qualifiers+='!derived' | qualifiers+=
		//'ordered' | qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='resolve' |
		//qualifiers+='!resolve' | qualifiers+='transient' | qualifiers+='!transient' | qualifiers+='unique' | qualifiers+=
		//'!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' | qualifiers+='volatile' | qualifiers+='!volatile')
		public Alternatives getAlternatives_6_1_0() { return cAlternatives_6_1_0; }

		//qualifiers+='composes'
		public Assignment getQualifiersAssignment_6_1_0_0() { return cQualifiersAssignment_6_1_0_0; }

		//'composes'
		public Keyword getQualifiersComposesKeyword_6_1_0_0_0() { return cQualifiersComposesKeyword_6_1_0_0_0; }

		//qualifiers+='!composes'
		public Assignment getQualifiersAssignment_6_1_0_1() { return cQualifiersAssignment_6_1_0_1; }

		//'!composes'
		public Keyword getQualifiersComposesKeyword_6_1_0_1_0() { return cQualifiersComposesKeyword_6_1_0_1_0; }

		//qualifiers+='derived'
		public Assignment getQualifiersAssignment_6_1_0_2() { return cQualifiersAssignment_6_1_0_2; }

		//'derived'
		public Keyword getQualifiersDerivedKeyword_6_1_0_2_0() { return cQualifiersDerivedKeyword_6_1_0_2_0; }

		//qualifiers+='!derived'
		public Assignment getQualifiersAssignment_6_1_0_3() { return cQualifiersAssignment_6_1_0_3; }

		//'!derived'
		public Keyword getQualifiersDerivedKeyword_6_1_0_3_0() { return cQualifiersDerivedKeyword_6_1_0_3_0; }

		//qualifiers+='ordered'
		public Assignment getQualifiersAssignment_6_1_0_4() { return cQualifiersAssignment_6_1_0_4; }

		//'ordered'
		public Keyword getQualifiersOrderedKeyword_6_1_0_4_0() { return cQualifiersOrderedKeyword_6_1_0_4_0; }

		//qualifiers+='!ordered'
		public Assignment getQualifiersAssignment_6_1_0_5() { return cQualifiersAssignment_6_1_0_5; }

		//'!ordered'
		public Keyword getQualifiersOrderedKeyword_6_1_0_5_0() { return cQualifiersOrderedKeyword_6_1_0_5_0; }

		//qualifiers+='readonly'
		public Assignment getQualifiersAssignment_6_1_0_6() { return cQualifiersAssignment_6_1_0_6; }

		//'readonly'
		public Keyword getQualifiersReadonlyKeyword_6_1_0_6_0() { return cQualifiersReadonlyKeyword_6_1_0_6_0; }

		//qualifiers+='!readonly'
		public Assignment getQualifiersAssignment_6_1_0_7() { return cQualifiersAssignment_6_1_0_7; }

		//'!readonly'
		public Keyword getQualifiersReadonlyKeyword_6_1_0_7_0() { return cQualifiersReadonlyKeyword_6_1_0_7_0; }

		//qualifiers+='resolve'
		public Assignment getQualifiersAssignment_6_1_0_8() { return cQualifiersAssignment_6_1_0_8; }

		//'resolve'
		public Keyword getQualifiersResolveKeyword_6_1_0_8_0() { return cQualifiersResolveKeyword_6_1_0_8_0; }

		//qualifiers+='!resolve'
		public Assignment getQualifiersAssignment_6_1_0_9() { return cQualifiersAssignment_6_1_0_9; }

		//'!resolve'
		public Keyword getQualifiersResolveKeyword_6_1_0_9_0() { return cQualifiersResolveKeyword_6_1_0_9_0; }

		//qualifiers+='transient'
		public Assignment getQualifiersAssignment_6_1_0_10() { return cQualifiersAssignment_6_1_0_10; }

		//'transient'
		public Keyword getQualifiersTransientKeyword_6_1_0_10_0() { return cQualifiersTransientKeyword_6_1_0_10_0; }

		//qualifiers+='!transient'
		public Assignment getQualifiersAssignment_6_1_0_11() { return cQualifiersAssignment_6_1_0_11; }

		//'!transient'
		public Keyword getQualifiersTransientKeyword_6_1_0_11_0() { return cQualifiersTransientKeyword_6_1_0_11_0; }

		//qualifiers+='unique'
		public Assignment getQualifiersAssignment_6_1_0_12() { return cQualifiersAssignment_6_1_0_12; }

		//'unique'
		public Keyword getQualifiersUniqueKeyword_6_1_0_12_0() { return cQualifiersUniqueKeyword_6_1_0_12_0; }

		//qualifiers+='!unique'
		public Assignment getQualifiersAssignment_6_1_0_13() { return cQualifiersAssignment_6_1_0_13; }

		//'!unique'
		public Keyword getQualifiersUniqueKeyword_6_1_0_13_0() { return cQualifiersUniqueKeyword_6_1_0_13_0; }

		//qualifiers+='unsettable'
		public Assignment getQualifiersAssignment_6_1_0_14() { return cQualifiersAssignment_6_1_0_14; }

		//'unsettable'
		public Keyword getQualifiersUnsettableKeyword_6_1_0_14_0() { return cQualifiersUnsettableKeyword_6_1_0_14_0; }

		//qualifiers+='!unsettable'
		public Assignment getQualifiersAssignment_6_1_0_15() { return cQualifiersAssignment_6_1_0_15; }

		//'!unsettable'
		public Keyword getQualifiersUnsettableKeyword_6_1_0_15_0() { return cQualifiersUnsettableKeyword_6_1_0_15_0; }

		//qualifiers+='volatile'
		public Assignment getQualifiersAssignment_6_1_0_16() { return cQualifiersAssignment_6_1_0_16; }

		//'volatile'
		public Keyword getQualifiersVolatileKeyword_6_1_0_16_0() { return cQualifiersVolatileKeyword_6_1_0_16_0; }

		//qualifiers+='!volatile'
		public Assignment getQualifiersAssignment_6_1_0_17() { return cQualifiersAssignment_6_1_0_17; }

		//'!volatile'
		public Keyword getQualifiersVolatileKeyword_6_1_0_17_0() { return cQualifiersVolatileKeyword_6_1_0_17_0; }

		//','?
		public Keyword getCommaKeyword_6_1_1() { return cCommaKeyword_6_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_6_2() { return cRightCurlyBracketKeyword_6_2; }

		//('{' (ownedAnnotations+=AnnotationElementCS
		//| 'key' referredKeys+=[pivot::Property|UnrestrictedName] (',' referredKeys+=[pivot::Property|UnrestrictedName])* ';' |
		//'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';' | ownedImplicitOpposites+=ImplicitOppositeCS ';')* '}' | ';')
		public Alternatives getAlternatives_7() { return cAlternatives_7; }

		//'{' (ownedAnnotations+=AnnotationElementCS
		//| 'key' referredKeys+=[pivot::Property|UnrestrictedName] (',' referredKeys+=[pivot::Property|UnrestrictedName])* ';' |
		//'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';' | ownedImplicitOpposites+=ImplicitOppositeCS ';')* '}'
		public Group getGroup_7_0() { return cGroup_7_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_7_0_0() { return cLeftCurlyBracketKeyword_7_0_0; }

		//(ownedAnnotations+=AnnotationElementCS
		//| 'key' referredKeys+=[pivot::Property|UnrestrictedName] (',' referredKeys+=[pivot::Property|UnrestrictedName])* ';' |
		//'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';' | ownedImplicitOpposites+=ImplicitOppositeCS ';')*
		public Alternatives getAlternatives_7_0_1() { return cAlternatives_7_0_1; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_7_0_1_0() { return cOwnedAnnotationsAssignment_7_0_1_0; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0; }

		//'key' referredKeys+=[pivot::Property|UnrestrictedName] (',' referredKeys+=[pivot::Property|UnrestrictedName])* ';'
		public Group getGroup_7_0_1_1() { return cGroup_7_0_1_1; }

		//'key'
		public Keyword getKeyKeyword_7_0_1_1_0() { return cKeyKeyword_7_0_1_1_0; }

		//referredKeys+=[pivot::Property|UnrestrictedName]
		public Assignment getReferredKeysAssignment_7_0_1_1_1() { return cReferredKeysAssignment_7_0_1_1_1; }

		//[pivot::Property|UnrestrictedName]
		public CrossReference getReferredKeysPropertyCrossReference_7_0_1_1_1_0() { return cReferredKeysPropertyCrossReference_7_0_1_1_1_0; }

		//UnrestrictedName
		public RuleCall getReferredKeysPropertyUnrestrictedNameParserRuleCall_7_0_1_1_1_0_1() { return cReferredKeysPropertyUnrestrictedNameParserRuleCall_7_0_1_1_1_0_1; }

		//(',' referredKeys+=[pivot::Property|UnrestrictedName])*
		public Group getGroup_7_0_1_1_2() { return cGroup_7_0_1_1_2; }

		//','
		public Keyword getCommaKeyword_7_0_1_1_2_0() { return cCommaKeyword_7_0_1_1_2_0; }

		//referredKeys+=[pivot::Property|UnrestrictedName]
		public Assignment getReferredKeysAssignment_7_0_1_1_2_1() { return cReferredKeysAssignment_7_0_1_1_2_1; }

		//[pivot::Property|UnrestrictedName]
		public CrossReference getReferredKeysPropertyCrossReference_7_0_1_1_2_1_0() { return cReferredKeysPropertyCrossReference_7_0_1_1_2_1_0; }

		//UnrestrictedName
		public RuleCall getReferredKeysPropertyUnrestrictedNameParserRuleCall_7_0_1_1_2_1_0_1() { return cReferredKeysPropertyUnrestrictedNameParserRuleCall_7_0_1_1_2_1_0_1; }

		//';'
		public Keyword getSemicolonKeyword_7_0_1_1_3() { return cSemicolonKeyword_7_0_1_1_3; }

		//'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';'
		public Group getGroup_7_0_1_2() { return cGroup_7_0_1_2; }

		//'initial'
		public Keyword getInitialKeyword_7_0_1_2_0() { return cInitialKeyword_7_0_1_2_0; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_7_0_1_2_1() { return cUnrestrictedNameParserRuleCall_7_0_1_2_1; }

		//':'
		public Keyword getColonKeyword_7_0_1_2_2() { return cColonKeyword_7_0_1_2_2; }

		//ownedDefaultExpressions+=SpecificationCS?
		public Assignment getOwnedDefaultExpressionsAssignment_7_0_1_2_3() { return cOwnedDefaultExpressionsAssignment_7_0_1_2_3; }

		//SpecificationCS
		public RuleCall getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_2_3_0() { return cOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_2_3_0; }

		//';'
		public Keyword getSemicolonKeyword_7_0_1_2_4() { return cSemicolonKeyword_7_0_1_2_4; }

		//'derivation' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';'
		public Group getGroup_7_0_1_3() { return cGroup_7_0_1_3; }

		//'derivation'
		public Keyword getDerivationKeyword_7_0_1_3_0() { return cDerivationKeyword_7_0_1_3_0; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_7_0_1_3_1() { return cUnrestrictedNameParserRuleCall_7_0_1_3_1; }

		//':'
		public Keyword getColonKeyword_7_0_1_3_2() { return cColonKeyword_7_0_1_3_2; }

		//ownedDefaultExpressions+=SpecificationCS?
		public Assignment getOwnedDefaultExpressionsAssignment_7_0_1_3_3() { return cOwnedDefaultExpressionsAssignment_7_0_1_3_3; }

		//SpecificationCS
		public RuleCall getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_3_3_0() { return cOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_3_3_0; }

		//';'
		public Keyword getSemicolonKeyword_7_0_1_3_4() { return cSemicolonKeyword_7_0_1_3_4; }

		//ownedImplicitOpposites+=ImplicitOppositeCS ';'
		public Group getGroup_7_0_1_4() { return cGroup_7_0_1_4; }

		//ownedImplicitOpposites+=ImplicitOppositeCS
		public Assignment getOwnedImplicitOppositesAssignment_7_0_1_4_0() { return cOwnedImplicitOppositesAssignment_7_0_1_4_0; }

		//ImplicitOppositeCS
		public RuleCall getOwnedImplicitOppositesImplicitOppositeCSParserRuleCall_7_0_1_4_0_0() { return cOwnedImplicitOppositesImplicitOppositeCSParserRuleCall_7_0_1_4_0_0; }

		//';'
		public Keyword getSemicolonKeyword_7_0_1_4_1() { return cSemicolonKeyword_7_0_1_4_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_7_0_2() { return cRightCurlyBracketKeyword_7_0_2; }

		//';'
		public Keyword getSemicolonKeyword_7_1() { return cSemicolonKeyword_7_1; }
	}

	public class SpecificationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.SpecificationCS");
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

	public class StructuredClassCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.StructuredClassCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsAbstractAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsAbstractAbstractKeyword_0_0 = (Keyword)cIsAbstractAssignment_0.eContents().get(0);
		private final Keyword cClassKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cOwnedSignatureAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_3_0 = (RuleCall)cOwnedSignatureAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cExtendsKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOwnedSuperTypesAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOwnedSuperTypesTypedRefCSParserRuleCall_4_1_0 = (RuleCall)cOwnedSuperTypesAssignment_4_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cGroup_4.eContents().get(2);
		private final Keyword cCommaKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cOwnedSuperTypesAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cOwnedSuperTypesTypedRefCSParserRuleCall_4_2_1_0 = (RuleCall)cOwnedSuperTypesAssignment_4_2_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cColonKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cInstanceClassNameAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0 = (RuleCall)cInstanceClassNameAssignment_5_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cLeftCurlyBracketKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cIsInterfaceAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final Keyword cIsInterfaceInterfaceKeyword_6_1_0 = (Keyword)cIsInterfaceAssignment_6_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6_2 = (Keyword)cGroup_6.eContents().get(2);
		private final Alternatives cAlternatives_7 = (Alternatives)cGroup.eContents().get(7);
		private final Group cGroup_7_0 = (Group)cAlternatives_7.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_7_0_0 = (Keyword)cGroup_7_0.eContents().get(0);
		private final Alternatives cAlternatives_7_0_1 = (Alternatives)cGroup_7_0.eContents().get(1);
		private final Assignment cOwnedAnnotationsAssignment_7_0_1_0 = (Assignment)cAlternatives_7_0_1.eContents().get(0);
		private final RuleCall cOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0 = (RuleCall)cOwnedAnnotationsAssignment_7_0_1_0.eContents().get(0);
		private final Assignment cOwnedOperationsAssignment_7_0_1_1 = (Assignment)cAlternatives_7_0_1.eContents().get(1);
		private final RuleCall cOwnedOperationsOperationCSParserRuleCall_7_0_1_1_0 = (RuleCall)cOwnedOperationsAssignment_7_0_1_1.eContents().get(0);
		private final Assignment cOwnedPropertiesAssignment_7_0_1_2 = (Assignment)cAlternatives_7_0_1.eContents().get(2);
		private final RuleCall cOwnedPropertiesStructuralFeatureCSParserRuleCall_7_0_1_2_0 = (RuleCall)cOwnedPropertiesAssignment_7_0_1_2.eContents().get(0);
		private final Assignment cOwnedConstraintsAssignment_7_0_1_3 = (Assignment)cAlternatives_7_0_1.eContents().get(3);
		private final RuleCall cOwnedConstraintsInvariantConstraintCSParserRuleCall_7_0_1_3_0 = (RuleCall)cOwnedConstraintsAssignment_7_0_1_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7_0_2 = (Keyword)cGroup_7_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_7_1 = (Keyword)cAlternatives_7.eContents().get(1);

		//StructuredClassCS base::StructuredClassCS:
		//	isAbstract?='abstract'?
		//	'class' name=UnrestrictedName
		//	ownedSignature=TemplateSignatureCS? ('extends' ownedSuperTypes+=TypedRefCS (',' ownedSuperTypes+=TypedRefCS)*)? (':'
		//	instanceClassName=SINGLE_QUOTED_STRING)? ('{' isInterface?='interface'?
		//	'}')? ('{' (ownedAnnotations+=AnnotationElementCS
		//	| ownedOperations+=OperationCS
		//	| ownedProperties+=StructuralFeatureCS
		//	| ownedConstraints+=InvariantConstraintCS)* '}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//isAbstract?='abstract'?
		//'class' name=UnrestrictedName
		//ownedSignature=TemplateSignatureCS? ('extends' ownedSuperTypes+=TypedRefCS (',' ownedSuperTypes+=TypedRefCS)*)? (':'
		//instanceClassName=SINGLE_QUOTED_STRING)? ('{' isInterface?='interface'?
		//'}')? ('{' (ownedAnnotations+=AnnotationElementCS
		//| ownedOperations+=OperationCS
		//| ownedProperties+=StructuralFeatureCS
		//| ownedConstraints+=InvariantConstraintCS)* '}' | ';')
		public Group getGroup() { return cGroup; }

		//isAbstract?='abstract'?
		public Assignment getIsAbstractAssignment_0() { return cIsAbstractAssignment_0; }

		//'abstract'
		public Keyword getIsAbstractAbstractKeyword_0_0() { return cIsAbstractAbstractKeyword_0_0; }

		//'class'
		public Keyword getClassKeyword_1() { return cClassKeyword_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_3() { return cOwnedSignatureAssignment_3; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_3_0; }

		//('extends' ownedSuperTypes+=TypedRefCS (',' ownedSuperTypes+=TypedRefCS)*)?
		public Group getGroup_4() { return cGroup_4; }

		//'extends'
		public Keyword getExtendsKeyword_4_0() { return cExtendsKeyword_4_0; }

		//ownedSuperTypes+=TypedRefCS
		public Assignment getOwnedSuperTypesAssignment_4_1() { return cOwnedSuperTypesAssignment_4_1; }

		//TypedRefCS
		public RuleCall getOwnedSuperTypesTypedRefCSParserRuleCall_4_1_0() { return cOwnedSuperTypesTypedRefCSParserRuleCall_4_1_0; }

		//(',' ownedSuperTypes+=TypedRefCS)*
		public Group getGroup_4_2() { return cGroup_4_2; }

		//','
		public Keyword getCommaKeyword_4_2_0() { return cCommaKeyword_4_2_0; }

		//ownedSuperTypes+=TypedRefCS
		public Assignment getOwnedSuperTypesAssignment_4_2_1() { return cOwnedSuperTypesAssignment_4_2_1; }

		//TypedRefCS
		public RuleCall getOwnedSuperTypesTypedRefCSParserRuleCall_4_2_1_0() { return cOwnedSuperTypesTypedRefCSParserRuleCall_4_2_1_0; }

		//(':' instanceClassName=SINGLE_QUOTED_STRING)?
		public Group getGroup_5() { return cGroup_5; }

		//':'
		public Keyword getColonKeyword_5_0() { return cColonKeyword_5_0; }

		//instanceClassName=SINGLE_QUOTED_STRING
		public Assignment getInstanceClassNameAssignment_5_1() { return cInstanceClassNameAssignment_5_1; }

		//SINGLE_QUOTED_STRING
		public RuleCall getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0() { return cInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0; }

		//('{' isInterface?='interface'?
		//'}')?
		public Group getGroup_6() { return cGroup_6; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_6_0() { return cLeftCurlyBracketKeyword_6_0; }

		//isInterface?='interface'?
		public Assignment getIsInterfaceAssignment_6_1() { return cIsInterfaceAssignment_6_1; }

		//'interface'
		public Keyword getIsInterfaceInterfaceKeyword_6_1_0() { return cIsInterfaceInterfaceKeyword_6_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_6_2() { return cRightCurlyBracketKeyword_6_2; }

		//('{' (ownedAnnotations+=AnnotationElementCS
		//| ownedOperations+=OperationCS
		//| ownedProperties+=StructuralFeatureCS
		//| ownedConstraints+=InvariantConstraintCS)* '}' | ';')
		public Alternatives getAlternatives_7() { return cAlternatives_7; }

		//'{' (ownedAnnotations+=AnnotationElementCS
		//| ownedOperations+=OperationCS
		//| ownedProperties+=StructuralFeatureCS
		//| ownedConstraints+=InvariantConstraintCS)* '}'
		public Group getGroup_7_0() { return cGroup_7_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_7_0_0() { return cLeftCurlyBracketKeyword_7_0_0; }

		//(ownedAnnotations+=AnnotationElementCS
		//| ownedOperations+=OperationCS
		//| ownedProperties+=StructuralFeatureCS
		//| ownedConstraints+=InvariantConstraintCS)*
		public Alternatives getAlternatives_7_0_1() { return cAlternatives_7_0_1; }

		//ownedAnnotations+=AnnotationElementCS
		public Assignment getOwnedAnnotationsAssignment_7_0_1_0() { return cOwnedAnnotationsAssignment_7_0_1_0; }

		//AnnotationElementCS
		public RuleCall getOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0() { return cOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0; }

		//ownedOperations+=OperationCS
		public Assignment getOwnedOperationsAssignment_7_0_1_1() { return cOwnedOperationsAssignment_7_0_1_1; }

		//OperationCS
		public RuleCall getOwnedOperationsOperationCSParserRuleCall_7_0_1_1_0() { return cOwnedOperationsOperationCSParserRuleCall_7_0_1_1_0; }

		//ownedProperties+=StructuralFeatureCS
		public Assignment getOwnedPropertiesAssignment_7_0_1_2() { return cOwnedPropertiesAssignment_7_0_1_2; }

		//StructuralFeatureCS
		public RuleCall getOwnedPropertiesStructuralFeatureCSParserRuleCall_7_0_1_2_0() { return cOwnedPropertiesStructuralFeatureCSParserRuleCall_7_0_1_2_0; }

		//ownedConstraints+=InvariantConstraintCS
		public Assignment getOwnedConstraintsAssignment_7_0_1_3() { return cOwnedConstraintsAssignment_7_0_1_3; }

		//InvariantConstraintCS
		public RuleCall getOwnedConstraintsInvariantConstraintCSParserRuleCall_7_0_1_3_0() { return cOwnedConstraintsInvariantConstraintCSParserRuleCall_7_0_1_3_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_7_0_2() { return cRightCurlyBracketKeyword_7_0_2; }

		//';'
		public Keyword getSemicolonKeyword_7_1() { return cSemicolonKeyword_7_1; }
	}

	public class StructuralFeatureCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.StructuralFeatureCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAttributeCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cReferenceCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		//StructuralFeatureCS base::StructuralFeatureCS:
		//	AttributeCS | ReferenceCS;
		@Override public ParserRule getRule() { return rule; }

		//AttributeCS | ReferenceCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//AttributeCS
		public RuleCall getAttributeCSParserRuleCall_0() { return cAttributeCSParserRuleCall_0; }

		//ReferenceCS
		public RuleCall getReferenceCSParserRuleCall_1() { return cReferenceCSParserRuleCall_1; }
	}

	public class SysMLCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.SysMLCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cSysMLCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cSysmlKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Assignment cOwnedDetailsAssignment_2_0_0 = (Assignment)cGroup_2_0.eContents().get(0);
		private final RuleCall cOwnedDetailsDetailCSParserRuleCall_2_0_0_0 = (RuleCall)cOwnedDetailsAssignment_2_0_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_2_0_1 = (Keyword)cGroup_2_0.eContents().get(1);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Group cGroup_2_1_1 = (Group)cGroup_2_1.eContents().get(1);
		private final Assignment cOwnedDetailsAssignment_2_1_1_0 = (Assignment)cGroup_2_1_1.eContents().get(0);
		private final RuleCall cOwnedDetailsDetailCSParserRuleCall_2_1_1_0_0 = (RuleCall)cOwnedDetailsAssignment_2_1_1_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_2_1_1_1 = (Keyword)cGroup_2_1_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_2_1_2 = (Keyword)cGroup_2_1.eContents().get(2);

		//SysMLCS:
		//	{SysMLCS} 'sysml' (ownedDetails+=DetailCS ';' | '{' (ownedDetails+=DetailCS ';')* '}');
		@Override public ParserRule getRule() { return rule; }

		//{SysMLCS} 'sysml' (ownedDetails+=DetailCS ';' | '{' (ownedDetails+=DetailCS ';')* '}')
		public Group getGroup() { return cGroup; }

		//{SysMLCS}
		public Action getSysMLCSAction_0() { return cSysMLCSAction_0; }

		//'sysml'
		public Keyword getSysmlKeyword_1() { return cSysmlKeyword_1; }

		//(ownedDetails+=DetailCS ';' | '{' (ownedDetails+=DetailCS ';')* '}')
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//ownedDetails+=DetailCS ';'
		public Group getGroup_2_0() { return cGroup_2_0; }

		//ownedDetails+=DetailCS
		public Assignment getOwnedDetailsAssignment_2_0_0() { return cOwnedDetailsAssignment_2_0_0; }

		//DetailCS
		public RuleCall getOwnedDetailsDetailCSParserRuleCall_2_0_0_0() { return cOwnedDetailsDetailCSParserRuleCall_2_0_0_0; }

		//';'
		public Keyword getSemicolonKeyword_2_0_1() { return cSemicolonKeyword_2_0_1; }

		//'{' (ownedDetails+=DetailCS ';')* '}'
		public Group getGroup_2_1() { return cGroup_2_1; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_1_0() { return cLeftCurlyBracketKeyword_2_1_0; }

		//(ownedDetails+=DetailCS ';')*
		public Group getGroup_2_1_1() { return cGroup_2_1_1; }

		//ownedDetails+=DetailCS
		public Assignment getOwnedDetailsAssignment_2_1_1_0() { return cOwnedDetailsAssignment_2_1_1_0; }

		//DetailCS
		public RuleCall getOwnedDetailsDetailCSParserRuleCall_2_1_1_0_0() { return cOwnedDetailsDetailCSParserRuleCall_2_1_1_0_0; }

		//';'
		public Keyword getSemicolonKeyword_2_1_1_1() { return cSemicolonKeyword_2_1_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_2_1_2() { return cRightCurlyBracketKeyword_2_1_2; }
	}

	public class TypeIdentifierElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.TypeIdentifier");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cUnrestrictedNameParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cPrimitiveTypeIdentifierParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		//TypeIdentifier:
		//	UnrestrictedName
		//	| PrimitiveTypeIdentifier;
		@Override public ParserRule getRule() { return rule; }

		//UnrestrictedName
		//| PrimitiveTypeIdentifier
		public Alternatives getAlternatives() { return cAlternatives; }

		//UnrestrictedName
		public RuleCall getUnrestrictedNameParserRuleCall_0() { return cUnrestrictedNameParserRuleCall_0; }

		//PrimitiveTypeIdentifier
		public RuleCall getPrimitiveTypeIdentifierParserRuleCall_1() { return cPrimitiveTypeIdentifierParserRuleCall_1; }
	}

	public class TypedMultiplicityRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.TypedMultiplicityRefCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cTypedRefCSParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Assignment cOwnedMultiplicityAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedMultiplicityMultiplicityCSParserRuleCall_1_0 = (RuleCall)cOwnedMultiplicityAssignment_1.eContents().get(0);

		//TypedMultiplicityRefCS base::TypedRefCS:
		//	TypedRefCS ownedMultiplicity=MultiplicityCS?;
		@Override public ParserRule getRule() { return rule; }

		//TypedRefCS ownedMultiplicity=MultiplicityCS?
		public Group getGroup() { return cGroup; }

		//TypedRefCS
		public RuleCall getTypedRefCSParserRuleCall_0() { return cTypedRefCSParserRuleCall_0; }

		//ownedMultiplicity=MultiplicityCS?
		public Assignment getOwnedMultiplicityAssignment_1() { return cOwnedMultiplicityAssignment_1; }

		//MultiplicityCS
		public RuleCall getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0() { return cOwnedMultiplicityMultiplicityCSParserRuleCall_1_0; }
	}

	public class TemplateSignatureCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.TemplateSignatureCS");
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
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.TypedRefCS");
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

	public class TypedTypeRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.TypedTypeRefCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedPathNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedPathNamePathNameCSParserRuleCall_0_0 = (RuleCall)cOwnedPathNameAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1_0_0 = (Keyword)cGroup_1_0.eContents().get(0);
		private final Assignment cOwnedBindingAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final RuleCall cOwnedBindingTemplateBindingCSParserRuleCall_1_0_1_0 = (RuleCall)cOwnedBindingAssignment_1_0_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_0_2 = (Keyword)cGroup_1_0.eContents().get(2);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Keyword cLessThanSignKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cOwnedBindingAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cOwnedBindingTemplateBindingCSParserRuleCall_1_1_1_0 = (RuleCall)cOwnedBindingAssignment_1_1_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_1_1_2 = (Keyword)cGroup_1_1.eContents().get(2);

		//@Override
		//TypedTypeRefCS base::TypedTypeRefCS:
		//	ownedPathName=PathNameCS ('(' ownedBinding=TemplateBindingCS ')' | '<' ownedBinding=TemplateBindingCS '>')?;
		@Override public ParserRule getRule() { return rule; }

		//ownedPathName=PathNameCS ('(' ownedBinding=TemplateBindingCS ')' | '<' ownedBinding=TemplateBindingCS '>')?
		public Group getGroup() { return cGroup; }

		//ownedPathName=PathNameCS
		public Assignment getOwnedPathNameAssignment_0() { return cOwnedPathNameAssignment_0; }

		//PathNameCS
		public RuleCall getOwnedPathNamePathNameCSParserRuleCall_0_0() { return cOwnedPathNamePathNameCSParserRuleCall_0_0; }

		//('(' ownedBinding=TemplateBindingCS ')' | '<' ownedBinding=TemplateBindingCS '>')?
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//'(' ownedBinding=TemplateBindingCS ')'
		public Group getGroup_1_0() { return cGroup_1_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_1_0_0() { return cLeftParenthesisKeyword_1_0_0; }

		//ownedBinding=TemplateBindingCS
		public Assignment getOwnedBindingAssignment_1_0_1() { return cOwnedBindingAssignment_1_0_1; }

		//TemplateBindingCS
		public RuleCall getOwnedBindingTemplateBindingCSParserRuleCall_1_0_1_0() { return cOwnedBindingTemplateBindingCSParserRuleCall_1_0_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_1_0_2() { return cRightParenthesisKeyword_1_0_2; }

		//'<' ownedBinding=TemplateBindingCS '>'
		public Group getGroup_1_1() { return cGroup_1_1; }

		//'<'
		public Keyword getLessThanSignKeyword_1_1_0() { return cLessThanSignKeyword_1_1_0; }

		//ownedBinding=TemplateBindingCS
		public Assignment getOwnedBindingAssignment_1_1_1() { return cOwnedBindingAssignment_1_1_1; }

		//TemplateBindingCS
		public RuleCall getOwnedBindingTemplateBindingCSParserRuleCall_1_1_1_0() { return cOwnedBindingTemplateBindingCSParserRuleCall_1_1_1_0; }

		//'>'
		public Keyword getGreaterThanSignKeyword_1_1_2() { return cGreaterThanSignKeyword_1_1_2; }
	}

	public class UnrestrictedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.UnrestrictedName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEnumerationLiteralNameParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cAnnotationKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cDocumentationKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cInvariantKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cLiteralKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cOppositeKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cSerializableKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cSysmlKeyword_7 = (Keyword)cAlternatives.eContents().get(7);

		//@Override
		//UnrestrictedName:
		//	EnumerationLiteralName
		//	| 'annotation'
		//	| 'documentation'
		//	| 'invariant'
		//	| 'literal'
		//	| 'opposite'
		//	| 'serializable'
		//	| 'sysml';
		@Override public ParserRule getRule() { return rule; }

		//EnumerationLiteralName
		//| 'annotation'
		//| 'documentation'
		//| 'invariant'
		//| 'literal'
		//| 'opposite'
		//| 'serializable'
		//| 'sysml'
		public Alternatives getAlternatives() { return cAlternatives; }

		//EnumerationLiteralName
		public RuleCall getEnumerationLiteralNameParserRuleCall_0() { return cEnumerationLiteralNameParserRuleCall_0; }

		//'annotation'
		public Keyword getAnnotationKeyword_1() { return cAnnotationKeyword_1; }

		//'documentation'
		public Keyword getDocumentationKeyword_2() { return cDocumentationKeyword_2; }

		//'invariant'
		public Keyword getInvariantKeyword_3() { return cInvariantKeyword_3; }

		//'literal'
		public Keyword getLiteralKeyword_4() { return cLiteralKeyword_4; }

		//'opposite'
		public Keyword getOppositeKeyword_5() { return cOppositeKeyword_5; }

		//'serializable'
		public Keyword getSerializableKeyword_6() { return cSerializableKeyword_6; }

		//'sysml'
		public Keyword getSysmlKeyword_7() { return cSysmlKeyword_7; }
	}


	private final TopLevelCSElements pTopLevelCS;
	private final TerminalRule tUNQUOTED_STRING;
	private final INTEGERElements pINTEGER;
	private final SIGNEDElements pSIGNED;
	private final EnumerationLiteralNameElements pEnumerationLiteralName;
	private final InvariantConstraintCSElements pInvariantConstraintCS;
	private final PostconditionConstraintCSElements pPostconditionConstraintCS;
	private final PreconditionConstraintCSElements pPreconditionConstraintCS;
	private final AnnotationCSElements pAnnotationCS;
	private final AnnotationElementCSElements pAnnotationElementCS;
	private final AttributeCSElements pAttributeCS;
	private final ClassCSElements pClassCS;
	private final DataTypeCSElements pDataTypeCS;
	private final DetailCSElements pDetailCS;
	private final DocumentationCSElements pDocumentationCS;
	private final EnumerationCSElements pEnumerationCS;
	private final EnumerationLiteralCSElements pEnumerationLiteralCS;
	private final ImportCSElements pImportCS;
	private final ModelElementCSElements pModelElementCS;
	private final ModelElementRefCSElements pModelElementRefCS;
	private final OperationCSElements pOperationCS;
	private final PackageCSElements pPackageCS;
	private final ParameterCSElements pParameterCS;
	private final ImplicitOppositeCSElements pImplicitOppositeCS;
	private final ReferenceCSElements pReferenceCS;
	private final SpecificationCSElements pSpecificationCS;
	private final StructuredClassCSElements pStructuredClassCS;
	private final StructuralFeatureCSElements pStructuralFeatureCS;
	private final SysMLCSElements pSysMLCS;
	private final TypeIdentifierElements pTypeIdentifier;
	private final TypedMultiplicityRefCSElements pTypedMultiplicityRefCS;
	private final TemplateSignatureCSElements pTemplateSignatureCS;
	private final TypedRefCSElements pTypedRefCS;
	private final TypedTypeRefCSElements pTypedTypeRefCS;
	private final UnrestrictedNameElements pUnrestrictedName;

	private final Grammar grammar;

	private final EssentialOCLGrammarAccess gaEssentialOCL;

	private final BaseGrammarAccess gaBase;

	@Inject
	public OCLinEcoreGrammarAccess(GrammarProvider grammarProvider,
		EssentialOCLGrammarAccess gaEssentialOCL,
		BaseGrammarAccess gaBase) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaEssentialOCL = gaEssentialOCL;
		this.gaBase = gaBase;
		this.pTopLevelCS = new TopLevelCSElements();
		this.tUNQUOTED_STRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.ocl.xtext.oclinecore.OCLinEcore.UNQUOTED_STRING");
		this.pINTEGER = new INTEGERElements();
		this.pSIGNED = new SIGNEDElements();
		this.pEnumerationLiteralName = new EnumerationLiteralNameElements();
		this.pInvariantConstraintCS = new InvariantConstraintCSElements();
		this.pPostconditionConstraintCS = new PostconditionConstraintCSElements();
		this.pPreconditionConstraintCS = new PreconditionConstraintCSElements();
		this.pAnnotationCS = new AnnotationCSElements();
		this.pAnnotationElementCS = new AnnotationElementCSElements();
		this.pAttributeCS = new AttributeCSElements();
		this.pClassCS = new ClassCSElements();
		this.pDataTypeCS = new DataTypeCSElements();
		this.pDetailCS = new DetailCSElements();
		this.pDocumentationCS = new DocumentationCSElements();
		this.pEnumerationCS = new EnumerationCSElements();
		this.pEnumerationLiteralCS = new EnumerationLiteralCSElements();
		this.pImportCS = new ImportCSElements();
		this.pModelElementCS = new ModelElementCSElements();
		this.pModelElementRefCS = new ModelElementRefCSElements();
		this.pOperationCS = new OperationCSElements();
		this.pPackageCS = new PackageCSElements();
		this.pParameterCS = new ParameterCSElements();
		this.pImplicitOppositeCS = new ImplicitOppositeCSElements();
		this.pReferenceCS = new ReferenceCSElements();
		this.pSpecificationCS = new SpecificationCSElements();
		this.pStructuredClassCS = new StructuredClassCSElements();
		this.pStructuralFeatureCS = new StructuralFeatureCSElements();
		this.pSysMLCS = new SysMLCSElements();
		this.pTypeIdentifier = new TypeIdentifierElements();
		this.pTypedMultiplicityRefCS = new TypedMultiplicityRefCSElements();
		this.pTemplateSignatureCS = new TemplateSignatureCSElements();
		this.pTypedRefCS = new TypedRefCSElements();
		this.pTypedTypeRefCS = new TypedTypeRefCSElements();
		this.pUnrestrictedName = new UnrestrictedNameElements();
	}

	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.ocl.xtext.oclinecore.OCLinEcore".equals(grammar.getName())) {
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


	////generate oclinEcore2 "http://www.eclipse.org/ocl/examples/xtext/oclinecore/OCLinEcore"
	//TopLevelCS:
	//	{TopLevelCS} ('module' UnrestrictedName)?
	//	ownedImports+=ImportCS*
	//	ownedPackages+=PackageCS*;
	public TopLevelCSElements getTopLevelCSAccess() {
		return pTopLevelCS;
	}

	public ParserRule getTopLevelCSRule() {
		return getTopLevelCSAccess().getRule();
	}

	//terminal UNQUOTED_STRING: // Never forward parsed; just provides a placeholder
	//	'£$%^£$%^' // for reverse serialisation of embedded OCL
	//;
	public TerminalRule getUNQUOTED_STRINGRule() {
		return tUNQUOTED_STRING;
	}

	//INTEGER ecore::EInt:
	//	INT;
	public INTEGERElements getINTEGERAccess() {
		return pINTEGER;
	}

	public ParserRule getINTEGERRule() {
		return getINTEGERAccess().getRule();
	}

	//SIGNED ecore::EInt:
	//	'-'? INT;
	public SIGNEDElements getSIGNEDAccess() {
		return pSIGNED;
	}

	public ParserRule getSIGNEDRule() {
		return getSIGNEDAccess().getRule();
	}

	//EnumerationLiteralName:
	//	EssentialOCLUnrestrictedName
	//	| 'abstract'
	//	| 'attribute'
	//	| 'body'
	//	| 'callable'
	//	| 'class'
	//	| 'composes'
	//	| 'datatype'
	//	| 'definition'
	//	| 'derivation'
	//	| 'derived'
	//	| 'enum'
	//	| 'extends'
	//	| 'id'
	//	| 'import'
	//	| 'initial'
	//	| 'interface'
	//	| 'key'
	//	| 'library'
	//	| 'module'
	//	| 'operation'
	//	| 'ordered'
	//	| 'package'
	//	| 'postcondition'
	//	| 'precondition'
	//	| 'primitive'
	//	| 'property'
	//	| 'readonly'
	//	| 'reference'
	//	| 'resolve'
	//	| 'static'
	//	| 'throws'
	//	| 'transient'
	//	| 'unique'
	//	| 'unsettable'
	//	| 'volatile';
	public EnumerationLiteralNameElements getEnumerationLiteralNameAccess() {
		return pEnumerationLiteralName;
	}

	public ParserRule getEnumerationLiteralNameRule() {
		return getEnumerationLiteralNameAccess().getRule();
	}

	//InvariantConstraintCS OCLinEcoreConstraintCS:
	//	isCallable?='callable'? stereotype='invariant' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS
	//	')')?)? (':' ownedSpecification=SpecificationCS? ';' | ';');
	public InvariantConstraintCSElements getInvariantConstraintCSAccess() {
		return pInvariantConstraintCS;
	}

	public ParserRule getInvariantConstraintCSRule() {
		return getInvariantConstraintCSAccess().getRule();
	}

	//PostconditionConstraintCS OCLinEcoreConstraintCS:
	//	stereotype='postcondition' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
	//	ownedSpecification=SpecificationCS? ';';
	public PostconditionConstraintCSElements getPostconditionConstraintCSAccess() {
		return pPostconditionConstraintCS;
	}

	public ParserRule getPostconditionConstraintCSRule() {
		return getPostconditionConstraintCSAccess().getRule();
	}

	//PreconditionConstraintCS OCLinEcoreConstraintCS:
	//	stereotype='precondition' (name=UnrestrictedName ('(' ownedMessageSpecification=SpecificationCS ')')?)? ':'
	//	ownedSpecification=SpecificationCS? ';';
	public PreconditionConstraintCSElements getPreconditionConstraintCSAccess() {
		return pPreconditionConstraintCS;
	}

	public ParserRule getPreconditionConstraintCSRule() {
		return getPreconditionConstraintCSAccess().getRule();
	}

	//AnnotationCS base::AnnotationCS:
	//	{base::AnnotationCS} 'annotation' name=(UnrestrictedName | SINGLE_QUOTED_STRING)? ('(' ownedDetails+=DetailCS (','
	//	ownedDetails+=DetailCS)* ')')? ('{' (ownedAnnotations+=AnnotationElementCS
	//	| ownedContents+=ModelElementCS
	//	| ownedReferences+=ModelElementRefCS)+ '}' | ';');
	public AnnotationCSElements getAnnotationCSAccess() {
		return pAnnotationCS;
	}

	public ParserRule getAnnotationCSRule() {
		return getAnnotationCSAccess().getRule();
	}

	//AnnotationElementCS base::AnnotationElementCS:
	//	AnnotationCS | DocumentationCS | SysMLCS;
	public AnnotationElementCSElements getAnnotationElementCSAccess() {
		return pAnnotationElementCS;
	}

	public ParserRule getAnnotationElementCSRule() {
		return getAnnotationElementCSAccess().getRule();
	}

	//AttributeCS base::AttributeCS:
	//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
	//	'attribute' name=UnrestrictedName (':' ownedType=TypedMultiplicityRefCS)? ('=' default=SINGLE_QUOTED_STRING)? ('{' (
	//	(qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='id' | qualifiers+='!id' | qualifiers+='ordered' |
	//	qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='transient' | qualifiers+=
	//	'!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' |
	//	qualifiers+='volatile' | qualifiers+='!volatile') ','?)+
	//	'}')? ('{' (ownedAnnotations+=AnnotationElementCS
	//	| 'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
	//	ownedDefaultExpressions+=SpecificationCS? ';')* '}' | ';');
	public AttributeCSElements getAttributeCSAccess() {
		return pAttributeCS;
	}

	public ParserRule getAttributeCSRule() {
		return getAttributeCSAccess().getRule();
	}

	//ClassCS base::ClassCS:
	//	StructuredClassCS | DataTypeCS | EnumerationCS;
	public ClassCSElements getClassCSAccess() {
		return pClassCS;
	}

	public ParserRule getClassCSRule() {
		return getClassCSAccess().getRule();
	}

	//DataTypeCS base::DataTypeCS:
	//	isPrimitive?='primitive'? 'datatype' name=UnrestrictedName
	//	ownedSignature=TemplateSignatureCS? (':' instanceClassName=SINGLE_QUOTED_STRING)? ('{' (isSerializable?=
	//	'serializable' | '!serializable')? '}')? ('{' (ownedAnnotations+=AnnotationElementCS
	//	| ownedConstraints+=InvariantConstraintCS)* '}' | ';');
	public DataTypeCSElements getDataTypeCSAccess() {
		return pDataTypeCS;
	}

	public ParserRule getDataTypeCSRule() {
		return getDataTypeCSAccess().getRule();
	}

	//DetailCS base::DetailCS:
	//	name=(UnrestrictedName | SINGLE_QUOTED_STRING) '=' values+=(SINGLE_QUOTED_STRING | ML_SINGLE_QUOTED_STRING)*;
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

	//EnumerationCS base::EnumerationCS:
	//	'enum' name=UnrestrictedName
	//	ownedSignature=TemplateSignatureCS? (':' instanceClassName=SINGLE_QUOTED_STRING)? ('{' (isSerializable?=
	//	'serializable' | '!serializable')? '}')? ('{' (ownedAnnotations+=AnnotationElementCS
	//	| ownedLiterals+=EnumerationLiteralCS
	//	| ownedConstraints+=InvariantConstraintCS)* '}' | ';');
	public EnumerationCSElements getEnumerationCSAccess() {
		return pEnumerationCS;
	}

	public ParserRule getEnumerationCSRule() {
		return getEnumerationCSAccess().getRule();
	}

	//EnumerationLiteralCS base::EnumerationLiteralCS:
	//	('literal' name=UnrestrictedName | name=EnumerationLiteralName) (':' literal=SINGLE_QUOTED_STRING)? ('=' value=SIGNED
	//	)? ('{' ownedAnnotations+=AnnotationElementCS* '}' | ';');
	public EnumerationLiteralCSElements getEnumerationLiteralCSAccess() {
		return pEnumerationLiteralCS;
	}

	public ParserRule getEnumerationLiteralCSRule() {
		return getEnumerationLiteralCSAccess().getRule();
	}

	//ImportCS base::ImportCS:
	//	('import' | 'library') (name=UnrestrictedName ':')? ownedPathName=URIPathNameCS isAll?='::*'? ';';
	public ImportCSElements getImportCSAccess() {
		return pImportCS;
	}

	public ParserRule getImportCSRule() {
		return getImportCSAccess().getRule();
	}

	//ModelElementCS base::ModelElementCS:
	//	ClassCS | EnumerationLiteralCS | OperationCS | PackageCS | StructuralFeatureCS;
	public ModelElementCSElements getModelElementCSAccess() {
		return pModelElementCS;
	}

	public ParserRule getModelElementCSRule() {
		return getModelElementCSAccess().getRule();
	}

	//ModelElementRefCS base::ModelElementRefCS:
	//	'reference' ownedPathName=PathNameCS ';';
	public ModelElementRefCSElements getModelElementRefCSAccess() {
		return pModelElementRefCS;
	}

	public ParserRule getModelElementRefCSRule() {
		return getModelElementRefCSAccess().getRule();
	}

	//OperationCS base::OperationCS:
	//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
	//	'operation' ownedSignature=TemplateSignatureCS? name=UnrestrictedName
	//	'(' (ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)? ')' (':' ownedType=TypedMultiplicityRefCS)? (
	//	'throws' ownedExceptions+=TypedRefCS (',' ownedExceptions+=TypedRefCS)*)? ('{' ((qualifiers+='derived' | qualifiers+=
	//	'!derived' | qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='transient' | qualifiers+='!transient' |
	//	qualifiers+='unique' | qualifiers+='!unique') ','?)+
	//	'}')? ('{' (ownedAnnotations+=AnnotationElementCS
	//	| ownedPreconditions+=PreconditionConstraintCS
	//	| 'body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS? ';' |
	//	ownedPostconditions+=PostconditionConstraintCS)* '}' | ';');
	public OperationCSElements getOperationCSAccess() {
		return pOperationCS;
	}

	public ParserRule getOperationCSRule() {
		return getOperationCSAccess().getRule();
	}

	//PackageCS base::PackageCS:
	//	'package' name=UnrestrictedName (':' nsPrefix=UnrestrictedName)? ('=' nsURI=URI)? ('{'
	//	(ownedAnnotations+=AnnotationElementCS | ownedPackages+=PackageCS | ownedClasses+=ClassCS)*
	//	'}' | ';');
	public PackageCSElements getPackageCSAccess() {
		return pPackageCS;
	}

	public ParserRule getPackageCSRule() {
		return getPackageCSAccess().getRule();
	}

	//ParameterCS base::ParameterCS:
	//	name=UnrestrictedName (':' ownedType=TypedMultiplicityRefCS)? ('{' ((qualifiers+='ordered' | qualifiers+='!ordered' |
	//	qualifiers+='unique' | qualifiers+='!unique') ','?)+
	//	'}')? ('{' ownedAnnotations+=AnnotationElementCS* '}')?;
	public ParameterCSElements getParameterCSAccess() {
		return pParameterCS;
	}

	public ParserRule getParameterCSRule() {
		return getParameterCSAccess().getRule();
	}

	//ImplicitOppositeCS base::ImplicitOppositeCS:
	//	'opposite' name=UnrestrictedName
	//	':' ownedType=TypedMultiplicityRefCS ('{' ((qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' |
	//	qualifiers+='!unique') ','?)+
	//	'}')?;
	public ImplicitOppositeCSElements getImplicitOppositeCSAccess() {
		return pImplicitOppositeCS;
	}

	public ParserRule getImplicitOppositeCSRule() {
		return getImplicitOppositeCSAccess().getRule();
	}

	//ReferenceCS base::ReferenceCS:
	//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
	//	'property' name=UnrestrictedName ('#' referredOpposite=[pivot::Property|UnrestrictedName])? (':'
	//	ownedType=TypedMultiplicityRefCS)? ('=' default=SINGLE_QUOTED_STRING)? ('{' ((qualifiers+='composes' | qualifiers+=
	//	'!composes' | qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' | qualifiers+='!ordered' |
	//	qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='resolve' | qualifiers+='!resolve' | qualifiers+=
	//	'transient' | qualifiers+='!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' |
	//	qualifiers+='!unsettable' | qualifiers+='volatile' | qualifiers+='!volatile') ','?)+
	//	'}')? ('{' (ownedAnnotations+=AnnotationElementCS
	//	| 'key' referredKeys+=[pivot::Property|UnrestrictedName] (',' referredKeys+=[pivot::Property|UnrestrictedName])* ';'
	//	| 'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
	//	ownedDefaultExpressions+=SpecificationCS? ';' | ownedImplicitOpposites+=ImplicitOppositeCS ';')* '}' | ';');
	public ReferenceCSElements getReferenceCSAccess() {
		return pReferenceCS;
	}

	public ParserRule getReferenceCSRule() {
		return getReferenceCSAccess().getRule();
	}

	//SpecificationCS essentialocl::ExpSpecificationCS:
	//	ownedExpression=ExpCS | exprString=UNQUOTED_STRING;
	public SpecificationCSElements getSpecificationCSAccess() {
		return pSpecificationCS;
	}

	public ParserRule getSpecificationCSRule() {
		return getSpecificationCSAccess().getRule();
	}

	//StructuredClassCS base::StructuredClassCS:
	//	isAbstract?='abstract'?
	//	'class' name=UnrestrictedName
	//	ownedSignature=TemplateSignatureCS? ('extends' ownedSuperTypes+=TypedRefCS (',' ownedSuperTypes+=TypedRefCS)*)? (':'
	//	instanceClassName=SINGLE_QUOTED_STRING)? ('{' isInterface?='interface'?
	//	'}')? ('{' (ownedAnnotations+=AnnotationElementCS
	//	| ownedOperations+=OperationCS
	//	| ownedProperties+=StructuralFeatureCS
	//	| ownedConstraints+=InvariantConstraintCS)* '}' | ';');
	public StructuredClassCSElements getStructuredClassCSAccess() {
		return pStructuredClassCS;
	}

	public ParserRule getStructuredClassCSRule() {
		return getStructuredClassCSAccess().getRule();
	}

	//StructuralFeatureCS base::StructuralFeatureCS:
	//	AttributeCS | ReferenceCS;
	public StructuralFeatureCSElements getStructuralFeatureCSAccess() {
		return pStructuralFeatureCS;
	}

	public ParserRule getStructuralFeatureCSRule() {
		return getStructuralFeatureCSAccess().getRule();
	}

	//SysMLCS:
	//	{SysMLCS} 'sysml' (ownedDetails+=DetailCS ';' | '{' (ownedDetails+=DetailCS ';')* '}');
	public SysMLCSElements getSysMLCSAccess() {
		return pSysMLCS;
	}

	public ParserRule getSysMLCSRule() {
		return getSysMLCSAccess().getRule();
	}

	//TypeIdentifier:
	//	UnrestrictedName
	//	| PrimitiveTypeIdentifier;
	public TypeIdentifierElements getTypeIdentifierAccess() {
		return pTypeIdentifier;
	}

	public ParserRule getTypeIdentifierRule() {
		return getTypeIdentifierAccess().getRule();
	}

	//TypedMultiplicityRefCS base::TypedRefCS:
	//	TypedRefCS ownedMultiplicity=MultiplicityCS?;
	public TypedMultiplicityRefCSElements getTypedMultiplicityRefCSAccess() {
		return pTypedMultiplicityRefCS;
	}

	public ParserRule getTypedMultiplicityRefCSRule() {
		return getTypedMultiplicityRefCSAccess().getRule();
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
	//TypedTypeRefCS base::TypedTypeRefCS:
	//	ownedPathName=PathNameCS ('(' ownedBinding=TemplateBindingCS ')' | '<' ownedBinding=TemplateBindingCS '>')?;
	public TypedTypeRefCSElements getTypedTypeRefCSAccess() {
		return pTypedTypeRefCS;
	}

	public ParserRule getTypedTypeRefCSRule() {
		return getTypedTypeRefCSAccess().getRule();
	}

	//@Override
	//UnrestrictedName:
	//	EnumerationLiteralName
	//	| 'annotation'
	//	| 'documentation'
	//	| 'invariant'
	//	| 'literal'
	//	| 'opposite'
	//	| 'serializable'
	//	| 'sysml';
	public UnrestrictedNameElements getUnrestrictedNameAccess() {
		return pUnrestrictedName;
	}

	public ParserRule getUnrestrictedNameRule() {
		return getUnrestrictedNameAccess().getRule();
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
