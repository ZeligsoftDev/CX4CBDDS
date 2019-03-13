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
package com.zeligsoft.cx.langc.m2t;

import org.eclipse.core.resources.IProject;

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.Name;
import com.zeligsoft.cx.langc.util.Partitioner;

/**
 * An output writer for C code needs to produce both the header and implementation files.
 */
public class CWriter {
	private final CodeWriter iface;
	private final CodeWriter impl;

	private CWriter( CodeWriter iface, CodeWriter impl ) {
		this.iface = iface;
		this.impl = impl;
	}

	public static CWriter createProvisional( IProject project, Name name ) {

		String basePath = project.getLocation().toString();
		CodeWriter iface = CodeWriter.createProvisional( basePath, Partitioner.headerPathname( name ) );
		CodeWriter impl = CodeWriter.createProvisional( basePath, Partitioner.implPathname( name ) );
		if( iface == null
		 || impl == null )
			return null;

		CWriter writer = new CWriter( iface, impl );

		String protectionMacro = getProtectionMacro(name) + "_H"; //$NON-NLS-1$
		if( ! writer.decl().newline()
		 || ! writer.decl().write( "#ifndef " ) //$NON-NLS-1$
		 || ! writer.decl().writeLn( protectionMacro )
		 || ! writer.decl().write( "#define " ) //$NON-NLS-1$
		 || ! writer.decl().writeLn( protectionMacro )
		 || ! writer.decl().newline() )
			return null;

		writer.decl().enableWrites();
		return writer;
	}

	private static String asCPPMacro( String str ) {
		return str.toUpperCase().replaceAll("[/-]", "_");  //$NON-NLS-1$//$NON-NLS-2$
	}

	private static String getProtectionMacro(Name name) {
		Name parent = name.getParent();
		String macro = asCPPMacro(name.getName());
		return parent == null ? macro : getProtectionMacro(parent) + '_' + macro;
	}

	public void release() {

		if( ! decl().isProvisional() ) {
			decl().newline();
			decl().writeLn("#endif"); //$NON-NLS-1$
		}

		decl().close();
		defn().close();
	}

	public CodeWriter decl() {
		return this.iface;
	}

	public CodeWriter defn() {
		return this.impl;
	}
}
