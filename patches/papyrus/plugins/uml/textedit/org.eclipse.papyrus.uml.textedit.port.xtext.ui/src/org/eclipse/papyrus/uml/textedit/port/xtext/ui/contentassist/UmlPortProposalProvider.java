/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.port.xtext.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.uml.textedit.port.xtext.scoping.UmlPortScopeProvider;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.QualifiedName;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule;
import org.eclipse.papyrus.uml.tools.utils.PropertyUtil;
import org.eclipse.papyrus.uml.xtext.integration.CompletionProposalUtils;
import org.eclipse.papyrus.uml.xtext.integration.CustomCompletionProposal;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class UmlPortProposalProvider extends org.eclipse.papyrus.uml.textedit.port.xtext.ui.contentassist.AbstractUmlPortProposalProvider {



	/**
	 * Provides custom completion for the specifying the type of a property
	 *
	 * @see org.eclipse.papyrus.uml.textedit.property.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completePropertyRule_Type(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completePortRule_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		List<Classifier> allClassifiers = new ArrayList<Classifier>();
		Namespace namespace = (Namespace) EcoreUtil.getRootContainer(ContextElementUtil.getContextElement(model.eResource()));
		allClassifiers.addAll(getRecursivelyOwnedClassifiers(namespace));
		allClassifiers.addAll(getRecursivelyImportedClassifiers(namespace));
		for (Classifier c : allClassifiers) {
			if (c.getQualifiedName().toLowerCase().contains(context.getPrefix().toLowerCase())) {
				String displayString = c.getQualifiedName();
				String completionString = CompletionProposalUtils.getQualifiedNameLabelWithSufficientDepth(c, namespace);
				ICompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(c, completionString, displayString, context);
				acceptor.accept(completionProposal);
			}
		}
	}

	/**
	 * Provides custom completion for the root element in a qualified name
	 *
	 * @see org.eclipse.papyrus.uml.textedit.property.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeTypeRule_Path(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeTypeRule_Path(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		Namespace root = (Namespace) EcoreUtil.getRootContainer(ContextElementUtil.getContextElement(model.eResource()));

		if (root == null) {
			return;
		}

		// first accept the root Model
		String completionString = root.getName() + "::";
		String displayString = root.getName() + "::";
		// String displayString = c.getName() ;
		CustomCompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(root, completionString, displayString, context);
		acceptor.accept(completionProposal);

		// then accepts all packages imported by Model
		List<Package> importedPackages = root.getImportedPackages();
		for (Package p : importedPackages) {
			if (p.getName().toLowerCase().contains(context.getPrefix().toLowerCase())) {
				completionString = p.getName() + "::";
				displayString = p.getName() + "::";
				// String displayString = c.getName() ;
				completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(root, completionString, displayString, context);
				acceptor.accept(completionProposal);
			}
		}

	}

	/**
	 * Provides custom completion for specifying the type of a property, taking into account the path if the name is qualified
	 *
	 * @see org.eclipse.papyrus.uml.textedit.property.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeTypeRule_Type(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeTypeRule_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {

		Namespace namespace = ((Property) ContextElementUtil.getContextElement(model.eResource())).getNamespace();
		if (model instanceof TypeRule) {
			TypeRule typeRule = (TypeRule) model;
			QualifiedName path = typeRule.getPath();
			while (path.getRemaining() != null) {
				path = path.getRemaining();
			}
			namespace = path.getPath();
		} else if (!(model instanceof PortRule)) {
			return;
		}
		for (NamedElement n : namespace.getOwnedMembers()) {
			if (n instanceof Classifier) {
				if (n.getName().toLowerCase().contains(context.getPrefix().toLowerCase())) {
					String completionString = n.getName();
					String displayString = n.getName();
					CustomCompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(n, completionString, displayString, context);
					acceptor.accept(completionProposal);
				}
			}
		}

	}



	/**
	 * Provides custom completion for a path in a qualified name
	 *
	 * @see org.eclipse.papyrus.uml.textedit.property.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeQualifiedName_Path(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeQualifiedName_Path(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// The customization consists in proposing nothing. Proposals are already handled by other methods
	}

	/**
	 * Provides custom completion for a path, taking into account the path which has already been specified
	 *
	 * @see org.eclipse.papyrus.uml.textedit.property.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeQualifiedName_Remaining(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeQualifiedName_Remaining(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		QualifiedName path = (QualifiedName) model;
		for (NamedElement n : path.getPath().getOwnedMembers()) {
			if (n instanceof Package) {
				if (n.getName().toLowerCase().contains(context.getPrefix().toLowerCase())) {
					String completionString = n.getName() + "::";
					String displayString = n.getName() + "::";
					CustomCompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(n, completionString, displayString, context);
					acceptor.accept(completionProposal);
				}
			}
		}
		for (Package p : path.getPath().getImportedPackages()) {
			if (p.getName().toLowerCase().contains(context.getPrefix().toLowerCase())) {
				String completionString = p.getName() + "::";
				String displayString = p.getName() + "::";
				CustomCompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(p, completionString, displayString, context);
				acceptor.accept(completionProposal);
			}
		}
	}

	@Override
	public void completeRedefinesRule_Port(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		for (Property inherited : UmlPortScopeProvider.retrieveInheritedProperties(model)) {
			if (inherited.getName().toLowerCase().contains(context.getPrefix().toLowerCase())) {
				String completionString = inherited.getName();
				String displayString = PropertyUtil.getLabel(inherited);
				CustomCompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(inherited, completionString, displayString, context);
				acceptor.accept(completionProposal);
			}
		}
	}

	@Override
	public void completeSubsetsRule_Port(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		for (Property inherited : UmlPortScopeProvider.retrieveInheritedProperties(model)) {
			if (inherited.getName().toLowerCase().contains(context.getPrefix().toLowerCase())) {
				String completionString = inherited.getName();
				String displayString = PropertyUtil.getLabel(inherited);
				CustomCompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(inherited, completionString, displayString, context);
				acceptor.accept(completionProposal);
			}
		}
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
			super.completeKeyword(keyword, contentAssistContext, acceptor);
			return;
		}
		ModifiersRule modifiersRule = (ModifiersRule) model;
		boolean isOrdered = false;
		boolean isReadOnly = true;
		boolean isUnion = false;
		boolean isUnique = false;
		for (ModifierSpecification spec : modifiersRule.getValues()) {
			if (spec.getValue() != null) {
				switch (spec.getValue()) {
				case ORDERED:
					isOrdered = true;
					break;
				case READ_ONLY:
					isReadOnly = !isReadOnly;
					break;
				case UNION:
					isUnion = true;
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
		if (value.equals("ordered")) {
			if (!isOrdered) {
				super.completeKeyword(keyword, contentAssistContext, acceptor);
			}
		} else if (value.equals("readOnly")) {
			if (!isReadOnly) {
				super.completeKeyword(keyword, contentAssistContext, acceptor);
			}
		} else if (value.equals("unique")) {
			if (!isUnique) {
				super.completeKeyword(keyword, contentAssistContext, acceptor);
			}
		} else if (value.equals("union")) {
			if (!isUnion) {
				super.completeKeyword(keyword, contentAssistContext, acceptor);
			}
		} else {
			super.completeKeyword(keyword, contentAssistContext, acceptor);
		}
	}

	@Override
	public void complete_MultiplicityRule(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		String zero_one = "[0..1]";
		String one = "[1]";
		String one_star = "[1..*]";
		String star = "[*]";

		String completionString = "";
		String displayString = "";
		ICompletionProposal completionProposal = null;

		completionString = "" + zero_one.substring(context.getPrefix().length());
		displayString = "" + zero_one;
		completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context);
		acceptor.accept(completionProposal);

		completionString = "" + one.substring(context.getPrefix().length());
		displayString = "" + one;
		completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context);
		acceptor.accept(completionProposal);

		completionString = "" + one_star.substring(context.getPrefix().length());
		displayString = "" + one_star + "     ";
		completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context);
		acceptor.accept(completionProposal);

		completionString = "" + star.substring(context.getPrefix().length());
		displayString = "" + star;
		completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context);
		acceptor.accept(completionProposal);
	}

	@Override
	public void completeMultiplicityRule_Bounds(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {

		if (!(model instanceof MultiplicityRule)) {
			return;
		}

		MultiplicityRule multiplicityRule = (MultiplicityRule) model;

		if (multiplicityRule.getBounds().size() == 2) {
			String value = multiplicityRule.getBounds().get(1).getValue();
			try {
				Integer.valueOf(value);
			} catch (Exception e) {
				if (!multiplicityRule.getBounds().get(0).getValue().equals("*") && !multiplicityRule.getBounds().get(1).getValue().equals("*")) {
					String completionString = "*";
					String displayString = "*";
					ICompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context);
					acceptor.accept(completionProposal);
				}
			}
		}
	}

	/* ******************************************************************************
	 * Utility methods
	 * ******************************************************************************
	 */

	/**
	 * Utility methods wich returns the list of classifiers that are directly or indirectly owned by a context namespace
	 *
	 * @param context
	 *            The context namespace
	 * @return the list of classifiers that are directly or indirectly owned by the context namespace
	 */
	private List<Classifier> getRecursivelyOwnedClassifiers(Namespace context) {
		List<Classifier> recursivelyOwnedClassifiers = new ArrayList<Classifier>();

		List<Element> allOwnedElements = context.getOwnedElements();
		for (Element e : allOwnedElements) {
			if (e instanceof Classifier) {
				recursivelyOwnedClassifiers.add((Classifier) e);
			}
			if (e instanceof Namespace) {
				recursivelyOwnedClassifiers.addAll(getRecursivelyOwnedClassifiers((Namespace) e));
			}
		}

		return recursivelyOwnedClassifiers;
	}

	/**
	 * Utility methods which returns the list of classifiers that are directly or indirectly owned by the namespaces imported by a context namespace
	 *
	 * @param context
	 *            The context namespace
	 * @return the list of classifiers that are directly or indirectly owned by the namespaces imported by the context namespace
	 */
	private List<Classifier> getRecursivelyImportedClassifiers(Namespace context) {
		List<Classifier> recursivelyImportedClassifiers = new ArrayList<Classifier>();

		List<Package> importedPackages = context.getImportedPackages();
		for (Package p : importedPackages) {
			recursivelyImportedClassifiers.addAll(getRecursivelyOwnedClassifiers(p));
		}

		return recursivelyImportedClassifiers;
	}

}
