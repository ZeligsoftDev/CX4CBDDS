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

package com.zeligsoft.domain.dds4ccm.codegen.listener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;

import com.google.common.base.Preconditions;
import com.zeligsoft.cx.codegen.UserEditableRegion;
import com.zeligsoft.cx.codegen.io.ParsingOutputStream;
import com.zeligsoft.domain.dds4ccm.DDS4CCMPreferenceConstants;
import com.zeligsoft.domain.dds4ccm.codegen.Activator;
import com.zeligsoft.domain.dds4ccm.codegen.l10n.Messages;

/**
 * A ResourceChangeListener to pick up .cpp/.h file changes and update the model
 * with any relevant codetags.
 * 
 * @author Sean
 *
 */
public class DDS4CCMResourceChangeListener implements IResourceChangeListener {

	/**
	 * The file extensions we care about.
	 */
	private static final String[] FILE_EXTENSION = {".cpp", ".h"}; //$NON-NLS-1$ //$NON-NLS-2$

	public static DDS4CCMResourceChangeListener INSTANCE = null;
	
	private static final IEclipsePreferences store = new InstanceScope()
			.getNode(com.zeligsoft.domain.dds4ccm.Activator.PLUGIN_ID);
	
	/**
	 * Weak singleton constructor.
	 */
	public DDS4CCMResourceChangeListener() {
		if( INSTANCE == null ) {
			INSTANCE = this;
		}
	}
	
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		boolean enabled = store.getBoolean(
				DDS4CCMPreferenceConstants.ENABLE_CODEGEN,
				DDS4CCMPreferenceConstants.DEFAULT_ENABLE_CODEGEN);
		if (enabled) {
			if (event.getDelta() != null) {
				visit(event.getDelta());
			}
		}
	}
	
	private void visit(IResourceDelta delta) {
		final IResource resource = delta.getResource();
		// ignore anything that isn't a .cpp/.h file.
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

		}
		// Navigate the delta hierarchy.
		for( IResourceDelta childDelta : delta.getAffectedChildren()) {
			visit(childDelta);
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
	 * Handle a newly added resource.
	 * 
	 * @param resource
	 *            the resource being added
	 */
	private static void processAdd(final IResource resource) {
		Preconditions.checkNotNull(resource);

		if ((resource instanceof IFile)
				&& isFileOfInterest(resource.getName())) {
			doUpdate((IFile) resource);
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
			doUpdate((IFile) resource); 
		}
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
	private static void doUpdate(IFile resource) {	
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
		} catch( CoreException e ) {
			Activator.getDefault().error(Messages.error_resourceCore, e);
		} catch (IOException e) {
			Activator.getDefault().error(Messages.error_resourceIO, e);
		}
		

	}


}
