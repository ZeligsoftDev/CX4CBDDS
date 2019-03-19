package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface deadlineQosPolicy extends qosPolicy {
	Duration getPeriod();

	void setPeriod(Duration val);

	<T extends Duration> T createPeriod(Class<T> typeToCreate, String concept);

	Duration createPeriod();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of deadlineQosPolicy
	 */
	static final TypeSelectPredicate<deadlineQosPolicy> type = new TypeSelectPredicate<deadlineQosPolicy>(
			"DDS::QOS::deadlineQosPolicy", //$NON-NLS-1$
			deadlineQosPolicy.class);
}
