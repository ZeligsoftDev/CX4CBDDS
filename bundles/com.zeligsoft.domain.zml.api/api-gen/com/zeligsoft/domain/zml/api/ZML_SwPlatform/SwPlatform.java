package com.zeligsoft.domain.zml.api.ZML_SwPlatform;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface SwPlatform extends SwComponent {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of SwPlatform
	 */
	static final TypeSelectPredicate<SwPlatform> type = new TypeSelectPredicate<SwPlatform>(
			"ZMLMM::ZML_SwPlatform::SwPlatform", //$NON-NLS-1$
			SwPlatform.class);
}
