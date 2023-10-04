/*****************************************************************************
 * Copyright (c) 2011,2012 CEA LIST and others
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
 *  E.D.Willink - Initial API and implementation
 *  CEA LIST - Architecture refactoring
 *  E.D.Willink - Bug 388529
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.constraintwithessentialocl.xtext;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.ui.OCLUI;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.papyrus.infra.services.validation.commands.AbstractValidateCommand;
import org.eclipse.papyrus.infra.services.validation.commands.AsyncValidateSubtreeCommand;
import org.eclipse.papyrus.infra.ui.emf.dialog.NestedEditingDialogContext;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProviderWithInit;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;
import com.google.inject.Injector;


/**
 * this plugin is the configuration of the essential editor
 *
 */
public class EssentialOCLEditorConfiguration extends DefaultXtextDirectEditorConfiguration {
	// org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration {

	@Inject
	protected XtextResource fakeResource;

	/**
	 * Clients may override to change style to {@link SWT}.MULTI
	 */
	@Override
	public int getStyle() {
		return SWT.MULTI | SWT.WRAP;
	}

	@Override
	public Object preEditAction(Object editedObject) {
		if (editedObject instanceof Constraint) {
			Constraint constraint = (Constraint) editedObject;
			if (!(constraint.getSpecification() instanceof OpaqueExpression)) {
				String stringValue = constraint.getSpecification().stringValue();
				if ((stringValue != null) && (stringValue.length() > 0)) {
					MessageDialog.openWarning(new Shell(),
							Messages.EssentialOCLEditorConfiguration_ExistingSpecification,
							Messages.EssentialOCLEditorConfiguration_AlreadyContainsNonEmpty);
				}
			}
		}
		return super.preEditAction(editedObject);
	}

	/**
	 * the command to save the content of the OCL constraint into the body of the UML constraint element
	 *
	 */
	protected class UpdateConstraintCommand extends AbstractTransactionalCommand {

		protected final Constraint constraint;

		protected final String newTextualRepresentation;

		public UpdateConstraintCommand(TransactionalEditingDomain editingDomain, Constraint constraint, String newTextualRepresentation) {
			super(editingDomain, "Constraint Update", getWorkspaceFiles(constraint)); //$NON-NLS-1$
			this.constraint = constraint;
			this.newTextualRepresentation = newTextualRepresentation;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
			org.eclipse.uml2.uml.OpaqueExpression opaqueExpression = null;
			int indexOfOCLBody = -1;
			if (constraint.getSpecification() == null || !(constraint.getSpecification() instanceof org.eclipse.uml2.uml.OpaqueExpression)) {
				opaqueExpression = UMLFactory.eINSTANCE.createOpaqueExpression();
			} else {
				opaqueExpression = (org.eclipse.uml2.uml.OpaqueExpression) constraint.getSpecification();
				for (int i = 0; i < opaqueExpression.getLanguages().size() && indexOfOCLBody == -1; i++) {
					if (opaqueExpression.getLanguages().get(i).equals(PivotConstants.OCL_LANGUAGE)) {
						indexOfOCLBody = i;
					}
				}
			}
			if (indexOfOCLBody == -1) {
				opaqueExpression.getLanguages().add(PivotConstants.OCL_LANGUAGE);
				opaqueExpression.getBodies().add(newTextualRepresentation);
			} else {
				opaqueExpression.getBodies().set(indexOfOCLBody, newTextualRepresentation);
			}
			constraint.setSpecification(opaqueExpression);

			return CommandResult.newOKCommandResult(constraint);
		}
	}

	/**
	 * the command to save the content of an opaque expression
	 *
	 */
	protected class UpdateOpaqueExpressionCommand extends AbstractTransactionalCommand {

		protected final OpaqueExpression opaqueExpression;

		protected final String newTextualRepresentation;

		public UpdateOpaqueExpressionCommand(TransactionalEditingDomain editingDomain, OpaqueExpression expression, String newTextualRepresentation) {
			super(editingDomain, "Opaque expression update", getWorkspaceFiles(expression)); //$NON-NLS-1$
			this.opaqueExpression = expression;
			this.newTextualRepresentation = newTextualRepresentation;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
			int indexOfOCLBody = -1;
			for (int i = 0; i < opaqueExpression.getLanguages().size() && indexOfOCLBody == -1; i++) {
				if (opaqueExpression.getLanguages().get(i).equals(PivotConstants.OCL_LANGUAGE)) {
					indexOfOCLBody = i;
				}
			}
			if (indexOfOCLBody == -1) {
				opaqueExpression.getLanguages().add(PivotConstants.OCL_LANGUAGE);
				opaqueExpression.getBodies().add(newTextualRepresentation);
			} else if (indexOfOCLBody < opaqueExpression.getBodies().size()) { // might not be true, if body list is not synchronized with language list
				opaqueExpression.getBodies().set(indexOfOCLBody, newTextualRepresentation);
			} else {
				opaqueExpression.getBodies().add(newTextualRepresentation);
			}
			return CommandResult.newOKCommandResult(opaqueExpression);
		}
	}

