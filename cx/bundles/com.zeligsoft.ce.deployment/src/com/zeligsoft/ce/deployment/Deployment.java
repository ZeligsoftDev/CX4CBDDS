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
package com.zeligsoft.ce.deployment;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.ce.deployment.Deployment#getDeploymentPart <em>Deployment Part</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.Deployment#getAllocation <em>Allocation</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getDeployment()
 * @model
 * @generated
 */
public interface Deployment extends ENamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	String copyright = "* Copyright (c) 2008 Zeligsoft Inc.\r\n *\r\n * All rights reserved. \r\n *  \r\n * THIS PROGRAM IS THE UNPUBLISHED, PROPRIETARY PROPERTY OF ZELIGSOFT INC. AND\r\n * IS TO BE MAINTAINED IN STRICT CONFIDENCE.  UNAUTHORIZED REPRODUCTION, \r\n * DISTRIBUTION OR DISCLOSURE OF THIS PROGRAM, OR ANY PROGRAM DERIVED FROM IT,\r\n * IS STRICTLY PROHIBITED.";
	String copyright = "* Copyright 2018 ADLINK Technology Limited.\r\n *\r\n * Licensed under the Apache License, Version 2.0";
	/**
	 * Returns the value of the '<em><b>Deployment Part</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ce.deployment.DeploymentPart}.
	 * It is bidirectional and its opposite is '{@link com.zeligsoft.ce.deployment.DeploymentPart#getDeployment <em>Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deployment Part</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deployment Part</em>' containment reference list.
	 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getDeployment_DeploymentPart()
	 * @see com.zeligsoft.ce.deployment.DeploymentPart#getDeployment
	 * @model opposite="deployment" containment="true" keys="id" ordered="false"
	 * @generated
	 */
	EList<DeploymentPart> getDeploymentPart();

	/**
	 * Returns the value of the '<em><b>Allocation</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ce.deployment.Allocation}.
	 * It is bidirectional and its opposite is '{@link com.zeligsoft.ce.deployment.Allocation#getDeployment <em>Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocation</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation</em>' containment reference list.
	 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getDeployment_Allocation()
	 * @see com.zeligsoft.ce.deployment.Allocation#getDeployment
	 * @model opposite="deployment" containment="true" ordered="false"
	 * @generated
	 */
	EList<Allocation> getAllocation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getDepth();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
	EList<DeploymentPart> getAllDeploymentParts();

	ArrayList<DeploymentPart> getDeploymentParts();

} // Deployment
