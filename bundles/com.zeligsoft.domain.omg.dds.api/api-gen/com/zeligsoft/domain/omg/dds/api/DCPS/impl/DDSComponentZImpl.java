package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.DCPS.DDSComponent;
import com.zeligsoft.domain.omg.dds.api.Core.impl.NamedEntityZImpl;

import com.zeligsoft.domain.omg.dds.api.DCPS.TopicConnector;
import com.zeligsoft.domain.omg.dds.api.DCPS.ComponentPart;

public class DDSComponentZImpl extends NamedEntityZImpl implements DDSComponent {
	protected ComponentPart _participants;
	protected java.util.List<TopicConnector> _topicConnector;

	public DDSComponentZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public ComponentPart getParticipants() {
		if (_participants == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::DCPS::DDSComponent",
							"participants");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_participants = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						ComponentPart.class);
			}
		}
		return _participants;
	}

	@Override
	public java.util.List<TopicConnector> getTopicConnector() {
		if (_topicConnector == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::DCPS::DDSComponent",
							"topicConnector");
			_topicConnector = new java.util.ArrayList<TopicConnector>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					TopicConnector nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									TopicConnector.class);
					_topicConnector.add(nextWrapper);
				}
			}
		}
		return _topicConnector;
	}

	@Override
	public org.eclipse.uml2.uml.Component asComponent() {
		return (org.eclipse.uml2.uml.Component) eObject();
	}
}
