package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface deadlineQosPolicy extends qosPolicy {
	Duration getPeriod();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of deadlineQosPolicy
	 */
	static final TypeSelectPredicate<deadlineQosPolicy> type = new TypeSelectPredicate<deadlineQosPolicy>(
			"DDS::QOS::deadlineQosPolicy", //$NON-NLS-1$
			deadlineQosPolicy.class);
}
