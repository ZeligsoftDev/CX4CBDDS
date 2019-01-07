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

package com.zeligsoft.domain.omg.dds;

/**
 * Constants for the ZDL model DDS
 * @generated
 *
 */
public class DDSNames {

	private DDSNames() {
		super();
	}

	/**
	 * Fully qualified name for the ZDL DomainConcept: Classifier. 
	 * @generated
	 */
	public static String CLASSIFIER = "DDS::Core::Classifier";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Classifier::property. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static String CLASSIFIER__PROPERTY = "property";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: ComponentPart. 
	 * @generated
	 */
	public static String COMPONENT_PART = "DDS::DCPS::ComponentPart";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: ComponentPart::type. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String COMPONENT_PART__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: ConnectorEnd. 
	 * @generated
	 */
	public static String CONNECTOR_END = "DDS::DCPS::ConnectorEnd";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: DDSComponent. 
	 * @generated
	 */
	public static String DDSCOMPONENT = "DDS::DCPS::DDSComponent";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: DDSComponent::participants. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static String DDSCOMPONENT__PARTICIPANTS = "participants";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: DDSComponent::topicConnector. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static String DDSCOMPONENT__TOPIC_CONNECTOR = "topicConnector";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: DDSEntity. 
	 * @generated
	 */
	public static String DDSENTITY = "DDS::Domain::DDSEntity";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: DDSEntity::qosPolicy. 
	 * Lower: 1 Upper: * 
	 * @generated
	 */
	public static String DDSENTITY__QOS_POLICY = "qosPolicy";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: DataReader. 
	 * @generated
	 */
	public static String DATA_READER = "DDS::DCPS::DataReader";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: DataReaderWriter. 
	 * @generated
	 */
	public static String DATA_READER_WRITER = "DDS::DCPS::DataReaderWriter";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: DataWriter. 
	 * @generated
	 */
	public static String DATA_WRITER = "DDS::DCPS::DataWriter";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: DataWriter::topic. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String DATA_WRITER__TOPIC = "topic";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: Domain. 
	 * @generated
	 */
	public static String DOMAIN = "DDS::DCPS::Domain";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Domain::connector. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static String DOMAIN__CONNECTOR = "connector";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: Domain::domainTopic. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static String DOMAIN__DOMAIN_TOPIC = "domainTopic";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: Domain::participant. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static String DOMAIN__PARTICIPANT = "participant";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: DomainParticipant. 
	 * @generated
	 */
	public static String DOMAIN_PARTICIPANT = "DDS::DCPS::DomainParticipant";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: DomainParticipant::type. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String DOMAIN_PARTICIPANT__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: DomainTopic. 
	 * @generated
	 */
	public static String DOMAIN_TOPIC = "DDS::DCPS::DomainTopic";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: Duration. 
	 * @generated
	 */
	public static String DURATION = "DDS::QOS::Duration";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: Duration::nanosecond. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String DURATION__NANOSECOND = "nanosecond";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: Duration::second. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String DURATION__SECOND = "second";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: NamedEntity. 
	 * @generated
	 */
	public static String NAMED_ENTITY = "DDS::Core::NamedEntity";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: NamedEntity::name. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String NAMED_ENTITY__NAME = "name";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: NamedEntity::ownedEntity. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static String NAMED_ENTITY__OWNED_ENTITY = "ownedEntity";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: ParticipantEnd. 
	 * @generated
	 */
	public static String PARTICIPANT_END = "DDS::DCPS::ParticipantEnd";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: ParticipantEnd::participant. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static String PARTICIPANT_END__PARTICIPANT = "participant";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: ParticipantEnd::readerWriter. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static String PARTICIPANT_END__READER_WRITER = "readerWriter";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: Publisher. 
	 * @generated
	 */
	public static String PUBLISHER = "DDS::DCPS::Publisher";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Publisher::writers. 
	 * Lower: 1 Upper: * 
	 * @generated
	 */
	public static String PUBLISHER__WRITERS = "writers";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: PublisherSubscriber. 
	 * @generated
	 */
	public static String PUBLISHER_SUBSCRIBER = "DDS::DCPS::PublisherSubscriber";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: PublisherSubscriber::data. 
	 * Lower: 1 Upper: * 
	 * @generated
	 */
	public static String PUBLISHER_SUBSCRIBER__DATA = "data";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: QoSProperty. 
	 * @generated
	 */
	public static String QO_SPROPERTY = "DDS::Domain::QoSProperty";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: Specification. 
	 * @generated
	 */
	public static String SPECIFICATION = "DDS::Core::Specification";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: Subscriber. 
	 * @generated
	 */
	public static String SUBSCRIBER = "DDS::DCPS::Subscriber";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: Subscriber::readers. 
	 * Lower: 1 Upper: * 
	 * @generated
	 */
	public static String SUBSCRIBER__READERS = "readers";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: Topic. 
	 * @generated
	 */
	public static String TOPIC = "DDS::Topics::Topic";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: Topic::expression. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String TOPIC__EXPRESSION = "expression";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: Topic::kind. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String TOPIC__KIND = "kind";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: Topic::qosProperty. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static String TOPIC__QOS_PROPERTY = "qosProperty";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: Topic::type. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String TOPIC__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: TopicConnector. 
	 * @generated
	 */
	public static String TOPIC_CONNECTOR = "DDS::DCPS::TopicConnector";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: TopicConnector::end. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static String TOPIC_CONNECTOR__END = "end";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: TopicEnd. 
	 * @generated
	 */
	public static String TOPIC_END = "DDS::DCPS::TopicEnd";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: TopicEnd::topic. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static String TOPIC_END__TOPIC = "topic";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: TopicField. 
	 * @generated
	 */
	public static String TOPIC_FIELD = "DDS::Topics::TopicField";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: TopicField::type. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String TOPIC_FIELD__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: TypedEntity. 
	 * @generated
	 */
	public static String TYPED_ENTITY = "DDS::Core::TypedEntity";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: TypedEntity::type. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static String TYPED_ENTITY__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: deadlineQosPolicy. 
	 * @generated
	 */
	public static String DEADLINEQOS_POLICY = "DDS::QOS::deadlineQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: deadlineQosPolicy::period. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String DEADLINEQOS_POLICY__PERIOD = "period";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: doQosPolicy. 
	 * @generated
	 */
	public static String DOQOS_POLICY = "DDS::QOS::doQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: doQosPolicy::kind. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String DOQOS_POLICY__KIND = "kind";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: dsQosPolicy. 
	 * @generated
	 */
	public static String DSQOS_POLICY = "DDS::QOS::dsQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: dsQosPolicy::history_depth. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String DSQOS_POLICY__HISTORY_DEPTH = "history_depth";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: dsQosPolicy::history_kind. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String DSQOS_POLICY__HISTORY_KIND = "history_kind";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: dsQosPolicy::max_instances. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String DSQOS_POLICY__MAX_INSTANCES = "max_instances";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: dsQosPolicy::max_samples. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String DSQOS_POLICY__MAX_SAMPLES = "max_samples";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: dsQosPolicy::max_samples_per_instance. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String DSQOS_POLICY__MAX_SAMPLES_PER_INSTANCE = "max_samples_per_instance";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: dsQosPolicy::service_cleanup_delay. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String DSQOS_POLICY__SERVICE_CLEANUP_DELAY = "service_cleanup_delay";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: durabilityQosPolicy. 
	 * @generated
	 */
	public static String DURABILITYQOS_POLICY = "DDS::QOS::durabilityQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: durabilityQosPolicy::kind. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String DURABILITYQOS_POLICY__KIND = "kind";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: efQosPolicy. 
	 * @generated
	 */
	public static String EFQOS_POLICY = "DDS::QOS::efQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: efQosPolicy::autoenable_created_entities. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String EFQOS_POLICY__AUTOENABLE_CREATED_ENTITIES = "autoenable_created_entities";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: gdQosPolicy. 
	 * @generated
	 */
	public static String GDQOS_POLICY = "DDS::QOS::gdQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: gdQosPolicy::value. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String GDQOS_POLICY__VALUE = "value";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: historyQosPolicy. 
	 * @generated
	 */
	public static String HISTORYQOS_POLICY = "DDS::QOS::historyQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: historyQosPolicy::depth. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String HISTORYQOS_POLICY__DEPTH = "depth";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: historyQosPolicy::kind. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String HISTORYQOS_POLICY__KIND = "kind";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: lbQosPolicy. 
	 * @generated
	 */
	public static String LBQOS_POLICY = "DDS::QOS::lbQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: lbQosPolicy::duration. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String LBQOS_POLICY__DURATION = "duration";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: lifespanQosPolicy. 
	 * @generated
	 */
	public static String LIFESPANQOS_POLICY = "DDS::QOS::lifespanQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: lifespanQosPolicy::duration. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String LIFESPANQOS_POLICY__DURATION = "duration";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: livelinessQosPolicy. 
	 * @generated
	 */
	public static String LIVELINESSQOS_POLICY = "DDS::QOS::livelinessQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: livelinessQosPolicy::kind. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String LIVELINESSQOS_POLICY__KIND = "kind";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: livelinessQosPolicy::lease_duration. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String LIVELINESSQOS_POLICY__LEASE_DURATION = "lease_duration";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: osQosPolicy. 
	 * @generated
	 */
	public static String OSQOS_POLICY = "DDS::QOS::osQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: osQosPolicy::value. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String OSQOS_POLICY__VALUE = "value";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: ownershipQosPolicy. 
	 * @generated
	 */
	public static String OWNERSHIPQOS_POLICY = "DDS::QOS::ownershipQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: ownershipQosPolicy::kind. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String OWNERSHIPQOS_POLICY__KIND = "kind";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: partitionQosPolicy. 
	 * @generated
	 */
	public static String PARTITIONQOS_POLICY = "DDS::QOS::partitionQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: partitionQosPolicy::name. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String PARTITIONQOS_POLICY__NAME = "name";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: presentationQosPolicy. 
	 * @generated
	 */
	public static String PRESENTATIONQOS_POLICY = "DDS::QOS::presentationQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: presentationQosPolicy::access_scope. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String PRESENTATIONQOS_POLICY__ACCESS_SCOPE = "access_scope";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: presentationQosPolicy::coherent_access. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String PRESENTATIONQOS_POLICY__COHERENT_ACCESS = "coherent_access";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: presentationQosPolicy::ordered_access. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String PRESENTATIONQOS_POLICY__ORDERED_ACCESS = "ordered_access";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: qosPolicy. 
	 * @generated
	 */
	public static String QOSPOLICY = "DDS::QOS::qosPolicy";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: qosProperty. 
	 * @generated
	 */
	public static String QOSPROPERTY = "DDS::QOS::qosProperty";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: qosProperty::policy. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static String QOSPROPERTY__POLICY = "policy";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: rdlQosPolicy. 
	 * @generated
	 */
	public static String RDLQOS_POLICY = "DDS::QOS::rdlQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: rdlQosPolicy::autopurge_disposed_samples_delay. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String RDLQOS_POLICY__AUTOPURGE_DISPOSED_SAMPLES_DELAY = "autopurge_disposed_samples_delay";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: rdlQosPolicy::autopurge_nowriter_samples_delay. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String RDLQOS_POLICY__AUTOPURGE_NOWRITER_SAMPLES_DELAY = "autopurge_nowriter_samples_delay";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: reliabilityQosPolicy. 
	 * @generated
	 */
	public static String RELIABILITYQOS_POLICY = "DDS::QOS::reliabilityQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: reliabilityQosPolicy::kind. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String RELIABILITYQOS_POLICY__KIND = "kind";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: reliabilityQosPolicy::max_blocking_time. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String RELIABILITYQOS_POLICY__MAX_BLOCKING_TIME = "max_blocking_time";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: rlQosPolicy. 
	 * @generated
	 */
	public static String RLQOS_POLICY = "DDS::QOS::rlQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: rlQosPolicy::max_instances. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String RLQOS_POLICY__MAX_INSTANCES = "max_instances";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: rlQosPolicy::max_samples. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String RLQOS_POLICY__MAX_SAMPLES = "max_samples";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: rlQosPolicy::max_samples_per_instance. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String RLQOS_POLICY__MAX_SAMPLES_PER_INSTANCE = "max_samples_per_instance";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: tbfQosPolicy. 
	 * @generated
	 */
	public static String TBFQOS_POLICY = "DDS::QOS::tbfQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: tbfQosPolicy::minimum_separation. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String TBFQOS_POLICY__MINIMUM_SEPARATION = "minimum_separation";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: tdQosPolicy. 
	 * @generated
	 */
	public static String TDQOS_POLICY = "DDS::QOS::tdQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: tdQosPolicy::value. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String TDQOS_POLICY__VALUE = "value";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: tpQosPolicy. 
	 * @generated
	 */
	public static String TPQOS_POLICY = "DDS::QOS::tpQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: tpQosPolicy::value. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String TPQOS_POLICY__VALUE = "value";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: udQosPolicy. 
	 * @generated
	 */
	public static String UDQOS_POLICY = "DDS::QOS::udQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: udQosPolicy::value. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String UDQOS_POLICY__VALUE = "value";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: wdlQosPolicy. 
	 * @generated
	 */
	public static String WDLQOS_POLICY = "DDS::QOS::wdlQosPolicy";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: wdlQosPolicy::autodispose_unregistered_instances. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String WDLQOS_POLICY__AUTODISPOSE_UNREGISTERED_INSTANCES = "autodispose_unregistered_instances";//$NON-NLS-1$  

