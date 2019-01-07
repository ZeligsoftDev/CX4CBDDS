package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface osQosPolicy extends qosPolicy {
	Integer getValue();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of osQosPolicy
	 */
	static final TypeSelectPredicate<osQosPolicy> type = new TypeSelectPredicate<osQosPolicy>(
			"DDS::QOS::osQosPolicy", //$NON-NLS-1$
			osQosPolicy.class);
}
