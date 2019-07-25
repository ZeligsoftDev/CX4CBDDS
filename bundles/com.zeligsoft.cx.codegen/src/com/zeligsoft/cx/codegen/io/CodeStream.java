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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

import org.eclipse.core.runtime.Platform;

import com.zeligsoft.cx.codegen.UserEditableRegion;
import com.zeligsoft.cx.codegen.internal.CodeStreamObserverRegistry;

// TODO This should log the IOExceptions
public class CodeStream extends OutputStream {

	private static final boolean TRACE_NEWFILE
		= Boolean.parseBoolean(
			Platform.getDebugOption( "com.zeligsoft.cx.langc/trace-codestream-newfile" ) ); //$NON-NLS-1$

	private final String basePath;
	private final String relPath;
	private final String pathname;

	private final byte[] inBuff;
	private int in;
	private int end;
	private int len = 0;

	private OutputStream out;
	private RandomAccessFile existing;
	private boolean hadFile;

	/**
	 * There is often standard code that needs to be written to the start of a file, e.g.,
	 * the protection macros.  Generating this content is not reason enough for a new file to
	 * be generated, the file should only be created when real content is written.  The
	 * provisional mode allows this boilerplate content to be written to the buffer, without
	 * causing a file to be created.  CodeStreams that start out in provisional mode, simply
	 * buffer all writes to memory.  At some later point #enableWrites is called.  After that
	 * point any write will cause the in buffer memory to be flushed to disk, followed by the
	 * the new content.
	 * This provisional flag is distinct from the work that happens to replace a file only when
	 * its content has changed.  Provisional settings are only to prevent files that look like:
	 *     #ifndef SOMEFILE_H
	 *     #define SOMEFILE_H
	 *	   // <no actual content>
	 *     #endif // SOMEFILE_H
	 */
	private boolean provisional = false;

	private StringBuilder provisionalBuffer;

	public static interface IObserver
	{
		public void preModifyFile( String pathname );
		public void modifiedFileClosed( String pathname );
		public void newFileCreated( String pathname );
		public static class Adapter implements IObserver
		{
			public void preModifyFile( String pathname ) { }
			public void modifiedFileClosed( String pathname ) { }
			public void newFileCreated( String pathname ) { }
		}
	}

	public static CodeStream create( String basePath, String relPath, int buffLen ) {
		CodeStream stm = new CodeStream( basePath, relPath, buffLen );
		try { stm.createFile(); }
		catch( IOException e ) { return null; }
		return stm;
	}

	public static CodeStream createProvisional( String basePath, String relPath, int buffLen ) {
		CodeStream stm = new CodeStream( basePath, relPath, buffLen );
		stm.provisional = true;
		stm.provisionalBuffer = new StringBuilder( 512 );
		return stm;
	}

	public static CodeStream create( String basePath, String relPath ) {
		return create( basePath, relPath, 64 * 1024 );
	}

	public static CodeStream createProvisional( String basePath, String relPath ) {
		return createProvisional( basePath, relPath, 64 * 1024 );
	}

	private CodeStream( String basePath, String relPath, int buffLen ) {
		this.basePath = basePath;
		this.relPath = relPath;
		this.pathname = basePath + '/' + relPath;
		this.inBuff = new byte[buffLen];
		this.in = 0;
		this.end = 0;
	}

	private int next() throws IOException {
		if( in >= end )
		{
			end = existing.read( inBuff );
			len += end;
			in = 0;
		}

		return in >= end ? -1 : inBuff[in++];
	}

	/**
	 * Modify the stream to allow new content to be written to the filesystem.
	 */
	public void enableWrites()
	{
		this.provisional = false;
	}

	/**
	 * Return true if the receiver is in provisional mode and false otherwise.
	 */
	public boolean isProvisional()
	{
		// the receiver is in provisional mode until the buffer is flushed
		return this.provisional
			|| this.provisionalBuffer != null;
	}

	private void createFile() throws IOException {

		File file = new File( this.pathname );
		File dir = file.getParentFile();
		if( ! dir.exists() )
			dir.mkdirs();
		this.existing = new RandomAccessFile( file, "rw" ); //$NON-NLS-1$
		this.hadFile = this.existing.length() > 0;
	}

	/** Buffer must not be flushed when the receiver is still in provisional mode. */
	private void flushProvisionalBuffer() throws IOException {

		if( this.provisional
		 || this.provisionalBuffer == null )
			return;

		// flush is only called when there is something to write, so the
		// file must be created, etc. at this point
		createFile();

		// disable the provisional buffer before starting a recursive path
		StringBuilder buff = this.provisionalBuffer;
		this.provisionalBuffer = null;
		write( buff.toString().getBytes() );
	}

