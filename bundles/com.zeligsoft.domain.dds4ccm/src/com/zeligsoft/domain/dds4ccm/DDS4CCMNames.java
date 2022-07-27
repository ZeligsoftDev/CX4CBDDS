
/**
 * Copyright (c) 2008 Zeligsoft Inc.
 * Copyright (c) 2011 Zeligsoft (2009) Ltd.
 *
 * All rights reserved. 
 *  
 * THIS PROGRAM IS THE UNPUBLISHED, PROPRIETARY PROPERTY OF ZELIGSOFT INC. AND
 * IS TO BE MAINTAINED IN STRICT CONFIDENCE.  UNAUTHORIZED REPRODUCTION, 
 * DISTRIBUTION OR DISCLOSURE OF THIS PROGRAM, OR ANY PROGRAM DERIVED FROM IT,
 * IS STRICTLY PROHIBITED.
 *
 */
 
package com.zeligsoft.domain.dds4ccm;

/**
 * Constants for the ZDL model DDS4CCM
 * @generated
 *
 */
public final class DDS4CCMNames {

	private DDS4CCMNames() {
		super();
	}

/**
 * Fully qualified name for the ZDL DomainConcept: ConnectorStatusListenerConnection. 
 * @generated
 */
 public static final String CONNECTOR_STATUS_LISTENER_CONNECTION = "DDS4CCM::DDS4CCM::ConnectorStatusListenerConnection";//$NON-NLS-1$
 

/**
 * Fully qualified name for the ZDL DomainConcept: DDS4CCMModel. 
 * @generated
 */
 public static final String DDS4_CCMMODEL = "DDS4CCM::DDS4CCM::DDS4CCMModel";//$NON-NLS-1$
 
/**
 * ZDL DomainAttribute: DDS4CCMModel::fixedFooter. 
 * Lower: 0 Upper: 1 
 * @generated
 */
 public static final String DDS4_CCMMODEL__FIXED_FOOTER = "fixedFooter";//$NON-NLS-1$  

/**
 * ZDL DomainAttribute: DDS4CCMModel::fixedHeader. 
 * Lower: 0 Upper: 1 
 * @generated
 */
 public static final String DDS4_CCMMODEL__FIXED_HEADER = "fixedHeader";//$NON-NLS-1$  

/**
 * ZDL DomainAttribute: DDS4CCMModel::locationPrefix. 
 * Lower: 0 Upper: 1 
 * @generated
 */
 public static final String DDS4_CCMMODEL__LOCATION_PREFIX = "locationPrefix";//$NON-NLS-1$  

/**
 * ZDL DomainAttribute: DDS4CCMModel::modelType. 
 * Multiplicity: 1  
 * @generated
 */
 public static final String DDS4_CCMMODEL__MODEL_TYPE = "modelType";//$NON-NLS-1$  


/**
 * Fully qualified name for the ZDL DomainConcept: DDSMessage. 
 * @generated
 */
 public static final String DDSMESSAGE = "DDS4CCM::DDSExtensions::DDSMessage";//$NON-NLS-1$
 
/**
 * ZDL DomainReference: DDSMessage::fields. 
 * Lower: 0 Upper: * 
 * @generated
 */
	 public static final String DDSMESSAGE__FIELDS = "fields";//$NON-NLS-1$ 


/**
 * Fully qualified name for the ZDL DomainConcept: DataReaderQoS. 
 * @generated
 */
 public static final String DATA_READER_QO_S = "DDS4CCM::QoSProfiles::DataReaderQoS";//$NON-NLS-1$
 

/**
 * Fully qualified name for the ZDL DomainConcept: DataReaderWriterQoS. 
 * @generated
 */
 public static final String DATA_READER_WRITER_QO_S = "DDS4CCM::QoSProfiles::DataReaderWriterQoS";//$NON-NLS-1$
 

/**
 * Fully qualified name for the ZDL DomainConcept: DataWriterQoS. 
 * @generated
 */
 public static final String DATA_WRITER_QO_S = "DDS4CCM::QoSProfiles::DataWriterQoS";//$NON-NLS-1$
 

/**
 * Fully qualified name for the ZDL DomainConcept: DomainDefinition. 
 * @generated
 */
 public static final String DOMAIN_DEFINITION = "DDS4CCM::DDS4CCM::DomainDefinition";//$NON-NLS-1$
 
/**
 * ZDL DomainReference: DomainDefinition::deployments. 
 * Lower: 0 Upper: * 
 * @generated
 */
	 public static final String DOMAIN_DEFINITION__DEPLOYMENTS = "deployments";//$NON-NLS-1$ 


/**
 * Fully qualified name for the ZDL DomainConcept: DomainDeployment. 
 * @generated
 */
 public static final String DOMAIN_DEPLOYMENT = "DDS4CCM::DDS4CCM::DomainDeployment";//$NON-NLS-1$
 
/**
 * ZDL DomainReference: DomainDeployment::parts. 
 * Lower: 0 Upper: * 
 * @generated
 */
	 public static final String DOMAIN_DEPLOYMENT__PARTS = "parts";//$NON-NLS-1$ 


/**
 * Fully qualified name for the ZDL DomainConcept: DomainDeploymentPart. 
 * @generated
 */
 public static final String DOMAIN_DEPLOYMENT_PART = "DDS4CCM::DDS4CCM::DomainDeploymentPart";//$NON-NLS-1$
 

/**
 * Fully qualified name for the ZDL DomainConcept: IDLFileDependency. 
 * @generated
 */
 public static final String IDLFILE_DEPENDENCY = "DDS4CCM::DDS4CCM::IDLFileDependency";//$NON-NLS-1$
 
/**
 * ZDL DomainReference: IDLFileDependency::element. 
 * Lower: 0 Upper: 1 
 * @generated
 */
	 public static final String IDLFILE_DEPENDENCY__ELEMENT = "element";//$NON-NLS-1$ 

/**
 * ZDL DomainReference: IDLFileDependency::file. 
 * Multiplicity: 1  
 * @generated
 */
	 public static final String IDLFILE_DEPENDENCY__FILE = "file";//$NON-NLS-1$ 


/**
 * Fully qualified name for the ZDL DomainConcept: IDLFileSpecification. 
 * @generated
 */
 public static final String IDLFILE_SPECIFICATION = "DDS4CCM::DDS4CCM::IDLFileSpecification";//$NON-NLS-1$
 
/**
 * ZDL DomainAttribute: IDLFileSpecification::filename. 
 * Multiplicity: 1  
 * @generated
 */
 public static final String IDLFILE_SPECIFICATION__FILENAME = "filename";//$NON-NLS-1$  


/**
 * Fully qualified name for the ZDL DomainConcept: IDLIncludeDependency. 
 * @generated
 */
 public static final String IDLINCLUDE_DEPENDENCY = "DDS4CCM::DDS4CCM::IDLIncludeDependency";//$NON-NLS-1$
 
/**
 * ZDL DomainReference: IDLIncludeDependency::includee. 
 * Multiplicity: 1  
 * @generated
 */
	 public static final String IDLINCLUDE_DEPENDENCY__INCLUDEE = "includee";//$NON-NLS-1$ 

/**
 * ZDL DomainReference: IDLIncludeDependency::includer. 
 * Multiplicity: 1  
 * @generated
 */
	 public static final String IDLINCLUDE_DEPENDENCY__INCLUDER = "includer";//$NON-NLS-1$ 


/**
 * Fully qualified name for the ZDL DomainConcept: MessageField. 
 * @generated
 */
 public static final String MESSAGE_FIELD = "DDS4CCM::DDSExtensions::MessageField";//$NON-NLS-1$
 
/**
 * ZDL DomainReference: MessageField::idlType. 
 * Multiplicity: 1  
 * @generated
 */
	 public static final String MESSAGE_FIELD__IDL_TYPE = "idlType";//$NON-NLS-1$ 

/**
 * ZDL DomainAttribute: MessageField::isKey. 
 * Multiplicity: 1  
 * @generated
 */
 public static final String MESSAGE_FIELD__IS_KEY = "isKey";//$NON-NLS-1$  


/**
 * Fully qualified name for the ZDL DomainConcept: ParticipantQoS. 
 * @generated
 */
 public static final String PARTICIPANT_QO_S = "DDS4CCM::QoSProfiles::ParticipantQoS";//$NON-NLS-1$
 

/**
 * Fully qualified name for the ZDL DomainConcept: PublisherQoS. 
 * @generated
 */
 public static final String PUBLISHER_QO_S = "DDS4CCM::QoSProfiles::PublisherQoS";//$NON-NLS-1$
 

/**
 * Fully qualified name for the ZDL DomainConcept: PublisherSubscriberQoS. 
 * @generated
 */
 public static final String PUBLISHER_SUBSCRIBER_QO_S = "DDS4CCM::QoSProfiles::PublisherSubscriberQoS";//$NON-NLS-1$
 

/**
 * Fully qualified name for the ZDL DomainConcept: QoSEntity. 
 * @generated
 */
 public static final String QO_SENTITY = "DDS4CCM::QoSProfiles::QoSEntity";//$NON-NLS-1$
 
/**
 * ZDL DomainReference: QoSEntity::type. 
 * Multiplicity: 1  
 * @generated
 */
	 public static final String QO_SENTITY__TYPE = "type";//$NON-NLS-1$ 


/**
 * Fully qualified name for the ZDL DomainConcept: QoSForEntity. 
 * @generated
 */
 public static final String QO_SFOR_ENTITY = "DDS4CCM::QoSProfiles::QoSForEntity";//$NON-NLS-1$
 
/**
 * ZDL DomainReference: QoSForEntity::qosProperty. 
 * Lower: 0 Upper: * 
 * @generated
 */
	 public static final String QO_SFOR_ENTITY__QOS_PROPERTY = "qosProperty";//$NON-NLS-1$ 


/**
 * Fully qualified name for the ZDL DomainConcept: QoSProfile. 
 * @generated
 */
 public static final String QO_SPROFILE = "DDS4CCM::QoSProfiles::QoSProfile";//$NON-NLS-1$
 
/**
 * ZDL DomainAttribute: QoSProfile::filename. 
 * Multiplicity: 1  
 * @generated
 */
 public static final String QO_SPROFILE__FILENAME = "filename";//$NON-NLS-1$  

/**
 * ZDL DomainReference: QoSProfile::qosEntity. 
 * Lower: 0 Upper: * 
 * @generated
 */
	 public static final String QO_SPROFILE__QOS_ENTITY = "qosEntity";//$NON-NLS-1$ 

/**
 * ZDL DomainReference: QoSProfile::qosForEntity. 
 * Lower: 0 Upper: * 
 * @generated
 */
	 public static final String QO_SPROFILE__QOS_FOR_ENTITY = "qosForEntity";//$NON-NLS-1$ 


/**
 * Fully qualified name for the ZDL DomainConcept: SubscriberQoS. 
 * @generated
 */
 public static final String SUBSCRIBER_QO_S = "DDS4CCM::QoSProfiles::SubscriberQoS";//$NON-NLS-1$
 

/**
 * Fully qualified name for the ZDL DomainConcept: TopicQoS. 
 * @generated
 */
 public static final String TOPIC_QO_S = "DDS4CCM::QoSProfiles::TopicQoS";//$NON-NLS-1$
 


/**
 * ZDL DomainEnum: ModelTypeEnum. 
 * @generated
 */
 public static final String MODEL_TYPE_ENUM = "DDS4CCM::DDS4CCM::ModelTypeEnum";//$NON-NLS-1$
 
/**
 * ZDL DomainEnumLiteral: ModelTypeEnum::ATCD. 
 * @generated
 */
 public static final String MODEL_TYPE_ENUM___ATCD = "ATCD";//$NON-NLS-1$

/**
 * ZDL DomainEnumLiteral: ModelTypeEnum::AXCIOMA. 
 * @generated
 */
 public static final String MODEL_TYPE_ENUM___AXCIOMA = "AXCIOMA";//$NON-NLS-1$


}
