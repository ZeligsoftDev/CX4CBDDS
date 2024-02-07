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
grammar InternalEssentialOCL;

options {
	superClass=AbstractInternalAntlrParser;
	backtrack=true;

}

@lexer::header {
package org.eclipse.ocl.xtext.essentialocl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import.
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.ocl.xtext.essentialocl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;

}

@parser::members {

/*
  This grammar contains a lot of empty actions to work around a bug in ANTLR.
  Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
*/

 	private EssentialOCLGrammarAccess grammarAccess;

    public InternalEssentialOCLParser(TokenStream input, EssentialOCLGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected EssentialOCLGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}




// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	 iv_ruleModel=ruleModel
	 { $current=$iv_ruleModel.current; }
	 EOF
;

// Rule Model
ruleModel returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
(
		{
	        newCompositeNode(grammarAccess.getModelAccess().getOwnedExpressionExpCSParserRuleCall_0());
	    }
		lv_ownedExpression_0_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelRule());
	        }
       		set(
       			$current,
       			"ownedExpression",
        		lv_ownedExpression_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
;







// Entry rule entryRuleEssentialOCLUnaryOperatorName
entryRuleEssentialOCLUnaryOperatorName returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getEssentialOCLUnaryOperatorNameRule()); }
	 iv_ruleEssentialOCLUnaryOperatorName=ruleEssentialOCLUnaryOperatorName
	 { $current=$iv_ruleEssentialOCLUnaryOperatorName.current.getText(); }
	 EOF
;

// Rule EssentialOCLUnaryOperatorName
ruleEssentialOCLUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	kw='-'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getHyphenMinusKeyword_0());
    }

    |
	kw='not'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNotKeyword_1());
    }

    |
	kw='not2'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNot2Keyword_2());
    }
)
    ;





// Entry rule entryRuleEssentialOCLInfixOperatorName
entryRuleEssentialOCLInfixOperatorName returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorNameRule()); }
	 iv_ruleEssentialOCLInfixOperatorName=ruleEssentialOCLInfixOperatorName
	 { $current=$iv_ruleEssentialOCLInfixOperatorName.current.getText(); }
	 EOF
;

// Rule EssentialOCLInfixOperatorName
ruleEssentialOCLInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	kw='*'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAsteriskKeyword_0());
    }

    |
	kw='/'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getSolidusKeyword_1());
    }

    |
	kw='+'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getPlusSignKeyword_2());
    }

    |
	kw='-'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getHyphenMinusKeyword_3());
    }

    |
	kw='>'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignKeyword_4());
    }

    |
	kw='<'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignKeyword_5());
    }

    |
	kw='>='
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignEqualsSignKeyword_6());
    }

    |
	kw='<='
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignEqualsSignKeyword_7());
    }

    |
	kw='='
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getEqualsSignKeyword_8());
    }

    |
	kw='<>'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignGreaterThanSignKeyword_9());
    }

    |
	kw='and'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAndKeyword_10());
    }

    |
	kw='and2'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAnd2Keyword_11());
    }

    |
	kw='implies'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImpliesKeyword_12());
    }

    |
	kw='implies2'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImplies2Keyword_13());
    }

    |
	kw='or'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOrKeyword_14());
    }

    |
	kw='or2'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOr2Keyword_15());
    }

    |
	kw='xor'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXorKeyword_16());
    }

    |
	kw='xor2'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXor2Keyword_17());
    }
)
    ;





// Entry rule entryRuleEssentialOCLNavigationOperatorName
entryRuleEssentialOCLNavigationOperatorName returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorNameRule()); }
	 iv_ruleEssentialOCLNavigationOperatorName=ruleEssentialOCLNavigationOperatorName
	 { $current=$iv_ruleEssentialOCLNavigationOperatorName.current.getText(); }
	 EOF
;

// Rule EssentialOCLNavigationOperatorName
ruleEssentialOCLNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	kw='.'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getFullStopKeyword_0());
    }

    |
	kw='->'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getHyphenMinusGreaterThanSignKeyword_1());
    }

    |
	kw='?.'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkFullStopKeyword_2());
    }

    |
	kw='?->'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkHyphenMinusGreaterThanSignKeyword_3());
    }
)
    ;





// Entry rule entryRuleBinaryOperatorName
entryRuleBinaryOperatorName returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getBinaryOperatorNameRule()); }
	 iv_ruleBinaryOperatorName=ruleBinaryOperatorName
	 { $current=$iv_ruleBinaryOperatorName.current.getText(); }
	 EOF
;

// Rule BinaryOperatorName
ruleBinaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
    {
        newCompositeNode(grammarAccess.getBinaryOperatorNameAccess().getInfixOperatorNameParserRuleCall_0());
    }
    this_InfixOperatorName_0=ruleInfixOperatorName    {
		$current.merge(this_InfixOperatorName_0);
    }

    {
        afterParserOrEnumRuleCall();
    }

    |
    {
        newCompositeNode(grammarAccess.getBinaryOperatorNameAccess().getNavigationOperatorNameParserRuleCall_1());
    }
    this_NavigationOperatorName_1=ruleNavigationOperatorName    {
		$current.merge(this_NavigationOperatorName_1);
    }

    {
        afterParserOrEnumRuleCall();
    }
)
    ;





// Entry rule entryRuleInfixOperatorName
entryRuleInfixOperatorName returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getInfixOperatorNameRule()); }
	 iv_ruleInfixOperatorName=ruleInfixOperatorName
	 { $current=$iv_ruleInfixOperatorName.current.getText(); }
	 EOF
;

// Rule InfixOperatorName
ruleInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:

    {
        newCompositeNode(grammarAccess.getInfixOperatorNameAccess().getEssentialOCLInfixOperatorNameParserRuleCall());
    }
    this_EssentialOCLInfixOperatorName_0=ruleEssentialOCLInfixOperatorName    {
		$current.merge(this_EssentialOCLInfixOperatorName_0);
    }

    {
        afterParserOrEnumRuleCall();
    }

    ;





// Entry rule entryRuleNavigationOperatorName
entryRuleNavigationOperatorName returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getNavigationOperatorNameRule()); }
	 iv_ruleNavigationOperatorName=ruleNavigationOperatorName
	 { $current=$iv_ruleNavigationOperatorName.current.getText(); }
	 EOF
;

// Rule NavigationOperatorName
ruleNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:

    {
        newCompositeNode(grammarAccess.getNavigationOperatorNameAccess().getEssentialOCLNavigationOperatorNameParserRuleCall());
    }
    this_EssentialOCLNavigationOperatorName_0=ruleEssentialOCLNavigationOperatorName    {
		$current.merge(this_EssentialOCLNavigationOperatorName_0);
    }

    {
        afterParserOrEnumRuleCall();
    }

    ;





// Entry rule entryRuleUnaryOperatorName
entryRuleUnaryOperatorName returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getUnaryOperatorNameRule()); }
	 iv_ruleUnaryOperatorName=ruleUnaryOperatorName
	 { $current=$iv_ruleUnaryOperatorName.current.getText(); }
	 EOF
;

// Rule UnaryOperatorName
ruleUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:

    {
        newCompositeNode(grammarAccess.getUnaryOperatorNameAccess().getEssentialOCLUnaryOperatorNameParserRuleCall());
    }
    this_EssentialOCLUnaryOperatorName_0=ruleEssentialOCLUnaryOperatorName    {
		$current.merge(this_EssentialOCLUnaryOperatorName_0);
    }

    {
        afterParserOrEnumRuleCall();
    }

    ;





// Entry rule entryRuleEssentialOCLUnrestrictedName
entryRuleEssentialOCLUnrestrictedName returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); }
	 iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName
	 { $current=$iv_ruleEssentialOCLUnrestrictedName.current.getText(); }
	 EOF
;

// Rule EssentialOCLUnrestrictedName
ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:

    {
        newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall());
    }
    this_Identifier_0=ruleIdentifier    {
		$current.merge(this_Identifier_0);
    }

    {
        afterParserOrEnumRuleCall();
    }

    ;





// Entry rule entryRuleUnrestrictedName
entryRuleUnrestrictedName returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getUnrestrictedNameRule()); }
	 iv_ruleUnrestrictedName=ruleUnrestrictedName
	 { $current=$iv_ruleUnrestrictedName.current.getText(); }
	 EOF
;

// Rule UnrestrictedName
ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:

    {
        newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall());
    }
    this_EssentialOCLUnrestrictedName_0=ruleEssentialOCLUnrestrictedName    {
		$current.merge(this_EssentialOCLUnrestrictedName_0);
    }

    {
        afterParserOrEnumRuleCall();
    }

    ;





// Entry rule entryRuleEssentialOCLUnreservedName
entryRuleEssentialOCLUnreservedName returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); }
	 iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName
	 { $current=$iv_ruleEssentialOCLUnreservedName.current.getText(); }
	 EOF
;

// Rule EssentialOCLUnreservedName
ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
    {
        newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0());
    }
    this_UnrestrictedName_0=ruleUnrestrictedName    {
		$current.merge(this_UnrestrictedName_0);
    }

    {
        afterParserOrEnumRuleCall();
    }

    |
    {
        newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1());
    }
    this_CollectionTypeIdentifier_1=ruleCollectionTypeIdentifier    {
		$current.merge(this_CollectionTypeIdentifier_1);
    }

    {
        afterParserOrEnumRuleCall();
    }

    |
    {
        newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2());
    }
    this_PrimitiveTypeIdentifier_2=rulePrimitiveTypeIdentifier    {
		$current.merge(this_PrimitiveTypeIdentifier_2);
    }

    {
        afterParserOrEnumRuleCall();
    }

    |
	kw='Map'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getMapKeyword_3());
    }

    |
	kw='Tuple'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_4());
    }
)
    ;





