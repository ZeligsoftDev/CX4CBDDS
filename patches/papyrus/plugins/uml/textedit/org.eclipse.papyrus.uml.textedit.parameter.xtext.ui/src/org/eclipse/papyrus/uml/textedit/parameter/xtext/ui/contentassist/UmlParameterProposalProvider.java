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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.parameter.xtext.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.ui.contributions.UMLParameterEditorUtil;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class UmlParameterProposalProvider extends AbstractUmlParameterProposalProvider {





	/**
	 * Provides custom completion for the specifying the type of a {@link Parameter}
	 *
	 * @param model
	 * @param assignment
	 * @param context
	 * @param acceptor
	 */
	@Override
	public void completeParameterRule_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// the customization consists in proposing nothing. Proposals are handled by other methods.
		List<Type> allType = new ArrayList<Type>();
		allType.addAll(getRecursivelyOwnedType(getModel()));
		allType.addAll(getRecursivelyImportedType(getModel()));
		for (Type c : allType) {
			if (c.getName().contains(context.getPrefix())) {
				String displayString = c.getQualifiedName();
				String completionString = UMLParameterEditorUtil.getTypeLabel(c, getModel());
				ICompletionProposal completionProposal = createCompletionProposalWithReplacementOfPrefix(c, completionString, displayString, context);
				acceptor.accept(completionProposal);
			}
		}
		completeRuleCall(((RuleCall) assignment.getTerminal()), context, acceptor);
	}




	/**
	 *
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.ui.contentassist.UmlCommonProposalProvider#completeTypeRule_Type(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 *
	 * @param model
	 * @param assignment
	 * @param context
	 * @param acceptor
	 */
	@Override
	public void completeTypeRule_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!(model instanceof ParameterRule)) {
			return;
		} else {
			super.completeTypeRule_Type(model, assignment, context, acceptor);
		}
	}


	/**
	 *
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.ui.contentassist.AbstractUmlParameterProposalProvider#complete_MultiplicityRule(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.RuleCall,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 *
	 * @param model
	 * @param ruleCall
	 * @param context
	 * @param acceptor
	 */
	@Override
	public void complete_MultiplicityRule(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// we complete the multiplicity only when a type is specified
		if (model instanceof ParameterRule) {
			if (!typeExists((ParameterRule) model)) {
				return;
			}
		}
		super.complete_MultiplicityRule(model, ruleCall, context, acceptor);
	}

	/**
	 * Provides custom completion for keywords, in the context of "modifiers" specification
	 *
	 * @see org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider#completeKeyword(org.eclipse.xtext.Keyword, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {
		
		EObject model = contentAssistContext.getCurrentModel();
		if (!(model instanceof ModifiersRule)) {
			if (model instanceof ParameterRule) {
				if ("::".equals(keyword.getValue())) {// :: is proposed only if the Type is a Namespace and if this namespace contains possible element to type the parameter //$NON-NLS-1$
					TypeRule typeRule = ((ParameterRule) model).getType();
					Type type = null;
					if (typeRule != null) {
						type = typeRule.getType();
					}

					if (type != null && typeExists((ParameterRule) model)) {
						if (type instanceof Namespace) {
							List<Type> includedType = getRecursivelyOwnedType((Namespace) type);
							includedType.addAll(getRecursivelyImportedType((Namespace) type));
							if (includedType.isEmpty()) {
								return;
							}
						}
					}
				} else if ("[".equals(keyword.getValue())) { //$NON-NLS-1$
					if (!typeExists((ParameterRule) model)) {
						return;
					}

				} else if ("]".equals(keyword.getValue())) { //$NON-NLS-1$
					if (!typeExists((ParameterRule) model)) {
						return;
					}
				} else if ("{".equals(keyword.getValue())) { //$NON-NLS-1$
					if (!typeExists((ParameterRule) model)) {
						return;
					}
				}
			}
			super.completeKeyword(keyword, contentAssistContext, acceptor);
			return;
		}
		ModifiersRule modifiersRule = (ModifiersRule) model;
		boolean isOrdered = false;
		boolean isException = false;
		boolean isStream = false;
		boolean isUnique = false;
		for (ModifierSpecification spec : modifiersRule.getValues()) {
			if (spec.getValue() != null) {
				switch (spec.getValue()) {
				case ORDERED:
					isOrdered = true;
					break;
				case EXCEPTION:
					isException = true;
					break;
				case STREAM:
					isStream = true;
					break;
				case UNIQUE:
					isUnique = true;
					break;
				default:
					break;
				}
			}
		}
		String value = keyword.getValue();
		if (value.equals("ordered")) { //$NON-NLS-1$
			if (!isOrdered) {
				super.completeKeyword(keyword, contentAssistContext, acceptor);
			}
		} else if (value.equals("exception")) { //$NON-NLS-1$
			if (!isException) {
				super.completeKeyword(keyword, contentAssistContext, acceptor);
			}
		} else if (value.equals("unique")) { //$NON-NLS-1$
			if (!isUnique) {
				super.completeKeyword(keyword, contentAssistContext, acceptor);
			}
		} else if (value.equals("stream")) { //$NON-NLS-1$
			if (!isStream) {
				super.completeKeyword(keyword, contentAssistContext, acceptor);
			}
		} else {
			super.completeKeyword(keyword, contentAssistContext, acceptor);
		}
	}


	/**
	 * Tests if the type of the {@link ParameterRule} is set
	 *
	 * @param parameterRule
	 *            ( a {@link ParameterRule}) to complete)
	 * @return
	 *         <code>true</code> if the type of the parameter is specified, <code>false</code> if not
	 */

	protected boolean typeExists(ParameterRule parameterRule) {
		if (parameterRule instanceof ParameterRule) {
			ParameterRule currentModel = parameterRule;
			TypeRule ruleType = currentModel.getType();
			if (ruleType == null) {
				return true; // <Undefined>
			}
			Type type = ruleType.getType();
			if (type == null) {
				return false;
			}
			if (type.eContainer() == null && type.getName() == null) {
				return false;
			}
		}
		return true;
	}
}
