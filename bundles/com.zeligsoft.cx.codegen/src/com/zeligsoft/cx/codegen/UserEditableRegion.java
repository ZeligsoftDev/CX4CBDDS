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
package com.zeligsoft.cx.codegen;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.osgi.util.NLS;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.codegen.editor.ICodeLocator;
import com.zeligsoft.cx.codegen.io.CXGenFileStore;
import com.zeligsoft.cx.codegen.l10n.Messages;
import com.zeligsoft.cx.codegen.postprocessor.CodeEditorPostProcessorRegistry;
import com.zeligsoft.domain.zml.util.WorkerFunctionUtil;

public class UserEditableRegion
{
	public static final String UserRegionTag    = "CXGEN-USERREGION-"; //$NON-NLS-1$
	public static final String UserEditBeginTag = "BEGIN"; //$NON-NLS-1$
	public static final String UserEditEndTag   = "END"; //$NON-NLS-1$
	public static final String CommentEndString = "*/";
	public static final String UserEditMarker   = UserRegionTag + UserEditBeginTag;
	private static final String Empty = new String();

	public final String label;
	public final int line;
	public final StringBuilder text = new StringBuilder();

	/**
	 * There have been problems related to the concept that is generated into the marker
	 * comment.  CX bug 104 was created because the code contained concepts that weren't
	 * part of the domain.  Zeligsoft bug 15003 was created because the concept was different
	 * between the generated code and what was expected.
	 *
	 * The concept should not really be needed for searching.  The marker comment also
	 * includes the elements unique URI fragment and the model property to which the source
	 * code relates.
	 *
	 * This flag is used as a marker to associate the two places where this fix needs to
	 * change the code (when generating the comment as well as when computing the string to
	 * be used to search for the proper part of the file).  If it turns out that we do need to
	 * use the concept in the search then this flag can be changed to false AND we'll need to
	 * figure out a way to fix the underlying problem of different concepts in the plugin.xml
	 * and XPand templates.
	 */
	private static final boolean Bug15003_SearchWithoutConcept = true;

	public static String getIdentifyingString(EObject object, String concept, String property) {
		
		String uriString = null;
		if (object != null)
		{
			URI uri = EcoreUtil.getURI(object);
			if (uri != null)
				uriString = uri.toString();
		}

		// all params need to be supplied
		if( uriString == null || uriString.isEmpty()
		 || property == null  || property.isEmpty()
		 || concept == null   || concept.isEmpty() )
			throw new IllegalArgumentException( "Valid strings required for all identifying attributes" ); //$NON-NLS-1$

		StringBuilder sb = new StringBuilder();
		sb.append(UserRegionTag);
		sb.append(UserEditBeginTag);
		sb.append(' ');
		sb.append(uriString == null ? Empty : uriString);
		sb.append(' ');
		sb.append(property == null ? Empty : property);
		if( ! Bug15003_SearchWithoutConcept )
		{
			sb.append(' ');
			sb.append(concept == null ? Empty : concept);
		}
		return sb.toString();
	}
	
	public static String getIdentifyingString(EObject object, String concept, String property, String language ) {
		String uriString = null;
		if (object != null)
		{
			URI uri = EcoreUtil.getURI(object);
			if (uri != null)
				uriString = uri.toString();
		}

		// all params need to be supplied
		if( uriString == null || uriString.isEmpty()
		 || property == null  || property.isEmpty()
		 || concept == null   || concept.isEmpty() 
		 || language == null || language.isEmpty() )
			throw new IllegalArgumentException( "Valid strings required for all identifying attributes" ); //$NON-NLS-1$

		StringBuilder sb = new StringBuilder();
		sb.append(UserRegionTag);
		sb.append(UserEditBeginTag);
		sb.append(' ');
		sb.append(uriString == null ? Empty : uriString);
		sb.append(' ');
		sb.append(property == null ? Empty : property);
		
		if( ! Bug15003_SearchWithoutConcept )
		{
			sb.append(' ');
			sb.append(concept == null ? Empty : concept);
			sb.append(' ');
			sb.append(language == null ? Empty : language);
		} else {
			sb.append(' ');
			sb.append(language == null ? Empty : language);
		}
		
		
		
		
		return sb.toString();
	}

	private static class Label
	{
		public EObject object;
		private String concept;
		private String property;
		private String language; // This is optional in older models.
	}

	private static Label parseLabel( String idString )
	{
		Label label = new Label();
		StringTokenizer tokenizer = new StringTokenizer( idString );
		if( ! tokenizer.hasMoreTokens() ) {
			return null;
		}
		String elementUri = tokenizer.nextToken(); 

		if( ! tokenizer.hasMoreElements() ) {
			return null;
		}
		label.property = tokenizer.nextToken();

		if( ! tokenizer.hasMoreElements() ) {
			return null;
		}
		label.concept = tokenizer.nextToken();
		
		if( tokenizer.hasMoreElements() ) {
			String language = tokenizer.nextToken();
			if( language.equals(CommentEndString) == false) {
				label.language = language;
			}
		}

		URI modelElementUri = URI.createURI(elementUri);
		label.object = CodeGenPlugin.getDefault().getEObject( modelElementUri );

		return label;
	}

