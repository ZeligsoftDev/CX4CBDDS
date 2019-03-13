package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface udQosPolicy extends qosPolicy {
	String getValue();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of udQosPolicy
	 */
	static final TypeSelectPredicate<udQosPolicy> type = new TypeSelectPredicate<udQosPolicy>(
			"DDS::QOS::udQosPolicy", //$NON-NLS-1$
			udQosPolicy.class);
}
