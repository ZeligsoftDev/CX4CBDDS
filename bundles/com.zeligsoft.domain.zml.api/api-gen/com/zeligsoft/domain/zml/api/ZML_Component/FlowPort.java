package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface FlowPort extends Port {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of FlowPort
	 */
	static final TypeSelectPredicate<FlowPort> type = new TypeSelectPredicate<FlowPort>(
			"ZMLMM::ZML_Component::FlowPort", //$NON-NLS-1$
			FlowPort.class);
}
