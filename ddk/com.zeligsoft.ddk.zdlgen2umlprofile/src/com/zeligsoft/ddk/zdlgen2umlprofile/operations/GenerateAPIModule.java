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
/**
 * 
 */
package com.zeligsoft.ddk.zdlgen2umlprofile.operations;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.zeligsoft.ddk.zdlgen2umlprofile.filesystem.IFileSystemAccess;
import com.zeligsoft.ddk.zdlgen2umlprofile.internal.filesystem.EclipseFileSystemAccess;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class GenerateAPIModule extends AbstractModule {
    private final String rootPackage;
    private final String implSubPackage;
    private final String implSuffix;
    private final String outputPath;
    private final String targetProject;
    
    /**
     * [TODO]
     * @param rootPackage
     * @param implSubPackage
     * @param implSuffix
     * @param outputPath 
     */
    public GenerateAPIModule(final String rootPackage, 
            final String implSubPackage, 
            final String implSuffix,
            final String outputPath, final String targetProject) {
        this.rootPackage = rootPackage;
        this.implSubPackage = implSubPackage;
        this.implSuffix = implSuffix;
        this.outputPath = outputPath;
        this.targetProject = targetProject;
    }
    
    /* (non-Javadoc)
     * @see com.google.inject.AbstractModule#configure()
     */
    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("Root Package")). //$NON-NLS-1$
            toInstance(rootPackage);
        bind(String.class).annotatedWith(Names.named("Implementation Suffix")). //$NON-NLS-1$
            toInstance(implSuffix);
        bind(String.class).annotatedWith(Names.named("Implementation SubPackage")). //$NON-NLS-1$
            toInstance(implSubPackage);
        bind(IFileSystemAccess.class).toProvider(new Provider<IFileSystemAccess>() {
        	@Inject EclipseFileSystemAccess configuredFileSystemAccess;
        	@Override
			public IFileSystemAccess get() { 
        		configuredFileSystemAccess.setOutputPath(outputPath);
        		configuredFileSystemAccess.setProject(findProject(targetProject));
        		configuredFileSystemAccess.setMonitor(new NullProgressMonitor());
        		configuredFileSystemAccess.setCreateOutputDirectory(true);
        		return configuredFileSystemAccess;
        	}
        }).asEagerSingleton();
    }
    
    private IProject findProject(String name) {
		final IProgressMonitor monitor = new NullProgressMonitor();
				
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(targetProject);
		if(!project.exists()) {
			try{
				project.create(monitor);
				project.open(monitor);
			} catch(CoreException e) {
				throw new RuntimeException(e);
			}
		}
		return project;
		
	}
    
//    @Provides @Singleton
//    IFileSystemAccess provideIFileSystemAccess() {
//        JavaIoFileSystemAccess configuredFileSystemAccess = 
//            new JavaIoFileSystemAccess();
//        configuredFileSystemAccess.setOutputPath(outputPath);
//        
//        return configuredFileSystemAccess;
//    }

}
