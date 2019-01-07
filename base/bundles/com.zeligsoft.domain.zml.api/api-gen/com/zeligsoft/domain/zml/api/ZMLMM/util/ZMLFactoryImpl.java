package com.zeligsoft.domain.zml.api.ZMLMM.util;

import java.util.Map;

import com.google.common.collect.Maps;

import com.zeligsoft.base.zdl.staticapi.util.AbstractBaseZDLFactory;

public class ZMLFactoryImpl extends AbstractBaseZDLFactory {
	protected java.util.Map<String, Class<?>> registry 
		= Maps.newHashMap();
	
	public ZMLFactoryImpl() {
	registry.put("ZMLMM::ZML_SwPlatform::SwPart", 
		com.zeligsoft.domain.zml.api.ZML_SwPlatform.impl.SwPartImplementation.class);
	registry.put("ZMLMM::ZML_SwPlatform::SwPort", 
		com.zeligsoft.domain.zml.api.ZML_SwPlatform.impl.SwPortImplementation.class);
	registry.put("ZMLMM::ZML_SwPlatform::SwConnector", 
		com.zeligsoft.domain.zml.api.ZML_SwPlatform.impl.SwConnectorImplementation.class);
	registry.put("ZMLMM::ZML_SwPlatform::SwBus", 
		com.zeligsoft.domain.zml.api.ZML_SwPlatform.impl.SwBusImplementation.class);
	registry.put("ZMLMM::ZML_SwPlatform::SwSchedulableResource", 
		com.zeligsoft.domain.zml.api.ZML_SwPlatform.impl.SwSchedulableResourceImplementation.class);
	registry.put("ZMLMM::ZML_SwPlatform::SwOperatingSystem", 
		com.zeligsoft.domain.zml.api.ZML_SwPlatform.impl.SwOperatingSystemImplementation.class);
	registry.put("ZMLMM::ZML_SwPlatform::SwPlatform", 
		com.zeligsoft.domain.zml.api.ZML_SwPlatform.impl.SwPlatformImplementation.class);
	registry.put("ZMLMM::ZML_HwPlatform::HwProcessor", 
		com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl.HwProcessorImplementation.class);
	registry.put("ZMLMM::ZML_HwPlatform::HwCore", 
		com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl.HwCoreImplementation.class);
	registry.put("ZMLMM::ZML_HwPlatform::HwPort", 
		com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl.HwPortImplementation.class);
	registry.put("ZMLMM::ZML_HwPlatform::HwBus", 
		com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl.HwBusImplementation.class);
	registry.put("ZMLMM::ZML_HwPlatform::HwConnector", 
		com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl.HwConnectorImplementation.class);
	registry.put("ZMLMM::ZML_HwPlatform::HwPart", 
		com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl.HwPartImplementation.class);
	registry.put("ZMLMM::ZML_HwPlatform::HwCard", 
		com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl.HwCardImplementation.class);
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
	registry.put("ZMLMM::ZML_Core::Model", 
		com.zeligsoft.domain.zml.api.ZML_Core.impl.ModelImplementation.class);
	registry.put("ZMLMM::ZML_Core::HideableElement", 
		com.zeligsoft.domain.zml.api.ZML_Core.impl.HideableElementImplementation.class);
	registry.put("ZMLMM::ZML_Configurations::BuildConfiguration", 
		com.zeligsoft.domain.zml.api.ZML_Configurations.impl.BuildConfigurationImplementation.class);
	registry.put("ZMLMM::ZML_Configurations::ConfigurationSlot", 
		com.zeligsoft.domain.zml.api.ZML_Configurations.impl.ConfigurationSlotImplementation.class);
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
	}
	
	@Override
	protected Map<String, Class<?>> getRegistry() {
	    return registry;
	}
}
