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
grammar InternalOCLinEcore;

options {
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;

}

@lexer::header {
package org.eclipse.ocl.xtext.oclinecore.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import.
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.ocl.xtext.oclinecore.ui.contentassist.antlr.internal;

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
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess;

}

@parser::members {

 	private OCLinEcoreGrammarAccess grammarAccess;

    public void setGrammarAccess(OCLinEcoreGrammarAccess grammarAccess) {
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




// Entry rule entryRuleTopLevelCS
entryRuleTopLevelCS
:
{ before(grammarAccess.getTopLevelCSRule()); }
	 ruleTopLevelCS
{ after(grammarAccess.getTopLevelCSRule()); }
	 EOF
;

// Rule TopLevelCS
ruleTopLevelCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTopLevelCSAccess().getGroup()); }
(rule__TopLevelCS__Group__0)
{ after(grammarAccess.getTopLevelCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}





// Entry rule entryRuleSIGNED
entryRuleSIGNED
:
{ before(grammarAccess.getSIGNEDRule()); }
	 ruleSIGNED
{ after(grammarAccess.getSIGNEDRule()); }
	 EOF
;

// Rule SIGNED
ruleSIGNED
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSIGNEDAccess().getGroup()); }
(rule__SIGNED__Group__0)
{ after(grammarAccess.getSIGNEDAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEnumerationLiteralName
entryRuleEnumerationLiteralName
:
{ before(grammarAccess.getEnumerationLiteralNameRule()); }
	 ruleEnumerationLiteralName
{ after(grammarAccess.getEnumerationLiteralNameRule()); }
	 EOF
;

// Rule EnumerationLiteralName
ruleEnumerationLiteralName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getAlternatives()); }
(rule__EnumerationLiteralName__Alternatives)
{ after(grammarAccess.getEnumerationLiteralNameAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleInvariantConstraintCS
entryRuleInvariantConstraintCS
:
{ before(grammarAccess.getInvariantConstraintCSRule()); }
	 ruleInvariantConstraintCS
{ after(grammarAccess.getInvariantConstraintCSRule()); }
	 EOF
;

// Rule InvariantConstraintCS
ruleInvariantConstraintCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getGroup()); }
(rule__InvariantConstraintCS__Group__0)
{ after(grammarAccess.getInvariantConstraintCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePostconditionConstraintCS
entryRulePostconditionConstraintCS
:
{ before(grammarAccess.getPostconditionConstraintCSRule()); }
	 rulePostconditionConstraintCS
{ after(grammarAccess.getPostconditionConstraintCSRule()); }
	 EOF
;

// Rule PostconditionConstraintCS
rulePostconditionConstraintCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getGroup()); }
(rule__PostconditionConstraintCS__Group__0)
{ after(grammarAccess.getPostconditionConstraintCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePreconditionConstraintCS
entryRulePreconditionConstraintCS
:
{ before(grammarAccess.getPreconditionConstraintCSRule()); }
	 rulePreconditionConstraintCS
{ after(grammarAccess.getPreconditionConstraintCSRule()); }
	 EOF
;

// Rule PreconditionConstraintCS
rulePreconditionConstraintCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getGroup()); }
(rule__PreconditionConstraintCS__Group__0)
{ after(grammarAccess.getPreconditionConstraintCSAccess().getGroup()); }
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



// Entry rule entryRuleAttributeCS
entryRuleAttributeCS
:
{ before(grammarAccess.getAttributeCSRule()); }
	 ruleAttributeCS
{ after(grammarAccess.getAttributeCSRule()); }
	 EOF
;

// Rule AttributeCS
ruleAttributeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAttributeCSAccess().getGroup()); }
(rule__AttributeCS__Group__0)
{ after(grammarAccess.getAttributeCSAccess().getGroup()); }
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
{ before(grammarAccess.getClassCSAccess().getAlternatives()); }
(rule__ClassCS__Alternatives)
{ after(grammarAccess.getClassCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDataTypeCS
entryRuleDataTypeCS
:
{ before(grammarAccess.getDataTypeCSRule()); }
	 ruleDataTypeCS
{ after(grammarAccess.getDataTypeCSRule()); }
	 EOF
;

// Rule DataTypeCS
ruleDataTypeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDataTypeCSAccess().getGroup()); }
(rule__DataTypeCS__Group__0)
{ after(grammarAccess.getDataTypeCSAccess().getGroup()); }
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



// Entry rule entryRuleEnumerationCS
entryRuleEnumerationCS
:
{ before(grammarAccess.getEnumerationCSRule()); }
	 ruleEnumerationCS
{ after(grammarAccess.getEnumerationCSRule()); }
	 EOF
;

// Rule EnumerationCS
ruleEnumerationCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEnumerationCSAccess().getGroup()); }
(rule__EnumerationCS__Group__0)
{ after(grammarAccess.getEnumerationCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEnumerationLiteralCS
entryRuleEnumerationLiteralCS
:
{ before(grammarAccess.getEnumerationLiteralCSRule()); }
	 ruleEnumerationLiteralCS
{ after(grammarAccess.getEnumerationLiteralCSRule()); }
	 EOF
;

// Rule EnumerationLiteralCS
ruleEnumerationLiteralCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getGroup()); }
(rule__EnumerationLiteralCS__Group__0)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getGroup()); }
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



// Entry rule entryRuleModelElementCS
entryRuleModelElementCS
:
{ before(grammarAccess.getModelElementCSRule()); }
	 ruleModelElementCS
{ after(grammarAccess.getModelElementCSRule()); }
	 EOF
;

// Rule ModelElementCS
ruleModelElementCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getModelElementCSAccess().getAlternatives()); }
(rule__ModelElementCS__Alternatives)
{ after(grammarAccess.getModelElementCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleModelElementRefCS
entryRuleModelElementRefCS
:
{ before(grammarAccess.getModelElementRefCSRule()); }
	 ruleModelElementRefCS
{ after(grammarAccess.getModelElementRefCSRule()); }
	 EOF
;

// Rule ModelElementRefCS
ruleModelElementRefCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getModelElementRefCSAccess().getGroup()); }
(rule__ModelElementRefCS__Group__0)
{ after(grammarAccess.getModelElementRefCSAccess().getGroup()); }
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
{ before(grammarAccess.getOperationCSAccess().getGroup()); }
(rule__OperationCS__Group__0)
{ after(grammarAccess.getOperationCSAccess().getGroup()); }
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



// Entry rule entryRuleImplicitOppositeCS
entryRuleImplicitOppositeCS
:
{ before(grammarAccess.getImplicitOppositeCSRule()); }
	 ruleImplicitOppositeCS
{ after(grammarAccess.getImplicitOppositeCSRule()); }
	 EOF
;

// Rule ImplicitOppositeCS
ruleImplicitOppositeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getGroup()); }
(rule__ImplicitOppositeCS__Group__0)
{ after(grammarAccess.getImplicitOppositeCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleReferenceCS
entryRuleReferenceCS
:
{ before(grammarAccess.getReferenceCSRule()); }
	 ruleReferenceCS
{ after(grammarAccess.getReferenceCSRule()); }
	 EOF
;

// Rule ReferenceCS
ruleReferenceCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup()); }
(rule__ReferenceCS__Group__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup()); }
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
{ before(grammarAccess.getSpecificationCSAccess().getAlternatives()); }
(rule__SpecificationCS__Alternatives)
{ after(grammarAccess.getSpecificationCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStructuredClassCS
entryRuleStructuredClassCS
:
{ before(grammarAccess.getStructuredClassCSRule()); }
	 ruleStructuredClassCS
{ after(grammarAccess.getStructuredClassCSRule()); }
	 EOF
;

// Rule StructuredClassCS
ruleStructuredClassCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStructuredClassCSAccess().getGroup()); }
(rule__StructuredClassCS__Group__0)
{ after(grammarAccess.getStructuredClassCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStructuralFeatureCS
entryRuleStructuralFeatureCS
:
{ before(grammarAccess.getStructuralFeatureCSRule()); }
	 ruleStructuralFeatureCS
{ after(grammarAccess.getStructuralFeatureCSRule()); }
	 EOF
;

// Rule StructuralFeatureCS
ruleStructuralFeatureCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStructuralFeatureCSAccess().getAlternatives()); }
(rule__StructuralFeatureCS__Alternatives)
{ after(grammarAccess.getStructuralFeatureCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSysMLCS
entryRuleSysMLCS
:
{ before(grammarAccess.getSysMLCSRule()); }
	 ruleSysMLCS
{ after(grammarAccess.getSysMLCSRule()); }
	 EOF
;

// Rule SysMLCS
ruleSysMLCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSysMLCSAccess().getGroup()); }
(rule__SysMLCS__Group__0)
{ after(grammarAccess.getSysMLCSAccess().getGroup()); }
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
{ before(grammarAccess.getTemplateSignatureCSAccess().getAlternatives()); }
(rule__TemplateSignatureCS__Alternatives)
{ after(grammarAccess.getTemplateSignatureCSAccess().getAlternatives()); }
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
{ before(grammarAccess.getTypedTypeRefCSAccess().getGroup()); }
(rule__TypedTypeRefCS__Group__0)
{ after(grammarAccess.getTypedTypeRefCSAccess().getGroup()); }
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
{ before(grammarAccess.getUnrestrictedNameAccess().getAlternatives()); }
(rule__UnrestrictedName__Alternatives)
{ after(grammarAccess.getUnrestrictedNameAccess().getAlternatives()); }
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
{ before(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); }
	ruleID
{ after(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); }
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




rule__EnumerationLiteralName__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0()); }
	ruleEssentialOCLUnrestrictedName
{ after(grammarAccess.getEnumerationLiteralNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getAbstractKeyword_1()); }

	'abstract'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getAbstractKeyword_1()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getAttributeKeyword_2()); }

	'attribute'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getAttributeKeyword_2()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getBodyKeyword_3()); }

	'body'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getBodyKeyword_3()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getCallableKeyword_4()); }

	'callable'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getCallableKeyword_4()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getClassKeyword_5()); }

	'class'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getClassKeyword_5()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getComposesKeyword_6()); }

	'composes'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getComposesKeyword_6()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getDatatypeKeyword_7()); }

	'datatype'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getDatatypeKeyword_7()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getDefinitionKeyword_8()); }

	'definition'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getDefinitionKeyword_8()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getDerivationKeyword_9()); }

	'derivation'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getDerivationKeyword_9()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getDerivedKeyword_10()); }

	'derived'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getDerivedKeyword_10()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getEnumKeyword_11()); }

	'enum'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getEnumKeyword_11()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getExtendsKeyword_12()); }

	'extends'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getExtendsKeyword_12()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getIdKeyword_13()); }

	'id'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getIdKeyword_13()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getImportKeyword_14()); }

	'import'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getImportKeyword_14()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getInitialKeyword_15()); }

	'initial'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getInitialKeyword_15()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getInterfaceKeyword_16()); }

	'interface'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getInterfaceKeyword_16()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getKeyKeyword_17()); }

	'key'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getKeyKeyword_17()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getLibraryKeyword_18()); }

	'library'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getLibraryKeyword_18()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getModuleKeyword_19()); }

	'module'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getModuleKeyword_19()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getOperationKeyword_20()); }

	'operation'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getOperationKeyword_20()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getOrderedKeyword_21()); }

	'ordered'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getOrderedKeyword_21()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getPackageKeyword_22()); }

	'package'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getPackageKeyword_22()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getPostconditionKeyword_23()); }

	'postcondition'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getPostconditionKeyword_23()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getPreconditionKeyword_24()); }

	'precondition'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getPreconditionKeyword_24()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getPrimitiveKeyword_25()); }

	'primitive'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getPrimitiveKeyword_25()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getPropertyKeyword_26()); }

	'property'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getPropertyKeyword_26()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getReadonlyKeyword_27()); }

	'readonly'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getReadonlyKeyword_27()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getReferenceKeyword_28()); }

	'reference'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getReferenceKeyword_28()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getResolveKeyword_29()); }

	'resolve'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getResolveKeyword_29()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getStaticKeyword_30()); }

	'static'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getStaticKeyword_30()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getThrowsKeyword_31()); }

	'throws'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getThrowsKeyword_31()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getTransientKeyword_32()); }

	'transient'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getTransientKeyword_32()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getUniqueKeyword_33()); }

	'unique'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getUniqueKeyword_33()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getUnsettableKeyword_34()); }

	'unsettable'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getUnsettableKeyword_34()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getVolatileKeyword_35()); }

	'volatile'

{ after(grammarAccess.getEnumerationLiteralNameAccess().getVolatileKeyword_35()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__Alternatives_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getGroup_3_0()); }
(rule__InvariantConstraintCS__Group_3_0__0)
{ after(grammarAccess.getInvariantConstraintCSAccess().getGroup_3_0()); }
)

    |(
{ before(grammarAccess.getInvariantConstraintCSAccess().getSemicolonKeyword_3_1()); }

	';'

{ after(grammarAccess.getInvariantConstraintCSAccess().getSemicolonKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__NameAlternatives_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getNameUnrestrictedNameParserRuleCall_2_0_0()); }
	ruleUnrestrictedName
{ after(grammarAccess.getAnnotationCSAccess().getNameUnrestrictedNameParserRuleCall_2_0_0()); }
)

    |(
{ before(grammarAccess.getAnnotationCSAccess().getNameSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1()); }
	RULE_SINGLE_QUOTED_STRING
{ after(grammarAccess.getAnnotationCSAccess().getNameSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Alternatives_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getGroup_4_0()); }
(rule__AnnotationCS__Group_4_0__0)
{ after(grammarAccess.getAnnotationCSAccess().getGroup_4_0()); }
)

    |(
{ before(grammarAccess.getAnnotationCSAccess().getSemicolonKeyword_4_1()); }

	';'

{ after(grammarAccess.getAnnotationCSAccess().getSemicolonKeyword_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Alternatives_4_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedAnnotationsAssignment_4_0_1_0()); }
(rule__AnnotationCS__OwnedAnnotationsAssignment_4_0_1_0)
{ after(grammarAccess.getAnnotationCSAccess().getOwnedAnnotationsAssignment_4_0_1_0()); }
)

    |(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedContentsAssignment_4_0_1_1()); }
(rule__AnnotationCS__OwnedContentsAssignment_4_0_1_1)
{ after(grammarAccess.getAnnotationCSAccess().getOwnedContentsAssignment_4_0_1_1()); }
)

    |(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedReferencesAssignment_4_0_1_2()); }
(rule__AnnotationCS__OwnedReferencesAssignment_4_0_1_2)
{ after(grammarAccess.getAnnotationCSAccess().getOwnedReferencesAssignment_4_0_1_2()); }
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

    |(
{ before(grammarAccess.getAnnotationElementCSAccess().getSysMLCSParserRuleCall_2()); }
	ruleSysMLCS
{ after(grammarAccess.getAnnotationElementCSAccess().getSysMLCSParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_0_0()); }
(rule__AttributeCS__Group_0_0__0)
{ after(grammarAccess.getAttributeCSAccess().getGroup_0_0()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getGroup_0_1()); }
(rule__AttributeCS__Group_0_1__0)
{ after(grammarAccess.getAttributeCSAccess().getGroup_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Alternatives_5_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_0()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_0)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_0()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_1()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_1)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_1()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_2()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_2)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_2()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_3()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_3)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_3()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_4()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_4)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_4()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_5()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_5)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_5()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_6()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_6)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_6()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_7()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_7)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_7()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_8()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_8)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_8()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_9()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_9)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_9()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_10()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_10)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_10()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_11()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_11)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_11()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_12()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_12)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_12()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_13()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_13)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_13()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_14()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_14)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_14()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_15()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_15)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_15()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Alternatives_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_6_0()); }
(rule__AttributeCS__Group_6_0__0)
{ after(grammarAccess.getAttributeCSAccess().getGroup_6_0()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_1()); }

	';'

