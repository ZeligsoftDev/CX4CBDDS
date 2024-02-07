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
package org.eclipse.papyrus.uml.textedit.state.xtext.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.ui.util.DisplayUtils;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.QualifiedName;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.StateRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.SubmachineRule;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on
 * how to customize content assistant
 */
public class UmlStateProposalProvider extends AbstractUmlStateProposalProvider {

	private ILabelProvider labelProvider = DisplayUtils.getLabelProvider();

	/**
	 * Provides custom completion for the specifying the submachine of
	 * submachine state
	 *
	 * @see org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completePropertyRule_Type(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeStateRule_Submachine(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// the customization consists in proposing nothing. Proposals are
		// handled by other methods.
		List<StateMachine> allStateMachines = new ArrayList<StateMachine>();
		Namespace namespace = (Namespace) EcoreUtil.getRootContainer(ContextElementUtil.getContextElement(model
				.eResource()));
		allStateMachines.addAll(getRecursivelyOwnedStatemachines(namespace));
		allStateMachines.addAll(getRecursivelyImportedStatemachines(namespace));
		for (StateMachine s : allStateMachines) {
			if (s.getName().contains(context.getPrefix())) {
				String displayString = s.getQualifiedName();
				String completionString = getSubmachineLabel(s);
				ICompletionProposal completionProposal = createCompletionProposalWithReplacementOfPrefix(s,
						completionString, displayString, context);
				acceptor.accept(completionProposal);
			}
		}
	}

	/**
	 * Provides custom completion for the root element in a qualified name
	 *
	 * @see org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeTypeRule_Path(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeSubmachineRule_Path(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		
		Namespace root = (Namespace) EcoreUtil
				.getRootContainer(ContextElementUtil.getContextElement(model.eResource()));
		if (root == null) {
			return;
		}

		// first accept the root Model
		String completionString = root.getName() + "::";
		String displayString = root.getName() + "::";
		// String displayString = c.getName() ;
		ICompletionProposal completionProposal = createCompletionProposalWithReplacementOfPrefix(root,
				completionString, displayString, context);
		acceptor.accept(completionProposal);

		// then accepts all packages imported by Model
		List<Package> importedPackages = root.getImportedPackages();
		for (Package p : importedPackages) {
			if (p.getName().startsWith(context.getPrefix())) {
				completionString = p.getName().substring(context.getPrefix().length()) + "::";
				displayString = p.getName() + "::";
				// String displayString = c.getName() ;
				completionProposal = createCompletionProposal(root, completionString, displayString, context);
				acceptor.accept(completionProposal);
			}
		}

	}

	/**
	 * Provides custom completion for specifying the submachine of a submachine
	 * state, taking into account the path if the name is qualified
	 *
	 * @see org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeTypeRule_Type(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeSubmachineRule_Submachine(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Element contextElement = (Element) ContextElementUtil.getContextElement(model.eResource());
		Namespace namespace = contextElement.getNearestPackage();
		if (model instanceof SubmachineRule) {
			SubmachineRule typeRule = (SubmachineRule) model;
			QualifiedName path = typeRule.getPath();
			while (path.getRemaining() != null) {
				path = path.getRemaining();
			}
			namespace = path.getPath();
		} else if (!(model instanceof StateRule)) {
			return;
		}
		for (NamedElement n : namespace.getOwnedMembers()) {
			if (n instanceof StateMachine) {
				if (n.getName().startsWith(context.getPrefix())) {
					String completionString = n.getName().substring(context.getPrefix().length());
					String displayString = n.getName();
					// String displayString = c.getName() ;
					ICompletionProposal completionProposal = createCompletionProposal(n, completionString,
							displayString, context);
					acceptor.accept(completionProposal);
				}
			}
		}

		// super.completeTypeRule_Type(model, assignment, context, acceptor) ;
	}

	/**
	 * Provides custom completion for a path in a qualified name
	 *
	 * @see org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeQualifiedName_Path(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeQualifiedName_Path(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// The customization consists in proposing nothing. Proposals are
		// already handled by other methods
	}

	/**
	 * Provides custom completion for a path, taking into account the path which
	 * has already been specified
	 *
	 * @see org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeQualifiedName_Remaining(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeQualifiedName_Remaining(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		
		QualifiedName path = (QualifiedName) model;
		for (NamedElement n : path.getPath().getOwnedMembers()) {
			if (n instanceof Namespace && !(n instanceof StateMachine)) {
				if (n.getName().startsWith(context.getPrefix())) {
					String completionString = n.getName().substring(context.getPrefix().length()) + "::";
					String displayString = n.getName() + "::";
					// String displayString = c.getName() ;
					ICompletionProposal completionProposal = createCompletionProposal(n, completionString,
							displayString, context);
					acceptor.accept(completionProposal);
				}
			}
		}
		for (Package p : path.getPath().getImportedPackages()) {
			if (p.getName().startsWith(context.getPrefix())) {
				String completionString = p.getName().substring(context.getPrefix().length()) + "::";
				String displayString = p.getName() + "::";
				// String displayString = c.getName() ;
				ICompletionProposal completionProposal = createCompletionProposal(p, completionString, displayString,
						context);
				acceptor.accept(completionProposal);
			}
		}
	}

	/* ******************************************************************************
	 * Utility methods
	 * ***********************************************************
	 * *******************
	 */

