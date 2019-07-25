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

package com.zeligsoft.domain.omg.ccm;

/**
 * Constants for the ZDL model CCM
 * @generated
 *
 */
public final class CCMNames {

	private CCMNames() {
		super();
	}

	/**
	 * Fully qualified name for the ZDL DomainConcept: AssemblyImplementation. 
	 * @generated
	 */
	public static final String ASSEMBLY_IMPLEMENTATION = "CCM::CCM_Implementation::AssemblyImplementation";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: Bridge. 
	 * @generated
	 */
	public static final String BRIDGE = "CCM::CCM_Target::Bridge";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Bridge::resource. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String BRIDGE__RESOURCE = "resource";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: BridgeInstance. 
	 * @generated
	 */
	public static final String BRIDGE_INSTANCE = "CCM::CCM_Target::BridgeInstance";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: BridgeInstance::label. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String BRIDGE_INSTANCE__LABEL = "label";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: BridgeInstance::type. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String BRIDGE_INSTANCE__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: CCMComponent. 
	 * @generated
	 */
	public static final String CCMCOMPONENT = "CCM::CCM_Component::CCMComponent";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: CCMComponent::generals. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CCMCOMPONENT__GENERALS = "generals";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: CCMComponent::ownedAttribute. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CCMCOMPONENT__OWNED_ATTRIBUTE = "ownedAttribute";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: CCMComponent::ownedProperty. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CCMCOMPONENT__OWNED_PROPERTY = "ownedProperty";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: CCMConnector. 
	 * @generated
	 */
	public static final String CCMCONNECTOR = "CCM::CCM_Implementation::CCMConnector";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CCMModel. 
	 * @generated
	 */
	public static final String CCMMODEL = "CCM::CCM_Core::CCMModel";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CCMPart. 
	 * @generated
	 */
	public static final String CCMPART = "CCM::CCM_Implementation::CCMPart";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: ContainerProcess. 
	 * @generated
	 */
	public static final String CONTAINER_PROCESS = "CCM::CCM_Deployment::ContainerProcess";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: ContainerProcess::property. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CONTAINER_PROCESS__PROPERTY = "property";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: DeploymentPlan. 
	 * @generated
	 */
	public static final String DEPLOYMENT_PLAN = "CCM::CCM_Deployment::DeploymentPlan";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: DeploymentPlan::id. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String DEPLOYMENT_PLAN__ID = "id";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: Domain. 
	 * @generated
	 */
	public static final String DOMAIN = "CCM::CCM_Target::Domain";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: Domain::UUID. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String DOMAIN___UUID = "UUID";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: Domain::bridge. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String DOMAIN__BRIDGE = "bridge";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: Domain::connections. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String DOMAIN__CONNECTIONS = "connections";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: Domain::infoProperty. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String DOMAIN__INFO_PROPERTY = "infoProperty";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: Domain::interconnect. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String DOMAIN__INTERCONNECT = "interconnect";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: Domain::label. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String DOMAIN__LABEL = "label";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: Domain::node. 
	 * Lower: 1 Upper: * 
	 * @generated
	 */
	public static final String DOMAIN__NODE = "node";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: Domain::sharedResource. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String DOMAIN__SHARED_RESOURCE = "sharedResource";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: Event. 
	 * @generated
	 */
	public static final String EVENT = "CCM::CCM_Component::Event";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: Event::isAbstract. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String EVENT__IS_ABSTRACT = "isAbstract";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: Event::isCustom. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String EVENT__IS_CUSTOM = "isCustom";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: Event::isTruncatable. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String EVENT__IS_TRUNCATABLE = "isTruncatable";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: Event::member. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String EVENT__MEMBER = "member";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: Event::ownedAttribute. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String EVENT__OWNED_ATTRIBUTE = "ownedAttribute";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: EventPort. 
	 * @generated
	 */
	public static final String EVENT_PORT = "CCM::CCM_Component::EventPort";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: EventPort::consumesEvent. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String EVENT_PORT__CONSUMES_EVENT = "consumesEvent";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: EventPort::publishesEvent. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String EVENT_PORT__PUBLISHES_EVENT = "publishesEvent";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: EventPort::type. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String EVENT_PORT__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: FactoryOperation. 
	 * @generated
	 */
	public static final String FACTORY_OPERATION = "CCM::CCM_Component::FactoryOperation";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: FinderOperation. 
	 * @generated
	 */
	public static final String FINDER_OPERATION = "CCM::CCM_Component::FinderOperation";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: Home. 
	 * @generated
	 */
	public static final String HOME = "CCM::CCM_Component::Home";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Home::export. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String HOME__EXPORT = "export";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: Home::manages. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String HOME__MANAGES = "manages";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: Home::nestedClassifier. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String HOME__NESTED_CLASSIFIER = "nestedClassifier";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: Home::operation. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String HOME__OPERATION = "operation";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: Home::ownedAttribute. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String HOME__OWNED_ATTRIBUTE = "ownedAttribute";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: Home::property. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String HOME__PROPERTY = "property";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: HomeImplementation. 
	 * @generated
	 */
	public static final String HOME_IMPLEMENTATION = "CCM::CCM_Implementation::HomeImplementation";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: HomeInstance. 
	 * @generated
	 */
	public static final String HOME_INSTANCE = "CCM::CCM_Implementation::HomeInstance";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: HomeInstance::definition. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String HOME_INSTANCE__DEFINITION = "definition";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: HomeOperation. 
	 * @generated
	 */
	public static final String HOME_OPERATION = "CCM::CCM_Component::HomeOperation";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: HomeOperation::exceptionDef. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String HOME_OPERATION__EXCEPTION_DEF = "exceptionDef";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: HomeOperation::ownedParameter. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String HOME_OPERATION__OWNED_PARAMETER = "ownedParameter";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: HomeOperation::owner. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String HOME_OPERATION__OWNER = "owner";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: IDL3File. 
	 * @generated
	 */
	public static final String IDL3_FILE = "CCM::CCM_Artifacts::IDL3File";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: IDL3File::contents. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String IDL3_FILE__CONTENTS = "contents";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: IDL3File::location. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String IDL3_FILE__LOCATION = "location";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: IDL3FileImport. 
	 * @generated
	 */
	public static final String IDL3_FILE_IMPORT = "CCM::CCM_Artifacts::IDL3FileImport";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: Interconnect. 
	 * @generated
	 */
	public static final String INTERCONNECT = "CCM::CCM_Target::Interconnect";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Interconnect::resource. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String INTERCONNECT__RESOURCE = "resource";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: InterconnectInstance. 
	 * @generated
	 */
	public static final String INTERCONNECT_INSTANCE = "CCM::CCM_Target::InterconnectInstance";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: InterconnectInstance::label. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String INTERCONNECT_INSTANCE__LABEL = "label";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: InterconnectInstance::type. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String INTERCONNECT_INSTANCE__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: InterfacePort. 
	 * @generated
	 */
	public static final String INTERFACE_PORT = "CCM::CCM_Component::InterfacePort";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: InterfacePort::connectorType. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String INTERFACE_PORT__CONNECTOR_TYPE = "connectorType";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: InterfacePort::hasCSL. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String INTERFACE_PORT__HAS_CSL = "hasCSL";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: InterfacePort::isAsynchronous. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String INTERFACE_PORT__IS_ASYNCHRONOUS = "isAsynchronous";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: Manages. 
	 * @generated
	 */
	public static final String MANAGES = "CCM::CCM_Component::Manages";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Manages::component. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String MANAGES__COMPONENT = "component";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: Manages::home. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String MANAGES__HOME = "home";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: ManagesEnd. 
	 * @generated
	 */
	public static final String MANAGES_END = "CCM::CCM_Component::ManagesEnd";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: ManagesImpl. 
	 * @generated
	 */
	public static final String MANAGES_IMPL = "CCM::CCM_Implementation::ManagesImpl";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: ManagesImpl::component. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String MANAGES_IMPL__COMPONENT = "component";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: ManagesImpl::home. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String MANAGES_IMPL__HOME = "home";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: ManagesImplEnd. 
	 * @generated
	 */
	public static final String MANAGES_IMPL_END = "CCM::CCM_Implementation::ManagesImplEnd";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: MonolithicImplementation. 
	 * @generated
	 */
	public static final String MONOLITHIC_IMPLEMENTATION = "CCM::CCM_Implementation::MonolithicImplementation";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: MonolithicImplementation::category. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String MONOLITHIC_IMPLEMENTATION__CATEGORY = "category";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: MonolithicImplementation::name. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String MONOLITHIC_IMPLEMENTATION__NAME = "name";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: Node. 
	 * @generated
	 */
	public static final String NODE = "CCM::CCM_Target::Node";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Node::resource. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String NODE__RESOURCE = "resource";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: NodeInstance. 
	 * @generated
	 */
	public static final String NODE_INSTANCE = "CCM::CCM_Target::NodeInstance";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: NodeInstance::label. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String NODE_INSTANCE__LABEL = "label";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: NodeInstance::type. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String NODE_INSTANCE__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: Property. 
	 * @generated
	 */
	public static final String PROPERTY = "CCM::CCM_Target::Property";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Property::type. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String PROPERTY__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: Property::value. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String PROPERTY__VALUE = "value";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: Requirement. 
	 * @generated
	 */
	public static final String REQUIREMENT = "CCM::CCM_Target::Requirement";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Requirement::property. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String REQUIREMENT__PROPERTY = "property";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: Requirement::resourceType. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String REQUIREMENT__RESOURCE_TYPE = "resourceType";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: RequirementSatisfier. 
	 * @generated
	 */
	public static final String REQUIREMENT_SATISFIER = "CCM::CCM_Target::RequirementSatisfier";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: RequirementSatisfier::property. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String REQUIREMENT_SATISFIER__PROPERTY = "property";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: RequirementSatisfier::resourceType. 
	 * Lower: 1 Upper: * 
	 * @generated
	 */
	public static final String REQUIREMENT_SATISFIER__RESOURCE_TYPE = "resourceType";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: Resource. 
	 * @generated
	 */
	public static final String RESOURCE = "CCM::CCM_Target::Resource";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: ResourceProperty. 
	 * @generated
	 */
	public static final String RESOURCE_PROPERTY = "CCM::CCM_Target::ResourceProperty";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: ResourceProperty::type. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String RESOURCE_PROPERTY__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: SatisfierProperty. 
	 * @generated
	 */
	public static final String SATISFIER_PROPERTY = "CCM::CCM_Target::SatisfierProperty";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: SatisfierProperty::dynamic. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String SATISFIER_PROPERTY__DYNAMIC = "dynamic";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: SatisfierProperty::kind. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String SATISFIER_PROPERTY__KIND = "kind";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: SatisfierProperty::type. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String SATISFIER_PROPERTY__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: SatisfierProperty::value. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String SATISFIER_PROPERTY__VALUE = "value";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: SharedResource. 
	 * @generated
	 */
	public static final String SHARED_RESOURCE = "CCM::CCM_Target::SharedResource";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: StateMember. 
	 * @generated
	 */
	public static final String STATE_MEMBER = "CCM::CCM_Component::StateMember";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: TargetAssemblyConnector. 
	 * @generated
	 */
	public static final String TARGET_ASSEMBLY_CONNECTOR = "CCM::CCM_Target::TargetAssemblyConnector";//$NON-NLS-1$

