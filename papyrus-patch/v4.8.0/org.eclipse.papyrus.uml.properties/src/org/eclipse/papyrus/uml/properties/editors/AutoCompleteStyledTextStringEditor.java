/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.editors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalSorter;
import org.eclipse.papyrus.infra.widgets.editors.CompletionStyledTextStringEditor;
import org.eclipse.papyrus.infra.widgets.editors.StyledTextStringEditor;
import org.eclipse.papyrus.infra.widgets.util.INameResolutionHelper;
import org.eclipse.papyrus.infra.widgets.util.PlatformUIUtils;
import org.eclipse.papyrus.infra.widgets.validator.AbstractValidator;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Auto-completion styled text
 * The main difference with {@link CompletionStyledTextStringEditor} is that
 * this editor isn't intended to binded in Papyrus Properties framework
 */
public class AutoCompleteStyledTextStringEditor extends StyledTextStringEditor {

	private static final String CONTENT_ASSIST_COMMAND_ID = "org.eclipse.ui.edit.text.contentAssist.proposals"; //$NON-NLS-1$

	/**
	 * This wrapper provides a text field with completion
	 */
	private TextViewer wrapper;

	protected INameResolutionHelper nameResolutionHelper;

	private ContentAssistant assistant;

	private UMLReferenceContentAssistProcessor processor;

	/**
	 * @return the nameResolutionHelper
	 */
	public INameResolutionHelper getNameResolutionHelper() {
		return nameResolutionHelper;
	}

	/**
	 * Initial value for text
	 *
	 * @param value
	 */
	@Override
	public void setValue(Object value) {
		if (value instanceof NamedElement) {
			super.setValue(((NamedElement) value).getName());
		}
		super.setValue(value);
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 * @param style
	 */
	public AutoCompleteStyledTextStringEditor(Composite parent, int style) {
		super(parent, style);
		createReferenceTargetValidator();
	}

	@Override
	protected void notifyChange() {
		text.notifyListeners(SWT.FocusOut, new Event());

		// added to update the status when we use the completion
		if (targetValidator != null) {
			IStatus status = targetValidator.validate(text.getText());
			updateStatus(status);
		}
		commit();
		changeColorField();
	}

	/**
	 * create the validator for the text field
	 */
	protected void createReferenceTargetValidator() {
		targetValidator = new AbstractValidator() {
			@Override
			public IStatus validate(Object value) {
					return Status.OK_STATUS;
			}
		};
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.StyledTextStringEditor#createStyledText(org.eclipse.swt.widgets.Composite, java.lang.String, int)
	 *
	 * @param parent
	 * @param value
	 * @param style
	 * @return
	 */
	@Override
	public StyledText createStyledText(Composite parent, String value, int style) {
		this.wrapper =  buildControls(parent, style);
		return wrapper.getTextWidget();
	}

	private TextViewer buildControls(Composite parent, int style) {
		TextViewer textViewer = new TextViewer(parent, SWT.SINGLE | SWT.V_SCROLL | style);
		textViewer.setDocument(new Document());
		this.assistant = new ContentAssistant();
		processor = new UMLReferenceContentAssistProcessor(UMLPackage.eINSTANCE.getTypedElement_Type(), (NameResolutionHelper) nameResolutionHelper, this);
		assistant.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);

		// Manage the sorter for the completion proposal
		assistant.setSorter(new ICompletionProposalSorter() {

			@Override
			public int compare(final ICompletionProposal p1, final ICompletionProposal p2) {
				return p1.getDisplayString().compareTo(p2.getDisplayString());
			}
		});

		assistant.install(textViewer);
		assistant.addCompletionListener(new ICompletionListener() {

			private boolean delayedIsOpen = false;

			@Override
			public void selectionChanged(ICompletionProposal proposal, boolean smartToggle) {

			}

			@Override
			public void assistSessionStarted(ContentAssistEvent event) {
				// reset open status asynchronously.
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						delayedIsOpen = true;
					}
				});
			}

			@Override
			public void assistSessionEnded(ContentAssistEvent event) {
				// reset open status asynchronously.
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						delayedIsOpen = false;
					}
				});

			}
		});

		// Hook up the user's preferred key binding for content assist
		PlatformUIUtils.handleCommand(textViewer.getControl(), CONTENT_ASSIST_COMMAND_ID,
				"CTRL+SPACE", //$NON-NLS-1$ // The default on all platforms
				assistant::showPossibleCompletions);
		return textViewer;
	}

	public void setNameResolutionHelper(INameResolutionHelper nameResolutionHelper) {
		this.nameResolutionHelper = nameResolutionHelper;
		if (nameResolutionHelper instanceof NameResolutionHelper) {
			processor.setNameResolutionHelper((NameResolutionHelper) nameResolutionHelper);		
		}
	}

	@Override
	public Object getContextElement() {
		return super.getContextElement(); // we need a public api
	}

}
