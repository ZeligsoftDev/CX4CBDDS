package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.DCPS.Subscriber;
import com.zeligsoft.domain.omg.dds.api.DCPS.impl.PublisherSubscriberZImpl;

import com.zeligsoft.domain.omg.dds.api.DCPS.DataReader;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class SubscriberZImpl extends PublisherSubscriberZImpl implements Subscriber {
	protected java.util.List<DataReader> _readers;

	public SubscriberZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<DataReader> getReaders() {
		if (_readers == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::DCPS::Subscriber",
					"readers");
			_readers = new java.util.ArrayList<DataReader>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DataReader nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							DataReader.class);
					_readers.add(nextWrapper);
				}
			}
		}
		return _readers;
	}

	@Override
	public void addReaders(DataReader val) {
		// make sure the readers list is created
		getReaders();

		final Object rawValue = ZDLUtil.getValue(element, "DDS::DCPS::Subscriber", "readers");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_readers != null) {
			_readers.add(val);
		}
	}

	@Override
	public <T extends DataReader> T addReaders(Class<T> typeToCreate, String concept) {
		// make sure the readers list is created
		getReaders();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::DCPS::Subscriber", "readers",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_readers != null) {
			_readers.add(element);
		}
		return element;
	}

	@Override
	public DataReader addReaders() {
		// make sure the readers list is created
		getReaders();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::DCPS::Subscriber", "readers",
				"DDS::DCPS::DataReader");
		DataReader element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				DataReader.class);
		if (_readers != null) {
			_readers.add(element);
		}
		return element;
	}

}
