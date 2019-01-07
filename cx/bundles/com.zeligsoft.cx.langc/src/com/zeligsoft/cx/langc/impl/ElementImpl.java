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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.zeligsoft.cx.codegen.io.CodeStream;
import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.CVQualifier;
import com.zeligsoft.cx.langc.Element;
import com.zeligsoft.cx.langc.Expression;
import com.zeligsoft.cx.langc.IntegralLiteral;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.Pointer;
import com.zeligsoft.cx.langc.PrimitiveType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public abstract class ElementImpl extends EObjectImpl implements Element {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.ELEMENT;
	}

	protected static boolean writePointerSpec( CodeWriter code, List<Pointer> ptrSpec ) {
		for( Pointer ptr : ptrSpec )
			if( ! code.space()
			 || ! write( code, ptr ) )
				return false;
		return true;
	}

	private static boolean writeArrayBound( CodeWriter code, Expression bound )
	{
		if( ! ( bound instanceof IntegralLiteral ) )
			return bound.write( code );
		IntegralLiteral lit = (IntegralLiteral)bound;
		return lit.getValue() < 0 ? true : lit.write( code );
	}

	protected static boolean writeArrayBounds( CodeWriter code, List<Expression> arrayBounds ) {
		for( Expression bound : arrayBounds )
			if( ! code.write( '[' )
			 || ! writeArrayBound( code, bound )
			 || ! code.write( ']' ) )
				return false;
		return true;
	}

	protected static boolean write( CodeWriter code, PrimitiveType primType ) {
	    switch( primType )
	    {
	    case INT8: return code.write( "char" );
	    case INT16: return code.write( "short" );
	    case INT32: return code.write( "int" );
	    case UINT8: return code.write( "unsigned char" );
	    case UINT16: return code.write( "unsigned short" );
	    case UINT32: return code.write( "unsigned int" );
	    case CHAR: return code.write( "char" );
	    case DOUBLE: return code.write( "double" );
	    case FLOAT: return code.write( "float" );
	    case VOID: return code.write( "void" );
	    case LONG: return code.write( "long" );
	    default: return true;
	    }
	}

	protected static boolean write( CodeStream stm, CVQualifier cvQualifier ) {
		switch( cvQualifier )
		{
		case CONST: return stm.write( "const" );
		case VOLATILE: return stm.write( "volatile" );
		default: return true;
		}
	}

	protected static boolean write( CodeWriter code, Pointer ptr ) {
		switch( ptr )
		{
		case POINTER: return code.write( "*" );
		case CONST_POINTER: return code.write( "* const" );
		case CONST_VOLATILE_POINTER: return code.write( "* const volatile" );
		default: return true;
		}
	}
} //ElementImpl
