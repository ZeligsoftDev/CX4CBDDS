package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface doQosPolicy extends qosPolicy {
	DestinationOrderQosPolicyKind getKind();

	void setKind(DestinationOrderQosPolicyKind val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of doQosPolicy
	 */
	static final TypeSelectPredicate<doQosPolicy> type = new TypeSelectPredicate<doQosPolicy>(
			"DDS::QOS::doQosPolicy", //$NON-NLS-1$
			doQosPolicy.class);
}
