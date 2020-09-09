package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CXField;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXNamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXBound;
import com.zeligsoft.domain.omg.corba.api.IDL.CXType;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CXFieldImplementation extends CXNamedElementImplementation implements CXField {
	protected CXType _idlType;
	protected java.util.List<CXBound> _bounds;

	public CXFieldImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getBound() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXField",
				"bound");
		return (String) rawValue;
	}

	@Override
	public void setBound(String val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXField", "bound", val);
	}

	@Override
	public CXType getIdlType() {
		if (_idlType == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXTyped",
					"idlType");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_idlType = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue, CXType.class);
			}
		}
		return _idlType;
	}

	@Override
	public void setIdlType(CXType val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXTyped", "idlType", val.eObject());
	}

	@Override
	public java.util.List<CXBound> getBounds() {
		if (_bounds == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXField",
					"bounds");
			_bounds = new java.util.ArrayList<CXBound>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXBound nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							CXBound.class);
					_bounds.add(nextWrapper);
				}
			}
		}
		return _bounds;
	}

	@Override
	public void addBounds(CXBound val) {
		// make sure the bounds list is created
		getBounds();

		final Object rawValue = ZDLUtil.getValue(element, "CXDomain::IDL::CXField", "bounds");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_bounds != null) {
			_bounds.add(val);
		}
	}

	@Override
	public <T extends CXBound> T addBounds(Class<T> typeToCreate, String concept) {
		// make sure the bounds list is created
		getBounds();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXField", "bounds",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_bounds != null) {
			_bounds.add(element);
		}
		return element;
	}

	@Override
	public CXBound addBounds() {
		// make sure the bounds list is created
		getBounds();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXField", "bounds",
				"CXDomain::IDL::CXBound");
		CXBound element = ZDLFactoryRegistry.INSTANCE.create(newConcept, CXBound.class);
		if (_bounds != null) {
			_bounds.add(element);
		}
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
