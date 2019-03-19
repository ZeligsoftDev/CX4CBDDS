package com.zeligsoft.domain.dds4ccm.api.QoSProfiles;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface SubscriberQoS extends PublisherSubscriberQoS {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of SubscriberQoS
	 */
	static final TypeSelectPredicate<SubscriberQoS> type = new TypeSelectPredicate<SubscriberQoS>(
			"DDS4CCM::QoSProfiles::SubscriberQoS", //$NON-NLS-1$
			SubscriberQoS.class);
}
