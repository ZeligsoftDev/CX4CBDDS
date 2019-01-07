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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.zeligsoft.ce.deployment.Allocation;
import com.zeligsoft.ce.deployment.Deployment;
import com.zeligsoft.ce.deployment.DeploymentPackage;
import com.zeligsoft.ce.deployment.DeploymentPart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.ce.deployment.impl.DeploymentImpl#getDeploymentPart <em>Deployment Part</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.impl.DeploymentImpl#getAllocation <em>Allocation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeploymentImpl extends ENamedElementImpl implements Deployment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	public static final String copyright = "* Copyright (c) 2008 Zeligsoft Inc.\r\n *\r\n * All rights reserved. \r\n *  \r\n * THIS PROGRAM IS THE UNPUBLISHED, PROPRIETARY PROPERTY OF ZELIGSOFT INC. AND\r\n * IS TO BE MAINTAINED IN STRICT CONFIDENCE.  UNAUTHORIZED REPRODUCTION, \r\n * DISTRIBUTION OR DISCLOSURE OF THIS PROGRAM, OR ANY PROGRAM DERIVED FROM IT,\r\n * IS STRICTLY PROHIBITED.";
	public static final String copyright = "* Copyright 2018 ADLINK Technology Limited.\r\n *\r\n * Licensed under the Apache License, Version 2.0";
	/**
	 * The cached value of the '{@link #getDeploymentPart() <em>Deployment Part</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeploymentPart()
	 * @generated
	 * @ordered
	 */
	protected EList<DeploymentPart> deploymentPart;

	/**
	 * The cached value of the '{@link #getAllocation() <em>Allocation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocation()
	 * @generated
	 * @ordered
	 */
	protected EList<Allocation> allocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeploymentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeploymentPackage.Literals.DEPLOYMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeploymentPart> getDeploymentPart() {
		if (deploymentPart == null) {
			deploymentPart = new EObjectContainmentWithInverseEList<DeploymentPart>(DeploymentPart.class, this, DeploymentPackage.DEPLOYMENT__DEPLOYMENT_PART, DeploymentPackage.DEPLOYMENT_PART__DEPLOYMENT);
		}
		return deploymentPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Allocation> getAllocation() {
		if (allocation == null) {
			allocation = new EObjectContainmentWithInverseEList<Allocation>(Allocation.class, this, DeploymentPackage.DEPLOYMENT__ALLOCATION, DeploymentPackage.ALLOCATION__DEPLOYMENT);
		}
		return allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the maximum of the depth of all contained parts.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getDepth() {
		
		int retVal = 0;
		
		for( int i = 0; i < getDeploymentParts().size(); i++ )
		{			
			int depth = getDeploymentParts().get(i).getDepth(); 
			if( depth > retVal ) retVal = depth;			
		}
		
		return retVal;

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<DeploymentPart> getAllDeploymentParts() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case DeploymentPackage.DEPLOYMENT__DEPLOYMENT_PART:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeploymentPart()).basicAdd(otherEnd, msgs);
			case DeploymentPackage.DEPLOYMENT__ALLOCATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAllocation()).basicAdd(otherEnd, msgs);
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
			case DeploymentPackage.DEPLOYMENT__DEPLOYMENT_PART:
				return ((InternalEList<?>)getDeploymentPart()).basicRemove(otherEnd, msgs);
			case DeploymentPackage.DEPLOYMENT__ALLOCATION:
				return ((InternalEList<?>)getAllocation()).basicRemove(otherEnd, msgs);
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
			case DeploymentPackage.DEPLOYMENT__DEPLOYMENT_PART:
				return getDeploymentPart();
			case DeploymentPackage.DEPLOYMENT__ALLOCATION:
				return getAllocation();
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
			case DeploymentPackage.DEPLOYMENT__DEPLOYMENT_PART:
				getDeploymentPart().clear();
				getDeploymentPart().addAll((Collection<? extends DeploymentPart>)newValue);
				return;
			case DeploymentPackage.DEPLOYMENT__ALLOCATION:
				getAllocation().clear();
				getAllocation().addAll((Collection<? extends Allocation>)newValue);
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
			case DeploymentPackage.DEPLOYMENT__DEPLOYMENT_PART:
				getDeploymentPart().clear();
				return;
			case DeploymentPackage.DEPLOYMENT__ALLOCATION:
				getAllocation().clear();
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
			case DeploymentPackage.DEPLOYMENT__DEPLOYMENT_PART:
				return deploymentPart != null && !deploymentPart.isEmpty();
			case DeploymentPackage.DEPLOYMENT__ALLOCATION:
				return allocation != null && !allocation.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public ArrayList<DeploymentPart> getDeploymentParts() {
		
		ArrayList<DeploymentPart> deploymentParts = new ArrayList<DeploymentPart>();
		
		for(int i = 0; i < getDeploymentPart().size(); i++)
		{
			deploymentParts.addAll(getDeploymentParts(getDeploymentPart().get(i)));
		}
		
		return deploymentParts;	    
	}
	
	/**
	 * Iterates through a tree of deployment parts and returns a flat list.
	 */ 
	private ArrayList<DeploymentPart> getDeploymentParts(DeploymentPart deploymentPart)
	{
		ArrayList<DeploymentPart> retVal = new ArrayList<DeploymentPart>();
		
		retVal.add(deploymentPart);
		
		for( int i = 0; i < deploymentPart.getChildPart().size(); i++)
		{
			retVal.addAll(getDeploymentParts(deploymentPart.getChildPart().get(i)));
		}
		
		return retVal;
	}

} //DeploymentImpl
