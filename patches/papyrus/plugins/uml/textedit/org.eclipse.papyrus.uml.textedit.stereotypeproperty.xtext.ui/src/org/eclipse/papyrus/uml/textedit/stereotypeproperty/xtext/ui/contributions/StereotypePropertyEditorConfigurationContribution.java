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
 *  Jeremie Tatibouet (CEA LIST)
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.contributions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.AppliedStereotypePropertyEditorUtil;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.StringConstants;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyRule;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.internal.AppliedStereotypePropertyActivator;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.papyrus.uml.xtext.integration.XtextFakeResourceContext;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProviderWithInit;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Injector;

public class StereotypePropertyEditorConfigurationContribution extends DefaultXtextDirectEditorConfiguration {

	public static AppliedStereotypeProperty getAppliedStereoProperty() {
		return statocAppliedStereotypeProperty;
	}

	protected static AppliedStereotypeProperty statocAppliedStereotypeProperty;

	@Override
	public Object preEditAction(Object objectToEdit) {
		if (objectToEdit instanceof AppliedStereotypeProperty) {
			statocAppliedStereotypeProperty = (AppliedStereotypeProperty) objectToEdit;
		}

		return super.preEditAction(objectToEdit);
	}

	@Override
	public Injector getInjector() {
		return AppliedStereotypePropertyActivator
				.getInstance()
				.getInjector(
						AppliedStereotypePropertyActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_STEREOTYPEPROPERTY_XTEXT_APPLIEDSTEREOTYPEPROPERTY);
	}

	@Override
	protected ICommand getParseCommand(EObject umlObject, EObject xtextObject) {
		umlObject = (EObject) objectToEdit; // replace with objectToEdit (umlObject is selected property, not stereotype application)
		CompositeCommand command = new CompositeCommand(""); //$NON-NLS-1$
		final AppliedStereotypeProperty appliedStereotypeProperty = (AppliedStereotypeProperty) umlObject;
		Type type = appliedStereotypeProperty.getStereotypeProperty().getType();

		ICommand specificCommand = null;
		// int
		if (type.getName().equals(StringConstants.INTEGER)
				|| type.getName().equals(StringConstants.BOOLEAN)
				|| type.getName().equals(StringConstants.STRING)) {
			specificCommand = this.reconcilePrimitiveType(appliedStereotypeProperty, xtextObject);
		}
		// ref element stereotype application
		else if (type.eClass().getName().equals("Stereotype")) { //$NON-NLS-1$
			specificCommand = reconcileRefToStereotypeApp(appliedStereotypeProperty, xtextObject);
		}
		else if (type instanceof Enumeration) {
			specificCommand = reconcileEnumerationLiteral(appliedStereotypeProperty, xtextObject);
		}
		// ref element
		else if (type instanceof Element) {
			specificCommand = reconcileRefToElement(appliedStereotypeProperty, xtextObject);
		}
		if (specificCommand != null) {
			command.add(specificCommand);
		}
		return command;
	}

	/**
	 * Provide the list of all enumeration literal available from the enumeration
	 * 
	 * @param enumeration
	 *            the enumeration from which the list of candidates is computed
	 * 
	 * @return tmp
	 *         the list of all available enumeration literal
	 */
	private List<NamedElement> getEnumerationCandidates(Enumeration enumeration) {
		List<NamedElement> tmp = new ArrayList<NamedElement>(enumeration.getMembers());
		tmp.removeAll(enumeration.getImportedMembers());
		return tmp;
	}

	/**
	 * this method is used to reconcile Enumeration literal with application of
	 * the stereotype
	 *
	 * @param appliedStereotypeProperty
	 *            the application of stereotype
	 * @param xtextObject
	 *            the AST of the grammar
	 */
	protected ICommand reconcileEnumerationLiteral(final AppliedStereotypeProperty appliedStereotypeProperty, EObject model) {
		Property property = appliedStereotypeProperty.getStereotypeProperty();
		List<NamedElement> candidates = this.getEnumerationCandidates((Enumeration) property.getType());
		Expression expression = this.getValueSpecificationExpression(model);
		List<EnumerationLiteral> results = AppliedStereotypePropertyEditorUtil.resolveEnumerationLiteralValue(expression, candidates);
		// cardinality 1
		if (property.getUpper() == 1) {
			if (!results.isEmpty()) {
				return createUpdateCommand(appliedStereotypeProperty, results.get(0));
			}
			return createUpdateCommand(appliedStereotypeProperty, null);
		}
		// cardinality *
		else {
			if (results.isEmpty()) {
				return createUpdateCommand(appliedStereotypeProperty, new ArrayList<Object>());
			}
			return createUpdateCommand(appliedStereotypeProperty, results);
		}
	}

