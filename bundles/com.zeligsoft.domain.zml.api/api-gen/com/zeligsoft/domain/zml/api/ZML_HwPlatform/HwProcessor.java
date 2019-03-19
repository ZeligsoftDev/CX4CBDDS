package com.zeligsoft.domain.zml.api.ZML_HwPlatform;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface HwProcessor extends HwComponent {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of HwProcessor
	 */
	static final TypeSelectPredicate<HwProcessor> type = new TypeSelectPredicate<HwProcessor>(
			"ZMLMM::ZML_HwPlatform::HwProcessor", //$NON-NLS-1$
			HwProcessor.class);
}
