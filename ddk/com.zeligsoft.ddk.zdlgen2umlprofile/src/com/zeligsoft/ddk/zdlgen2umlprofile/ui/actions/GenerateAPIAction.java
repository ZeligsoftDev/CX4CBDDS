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
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Shell;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.CodegenException;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.ICodegenAction;
import com.zeligsoft.ddk.zdlgen2umlprofile.Activator;
import com.zeligsoft.ddk.zdlgen2umlprofile.l10n.ZDLGen2UMLProfileMessages;
import com.zeligsoft.ddk.zdlgen2umlprofile.operations.GenerateAPIOperation;

/**
 * [TODO]
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class GenerateAPIAction 
		implements ICodegenAction {
	
	/**
	 * Instantiate me
	 */
	public GenerateAPIAction() {
		super();
	}

	/**
	 * @param model
	 * @param monitor
	 * @throws InvocationTargetException
	 * @throws InterruptedException
	 */
	private IStatus doGenerateAPI(final Shell shell, final GenDomainModel model) {
		IProgressMonitor monitor = new NullProgressMonitor();
		IStatus result = Status.OK_STATUS;
		GenerateAPIOperation op = 
			new GenerateAPIOperation(
					shell, 
					model);
		try {
			op.run(monitor);
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(model.getApiProject());
			if(project != null && project.exists()) {
			    try {
			        project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
			    } catch (CoreException e) {
			        result = new Status(
			                IStatus.ERROR, 
			                Activator.PLUGIN_ID, 
			                IStatus.OK, 
			                "Exception refreshing project: " + model.getApiProject(), //$NON-NLS-1$
			                e);
			    }
			}
		} catch (InvocationTargetException e) {
			result = new Status(
					IStatus.ERROR, 
					Activator.PLUGIN_ID, 
					IStatus.OK, 
					ZDLGen2UMLProfileMessages.GenerateModelLibraryNamesPopupAction_0,
					e);
		} catch (InterruptedException e) {
			result = new Status(
					IStatus.ERROR, 
					Activator.PLUGIN_ID, 
					IStatus.OK, 
					ZDLGen2UMLProfileMessages.GenerateModelLibraryNamesPopupAction_0,
					e);
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.codegen.ICodegenAction#execute(com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject, java.util.Map)
	 */
	@Override
	public IStatus execute(GenDomainObject genObject,
			Map<Object, Object> context) throws CodegenException {
		IStatus result = null;
		if(genObject instanceof GenDomainModel) {
			Object shellObj = context.get("shell"); //$NON-NLS-1$
			Shell shell = null;
			if(shellObj != null && shellObj instanceof Shell) {
				shell = (Shell) shellObj;
			}
			result = doGenerateAPI(shell, 
				(GenDomainModel) genObject);
		} else {
			result = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"Can only generate the API from a GenDomainModel element."); //$NON-NLS-1$
		}
		return result;
	}
	
	
}