	public static String userEditBegin( EObject object, String concept, String property )
	{
		StringBuilder sb = new StringBuilder("/* "); //$NON-NLS-1$
		sb.append(getIdentifyingString(object, concept, property));
		if( Bug15003_SearchWithoutConcept )
		{
			sb.append( ' ' );
			sb.append( concept == null ? Empty : concept );
		}
		sb.append(" */"); //$NON-NLS-1$
		return sb.toString();
	}
	
	public static String userEditBegin( EObject object, String concept, String property, String language ) {
		StringBuilder sb = new StringBuilder("/* "); //$NON-NLS-1$
		sb.append(getIdentifyingString(object, concept, property, language));
		if( Bug15003_SearchWithoutConcept )
		{
			sb.delete(sb.length() - language.length() - 1, sb.length());
			sb.append( ' ' );
			sb.append( concept == null ? Empty : concept );
			sb.append(' ');
			sb.append(language == null ? Empty : language);
		}
		sb.append(" */"); //$NON-NLS-1$
		return sb.toString();
	}

	/**
	 * Overlapping regions are not allowed so a simple end tag is possible.
	 */
	public static String userEditEnd()
	{
		return "/* " + UserRegionTag + UserEditEndTag + " */"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public UserEditableRegion( String label, int line )
	{
		this.label = label;
		this.line = line;
	}

	/**
	 * Stores the receiver's text into the model element indicated in the identifying label.
	 */
	public void commit()
	{
		// TODO This implementation is wrong, e.g., when the source model is gone.

		final Label l = parseLabel( this.label );
		if( l == null || l.object == null)
		{
			CodeGenPlugin.getDefault().error(
					Messages.UserEditableRegion_CannotSaveChanges + "("
							+ this.label + ")", null);
			return;
		}

		AbstractTransactionalCommand command
			= new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain( l.object ),
				Messages.UserEditableRegion_StoreObjectLabel,
				null )
		{
			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				try
				{
					if( l.language == null) {
						// This modifies the value in memory, and adds a (*) indicator to the
						// model in the navigator.
						ZDLUtil.setValue(
								l.object, l.concept, l.property,
								UserEditableRegion.this.text.toString() );
					} else {
						
						boolean codeChanged =
						WorkerFunctionUtil.setWorkerFunctionImplementationCode(
								l.object.eContainer(), 
								l.object, 
								l.language, 
								UserEditableRegion.this.text.toString());
						if( codeChanged ) {
							CodeEditorPostProcessorRegistry.INSTANCE.notifyObject(l.object);
						}
					}
	
					return CommandResult.newOKCommandResult();
				}
				catch( IllegalArgumentException e )
				{
					return CommandResult.newErrorCommandResult( e );
				}
			}
		};

