package com.zeligsoft.domain.omg.dds.api.DDS.util;

import java.util.Map;

import com.google.common.collect.Maps;

import com.zeligsoft.base.zdl.staticapi.util.AbstractBaseZDLFactory;

public class DDSFactoryImpl extends AbstractBaseZDLFactory {
	protected java.util.Map<String, Class<?>> registry = Maps.newHashMap();

	public DDSFactoryImpl() {
		registry.put("DDS::Topics::Topic", com.zeligsoft.domain.omg.dds.api.Topics.impl.TopicZImpl.class);
		registry.put("DDS::Topics::TopicField", com.zeligsoft.domain.omg.dds.api.Topics.impl.TopicFieldZImpl.class);
		registry.put("ZMLMM::ZML_Core::Parameter",
				com.zeligsoft.domain.zml.api.ZML_Core.impl.ParameterImplementation.class);
		registry.put("ZMLMM::ZML_Core::Model", com.zeligsoft.domain.zml.api.ZML_Core.impl.ModelImplementation.class);
		registry.put("ZMLMM::ZML_Core::HideableElement",
				com.zeligsoft.domain.zml.api.ZML_Core.impl.HideableElementImplementation.class);
		registry.put("CXDomain::IDL::CXWString",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXWStringImplementation.class);
		registry.put("CXDomain::IDL::CXAnonymousArray",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXAnonymousArrayImplementation.class);
		registry.put("CXDomain::IDL::CXAnonymousSequence",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXAnonymousSequenceImplementation.class);
		registry.put("CXDomain::IDL::CXArray", com.zeligsoft.domain.omg.corba.api.IDL.impl.CXArrayImplementation.class);
		registry.put("CXDomain::IDL::CXBoxedValue",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXBoxedValueImplementation.class);
		registry.put("CXDomain::IDL::CXCase", com.zeligsoft.domain.omg.corba.api.IDL.impl.CXCaseImplementation.class);
		registry.put("CXDomain::IDL::CXConstant",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXConstantImplementation.class);
		registry.put("CXDomain::IDL::CXConstants",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXConstantsImplementation.class);
		registry.put("CXDomain::IDL::CXDefault",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXDefaultImplementation.class);
		registry.put("CXDomain::IDL::CXEnum", com.zeligsoft.domain.omg.corba.api.IDL.impl.CXEnumImplementation.class);
		registry.put("CXDomain::IDL::CXException",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXExceptionImplementation.class);
		registry.put("CXDomain::IDL::CXInterface",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXInterfaceImplementation.class);
		registry.put("CXDomain::IDL::CXPrimitive",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXPrimitiveImplementation.class);
		registry.put("CXDomain::IDL::CXSequence",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXSequenceImplementation.class);
		registry.put("CXDomain::IDL::CXString",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXStringImplementation.class);
		registry.put("CXDomain::IDL::CXStruct",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXStructImplementation.class);
		registry.put("CXDomain::IDL::CXSupports",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXSupportsImplementation.class);
		registry.put("CXDomain::IDL::CXTypeDef",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXTypeDefImplementation.class);
		registry.put("CXDomain::IDL::CXUnion", com.zeligsoft.domain.omg.corba.api.IDL.impl.CXUnionImplementation.class);
		registry.put("CXDomain::IDL::CXUnionField",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXUnionFieldImplementation.class);
		registry.put("CXDomain::IDL::CXValue", com.zeligsoft.domain.omg.corba.api.IDL.impl.CXValueImplementation.class);
		registry.put("CXDomain::IDL::CXValueFactory",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXValueFactoryImplementation.class);
		registry.put("CXDomain::IDL::CXModule",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXModuleImplementation.class);
		registry.put("CXDomain::IDL::CXAttribute",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXAttributeImplementation.class);
		registry.put("CXDomain::IDL::CXOperation",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXOperationImplementation.class);
		registry.put("CXDomain::IDL::CXNamedElement",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXNamedElementImplementation.class);
		registry.put("CXDomain::IDL::CXField", com.zeligsoft.domain.omg.corba.api.IDL.impl.CXFieldImplementation.class);
		registry.put("CXDomain::IDL::CXParameter",
				com.zeligsoft.domain.omg.corba.api.IDL.impl.CXParameterImplementation.class);
		registry.put("CXDomain::IDL::Native", com.zeligsoft.domain.omg.corba.api.IDL.impl.NativeImplementation.class);
		registry.put("CXDomain::IDL::CXBound", com.zeligsoft.domain.omg.corba.api.IDL.impl.CXBoundImplementation.class);
		registry.put("ZMLMM::ZML_Component::ComponentInterface",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.ComponentInterfaceImplementation.class);
		registry.put("ZMLMM::ZML_Component::StructuralRealization",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.StructuralRealizationImplementation.class);
		registry.put("ZMLMM::ZML_Component::Implementation",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.ImplementationImplementation.class);
		registry.put("ZMLMM::ZML_Component::MessagePort",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.MessagePortImplementation.class);
		registry.put("ZMLMM::ZML_Component::AssemblyConnector",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.AssemblyConnectorImplementation.class);
		registry.put("ZMLMM::ZML_Component::WorkerFunction",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.WorkerFunctionImplementation.class);
		registry.put("ZMLMM::ZML_Component::PortType",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.PortTypeImplementation.class);
		registry.put("ZMLMM::ZML_Component::Operation",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.OperationImplementation.class);
		registry.put("ZMLMM::ZML_Component::ConnectorEnd",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.ConnectorEndImplementation.class);
		registry.put("ZMLMM::ZML_Component::ComponentImplementation",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.ComponentImplementationImplementation.class);
		registry.put("ZMLMM::ZML_Component::InterfaceRealization",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.InterfaceRealizationImplementation.class);
		registry.put("ZMLMM::ZML_Component::PortTypeable",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.PortTypeableImplementation.class);
		registry.put("ZMLMM::ZML_Component::WorkerFunctionImpl",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.WorkerFunctionImplImplementation.class);
		registry.put("ZMLMM::ZML_Component::ConjugatedPort",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.ConjugatedPortImplementation.class);
		registry.put("ZMLMM::ZML_Component::WorkerFunctionIdentifiable",
				com.zeligsoft.domain.zml.api.ZML_Component.impl.WorkerFunctionIdentifiableImplementation.class);
		registry.put("ZMLMM::ZML_Deployments::Allocation",
				com.zeligsoft.domain.zml.api.ZML_Deployments.impl.AllocationImplementation.class);
		registry.put("ZMLMM::ZML_Deployments::Deployment",
				com.zeligsoft.domain.zml.api.ZML_Deployments.impl.DeploymentImplementation.class);
		registry.put("ZMLMM::ZML_Deployments::DeploymentPart",
				com.zeligsoft.domain.zml.api.ZML_Deployments.impl.DeploymentPartImplementation.class);
		registry.put("ZMLMM::ZML_Deployments::ComponentDeploymentPart",
				com.zeligsoft.domain.zml.api.ZML_Deployments.impl.ComponentDeploymentPartImplementation.class);
		registry.put("ZMLMM::ZML_Deployments::DeploymentTarget",
				com.zeligsoft.domain.zml.api.ZML_Deployments.impl.DeploymentTargetImplementation.class);
		registry.put("ZMLMM::ZML_Deployments::DeployableElement",
				com.zeligsoft.domain.zml.api.ZML_Deployments.impl.DeployableElementImplementation.class);
		registry.put("ZMLMM::ZML_Configurations::BuildConfiguration",
				com.zeligsoft.domain.zml.api.ZML_Configurations.impl.BuildConfigurationImplementation.class);
		registry.put("ZMLMM::ZML_Configurations::ConfigurationSlot",
				com.zeligsoft.domain.zml.api.ZML_Configurations.impl.ConfigurationSlotImplementation.class);
		registry.put("DDS::QOS::historyQosPolicy",
				com.zeligsoft.domain.omg.dds.api.QOS.impl.historyQosPolicyZImpl.class);
		registry.put("DDS::QOS::lifespanQosPolicy",
				com.zeligsoft.domain.omg.dds.api.QOS.impl.lifespanQosPolicyZImpl.class);
		registry.put("DDS::QOS::ownershipQosPolicy",
				com.zeligsoft.domain.omg.dds.api.QOS.impl.ownershipQosPolicyZImpl.class);
		registry.put("DDS::QOS::osQosPolicy", com.zeligsoft.domain.omg.dds.api.QOS.impl.osQosPolicyZImpl.class);
		registry.put("DDS::QOS::wdlQosPolicy", com.zeligsoft.domain.omg.dds.api.QOS.impl.wdlQosPolicyZImpl.class);
		registry.put("DDS::QOS::rdlQosPolicy", com.zeligsoft.domain.omg.dds.api.QOS.impl.rdlQosPolicyZImpl.class);
		registry.put("DDS::QOS::udQosPolicy", com.zeligsoft.domain.omg.dds.api.QOS.impl.udQosPolicyZImpl.class);
		registry.put("DDS::QOS::tdQosPolicy", com.zeligsoft.domain.omg.dds.api.QOS.impl.tdQosPolicyZImpl.class);
		registry.put("DDS::QOS::tpQosPolicy", com.zeligsoft.domain.omg.dds.api.QOS.impl.tpQosPolicyZImpl.class);
		registry.put("DDS::QOS::deadlineQosPolicy",
				com.zeligsoft.domain.omg.dds.api.QOS.impl.deadlineQosPolicyZImpl.class);
		registry.put("DDS::QOS::lbQosPolicy", com.zeligsoft.domain.omg.dds.api.QOS.impl.lbQosPolicyZImpl.class);
		registry.put("DDS::QOS::tbfQosPolicy", com.zeligsoft.domain.omg.dds.api.QOS.impl.tbfQosPolicyZImpl.class);
		registry.put("DDS::QOS::gdQosPolicy", com.zeligsoft.domain.omg.dds.api.QOS.impl.gdQosPolicyZImpl.class);
		registry.put("DDS::QOS::efQosPolicy", com.zeligsoft.domain.omg.dds.api.QOS.impl.efQosPolicyZImpl.class);
		registry.put("DDS::QOS::rlQosPolicy", com.zeligsoft.domain.omg.dds.api.QOS.impl.rlQosPolicyZImpl.class);
		registry.put("DDS::QOS::presentationQosPolicy",
				com.zeligsoft.domain.omg.dds.api.QOS.impl.presentationQosPolicyZImpl.class);
		registry.put("DDS::QOS::partitionQosPolicy",
				com.zeligsoft.domain.omg.dds.api.QOS.impl.partitionQosPolicyZImpl.class);
		registry.put("DDS::QOS::reliabilityQosPolicy",
				com.zeligsoft.domain.omg.dds.api.QOS.impl.reliabilityQosPolicyZImpl.class);
		registry.put("DDS::QOS::dsQosPolicy", com.zeligsoft.domain.omg.dds.api.QOS.impl.dsQosPolicyZImpl.class);
		registry.put("DDS::QOS::livelinessQosPolicy",
				com.zeligsoft.domain.omg.dds.api.QOS.impl.livelinessQosPolicyZImpl.class);
		registry.put("DDS::QOS::durabilityQosPolicy",
				com.zeligsoft.domain.omg.dds.api.QOS.impl.durabilityQosPolicyZImpl.class);
		registry.put("DDS::QOS::doQosPolicy", com.zeligsoft.domain.omg.dds.api.QOS.impl.doQosPolicyZImpl.class);
		registry.put("DDS::QOS::qosProperty", com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPropertyZImpl.class);
		registry.put("DDS::QOS::Duration", com.zeligsoft.domain.omg.dds.api.QOS.impl.DurationZImpl.class);
		registry.put("DDS::Domain::QoSProperty", com.zeligsoft.domain.omg.dds.api.Domain.impl.QoSPropertyZImpl.class);
		registry.put("DDS::DCPS::Subscriber", com.zeligsoft.domain.omg.dds.api.DCPS.impl.SubscriberZImpl.class);
		registry.put("DDS::DCPS::Publisher", com.zeligsoft.domain.omg.dds.api.DCPS.impl.PublisherZImpl.class);
		registry.put("DDS::DCPS::DataWriter", com.zeligsoft.domain.omg.dds.api.DCPS.impl.DataWriterZImpl.class);
		registry.put("DDS::DCPS::DataReader", com.zeligsoft.domain.omg.dds.api.DCPS.impl.DataReaderZImpl.class);
		registry.put("DDS::DCPS::DataReaderWriter",
				com.zeligsoft.domain.omg.dds.api.DCPS.impl.DataReaderWriterZImpl.class);
		registry.put("DDS::DCPS::DDSComponent", com.zeligsoft.domain.omg.dds.api.DCPS.impl.DDSComponentZImpl.class);
		registry.put("DDS::DCPS::Domain", com.zeligsoft.domain.omg.dds.api.DCPS.impl.DomainZImpl.class);
		registry.put("DDS::DCPS::DomainParticipant",
				com.zeligsoft.domain.omg.dds.api.DCPS.impl.DomainParticipantZImpl.class);
		registry.put("DDS::DCPS::DomainTopic", com.zeligsoft.domain.omg.dds.api.DCPS.impl.DomainTopicZImpl.class);
		registry.put("DDS::DCPS::ComponentPart", com.zeligsoft.domain.omg.dds.api.DCPS.impl.ComponentPartZImpl.class);
		registry.put("DDS::DCPS::TopicConnector", com.zeligsoft.domain.omg.dds.api.DCPS.impl.TopicConnectorZImpl.class);
		registry.put("DDS::DCPS::ParticipantEnd", com.zeligsoft.domain.omg.dds.api.DCPS.impl.ParticipantEndZImpl.class);
		registry.put("DDS::DCPS::TopicEnd", com.zeligsoft.domain.omg.dds.api.DCPS.impl.TopicEndZImpl.class);
	}

	@Override
	protected Map<String, Class<?>> getRegistry() {
		return registry;
	}
}