{ after(grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Alternatives_6_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getOwnedAnnotationsAssignment_6_0_1_0()); }
(rule__AttributeCS__OwnedAnnotationsAssignment_6_0_1_0)
{ after(grammarAccess.getAttributeCSAccess().getOwnedAnnotationsAssignment_6_0_1_0()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getGroup_6_0_1_1()); }
(rule__AttributeCS__Group_6_0_1_1__0)
{ after(grammarAccess.getAttributeCSAccess().getGroup_6_0_1_1()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getGroup_6_0_1_2()); }
(rule__AttributeCS__Group_6_0_1_2__0)
{ after(grammarAccess.getAttributeCSAccess().getGroup_6_0_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ClassCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getClassCSAccess().getStructuredClassCSParserRuleCall_0()); }
	ruleStructuredClassCS
{ after(grammarAccess.getClassCSAccess().getStructuredClassCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getClassCSAccess().getDataTypeCSParserRuleCall_1()); }
	ruleDataTypeCS
{ after(grammarAccess.getClassCSAccess().getDataTypeCSParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getClassCSAccess().getEnumerationCSParserRuleCall_2()); }
	ruleEnumerationCS
{ after(grammarAccess.getClassCSAccess().getEnumerationCSParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Alternatives_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getIsSerializableAssignment_5_1_0()); }
(rule__DataTypeCS__IsSerializableAssignment_5_1_0)
{ after(grammarAccess.getDataTypeCSAccess().getIsSerializableAssignment_5_1_0()); }
)

    |(
{ before(grammarAccess.getDataTypeCSAccess().getSerializableKeyword_5_1_1()); }

	'!serializable'

{ after(grammarAccess.getDataTypeCSAccess().getSerializableKeyword_5_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Alternatives_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getGroup_6_0()); }
(rule__DataTypeCS__Group_6_0__0)
{ after(grammarAccess.getDataTypeCSAccess().getGroup_6_0()); }
)

    |(
{ before(grammarAccess.getDataTypeCSAccess().getSemicolonKeyword_6_1()); }

	';'

{ after(grammarAccess.getDataTypeCSAccess().getSemicolonKeyword_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Alternatives_6_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getOwnedAnnotationsAssignment_6_0_1_0()); }
(rule__DataTypeCS__OwnedAnnotationsAssignment_6_0_1_0)
{ after(grammarAccess.getDataTypeCSAccess().getOwnedAnnotationsAssignment_6_0_1_0()); }
)

    |(
{ before(grammarAccess.getDataTypeCSAccess().getOwnedConstraintsAssignment_6_0_1_1()); }
(rule__DataTypeCS__OwnedConstraintsAssignment_6_0_1_1)
{ after(grammarAccess.getDataTypeCSAccess().getOwnedConstraintsAssignment_6_0_1_1()); }
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
{ before(grammarAccess.getDetailCSAccess().getNameUnrestrictedNameParserRuleCall_0_0_0()); }
	ruleUnrestrictedName
{ after(grammarAccess.getDetailCSAccess().getNameUnrestrictedNameParserRuleCall_0_0_0()); }
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

rule__EnumerationCS__Alternatives_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getIsSerializableAssignment_4_1_0()); }
(rule__EnumerationCS__IsSerializableAssignment_4_1_0)
{ after(grammarAccess.getEnumerationCSAccess().getIsSerializableAssignment_4_1_0()); }
)

    |(
{ before(grammarAccess.getEnumerationCSAccess().getSerializableKeyword_4_1_1()); }

	'!serializable'

{ after(grammarAccess.getEnumerationCSAccess().getSerializableKeyword_4_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Alternatives_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getGroup_5_0()); }
(rule__EnumerationCS__Group_5_0__0)
{ after(grammarAccess.getEnumerationCSAccess().getGroup_5_0()); }
)

    |(
{ before(grammarAccess.getEnumerationCSAccess().getSemicolonKeyword_5_1()); }

	';'

{ after(grammarAccess.getEnumerationCSAccess().getSemicolonKeyword_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Alternatives_5_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getOwnedAnnotationsAssignment_5_0_1_0()); }
(rule__EnumerationCS__OwnedAnnotationsAssignment_5_0_1_0)
{ after(grammarAccess.getEnumerationCSAccess().getOwnedAnnotationsAssignment_5_0_1_0()); }
)

    |(
{ before(grammarAccess.getEnumerationCSAccess().getOwnedLiteralsAssignment_5_0_1_1()); }
(rule__EnumerationCS__OwnedLiteralsAssignment_5_0_1_1)
{ after(grammarAccess.getEnumerationCSAccess().getOwnedLiteralsAssignment_5_0_1_1()); }
)

    |(
{ before(grammarAccess.getEnumerationCSAccess().getOwnedConstraintsAssignment_5_0_1_2()); }
(rule__EnumerationCS__OwnedConstraintsAssignment_5_0_1_2)
{ after(grammarAccess.getEnumerationCSAccess().getOwnedConstraintsAssignment_5_0_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getGroup_0_0()); }
(rule__EnumerationLiteralCS__Group_0_0__0)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getGroup_0_0()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getNameAssignment_0_1()); }
(rule__EnumerationLiteralCS__NameAssignment_0_1)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getNameAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Alternatives_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getGroup_3_0()); }
(rule__EnumerationLiteralCS__Group_3_0__0)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getGroup_3_0()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getSemicolonKeyword_3_1()); }

	';'

{ after(grammarAccess.getEnumerationLiteralCSAccess().getSemicolonKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getImportKeyword_0_0()); }

	'import'

{ after(grammarAccess.getImportCSAccess().getImportKeyword_0_0()); }
)

    |(
{ before(grammarAccess.getImportCSAccess().getLibraryKeyword_0_1()); }

	'library'

{ after(grammarAccess.getImportCSAccess().getLibraryKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModelElementCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelElementCSAccess().getClassCSParserRuleCall_0()); }
	ruleClassCS
{ after(grammarAccess.getModelElementCSAccess().getClassCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getModelElementCSAccess().getEnumerationLiteralCSParserRuleCall_1()); }
	ruleEnumerationLiteralCS
{ after(grammarAccess.getModelElementCSAccess().getEnumerationLiteralCSParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getModelElementCSAccess().getOperationCSParserRuleCall_2()); }
	ruleOperationCS
{ after(grammarAccess.getModelElementCSAccess().getOperationCSParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getModelElementCSAccess().getPackageCSParserRuleCall_3()); }
	rulePackageCS
{ after(grammarAccess.getModelElementCSAccess().getPackageCSParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getModelElementCSAccess().getStructuralFeatureCSParserRuleCall_4()); }
	ruleStructuralFeatureCS
{ after(grammarAccess.getModelElementCSAccess().getStructuralFeatureCSParserRuleCall_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_0_0()); }
(rule__OperationCS__Group_0_0__0)
{ after(grammarAccess.getOperationCSAccess().getGroup_0_0()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getGroup_0_1()); }
(rule__OperationCS__Group_0_1__0)
{ after(grammarAccess.getOperationCSAccess().getGroup_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Alternatives_9_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_0()); }
(rule__OperationCS__QualifiersAssignment_9_1_0_0)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_0()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_1()); }
(rule__OperationCS__QualifiersAssignment_9_1_0_1)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_1()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_2()); }
(rule__OperationCS__QualifiersAssignment_9_1_0_2)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_2()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_3()); }
(rule__OperationCS__QualifiersAssignment_9_1_0_3)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_3()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_4()); }
(rule__OperationCS__QualifiersAssignment_9_1_0_4)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_4()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_5()); }
(rule__OperationCS__QualifiersAssignment_9_1_0_5)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_5()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_6()); }
(rule__OperationCS__QualifiersAssignment_9_1_0_6)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_6()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_7()); }
(rule__OperationCS__QualifiersAssignment_9_1_0_7)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Alternatives_10
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_10_0()); }
(rule__OperationCS__Group_10_0__0)
{ after(grammarAccess.getOperationCSAccess().getGroup_10_0()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getSemicolonKeyword_10_1()); }

	';'

{ after(grammarAccess.getOperationCSAccess().getSemicolonKeyword_10_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Alternatives_10_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedAnnotationsAssignment_10_0_1_0()); }
(rule__OperationCS__OwnedAnnotationsAssignment_10_0_1_0)
{ after(grammarAccess.getOperationCSAccess().getOwnedAnnotationsAssignment_10_0_1_0()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getOwnedPreconditionsAssignment_10_0_1_1()); }
(rule__OperationCS__OwnedPreconditionsAssignment_10_0_1_1)
{ after(grammarAccess.getOperationCSAccess().getOwnedPreconditionsAssignment_10_0_1_1()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getGroup_10_0_1_2()); }
(rule__OperationCS__Group_10_0_1_2__0)
{ after(grammarAccess.getOperationCSAccess().getGroup_10_0_1_2()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getOwnedPostconditionsAssignment_10_0_1_3()); }
(rule__OperationCS__OwnedPostconditionsAssignment_10_0_1_3)
{ after(grammarAccess.getOperationCSAccess().getOwnedPostconditionsAssignment_10_0_1_3()); }
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
{ before(grammarAccess.getPackageCSAccess().getGroup_4_0()); }
(rule__PackageCS__Group_4_0__0)
{ after(grammarAccess.getPackageCSAccess().getGroup_4_0()); }
)

    |(
{ before(grammarAccess.getPackageCSAccess().getSemicolonKeyword_4_1()); }

	';'

{ after(grammarAccess.getPackageCSAccess().getSemicolonKeyword_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Alternatives_4_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getOwnedAnnotationsAssignment_4_0_1_0()); }
(rule__PackageCS__OwnedAnnotationsAssignment_4_0_1_0)
{ after(grammarAccess.getPackageCSAccess().getOwnedAnnotationsAssignment_4_0_1_0()); }
)

    |(
{ before(grammarAccess.getPackageCSAccess().getOwnedPackagesAssignment_4_0_1_1()); }
(rule__PackageCS__OwnedPackagesAssignment_4_0_1_1)
{ after(grammarAccess.getPackageCSAccess().getOwnedPackagesAssignment_4_0_1_1()); }
)

    |(
{ before(grammarAccess.getPackageCSAccess().getOwnedClassesAssignment_4_0_1_2()); }
(rule__PackageCS__OwnedClassesAssignment_4_0_1_2)
{ after(grammarAccess.getPackageCSAccess().getOwnedClassesAssignment_4_0_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Alternatives_2_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_0()); }
(rule__ParameterCS__QualifiersAssignment_2_1_0_0)
{ after(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_0()); }
)

    |(
{ before(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_1()); }
(rule__ParameterCS__QualifiersAssignment_2_1_0_1)
{ after(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_1()); }
)

    |(
{ before(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_2()); }
(rule__ParameterCS__QualifiersAssignment_2_1_0_2)
{ after(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_2()); }
)

    |(
{ before(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_3()); }
(rule__ParameterCS__QualifiersAssignment_2_1_0_3)
{ after(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__Alternatives_4_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getQualifiersAssignment_4_1_0_0()); }
(rule__ImplicitOppositeCS__QualifiersAssignment_4_1_0_0)
{ after(grammarAccess.getImplicitOppositeCSAccess().getQualifiersAssignment_4_1_0_0()); }
)

    |(
{ before(grammarAccess.getImplicitOppositeCSAccess().getQualifiersAssignment_4_1_0_1()); }
(rule__ImplicitOppositeCS__QualifiersAssignment_4_1_0_1)
{ after(grammarAccess.getImplicitOppositeCSAccess().getQualifiersAssignment_4_1_0_1()); }
)

    |(
{ before(grammarAccess.getImplicitOppositeCSAccess().getQualifiersAssignment_4_1_0_2()); }
(rule__ImplicitOppositeCS__QualifiersAssignment_4_1_0_2)
{ after(grammarAccess.getImplicitOppositeCSAccess().getQualifiersAssignment_4_1_0_2()); }
)

    |(
{ before(grammarAccess.getImplicitOppositeCSAccess().getQualifiersAssignment_4_1_0_3()); }
(rule__ImplicitOppositeCS__QualifiersAssignment_4_1_0_3)
{ after(grammarAccess.getImplicitOppositeCSAccess().getQualifiersAssignment_4_1_0_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_0_0()); }
(rule__ReferenceCS__Group_0_0__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup_0_0()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getGroup_0_1()); }
(rule__ReferenceCS__Group_0_1__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Alternatives_6_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_0()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_0)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_0()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_1()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_1)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_1()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_2()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_2)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_2()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_3()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_3)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_3()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_4()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_4)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_4()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_5()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_5)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_5()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_6()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_6)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_6()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_7()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_7)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_7()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_8()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_8)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_8()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_9()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_9)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_9()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_10()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_10)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_10()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_11()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_11)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_11()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_12()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_12)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_12()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_13()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_13)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_13()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_14()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_14)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_14()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_15()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_15)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_15()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_16()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_16)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_16()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_17()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_17)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_17()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Alternatives_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_7_0()); }
(rule__ReferenceCS__Group_7_0__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup_7_0()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_1()); }

	';'

{ after(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Alternatives_7_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedAnnotationsAssignment_7_0_1_0()); }
(rule__ReferenceCS__OwnedAnnotationsAssignment_7_0_1_0)
{ after(grammarAccess.getReferenceCSAccess().getOwnedAnnotationsAssignment_7_0_1_0()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_1()); }
(rule__ReferenceCS__Group_7_0_1_1__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_1()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_2()); }
(rule__ReferenceCS__Group_7_0_1_2__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_2()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_3()); }
(rule__ReferenceCS__Group_7_0_1_3__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_3()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_4()); }
(rule__ReferenceCS__Group_7_0_1_4__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificationCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSpecificationCSAccess().getOwnedExpressionAssignment_0()); }
(rule__SpecificationCS__OwnedExpressionAssignment_0)
{ after(grammarAccess.getSpecificationCSAccess().getOwnedExpressionAssignment_0()); }
)

    |(
{ before(grammarAccess.getSpecificationCSAccess().getExprStringAssignment_1()); }
(rule__SpecificationCS__ExprStringAssignment_1)
{ after(grammarAccess.getSpecificationCSAccess().getExprStringAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Alternatives_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getGroup_7_0()); }
(rule__StructuredClassCS__Group_7_0__0)
{ after(grammarAccess.getStructuredClassCSAccess().getGroup_7_0()); }
)

    |(
{ before(grammarAccess.getStructuredClassCSAccess().getSemicolonKeyword_7_1()); }

	';'

{ after(grammarAccess.getStructuredClassCSAccess().getSemicolonKeyword_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Alternatives_7_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedAnnotationsAssignment_7_0_1_0()); }
(rule__StructuredClassCS__OwnedAnnotationsAssignment_7_0_1_0)
{ after(grammarAccess.getStructuredClassCSAccess().getOwnedAnnotationsAssignment_7_0_1_0()); }
)

    |(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedOperationsAssignment_7_0_1_1()); }
(rule__StructuredClassCS__OwnedOperationsAssignment_7_0_1_1)
{ after(grammarAccess.getStructuredClassCSAccess().getOwnedOperationsAssignment_7_0_1_1()); }
)

    |(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedPropertiesAssignment_7_0_1_2()); }
(rule__StructuredClassCS__OwnedPropertiesAssignment_7_0_1_2)
{ after(grammarAccess.getStructuredClassCSAccess().getOwnedPropertiesAssignment_7_0_1_2()); }
)

    |(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedConstraintsAssignment_7_0_1_3()); }
