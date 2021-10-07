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
import org.eclipse.uml2.uml.Dependency;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Domain Block Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockReferenceImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockReferenceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockReferenceImpl#getDomainBlockReference <em>Domain Block Reference</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockReferenceImpl#getDomainSpecialization <em>Domain Specialization</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainBlockReferenceImpl extends GenDomainObjectImpl implements GenDomainBlockReference {

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected GenDomainBlock target;

	/**
	 * The cached value of the '{@link #getDomainBlockReference() <em>Domain Block Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainBlockReference()
	 * @generated
	 * @ordered
	 */
	protected Dependency domainBlockReference;

	/**
	 * The cached value of the '{@link #getDomainSpecialization() <em>Domain Specialization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainSpecialization()
	 * @generated
	 * @ordered
	 */
	protected GenDomainSpecialization domainSpecialization;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainBlockReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK_REFERENCE;
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
		if (eIsSet(ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_SPECIALIZATION)) {
			return basicGetDomainSpecialization();
		}
		return super.basicGetOwner();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainBlock getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject) target;
			target = (GenDomainBlock) eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainBlock basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(GenDomainBlock newTarget) {
		GenDomainBlock oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__TARGET,
					oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Dependency getDomainBlockReference() {
		if (domainBlockReference != null && domainBlockReference.eIsProxy()) {
			InternalEObject oldDomainBlockReference = (InternalEObject) domainBlockReference;
			domainBlockReference = (Dependency) eResolveProxy(oldDomainBlockReference);
			if (domainBlockReference != oldDomainBlockReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_BLOCK_REFERENCE, oldDomainBlockReference,
							domainBlockReference));
			}
		}
		return domainBlockReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency basicGetDomainBlockReference() {
		return domainBlockReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainBlockReference(Dependency newDomainBlockReference) {
		Dependency oldDomainBlockReference = domainBlockReference;
		domainBlockReference = newDomainBlockReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_BLOCK_REFERENCE, oldDomainBlockReference,
					domainBlockReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainSpecialization getDomainSpecialization() {
		if (domainSpecialization != null && domainSpecialization.eIsProxy()) {
			InternalEObject oldDomainSpecialization = (InternalEObject) domainSpecialization;
			domainSpecialization = (GenDomainSpecialization) eResolveProxy(oldDomainSpecialization);
			if (domainSpecialization != oldDomainSpecialization) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_SPECIALIZATION, oldDomainSpecialization,
							domainSpecialization));
			}
		}
		return domainSpecialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainSpecialization basicGetDomainSpecialization() {
		return domainSpecialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainSpecialization(GenDomainSpecialization newDomainSpecialization) {
		GenDomainSpecialization oldDomainSpecialization = domainSpecialization;
		domainSpecialization = newDomainSpecialization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_SPECIALIZATION, oldDomainSpecialization,
					domainSpecialization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__TARGET:
			if (resolve)
				return getTarget();
			return basicGetTarget();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_BLOCK_REFERENCE:
			if (resolve)
				return getDomainBlockReference();
			return basicGetDomainBlockReference();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_SPECIALIZATION:
			if (resolve)
				return getDomainSpecialization();
			return basicGetDomainSpecialization();
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
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__TARGET:
			setTarget((GenDomainBlock) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_BLOCK_REFERENCE:
			setDomainBlockReference((Dependency) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_SPECIALIZATION:
			setDomainSpecialization((GenDomainSpecialization) newValue);
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
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__TARGET:
			setTarget((GenDomainBlock) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_BLOCK_REFERENCE:
			setDomainBlockReference((Dependency) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_SPECIALIZATION:
			setDomainSpecialization((GenDomainSpecialization) null);
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
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__OWNER:
			return isSetOwner();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__TARGET:
			return target != null;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_BLOCK_REFERENCE:
			return domainBlockReference != null;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_SPECIALIZATION:
			return domainSpecialization != null;
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
		return super.isSetOwner() || eIsSet(ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_SPECIALIZATION);
	}

} //GenDomainBlockReferenceImpl
