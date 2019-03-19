package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.dds.api.DCPS.ConnectorEnd;

public abstract class ConnectorEndZImpl extends ZObjectImpl implements
		ConnectorEnd {
	public ConnectorEndZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.ConnectorEnd asConnectorEnd() {
		return (org.eclipse.uml2.uml.ConnectorEnd) eObject();
	}
}
