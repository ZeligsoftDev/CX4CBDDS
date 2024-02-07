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

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ocl.xtext.base.ui.BaseUiPluginHelper;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * Wizard allowing the user to create a new OCL rule file.
 */
public abstract class AbstractFileNewWizard extends Wizard implements INewWizard
{
	/** The only page contributing to the wizard */
	private AbstractFileNewWizardPage wizardPage;

	/**
	 * Constructor
	 */
	protected AbstractFileNewWizard() {
		setDefaultPageImageDescriptor(BaseUiPluginHelper.getImageDescriptor("icons/OCLModelFile.gif"));
		setWindowTitle(getPageTitle());
	}

	protected abstract @NonNull AbstractFileDialog createDialog(@NonNull AbstractFileNewWizardPage wizardPage, @Nullable IResource initialSelection);

	public @NonNull AbstractFileNewWizardPage createNewWizardPage(@Nullable IResource initialSelection) {
		return new AbstractFileNewWizardPage(this, initialSelection);
	}

	protected abstract String getEditorId();

	/**
	 * Returns a string containing the initial contents to be given to new
	 * complete OCL file resource instances.
	 *
	 * @return contents to be given to new complete OCL file resource instances
	 */
	public abstract @NonNull String getInitialContentsAsString(@NonNull IFile newFile, @NonNull AbstractFileDialog dialog);

	/**
	 * Returns the extension to display in the file name specification visual
	 * component group.
	 *
	 * @return the extension to display in the file name specification visual
	 *         component group
	 */
	public abstract @NonNull String getNewFileExtension();

	/**
	 * Returns the name to display in the file name specification visual
	 * component group.
	 *
	 * @return the name to display in the file name specification visual
	 *         component group
	 */
	public abstract @NonNull String getNewFileName();

	/**
	 * Returns the label to display in the file name specification visual
	 * component group.
	 *
	 * @return the label to display in the file name specification visual
	 *         component group
	 */
	public abstract @NonNull String getNewFileLabel();

	/**
	 * Return the long description to appear in the dialog.
	 */
	public abstract @NonNull String getPageDescription();

	/**
	 * Return the short description to appear in the dialog.
	 */
	public abstract @NonNull String getPageSummary();

	/**
	 * Return the text to appear as the title in the window manager frame.
	 */
	public abstract @NonNull String getPageTitle();

	/**
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		IResource selectedResource = null;
		Iterator<?> it = selection.iterator();
		if (it.hasNext()) {
			Object object = it.next();
			if (object instanceof IResource) {
				selectedResource = (IResource) object;
			} else if (object instanceof IAdaptable) {
				@Nullable IResource adapter = ((IAdaptable) object).getAdapter(IResource.class);
				selectedResource = adapter;
			}
		}
		wizardPage = createNewWizardPage(selectedResource);
//		wizardPage.initSelection(selectedResource);
		addPage(wizardPage);
	}

	/**
	 * Opens file in the Editor
	 * @param the file to open
	 * @throws PartInitException
	 */
	private void openCreatedFile(IFile file) throws PartInitException {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage currentPage = activeWorkbenchWindow.getActivePage();
		IDE.openEditor(currentPage, file, getEditorId(), true);
	}

	/**
	 * Performs finish action of this wizard.
	 *
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		final IFile file = wizardPage.createNewFile();
		try {
			openCreatedFile(file);
		} catch (PartInitException e) {
			BaseUiPluginHelper.log(e);
			return false;
		}
		return true;
	}
}