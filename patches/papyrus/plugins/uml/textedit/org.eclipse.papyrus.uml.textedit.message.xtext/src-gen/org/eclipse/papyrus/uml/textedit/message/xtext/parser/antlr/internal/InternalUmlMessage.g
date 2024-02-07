/*
 * generated by Xtext
 */
grammar InternalUmlMessage;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.eclipse.papyrus.uml.textedit.message.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.papyrus.uml.textedit.message.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.papyrus.uml.textedit.message.xtext.services.UmlMessageGrammarAccess;

}

@parser::members {

 	private UmlMessageGrammarAccess grammarAccess;
 	
    public InternalUmlMessageParser(TokenStream input, UmlMessageGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "MessageRule";	
   	}
   	
   	@Override
   	protected UmlMessageGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleMessageRule
entryRuleMessageRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMessageRuleRule()); }
	 iv_ruleMessageRule=ruleMessageRule 
	 { $current=$iv_ruleMessageRule.current; } 
	 EOF 
;

// Rule MessageRule
ruleMessageRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getMessageRuleAccess().getSequenceTermSequenceTermRuleParserRuleCall_0_0()); 
	    }
		lv_sequenceTerm_0_0=ruleSequenceTermRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMessageRuleRule());
	        }
       		add(
       			$current, 
       			"sequenceTerm",
        		lv_sequenceTerm_0_0, 
        		"org.eclipse.papyrus.uml.textedit.message.xtext.UmlMessage.SequenceTermRule");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='.' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMessageRuleAccess().getFullStopKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMessageRuleAccess().getSequenceTermSequenceTermRuleParserRuleCall_1_1_0()); 
	    }
		lv_sequenceTerm_2_0=ruleSequenceTermRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMessageRuleRule());
	        }
       		add(
       			$current, 
       			"sequenceTerm",
        		lv_sequenceTerm_2_0, 
        		"org.eclipse.papyrus.uml.textedit.message.xtext.UmlMessage.SequenceTermRule");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getMessageRuleAccess().getColonKeyword_2());
    }
(
(
		lv_name_4_0=RULE_NAME_RULE
		{
			newLeafNode(lv_name_4_0, grammarAccess.getMessageRuleAccess().getNameNAME_RULETerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMessageRuleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_4_0, 
        		"org.eclipse.papyrus.uml.textedit.message.xtext.UmlMessage.NAME_RULE");
	    }

)
))
;





// Entry rule entryRuleSequenceTermRule
entryRuleSequenceTermRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSequenceTermRuleRule()); }
	 iv_ruleSequenceTermRule=ruleSequenceTermRule 
	 { $current=$iv_ruleSequenceTermRule.current; } 
	 EOF 
;

// Rule SequenceTermRule
ruleSequenceTermRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_sequencialOrder_0_0=RULE_INT
		{
			newLeafNode(lv_sequencialOrder_0_0, grammarAccess.getSequenceTermRuleAccess().getSequencialOrderINTTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSequenceTermRuleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"sequencialOrder",
        		lv_sequencialOrder_0_0, 
        		"org.eclipse.papyrus.uml.alf.Common.INT");
	    }

)
)(
(
		lv_sequenceName_1_0=RULE_ID
		{
			newLeafNode(lv_sequenceName_1_0, grammarAccess.getSequenceTermRuleAccess().getSequenceNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSequenceTermRuleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"sequenceName",
        		lv_sequenceName_1_0, 
        		"org.eclipse.papyrus.uml.alf.Common.ID");
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getSequenceTermRuleAccess().getRecurrenceRecurrenceRuleParserRuleCall_2_0()); 
	    }
		lv_recurrence_2_0=ruleRecurrenceRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSequenceTermRuleRule());
	        }
       		set(
       			$current, 
       			"recurrence",
        		lv_recurrence_2_0, 
        		"org.eclipse.papyrus.uml.textedit.message.xtext.UmlMessage.RecurrenceRule");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleRecurrenceRule
entryRuleRecurrenceRule returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getRecurrenceRuleRule()); } 
	 iv_ruleRecurrenceRule=ruleRecurrenceRule 
	 { $current=$iv_ruleRecurrenceRule.current.getText(); }  
	 EOF 
;

// Rule RecurrenceRule
ruleRecurrenceRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	kw='*' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getAsteriskKeyword_0_0()); 
    }

	kw='[' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getLeftSquareBracketKeyword_0_1()); 
    }
    this_STRING_2=RULE_STRING    {
		$current.merge(this_STRING_2);
    }

    { 
    newLeafNode(this_STRING_2, grammarAccess.getRecurrenceRuleAccess().getSTRINGTerminalRuleCall_0_2()); 
    }

	kw=']' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getRightSquareBracketKeyword_0_3()); 
    }
)
    |(
	kw='[' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getLeftSquareBracketKeyword_1_0()); 
    }
    this_STRING_5=RULE_STRING    {
		$current.merge(this_STRING_5);
    }

    { 
    newLeafNode(this_STRING_5, grammarAccess.getRecurrenceRuleAccess().getSTRINGTerminalRuleCall_1_1()); 
    }

	kw=']' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getRightSquareBracketKeyword_1_2()); 
    }
))
    ;





RULE_NAME_RULE : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'_'|'-'|'0'..'9'|'('|')')*;

RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'\'' ( options {greedy=false;} : . )*'\'');

RULE_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

RULE_ML_COMMENT : '/*' ~('@') ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'|'@'))* ('\r'? '\n')?;

RULE_INT : ('0'..'9')+;

RULE_INTEGER_VALUE : (('0'|'1'..'9' ('_'? '0'..'9')*)|('0b'|'0B') '0'..'1' ('_'? '0'..'1')*|('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F') ('_'? ('0'..'9'|'a'..'f'|'A'..'F'))*|'0' '_'? '0'..'7' ('_'? '0'..'7')*);

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