		try
		{
			OperationHistoryFactory.getOperationHistory().execute(command, null, null);
		}
		catch (ExecutionException e)
		{
			CodeGenPlugin.getDefault().error( Messages.UserEditableRegion_CannotSaveChanges, e);
		}
	}

	public static boolean containsUserEditableRegions( CharSequence buffer )
	{
		return buffer.toString().contains( UserEditMarker );
	}

	public static boolean containsUserEditableRegions( InputStream in )
	{
		int marker_prefix = UserEditMarker.length() - 1;
		int active_buff_len = 16 * 1024;

		byte[] buff = new byte[marker_prefix + active_buff_len];
		Arrays.fill( buff, 0, marker_prefix, (byte)0 );
		int bytes;
		try
		{
			while( ( bytes = in.read( buff, marker_prefix, active_buff_len ) ) > 0 )
			{
				if( containsUserEditableRegions( new String( buff, 0, bytes + marker_prefix ) ) )
					return true;

				int src_begin = buff.length - marker_prefix;
				System.arraycopy( buff, src_begin, buff, 0, marker_prefix );
			}
		}
		catch( IOException e ) { /* empty */ }
		finally
		{
			if( in != null )
				try { in.close(); }
				catch( IOException e ) { /* empty */ }
		}

		return false;
	}

	/**
	 * This method updates Eclipse's view of the receiver's file to apply the correct filesystem.
	 * <p>
	 * <h1>Background</h1>
	 * Files that are generated with user modifiable content are stored in the cxgen:// filesystem.
	 * Modifications to files in that filesystem cause the content to be parsed and the user-
	 * modifiable regions to be stored back into the model.  Files that have no user modifiable
	 * content are stored in the normal file:// filesystem.
	 * <h1>What is the purpose of this method?</h1>
	 * Since the content of the file may change with each regen, the filesystem in which it is
	 * stored may also change.
	 * <p>
	 * <strong>NOTE:</strong> This method needs to be called even if the underlying file content
	 * has not changed.  E.g., when a link is deleted the file is removed from Eclipse, but the
	 * content still lives on disk in a java.io.File.  The OAW generator uses the underlying file
	 * directly.  If it finds java.io.File without a representation in Eclipse, it automatically
	 * adds it as a plain file:// entry.  Calling this method before letting OAW find the file
	 * resolves the problem.
	 */
	public static boolean refreshFileStoreKind( String basePath, String relPath, InputStream content )
	{
		String projectName = new Path( basePath ).lastSegment();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject( projectName );
		IPath projectRelPath = new Path( relPath );
		IPath path = new Path( basePath ).append( relPath );
		IFile link = project.getFile( projectRelPath );

		// If the file is not user editable and there is already a link, then delete the link,
		// the underlying content will be discovered as a file:// on the folder refresh.
		if( ! containsUserEditableRegions( content ) )
		{
			if( link.isLinked() )
				try
				{
					// After deleting the link the parent folder is refreshed so that the
					// underlying file (if it exists) will be known to eclipse.  Skipping
					// the refresh causes an external Editor to be opened.
					IContainer parent = link.getParent();
					link.delete( true, false, null );
					if( parent.exists() )
						parent.refreshLocal( IResource.DEPTH_ONE, null );
				}
				catch( CoreException e )
				{
					CodeGenPlugin.getDefault().error(
							NLS.bind( Messages.UserEditableRegion_CannotConvertToPlainFS, basePath, relPath ),
							e );
				}

			// when there isn't user-editable content, make sure the parent folders
			// exist
			if( ! link.exists() )
				ensureFolderExists( link.getParent(), null );

			return true;
		}

		// Otherwise make sure that Eclipse views the file as a link.
		try
		{
			ensureFolderExists( link.getParent(), null );
			link.createLink(
					CXGenFileStore.createUri( path ),
					IResource.ALLOW_MISSING_LOCAL | IResource.REPLACE,
					null );
			link.getParent().refreshLocal( IResource.DEPTH_ONE, null );
			return true;
		}
		catch( CoreException e )
		{
			CodeGenPlugin.getDefault().error(
					NLS.bind( Messages.UserEditableRegion_CannotConvertToCXGenFS, basePath, relPath ),
					e );
			return false;
		}
	}

	/**
	 * Ensure the parent of the argument exists.  Create folders up to the IProject if required.
	 * Does not create the IProject.  Returns true if the folder now exists and false if it does
	 * not exist and could not be created.
	 */
	private static boolean ensureFolderExists( IContainer parent, IProgressMonitor monitor )
	{
		if( parent == null )
			return false;

		if( parent instanceof IProject )
			return parent.exists();

		if( parent.exists() )
			return true;

		if( ! ensureFolderExists( parent.getParent(), monitor )  )
			return false;

		IFolder folder = parent.getParent().getFolder( new Path( parent.getName() ) );
		try { folder.create( true, true, monitor ); }
		catch( CoreException e )
		{
			CodeGenPlugin.getDefault().error(
				NLS.bind( Messages.UserEditableRegion_CannotCreateParent, parent.getLocation().toString() ),
				e );
			return false;
		}

		return true;
	}

	public static class Locator implements ICodeLocator
	{
		public int getLineNumber( IFile file, EObject object, String concept, String property )
		{
			LineNumberReader reader = null;
			try { reader = new LineNumberReader( new InputStreamReader( file.getContents() ) ); }
			catch( CoreException e ) { return -1; }

			String id = getIdentifyingString( object, concept, property );
			String line;
			try
			{
				// LineNumberReader starts at 0 but the tag consumes 1 line so the current
				// value will wind up one past the opening tag.
				while( ( line = reader.readLine() ) != null )
					if( line.contains( id ) )
						return reader.getLineNumber();
			}
			catch( IOException e ) { /* empty */ }

			return -1;
		}
		
		public int getLineNumber( IFile file, EObject object, String concept, String property, String language )
		{
			LineNumberReader reader = null;
			try { reader = new LineNumberReader( new InputStreamReader( file.getContents() ) ); }
			catch( CoreException e ) { return -1; }

			String id = getIdentifyingString( object, concept, property, language );
			String line;
			try
			{
				// LineNumberReader starts at 0 but the tag consumes 1 line so the current
				// value will wind up one past the opening tag.
				while( ( line = reader.readLine() ) != null )
					if( line.contains( id ) )
						return reader.getLineNumber();
			}
			catch( IOException e ) { /* empty */ }

			return -1;
		}
	}
}
