package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface gdQosPolicy extends qosPolicy {
	String getValue();

	void setValue(String val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of gdQosPolicy
	 */
	static final TypeSelectPredicate<gdQosPolicy> type = new TypeSelectPredicate<gdQosPolicy>(
			"DDS::QOS::gdQosPolicy", //$NON-NLS-1$
			gdQosPolicy.class);
}
