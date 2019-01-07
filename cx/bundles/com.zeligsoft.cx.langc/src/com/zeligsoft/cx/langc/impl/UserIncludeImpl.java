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
package com.zeligsoft.cx.langc.impl;

import org.eclipse.emf.ecore.EClass;

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.ElementList;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.UserInclude;
import com.zeligsoft.cx.langc.util.Partitioner;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Include</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class UserIncludeImpl extends FileDependencyImpl implements UserInclude {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserIncludeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.USER_INCLUDE;
	}

	@Override
	protected boolean writeFile(CodeWriter code) {

		return code.write( '"' )
			&& code.write(Partitioner.includePath(getFilename()))
			&& code.write( '"' );
	}

	@Override
	public boolean refersTo(ElementList elementList) {
		return elementList.getName().equals(getFilename());
	}

} //UserIncludeImpl
