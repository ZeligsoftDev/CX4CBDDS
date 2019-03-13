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

import com.zeligsoft.cx.langc.FileName;
import com.zeligsoft.cx.langc.LangCPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.FileNameImpl#isHasObjectCode <em>Has Object Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public class FileNameImpl extends NameImpl implements FileName {
	/**
	 * The default value of the '{@link #isHasObjectCode() <em>Has Object Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasObjectCode()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_OBJECT_CODE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isHasObjectCode() <em>Has Object Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasObjectCode()
	 * @generated
	 * @ordered
	 */
	protected boolean hasObjectCode = HAS_OBJECT_CODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileNameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.FILE_NAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasObjectCode() {
		return hasObjectCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasObjectCode(boolean newHasObjectCode) {
		boolean oldHasObjectCode = hasObjectCode;
		hasObjectCode = newHasObjectCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.FILE_NAME__HAS_OBJECT_CODE, oldHasObjectCode, hasObjectCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LangCPackage.FILE_NAME__HAS_OBJECT_CODE:
				return isHasObjectCode() ? Boolean.TRUE : Boolean.FALSE;
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
			case LangCPackage.FILE_NAME__HAS_OBJECT_CODE:
				setHasObjectCode(((Boolean)newValue).booleanValue());
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
			case LangCPackage.FILE_NAME__HAS_OBJECT_CODE:
				setHasObjectCode(HAS_OBJECT_CODE_EDEFAULT);
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
			case LangCPackage.FILE_NAME__HAS_OBJECT_CODE:
				return hasObjectCode != HAS_OBJECT_CODE_EDEFAULT;
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
		result.append(" (hasObjectCode: ");
		result.append(hasObjectCode);
		result.append(')');
		return result.toString();
	}

} //FileNameImpl