	/**
	 * ZDL DomainEnum: ComponentCategory. 
	 * @generated
	 */
	public static final String COMPONENT_CATEGORY = "CCM::CCM_Implementation::ComponentCategory";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: ComponentCategory::SERVICE. 
	 * @generated
	 */
	public static final String COMPONENT_CATEGORY___SERVICE = "SERVICE";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: ComponentCategory::SESSION. 
	 * @generated
	 */
	public static final String COMPONENT_CATEGORY___SESSION = "SESSION";//$NON-NLS-1$

	/**
	 * ZDL DomainEnum: SatisfierPropertyKind. 
	 * @generated
	 */
	public static final String SATISFIER_PROPERTY_KIND = "CCM::CCM_Target::SatisfierPropertyKind";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: SatisfierPropertyKind::Attribute. 
	 * @generated
	 */
	public static final String SATISFIER_PROPERTY_KIND___ATTRIBUTE = "Attribute";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: SatisfierPropertyKind::Capacity. 
	 * @generated
	 */
	public static final String SATISFIER_PROPERTY_KIND___CAPACITY = "Capacity";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: SatisfierPropertyKind::Maximum. 
	 * @generated
	 */
	public static final String SATISFIER_PROPERTY_KIND___MAXIMUM = "Maximum";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: SatisfierPropertyKind::Minimum. 
	 * @generated
	 */
	public static final String SATISFIER_PROPERTY_KIND___MINIMUM = "Minimum";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: SatisfierPropertyKind::Quantity. 
	 * @generated
	 */
	public static final String SATISFIER_PROPERTY_KIND___QUANTITY = "Quantity";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: SatisfierPropertyKind::Selection. 
	 * @generated
	 */
	public static final String SATISFIER_PROPERTY_KIND___SELECTION = "Selection";//$NON-NLS-1$

}
