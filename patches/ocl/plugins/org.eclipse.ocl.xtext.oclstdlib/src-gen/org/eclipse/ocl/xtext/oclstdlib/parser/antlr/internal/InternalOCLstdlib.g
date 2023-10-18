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
grammar InternalOCLstdlib;

options {
	superClass=AbstractInternalAntlrParser;
	backtrack=true;

}

@lexer::header {
package org.eclipse.ocl.xtext.oclstdlib.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import.
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.ocl.xtext.oclstdlib.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.ocl.xtext.oclstdlib.services.OCLstdlibGrammarAccess;

}

@parser::members {

/*
  This grammar contains a lot of empty actions to work around a bug in ANTLR.
  Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
*/

 	private OCLstdlibGrammarAccess grammarAccess;

    public InternalOCLstdlibParser(TokenStream input, OCLstdlibGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Library";
   	}

   	@Override
   	protected OCLstdlibGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}




// Entry rule entryRuleLibrary
entryRuleLibrary returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLibraryRule()); }
	 iv_ruleLibrary=ruleLibrary
	 { $current=$iv_ruleLibrary.current; }
	 EOF
;

// Rule Library
ruleLibrary returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(((
(
		{
	        newCompositeNode(grammarAccess.getLibraryAccess().getOwnedImportsImportCSParserRuleCall_0_0_0());
	    }
		lv_ownedImports_0_0=ruleImportCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibraryRule());
	        }
       		add(
       			$current,
       			"ownedImports",
        		lv_ownedImports_0_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.ImportCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1=';'
    {
    	newLeafNode(otherlv_1, grammarAccess.getLibraryAccess().getSemicolonKeyword_0_1());
    }
)*(
(
		{
	        newCompositeNode(grammarAccess.getLibraryAccess().getOwnedPackagesLibPackageCSParserRuleCall_1_0());
	    }
		lv_ownedPackages_2_0=ruleLibPackageCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibraryRule());
	        }
       		add(
       			$current,
       			"ownedPackages",
        		lv_ownedPackages_2_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibPackageCS");
	        afterParserOrEnumRuleCall();
	    }

)
)*)
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
(
    {
        newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall_0());
    }
    this_ID_0=ruleID    {
		$current.merge(this_ID_0);
    }

    {
        afterParserOrEnumRuleCall();
    }

    |
    {
        newCompositeNode(grammarAccess.getIdentifierAccess().getRestrictedKeywordsParserRuleCall_1());
    }
    this_RestrictedKeywords_1=ruleRestrictedKeywords    {
		$current.merge(this_RestrictedKeywords_1);
    }

    {
        afterParserOrEnumRuleCall();
    }
)
    ;





// Entry rule entryRuleRestrictedKeywords
entryRuleRestrictedKeywords returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getRestrictedKeywordsRule()); }
	 iv_ruleRestrictedKeywords=ruleRestrictedKeywords
	 { $current=$iv_ruleRestrictedKeywords.current.getText(); }
	 EOF
;

// Rule RestrictedKeywords
ruleRestrictedKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	kw='abstract'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getAbstractKeyword_0());
    }

    |
	kw='annotation'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getAnnotationKeyword_1());
    }

    |
	kw='conformsTo'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getConformsToKeyword_2());
    }

    |
	kw='documentation'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getDocumentationKeyword_3());
    }

    |
	kw='extends'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getExtendsKeyword_4());
    }

    |
	kw='import'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getImportKeyword_5());
    }

    |
	kw='inv'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getInvKeyword_6());
    }

    |
	kw='invalidating'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getInvalidatingKeyword_7());
    }

    |
	kw='iteration'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getIterationKeyword_8());
    }

    |
	kw='left'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getLeftKeyword_9());
    }

    |
	kw='library'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getLibraryKeyword_10());
    }

    |
	kw='operation'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getOperationKeyword_11());
    }

    |
	kw='opposite'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getOppositeKeyword_12());
    }

    |
	kw='package'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getPackageKeyword_13());
    }

    |
	kw='post'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getPostKeyword_14());
    }

    |
	kw='pre'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getPreKeyword_15());
    }

    |
	kw='precedence'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getPrecedenceKeyword_16());
    }

    |
	kw='property'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getPropertyKeyword_17());
    }

    |
	kw='right'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getRightKeyword_18());
    }

    |
	kw='static'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getStaticKeyword_19());
    }

    |
	kw='type'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getTypeKeyword_20());
    }

    |
	kw='validating'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRestrictedKeywordsAccess().getValidatingKeyword_21());
    }
)
    ;





// Entry rule entryRuleName
entryRuleName returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getNameRule()); }
	 iv_ruleName=ruleName
	 { $current=$iv_ruleName.current.getText(); }
	 EOF
;

// Rule Name
ruleName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
    {
        newCompositeNode(grammarAccess.getNameAccess().getIdentifierParserRuleCall_0());
    }
    this_Identifier_0=ruleIdentifier    {
		$current.merge(this_Identifier_0);
    }

    {
        afterParserOrEnumRuleCall();
    }

    |    this_DOUBLE_QUOTED_STRING_1=RULE_DOUBLE_QUOTED_STRING    {
		$current.merge(this_DOUBLE_QUOTED_STRING_1);
    }

    {
    newLeafNode(this_DOUBLE_QUOTED_STRING_1, grammarAccess.getNameAccess().getDOUBLE_QUOTED_STRINGTerminalRuleCall_1());
    }

    |
    {
        newCompositeNode(grammarAccess.getNameAccess().getEssentialOCLReservedKeywordParserRuleCall_2());
    }
    this_EssentialOCLReservedKeyword_2=ruleEssentialOCLReservedKeyword    {
		$current.merge(this_EssentialOCLReservedKeyword_2);
    }

    {
        afterParserOrEnumRuleCall();
    }

    |
    {
        newCompositeNode(grammarAccess.getNameAccess().getPrimitiveTypeIdentifierParserRuleCall_3());
    }
    this_PrimitiveTypeIdentifier_3=rulePrimitiveTypeIdentifier    {
		$current.merge(this_PrimitiveTypeIdentifier_3);
    }

    {
        afterParserOrEnumRuleCall();
    }

    |
    {
        newCompositeNode(grammarAccess.getNameAccess().getCollectionTypeIdentifierParserRuleCall_4());
    }
    this_CollectionTypeIdentifier_4=ruleCollectionTypeIdentifier    {
		$current.merge(this_CollectionTypeIdentifier_4);
    }

    {
        afterParserOrEnumRuleCall();
    }
)
    ;





// Entry rule entryRuleAnyName
entryRuleAnyName returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getAnyNameRule()); }
	 iv_ruleAnyName=ruleAnyName
	 { $current=$iv_ruleAnyName.current.getText(); }
	 EOF
;

// Rule AnyName
ruleAnyName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
    {
        newCompositeNode(grammarAccess.getAnyNameAccess().getNameParserRuleCall_0());
    }
    this_Name_0=ruleName    {
		$current.merge(this_Name_0);
    }

    {
        afterParserOrEnumRuleCall();
    }

    |
	kw='Lambda'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getAnyNameAccess().getLambdaKeyword_1());
    }

    |
	kw='Map'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getAnyNameAccess().getMapKeyword_2());
    }

    |
	kw='Tuple'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getAnyNameAccess().getTupleKeyword_3());
    }
)
    ;





// Entry rule entryRuleLibPathNameCS
entryRuleLibPathNameCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLibPathNameCSRule()); }
	 iv_ruleLibPathNameCS=ruleLibPathNameCS
	 { $current=$iv_ruleLibPathNameCS.current; }
	 EOF
;

// Rule LibPathNameCS
ruleLibPathNameCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getLibPathNameCSAccess().getOwnedPathElementsLibPathElementCSParserRuleCall_0_0());
	    }
		lv_ownedPathElements_0_0=ruleLibPathElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibPathNameCSRule());
	        }
       		add(
       			$current,
       			"ownedPathElements",
        		lv_ownedPathElements_0_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibPathElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='::'
    {
    	newLeafNode(otherlv_1, grammarAccess.getLibPathNameCSAccess().getColonColonKeyword_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibPathNameCSAccess().getOwnedPathElementsLibPathElementCSParserRuleCall_1_1_0());
	    }
		lv_ownedPathElements_2_0=ruleLibPathElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibPathNameCSRule());
	        }
       		add(
       			$current,
       			"ownedPathElements",
        		lv_ownedPathElements_2_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibPathElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleLibPathElementCS
entryRuleLibPathElementCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLibPathElementCSRule()); }
	 iv_ruleLibPathElementCS=ruleLibPathElementCS
	 { $current=$iv_ruleLibPathElementCS.current; }
	 EOF
;

// Rule LibPathElementCS
ruleLibPathElementCS returns [EObject current=null]
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
	            $current = createModelElement(grammarAccess.getLibPathElementCSRule());
	        }
        }
		{
	        newCompositeNode(grammarAccess.getLibPathElementCSAccess().getReferredElementNamedElementCrossReference_0());
	    }
		ruleName		{
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleAccumulatorCS
entryRuleAccumulatorCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getAccumulatorCSRule()); }
	 iv_ruleAccumulatorCS=ruleAccumulatorCS
	 { $current=$iv_ruleAccumulatorCS.current; }
	 EOF