	/**
	 * this method is used to reconcile references to Stereotype Application
	 * with the current application of the stereotype
	 *
	 * @param appliedStereotypeProperty
	 *            the application of stereotype
	 * @param xtextObject
	 *            the AST of the grammar
	 * @param possibleElement
	 *            list of possible elements that can be used
	 */
	protected ICommand reconcileRefToStereotypeApp(final AppliedStereotypeProperty appliedStereotypeProperty, EObject model) {
		/* 1. Initialization */
		Property property = appliedStereotypeProperty.getStereotypeProperty();
		Expression expression = this.getValueSpecificationExpression(model);
		Element scope = appliedStereotypeProperty.getBaseElement();
		/* 2. Reference resolution */
		List<NamedElement> references = AppliedStereotypePropertyEditorUtil.resolveReferenceValue(expression, scope);
		List<EObject> stereotypeApplications = this.getStereotypeApplication(references, (Stereotype) property.getType());
		/* 3. Assignment of the resolved element(s) */
		if (property.getUpper() == 1) {// cardinality 1
			if (!stereotypeApplications.isEmpty()) {
				return createUpdateCommand(appliedStereotypeProperty, stereotypeApplications.get(0));
			}
			return createUpdateCommand(appliedStereotypeProperty, null);
		}
		else { // cardinality *
			return createUpdateCommand(appliedStereotypeProperty, stereotypeApplications);
		}
	}

	/**
	 * Provides the list of stereotype applications found for the elements in <code>references</code>
	 * 
	 * @param references
	 *            the list of references on which the <code>stereotype</code> should be applied
	 * 
	 * @param stereotype
	 *            the stereotype used in the applications
	 * 
	 * @return stereotypeApplications
	 *         the list of stereotype applications
	 */
	private List<EObject> getStereotypeApplication(List<NamedElement> references, Stereotype stereotype) {
		List<EObject> stereotypeApplications = new ArrayList<EObject>();
		for (NamedElement element : references) {
			if (element.isStereotypeApplied(stereotype)) {
				stereotypeApplications.add(element.getStereotypeApplication(stereotype));
			}
		}
		return stereotypeApplications;
	}

	/**
	 * Extract from the model of a stereotype property assignment the expression corresponding
	 * to the assigned value
	 * 
	 * @param model
	 *            the model from which the value specification extracted
	 * @return valueSpecification
	 *         the expression used as the value specification for a property
	 */
	private Expression getValueSpecificationExpression(EObject model) {
		Expression valueSpecification = null;
		if (model instanceof AppliedStereotypePropertyRule) {
			if (((AppliedStereotypePropertyRule) model).getValue() != null) {
				valueSpecification = ((AppliedStereotypePropertyRule) model).getValue().getExpression();
			}
		}
		return valueSpecification;
	}

	/**
	 * Reconcile the expression specified in the <code>model</code> onto a primitive element (e.g. a boolean)
	 * 
	 * @param appliedStereotypeProperty
	 *            the application of stereotype
	 * 
	 * @param model
	 *            the model on which we try to resolve
	 * 
	 * @return The update command
	 */
	protected ICommand reconcilePrimitiveType(final AppliedStereotypeProperty appliedStereotypeProperty, EObject model) {
		Expression valueSpecification = this.getValueSpecificationExpression(model);
		if (valueSpecification != null) {
			List<Object> values = AppliedStereotypePropertyEditorUtil.resolvePrimitiveValue(valueSpecification);
			// cardinality 1
			if (appliedStereotypeProperty.getStereotypeProperty().getUpper() == 1) {
				if (values.isEmpty()) {
					return createUpdateCommand(appliedStereotypeProperty, null);
				} else {
					return createUpdateCommand(appliedStereotypeProperty, values.get(0));
				}
			}
			// cardinality *
			else {
				return createUpdateCommand(appliedStereotypeProperty, values);
			}
		}
		return null;
	}