	@Override
	public String getTextToEdit(Object editedObject) {
		String value = ""; //$NON-NLS-1$
		ValueSpecification specification = null;
		if (objectToEdit instanceof Constraint) {
			specification = ((Constraint) objectToEdit).getSpecification();
		}
		else if (objectToEdit instanceof ValueSpecification) {
			specification = (ValueSpecification) objectToEdit;
		}
		if (specification != null) {
			if (specification instanceof LiteralString) {
				if (((LiteralString) specification).getValue() != null) {
					value += ((LiteralString) specification).getValue();
				}
			} else if (specification instanceof org.eclipse.uml2.uml.OpaqueExpression) {
				int indexOfOCLBody = -1;
				org.eclipse.uml2.uml.OpaqueExpression opaqueExpression = (org.eclipse.uml2.uml.OpaqueExpression) specification;
				for (int i = 0; i < opaqueExpression.getLanguages().size() && indexOfOCLBody == -1; i++) {
					if (opaqueExpression.getLanguages().get(i).equals(PivotConstants.OCL_LANGUAGE)) {
						if (i < opaqueExpression.getBodies().size()) {
							value += opaqueExpression.getBodies().get(i);
						}
						indexOfOCLBody = i;
					}
				}
			}
		}
		return value;
	}

	@Override
	public IContextElementProvider getContextProvider() {
		return new IContextElementProviderWithInit() {

			public EObject getContextObject() {
				if (objectToEdit instanceof Constraint) {
					return ((Constraint) objectToEdit).getContext();
				}
				else if (objectToEdit instanceof OpaqueExpression) {
					Element owner = ((OpaqueExpression) objectToEdit).getOwner();
					if (owner instanceof Constraint) {
						return ((Constraint) owner).getContext();
					}
				}
				return null;
			}

			public EObject getEditObject() {
				if (objectToEdit instanceof EObject) {
					return (EObject)objectToEdit;
				}
				return null;
			}
				
			public void initResource(XtextResource resource) {
				try {
					PivotUtil.setParserContext((CSResource)resource, getEditObject());
				} catch (Exception e) {
				}
			}
		};
	}

	@Override
	public Injector getInjector() {
		return UMLConstraintEditorActivator.getInstance().getInjector(OCLUI.ESSENTIAL_OCL_LANGUAGE_ID);
	}

	@Override
	public IParser createParser(final EObject semanticObject) {
		if (objectToEdit == null) {
			objectToEdit = semanticObject;
		}
		final IParser defaultParser = super.createParser(semanticObject);
		// use a semantic parser to assure refresh after opaque expression changes, see bug 400077
		return new ISemanticParser() {

			public String getEditString(IAdaptable element, int flags) {
				return defaultParser.getEditString(element, flags);
			}

			public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
				// the superclass creates a comment, if validation fails. This is not useful in case of OCL,
				// since the OCL expression is already stored in opaque form within the constraint.
				CompositeCommand result = new CompositeCommand("validation"); //$NON-NLS-1$
				TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(semanticObject);
				boolean doValidation = editingDomain != null;
				if (editingDomain == null) {
					// can be null for opaque expression that have been created but have not been added to parent
					// try to get resource set from nested dialog context
					ResourceSet rs = NestedEditingDialogContext.getInstance().getResourceSet();
					editingDomain = TransactionUtil.getEditingDomain(rs);

				}
				if (semanticObject instanceof Constraint) {
					result.add(new UpdateConstraintCommand(editingDomain, (Constraint) semanticObject, newString));
				}
				else if (semanticObject instanceof OpaqueExpression) {
					result.add(new UpdateOpaqueExpressionCommand(editingDomain, (OpaqueExpression) semanticObject, newString));
				}
				if (doValidation) {
					final AbstractValidateCommand validationCommand = new AsyncValidateSubtreeCommand(semanticObject);
					validationCommand.disableUIFeedback();
					result.add(validationCommand);
				}
				return result;
			}

			public String getPrintString(IAdaptable element, int flags) {
				return defaultParser.getPrintString(element, flags);
			}

			public boolean isAffectingEvent(Object event, int flags) {
				return false;
			}

			public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
				// Not used
				return null;
			}

			public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
				// Not used
				return null;
			}

			public List<EObject> getSemanticElementsBeingParsed(EObject element) {
				// Add specification to list.
				List<EObject> list = new BasicEList<EObject>();
				if (element instanceof Constraint) {
					list.add(((Constraint) element).getSpecification());
				}
				return list;
			}

			public boolean areSemanticElementsAffected(EObject listener,
					Object notification) {
				// always return true to assure refresh of semantic listeners
				return true;
			}
		};
	}

	@Override
	protected ICommand getParseCommand(EObject umlObject, EObject xtextObject) {
		// this operation is never called, since the parser above will not call it.
		return UnexecutableCommand.INSTANCE;
	}
}
