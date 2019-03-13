package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.DCPS.Publisher;
import com.zeligsoft.domain.omg.dds.api.DCPS.impl.PublisherSubscriberZImpl;

import com.zeligsoft.domain.omg.dds.api.DCPS.DataWriter;

public class PublisherZImpl extends PublisherSubscriberZImpl implements
		Publisher {
	protected java.util.List<DataWriter> _writers;

	public PublisherZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<DataWriter> getWriters() {
		if (_writers == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::DCPS::Publisher", "writers");
			_writers = new java.util.ArrayList<DataWriter>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DataWriter nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									DataWriter.class);
					_writers.add(nextWrapper);
				}
			}
		}
		return _writers;
	}

}
