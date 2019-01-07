package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface ownershipQosPolicy extends qosPolicy {
	OwnershipQosPolicyKind getKind();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ownershipQosPolicy
	 */
	static final TypeSelectPredicate<ownershipQosPolicy> type = new TypeSelectPredicate<ownershipQosPolicy>(
			"DDS::QOS::ownershipQosPolicy", //$NON-NLS-1$
			ownershipQosPolicy.class);
}
