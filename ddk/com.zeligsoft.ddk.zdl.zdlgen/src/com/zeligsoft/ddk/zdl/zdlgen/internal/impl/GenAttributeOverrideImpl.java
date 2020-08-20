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

import com.zeligsoft.ddk.zdl.zdlgen.GenAttributeOverride;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenModel;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

import com.zeligsoft.ddk.zdl.zdlgen.internal.operations.GenDomainObjectOperations;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Attribute Override</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenAttributeOverrideImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenAttributeOverrideImpl#getOwnedObjects <em>Owned Object</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenAttributeOverrideImpl#getGenModel <em>Gen Model</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenAttributeOverrideImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenAttributeOverrideImpl extends GenDomainAttributePresentationImpl implements GenAttributeOverride {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenAttributeOverrideImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_ATTRIBUTE_OVERRIDE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainObject getOwner() {
		GenDomainObject owner = basicGetOwner();
		return owner != null && owner.eIsProxy() ? (GenDomainObject) eResolveProxy((InternalEObject) owner) : owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainObject basicGetOwner() {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainObject> getOwnedObjects() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<GenDomainObject> ownedObjects = (EList<GenDomainObject>) cache.get(eResource, this,
					ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			if (ownedObjects == null) {
				cache.put(eResource, this, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT,
						ownedObjects = new DerivedUnionEObjectEList<GenDomainObject>(GenDomainObject.class, this,
								ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__OWNED_OBJECT, null));
			}
			return ownedObjects;
		}
		return new DerivedUnionEObjectEList<GenDomainObject>(GenDomainObject.class, this,
				ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__OWNED_OBJECT, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenModel getGenModel() {
		GenModel genModel = basicGetGenModel();
		return genModel != null && genModel.eIsProxy() ? (GenModel) eResolveProxy((InternalEObject) genModel)
				: genModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenModel basicGetGenModel() {
		return GenDomainObjectOperations.getGenModel(this);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__OWNER:
			if (resolve)
				return getOwner();
			return basicGetOwner();
		case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__OWNED_OBJECT:
			return getOwnedObjects();
		case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__GEN_MODEL:
			if (resolve)
				return getGenModel();
			return basicGetGenModel();
		case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__NAME:
			return getName();
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
		case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__NAME:
			setName((String) newValue);
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
		case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__NAME:
			setName(NAME_EDEFAULT);
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
		case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__OWNER:
			return isSetOwner();
		case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__OWNED_OBJECT:
			return isSetOwnedObjects();
		case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__GEN_MODEL:
			return basicGetGenModel() != null;
		case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == GenDomainObject.class) {
			switch (derivedFeatureID) {
			case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__GEN_MODEL:
				return ZDLGenPackage.GEN_DOMAIN_OBJECT__GEN_MODEL;
			case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__OWNER:
				return ZDLGenPackage.GEN_DOMAIN_OBJECT__OWNER;
			case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__OWNED_OBJECT:
				return ZDLGenPackage.GEN_DOMAIN_OBJECT__OWNED_OBJECT;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == GenDomainObject.class) {
			switch (baseFeatureID) {
			case ZDLGenPackage.GEN_DOMAIN_OBJECT__GEN_MODEL:
				return ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__GEN_MODEL;
			case ZDLGenPackage.GEN_DOMAIN_OBJECT__OWNER:
				return ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__OWNER;
			case ZDLGenPackage.GEN_DOMAIN_OBJECT__OWNED_OBJECT:
				return ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE__OWNED_OBJECT;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwner() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedObjects() {
		return false;
	}

} //GenAttributeOverrideImpl
