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

import com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

import com.zeligsoft.ddk.zdl.zdlgen.internal.operations.GenMenuItemOperations;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Menu Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuItemImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuItemImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuItemImpl#getOverrides <em>Overrides</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GenMenuItemImpl extends GenDomainObjectImpl implements GenMenuItem {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOverrides() <em>Overrides</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverrides()
	 * @generated
	 * @ordered
	 */
	protected GenMenuItem overrides;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenMenuItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_MENU_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_MENU_ITEM__DESCRIPTION,
					oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_MENU_ITEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenMenuItem getOverrides() {
		if (overrides != null && overrides.eIsProxy()) {
			InternalEObject oldOverrides = (InternalEObject) overrides;
			overrides = (GenMenuItem) eResolveProxy(oldOverrides);
			if (overrides != oldOverrides) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ZDLGenPackage.GEN_MENU_ITEM__OVERRIDES,
							oldOverrides, overrides));
			}
		}
		return overrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenMenuItem basicGetOverrides() {
		return overrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverrides(GenMenuItem newOverrides) {
		GenMenuItem oldOverrides = overrides;
		overrides = newOverrides;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_MENU_ITEM__OVERRIDES, oldOverrides,
					overrides));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenMenuItem overridenBy() {
		return GenMenuItemOperations.overridenBy(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_MENU_ITEM__DESCRIPTION:
			return getDescription();
		case ZDLGenPackage.GEN_MENU_ITEM__NAME:
			return getName();
		case ZDLGenPackage.GEN_MENU_ITEM__OVERRIDES:
			if (resolve)
				return getOverrides();
			return basicGetOverrides();
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
		case ZDLGenPackage.GEN_MENU_ITEM__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case ZDLGenPackage.GEN_MENU_ITEM__NAME:
			setName((String) newValue);
			return;
		case ZDLGenPackage.GEN_MENU_ITEM__OVERRIDES:
			setOverrides((GenMenuItem) newValue);
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
		case ZDLGenPackage.GEN_MENU_ITEM__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_MENU_ITEM__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_MENU_ITEM__OVERRIDES:
			setOverrides((GenMenuItem) null);
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
		case ZDLGenPackage.GEN_MENU_ITEM__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		case ZDLGenPackage.GEN_MENU_ITEM__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ZDLGenPackage.GEN_MENU_ITEM__OVERRIDES:
			return overrides != null;
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
		result.append(" (description: "); //$NON-NLS-1$
		result.append(description);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //GenMenuItemImpl
