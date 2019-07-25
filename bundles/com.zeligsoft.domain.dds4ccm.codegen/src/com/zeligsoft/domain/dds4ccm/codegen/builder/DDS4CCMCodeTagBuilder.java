/**
 * Copyright 2018 ADLINK Technology Limited.
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
 *
 */

package com.zeligsoft.domain.dds4ccm.codegen.builder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.common.base.Preconditions;
import com.zeligsoft.cx.codegen.UserEditableRegion;
import com.zeligsoft.cx.codegen.io.ParsingOutputStream;

/**
 * A {@link IncrementalProjectBuilder} for projects with the
 * {@link DDS4CCMCodeTagNature} applied to them. It looks for ".cpp" and ".h"
 * {@link IResource}s and processes user-defined code tags in them to bring them
 * back into the model.
 * 
 * @author Sean McFee
 */
public class DDS4CCMCodeTagBuilder extends IncrementalProjectBuilder {

	/**
	 * The file extensions we care about.
	 */
	private static final String[] FILE_EXTENSION = {".cpp", ".h"}; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The visitor used for incremental builds. 
	 * 
	 * @author Sean McFee
	 */
	class DDS4CCMCodeGenDeltaVisitor implements IResourceDeltaVisitor {

		public DDS4CCMCodeGenDeltaVisitor() {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse
		 * .core.resources.IResourceDelta)
		 */
		public boolean visit(IResourceDelta delta) throws CoreException {
			final IResource resource = delta.getResource();
			if (resource instanceof IFile
					&& isFileOfInterest(resource.getName())) {

				switch (delta.getKind()) {
				case IResourceDelta.ADDED:
					// handle added resource
					processAdd(resource);
					break;
				case IResourceDelta.REMOVED:
					break;
				case IResourceDelta.CHANGED:
					// handle changed resource
					processChange(resource);
					break;
				default:
					break;
				}

				try {
					refresh();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// return true to continue visiting children.
			return true;
		}
	}
	
	private static boolean isFileOfInterest(String filename) {
		for( String s : FILE_EXTENSION ) {
			if( filename.endsWith(s)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The visitor used by full builds. 
	 * 
	 * @author Sean McFee
	 */
	class DDS4CCMCodeTagResourceVisitor implements IResourceVisitor {

		/**
		 * Default constructor.
		 * 
		 */
		public DDS4CCMCodeTagResourceVisitor() {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.resources.IResourceVisitor#visit(org.eclipse.core
		 * .resources.IResource)
		 */
		@Override
		public boolean visit(IResource resource) {
			processAdd(resource);
			// return true to continue visiting children.
			return true;
		}
	}

	/**
	 * The ID used to register this builder. 
	 */
	public static final String BUILDER_ID = "com.zeligsoft.domain.dds4ccm.codegen.builder"; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 * java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IProject[] build(int kind,
			@SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor)
			throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			final IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}

		return new IProject[0];
	}

	/**
	 * Handle a newly added resource.
	 * 
	 * @param resource
	 *            the resource being added
	 */
	private static void processAdd(final IResource resource) {
		Preconditions.checkNotNull(resource);

		if ((resource instanceof IFile)
				&& isFileOfInterest(resource.getName())) {
			try {
				doUpdate((IFile) resource);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Handle an updated resource.
	 * 
	 * @param resource
	 *            the resource being changed
	 */
	private void processChange(final IResource resource) {
		Preconditions.checkNotNull(resource);

		if ((resource instanceof IFile)
				&& isFileOfInterest(resource.getName())) {
			try {
				doUpdate((IFile) resource);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	/**
	 * Perform a full build of the project. This means searching all files for
	 * relevant tags with which to update the model.
	 * 
	 * @param monitor
	 *            the progress monitor for the build task
	 * @throws CoreException
	 */
	private void fullBuild(final IProgressMonitor monitor) throws CoreException {

		getProject().accept(
					new DDS4CCMCodeTagResourceVisitor());

		try {
			refresh();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Perform an incremental build of the project, for a change to a specific
	 * Resource.
	 * 
	 * @param delta
	 *            the change
	 * @param monitor
	 *            the progress monitor for the build task
	 * 
	 * @throws CoreException
	 */
	private void incrementalBuild(final IResourceDelta delta,
			final IProgressMonitor monitor) throws CoreException {
		delta.accept(new DDS4CCMCodeGenDeltaVisitor());
	}

	/**
	 * Refresh the project.
	 * 
	 * @param rset
	 *            the {@link ResourceSet} containing the {@link Resource}s to
	 *            save and unload
	 * 
	 * @throws CoreException
	 * @throws IOException 
	 */
	private void refresh()
			throws CoreException, IOException {

		getProject().refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * com.zeligsoft.cx.codegen.io.ParsingOutputStream contains the logic to parse user-editable
	 * regions and save them back into the model, and perform any post-processing. To use it
	 * in this context, we read the contents of the resource into a buffer. We then create a 
	 * stream in memory and write out a ParsingOutputStream there instead of to the file system.
	 * This has the effect of invoking all the relevant CDT integration code.
	 */
	private static void doUpdate(IFile resource) throws IOException {	
		try {
			InputStream content = resource.getContents(true);
			
			if( UserEditableRegion.containsUserEditableRegions(content)) {
				ParsingOutputStream stream = new ParsingOutputStream(
						new ByteArrayOutputStream(),
						resource );
				byte[] buff = new byte[resource.getContents().available()];
				Arrays.fill( buff, 0, buff.length, (byte)0 );
				resource.getContents().read(buff, 0, resource.getContents().available());
				stream.write(buff);
				stream.close();
				
			}
			
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
