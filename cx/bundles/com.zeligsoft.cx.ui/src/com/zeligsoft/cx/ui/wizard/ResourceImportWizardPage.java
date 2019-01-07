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

package com.zeligsoft.cx.ui.wizard;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.FileSystemElement;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.model.WorkbenchViewerComparator;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.IImportStructureProvider;

import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.cx.ui.wizard.internal.MinimizedFileSystemElement;
import com.zeligsoft.cx.ui.wizard.internal.ResourceTreeAndListGroup;

public class ResourceImportWizardPage extends WizardPage implements Listener {

	private static final String EMX = "emx"; //$NON-NLS-1$

	private static final int SIZING_TEXT_FIELD_WIDTH = 250;

	List<String> fileExtensions = new Vector<String>();

	private ResourceTreeAndListGroup fileSelectionGroup;

	private Text sourceFolderText;

	private Button sourceBrowseButton;

	private Text targetNameText;

	private Button targetBrowseButton;

	private String targetName = null;

	private String sourceFolderName = null;
	
	private IDialogSettings dialogSettings = ZeligsoftCXUIPlugin.getDefault()
	.getDialogSettings();
	
	protected String rootDirectoryDialogSettingKey = "ResourceImportRootDirectoryText"; //$NON-NLS-1$
	
	protected String targetModelDialogSettingKey = "ResourceImportTargetModelText"; //$NON-NLS-1$


	/**
	 * Constructor
	 */
	public ResourceImportWizardPage(String name, IWorkbench aWorkbench,
			String title, String description) {
		super(name);
		setTitle(title);
		setDescription(description);
	}

	public void setRootDirectoryDialogSettingKey(String key){
		rootDirectoryDialogSettingKey = key;
	}
	
	public void setTargetModelDialogSettingKey(String key){
		targetModelDialogSettingKey = key;
	}
	
	/**
	 * Set the file extensions of the selectable file types.
	 * 
	 * @param List
	 *            <String> fileExtensions
	 */
	public void setFileExtensions(List<String> fileExtensions) {
		this.fileExtensions = fileExtensions;
	}

	/**
	 * Return true if the extension is a selectable file type.
	 * 
	 * @param String
	 *            extension
	 * @return boolean isValidExtension
	 */
	protected boolean isValidExtension(String extension) {
		return fileExtensions.contains(extension);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createControl(Composite parent) {

		if(dialogSettings.get(rootDirectoryDialogSettingKey) != null & sourceFolderName == null){
			sourceFolderName = dialogSettings.get(rootDirectoryDialogSettingKey);
		}
		if(dialogSettings.get(targetModelDialogSettingKey) != null & targetName == null){
			targetName = dialogSettings.get(targetModelDialogSettingKey);
		}
		
		initializeDialogUnits(parent);

		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		composite.setSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		composite.setFont(parent.getFont());

		doCreateControl(composite);
		resetSelection();

		setPageComplete(determinePageCompletion());
		setControl(composite);

	}

	/**
	 * Compose controls
	 * 
	 * @param composite
	 */
	protected void doCreateControl(Composite composite) {
		createSourceGroup(composite);
		createDestinationModelGroup(composite);
	}

	/**
	 * Create the source widget group.
	 * 
	 * @param Composite
	 *            parent
	 */
	protected void createSourceGroup(Composite parent) {
		createRootDirectoryGroup(parent);
		createFileSelectionGroup(parent);
	}

	/**
	 * Create the file selection widget group.
	 * 
	 * @param Composite
	 *            parent
	 */
	protected void createFileSelectionGroup(Composite parent) {

		fileSelectionGroup = new ResourceTreeAndListGroup(
				parent,
				new FileSystemElement("empty", null, true),//$NON-NLS-1$
				getFolderProvider(), new WorkbenchLabelProvider(),
				getFileProvider(), new WorkbenchLabelProvider(), SWT.NONE, true);

		ICheckStateListener listener = new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				setPageComplete(determinePageCompletion());
			}
		};

