package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface tbfQosPolicy extends qosPolicy {
	Duration getMinimum_separation();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of tbfQosPolicy
	 */
	static final TypeSelectPredicate<tbfQosPolicy> type = new TypeSelectPredicate<tbfQosPolicy>(
			"DDS::QOS::tbfQosPolicy", //$NON-NLS-1$
			tbfQosPolicy.class);
}
