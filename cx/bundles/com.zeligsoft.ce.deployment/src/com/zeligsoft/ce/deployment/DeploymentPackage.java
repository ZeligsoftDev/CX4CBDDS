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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * TBD
 * 
 * 
 * This will be harder
 * <!-- end-model-doc -->
 * @see com.zeligsoft.ce.deployment.DeploymentFactory
 * @model kind="package"
 * @generated
 */
public interface DeploymentPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	String copyright = "* Copyright (c) 2008 Zeligsoft Inc.\r\n *\r\n * All rights reserved. \r\n *  \r\n * THIS PROGRAM IS THE UNPUBLISHED, PROPRIETARY PROPERTY OF ZELIGSOFT INC. AND\r\n * IS TO BE MAINTAINED IN STRICT CONFIDENCE.  UNAUTHORIZED REPRODUCTION, \r\n * DISTRIBUTION OR DISCLOSURE OF THIS PROGRAM, OR ANY PROGRAM DERIVED FROM IT,\r\n * IS STRICTLY PROHIBITED.";
	String copyright = "* Copyright 2018 ADLINK Technology Limited.\r\n *\r\n * Licensed under the Apache License, Version 2.0";
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "deployment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.zeligsoft.com/zdm/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "zdm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DeploymentPackage eINSTANCE = com.zeligsoft.ce.deployment.impl.DeploymentPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.zeligsoft.ce.deployment.impl.DeploymentImpl <em>Deployment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ce.deployment.impl.DeploymentImpl
	 * @see com.zeligsoft.ce.deployment.impl.DeploymentPackageImpl#getDeployment()
	 * @generated
	 */
	int DEPLOYMENT = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__EANNOTATIONS = EcorePackage.ENAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__NAME = EcorePackage.ENAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Deployment Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__DEPLOYMENT_PART = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allocation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__ALLOCATION = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Deployment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_FEATURE_COUNT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ce.deployment.impl.DeploymentPartImpl <em>Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ce.deployment.impl.DeploymentPartImpl
	 * @see com.zeligsoft.ce.deployment.impl.DeploymentPackageImpl#getDeploymentPart()
	 * @generated
	 */
	int DEPLOYMENT_PART = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART__EANNOTATIONS = EcorePackage.ENAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART__NAME = EcorePackage.ENAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Configuration Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART__CONFIGURATION_ELEMENT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Allocation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART__SOURCE_ALLOCATION = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Allocation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART__TARGET_ALLOCATION = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent Part</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART__PARENT_PART = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Child Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART__CHILD_PART = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Deployment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART__DEPLOYMENT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART__ID = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART__MODEL_ELEMENT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART_FEATURE_COUNT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ce.deployment.impl.AllocationImpl <em>Allocation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ce.deployment.impl.AllocationImpl
	 * @see com.zeligsoft.ce.deployment.impl.DeploymentPackageImpl#getAllocation()
	 * @generated
	 */
	int ALLOCATION = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Target Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__TARGET_PART = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deployment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__DEPLOYMENT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__SOURCE_PART = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__ID = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Allocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ce.deployment.impl.DeploymentComponentPartImpl <em>Component Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ce.deployment.impl.DeploymentComponentPartImpl
	 * @see com.zeligsoft.ce.deployment.impl.DeploymentPackageImpl#getDeploymentComponentPart()
	 * @generated
	 */
	int DEPLOYMENT_COMPONENT_PART = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_COMPONENT_PART__EANNOTATIONS = DEPLOYMENT_PART__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_COMPONENT_PART__NAME = DEPLOYMENT_PART__NAME;

	/**
	 * The feature id for the '<em><b>Configuration Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_COMPONENT_PART__CONFIGURATION_ELEMENT = DEPLOYMENT_PART__CONFIGURATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Source Allocation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_COMPONENT_PART__SOURCE_ALLOCATION = DEPLOYMENT_PART__SOURCE_ALLOCATION;

	/**
	 * The feature id for the '<em><b>Target Allocation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_COMPONENT_PART__TARGET_ALLOCATION = DEPLOYMENT_PART__TARGET_ALLOCATION;

	/**
	 * The feature id for the '<em><b>Parent Part</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_COMPONENT_PART__PARENT_PART = DEPLOYMENT_PART__PARENT_PART;

	/**
	 * The feature id for the '<em><b>Child Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_COMPONENT_PART__CHILD_PART = DEPLOYMENT_PART__CHILD_PART;

	/**
	 * The feature id for the '<em><b>Deployment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_COMPONENT_PART__DEPLOYMENT = DEPLOYMENT_PART__DEPLOYMENT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_COMPONENT_PART__ID = DEPLOYMENT_PART__ID;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_COMPONENT_PART__MODEL_ELEMENT = DEPLOYMENT_PART__MODEL_ELEMENT;

	/**
	 * The number of structural features of the '<em>Component Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_COMPONENT_PART_FEATURE_COUNT = DEPLOYMENT_PART_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ce.deployment.impl.DeploymentConnectorPartImpl <em>Connector Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ce.deployment.impl.DeploymentConnectorPartImpl
	 * @see com.zeligsoft.ce.deployment.impl.DeploymentPackageImpl#getDeploymentConnectorPart()
	 * @generated
	 */
	int DEPLOYMENT_CONNECTOR_PART = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_CONNECTOR_PART__EANNOTATIONS = DEPLOYMENT_PART__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_CONNECTOR_PART__NAME = DEPLOYMENT_PART__NAME;

	/**
	 * The feature id for the '<em><b>Configuration Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_CONNECTOR_PART__CONFIGURATION_ELEMENT = DEPLOYMENT_PART__CONFIGURATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Source Allocation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_CONNECTOR_PART__SOURCE_ALLOCATION = DEPLOYMENT_PART__SOURCE_ALLOCATION;

	/**
	 * The feature id for the '<em><b>Target Allocation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_CONNECTOR_PART__TARGET_ALLOCATION = DEPLOYMENT_PART__TARGET_ALLOCATION;

	/**
	 * The feature id for the '<em><b>Parent Part</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_CONNECTOR_PART__PARENT_PART = DEPLOYMENT_PART__PARENT_PART;

	/**
	 * The feature id for the '<em><b>Child Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_CONNECTOR_PART__CHILD_PART = DEPLOYMENT_PART__CHILD_PART;

	/**
	 * The feature id for the '<em><b>Deployment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_CONNECTOR_PART__DEPLOYMENT = DEPLOYMENT_PART__DEPLOYMENT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_CONNECTOR_PART__ID = DEPLOYMENT_PART__ID;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_CONNECTOR_PART__MODEL_ELEMENT = DEPLOYMENT_PART__MODEL_ELEMENT;

	/**
	 * The number of structural features of the '<em>Connector Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_CONNECTOR_PART_FEATURE_COUNT = DEPLOYMENT_PART_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ce.deployment.impl.DeploymentPortPartImpl <em>Port Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ce.deployment.impl.DeploymentPortPartImpl
	 * @see com.zeligsoft.ce.deployment.impl.DeploymentPackageImpl#getDeploymentPortPart()
	 * @generated
	 */
	int DEPLOYMENT_PORT_PART = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PORT_PART__EANNOTATIONS = DEPLOYMENT_PART__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PORT_PART__NAME = DEPLOYMENT_PART__NAME;

	/**
	 * The feature id for the '<em><b>Configuration Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PORT_PART__CONFIGURATION_ELEMENT = DEPLOYMENT_PART__CONFIGURATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Source Allocation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PORT_PART__SOURCE_ALLOCATION = DEPLOYMENT_PART__SOURCE_ALLOCATION;

	/**
	 * The feature id for the '<em><b>Target Allocation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PORT_PART__TARGET_ALLOCATION = DEPLOYMENT_PART__TARGET_ALLOCATION;

	/**
	 * The feature id for the '<em><b>Parent Part</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PORT_PART__PARENT_PART = DEPLOYMENT_PART__PARENT_PART;

	/**
	 * The feature id for the '<em><b>Child Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PORT_PART__CHILD_PART = DEPLOYMENT_PART__CHILD_PART;

	/**
	 * The feature id for the '<em><b>Deployment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PORT_PART__DEPLOYMENT = DEPLOYMENT_PART__DEPLOYMENT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PORT_PART__ID = DEPLOYMENT_PART__ID;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PORT_PART__MODEL_ELEMENT = DEPLOYMENT_PART__MODEL_ELEMENT;

	/**
	 * The number of structural features of the '<em>Port Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PORT_PART_FEATURE_COUNT = DEPLOYMENT_PART_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ce.deployment.Deployment <em>Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment</em>'.
	 * @see com.zeligsoft.ce.deployment.Deployment
	 * @generated
	 */
	EClass getDeployment();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ce.deployment.Deployment#getDeploymentPart <em>Deployment Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deployment Part</em>'.
	 * @see com.zeligsoft.ce.deployment.Deployment#getDeploymentPart()
	 * @see #getDeployment()
	 * @generated
	 */
	EReference getDeployment_DeploymentPart();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ce.deployment.Deployment#getAllocation <em>Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Allocation</em>'.
	 * @see com.zeligsoft.ce.deployment.Deployment#getAllocation()
	 * @see #getDeployment()
	 * @generated
	 */
	EReference getDeployment_Allocation();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ce.deployment.DeploymentPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part</em>'.
	 * @see com.zeligsoft.ce.deployment.DeploymentPart
	 * @generated
	 */
	EClass getDeploymentPart();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ce.deployment.DeploymentPart#getModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Element</em>'.
	 * @see com.zeligsoft.ce.deployment.DeploymentPart#getModelElement()
	 * @see #getDeploymentPart()
	 * @generated
	 */
	EReference getDeploymentPart_ModelElement();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ce.deployment.DeploymentPart#getConfigurationElement <em>Configuration Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Configuration Element</em>'.
	 * @see com.zeligsoft.ce.deployment.DeploymentPart#getConfigurationElement()
	 * @see #getDeploymentPart()
	 * @generated
	 */
	EAttribute getDeploymentPart_ConfigurationElement();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ce.deployment.DeploymentPart#getSourceAllocation <em>Source Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Allocation</em>'.
	 * @see com.zeligsoft.ce.deployment.DeploymentPart#getSourceAllocation()
	 * @see #getDeploymentPart()
	 * @generated
	 */
	EReference getDeploymentPart_SourceAllocation();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ce.deployment.DeploymentPart#getTargetAllocation <em>Target Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Allocation</em>'.
	 * @see com.zeligsoft.ce.deployment.DeploymentPart#getTargetAllocation()
	 * @see #getDeploymentPart()
	 * @generated
	 */
	EReference getDeploymentPart_TargetAllocation();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.ce.deployment.DeploymentPart#getParentPart <em>Parent Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Part</em>'.
	 * @see com.zeligsoft.ce.deployment.DeploymentPart#getParentPart()
	 * @see #getDeploymentPart()
	 * @generated
	 */
	EReference getDeploymentPart_ParentPart();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ce.deployment.DeploymentPart#getChildPart <em>Child Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child Part</em>'.
	 * @see com.zeligsoft.ce.deployment.DeploymentPart#getChildPart()
	 * @see #getDeploymentPart()
	 * @generated
	 */
	EReference getDeploymentPart_ChildPart();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.ce.deployment.DeploymentPart#getDeployment <em>Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Deployment</em>'.
	 * @see com.zeligsoft.ce.deployment.DeploymentPart#getDeployment()
	 * @see #getDeploymentPart()
	 * @generated
	 */
	EReference getDeploymentPart_Deployment();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ce.deployment.DeploymentPart#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.zeligsoft.ce.deployment.DeploymentPart#getId()
	 * @see #getDeploymentPart()
	 * @generated
	 */
	EAttribute getDeploymentPart_Id();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ce.deployment.Allocation <em>Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allocation</em>'.
	 * @see com.zeligsoft.ce.deployment.Allocation
	 * @generated
	 */
	EClass getAllocation();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ce.deployment.Allocation#getTargetPart <em>Target Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Part</em>'.
	 * @see com.zeligsoft.ce.deployment.Allocation#getTargetPart()
	 * @see #getAllocation()
	 * @generated
	 */
	EReference getAllocation_TargetPart();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.ce.deployment.Allocation#getDeployment <em>Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Deployment</em>'.
	 * @see com.zeligsoft.ce.deployment.Allocation#getDeployment()
	 * @see #getAllocation()
	 * @generated
	 */
	EReference getAllocation_Deployment();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ce.deployment.Allocation#getSourcePart <em>Source Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Part</em>'.
	 * @see com.zeligsoft.ce.deployment.Allocation#getSourcePart()
	 * @see #getAllocation()
	 * @generated
	 */
	EReference getAllocation_SourcePart();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ce.deployment.Allocation#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.zeligsoft.ce.deployment.Allocation#getId()
	 * @see #getAllocation()
	 * @generated
	 */
	EAttribute getAllocation_Id();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ce.deployment.DeploymentComponentPart <em>Component Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Part</em>'.
	 * @see com.zeligsoft.ce.deployment.DeploymentComponentPart
	 * @generated
	 */
	EClass getDeploymentComponentPart();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ce.deployment.DeploymentConnectorPart <em>Connector Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Part</em>'.
	 * @see com.zeligsoft.ce.deployment.DeploymentConnectorPart
	 * @generated
	 */
	EClass getDeploymentConnectorPart();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ce.deployment.DeploymentPortPart <em>Port Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Part</em>'.
	 * @see com.zeligsoft.ce.deployment.DeploymentPortPart
	 * @generated
	 */
	EClass getDeploymentPortPart();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DeploymentFactory getDeploymentFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.zeligsoft.ce.deployment.impl.DeploymentImpl <em>Deployment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ce.deployment.impl.DeploymentImpl
		 * @see com.zeligsoft.ce.deployment.impl.DeploymentPackageImpl#getDeployment()
		 * @generated
		 */
		EClass DEPLOYMENT = eINSTANCE.getDeployment();

		/**
		 * The meta object literal for the '<em><b>Deployment Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT__DEPLOYMENT_PART = eINSTANCE.getDeployment_DeploymentPart();

		/**
		 * The meta object literal for the '<em><b>Allocation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT__ALLOCATION = eINSTANCE.getDeployment_Allocation();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ce.deployment.impl.DeploymentPartImpl <em>Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ce.deployment.impl.DeploymentPartImpl
		 * @see com.zeligsoft.ce.deployment.impl.DeploymentPackageImpl#getDeploymentPart()
		 * @generated
		 */
		EClass DEPLOYMENT_PART = eINSTANCE.getDeploymentPart();

		/**
		 * The meta object literal for the '<em><b>Model Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PART__MODEL_ELEMENT = eINSTANCE.getDeploymentPart_ModelElement();

		/**
		 * The meta object literal for the '<em><b>Configuration Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT_PART__CONFIGURATION_ELEMENT = eINSTANCE.getDeploymentPart_ConfigurationElement();

		/**
		 * The meta object literal for the '<em><b>Source Allocation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PART__SOURCE_ALLOCATION = eINSTANCE.getDeploymentPart_SourceAllocation();

		/**
		 * The meta object literal for the '<em><b>Target Allocation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PART__TARGET_ALLOCATION = eINSTANCE.getDeploymentPart_TargetAllocation();

		/**
		 * The meta object literal for the '<em><b>Parent Part</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PART__PARENT_PART = eINSTANCE.getDeploymentPart_ParentPart();

		/**
		 * The meta object literal for the '<em><b>Child Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PART__CHILD_PART = eINSTANCE.getDeploymentPart_ChildPart();

		/**
		 * The meta object literal for the '<em><b>Deployment</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PART__DEPLOYMENT = eINSTANCE.getDeploymentPart_Deployment();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT_PART__ID = eINSTANCE.getDeploymentPart_Id();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ce.deployment.impl.AllocationImpl <em>Allocation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ce.deployment.impl.AllocationImpl
		 * @see com.zeligsoft.ce.deployment.impl.DeploymentPackageImpl#getAllocation()
		 * @generated
		 */
		EClass ALLOCATION = eINSTANCE.getAllocation();

		/**
		 * The meta object literal for the '<em><b>Target Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION__TARGET_PART = eINSTANCE.getAllocation_TargetPart();

		/**
		 * The meta object literal for the '<em><b>Deployment</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION__DEPLOYMENT = eINSTANCE.getAllocation_Deployment();

		/**
		 * The meta object literal for the '<em><b>Source Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION__SOURCE_PART = eINSTANCE.getAllocation_SourcePart();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALLOCATION__ID = eINSTANCE.getAllocation_Id();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ce.deployment.impl.DeploymentComponentPartImpl <em>Component Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ce.deployment.impl.DeploymentComponentPartImpl
		 * @see com.zeligsoft.ce.deployment.impl.DeploymentPackageImpl#getDeploymentComponentPart()
		 * @generated
		 */
		EClass DEPLOYMENT_COMPONENT_PART = eINSTANCE.getDeploymentComponentPart();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ce.deployment.impl.DeploymentConnectorPartImpl <em>Connector Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ce.deployment.impl.DeploymentConnectorPartImpl
		 * @see com.zeligsoft.ce.deployment.impl.DeploymentPackageImpl#getDeploymentConnectorPart()
		 * @generated
		 */
		EClass DEPLOYMENT_CONNECTOR_PART = eINSTANCE.getDeploymentConnectorPart();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ce.deployment.impl.DeploymentPortPartImpl <em>Port Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ce.deployment.impl.DeploymentPortPartImpl
		 * @see com.zeligsoft.ce.deployment.impl.DeploymentPackageImpl#getDeploymentPortPart()
		 * @generated
		 */
		EClass DEPLOYMENT_PORT_PART = eINSTANCE.getDeploymentPortPart();

	}

} //DeploymentPackage