	/**
	 * ZDL DomainEnum: DestinationOrderQosPolicyKind. 
	 * @generated
	 */
	public static String DESTINATION_ORDER_QOS_POLICY_KIND = "DDS::QOS::DestinationOrderQosPolicyKind";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: DestinationOrderQosPolicyKind::BY_RECEPTION_TIMESTAMP. 
	 * @generated
	 */
	public static String DESTINATION_ORDER_QOS_POLICY_KIND___BY__RECEPTION__TIMESTAMP = "BY_RECEPTION_TIMESTAMP";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: DestinationOrderQosPolicyKind::BY_SOURCE_TIMESTAMP. 
	 * @generated
	 */
	public static String DESTINATION_ORDER_QOS_POLICY_KIND___BY__SOURCE__TIMESTAMP = "BY_SOURCE_TIMESTAMP";//$NON-NLS-1$

	/**
	 * ZDL DomainEnum: DurabilityQosPolicyKind. 
	 * @generated
	 */
	public static String DURABILITY_QOS_POLICY_KIND = "DDS::QOS::DurabilityQosPolicyKind";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: DurabilityQosPolicyKind::PERSISTENT. 
	 * @generated
	 */
	public static String DURABILITY_QOS_POLICY_KIND___PERSISTENT = "PERSISTENT";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: DurabilityQosPolicyKind::TRANSIENT. 
	 * @generated
	 */
	public static String DURABILITY_QOS_POLICY_KIND___TRANSIENT = "TRANSIENT";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: DurabilityQosPolicyKind::TRANSIENT_LOCAL. 
	 * @generated
	 */
	public static String DURABILITY_QOS_POLICY_KIND___TRANSIENT__LOCAL = "TRANSIENT_LOCAL";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: DurabilityQosPolicyKind::VOLATILE. 
	 * @generated
	 */
	public static String DURABILITY_QOS_POLICY_KIND___VOLATILE = "VOLATILE";//$NON-NLS-1$

