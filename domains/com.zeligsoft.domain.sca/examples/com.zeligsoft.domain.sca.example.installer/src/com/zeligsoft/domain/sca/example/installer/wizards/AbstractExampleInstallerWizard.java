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
package com.zeligsoft.domain.sca.example.installer.wizards;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.RenameResourceAction;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.ide.undo.DeleteResourcesOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.eclipse.ui.wizards.datatransfer.ZipFileStructureProvider;

import com.zeligsoft.domain.sca.example.installer.ExampleInstallerPlugin;
import com.zeligsoft.domain.sca.example.installer.l10.Messages;

/**
 * An abstract generic wizard for installing examples from either a directory or
 * a zip file.
 * 
 * @author Toby McClean
 * 
 */
public abstract class AbstractExampleInstallerWizard extends Wizard implements
		INewWizard, IShellProvider {

	protected static final IOverwriteQuery OVERWRITE_ALL_QUERY = new IOverwriteQuery() {
		public String queryOverwrite(String pathString) {
			return IOverwriteQuery.ALL;
		}
	};

	protected IWorkbench workbench;
	protected IStructuredSelection structuredSelection;
	
	protected ProjectPage projectPage;

	/**
	 * Default constructor that initializes the title of the window and indicates
	 * that a progress monitor is necessary.
	 */
	public AbstractExampleInstallerWizard() {
		setNeedsProgressMonitor(true);
		setWindowTitle(Messages.AbstractExampleInstallerWizard_UI_Wizard_title);
	}

	/**
	 * Initialize the members of the class.
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.structuredSelection = selection;
	}

	/**
	 * Returns the project descriptors to be used by this wizard. This
	 * method is called multiple times, so subclasses should cache the information.
	 * 
	 * @return a list of ProjectDescriptors
	 */
	protected abstract java.util.List<ProjectDescriptor> getProjectDescriptors();

	/**
	 * Returns the files to open descriptors that are used by the wizard. This
	 * method is called multiple times, so subclasses should cache the information.
	 * @return
	 */
	protected abstract java.util.List<FileToOpen> getFilesToOpen();

	/**
	 * Returns the title to be used for the page. This method provides a default
	 * value, subclasses should override the method if a different value is
	 * desired.
	 * 
	 * @return A string for the title of the page shown in the wizard.
	 */
	protected String getPageTitle() {
		return Messages.AbstractExampleInstallerWizard_UI_ProjectPage_title;
	}

	/**
	 * Returns the description to be used for the page. This method provides a
	 * default value, subclasses should override the method if a different value
	 * is desired.
	 * 
	 * @return A string for the description of the page shown in the wizard.
	 */
	protected String getPageDescription() {
		return Messages.AbstractExampleInstallerWizard_UI_ProjectPage_description;
	}

	

	@Override
	public void dispose() {
		projectPage = null;
		super.dispose();
	}

	@Override
	public void addPages() {
		projectPage = new ProjectPage("projectPage", getPageTitle(), null); //$NON-NLS-1$
		projectPage.setDescription(getPageDescription());
		addPage(projectPage);
	}

	@Override
	public boolean performFinish() {
		final Exception exceptionWrapper = new Exception();

		try {
			getContainer().run(false, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					monitor
							.beginTask(
									Messages.AbstractExampleInstallerWizard_UI_Task_message,
									3);

					WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
						@Override
						protected void execute(IProgressMonitor monitor)
								throws CoreException,
								InvocationTargetException, InterruptedException {
							Diagnostic diagnostic = deleteExistingProjects(new SubProgressMonitor(
									monitor, 1));
							if (diagnostic.getSeverity() != Diagnostic.OK) {
								exceptionWrapper
										.initCause(new DiagnosticException(
												diagnostic));
								throw new InterruptedException();
							}

							try {
								installExample(monitor);
							} catch (Exception e) {
								exceptionWrapper.initCause(e);
								throw new InterruptedException();
							}
						}
					};
					op.run(new SubProgressMonitor(monitor, 1));

					openFiles(new SubProgressMonitor(monitor, 1));
					monitor.done();
				}
			});

			return true;
		} catch (InterruptedException e) {
			if (exceptionWrapper.getCause() != null) {
				openErrorDialog(
						Messages.AbstractExampleInstallerWizard_UI_Error_message,
						exceptionWrapper.getCause());
			}
		} catch (InvocationTargetException e) {
			ExampleInstallerPlugin.INSTANCE.log(e);
		}

		if (projectPage != null && !projectPage.getControl().isDisposed()) {
			projectPage.refresh();
		}
		return false;
	}

	/**
	 * Helper method which will deleting existing projects in the workspace
	 * when it is necessary.
	 * 
	 * @param monitor The <code>IProgressMonitor</code> to be used during the
	 * deletion process.
	 * 
	 * @return The result of deleting the projects. For example, if the 
	 * deletion was successful.
	 */
	protected Diagnostic deleteExistingProjects(IProgressMonitor monitor) {
		StringBuilder projectNames = new StringBuilder();
		java.util.List<IProject> projects = new ArrayList<IProject>();
		for (ProjectDescriptor projectDescriptor : getProjectDescriptors()) {
			IProject project = projectDescriptor.getProject();
			if (project.exists()) {
				projectNames.append(", '").append(project.getName()) //$NON-NLS-1$
						.append("'"); //$NON-NLS-1$
				projects.add(project);
			}
		}

		if (!projects.isEmpty()) {
			projectNames.delete(0, ", ".length()); //$NON-NLS-1$

			String title = null;
			String message = null;
			if (projects.size() == 1) {
				title = Messages.AbstractExampleInstallerWizard_UI_ConfirmSingleDeletion_title;
				message = NLS
						.bind(
								Messages.AbstractExampleInstallerWizard_UI_ConfirmSingleDeletion_message,
								new String[] { projectNames.toString() });
			} else {
				title = Messages.AbstractExampleInstallerWizard_UI_ConfirmMultipleDeletion_title;
				message = NLS
						.bind(
								Messages.AbstractExampleInstallerWizard_UI_ConfirmMultipleDeletion_message,
								new String[] { projectNames.toString() });
			}

			if (MessageDialog.openConfirm(getShell(), title, message)) {
				DeleteResourcesOperation op = new DeleteResourcesOperation(
						projects.toArray(new IProject[projects.size()]),
						"deleteprojects", true); //$NON-NLS-1$
				try {
					return BasicDiagnostic.toDiagnostic(op.execute(
							new SubProgressMonitor(monitor, 1), null));
				} catch (ExecutionException e) {
					return BasicDiagnostic.toDiagnostic(e);
				}
			} else {
				return Diagnostic.CANCEL_INSTANCE;
			}
		}
		return Diagnostic.OK_INSTANCE;
	}

	/**
	 * Installs the projects described by {@link #getProjectDescriptors}.
	 * 
	 * @param progressMonitor The <code>IProgressMonitor</code> to be used during the
	 * deletion process.
	 * 
	 */
	protected void installExample(IProgressMonitor progressMonitor)
			throws Exception {
		java.util.List<ProjectDescriptor> projectDescriptors = getProjectDescriptors();
		progressMonitor
				.beginTask(
						Messages.AbstractExampleInstallerWizard_UI_Task_CreatingProjects_message,
						2 * projectDescriptors.size());
		for (ProjectDescriptor projectDescriptor : projectDescriptors) {
			installProject(projectDescriptor, progressMonitor);
		}
		progressMonitor.done();
	}

	/**
	 * Opens the files described by {@link #getFilesToOpen}.
	 * 
	 * @param progressMonitor The <code>IProgressMonitor</code> to be used during the
	 * deletion process.
	 */
	protected void openFiles(IProgressMonitor progressMonitor) {
		java.util.List<FileToOpen> filesToOpen = getFilesToOpen();
		if (!filesToOpen.isEmpty()) {
			progressMonitor
					.beginTask(
							Messages.AbstractExampleInstallerWizard_UI_Task_OpeningFiles_message,
							filesToOpen.size());
			for (FileToOpen fileToOpen : filesToOpen) {
				IFile workspaceFile = fileToOpen.getWorkspaceFile();
				if (workspaceFile != null && workspaceFile.exists()) {
					try {
						openEditor(workspaceFile, fileToOpen.getEditorID());
						progressMonitor.worked(1);
					} catch (PartInitException e) {
						ExampleInstallerPlugin.INSTANCE.log(e);
					}
				}
			}
			progressMonitor.done();
		}
	}

	/**
	 * Show an error dialog with the provided message.
	 * 
	 * @param message A message to be shown in the error dialog.
	 * 
	 * @param throwable An exception to be shown in the error dialog.
	 */
	protected void openErrorDialog(String message, Throwable throwable) {
		DiagnosticDialog.open(getShell(),
				Messages.AbstractExampleInstallerWizard_UI_Error_label,
				message, BasicDiagnostic.toDiagnostic(throwable));
	}

	/**
	 * Install the project that is described by the given 
	 * <code>projectDescriptor</code>.
	 * 
	 */
	protected void installProject(ProjectDescriptor projectDescriptor,
			ImportOperation importOperation, IProgressMonitor progressMonitor)
			throws Exception {
		createProject(projectDescriptor, new SubProgressMonitor(
				progressMonitor, 1));
		importOperation.setContext(getShell());
		importOperation.run(new SubProgressMonitor(progressMonitor, 1));
	}

	/**
	 * Create the project that is described by the given 
	 * <code>projectDescriptor</code>.
	 * 
	 * @param projectDescriptor Description of the project to be created.
	 * @param monitor The <code>IProgressMonitor</code> to be used during the
	 * deletion process.
	 * 
	 * @throws CoreException
	 */
	protected void createProject(ProjectDescriptor projectDescriptor,
			IProgressMonitor monitor) throws CoreException {
		monitor
				.beginTask(
						NLS
								.bind(
										Messages.AbstractExampleInstallerWizard_UI_Task_CreateProject_message,
										new String[] { projectDescriptor
												.getName() }), 3);

		IProject project = projectDescriptor.getProject();
		project.create(new SubProgressMonitor(monitor, 1));
		project.open(new SubProgressMonitor(monitor, 1));

		monitor.done();
	}

	/**
	 * Installs the project described by the given
	 * <code>projectDescriptor</code>. This implementation simply looks at the
	 * form of its content URI and delegates to
	 * {@link #installProjectFromDirectory} or {@link #installProjectFromFile},
	 * as appropriate.
	 * 
	 */
	protected void installProject(ProjectDescriptor projectDescriptor,
			IProgressMonitor progressMonitor) throws Exception {
		URI contentURI = projectDescriptor.getContentURI();
		if (contentURI.hasTrailingPathSeparator()) {
			installProjectFromDirectory(projectDescriptor, progressMonitor);
		} else {
			installProjectFromFile(projectDescriptor, progressMonitor);
		}
	}

	/**
	 * Installs the project described by the given
	 * <code>projectDescriptor</code> from a directory. This implementation
	 * should handle the directory scenario completely, but will throw an
	 * exception if the specified directory is not found or readable.
	 * 
	 */
	protected void installProjectFromDirectory(
			ProjectDescriptor projectDescriptor,
			IProgressMonitor progressMonitor) throws Exception {
		URI contentURI = projectDescriptor.getContentURI();
		if (contentURI.isPlatform()) {
			contentURI = CommonPlugin.asLocalURI(contentURI);
		}

		ImportOperation importOperation = null;
		String location = contentURI.toFileString();
		if (location != null) {
			java.io.File directory = new java.io.File(location);
			if (directory.isDirectory() && directory.canRead()) {
				java.util.List<java.io.File> filesToImport = new ArrayList<java.io.File>();
				filesToImport.addAll(Arrays.asList(directory.listFiles()));

				importOperation = new ImportOperation(projectDescriptor
						.getProject().getFullPath(), directory,
						FileSystemStructureProvider.INSTANCE,
						OVERWRITE_ALL_QUERY, filesToImport);
				importOperation.setCreateContainerStructure(false);
			}
		}

		if (importOperation != null) {
			installProject(projectDescriptor, importOperation, progressMonitor);
		} else {
			throw new Exception(
					NLS
							.bind(
									Messages.AbstractExampleInstallerWizard_UI_Error_DirectoryError_message,
									new String[] { contentURI.toString() }));
		}
	}

	/**
	 * Installs the project described by the given
	 * <code>projectDescriptor</code> from a file. This implementation only
	 * handles zip files, throwing an exception otherwise. It may be overridden
	 * to handle other cases.
	 * 
	 */
	protected void installProjectFromFile(ProjectDescriptor projectDescriptor,
			IProgressMonitor progressMonitor) throws Exception {
		URI contentURI = projectDescriptor.getContentURI();
		if (contentURI.isPlatform()) {
			contentURI = CommonPlugin.asLocalURI(contentURI);
		}

		ImportOperation importOperation = null;
		ZipFile zipFile = null;
		try {
			String location = contentURI.toFileString();
			if (location != null) {
				java.io.File file = new java.io.File(location);
				if (file.isFile() && file.canRead()) {
					zipFile = createZipFile(file);
					if (zipFile != null) {
						ZipFileStructureProvider structureProvider = new ZipFileStructureProvider(
								zipFile);
						importOperation = new ImportOperation(projectDescriptor
								.getProject().getFullPath(), structureProvider
								.getRoot(), structureProvider,
								OVERWRITE_ALL_QUERY);
					}
				}
			}

			if (importOperation != null) {
				installProject(projectDescriptor, importOperation,
						progressMonitor);
			} else {
				throw new Exception(
						NLS
								.bind(
										Messages.AbstractExampleInstallerWizard_UI_Error_FileError_message,
										new String[] { contentURI.toString() }));
			}
		} finally {
			if (zipFile != null) {
				try {
					zipFile.close();
				} catch (IOException e) {
					// Ignore.
				}
			}
		}
	}

	/**
	 * Returns a <code>ZipFile</code> for reading from the given file, if it is
	 * in fact a zip file; null otherwise. The client is responsible for closing
	 * the zip file if it is non-null.
	 * 
	 */
	protected ZipFile createZipFile(java.io.File file) {
		try {
			return new ZipFile(file);
		} catch (ZipException e) {
			// Ignore
		} catch (IOException e) {
			// Ignore
		}
		return null;
	}

	/**
	 * Return the current workbench.
	 * @return The current workbench.
	 */
	protected IWorkbench getWorkbench() {
		return workbench;
	}

	/**
	 * Returns the current selection.
	 * @return The current selection.
	 */
	protected IStructuredSelection getSelection() {
		return structuredSelection;
	}

	/**
	 * Open the given <code>file</code> using the editor described
	 * by the provided <code>editorID</code> if no match for the
	 * <code>editorID</code> is found the default editor for the
	 * <code>file</code> will be used.
	 * 
	 * @param file The file to be opened in the editor.
	 * @param editorID The id of the editor to open the file with.
	 * @throws PartInitException
	 */
	protected void openEditor(IFile file, String editorID)
			throws PartInitException {
		IEditorRegistry editorRegistry = getWorkbench().getEditorRegistry();
		if (editorID == null || editorRegistry.findEditor(editorID) == null) {
			editorID = getWorkbench().getEditorRegistry().getDefaultEditor(
					file.getFullPath().toString()).getId();
		}

		IWorkbenchPage page = getWorkbench().getActiveWorkbenchWindow()
				.getActivePage();
		page.openEditor(new FileEditorInput(file), editorID, true,
				IWorkbenchPage.MATCH_ID);
	}

	/**
	 * A class used to describe a project and its contents.
	 * 
	 * @author Toby McClean (tmcclean)
	 *
	 */
	public static class ProjectDescriptor {
		protected String name;
		protected URI contentURI;
		protected String description;

		protected IProject project;

		public URI getContentURI() {
			return contentURI;
		}

		public void setContentURI(URI contentURI) {
			this.contentURI = contentURI;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public IProject getProject() {
			if (project == null) {
				project = ResourcesPlugin.getWorkspace().getRoot().getProject(
						getName());
			}

			return project;
		}
	}

	/**
	 * A class used to describe a file to be opened with a specific editor.
	 * 
	 * @author Toby McClean (tmcclean)
	 *
	 */
	public static class FileToOpen {
		protected String location;
		protected String editorID;

		protected IFile workspaceFile;

		/**
		 * @return the location
		 */
		public String getLocation() {
			return location;
		}

		/**
		 * @param location
		 *            the location to set
		 */
		public void setLocation(String location) {
			this.location = location;
		}

		/**
		 * @return the editorID
		 */
		public String getEditorID() {
			return editorID;
		}

		/**
		 * @param editorID
		 *            the editorID to set
		 */
		public void setEditorID(String editorID) {
			this.editorID = editorID;
		}

		/**
		 * @return the workspaceFile
		 */
		public IFile getWorkspaceFile() {
			if (null == workspaceFile) {
				workspaceFile = ResourcesPlugin.getWorkspace().getRoot()
						.getFile(new Path(getLocation()));
			}
			return workspaceFile;
		}

	}

	/**
	 * A <code>WizardPage</code> that shows the list of projects for
	 * a given example.
	 * 
	 * The page provides a mechanism for renaming projects in the 
	 * <code>Workspace</code> which have the same name as projects
	 * from the example.
	 * 
	 * @author Toby McClean (tmcclean)
	 *
	 */
	public class ProjectPage extends WizardPage {
		protected List projectList;
		protected Text descriptionText;
		protected Button renameButton;

		public ProjectPage(String pageName, String title,
				ImageDescriptor titleImage) {
			super(pageName, title, titleImage);
		}

		public void createControl(Composite parent) {
			SashForm sashForm = new SashForm(parent, SWT.VERTICAL);
			sashForm.setLayoutData(new GridData(GridData.FILL_BOTH
					| GridData.GRAB_VERTICAL));

			projectList = new List(sashForm, SWT.SINGLE | SWT.BORDER);
			projectList.setLayoutData(new GridData(GridData.FILL_BOTH));
			projectList.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					itemSelected();
				}
			});
			projectList.setFocus();

			Composite composite = new Composite(sashForm, SWT.NONE);
			{
				GridLayout layout = new GridLayout(2, false);
				int margin = -5;
				int spacing = 3;
				layout.marginTop = margin;
				layout.marginLeft = margin;
				layout.marginRight = margin;
				layout.marginBottom = margin;
				layout.horizontalSpacing = spacing;
				layout.verticalSpacing = spacing;
				composite.setLayout(layout);
			}

			descriptionText = new Text(composite, SWT.READ_ONLY | SWT.MULTI
					| SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
			{
				GridData gridData = new GridData(GridData.FILL_BOTH);
				gridData.heightHint = convertHeightInCharsToPixels(2);
				gridData.grabExcessVerticalSpace = true;
				descriptionText.setLayoutData(gridData);
			}

			Composite buttonComposite = new Composite(composite, SWT.NONE);

			buttonComposite.setLayoutData(new GridData(
					GridData.VERTICAL_ALIGN_BEGINNING
							| GridData.HORIZONTAL_ALIGN_END));
			buttonComposite.setLayout(new GridLayout());
			{
				GridLayout layout = new GridLayout();
				int margin = -5;
				int spacing = 3;
				layout.marginTop = margin;
				layout.marginLeft = margin;
				layout.marginRight = margin;
				layout.marginBottom = margin;
				layout.horizontalSpacing = spacing;
				layout.verticalSpacing = spacing;
				buttonComposite.setLayout(layout);
			}

			renameButton = new Button(buttonComposite, SWT.PUSH);
			renameButton.setLayoutData(new GridData(
					GridData.HORIZONTAL_ALIGN_BEGINNING
							| GridData.FILL_HORIZONTAL));
			renameButton
					.setText(Messages.AbstractExampleInstallerWizard_UI_Button_Rename_label);
			renameButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					renameExistingProject();
				}
			});
			renameButton.setEnabled(false);

			refresh();
			sashForm.setWeights(new int[] { 70, 30 });
			setControl(sashForm);
		}

		public void refresh() {
			if (getProjectDescriptors().isEmpty()) {
				setErrorMessage(Messages.AbstractExampleInstallerWizard_UI_Error_NoProjectError_message);
				setPageComplete(false);
			} else {
				setErrorMessage(null);

				int selectionIndex = projectList.getSelectionIndex();
				if (selectionIndex < 0) {
					selectionIndex = 0;
				}

				projectList.removeAll();
				for (ProjectDescriptor projectDescriptor : getProjectDescriptors()) {
					String name = projectDescriptor.getName();
					boolean exists = projectDescriptor.getProject().exists();
					String item = exists ? NLS
							.bind(
									Messages.AbstractExampleInstallerWizard_UI_ExistingProjectName_message,
									new String[] { name })
							: name;
					projectList.add(item);

					projectList.setData(item, projectDescriptor);
				}

				if (getControl() != null) {
					projectList.setSelection(selectionIndex);
					itemSelected();
				}

				setPageComplete(true);
			}
		}

		@Override
		public void setVisible(boolean visible) {
			if (visible && projectList.getItemCount() > 0
					&& projectList != null
					&& projectList.getSelectionCount() == 0) {
				int index = 0;
				int count = 0;
				for (ProjectDescriptor projectDescriptor : getProjectDescriptors()) {
					if (projectDescriptor.getProject().exists()) {
						index = count;
						break;
					}
					count++;
				}
				projectList.select(index);
				refresh();
			}
			super.setVisible(visible);
		}

		protected ProjectDescriptor getSelectedProjectDescriptor() {
			return projectList.getSelectionCount() == 0 ? null
					: (ProjectDescriptor) projectList.getData(projectList
							.getSelection()[0]);
		}

		protected void itemSelected() {
			ProjectDescriptor projectDescriptor = getSelectedProjectDescriptor();
			if (projectDescriptor != null) {
				boolean exists = projectDescriptor.getProject().exists();
				renameButton.setEnabled(exists);

				String description = projectDescriptor.getDescription() != null ? projectDescriptor
						.getDescription()
						: ""; //$NON-NLS-1$
				if (exists) {
					String renameMessage = Messages.AbstractExampleInstallerWizard_UI_ProjectRename_message;
					description = description == "" ? renameMessage //$NON-NLS-1$
							: NLS
									.bind(
											Messages.AbstractExampleInstallerWizard_UI_ProjectDescriptionAndRename,
											new String[] { description,
													renameMessage });
				}
				descriptionText.setText(description);
			}
		}

		protected void renameExistingProject() {
			ProjectDescriptor projectDescriptor = getSelectedProjectDescriptor();
			if (projectDescriptor != null
					&& projectDescriptor.getProject().exists()) {
				RenameResourceAction renameResourceAction = new RenameResourceAction(
						AbstractExampleInstallerWizard.this);
				renameResourceAction.selectionChanged(new StructuredSelection(
						projectDescriptor.getProject()));
				renameResourceAction.run();
				projectDescriptor.project = null;
				refresh();
			}
		}
	}
}
