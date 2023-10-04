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
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.contributions.UMLCollaborationUseEditorUtil;
import org.eclipse.papyrus.uml.textedit.common.xtext.ui.contentassist.UmlCommonProposalProvider;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * Customization of the default ProposalProvider of the textual property editor
 *
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class UmlCollaborationUseProposalProvider extends AbstractUmlCollaborationUseProposalProvider {


	/**
	 * Provides custom completion for the specifying the type of a {@link CollaborationUse}
	 *
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.contentassist.AbstractUmlCollaborationUseProposalProvider#completeCollaborationUseRule_Type(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 *
	 * @param model
	 * @param assignment
	 * @param context
	 * @param acceptor
	 */
	@Override
	public void completeCollaborationUseRule_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// the customization consists in proposing nothing. Proposals are handled by other methods.
		List<Type> allCollaboration = new ArrayList<Type>();
		allCollaboration.addAll(getRecursivelyOwnedType(getModel()));
		allCollaboration.addAll(getRecursivelyImportedType(getModel()));
		for (Type c : allCollaboration) {
			if (c.getName().contains(context.getPrefix())) {
				String displayString = c.getQualifiedName();
				String completionString = UMLCollaborationUseEditorUtil.getTypeLabel(c, getModel());
				ICompletionProposal completionProposal = createCompletionProposalWithReplacementOfPrefix(c, completionString, displayString, context);
				acceptor.accept(completionProposal);
			}
		}
		completeRuleCall(((RuleCall) assignment.getTerminal()), context, acceptor);

	}



	/**
	 *
	 * @see org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider#completeKeyword(org.eclipse.xtext.Keyword, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 *
	 * @param keyword
	 * @param contentAssistContext
	 * @param acceptor
	 */
	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {
		/*
		 * we avoid to have "::" after a correct Type (model::Collaboration1:: )
		 * and we want are able to complete something like "model:"
		 */
		if (keyword.getValue().equals("::") && !contentAssistContext.getPrefix().equals(":")) { //$NON-NLS-1$ //$NON-NLS-2$
			// do nothing
		} else {
			ICompletionProposal proposal = createCompletionProposal(keyword.getValue(), getKeywordDisplayString(keyword), getImage(keyword), contentAssistContext);
			getPriorityHelper().adjustKeywordPriority(proposal, contentAssistContext.getPrefix());
			acceptor.accept(proposal);
		}
	}

	/**
	 *
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.contentassist.AbstractUmlCollaborationUseProposalProvider#completeTypeRule_Path(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 *
	 * @param model
	 * @param assignment
	 * @param context
	 * @param acceptor
	 */
	@Override
	public void completeTypeRule_Path(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {

		// we can't use super, because we have an abstract class between this class and the class owning the correct method!
		UmlCommonProposalProvider provider = new UmlCommonProposalProvider();
		provider.setWantedType(Collaboration.class);
		provider.completeTypeRule_Path(model, assignment, context, acceptor);
	}

	/**
	 *
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.contentassist.AbstractUmlCollaborationUseProposalProvider#completeTypeRule_Type(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 *
	 * @param model
	 * @param assignment
	 * @param context
	 * @param acceptor
	 */
	@Override
	public void completeTypeRule_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// we can't use super, because we have an abstract class between this class and the class owning the correct method!
		UmlCommonProposalProvider provider = new UmlCommonProposalProvider();
		provider.setWantedType(Collaboration.class);
		provider.completeTypeRule_Type(model, assignment, context, acceptor);
	}


	/**
	 *
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.ui.contentassist.UmlCommonProposalProvider#isWantedType(org.eclipse.uml2.uml.Element)
	 *
	 * @param e
	 * @return
	 */
	@Override
	protected boolean isWantedType(Element e) {
		return e instanceof Collaboration;
	}

}
