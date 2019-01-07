package com.zeligsoft.domain.zml.api.ZML_SwPlatform;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface SwOperatingSystem extends SwComponent {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of SwOperatingSystem
	 */
	static final TypeSelectPredicate<SwOperatingSystem> type = new TypeSelectPredicate<SwOperatingSystem>(
			"ZMLMM::ZML_SwPlatform::SwOperatingSystem", //$NON-NLS-1$
			SwOperatingSystem.class);
}
