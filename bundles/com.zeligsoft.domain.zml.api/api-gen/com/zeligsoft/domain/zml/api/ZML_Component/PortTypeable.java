package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface PortTypeable extends ZObject {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of PortTypeable
	 */
	static final TypeSelectPredicate<PortTypeable> type = new TypeSelectPredicate<PortTypeable>(
			"ZMLMM::ZML_Component::PortTypeable", //$NON-NLS-1$
			PortTypeable.class);
}
