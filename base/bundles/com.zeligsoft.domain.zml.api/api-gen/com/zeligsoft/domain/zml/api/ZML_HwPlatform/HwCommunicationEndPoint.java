package com.zeligsoft.domain.zml.api.ZML_HwPlatform;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface HwCommunicationEndPoint extends ZObject {
	org.eclipse.uml2.uml.ConnectableElement asConnectableElement();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of HwCommunicationEndPoint
	 */
	static final TypeSelectPredicate<HwCommunicationEndPoint> type = new TypeSelectPredicate<HwCommunicationEndPoint>(
			"ZMLMM::ZML_HwPlatform::HwCommunicationEndPoint", //$NON-NLS-1$
			HwCommunicationEndPoint.class);
}
