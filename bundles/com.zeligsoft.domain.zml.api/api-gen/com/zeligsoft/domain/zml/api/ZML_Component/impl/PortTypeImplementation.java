package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.zml.api.ZML_Component.PortType;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.TypeImplementation;

import com.zeligsoft.domain.zml.api.ZML_Component.InterfaceRealization;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class PortTypeImplementation extends TypeImplementation implements
		PortType {
	protected PortType _inverse;
	protected java.util.List<InterfaceRealization> _providedInterfaces;

	public PortTypeImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public PortType getInverse() {
		if (_inverse == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_Component::PortType",
							"inverse");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_inverse = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						PortType.class);
			}
		}
		return _inverse;
	}

	@Override
	public void setInverse(PortType val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::PortType", "inverse",
				val.eObject());
	}

	@Override
	public java.util.List<InterfaceRealization> getProvidedInterfaces() {
		if (_providedInterfaces == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_Component::PortType",
							"providedInterfaces");
			_providedInterfaces = new java.util.ArrayList<InterfaceRealization>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					InterfaceRealization nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									InterfaceRealization.class);
					_providedInterfaces.add(nextWrapper);
				}
			}
		}
		return _providedInterfaces;
	}

	@Override
	public void addProvidedInterfaces(InterfaceRealization val) {
		// make sure the providedInterfaces list is created
		getProvidedInterfaces();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Component::PortType", "providedInterfaces");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_providedInterfaces != null) {
			_providedInterfaces.add(val);
		}
	}

	@Override
	public <T extends InterfaceRealization> T addProvidedInterfaces(
			Class<T> typeToCreate, String concept) {
		// make sure the providedInterfaces list is created
		getProvidedInterfaces();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::PortType",
				"providedInterfaces", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_providedInterfaces != null) {
			_providedInterfaces.add(element);
		}
		return element;
	}

	@Override
	public InterfaceRealization addProvidedInterfaces() {
		// make sure the providedInterfaces list is created
		getProvidedInterfaces();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::PortType",
				"providedInterfaces",
				"ZMLMM::ZML_Component::InterfaceRealization");
		InterfaceRealization element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept,
				InterfaceRealization.class);
		if (_providedInterfaces != null) {
			_providedInterfaces.add(element);
		}
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
