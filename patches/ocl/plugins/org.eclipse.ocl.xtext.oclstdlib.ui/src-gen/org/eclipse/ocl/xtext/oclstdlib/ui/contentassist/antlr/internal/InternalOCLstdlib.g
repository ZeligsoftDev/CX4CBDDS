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
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;

}

@lexer::header {
package org.eclipse.ocl.xtext.oclstdlib.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import.
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.ocl.xtext.oclstdlib.ui.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.ocl.xtext.oclstdlib.services.OCLstdlibGrammarAccess;

}

@parser::members {

 	private OCLstdlibGrammarAccess grammarAccess;

    public void setGrammarAccess(OCLstdlibGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }

    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }

    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleLibrary
entryRuleLibrary
:
{ before(grammarAccess.getLibraryRule()); }
	 ruleLibrary
{ after(grammarAccess.getLibraryRule()); }
	 EOF
;

// Rule Library
ruleLibrary
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLibraryAccess().getGroup()); }
(rule__Library__Group__0)
{ after(grammarAccess.getLibraryAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleIdentifier
entryRuleIdentifier
:
{ before(grammarAccess.getIdentifierRule()); }
	 ruleIdentifier
{ after(grammarAccess.getIdentifierRule()); }
	 EOF
;

// Rule Identifier
ruleIdentifier
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getIdentifierAccess().getAlternatives()); }
(rule__Identifier__Alternatives)
{ after(grammarAccess.getIdentifierAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRestrictedKeywords
entryRuleRestrictedKeywords
:
{ before(grammarAccess.getRestrictedKeywordsRule()); }
	 ruleRestrictedKeywords
{ after(grammarAccess.getRestrictedKeywordsRule()); }
	 EOF
;

// Rule RestrictedKeywords
ruleRestrictedKeywords
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRestrictedKeywordsAccess().getAlternatives()); }
(rule__RestrictedKeywords__Alternatives)
{ after(grammarAccess.getRestrictedKeywordsAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleName
entryRuleName
:
{ before(grammarAccess.getNameRule()); }
	 ruleName
{ after(grammarAccess.getNameRule()); }
	 EOF
;

// Rule Name
ruleName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNameAccess().getAlternatives()); }
(rule__Name__Alternatives)
{ after(grammarAccess.getNameAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAnyName
entryRuleAnyName
:
{ before(grammarAccess.getAnyNameRule()); }
	 ruleAnyName
{ after(grammarAccess.getAnyNameRule()); }
	 EOF
;

// Rule AnyName
ruleAnyName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAnyNameAccess().getAlternatives()); }
(rule__AnyName__Alternatives)
{ after(grammarAccess.getAnyNameAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLibPathNameCS
entryRuleLibPathNameCS
:
{ before(grammarAccess.getLibPathNameCSRule()); }
	 ruleLibPathNameCS
{ after(grammarAccess.getLibPathNameCSRule()); }
	 EOF
;

// Rule LibPathNameCS
ruleLibPathNameCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLibPathNameCSAccess().getGroup()); }
(rule__LibPathNameCS__Group__0)
{ after(grammarAccess.getLibPathNameCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLibPathElementCS
entryRuleLibPathElementCS
:
{ before(grammarAccess.getLibPathElementCSRule()); }
	 ruleLibPathElementCS
{ after(grammarAccess.getLibPathElementCSRule()); }
	 EOF
;

// Rule LibPathElementCS
ruleLibPathElementCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLibPathElementCSAccess().getReferredElementAssignment()); }
(rule__LibPathElementCS__ReferredElementAssignment)
{ after(grammarAccess.getLibPathElementCSAccess().getReferredElementAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAccumulatorCS
entryRuleAccumulatorCS
:
{ before(grammarAccess.getAccumulatorCSRule()); }
	 ruleAccumulatorCS
{ after(grammarAccess.getAccumulatorCSRule()); }
	 EOF
;

// Rule AccumulatorCS
ruleAccumulatorCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAccumulatorCSAccess().getGroup()); }
(rule__AccumulatorCS__Group__0)
{ after(grammarAccess.getAccumulatorCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAnnotationCS
entryRuleAnnotationCS
:
{ before(grammarAccess.getAnnotationCSRule()); }
	 ruleAnnotationCS
{ after(grammarAccess.getAnnotationCSRule()); }
	 EOF
;

// Rule AnnotationCS
ruleAnnotationCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAnnotationCSAccess().getGroup()); }
(rule__AnnotationCS__Group__0)
{ after(grammarAccess.getAnnotationCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAnnotationElementCS
entryRuleAnnotationElementCS
:
{ before(grammarAccess.getAnnotationElementCSRule()); }
	 ruleAnnotationElementCS
{ after(grammarAccess.getAnnotationElementCSRule()); }
	 EOF
;

// Rule AnnotationElementCS
ruleAnnotationElementCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAnnotationElementCSAccess().getAlternatives()); }
(rule__AnnotationElementCS__Alternatives)
{ after(grammarAccess.getAnnotationElementCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLibClassCS
entryRuleLibClassCS
:
{ before(grammarAccess.getLibClassCSRule()); }
	 ruleLibClassCS
{ after(grammarAccess.getLibClassCSRule()); }
	 EOF
;

// Rule LibClassCS
ruleLibClassCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLibClassCSAccess().getGroup()); }
(rule__LibClassCS__Group__0)
{ after(grammarAccess.getLibClassCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleClassCS
entryRuleClassCS
:
{ before(grammarAccess.getClassCSRule()); }
	 ruleClassCS
{ after(grammarAccess.getClassCSRule()); }
	 EOF
;

// Rule ClassCS
ruleClassCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getClassCSAccess().getLibClassCSParserRuleCall()); }
	ruleLibClassCS
{ after(grammarAccess.getClassCSAccess().getLibClassCSParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDetailCS
entryRuleDetailCS
:
{ before(grammarAccess.getDetailCSRule()); }
	 ruleDetailCS
{ after(grammarAccess.getDetailCSRule()); }
	 EOF
;

// Rule DetailCS
ruleDetailCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDetailCSAccess().getGroup()); }
(rule__DetailCS__Group__0)
{ after(grammarAccess.getDetailCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDocumentationCS
entryRuleDocumentationCS
:
{ before(grammarAccess.getDocumentationCSRule()); }
	 ruleDocumentationCS
{ after(grammarAccess.getDocumentationCSRule()); }
	 EOF
;

// Rule DocumentationCS
ruleDocumentationCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDocumentationCSAccess().getGroup()); }
(rule__DocumentationCS__Group__0)
{ after(grammarAccess.getDocumentationCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleImportCS
entryRuleImportCS
:
{ before(grammarAccess.getImportCSRule()); }
	 ruleImportCS
{ after(grammarAccess.getImportCSRule()); }
	 EOF
;

// Rule ImportCS
ruleImportCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getImportCSAccess().getGroup()); }
(rule__ImportCS__Group__0)
{ after(grammarAccess.getImportCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleInvCS
entryRuleInvCS
:
{ before(grammarAccess.getInvCSRule()); }
	 ruleInvCS
{ after(grammarAccess.getInvCSRule()); }
	 EOF
;

// Rule InvCS
ruleInvCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getInvCSAccess().getGroup()); }
(rule__InvCS__Group__0)
{ after(grammarAccess.getInvCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLibCoercionCS
entryRuleLibCoercionCS
:
{ before(grammarAccess.getLibCoercionCSRule()); }
	 ruleLibCoercionCS
{ after(grammarAccess.getLibCoercionCSRule()); }
	 EOF
;

// Rule LibCoercionCS
ruleLibCoercionCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLibCoercionCSAccess().getGroup()); }
(rule__LibCoercionCS__Group__0)
{ after(grammarAccess.getLibCoercionCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLibIterationCS
entryRuleLibIterationCS
:
{ before(grammarAccess.getLibIterationCSRule()); }
	 ruleLibIterationCS
{ after(grammarAccess.getLibIterationCSRule()); }
	 EOF
;

// Rule LibIterationCS
ruleLibIterationCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLibIterationCSAccess().getGroup()); }
(rule__LibIterationCS__Group__0)
{ after(grammarAccess.getLibIterationCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleIteratorCS
entryRuleIteratorCS
:
{ before(grammarAccess.getIteratorCSRule()); }
	 ruleIteratorCS
{ after(grammarAccess.getIteratorCSRule()); }
	 EOF
;

// Rule IteratorCS
ruleIteratorCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getIteratorCSAccess().getGroup()); }
(rule__IteratorCS__Group__0)
{ after(grammarAccess.getIteratorCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLambdaTypeCS
entryRuleLambdaTypeCS
:
{ before(grammarAccess.getLambdaTypeCSRule()); }
	 ruleLambdaTypeCS
{ after(grammarAccess.getLambdaTypeCSRule()); }
	 EOF
;

// Rule LambdaTypeCS
ruleLambdaTypeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getGroup()); }
(rule__LambdaTypeCS__Group__0)
{ after(grammarAccess.getLambdaTypeCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLambdaContextTypeRefCS
entryRuleLambdaContextTypeRefCS
:
{ before(grammarAccess.getLambdaContextTypeRefCSRule()); }
	 ruleLambdaContextTypeRefCS
{ after(grammarAccess.getLambdaContextTypeRefCSRule()); }
	 EOF
;

// Rule LambdaContextTypeRefCS
ruleLambdaContextTypeRefCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLambdaContextTypeRefCSAccess().getOwnedPathNameAssignment()); }
(rule__LambdaContextTypeRefCS__OwnedPathNameAssignment)
{ after(grammarAccess.getLambdaContextTypeRefCSAccess().getOwnedPathNameAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOperationCS
entryRuleOperationCS
:
{ before(grammarAccess.getOperationCSRule()); }
	 ruleOperationCS
{ after(grammarAccess.getOperationCSRule()); }
	 EOF
;

// Rule OperationCS
ruleOperationCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getOperationCSAccess().getAlternatives()); }
(rule__OperationCS__Alternatives)
{ after(grammarAccess.getOperationCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLibOperationCS
entryRuleLibOperationCS
:
{ before(grammarAccess.getLibOperationCSRule()); }
	 ruleLibOperationCS
{ after(grammarAccess.getLibOperationCSRule()); }
	 EOF
;

// Rule LibOperationCS
ruleLibOperationCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLibOperationCSAccess().getGroup()); }
(rule__LibOperationCS__Group__0)
{ after(grammarAccess.getLibOperationCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLibOppositeCS
entryRuleLibOppositeCS
:
{ before(grammarAccess.getLibOppositeCSRule()); }
	 ruleLibOppositeCS
{ after(grammarAccess.getLibOppositeCSRule()); }
	 EOF
;

// Rule LibOppositeCS
ruleLibOppositeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLibOppositeCSAccess().getGroup()); }
(rule__LibOppositeCS__Group__0)
{ after(grammarAccess.getLibOppositeCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLibPackageCS
entryRuleLibPackageCS
:
{ before(grammarAccess.getLibPackageCSRule()); }
	 ruleLibPackageCS
{ after(grammarAccess.getLibPackageCSRule()); }
	 EOF
;

// Rule LibPackageCS
ruleLibPackageCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLibPackageCSAccess().getGroup()); }
(rule__LibPackageCS__Group__0)
{ after(grammarAccess.getLibPackageCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePackageCS
entryRulePackageCS
:
{ before(grammarAccess.getPackageCSRule()); }
	 rulePackageCS
{ after(grammarAccess.getPackageCSRule()); }
	 EOF
;

// Rule PackageCS
rulePackageCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPackageCSAccess().getGroup()); }
(rule__PackageCS__Group__0)
{ after(grammarAccess.getPackageCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleParameterCS
entryRuleParameterCS
:
{ before(grammarAccess.getParameterCSRule()); }
	 ruleParameterCS
{ after(grammarAccess.getParameterCSRule()); }
	 EOF
;

// Rule ParameterCS
ruleParameterCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getParameterCSAccess().getGroup()); }
(rule__ParameterCS__Group__0)
{ after(grammarAccess.getParameterCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLibPropertyCS
entryRuleLibPropertyCS
:
{ before(grammarAccess.getLibPropertyCSRule()); }
	 ruleLibPropertyCS
{ after(grammarAccess.getLibPropertyCSRule()); }
	 EOF
;

// Rule LibPropertyCS
ruleLibPropertyCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLibPropertyCSAccess().getGroup()); }
(rule__LibPropertyCS__Group__0)
{ after(grammarAccess.getLibPropertyCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePostCS
entryRulePostCS
:
{ before(grammarAccess.getPostCSRule()); }
	 rulePostCS
{ after(grammarAccess.getPostCSRule()); }
	 EOF
;

// Rule PostCS
rulePostCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPostCSAccess().getGroup()); }
(rule__PostCS__Group__0)
{ after(grammarAccess.getPostCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePreCS
entryRulePreCS
:
{ before(grammarAccess.getPreCSRule()); }
	 rulePreCS
{ after(grammarAccess.getPreCSRule()); }
	 EOF
;

// Rule PreCS
rulePreCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPreCSAccess().getGroup()); }
(rule__PreCS__Group__0)
{ after(grammarAccess.getPreCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePrecedenceCS
entryRulePrecedenceCS
:
{ before(grammarAccess.getPrecedenceCSRule()); }
	 rulePrecedenceCS
{ after(grammarAccess.getPrecedenceCSRule()); }
	 EOF
;

// Rule PrecedenceCS
rulePrecedenceCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrecedenceCSAccess().getGroup()); }
(rule__PrecedenceCS__Group__0)
{ after(grammarAccess.getPrecedenceCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSpecificationCS
entryRuleSpecificationCS
:
{ before(grammarAccess.getSpecificationCSRule()); }
	 ruleSpecificationCS
{ after(grammarAccess.getSpecificationCSRule()); }
	 EOF
;

// Rule SpecificationCS
ruleSpecificationCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSpecificationCSAccess().getOwnedExpressionAssignment()); }
(rule__SpecificationCS__OwnedExpressionAssignment)
{ after(grammarAccess.getSpecificationCSAccess().getOwnedExpressionAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypedMultiplicityRefCS
entryRuleTypedMultiplicityRefCS
:
{ before(grammarAccess.getTypedMultiplicityRefCSRule()); }
	 ruleTypedMultiplicityRefCS
{ after(grammarAccess.getTypedMultiplicityRefCSRule()); }
	 EOF
;

// Rule TypedMultiplicityRefCS
ruleTypedMultiplicityRefCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypedMultiplicityRefCSAccess().getGroup()); }
(rule__TypedMultiplicityRefCS__Group__0)
{ after(grammarAccess.getTypedMultiplicityRefCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypedRefCS
entryRuleTypedRefCS
:
{ before(grammarAccess.getTypedRefCSRule()); }
	 ruleTypedRefCS
{ after(grammarAccess.getTypedRefCSRule()); }
	 EOF
;

// Rule TypedRefCS
ruleTypedRefCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypedRefCSAccess().getAlternatives()); }
(rule__TypedRefCS__Alternatives)
{ after(grammarAccess.getTypedRefCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypedTypeRefCS
entryRuleTypedTypeRefCS
:
{ before(grammarAccess.getTypedTypeRefCSRule()); }
	 ruleTypedTypeRefCS
{ after(grammarAccess.getTypedTypeRefCSRule()); }
	 EOF
;

// Rule TypedTypeRefCS
ruleTypedTypeRefCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getAlternatives()); }
(rule__TypedTypeRefCS__Alternatives)
{ after(grammarAccess.getTypedTypeRefCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTuplePartCS
entryRuleTuplePartCS
:
{ before(grammarAccess.getTuplePartCSRule()); }
	 ruleTuplePartCS
{ after(grammarAccess.getTuplePartCSRule()); }
	 EOF
;

// Rule TuplePartCS
ruleTuplePartCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTuplePartCSAccess().getGroup()); }
(rule__TuplePartCS__Group__0)
{ after(grammarAccess.getTuplePartCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}





// Entry rule entryRuleEssentialOCLReservedKeyword
entryRuleEssentialOCLReservedKeyword
:
{ before(grammarAccess.getEssentialOCLReservedKeywordRule()); }
	 ruleEssentialOCLReservedKeyword
{ after(grammarAccess.getEssentialOCLReservedKeywordRule()); }
	 EOF
;

// Rule EssentialOCLReservedKeyword
ruleEssentialOCLReservedKeyword
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getAlternatives()); }
(rule__EssentialOCLReservedKeyword__Alternatives)
{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEssentialOCLUnaryOperatorName
entryRuleEssentialOCLUnaryOperatorName
:
{ before(grammarAccess.getEssentialOCLUnaryOperatorNameRule()); }
	 ruleEssentialOCLUnaryOperatorName
{ after(grammarAccess.getEssentialOCLUnaryOperatorNameRule()); }
	 EOF
;

// Rule EssentialOCLUnaryOperatorName
ruleEssentialOCLUnaryOperatorName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getAlternatives()); }
(rule__EssentialOCLUnaryOperatorName__Alternatives)
{ after(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEssentialOCLInfixOperatorName
entryRuleEssentialOCLInfixOperatorName
:
{ before(grammarAccess.getEssentialOCLInfixOperatorNameRule()); }
	 ruleEssentialOCLInfixOperatorName
{ after(grammarAccess.getEssentialOCLInfixOperatorNameRule()); }
	 EOF
;

// Rule EssentialOCLInfixOperatorName
ruleEssentialOCLInfixOperatorName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAlternatives()); }
(rule__EssentialOCLInfixOperatorName__Alternatives)
{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEssentialOCLNavigationOperatorName
entryRuleEssentialOCLNavigationOperatorName
:
{ before(grammarAccess.getEssentialOCLNavigationOperatorNameRule()); }
	 ruleEssentialOCLNavigationOperatorName
{ after(grammarAccess.getEssentialOCLNavigationOperatorNameRule()); }
	 EOF
;

// Rule EssentialOCLNavigationOperatorName
ruleEssentialOCLNavigationOperatorName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getAlternatives()); }
(rule__EssentialOCLNavigationOperatorName__Alternatives)
{ after(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleBinaryOperatorName
entryRuleBinaryOperatorName
:
{ before(grammarAccess.getBinaryOperatorNameRule()); }
	 ruleBinaryOperatorName
{ after(grammarAccess.getBinaryOperatorNameRule()); }
	 EOF
;

// Rule BinaryOperatorName
ruleBinaryOperatorName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getBinaryOperatorNameAccess().getAlternatives()); }
(rule__BinaryOperatorName__Alternatives)
{ after(grammarAccess.getBinaryOperatorNameAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleInfixOperatorName
entryRuleInfixOperatorName
:
{ before(grammarAccess.getInfixOperatorNameRule()); }
	 ruleInfixOperatorName
{ after(grammarAccess.getInfixOperatorNameRule()); }
	 EOF
;

// Rule InfixOperatorName
ruleInfixOperatorName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getInfixOperatorNameAccess().getEssentialOCLInfixOperatorNameParserRuleCall()); }
	ruleEssentialOCLInfixOperatorName
{ after(grammarAccess.getInfixOperatorNameAccess().getEssentialOCLInfixOperatorNameParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNavigationOperatorName
entryRuleNavigationOperatorName
:
{ before(grammarAccess.getNavigationOperatorNameRule()); }
	 ruleNavigationOperatorName
{ after(grammarAccess.getNavigationOperatorNameRule()); }
	 EOF
;

// Rule NavigationOperatorName
ruleNavigationOperatorName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNavigationOperatorNameAccess().getEssentialOCLNavigationOperatorNameParserRuleCall()); }
	ruleEssentialOCLNavigationOperatorName
{ after(grammarAccess.getNavigationOperatorNameAccess().getEssentialOCLNavigationOperatorNameParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUnaryOperatorName
entryRuleUnaryOperatorName
:
{ before(grammarAccess.getUnaryOperatorNameRule()); }
	 ruleUnaryOperatorName
{ after(grammarAccess.getUnaryOperatorNameRule()); }
	 EOF
;

// Rule UnaryOperatorName
ruleUnaryOperatorName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getUnaryOperatorNameAccess().getEssentialOCLUnaryOperatorNameParserRuleCall()); }
	ruleEssentialOCLUnaryOperatorName
{ after(grammarAccess.getUnaryOperatorNameAccess().getEssentialOCLUnaryOperatorNameParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEssentialOCLUnrestrictedName
entryRuleEssentialOCLUnrestrictedName
:
{ before(grammarAccess.getEssentialOCLUnrestrictedNameRule()); }
	 ruleEssentialOCLUnrestrictedName
{ after(grammarAccess.getEssentialOCLUnrestrictedNameRule()); }
	 EOF
;

// Rule EssentialOCLUnrestrictedName
ruleEssentialOCLUnrestrictedName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); }
	ruleIdentifier
{ after(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUnrestrictedName
entryRuleUnrestrictedName
:
{ before(grammarAccess.getUnrestrictedNameRule()); }
	 ruleUnrestrictedName
{ after(grammarAccess.getUnrestrictedNameRule()); }
	 EOF
;

// Rule UnrestrictedName
ruleUnrestrictedName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall()); }
	ruleEssentialOCLUnrestrictedName
{ after(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEssentialOCLUnreservedName
entryRuleEssentialOCLUnreservedName
:
{ before(grammarAccess.getEssentialOCLUnreservedNameRule()); }
	 ruleEssentialOCLUnreservedName
{ after(grammarAccess.getEssentialOCLUnreservedNameRule()); }
	 EOF
;

// Rule EssentialOCLUnreservedName
ruleEssentialOCLUnreservedName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEssentialOCLUnreservedNameAccess().getAlternatives()); }
(rule__EssentialOCLUnreservedName__Alternatives)
{ after(grammarAccess.getEssentialOCLUnreservedNameAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUnreservedName
entryRuleUnreservedName
:
{ before(grammarAccess.getUnreservedNameRule()); }
	 ruleUnreservedName
{ after(grammarAccess.getUnreservedNameRule()); }
	 EOF
;

// Rule UnreservedName
ruleUnreservedName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); }
	ruleEssentialOCLUnreservedName
{ after(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleURIPathNameCS
entryRuleURIPathNameCS
:
{ before(grammarAccess.getURIPathNameCSRule()); }
	 ruleURIPathNameCS
{ after(grammarAccess.getURIPathNameCSRule()); }
	 EOF
;

// Rule URIPathNameCS
ruleURIPathNameCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getURIPathNameCSAccess().getGroup()); }
(rule__URIPathNameCS__Group__0)
{ after(grammarAccess.getURIPathNameCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleURIFirstPathElementCS
entryRuleURIFirstPathElementCS
:
{ before(grammarAccess.getURIFirstPathElementCSRule()); }
	 ruleURIFirstPathElementCS
{ after(grammarAccess.getURIFirstPathElementCSRule()); }
	 EOF
;

// Rule URIFirstPathElementCS
ruleURIFirstPathElementCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getAlternatives()); }
(rule__URIFirstPathElementCS__Alternatives)
{ after(grammarAccess.getURIFirstPathElementCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}





// Entry rule entryRulePrimitiveTypeIdentifier
entryRulePrimitiveTypeIdentifier
:
{ before(grammarAccess.getPrimitiveTypeIdentifierRule()); }
	 rulePrimitiveTypeIdentifier
{ after(grammarAccess.getPrimitiveTypeIdentifierRule()); }
	 EOF
;

// Rule PrimitiveTypeIdentifier
rulePrimitiveTypeIdentifier
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getAlternatives()); }
(rule__PrimitiveTypeIdentifier__Alternatives)
{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePrimitiveTypeCS
entryRulePrimitiveTypeCS
:
{ before(grammarAccess.getPrimitiveTypeCSRule()); }
	 rulePrimitiveTypeCS
{ after(grammarAccess.getPrimitiveTypeCSRule()); }
	 EOF
;

// Rule PrimitiveTypeCS
rulePrimitiveTypeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrimitiveTypeCSAccess().getNameAssignment()); }
(rule__PrimitiveTypeCS__NameAssignment)
{ after(grammarAccess.getPrimitiveTypeCSAccess().getNameAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCollectionTypeIdentifier
entryRuleCollectionTypeIdentifier
:
{ before(grammarAccess.getCollectionTypeIdentifierRule()); }
	 ruleCollectionTypeIdentifier
{ after(grammarAccess.getCollectionTypeIdentifierRule()); }
	 EOF
;

// Rule CollectionTypeIdentifier
ruleCollectionTypeIdentifier
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCollectionTypeIdentifierAccess().getAlternatives()); }
(rule__CollectionTypeIdentifier__Alternatives)
{ after(grammarAccess.getCollectionTypeIdentifierAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCollectionTypeCS
entryRuleCollectionTypeCS
:
{ before(grammarAccess.getCollectionTypeCSRule()); }
	 ruleCollectionTypeCS
{ after(grammarAccess.getCollectionTypeCSRule()); }
	 EOF
;

// Rule CollectionTypeCS
ruleCollectionTypeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getGroup()); }
(rule__CollectionTypeCS__Group__0)
{ after(grammarAccess.getCollectionTypeCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMapTypeCS
entryRuleMapTypeCS
:
{ before(grammarAccess.getMapTypeCSRule()); }
	 ruleMapTypeCS
{ after(grammarAccess.getMapTypeCSRule()); }
	 EOF
;

// Rule MapTypeCS
ruleMapTypeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMapTypeCSAccess().getGroup()); }
(rule__MapTypeCS__Group__0)
{ after(grammarAccess.getMapTypeCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTupleTypeCS
entryRuleTupleTypeCS
:
{ before(grammarAccess.getTupleTypeCSRule()); }
	 ruleTupleTypeCS
{ after(grammarAccess.getTupleTypeCSRule()); }
	 EOF
;

// Rule TupleTypeCS
ruleTupleTypeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTupleTypeCSAccess().getGroup()); }
(rule__TupleTypeCS__Group__0)
{ after(grammarAccess.getTupleTypeCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCollectionLiteralExpCS
entryRuleCollectionLiteralExpCS
:
{ before(grammarAccess.getCollectionLiteralExpCSRule()); }
	 ruleCollectionLiteralExpCS
{ after(grammarAccess.getCollectionLiteralExpCSRule()); }
	 EOF
;

// Rule CollectionLiteralExpCS
ruleCollectionLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getGroup()); }
(rule__CollectionLiteralExpCS__Group__0)
{ after(grammarAccess.getCollectionLiteralExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCollectionLiteralPartCS
entryRuleCollectionLiteralPartCS
:
{ before(grammarAccess.getCollectionLiteralPartCSRule()); }
	 ruleCollectionLiteralPartCS
{ after(grammarAccess.getCollectionLiteralPartCSRule()); }
	 EOF
;

// Rule CollectionLiteralPartCS
ruleCollectionLiteralPartCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getAlternatives()); }
(rule__CollectionLiteralPartCS__Alternatives)
{ after(grammarAccess.getCollectionLiteralPartCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCollectionPatternCS
entryRuleCollectionPatternCS
:
{ before(grammarAccess.getCollectionPatternCSRule()); }
	 ruleCollectionPatternCS
{ after(grammarAccess.getCollectionPatternCSRule()); }
	 EOF
;

// Rule CollectionPatternCS
ruleCollectionPatternCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getGroup()); }
(rule__CollectionPatternCS__Group__0)
{ after(grammarAccess.getCollectionPatternCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleShadowPartCS
entryRuleShadowPartCS
:
{ before(grammarAccess.getShadowPartCSRule()); }
	 ruleShadowPartCS
{ after(grammarAccess.getShadowPartCSRule()); }
	 EOF
;

// Rule ShadowPartCS
ruleShadowPartCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getShadowPartCSAccess().getAlternatives()); }
(rule__ShadowPartCS__Alternatives)
{ after(grammarAccess.getShadowPartCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePatternExpCS
entryRulePatternExpCS
:
{ before(grammarAccess.getPatternExpCSRule()); }
	 rulePatternExpCS
{ after(grammarAccess.getPatternExpCSRule()); }
	 EOF
;

// Rule PatternExpCS
rulePatternExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPatternExpCSAccess().getGroup()); }
(rule__PatternExpCS__Group__0)
{ after(grammarAccess.getPatternExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLambdaLiteralExpCS
entryRuleLambdaLiteralExpCS
:
{ before(grammarAccess.getLambdaLiteralExpCSRule()); }
	 ruleLambdaLiteralExpCS
{ after(grammarAccess.getLambdaLiteralExpCSRule()); }
	 EOF
;

// Rule LambdaLiteralExpCS
ruleLambdaLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLambdaLiteralExpCSAccess().getGroup()); }
(rule__LambdaLiteralExpCS__Group__0)
{ after(grammarAccess.getLambdaLiteralExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMapLiteralExpCS
entryRuleMapLiteralExpCS
:
{ before(grammarAccess.getMapLiteralExpCSRule()); }
	 ruleMapLiteralExpCS
{ after(grammarAccess.getMapLiteralExpCSRule()); }
	 EOF
;

// Rule MapLiteralExpCS
ruleMapLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getGroup()); }
(rule__MapLiteralExpCS__Group__0)
{ after(grammarAccess.getMapLiteralExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMapLiteralPartCS
entryRuleMapLiteralPartCS
:
{ before(grammarAccess.getMapLiteralPartCSRule()); }
	 ruleMapLiteralPartCS
{ after(grammarAccess.getMapLiteralPartCSRule()); }
	 EOF
;

// Rule MapLiteralPartCS
ruleMapLiteralPartCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMapLiteralPartCSAccess().getGroup()); }
(rule__MapLiteralPartCS__Group__0)
{ after(grammarAccess.getMapLiteralPartCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePrimitiveLiteralExpCS
entryRulePrimitiveLiteralExpCS
:
{ before(grammarAccess.getPrimitiveLiteralExpCSRule()); }
	 rulePrimitiveLiteralExpCS
{ after(grammarAccess.getPrimitiveLiteralExpCSRule()); }
	 EOF
;

// Rule PrimitiveLiteralExpCS
rulePrimitiveLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrimitiveLiteralExpCSAccess().getAlternatives()); }
(rule__PrimitiveLiteralExpCS__Alternatives)
{ after(grammarAccess.getPrimitiveLiteralExpCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTupleLiteralExpCS
entryRuleTupleLiteralExpCS
:
{ before(grammarAccess.getTupleLiteralExpCSRule()); }
	 ruleTupleLiteralExpCS
{ after(grammarAccess.getTupleLiteralExpCSRule()); }
	 EOF
;

// Rule TupleLiteralExpCS
ruleTupleLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getGroup()); }
(rule__TupleLiteralExpCS__Group__0)
{ after(grammarAccess.getTupleLiteralExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTupleLiteralPartCS
entryRuleTupleLiteralPartCS
:
{ before(grammarAccess.getTupleLiteralPartCSRule()); }
	 ruleTupleLiteralPartCS
{ after(grammarAccess.getTupleLiteralPartCSRule()); }
	 EOF
;

// Rule TupleLiteralPartCS
ruleTupleLiteralPartCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getGroup()); }
(rule__TupleLiteralPartCS__Group__0)
{ after(grammarAccess.getTupleLiteralPartCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNumberLiteralExpCS
entryRuleNumberLiteralExpCS
:
{ before(grammarAccess.getNumberLiteralExpCSRule()); }
	 ruleNumberLiteralExpCS
{ after(grammarAccess.getNumberLiteralExpCSRule()); }
	 EOF
;

// Rule NumberLiteralExpCS
ruleNumberLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNumberLiteralExpCSAccess().getSymbolAssignment()); }
(rule__NumberLiteralExpCS__SymbolAssignment)
{ after(grammarAccess.getNumberLiteralExpCSAccess().getSymbolAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStringLiteralExpCS
entryRuleStringLiteralExpCS
:
{ before(grammarAccess.getStringLiteralExpCSRule()); }
	 ruleStringLiteralExpCS
{ after(grammarAccess.getStringLiteralExpCSRule()); }
	 EOF
;

// Rule StringLiteralExpCS
ruleStringLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
(
{ before(grammarAccess.getStringLiteralExpCSAccess().getSegmentsAssignment()); }
(rule__StringLiteralExpCS__SegmentsAssignment)
{ after(grammarAccess.getStringLiteralExpCSAccess().getSegmentsAssignment()); }
)
(
{ before(grammarAccess.getStringLiteralExpCSAccess().getSegmentsAssignment()); }
(rule__StringLiteralExpCS__SegmentsAssignment)*
{ after(grammarAccess.getStringLiteralExpCSAccess().getSegmentsAssignment()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleBooleanLiteralExpCS
entryRuleBooleanLiteralExpCS
:
{ before(grammarAccess.getBooleanLiteralExpCSRule()); }
	 ruleBooleanLiteralExpCS
{ after(grammarAccess.getBooleanLiteralExpCSRule()); }
	 EOF
;

// Rule BooleanLiteralExpCS
ruleBooleanLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getBooleanLiteralExpCSAccess().getAlternatives()); }
(rule__BooleanLiteralExpCS__Alternatives)
{ after(grammarAccess.getBooleanLiteralExpCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUnlimitedNaturalLiteralExpCS
entryRuleUnlimitedNaturalLiteralExpCS
:
{ before(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); }
	 ruleUnlimitedNaturalLiteralExpCS
{ after(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); }
	 EOF
;

// Rule UnlimitedNaturalLiteralExpCS
ruleUnlimitedNaturalLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getGroup()); }
(rule__UnlimitedNaturalLiteralExpCS__Group__0)
{ after(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleInvalidLiteralExpCS
entryRuleInvalidLiteralExpCS
:
{ before(grammarAccess.getInvalidLiteralExpCSRule()); }
	 ruleInvalidLiteralExpCS
{ after(grammarAccess.getInvalidLiteralExpCSRule()); }
	 EOF
;

// Rule InvalidLiteralExpCS
ruleInvalidLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getInvalidLiteralExpCSAccess().getGroup()); }
(rule__InvalidLiteralExpCS__Group__0)
{ after(grammarAccess.getInvalidLiteralExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNullLiteralExpCS
entryRuleNullLiteralExpCS
:
{ before(grammarAccess.getNullLiteralExpCSRule()); }
	 ruleNullLiteralExpCS
{ after(grammarAccess.getNullLiteralExpCSRule()); }
	 EOF
;

// Rule NullLiteralExpCS
ruleNullLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNullLiteralExpCSAccess().getGroup()); }
(rule__NullLiteralExpCS__Group__0)
{ after(grammarAccess.getNullLiteralExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeLiteralCS
entryRuleTypeLiteralCS
:
{ before(grammarAccess.getTypeLiteralCSRule()); }
	 ruleTypeLiteralCS
{ after(grammarAccess.getTypeLiteralCSRule()); }
	 EOF
;

// Rule TypeLiteralCS
ruleTypeLiteralCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeLiteralCSAccess().getAlternatives()); }
(rule__TypeLiteralCS__Alternatives)
{ after(grammarAccess.getTypeLiteralCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeLiteralWithMultiplicityCS
entryRuleTypeLiteralWithMultiplicityCS
:
{ before(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); }
	 ruleTypeLiteralWithMultiplicityCS
{ after(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); }
	 EOF
;

// Rule TypeLiteralWithMultiplicityCS
ruleTypeLiteralWithMultiplicityCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getGroup()); }
(rule__TypeLiteralWithMultiplicityCS__Group__0)
{ after(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeLiteralExpCS
entryRuleTypeLiteralExpCS
:
{ before(grammarAccess.getTypeLiteralExpCSRule()); }
	 ruleTypeLiteralExpCS
{ after(grammarAccess.getTypeLiteralExpCSRule()); }
	 EOF
;

// Rule TypeLiteralExpCS
ruleTypeLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeAssignment()); }
(rule__TypeLiteralExpCS__OwnedTypeAssignment)
{ after(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeNameExpCS
entryRuleTypeNameExpCS
:
{ before(grammarAccess.getTypeNameExpCSRule()); }
	 ruleTypeNameExpCS
{ after(grammarAccess.getTypeNameExpCSRule()); }
	 EOF
;

// Rule TypeNameExpCS
ruleTypeNameExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getGroup()); }
(rule__TypeNameExpCS__Group__0)
{ after(grammarAccess.getTypeNameExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeExpWithoutMultiplicityCS
entryRuleTypeExpWithoutMultiplicityCS
:
{ before(grammarAccess.getTypeExpWithoutMultiplicityCSRule()); }
	 ruleTypeExpWithoutMultiplicityCS
{ after(grammarAccess.getTypeExpWithoutMultiplicityCSRule()); }
	 EOF
;

// Rule TypeExpWithoutMultiplicityCS
ruleTypeExpWithoutMultiplicityCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getAlternatives()); }
(rule__TypeExpWithoutMultiplicityCS__Alternatives)
{ after(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeExpCS
entryRuleTypeExpCS
:
{ before(grammarAccess.getTypeExpCSRule()); }
	 ruleTypeExpCS
{ after(grammarAccess.getTypeExpCSRule()); }
	 EOF
;

// Rule TypeExpCS
ruleTypeExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeExpCSAccess().getGroup()); }
(rule__TypeExpCS__Group__0)
{ after(grammarAccess.getTypeExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleExpCS
entryRuleExpCS
:
{ before(grammarAccess.getExpCSRule()); }
	 ruleExpCS
{ after(grammarAccess.getExpCSRule()); }
	 EOF
;

// Rule ExpCS
ruleExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getExpCSAccess().getAlternatives()); }
(rule__ExpCS__Alternatives)
{ after(grammarAccess.getExpCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePrefixedLetExpCS
entryRulePrefixedLetExpCS
:
{ before(grammarAccess.getPrefixedLetExpCSRule()); }
	 rulePrefixedLetExpCS
{ after(grammarAccess.getPrefixedLetExpCSRule()); }
	 EOF
;

// Rule PrefixedLetExpCS
rulePrefixedLetExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getAlternatives()); }
(rule__PrefixedLetExpCS__Alternatives)
{ after(grammarAccess.getPrefixedLetExpCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePrefixedPrimaryExpCS
entryRulePrefixedPrimaryExpCS
:
{ before(grammarAccess.getPrefixedPrimaryExpCSRule()); }
	 rulePrefixedPrimaryExpCS
{ after(grammarAccess.getPrefixedPrimaryExpCSRule()); }
	 EOF
;

// Rule PrefixedPrimaryExpCS
rulePrefixedPrimaryExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getAlternatives()); }
(rule__PrefixedPrimaryExpCS__Alternatives)
{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePrimaryExpCS
entryRulePrimaryExpCS
:
{ before(grammarAccess.getPrimaryExpCSRule()); }
	 rulePrimaryExpCS
{ after(grammarAccess.getPrimaryExpCSRule()); }
	 EOF
;

// Rule PrimaryExpCS
rulePrimaryExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrimaryExpCSAccess().getAlternatives()); }
(rule__PrimaryExpCS__Alternatives)
{ after(grammarAccess.getPrimaryExpCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNameExpCS
entryRuleNameExpCS
:
{ before(grammarAccess.getNameExpCSRule()); }
	 ruleNameExpCS
{ after(grammarAccess.getNameExpCSRule()); }
	 EOF
;

// Rule NameExpCS
ruleNameExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNameExpCSAccess().getGroup()); }
(rule__NameExpCS__Group__0)
{ after(grammarAccess.getNameExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCurlyBracketedClauseCS
entryRuleCurlyBracketedClauseCS
:
{ before(grammarAccess.getCurlyBracketedClauseCSRule()); }
	 ruleCurlyBracketedClauseCS
{ after(grammarAccess.getCurlyBracketedClauseCSRule()); }
	 EOF
;

// Rule CurlyBracketedClauseCS
ruleCurlyBracketedClauseCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup()); }
(rule__CurlyBracketedClauseCS__Group__0)
{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRoundBracketedClauseCS
entryRuleRoundBracketedClauseCS
:
{ before(grammarAccess.getRoundBracketedClauseCSRule()); }
	 ruleRoundBracketedClauseCS
{ after(grammarAccess.getRoundBracketedClauseCSRule()); }
	 EOF
;

// Rule RoundBracketedClauseCS
ruleRoundBracketedClauseCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getGroup()); }
(rule__RoundBracketedClauseCS__Group__0)
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSquareBracketedClauseCS
entryRuleSquareBracketedClauseCS
:
{ before(grammarAccess.getSquareBracketedClauseCSRule()); }
	 ruleSquareBracketedClauseCS
{ after(grammarAccess.getSquareBracketedClauseCSRule()); }
	 EOF
;

// Rule SquareBracketedClauseCS
ruleSquareBracketedClauseCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getGroup()); }
(rule__SquareBracketedClauseCS__Group__0)
{ after(grammarAccess.getSquareBracketedClauseCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNavigatingArgCS
entryRuleNavigatingArgCS
:
{ before(grammarAccess.getNavigatingArgCSRule()); }
	 ruleNavigatingArgCS
{ after(grammarAccess.getNavigatingArgCSRule()); }
	 EOF
;

// Rule NavigatingArgCS
ruleNavigatingArgCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getAlternatives()); }
(rule__NavigatingArgCS__Alternatives)
{ after(grammarAccess.getNavigatingArgCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNavigatingBarArgCS
entryRuleNavigatingBarArgCS
:
{ before(grammarAccess.getNavigatingBarArgCSRule()); }
	 ruleNavigatingBarArgCS
{ after(grammarAccess.getNavigatingBarArgCSRule()); }
	 EOF
;

// Rule NavigatingBarArgCS
ruleNavigatingBarArgCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getGroup()); }
(rule__NavigatingBarArgCS__Group__0)
{ after(grammarAccess.getNavigatingBarArgCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNavigatingCommaArgCS
entryRuleNavigatingCommaArgCS
:
{ before(grammarAccess.getNavigatingCommaArgCSRule()); }
	 ruleNavigatingCommaArgCS
{ after(grammarAccess.getNavigatingCommaArgCSRule()); }
	 EOF
;

// Rule NavigatingCommaArgCS
ruleNavigatingCommaArgCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getGroup()); }
(rule__NavigatingCommaArgCS__Group__0)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNavigatingSemiArgCS
entryRuleNavigatingSemiArgCS
:
{ before(grammarAccess.getNavigatingSemiArgCSRule()); }
	 ruleNavigatingSemiArgCS
{ after(grammarAccess.getNavigatingSemiArgCSRule()); }
	 EOF
