package com.zeligsoft.domain.dds4ccm.api.DDS4CCM.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.ConnectorStatusListenerConnection;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.impl.CCMConnectorImplementation;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ConnectorStatusListenerConnectionZImpl extends
		CCMConnectorImplementation implements ConnectorStatusListenerConnection {
	public ConnectorStatusListenerConnectionZImpl(
			org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

}
