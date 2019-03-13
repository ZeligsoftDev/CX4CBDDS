package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.zml.api.ZML_Component.InterfaceRealization;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.zml.api.ZML_Component.Interface;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class InterfaceRealizationImplementation extends
		NamedElementImplementation implements InterfaceRealization {
	protected Interface _target;

	public InterfaceRealizationImplementation(
			org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Interface getTarget() {
		if (_target == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::InterfaceRealization",
							"target");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_target = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						Interface.class);
			}
		}
		return _target;
	}

	@Override
	public void setTarget(Interface val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::InterfaceRealization",
				"target", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.InterfaceRealization asInterfaceRealization() {
		return (org.eclipse.uml2.uml.InterfaceRealization) eObject();
	}
}