(rule__StructuredClassCS__OwnedConstraintsAssignment_7_0_1_3)
{ after(grammarAccess.getStructuredClassCSAccess().getOwnedConstraintsAssignment_7_0_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuralFeatureCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuralFeatureCSAccess().getAttributeCSParserRuleCall_0()); }
	ruleAttributeCS
{ after(grammarAccess.getStructuralFeatureCSAccess().getAttributeCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getStructuralFeatureCSAccess().getReferenceCSParserRuleCall_1()); }
	ruleReferenceCS
{ after(grammarAccess.getStructuralFeatureCSAccess().getReferenceCSParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SysMLCS__Alternatives_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSysMLCSAccess().getGroup_2_0()); }
(rule__SysMLCS__Group_2_0__0)
{ after(grammarAccess.getSysMLCSAccess().getGroup_2_0()); }
)

    |(
{ before(grammarAccess.getSysMLCSAccess().getGroup_2_1()); }
(rule__SysMLCS__Group_2_1__0)
{ after(grammarAccess.getSysMLCSAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getGroup_0()); }
(rule__TemplateSignatureCS__Group_0__0)
{ after(grammarAccess.getTemplateSignatureCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getTemplateSignatureCSAccess().getGroup_1()); }
(rule__TemplateSignatureCS__Group_1__0)
{ after(grammarAccess.getTemplateSignatureCSAccess().getGroup_1()); }
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
{ before(grammarAccess.getTypedRefCSAccess().getTypeLiteralCSParserRuleCall_0()); }
	ruleTypeLiteralCS
{ after(grammarAccess.getTypedRefCSAccess().getTypeLiteralCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall_1()); }
	ruleTypedTypeRefCS
{ after(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getGroup_1_0()); }
(rule__TypedTypeRefCS__Group_1_0__0)
{ after(grammarAccess.getTypedTypeRefCSAccess().getGroup_1_0()); }
)

    |(
{ before(grammarAccess.getTypedTypeRefCSAccess().getGroup_1_1()); }
(rule__TypedTypeRefCS__Group_1_1__0)
{ after(grammarAccess.getTypedTypeRefCSAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__UnrestrictedName__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnrestrictedNameAccess().getEnumerationLiteralNameParserRuleCall_0()); }
	ruleEnumerationLiteralName
{ after(grammarAccess.getUnrestrictedNameAccess().getEnumerationLiteralNameParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getAnnotationKeyword_1()); }

	'annotation'

{ after(grammarAccess.getUnrestrictedNameAccess().getAnnotationKeyword_1()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getDocumentationKeyword_2()); }

	'documentation'

{ after(grammarAccess.getUnrestrictedNameAccess().getDocumentationKeyword_2()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getInvariantKeyword_3()); }

	'invariant'

{ after(grammarAccess.getUnrestrictedNameAccess().getInvariantKeyword_3()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getLiteralKeyword_4()); }

	'literal'

{ after(grammarAccess.getUnrestrictedNameAccess().getLiteralKeyword_4()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getOppositeKeyword_5()); }

	'opposite'

{ after(grammarAccess.getUnrestrictedNameAccess().getOppositeKeyword_5()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getSerializableKeyword_6()); }

	'serializable'

{ after(grammarAccess.getUnrestrictedNameAccess().getSerializableKeyword_6()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getSysmlKeyword_7()); }

	'sysml'

{ after(grammarAccess.getUnrestrictedNameAccess().getSysmlKeyword_7()); }
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



rule__TopLevelCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TopLevelCS__Group__0__Impl
	rule__TopLevelCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TopLevelCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getTopLevelCSAction_0()); }
(

)
{ after(grammarAccess.getTopLevelCSAccess().getTopLevelCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TopLevelCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TopLevelCS__Group__1__Impl
	rule__TopLevelCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TopLevelCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getGroup_1()); }
(rule__TopLevelCS__Group_1__0)?
{ after(grammarAccess.getTopLevelCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TopLevelCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TopLevelCS__Group__2__Impl
	rule__TopLevelCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TopLevelCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getOwnedImportsAssignment_2()); }
(rule__TopLevelCS__OwnedImportsAssignment_2)*
{ after(grammarAccess.getTopLevelCSAccess().getOwnedImportsAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TopLevelCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TopLevelCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TopLevelCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getOwnedPackagesAssignment_3()); }
(rule__TopLevelCS__OwnedPackagesAssignment_3)*
{ after(grammarAccess.getTopLevelCSAccess().getOwnedPackagesAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__TopLevelCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TopLevelCS__Group_1__0__Impl
	rule__TopLevelCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TopLevelCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getModuleKeyword_1_0()); }

	'module'

{ after(grammarAccess.getTopLevelCSAccess().getModuleKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TopLevelCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TopLevelCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TopLevelCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getUnrestrictedNameParserRuleCall_1_1()); }
	ruleUnrestrictedName
{ after(grammarAccess.getTopLevelCSAccess().getUnrestrictedNameParserRuleCall_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SIGNED__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SIGNED__Group__0__Impl
	rule__SIGNED__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SIGNED__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSIGNEDAccess().getHyphenMinusKeyword_0()); }
(
	'-'
)?
{ after(grammarAccess.getSIGNEDAccess().getHyphenMinusKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SIGNED__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SIGNED__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SIGNED__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSIGNEDAccess().getINTTerminalRuleCall_1()); }
	RULE_INT
{ after(grammarAccess.getSIGNEDAccess().getINTTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__InvariantConstraintCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvariantConstraintCS__Group__0__Impl
	rule__InvariantConstraintCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getIsCallableAssignment_0()); }
(rule__InvariantConstraintCS__IsCallableAssignment_0)?
{ after(grammarAccess.getInvariantConstraintCSAccess().getIsCallableAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvariantConstraintCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvariantConstraintCS__Group__1__Impl
	rule__InvariantConstraintCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getStereotypeAssignment_1()); }
(rule__InvariantConstraintCS__StereotypeAssignment_1)
{ after(grammarAccess.getInvariantConstraintCSAccess().getStereotypeAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvariantConstraintCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvariantConstraintCS__Group__2__Impl
	rule__InvariantConstraintCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getGroup_2()); }
(rule__InvariantConstraintCS__Group_2__0)?
{ after(grammarAccess.getInvariantConstraintCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvariantConstraintCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvariantConstraintCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getAlternatives_3()); }
(rule__InvariantConstraintCS__Alternatives_3)
{ after(grammarAccess.getInvariantConstraintCSAccess().getAlternatives_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__InvariantConstraintCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvariantConstraintCS__Group_2__0__Impl
	rule__InvariantConstraintCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getNameAssignment_2_0()); }
(rule__InvariantConstraintCS__NameAssignment_2_0)
{ after(grammarAccess.getInvariantConstraintCSAccess().getNameAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvariantConstraintCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvariantConstraintCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getGroup_2_1()); }
(rule__InvariantConstraintCS__Group_2_1__0)?
{ after(grammarAccess.getInvariantConstraintCSAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__InvariantConstraintCS__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvariantConstraintCS__Group_2_1__0__Impl
	rule__InvariantConstraintCS__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getLeftParenthesisKeyword_2_1_0()); }

	'('

{ after(grammarAccess.getInvariantConstraintCSAccess().getLeftParenthesisKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvariantConstraintCS__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvariantConstraintCS__Group_2_1__1__Impl
	rule__InvariantConstraintCS__Group_2_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getOwnedMessageSpecificationAssignment_2_1_1()); }
(rule__InvariantConstraintCS__OwnedMessageSpecificationAssignment_2_1_1)
{ after(grammarAccess.getInvariantConstraintCSAccess().getOwnedMessageSpecificationAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvariantConstraintCS__Group_2_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvariantConstraintCS__Group_2_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__Group_2_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getRightParenthesisKeyword_2_1_2()); }

	')'

{ after(grammarAccess.getInvariantConstraintCSAccess().getRightParenthesisKeyword_2_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__InvariantConstraintCS__Group_3_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvariantConstraintCS__Group_3_0__0__Impl
	rule__InvariantConstraintCS__Group_3_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__Group_3_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getColonKeyword_3_0_0()); }

	':'

{ after(grammarAccess.getInvariantConstraintCSAccess().getColonKeyword_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvariantConstraintCS__Group_3_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvariantConstraintCS__Group_3_0__1__Impl
	rule__InvariantConstraintCS__Group_3_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__Group_3_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getOwnedSpecificationAssignment_3_0_1()); }
(rule__InvariantConstraintCS__OwnedSpecificationAssignment_3_0_1)?
{ after(grammarAccess.getInvariantConstraintCSAccess().getOwnedSpecificationAssignment_3_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvariantConstraintCS__Group_3_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvariantConstraintCS__Group_3_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__Group_3_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getSemicolonKeyword_3_0_2()); }

	';'

{ after(grammarAccess.getInvariantConstraintCSAccess().getSemicolonKeyword_3_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PostconditionConstraintCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostconditionConstraintCS__Group__0__Impl
	rule__PostconditionConstraintCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PostconditionConstraintCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getStereotypeAssignment_0()); }
(rule__PostconditionConstraintCS__StereotypeAssignment_0)
{ after(grammarAccess.getPostconditionConstraintCSAccess().getStereotypeAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PostconditionConstraintCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostconditionConstraintCS__Group__1__Impl
	rule__PostconditionConstraintCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PostconditionConstraintCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getGroup_1()); }
(rule__PostconditionConstraintCS__Group_1__0)?
{ after(grammarAccess.getPostconditionConstraintCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PostconditionConstraintCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostconditionConstraintCS__Group__2__Impl
	rule__PostconditionConstraintCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PostconditionConstraintCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getColonKeyword_2()); }

	':'

{ after(grammarAccess.getPostconditionConstraintCSAccess().getColonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PostconditionConstraintCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostconditionConstraintCS__Group__3__Impl
	rule__PostconditionConstraintCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__PostconditionConstraintCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getOwnedSpecificationAssignment_3()); }
(rule__PostconditionConstraintCS__OwnedSpecificationAssignment_3)?
{ after(grammarAccess.getPostconditionConstraintCSAccess().getOwnedSpecificationAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PostconditionConstraintCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostconditionConstraintCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PostconditionConstraintCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getSemicolonKeyword_4()); }

	';'

{ after(grammarAccess.getPostconditionConstraintCSAccess().getSemicolonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__PostconditionConstraintCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostconditionConstraintCS__Group_1__0__Impl
	rule__PostconditionConstraintCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PostconditionConstraintCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getNameAssignment_1_0()); }
(rule__PostconditionConstraintCS__NameAssignment_1_0)
{ after(grammarAccess.getPostconditionConstraintCSAccess().getNameAssignment_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PostconditionConstraintCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostconditionConstraintCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PostconditionConstraintCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getGroup_1_1()); }
(rule__PostconditionConstraintCS__Group_1_1__0)?
{ after(grammarAccess.getPostconditionConstraintCSAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PostconditionConstraintCS__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostconditionConstraintCS__Group_1_1__0__Impl
	rule__PostconditionConstraintCS__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PostconditionConstraintCS__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getLeftParenthesisKeyword_1_1_0()); }

	'('

{ after(grammarAccess.getPostconditionConstraintCSAccess().getLeftParenthesisKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PostconditionConstraintCS__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostconditionConstraintCS__Group_1_1__1__Impl
	rule__PostconditionConstraintCS__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PostconditionConstraintCS__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getOwnedMessageSpecificationAssignment_1_1_1()); }
(rule__PostconditionConstraintCS__OwnedMessageSpecificationAssignment_1_1_1)
{ after(grammarAccess.getPostconditionConstraintCSAccess().getOwnedMessageSpecificationAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PostconditionConstraintCS__Group_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PostconditionConstraintCS__Group_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PostconditionConstraintCS__Group_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getRightParenthesisKeyword_1_1_2()); }

	')'

{ after(grammarAccess.getPostconditionConstraintCSAccess().getRightParenthesisKeyword_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PreconditionConstraintCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreconditionConstraintCS__Group__0__Impl
	rule__PreconditionConstraintCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PreconditionConstraintCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getStereotypeAssignment_0()); }
(rule__PreconditionConstraintCS__StereotypeAssignment_0)
{ after(grammarAccess.getPreconditionConstraintCSAccess().getStereotypeAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PreconditionConstraintCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreconditionConstraintCS__Group__1__Impl
	rule__PreconditionConstraintCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PreconditionConstraintCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getGroup_1()); }
(rule__PreconditionConstraintCS__Group_1__0)?
{ after(grammarAccess.getPreconditionConstraintCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PreconditionConstraintCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreconditionConstraintCS__Group__2__Impl
	rule__PreconditionConstraintCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PreconditionConstraintCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getColonKeyword_2()); }

	':'

{ after(grammarAccess.getPreconditionConstraintCSAccess().getColonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PreconditionConstraintCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreconditionConstraintCS__Group__3__Impl
	rule__PreconditionConstraintCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__PreconditionConstraintCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getOwnedSpecificationAssignment_3()); }
(rule__PreconditionConstraintCS__OwnedSpecificationAssignment_3)?
{ after(grammarAccess.getPreconditionConstraintCSAccess().getOwnedSpecificationAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PreconditionConstraintCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreconditionConstraintCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PreconditionConstraintCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getSemicolonKeyword_4()); }

	';'

{ after(grammarAccess.getPreconditionConstraintCSAccess().getSemicolonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__PreconditionConstraintCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreconditionConstraintCS__Group_1__0__Impl
	rule__PreconditionConstraintCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PreconditionConstraintCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getNameAssignment_1_0()); }
(rule__PreconditionConstraintCS__NameAssignment_1_0)
{ after(grammarAccess.getPreconditionConstraintCSAccess().getNameAssignment_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PreconditionConstraintCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreconditionConstraintCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PreconditionConstraintCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getGroup_1_1()); }
(rule__PreconditionConstraintCS__Group_1_1__0)?
{ after(grammarAccess.getPreconditionConstraintCSAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PreconditionConstraintCS__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreconditionConstraintCS__Group_1_1__0__Impl
	rule__PreconditionConstraintCS__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PreconditionConstraintCS__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getLeftParenthesisKeyword_1_1_0()); }

	'('

{ after(grammarAccess.getPreconditionConstraintCSAccess().getLeftParenthesisKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PreconditionConstraintCS__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreconditionConstraintCS__Group_1_1__1__Impl
	rule__PreconditionConstraintCS__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PreconditionConstraintCS__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getOwnedMessageSpecificationAssignment_1_1_1()); }
(rule__PreconditionConstraintCS__OwnedMessageSpecificationAssignment_1_1_1)
{ after(grammarAccess.getPreconditionConstraintCSAccess().getOwnedMessageSpecificationAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PreconditionConstraintCS__Group_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PreconditionConstraintCS__Group_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PreconditionConstraintCS__Group_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getRightParenthesisKeyword_1_1_2()); }

	')'

{ after(grammarAccess.getPreconditionConstraintCSAccess().getRightParenthesisKeyword_1_1_2()); }
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
{ before(grammarAccess.getAnnotationCSAccess().getAnnotationCSAction_0()); }
(

)
{ after(grammarAccess.getAnnotationCSAccess().getAnnotationCSAction_0()); }
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
{ before(grammarAccess.getAnnotationCSAccess().getAnnotationKeyword_1()); }

	'annotation'

{ after(grammarAccess.getAnnotationCSAccess().getAnnotationKeyword_1()); }
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
{ before(grammarAccess.getAnnotationCSAccess().getNameAssignment_2()); }
(rule__AnnotationCS__NameAssignment_2)?
{ after(grammarAccess.getAnnotationCSAccess().getNameAssignment_2()); }
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
	rule__AnnotationCS__Group__4
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
{ before(grammarAccess.getAnnotationCSAccess().getGroup_3()); }
(rule__AnnotationCS__Group_3__0)?
{ after(grammarAccess.getAnnotationCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getAlternatives_4()); }
(rule__AnnotationCS__Alternatives_4)
{ after(grammarAccess.getAnnotationCSAccess().getAlternatives_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__AnnotationCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_3__0__Impl
	rule__AnnotationCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getLeftParenthesisKeyword_3_0()); }

	'('