;

// Rule NavigatingSemiArgCS
ruleNavigatingSemiArgCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getGroup()); }
(rule__NavigatingSemiArgCS__Group__0)
{ after(grammarAccess.getNavigatingSemiArgCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNavigatingArgExpCS
entryRuleNavigatingArgExpCS
:
{ before(grammarAccess.getNavigatingArgExpCSRule()); }
	 ruleNavigatingArgExpCS
{ after(grammarAccess.getNavigatingArgExpCSRule()); }
	 EOF
;

// Rule NavigatingArgExpCS
ruleNavigatingArgExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); }
	ruleExpCS
{ after(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCoIteratorVariableCS
entryRuleCoIteratorVariableCS
:
{ before(grammarAccess.getCoIteratorVariableCSRule()); }
	 ruleCoIteratorVariableCS
{ after(grammarAccess.getCoIteratorVariableCSRule()); }
	 EOF
;

// Rule CoIteratorVariableCS
ruleCoIteratorVariableCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCoIteratorVariableCSAccess().getGroup()); }
(rule__CoIteratorVariableCS__Group__0)
{ after(grammarAccess.getCoIteratorVariableCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleIfExpCS
entryRuleIfExpCS
:
{ before(grammarAccess.getIfExpCSRule()); }
	 ruleIfExpCS
{ after(grammarAccess.getIfExpCSRule()); }
	 EOF
;

// Rule IfExpCS
ruleIfExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getIfExpCSAccess().getGroup()); }
(rule__IfExpCS__Group__0)
{ after(grammarAccess.getIfExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleElseIfThenExpCS
entryRuleElseIfThenExpCS
:
{ before(grammarAccess.getElseIfThenExpCSRule()); }
	 ruleElseIfThenExpCS
{ after(grammarAccess.getElseIfThenExpCSRule()); }
	 EOF
;

// Rule ElseIfThenExpCS
ruleElseIfThenExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getElseIfThenExpCSAccess().getGroup()); }
(rule__ElseIfThenExpCS__Group__0)
{ after(grammarAccess.getElseIfThenExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLetExpCS
entryRuleLetExpCS
:
{ before(grammarAccess.getLetExpCSRule()); }
	 ruleLetExpCS
{ after(grammarAccess.getLetExpCSRule()); }
	 EOF
;

// Rule LetExpCS
ruleLetExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLetExpCSAccess().getGroup()); }
(rule__LetExpCS__Group__0)
{ after(grammarAccess.getLetExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLetVariableCS
entryRuleLetVariableCS
:
{ before(grammarAccess.getLetVariableCSRule()); }
	 ruleLetVariableCS
{ after(grammarAccess.getLetVariableCSRule()); }
	 EOF
;

// Rule LetVariableCS
ruleLetVariableCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLetVariableCSAccess().getGroup()); }
(rule__LetVariableCS__Group__0)
{ after(grammarAccess.getLetVariableCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNestedExpCS
entryRuleNestedExpCS
:
{ before(grammarAccess.getNestedExpCSRule()); }
	 ruleNestedExpCS
{ after(grammarAccess.getNestedExpCSRule()); }
	 EOF
;

// Rule NestedExpCS
ruleNestedExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNestedExpCSAccess().getGroup()); }
(rule__NestedExpCS__Group__0)
{ after(grammarAccess.getNestedExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSelfExpCS
entryRuleSelfExpCS
:
{ before(grammarAccess.getSelfExpCSRule()); }
	 ruleSelfExpCS
{ after(grammarAccess.getSelfExpCSRule()); }
	 EOF
;

// Rule SelfExpCS
ruleSelfExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSelfExpCSAccess().getGroup()); }
(rule__SelfExpCS__Group__0)
{ after(grammarAccess.getSelfExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMultiplicityBoundsCS
entryRuleMultiplicityBoundsCS
:
{ before(grammarAccess.getMultiplicityBoundsCSRule()); }
	 ruleMultiplicityBoundsCS
{ after(grammarAccess.getMultiplicityBoundsCSRule()); }
	 EOF
;

// Rule MultiplicityBoundsCS
ruleMultiplicityBoundsCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMultiplicityBoundsCSAccess().getGroup()); }
(rule__MultiplicityBoundsCS__Group__0)
{ after(grammarAccess.getMultiplicityBoundsCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMultiplicityCS
entryRuleMultiplicityCS
:
{ before(grammarAccess.getMultiplicityCSRule()); }
	 ruleMultiplicityCS
{ after(grammarAccess.getMultiplicityCSRule()); }
	 EOF
;

// Rule MultiplicityCS
ruleMultiplicityCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMultiplicityCSAccess().getGroup()); }
(rule__MultiplicityCS__Group__0)
{ after(grammarAccess.getMultiplicityCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMultiplicityStringCS
entryRuleMultiplicityStringCS
:
{ before(grammarAccess.getMultiplicityStringCSRule()); }
	 ruleMultiplicityStringCS
{ after(grammarAccess.getMultiplicityStringCSRule()); }
	 EOF
;

// Rule MultiplicityStringCS
ruleMultiplicityStringCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAssignment()); }
(rule__MultiplicityStringCS__StringBoundsAssignment)
{ after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePathNameCS
entryRulePathNameCS
:
{ before(grammarAccess.getPathNameCSRule()); }
	 rulePathNameCS
{ after(grammarAccess.getPathNameCSRule()); }
	 EOF
;

// Rule PathNameCS
rulePathNameCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPathNameCSAccess().getGroup()); }
(rule__PathNameCS__Group__0)
{ after(grammarAccess.getPathNameCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}





// Entry rule entryRuleFirstPathElementCS
entryRuleFirstPathElementCS
:
{ before(grammarAccess.getFirstPathElementCSRule()); }
	 ruleFirstPathElementCS
{ after(grammarAccess.getFirstPathElementCSRule()); }
	 EOF
;

// Rule FirstPathElementCS
ruleFirstPathElementCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getFirstPathElementCSAccess().getReferredElementAssignment()); }
(rule__FirstPathElementCS__ReferredElementAssignment)
{ after(grammarAccess.getFirstPathElementCSAccess().getReferredElementAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNextPathElementCS
entryRuleNextPathElementCS
:
{ before(grammarAccess.getNextPathElementCSRule()); }
	 ruleNextPathElementCS
{ after(grammarAccess.getNextPathElementCSRule()); }
	 EOF
;

// Rule NextPathElementCS
ruleNextPathElementCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNextPathElementCSAccess().getReferredElementAssignment()); }
(rule__NextPathElementCS__ReferredElementAssignment)
{ after(grammarAccess.getNextPathElementCSAccess().getReferredElementAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTemplateBindingCS
entryRuleTemplateBindingCS
:
{ before(grammarAccess.getTemplateBindingCSRule()); }
	 ruleTemplateBindingCS
{ after(grammarAccess.getTemplateBindingCSRule()); }
	 EOF
;

// Rule TemplateBindingCS
ruleTemplateBindingCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getGroup()); }
(rule__TemplateBindingCS__Group__0)
{ after(grammarAccess.getTemplateBindingCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTemplateParameterSubstitutionCS
entryRuleTemplateParameterSubstitutionCS
:
{ before(grammarAccess.getTemplateParameterSubstitutionCSRule()); }
	 ruleTemplateParameterSubstitutionCS
{ after(grammarAccess.getTemplateParameterSubstitutionCSRule()); }
	 EOF
;

// Rule TemplateParameterSubstitutionCS
ruleTemplateParameterSubstitutionCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterAssignment()); }
(rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment)
{ after(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTemplateSignatureCS
entryRuleTemplateSignatureCS
:
{ before(grammarAccess.getTemplateSignatureCSRule()); }
	 ruleTemplateSignatureCS
{ after(grammarAccess.getTemplateSignatureCSRule()); }
	 EOF
;

// Rule TemplateSignatureCS
ruleTemplateSignatureCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getGroup()); }
(rule__TemplateSignatureCS__Group__0)
{ after(grammarAccess.getTemplateSignatureCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeParameterCS
entryRuleTypeParameterCS
:
{ before(grammarAccess.getTypeParameterCSRule()); }
	 ruleTypeParameterCS
{ after(grammarAccess.getTypeParameterCSRule()); }
	 EOF
;

// Rule TypeParameterCS
ruleTypeParameterCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeParameterCSAccess().getGroup()); }
(rule__TypeParameterCS__Group__0)
{ after(grammarAccess.getTypeParameterCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeRefCS
entryRuleTypeRefCS
:
{ before(grammarAccess.getTypeRefCSRule()); }
	 ruleTypeRefCS
{ after(grammarAccess.getTypeRefCSRule()); }
	 EOF
;

// Rule TypeRefCS
ruleTypeRefCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeRefCSAccess().getAlternatives()); }
(rule__TypeRefCS__Alternatives)
{ after(grammarAccess.getTypeRefCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleWildcardTypeRefCS
entryRuleWildcardTypeRefCS
:
{ before(grammarAccess.getWildcardTypeRefCSRule()); }
	 ruleWildcardTypeRefCS
{ after(grammarAccess.getWildcardTypeRefCSRule()); }
	 EOF
;

// Rule WildcardTypeRefCS
ruleWildcardTypeRefCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getWildcardTypeRefCSAccess().getGroup()); }
(rule__WildcardTypeRefCS__Group__0)
{ after(grammarAccess.getWildcardTypeRefCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleID
entryRuleID
:
{ before(grammarAccess.getIDRule()); }
	 ruleID
{ after(grammarAccess.getIDRule()); }
	 EOF
;

// Rule ID
ruleID
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getIDAccess().getAlternatives()); }
(rule__ID__Alternatives)
{ after(grammarAccess.getIDAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLOWER
entryRuleLOWER
:
{ before(grammarAccess.getLOWERRule()); }
	 ruleLOWER
{ after(grammarAccess.getLOWERRule()); }
	 EOF
;

// Rule LOWER
ruleLOWER
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); }
	RULE_INT
{ after(grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNUMBER_LITERAL
entryRuleNUMBER_LITERAL
:
{ before(grammarAccess.getNUMBER_LITERALRule()); }
	 ruleNUMBER_LITERAL
{ after(grammarAccess.getNUMBER_LITERALRule()); }
	 EOF
;

// Rule NUMBER_LITERAL
ruleNUMBER_LITERAL
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall()); }
	RULE_INT
{ after(grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStringLiteral
entryRuleStringLiteral
:
{ before(grammarAccess.getStringLiteralRule()); }
	 ruleStringLiteral
{ after(grammarAccess.getStringLiteralRule()); }
	 EOF
;

// Rule StringLiteral
ruleStringLiteral
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStringLiteralAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall()); }
	RULE_SINGLE_QUOTED_STRING
{ after(grammarAccess.getStringLiteralAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUPPER
entryRuleUPPER
:
{ before(grammarAccess.getUPPERRule()); }
	 ruleUPPER
{ after(grammarAccess.getUPPERRule()); }
	 EOF
;

// Rule UPPER
ruleUPPER
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getUPPERAccess().getAlternatives()); }
(rule__UPPER__Alternatives)
{ after(grammarAccess.getUPPERAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleURI
entryRuleURI
:
{ before(grammarAccess.getURIRule()); }
	 ruleURI
{ after(grammarAccess.getURIRule()); }
	 EOF
;

// Rule URI
ruleURI
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getURIAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall()); }
	RULE_SINGLE_QUOTED_STRING
{ after(grammarAccess.getURIAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__Identifier__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIdentifierAccess().getIDParserRuleCall_0()); }
	ruleID
{ after(grammarAccess.getIdentifierAccess().getIDParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getIdentifierAccess().getRestrictedKeywordsParserRuleCall_1()); }
	ruleRestrictedKeywords
{ after(grammarAccess.getIdentifierAccess().getRestrictedKeywordsParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictedKeywords__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRestrictedKeywordsAccess().getAbstractKeyword_0()); }

	'abstract'

{ after(grammarAccess.getRestrictedKeywordsAccess().getAbstractKeyword_0()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getAnnotationKeyword_1()); }

	'annotation'

{ after(grammarAccess.getRestrictedKeywordsAccess().getAnnotationKeyword_1()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getConformsToKeyword_2()); }

	'conformsTo'

{ after(grammarAccess.getRestrictedKeywordsAccess().getConformsToKeyword_2()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getDocumentationKeyword_3()); }

	'documentation'

{ after(grammarAccess.getRestrictedKeywordsAccess().getDocumentationKeyword_3()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getExtendsKeyword_4()); }

	'extends'

{ after(grammarAccess.getRestrictedKeywordsAccess().getExtendsKeyword_4()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getImportKeyword_5()); }

	'import'

{ after(grammarAccess.getRestrictedKeywordsAccess().getImportKeyword_5()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getInvKeyword_6()); }

	'inv'

{ after(grammarAccess.getRestrictedKeywordsAccess().getInvKeyword_6()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getInvalidatingKeyword_7()); }

	'invalidating'

{ after(grammarAccess.getRestrictedKeywordsAccess().getInvalidatingKeyword_7()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getIterationKeyword_8()); }

	'iteration'

{ after(grammarAccess.getRestrictedKeywordsAccess().getIterationKeyword_8()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getLeftKeyword_9()); }

	'left'

{ after(grammarAccess.getRestrictedKeywordsAccess().getLeftKeyword_9()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getLibraryKeyword_10()); }

	'library'

{ after(grammarAccess.getRestrictedKeywordsAccess().getLibraryKeyword_10()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getOperationKeyword_11()); }

	'operation'

{ after(grammarAccess.getRestrictedKeywordsAccess().getOperationKeyword_11()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getOppositeKeyword_12()); }

	'opposite'

{ after(grammarAccess.getRestrictedKeywordsAccess().getOppositeKeyword_12()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getPackageKeyword_13()); }

	'package'

{ after(grammarAccess.getRestrictedKeywordsAccess().getPackageKeyword_13()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getPostKeyword_14()); }

	'post'

{ after(grammarAccess.getRestrictedKeywordsAccess().getPostKeyword_14()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getPreKeyword_15()); }

	'pre'

{ after(grammarAccess.getRestrictedKeywordsAccess().getPreKeyword_15()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getPrecedenceKeyword_16()); }

	'precedence'

{ after(grammarAccess.getRestrictedKeywordsAccess().getPrecedenceKeyword_16()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getPropertyKeyword_17()); }

	'property'

{ after(grammarAccess.getRestrictedKeywordsAccess().getPropertyKeyword_17()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getRightKeyword_18()); }

	'right'

{ after(grammarAccess.getRestrictedKeywordsAccess().getRightKeyword_18()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getStaticKeyword_19()); }

	'static'

{ after(grammarAccess.getRestrictedKeywordsAccess().getStaticKeyword_19()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getTypeKeyword_20()); }

	'type'

