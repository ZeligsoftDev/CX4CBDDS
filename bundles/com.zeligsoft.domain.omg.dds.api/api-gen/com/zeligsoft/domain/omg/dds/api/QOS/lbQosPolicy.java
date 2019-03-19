package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface lbQosPolicy extends qosPolicy {
	Duration getDuration();

	void setDuration(Duration val);

	<T extends Duration> T createDuration(Class<T> typeToCreate, String concept);

	Duration createDuration();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of lbQosPolicy
	 */
	static final TypeSelectPredicate<lbQosPolicy> type = new TypeSelectPredicate<lbQosPolicy>(
			"DDS::QOS::lbQosPolicy", //$NON-NLS-1$
			lbQosPolicy.class);
}
