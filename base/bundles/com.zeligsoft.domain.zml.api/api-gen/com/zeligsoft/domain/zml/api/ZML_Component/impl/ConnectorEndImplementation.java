package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_Component.ConnectorEnd;

import com.zeligsoft.domain.zml.api.ZML_Component.Port;
import com.zeligsoft.domain.zml.api.ZML_Component.Part;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ConnectorEndImplementation extends ZObjectImpl implements
		ConnectorEnd {
	protected Port _port;
	protected Part _part;
	protected Part _partWithPort;

	public ConnectorEndImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Port getPort() {
		if (_port == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_Component::ConnectorEnd",
							"port");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_port = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue, Port.class);
			}
		}
		return _port;
	}

	@Override
	public void setPort(Port val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::ConnectorEnd", "port",
				val.eObject());
	}

	@Override
	public Part getPart() {
		if (_part == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_Component::ConnectorEnd",
							"part");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_part = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue, Part.class);
			}
		}
		return _part;
	}

	@Override
	public void setPart(Part val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::ConnectorEnd", "part",
				val.eObject());
	}

	@Override
	public Part getPartWithPort() {
		if (_partWithPort == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_Component::ConnectorEnd",
							"partWithPort");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_partWithPort = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue, Part.class);
			}
		}
		return _partWithPort;
	}

	@Override
	public void setPartWithPort(Part val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::ConnectorEnd",
				"partWithPort", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.ConnectorEnd asConnectorEnd() {
		return (org.eclipse.uml2.uml.ConnectorEnd) eObject();
	}
}