{ after(grammarAccess.getRestrictedKeywordsAccess().getTypeKeyword_20()); }
)

    |(
{ before(grammarAccess.getRestrictedKeywordsAccess().getValidatingKeyword_21()); }

	'validating'

{ after(grammarAccess.getRestrictedKeywordsAccess().getValidatingKeyword_21()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Name__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameAccess().getIdentifierParserRuleCall_0()); }
	ruleIdentifier
{ after(grammarAccess.getNameAccess().getIdentifierParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getNameAccess().getDOUBLE_QUOTED_STRINGTerminalRuleCall_1()); }
	RULE_DOUBLE_QUOTED_STRING
{ after(grammarAccess.getNameAccess().getDOUBLE_QUOTED_STRINGTerminalRuleCall_1()); }
)

    |(
{ before(grammarAccess.getNameAccess().getEssentialOCLReservedKeywordParserRuleCall_2()); }
	ruleEssentialOCLReservedKeyword
{ after(grammarAccess.getNameAccess().getEssentialOCLReservedKeywordParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getNameAccess().getPrimitiveTypeIdentifierParserRuleCall_3()); }
	rulePrimitiveTypeIdentifier
{ after(grammarAccess.getNameAccess().getPrimitiveTypeIdentifierParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getNameAccess().getCollectionTypeIdentifierParserRuleCall_4()); }
	ruleCollectionTypeIdentifier
{ after(grammarAccess.getNameAccess().getCollectionTypeIdentifierParserRuleCall_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnyName__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnyNameAccess().getNameParserRuleCall_0()); }
	ruleName
{ after(grammarAccess.getAnyNameAccess().getNameParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getAnyNameAccess().getLambdaKeyword_1()); }

	'Lambda'

{ after(grammarAccess.getAnyNameAccess().getLambdaKeyword_1()); }
)

    |(
{ before(grammarAccess.getAnyNameAccess().getMapKeyword_2()); }

	'Map'

{ after(grammarAccess.getAnyNameAccess().getMapKeyword_2()); }
)

    |(
{ before(grammarAccess.getAnyNameAccess().getTupleKeyword_3()); }

	'Tuple'

{ after(grammarAccess.getAnyNameAccess().getTupleKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__NameAlternatives_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getNameIdentifierParserRuleCall_1_0_0()); }
	ruleIdentifier
{ after(grammarAccess.getAnnotationCSAccess().getNameIdentifierParserRuleCall_1_0_0()); }
)

    |(
{ before(grammarAccess.getAnnotationCSAccess().getNameSINGLE_QUOTED_STRINGTerminalRuleCall_1_0_1()); }
	RULE_SINGLE_QUOTED_STRING
{ after(grammarAccess.getAnnotationCSAccess().getNameSINGLE_QUOTED_STRINGTerminalRuleCall_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Alternatives_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getGroup_3_0()); }
(rule__AnnotationCS__Group_3_0__0)
{ after(grammarAccess.getAnnotationCSAccess().getGroup_3_0()); }
)

    |(
{ before(grammarAccess.getAnnotationCSAccess().getSemicolonKeyword_3_1()); }

	';'

{ after(grammarAccess.getAnnotationCSAccess().getSemicolonKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationElementCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationElementCSAccess().getAnnotationCSParserRuleCall_0()); }
	ruleAnnotationCS
{ after(grammarAccess.getAnnotationElementCSAccess().getAnnotationCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getAnnotationElementCSAccess().getDocumentationCSParserRuleCall_1()); }
	ruleDocumentationCS
{ after(grammarAccess.getAnnotationElementCSAccess().getDocumentationCSParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Alternatives_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getOwnedOperationsAssignment_8_0()); }
(rule__LibClassCS__OwnedOperationsAssignment_8_0)
{ after(grammarAccess.getLibClassCSAccess().getOwnedOperationsAssignment_8_0()); }
)

    |(
{ before(grammarAccess.getLibClassCSAccess().getOwnedPropertiesAssignment_8_1()); }
(rule__LibClassCS__OwnedPropertiesAssignment_8_1)
{ after(grammarAccess.getLibClassCSAccess().getOwnedPropertiesAssignment_8_1()); }
)

    |(
{ before(grammarAccess.getLibClassCSAccess().getOwnedConstraintsAssignment_8_2()); }
(rule__LibClassCS__OwnedConstraintsAssignment_8_2)
{ after(grammarAccess.getLibClassCSAccess().getOwnedConstraintsAssignment_8_2()); }
)

    |(
{ before(grammarAccess.getLibClassCSAccess().getOwnedAnnotationsAssignment_8_3()); }
(rule__LibClassCS__OwnedAnnotationsAssignment_8_3)
{ after(grammarAccess.getLibClassCSAccess().getOwnedAnnotationsAssignment_8_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DetailCS__NameAlternatives_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDetailCSAccess().getNameNameParserRuleCall_0_0_0()); }
	ruleName
{ after(grammarAccess.getDetailCSAccess().getNameNameParserRuleCall_0_0_0()); }
)

    |(
{ before(grammarAccess.getDetailCSAccess().getNameSINGLE_QUOTED_STRINGTerminalRuleCall_0_0_1()); }
	RULE_SINGLE_QUOTED_STRING
{ after(grammarAccess.getDetailCSAccess().getNameSINGLE_QUOTED_STRINGTerminalRuleCall_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DetailCS__ValuesAlternatives_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDetailCSAccess().getValuesSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_0()); }
	RULE_SINGLE_QUOTED_STRING
{ after(grammarAccess.getDetailCSAccess().getValuesSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_0()); }
)

    |(
{ before(grammarAccess.getDetailCSAccess().getValuesML_SINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1()); }
	RULE_ML_SINGLE_QUOTED_STRING
{ after(grammarAccess.getDetailCSAccess().getValuesML_SINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Alternatives_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getGroup_7_0()); }
(rule__LibCoercionCS__Group_7_0__0)
{ after(grammarAccess.getLibCoercionCSAccess().getGroup_7_0()); }
)

    |(
{ before(grammarAccess.getLibCoercionCSAccess().getSemicolonKeyword_7_1()); }

	';'

{ after(grammarAccess.getLibCoercionCSAccess().getSemicolonKeyword_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Alternatives_7_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getOwnedAnnotationsAssignment_7_0_1_0()); }
(rule__LibCoercionCS__OwnedAnnotationsAssignment_7_0_1_0)
{ after(grammarAccess.getLibCoercionCSAccess().getOwnedAnnotationsAssignment_7_0_1_0()); }
)

    |(
{ before(grammarAccess.getLibCoercionCSAccess().getOwnedPreconditionsAssignment_7_0_1_1()); }
(rule__LibCoercionCS__OwnedPreconditionsAssignment_7_0_1_1)
{ after(grammarAccess.getLibCoercionCSAccess().getOwnedPreconditionsAssignment_7_0_1_1()); }
)

    |(
{ before(grammarAccess.getLibCoercionCSAccess().getOwnedPostconditionsAssignment_7_0_1_2()); }
(rule__LibCoercionCS__OwnedPostconditionsAssignment_7_0_1_2)
{ after(grammarAccess.getLibCoercionCSAccess().getOwnedPostconditionsAssignment_7_0_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Alternatives_14
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getGroup_14_0()); }
(rule__LibIterationCS__Group_14_0__0)
{ after(grammarAccess.getLibIterationCSAccess().getGroup_14_0()); }
)

    |(
{ before(grammarAccess.getLibIterationCSAccess().getSemicolonKeyword_14_1()); }

	';'

{ after(grammarAccess.getLibIterationCSAccess().getSemicolonKeyword_14_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Alternatives_14_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedAnnotationsAssignment_14_0_1_0()); }
(rule__LibIterationCS__OwnedAnnotationsAssignment_14_0_1_0)
{ after(grammarAccess.getLibIterationCSAccess().getOwnedAnnotationsAssignment_14_0_1_0()); }
)

    |(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedPreconditionsAssignment_14_0_1_1()); }
(rule__LibIterationCS__OwnedPreconditionsAssignment_14_0_1_1)
{ after(grammarAccess.getLibIterationCSAccess().getOwnedPreconditionsAssignment_14_0_1_1()); }
)

    |(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedPostconditionsAssignment_14_0_1_2()); }
(rule__LibIterationCS__OwnedPostconditionsAssignment_14_0_1_2)
{ after(grammarAccess.getLibIterationCSAccess().getOwnedPostconditionsAssignment_14_0_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getLibCoercionCSParserRuleCall_0()); }
	ruleLibCoercionCS
{ after(grammarAccess.getOperationCSAccess().getLibCoercionCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getLibIterationCSParserRuleCall_1()); }
	ruleLibIterationCS
{ after(grammarAccess.getOperationCSAccess().getLibIterationCSParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getLibOperationCSParserRuleCall_2()); }
	ruleLibOperationCS
{ after(grammarAccess.getOperationCSAccess().getLibOperationCSParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Alternatives_13
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getGroup_13_0()); }
(rule__LibOperationCS__Group_13_0__0)
{ after(grammarAccess.getLibOperationCSAccess().getGroup_13_0()); }
)

    |(
{ before(grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_13_1()); }

	';'

{ after(grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_13_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Alternatives_13_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedAnnotationsAssignment_13_0_1_0()); }
(rule__LibOperationCS__OwnedAnnotationsAssignment_13_0_1_0)
{ after(grammarAccess.getLibOperationCSAccess().getOwnedAnnotationsAssignment_13_0_1_0()); }
)

    |(
{ before(grammarAccess.getLibOperationCSAccess().getGroup_13_0_1_1()); }
(rule__LibOperationCS__Group_13_0_1_1__0)
{ after(grammarAccess.getLibOperationCSAccess().getGroup_13_0_1_1()); }
)

    |(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedPostconditionsAssignment_13_0_1_2()); }
(rule__LibOperationCS__OwnedPostconditionsAssignment_13_0_1_2)
{ after(grammarAccess.getLibOperationCSAccess().getOwnedPostconditionsAssignment_13_0_1_2()); }
)

    |(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedPreconditionsAssignment_13_0_1_3()); }
(rule__LibOperationCS__OwnedPreconditionsAssignment_13_0_1_3)
{ after(grammarAccess.getLibOperationCSAccess().getOwnedPreconditionsAssignment_13_0_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__Alternatives_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getOwnedPackagesAssignment_4_0()); }
(rule__LibPackageCS__OwnedPackagesAssignment_4_0)
{ after(grammarAccess.getLibPackageCSAccess().getOwnedPackagesAssignment_4_0()); }
)

    |(
{ before(grammarAccess.getLibPackageCSAccess().getGroup_4_1()); }
(rule__LibPackageCS__Group_4_1__0)
{ after(grammarAccess.getLibPackageCSAccess().getGroup_4_1()); }
)

    |(
{ before(grammarAccess.getLibPackageCSAccess().getOwnedClassesAssignment_4_2()); }
(rule__LibPackageCS__OwnedClassesAssignment_4_2)
{ after(grammarAccess.getLibPackageCSAccess().getOwnedClassesAssignment_4_2()); }
)

    |(
{ before(grammarAccess.getLibPackageCSAccess().getOwnedAnnotationsAssignment_4_3()); }
(rule__LibPackageCS__OwnedAnnotationsAssignment_4_3)
{ after(grammarAccess.getLibPackageCSAccess().getOwnedAnnotationsAssignment_4_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Alternatives_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getOwnedPackagesAssignment_4_0()); }
(rule__PackageCS__OwnedPackagesAssignment_4_0)
{ after(grammarAccess.getPackageCSAccess().getOwnedPackagesAssignment_4_0()); }
)

    |(
{ before(grammarAccess.getPackageCSAccess().getOwnedClassesAssignment_4_1()); }
(rule__PackageCS__OwnedClassesAssignment_4_1)
{ after(grammarAccess.getPackageCSAccess().getOwnedClassesAssignment_4_1()); }
)

    |(
{ before(grammarAccess.getPackageCSAccess().getOwnedAnnotationsAssignment_4_2()); }
(rule__PackageCS__OwnedAnnotationsAssignment_4_2)
{ after(grammarAccess.getPackageCSAccess().getOwnedAnnotationsAssignment_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__Alternatives_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getGroup_7_0()); }
(rule__LibPropertyCS__Group_7_0__0)
{ after(grammarAccess.getLibPropertyCSAccess().getGroup_7_0()); }
)

    |(
{ before(grammarAccess.getLibPropertyCSAccess().getSemicolonKeyword_7_1()); }

	';'

{ after(grammarAccess.getLibPropertyCSAccess().getSemicolonKeyword_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrecedenceCS__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrecedenceCSAccess().getLeftKeyword_0_0()); }

	'left'

{ after(grammarAccess.getPrecedenceCSAccess().getLeftKeyword_0_0()); }
)

    |(
{ before(grammarAccess.getPrecedenceCSAccess().getIsRightAssociativeAssignment_0_1()); }
(rule__PrecedenceCS__IsRightAssociativeAssignment_0_1)
{ after(grammarAccess.getPrecedenceCSAccess().getIsRightAssociativeAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypedMultiplicityRefCS__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedMultiplicityRefCSAccess().getMapTypeCSParserRuleCall_0_0()); }
	ruleMapTypeCS
{ after(grammarAccess.getTypedMultiplicityRefCSAccess().getMapTypeCSParserRuleCall_0_0()); }
)

    |(
{ before(grammarAccess.getTypedMultiplicityRefCSAccess().getTupleTypeCSParserRuleCall_0_1()); }
	ruleTupleTypeCS
{ after(grammarAccess.getTypedMultiplicityRefCSAccess().getTupleTypeCSParserRuleCall_0_1()); }
)

    |(
{ before(grammarAccess.getTypedMultiplicityRefCSAccess().getTypedTypeRefCSParserRuleCall_0_2()); }
	ruleTypedTypeRefCS
{ after(grammarAccess.getTypedMultiplicityRefCSAccess().getTypedTypeRefCSParserRuleCall_0_2()); }
)

    |(
{ before(grammarAccess.getTypedMultiplicityRefCSAccess().getLambdaTypeCSParserRuleCall_0_3()); }
	ruleLambdaTypeCS
{ after(grammarAccess.getTypedMultiplicityRefCSAccess().getLambdaTypeCSParserRuleCall_0_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypedRefCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedRefCSAccess().getMapTypeCSParserRuleCall_0()); }
	ruleMapTypeCS
{ after(grammarAccess.getTypedRefCSAccess().getMapTypeCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getTypedRefCSAccess().getTupleTypeCSParserRuleCall_1()); }
	ruleTupleTypeCS
{ after(grammarAccess.getTypedRefCSAccess().getTupleTypeCSParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall_2()); }
	ruleTypedTypeRefCS
{ after(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getTypedRefCSAccess().getLambdaTypeCSParserRuleCall_3()); }
	ruleLambdaTypeCS
{ after(grammarAccess.getTypedRefCSAccess().getLambdaTypeCSParserRuleCall_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getGroup_0()); }
(rule__TypedTypeRefCS__Group_0__0)
{ after(grammarAccess.getTypedTypeRefCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getTypedTypeRefCSAccess().getGroup_1()); }
(rule__TypedTypeRefCS__Group_1__0)
{ after(grammarAccess.getTypedTypeRefCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EssentialOCLReservedKeyword__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getAndKeyword_0()); }

	'and'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getAndKeyword_0()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getAnd2Keyword_1()); }

	'and2'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getAnd2Keyword_1()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getElseKeyword_2()); }

	'else'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getElseKeyword_2()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getEndifKeyword_3()); }

	'endif'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getEndifKeyword_3()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getIfKeyword_4()); }

	'if'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getIfKeyword_4()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getImpliesKeyword_5()); }

	'implies'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getImpliesKeyword_5()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getImplies2Keyword_6()); }

	'implies2'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getImplies2Keyword_6()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getInKeyword_7()); }

	'in'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getInKeyword_7()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getLetKeyword_8()); }

	'let'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getLetKeyword_8()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getNotKeyword_9()); }

	'not'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getNotKeyword_9()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getNot2Keyword_10()); }

	'not2'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getNot2Keyword_10()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getOrKeyword_11()); }

	'or'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getOrKeyword_11()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getOr2Keyword_12()); }

	'or2'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getOr2Keyword_12()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getThenKeyword_13()); }

	'then'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getThenKeyword_13()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getWithKeyword_14()); }

	'with'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getWithKeyword_14()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getXorKeyword_15()); }

	'xor'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getXorKeyword_15()); }
)

    |(
{ before(grammarAccess.getEssentialOCLReservedKeywordAccess().getXor2Keyword_16()); }

	'xor2'

{ after(grammarAccess.getEssentialOCLReservedKeywordAccess().getXor2Keyword_16()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EssentialOCLUnaryOperatorName__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getHyphenMinusKeyword_0()); }

	'-'

{ after(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getHyphenMinusKeyword_0()); }
)

    |(
{ before(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNotKeyword_1()); }

	'not'

{ after(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNotKeyword_1()); }
)

    |(
{ before(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNot2Keyword_2()); }

	'not2'

{ after(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNot2Keyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EssentialOCLInfixOperatorName__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAsteriskKeyword_0()); }

	'*'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAsteriskKeyword_0()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getSolidusKeyword_1()); }

	'/'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getSolidusKeyword_1()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getPlusSignKeyword_2()); }

	'+'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getPlusSignKeyword_2()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getHyphenMinusKeyword_3()); }

	'-'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getHyphenMinusKeyword_3()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignKeyword_4()); }

	'>'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignKeyword_4()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignKeyword_5()); }

	'<'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignKeyword_5()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignEqualsSignKeyword_6()); }

	'>='

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignEqualsSignKeyword_6()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignEqualsSignKeyword_7()); }

	'<='

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignEqualsSignKeyword_7()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getEqualsSignKeyword_8()); }

	'='

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getEqualsSignKeyword_8()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignGreaterThanSignKeyword_9()); }

	'<>'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignGreaterThanSignKeyword_9()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAndKeyword_10()); }

	'and'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAndKeyword_10()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAnd2Keyword_11()); }

	'and2'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAnd2Keyword_11()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImpliesKeyword_12()); }

	'implies'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImpliesKeyword_12()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImplies2Keyword_13()); }

	'implies2'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImplies2Keyword_13()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOrKeyword_14()); }

	'or'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOrKeyword_14()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOr2Keyword_15()); }

	'or2'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOr2Keyword_15()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXorKeyword_16()); }

	'xor'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXorKeyword_16()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXor2Keyword_17()); }

	'xor2'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXor2Keyword_17()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EssentialOCLNavigationOperatorName__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getFullStopKeyword_0()); }

	'.'

{ after(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getFullStopKeyword_0()); }
)

    |(
{ before(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getHyphenMinusGreaterThanSignKeyword_1()); }

	'->'

{ after(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getHyphenMinusGreaterThanSignKeyword_1()); }
)

    |(
{ before(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkFullStopKeyword_2()); }

	'?.'

{ after(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkFullStopKeyword_2()); }
)

    |(
{ before(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkHyphenMinusGreaterThanSignKeyword_3()); }

	'?->'

{ after(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkHyphenMinusGreaterThanSignKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryOperatorName__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBinaryOperatorNameAccess().getInfixOperatorNameParserRuleCall_0()); }
	ruleInfixOperatorName
{ after(grammarAccess.getBinaryOperatorNameAccess().getInfixOperatorNameParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getBinaryOperatorNameAccess().getNavigationOperatorNameParserRuleCall_1()); }
	ruleNavigationOperatorName
{ after(grammarAccess.getBinaryOperatorNameAccess().getNavigationOperatorNameParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EssentialOCLUnreservedName__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); }
	ruleUnrestrictedName
{ after(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); }
	ruleCollectionTypeIdentifier
{ after(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); }
	rulePrimitiveTypeIdentifier
{ after(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getEssentialOCLUnreservedNameAccess().getMapKeyword_3()); }

	'Map'

{ after(grammarAccess.getEssentialOCLUnreservedNameAccess().getMapKeyword_3()); }
)

    |(
{ before(grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_4()); }

	'Tuple'

{ after(grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__URIFirstPathElementCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementAssignment_0()); }
(rule__URIFirstPathElementCS__ReferredElementAssignment_0)
{ after(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementAssignment_0()); }
)

    |(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getGroup_1()); }
(rule__URIFirstPathElementCS__Group_1__0)
{ after(grammarAccess.getURIFirstPathElementCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrimitiveTypeIdentifier__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); }

	'Boolean'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); }
)

    |(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); }

	'Integer'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); }
)

    |(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); }

	'Real'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); }
)

    |(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); }

	'String'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); }
)

    |(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); }

	'UnlimitedNatural'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); }
)

    |(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); }

	'OclAny'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); }
)

    |(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); }

	'OclInvalid'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); }
)

    |(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclVoidKeyword_7()); }

	'OclVoid'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclVoidKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeIdentifier__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); }

	'Set'

{ after(grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); }
)

    |(
{ before(grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); }

	'Bag'

{ after(grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); }
)

    |(
{ before(grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); }

	'Sequence'

{ after(grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); }
)

    |(
{ before(grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); }

	'Collection'

{ after(grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); }
)

    |(
{ before(grammarAccess.getCollectionTypeIdentifierAccess().getOrderedSetKeyword_4()); }

	'OrderedSet'

{ after(grammarAccess.getCollectionTypeIdentifierAccess().getOrderedSetKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_0()); }
(rule__CollectionLiteralPartCS__Group_0__0)
{ after(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionAssignment_1()); }
(rule__CollectionLiteralPartCS__OwnedExpressionAssignment_1)
{ after(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getGroup_0()); }
(rule__ShadowPartCS__Group_0__0)
{ after(grammarAccess.getShadowPartCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAssignment_1()); }
(rule__ShadowPartCS__OwnedInitExpressionAssignment_1)
{ after(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__OwnedInitExpressionAlternatives_0_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_2_0_0()); }
	ruleExpCS
{ after(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_2_0_0()); }
)

    |(
{ before(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_0_2_0_1()); }
	rulePatternExpCS
{ after(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_0_2_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralPartCS__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralPartCSAccess().getWithKeyword_1_0()); }

	'with'

{ after(grammarAccess.getMapLiteralPartCSAccess().getWithKeyword_1_0()); }
)

    |(
{ before(grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1_1()); }

	'<-'

{ after(grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrimitiveLiteralExpCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); }
	ruleNumberLiteralExpCS
{ after(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); }
	ruleStringLiteralExpCS
{ after(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); }
	ruleBooleanLiteralExpCS
{ after(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); }
	ruleUnlimitedNaturalLiteralExpCS
{ after(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); }
	ruleInvalidLiteralExpCS
{ after(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); }
)

    |(
{ before(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); }
	ruleNullLiteralExpCS
{ after(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteralExpCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolAssignment_0()); }
(rule__BooleanLiteralExpCS__SymbolAssignment_0)
{ after(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolAssignment_0()); }
)

    |(
{ before(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolAssignment_1()); }
(rule__BooleanLiteralExpCS__SymbolAssignment_1)
{ after(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeLiteralCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); }
	rulePrimitiveTypeCS
{ after(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); }
	ruleCollectionTypeCS
{ after(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getTypeLiteralCSAccess().getMapTypeCSParserRuleCall_2()); }
	ruleMapTypeCS
{ after(grammarAccess.getTypeLiteralCSAccess().getMapTypeCSParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_3()); }
	ruleTupleTypeCS
{ after(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeExpWithoutMultiplicityCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getTypeNameExpCSParserRuleCall_0()); }
	ruleTypeNameExpCS
{ after(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getTypeNameExpCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_1()); }
	ruleTypeLiteralCS
{ after(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getCollectionPatternCSParserRuleCall_2()); }
	ruleCollectionPatternCS
{ after(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getCollectionPatternCSParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getGroup_0()); }
(rule__ExpCS__Group_0__0)
{ after(grammarAccess.getExpCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getExpCSAccess().getPrefixedLetExpCSParserRuleCall_1()); }
	rulePrefixedLetExpCS
{ after(grammarAccess.getExpCSAccess().getPrefixedLetExpCSParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedLetExpCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getGroup_0()); }
(rule__PrefixedLetExpCS__Group_0__0)
{ after(grammarAccess.getPrefixedLetExpCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getLetExpCSParserRuleCall_1()); }
	ruleLetExpCS
{ after(grammarAccess.getPrefixedLetExpCSAccess().getLetExpCSParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedPrimaryExpCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getGroup_0()); }
(rule__PrefixedPrimaryExpCS__Group_0__0)
{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_1()); }
	rulePrimaryExpCS
{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); }
	ruleNestedExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); }
	ruleIfExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); }
	ruleSelfExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); }
	rulePrimitiveLiteralExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); }
	ruleTupleLiteralExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getMapLiteralExpCSParserRuleCall_5()); }
	ruleMapLiteralExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getMapLiteralExpCSParserRuleCall_5()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_6()); }
	ruleCollectionLiteralExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_6()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getLambdaLiteralExpCSParserRuleCall_7()); }
	ruleLambdaLiteralExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getLambdaLiteralExpCSParserRuleCall_7()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_8()); }
	ruleTypeLiteralExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_8()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_9()); }
	ruleNameExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__OwnedArgumentsAlternatives_2_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0_0()); }
	ruleNavigatingCommaArgCS
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0_0()); }
)

    |(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_1_0_1()); }
	ruleNavigatingSemiArgCS
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_1_0_1()); }
)

    |(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_1_0_2()); }
	ruleNavigatingBarArgCS
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_1_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_0()); }
(rule__NavigatingArgCS__Group_0__0)
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_1()); }
(rule__NavigatingArgCS__Group_1__0)
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Alternatives_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_0()); }
(rule__NavigatingArgCS__Group_0_1_0__0)
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_0()); }
)

    |(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_1()); }
(rule__NavigatingArgCS__Group_0_1_1__0)
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_1()); }
)

    |(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_2()); }
(rule__NavigatingArgCS__Group_0_1_2__0)
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Alternatives_0_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_0_0_0()); }

	'with'

{ after(grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_0_0_0()); }
)

    |(
{ before(grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_0_0_1()); }

	'<-'

{ after(grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Alternatives_0_1_1_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_1_2_0_0()); }

	'with'

{ after(grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_1_2_0_0()); }
)

    |(
{ before(grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_1_2_0_1()); }

	'<-'

{ after(grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_1_2_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Alternatives_0_1_2_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_2_1_0_0()); }

	'with'

{ after(grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_2_1_0_0()); }
)

    |(
{ before(grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_2_1_0_1()); }

	'<-'

{ after(grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_2_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Alternatives_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_0()); }
(rule__NavigatingCommaArgCS__Group_2_0__0)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_0()); }
)

    |(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_1()); }
(rule__NavigatingCommaArgCS__Group_2_1__0)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_1()); }
)

    |(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_2()); }
(rule__NavigatingCommaArgCS__Group_2_2__0)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Alternatives_2_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_0_0_0()); }

	'with'

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_0_0_0()); }
)

    |(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_0_0_1()); }

	'<-'

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Alternatives_2_1_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_1_2_0_0()); }

	'with'

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_1_2_0_0()); }
)

    |(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_1_2_0_1()); }

	'<-'

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_1_2_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Alternatives_2_2_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_2_1_0_0()); }

	'with'

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_2_1_0_0()); }
)

    |(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_2_1_0_1()); }

	'<-'

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_2_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__OwnedConditionAlternatives_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0()); }
	ruleExpCS
{ after(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0()); }
)

    |(
{ before(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1()); }
	rulePatternExpCS
{ after(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityCS__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); }
	ruleMultiplicityBoundsCS
{ after(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); }
)

    |(
{ before(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); }
	ruleMultiplicityStringCS
{ after(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityCS__Alternatives_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0()); }

	'|?'

{ after(grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0()); }
)

    |(
{ before(grammarAccess.getMultiplicityCSAccess().getIsNullFreeAssignment_2_1()); }
(rule__MultiplicityCS__IsNullFreeAssignment_2_1)
{ after(grammarAccess.getMultiplicityCSAccess().getIsNullFreeAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityStringCS__StringBoundsAlternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0()); }

	'*'

{ after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0()); }
)

    |(
{ before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1()); }

	'+'

{ after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1()); }
)

    |(
{ before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2()); }

	'?'

