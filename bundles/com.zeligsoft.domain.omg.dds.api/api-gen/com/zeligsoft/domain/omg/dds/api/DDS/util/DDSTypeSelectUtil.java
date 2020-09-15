package com.zeligsoft.domain.omg.dds.api.DDS.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.uml2.uml.PackageableElement;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

import com.zeligsoft.base.zdl.staticapi.predicate.IsZDLConcept;
import com.zeligsoft.base.zdl.staticapi.functions.CreateZDLWrapper;

import com.zeligsoft.domain.omg.dds.api.Core.Specification;
import com.zeligsoft.domain.omg.dds.api.Core.Classifier;
import com.zeligsoft.domain.omg.dds.api.Domain.DDSEntity;
import com.zeligsoft.domain.omg.dds.api.Topics.Topic;
import com.zeligsoft.domain.omg.dds.api.DCPS.Subscriber;
import com.zeligsoft.domain.omg.dds.api.DCPS.Publisher;
import com.zeligsoft.domain.omg.dds.api.DCPS.DDSComponent;
import com.zeligsoft.domain.omg.dds.api.DCPS.Domain;
import com.zeligsoft.domain.omg.dds.api.DCPS.PublisherSubscriber;
import com.zeligsoft.domain.omg.dds.api.QOS.qosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.historyQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.lifespanQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.ownershipQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.osQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.wdlQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.rdlQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.udQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.tdQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.tpQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.deadlineQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.lbQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.tbfQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.gdQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.efQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.rlQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.presentationQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.partitionQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.reliabilityQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.dsQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.livelinessQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.durabilityQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.doQosPolicy;

