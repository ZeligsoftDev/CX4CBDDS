/*
 * generated by Xtext
 */
grammar InternalUmlPort;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.eclipse.papyrus.uml.textedit.port.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.papyrus.uml.textedit.port.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.papyrus.uml.textedit.port.xtext.services.UmlPortGrammarAccess;

}

@parser::members {

 	private UmlPortGrammarAccess grammarAccess;
 	
    public InternalUmlPortParser(TokenStream input, UmlPortGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "PortRule";	
   	}
   	
   	@Override
   	protected UmlPortGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRulePortRule
entryRulePortRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPortRuleRule()); }
	 iv_rulePortRule=rulePortRule 
	 { $current=$iv_rulePortRule.current; } 
	 EOF 
;

// Rule PortRule
rulePortRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getPortRuleAccess().getVisibilityVisibilityRuleParserRuleCall_0_0()); 
	    }
		lv_visibility_0_0=ruleVisibilityRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPortRuleRule());
	        }
       		set(
       			$current, 
       			"visibility",
        		lv_visibility_0_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.VisibilityRule");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		lv_derived_1_0=	'/' 
    {
        newLeafNode(lv_derived_1_0, grammarAccess.getPortRuleAccess().getDerivedSolidusKeyword_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPortRuleRule());
	        }
       		setWithLastConsumed($current, "derived", true, "/");
	    }

)
)?(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getPortRuleAccess().getNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPortRuleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"org.eclipse.papyrus.uml.alf.Common.ID");
	    }

)
)(	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getPortRuleAccess().getColonKeyword_3_0());
    }
(
(
		lv_conjugated_4_0=	'~' 
    {
        newLeafNode(lv_conjugated_4_0, grammarAccess.getPortRuleAccess().getConjugatedTildeKeyword_3_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPortRuleRule());
	        }
       		setWithLastConsumed($current, "conjugated", true, "~");
	    }

)
)?((
(
		{ 
	        newCompositeNode(grammarAccess.getPortRuleAccess().getTypeTypeRuleParserRuleCall_3_2_0_0()); 
	    }
		lv_type_5_0=ruleTypeRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPortRuleRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_5_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.TypeRule");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		lv_typeUndefined_6_0=	'<Undefined>' 
    {
        newLeafNode(lv_typeUndefined_6_0, grammarAccess.getPortRuleAccess().getTypeUndefinedUndefinedKeyword_3_2_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPortRuleRule());
	        }
       		setWithLastConsumed($current, "typeUndefined", true, "<Undefined>");
	    }

)
)))?(
(
		{ 
	        newCompositeNode(grammarAccess.getPortRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_4_0()); 
	    }
		lv_multiplicity_7_0=ruleMultiplicityRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPortRuleRule());
	        }
       		set(
       			$current, 
       			"multiplicity",
        		lv_multiplicity_7_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.MultiplicityRule");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getPortRuleAccess().getModifiersModifiersRuleParserRuleCall_5_0()); 
	    }
		lv_modifiers_8_0=ruleModifiersRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPortRuleRule());
	        }
       		set(
       			$current, 
       			"modifiers",
        		lv_modifiers_8_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.ModifiersRule");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getPortRuleAccess().getDefaultDefaultValueRuleParserRuleCall_6_0()); 
	    }
		lv_default_9_0=ruleDefaultValueRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPortRuleRule());
	        }
       		set(
       			$current, 
       			"default",
        		lv_default_9_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.DefaultValueRule");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleVisibilityRule
entryRuleVisibilityRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVisibilityRuleRule()); }
	 iv_ruleVisibilityRule=ruleVisibilityRule 
	 { $current=$iv_ruleVisibilityRule.current; } 
	 EOF 
;

// Rule VisibilityRule
ruleVisibilityRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getVisibilityRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0()); 
	    }
		lv_visibility_0_0=ruleVisibilityKind		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVisibilityRuleRule());
	        }
       		set(
       			$current, 
       			"visibility",
        		lv_visibility_0_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.VisibilityKind");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleTypeRule
entryRuleTypeRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTypeRuleRule()); }
	 iv_ruleTypeRule=ruleTypeRule 
	 { $current=$iv_ruleTypeRule.current; } 
	 EOF 
;

// Rule TypeRule
ruleTypeRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
	    }
		lv_path_0_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeRuleRule());
	        }
       		set(
       			$current, 
       			"path",
        		lv_path_0_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getTypeRuleRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0()); 
	}

)
))
;





// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); }
	 iv_ruleQualifiedName=ruleQualifiedName 
	 { $current=$iv_ruleQualifiedName.current; } 
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getQualifiedNameRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
	}

)
)	otherlv_1='::' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
	    }
		lv_remaining_2_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getQualifiedNameRule());
	        }
       		set(
       			$current, 
       			"remaining",
        		lv_remaining_2_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleMultiplicityRule
entryRuleMultiplicityRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMultiplicityRuleRule()); }
	 iv_ruleMultiplicityRule=ruleMultiplicityRule 
	 { $current=$iv_ruleMultiplicityRule.current; } 
	 EOF 
;

// Rule MultiplicityRule
ruleMultiplicityRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='[' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0_0()); 
	    }
		lv_bounds_1_0=ruleBoundSpecification		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMultiplicityRuleRule());
	        }
       		add(
       			$current, 
       			"bounds",
        		lv_bounds_1_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.BoundSpecification");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='..' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_1_1());
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_0()); 
	    }
		lv_bounds_3_0=ruleBoundSpecification		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMultiplicityRuleRule());
	        }
       		add(
       			$current, 
       			"bounds",
        		lv_bounds_3_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.BoundSpecification");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4=']' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3());
    }
)
;





// Entry rule entryRuleBoundSpecification
entryRuleBoundSpecification returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getBoundSpecificationRule()); }
	 iv_ruleBoundSpecification=ruleBoundSpecification 
	 { $current=$iv_ruleBoundSpecification.current; } 
	 EOF 
;

// Rule BoundSpecification
ruleBoundSpecification returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
(
		{ 
	        newCompositeNode(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0_0()); 
	    }
		lv_value_0_1=ruleUnlimitedLiteral		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBoundSpecificationRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_0_1, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.UnlimitedLiteral");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getBoundSpecificationAccess().getValueStringLiteralParserRuleCall_0_1()); 
	    }
		lv_value_0_2=ruleStringLiteral		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBoundSpecificationRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_0_2, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.StringLiteral");
	        afterParserOrEnumRuleCall();
	    }

)

)
)
;





// Entry rule entryRuleUnlimitedLiteral
entryRuleUnlimitedLiteral returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getUnlimitedLiteralRule()); } 
	 iv_ruleUnlimitedLiteral=ruleUnlimitedLiteral 
	 { $current=$iv_ruleUnlimitedLiteral.current.getText(); }  
	 EOF 
;

// Rule UnlimitedLiteral
ruleUnlimitedLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    { 
    newLeafNode(this_INT_0, grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 
    }

    |
	kw='*' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1()); 
    }
)
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
    this_STRING_0=RULE_STRING    {
		$current.merge(this_STRING_0);
    }

    { 
    newLeafNode(this_STRING_0, grammarAccess.getStringLiteralAccess().getSTRINGTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleModifiersRule
entryRuleModifiersRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getModifiersRuleRule()); }
	 iv_ruleModifiersRule=ruleModifiersRule 
	 { $current=$iv_ruleModifiersRule.current; } 
	 EOF 
;

// Rule ModifiersRule
ruleModifiersRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getModifiersRuleAccess().getModifiersRuleAction_0(),
            $current);
    }
)	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_0_0()); 
	    }
		lv_values_2_0=ruleModifierSpecification		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModifiersRuleRule());
	        }
       		add(
       			$current, 
       			"values",
        		lv_values_2_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.ModifierSpecification");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_1_0()); 
	    }
		lv_values_4_0=ruleModifierSpecification		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModifiersRuleRule());
	        }
       		add(
       			$current, 
       			"values",
        		lv_values_4_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.ModifierSpecification");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleModifierSpecification
entryRuleModifierSpecification returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getModifierSpecificationRule()); }
	 iv_ruleModifierSpecification=ruleModifierSpecification 
	 { $current=$iv_ruleModifierSpecification.current; } 
	 EOF 
;

// Rule ModifierSpecification
ruleModifierSpecification returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0()); 
	    }
		lv_value_0_0=ruleModifierKind		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModifierSpecificationRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_0_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.ModifierKind");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0()); 
	    }
		lv_redefines_1_0=ruleRedefinesRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModifierSpecificationRule());
	        }
       		set(
       			$current, 
       			"redefines",
        		lv_redefines_1_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.RedefinesRule");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0()); 
	    }
		lv_subsets_2_0=ruleSubsetsRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModifierSpecificationRule());
	        }
       		set(
       			$current, 
       			"subsets",
        		lv_subsets_2_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.SubsetsRule");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleRedefinesRule
entryRuleRedefinesRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRedefinesRuleRule()); }
	 iv_ruleRedefinesRule=ruleRedefinesRule 
	 { $current=$iv_ruleRedefinesRule.current; } 
	 EOF 