	/**
	 * ZDL DomainEnum: HistoryQosPolicyKind. 
	 * @generated
	 */
	public static String HISTORY_QOS_POLICY_KIND = "DDS::QOS::HistoryQosPolicyKind";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: HistoryQosPolicyKind::KEEP_ALL. 
	 * @generated
	 */
	public static String HISTORY_QOS_POLICY_KIND___KEEP__ALL = "KEEP_ALL";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: HistoryQosPolicyKind::KEEP_LAST. 
	 * @generated
	 */
	public static String HISTORY_QOS_POLICY_KIND___KEEP__LAST = "KEEP_LAST";//$NON-NLS-1$

	/**
	 * ZDL DomainEnum: LivelinessQosPolicyKind. 
	 * @generated
	 */
	public static String LIVELINESS_QOS_POLICY_KIND = "DDS::QOS::LivelinessQosPolicyKind";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: LivelinessQosPolicyKind::AUTOMATIC. 
	 * @generated
	 */
	public static String LIVELINESS_QOS_POLICY_KIND___AUTOMATIC = "AUTOMATIC";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: LivelinessQosPolicyKind::MANUAL_BY_PARTICIPANT. 
	 * @generated
	 */
	public static String LIVELINESS_QOS_POLICY_KIND___MANUAL__BY__PARTICIPANT = "MANUAL_BY_PARTICIPANT";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: LivelinessQosPolicyKind::MANUAL_BY_TOPIC. 
	 * @generated
	 */
	public static String LIVELINESS_QOS_POLICY_KIND___MANUAL__BY__TOPIC = "MANUAL_BY_TOPIC";//$NON-NLS-1$

