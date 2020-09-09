package com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.InterfacePort;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.MessagePortImplementation;

import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class InterfacePortImplementation extends MessagePortImplementation implements InterfacePort {
	protected ComponentInterface _connectorType;

	public InterfacePortImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public ComponentInterface getConnectorType() {
		if (_connectorType == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CCM::CCM_Component::InterfacePort", "connectorType");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_connectorType = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						ComponentInterface.class);
			}
		}
		return _connectorType;
	}

	@Override
	public void setConnectorType(ComponentInterface val) {
		ZDLUtil.setValue(element, "CCM::CCM_Component::InterfacePort", "connectorType", val.eObject());
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
	public Boolean getHasCSL() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
				"CCM::CCM_Component::InterfacePort", "hasCSL");
		return (Boolean) rawValue;
	}

	@Override
	public void setHasCSL(Boolean val) {
		ZDLUtil.setValue(element, "CCM::CCM_Component::InterfacePort", "hasCSL", val);
	}

	@Override
	public String getUuid() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
				"ZMLMM::ZML_Component::WorkerFunctionIdentifiable", "uuid");
		return (String) rawValue;
	}

	@Override
	public void setUuid(String val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::WorkerFunctionIdentifiable", "uuid", val);
	}

	@Override
	public Boolean getIsAsynchronous() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
				"CCM::CCM_Component::InterfacePort", "isAsynchronous");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsAsynchronous(Boolean val) {
		ZDLUtil.setValue(element, "CCM::CCM_Component::InterfacePort", "isAsynchronous", val);
	}

}
