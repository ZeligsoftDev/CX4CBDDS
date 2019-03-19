package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.DCPS.TopicEnd;
import com.zeligsoft.domain.omg.dds.api.DCPS.impl.ConnectorEndZImpl;

import com.zeligsoft.domain.omg.dds.api.DCPS.DomainTopic;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class TopicEndZImpl extends ConnectorEndZImpl implements TopicEnd {
	protected DomainTopic _topic;

	public TopicEndZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public DomainTopic getTopic() {
		if (_topic == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::DCPS::TopicEnd", "topic");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_topic = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						DomainTopic.class);
			}
		}
		return _topic;
	}

	@Override
	public void setTopic(DomainTopic val) {
		ZDLUtil.setValue(element, "DDS::DCPS::TopicEnd", "topic", val.eObject());
	}

}
