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
package com.zeligsoft.ddk.zdlgen2umlprofile.operations;


import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;

import com.google.common.base.Strings;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdlgen2umlprofile.Activator;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.DDKAPIGenerator;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.JavaCodeFormatter;

/**
 * [TODO]
 * 
 * @author Toby McClean
 *
 */
public class GenerateAPIOperation implements
		IRunnableWithProgress {

	
	/**
	 * Set of constants for the name of properties in the workflow
	 */
	public static final String MODEL_URI_STRING = "sourceModelURI"; //$NON-NLS-1$
	public static final String SRC_GEN = "src-gen"; //$NON-NLS-1$
	public static final String SOURCE_MODEL = "sourceModel"; //$NON-NLS-1$
	public static final String PACKAGE_NAME = "packageName"; //$NON-NLS-1$
	public static final String SPECIALIZATION = "specialization"; //$NON-NLS-1$
	
	private Shell shell;
	private GenDomainModel model;

	/**
	 * Initialize me
	 */
	public GenerateAPIOperation(Shell shell, 
			GenDomainModel model) {
		this.shell = shell;
		this.model = model;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {

		String apiProject = model.getApiProject();
	    
	    if(Strings.isNullOrEmpty(apiProject)) {
	        throw new IllegalArgumentException("The API project setting on a GenDomainModel, can not be empty or null"); //$NON-NLS-1$
	    }
	    
	    IProject project = null;
	    try {
	        project = APIProjectFactory.INSTANCE
                .getProject(apiProject, monitor, true);
            
        } catch (CoreException e) {
            Activator.log(new Status(IStatus.ERROR, 
                    Activator.PLUGIN_ID,
                    IStatus.OK,
                    "Error creating the Static API project", e)); //$NON-NLS-1$
        }
		
	    Injector injector = Guice.createInjector(new GenerateAPIModule(
                model.getRootPackage(), 
                model.getImplementationSubPackage(), 
                model.getImplSuffix(), 
                "api-gen", //$NON-NLS-1$
                apiProject)); 
		DDKAPIGenerator generator = injector.getInstance(DDKAPIGenerator.class);
		injector.injectMembers(generator);
		
		
		generator.doGenerate(model);
		
		try {
		    project.refreshLocal(IResource.DEPTH_INFINITE, null);
		    JavaCodeFormatter.format(project);
            project.refreshLocal(IResource.DEPTH_INFINITE, null);
            JavaCodeFormatter.cleanup(project);
            project.refreshLocal(IResource.DEPTH_INFINITE, null); 
        } catch (CoreException e) {
            Activator.log(new Status(
                    IStatus.ERROR,
                    Activator.PLUGIN_ID,
                    "Error formatting project: " + project, //$NON-NLS-1$
                    e));
        }
	}
	
	/**
	 * Get the shell member variable.
	 * @return
	 * 		The shell member variable, which may be null.
	 */
	@SuppressWarnings("unused")
	private Shell getShell() {
		return this.shell;
	}

	/**
	 * Helper function to construct the full path for the outlet of the 
	 * code that will be generated.
	 * 
	 * @return
	 * 	A path that can be used as an outlet for an MWE workflow.
	 */
	private static String buildFullPath(IProject project, String lastSegment) {
		String fullPath = project.getLocation().toOSString();
		if(fullPath.endsWith("/") || fullPath.endsWith("\\")) {  //$NON-NLS-1$//$NON-NLS-2$
			fullPath = fullPath.substring(0, fullPath.length()-1);
		}
		if(lastSegment.startsWith("/") || lastSegment.startsWith("\\")){  //$NON-NLS-1$//$NON-NLS-2$
			lastSegment = lastSegment.substring(0, lastSegment.length() - 1);
		}
		
		return fullPath + File.separator + lastSegment;
	}
}
