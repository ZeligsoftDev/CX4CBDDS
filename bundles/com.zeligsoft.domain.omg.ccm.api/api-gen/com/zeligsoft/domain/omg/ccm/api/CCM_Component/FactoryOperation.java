package com.zeligsoft.domain.omg.ccm.api.CCM_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface FactoryOperation extends HomeOperation {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of FactoryOperation
	 */
	static final TypeSelectPredicate<FactoryOperation> type = new TypeSelectPredicate<FactoryOperation>(
			"CCM::CCM_Component::FactoryOperation", //$NON-NLS-1$
			FactoryOperation.class);
}