;

// Rule AccumulatorCS
ruleAccumulatorCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getAccumulatorCSAccess().getNameIdentifierParserRuleCall_0_0());
	    }
		lv_name_0_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAccumulatorCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_0_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1=':'
    {
    	newLeafNode(otherlv_1, grammarAccess.getAccumulatorCSAccess().getColonKeyword_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getAccumulatorCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0());
	    }
		lv_ownedType_2_0=ruleTypedMultiplicityRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAccumulatorCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_2_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedMultiplicityRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleAnnotationCS
entryRuleAnnotationCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getAnnotationCSRule()); }
	 iv_ruleAnnotationCS=ruleAnnotationCS
	 { $current=$iv_ruleAnnotationCS.current; }
	 EOF
;

// Rule AnnotationCS
ruleAnnotationCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='annotation'
    {
    	newLeafNode(otherlv_0, grammarAccess.getAnnotationCSAccess().getAnnotationKeyword_0());
    }
(
(
(
		{
	        newCompositeNode(grammarAccess.getAnnotationCSAccess().getNameIdentifierParserRuleCall_1_0_0());
	    }
		lv_name_1_1=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAnnotationCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_1_1,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Identifier");
	        afterParserOrEnumRuleCall();
	    }

    |		lv_name_1_2=RULE_SINGLE_QUOTED_STRING
		{
			newLeafNode(lv_name_1_2, grammarAccess.getAnnotationCSAccess().getNameSINGLE_QUOTED_STRINGTerminalRuleCall_1_0_1());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAnnotationCSRule());
	        }
       		setWithLastConsumed(
       			$current,
       			"name",
        		lv_name_1_2,
        		"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");
	    }

)

)
)(	otherlv_2='('
    {
    	newLeafNode(otherlv_2, grammarAccess.getAnnotationCSAccess().getLeftParenthesisKeyword_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getAnnotationCSAccess().getOwnedDetailsDetailCSParserRuleCall_2_1_0());
	    }
		lv_ownedDetails_3_0=ruleDetailCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAnnotationCSRule());
	        }
       		add(
       			$current,
       			"ownedDetails",
        		lv_ownedDetails_3_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.DetailCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=','
    {
    	newLeafNode(otherlv_4, grammarAccess.getAnnotationCSAccess().getCommaKeyword_2_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getAnnotationCSAccess().getOwnedDetailsDetailCSParserRuleCall_2_2_1_0());
	    }
		lv_ownedDetails_5_0=ruleDetailCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAnnotationCSRule());
	        }
       		add(
       			$current,
       			"ownedDetails",
        		lv_ownedDetails_5_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.DetailCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_6=')'
    {
    	newLeafNode(otherlv_6, grammarAccess.getAnnotationCSAccess().getRightParenthesisKeyword_2_3());
    }
)?((	otherlv_7='{'
    {
    	newLeafNode(otherlv_7, grammarAccess.getAnnotationCSAccess().getLeftCurlyBracketKeyword_3_0_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getAnnotationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_3_0_1_0());
	    }
		lv_ownedAnnotations_8_0=ruleAnnotationElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAnnotationCSRule());
	        }
       		add(
       			$current,
       			"ownedAnnotations",
        		lv_ownedAnnotations_8_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AnnotationElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_9='}'
    {
    	newLeafNode(otherlv_9, grammarAccess.getAnnotationCSAccess().getRightCurlyBracketKeyword_3_0_2());
    }
)
    |	otherlv_10=';'
    {
    	newLeafNode(otherlv_10, grammarAccess.getAnnotationCSAccess().getSemicolonKeyword_3_1());
    }
))
;





// Entry rule entryRuleAnnotationElementCS
entryRuleAnnotationElementCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getAnnotationElementCSRule()); }
	 iv_ruleAnnotationElementCS=ruleAnnotationElementCS
	 { $current=$iv_ruleAnnotationElementCS.current; }
	 EOF
;

// Rule AnnotationElementCS
ruleAnnotationElementCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getAnnotationElementCSAccess().getAnnotationCSParserRuleCall_0());
    }
    this_AnnotationCS_0=ruleAnnotationCS
    {
        $current = $this_AnnotationCS_0.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getAnnotationElementCSAccess().getDocumentationCSParserRuleCall_1());
    }
    this_DocumentationCS_1=ruleDocumentationCS
    {
        $current = $this_DocumentationCS_1.current;
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleLibClassCS
entryRuleLibClassCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLibClassCSRule()); }
	 iv_ruleLibClassCS=ruleLibClassCS
	 { $current=$iv_ruleLibClassCS.current; }
	 EOF
;

// Rule LibClassCS
ruleLibClassCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		lv_isAbstract_0_0=	'abstract'
    {
        newLeafNode(lv_isAbstract_0_0, grammarAccess.getLibClassCSAccess().getIsAbstractAbstractKeyword_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getLibClassCSRule());
	        }
       		setWithLastConsumed($current, "isAbstract", true, "abstract");
	    }

)
)?	otherlv_1='type'
    {
    	newLeafNode(otherlv_1, grammarAccess.getLibClassCSAccess().getTypeKeyword_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibClassCSAccess().getNameAnyNameParserRuleCall_2_0());
	    }
		lv_name_2_0=ruleAnyName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibClassCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_2_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AnyName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getLibClassCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0());
	    }
		lv_ownedSignature_3_0=ruleTemplateSignatureCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibClassCSRule());
	        }
       		set(
       			$current,
       			"ownedSignature",
        		lv_ownedSignature_3_0,
        		"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?(	otherlv_4=':'
    {
    	newLeafNode(otherlv_4, grammarAccess.getLibClassCSAccess().getColonKeyword_4_0());
    }
(
(
		{
		  /* */
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getLibClassCSRule());
	        }
        }
		{
	        newCompositeNode(grammarAccess.getLibClassCSAccess().getMetaclassNameMetaclassNameCSCrossReference_4_1_0());
	    }
		ruleAnyName		{
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_6='conformsTo'
    {
    	newLeafNode(otherlv_6, grammarAccess.getLibClassCSAccess().getConformsToKeyword_5_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_5_1_0());
	    }
		lv_ownedSuperTypes_7_0=ruleTypedRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibClassCSRule());
	        }
       		add(
       			$current,
       			"ownedSuperTypes",
        		lv_ownedSuperTypes_7_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_8=','
    {
    	newLeafNode(otherlv_8, grammarAccess.getLibClassCSAccess().getCommaKeyword_5_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_5_2_1_0());
	    }
		lv_ownedSuperTypes_9_0=ruleTypedRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibClassCSRule());
	        }
       		add(
       			$current,
       			"ownedSuperTypes",
        		lv_ownedSuperTypes_9_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?(	otherlv_10='=>'
    {
    	newLeafNode(otherlv_10, grammarAccess.getLibClassCSAccess().getEqualsSignGreaterThanSignKeyword_6_0());
    }
(
(
		{
		  /* */
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getLibClassCSRule());
	        }
        }
	otherlv_11=RULE_SINGLE_QUOTED_STRING
	{
		newLeafNode(otherlv_11, grammarAccess.getLibClassCSAccess().getImplementationJavaClassCSCrossReference_6_1_0());
	}

)
))?	otherlv_12='{'
    {
    	newLeafNode(otherlv_12, grammarAccess.getLibClassCSAccess().getLeftCurlyBracketKeyword_7());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getLibClassCSAccess().getOwnedOperationsOperationCSParserRuleCall_8_0_0());
	    }
		lv_ownedOperations_13_0=ruleOperationCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibClassCSRule());
	        }
       		add(
       			$current,
       			"ownedOperations",
        		lv_ownedOperations_13_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.OperationCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getLibClassCSAccess().getOwnedPropertiesLibPropertyCSParserRuleCall_8_1_0());
	    }
		lv_ownedProperties_14_0=ruleLibPropertyCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibClassCSRule());
	        }
       		add(
       			$current,
       			"ownedProperties",
        		lv_ownedProperties_14_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibPropertyCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getLibClassCSAccess().getOwnedConstraintsInvCSParserRuleCall_8_2_0());
	    }
		lv_ownedConstraints_15_0=ruleInvCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibClassCSRule());
	        }
       		add(
       			$current,
       			"ownedConstraints",
        		lv_ownedConstraints_15_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.InvCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getLibClassCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_8_3_0());
	    }
		lv_ownedAnnotations_16_0=ruleAnnotationElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibClassCSRule());
	        }
       		add(
       			$current,
       			"ownedAnnotations",
        		lv_ownedAnnotations_16_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AnnotationElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_17='}'
    {
    	newLeafNode(otherlv_17, grammarAccess.getLibClassCSAccess().getRightCurlyBracketKeyword_9());
    }
)
;