		WorkbenchViewerComparator comparator = new WorkbenchViewerComparator();
		fileSelectionGroup.setTreeComparator(comparator);
		fileSelectionGroup.setListComparator(comparator);
		fileSelectionGroup.addCheckStateListener(listener);

	}

	/**
	 * Create the root folder widget group.
	 * 
	 * @param Composite
	 *            parent
	 */
	protected void createRootDirectoryGroup(Composite parent) {
		Composite sourceContainerGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		sourceContainerGroup.setLayout(layout);
		sourceContainerGroup.setFont(parent.getFont());
		sourceContainerGroup.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));

		Label groupLabel = new Label(sourceContainerGroup, SWT.NONE);
		groupLabel
				.setText(Messages.ResourceImportWizardPage_SourceFolderTextLabel);
		groupLabel.setFont(parent.getFont());

		// source name entry field
		sourceFolderText = new Text(sourceContainerGroup, SWT.BORDER);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		sourceFolderText.setLayoutData(data);
		sourceFolderText.setFont(parent.getFont());

		if (sourceFolderName != null) {
			sourceFolderText.setText(sourceFolderName);
		}
		sourceFolderText.addListener(SWT.Modify, this);

		// source browse button
		sourceBrowseButton = new Button(sourceContainerGroup, SWT.PUSH);
		sourceBrowseButton
				.setText(Messages.ResourceImportWizardPage_BrowseButtonLabel);
		sourceBrowseButton.addListener(SWT.Selection, this);
		sourceBrowseButton.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_FILL));
		sourceBrowseButton.setFont(parent.getFont());
		setButtonLayoutData(sourceBrowseButton);
	}

	/**
	 * Create the target model widgets group.
	 * 
	 * @param Composite
	 *            parent
	 */
	protected void createDestinationModelGroup(Composite parent) {
		// container specification group
		Composite containerGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		containerGroup.setLayout(layout);
		containerGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		containerGroup.setFont(parent.getFont());

		// container label
		Label resourcesLabel = new Label(containerGroup, SWT.NONE);
		resourcesLabel
				.setText(Messages.ResourceImportWizardPage_TargetModelTextLabel);
		resourcesLabel.setFont(parent.getFont());

		// container name entry field
		targetNameText = new Text(containerGroup, SWT.SINGLE | SWT.BORDER);
		targetNameText.addListener(SWT.Modify, this);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		targetNameText.setLayoutData(data);
		targetNameText.setFont(parent.getFont());

		if (targetName != null) {
			targetNameText.setText(targetName);
		}
		targetNameText.addListener(SWT.Modify, this);

		// container browse button
		targetBrowseButton = new Button(containerGroup, SWT.PUSH);
		targetBrowseButton
				.setText(Messages.ResourceImportWizardPage_BrowseButtonLabel);
		targetBrowseButton.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_FILL));
		targetBrowseButton.addListener(SWT.Selection, this);
		targetBrowseButton.setFont(parent.getFont());
		setButtonLayoutData(targetBrowseButton);
	}

	/**
	 * Create a dummy root file sytem element.
	 * 
	 * @param Object
	 *            fileSystemObject
	 * @param IImportStructureProvider
	 *            provider
	 * @return MinimizedFileSystemElement fileSystemElement
	 */
	protected MinimizedFileSystemElement createEmptyRootElement(
			Object fileSystemObject, IImportStructureProvider provider) {

		boolean isContainer = provider.isFolder(fileSystemObject);
		String elementLabel = provider.getLabel(fileSystemObject);

		// Use an empty label so that display of the element's full name
		// doesn't include a confusing label
		MinimizedFileSystemElement emptyFileSystemElement = new MinimizedFileSystemElement(
				"", null, true);//$NON-NLS-1$
		emptyFileSystemElement.setPopulated();
		MinimizedFileSystemElement result = new MinimizedFileSystemElement(
				elementLabel, emptyFileSystemElement, isContainer);
		result.setFileSystemObject(fileSystemObject);

		// Get the files for the element so as to build the first level
		result.getFiles(provider);

		return emptyFileSystemElement;
	}

	/**
	 * Return isPageComplete
	 * 
	 * @return boolean isPageComplete
	 */
	public boolean finish() {
		return determinePageCompletion();
	}

	/**
	 * Get the selected file system objects.
	 * 
	 * @return List<Object> fileSystemObjects
	 */
	@SuppressWarnings("rawtypes")
	public List<Object> getFileSystemObjects() {
		Iterator resourcesEnum = fileSelectionGroup.getAllCheckedListItems()
				.iterator();
		List<Object> fileSystemObjects = new ArrayList<Object>();
		while (resourcesEnum.hasNext()) {
			fileSystemObjects.add(((FileSystemElement) resourcesEnum.next())
					.getFileSystemObject());
		}
		return fileSystemObjects;
	}

	/**
	 * Return file path list
	 * 
	 * @return
	 */
	public ArrayList<String> getSelectedFileList() {
		ArrayList<String> pathList = new ArrayList<String>();
		final List<Object> fileSystemObjects = getFileSystemObjects();
		for (int i = 0; i < fileSystemObjects.size(); i++) {
			Object fileObject = fileSystemObjects.get(i);
			File file = (File) fileObject;
			pathList.add(file.getAbsolutePath());
		}
		return pathList;
	}

	/**
	 * Get the target model string representation.
	 * 
	 * @return String target model
	 */
	public String getTargetModel() {
		URI uri = getTargetModelURI();
		if (uri == null) {
			return null;
		}
		return uri.toPlatformString(false);
	}

	/**
	 * Get file provider.
	 * 
	 * @return ITreeContentProvider treeContentProvider
	 */
	protected ITreeContentProvider getFileProvider() {
		return new WorkbenchContentProvider() {

			@Override
			public Object[] getChildren(Object o) {
				if (o instanceof MinimizedFileSystemElement) {
					MinimizedFileSystemElement element = (MinimizedFileSystemElement) o;
					Object[] objects = element.getFiles(
							FileSystemStructureProvider.INSTANCE).getChildren(
							element);

					ArrayList<Object> filteredList = new ArrayList<Object>();
					for (int x = 0; x < objects.length; x++) {
						Object object = objects[x];
						if (object instanceof FileSystemElement) {
							FileSystemElement fileElement = (FileSystemElement) object;
							String extension = fileElement
									.getFileNameExtension();

							if (isValidExtension(extension)) {
								filteredList.add(object);
							}
						}
					}

					return filteredList.toArray();
				}
				return new Object[0];
			}
		};
	}

	/**
	 * Get the FileSystemTree for the selected source directory.
	 * 
	 * @return MinimizedFileSystemElement fileSystemElement
	 */
	protected MinimizedFileSystemElement getFileSystemTree() {

		File sourceDirectory = getSourceDirectory();
		if (sourceDirectory == null) {
			return null;
		}

		return selectFiles(sourceDirectory,
				FileSystemStructureProvider.INSTANCE);
	}

	/**
	 * Get the tree content folder provider.
	 * 
	 * @return ITreeContentProvider treeContentProvider
	 */
	protected ITreeContentProvider getFolderProvider() {
		return new WorkbenchContentProvider() {

			@Override
			public Object[] getChildren(Object o) {
				if (o instanceof MinimizedFileSystemElement) {
					MinimizedFileSystemElement element = (MinimizedFileSystemElement) o;
					return element.getFolders(
							FileSystemStructureProvider.INSTANCE).getChildren(
							element);
				}
				return new Object[0];
			}

			@Override
			public boolean hasChildren(Object o) {
				if (o instanceof MinimizedFileSystemElement) {
					MinimizedFileSystemElement element = (MinimizedFileSystemElement) o;
					if (element.isPopulated()) {
						return getChildren(element).length > 0;
					}

					// If we have not populated then wait until asked
					return true;
				}
				return false;
			}
		};
	}

	/**
	 * Get the source directory.
	 * 
	 * @return File sourceDirectory
	 */
	protected File getSourceDirectory() {
		File sourceDirectory = new File(getSourceDirectoryName());
		if (!sourceDirectory.exists() || !sourceDirectory.isDirectory()) {
			return null;
		}
		return sourceDirectory;
	}

	/**
	 * Get the source directory name as OSString
	 * 
	 * @return String source directory name
	 */
	protected String getSourceDirectoryName() {
		String sourceDirectory = sourceFolderText.getText();
		IPath result = new Path(sourceDirectory.trim());

		if (result.getDevice() != null && result.segmentCount() == 0) {
			result = result.addTrailingSeparator();
		} else {
			result = result.removeTrailingSeparator();
		}
		return result.toOSString();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.
	 * Event)
	 */
	@Override
	public void handleEvent(Event event) {
		if (event.widget == sourceBrowseButton) {
			handleSourceBrowseButtonPressed();
		} else if (event.widget == targetBrowseButton) {
			handleTargetBrowseButtonPressed();
		} else if (event.widget == targetNameText) {
			dialogSettings.put(targetModelDialogSettingKey, targetNameText.getText());
		} else if (event.widget == sourceFolderText) {
			dialogSettings.put(rootDirectoryDialogSettingKey, sourceFolderText.getText());
		}
	}

	/**
	 * Handle the source browse button pressed.
	 */
	protected void handleSourceBrowseButtonPressed() {

		IContainer[] containers = WorkspaceResourceDialog.openFolderSelection(
				getShell(),
				Messages.ResourceImportWizardPage_SourceFolderDialogTitle,
				Messages.ResourceImportWizardPage_SourceFolderDialogDesc,
				false, null, null);

		if (containers.length != 1) {
			return;
		}

		IContainer selectedContainer = containers[0];
		if (selectedContainer != null) {
			// Just quit if the directory is not valid
			// If it is valid then proceed to populate
			setSourceName(selectedContainer.getLocationURI().getPath());
		}
		setPageComplete(determinePageCompletion());
	}

	/**
	 * The source selection has changed, need to refresh the file selection
	 * group tree.
	 */
	protected void resetSelection() {
		MinimizedFileSystemElement currentRoot = getFileSystemTree();
		fileSelectionGroup.setRoot(currentRoot);
	}

	/**
	 * Select files.
	 * 
	 * @param Object
	 *            rootFileSystemObject
	 * @param IImportStructureProvider
	 *            structureProvider
	 * @return MinimizedFileSystemElement fileSystemElement
	 */
	protected MinimizedFileSystemElement selectFiles(
			final Object rootFileSystemObject,
			final IImportStructureProvider structureProvider) {

		final MinimizedFileSystemElement[] results = new MinimizedFileSystemElement[1];

		BusyIndicator.showWhile(getShell().getDisplay(), new Runnable() {

			@Override
			public void run() {
				// Create the root element from the supplied file system object
				results[0] = createEmptyRootElement(rootFileSystemObject,
						structureProvider);
			}
		});

		return results[0];
	}

	public void setSourceName(String path) {
		if (path == null)
			return;
		sourceFolderName = path;
		if (sourceFolderText != null) {
			this.sourceFolderText.setText(path);
			resetSelection();
		}
	}

	/**
	 * Handle the target browse button pressed.
	 */
	protected void handleTargetBrowseButtonPressed() {
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

		IFile[] result = WorkspaceResourceDialog.openFileSelection(getShell(),
				Messages.ResourceImportWizardPage_TargetModelBrowseDialogTitle,
				Messages.ResourceImportWizardPage_TargetModelBrowseDialogDesc,
				false, null, Collections.singletonList(filter));

		if (result.length != 1) {
			return; // TODO exception handling
		}

		IFile file = result[0];
		targetNameText.setText(file.getFullPath().toPortableString());
		setPageComplete(determinePageCompletion());

	}

	/**
	 * Return true if the page is complete. Else, return false and set
	 * appropriate error messages.
	 * 
	 * @return boolean isPageComplete
	 */
	protected boolean determinePageCompletion() {

		if (getSourceDirectory() == null) {
			setErrorMessage(Messages.ResourceImportWizardPage_InvalidSourceFolderError);
			return false;
		} else if (fileSelectionGroup.getAllCheckedListItems().size() < 1) {
			setErrorMessage(Messages.ResourceImportWizardPage_InvalidFileSelectionError);
			return false;
		} else if (getTargetModel() == null || getTargetModel().isEmpty()) {
			setErrorMessage(Messages.ResourceImportWizardPage_InvalidTargetModelError);
			return false;
		}

		setErrorMessage(null);
		return true;
	}

	/**
	 * Get the target model URI
	 * 
	 * @return URI targetModelURI
	 */
	public URI getTargetModelURI() {

		String targetName = targetNameText.getText();
		if (targetName == null || targetName.isEmpty()) {
			return null;
		}
		return URI.createPlatformResourceURI(targetNameText.getText(), false);
	}

	/**
	 * Set target model name
	 * 
	 * @param targetModelName
	 */
	public void setTargetName(String targetModelName) {
		if (targetModelName == null)
			return;
		targetName = targetModelName;
		if (targetNameText != null) {
			targetNameText.setText(targetName);
		}
	}

}
