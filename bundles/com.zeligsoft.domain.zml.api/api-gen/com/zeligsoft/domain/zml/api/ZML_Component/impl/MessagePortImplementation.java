package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.zml.api.ZML_Component.MessagePort;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.PortImplementation;

import com.zeligsoft.domain.zml.api.ZML_Core.Type;
import com.zeligsoft.domain.zml.api.ZML_Component.Interface;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class MessagePortImplementation extends PortImplementation implements
		MessagePort {
	protected Type _type;
	protected java.util.List<Interface> _providedInterface;
	protected java.util.List<Interface> _requiredInterface;

	public MessagePortImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Type getType() {
		if (_type == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_Component::MessagePort",
							"type");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue, Type.class);
			}
		}
		return _type;
	}

	@Override
	public void setType(Type val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::MessagePort", "type",
				val.eObject());
	}

	@Override
	public java.util.List<Interface> getProvidedInterface() {
		if (_providedInterface == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_Component::MessagePort",
							"providedInterface");
			_providedInterface = new java.util.ArrayList<Interface>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					Interface nextWrapper = ZDLFactoryRegistry.INSTANCE.create(
							(org.eclipse.emf.ecore.EObject) next,
							Interface.class);
					_providedInterface.add(nextWrapper);
				}
			}
		}
		return _providedInterface;
	}

	@Override
	public java.util.List<Interface> getRequiredInterface() {
		if (_requiredInterface == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_Component::MessagePort",
							"requiredInterface");
			_requiredInterface = new java.util.ArrayList<Interface>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					Interface nextWrapper = ZDLFactoryRegistry.INSTANCE.create(
							(org.eclipse.emf.ecore.EObject) next,
							Interface.class);
					_requiredInterface.add(nextWrapper);
				}
			}
		}
		return _requiredInterface;
	}

}