// Entry rule entryRuleClassCS
entryRuleClassCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getClassCSRule()); }
	 iv_ruleClassCS=ruleClassCS
	 { $current=$iv_ruleClassCS.current; }
	 EOF
;

// Rule ClassCS
ruleClassCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:

	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getClassCSAccess().getLibClassCSParserRuleCall());
    }
    this_LibClassCS_0=ruleLibClassCS
    {
        $current = $this_LibClassCS_0.current;
        afterParserOrEnumRuleCall();
    }

;





// Entry rule entryRuleDetailCS
entryRuleDetailCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getDetailCSRule()); }
	 iv_ruleDetailCS=ruleDetailCS
	 { $current=$iv_ruleDetailCS.current; }
	 EOF
;

// Rule DetailCS
ruleDetailCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
(
		{
	        newCompositeNode(grammarAccess.getDetailCSAccess().getNameNameParserRuleCall_0_0_0());
	    }
		lv_name_0_1=ruleName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDetailCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_0_1,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Name");
	        afterParserOrEnumRuleCall();
	    }

    |		lv_name_0_2=RULE_SINGLE_QUOTED_STRING
		{
			newLeafNode(lv_name_0_2, grammarAccess.getDetailCSAccess().getNameSINGLE_QUOTED_STRINGTerminalRuleCall_0_0_1());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDetailCSRule());
	        }
       		setWithLastConsumed(
       			$current,
       			"name",
        		lv_name_0_2,
        		"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");
	    }

)

)
)	otherlv_1='='
    {
    	newLeafNode(otherlv_1, grammarAccess.getDetailCSAccess().getEqualsSignKeyword_1());
    }
(
(
(
		lv_values_2_1=RULE_SINGLE_QUOTED_STRING
		{
			newLeafNode(lv_values_2_1, grammarAccess.getDetailCSAccess().getValuesSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDetailCSRule());
	        }
       		addWithLastConsumed(
       			$current,
       			"values",
        		lv_values_2_1,
        		"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");
	    }

    |		lv_values_2_2=RULE_ML_SINGLE_QUOTED_STRING
		{
			newLeafNode(lv_values_2_2, grammarAccess.getDetailCSAccess().getValuesML_SINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDetailCSRule());
	        }
       		addWithLastConsumed(
       			$current,
       			"values",
        		lv_values_2_2,
        		"org.eclipse.ocl.xtext.base.Base.ML_SINGLE_QUOTED_STRING");
	    }

)

)
)*)
;





// Entry rule entryRuleDocumentationCS
entryRuleDocumentationCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getDocumentationCSRule()); }
	 iv_ruleDocumentationCS=ruleDocumentationCS
	 { $current=$iv_ruleDocumentationCS.current; }
	 EOF
;

// Rule DocumentationCS
ruleDocumentationCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getDocumentationCSAccess().getDocumentationCSAction_0(),
            $current);
    }
)	otherlv_1='documentation'
    {
    	newLeafNode(otherlv_1, grammarAccess.getDocumentationCSAccess().getDocumentationKeyword_1());
    }
(
(
		lv_value_2_0=RULE_SINGLE_QUOTED_STRING
		{
			newLeafNode(lv_value_2_0, grammarAccess.getDocumentationCSAccess().getValueSINGLE_QUOTED_STRINGTerminalRuleCall_2_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocumentationCSRule());
	        }
       		setWithLastConsumed(
       			$current,
       			"value",
        		lv_value_2_0,
        		"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");
	    }

)
)?(	otherlv_3='('
    {
    	newLeafNode(otherlv_3, grammarAccess.getDocumentationCSAccess().getLeftParenthesisKeyword_3_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getDocumentationCSAccess().getOwnedDetailsDetailCSParserRuleCall_3_1_0());
	    }
		lv_ownedDetails_4_0=ruleDetailCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocumentationCSRule());
	        }
       		add(
       			$current,
       			"ownedDetails",
        		lv_ownedDetails_4_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.DetailCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=','
    {
    	newLeafNode(otherlv_5, grammarAccess.getDocumentationCSAccess().getCommaKeyword_3_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getDocumentationCSAccess().getOwnedDetailsDetailCSParserRuleCall_3_2_1_0());
	    }
		lv_ownedDetails_6_0=ruleDetailCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocumentationCSRule());
	        }
       		add(
       			$current,
       			"ownedDetails",
        		lv_ownedDetails_6_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.DetailCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_7=')'
    {
    	newLeafNode(otherlv_7, grammarAccess.getDocumentationCSAccess().getRightParenthesisKeyword_3_3());
    }
)?	otherlv_8=';'
    {
    	newLeafNode(otherlv_8, grammarAccess.getDocumentationCSAccess().getSemicolonKeyword_4());
    }
)
;





// Entry rule entryRuleImportCS
entryRuleImportCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getImportCSRule()); }
	 iv_ruleImportCS=ruleImportCS
	 { $current=$iv_ruleImportCS.current; }
	 EOF
;

// Rule ImportCS
ruleImportCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='import'
    {
    	newLeafNode(otherlv_0, grammarAccess.getImportCSAccess().getImportKeyword_0());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getImportCSAccess().getNameIdentifierParserRuleCall_1_0_0());
	    }
		lv_name_1_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getImportCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_1_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2=':'
    {
    	newLeafNode(otherlv_2, grammarAccess.getImportCSAccess().getColonKeyword_1_1());
    }
)?(
(
		{
	        newCompositeNode(grammarAccess.getImportCSAccess().getOwnedPathNameURIPathNameCSParserRuleCall_2_0());
	    }
		lv_ownedPathName_3_0=ruleURIPathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getImportCSRule());
	        }
       		set(
       			$current,
       			"ownedPathName",
        		lv_ownedPathName_3_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.URIPathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_isAll_4_0=	'::*'
    {
        newLeafNode(lv_isAll_4_0, grammarAccess.getImportCSAccess().getIsAllColonColonAsteriskKeyword_3_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getImportCSRule());
	        }
       		setWithLastConsumed($current, "isAll", true, "::*");
	    }

)
)?)
;





// Entry rule entryRuleInvCS
entryRuleInvCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getInvCSRule()); }
	 iv_ruleInvCS=ruleInvCS
	 { $current=$iv_ruleInvCS.current; }
	 EOF
;

// Rule InvCS
ruleInvCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		lv_stereotype_0_0=	'inv'
    {
        newLeafNode(lv_stereotype_0_0, grammarAccess.getInvCSAccess().getStereotypeInvKeyword_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getInvCSRule());
	        }
       		setWithLastConsumed($current, "stereotype", lv_stereotype_0_0, "inv");
	    }

)
)((
(
		{
	        newCompositeNode(grammarAccess.getInvCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0());
	    }
		lv_name_1_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInvCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2='('
    {
    	newLeafNode(otherlv_2, grammarAccess.getInvCSAccess().getLeftParenthesisKeyword_1_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getInvCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0());
	    }
		lv_ownedMessageSpecification_3_0=ruleSpecificationCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInvCSRule());
	        }
       		set(
       			$current,
       			"ownedMessageSpecification",
        		lv_ownedMessageSpecification_3_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.SpecificationCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4=')'
    {
    	newLeafNode(otherlv_4, grammarAccess.getInvCSAccess().getRightParenthesisKeyword_1_1_2());
    }
)?)?	otherlv_5=':'
    {
    	newLeafNode(otherlv_5, grammarAccess.getInvCSAccess().getColonKeyword_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getInvCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0());
	    }
		lv_ownedSpecification_6_0=ruleSpecificationCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInvCSRule());
	        }
       		set(
       			$current,
       			"ownedSpecification",
        		lv_ownedSpecification_6_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.SpecificationCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7=';'
    {
    	newLeafNode(otherlv_7, grammarAccess.getInvCSAccess().getSemicolonKeyword_4());
    }
)
;





// Entry rule entryRuleLibCoercionCS
entryRuleLibCoercionCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLibCoercionCSRule()); }
	 iv_ruleLibCoercionCS=ruleLibCoercionCS
	 { $current=$iv_ruleLibCoercionCS.current; }
	 EOF
;

// Rule LibCoercionCS
ruleLibCoercionCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='coercion'
    {
    	newLeafNode(otherlv_0, grammarAccess.getLibCoercionCSAccess().getCoercionKeyword_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibCoercionCSAccess().getNameNameParserRuleCall_1_0());
	    }
		lv_name_1_0=ruleName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibCoercionCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_1_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Name");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='('
    {
    	newLeafNode(otherlv_2, grammarAccess.getLibCoercionCSAccess().getLeftParenthesisKeyword_2());
    }
	otherlv_3=')'
    {
    	newLeafNode(otherlv_3, grammarAccess.getLibCoercionCSAccess().getRightParenthesisKeyword_3());
    }
	otherlv_4=':'
    {
    	newLeafNode(otherlv_4, grammarAccess.getLibCoercionCSAccess().getColonKeyword_4());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibCoercionCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_5_0());
	    }
		lv_ownedType_5_0=ruleTypedMultiplicityRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibCoercionCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_5_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedMultiplicityRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_6='=>'
    {
    	newLeafNode(otherlv_6, grammarAccess.getLibCoercionCSAccess().getEqualsSignGreaterThanSignKeyword_6_0());
    }