// Entry rule entryRuleUnreservedName
entryRuleUnreservedName returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getUnreservedNameRule()); }
	 iv_ruleUnreservedName=ruleUnreservedName
	 { $current=$iv_ruleUnreservedName.current.getText(); }
	 EOF
;

// Rule UnreservedName
ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:

    {
        newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall());
    }
    this_EssentialOCLUnreservedName_0=ruleEssentialOCLUnreservedName    {
		$current.merge(this_EssentialOCLUnreservedName_0);
    }

    {
        afterParserOrEnumRuleCall();
    }

    ;







// Entry rule entryRuleURIFirstPathElementCS
entryRuleURIFirstPathElementCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getURIFirstPathElementCSRule()); }
	 iv_ruleURIFirstPathElementCS=ruleURIFirstPathElementCS
	 { $current=$iv_ruleURIFirstPathElementCS.current; }
	 EOF
;

// Rule URIFirstPathElementCS
ruleURIFirstPathElementCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
		  /* */
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getURIFirstPathElementCSRule());
	        }
        }
		{
	        newCompositeNode(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0_0());
	    }
		ruleUnrestrictedName		{
	        afterParserOrEnumRuleCall();
	    }

)
)
    |((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getURIFirstPathElementCSAccess().getPathElementWithURICSAction_1_0(),
            $current);
    }
)(
(
		{
		  /* */
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getURIFirstPathElementCSRule());
	        }
        }
		{
	        newCompositeNode(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceCrossReference_1_1_0());
	    }
		ruleURI		{
	        afterParserOrEnumRuleCall();
	    }

)
)))
;







// Entry rule entryRulePrimitiveTypeIdentifier
entryRulePrimitiveTypeIdentifier returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); }
	 iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier
	 { $current=$iv_rulePrimitiveTypeIdentifier.current.getText(); }
	 EOF
;

// Rule PrimitiveTypeIdentifier
rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	kw='Boolean'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0());
    }

    |
	kw='Integer'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1());
    }

    |
	kw='Real'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2());
    }

    |
	kw='String'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3());
    }

    |
	kw='UnlimitedNatural'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4());
    }

    |
	kw='OclAny'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5());
    }

    |
	kw='OclInvalid'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6());
    }

    |
	kw='OclVoid'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclVoidKeyword_7());
    }
)
    ;





// Entry rule entryRulePrimitiveTypeCS
entryRulePrimitiveTypeCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); }
	 iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS
	 { $current=$iv_rulePrimitiveTypeCS.current; }
	 EOF
;

// Rule PrimitiveTypeCS
rulePrimitiveTypeCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
(
		{
	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0());
	    }
		lv_name_0_0=rulePrimitiveTypeIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrimitiveTypeCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrimitiveTypeIdentifier");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleCollectionTypeIdentifier
entryRuleCollectionTypeIdentifier returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); }
	 iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier
	 { $current=$iv_ruleCollectionTypeIdentifier.current.getText(); }
	 EOF
;

// Rule CollectionTypeIdentifier
ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	kw='Set'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0());
    }

    |
	kw='Bag'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1());
    }

    |
	kw='Sequence'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2());
    }

    |
	kw='Collection'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3());
    }

    |
	kw='OrderedSet'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getOrderedSetKeyword_4());
    }
)
    ;





// Entry rule entryRuleCollectionTypeCS
entryRuleCollectionTypeCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getCollectionTypeCSRule()); }
	 iv_ruleCollectionTypeCS=ruleCollectionTypeCS
	 { $current=$iv_ruleCollectionTypeCS.current; }
	 EOF
;

// Rule CollectionTypeCS
ruleCollectionTypeCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0());
	    }
		lv_name_0_0=ruleCollectionTypeIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeIdentifier");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='('
    {
    	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpWithoutMultiplicityCSParserRuleCall_1_1_0());
	    }
		lv_ownedType_2_0=ruleTypeExpWithoutMultiplicityCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpWithoutMultiplicityCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedCollectionMultiplicityMultiplicityCSParserRuleCall_1_2_0());
	    }
		lv_ownedCollectionMultiplicity_3_0=ruleMultiplicityCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
	        }
       		set(
       			$current,
       			"ownedCollectionMultiplicity",
        		lv_ownedCollectionMultiplicity_3_0,
        		"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_4=')'
    {
    	newLeafNode(otherlv_4, grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_3());
    }
)?)
;





// Entry rule entryRuleMapTypeCS
entryRuleMapTypeCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getMapTypeCSRule()); }
	 iv_ruleMapTypeCS=ruleMapTypeCS
	 { $current=$iv_ruleMapTypeCS.current; }
	 EOF
;

// Rule MapTypeCS
ruleMapTypeCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=	'Map'
    {
        newLeafNode(lv_name_0_0, grammarAccess.getMapTypeCSAccess().getNameMapKeyword_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMapTypeCSRule());
	        }
       		setWithLastConsumed($current, "name", lv_name_0_0, "Map");
	    }

)
)(	otherlv_1='('
    {
    	newLeafNode(otherlv_1, grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0());
	    }
		lv_ownedKeyType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMapTypeCSRule());
	        }
       		set(
       			$current,
       			"ownedKeyType",
        		lv_ownedKeyType_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=','
    {
    	newLeafNode(otherlv_3, grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0());
	    }
		lv_ownedValueType_4_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMapTypeCSRule());
	        }
       		set(
       			$current,
       			"ownedValueType",
        		lv_ownedValueType_4_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_5=')'
    {
    	newLeafNode(otherlv_5, grammarAccess.getMapTypeCSAccess().getRightParenthesisKeyword_1_4());
    }
)?)
;





// Entry rule entryRuleTupleTypeCS
entryRuleTupleTypeCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTupleTypeCSRule()); }
	 iv_ruleTupleTypeCS=ruleTupleTypeCS
	 { $current=$iv_ruleTupleTypeCS.current; }
	 EOF
;

// Rule TupleTypeCS
ruleTupleTypeCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=	'Tuple'
    {
        newLeafNode(lv_name_0_0, grammarAccess.getTupleTypeCSAccess().getNameTupleKeyword_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTupleTypeCSRule());
	        }
       		setWithLastConsumed($current, "name", lv_name_0_0, "Tuple");
	    }

)
)(	otherlv_1='('
    {
    	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0());
	    }
		lv_ownedParts_2_0=ruleTuplePartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
	        }
       		add(
       			$current,
       			"ownedParts",
        		lv_ownedParts_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TuplePartCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=','
    {
    	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0());
	    }
		lv_ownedParts_4_0=ruleTuplePartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
	        }
       		add(
       			$current,
       			"ownedParts",
        		lv_ownedParts_4_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TuplePartCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_5=')'
    {
    	newLeafNode(otherlv_5, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2());
    }
)?)
;





// Entry rule entryRuleTuplePartCS
entryRuleTuplePartCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTuplePartCSRule()); }
	 iv_ruleTuplePartCS=ruleTuplePartCS
	 { $current=$iv_ruleTuplePartCS.current; }
	 EOF
;

// Rule TuplePartCS
ruleTuplePartCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
	    }
		lv_name_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1=':'
    {
    	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0());
	    }
		lv_ownedType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleCollectionLiteralExpCS
entryRuleCollectionLiteralExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); }
	 iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS
	 { $current=$iv_ruleCollectionLiteralExpCS.current; }
	 EOF
;

// Rule CollectionLiteralExpCS
ruleCollectionLiteralExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0());
	    }
		lv_ownedType_0_0=ruleCollectionTypeCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='{'
    {
    	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0());
	    }
		lv_ownedParts_2_0=ruleCollectionLiteralPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
	        }
       		add(
       			$current,
       			"ownedParts",
        		lv_ownedParts_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionLiteralPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=','
    {
    	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0());
	    }
		lv_ownedParts_4_0=ruleCollectionLiteralPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
	        }
       		add(
       			$current,
       			"ownedParts",
        		lv_ownedParts_4_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionLiteralPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_5='}'
    {
    	newLeafNode(otherlv_5, grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleCollectionLiteralPartCS
entryRuleCollectionLiteralPartCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); }
	 iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS
	 { $current=$iv_ruleCollectionLiteralPartCS.current; }
	 EOF
;

// Rule CollectionLiteralPartCS
ruleCollectionLiteralPartCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(((
(
		{
	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0());
	    }
		lv_ownedExpression_0_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
	        }
       		set(
       			$current,
       			"ownedExpression",
        		lv_ownedExpression_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='..'
    {
    	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionExpCSParserRuleCall_0_1_1_0());
	    }
		lv_ownedLastExpression_2_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
	        }
       		set(
       			$current,
       			"ownedLastExpression",
        		lv_ownedLastExpression_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
    |(
(
		{
	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionPatternExpCSParserRuleCall_1_0());
	    }
		lv_ownedExpression_3_0=rulePatternExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
	        }
       		set(
       			$current,
       			"ownedExpression",
        		lv_ownedExpression_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleCollectionPatternCS
entryRuleCollectionPatternCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getCollectionPatternCSRule()); }
	 iv_ruleCollectionPatternCS=ruleCollectionPatternCS
	 { $current=$iv_ruleCollectionPatternCS.current; }
	 EOF
;

// Rule CollectionPatternCS
ruleCollectionPatternCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0());
	    }
		lv_ownedType_0_0=ruleCollectionTypeCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='{'
    {
    	newLeafNode(otherlv_1, grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0());
	    }
		lv_ownedParts_2_0=rulePatternExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
	        }
       		add(
       			$current,
       			"ownedParts",
        		lv_ownedParts_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=','
    {
    	newLeafNode(otherlv_3, grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0());
	    }
		lv_ownedParts_4_0=rulePatternExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
	        }
       		add(
       			$current,
       			"ownedParts",
        		lv_ownedParts_4_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*(	otherlv_5='++'
    {
    	newLeafNode(otherlv_5, grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0());
	    }
		lv_restVariableName_6_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
	        }
       		set(
       			$current,
       			"restVariableName",
        		lv_restVariableName_6_0,
        		"org.eclipse.ocl.xtext.base.Base.Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
)))?	otherlv_7='}'
    {
    	newLeafNode(otherlv_7, grammarAccess.getCollectionPatternCSAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleShadowPartCS
entryRuleShadowPartCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getShadowPartCSRule()); }
	 iv_ruleShadowPartCS=ruleShadowPartCS
	 { $current=$iv_ruleShadowPartCS.current; }
	 EOF
