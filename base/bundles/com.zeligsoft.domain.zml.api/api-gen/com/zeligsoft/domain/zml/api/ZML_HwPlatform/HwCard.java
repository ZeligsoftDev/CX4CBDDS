package com.zeligsoft.domain.zml.api.ZML_HwPlatform;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface HwCard extends HwComponent {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of HwCard
	 */
	static final TypeSelectPredicate<HwCard> type = new TypeSelectPredicate<HwCard>(
			"ZMLMM::ZML_HwPlatform::HwCard", //$NON-NLS-1$
			HwCard.class);
}
