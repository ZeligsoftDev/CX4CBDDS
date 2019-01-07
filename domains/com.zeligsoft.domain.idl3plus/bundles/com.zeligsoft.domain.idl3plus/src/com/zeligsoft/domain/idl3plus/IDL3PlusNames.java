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

package com.zeligsoft.domain.idl3plus;

/**
 * Constants for the ZDL model IDL3Plus
 * @generated
 *
 */
public final class IDL3PlusNames {

	private IDL3PlusNames() {
		super();
	}

	/**
	 * Fully qualified name for the ZDL DomainConcept: ConnectorAssembly. 
	 * @generated
	 */
	public static final String CONNECTOR_ASSEMBLY = "IDL3Plus::Connectors::ConnectorAssembly";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: ConnectorDef. 
	 * @generated
	 */
	public static final String CONNECTOR_DEF = "IDL3Plus::Connectors::ConnectorDef";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: ConnectorDef::general. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CONNECTOR_DEF__GENERAL = "general";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: ConnectorDef::ownedAttribute. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CONNECTOR_DEF__OWNED_ATTRIBUTE = "ownedAttribute";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: ConnectorDefaultValueBinding. 
	 * @generated
	 */
	public static final String CONNECTOR_DEFAULT_VALUE_BINDING = "IDL3Plus::Connectors::ConnectorDefaultValueBinding";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: ConnectorDefaultValueBinding::connectorInstance. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CONNECTOR_DEFAULT_VALUE_BINDING__CONNECTOR_INSTANCE = "connectorInstance";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: ConnectorDefaultValueBinding::definition. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CONNECTOR_DEFAULT_VALUE_BINDING__DEFINITION = "definition";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: ConnectorFragment. 
	 * @generated
	 */
	public static final String CONNECTOR_FRAGMENT = "IDL3Plus::Connectors::ConnectorFragment";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: ConnectorImplementation. 
	 * @generated
	 */
	public static final String CONNECTOR_IMPLEMENTATION = "IDL3Plus::Connectors::ConnectorImplementation";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: DataSpace. 
	 * @generated
	 */
	public static final String DATA_SPACE = "IDL3Plus::Connectors::DataSpace";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: DataSpace::connectorType. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String DATA_SPACE__CONNECTOR_TYPE = "connectorType";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: ExtendedPortType. 
	 * @generated
	 */
	public static final String EXTENDED_PORT_TYPE = "IDL3Plus::IDL3Plus::ExtendedPortType";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: ExtendedPortType::ownedAttribute. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String EXTENDED_PORT_TYPE__OWNED_ATTRIBUTE = "ownedAttribute";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: FragmentAssembly. 
	 * @generated
	 */
	public static final String FRAGMENT_ASSEMBLY = "IDL3Plus::Connectors::FragmentAssembly";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: FragmentImplementation. 
	 * @generated
	 */
	public static final String FRAGMENT_IMPLEMENTATION = "IDL3Plus::Connectors::FragmentImplementation";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: FragmentPart. 
	 * @generated
	 */
	public static final String FRAGMENT_PART = "IDL3Plus::Connectors::FragmentPart";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: IDL3PlusModel. 
	 * @generated
	 */
	public static final String IDL3_PLUS_MODEL = "IDL3Plus::IDL3Plus::IDL3PlusModel";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: ModuleBinding. 
	 * @generated
	 */
	public static final String MODULE_BINDING = "IDL3Plus::Generics::ModuleBinding";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: ModuleBinding::boundElement. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String MODULE_BINDING__BOUND_ELEMENT = "boundElement";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: ModuleBinding::parameterBinding. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String MODULE_BINDING__PARAMETER_BINDING = "parameterBinding";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: ModuleBinding::template. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String MODULE_BINDING__TEMPLATE = "template";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: ModuleInstantiation. 
	 * @generated
	 */
	public static final String MODULE_INSTANTIATION = "IDL3Plus::Generics::ModuleInstantiation";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: ModuleInstantiation::moduleBinding. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String MODULE_INSTANTIATION__MODULE_BINDING = "moduleBinding";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: ParameterBinding. 
	 * @generated
	 */
	public static final String PARAMETER_BINDING = "IDL3Plus::Generics::ParameterBinding";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: ParameterBinding::type. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String PARAMETER_BINDING__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: ParameterBinding::typeParameter. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String PARAMETER_BINDING__TYPE_PARAMETER = "typeParameter";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: PerPortConnectorTypeDeploymentPart. 
	 * @generated
	 */
	public static final String PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART = "IDL3Plus::Deployment::PerPortConnectorTypeDeploymentPart";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: TemplateModule. 
	 * @generated
	 */
	public static final String TEMPLATE_MODULE = "IDL3Plus::Generics::TemplateModule";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: TemplateModule::signature. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String TEMPLATE_MODULE__SIGNATURE = "signature";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: TemplateModuleAlias. 
	 * @generated
	 */
	public static final String TEMPLATE_MODULE_ALIAS = "IDL3Plus::Generics::TemplateModuleAlias";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: TemplateParameterType. 
	 * @generated
	 */
	public static final String TEMPLATE_PARAMETER_TYPE = "IDL3Plus::Generics::TemplateParameterType";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: TemplateSignature. 
	 * @generated
	 */
	public static final String TEMPLATE_SIGNATURE = "IDL3Plus::Generics::TemplateSignature";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: TemplateSignature::typeParameter. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String TEMPLATE_SIGNATURE__TYPE_PARAMETER = "typeParameter";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: TypeParameter. 
	 * @generated
	 */
	public static final String TYPE_PARAMETER = "IDL3Plus::Generics::TypeParameter";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: TypeParameter::constraint. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String TYPE_PARAMETER__CONSTRAINT = "constraint";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: TypedConnector. 
	 * @generated
	 */
	public static final String TYPED_CONNECTOR = "IDL3Plus::Connectors::TypedConnector";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: TypedConnector::connectorType. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String TYPED_CONNECTOR__CONNECTOR_TYPE = "connectorType";//$NON-NLS-1$ 

	/**
	 * ZDL DomainEnum: TypeConstraint. 
	 * @generated
	 */
	public static final String TYPE_CONSTRAINT = "IDL3Plus::Generics::TypeConstraint";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: TypeConstraint::array. 
	 * @generated
	 */
	public static final String TYPE_CONSTRAINT__ARRAY = "array";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: TypeConstraint::enum. 
	 * @generated
	 */
	public static final String TYPE_CONSTRAINT__ENUM = "enum";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: TypeConstraint::eventtype. 
	 * @generated
	 */
	public static final String TYPE_CONSTRAINT__EVENTTYPE = "eventtype";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: TypeConstraint::interface. 
	 * @generated
	 */
	public static final String TYPE_CONSTRAINT__INTERFACE = "interface";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: TypeConstraint::sequence. 
	 * @generated
	 */
	public static final String TYPE_CONSTRAINT__SEQUENCE = "sequence";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: TypeConstraint::struct. 
	 * @generated
	 */
	public static final String TYPE_CONSTRAINT__STRUCT = "struct";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: TypeConstraint::typename. 
	 * @generated
	 */
	public static final String TYPE_CONSTRAINT__TYPENAME = "typename";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: TypeConstraint::union. 
	 * @generated
	 */
	public static final String TYPE_CONSTRAINT__UNION = "union";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: TypeConstraint::valuetype. 
	 * @generated
	 */
	public static final String TYPE_CONSTRAINT__VALUETYPE = "valuetype";//$NON-NLS-1$

}