;

// Rule ShadowPartCS
ruleShadowPartCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(((
(
		{
		  /* */
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getShadowPartCSRule());
	        }
        }
		{
	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyCrossReference_0_0_0());
	    }
		ruleUnrestrictedName		{
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='='
    {
    	newLeafNode(otherlv_1, grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_0_1());
    }
(
(
(
		{
	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_2_0_0());
	    }
		lv_ownedInitExpression_2_1=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
	        }
       		set(
       			$current,
       			"ownedInitExpression",
        		lv_ownedInitExpression_2_1,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

    |		{
	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_0_2_0_1());
	    }
		lv_ownedInitExpression_2_2=rulePatternExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
	        }
       		set(
       			$current,
       			"ownedInitExpression",
        		lv_ownedInitExpression_2_2,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
	        afterParserOrEnumRuleCall();
	    }

)

)
))
    |(
(
		{
	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionStringLiteralExpCSParserRuleCall_1_0());
	    }
		lv_ownedInitExpression_3_0=ruleStringLiteralExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
	        }
       		set(
       			$current,
       			"ownedInitExpression",
        		lv_ownedInitExpression_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.StringLiteralExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRulePatternExpCS
entryRulePatternExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPatternExpCSRule()); }
	 iv_rulePatternExpCS=rulePatternExpCS
	 { $current=$iv_rulePatternExpCS.current; }
	 EOF
;

// Rule PatternExpCS
rulePatternExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0());
	    }
		lv_patternVariableName_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPatternExpCSRule());
	        }
       		set(
       			$current,
       			"patternVariableName",
        		lv_patternVariableName_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_1=':'
    {
    	newLeafNode(otherlv_1, grammarAccess.getPatternExpCSAccess().getColonKeyword_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeTypeExpCSParserRuleCall_2_0());
	    }
		lv_ownedPatternType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPatternExpCSRule());
	        }
       		set(
       			$current,
       			"ownedPatternType",
        		lv_ownedPatternType_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleLambdaLiteralExpCS
entryRuleLambdaLiteralExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLambdaLiteralExpCSRule()); }
	 iv_ruleLambdaLiteralExpCS=ruleLambdaLiteralExpCS
	 { $current=$iv_ruleLambdaLiteralExpCS.current; }
	 EOF
;

// Rule LambdaLiteralExpCS
ruleLambdaLiteralExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='Lambda'
    {
    	newLeafNode(otherlv_0, grammarAccess.getLambdaLiteralExpCSAccess().getLambdaKeyword_0());
    }
	otherlv_1='{'
    {
    	newLeafNode(otherlv_1, grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0());
	    }
		lv_ownedExpressionCS_2_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLambdaLiteralExpCSRule());
	        }
       		set(
       			$current,
       			"ownedExpressionCS",
        		lv_ownedExpressionCS_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='}'
    {
    	newLeafNode(otherlv_3, grammarAccess.getLambdaLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleMapLiteralExpCS
entryRuleMapLiteralExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getMapLiteralExpCSRule()); }
	 iv_ruleMapLiteralExpCS=ruleMapLiteralExpCS
	 { $current=$iv_ruleMapLiteralExpCS.current; }
	 EOF
;

// Rule MapLiteralExpCS
ruleMapLiteralExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0());
	    }
		lv_ownedType_0_0=ruleMapTypeCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapTypeCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='{'
    {
    	newLeafNode(otherlv_1, grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0());
	    }
		lv_ownedParts_2_0=ruleMapLiteralPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
	        }
       		add(
       			$current,
       			"ownedParts",
        		lv_ownedParts_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapLiteralPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=','
    {
    	newLeafNode(otherlv_3, grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0());
	    }
		lv_ownedParts_4_0=ruleMapLiteralPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
	        }
       		add(
       			$current,
       			"ownedParts",
        		lv_ownedParts_4_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapLiteralPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_5='}'
    {
    	newLeafNode(otherlv_5, grammarAccess.getMapLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleMapLiteralPartCS
entryRuleMapLiteralPartCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getMapLiteralPartCSRule()); }
	 iv_ruleMapLiteralPartCS=ruleMapLiteralPartCS
	 { $current=$iv_ruleMapLiteralPartCS.current; }
	 EOF
;

// Rule MapLiteralPartCS
ruleMapLiteralPartCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0());
	    }
		lv_ownedKey_0_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMapLiteralPartCSRule());
	        }
       		set(
       			$current,
       			"ownedKey",
        		lv_ownedKey_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='with'
    {
    	newLeafNode(otherlv_1, grammarAccess.getMapLiteralPartCSAccess().getWithKeyword_1_0());
    }

    |	otherlv_2='<-'
    {
    	newLeafNode(otherlv_2, grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1_1());
    }
)(
(
		{
	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0());
	    }
		lv_ownedValue_3_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMapLiteralPartCSRule());
	        }
       		set(
       			$current,
       			"ownedValue",
        		lv_ownedValue_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRulePrimitiveLiteralExpCS
entryRulePrimitiveLiteralExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); }
	 iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS
	 { $current=$iv_rulePrimitiveLiteralExpCS.current; }
	 EOF
;

// Rule PrimitiveLiteralExpCS
rulePrimitiveLiteralExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0());
    }
    this_NumberLiteralExpCS_0=ruleNumberLiteralExpCS
    {
        $current = $this_NumberLiteralExpCS_0.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1());
    }
    this_StringLiteralExpCS_1=ruleStringLiteralExpCS
    {
        $current = $this_StringLiteralExpCS_1.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2());
    }
    this_BooleanLiteralExpCS_2=ruleBooleanLiteralExpCS
    {
        $current = $this_BooleanLiteralExpCS_2.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3());
    }
    this_UnlimitedNaturalLiteralExpCS_3=ruleUnlimitedNaturalLiteralExpCS
    {
        $current = $this_UnlimitedNaturalLiteralExpCS_3.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4());
    }
    this_InvalidLiteralExpCS_4=ruleInvalidLiteralExpCS
    {
        $current = $this_InvalidLiteralExpCS_4.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5());
    }
    this_NullLiteralExpCS_5=ruleNullLiteralExpCS
    {
        $current = $this_NullLiteralExpCS_5.current;
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleTupleLiteralExpCS
entryRuleTupleLiteralExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); }
	 iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS
	 { $current=$iv_ruleTupleLiteralExpCS.current; }
	 EOF
;

// Rule TupleLiteralExpCS
ruleTupleLiteralExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='Tuple'
    {
    	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
    }
	otherlv_1='{'
    {
    	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0());
	    }
		lv_ownedParts_2_0=ruleTupleLiteralPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTupleLiteralExpCSRule());
	        }
       		add(
       			$current,
       			"ownedParts",
        		lv_ownedParts_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TupleLiteralPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=','
    {
    	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0());
	    }
		lv_ownedParts_4_0=ruleTupleLiteralPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTupleLiteralExpCSRule());
	        }
       		add(
       			$current,
       			"ownedParts",
        		lv_ownedParts_4_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TupleLiteralPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_5='}'
    {
    	newLeafNode(otherlv_5, grammarAccess.getTupleLiteralExpCSAccess().getRightCurlyBracketKeyword_4());
    }
)
;





// Entry rule entryRuleTupleLiteralPartCS
entryRuleTupleLiteralPartCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); }
	 iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS
	 { $current=$iv_ruleTupleLiteralPartCS.current; }
	 EOF
;

// Rule TupleLiteralPartCS
ruleTupleLiteralPartCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
	    }
		lv_name_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1=':'
    {
    	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0());
	    }
		lv_ownedType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_3='='
    {
    	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_0());
	    }
		lv_ownedInitExpression_4_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
	        }
       		set(
       			$current,
       			"ownedInitExpression",
        		lv_ownedInitExpression_4_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleNumberLiteralExpCS
entryRuleNumberLiteralExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); }
	 iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS
	 { $current=$iv_ruleNumberLiteralExpCS.current; }
	 EOF
;

// Rule NumberLiteralExpCS
ruleNumberLiteralExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
(
		{
	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0());
	    }
		lv_symbol_0_0=ruleNUMBER_LITERAL		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNumberLiteralExpCSRule());
	        }
       		set(
       			$current,
       			"symbol",
        		lv_symbol_0_0,
        		"org.eclipse.ocl.xtext.base.Base.NUMBER_LITERAL");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleStringLiteralExpCS
entryRuleStringLiteralExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); }
	 iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS
	 { $current=$iv_ruleStringLiteralExpCS.current; }
	 EOF
;