(
(
		{
		  /* */
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getLibCoercionCSRule());
	        }
        }
	otherlv_7=RULE_SINGLE_QUOTED_STRING
	{
		newLeafNode(otherlv_7, grammarAccess.getLibCoercionCSAccess().getImplementationJavaClassCSCrossReference_6_1_0());
	}

)
))?((	otherlv_8='{'
    {
    	newLeafNode(otherlv_8, grammarAccess.getLibCoercionCSAccess().getLeftCurlyBracketKeyword_7_0_0());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getLibCoercionCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0());
	    }
		lv_ownedAnnotations_9_0=ruleAnnotationElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibCoercionCSRule());
	        }
       		add(
       			$current,
       			"ownedAnnotations",
        		lv_ownedAnnotations_9_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AnnotationElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getLibCoercionCSAccess().getOwnedPreconditionsPostCSParserRuleCall_7_0_1_1_0());
	    }
		lv_ownedPreconditions_10_0=rulePostCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibCoercionCSRule());
	        }
       		add(
       			$current,
       			"ownedPreconditions",
        		lv_ownedPreconditions_10_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.PostCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getLibCoercionCSAccess().getOwnedPostconditionsPreCSParserRuleCall_7_0_1_2_0());
	    }
		lv_ownedPostconditions_11_0=rulePreCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibCoercionCSRule());
	        }
       		add(
       			$current,
       			"ownedPostconditions",
        		lv_ownedPostconditions_11_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.PreCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_12='}'
    {
    	newLeafNode(otherlv_12, grammarAccess.getLibCoercionCSAccess().getRightCurlyBracketKeyword_7_0_2());
    }
)
    |	otherlv_13=';'
    {
    	newLeafNode(otherlv_13, grammarAccess.getLibCoercionCSAccess().getSemicolonKeyword_7_1());
    }
))
;





// Entry rule entryRuleLibIterationCS
entryRuleLibIterationCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLibIterationCSRule()); }
	 iv_ruleLibIterationCS=ruleLibIterationCS
	 { $current=$iv_ruleLibIterationCS.current; }
	 EOF
;

// Rule LibIterationCS
ruleLibIterationCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='iteration'
    {
    	newLeafNode(otherlv_0, grammarAccess.getLibIterationCSAccess().getIterationKeyword_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibIterationCSAccess().getNameNameParserRuleCall_1_0());
	    }
		lv_name_1_0=ruleName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibIterationCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_1_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Name");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getLibIterationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0());
	    }
		lv_ownedSignature_2_0=ruleTemplateSignatureCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibIterationCSRule());
	        }
       		set(
       			$current,
       			"ownedSignature",
        		lv_ownedSignature_2_0,
        		"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_3='('
    {
    	newLeafNode(otherlv_3, grammarAccess.getLibIterationCSAccess().getLeftParenthesisKeyword_3());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibIterationCSAccess().getOwnedIteratorsIteratorCSParserRuleCall_4_0());
	    }
		lv_ownedIterators_4_0=ruleIteratorCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibIterationCSRule());
	        }
       		add(
       			$current,
       			"ownedIterators",
        		lv_ownedIterators_4_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.IteratorCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=','
    {
    	newLeafNode(otherlv_5, grammarAccess.getLibIterationCSAccess().getCommaKeyword_5_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibIterationCSAccess().getOwnedIteratorsIteratorCSParserRuleCall_5_1_0());
	    }
		lv_ownedIterators_6_0=ruleIteratorCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibIterationCSRule());
	        }
       		add(
       			$current,
       			"ownedIterators",
        		lv_ownedIterators_6_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.IteratorCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*(	otherlv_7=';'
    {
    	newLeafNode(otherlv_7, grammarAccess.getLibIterationCSAccess().getSemicolonKeyword_6_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibIterationCSAccess().getOwnedAccumulatorsAccumulatorCSParserRuleCall_6_1_0());
	    }
		lv_ownedAccumulators_8_0=ruleAccumulatorCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibIterationCSRule());
	        }
       		add(
       			$current,
       			"ownedAccumulators",
        		lv_ownedAccumulators_8_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AccumulatorCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_9=','
    {
    	newLeafNode(otherlv_9, grammarAccess.getLibIterationCSAccess().getCommaKeyword_6_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibIterationCSAccess().getOwnedAccumulatorsAccumulatorCSParserRuleCall_6_2_1_0());
	    }
		lv_ownedAccumulators_10_0=ruleAccumulatorCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibIterationCSRule());
	        }
       		add(
       			$current,
       			"ownedAccumulators",
        		lv_ownedAccumulators_10_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AccumulatorCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?(	otherlv_11='|'
    {
    	newLeafNode(otherlv_11, grammarAccess.getLibIterationCSAccess().getVerticalLineKeyword_7_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibIterationCSAccess().getOwnedParametersParameterCSParserRuleCall_7_1_0());
	    }
		lv_ownedParameters_12_0=ruleParameterCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibIterationCSRule());
	        }
       		add(
       			$current,
       			"ownedParameters",
        		lv_ownedParameters_12_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.ParameterCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_13=','
    {
    	newLeafNode(otherlv_13, grammarAccess.getLibIterationCSAccess().getCommaKeyword_7_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibIterationCSAccess().getOwnedParametersParameterCSParserRuleCall_7_2_1_0());
	    }
		lv_ownedParameters_14_0=ruleParameterCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibIterationCSRule());
	        }
       		add(
       			$current,
       			"ownedParameters",
        		lv_ownedParameters_14_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.ParameterCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_15=')'
    {
    	newLeafNode(otherlv_15, grammarAccess.getLibIterationCSAccess().getRightParenthesisKeyword_8());
    }
	otherlv_16=':'
    {
    	newLeafNode(otherlv_16, grammarAccess.getLibIterationCSAccess().getColonKeyword_9());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibIterationCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_10_0());
	    }
		lv_ownedType_17_0=ruleTypedMultiplicityRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibIterationCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_17_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedMultiplicityRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_isInvalidating_18_0=	'invalidating'
    {
        newLeafNode(lv_isInvalidating_18_0, grammarAccess.getLibIterationCSAccess().getIsInvalidatingInvalidatingKeyword_11_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getLibIterationCSRule());
	        }
       		setWithLastConsumed($current, "isInvalidating", true, "invalidating");
	    }

)
)?(
(
		lv_isValidating_19_0=	'validating'
    {
        newLeafNode(lv_isValidating_19_0, grammarAccess.getLibIterationCSAccess().getIsValidatingValidatingKeyword_12_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getLibIterationCSRule());
	        }
       		setWithLastConsumed($current, "isValidating", true, "validating");
	    }

)
)?(	otherlv_20='=>'
    {
    	newLeafNode(otherlv_20, grammarAccess.getLibIterationCSAccess().getEqualsSignGreaterThanSignKeyword_13_0());
    }
(
(
		{
		  /* */
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getLibIterationCSRule());
	        }
        }
	otherlv_21=RULE_SINGLE_QUOTED_STRING
	{
		newLeafNode(otherlv_21, grammarAccess.getLibIterationCSAccess().getImplementationJavaClassCSCrossReference_13_1_0());
	}

)
))?((	otherlv_22='{'
    {
    	newLeafNode(otherlv_22, grammarAccess.getLibIterationCSAccess().getLeftCurlyBracketKeyword_14_0_0());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getLibIterationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_14_0_1_0_0());
	    }
		lv_ownedAnnotations_23_0=ruleAnnotationElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibIterationCSRule());
	        }
       		add(
       			$current,
       			"ownedAnnotations",
        		lv_ownedAnnotations_23_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AnnotationElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getLibIterationCSAccess().getOwnedPreconditionsPostCSParserRuleCall_14_0_1_1_0());
	    }
		lv_ownedPreconditions_24_0=rulePostCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibIterationCSRule());
	        }
       		add(
       			$current,
       			"ownedPreconditions",
        		lv_ownedPreconditions_24_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.PostCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getLibIterationCSAccess().getOwnedPostconditionsPreCSParserRuleCall_14_0_1_2_0());
	    }
		lv_ownedPostconditions_25_0=rulePreCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibIterationCSRule());
	        }
       		add(
       			$current,
       			"ownedPostconditions",
        		lv_ownedPostconditions_25_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.PreCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_26='}'
    {
    	newLeafNode(otherlv_26, grammarAccess.getLibIterationCSAccess().getRightCurlyBracketKeyword_14_0_2());
    }
)
    |	otherlv_27=';'
    {
    	newLeafNode(otherlv_27, grammarAccess.getLibIterationCSAccess().getSemicolonKeyword_14_1());
    }
))
;





// Entry rule entryRuleIteratorCS
entryRuleIteratorCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getIteratorCSRule()); }
	 iv_ruleIteratorCS=ruleIteratorCS
	 { $current=$iv_ruleIteratorCS.current; }
	 EOF
