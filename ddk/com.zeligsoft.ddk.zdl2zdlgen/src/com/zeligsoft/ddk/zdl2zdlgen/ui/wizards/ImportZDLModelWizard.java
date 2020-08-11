/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl2zdlgen.ui.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.ddk.zdl.zdlgen.GenModel;
import com.zeligsoft.ddk.zdl.zdlgen.presentation.ZDLGenEditorPlugin;
import com.zeligsoft.ddk.zdl.zdlgen.util.ZDLGenResource;
import com.zeligsoft.ddk.zdl2zdlgen.Activator;
import com.zeligsoft.ddk.zdl2zdlgen.l10n.ZDL2ZDLGenMessages;

/**
 * The ZDL Model Importer wizard, which converts a ZDL model to ZDLGen or
 * re-loads an existing ZDLGen from the same or a different ZDL model. The first
 * page of the wizard, for selection of the destination ZDL resource, is
 * optional; it is not used when re-loading.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ImportZDLModelWizard
		extends Wizard
		implements INewWizard {

	private ZDLImporter importer = new ZDLImporter();
	
	private ImportZDLModelWizardPage mainPage;

	private ZDLConverterPage converterPage;
	
	private ReferencedModelsPage referencedModelsPage;

	private GenModel reloadModel;

	private IStatus status;
	
	/**
	 * Initializes me.
	 */
	public ImportZDLModelWizard() {
		super();
	}

	@Override
	public boolean performFinish() {
		try {
			final IFile[] newFile = new IFile[1];

			newFile[0] = (getReloadModel() != null)
				? WorkspaceSynchronizer.getFile(getReloadModel().eResource())
				: mainPage.createNewFile();

			getContainer().run(true, false, new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					URI uri = URI.createPlatformResourceURI(newFile[0]
						.getFullPath().toString(), true);
					
					setStatus(importer.convert(uri, getShell(), monitor));
					
					IContainer targetGenFolder = newFile[0].getParent();

					// Refresh the target folder
					try {
						targetGenFolder.refreshLocal(IResource.DEPTH_INFINITE, null);
					} catch (org.eclipse.core.runtime.CoreException e) {
						Log.error(Activator.getDefault(), 0, 
								"Exception trying to refresh workspace",  //$NON-NLS-1$
								e);
					}
					
					if (getStatus().getSeverity() >= IStatus.ERROR) {
						converterPage.getControl().getDisplay().asyncExec(
							new Runnable() {

								@Override
								public void run() {
									ErrorDialog
										.openError(
											getShell(),
											ZDL2ZDLGenMessages.ImportZDLModelWizard_errorDlgTitle,
											getStatus().getMessage(), getStatus());
								}});
						return;
					}

					if (getReloadModel() == null) {
						converterPage.getControl().getDisplay().asyncExec(
							new Runnable() {

								@Override
								public void run() {
									IEditorInput input = new FileEditorInput(
										newFile[0]);
									try {
										PlatformUI.getWorkbench()
											.getActiveWorkbenchWindow()
											.getActivePage().openEditor(input,
												ZDLGenEditorPlugin.EDITOR_ID);
									} catch (PartInitException e) {
										ErrorDialog
											.openError(
												null,
												ZDL2ZDLGenMessages.ImportZDLModelWizard_errorDlgTitle,
												ZDL2ZDLGenMessages.ImportZDLModelWizard_editorNotOpened,
												e.getStatus());
									}
								}
							});
					}
				}
			});
		} catch (InvocationTargetException e) {
			Log.error(Activator.getDefault(), 0, 
					"Exception in ImportZDLModelWizard#performFinish",  //$NON-NLS-1$
					e);
		} catch (InterruptedException e) {
			Log.error(Activator.getDefault(), 0, 
					"Exception in ImportZDLModelWizard#performFinish",  //$NON-NLS-1$
					e);
		}
		return true;
	}
	
	private void setStatus(IStatus status) {
		this.status = status;
	}
	
	/**
	 * Obtains the status of the transformation that I ran, if the user elected
	 * to finish me.
	 * 
	 * @return my transformation status
	 */
	public IStatus getStatus() {
		return status;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		if (getReloadModel() == null) {
			mainPage = new ImportZDLModelWizardPage(selection);
			mainPage
				.setTitle(ZDL2ZDLGenMessages.ImportZDLModelWizard_pageTitle);
			mainPage
				.setDescription(ZDL2ZDLGenMessages.ImportZDLModelWizard_description);
			mainPage.setFileExtension(ZDLGenResource.FILE_EXTENSION);
		}

		converterPage = new ZDLConverterPage(importer);

		if ((getReloadModel() != null) && !getReloadModel().getOwnedModels().isEmpty()) {
			Model sourceModel = getReloadModel().getOwnedModels().get(0).getDomainModel();

			if (sourceModel != null) {
				Resource sourceRes = sourceModel.eResource();
				if (sourceRes != null) {
					converterPage.setSourceModelURI(sourceRes.getURI());
				}
			}
		} else if (!selection.isEmpty()) {
			Object first = selection.getFirstElement();

			if (!(first instanceof IFile)) {
				// try to adapt it
				if (first instanceof IAdaptable) {
					first = ((IAdaptable) first).getAdapter(IResource.class);
				}
			}

			if (first instanceof IFile) {
				IFile file = (IFile) first;

				mainPage.setFileName(computeSuggestedFileName(file));

				if (converterPage.isZDLModel(file)) {
					converterPage.setSourceModelURI(URI
						.createPlatformResourceURI(file.getFullPath()
							.toPortableString(), true));
				}
			}
		}
		
		referencedModelsPage = new ReferencedModelsPage(importer);
	}

	@Override
	public void addPages() {
		super.addPages();

		if (mainPage != null) {
			addPage(mainPage);
		}

		addPage(converterPage);
		addPage(referencedModelsPage);
	}

	private String computeSuggestedFileName(IFile selection) {
		IContainer parent = selection.getParent();

		String baseName = selection.getFullPath().removeFileExtension()
			.lastSegment();
		IPath basePath = new Path(baseName);

		IResource clash = parent.findMember(basePath
			.addFileExtension(ZDLGenResource.FILE_EXTENSION));
		for (int i = 1; clash != null; i++) {
			basePath = new Path(baseName + i);
			clash = parent.findMember(basePath
				.addFileExtension(ZDLGenResource.FILE_EXTENSION));
		}

		return basePath.addFileExtension(ZDLGenResource.FILE_EXTENSION)
			.toString();
	}

	/**
	 * <p>
	 * Configures the wizard for reloading of the specified ZDLGen model
	 * instance. In this mode, the wizard will not show its first page which
	 * specifies the ZDLGen resource to create.
	 * </p>
	 * <p>
	 * This method must be called before the wizard is shown (specifically,
	 * before the Eclipse wizard framework calls {@link IWizard#addPages()}.
	 * </p>
	 * 
	 * @param model
	 *            the existing model to re-load, or <code>null</code> to
	 *            forget a previous setting
	 */
	public void setReloadModel(GenModel model) {
		reloadModel = model;
	}

	/**
	 * Queries the ZDLGen instance that we are re-loading, if any.
	 * 
	 * @return the model to be re-loaded, or <code>null</code> if we are
	 *         creating a new instance
	 */
	public GenModel getReloadModel() {
		return reloadModel;
	}
	
	@Override
	public void dispose() {
		importer.dispose();
		
		super.dispose();
	}
}
