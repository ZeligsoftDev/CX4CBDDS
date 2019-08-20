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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.IntegralLiteral;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.PrimitiveType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integral Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.IntegralLiteralImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.IntegralLiteralImpl#getBytes <em>Bytes</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.IntegralLiteralImpl#isSigned <em>Signed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public class IntegralLiteralImpl extends LiteralImpl implements IntegralLiteral {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final long VALUE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected long value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBytes() <em>Bytes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBytes()
	 * @generated
	 * @ordered
	 */
	protected static final byte BYTES_EDEFAULT = 0x00;

	/**
	 * The cached value of the '{@link #getBytes() <em>Bytes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBytes()
	 * @generated
	 * @ordered
	 */
	protected byte bytes = BYTES_EDEFAULT;

	/**
	 * The default value of the '{@link #isSigned() <em>Signed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSigned()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SIGNED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSigned() <em>Signed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSigned()
	 * @generated
	 * @ordered
	 */
	protected boolean signed = SIGNED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegralLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.INTEGRAL_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(long newValue) {
		long oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.INTEGRAL_LITERAL__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte getBytes() {
		return bytes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBytes(byte newBytes) {
		byte oldBytes = bytes;
		bytes = newBytes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.INTEGRAL_LITERAL__BYTES, oldBytes, bytes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSigned() {
		return signed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSigned(boolean newSigned) {
		boolean oldSigned = signed;
		signed = newSigned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.INTEGRAL_LITERAL__SIGNED, oldSigned, signed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LangCPackage.INTEGRAL_LITERAL__VALUE:
				return new Long(getValue());
			case LangCPackage.INTEGRAL_LITERAL__BYTES:
				return new Byte(getBytes());
			case LangCPackage.INTEGRAL_LITERAL__SIGNED:
				return isSigned() ? Boolean.TRUE : Boolean.FALSE;
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
			case LangCPackage.INTEGRAL_LITERAL__VALUE:
				setValue(((Long)newValue).longValue());
				return;
			case LangCPackage.INTEGRAL_LITERAL__BYTES:
				setBytes(((Byte)newValue).byteValue());
				return;
			case LangCPackage.INTEGRAL_LITERAL__SIGNED:
				setSigned(((Boolean)newValue).booleanValue());
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
			case LangCPackage.INTEGRAL_LITERAL__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case LangCPackage.INTEGRAL_LITERAL__BYTES:
				setBytes(BYTES_EDEFAULT);
				return;
			case LangCPackage.INTEGRAL_LITERAL__SIGNED:
				setSigned(SIGNED_EDEFAULT);
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
			case LangCPackage.INTEGRAL_LITERAL__VALUE:
				return value != VALUE_EDEFAULT;
			case LangCPackage.INTEGRAL_LITERAL__BYTES:
				return bytes != BYTES_EDEFAULT;
			case LangCPackage.INTEGRAL_LITERAL__SIGNED:
				return signed != SIGNED_EDEFAULT;
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
		result.append(" (value: ");
		result.append(value);
		result.append(", bytes: ");
		result.append(bytes);
		result.append(", signed: ");
		result.append(signed);
		result.append(')');
		return result.toString();
	}

	@Override
	public PrimitiveType getPrimitiveType() {
		switch (getBytes()) {
		case 1:
			return isSigned() ? PrimitiveType.INT8 : PrimitiveType.UINT8;
		case 2:
			return isSigned() ? PrimitiveType.INT16 : PrimitiveType.UINT16;
		case 4:
			return isSigned() ? PrimitiveType.INT32 : PrimitiveType.UINT32;
		}

		// default is plain int
		// TODO change #bytes to an enum and get rid of this
		return PrimitiveType.INT32;
	}

	@Override
	public boolean write(CodeWriter code) {
		return code.write(Long.toString(getValue()));
	}

} //IntegralLiteralImpl