;

// Rule IteratorCS
ruleIteratorCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getIteratorCSAccess().getNameIdentifierParserRuleCall_0_0());
	    }
		lv_name_0_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIteratorCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_0_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1=':'
    {
    	newLeafNode(otherlv_1, grammarAccess.getIteratorCSAccess().getColonKeyword_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getIteratorCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0());
	    }
		lv_ownedType_2_0=ruleTypedMultiplicityRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIteratorCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_2_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedMultiplicityRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleLambdaTypeCS
entryRuleLambdaTypeCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLambdaTypeCSRule()); }
	 iv_ruleLambdaTypeCS=ruleLambdaTypeCS
	 { $current=$iv_ruleLambdaTypeCS.current; }
	 EOF
;

// Rule LambdaTypeCS
ruleLambdaTypeCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=	'Lambda'
    {
        newLeafNode(lv_name_0_0, grammarAccess.getLambdaTypeCSAccess().getNameLambdaKeyword_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getLambdaTypeCSRule());
	        }
       		setWithLastConsumed($current, "name", lv_name_0_0, "Lambda");
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getLambdaTypeCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_1_0());
	    }
		lv_ownedSignature_1_0=ruleTemplateSignatureCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLambdaTypeCSRule());
	        }
       		set(
       			$current,
       			"ownedSignature",
        		lv_ownedSignature_1_0,
        		"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{
	        newCompositeNode(grammarAccess.getLambdaTypeCSAccess().getOwnedContextTypeLambdaContextTypeRefCSParserRuleCall_2_0());
	    }
		lv_ownedContextType_2_0=ruleLambdaContextTypeRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLambdaTypeCSRule());
	        }
       		set(
       			$current,
       			"ownedContextType",
        		lv_ownedContextType_2_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LambdaContextTypeRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='('
    {
    	newLeafNode(otherlv_3, grammarAccess.getLambdaTypeCSAccess().getLeftParenthesisKeyword_3());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getLambdaTypeCSAccess().getOwnedParameterTypesTypedMultiplicityRefCSParserRuleCall_4_0_0());
	    }
		lv_ownedParameterTypes_4_0=ruleTypedMultiplicityRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLambdaTypeCSRule());
	        }
       		add(
       			$current,
       			"ownedParameterTypes",
        		lv_ownedParameterTypes_4_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedMultiplicityRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=','
    {
    	newLeafNode(otherlv_5, grammarAccess.getLambdaTypeCSAccess().getCommaKeyword_4_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLambdaTypeCSAccess().getOwnedParameterTypesTypedMultiplicityRefCSParserRuleCall_4_1_1_0());
	    }
		lv_ownedParameterTypes_6_0=ruleTypedMultiplicityRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLambdaTypeCSRule());
	        }
       		add(
       			$current,
       			"ownedParameterTypes",
        		lv_ownedParameterTypes_6_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedMultiplicityRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_7=')'
    {
    	newLeafNode(otherlv_7, grammarAccess.getLambdaTypeCSAccess().getRightParenthesisKeyword_5());
    }
	otherlv_8=':'
    {
    	newLeafNode(otherlv_8, grammarAccess.getLambdaTypeCSAccess().getColonKeyword_6());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLambdaTypeCSAccess().getOwnedResultTypeTypedRefCSParserRuleCall_7_0());
	    }
		lv_ownedResultType_9_0=ruleTypedRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLambdaTypeCSRule());
	        }
       		set(
       			$current,
       			"ownedResultType",
        		lv_ownedResultType_9_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleLambdaContextTypeRefCS
entryRuleLambdaContextTypeRefCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLambdaContextTypeRefCSRule()); }
	 iv_ruleLambdaContextTypeRefCS=ruleLambdaContextTypeRefCS
	 { $current=$iv_ruleLambdaContextTypeRefCS.current; }
	 EOF
;

// Rule LambdaContextTypeRefCS
ruleLambdaContextTypeRefCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
(
		{
	        newCompositeNode(grammarAccess.getLambdaContextTypeRefCSAccess().getOwnedPathNameLibPathNameCSParserRuleCall_0());
	    }
		lv_ownedPathName_0_0=ruleLibPathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLambdaContextTypeRefCSRule());
	        }
       		set(
       			$current,
       			"ownedPathName",
        		lv_ownedPathName_0_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibPathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleOperationCS
entryRuleOperationCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getOperationCSRule()); }
	 iv_ruleOperationCS=ruleOperationCS
	 { $current=$iv_ruleOperationCS.current; }
	 EOF
;

// Rule OperationCS
ruleOperationCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getOperationCSAccess().getLibCoercionCSParserRuleCall_0());
    }
    this_LibCoercionCS_0=ruleLibCoercionCS
    {
        $current = $this_LibCoercionCS_0.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getOperationCSAccess().getLibIterationCSParserRuleCall_1());
    }
    this_LibIterationCS_1=ruleLibIterationCS
    {
        $current = $this_LibIterationCS_1.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getOperationCSAccess().getLibOperationCSParserRuleCall_2());
    }
    this_LibOperationCS_2=ruleLibOperationCS
    {
        $current = $this_LibOperationCS_2.current;
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleLibOperationCS
entryRuleLibOperationCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLibOperationCSRule()); }
	 iv_ruleLibOperationCS=ruleLibOperationCS
	 { $current=$iv_ruleLibOperationCS.current; }
	 EOF
;

// Rule LibOperationCS
ruleLibOperationCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		lv_isStatic_0_0=	'static'
    {
        newLeafNode(lv_isStatic_0_0, grammarAccess.getLibOperationCSAccess().getIsStaticStaticKeyword_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getLibOperationCSRule());
	        }
       		setWithLastConsumed($current, "isStatic", true, "static");
	    }

)
)?	otherlv_1='operation'
    {
    	newLeafNode(otherlv_1, grammarAccess.getLibOperationCSAccess().getOperationKeyword_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibOperationCSAccess().getNameNameParserRuleCall_2_0());
	    }
		lv_name_2_0=ruleName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibOperationCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_2_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Name");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getLibOperationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0());
	    }
		lv_ownedSignature_3_0=ruleTemplateSignatureCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibOperationCSRule());
	        }
       		set(
       			$current,
       			"ownedSignature",
        		lv_ownedSignature_3_0,
        		"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_4='('
    {
    	newLeafNode(otherlv_4, grammarAccess.getLibOperationCSAccess().getLeftParenthesisKeyword_4());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getLibOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_0_0());
	    }
		lv_ownedParameters_5_0=ruleParameterCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibOperationCSRule());
	        }
       		add(
       			$current,
       			"ownedParameters",
        		lv_ownedParameters_5_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.ParameterCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_6=','
    {
    	newLeafNode(otherlv_6, grammarAccess.getLibOperationCSAccess().getCommaKeyword_5_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_1_1_0());
	    }
		lv_ownedParameters_7_0=ruleParameterCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibOperationCSRule());
	        }
       		add(
       			$current,
       			"ownedParameters",
        		lv_ownedParameters_7_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.ParameterCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_8=')'
    {
    	newLeafNode(otherlv_8, grammarAccess.getLibOperationCSAccess().getRightParenthesisKeyword_6());
    }
	otherlv_9=':'
    {
    	newLeafNode(otherlv_9, grammarAccess.getLibOperationCSAccess().getColonKeyword_7());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibOperationCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_8_0());
	    }
		lv_ownedType_10_0=ruleTypedMultiplicityRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibOperationCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_10_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedMultiplicityRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_isValidating_11_0=	'validating'
    {
        newLeafNode(lv_isValidating_11_0, grammarAccess.getLibOperationCSAccess().getIsValidatingValidatingKeyword_9_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getLibOperationCSRule());
	        }
       		setWithLastConsumed($current, "isValidating", true, "validating");
	    }

)
)?(
(
		lv_isInvalidating_12_0=	'invalidating'
    {
        newLeafNode(lv_isInvalidating_12_0, grammarAccess.getLibOperationCSAccess().getIsInvalidatingInvalidatingKeyword_10_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getLibOperationCSRule());
	        }
       		setWithLastConsumed($current, "isInvalidating", true, "invalidating");
	    }

)
)?(	otherlv_13='precedence'
    {
    	newLeafNode(otherlv_13, grammarAccess.getLibOperationCSAccess().getPrecedenceKeyword_11_0());
    }
	otherlv_14='='
    {
    	newLeafNode(otherlv_14, grammarAccess.getLibOperationCSAccess().getEqualsSignKeyword_11_1());
    }
(
(
		{
		  /* */
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getLibOperationCSRule());
	        }
        }
		{
	        newCompositeNode(grammarAccess.getLibOperationCSAccess().getPrecedencePrecedenceCrossReference_11_2_0());
	    }
		ruleName		{
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_16='=>'
    {
    	newLeafNode(otherlv_16, grammarAccess.getLibOperationCSAccess().getEqualsSignGreaterThanSignKeyword_12_0());
    }
(
(
		{
		  /* */
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getLibOperationCSRule());
	        }
        }
	otherlv_17=RULE_SINGLE_QUOTED_STRING
	{
		newLeafNode(otherlv_17, grammarAccess.getLibOperationCSAccess().getImplementationJavaClassCSCrossReference_12_1_0());
	}

)
))?((	otherlv_18='{'
    {
    	newLeafNode(otherlv_18, grammarAccess.getLibOperationCSAccess().getLeftCurlyBracketKeyword_13_0_0());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getLibOperationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_13_0_1_0_0());
	    }
		lv_ownedAnnotations_19_0=ruleAnnotationElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibOperationCSRule());
	        }
       		add(
       			$current,
       			"ownedAnnotations",
        		lv_ownedAnnotations_19_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AnnotationElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(	otherlv_20='body'
    {
    	newLeafNode(otherlv_20, grammarAccess.getLibOperationCSAccess().getBodyKeyword_13_0_1_1_0());
    }
(
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getLibOperationCSAccess().getUnrestrictedNameParserRuleCall_13_0_1_1_1());
    }
ruleUnrestrictedName
    {
        afterParserOrEnumRuleCall();
    }
)?	otherlv_22=':'
    {
    	newLeafNode(otherlv_22, grammarAccess.getLibOperationCSAccess().getColonKeyword_13_0_1_1_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibOperationCSAccess().getOwnedBodyExpressionsSpecificationCSParserRuleCall_13_0_1_1_3_0());
	    }
		lv_ownedBodyExpressions_23_0=ruleSpecificationCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibOperationCSRule());
	        }
       		add(
       			$current,
       			"ownedBodyExpressions",
        		lv_ownedBodyExpressions_23_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.SpecificationCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_24=';'
    {
    	newLeafNode(otherlv_24, grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_13_0_1_1_4());
    }
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getLibOperationCSAccess().getOwnedPostconditionsPostCSParserRuleCall_13_0_1_2_0());
	    }
		lv_ownedPostconditions_25_0=rulePostCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibOperationCSRule());
	        }
       		add(
       			$current,
       			"ownedPostconditions",
        		lv_ownedPostconditions_25_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.PostCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getLibOperationCSAccess().getOwnedPreconditionsPreCSParserRuleCall_13_0_1_3_0());
	    }
		lv_ownedPreconditions_26_0=rulePreCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibOperationCSRule());
	        }
       		add(
       			$current,
       			"ownedPreconditions",
        		lv_ownedPreconditions_26_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.PreCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_27='}'
    {
    	newLeafNode(otherlv_27, grammarAccess.getLibOperationCSAccess().getRightCurlyBracketKeyword_13_0_2());
    }
)
    |	otherlv_28=';'
    {
    	newLeafNode(otherlv_28, grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_13_1());
    }
))
;





