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
package com.zeligsoft.cx.codegen.io;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.VetoException;
import org.eclipse.xpand2.output.VetoStrategy;

public class CXGenOutlet extends Outlet
{
	private final List<String> relPaths = new LinkedList<String>();

	@Override
	public FileHandle createFileHandle( String filePath ) throws VetoException
	{
		this.relPaths.add( filePath );
		return new CXGenFileHandle( this, getPath(), filePath );
	}

	public boolean shouldWrite( FileHandle fileHandle )
	{
		for( VetoStrategy veto : this.vetoStrategies )
			if( veto.hasVeto( fileHandle ) )
            	return false;

		return true;
	}

	private IProject getProject()
	{
		String projectName = new Path( getPath() ).lastSegment();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject( projectName );
		return ( project == null || ! project.exists() ) ? null : project;
	}

	public Iterable<IFile> getFiles()
	{
		return new Iterable<IFile>()
		{
			public Iterator<IFile> iterator() {
				return new Iterator<IFile>()
				{
					private final IProject project = getProject();
					private final Iterator<String> iterator = CXGenOutlet.this.relPaths.iterator();

					public void remove() { /* empty */ }
					public boolean hasNext() {
						return this.project != null
							&& this.iterator.hasNext();
					}

					public IFile next() {
						return this.project.getFile( this.iterator.next() );
					}
				};
			}
		};
	}
}
