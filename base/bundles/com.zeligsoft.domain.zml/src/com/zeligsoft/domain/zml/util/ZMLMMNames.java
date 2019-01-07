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

package com.zeligsoft.domain.zml.util;

/**
 * Constants for the ZDL model ZMLMM
 * @generated
 *
 */
public final class ZMLMMNames {

	private ZMLMMNames() {
		super();
	}

	/**
	 * Fully qualified name for the ZDL DomainConcept: Allocation. 
	 * @generated
	 */
	public static final String ALLOCATION = "ZMLMM::ZML_Deployments::Allocation";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Allocation::deployed. 
	 * Lower: 1 Upper: * 
	 * @generated
	 */
	public static final String ALLOCATION__DEPLOYED = "deployed";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: Allocation::deployedOn. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String ALLOCATION__DEPLOYED_ON = "deployedOn";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: AssemblyConnector. 
	 * @generated
	 */
	public static final String ASSEMBLY_CONNECTOR = "ZMLMM::ZML_Component::AssemblyConnector";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: AssemblyConnector::end. 
	 * Multiplicity: 2  
	 * @generated
	 */
	public static final String ASSEMBLY_CONNECTOR__END = "end";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: AssemblyConnector::portEnd. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String ASSEMBLY_CONNECTOR__PORT_END = "portEnd";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: BuildConfiguration. 
	 * @generated
	 */
	public static final String BUILD_CONFIGURATION = "ZMLMM::ZML_Configurations::BuildConfiguration";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: ComponentDeploymentPart. 
	 * @generated
	 */
	public static final String COMPONENT_DEPLOYMENT_PART = "ZMLMM::ZML_Deployments::ComponentDeploymentPart";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: ComponentDeploymentPart::implementationConfiguration. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String COMPONENT_DEPLOYMENT_PART__IMPLEMENTATION_CONFIGURATION = "implementationConfiguration";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: ComponentDeploymentPart::selectedImplementation. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String COMPONENT_DEPLOYMENT_PART__SELECTED_IMPLEMENTATION = "selectedImplementation";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: ComponentImplementation. 
	 * @generated
	 */
	public static final String COMPONENT_IMPLEMENTATION = "ZMLMM::ZML_Component::ComponentImplementation";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: ComponentImplementation::implementation. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String COMPONENT_IMPLEMENTATION__IMPLEMENTATION = "implementation";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: ComponentImplementation::structuralRealization. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String COMPONENT_IMPLEMENTATION__STRUCTURAL_REALIZATION = "structuralRealization";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: ComponentInterface. 
	 * @generated
	 */
	public static final String COMPONENT_INTERFACE = "ZMLMM::ZML_Component::ComponentInterface";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: ComponentInterface::ownedPort. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String COMPONENT_INTERFACE__OWNED_PORT = "ownedPort";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: Configuration. 
	 * @generated
	 */
	public static final String CONFIGURATION = "ZMLMM::ZML_Configurations::Configuration";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: ConfigurationSlot. 
	 * @generated
	 */
	public static final String CONFIGURATION_SLOT = "ZMLMM::ZML_Configurations::ConfigurationSlot";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: ConfigurationSlot::slotKind. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CONFIGURATION_SLOT__SLOT_KIND = "slotKind";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: ConjugatedPort. 
	 * @generated
	 */
	public static final String CONJUGATED_PORT = "ZMLMM::ZML_Component::ConjugatedPort";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: ConjugatedPort::isConjugated. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CONJUGATED_PORT__IS_CONJUGATED = "isConjugated";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: ConnectorEnd. 
	 * @generated
	 */
	public static final String CONNECTOR_END = "ZMLMM::ZML_Component::ConnectorEnd";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: ConnectorEnd::part. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String CONNECTOR_END__PART = "part";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: ConnectorEnd::partWithPort. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String CONNECTOR_END__PART_WITH_PORT = "partWithPort";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: ConnectorEnd::port. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String CONNECTOR_END__PORT = "port";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: DeployableElement. 
	 * @generated
	 */
	public static final String DEPLOYABLE_ELEMENT = "ZMLMM::ZML_Deployments::DeployableElement";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: Deployment. 
	 * @generated
	 */
	public static final String DEPLOYMENT = "ZMLMM::ZML_Deployments::Deployment";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Deployment::allocation. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String DEPLOYMENT__ALLOCATION = "allocation";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: Deployment::part. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String DEPLOYMENT__PART = "part";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: DeploymentPart. 
	 * @generated
	 */
	public static final String DEPLOYMENT_PART = "ZMLMM::ZML_Deployments::DeploymentPart";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: DeploymentPart::configuration. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String DEPLOYMENT_PART__CONFIGURATION = "configuration";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: DeploymentPart::modelElement. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String DEPLOYMENT_PART__MODEL_ELEMENT = "modelElement";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: DeploymentPart::nestedPart. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String DEPLOYMENT_PART__NESTED_PART = "nestedPart";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: DeploymentPart::specification. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String DEPLOYMENT_PART__SPECIFICATION = "specification";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: DeploymentSpecification. 
	 * @generated
	 */
	public static final String DEPLOYMENT_SPECIFICATION = "ZMLMM::ZML_Deployments::DeploymentSpecification";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: DeploymentTarget. 
	 * @generated
	 */
	public static final String DEPLOYMENT_TARGET = "ZMLMM::ZML_Deployments::DeploymentTarget";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: FlowPort. 
	 * @generated
	 */
	public static final String FLOW_PORT = "ZMLMM::ZML_Component::FlowPort";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: HideableElement. 
	 * @generated
	 */
	public static final String HIDEABLE_ELEMENT = "ZMLMM::ZML_Core::HideableElement";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: HwBus. 
	 * @generated
	 */
	public static final String HW_BUS = "ZMLMM::ZML_HwPlatform::HwBus";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: HwCard. 
	 * @generated
	 */
	public static final String HW_CARD = "ZMLMM::ZML_HwPlatform::HwCard";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: HwCommunicationEndPoint. 
	 * @generated
	 */
	public static final String HW_COMMUNICATION_END_POINT = "ZMLMM::ZML_HwPlatform::HwCommunicationEndPoint";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: HwCommunicationMedium. 
	 * @generated
	 */
	public static final String HW_COMMUNICATION_MEDIUM = "ZMLMM::ZML_HwPlatform::HwCommunicationMedium";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: HwComponent. 
	 * @generated
	 */
	public static final String HW_COMPONENT = "ZMLMM::ZML_HwPlatform::HwComponent";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: HwComponent::connector. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String HW_COMPONENT__CONNECTOR = "connector";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: HwComponent::part. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String HW_COMPONENT__PART = "part";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: HwComponent::port. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String HW_COMPONENT__PORT = "port";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: HwConnector. 
	 * @generated
	 */
	public static final String HW_CONNECTOR = "ZMLMM::ZML_HwPlatform::HwConnector";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: HwConnector::container. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String HW_CONNECTOR__CONTAINER = "container";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: HwConnector::end. 
	 * Lower: 2 Upper: * 
	 * @generated
	 */
	public static final String HW_CONNECTOR__END = "end";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: HwCore. 
	 * @generated
	 */
	public static final String HW_CORE = "ZMLMM::ZML_HwPlatform::HwCore";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: HwPart. 
	 * @generated
	 */
	public static final String HW_PART = "ZMLMM::ZML_HwPlatform::HwPart";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: HwPart::definition. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String HW_PART__DEFINITION = "definition";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: HwPort. 
	 * @generated
	 */
	public static final String HW_PORT = "ZMLMM::ZML_HwPlatform::HwPort";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: HwPort::component. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String HW_PORT__COMPONENT = "component";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: HwProcessor. 
	 * @generated
	 */
	public static final String HW_PROCESSOR = "ZMLMM::ZML_HwPlatform::HwProcessor";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: Implementation. 
	 * @generated
	 */
	public static final String IMPLEMENTATION = "ZMLMM::ZML_Component::Implementation";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Implementation::worker. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String IMPLEMENTATION__WORKER = "worker";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: Interface. 
	 * @generated
	 */
	public static final String INTERFACE = "ZMLMM::ZML_Component::Interface";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Interface::operation. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String INTERFACE__OPERATION = "operation";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: InterfaceRealization. 
	 * @generated
	 */
	public static final String INTERFACE_REALIZATION = "ZMLMM::ZML_Component::InterfaceRealization";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: InterfaceRealization::target. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String INTERFACE_REALIZATION__TARGET = "target";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: MessagePort. 
	 * @generated
	 */
	public static final String MESSAGE_PORT = "ZMLMM::ZML_Component::MessagePort";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: MessagePort::providedInterface. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String MESSAGE_PORT__PROVIDED_INTERFACE = "providedInterface";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: MessagePort::requiredInterface. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String MESSAGE_PORT__REQUIRED_INTERFACE = "requiredInterface";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: MessagePort::type. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String MESSAGE_PORT__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: Model. 
	 * @generated
	 */
	public static final String MODEL = "ZMLMM::ZML_Core::Model";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: NamedElement. 
	 * @generated
	 */
	public static final String NAMED_ELEMENT = "ZMLMM::ZML_Core::NamedElement";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: NamedElement::name. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String NAMED_ELEMENT__NAME = "name";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: NamedElement::qualifiedName. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String NAMED_ELEMENT__QUALIFIED_NAME = "qualifiedName";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: Namespace. 
	 * @generated
	 */
	public static final String NAMESPACE = "ZMLMM::ZML_Core::Namespace";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Namespace::member. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String NAMESPACE__MEMBER = "member";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: Operation. 
	 * @generated
	 */
	public static final String OPERATION = "ZMLMM::ZML_Component::Operation";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: Parameter. 
	 * @generated
	 */
	public static final String PARAMETER = "ZMLMM::ZML_Core::Parameter";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: Part. 
	 * @generated
	 */
	public static final String PART = "ZMLMM::ZML_Component::Part";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Part::definition. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String PART__DEFINITION = "definition";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: Port. 
	 * @generated
	 */
	public static final String PORT = "ZMLMM::ZML_Component::Port";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: Port::isExternal. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String PORT__IS_EXTERNAL = "isExternal";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: Port::porttype. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String PORT__PORTTYPE = "porttype";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: Port::wiring. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String PORT__WIRING = "wiring";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: PortType. 
	 * @generated
	 */
	public static final String PORT_TYPE = "ZMLMM::ZML_Component::PortType";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: PortType::inverse. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String PORT_TYPE__INVERSE = "inverse";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: PortType::providedInterfaces. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String PORT_TYPE__PROVIDED_INTERFACES = "providedInterfaces";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: PortTypeable. 
	 * @generated
	 */
	public static final String PORT_TYPEABLE = "ZMLMM::ZML_Component::PortTypeable";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: StructuralRealization. 
	 * @generated
	 */
	public static final String STRUCTURAL_REALIZATION = "ZMLMM::ZML_Component::StructuralRealization";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: StructuralRealization::connector. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String STRUCTURAL_REALIZATION__CONNECTOR = "connector";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: StructuralRealization::interface. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String STRUCTURAL_REALIZATION__INTERFACE = "interface";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: StructuralRealization::ownedPort. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String STRUCTURAL_REALIZATION__OWNED_PORT = "ownedPort";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: StructuralRealization::part. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String STRUCTURAL_REALIZATION__PART = "part";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: StructuralRealization::worker. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String STRUCTURAL_REALIZATION__WORKER = "worker";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: StructuralRealization::workerImpl. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String STRUCTURAL_REALIZATION__WORKER_IMPL = "workerImpl";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: SwBus. 
	 * @generated
	 */
	public static final String SW_BUS = "ZMLMM::ZML_SwPlatform::SwBus";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: SwCommunicationEndPoint. 
	 * @generated
	 */
	public static final String SW_COMMUNICATION_END_POINT = "ZMLMM::ZML_SwPlatform::SwCommunicationEndPoint";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: SwCommunicationMedium. 
	 * @generated
	 */
	public static final String SW_COMMUNICATION_MEDIUM = "ZMLMM::ZML_SwPlatform::SwCommunicationMedium";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: SwComponent. 
	 * @generated
	 */
	public static final String SW_COMPONENT = "ZMLMM::ZML_SwPlatform::SwComponent";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: SwComponent::part. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String SW_COMPONENT__PART = "part";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: SwComponent::port. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String SW_COMPONENT__PORT = "port";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: SwConnector. 
	 * @generated
	 */
	public static final String SW_CONNECTOR = "ZMLMM::ZML_SwPlatform::SwConnector";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: SwConnector::end. 
	 * Lower: 2 Upper: * 
	 * @generated
	 */
	public static final String SW_CONNECTOR__END = "end";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: SwOperatingSystem. 
	 * @generated
	 */
	public static final String SW_OPERATING_SYSTEM = "ZMLMM::ZML_SwPlatform::SwOperatingSystem";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: SwPart. 
	 * @generated
	 */
	public static final String SW_PART = "ZMLMM::ZML_SwPlatform::SwPart";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: SwPart::container. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String SW_PART__CONTAINER = "container";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: SwPart::definition. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String SW_PART__DEFINITION = "definition";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: SwPlatform. 
	 * @generated
	 */
	public static final String SW_PLATFORM = "ZMLMM::ZML_SwPlatform::SwPlatform";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: SwPort. 
	 * @generated
	 */
	public static final String SW_PORT = "ZMLMM::ZML_SwPlatform::SwPort";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: SwPort::container. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String SW_PORT__CONTAINER = "container";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: SwSchedulableResource. 
	 * @generated
	 */
	public static final String SW_SCHEDULABLE_RESOURCE = "ZMLMM::ZML_SwPlatform::SwSchedulableResource";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: Type. 
	 * @generated
	 */
	public static final String TYPE = "ZMLMM::ZML_Core::Type";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: TypedElement. 
	 * @generated
	 */
	public static final String TYPED_ELEMENT = "ZMLMM::ZML_Core::TypedElement";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: TypedElement::lowerBound. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String TYPED_ELEMENT__LOWER_BOUND = "lowerBound";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: TypedElement::type. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String TYPED_ELEMENT__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: TypedElement::upperBound. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String TYPED_ELEMENT__UPPER_BOUND = "upperBound";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: WorkerFunction. 
	 * @generated
	 */
	public static final String WORKER_FUNCTION = "ZMLMM::ZML_Component::WorkerFunction";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: WorkerFunction::body. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String WORKER_FUNCTION__BODY = "body";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: WorkerFunction::delegate. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String WORKER_FUNCTION__DELEGATE = "delegate";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: WorkerFunction::parameter. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String WORKER_FUNCTION__PARAMETER = "parameter";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: WorkerFunction::portOperation. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String WORKER_FUNCTION__PORT_OPERATION = "portOperation";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: WorkerFunction::receivingPort. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String WORKER_FUNCTION__RECEIVING_PORT = "receivingPort";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: WorkerFunction::uuid. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String WORKER_FUNCTION__UUID = "uuid";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: WorkerFunctionIdentifiable. 
	 * @generated
	 */
	public static final String WORKER_FUNCTION_IDENTIFIABLE = "ZMLMM::ZML_Component::WorkerFunctionIdentifiable";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: WorkerFunctionIdentifiable::uuid. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String WORKER_FUNCTION_IDENTIFIABLE__UUID = "uuid";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: WorkerFunctionImpl. 
	 * @generated
	 */
	public static final String WORKER_FUNCTION_IMPL = "ZMLMM::ZML_Component::WorkerFunctionImpl";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: WorkerFunctionImpl::body. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String WORKER_FUNCTION_IMPL__BODY = "body";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: WorkerFunctionImpl::language. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String WORKER_FUNCTION_IMPL__LANGUAGE = "language";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: WorkerFunctionImpl::workerFunction. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String WORKER_FUNCTION_IMPL__WORKER_FUNCTION = "workerFunction";//$NON-NLS-1$ 

