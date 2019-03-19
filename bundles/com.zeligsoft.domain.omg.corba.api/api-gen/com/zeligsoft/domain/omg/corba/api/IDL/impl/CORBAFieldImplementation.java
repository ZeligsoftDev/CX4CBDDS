package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAField;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBABound;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CORBAFieldImplementation extends CORBANamedElementImplementation
		implements CORBAField {
	protected java.util.List<CORBABound> _bounds;
	protected CORBAType _idlType;

	public CORBAFieldImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<CORBABound> getBounds() {
		if (_bounds == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CORBADomain::IDL::CORBAField",
							"bounds");
			_bounds = new java.util.ArrayList<CORBABound>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CORBABound nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									CORBABound.class);
					_bounds.add(nextWrapper);
				}
			}
		}
		return _bounds;
	}

	@Override
	public void addBounds(CORBABound val) {
		// make sure the bounds list is created
		getBounds();

		final Object rawValue = ZDLUtil.getValue(element,
				"CORBADomain::IDL::CORBAField", "bounds");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_bounds != null) {
			_bounds.add(val);
		}
	}

	@Override
	public <T extends CORBABound> T addBounds(Class<T> typeToCreate,
			String concept) {
		// make sure the bounds list is created
		getBounds();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CORBADomain::IDL::CORBAField", "bounds", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_bounds != null) {
			_bounds.add(element);
		}
		return element;
	}

	@Override
	public CORBABound addBounds() {
		// make sure the bounds list is created
		getBounds();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CORBADomain::IDL::CORBAField", "bounds",
				"CORBADomain::IDL::CORBABound");
		CORBABound element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, CORBABound.class);
		if (_bounds != null) {
			_bounds.add(element);
		}
		return element;
	}

	@Override
	public String getBound() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "CORBADomain::IDL::CORBAField", "bound");
		return (String) rawValue;
	}

	@Override
	public void setBound(String val) {
		ZDLUtil.setValue(element, "CORBADomain::IDL::CORBAField", "bound", val);
	}

	@Override
	public CORBAType getIdlType() {
		if (_idlType == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CORBADomain::IDL::CORBATyped",
							"idlType");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_idlType = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						CORBAType.class);
			}
		}
		return _idlType;
	}

	@Override
	public void setIdlType(CORBAType val) {
		ZDLUtil.setValue(element, "CORBADomain::IDL::CORBATyped", "idlType",
				val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
