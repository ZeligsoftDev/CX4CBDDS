package com.zeligsoft.domain.zml.api.ZML_HwPlatform;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface HwBus extends HwCommunicationMedium, HwCommunicationEndPoint,
		HwComponent {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of HwBus
	 */
	static final TypeSelectPredicate<HwBus> type = new TypeSelectPredicate<HwBus>(
			"ZMLMM::ZML_HwPlatform::HwBus", //$NON-NLS-1$
			HwBus.class);
}
