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

import java.io.IOException;


public class CodeWriter {

	private final CodeStream stm;

	private int indentLevel = 0;
	private static final String Indent = "    "; //$NON-NLS-1$
	private char lastChar = '\0';
	private boolean wroteBlankLine = false;

	public static CodeWriter create( String basePath, String relPath ) {
		CodeStream stm = CodeStream.create( basePath, relPath );
		return stm == null ? null : new CodeWriter( stm );
	}

	public static CodeWriter createProvisional( String basePath, String relPath ) {
		CodeStream stm = CodeStream.createProvisional( basePath, relPath );
		return stm == null ? null : new CodeWriter( stm );
	}

	public void enableWrites() {
		this.stm.enableWrites();
	}

	public boolean isProvisional() {
		return this.stm.isProvisional();
	}

	private CodeWriter( CodeStream stm ) {
		this.stm = stm;
	}

	public void close() {
		try { this.stm.close(); }
		catch( IOException e ) { /* empty */ }
	}

	// TODO This should look inside arg and then decide if its valid to collapse
	//      internal characters.
	private void output( String str ) throws IOException
	{
		stm.write( str.getBytes() );
		if( str.length() > 0 )
		{
			lastChar = str.charAt( str.length() - 1 );
			if( lastChar != '\n' )
				wroteBlankLine = false;
		}
	}

	private void output( char c ) throws IOException
	{
		stm.write( (byte)c );
		lastChar = c;
		if( lastChar != '\n' )
			wroteBlankLine = false;
	}

	public boolean write( String str ) {
		if( str == null
		 || str.isEmpty() )
			return true;

		try
		{
			writeIndent();

			int lastNewline = 0;
			while( lastNewline >= 0 )
			{
				int nextNewline = str.indexOf( '\n', lastNewline + 1 );
				if( nextNewline < 0 )
				{
					output( str.substring( lastNewline ) );
					return true;
				}

				output( str.substring( lastNewline, nextNewline ) );
				newline();

				lastNewline = nextNewline + 1;
			}
		}
		catch( IOException e )
		{
			return false;
		}
		return true;
	}

	public boolean write( char c ) {
		try
		{
			if( c != '\n' )
				writeIndent();

			output( c );
		}
		catch( IOException e )
		{
			return false;
		}
		return true;
	}

	private boolean writeIndent() {
		if( lastChar == '\n' )
		{
			for( int i = 0; i < indentLevel; ++i )
				try { output( Indent ); }
				catch( IOException e ) { /* empty */ }
		}

		return true;
	}

	public boolean incIndent() { ++indentLevel; return true; }
	public boolean decIndent() { --indentLevel; return true; }

	public boolean space()
	{
		return lastChar == ' '
			|| lastChar == '\n'
			|| write( ' ' );
	}

	public boolean newline()
	{
		if( lastChar != '\n' )
			return write( '\n' );

		if( wroteBlankLine )
			return true;

		wroteBlankLine = true;
		return write( '\n' );
	}

	public boolean terminate()
	{
		return writeLn( ';' );
	}

	public boolean openBrace()
	{
		if( ( lastChar != '\n' && ! newline() )
		 || ! writeLn( '{' ) )
			return false;

		++indentLevel;
		return true;
	}

	public boolean closeBrace( boolean trailingNewline )
	{
		--indentLevel;
		return ( lastChar == '\n' || newline() )
			&& write( '}' )
			&& ( ! trailingNewline || newline() );
	}

	public boolean closeBrace()
	{
		return closeBrace( true );
	}

	public boolean writeLn( char c )
	{
		return write( c )
			&& newline();
	}

	public boolean writeLn( String str )
	{
		return write( str )
			&& newline();
	}
}
