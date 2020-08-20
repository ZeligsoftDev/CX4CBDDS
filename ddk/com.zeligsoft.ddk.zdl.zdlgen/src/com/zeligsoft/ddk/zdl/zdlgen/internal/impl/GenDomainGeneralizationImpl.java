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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Generalization;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Domain Generalization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainGeneralizationImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainGeneralizationImpl#getSpecific <em>Specific</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainGeneralizationImpl#getGeneral <em>General</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainGeneralizationImpl#getDomainGeneralization <em>Domain Generalization</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainGeneralizationImpl extends GenDomainObjectImpl implements GenDomainGeneralization {

	/**
	 * The cached value of the '{@link #getGeneral() <em>General</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneral()
	 * @generated
	 * @ordered
	 */
	protected GenDomainConcept general;

	/**
	 * The cached value of the '{@link #getDomainGeneralization() <em>Domain Generalization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainGeneralization()
	 * @generated
	 * @ordered
	 */
	protected Generalization domainGeneralization;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainGeneralizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_DOMAIN_GENERALIZATION;
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
	@Override
	public GenDomainObject basicGetOwner() {
		GenDomainConcept specific = getSpecific();
		if (specific != null) {
			return specific;
		}
		return super.basicGetOwner();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainConcept getGeneral() {
		if (general != null && general.eIsProxy()) {
			InternalEObject oldGeneral = (InternalEObject) general;
			general = (GenDomainConcept) eResolveProxy(oldGeneral);
			if (general != oldGeneral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__GENERAL, oldGeneral, general));
			}
		}
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainConcept basicGetGeneral() {
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGeneral(GenDomainConcept newGeneral) {
		GenDomainConcept oldGeneral = general;
		general = newGeneral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__GENERAL,
					oldGeneral, general));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Generalization getDomainGeneralization() {
		if (domainGeneralization != null && domainGeneralization.eIsProxy()) {
			InternalEObject oldDomainGeneralization = (InternalEObject) domainGeneralization;
			domainGeneralization = (Generalization) eResolveProxy(oldDomainGeneralization);
			if (domainGeneralization != oldDomainGeneralization) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__DOMAIN_GENERALIZATION, oldDomainGeneralization,
							domainGeneralization));
			}
		}
		return domainGeneralization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generalization basicGetDomainGeneralization() {
		return domainGeneralization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainGeneralization(Generalization newDomainGeneralization) {
		Generalization oldDomainGeneralization = domainGeneralization;
		domainGeneralization = newDomainGeneralization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__DOMAIN_GENERALIZATION, oldDomainGeneralization,
					domainGeneralization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainConcept getSpecific() {
		if (eContainerFeatureID() != ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__SPECIFIC)
			return null;
		return (GenDomainConcept) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecific(GenDomainConcept newSpecific, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newSpecific, ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__SPECIFIC,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpecific(GenDomainConcept newSpecific) {
		if (newSpecific != eInternalContainer()
				|| (eContainerFeatureID() != ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__SPECIFIC
						&& newSpecific != null)) {
			if (EcoreUtil.isAncestor(this, newSpecific))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSpecific != null)
				msgs = ((InternalEObject) newSpecific).eInverseAdd(this,
						ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERALIZATION, GenDomainConcept.class, msgs);
			msgs = basicSetSpecific(newSpecific, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__SPECIFIC,
					newSpecific, newSpecific));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__SPECIFIC:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetSpecific((GenDomainConcept) otherEnd, msgs);
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
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__SPECIFIC:
			return basicSetSpecific(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__SPECIFIC:
			return eInternalContainer().eInverseRemove(this, ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERALIZATION,
					GenDomainConcept.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__SPECIFIC:
			return getSpecific();
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__GENERAL:
			if (resolve)
				return getGeneral();
			return basicGetGeneral();
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__DOMAIN_GENERALIZATION:
			if (resolve)
				return getDomainGeneralization();
			return basicGetDomainGeneralization();
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
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__SPECIFIC:
			setSpecific((GenDomainConcept) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__GENERAL:
			setGeneral((GenDomainConcept) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__DOMAIN_GENERALIZATION:
			setDomainGeneralization((Generalization) newValue);
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
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__SPECIFIC:
			setSpecific((GenDomainConcept) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__GENERAL:
			setGeneral((GenDomainConcept) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__DOMAIN_GENERALIZATION:
			setDomainGeneralization((Generalization) null);
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
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__OWNER:
			return isSetOwner();
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__SPECIFIC:
			return getSpecific() != null;
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__GENERAL:
			return general != null;
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__DOMAIN_GENERALIZATION:
			return domainGeneralization != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwner() {
		return super.isSetOwner() || eIsSet(ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__SPECIFIC);
	}

} //GenDomainGeneralizationImpl