	/**
	 * ZDL DomainEnum: OwnershipQosPolicyKind. 
	 * @generated
	 */
	public static String OWNERSHIP_QOS_POLICY_KIND = "DDS::QOS::OwnershipQosPolicyKind";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: OwnershipQosPolicyKind::EXCLUSIVE. 
	 * @generated
	 */
	public static String OWNERSHIP_QOS_POLICY_KIND___EXCLUSIVE = "EXCLUSIVE";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: OwnershipQosPolicyKind::SHARED. 
	 * @generated
	 */
	public static String OWNERSHIP_QOS_POLICY_KIND___SHARED = "SHARED";//$NON-NLS-1$

	/**
	 * ZDL DomainEnum: PresentationQosPolicyAccessScopeKind. 
	 * @generated
	 */
	public static String PRESENTATION_QOS_POLICY_ACCESS_SCOPE_KIND = "DDS::QOS::PresentationQosPolicyAccessScopeKind";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: PresentationQosPolicyAccessScopeKind::GROUP. 
	 * @generated
	 */
	public static String PRESENTATION_QOS_POLICY_ACCESS_SCOPE_KIND___GROUP = "GROUP";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: PresentationQosPolicyAccessScopeKind::INSTANCE. 
	 * @generated
	 */
	public static String PRESENTATION_QOS_POLICY_ACCESS_SCOPE_KIND___INSTANCE = "INSTANCE";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: PresentationQosPolicyAccessScopeKind::TOPIC. 
	 * @generated
	 */
	public static String PRESENTATION_QOS_POLICY_ACCESS_SCOPE_KIND___TOPIC = "TOPIC";//$NON-NLS-1$

