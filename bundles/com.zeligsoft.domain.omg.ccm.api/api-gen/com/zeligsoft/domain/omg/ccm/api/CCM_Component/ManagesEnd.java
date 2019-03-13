package com.zeligsoft.domain.omg.ccm.api.CCM_Component;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface ManagesEnd extends ZObject {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of ManagesEnd
	 */
	static final TypeSelectPredicate<ManagesEnd> type = new TypeSelectPredicate<ManagesEnd>(
			"CCM::CCM_Component::ManagesEnd", //$NON-NLS-1$
			ManagesEnd.class); 
}
