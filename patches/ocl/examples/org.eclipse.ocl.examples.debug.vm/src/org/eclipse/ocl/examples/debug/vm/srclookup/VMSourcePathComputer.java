/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.srclookup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourcePathComputer;
import org.eclipse.debug.core.sourcelookup.containers.DirectorySourceContainer;
import org.eclipse.debug.core.sourcelookup.containers.ProjectSourceContainer;
import org.eclipse.debug.core.sourcelookup.containers.WorkspaceSourceContainer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.URIUtil;

public abstract class VMSourcePathComputer implements ISourcePathComputer
{
//	private static final String JAVA_SRC_COMPUTER_ID = "org.eclipse.jdt.launching.sourceLookup.javaSourcePathComputer"; //$NON-NLS-1$

    public static IFile getIFile(String fileUnderWorkspace) {
		IPath location = new Path(fileUnderWorkspace);
		IFile ifile = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(location);
		return ifile;
	}

    public static IFile getWorkspaceFile(String name) {
        try {
            IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(name));
            return file;
        }
        catch(Exception e) {
            return null;
        }
    }

    public static IFile getWorkspaceFile(URI uri) {
		String uriPath;
		if (uri.isFile()) {
			uriPath = uri.toFileString();
		}
		else if (uri.isPlatform()) {
			uriPath = uri.toPlatformString(true);
		}
		else {
			uriPath = uri.toString();
		}
		IFile ifile = getWorkspaceFile(uriPath);

		if (ifile == null || !ifile.exists()) {
			if (uri.isFile()) {
				IFile wsfile = getIFile(uriPath);
				if (wsfile != null && wsfile.exists()) {
					return wsfile;
				}
			}
		}
		return ifile;
    }

//	private final ISourcePathComputer fJavaSourcePathComputer;

	public VMSourcePathComputer() {
//		fJavaSourcePathComputer = DebugPlugin.getDefault().getLaunchManager().getSourcePathComputer(JAVA_SRC_COMPUTER_ID);
	}

	@Override
	public abstract @NonNull String getId();

	@Override
	public @NonNull ISourceContainer @NonNull [] computeSourceContainers(ILaunchConfiguration configuration, IProgressMonitor monitor) throws CoreException {
		assert configuration != null;
		URI moduleURI = getModuleFile(configuration);
		ISourceContainer sourceContainer;
		if (moduleURI.isFile()) {
			File moduleFile = new File(moduleURI.toFileString());
			sourceContainer = new DirectorySourceContainer(moduleFile.getParentFile(), false)
			{

				@Override
				public Object[] findSourceElements(String name) throws CoreException {
					URI nameURI = URI.createFileURI(name);
					URI directoryURI = URI.createFileURI(getDirectory().toString() + "/");
					URI relativeURI = URIUtil.deresolve(nameURI, directoryURI);
					return super.findSourceElements(relativeURI.toString());
				}

				@Override
				protected Object[] findSourceElements(String name,
						ISourceContainer[] containers) throws CoreException {
					// TODO Auto-generated method stub
					return super.findSourceElements(name, containers);
				}

			};
		}
		else {
			IFile moduleFile = getWorkspaceFile(moduleURI);
			if (moduleFile != null && moduleFile.exists()) {
				sourceContainer = new ProjectSourceContainer(moduleFile.getProject(), false);
			}
			else {
				sourceContainer = new WorkspaceSourceContainer();
			}
		}
	    List<ISourceContainer> result = new ArrayList<ISourceContainer>();
		result.add(sourceContainer);
//		result.addAll(Arrays.asList(fJavaSourcePathComputer.computeSourceContainers(configuration, monitor)));
		@SuppressWarnings("null")@NonNull ISourceContainer @NonNull [] array = result.toArray(new ISourceContainer[result.size()]);
		return array;
	}

	protected abstract URI getModuleFile(@NonNull ILaunchConfiguration configuration) throws CoreException;
}
