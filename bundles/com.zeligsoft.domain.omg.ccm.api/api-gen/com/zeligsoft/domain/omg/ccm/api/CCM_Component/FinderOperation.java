package com.zeligsoft.domain.omg.ccm.api.CCM_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface FinderOperation extends HomeOperation {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of FinderOperation
	 */
	static final TypeSelectPredicate<FinderOperation> type = new TypeSelectPredicate<FinderOperation>(
			"CCM::CCM_Component::FinderOperation", //$NON-NLS-1$
			FinderOperation.class);
}
