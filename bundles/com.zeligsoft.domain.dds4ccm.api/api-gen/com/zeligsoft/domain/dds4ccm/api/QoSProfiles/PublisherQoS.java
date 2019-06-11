package com.zeligsoft.domain.dds4ccm.api.QoSProfiles;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface PublisherQoS extends PublisherSubscriberQoS {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of PublisherQoS
	 */
	static final TypeSelectPredicate<PublisherQoS> type = new TypeSelectPredicate<PublisherQoS>(
			"DDS4CCM::QoSProfiles::PublisherQoS", //$NON-NLS-1$
			PublisherQoS.class);
}
