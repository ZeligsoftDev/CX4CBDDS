package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface presentationQosPolicy extends qosPolicy {
	PresentationQosPolicyAccessScopeKind getAccess_scope();

	Boolean getCoherent_access();

	Boolean getOrdered_access();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of presentationQosPolicy
	 */
	static final TypeSelectPredicate<presentationQosPolicy> type = new TypeSelectPredicate<presentationQosPolicy>(
			"DDS::QOS::presentationQosPolicy", //$NON-NLS-1$
			presentationQosPolicy.class);
}
