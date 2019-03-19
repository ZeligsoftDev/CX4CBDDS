package com.zeligsoft.domain.zml.api.ZMLMM.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.uml2.uml.PackageableElement;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

import com.zeligsoft.base.zdl.staticapi.predicate.IsZDLConcept;
import com.zeligsoft.base.zdl.staticapi.functions.CreateZDLWrapper;

import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;
import com.zeligsoft.domain.zml.api.ZML_Component.StructuralRealization;
import com.zeligsoft.domain.zml.api.ZML_Component.Interface;
import com.zeligsoft.domain.zml.api.ZML_Component.PortType;
import com.zeligsoft.domain.zml.api.ZML_Component.ComponentImplementation;
import com.zeligsoft.domain.zml.api.ZML_Component.InterfaceRealization;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionImpl;
import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwComponent;
import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwProcessor;
import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwCore;
import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwBus;
import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwCard;
import com.zeligsoft.domain.zml.api.ZML_SwPlatform.SwComponent;
import com.zeligsoft.domain.zml.api.ZML_SwPlatform.SwBus;
import com.zeligsoft.domain.zml.api.ZML_SwPlatform.SwSchedulableResource;
import com.zeligsoft.domain.zml.api.ZML_SwPlatform.SwOperatingSystem;
import com.zeligsoft.domain.zml.api.ZML_SwPlatform.SwPlatform;
import com.zeligsoft.domain.zml.api.ZML_Configurations.Configuration;
import com.zeligsoft.domain.zml.api.ZML_Configurations.BuildConfiguration;
import com.zeligsoft.domain.zml.api.ZML_Deployments.Allocation;
import com.zeligsoft.domain.zml.api.ZML_Deployments.Deployment;
import com.zeligsoft.domain.zml.api.ZML_Deployments.DeploymentTarget;
import com.zeligsoft.domain.zml.api.ZML_Deployments.DeployableElement;
import com.zeligsoft.domain.zml.api.ZML_Deployments.DeploymentSpecification;
import com.zeligsoft.domain.zml.api.ZML_Core.Type;
import com.zeligsoft.domain.zml.api.ZML_Core.Model;

public class ZMLMMTypeSelectUtil {
	public List<ComponentInterface> selectComponentInterface(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Component::ComponentInterface"));
		final Collection<ComponentInterface> result = Collections2.transform(
				elements, CreateZDLWrapper.create(ComponentInterface.class));
		return new ImmutableList.Builder<ComponentInterface>().addAll(result)
				.build();

	}

	public List<StructuralRealization> selectStructuralRealization(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Component::StructuralRealization"));
		final Collection<StructuralRealization> result = Collections2
				.transform(elements,
						CreateZDLWrapper.create(StructuralRealization.class));
		return new ImmutableList.Builder<StructuralRealization>()
				.addAll(result).build();

	}