{ after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRefCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0()); }
	ruleTypedRefCS
{ after(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); }
	ruleWildcardTypeRefCS
{ after(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ID__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); }
	RULE_SIMPLE_ID
{ after(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); }
)

    |(
{ before(grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1()); }
	RULE_ESCAPED_ID
{ after(grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__UPPER__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); }
	RULE_INT
{ after(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); }
)

    |(
{ before(grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); }

	'*'

{ after(grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__Library__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Library__Group__0__Impl
	rule__Library__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Library__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibraryAccess().getGroup_0()); }
(rule__Library__Group_0__0)*
{ after(grammarAccess.getLibraryAccess().getGroup_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Library__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Library__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Library__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibraryAccess().getOwnedPackagesAssignment_1()); }
(rule__Library__OwnedPackagesAssignment_1)*
{ after(grammarAccess.getLibraryAccess().getOwnedPackagesAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Library__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Library__Group_0__0__Impl
	rule__Library__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Library__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibraryAccess().getOwnedImportsAssignment_0_0()); }
(rule__Library__OwnedImportsAssignment_0_0)
{ after(grammarAccess.getLibraryAccess().getOwnedImportsAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Library__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Library__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Library__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibraryAccess().getSemicolonKeyword_0_1()); }

	';'

{ after(grammarAccess.getLibraryAccess().getSemicolonKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LibPathNameCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPathNameCS__Group__0__Impl
	rule__LibPathNameCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPathNameCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPathNameCSAccess().getOwnedPathElementsAssignment_0()); }
(rule__LibPathNameCS__OwnedPathElementsAssignment_0)
{ after(grammarAccess.getLibPathNameCSAccess().getOwnedPathElementsAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPathNameCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPathNameCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPathNameCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPathNameCSAccess().getGroup_1()); }
(rule__LibPathNameCS__Group_1__0)*
{ after(grammarAccess.getLibPathNameCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LibPathNameCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPathNameCS__Group_1__0__Impl
	rule__LibPathNameCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPathNameCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPathNameCSAccess().getColonColonKeyword_1_0()); }

	'::'

{ after(grammarAccess.getLibPathNameCSAccess().getColonColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPathNameCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPathNameCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPathNameCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); }
(rule__LibPathNameCS__OwnedPathElementsAssignment_1_1)
{ after(grammarAccess.getLibPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AccumulatorCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AccumulatorCS__Group__0__Impl
	rule__AccumulatorCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AccumulatorCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAccumulatorCSAccess().getNameAssignment_0()); }
(rule__AccumulatorCS__NameAssignment_0)
{ after(grammarAccess.getAccumulatorCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AccumulatorCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AccumulatorCS__Group__1__Impl
	rule__AccumulatorCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AccumulatorCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAccumulatorCSAccess().getColonKeyword_1()); }

	':'

{ after(grammarAccess.getAccumulatorCSAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AccumulatorCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AccumulatorCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AccumulatorCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAccumulatorCSAccess().getOwnedTypeAssignment_2()); }
(rule__AccumulatorCS__OwnedTypeAssignment_2)
{ after(grammarAccess.getAccumulatorCSAccess().getOwnedTypeAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AnnotationCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group__0__Impl
	rule__AnnotationCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getAnnotationKeyword_0()); }

	'annotation'

{ after(grammarAccess.getAnnotationCSAccess().getAnnotationKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group__1__Impl
	rule__AnnotationCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getNameAssignment_1()); }
(rule__AnnotationCS__NameAssignment_1)
{ after(grammarAccess.getAnnotationCSAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group__2__Impl
	rule__AnnotationCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getGroup_2()); }
(rule__AnnotationCS__Group_2__0)?
{ after(grammarAccess.getAnnotationCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getAlternatives_3()); }
(rule__AnnotationCS__Alternatives_3)
{ after(grammarAccess.getAnnotationCSAccess().getAlternatives_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__AnnotationCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_2__0__Impl
	rule__AnnotationCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getLeftParenthesisKeyword_2_0()); }

	'('

{ after(grammarAccess.getAnnotationCSAccess().getLeftParenthesisKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_2__1__Impl
	rule__AnnotationCS__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedDetailsAssignment_2_1()); }
(rule__AnnotationCS__OwnedDetailsAssignment_2_1)
{ after(grammarAccess.getAnnotationCSAccess().getOwnedDetailsAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_2__2__Impl
	rule__AnnotationCS__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getGroup_2_2()); }
(rule__AnnotationCS__Group_2_2__0)*
{ after(grammarAccess.getAnnotationCSAccess().getGroup_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getRightParenthesisKeyword_2_3()); }

	')'

{ after(grammarAccess.getAnnotationCSAccess().getRightParenthesisKeyword_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__AnnotationCS__Group_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_2_2__0__Impl
	rule__AnnotationCS__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getCommaKeyword_2_2_0()); }

	','

{ after(grammarAccess.getAnnotationCSAccess().getCommaKeyword_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedDetailsAssignment_2_2_1()); }
(rule__AnnotationCS__OwnedDetailsAssignment_2_2_1)
{ after(grammarAccess.getAnnotationCSAccess().getOwnedDetailsAssignment_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AnnotationCS__Group_3_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_3_0__0__Impl
	rule__AnnotationCS__Group_3_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_3_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getLeftCurlyBracketKeyword_3_0_0()); }

	'{'

{ after(grammarAccess.getAnnotationCSAccess().getLeftCurlyBracketKeyword_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group_3_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_3_0__1__Impl
	rule__AnnotationCS__Group_3_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_3_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedAnnotationsAssignment_3_0_1()); }
(rule__AnnotationCS__OwnedAnnotationsAssignment_3_0_1)
{ after(grammarAccess.getAnnotationCSAccess().getOwnedAnnotationsAssignment_3_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group_3_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_3_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_3_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getRightCurlyBracketKeyword_3_0_2()); }

	'}'

{ after(grammarAccess.getAnnotationCSAccess().getRightCurlyBracketKeyword_3_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__LibClassCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group__0__Impl
	rule__LibClassCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getIsAbstractAssignment_0()); }
(rule__LibClassCS__IsAbstractAssignment_0)?
{ after(grammarAccess.getLibClassCSAccess().getIsAbstractAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibClassCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group__1__Impl
	rule__LibClassCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getTypeKeyword_1()); }

	'type'

{ after(grammarAccess.getLibClassCSAccess().getTypeKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibClassCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group__2__Impl
	rule__LibClassCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getNameAssignment_2()); }
(rule__LibClassCS__NameAssignment_2)
{ after(grammarAccess.getLibClassCSAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibClassCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group__3__Impl
	rule__LibClassCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getOwnedSignatureAssignment_3()); }
(rule__LibClassCS__OwnedSignatureAssignment_3)?
{ after(grammarAccess.getLibClassCSAccess().getOwnedSignatureAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibClassCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group__4__Impl
	rule__LibClassCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getGroup_4()); }
(rule__LibClassCS__Group_4__0)?
{ after(grammarAccess.getLibClassCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibClassCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group__5__Impl
	rule__LibClassCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getGroup_5()); }
(rule__LibClassCS__Group_5__0)?
{ after(grammarAccess.getLibClassCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibClassCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group__6__Impl
	rule__LibClassCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getGroup_6()); }
(rule__LibClassCS__Group_6__0)?
{ after(grammarAccess.getLibClassCSAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibClassCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group__7__Impl
	rule__LibClassCS__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getLeftCurlyBracketKeyword_7()); }

	'{'

{ after(grammarAccess.getLibClassCSAccess().getLeftCurlyBracketKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibClassCS__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group__8__Impl
	rule__LibClassCS__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getAlternatives_8()); }
(rule__LibClassCS__Alternatives_8)*
{ after(grammarAccess.getLibClassCSAccess().getAlternatives_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibClassCS__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getRightCurlyBracketKeyword_9()); }

	'}'

{ after(grammarAccess.getLibClassCSAccess().getRightCurlyBracketKeyword_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}






















rule__LibClassCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group_4__0__Impl
	rule__LibClassCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getColonKeyword_4_0()); }

	':'

{ after(grammarAccess.getLibClassCSAccess().getColonKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibClassCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getMetaclassNameAssignment_4_1()); }
(rule__LibClassCS__MetaclassNameAssignment_4_1)
{ after(grammarAccess.getLibClassCSAccess().getMetaclassNameAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LibClassCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group_5__0__Impl
	rule__LibClassCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getConformsToKeyword_5_0()); }

	'conformsTo'

{ after(grammarAccess.getLibClassCSAccess().getConformsToKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibClassCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group_5__1__Impl
	rule__LibClassCS__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getOwnedSuperTypesAssignment_5_1()); }
(rule__LibClassCS__OwnedSuperTypesAssignment_5_1)
{ after(grammarAccess.getLibClassCSAccess().getOwnedSuperTypesAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibClassCS__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getGroup_5_2()); }
(rule__LibClassCS__Group_5_2__0)*
{ after(grammarAccess.getLibClassCSAccess().getGroup_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__LibClassCS__Group_5_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group_5_2__0__Impl
	rule__LibClassCS__Group_5_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group_5_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getCommaKeyword_5_2_0()); }

	','

{ after(grammarAccess.getLibClassCSAccess().getCommaKeyword_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibClassCS__Group_5_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group_5_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group_5_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getOwnedSuperTypesAssignment_5_2_1()); }
(rule__LibClassCS__OwnedSuperTypesAssignment_5_2_1)
{ after(grammarAccess.getLibClassCSAccess().getOwnedSuperTypesAssignment_5_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LibClassCS__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group_6__0__Impl
	rule__LibClassCS__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getEqualsSignGreaterThanSignKeyword_6_0()); }

	'=>'

{ after(grammarAccess.getLibClassCSAccess().getEqualsSignGreaterThanSignKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibClassCS__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibClassCS__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getImplementationAssignment_6_1()); }
(rule__LibClassCS__ImplementationAssignment_6_1)
{ after(grammarAccess.getLibClassCSAccess().getImplementationAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DetailCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DetailCS__Group__0__Impl
	rule__DetailCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DetailCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDetailCSAccess().getNameAssignment_0()); }
(rule__DetailCS__NameAssignment_0)
{ after(grammarAccess.getDetailCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DetailCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DetailCS__Group__1__Impl
	rule__DetailCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DetailCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDetailCSAccess().getEqualsSignKeyword_1()); }

	'='

{ after(grammarAccess.getDetailCSAccess().getEqualsSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DetailCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DetailCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DetailCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDetailCSAccess().getValuesAssignment_2()); }
(rule__DetailCS__ValuesAssignment_2)*
{ after(grammarAccess.getDetailCSAccess().getValuesAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__DocumentationCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationCS__Group__0__Impl
	rule__DocumentationCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationCSAccess().getDocumentationCSAction_0()); }
(

)
{ after(grammarAccess.getDocumentationCSAccess().getDocumentationCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentationCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationCS__Group__1__Impl
	rule__DocumentationCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationCSAccess().getDocumentationKeyword_1()); }

	'documentation'

{ after(grammarAccess.getDocumentationCSAccess().getDocumentationKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentationCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationCS__Group__2__Impl
	rule__DocumentationCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationCSAccess().getValueAssignment_2()); }
(rule__DocumentationCS__ValueAssignment_2)?
{ after(grammarAccess.getDocumentationCSAccess().getValueAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentationCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationCS__Group__3__Impl
	rule__DocumentationCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationCSAccess().getGroup_3()); }
(rule__DocumentationCS__Group_3__0)?
{ after(grammarAccess.getDocumentationCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentationCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationCSAccess().getSemicolonKeyword_4()); }

	';'

{ after(grammarAccess.getDocumentationCSAccess().getSemicolonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__DocumentationCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationCS__Group_3__0__Impl
	rule__DocumentationCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationCSAccess().getLeftParenthesisKeyword_3_0()); }

	'('

{ after(grammarAccess.getDocumentationCSAccess().getLeftParenthesisKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentationCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationCS__Group_3__1__Impl
	rule__DocumentationCS__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationCSAccess().getOwnedDetailsAssignment_3_1()); }
(rule__DocumentationCS__OwnedDetailsAssignment_3_1)
{ after(grammarAccess.getDocumentationCSAccess().getOwnedDetailsAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentationCS__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationCS__Group_3__2__Impl
	rule__DocumentationCS__Group_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationCS__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationCSAccess().getGroup_3_2()); }
(rule__DocumentationCS__Group_3_2__0)*
{ after(grammarAccess.getDocumentationCSAccess().getGroup_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentationCS__Group_3__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationCS__Group_3__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationCS__Group_3__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationCSAccess().getRightParenthesisKeyword_3_3()); }

	')'

{ after(grammarAccess.getDocumentationCSAccess().getRightParenthesisKeyword_3_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__DocumentationCS__Group_3_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationCS__Group_3_2__0__Impl
	rule__DocumentationCS__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationCS__Group_3_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationCSAccess().getCommaKeyword_3_2_0()); }

	','

{ after(grammarAccess.getDocumentationCSAccess().getCommaKeyword_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentationCS__Group_3_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationCS__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationCS__Group_3_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationCSAccess().getOwnedDetailsAssignment_3_2_1()); }
(rule__DocumentationCS__OwnedDetailsAssignment_3_2_1)
{ after(grammarAccess.getDocumentationCSAccess().getOwnedDetailsAssignment_3_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ImportCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group__0__Impl
	rule__ImportCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getImportKeyword_0()); }

	'import'

{ after(grammarAccess.getImportCSAccess().getImportKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImportCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group__1__Impl
	rule__ImportCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getGroup_1()); }
(rule__ImportCS__Group_1__0)?
{ after(grammarAccess.getImportCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImportCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group__2__Impl
	rule__ImportCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getOwnedPathNameAssignment_2()); }
(rule__ImportCS__OwnedPathNameAssignment_2)
{ after(grammarAccess.getImportCSAccess().getOwnedPathNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImportCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getIsAllAssignment_3()); }
(rule__ImportCS__IsAllAssignment_3)?
{ after(grammarAccess.getImportCSAccess().getIsAllAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ImportCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group_1__0__Impl
	rule__ImportCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getNameAssignment_1_0()); }
(rule__ImportCS__NameAssignment_1_0)
{ after(grammarAccess.getImportCSAccess().getNameAssignment_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImportCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getColonKeyword_1_1()); }

	':'

{ after(grammarAccess.getImportCSAccess().getColonKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__InvCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvCS__Group__0__Impl
	rule__InvCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InvCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvCSAccess().getStereotypeAssignment_0()); }
(rule__InvCS__StereotypeAssignment_0)
{ after(grammarAccess.getInvCSAccess().getStereotypeAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvCS__Group__1__Impl
	rule__InvCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__InvCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvCSAccess().getGroup_1()); }
(rule__InvCS__Group_1__0)?
{ after(grammarAccess.getInvCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvCS__Group__2__Impl
	rule__InvCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__InvCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvCSAccess().getColonKeyword_2()); }

	':'

{ after(grammarAccess.getInvCSAccess().getColonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvCS__Group__3__Impl
	rule__InvCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__InvCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvCSAccess().getOwnedSpecificationAssignment_3()); }
(rule__InvCS__OwnedSpecificationAssignment_3)
{ after(grammarAccess.getInvCSAccess().getOwnedSpecificationAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InvCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvCSAccess().getSemicolonKeyword_4()); }

	';'

{ after(grammarAccess.getInvCSAccess().getSemicolonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__InvCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvCS__Group_1__0__Impl
	rule__InvCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InvCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvCSAccess().getNameAssignment_1_0()); }
(rule__InvCS__NameAssignment_1_0)
{ after(grammarAccess.getInvCSAccess().getNameAssignment_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InvCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvCSAccess().getGroup_1_1()); }
(rule__InvCS__Group_1_1__0)?
{ after(grammarAccess.getInvCSAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__InvCS__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvCS__Group_1_1__0__Impl
	rule__InvCS__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InvCS__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvCSAccess().getLeftParenthesisKeyword_1_1_0()); }

	'('

{ after(grammarAccess.getInvCSAccess().getLeftParenthesisKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvCS__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvCS__Group_1_1__1__Impl
	rule__InvCS__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__InvCS__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvCSAccess().getOwnedMessageSpecificationAssignment_1_1_1()); }
(rule__InvCS__OwnedMessageSpecificationAssignment_1_1_1)
{ after(grammarAccess.getInvCSAccess().getOwnedMessageSpecificationAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvCS__Group_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvCS__Group_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InvCS__Group_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvCSAccess().getRightParenthesisKeyword_1_1_2()); }

	')'

{ after(grammarAccess.getInvCSAccess().getRightParenthesisKeyword_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__LibCoercionCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibCoercionCS__Group__0__Impl
	rule__LibCoercionCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getCoercionKeyword_0()); }

	'coercion'

{ after(grammarAccess.getLibCoercionCSAccess().getCoercionKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibCoercionCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibCoercionCS__Group__1__Impl
	rule__LibCoercionCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getNameAssignment_1()); }
(rule__LibCoercionCS__NameAssignment_1)
{ after(grammarAccess.getLibCoercionCSAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibCoercionCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibCoercionCS__Group__2__Impl
	rule__LibCoercionCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getLeftParenthesisKeyword_2()); }

	'('

{ after(grammarAccess.getLibCoercionCSAccess().getLeftParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibCoercionCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibCoercionCS__Group__3__Impl
	rule__LibCoercionCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getRightParenthesisKeyword_3()); }

	')'

{ after(grammarAccess.getLibCoercionCSAccess().getRightParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibCoercionCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibCoercionCS__Group__4__Impl
	rule__LibCoercionCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getColonKeyword_4()); }

	':'

{ after(grammarAccess.getLibCoercionCSAccess().getColonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibCoercionCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibCoercionCS__Group__5__Impl
	rule__LibCoercionCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getOwnedTypeAssignment_5()); }
(rule__LibCoercionCS__OwnedTypeAssignment_5)
{ after(grammarAccess.getLibCoercionCSAccess().getOwnedTypeAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibCoercionCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibCoercionCS__Group__6__Impl
	rule__LibCoercionCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getGroup_6()); }
(rule__LibCoercionCS__Group_6__0)?
{ after(grammarAccess.getLibCoercionCSAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibCoercionCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibCoercionCS__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getAlternatives_7()); }
(rule__LibCoercionCS__Alternatives_7)
{ after(grammarAccess.getLibCoercionCSAccess().getAlternatives_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__LibCoercionCS__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibCoercionCS__Group_6__0__Impl
	rule__LibCoercionCS__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getEqualsSignGreaterThanSignKeyword_6_0()); }

	'=>'

{ after(grammarAccess.getLibCoercionCSAccess().getEqualsSignGreaterThanSignKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibCoercionCS__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibCoercionCS__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getImplementationAssignment_6_1()); }
(rule__LibCoercionCS__ImplementationAssignment_6_1)
{ after(grammarAccess.getLibCoercionCSAccess().getImplementationAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LibCoercionCS__Group_7_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibCoercionCS__Group_7_0__0__Impl
	rule__LibCoercionCS__Group_7_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Group_7_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getLeftCurlyBracketKeyword_7_0_0()); }

	'{'

{ after(grammarAccess.getLibCoercionCSAccess().getLeftCurlyBracketKeyword_7_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibCoercionCS__Group_7_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibCoercionCS__Group_7_0__1__Impl
	rule__LibCoercionCS__Group_7_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Group_7_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getAlternatives_7_0_1()); }
(rule__LibCoercionCS__Alternatives_7_0_1)*
{ after(grammarAccess.getLibCoercionCSAccess().getAlternatives_7_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibCoercionCS__Group_7_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibCoercionCS__Group_7_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__Group_7_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getRightCurlyBracketKeyword_7_0_2()); }

	'}'

{ after(grammarAccess.getLibCoercionCSAccess().getRightCurlyBracketKeyword_7_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__LibIterationCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__0__Impl
	rule__LibIterationCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getIterationKeyword_0()); }

	'iteration'

{ after(grammarAccess.getLibIterationCSAccess().getIterationKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__1__Impl
	rule__LibIterationCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getNameAssignment_1()); }
(rule__LibIterationCS__NameAssignment_1)
{ after(grammarAccess.getLibIterationCSAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__2__Impl
	rule__LibIterationCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedSignatureAssignment_2()); }
(rule__LibIterationCS__OwnedSignatureAssignment_2)?
{ after(grammarAccess.getLibIterationCSAccess().getOwnedSignatureAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__3__Impl
	rule__LibIterationCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getLeftParenthesisKeyword_3()); }

	'('

{ after(grammarAccess.getLibIterationCSAccess().getLeftParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__4__Impl
	rule__LibIterationCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedIteratorsAssignment_4()); }
(rule__LibIterationCS__OwnedIteratorsAssignment_4)
{ after(grammarAccess.getLibIterationCSAccess().getOwnedIteratorsAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__5__Impl
	rule__LibIterationCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getGroup_5()); }
(rule__LibIterationCS__Group_5__0)*
{ after(grammarAccess.getLibIterationCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__6__Impl
	rule__LibIterationCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getGroup_6()); }
(rule__LibIterationCS__Group_6__0)?
{ after(grammarAccess.getLibIterationCSAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__7__Impl
	rule__LibIterationCS__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getGroup_7()); }
(rule__LibIterationCS__Group_7__0)?
{ after(grammarAccess.getLibIterationCSAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__8__Impl
	rule__LibIterationCS__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getRightParenthesisKeyword_8()); }

	')'

{ after(grammarAccess.getLibIterationCSAccess().getRightParenthesisKeyword_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__9__Impl
	rule__LibIterationCS__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getColonKeyword_9()); }

	':'

{ after(grammarAccess.getLibIterationCSAccess().getColonKeyword_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__10__Impl
	rule__LibIterationCS__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedTypeAssignment_10()); }
(rule__LibIterationCS__OwnedTypeAssignment_10)
{ after(grammarAccess.getLibIterationCSAccess().getOwnedTypeAssignment_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group__11
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__11__Impl
	rule__LibIterationCS__Group__12
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__11__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getIsInvalidatingAssignment_11()); }
(rule__LibIterationCS__IsInvalidatingAssignment_11)?
{ after(grammarAccess.getLibIterationCSAccess().getIsInvalidatingAssignment_11()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group__12
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__12__Impl
	rule__LibIterationCS__Group__13
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__12__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getIsValidatingAssignment_12()); }
(rule__LibIterationCS__IsValidatingAssignment_12)?
{ after(grammarAccess.getLibIterationCSAccess().getIsValidatingAssignment_12()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group__13
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__13__Impl
	rule__LibIterationCS__Group__14
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__13__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getGroup_13()); }
(rule__LibIterationCS__Group_13__0)?
{ after(grammarAccess.getLibIterationCSAccess().getGroup_13()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group__14
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group__14__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group__14__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getAlternatives_14()); }
(rule__LibIterationCS__Alternatives_14)
{ after(grammarAccess.getLibIterationCSAccess().getAlternatives_14()); }
)

;
finally {
	restoreStackSize(stackSize);
}
































rule__LibIterationCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_5__0__Impl
	rule__LibIterationCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getCommaKeyword_5_0()); }

	','

{ after(grammarAccess.getLibIterationCSAccess().getCommaKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedIteratorsAssignment_5_1()); }
(rule__LibIterationCS__OwnedIteratorsAssignment_5_1)
{ after(grammarAccess.getLibIterationCSAccess().getOwnedIteratorsAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LibIterationCS__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_6__0__Impl
	rule__LibIterationCS__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getSemicolonKeyword_6_0()); }

	';'

{ after(grammarAccess.getLibIterationCSAccess().getSemicolonKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_6__1__Impl
	rule__LibIterationCS__Group_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedAccumulatorsAssignment_6_1()); }
(rule__LibIterationCS__OwnedAccumulatorsAssignment_6_1)
{ after(grammarAccess.getLibIterationCSAccess().getOwnedAccumulatorsAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group_6__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_6__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getGroup_6_2()); }
(rule__LibIterationCS__Group_6_2__0)*
{ after(grammarAccess.getLibIterationCSAccess().getGroup_6_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__LibIterationCS__Group_6_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_6_2__0__Impl
	rule__LibIterationCS__Group_6_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_6_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getCommaKeyword_6_2_0()); }

	','

{ after(grammarAccess.getLibIterationCSAccess().getCommaKeyword_6_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group_6_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_6_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_6_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedAccumulatorsAssignment_6_2_1()); }
(rule__LibIterationCS__OwnedAccumulatorsAssignment_6_2_1)
{ after(grammarAccess.getLibIterationCSAccess().getOwnedAccumulatorsAssignment_6_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LibIterationCS__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_7__0__Impl
	rule__LibIterationCS__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getVerticalLineKeyword_7_0()); }

	'|'

{ after(grammarAccess.getLibIterationCSAccess().getVerticalLineKeyword_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_7__1__Impl
	rule__LibIterationCS__Group_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedParametersAssignment_7_1()); }
(rule__LibIterationCS__OwnedParametersAssignment_7_1)
{ after(grammarAccess.getLibIterationCSAccess().getOwnedParametersAssignment_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group_7__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_7__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_7__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getGroup_7_2()); }
(rule__LibIterationCS__Group_7_2__0)*
{ after(grammarAccess.getLibIterationCSAccess().getGroup_7_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__LibIterationCS__Group_7_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_7_2__0__Impl
	rule__LibIterationCS__Group_7_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_7_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getCommaKeyword_7_2_0()); }

	','

{ after(grammarAccess.getLibIterationCSAccess().getCommaKeyword_7_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group_7_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_7_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_7_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedParametersAssignment_7_2_1()); }
(rule__LibIterationCS__OwnedParametersAssignment_7_2_1)
{ after(grammarAccess.getLibIterationCSAccess().getOwnedParametersAssignment_7_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LibIterationCS__Group_13__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_13__0__Impl
	rule__LibIterationCS__Group_13__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_13__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getEqualsSignGreaterThanSignKeyword_13_0()); }

	'=>'

{ after(grammarAccess.getLibIterationCSAccess().getEqualsSignGreaterThanSignKeyword_13_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group_13__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_13__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_13__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getImplementationAssignment_13_1()); }
(rule__LibIterationCS__ImplementationAssignment_13_1)
{ after(grammarAccess.getLibIterationCSAccess().getImplementationAssignment_13_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LibIterationCS__Group_14_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_14_0__0__Impl
	rule__LibIterationCS__Group_14_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_14_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getLeftCurlyBracketKeyword_14_0_0()); }

	'{'

{ after(grammarAccess.getLibIterationCSAccess().getLeftCurlyBracketKeyword_14_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group_14_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_14_0__1__Impl
	rule__LibIterationCS__Group_14_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_14_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getAlternatives_14_0_1()); }
(rule__LibIterationCS__Alternatives_14_0_1)*
{ after(grammarAccess.getLibIterationCSAccess().getAlternatives_14_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibIterationCS__Group_14_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibIterationCS__Group_14_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__Group_14_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getRightCurlyBracketKeyword_14_0_2()); }

	'}'

{ after(grammarAccess.getLibIterationCSAccess().getRightCurlyBracketKeyword_14_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__IteratorCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IteratorCS__Group__0__Impl
	rule__IteratorCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IteratorCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIteratorCSAccess().getNameAssignment_0()); }
(rule__IteratorCS__NameAssignment_0)
{ after(grammarAccess.getIteratorCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IteratorCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IteratorCS__Group__1__Impl
	rule__IteratorCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IteratorCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIteratorCSAccess().getColonKeyword_1()); }

	':'

{ after(grammarAccess.getIteratorCSAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IteratorCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IteratorCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IteratorCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIteratorCSAccess().getOwnedTypeAssignment_2()); }
(rule__IteratorCS__OwnedTypeAssignment_2)
{ after(grammarAccess.getIteratorCSAccess().getOwnedTypeAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__LambdaTypeCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaTypeCS__Group__0__Impl
	rule__LambdaTypeCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getNameAssignment_0()); }
(rule__LambdaTypeCS__NameAssignment_0)
{ after(grammarAccess.getLambdaTypeCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaTypeCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaTypeCS__Group__1__Impl
	rule__LambdaTypeCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getOwnedSignatureAssignment_1()); }
(rule__LambdaTypeCS__OwnedSignatureAssignment_1)?
{ after(grammarAccess.getLambdaTypeCSAccess().getOwnedSignatureAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaTypeCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaTypeCS__Group__2__Impl
	rule__LambdaTypeCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getOwnedContextTypeAssignment_2()); }
(rule__LambdaTypeCS__OwnedContextTypeAssignment_2)
{ after(grammarAccess.getLambdaTypeCSAccess().getOwnedContextTypeAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaTypeCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaTypeCS__Group__3__Impl
	rule__LambdaTypeCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getLeftParenthesisKeyword_3()); }

	'('

{ after(grammarAccess.getLambdaTypeCSAccess().getLeftParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaTypeCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaTypeCS__Group__4__Impl
	rule__LambdaTypeCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getGroup_4()); }
(rule__LambdaTypeCS__Group_4__0)?
{ after(grammarAccess.getLambdaTypeCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaTypeCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaTypeCS__Group__5__Impl
	rule__LambdaTypeCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getRightParenthesisKeyword_5()); }

	')'

{ after(grammarAccess.getLambdaTypeCSAccess().getRightParenthesisKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaTypeCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaTypeCS__Group__6__Impl
	rule__LambdaTypeCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getColonKeyword_6()); }

	':'

{ after(grammarAccess.getLambdaTypeCSAccess().getColonKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaTypeCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaTypeCS__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getOwnedResultTypeAssignment_7()); }
(rule__LambdaTypeCS__OwnedResultTypeAssignment_7)
{ after(grammarAccess.getLambdaTypeCSAccess().getOwnedResultTypeAssignment_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__LambdaTypeCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaTypeCS__Group_4__0__Impl
	rule__LambdaTypeCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getOwnedParameterTypesAssignment_4_0()); }
