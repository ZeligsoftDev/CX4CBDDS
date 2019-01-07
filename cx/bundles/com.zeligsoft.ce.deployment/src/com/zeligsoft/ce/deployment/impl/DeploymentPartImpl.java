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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.zeligsoft.ce.deployment.Allocation;
import com.zeligsoft.ce.deployment.Deployment;
import com.zeligsoft.ce.deployment.DeploymentPackage;
import com.zeligsoft.ce.deployment.DeploymentPart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.ce.deployment.impl.DeploymentPartImpl#getConfigurationElement <em>Configuration Element</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.impl.DeploymentPartImpl#getSourceAllocation <em>Source Allocation</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.impl.DeploymentPartImpl#getTargetAllocation <em>Target Allocation</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.impl.DeploymentPartImpl#getParentPart <em>Parent Part</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.impl.DeploymentPartImpl#getChildPart <em>Child Part</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.impl.DeploymentPartImpl#getDeployment <em>Deployment</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.impl.DeploymentPartImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.impl.DeploymentPartImpl#getModelElement <em>Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DeploymentPartImpl extends ENamedElementImpl implements DeploymentPart {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	public static final String copyright = "* Copyright (c) 2008 Zeligsoft Inc.\r\n *\r\n * All rights reserved. \r\n *  \r\n * THIS PROGRAM IS THE UNPUBLISHED, PROPRIETARY PROPERTY OF ZELIGSOFT INC. AND\r\n * IS TO BE MAINTAINED IN STRICT CONFIDENCE.  UNAUTHORIZED REPRODUCTION, \r\n * DISTRIBUTION OR DISCLOSURE OF THIS PROGRAM, OR ANY PROGRAM DERIVED FROM IT,\r\n * IS STRICTLY PROHIBITED.";
	public static final String copyright = "* Copyright 2018 ADLINK Technology Limited.\r\n *\r\n * Licensed under the Apache License, Version 2.0";
	/**
	 * The default value of the '{@link #getConfigurationElement() <em>Configuration Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationElement()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIGURATION_ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfigurationElement() <em>Configuration Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationElement()
	 * @generated
	 * @ordered
	 */
	protected String configurationElement = CONFIGURATION_ELEMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceAllocation() <em>Source Allocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceAllocation()
	 * @generated
	 * @ordered
	 */
	protected Allocation sourceAllocation;

	/**
	 * The cached value of the '{@link #getTargetAllocation() <em>Target Allocation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAllocation()
	 * @generated
	 * @ordered
	 */
	protected EList<Allocation> targetAllocation;

	/**
	 * The cached value of the '{@link #getChildPart() <em>Child Part</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildPart()
	 * @generated
	 * @ordered
	 */
	protected EList<DeploymentPart> childPart;

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
	 * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElement()
	 * @generated
	 * @ordered
	 */
	protected EObject modelElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected DeploymentPartImpl() {
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
		return DeploymentPackage.Literals.DEPLOYMENT_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getModelElement() {
		if (modelElement != null && modelElement.eIsProxy()) {
			InternalEObject oldModelElement = (InternalEObject)modelElement;
			modelElement = eResolveProxy(oldModelElement);
			if (modelElement != oldModelElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeploymentPackage.DEPLOYMENT_PART__MODEL_ELEMENT, oldModelElement, modelElement));
			}
		}
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetModelElement() {
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setModelElement(EObject newModelElement) {
		EObject oldModelElement = modelElement;
		this.oldModelElement = oldModelElement; 
		modelElement = newModelElement;		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeploymentPackage.DEPLOYMENT_PART__MODEL_ELEMENT, oldModelElement, modelElement));
	}
	
	private EObject oldModelElement = null;
	
	public EObject getOldModelElement()
	{
		return oldModelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfigurationElement() {
		return configurationElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurationElement(String newConfigurationElement) {
		String oldConfigurationElement = configurationElement;
		configurationElement = newConfigurationElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeploymentPackage.DEPLOYMENT_PART__CONFIGURATION_ELEMENT, oldConfigurationElement, configurationElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Allocation getSourceAllocation() {
		if (sourceAllocation != null && sourceAllocation.eIsProxy()) {
			InternalEObject oldSourceAllocation = (InternalEObject)sourceAllocation;
			sourceAllocation = (Allocation)eResolveProxy(oldSourceAllocation);
			if (sourceAllocation != oldSourceAllocation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeploymentPackage.DEPLOYMENT_PART__SOURCE_ALLOCATION, oldSourceAllocation, sourceAllocation));
			}
		}
		return sourceAllocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Allocation basicGetSourceAllocation() {
		return sourceAllocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceAllocation(Allocation newSourceAllocation, NotificationChain msgs) {
		Allocation oldSourceAllocation = sourceAllocation;
		sourceAllocation = newSourceAllocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeploymentPackage.DEPLOYMENT_PART__SOURCE_ALLOCATION, oldSourceAllocation, newSourceAllocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceAllocation(Allocation newSourceAllocation) {
		if (newSourceAllocation != sourceAllocation) {
			NotificationChain msgs = null;
			if (sourceAllocation != null)
				msgs = ((InternalEObject)sourceAllocation).eInverseRemove(this, DeploymentPackage.ALLOCATION__SOURCE_PART, Allocation.class, msgs);
			if (newSourceAllocation != null)
				msgs = ((InternalEObject)newSourceAllocation).eInverseAdd(this, DeploymentPackage.ALLOCATION__SOURCE_PART, Allocation.class, msgs);
			msgs = basicSetSourceAllocation(newSourceAllocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeploymentPackage.DEPLOYMENT_PART__SOURCE_ALLOCATION, newSourceAllocation, newSourceAllocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Allocation> getTargetAllocation() {
		if (targetAllocation == null) {
			targetAllocation = new EObjectWithInverseResolvingEList<Allocation>(Allocation.class, this, DeploymentPackage.DEPLOYMENT_PART__TARGET_ALLOCATION, DeploymentPackage.ALLOCATION__TARGET_PART);
		}
		return targetAllocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentPart getParentPart() {
		if (eContainerFeatureID != DeploymentPackage.DEPLOYMENT_PART__PARENT_PART) return null;
		return (DeploymentPart)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentPart(DeploymentPart newParentPart, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentPart, DeploymentPackage.DEPLOYMENT_PART__PARENT_PART, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentPart(DeploymentPart newParentPart) {
		if (newParentPart != eInternalContainer() || (eContainerFeatureID != DeploymentPackage.DEPLOYMENT_PART__PARENT_PART && newParentPart != null)) {
			if (EcoreUtil.isAncestor(this, newParentPart))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentPart != null)
				msgs = ((InternalEObject)newParentPart).eInverseAdd(this, DeploymentPackage.DEPLOYMENT_PART__CHILD_PART, DeploymentPart.class, msgs);
			msgs = basicSetParentPart(newParentPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeploymentPackage.DEPLOYMENT_PART__PARENT_PART, newParentPart, newParentPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeploymentPart> getChildPart() {
		if (childPart == null) {
			childPart = new EObjectContainmentWithInverseEList<DeploymentPart>(DeploymentPart.class, this, DeploymentPackage.DEPLOYMENT_PART__CHILD_PART, DeploymentPackage.DEPLOYMENT_PART__PARENT_PART);
		}
		return childPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deployment getDeployment() {
		if (eContainerFeatureID != DeploymentPackage.DEPLOYMENT_PART__DEPLOYMENT) return null;
		return (Deployment)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeployment(Deployment newDeployment, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDeployment, DeploymentPackage.DEPLOYMENT_PART__DEPLOYMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeployment(Deployment newDeployment) {
		if (newDeployment != eInternalContainer() || (eContainerFeatureID != DeploymentPackage.DEPLOYMENT_PART__DEPLOYMENT && newDeployment != null)) {
			if (EcoreUtil.isAncestor(this, newDeployment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDeployment != null)
				msgs = ((InternalEObject)newDeployment).eInverseAdd(this, DeploymentPackage.DEPLOYMENT__DEPLOYMENT_PART, Deployment.class, msgs);
			msgs = basicSetDeployment(newDeployment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeploymentPackage.DEPLOYMENT_PART__DEPLOYMENT, newDeployment, newDeployment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DeploymentPackage.DEPLOYMENT_PART__ID, oldId, id, !oldIdESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, DeploymentPackage.DEPLOYMENT_PART__ID, oldId, ID_EDEFAULT, oldIdESet));
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
	 * This function returns the Deployment object in which this part is contained.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Deployment getContainingDeployment() {
		DeploymentPart parent = this;
		while( parent.getParentPart() != null )
		{
			parent = parent.getParentPart();
		}
		return parent.getDeployment();
	}

	/**
	 * <!-- begin-user-doc -->
	 * This function returns the part on which this part is deployed. If the part is undeployed, it returns null.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DeploymentPart getPartDeployedOn() {
		if( getSourceAllocation() == null )
			return null;
		
		return getSourceAllocation().getTargetPart();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * This function calculates the "depth" of a deployment part, which is the number of ancestor deployment
	 * parts for this deployment part. 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getDepth() {
		
		if( getParentPart() == null)
			return 0;
		
		return 1 + getParentPart().getDepth();
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
			case DeploymentPackage.DEPLOYMENT_PART__SOURCE_ALLOCATION:
				if (sourceAllocation != null)
					msgs = ((InternalEObject)sourceAllocation).eInverseRemove(this, DeploymentPackage.ALLOCATION__SOURCE_PART, Allocation.class, msgs);
				return basicSetSourceAllocation((Allocation)otherEnd, msgs);
			case DeploymentPackage.DEPLOYMENT_PART__TARGET_ALLOCATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargetAllocation()).basicAdd(otherEnd, msgs);
			case DeploymentPackage.DEPLOYMENT_PART__PARENT_PART:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentPart((DeploymentPart)otherEnd, msgs);
			case DeploymentPackage.DEPLOYMENT_PART__CHILD_PART:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildPart()).basicAdd(otherEnd, msgs);
			case DeploymentPackage.DEPLOYMENT_PART__DEPLOYMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeployment((Deployment)otherEnd, msgs);
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
			case DeploymentPackage.DEPLOYMENT_PART__SOURCE_ALLOCATION:
				return basicSetSourceAllocation(null, msgs);
			case DeploymentPackage.DEPLOYMENT_PART__TARGET_ALLOCATION:
				return ((InternalEList<?>)getTargetAllocation()).basicRemove(otherEnd, msgs);
			case DeploymentPackage.DEPLOYMENT_PART__PARENT_PART:
				return basicSetParentPart(null, msgs);
			case DeploymentPackage.DEPLOYMENT_PART__CHILD_PART:
				return ((InternalEList<?>)getChildPart()).basicRemove(otherEnd, msgs);
			case DeploymentPackage.DEPLOYMENT_PART__DEPLOYMENT:
				return basicSetDeployment(null, msgs);
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
			case DeploymentPackage.DEPLOYMENT_PART__PARENT_PART:
				return eInternalContainer().eInverseRemove(this, DeploymentPackage.DEPLOYMENT_PART__CHILD_PART, DeploymentPart.class, msgs);
			case DeploymentPackage.DEPLOYMENT_PART__DEPLOYMENT:
				return eInternalContainer().eInverseRemove(this, DeploymentPackage.DEPLOYMENT__DEPLOYMENT_PART, Deployment.class, msgs);
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
			case DeploymentPackage.DEPLOYMENT_PART__CONFIGURATION_ELEMENT:
				return getConfigurationElement();
			case DeploymentPackage.DEPLOYMENT_PART__SOURCE_ALLOCATION:
				if (resolve) return getSourceAllocation();
				return basicGetSourceAllocation();
			case DeploymentPackage.DEPLOYMENT_PART__TARGET_ALLOCATION:
				return getTargetAllocation();
			case DeploymentPackage.DEPLOYMENT_PART__PARENT_PART:
				return getParentPart();
			case DeploymentPackage.DEPLOYMENT_PART__CHILD_PART:
				return getChildPart();
			case DeploymentPackage.DEPLOYMENT_PART__DEPLOYMENT:
				return getDeployment();
			case DeploymentPackage.DEPLOYMENT_PART__ID:
				return getId();
			case DeploymentPackage.DEPLOYMENT_PART__MODEL_ELEMENT:
				if (resolve) return getModelElement();
				return basicGetModelElement();
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
			case DeploymentPackage.DEPLOYMENT_PART__CONFIGURATION_ELEMENT:
				setConfigurationElement((String)newValue);
				return;
			case DeploymentPackage.DEPLOYMENT_PART__SOURCE_ALLOCATION:
				setSourceAllocation((Allocation)newValue);
				return;
			case DeploymentPackage.DEPLOYMENT_PART__TARGET_ALLOCATION:
				getTargetAllocation().clear();
				getTargetAllocation().addAll((Collection<? extends Allocation>)newValue);
				return;
			case DeploymentPackage.DEPLOYMENT_PART__PARENT_PART:
				setParentPart((DeploymentPart)newValue);
				return;
			case DeploymentPackage.DEPLOYMENT_PART__CHILD_PART:
				getChildPart().clear();
				getChildPart().addAll((Collection<? extends DeploymentPart>)newValue);
				return;
			case DeploymentPackage.DEPLOYMENT_PART__DEPLOYMENT:
				setDeployment((Deployment)newValue);
				return;
			case DeploymentPackage.DEPLOYMENT_PART__ID:
				setId((String)newValue);
				return;
			case DeploymentPackage.DEPLOYMENT_PART__MODEL_ELEMENT:
				setModelElement((EObject)newValue);
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
			case DeploymentPackage.DEPLOYMENT_PART__CONFIGURATION_ELEMENT:
				setConfigurationElement(CONFIGURATION_ELEMENT_EDEFAULT);
				return;
			case DeploymentPackage.DEPLOYMENT_PART__SOURCE_ALLOCATION:
				setSourceAllocation((Allocation)null);
				return;
			case DeploymentPackage.DEPLOYMENT_PART__TARGET_ALLOCATION:
				getTargetAllocation().clear();
				return;
			case DeploymentPackage.DEPLOYMENT_PART__PARENT_PART:
				setParentPart((DeploymentPart)null);
				return;
			case DeploymentPackage.DEPLOYMENT_PART__CHILD_PART:
				getChildPart().clear();
				return;
			case DeploymentPackage.DEPLOYMENT_PART__DEPLOYMENT:
				setDeployment((Deployment)null);
				return;
			case DeploymentPackage.DEPLOYMENT_PART__ID:
				unsetId();
				return;
			case DeploymentPackage.DEPLOYMENT_PART__MODEL_ELEMENT:
				setModelElement((EObject)null);
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
			case DeploymentPackage.DEPLOYMENT_PART__CONFIGURATION_ELEMENT:
				return CONFIGURATION_ELEMENT_EDEFAULT == null ? configurationElement != null : !CONFIGURATION_ELEMENT_EDEFAULT.equals(configurationElement);
			case DeploymentPackage.DEPLOYMENT_PART__SOURCE_ALLOCATION:
				return sourceAllocation != null;
			case DeploymentPackage.DEPLOYMENT_PART__TARGET_ALLOCATION:
				return targetAllocation != null && !targetAllocation.isEmpty();
			case DeploymentPackage.DEPLOYMENT_PART__PARENT_PART:
				return getParentPart() != null;
			case DeploymentPackage.DEPLOYMENT_PART__CHILD_PART:
				return childPart != null && !childPart.isEmpty();
			case DeploymentPackage.DEPLOYMENT_PART__DEPLOYMENT:
				return getDeployment() != null;
			case DeploymentPackage.DEPLOYMENT_PART__ID:
				return isSetId();
			case DeploymentPackage.DEPLOYMENT_PART__MODEL_ELEMENT:
				return modelElement != null;
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
		result.append(" (configurationElement: ");
		result.append(configurationElement);
		result.append(", id: ");
		if (idESet) result.append(id); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //DeploymentPartImpl
