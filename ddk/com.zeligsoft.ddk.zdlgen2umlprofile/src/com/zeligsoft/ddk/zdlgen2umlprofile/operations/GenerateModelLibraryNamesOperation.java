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
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;

import com.zeligsoft.base.util.WorkflowUtil;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdlgen2umlprofile.Activator;

/**
 * Operation to run the GenerateModelLibraryNames workflow file.
 * 
 * @author Toby McClean
 *
 */
public class GenerateModelLibraryNamesOperation implements
		IRunnableWithProgress {

	
	/**
	 * Set of constants for the name of properties in the workflow
	 */
	public static final String MODEL_URI_STRING = "sourceModelURI"; //$NON-NLS-1$
	public static final String SRC_GEN = "src-gen"; //$NON-NLS-1$
	public static final String SOURCE_MODEL = "sourceModel"; //$NON-NLS-1$
	public static final String PACKAGE_NAME = "packageName"; //$NON-NLS-1$
	public static final String SPECIALIZATION = "specialization"; //$NON-NLS-1$
	
	/**
	 * Set of constants related to the of the workflow file and its
	 * required resources.
	 */
	public static final String WORKFLOW_URI_STRING =
		"workflows/generateModelLibraryNames.oaw"; //$NON-NLS-1$
	
	private Shell shell;
	private GenDomainSpecialization model;
	private String dest;
	private String packageName;
	private IProject project;

	/**
	 * Initialize me
	 */
	public GenerateModelLibraryNamesOperation(Shell shell, 
			GenDomainSpecialization model, IProject project, String dest, 
			String packageName) {
		this.shell = shell;
		this.model = model;
		this.project = project;
		this.dest = dest;
		this.packageName = packageName;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {

		Map<String, String> properties = new HashMap<String,String>();
		
		String fullPath = buildFullPath();
		
		properties.put(SRC_GEN, fullPath);
		properties.put(MODEL_URI_STRING, model.eResource().getURI().toString());
		properties.put(PACKAGE_NAME, packageName);
		properties.put(SPECIALIZATION, model.getName());
		
		URL workflow = 
			Activator.getDefault().getBundle()
				.getEntry(WORKFLOW_URI_STRING);
		
		IStatus status = WorkflowUtil.executeWorkflow(workflow, monitor, properties, null);
		
		if(!status.isOK()) {
			Activator.getDefault().getLog().log(status);
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
	private String buildFullPath() {
		String fullPath = project.getLocation().toOSString();
		if(fullPath.endsWith("/") || fullPath.endsWith("\\")) {  //$NON-NLS-1$//$NON-NLS-2$
			fullPath = fullPath.substring(0, fullPath.length()-1);
		}
		if(dest.startsWith("/") || dest.startsWith("\\")){  //$NON-NLS-1$//$NON-NLS-2$
			dest = dest.substring(0, dest.length() - 1);
		}
		
		return fullPath + File.separator + dest;
	}
}
