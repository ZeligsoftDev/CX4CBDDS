package com.zeligsoft.domain.zml.api.ZML_HwPlatform;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface HwPort extends HwCommunicationEndPoint {
	org.eclipse.uml2.uml.Port asPort();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of HwPort
	 */
	static final TypeSelectPredicate<HwPort> type = new TypeSelectPredicate<HwPort>(
			"ZMLMM::ZML_HwPlatform::HwPort", //$NON-NLS-1$
			HwPort.class);
}