;

// Rule RedefinesRule
ruleRedefinesRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='redefines' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getRedefinesRuleRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getRedefinesRuleAccess().getPortPortCrossReference_1_0()); 
	}

)
))
;





// Entry rule entryRuleSubsetsRule
entryRuleSubsetsRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSubsetsRuleRule()); }
	 iv_ruleSubsetsRule=ruleSubsetsRule 
	 { $current=$iv_ruleSubsetsRule.current; } 
	 EOF 
;

// Rule SubsetsRule
ruleSubsetsRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='subsets' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSubsetsRuleRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getSubsetsRuleAccess().getPortPortCrossReference_1_0()); 
	}

)
))
;





// Entry rule entryRuleDefaultValueRule
entryRuleDefaultValueRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getDefaultValueRuleRule()); }
	 iv_ruleDefaultValueRule=ruleDefaultValueRule 
	 { $current=$iv_ruleDefaultValueRule.current; } 
	 EOF 
;

// Rule DefaultValueRule
ruleDefaultValueRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='=' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getDefaultValueRuleAccess().getDefaultValueParserRuleCall_1_0()); 
	    }
		lv_default_1_0=ruleValue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDefaultValueRuleRule());
	        }
       		set(
       			$current, 
       			"default",
        		lv_default_1_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.Value");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleValue
entryRuleValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getValueRule()); }
	 iv_ruleValue=ruleValue 
	 { $current=$iv_ruleValue.current; } 
	 EOF 
;

// Rule Value
ruleValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getValueAccess().getIntValueParserRuleCall_0()); 
    }
    this_IntValue_0=ruleIntValue
    { 
        $current = $this_IntValue_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getValueAccess().getStringValueParserRuleCall_1()); 
    }
    this_StringValue_1=ruleStringValue
    { 
        $current = $this_StringValue_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getValueAccess().getBooleanValueParserRuleCall_2()); 
    }
    this_BooleanValue_2=ruleBooleanValue
    { 
        $current = $this_BooleanValue_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getValueAccess().getRealValueParserRuleCall_3()); 
    }
    this_RealValue_3=ruleRealValue
    { 
        $current = $this_RealValue_3.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getValueAccess().getNullValueParserRuleCall_4()); 
    }
    this_NullValue_4=ruleNullValue
    { 
        $current = $this_NullValue_4.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getValueAccess().getNoValueParserRuleCall_5()); 
    }
    this_NoValue_5=ruleNoValue
    { 
        $current = $this_NoValue_5.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleIntValue
entryRuleIntValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getIntValueRule()); }
	 iv_ruleIntValue=ruleIntValue 
	 { $current=$iv_ruleIntValue.current; } 
	 EOF 
;

// Rule IntValue
ruleIntValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		lv_literalInteger_0_0=RULE_INT
		{
			newLeafNode(lv_literalInteger_0_0, grammarAccess.getIntValueAccess().getLiteralIntegerINTTerminalRuleCall_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getIntValueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"literalInteger",
        		lv_literalInteger_0_0, 
        		"org.eclipse.papyrus.uml.alf.Common.INT");
	    }

)
)
;





// Entry rule entryRuleStringValue
entryRuleStringValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getStringValueRule()); }
	 iv_ruleStringValue=ruleStringValue 
	 { $current=$iv_ruleStringValue.current; } 
	 EOF 
;

// Rule StringValue
ruleStringValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		lv_literalString_0_0=RULE_STRING
		{
			newLeafNode(lv_literalString_0_0, grammarAccess.getStringValueAccess().getLiteralStringSTRINGTerminalRuleCall_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getStringValueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"literalString",
        		lv_literalString_0_0, 
        		"org.eclipse.papyrus.uml.alf.Common.STRING");
	    }

)
)
;





// Entry rule entryRuleBooleanValue
entryRuleBooleanValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getBooleanValueRule()); }
	 iv_ruleBooleanValue=ruleBooleanValue 
	 { $current=$iv_ruleBooleanValue.current; } 
	 EOF 
;

// Rule BooleanValue
ruleBooleanValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getBooleanValueAccess().getLiteralBooleanBooleanLiteralsEnumRuleCall_0()); 
	    }
		lv_literalBoolean_0_0=ruleBooleanLiterals		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBooleanValueRule());
	        }
       		set(
       			$current, 
       			"literalBoolean",
        		lv_literalBoolean_0_0, 
        		"org.eclipse.papyrus.uml.textedit.port.xtext.UmlPort.BooleanLiterals");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleRealValue
entryRuleRealValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRealValueRule()); }
	 iv_ruleRealValue=ruleRealValue 
	 { $current=$iv_ruleRealValue.current; } 
	 EOF 
;

// Rule RealValue
ruleRealValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((
(
		lv_integer_0_0=RULE_INT
		{
			newLeafNode(lv_integer_0_0, grammarAccess.getRealValueAccess().getIntegerINTTerminalRuleCall_0_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRealValueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"integer",
        		lv_integer_0_0, 
        		"org.eclipse.papyrus.uml.alf.Common.INT");
	    }

)
)	otherlv_1='.' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getRealValueAccess().getFullStopKeyword_0_1());
    }
)
    |(	otherlv_2='.' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getRealValueAccess().getFullStopKeyword_1_0());
    }
(
(
		lv_fraction_3_0=RULE_INT
		{
			newLeafNode(lv_fraction_3_0, grammarAccess.getRealValueAccess().getFractionINTTerminalRuleCall_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRealValueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"fraction",
        		lv_fraction_3_0, 
        		"org.eclipse.papyrus.uml.alf.Common.INT");
	    }

)
))
    |((
(
		lv_integer_4_0=RULE_INT
		{
			newLeafNode(lv_integer_4_0, grammarAccess.getRealValueAccess().getIntegerINTTerminalRuleCall_2_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRealValueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"integer",
        		lv_integer_4_0, 
        		"org.eclipse.papyrus.uml.alf.Common.INT");
	    }

)
)	otherlv_5='.' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getRealValueAccess().getFullStopKeyword_2_1());
    }
(
(
		lv_fraction_6_0=RULE_INT
		{
			newLeafNode(lv_fraction_6_0, grammarAccess.getRealValueAccess().getFractionINTTerminalRuleCall_2_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRealValueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"fraction",
        		lv_fraction_6_0, 
        		"org.eclipse.papyrus.uml.alf.Common.INT");
	    }

)
)))
;





// Entry rule entryRuleNullValue
entryRuleNullValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNullValueRule()); }
	 iv_ruleNullValue=ruleNullValue 
	 { $current=$iv_ruleNullValue.current; } 
	 EOF 
;

// Rule NullValue
ruleNullValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getNullValueAccess().getNullValueAction_0(),
            $current);
    }
)	otherlv_1='null' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getNullValueAccess().getNullKeyword_1());
    }
)
;





// Entry rule entryRuleNoValue
entryRuleNoValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNoValueRule()); }
	 iv_ruleNoValue=ruleNoValue 
	 { $current=$iv_ruleNoValue.current; } 
	 EOF 
;

// Rule NoValue
ruleNoValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getNoValueAccess().getNoValueAction_0(),
            $current);
    }
)	otherlv_1='none' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getNoValueAccess().getNoneKeyword_1());
    }
)
;





// Rule VisibilityKind
ruleVisibilityKind returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='+' 
	{
        $current = grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='-' 
	{
        $current = grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='#' 
	{
        $current = grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='~' 
	{
        $current = grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 
    }
));



// Rule ModifierKind
ruleModifierKind returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='readOnly' 
	{
        $current = grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='union' 
	{
        $current = grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='ordered' 
	{
        $current = grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='unique' 
	{
        $current = grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3()); 
    }
));



// Rule BooleanLiterals
ruleBooleanLiterals returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='true' 
	{
        $current = grammarAccess.getBooleanLiteralsAccess().getTRUEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getBooleanLiteralsAccess().getTRUEEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='false' 
	{
        $current = grammarAccess.getBooleanLiteralsAccess().getFALSEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getBooleanLiteralsAccess().getFALSEEnumLiteralDeclaration_1()); 
    }
));



RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'\'' ( options {greedy=false;} : . )*'\'');

RULE_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

RULE_ML_COMMENT : '/*' ~('@') ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'|'@'))* ('\r'? '\n')?;

RULE_INT : ('0'..'9')+;

RULE_INTEGER_VALUE : (('0'|'1'..'9' ('_'? '0'..'9')*)|('0b'|'0B') '0'..'1' ('_'? '0'..'1')*|('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F') ('_'? ('0'..'9'|'a'..'f'|'A'..'F'))*|'0' '_'? '0'..'7' ('_'? '0'..'7')*);

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;

