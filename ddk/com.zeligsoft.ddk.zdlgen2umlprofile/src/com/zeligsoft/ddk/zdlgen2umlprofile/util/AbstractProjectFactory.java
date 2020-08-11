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
package com.zeligsoft.ddk.zdlgen2umlprofile.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * @author prismtech
 *
 */
public abstract class AbstractProjectFactory {

	/**
	 * 
	 */
	public AbstractProjectFactory() {
		super();
	}

	/**
	 * Find the project in the current workspace specified by the name
	 * provided. It will create the project if it doesn't exist when
	 * directed to by the client.
	 * 
	 * @param projectName
	 *      The name of the project we are looking for
	 * @param progressMonitor
	 *      The monitor to be used
	 * @param create
	 *      If true and the project doesn't exist it will be created.
	 * @return
	 *      The project that is being looked for or null if it doesn't
	 *      exist and create was false.
	 * @throws CoreException 
	 */
	public IProject getProject(String projectName, IProgressMonitor progressMonitor, boolean create)
			throws CoreException {
			    
			    // allocate a default progress monitor if one is not passed in
			    IProgressMonitor monitor = progressMonitor;
			    if(monitor == null) {
			        monitor = new NullProgressMonitor();
			    }
			    
			    IProject project = findProject(projectName);
			    
			    if(project == null) {
			        return null;
			    }
			    
			    project = createProject(projectName, monitor);
			                
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
     *      The project to be created
     * @param monitor
     *      The progress monitor to be used
     * @return
     *      The project that has been created
     * @throws CoreException 
     */
	protected abstract IProject createProject(final String projectName, 
			final IProgressMonitor monitor) throws CoreException;

}