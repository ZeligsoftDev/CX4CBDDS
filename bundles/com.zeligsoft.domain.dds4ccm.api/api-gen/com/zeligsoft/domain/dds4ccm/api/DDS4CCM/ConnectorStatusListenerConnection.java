package com.zeligsoft.domain.dds4ccm.api.DDS4CCM;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.CCMConnector;

public interface ConnectorStatusListenerConnection extends CCMConnector {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of ConnectorStatusListenerConnection
	 */
	static final TypeSelectPredicate<ConnectorStatusListenerConnection> type = new TypeSelectPredicate<ConnectorStatusListenerConnection>(
			"DDS4CCM::DDS4CCM::ConnectorStatusListenerConnection", //$NON-NLS-1$
			ConnectorStatusListenerConnection.class); 
}
