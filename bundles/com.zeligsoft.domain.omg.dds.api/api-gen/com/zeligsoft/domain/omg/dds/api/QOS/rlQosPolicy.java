package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface rlQosPolicy extends qosPolicy {
	Integer getMax_instances();

	void setMax_instances(Integer val);

	Integer getMax_samples();

	void setMax_samples(Integer val);

	Integer getMax_samples_per_instance();

	void setMax_samples_per_instance(Integer val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of rlQosPolicy
	 */
	static final TypeSelectPredicate<rlQosPolicy> type = new TypeSelectPredicate<rlQosPolicy>("DDS::QOS::rlQosPolicy", //$NON-NLS-1$
			rlQosPolicy.class);
}