{ after(grammarAccess.getAnnotationCSAccess().getLeftParenthesisKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_3__1__Impl
	rule__AnnotationCS__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedDetailsAssignment_3_1()); }
(rule__AnnotationCS__OwnedDetailsAssignment_3_1)
{ after(grammarAccess.getAnnotationCSAccess().getOwnedDetailsAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_3__2__Impl
	rule__AnnotationCS__Group_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getGroup_3_2()); }
(rule__AnnotationCS__Group_3_2__0)*
{ after(grammarAccess.getAnnotationCSAccess().getGroup_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group_3__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_3__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_3__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getRightParenthesisKeyword_3_3()); }

	')'

{ after(grammarAccess.getAnnotationCSAccess().getRightParenthesisKeyword_3_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__AnnotationCS__Group_3_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_3_2__0__Impl
	rule__AnnotationCS__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_3_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getCommaKeyword_3_2_0()); }

	','

{ after(grammarAccess.getAnnotationCSAccess().getCommaKeyword_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group_3_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_3_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedDetailsAssignment_3_2_1()); }
(rule__AnnotationCS__OwnedDetailsAssignment_3_2_1)
{ after(grammarAccess.getAnnotationCSAccess().getOwnedDetailsAssignment_3_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AnnotationCS__Group_4_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_4_0__0__Impl
	rule__AnnotationCS__Group_4_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_4_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getLeftCurlyBracketKeyword_4_0_0()); }

	'{'

{ after(grammarAccess.getAnnotationCSAccess().getLeftCurlyBracketKeyword_4_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group_4_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_4_0__1__Impl
	rule__AnnotationCS__Group_4_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_4_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getAnnotationCSAccess().getAlternatives_4_0_1()); }
(rule__AnnotationCS__Alternatives_4_0_1)
{ after(grammarAccess.getAnnotationCSAccess().getAlternatives_4_0_1()); }
)
(
{ before(grammarAccess.getAnnotationCSAccess().getAlternatives_4_0_1()); }
(rule__AnnotationCS__Alternatives_4_0_1)*
{ after(grammarAccess.getAnnotationCSAccess().getAlternatives_4_0_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationCS__Group_4_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AnnotationCS__Group_4_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__Group_4_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getRightCurlyBracketKeyword_4_0_2()); }

	'}'

{ after(grammarAccess.getAnnotationCSAccess().getRightCurlyBracketKeyword_4_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AttributeCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group__0__Impl
	rule__AttributeCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getAlternatives_0()); }
(rule__AttributeCS__Alternatives_0)?
{ after(grammarAccess.getAttributeCSAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group__1__Impl
	rule__AttributeCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getAttributeKeyword_1()); }

	'attribute'

{ after(grammarAccess.getAttributeCSAccess().getAttributeKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group__2__Impl
	rule__AttributeCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getNameAssignment_2()); }
(rule__AttributeCS__NameAssignment_2)
{ after(grammarAccess.getAttributeCSAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group__3__Impl
	rule__AttributeCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_3()); }
(rule__AttributeCS__Group_3__0)?
{ after(grammarAccess.getAttributeCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group__4__Impl
	rule__AttributeCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_4()); }
(rule__AttributeCS__Group_4__0)?
{ after(grammarAccess.getAttributeCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group__5__Impl
	rule__AttributeCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_5()); }
(rule__AttributeCS__Group_5__0)?
{ after(grammarAccess.getAttributeCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getAlternatives_6()); }
(rule__AttributeCS__Alternatives_6)
{ after(grammarAccess.getAttributeCSAccess().getAlternatives_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__AttributeCS__Group_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_0_0__0__Impl
	rule__AttributeCS__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_0_0()); }
(rule__AttributeCS__QualifiersAssignment_0_0_0)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_0_1()); }
(rule__AttributeCS__QualifiersAssignment_0_0_1)?
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AttributeCS__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_0_1__0__Impl
	rule__AttributeCS__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_1_0()); }
(rule__AttributeCS__QualifiersAssignment_0_1_0)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_1_1()); }
(rule__AttributeCS__QualifiersAssignment_0_1_1)?
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AttributeCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_3__0__Impl
	rule__AttributeCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getColonKeyword_3_0()); }

	':'

{ after(grammarAccess.getAttributeCSAccess().getColonKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getOwnedTypeAssignment_3_1()); }
(rule__AttributeCS__OwnedTypeAssignment_3_1)
{ after(grammarAccess.getAttributeCSAccess().getOwnedTypeAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AttributeCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_4__0__Impl
	rule__AttributeCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getEqualsSignKeyword_4_0()); }

	'='

{ after(grammarAccess.getAttributeCSAccess().getEqualsSignKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getDefaultAssignment_4_1()); }
(rule__AttributeCS__DefaultAssignment_4_1)
{ after(grammarAccess.getAttributeCSAccess().getDefaultAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AttributeCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_5__0__Impl
	rule__AttributeCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getLeftCurlyBracketKeyword_5_0()); }

	'{'

{ after(grammarAccess.getAttributeCSAccess().getLeftCurlyBracketKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_5__1__Impl
	rule__AttributeCS__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_5_1()); }
(rule__AttributeCS__Group_5_1__0)
{ after(grammarAccess.getAttributeCSAccess().getGroup_5_1()); }
)
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_5_1()); }
(rule__AttributeCS__Group_5_1__0)*
{ after(grammarAccess.getAttributeCSAccess().getGroup_5_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getRightCurlyBracketKeyword_5_2()); }

	'}'

{ after(grammarAccess.getAttributeCSAccess().getRightCurlyBracketKeyword_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AttributeCS__Group_5_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_5_1__0__Impl
	rule__AttributeCS__Group_5_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_5_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getAlternatives_5_1_0()); }
(rule__AttributeCS__Alternatives_5_1_0)
{ after(grammarAccess.getAttributeCSAccess().getAlternatives_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_5_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_5_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_5_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getCommaKeyword_5_1_1()); }
(
	','
)?
{ after(grammarAccess.getAttributeCSAccess().getCommaKeyword_5_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AttributeCS__Group_6_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0__0__Impl
	rule__AttributeCS__Group_6_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getLeftCurlyBracketKeyword_6_0_0()); }

	'{'

{ after(grammarAccess.getAttributeCSAccess().getLeftCurlyBracketKeyword_6_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0__1__Impl
	rule__AttributeCS__Group_6_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getAlternatives_6_0_1()); }
(rule__AttributeCS__Alternatives_6_0_1)*
{ after(grammarAccess.getAttributeCSAccess().getAlternatives_6_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getRightCurlyBracketKeyword_6_0_2()); }

	'}'

{ after(grammarAccess.getAttributeCSAccess().getRightCurlyBracketKeyword_6_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AttributeCS__Group_6_0_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_1__0__Impl
	rule__AttributeCS__Group_6_0_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getInitialKeyword_6_0_1_1_0()); }

	'initial'

{ after(grammarAccess.getAttributeCSAccess().getInitialKeyword_6_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_1__1__Impl
	rule__AttributeCS__Group_6_0_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getUnrestrictedNameParserRuleCall_6_0_1_1_1()); }
(	ruleUnrestrictedName)?
{ after(grammarAccess.getAttributeCSAccess().getUnrestrictedNameParserRuleCall_6_0_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_1__2__Impl
	rule__AttributeCS__Group_6_0_1_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getColonKeyword_6_0_1_1_2()); }

	':'

{ after(grammarAccess.getAttributeCSAccess().getColonKeyword_6_0_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_1__3__Impl
	rule__AttributeCS__Group_6_0_1_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsAssignment_6_0_1_1_3()); }
(rule__AttributeCS__OwnedDefaultExpressionsAssignment_6_0_1_1_3)?
{ after(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsAssignment_6_0_1_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_1__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_1__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_0_1_1_4()); }

	';'

{ after(grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_0_1_1_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__AttributeCS__Group_6_0_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_2__0__Impl
	rule__AttributeCS__Group_6_0_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getDerivationKeyword_6_0_1_2_0()); }

	'derivation'

{ after(grammarAccess.getAttributeCSAccess().getDerivationKeyword_6_0_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_2__1__Impl
	rule__AttributeCS__Group_6_0_1_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getUnrestrictedNameParserRuleCall_6_0_1_2_1()); }
(	ruleUnrestrictedName)?
{ after(grammarAccess.getAttributeCSAccess().getUnrestrictedNameParserRuleCall_6_0_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_2__2__Impl
	rule__AttributeCS__Group_6_0_1_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getColonKeyword_6_0_1_2_2()); }

	':'

{ after(grammarAccess.getAttributeCSAccess().getColonKeyword_6_0_1_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_2__3__Impl
	rule__AttributeCS__Group_6_0_1_2__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsAssignment_6_0_1_2_3()); }
(rule__AttributeCS__OwnedDefaultExpressionsAssignment_6_0_1_2_3)?
{ after(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsAssignment_6_0_1_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_2__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_2__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_2__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_0_1_2_4()); }

	';'

{ after(grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_0_1_2_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__DataTypeCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group__0__Impl
	rule__DataTypeCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getIsPrimitiveAssignment_0()); }
(rule__DataTypeCS__IsPrimitiveAssignment_0)?
{ after(grammarAccess.getDataTypeCSAccess().getIsPrimitiveAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group__1__Impl
	rule__DataTypeCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getDatatypeKeyword_1()); }

	'datatype'

{ after(grammarAccess.getDataTypeCSAccess().getDatatypeKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group__2__Impl
	rule__DataTypeCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getNameAssignment_2()); }
(rule__DataTypeCS__NameAssignment_2)
{ after(grammarAccess.getDataTypeCSAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group__3__Impl
	rule__DataTypeCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getOwnedSignatureAssignment_3()); }
(rule__DataTypeCS__OwnedSignatureAssignment_3)?
{ after(grammarAccess.getDataTypeCSAccess().getOwnedSignatureAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group__4__Impl
	rule__DataTypeCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getGroup_4()); }
(rule__DataTypeCS__Group_4__0)?
{ after(grammarAccess.getDataTypeCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group__5__Impl
	rule__DataTypeCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getGroup_5()); }
(rule__DataTypeCS__Group_5__0)?
{ after(grammarAccess.getDataTypeCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getAlternatives_6()); }
(rule__DataTypeCS__Alternatives_6)
{ after(grammarAccess.getDataTypeCSAccess().getAlternatives_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__DataTypeCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_4__0__Impl
	rule__DataTypeCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getColonKeyword_4_0()); }

	':'

{ after(grammarAccess.getDataTypeCSAccess().getColonKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getInstanceClassNameAssignment_4_1()); }
(rule__DataTypeCS__InstanceClassNameAssignment_4_1)
{ after(grammarAccess.getDataTypeCSAccess().getInstanceClassNameAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DataTypeCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_5__0__Impl
	rule__DataTypeCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getLeftCurlyBracketKeyword_5_0()); }

	'{'

{ after(grammarAccess.getDataTypeCSAccess().getLeftCurlyBracketKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_5__1__Impl
	rule__DataTypeCS__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getAlternatives_5_1()); }
(rule__DataTypeCS__Alternatives_5_1)?
{ after(grammarAccess.getDataTypeCSAccess().getAlternatives_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getRightCurlyBracketKeyword_5_2()); }

	'}'

{ after(grammarAccess.getDataTypeCSAccess().getRightCurlyBracketKeyword_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__DataTypeCS__Group_6_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_6_0__0__Impl
	rule__DataTypeCS__Group_6_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_6_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getLeftCurlyBracketKeyword_6_0_0()); }

	'{'

{ after(grammarAccess.getDataTypeCSAccess().getLeftCurlyBracketKeyword_6_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group_6_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_6_0__1__Impl
	rule__DataTypeCS__Group_6_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_6_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getAlternatives_6_0_1()); }
(rule__DataTypeCS__Alternatives_6_0_1)*
{ after(grammarAccess.getDataTypeCSAccess().getAlternatives_6_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group_6_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_6_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_6_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getRightCurlyBracketKeyword_6_0_2()); }

	'}'

{ after(grammarAccess.getDataTypeCSAccess().getRightCurlyBracketKeyword_6_0_2()); }
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






rule__EnumerationCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group__0__Impl
	rule__EnumerationCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getEnumKeyword_0()); }

	'enum'

{ after(grammarAccess.getEnumerationCSAccess().getEnumKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group__1__Impl
	rule__EnumerationCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getNameAssignment_1()); }
(rule__EnumerationCS__NameAssignment_1)
{ after(grammarAccess.getEnumerationCSAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group__2__Impl
	rule__EnumerationCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getOwnedSignatureAssignment_2()); }
(rule__EnumerationCS__OwnedSignatureAssignment_2)?
{ after(grammarAccess.getEnumerationCSAccess().getOwnedSignatureAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group__3__Impl
	rule__EnumerationCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getGroup_3()); }
(rule__EnumerationCS__Group_3__0)?
{ after(grammarAccess.getEnumerationCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group__4__Impl
	rule__EnumerationCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getGroup_4()); }
(rule__EnumerationCS__Group_4__0)?
{ after(grammarAccess.getEnumerationCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getAlternatives_5()); }
(rule__EnumerationCS__Alternatives_5)
{ after(grammarAccess.getEnumerationCSAccess().getAlternatives_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__EnumerationCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_3__0__Impl
	rule__EnumerationCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getColonKeyword_3_0()); }

	':'

{ after(grammarAccess.getEnumerationCSAccess().getColonKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getInstanceClassNameAssignment_3_1()); }
(rule__EnumerationCS__InstanceClassNameAssignment_3_1)
{ after(grammarAccess.getEnumerationCSAccess().getInstanceClassNameAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EnumerationCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_4__0__Impl
	rule__EnumerationCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getLeftCurlyBracketKeyword_4_0()); }

	'{'

{ after(grammarAccess.getEnumerationCSAccess().getLeftCurlyBracketKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_4__1__Impl
	rule__EnumerationCS__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getAlternatives_4_1()); }
(rule__EnumerationCS__Alternatives_4_1)?
{ after(grammarAccess.getEnumerationCSAccess().getAlternatives_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getRightCurlyBracketKeyword_4_2()); }

	'}'

{ after(grammarAccess.getEnumerationCSAccess().getRightCurlyBracketKeyword_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__EnumerationCS__Group_5_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_5_0__0__Impl
	rule__EnumerationCS__Group_5_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_5_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getLeftCurlyBracketKeyword_5_0_0()); }

	'{'

{ after(grammarAccess.getEnumerationCSAccess().getLeftCurlyBracketKeyword_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group_5_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_5_0__1__Impl
	rule__EnumerationCS__Group_5_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_5_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getAlternatives_5_0_1()); }
(rule__EnumerationCS__Alternatives_5_0_1)*
{ after(grammarAccess.getEnumerationCSAccess().getAlternatives_5_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group_5_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_5_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_5_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getRightCurlyBracketKeyword_5_0_2()); }

	'}'

{ after(grammarAccess.getEnumerationCSAccess().getRightCurlyBracketKeyword_5_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__EnumerationLiteralCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group__0__Impl
	rule__EnumerationLiteralCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getAlternatives_0()); }
(rule__EnumerationLiteralCS__Alternatives_0)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationLiteralCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group__1__Impl
	rule__EnumerationLiteralCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getGroup_1()); }
(rule__EnumerationLiteralCS__Group_1__0)?
{ after(grammarAccess.getEnumerationLiteralCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationLiteralCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group__2__Impl
	rule__EnumerationLiteralCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getGroup_2()); }
(rule__EnumerationLiteralCS__Group_2__0)?
{ after(grammarAccess.getEnumerationLiteralCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationLiteralCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getAlternatives_3()); }
(rule__EnumerationLiteralCS__Alternatives_3)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getAlternatives_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__EnumerationLiteralCS__Group_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_0_0__0__Impl
	rule__EnumerationLiteralCS__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getLiteralKeyword_0_0_0()); }

	'literal'