	public static String getSubmachineLabel(StateMachine statemachine) {
		String label = "";

		Namespace model = (Namespace) EcoreUtil.getRootContainer(ContextElementUtil.getContextElement(statemachine
				.eResource()));
		List<Package> importedPackages = new ArrayList<Package>(model.getImportedPackages());

		List<Namespace> visitedNamespaces = new ArrayList<Namespace>();
		Namespace currentNamespace = statemachine.getNamespace();

		boolean rootFound = false;

		while (currentNamespace != null && !rootFound) {
			visitedNamespaces.add(currentNamespace);
			if (importedPackages.contains(currentNamespace) || currentNamespace == model) {
				rootFound = true;
			}
			Element owner = currentNamespace.getOwner();
			currentNamespace = owner != null ? (Namespace) owner : null;
		}

		for (int i = visitedNamespaces.size() - 1; i >= 0; i--) {
			label += visitedNamespaces.get(i).getName() + "::";
		}

		return label + statemachine.getName();
	}

	/**
	 * Private Utility method for creating a completion proposal
	 *
	 * @param namedElement
	 *            The named element for which completion proposal must be
	 *            created
	 * @param completionString
	 *            The actual completion string
	 * @param displayString
	 *            The way the completion is displayed in the completion list
	 * @param context
	 *            Some information related to the context of the completion
	 * @return
	 */
	protected ICompletionProposal createCompletionProposal(NamedElement namedElement, String completionString,
			String displayString, ContentAssistContext context) {
		String additionalProposalInfo = "" + namedElement.getQualifiedName() + "\n" + '('
				+ namedElement.eClass().getName() + ')';

		ICompletionProposal completionProposal = new CompletionProposal(completionString, // String
																							// to
																							// be
																							// inserted
				context.getOffset(), // Offset
				context.getSelectedText().length(), // Replacement length
				completionString.length(), // cursorPosition
				labelProvider.getImage(namedElement), // image
				" " + displayString, // displayString
				null, // contextInformation
				additionalProposalInfo // additionalProposalInfo
		);
		return completionProposal;
	}

	/**
	 * Private Utility method for creating a completion proposal with
	 * replacement of prefix
	 *
	 * @param namedElement
	 *            The named element for which completion proposal must be
	 *            created
	 * @param completionString
	 *            The actual completion string
	 * @param displayString
	 *            The way the completion is displayed in the completion list
	 * @param context
	 *            Some information related to the context of the completion
	 * @return
	 */
	protected ICompletionProposal createCompletionProposalWithReplacementOfPrefix(NamedElement namedElement,
			String completionString, String displayString, ContentAssistContext context) {
		String additionalProposalInfo = "" + namedElement.getQualifiedName() + "\n" + '('
				+ namedElement.eClass().getName() + ')';

		ICompletionProposal completionProposal = new CompletionProposal(completionString, // String
																							// to
																							// be
																							// inserted
				context.getOffset() - context.getPrefix().length(), // Offset
				context.getPrefix().length(), // Replacement length
				completionString.length(), // cursorPosition
				labelProvider.getImage(namedElement), // image
				" " + displayString, // displayString
				null, // contextInformation
				additionalProposalInfo // additionalProposalInfo
		);
		return completionProposal;
	}

	/**
	 * Private Utility method for creating a completion proposal
	 *
	 * @param completionString
	 *            The actual completion string
	 * @param displayString
	 *            The way the completion is displayed in the completion list
	 * @param context
	 *            Some information related to the context of the completion
	 * @return
	 */
	protected ICompletionProposal createCompletionProposal(String completionString, String displayString,
			ContentAssistContext context) {

		ICompletionProposal completionProposal = new CompletionProposal(completionString, // String
																							// to
																							// be
																							// inserted
				context.getOffset(), // Offset
				context.getSelectedText().length(), // Replacement length
				completionString.length(), // cursorPosition
				null, // image
				" " + displayString, // displayString
				null, // contextInformation
				null // additionalProposalInfo
		);
		return completionProposal;
	}

	/**
	 * Utility methods wich returns the list of statemachines that are directly
	 * or indirectly owned by a context statemachine
	 *
	 * @param context
	 *            The context namespace
	 * @return the list of statemachines that are directly or indirectly owned
	 *         by the context namespace
	 */
	private List<StateMachine> getRecursivelyOwnedStatemachines(Namespace context) {
		List<StateMachine> recursivelyOwnedStatemachines = new ArrayList<StateMachine>();

		List<Element> allOwnedElements = context.getOwnedElements();
		for (Element e : allOwnedElements) {
			if (e instanceof StateMachine) {
				recursivelyOwnedStatemachines.add((StateMachine) e);
			} else if (e instanceof Namespace) {
				recursivelyOwnedStatemachines.addAll(getRecursivelyOwnedStatemachines((Namespace) e));
			}
		}

		return recursivelyOwnedStatemachines;
	}

	/**
	 * Utility methods which returns the list of statemachines that are directly
	 * or indirectly owned by the namespaces imported by a context namespace
	 *
	 * @param context
	 *            The context namespace
	 * @return the list of statemachines that are directly or indirectly owned
	 *         by the namespaces imported by the context namespace
	 */
	private List<StateMachine> getRecursivelyImportedStatemachines(Namespace context) {
		List<StateMachine> recursivelyImportedStateMachines = new ArrayList<StateMachine>();

		List<Package> importedPackages = context.getImportedPackages();
		for (Package p : importedPackages) {
			recursivelyImportedStateMachines.addAll(getRecursivelyOwnedStatemachines(p));
		}

		return recursivelyImportedStateMachines;
	}
}
