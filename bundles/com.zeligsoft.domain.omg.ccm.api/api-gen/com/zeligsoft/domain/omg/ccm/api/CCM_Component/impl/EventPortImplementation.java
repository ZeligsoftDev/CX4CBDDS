package com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.EventPort;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.PortImplementation;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Event;
import com.zeligsoft.domain.zml.api.ZML_Core.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class EventPortImplementation extends PortImplementation implements EventPort {
	protected java.util.List<Event> _consumesEvent;
	protected java.util.List<Event> _publishesEvent;
	protected Type _type;

	public EventPortImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<Event> getConsumesEvent() {
		if (_consumesEvent == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CCM::CCM_Component::EventPort", "consumesEvent");
			_consumesEvent = new java.util.ArrayList<Event>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					Event nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							Event.class);
					_consumesEvent.add(nextWrapper);
				}
			}
		}
		return _consumesEvent;
	}

	@Override
	public void addConsumesEvent(Event val) {
		// make sure the consumesEvent list is created
		getConsumesEvent();

		final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::EventPort", "consumesEvent");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_consumesEvent != null) {
			_consumesEvent.add(val);
		}
	}

	@Override
	public Boolean getIsConjugated() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
				"ZMLMM::ZML_Component::ConjugatedPort", "isConjugated");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsConjugated(Boolean val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::ConjugatedPort", "isConjugated", val);
	}

	@Override
	public java.util.List<Event> getPublishesEvent() {
		if (_publishesEvent == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CCM::CCM_Component::EventPort", "publishesEvent");
			_publishesEvent = new java.util.ArrayList<Event>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					Event nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							Event.class);
					_publishesEvent.add(nextWrapper);
				}
			}
		}
		return _publishesEvent;
	}

	@Override
	public void addPublishesEvent(Event val) {
		// make sure the publishesEvent list is created
		getPublishesEvent();

		final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::EventPort", "publishesEvent");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_publishesEvent != null) {
			_publishesEvent.add(val);
		}
	}

	@Override
	public Type getType() {
		if (_type == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CCM::CCM_Component::EventPort", "type");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue, Type.class);
			}
		}
		return _type;
	}

	@Override
	public void setType(Type val) {
		ZDLUtil.setValue(element, "CCM::CCM_Component::EventPort", "type", val.eObject());
	}

}
