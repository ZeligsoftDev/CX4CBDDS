package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface reliabilityQosPolicy extends qosPolicy {
	RealiabilityQosPolicyKind getKind();

	void setKind(RealiabilityQosPolicyKind val);

	Duration getMax_blocking_time();

	void setMax_blocking_time(Duration val);

	<T extends Duration> T createMax_blocking_time(Class<T> typeToCreate, String concept);

	Duration createMax_blocking_time();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of reliabilityQosPolicy
	 */
	static final TypeSelectPredicate<reliabilityQosPolicy> type = new TypeSelectPredicate<reliabilityQosPolicy>(
			"DDS::QOS::reliabilityQosPolicy", //$NON-NLS-1$
			reliabilityQosPolicy.class);
}
