package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.dds.api.Core.NamedEntity;

public interface Domain extends NamedEntity {
	java.util.List<DomainTopic> getDomainTopic();

	void addDomainTopic(DomainTopic val);

	<T extends DomainTopic> T addDomainTopic(Class<T> typeToCreate,
			String concept);

	DomainTopic addDomainTopic();

	java.util.List<DomainParticipant> getParticipant();

	void addParticipant(DomainParticipant val);

	<T extends DomainParticipant> T addParticipant(Class<T> typeToCreate,
			String concept);

	DomainParticipant addParticipant();

	java.util.List<TopicConnector> getConnector();

	void addConnector(TopicConnector val);

	<T extends TopicConnector> T addConnector(Class<T> typeToCreate,
			String concept);

	TopicConnector addConnector();

	org.eclipse.uml2.uml.Component asComponent();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Domain
	 */
	static final TypeSelectPredicate<Domain> type = new TypeSelectPredicate<Domain>(
			"DDS::DCPS::Domain", //$NON-NLS-1$
			Domain.class);
}