	/**
	 * ZDL DomainEnum: RealiabilityQosPolicyKind. 
	 * @generated
	 */
	public static String REALIABILITY_QOS_POLICY_KIND = "DDS::QOS::RealiabilityQosPolicyKind";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: RealiabilityQosPolicyKind::BEST_EFFORT. 
	 * @generated
	 */
	public static String REALIABILITY_QOS_POLICY_KIND___BEST__EFFORT = "BEST_EFFORT";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: RealiabilityQosPolicyKind::RELIABLE. 
	 * @generated
	 */
	public static String REALIABILITY_QOS_POLICY_KIND___RELIABLE = "RELIABLE";//$NON-NLS-1$

	/**
	 * ZDL DomainEnum: TopicKind. 
	 * @generated
	 */
	public static String TOPIC_KIND = "DDS::Topics::TopicKind";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: TopicKind::CONTENT_FILTERED. 
	 * @generated
	 */
	public static String TOPIC_KIND___CONTENT__FILTERED = "CONTENT_FILTERED";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: TopicKind::MULTI_TOPIC. 
	 * @generated
	 */
	public static String TOPIC_KIND___MULTI__TOPIC = "MULTI_TOPIC";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: TopicKind::STANDARD. 
	 * @generated
	 */
	public static String TOPIC_KIND___STANDARD = "STANDARD";//$NON-NLS-1$

}