	public List<Interface> selectInterface(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Component::Interface"));
		final Collection<Interface> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Interface.class));
		return new ImmutableList.Builder<Interface>().addAll(result).build();

	}

	public List<PortType> selectPortType(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Component::PortType"));
		final Collection<PortType> result = Collections2.transform(elements,
				CreateZDLWrapper.create(PortType.class));
		return new ImmutableList.Builder<PortType>().addAll(result).build();

	}

	public List<ComponentImplementation> selectComponentImplementation(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Component::ComponentImplementation"));
		final Collection<ComponentImplementation> result = Collections2
				.transform(elements,
						CreateZDLWrapper.create(ComponentImplementation.class));
		return new ImmutableList.Builder<ComponentImplementation>().addAll(
				result).build();

	}

	public List<InterfaceRealization> selectInterfaceRealization(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Component::InterfaceRealization"));
		final Collection<InterfaceRealization> result = Collections2.transform(
				elements, CreateZDLWrapper.create(InterfaceRealization.class));
		return new ImmutableList.Builder<InterfaceRealization>().addAll(result)
				.build();

	}

	public List<WorkerFunctionImpl> selectWorkerFunctionImpl(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Component::WorkerFunctionImpl"));
		final Collection<WorkerFunctionImpl> result = Collections2.transform(
				elements, CreateZDLWrapper.create(WorkerFunctionImpl.class));
		return new ImmutableList.Builder<WorkerFunctionImpl>().addAll(result)
				.build();

	}

	public List<HwComponent> selectHwComponent(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_HwPlatform::HwComponent"));
		final Collection<HwComponent> result = Collections2.transform(elements,
				CreateZDLWrapper.create(HwComponent.class));
		return new ImmutableList.Builder<HwComponent>().addAll(result).build();

	}

	public List<HwProcessor> selectHwProcessor(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_HwPlatform::HwProcessor"));
		final Collection<HwProcessor> result = Collections2.transform(elements,
				CreateZDLWrapper.create(HwProcessor.class));
		return new ImmutableList.Builder<HwProcessor>().addAll(result).build();

	}

	public List<HwCore> selectHwCore(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_HwPlatform::HwCore"));
		final Collection<HwCore> result = Collections2.transform(elements,
				CreateZDLWrapper.create(HwCore.class));
		return new ImmutableList.Builder<HwCore>().addAll(result).build();

	}

	public List<HwBus> selectHwBus(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_HwPlatform::HwBus"));
		final Collection<HwBus> result = Collections2.transform(elements,
				CreateZDLWrapper.create(HwBus.class));
		return new ImmutableList.Builder<HwBus>().addAll(result).build();

	}

	public List<HwCard> selectHwCard(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_HwPlatform::HwCard"));
		final Collection<HwCard> result = Collections2.transform(elements,
				CreateZDLWrapper.create(HwCard.class));
		return new ImmutableList.Builder<HwCard>().addAll(result).build();

	}

	public List<SwComponent> selectSwComponent(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_SwPlatform::SwComponent"));
		final Collection<SwComponent> result = Collections2.transform(elements,
				CreateZDLWrapper.create(SwComponent.class));
		return new ImmutableList.Builder<SwComponent>().addAll(result).build();

	}

	public List<SwBus> selectSwBus(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_SwPlatform::SwBus"));
		final Collection<SwBus> result = Collections2.transform(elements,
				CreateZDLWrapper.create(SwBus.class));
		return new ImmutableList.Builder<SwBus>().addAll(result).build();

	}

	public List<SwSchedulableResource> selectSwSchedulableResource(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_SwPlatform::SwSchedulableResource"));
		final Collection<SwSchedulableResource> result = Collections2
				.transform(elements,
						CreateZDLWrapper.create(SwSchedulableResource.class));
		return new ImmutableList.Builder<SwSchedulableResource>()
				.addAll(result).build();

	}

	public List<SwOperatingSystem> selectSwOperatingSystem(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_SwPlatform::SwOperatingSystem"));
		final Collection<SwOperatingSystem> result = Collections2.transform(
				elements, CreateZDLWrapper.create(SwOperatingSystem.class));
		return new ImmutableList.Builder<SwOperatingSystem>().addAll(result)
				.build();

	}

	public List<SwPlatform> selectSwPlatform(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_SwPlatform::SwPlatform"));
		final Collection<SwPlatform> result = Collections2.transform(elements,
				CreateZDLWrapper.create(SwPlatform.class));
		return new ImmutableList.Builder<SwPlatform>().addAll(result).build();

	}

	public List<Configuration> selectConfiguration(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Configurations::Configuration"));
		final Collection<Configuration> result = Collections2.transform(
				elements, CreateZDLWrapper.create(Configuration.class));
		return new ImmutableList.Builder<Configuration>().addAll(result)
				.build();

	}

	public List<BuildConfiguration> selectBuildConfiguration(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Configurations::BuildConfiguration"));
		final Collection<BuildConfiguration> result = Collections2.transform(
				elements, CreateZDLWrapper.create(BuildConfiguration.class));
		return new ImmutableList.Builder<BuildConfiguration>().addAll(result)
				.build();

	}

	public List<Allocation> selectAllocation(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Deployments::Allocation"));
		final Collection<Allocation> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Allocation.class));
		return new ImmutableList.Builder<Allocation>().addAll(result).build();

	}

	public List<Deployment> selectDeployment(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Deployments::Deployment"));
		final Collection<Deployment> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Deployment.class));
		return new ImmutableList.Builder<Deployment>().addAll(result).build();

	}

	public List<DeploymentTarget> selectDeploymentTarget(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Deployments::DeploymentTarget"));
		final Collection<DeploymentTarget> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DeploymentTarget.class));
		return new ImmutableList.Builder<DeploymentTarget>().addAll(result)
				.build();

	}

	public List<DeployableElement> selectDeployableElement(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Deployments::DeployableElement"));
		final Collection<DeployableElement> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DeployableElement.class));
		return new ImmutableList.Builder<DeployableElement>().addAll(result)
				.build();

	}

	public List<DeploymentSpecification> selectDeploymentSpecification(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Deployments::DeploymentSpecification"));
		final Collection<DeploymentSpecification> result = Collections2
				.transform(elements,
						CreateZDLWrapper.create(DeploymentSpecification.class));
		return new ImmutableList.Builder<DeploymentSpecification>().addAll(
				result).build();

	}

	public List<Type> selectType(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Core::Type"));
		final Collection<Type> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Type.class));
		return new ImmutableList.Builder<Type>().addAll(result).build();

	}

	public List<Model> selectModel(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZMLMM::ZML_Core::Model"));
		final Collection<Model> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Model.class));
		return new ImmutableList.Builder<Model>().addAll(result).build();

	}

}
