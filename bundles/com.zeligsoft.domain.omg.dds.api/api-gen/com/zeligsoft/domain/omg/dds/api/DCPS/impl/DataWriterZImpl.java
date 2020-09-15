package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.DCPS.DataWriter;
import com.zeligsoft.domain.omg.dds.api.DCPS.impl.DataReaderWriterZImpl;

import com.zeligsoft.domain.omg.dds.api.Topics.Topic;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DataWriterZImpl extends DataReaderWriterZImpl implements DataWriter {
	protected Topic _topic;

	public DataWriterZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Topic getTopic() {
		if (_topic == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::DCPS::DataWriter",
					"topic");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_topic = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue, Topic.class);
			}
		}
		return _topic;
	}

	@Override
	public void setTopic(Topic val) {
		ZDLUtil.setValue(element, "DDS::DCPS::DataWriter", "topic", val.eObject());
	}

}