// Rule StringLiteralExpCS
ruleStringLiteralExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
(
		{
	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0());
	    }
		lv_segments_0_0=ruleStringLiteral		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStringLiteralExpCSRule());
	        }
       		add(
       			$current,
       			"segments",
        		lv_segments_0_0,
        		"org.eclipse.ocl.xtext.base.Base.StringLiteral");
	        afterParserOrEnumRuleCall();
	    }

)
)+
;





// Entry rule entryRuleBooleanLiteralExpCS
entryRuleBooleanLiteralExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); }
	 iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS
	 { $current=$iv_ruleBooleanLiteralExpCS.current; }
	 EOF
;

// Rule BooleanLiteralExpCS
ruleBooleanLiteralExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		lv_symbol_0_0=	'true'
    {
        newLeafNode(lv_symbol_0_0, grammarAccess.getBooleanLiteralExpCSAccess().getSymbolTrueKeyword_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
	        }
       		setWithLastConsumed($current, "symbol", lv_symbol_0_0, "true");
	    }

)
)
    |(
(
		lv_symbol_1_0=	'false'
    {
        newLeafNode(lv_symbol_1_0, grammarAccess.getBooleanLiteralExpCSAccess().getSymbolFalseKeyword_1_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
	        }
       		setWithLastConsumed($current, "symbol", lv_symbol_1_0, "false");
	    }

)
))
;





// Entry rule entryRuleUnlimitedNaturalLiteralExpCS
entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); }
	 iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS
	 { $current=$iv_ruleUnlimitedNaturalLiteralExpCS.current; }
	 EOF
;

// Rule UnlimitedNaturalLiteralExpCS
ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0(),
            $current);
    }
)	otherlv_1='*'
    {
    	newLeafNode(otherlv_1, grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getAsteriskKeyword_1());
    }
)
;





// Entry rule entryRuleInvalidLiteralExpCS
entryRuleInvalidLiteralExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); }
	 iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS
	 { $current=$iv_ruleInvalidLiteralExpCS.current; }
	 EOF
;

// Rule InvalidLiteralExpCS
ruleInvalidLiteralExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0(),
            $current);
    }
)	otherlv_1='invalid'
    {
    	newLeafNode(otherlv_1, grammarAccess.getInvalidLiteralExpCSAccess().getInvalidKeyword_1());
    }
)
;





// Entry rule entryRuleNullLiteralExpCS
entryRuleNullLiteralExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); }
	 iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS
	 { $current=$iv_ruleNullLiteralExpCS.current; }
	 EOF
;

// Rule NullLiteralExpCS
ruleNullLiteralExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0(),
            $current);
    }
)	otherlv_1='null'
    {
    	newLeafNode(otherlv_1, grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1());
    }
)
;





// Entry rule entryRuleTypeLiteralCS
entryRuleTypeLiteralCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTypeLiteralCSRule()); }
	 iv_ruleTypeLiteralCS=ruleTypeLiteralCS
	 { $current=$iv_ruleTypeLiteralCS.current; }
	 EOF
;

// Rule TypeLiteralCS
ruleTypeLiteralCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0());
    }
    this_PrimitiveTypeCS_0=rulePrimitiveTypeCS
    {
        $current = $this_PrimitiveTypeCS_0.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1());
    }
    this_CollectionTypeCS_1=ruleCollectionTypeCS
    {
        $current = $this_CollectionTypeCS_1.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getMapTypeCSParserRuleCall_2());
    }
    this_MapTypeCS_2=ruleMapTypeCS
    {
        $current = $this_MapTypeCS_2.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_3());
    }
    this_TupleTypeCS_3=ruleTupleTypeCS
    {
        $current = $this_TupleTypeCS_3.current;
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleTypeLiteralWithMultiplicityCS
entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); }
	 iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS
	 { $current=$iv_ruleTypeLiteralWithMultiplicityCS.current; }
	 EOF
;

// Rule TypeLiteralWithMultiplicityCS
ruleTypeLiteralWithMultiplicityCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0());
    }
    this_TypeLiteralCS_0=ruleTypeLiteralCS
    {
        $current = $this_TypeLiteralCS_0.current;
        afterParserOrEnumRuleCall();
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0());
	    }
		lv_ownedMultiplicity_1_0=ruleMultiplicityCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeLiteralWithMultiplicityCSRule());
	        }
       		set(
       			$current,
       			"ownedMultiplicity",
        		lv_ownedMultiplicity_1_0,
        		"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleTypeLiteralExpCS
entryRuleTypeLiteralExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); }
	 iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS
	 { $current=$iv_ruleTypeLiteralExpCS.current; }
	 EOF
;

// Rule TypeLiteralExpCS
ruleTypeLiteralExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
(
		{
	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0());
	    }
		lv_ownedType_0_0=ruleTypeLiteralWithMultiplicityCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeLiteralExpCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeLiteralWithMultiplicityCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleTypeNameExpCS
entryRuleTypeNameExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTypeNameExpCSRule()); }
	 iv_ruleTypeNameExpCS=ruleTypeNameExpCS
	 { $current=$iv_ruleTypeNameExpCS.current; }
	 EOF
;

// Rule TypeNameExpCS
ruleTypeNameExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0());
	    }
		lv_ownedPathName_0_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
	        }
       		set(
       			$current,
       			"ownedPathName",
        		lv_ownedPathName_0_0,
        		"org.eclipse.ocl.xtext.base.Base.PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)((
(
		{
	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0());
	    }
		lv_ownedCurlyBracketedClause_1_0=ruleCurlyBracketedClauseCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
	        }
       		set(
       			$current,
       			"ownedCurlyBracketedClause",
        		lv_ownedCurlyBracketedClause_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CurlyBracketedClauseCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2='{'
    {
    	newLeafNode(otherlv_2, grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0());
	    }
		lv_ownedPatternGuard_3_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
	        }
       		set(
       			$current,
       			"ownedPatternGuard",
        		lv_ownedPatternGuard_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4='}'
    {
    	newLeafNode(otherlv_4, grammarAccess.getTypeNameExpCSAccess().getRightCurlyBracketKeyword_1_1_2());
    }
)?)?)
;





// Entry rule entryRuleTypeExpWithoutMultiplicityCS
entryRuleTypeExpWithoutMultiplicityCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTypeExpWithoutMultiplicityCSRule()); }
	 iv_ruleTypeExpWithoutMultiplicityCS=ruleTypeExpWithoutMultiplicityCS
	 { $current=$iv_ruleTypeExpWithoutMultiplicityCS.current; }
	 EOF
;

// Rule TypeExpWithoutMultiplicityCS
ruleTypeExpWithoutMultiplicityCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getTypeNameExpCSParserRuleCall_0());
    }
    this_TypeNameExpCS_0=ruleTypeNameExpCS
    {
        $current = $this_TypeNameExpCS_0.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_1());
    }
    this_TypeLiteralCS_1=ruleTypeLiteralCS
    {
        $current = $this_TypeLiteralCS_1.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getCollectionPatternCSParserRuleCall_2());
    }
    this_CollectionPatternCS_2=ruleCollectionPatternCS
    {
        $current = $this_CollectionPatternCS_2.current;
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleTypeExpCS
entryRuleTypeExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTypeExpCSRule()); }
	 iv_ruleTypeExpCS=ruleTypeExpCS
	 { $current=$iv_ruleTypeExpCS.current; }
	 EOF
;

// Rule TypeExpCS
ruleTypeExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeExpWithoutMultiplicityCSParserRuleCall_0());
    }
    this_TypeExpWithoutMultiplicityCS_0=ruleTypeExpWithoutMultiplicityCS
    {
        $current = $this_TypeExpWithoutMultiplicityCS_0.current;
        afterParserOrEnumRuleCall();
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0());
	    }
		lv_ownedMultiplicity_1_0=ruleMultiplicityCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeExpCSRule());
	        }
       		set(
       			$current,
       			"ownedMultiplicity",
        		lv_ownedMultiplicity_1_0,
        		"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleExpCS
entryRuleExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getExpCSRule()); }
	 iv_ruleExpCS=ruleExpCS
	 { $current=$iv_ruleExpCS.current; }
	 EOF
;

// Rule ExpCS
ruleExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0());
    }
    this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS
    {
        $current = $this_PrefixedPrimaryExpCS_0.current;
        afterParserOrEnumRuleCall();
    }
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0(),
            $current);
    }
)(
(
		{
	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0());
	    }
		lv_name_2_0=ruleBinaryOperatorName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExpCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.BinaryOperatorName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0());
	    }
		lv_ownedRight_3_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExpCSRule());
	        }
       		set(
       			$current,
       			"ownedRight",
        		lv_ownedRight_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedLetExpCSParserRuleCall_1());
    }
    this_PrefixedLetExpCS_4=rulePrefixedLetExpCS
    {
        $current = $this_PrefixedLetExpCS_4.current;
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRulePrefixedLetExpCS
entryRulePrefixedLetExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPrefixedLetExpCSRule()); }
	 iv_rulePrefixedLetExpCS=rulePrefixedLetExpCS
	 { $current=$iv_rulePrefixedLetExpCS.current; }
	 EOF
;

// Rule PrefixedLetExpCS
rulePrefixedLetExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getPrefixedLetExpCSAccess().getPrefixExpCSAction_0_0(),
            $current);
    }
)(
(
		{
	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0());
	    }
		lv_name_1_0=ruleUnaryOperatorName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrefixedLetExpCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnaryOperatorName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0());
	    }
		lv_ownedRight_2_0=rulePrefixedLetExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrefixedLetExpCSRule());
	        }
       		set(
       			$current,
       			"ownedRight",
        		lv_ownedRight_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrefixedLetExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getLetExpCSParserRuleCall_1());
    }
    this_LetExpCS_3=ruleLetExpCS
    {
        $current = $this_LetExpCS_3.current;
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRulePrefixedPrimaryExpCS
entryRulePrefixedPrimaryExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSRule()); }
	 iv_rulePrefixedPrimaryExpCS=rulePrefixedPrimaryExpCS
	 { $current=$iv_rulePrefixedPrimaryExpCS.current; }
	 EOF