(rule__LambdaTypeCS__OwnedParameterTypesAssignment_4_0)
{ after(grammarAccess.getLambdaTypeCSAccess().getOwnedParameterTypesAssignment_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaTypeCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaTypeCS__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getGroup_4_1()); }
(rule__LambdaTypeCS__Group_4_1__0)*
{ after(grammarAccess.getLambdaTypeCSAccess().getGroup_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LambdaTypeCS__Group_4_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaTypeCS__Group_4_1__0__Impl
	rule__LambdaTypeCS__Group_4_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__Group_4_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getCommaKeyword_4_1_0()); }

	','

{ after(grammarAccess.getLambdaTypeCSAccess().getCommaKeyword_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaTypeCS__Group_4_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaTypeCS__Group_4_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__Group_4_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getOwnedParameterTypesAssignment_4_1_1()); }
(rule__LambdaTypeCS__OwnedParameterTypesAssignment_4_1_1)
{ after(grammarAccess.getLambdaTypeCSAccess().getOwnedParameterTypesAssignment_4_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LibOperationCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group__0__Impl
	rule__LibOperationCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getIsStaticAssignment_0()); }
(rule__LibOperationCS__IsStaticAssignment_0)?
{ after(grammarAccess.getLibOperationCSAccess().getIsStaticAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group__1__Impl
	rule__LibOperationCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOperationKeyword_1()); }

	'operation'

{ after(grammarAccess.getLibOperationCSAccess().getOperationKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group__2__Impl
	rule__LibOperationCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getNameAssignment_2()); }
(rule__LibOperationCS__NameAssignment_2)
{ after(grammarAccess.getLibOperationCSAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group__3__Impl
	rule__LibOperationCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedSignatureAssignment_3()); }
(rule__LibOperationCS__OwnedSignatureAssignment_3)?
{ after(grammarAccess.getLibOperationCSAccess().getOwnedSignatureAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group__4__Impl
	rule__LibOperationCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getLeftParenthesisKeyword_4()); }

	'('

{ after(grammarAccess.getLibOperationCSAccess().getLeftParenthesisKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group__5__Impl
	rule__LibOperationCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getGroup_5()); }
(rule__LibOperationCS__Group_5__0)?
{ after(grammarAccess.getLibOperationCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group__6__Impl
	rule__LibOperationCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getRightParenthesisKeyword_6()); }

	')'

{ after(grammarAccess.getLibOperationCSAccess().getRightParenthesisKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group__7__Impl
	rule__LibOperationCS__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getColonKeyword_7()); }

	':'

{ after(grammarAccess.getLibOperationCSAccess().getColonKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group__8__Impl
	rule__LibOperationCS__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedTypeAssignment_8()); }
(rule__LibOperationCS__OwnedTypeAssignment_8)
{ after(grammarAccess.getLibOperationCSAccess().getOwnedTypeAssignment_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group__9__Impl
	rule__LibOperationCS__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getIsValidatingAssignment_9()); }
(rule__LibOperationCS__IsValidatingAssignment_9)?
{ after(grammarAccess.getLibOperationCSAccess().getIsValidatingAssignment_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group__10__Impl
	rule__LibOperationCS__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getIsInvalidatingAssignment_10()); }
(rule__LibOperationCS__IsInvalidatingAssignment_10)?
{ after(grammarAccess.getLibOperationCSAccess().getIsInvalidatingAssignment_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group__11
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group__11__Impl
	rule__LibOperationCS__Group__12
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group__11__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getGroup_11()); }
(rule__LibOperationCS__Group_11__0)?
{ after(grammarAccess.getLibOperationCSAccess().getGroup_11()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group__12
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group__12__Impl
	rule__LibOperationCS__Group__13
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group__12__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getGroup_12()); }
(rule__LibOperationCS__Group_12__0)?
{ after(grammarAccess.getLibOperationCSAccess().getGroup_12()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group__13
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group__13__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group__13__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getAlternatives_13()); }
(rule__LibOperationCS__Alternatives_13)
{ after(grammarAccess.getLibOperationCSAccess().getAlternatives_13()); }
)

;
finally {
	restoreStackSize(stackSize);
}






























rule__LibOperationCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_5__0__Impl
	rule__LibOperationCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedParametersAssignment_5_0()); }
(rule__LibOperationCS__OwnedParametersAssignment_5_0)
{ after(grammarAccess.getLibOperationCSAccess().getOwnedParametersAssignment_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getGroup_5_1()); }
(rule__LibOperationCS__Group_5_1__0)*
{ after(grammarAccess.getLibOperationCSAccess().getGroup_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LibOperationCS__Group_5_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_5_1__0__Impl
	rule__LibOperationCS__Group_5_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_5_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getCommaKeyword_5_1_0()); }

	','

{ after(grammarAccess.getLibOperationCSAccess().getCommaKeyword_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group_5_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_5_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_5_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedParametersAssignment_5_1_1()); }
(rule__LibOperationCS__OwnedParametersAssignment_5_1_1)
{ after(grammarAccess.getLibOperationCSAccess().getOwnedParametersAssignment_5_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LibOperationCS__Group_11__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_11__0__Impl
	rule__LibOperationCS__Group_11__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_11__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getPrecedenceKeyword_11_0()); }

	'precedence'

{ after(grammarAccess.getLibOperationCSAccess().getPrecedenceKeyword_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group_11__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_11__1__Impl
	rule__LibOperationCS__Group_11__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_11__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getEqualsSignKeyword_11_1()); }

	'='

{ after(grammarAccess.getLibOperationCSAccess().getEqualsSignKeyword_11_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group_11__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_11__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_11__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getPrecedenceAssignment_11_2()); }
(rule__LibOperationCS__PrecedenceAssignment_11_2)
{ after(grammarAccess.getLibOperationCSAccess().getPrecedenceAssignment_11_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__LibOperationCS__Group_12__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_12__0__Impl
	rule__LibOperationCS__Group_12__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_12__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getEqualsSignGreaterThanSignKeyword_12_0()); }

	'=>'

{ after(grammarAccess.getLibOperationCSAccess().getEqualsSignGreaterThanSignKeyword_12_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group_12__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_12__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_12__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getImplementationAssignment_12_1()); }
(rule__LibOperationCS__ImplementationAssignment_12_1)
{ after(grammarAccess.getLibOperationCSAccess().getImplementationAssignment_12_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LibOperationCS__Group_13_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_13_0__0__Impl
	rule__LibOperationCS__Group_13_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_13_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getLeftCurlyBracketKeyword_13_0_0()); }

	'{'

{ after(grammarAccess.getLibOperationCSAccess().getLeftCurlyBracketKeyword_13_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group_13_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_13_0__1__Impl
	rule__LibOperationCS__Group_13_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_13_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getAlternatives_13_0_1()); }
(rule__LibOperationCS__Alternatives_13_0_1)*
{ after(grammarAccess.getLibOperationCSAccess().getAlternatives_13_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group_13_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_13_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_13_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getRightCurlyBracketKeyword_13_0_2()); }

	'}'

{ after(grammarAccess.getLibOperationCSAccess().getRightCurlyBracketKeyword_13_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__LibOperationCS__Group_13_0_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_13_0_1_1__0__Impl
	rule__LibOperationCS__Group_13_0_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_13_0_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getBodyKeyword_13_0_1_1_0()); }

	'body'

{ after(grammarAccess.getLibOperationCSAccess().getBodyKeyword_13_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group_13_0_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_13_0_1_1__1__Impl
	rule__LibOperationCS__Group_13_0_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_13_0_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getUnrestrictedNameParserRuleCall_13_0_1_1_1()); }
(	ruleUnrestrictedName)?
{ after(grammarAccess.getLibOperationCSAccess().getUnrestrictedNameParserRuleCall_13_0_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group_13_0_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_13_0_1_1__2__Impl
	rule__LibOperationCS__Group_13_0_1_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_13_0_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getColonKeyword_13_0_1_1_2()); }

	':'

{ after(grammarAccess.getLibOperationCSAccess().getColonKeyword_13_0_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group_13_0_1_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_13_0_1_1__3__Impl
	rule__LibOperationCS__Group_13_0_1_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_13_0_1_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedBodyExpressionsAssignment_13_0_1_1_3()); }
(rule__LibOperationCS__OwnedBodyExpressionsAssignment_13_0_1_1_3)
{ after(grammarAccess.getLibOperationCSAccess().getOwnedBodyExpressionsAssignment_13_0_1_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOperationCS__Group_13_0_1_1__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOperationCS__Group_13_0_1_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__Group_13_0_1_1__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_13_0_1_1_4()); }

	';'

{ after(grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_13_0_1_1_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__LibOppositeCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOppositeCS__Group__0__Impl
	rule__LibOppositeCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOppositeCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOppositeCSAccess().getOppositeKeyword_0()); }

	'opposite'

{ after(grammarAccess.getLibOppositeCSAccess().getOppositeKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOppositeCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOppositeCS__Group__1__Impl
	rule__LibOppositeCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOppositeCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOppositeCSAccess().getNameAssignment_1()); }
(rule__LibOppositeCS__NameAssignment_1)
{ after(grammarAccess.getLibOppositeCSAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOppositeCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOppositeCS__Group__2__Impl
	rule__LibOppositeCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOppositeCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOppositeCSAccess().getColonKeyword_2()); }

	':'

{ after(grammarAccess.getLibOppositeCSAccess().getColonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibOppositeCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibOppositeCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibOppositeCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOppositeCSAccess().getOwnedTypeAssignment_3()); }
(rule__LibOppositeCS__OwnedTypeAssignment_3)
{ after(grammarAccess.getLibOppositeCSAccess().getOwnedTypeAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__LibPackageCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPackageCS__Group__0__Impl
	rule__LibPackageCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getLibraryKeyword_0()); }

	'library'

{ after(grammarAccess.getLibPackageCSAccess().getLibraryKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPackageCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPackageCS__Group__1__Impl
	rule__LibPackageCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getNameAssignment_1()); }
(rule__LibPackageCS__NameAssignment_1)
{ after(grammarAccess.getLibPackageCSAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPackageCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPackageCS__Group__2__Impl
	rule__LibPackageCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getGroup_2()); }
(rule__LibPackageCS__Group_2__0)?
{ after(grammarAccess.getLibPackageCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPackageCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPackageCS__Group__3__Impl
	rule__LibPackageCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getLeftCurlyBracketKeyword_3()); }

	'{'

{ after(grammarAccess.getLibPackageCSAccess().getLeftCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPackageCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPackageCS__Group__4__Impl
	rule__LibPackageCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getAlternatives_4()); }
(rule__LibPackageCS__Alternatives_4)*
{ after(grammarAccess.getLibPackageCSAccess().getAlternatives_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPackageCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPackageCS__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getRightCurlyBracketKeyword_5()); }

	'}'

{ after(grammarAccess.getLibPackageCSAccess().getRightCurlyBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__LibPackageCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPackageCS__Group_2__0__Impl
	rule__LibPackageCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getColonKeyword_2_0()); }

	':'

{ after(grammarAccess.getLibPackageCSAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPackageCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPackageCS__Group_2__1__Impl
	rule__LibPackageCS__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getNsPrefixAssignment_2_1()); }
(rule__LibPackageCS__NsPrefixAssignment_2_1)
{ after(grammarAccess.getLibPackageCSAccess().getNsPrefixAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPackageCS__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPackageCS__Group_2__2__Impl
	rule__LibPackageCS__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getEqualsSignKeyword_2_2()); }

	'='

{ after(grammarAccess.getLibPackageCSAccess().getEqualsSignKeyword_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPackageCS__Group_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPackageCS__Group_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__Group_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getNsURIAssignment_2_3()); }
(rule__LibPackageCS__NsURIAssignment_2_3)
{ after(grammarAccess.getLibPackageCSAccess().getNsURIAssignment_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__LibPackageCS__Group_4_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPackageCS__Group_4_1__0__Impl
	rule__LibPackageCS__Group_4_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__Group_4_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getPrecedenceKeyword_4_1_0()); }

	'precedence'

{ after(grammarAccess.getLibPackageCSAccess().getPrecedenceKeyword_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPackageCS__Group_4_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPackageCS__Group_4_1__1__Impl
	rule__LibPackageCS__Group_4_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__Group_4_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getLibPackageCSAccess().getOwnedPrecedencesAssignment_4_1_1()); }
