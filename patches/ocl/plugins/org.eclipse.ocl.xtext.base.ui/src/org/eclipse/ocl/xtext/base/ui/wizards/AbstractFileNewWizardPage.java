/*******************************************************************************
 * Copyright (c) 2013, 2020 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.ocl.xtext.base.ui.BaseUiPluginHelper;
import org.eclipse.ocl.xtext.base.ui.messages.BaseUIMessages;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.ide.undo.CreateFileOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;

/**
 * Wizard page allowing creation of OCL rule files in the workspace.
 */
public class AbstractFileNewWizardPage extends WizardPage implements Listener
{
	protected final @NonNull AbstractFileNewWizard wizard;
	protected final @Nullable IResource initialSelection;

	// cache of newly-created file
	private IFile newFile;

	private AbstractFileDialog dialog;

	/**
	 * Creates a new complete OCL file creation wizard page. If the initial
	 * resource selection contains exactly one container resource then it will
	 * be used as the default container resource.
	 */
	public AbstractFileNewWizardPage(@NonNull AbstractFileNewWizard wizard, @Nullable IResource initialSelection) {
		super(BaseUIMessages.NewWizardPage_pageName);
		this.wizard = wizard;
		this.initialSelection = initialSelection;
		setPageComplete(false);
		setTitle(wizard.getPageSummary());
		setDescription(wizard.getPageDescription());
	}

	/**
	 * (non-Javadoc) Method declared on IDialogPage.
	 */
	@Override
	public void createControl(Composite parent) {
		initDialog(initialSelection);
		Composite topLevel = dialog.createDialogArea(parent);
		validatePage();
		setControl(topLevel);
	}

	/**
	 * Creates a new complete OCL file resource in the selected container and
	 * with the selected name. Creates any missing resource containers along the
	 * path; does nothing if the container resources already exist.
	 * <p>
	 * In normal usage, this method is invoked after the user has pressed Finish
	 * on the wizard; the enablement of the Finish button implies that all
	 * controls on on this page currently contain valid values.
	 * </p>
	 * <p>
	 * Note that this page caches the new complete OCL file once it has been
	 * successfully created; subsequent invocations of this method will answer
	 * the same file resource without attempting to create it again.
	 * </p>
	 * <p>
	 * This method should be called within a workspace modify operation since it
	 * creates resources.
	 * </p>
	 *
	 * @return the created file resource, or <code>null</code> if the file was
	 *         not created
	 */
	public IFile createNewFile() {
		if (newFile != null) {
			return newFile;
		}

		// create the new complete OCL file and cache it if successful
		newFile = dialog.getNewFile();
		final InputStream initialContents = getInitialContents();

		IRunnableWithProgress op = new IRunnableWithProgress() {

			@Override
			public void run(IProgressMonitor monitor) {
				CreateFileOperation op = new CreateFileOperation(newFile,
					null, initialContents, wizard.getNewFileLabel());
				try {
					op.execute(monitor,WorkspaceUndoUtil.getUIInfoAdapter(getShell()));
				} catch (final ExecutionException e) {
					getContainer().getShell().getDisplay()
						.syncExec(new Runnable() {

							@Override
							public void run() {
								if (e.getCause() instanceof CoreException) {
									ErrorDialog.openError(getContainer().getShell(),
										BaseUIMessages.NewWizardPage_errorTitle,
											null, // no special
											// message
											((CoreException) e.getCause()).getStatus());
								} else {
									BaseUiPluginHelper.log(getClass(), "createNewFile()", e.getCause()); //$NON-NLS-1$
									MessageDialog.openError(getContainer().getShell(),
										BaseUIMessages.NewWizardPage_internalErrorTitle,
											NLS.bind(BaseUIMessages.NewWizardPage_internalErrorTitle,
												e.getCause().getMessage()));
								}
							}
						});
				}
			}
		};
		try {
			getContainer().run(true, true, op);
		} catch (InterruptedException e) {
			return null;
		} catch (InvocationTargetException e) {
			// Execution Exceptions are handled above but we may still get
			// unexpected runtime errors.
			BaseUiPluginHelper.log(getClass(), "createNewFile()", e.getTargetException()); //$NON-NLS-1$
			MessageDialog.open(MessageDialog.ERROR, getContainer().getShell(),
					BaseUIMessages.NewWizardPage_internalErrorTitle,
					NLS.bind(BaseUIMessages.NewWizardPage_internalErrorMessage,
						e.getTargetException().getMessage()), SWT.SHEET);

			return null;
		}

		return newFile;
	}

	/**
	 * Returns a stream containing the initial contents to be given to new
	 * complete OCL file resource instances.
	 *
	 * @return initial contents to be given to new complete OCL file resource
	 *         instances
	 */
	public InputStream getInitialContents() {
		AbstractFileDialog dialog2 = dialog;
		IFile newFile2 = newFile;
		if ((newFile2 != null) && (dialog2 != null) && dialog2.isURIFieldValid()) {
			String initialContentsAsString = wizard.getInitialContentsAsString(newFile2, dialog2);
			return new ByteArrayInputStream(initialContentsAsString.getBytes());
		}
		return null;
	}

	/**
	 * The <code>WizardNewFileCreationPage</code> implementation of this
	 * <code>Listener</code> method handles all events and enablements for
	 * controls on this page. Subclasses may extend.
	 */
	@Override
	public void handleEvent(Event event) {
		if (dialog != null) {
			setPageComplete(validatePage());
		}
	}

	public @NonNull AbstractFileDialog initDialog(@Nullable IResource initialSelection) {
		AbstractFileDialog dialog2 = wizard.createDialog(this, initialSelection);
		dialog = dialog2;
		return dialog2;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			dialog.getGroup().setFocus();
		}
	}

	/**
	 * Returns whether this page's controls currently all contain valid values.
	 *
	 * @return <code>true</code> if all controls are valid, and
	 *         <code>false</code> if at least one is invalid
	 */
	protected boolean validatePage() {
		setMessage(wizard.getPageDescription());
		setErrorMessage(null);

		return dialog.validateGroup();
	}
}