;

// Rule PrefixedPrimaryExpCS
rulePrefixedPrimaryExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getPrefixedPrimaryExpCSAccess().getPrefixExpCSAction_0_0(),
            $current);
    }
)(
(
		{
	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0());
	    }
		lv_name_1_0=ruleUnaryOperatorName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrefixedPrimaryExpCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnaryOperatorName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0());
	    }
		lv_ownedRight_2_0=rulePrefixedPrimaryExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrefixedPrimaryExpCSRule());
	        }
       		set(
       			$current,
       			"ownedRight",
        		lv_ownedRight_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrefixedPrimaryExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_1());
    }
    this_PrimaryExpCS_3=rulePrimaryExpCS
    {
        $current = $this_PrimaryExpCS_3.current;
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRulePrimaryExpCS
entryRulePrimaryExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPrimaryExpCSRule()); }
	 iv_rulePrimaryExpCS=rulePrimaryExpCS
	 { $current=$iv_rulePrimaryExpCS.current; }
	 EOF
;

// Rule PrimaryExpCS
rulePrimaryExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0());
    }
    this_NestedExpCS_0=ruleNestedExpCS
    {
        $current = $this_NestedExpCS_0.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1());
    }
    this_IfExpCS_1=ruleIfExpCS
    {
        $current = $this_IfExpCS_1.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2());
    }
    this_SelfExpCS_2=ruleSelfExpCS
    {
        $current = $this_SelfExpCS_2.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3());
    }
    this_PrimitiveLiteralExpCS_3=rulePrimitiveLiteralExpCS
    {
        $current = $this_PrimitiveLiteralExpCS_3.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4());
    }
    this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS
    {
        $current = $this_TupleLiteralExpCS_4.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getMapLiteralExpCSParserRuleCall_5());
    }
    this_MapLiteralExpCS_5=ruleMapLiteralExpCS
    {
        $current = $this_MapLiteralExpCS_5.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_6());
    }
    this_CollectionLiteralExpCS_6=ruleCollectionLiteralExpCS
    {
        $current = $this_CollectionLiteralExpCS_6.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLambdaLiteralExpCSParserRuleCall_7());
    }
    this_LambdaLiteralExpCS_7=ruleLambdaLiteralExpCS
    {
        $current = $this_LambdaLiteralExpCS_7.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_8());
    }
    this_TypeLiteralExpCS_8=ruleTypeLiteralExpCS
    {
        $current = $this_TypeLiteralExpCS_8.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_9());
    }
    this_NameExpCS_9=ruleNameExpCS
    {
        $current = $this_NameExpCS_9.current;
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleNameExpCS
entryRuleNameExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getNameExpCSRule()); }
	 iv_ruleNameExpCS=ruleNameExpCS
	 { $current=$iv_ruleNameExpCS.current; }
	 EOF
;

// Rule NameExpCS
ruleNameExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0());
	    }
		lv_ownedPathName_0_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNameExpCSRule());
	        }
       		set(
       			$current,
       			"ownedPathName",
        		lv_ownedPathName_0_0,
        		"org.eclipse.ocl.xtext.base.Base.PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0());
	    }
		lv_ownedSquareBracketedClauses_1_0=ruleSquareBracketedClauseCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNameExpCSRule());
	        }
       		add(
       			$current,
       			"ownedSquareBracketedClauses",
        		lv_ownedSquareBracketedClauses_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.SquareBracketedClauseCS");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{
	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0());
	    }
		lv_ownedRoundBracketedClause_2_0=ruleRoundBracketedClauseCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNameExpCSRule());
	        }
       		set(
       			$current,
       			"ownedRoundBracketedClause",
        		lv_ownedRoundBracketedClause_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.RoundBracketedClauseCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{
	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0());
	    }
		lv_ownedCurlyBracketedClause_3_0=ruleCurlyBracketedClauseCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNameExpCSRule());
	        }
       		set(
       			$current,
       			"ownedCurlyBracketedClause",
        		lv_ownedCurlyBracketedClause_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CurlyBracketedClauseCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?((
(
		lv_isPre_4_0=	'@'
    {
        newLeafNode(lv_isPre_4_0, grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getNameExpCSRule());
	        }
       		setWithLastConsumed($current, "isPre", true, "@");
	    }

)
)	otherlv_5='pre'
    {
    	newLeafNode(otherlv_5, grammarAccess.getNameExpCSAccess().getPreKeyword_4_1());
    }
)?)
;





// Entry rule entryRuleCurlyBracketedClauseCS
entryRuleCurlyBracketedClauseCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getCurlyBracketedClauseCSRule()); }
	 iv_ruleCurlyBracketedClauseCS=ruleCurlyBracketedClauseCS
	 { $current=$iv_ruleCurlyBracketedClauseCS.current; }
	 EOF
;

// Rule CurlyBracketedClauseCS
ruleCurlyBracketedClauseCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getCurlyBracketedClauseCSAccess().getCurlyBracketedClauseCSAction_0(),
            $current);
    }
)	otherlv_1='{'
    {
    	newLeafNode(otherlv_1, grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_0());
	    }
		lv_ownedParts_2_0=ruleShadowPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
	        }
       		add(
       			$current,
       			"ownedParts",
        		lv_ownedParts_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ShadowPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=','
    {
    	newLeafNode(otherlv_3, grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_1_1_0());
	    }
		lv_ownedParts_4_0=ruleShadowPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
	        }
       		add(
       			$current,
       			"ownedParts",
        		lv_ownedParts_4_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ShadowPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_5='}'
    {
    	newLeafNode(otherlv_5, grammarAccess.getCurlyBracketedClauseCSAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleRoundBracketedClauseCS
entryRuleRoundBracketedClauseCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getRoundBracketedClauseCSRule()); }
	 iv_ruleRoundBracketedClauseCS=ruleRoundBracketedClauseCS
	 { $current=$iv_ruleRoundBracketedClauseCS.current; }
	 EOF
;

// Rule RoundBracketedClauseCS
ruleRoundBracketedClauseCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getRoundBracketedClauseCSAccess().getRoundBracketedClauseCSAction_0(),
            $current);
    }
)	otherlv_1='('
    {
    	newLeafNode(otherlv_1, grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0());
	    }
		lv_ownedArguments_2_0=ruleNavigatingArgCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
	        }
       		add(
       			$current,
       			"ownedArguments",
        		lv_ownedArguments_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
(
		{
	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0_0());
	    }
		lv_ownedArguments_3_1=ruleNavigatingCommaArgCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
	        }
       		add(
       			$current,
       			"ownedArguments",
        		lv_ownedArguments_3_1,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingCommaArgCS");
	        afterParserOrEnumRuleCall();
	    }

    |		{
	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_1_0_1());
	    }
		lv_ownedArguments_3_2=ruleNavigatingSemiArgCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
	        }
       		add(
       			$current,
       			"ownedArguments",
        		lv_ownedArguments_3_2,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingSemiArgCS");
	        afterParserOrEnumRuleCall();
	    }

    |		{
	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_1_0_2());
	    }
		lv_ownedArguments_3_3=ruleNavigatingBarArgCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
	        }
       		add(
       			$current,
       			"ownedArguments",
        		lv_ownedArguments_3_3,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingBarArgCS");
	        afterParserOrEnumRuleCall();
	    }

)

)
)*)?	otherlv_4=')'
    {
    	newLeafNode(otherlv_4, grammarAccess.getRoundBracketedClauseCSAccess().getRightParenthesisKeyword_3());
    }
)
;





// Entry rule entryRuleSquareBracketedClauseCS
entryRuleSquareBracketedClauseCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getSquareBracketedClauseCSRule()); }
	 iv_ruleSquareBracketedClauseCS=ruleSquareBracketedClauseCS
	 { $current=$iv_ruleSquareBracketedClauseCS.current; }
	 EOF
;

// Rule SquareBracketedClauseCS
ruleSquareBracketedClauseCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='['
    {
    	newLeafNode(otherlv_0, grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0());
	    }
		lv_ownedTerms_1_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
	        }
       		add(
       			$current,
       			"ownedTerms",
        		lv_ownedTerms_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=','
    {
    	newLeafNode(otherlv_2, grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0());
	    }
		lv_ownedTerms_3_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
	        }
       		add(
       			$current,
       			"ownedTerms",
        		lv_ownedTerms_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_4=']'
    {
    	newLeafNode(otherlv_4, grammarAccess.getSquareBracketedClauseCSAccess().getRightSquareBracketKeyword_3());
    }
)
;





// Entry rule entryRuleNavigatingArgCS
entryRuleNavigatingArgCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getNavigatingArgCSRule()); }
	 iv_ruleNavigatingArgCS=ruleNavigatingArgCS
	 { $current=$iv_ruleNavigatingArgCS.current; }
	 EOF
;

