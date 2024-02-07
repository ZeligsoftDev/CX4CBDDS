/*****************************************************************************
 * Copyright (c) 2012, 2018 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Bug 533527
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Bug 539319
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.common.xtext.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.ui.util.EditorHelper;
import org.eclipse.papyrus.uml.textedit.common.xtext.ui.internal.UmlCommonActivator;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IShowInSource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class UmlCommonProposalProvider extends AbstractUmlCommonProposalProvider {


	/** the label provider */
	protected ILabelProvider labelProvider;

	/** the edited model */
	private Namespace model = null;

	/** the edited element */
	private Element contextElement = null;

	/** the wanted type */
	private Class<?> wantedType = Type.class;

	/**
	 *
	 * Constructor.
	 *
	 *
	 */
	public UmlCommonProposalProvider() {
		initModel();
	}

	/**
	 * Getter for {@link #model}
	 *
	 * @return
	 * 		{@link #model}
	 */
	protected Namespace getModel() {
		return this.model;
	}

	/**
	 * Getter for {@link #contextElement}
	 *
	 * @return
	 * 		{@link #contextElement}
	 */
	protected Element getContextElement() {
		return this.contextElement;
	}

	/**
	 *
	 * This method initializes the fields {@link #model} {@link #contextElement} {@link #labelProvider} thanks to the current selection
	 *
	 */
	protected void initModel() {
		// get selection from active editor, this assures that suitable selection is obtained if triggered
		// from property view (fix for bug 533527)
		final IEditorPart activeEditor = EditorHelper.getCurrentEditor();
		ISelection mySelection = null;

		if (null != activeEditor) {// papyrus editor is opened with a selection in the current diagram/table
			mySelection = activeEditor.getEditorSite().getSelectionProvider().getSelection();
		}


		if (mySelection.isEmpty()) {
			/*
			 * handle the two following use case, if diagrams/tables are closed, only the Welcome page is displayed:
			 * 1. we are in the modelexplorer and we are displaying a property view.
			 * --Example: selecting the OpaqueExpression, used as specification of a Constraint
			 * 2. we already are in the Property View and we want to open a dialog embedding Xtext
			 * --Example: We want to edit the Constraint's specification represented by an OpaqueExpression from the Property View
			 */
			final IWorkbenchPart part = EditorHelper.getActivePart();
			final IShowInSource source = part.getAdapter(IShowInSource.class);
			if (null != source && null != source.getShowInContext()) {
				mySelection = source.getShowInContext().getSelection();
			}
		}

		EObject first = null;
		if (!mySelection.isEmpty() && mySelection instanceof IStructuredSelection) {
			first = EMFHelper.getEObject(((IStructuredSelection) mySelection).getFirstElement());
		}

		if (first instanceof Element) {
			this.contextElement = (Element) first;
		}

		if (null != this.contextElement) {
			if (this.contextElement != null) {
				List<Namespace> namespaces = this.contextElement.getNearestPackage().allNamespaces();
				if (namespaces.size() == 0) {
					this.model = this.contextElement.getNearestPackage();
				} else {
					this.model = namespaces.get(namespaces.size() - 1);
				}
			}
		}


		if (null != this.model) {
			try {
				this.labelProvider = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, this.model).getLabelProvider();
			} catch (ServiceException ex) {
				LogManager.getLogger(UmlCommonActivator.class).error(ex);
				this.labelProvider = new LabelProvider();
			}
		}

		Assert.isNotNull(this.contextElement, "I can't find the edited element"); //$NON-NLS-1$
		Assert.isNotNull(this.model, "I can't find the model owning the edited element"); //$NON-NLS-1$

	}

	/**
	 *
	 * @see org.eclipse.papyrus.parameter.editor.xtext.ui.contentassist.AbstractUmlParameterProposalProvider#complete_MultiplicityRule(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.RuleCall, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 *
	 * @param model
	 * @param ruleCall
	 * @param context
	 * @param acceptor
	 */
	@Override
	public void complete_MultiplicityRule(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {

		String one = "[1]"; //$NON-NLS-1$
		String one_star = "[1..*]"; //$NON-NLS-1$
		String star = "[*]"; //$NON-NLS-1$

		String completionString = ""; //$NON-NLS-1$
		String displayString = ""; //$NON-NLS-1$
		// String displayString = c.getName() ;
		ICompletionProposal completionProposal = null;

		completionString = "" + one.substring(context.getPrefix().length()); //$NON-NLS-1$
		displayString = "" + one; //$NON-NLS-1$
		completionProposal = createCompletionProposal(completionString, displayString, context);
		acceptor.accept(completionProposal);

		completionString = "" + one_star.substring(context.getPrefix().length()); //$NON-NLS-1$
		displayString = "" + one_star + "     "; //$NON-NLS-1$ //$NON-NLS-2$
		completionProposal = createCompletionProposal(completionString, displayString, context);
		acceptor.accept(completionProposal);

		completionString = "" + star.substring(context.getPrefix().length()); //$NON-NLS-1$
		displayString = "" + star; //$NON-NLS-1$
		completionProposal = createCompletionProposal(completionString, displayString, context);
		acceptor.accept(completionProposal);
	}


	/**
	 *
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.ui.contentassist.AbstractUmlCommonProposalProvider#completeMultiplicityRule_Bounds(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 *
	 * @param model
	 * @param assignment
	 * @param context
	 * @param acceptor
	 */
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
				if (!multiplicityRule.getBounds().get(0).getValue().equals("*") && !multiplicityRule.getBounds().get(1).getValue().equals("*")) { //$NON-NLS-1$ //$NON-NLS-2$
					String completionString = "*"; //$NON-NLS-1$
					String displayString = "*"; //$NON-NLS-1$
					ICompletionProposal completionProposal = createCompletionProposal(completionString, displayString, context);
					acceptor.accept(completionProposal);
				}
			}
		}
	}

	/**
	 *
	 * @see org.eclipse.papyrus.collaborationuse.editor.xtext.ui.contentassist.AbstractUmlCollaborationUseProposalProvider#completeQualifiedName_Path(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 *
	 * @param model
	 * @param assignment
	 * @param context
	 * @param acceptor
	 */
	@Override
	public void completeQualifiedName_Path(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// The customization consists in proposing nothing. Proposals are already handled by other methods
	}

	/**
	 * Provides custom completion for a path, taking into account the path which has already been specified
	 *
	 * @see org.eclipse.papyrus.collaborationuse.editor.xtext.ui.contentassist.AbstractUmlCollaborationUseProposalProvider#completeQualifiedName_Remaining(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 *
	 * @param model
	 * @param assignment
	 * @param context
	 * @param acceptor
	 */
	@Override
	public void completeQualifiedName_Remaining(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {


		QualifiedName path = (QualifiedName) model;
		for (NamedElement n : path.getPath().getOwnedMembers()) {
			// we add the namespace only if he contains interesting element
			if (n instanceof Namespace) {
				if (n.getName().startsWith(context.getPrefix())) {
					String completionString = n.getName().substring(context.getPrefix().length()) + "::"; //$NON-NLS-1$
					String displayString = n.getName() + "::"; //$NON-NLS-1$
					ICompletionProposal completionProposal = createCompletionProposal(n, completionString, displayString, context);
					List<Type> accessibleType = getRecursivelyOwnedType((Namespace) n);
					accessibleType.addAll(getRecursivelyImportedType((Namespace) n));
					if (accessibleType.size() != 0) {
						acceptor.accept(completionProposal);
					}
				}

				// we add the namespace to the possible element, if the namespace has the correct type
				if (n.getName().startsWith(context.getPrefix())) {
					String completionString = n.getName().substring(context.getPrefix().length());
					String displayString = n.getName();
					ICompletionProposal completionProposal = createCompletionProposal(n, completionString, displayString, context);
					if (isWantedType(n)) {
						acceptor.accept(completionProposal);
					}
				}
			}
		}
		for (Package p : path.getPath().getImportedPackages()) {
			if (p.getName().startsWith(context.getPrefix())) {
				String completionString = p.getName().substring(context.getPrefix().length()) + "::"; //$NON-NLS-1$
				String displayString = p.getName() + "::"; //$NON-NLS-1$
				ICompletionProposal completionProposal = createCompletionProposal(p, completionString, displayString, context);
				List<Type> accessibleType = getRecursivelyOwnedType(p);
				accessibleType.addAll(getRecursivelyImportedType(p));
				if (accessibleType.size() != 0) {
					acceptor.accept(completionProposal);
				}
			}
		}
	}

	/**
	 *
	 * Provides custom completion for the root element in a qualified name
	 *
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.ui.contentassist.AbstractUmlCommonProposalProvider#completeTypeRule_Path(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 *
	 * @param model
	 * @param assignment
	 * @param context
	 * @param acceptor
	 */
	@Override
	public void completeTypeRule_Path(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		Namespace root = getModel();
		if (root == null) {
			return;
		}

		// first accept the root Model
		String completionString = root.getName() + "::"; //$NON-NLS-1$
		String displayString = root.getName() + "::"; //$NON-NLS-1$
		// String displayString = c.getName() ;
		ICompletionProposal completionProposal = createCompletionProposalWithReplacementOfPrefix(root, completionString, displayString, context);
		acceptor.accept(completionProposal);
		// then accepts all packages imported by Model
		List<Package> importedPackages = root.getImportedPackages();
		for (Package p : importedPackages) {
			if (p.getName().startsWith(context.getPrefix())) {
				completionString = p.getName().substring(context.getPrefix().length()) + "::"; //$NON-NLS-1$
				displayString = p.getName() + "::"; //$NON-NLS-1$
				completionProposal = createCompletionProposal(root, completionString, displayString, context);
				List<Type> accessibleType = getRecursivelyOwnedType(p);
				accessibleType.addAll(getRecursivelyImportedType(p));
				if (accessibleType.size() != 0) {
					acceptor.accept(completionProposal);
				}
			}
		}
	}

	/**
	 * Provides custom completion for specifying the type of an {@link Element}, taking into account the path if the name is qualified
	 *
	 * @see org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeTypeRule_Type(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeTypeRule_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {

		Namespace namespace = getContextElement().getNearestPackage();
		if (model instanceof TypeRule) {
			TypeRule typeRule = (TypeRule) model;
			QualifiedName path = typeRule.getPath();
			while (path.getRemaining() != null) {
				path = path.getRemaining();
			}
			namespace = path.getPath();
		}
		for (NamedElement n : namespace.getOwnedMembers()) {
			if (isWantedType(n)) {
				if (n.getName().startsWith(context.getPrefix())) {
					String completionString = n.getName().substring(context.getPrefix().length());
					String displayString = n.getName();
					ICompletionProposal completionProposal = createCompletionProposal(n, completionString, displayString, context);
					acceptor.accept(completionProposal);
				}
			}
			if (n instanceof Namespace) {
				for (Type t : getRecursivelyOwnedType((Namespace) n)) {
					if (t.getName().startsWith(context.getPrefix())) {
						String completionString = t.getName().substring(context.getPrefix().length());
						String displayString = t.getName();
						;
						ICompletionProposal completionProposal = createCompletionProposal(t, completionString, displayString, context);
						acceptor.accept(completionProposal);
					}
				}
			}
		}

	}

	/**
	 * Private Utility method for creating a completion proposal
	 *
	 * @param namedElement
	 *            The named element for which completion proposal must be created
	 * @param completionString
	 *            The actual completion string
	 * @param displayString
	 *            The way the completion is displayed in the completion list
	 * @param context
	 *            Some information related to the context of the completion
	 * @return
	 */
	protected ICompletionProposal createCompletionProposal(NamedElement namedElement, String completionString, String displayString, ContentAssistContext context) {
		String additionalProposalInfo = "" + namedElement.getQualifiedName() + "\n" + '(' + namedElement.eClass().getName() + ')'; //$NON-NLS-1$ //$NON-NLS-2$

		ICompletionProposal completionProposal = new CompletionProposal(completionString, // String to be inserted
				context.getOffset(), // Offset
				context.getSelectedText().length(), // Replacement length
				completionString.length(), // cursorPosition
				labelProvider.getImage(namedElement), // image
				" " + displayString, // displayString //$NON-NLS-1$
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
	protected ICompletionProposal createCompletionProposal(String completionString, String displayString, ContentAssistContext context) {

		ICompletionProposal completionProposal = new CompletionProposal(completionString, // String to be inserted
				context.getOffset(), // Offset
				context.getSelectedText().length(), // Replacement length
				completionString.length(), // cursorPosition
				null, // image
				" " + displayString, // displayString //$NON-NLS-1$
				null, // contextInformation
				null // additionalProposalInfo
		);
		return completionProposal;
	}

	/**
	 *
	 * Private Utility method for creating a completion proposal with replacement of prefix
	 *
	 * @param namedElement
	 *            The named element for which completion proposal must be created
	 * @param completionString
	 *            The actual completion string
	 * @param displayString
	 *            The way the completion is displayed in the completion list
	 * @param context
	 *            Some information related to the context of the completion
	 * @return
	 */
	protected ICompletionProposal createCompletionProposalWithReplacementOfPrefix(NamedElement namedElement, String completionString, String displayString, ContentAssistContext context) {
		String additionalProposalInfo = "" + namedElement.getQualifiedName() + "\n" + '(' + namedElement.eClass().getName() + ')'; //$NON-NLS-1$ //$NON-NLS-2$

		ICompletionProposal completionProposal = new CompletionProposal(completionString, // String to be inserted
				context.getOffset() - context.getPrefix().length(), // Offset
				context.getPrefix().length(), // Replacement length
				completionString.length(), // cursorPosition
				labelProvider.getImage(namedElement), // image
				" " + displayString, // displayString //$NON-NLS-1$
				null, // contextInformation
				additionalProposalInfo // additionalProposalInfo
		);
		return completionProposal;
	}

	/**
	 *
	 * This method shall be overridden in order to look for a more specific {@link Type} Utility methods which returns the list of {@link Type} that
	 * are directly or indirectly owned by the namespaces imported by a context namespace
	 *
	 * @param context
	 *            The context namespace
	 * @return the list of classifiers that are directly or indirectly owned by the namespaces imported by the context namespace
	 */
	protected List<Type> getRecursivelyImportedType(Namespace context) {
		List<Type> recursivelyImportedTypes = new ArrayList<>();

		EList<org.eclipse.uml2.uml.Package> importedPackages = context.getImportedPackages();
		for (Package p : importedPackages) {
			recursivelyImportedTypes.addAll(getRecursivelyOwnedType(p));
		}

		return recursivelyImportedTypes;
	}

	/**
	 * This method shall be overridden in order to look for a more specific {@link Type}
	 *
	 * Utility methods which returns the list of the type that are directly or indirectly owned by a context namespace
	 *
	 * @param context
	 *            The context namespace
	 * @return the list of classifiers that are directly or indirectly owned by the context namespace
	 */
	protected List<Type> getRecursivelyOwnedType(Namespace context) {
		List<Type> recursivelyOwnedTypes = new ArrayList<>();

		List<Element> allOwnedElements = context.getOwnedElements();
		for (Element e : allOwnedElements) {
			if (isWantedType(e)) {
				recursivelyOwnedTypes.add((Type) e);
			}
			if (e instanceof Namespace) {
				recursivelyOwnedTypes.addAll(this.getRecursivelyOwnedType((Namespace) e));
			}
		}

		return recursivelyOwnedTypes;
	}

	/**
	 * Inherited class should overridden this method in order to have a mode specific type
	 *
	 * Tests if the element is an instance of the wanted type
	 *
	 * @param e
	 *            the element to test
	 * @return
	 * 		<code>true</code> is the element is an instance of the wanted type
	 */
	protected boolean isWantedType(Element e) {
		return this.wantedType.isInstance(e);
	}

	/**
	 * This method allows to precise the wanted type of the element (to be more restrictive that {@link Port}
	 *
	 * Setter for {@link #wantedType}
	 *
	 * @param type
	 *            the new type
	 */
	public void setWantedType(Class<?> type) {
		this.wantedType = type;
	}

}
