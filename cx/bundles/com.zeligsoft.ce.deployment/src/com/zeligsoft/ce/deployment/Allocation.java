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

import org.eclipse.emf.ecore.EModelElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Allocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.ce.deployment.Allocation#getTargetPart <em>Target Part</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.Allocation#getDeployment <em>Deployment</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.Allocation#getSourcePart <em>Source Part</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.Allocation#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getAllocation()
 * @model
 * @generated
 */
public interface Allocation extends EModelElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	String copyright = "* Copyright (c) 2008 Zeligsoft Inc.\r\n *\r\n * All rights reserved. \r\n *  \r\n * THIS PROGRAM IS THE UNPUBLISHED, PROPRIETARY PROPERTY OF ZELIGSOFT INC. AND\r\n * IS TO BE MAINTAINED IN STRICT CONFIDENCE.  UNAUTHORIZED REPRODUCTION, \r\n * DISTRIBUTION OR DISCLOSURE OF THIS PROGRAM, OR ANY PROGRAM DERIVED FROM IT,\r\n * IS STRICTLY PROHIBITED.";
	String copyright = "* Copyright 2018 ADLINK Technology Limited.\r\n *\r\n * Licensed under the Apache License, Version 2.0";
	/**
	 * Returns the value of the '<em><b>Target Part</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.zeligsoft.ce.deployment.DeploymentPart#getTargetAllocation <em>Target Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Part</em>' reference.
	 * @see #setTargetPart(DeploymentPart)
	 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getAllocation_TargetPart()
	 * @see com.zeligsoft.ce.deployment.DeploymentPart#getTargetAllocation
	 * @model opposite="targetAllocation" required="true" ordered="false"
	 * @generated
	 */
	DeploymentPart getTargetPart();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ce.deployment.Allocation#getTargetPart <em>Target Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Part</em>' reference.
	 * @see #getTargetPart()
	 * @generated
	 */
	void setTargetPart(DeploymentPart value);

	/**
	 * Returns the value of the '<em><b>Deployment</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.zeligsoft.ce.deployment.Deployment#getAllocation <em>Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deployment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deployment</em>' container reference.
	 * @see #setDeployment(Deployment)
	 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getAllocation_Deployment()
	 * @see com.zeligsoft.ce.deployment.Deployment#getAllocation
	 * @model opposite="allocation" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Deployment getDeployment();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ce.deployment.Allocation#getDeployment <em>Deployment</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deployment</em>' container reference.
	 * @see #getDeployment()
	 * @generated
	 */
	void setDeployment(Deployment value);

	/**
	 * Returns the value of the '<em><b>Source Part</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.zeligsoft.ce.deployment.DeploymentPart#getSourceAllocation <em>Source Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Part</em>' reference.
	 * @see #setSourcePart(DeploymentPart)
	 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getAllocation_SourcePart()
	 * @see com.zeligsoft.ce.deployment.DeploymentPart#getSourceAllocation
	 * @model opposite="sourceAllocation" required="true" ordered="false"
	 * @generated
	 */
	DeploymentPart getSourcePart();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ce.deployment.Allocation#getSourcePart <em>Source Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Part</em>' reference.
	 * @see #getSourcePart()
	 * @generated
	 */
	void setSourcePart(DeploymentPart value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #isSetId()
	 * @see #unsetId()
	 * @see #setId(String)
	 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getAllocation_Id()
	 * @model unsettable="true" id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ce.deployment.Allocation#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #isSetId()
	 * @see #unsetId()
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Unsets the value of the '{@link com.zeligsoft.ce.deployment.Allocation#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetId()
	 * @see #getId()
	 * @see #setId(String)
	 * @generated
	 */
	void unsetId();

	/**
	 * Returns whether the value of the '{@link com.zeligsoft.ce.deployment.Allocation#getId <em>Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Id</em>' attribute is set.
	 * @see #unsetId()
	 * @see #getId()
	 * @see #setId(String)
	 * @generated
	 */
	boolean isSetId();

} // Allocation
