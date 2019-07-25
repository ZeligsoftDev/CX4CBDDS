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

import com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl;
import com.zeligsoft.domain.omg.corba.dsl.idl.util.IdlSwitch;

/**
 * @author jfront incorporated
 */
public class IdlForwardDeclarationGenerator extends IdlSwitch<Object> {

	private final StringBuffer buf;
	private final String indentString;

	private IdlForwardDeclarationGenerator(StringBuffer buf, String indentString) {
		this.buf = buf;
		this.indentString = indentString;
	}

	public static void generate(StringBuffer buf, String indentString, EObject object) {
		new IdlForwardDeclarationGenerator(buf, indentString).doSwitch(object);
	}

	@Override
	public Object caseInterface_decl(Interface_decl object) {
		buf.append(
			String.format(
				"%sinterface %s;%n", this.indentString, object.getHeader().getName())); //$NON-NLS-1$
		return null;
	}
}
