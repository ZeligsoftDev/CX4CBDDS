package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface rlQosPolicy extends qosPolicy {
	Integer getMax_instances();

	Integer getMax_samples();

	Integer getMax_samples_per_instance();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of rlQosPolicy
	 */
	static final TypeSelectPredicate<rlQosPolicy> type = new TypeSelectPredicate<rlQosPolicy>(
			"DDS::QOS::rlQosPolicy", //$NON-NLS-1$
			rlQosPolicy.class);
}
