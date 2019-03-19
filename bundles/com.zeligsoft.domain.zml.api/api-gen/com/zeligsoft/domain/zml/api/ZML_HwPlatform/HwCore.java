package com.zeligsoft.domain.zml.api.ZML_HwPlatform;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface HwCore extends HwComponent {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of HwCore
	 */
	static final TypeSelectPredicate<HwCore> type = new TypeSelectPredicate<HwCore>(
			"ZMLMM::ZML_HwPlatform::HwCore", //$NON-NLS-1$
			HwCore.class);
}
