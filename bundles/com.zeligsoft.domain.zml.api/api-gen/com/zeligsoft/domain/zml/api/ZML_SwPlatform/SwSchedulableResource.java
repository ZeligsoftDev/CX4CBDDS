package com.zeligsoft.domain.zml.api.ZML_SwPlatform;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface SwSchedulableResource extends SwComponent {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of SwSchedulableResource
	 */
	static final TypeSelectPredicate<SwSchedulableResource> type = new TypeSelectPredicate<SwSchedulableResource>(
			"ZMLMM::ZML_SwPlatform::SwSchedulableResource", //$NON-NLS-1$
			SwSchedulableResource.class);
}