{ after(grammarAccess.getEnumerationLiteralCSAccess().getLiteralKeyword_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationLiteralCS__Group_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getNameAssignment_0_0_1()); }
(rule__EnumerationLiteralCS__NameAssignment_0_0_1)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getNameAssignment_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EnumerationLiteralCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_1__0__Impl
	rule__EnumerationLiteralCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getColonKeyword_1_0()); }

	':'

{ after(grammarAccess.getEnumerationLiteralCSAccess().getColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationLiteralCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getLiteralAssignment_1_1()); }
(rule__EnumerationLiteralCS__LiteralAssignment_1_1)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getLiteralAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EnumerationLiteralCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_2__0__Impl
	rule__EnumerationLiteralCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getEqualsSignKeyword_2_0()); }

	'='

{ after(grammarAccess.getEnumerationLiteralCSAccess().getEqualsSignKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationLiteralCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getValueAssignment_2_1()); }
(rule__EnumerationLiteralCS__ValueAssignment_2_1)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getValueAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EnumerationLiteralCS__Group_3_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_3_0__0__Impl
	rule__EnumerationLiteralCS__Group_3_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_3_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getLeftCurlyBracketKeyword_3_0_0()); }

	'{'

{ after(grammarAccess.getEnumerationLiteralCSAccess().getLeftCurlyBracketKeyword_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationLiteralCS__Group_3_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_3_0__1__Impl
	rule__EnumerationLiteralCS__Group_3_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_3_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getOwnedAnnotationsAssignment_3_0_1()); }
(rule__EnumerationLiteralCS__OwnedAnnotationsAssignment_3_0_1)*
{ after(grammarAccess.getEnumerationLiteralCSAccess().getOwnedAnnotationsAssignment_3_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationLiteralCS__Group_3_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_3_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_3_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getRightCurlyBracketKeyword_3_0_2()); }

	'}'

{ after(grammarAccess.getEnumerationLiteralCSAccess().getRightCurlyBracketKeyword_3_0_2()); }
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
{ before(grammarAccess.getImportCSAccess().getAlternatives_0()); }
(rule__ImportCS__Alternatives_0)
{ after(grammarAccess.getImportCSAccess().getAlternatives_0()); }
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
	rule__ImportCS__Group__4
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


rule__ImportCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getSemicolonKeyword_4()); }

	';'

{ after(grammarAccess.getImportCSAccess().getSemicolonKeyword_4()); }
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






rule__ModelElementRefCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModelElementRefCS__Group__0__Impl
	rule__ModelElementRefCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ModelElementRefCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelElementRefCSAccess().getReferenceKeyword_0()); }

	'reference'

{ after(grammarAccess.getModelElementRefCSAccess().getReferenceKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModelElementRefCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModelElementRefCS__Group__1__Impl
	rule__ModelElementRefCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ModelElementRefCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelElementRefCSAccess().getOwnedPathNameAssignment_1()); }
(rule__ModelElementRefCS__OwnedPathNameAssignment_1)
{ after(grammarAccess.getModelElementRefCSAccess().getOwnedPathNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModelElementRefCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModelElementRefCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ModelElementRefCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelElementRefCSAccess().getSemicolonKeyword_2()); }

	';'

{ after(grammarAccess.getModelElementRefCSAccess().getSemicolonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__OperationCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__0__Impl
	rule__OperationCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getAlternatives_0()); }
(rule__OperationCS__Alternatives_0)?
{ after(grammarAccess.getOperationCSAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__1__Impl
	rule__OperationCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOperationKeyword_1()); }

	'operation'

{ after(grammarAccess.getOperationCSAccess().getOperationKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__2__Impl
	rule__OperationCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedSignatureAssignment_2()); }
(rule__OperationCS__OwnedSignatureAssignment_2)?
{ after(grammarAccess.getOperationCSAccess().getOwnedSignatureAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__3__Impl
	rule__OperationCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getNameAssignment_3()); }
(rule__OperationCS__NameAssignment_3)
{ after(grammarAccess.getOperationCSAccess().getNameAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__4__Impl
	rule__OperationCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getLeftParenthesisKeyword_4()); }

	'('

{ after(grammarAccess.getOperationCSAccess().getLeftParenthesisKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__5__Impl
	rule__OperationCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_5()); }
(rule__OperationCS__Group_5__0)?
{ after(grammarAccess.getOperationCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__6__Impl
	rule__OperationCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getRightParenthesisKeyword_6()); }

	')'

{ after(grammarAccess.getOperationCSAccess().getRightParenthesisKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__7__Impl
	rule__OperationCS__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_7()); }
(rule__OperationCS__Group_7__0)?
{ after(grammarAccess.getOperationCSAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__8__Impl
	rule__OperationCS__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_8()); }
(rule__OperationCS__Group_8__0)?
{ after(grammarAccess.getOperationCSAccess().getGroup_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__9__Impl
	rule__OperationCS__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_9()); }
(rule__OperationCS__Group_9__0)?
{ after(grammarAccess.getOperationCSAccess().getGroup_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__10__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getAlternatives_10()); }
(rule__OperationCS__Alternatives_10)
{ after(grammarAccess.getOperationCSAccess().getAlternatives_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}
























rule__OperationCS__Group_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_0_0__0__Impl
	rule__OperationCS__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_0_0()); }
(rule__OperationCS__QualifiersAssignment_0_0_0)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_0_1()); }
(rule__OperationCS__QualifiersAssignment_0_0_1)?
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_0_1__0__Impl
	rule__OperationCS__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_1_0()); }
(rule__OperationCS__QualifiersAssignment_0_1_0)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_1_1()); }
(rule__OperationCS__QualifiersAssignment_0_1_1)?
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_5__0__Impl
	rule__OperationCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedParametersAssignment_5_0()); }
(rule__OperationCS__OwnedParametersAssignment_5_0)
{ after(grammarAccess.getOperationCSAccess().getOwnedParametersAssignment_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_5_1()); }
(rule__OperationCS__Group_5_1__0)*
{ after(grammarAccess.getOperationCSAccess().getGroup_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group_5_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_5_1__0__Impl
	rule__OperationCS__Group_5_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_5_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getCommaKeyword_5_1_0()); }

	','

{ after(grammarAccess.getOperationCSAccess().getCommaKeyword_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_5_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_5_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_5_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedParametersAssignment_5_1_1()); }
(rule__OperationCS__OwnedParametersAssignment_5_1_1)
{ after(grammarAccess.getOperationCSAccess().getOwnedParametersAssignment_5_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_7__0__Impl
	rule__OperationCS__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getColonKeyword_7_0()); }

	':'

{ after(grammarAccess.getOperationCSAccess().getColonKeyword_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_7__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedTypeAssignment_7_1()); }
(rule__OperationCS__OwnedTypeAssignment_7_1)
{ after(grammarAccess.getOperationCSAccess().getOwnedTypeAssignment_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_8__0__Impl
	rule__OperationCS__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getThrowsKeyword_8_0()); }

	'throws'

{ after(grammarAccess.getOperationCSAccess().getThrowsKeyword_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_8__1__Impl
	rule__OperationCS__Group_8__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedExceptionsAssignment_8_1()); }
(rule__OperationCS__OwnedExceptionsAssignment_8_1)
{ after(grammarAccess.getOperationCSAccess().getOwnedExceptionsAssignment_8_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_8__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_8__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_8__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_8_2()); }
(rule__OperationCS__Group_8_2__0)*
{ after(grammarAccess.getOperationCSAccess().getGroup_8_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__OperationCS__Group_8_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_8_2__0__Impl
	rule__OperationCS__Group_8_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_8_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getCommaKeyword_8_2_0()); }

	','

{ after(grammarAccess.getOperationCSAccess().getCommaKeyword_8_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_8_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_8_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_8_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedExceptionsAssignment_8_2_1()); }
(rule__OperationCS__OwnedExceptionsAssignment_8_2_1)
{ after(grammarAccess.getOperationCSAccess().getOwnedExceptionsAssignment_8_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group_9__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_9__0__Impl
	rule__OperationCS__Group_9__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_9__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getLeftCurlyBracketKeyword_9_0()); }

	'{'

{ after(grammarAccess.getOperationCSAccess().getLeftCurlyBracketKeyword_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_9__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_9__1__Impl
	rule__OperationCS__Group_9__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_9__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getOperationCSAccess().getGroup_9_1()); }
(rule__OperationCS__Group_9_1__0)
{ after(grammarAccess.getOperationCSAccess().getGroup_9_1()); }
)
(
{ before(grammarAccess.getOperationCSAccess().getGroup_9_1()); }
(rule__OperationCS__Group_9_1__0)*
{ after(grammarAccess.getOperationCSAccess().getGroup_9_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_9__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_9__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_9__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getRightCurlyBracketKeyword_9_2()); }

	'}'

{ after(grammarAccess.getOperationCSAccess().getRightCurlyBracketKeyword_9_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__OperationCS__Group_9_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_9_1__0__Impl
	rule__OperationCS__Group_9_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_9_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getAlternatives_9_1_0()); }
(rule__OperationCS__Alternatives_9_1_0)
{ after(grammarAccess.getOperationCSAccess().getAlternatives_9_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_9_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_9_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_9_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getCommaKeyword_9_1_1()); }
(
	','
)?
{ after(grammarAccess.getOperationCSAccess().getCommaKeyword_9_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group_10_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0__0__Impl
	rule__OperationCS__Group_10_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getLeftCurlyBracketKeyword_10_0_0()); }

	'{'

{ after(grammarAccess.getOperationCSAccess().getLeftCurlyBracketKeyword_10_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_10_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0__1__Impl
	rule__OperationCS__Group_10_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getAlternatives_10_0_1()); }
(rule__OperationCS__Alternatives_10_0_1)*
{ after(grammarAccess.getOperationCSAccess().getAlternatives_10_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_10_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getRightCurlyBracketKeyword_10_0_2()); }

	'}'

{ after(grammarAccess.getOperationCSAccess().getRightCurlyBracketKeyword_10_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__OperationCS__Group_10_0_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0_1_2__0__Impl
	rule__OperationCS__Group_10_0_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getBodyKeyword_10_0_1_2_0()); }

	'body'

{ after(grammarAccess.getOperationCSAccess().getBodyKeyword_10_0_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_10_0_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0_1_2__1__Impl
	rule__OperationCS__Group_10_0_1_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getUnrestrictedNameParserRuleCall_10_0_1_2_1()); }
(	ruleUnrestrictedName)?
{ after(grammarAccess.getOperationCSAccess().getUnrestrictedNameParserRuleCall_10_0_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_10_0_1_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0_1_2__2__Impl
	rule__OperationCS__Group_10_0_1_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0_1_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getColonKeyword_10_0_1_2_2()); }

	':'

{ after(grammarAccess.getOperationCSAccess().getColonKeyword_10_0_1_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_10_0_1_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0_1_2__3__Impl
	rule__OperationCS__Group_10_0_1_2__4
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0_1_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedBodyExpressionsAssignment_10_0_1_2_3()); }
(rule__OperationCS__OwnedBodyExpressionsAssignment_10_0_1_2_3)?
{ after(grammarAccess.getOperationCSAccess().getOwnedBodyExpressionsAssignment_10_0_1_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_10_0_1_2__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0_1_2__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0_1_2__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getSemicolonKeyword_10_0_1_2_4()); }

	';'

{ after(grammarAccess.getOperationCSAccess().getSemicolonKeyword_10_0_1_2_4()); }
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
{ before(grammarAccess.getPackageCSAccess().getGroup_3()); }
(rule__PackageCS__Group_3__0)?
{ after(grammarAccess.getPackageCSAccess().getGroup_3()); }
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
(rule__PackageCS__Alternatives_4)
{ after(grammarAccess.getPackageCSAccess().getAlternatives_4()); }
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






rule__PackageCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group_3__0__Impl
	rule__PackageCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getEqualsSignKeyword_3_0()); }

	'='

{ after(grammarAccess.getPackageCSAccess().getEqualsSignKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PackageCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getNsURIAssignment_3_1()); }
(rule__PackageCS__NsURIAssignment_3_1)
{ after(grammarAccess.getPackageCSAccess().getNsURIAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PackageCS__Group_4_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group_4_0__0__Impl
	rule__PackageCS__Group_4_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group_4_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getLeftCurlyBracketKeyword_4_0_0()); }

	'{'

{ after(grammarAccess.getPackageCSAccess().getLeftCurlyBracketKeyword_4_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PackageCS__Group_4_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group_4_0__1__Impl
	rule__PackageCS__Group_4_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group_4_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getAlternatives_4_0_1()); }
(rule__PackageCS__Alternatives_4_0_1)*
{ after(grammarAccess.getPackageCSAccess().getAlternatives_4_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PackageCS__Group_4_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PackageCS__Group_4_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__Group_4_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getRightCurlyBracketKeyword_4_0_2()); }

	'}'

{ after(grammarAccess.getPackageCSAccess().getRightCurlyBracketKeyword_4_0_2()); }
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
{ before(grammarAccess.getParameterCSAccess().getGroup_1()); }
(rule__ParameterCS__Group_1__0)?
{ after(grammarAccess.getParameterCSAccess().getGroup_1()); }
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
	rule__ParameterCS__Group__3
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
{ before(grammarAccess.getParameterCSAccess().getGroup_2()); }
(rule__ParameterCS__Group_2__0)?
{ after(grammarAccess.getParameterCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getGroup_3()); }
(rule__ParameterCS__Group_3__0)?
{ after(grammarAccess.getParameterCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ParameterCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_1__0__Impl
	rule__ParameterCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getColonKeyword_1_0()); }

	':'

{ after(grammarAccess.getParameterCSAccess().getColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getOwnedTypeAssignment_1_1()); }
(rule__ParameterCS__OwnedTypeAssignment_1_1)
{ after(grammarAccess.getParameterCSAccess().getOwnedTypeAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ParameterCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_2__0__Impl
	rule__ParameterCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getLeftCurlyBracketKeyword_2_0()); }

	'{'

{ after(grammarAccess.getParameterCSAccess().getLeftCurlyBracketKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_2__1__Impl
	rule__ParameterCS__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getParameterCSAccess().getGroup_2_1()); }
