/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen.internal.impl;

import com.zeligsoft.ddk.zdl.zdlgen.GenMenuDelegateAction;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Menu Delegate Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuDelegateActionImpl#getHostBundle <em>Host Bundle</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuDelegateActionImpl#getClassName <em>Class Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenMenuDelegateActionImpl extends GenMenuActionImpl implements GenMenuDelegateAction {
	/**
	 * The default value of the '{@link #getHostBundle() <em>Host Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHostBundle()
	 * @generated
	 * @ordered
	 */
	protected static final String HOST_BUNDLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHostBundle() <em>Host Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHostBundle()
	 * @generated
	 * @ordered
	 */
	protected String hostBundle = HOST_BUNDLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenMenuDelegateActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_MENU_DELEGATE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHostBundle() {
		return hostBundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHostBundle(String newHostBundle) {
		String oldHostBundle = hostBundle;
		hostBundle = newHostBundle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_MENU_DELEGATE_ACTION__HOST_BUNDLE,
					oldHostBundle, hostBundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_MENU_DELEGATE_ACTION__CLASS_NAME,
					oldClassName, className));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_MENU_DELEGATE_ACTION__HOST_BUNDLE:
			return getHostBundle();
		case ZDLGenPackage.GEN_MENU_DELEGATE_ACTION__CLASS_NAME:
			return getClassName();
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
		case ZDLGenPackage.GEN_MENU_DELEGATE_ACTION__HOST_BUNDLE:
			setHostBundle((String) newValue);
			return;
		case ZDLGenPackage.GEN_MENU_DELEGATE_ACTION__CLASS_NAME:
			setClassName((String) newValue);
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
		case ZDLGenPackage.GEN_MENU_DELEGATE_ACTION__HOST_BUNDLE:
			setHostBundle(HOST_BUNDLE_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_MENU_DELEGATE_ACTION__CLASS_NAME:
			setClassName(CLASS_NAME_EDEFAULT);
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
		case ZDLGenPackage.GEN_MENU_DELEGATE_ACTION__HOST_BUNDLE:
			return HOST_BUNDLE_EDEFAULT == null ? hostBundle != null : !HOST_BUNDLE_EDEFAULT.equals(hostBundle);
		case ZDLGenPackage.GEN_MENU_DELEGATE_ACTION__CLASS_NAME:
			return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
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
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (hostBundle: "); //$NON-NLS-1$
		result.append(hostBundle);
		result.append(", className: "); //$NON-NLS-1$
		result.append(className);
		result.append(')');
		return result.toString();
	}

} //GenMenuDelegateActionImpl
