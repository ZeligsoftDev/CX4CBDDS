/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Ed Seidewitz
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.formatting

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig
import com.google.inject.Inject;
import org.eclipse.papyrus.uml.alf.services.AlfGrammarAccess

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
class AlfFormatter extends AbstractDeclarativeFormatter {

	@Inject extension AlfGrammarAccess
	
	override protected void configureFormatting(FormattingConfig c) {
	  
	  // General Keywords
	  
    for (pair : findKeywordPairs("(", ")")) {
      c.setNoSpace().after(pair.first);
      c.setNoSpace().before(pair.second);
    }
    
    for (pair : findKeywordPairs("<", ">")) {
      c.setNoSpace().before(pair.first);
      c.setNoLinewrap().around(pair.first);
      c.setNoLinewrap().before(pair.second);
    }
    
    for (openBracket : findKeywords("[")) {
      c.setNoSpace().around(openBracket);
    }
 
    for (closeBracket : findKeywords("]")) {
      c.setNoSpace().before(closeBracket);
    }
 
    for (dot : findKeywords(".")) {
      c.setNoSpace().around(dot);
    }
 
    for (dots : findKeywords("..")) {
      c.setNoSpace().around(dots);
    }
 
    for (arrow : findKeywords("->")) {
      c.setNoSpace().around(arrow);
    }
 
    for (arrow : findKeywords("=>")) {
      c.setNoSpace().around(arrow);
    }
 
    for (comma : findKeywords(",")) {
      c.setNoSpace().before(comma);
    }
 
    for (colon : findKeywords(":")) {
      c.setNoSpace().before(colon);
      c.setNoLinewrap().after(colon);
    }
 
    for (colons : findKeywords("::")) {
      c.setNoSpace().around(colons);
    }
 
    for (semicolon : findKeywords(";")) {
      c.setLinewrap().after(semicolon);
      c.setNoSpace().before(semicolon);
    }

    for (atSign : findKeywords("@")) {
      c.setNoSpace().after(atSign);
    }
    
    // Lexical Comments
    c.setLinewrap(0, 1, 2).before(SL_COMMENTRule)
    c.setLinewrap(0, 1, 2).before(ML_COMMENTRule)
    c.setLinewrap(0, 1, 1).after(ML_COMMENTRule)

    // Documentation Comment
    c.setLinewrap(0, 2, 2).before(DOCUMENTATION_COMMENTRule);
    c.setLinewrap(0, 1, 1).after(DOCUMENTATION_COMMENTRule);
    
    // Tuple
    c.setNoSpace().before(tupleAccess.leftParenthesisKeyword_0);
    c.setIndentationIncrement().after(tupleAccess.leftParenthesisKeyword_0);
    c.setIndentationDecrement().before(tupleAccess.rightParenthesisKeyword_2);  
    
    // Block
    c.setIndentationIncrement().after(blockAccess.leftCurlyBracketKeyword_1);
    c.setIndentationDecrement().before(blockAccess.rightCurlyBracketKeyword_3);
    c.setLinewrap().after(blockAccess.leftCurlyBracketKeyword_1);
    c.setLinewrap().after(blockAccess.rightCurlyBracketKeyword_3);

    // Unit Definition
    c.setLinewrap(2).after(namespaceDeclarationRule);
    c.setLinewrap(0,1,1).before(namespaceDefinitionRule);
    
    // Package Definition
    c.setIndentationIncrement().after(packageDefinitionAccess.leftCurlyBracketKeyword_2);
    c.setIndentationDecrement().before(packageDefinitionAccess.rightCurlyBracketKeyword_4);
    c.setLinewrap(2).after(packageDefinitionAccess.leftCurlyBracketKeyword_2);
    c.setLinewrap(2).before(packageDefinitionAccess.rightCurlyBracketKeyword_4);
    c.setLinewrap().after(packageDefinitionAccess.rightCurlyBracketKeyword_4);
    
    c.setIndentationIncrement().after(packageDefinitionOrStubAccess.leftCurlyBracketKeyword_2_1_0);
    c.setIndentationDecrement().before(packageDefinitionOrStubAccess.rightCurlyBracketKeyword_2_1_2);
    c.setLinewrap(2).after(packageDefinitionOrStubAccess.leftCurlyBracketKeyword_2_1_0);
    c.setLinewrap(2).before(packageDefinitionOrStubAccess.rightCurlyBracketKeyword_2_1_2);
    c.setLinewrap(2).after(packageDefinitionOrStubAccess.rightCurlyBracketKeyword_2_1_2);
    
    c.setLinewrap(0,1,1).before(importVisibilityIndicatorRule);
    
    // Class Definition
    c.setNoSpace().after(classDeclarationAccess.lessThanSignKeyword_3_0);
    c.setNoSpace().before(classDeclarationAccess.greaterThanSignKeyword_3_3);
    
    c.setIndentationIncrement().after(classDefinitionAccess.leftCurlyBracketKeyword_1);
    c.setIndentationDecrement().before(classDefinitionAccess.rightCurlyBracketKeyword_3);
    c.setLinewrap(2).after(classDefinitionAccess.leftCurlyBracketKeyword_1);
    c.setLinewrap(2).before(classDefinitionAccess.rightCurlyBracketKeyword_3);
    c.setLinewrap().after(classDefinitionAccess.rightCurlyBracketKeyword_3);
    
    c.setIndentationIncrement().after(classDefinitionOrStubAccess.leftCurlyBracketKeyword_1_1_0);
    c.setIndentationDecrement().before(classDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    c.setLinewrap(2).after(classDefinitionOrStubAccess.leftCurlyBracketKeyword_1_1_0);
    c.setLinewrap(2).before(classDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    c.setLinewrap(2).after(classDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
        
    c.setLinewrap().before(visibilityIndicatorRule);

    // Active Class Definition
    c.setNoSpace().after(activeClassDeclarationAccess.lessThanSignKeyword_4_0);
    c.setNoSpace().before(activeClassDeclarationAccess.greaterThanSignKeyword_4_3);
    
    c.setIndentationIncrement().after(activeClassDefinitionAccess.leftCurlyBracketKeyword_1);
    c.setIndentationDecrement().before(activeClassDefinitionAccess.rightCurlyBracketKeyword_3);
    c.setLinewrap(2).after(activeClassDefinitionAccess.leftCurlyBracketKeyword_1);
    c.setLinewrap(2).before(activeClassDefinitionAccess.rightCurlyBracketKeyword_3);
    c.setLinewrap().after(activeClassDefinitionAccess.rightCurlyBracketKeyword_3);
    c.setNoLinewrap().before(activeClassDefinitionAccess.doKeyword_4_0);
    
    c.setIndentationIncrement().after(activeClassDefinitionOrStubAccess.leftCurlyBracketKeyword_1_1_0);
    c.setIndentationDecrement().before(activeClassDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    c.setLinewrap(2).after(activeClassDefinitionOrStubAccess.leftCurlyBracketKeyword_1_1_0);
    c.setLinewrap(2).before(activeClassDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    c.setLinewrap(2).after(activeClassDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    c.setNoLinewrap().before(activeClassDefinitionOrStubAccess.doKeyword_1_1_3_0);
    
    c.setLinewrap(2).after(behaviorClauseRule);
    
    // Data Type Definition
    c.setNoSpace().after(dataTypeDeclarationAccess.lessThanSignKeyword_3_0);
    c.setNoSpace().before(dataTypeDeclarationAccess.greaterThanSignKeyword_3_3);
    
    c.setIndentationIncrement().after(dataTypeDefinitionAccess.leftCurlyBracketKeyword_1);
    c.setIndentationDecrement().before(dataTypeDefinitionAccess.rightCurlyBracketKeyword_3);
    c.setLinewrap().after(dataTypeDefinitionAccess.leftCurlyBracketKeyword_1);
    c.setLinewrap().after(dataTypeDefinitionAccess.rightCurlyBracketKeyword_3);
    
    c.setIndentationIncrement().after(dataTypeDefinitionOrStubAccess.leftCurlyBracketKeyword_1_1_0);
    c.setIndentationDecrement().before(dataTypeDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    c.setLinewrap().after(dataTypeDefinitionOrStubAccess.leftCurlyBracketKeyword_1_1_0);
    c.setLinewrap(2).after(dataTypeDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    
    // Association Definition
    c.setNoSpace().after(associationDeclarationAccess.lessThanSignKeyword_3_0);
    c.setNoSpace().before(associationDeclarationAccess.greaterThanSignKeyword_3_3);
    
    c.setIndentationIncrement().after(associationDefinitionAccess.leftCurlyBracketKeyword_1);
    c.setIndentationDecrement().before(associationDefinitionAccess.rightCurlyBracketKeyword_3);
    c.setLinewrap().after(associationDefinitionAccess.leftCurlyBracketKeyword_1);
    c.setLinewrap().after(associationDefinitionAccess.rightCurlyBracketKeyword_3);
    
    c.setIndentationIncrement().after(associationDefinitionOrStubAccess.leftCurlyBracketKeyword_1_1_0);
    c.setIndentationDecrement().before(associationDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    c.setLinewrap().after(associationDefinitionOrStubAccess.leftCurlyBracketKeyword_1_1_0);
    c.setLinewrap(2).after(associationDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    
    // Signal Definition
    c.setNoSpace().after(signalDeclarationAccess.lessThanSignKeyword_3_0);
    c.setNoSpace().before(signalDeclarationAccess.greaterThanSignKeyword_3_3);
    
    c.setIndentationIncrement().after(signalDefinitionAccess.leftCurlyBracketKeyword_1);
    c.setIndentationDecrement().before(signalDefinitionAccess.rightCurlyBracketKeyword_3);
    c.setLinewrap().after(signalDefinitionAccess.leftCurlyBracketKeyword_1);
    c.setLinewrap().after(signalDefinitionAccess.rightCurlyBracketKeyword_3);
    
    c.setIndentationIncrement().after(signalDefinitionOrStubAccess.leftCurlyBracketKeyword_1_1_0);
    c.setIndentationDecrement().before(signalDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    c.setLinewrap().after(signalDefinitionOrStubAccess.leftCurlyBracketKeyword_1_1_0);
    c.setLinewrap(2).after(signalDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    
    // Signal Reception Definition
    c.setIndentationIncrement().after(signalReceptionDefinitionOrStubAccess.leftCurlyBracketKeyword_1_1_0);
    c.setIndentationDecrement().before(signalReceptionDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    c.setLinewrap().after(signalReceptionDefinitionOrStubAccess.leftCurlyBracketKeyword_1_1_0);
    c.setLinewrap(2).after(signalReceptionDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    
    // Enumeration Definition
    c.setIndentationIncrement().after(enumerationDefinitionAccess.leftCurlyBracketKeyword_1);
    c.setLinewrap().after(enumerationDefinitionAccess.leftCurlyBracketKeyword_1);
    c.setLinewrap().before(enumerationDefinitionAccess.rightCurlyBracketKeyword_3);
    c.setIndentationDecrement().before(enumerationDefinitionAccess.rightCurlyBracketKeyword_3);
    c.setLinewrap().after(enumerationDefinitionAccess.rightCurlyBracketKeyword_3);
    c.setLinewrap().after(enumerationDefinitionAccess.commaKeyword_2_1_0);
    
    c.setIndentationIncrement().after(enumerationDefinitionOrStubAccess.leftCurlyBracketKeyword_1_1_0);
    c.setIndentationDecrement().before(enumerationDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    c.setLinewrap(2).after(enumerationDefinitionOrStubAccess.rightCurlyBracketKeyword_1_1_2);
    
    // Activity Definition
    c.setNoSpace().after(activityDeclarationAccess.lessThanSignKeyword_2_0);
    c.setNoSpace().before(activityDeclarationAccess.greaterThanSignKeyword_2_3);
    c.setNoSpace().before(activityDeclarationAccess.leftParenthesisKeyword_3);
    c.setIndentationIncrement().after(activityDeclarationAccess.leftParenthesisKeyword_3);
    c.setIndentationDecrement().before(activityDeclarationAccess.rightParenthesisKeyword_5);  
    c.setIndentationIncrement().after(returnParameterDefinitionAccess.colonKeyword_0);
    c.setIndentationDecrement().after(returnParameterDefinitionRule);
    
    // Property Definition
    c.setIndentationIncrement().after(propertyDeclarationAccess.colonKeyword_1);
    c.setIndentationDecrement().after(propertyDefinitionAccess.semicolonKeyword_1);
    c.setIndentationDecrement().after(attributeDefinitionAccess.semicolonKeyword_2);
    
    // Operation Definition
    c.setNoSpace().before(operationDeclarationAccess.leftParenthesisKeyword_2);
    c.setIndentationIncrement().after(operationDeclarationAccess.leftParenthesisKeyword_2);
    c.setIndentationDecrement().before(operationDeclarationAccess.rightParenthesisKeyword_4);  

    // Formal Parameters
    c.setNoLinewrap().after(parameterDirectionRule);
    
	}
}
