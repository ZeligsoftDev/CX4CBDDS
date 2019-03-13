package com.zeligsoft.domain.zml.api.ZML_SwPlatform;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface SwCommunicationMedium extends ZObject {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of SwCommunicationMedium
	 */
	static final TypeSelectPredicate<SwCommunicationMedium> type = new TypeSelectPredicate<SwCommunicationMedium>(
			"ZMLMM::ZML_SwPlatform::SwCommunicationMedium", //$NON-NLS-1$
			SwCommunicationMedium.class);
}
