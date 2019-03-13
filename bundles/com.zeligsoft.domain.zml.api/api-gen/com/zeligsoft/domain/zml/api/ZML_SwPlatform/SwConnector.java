package com.zeligsoft.domain.zml.api.ZML_SwPlatform;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface SwConnector extends SwCommunicationMedium {
	java.util.List<SwCommunicationEndPoint> getEnd();

	void addEnd(SwCommunicationEndPoint val);

	org.eclipse.uml2.uml.Connector asConnector();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of SwConnector
	 */
	static final TypeSelectPredicate<SwConnector> type = new TypeSelectPredicate<SwConnector>(
			"ZMLMM::ZML_SwPlatform::SwConnector", //$NON-NLS-1$
			SwConnector.class);
}
