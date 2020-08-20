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

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.CodegenException;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.ICodegenAction;
import com.zeligsoft.ddk.zdlgen2umlprofile.Activator;
import com.zeligsoft.ddk.zdlgen2umlprofile.l10n.ZDLGen2UMLProfileMessages;
import com.zeligsoft.ddk.zdlgen2umlprofile.operations.InitializeMenuModelOperation;

/**
 * 
 * The initialize domain specific menu model action. 
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public class GenerateMenuModelPopupAction
		extends AbstractZDLGenPopupAction
		implements ICodegenAction {

	private static final String TOOLINGMODEL_FILE_EXT = 
		"toolingmodel"; //$NON-NLS-1$
	//private Object myPart;

	private IStatus doAction(Shell shell, GenDomainSpecialization specialization) {
		//if (!validateExternalCrossReferences(specialization)) {
		//	return;
		//}
		
		URI sourceURI = specialization.eResource().getURI();

		String resourceName = specialization.getMenuModelResource();
		if (UML2Util.isEmpty(resourceName)) {
			resourceName = specialization.getName();
		}

		IPath targetFileName = new Path(resourceName).makeAbsolute();
		if (!TOOLINGMODEL_FILE_EXT.equals(targetFileName
			.getFileExtension())) {

			targetFileName = targetFileName.removeFileExtension()
				.addFileExtension(TOOLINGMODEL_FILE_EXT);
		}

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IStatus status = root.getWorkspace().validatePath(
			targetFileName.toString(), IResource.FILE);
		if (status.getSeverity() >= IStatus.ERROR) {
			return status;
		}

		if (!PlatformUI.getWorkbench().saveAllEditors(true)) {
			return Status.CANCEL_STATUS;
		}

		IFile sourceFile = WorkspaceSynchronizer.getFile(specialization
			.eResource());

		URI targetModelURI;
		
		try {
			targetModelURI = getTargetModelURI(shell, specialization, sourceFile,
				targetFileName.toString());
		} catch (CoreException e) {
			
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, 
							ZDLGen2UMLProfileMessages.InitializeMenuModelPopupAction_badFolder_dlgMessage, e);
		}
		
		if (targetModelURI == null) {
			// user canceled container-selection dialog
			return Status.CANCEL_STATUS;
		}
		
		IFile targetFile = getFile(targetModelURI);
		IProject outputProject = targetFile.getProject();
		if (targetFile.exists()
			&& !MessageDialog
				.openConfirm(
					shell,
					ZDLGen2UMLProfileMessages.InitializeMenuModelPopupAction_confirmMergeTitle,
					ZDLGen2UMLProfileMessages.InitializeMenuModelPopupAction_confirmMergePrompt)) {
			return Status.CANCEL_STATUS;
		}

		final Map<String, String> genProperties = new HashMap<String, String>();
		final Map<String, Object> genSlots = new HashMap<String, Object>();

		genProperties.put(InitializeMenuModelOperation.SOURCE_MODEL_URI, sourceURI
			.toString());
		genProperties.put(InitializeMenuModelOperation.SPECIALIZATION_NAME, specialization
			.getName());
		genSlots.put(InitializeMenuModelOperation.TARGET_MODEL_URI, targetModelURI);
		

		final InitializeMenuModelOperation op = new InitializeMenuModelOperation(shell,
			genProperties, genSlots,
			InitializeMenuModelOperation.workflow_path);

		try {
//			IProgressService service = myPart.getSite().getPage()
//				.getWorkbenchWindow().getWorkbench().getProgressService();
//
//			service.busyCursorWhile(new WorkspaceModifyOperation() {
//
//				@Override
//				protected void execute(IProgressMonitor monitor)
//						throws CoreException, InvocationTargetException,
//						InterruptedException {

					op.run(new NullProgressMonitor());
//				}
//			});
		} catch (InvocationTargetException e) {
			Activator.getDefault().getLog().log(
					new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		} catch (InterruptedException e) {
			Activator.getDefault().getLog().log(
					new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}

		// Refresh the output directory
		try {
			outputProject.refreshLocal(IResource.DEPTH_ONE, null);
		} catch (CoreException e) {
			Activator.getDefault().getLog().log(
					new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}

		if (op.getStatus().getSeverity() >= IStatus.ERROR) {
//			ErrorDialog
//				.openError(
//					shell,
//					ZDLGen2UMLProfileMessages.GenerateProfilePopupAction_errorDlgTitle,
//					op.getStatus().getMessage(), op.getStatus());
			return op.getStatus();
		}

		// Open the target profile, if possible, as well as the model libraries
//		if (myPart != null) {
//			IWorkbenchPage page = myPart.getSite().getPage();
//			openEditor(page, targetFile);
//		}
		
		return Status.OK_STATUS;
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.codegen.ICodegenAction#execute(com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject, java.util.Map)
	 */
	@Override
	public IStatus execute(GenDomainObject genObject,
			Map<Object, Object> context) throws CodegenException {
		IStatus result = null;
		if(genObject instanceof GenDomainSpecialization) {
			Object shellObj = context.get("shell"); //$NON-NLS-1$
			Shell shell = null;
			if(shellObj != null && shellObj instanceof Shell) {
				shell = (Shell) shellObj;
			}
			result = doAction(shell, 
				(GenDomainSpecialization) genObject);
		} else {
			result = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"Can only generate the API from a GenDomainSpecialization element."); //$NON-NLS-1$
		}
		return result;
	}

	private URI getTargetModelURI(Shell shell, GenDomainSpecialization specialization,
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
				ZDLGen2UMLProfileMessages.InitializeMenuModelPopupAction_folder_selection_message);

			if (dialog.open() == Window.OK) {
				IPath outputPath = (IPath) dialog.getResult()[0];

				IPath targetPath = outputPath.append(resourceName);
				result = URI.createPlatformResourceURI(targetPath.toString(),
					true);
			}
		}

		return result;
	}
}
