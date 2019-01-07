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

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.domain.omg.corba.codegen.l10n.Messages;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConstrTypeSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.Declarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.EnumType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl;
import com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;
import com.zeligsoft.domain.omg.corba.dsl.idl.StructType;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnionType;
import com.zeligsoft.domain.omg.corba.dsl.idl.util.IdlSwitch;

/**
 * Examines elements of the IDL model to extract the name for declarations.  Returns null
 * if the parameter is not a declaration.
 * @author jfront incorporated
 */
public class IdlDeclarationInspector extends IdlSwitch<Object> {

	// the class is stateless
	private static final IdlDeclarationInspector Instance = new IdlDeclarationInspector();

	public static String getDeclaration(EObject object) {
		if( object == null) return null;
		
		return (String)Instance.doSwitch(object);
	}

	// TODO For now only interfaces are tracked.  The general solution can be extended
	//      by adding new case implementations.

	@Override
	public Object caseInterface_decl(Interface_decl object) {
		return object.getHeader().getName();
	}

	// The following simple accessors are needed to get the declaration string from
	// the components of the complex types.  E.g., to get the declaration that is
	// required for the return type of an operation.

	@Override
	public Object caseConstrTypeSpec(ConstrTypeSpec object) {
		Object result = null;
		if(object instanceof StructType) {
			result = ((StructType) object).getName();
		} else if(object instanceof UnionType) {
			result = ((UnionType) object).getName();
		} else if(object instanceof EnumType) {
			result = ((EnumType) object).getName();
		} else {
			throw new IllegalArgumentException(String.format(Messages.IdlDeclarationInspector_UnknownConstrTypeSpec, object));
		}
		
		return result;
	}

	@Override
	public Object caseExceptDecl(ExceptDecl object) {
		return object.getName();
	}

	@Override
	public Object caseTypeDeclarator(TypeDeclarator object) {
		// TODO I'm not sure why this is a list, I think its for the IDL equivalent
		//      of this C "int i, j;".  However, there aren't any examples of that
		//      in here, so I'm just taking the 1st element like in the IDLWriter.
		// It might be necessary to move the undeclareds map into this class, I've
		// avoided that for now, because its kind of nice to have it stateless.
		return getDeclaration(object.getDeclarators().get(0));
	}

	@Override
	public Object caseDeclarator(Declarator object) {
		return object.getId();
	}

	@Override
	public Object caseScopedName(ScopedName object) {
		String name = null;
		for( String n : object.getName() ) {
			if (name == null)
				name = n;
			else
				name += "::" + n; //$NON-NLS-1$
		}

		return name;
	}

	@Override
	public Object caseOpDecl(OpDecl object) {
		return object.getName();
	}
}