(rule__LibPackageCS__OwnedPrecedencesAssignment_4_1_1)
{ after(grammarAccess.getLibPackageCSAccess().getOwnedPrecedencesAssignment_4_1_1()); }
)
(
{ before(grammarAccess.getLibPackageCSAccess().getOwnedPrecedencesAssignment_4_1_1()); }
(rule__LibPackageCS__OwnedPrecedencesAssignment_4_1_1)*
{ after(grammarAccess.getLibPackageCSAccess().getOwnedPrecedencesAssignment_4_1_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPackageCS__Group_4_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPackageCS__Group_4_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__Group_4_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getSemicolonKeyword_4_1_2()); }

	';'

{ after(grammarAccess.getLibPackageCSAccess().getSemicolonKeyword_4_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PackageCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group__0__Impl
	rule__PackageCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getPackageKeyword_0()); }

	'package'

{ after(grammarAccess.getPackageCSAccess().getPackageKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PackageCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group__1__Impl
	rule__PackageCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getNameAssignment_1()); }
(rule__PackageCS__NameAssignment_1)
{ after(grammarAccess.getPackageCSAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PackageCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group__2__Impl
	rule__PackageCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getGroup_2()); }
(rule__PackageCS__Group_2__0)?
{ after(grammarAccess.getPackageCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PackageCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group__3__Impl
	rule__PackageCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getLeftCurlyBracketKeyword_3()); }

	'{'

{ after(grammarAccess.getPackageCSAccess().getLeftCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PackageCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group__4__Impl
	rule__PackageCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getAlternatives_4()); }
(rule__PackageCS__Alternatives_4)*
{ after(grammarAccess.getPackageCSAccess().getAlternatives_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PackageCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getRightCurlyBracketKeyword_5()); }

	'}'

{ after(grammarAccess.getPackageCSAccess().getRightCurlyBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__PackageCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group_2__0__Impl
	rule__PackageCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getColonKeyword_2_0()); }

	':'

{ after(grammarAccess.getPackageCSAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PackageCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group_2__1__Impl
	rule__PackageCS__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getNsPrefixAssignment_2_1()); }
(rule__PackageCS__NsPrefixAssignment_2_1)
{ after(grammarAccess.getPackageCSAccess().getNsPrefixAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PackageCS__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group_2__2__Impl
	rule__PackageCS__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getEqualsSignKeyword_2_2()); }

	'='

{ after(grammarAccess.getPackageCSAccess().getEqualsSignKeyword_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PackageCS__Group_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getNsURIAssignment_2_3()); }
(rule__PackageCS__NsURIAssignment_2_3)
{ after(grammarAccess.getPackageCSAccess().getNsURIAssignment_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ParameterCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group__0__Impl
	rule__ParameterCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getNameAssignment_0()); }
(rule__ParameterCS__NameAssignment_0)
{ after(grammarAccess.getParameterCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group__1__Impl
	rule__ParameterCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getColonKeyword_1()); }

	':'

{ after(grammarAccess.getParameterCSAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getOwnedTypeAssignment_2()); }
(rule__ParameterCS__OwnedTypeAssignment_2)
{ after(grammarAccess.getParameterCSAccess().getOwnedTypeAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__LibPropertyCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPropertyCS__Group__0__Impl
	rule__LibPropertyCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getIsStaticAssignment_0()); }
(rule__LibPropertyCS__IsStaticAssignment_0)?
{ after(grammarAccess.getLibPropertyCSAccess().getIsStaticAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPropertyCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPropertyCS__Group__1__Impl
	rule__LibPropertyCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getPropertyKeyword_1()); }

	'property'

{ after(grammarAccess.getLibPropertyCSAccess().getPropertyKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPropertyCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPropertyCS__Group__2__Impl
	rule__LibPropertyCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getNameAssignment_2()); }
(rule__LibPropertyCS__NameAssignment_2)
{ after(grammarAccess.getLibPropertyCSAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPropertyCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPropertyCS__Group__3__Impl
	rule__LibPropertyCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getColonKeyword_3()); }

	':'

{ after(grammarAccess.getLibPropertyCSAccess().getColonKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPropertyCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPropertyCS__Group__4__Impl
	rule__LibPropertyCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getOwnedTypeAssignment_4()); }
(rule__LibPropertyCS__OwnedTypeAssignment_4)
{ after(grammarAccess.getLibPropertyCSAccess().getOwnedTypeAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPropertyCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPropertyCS__Group__5__Impl
	rule__LibPropertyCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getOwnedOppositeAssignment_5()); }
(rule__LibPropertyCS__OwnedOppositeAssignment_5)?
{ after(grammarAccess.getLibPropertyCSAccess().getOwnedOppositeAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPropertyCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPropertyCS__Group__6__Impl
	rule__LibPropertyCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getGroup_6()); }
(rule__LibPropertyCS__Group_6__0)?
{ after(grammarAccess.getLibPropertyCSAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPropertyCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPropertyCS__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getAlternatives_7()); }
(rule__LibPropertyCS__Alternatives_7)
{ after(grammarAccess.getLibPropertyCSAccess().getAlternatives_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__LibPropertyCS__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPropertyCS__Group_6__0__Impl
	rule__LibPropertyCS__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getEqualsSignGreaterThanSignKeyword_6_0()); }

	'=>'

{ after(grammarAccess.getLibPropertyCSAccess().getEqualsSignGreaterThanSignKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPropertyCS__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPropertyCS__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getImplementationAssignment_6_1()); }
(rule__LibPropertyCS__ImplementationAssignment_6_1)
{ after(grammarAccess.getLibPropertyCSAccess().getImplementationAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LibPropertyCS__Group_7_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPropertyCS__Group_7_0__0__Impl
	rule__LibPropertyCS__Group_7_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__Group_7_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getLeftCurlyBracketKeyword_7_0_0()); }

	'{'

{ after(grammarAccess.getLibPropertyCSAccess().getLeftCurlyBracketKeyword_7_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPropertyCS__Group_7_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPropertyCS__Group_7_0__1__Impl
	rule__LibPropertyCS__Group_7_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__Group_7_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getOwnedAnnotationsAssignment_7_0_1()); }
(rule__LibPropertyCS__OwnedAnnotationsAssignment_7_0_1)*
{ after(grammarAccess.getLibPropertyCSAccess().getOwnedAnnotationsAssignment_7_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LibPropertyCS__Group_7_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LibPropertyCS__Group_7_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__Group_7_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getRightCurlyBracketKeyword_7_0_2()); }

	'}'

{ after(grammarAccess.getLibPropertyCSAccess().getRightCurlyBracketKeyword_7_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PostCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostCS__Group__0__Impl
	rule__PostCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PostCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostCSAccess().getStereotypeAssignment_0()); }
(rule__PostCS__StereotypeAssignment_0)
{ after(grammarAccess.getPostCSAccess().getStereotypeAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PostCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostCS__Group__1__Impl
	rule__PostCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PostCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostCSAccess().getGroup_1()); }
(rule__PostCS__Group_1__0)?
{ after(grammarAccess.getPostCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PostCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostCS__Group__2__Impl
	rule__PostCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PostCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostCSAccess().getColonKeyword_2()); }

	':'

{ after(grammarAccess.getPostCSAccess().getColonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PostCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostCS__Group__3__Impl
	rule__PostCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__PostCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostCSAccess().getOwnedSpecificationAssignment_3()); }
(rule__PostCS__OwnedSpecificationAssignment_3)
{ after(grammarAccess.getPostCSAccess().getOwnedSpecificationAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PostCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PostCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostCSAccess().getSemicolonKeyword_4()); }

	';'

{ after(grammarAccess.getPostCSAccess().getSemicolonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__PostCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostCS__Group_1__0__Impl
	rule__PostCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PostCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostCSAccess().getNameAssignment_1_0()); }
(rule__PostCS__NameAssignment_1_0)
{ after(grammarAccess.getPostCSAccess().getNameAssignment_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PostCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PostCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostCSAccess().getGroup_1_1()); }
(rule__PostCS__Group_1_1__0)?
{ after(grammarAccess.getPostCSAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PostCS__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostCS__Group_1_1__0__Impl
	rule__PostCS__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PostCS__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostCSAccess().getLeftParenthesisKeyword_1_1_0()); }

	'('

{ after(grammarAccess.getPostCSAccess().getLeftParenthesisKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PostCS__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostCS__Group_1_1__1__Impl
	rule__PostCS__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PostCS__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostCSAccess().getOwnedMessageSpecificationAssignment_1_1_1()); }
(rule__PostCS__OwnedMessageSpecificationAssignment_1_1_1)
{ after(grammarAccess.getPostCSAccess().getOwnedMessageSpecificationAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PostCS__Group_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostCS__Group_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PostCS__Group_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostCSAccess().getRightParenthesisKeyword_1_1_2()); }

	')'

{ after(grammarAccess.getPostCSAccess().getRightParenthesisKeyword_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PreCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreCS__Group__0__Impl
	rule__PreCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PreCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreCSAccess().getStereotypeAssignment_0()); }
(rule__PreCS__StereotypeAssignment_0)
{ after(grammarAccess.getPreCSAccess().getStereotypeAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PreCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreCS__Group__1__Impl
	rule__PreCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PreCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreCSAccess().getGroup_1()); }
(rule__PreCS__Group_1__0)?
{ after(grammarAccess.getPreCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PreCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreCS__Group__2__Impl
	rule__PreCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PreCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreCSAccess().getColonKeyword_2()); }

	':'

{ after(grammarAccess.getPreCSAccess().getColonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PreCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreCS__Group__3__Impl
	rule__PreCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__PreCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreCSAccess().getOwnedSpecificationAssignment_3()); }
(rule__PreCS__OwnedSpecificationAssignment_3)
{ after(grammarAccess.getPreCSAccess().getOwnedSpecificationAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PreCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PreCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreCSAccess().getSemicolonKeyword_4()); }

	';'

{ after(grammarAccess.getPreCSAccess().getSemicolonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__PreCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreCS__Group_1__0__Impl
	rule__PreCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PreCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreCSAccess().getNameAssignment_1_0()); }
(rule__PreCS__NameAssignment_1_0)
{ after(grammarAccess.getPreCSAccess().getNameAssignment_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PreCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PreCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreCSAccess().getGroup_1_1()); }
(rule__PreCS__Group_1_1__0)?
{ after(grammarAccess.getPreCSAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PreCS__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreCS__Group_1_1__0__Impl
	rule__PreCS__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PreCS__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreCSAccess().getLeftParenthesisKeyword_1_1_0()); }

	'('

{ after(grammarAccess.getPreCSAccess().getLeftParenthesisKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PreCS__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreCS__Group_1_1__1__Impl
	rule__PreCS__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PreCS__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreCSAccess().getOwnedMessageSpecificationAssignment_1_1_1()); }
(rule__PreCS__OwnedMessageSpecificationAssignment_1_1_1)
{ after(grammarAccess.getPreCSAccess().getOwnedMessageSpecificationAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PreCS__Group_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreCS__Group_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PreCS__Group_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreCSAccess().getRightParenthesisKeyword_1_1_2()); }

	')'

{ after(grammarAccess.getPreCSAccess().getRightParenthesisKeyword_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PrecedenceCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrecedenceCS__Group__0__Impl
	rule__PrecedenceCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PrecedenceCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrecedenceCSAccess().getAlternatives_0()); }
(rule__PrecedenceCS__Alternatives_0)
{ after(grammarAccess.getPrecedenceCSAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrecedenceCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrecedenceCS__Group__1__Impl
	rule__PrecedenceCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PrecedenceCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrecedenceCSAccess().getColonKeyword_1()); }

	':'

{ after(grammarAccess.getPrecedenceCSAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrecedenceCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrecedenceCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PrecedenceCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrecedenceCSAccess().getNameAssignment_2()); }
(rule__PrecedenceCS__NameAssignment_2)
{ after(grammarAccess.getPrecedenceCSAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypedMultiplicityRefCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedMultiplicityRefCS__Group__0__Impl
	rule__TypedMultiplicityRefCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedMultiplicityRefCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedMultiplicityRefCSAccess().getAlternatives_0()); }
(rule__TypedMultiplicityRefCS__Alternatives_0)
{ after(grammarAccess.getTypedMultiplicityRefCSAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypedMultiplicityRefCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedMultiplicityRefCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedMultiplicityRefCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedMultiplicityRefCSAccess().getOwnedMultiplicityAssignment_1()); }
(rule__TypedMultiplicityRefCS__OwnedMultiplicityAssignment_1)?
{ after(grammarAccess.getTypedMultiplicityRefCSAccess().getOwnedMultiplicityAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypedTypeRefCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_0__0__Impl
	rule__TypedTypeRefCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getIsTypeofAssignment_0_0()); }
(rule__TypedTypeRefCS__IsTypeofAssignment_0_0)
{ after(grammarAccess.getTypedTypeRefCSAccess().getIsTypeofAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypedTypeRefCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_0__1__Impl
	rule__TypedTypeRefCS__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_0_1()); }

	'('

{ after(grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypedTypeRefCS__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_0__2__Impl
	rule__TypedTypeRefCS__Group_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_0_2()); }
(rule__TypedTypeRefCS__OwnedPathNameAssignment_0_2)
{ after(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypedTypeRefCS__Group_0__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_0__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_0__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_0_3()); }

	')'

{ after(grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_0_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__TypedTypeRefCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_1__0__Impl
	rule__TypedTypeRefCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_1_0()); }
(rule__TypedTypeRefCS__OwnedPathNameAssignment_1_0)
{ after(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypedTypeRefCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getGroup_1_1()); }
(rule__TypedTypeRefCS__Group_1_1__0)?
{ after(grammarAccess.getTypedTypeRefCSAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypedTypeRefCS__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_1_1__0__Impl
	rule__TypedTypeRefCS__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_1_0()); }

	'('

{ after(grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypedTypeRefCS__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_1_1__1__Impl
	rule__TypedTypeRefCS__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingAssignment_1_1_1()); }
(rule__TypedTypeRefCS__OwnedBindingAssignment_1_1_1)
{ after(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypedTypeRefCS__Group_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_1_2()); }

	')'

{ after(grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TuplePartCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TuplePartCS__Group__0__Impl
	rule__TuplePartCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TuplePartCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTuplePartCSAccess().getNameAssignment_0()); }
(rule__TuplePartCS__NameAssignment_0)
{ after(grammarAccess.getTuplePartCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TuplePartCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TuplePartCS__Group__1__Impl
	rule__TuplePartCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TuplePartCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTuplePartCSAccess().getColonKeyword_1()); }

	':'

{ after(grammarAccess.getTuplePartCSAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TuplePartCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TuplePartCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TuplePartCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTuplePartCSAccess().getOwnedTypeAssignment_2()); }
(rule__TuplePartCS__OwnedTypeAssignment_2)
{ after(grammarAccess.getTuplePartCSAccess().getOwnedTypeAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__URIPathNameCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__URIPathNameCS__Group__0__Impl
	rule__URIPathNameCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__URIPathNameCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsAssignment_0()); }
(rule__URIPathNameCS__OwnedPathElementsAssignment_0)
{ after(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__URIPathNameCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__URIPathNameCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__URIPathNameCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIPathNameCSAccess().getGroup_1()); }
(rule__URIPathNameCS__Group_1__0)*
{ after(grammarAccess.getURIPathNameCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__URIPathNameCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__URIPathNameCS__Group_1__0__Impl
	rule__URIPathNameCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__URIPathNameCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0()); }

	'::'

{ after(grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__URIPathNameCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__URIPathNameCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__URIPathNameCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); }
(rule__URIPathNameCS__OwnedPathElementsAssignment_1_1)
{ after(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__URIFirstPathElementCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__URIFirstPathElementCS__Group_1__0__Impl
	rule__URIFirstPathElementCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__URIFirstPathElementCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getPathElementWithURICSAction_1_0()); }
(

)
{ after(grammarAccess.getURIFirstPathElementCSAccess().getPathElementWithURICSAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__URIFirstPathElementCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__URIFirstPathElementCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__URIFirstPathElementCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementAssignment_1_1()); }
(rule__URIFirstPathElementCS__ReferredElementAssignment_1_1)
{ after(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionTypeCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionTypeCS__Group__0__Impl
	rule__CollectionTypeCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getNameAssignment_0()); }
(rule__CollectionTypeCS__NameAssignment_0)
{ after(grammarAccess.getCollectionTypeCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionTypeCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionTypeCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getGroup_1()); }
(rule__CollectionTypeCS__Group_1__0)?
{ after(grammarAccess.getCollectionTypeCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionTypeCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionTypeCS__Group_1__0__Impl
	rule__CollectionTypeCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0()); }

	'('

{ after(grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionTypeCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionTypeCS__Group_1__1__Impl
	rule__CollectionTypeCS__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeAssignment_1_1()); }
(rule__CollectionTypeCS__OwnedTypeAssignment_1_1)
{ after(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionTypeCS__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionTypeCS__Group_1__2__Impl
	rule__CollectionTypeCS__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getOwnedCollectionMultiplicityAssignment_1_2()); }
(rule__CollectionTypeCS__OwnedCollectionMultiplicityAssignment_1_2)?
{ after(grammarAccess.getCollectionTypeCSAccess().getOwnedCollectionMultiplicityAssignment_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionTypeCS__Group_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionTypeCS__Group_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__Group_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_3()); }

	')'

{ after(grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__MapTypeCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapTypeCS__Group__0__Impl
	rule__MapTypeCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getNameAssignment_0()); }
(rule__MapTypeCS__NameAssignment_0)
{ after(grammarAccess.getMapTypeCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapTypeCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapTypeCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getGroup_1()); }
(rule__MapTypeCS__Group_1__0)?
{ after(grammarAccess.getMapTypeCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MapTypeCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapTypeCS__Group_1__0__Impl
	rule__MapTypeCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0()); }

	'('

{ after(grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapTypeCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapTypeCS__Group_1__1__Impl
	rule__MapTypeCS__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeAssignment_1_1()); }
(rule__MapTypeCS__OwnedKeyTypeAssignment_1_1)
{ after(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapTypeCS__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapTypeCS__Group_1__2__Impl
	rule__MapTypeCS__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2()); }

	','

{ after(grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapTypeCS__Group_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapTypeCS__Group_1__3__Impl
	rule__MapTypeCS__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__Group_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeAssignment_1_3()); }
(rule__MapTypeCS__OwnedValueTypeAssignment_1_3)
{ after(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeAssignment_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapTypeCS__Group_1__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapTypeCS__Group_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__Group_1__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getRightParenthesisKeyword_1_4()); }

	')'

{ after(grammarAccess.getMapTypeCSAccess().getRightParenthesisKeyword_1_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__TupleTypeCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group__0__Impl
	rule__TupleTypeCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getNameAssignment_0()); }
(rule__TupleTypeCS__NameAssignment_0)
{ after(grammarAccess.getTupleTypeCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleTypeCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getGroup_1()); }
(rule__TupleTypeCS__Group_1__0)?
{ after(grammarAccess.getTupleTypeCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TupleTypeCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group_1__0__Impl
	rule__TupleTypeCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0()); }

	'('

{ after(grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleTypeCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group_1__1__Impl
	rule__TupleTypeCS__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getGroup_1_1()); }
(rule__TupleTypeCS__Group_1_1__0)?
{ after(grammarAccess.getTupleTypeCSAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleTypeCS__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2()); }

	')'

{ after(grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TupleTypeCS__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group_1_1__0__Impl
	rule__TupleTypeCS__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getOwnedPartsAssignment_1_1_0()); }
(rule__TupleTypeCS__OwnedPartsAssignment_1_1_0)
{ after(grammarAccess.getTupleTypeCSAccess().getOwnedPartsAssignment_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleTypeCS__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getGroup_1_1_1()); }
(rule__TupleTypeCS__Group_1_1_1__0)*
{ after(grammarAccess.getTupleTypeCSAccess().getGroup_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TupleTypeCS__Group_1_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group_1_1_1__0__Impl
	rule__TupleTypeCS__Group_1_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group_1_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0()); }

	','

{ after(grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleTypeCS__Group_1_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group_1_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group_1_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getOwnedPartsAssignment_1_1_1_1()); }
(rule__TupleTypeCS__OwnedPartsAssignment_1_1_1_1)
{ after(grammarAccess.getTupleTypeCSAccess().getOwnedPartsAssignment_1_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionLiteralExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group__0__Impl
	rule__CollectionLiteralExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeAssignment_0()); }
(rule__CollectionLiteralExpCS__OwnedTypeAssignment_0)
{ after(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionLiteralExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group__1__Impl
	rule__CollectionLiteralExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }

	'{'

{ after(grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionLiteralExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group__2__Impl
	rule__CollectionLiteralExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2()); }
(rule__CollectionLiteralExpCS__Group_2__0)?
{ after(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionLiteralExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3()); }

	'}'

{ after(grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__CollectionLiteralExpCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group_2__0__Impl
	rule__CollectionLiteralExpCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsAssignment_2_0()); }
(rule__CollectionLiteralExpCS__OwnedPartsAssignment_2_0)
{ after(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionLiteralExpCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2_1()); }
(rule__CollectionLiteralExpCS__Group_2_1__0)*
{ after(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionLiteralExpCS__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group_2_1__0__Impl
	rule__CollectionLiteralExpCS__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0()); }

	','

{ after(grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionLiteralExpCS__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsAssignment_2_1_1()); }
(rule__CollectionLiteralExpCS__OwnedPartsAssignment_2_1_1)
{ after(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionLiteralPartCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralPartCS__Group_0__0__Impl
	rule__CollectionLiteralPartCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionAssignment_0_0()); }
(rule__CollectionLiteralPartCS__OwnedExpressionAssignment_0_0)
{ after(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionLiteralPartCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralPartCS__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_0_1()); }
(rule__CollectionLiteralPartCS__Group_0_1__0)?
{ after(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionLiteralPartCS__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralPartCS__Group_0_1__0__Impl
	rule__CollectionLiteralPartCS__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__Group_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0()); }

	'..'

{ after(grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionLiteralPartCS__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralPartCS__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__Group_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionAssignment_0_1_1()); }
(rule__CollectionLiteralPartCS__OwnedLastExpressionAssignment_0_1_1)
{ after(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionPatternCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group__0__Impl
	rule__CollectionPatternCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeAssignment_0()); }
(rule__CollectionPatternCS__OwnedTypeAssignment_0)
{ after(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionPatternCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group__1__Impl
	rule__CollectionPatternCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1()); }

	'{'

{ after(grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionPatternCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group__2__Impl
	rule__CollectionPatternCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getGroup_2()); }
(rule__CollectionPatternCS__Group_2__0)?
{ after(grammarAccess.getCollectionPatternCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionPatternCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getRightCurlyBracketKeyword_3()); }

	'}'

{ after(grammarAccess.getCollectionPatternCSAccess().getRightCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__CollectionPatternCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group_2__0__Impl
	rule__CollectionPatternCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsAssignment_2_0()); }
(rule__CollectionPatternCS__OwnedPartsAssignment_2_0)
{ after(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionPatternCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group_2__1__Impl
	rule__CollectionPatternCS__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getGroup_2_1()); }
(rule__CollectionPatternCS__Group_2_1__0)*
{ after(grammarAccess.getCollectionPatternCSAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionPatternCS__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getGroup_2_2()); }
(rule__CollectionPatternCS__Group_2_2__0)
{ after(grammarAccess.getCollectionPatternCSAccess().getGroup_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__CollectionPatternCS__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group_2_1__0__Impl
	rule__CollectionPatternCS__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0()); }

	','

{ after(grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionPatternCS__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsAssignment_2_1_1()); }
(rule__CollectionPatternCS__OwnedPartsAssignment_2_1_1)
{ after(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionPatternCS__Group_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group_2_2__0__Impl
	rule__CollectionPatternCS__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0()); }

	'++'

{ after(grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionPatternCS__Group_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameAssignment_2_2_1()); }
(rule__CollectionPatternCS__RestVariableNameAssignment_2_2_1)
{ after(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameAssignment_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ShadowPartCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ShadowPartCS__Group_0__0__Impl
	rule__ShadowPartCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getReferredPropertyAssignment_0_0()); }
(rule__ShadowPartCS__ReferredPropertyAssignment_0_0)
{ after(grammarAccess.getShadowPartCSAccess().getReferredPropertyAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ShadowPartCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ShadowPartCS__Group_0__1__Impl
	rule__ShadowPartCS__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_0_1()); }

	'='

{ after(grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ShadowPartCS__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ShadowPartCS__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAssignment_0_2()); }
(rule__ShadowPartCS__OwnedInitExpressionAssignment_0_2)
{ after(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAssignment_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PatternExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PatternExpCS__Group__0__Impl
	rule__PatternExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PatternExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPatternExpCSAccess().getPatternVariableNameAssignment_0()); }
(rule__PatternExpCS__PatternVariableNameAssignment_0)?
{ after(grammarAccess.getPatternExpCSAccess().getPatternVariableNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PatternExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PatternExpCS__Group__1__Impl
	rule__PatternExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PatternExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPatternExpCSAccess().getColonKeyword_1()); }

	':'

{ after(grammarAccess.getPatternExpCSAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PatternExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PatternExpCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PatternExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeAssignment_2()); }
(rule__PatternExpCS__OwnedPatternTypeAssignment_2)
{ after(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__LambdaLiteralExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaLiteralExpCS__Group__0__Impl
	rule__LambdaLiteralExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaLiteralExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaLiteralExpCSAccess().getLambdaKeyword_0()); }

	'Lambda'

{ after(grammarAccess.getLambdaLiteralExpCSAccess().getLambdaKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaLiteralExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaLiteralExpCS__Group__1__Impl
	rule__LambdaLiteralExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaLiteralExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }

	'{'

{ after(grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaLiteralExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaLiteralExpCS__Group__2__Impl
	rule__LambdaLiteralExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaLiteralExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSAssignment_2()); }
(rule__LambdaLiteralExpCS__OwnedExpressionCSAssignment_2)
{ after(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaLiteralExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaLiteralExpCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaLiteralExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaLiteralExpCSAccess().getRightCurlyBracketKeyword_3()); }

	'}'

{ after(grammarAccess.getLambdaLiteralExpCSAccess().getRightCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__MapLiteralExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group__0__Impl
	rule__MapLiteralExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeAssignment_0()); }
(rule__MapLiteralExpCS__OwnedTypeAssignment_0)
{ after(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapLiteralExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group__1__Impl
	rule__MapLiteralExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }

	'{'

{ after(grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapLiteralExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group__2__Impl
	rule__MapLiteralExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getGroup_2()); }
(rule__MapLiteralExpCS__Group_2__0)?
{ after(grammarAccess.getMapLiteralExpCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapLiteralExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getRightCurlyBracketKeyword_3()); }

	'}'

{ after(grammarAccess.getMapLiteralExpCSAccess().getRightCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__MapLiteralExpCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group_2__0__Impl
	rule__MapLiteralExpCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsAssignment_2_0()); }
(rule__MapLiteralExpCS__OwnedPartsAssignment_2_0)
{ after(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapLiteralExpCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getGroup_2_1()); }
(rule__MapLiteralExpCS__Group_2_1__0)*
{ after(grammarAccess.getMapLiteralExpCSAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MapLiteralExpCS__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group_2_1__0__Impl
	rule__MapLiteralExpCS__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0()); }

	','

{ after(grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapLiteralExpCS__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsAssignment_2_1_1()); }
(rule__MapLiteralExpCS__OwnedPartsAssignment_2_1_1)
{ after(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MapLiteralPartCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralPartCS__Group__0__Impl
	rule__MapLiteralPartCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralPartCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyAssignment_0()); }
(rule__MapLiteralPartCS__OwnedKeyAssignment_0)
{ after(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapLiteralPartCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralPartCS__Group__1__Impl
	rule__MapLiteralPartCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralPartCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralPartCSAccess().getAlternatives_1()); }
(rule__MapLiteralPartCS__Alternatives_1)
{ after(grammarAccess.getMapLiteralPartCSAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapLiteralPartCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralPartCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralPartCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueAssignment_2()); }
(rule__MapLiteralPartCS__OwnedValueAssignment_2)
{ after(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TupleLiteralExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralExpCS__Group__0__Impl
	rule__TupleLiteralExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0()); }

	'Tuple'

{ after(grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralExpCS__Group__1__Impl
	rule__TupleLiteralExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }

	'{'

{ after(grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralExpCS__Group__2__Impl
	rule__TupleLiteralExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsAssignment_2()); }
(rule__TupleLiteralExpCS__OwnedPartsAssignment_2)
{ after(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralExpCS__Group__3__Impl
	rule__TupleLiteralExpCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getGroup_3()); }
(rule__TupleLiteralExpCS__Group_3__0)*
{ after(grammarAccess.getTupleLiteralExpCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralExpCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralExpCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getRightCurlyBracketKeyword_4()); }

	'}'

{ after(grammarAccess.getTupleLiteralExpCSAccess().getRightCurlyBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__TupleLiteralExpCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralExpCS__Group_3__0__Impl
	rule__TupleLiteralExpCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0()); }

	','

{ after(grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralExpCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralExpCS__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsAssignment_3_1()); }
(rule__TupleLiteralExpCS__OwnedPartsAssignment_3_1)
{ after(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TupleLiteralPartCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralPartCS__Group__0__Impl
	rule__TupleLiteralPartCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getNameAssignment_0()); }
(rule__TupleLiteralPartCS__NameAssignment_0)
{ after(grammarAccess.getTupleLiteralPartCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralPartCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralPartCS__Group__1__Impl
	rule__TupleLiteralPartCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getGroup_1()); }
(rule__TupleLiteralPartCS__Group_1__0)?
{ after(grammarAccess.getTupleLiteralPartCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralPartCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralPartCS__Group__2__Impl
	rule__TupleLiteralPartCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2()); }

	'='

{ after(grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralPartCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralPartCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionAssignment_3()); }
(rule__TupleLiteralPartCS__OwnedInitExpressionAssignment_3)
{ after(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__TupleLiteralPartCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralPartCS__Group_1__0__Impl
	rule__TupleLiteralPartCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0()); }

	':'

{ after(grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralPartCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralPartCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeAssignment_1_1()); }
(rule__TupleLiteralPartCS__OwnedTypeAssignment_1_1)
{ after(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__UnlimitedNaturalLiteralExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UnlimitedNaturalLiteralExpCS__Group__0__Impl
	rule__UnlimitedNaturalLiteralExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UnlimitedNaturalLiteralExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0()); }
(

)
{ after(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UnlimitedNaturalLiteralExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UnlimitedNaturalLiteralExpCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UnlimitedNaturalLiteralExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getAsteriskKeyword_1()); }

	'*'

{ after(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getAsteriskKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__InvalidLiteralExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvalidLiteralExpCS__Group__0__Impl
	rule__InvalidLiteralExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InvalidLiteralExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0()); }
(

)
{ after(grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvalidLiteralExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvalidLiteralExpCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InvalidLiteralExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvalidLiteralExpCSAccess().getInvalidKeyword_1()); }

	'invalid'

{ after(grammarAccess.getInvalidLiteralExpCSAccess().getInvalidKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NullLiteralExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NullLiteralExpCS__Group__0__Impl
	rule__NullLiteralExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NullLiteralExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0()); }
(

)
{ after(grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NullLiteralExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NullLiteralExpCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NullLiteralExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1()); }

	'null'

{ after(grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeLiteralWithMultiplicityCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeLiteralWithMultiplicityCS__Group__0__Impl
	rule__TypeLiteralWithMultiplicityCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeLiteralWithMultiplicityCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); }
	ruleTypeLiteralCS
{ after(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeLiteralWithMultiplicityCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeLiteralWithMultiplicityCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeLiteralWithMultiplicityCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityAssignment_1()); }
(rule__TypeLiteralWithMultiplicityCS__OwnedMultiplicityAssignment_1)?
{ after(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeNameExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeNameExpCS__Group__0__Impl
	rule__TypeNameExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNameAssignment_0()); }
(rule__TypeNameExpCS__OwnedPathNameAssignment_0)
{ after(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeNameExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeNameExpCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getGroup_1()); }
(rule__TypeNameExpCS__Group_1__0)?
{ after(grammarAccess.getTypeNameExpCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeNameExpCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeNameExpCS__Group_1__0__Impl
	rule__TypeNameExpCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseAssignment_1_0()); }
(rule__TypeNameExpCS__OwnedCurlyBracketedClauseAssignment_1_0)
{ after(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseAssignment_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeNameExpCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeNameExpCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getGroup_1_1()); }
(rule__TypeNameExpCS__Group_1_1__0)?
{ after(grammarAccess.getTypeNameExpCSAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeNameExpCS__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeNameExpCS__Group_1_1__0__Impl
	rule__TypeNameExpCS__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0()); }

	'{'

{ after(grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeNameExpCS__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeNameExpCS__Group_1_1__1__Impl
	rule__TypeNameExpCS__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardAssignment_1_1_1()); }
(rule__TypeNameExpCS__OwnedPatternGuardAssignment_1_1_1)
{ after(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeNameExpCS__Group_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeNameExpCS__Group_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__Group_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getRightCurlyBracketKeyword_1_1_2()); }

	'}'

{ after(grammarAccess.getTypeNameExpCSAccess().getRightCurlyBracketKeyword_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeExpCS__Group__0__Impl
	rule__TypeExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeExpCSAccess().getTypeExpWithoutMultiplicityCSParserRuleCall_0()); }
	ruleTypeExpWithoutMultiplicityCS
{ after(grammarAccess.getTypeExpCSAccess().getTypeExpWithoutMultiplicityCSParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeExpCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityAssignment_1()); }
(rule__TypeExpCS__OwnedMultiplicityAssignment_1)?
{ after(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ExpCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExpCS__Group_0__0__Impl
	rule__ExpCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0()); }
	rulePrefixedPrimaryExpCS
{ after(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExpCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExpCS__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getGroup_0_1()); }
(rule__ExpCS__Group_0_1__0)?
{ after(grammarAccess.getExpCSAccess().getGroup_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ExpCS__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExpCS__Group_0_1__0__Impl
	rule__ExpCS__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__Group_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0()); }
(

)
{ after(grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExpCS__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExpCS__Group_0_1__1__Impl
	rule__ExpCS__Group_0_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__Group_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getNameAssignment_0_1_1()); }
(rule__ExpCS__NameAssignment_0_1_1)
{ after(grammarAccess.getExpCSAccess().getNameAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExpCS__Group_0_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExpCS__Group_0_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__Group_0_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getOwnedRightAssignment_0_1_2()); }
(rule__ExpCS__OwnedRightAssignment_0_1_2)
{ after(grammarAccess.getExpCSAccess().getOwnedRightAssignment_0_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PrefixedLetExpCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrefixedLetExpCS__Group_0__0__Impl
	rule__PrefixedLetExpCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedLetExpCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getPrefixExpCSAction_0_0()); }
(

)
{ after(grammarAccess.getPrefixedLetExpCSAccess().getPrefixExpCSAction_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrefixedLetExpCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrefixedLetExpCS__Group_0__1__Impl
	rule__PrefixedLetExpCS__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedLetExpCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getNameAssignment_0_1()); }
(rule__PrefixedLetExpCS__NameAssignment_0_1)
{ after(grammarAccess.getPrefixedLetExpCSAccess().getNameAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrefixedLetExpCS__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrefixedLetExpCS__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedLetExpCS__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightAssignment_0_2()); }
(rule__PrefixedLetExpCS__OwnedRightAssignment_0_2)
{ after(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightAssignment_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PrefixedPrimaryExpCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrefixedPrimaryExpCS__Group_0__0__Impl
	rule__PrefixedPrimaryExpCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedPrimaryExpCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrefixExpCSAction_0_0()); }
(

)
{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrefixExpCSAction_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrefixedPrimaryExpCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrefixedPrimaryExpCS__Group_0__1__Impl
	rule__PrefixedPrimaryExpCS__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedPrimaryExpCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameAssignment_0_1()); }
(rule__PrefixedPrimaryExpCS__NameAssignment_0_1)
{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrefixedPrimaryExpCS__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrefixedPrimaryExpCS__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedPrimaryExpCS__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightAssignment_0_2()); }
(rule__PrefixedPrimaryExpCS__OwnedRightAssignment_0_2)
{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightAssignment_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NameExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NameExpCS__Group__0__Impl
	rule__NameExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedPathNameAssignment_0()); }
(rule__NameExpCS__OwnedPathNameAssignment_0)
{ after(grammarAccess.getNameExpCSAccess().getOwnedPathNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NameExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NameExpCS__Group__1__Impl
	rule__NameExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesAssignment_1()); }
(rule__NameExpCS__OwnedSquareBracketedClausesAssignment_1)*
{ after(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NameExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NameExpCS__Group__2__Impl
	rule__NameExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseAssignment_2()); }
(rule__NameExpCS__OwnedRoundBracketedClauseAssignment_2)?
{ after(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NameExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NameExpCS__Group__3__Impl
	rule__NameExpCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseAssignment_3()); }
(rule__NameExpCS__OwnedCurlyBracketedClauseAssignment_3)?
{ after(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NameExpCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NameExpCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getGroup_4()); }
(rule__NameExpCS__Group_4__0)?
{ after(grammarAccess.getNameExpCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__NameExpCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NameExpCS__Group_4__0__Impl
	rule__NameExpCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getIsPreAssignment_4_0()); }
(rule__NameExpCS__IsPreAssignment_4_0)
{ after(grammarAccess.getNameExpCSAccess().getIsPreAssignment_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NameExpCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NameExpCS__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getPreKeyword_4_1()); }

	'pre'

{ after(grammarAccess.getNameExpCSAccess().getPreKeyword_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CurlyBracketedClauseCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group__0__Impl
	rule__CurlyBracketedClauseCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getCurlyBracketedClauseCSAction_0()); }
(

)
{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getCurlyBracketedClauseCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CurlyBracketedClauseCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group__1__Impl
	rule__CurlyBracketedClauseCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1()); }

	'{'

{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CurlyBracketedClauseCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group__2__Impl
	rule__CurlyBracketedClauseCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup_2()); }
(rule__CurlyBracketedClauseCS__Group_2__0)?
{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CurlyBracketedClauseCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getRightCurlyBracketKeyword_3()); }

	'}'

{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getRightCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__CurlyBracketedClauseCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group_2__0__Impl
	rule__CurlyBracketedClauseCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsAssignment_2_0()); }
(rule__CurlyBracketedClauseCS__OwnedPartsAssignment_2_0)
{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CurlyBracketedClauseCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup_2_1()); }
(rule__CurlyBracketedClauseCS__Group_2_1__0)*
{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CurlyBracketedClauseCS__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group_2_1__0__Impl
	rule__CurlyBracketedClauseCS__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_1_0()); }

	','

{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CurlyBracketedClauseCS__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsAssignment_2_1_1()); }
(rule__CurlyBracketedClauseCS__OwnedPartsAssignment_2_1_1)
{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__RoundBracketedClauseCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group__0__Impl
	rule__RoundBracketedClauseCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getRoundBracketedClauseCSAction_0()); }
(

)
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getRoundBracketedClauseCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RoundBracketedClauseCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group__1__Impl
	rule__RoundBracketedClauseCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1()); }

	'('

{ after(grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RoundBracketedClauseCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group__2__Impl
	rule__RoundBracketedClauseCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getGroup_2()); }
(rule__RoundBracketedClauseCS__Group_2__0)?
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RoundBracketedClauseCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getRightParenthesisKeyword_3()); }

	')'

{ after(grammarAccess.getRoundBracketedClauseCSAccess().getRightParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__RoundBracketedClauseCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group_2__0__Impl
	rule__RoundBracketedClauseCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_0()); }
(rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_0)
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RoundBracketedClauseCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_1()); }
(rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_1)*
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SquareBracketedClauseCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SquareBracketedClauseCS__Group__0__Impl
	rule__SquareBracketedClauseCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0()); }

	'['

{ after(grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SquareBracketedClauseCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SquareBracketedClauseCS__Group__1__Impl
	rule__SquareBracketedClauseCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsAssignment_1()); }
(rule__SquareBracketedClauseCS__OwnedTermsAssignment_1)
{ after(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SquareBracketedClauseCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SquareBracketedClauseCS__Group__2__Impl
	rule__SquareBracketedClauseCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getGroup_2()); }
(rule__SquareBracketedClauseCS__Group_2__0)*
{ after(grammarAccess.getSquareBracketedClauseCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SquareBracketedClauseCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SquareBracketedClauseCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getRightSquareBracketKeyword_3()); }

	']'

{ after(grammarAccess.getSquareBracketedClauseCSAccess().getRightSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__SquareBracketedClauseCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SquareBracketedClauseCS__Group_2__0__Impl
	rule__SquareBracketedClauseCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0()); }

	','

{ after(grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SquareBracketedClauseCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SquareBracketedClauseCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsAssignment_2_1()); }
(rule__SquareBracketedClauseCS__OwnedTermsAssignment_2_1)
{ after(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingArgCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0__0__Impl
	rule__NavigatingArgCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionAssignment_0_0()); }
(rule__NavigatingArgCS__OwnedNameExpressionAssignment_0_0)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1()); }
(rule__NavigatingArgCS__Alternatives_0_1)?
{ after(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingArgCS__Group_0_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_0__0__Impl
	rule__NavigatingArgCS__Group_0_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1_0_0()); }
(rule__NavigatingArgCS__Alternatives_0_1_0_0)
{ after(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_0__1__Impl
	rule__NavigatingArgCS__Group_0_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorAssignment_0_1_0_1()); }
(rule__NavigatingArgCS__OwnedCoIteratorAssignment_0_1_0_1)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorAssignment_0_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_0_2()); }
(rule__NavigatingArgCS__Group_0_1_0_2__0)?
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NavigatingArgCS__Group_0_1_0_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_0_2__0__Impl
	rule__NavigatingArgCS__Group_0_1_0_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_0_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0()); }

	'='

{ after(grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_0_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_0_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_0_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_0_2_1()); }
(rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_0_2_1)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_0_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingArgCS__Group_0_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_1__0__Impl
	rule__NavigatingArgCS__Group_0_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_1_0()); }

	':'

{ after(grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_1__1__Impl
	rule__NavigatingArgCS__Group_0_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_0_1_1_1()); }
(rule__NavigatingArgCS__OwnedTypeAssignment_0_1_1_1)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_0_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_1__2__Impl
	rule__NavigatingArgCS__Group_0_1_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_1_2()); }
(rule__NavigatingArgCS__Group_0_1_1_2__0)?
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_1_3()); }
(rule__NavigatingArgCS__Group_0_1_1_3__0)?
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__NavigatingArgCS__Group_0_1_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_1_2__0__Impl
	rule__NavigatingArgCS__Group_0_1_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1_1_2_0()); }
(rule__NavigatingArgCS__Alternatives_0_1_1_2_0)
{ after(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorAssignment_0_1_1_2_1()); }
(rule__NavigatingArgCS__OwnedCoIteratorAssignment_0_1_1_2_1)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorAssignment_0_1_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingArgCS__Group_0_1_1_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_1_3__0__Impl
	rule__NavigatingArgCS__Group_0_1_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_1_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_1_3_0()); }

	'='

{ after(grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_1_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_1_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_1_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_1_3_1()); }
(rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_1_3_1)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_1_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingArgCS__Group_0_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_2__0__Impl
	rule__NavigatingArgCS__Group_0_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_2_0()); }
(rule__NavigatingArgCS__Group_0_1_2_0__0)?
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_2__1__Impl
	rule__NavigatingArgCS__Group_0_1_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_2_1()); }
(rule__NavigatingArgCS__Group_0_1_2_1__0)?
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_2__2__Impl
	rule__NavigatingArgCS__Group_0_1_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_2_2()); }

	'in'

{ after(grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_2_3()); }
(rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_2_3)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__NavigatingArgCS__Group_0_1_2_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_2_0__0__Impl
	rule__NavigatingArgCS__Group_0_1_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_2_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_2_0_0()); }

	':'

{ after(grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_2_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_2_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_2_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_0_1_2_0_1()); }
(rule__NavigatingArgCS__OwnedTypeAssignment_0_1_2_0_1)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_0_1_2_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingArgCS__Group_0_1_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_2_1__0__Impl
	rule__NavigatingArgCS__Group_0_1_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1_2_1_0()); }
(rule__NavigatingArgCS__Alternatives_0_1_2_1_0)
{ after(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorAssignment_0_1_2_1_1()); }
(rule__NavigatingArgCS__OwnedCoIteratorAssignment_0_1_2_1_1)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorAssignment_0_1_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingArgCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_1__0__Impl
	rule__NavigatingArgCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0()); }

	':'

{ after(grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_1_1()); }
(rule__NavigatingArgCS__OwnedTypeAssignment_1_1)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingBarArgCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group__0__Impl
	rule__NavigatingBarArgCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getPrefixAssignment_0()); }
(rule__NavigatingBarArgCS__PrefixAssignment_0)
{ after(grammarAccess.getNavigatingBarArgCSAccess().getPrefixAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingBarArgCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group__1__Impl
	rule__NavigatingBarArgCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionAssignment_1()); }
