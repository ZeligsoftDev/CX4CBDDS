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
package com.zeligsoft.domain.sca.agilent.importer.ui.pages;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;

import com.zeligsoft.domain.sca.agilent.importer.ui.l10.AgilentImporterMessages;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class AgilentImportPage extends WizardPage {
	
	private static final String EMX = "emx"; //$NON-NLS-1$
	private static final int SIZING_TEXT_FIELD_WIDTH = 250;
	private static final int SIZING_LABEL_WIDTH = 125;
	
	private final IStructuredSelection selection;
	private final IWorkbench workbench;
	
	private Text sourcePathField;
	private Text targetPathField;
	
	private List<String> fileExtensions;
	
	
	public AgilentImportPage(String name, IWorkbench aWorkbench, IStructuredSelection selection,
			String title, String description) {
		super(name);
		setTitle(title);
		setDescription(description);
		
		this.workbench = aWorkbench;
		this.selection = selection;
	}
	
	public void setFileExtensions(List<String> fileExtensions) {
		this.fileExtensions = fileExtensions;
	}
	
	/**
	 * Return true if the extension is a selectable file type.
	 * 
	 * @param extension
	 * @return
	 */
	protected boolean isValidExtension(String extension) {
		return fileExtensions.contains(extension);
	}
	
	
	protected void createSourceGroup(Composite parent) {
		GridData data;
		
		Composite group = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		group.setLayout(layout);
		group.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL));
		group.setFont(parent.getFont());
		
		// label
		Label fileName = new Label(group, SWT.NONE);
		data = new GridData(GridData.HORIZONTAL_ALIGN_END);
		data.widthHint = SIZING_LABEL_WIDTH;
		fileName.setLayoutData(data);
		fileName.setText(AgilentImporterMessages.AgilentImportPage_source_field_label);
		fileName.setFont(parent.getFont());
		
		// field
		sourcePathField = new Text(group, SWT.BORDER);
		sourcePathField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				handleSourcePathFieldChanged();
			}
		});
		data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		sourcePathField.setLayoutData(data);
		sourcePathField.setFont(parent.getFont());
		sourcePathField.setText(selectedSourceHint());
		
		Button sourceBrowseButton = new Button(group, SWT.PUSH);
		sourceBrowseButton.setText(AgilentImporterMessages.AgilentImportPage_source_browse_button_label);
		sourceBrowseButton.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_FILL));
		sourceBrowseButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleSourceBrowseEvent();
			}
		});
		sourceBrowseButton.setFont(parent.getFont());
		setButtonLayoutData(sourceBrowseButton);
		sourceBrowseButton.setFocus();
	}
	
	/**
	 * Create the target model widgets group.
	 * 
	 * @param Composite parent
	 */
	protected void createDestinationModelGroup(Composite parent) {
		GridData data;
		
		// container specification group
		Composite containerGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		containerGroup.setLayout(layout);
		containerGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		containerGroup.setFont(parent.getFont());

		// container label
		Label resourcesLabel = new Label(containerGroup, SWT.NONE);
		data = new GridData(GridData.HORIZONTAL_ALIGN_END);
		data.widthHint = SIZING_LABEL_WIDTH;
		resourcesLabel.setLayoutData(data);
		resourcesLabel.setText(AgilentImporterMessages.AgilentImportPage_target_field_label);
		resourcesLabel.setFont(parent.getFont());

		// container name entry field
		targetPathField = new Text(containerGroup, SWT.SINGLE | SWT.BORDER);
		targetPathField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				handleTargetPathFieldChanged();
			}
		});
		data = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		targetPathField.setLayoutData(data);
		targetPathField.setFont(parent.getFont());
		targetPathField.setText(targetHint());

		// container browse button
		Button targetBrowseButton = new Button(containerGroup, SWT.PUSH);
		targetBrowseButton.setText(AgilentImporterMessages.AgilentImportPage_target_browse_button_label);
		targetBrowseButton.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_FILL));
		targetBrowseButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleTargetBrowseEvent();
			}
		});
		targetBrowseButton.setFont(parent.getFont());
		setButtonLayoutData(targetBrowseButton);
	}

	protected void handleTargetPathFieldChanged() {
		determinePageCompletion();
	}
	
	protected void handleSourcePathFieldChanged() {
		determinePageCompletion();
	}

	protected void handleTargetBrowseEvent() {
		ViewerFilter filter = new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				boolean result = false;
				if (element instanceof IFile) {
					result = EMX.equals(((IFile) element).getFileExtension());
				}

				if (element instanceof IContainer) {
					result = true;
				}

				return result;
			}
		};
		
		IFile[] result = WorkspaceResourceDialog.openFileSelection(
					getShell(), 
					AgilentImporterMessages.AgilentImportPage_target_browse_dialog_title, 
					AgilentImporterMessages.AgilentImportPage_target_browse_dialog_description, 
					false, 
					null, 
					Collections.singletonList(filter));
		if (result.length != 1) {
			return;
		}

		IFile selectedFile = result[0];
		targetPathField.setText(selectedFile.getLocationURI().toString());
		setPageComplete(determinePageCompletion());
	}

	protected void handleSourceBrowseEvent() {
		IFile[] files = WorkspaceResourceDialog.openFileSelection(
				getShell(),
				AgilentImporterMessages.AgilentImportPage_source_browse_dialog_title, 
				AgilentImporterMessages.AgilentImportPage_source_browse_dialog_description, 
				false, 
				null, 
				null);
		
		if (files.length != 1) {
			return;
		}
		
		IFile selectedFile = files[0];
		if(selectedFile != null) {
			// Just quite if the file is not valid
			// If it is valid then proceed and populate
			sourcePathField.setText(selectedFile.getLocationURI().toString());
		}
		setPageComplete(determinePageCompletion());
		
	}

	public boolean finish() {
		return determinePageCompletion();
	}

	private boolean determinePageCompletion() {
		if (getSource() == null || getSource().length() <= 0) {
			setErrorMessage(AgilentImporterMessages.AgilentImportPage_source_invalid_error_message);
			return false;
		} else if (getTarget() == null || getTarget().length() <= 0) {
			setErrorMessage(AgilentImporterMessages.AgilentImportPage_target_invalid_error_message);
			return false;
		} 

		setErrorMessage(null);
		return true;
	}

	/**
	 * Get the source XML file that is being imported.
	 * @return
	 */
	public String getSource() {
		if(sourcePathField == null) {
			return "";
		}
		
		return sourcePathField.getText();
	}
	
	/**
	 * Get the target EMX file that the XML is being imported into.
	 * @return
	 */
	public String getTarget() {
		if(targetPathField == null) {
			return "";
		}
		
		return targetPathField.getText();
	}
	

	public void createControl(Composite parent) {
		initializeDialogUnits(parent);
		
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		composite.setSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		composite.setFont(parent.getFont());
		
		createSourceGroup(composite);
		createDestinationModelGroup(composite);
		
		setPageComplete(determinePageCompletion());
		setControl(composite);
	}

	protected String selectedSourceHint() {
		for(Object element : selection.toList()) {
			if(element instanceof IFile) {
				IFile ifile = (IFile) element;
				if(fileExtensions.contains(ifile.getFileExtension())) {
					return ifile.getLocationURI().toString();
				}
			}
		}
		return "";
	}
	
	protected String targetHint() {
		for(Object element : selection.toList()) {
			if(element instanceof IFile) {
				IFile ifile = (IFile) element;
				if(ifile.getFileExtension().equals(EMX)) {
					return ifile.getLocationURI().toString();
				}
			}
		}
		return "";
	}
}