// Entry rule entryRuleLibOppositeCS
entryRuleLibOppositeCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLibOppositeCSRule()); }
	 iv_ruleLibOppositeCS=ruleLibOppositeCS
	 { $current=$iv_ruleLibOppositeCS.current; }
	 EOF
;

// Rule LibOppositeCS
ruleLibOppositeCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='opposite'
    {
    	newLeafNode(otherlv_0, grammarAccess.getLibOppositeCSAccess().getOppositeKeyword_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibOppositeCSAccess().getNameNameParserRuleCall_1_0());
	    }
		lv_name_1_0=ruleName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibOppositeCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_1_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Name");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2=':'
    {
    	newLeafNode(otherlv_2, grammarAccess.getLibOppositeCSAccess().getColonKeyword_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibOppositeCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_0());
	    }
		lv_ownedType_3_0=ruleTypedMultiplicityRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibOppositeCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_3_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedMultiplicityRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleLibPackageCS
entryRuleLibPackageCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLibPackageCSRule()); }
	 iv_ruleLibPackageCS=ruleLibPackageCS
	 { $current=$iv_ruleLibPackageCS.current; }
	 EOF
;

// Rule LibPackageCS
ruleLibPackageCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='library'
    {
    	newLeafNode(otherlv_0, grammarAccess.getLibPackageCSAccess().getLibraryKeyword_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibPackageCSAccess().getNameNameParserRuleCall_1_0());
	    }
		lv_name_1_0=ruleName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibPackageCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_1_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Name");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=':'
    {
    	newLeafNode(otherlv_2, grammarAccess.getLibPackageCSAccess().getColonKeyword_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibPackageCSAccess().getNsPrefixIdentifierParserRuleCall_2_1_0());
	    }
		lv_nsPrefix_3_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibPackageCSRule());
	        }
       		set(
       			$current,
       			"nsPrefix",
        		lv_nsPrefix_3_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4='='
    {
    	newLeafNode(otherlv_4, grammarAccess.getLibPackageCSAccess().getEqualsSignKeyword_2_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibPackageCSAccess().getNsURIURIParserRuleCall_2_3_0());
	    }
		lv_nsURI_5_0=ruleURI		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibPackageCSRule());
	        }
       		set(
       			$current,
       			"nsURI",
        		lv_nsURI_5_0,
        		"org.eclipse.ocl.xtext.base.Base.URI");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_6='{'
    {
    	newLeafNode(otherlv_6, grammarAccess.getLibPackageCSAccess().getLeftCurlyBracketKeyword_3());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getLibPackageCSAccess().getOwnedPackagesPackageCSParserRuleCall_4_0_0());
	    }
		lv_ownedPackages_7_0=rulePackageCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibPackageCSRule());
	        }
       		add(
       			$current,
       			"ownedPackages",
        		lv_ownedPackages_7_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.PackageCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(	otherlv_8='precedence'
    {
    	newLeafNode(otherlv_8, grammarAccess.getLibPackageCSAccess().getPrecedenceKeyword_4_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibPackageCSAccess().getOwnedPrecedencesPrecedenceCSParserRuleCall_4_1_1_0());
	    }
		lv_ownedPrecedences_9_0=rulePrecedenceCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibPackageCSRule());
	        }
       		add(
       			$current,
       			"ownedPrecedences",
        		lv_ownedPrecedences_9_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.PrecedenceCS");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_10=';'
    {
    	newLeafNode(otherlv_10, grammarAccess.getLibPackageCSAccess().getSemicolonKeyword_4_1_2());
    }
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getLibPackageCSAccess().getOwnedClassesClassCSParserRuleCall_4_2_0());
	    }
		lv_ownedClasses_11_0=ruleClassCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibPackageCSRule());
	        }
       		add(
       			$current,
       			"ownedClasses",
        		lv_ownedClasses_11_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.ClassCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getLibPackageCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_4_3_0());
	    }
		lv_ownedAnnotations_12_0=ruleAnnotationElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibPackageCSRule());
	        }
       		add(
       			$current,
       			"ownedAnnotations",
        		lv_ownedAnnotations_12_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AnnotationElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_13='}'
    {
    	newLeafNode(otherlv_13, grammarAccess.getLibPackageCSAccess().getRightCurlyBracketKeyword_5());
    }
)
;





// Entry rule entryRulePackageCS
entryRulePackageCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPackageCSRule()); }
	 iv_rulePackageCS=rulePackageCS
	 { $current=$iv_rulePackageCS.current; }
	 EOF
;

// Rule PackageCS
rulePackageCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='package'
    {
    	newLeafNode(otherlv_0, grammarAccess.getPackageCSAccess().getPackageKeyword_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getPackageCSAccess().getNameNameParserRuleCall_1_0());
	    }
		lv_name_1_0=ruleName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPackageCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_1_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Name");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=':'
    {
    	newLeafNode(otherlv_2, grammarAccess.getPackageCSAccess().getColonKeyword_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getPackageCSAccess().getNsPrefixIdentifierParserRuleCall_2_1_0());
	    }
		lv_nsPrefix_3_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPackageCSRule());
	        }
       		set(
       			$current,
       			"nsPrefix",
        		lv_nsPrefix_3_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4='='
    {
    	newLeafNode(otherlv_4, grammarAccess.getPackageCSAccess().getEqualsSignKeyword_2_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getPackageCSAccess().getNsURIURIParserRuleCall_2_3_0());
	    }
		lv_nsURI_5_0=ruleURI		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPackageCSRule());
	        }
       		set(
       			$current,
       			"nsURI",
        		lv_nsURI_5_0,
        		"org.eclipse.ocl.xtext.base.Base.URI");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_6='{'
    {
    	newLeafNode(otherlv_6, grammarAccess.getPackageCSAccess().getLeftCurlyBracketKeyword_3());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getPackageCSAccess().getOwnedPackagesPackageCSParserRuleCall_4_0_0());
	    }
		lv_ownedPackages_7_0=rulePackageCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPackageCSRule());
	        }
       		add(
       			$current,
       			"ownedPackages",
        		lv_ownedPackages_7_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.PackageCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getPackageCSAccess().getOwnedClassesClassCSParserRuleCall_4_1_0());
	    }
		lv_ownedClasses_8_0=ruleClassCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPackageCSRule());
	        }
       		add(
       			$current,
       			"ownedClasses",
        		lv_ownedClasses_8_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.ClassCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getPackageCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_4_2_0());
	    }
		lv_ownedAnnotations_9_0=ruleAnnotationElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPackageCSRule());
	        }
       		add(
       			$current,
       			"ownedAnnotations",
        		lv_ownedAnnotations_9_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AnnotationElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_10='}'
    {
    	newLeafNode(otherlv_10, grammarAccess.getPackageCSAccess().getRightCurlyBracketKeyword_5());
    }
)
;





