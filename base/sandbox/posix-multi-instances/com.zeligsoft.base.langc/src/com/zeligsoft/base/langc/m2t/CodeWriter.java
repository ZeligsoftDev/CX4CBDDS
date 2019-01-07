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

import java.io.IOException;

@SuppressWarnings("nls")
public class CodeWriter {

	private final CodeStream stm;

	private int indentLevel = 0;
	private static final String Indent = "    ";
	private boolean wroteNewline = false;

	public static CodeWriter create( String pathname ) {
		CodeStream stm = CodeStream.create(pathname);
		return stm == null ? null : new CodeWriter( stm );
	}

	public static CodeWriter createProvisional( String pathname ) {
		CodeStream stm = CodeStream.createProvisional(pathname);
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

	public boolean write( String str ) {
		if( str == null )
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
					stm.write( str.substring( lastNewline ).getBytes() );
					return true;
				}

				stm.write( str.substring( lastNewline, nextNewline ).getBytes() );
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

			stm.write( (byte)c );
			wroteNewline = c == '\n';
		}
		catch( IOException e )
		{
			return false;
		}
		return true;
	}

	private boolean writeIndent() {
		if( wroteNewline )
		{
			for( int i = 0; i < indentLevel; ++i )
				stm.write( Indent );
			wroteNewline = false;
		}

		return true;
	}

	public boolean incIndent() { ++indentLevel; return true; }
	public boolean decIndent() { --indentLevel; return true; }

	public boolean space() {
		return write( ' ' );
	}

	public boolean newline() {
		return write( '\n' );
	}

	public boolean terminate() {
		return writeLn( ';' );
	}

	public boolean openBrace() {
		if( ( ! wroteNewline && ! newline() )
		 || ! writeLn( '{' ) )
			return false;

		++indentLevel;
		return true;
	}

	public boolean closeBrace( boolean trailingNewline ) {
		--indentLevel;
		return ( wroteNewline || newline() )
			&& write( '}' )
			&& ( ! trailingNewline || newline() );
	}

	public boolean closeBrace() {
		return closeBrace( true );
	}

	public boolean writeLn( char c ) {
		return write( c )
			&& newline();
	}

	public boolean writeLn( String str ) {
		return write( str )
			&& newline();
	}
}
