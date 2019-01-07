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
package com.zeligsoft.ce.deployment.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.zeligsoft.ce.deployment.Allocation;
import com.zeligsoft.ce.deployment.Deployment;
import com.zeligsoft.ce.deployment.DeploymentPackage;
import com.zeligsoft.ce.deployment.DeploymentPart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Allocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.ce.deployment.impl.AllocationImpl#getTargetPart <em>Target Part</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.impl.AllocationImpl#getDeployment <em>Deployment</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.impl.AllocationImpl#getSourcePart <em>Source Part</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.impl.AllocationImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocationImpl extends EModelElementImpl implements Allocation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	public static final String copyright = "* Copyright (c) 2008 Zeligsoft Inc.\r\n *\r\n * All rights reserved. \r\n *  \r\n * THIS PROGRAM IS THE UNPUBLISHED, PROPRIETARY PROPERTY OF ZELIGSOFT INC. AND\r\n * IS TO BE MAINTAINED IN STRICT CONFIDENCE.  UNAUTHORIZED REPRODUCTION, \r\n * DISTRIBUTION OR DISCLOSURE OF THIS PROGRAM, OR ANY PROGRAM DERIVED FROM IT,\r\n * IS STRICTLY PROHIBITED.";
	public static final String copyright = "* Copyright 2018 ADLINK Technology Limited.\r\n *\r\n * Licensed under the Apache License, Version 2.0";
	/**
	 * The cached value of the '{@link #getTargetPart() <em>Target Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPart()
	 * @generated
	 * @ordered
	 */
	protected DeploymentPart targetPart;

	/**
	 * The cached value of the '{@link #getSourcePart() <em>Source Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePart()
	 * @generated
	 * @ordered
	 */
	protected DeploymentPart sourcePart;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * This is true if the Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean idESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected AllocationImpl() {
		super();
		
		this.setId(java.util.UUID.randomUUID().toString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeploymentPackage.Literals.ALLOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentPart getTargetPart() {
		if (targetPart != null && targetPart.eIsProxy()) {
			InternalEObject oldTargetPart = (InternalEObject)targetPart;
			targetPart = (DeploymentPart)eResolveProxy(oldTargetPart);
			if (targetPart != oldTargetPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeploymentPackage.ALLOCATION__TARGET_PART, oldTargetPart, targetPart));
			}
		}
		return targetPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentPart basicGetTargetPart() {
		return targetPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetPart(DeploymentPart newTargetPart, NotificationChain msgs) {
		DeploymentPart oldTargetPart = targetPart;
		targetPart = newTargetPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeploymentPackage.ALLOCATION__TARGET_PART, oldTargetPart, newTargetPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPart(DeploymentPart newTargetPart) {
		if (newTargetPart != targetPart) {
			NotificationChain msgs = null;
			if (targetPart != null)
				msgs = ((InternalEObject)targetPart).eInverseRemove(this, DeploymentPackage.DEPLOYMENT_PART__TARGET_ALLOCATION, DeploymentPart.class, msgs);
			if (newTargetPart != null)
				msgs = ((InternalEObject)newTargetPart).eInverseAdd(this, DeploymentPackage.DEPLOYMENT_PART__TARGET_ALLOCATION, DeploymentPart.class, msgs);
			msgs = basicSetTargetPart(newTargetPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeploymentPackage.ALLOCATION__TARGET_PART, newTargetPart, newTargetPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deployment getDeployment() {
		if (eContainerFeatureID != DeploymentPackage.ALLOCATION__DEPLOYMENT) return null;
		return (Deployment)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeployment(Deployment newDeployment, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDeployment, DeploymentPackage.ALLOCATION__DEPLOYMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeployment(Deployment newDeployment) {
		if (newDeployment != eInternalContainer() || (eContainerFeatureID != DeploymentPackage.ALLOCATION__DEPLOYMENT && newDeployment != null)) {
			if (EcoreUtil.isAncestor(this, newDeployment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDeployment != null)
				msgs = ((InternalEObject)newDeployment).eInverseAdd(this, DeploymentPackage.DEPLOYMENT__ALLOCATION, Deployment.class, msgs);
			msgs = basicSetDeployment(newDeployment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeploymentPackage.ALLOCATION__DEPLOYMENT, newDeployment, newDeployment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentPart getSourcePart() {
		if (sourcePart != null && sourcePart.eIsProxy()) {
			InternalEObject oldSourcePart = (InternalEObject)sourcePart;
			sourcePart = (DeploymentPart)eResolveProxy(oldSourcePart);
			if (sourcePart != oldSourcePart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeploymentPackage.ALLOCATION__SOURCE_PART, oldSourcePart, sourcePart));
			}
		}
		return sourcePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentPart basicGetSourcePart() {
		return sourcePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourcePart(DeploymentPart newSourcePart, NotificationChain msgs) {
		DeploymentPart oldSourcePart = sourcePart;
		sourcePart = newSourcePart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeploymentPackage.ALLOCATION__SOURCE_PART, oldSourcePart, newSourcePart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourcePart(DeploymentPart newSourcePart) {
		if (newSourcePart != sourcePart) {
			NotificationChain msgs = null;
			if (sourcePart != null)
				msgs = ((InternalEObject)sourcePart).eInverseRemove(this, DeploymentPackage.DEPLOYMENT_PART__SOURCE_ALLOCATION, DeploymentPart.class, msgs);
			if (newSourcePart != null)
				msgs = ((InternalEObject)newSourcePart).eInverseAdd(this, DeploymentPackage.DEPLOYMENT_PART__SOURCE_ALLOCATION, DeploymentPart.class, msgs);
			msgs = basicSetSourcePart(newSourcePart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeploymentPackage.ALLOCATION__SOURCE_PART, newSourcePart, newSourcePart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		boolean oldIdESet = idESet;
		idESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeploymentPackage.ALLOCATION__ID, oldId, id, !oldIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetId() {
		String oldId = id;
		boolean oldIdESet = idESet;
		id = ID_EDEFAULT;
		idESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, DeploymentPackage.ALLOCATION__ID, oldId, ID_EDEFAULT, oldIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetId() {
		return idESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeploymentPackage.ALLOCATION__TARGET_PART:
				if (targetPart != null)
					msgs = ((InternalEObject)targetPart).eInverseRemove(this, DeploymentPackage.DEPLOYMENT_PART__TARGET_ALLOCATION, DeploymentPart.class, msgs);
				return basicSetTargetPart((DeploymentPart)otherEnd, msgs);
			case DeploymentPackage.ALLOCATION__DEPLOYMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeployment((Deployment)otherEnd, msgs);
			case DeploymentPackage.ALLOCATION__SOURCE_PART:
				if (sourcePart != null)
					msgs = ((InternalEObject)sourcePart).eInverseRemove(this, DeploymentPackage.DEPLOYMENT_PART__SOURCE_ALLOCATION, DeploymentPart.class, msgs);
				return basicSetSourcePart((DeploymentPart)otherEnd, msgs);
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
			case DeploymentPackage.ALLOCATION__TARGET_PART:
				return basicSetTargetPart(null, msgs);
			case DeploymentPackage.ALLOCATION__DEPLOYMENT:
				return basicSetDeployment(null, msgs);
			case DeploymentPackage.ALLOCATION__SOURCE_PART:
				return basicSetSourcePart(null, msgs);
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
		switch (eContainerFeatureID) {
			case DeploymentPackage.ALLOCATION__DEPLOYMENT:
				return eInternalContainer().eInverseRemove(this, DeploymentPackage.DEPLOYMENT__ALLOCATION, Deployment.class, msgs);
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
			case DeploymentPackage.ALLOCATION__TARGET_PART:
				if (resolve) return getTargetPart();
				return basicGetTargetPart();
			case DeploymentPackage.ALLOCATION__DEPLOYMENT:
				return getDeployment();
			case DeploymentPackage.ALLOCATION__SOURCE_PART:
				if (resolve) return getSourcePart();
				return basicGetSourcePart();
			case DeploymentPackage.ALLOCATION__ID:
				return getId();
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
			case DeploymentPackage.ALLOCATION__TARGET_PART:
				setTargetPart((DeploymentPart)newValue);
				return;
			case DeploymentPackage.ALLOCATION__DEPLOYMENT:
				setDeployment((Deployment)newValue);
				return;
			case DeploymentPackage.ALLOCATION__SOURCE_PART:
				setSourcePart((DeploymentPart)newValue);
				return;
			case DeploymentPackage.ALLOCATION__ID:
				setId((String)newValue);
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
			case DeploymentPackage.ALLOCATION__TARGET_PART:
				setTargetPart((DeploymentPart)null);
				return;
			case DeploymentPackage.ALLOCATION__DEPLOYMENT:
				setDeployment((Deployment)null);
				return;
			case DeploymentPackage.ALLOCATION__SOURCE_PART:
				setSourcePart((DeploymentPart)null);
				return;
			case DeploymentPackage.ALLOCATION__ID:
				unsetId();
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
			case DeploymentPackage.ALLOCATION__TARGET_PART:
				return targetPart != null;
			case DeploymentPackage.ALLOCATION__DEPLOYMENT:
				return getDeployment() != null;
			case DeploymentPackage.ALLOCATION__SOURCE_PART:
				return sourcePart != null;
			case DeploymentPackage.ALLOCATION__ID:
				return isSetId();
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
		result.append(" (id: ");
		if (idESet) result.append(id); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //AllocationImpl
