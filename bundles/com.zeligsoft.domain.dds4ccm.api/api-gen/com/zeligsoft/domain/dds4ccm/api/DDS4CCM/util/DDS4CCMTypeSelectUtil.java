package com.zeligsoft.domain.dds4ccm.api.DDS4CCM.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.uml2.uml.PackageableElement;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

import com.zeligsoft.base.zdl.staticapi.predicate.IsZDLConcept;
import com.zeligsoft.base.zdl.staticapi.functions.CreateZDLWrapper;

import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.DDS4CCMModel;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLFileSpecification;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLFileDependency;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLIncludeDependency;
import com.zeligsoft.domain.dds4ccm.api.DDSExtensions.DDSMessage;
import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.QoSProfile;
import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.QoSForEntity;
import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.DataReaderQoS;
import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.ParticipantQoS;
import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.PublisherQoS;
import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.SubscriberQoS;
import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.TopicQoS;
import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.DataWriterQoS;
import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.DataReaderWriterQoS;
import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.PublisherSubscriberQoS;

public class DDS4CCMTypeSelectUtil {
	public List<DDS4CCMModel> selectDDS4CCMModel(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::DDS4CCM::DDS4CCMModel"));
		final Collection<DDS4CCMModel> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DDS4CCMModel.class));
		return new ImmutableList.Builder<DDS4CCMModel>().addAll(result).build();

	}

	public List<IDLFileSpecification> selectIDLFileSpecification(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::DDS4CCM::IDLFileSpecification"));
		final Collection<IDLFileSpecification> result = Collections2.transform(
				elements, CreateZDLWrapper.create(IDLFileSpecification.class));
		return new ImmutableList.Builder<IDLFileSpecification>().addAll(result)
				.build();

	}

	public List<IDLFileDependency> selectIDLFileDependency(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::DDS4CCM::IDLFileDependency"));
		final Collection<IDLFileDependency> result = Collections2.transform(
				elements, CreateZDLWrapper.create(IDLFileDependency.class));
		return new ImmutableList.Builder<IDLFileDependency>().addAll(result)
				.build();

	}

	public List<IDLIncludeDependency> selectIDLIncludeDependency(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::DDS4CCM::IDLIncludeDependency"));
		final Collection<IDLIncludeDependency> result = Collections2.transform(
				elements, CreateZDLWrapper.create(IDLIncludeDependency.class));
		return new ImmutableList.Builder<IDLIncludeDependency>().addAll(result)
				.build();

	}

	public List<DDSMessage> selectDDSMessage(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::DDSExtensions::DDSMessage"));
		final Collection<DDSMessage> result = Collections2.transform(elements,
				CreateZDLWrapper.create(DDSMessage.class));
		return new ImmutableList.Builder<DDSMessage>().addAll(result).build();

	}

	public List<QoSProfile> selectQoSProfile(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::QoSProfiles::QoSProfile"));
		final Collection<QoSProfile> result = Collections2.transform(elements,
				CreateZDLWrapper.create(QoSProfile.class));
		return new ImmutableList.Builder<QoSProfile>().addAll(result).build();

	}

	public List<QoSForEntity> selectQoSForEntity(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::QoSProfiles::QoSForEntity"));
		final Collection<QoSForEntity> result = Collections2.transform(
				elements, CreateZDLWrapper.create(QoSForEntity.class));
		return new ImmutableList.Builder<QoSForEntity>().addAll(result).build();

	}

	public List<DataReaderQoS> selectDataReaderQoS(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::QoSProfiles::DataReaderQoS"));
		final Collection<DataReaderQoS> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DataReaderQoS.class));
		return new ImmutableList.Builder<DataReaderQoS>().addAll(result)
				.build();

	}

	public List<ParticipantQoS> selectParticipantQoS(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::QoSProfiles::ParticipantQoS"));
		final Collection<ParticipantQoS> result = Collections2.transform(
				elements, CreateZDLWrapper.create(ParticipantQoS.class));
		return new ImmutableList.Builder<ParticipantQoS>().addAll(result)
				.build();

	}

	public List<PublisherQoS> selectPublisherQoS(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::QoSProfiles::PublisherQoS"));
		final Collection<PublisherQoS> result = Collections2.transform(
				elements, CreateZDLWrapper.create(PublisherQoS.class));
		return new ImmutableList.Builder<PublisherQoS>().addAll(result).build();

	}

	public List<SubscriberQoS> selectSubscriberQoS(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::QoSProfiles::SubscriberQoS"));
		final Collection<SubscriberQoS> result = Collections2.transform(
				elements, CreateZDLWrapper.create(SubscriberQoS.class));
		return new ImmutableList.Builder<SubscriberQoS>().addAll(result)
				.build();

	}

	public List<TopicQoS> selectTopicQoS(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::QoSProfiles::TopicQoS"));
		final Collection<TopicQoS> result = Collections2.transform(elements,
				CreateZDLWrapper.create(TopicQoS.class));
		return new ImmutableList.Builder<TopicQoS>().addAll(result).build();

	}

	public List<DataWriterQoS> selectDataWriterQoS(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::QoSProfiles::DataWriterQoS"));
		final Collection<DataWriterQoS> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DataWriterQoS.class));
		return new ImmutableList.Builder<DataWriterQoS>().addAll(result)
				.build();

	}

	public List<DataReaderWriterQoS> selectDataReaderWriterQoS(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::QoSProfiles::DataReaderWriterQoS"));
		final Collection<DataReaderWriterQoS> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DataReaderWriterQoS.class));
		return new ImmutableList.Builder<DataReaderWriterQoS>().addAll(result)
				.build();

	}

	public List<PublisherSubscriberQoS> selectPublisherSubscriberQoS(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"DDS4CCM::QoSProfiles::PublisherSubscriberQoS"));
		final Collection<PublisherSubscriberQoS> result = Collections2
				.transform(elements,
						CreateZDLWrapper.create(PublisherSubscriberQoS.class));
		return new ImmutableList.Builder<PublisherSubscriberQoS>().addAll(
				result).build();

	}

}