(rule__NavigatingBarArgCS__OwnedNameExpressionAssignment_1)
{ after(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingBarArgCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getGroup_2()); }
(rule__NavigatingBarArgCS__Group_2__0)?
{ after(grammarAccess.getNavigatingBarArgCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NavigatingBarArgCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group_2__0__Impl
	rule__NavigatingBarArgCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0()); }

	':'

{ after(grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingBarArgCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group_2__1__Impl
	rule__NavigatingBarArgCS__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeAssignment_2_1()); }
(rule__NavigatingBarArgCS__OwnedTypeAssignment_2_1)
{ after(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingBarArgCS__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getGroup_2_2()); }
(rule__NavigatingBarArgCS__Group_2_2__0)?
{ after(grammarAccess.getNavigatingBarArgCSAccess().getGroup_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NavigatingBarArgCS__Group_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group_2_2__0__Impl
	rule__NavigatingBarArgCS__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0()); }

	'='

{ after(grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingBarArgCS__Group_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionAssignment_2_2_1()); }
(rule__NavigatingBarArgCS__OwnedInitExpressionAssignment_2_2_1)
{ after(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionAssignment_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingCommaArgCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group__0__Impl
	rule__NavigatingCommaArgCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixAssignment_0()); }
(rule__NavigatingCommaArgCS__PrefixAssignment_0)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group__1__Impl
	rule__NavigatingCommaArgCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionAssignment_1()); }
(rule__NavigatingCommaArgCS__OwnedNameExpressionAssignment_1)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2()); }
(rule__NavigatingCommaArgCS__Alternatives_2)?
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NavigatingCommaArgCS__Group_2_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_0__0__Impl
	rule__NavigatingCommaArgCS__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2_0_0()); }
(rule__NavigatingCommaArgCS__Alternatives_2_0_0)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_0__1__Impl
	rule__NavigatingCommaArgCS__Group_2_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorAssignment_2_0_1()); }
(rule__NavigatingCommaArgCS__OwnedCoIteratorAssignment_2_0_1)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorAssignment_2_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_0_2()); }
(rule__NavigatingCommaArgCS__Group_2_0_2__0)?
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NavigatingCommaArgCS__Group_2_0_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_0_2__0__Impl
	rule__NavigatingCommaArgCS__Group_2_0_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_0_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0()); }

	'='

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_0_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_0_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_0_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_0_2_1()); }
(rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_0_2_1)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_0_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingCommaArgCS__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_1__0__Impl
	rule__NavigatingCommaArgCS__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_1_0()); }

	':'

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_1__1__Impl
	rule__NavigatingCommaArgCS__Group_2_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeAssignment_2_1_1()); }
(rule__NavigatingCommaArgCS__OwnedTypeAssignment_2_1_1)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_1__2__Impl
	rule__NavigatingCommaArgCS__Group_2_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_1_2()); }
(rule__NavigatingCommaArgCS__Group_2_1_2__0)?
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_1_3()); }
(rule__NavigatingCommaArgCS__Group_2_1_3__0)?
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__NavigatingCommaArgCS__Group_2_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_1_2__0__Impl
	rule__NavigatingCommaArgCS__Group_2_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2_1_2_0()); }
(rule__NavigatingCommaArgCS__Alternatives_2_1_2_0)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorAssignment_2_1_2_1()); }
(rule__NavigatingCommaArgCS__OwnedCoIteratorAssignment_2_1_2_1)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorAssignment_2_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingCommaArgCS__Group_2_1_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_1_3__0__Impl
	rule__NavigatingCommaArgCS__Group_2_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_1_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_1_3_0()); }

	'='

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_1_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_1_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_1_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_1_3_1()); }
(rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_1_3_1)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_1_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingCommaArgCS__Group_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_2__0__Impl
	rule__NavigatingCommaArgCS__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_2_0()); }
(rule__NavigatingCommaArgCS__Group_2_2_0__0)?
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_2__1__Impl
	rule__NavigatingCommaArgCS__Group_2_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_2_1()); }
(rule__NavigatingCommaArgCS__Group_2_2_1__0)?
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_2__2__Impl
	rule__NavigatingCommaArgCS__Group_2_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_2_2()); }

	'in'

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_2_3()); }
(rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_2_3)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__NavigatingCommaArgCS__Group_2_2_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_2_0__0__Impl
	rule__NavigatingCommaArgCS__Group_2_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_2_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_2_0_0()); }

	':'

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_2_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_2_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_2_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeAssignment_2_2_0_1()); }
(rule__NavigatingCommaArgCS__OwnedTypeAssignment_2_2_0_1)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeAssignment_2_2_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingCommaArgCS__Group_2_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_2_1__0__Impl
	rule__NavigatingCommaArgCS__Group_2_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2_2_1_0()); }
(rule__NavigatingCommaArgCS__Alternatives_2_2_1_0)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorAssignment_2_2_1_1()); }
(rule__NavigatingCommaArgCS__OwnedCoIteratorAssignment_2_2_1_1)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorAssignment_2_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingSemiArgCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group__0__Impl
	rule__NavigatingSemiArgCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixAssignment_0()); }
(rule__NavigatingSemiArgCS__PrefixAssignment_0)
{ after(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingSemiArgCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group__1__Impl
	rule__NavigatingSemiArgCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionAssignment_1()); }
(rule__NavigatingSemiArgCS__OwnedNameExpressionAssignment_1)
{ after(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingSemiArgCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getGroup_2()); }
(rule__NavigatingSemiArgCS__Group_2__0)?
{ after(grammarAccess.getNavigatingSemiArgCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NavigatingSemiArgCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group_2__0__Impl
	rule__NavigatingSemiArgCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0()); }

	':'

{ after(grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingSemiArgCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group_2__1__Impl
	rule__NavigatingSemiArgCS__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeAssignment_2_1()); }
(rule__NavigatingSemiArgCS__OwnedTypeAssignment_2_1)
{ after(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingSemiArgCS__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getGroup_2_2()); }
(rule__NavigatingSemiArgCS__Group_2_2__0)?
{ after(grammarAccess.getNavigatingSemiArgCSAccess().getGroup_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NavigatingSemiArgCS__Group_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group_2_2__0__Impl
	rule__NavigatingSemiArgCS__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0()); }

	'='

{ after(grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingSemiArgCS__Group_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionAssignment_2_2_1()); }
(rule__NavigatingSemiArgCS__OwnedInitExpressionAssignment_2_2_1)
{ after(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionAssignment_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CoIteratorVariableCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CoIteratorVariableCS__Group__0__Impl
	rule__CoIteratorVariableCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CoIteratorVariableCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCoIteratorVariableCSAccess().getNameAssignment_0()); }
(rule__CoIteratorVariableCS__NameAssignment_0)
{ after(grammarAccess.getCoIteratorVariableCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CoIteratorVariableCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CoIteratorVariableCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CoIteratorVariableCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCoIteratorVariableCSAccess().getGroup_1()); }
(rule__CoIteratorVariableCS__Group_1__0)?
{ after(grammarAccess.getCoIteratorVariableCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CoIteratorVariableCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CoIteratorVariableCS__Group_1__0__Impl
	rule__CoIteratorVariableCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CoIteratorVariableCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCoIteratorVariableCSAccess().getColonKeyword_1_0()); }

	':'

{ after(grammarAccess.getCoIteratorVariableCSAccess().getColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CoIteratorVariableCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CoIteratorVariableCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CoIteratorVariableCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCoIteratorVariableCSAccess().getOwnedTypeAssignment_1_1()); }
(rule__CoIteratorVariableCS__OwnedTypeAssignment_1_1)
{ after(grammarAccess.getCoIteratorVariableCSAccess().getOwnedTypeAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__IfExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__0__Impl
	rule__IfExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getIfKeyword_0()); }

	'if'

{ after(grammarAccess.getIfExpCSAccess().getIfKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__1__Impl
	rule__IfExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedConditionAssignment_1()); }
(rule__IfExpCS__OwnedConditionAssignment_1)
{ after(grammarAccess.getIfExpCSAccess().getOwnedConditionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__2__Impl
	rule__IfExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getThenKeyword_2()); }

	'then'

{ after(grammarAccess.getIfExpCSAccess().getThenKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__3__Impl
	rule__IfExpCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionAssignment_3()); }
(rule__IfExpCS__OwnedThenExpressionAssignment_3)
{ after(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__4__Impl
	rule__IfExpCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsAssignment_4()); }
(rule__IfExpCS__OwnedIfThenExpressionsAssignment_4)*
{ after(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__5__Impl
	rule__IfExpCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getElseKeyword_5()); }

	'else'

{ after(grammarAccess.getIfExpCSAccess().getElseKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__6__Impl
	rule__IfExpCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionAssignment_6()); }
(rule__IfExpCS__OwnedElseExpressionAssignment_6)
{ after(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionAssignment_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getEndifKeyword_7()); }

	'endif'

{ after(grammarAccess.getIfExpCSAccess().getEndifKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__ElseIfThenExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ElseIfThenExpCS__Group__0__Impl
	rule__ElseIfThenExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ElseIfThenExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0()); }

	'elseif'

{ after(grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ElseIfThenExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ElseIfThenExpCS__Group__1__Impl
	rule__ElseIfThenExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ElseIfThenExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionAssignment_1()); }
(rule__ElseIfThenExpCS__OwnedConditionAssignment_1)
{ after(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ElseIfThenExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ElseIfThenExpCS__Group__2__Impl
	rule__ElseIfThenExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ElseIfThenExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2()); }

	'then'

{ after(grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ElseIfThenExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ElseIfThenExpCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ElseIfThenExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionAssignment_3()); }
(rule__ElseIfThenExpCS__OwnedThenExpressionAssignment_3)
{ after(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__LetExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetExpCS__Group__0__Impl
	rule__LetExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getLetKeyword_0()); }

	'let'

{ after(grammarAccess.getLetExpCSAccess().getLetKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetExpCS__Group__1__Impl
	rule__LetExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getOwnedVariablesAssignment_1()); }
(rule__LetExpCS__OwnedVariablesAssignment_1)
{ after(grammarAccess.getLetExpCSAccess().getOwnedVariablesAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetExpCS__Group__2__Impl
	rule__LetExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getGroup_2()); }
(rule__LetExpCS__Group_2__0)*
{ after(grammarAccess.getLetExpCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetExpCS__Group__3__Impl
	rule__LetExpCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getInKeyword_3()); }

	'in'

{ after(grammarAccess.getLetExpCSAccess().getInKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetExpCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetExpCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getOwnedInExpressionAssignment_4()); }
(rule__LetExpCS__OwnedInExpressionAssignment_4)
{ after(grammarAccess.getLetExpCSAccess().getOwnedInExpressionAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__LetExpCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetExpCS__Group_2__0__Impl
	rule__LetExpCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0()); }

	','

{ after(grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetExpCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetExpCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getOwnedVariablesAssignment_2_1()); }
(rule__LetExpCS__OwnedVariablesAssignment_2_1)
{ after(grammarAccess.getLetExpCSAccess().getOwnedVariablesAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LetVariableCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetVariableCS__Group__0__Impl
	rule__LetVariableCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getNameAssignment_0()); }
(rule__LetVariableCS__NameAssignment_0)
{ after(grammarAccess.getLetVariableCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetVariableCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetVariableCS__Group__1__Impl
	rule__LetVariableCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseAssignment_1()); }
(rule__LetVariableCS__OwnedRoundBracketedClauseAssignment_1)?
{ after(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetVariableCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetVariableCS__Group__2__Impl
	rule__LetVariableCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getGroup_2()); }
(rule__LetVariableCS__Group_2__0)?
{ after(grammarAccess.getLetVariableCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetVariableCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetVariableCS__Group__3__Impl
	rule__LetVariableCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3()); }

	'='

{ after(grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetVariableCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetVariableCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionAssignment_4()); }
(rule__LetVariableCS__OwnedInitExpressionAssignment_4)
{ after(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__LetVariableCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetVariableCS__Group_2__0__Impl
	rule__LetVariableCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0()); }

	':'

{ after(grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetVariableCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetVariableCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getOwnedTypeAssignment_2_1()); }
(rule__LetVariableCS__OwnedTypeAssignment_2_1)
{ after(grammarAccess.getLetVariableCSAccess().getOwnedTypeAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NestedExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NestedExpCS__Group__0__Impl
	rule__NestedExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NestedExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0()); }

	'('

{ after(grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NestedExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NestedExpCS__Group__1__Impl
	rule__NestedExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NestedExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNestedExpCSAccess().getOwnedExpressionAssignment_1()); }
(rule__NestedExpCS__OwnedExpressionAssignment_1)
{ after(grammarAccess.getNestedExpCSAccess().getOwnedExpressionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NestedExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NestedExpCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NestedExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNestedExpCSAccess().getRightParenthesisKeyword_2()); }

	')'

{ after(grammarAccess.getNestedExpCSAccess().getRightParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SelfExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SelfExpCS__Group__0__Impl
	rule__SelfExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SelfExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSelfExpCSAccess().getSelfExpCSAction_0()); }
(

)
{ after(grammarAccess.getSelfExpCSAccess().getSelfExpCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SelfExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SelfExpCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SelfExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSelfExpCSAccess().getSelfKeyword_1()); }

	'self'

{ after(grammarAccess.getSelfExpCSAccess().getSelfKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MultiplicityBoundsCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityBoundsCS__Group__0__Impl
	rule__MultiplicityBoundsCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityBoundsCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0()); }
(rule__MultiplicityBoundsCS__LowerBoundAssignment_0)
{ after(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicityBoundsCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityBoundsCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityBoundsCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1()); }
(rule__MultiplicityBoundsCS__Group_1__0)?
{ after(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MultiplicityBoundsCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityBoundsCS__Group_1__0__Impl
	rule__MultiplicityBoundsCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityBoundsCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0()); }

	'..'

{ after(grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicityBoundsCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityBoundsCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityBoundsCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1()); }
(rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1)
{ after(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MultiplicityCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityCS__Group__0__Impl
	rule__MultiplicityCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0()); }

	'['

{ after(grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicityCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityCS__Group__1__Impl
	rule__MultiplicityCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityCSAccess().getAlternatives_1()); }
(rule__MultiplicityCS__Alternatives_1)
{ after(grammarAccess.getMultiplicityCSAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicityCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityCS__Group__2__Impl
	rule__MultiplicityCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityCSAccess().getAlternatives_2()); }
(rule__MultiplicityCS__Alternatives_2)?
{ after(grammarAccess.getMultiplicityCSAccess().getAlternatives_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicityCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_3()); }

	']'

{ after(grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__PathNameCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PathNameCS__Group__0__Impl
	rule__PathNameCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PathNameCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_0()); }
(rule__PathNameCS__OwnedPathElementsAssignment_0)
{ after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PathNameCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PathNameCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PathNameCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathNameCSAccess().getGroup_1()); }
(rule__PathNameCS__Group_1__0)*
{ after(grammarAccess.getPathNameCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PathNameCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PathNameCS__Group_1__0__Impl
	rule__PathNameCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PathNameCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0()); }

	'::'

{ after(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PathNameCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PathNameCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PathNameCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); }
(rule__PathNameCS__OwnedPathElementsAssignment_1_1)
{ after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TemplateBindingCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateBindingCS__Group__0__Impl
	rule__TemplateBindingCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_0()); }
(rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0)
{ after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateBindingCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateBindingCS__Group__1__Impl
	rule__TemplateBindingCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getGroup_1()); }
(rule__TemplateBindingCS__Group_1__0)*
{ after(grammarAccess.getTemplateBindingCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateBindingCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateBindingCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityAssignment_2()); }
(rule__TemplateBindingCS__OwnedMultiplicityAssignment_2)?
{ after(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TemplateBindingCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateBindingCS__Group_1__0__Impl
	rule__TemplateBindingCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0()); }

	','

{ after(grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateBindingCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateBindingCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_1_1()); }
(rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1)
{ after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TemplateSignatureCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group__0__Impl
	rule__TemplateSignatureCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getLeftParenthesisKeyword_0()); }

	'('

{ after(grammarAccess.getTemplateSignatureCSAccess().getLeftParenthesisKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group__1__Impl
	rule__TemplateSignatureCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_1()); }
(rule__TemplateSignatureCS__OwnedParametersAssignment_1)
{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group__2__Impl
	rule__TemplateSignatureCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getGroup_2()); }
(rule__TemplateSignatureCS__Group_2__0)*
{ after(grammarAccess.getTemplateSignatureCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getRightParenthesisKeyword_3()); }

	')'

{ after(grammarAccess.getTemplateSignatureCSAccess().getRightParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__TemplateSignatureCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_2__0__Impl
	rule__TemplateSignatureCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getCommaKeyword_2_0()); }

	','

{ after(grammarAccess.getTemplateSignatureCSAccess().getCommaKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_2_1()); }
(rule__TemplateSignatureCS__OwnedParametersAssignment_2_1)
{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeParameterCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeParameterCS__Group__0__Impl
	rule__TypeParameterCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getNameAssignment_0()); }
(rule__TypeParameterCS__NameAssignment_0)
{ after(grammarAccess.getTypeParameterCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeParameterCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeParameterCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getGroup_1()); }
(rule__TypeParameterCS__Group_1__0)?
{ after(grammarAccess.getTypeParameterCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeParameterCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeParameterCS__Group_1__0__Impl
	rule__TypeParameterCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0()); }

	'extends'

{ after(grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeParameterCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeParameterCS__Group_1__1__Impl
	rule__TypeParameterCS__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_1()); }
(rule__TypeParameterCS__OwnedExtendsAssignment_1_1)
{ after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeParameterCS__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeParameterCS__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getGroup_1_2()); }
(rule__TypeParameterCS__Group_1_2__0)*
{ after(grammarAccess.getTypeParameterCSAccess().getGroup_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeParameterCS__Group_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeParameterCS__Group_1_2__0__Impl
	rule__TypeParameterCS__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__Group_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0()); }

	'&&'

{ after(grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeParameterCS__Group_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeParameterCS__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__Group_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_2_1()); }
(rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1)
{ after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__WildcardTypeRefCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WildcardTypeRefCS__Group__0__Impl
	rule__WildcardTypeRefCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__WildcardTypeRefCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); }
(

)
{ after(grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WildcardTypeRefCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WildcardTypeRefCS__Group__1__Impl
	rule__WildcardTypeRefCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__WildcardTypeRefCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); }

	'?'

{ after(grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WildcardTypeRefCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WildcardTypeRefCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__WildcardTypeRefCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2()); }
(rule__WildcardTypeRefCS__Group_2__0)?
{ after(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__WildcardTypeRefCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WildcardTypeRefCS__Group_2__0__Impl
	rule__WildcardTypeRefCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__WildcardTypeRefCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0()); }

	'extends'

{ after(grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WildcardTypeRefCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WildcardTypeRefCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__WildcardTypeRefCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsAssignment_2_1()); }
(rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1)
{ after(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}







rule__Library__OwnedImportsAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibraryAccess().getOwnedImportsImportCSParserRuleCall_0_0_0()); }
	ruleImportCS{ after(grammarAccess.getLibraryAccess().getOwnedImportsImportCSParserRuleCall_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Library__OwnedPackagesAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibraryAccess().getOwnedPackagesLibPackageCSParserRuleCall_1_0()); }
	ruleLibPackageCS{ after(grammarAccess.getLibraryAccess().getOwnedPackagesLibPackageCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPathNameCS__OwnedPathElementsAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPathNameCSAccess().getOwnedPathElementsLibPathElementCSParserRuleCall_0_0()); }
	ruleLibPathElementCS{ after(grammarAccess.getLibPathNameCSAccess().getOwnedPathElementsLibPathElementCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPathNameCS__OwnedPathElementsAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPathNameCSAccess().getOwnedPathElementsLibPathElementCSParserRuleCall_1_1_0()); }
	ruleLibPathElementCS{ after(grammarAccess.getLibPathNameCSAccess().getOwnedPathElementsLibPathElementCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPathElementCS__ReferredElementAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); }
(
{ before(grammarAccess.getLibPathElementCSAccess().getReferredElementNamedElementNameParserRuleCall_0_1()); }
	ruleName{ after(grammarAccess.getLibPathElementCSAccess().getReferredElementNamedElementNameParserRuleCall_0_1()); }
)
{ after(grammarAccess.getLibPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AccumulatorCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAccumulatorCSAccess().getNameIdentifierParserRuleCall_0_0()); }
	ruleIdentifier{ after(grammarAccess.getAccumulatorCSAccess().getNameIdentifierParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AccumulatorCS__OwnedTypeAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAccumulatorCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getAccumulatorCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getNameAlternatives_1_0()); }
(rule__AnnotationCS__NameAlternatives_1_0)
{ after(grammarAccess.getAnnotationCSAccess().getNameAlternatives_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__OwnedDetailsAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedDetailsDetailCSParserRuleCall_2_1_0()); }
	ruleDetailCS{ after(grammarAccess.getAnnotationCSAccess().getOwnedDetailsDetailCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__OwnedDetailsAssignment_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedDetailsDetailCSParserRuleCall_2_2_1_0()); }
	ruleDetailCS{ after(grammarAccess.getAnnotationCSAccess().getOwnedDetailsDetailCSParserRuleCall_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__OwnedAnnotationsAssignment_3_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_3_0_1_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getAnnotationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_3_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__IsAbstractAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getIsAbstractAbstractKeyword_0_0()); }
(
{ before(grammarAccess.getLibClassCSAccess().getIsAbstractAbstractKeyword_0_0()); }

	'abstract'

{ after(grammarAccess.getLibClassCSAccess().getIsAbstractAbstractKeyword_0_0()); }
)

{ after(grammarAccess.getLibClassCSAccess().getIsAbstractAbstractKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getNameAnyNameParserRuleCall_2_0()); }
	ruleAnyName{ after(grammarAccess.getLibClassCSAccess().getNameAnyNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__OwnedSignatureAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0()); }
	ruleTemplateSignatureCS{ after(grammarAccess.getLibClassCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__MetaclassNameAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getMetaclassNameMetaclassNameCSCrossReference_4_1_0()); }
(
{ before(grammarAccess.getLibClassCSAccess().getMetaclassNameMetaclassNameCSAnyNameParserRuleCall_4_1_0_1()); }
	ruleAnyName{ after(grammarAccess.getLibClassCSAccess().getMetaclassNameMetaclassNameCSAnyNameParserRuleCall_4_1_0_1()); }
)
{ after(grammarAccess.getLibClassCSAccess().getMetaclassNameMetaclassNameCSCrossReference_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__OwnedSuperTypesAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_5_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getLibClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__OwnedSuperTypesAssignment_5_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_5_2_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getLibClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_5_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__ImplementationAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getImplementationJavaClassCSCrossReference_6_1_0()); }
(
{ before(grammarAccess.getLibClassCSAccess().getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getLibClassCSAccess().getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1()); }
)
{ after(grammarAccess.getLibClassCSAccess().getImplementationJavaClassCSCrossReference_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__OwnedOperationsAssignment_8_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getOwnedOperationsOperationCSParserRuleCall_8_0_0()); }
	ruleOperationCS{ after(grammarAccess.getLibClassCSAccess().getOwnedOperationsOperationCSParserRuleCall_8_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__OwnedPropertiesAssignment_8_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getOwnedPropertiesLibPropertyCSParserRuleCall_8_1_0()); }
	ruleLibPropertyCS{ after(grammarAccess.getLibClassCSAccess().getOwnedPropertiesLibPropertyCSParserRuleCall_8_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__OwnedConstraintsAssignment_8_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getOwnedConstraintsInvCSParserRuleCall_8_2_0()); }
	ruleInvCS{ after(grammarAccess.getLibClassCSAccess().getOwnedConstraintsInvCSParserRuleCall_8_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibClassCS__OwnedAnnotationsAssignment_8_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibClassCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_8_3_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getLibClassCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_8_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DetailCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDetailCSAccess().getNameAlternatives_0_0()); }
(rule__DetailCS__NameAlternatives_0_0)
{ after(grammarAccess.getDetailCSAccess().getNameAlternatives_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DetailCS__ValuesAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDetailCSAccess().getValuesAlternatives_2_0()); }
(rule__DetailCS__ValuesAlternatives_2_0)
{ after(grammarAccess.getDetailCSAccess().getValuesAlternatives_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationCS__ValueAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationCSAccess().getValueSINGLE_QUOTED_STRINGTerminalRuleCall_2_0()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getDocumentationCSAccess().getValueSINGLE_QUOTED_STRINGTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationCS__OwnedDetailsAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationCSAccess().getOwnedDetailsDetailCSParserRuleCall_3_1_0()); }
	ruleDetailCS{ after(grammarAccess.getDocumentationCSAccess().getOwnedDetailsDetailCSParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationCS__OwnedDetailsAssignment_3_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationCSAccess().getOwnedDetailsDetailCSParserRuleCall_3_2_1_0()); }
	ruleDetailCS{ after(grammarAccess.getDocumentationCSAccess().getOwnedDetailsDetailCSParserRuleCall_3_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__NameAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); }
	ruleIdentifier{ after(grammarAccess.getImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__OwnedPathNameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getOwnedPathNameURIPathNameCSParserRuleCall_2_0()); }
	ruleURIPathNameCS{ after(grammarAccess.getImportCSAccess().getOwnedPathNameURIPathNameCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__IsAllAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getIsAllColonColonAsteriskKeyword_3_0()); }
(
{ before(grammarAccess.getImportCSAccess().getIsAllColonColonAsteriskKeyword_3_0()); }

	'::*'

{ after(grammarAccess.getImportCSAccess().getIsAllColonColonAsteriskKeyword_3_0()); }
)

{ after(grammarAccess.getImportCSAccess().getIsAllColonColonAsteriskKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InvCS__StereotypeAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvCSAccess().getStereotypeInvKeyword_0_0()); }
(
{ before(grammarAccess.getInvCSAccess().getStereotypeInvKeyword_0_0()); }

	'inv'

{ after(grammarAccess.getInvCSAccess().getStereotypeInvKeyword_0_0()); }
)

{ after(grammarAccess.getInvCSAccess().getStereotypeInvKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InvCS__NameAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getInvCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InvCS__OwnedMessageSpecificationAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0()); }
	ruleSpecificationCS{ after(grammarAccess.getInvCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InvCS__OwnedSpecificationAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getInvCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getNameNameParserRuleCall_1_0()); }
	ruleName{ after(grammarAccess.getLibCoercionCSAccess().getNameNameParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__OwnedTypeAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_5_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getLibCoercionCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__ImplementationAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getImplementationJavaClassCSCrossReference_6_1_0()); }
(
{ before(grammarAccess.getLibCoercionCSAccess().getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getLibCoercionCSAccess().getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1()); }
)
{ after(grammarAccess.getLibCoercionCSAccess().getImplementationJavaClassCSCrossReference_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__OwnedAnnotationsAssignment_7_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getLibCoercionCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__OwnedPreconditionsAssignment_7_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getOwnedPreconditionsPostCSParserRuleCall_7_0_1_1_0()); }
	rulePostCS{ after(grammarAccess.getLibCoercionCSAccess().getOwnedPreconditionsPostCSParserRuleCall_7_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibCoercionCS__OwnedPostconditionsAssignment_7_0_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibCoercionCSAccess().getOwnedPostconditionsPreCSParserRuleCall_7_0_1_2_0()); }
	rulePreCS{ after(grammarAccess.getLibCoercionCSAccess().getOwnedPostconditionsPreCSParserRuleCall_7_0_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getNameNameParserRuleCall_1_0()); }
	ruleName{ after(grammarAccess.getLibIterationCSAccess().getNameNameParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__OwnedSignatureAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0()); }
	ruleTemplateSignatureCS{ after(grammarAccess.getLibIterationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__OwnedIteratorsAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedIteratorsIteratorCSParserRuleCall_4_0()); }
	ruleIteratorCS{ after(grammarAccess.getLibIterationCSAccess().getOwnedIteratorsIteratorCSParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__OwnedIteratorsAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedIteratorsIteratorCSParserRuleCall_5_1_0()); }
	ruleIteratorCS{ after(grammarAccess.getLibIterationCSAccess().getOwnedIteratorsIteratorCSParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__OwnedAccumulatorsAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedAccumulatorsAccumulatorCSParserRuleCall_6_1_0()); }
	ruleAccumulatorCS{ after(grammarAccess.getLibIterationCSAccess().getOwnedAccumulatorsAccumulatorCSParserRuleCall_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__OwnedAccumulatorsAssignment_6_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedAccumulatorsAccumulatorCSParserRuleCall_6_2_1_0()); }
	ruleAccumulatorCS{ after(grammarAccess.getLibIterationCSAccess().getOwnedAccumulatorsAccumulatorCSParserRuleCall_6_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__OwnedParametersAssignment_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedParametersParameterCSParserRuleCall_7_1_0()); }
	ruleParameterCS{ after(grammarAccess.getLibIterationCSAccess().getOwnedParametersParameterCSParserRuleCall_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__OwnedParametersAssignment_7_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedParametersParameterCSParserRuleCall_7_2_1_0()); }
	ruleParameterCS{ after(grammarAccess.getLibIterationCSAccess().getOwnedParametersParameterCSParserRuleCall_7_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__OwnedTypeAssignment_10
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_10_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getLibIterationCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__IsInvalidatingAssignment_11
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getIsInvalidatingInvalidatingKeyword_11_0()); }
(
{ before(grammarAccess.getLibIterationCSAccess().getIsInvalidatingInvalidatingKeyword_11_0()); }

	'invalidating'

{ after(grammarAccess.getLibIterationCSAccess().getIsInvalidatingInvalidatingKeyword_11_0()); }
)

