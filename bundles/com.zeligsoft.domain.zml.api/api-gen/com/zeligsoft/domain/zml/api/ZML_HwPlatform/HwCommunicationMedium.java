package com.zeligsoft.domain.zml.api.ZML_HwPlatform;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface HwCommunicationMedium extends ZObject {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of HwCommunicationMedium
	 */
	static final TypeSelectPredicate<HwCommunicationMedium> type = new TypeSelectPredicate<HwCommunicationMedium>(
			"ZMLMM::ZML_HwPlatform::HwCommunicationMedium", //$NON-NLS-1$
			HwCommunicationMedium.class);
}
