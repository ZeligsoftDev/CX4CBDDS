package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface partitionQosPolicy extends qosPolicy {
	@Override
	String getName();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of partitionQosPolicy
	 */
	static final TypeSelectPredicate<partitionQosPolicy> type = new TypeSelectPredicate<partitionQosPolicy>(
			"DDS::QOS::partitionQosPolicy", //$NON-NLS-1$
			partitionQosPolicy.class);
}
