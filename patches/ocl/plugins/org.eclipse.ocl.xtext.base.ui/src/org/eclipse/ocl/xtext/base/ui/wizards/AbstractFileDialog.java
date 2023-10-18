/*******************************************************************************
 * Copyright (c) 2013, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Obeo - initial API and implementation
 *   		references WizardNewFileCreationPage, ResourceDialog and ExtendedLoadResourceDialog
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor.ExtendedLoadResourceAction.ExtendedLoadResourceDialog;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.ocl.xtext.base.ui.BaseUiPluginHelper;
import org.eclipse.ocl.xtext.base.ui.messages.BaseUIMessages;
import org.eclipse.ocl.xtext.base.ui.ripoffs.ResourceAndContainerGroup;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public abstract class AbstractFileDialog extends ExtendedLoadResourceDialog
{
	private static final int SIZING_CONTAINER_GROUP_HEIGHT = 120;
	public static final String PREFIX = BaseUiPluginHelper.PLUGIN_ID + "."; //$NON-NLS-1$

	private static final String NEW_FILE_WIZARD_PAGE = PREFIX
			+ BaseUIMessages.NewWizardPage_newFileWizardContextId;

	// the current resource selection
	protected final @Nullable IResource initialSelection;

	private AbstractFileNewWizardPage wizardPage;

	protected final @NonNull AbstractFileNewWizard wizard;

	// widgets
	private @Nullable ResourceAndContainerGroup resourceGroup;

	/**
	 * Creates an extended new complete OCL file creation dialog. If the initial
	 * resource selection contains exactly one container resource then it will
	 * be used as the default container resource.
	 */
	public AbstractFileDialog(@NonNull AbstractFileNewWizard wizard, @NonNull AbstractFileNewWizardPage wizardPage, @Nullable IResource initialSelection) {
		super(wizardPage.getShell(), null);
		this.initialSelection = initialSelection;
		this.wizardPage = wizardPage;
		this.wizard = wizard;
	}

	@Override
	public Composite createDialogArea(Composite parent) {
		initializeDialogUnits(parent);
		// top level group
		Composite topLevel = new Composite(parent, SWT.NONE);
		topLevel.setLayout(new GridLayout());
		topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL));
		topLevel.setFont(parent.getFont());
		PlatformUI.getWorkbench().getHelpSystem().setHelp(topLevel, NEW_FILE_WIZARD_PAGE);

		resourceGroup = createResourceAndContainerArea(topLevel);
		createMetamodelsArea(topLevel);
		initSelection(initialSelection);
		return topLevel;
	}

	protected void createMetamodelsArea(Composite topLevel) {
		super.createDialogArea(topLevel);
	}

	protected @Nullable ResourceAndContainerGroup createResourceAndContainerArea(Composite parent) {
		// resource and container group
		ResourceAndContainerGroup resourceGroup = new ResourceAndContainerGroup(parent, wizardPage,
			wizard.getNewFileLabel(), BaseUIMessages.NewWizardPage_file, false, SIZING_CONTAINER_GROUP_HEIGHT);
		resourceGroup.setAllowExistingResources(false);
		resourceGroup.setResourceExtension(wizard.getNewFileExtension());
		return resourceGroup;
	}

	/**
	 * Returns the current file name as entered by the user, or its anticipated
	 * initial value. <br>
	 * <br>
	 * The current file name will include the file extension if the
	 * preconditions are met.
	 *
	 * @see WizardNewFileCreationPage#setFileExtension(String)
	 *
	 * @return the file name, its anticipated initial value, or
	 *         <code>null</code> if no file name is known
	 */
	public String getFileName() {
		return getGroup().getResource();
	}

	/**
	 * @return the resource group
	 */
	protected @NonNull ResourceAndContainerGroup getGroup() {
		ResourceAndContainerGroup resourceGroup2 = resourceGroup;
		assert resourceGroup2 != null;
		return resourceGroup2;
	}

	public IFile getNewFile() {
		IPath newFilePath = getNewFilePath();
		return ResourcesPlugin.getWorkspace().getRoot().getFile(newFilePath);
	}

	public IPath getNewFilePath() {
		ResourceAndContainerGroup group = getGroup();
		IPath containerPath = group.getContainerFullPath();
		return containerPath.append(group.getResource());
	}

	@Override
	public Shell getShell() {
		return wizard.getShell();
	}

	public void initSelection(IResource initialSelection) {
		ResourceAndContainerGroup resourceGroup2 = resourceGroup;
		if (resourceGroup2 != null) {
			IResource resourceSelection2 = initialSelection;
			if (resourceSelection2 instanceof IFile) {
				IPath fullPath = resourceSelection2.getFullPath();
				if (uriField != null) {
					URI uri = URI.createPlatformResourceURI(fullPath.toString(), true);
					uriField.setText(String.valueOf(uri));
				}
				IPath removeFileExtension = fullPath.removeFileExtension();
				IPath addFileExtension = removeFileExtension.addFileExtension(wizard.getNewFileExtension());
				resourceGroup2.setResource(addFileExtension.lastSegment());
			}
			else {
				resourceGroup2.setResource(wizard.getNewFileName());
			}
			if (resourceSelection2 != null) {
				initialPopulateContainerNameField(resourceSelection2);
			}
		}
	}

	/**
	 * Sets the initial contents of the container name entry field, based upon
	 * either a previously-specified initial value or the ability to determine
	 * such a value.
	 */
	@SuppressWarnings("null")
	private void initialPopulateContainerNameField(@NonNull IResource resourceSelection) {
		ResourceAndContainerGroup resourceGroup2 = getGroup();
		if (resourceSelection.getType() == IResource.FILE) {
			resourceSelection = resourceSelection.getParent();
		}
		if (resourceSelection.isAccessible()) {
			resourceGroup2.setContainerFullPath(resourceSelection.getFullPath());
		}
	}

	/**
	 * Returns true if this selected resource would be filtered from view.
	 *
	 * {@link IWorkspace#validateFiltered(IResource)}
	 */
	protected boolean isFilteredByParent() {
		ResourceAndContainerGroup group = getGroup();
		IPath containerPath = group.getContainerFullPath();
		if (containerPath == null)
			return false;
		String resourceName = group.getResource();
		if (resourceName == null)
			return false;
		if (resourceName.length() > 0) {
			//			IPath newFolderPath = containerPath.append(resourceName);
			//			IFile newFileHandle = createFileHandle(newFolderPath);
			IFile newFileHandle = getNewFile();
			IWorkspace workspace = newFileHandle.getWorkspace();
			return !workspace.validateFiltered(newFileHandle).isOK();
		}
		return false;
	}

	public boolean isURIFieldValid() {
		return (uriField == null) || (uriField.getText() != "");//$NON-NLS-1$
	}

	public boolean validateGroup() {
		boolean valid = true;
		ResourceAndContainerGroup group = getGroup();
		if (!group.areAllValuesValid()) {
			// if blank name then fail silently
			int problemType = group.getProblemType();
			String problemMessage = group.getProblemMessage();
			if (problemType == ResourceAndContainerGroup.PROBLEM_RESOURCE_EMPTY
					|| problemType == ResourceAndContainerGroup.PROBLEM_CONTAINER_EMPTY) {
				wizardPage.setMessage(problemMessage);
				wizardPage.setErrorMessage(null);
			} else {
				wizardPage.setErrorMessage(problemMessage);
			}
			valid = false;
		}

		String resourceName = group.getResource();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IStatus result = workspace.validateName(resourceName, IResource.FILE);
		if (!result.isOK()) {
			wizardPage.setErrorMessage(result.getMessage());
			return false;
		}

		if (group.getAllowExistingResources()) {
			String problemMessage = NLS.bind(
				BaseUIMessages.NewWizardPage_nameExists,
				getFileName());
			IPath resourcePath = group.getContainerFullPath().append(getFileName());
			IWorkspaceRoot root = workspace.getRoot();
			if (root.getFolder(resourcePath).exists()) {
				wizardPage.setErrorMessage(problemMessage);
				valid = false;
			}
			if (root.getFile(resourcePath).exists()) {
				wizardPage.setMessage(problemMessage, IMessageProvider.WARNING);
			}
		}

		if (isFilteredByParent()) {
			wizardPage.setMessage(
				BaseUIMessages.NewWizardPage_resourceWillBeFilteredWarning,
				IMessageProvider.ERROR);
			valid = false;
		}
		return valid;
	}
}
