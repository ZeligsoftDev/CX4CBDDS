package com.zeligsoft.domain.zml.api.ZML_SwPlatform.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.zml.api.ZML_SwPlatform.SwBus;
import com.zeligsoft.domain.zml.api.ZML_SwPlatform.impl.SwCommunicationEndPointImplementation;

import com.zeligsoft.domain.zml.api.ZML_SwPlatform.SwPort;
import com.zeligsoft.domain.zml.api.ZML_SwPlatform.SwPart;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class SwBusImplementation extends SwCommunicationEndPointImplementation
		implements SwBus {
	protected java.util.List<SwPort> _port;
	protected java.util.List<SwPart> _part;

	public SwBusImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<SwPort> getPort() {
		if (_port == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_SwPlatform::SwComponent",
							"port");
			_port = new java.util.ArrayList<SwPort>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					SwPort nextWrapper = ZDLFactoryRegistry.INSTANCE.create(
							(org.eclipse.emf.ecore.EObject) next, SwPort.class);
					_port.add(nextWrapper);
				}
			}
		}
		return _port;
	}

	@Override
	public void addPort(SwPort val) {
		// make sure the port list is created
		getPort();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_SwPlatform::SwComponent", "port");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_port != null) {
			_port.add(val);
		}
	}

	@Override
	public <T extends SwPort> T addPort(Class<T> typeToCreate, String concept) {
		// make sure the port list is created
		getPort();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_SwPlatform::SwComponent", "port", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_port != null) {
			_port.add(element);
		}
		return element;
	}

	@Override
	public SwPort addPort() {
		// make sure the port list is created
		getPort();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_SwPlatform::SwComponent", "port",
				"ZMLMM::ZML_SwPlatform::SwPort");
		SwPort element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, SwPort.class);
		if (_port != null) {
			_port.add(element);
		}
		return element;
	}

	@Override
	public java.util.List<SwPart> getPart() {
		if (_part == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_SwPlatform::SwComponent",
							"part");
			_part = new java.util.ArrayList<SwPart>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					SwPart nextWrapper = ZDLFactoryRegistry.INSTANCE.create(
							(org.eclipse.emf.ecore.EObject) next, SwPart.class);
					_part.add(nextWrapper);
				}
			}
		}
		return _part;
	}

	@Override
	public void addPart(SwPart val) {
		// make sure the part list is created
		getPart();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_SwPlatform::SwComponent", "part");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_part != null) {
			_part.add(val);
		}
	}

	@Override
	public <T extends SwPart> T addPart(Class<T> typeToCreate, String concept) {
		// make sure the part list is created
		getPart();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_SwPlatform::SwComponent", "part", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_part != null) {
			_part.add(element);
		}
		return element;
	}

	@Override
	public SwPart addPart() {
		// make sure the part list is created
		getPart();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_SwPlatform::SwComponent", "part",
				"ZMLMM::ZML_SwPlatform::SwPart");
		SwPart element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, SwPart.class);
		if (_part != null) {
			_part.add(element);
		}
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.Component asComponent() {
		return (org.eclipse.uml2.uml.Component) eObject();
	}
}
