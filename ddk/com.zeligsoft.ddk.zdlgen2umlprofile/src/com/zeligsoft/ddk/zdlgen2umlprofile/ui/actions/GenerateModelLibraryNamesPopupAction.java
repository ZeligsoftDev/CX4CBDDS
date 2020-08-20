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
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.CodegenException;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.ICodegenAction;
import com.zeligsoft.ddk.zdlgen2umlprofile.Activator;
import com.zeligsoft.ddk.zdlgen2umlprofile.l10n.ZDLGen2UMLProfileMessages;
import com.zeligsoft.ddk.zdlgen2umlprofile.operations.GenerateModelLibraryNamesOperation;

/**
 * An action that will generate all of the classes for constants to be used
 * in referring to elements in a generated model library.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class GenerateModelLibraryNamesPopupAction 
		extends AbstractZDLGenPopupAction
		implements ICodegenAction {
	
	/**
	 * Instantiate me
	 */
	public GenerateModelLibraryNamesPopupAction() {
		super();
	}

	/**
	 * @param specialization
	 * @param monitor
	 */
	private IStatus doAction(final Shell shell, final GenDomainSpecialization specialization) {
		final IProgressMonitor monitor = new NullProgressMonitor();
		
		if(!validateExternalCrossReferences(specialization)){
			return Status.CANCEL_STATUS;
		}
		
		String resourceName = specialization.getResourceName();
		if(UML2Util.isEmpty(resourceName)){
			resourceName = specialization.getName();
		}
		
		String projectName = specialization.getPluginName();
		String packageName = specialization.getModelLibraryNamesPackage();
		String srcFolderName = specialization.getModelLibrarySourceFolder();
		
		
		try {
			IProject project = ProjectFactory.INSTANCE
				.getProject(projectName, monitor, true);
			
			if (!PlatformUI.getWorkbench().saveAllEditors(true)) {
				return Status.CANCEL_STATUS;
			}

			GenerateModelLibraryNamesOperation op = 
				new GenerateModelLibraryNamesOperation(
						shell, 
						specialization, 
						project, 
						srcFolderName, 
						packageName);
			op.run(monitor);
			project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		} catch (InvocationTargetException e) {
			return new Status(
					IStatus.ERROR, 
					Activator.PLUGIN_ID, 
					IStatus.OK, 
					ZDLGen2UMLProfileMessages.GenerateModelLibraryNamesPopupAction_0,
					e);
		} catch (InterruptedException e) {
			return new Status(
					IStatus.ERROR, 
					Activator.PLUGIN_ID, 
					IStatus.OK, 
					ZDLGen2UMLProfileMessages.GenerateModelLibraryNamesPopupAction_0,
					e);
		} catch (CoreException e) {
			return e.getStatus();
		}
		
		return Status.OK_STATUS;
	}
	
	/* (non-Javadoc)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.codegen.ICodegenAction#execute(com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject, java.util.Map)
	 */
	@Override
	public IStatus execute(GenDomainObject genObject,
			Map<Object, Object> context) throws CodegenException {
		if(genObject instanceof GenDomainSpecialization) {
			Object shellObj = context.get("shell"); //$NON-NLS-1$
			Shell theShell = null;
			if(shellObj != null) {
				theShell = (Shell) shellObj;
			}
			return doAction(theShell,
					(GenDomainSpecialization) genObject);
		} else {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, 
					"Can only execute the Generate Model Library Names for a GenDomainSpecialization."); //$NON-NLS-1$
		}
	}

	/**
	 * An internal class for finding the project to generate the model library
	 * constants to. If it does not exist it will create one.
	 * 
	 * @author Toby McClean (tmcclean)
	 *
	 */
	public static class ProjectFactory {
		
		/**
		 * There is no state so we only need a single instance.
		 */
		public static final ProjectFactory INSTANCE = new ProjectFactory();
		
		/**
		 * Initialize me
		 */
		private ProjectFactory() {
			// do nothing
		}
		
		/**
		 * Find the project in the current workspace specified by the name
		 * provided. It will create the project if it doesn't exist when
		 * directed to by the client.
		 * 
		 * @param projectName
		 * 		The name of the project we are looking for
		 * @param progressMonitor
		 * 		The monitor to be used
		 * @param create
		 * 		If true and the project doesn't exist it will be created.
		 * @return
		 * 		The project that is being looked for or null if it doesn't
		 * 		exist and create was false.
		 * @throws CoreException 
		 */
		public IProject getProject(String projectName, IProgressMonitor progressMonitor,
				boolean create) throws CoreException{
			
			// allocate a default progress monitor if one is not passed in
			IProgressMonitor monitor = progressMonitor;
			if(monitor == null) {
				monitor = new NullProgressMonitor();
			}
			
			IProject project = findProject(projectName);
			
			if(project == null) {
				return null;
			}
			
			// if the project already exists return it
			if(project.exists()){
				return project;
			} else if(create) {
				project = createProject(project, monitor);
			}
			
			return project;
		}
		
		/**
		 * Retrieves the project from the workspace
		 * 
		 * @param projectName
		 * @return
		 */
		private IProject findProject(String projectName) {
			return ResourcesPlugin
						.getWorkspace()
							.getRoot()
								.getProject(projectName);
		}
		
		/**
		 * Helper function to create the necessary type of project to contain
		 * the generated names constants.
		 * 
		 * @param project
		 * 		The project to be created
		 * @param monitor
		 * 		The progress monitor to be used
		 * @return
		 * 		The project that has been created
		 * @throws CoreException 
		 */
		private IProject createProject(IProject project, IProgressMonitor monitor) 
			throws CoreException {
			project.create(monitor);
			project.open(monitor);
			
			IProjectDescription description = project.getDescription();
			String[] natures 
				= {"org.eclipse.pde.PluginNature",  //$NON-NLS-1$
					JavaCore.NATURE_ID};
			description.setNatureIds(natures);
			project.setDescription(description, monitor);
			
			return project;
		}
		
	}
}
