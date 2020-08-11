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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenModel;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;
import com.zeligsoft.ddk.zdl.zdlgen.internal.operations.GenDomainObjectOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Domain Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainObjectImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainObjectImpl#getOwnedObjects <em>Owned Object</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainObjectImpl#getGenModel <em>Gen Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GenDomainObjectImpl extends EObjectImpl implements GenDomainObject {

	private boolean isAdapting;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT;
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
								ZDLGenPackage.GEN_DOMAIN_OBJECT__OWNED_OBJECT, null));
			}
			return ownedObjects;
		}
		return new DerivedUnionEObjectEList<GenDomainObject>(GenDomainObject.class, this,
				ZDLGenPackage.GEN_DOMAIN_OBJECT__OWNED_OBJECT, null);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_OBJECT__OWNER:
			if (resolve)
				return getOwner();
			return basicGetOwner();
		case ZDLGenPackage.GEN_DOMAIN_OBJECT__OWNED_OBJECT:
			return getOwnedObjects();
		case ZDLGenPackage.GEN_DOMAIN_OBJECT__GEN_MODEL:
			if (resolve)
				return getGenModel();
			return basicGetGenModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_OBJECT__OWNER:
			return isSetOwner();
		case ZDLGenPackage.GEN_DOMAIN_OBJECT__OWNED_OBJECT:
			return isSetOwnedObjects();
		case ZDLGenPackage.GEN_DOMAIN_OBJECT__GEN_MODEL:
			return basicGetGenModel() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Retrieves the cache adapter for this '<em><b>Gen Domain Object</b></em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The cache adapter for this '<em><b>Gen Domain Object</b></em>'.
	 * @generated NOT
	 */
	protected CacheAdapter getCacheAdapter() {
		return CacheAdapter.getInstance();
	}

	@Override
	public EList<Adapter> eAdapters() {
		EList<Adapter> result = super.eAdapters();

		if (result.isEmpty() && !isAdapting) {
			isAdapting = true;

			try {
				CacheAdapter cache = getCacheAdapter();
				if (cache != null) {
					cache.adapt(this);
				}
			} finally {
				isAdapting = false;
			}
		}

		return result;
	}

	@Override
	public boolean eNotificationRequired() {
		return (getCacheAdapter() != null) ? eDeliver() : super.eNotificationRequired();
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		if (deliver) {
			CacheAdapter cache = getCacheAdapter();

			if (cache != null) {
				// force re-synchronization of any cross-reference changes
				// that the cache missed while I wasn't delivering
				cache.handleCrossReference(this);
			}
		}

		super.eSetDeliver(deliver);
	}

	@Override
	public void eNotify(Notification notification) {
		if (eDeliver()) {
			EList<Adapter> adapters = eBasicAdapters();

			if ((adapters == null) || adapters.isEmpty()) {
				// must notify the cache adapter, nonetheless
				CacheAdapter cache = getCacheAdapter();

				if (cache != null) {
					cache.notifyChanged(notification);
				}
			} else {
				// we have already added the cache adapter
				super.eNotify(notification);
			}
		}
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

} //GenDomainObjectImpl
