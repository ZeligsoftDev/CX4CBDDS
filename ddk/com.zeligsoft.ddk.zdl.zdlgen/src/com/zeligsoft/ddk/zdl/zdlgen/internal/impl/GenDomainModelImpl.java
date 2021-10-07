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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenPalette;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;
import com.zeligsoft.ddk.zdl.zdlgen.internal.operations.GenDomainModelOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Domain Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl#getDomainElement <em>Domain Element</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl#getOwnedObjects <em>Owned Object</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl#getDomainModel <em>Domain Model</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl#getOwningGenModel <em>Owning Gen Model</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl#getRootPackage <em>Root Package</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl#getImplementationSubPackage <em>Implementation Sub Package</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl#getImplSuffix <em>Impl Suffix</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl#getApiProject <em>Api Project</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl#getPalette <em>Palette</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl#getMenuModel <em>Menu Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainModelImpl extends GenDomainPackageImpl implements GenDomainModel {

	/**
	 * The cached value of the '{@link #getDomainModel() <em>Domain Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainModel()
	 * @generated
	 * @ordered
	 */
	protected Model domainModel;

	/**
	 * The default value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsURI()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsURI()
	 * @generated
	 * @ordered
	 */
	protected String nsURI = NS_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwningGenModel() <em>Owning Gen Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwningGenModel()
	 * @generated
	 * @ordered
	 */
	protected GenModel owningGenModel;

	/**
	 * The default value of the '{@link #getRootPackage() <em>Root Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String ROOT_PACKAGE_EDEFAULT = null; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getRootPackage() <em>Root Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootPackage()
	 * @generated
	 * @ordered
	 */
	protected String rootPackage = ROOT_PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getImplementationSubPackage() <em>Implementation Sub Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationSubPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPLEMENTATION_SUB_PACKAGE_EDEFAULT = null; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getImplementationSubPackage() <em>Implementation Sub Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationSubPackage()
	 * @generated
	 * @ordered
	 */
	protected String implementationSubPackage = IMPLEMENTATION_SUB_PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getImplSuffix() <em>Impl Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPL_SUFFIX_EDEFAULT = null; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getImplSuffix() <em>Impl Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplSuffix()
	 * @generated
	 * @ordered
	 */
	protected String implSuffix = IMPL_SUFFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getApiProject() <em>Api Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiProject()
	 * @generated
	 * @ordered
	 */
	protected static final String API_PROJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApiProject() <em>Api Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiProject()
	 * @generated
	 * @ordered
	 */
	protected String apiProject = API_PROJECT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPalette() <em>Palette</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPalette()
	 * @generated
	 * @ordered
	 */
	protected GenPalette palette;

	/**
	 * The cached value of the '{@link #getMenuModel() <em>Menu Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMenuModel()
	 * @generated
	 * @ordered
	 */
	protected GenMenuModel menuModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_DOMAIN_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedElement getDomainElement() {
		NamedElement domainElement = basicGetDomainElement();
		return domainElement != null && domainElement.eIsProxy()
				? (NamedElement) eResolveProxy((InternalEObject) domainElement)
				: domainElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedElement basicGetDomainElement() {
		if (isSetDomainModel()) {
			return basicGetDomainModel();
		}
		return super.basicGetDomainElement();
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
								ZDLGenPackage.GEN_DOMAIN_MODEL__OWNED_OBJECT, OWNED_OBJECT_ESUBSETS));
			}
			return ownedObjects;
		}
		return new DerivedUnionEObjectEList<GenDomainObject>(GenDomainObject.class, this,
				ZDLGenPackage.GEN_DOMAIN_MODEL__OWNED_OBJECT, OWNED_OBJECT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedObjects() <em>Owned Object</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedObjects()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_OBJECT_ESUBSETS = new int[] { ZDLGenPackage.GEN_DOMAIN_MODEL__ELEMENT,
			ZDLGenPackage.GEN_DOMAIN_MODEL__PALETTE };

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
	@Override
	public GenDomainObject basicGetOwner() {
		if (eIsSet(ZDLGenPackage.GEN_DOMAIN_MODEL__OWNING_GEN_MODEL)) {
			return basicGetOwningGenModel();
		}
		return super.basicGetOwner();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Model getDomainModel() {
		if (domainModel != null && domainModel.eIsProxy()) {
			InternalEObject oldDomainModel = (InternalEObject) domainModel;
			domainModel = (Model) eResolveProxy(oldDomainModel);
			if (domainModel != oldDomainModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_MODEL__DOMAIN_MODEL, oldDomainModel, domainModel));
			}
		}
		return domainModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model basicGetDomainModel() {
		return domainModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainModel(Model newDomainModel) {
		Model oldDomainModel = domainModel;
		domainModel = newDomainModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_MODEL__DOMAIN_MODEL,
					oldDomainModel, domainModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDomainModel() {
		return domainModel != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNsURI() {
		return nsURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNsURI(String newNsURI) {
		String oldNsURI = nsURI;
		nsURI = newNsURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_MODEL__NS_URI, oldNsURI,
					nsURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRootPackage() {
		return rootPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootPackage(String newRootPackage) {
		String oldRootPackage = rootPackage;
		rootPackage = newRootPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_MODEL__ROOT_PACKAGE,
					oldRootPackage, rootPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplementationSubPackage() {
		return implementationSubPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationSubPackage(String newImplementationSubPackage) {
		String oldImplementationSubPackage = implementationSubPackage;
		implementationSubPackage = newImplementationSubPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_MODEL__IMPLEMENTATION_SUB_PACKAGE, oldImplementationSubPackage,
					implementationSubPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplSuffix() {
		return implSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplSuffix(String newImplSuffix) {
		String oldImplSuffix = implSuffix;
		implSuffix = newImplSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_MODEL__IMPL_SUFFIX,
					oldImplSuffix, implSuffix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApiProject() {
		return apiProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApiProject(String newApiProject) {
		String oldApiProject = apiProject;
		apiProject = newApiProject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_MODEL__API_PROJECT,
					oldApiProject, apiProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPalette getPalette() {
		return palette;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPalette(GenPalette newPalette, NotificationChain msgs) {
		GenPalette oldPalette = palette;
		palette = newPalette;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_MODEL__PALETTE, oldPalette, newPalette);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPalette(GenPalette newPalette) {
		if (newPalette != palette) {
			NotificationChain msgs = null;
			if (palette != null)
				msgs = ((InternalEObject) palette).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - ZDLGenPackage.GEN_DOMAIN_MODEL__PALETTE, null, msgs);
			if (newPalette != null)
				msgs = ((InternalEObject) newPalette).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - ZDLGenPackage.GEN_DOMAIN_MODEL__PALETTE, null, msgs);
			msgs = basicSetPalette(newPalette, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_MODEL__PALETTE, newPalette,
					newPalette));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenMenuModel getMenuModel() {
		return menuModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMenuModel(GenMenuModel newMenuModel, NotificationChain msgs) {
		GenMenuModel oldMenuModel = menuModel;
		menuModel = newMenuModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_MODEL__MENU_MODEL, oldMenuModel, newMenuModel);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMenuModel(GenMenuModel newMenuModel) {
		if (newMenuModel != menuModel) {
			NotificationChain msgs = null;
			if (menuModel != null)
				msgs = ((InternalEObject) menuModel).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - ZDLGenPackage.GEN_DOMAIN_MODEL__MENU_MODEL, null, msgs);
			if (newMenuModel != null)
				msgs = ((InternalEObject) newMenuModel).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - ZDLGenPackage.GEN_DOMAIN_MODEL__MENU_MODEL, null, msgs);
			msgs = basicSetMenuModel(newMenuModel, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_MODEL__MENU_MODEL,
					newMenuModel, newMenuModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenModel getOwningGenModel() {
		if (owningGenModel != null && owningGenModel.eIsProxy()) {
			InternalEObject oldOwningGenModel = (InternalEObject) owningGenModel;
			owningGenModel = (GenModel) eResolveProxy(oldOwningGenModel);
			if (owningGenModel != oldOwningGenModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_MODEL__OWNING_GEN_MODEL, oldOwningGenModel, owningGenModel));
			}
		}
		return owningGenModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenModel basicGetOwningGenModel() {
		return owningGenModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningGenModel(GenModel newOwningGenModel) {
		GenModel oldOwningGenModel = owningGenModel;
		owningGenModel = newOwningGenModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_MODEL__OWNING_GEN_MODEL,
					oldOwningGenModel, owningGenModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainBlock getDomainBlock(String qualifiedName) {
		return GenDomainModelOperations.getDomainBlock(this, qualifiedName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_MODEL__PALETTE:
			return basicSetPalette(null, msgs);
		case ZDLGenPackage.GEN_DOMAIN_MODEL__MENU_MODEL:
			return basicSetMenuModel(null, msgs);
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
		case ZDLGenPackage.GEN_DOMAIN_MODEL__DOMAIN_MODEL:
			if (resolve)
				return getDomainModel();
			return basicGetDomainModel();
		case ZDLGenPackage.GEN_DOMAIN_MODEL__NS_URI:
			return getNsURI();
		case ZDLGenPackage.GEN_DOMAIN_MODEL__OWNING_GEN_MODEL:
			if (resolve)
				return getOwningGenModel();
			return basicGetOwningGenModel();
		case ZDLGenPackage.GEN_DOMAIN_MODEL__ROOT_PACKAGE:
			return getRootPackage();
		case ZDLGenPackage.GEN_DOMAIN_MODEL__IMPLEMENTATION_SUB_PACKAGE:
			return getImplementationSubPackage();
		case ZDLGenPackage.GEN_DOMAIN_MODEL__IMPL_SUFFIX:
			return getImplSuffix();
		case ZDLGenPackage.GEN_DOMAIN_MODEL__API_PROJECT:
			return getApiProject();
		case ZDLGenPackage.GEN_DOMAIN_MODEL__PALETTE:
			return getPalette();
		case ZDLGenPackage.GEN_DOMAIN_MODEL__MENU_MODEL:
			return getMenuModel();
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
		case ZDLGenPackage.GEN_DOMAIN_MODEL__DOMAIN_MODEL:
			setDomainModel((Model) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__NS_URI:
			setNsURI((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__OWNING_GEN_MODEL:
			setOwningGenModel((GenModel) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__ROOT_PACKAGE:
			setRootPackage((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__IMPLEMENTATION_SUB_PACKAGE:
			setImplementationSubPackage((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__IMPL_SUFFIX:
			setImplSuffix((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__API_PROJECT:
			setApiProject((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__PALETTE:
			setPalette((GenPalette) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__MENU_MODEL:
			setMenuModel((GenMenuModel) newValue);
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
		case ZDLGenPackage.GEN_DOMAIN_MODEL__DOMAIN_MODEL:
			setDomainModel((Model) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__NS_URI:
			setNsURI(NS_URI_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__OWNING_GEN_MODEL:
			setOwningGenModel((GenModel) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__ROOT_PACKAGE:
			setRootPackage(ROOT_PACKAGE_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__IMPLEMENTATION_SUB_PACKAGE:
			setImplementationSubPackage(IMPLEMENTATION_SUB_PACKAGE_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__IMPL_SUFFIX:
			setImplSuffix(IMPL_SUFFIX_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__API_PROJECT:
			setApiProject(API_PROJECT_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__PALETTE:
			setPalette((GenPalette) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__MENU_MODEL:
			setMenuModel((GenMenuModel) null);
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
		case ZDLGenPackage.GEN_DOMAIN_MODEL__DOMAIN_ELEMENT:
			return isSetDomainElement();
		case ZDLGenPackage.GEN_DOMAIN_MODEL__OWNER:
			return isSetOwner();
		case ZDLGenPackage.GEN_DOMAIN_MODEL__OWNED_OBJECT:
			return isSetOwnedObjects();
		case ZDLGenPackage.GEN_DOMAIN_MODEL__DOMAIN_PACKAGE:
			return isSetDomainPackage();
		case ZDLGenPackage.GEN_DOMAIN_MODEL__DOMAIN_MODEL:
			return isSetDomainModel();
		case ZDLGenPackage.GEN_DOMAIN_MODEL__NS_URI:
			return NS_URI_EDEFAULT == null ? nsURI != null : !NS_URI_EDEFAULT.equals(nsURI);
		case ZDLGenPackage.GEN_DOMAIN_MODEL__OWNING_GEN_MODEL:
			return owningGenModel != null;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__ROOT_PACKAGE:
			return ROOT_PACKAGE_EDEFAULT == null ? rootPackage != null : !ROOT_PACKAGE_EDEFAULT.equals(rootPackage);
		case ZDLGenPackage.GEN_DOMAIN_MODEL__IMPLEMENTATION_SUB_PACKAGE:
			return IMPLEMENTATION_SUB_PACKAGE_EDEFAULT == null ? implementationSubPackage != null
					: !IMPLEMENTATION_SUB_PACKAGE_EDEFAULT.equals(implementationSubPackage);
		case ZDLGenPackage.GEN_DOMAIN_MODEL__IMPL_SUFFIX:
			return IMPL_SUFFIX_EDEFAULT == null ? implSuffix != null : !IMPL_SUFFIX_EDEFAULT.equals(implSuffix);
		case ZDLGenPackage.GEN_DOMAIN_MODEL__API_PROJECT:
			return API_PROJECT_EDEFAULT == null ? apiProject != null : !API_PROJECT_EDEFAULT.equals(apiProject);
		case ZDLGenPackage.GEN_DOMAIN_MODEL__PALETTE:
			return palette != null;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__MENU_MODEL:
			return menuModel != null;
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
		result.append(" (nsURI: "); //$NON-NLS-1$
		result.append(nsURI);
		result.append(", rootPackage: "); //$NON-NLS-1$
		result.append(rootPackage);
		result.append(", implementationSubPackage: "); //$NON-NLS-1$
		result.append(implementationSubPackage);
		result.append(", implSuffix: "); //$NON-NLS-1$
		result.append(implSuffix);
		result.append(", apiProject: "); //$NON-NLS-1$
		result.append(apiProject);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDomainElement() {
		return super.isSetDomainElement() || isSetDomainModel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedObjects() {
		return super.isSetOwnedObjects() || eIsSet(ZDLGenPackage.GEN_DOMAIN_MODEL__PALETTE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwner() {
		return super.isSetOwner() || eIsSet(ZDLGenPackage.GEN_DOMAIN_MODEL__OWNING_GEN_MODEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Package getDomainPackage() {
		return getDomainModel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Package basicGetDomainPackage() {
		return basicGetDomainModel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainPackage(org.eclipse.uml2.uml.Package newDomainPackage) {
		if (newDomainPackage != null && !(newDomainPackage instanceof Model)) {
			throw new IllegalArgumentException("newDomainPackage must be an instance of Model"); //$NON-NLS-1$
		}
		setDomainModel((Model) newDomainPackage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDomainPackage() {
		return false;
	}

} //GenDomainModelImpl
