/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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

package org.eclipse.papyrus.uml.textedit.transition.xtext.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.uml.textedit.transition.xtext.scoping.UmlTransitionScopeProvider;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementUtil;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class UmlTransitionProposalProvider extends AbstractUmlTransitionProposalProvider {

	@Override
	public void complete_CallOrSignalEventRule(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		TransitionRule rule = (TransitionRule) model;
		if (model == null) {
			return;
		}
		List<EObject> operationAndSignals = UmlTransitionScopeProvider.getVisibleOperationAndSignals(ContextElementUtil.getContextElement(model.eResource()));
		List<EObject> alreadyUsedOperationAndSignals = new ArrayList<EObject>();
		if (rule != null && rule.getTriggers() != null && !rule.getTriggers().isEmpty()) {
			List<EventRule> eventRules = rule.getTriggers();
			for (EventRule eventRule : eventRules) {
				if (eventRule instanceof CallOrSignalEventRule) {
					CallOrSignalEventRule callOrSignalEventRule = (CallOrSignalEventRule) eventRule;
					if (callOrSignalEventRule.getOperationOrSignal() != null) {
						alreadyUsedOperationAndSignals.add(callOrSignalEventRule.getOperationOrSignal());
					}
				}
			}
		}
		operationAndSignals.removeAll(alreadyUsedOperationAndSignals);
		for (EObject o : operationAndSignals) {
			NamedElement opOrSignal = (NamedElement) o;
			if (opOrSignal.getName().startsWith(context.getPrefix())) {
				String completionString = opOrSignal.getName().substring(context.getPrefix().length());
				ICompletionProposal completionProposal = new CompletionProposal(completionString, // String to be inserted
						context.getOffset(), // Offset
						context.getSelectedText().length(), // Replacement length
						completionString.length(), // cursorPosition
						null, // image
						opOrSignal.getName() + " - " + (opOrSignal instanceof Operation ? //$NON-NLS-1$
								"Operation" : //$NON-NLS-1$
								"Signal"), // displayString //$NON-NLS-1$
						null, // contextInformation
						(opOrSignal instanceof Operation ?
								"Operation associated with the CallEvent of this trigger" :
									"Signal associated with the SignalEvent of this trigger") // additionalProposalInfo
				);
				// acceptor.accept(new CompletionProposal(replacementString, replacementOffset, replacementLength, cursorPosition, image, displayString, contextInformation, additionalProposalInfo))
				acceptor.accept(completionProposal);
			}
		}
	}
}