	/**
	 * ZDL DomainEnum: ConfigurationSlotKind. 
	 * @generated
	 */
	public static final String CONFIGURATION_SLOT_KIND = "ZMLMM::ZML_Configurations::ConfigurationSlotKind";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: ConfigurationSlotKind::additive. 
	 * @generated
	 */
	public static final String CONFIGURATION_SLOT_KIND__ADDITIVE = "additive";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: ConfigurationSlotKind::override. 
	 * @generated
	 */
	public static final String CONFIGURATION_SLOT_KIND__OVERRIDE = "override";//$NON-NLS-1$

	/**
	 * ZDL DomainEnum: WiringKind. 
	 * @generated
	 */
	public static final String WIRING_KIND = "ZMLMM::ZML_Component::WiringKind";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: WiringKind::connector. 
	 * @generated
	 */
	public static final String WIRING_KIND__CONNECTOR = "connector";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: WiringKind::sap. 
	 * @generated
	 */
	public static final String WIRING_KIND__SAP = "sap";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: WiringKind::spp. 
	 * @generated
	 */
	public static final String WIRING_KIND__SPP = "spp";//$NON-NLS-1$

	
	/**
	 * Fully qualified name for the Concept: ModelConfiguration. 
	 * @generated NOT
	 */
	public static final String MODEL_CONFIGURATION = "ZMLMM::ZML C Build::ModelConfiguration";//$NON-NLS-1$
	
	/**
	 * Attribute: ModelConfiguration::generatedProjectName. 
	 * Lower: 1 Upper: * 
	 * @generated NOT
	 */
	public static final String MODEL_CONFIGURATION__GENERATED_PROJECT_NAME = "generatedProjectName";//$NON-NLS-1$

}