	@Override
	public void write(int b) throws IOException {

		// if the stream is in provisional mode, then just write to the buffer
		if( this.provisional
		 && this.provisionalBuffer != null )
		{
			this.provisionalBuffer.append( (char)b );
			return;
		}

		// otherwise make sure the buffer has been flushed
		flushProvisionalBuffer();

		// and continue with the normal write
		if( out != null )
		{
			out.write(b);
			return;
		}

		int next = next();
		if( next == b )
			return;

		if( TRACE_NEWFILE )
			System.out.println( "Updating " + this.pathname ); //$NON-NLS-1$

		if( this.hadFile )
			CodeStreamObserverRegistry.preModifyFile( this.pathname );

		// includes case of reading EOF from existing file
		if( next >= 0 )
			existing.setLength( len - end + in - 1 );

		out = createNewFile();

		existing.close();
		existing = null;

		out.write( b );
	}

	@Override
	public void write(byte[] b, int o, int l) throws IOException {

		// if the stream is in provisional mode, then just write to the buffer
		if( this.provisional
		 && this.provisionalBuffer != null )
		{
			while( o < l )
				this.provisionalBuffer.append( (char)b[o++] );
			return;
		}

		// otherwise make sure the buffer has been flushed
		flushProvisionalBuffer();

		// and continue with the normal write
		for( ; l > 0; ++o, --l) {
			if( out != null )
			{
				out.write(b, o, l);
				return;
			}

			int next = next();
			if( next != b[o] )
			{
				if( TRACE_NEWFILE )
					System.out.println( "Updating " + this.pathname ); //$NON-NLS-1$

				if( this.hadFile )
					CodeStreamObserverRegistry.preModifyFile( this.pathname );
				
				// don't set length when appending to existing
				if( next >= 0 )
					existing.setLength( Math.max( 0, len - end + in - 1 ) );

				out = createNewFile();

				existing.close();
				existing = null;

				out.write(b, o, l);
				return;
			}
		}
	}

	@Override
	public void close() throws IOException {

		boolean modified = false;
		boolean created = false;

		// if still in provisional mode, then nothing should be
		// written, delete the existing file if it exists
		if( isProvisional() )
		{
			if( this.hadFile )
			{
				CodeStreamObserverRegistry.preModifyFile( this.pathname );
				modified = true;
			}
			new File( this.pathname ).delete();
		}

		if( out != null )
		{
			out.close();
			if( this.hadFile )
				modified = true;
			else
				created = true;

			// The out field will only be have a value when the content has changed.  The type
			// of the file should only change when its content has changed (a marker comment
			// has either been added or removed).
			InputStream in = null;
			try
			{
				in = new FileInputStream( this.pathname );
				UserEditableRegion.refreshFileStoreKind( this.basePath, this.relPath, in );
			}
			catch( FileNotFoundException e ) { return; }
			finally
			{
				if( in != null )
					try { in.close(); }
					catch( IOException e ) { /* empty */ }
			}
		}

		if( existing != null )
		{
			int newLen = len - end + in;
			if( existing.length() > newLen )
			{
				CodeStreamObserverRegistry.preModifyFile( this.pathname );
				existing.setLength( newLen );
				modified = true;
			}
			existing.close();
		}

		if( modified )
			CodeStreamObserverRegistry.modifiedFileClosed( this.pathname );
		else if( created )
			CodeStreamObserverRegistry.newFileCreated( this.pathname );
	}

	/**
	 * Creates and returns a newly initialized file for the receiver's stream.
	 */
	private OutputStream createNewFile() throws IOException
	{
		// Bug 15048: The line that is commented out will work on J9, but not on Sun's VM.  The
		//            J9 VM seems to keep track of who is using the fd, the Sun VM does not.
		//            The Sun VM runs (without throwing exceptions), but does not write anything
		//            to the file.
//		return new BufferedOutputStream( new FileOutputStream( existing.getFD() ) );

		long ptr = existing.getFilePointer();
		if( existing.length() > ptr )
			existing.setLength( ptr - 1 );

		return new BufferedOutputStream( new FileOutputStream( this.pathname, true ) );
	}

	// TODO move these to a CodeStreamFormatter
	public boolean write( String str ) {
		if( str == null )
			return true;

		try { write( str.getBytes() ); }
		catch( IOException e ) { return false; }
		return true;
	}

	public boolean write( char c ) {
		try { write( (byte)c ); }
		catch( IOException e ) { return false; }
		return true;
	}
}
