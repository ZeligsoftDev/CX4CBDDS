package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface rdlQosPolicy extends qosPolicy {
	Duration getAutopurge_nowriter_samples_delay();

	Duration getAutopurge_disposed_samples_delay();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of rdlQosPolicy
	 */
	static final TypeSelectPredicate<rdlQosPolicy> type = new TypeSelectPredicate<rdlQosPolicy>(
			"DDS::QOS::rdlQosPolicy", //$NON-NLS-1$
			rdlQosPolicy.class);
}