// Entry rule entryRuleParameterCS
entryRuleParameterCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getParameterCSRule()); }
	 iv_ruleParameterCS=ruleParameterCS
	 { $current=$iv_ruleParameterCS.current; }
	 EOF
;

// Rule ParameterCS
ruleParameterCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getParameterCSAccess().getNameIdentifierParserRuleCall_0_0());
	    }
		lv_name_0_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getParameterCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_0_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1=':'
    {
    	newLeafNode(otherlv_1, grammarAccess.getParameterCSAccess().getColonKeyword_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getParameterCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0());
	    }
		lv_ownedType_2_0=ruleTypedMultiplicityRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getParameterCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_2_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedMultiplicityRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleLibPropertyCS
entryRuleLibPropertyCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getLibPropertyCSRule()); }
	 iv_ruleLibPropertyCS=ruleLibPropertyCS
	 { $current=$iv_ruleLibPropertyCS.current; }
	 EOF
;

// Rule LibPropertyCS
ruleLibPropertyCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		lv_isStatic_0_0=	'static'
    {
        newLeafNode(lv_isStatic_0_0, grammarAccess.getLibPropertyCSAccess().getIsStaticStaticKeyword_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getLibPropertyCSRule());
	        }
       		setWithLastConsumed($current, "isStatic", true, "static");
	    }

)
)?	otherlv_1='property'
    {
    	newLeafNode(otherlv_1, grammarAccess.getLibPropertyCSAccess().getPropertyKeyword_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibPropertyCSAccess().getNameNameParserRuleCall_2_0());
	    }
		lv_name_2_0=ruleName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibPropertyCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_2_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Name");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=':'
    {
    	newLeafNode(otherlv_3, grammarAccess.getLibPropertyCSAccess().getColonKeyword_3());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibPropertyCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_0());
	    }
		lv_ownedType_4_0=ruleTypedMultiplicityRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibPropertyCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_4_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedMultiplicityRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getLibPropertyCSAccess().getOwnedOppositeLibOppositeCSParserRuleCall_5_0());
	    }
		lv_ownedOpposite_5_0=ruleLibOppositeCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibPropertyCSRule());
	        }
       		set(
       			$current,
       			"ownedOpposite",
        		lv_ownedOpposite_5_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibOppositeCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?(	otherlv_6='=>'
    {
    	newLeafNode(otherlv_6, grammarAccess.getLibPropertyCSAccess().getEqualsSignGreaterThanSignKeyword_6_0());
    }
(
(
		{
		  /* */
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getLibPropertyCSRule());
	        }
        }
	otherlv_7=RULE_SINGLE_QUOTED_STRING
	{
		newLeafNode(otherlv_7, grammarAccess.getLibPropertyCSAccess().getImplementationJavaClassCSCrossReference_6_1_0());
	}

)
))?((	otherlv_8='{'
    {
    	newLeafNode(otherlv_8, grammarAccess.getLibPropertyCSAccess().getLeftCurlyBracketKeyword_7_0_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getLibPropertyCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0());
	    }
		lv_ownedAnnotations_9_0=ruleAnnotationElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLibPropertyCSRule());
	        }
       		add(
       			$current,
       			"ownedAnnotations",
        		lv_ownedAnnotations_9_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.AnnotationElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_10='}'
    {
    	newLeafNode(otherlv_10, grammarAccess.getLibPropertyCSAccess().getRightCurlyBracketKeyword_7_0_2());
    }
)
    |	otherlv_11=';'
    {
    	newLeafNode(otherlv_11, grammarAccess.getLibPropertyCSAccess().getSemicolonKeyword_7_1());
    }
))
;





// Entry rule entryRulePostCS
entryRulePostCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPostCSRule()); }
	 iv_rulePostCS=rulePostCS
	 { $current=$iv_rulePostCS.current; }
	 EOF
;

// Rule PostCS
rulePostCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		lv_stereotype_0_0=	'post'
    {
        newLeafNode(lv_stereotype_0_0, grammarAccess.getPostCSAccess().getStereotypePostKeyword_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPostCSRule());
	        }
       		setWithLastConsumed($current, "stereotype", lv_stereotype_0_0, "post");
	    }

)
)((
(
		{
	        newCompositeNode(grammarAccess.getPostCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0());
	    }
		lv_name_1_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPostCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2='('
    {
    	newLeafNode(otherlv_2, grammarAccess.getPostCSAccess().getLeftParenthesisKeyword_1_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getPostCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0());
	    }
		lv_ownedMessageSpecification_3_0=ruleSpecificationCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPostCSRule());
	        }
       		set(
       			$current,
       			"ownedMessageSpecification",
        		lv_ownedMessageSpecification_3_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.SpecificationCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4=')'
    {
    	newLeafNode(otherlv_4, grammarAccess.getPostCSAccess().getRightParenthesisKeyword_1_1_2());
    }
)?)?	otherlv_5=':'
    {
    	newLeafNode(otherlv_5, grammarAccess.getPostCSAccess().getColonKeyword_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getPostCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0());
	    }
		lv_ownedSpecification_6_0=ruleSpecificationCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPostCSRule());
	        }
       		set(
       			$current,
       			"ownedSpecification",
        		lv_ownedSpecification_6_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.SpecificationCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7=';'
    {
    	newLeafNode(otherlv_7, grammarAccess.getPostCSAccess().getSemicolonKeyword_4());
    }
)
;





// Entry rule entryRulePreCS
entryRulePreCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPreCSRule()); }
	 iv_rulePreCS=rulePreCS
	 { $current=$iv_rulePreCS.current; }
	 EOF
;

// Rule PreCS
rulePreCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		lv_stereotype_0_0=	'pre'
    {
        newLeafNode(lv_stereotype_0_0, grammarAccess.getPreCSAccess().getStereotypePreKeyword_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPreCSRule());
	        }
       		setWithLastConsumed($current, "stereotype", lv_stereotype_0_0, "pre");
	    }

)
)((
(
		{
	        newCompositeNode(grammarAccess.getPreCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0());
	    }
		lv_name_1_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPreCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_1_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2='('
    {
    	newLeafNode(otherlv_2, grammarAccess.getPreCSAccess().getLeftParenthesisKeyword_1_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getPreCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0());
	    }
		lv_ownedMessageSpecification_3_0=ruleSpecificationCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPreCSRule());
	        }
       		set(
       			$current,
       			"ownedMessageSpecification",
        		lv_ownedMessageSpecification_3_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.SpecificationCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4=')'
    {
    	newLeafNode(otherlv_4, grammarAccess.getPreCSAccess().getRightParenthesisKeyword_1_1_2());
    }
)?)?	otherlv_5=':'
    {
    	newLeafNode(otherlv_5, grammarAccess.getPreCSAccess().getColonKeyword_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getPreCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0());
	    }
		lv_ownedSpecification_6_0=ruleSpecificationCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPreCSRule());
	        }
       		set(
       			$current,
       			"ownedSpecification",
        		lv_ownedSpecification_6_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.SpecificationCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7=';'
    {
    	newLeafNode(otherlv_7, grammarAccess.getPreCSAccess().getSemicolonKeyword_4());
    }
)
;





// Entry rule entryRulePrecedenceCS
entryRulePrecedenceCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPrecedenceCSRule()); }
	 iv_rulePrecedenceCS=rulePrecedenceCS
	 { $current=$iv_rulePrecedenceCS.current; }
	 EOF
;

// Rule PrecedenceCS
rulePrecedenceCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((	otherlv_0='left'
    {
    	newLeafNode(otherlv_0, grammarAccess.getPrecedenceCSAccess().getLeftKeyword_0_0());
    }

    |(
(
		lv_isRightAssociative_1_0=	'right'
    {
        newLeafNode(lv_isRightAssociative_1_0, grammarAccess.getPrecedenceCSAccess().getIsRightAssociativeRightKeyword_0_1_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPrecedenceCSRule());
	        }
       		setWithLastConsumed($current, "isRightAssociative", true, "right");
	    }

)
))	otherlv_2=':'
    {
    	newLeafNode(otherlv_2, grammarAccess.getPrecedenceCSAccess().getColonKeyword_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getPrecedenceCSAccess().getNameNameParserRuleCall_2_0());
	    }
		lv_name_3_0=ruleName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrecedenceCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_3_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Name");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleSpecificationCS
entryRuleSpecificationCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getSpecificationCSRule()); }
	 iv_ruleSpecificationCS=ruleSpecificationCS
	 { $current=$iv_ruleSpecificationCS.current; }
	 EOF
;

