package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.DCPS.Domain;
import com.zeligsoft.domain.omg.dds.api.Core.impl.NamedEntityZImpl;

import com.zeligsoft.domain.omg.dds.api.DCPS.DomainParticipant;
import com.zeligsoft.domain.omg.dds.api.DCPS.TopicConnector;
import com.zeligsoft.domain.omg.dds.api.DCPS.DomainTopic;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DomainZImpl extends NamedEntityZImpl implements Domain {
	protected java.util.List<DomainTopic> _domainTopic;
	protected java.util.List<TopicConnector> _connector;
	protected java.util.List<DomainParticipant> _participant;

	public DomainZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<DomainTopic> getDomainTopic() {
		if (_domainTopic == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::DCPS::Domain",
					"domainTopic");
			_domainTopic = new java.util.ArrayList<DomainTopic>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DomainTopic nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							DomainTopic.class);
					_domainTopic.add(nextWrapper);
				}
			}
		}
		return _domainTopic;
	}

	@Override
	public void addDomainTopic(DomainTopic val) {
		// make sure the domainTopic list is created
		getDomainTopic();

		final Object rawValue = ZDLUtil.getValue(element, "DDS::DCPS::Domain", "domainTopic");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_domainTopic != null) {
			_domainTopic.add(val);
		}
	}

	@Override
	public <T extends DomainTopic> T addDomainTopic(Class<T> typeToCreate, String concept) {
		// make sure the domainTopic list is created
		getDomainTopic();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::DCPS::Domain", "domainTopic",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_domainTopic != null) {
			_domainTopic.add(element);
		}
		return element;
	}

	@Override
	public DomainTopic addDomainTopic() {
		// make sure the domainTopic list is created
		getDomainTopic();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::DCPS::Domain", "domainTopic",
				"DDS::DCPS::DomainTopic");
		DomainTopic element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				DomainTopic.class);
		if (_domainTopic != null) {
			_domainTopic.add(element);
		}
		return element;
	}

	@Override
	public java.util.List<TopicConnector> getConnector() {
		if (_connector == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::DCPS::Domain",
					"connector");
			_connector = new java.util.ArrayList<TopicConnector>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					TopicConnector nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next, TopicConnector.class);
					_connector.add(nextWrapper);
				}
			}
		}
		return _connector;
	}

	@Override
	public void addConnector(TopicConnector val) {
		// make sure the connector list is created
		getConnector();

		final Object rawValue = ZDLUtil.getValue(element, "DDS::DCPS::Domain", "connector");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_connector != null) {
			_connector.add(val);
		}
	}

	@Override
	public <T extends TopicConnector> T addConnector(Class<T> typeToCreate, String concept) {
		// make sure the connector list is created
		getConnector();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::DCPS::Domain", "connector",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_connector != null) {
			_connector.add(element);
		}
		return element;
	}

	@Override
	public TopicConnector addConnector() {
		// make sure the connector list is created
		getConnector();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::DCPS::Domain", "connector",
				"DDS::DCPS::TopicConnector");
		TopicConnector element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				TopicConnector.class);
		if (_connector != null) {
			_connector.add(element);
		}
		return element;
	}

	@Override
	public java.util.List<DomainParticipant> getParticipant() {
		if (_participant == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::DCPS::Domain",
					"participant");
			_participant = new java.util.ArrayList<DomainParticipant>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DomainParticipant nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next, DomainParticipant.class);
					_participant.add(nextWrapper);
				}
			}
		}
		return _participant;
	}

	@Override
	public void addParticipant(DomainParticipant val) {
		// make sure the participant list is created
		getParticipant();

		final Object rawValue = ZDLUtil.getValue(element, "DDS::DCPS::Domain", "participant");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_participant != null) {
			_participant.add(val);
		}
	}

	@Override
	public <T extends DomainParticipant> T addParticipant(Class<T> typeToCreate, String concept) {
		// make sure the participant list is created
		getParticipant();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::DCPS::Domain", "participant",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_participant != null) {
			_participant.add(element);
		}
		return element;
	}

	@Override
	public DomainParticipant addParticipant() {
		// make sure the participant list is created
		getParticipant();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::DCPS::Domain", "participant",
				"DDS::DCPS::DomainParticipant");
		DomainParticipant element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				DomainParticipant.class);
		if (_participant != null) {
			_participant.add(element);
		}
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.Component asComponent() {
		return (org.eclipse.uml2.uml.Component) eObject();
	}
}
