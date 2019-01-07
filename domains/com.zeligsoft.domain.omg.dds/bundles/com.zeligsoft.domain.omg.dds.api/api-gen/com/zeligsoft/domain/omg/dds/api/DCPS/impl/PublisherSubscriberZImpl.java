package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.DCPS.PublisherSubscriber;
import com.zeligsoft.domain.omg.dds.api.Core.impl.NamedEntityZImpl;

import com.zeligsoft.domain.omg.dds.api.DCPS.DataReaderWriter;

public abstract class PublisherSubscriberZImpl extends NamedEntityZImpl
		implements PublisherSubscriber {
	protected java.util.List<DataReaderWriter> _data;

	public PublisherSubscriberZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<DataReaderWriter> getData() {
		if (_data == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::DCPS::PublisherSubscriber",
							"data");
			_data = new java.util.ArrayList<DataReaderWriter>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DataReaderWriter nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									DataReaderWriter.class);
					_data.add(nextWrapper);
				}
			}
		}
		return _data;
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