(rule__ParameterCS__Group_2_1__0)
{ after(grammarAccess.getParameterCSAccess().getGroup_2_1()); }
)
(
{ before(grammarAccess.getParameterCSAccess().getGroup_2_1()); }
(rule__ParameterCS__Group_2_1__0)*
{ after(grammarAccess.getParameterCSAccess().getGroup_2_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getRightCurlyBracketKeyword_2_2()); }

	'}'

{ after(grammarAccess.getParameterCSAccess().getRightCurlyBracketKeyword_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ParameterCS__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_2_1__0__Impl
	rule__ParameterCS__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getAlternatives_2_1_0()); }
(rule__ParameterCS__Alternatives_2_1_0)
{ after(grammarAccess.getParameterCSAccess().getAlternatives_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getCommaKeyword_2_1_1()); }
(
	','
)?
{ after(grammarAccess.getParameterCSAccess().getCommaKeyword_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ParameterCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_3__0__Impl
	rule__ParameterCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getLeftCurlyBracketKeyword_3_0()); }

	'{'

{ after(grammarAccess.getParameterCSAccess().getLeftCurlyBracketKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_3__1__Impl
	rule__ParameterCS__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getOwnedAnnotationsAssignment_3_1()); }
(rule__ParameterCS__OwnedAnnotationsAssignment_3_1)*
{ after(grammarAccess.getParameterCSAccess().getOwnedAnnotationsAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getRightCurlyBracketKeyword_3_2()); }

	'}'

{ after(grammarAccess.getParameterCSAccess().getRightCurlyBracketKeyword_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ImplicitOppositeCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplicitOppositeCS__Group__0__Impl
	rule__ImplicitOppositeCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getOppositeKeyword_0()); }

	'opposite'

{ after(grammarAccess.getImplicitOppositeCSAccess().getOppositeKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImplicitOppositeCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplicitOppositeCS__Group__1__Impl
	rule__ImplicitOppositeCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getNameAssignment_1()); }
(rule__ImplicitOppositeCS__NameAssignment_1)
{ after(grammarAccess.getImplicitOppositeCSAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImplicitOppositeCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplicitOppositeCS__Group__2__Impl
	rule__ImplicitOppositeCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getColonKeyword_2()); }

	':'

{ after(grammarAccess.getImplicitOppositeCSAccess().getColonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImplicitOppositeCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplicitOppositeCS__Group__3__Impl
	rule__ImplicitOppositeCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getOwnedTypeAssignment_3()); }
(rule__ImplicitOppositeCS__OwnedTypeAssignment_3)
{ after(grammarAccess.getImplicitOppositeCSAccess().getOwnedTypeAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImplicitOppositeCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplicitOppositeCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getGroup_4()); }
(rule__ImplicitOppositeCS__Group_4__0)?
{ after(grammarAccess.getImplicitOppositeCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__ImplicitOppositeCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplicitOppositeCS__Group_4__0__Impl
	rule__ImplicitOppositeCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getLeftCurlyBracketKeyword_4_0()); }

	'{'

{ after(grammarAccess.getImplicitOppositeCSAccess().getLeftCurlyBracketKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImplicitOppositeCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplicitOppositeCS__Group_4__1__Impl
	rule__ImplicitOppositeCS__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getGroup_4_1()); }
(rule__ImplicitOppositeCS__Group_4_1__0)
{ after(grammarAccess.getImplicitOppositeCSAccess().getGroup_4_1()); }
)
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getGroup_4_1()); }
(rule__ImplicitOppositeCS__Group_4_1__0)*
{ after(grammarAccess.getImplicitOppositeCSAccess().getGroup_4_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImplicitOppositeCS__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplicitOppositeCS__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getRightCurlyBracketKeyword_4_2()); }

	'}'

{ after(grammarAccess.getImplicitOppositeCSAccess().getRightCurlyBracketKeyword_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ImplicitOppositeCS__Group_4_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplicitOppositeCS__Group_4_1__0__Impl
	rule__ImplicitOppositeCS__Group_4_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__Group_4_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getAlternatives_4_1_0()); }
(rule__ImplicitOppositeCS__Alternatives_4_1_0)
{ after(grammarAccess.getImplicitOppositeCSAccess().getAlternatives_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImplicitOppositeCS__Group_4_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplicitOppositeCS__Group_4_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__Group_4_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getCommaKeyword_4_1_1()); }
(
	','
)?
{ after(grammarAccess.getImplicitOppositeCSAccess().getCommaKeyword_4_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__0__Impl
	rule__ReferenceCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getAlternatives_0()); }
(rule__ReferenceCS__Alternatives_0)?
{ after(grammarAccess.getReferenceCSAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__1__Impl
	rule__ReferenceCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getPropertyKeyword_1()); }

	'property'

{ after(grammarAccess.getReferenceCSAccess().getPropertyKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__2__Impl
	rule__ReferenceCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getNameAssignment_2()); }
(rule__ReferenceCS__NameAssignment_2)
{ after(grammarAccess.getReferenceCSAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__3__Impl
	rule__ReferenceCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_3()); }
(rule__ReferenceCS__Group_3__0)?
{ after(grammarAccess.getReferenceCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__4__Impl
	rule__ReferenceCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_4()); }
(rule__ReferenceCS__Group_4__0)?
{ after(grammarAccess.getReferenceCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__5__Impl
	rule__ReferenceCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_5()); }
(rule__ReferenceCS__Group_5__0)?
{ after(grammarAccess.getReferenceCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__6__Impl
	rule__ReferenceCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_6()); }
(rule__ReferenceCS__Group_6__0)?
{ after(grammarAccess.getReferenceCSAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getAlternatives_7()); }
(rule__ReferenceCS__Alternatives_7)
{ after(grammarAccess.getReferenceCSAccess().getAlternatives_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__ReferenceCS__Group_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_0_0__0__Impl
	rule__ReferenceCS__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_0_0()); }
(rule__ReferenceCS__QualifiersAssignment_0_0_0)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_0_1()); }
(rule__ReferenceCS__QualifiersAssignment_0_0_1)?
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_0_1__0__Impl
	rule__ReferenceCS__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_1_0()); }
(rule__ReferenceCS__QualifiersAssignment_0_1_0)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_1_1()); }
(rule__ReferenceCS__QualifiersAssignment_0_1_1)?
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_3__0__Impl
	rule__ReferenceCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getNumberSignKeyword_3_0()); }

	'#'

{ after(grammarAccess.getReferenceCSAccess().getNumberSignKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getReferredOppositeAssignment_3_1()); }
(rule__ReferenceCS__ReferredOppositeAssignment_3_1)
{ after(grammarAccess.getReferenceCSAccess().getReferredOppositeAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_4__0__Impl
	rule__ReferenceCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getColonKeyword_4_0()); }

	':'

{ after(grammarAccess.getReferenceCSAccess().getColonKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedTypeAssignment_4_1()); }
(rule__ReferenceCS__OwnedTypeAssignment_4_1)
{ after(grammarAccess.getReferenceCSAccess().getOwnedTypeAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_5__0__Impl
	rule__ReferenceCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getEqualsSignKeyword_5_0()); }

	'='

{ after(grammarAccess.getReferenceCSAccess().getEqualsSignKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getDefaultAssignment_5_1()); }
(rule__ReferenceCS__DefaultAssignment_5_1)
{ after(grammarAccess.getReferenceCSAccess().getDefaultAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_6__0__Impl
	rule__ReferenceCS__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getLeftCurlyBracketKeyword_6_0()); }

	'{'

{ after(grammarAccess.getReferenceCSAccess().getLeftCurlyBracketKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_6__1__Impl
	rule__ReferenceCS__Group_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_6_1()); }
(rule__ReferenceCS__Group_6_1__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup_6_1()); }
)
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_6_1()); }
(rule__ReferenceCS__Group_6_1__0)*
{ after(grammarAccess.getReferenceCSAccess().getGroup_6_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_6__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_6__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getRightCurlyBracketKeyword_6_2()); }

	'}'

{ after(grammarAccess.getReferenceCSAccess().getRightCurlyBracketKeyword_6_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ReferenceCS__Group_6_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_6_1__0__Impl
	rule__ReferenceCS__Group_6_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_6_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getAlternatives_6_1_0()); }
(rule__ReferenceCS__Alternatives_6_1_0)
{ after(grammarAccess.getReferenceCSAccess().getAlternatives_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_6_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_6_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_6_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getCommaKeyword_6_1_1()); }
(
	','
)?
{ after(grammarAccess.getReferenceCSAccess().getCommaKeyword_6_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group_7_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0__0__Impl
	rule__ReferenceCS__Group_7_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getLeftCurlyBracketKeyword_7_0_0()); }

	'{'

{ after(grammarAccess.getReferenceCSAccess().getLeftCurlyBracketKeyword_7_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0__1__Impl
	rule__ReferenceCS__Group_7_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getAlternatives_7_0_1()); }
(rule__ReferenceCS__Alternatives_7_0_1)*
{ after(grammarAccess.getReferenceCSAccess().getAlternatives_7_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getRightCurlyBracketKeyword_7_0_2()); }

	'}'

{ after(grammarAccess.getReferenceCSAccess().getRightCurlyBracketKeyword_7_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ReferenceCS__Group_7_0_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_1__0__Impl
	rule__ReferenceCS__Group_7_0_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getKeyKeyword_7_0_1_1_0()); }

	'key'

{ after(grammarAccess.getReferenceCSAccess().getKeyKeyword_7_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_1__1__Impl
	rule__ReferenceCS__Group_7_0_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getReferredKeysAssignment_7_0_1_1_1()); }
(rule__ReferenceCS__ReferredKeysAssignment_7_0_1_1_1)
{ after(grammarAccess.getReferenceCSAccess().getReferredKeysAssignment_7_0_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_1__2__Impl
	rule__ReferenceCS__Group_7_0_1_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_1_2()); }
(rule__ReferenceCS__Group_7_0_1_1_2__0)*
{ after(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_1_3()); }

	';'

{ after(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ReferenceCS__Group_7_0_1_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_1_2__0__Impl
	rule__ReferenceCS__Group_7_0_1_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getCommaKeyword_7_0_1_1_2_0()); }

	','

{ after(grammarAccess.getReferenceCSAccess().getCommaKeyword_7_0_1_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getReferredKeysAssignment_7_0_1_1_2_1()); }
(rule__ReferenceCS__ReferredKeysAssignment_7_0_1_1_2_1)
{ after(grammarAccess.getReferenceCSAccess().getReferredKeysAssignment_7_0_1_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group_7_0_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_2__0__Impl
	rule__ReferenceCS__Group_7_0_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getInitialKeyword_7_0_1_2_0()); }

	'initial'

{ after(grammarAccess.getReferenceCSAccess().getInitialKeyword_7_0_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_2__1__Impl
	rule__ReferenceCS__Group_7_0_1_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getUnrestrictedNameParserRuleCall_7_0_1_2_1()); }
(	ruleUnrestrictedName)?
{ after(grammarAccess.getReferenceCSAccess().getUnrestrictedNameParserRuleCall_7_0_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_2__2__Impl
	rule__ReferenceCS__Group_7_0_1_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getColonKeyword_7_0_1_2_2()); }

	':'

{ after(grammarAccess.getReferenceCSAccess().getColonKeyword_7_0_1_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_2__3__Impl
	rule__ReferenceCS__Group_7_0_1_2__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsAssignment_7_0_1_2_3()); }
(rule__ReferenceCS__OwnedDefaultExpressionsAssignment_7_0_1_2_3)?
{ after(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsAssignment_7_0_1_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_2__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_2__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_2__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_2_4()); }

	';'

{ after(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_2_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__ReferenceCS__Group_7_0_1_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_3__0__Impl
	rule__ReferenceCS__Group_7_0_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getDerivationKeyword_7_0_1_3_0()); }

	'derivation'

{ after(grammarAccess.getReferenceCSAccess().getDerivationKeyword_7_0_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_3__1__Impl
	rule__ReferenceCS__Group_7_0_1_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getUnrestrictedNameParserRuleCall_7_0_1_3_1()); }
(	ruleUnrestrictedName)?
{ after(grammarAccess.getReferenceCSAccess().getUnrestrictedNameParserRuleCall_7_0_1_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_3__2__Impl
	rule__ReferenceCS__Group_7_0_1_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getColonKeyword_7_0_1_3_2()); }

	':'

{ after(grammarAccess.getReferenceCSAccess().getColonKeyword_7_0_1_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_3__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_3__3__Impl
	rule__ReferenceCS__Group_7_0_1_3__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_3__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsAssignment_7_0_1_3_3()); }
(rule__ReferenceCS__OwnedDefaultExpressionsAssignment_7_0_1_3_3)?
{ after(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsAssignment_7_0_1_3_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_3__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_3__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_3__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_3_4()); }

	';'

{ after(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_3_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__ReferenceCS__Group_7_0_1_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_4__0__Impl
	rule__ReferenceCS__Group_7_0_1_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedImplicitOppositesAssignment_7_0_1_4_0()); }
(rule__ReferenceCS__OwnedImplicitOppositesAssignment_7_0_1_4_0)
{ after(grammarAccess.getReferenceCSAccess().getOwnedImplicitOppositesAssignment_7_0_1_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_4_1()); }

	';'

{ after(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__StructuredClassCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__0__Impl
	rule__StructuredClassCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getIsAbstractAssignment_0()); }
(rule__StructuredClassCS__IsAbstractAssignment_0)?
{ after(grammarAccess.getStructuredClassCSAccess().getIsAbstractAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__1__Impl
	rule__StructuredClassCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getClassKeyword_1()); }

	'class'

{ after(grammarAccess.getStructuredClassCSAccess().getClassKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__2__Impl
	rule__StructuredClassCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getNameAssignment_2()); }
(rule__StructuredClassCS__NameAssignment_2)
{ after(grammarAccess.getStructuredClassCSAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__3__Impl
	rule__StructuredClassCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedSignatureAssignment_3()); }
(rule__StructuredClassCS__OwnedSignatureAssignment_3)?
{ after(grammarAccess.getStructuredClassCSAccess().getOwnedSignatureAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__4__Impl
	rule__StructuredClassCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getGroup_4()); }
(rule__StructuredClassCS__Group_4__0)?
{ after(grammarAccess.getStructuredClassCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__5__Impl
	rule__StructuredClassCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getGroup_5()); }
(rule__StructuredClassCS__Group_5__0)?
{ after(grammarAccess.getStructuredClassCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__6__Impl
	rule__StructuredClassCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getGroup_6()); }
(rule__StructuredClassCS__Group_6__0)?
{ after(grammarAccess.getStructuredClassCSAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getAlternatives_7()); }
(rule__StructuredClassCS__Alternatives_7)
{ after(grammarAccess.getStructuredClassCSAccess().getAlternatives_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__StructuredClassCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_4__0__Impl
	rule__StructuredClassCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getExtendsKeyword_4_0()); }

	'extends'

{ after(grammarAccess.getStructuredClassCSAccess().getExtendsKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_4__1__Impl
	rule__StructuredClassCS__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesAssignment_4_1()); }
(rule__StructuredClassCS__OwnedSuperTypesAssignment_4_1)
{ after(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getGroup_4_2()); }
(rule__StructuredClassCS__Group_4_2__0)*
{ after(grammarAccess.getStructuredClassCSAccess().getGroup_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__StructuredClassCS__Group_4_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_4_2__0__Impl
	rule__StructuredClassCS__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_4_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getCommaKeyword_4_2_0()); }

	','

{ after(grammarAccess.getStructuredClassCSAccess().getCommaKeyword_4_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_4_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_4_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesAssignment_4_2_1()); }
(rule__StructuredClassCS__OwnedSuperTypesAssignment_4_2_1)
{ after(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesAssignment_4_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__StructuredClassCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_5__0__Impl
	rule__StructuredClassCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getColonKeyword_5_0()); }

	':'

{ after(grammarAccess.getStructuredClassCSAccess().getColonKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getInstanceClassNameAssignment_5_1()); }
(rule__StructuredClassCS__InstanceClassNameAssignment_5_1)
{ after(grammarAccess.getStructuredClassCSAccess().getInstanceClassNameAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__StructuredClassCS__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_6__0__Impl
	rule__StructuredClassCS__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getLeftCurlyBracketKeyword_6_0()); }

	'{'

{ after(grammarAccess.getStructuredClassCSAccess().getLeftCurlyBracketKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_6__1__Impl
	rule__StructuredClassCS__Group_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getIsInterfaceAssignment_6_1()); }
(rule__StructuredClassCS__IsInterfaceAssignment_6_1)?
{ after(grammarAccess.getStructuredClassCSAccess().getIsInterfaceAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_6__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_6__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getRightCurlyBracketKeyword_6_2()); }

	'}'

{ after(grammarAccess.getStructuredClassCSAccess().getRightCurlyBracketKeyword_6_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__StructuredClassCS__Group_7_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_7_0__0__Impl
	rule__StructuredClassCS__Group_7_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_7_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getLeftCurlyBracketKeyword_7_0_0()); }

	'{'

{ after(grammarAccess.getStructuredClassCSAccess().getLeftCurlyBracketKeyword_7_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_7_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_7_0__1__Impl
	rule__StructuredClassCS__Group_7_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_7_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getAlternatives_7_0_1()); }
(rule__StructuredClassCS__Alternatives_7_0_1)*
{ after(grammarAccess.getStructuredClassCSAccess().getAlternatives_7_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_7_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_7_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_7_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getRightCurlyBracketKeyword_7_0_2()); }

	'}'

