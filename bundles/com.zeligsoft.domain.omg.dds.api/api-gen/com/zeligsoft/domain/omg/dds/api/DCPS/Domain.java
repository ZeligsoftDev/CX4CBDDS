package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.dds.api.Core.NamedEntity;

public interface Domain extends NamedEntity {
	java.util.List<DomainTopic> getDomainTopic();

	java.util.List<DomainParticipant> getParticipant();

	java.util.List<TopicConnector> getConnector();

	org.eclipse.uml2.uml.Component asComponent();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Domain
	 */
	static final TypeSelectPredicate<Domain> type = new TypeSelectPredicate<Domain>(
			"DDS::DCPS::Domain", //$NON-NLS-1$
			Domain.class);
}
