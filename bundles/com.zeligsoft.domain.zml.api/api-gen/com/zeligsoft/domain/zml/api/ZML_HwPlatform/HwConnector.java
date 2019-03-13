package com.zeligsoft.domain.zml.api.ZML_HwPlatform;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface HwConnector extends HwCommunicationMedium {
	java.util.List<HwCommunicationEndPoint> getEnd();

	void addEnd(HwCommunicationEndPoint val);

	org.eclipse.uml2.uml.Connector asConnector();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of HwConnector
	 */
	static final TypeSelectPredicate<HwConnector> type = new TypeSelectPredicate<HwConnector>(
			"ZMLMM::ZML_HwPlatform::HwConnector", //$NON-NLS-1$
			HwConnector.class);
}