{ after(grammarAccess.getStructuredClassCSAccess().getRightCurlyBracketKeyword_7_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SysMLCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SysMLCS__Group__0__Impl
	rule__SysMLCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SysMLCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSysMLCSAccess().getSysMLCSAction_0()); }
(

)
{ after(grammarAccess.getSysMLCSAccess().getSysMLCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SysMLCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SysMLCS__Group__1__Impl
	rule__SysMLCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SysMLCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSysMLCSAccess().getSysmlKeyword_1()); }

	'sysml'

{ after(grammarAccess.getSysMLCSAccess().getSysmlKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SysMLCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SysMLCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SysMLCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSysMLCSAccess().getAlternatives_2()); }
(rule__SysMLCS__Alternatives_2)
{ after(grammarAccess.getSysMLCSAccess().getAlternatives_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SysMLCS__Group_2_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SysMLCS__Group_2_0__0__Impl
	rule__SysMLCS__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SysMLCS__Group_2_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSysMLCSAccess().getOwnedDetailsAssignment_2_0_0()); }
(rule__SysMLCS__OwnedDetailsAssignment_2_0_0)
{ after(grammarAccess.getSysMLCSAccess().getOwnedDetailsAssignment_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SysMLCS__Group_2_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SysMLCS__Group_2_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SysMLCS__Group_2_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSysMLCSAccess().getSemicolonKeyword_2_0_1()); }

	';'

{ after(grammarAccess.getSysMLCSAccess().getSemicolonKeyword_2_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SysMLCS__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SysMLCS__Group_2_1__0__Impl
	rule__SysMLCS__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SysMLCS__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSysMLCSAccess().getLeftCurlyBracketKeyword_2_1_0()); }

	'{'

{ after(grammarAccess.getSysMLCSAccess().getLeftCurlyBracketKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SysMLCS__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SysMLCS__Group_2_1__1__Impl
	rule__SysMLCS__Group_2_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SysMLCS__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSysMLCSAccess().getGroup_2_1_1()); }
(rule__SysMLCS__Group_2_1_1__0)*
{ after(grammarAccess.getSysMLCSAccess().getGroup_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SysMLCS__Group_2_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SysMLCS__Group_2_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SysMLCS__Group_2_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSysMLCSAccess().getRightCurlyBracketKeyword_2_1_2()); }

	'}'

{ after(grammarAccess.getSysMLCSAccess().getRightCurlyBracketKeyword_2_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SysMLCS__Group_2_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SysMLCS__Group_2_1_1__0__Impl
	rule__SysMLCS__Group_2_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SysMLCS__Group_2_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSysMLCSAccess().getOwnedDetailsAssignment_2_1_1_0()); }
(rule__SysMLCS__OwnedDetailsAssignment_2_1_1_0)
{ after(grammarAccess.getSysMLCSAccess().getOwnedDetailsAssignment_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SysMLCS__Group_2_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SysMLCS__Group_2_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SysMLCS__Group_2_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSysMLCSAccess().getSemicolonKeyword_2_1_1_1()); }

	';'

{ after(grammarAccess.getSysMLCSAccess().getSemicolonKeyword_2_1_1_1()); }
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
{ before(grammarAccess.getTypedMultiplicityRefCSAccess().getTypedRefCSParserRuleCall_0()); }
	ruleTypedRefCS
{ after(grammarAccess.getTypedMultiplicityRefCSAccess().getTypedRefCSParserRuleCall_0()); }
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






rule__TemplateSignatureCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_0__0__Impl
	rule__TemplateSignatureCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getLeftParenthesisKeyword_0_0()); }

	'('

{ after(grammarAccess.getTemplateSignatureCSAccess().getLeftParenthesisKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_0__1__Impl
	rule__TemplateSignatureCS__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_0_1()); }
(rule__TemplateSignatureCS__OwnedParametersAssignment_0_1)
{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_0__2__Impl
	rule__TemplateSignatureCS__Group_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getGroup_0_2()); }
(rule__TemplateSignatureCS__Group_0_2__0)*
{ after(grammarAccess.getTemplateSignatureCSAccess().getGroup_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group_0__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_0__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_0__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getRightParenthesisKeyword_0_3()); }

	')'

{ after(grammarAccess.getTemplateSignatureCSAccess().getRightParenthesisKeyword_0_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__TemplateSignatureCS__Group_0_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_0_2__0__Impl
	rule__TemplateSignatureCS__Group_0_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_0_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getCommaKeyword_0_2_0()); }

	','

{ after(grammarAccess.getTemplateSignatureCSAccess().getCommaKeyword_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group_0_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_0_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_0_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_0_2_1()); }
(rule__TemplateSignatureCS__OwnedParametersAssignment_0_2_1)
{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_0_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TemplateSignatureCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_1__0__Impl
	rule__TemplateSignatureCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getLessThanSignKeyword_1_0()); }

	'<'

{ after(grammarAccess.getTemplateSignatureCSAccess().getLessThanSignKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_1__1__Impl
	rule__TemplateSignatureCS__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_1_1()); }
(rule__TemplateSignatureCS__OwnedParametersAssignment_1_1)
{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_1__2__Impl
	rule__TemplateSignatureCS__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getGroup_1_2()); }
(rule__TemplateSignatureCS__Group_1_2__0)*
{ after(grammarAccess.getTemplateSignatureCSAccess().getGroup_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getGreaterThanSignKeyword_1_3()); }

	'>'

{ after(grammarAccess.getTemplateSignatureCSAccess().getGreaterThanSignKeyword_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__TemplateSignatureCS__Group_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_1_2__0__Impl
	rule__TemplateSignatureCS__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getCommaKeyword_1_2_0()); }

	','

{ after(grammarAccess.getTemplateSignatureCSAccess().getCommaKeyword_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_1_2_1()); }
(rule__TemplateSignatureCS__OwnedParametersAssignment_1_2_1)
{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypedTypeRefCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group__0__Impl
	rule__TypedTypeRefCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_0()); }
(rule__TypedTypeRefCS__OwnedPathNameAssignment_0)
{ after(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypedTypeRefCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getAlternatives_1()); }
(rule__TypedTypeRefCS__Alternatives_1)?
{ after(grammarAccess.getTypedTypeRefCSAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypedTypeRefCS__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_1_0__0__Impl
	rule__TypedTypeRefCS__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0_0()); }

	'('

{ after(grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypedTypeRefCS__Group_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_1_0__1__Impl
	rule__TypedTypeRefCS__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingAssignment_1_0_1()); }
(rule__TypedTypeRefCS__OwnedBindingAssignment_1_0_1)
{ after(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingAssignment_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypedTypeRefCS__Group_1_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_1_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_0_2()); }

	')'

{ after(grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_0_2()); }
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
{ before(grammarAccess.getTypedTypeRefCSAccess().getLessThanSignKeyword_1_1_0()); }

	'<'

{ after(grammarAccess.getTypedTypeRefCSAccess().getLessThanSignKeyword_1_1_0()); }
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
{ before(grammarAccess.getTypedTypeRefCSAccess().getGreaterThanSignKeyword_1_1_2()); }

	'>'

{ after(grammarAccess.getTypedTypeRefCSAccess().getGreaterThanSignKeyword_1_1_2()); }
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







rule__TopLevelCS__OwnedImportsAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getOwnedImportsImportCSParserRuleCall_2_0()); }
	ruleImportCS{ after(grammarAccess.getTopLevelCSAccess().getOwnedImportsImportCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TopLevelCS__OwnedPackagesAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getOwnedPackagesPackageCSParserRuleCall_3_0()); }
	rulePackageCS{ after(grammarAccess.getTopLevelCSAccess().getOwnedPackagesPackageCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__IsCallableAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getIsCallableCallableKeyword_0_0()); }
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getIsCallableCallableKeyword_0_0()); }

	'callable'

{ after(grammarAccess.getInvariantConstraintCSAccess().getIsCallableCallableKeyword_0_0()); }
)

{ after(grammarAccess.getInvariantConstraintCSAccess().getIsCallableCallableKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__StereotypeAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getStereotypeInvariantKeyword_1_0()); }
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getStereotypeInvariantKeyword_1_0()); }

	'invariant'

{ after(grammarAccess.getInvariantConstraintCSAccess().getStereotypeInvariantKeyword_1_0()); }
)

{ after(grammarAccess.getInvariantConstraintCSAccess().getStereotypeInvariantKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__NameAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getNameUnrestrictedNameParserRuleCall_2_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getInvariantConstraintCSAccess().getNameUnrestrictedNameParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__OwnedMessageSpecificationAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_2_1_1_0()); }
	ruleSpecificationCS{ after(grammarAccess.getInvariantConstraintCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InvariantConstraintCS__OwnedSpecificationAssignment_3_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvariantConstraintCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0_1_0()); }
	ruleSpecificationCS{ after(grammarAccess.getInvariantConstraintCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PostconditionConstraintCS__StereotypeAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getStereotypePostconditionKeyword_0_0()); }
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getStereotypePostconditionKeyword_0_0()); }

	'postcondition'

{ after(grammarAccess.getPostconditionConstraintCSAccess().getStereotypePostconditionKeyword_0_0()); }
)

{ after(grammarAccess.getPostconditionConstraintCSAccess().getStereotypePostconditionKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PostconditionConstraintCS__NameAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getPostconditionConstraintCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PostconditionConstraintCS__OwnedMessageSpecificationAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0()); }
	ruleSpecificationCS{ after(grammarAccess.getPostconditionConstraintCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PostconditionConstraintCS__OwnedSpecificationAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPostconditionConstraintCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getPostconditionConstraintCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PreconditionConstraintCS__StereotypeAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getStereotypePreconditionKeyword_0_0()); }
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getStereotypePreconditionKeyword_0_0()); }

	'precondition'

{ after(grammarAccess.getPreconditionConstraintCSAccess().getStereotypePreconditionKeyword_0_0()); }
)

{ after(grammarAccess.getPreconditionConstraintCSAccess().getStereotypePreconditionKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PreconditionConstraintCS__NameAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getPreconditionConstraintCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PreconditionConstraintCS__OwnedMessageSpecificationAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0()); }
	ruleSpecificationCS{ after(grammarAccess.getPreconditionConstraintCSAccess().getOwnedMessageSpecificationSpecificationCSParserRuleCall_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PreconditionConstraintCS__OwnedSpecificationAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPreconditionConstraintCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getPreconditionConstraintCSAccess().getOwnedSpecificationSpecificationCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getNameAlternatives_2_0()); }
(rule__AnnotationCS__NameAlternatives_2_0)
{ after(grammarAccess.getAnnotationCSAccess().getNameAlternatives_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__OwnedDetailsAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedDetailsDetailCSParserRuleCall_3_1_0()); }
	ruleDetailCS{ after(grammarAccess.getAnnotationCSAccess().getOwnedDetailsDetailCSParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__OwnedDetailsAssignment_3_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedDetailsDetailCSParserRuleCall_3_2_1_0()); }
	ruleDetailCS{ after(grammarAccess.getAnnotationCSAccess().getOwnedDetailsDetailCSParserRuleCall_3_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__OwnedAnnotationsAssignment_4_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_4_0_1_0_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getAnnotationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_4_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__OwnedContentsAssignment_4_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedContentsModelElementCSParserRuleCall_4_0_1_1_0()); }
	ruleModelElementCS{ after(grammarAccess.getAnnotationCSAccess().getOwnedContentsModelElementCSParserRuleCall_4_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationCS__OwnedReferencesAssignment_4_0_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationCSAccess().getOwnedReferencesModelElementRefCSParserRuleCall_4_0_1_2_0()); }
	ruleModelElementRefCS{ after(grammarAccess.getAnnotationCSAccess().getOwnedReferencesModelElementRefCSParserRuleCall_4_0_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_0_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }

	'static'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }

	'definition'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }

	'definition'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }

	'static'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getAttributeCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__OwnedTypeAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_1_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getAttributeCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__DefaultAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getAttributeCSAccess().getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_0_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_0_0()); }

	'derived'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_0_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_1_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_1_0()); }

	'!derived'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_1_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_2_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_2_0()); }

	'id'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_2_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_3_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_3_0()); }

	'!id'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_3_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_4_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_4_0()); }

	'ordered'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_4_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_5_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_5_0()); }

	'!ordered'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_5_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_6_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_6_0()); }

	'readonly'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_6_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_7_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_7_0()); }

	'!readonly'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_7_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_8_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_8_0()); }

	'transient'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_8_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_9_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_9_0()); }

	'!transient'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_9_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_10
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_10_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_10_0()); }

	'unique'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_10_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_11
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_11_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_11_0()); }

	'!unique'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_11_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_12
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_12_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_12_0()); }

	'unsettable'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_12_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_12_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_13
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_13_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_13_0()); }

	'!unsettable'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_13_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_13_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_14
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_14_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_14_0()); }

	'volatile'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_14_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_14_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_15
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_15_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_15_0()); }

	'!volatile'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_15_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_15_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__OwnedAnnotationsAssignment_6_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_6_0_1_0_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getAttributeCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_6_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__OwnedDefaultExpressionsAssignment_6_0_1_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_1_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__OwnedDefaultExpressionsAssignment_6_0_1_2_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_2_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_2_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__IsPrimitiveAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getIsPrimitivePrimitiveKeyword_0_0()); }
(
{ before(grammarAccess.getDataTypeCSAccess().getIsPrimitivePrimitiveKeyword_0_0()); }

	'primitive'

{ after(grammarAccess.getDataTypeCSAccess().getIsPrimitivePrimitiveKeyword_0_0()); }
)

{ after(grammarAccess.getDataTypeCSAccess().getIsPrimitivePrimitiveKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getDataTypeCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__OwnedSignatureAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0()); }
	ruleTemplateSignatureCS{ after(grammarAccess.getDataTypeCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__InstanceClassNameAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getDataTypeCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__IsSerializableAssignment_5_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getIsSerializableSerializableKeyword_5_1_0_0()); }
(
{ before(grammarAccess.getDataTypeCSAccess().getIsSerializableSerializableKeyword_5_1_0_0()); }

	'serializable'

{ after(grammarAccess.getDataTypeCSAccess().getIsSerializableSerializableKeyword_5_1_0_0()); }
)

{ after(grammarAccess.getDataTypeCSAccess().getIsSerializableSerializableKeyword_5_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__OwnedAnnotationsAssignment_6_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_6_0_1_0_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getDataTypeCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_6_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__OwnedConstraintsAssignment_6_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getOwnedConstraintsInvariantConstraintCSParserRuleCall_6_0_1_1_0()); }
	ruleInvariantConstraintCS{ after(grammarAccess.getDataTypeCSAccess().getOwnedConstraintsInvariantConstraintCSParserRuleCall_6_0_1_1_0()); }
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

rule__EnumerationCS__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getEnumerationCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__OwnedSignatureAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0()); }
	ruleTemplateSignatureCS{ after(grammarAccess.getEnumerationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__InstanceClassNameAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_3_1_0()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getEnumerationCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__IsSerializableAssignment_4_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getIsSerializableSerializableKeyword_4_1_0_0()); }
(
{ before(grammarAccess.getEnumerationCSAccess().getIsSerializableSerializableKeyword_4_1_0_0()); }

	'serializable'

{ after(grammarAccess.getEnumerationCSAccess().getIsSerializableSerializableKeyword_4_1_0_0()); }
)

