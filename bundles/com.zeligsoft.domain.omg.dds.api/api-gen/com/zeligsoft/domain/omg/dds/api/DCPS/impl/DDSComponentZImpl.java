package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.DCPS.DDSComponent;
import com.zeligsoft.domain.omg.dds.api.Core.impl.NamedEntityZImpl;

import com.zeligsoft.domain.omg.dds.api.DCPS.TopicConnector;
import com.zeligsoft.domain.omg.dds.api.DCPS.ComponentPart;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DDSComponentZImpl extends NamedEntityZImpl implements DDSComponent {
	protected java.util.List<TopicConnector> _topicConnector;
	protected ComponentPart _participants;

	public DDSComponentZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
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
	public void addTopicConnector(TopicConnector val) {
		// make sure the topicConnector list is created
		getTopicConnector();

		final Object rawValue = ZDLUtil.getValue(element,
				"DDS::DCPS::DDSComponent", "topicConnector");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_topicConnector != null) {
			_topicConnector.add(val);
		}
	}

	@Override
	public <T extends TopicConnector> T addTopicConnector(
			Class<T> typeToCreate, String concept) {
		// make sure the topicConnector list is created
		getTopicConnector();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "DDS::DCPS::DDSComponent", "topicConnector", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_topicConnector != null) {
			_topicConnector.add(element);
		}
		return element;
	}

	@Override
	public TopicConnector addTopicConnector() {
		// make sure the topicConnector list is created
		getTopicConnector();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "DDS::DCPS::DDSComponent", "topicConnector",
				"DDS::DCPS::TopicConnector");
		TopicConnector element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept,
				TopicConnector.class);
		if (_topicConnector != null) {
			_topicConnector.add(element);
		}
		return element;
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
	public void setParticipants(ComponentPart val) {
		ZDLUtil.setValue(element, "DDS::DCPS::DDSComponent", "participants",
				val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Component asComponent() {
		return (org.eclipse.uml2.uml.Component) eObject();
	}
}
