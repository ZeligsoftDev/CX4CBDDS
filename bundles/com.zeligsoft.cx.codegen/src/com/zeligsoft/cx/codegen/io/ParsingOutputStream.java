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

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.osgi.util.NLS;

import com.zeligsoft.cx.codegen.CodeGenPlugin;
import com.zeligsoft.cx.codegen.UserEditableRegion;
import com.zeligsoft.cx.codegen.l10n.Messages;
import com.zeligsoft.cx.codegen.postprocessor.CodeEditorPostProcessorRegistry;

/**
 * This output stream parses the user generated content to look for designated regions to be
 * put back into the model.  It raises errors if the tags have been edited in an invalid
 * way, e.g., two start tags, overlapping tags, etc.
 */
public class ParsingOutputStream extends FilterOutputStream
{
	private final Map<String, UserEditableRegion> regions = new LinkedHashMap<String, UserEditableRegion>();
	private final IResource problemResource;

	private int lineNum = 1;
	private UserEditableRegion activeRegion;
	private StringBuilder currLine = new StringBuilder();

	public ParsingOutputStream( OutputStream stm, IResource problemResource )
	{
		super( stm );
		this.problemResource = problemResource;
	}

	public Iterable<UserEditableRegion> getRegions()
	{
		return this.regions.values();
	}

	@Override
	public void write( int b ) throws IOException
	{
		out.write( b );

		if( b == '\n' )
			terminate_line();
		else
			currLine.append( (char)b );
	}

	@Override
	public void write( byte[] b, int off, int len ) throws IOException
	{
		out.write( b, off, len );

		int o = off, s = off;
		for( int i = 0; i < len; ++i, ++o )
		{
			if( b[o] == '\n' )
			{
				// Bug 91: Make sure the final character makes it into the string of user code.
				currLine.append( new String( b, s, o - s + 1 ) );
				terminate_line();
				s = o + 1;
			}
		}

		if( s < o )
		{
			currLine.append( new String( b, s, o - s ) );

			// Bug218: There is no newline, so don't terminate the line.  The partial content
			//         is cached in currLine where it can be continued on the next call to
			//         write.  Its also possible that there will be no more calls to #write,
			//         in which case the line will be terminated in #close.
		}
	}

	@Override
	public void close() throws IOException
	{
		terminate_line();

		// save the text within all regions back into the model
		for( UserEditableRegion region : this.regions.values() ) {
			region.commit();
		}
		
		CodeEditorPostProcessorRegistry.INSTANCE.postProcess();

		super.close();
	}

	private void terminate_line()
	{
		String line = check_tags();
		if( line != null
		 && this.activeRegion != null )
			this.activeRegion.text.append( line );
		++this.lineNum;
		this.currLine = new StringBuilder();
	}

	/**
	 * @return The trimmed line to add to the active region (if it exits) or null if the line
	 *         should not be added to the active region.
	 */
	private String check_tags()
	{
		// Bug 91: The trimmed string is OK for parsing, but make sure the non-trimmed version
		//         is returned.  The #trim operation will strip the trailing \r\n.
		String line = this.currLine.toString();
		String trimmedLine = line.trim();
		int index = trimmedLine.indexOf( UserEditableRegion.UserRegionTag );
		if( index < 0 )
			return line;

		int last = trimmedLine.length();
		index += UserEditableRegion.UserRegionTag.length();
		if( index >= last )
		{
			error(
				NLS.bind(
					Messages.ParsingOutputStream_MissingSpecifier,
					new String[]{ UserEditableRegion.UserEditBeginTag, UserEditableRegion.UserEditEndTag } ) );
			return line;
		}

		if( index + UserEditableRegion.UserEditEndTag.length() <= last
		 && trimmedLine.substring( index, index + UserEditableRegion.UserEditEndTag.length() ).equals( UserEditableRegion.UserEditEndTag ) )
		{
			String userCode = null;
			if (!trimmedLine.startsWith("/*")) {
				int ind = trimmedLine.indexOf("/*");
				userCode = trimmedLine.substring(0, ind);
			}
			exit(userCode);
			return null;
		}

		if( index + UserEditableRegion.UserEditBeginTag.length() <= last
		 && trimmedLine.substring( index, index + UserEditableRegion.UserEditBeginTag.length() ).equals( UserEditableRegion.UserEditBeginTag ) )
		{
			String userCode = null;
			String label = trimmedLine.substring(
					index + UserEditableRegion.UserEditBeginTag.length())
					.trim();
			if (!label.endsWith(UserEditableRegion.CommentEndString)) {
				int ind = label.indexOf(UserEditableRegion.CommentEndString);
				userCode = label.substring(ind + 2);
				userCode = userCode.concat(System.getProperty("line.separator"));
				label = label.substring(0, ind + 2);
			}
			enter(label);
			return userCode;
		}

		return null;
	}

	private void enter( String label )
	{
		if( this.activeRegion != null )
		{
			error( Messages.ParsingOutputStream_OverlappingRegion );

			// Bug218: Don't ignore this new region, just abandon the region that is currently
			//         being parsed.  If we've found a new begin tag, then the previous region's
			//         end tag must have been deleted.  We don't want to store all content that
			//         comes after where that end should be.
			// E.g.,
			// void f1() {
			//     // CXGEN-USERREGION-BEGIN f1-uri, etc.
			//     // stuff
			//     // CXGEN-USERREGION-E <-- spelled wrong so the parser misses it
			// }
			// void f2() {
			//     // CXGEN-USERREGION-BEGIN f2-uri, etc.
			//     // other stuff
			//     // CXGEN-USERREGION-END
			// }
			// ...
			//
			// In the old implementation of this function (returned at this point), this sample would
			// cause 'void f2()' (and related) to get stored in the user region for f1.  It would also
			// mean that f2 would not have any user content associated with it.  This fix means that
			// the changes to f1's user code will be lost, but parsing will recover properly for f2 and
			// later.  We need to throw away f1's changes because at this point the active region has
			// content like 'void f2() {'.
			this.regions.remove( this.activeRegion.label );
			this.activeRegion = null;
		}

		UserEditableRegion region = this.regions.get( label );
		if( region != null )
		{
			error(
				NLS.bind(
					Messages.ParsingOutputStream_DuplicateRegionLabel,
					Integer.valueOf( region.line ) ) );
			return;
		}

		this.activeRegion = new UserEditableRegion( label, this.lineNum );
		this.regions.put( label, this.activeRegion );
	}

	private void exit(String string) {
		if (string != null && this.activeRegion != null) {
			this.activeRegion.text.append(string);
			this.activeRegion = null;
		} else if (this.activeRegion != null) {
			this.activeRegion = null;
		} else {
			error(Messages.ParsingOutputStream_UnexpectedEnding);
		}
	}

	private void error( String message )
	{
		try
		{
			IMarker marker = this.problemResource.createMarker( IMarker.PROBLEM );
			marker.setAttribute( IMarker.SEVERITY, IMarker.SEVERITY_ERROR );
			marker.setAttribute( IMarker.MESSAGE, message );
			marker.setAttribute( IMarker.LINE_NUMBER, this.lineNum );
			marker.setAttribute( IMarker.CHAR_START, -1 );
			marker.setAttribute( IMarker.CHAR_END, -1 );
		}
		catch( CoreException e )
		{
			CodeGenPlugin.getDefault().error( Messages.ParsingOutputStream_ProblemCreateError, e );
		}
	}
}