{ after(grammarAccess.getLibIterationCSAccess().getIsInvalidatingInvalidatingKeyword_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__IsValidatingAssignment_12
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getIsValidatingValidatingKeyword_12_0()); }
(
{ before(grammarAccess.getLibIterationCSAccess().getIsValidatingValidatingKeyword_12_0()); }

	'validating'

{ after(grammarAccess.getLibIterationCSAccess().getIsValidatingValidatingKeyword_12_0()); }
)

{ after(grammarAccess.getLibIterationCSAccess().getIsValidatingValidatingKeyword_12_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__ImplementationAssignment_13_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getImplementationJavaClassCSCrossReference_13_1_0()); }
(
{ before(grammarAccess.getLibIterationCSAccess().getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_13_1_0_1()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getLibIterationCSAccess().getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_13_1_0_1()); }
)
{ after(grammarAccess.getLibIterationCSAccess().getImplementationJavaClassCSCrossReference_13_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__OwnedAnnotationsAssignment_14_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_14_0_1_0_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getLibIterationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_14_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__OwnedPreconditionsAssignment_14_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedPreconditionsPostCSParserRuleCall_14_0_1_1_0()); }
	rulePostCS{ after(grammarAccess.getLibIterationCSAccess().getOwnedPreconditionsPostCSParserRuleCall_14_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibIterationCS__OwnedPostconditionsAssignment_14_0_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibIterationCSAccess().getOwnedPostconditionsPreCSParserRuleCall_14_0_1_2_0()); }
	rulePreCS{ after(grammarAccess.getLibIterationCSAccess().getOwnedPostconditionsPreCSParserRuleCall_14_0_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IteratorCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIteratorCSAccess().getNameIdentifierParserRuleCall_0_0()); }
	ruleIdentifier{ after(grammarAccess.getIteratorCSAccess().getNameIdentifierParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IteratorCS__OwnedTypeAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIteratorCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getIteratorCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getNameLambdaKeyword_0_0()); }
(
{ before(grammarAccess.getLambdaTypeCSAccess().getNameLambdaKeyword_0_0()); }

	'Lambda'

{ after(grammarAccess.getLambdaTypeCSAccess().getNameLambdaKeyword_0_0()); }
)

{ after(grammarAccess.getLambdaTypeCSAccess().getNameLambdaKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__OwnedSignatureAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_1_0()); }
	ruleTemplateSignatureCS{ after(grammarAccess.getLambdaTypeCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__OwnedContextTypeAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getOwnedContextTypeLambdaContextTypeRefCSParserRuleCall_2_0()); }
	ruleLambdaContextTypeRefCS{ after(grammarAccess.getLambdaTypeCSAccess().getOwnedContextTypeLambdaContextTypeRefCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__OwnedParameterTypesAssignment_4_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getOwnedParameterTypesTypedMultiplicityRefCSParserRuleCall_4_0_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getLambdaTypeCSAccess().getOwnedParameterTypesTypedMultiplicityRefCSParserRuleCall_4_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__OwnedParameterTypesAssignment_4_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getOwnedParameterTypesTypedMultiplicityRefCSParserRuleCall_4_1_1_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getLambdaTypeCSAccess().getOwnedParameterTypesTypedMultiplicityRefCSParserRuleCall_4_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaTypeCS__OwnedResultTypeAssignment_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaTypeCSAccess().getOwnedResultTypeTypedRefCSParserRuleCall_7_0()); }
	ruleTypedRefCS{ after(grammarAccess.getLambdaTypeCSAccess().getOwnedResultTypeTypedRefCSParserRuleCall_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaContextTypeRefCS__OwnedPathNameAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaContextTypeRefCSAccess().getOwnedPathNameLibPathNameCSParserRuleCall_0()); }
	ruleLibPathNameCS{ after(grammarAccess.getLambdaContextTypeRefCSAccess().getOwnedPathNameLibPathNameCSParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__IsStaticAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getIsStaticStaticKeyword_0_0()); }
(
{ before(grammarAccess.getLibOperationCSAccess().getIsStaticStaticKeyword_0_0()); }

	'static'

{ after(grammarAccess.getLibOperationCSAccess().getIsStaticStaticKeyword_0_0()); }
)

{ after(grammarAccess.getLibOperationCSAccess().getIsStaticStaticKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getNameNameParserRuleCall_2_0()); }
	ruleName{ after(grammarAccess.getLibOperationCSAccess().getNameNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__OwnedSignatureAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0()); }
	ruleTemplateSignatureCS{ after(grammarAccess.getLibOperationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__OwnedParametersAssignment_5_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_0_0()); }
	ruleParameterCS{ after(grammarAccess.getLibOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__OwnedParametersAssignment_5_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_1_1_0()); }
	ruleParameterCS{ after(grammarAccess.getLibOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__OwnedTypeAssignment_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_8_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getLibOperationCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__IsValidatingAssignment_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getIsValidatingValidatingKeyword_9_0()); }
(
{ before(grammarAccess.getLibOperationCSAccess().getIsValidatingValidatingKeyword_9_0()); }

	'validating'

{ after(grammarAccess.getLibOperationCSAccess().getIsValidatingValidatingKeyword_9_0()); }
)

{ after(grammarAccess.getLibOperationCSAccess().getIsValidatingValidatingKeyword_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__IsInvalidatingAssignment_10
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getIsInvalidatingInvalidatingKeyword_10_0()); }
(
{ before(grammarAccess.getLibOperationCSAccess().getIsInvalidatingInvalidatingKeyword_10_0()); }

	'invalidating'

{ after(grammarAccess.getLibOperationCSAccess().getIsInvalidatingInvalidatingKeyword_10_0()); }
)

{ after(grammarAccess.getLibOperationCSAccess().getIsInvalidatingInvalidatingKeyword_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__PrecedenceAssignment_11_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getPrecedencePrecedenceCrossReference_11_2_0()); }
(
{ before(grammarAccess.getLibOperationCSAccess().getPrecedencePrecedenceNameParserRuleCall_11_2_0_1()); }
	ruleName{ after(grammarAccess.getLibOperationCSAccess().getPrecedencePrecedenceNameParserRuleCall_11_2_0_1()); }
)
{ after(grammarAccess.getLibOperationCSAccess().getPrecedencePrecedenceCrossReference_11_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__ImplementationAssignment_12_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getImplementationJavaClassCSCrossReference_12_1_0()); }
(
{ before(grammarAccess.getLibOperationCSAccess().getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_12_1_0_1()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getLibOperationCSAccess().getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_12_1_0_1()); }
)
{ after(grammarAccess.getLibOperationCSAccess().getImplementationJavaClassCSCrossReference_12_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__OwnedAnnotationsAssignment_13_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_13_0_1_0_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getLibOperationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_13_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__OwnedBodyExpressionsAssignment_13_0_1_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedBodyExpressionsSpecificationCSParserRuleCall_13_0_1_1_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getLibOperationCSAccess().getOwnedBodyExpressionsSpecificationCSParserRuleCall_13_0_1_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__OwnedPostconditionsAssignment_13_0_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedPostconditionsPostCSParserRuleCall_13_0_1_2_0()); }
	rulePostCS{ after(grammarAccess.getLibOperationCSAccess().getOwnedPostconditionsPostCSParserRuleCall_13_0_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOperationCS__OwnedPreconditionsAssignment_13_0_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOperationCSAccess().getOwnedPreconditionsPreCSParserRuleCall_13_0_1_3_0()); }
	rulePreCS{ after(grammarAccess.getLibOperationCSAccess().getOwnedPreconditionsPreCSParserRuleCall_13_0_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOppositeCS__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOppositeCSAccess().getNameNameParserRuleCall_1_0()); }
	ruleName{ after(grammarAccess.getLibOppositeCSAccess().getNameNameParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibOppositeCS__OwnedTypeAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibOppositeCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getLibOppositeCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getNameNameParserRuleCall_1_0()); }
	ruleName{ after(grammarAccess.getLibPackageCSAccess().getNameNameParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__NsPrefixAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getNsPrefixIdentifierParserRuleCall_2_1_0()); }
	ruleIdentifier{ after(grammarAccess.getLibPackageCSAccess().getNsPrefixIdentifierParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__NsURIAssignment_2_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getNsURIURIParserRuleCall_2_3_0()); }
	ruleURI{ after(grammarAccess.getLibPackageCSAccess().getNsURIURIParserRuleCall_2_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__OwnedPackagesAssignment_4_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getOwnedPackagesPackageCSParserRuleCall_4_0_0()); }
	rulePackageCS{ after(grammarAccess.getLibPackageCSAccess().getOwnedPackagesPackageCSParserRuleCall_4_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__OwnedPrecedencesAssignment_4_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getOwnedPrecedencesPrecedenceCSParserRuleCall_4_1_1_0()); }
	rulePrecedenceCS{ after(grammarAccess.getLibPackageCSAccess().getOwnedPrecedencesPrecedenceCSParserRuleCall_4_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__OwnedClassesAssignment_4_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getOwnedClassesClassCSParserRuleCall_4_2_0()); }
	ruleClassCS{ after(grammarAccess.getLibPackageCSAccess().getOwnedClassesClassCSParserRuleCall_4_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPackageCS__OwnedAnnotationsAssignment_4_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPackageCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_4_3_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getLibPackageCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_4_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getNameNameParserRuleCall_1_0()); }
	ruleName{ after(grammarAccess.getPackageCSAccess().getNameNameParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__NsPrefixAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getNsPrefixIdentifierParserRuleCall_2_1_0()); }
	ruleIdentifier{ after(grammarAccess.getPackageCSAccess().getNsPrefixIdentifierParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__NsURIAssignment_2_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getNsURIURIParserRuleCall_2_3_0()); }
	ruleURI{ after(grammarAccess.getPackageCSAccess().getNsURIURIParserRuleCall_2_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__OwnedPackagesAssignment_4_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getOwnedPackagesPackageCSParserRuleCall_4_0_0()); }
	rulePackageCS{ after(grammarAccess.getPackageCSAccess().getOwnedPackagesPackageCSParserRuleCall_4_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__OwnedClassesAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getOwnedClassesClassCSParserRuleCall_4_1_0()); }
	ruleClassCS{ after(grammarAccess.getPackageCSAccess().getOwnedClassesClassCSParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__OwnedAnnotationsAssignment_4_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_4_2_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getPackageCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_4_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getNameIdentifierParserRuleCall_0_0()); }
	ruleIdentifier{ after(grammarAccess.getParameterCSAccess().getNameIdentifierParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__OwnedTypeAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getParameterCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__IsStaticAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getIsStaticStaticKeyword_0_0()); }
(
{ before(grammarAccess.getLibPropertyCSAccess().getIsStaticStaticKeyword_0_0()); }

	'static'

{ after(grammarAccess.getLibPropertyCSAccess().getIsStaticStaticKeyword_0_0()); }
)

{ after(grammarAccess.getLibPropertyCSAccess().getIsStaticStaticKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getNameNameParserRuleCall_2_0()); }
	ruleName{ after(grammarAccess.getLibPropertyCSAccess().getNameNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__OwnedTypeAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getLibPropertyCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__OwnedOppositeAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getOwnedOppositeLibOppositeCSParserRuleCall_5_0()); }
	ruleLibOppositeCS{ after(grammarAccess.getLibPropertyCSAccess().getOwnedOppositeLibOppositeCSParserRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__ImplementationAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getImplementationJavaClassCSCrossReference_6_1_0()); }
(
{ before(grammarAccess.getLibPropertyCSAccess().getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getLibPropertyCSAccess().getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_6_1_0_1()); }
)
{ after(grammarAccess.getLibPropertyCSAccess().getImplementationJavaClassCSCrossReference_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LibPropertyCS__OwnedAnnotationsAssignment_7_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLibPropertyCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getLibPropertyCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PostCS__StereotypeAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostCSAccess().getStereotypePostKeyword_0_0()); }
(
{ before(grammarAccess.getPostCSAccess().getStereotypePostKeyword_0_0()); }

	'post'

{ after(grammarAccess.getPostCSAccess().getStereotypePostKeyword_0_0()); }
)

{ after(grammarAccess.getPostCSAccess().getStereotypePostKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PostCS__NameAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getPostCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PostCS__OwnedMessageSpecificationAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0()); }
	ruleSpecificationCS{ after(grammarAccess.getPostCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PostCS__OwnedSpecificationAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getPostCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PreCS__StereotypeAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreCSAccess().getStereotypePreKeyword_0_0()); }
(
{ before(grammarAccess.getPreCSAccess().getStereotypePreKeyword_0_0()); }

	'pre'

{ after(grammarAccess.getPreCSAccess().getStereotypePreKeyword_0_0()); }
)

{ after(grammarAccess.getPreCSAccess().getStereotypePreKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PreCS__NameAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getPreCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PreCS__OwnedMessageSpecificationAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0()); }
	ruleSpecificationCS{ after(grammarAccess.getPreCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PreCS__OwnedSpecificationAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getPreCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrecedenceCS__IsRightAssociativeAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrecedenceCSAccess().getIsRightAssociativeRightKeyword_0_1_0()); }
(
{ before(grammarAccess.getPrecedenceCSAccess().getIsRightAssociativeRightKeyword_0_1_0()); }

	'right'

{ after(grammarAccess.getPrecedenceCSAccess().getIsRightAssociativeRightKeyword_0_1_0()); }
)

{ after(grammarAccess.getPrecedenceCSAccess().getIsRightAssociativeRightKeyword_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrecedenceCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrecedenceCSAccess().getNameNameParserRuleCall_2_0()); }
	ruleName{ after(grammarAccess.getPrecedenceCSAccess().getNameNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificationCS__OwnedExpressionAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSpecificationCSAccess().getOwnedExpressionExpCSParserRuleCall_0()); }
	ruleExpCS{ after(grammarAccess.getSpecificationCSAccess().getOwnedExpressionExpCSParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypedMultiplicityRefCS__OwnedMultiplicityAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedMultiplicityRefCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); }
	ruleMultiplicityCS{ after(grammarAccess.getTypedMultiplicityRefCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__IsTypeofAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getIsTypeofTypeofKeyword_0_0_0()); }
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getIsTypeofTypeofKeyword_0_0_0()); }

	'typeof'

{ after(grammarAccess.getTypedTypeRefCSAccess().getIsTypeofTypeofKeyword_0_0_0()); }
)

{ after(grammarAccess.getTypedTypeRefCSAccess().getIsTypeofTypeofKeyword_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__OwnedPathNameAssignment_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameLibPathNameCSParserRuleCall_0_2_0()); }
	ruleLibPathNameCS{ after(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameLibPathNameCSParserRuleCall_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__OwnedPathNameAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameLibPathNameCSParserRuleCall_1_0_0()); }
	ruleLibPathNameCS{ after(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameLibPathNameCSParserRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__OwnedBindingAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_1_0()); }
	ruleTemplateBindingCS{ after(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TuplePartCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTuplePartCSAccess().getNameIdentifierParserRuleCall_0_0()); }
	ruleIdentifier{ after(grammarAccess.getTuplePartCSAccess().getNameIdentifierParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TuplePartCS__OwnedTypeAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__URIPathNameCS__OwnedPathElementsAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsURIFirstPathElementCSParserRuleCall_0_0()); }
	ruleURIFirstPathElementCS{ after(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsURIFirstPathElementCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__URIPathNameCS__OwnedPathElementsAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); }
	ruleNextPathElementCS{ after(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__URIFirstPathElementCS__ReferredElementAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0_0()); }
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_0_1()); }
)
{ after(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__URIFirstPathElementCS__ReferredElementAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceCrossReference_1_1_0()); }
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceURIParserRuleCall_1_1_0_1()); }
	ruleURI{ after(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceURIParserRuleCall_1_1_0_1()); }
)
{ after(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceCrossReference_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrimitiveTypeCS__NameAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); }
	rulePrimitiveTypeIdentifier{ after(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); }
	ruleCollectionTypeIdentifier{ after(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__OwnedTypeAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpWithoutMultiplicityCSParserRuleCall_1_1_0()); }
	ruleTypeExpWithoutMultiplicityCS{ after(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpWithoutMultiplicityCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__OwnedCollectionMultiplicityAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getOwnedCollectionMultiplicityMultiplicityCSParserRuleCall_1_2_0()); }
	ruleMultiplicityCS{ after(grammarAccess.getCollectionTypeCSAccess().getOwnedCollectionMultiplicityMultiplicityCSParserRuleCall_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getNameMapKeyword_0_0()); }
(
{ before(grammarAccess.getMapTypeCSAccess().getNameMapKeyword_0_0()); }

	'Map'

{ after(grammarAccess.getMapTypeCSAccess().getNameMapKeyword_0_0()); }
)

{ after(grammarAccess.getMapTypeCSAccess().getNameMapKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__OwnedKeyTypeAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__OwnedValueTypeAssignment_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0()); }
	ruleTypeExpCS{ after(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getNameTupleKeyword_0_0()); }
(
{ before(grammarAccess.getTupleTypeCSAccess().getNameTupleKeyword_0_0()); }

	'Tuple'

{ after(grammarAccess.getTupleTypeCSAccess().getNameTupleKeyword_0_0()); }
)

{ after(grammarAccess.getTupleTypeCSAccess().getNameTupleKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__OwnedPartsAssignment_1_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); }
	ruleTuplePartCS{ after(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__OwnedPartsAssignment_1_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); }
	ruleTuplePartCS{ after(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__OwnedTypeAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); }
	ruleCollectionTypeCS{ after(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__OwnedPartsAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); }
	ruleCollectionLiteralPartCS{ after(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__OwnedPartsAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); }
	ruleCollectionLiteralPartCS{ after(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__OwnedExpressionAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0()); }
	ruleExpCS{ after(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__OwnedLastExpressionAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionExpCSParserRuleCall_0_1_1_0()); }
	ruleExpCS{ after(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionExpCSParserRuleCall_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__OwnedExpressionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionPatternExpCSParserRuleCall_1_0()); }
	rulePatternExpCS{ after(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionPatternExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__OwnedTypeAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); }
	ruleCollectionTypeCS{ after(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__OwnedPartsAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0()); }
	rulePatternExpCS{ after(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__OwnedPartsAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0()); }
	rulePatternExpCS{ after(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__RestVariableNameAssignment_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0()); }
	ruleIdentifier{ after(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__ReferredPropertyAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyCrossReference_0_0_0()); }
(
{ before(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyUnrestrictedNameParserRuleCall_0_0_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyUnrestrictedNameParserRuleCall_0_0_0_1()); }
)
{ after(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyCrossReference_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__OwnedInitExpressionAssignment_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAlternatives_0_2_0()); }
(rule__ShadowPartCS__OwnedInitExpressionAlternatives_0_2_0)
{ after(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAlternatives_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__OwnedInitExpressionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionStringLiteralExpCSParserRuleCall_1_0()); }
	ruleStringLiteralExpCS{ after(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionStringLiteralExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PatternExpCS__PatternVariableNameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PatternExpCS__OwnedPatternTypeAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeTypeExpCSParserRuleCall_2_0()); }
	ruleTypeExpCS{ after(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeTypeExpCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaLiteralExpCS__OwnedExpressionCSAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0()); }
	ruleExpCS{ after(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__OwnedTypeAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0()); }
	ruleMapTypeCS{ after(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__OwnedPartsAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0()); }
	ruleMapLiteralPartCS{ after(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__OwnedPartsAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0()); }
	ruleMapLiteralPartCS{ after(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralPartCS__OwnedKeyAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0()); }
	ruleExpCS{ after(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralPartCS__OwnedValueAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0()); }
	ruleExpCS{ after(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__OwnedPartsAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); }
	ruleTupleLiteralPartCS{ after(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__OwnedPartsAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); }
	ruleTupleLiteralPartCS{ after(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__OwnedTypeAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__OwnedInitExpressionAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_0()); }
	ruleExpCS{ after(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NumberLiteralExpCS__SymbolAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0()); }
	ruleNUMBER_LITERAL{ after(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StringLiteralExpCS__SegmentsAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0()); }
	ruleStringLiteral{ after(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteralExpCS__SymbolAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolTrueKeyword_0_0()); }
(
{ before(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolTrueKeyword_0_0()); }

	'true'

{ after(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolTrueKeyword_0_0()); }
)

{ after(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolTrueKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteralExpCS__SymbolAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolFalseKeyword_1_0()); }
(
{ before(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolFalseKeyword_1_0()); }

	'false'

{ after(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolFalseKeyword_1_0()); }
)

{ after(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolFalseKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeLiteralWithMultiplicityCS__OwnedMultiplicityAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); }
	ruleMultiplicityCS{ after(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeLiteralExpCS__OwnedTypeAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); }
	ruleTypeLiteralWithMultiplicityCS{ after(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__OwnedPathNameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); }
	rulePathNameCS{ after(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__OwnedCurlyBracketedClauseAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0()); }
	ruleCurlyBracketedClauseCS{ after(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__OwnedPatternGuardAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0()); }
	ruleExpCS{ after(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeExpCS__OwnedMultiplicityAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); }
	ruleMultiplicityCS{ after(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__NameAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); }
	ruleBinaryOperatorName{ after(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__OwnedRightAssignment_0_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); }
	ruleExpCS{ after(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedLetExpCS__NameAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); }
	ruleUnaryOperatorName{ after(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedLetExpCS__OwnedRightAssignment_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0()); }
	rulePrefixedLetExpCS{ after(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedPrimaryExpCS__NameAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); }
	ruleUnaryOperatorName{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedPrimaryExpCS__OwnedRightAssignment_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0()); }
	rulePrefixedPrimaryExpCS{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__OwnedPathNameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); }
	rulePathNameCS{ after(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__OwnedSquareBracketedClausesAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0()); }
	ruleSquareBracketedClauseCS{ after(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__OwnedRoundBracketedClauseAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0()); }
	ruleRoundBracketedClauseCS{ after(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__OwnedCurlyBracketedClauseAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0()); }
	ruleCurlyBracketedClauseCS{ after(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__IsPreAssignment_4_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0()); }
(
{ before(grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0()); }

	'@'

{ after(grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0()); }
)

{ after(grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__OwnedPartsAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_0()); }
	ruleShadowPartCS{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__OwnedPartsAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_1_1_0()); }
	ruleShadowPartCS{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0()); }
	ruleNavigatingArgCS{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAlternatives_2_1_0()); }
(rule__RoundBracketedClauseCS__OwnedArgumentsAlternatives_2_1_0)
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAlternatives_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__OwnedTermsAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0()); }
	ruleExpCS{ after(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__OwnedTermsAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0()); }
	ruleExpCS{ after(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedNameExpressionAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0()); }
	ruleNavigatingArgExpCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedCoIteratorAssignment_0_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_0_1_0()); }
	ruleCoIteratorVariableCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_0_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0()); }
	ruleExpCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedTypeAssignment_0_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_1_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedCoIteratorAssignment_0_1_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_1_2_1_0()); }
	ruleCoIteratorVariableCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_1_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_3_1_0()); }
	ruleExpCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedTypeAssignment_0_1_2_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_2_0_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_2_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedCoIteratorAssignment_0_1_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_2_1_1_0()); }
	ruleCoIteratorVariableCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_2_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_2_3_0()); }
	ruleExpCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_2_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedTypeAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__PrefixAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getPrefixVerticalLineKeyword_0_0()); }
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getPrefixVerticalLineKeyword_0_0()); }

	'|'

{ after(grammarAccess.getNavigatingBarArgCSAccess().getPrefixVerticalLineKeyword_0_0()); }
)

{ after(grammarAccess.getNavigatingBarArgCSAccess().getPrefixVerticalLineKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__OwnedNameExpressionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); }
	ruleNavigatingArgExpCS{ after(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__OwnedTypeAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__OwnedInitExpressionAssignment_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); }
	ruleExpCS{ after(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__PrefixAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixCommaKeyword_0_0()); }
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixCommaKeyword_0_0()); }

	','

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixCommaKeyword_0_0()); }
)

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixCommaKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__OwnedNameExpressionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); }
	ruleNavigatingArgExpCS{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__OwnedCoIteratorAssignment_2_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_0_1_0()); }
	ruleCoIteratorVariableCS{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_0_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0()); }
	ruleExpCS{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__OwnedTypeAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__OwnedCoIteratorAssignment_2_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_1_2_1_0()); }
	ruleCoIteratorVariableCS{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_1_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_3_1_0()); }
	ruleExpCS{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__OwnedTypeAssignment_2_2_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_2_0_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_2_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__OwnedCoIteratorAssignment_2_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_2_1_1_0()); }
	ruleCoIteratorVariableCS{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_2_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_3_0()); }
	ruleExpCS{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__PrefixAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixSemicolonKeyword_0_0()); }
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixSemicolonKeyword_0_0()); }

	';'

{ after(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixSemicolonKeyword_0_0()); }
)

{ after(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixSemicolonKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__OwnedNameExpressionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); }
	ruleNavigatingArgExpCS{ after(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__OwnedTypeAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__OwnedInitExpressionAssignment_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); }
	ruleExpCS{ after(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CoIteratorVariableCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCoIteratorVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getCoIteratorVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CoIteratorVariableCS__OwnedTypeAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCoIteratorVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getCoIteratorVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__OwnedConditionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedConditionAlternatives_1_0()); }
(rule__IfExpCS__OwnedConditionAlternatives_1_0)
{ after(grammarAccess.getIfExpCSAccess().getOwnedConditionAlternatives_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__OwnedThenExpressionAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); }
	ruleExpCS{ after(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__OwnedIfThenExpressionsAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0()); }
	ruleElseIfThenExpCS{ after(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__OwnedElseExpressionAssignment_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0()); }
	ruleExpCS{ after(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ElseIfThenExpCS__OwnedConditionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0()); }
	ruleExpCS{ after(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ElseIfThenExpCS__OwnedThenExpressionAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); }
	ruleExpCS{ after(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__OwnedVariablesAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0()); }
	ruleLetVariableCS{ after(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__OwnedVariablesAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0()); }
	ruleLetVariableCS{ after(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__OwnedInExpressionAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0()); }
	ruleExpCS{ after(grammarAccess.getLetExpCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__OwnedRoundBracketedClauseAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0()); }
	ruleRoundBracketedClauseCS{ after(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__OwnedTypeAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__OwnedInitExpressionAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_4_0()); }
	ruleExpCS{ after(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NestedExpCS__OwnedExpressionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0()); }
	ruleExpCS{ after(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityBoundsCS__LowerBoundAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); }
	ruleLOWER{ after(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); }
	ruleUPPER{ after(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityCS__IsNullFreeAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0()); }
(
{ before(grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0()); }

	'|1'

{ after(grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0()); }
)

{ after(grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityStringCS__StringBoundsAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0()); }
(rule__MultiplicityStringCS__StringBoundsAlternatives_0)
{ after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PathNameCS__OwnedPathElementsAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); }
	ruleFirstPathElementCS{ after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PathNameCS__OwnedPathElementsAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); }
	ruleNextPathElementCS{ after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__FirstPathElementCS__ReferredElementAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); }
(
{ before(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1()); }
)
{ after(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NextPathElementCS__ReferredElementAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); }
(
{ before(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementUnreservedNameParserRuleCall_0_1()); }
	ruleUnreservedName{ after(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementUnreservedNameParserRuleCall_0_1()); }
)
{ after(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); }
	ruleTemplateParameterSubstitutionCS{ after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); }
	ruleTemplateParameterSubstitutionCS{ after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__OwnedMultiplicityAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0()); }
	ruleMultiplicityCS{ after(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); }
	ruleTypeRefCS{ after(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__OwnedParametersAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_1_0()); }
	ruleTypeParameterCS{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__OwnedParametersAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_2_1_0()); }
	ruleTypeParameterCS{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__OwnedExtendsAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


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


