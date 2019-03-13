package com.zeligsoft.domain.omg.ccm.api.CCM.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.uml2.uml.PackageableElement;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

import com.zeligsoft.base.zdl.staticapi.predicate.IsZDLConcept;
import com.zeligsoft.base.zdl.staticapi.functions.CreateZDLWrapper;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.CCMComponent;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Event;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Home;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Manages;
import com.zeligsoft.domain.omg.ccm.api.CCM_Artifacts.IDL3File;
import com.zeligsoft.domain.omg.ccm.api.CCM_Artifacts.IDL3FileImport;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.HomeImplementation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.ManagesImpl;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.MonolithicImplementation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Core.CCMModel;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Domain;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Node;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Interconnect;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Bridge;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Resource;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.RequirementSatisfier;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Requirement;
import com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.DeploymentPlan;
import com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.ContainerProcess;

public class CCMTypeSelectUtil {
	public List<CCMComponent> selectCCMComponent(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Component::CCMComponent"));
		final Collection<CCMComponent> result = Collections2.transform(
				elements, CreateZDLWrapper.create(CCMComponent.class));
		return new ImmutableList.Builder<CCMComponent>().addAll(result).build();

	}

	public List<Event> selectEvent(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Component::Event"));
		final Collection<Event> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Event.class));
		return new ImmutableList.Builder<Event>().addAll(result).build();

	}

	public List<Home> selectHome(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Component::Home"));
		final Collection<Home> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Home.class));
		return new ImmutableList.Builder<Home>().addAll(result).build();

	}

	public List<Manages> selectManages(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Component::Manages"));
		final Collection<Manages> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Manages.class));
		return new ImmutableList.Builder<Manages>().addAll(result).build();

	}

	public List<IDL3File> selectIDL3File(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Artifacts::IDL3File"));
		final Collection<IDL3File> result = Collections2.transform(elements,
				CreateZDLWrapper.create(IDL3File.class));
		return new ImmutableList.Builder<IDL3File>().addAll(result).build();

	}

	public List<IDL3FileImport> selectIDL3FileImport(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Artifacts::IDL3FileImport"));
		final Collection<IDL3FileImport> result = Collections2.transform(
				elements, CreateZDLWrapper.create(IDL3FileImport.class));
		return new ImmutableList.Builder<IDL3FileImport>().addAll(result)
				.build();

	}

	public List<AssemblyImplementation> selectAssemblyImplementation(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Implementation::AssemblyImplementation"));
		final Collection<AssemblyImplementation> result = Collections2
				.transform(elements,
						CreateZDLWrapper.create(AssemblyImplementation.class));
		return new ImmutableList.Builder<AssemblyImplementation>().addAll(
				result).build();

	}

	public List<HomeImplementation> selectHomeImplementation(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Implementation::HomeImplementation"));
		final Collection<HomeImplementation> result = Collections2.transform(
				elements, CreateZDLWrapper.create(HomeImplementation.class));
		return new ImmutableList.Builder<HomeImplementation>().addAll(result)
				.build();

	}

	public List<ManagesImpl> selectManagesImpl(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Implementation::ManagesImpl"));
		final Collection<ManagesImpl> result = Collections2.transform(elements,
				CreateZDLWrapper.create(ManagesImpl.class));
		return new ImmutableList.Builder<ManagesImpl>().addAll(result).build();

	}

	public List<MonolithicImplementation> selectMonolithicImplementation(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Implementation::MonolithicImplementation"));
		final Collection<MonolithicImplementation> result = Collections2
				.transform(elements,
						CreateZDLWrapper.create(MonolithicImplementation.class));
		return new ImmutableList.Builder<MonolithicImplementation>().addAll(
				result).build();

	}

	public List<CCMModel> selectCCMModel(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Core::CCMModel"));
		final Collection<CCMModel> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CCMModel.class));
		return new ImmutableList.Builder<CCMModel>().addAll(result).build();

	}

	public List<Domain> selectDomain(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Target::Domain"));
		final Collection<Domain> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Domain.class));
		return new ImmutableList.Builder<Domain>().addAll(result).build();

	}

	public List<Node> selectNode(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Target::Node"));
		final Collection<Node> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Node.class));
		return new ImmutableList.Builder<Node>().addAll(result).build();

	}

	public List<Interconnect> selectInterconnect(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Target::Interconnect"));
		final Collection<Interconnect> result = Collections2.transform(
				elements, CreateZDLWrapper.create(Interconnect.class));
		return new ImmutableList.Builder<Interconnect>().addAll(result).build();

	}

	public List<Bridge> selectBridge(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Target::Bridge"));
		final Collection<Bridge> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Bridge.class));
		return new ImmutableList.Builder<Bridge>().addAll(result).build();

	}

	public List<Resource> selectResource(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Target::Resource"));
		final Collection<Resource> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Resource.class));
		return new ImmutableList.Builder<Resource>().addAll(result).build();

	}

	public List<RequirementSatisfier> selectRequirementSatisfier(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Target::RequirementSatisfier"));
		final Collection<RequirementSatisfier> result = Collections2.transform(
				elements, CreateZDLWrapper.create(RequirementSatisfier.class));
		return new ImmutableList.Builder<RequirementSatisfier>().addAll(result)
				.build();

	}

	public List<Requirement> selectRequirement(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Target::Requirement"));
		final Collection<Requirement> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Requirement.class));
		return new ImmutableList.Builder<Requirement>().addAll(result).build();

	}

	public List<DeploymentPlan> selectDeploymentPlan(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Deployment::DeploymentPlan"));
		final Collection<DeploymentPlan> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DeploymentPlan.class));
		return new ImmutableList.Builder<DeploymentPlan>().addAll(result)
				.build();

	}

	public List<ContainerProcess> selectContainerProcess(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CCM::CCM_Deployment::ContainerProcess"));
		final Collection<ContainerProcess> result = Collections2.transform(
				elements, CreateZDLWrapper.create(ContainerProcess.class));
		return new ImmutableList.Builder<ContainerProcess>().addAll(result)
				.build();

	}

}
