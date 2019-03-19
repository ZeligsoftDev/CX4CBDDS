package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface presentationQosPolicy extends qosPolicy {
	PresentationQosPolicyAccessScopeKind getAccess_scope();

	void setAccess_scope(PresentationQosPolicyAccessScopeKind val);

	Boolean getCoherent_access();

	void setCoherent_access(Boolean val);

	Boolean getOrdered_access();

	void setOrdered_access(Boolean val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of presentationQosPolicy
	 */
	static final TypeSelectPredicate<presentationQosPolicy> type = new TypeSelectPredicate<presentationQosPolicy>(
			"DDS::QOS::presentationQosPolicy", //$NON-NLS-1$
			presentationQosPolicy.class);
}
