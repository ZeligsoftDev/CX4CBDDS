/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.zeligsoft.cx.ui.pages;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.cx.CXActivator;
import com.zeligsoft.cx.ui.l10n.Messages;

/**
 * Wizard page for creating Zeligsoft model
 * 
 * @author ysroh
 * 
 */
public class ZeligsoftModelWizardPage
		extends WizardPage {

	protected Text modelNameField;

	protected Text cdtProjectNameField;

	protected Text folderNameField;

	protected Button cdtUseDefaultButton;

	protected IResource resource;

	protected String dest;

	protected String defaultModelName = ""; //$NON-NLS-1$

	protected String defaultCdtProjectName = ""; //$NON-NLS-1$

	protected String cdtProjectNameSuffix;

	// Name field modify listener
	protected Listener nameFieldModifyListener = new Listener() {

		@Override
		public void handleEvent(Event e) {
			validateName();
			if (cdtUseDefaultButton.getSelection()) {
				cdtProjectNameField.setText(getDefaultCdtProjectName());
			}
		}

	};
	
	/**
	 * Helper method to compose default CDT project name
	 */
	protected String getDefaultCdtProjectName() {
		if (defaultCdtProjectName.length() == 0) {
			if (modelNameField != null) {
				return modelNameField.getText() + cdtProjectNameSuffix;
			}
			return defaultModelName + cdtProjectNameSuffix;
		}
		return defaultCdtProjectName;
	}
	
	/**
	 * Set default CDT project name and update the text field
	 */
	public void setDefaultCdtProjectName(String cdtProjectName) {
		defaultCdtProjectName = cdtProjectName;
		if (cdtProjectNameField != null && cdtUseDefaultButton.getSelection()) {
			cdtProjectNameField.setText(defaultCdtProjectName);
		}
	}

	// CDT Project Name field modify listener
	protected Listener cdtNameFieldModifyListener = new Listener() {

		@Override
		public void handleEvent(Event e) {
			validateName();
		}

	};

	// Folder name field modify listener
	protected Listener folderNameFieldModifyListener = new Listener() {

		@Override
		public void handleEvent(Event e) {
			validateFolderName();
		}

	};

	public ZeligsoftModelWizardPage(String pageName) {

		super(pageName);
		resource = null;
	}

	/**
	 * Constructor
	 * 
	 * @param pageName
	 *            The name of the page
	 * @param selectedResource
	 *            This resource is used to validate the path
	 */
	public ZeligsoftModelWizardPage(String pageName, IResource selectedResource) {

		super(pageName);
		resource = selectedResource;
		if (selectedResource == null) {
			return;
		}
		if (!(resource instanceof IContainer)) {
			dest = resource.getParent().getFullPath().toString();
		} else {
			dest = resource.getFullPath().toString();
		}
	}

	@Override
	@SuppressWarnings("deprecation")
	public void createControl(Composite parent) {

		cdtProjectNameSuffix = CXActivator
			.getDefault()
			.getPluginPreferences()
			.getString(
				com.zeligsoft.cx.preferences.CXPreferenceConstants.CDT_PROJECT_SUFFIX);

		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		layout.makeColumnsEqualWidth = false;

		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		createModelNameGroup(composite);

		if (resource != null) {
			createFolderNameGroup(composite);
		}

		setControl(composite);

	}

	/**
	 * Creates an folder name group
	 * 
	 * @param parent
	 *            Parent composite
	 */
	protected void createFolderNameGroup(Composite composite) {

		Label folderLabel = new Label(composite, SWT.LEFT);
		folderLabel
			.setText(Messages.ZeligsoftModelWizardPage_DestinationFolderLabel);
		folderLabel.setLayoutData(new GridData());

		folderNameField = new Text(composite, SWT.BORDER);
		folderNameField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		folderNameField.setText(dest);
		folderNameField.addListener(SWT.Modify, folderNameFieldModifyListener);

		final ContainerSelectionDialog dialog = new ContainerSelectionDialog(
			getShell(),
			resource.getProject().getFolder(dest),
			false,
			Messages.ZeligsoftModelWizardPage_BrowseFolderDialogDescriptionLabel);

		Button browseButton = new Button(composite, SWT.NULL);
		browseButton
			.setText(Messages.ZeligsoftModelWizardPage_BrowseButtonLabel);
		GridData data = new GridData();
		data.widthHint = 80;
		browseButton.setLayoutData(data);
		browseButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (dialog.open() == Window.OK) {
					folderNameField.setText(((IPath) dialog.getResult()[0])
						.toString());
				}
			}
		});

	}

	/**
	 * Creates model name group
	 * 
	 * @param parent
	 *            Parent composite
	 */
	protected final void createModelNameGroup(Composite composite) {

		{

			// Model Name
			Label modelLabel = new Label(composite, SWT.NULL);
			modelLabel
				.setText(Messages.ZeligsoftModelWizardPage_ModelNameLabel);
			modelLabel.setLayoutData(new GridData());

			GridData data = new GridData(GridData.FILL_HORIZONTAL);
			data.horizontalSpan = 2;
			data.grabExcessHorizontalSpace = true;

			modelNameField = new Text(composite, SWT.BORDER);
			modelNameField.setText(defaultModelName);
			modelNameField.selectAll();
			modelNameField.setLayoutData(data);
			modelNameField.addListener(SWT.Modify, nameFieldModifyListener);
		}

		{
			// CDT Project Name
			Label cdtProjectLabel = new Label(composite, SWT.NONE);
			cdtProjectLabel
				.setText(Messages.ZeligsoftModelWizardPage_CDTProjectNameLabel
					+ ": "); //$NON-NLS-1$
			cdtProjectLabel.setLayoutData(new GridData());

			GridData data = new GridData(GridData.FILL_HORIZONTAL);
			data.grabExcessHorizontalSpace = true;

			cdtProjectNameField = new Text(composite, SWT.BORDER);
			cdtProjectNameField.setText(getDefaultCdtProjectName());
			cdtProjectNameField.selectAll();
			cdtProjectNameField.setLayoutData(data);
			cdtProjectNameField.addListener(SWT.Modify,
				cdtNameFieldModifyListener);
			cdtProjectNameField.setEditable(false);

			cdtUseDefaultButton = new Button(composite, SWT.CHECK);
			cdtUseDefaultButton
				.setText(Messages.ZeligsoftModelWizardPage_UseDefaultLabel);
			cdtUseDefaultButton.setLayoutData(new GridData());
			cdtUseDefaultButton.setSelection(true);
			cdtUseDefaultButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					if (cdtUseDefaultButton.getSelection()) {
						cdtProjectNameField.setEditable(false);
						cdtProjectNameField.setText(getDefaultCdtProjectName());
					} else {
						cdtProjectNameField.setEditable(true);
					}
				}
			});

		}

	}

	/**
	 * Returns model name
	 * 
	 * @return model name
	 */
	public String getModelName() {
		if (modelNameField == null) {
			return ""; //$NON-NLS-1$
		}
		return modelNameField.getText();
	}

	/**
	 * Return CDT Project Name
	 * 
	 * @return CDT Project Name
	 */
	public String getCdtProjectName() {

		if (cdtProjectNameField == null) {
			return ""; //$NON-NLS-1$
		}
		return cdtProjectNameField.getText();
	}

	/**
	 * Returns destination folder path in string
	 * 
	 * @return
	 */
	public String getFolderPath() {
		if (folderNameField == null) {
			return ""; //$NON-NLS-1$
		}
		return folderNameField.getText();
	}

	/**
	 * Validate the model name
	 */
	protected void validateName() {
		if (UML2Util.isEmpty(modelNameField.getText())) {
			setPageComplete(false);
			setErrorMessage(Messages.ZeligsoftModelWizardPage_ModelNameEmptyErrorMsg);
			return;
		}

		if (modelNameField.getText().matches(".*[^A-Z,a-z,0-9,\\-,_].*")) { //$NON-NLS-1$
			setPageComplete(false);
			setErrorMessage(Messages.ZeligsoftModelWizardPage_InvalidModelNameErrorMsg);
			return;
		}

		if (resource != null) {

			// check to see if model exists already
			String destFile = folderNameField.getText()
				+ System.getProperty("file.separator") //$NON-NLS-1$
				+ modelNameField.getText() + ".emx"; //$NON-NLS-1$

			IFile file = resource.getProject().getFile(new Path(destFile));
			if (file.exists()) {
				setErrorMessage(Messages.ZeligsoftModelWizardPage_ModelNameErrorMessage);
				setPageComplete(false);
				return;
			}
		}
		if(validateCdtProjectName() == false){
			return;
		}
		setPageComplete(true);
		setErrorMessage(null);

	}
	
	protected boolean validateCdtProjectName(){
		if (UML2Util.isEmpty(cdtProjectNameField.getText())) {
			setPageComplete(false);
			setErrorMessage(Messages.ZeligsoftModelWizardPage_CDTProjectNameErrorMsg);
			return false;
		}
		
		if (cdtProjectNameField.getText().matches(".*[^A-Z,a-z,0-9,\\-,_].*")) { //$NON-NLS-1$
			setPageComplete(false);
			setErrorMessage(Messages.ZeligsoftModelWizardPage_InvalidCDTProjectNameErrorMsg);
			return false;
		}
		
		if (resource != null) {

			// check to see if CDT project already exists
			IProject project = resource.getWorkspace().getRoot().getProject(
				cdtProjectNameField.getText());
			if (project.exists()) {
				setErrorMessage(Messages.ZeligsoftModelWizardPage_CDTProjectExistErrorMsg);
				setPageComplete(false);
				return false;
			}
		}
		return true;
	}

	/**
	 * Validate folder name
	 */
	protected void validateFolderName() {

		// Contains project name only
		String[] pathSeg = folderNameField.getText().split("/"); //$NON-NLS-1$
		if (pathSeg.length == 1
			|| (pathSeg.length == 2 && pathSeg[0].length() == 0)) {
			if (!(resource.getWorkspace().getRoot().getProject(folderNameField
				.getText())).exists()) {
				setPageComplete(false);
				setErrorMessage(Messages.ZeligsoftModelWizardPage_FolderErrorMessage);
				return;
			}
			setPageComplete(true);
			setErrorMessage(null);
			return;
		}

		// Contains project name and folder name
		IFolder folder = resource.getWorkspace().getRoot().getFolder(
			new Path(folderNameField.getText()));
		if (!folder.exists()) {
			setPageComplete(false);
			setErrorMessage(Messages.ZeligsoftModelWizardPage_FolderErrorMessage);
			return;
		}
		setPageComplete(true);
		setErrorMessage(null);
	}

	/**
	 * Set the default model name
	 * 
	 * @param modelName
	 *            default model name
	 */
	public void setDefaultModelName(String modelName) {
		this.defaultModelName = modelName;
	}
}
