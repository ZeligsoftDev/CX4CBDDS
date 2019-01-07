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

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;

import com.zeligsoft.base.langc.BooleanOperator;
import com.zeligsoft.base.langc.Element;
import com.zeligsoft.base.langc.ElementList;
import com.zeligsoft.base.langc.ElementReference;
import com.zeligsoft.base.langc.Expression;
import com.zeligsoft.base.langc.FileName;
import com.zeligsoft.base.langc.FunctionPointer;
import com.zeligsoft.base.langc.Name;
import com.zeligsoft.base.langc.NamedReference;
import com.zeligsoft.base.langc.Operator;
import com.zeligsoft.base.langc.UserElement;
import com.zeligsoft.base.langc.VariableDeclaration;
import com.zeligsoft.base.langc.util.LangCSwitch;
import com.zeligsoft.base.langc.util.Partitioner;

public class M2TGenerator extends LangCSwitch<Boolean>{

	private M2TGenerator() { /* empty */ }

	private static IProject destProject;
	private static Map<FileName, CodeWriter> headers = new HashMap<FileName, CodeWriter>();
	private static Map<FileName, CodeWriter> impls = new HashMap<FileName, CodeWriter>();
	public static boolean initializeGenerator( String destProjectName ) {

		headers.clear();
		impls.clear();

		IResource dest = ResourcesPlugin.getWorkspace().getRoot().findMember(destProjectName);
		if( dest == null )
			return false;

		destProject = (IProject)dest.getAdapter( IProject.class );
		return destProject != null;
	}

	/**
	 * This should be called to cleanup at the end of the generation process.  It will close all
	 * writers and return a list of the implementation files that contain code.
	 */
	public static Collection<FileName> getPopulatedObjectFiles( Collection<FileName> objectFiles ) {

		Set<FileName> files = new HashSet<FileName>();
		if( objectFiles == null )
			return files;

		for( FileName filename : objectFiles ) {
			CodeWriter impl = impls.get( filename );
			if( impl != null
			 && ! impl.isProvisional() )
				files.add( filename );
		}

		return files;
	}

	public static void finalizeGenerator() {

		for( CodeWriter writer : headers.values() ) {
			if( ! writer.isProvisional() ) {
				writer.newline();
				writer.writeLn("#endif"); //$NON-NLS-1$
			}
			writer.close();
		}

		for( CodeWriter writer : impls.values() )
			writer.close();

	}

	private static String getBasePath() {
		return destProject == null
				? new String()
				: ( destProject.getLocation().toString() + '/' );
	}

	private static CodeWriter getHeader( FileName filename ) {
		CodeWriter writer = headers.get( filename );
		if( writer == null ) {
			writer = CodeWriter.createProvisional( getBasePath() + Partitioner.headerPathname( filename ) );

			String protectionMacro = getProtectionMacro(filename) + "_H"; //$NON-NLS-1$
			if( ! writer.newline()
			 || ! writer.write( "#ifndef " ) //$NON-NLS-1$
			 || ! writer.writeLn( protectionMacro )
			 || ! writer.write( "#define " ) //$NON-NLS-1$
			 || ! writer.writeLn( protectionMacro )
			 || ! writer.newline() )
				return null;

			writer.enableWrites();
			headers.put( filename, writer );
		}
		return writer;
	}

	private static CodeWriter getImpl( FileName filename ) {
		CodeWriter writer = impls.get( filename );
		if( writer == null ) {
			writer = CodeWriter.createProvisional( getBasePath() + Partitioner.implPathname( filename ) );
			if( ! writer.newline()
			 || ! writer.write( "#include \"" ) //$NON-NLS-1$
			 || ! writer.write( Partitioner.includePath( filename ) )
			 || ! writer.writeLn( '"' )
			 || ! writer.newline() )
				return null;

			writer.enableWrites();
			impls.put( filename, writer );
		}
		return writer;
	}

	/**
	 * Called from XPand.
	 */
	public static boolean generate( UserElement element, FileName headerFile, FileName implFile ) {

		CodeWriter header = headerFile == null ? null : getHeader( headerFile );
		CodeWriter impl = implFile == null ? null : getImpl( implFile );

		// TODO This should get replaced with something that sends the CodeWriters directly to
		//      the element's writeDecl/writeDefn methods.
		element.setWritten( element.write( new CWriter( header, impl ) ) );

		return false;
	}

	public static boolean write( CodeWriter code, Operator op ) {
		switch(op) {
		case ADD: return code.write('+');
		case ASSIGN: return code.write('=');
		case BITWISE_AND: return code.write('&');
		case BITWISE_OR: return code.write('|');
		case SUBTRACT: return code.write('-');
		case MULTIPLY: return code.write('*');
		case DIVIDE: return code.write('/');
		default: return false;
		}
	}

	public static boolean write( CodeWriter code, BooleanOperator op ) {
		switch(op) {
		case LESS_THAN: return code.write('<');
		case GREATER_THAN: return code.write('>');
		case LESS_THAN_EQUAL: return code.write("<="); //$NON-NLS-1$
		case GREATER_THAN_EQUAL: return code.write(">="); //$NON-NLS-1$
		case EQUIVALENT: return code.write("=="); //$NON-NLS-1$
		case NOT_EQUIVALENT: return code.write("!="); //$NON-NLS-1$
		default: return false;
		}
	}

	public static boolean needsParens( Expression expr, int neighbouringPrecendence ) {
		return expr.getPrecendence() < neighbouringPrecendence;
	}

	public static boolean isIndirect( ElementReference ref ) {
		if( ref == null )
			return false;

		return ref != null
			&& ( ref.getPointerSpec().size() > 0
			  || isIndirect( ref.getElement() ) );
	}

	public static boolean isIndirect( Element element ) {

		if( element instanceof FunctionPointer )
			return true;
		else if( element instanceof VariableDeclaration )
			return isIndirect( ( (VariableDeclaration)element ).getElement() );
		else
			return false;
	}

	public static boolean isIndirect( NamedReference ref ) {
		return isIndirect(ref.getType());
	}

	public static boolean isIndirect( Expression expr ) {
		return isIndirect(expr.getType());
	}

	private static String asCPPMacro( String str ) {
		return str.toUpperCase().replaceAll("[/-]", "_");  //$NON-NLS-1$//$NON-NLS-2$
	}

	private static String getProtectionMacro(Name name) {
		Name parent = name.getParent();
		String macro = asCPPMacro(name.getName());
		return parent == null ? macro : getProtectionMacro(parent) + '_' + macro;
	}

	public static boolean generate_old( ElementList elementList, String destProjectName) {
		IResource dest = ResourcesPlugin.getWorkspace().getRoot().findMember(destProjectName);
		if( dest == null )
			return false;

		IProject destProject = (IProject)dest.getAdapter(IProject.class);
		if( dest == null )
			return false;

		FileName name = elementList.getName();
		CWriter writer = new CWriter( getHeader( name ), getImpl( name ) );
		if( writer == null )
			return false;

		elementList.write(writer);

		// If the definition's writer is still in provisional mode, then no content was
		// generated into the .c file.  Update the flag in the FileName so that the
		// sources.mk will contain an accurate list of buildable content.
		elementList.getName().setHasObjectCode( ! writer.defn().isProvisional() );

		writer.release();
		return true;
	}
}
