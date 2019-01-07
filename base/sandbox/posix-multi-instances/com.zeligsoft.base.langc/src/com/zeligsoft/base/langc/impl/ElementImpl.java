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
package com.zeligsoft.base.langc.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.zeligsoft.base.langc.CVQualifier;
import com.zeligsoft.base.langc.Element;
import com.zeligsoft.base.langc.Expression;
import com.zeligsoft.base.langc.IntegralLiteral;
import com.zeligsoft.base.langc.LangCPackage;
import org.eclipse.emf.common.notify.Notification;
import com.zeligsoft.base.langc.Pointer;
import com.zeligsoft.base.langc.PrimitiveType;
import com.zeligsoft.base.langc.m2t.CodeStream;
import com.zeligsoft.base.langc.m2t.CodeWriter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.base.langc.impl.ElementImpl#getWritten <em>Written</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public abstract class ElementImpl extends EObjectImpl implements Element {
	/**
	 * The default value of the '{@link #getWritten() <em>Written</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWritten()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean WRITTEN_EDEFAULT = Boolean.FALSE;
	/**
	 * The cached value of the '{@link #getWritten() <em>Written</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWritten()
	 * @generated
	 * @ordered
	 */
	protected Boolean written = WRITTEN_EDEFAULT;

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getWritten() {
		return written;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWritten(Boolean newWritten) {
		Boolean oldWritten = written;
		written = newWritten;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.ELEMENT__WRITTEN, oldWritten, written));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LangCPackage.ELEMENT__WRITTEN:
				return getWritten();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LangCPackage.ELEMENT__WRITTEN:
				setWritten((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LangCPackage.ELEMENT__WRITTEN:
				setWritten(WRITTEN_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LangCPackage.ELEMENT__WRITTEN:
				return WRITTEN_EDEFAULT == null ? written != null : !WRITTEN_EDEFAULT.equals(written);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (written: ");
		result.append(written);
		result.append(')');
		return result.toString();
	}

	protected static boolean writePointerSpec( CodeWriter code, List<Pointer> ptrSpec ) {
		for( Pointer ptr : ptrSpec )
			if( ! write( code, ptr )
			 || ! code.space() )
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
