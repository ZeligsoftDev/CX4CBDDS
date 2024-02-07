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


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.ocl.examples.emf.validation.validity.ui.messages.ValidityUIMessages;
import org.eclipse.ocl.examples.emf.validation.validity.ui.plugin.ValidityUIPlugin;
import org.eclipse.ocl.examples.emf.validation.validity.ui.ripoffs.ResourceAndContainerGroup;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * Wizard page allowing creation of exported files in the workspace.
 */
public class ExportValidationResultsFileWizardPage extends WizardPage implements Listener
{
	private static final int SIZING_CONTAINER_GROUP_HEIGHT = 120;
	private static final String NEW_FILE_WIZARD_PAGE = ValidityUIPlugin.PLUGIN_ID + '.' + ValidityUIMessages.NewWizardPage_newFileWizardContextId;

	private final @Nullable String preferredExtension;	

	// the current resource selection
	private final @Nullable IResource initialResource;
	
	// widgets
	private @Nullable ResourceAndContainerGroup resourceGroup;

	/**
	 * Creates a new exported file creation wizard page. The initial
	 * resource will be used as the default container resource.
	 * 
	 * @param preferredExtension
	 * @param initialResource
	 *            the current resource selection
	 */
	public ExportValidationResultsFileWizardPage(@Nullable String preferredExtension, @Nullable IResource initialResource) {
		super(ValidityUIMessages.NewWizardPage_pageName);
		setTitle(ValidityUIMessages.NewWizardPage_pageSummary);
		setDescription(ValidityUIMessages.NewWizardPage_pageDescription);
		setPageComplete(false);
		this.preferredExtension = preferredExtension;
		this.initialResource = initialResource;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite topLevel = new Composite(parent, SWT.NONE);
		topLevel.setLayout(new GridLayout());
		topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL));
		topLevel.setFont(parent.getFont());
		PlatformUI.getWorkbench().getHelpSystem().setHelp(topLevel, NEW_FILE_WIZARD_PAGE);

		resourceGroup = createResourceAndContainerArea(topLevel);
		initSelection(initialResource);
		
		validatePage();
		setControl(topLevel);
	}
	
	private @Nullable ResourceAndContainerGroup createResourceAndContainerArea(Composite parent) {
		// resource and container group
		ResourceAndContainerGroup resourceGroup = new ResourceAndContainerGroup(parent, this,
				ValidityUIMessages.NewWizardPage_fileNameLabel,
				ValidityUIMessages.NewWizardPage_file, false, SIZING_CONTAINER_GROUP_HEIGHT);
		resourceGroup.setAllowExistingResources(true);
		resourceGroup.setResourceExtension(preferredExtension);
		return resourceGroup;
	}

	
	/**
	 * @return the resource group
	 */
	private @NonNull ResourceAndContainerGroup getGroup() {
		ResourceAndContainerGroup resourceGroup2 = resourceGroup;
		assert resourceGroup2 != null;
		return resourceGroup2;
	}

	/**
	 * Returns true if this selected resource would be filtered from view.
	 * 
	 * {@link IWorkspace#validateFiltered(Resource)}
	 */
	private boolean isFilteredByParent() {
		ResourceAndContainerGroup group = getGroup();
		IPath containerPath = group.getContainerFullPath();
		if (containerPath == null)
			return false;
		String resourceName = group.getResource();
		if (resourceName == null)
			return false;
		if (resourceName.length() > 0) {
			IFile newFileHandle = getNewExportedFile();
			IWorkspace workspace = newFileHandle.getWorkspace();
			return !workspace.validateFiltered(newFileHandle).isOK();
		}
		return false;
	}

	/**
	 * Returns whether this page's controls currently all contain valid values.
	 * 
	 * @return <code>true</code> if all controls are valid, and
	 *         <code>false</code> if at least one is invalid
	 */
	private boolean validatePage() {
		setMessage(ValidityUIMessages.NewWizardPage_pageDescription);
		setErrorMessage(null);
	
		return validateGroup();
	}

	/**
	 * Returns the current exported file name as entered by the user, or its anticipated
	 * initial value. <br>
	 * <br>
	 * The current exported file name will include the file extension if the
	 * preconditions are met.
	 * 
	 * @see WizardNewFileCreationPage#setFileExtension(String)
	 * 
	 * @return the file name, its anticipated initial value, or
	 *         <code>null</code> if no file name is known
	 */
	private String getNewExportedFileName() {
		return getGroup().getResource();
	}

	private IFile getNewExportedFile() {
		IPath newFilePath = getNewExportedFilePath();
		return ResourcesPlugin.getWorkspace().getRoot().getFile(newFilePath);
	}

	public IPath getNewExportedFilePath() {
		ResourceAndContainerGroup group = getGroup();
		IPath containerPath = group.getContainerFullPath();
		return containerPath.append(group.getResource());
	}
	
	private void initSelection(IResource initialSelection) {
		ResourceAndContainerGroup resourceGroup2 = resourceGroup;
		IResource resourceSelection2 = initialSelection;
		if (resourceGroup2 != null && resourceSelection2 != null) {
			resourceGroup2.setResource(ValidityUIMessages.NewWizardPage_defaultFileName + "." + preferredExtension);
			initialPopulateContainerNameField(resourceSelection2);
		}
	}

	/**
	 * Sets the initial contents of the container name entry field, based upon
	 * either a previously-specified initial value or the ability to determine
	 * such a value.
	 * 
	 * @param resourceSelection
	 *            The selected resource
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

	private boolean validateGroup() {
		boolean valid = true;
		ResourceAndContainerGroup group = getGroup();
		if (!group.areAllValuesValid()) {
			// if blank name then fail silently
			int problemType = group.getProblemType();
			String problemMessage = group.getProblemMessage();
			if (problemType == ResourceAndContainerGroup.PROBLEM_RESOURCE_EMPTY
				|| problemType == ResourceAndContainerGroup.PROBLEM_CONTAINER_EMPTY) {
				setMessage(problemMessage);
				setErrorMessage(null);
			} else {
				setErrorMessage(problemMessage);
			}
			valid = false;
		}

		String resourceName = group.getResource();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IStatus result = workspace.validateName(resourceName, IResource.FILE);
		if (!result.isOK()) {
			setErrorMessage(result.getMessage());
			return false;
		}
		
//		if (!resourceName.endsWith('.' + expectedExtension)) {
//			setErrorMessage(NLS.bind(ValidityUIMessages.NewWizardPage_wrongExtension, preferredExtension));
//			return false;
//		}

		if (group.getAllowExistingResources()) {
			IPath containerFullPath = group.getContainerFullPath();
			if (containerFullPath != null) {
				String newExportedFileName = getNewExportedFileName();
				String problemMessage = NLS.bind(ValidityUIMessages.NewWizardPage_nameExists, newExportedFileName);
				IPath resourcePath = containerFullPath.append(newExportedFileName);
				IWorkspaceRoot root = workspace.getRoot();
				if (root.getFolder(resourcePath).exists()) {
					setErrorMessage(problemMessage);
					valid = false;
				}
				if (root.getFile(resourcePath).exists()) {
					setMessage(problemMessage, IMessageProvider.WARNING);
				}
			}
		}

		if (isFilteredByParent()) {
			setMessage(
				ValidityUIMessages.NewWizardPage_resourceWillBeFilteredWarning,
				IMessageProvider.ERROR);
			valid = false;
		}
		return valid;
	}
	
	
	/**
	 * The <code>WizardNewFileCreationPage</code> implementation of this
	 * <code>Listener</code> method handles all events and enablements for
	 * controls on this page. Subclasses may extend.
	 *
	 *(non-Javadoc)
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		setPageComplete(validatePage());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			getGroup().setFocus();
		}
	}
}