{ after(grammarAccess.getEnumerationCSAccess().getIsSerializableSerializableKeyword_4_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__OwnedAnnotationsAssignment_5_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_5_0_1_0_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getEnumerationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_5_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__OwnedLiteralsAssignment_5_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getOwnedLiteralsEnumerationLiteralCSParserRuleCall_5_0_1_1_0()); }
	ruleEnumerationLiteralCS{ after(grammarAccess.getEnumerationCSAccess().getOwnedLiteralsEnumerationLiteralCSParserRuleCall_5_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__OwnedConstraintsAssignment_5_0_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getOwnedConstraintsInvariantConstraintCSParserRuleCall_5_0_1_2_0()); }
	ruleInvariantConstraintCS{ after(grammarAccess.getEnumerationCSAccess().getOwnedConstraintsInvariantConstraintCSParserRuleCall_5_0_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__NameAssignment_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getNameUnrestrictedNameParserRuleCall_0_0_1_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getEnumerationLiteralCSAccess().getNameUnrestrictedNameParserRuleCall_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__NameAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getNameEnumerationLiteralNameParserRuleCall_0_1_0()); }
	ruleEnumerationLiteralName{ after(grammarAccess.getEnumerationLiteralCSAccess().getNameEnumerationLiteralNameParserRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__LiteralAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getLiteralSINGLE_QUOTED_STRINGTerminalRuleCall_1_1_0()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getEnumerationLiteralCSAccess().getLiteralSINGLE_QUOTED_STRINGTerminalRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__ValueAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getValueSIGNEDParserRuleCall_2_1_0()); }
	ruleSIGNED{ after(grammarAccess.getEnumerationLiteralCSAccess().getValueSIGNEDParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__OwnedAnnotationsAssignment_3_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_3_0_1_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getEnumerationLiteralCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_3_0_1_0()); }
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
{ before(grammarAccess.getImportCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getImportCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0()); }
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

rule__ModelElementRefCS__OwnedPathNameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelElementRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_1_0()); }
	rulePathNameCS{ after(grammarAccess.getModelElementRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_0_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }

	'static'

{ after(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }

	'definition'

{ after(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }

	'definition'

{ after(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }

	'static'

{ after(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedSignatureAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0()); }
	ruleTemplateSignatureCS{ after(grammarAccess.getOperationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__NameAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getNameUnrestrictedNameParserRuleCall_3_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getOperationCSAccess().getNameUnrestrictedNameParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedParametersAssignment_5_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_0_0()); }
	ruleParameterCS{ after(grammarAccess.getOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedParametersAssignment_5_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_1_1_0()); }
	ruleParameterCS{ after(grammarAccess.getOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedTypeAssignment_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_7_1_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getOperationCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedExceptionsAssignment_8_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedExceptionsTypedRefCSParserRuleCall_8_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getOperationCSAccess().getOwnedExceptionsTypedRefCSParserRuleCall_8_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedExceptionsAssignment_8_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedExceptionsTypedRefCSParserRuleCall_8_2_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getOperationCSAccess().getOwnedExceptionsTypedRefCSParserRuleCall_8_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_9_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_0_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_0_0()); }

	'derived'

{ after(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_0_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_9_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_1_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_1_0()); }

	'!derived'

{ after(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_1_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_9_1_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_2_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_2_0()); }

	'ordered'

{ after(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_2_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_9_1_0_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_3_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_3_0()); }

	'!ordered'

{ after(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_3_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_9_1_0_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersTransientKeyword_9_1_0_4_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersTransientKeyword_9_1_0_4_0()); }

	'transient'

{ after(grammarAccess.getOperationCSAccess().getQualifiersTransientKeyword_9_1_0_4_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersTransientKeyword_9_1_0_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_9_1_0_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersTransientKeyword_9_1_0_5_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersTransientKeyword_9_1_0_5_0()); }

	'!transient'

{ after(grammarAccess.getOperationCSAccess().getQualifiersTransientKeyword_9_1_0_5_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersTransientKeyword_9_1_0_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_9_1_0_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_6_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_6_0()); }

	'unique'

{ after(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_6_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_9_1_0_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_7_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_7_0()); }

	'!unique'

{ after(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_7_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedAnnotationsAssignment_10_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_10_0_1_0_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getOperationCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_10_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedPreconditionsAssignment_10_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedPreconditionsPreconditionConstraintCSParserRuleCall_10_0_1_1_0()); }
	rulePreconditionConstraintCS{ after(grammarAccess.getOperationCSAccess().getOwnedPreconditionsPreconditionConstraintCSParserRuleCall_10_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedBodyExpressionsAssignment_10_0_1_2_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedBodyExpressionsSpecificationCSParserRuleCall_10_0_1_2_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getOperationCSAccess().getOwnedBodyExpressionsSpecificationCSParserRuleCall_10_0_1_2_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedPostconditionsAssignment_10_0_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedPostconditionsPostconditionConstraintCSParserRuleCall_10_0_1_3_0()); }
	rulePostconditionConstraintCS{ after(grammarAccess.getOperationCSAccess().getOwnedPostconditionsPostconditionConstraintCSParserRuleCall_10_0_1_3_0()); }
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
{ before(grammarAccess.getPackageCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getPackageCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); }
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
{ before(grammarAccess.getPackageCSAccess().getNsPrefixUnrestrictedNameParserRuleCall_2_1_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getPackageCSAccess().getNsPrefixUnrestrictedNameParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__NsURIAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getNsURIURIParserRuleCall_3_1_0()); }
	ruleURI{ after(grammarAccess.getPackageCSAccess().getNsURIURIParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__OwnedAnnotationsAssignment_4_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_4_0_1_0_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getPackageCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_4_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__OwnedPackagesAssignment_4_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getOwnedPackagesPackageCSParserRuleCall_4_0_1_1_0()); }
	rulePackageCS{ after(grammarAccess.getPackageCSAccess().getOwnedPackagesPackageCSParserRuleCall_4_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PackageCS__OwnedClassesAssignment_4_0_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPackageCSAccess().getOwnedClassesClassCSParserRuleCall_4_0_1_2_0()); }
	ruleClassCS{ after(grammarAccess.getPackageCSAccess().getOwnedClassesClassCSParserRuleCall_4_0_1_2_0()); }
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
{ before(grammarAccess.getParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__OwnedTypeAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_1_1_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getParameterCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__QualifiersAssignment_2_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_0_0()); }
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_0_0()); }

	'ordered'

{ after(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_0_0()); }
)

{ after(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__QualifiersAssignment_2_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_1_0()); }
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_1_0()); }

	'!ordered'

{ after(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_1_0()); }
)

{ after(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__QualifiersAssignment_2_1_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_2_0()); }
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_2_0()); }

	'unique'

{ after(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_2_0()); }
)

{ after(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__QualifiersAssignment_2_1_0_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_3_0()); }
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_3_0()); }

	'!unique'

{ after(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_3_0()); }
)

{ after(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__OwnedAnnotationsAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_3_1_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getParameterCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getImplicitOppositeCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__OwnedTypeAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getImplicitOppositeCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__QualifiersAssignment_4_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getQualifiersOrderedKeyword_4_1_0_0_0()); }
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getQualifiersOrderedKeyword_4_1_0_0_0()); }

	'ordered'

{ after(grammarAccess.getImplicitOppositeCSAccess().getQualifiersOrderedKeyword_4_1_0_0_0()); }
)

{ after(grammarAccess.getImplicitOppositeCSAccess().getQualifiersOrderedKeyword_4_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__QualifiersAssignment_4_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getQualifiersOrderedKeyword_4_1_0_1_0()); }
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getQualifiersOrderedKeyword_4_1_0_1_0()); }

	'!ordered'

{ after(grammarAccess.getImplicitOppositeCSAccess().getQualifiersOrderedKeyword_4_1_0_1_0()); }
)

{ after(grammarAccess.getImplicitOppositeCSAccess().getQualifiersOrderedKeyword_4_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__QualifiersAssignment_4_1_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getQualifiersUniqueKeyword_4_1_0_2_0()); }
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getQualifiersUniqueKeyword_4_1_0_2_0()); }

	'unique'

{ after(grammarAccess.getImplicitOppositeCSAccess().getQualifiersUniqueKeyword_4_1_0_2_0()); }
)

{ after(grammarAccess.getImplicitOppositeCSAccess().getQualifiersUniqueKeyword_4_1_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImplicitOppositeCS__QualifiersAssignment_4_1_0_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getQualifiersUniqueKeyword_4_1_0_3_0()); }
(
{ before(grammarAccess.getImplicitOppositeCSAccess().getQualifiersUniqueKeyword_4_1_0_3_0()); }

	'!unique'

{ after(grammarAccess.getImplicitOppositeCSAccess().getQualifiersUniqueKeyword_4_1_0_3_0()); }
)

{ after(grammarAccess.getImplicitOppositeCSAccess().getQualifiersUniqueKeyword_4_1_0_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_0_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }

	'static'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }

	'definition'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }

	'definition'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }

	'static'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getReferenceCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__ReferredOppositeAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getReferredOppositePropertyCrossReference_3_1_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getReferredOppositePropertyUnrestrictedNameParserRuleCall_3_1_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getReferenceCSAccess().getReferredOppositePropertyUnrestrictedNameParserRuleCall_3_1_0_1()); }
)
{ after(grammarAccess.getReferenceCSAccess().getReferredOppositePropertyCrossReference_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__OwnedTypeAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_1_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getReferenceCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__DefaultAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getReferenceCSAccess().getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_0_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_0_0()); }

	'composes'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_0_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_1_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_1_0()); }

	'!composes'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_1_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_2_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_2_0()); }

	'derived'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_2_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_3_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_3_0()); }

	'!derived'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_3_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_4_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_4_0()); }

	'ordered'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_4_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_5_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_5_0()); }

	'!ordered'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_5_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_6_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_6_0()); }

	'readonly'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_6_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_7_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_7_0()); }

	'!readonly'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_7_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_8_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_8_0()); }

	'resolve'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_8_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_9_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_9_0()); }

	'!resolve'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_9_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_10
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_10_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_10_0()); }

	'transient'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_10_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_11
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_11_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_11_0()); }

	'!transient'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_11_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_12
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_12_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_12_0()); }

	'unique'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_12_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_12_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_13
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_13_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_13_0()); }

	'!unique'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_13_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_13_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_14
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_14_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_14_0()); }

	'unsettable'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_14_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_14_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_15
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_15_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_15_0()); }

	'!unsettable'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_15_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_15_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_16
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_16_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_16_0()); }

	'volatile'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_16_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_16_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_17
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_17_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_17_0()); }

	'!volatile'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_17_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_17_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__OwnedAnnotationsAssignment_7_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getReferenceCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__ReferredKeysAssignment_7_0_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getReferredKeysPropertyCrossReference_7_0_1_1_1_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getReferredKeysPropertyUnrestrictedNameParserRuleCall_7_0_1_1_1_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getReferenceCSAccess().getReferredKeysPropertyUnrestrictedNameParserRuleCall_7_0_1_1_1_0_1()); }
)
{ after(grammarAccess.getReferenceCSAccess().getReferredKeysPropertyCrossReference_7_0_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__ReferredKeysAssignment_7_0_1_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getReferredKeysPropertyCrossReference_7_0_1_1_2_1_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getReferredKeysPropertyUnrestrictedNameParserRuleCall_7_0_1_1_2_1_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getReferenceCSAccess().getReferredKeysPropertyUnrestrictedNameParserRuleCall_7_0_1_1_2_1_0_1()); }
)
{ after(grammarAccess.getReferenceCSAccess().getReferredKeysPropertyCrossReference_7_0_1_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__OwnedDefaultExpressionsAssignment_7_0_1_2_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_2_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_2_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__OwnedDefaultExpressionsAssignment_7_0_1_3_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_3_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_3_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__OwnedImplicitOppositesAssignment_7_0_1_4_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedImplicitOppositesImplicitOppositeCSParserRuleCall_7_0_1_4_0_0()); }
	ruleImplicitOppositeCS{ after(grammarAccess.getReferenceCSAccess().getOwnedImplicitOppositesImplicitOppositeCSParserRuleCall_7_0_1_4_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificationCS__OwnedExpressionAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSpecificationCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0()); }
	ruleExpCS{ after(grammarAccess.getSpecificationCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificationCS__ExprStringAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSpecificationCSAccess().getExprStringUNQUOTED_STRINGTerminalRuleCall_1_0()); }
	RULE_UNQUOTED_STRING{ after(grammarAccess.getSpecificationCSAccess().getExprStringUNQUOTED_STRINGTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__IsAbstractAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getIsAbstractAbstractKeyword_0_0()); }
(
{ before(grammarAccess.getStructuredClassCSAccess().getIsAbstractAbstractKeyword_0_0()); }

	'abstract'

{ after(grammarAccess.getStructuredClassCSAccess().getIsAbstractAbstractKeyword_0_0()); }
)

{ after(grammarAccess.getStructuredClassCSAccess().getIsAbstractAbstractKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getStructuredClassCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__OwnedSignatureAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0()); }
	ruleTemplateSignatureCS{ after(grammarAccess.getStructuredClassCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__OwnedSuperTypesAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_4_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__OwnedSuperTypesAssignment_4_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_4_2_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_4_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__InstanceClassNameAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getStructuredClassCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__IsInterfaceAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getIsInterfaceInterfaceKeyword_6_1_0()); }
(
{ before(grammarAccess.getStructuredClassCSAccess().getIsInterfaceInterfaceKeyword_6_1_0()); }

	'interface'

{ after(grammarAccess.getStructuredClassCSAccess().getIsInterfaceInterfaceKeyword_6_1_0()); }
)

{ after(grammarAccess.getStructuredClassCSAccess().getIsInterfaceInterfaceKeyword_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__OwnedAnnotationsAssignment_7_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0()); }
	ruleAnnotationElementCS{ after(grammarAccess.getStructuredClassCSAccess().getOwnedAnnotationsAnnotationElementCSParserRuleCall_7_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__OwnedOperationsAssignment_7_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedOperationsOperationCSParserRuleCall_7_0_1_1_0()); }
	ruleOperationCS{ after(grammarAccess.getStructuredClassCSAccess().getOwnedOperationsOperationCSParserRuleCall_7_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__OwnedPropertiesAssignment_7_0_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedPropertiesStructuralFeatureCSParserRuleCall_7_0_1_2_0()); }
	ruleStructuralFeatureCS{ after(grammarAccess.getStructuredClassCSAccess().getOwnedPropertiesStructuralFeatureCSParserRuleCall_7_0_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__OwnedConstraintsAssignment_7_0_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedConstraintsInvariantConstraintCSParserRuleCall_7_0_1_3_0()); }
	ruleInvariantConstraintCS{ after(grammarAccess.getStructuredClassCSAccess().getOwnedConstraintsInvariantConstraintCSParserRuleCall_7_0_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SysMLCS__OwnedDetailsAssignment_2_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSysMLCSAccess().getOwnedDetailsDetailCSParserRuleCall_2_0_0_0()); }
	ruleDetailCS{ after(grammarAccess.getSysMLCSAccess().getOwnedDetailsDetailCSParserRuleCall_2_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SysMLCS__OwnedDetailsAssignment_2_1_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSysMLCSAccess().getOwnedDetailsDetailCSParserRuleCall_2_1_1_0_0()); }
	ruleDetailCS{ after(grammarAccess.getSysMLCSAccess().getOwnedDetailsDetailCSParserRuleCall_2_1_1_0_0()); }
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

rule__TemplateSignatureCS__OwnedParametersAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_0_1_0()); }
	ruleTypeParameterCS{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__OwnedParametersAssignment_0_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_0_2_1_0()); }
	ruleTypeParameterCS{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_0_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__OwnedParametersAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_1_1_0()); }
	ruleTypeParameterCS{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__OwnedParametersAssignment_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_1_2_1_0()); }
	ruleTypeParameterCS{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__OwnedPathNameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); }
	rulePathNameCS{ after(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__OwnedBindingAssignment_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_0_1_0()); }
	ruleTemplateBindingCS{ after(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_0_1_0()); }
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

rule__TuplePartCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
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
{ before(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); }
	ruleTypeExpCS{ after(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); }
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


RULE_UNQUOTED_STRING : '\u00A3$%^\u00A3$%^';

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