// Rule SpecificationCS
ruleSpecificationCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
(
		{
	        newCompositeNode(grammarAccess.getSpecificationCSAccess().getOwnedExpressionExpCSParserRuleCall_0());
	    }
		lv_ownedExpression_0_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSpecificationCSRule());
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





// Entry rule entryRuleTypedMultiplicityRefCS
entryRuleTypedMultiplicityRefCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTypedMultiplicityRefCSRule()); }
	 iv_ruleTypedMultiplicityRefCS=ruleTypedMultiplicityRefCS
	 { $current=$iv_ruleTypedMultiplicityRefCS.current; }
	 EOF
;

// Rule TypedMultiplicityRefCS
ruleTypedMultiplicityRefCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypedMultiplicityRefCSAccess().getMapTypeCSParserRuleCall_0_0());
    }
    this_MapTypeCS_0=ruleMapTypeCS
    {
        $current = $this_MapTypeCS_0.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypedMultiplicityRefCSAccess().getTupleTypeCSParserRuleCall_0_1());
    }
    this_TupleTypeCS_1=ruleTupleTypeCS
    {
        $current = $this_TupleTypeCS_1.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypedMultiplicityRefCSAccess().getTypedTypeRefCSParserRuleCall_0_2());
    }
    this_TypedTypeRefCS_2=ruleTypedTypeRefCS
    {
        $current = $this_TypedTypeRefCS_2.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypedMultiplicityRefCSAccess().getLambdaTypeCSParserRuleCall_0_3());
    }
    this_LambdaTypeCS_3=ruleLambdaTypeCS
    {
        $current = $this_LambdaTypeCS_3.current;
        afterParserOrEnumRuleCall();
    }
)(
(
		{
	        newCompositeNode(grammarAccess.getTypedMultiplicityRefCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0());
	    }
		lv_ownedMultiplicity_4_0=ruleMultiplicityCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypedMultiplicityRefCSRule());
	        }
       		set(
       			$current,
       			"ownedMultiplicity",
        		lv_ownedMultiplicity_4_0,
        		"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
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
(
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypedRefCSAccess().getMapTypeCSParserRuleCall_0());
    }
    this_MapTypeCS_0=ruleMapTypeCS
    {
        $current = $this_MapTypeCS_0.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypedRefCSAccess().getTupleTypeCSParserRuleCall_1());
    }
    this_TupleTypeCS_1=ruleTupleTypeCS
    {
        $current = $this_TupleTypeCS_1.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall_2());
    }
    this_TypedTypeRefCS_2=ruleTypedTypeRefCS
    {
        $current = $this_TypedTypeRefCS_2.current;
        afterParserOrEnumRuleCall();
    }

    |
	{
	  /* */
	}
    {
        newCompositeNode(grammarAccess.getTypedRefCSAccess().getLambdaTypeCSParserRuleCall_3());
    }
    this_LambdaTypeCS_3=ruleLambdaTypeCS
    {
        $current = $this_LambdaTypeCS_3.current;
        afterParserOrEnumRuleCall();
    }
)
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
(((
(
		lv_isTypeof_0_0=	'typeof'
    {
        newLeafNode(lv_isTypeof_0_0, grammarAccess.getTypedTypeRefCSAccess().getIsTypeofTypeofKeyword_0_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTypedTypeRefCSRule());
	        }
       		setWithLastConsumed($current, "isTypeof", true, "typeof");
	    }

)
)	otherlv_1='('
    {
    	newLeafNode(otherlv_1, grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_0_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameLibPathNameCSParserRuleCall_0_2_0());
	    }
		lv_ownedPathName_2_0=ruleLibPathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
	        }
       		set(
       			$current,
       			"ownedPathName",
        		lv_ownedPathName_2_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibPathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=')'
    {
    	newLeafNode(otherlv_3, grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_0_3());
    }
)
    |((
(
		{
	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameLibPathNameCSParserRuleCall_1_0_0());
	    }
		lv_ownedPathName_4_0=ruleLibPathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
	        }
       		set(
       			$current,
       			"ownedPathName",
        		lv_ownedPathName_4_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.LibPathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5='('
    {
    	newLeafNode(otherlv_5, grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_1_0());
	    }
		lv_ownedBinding_6_0=ruleTemplateBindingCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
	        }
       		set(
       			$current,
       			"ownedBinding",
        		lv_ownedBinding_6_0,
        		"org.eclipse.ocl.xtext.base.Base.TemplateBindingCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7=')'
    {
    	newLeafNode(otherlv_7, grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_1_2());
    }
)?))
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
	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameIdentifierParserRuleCall_0_0());
	    }
		lv_name_0_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
	        }
       		set(
       			$current,
       			"name",
        		lv_name_0_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Identifier");
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
	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0());
	    }
		lv_ownedType_2_0=ruleTypedMultiplicityRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
	        }
       		set(
       			$current,
       			"ownedType",
        		lv_ownedType_2_0,
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedMultiplicityRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;







// Entry rule entryRuleEssentialOCLReservedKeyword
entryRuleEssentialOCLReservedKeyword returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getEssentialOCLReservedKeywordRule()); }
	 iv_ruleEssentialOCLReservedKeyword=ruleEssentialOCLReservedKeyword
	 { $current=$iv_ruleEssentialOCLReservedKeyword.current.getText(); }
	 EOF
;

// Rule EssentialOCLReservedKeyword
ruleEssentialOCLReservedKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(
	kw='and'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getAndKeyword_0());
    }

    |
	kw='and2'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getAnd2Keyword_1());
    }

    |
	kw='else'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getElseKeyword_2());
    }

    |
	kw='endif'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getEndifKeyword_3());
    }

    |
	kw='if'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getIfKeyword_4());
    }

    |
	kw='implies'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getImpliesKeyword_5());
    }

    |
	kw='implies2'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getImplies2Keyword_6());
    }

    |
	kw='in'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getInKeyword_7());
    }

    |
	kw='let'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getLetKeyword_8());
    }

    |
	kw='not'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getNotKeyword_9());
    }

    |
	kw='not2'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getNot2Keyword_10());
    }

    |
	kw='or'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getOrKeyword_11());
    }

    |
	kw='or2'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getOr2Keyword_12());
    }

    |
	kw='then'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getThenKeyword_13());
    }

    |
	kw='with'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getWithKeyword_14());
    }

    |
	kw='xor'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getXorKeyword_15());
    }

    |
	kw='xor2'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLReservedKeywordAccess().getXor2Keyword_16());
    }
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





// Entry rule entryRuleURIPathNameCS
entryRuleURIPathNameCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getURIPathNameCSRule()); }
	 iv_ruleURIPathNameCS=ruleURIPathNameCS
	 { $current=$iv_ruleURIPathNameCS.current; }
	 EOF
;

// Rule URIPathNameCS
ruleURIPathNameCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsURIFirstPathElementCSParserRuleCall_0_0());
	    }
		lv_ownedPathElements_0_0=ruleURIFirstPathElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getURIPathNameCSRule());
	        }
       		add(
       			$current,
       			"ownedPathElements",
        		lv_ownedPathElements_0_0,
        		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.URIFirstPathElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='::'
    {
    	newLeafNode(otherlv_1, grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0());
	    }
		lv_ownedPathElements_2_0=ruleNextPathElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getURIPathNameCSRule());
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
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TuplePartCS");
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
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TuplePartCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_5=')'
    {
    	newLeafNode(otherlv_5, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2());
    }
)?)
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
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.Identifier");
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





// Entry rule entryRuleTemplateSignatureCS
entryRuleTemplateSignatureCS returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTemplateSignatureCSRule()); }
	 iv_ruleTemplateSignatureCS=ruleTemplateSignatureCS
	 { $current=$iv_ruleTemplateSignatureCS.current; }
	 EOF
;

// Rule TemplateSignatureCS
ruleTemplateSignatureCS returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='('
    {
    	newLeafNode(otherlv_0, grammarAccess.getTemplateSignatureCSAccess().getLeftParenthesisKeyword_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_1_0());
	    }
		lv_ownedParameters_1_0=ruleTypeParameterCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTemplateSignatureCSRule());
	        }
       		add(
       			$current,
       			"ownedParameters",
        		lv_ownedParameters_1_0,
        		"org.eclipse.ocl.xtext.base.Base.TypeParameterCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=','
    {
    	newLeafNode(otherlv_2, grammarAccess.getTemplateSignatureCSAccess().getCommaKeyword_2_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_2_1_0());
	    }
		lv_ownedParameters_3_0=ruleTypeParameterCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTemplateSignatureCSRule());
	        }
       		add(
       			$current,
       			"ownedParameters",
        		lv_ownedParameters_3_0,
        		"org.eclipse.ocl.xtext.base.Base.TypeParameterCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_4=')'
    {
    	newLeafNode(otherlv_4, grammarAccess.getTemplateSignatureCSAccess().getRightParenthesisKeyword_3());
    }
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
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedRefCS");
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
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedRefCS");
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
        		"org.eclipse.ocl.xtext.oclstdlib.OCLstdlib.TypedRefCS");
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


