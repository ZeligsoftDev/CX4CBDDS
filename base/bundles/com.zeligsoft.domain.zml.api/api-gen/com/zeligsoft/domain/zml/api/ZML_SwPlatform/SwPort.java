package com.zeligsoft.domain.zml.api.ZML_SwPlatform;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface SwPort extends SwCommunicationEndPoint {
	org.eclipse.uml2.uml.Port asPort();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of SwPort
	 */
	static final TypeSelectPredicate<SwPort> type = new TypeSelectPredicate<SwPort>(
			"ZMLMM::ZML_SwPlatform::SwPort", //$NON-NLS-1$
			SwPort.class);
}
