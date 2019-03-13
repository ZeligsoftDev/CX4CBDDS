package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.DCPS.TopicConnector;
import com.zeligsoft.domain.omg.dds.api.Core.impl.NamedEntityZImpl;

import com.zeligsoft.domain.omg.dds.api.DCPS.ConnectorEnd;

public class TopicConnectorZImpl extends NamedEntityZImpl implements
		TopicConnector {
	protected java.util.List<ConnectorEnd> _end;

	public TopicConnectorZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<ConnectorEnd> getEnd() {
		if (_end == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::DCPS::TopicConnector", "end");
			_end = new java.util.ArrayList<ConnectorEnd>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					ConnectorEnd nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									ConnectorEnd.class);
					_end.add(nextWrapper);
				}
			}
		}
		return _end;
	}

	@Override
	public org.eclipse.uml2.uml.Connector asConnector() {
		return (org.eclipse.uml2.uml.Connector) eObject();
	}
}
