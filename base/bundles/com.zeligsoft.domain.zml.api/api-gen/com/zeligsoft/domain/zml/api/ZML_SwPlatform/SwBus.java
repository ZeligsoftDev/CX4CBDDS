package com.zeligsoft.domain.zml.api.ZML_SwPlatform;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface SwBus extends SwCommunicationEndPoint, SwCommunicationMedium,
		SwComponent {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of SwBus
	 */
	static final TypeSelectPredicate<SwBus> type = new TypeSelectPredicate<SwBus>(
			"ZMLMM::ZML_SwPlatform::SwBus", //$NON-NLS-1$
			SwBus.class);
}