	/**
	 * this method is used to reconcile references element with the current
	 * application of the stereotype
	 *
	 * @param appliedStereotypeProperty
	 *            the application of stereotype
	 * @param xtextObject
	 *            the AST of the grammar
	 * @param possibleElement
	 *            list of possible elements that can be used
	 */
	protected ICommand reconcileRefToElement(final AppliedStereotypeProperty appliedStereotypeProperty, EObject model) {
		/* 1. Initialization */
		Expression valueSpecification = this.getValueSpecificationExpression(model);
		Element scope = appliedStereotypeProperty.getBaseElement();
		/* 2. Perform the resolution */
		List<NamedElement> references = AppliedStereotypePropertyEditorUtil.resolveReferenceValue(valueSpecification, scope);
		/* 3. Generate the comment corresponding to the assignment */
		if (appliedStereotypeProperty.getStereotypeProperty().getUpper() == 1) {// cardinality 1
			if (!references.isEmpty()) {
				return createUpdateCommand(appliedStereotypeProperty, references.get(0));
			}
			return createUpdateCommand(appliedStereotypeProperty, null);
		}
		else {// cardinality *
			return createUpdateCommand(appliedStereotypeProperty, references);
		}
	}

	/**
	 * Create the command required to update the given stereotype property with the given value
	 * 
	 * @param appliedStereotypeProperty
	 *            The stereotype property that need to be assigned
	 * 
	 * @param value
	 *            The value that will be used as assignment right hand side
	 * 
	 * @return setValueCommand
	 *         The update command
	 */
	protected ICommand createUpdateCommand(final AppliedStereotypeProperty appliedStereotypeProperty, final Object value) {
		AbstractTransactionalCommand setValueCommand = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(appliedStereotypeProperty.getStereotypeProperty()), "", Collections.EMPTY_LIST) { //$NON-NLS-1$
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				appliedStereotypeProperty.getBaseElement().setValue(appliedStereotypeProperty.getStereotype(),
						appliedStereotypeProperty.getStereotypeProperty().getName(), value);
				return CommandResult.newOKCommandResult();

			}
		};
		return setValueCommand;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration
	 * #getTextToEdit(java.lang.Object)
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if (editedObject instanceof AppliedStereotypeProperty) {
			return AppliedStereotypePropertyEditorUtil.getLabel((AppliedStereotypeProperty) editedObject).trim();
			// TODO: default values not supported by the grammar
			// TODO: either complete the grammar, or use another label provider
		}
		return "<UNDEFINED>"; //$NON-NLS-1$
	}

	@Override
	public IParser createParser(final EObject semanticObject) {

		return new IParser() {

			@Override
			public String getEditString(IAdaptable element, int flags) {
				return getTextToEdit(objectToEdit);
			}

			@Override
			public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
				CompositeCommand result = new CompositeCommand("validation"); //$NON-NLS-1$
				IContextElementProvider provider = getContextProvider();

				XtextFakeResourceContext context = new XtextFakeResourceContext(getInjector());
				context.getFakeResource().eAdapters().add(new ContextElementAdapter(provider));
				try {
					context.getFakeResource().load(new StringInputStream(newString), Collections.EMPTY_MAP);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (provider instanceof IContextElementProviderWithInit) {
					((IContextElementProviderWithInit) provider).initResource(context.getFakeResource());
				}
				EcoreUtil2.resolveLazyCrossReferences(context.getFakeResource(), CancelIndicator.NullImpl);
				if (!context.getFakeResource().getParseResult().hasSyntaxErrors() && context.getFakeResource().getErrors().size() == 0) {
					EObject xtextObject = context.getFakeResource().getParseResult().getRootASTElement();
					result.add(StereotypePropertyEditorConfigurationContribution.this.getParseCommand(semanticObject, xtextObject));
				} else {
					result.add(createInvalidStringCommand(newString, semanticObject));
				}
				// ValidateSubtreeCommand validationCommand = new ValidateSubtreeCommand(semanticObject);
				// validationCommand.disableUIFeedback();
				// result.add(validationCommand);
				return result;
			}

			@Override
			public String getPrintString(IAdaptable element, int flags) {
				return getTextToEdit(objectToEdit);
			}

			@Override
			public boolean isAffectingEvent(Object event, int flags) {
				return false;
			}

			@Override
			public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
				// Not used
				return null;
			}

			@Override
			public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
				// Not used
				return null;
			}
		};
	}
}
