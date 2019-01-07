package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface tdQosPolicy extends qosPolicy {
	String getValue();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of tdQosPolicy
	 */
	static final TypeSelectPredicate<tdQosPolicy> type = new TypeSelectPredicate<tdQosPolicy>(
			"DDS::QOS::tdQosPolicy", //$NON-NLS-1$
			tdQosPolicy.class);
}
