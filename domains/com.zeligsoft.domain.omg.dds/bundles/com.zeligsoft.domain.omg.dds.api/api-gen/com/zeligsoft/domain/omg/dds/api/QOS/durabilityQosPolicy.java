package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface durabilityQosPolicy extends qosPolicy {
	DurabilityQosPolicyKind getKind();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of durabilityQosPolicy
	 */
	static final TypeSelectPredicate<durabilityQosPolicy> type = new TypeSelectPredicate<durabilityQosPolicy>(
			"DDS::QOS::durabilityQosPolicy", //$NON-NLS-1$
			durabilityQosPolicy.class);
}
