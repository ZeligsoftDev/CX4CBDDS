package com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwBus;
import com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl.HwCommunicationMediumImplementation;

import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwPort;
import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwConnector;
import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwPart;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class HwBusImplementation extends HwCommunicationMediumImplementation
		implements HwBus {
	protected java.util.List<HwConnector> _connector;
	protected java.util.List<HwPort> _port;
	protected java.util.List<HwPart> _part;

	public HwBusImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<HwConnector> getConnector() {
		if (_connector == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_HwPlatform::HwComponent",
							"connector");
			_connector = new java.util.ArrayList<HwConnector>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					HwConnector nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									HwConnector.class);
					_connector.add(nextWrapper);
				}
			}
		}
		return _connector;
	}

	@Override
	public void addConnector(HwConnector val) {
		// make sure the connector list is created
		getConnector();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_HwPlatform::HwComponent", "connector");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_connector != null) {
			_connector.add(val);
		}
	}

	@Override
	public <T extends HwConnector> T addConnector(Class<T> typeToCreate,
			String concept) {
		// make sure the connector list is created
		getConnector();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_HwPlatform::HwComponent", "connector",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_connector != null) {
			_connector.add(element);
		}
		return element;
	}

	@Override
	public HwConnector addConnector() {
		// make sure the connector list is created
		getConnector();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_HwPlatform::HwComponent", "connector",
				"ZMLMM::ZML_HwPlatform::HwConnector");
		HwConnector element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, HwConnector.class);
		if (_connector != null) {
			_connector.add(element);
		}
		return element;
	}

	@Override
	public java.util.List<HwPort> getPort() {
		if (_port == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_HwPlatform::HwComponent",
							"port");
			_port = new java.util.ArrayList<HwPort>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					HwPort nextWrapper = ZDLFactoryRegistry.INSTANCE.create(
							(org.eclipse.emf.ecore.EObject) next, HwPort.class);
					_port.add(nextWrapper);
				}
			}
		}
		return _port;
	}

	@Override
	public void addPort(HwPort val) {
		// make sure the port list is created
		getPort();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_HwPlatform::HwComponent", "port");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_port != null) {
			_port.add(val);
		}
	}

	@Override
	public <T extends HwPort> T addPort(Class<T> typeToCreate, String concept) {
		// make sure the port list is created
		getPort();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_HwPlatform::HwComponent", "port", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_port != null) {
			_port.add(element);
		}
		return element;
	}

	@Override
	public HwPort addPort() {
		// make sure the port list is created
		getPort();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_HwPlatform::HwComponent", "port",
				"ZMLMM::ZML_HwPlatform::HwPort");
		HwPort element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, HwPort.class);
		if (_port != null) {
			_port.add(element);
		}
		return element;
	}

	@Override
	public java.util.List<HwPart> getPart() {
		if (_part == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_HwPlatform::HwComponent",
							"part");
			_part = new java.util.ArrayList<HwPart>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					HwPart nextWrapper = ZDLFactoryRegistry.INSTANCE.create(
							(org.eclipse.emf.ecore.EObject) next, HwPart.class);
					_part.add(nextWrapper);
				}
			}
		}
		return _part;
	}

	@Override
	public void addPart(HwPart val) {
		// make sure the part list is created
		getPart();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_HwPlatform::HwComponent", "part");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_part != null) {
			_part.add(val);
		}
	}

	@Override
	public <T extends HwPart> T addPart(Class<T> typeToCreate, String concept) {
		// make sure the part list is created
		getPart();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_HwPlatform::HwComponent", "part", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_part != null) {
			_part.add(element);
		}
		return element;
	}

	@Override
	public HwPart addPart() {
		// make sure the part list is created
		getPart();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_HwPlatform::HwComponent", "part",
				"ZMLMM::ZML_HwPlatform::HwPart");
		HwPart element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, HwPart.class);
		if (_part != null) {
			_part.add(element);
		}
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.ConnectableElement asConnectableElement() {
		return (org.eclipse.uml2.uml.ConnectableElement) eObject();
	}

	@Override
	public org.eclipse.uml2.uml.Component asComponent() {
		return (org.eclipse.uml2.uml.Component) eObject();
	}
}
