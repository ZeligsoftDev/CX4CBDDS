package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.DCPS.Domain;
import com.zeligsoft.domain.omg.dds.api.Core.impl.NamedEntityZImpl;

import com.zeligsoft.domain.omg.dds.api.DCPS.DomainParticipant;
import com.zeligsoft.domain.omg.dds.api.DCPS.TopicConnector;
import com.zeligsoft.domain.omg.dds.api.DCPS.DomainTopic;

public class DomainZImpl extends NamedEntityZImpl implements Domain {
	protected java.util.List<TopicConnector> _connector;
	protected java.util.List<DomainTopic> _domainTopic;
	protected java.util.List<DomainParticipant> _participant;

	public DomainZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<TopicConnector> getConnector() {
		if (_connector == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::DCPS::Domain", "connector");
			_connector = new java.util.ArrayList<TopicConnector>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					TopicConnector nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									TopicConnector.class);
					_connector.add(nextWrapper);
				}
			}
		}
		return _connector;
	}

	@Override
	public java.util.List<DomainTopic> getDomainTopic() {
		if (_domainTopic == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::DCPS::Domain", "domainTopic");
			_domainTopic = new java.util.ArrayList<DomainTopic>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DomainTopic nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									DomainTopic.class);
					_domainTopic.add(nextWrapper);
				}
			}
		}
		return _domainTopic;
	}

	@Override
	public java.util.List<DomainParticipant> getParticipant() {
		if (_participant == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::DCPS::Domain", "participant");
			_participant = new java.util.ArrayList<DomainParticipant>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DomainParticipant nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									DomainParticipant.class);
					_participant.add(nextWrapper);
				}
			}
		}
		return _participant;
	}

	@Override
	public org.eclipse.uml2.uml.Component asComponent() {
		return (org.eclipse.uml2.uml.Component) eObject();
	}
}