// Rule NavigatingArgCS
ruleNavigatingArgCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(((
(
		{
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0());
	    }
		lv_ownedNameExpression_0_0=ruleNavigatingArgExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current,
       			"ownedNameExpression",
        		lv_ownedNameExpression_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(((	otherlv_1='with'
    {
    	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_0_0_0());
    }

    |	otherlv_2='<-'
    {
    	newLeafNode(otherlv_2, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_0_0_1());
    }
)(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_0_1_0());
	    }
		lv_ownedCoIterator_3_0=ruleCoIteratorVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current,
       			"ownedCoIterator",
        		lv_ownedCoIterator_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='='
    {
    	newLeafNode(otherlv_4, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0());
	    }
		lv_ownedInitExpression_5_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current,
       			"ownedInitExpression",
        		lv_ownedInitExpression_5_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
    |(	otherlv_6=':'
    {
    	newLeafNode(otherlv_6, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_1_1_0());
	    }
		lv_ownedType_7_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_7_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)((	otherlv_8='with'
    {
    	newLeafNode(otherlv_8, grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_1_2_0_0());
    }

    |	otherlv_9='<-'
    {
    	newLeafNode(otherlv_9, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_1_2_0_1());
    }
)(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_1_2_1_0());
	    }
		lv_ownedCoIterator_10_0=ruleCoIteratorVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current,
       			"ownedCoIterator",
        		lv_ownedCoIterator_10_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_11='='
    {
    	newLeafNode(otherlv_11, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_1_3_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_3_1_0());
	    }
		lv_ownedInitExpression_12_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current,
       			"ownedInitExpression",
        		lv_ownedInitExpression_12_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
    |((	otherlv_13=':'
    {
    	newLeafNode(otherlv_13, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_2_0_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_2_0_1_0());
	    }
		lv_ownedType_14_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_14_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?((	otherlv_15='with'
    {
    	newLeafNode(otherlv_15, grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_2_1_0_0());
    }

    |	otherlv_16='<-'
    {
    	newLeafNode(otherlv_16, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_2_1_0_1());
    }
)(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_2_1_1_0());
	    }
		lv_ownedCoIterator_17_0=ruleCoIteratorVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current,
       			"ownedCoIterator",
        		lv_ownedCoIterator_17_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_18='in'
    {
    	newLeafNode(otherlv_18, grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_2_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_2_3_0());
	    }
		lv_ownedInitExpression_19_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current,
       			"ownedInitExpression",
        		lv_ownedInitExpression_19_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)))?)
    |(	otherlv_20=':'
    {
    	newLeafNode(otherlv_20, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0());
	    }
		lv_ownedType_21_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_21_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)))
;





// Entry rule entryRuleNavigatingBarArgCS
entryRuleNavigatingBarArgCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); }
	 iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS
	 { $current=$iv_ruleNavigatingBarArgCS.current; }
	 EOF
;

// Rule NavigatingBarArgCS
ruleNavigatingBarArgCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		lv_prefix_0_0=	'|'
    {
        newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingBarArgCSAccess().getPrefixVerticalLineKeyword_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getNavigatingBarArgCSRule());
	        }
       		setWithLastConsumed($current, "prefix", lv_prefix_0_0, "|");
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0());
	    }
		lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
	        }
       		set(
       			$current,
       			"ownedNameExpression",
        		lv_ownedNameExpression_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=':'
    {
    	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0());
	    }
		lv_ownedType_3_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='='
    {
    	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0());
	    }
		lv_ownedInitExpression_5_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
	        }
       		set(
       			$current,
       			"ownedInitExpression",
        		lv_ownedInitExpression_5_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)?)
;





// Entry rule entryRuleNavigatingCommaArgCS
entryRuleNavigatingCommaArgCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); }
	 iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS
	 { $current=$iv_ruleNavigatingCommaArgCS.current; }
	 EOF
;

// Rule NavigatingCommaArgCS
ruleNavigatingCommaArgCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		lv_prefix_0_0=	','
    {
        newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingCommaArgCSAccess().getPrefixCommaKeyword_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		setWithLastConsumed($current, "prefix", lv_prefix_0_0, ",");
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0());
	    }
		lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		set(
       			$current,
       			"ownedNameExpression",
        		lv_ownedNameExpression_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(((	otherlv_2='with'
    {
    	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_0_0_0());
    }

    |	otherlv_3='<-'
    {
    	newLeafNode(otherlv_3, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_0_0_1());
    }
)(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_0_1_0());
	    }
		lv_ownedCoIterator_4_0=ruleCoIteratorVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		set(
       			$current,
       			"ownedCoIterator",
        		lv_ownedCoIterator_4_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5='='
    {
    	newLeafNode(otherlv_5, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0());
	    }
		lv_ownedInitExpression_6_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		set(
       			$current,
       			"ownedInitExpression",
        		lv_ownedInitExpression_6_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
    |(	otherlv_7=':'
    {
    	newLeafNode(otherlv_7, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_1_0());
	    }
		lv_ownedType_8_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_8_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)((	otherlv_9='with'
    {
    	newLeafNode(otherlv_9, grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_1_2_0_0());
    }

    |	otherlv_10='<-'
    {
    	newLeafNode(otherlv_10, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_1_2_0_1());
    }
)(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_1_2_1_0());
	    }
		lv_ownedCoIterator_11_0=ruleCoIteratorVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		set(
       			$current,
       			"ownedCoIterator",
        		lv_ownedCoIterator_11_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_12='='
    {
    	newLeafNode(otherlv_12, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_1_3_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_3_1_0());
	    }
		lv_ownedInitExpression_13_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		set(
       			$current,
       			"ownedInitExpression",
        		lv_ownedInitExpression_13_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
    |((	otherlv_14=':'
    {
    	newLeafNode(otherlv_14, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_2_0_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_2_0_1_0());
	    }
		lv_ownedType_15_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_15_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?((	otherlv_16='with'
    {
    	newLeafNode(otherlv_16, grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_2_1_0_0());
    }

    |	otherlv_17='<-'
    {
    	newLeafNode(otherlv_17, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_2_1_0_1());
    }
)(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_2_1_1_0());
	    }
		lv_ownedCoIterator_18_0=ruleCoIteratorVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		set(
       			$current,
       			"ownedCoIterator",
        		lv_ownedCoIterator_18_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_19='in'
    {
    	newLeafNode(otherlv_19, grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_2_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_3_0());
	    }
		lv_ownedInitExpression_20_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		set(
       			$current,
       			"ownedInitExpression",
        		lv_ownedInitExpression_20_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)))?)
;





// Entry rule entryRuleNavigatingSemiArgCS
entryRuleNavigatingSemiArgCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); }
	 iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS
	 { $current=$iv_ruleNavigatingSemiArgCS.current; }
	 EOF
;

// Rule NavigatingSemiArgCS
ruleNavigatingSemiArgCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		lv_prefix_0_0=	';'
    {
        newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingSemiArgCSAccess().getPrefixSemicolonKeyword_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getNavigatingSemiArgCSRule());
	        }
       		setWithLastConsumed($current, "prefix", lv_prefix_0_0, ";");
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0());
	    }
		lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
	        }
       		set(
       			$current,
       			"ownedNameExpression",
        		lv_ownedNameExpression_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=':'
    {
    	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0());
	    }
		lv_ownedType_3_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='='
    {
    	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0());
	    }
		lv_ownedInitExpression_5_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
	        }
       		set(
       			$current,
       			"ownedInitExpression",
        		lv_ownedInitExpression_5_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)?)
;





// Entry rule entryRuleNavigatingArgExpCS
entryRuleNavigatingArgExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); }
	 iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS
	 { $current=$iv_ruleNavigatingArgExpCS.current; }
	 EOF
;

// Rule NavigatingArgExpCS
ruleNavigatingArgExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:

	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall());
    }
    this_ExpCS_0=ruleExpCS
    {
        $current = $this_ExpCS_0.current;
        afterParserOrEnumRuleCall();
    }

;





// Entry rule entryRuleCoIteratorVariableCS
entryRuleCoIteratorVariableCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getCoIteratorVariableCSRule()); }
	 iv_ruleCoIteratorVariableCS=ruleCoIteratorVariableCS
	 { $current=$iv_ruleCoIteratorVariableCS.current; }
	 EOF
;

// Rule CoIteratorVariableCS
ruleCoIteratorVariableCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getCoIteratorVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
	    }
		lv_name_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCoIteratorVariableCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1=':'
    {
    	newLeafNode(otherlv_1, grammarAccess.getCoIteratorVariableCSAccess().getColonKeyword_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getCoIteratorVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0());
	    }
		lv_ownedType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCoIteratorVariableCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_2_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;





// Entry rule entryRuleIfExpCS
entryRuleIfExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getIfExpCSRule()); }
	 iv_ruleIfExpCS=ruleIfExpCS
	 { $current=$iv_ruleIfExpCS.current; }
	 EOF
;

// Rule IfExpCS
ruleIfExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='if'
    {
    	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
    }
(
(
(
		{
	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0());
	    }
		lv_ownedCondition_1_1=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIfExpCSRule());
	        }
       		set(
       			$current,
       			"ownedCondition",
        		lv_ownedCondition_1_1,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

    |		{
	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1());
	    }
		lv_ownedCondition_1_2=rulePatternExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIfExpCSRule());
	        }
       		set(
       			$current,
       			"ownedCondition",
        		lv_ownedCondition_1_2,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
	        afterParserOrEnumRuleCall();
	    }

)

)
)	otherlv_2='then'
    {
    	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0());
	    }
		lv_ownedThenExpression_3_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIfExpCSRule());
	        }
       		set(
       			$current,
       			"ownedThenExpression",
        		lv_ownedThenExpression_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0());
	    }
		lv_ownedIfThenExpressions_4_0=ruleElseIfThenExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIfExpCSRule());
	        }
       		add(
       			$current,
       			"ownedIfThenExpressions",
        		lv_ownedIfThenExpressions_4_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ElseIfThenExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_5='else'
    {
    	newLeafNode(otherlv_5, grammarAccess.getIfExpCSAccess().getElseKeyword_5());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0());
	    }
		lv_ownedElseExpression_6_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIfExpCSRule());
	        }
       		set(
       			$current,
       			"ownedElseExpression",
        		lv_ownedElseExpression_6_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7='endif'
    {
    	newLeafNode(otherlv_7, grammarAccess.getIfExpCSAccess().getEndifKeyword_7());
    }
)
;





