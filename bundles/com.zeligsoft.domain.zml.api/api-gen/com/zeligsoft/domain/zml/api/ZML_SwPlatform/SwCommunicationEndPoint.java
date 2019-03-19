package com.zeligsoft.domain.zml.api.ZML_SwPlatform;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface SwCommunicationEndPoint extends ZObject {
	org.eclipse.uml2.uml.ConnectableElement asConnectableElement();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of SwCommunicationEndPoint
	 */
	static final TypeSelectPredicate<SwCommunicationEndPoint> type = new TypeSelectPredicate<SwCommunicationEndPoint>(
			"ZMLMM::ZML_SwPlatform::SwCommunicationEndPoint", //$NON-NLS-1$
			SwCommunicationEndPoint.class);
}
