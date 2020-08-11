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
package com.zeligsoft.ddk.zdlgen2umlprofile.internal.filesystem;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;

import com.google.common.base.Strings;
import com.zeligsoft.ddk.zdlgen2umlprofile.Activator;
import com.zeligsoft.ddk.zdlgen2umlprofile.filesystem.IEclipseFileSystemAccess;
import com.zeligsoft.ddk.zdlgen2umlprofile.filesystem.IFileSystemAccess;

/**
 * An implementation of {@link IFileSystemAccess} for Eclipse.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class EclipseFileSystemAccess extends AbstractFileSystemAccess implements IEclipseFileSystemAccess {
	/**
	 * @noimplement This interface is not intended to be implemented by clients.
	 */
	public interface IFileCallback {
		public void afterFileUpdate(IFile file);

		public void afterFileCreation(IFile file);

		public boolean beforeFileDeletion(IFile file);

	}

	private IProject project;

	private IProgressMonitor monitor;

	private IFileCallback callBack;

	public IFileCallback getCallBack() {
		return callBack;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

	public IProgressMonitor getMonitor() {
		return monitor;
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.ddk.zdlgen2umlprofile.internal.filesystem.IEclipseFileSystemAccess#setMonitor(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	/**
	 * {@inheritDoc IFileSystemAccess#generateFile(String, String, CharSequence)}
	 */
	@Override
	public void generateFile(String fileName, String outputName,
			CharSequence contents) {
		if (monitor.isCanceled()) {
			Activator.log(new Status(IStatus.INFO,Activator.PLUGIN_ID, String.format(
					"%s#%s: fileName (%s) and outputName(%s) canceled.",  //$NON-NLS-1$
						this.getClass().getName(),
						"generateFile", //$NON-NLS-1$
						fileName,
						outputName)));
			throw new OperationCanceledException();
		}
		
		if(Strings.isNullOrEmpty(fileName)) {
			throw new IllegalArgumentException("The fileName parameter cannot be null or empty."); //$NON-NLS-1$
		}
		
		if(Strings.isNullOrEmpty(outputName)) {
			throw new IllegalArgumentException("The outputName parameter cannot be null or empty.");	 //$NON-NLS-1$
		}

		OutputConfiguration outputConfig = getOutputConfig(outputName);

		// check to see if the output folder already exists
		IFolder folder = getFolder(outputConfig);
		if (folder != null && !folder.exists()) {
			if (outputConfig.isCreateOutputDirectory()) {
				try {
					createFolder(folder);
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
			} else {
				throw new IllegalArgumentException(
						"The folder doesn't exist and I am configured not to create it."); //$NON-NLS-1$
			}
		}

		IFile file = getFile(fileName, outputName);
		CharSequence postProcessedContent = postProcess(fileName, outputName, contents);
		String contentsAsString = postProcessedContent.toString();
		if (file.exists()) {
			if (outputConfig.isOverrideExistingResources()) {
				try {
					StringInputStream newContent = getInputStream(
							contentsAsString, getEncoding(file));
					if (hasContentsChanged(file, newContent)) {
						// reset to offset zero allows to reuse internal byte[]
						// no need to convert to string twice
						newContent.reset();
						file.setContents(newContent, true, true, monitor);
					}
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}

				if (callBack != null) {
					callBack.afterFileUpdate(file);
				}
			}
		} else {
			try {
				ensureParentExists(file);
				file.create(getInputStream(contentsAsString, getEncoding(file)),
						true, monitor);
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}

			if (callBack != null) {
				callBack.afterFileUpdate(file);
			}
		}
	}

	protected boolean hasContentsChanged(IFile file,
			StringInputStream newContent) {
		boolean contentChanged = false;
		BufferedInputStream oldContent = null;
		try {
			oldContent = new BufferedInputStream(file.getContents());
			int newByte = newContent.read();
			int oldByte = oldContent.read();
			while (newByte != -1 && oldByte != -1 && newByte == oldByte) {
				newByte = newContent.read();
				oldByte = oldContent.read();
			}
			contentChanged = newByte != oldByte;
		} catch (CoreException e) {
			contentChanged = true;
		} catch (IOException e) {
			contentChanged = true;
		} finally {
			if (oldContent != null) {
				try {
					oldContent.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
		return contentChanged;
	}

	protected StringInputStream getInputStream(String contentsAsString,
			String encoding) {
		try {
			return new StringInputStream(contentsAsString, encoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	protected String getEncoding(IFile file) throws CoreException {
		return file.getCharset(true);
	}

	protected IFile getFile(String fileName, String outputName) {
		OutputConfiguration configuration = getOutputConfig(outputName);
		IFolder folder = getFolder(configuration);
		return folder.getFile(new Path(fileName));
	}

	protected void createFolder(IFolder folder) throws CoreException {
		ensureExists(folder);
	}

	protected void ensureParentExists(IFile file) throws CoreException {
		if (!file.exists()) {
			ensureExists(file.getParent());
		}
	}

	protected void ensureExists(IContainer container) throws CoreException {
		if (container.exists())
			return;
		if (container instanceof IFolder) {
			ensureExists(container.getParent());
			((IFolder) container).create(true, true, monitor);
		}
	}

	protected IFolder getFolder(OutputConfiguration outputConfig) {
		return project.getFolder(new Path(outputConfig.getOutputDirectory()));
	}

	/**
	 * {@inheritDoc IFileSystemAccess#deleteFile(String, String)}
	 */
	@Override
	public void deleteFile(String fileName, String outputName) {
		try {
			IFile file = getFile(fileName, outputName);
			deleteFile(file, monitor);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 * @param file
	 * @param monitor
	 * @throws CoreException
	 */
	public void deleteFile(IFile file, IProgressMonitor monitor) throws CoreException {
		IFileCallback callBack = getCallBack();
		if ((callBack == null || callBack.beforeFileDeletion(file)) && file.exists()) {
			file.delete(IResource.KEEP_HISTORY, monitor);
		}
	}
	
	public URI getURI(String fileName, String outputConfiguration) {
		IFile file = getFile(fileName, outputConfiguration);
		return URI.createPlatformResourceURI(file.getFullPath().toString(), true);
	}
	
	@Override
	protected CharSequence postProcess(String fileName, String outputConfiguration, CharSequence content) {
		if(postProcessor != null) 
			return postProcessor.postProcess(getURI(fileName, outputConfiguration), content);
		else
			return content;
	}
	
	@Override
	public String getFolderPath(String folder, String outputName) {
		OutputConfiguration configuration = getOutputConfig(outputName);
		IFolder projectFolder = getFolder(configuration);
		
		IFolder ifolder = projectFolder.getFolder(folder);
		
		try {
			ensureExists(ifolder);
		} catch (CoreException e) {
			ifolder = projectFolder;
		}
		
		return ifolder.getLocation().toString();
	}
	
	@Override
	public String getFolderPath(String folder) {
		return getFolderPath(folder, DEFAULT_OUTPUT);
	}
}