// Entry rule entryRuleElseIfThenExpCS
entryRuleElseIfThenExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getElseIfThenExpCSRule()); }
	 iv_ruleElseIfThenExpCS=ruleElseIfThenExpCS
	 { $current=$iv_ruleElseIfThenExpCS.current; }
	 EOF
;

// Rule ElseIfThenExpCS
ruleElseIfThenExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='elseif'
    {
    	newLeafNode(otherlv_0, grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0());
	    }
		lv_ownedCondition_1_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseIfThenExpCSRule());
	        }
       		set(
       			$current,
       			"ownedCondition",
        		lv_ownedCondition_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='then'
    {
    	newLeafNode(otherlv_2, grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0());
	    }
		lv_ownedThenExpression_3_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseIfThenExpCSRule());
	        }
       		set(
       			$current,
       			"ownedThenExpression",
        		lv_ownedThenExpression_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleLetExpCS
entryRuleLetExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLetExpCSRule()); }
	 iv_ruleLetExpCS=ruleLetExpCS
	 { $current=$iv_ruleLetExpCS.current; }
	 EOF
;

// Rule LetExpCS
ruleLetExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='let'
    {
    	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0());
	    }
		lv_ownedVariables_1_0=ruleLetVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLetExpCSRule());
	        }
       		add(
       			$current,
       			"ownedVariables",
        		lv_ownedVariables_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.LetVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=','
    {
    	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0());
	    }
		lv_ownedVariables_3_0=ruleLetVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLetExpCSRule());
	        }
       		add(
       			$current,
       			"ownedVariables",
        		lv_ownedVariables_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.LetVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_4='in'
    {
    	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0());
	    }
		lv_ownedInExpression_5_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLetExpCSRule());
	        }
       		set(
       			$current,
       			"ownedInExpression",
        		lv_ownedInExpression_5_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleLetVariableCS
entryRuleLetVariableCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLetVariableCSRule()); }
	 iv_ruleLetVariableCS=ruleLetVariableCS
	 { $current=$iv_ruleLetVariableCS.current; }
	 EOF
;

// Rule LetVariableCS
ruleLetVariableCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
	    }
		lv_name_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0());
	    }
		lv_ownedRoundBracketedClause_1_0=ruleRoundBracketedClauseCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
	        }
       		set(
       			$current,
       			"ownedRoundBracketedClause",
        		lv_ownedRoundBracketedClause_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.RoundBracketedClauseCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?(	otherlv_2=':'
    {
    	newLeafNode(otherlv_2, grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0());
	    }
		lv_ownedType_3_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_4='='
    {
    	newLeafNode(otherlv_4, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_4_0());
	    }
		lv_ownedInitExpression_5_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
	        }
       		set(
       			$current,
       			"ownedInitExpression",
        		lv_ownedInitExpression_5_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleNestedExpCS
entryRuleNestedExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getNestedExpCSRule()); }
	 iv_ruleNestedExpCS=ruleNestedExpCS
	 { $current=$iv_ruleNestedExpCS.current; }
	 EOF
;

// Rule NestedExpCS
ruleNestedExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='('
    {
    	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0());
	    }
		lv_ownedExpression_1_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNestedExpCSRule());
	        }
       		set(
       			$current,
       			"ownedExpression",
        		lv_ownedExpression_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2=')'
    {
    	newLeafNode(otherlv_2, grammarAccess.getNestedExpCSAccess().getRightParenthesisKeyword_2());
    }
)
;





// Entry rule entryRuleSelfExpCS
entryRuleSelfExpCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getSelfExpCSRule()); }
	 iv_ruleSelfExpCS=ruleSelfExpCS
	 { $current=$iv_ruleSelfExpCS.current; }
	 EOF
;

// Rule SelfExpCS
ruleSelfExpCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getSelfExpCSAccess().getSelfExpCSAction_0(),
            $current);
    }
)	otherlv_1='self'
    {
    	newLeafNode(otherlv_1, grammarAccess.getSelfExpCSAccess().getSelfKeyword_1());
    }
)
;





// Entry rule entryRuleMultiplicityBoundsCS
entryRuleMultiplicityBoundsCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); }
	 iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS
	 { $current=$iv_ruleMultiplicityBoundsCS.current; }
	 EOF
;

// Rule MultiplicityBoundsCS
ruleMultiplicityBoundsCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0());
	    }
		lv_lowerBound_0_0=ruleLOWER		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMultiplicityBoundsCSRule());
	        }
       		set(
       			$current,
       			"lowerBound",
        		lv_lowerBound_0_0,
        		"org.eclipse.ocl.xtext.base.Base.LOWER");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='..'
    {
    	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0());
	    }
		lv_upperBound_2_0=ruleUPPER		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMultiplicityBoundsCSRule());
	        }
       		set(
       			$current,
       			"upperBound",
        		lv_upperBound_2_0,
        		"org.eclipse.ocl.xtext.base.Base.UPPER");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;





// Entry rule entryRuleMultiplicityCS
entryRuleMultiplicityCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getMultiplicityCSRule()); }
	 iv_ruleMultiplicityCS=ruleMultiplicityCS
	 { $current=$iv_ruleMultiplicityCS.current; }
	 EOF
;

// Rule MultiplicityCS
ruleMultiplicityCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='['
    {
    	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
    }
(
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0());
    }
    this_MultiplicityBoundsCS_1=ruleMultiplicityBoundsCS
    {
        $current = $this_MultiplicityBoundsCS_1.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1());
    }
    this_MultiplicityStringCS_2=ruleMultiplicityStringCS
    {
        $current = $this_MultiplicityStringCS_2.current;
        afterParserOrEnumRuleCall();
    }
)(	otherlv_3='|?'
    {
    	newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
    }

    |(
(
		lv_isNullFree_4_0=	'|1'
    {
        newLeafNode(lv_isNullFree_4_0, grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMultiplicityCSRule());
	        }
       		setWithLastConsumed($current, "isNullFree", true, "|1");
	    }

)
))?	otherlv_5=']'
    {
    	newLeafNode(otherlv_5, grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_3());
    }
)
;





// Entry rule entryRuleMultiplicityStringCS
entryRuleMultiplicityStringCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); }
	 iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS
	 { $current=$iv_ruleMultiplicityStringCS.current; }
	 EOF
;

// Rule MultiplicityStringCS
ruleMultiplicityStringCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
(
(
		lv_stringBounds_0_1=	'*'
    {
        newLeafNode(lv_stringBounds_0_1, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
	        }
       		setWithLastConsumed($current, "stringBounds", lv_stringBounds_0_1, null);
	    }

    |		lv_stringBounds_0_2=	'+'
    {
        newLeafNode(lv_stringBounds_0_2, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
	        }
       		setWithLastConsumed($current, "stringBounds", lv_stringBounds_0_2, null);
	    }

    |		lv_stringBounds_0_3=	'?'
    {
        newLeafNode(lv_stringBounds_0_3, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
	        }
       		setWithLastConsumed($current, "stringBounds", lv_stringBounds_0_3, null);
	    }

)

)
)
;





// Entry rule entryRulePathNameCS
entryRulePathNameCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPathNameCSRule()); }
	 iv_rulePathNameCS=rulePathNameCS
	 { $current=$iv_rulePathNameCS.current; }
	 EOF
;

// Rule PathNameCS
rulePathNameCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0());
	    }
		lv_ownedPathElements_0_0=ruleFirstPathElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPathNameCSRule());
	        }
       		add(
       			$current,
       			"ownedPathElements",
        		lv_ownedPathElements_0_0,
        		"org.eclipse.ocl.xtext.base.Base.FirstPathElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='::'
    {
    	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0());
	    }
		lv_ownedPathElements_2_0=ruleNextPathElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPathNameCSRule());
	        }
       		add(
       			$current,
       			"ownedPathElements",
        		lv_ownedPathElements_2_0,
        		"org.eclipse.ocl.xtext.base.Base.NextPathElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;







// Entry rule entryRuleFirstPathElementCS
entryRuleFirstPathElementCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getFirstPathElementCSRule()); }
	 iv_ruleFirstPathElementCS=ruleFirstPathElementCS
	 { $current=$iv_ruleFirstPathElementCS.current; }
	 EOF
;

// Rule FirstPathElementCS
ruleFirstPathElementCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
(
		{
		  /* */
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFirstPathElementCSRule());
	        }
        }
		{
	        newCompositeNode(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0());
	    }
		ruleUnrestrictedName		{
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleNextPathElementCS
entryRuleNextPathElementCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getNextPathElementCSRule()); }
	 iv_ruleNextPathElementCS=ruleNextPathElementCS
	 { $current=$iv_ruleNextPathElementCS.current; }
	 EOF
;

// Rule NextPathElementCS
ruleNextPathElementCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
(
		{
		  /* */
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getNextPathElementCSRule());
	        }
        }
		{
	        newCompositeNode(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0());
	    }
		ruleUnreservedName		{
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleTemplateBindingCS
entryRuleTemplateBindingCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTemplateBindingCSRule()); }
	 iv_ruleTemplateBindingCS=ruleTemplateBindingCS
	 { $current=$iv_ruleTemplateBindingCS.current; }
	 EOF
;

