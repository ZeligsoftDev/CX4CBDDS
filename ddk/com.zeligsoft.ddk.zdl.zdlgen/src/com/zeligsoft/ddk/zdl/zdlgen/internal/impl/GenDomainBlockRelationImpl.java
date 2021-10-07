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
import org.eclipse.uml2.uml.DirectedRelationship;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Domain Block Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockRelationImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockRelationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockRelationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockRelationImpl#getDomainBlockRelation <em>Domain Block Relation</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GenDomainBlockRelationImpl extends GenDomainObjectImpl implements GenDomainBlockRelation {

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected GenDomainBlock source;

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
	 * The cached value of the '{@link #getDomainBlockRelation() <em>Domain Block Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainBlockRelation()
	 * @generated
	 * @ordered
	 */
	protected DirectedRelationship domainBlockRelation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainBlockRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK_RELATION;
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
		if (eIsSet(ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__SOURCE)) {
			return basicGetSource();
		}
		return super.basicGetOwner();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainBlock getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (GenDomainBlock) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainBlock basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(GenDomainBlock newSource) {
		GenDomainBlock oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__SOURCE,
					oldSource, source));
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
							ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__TARGET,
					oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DirectedRelationship getDomainBlockRelation() {
		if (domainBlockRelation != null && domainBlockRelation.eIsProxy()) {
			InternalEObject oldDomainBlockRelation = (InternalEObject) domainBlockRelation;
			domainBlockRelation = (DirectedRelationship) eResolveProxy(oldDomainBlockRelation);
			if (domainBlockRelation != oldDomainBlockRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__DOMAIN_BLOCK_RELATION, oldDomainBlockRelation,
							domainBlockRelation));
			}
		}
		return domainBlockRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectedRelationship basicGetDomainBlockRelation() {
		return domainBlockRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainBlockRelation(DirectedRelationship newDomainBlockRelation) {
		DirectedRelationship oldDomainBlockRelation = domainBlockRelation;
		domainBlockRelation = newDomainBlockRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__DOMAIN_BLOCK_RELATION, oldDomainBlockRelation,
					domainBlockRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__TARGET:
			if (resolve)
				return getTarget();
			return basicGetTarget();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__DOMAIN_BLOCK_RELATION:
			if (resolve)
				return getDomainBlockRelation();
			return basicGetDomainBlockRelation();
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
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__SOURCE:
			setSource((GenDomainBlock) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__TARGET:
			setTarget((GenDomainBlock) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__DOMAIN_BLOCK_RELATION:
			setDomainBlockRelation((DirectedRelationship) newValue);
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
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__SOURCE:
			setSource((GenDomainBlock) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__TARGET:
			setTarget((GenDomainBlock) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__DOMAIN_BLOCK_RELATION:
			setDomainBlockRelation((DirectedRelationship) null);
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
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__OWNER:
			return isSetOwner();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__SOURCE:
			return source != null;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__TARGET:
			return target != null;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__DOMAIN_BLOCK_RELATION:
			return domainBlockRelation != null;
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
		return super.isSetOwner() || eIsSet(ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION__SOURCE);
	}

} //GenDomainBlockRelationImpl
