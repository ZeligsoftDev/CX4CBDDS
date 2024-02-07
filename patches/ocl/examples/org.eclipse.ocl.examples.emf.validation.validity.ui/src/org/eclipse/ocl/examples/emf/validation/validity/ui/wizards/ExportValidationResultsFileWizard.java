/*******************************************************************************
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.export.IValidityExporter;
import org.eclipse.ocl.examples.emf.validation.validity.ui.messages.ValidityUIMessages;
import org.eclipse.ocl.examples.emf.validation.validity.ui.plugin.ValidityUIPlugin;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.google.common.io.Files;

/**
 * Wizard allowing the user to export a validation results file.
 */
public class ExportValidationResultsFileWizard extends Wizard implements INewWizard
{
	/** The only export descriptor contributing to the wizard */
	private final @NonNull IValidityExporter exporter;

	/** The results root node contributing to the wizard */
	private final @NonNull RootNode rootNode;

	/** The only page contributing to the wizard */
	private ExportValidationResultsFileWizardPage wizardPage;

	/**
	 * Constructor
	 */
	public ExportValidationResultsFileWizard(@NonNull IWorkbench workbench, @Nullable IStructuredSelection initialSelection, 
			@NonNull RootNode rootNode, @NonNull IValidityExporter exporter) {
		super();
		setWindowTitle(ValidityUIMessages.NewWizardPage_pageTitle);
		this.exporter = exporter;
		this.rootNode = rootNode;
		init(workbench, initialSelection);
	}
	
	public void export(final @Nullable Resource zzvalidatedResource, @NonNull IPath savePath) {
		final File exportedFile = new File(savePath.toString());
		final IFile exportedIFile = ResourcesPlugin.getWorkspace().getRoot().getFile(savePath);
		final boolean fileExists = exportedIFile.exists();
		if (fileExists) {
			if (!MessageDialog.openQuestion(getShell(), ValidityUIMessages.NewWizardPage_exists,
					NLS.bind(ValidityUIMessages.NewWizardPage_overwrite, savePath.toString()))) {
				return;
			}
		}
		final IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				String initialContents = exporter.export(rootNode, exportedFile.getName());
				byte[] byteArrayInputStream = initialContents.getBytes(Charset.forName("UTF-8"));
				try {
					if (exportedFile.isAbsolute()) {
						Files.write(byteArrayInputStream, exportedFile);
					} else {
						final InputStream contentStream = new ByteArrayInputStream(byteArrayInputStream);
						if (!fileExists) {
							exportedIFile.create(contentStream, true, monitor);
						}
						else {
							exportedIFile.setContents(contentStream, true, true, monitor);
						}
					}
				} catch (final CoreException e) {
					handleError(e, true);
				} catch (final IOException e) {
					handleError(e, true);
				}
			}
		};

		try {
			op.run(new NullProgressMonitor());
		} catch (InvocationTargetException e) {
			handleError(e, false);
		} catch (InterruptedException e) {
			handleError(e, false);
		}
	}

	private static void handleError(Throwable t, boolean popup) {
		final String message = NLS.bind(ValidityUIMessages.NewWizardPage_internalErrorMessage, t.getMessage());
		final IStatus status;
		if (t instanceof CoreException) {
			status = new Status(((CoreException) t).getStatus().getSeverity(), ValidityUIPlugin.PLUGIN_ID, message, t);
		} else {
			status = new Status(IStatus.ERROR, ValidityUIPlugin.PLUGIN_ID, message, t);
		}
		ValidityUIPlugin.getPlugin().getLog().log(status);
		
		if (popup) {
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
				public void run() {
					ErrorDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
							ValidityUIMessages.NewWizardPage_errorTitle, message, status);
					}
				});
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		Object selected = selection != null ? selection.getFirstElement() : null;
		IResource initialIResource = selected instanceof IResource ? (IResource)selected : null;
		String preferredExtension = exporter.getPreferredExtension();
		wizardPage = new ExportValidationResultsFileWizardPage(preferredExtension, initialIResource);
		addPage(wizardPage);
	}

	/**
	 * Creates a new Exported validation results file resource in the selected container and
	 * with the selected name. Creates any missing resource containers along the
	 * path; does nothing if the container resources already exist.
	 * <p>
	 * In normal usage, this method is invoked after the user has pressed Finish
	 * on the wizard; the enablement of the Finish button implies that all
	 * controls on on this page currently contain valid values.
	 * </p>
	 * <p>
	 * This method should be called within a workspace modify operation since it
	 * creates resources.
	 * </p>
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		final IPath path = wizardPage.getNewExportedFilePath();
		if (path != null) {
			export(null, path);
		}
		return true;
	}
}
