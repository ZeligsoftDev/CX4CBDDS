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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.provider.FileInfo;
import org.eclipse.core.filesystem.provider.FileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.zeligsoft.cx.codegen.CodeGenPlugin;
import com.zeligsoft.cx.codegen.l10n.Messages;

public class CXGenFileStore extends FileStore
{
	private final URI uri;
	private final IPath path;
	private final FileInfo fileInfo;

	public CXGenFileStore( URI uri )
	{
		this.uri = uri;
		this.path = new Path( uri.getSchemeSpecificPart() );
		this.fileInfo = new SyntheticFileInfo( this.path.lastSegment() );
	}

	public static URI createUri( IPath path )
	{
		// URIUtil.toURI can't be used directly because the cxgen scheme must be used
		// However, the implementation in there might be better than this quick way.
		try
		{
			return
				new URI(
					CXGenFileSystem.Scheme,
					null,
					Character.toString('/') + path.makeAbsolute().toPortableString(),
					null );
		}
		catch( URISyntaxException e )
		{
			CodeGenPlugin.getDefault().error(Messages.CXGenFileStore_BadUri, e);
			return null;
		}
	}

	@Override public URI toURI() { return this.uri; }
	@Override public String getName() { return this.path.lastSegment(); }

	@Override
	public String[] childNames( int options, IProgressMonitor monitor ) throws CoreException
	{
		// This class is only used to represent files, there are never children.
		return new String[0];
	}

	@Override
	public IFileStore getChild( String name )
	{
		// This class is only used to represent files, there are never children.
		return EFS.getNullFileSystem().getStore( new Path( new String() ) );
	}

	@Override
	public IFileStore getParent()
	{
		// There currently is no hierarchical structure to the worker code URIs.
		return EFS.getNullFileSystem().getStore( new Path( new String() ) );
	}

	@Override
	public IFileInfo fetchInfo( int options, IProgressMonitor monitor ) throws CoreException
	{
		return fileInfo;
	}

	@Override
	public InputStream openInputStream( int options, IProgressMonitor monitor ) throws CoreException
	{
		try
		{
			return new FileInputStream( toLocalFile( EFS.NONE, monitor ) );
		}
		catch( IOException e )
		{
			String msg = NLS.bind( Messages.CXGenFileStore_OpenFailed, this.uri.toString() );
			CodeGenPlugin.getDefault().error( msg, e );
			throw new CoreException( new Status( IStatus.ERROR, CodeGenPlugin.ID, msg, e ) );
		}
	}

	private IResource getResource()
	{
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		IPath testPath = this.path;
		while( testPath != null
		    && testPath.segmentCount() > 0 )
		{
			IResource resource = root.findMember(testPath);
			if( resource != null )
				return resource;
			testPath = testPath.removeFirstSegments(1);
		}

		return null;
	}

	@Override
	public OutputStream openOutputStream( int options, IProgressMonitor monitor ) throws CoreException
	{
		try
		{
			return
				new ParsingOutputStream(
						new FileOutputStream( toLocalFile( EFS.NONE, monitor ) ),
						getResource() );
		}
		catch( IOException e )
		{
			String msg = NLS.bind( Messages.CXGenFileStore_SaveFailed, this.uri.toString() );
			CodeGenPlugin.getDefault().error( msg, e );
			throw new CoreException( new Status( IStatus.ERROR, CodeGenPlugin.ID, msg, e ) );
		}
	}

	@Override
	public File toLocalFile( int options, IProgressMonitor monitor ) throws CoreException
	{
		if( ( options & EFS.CACHE ) != 0 )
			return super.toLocalFile( options, monitor );

		return new File( this.uri.getSchemeSpecificPart() );
	}

	private class SyntheticFileInfo extends FileInfo
	{
		public SyntheticFileInfo( String name )
		{
			super( name );
			setExists( true );
			setDirectory( false );
		}

		@Override
		public long getLastModified()
		{
			try
			{
				return toLocalFile( EFS.NONE, null ).lastModified();
			}
			catch( CoreException e )
			{
				String msg = NLS.bind( Messages.CXGenFileStore_FileInaccessible, CXGenFileStore.this.uri.toString() );
				CodeGenPlugin.getDefault().error( msg, e );
				return 0L;
			}
		}
	};
}
