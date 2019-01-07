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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * not(self.sourceAllocation.targetPart = self)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.ce.deployment.DeploymentPart#getConfigurationElement <em>Configuration Element</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.DeploymentPart#getSourceAllocation <em>Source Allocation</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.DeploymentPart#getTargetAllocation <em>Target Allocation</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.DeploymentPart#getParentPart <em>Parent Part</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.DeploymentPart#getChildPart <em>Child Part</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.DeploymentPart#getDeployment <em>Deployment</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.DeploymentPart#getId <em>Id</em>}</li>
 *   <li>{@link com.zeligsoft.ce.deployment.DeploymentPart#getModelElement <em>Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getDeploymentPart()
 * @model abstract="true"
 * @generated
 */
public interface DeploymentPart extends ENamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	String copyright = "* Copyright (c) 2008 Zeligsoft Inc.\r\n *\r\n * All rights reserved. \r\n *  \r\n * THIS PROGRAM IS THE UNPUBLISHED, PROPRIETARY PROPERTY OF ZELIGSOFT INC. AND\r\n * IS TO BE MAINTAINED IN STRICT CONFIDENCE.  UNAUTHORIZED REPRODUCTION, \r\n * DISTRIBUTION OR DISCLOSURE OF THIS PROGRAM, OR ANY PROGRAM DERIVED FROM IT,\r\n * IS STRICTLY PROHIBITED.";
	String copyright = "* Copyright 2018 ADLINK Technology Limited.\r\n *\r\n * Licensed under the Apache License, Version 2.0";
	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element</em>' reference.
	 * @see #setModelElement(EObject)
	 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getDeploymentPart_ModelElement()
	 * @model
	 * @generated
	 */
	EObject getModelElement();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ce.deployment.DeploymentPart#getModelElement <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element</em>' reference.
	 * @see #getModelElement()
	 * @generated
	 */
	void setModelElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Configuration Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Element</em>' attribute.
	 * @see #setConfigurationElement(String)
	 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getDeploymentPart_ConfigurationElement()
	 * @model ordered="false"
	 * @generated
	 */
	String getConfigurationElement();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ce.deployment.DeploymentPart#getConfigurationElement <em>Configuration Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Element</em>' attribute.
	 * @see #getConfigurationElement()
	 * @generated
	 */
	void setConfigurationElement(String value);

	/**
	 * Returns the value of the '<em><b>Source Allocation</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.zeligsoft.ce.deployment.Allocation#getSourcePart <em>Source Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Allocation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Allocation</em>' reference.
	 * @see #setSourceAllocation(Allocation)
	 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getDeploymentPart_SourceAllocation()
	 * @see com.zeligsoft.ce.deployment.Allocation#getSourcePart
	 * @model opposite="sourcePart" ordered="false"
	 * @generated
	 */
	Allocation getSourceAllocation();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ce.deployment.DeploymentPart#getSourceAllocation <em>Source Allocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Allocation</em>' reference.
	 * @see #getSourceAllocation()
	 * @generated
	 */
	void setSourceAllocation(Allocation value);

	/**
	 * Returns the value of the '<em><b>Target Allocation</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ce.deployment.Allocation}.
	 * It is bidirectional and its opposite is '{@link com.zeligsoft.ce.deployment.Allocation#getTargetPart <em>Target Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Allocation</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Allocation</em>' reference list.
	 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getDeploymentPart_TargetAllocation()
	 * @see com.zeligsoft.ce.deployment.Allocation#getTargetPart
	 * @model opposite="targetPart" ordered="false"
	 * @generated
	 */
	EList<Allocation> getTargetAllocation();

	/**
	 * Returns the value of the '<em><b>Parent Part</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.zeligsoft.ce.deployment.DeploymentPart#getChildPart <em>Child Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Part</em>' container reference.
	 * @see #setParentPart(DeploymentPart)
	 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getDeploymentPart_ParentPart()
	 * @see com.zeligsoft.ce.deployment.DeploymentPart#getChildPart
	 * @model opposite="childPart" keys="id" transient="false" ordered="false"
	 * @generated
	 */
	DeploymentPart getParentPart();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ce.deployment.DeploymentPart#getParentPart <em>Parent Part</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Part</em>' container reference.
	 * @see #getParentPart()
	 * @generated
	 */
	void setParentPart(DeploymentPart value);

	/**
	 * Returns the value of the '<em><b>Child Part</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ce.deployment.DeploymentPart}.
	 * It is bidirectional and its opposite is '{@link com.zeligsoft.ce.deployment.DeploymentPart#getParentPart <em>Parent Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Part</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Part</em>' containment reference list.
	 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getDeploymentPart_ChildPart()
	 * @see com.zeligsoft.ce.deployment.DeploymentPart#getParentPart
	 * @model opposite="parentPart" containment="true" keys="id" ordered="false"
	 * @generated
	 */
	EList<DeploymentPart> getChildPart();

	/**
	 * Returns the value of the '<em><b>Deployment</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.zeligsoft.ce.deployment.Deployment#getDeploymentPart <em>Deployment Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deployment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deployment</em>' container reference.
	 * @see #setDeployment(Deployment)
	 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getDeploymentPart_Deployment()
	 * @see com.zeligsoft.ce.deployment.Deployment#getDeploymentPart
	 * @model opposite="deploymentPart" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Deployment getDeployment();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ce.deployment.DeploymentPart#getDeployment <em>Deployment</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deployment</em>' container reference.
	 * @see #getDeployment()
	 * @generated
	 */
	void setDeployment(Deployment value);

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
	 * @see com.zeligsoft.ce.deployment.DeploymentPackage#getDeploymentPart_Id()
	 * @model unsettable="true" id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ce.deployment.DeploymentPart#getId <em>Id</em>}' attribute.
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
	 * Unsets the value of the '{@link com.zeligsoft.ce.deployment.DeploymentPart#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetId()
	 * @see #getId()
	 * @see #setId(String)
	 * @generated
	 */
	void unsetId();

	/**
	 * Returns whether the value of the '{@link com.zeligsoft.ce.deployment.DeploymentPart#getId <em>Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Id</em>' attribute is set.
	 * @see #unsetId()
	 * @see #getId()
	 * @see #setId(String)
	 * @generated
	 */
	boolean isSetId();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Deployment getContainingDeployment();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	DeploymentPart getPartDeployedOn();

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
	 * @model kind="operation"
	 * @generated
	 */
	EObject getOldModelElement();

} // DeploymentPart
