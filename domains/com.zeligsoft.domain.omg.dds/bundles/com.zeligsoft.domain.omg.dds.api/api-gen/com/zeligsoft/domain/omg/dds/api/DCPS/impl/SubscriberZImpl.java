package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.DCPS.Subscriber;
import com.zeligsoft.domain.omg.dds.api.DCPS.impl.PublisherSubscriberZImpl;

import com.zeligsoft.domain.omg.dds.api.DCPS.DataReader;

public class SubscriberZImpl extends PublisherSubscriberZImpl implements
		Subscriber {
	protected java.util.List<DataReader> _readers;

	public SubscriberZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<DataReader> getReaders() {
		if (_readers == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::DCPS::Subscriber", "readers");
			_readers = new java.util.ArrayList<DataReader>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DataReader nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									DataReader.class);
					_readers.add(nextWrapper);
				}
			}
		}
		return _readers;
	}

}
