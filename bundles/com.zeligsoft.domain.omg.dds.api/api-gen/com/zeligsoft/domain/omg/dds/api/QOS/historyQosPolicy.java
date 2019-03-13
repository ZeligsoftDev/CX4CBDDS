package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface historyQosPolicy extends qosPolicy {
	Integer getDepth();

	HistoryQosPolicyKind getKind();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of historyQosPolicy
	 */
	static final TypeSelectPredicate<historyQosPolicy> type = new TypeSelectPredicate<historyQosPolicy>(
			"DDS::QOS::historyQosPolicy", //$NON-NLS-1$
			historyQosPolicy.class);
}
