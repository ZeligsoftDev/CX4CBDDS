package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface dsQosPolicy extends qosPolicy {
	HistoryQosPolicyKind getHistory_kind();

	Integer getMax_instances();

	Integer getMax_samples();

	Integer getMax_samples_per_instance();

	Duration getService_cleanup_delay();

	Integer getHistory_depth();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of dsQosPolicy
	 */
	static final TypeSelectPredicate<dsQosPolicy> type = new TypeSelectPredicate<dsQosPolicy>(
			"DDS::QOS::dsQosPolicy", //$NON-NLS-1$
			dsQosPolicy.class);
}
