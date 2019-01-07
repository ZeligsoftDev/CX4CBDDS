package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;

import com.zeligsoft.domain.zml.api.ZML_Component.Port;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ComponentInterfaceImplementation extends ZObjectImpl implements
		ComponentInterface {
	protected java.util.List<Port> _ownedPort;

	public ComponentInterfaceImplementation(
			org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<Port> getOwnedPort() {
		if (_ownedPort == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::ComponentInterface",
							"ownedPort");
			_ownedPort = new java.util.ArrayList<Port>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					Port nextWrapper = ZDLFactoryRegistry.INSTANCE.create(
							(org.eclipse.emf.ecore.EObject) next, Port.class);
					_ownedPort.add(nextWrapper);
				}
			}
		}
		return _ownedPort;
	}

	@Override
	public void addOwnedPort(Port val) {
		// make sure the ownedPort list is created
		getOwnedPort();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Component::ComponentInterface", "ownedPort");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_ownedPort != null) {
			_ownedPort.add(val);
		}
	}

	@Override
	public <T extends Port> T addOwnedPort(Class<T> typeToCreate, String concept) {
		// make sure the ownedPort list is created
		getOwnedPort();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::ComponentInterface",
				"ownedPort", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_ownedPort != null) {
			_ownedPort.add(element);
		}
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.Component asComponent() {
		return (org.eclipse.uml2.uml.Component) eObject();
	}
}
