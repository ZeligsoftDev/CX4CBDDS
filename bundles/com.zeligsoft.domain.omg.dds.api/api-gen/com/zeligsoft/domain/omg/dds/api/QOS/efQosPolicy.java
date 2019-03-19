package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface efQosPolicy extends qosPolicy {
	Boolean getAutoenable_created_entities();

	void setAutoenable_created_entities(Boolean val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of efQosPolicy
	 */
	static final TypeSelectPredicate<efQosPolicy> type = new TypeSelectPredicate<efQosPolicy>(
			"DDS::QOS::efQosPolicy", //$NON-NLS-1$
			efQosPolicy.class);
}
