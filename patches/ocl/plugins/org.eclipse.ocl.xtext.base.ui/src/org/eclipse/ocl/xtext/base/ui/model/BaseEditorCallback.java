/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http:www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation based on org.eclipse.xtext.builder.nature.NatureAddingEditorCallback
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.model;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ocl.xtext.base.ui.BaseEditor;
import org.eclipse.ocl.xtext.base.ui.BaseUIActivator;
import org.eclipse.ocl.xtext.base.ui.builder.MultiValidationJob;
import org.eclipse.ocl.xtext.base.ui.builder.ValidationEntry;
import org.eclipse.ocl.xtext.base.ui.commands.ToggleNatureCommand;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
//import org.eclipse.xtext.ui.editor.validation.ValidatingEditorCallback;
import org.eclipse.xtext.ui.util.DontAskAgainDialogs;

import com.google.inject.Inject;

/**
 * The BaseEditorCallback should be registered so that it is executed as pretty mucj the last activity in XtextEditor.createPartControl().
 */
public class BaseEditorCallback extends IXtextEditorCallback.NullImpl
{
	@Inject
	private ToggleNatureCommand toggleNature;

	@Inject
	private DontAskAgainDialogs dialogs;

	private @Inject IDialogSettings dialogSettings;

	@Override
	public void afterCreatePartControl(XtextEditor editor) {
		super.afterCreatePartControl(editor);
		//
		//	Kick off a ValidationJob to provide the start-up Annotations
		//
		IDocumentProvider documentProvider = editor.getDocumentProvider();
		if (documentProvider instanceof BaseDocumentProvider) {
			IDocument document = ((BaseDocumentProvider)documentProvider).getDocument(editor.getEditorInput());
			if (document instanceof XtextDocument) {
				Job validationJob = ((XtextDocument)document).getValidationJob();
				if (validationJob != null) {
					validationJob.schedule(250);
				}
			}
		}
		//
		//	See if a nature could be activated.
		//
		IResource resource = editor.getResource();
		if (resource != null) {
			IProject project = resource.getProject();
			if (project != null && !toggleNature.hasNature(project) && project.isAccessible() && !project.isHidden()) {
				boolean addNature = false;
				String addNatureKey = toggleNature.getAddNatureKey();
				if (MessageDialogWithToggle.PROMPT.equals(dialogs.getUserDecision(addNatureKey))) {
					String testNameSuffix = System.getProperty("testNameSuffix", null);
					if (testNameSuffix != null) {
						throw new UnsupportedOperationException("Asking for a nature is not supported by testing");
					}
					String title = toggleNature.getAddNatureDialogTitle();
					String message = toggleNature.getAddNatureDialogText(project.getName());
					int userAnswer = dialogs.askUser(message, title, addNatureKey, editor.getEditorSite().getShell());
					if (userAnswer == IDialogConstants.YES_ID) {
						addNature = true;
					} else if (userAnswer == IDialogConstants.CANCEL_ID) {
						return;
					}
				} else if (MessageDialogWithToggle.ALWAYS.equals(dialogs.getUserDecision(addNatureKey))) {
					addNature = true;
				}
				if (addNature) {
					toggleNature.toggleNature(project);
				}
			}
		}
	}

	@Override
	public void afterSave(XtextEditor editor) {
		super.afterSave(editor);
		IResource resource = editor.getResource();
		if (resource != null) {
			IProject project = resource.getProject();
			if (project != null && !toggleNature.hasNature(project) && project.isAccessible() && !project.isHidden()) {
				MultiValidationJob multiValidationJob = BaseUIActivator.getMultiValidationJob();
				if (multiValidationJob != null) {
					IEditorInput editorInput = editor.getEditorInput();
					if (editorInput instanceof IFileEditorInput) {
						IFile file = ((IFileEditorInput)editorInput).getFile();
						if (file != null) {
							ValidationEntry validationEntry = new ValidationEntry(file, ((BaseEditor)editor).getMarkerId());
							multiValidationJob.addValidations(Collections.singletonList(validationEntry));
						}
					}
				}
			}
		}
	}

	/**
	 * Suppress the "Add Nature" dialog, typically just to allow tests to proceed unhindered.
	 */
	public void setDontAskForNatureAgain() {
		IDialogSettings section = dialogSettings.getSection(DontAskAgainDialogs.DONT_ASK_AGAIN_DIALOG_PREFIX);
		if (section == null) {
			section = dialogSettings.addNewSection(DontAskAgainDialogs.DONT_ASK_AGAIN_DIALOG_PREFIX);
		}
		section.put(toggleNature.getAddNatureKey(), MessageDialogWithToggle.NEVER);
	}
}