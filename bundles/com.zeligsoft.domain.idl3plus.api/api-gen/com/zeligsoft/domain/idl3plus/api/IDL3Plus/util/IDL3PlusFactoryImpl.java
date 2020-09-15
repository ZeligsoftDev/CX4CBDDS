package com.zeligsoft.domain.idl3plus.api.IDL3Plus.util;

import java.util.Map;

import com.google.common.collect.Maps;

import com.zeligsoft.base.zdl.staticapi.util.AbstractBaseZDLFactory;

public class IDL3PlusFactoryImpl extends AbstractBaseZDLFactory {
	protected java.util.Map<String, Class<?>> registry = Maps.newHashMap();

	public IDL3PlusFactoryImpl() {
		registry.put("IDL3Plus::IDL3Plus::IDL3PlusModel",
				com.zeligsoft.domain.idl3plus.api.IDL3Plus.impl.IDL3PlusModelZImpl.class);
		registry.put("IDL3Plus::IDL3Plus::ExtendedPortType",
				com.zeligsoft.domain.idl3plus.api.IDL3Plus.impl.ExtendedPortTypeZImpl.class);
		registry.put("IDL3Plus::Connectors::ConnectorDef",
				com.zeligsoft.domain.idl3plus.api.Connectors.impl.ConnectorDefZImpl.class);
		registry.put("IDL3Plus::Connectors::ConnectorFragment",
				com.zeligsoft.domain.idl3plus.api.Connectors.impl.ConnectorFragmentZImpl.class);
		registry.put("IDL3Plus::Connectors::FragmentImplementation",
				com.zeligsoft.domain.idl3plus.api.Connectors.impl.FragmentImplementationZImpl.class);
		registry.put("IDL3Plus::Connectors::FragmentAssembly",
				com.zeligsoft.domain.idl3plus.api.Connectors.impl.FragmentAssemblyZImpl.class);
		registry.put("IDL3Plus::Connectors::ConnectorImplementation",
				com.zeligsoft.domain.idl3plus.api.Connectors.impl.ConnectorImplementationZImpl.class);
		registry.put("IDL3Plus::Connectors::ConnectorAssembly",
				com.zeligsoft.domain.idl3plus.api.Connectors.impl.ConnectorAssemblyZImpl.class);
		registry.put("IDL3Plus::Connectors::FragmentPart",
				com.zeligsoft.domain.idl3plus.api.Connectors.impl.FragmentPartZImpl.class);
		registry.put("IDL3Plus::Connectors::TypedConnector",
				com.zeligsoft.domain.idl3plus.api.Connectors.impl.TypedConnectorZImpl.class);
		registry.put("IDL3Plus::Connectors::DataSpace",
				com.zeligsoft.domain.idl3plus.api.Connectors.impl.DataSpaceZImpl.class);
		registry.put("IDL3Plus::Connectors::ConnectorDefaultValueBinding",
				com.zeligsoft.domain.idl3plus.api.Connectors.impl.ConnectorDefaultValueBindingZImpl.class);
		registry.put("CCM::CCM_Core::CCMModel",
				com.zeligsoft.domain.omg.ccm.api.CCM_Core.impl.CCMModelImplementation.class);
		registry.put("CCM::CCM_Component::EventPort",
				com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl.EventPortImplementation.class);
		registry.put("CCM::CCM_Component::CCMComponent",
				com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl.CCMComponentImplementation.class);
		registry.put("CCM::CCM_Component::Event",
				com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl.EventImplementation.class);
		registry.put("CCM::CCM_Component::Home",
				com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl.HomeImplementation.class);
		registry.put("CCM::CCM_Component::Manages",
				com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl.ManagesImplementation.class);
		registry.put("CCM::CCM_Component::StateMember",
				com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl.StateMemberImplementation.class);
		registry.put("CCM::CCM_Component::InterfacePort",
				com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl.InterfacePortImplementation.class);
		registry.put("CCM::CCM_Component::FinderOperation",
				com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl.FinderOperationImplementation.class);
		registry.put("CCM::CCM_Component::FactoryOperation",
				com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl.FactoryOperationImplementation.class);
		registry.put("CCM::CCM_Component::HomeOperation",
				com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl.HomeOperationImplementation.class);
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
		registry.put("ZMLMM::ZML_Core::Parameter",
				com.zeligsoft.domain.zml.api.ZML_Core.impl.ParameterImplementation.class);
		registry.put("ZMLMM::ZML_Core::Model", com.zeligsoft.domain.zml.api.ZML_Core.impl.ModelImplementation.class);
		registry.put("ZMLMM::ZML_Core::HideableElement",
				com.zeligsoft.domain.zml.api.ZML_Core.impl.HideableElementImplementation.class);
		registry.put("IDL3Plus::Generics::TypeParameter",
				com.zeligsoft.domain.idl3plus.api.Generics.impl.TypeParameterZImpl.class);
		registry.put("IDL3Plus::Generics::TemplateModule",
				com.zeligsoft.domain.idl3plus.api.Generics.impl.TemplateModuleZImpl.class);
		registry.put("IDL3Plus::Generics::ModuleInstantiation",
				com.zeligsoft.domain.idl3plus.api.Generics.impl.ModuleInstantiationZImpl.class);
		registry.put("IDL3Plus::Generics::ParameterBinding",
				com.zeligsoft.domain.idl3plus.api.Generics.impl.ParameterBindingZImpl.class);
		registry.put("IDL3Plus::Generics::TemplateModuleAlias",
				com.zeligsoft.domain.idl3plus.api.Generics.impl.TemplateModuleAliasZImpl.class);
		registry.put("IDL3Plus::Generics::ModuleBinding",
				com.zeligsoft.domain.idl3plus.api.Generics.impl.ModuleBindingZImpl.class);
		registry.put("IDL3Plus::Generics::TemplateSignature",
				com.zeligsoft.domain.idl3plus.api.Generics.impl.TemplateSignatureZImpl.class);
		registry.put("IDL3Plus::Generics::TemplateParameterType",
				com.zeligsoft.domain.idl3plus.api.Generics.impl.TemplateParameterTypeZImpl.class);
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
		registry.put("CCM::CCM_Deployment::DeploymentPlan",
				com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.impl.DeploymentPlanImplementation.class);
		registry.put("CCM::CCM_Deployment::ContainerProcess",
				com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.impl.ContainerProcessImplementation.class);
		registry.put("CCM::CCM_Implementation::AssemblyImplementation",
				com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.impl.AssemblyImplementationImplementation.class);
		registry.put("CCM::CCM_Implementation::HomeImplementation",
				com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.impl.HomeImplementationImplementation.class);
		registry.put("CCM::CCM_Implementation::ManagesImpl",
				com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.impl.ManagesImplImplementation.class);
		registry.put("CCM::CCM_Implementation::MonolithicImplementation",
				com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.impl.MonolithicImplementationImplementation.class);
		registry.put("CCM::CCM_Implementation::CCMPart",
				com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.impl.CCMPartImplementation.class);
		registry.put("CCM::CCM_Implementation::CCMConnector",
				com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.impl.CCMConnectorImplementation.class);
		registry.put("CCM::CCM_Implementation::HomeInstance",
				com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.impl.HomeInstanceImplementation.class);
		registry.put("CCM::CCM_Target::Domain",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.DomainImplementation.class);
		registry.put("CCM::CCM_Target::Node",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.NodeImplementation.class);
		registry.put("CCM::CCM_Target::NodeInstance",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.NodeInstanceImplementation.class);
		registry.put("CCM::CCM_Target::Interconnect",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.InterconnectImplementation.class);
		registry.put("CCM::CCM_Target::InterconnectInstance",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.InterconnectInstanceImplementation.class);
		registry.put("CCM::CCM_Target::Bridge",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.BridgeImplementation.class);
		registry.put("CCM::CCM_Target::BridgeInstance",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.BridgeInstanceImplementation.class);
		registry.put("CCM::CCM_Target::Resource",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.ResourceImplementation.class);
		registry.put("CCM::CCM_Target::ResourceProperty",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.ResourcePropertyImplementation.class);
		registry.put("CCM::CCM_Target::SharedResource",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.SharedResourceImplementation.class);
		registry.put("CCM::CCM_Target::RequirementSatisfier",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.RequirementSatisfierImplementation.class);
		registry.put("CCM::CCM_Target::SatisfierProperty",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.SatisfierPropertyImplementation.class);
		registry.put("CCM::CCM_Target::Requirement",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.RequirementImplementation.class);
		registry.put("CCM::CCM_Target::TargetAssemblyConnector",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.TargetAssemblyConnectorImplementation.class);
		registry.put("CCM::CCM_Target::Property",
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.PropertyImplementation.class);
	}

	@Override
	protected Map<String, Class<?>> getRegistry() {
		return registry;
	}
}
