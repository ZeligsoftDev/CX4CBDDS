package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface wdlQosPolicy extends qosPolicy {
	Boolean getAutodispose_unregistered_instances();

	void setAutodispose_unregistered_instances(Boolean val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of wdlQosPolicy
	 */
	static final TypeSelectPredicate<wdlQosPolicy> type = new TypeSelectPredicate<wdlQosPolicy>(
			"DDS::QOS::wdlQosPolicy", //$NON-NLS-1$
			wdlQosPolicy.class);
}
