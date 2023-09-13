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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringBufferInputStream;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.Outlet;

import com.zeligsoft.cx.codegen.CodeGenPlugin;
import com.zeligsoft.cx.codegen.UserEditableRegion;
import com.zeligsoft.cx.codegen.l10n.Messages;

@SuppressWarnings("deprecation")
public class CXGenFileHandle implements FileHandle
{
	private final Logger log = LoggerFactory.getLogger( getClass() );

	private final CXGenOutlet outlet;
	private final String basePath;
	private final String relPath;

	private File targetFile;
	private StringBuffer buffer = new StringBuffer();

	public CXGenFileHandle( CXGenOutlet outlet, String basePath, String filePath )
	{
		this.outlet = outlet;
		this.basePath = basePath;
		this.relPath = filePath;
	}

	/**
	 * The OAW code really likes writing directly to the underlying java.io.files.  This implementation
	 * allows for that by updating Eclipse's view of the file in #writeAndClose.  All other code
	 * should be ok with the raw file being returned here.
	 * <p>
	 * NOTE: A benefit of this approach is that we don't waste time writing the generator's output
	 *       through the ParsingOutputStream (which would then store the user-sections back to the
	 *       model).
	 */
	public File getTargetFile()
	{
		if( this.targetFile == null )
		{
			IPath path = new Path( this.basePath ).append( this.relPath );
			this.targetFile = new File( path.makeAbsolute().toPortableString() );
		}

		return this.targetFile;
	}

	/**
	 * The API says this is a CharSequence, but the OAW implementation casts it to
	 * a StringBuffer while executing the rules.
	 */
	public CharSequence getBuffer() { return this.buffer; }
	public void setBuffer( CharSequence buffer ) { this.buffer = new StringBuffer( buffer ); }

	public Outlet getOutlet() { return this.outlet; }
	public boolean isAppend() { return this.outlet.isAppend(); }
	public boolean isOverwrite() { return this.outlet.isOverwrite(); }
	public String getFileEncoding() { return this.outlet.getFileEncoding(); }

	public void writeAndClose()
	{
		if( ! isOverwrite()
		 && getTargetFile().exists() )
		{
			if( this.log.isDebugEnabled() )
				this.log.debug(
					NLS.bind( Messages.CXGenFileHandle_FileExists, getTargetFile().getName() ) );
			return;
		}
		if( this.log.isDebugEnabled() )
			this.log.debug( NLS.bind( Messages.CXGenFileHandle_OpeningFile, getTargetFile().getName() ) );

		outlet.beforeWriteAndClose( this );

		// Update Eclipse's view of the file before letting OAW auto-import the filename.
		UserEditableRegion.refreshFileStoreKind(
				this.basePath, this.relPath,
				new StringBufferInputStream( this.buffer.toString() ) );

		if( outlet.shouldWrite( this ) )
		{
			OutputStream out = null;
			try
			{
				// Write directly to the underlying java.io.File to avoid going through the
				// cxgen:// filesystem's ParsingOutputStream.
				// NOTE: Removing the call to #refreshFileStoreKind and using the FileStore
				//       here will not work in the case where the underlying file content has
				//       not changed.  See the comment in #refreshFileStoreKind for more detail.
				out = new FileOutputStream( getTargetFile() );
				out.write( getBytes() );
			}
			catch( IOException e )
			{
				CodeGenPlugin.getDefault().error(
					NLS.bind(
						Messages.CXGenFileHandle_CannotWriteFile,
						new String[]{ this.basePath, this.relPath } ),
					e );
				throw new RuntimeException( e );
			}
			finally
			{
				if( out != null )
					try { out.close(); }
					catch( IOException e ) { /* empty */ }
					finally { outlet.afterClose( this ); }
			}
		}
	}

	private byte[] getBytes()
	{
		String encoding = getFileEncoding();
			try { return buffer.toString().getBytes( encoding ); }
			catch( final UnsupportedEncodingException e )
			{
				CodeGenPlugin.getDefault().error(
						NLS.bind(
							Messages.CXGenFileHandle_CannotEncodeFile,
							new String[]{ this.basePath, this.relPath } ),
						e );
			}

		return buffer.toString().getBytes();
	}

	@Override
	public String getAbsolutePath()
	{
		return getTargetFile().getAbsolutePath();
	}
}
