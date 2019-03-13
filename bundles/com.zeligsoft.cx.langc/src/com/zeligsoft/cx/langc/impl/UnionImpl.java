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

import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.NamedReference;
import com.zeligsoft.cx.langc.Union;
import com.zeligsoft.cx.langc.m2t.CWriter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Union</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public class UnionImpl extends StructureImpl implements Union {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.UNION;
	}

	@Override
	public boolean write(CWriter writer) {
		if( ! writer.decl().write( "typedef union " )
		 || ! writer.decl().write( getName().getName() )
		 || ! writer.decl().openBrace() )
			return false;

		for( NamedReference field : getMembers() )
			if( ! field.write( writer.decl() )
			 || ! writer.decl().terminate() )
				return false;

		return writer.decl().closeBrace()
			&& writer.decl().space()
			&& writer.decl().write( getName().getName() )
			&& writer.decl().terminate();
	}
} //UnionImpl
