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

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenModel;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

import com.zeligsoft.ddk.zdl.zdlgen.internal.operations.GenModelOperations;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

import org.eclipse.uml2.uml.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenModelImpl#getDomainModels <em>Domain Model</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenModelImpl#getOwnedObjects <em>Owned Object</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenModelImpl#getOwnedModels <em>Owned Model</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenModelImpl#getReferencedModels <em>Referenced Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenModelImpl extends GenDomainObjectImpl implements GenModel {

	/**
	 * The cached value of the '{@link #getOwnedModels() <em>Owned Model</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedModels()
	 * @generated
	 * @ordered
	 */
	protected EList<GenDomainModel> ownedModels;

	/**
	 * The cached value of the '{@link #getReferencedModels() <em>Referenced Model</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedModels()
	 * @generated
	 * @ordered
	 */
	protected EList<GenDomainModel> referencedModels;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainModel> getDomainModels() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<GenDomainModel> domainModels = (EList<GenDomainModel>) cache.get(eResource, this,
					ZDLGenPackage.Literals.GEN_MODEL__DOMAIN_MODEL);
			if (domainModels == null) {
				cache.put(eResource, this, ZDLGenPackage.Literals.GEN_MODEL__DOMAIN_MODEL,
						domainModels = new DerivedUnionEObjectEList<GenDomainModel>(GenDomainModel.class, this,
								ZDLGenPackage.GEN_MODEL__DOMAIN_MODEL, DOMAIN_MODEL_ESUBSETS));
			}
			return domainModels;
		}
		return new DerivedUnionEObjectEList<GenDomainModel>(GenDomainModel.class, this,
				ZDLGenPackage.GEN_MODEL__DOMAIN_MODEL, DOMAIN_MODEL_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getDomainModels() <em>Domain Model</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainModels()
	 * @generated
	 * @ordered
	 */
	protected static final int[] DOMAIN_MODEL_ESUBSETS = new int[] { ZDLGenPackage.GEN_MODEL__OWNED_MODEL,
			ZDLGenPackage.GEN_MODEL__REFERENCED_MODEL };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainModel getDomainModel(String name) {
		return getDomainModel(name, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainModel getDomainModel(String name, boolean ignoreCase) {
		domainModelLoop: for (GenDomainModel domainModel : getDomainModels()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(domainModel.getName())
					: name.equals(domainModel.getName())))
				continue domainModelLoop;
			return domainModel;
		}
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
								ZDLGenPackage.GEN_MODEL__OWNED_OBJECT, OWNED_OBJECT_ESUBSETS));
			}
			return ownedObjects;
		}
		return new DerivedUnionEObjectEList<GenDomainObject>(GenDomainObject.class, this,
				ZDLGenPackage.GEN_MODEL__OWNED_OBJECT, OWNED_OBJECT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedObjects() <em>Owned Object</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedObjects()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_OBJECT_ESUBSETS = new int[] { ZDLGenPackage.GEN_MODEL__OWNED_MODEL };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainModel> getReferencedModels() {
		if (referencedModels == null) {
			referencedModels = new EObjectResolvingEList<GenDomainModel>(GenDomainModel.class, this,
					ZDLGenPackage.GEN_MODEL__REFERENCED_MODEL);
		}
		return referencedModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainModel getReferencedModel(String name) {
		return getReferencedModel(name, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainModel getReferencedModel(String name, boolean ignoreCase) {
		referencedModelLoop: for (GenDomainModel referencedModel : getReferencedModels()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(referencedModel.getName())
					: name.equals(referencedModel.getName())))
				continue referencedModelLoop;
			return referencedModel;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainModel> getOwnedModels() {
		if (ownedModels == null) {
			ownedModels = new EObjectContainmentWithInverseEList<GenDomainModel>(GenDomainModel.class, this,
					ZDLGenPackage.GEN_MODEL__OWNED_MODEL, ZDLGenPackage.GEN_DOMAIN_MODEL__OWNING_GEN_MODEL);
		}
		return ownedModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainModel getOwnedModel(String name) {
		return getOwnedModel(name, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainModel getOwnedModel(String name, boolean ignoreCase) {
		ownedModelLoop: for (GenDomainModel ownedModel : getOwnedModels()) {
			if (name != null
					&& !(ignoreCase ? name.equalsIgnoreCase(ownedModel.getName()) : name.equals(ownedModel.getName())))
				continue ownedModelLoop;
			return ownedModel;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Model> findUsedDomainModels(Model model) {
		return GenModelOperations.findUsedDomainModels(this, model);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Model> getDomainModels(EList<String> uris) {
		return GenModelOperations.getDomainModels(this, uris);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_MODEL__OWNED_MODEL:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedModels()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_MODEL__OWNED_MODEL:
			return ((InternalEList<?>) getOwnedModels()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_MODEL__DOMAIN_MODEL:
			return getDomainModels();
		case ZDLGenPackage.GEN_MODEL__OWNED_MODEL:
			return getOwnedModels();
		case ZDLGenPackage.GEN_MODEL__REFERENCED_MODEL:
			return getReferencedModels();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ZDLGenPackage.GEN_MODEL__OWNED_MODEL:
			getOwnedModels().clear();
			getOwnedModels().addAll((Collection<? extends GenDomainModel>) newValue);
			return;
		case ZDLGenPackage.GEN_MODEL__REFERENCED_MODEL:
			getReferencedModels().clear();
			getReferencedModels().addAll((Collection<? extends GenDomainModel>) newValue);
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
		case ZDLGenPackage.GEN_MODEL__OWNED_MODEL:
			getOwnedModels().clear();
			return;
		case ZDLGenPackage.GEN_MODEL__REFERENCED_MODEL:
			getReferencedModels().clear();
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
		case ZDLGenPackage.GEN_MODEL__DOMAIN_MODEL:
			return isSetDomainModels();
		case ZDLGenPackage.GEN_MODEL__OWNED_OBJECT:
			return isSetOwnedObjects();
		case ZDLGenPackage.GEN_MODEL__OWNED_MODEL:
			return ownedModels != null && !ownedModels.isEmpty();
		case ZDLGenPackage.GEN_MODEL__REFERENCED_MODEL:
			return referencedModels != null && !referencedModels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDomainModels() {
		return eIsSet(ZDLGenPackage.GEN_MODEL__OWNED_MODEL) || eIsSet(ZDLGenPackage.GEN_MODEL__REFERENCED_MODEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedObjects() {
		return super.isSetOwnedObjects() || eIsSet(ZDLGenPackage.GEN_MODEL__OWNED_MODEL);
	}

} //GenModelImpl
