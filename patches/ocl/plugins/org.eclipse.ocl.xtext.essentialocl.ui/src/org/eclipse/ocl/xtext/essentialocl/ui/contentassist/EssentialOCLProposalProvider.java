/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.ui.contentassist;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.Pivotable;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.essentialocl.attributes.NavigationUtil;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class EssentialOCLProposalProvider extends AbstractEssentialOCLProposalProvider
{
	private static final int BOOST_EXPLICIT_PROPERTY = 20;
	private static final int BOOST_PARAMETER = 20;
	private static final int BOOST_VARIABLE = 20;
	private static final int BOOST_IMPLICIT_PROPERTY = 15;
	private static final int BOOST_OPERATION = 10;
	private static final int BOOST_ITERATION = 5;
	private static final int BOOST_TYPE = 0;
	private static final int BOOST_PACKAGE = -5;

	public class ClassSensitiveProposalCreator extends DefaultProposalCreator
	{
		public ClassSensitiveProposalCreator(ContentAssistContext contentAssistContext, String ruleName, IQualifiedNameConverter qualifiedNameConverter) {
			super(contentAssistContext, ruleName, qualifiedNameConverter);
		}

		@Override
		public ICompletionProposal apply(IEObjectDescription candidate) {
			ICompletionProposal proposal = super.apply(candidate);
			EObject eObject = candidate.getEObjectOrProxy();
			if ((proposal instanceof ConfigurableCompletionProposal) && (eObject != null) && !eObject.eIsProxy()) {
				ConfigurableCompletionProposal configurableCompletionProposal = (ConfigurableCompletionProposal)proposal;
				int priority = configurableCompletionProposal.getPriority() + getPriorityBoost(eObject);
				configurableCompletionProposal.setPriority(priority);
			}
			return proposal;
		}

	}

	protected static Image collectionTypeImage = null;
	private static Image primitiveTypeImage = null;

	@Override
	public void complete_CollectionTypeIdentifier(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (collectionTypeImage == null) {
			collectionTypeImage = getImage(PivotFactory.eINSTANCE.createCollectionType());
		}
		proposeKeywordAlternatives(ruleCall, context, acceptor, collectionTypeImage);
		super.complete_CollectionTypeIdentifier(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_UnaryOperatorName(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		proposeKeywordAlternatives(ruleCall, context, acceptor, null);
		super.complete_UnaryOperatorName(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_BinaryOperatorName(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		proposeKeywordAlternatives(ruleCall, context, acceptor, null);
		super.complete_BinaryOperatorName(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_NavigationOperatorName(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		proposeKeywordAlternatives(ruleCall, context, acceptor, null);
		super.complete_NavigationOperatorName(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_PrimitiveTypeIdentifier(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		proposeKeywordAlternatives(ruleCall, context, acceptor, getPrimitiveTypeImage());
	}

	@Override
	public void createProposals(ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		EObject currentModel = context.getCurrentModel();
		if ((currentModel instanceof Pivotable) && ((Pivotable)currentModel).getPivot() == null) {
			Resource eResource = currentModel.eResource();
			@NonNull List<Diagnostic> errors = eResource.getErrors();
			@SuppressWarnings("unused") int errorsSize = errors.size();
			if ((eResource instanceof BaseCSResource) && ElementUtil.hasSyntaxError(errors)) {
				//
				//	If we skipped the semantic analysis because of syntax errors, take a shot at it now
				//	so that there is some semantic content from which to derive completion proposals.
				//
				BaseCSResource csResource = (BaseCSResource) eResource;
				try {
					ListBasedDiagnosticConsumer diagnosticsConsumer = new ListBasedDiagnosticConsumer();
					csResource.update(diagnosticsConsumer);
				}
				catch (Exception exception) {
					/* Never let an Exception leak out to abort Xtext */
					exception.getClass();					// Just a debug breakpoint opportunity.
				}
				//				assert errorsSize == errors.size();
			}
			//			System.out.println("createProposals: for " + context.getPreviousModel().eClass().getName() + "  then " + currentModel.eClass().getName() + " with \"" + context.getPrefix() + "\"");
		}
		super.createProposals(context, acceptor);
	}

	protected EObject getPathScope(EObject model, ContentAssistContext context) {
		int offset = context.getOffset();
		INode currentNode = context.getCurrentNode();
		if (currentNode != null) {
			INode offsetNode = NodeModelUtils.findLeafNodeAtOffset(currentNode, offset);
			EObject eObject = NodeModelUtils.findActualSemanticObjectFor(offsetNode);
			if (!(eObject instanceof PathElementCS)) {
				offsetNode = NodeModelUtils.findLeafNodeAtOffset(currentNode, offset-1);
				eObject = NodeModelUtils.findActualSemanticObjectFor(offsetNode);
			}
			if (eObject instanceof PathElementCS) {
				model = eObject;
			}
		}
		return model;
	}

	protected Image getPrimitiveTypeImage() {
		if (primitiveTypeImage == null) {
			primitiveTypeImage = getImage(PivotFactory.eINSTANCE.createPrimitiveType());
		}
		return primitiveTypeImage;
	}

	/**
	 * Return a priority boost to prioritize eObject with respect to alternative proposals.
	 * <br>
	 * The return value should be small to avoid disrupting the default 100 spacing with double and three-quartering for prefix matches.
	 */
	protected int getPriorityBoost(@Nullable EObject eObject) {
		if (eObject instanceof Property) {
			return ((Property)eObject).isIsImplicit() ? BOOST_IMPLICIT_PROPERTY : BOOST_EXPLICIT_PROPERTY;
		}
		else if (eObject instanceof Iteration) {
			return BOOST_ITERATION;
		}
		else if (eObject instanceof Operation) {
			return BOOST_OPERATION;
		}
		else if (eObject instanceof Type) {
			return BOOST_TYPE;
		}
		else if (eObject instanceof Parameter) {
			return BOOST_PARAMETER;
		}
		else if (eObject instanceof Variable) {
			return BOOST_VARIABLE;
		}
		else if (eObject instanceof org.eclipse.ocl.pivot.Package) {
			return BOOST_PACKAGE;
		}
		else {
			return 0;
		}
	}

	@Override
	protected Function<IEObjectDescription, ICompletionProposal> getProposalFactory(String ruleName, ContentAssistContext contentAssistContext) {
		return new ClassSensitiveProposalCreator(contentAssistContext, ruleName, getQualifiedNameConverter());
	}

	/*	@Override
	protected void invokeMethod(String methodName, ICompletionProposalAcceptor acceptor, Object... params) {
		System.out.println("  invokeMethod: " + methodName);
		super.invokeMethod(methodName, acceptor, params);
	} */

	@Override
	protected void lookupCrossReference(CrossReference crossReference,
			EReference reference, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor,
			Predicate<IEObjectDescription> filter) {
		EObject currentModel = contentAssistContext.getCurrentModel();
		if (currentModel instanceof InfixExpCS) {
			EObject previousModel = contentAssistContext.getPreviousModel();
			if (NavigationUtil.isNavigationInfixExp(previousModel)) {
				ExpCS argument = ((InfixExpCS)previousModel).getArgument();
				if (argument != null) {
					currentModel = argument;
				}
			}
		}
		else if (currentModel instanceof PathNameCS) {
			currentModel = getPathScope(currentModel, contentAssistContext);
		}
		String ruleName = null;
		if (crossReference.getTerminal() instanceof RuleCall) {
			ruleName = ((RuleCall) crossReference.getTerminal()).getRule().getName();
		}
		lookupCrossReference(currentModel, reference, acceptor, filter,
			getProposalFactory(ruleName, contentAssistContext));
	}

	@Override
	protected void lookupCrossReference(EObject model, EReference reference,
			ICompletionProposalAcceptor acceptor,
			Predicate<IEObjectDescription> filter,
			Function<IEObjectDescription, ICompletionProposal> proposalFactory) {
		//		System.out.println("    lookupCrossReference: " + reference.getEContainingClass().getName() + "::" + reference.getName());
		super.lookupCrossReference(model, reference, acceptor, filter, proposalFactory);
	}

	protected void proposeKeywordAlternatives(RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor, Image image) {
		AbstractElement alternatives = ruleCall.getRule().getAlternatives();
		if (alternatives instanceof Alternatives) {
			for (AbstractElement alternative : ((Alternatives)alternatives).getElements()) {
				if (alternative instanceof Keyword) {
					Keyword keyword = (Keyword)alternative;
					String name = keyword.getValue();
					acceptor.accept(createCompletionProposal(name, name, image, context));
				}
			}
		}
		else if (alternatives instanceof RuleCall) {
			proposeKeywordAlternatives((RuleCall)alternatives, context, acceptor, image);
		}
	}
}