public class DDSTypeSelectUtil {
	public List<Specification> selectSpecification(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::Core::Specification"));
		final Collection<Specification> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Specification.class));
		return new ImmutableList.Builder<Specification>().addAll(result).build();

	}

	public List<Classifier> selectClassifier(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::Core::Classifier"));
		final Collection<Classifier> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Classifier.class));
		return new ImmutableList.Builder<Classifier>().addAll(result).build();

	}

	public List<DDSEntity> selectDDSEntity(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::Domain::DDSEntity"));
		final Collection<DDSEntity> result = Collections2.transform(elements, CreateZDLWrapper.create(DDSEntity.class));
		return new ImmutableList.Builder<DDSEntity>().addAll(result).build();

	}

	public List<Topic> selectTopic(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::Topics::Topic"));
		final Collection<Topic> result = Collections2.transform(elements, CreateZDLWrapper.create(Topic.class));
		return new ImmutableList.Builder<Topic>().addAll(result).build();

	}

	public List<Subscriber> selectSubscriber(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::DCPS::Subscriber"));
		final Collection<Subscriber> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Subscriber.class));
		return new ImmutableList.Builder<Subscriber>().addAll(result).build();

	}

	public List<Publisher> selectPublisher(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::DCPS::Publisher"));
		final Collection<Publisher> result = Collections2.transform(elements, CreateZDLWrapper.create(Publisher.class));
		return new ImmutableList.Builder<Publisher>().addAll(result).build();

	}

	public List<DDSComponent> selectDDSComponent(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::DCPS::DDSComponent"));
		final Collection<DDSComponent> result = Collections2.transform(elements,
				CreateZDLWrapper.create(DDSComponent.class));
		return new ImmutableList.Builder<DDSComponent>().addAll(result).build();

	}

	public List<Domain> selectDomain(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::DCPS::Domain"));
		final Collection<Domain> result = Collections2.transform(elements, CreateZDLWrapper.create(Domain.class));
		return new ImmutableList.Builder<Domain>().addAll(result).build();

	}

	public List<PublisherSubscriber> selectPublisherSubscriber(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::DCPS::PublisherSubscriber"));
		final Collection<PublisherSubscriber> result = Collections2.transform(elements,
				CreateZDLWrapper.create(PublisherSubscriber.class));
		return new ImmutableList.Builder<PublisherSubscriber>().addAll(result).build();

	}

	public List<qosPolicy> selectQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::qosPolicy"));
		final Collection<qosPolicy> result = Collections2.transform(elements, CreateZDLWrapper.create(qosPolicy.class));
		return new ImmutableList.Builder<qosPolicy>().addAll(result).build();

	}

	public List<historyQosPolicy> selectHistoryQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::historyQosPolicy"));
		final Collection<historyQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(historyQosPolicy.class));
		return new ImmutableList.Builder<historyQosPolicy>().addAll(result).build();

	}

	public List<lifespanQosPolicy> selectLifespanQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::lifespanQosPolicy"));
		final Collection<lifespanQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(lifespanQosPolicy.class));
		return new ImmutableList.Builder<lifespanQosPolicy>().addAll(result).build();

	}

	public List<ownershipQosPolicy> selectOwnershipQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::ownershipQosPolicy"));
		final Collection<ownershipQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(ownershipQosPolicy.class));
		return new ImmutableList.Builder<ownershipQosPolicy>().addAll(result).build();

	}

	public List<osQosPolicy> selectOsQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::osQosPolicy"));
		final Collection<osQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(osQosPolicy.class));
		return new ImmutableList.Builder<osQosPolicy>().addAll(result).build();

	}

	public List<wdlQosPolicy> selectWdlQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::wdlQosPolicy"));
		final Collection<wdlQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(wdlQosPolicy.class));
		return new ImmutableList.Builder<wdlQosPolicy>().addAll(result).build();

	}

	public List<rdlQosPolicy> selectRdlQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::rdlQosPolicy"));
		final Collection<rdlQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(rdlQosPolicy.class));
		return new ImmutableList.Builder<rdlQosPolicy>().addAll(result).build();

	}

	public List<udQosPolicy> selectUdQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::udQosPolicy"));
		final Collection<udQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(udQosPolicy.class));
		return new ImmutableList.Builder<udQosPolicy>().addAll(result).build();

	}

	public List<tdQosPolicy> selectTdQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::tdQosPolicy"));
		final Collection<tdQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(tdQosPolicy.class));
		return new ImmutableList.Builder<tdQosPolicy>().addAll(result).build();

	}

	public List<tpQosPolicy> selectTpQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::tpQosPolicy"));
		final Collection<tpQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(tpQosPolicy.class));
		return new ImmutableList.Builder<tpQosPolicy>().addAll(result).build();

	}

	public List<deadlineQosPolicy> selectDeadlineQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::deadlineQosPolicy"));
		final Collection<deadlineQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(deadlineQosPolicy.class));
		return new ImmutableList.Builder<deadlineQosPolicy>().addAll(result).build();

	}

	public List<lbQosPolicy> selectLbQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::lbQosPolicy"));
		final Collection<lbQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(lbQosPolicy.class));
		return new ImmutableList.Builder<lbQosPolicy>().addAll(result).build();

	}

	public List<tbfQosPolicy> selectTbfQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::tbfQosPolicy"));
		final Collection<tbfQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(tbfQosPolicy.class));
		return new ImmutableList.Builder<tbfQosPolicy>().addAll(result).build();

	}

	public List<gdQosPolicy> selectGdQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::gdQosPolicy"));
		final Collection<gdQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(gdQosPolicy.class));
		return new ImmutableList.Builder<gdQosPolicy>().addAll(result).build();

	}

	public List<efQosPolicy> selectEfQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::efQosPolicy"));
		final Collection<efQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(efQosPolicy.class));
		return new ImmutableList.Builder<efQosPolicy>().addAll(result).build();

	}

	public List<rlQosPolicy> selectRlQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::rlQosPolicy"));
		final Collection<rlQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(rlQosPolicy.class));
		return new ImmutableList.Builder<rlQosPolicy>().addAll(result).build();

	}

	public List<presentationQosPolicy> selectPresentationQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::presentationQosPolicy"));
		final Collection<presentationQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(presentationQosPolicy.class));
		return new ImmutableList.Builder<presentationQosPolicy>().addAll(result).build();

	}

	public List<partitionQosPolicy> selectPartitionQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::partitionQosPolicy"));
		final Collection<partitionQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(partitionQosPolicy.class));
		return new ImmutableList.Builder<partitionQosPolicy>().addAll(result).build();

	}

	public List<reliabilityQosPolicy> selectReliabilityQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::reliabilityQosPolicy"));
		final Collection<reliabilityQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(reliabilityQosPolicy.class));
		return new ImmutableList.Builder<reliabilityQosPolicy>().addAll(result).build();

	}

	public List<dsQosPolicy> selectDsQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::dsQosPolicy"));
		final Collection<dsQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(dsQosPolicy.class));
		return new ImmutableList.Builder<dsQosPolicy>().addAll(result).build();

	}

	public List<livelinessQosPolicy> selectLivelinessQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::livelinessQosPolicy"));
		final Collection<livelinessQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(livelinessQosPolicy.class));
		return new ImmutableList.Builder<livelinessQosPolicy>().addAll(result).build();

	}

	public List<durabilityQosPolicy> selectDurabilityQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::durabilityQosPolicy"));
		final Collection<durabilityQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(durabilityQosPolicy.class));
		return new ImmutableList.Builder<durabilityQosPolicy>().addAll(result).build();

	}

	public List<doQosPolicy> selectDoQosPolicy(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("DDS::QOS::doQosPolicy"));
		final Collection<doQosPolicy> result = Collections2.transform(elements,
				CreateZDLWrapper.create(doQosPolicy.class));
		return new ImmutableList.Builder<doQosPolicy>().addAll(result).build();

	}

}
