package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface livelinessQosPolicy extends qosPolicy {
	LivelinessQosPolicyKind getKind();

	Duration getLease_duration();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of livelinessQosPolicy
	 */
	static final TypeSelectPredicate<livelinessQosPolicy> type = new TypeSelectPredicate<livelinessQosPolicy>(
			"DDS::QOS::livelinessQosPolicy", //$NON-NLS-1$
			livelinessQosPolicy.class);
}