// Rule TemplateBindingCS
ruleTemplateBindingCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0());
	    }
		lv_ownedSubstitutions_0_0=ruleTemplateParameterSubstitutionCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
	        }
       		add(
       			$current,
       			"ownedSubstitutions",
        		lv_ownedSubstitutions_0_0,
        		"org.eclipse.ocl.xtext.base.Base.TemplateParameterSubstitutionCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1=','
    {
    	newLeafNode(otherlv_1, grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0());
	    }
		lv_ownedSubstitutions_2_0=ruleTemplateParameterSubstitutionCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
	        }
       		add(
       			$current,
       			"ownedSubstitutions",
        		lv_ownedSubstitutions_2_0,
        		"org.eclipse.ocl.xtext.base.Base.TemplateParameterSubstitutionCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*(
(
		{
	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0());
	    }
		lv_ownedMultiplicity_3_0=ruleMultiplicityCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
	        }
       		set(
       			$current,
       			"ownedMultiplicity",
        		lv_ownedMultiplicity_3_0,
        		"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleTemplateParameterSubstitutionCS
entryRuleTemplateParameterSubstitutionCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSRule()); }
	 iv_ruleTemplateParameterSubstitutionCS=ruleTemplateParameterSubstitutionCS
	 { $current=$iv_ruleTemplateParameterSubstitutionCS.current; }
	 EOF
;

// Rule TemplateParameterSubstitutionCS
ruleTemplateParameterSubstitutionCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
(
		{
	        newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0());
	    }
		lv_ownedActualParameter_0_0=ruleTypeRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTemplateParameterSubstitutionCSRule());
	        }
       		set(
       			$current,
       			"ownedActualParameter",
        		lv_ownedActualParameter_0_0,
        		"org.eclipse.ocl.xtext.base.Base.TypeRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
;







// Entry rule entryRuleTypeParameterCS
entryRuleTypeParameterCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTypeParameterCSRule()); }
	 iv_ruleTypeParameterCS=ruleTypeParameterCS
	 { $current=$iv_ruleTypeParameterCS.current; }
	 EOF
;

// Rule TypeParameterCS
ruleTypeParameterCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
	    }
		lv_name_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='extends'
    {
    	newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0());
	    }
		lv_ownedExtends_2_0=ruleTypedRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
	        }
       		add(
       			$current,
       			"ownedExtends",
        		lv_ownedExtends_2_0,
        		"org.eclipse.ocl.xtext.base.Base.TypedRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3='&&'
    {
    	newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0());
	    }
		lv_ownedExtends_4_0=ruleTypedRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
	        }
       		add(
       			$current,
       			"ownedExtends",
        		lv_ownedExtends_4_0,
        		"org.eclipse.ocl.xtext.base.Base.TypedRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?)
;





// Entry rule entryRuleTypeRefCS
entryRuleTypeRefCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTypeRefCSRule()); }
	 iv_ruleTypeRefCS=ruleTypeRefCS
	 { $current=$iv_ruleTypeRefCS.current; }
	 EOF
;

// Rule TypeRefCS
ruleTypeRefCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0());
    }
    this_TypedRefCS_0=ruleTypedRefCS
    {
        $current = $this_TypedRefCS_0.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1());
    }
    this_WildcardTypeRefCS_1=ruleWildcardTypeRefCS
    {
        $current = $this_WildcardTypeRefCS_1.current;
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleTypedRefCS
entryRuleTypedRefCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTypedRefCSRule()); }
	 iv_ruleTypedRefCS=ruleTypedRefCS
	 { $current=$iv_ruleTypedRefCS.current; }
	 EOF
;

// Rule TypedRefCS
ruleTypedRefCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:

	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall());
    }
    this_TypedTypeRefCS_0=ruleTypedTypeRefCS
    {
        $current = $this_TypedTypeRefCS_0.current;
        afterParserOrEnumRuleCall();
    }

;





// Entry rule entryRuleTypedTypeRefCS
entryRuleTypedTypeRefCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTypedTypeRefCSRule()); }
	 iv_ruleTypedTypeRefCS=ruleTypedTypeRefCS
	 { $current=$iv_ruleTypedTypeRefCS.current; }
	 EOF
;

// Rule TypedTypeRefCS
ruleTypedTypeRefCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0());
	    }
		lv_ownedPathName_0_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
	        }
       		set(
       			$current,
       			"ownedPathName",
        		lv_ownedPathName_0_0,
        		"org.eclipse.ocl.xtext.base.Base.PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='('
    {
    	newLeafNode(otherlv_1, grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0());
	    }
		lv_ownedBinding_2_0=ruleTemplateBindingCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
	        }
       		set(
       			$current,
       			"ownedBinding",
        		lv_ownedBinding_2_0,
        		"org.eclipse.ocl.xtext.base.Base.TemplateBindingCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=')'
    {
    	newLeafNode(otherlv_3, grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_2());
    }
)?)
;





// Entry rule entryRuleWildcardTypeRefCS
entryRuleWildcardTypeRefCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getWildcardTypeRefCSRule()); }
	 iv_ruleWildcardTypeRefCS=ruleWildcardTypeRefCS
	 { $current=$iv_ruleWildcardTypeRefCS.current; }
	 EOF
;

// Rule WildcardTypeRefCS
ruleWildcardTypeRefCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0(),
            $current);
    }
)	otherlv_1='?'
    {
    	newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
    }
(	otherlv_2='extends'
    {
    	newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0());
	    }
		lv_ownedExtends_3_0=ruleTypedRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getWildcardTypeRefCSRule());
	        }
       		set(
       			$current,
       			"ownedExtends",
        		lv_ownedExtends_3_0,
        		"org.eclipse.ocl.xtext.base.Base.TypedRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;





// Entry rule entryRuleID
entryRuleID returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getIDRule()); }
	 iv_ruleID=ruleID
	 { $current=$iv_ruleID.current.getText(); }
	 EOF
;

// Rule ID
ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(    this_SIMPLE_ID_0=RULE_SIMPLE_ID    {
		$current.merge(this_SIMPLE_ID_0);
    }

    {
    newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0());
    }

    |    this_ESCAPED_ID_1=RULE_ESCAPED_ID    {
		$current.merge(this_ESCAPED_ID_1);
    }

    {
    newLeafNode(this_ESCAPED_ID_1, grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1());
    }
)
    ;





// Entry rule entryRuleIdentifier
entryRuleIdentifier returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getIdentifierRule()); }
	 iv_ruleIdentifier=ruleIdentifier
	 { $current=$iv_ruleIdentifier.current.getText(); }
	 EOF
;

// Rule Identifier
ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:

    {
        newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall());
    }
    this_ID_0=ruleID    {
		$current.merge(this_ID_0);
    }

    {
        afterParserOrEnumRuleCall();
    }

    ;





// Entry rule entryRuleLOWER
entryRuleLOWER returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getLOWERRule()); }
	 iv_ruleLOWER=ruleLOWER
	 { $current=$iv_ruleLOWER.current.getText(); }
	 EOF
;

// Rule LOWER
ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    {
    newLeafNode(this_INT_0, grammarAccess.getLOWERAccess().getINTTerminalRuleCall());
    }

    ;





// Entry rule entryRuleNUMBER_LITERAL
entryRuleNUMBER_LITERAL returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); }
	 iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL
	 { $current=$iv_ruleNUMBER_LITERAL.current.getText(); }
	 EOF
;

// Rule NUMBER_LITERAL
ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    {
    newLeafNode(this_INT_0, grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall());
    }

    ;





// Entry rule entryRuleStringLiteral
entryRuleStringLiteral returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getStringLiteralRule()); }
	 iv_ruleStringLiteral=ruleStringLiteral
	 { $current=$iv_ruleStringLiteral.current.getText(); }
	 EOF
;

// Rule StringLiteral
ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
    this_SINGLE_QUOTED_STRING_0=RULE_SINGLE_QUOTED_STRING    {
		$current.merge(this_SINGLE_QUOTED_STRING_0);
    }

    {
    newLeafNode(this_SINGLE_QUOTED_STRING_0, grammarAccess.getStringLiteralAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall());
    }

    ;





// Entry rule entryRuleUPPER
entryRuleUPPER returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getUPPERRule()); }
	 iv_ruleUPPER=ruleUPPER
	 { $current=$iv_ruleUPPER.current.getText(); }
	 EOF
;

// Rule UPPER
ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    {
    newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0());
    }

    |
	kw='*'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUPPERAccess().getAsteriskKeyword_1());
    }
)
    ;





// Entry rule entryRuleURI
entryRuleURI returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getURIRule()); }
	 iv_ruleURI=ruleURI
	 { $current=$iv_ruleURI.current.getText(); }
	 EOF
;

// Rule URI
ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
    this_SINGLE_QUOTED_STRING_0=RULE_SINGLE_QUOTED_STRING    {
		$current.merge(this_SINGLE_QUOTED_STRING_0);
    }

    {
    newLeafNode(this_SINGLE_QUOTED_STRING_0, grammarAccess.getURIAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall());
    }

    ;





fragment RULE_ESCAPED_CHARACTER : '\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\');

fragment RULE_LETTER_CHARACTER : ('a'..'z'|'A'..'Z'|'_');

RULE_DOUBLE_QUOTED_STRING : '"' (RULE_ESCAPED_CHARACTER|~(('\\'|'"')))* '"';

RULE_SINGLE_QUOTED_STRING : '\'' (RULE_ESCAPED_CHARACTER|~(('\\'|'\'')))* '\'';

RULE_ML_SINGLE_QUOTED_STRING : '/\'' ( options {greedy=false;} : . )*'\'/';

RULE_SIMPLE_ID : RULE_LETTER_CHARACTER (RULE_LETTER_CHARACTER|'0'..'9')*;

RULE_ESCAPED_ID : '_' RULE_SINGLE_QUOTED_STRING;

RULE_INT : ('0'..'9')+;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


