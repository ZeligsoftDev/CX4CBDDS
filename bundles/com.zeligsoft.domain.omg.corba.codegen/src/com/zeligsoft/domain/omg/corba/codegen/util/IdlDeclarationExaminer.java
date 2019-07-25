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
package com.zeligsoft.domain.omg.corba.codegen.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.domain.omg.corba.dsl.idl.AttrDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Export;
import com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Member;
import com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;
import com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType;
import com.zeligsoft.domain.omg.corba.dsl.idl.StructType;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.util.IdlSwitch;

/**
 * Examines types in the IDL model to build a list of the required declarations.
 * @author jfront incorporated
 */
@SuppressWarnings("unchecked")
public class IdlDeclarationExaminer extends IdlSwitch<Object> {

	// the class is stateless
	private static final IdlDeclarationExaminer Instance = new IdlDeclarationExaminer();

	public static Iterable<String> getRequiredDecls(EObject object) {
		Object decls = Instance.doSwitch(object);
		if( decls == null )
			return Collections.emptyList();
		return (Iterable<String>)decls;
	}

	@Override
	public Object caseTypeDeclarator(TypeDeclarator object) {
		return getRequiredDecls(object.getType());
	}

	@Override
	public Object caseSequenceType(SequenceType object) {
		return getRequiredDecls(object.getType());
	}

	@Override
	public Object caseScopedName(ScopedName object) {
		return object.getName();
	}

	@Override
	public Object caseStructType(StructType object) {

		List<String> reqDecls = new LinkedList<String>();
		for( Member member : object.getMembers() ) {
			String name = IdlDeclarationInspector.getDeclaration(member.getType());
			if( name != null )
				reqDecls.add( name );
		}

		return reqDecls;
	}

	@Override
	public Object caseOpDecl(OpDecl object) {

		List<String> reqDecls = new LinkedList<String>();
		String name = IdlDeclarationInspector.getDeclaration(object.getType());
		if( name != null )
			reqDecls.add( name );
		for( ParamDcl decl : object.getParams().getDecls() ) {
			name = IdlDeclarationInspector.getDeclaration(decl.getType());
			if( name != null )
				reqDecls.add( name );
		}
		for( ScopedName exception : object.getRaises().getException() ) {
			name = IdlDeclarationInspector.getDeclaration(exception);
			if( name != null )
				reqDecls.add( name );
		}

		return reqDecls;
	}

	@Override
	public Object caseInterface_decl(Interface_decl object) {
		List<String> reqDecls = new LinkedList<String>();
		for( Export export : object.getInterfaceBody().getExport() )
			for( String reqDecl : getRequiredDecls(export))
				reqDecls.add( reqDecl );
		for( EObject export : object.getHeader().getSpecializes() )
			for ( String reqDecl : getRequiredDecls(export))
				reqDecls.add( reqDecl );
			
		return reqDecls;
	}

	@Override
	public Object caseAttrDecl(AttrDecl object) {
		return getRequiredDecls(object.getType());
	}
}
