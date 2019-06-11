package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface tpQosPolicy extends qosPolicy {
	Integer getValue();

	void setValue(Integer val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of tpQosPolicy
	 */
	static final TypeSelectPredicate<tpQosPolicy> type = new TypeSelectPredicate<tpQosPolicy>(
			"DDS::QOS::tpQosPolicy", //$NON-NLS-1$
			tpQosPolicy.class);
}
