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
package com.zeligsoft.ddk.zdlgen2umlprofile.ui.actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypesConfigurationsFactory;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.ui.util.EditorUtils;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.progress.IProgressService;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.CodegenException;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.ICodegenAction;
import com.zeligsoft.ddk.zdlgen2umlprofile.Activator;
import com.zeligsoft.ddk.zdlgen2umlprofile.l10n.ZDLGen2UMLProfileMessages;
import com.zeligsoft.ddk.zdlgen2umlprofile.operations.GenerateOperation;

/**
 * 
 * The generate ZDLGen to UMLProfile transformation action. Which prompts the
 * user for the target directory of the transformation. It also sets up all of
 * the properties required by the generate operation.
 * 
 * @author tmcclean
 * 
 */
public class GenerateProfilePopupAction
		extends AbstractZDLGenPopupAction
		implements ICodegenAction {

	/**
	 * @param specialization
	 */
	private IStatus doAction(final IWorkbenchPart part, 
			final Shell shell, final GenDomainSpecialization specialization) {
		if (!validateExternalCrossReferences(specialization)) {
			return Status.CANCEL_STATUS;
		}
		
		URI sourceURI = specialization.eResource().getURI();

		String resourceName = specialization.getResourceName();
		if (UML2Util.isEmpty(resourceName)) {
			resourceName = specialization.getName();
		}

		IPath targetFileName = new Path(resourceName).makeAbsolute();
		if (!UMLResource.FILE_EXTENSION.equals(targetFileName
			.getFileExtension())) {

			targetFileName = targetFileName.removeFileExtension()
				.addFileExtension(UMLResource.FILE_EXTENSION);
		}

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IStatus status = root.getWorkspace().validatePath(
			targetFileName.toString(), IResource.FILE);
		if (status.getSeverity() >= IStatus.ERROR) {
			return new Status(
					IStatus.ERROR, 
					Activator.PLUGIN_ID, 
					ZDLGen2UMLProfileMessages.GenerateProfilePopupAction_badFileName_dlgMessage);
			
		}

		if (!PlatformUI.getWorkbench().saveAllEditors(true)) {
			return Status.CANCEL_STATUS;
		}

		IFile sourceFile = WorkspaceSynchronizer.getFile(specialization
			.eResource());

		URI targetProfileURI;
		
		try {
			targetProfileURI = getTargetProfileURI(shell, specialization, sourceFile,
				targetFileName.toString());
		} catch (CoreException e) {
			return new Status(
					IStatus.ERROR, 
					Activator.PLUGIN_ID, 
					ZDLGen2UMLProfileMessages.GenerateProfilePopupAction_badFolder_dlgMessage, e);
		}
		
		if (targetProfileURI == null) {
			// user canceled container-selection dialog
			return Status.CANCEL_STATUS;
		}
		
		IFile targetFile = getFile(targetProfileURI);
		IProject outputProject = targetFile.getProject();
		if (targetFile.exists()
			&& !MessageDialog
				.openConfirm(
					shell,
					ZDLGen2UMLProfileMessages.GenerateProfilePopupAction_confirmMergeTitle,
					ZDLGen2UMLProfileMessages.GenerateProfilePopupAction_confirmMergePrompt)) {
			return Status.CANCEL_STATUS;
		}

		List<URI> targetModelLibraryURIs;
		try {
			targetModelLibraryURIs = getTargetModelLibraryURIs(specialization,
				outputProject);
		} catch (CoreException e) {
			return new Status(
					IStatus.ERROR, 
					Activator.PLUGIN_ID, 
					ZDLGen2UMLProfileMessages.GenerateProfilePopupAction_badFolder_dlgMessage, e);
		}

		final Map<String, String> genProperties = new HashMap<String, String>();
		final Map<String, Object> genSlots = new HashMap<String, Object>();

		genProperties.put(GenerateOperation.SOURCE_MODEL_URI, sourceURI
			.toString());
		genProperties.put(GenerateOperation.SPECIALIZATION_NAME, specialization
			.getName());
		genSlots.put(GenerateOperation.TARGET_PROFILE_URI, targetProfileURI);
		genSlots.put(GenerateOperation.TARGET_MODEL_LIBRARY_URIS,
			targetModelLibraryURIs);

		final GenerateOperation op = new GenerateOperation(shell,
			genProperties, genSlots,
			GenerateOperation.zdlgen2umlprofile_workflow);

		try {
			
			if(part != null) {
				IProgressService service = part.getSite().getPage().getWorkbenchWindow().getWorkbench().getProgressService();
				service.busyCursorWhile(new WorkspaceModifyOperation() {
					@Override
					protected void execute(IProgressMonitor monitor)
							throws CoreException, InvocationTargetException,
							InterruptedException {
						op.run(monitor);
					}
				});
			} else {
				final IProgressMonitor monitor = new NullProgressMonitor();
				op.run(monitor);
			}
		} catch (InvocationTargetException e) {
			return new Status(
					IStatus.ERROR, 
					Activator.PLUGIN_ID, 
					e.getMessage(), e);
		} catch (InterruptedException e) {
			return new Status(
					IStatus.ERROR, 
					Activator.PLUGIN_ID, 
					e.getMessage(), e);
		}

		// Refresh the output directory
		try {
			outputProject.refreshLocal(IResource.DEPTH_ONE, null);
		} catch (CoreException e) {
			return e.getStatus();
		}

		if (op.getStatus().getSeverity() >= IStatus.ERROR) {
			return new Status(
					IStatus.ERROR, 
					Activator.PLUGIN_ID, 
					op.getStatus().getMessage());
		}

		// Open the target profile, if possible, as well as the model libraries
		if (part != null) {
			IWorkbenchPage page = BaseUIUtil.getActivepage();
			//open profile in papyrus editor and generate element types
			try {
				page.openEditor(new FileEditorInput(targetFile), "org.eclipse.papyrus.infra.core.papyrusEditor", true,
						IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);
				
				IMultiDiagramEditor editor = EditorUtils.getMultiDiagramEditor();
				ServicesRegistry serviceRegistry = editor.getAdapter(ServicesRegistry.class);
				ModelSet modelSet = ServiceUtils.getInstance().getModelSet(serviceRegistry);
				Profile profile = UML2Util.load(modelSet, targetProfileURI, UMLPackage.Literals.PROFILE);
				if(profile != null) {
					ResourceSet rset = new ResourceSetImpl();
					Resource umlElementType = rset.getResource(URI.createURI("platform:/plugin/org.eclipse.papyrus.uml.service.types/model/uml.elementtypesconfigurations"), true);
					com.zeligsoft.ddk.zdlgen2umlprofile.xtend.MainTransform translator = new com.zeligsoft.ddk.zdlgen2umlprofile.xtend.MainTransform();
					String configPath = specialization.getElementtypeConfigurationContainerUri();
					Resource resource = rset.getResource(URI.createURI(configPath + profile.getName() + ".elementtypesconfigurations"), true);
					ElementTypeSetConfiguration config;
					if(resource.getContents().isEmpty()) {
						config = ElementTypesConfigurationsFactory.eINSTANCE.createElementTypeSetConfiguration();
						resource.getContents().add(config);
					}else {
						config = (ElementTypeSetConfiguration) resource.getContents().get(0);
					}
					translator.mainTransform(profile, (ElementTypeSetConfiguration)umlElementType.getContents().get(0), config);
					try {
						resource.save(Collections.EMPTY_MAP);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				//do nothing
			}
		}
		

		return Status.OK_STATUS;
	}

	private URI getTargetProfileURI(final Shell shell, GenDomainSpecialization specialization,
			IFile sourceFile, String resourceName) throws CoreException {
		URI result = null;

		String plugin = specialization.getPluginName();
		if (!UML2Util.isEmpty(plugin)) {
			result = URI.createPlatformResourceURI(plugin, true);
			IPath path = new Path(resourceName);
			for (String seg : path.segments()) {
				result = result.appendSegment(URI.encodeSegment(seg, false));
			}
			
			ensurePath(result);
		} else {
			// prompt the user for a container
			IContainer initialSelection = sourceFile.getParent();

			ContainerSelectionDialog dialog = new ContainerSelectionDialog(
				shell,
				initialSelection,
				true,
				ZDLGen2UMLProfileMessages.GenerateProfilePopupAction_folder_selection_message);

			if (dialog.open() == Window.OK) {
				IPath outputPath = (IPath) dialog.getResult()[0];

				IPath targetPath = outputPath.append(resourceName);
				result = URI.createPlatformResourceURI(targetPath.toString(),
					true);
			}
		}

		return result;
	}

	private List<URI> getTargetModelLibraryURIs(
			GenDomainSpecialization specialization, IProject project) throws CoreException {

		List<URI> result = new java.util.ArrayList<URI>(specialization
			.getDomainModelLibraries().size());

		for (GenDomainModelLibraryReference ref : specialization
			.getDomainModelLibraries()) {
			String resourceName = ref.getResourceName();
			if (UML2Util.isEmpty(resourceName)) {
				resourceName = ref.getTarget().getName();
			}

			IPath targetFileName = new Path(resourceName);
			if (!UMLResource.FILE_EXTENSION.equals(targetFileName
				.getFileExtension())) {

				targetFileName = targetFileName.removeFileExtension()
					.addFileExtension(UMLResource.FILE_EXTENSION);
			}
			
			targetFileName = project.getFullPath().append(targetFileName);
			
			URI uri = URI.createPlatformResourceURI(targetFileName.toString(),
				true);
			ensurePath(uri);
			result.add(uri);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.codegen.ICodegenAction#execute(com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject, java.util.Map)
	 */
	@Override
	public IStatus execute(GenDomainObject genObject,
			Map<Object, Object> context) throws CodegenException {
		if(genObject instanceof GenDomainSpecialization) {
			return doAction(getActivePart(context), getShell(context),
					(GenDomainSpecialization) genObject);
		} else {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, 
					"Can only execute the generate profile for a GenDomainSpecialization."); //$NON-NLS-1$
		}
	}
}
