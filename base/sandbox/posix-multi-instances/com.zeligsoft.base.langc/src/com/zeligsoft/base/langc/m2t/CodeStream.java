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
package com.zeligsoft.base.langc.m2t;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class CodeStream extends OutputStream {

	private final String pathname;

	private final byte[] inBuff;
	private int in;
	private int end;
	private int len = 0;

	private OutputStream out;
	private RandomAccessFile existing;

	private boolean provisional = false;
	private StringBuilder provisionalBuffer;

	public static CodeStream create( String pathname, int buffLen ) {
		CodeStream stm = new CodeStream( pathname, buffLen );
		try { stm.createFile(); }
		catch( IOException e ) { return null; }
		return stm;
	}

	public static CodeStream createProvisional( String pathname, int buffLen ) {
		CodeStream stm = new CodeStream( pathname, buffLen );
		stm.provisional = true;
		stm.provisionalBuffer = new StringBuilder( 512 );
		return stm;
	}

	public static CodeStream create( String pathname ) {
		return create( pathname, 64 * 1024 );
	}

	public static CodeStream createProvisional( String pathname ) {
		return createProvisional( pathname, 64 * 1024 );
	}

	private CodeStream( String pathname, int buffLen ) {
		this.pathname = pathname;
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
	 * Return true if the stream is able to write and false otherwise.
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
		if (!dir.exists())
			dir.mkdirs();
		this.existing = new RandomAccessFile( file, "rw" ); //$NON-NLS-1$
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

		// includes case of reading EOF from existing file
		if( next >= 0 )
			existing.setLength( len - end + in - 1 );

		out = new BufferedOutputStream( new FileOutputStream( existing.getFD() ) );

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
				// don't set length when appending to existing
				if( next >= 0 )
					existing.setLength( Math.max( 0, len - end + in - 1 ) );

				out = new BufferedOutputStream( new FileOutputStream( existing.getFD() ) );

				existing.close();
				existing = null;

				out.write(b, o, l);
				return;
			}
		}
	}

	@Override
	public void close() throws IOException {

		// if still in provisional mode, then nothing should be
		// written, delete the existing file if it exists
		if( isProvisional() )
			new File( this.pathname ).delete();

		if( out != null )
			out.close();

		if( existing != null )
		{
			int newLen = len - end + in;
			if( existing.length() > newLen )
				existing.setLength( newLen );
			existing.close();
		}
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
