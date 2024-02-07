/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.contentassist;

import java.util.Iterator;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.infra.widgets.providers.HierarchicToFlatContentProvider;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.StringConstants;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.ExpressionValueRule;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.contributions.StereotypePropertyEditorConfigurationContribution;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.xtext.integration.CompletionProposalUtils;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class AppliedStereotypePropertyProposalProvider extends AbstractAppliedStereotypePropertyProposalProvider {


	@Override
	public void complete_ExpressionValueRule(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
	}


	public void completeNameExpression_Name(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {

		AppliedStereotypeProperty appliedStereotypeProperty = StereotypePropertyEditorConfigurationContribution.getAppliedStereoProperty();

		if (appliedStereotypeProperty != null) {

			if ((model instanceof ExpressionValueRule) && ((appliedStereotypeProperty.getStereotypeProperty().getUpper() == 1)) || (!(model instanceof ExpressionValueRule))) {
				EClass stereotypeApplication = appliedStereotypeProperty.getStereotypeApplication().eClass();

				EStructuralFeature foundStructuralFeature = null;
				Iterator<EStructuralFeature> iterator = stereotypeApplication.getEAllStructuralFeatures().iterator();
				while (iterator.hasNext()) {
					EStructuralFeature eStructuralFeature = iterator.next();
					if (eStructuralFeature.getName().equals(appliedStereotypeProperty.getStereotypeProperty().getName())) {
						foundStructuralFeature = eStructuralFeature;
					}
				}
				if (foundStructuralFeature != null) {
					UMLContentProvider umlContentProvider = new UMLContentProvider(appliedStereotypeProperty.getStereotypeApplication(), foundStructuralFeature, appliedStereotypeProperty.getStereotype());
					HierarchicToFlatContentProvider treeToFlatContentProvider = new HierarchicToFlatContentProvider(umlContentProvider);
					Object[] result = treeToFlatContentProvider.getElements();
					// UMLLabelProvider umlLabelProvider = new UMLLabelProvider();
					for (int i = 0; i < result.length; i++) {
						if (result[i] instanceof EObject && UMLUtil.getBaseElement((EObject) result[i]) != null) {
							acceptor.accept(CompletionProposalUtils.createCompletionProposal(((NamedElement) UMLUtil.getBaseElement((EObject) result[i])), ((NamedElement) UMLUtil.getBaseElement((EObject) result[i])).getQualifiedName(),
									((NamedElement) UMLUtil.getBaseElement((EObject) result[i])).getQualifiedName(), context));
						} else if (result[i] instanceof EEnumLiteral) {
							EEnumLiteral enumerationLiteral = (EEnumLiteral) result[i];
							acceptor.accept(CompletionProposalUtils.createCompletionProposal(enumerationLiteral.getName(), enumerationLiteral.getName(), context));
						} else if (result[i] instanceof Enumerator) {
							Enumerator enumerationLiteral = (Enumerator) result[i];
							acceptor.accept(CompletionProposalUtils.createCompletionProposal(enumerationLiteral.getName(), enumerationLiteral.getName(), context));
						} else {
							if (result[i] instanceof NamedElement) {
								NamedElement namedElement = (NamedElement) result[i];
								acceptor.accept(CompletionProposalUtils.createCompletionProposal(namedElement, namedElement.getQualifiedName(), namedElement.getQualifiedName(), context));
							}
						}
					}
					completeRuleCall(((RuleCall) assignment.getTerminal()), context, acceptor);
				}
			}
		}
	}

	/*
	 * @Override
	 * public void completeNameExpression_Id(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
	 * // acceptor.accept(CompletionProposalUtils.createCompletionProposal("NameExpression_Id", "NameExpression_Id", context)) ;
	 * super.completeNameExpression_Id(model, assignment, context, acceptor);
	 * // completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	 * }
	 */

	public void completeBooleanKeyWord(Keyword keyword, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor, AppliedStereotypeProperty appliedStereotypeProperty) {

		if (appliedStereotypeProperty.getStereotypeProperty().getType().getName().equals(StringConstants.BOOLEAN)) {
			if (keyword.getValue().startsWith(StringConstants.TRUE) || (keyword.getValue().startsWith(StringConstants.FALSE))) {
				addKeyWord(keyword, contentAssistContext, acceptor);
			}
		}
	}


	public void addKeyWord(Keyword keyword, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {

		ICompletionProposal proposal = createCompletionProposal(keyword.getValue(), getKeywordDisplayString(keyword), getImage(keyword), contentAssistContext);
		getPriorityHelper().adjustKeywordPriority(proposal, contentAssistContext.getPrefix());
		acceptor.accept(proposal);

	}

	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {

		if (!contentAssistContext.getPrefix().equals(StringConstants.EMPTY) && !contentAssistContext.getPrefix().equals(StringConstants.EQUALS)) {
			if (keyword.getValue().startsWith(contentAssistContext.getPrefix())) {
				super.completeKeyword(keyword, contentAssistContext, acceptor);
			}
		} else {
			// take in account cardinalities and type of the properties
			AppliedStereotypeProperty appliedStereotypeProperty = StereotypePropertyEditorConfigurationContribution.getAppliedStereoProperty();

			if (appliedStereotypeProperty != null) {
				completeBooleanKeyWord(keyword, contentAssistContext, acceptor, appliedStereotypeProperty);
				// collection
				if (appliedStereotypeProperty.getStereotypeProperty().getUpper() == -1 || appliedStereotypeProperty.getStereotypeProperty().getUpper() > 1) {
					if (keyword.getValue().startsWith(StringConstants.CURLY_CLOSE) || keyword.getValue().startsWith(StringConstants.CURLY_OPEN) || keyword.getValue().startsWith(StringConstants.COMMA) || keyword.getValue().startsWith(StringConstants.NULL)
							|| keyword.getValue().startsWith(StringConstants.COMMA)) {
						addKeyWord(keyword, contentAssistContext, acceptor);
					}
				}
				if (appliedStereotypeProperty.getStereotypeProperty().getUpper() == 1) {
					if (keyword.getValue().startsWith(StringConstants.NULL)) {
						addKeyWord(keyword, contentAssistContext, acceptor);
					}
				}

				if (appliedStereotypeProperty.getStereotypeProperty().getType().eClass().getName().equals(StringConstants.PRIMITIVE_TYPE)) {
					if (keyword.getValue().startsWith("\"")) { //$NON-NLS-1$
						addKeyWord(keyword, contentAssistContext, acceptor);
					}
				}
			}
		}
	}
}
